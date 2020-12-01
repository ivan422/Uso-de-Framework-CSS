
package domain;


public class Estado {
    
    private int id;
    private int id_paciente;
    private int id_doctor;
    private String estado;
    private String fecha;
    
    public Estado(){
        
    }
    
    public Estado(int id){
        this.id=id;
    }
    
    public Estado(int id_paciente, int id_doctor, String estado, String fecha){
        this.id_paciente=id_paciente;
        this.id_doctor=id_doctor;
        this.estado=estado;
        this.fecha=fecha;
    }
    
    public Estado(int id, int id_paciente, int id_doctor, String estado, String fecha){
        this.id=id;
        this.id_paciente=id_paciente;
        this.id_doctor=id_doctor;
        this.estado=estado;
        this.fecha=fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
