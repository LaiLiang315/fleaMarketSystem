//筛选类型
var typeId = null;
var myArray=new Array();
//当前登陆的用户
var user = null;
$(document).ready(function() {
	// 获取分类信息
	getTypeInfo();
	//获取当前登陆的用户
	getuser()
	if(!user || typeof(user) =="undefined" || user == null){
		toastr.error("非法登陆，正在退出");
		setTimeout(function(){
			window.location.href = "/fleaMarketSystem/skip/skip_intoIndex";
		},1000);
	}
});
// 得到当前登陆的用户
function getuser() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		dataType:"text",
		success : function(result) {
			var jsonData = JSON.parse(result);
			user = jsonData.session.attributes.user_session;
		}
	})
}
// 定义键值对象
function ObjData(key, value) {
	this.Key = key;
	this.Value = value;
}
// 添加作品
function saveGoodsInfo() {
	var ROW = $(".uploaded").length;
	var pushData = myArray;// 将数组转为json字符串
	var formData = new FormData();
	// 放入商品信息
	formData.append("goodsInfo.goods_name", $("input[name='goods_name']").val());
	formData.append("goodsInfo.goods_price", $("input[name='goods_price']").val());
	formData.append("goodsInfo.goods_describe", $("textarea[name='goods_describe']").val());
	 formData.append("goodsInfo.goods_belong",user.user_id);
	formData.append("goodsInfo.goods_type", typeId);
	formData.append("goodsInfo.exchange_ways",$("input[type='radio']:checked").val());
	formData.append("goodsInfo.exchange_adress", $("input[name='exchange_adress']").val())
	formData.append("goodsInfo.user_qq", $("input[name='user_qq']").val())
	formData.append("goodsInfo.user_weixin", $("input[name='user_weixin']").val())
    // console.log("CCCC"+$("input[name='goods_name']").val())
	formData.append("pictrueMap", pushData);
	console.log("XXX:"+pushData)
	$
			.ajax({
				type : 'POST',
				data : formData,
				url : '/fleaMarketSystem/carouselManager/carouselManager_addAndComplete',
				cache : false,
				processData : false,
				contentType : false,
				success : function(result) {
					var addResult = result;
					if (addResult == "success") {
						toastr.success("作品添加成功!");
						/*
						 * setTimeout(function(){ location.href="http://";
						 * },1000);
						 */
					}/*
						 * else{ toastr.error("作品添加失败!"); }
						 */
				}
			})
}
// 获取选择的分类
layui.use('form', function() {
	var form = layui.form;
	form.render('select');
	form.on('select(userGrade)', function(data) {
		typeId = data.value;
	});
});
// 放入类型信息
function getTypeInfo() {
	$
			.ajax({
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_queryGoodsManagerDTO',
				cache : false,
				processData : false,
				contentType : false,
				success : function(result) {
					var listGoodsManagerDTO = JSON.parse(result);
					putType(listGoodsManagerDTO);
				}
			})
}
// 查询分类下拉菜单
function putType(listGoodsManagerDTO) {
	var strStart = '<option value=""></option>';
	var str = "";
	var typeNames = document.querySelector("#selectTypes");// 定位放入的位置
	var length = listGoodsManagerDTO.length;
	// 遍历对象
	for (var i = 0; i < length; i++) {
		var typeId = listGoodsManagerDTO[i].type.type_id;// 类型id
		var typeName = listGoodsManagerDTO[i].type.type_name;// 类别名称
		str += '<option value="' + typeId + '">' + typeName + '</option>';
	}
	var strAll = strStart + str;
	typeNames.innerHTML = strAll;// 插入标签
	// layui再次渲染
	layui.use('form', function() {
		var form = layui.form;
		form.render();
	});
}
// 图片上传
var i = 1;
var belongId = '';
layui
		.use(
				'upload',
				function() {
					var upload = layui.upload;
					// 执行实例
					var uploadInst = upload
							.render({
								elem : '#test1' // 绑定元素
								,
								url : '/fleaMarketSystem/carouselManager/carouselManager_uploadAndSavePic' // 上传接口
								,
								accept : 'images',
								data : {
									'picture.picture_belong' : belongId
								},
								bindAction : '#testListAction' // 指向一个按钮触发上传
								,
								multiple : true,
								auto : false,
								choose : function(obj) {
									var files = this.files = obj.pushFile(); // 将每次选择的文件追加到文件队列
									// 预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
									
									obj.preview(function(index, file,result) {
												console.log()
												console.log("1:" + index); // 得到文件索引
												console.log("2:" + file.name); // 得到文件对象
												console.log("3:" + result); // 得到文件base64编码，比如图片
												var str = '<div class="uploaded"style="float:left">'
														+ '<img class="good-image" src="'+ result+ '" />'
														+ '<i class="layui-icon-delete" data-src="" onClick="deleteImage(this);">'
														+ '</i>' + '</div>'
												$("#test2").prepend(str);
												// console.log("4rrrr:"+$(".uploaded").length)
											});
								},
								before : function(obj) {
									console.log("ooo")
									if ($("input[name='goods_name']").val() == ""
											|| $("input[name='goods_name']")
													.val() == null) {
										toastr.error("请填写商品名!");
										return false;
									} else if ($("#goods_describe").val() == null
											|| $("#goods_describe").val() == "") {
										toastr.error("请填写作品描述!");
										return false;
										// throw SyntaxError();
									} else if (typeId == null || typeId == "") {
										toastr.error("请选择作品类型!");
										return false;
									} else if ($("input[name='goods_price']")
											.val() == ""
											|| $("input[name='goods_price']")
													.val() == null) {
										toastr.error("请填写价格!");
										return false;
									}else if ($("input[name='exchange_adress']")
											.val() == ""
												|| $("input[name='exchange_adress']")
														.val() == null) {
											toastr.error("请填写交易地址!");
											return false;
										}
								},
								done : function(res, index, upload) {
									console.log("res====" + res.code);
									if (res.code == 0) { // 上传成功
//										List<String>
//										for(var id:jsonData){
//											pidName.push(id);
//										}
										myArray.push(res.picId)
										
										toastr.info("上传成功")
									}else{
										this.error(index, upload);
									}
									
								},
								error : function(index, upload) {
									alert("2")
									toastr.error("上传失败")
									
								},
								allDone : function(obj) { // 当文件全部被提交后，才触发
									console.log("qqq" + obj.total); // 得到总文件数
									console.log("aaa" + obj.successful); // 请求成功的文件数
									console.log("zzz" + obj.aborted); // 请求失败的文件数
									// 如果文件全部上传成功，执行作品添加操作
									if (obj.total == obj.successful) {
										saveGoodsInfo();
									}
								}
							});
				})
//删除图片
function deleteImage(e) {

}

//点击图标回到首页
$(".brand").on("click",function(){
	location.href="/fleaMarketSystem/skip/skip_intoIndex";
	
})

