package com.myblog.service;

import java.util.List;

import com.myblog.domain.Blog;
import com.myblog.domain.Category;
import com.myblog.domain.Comment;
import com.myblog.domain.NewBlog;
import com.myblog.domain.User;

public interface BlogService {
	public Category addCategory(Category category);

	public List<Category> getCategory();

	public void updateCategory(Long id);

	public String deleteCategory(Long id);

	// this function of blog
	public Blog addBlog(Blog blog);
	public List<NewBlog> getBlog(NewBlog blog);
	public String deleteBlog(Long id);
	public User findUserByusername(String username);
	public NewBlog getBlogFromTitle(String title);
	public Comment addComment(Comment comment);

	
	public List<?> getUserComment();
	//user funtion 
	public User userRegistration(User user);
	//public List<User> getUser1( User user);
	public boolean deleteUser( User id);
	public void updateUser(User id);

   public List<User> getUser(User user);
   public NewBlog saveBlog(NewBlog newBlog);
}
