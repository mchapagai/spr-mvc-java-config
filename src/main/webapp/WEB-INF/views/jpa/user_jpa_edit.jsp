<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<div class="container">
	<div class="top-space">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h2 style="text-align: center;">
					<spring:message code="contact.form.title" />
				</h2>
				<hr>

				<c:if test="${not empty message}">
					<div class="alert alert-${errorType}">${message}</div>
				</c:if>

				<form:form class="form-horizontal" role="form" method="post"
					id="user" commandName="contact" action="${contactId}">
					<div class="form-group">
						<label for="firstname" class="col-sm-3 control-label"><spring:message code="contact.form.firstname" /></label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" id="firstname" path="firstname" placeholder="First Name" />
							<form:errors path="firstname" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-3 control-label"><spring:message code="contact.form.lastname" /></label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" id="lastname" path="lastname" placeholder="Last Name" />
							<form:errors path="lastname" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-3 control-label"><spring:message code="contact.form.email" /></label>
						<div class="col-sm-7">
							<form:input type="email" class="form-control" id="email" path="email" placeholder="Email" />
							<form:errors path="email" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="birthdate" class="col-sm-3 control-label"><spring:message code="contact.form.birthdate" /></label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" id="birthdate" path="birthdate" placeholder="birthdate" />
							<form:errors path="birthdate" cssClass="text-danger" />
						</div>
					</div>
					<div class="col-sm-3 col-md-offset-5">
						<button class="btn btn-primary btn-block" type="submit"><spring:message code="contact.form.button.edit" />
						</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>