package com.myblog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.myblog.domain.AjaxResponse;
import com.myblog.domain.Blog;
import com.myblog.domain.Category;
import com.myblog.domain.NewBlog;
import com.myblog.domain.User;
import com.myblog.service.BlogService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired(required=true)
	BlogService blogService;
	@RequestMapping(value="/processlogin",method=RequestMethod.GET )
	public String processlogin(HttpServletRequest req){
		return "adminhome";
	}
	@RequestMapping(value="/category",method=RequestMethod.GET )
	public String category(HttpServletRequest req){
		return "category";
	}
	@RequestMapping(value="/addCategory",method=RequestMethod.POST )
	public @ResponseBody  AjaxResponse addCategory(@RequestBody Category category){
		AjaxResponse rd = new AjaxResponse();
		category =  blogService.addCategory(category);
		rd.setData(category);
		rd.setStatus(AjaxResponse.SUCCESS);
	
		return rd;
	}
	@RequestMapping(value="/getCategory",method=RequestMethod.GET)

	public @ResponseBody AjaxResponse getCategory(){

		AjaxResponse rd = new AjaxResponse();
		List<Category> list=null;
		list = blogService.getCategory();
		rd.setStatus(AjaxResponse.SUCCESS);
		rd.setData(list);

		return rd;

	}
	@RequestMapping(value="/deleteCategory",method=RequestMethod.GET)
	public @ResponseBody AjaxResponse deleteCategory(Long id,HttpServletRequest request, Model model) {
		System.out.println("in delete ");
		AjaxResponse rd = new AjaxResponse();
		try{

			rd.setStatus(AjaxResponse.SUCCESS);
			blogService.deleteCategory(id);
		}
		catch(Exception er){
			rd.setStatus(AjaxResponse.ERROR);
		}
		return rd;
	}
	@RequestMapping(value="/updateCategory",method=RequestMethod.GET)
	public @ResponseBody 
	AjaxResponse updateCategory(Long id,HttpServletRequest request,Model model){


		AjaxResponse res=new AjaxResponse();
		try{

			res.setStatus(AjaxResponse.SUCCESS);
			blogService.updateCategory(id);
		}
		catch(Exception e){
			res.setStatus(AjaxResponse.ERROR);
		}
		return res;
	}
	@RequestMapping(value="/blog",method=RequestMethod.GET )
	public String blog(HttpServletRequest req){
		System.out.println("blog defining");
		return "blog";	
	}
	@RequestMapping("/newblog")
	public String newblog()
	{
		System.out.println("home pringt");
		return "newblog";
	}
	@RequestMapping(value="/user",method=RequestMethod.GET )
	public String user(HttpServletRequest req){
		System.out.println("user defining");
		return "user";	
	}
	@RequestMapping(value="/addBlog",method=RequestMethod.POST )
	public @ResponseBody  AjaxResponse addBlog(@RequestBody Blog blog,HttpServletRequest request){
		AjaxResponse rd = new AjaxResponse();
		try {
			org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println("In addBlog method username: "+usr.getUsername());
			User currentUser = blogService.findUserByusername(usr.getUsername());
			blog.setUser(currentUser.getId());
			blog.setDate(new Date());
			blog =  blogService.addBlog(blog);
			rd.setData(blog);
			System.out.println("========================================================"+blog.getTitle());
			rd.setStatus(AjaxResponse.SUCCESS);
		} catch (Exception e) {
			rd.setStatus(AjaxResponse.ERROR);
			e.printStackTrace();
		}
		return rd;
	}
	@RequestMapping(value="/getBlog",method=RequestMethod.GET )
	public @ResponseBody AjaxResponse getBlog(NewBlog blog){
		AjaxResponse rd = new AjaxResponse();
		List<NewBlog> list=null;
		list = blogService.getBlog(blog);
		rd.setStatus(AjaxResponse.SUCCESS);
		rd.setData(list);
		
		return rd;
	}
	@RequestMapping(value="/deleteBlog",method=RequestMethod.GET)
	public @ResponseBody AjaxResponse deleteBlog(Long blogId,HttpServletRequest request, Model model) {
		System.out.println("in delete ");
		AjaxResponse rd = new AjaxResponse();
		try{
			rd.setStatus(AjaxResponse.SUCCESS);
			blogService.deleteBlog(blogId);
		}
		catch(Exception er){
			er.printStackTrace();
			rd.setStatus(AjaxResponse.ERROR);
		}
		return rd;		
	}
	
	@RequestMapping(value="/userRegistration" ,method=RequestMethod.GET)
	public @ResponseBody AjaxResponse userRegistration(@RequestBody User user){
		AjaxResponse rd=new AjaxResponse();
		user=blogService.userRegistration(user);
		//user.setDateOfBirth( Date dateOfBirth);
		rd.setData(user);
		rd.setStatus(AjaxResponse.SUCCESS);
		//user=blogService.userRegistration(user);
		System.out.println("--------------------------------------------------------"+user.getEmail());
		return rd;

	}
	

@RequestMapping(value="/getUser",method=RequestMethod.GET)
public @ResponseBody AjaxResponse getUser(User user){
	
	AjaxResponse rd=new AjaxResponse();
	List<User> usr=null;
	usr=blogService.getUser(user);
	rd.setData(usr);
	rd.setStatus(AjaxResponse.SUCCESS);
	return rd;

	
}
@RequestMapping(value="/saveBlog",method=RequestMethod.POST )
public @ResponseBody  AjaxResponse saveBlog(@RequestBody NewBlog newBlog,HttpServletRequest request){
	AjaxResponse rd = new AjaxResponse();
	try {
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("In addBlog method username: "+usr.getUsername());
		User currentUser = blogService.findUserByusername(usr.getUsername());
		newBlog.setUserId(currentUser.getId());
		newBlog.setDate(new Date());
		newBlog =  blogService.saveBlog(newBlog);
		rd.setData(newBlog);
		System.out.println("========================================================"+newBlog.getTitle());
		rd.setStatus(AjaxResponse.SUCCESS);
	} catch (Exception e) {
		rd.setStatus(AjaxResponse.ERROR);
		e.printStackTrace();
	}
	return rd;
}
}
