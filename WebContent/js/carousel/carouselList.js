$(document).ready(function() {
	console.log("启动listCarousel_ajax");
	listCarousel_ajax();
});

function listCarousel_ajax(){
	$.ajax({
		url : "/fleaMarketSystem/carouselManager/carouselManager_getCarouselVO",//数据传输的目的地址，将在这里对前台数据进行操作
		type : "post",
		success : function(result) {
			console.log("YYYY"+result)
			var carouselVO = JSON.parse(result); 
//			console.log("YYddsdasdYY"+typeVO.listCarousel.length)
			var str=''
			var n='1'	
			for(i=0;i<carouselVO.listCarousel.length;i++){
					str+='<tr>'+ 
					'<td style="text-align:center;"><input type="checkbox" name="item" lay-skin="primary" lay-filter="choose" value="'+carouselVO.listCarousel[i].carousel_id+'"/></td>'+
					'<td style="text-align:center;">'+n+++'</td>'+
					'<td style="text-align:center;">'+carouselVO.listCarousel[i].carousel_name+'</td>'+
					'<td style="text-align:center;">'+carouselVO.listCarousel[i].carousel_sequence+'</td>'+
					'<td style="text-align:center;">'+
					'<a href="/fleaMarketSystem/skip/skip_intoCarouselAdd?data_id='+carouselVO.listCarousel[i].carousel_id+'" class="layui-btn layui-btn-mini news_edit"  data_id="'+carouselVO.listCarousel[i].carousel_id+'"><i class="layui-icon">&#xe642;</i> 编辑</a>'+
						'<a class="layui-btn layui-btn-danger layui-btn-mini news_del" onclick="carousel_delete(this)" data_id="'+carouselVO.listCarousel[i].carousel_id+ '" ><i class="layui-icon">&#xe640;</i> 删除</a>'+
					'</td>'
						
					
				str = str+'</tr>';
				$(".categoryli").html(str)
			}
		}
		})
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