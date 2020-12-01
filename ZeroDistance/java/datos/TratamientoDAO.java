
package datos;

import domain.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TratamientoDAO {
    
    private static final String SQLSELECTPORIDPACIENTE = "SELECT id, id_doctor, tratamiento, fecha FROM tratamiento WHERE id_paciente = ?";
    
    private static final String SQLINSERT = "INSERT INTO tratamiento(id_paciente, id_doctor,"
            + "tratamiento, fecha) VALUES (?,?,?,?)";
    
    public int insertar(Tratamiento tratamiento) throws SQLException {
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();
            
            stmt = conn.prepareStatement(SQLINSERT); 
            stmt.setInt(1, tratamiento.getId_paciente());
            stmt.setDouble(2, 1);
            stmt.setString(3, tratamiento.getTratamiento());
            stmt.setString(4, tratamiento.getFecha());
            
            filasAfectadas = stmt.executeUpdate();  
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {           
            stmt.close();
            conn.close();
        }
        return filasAfectadas;    
    }
    
    public List<Tratamiento> seleccionarPorPaciente(int idPaciente) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Tratamiento tratamientoE;
        List<Tratamiento> tratamientos = new ArrayList();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORIDPACIENTE);
            stmt.setInt(1, idPaciente);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                // Leer valores del registro
                int id = rs.getInt("id");
                int id_doctor = rs.getInt("id_doctor");
                String estado = rs.getString("tratamiento");
                String fecha = rs.getString("fecha");
                
                tratamientoE = new Tratamiento(id, idPaciente, id_doctor, estado, fecha);

                //Ingresa cada paciente al ArrayList
                tratamientos.add(tratamientoE);
                
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
        
        return tratamientos;
    }
    
    public Tratamiento ultimoEstado(int id_paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int mayor = 0;
        Tratamiento tratamientoE = new Tratamiento();
        List<Tratamiento> tratamientos = new ArrayList();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORIDPACIENTE);
            stmt.setInt(1, id_paciente);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");

                if (id > mayor) {
                    mayor = id;
                    int id_doctor = rs.getInt("id_doctor");
                    String tratamiento = rs.getString("tratamiento");
                    String fecha = rs.getString("fecha");
                    
                    tratamientoE.setId(id);
                    tratamientoE.setId_paciente(id_paciente);
                    tratamientoE.setId_doctor(id_doctor);
                    tratamientoE.setTratamiento(tratamiento);
                    tratamientoE.setFecha(fecha);
                    
                    tratamientoE = new Tratamiento(id, id_paciente, id_doctor, tratamiento, fecha);
                }


            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
            }
        }

        return tratamientoE;
    }
    
}
