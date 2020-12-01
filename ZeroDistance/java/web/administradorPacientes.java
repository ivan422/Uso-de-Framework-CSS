/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import datos.PacienteDAO;
import domain.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Henrr
 */
@WebServlet("/administradorPacientes")
public class administradorPacientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet administradorPacientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet administradorPacientes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregar": 
                try {
                    this.agregar(request, response);
                    response.sendRedirect("administrador.jsp");
         
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            break;

            case "eliminar":
            {
                try {
                    this.eliminar(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(administradorPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                break;

            case "buscar":
            {
                try {
                    this.buscar(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(administradorPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

        }

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    // Metodos extras
    // INSERT
    private int agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Recuperamos los valores del formulario
        Paciente pacienteForm = new Paciente();

        pacienteForm.setId(Integer.parseInt(request.getParameter("id")));
        pacienteForm.setNombre(request.getParameter("nombre"));
        pacienteForm.setPaterno(request.getParameter("paterno"));
        pacienteForm.setMaterno(request.getParameter("materno"));
        pacienteForm.setFecha_nacimiento(request.getParameter("fecha_nacimiento"));
        pacienteForm.setNumero_seguro(request.getParameter("numero_seguro"));
        pacienteForm.setCurp(request.getParameter("curp"));
        pacienteForm.setFecha_ingreso(request.getParameter("fecha_ingreso"));
        pacienteForm.setInstalacion(request.getParameter("edificio"));
        pacienteForm.setPlanta(request.getParameter("planta"));
        pacienteForm.setCama(request.getParameter("cama"));
        pacienteForm.setIdDoctor(Integer.parseInt(request.getParameter("idDoctor")));

        // Agregamos el registro a la Base de Datos
        PacienteDAO pacienteBd = new PacienteDAO();
        int rows = pacienteBd.insertar(pacienteForm);


        return rows;
    }
    //Para poder eliminar luego de buscarlo
 Paciente pacienteFormEliminar = new Paciente();
    // DELETE
    private int eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Agregamos el registro a la Base de Datos
        PacienteDAO pacienteBd = new PacienteDAO();
        int rows = pacienteBd.eliminar(pacienteFormEliminar);


        return rows;
    }
    
     // DELETE
    private void buscar (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

       
        

        // Leer el id del navegador
        int id = Integer.parseInt(request.getParameter("id"));

        // Se requiere el Id por que será un update
       pacienteFormEliminar.setId(id);

        // Agregamos el registro a la Base de Datos
        PacienteDAO pacienteBd = new PacienteDAO();
        pacienteFormEliminar=pacienteBd.buscar(pacienteFormEliminar);
        
         HttpSession sesion = request.getSession();
        // Compartimos la información obtenida con otros módulos
        sesion.setAttribute("paciente",pacienteFormEliminar);

    }
}
