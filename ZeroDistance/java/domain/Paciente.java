
package domain;


public class Paciente {
    
    private int id;
    private String nombre;
    private String paterno;
    private String materno;
    private String fecha_nacimiento;
    private String numero_seguro;
    private String curp;
    private String fecha_ingreso;
    private String instalacion;
    private String planta;
    private String cama;
    private String codigo;
    private int idDoctor;
    
    

    public Paciente() {
    }

    public Paciente(int id) {
        this.id = id;
    }

    public Paciente(int id, String nombre, String paterno, String materno, String fecha_nacimiento, String numero_seguro, String curp, String fecha_ingreso, String instalacion, String planta, String cama, String codigo, int idDoctor) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.numero_seguro = numero_seguro;
        this.curp = curp;
        this.fecha_ingreso = fecha_ingreso;
        this.instalacion = instalacion;
        this.planta = planta;
        this.cama = cama;
        this.codigo = codigo;
        this.idDoctor = idDoctor;
    }

    public Paciente(String nombre, String paterno, String materno, String fecha_nacimiento, String numero_seguro, String curp, String fecha_ingreso, String instalacion, String planta, String cama, String codigo, int idDoctor) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.numero_seguro = numero_seguro;
        this.curp = curp;
        this.fecha_ingreso = fecha_ingreso;
        this.instalacion = instalacion;
        this.planta = planta;
        this.cama = cama;
        this.codigo = codigo;
        this.idDoctor = idDoctor;
    }

    public Paciente(String nombre, String paterno, String materno, String fecha_nacimiento, String numero_seguro, String curp, String fecha_ingreso, String instalacion, String planta, String cama, int idDoctor) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.numero_seguro = numero_seguro;
        this.curp = curp;
        this.fecha_ingreso = fecha_ingreso;
        this.instalacion = instalacion;
        this.planta = planta;
        this.cama = cama;
        this.idDoctor = idDoctor;
    }

    public Paciente(String numero_seguro, String curp) {
        this.numero_seguro = numero_seguro;
        this.curp = curp;
    }
    
    
    
    

    public Paciente(String codigo) {
        this.codigo = codigo;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNumero_seguro() {
        return numero_seguro;
    }

    public void setNumero_seguro(String numero_seguro) {
        this.numero_seguro = numero_seguro;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getCama() {
        return cama;
    }

    public void setCama(String cama) {
        this.cama = cama;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", fecha_nacimiento=" + fecha_nacimiento + ", numero_seguro=" + numero_seguro + ", curp=" + curp + ", fecha_ingreso=" + fecha_ingreso + ", instalacion=" + instalacion + ", planta=" + planta + ", cama=" + cama + ", codigo=" + codigo + ", idDoctor=" + idDoctor + '}';
    }
    
    
    


}