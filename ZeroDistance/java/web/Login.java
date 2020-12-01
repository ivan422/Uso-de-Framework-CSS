package web;

import datos.EstadoDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import datos.TratamientoDAO;
import domain.Administrador;
import domain.Estado;
import domain.Medico;
import domain.Paciente;
import domain.Tratamiento;
import domain.Validador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesus
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String accion = request.getParameter("accion");
        
        switch(accion){
            case "login":
                
                Validador validador = new Validador();
                String user = request.getParameter("user");
                String password  = request.getParameter("password");
                
                
                Administrador administrador = validador.loginAdministrador(user, password);
                Medico medico = validador.loginMedico(user, password);
                HttpSession sesion = request.getSession();
                
                if(administrador != null){
                    sesion.setAttribute("administrador", administrador);
                    response.sendRedirect("administrador.jsp");
                }else if(medico != null){
                    //AgregadoCarlos
                    //Enviar Pacientes del médico
                    PacienteDAO pacienteDao = new PacienteDAO();
                    List<Paciente> pacientes = pacienteDao.seleccionarDeMedico(medico.getId());
                    sesion.setAttribute("pacientes", pacientes);
                    
                    sesion.setAttribute("medico", medico);
                    response.sendRedirect("medico.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                }
                
                break;
                
            case "login-code":
                
                HttpSession sesion2 = request.getSession();
                Validador validadorP = new Validador();
                String code = request.getParameter("code");
                Paciente paciente = validadorP.loginPaciente(code);
                
                
                if(paciente != null){
                    TratamientoDAO tratamientoDao = new TratamientoDAO();
                    List<Tratamiento> tratamientos = tratamientoDao.seleccionarPorPaciente(paciente.getId());
                    sesion2.setAttribute("tratamientos", tratamientos);
                    
                    EstadoDAO estadoDao = new EstadoDAO();
                    List<Estado> estados = estadoDao.seleccionarPorPaciente(paciente.getId());
                    sesion2.setAttribute("estados", estados);
                    
                    Medico medicoPaciente = new Medico(paciente.getIdDoctor());
                    MedicoDAO medicoDao = new MedicoDAO();
                    
                    medicoPaciente = medicoDao.buscar(medicoPaciente);
                    
                    sesion2.setAttribute("medicoPaciente", medicoPaciente);
                    sesion2.setAttribute("paciente", paciente);
                    response.sendRedirect("paciente.jsp");
                }else{
                   response.sendRedirect("index.jsp"); 
                }
                break;
        }
    }
   
}
