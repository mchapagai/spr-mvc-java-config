<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>

<div class="navbar navbar-fixed-top alt">
    <div class="container">
        <div class="navbar-header">
            <a href="<c:url value='/'/>" class="navbar-brand"><spring:message code="main.title"/></a>

            <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
        </div>

        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav pull-right">
                <li><a href="${pageContext.request.contextPath}/users"><spring:message code="users.list"/></a></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">PROJECT NAVIGATION</a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/users/dropdown">User Dropdown</a></li>
                        <li><a href="${pageContext.request.contextPath}/users/json">User JSON Response</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">FILE UPLOAD</li>
                        <li><a href="${pageContext.request.contextPath}/upload">Uploads</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">FILE UPLOAD</li>
                        <li><a href="${pageContext.request.contextPath}/upload">Uploads</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">HIBERNATE</li>
                        <li><a href="${pageContext.request.contextPath}/jpa">Hibernate List</a></li>
                        <li><a href="${pageContext.request.contextPath}/jpa/add">Hibernate Add</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value="#"/>">Login</a></li>
                <li><a href="${pageContext.request.contextPath}/about"><spring:message code="users.about"/></a></li>
            </ul>
        </div>
    </div>
</div>