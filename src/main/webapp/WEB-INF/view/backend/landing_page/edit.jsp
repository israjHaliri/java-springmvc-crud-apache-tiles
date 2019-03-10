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
    <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/backend/landing_page/edit" method="post">
        <div class="panel panel-default">
            <div class="panel-heading"><i class="fa fa-list"></i> Content</div>
            <div class="panel-body">
                <div class="form-group" style="display: none">
                    <label for="id">ID:</label>
                    <input type="text" class="form-control" id="id" name="id" value="${list_data.id}">
                </div>
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title" name="title" value="${list_data.title}">
                </div>
                <div class="form-group">
                    <label for="subtitle">Subtitle:</label>
                    <input type="text" class="form-control" id="subtitle" name="subtitle" value="${list_data.subtitle}">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" cols="30" rows="10">${list_data.description}</textarea>
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" id="status" name="status">
                        <option <c:if test='${list_data.status == 1}'>selected</c:if> value="1">Active</option>
                        <option <c:if test='${list_data.status == 0}'>selected</c:if> value="0">Inactive</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="category">Category:</label>
                    <select class="form-control" id="category" name="category">
                        <option <c:if test='${list_data.status == 1}'>selected</c:if> value="1">Testimonial</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <input type="submit" value="simpan" class="btn btn-success">
        </div>
    </form>
</div>