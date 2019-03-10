<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div class="container">
    <div class="row">
        <div class='col-md-4'></div>
        <div class="col-md-4">
            <div class="login-container">
                <div class="col-md-12" style="text-align: center;color: firebrick;margin-top: 15px;margin-bottom: 15px;">
                    <c:if test="${param.error == 'true'}">
                        <div>
                            Login Failed !
                        </div>
                        <div>
                            Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                        </div>
                    </c:if>
                </div>
                <legend><b>Sign In</b></legend>
                <form action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
                    <div class="form-group mymargin-top" align="left">
                        <label><b>Username</b></label>
                        <input id="username" placeholder="Ex : admin" type="text" name="username" class="form-control"/>
                    </div>
                    <div class="form-group" align="left">
                        <label><b>Password</b></label>
                        <input id="password" placeholder="Ex : xxxxxxx" name="password" type="password" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <td>Remember Me:</td>
                        <td><input type="checkbox" name="remember-me" /></td>
                    </div>
                    <div class="form-group mymargin-bottom" align="center">
                        <button class="btn btn-warning" id="btn-auth">Login</button>
                    </div>
                </form>
            </div>
        </div>
        <div class='col-md-4'></div>
    </div>
</div>