<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ page import="java.util.List" %>
<%@ page import="Query.MenuItem" %> 

<%@include file="include/header.html" %>  
<div class="main">
    <h3>Menu Items</h3>
    <hr/><br/>
    <div class="menu-items">  
        <!-- Dynamically display menu items from the servlet -->
        <%  
            List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
            for (MenuItem item : menuItems) {  
        %>  
        <div class="menu-item">  
            <img src="<%= item.image_url %>" alt="<%= item.item %>" class="menu-item-img" />  
            <div class="menu-item-details">  
                <div class="item-details">  
                    <h3><%= item.item %></h3>  
                    <p>Amount: <%= item.stock_quantity %></p>  
                    <p>Price: KES <%= item.price %></p>  
                </div>  
                <div class="menu-item-actions">  
                    <button>Edit</button>  
                    <button>Remove</button>  
                    <button>Out of stock</button>  
                </div>  
            </div>  
        </div>  
        <%  
            }  
        %>  
    </div>  

    <h2>Add New Menu Item</h2>  
    <form action="#" method="post" enctype="multipart/form-data">  
        <label for="name">Item Name:</label>  
        <input type="text" id="name" name="name" required />  

        <label for="amount">Amount:</label>  
        <input type="text" id="amount" name="amount" required />  

        <label for="price">Price (KES):</label>  
        <input type="number" id="price" name="price" step="0.01" required />  

        <label for="image">Item Image URL:</label>  
        <input type="text" id="image" name="image" required />  

        <button type="submit">Add Item</button>  
    </form>  
</div>  
<%@include file="include/footer.html" %>  
