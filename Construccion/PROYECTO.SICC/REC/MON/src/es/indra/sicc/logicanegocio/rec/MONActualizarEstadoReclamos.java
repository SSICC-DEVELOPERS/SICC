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
*/

package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONActualizarEstadoReclamos extends EJBObject  {
    void actualizarEstadoReclamosFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws MareException, RemoteException;

    void actualizarEstadoReclamosRevertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws MareException, RemoteException;
}