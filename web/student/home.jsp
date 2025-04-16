<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="Query.Cafeteria" %>
<%@page import="Query.User" %>
<%@include file="include/header.html" %>

<div class="main">
    
    <%
        User student = (User) request.getAttribute("user");
        if (student != null) {
    %>
        <h3>Welcome, <%= student.firstName %> <%= student.lastName %>!</h3>
    <%
        }
    %>
    
    <h2>Available Cafeterias</h2>
    <div class="cafeteria-list">
        <%
            List<Cafeteria> cafeterias = (List<Cafeteria>) request.getAttribute("cafeterias");
            if (cafeterias != null && !cafeterias.isEmpty()) {
                for (Cafeteria cafe : cafeterias) {
        %>
            <div class="cafeteria-card">
                <img class="cafeteria-img" src="<%= cafe.imageUrl %>" alt="<%= cafe.name %> Image" />
                <h4 class="cafeteria-name"><%= cafe.name %></h4>
            </div>
        <%
                }
            } else {
        %>
            <p>No cafeterias available at the moment.</p>
        <%
            }
        %>
    </div>
</div>

<%@include file="include/footer.html" %>
