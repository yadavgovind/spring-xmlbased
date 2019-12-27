var table = null;

$(function(){

	$("#catadd").click(function(){
		var catName=$("#catName").val();
		if(catName=="")
		{
			alert("Please input a category name");
			return;
		}
		var catObj = {};
		catObj.name = catName;
		saveCategory(catObj);
	});
	table =  $('#category').dataTable();
	getAllCategory();
});
function getAllCategory(){ 
	$.ajax({
		contentType : "application/json",
		processData : true,
		url : 'getCategory.html',
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
	});	}
function addRow(value){
	table.fnAddData({
		"0" : value.name,
		"1": "<input type='submit' value= 'edit'  class='edit btn btn-sm btn-primary' catid='"+value.id+"'  name=\""+value.name+"\" >",
		"2": "<input type='submit' value= 'delete' class='delete btn btn-sm btn-danger'  catid='"+value.id+"' name=\""+value.name+"\" />"
	});
}
$("body").on("click",".edit",function(){
	$("#category_modal").modal({backdrop:true});
var id=$(this).attr("catid");
	var categoryName=$(this).attr("name");
	$("#edit_catName").val(categoryName);
	$("#cat_id").val(id);
});
$("body").on("click","#editable_catName",function(){
	var id=$("#cat_id").val();
	var cateditname=$("#edit_catName").val();
	$('#category_modal').modal("hide");
	if(cateditname==""||cateditname==null)
	{
		alert("Please input a category name");
		return;
	}
	var catObj = {};
	catObj.id = id;
	catObj.name = cateditname;
	saveCategory(catObj);

});
function updateCategory(id){
	$.ajax({
		contentType: "application/json",
		processData : true,
		data : {
			id : id
		},
		async : false,
		url : "updateCategory.html",
		type : "GET",
		success : function(response) {

			if (response.status!=0)
			{
				//window.location.reload(true);
			}

		},
		error : function(request, status, thrownError) {

		}
	});
}
$("body").on("click",".delete",function(){
	var id=$(this).attr("catid");
	$("#delete_category_modal").modal({backdrop:true});
$("body").on("click","#btndeletecategory",function(){
	deleteCategory(id);
	$("#id").val(id);
	$('#delete_category_modal').modal("hide");
});
});
/*$("body").on("click",".delete",function(){
	var id=$(this).attr("catid");


	var r=confirm("do u really want to delete");
	if(r)
	{
		deleteCategory(id);
		$("#id").val(id);
	}
});*/
function deleteCategory(id) {
	$.ajax({
		contentType: "application/json",
		processData : true,
		data : {
			id : id
		},
		async : false,
		url : "deleteCategory.html",
		type : "GET",
		success : function(response) {

			if (response.status!=0)
			{
				//alert("success");
				window.location.reload(true);
			}
			//else
				//alert("error");
		},
		error : function(request, status, thrownError) {
		}
	});
}

function saveCategory(catObj)
{
	$.ajax({
		contentType : "application/json",
		processData : true,
		url : 'addCategory.html',
		type : "POST",
		dataType : "json",
		cache : false,
		async : true,
		data : JSON.stringify(catObj),
		success : function(response){
			//alert("you are successfully submitted");
			getAllCategory();
		}
	});	}

