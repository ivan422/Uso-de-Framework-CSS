package datos;

import domain.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    private static final String SQLSELECTPORIDPACIENTE = "SELECT id, id_doctor, estado, fecha FROM estado WHERE id_paciente = ?";
    
    private static final String SQLINSERT = "INSERT INTO estado(id_paciente, id_doctor,"
            + "estado, fecha) VALUES (?,?,?,?)";
    
    public int insertar(Estado estado) throws SQLException {
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();
            
            stmt = conn.prepareStatement(SQLINSERT); 
            stmt.setInt(1, estado.getId_paciente());
            stmt.setDouble(2, 1);
            stmt.setString(3, estado.getEstado());
            stmt.setString(4, estado.getFecha());
            
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
    
    
    
    
    public List<Estado> seleccionarPorPaciente(int id_paciente) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Estado estadoE;
        List<Estado> estados = new ArrayList();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORIDPACIENTE);
            stmt.setInt(1, id_paciente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                // Leer valores del registro
                int id = rs.getInt("id");
                int id_doctor = rs.getInt("id_doctor");
                String estado = rs.getString("estado");
                String fecha = rs.getString("fecha");

                estadoE = new Estado(id, id_paciente, id_doctor, estado, fecha);

                //Ingresa cada paciente al ArrayList
                estados.add(estadoE);

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

        return estados;
    }

    public Estado ultimoEstado(int id_paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int mayor = 0;
        Estado estadoE = new Estado();
        List<Estado> estados = new ArrayList();

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
                    String estado = rs.getString("estado");
                    String fecha = rs.getString("fecha");
                    
                    estadoE.setId(id);
                    estadoE.setId_paciente(id_paciente);
                    estadoE.setId_doctor(id_doctor);
                    estadoE.setEstado(estado);
                    estadoE.setFecha(fecha);
                    
                    estadoE = new Estado(id, id_paciente, id_doctor, estado, fecha);
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

        return estadoE;
    }

}
