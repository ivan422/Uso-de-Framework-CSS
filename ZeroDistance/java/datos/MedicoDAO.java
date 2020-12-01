
package datos;

import domain.Medico;
import domain.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MedicoDAO {
    
    private static final String SQL_SELECT = "SELECT id, nombre, paterno, materno, fecha_nacimiento, numero_empleado, area, usuario, contrasena FROM doctor";
    
    private static final String SQLSELECTPORID = "SELECT id, nombre, paterno,"
            + "materno, fecha_nacimiento, numero_empleado, area, usuario, contrasena FROM doctor WHERE id = ?";
    
    private static final String SQL_INSERT = "INSERT INTO doctor(nombre, paterno,materno, fecha_nacimiento, numero_empleado, area, usuario, contrasena) VALUES (?,?,?,?,?,?,?,?)";
    
    private static final String SQL_DELETE = "DELETE FROM doctor WHERE numero_empleado=?";
    
    private static final String SQL_SELECT_POR_NUMERO = "SELECT id FROM doctor WHERE numero_Empleado = ?";
    
    public List<Medico> consultar(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Medico medico;
        List<Medico> medicos = new ArrayList<>();
        
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String paterno = resultSet.getString("paterno");
                String materno = resultSet.getString("materno");
                String fechaNacimiento = resultSet.getString("fecha_nacimiento");
                String numeroEmpleado = resultSet.getString("numero_empleado");
                String area = resultSet.getString("area");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");
                
                medico = new Medico(id,nombre,paterno,materno,fechaNacimiento,numeroEmpleado,area,usuario,contrasena);
                medicos.add(medico);
            }
        } catch (SQLException ex) {
        }finally{
            try {
                Conexion.close(resultSet);
                Conexion.close(preparedStatement);
                Conexion.close(connection);
            } catch (SQLException ex) {
            }
        }
         
        return medicos;
    }
    
    public Medico buscar(Medico medico) {
        // Buscar medico por ID

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORID);
            
            stmt.setInt(1, medico.getId());
            
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
                String fechaNacimiento = rs.getString("fecha_nacimiento");
                String numeroEmpleado = rs.getString("numero_empleado");
                String area = rs.getString("area");
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");

                
                // Pasar variables al objeto de retorno
                medico.setNombre(nombre);
                medico.setPaterno(paterno);
                medico.setMaterno(materno);
                medico.setFechaNacimiento(fechaNacimiento);
                medico.setNumeroEmpleado(numeroEmpleado);
                medico.setArea(area);
                medico.setUsuario(usuario);
                medico.setContrasena(contrasena);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return medico;
    }
    
    public int insertar(Medico medico) throws SQLException {
    
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();
            
            stmt = conn.prepareStatement(SQL_INSERT); 
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getPaterno());
            stmt.setString(3, medico.getMaterno());
            stmt.setString(4, medico.getFechaNacimiento());
            stmt.setString(5, medico.getNumeroEmpleado());
            stmt.setString(6, medico.getArea());
            stmt.setString(7, medico.getUsuario());
            stmt.setString(8, medico.getContrasena());
            
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
    
    public int eliminar(Medico medico) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int filasAfectadas = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, medico.getNumeroEmpleado());

            filasAfectadas = stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return filasAfectadas;
    }
    
    public Medico buscarNumeroEmpleado(Medico medico) {
        // Buscar medico por ID

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_POR_NUMERO);
            
            stmt.setString(1, medico.getNumeroEmpleado());
            
            rs = stmt.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        try {
            // validar
            if (rs.next()) {
                // Leer valores del registro
                int id = rs.getInt("id");
                

                
                // Pasar variables al objeto de retorno
                medico.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return medico;
    }

}
