<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
body {
  background-color:#fff;
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
}

.container {
    padding: 25px;
    position: fixed;
}

.form-login {
    background-color: #EDEDED;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    box-shadow:0 1px 0 #cfcfcf;
}

h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}

.wrapper {
    text-align: center;
}

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
           <form class="form-login" method="post" id="login_form" name="login_form"  action="<c:url value='j_spring_security_check'/>">
           <fieldset class="col-sm-12">
             <div class="form-group">
               <div class="controls row">
                 <div class="input-group col-sm-12">
                   <input type="text" class="form-control" id="j_username" name="j_username" onChange="javascript:this.value=this.value.toLowerCase();" placeholder="Username" />
                   <span class="input-group-addon ToolTipCss"><i class="fa fa-user"></i></span> </div>
               </div>
             </div>
             <div class="form-group">
               <div class="controls row">
                 <div class="input-group col-sm-12">
                   <input type="password" class="form-control" id="j_password" name="j_password" placeholder="Password" />
                   <span class="input-group-addon ToolTipCss"><i class="fa fa-key"></i></span> </div>
               </div>
             </div>
             <div class="confirm">
               <input type="checkbox" name="remember_me" id="remember_me"/>
               <label for="remember">Remember me </label>
             </div>
             <div class="row">
               <button type="submit" id="login-btn" class="btn btn-lg btn-primary col-xs-12">Login</button>
             </div>
           </fieldset>
         </form>
        </div>
    </div>
</div>


</body>

</html>