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
package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           19/1/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Viviana Bongiovanni
 */

public class DTOCombosKit  extends DTOAuditableSICC {
    private RecordSet marcas;
    private RecordSet unidadesNegocio;
    private RecordSet negocio;
    private RecordSet genericos;
    private RecordSet supergenericos;
    private RecordSet lineas;
    private RecordSet unidadesMedida;
    private RecordSet estatus;
    private RecordSet canales;
	private RecordSet formasPago;

    public DTOCombosKit() {
        super();
    }

    public RecordSet getMarcas() {
		return marcas;
    }

    public void setMarcas(RecordSet newMarcas) {
		marcas = newMarcas;
    }

    public RecordSet getUnidadesNegocio() {
        return unidadesNegocio;
    }

    public void setUnidadesNegocio(RecordSet newUnidadesNegocio) {
        unidadesNegocio = newUnidadesNegocio;
    }

    public RecordSet getNegocio() {
        return negocio;
    }

    public void setNegocio(RecordSet newNegocio) {
        negocio = newNegocio;
    }

    public RecordSet getGenericos() {
        return genericos;
    }

    public void setGenericos(RecordSet newGenericos) {
        genericos = newGenericos;
    }

    public RecordSet getSupergenericos() {
        return supergenericos;
    }

    public void setSupergenericos(RecordSet newSupergenericos) {
        supergenericos = newSupergenericos;
    }

    public RecordSet getLineas() {
        return lineas;
    }

    public void setLineas(RecordSet newLineas) {
        lineas = newLineas;
    }



    public RecordSet getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(RecordSet newUnidadesMedida) {
        unidadesMedida = newUnidadesMedida;
    }

    public RecordSet getEstatus() {
        return estatus;
    }

    public void setEstatus(RecordSet newEstatus) {
        estatus = newEstatus;
    }

    public RecordSet getCanales() {
        return canales;
    }

    public void setCanales(RecordSet newCanales) {
        canales = newCanales;
    }

	public RecordSet getFormasPago() {
		return formasPago;
	}

	public void setFormasPago(RecordSet newFormasPago) {
		formasPago = newFormasPago;
	}
}