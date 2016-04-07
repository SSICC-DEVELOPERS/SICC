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
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.EJBObject;


public interface MONAPE extends EJBObject {
	  DTOFACConsolidado[] balancearAreaChequeo(DTOFACConsolidado[] listaConsolidados) throws RemoteException, MareException;
    
    void imprimirEtiquetasInduccionPTL (ArrayList lstEtiquetasAImprimir) throws RemoteException, MareException;
    
    void crearListasPicadoInduccionPTL (DTOListaPicadoInduccionPTL dtoE) throws RemoteException, MareException;
}