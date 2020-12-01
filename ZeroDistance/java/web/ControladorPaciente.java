package web;

import datos.PacienteDAO;
import domain.Paciente;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesus
 */

@WebServlet("/ControladorPaciente")
public class ControladorPaciente extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "alta":
                altaPaciente(request,response);
                response.sendRedirect("administrador.jsp");
                break;
                
            case "baja":
                bajaPaciente(request, response);
                response.sendRedirect("administrador.jsp");
                break;
                
            case "generar":
                generarCodigo(request,response);
                response.sendRedirect("administrador.jsp");
                break;
        }
    }
    
    
    private void altaPaciente(HttpServletRequest request, HttpServletResponse response){
        
        String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String numeroSeguro = request.getParameter("numeroSeguro");
        String fechaIngreso = request.getParameter("fechaIngreso");
        String curp = request.getParameter("curp");
        String edificio = request.getParameter("edificio");
        String planta = request.getParameter("planta");
        String cama = request.getParameter("cama");
        String medico = request.getParameter("medico");
        
        Paciente paciente = new Paciente(nombre,paterno,materno,fechaNacimiento,numeroSeguro,curp,fechaIngreso,edificio,planta,cama,Integer.parseInt(medico));
        PacienteDAO pacienteDao = new PacienteDAO();
        pacienteDao.insertar(paciente);
        System.out.println(paciente);
    }

    private void bajaPaciente(HttpServletRequest request, HttpServletResponse response) {
        
        String numeroSeguroSocial = request.getParameter("numeroSeguroSocial");
        
        Paciente paciente = new Paciente(numeroSeguroSocial, "");
        PacienteDAO pacienteDao = new PacienteDAO();
        
        pacienteDao.eliminar(paciente);
    }

    private void generarCodigo(HttpServletRequest request, HttpServletResponse response) {
        String numeroSeguro = request.getParameter("numeroSeguroSocial");
        String codigo = numeroSeguro;
        
        Paciente paciente = new Paciente();
        paciente.setCodigo(codigo);
        paciente.setNumero_seguro(numeroSeguro);
        
        PacienteDAO pacienteDao = new PacienteDAO();
        pacienteDao.actualizarCodigo(paciente);
    }
}
