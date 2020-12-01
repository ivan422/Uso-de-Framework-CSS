
package domain;


public class Tratamiento {
    
    private int id;
    private int id_paciente;
    private int id_doctor;
    private String tratamiento;
    private String fecha;
    
    public Tratamiento(){
        
    }
    
    public Tratamiento(int id){
        this.id=id;
    }
    
    public Tratamiento(int id_paciente, int id_doctor, String tratamiento, String fecha){
        this.id_paciente=id_paciente;
        this.id_doctor=id_doctor;
        this.tratamiento=tratamiento;
        this.fecha=fecha;
    }
    
    public Tratamiento(int id, int id_paciente, int id_doctor, String tratamiento, String fecha){
        this.id=id;
        this.id_paciente=id_paciente;
        this.id_doctor=id_doctor;
        this.tratamiento=tratamiento;
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

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return "Tratamiento{" + "id=" + id + ", id_paciente=" + id_paciente + ", id_doctor=" + id_doctor + ", "
                + "tratamiento=" + tratamiento + ", fecha=" + fecha + '}';
    }
    
}
