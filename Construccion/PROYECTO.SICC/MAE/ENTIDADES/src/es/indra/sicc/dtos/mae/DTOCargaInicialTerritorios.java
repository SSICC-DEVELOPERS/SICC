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
import java.util.Vector;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           07/1/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Viviana Bongiovanni
 */

public class DTOCargaInicialTerritorios extends DTOAuditableSICC  {
    private RecordSet nivelGeograficoPadre;
    private Vector niveles;

    public DTOCargaInicialTerritorios() {
    }

    public RecordSet getNivelGeograficoPadre() {
        return nivelGeograficoPadre;
    }

    public void setNivelGeograficoPadre(RecordSet newNivelGeograficoPadre) {
        nivelGeograficoPadre = newNivelGeograficoPadre;
    }

    public Vector getNiveles() {
        return niveles;
    }

    public void setNiveles(Vector newNiveles) {
        niveles = newNiveles;
    }
}