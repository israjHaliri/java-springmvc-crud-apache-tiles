<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div class="col-md-12" align="center">
    <c:choose>
        <c:when test="${not empty Message}">
            <p>${Message}</p>
        </c:when>
    </c:choose>
</div>
<div class="col-md-12">
<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/backend/user/edit" method="post">
    <div class="panel panel-default">
        <div class="panel-heading"><i class="fa fa-user"></i> User</div>
        <div class="panel-body">
            <div class="form-group" style="display: none">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" name="id" value="${list_data.id}">
            </div>
            <div class="form-group">
                <label for="username">Name:</label>
                <input type="text" class="form-control" id="username" name="username" value="${list_data.username}">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${list_data_profile.email}">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="">
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading"><i class="fa fa-list"></i> Profile</div>
        <div class="panel-body">
            <div class="form-group" style="display: none">
                <label for="id_profile">ID:</label>
                <input type="text" class="form-control" id="id_profile" name="id_profile" value="${list_data_profile.id}">
            </div>
            <div class="form-group">
                <label for="birthplace">Birth place:</label>
                <input type="text" class="form-control" id="birthplace" name="birthplace" value="${list_data_profile.birthplace}">
            </div>
            <div class="form-group">
                <label for="birthday">Birth day:</label>
                <input type="date" class="form-control" id="birthday" name="birthday" value="${list_data_profile.birthday}">
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" class="form-control" id="address" name="address" value="${list_data_profile.address}">
            </div>
            <div class="form-group">
                <label for="address">Phone:</label>
                <input type="number" class="form-control" id="phone" name="phone" value="${list_data_profile.phone}">
            </div>
            <div class="form-group">
                <label for="address">Photo:</label>
                <input type="file" class="form-control" id="photo" name="photo">
            </div>
        </div>
    </div>
    <div class="form-group">
        <input type="submit" value="simpan" class="btn btn-success">
    </div>
</form>
</div>