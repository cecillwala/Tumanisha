<%-- 
    Document   : home
    Created on : Mar 4, 2025, 11:46:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.html" %>
<div class="main">
     <h2>Welcome, Rider!</h2>
    <%
        // Retrieve a simulated order assignment from session
        String order = (String) session.getAttribute("order");
        if(order == null) {
    %>
        <!-- No order assigned: show "Open to Work" button -->
        <form action="homejsp" method= "post">
            <input type="hidden" name="action" value="open">
            <input type="submit" value="Open to Work">
        </form>
    <%
        } else {
    %>
        <!-- Order assigned: display order details and "Accept Order" button -->
        <h3>New Order Assigned:</h3>
        <p><strong>Order Details:</strong> <%= order %></p>
        <form action="homejsp" method="post">
            <input type="hidden" name="action" value="accept">
            <input type="submit" value="Accept Order">
        </form>
    <%
        }
    %>
</div>
<%@include file="include/header.html" %>