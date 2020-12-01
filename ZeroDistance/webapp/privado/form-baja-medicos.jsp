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
    <link rel="stylesheet" href="./css/form-baja-medicos.css">
    <title>Document</title>
</head>
<body>
    <section id="form-alta" >

        <form  class="baja-medicos" action="${pageContext.request.contextPath}/ControladorMedico?accion=baja" method="post">
            <section class="one-baja">
                <label for="">Numero de empleado: </label>
                <input type="text" name="numeroEmpleado" id="">
            </section>  
            <input type="submit" id="colsultar" class="button-baja" value="Eliminar medico">
        </form>
    </section>

    <section class="resultado" id="resultado"></section>
</body>
</html>