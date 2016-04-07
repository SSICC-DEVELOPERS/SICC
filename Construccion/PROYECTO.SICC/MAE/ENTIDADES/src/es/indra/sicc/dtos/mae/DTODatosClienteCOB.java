package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTODatosClienteCOB extends DTOAuditableSICC  {
    
    private String codigoCliente;
    private String apellido1;
    private String apellido2;
    private String apellidoCasada;
    private String nombre1;
    private String nombre2;
    private String tratamiento;
    private Date fechaNacimiento;
    private String tipoVia;
    private String nombreVia;
    private Integer numeroPrincipal;
    private String puerta;
    private String estatus;
    private Boolean indicadorActivo;


    public DTODatosClienteCOB() {
    }


    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }


    public String getCodigoCliente() {
        return codigoCliente;
    }


    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    public String getApellido1() {
        return apellido1;
    }


    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }


    public String getApellido2() {
        return apellido2;
    }


    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }


    public String getApellidoCasada() {
        return apellidoCasada;
    }


    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }


    public String getNombre1() {
        return nombre1;
    }


    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }


    public String getNombre2() {
        return nombre2;
    }


    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }


    public String getTratamiento() {
        return tratamiento;
    }


    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }


    public String getTipoVia() {
        return tipoVia;
    }


    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }


    public String getNombreVia() {
        return nombreVia;
    }


    public void setNumeroPrincipal(Integer numeroPrincipal) {
        this.numeroPrincipal = numeroPrincipal;
    }


    public Integer getNumeroPrincipal() {
        return numeroPrincipal;
    }


    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }


    public String getPuerta() {
        return puerta;
    }


    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }


    public String getEstatus() {
        return estatus;
    }


    public void setIndicadorActivo(Boolean indicadorActivo) {
        this.indicadorActivo = indicadorActivo;
    }


    public Boolean getIndicadorActivo() {
        return indicadorActivo;
    }
}