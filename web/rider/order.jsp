<%-- 
    Document   : home
    Created on : Mar 5, 2025, 4:17:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.html" %>
<div class="main">
    <h2>Order Accepted</h2>
    <%
        String orderId = request.getParameter("orderId");
    %>
    <p>You have accepted Order ID: <strong><%= orderId %></strong></p>
    <a href="home.jsp">Return Home</a>
</div>
<%@include file="include/footer.html" %>
