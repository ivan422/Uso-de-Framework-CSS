/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Paciente;
import java.util.List;

/**
 *
 * @author dajaimes
 */
public interface PacientesDAO {
    public List<Paciente> seleccionar();
    //AgregadoCarlos
    public List<Paciente> seleccionarDeMedico(int idDoctor);
    public int insertar(Paciente paciente);
    public int eliminar(Paciente paciente);
    public Paciente buscar(Paciente paciente);
    public int actualizar(Paciente paciente);
}
