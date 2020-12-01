<%-- 
    Document   : administrador
    Created on : 14 nov. 2020, 18:56:49
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./public/css/administrador.css">
    <link rel="stylesheet" href="./privado/css/form-alta-medicos.css">
    <link rel="stylesheet" href="./privado/css/form-alta-pacientes.css">
    <link rel="stylesheet" href="./privado/css/form-baja-medicos.css">
    <link rel="stylesheet" href="./privado/css/form-baja-pacientes.css">
    <link rel="stylesheet" href="./privado/css/asignar-pacientes.css">
    <link rel="stylesheet" href="./privado/css/generar-codigo.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Main Page</title>

    <script>
        $(document).ready(function(){

            $("#alta").click(function(){

                $("#main").load("./privado/form-alta-medicos.jsp");
                return false;
            });
            
             $("#alta-paciente").click(function () {

                $("#main").load("./privado/form-alta-pacientes.jsp");
                return false;

            });
            
            $("#baja").click(function () {

                $("#main").load("./privado/form-baja-medicos.jsp");
                return false;

            });
            
            $("#baja-paciente").click(function () {

                $("#main").load("./privado/form-baja-pacientes.jsp");
                return false;

            });
            
            $("#asignar").click(function () {

                $("#main").load("./privado/asignar-paciente.jsp");
                return false;

            });
            
            $("#generar-codigo").click(function () {

                $("#main").load("./privado/generar-codigo.jsp");
                return false;

            });

        });
    </script>

</head>
<body>
    <section class="Container">

        <section class="navbar">

        </section>

        <section class="main-container">
            <h3 class="title">ZeroDistance cuidando de tu familia</h3>

            <section class="page-user">
                <article>
                    <article class="user">
                    <p class="welcom-text">Bienvedio!</p>
                    <p class="user-text">Administrador</p>
                    </article>
                </article>
            </section>

            <section class="header">
                
                <ul class="nav">
                    <li><a href="#">Medicos</a>
                        <ul>
                            <li><a href="" id="alta">Dar de Alta</a></li>
                            <li><a href="" id="baja">Dar de Baja</a></li>
                            <li><a href="" id="asignar">Asignar paciente</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Pacientes</a>
                        <ul>
                            <li><a href="" id="alta-paciente">Dar de Alta</a></li>
                            <li><a href="" id="baja-paciente">Dar de Baja</a></li>
                            <li><a href="" id="generar-codigo">Generar codigo</a></li>
                        </ul>                       
                    </li>
                    <li><a href="#">Informacion</a></li>
                </ul>

            </section>


            <section id="main" class="main"></section>

        </section>
    </section>

</body>
</html>
