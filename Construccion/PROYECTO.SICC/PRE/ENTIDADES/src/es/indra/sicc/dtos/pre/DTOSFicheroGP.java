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
 *
 */ 
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.lang.String;

/**
 * Sistema:           Belcorp
 * Modulo:            PRE
 * Submódulo:         DescargarGuiaProductos
 * Componente:        DTO
 * Fecha:             02/03/2004
 * Descripcion:       
 * @version           1.0
 * @autor             Javier Montano
 */
 
public class DTOSFicheroGP extends DTOAuditableSICC  {
	private String indicadorFin;
	private RecordSet resultado;

	public DTOSFicheroGP() {
	}

	public String getIndicadorFin() {
		return this.indicadorFin;
	}

	public void setIndicadorFin(String indicadorFin) {
		this.indicadorFin = indicadorFin;
	}

	public RecordSet getResultado () {
		return this.resultado;
	}

	public void setResultado (RecordSet resultado) {
		this.resultado = resultado;
	}
}