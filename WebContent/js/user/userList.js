$(document).ready(function() {
	console.log("启动listUser_ajax");
	listUser_ajax();
});

function listUser_ajax(){
	$.ajax({
		url : "/fleaMarketSystem/loginRegister/loginRegister_getUserVO",		//数据传输的目的地址，将在这里对前台数据进行操作
		type : "post",
//		processData: false,  
//	    contentType: false,
		success : function(result) {
			console.log("YYYY"+result)
			var userVO = JSON.parse(result); 
			var str=''
			var n='1' 
			for(i=0;i<userVO.listUser.length;i++){
				var state = userVO.listUser[i].is_delete;
				console.log("KK"+state)
				var nickName = userVO.listUser[i].nickname
				if(state==1){
					state="已封禁"
					str+='<tr>'+ 
					'<td style="text-align:center;"><input type="checkbox" name="item" lay-skin="primary" lay-filter="choose" value="'+userVO.listUser[i].user_id+'"/></td>'+
					'<td style="text-align:center;">'+n+++'</td>'+
					'<td style="text-align:center;">'+nickName+'</td>'+
					'<td style="text-align:center;">'+userVO.listUser[i].username+'</td>'+
				    '<td style="text-align:center;">'+userVO.listUser[i].sex+'</td>'+
				    '<td style="text-align:center;">'+state+'</td>'+
					'<td style="text-align:center;">'+
						'<a class="layui-btn layui-btn layui-btn-mini " onclick="user_unDelete(this)" data_id="'+userVO.listUser[i].user_id+ '" ><i class="layui-icon">&#xe672;</i> 解封</a>'+
					'</td>'
						str = str+'</tr>';
						$(".categoryli").html(str)
				}else {
					state="正常"
						str+='<tr>'+ 
						'<td style="text-align:center;"><input type="checkbox" name="item" lay-skin="primary" lay-filter="choose" value="'+userVO.listUser[i].user_id+'"/></td>'+
						'<td style="text-align:center;">'+n+++'</td>'+
						'<td style="text-align:center;">'+userVO.listUser[i].nickname+'</td>'+
						'<td style="text-align:center;">'+userVO.listUser[i].username+'</td>'+
					    '<td style="text-align:center;">'+userVO.listUser[i].sex+'</td>'+
					    '<td style="text-align:center;">'+state+'</td>'+
						'<td style="text-align:center;">'+
							'<a class="layui-btn layui-btn-danger layui-btn-mini news_del" onclick="user_delete(this)" data_id="'+userVO.listUser[i].user_id+ '" ><i class="layui-icon">&#xe640;</i> 封禁</a>'+
						'</td>'
							str = str+'</tr>';
					$(".categoryli").html(str)
				}
					
				
				
			}
		}
		})
	
}
layui.use('form', function(){
	var form = layui.form; 
	form.render();
});
//批量封禁
function deleteMore(){
  //得到选中的值，ajax操作使用  
	layer.confirm('确定全部封禁？',{icon:3, title:'提示信息'},function(index){
		var formData=new FormData();
		var ch=new Array();
		var obj = document.getElementsByName("item");
//		console.log("obj.length"+obj)
		for(var i=0;i<obj.length;i++){
			if(obj[i].checked){
				ch[i]=obj[i].value
			}else{
				toastr.error("未指定用户!");
			}
		}
		var ch2=ch.join(",");	//加逗号大法好啊！！！
//		console.log( "ch2为===="+ch2);
//		console.log( "ch为===="+ch[0]+ch[1]+ch[2]);
		formData.append("idList", ch2);		//存到后台
		$.ajax({
			url:"/fleaMarketSystem/loginRegister/loginRegister_deleteUser?idList="+ch2+"",
			type:"post",
			data :formData,
			//报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
			success:function(result){
				var rs=result;
				console.log("result----==="+rs);
				if(rs="deleteSuccess"){
					toastr.success("全部封禁成功了哦!");
					setTimeout(function(){
						location.href="/fleaMarketSystem/skip/skip_intoUserList";
					},500);
				}else{
					toastr.error("封禁失败!");
				}}
		});
      
	
		});
	}

//批量解封
function unDeleteMore(){
  //得到选中的值，ajax操作使用  
	layer.confirm('确定全部解封？',{icon:3, title:'提示信息'},function(index){
		var formData=new FormData();
		var ch=new Array();
		var obj = document.getElementsByName("item");
//		console.log("obj.length"+obj)
		for(var i=0;i<obj.length;i++){
			if(obj[i].checked){
				ch[i]=obj[i].value
			}else{
				toastr.error("未指定用户!");
			}
		}
		var ch2=ch.join(",");	//加逗号大法好啊！！！
//		console.log( "ch2为===="+ch2);
//		console.log( "ch为===="+ch[0]+ch[1]+ch[2]);
		formData.append("idList", ch2);		//存到后台
		$.ajax({
			url:"/fleaMarketSystem/loginRegister/loginRegister_unDeleteUser?idList="+ch2+"",
			type:"post",
			data :formData,
			//报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
			success:function(result){
				var rs=result;
				console.log("result----==="+rs);
				if(rs="deleteSuccess"){
					toastr.success("全部解封成功了哦!");
					setTimeout(function(){
						location.href="/fleaMarketSystem/skip/skip_intoUserList";
					},500);
				}else{
					toastr.error("解封失败!");
				}}
		});
      
	
		});
	}
//全选
function allChoose(){
	var checkal=document.getElementById("allChoose");
	var checkbos=document.getElementsByName("item");
	for(i=0;i<checkbos.length;i++){
		var checkbo=checkbos[i];
		if(checkal.checked){
			checkbo.checked="checked";
		}else{
			checkbo.checked=null;
		}
	}	
	layui.use('form', function(){
		var form = layui.form; 
		form.render();
		});
}			


//单个封禁
function user_delete(object_i){
	layer.confirm('确定封禁此用户？',{icon:3, title:'提示信息'},function(index){
		var ar=$(object_i).attr('data_id');//定义id
		var formData = new FormData;
		formData.append("idList", ar);
		//var arid=JSON.parse(ar);		//转换成json对象
		console.log("====arar==="+ar);
			$.ajax({
				url:"/fleaMarketSystem/loginRegister/loginRegister_deleteUser?idList="+ar+"",
				type:"post",
				data :formData,
				//报错请加入以下三行，则ajax提交无问题
		        cache: false,  
		        processData: false,  
		        contentType: false,
				success:function(result){
					console.log("sdasd"+result)
					var rs=result;
					if(rs="deleteSuccess"){
						toastr.success("封禁成功了哦!");
						setTimeout(function(){
							location.href="/fleaMarketSystem/skip/skip_intoUserList";
						},500);
					}else{
						toastr.error("封禁失败!");
						setTimeout(function(){
							location.href="/fleaMarketSystem/skip/skip_intoUserList";
						},500);
					}
//					
				}
			});
		})
}

//单个解除封禁
function user_unDelete(object_i){
	layer.confirm('确定解封此用户？',{icon:3, title:'提示信息'},function(index){
		var ar=$(object_i).attr('data_id');//定义id
		var formData = new FormData;
		formData.append("idList", ar);
		//var arid=JSON.parse(ar);		//转换成json对象
		console.log("====arar==="+ar);
			$.ajax({
				url:"/fleaMarketSystem/loginRegister/loginRegister_unDeleteUser?idList="+ar+"",
				type:"post",
				data :formData,
				//报错请加入以下三行，则ajax提交无问题
		        cache: false,  
		        processData: false,  
		        contentType: false,
				success:function(result){
					console.log("sdasd"+result)
					var rs=result;
					if(rs="unDeleteSuccess"){
						toastr.success("解封成功了哦!");
						setTimeout(function(){
							location.href="/fleaMarketSystem/skip/skip_intoUserList";
						},500);
					}else{
						toastr.error("解封失败!");
						setTimeout(function(){
							location.href="/fleaMarketSystem/skip/skip_intoUserList";
						},500);
					}
//					
				}
			});
		})
}