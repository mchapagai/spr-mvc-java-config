<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<style type="text/css">
.error_color {
	color: #FF0000;
	font: Arial, Helvetica, sans-serif;
}
</style>
<div class="container">

	<div class="row">
		<div class="span12 jumbotron">
			<div class="hero-unit center">
				<h1>
					<spring:message code="404.page.title" />
					<p class="error_color">Error 404</p>
				</h1>
				<br />
				<p>
					<spring:message code="404.not.found" />
				</p>
				<a href="${pageContext.request.contextPath}"
					class="btn btn-large btn-info"><i class="icon-home icon-white"></i>
					<spring:message code="404.button" /> </a>
			</div>
		</div>
	</div>

</div>