<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ssyvsse 菜谱网</title>

<link type="text/css" rel="stylesheet" href="/js/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx!}/assets/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<style>
	.stepCls{
		width:90%
		padding:2px 10px;
	}

</style>
</head>
<body>
	<#include "/header/header1.0.ftl">
<div class="container" >
<div class="row" >
	<div class="col-sm-6" >
		<h1>${cookBook.title}</h1>
		<img src="${cookBook.album}" >
		<p id="box" >&nbsp;&nbsp;&nbsp;&nbsp;${cookBook.imtro}</p>
		<hr>
		<em>烹调原料</em>
		<p>${cookBook.ingredients}</p>
		<em>佐料</em>
		<p>${cookBook.burden}</p>
		<em>步骤</em>
		<ul style="list-style:none;" >
			<#list cookBook.cookSteps as step>
				<li>
					<div class='stepCls' >
						<img src="${step.img}">
						<p>${step.step}</p>
					</div>
				</li>
			</#list>
		</ul>
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
	function show(){
		var box = document.getElementById("box");
		var text = box.innerHTML;
		var newBox = document.createElement("div");
		var btn = document.createElement("a");
		newBox.innerHTML = text.substring(0,85);
		btn.innerHTML = text.length > 85 ? "...显示全部" : "";
		btn.href = "###";
		btn.onclick = function(){
			if (btn.innerHTML == "...显示全部"){
				btn.innerHTML = "收起";
				newBox.innerHTML = text;
			}else{
				btn.innerHTML = "...显示全部";
				newBox.innerHTML = text.substring(0,85);
			}
		}
		box.innerHTML = "";
		box.appendChild(newBox);
		box.appendChild(btn);
	}
show();
</script>

</body>
</html>