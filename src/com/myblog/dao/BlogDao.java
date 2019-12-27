package com.myblog.dao;

import java.util.List;

import com.myblog.domain.Blog;
import com.myblog.domain.Category;
import com.myblog.domain.Comment;
import com.myblog.domain.NewBlog;
import com.myblog.domain.User;

public interface BlogDao {

	public Category addCategory(Category categogry);
    public List<Category> getCategory();
    public String deleteCategory(Long id);
    public void updateCategory(Long id);
    public Blog addBlog(Blog blog);
    public List<NewBlog> getBlog(NewBlog blog);
    public String deleteBlog(Long blogId);
    public NewBlog getBlogFromTitle(String title);
	public User findUserByusername(String username);
	public Comment addComment(Comment comment);
	public User userRegistration(User user);
    List<?> getUserComment();
	public List<User> getUser(User user);
	public void updateUser(User id);
	public boolean deleteUser(User id);
	public NewBlog saveBlog(NewBlog newBlog);
	
}
