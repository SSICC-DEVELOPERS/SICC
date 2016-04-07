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

package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;

public interface MONINTPTLLocal extends EJBLocalObject 
{
  DTOSalidaBatch enviarMapaAnaquelesProducto(DTOBatch dtoE) throws MareException;

  void enviarMapaAnaquelesProductoBatch(DTOOID dtoE) throws MareException;

  void enviarPedidosFacturadosAPicar(DTOOID dtoE) throws MareException;

  void recepcionarInformacionEtiquetas(DTOOID dtoE) throws MareException;

  void recepcionarMapaAnaquelesProducto(DTOAsignacionProductoAnaquelCabecera dtoe) throws MareException;

  void recepcionarPedidosProcesadosPTL(DTOOID dtoE) throws MareException;
}