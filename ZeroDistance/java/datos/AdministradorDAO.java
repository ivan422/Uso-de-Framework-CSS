package datos;

import domain.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus
 */
public class AdministradorDAO {
    
    private static final String SQL_SELECT = "SELECT id, nombre, paterno, materno, fecha_nacimiento, numero_empleado, usuario, contrasena FROM administrador";
    
    public List<Administrador> consultar(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Administrador administrador;
        List<Administrador> administradores = new ArrayList<>();
        
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
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");
                
                administrador = new Administrador(id,nombre,paterno,materno,fechaNacimiento,numeroEmpleado,usuario,contrasena);
                administradores.add(administrador);
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
         
        return administradores;
    }
    
    
}
