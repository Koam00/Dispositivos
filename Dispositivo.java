package Dispositivos;
public class Dispositivo {
    private String tipo;
    private String serial;
    private String marca;
    private String estudiante;
    public Dispositivo(String tipo, String serial, String marca, String estudiante) {
        this.tipo = tipo;
        this.serial = serial;
        this.marca = marca;
        this.estudiante = estudiante;
    }
    public Dispositivo() {
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
    @Override
    public String toString() {
        return String.format("%s | Serial: %s | Marca: %s | Estudiante: %s", tipo, serial, marca, estudiante);
    }
}

  
    
