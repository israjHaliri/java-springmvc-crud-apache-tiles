<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div class="col-md-12" style=" min-height: 200px;top: 30%">
    <div class="col-md-3"></div>
    <div class="col-sm-6">
        <div class="tile-progress tile-aqua">
            <div class="tile-header">
                <h3>Dear Visitors</h3>
                <span>We are sorry because we still working it.</span>
            </div>
            <div class="tile-progressbar">
                <span data-fill="22%" style="width: 60%;"></span>
            </div>
            <div class="tile-footer">
                <h4>
                    <span class="pct-counter">22</span>% increase
                </h4>
                <span>so far in our blog and our website, if you need something pelase contact us in <a class="btn btn-warning" href="${pageContext.request.contextPath}/contact_us"><i class="fa fa-envelope"></i>&nbsp;here</a></span>
                <div align="center">
                <span><a class="btn btn-warning" href="${pageContext.request.contextPath}/sign_up"><i class="fa fa-user-plus"></i>&nbsp;Register</a></span>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-3"></div>
</div>

