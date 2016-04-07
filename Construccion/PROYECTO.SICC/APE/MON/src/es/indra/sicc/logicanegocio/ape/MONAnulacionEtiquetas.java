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


package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;

public interface MONAnulacionEtiquetas extends EJBObject 
{
  DTOSalida buscarEtiquetas(DTOBusquedaEtiqueta dtoE) throws MareException, RemoteException;

  void anularEtiquetas(DTOOIDs dtoE) throws MareException, RemoteException;
}