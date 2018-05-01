<%-- 
    Document   : PruebaCatalogo
    Created on : 25/04/2018, 10:15:56 AM
    Author     : OmarNori
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="db.Conexion"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Catálogo</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <style type="text/css">
            body{
                background: url("Img/toys1.png"); 
            }
            input { 
                background-color: transparent; 
            }
            .caja{
                background-color: blue;
                color: black;
                float: left;
                height: 280px;
                text-align: center;
                width: 300px;
                border: 1px solid;
                background-color:  rgba(255,255,255,.7);
            }
            .contenedor{
                background-color: transparent;
                width: 900px;
                height: 1004px;
                margin: auto;
            }
            body{
                font-family: "BB";
            }
        </style>
    </head>
    <body>
        <%
            try {
                Conexion con = new Conexion();
                Connection c = con.getConexion();
                Statement st = c.createStatement();
                ResultSet rs = null;
                ArrayList<String> nom = new ArrayList<String>();
                ArrayList<String> desc = new ArrayList<String>();
                ArrayList<Integer> id = new ArrayList<Integer>();
                System.out.println("Conectado");
                rs = st.executeQuery("select * from Juguete_has_Sucursal where Sucursal_idSucursal=3 and not existencia = 0;");
                while (rs.next()) {
                    System.out.println("idjuguete: " + rs.getInt("Juguete_idJuguete"));
                    id.add(rs.getInt("Juguete_idJuguete"));
                }
                System.out.println("idlength = " + id.size());
                for (int i = 0; i < id.size(); i++) {
                    rs = st.executeQuery("select * from juguete where idjuguete = " + id.get(i) + ";");
                    while (rs.next()) {
                        System.out.println("Nombre: = " + rs.getString("Nombre"));
                        nom.add(rs.getString("Nombre"));
                        desc.add(rs.getString("Descripcion"));
                    }
                }
        %>
        <h1>Juguetes</h1>
        <h2>De clic en el carrito de un juguete para reclamarlo.</h2>
        <div class="contenedor">
            <%for (int i = 0; i < id.size(); i++) {
                    int a = i + 1;
            %>
            <div class="caja">
                <form action="Disminuir" method="post">
                    <input type="hidden" name="idJuguete" value="<%out.print(id.get(i));%>"> 
                    <p align="center"><%out.print(nom.get(i));%></p>
                    <p align="center"><img src="Img/Juguetes/j<%out.print(a);%>.png" width="100" height="100"></p>
                    <p align = "center"><%out.print(desc.get(i));%></p>
                    <p align = "center"><input type="image" name="imageField" src="Img/carrito.png" width="35px" height="35px"/></p> 
                </form>
            </div>
            <%}%>
        </div>
        <%
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        %>
    </body>
</html>
