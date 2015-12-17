<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<div class="container">
	<div class="top-space">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">

				<div class="col-md-2">
					<a href="<c:url value='/jpa/add' />" class="btn btn-custom" role="button" style="margin-top: 15px;">
					<spring:message code="contact.list.button" /> &raquo;</a>
				</div>
				<c:if test="${not empty message}">
					<div class="col-md-3">
						<div class="alert alert-${errorType}">${message}</div>
					</div>
				</c:if>

				<div class="bs-example">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th><spring:message code="contact.grid.fullname" /></th>
								<th><spring:message code="contact.grid.email" /></th>
								<th><spring:message code="contact.grid.birthdate" /></th>
								<th><spring:message code="contact.grid.edit" /></th>
								<th><spring:message code="contact.grid.delete" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user">
								<tr>
									<td>${user.id}</td>
									<td><a href="<c:url value='/jpa/edit/${user.id}' />">${user.firstname} ${user.lastname}</a></td>
									<td>${user.email}
									<td>${user.birthdate}</td>
									<td><a href="<c:url value='/jpa/edit/${user.id}'/>" class="fa fa-pencil fa-fw"></a></td>
									<td><a href="<c:url value='/jpa/delete/${user.id}'/>" class="fa fa-trash fa-fw" onclick="return confirm('Are you sure?');"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>