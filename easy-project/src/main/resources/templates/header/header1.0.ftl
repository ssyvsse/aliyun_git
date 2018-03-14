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