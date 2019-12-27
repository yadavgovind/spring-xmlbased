<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta></meta>
<style type="text/css">
.filename {
    background-color:#E6E6FC;
    border: 1px solid #D1D1E8;
    padding: 8px 8px 8px 14px;
    border-bottom: none;
    margin-top:20px;
    color: #333;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;

    font-family: Consolas, Monaco, 'Andale Mono', monospace;
}
pre{ border-radius: 0px; !important}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${blog.title}</title>
 <script src="js/prettify.js"></script>
	 <link rel="stylesheet" href="css/prettify.css">
</head>
<body onload="prettyPrint()">

  <div class="row">

            <!-- Blog Post Content Column -->
            <div class="col-lg-8">

                <!-- Blog Post -->

                <!-- Title -->
                <h1>${blog.title}</h1>

                <!-- Author -->
                <p style="margin-bottom: 0px;">
                    By: Sandeep Sharma | ${blog.date}
                </p>
                <hr>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<code class="language-java">
${blog.blogMeta}
</code>
</meta>
           <%--      <!-- Preview Image -->
                <img class="img-responsive" src="http://placehold.it/900x300" alt="">

                <hr>
                <div class="filename">MyWebInitializer.java</div>
				<pre class="prettyprint">
				
				<code class="language-java">
package com.myblog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// Find the saved request
SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		if (savedRequest != null)
			request.getSession().setAttribute("redirectUrl",
					savedRequest.getRedirectUrl());

		request.getSession().setAttribute("remoteAddress",
				request.getRemoteAddr());
		response.sendRedirect("processlogin.html");
	}
}


</code>
				</pre> --%>
                <!-- Blog Comments -->

                <!-- Comments Form -->
                <div class="well">
                    <h4>Leave a Comment:</h4>
                     <form name="formcomment" id="formcomment" class="form-horizontal">  
                            <textarea class="form-control required" rows="3" id="comment_id"></textarea>
                     
                          Name:<input class="form-control required" type="text" name="name" id="comment_user">
                          Email:<input class="form-control required email" type="text" name="name" id="email_user">
                         <input type="hidden" value="${blog.blogId}" id="blog_id"/>
              </form>
   						<button type="button" class="btn btn-info"  style="margin-top: 10px;"  id="button_id">Submit</button> 
   						             </form>
                   
                </div>
	                  
                <hr>

                <!-- Posted Comments -->

                <!-- Comment -->
                <div class="media">
                    <div class="media-body">
                      <div id="blogcomments">
                      
                      
                      
                      
<!-- <div class="media">
<a class="pull-left" href="#">
    <img class="media-object" src="http://placehold.it/64x64" alt="">
</a>
<div class="media-body">
    <h4 class="media-heading">Start Bootstrap
        <small>August 25, 2014 at 9:30 PM</small>
    </h4>
    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
</div>
</div> -->


<!-- 
<div class="media">
<a class="pull-left" href="#">
    <img class="media-object" src="http://placehold.it/64x64" alt="">
</a>
<div class="media-body">
    <h4 class="media-heading">Start Bootstrap
        <small>August 25, 2014 at 9:30 PM</small>
    </h4>
    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
    Nested Comment
    <div class="media">
        <a class="pull-left" href="#">
            <img class="media-object" src="http://placehold.it/64x64" alt="">
        </a>
        <div class="media-body">
            <h4 class="media-heading">Nested Start Bootstrap
                <small>August 25, 2014 at 9:30 PM</small>
            </h4>
            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
        </div>
    </div>
    End Nested Comment
</div>
</div> -->
                      
                      </div>
                    </div>
                </div>
                <!-- Comment -->
                

            </div>

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-4">
                <!-- Blog Categories Well -->
                <div class="well">
                    <h4>Blog Categories</h4>
                    <div class="row">
                        <div class="col-lg-12">
                            <ul class="list-unstyled">
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>

                <!-- Side Widget Well -->
                <div class="well">
                    <h4>Side Widget Well</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
                </div>

            </div>

        </div>
        <!-- /.row -->
</body>
</html>