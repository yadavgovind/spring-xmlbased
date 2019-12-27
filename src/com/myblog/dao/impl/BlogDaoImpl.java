package com.myblog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.myblog.dao.BlogDao;
import com.myblog.domain.Blog;
import com.myblog.domain.Category;
import com.myblog.domain.Comment;
import com.myblog.domain.NewBlog;
import com.myblog.domain.User;


@Repository
public  class BlogDaoImpl implements BlogDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Category addCategory(Category category) {
		Category categoryObj=(Category) this.sessionFactory.getCurrentSession().merge(category);
		return categoryObj;
	}

	@Override
	public List<Category> getCategory() {
		@SuppressWarnings("unchecked")
		List<Category> categoryList=this.sessionFactory.getCurrentSession().createQuery("from Category").list();
		for(Category category1 : categoryList){
		System.out.println("result is "+category1.getId());
		System.out.println("name is"+category1.getName());

		}
		return categoryList;
	}

	@Override
	public String deleteCategory(Long id) {
		Category category=(Category)sessionFactory.getCurrentSession().load(Category.class, id);
		if(category!=null){
			sessionFactory.getCurrentSession().delete(category);	
		}
		else{
			System.out.println("any error will ouccre");
		}


		return "deleted successfully";
	}

	@Override
	public void updateCategory(Long id) {
		int x=this.sessionFactory.getCurrentSession().createQuery("update u.name from Category as u where u.id=?").executeUpdate();
System.out.println(x);
	}

	@Override
	public Blog addBlog(Blog blog) {
		blog = (Blog) this.sessionFactory.getCurrentSession().merge(blog);

		return blog;
	}

	@Override
	public List<NewBlog> getBlog(NewBlog blog) {
		@SuppressWarnings("unchecked")
		List<NewBlog> listBlog= this.sessionFactory.getCurrentSession().createQuery("from NewBlog ").list();
		
		return listBlog;
	}

	@Override
	public String deleteBlog(Long id) {
		Blog blog=	(Blog)this.sessionFactory.getCurrentSession().load(Blog.class, id);
		if(blog!=null){
			sessionFactory.getCurrentSession().delete(blog);
		}
		return "deleted successfully";
	}


	@Override
	public User findUserByusername(String username) {
		User usr = (User) this.sessionFactory.getCurrentSession().createQuery("from User where username = ?").setParameter(0, username).uniqueResult();

		return usr;
	}

	public NewBlog getBlogFromTitle(String title)
	{
		NewBlog blog = (NewBlog) this.sessionFactory
				.getCurrentSession()
				.createQuery("from NewBlog where  lower(replace(title,' ','-')) = lower(?)")
				.setParameter(0, title).uniqueResult();

		return blog;	

	}
	@Override
	public Comment addComment(Comment comment) {
		Comment comm= (Comment) this.sessionFactory.getCurrentSession().merge(comment);

		return comm;

	}

	@Override
	public User userRegistration(User user) {
		
User	usr= (User)this.sessionFactory.getCurrentSession().merge(user)	;
	 
		
		
		return usr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getUserComment() {
	List<?>	listcomment =this.sessionFactory.getCurrentSession().createSQLQuery("SELECT bc.comment_id commentId,bc.comment comment, bc.name name,bc.date date,bc.email_id emailId ,bc.blog_id bblogId FROM blog_comment bc order by bc.blog_id DESC LIMIT 5")
			.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
			.list();
			//.setMaxResults(1)
			
	//Comment last 5= (Comment) ((Query) listcomment).uniqueResult();
		return  listcomment;
	}

	@Override
	public List<User> getUser(User user) {
		@SuppressWarnings("unchecked")
		List<User> list= (List<User>) this.sessionFactory.getCurrentSession().createQuery("from User order by id DESC").list();
		return list;
	}

	@Override
	public void updateUser(User id) {
this.sessionFactory.getCurrentSession().createQuery("update  u.username, u.firstName, u.lastName, u.enabled,u.email,u.pic,u.aboutMe from User as u where .id=?").executeUpdate();	
	}

	@Override
	public boolean deleteUser(User id) {
	User usr=(User)this.sessionFactory.getCurrentSession().load(User.class, (Serializable) id);
		if(id!=null){
			this.sessionFactory.getCurrentSession().delete(usr);
		}
		return false;
	}

	@Override
	public NewBlog saveBlog(NewBlog newBlog) {
		return (NewBlog) this.sessionFactory.getCurrentSession().merge(newBlog);
	}




}


