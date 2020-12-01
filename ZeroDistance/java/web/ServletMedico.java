
package web;

import datos.EstadoDAO;
import datos.PacienteDAO;
import datos.TratamientoDAO;
import domain.Estado;
import domain.Paciente;
import domain.Tratamiento;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletMedico")
public class ServletMedico extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        
        String accion = request.getParameter("accion");
        
        
        switch (accion) {
            case "listar":
                this.listar(request, response);
                break;
            case "cambiarEstado":
                this.cambiarEstado(request, response);
                break;
            case "agregarTratamiento":
                this.agregarTratamiento(request, response);
                break;
            default:
                throw new AssertionError();
        }
        
        
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "actualizarEstado":  
            
                try {
                    this.actualizarEstado(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ServletMedico.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                break;
            case "actualizarTratamiento":  
            
                try {
                    this.actualizarTratamiento(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ServletMedico.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                break;
            default:
                throw new AssertionError();
        }
 
    }
    
    //Asigna los elementos
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        HttpSession sesion = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        
        sesion.setAttribute("id",id);
        
        PacienteDAO pacienteDao = new PacienteDAO();
        Paciente paciente = new Paciente(id);
        paciente = pacienteDao.buscar(paciente);
        sesion.setAttribute("paciente",paciente);
        
        EstadoDAO estadoDao = new EstadoDAO();
        Estado estado = estadoDao.ultimoEstado(id);
        sesion.setAttribute("estado", estado);
        
        TratamientoDAO tratamientoDao = new TratamientoDAO();
        List<Tratamiento> tratamientos = tratamientoDao.seleccionarPorPaciente(id);
        sesion.setAttribute("tratamientos", tratamientos);      
        
        
        
        response.sendRedirect("medico_paciente.jsp");
        
    }
    
    //Cambiar estado
    public void cambiarEstado(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        HttpSession sesion = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        
        EstadoDAO estadoDao = new EstadoDAO();
        List<Estado> estados = estadoDao.seleccionarPorPaciente(id);
        sesion.setAttribute("estados",estados);
        sesion.setAttribute("id",id);
        
        response.sendRedirect("cambiar_estado.jsp");
        
    }
    
    //Actualiza Estado
    public void actualizarEstado(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        // Recuperamos los valores del formulario
        
        Estado estado = new Estado();
        
        estado.setId_paciente(parseInt(request.getParameter("id")));
        estado.setEstado(request.getParameter("estadoopcion"));
        estado.setFecha(request.getParameter("fecha"));
        
        EstadoDAO estadoDao = new EstadoDAO();
        
        estadoDao.insertar(estado);
        
        this.listar(request, response);
        
    }
    
    //AgregarTratamiento
    public void agregarTratamiento(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        HttpSession sesion = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        sesion.setAttribute("id",id);
        
        response.sendRedirect("agregar_tratamiento.jsp");
        
    }
    
    //Actualiza Tratamiento
    public void actualizarTratamiento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        // Recuperamos los valores del formulario
        
        Tratamiento tratamiento = new Tratamiento();
        
        tratamiento.setId_paciente(parseInt(request.getParameter("id")));
        tratamiento.setTratamiento(request.getParameter("tratamiento"));
        tratamiento.setFecha(request.getParameter("fecha"));
        
        TratamientoDAO tratamientoDao = new TratamientoDAO();
        tratamientoDao.insertar(tratamiento);
        
        this.listar(request, response);
        
    }
    
    
    
}
