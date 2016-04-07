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

/**
 * Sistema:		Belcorp
 * Modulo:	   	INT 
 * Fecha:		19/01/2007
 * @version		1.0
 * @autor		SPLATAS
 */
 
package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;

public interface MONINTPTL extends EJBObject 
{
    void enviarPedidosFacturadosAPicar(DTOOID dtoE) throws RemoteException, MareException;

    void recepcionarInformacionEtiquetas(DTOOID dtoE) throws RemoteException, MareException;

    void recepcionarPedidosProcesadosPTL(DTOOID dtoE) throws RemoteException, MareException;

  void enviarMapaAnaquelesProductoBatch(DTOOID dtoE) throws RemoteException, MareException;

  DTOSalidaBatch enviarMapaAnaquelesProducto(DTOBatch dtoE) throws RemoteException, MareException;

  void recepcionarMapaAnaquelesProducto(DTOAsignacionProductoAnaquelCabecera dtoe) throws RemoteException, MareException;
}