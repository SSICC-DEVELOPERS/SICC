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
//import es.indra.sicc.util.DTOBelcorp;
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

public class DTOCombosBusquedaMateriales extends DTOAuditableSICC {
//public class DTOCombosBusquedaMateriales extends DTOBelcorp {

    private RecordSet marcasProducto;
    private RecordSet unidadNegocio;
    private RecordSet negocio;
    private RecordSet generico;
    private RecordSet supergenerico;

    public DTOCombosBusquedaMateriales() {
    }

    public RecordSet getMarcasProducto()
    {
		return marcasProducto;
    }

    public void setMarcasProducto(RecordSet newMarcasProducto)
    {
		marcasProducto = newMarcasProducto;
    }

    public RecordSet getUnidadNegocio()
    {
        return unidadNegocio;
    }

    public void setUnidadNegocio(RecordSet newUnidadNegocio)
    {
        unidadNegocio = newUnidadNegocio;
    }

    public RecordSet getNegocio()
    {
        return negocio;
    }

    public void setNegocio(RecordSet newNegocio)
    {
        negocio = newNegocio;
    }

    public RecordSet getGenerico()
    {
        return generico;
    }

    public void setGenerico(RecordSet newGenerico)
    {
        generico = newGenerico;
    }

    public RecordSet getSupergenerico()
    {
        return supergenerico;
    }

    public void setSupergenerico(RecordSet newSupergenerico)
    {
        supergenerico = newSupergenerico;
    }

 
}