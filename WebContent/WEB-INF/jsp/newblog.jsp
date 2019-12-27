<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New  Blog</h1>


<div class="modal-body">
	<table align="center">
	<tr>
	<td>
	<div class="row">
       <form class="form-horizontal" id="newblog_formID" name="cash-rewards-edit-form">
         <div class="col-lg-8 pull-left">
           <div class="form-group">
             <label for="category" class="col-md-3 no-padding">Category   :</label>
              <div class="col-md-12 pl0">
				   <select id="catId"   class="form-control required">
				</select>
					</div>
           </div>
         </div>
         <div class="col-lg-8 pull-left">
           <div class="form-group">
             <label for="hf-email" class="col-md-3 no-padding">Title   :</label>
             <div class="col-md-12 pl0">
               <input type="text" name="title" id="titleId" class="form-control required  " />
             </div>
           </div>
           
         </div>
         
          <div class="col-lg-8 pull-left">
            <div class="form-group mb0">
              <label for="metatag">Meta Tag  :</label>             
            </div>
          </div>
         <div class="col-lg-12 pull-left">
            <div class="form-group">
                <textarea  name="metatag" id="metatagId" cols="45" rows="5" class="form-control summernote  required"></textarea>
            </div>
          </div>
          <div class="col-lg-8 pull-left">
            <div class="form-group mb0">
              <label for="content">Content  :</label>             
            </div>
          </div>
         <div class="col-lg-12 pull-left">
            <div class="form-group">
                <textarea  name="content" id="contentId" cols=45 rows="5" class="form-control  required"></textarea>
            </div>
          </div>
     	<button class="btn close-btn pull-left" data-dismiss="modal" aria-hidden="true">Reset</button>
        <button id="savenewblogid" type="button" class="btn btn-primary pull-left">Save</button>
       </form>
     </div>
	</td>
	</tr>
	</table>
  </div>
  
  
</body>
</html>