<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ssyvsse 菜谱网</title>

<link type="text/css" rel="stylesheet" href="/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx!}/assets/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<style>
	.cookBookDiv{
		padding:5px 40px;
		width:80%;
		min-height:250px;
		margin:5px 10px;
		border:1px solid #ccc;
	}
	.titleLeft{
		width:100%;
		text-align: center;
		font-size: 22px;
	}
	.imgRight{
		width:100%;
	}
	.imgCls{
		height:30%;
	}
</style>
</head>
<body>
	<#include "/header/header1.0.ftl">
<div class="container" >
<div class="row" >
	<div class="col-sm-6" >
	</div>
</div>
</div>
<script src="/js/jquery-1.9.1.min.js"></script>
<script src="/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<!-- Bootstrap table -->
<script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${ctx!}/assets/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
	$(function(){
		$.get("/cook/getHotest",function(data){
			if(data.code==0){
				$(".col-sm-6").empty();
				for(var i=0;i<data.data.length;i++){
					$(".col-sm-6")
					.append("<div class='cookBookDiv'>"
					+"<div class='titleLeft'><a href='/cook/cookBook?id="+data.data[i].id+"'>"
					+ data.data[i].title+"</a></div>"
					+"<div class='imgRight'>"
					+"<img src="+ data.data[i].album+" class='imgCls'>"+"</div>");
				}
			}			
		},"json");
	})

</script>

</body>
</html>