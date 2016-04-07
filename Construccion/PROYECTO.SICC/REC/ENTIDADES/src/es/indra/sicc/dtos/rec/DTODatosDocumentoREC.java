/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTODatosDocumentoREC extends DTOBelcorp  {

    private Date fecha;     
    private String periodo;  
    private Long oidTipoDocumento;  
    private Long oidMarca;   
    private Long oidCanal;

    public DTODatosDocumentoREC() {
        super();
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }

    public Long getOidTipoDocumento()
    {
        return oidTipoDocumento;
    }

    public void setOidTipoDocumento(Long oidTipoDocumento)
    {
        this.oidTipoDocumento = oidTipoDocumento;
    }

    public String getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }
}