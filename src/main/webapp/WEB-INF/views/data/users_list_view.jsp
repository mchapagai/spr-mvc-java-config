<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>

<div class="container">
    <div class="top-space">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">

                <div class="col-md-2">
                    <a href="<c:url value='/users/registration' />" class="btn btn-custom" role="button" style="margin-top: 15px;"><spring:message code="users.label.new"/> &raquo;</a>
                </div>

                <c:if test="${not empty message}">
                    <div class="col-md-3">
                        <div class="alert alert-${errorType}">${message}</div>
                    </div>
                </c:if>

                <div class="bs-example">
                    <table class="table table-striped">
                        <thead>
                        <tr><th>#</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Zip</th>
                        <th>Country</th>
                        <th>Email</th>
                        <th>Edit</th>
                        <th>Delete</th></tr>
                        </thead>

                        <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.id}</td>
                                <td><a href="<c:url value='/users/edit/${user.id}' />">${user.lastName},${user.firstName}</a></td>
                                <td>${user.city}</td>
                                <td>${user.zip}</td>
                                <td>${user.country}</td>
                                <td>${user.email}</td>
                                <td>
                               <a href="${pageContext.request.contextPath}/users/edit/${user.id}" class="fa fa-pencil fa-fw"></a></td>
                                <td><a href="${pageContext.request.contextPath}/users/delete/${user.id}" class="fa fa-trash fa-fw" onclick="return confirm('Are you sure?');"></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>