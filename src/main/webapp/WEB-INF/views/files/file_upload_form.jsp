<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/views/templates/meta.jsp" />
</head>
<body>
<c:import url="/WEB-INF/views/templates/menu.jsp" />
<div class="container">
    <div class="top-space">
	<div class="row">
		<h3 style="text-align: center">
			<spring:message code="upload.title.heading" />
		</h3>

		<form:form modelAttribute="fileUploadBean" action="save" method="POST"
			enctype="multipart/form-data">

			<label for="uploadFile">File Upload</label>
			<input type="file" id="uploadFile" name="files[0]">


			<label for="uploadFileAnother">Another File Upload</label>
			<input type="file" id="uploadFileAnother" name="files[1]">

			<input id="addFile" type="button" value="Add Another File" />
			<button type="submit">Upload</button>
		</form:form>
	</div>

	</div></div>
	<script>
		$(document).ready(function() {
			$('#addFile').click(function() {
				var fileIndex = $('#fileTable tr').children().length - 1;
				$('#fileTable').append('<tr><td>'
						+ '	<input type="file" name="files[' + fileIndex + ']" />'
						+ '</td></tr>');
				});
			});
	</script>
</body>
</html>