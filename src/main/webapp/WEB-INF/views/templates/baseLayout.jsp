<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>

<html>
<head>
    <tiles:insertAttribute name="meta"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
	<tiles:insertAttribute name="menu"/>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>
</body>
</html>