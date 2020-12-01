/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PacienteDAO;
import domain.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CiPp9
 */
public class pruebaPacienteMedico {
    
    public void main (String[] args){
        
        PacienteDAO pacienteDao = new PacienteDAO();
        List<Paciente> pacientes = pacienteDao.seleccionarDeMedico(1);
        
        
        for(Paciente paciente : pacientes){
            System.out.println(paciente);
        }
        
        
        
    }
}
