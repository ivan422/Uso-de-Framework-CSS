package domain;

/**
 *
 * @author jesus
 */
public class Administrador {
    
    private int id;
    private String nombre;
    private String paterno;
    private String materno;
    private String fechaNacimiento;
    private String numeroEmpleado;
    private String usuario;
    private String contrasena;

    public Administrador() {
    }

    //Constructor para eliminar
    public Administrador(int id) {
        this.id = id;
    }

    //Constructor para modificar
    public Administrador(String nombre, String paterno, String materno, String fechaNacimiento, String numeroEmpleado, String usuario, String contrasena) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroEmpleado = numeroEmpleado;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //Constructor para consultar
    public Administrador(int id, String nombre, String paterno, String materno, String fechaNacimiento, String numeroEmpleado, String usuario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroEmpleado = numeroEmpleado;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", fechaNacimiento=" + fechaNacimiento + ", numeroEmpleado=" + numeroEmpleado + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
    
    
}
