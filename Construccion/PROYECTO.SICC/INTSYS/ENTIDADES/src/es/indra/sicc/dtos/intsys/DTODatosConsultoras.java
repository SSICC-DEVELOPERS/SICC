package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;
import java.math.BigDecimal;

public class DTODatosConsultoras extends DTOBelcorp  {
    private Long oidCliente;
    private String codCliente;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String codBuzon;
    private String codSeccion;
    private String codTerritorio;
    private Long oidMovimientosCCA;
    private Date fechaDocumento;
    private String indIncobrable;
    private BigDecimal saldo;

    public DTODatosConsultoras() {
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCodBuzon() {
        return codBuzon;
    }

    public void setCodBuzon(String codBuzon) {
        this.codBuzon = codBuzon;
    }

    public String getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(String codSeccion) {
        this.codSeccion = codSeccion;
    }

    public String getCodTerritorio() {
        return codTerritorio;
    }

    public void setCodTerritorio(String codTerritorio) {
        this.codTerritorio = codTerritorio;
    }

    public Long getOidMovimientosCCA() {
        return oidMovimientosCCA;
    }

    public void setOidMovimientosCCA(Long oidMovimientosCCA) {
        this.oidMovimientosCCA = oidMovimientosCCA;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getIndIncobrable() {
        return indIncobrable;
    }

    public void setIndIncobrable(String indIncobrable) {
        this.indIncobrable = indIncobrable;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
