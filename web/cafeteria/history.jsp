<%-- 
    Document   : home
    Created on : Mar 5, 2025, 4:17:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.html" %>
<div class="main">
    <a href="../include/header.html"></a>
        <h1>Order History</h1>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Student Username</th>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Item Price</th>
                    <th>Date and Time</th>
                     <th>Driver</th>
                      <th>Order Status</th>
                </tr>   
            </thead>
            <tbody>
                <tr>
                    <td>001</td>
                    <td>Michael</td>
                     <td>Chapati</td>
                      <td>4 pieces</td>
                        <td>Ksh 40</td>
                       <td>4/05/2025 11.30</td>
                          <td>John</td>
                           <td>Delivered</td>
                </tr>
                <tr>
                    <td>002</td>
                     <td>Michael</td>
                     <td>Beans</td>
                      <td>1 piece</td>
                        <td>Ksh 30</td>
                      <td>4/05/2025 11.30</td>
                          <td>John</td>
                           <td>Delivered</td>
                </tr>
                <tr>
                    <td>003</td>
                     <td>Mercy</td>
                     <td>Ugali</td>
                      <td>2 pieces</td>
                        <td>Ksh 40</td>
                      <td>4/05/2025 14.30</td>
                          <td>Peter</td>
                           <td>Delivered</td>
                </tr>
                <tr>
                    <td>004</td>
                     <td>Mercy</td>
                     <td>Beef Stew</td>
                      <td>2 pieces</td>
                        <td>Ksh 100</td>
                      <td>4/05/2025 11.30</td>
                          <td>Peter</td>
                           <td>Returned</td>
                </tr>
                <tr>
                    <td>005</td>
                     <td>Betty</td>
                     <td>Rice and Beef Stew</td>
                      <td>2 pieces</td>
                        <td>Ksh 180</td>
                      <td>4/05/2025 13.30</td>
                          <td>Peter</td>
                           <td>Delivered</td>
                </tr>
            </tbody>
        </table>
        </div>
</div>
<%@include file="include/footer.html" %>
