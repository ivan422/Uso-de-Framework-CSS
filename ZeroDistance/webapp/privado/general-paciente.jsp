<%-- 
    Document   : general-paciente
    Created on : 24 nov. 2020, 13:10:22
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
