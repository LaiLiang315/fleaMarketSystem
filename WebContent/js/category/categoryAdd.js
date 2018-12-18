$(document).ready(function() {
	//得到一级分类
	getTypeOne()
});
//得到一级分类
function getTypeOne(){
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/goodsType/goodsType_getTypeDTO',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		processData : false, // 不序列化data
		contentType : false,
		success : function(result) {
			console.log("d"+result)
			var listTypeDTO = JSON.parse(result)
			console.log("d"+listTypeDTO)
			var strStart = '<option value=""></option>';
			var str ='<select name="type1" id="selectTypes"	class="userGrade" lay-filter="userGrade">';
			for(i=0;i<listTypeDTO.length;i++){
				console.log("d"+listTypeDTO[i].typeOne.typeOne_name)
				str =str+strStart+ '<option>'+listTypeDTO[i].typeOne.typeOne_name+'</option>'
				
			}
			str = str +'</select>'
			$("#typeOne").html(str)
		}
	})
}
//添加类型
$("#addCategory").on("click",function(){
	var dd = $("input[type='radio']:checked").val()
	console.log("sd"+dd)
	var type1 = $("input[name='goods_type_title']").val()
	if(type1 ==""){
		toastr.error("请填入类型名称");
		return false
	}
	
	if(dd ==1){
		alert("1")
		$.ajax({
			type : 'POST',
			data:{"typeOne.typeOne_name":type1},
			url :"/fleaMarketSystem/goodsType/goodsType_addTypeOne",
			success : function(result) {
				if(result="success"){
					toastr.success("添加一级类型成功");	
					setTimeout(function(){
						location.href="/fleaMarketSystem/skip/skip_intoCategoryAdd";
					},1000);
				}
				}
		
			})
		
	}
	if(dd ==2){
		alert("2")
		var ff =$("select[name='type1']").val() 
		console.log("gg1111111"+ff)
		if(ff ==""){
			toastr.error("请选择一级类型");
			return false
		}
		console.log("ff111111111"+type1)
		$.ajax({
			type : 'POST',
			data:{"newType.type_name":type1,"typeOne.typeOne_name":ff},
			url :"/fleaMarketSystem/goodsType/goodsType_addType",
			cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
			success : function(result) {
				if(result="addSuccess"){
					toastr.success("添加二级类型成功");	
					setTimeout(function(){
						location.href="/fleaMarketSystem/skip/skip_intoCategoryAdd";
					},1000);
					
				}
				
				}
		
			})
	}
	
})
	
	
