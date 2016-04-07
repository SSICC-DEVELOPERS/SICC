package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTODatosGerentes extends DTOBelcorp  {
    private String codCliente;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String codBuzonZona;
    private String codBuzonRegion;
    private Date fechaNacimiento;
    private String codTipoCliente;
    private Long oidSubTipoCliente;

    public DTODatosGerentes() {
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

    public String getCodBuzonZona() {
        return codBuzonZona;
    }

    public void setCodBuzonZona(String codBuzonZona) {
        this.codBuzonZona = codBuzonZona;
    }

    public String getCodBuzonRegion() {
        return codBuzonRegion;
    }

    public void setCodBuzonRegion(String codBuzonRegion) {
        this.codBuzonRegion = codBuzonRegion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(String codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public Long getOidSubTipoCliente() {
        return oidSubTipoCliente;
    }

    public void setOidSubTipoCliente(Long oidSubTipoCliente) {
        this.oidSubTipoCliente = oidSubTipoCliente;
    }
}
