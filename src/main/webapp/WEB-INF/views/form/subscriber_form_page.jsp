<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<div class="container">
	<div class="top-space">
		<div class="col-md-4 col-md-offset-3">
			<h2>Subscribe to The Newsletter!</h2>

			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success">${message}</div>
			</c:if>

			<div class="tab-content">
				<form:form modelAttribute="subscriber" method="post">
					<div class="form-group">
						<form:input class="form-control" placeholder="Full Name" type="text" path="name" />
					</div>

					<div class="form-group">
						<form:input class="form-control" placeholder="Email Address" type="text" path="email" />
					</div>

					<div class="form-group form-inline">
						<form:select cssClass="form-control" path="gender" id="genderOptions">
							<form:option value="">Select Gender please...</form:option>
							<c:forEach items="${genders}" var="gender">
								<form:option value="${gender}">${gender}</form:option>
							</c:forEach>
						</form:select>
					</div>

					<div class="form-group">
						<p>Would you like Newspaper subscription: Yes/No<br>If Yes, check the box below:</p>
						<form:checkbox cssClass="checkbox" path="receiveNewsletter" id="newsletterCheckbox" />
					</div>

					<div class="form-group form-inline">
						<form:select cssClass="form-control" path="newsletterFrequency" id="frequencySelect">
							<form:option value="">Select Newsletter Frequency</form:option>
							<c:forEach items="${frequencies}" var="frequency">
								<form:option value="${frequency}">${frequency}</form:option>
							</c:forEach>
						</form:select>
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(document).ready(function() {
		toggleFrequencySelectBox(); // show/hide box on page load
		$('#newsletterCheckbox').change(function() {
			toggleFrequencySelectBox();
		})
	});

	function toggleFrequencySelectBox() {
		if (!$('#newsletterCheckbox').is(':checked')) {
			$('#frequencySelect').val('');
			$('#frequencySelect').prop('disabled', true);
		} else {
			$('#frequencySelect').prop('disabled', false);
		}
	}
</script>