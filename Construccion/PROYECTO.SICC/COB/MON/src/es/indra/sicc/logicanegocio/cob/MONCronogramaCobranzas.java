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
package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOGenerarCronogramaCOBPeriodo;
import es.indra.sicc.dtos.cob.DTOCronogramaGenerado;
import es.indra.sicc.dtos.cob.DTOEBuscarCronogramaCOBPeriodo;

public interface MONCronogramaCobranzas extends EJBObject 
{
  DTOSalida consultarEtapasCobranza(DTOBelcorp dto) throws MareException, RemoteException;

  void guardarCronogramaCobranzas(DTOColeccion dto) throws MareException, RemoteException;

  DTOSalida obtenerEtapasUsuarioCOB(DTOOID dto) throws MareException, RemoteException;

  DTOCronogramaGenerado generarCronogramaCobranzas(DTOGenerarCronogramaCOBPeriodo dto) throws MareException, RemoteException;

  DTOSalida buscarCronogramaCOBPeriodo(DTOEBuscarCronogramaCOBPeriodo dto) throws MareException, RemoteException;
}