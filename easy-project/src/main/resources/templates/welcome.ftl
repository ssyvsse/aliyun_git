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
		padding:0 50px;
		width:80%;
		margin:5px 10px;
		border:1px solid #ccc;
	}
	.titleLeft{
		float:left;
	}
	.imgRight{
	
	}
</style>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#example-navbar-collapse">
            <span class="sr-only">切换导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${navigation[0].url}">${navigation[0].name}</a>
    </div>
    <div class="collapse navbar-collapse" id="example-navbar-collapse">
        <ul class="nav navbar-nav">
        		<#list navigation as nav>
        				<#if nav.id==1 >
        					<#else>
        					<li><a href="${nav.url}">${nav.name}</a></li>
        				</#if>
        		</#list>
        </ul>
		
    </div>
    </div>
</nav>
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
				$(".col-sm-6").append("<ul>")
				for(var i=0;i<data.data.length;i++){
					$(".col-sm-6").append("<li><div class='cookBookDiv'><div class='titleLeft'><a href='/getCookBook'>"+data.data[i].title+"</a></div><div class='imgRight'><img src="+data.data[i].album+" >"+"</div></li>");
				}
				$(".col-sm-6").append("</ul>")
			}			
		},"json");
	})

</script>

</body>
</html>