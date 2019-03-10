<%--
  User: Israj
  Date: 09/05/2015
  Time: 6:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="javascripts"/>
<html>
<head>
    <title>My Network</title>
    <link href="<c:url value="/resources/assets/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/assets/css/font-awesome.css" />" rel="stylesheet">
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
</head>
<body background="/resources/assets/images/bc.jpg">
<tiles:insertAttribute name="content_front"/>
</body>
<script src="<c:url value="/resources/assets/js/jquery-2.2.0.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/bootstrap.js"/>"></script>
<c:forEach var="script" items="${javascripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>
</html>