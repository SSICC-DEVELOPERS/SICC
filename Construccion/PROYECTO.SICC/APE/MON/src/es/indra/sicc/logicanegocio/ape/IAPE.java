
/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import java.util.ArrayList;

public interface IAPE  {

	public DTOFACConsolidado[] balancearAreaChequeo(DTOFACConsolidado[] listaConsolidados) throws MareException;
    
    public void imprimirEtiquetasInduccionPTL (ArrayList lstEtiquetasAImprimir) throws MareException;
    
    public void crearListasPicadoInduccionPTL (DTOListaPicadoInduccionPTL dtoE) throws MareException;
    
}


