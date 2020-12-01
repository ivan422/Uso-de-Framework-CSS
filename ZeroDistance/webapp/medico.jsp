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
        <link rel="stylesheet" href="./public/css/medico.css">

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

                <section id="main" class="main">
                    <h2 class="titulo">Listado de pacientes</h2>    
                </section>


                <Section>
                    <c:forEach var="paciente" items="${pacientes}">
                        <a class="enlace" href="${pageContext.request.contextPath}/ControladorMedico?accion=mostrar&id=${paciente.id}"><section class="pacientes">
                                <h4 class="texto">Numero de seguro social: ${paciente.numero_seguro}</h4>
                            <h2 class="texto paciente-importante">${paciente.nombre} ${paciente.paterno} ${paciente.materno}</h2>
                        </section></a>
                    </c:forEach>
                </Section>


            </section>
        </section>

    </body>
</html>

