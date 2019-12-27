var table=null;
$(function(){
	getComments();
	$('#formcomment').validate_popover({onsubmit: false, popoverPosition: 'right'});
	  $(window).resize(function() {
			$.validator.reposition();
	});

});

function saveComment(commentObj)
 {
	
	
	 $.ajax({
	 	contentType : "application/json",
		processData : false,
		data:JSON.stringify(commentObj),
		async : false,
		url : "addComment.html",
		type : "POST",
		dataType: "json",
	    cache: false,
		success : function(response) { 
			if(response.status==1){
				//getComments();
				toastr.success("comment successfully saved.");
				clear();
			}else{
				toastr.error("please check comment");
					
			}
		}
		});
	 }
		
function clear(){
	
	$("#comment_id").val("");
	$("#comment_user").val("");
	$("#email_user").val("");
	
	
}

function getComments()
{
	$("#blogcomments").html("");
	$.ajax({
		contentType : "application/json",
		processData : true,
		url : 'getusercomment.html',
		type : "GET",
		dataType : "json",
		cache : false,
		async : true,
		success : function(response){
			if(response.status==1){
				$('#blogcomments').val("");
				$.each(response.data,function(index,row){
					
					
					 addcomment(row);
				});
				
			}
		}
	});	
}

function addcomment(row){
	
	html=                     
		'<div class="media">'+
	'<a class="pull-left" href="#">'+
	'    <img class="media-object" src="http://placehold.it/64x64" alt="">'+
'	</a>'+
	'<div class="media-body">'+
	 '   <h4 class="media-heading">Start Bootstrap'+
	     '   <small>'+ moment( row.date).format("DD-MMM-YYYY hh:mm a")+'</small>  Posted By  '+row.name+''+
	 '   </h4>'+
	  '  '+row.comment+'  '+
	'</div>'+
	'</div>';
	
	
	$("#blogcomments").append(html);

	
	
	
	
}
$("body").on("click","#button_id",function(){
	if($('#formcomment').validate().form()){	
	var commentUserName=$("#comment_user").val();
	var blogId=$("#blog_id").val();
	var comment=$("#comment_id").val();
	var comentEmail=$("#email_user").val();
	var commentObj = {};
	commentObj.user = commentUserName;
	commentObj.blogId=blogId;
	commentObj.comment=comment;
	commentObj.emailId=comentEmail;
	saveComment(commentObj);
	clear();
	getComments();
	}
});



