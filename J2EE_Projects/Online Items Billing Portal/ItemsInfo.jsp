<!-- Information Store JS Page -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Items Data Store
        </title>
        <style>
            body{
                font-family: Arial, Helvetica, sans-serif;
                background-color: lightblue;
                color: white;
            }
            .container{
                max-width: 400px;
                transform: translate(450px,20px);
                background-color: darkseagreen;
                color: white;
                border: solid;
                border-radius: 10px;
            }
            table{
                background-color: white;
                transform: translate(30px,-5px);
                max-width: 200px;
                border-collapse: collapse;
                color: black;;
            }
            th {
                background-color: #4CAF50;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            tr.total-row {
                background-color: #dff0d8;
                font-weight: bold;
                color: green;
            }
            a {
                color: yellow;
                text-decoration: none;
                font-weight: bold;
                margin-right: 10px;
                padding: 15px;
            }
            td{
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center;">Selected Products</h1>
            <%
            Map<String, Double> hashMap=new HashMap<>();
            hashMap.put("Motherboard",2000.0);
            hashMap.put("Mouse",500.0);
            hashMap.put("Keyboard",500.0);
            hashMap.put("Scanner",13999.9);
            hashMap.put("Printer",14499.9);
            hashMap.put("Processor",11999.9);
            hashMap.put("Graphic Card",2100.0);
            hashMap.put("Touchscreen",17500.0);
            hashMap.put("Hard Disk",4500.0);
            String[] items=request.getParameterValues("Products");
            if(items != null){
                double total=0.0;
                %><table border="2px">
                    <tr>
                        <th><b>Select</b></th>
                        <th><b>Products</b></th>
                        <th><b>Quantity</b></th>
                        <th><b>Prices</b></th>
                    </tr>
                        <%
                        for(String data:items){
                            Double price = hashMap.get(data);
                            String quantityParam = request.getParameter("Quantity_" + data.replace(" ", "_"));
                            int quantity = 1;
                            if(quantityParam != null){
                                try{
                                    quantity=Integer.parseInt(quantityParam);
                                }catch(NumberFormatException e){
                                    quantity=1;
                                }
                            }
                            double subtotal=quantity*price;
                            total=total+subtotal;
                            %>
                            <tr>
                                <td><%= data %></td>
                                <td>$<%= price %></td>
                                <td><%= quantity %></td>
                                <td>$<%= subtotal %></td>
                            </tr>
                            <%}%>
                            <tr>
                                <th colspan="2">Your Bill:</th>
                                <th colspan="2">$<%= total %></th>
                            </tr>
                    </table>
                    <p><a href="Items.jsp">Add Products</a></p>
                    <p><a href="Logout.jsp">Logout</a></p>
                    <%}
                    else{%>
                <p>You have no select any product</p>
                <p><a href="Logout.jsp" style="background-color:grey;width:100px;">Logout</a></p>
                <p><a href="Items.jsp">Go Back</a></p>
                <%}
                %>
        </div>
    </body>
</html>

