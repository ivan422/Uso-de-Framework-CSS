<%-- 
    Document   : index
    Created on : 11 nov. 2020, 0:09:00
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./public/css/main.css">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto:wght@400;700&display=swap" rel="stylesheet"> 
    <script src="https://kit.fontawesome.com/a399b7469e.js" crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body>
    <div class="content">
    
        <form class="children one"  action="${pageContext.request.contextPath}/Login?accion=login" method="post"> 
            <section class="item-title">
                <h1>Bienvenido a ZeroDistance</h1>
            </section>
            <section class="item-boxes">
                <input type="text" name="user"  placeholder="    &#xf0e0; Email">
                <input type="password" name="password" placeholder="    &#xf3ed; Contraseña">
            </section>
            <section class="item-forgot">
                <a href="">Olvidaste tu contraseña?</a>
            </section>
            <section class="item-button">
                <input type="submit" value="Iniciar sesion">
            </section>
        </form>
        
        <form class="children two" action="${pageContext.request.contextPath}/Login?accion=login-code" method="post">

            <section class="item-title-create"> 
                <h1>Hola!!</h1>
            </section>
            <section class="item-paragraph">
                <p>Para checar el estado de salud<br>de un paciente, por favor introduce<br>tu codigo.</p>
            </section>
            <section class="item-boxes">
                <input type="text" name="code" placeholder="&#xf02a; Introduce tu codigo...."/>
            </section>
            
            <section class="item-button-create ">
                <input class="efecto" type="submit" value="Iniciar">
            </section>

        </form>

    </div>
</body>
</html>
