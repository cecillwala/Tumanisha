<%-- 
    Document   : register
    Created on : Feb 16, 2025, 5:36:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.FileWriter" %>
<%@page import="java.io.IOException" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tumanisha | Home</title>
        <link href="style/styles.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <%
            String firstName =  request.getParameter("firstName");
            String lastName =  request.getParameter("lastName");
            String hostel = request.getParameter("hostel");
            String roomno = request.getParameter("roomNo");
            String nationalID = request.getParameter("nationalID");
            String email = request.getParameter("email");
            
             try {
                FileWriter myWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\registered.txt", true);
                myWriter.write("First name: " + firstName +
                               "\nLast name: "+ lastName +
                               "\nNational ID: "+ nationalID +
                               "\nEmail: "+ email +
                               "\nHostel: "+ hostel +
                               "\nRoom Number: "+ roomno +"\n\n");
            myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
            e.printStackTrace();
        }
        %>
        <h1>Form submitted and saved to "registered.txt" on your Desktop</h1>
    </body>
</html>
