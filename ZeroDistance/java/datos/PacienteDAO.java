
package datos;

import domain.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrr
 */
public class PacienteDAO implements PacientesDAO {

    private static final String SQLSELECTPORID = "SELECT id, nombre, paterno, materno, fecha_nacimiento, "
            + "numero_seguro,curp, fecha_ingreso, instalacion, planta, cama, codigo, id_doctor FROM paciente WHERE Id = ?";
    
    private static final String SQL_SELECT_POR_NUMERO_SEGURO = "SELECT id, nombre, paterno, materno, fecha_nacimiento, "
            + "numero_seguro,curp, fecha_ingreso, instalacion, planta, cama, codigo, id_doctor FROM paciente WHERE numero_seguro = ?";
    

    private static final String SQLINSERT = "INSERT INTO paciente(nombre, paterno, materno, fecha_nacimiento, "
            + "numero_seguro,curp, fecha_ingreso, instalacion, planta, cama, id_doctor) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    
    private static final String SQLSELECTPORCODE = "SELECT id, nombre, paterno, materno, fecha_nacimiento, "
            + "numero_seguro,curp, fecha_ingreso, instalacion, planta, cama, codigo, id_doctor FROM paciente WHERE codigo = ?";
    
    //AgregadoCarlos
    private static final String SQLSELECTPORMEDICO = "SELECT id, nombre, paterno, materno, fecha_nacimiento, "
            + "numero_seguro,curp, fecha_ingreso, instalacion, planta, cama, codigo FROM paciente WHERE id_doctor = ?";
    
    private static final String SQLDELETE = "DELETE FROM paciente WHERE numero_seguro=?";
    
    private static final String SQL_UPDATE = "UPDATE paciente SET id_doctor = ? WHERE numero_seguro = ?";
    
    private static final String SQL_UPDATE_CODIGO = "UPDATE paciente SET codigo = ? WHERE numero_seguro = ?";
    
    @Override
    public List<Paciente> seleccionar() {
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //AgregadoCarlos
    @Override
    public List<Paciente> seleccionarDeMedico(int idDoctor) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente pacienteD;
        List<Paciente> pacientes = new ArrayList();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORMEDICO);
            stmt.setInt(1, idDoctor);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                // Leer valores del registro
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String fecha_nacimiento = rs.getString("fecha_nacimiento");
                String numero_seguro = rs.getString("numero_seguro");
                String curp = rs.getString("curp");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String instalacion = rs.getString("instalacion");
                String planta = rs.getString("planta");
                String cama = rs.getString("cama");
                String codigo = rs.getString("codigo");
                //idDoctor = rs.getInt("id_doctor");

                
                pacienteD = new Paciente(id, nombre, paterno, materno, fecha_nacimiento, numero_seguro, curp,
                fecha_ingreso, instalacion, planta, cama, codigo, idDoctor);
                //Ingresa cada paciente al ArrayList
                pacientes.add(pacienteD);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
            }
        }
        
        return pacientes;
    }

    @Override
    public int insertar(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQLINSERT);
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getPaterno());
            stmt.setString(3, paciente.getMaterno());
            stmt.setString(4, paciente.getFecha_nacimiento());
            stmt.setString(5, paciente.getNumero_seguro());
            stmt.setString(6, paciente.getCurp());
            stmt.setString(7, paciente.getFecha_ingreso());
            stmt.setString(8, paciente.getInstalacion());
            stmt.setString(9, paciente.getPlanta());
            stmt.setString(10, paciente.getCama());
            stmt.setInt(11, paciente.getIdDoctor());

            filasAfectadas = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {           
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return filasAfectadas;
    }

    @Override
    public int eliminar(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQLDELETE);
            stmt.setString(1, paciente.getNumero_seguro());

            filasAfectadas = stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return filasAfectadas;
    }

    @Override
    public Paciente buscar(Paciente paciente) {
        // Buscar alumno por Codigo

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORID);
            stmt.setInt(1, paciente.getId());
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        try {
            // validar
            if (rs.next()) {
                // Leer valores del registro
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String fecha_nacimiento = rs.getString("fecha_nacimiento");
                String numero_seguro = rs.getString("numero_seguro");
                String curp = rs.getString("curp");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String instalacion = rs.getString("instalacion");
                String planta = rs.getString("planta");
                String cama = rs.getString("cama");
                String codigo = rs.getString("codigo");
                int idDoctor = rs.getInt("id_doctor");

                // Pasar variables al objeto de retorno
                paciente.setNombre(nombre);
                paciente.setPaterno(paterno);
                paciente.setMaterno(materno);
                paciente.setFecha_nacimiento(fecha_nacimiento);
                paciente.setNumero_seguro(numero_seguro);
                paciente.setCurp(curp);
                paciente.setFecha_ingreso(fecha_ingreso);
                paciente.setInstalacion(instalacion);
                paciente.setPlanta(planta);
                paciente.setCama(cama);
                paciente.setCodigo(codigo);
                paciente.setIdDoctor(idDoctor);
                
                return paciente;

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public Paciente buscarCodigo(Paciente paciente) {
        // Buscar alumno por Codigo

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORCODE);
            stmt.setString(1, paciente.getCodigo());
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        try {
            // validar
            if (rs.next()) {
                // Leer valores del registro
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String fecha_nacimiento = rs.getString("fecha_nacimiento");
                String numero_seguro = rs.getString("numero_seguro");
                String curp = rs.getString("curp");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String instalacion = rs.getString("instalacion");
                String planta = rs.getString("planta");
                String cama = rs.getString("cama");
                String codigo = rs.getString("codigo");
                int idDoctor = rs.getInt("id_doctor");

                // Pasar variables al objeto de retorno
                paciente.setId(id);
                paciente.setNombre(nombre);
                paciente.setPaterno(paterno);
                paciente.setMaterno(materno);
                paciente.setFecha_nacimiento(fecha_nacimiento);
                paciente.setNumero_seguro(numero_seguro);
                paciente.setCurp(curp);
                paciente.setFecha_ingreso(fecha_ingreso);
                paciente.setInstalacion(instalacion);
                paciente.setPlanta(planta);
                paciente.setCama(cama);
                paciente.setCodigo(codigo);
                paciente.setIdDoctor(idDoctor);
                
                return paciente;

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public int actualizar(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int actualizarCodigo(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();             
            
            stmt = conn.prepareStatement(SQL_UPDATE_CODIGO);
            stmt.setString(1, paciente.getCodigo());
            stmt.setString(2, paciente.getNumero_seguro());
            
            filasAfectadas = stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return filasAfectadas;
    }
    
    public int actualizarDoctor(Paciente paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();             
            
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, paciente.getIdDoctor());
            stmt.setString(2, paciente.getNumero_seguro());
            
            filasAfectadas = stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return filasAfectadas;
    }
    
    public Paciente buscarNumeroSeguro(Paciente paciente) {
        // Buscar alumno por Codigo

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_POR_NUMERO_SEGURO);
            stmt.setString(1, paciente.getNumero_seguro());
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        try {
            // validar
            if (rs.next()) {
                // Leer valores del registro
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String fecha_nacimiento = rs.getString("fecha_nacimiento");
                String numero_seguro = rs.getString("numero_seguro");
                String curp = rs.getString("curp");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String instalacion = rs.getString("instalacion");
                String planta = rs.getString("planta");
                String cama = rs.getString("cama");
                String codigo = rs.getString("codigo");
                int idDoctor = rs.getInt("id_doctor");

                // Pasar variables al objeto de retorno
                paciente.setNombre(nombre);
                paciente.setPaterno(paterno);
                paciente.setMaterno(materno);
                paciente.setFecha_nacimiento(fecha_nacimiento);
                paciente.setNumero_seguro(numero_seguro);
                paciente.setCurp(curp);
                paciente.setFecha_ingreso(fecha_ingreso);
                paciente.setInstalacion(instalacion);
                paciente.setPlanta(planta);
                paciente.setCama(cama);
                paciente.setCodigo(codigo);
                paciente.setIdDoctor(idDoctor);
                
                return paciente;

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

}
