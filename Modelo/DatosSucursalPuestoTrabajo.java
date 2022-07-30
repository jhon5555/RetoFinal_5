package Modelo;


public class DatosSucursalPuestoTrabajo {
    private int idSucursal;
    private String nombreSucursal;
    private int idPuestoTrabajo;
    private String nombrePuestoTrabajo;
    private float salario;

    public DatosSucursalPuestoTrabajo() {
        this.idSucursal = 0;
        this.nombreSucursal = "";
        this.idPuestoTrabajo = 0;
        this.nombrePuestoTrabajo = "";
        this.salario = 0.0f;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public int getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(int idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public String getNombrePuestoTrabajo() {
        return nombrePuestoTrabajo;
    }

    public void setNombrePuestoTrabajo(String nombrePuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
    
}
