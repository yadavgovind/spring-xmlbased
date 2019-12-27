package com.myblog.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.domain.AjaxResponse;
import com.myblog.domain.Blog;
import com.myblog.domain.Comment;
import com.myblog.domain.NewBlog;
import com.myblog.service.BlogService;

@Controller

public class BlogController {
	@Autowired(required=true)
	BlogService blogService;
	
	
	
	@RequestMapping("/{title}")
	public String openBlog(@PathVariable String title,ModelMap map)
	{
		
		NewBlog blog=blogService.getBlogFromTitle(title);
		map.addAttribute("blog", blog);
		return "disblog";
	}
	@RequestMapping(value="/addComment" , method=RequestMethod.POST)
	public @ResponseBody AjaxResponse addComment(@RequestBody Comment comment){
		AjaxResponse rd=new AjaxResponse();
 
	      comment.setDate(new Date());
	      Comment  commet =  blogService.addComment(comment);
		  rd.setData(commet);
		rd.setStatus(AjaxResponse.SUCCESS);
		rd.setMessage("SUCCESS comment");
		
	   return rd;
	}
	@RequestMapping(value="/getusercomment",method=RequestMethod.GET )
	public @ResponseBody AjaxResponse getUserComment(){
		AjaxResponse rd= new AjaxResponse();
		try{
			List<?> comment=blogService.getUserComment();
			rd.setData(comment);
			rd.setStatus(AjaxResponse.SUCCESS);
			rd.setMessage("SUCCESS");
			
		}catch(Exception e){
			e.printStackTrace();
			rd.setMessage("ERROR IN COMMENT");
			rd.setStatus(AjaxResponse.ERROR);
		}
		return rd;
	
	}
}