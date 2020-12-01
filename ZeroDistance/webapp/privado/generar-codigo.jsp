<%-- 
    Document   : form-baja-medicos
    Created on : 23 nov. 2020, 0:56:04
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/form-baja-pacientes.css">
        <title>Document</title>

    </head>
    <body>
        <section id="form-alta" >

            <form  class="generar" action="${pageContext.request.contextPath}/ControladorPaciente?accion=generar" method="post">
                <section class="one-generar">
                    <label for="">Numero de seguro social: </label>
                    <input type="text" name="numeroSeguroSocial" id="">
                </section>  
                <input type="submit" id="colsultar" class="button-generar" value="Generar codigo">
            </form>
        </section>

        <section class="resultado" id="resultado"></section>
    </body>
</html>