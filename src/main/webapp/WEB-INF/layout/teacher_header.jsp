<ul class="nav navbar-nav">
	<li id="homeActive" ><a href="${pageContext.request.contextPath}/Teacher/home">Home</a></li>
	<li id="schoolsActive" ><a href="${pageContext.request.contextPath}/Teacher/ChildList">ChildList</a></li>
	<li id="AddBlogActive" ><a href="${pageContext.request.contextPath}/Teacher/AddBlog">AddBlog</a></li>
</ul>
<script>
$(function(){
	if("${childProgressActive}" == 'childProgressActive'){
		$("#childProgressActive").addClass("active");
	}else if("${homeActive}" == 'homeActive'){
		$("#homeActive").addClass("active");
	}else if("${AddBlogActive}" == 'AddBlogActive'){
		$("#AddBlogActive").addClass("active");
	}
})
</script>