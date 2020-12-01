
package domain;


public class Medico {
    
    private int id;
    private String nombre;
    private String paterno;
    private String materno;
    private String fechaNacimiento;
    private String numeroEmpleado;
    private String area;
    private String usuario;
    private String contrasena;

    public Medico() {
    }

    //Constructor para eliminar
    public Medico(int id) {
        this.id = id;
    }

    //Constructor para modificar
    public Medico(String nombre, String paterno, String materno, String fechaNacimiento, String numeroEmpleado, String area, String usuario, String contrasena) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroEmpleado = numeroEmpleado;
        this.area = area;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //Constructor para consultar
    public Medico(int id, String nombre, String paterno, String materno, String fechaNacimiento, String numeroEmpleado, String area, String usuario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroEmpleado = numeroEmpleado;
        this.area = area;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Medico(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }


    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
        return "Medico{" + "id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", fechaNacimiento=" + fechaNacimiento + ", numeroEmpleado=" + numeroEmpleado + ", area=" + area + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
    
}
