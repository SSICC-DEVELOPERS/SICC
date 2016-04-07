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
package es.indra.sicc.entidades.msg;

import es.indra.sicc.cmn.negocio.auditoria.EJBLocalObjectSICCAuditable;

import java.sql.Timestamp;

import javax.ejb.EJBLocalObject;

public interface BuzonMensajesLocal extends EJBLocalObjectSICCAuditable  {
    public Long getOid() ;

	public void setOid(Long newOid) ;

	public Long getNumeroSecuencial() ;

	public void setNumeroSecuencial(Long newNumeroSecuencial) ;

	public String getDatoVariable10() ;

	public void setDatoVariable10(String newDatoVariable10) ;

	public String getDatoVariable11() ;

	public void setDatoVariable11(String newDatoVariable11) ;

	public String getDatoVariable12() ;

	public void setDatoVariable12(String newDatoVariable12) ;

	public String getDatoVariable13() ;

	public void setDatoVariable13(String newDatoVariable13) ;

	public String getDatoVariable14() ;

	public void setDatoVariable14(String newDatoVariable14) ;

	public String getDatoVariable15() ;

	public void setDatoVariable15(String newDatoVariable15) ;

	public String getDatoVariable16() ;

	public void setDatoVariable16(String newDatoVariable16) ;

	public String getDatoVariable17() ;

	public void setDatoVariable17(String newDatoVariable17) ;

	public String getDatoVariable18() ;

	public void setDatoVariable18(String newDatoVariable18) ;

	public String getDatoVariable19() ;

	public void setDatoVariable19(String newDatoVariable19) ;

	public String getDatoVariable20() ;

	public void setDatoVariable20(String newDatoVariable20) ;



	public Long getActivo() ;

	public void setActivo(Long newActivo) ;



	public Long getOidPeriodo() ;

	public void setOidPeriodo(Long newOidPeriodo) ;

	public Long getOidCliente() ;

	public void setOidCliente(Long newOidCliente) ;

	public Long getOidMensaje() ;

	public void setOidMensaje(Long newOidMensaje) ;



	public Long getModulo() ;

	public void setModulo(Long newModulo) ;

	public String getNombre1Cliente() ;

	public void setNombre1Cliente(String newNombre1Cliente) ;

	public String getNombre2Cliente() ;

	public void setNombre2Cliente(String newNombre2Cliente) ;

	public String getApellido1Cliente() ;

	public void setApellido1Cliente(String newApellido1Cliente) ;

	public String getApellido2Cliente() ;

	public void setApellido2Cliente(String newApellido2Cliente) ;

	public String getApellidoCasadaCliente() ;

	public void setApellidoCasadaCliente(String newApellidoCasadaCliente) ;

	public String getDatoVariable1() ;

	public void setDatoVariable1(String newDatoVariable1) ;

	public String getDatoVariable2() ;

	public void setDatoVariable2(String newDatoVariable2) ;

	public String getDatoVariable3() ;

	public void setDatoVariable3(String newDatoVariable3) ;

	public String getDatoVariable4() ;

	public void setDatoVariable4(String newDatoVariable4) ;

	public String getDatoVariable5() ;

	public void setDatoVariable5(String newDatoVariable5) ;

	public String getDatoVariable6() ;

	public void setDatoVariable6(String newDatoVariable6) ;

	public String getDatoVariable7() ;

	public void setDatoVariable7(String newDatoVariable7) ;

	public String getDatoVariable8() ;

	public void setDatoVariable8(String newDatoVariable8) ;

	public String getDatoVariable9() ;

	public void setDatoVariable9(String newDatoVariable9) ;



	public Long getNumeroLoteImpresion() ;

	public void setNumeroLoteImpresion(Long newNumeroLoteImpresion) ;





	public java.sql.Timestamp getFechaGrabacion() ;

	public void setFechaGrabacion(java.sql.Timestamp newFechaGrabacion) ;

	public java.sql.Timestamp getFechaImpresion() ;

	public void setFechaImpresion(java.sql.Timestamp newFechaImpresion) ;

	public Long getEsConsultora() ;

	public void setEsConsultora(Long newEsConsultora) ;

    Long getEstadoMensaje();

    void setEstadoMensaje(Long newEstadoMensaje);
}