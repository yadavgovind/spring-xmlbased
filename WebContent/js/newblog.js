$(function(){ 
	getCategory();
$('.summernote').summernote({
        height: 150,
        toolbar: [
                   
                  ['style', ['bold', 'italic', 'underline', 'clear']],
                  ['fontsize', ['fontsize']],
                  ['color', ['color']],
                  ['para', ['ul', 'ol', 'paragraph']],
                  ['height', ['height']],
                ]
    });

$('#newblog_formID').validate_popover({onsubmit: false, popoverPosition: 'right'});
});

function savenewblog(newBlog)
{
	 $.ajax({
		 	contentType : "application/json",
			processData : false,
			data:JSON.stringify(newBlog),
			async : false,
			url : "saveBlog.html",
			type : "POST",
			dataType: "json",
		    cache: false,
		    async:false,
			success : function(response) { 
				if(response.status==1){
				//	toastr.success("new blog added successfully.");
				}
				else{
					//toastr.error(response.message);
				}
			},
			
		 });
}


getCategory();
$("body").on("click", "#savenewblogid", function(e) {
	 getCategory();
	if($('#newblog_formID').validate().form()){
	         var newBlog={};
	         newBlog.title = $("#titleId").val();
	         newBlog.content= $("#contentId").val();
	        
	         newBlog.categoryId= $("#categoryId").val();
	         newBlog.blogMeta= $("#metatagId").code();
		
		 
savenewblog(newBlog);
	}	 
});
    

function getCategory(){
	$.ajax({
		contentType: "application/json",
		processData : true,
		async : false,
		url : "getCategory.html",
		type : "GET",
		success : function(response) {
			if (response.status!=0)
			{
				$("#catId").empty();
				$.each(response.data,function(index,value){
					$("#catId").append('<option value = '+value.id+'>'+value.name+'</option>');
				});
			}
			else
				alert("error");
		},
		error : function(request, status, thrownError) {
		}
	});
}
  
    
$(document).on("click", '.close-btn', function(e) {
	$.validator.hide_validate_popover($("#categoryId, #titleId, #metatagId, #contentId"));
});
