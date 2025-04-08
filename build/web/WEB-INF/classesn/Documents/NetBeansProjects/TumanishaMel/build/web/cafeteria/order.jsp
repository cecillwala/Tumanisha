<%-- 
    Document   : home
    Created on : Mar 5, 2025, 4:17:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.html" %>
<div class="main">
     <a href="../include/header.html"></a>
        <h1>Orders</h1>
        <div><h2>Order Table</h2>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Customer Name</th>
                    <th>Item</th>
                    <th>Quantity</th>
                    <th>Location</th>
                    <th>Status</th>
                </tr>   
            </thead>
            <tbody>
                <tr>
                    <td>001</td>
                    <td>Michael</td>
                     <td>Chapati</td>
                      <td>4 pieces</td>
                       <td>Bogoria 34</td>
                       <td><button>Ready For Delivery</button></td>
                </tr>
                <tr>
                    <td>002</td>
                     <td>Michael</td>
                     <td>Beans</td>
                      <td>1 piece</td>
                       <td>Bogoria 34</td>
                        <td><button>Ready For Delivery</button></td>
                </tr>
                <tr>
                    <td>003</td>
                     <td>Mercy</td>
                     <td>Ugali</td>
                      <td>2 pieces</td>
                       <td>Mau 58</td>
                        <td><button>Ready For Delivery</button></td>
                </tr>
                <tr>
                    <td>004</td>
                     <td>Mercy</td>
                     <td>Beef Stew</td>
                      <td>2 pieces</td>
                       <td>Mau 58</td>
                        <td><button>Ready For Delivery</button></td>
                </tr>
            </tbody>
        </table>
        </div>
</div>
<%@include file="include/footer.html" %>
