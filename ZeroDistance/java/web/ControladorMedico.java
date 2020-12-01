
package web;

import datos.EstadoDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import datos.TratamientoDAO;
import domain.Estado;
import domain.Medico;
import domain.Paciente;
import domain.Tratamiento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesus
 */
@WebServlet("/ControladorMedico")
public class ControladorMedico extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String accion = request.getParameter("accion");
        
        switch(accion){
                case "mostrar":
                mostrarPaciente(request,response);
                response.sendRedirect("medico-paciente-detalle.jsp");
                break;
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "alta":
                altaMedico(request, response);
                response.sendRedirect("administrador.jsp");
                break;
                
            case "baja":
                bajaMedico(request,response);
                response.sendRedirect("administrador.jsp");
                break;
                
            case "asignar":
                asignarPaciente(request,response);
                response.sendRedirect("administrador.jsp");
                break;
                
            case "estado":
                nuevoEstado(request,response);
                response.sendRedirect("medico-paciente-detalle.jsp");
                break;
                
            case "tratamiento":
                nuevoTratamiento(request,response);
                response.sendRedirect("medico-paciente-detalle.jsp");
                break;
                
        }
        
    }
    
    private void altaMedico(HttpServletRequest request, HttpServletResponse response){
        
        try {
            String nombre = request.getParameter("nombre");
            String paterno = request.getParameter("paterno");
            String materno = request.getParameter("materno");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String numeroEmpleado = request.getParameter("numeroEmpleado");
            String area = request.getParameter("area");
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            
            Medico medico = new Medico(nombre,paterno,materno,fechaNacimiento,numeroEmpleado,area,usuario,password);
            MedicoDAO medicoDao = new MedicoDAO();
            
            medicoDao.insertar(medico);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void bajaMedico(HttpServletRequest request, HttpServletResponse response) {
        
        String numeroEmpleado = request.getParameter("numeroEmpleado");
        
        Medico medico = new Medico(numeroEmpleado);
        MedicoDAO medicoDao = new MedicoDAO();
        
        medicoDao.eliminar(medico);
    }

    private void asignarPaciente(HttpServletRequest request, HttpServletResponse response) {
        
        String numeroSeguro = request.getParameter("numeroSeguro");
        String numeroEmpleado = request.getParameter("numeroEmpleado");
        
        Medico medico = new Medico(numeroEmpleado);
        MedicoDAO medicoDao = new MedicoDAO ();
        
        medico = medicoDao.buscarNumeroEmpleado(medico);
        
        Paciente paciente = new Paciente(numeroSeguro,"");
        paciente.setIdDoctor(medico.getId());
        PacienteDAO pacienteDao = new PacienteDAO ();
        
        pacienteDao.actualizarDoctor(paciente);
        
    }

    private void mostrarPaciente(HttpServletRequest request, HttpServletResponse response) {
        
        String id = request.getParameter("id");
        
        Paciente paciente = new Paciente(Integer.parseInt(id));
        PacienteDAO pacienteDao = new PacienteDAO();
        paciente = pacienteDao.buscar(paciente);
        
        HttpSession sesion = request.getSession();
        
        EstadoDAO estadoDao = new EstadoDAO();
        Estado estado = estadoDao.ultimoEstado(paciente.getId());
        
        TratamientoDAO tratamientoDao = new TratamientoDAO();
        Tratamiento tratamiento = tratamientoDao.ultimoEstado(paciente.getId());
        
        sesion.setAttribute("ultimoTratamiento", tratamiento);
        sesion.setAttribute("ultimoEstado", estado);
        sesion.setAttribute("mostrarPaciente", paciente);
    }

    private void nuevoEstado(HttpServletRequest request, HttpServletResponse response) {
        String estadoE = request.getParameter("estado");
        String fecha = request.getParameter("fecha");
        String idPaciente = request.getParameter("idPaciente");
        String idDoctor = request.getParameter("idDoctor");
        
        Estado estado = new Estado(Integer.parseInt(idPaciente),Integer.parseInt(idDoctor),estadoE,fecha);
        
        EstadoDAO estadoDao = new EstadoDAO ();
        try {
            estadoDao.insertar(estado);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void nuevoTratamiento(HttpServletRequest request, HttpServletResponse response) {
        String tratamientoE = request.getParameter("tratamiento");
        String fecha = request.getParameter("fecha");
        String idPaciente = request.getParameter("idPaciente");
        String idDoctor = request.getParameter("idDoctor");
        
        Tratamiento tratamiento = new Tratamiento(Integer.parseInt(idPaciente),Integer.parseInt(idDoctor), tratamientoE,fecha);
        TratamientoDAO tratamientoDao = new TratamientoDAO();
        
        try {
            tratamientoDao.insertar(tratamiento);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
