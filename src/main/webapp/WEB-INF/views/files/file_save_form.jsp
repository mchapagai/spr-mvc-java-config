<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/views/templates/meta.jsp" />
</head>
<body>
	<c:import url="/WEB-INF/views/template/menu.jsp" />
	<div class="container">
        <div class="top-space">
		<h2>The Big Picture!</h2>
		<div class="row">
			<p>
				<spring:message code="upload.save.message" />
			</p>
			<ul>
				<c:forEach items="${files}" var="file">
					<li>${file}</li>
				</c:forEach>
			</ul>
		</div>

		<c:import url="/WEB-INF/views/templates/footer.jsp" />
	</div></div>
</body>
</html>