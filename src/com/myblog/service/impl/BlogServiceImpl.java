package com.myblog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.dao.BlogDao;
import com.myblog.domain.Blog;
import com.myblog.domain.Category;
import com.myblog.domain.Comment;
import com.myblog.domain.NewBlog;
import com.myblog.domain.User;
import com.myblog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	BlogDao blogDao;

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	@Transactional(readOnly = false)
	public Category addCategory(Category category) {
		return blogDao.addCategory(category);
	}

	@Override
	@Transactional(readOnly=false)
	public List<Category> getCategory() {

		return blogDao.getCategory();
	}

	@Override
	@Transactional(readOnly = false)
	public void updateCategory(Long id) {
		blogDao.updateCategory(id);

	}

	@Override
	@Transactional(readOnly = false)
	public String deleteCategory(Long id) {
		blogDao.deleteCategory(id);
		return "deleted successfully";
	}

	@Override
	@Transactional(readOnly = false)
	public Blog addBlog(Blog blog) {

		return blogDao.addBlog(blog);
	}

	@Override
	@Transactional(readOnly = false)
	public List<NewBlog> getBlog(NewBlog blog) {

		return blogDao.getBlog(blog);
	}

	@Override
	@Transactional(readOnly = false)
	public String deleteBlog(Long blogId) {

		blogDao.deleteBlog(blogId);
		return "deleted successfully";
	}

	

	@Override
	@Transactional(readOnly = false)
	public User findUserByusername(String username) {
		return blogDao.findUserByusername(username);
	}
   @Override
   @Transactional(readOnly = false)
	public NewBlog getBlogFromTitle(String title) {
		return blogDao.getBlogFromTitle(title);

	}

@Override
@Transactional(readOnly = false)
public Comment addComment(Comment comment) {
	blogDao.addComment(comment);
	return comment;
	
}

@Override
@Transactional(readOnly = false)
public User userRegistration(User user) {
	
	return blogDao.userRegistration(user);
}

@Override
@Transactional(readOnly = true)
public List<?> getUserComment() {
	
	return blogDao.getUserComment();
}

@Override
@Transactional(readOnly = false)
public List<User> getUser(User user) {
	return blogDao.getUser(user);
}

@Override
@Transactional(readOnly = false)
public boolean deleteUser(User id) {
	if(id!=null){
		blogDao.deleteUser(id);
		return true;
	}
	return false;
}

@Override
@Transactional(readOnly = false)
public void updateUser(User id) {
	blogDao.updateUser(id);
}

@Override
@Transactional(readOnly = false)
public NewBlog saveBlog(NewBlog newBlog) {
	return blogDao.saveBlog(newBlog);
}

}
