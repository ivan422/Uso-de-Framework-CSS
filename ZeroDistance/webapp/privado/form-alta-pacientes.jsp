<%-- 
    Document   : form-alta-pacientes
    Created on : 20 nov. 2020, 13:40:03
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/form-alta-pacientes.css">
</head>
<body>
    
    <section id="form-alta" >

        <form  class="alta-pacientes" action="${pageContext.request.contextPath}/ControladorPaciente?accion=alta" method="post">
            <section class="one-pacientes">
                <label for="">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Nombre: </label>
                <input type="text" name="nombre" id="">
            </section>

            <section class="two-pacientes">  
                <label for="">&nbsp; &nbsp; &nbsp; Apellido paterno: </label>
                <input type="text" name="paterno" id="">
            </section>  

            <section class="three-pacientes">
                <label for="">&nbsp; &nbsp; &nbsp; Apellido materno: </label>
                <input type="text" name="materno" id="">
            </section>  

            <section class="four-pacientes">
                <label for="">Fecha de nacimiento: </label>
                <input type="text" name="fechaNacimiento" id="">
            </section>  

            <section class="five-pacientes">
                <label for=""> &nbsp; Número de seguro: </label>
                <input type="text" name="numeroSeguro" id="">
            </section>  

            <section class="six-pacientes">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Curp: </label>
                <input type="text" name="curp" id="">
            </section>  

            <section class="nine-pacientes">
                <label for="">Fecha de ingreso: </label>
                <input type="text" name="fechaIngreso" id="">
            </section>  

            <section class="seven-pacientes">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Edificio: </label>
                <input type="text" name="edificio" id="">
            </section>  

            <section class="eight-pacientes">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Planta: </label>
                <input type="text" name="planta" id="">
            </section> 
            
            <section class="eleven-pacientes">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Cama: </label>
                <input type="text" name="cama" id="">
            </section> 

            <section class="ten-pacientes">
                <label for="">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Medico: </label>
                <input type="text" name="medico" id="">
            </section> 
            
            <input type="submit" class="button-pacientes" value="Dar de alta">


        </form>
    </section>
</body>
</html>
