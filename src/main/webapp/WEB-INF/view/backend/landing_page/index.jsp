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

    <div class="col-md-12">
        <div class="row col-md-12" align="right">
            <form action="${pageContext.request.contextPath}/backend/landing_page" method="get" class="search-form">
                <div class="form-group has-feedback">
                    <label for="searchKeyword" class="sr-only">Search</label>
                    <input type="text" class="form-control" id="searchKeyword" name="searchKeyword"
                           placeholder="search">
                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                </div>
            </form>
        </div>
    </div>

    <div class="col-md-12">
        <table class="table table-bordered table-responsive" border="1">
            <thead>
            <tr>
                <th width="5%">No</th>
                <th>Title</th>
                <th>Subtitle</th>
                <th width="40%">Option</th>
            </tr>
            </thead>
            <c:choose>
                <c:when test="${not empty list_data}">
                    <tbody>
                    <c:forEach items="${list_data}" var="data" varStatus="loop">
                        <tr>
                            <td><c:out value="${loop.index+1}"/></td>
                            <td><c:out value="${data.title}"/></td>
                            <td><c:out value="${data.subtitle}"/></td>
                            <td align="center">
                                <a class="btn btn-success" href="${pageContext.request.contextPath}/backend/landing_page/edit/${data.id}"><i class="fa fa-edit"></i>  Edit</a>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/backend/landing_page/delete/${data.id}"><i class="fa fa-remove"></i> Delete</a>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/backend/file/${data.id}"><i class="fa fa-file-o"></i> Attachment</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:when>
                <c:otherwise>
                    <tbody>
                    <tr>
                        <td colspan="4" align="center">No Data</td>
                    </tr>
                    </tbody>
                </c:otherwise>
            </c:choose>
        </table>
        <div class="col-md-12" align="center">
            <c:if test="${endpage > 0}">
                <ul class="pagination">
                    <c:forEach begin="${startpage}" end="${endpage}" var="p">
                        <li><a href="${href}${p}">${p+1}</a></li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>
</div>






