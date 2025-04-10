<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tumanisha Cafe</title>
    <link href="https://fonts.googleapis.com/css2?family=Bubblegum+Sans&display=swap" rel="stylesheet">
    
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: 'Bubblegum Sans', cursive;
            background-color: #000;
            color: white;
            overflow: hidden;
        }

        .container {
            display: flex;
            height: 100vh;
        }

        /* Sidebar */
        .sidebar {
            width: 250px;
            background-color: #000;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            border-right: 1px solid #F78508;
        }

        .logo {
            text-align: center;
            margin-bottom: 30px;
        }

        .logo img {
            width: 70px;
            height: 70px;
            border-radius: 50%;
        }

        .logo span {
            font-size: 24px;
            color: white;
            font-weight: bold;
            line-height: 1.2;
        }

        .button {
            width: 100%;
            padding: 14px;
            margin: 10px 0;
            font-size: 20px;
            background-color: #F78508;
            color: white;
            border: none;
            border-radius: 20px;
            cursor: pointer;
            transition: all 0.2s ease-in-out;
        }

        .button:hover {
            background-color: white;
            color: #F78508;
        }

        /* Main Content */
        .content {
            flex-grow: 1;
            padding: 40px;
            overflow-y: auto;
        }

        .content h1 {
            font-size: 36px;
            margin-bottom: 10px;
        }

        .content p {
            font-size: 18px;
            margin-bottom: 30px;
        }

        .table-container {
            display: flex;
            justify-content: center;
        }

        table {
            width: 90%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #F78508;
        }

        th {
            font-size: 18px;
            background-color: #111;
        }

        td {
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="container">

    <!-- Sidebar -->
    <div class="sidebar">
        <div class="logo">
            <img src="include/logo.png" alt="Tumanisha Logo">
            <span>tumanisha<br>cafeteria</span>
        </div>
        <button class="button">Home</button>
        <button class="button">Orders</button>
        <button class="button">Menu</button>
        <button class="button">Inventory</button>
    </div>

    <!-- Main Content -->
    <div class="content">
        <h1>Welcome to Tumanisha Cafe!</h1>
        <p>Explore our delicious meals, place your orders, and enjoy timely delivery right to your table.</p>

        <div class="table-container">
            <table>
                <tr>
                    <th>Order No.</th>
                    <th>Order</th>
                    <th>Status</th>
                </tr>
                <tr>
                    <td>555009</td>
                    <td>8 chapatis<br>2 beans</td>
                    <td>awaiting delivery</td>
                </tr>
                <tr>
                    <td>555010</td>
                    <td>ugali<br>omena</td>
                    <td>pending</td>
                </tr>
                <tr>
                    <td>555011</td>
                    <td>rice<br>chicken</td>
                    <td>completed</td>
                </tr>
            </table>
        </div>
    </div>

</div>
</body>
</html>
