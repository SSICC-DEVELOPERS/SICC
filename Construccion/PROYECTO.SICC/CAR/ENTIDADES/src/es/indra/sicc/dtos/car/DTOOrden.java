/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOOrden  extends DTOAuditableSICC{
    private Long oid;
    private Long numSolicitud;
    private String codGerenteZona;
    private String comunicacion;

	public DTOOrden() {
	}

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long oid)
    {
        this.oid = oid;
    }

    public Long getNumSolicitud()
    {
        return numSolicitud;
    }

    public void setNumSolicitud(Long numSolicitud)
    {
        this.numSolicitud = numSolicitud;
    }

    public String getCodGerenteZona()
    {
        return codGerenteZona;
    }

    public void setCodGerenteZona(String codGerenteZona)
    {
        this.codGerenteZona = codGerenteZona;
    }

    public String getComunicacion()
    {
        return comunicacion;
    }

    public void setComunicacion(String comunicacion)
    {
        this.comunicacion = comunicacion;
    }

	
}