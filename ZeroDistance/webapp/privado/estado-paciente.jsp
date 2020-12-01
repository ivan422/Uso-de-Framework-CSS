<%-- 
    Document   : general-paciente
    Created on : 24 nov. 2020, 13:10:22
    Author     : jesus
--%>
<%-- Librería de core para JSP --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="es">
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/estado-paciente.css">
    <title>Document</title>
    </head>
    <body>
        <section id="main" class="main">

            <section id ="Contenido">

                <section class="info1">

                    <section class="cuadronombre">
                        <h2>${paciente.nombre} ${paciente.paterno} ${paciente.materno}</h2>
                    </section>

                    <Section>
                        <c:forEach var="estado" items="${estados}">
                            <section class="estado">
                                <h4>Fecha: ${estado.fecha}</h4>
                                <h2 class="estado-importante">${estado.estado}</h2>
                                <h4>Doctor: ${medicoPaciente.nombre} ${medicoPaciente.paterno} ${medicoPaciente.materno}</h4>
                            </section>
                                
                        </c:forEach>
                    </Section>

                </section>

            </section>

        </section>


    </body>
</html>
