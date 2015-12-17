<%@ include file="/WEB-INF/views/includes/taglibs.jsp" %>


<div class="container">
    <div class="top-space">
        <div class="row">

            <div class="col-md-6 col-md-offset-3">
                <c:if test="${not empty message}">
                    <div class="message green">${message}</div>
                </c:if>


                <form:form cssClass="form-horizontal" role="form" modelAttribute="user">
                    <div class="form-group">
                        <label class="col-lg-3 control-label">First Name:</label>
                        <div class="col-lg-8">
                            <form:input cssClass="form-control" placeholder="First Name" type="text" path="firstName"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">Last Name:</label>
                        <div class="col-lg-8">
                            <form:input cssClass="form-control" placeholder="Last Name" type="text" path="lastName"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">City:</label>
                        <div class="col-lg-8">
                            <div class="ui-select">
                                <form:select cssClass="form-control" path="city">
                                    <form:option value="none" label=" city "/>
                                    <form:options items="${map.userCity}"/>
                                </form:select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">Zip:</label>
                        <div class="col-lg-8">
                            <div class="ui-select">
                                <form:select cssClass="form-control" path="zip">
                                    <form:option value="none" label="zip"/>
                                    <form:options items="${map.userZip}"/>
                                </form:select>
                            </div>
                        </div>
                    </div>

                    <%--
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Country:</label>
                        <div class="col-lg-8">
                            <div class="ui-select">
                                <form:select cssClass="form-control" path="country">
                                    <form:option value="none" label="country"/>
                                    <form:options items="${map.userCountry}"/>
                                </form:select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">Email:</label>
                        <div class="col-lg-8">
                            <div class="ui-select">
                                <form:select cssClass="form-control" path="email">
                                    <form:option value="none" label="email"/>
                                    <form:options items="${map.userEmail}"/>
                                </form:select>
                            </div>
                        </div>
                    </div>
                    --%>

                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-8">
                            <input class="btn btn-custom" value="Save Changes" type="submit">
                            <span></span> <input class="btn btn-default" value="Cancel" type="reset">
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>