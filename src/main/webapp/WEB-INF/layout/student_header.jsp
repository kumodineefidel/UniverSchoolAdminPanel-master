<ul class="nav navbar-nav">
	<li id="homeActive" ><a href="${pageContext.request.contextPath}/student/home">Home</a></li>
	<li id="seeBlogsActive" ><a href="${pageContext.request.contextPath}/student/seeBlogs">Blogs</a></li>
	
</ul>
<script>
$(function(){
	 if("${homeActive}" == 'homeActive'){
		$("#homeActive").addClass("active");
	}else if("${seeBlogsActive}" == 'seeBlogsActive'){
		$("#seeBlogsActive").addClass("active");
	}
})
</script>