/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import java.util.ArrayList;

public class TaponAPE implements IAPE {
    
    public TaponAPE() {
    }
    
    public DTOFACConsolidado[] balancearAreaChequeo(DTOFACConsolidado[] listaConsolidados) throws MareException{
		String mensaje = "*** Proceso no implementado: Balanceo del Área de Chequeo ***";
		UtilidadesLog.info(mensaje);
		return listaConsolidados;
	}
    
    public void imprimirEtiquetasInduccionPTL(ArrayList lstEtiquetasAImprimir) throws MareException  {
        UtilidadesLog.info("TaponAPE.imprimirEtiquetasInduccionPTL(ArrayList lstEtiquetasAImprimir).");
    }
    
    public void crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoE) throws MareException  {
        UtilidadesLog.info("TaponAPE.crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoE).");
    }
    
    
}