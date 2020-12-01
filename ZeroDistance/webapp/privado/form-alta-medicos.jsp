<%-- 
    Document   : form-alta-medicos
    Created on : 19 nov. 2020, 23:45:18
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/form-alta-medicos.css">
</head>
<body>
    
    <section id="form-alta" >

        <form  class="alta-medicos" action="${pageContext.request.contextPath}/ControladorMedico?accion=alta" method="post">
            <section class="one">
                <label for="">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Nombre: </label>
                <input type="text" name="nombre" id="">
            </section>

            <section class="two">  
                <label for="">&nbsp; &nbsp; &nbsp; Apellido paterno: </label>
                <input type="text" name="paterno" id="">
            </section>  

            <section class="three">
                <label for="">&nbsp; &nbsp; &nbsp; Apellido materno: </label>
                <input type="text" name="materno" id="">
            </section>  

            <section class="four">
                <label for="">Fecha de nacimiento: </label>
                <input type="text" name="fechaNacimiento" id="">
            </section>  

            <section class="five">
                <label for="">Número de empleado: </label>
                <input type="text" name="numeroEmpleado" id="">
            </section>  

            <section class="six">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Área: </label>
                <input type="text" name="area" id="">
            </section>  

            <section class="seven">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Usuario: </label>
                <input type="text" name="usuario" id="">
            </section>  

            <section class="eight">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Contraseña: </label>
                <input type="text" name="password" id="">
            </section> 
            
            <input type="submit" class="button" value="Dar de alta">


        </form>
    </section>
</body>
</html>
