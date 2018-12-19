$(document).ready(function() {
	console.log("启动listCategory_ajax");
	listCategory_ajax();
});

function listCategory_ajax(){
	$.ajax({
		url : "/fleaMarketSystem/goodsType/goodsType_getTypeVO",		//数据传输的目的地址，将在这里对前台数据进行操作
		type : "post",
		processData: false,  
	    contentType: false,
		success : function(result) {
			console.log("YYYY"+result)
			var typeVO = JSON.parse(result); 
			var str=''
			var n='1'	
			for(i=0;i<typeVO.listTypeDTO.length;i++){
				for(j=0;j<typeVO.listTypeDTO[i].ListType.length;j++){
					str+='<tr>'+ 
					'<td style="text-align:center;"><input type="checkbox" name="item" lay-skin="primary" lay-filter="choose" value="'+typeVO.listTypeDTO[i].ListType[j].type_id+'"/></td>'+
					'<td style="text-align:center;">'+n+++'</td>'+
					'<td style="text-align:center;">'+typeVO.listTypeDTO[i].typeOne.typeOne_name+'</td>'+
					'<td style="text-align:center;">'+typeVO.listTypeDTO[i].ListType[j].type_name+'</td>'+
					'<td style="text-align:center;">'+
						'<a href="/fleaMarketSystem/skip/skip_intoCategoryEdit?data_id='+typeVO.listTypeDTO[i].ListType[j].type_id+'" class="layui-btn layui-btn-mini news_edit"  data_id="'+typeVO.listTypeDTO[i].ListType[j].type_id+'"><i class="layui-icon">&#xe642;</i> 编辑</a>'+
						'<a class="layui-btn layui-btn-danger layui-btn-mini news_del" onclick="category_delete(this)" data_id="'+typeVO.listTypeDTO[i].ListType[j].type_id+ '" ><i class="layui-icon">&#xe640;</i> 删除</a>'+
					'</td>'
						
				}
					
				str = str+'</tr>';
				$(".categoryli").html(str)
			}
		}
		})
	
}
layui.use('form', function(){
	var form = layui.form; 
	form.render();
});
//批量删除
function deleteMore(){
  //得到选中的值，ajax操作使用  
	layer.confirm('确定删除全部类型？',{icon:3, title:'提示信息'},function(index){
		var formData=new FormData();
		var ch=new Array();
		var obj = document.getElementsByName("item");
		console.log("obj.length"+obj.length)
		for(var i=0;i<obj.length;i++){
			if(obj[i].checked){
				ch[i]=obj[i].value
			}else{
				toastr.error("未指定类型!");
			}
		}
		var ch2=ch.join(",");	//加逗号大法好啊！！！
//		console.log( "ch2为===="+ch2);
//		console.log( "ch为===="+ch[0]+ch[1]+ch[2]);
		formData.append("idList", ch2);		//存到后台
		$.ajax({
			url:"/fleaMarketSystem/goodsType/goodsType_deleteType?idList="+ch2+"",
			type:"post",
			data :formData,
			//报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
			success:function(result){
				var rs=result;
//				console.log("result----==="+rs);
				if(rs=="deleteSuccess"){
					toastr.success("类型删除成功了哦!");
					setTimeout(function(){
						location.href="/fleaMarketSystem/skip/skip_intoCategoryList";
					},500);
				}else{
					toastr.error("删除失败!");
				}}
		});
      
	
		});
	}




//单个删除
function category_delete(object_i){
	layer.confirm('确定删除此类型？',{icon:3, title:'提示信息'},function(index){
		var ar=$(object_i).attr('data_id');//定义id
		var formData = new FormData;
		formData.append("idList", ar);
		//var arid=JSON.parse(ar);		//转换成json对象
		console.log("====arar==="+ar);
			$.ajax({
				url:"/fleaMarketSystem/goodsType/goodsType_deleteType?idList="+ar+"",
				type:"post",
				data :formData,
				//报错请加入以下三行，则ajax提交无问题
		        cache: false,  
		        processData: false,  
		        contentType: false,
				success:function(result){
					var rs=result;
					if(rs=="deleteSuccess"){
						toastr.success("文章删除成功了哦!");
						setTimeout(function(){
							location.href="/fleaMarketSystem/skip/skip_intoCategoryList";
						},1000);
					}else{
						toastr.error("删除失败33131!");
					}
//					
				}
			});
		})
}