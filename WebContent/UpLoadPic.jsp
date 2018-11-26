<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css"
	media="all" />	
</head>
<body>
	<form class="layui-form" style="width: 60%;">
		<div class="layui-inline">
			<label class="layui-form-label">商品类型</label>
			<div class="layui-input-block">
				<select name="production_info_type" id="selectTypes"
					class="userGrade" lay-filter="userGrade">
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">商品名</label>
			<div class="layui-input-block">
				<input type="text" name="goods_name" class="layui-input userName"
					lay-verify="required" placeholder="请输入商品名">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">价格</label>
			<div class="layui-input-block">
				<input type="text" name="goods_price" class="layui-input userEmail"
					lay-verify="email" placeholder="请输入价格">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商品描述</label>
			<div class="layui-input-block">
				<textarea id="goods_describe" name="goods_describe" placeholder="请输入作品描述"
					class="layui-textarea linksDesc"></textarea>
			</div>
		</div>
		<div class="layui-upload">
			<div class="layui-inline">
				 <button type="button" class="layui-btn layui-btn-normal" id="test1">
					<i class="layui-icon">&#xe67c;</i>上传图片
				</button> 
			</div>
			<table class="layui-table" id="pictrues">
				<thead>
					<tr>
						<th>顺序</th>
						<th>文件名</th>
						<th>大小</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="demoList"></tbody>
			</table>
			<div style="margin: auto; width: 250px">
				<input type="button" class="layui-btn" id="testListAction"
					onclick="isNull()" value="提交商品" />
				<button type="reset" class="layui-btn layui-btn-primary">重置信息</button>
			</div>
		</div>
	</form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery.1.8.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.plugin.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/toastr.js"></script>
	<script>
//筛选类型
var typeId = null;
   $(document).ready(function(){
	//获取分类信息
	getTypeInfo();
	
});
 
   
 //得到当前登陆的用户
   function getuser(){
   	$.ajax({
   		async : false,
   		type : 'POST',
   		url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
   		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
   		processData : false, // 不序列化data
   		contentType : false,
   		success : function(result) {
   			alert("yu3212"+result)
   			console.log("5555566666"+result)
   			var sessin = JSON.parse(result)
   		}
   	})
   	
   }
   
   
   //定义键值对象
function ObjData(key,value){
	this.Key=key;
	this.Value=value;
   }
	//添加作品
function saveGoodsInfo(){
		 var array=[];
		var table = document.getElementById("pictrues");
		var ROW = table.rows.length;
		//遍历表格
		for(var i=1;i<ROW;i++){
			console.log(table.rows[i].cells[0].innerHTML)
			var value= table.rows[i].cells[0].innerHTML;//将表格设置为值
			console.log(table.rows[i].cells[1].innerHTML)
			var key=table.rows[i].cells[1].innerHTML;//将文件名定义为键
			var s = new ObjData(key,value);
			array.push(s);
		}
		var pushData = JSON.stringify(array);//将数组转为json字符串
		var formData = new FormData();
		//放入商品信息
		formData.append("goodsInfo.goods_name",$("input[name='goods_name']").val());
		formData.append("goodsInfo.goods_price",$("input[name='goods_price']").val());
		formData.append("goodsInfo.goods_describe",$("textarea[name='goods_describe']").val());
// 		 formData.append("goodsInfo.goods_type",userId);
		formData.append("goodsInfo.goods_type",typeId); 
		formData.append("pictrueMap",pushData);
		$.ajax({
			type:'POST',
			data:formData,
			url:'/fleaMarketSystem/carouselManager/carouselManager_addAndComplete',
			cache: false,
		    processData: false,
		    contentType: false,
		    success:function(result){
		    	var addResult = JSON.parse(result);
		    	if(addResult=="success"){
					toastr.success("作品添加成功!");
					/* setTimeout(function(){
						location.href="http://";
					},1000); */
				}/* else{
					toastr.error("作品添加失败!");
				} */
		    }
		})
	}
	//获取选择的分类
	layui.use('form', function(){
		var form = layui.form; 
		form.render('select');
		form.on('select(userGrade)',function (data) {
		    typeId = data.value;
		});
	});
	//放入类型信息
	function getTypeInfo() {
		$.ajax({
			type:'POST',
			url:'/fleaMarketSystem/goodsInfoManager/goodsInfoManager_queryGoodsManagerDTO',
			cache: false,  
		    processData: false,  
		    contentType: false,
		    success:function(result){
		    	var listGoodsManagerDTO = JSON.parse(result);
		    	putType(listGoodsManagerDTO);
		    }
		})
	}
	//查询分类下拉菜单
	function putType(listGoodsManagerDTO){
		var strStart = '<option value=""></option>';
		var str="";
		var typeNames= document.querySelector("#selectTypes");// 定位放入的位置
		var length = listGoodsManagerDTO.length;
		//遍历对象
		for(var i=0;i<length;i++){
			var typeId=listGoodsManagerDTO[i].type.type_id;//类型id
			var typeName=listGoodsManagerDTO[i].type.type_name;//类别名称
			str+='<option value="'+typeId+'">'+typeName+'</option>';
		}
		var strAll = strStart+str;
		typeNames.innerHTML=strAll;// 插入标签
		//layui再次渲染
		layui.use('form', function(){
			var form = layui.form; 
			form.render();
		});
	}
	//判断表单按钮是否为空!$("input[name='sex1']").checked&&!$("input[name='sex2']").checked
	function isNull(){
		var table = document.getElementById("pictrues");
		var ROW = table.rows.length;
		if($("input[name='goods_name']").val()==""||$("input[name='goods_name']").val()==null){
			toastr.error("请填写商品名!");
		}else if($("input[name='goods_price']").val()==""||$("input[name='goods_price']").val()==null){
			toastr.error("请填写价格!");
		}else if(typeId==null||typeId==""){
			toastr.error("请选择作品类型!");
		}else if($("#goods_describe").val()==null||$("#goods_describe").val()==""){
			toastr.error("请填写作品描述!");
		}else if(ROW<=1){
			toastr.error("请上传作品图片!");
		} 
	}
//图片上传
var i = 1;
var belongId = '';
layui.use('upload', function(){
  var upload = layui.upload;
  var demoListView = $('#demoList')
  //执行实例
   ,uploadListIns = upload.render({
    elem: '#test1' //绑定元素
    ,url: '/fleaMarketSystem/carouselManager/carouselManager_uploadAndSavePic' //上传接口
    ,accept: 'images'
    ,data:{'picture.picture_belong':belongId}
    ,bindAction: '#testListAction' //指向一个按钮触发上传
    ,multiple: true
    ,auto: false 
    ,choose: function(obj){
    var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
    //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
    obj.preview(function(index, file, result){
      console.log(index); //得到文件索引
      console.log(file); //得到文件对象
      console.log(result); //得到文件base64编码，比如图片
      var tr = $(['<tr id="upload-'+ index +'">'
      	,'<td>'+ (i++) +'</td>'
        ,'<td>'+ file.name +'</td>'
        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
        ,'<td>等待上传</td>'
        ,'<td>'
          ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
          ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
        ,'</td>'
      ,'</tr>'].join(''));
      //单个重传
      tr.find('.demo-reload').on('click', function(){
    	  obj.upload(index, file);
      });
      
      //删除
      tr.find('.demo-delete').on('click', function(){
        delete files[index]; //删除对应的文件
        tr.remove();
        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
      });
      
      demoListView.append(tr);
    });
    }
    ,before: function(obj){
    	if($("input[name='goods_name']").val()==""||$("input[name='goods_name']").val()==null){
			toastr.error("请填写商品名!");
		}else if($("input[name='goods_price']").val()==""||$("input[name='goods_price']").val()==null){
			toastr.error("请填写价格!");
		}else if(typeId==null||typeId==""){
			toastr.error("请选择作品类型!");
		}else if($("#goods_describe").val()==null||$("#goods_describe").val()==""){
			toastr.error("请填写作品描述!");
			throw SyntaxError();
		}
    }
    ,done: function(res, index, upload){
	   /*  console.log("res===="+res); */
	      if(res.code == 0){ //上传成功
	        var tr = demoListView.find('tr#upload-'+ index)
	        ,tds = tr.children();
	        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
	        tds.eq(3).html(''); //清空操作
	        return delete this.files[index]; //删除文件队列已经上传成功的文件
	      }
	      this.error(index, upload);
	    }
	    ,error: function(index, upload){
	      var tr = demoListView.find('tr#upload-'+ index)
	      ,tds = tr.children();
	      tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
	      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
	    }
	    ,allDone: function(obj){ //当文件全部被提交后，才触发
	    	console.log(obj.total); //得到总文件数
	        console.log(obj.successful); //请求成功的文件数
	        console.log(obj.aborted); //请求失败的文件数
	        //如果文件全部上传成功，执行作品添加操作
	    	if(obj.total==obj.successful){
	    		saveGoodsInfo();
	    	}
	    }
  });
})
</script>
</body>
</html>