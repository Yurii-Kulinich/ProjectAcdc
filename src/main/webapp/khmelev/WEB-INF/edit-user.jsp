<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<div class="container">
    <form class="form-horizontal" method="post"
          action="edit-user?id=${requestScope.user.id==null?0:requestScope.user.id}"
          enctype="multipart/form-data"
    >
        <fieldset>

            <!-- Form Name -->
            <legend>Edit user:</legend>

            <!-- File Button -->
            <div class="form-group">

                <label class="col-md-4 control-label" for="image">
                    <img id="previewId" src="images/${requestScope.user.image}" width="150"
                         alt="${requestScope.user.image}">
                    Нажмите чтобы изменить
                </label>
                <div class="col-md-4">
                    <input onchange="loadImageFile('image','previewId');" id="image" name="image"
                           style="visibility:hidden;"
                           class="input-file" type="file">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input
                            id="login"
                            name="login"
                            type="text"
                            value="${requestScope.user.login}"
                            placeholder="your login"
                            class="form-control input-md"
                            required="">
                    <span class="help-block">min 3 symbols</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password"
                           name="password"
                           type="password"
                           value="${requestScope.user.password}"
                           placeholder="your password"
                           class="form-control input-md"
                           required="">
                    <span class="help-block">min 8 symbols</span>
                </div>
            </div>


            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="role">Role</label>
                <div class="col-md-4">
                    <select id="role" name="role" class="form-control">
                        <c:forEach var="role" items="${applicationScope.roles}">
                            <option value="${role}" ${role==requestScope.user.role?"selected":""}>${role}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="createButton">Operation</label>
                <div class="col-md-8">
                    <c:if test="${requestScope.user==null}">
                        <button id="createButton" name="createButton" class="btn btn-success">Create</button>
                    </c:if>
                    <c:if test="${requestScope.user!=null}">
                        <button id="update" name="update" class="btn btn-primary">Update</button>
                    </c:if>
                </div>
            </div>

        </fieldset>
    </form>
</div>
<%@include file="parts/footer.jsp" %>


