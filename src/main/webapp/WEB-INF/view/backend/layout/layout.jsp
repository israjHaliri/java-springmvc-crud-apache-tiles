<%--
  User: Israj
  Date: 09/05/2015
  Time: 6:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="javascripts"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Pages</title>
    <link href="<c:url value="/resources/assets/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/assets/css/font-awesome.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/assets/css/backend/jquery.gritter.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/assets/css/backend/pace-theme-minimal.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/assets/css/backend/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/assets/css/backend/skins.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/assets/css/backend/custom_global.css" />" rel="stylesheet">
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
</head>
<body class="skin-dark">
<header class="header" id="#head-nav-backend">
  <span href="index.html" class="logo">
    <big>DASHBOARD</big>
  </span>
    <nav class="navbar navbar-static-top" role="navigation">
        <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="fa fa-bars fa-lg"></span>
        </a>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <li class="dropdown profile-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-cog fa-lg"></i>
                        <span class="username">Me</span>
                        <i class="caret"></i>
                    </a>
                    <ul class="dropdown-menu box profile">
                        <li>
                            <div class="up-arrow"></div>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-power-off"></i>Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <aside class="left-side sidebar-offcanvas">
        <section class="sidebar">
            <div class="user-panel">
                <div class="image" align="center">
                    <img src="/file/${photo}" class="img-circle"
                         alt="User Image" style="height:75px;width:75px;">
                </div>
                <div class="pull-left info" style="margin-top:15px;">
                    <p>Email : ${email}</p>
                    <span>Name : ${name} </span>
                </div>
            </div>
            <ul class="sidebar-menu">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/backend/dashboard">
                        <i class="fa fa-home"></i><span>Dashboard</span>
                    </a>
                </li>
                <li class="menu">
                    <a href="#">
                        <i class="fa fa-users"></i><span>User</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath}/backend/user/insert">New</a></li>
                        <li><a href="${pageContext.request.contextPath}/backend/user/">List</a></li>
                    </ul>
                </li>
                <li class="menu">
                    <a href="#">
                        <i class="fa fa-folder"></i><span>Content</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath}/backend/landing_page/insert">New</a></li>
                        <li><a href="${pageContext.request.contextPath}/backend/landing_page/">List</a></li>
                    </ul>
                </li>
            </ul>
        </section>
    </aside>
    <aside class="right-side">
        <section class="content">
            <div class="row">
                <div class="col-md-12" id="content_backend_ajax" style="margin-top:25px;">
                    <tiles:insertAttribute name="content" />
                </div>
            </div>
        </section>
    </aside>
</div>
</body>
<script src="<c:url value="/resources/assets/js/jquery-2.2.0.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/dataTables.bootstrap.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/pace.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/jquery.totemticker.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/jquery.ba-resize.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/jquery.blockUI.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/jquery.gritter.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/jquery.sparkline.min.js"/>"></script>
<script src="<c:url value="/resources/assets/js/backend/main.js"/>"></script>
<c:forEach var="script" items="${javascripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>
</html>