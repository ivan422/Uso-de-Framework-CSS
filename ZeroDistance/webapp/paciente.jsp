<%-- 
    Document   : familiar
    Created on : 14 nov. 2020, 18:57:19
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paciente</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" href="./public/css/paciente.css">
        <link rel="stylesheet" href="./privado/css/general-paciente.css">
        <link rel="stylesheet" href="./privado/css/estado-paciente.css">
        <link rel="stylesheet" href="./privado/css/tratamiento-paciente.css">

        <script>
            $(document).ready(function () {

                $("#general").click(function () {
                    $("#main").load("./privado/general-paciente.jsp");
                    return false;
                });
                
                $("#estado").click(function () {
                    $("#main").load("./privado/estado-paciente.jsp");
                    return false;
                });
                
                $("#tratamiento").click(function () {
                    $("#main").load("./privado/tratamiento-paciente.jsp");
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
                            <p class="user-text">Familiar</p>
                        </article>
                    </article>
                </section>

                <section class="header">

                    <ul class="nav">
                        <li><a id="general" href="">Informacion general</a></li>
                        <li><a id="estado" href="">Estado</a></li>
                        <li><a id="tratamiento" href="">Tratamiento</a></li>
                        <li><a id="atencion" href="">Atencion</a></li>
                    </ul>

                </section>

                <section id="main" class="main">
                    
                    <section id ="Contenido">
                        <section class="info1">
                            
                            <section class="cuadronombre">
                                <h2>${paciente.nombre} ${paciente.paterno} ${paciente.materno}</h2>
                            </section>
                            
                            <section class="infoadicional">
                                
                                <h2 class="personal"> Informacion personal </h2>
                                <section class="one-informacion">
                                    <Label class="label">Id del paciente: </Label>
                                    <input class="input" type="text" value="${paciente.id}" readonly="readonly" > 
                                </section>

                                <section class="two-informacion">
                                    <Label class="label">Fecha de nacimiento: </Label>
                                    <input class="input" type="text" value="${paciente.fecha_nacimiento}" readonly="readonly" > 
                                </section>
                                
                                <section class="three-informacion">
                                    <Label class="label">Numero seguro social: </Label>
                                    <input class="input" type="text" value="${paciente.numero_seguro}" readonly="readonly" > 
                                </section>

                                <section class="four-informacion">
                                    <Label class="label">Curp: </Label>
                                    <input class="input" type="text" value="${paciente.curp}" readonly="readonly" > 
                                </section>
                                
                                <h2 class="medica"> Informacion medica </h2>
                                <section class="five-informacion">
                                    <Label class="label">Fecha de ingreso: </Label>
                                    <input class="input" type="text" value="${paciente.fecha_ingreso}" readonly="readonly" > 
                                </section>
                                
                                <section class="six-informacion">
                                    <Label class="label">Instalacion: </Label>
                                    <input class="input" type="text" value="${paciente.instalacion}" readonly="readonly" > 
                                </section>
                                
                                <section class="seven-informacion">
                                    <Label class="label">Planta: </Label>
                                    <input class="input" type="text" value="${paciente.planta}" readonly="readonly" > 
                                </section>
                                
                                <section class="eight-informacion">
                                    <Label class="label">Cama: </Label>
                                    <input class="input" type="text" value="${paciente.cama}" readonly="readonly" > 
                                </section>
                                
                            </section>
                        </section>

                    </section>
                </section>

            </section>
        </section>    

    </body>
</html>
