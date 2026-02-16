<!-- Items Store Page -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Information Store Page 
        </title>
        <style>
            body{
                font-family: Arial, Helvetica, sans-serif;
                background-color: lightblue;
                color:white;
            }
            .container{
                background-color: darkseagreen;
                max-width: 400px;
                color: white;
                border: solid;
                transform: translate(450px,-20px);
                border-radius: 10px;
            }
            table{
                border-collapse: collapse;
                margin-bottom: 10px;
                max-width: 300px;
                transform: translate(50px,-25px);
                background-color: white;
                color: black;
            }
            th{
                background-color:green ;
                color:white
            }
            tr:nth-child(even){
                background-color: #f2f2f2;
            }
            tr.total-row{
                background-color: #dff0d8;
                font-weight: bold;
                color: green;
            }
            td{
                padding: 5px;
            }
            input[type="checkbox"]{
                margin-top: 5px;
            }
            input[type="submit"]{
                background-color: darkgrey;
                padding: 3px;
                transform: translate(125px);
                text-align: center;
                width: 100px;
                border: solid;
                border-radius: 80px;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <%
            HttpSession mySession=request.getSession(true);
            String userName=(String)mySession.getAttribute("userName");
            if(userName == null){
                response.sendRedirect("Login.jsp");
                return;
            }
            %>
            <h1 style="text-align: center;">Production Selection</h1>
            <h2 style="text-align: center;">Welcome ,Admin <%= userName %></h2>
            <h2 style="text-align: center;">Available Products</h2>
            <form action="ItemsInfo.jsp" method="POST">
                <table border="2px">
                <label for="Products"></label>
                <tr>
                    <th>Select</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Motherboard" name="Products" value="Motherboard"></td>
                    <td>Motherboard</td>
                    <td>$2000.0</td>
                    <td><input type="number" name="Quantity_Motherboard" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Mouse" name="Products" value="Mouse"/></td>
                    <td>Mouse</td>
                    <td>$500.0</td>
                    <td><input type="number" name="Quantity_Mouse" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Keyboard" name="Products" value="Keyboard"/></td>
                    <td>Keyboard</td>
                    <td>$500.0</td>
                    <td><input type="number" name="Quantity_Keyboard" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Scanner" name="Products" value="Scanner"/></td>
                    <td>Scanner</td>
                    <td>$13999.9</td>
                    <td><input type="number" name="Quantity_Scanner" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Printer" name="Products" value="Printer"/></td>
                    <td>Printer</td>
                    <td>$14499.9</td>
                    <td><input type="number" name="Quantity_Printer" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Processor" name="Products" value="Processor"/></td>
                    <td>Processor</td>
                    <td>$11999.9</td>
                    <td><input type="number" name="Quantity_Processor" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Graphic Card" name="Products" value="Graphic Card"/></td>
                    <td>Graphic Card</td>
                    <td>$2100.0</td>
                    <td><input type="number" name="Quantity_Graphic Card" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Touchscreen" name="Products" value="Touchscreen"/></td>
                    <td>Touchscreen</td>>
                    <td>$17500.0</td>
                    <td><input type="number" name="Quantity_Touchscreen" min="1" value="1" style="width:50px;"/></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="Hard Disk" name="Products" value="Hard Disk"/></td>
                    <td>Hard Disk</td>
                    <td>$4500.0</td>
                    <td><input type="number" name="Quantity_Hard Disk" min="1" value="1" style="width:50px;"/></td>
                </tr>
                </table>
                <input type="submit" value="Add To Cart"/>
            </form>
        </div>
    </body>
</html>
    

