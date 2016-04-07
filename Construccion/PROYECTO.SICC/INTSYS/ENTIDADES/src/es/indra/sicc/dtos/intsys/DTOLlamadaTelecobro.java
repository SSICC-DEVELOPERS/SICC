package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOLlamadaTelecobro extends DTOBelcorp  {
    private Long oidCliente;
    private String telefono1;
    private Long oidZona;
    private Long oidRegion;
    private Long oidUsuarioCobranzas;
    private Long oidSubTipoCliente;
    private Long oidPeriodo;
    private Long oidEtapaDeuda;
    private Long prioridad;
    private Long oidTipoCargoAbono;

    public DTOLlamadaTelecobro() {
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidRegion() {
        return oidRegion;
    }

    public void setOidRegion(Long oidRegion) {
        this.oidRegion = oidRegion;
    }

    public Long getOidUsuarioCobranzas() {
        return oidUsuarioCobranzas;
    }

    public void setOidUsuarioCobranzas(Long oidUsuarioCobranzas) {
        this.oidUsuarioCobranzas = oidUsuarioCobranzas;
    }

    public Long getOidSubTipoCliente() {
        return oidSubTipoCliente;
    }

    public void setOidSubTipoCliente(Long oidSubTipoCliente) {
        this.oidSubTipoCliente = oidSubTipoCliente;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidEtapaDeuda() {
        return oidEtapaDeuda;
    }

    public void setOidEtapaDeuda(Long oidEtapaDeuda) {
        this.oidEtapaDeuda = oidEtapaDeuda;
    }

    public Long getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Long prioridad) {
        this.prioridad = prioridad;
    }

    public Long getOidTipoCargoAbono() {
        return oidTipoCargoAbono;
    }

    public void setOidTipoCargoAbono(Long oidTipoCargoAbono) {
        this.oidTipoCargoAbono = oidTipoCargoAbono;
    }
}