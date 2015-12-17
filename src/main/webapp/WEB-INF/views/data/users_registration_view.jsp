<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>

<div class="container">
    <div class="top-space">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
            <h3 class="col-md-offset-3">Personal Information</h3>

                <c:if test="${not empty message}">
                    <div class="alert alert-${errorType}">${message}</div>
                </c:if>

            <form:form cssClass="form-horizontal" modelAttribute="user" method="POST" action="save">
                <div class="form-group">
                    <label class="col-lg-3 control-label">First Name:</label>

                    <div class="col-lg-8">
                        <form:input cssClass="form-control" placeholder="First Name"
                                    type="text" path="firstName"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Last Name:</label>

                    <div class="col-lg-8">
                        <form:input cssClass="form-control" placeholder="Last Name"
                                    type="text" path="LastName"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-lg-3 control-label">City:</label>

                    <div class="col-lg-8">
                        <form:input cssClass="form-control" placeholder="City" type="text"
                                    path="city"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Postal Code:</label>

                    <div class="col-lg-8">
                        <form:input cssClass="form-control" placeholder="Zip"
                                    type="text" path="zip"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Country:</label>

                    <div class="col-lg-8">
                        <form:input cssClass="form-control" placeholder="Country"
                                    type="text" path="country"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Email:</label>

                    <div class="col-lg-8">
                        <form:input cssClass="form-control" placeholder="Email"
                                    type="text" path="email"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label"></label>

                    <div class="col-md-8">
                        <input class="btn btn-custom" value="Save Changes" type="submit">
                        <span></span> <input class="btn btn-default" value="Cancel"
                                             type="reset">
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>
</div>