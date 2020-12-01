package test;

import datos.AdministradorDAO;
import datos.EstadoDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import datos.PacientesDAO;
import datos.TratamientoDAO;
import domain.Administrador;
import domain.Estado;
import domain.Medico;
import domain.Paciente;
import domain.Tratamiento;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jesus
 */
public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        
        Estado estado = new Estado();
        
        estado.setId_paciente(1);
        estado.setEstado("DébilPrueba");
        estado.setFecha("FechaP");
        
        EstadoDAO estadoDao = new EstadoDAO();
        
        estadoDao.insertar(estado);
        
        /*
        TratamientoDAO tratamientoDao = new TratamientoDAO();
        List<Tratamiento> tratamientos = tratamientoDao.seleccionarPorPaciente(3);
       
        for(Tratamiento tratamiento : tratamientos){
            System.out.println(tratamiento);
        }
        */
        /*
        PacienteDAO pacienteDao = new PacienteDAO();
        Paciente paciente = new Paciente(1);
        paciente = pacienteDao.buscar(paciente);
        
        System.out.println(paciente);
        */
        /*
        PacienteDAO pacienteDao = new PacienteDAO();
        List<Paciente> pacientes = pacienteDao.seleccionarDeMedico(2);
        
        
        for(Paciente paciente : pacientes){
            System.out.println(paciente);
        }
        
        
        AdministradorDAO administradorDao = new AdministradorDAO();
        
        List<Administrador> administradores = administradorDao.consultar();
        
        for(Administrador administrador : administradores){
            System.out.println(administrador);
        }
        
        MedicoDAO medicoDao = new MedicoDAO();
        
        List<Medico> medicos = medicoDao.consultar();
        
        for(Medico medico : medicos){
            System.out.println(medico);
        }
        */
        /*
        PacientesDAO paciente = new PacienteDAO();
        
        Paciente pacientejsp = new Paciente(52067);
        pacientejsp = paciente.buscar(pacientejsp);
        System.out.println(pacientejsp);
*/
    }
}
