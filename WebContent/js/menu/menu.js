//筛选类型
var typeId = null
 $(document).ready(function(){
	//获取分类信息
	getTypeInfo();
});
//获取分类信息
function getTypeInfo(){
	$.ajax({
	async:false, 
	type:'POST',
    url:'/fleaMarketSystem/goodsType/goodsType_getListGoodsTypeDTO',
    /*data:{"typeOne.TypeOne_id":$("typeOne.TypeOne_name")},*/
	cache: false,  //cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
	processData: false, //不序列化data
	contentType: false,
	success:function(result){
	var listGoodsTypeDTO = JSON.parse(result)
	putType(listGoodsTypeDTO)
   }
 })
};
//查询分类下拉菜单
function putType(listGoodsTypeDTO){
	var length = listGoodsTypeDTO.length;
	var strStart ='<ul>';
	var str = '<li>';
	for(i=0;i<length;i++){
		
		strStart = strStart + '<li>'+listGoodsTypeDTO[i].typeOne.typeOne_name + '<ul>'
		console.log(strStart)
		
		for(j=0;j<listGoodsTypeDTO[i].listType.length;j++){
			console.log(listGoodsTypeDTO[i].listType.length)
			strStart = '<li>'+listGoodsTypeDTO[i].listType[j].type_name+'</li>'
		}
		strStart = strStart +'</ul>' + '</li>'
		console.log("GG"+strStart)
	}
	strStart = strStart + '</ul>'
	console.log("f:"+strStart)
	document.querySelector("#sideManu").innerHTML = strStart;
}