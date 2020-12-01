package domain;

import datos.AdministradorDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import java.util.List;

/**
 *
 * @author jesus
 */
public class Validador {
    
    AdministradorDAO administradorDao;
    MedicoDAO medicoDao;
    
    public Administrador loginAdministrador(String user, String password){
        administradorDao = new AdministradorDAO();

        List<Administrador> administradores = administradorDao.consultar();
        
        for(Administrador administrador : administradores){
            if(administrador.getUsuario().equals(user)){
                if(administrador.getContrasena().equals(password)){
                    return administrador;
                }
            }
        }
        return null;
    } 
    
    public Medico loginMedico(String user, String password){
        medicoDao = new MedicoDAO();
        List<Medico> medicos = medicoDao.consultar();
        
        for(Medico medico : medicos){
            if(medico.getUsuario().equals(user)){
                if(medico.getContrasena().equals(password)){
                    return medico;
                }
            }
        }
        
        return null;
    } 
    
    public Paciente loginPaciente(String code){
        PacienteDAO pacienteDao = new PacienteDAO();
        Paciente paciente = new Paciente(code);
        
        paciente = pacienteDao.buscarCodigo(paciente);
        return paciente;
    }
}
