package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTODatosRuvContaCentral extends DTOBelcorp{

    private Long oid;
    private String identidadFiscal;
    private String identidadNacional;
    private Long oidTipoDocumento;
    private String nombre;

    public DTODatosRuvContaCentral() {
    }


    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getIdentidadFiscal() {
        return identidadFiscal;
    }

    public void setIdentidadFiscal(String identidadFiscal) {
        this.identidadFiscal = identidadFiscal;
    }

    public String getIdentidadNacional() {
        return identidadNacional;
    }

    public void setIdentidadNacional(String identidadNacional) {
        this.identidadNacional = identidadNacional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getOidTipoDocumento() {
        return oidTipoDocumento;
    }

    public void setOidTipoDocumento(Long oidTipoDocumento) {
        this.oidTipoDocumento = oidTipoDocumento;
    }
}
