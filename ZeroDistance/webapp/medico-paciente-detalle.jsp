<%-- 
    Document   : medico
    Created on : 14 nov. 2020, 18:57:07
    Author     : jesus
--%>
<%-- Librería de core para JSP --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./public/css/medico-paciente-detalle.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Main Page</title>

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
                            <p class="user-text">Medico</p>
                        </article>
                    </article>
                </section>

                <a href="medico.jsp">Regresar </a>
                
                <section class="cuadronombre">
                    <h2>${mostrarPaciente.nombre} ${mostrarPaciente.paterno} ${mostrarPaciente.materno}</h2>
                </section>

                <section class="ultimo">

                    <section class="estado">
                        <h4>Ultimo estado</h4>
                        <h4>Fecha: ${ultimoEstado.fecha}</h4>
                        <h2 class="estado-importante">${ultimoEstado.estado}</h2>
                    </section>

                    <section class="estado">
                        <h4>Ultimo tratamiento</h4>
                        <h4>Fecha: ${ultimoTratamiento.fecha}</h4>
                        <h2 class="estado-importante">${ultimoTratamiento.tratamiento}</h2>
                    </section>
                </section>

                <form  class="asignar-pacientes" action="${pageContext.request.contextPath}/ControladorMedico?accion=estado&idPaciente=${mostrarPaciente.id}&idDoctor=${medico.id}" method="post">
                    <section><h2 class="titulo">Agregar estado nuevo</h2></section>
                    
                    <section class="one-asignar">
                        <label for="">Estado nuevo: </label>
                        <input type="text" name="estado" id="">
                    </section>  

                    <section class="two-asignar">
                        <label for="">Fecha: </label>
                        <input type="text" name="fecha" id="">
                    </section>

                    <input type="submit" id="colsultar" class="button-asignar" value="Añadir Estado">
                </form>


                <form  class="asignar-pacientes" action="${pageContext.request.contextPath}/ControladorMedico?accion=tratamiento&idPaciente=${mostrarPaciente.id}&idDoctor=${medico.id}" method="post">
                    
                    <section class="titulo"><h2>Agregar tratamiento nuevo</h2></section>
                    
                    <section class="one-asignar">
                        <label for="">Tratamiento nuevo: </label>
                        <input type="text" name="tratamiento" id="">
                    </section>  

                    <section class="two-asignar">
                        <label for="">Fecha: </label>
                        <input type="text" name="fecha" id="">
                    </section>

                    <input type="submit" id="colsultar" class="button-asignar" value="Añadir tratamiento">
                </form>

            </section>
        </section>

    </body>
</html>

