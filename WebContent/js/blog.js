var table=null;

$(function(){
	table =  $('#blog_table_id').dataTable();
	getAllBlog();
});


function getAllBlog(){ 
	$.ajax({
		contentType : "application/json",
		processData : true,
		url : 'getBlog.html',
		type : "GET",
		dataType : "json",
		cache : false,
		async : true,	
		success : function(response){
			table.fnClearTable();
			$.each(response.data,function(index,row){
				addRow(row);
			});
		}
	});	
}

function addRow(row){
	//var str=(row.blogMeta).replace(/(<([^>]+)>)/ig,"").trunc(50);
	//var tgs='<div class="pop-div"><a href="javascript:void(0)" class="pop-div" data-html=true data-trigger="focus" data-toggle="popover" title="Description" data-content=\''+row.blogMeta+'\'></a></div>';
	table.fnAddData({
		"0":(row.title!=null && row.title!="null">0)?row.title:'N/A',
		"1":(row.date!=null &&row.date!="null">0)?row.date:'N/A',
		"2":(row.user!=null && row.user!="null">0)?row.user:'N/A',
		"3":(row.content!=null && row.content!="null">0)?row.content:'N/A',
		//"4":('<div class="pop-div"><a href="javascript:void(0)" class="pop-div" data-html=true data-trigger="focus" data-toggle="popover" title="Description" data-content=\''+row.blogMeta+'\'></a></div>'),		
		"4":(row.blogMeta!=null && row.blogMeta!="null">0)?row.blogMeta:'N/A',
		"5": "<input type='submit' value= 'edit'  class='edit btn btn-sm btn-primary' blogid='"+row.id+"'  title=\""+row.title+"\"" +
		" date=\""+row.date+"\"user=\""+row.user+"\"content=\""+row.content+"\"blogMeta=\""+row.blogMeta+"\">",
		"6": "<input type='submit' value= 'delete' class='delete btn btn-sm btn-danger'  blogid='"+row.id+"' name=\""+row.title+"\" />"
	});
}

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

$("body").on("click",".edit",function(){
	getCategory();
	$('#btnSaveUser').hide();
	$('#update_id').show();
	var id=$(this).attr("blogid");
	var blogedittitle=$(this).attr("title");
	var blogeditcat=$(this).attr("catid");
	var blogeditcontent=$(this).attr("content");
	
    $("#blog_id").val(id);
	$("#title").val(blogedittitle);
	$("#catId option[value='"+ blogeditcat +"']").attr("selected", "selected");
	//$("#").val();
	$("#content").val(blogeditcontent);

	$('#blog_modal').modal({backdrop:true});
});		
$("body").on("click","#btnSaveUser",function(){
	var id=$("#blog_id").val();
	var title=$("#title").val();
	//var date=$("#date").val();
	var content=$("#content").val();
	var catid=$("#catId").val();
	
	var blogObj={};
	blogObj.id=id;
	blogObj.title=title;
	blogObj.content=content;
	blogObj.catid=catid;
	
	//updateBlog(blogObj);
	saveBlog(blogObj);
	$('#blog_modal').modal("hide");
});
$("body").on("click","#update_id",function(){
	
		var id=$("#blog_id").val();
		var title=$("#title").val();
		//var date=$("#date").val();
		var content=$("#content").val();
		var catid=$("#catId").val();
		
		var blogObj={};
		if(id!="" || id!=null || id.length>0){
			blogObj.id=id;
		}
		blogObj.title=title;
		blogObj.content=content;
		blogObj.catid=catid;
		
		//updateBlog(blogObj);
		saveBlog(blogObj);
	
		
		$('#blog_modal').modal("hide");
});
	
function saveBlog(blogObj)
{
	$.ajax({
		contentType : "application/json",
		processData : true,
		url : 'addBlog.html',
		type : "POST",
		dataType : "json",
		cache : false,
		async : true,
		data : JSON.stringify(blogObj),
		success : function(response){
			if(response.status==1){
				getAllBlog();
			}else{
				alert("Blog not update or save. ");
			}
		}
	});	
}

$("body").on("click",".addnewblog",function(){
	$('#btnSaveUser').show();
	$('#update_id').hide();
	getCategory();
	$("#blog_id").val("");
	$("#title").val("");
	//$("#catId").val("");
	$("#content").val("");
	
	$('#btnSaveUser').val("save");
	$('#blog_modal').modal({backdrop:true});
});


$("body").on("click",".delete",function(){
	var blog_id=$(this).attr("blogid");
	$("#blog_id").val(blog_id);
	$('#delete_blog_modal').modal({backdrop:true});
});
$("body").on("click","#btndeleteblog",function(){
	var blog_id=$("#blog_id").val();
	deleteBlog(blog_id);
	$('#delete_blog_modal').modal("hide");
	
});

function deleteBlog(id) {
	$.ajax({
		contentType: "application/json",
		processData : true,
		data : {id : id},
		async : false,
		url : "deleteBlog.html",
		type : "GET",
		success : function(response) {
			if (response.status!=0)
			{
				window.location.reload(true);
			}
			else
				alert("error");
		},
		error : function(request, status, thrownError) {
		}
	});
}

