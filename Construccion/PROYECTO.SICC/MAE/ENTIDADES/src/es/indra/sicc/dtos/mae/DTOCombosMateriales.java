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

import java.util.Vector;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


/**
 * Sistema:         Belcorp
 * Modulo:           MAE
 * Submódulo:     Mantenimiento de Materiales
 * Componente:   DTO's
 * Fecha:             02/12/2003
 * Observaciones:     
 *                    
 * @version          1.0
 * @autor             Luis Ramos
 */

public class DTOCombosMateriales extends DTOCombosBusquedaMateriales {

    private RecordSet lineaProducto;
    private RecordSet unidadesMedida;
    private RecordSet estatus;
	private RecordSet formasPago;

    public DTOCombosMateriales() {
    }

    public DTOCombosMateriales(DTOCombosBusquedaMateriales dto) {
        this.setMarcasProducto(dto.getMarcasProducto());
        this.setUnidadNegocio(dto.getUnidadNegocio());
        this.setNegocio(dto.getNegocio());
        this.setGenerico(dto.getGenerico());
        this.setSupergenerico(dto.getSupergenerico());
    }

    public RecordSet getLineaProducto()
    {
        return lineaProducto;
    }

    public void setLineaProducto(RecordSet newLineaProducto)
    {
        lineaProducto = newLineaProducto;
    }

    public RecordSet getUnidadesMedida()
    {
        return unidadesMedida;
    }

    public void setUnidadesMedida(RecordSet newUnidadesMedida)
    {
        unidadesMedida = newUnidadesMedida;
    }

    public RecordSet getEstatus()
    {
        return estatus;
    }

    public void setEstatus(RecordSet newEstatus)
    {
        estatus = newEstatus;
    }

	public RecordSet getFormasPago() {
		return formasPago;
	}

	public void setFormasPago(RecordSet newFormasPago) {
		formasPago = newFormasPago;
	}
}