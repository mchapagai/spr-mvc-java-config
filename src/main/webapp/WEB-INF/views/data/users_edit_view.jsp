<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>


<div class="container">
    <div class="top-space">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">

                <form:form class="form-horizontal" role="form" method="post" id="user" modelAttribute="user" action="${userId}">
                    <div class="form-group">
                        <label for="firstName" class="col-sm-3 control-label">First Name</label>
                        <div class="col-sm-7">
                            <form:input type="text" class="form-control" id="firstName" path="firstName" placeholder="First Name"/>
                            <form:errors path="firstName" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                        <div class="col-sm-7">
                            <form:input type="text" class="form-control" id="lastName" path="lastName" placeholder="Last Name"/>
                            <form:errors path="lastName" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label">Email</label>
                        <div class="col-sm-7">
                            <form:input type="email" class="form-control" id="email" path="email" placeholder="Email"/>
                            <form:errors path="email" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="country" class="col-sm-3 control-label">Country</label>
                        <div class="col-sm-7">
                            <form:input type="country" class="form-control" id="country" path="country" placeholder="country"/>
                            <form:errors path="country" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="zip" class="col-sm-3 control-label">zip</label>
                        <div class="col-sm-7">
                            <form:input type="zip" class="form-control" id="zip" path="zip" placeholder="zip"/>
                            <form:errors path="zip" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="city" class="col-sm-3 control-label">city</label>
                        <div class="col-sm-7">
                            <form:input type="city" class="form-control" id="city" path="city" placeholder="city"/>
                            <form:errors path="zip" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="col-sm-3 col-md-offset-5">
                        <button class="btn btn-primary btn-block" type="submit">SAVE</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>