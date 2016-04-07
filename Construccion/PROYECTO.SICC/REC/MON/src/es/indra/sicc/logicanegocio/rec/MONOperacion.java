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
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.rec.DTOOperacion;
import es.indra.sicc.dtos.rec.DTOBusqueda;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.mare.common.exception.MareException;

public interface MONOperacion extends EJBObject 
{
    void insertarOperacion(DTOOperacion dtoE) throws MareException, RemoteException;

    void insertarTiposOperacion(DTOOperacion dtoE) throws MareException, RemoteException;

    DTOSalida obtenerOperaciones(DTOBusqueda dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTiposOperacion(DTOOID dtoE) throws RemoteException, MareException;

    DTOSalida obtenerMovimientoAlmacen(DTOBelcorp dtoE) throws MareException, RemoteException;


    DTOSalida obtenerMotivosBloqueo(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerPrecioEnvia(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerPrecios(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTipoSolicitud(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerAlmacen(DTOBelcorp dtoE) throws MareException , RemoteException;

    DTOSalida obtenerMensajes(DTOBelcorp dtoE) throws MareException , RemoteException;

    void  eliminarOperaciones(DTOOIDs dtoE) throws MareException , RemoteException;

    DTOOperacion detalleOperaciones(DTOOID dtoE) throws MareException, RemoteException;

    void eliminarTiposOperacion(Long oidOperacion) throws MareException, RemoteException;

    DTOSalida obtenerTipoSolicitudGenera(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida obtenerTipoOperacionREP(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtenerTipoSolicitudNoNegativa(DTOBelcorp dtoE) throws RemoteException, MareException;

    DTOSalida obtenerTipoSolicitudNegativa(DTOBelcorp dtoE) throws RemoteException, MareException;

    DTOSalida obtenerOperacionesDescLarga(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida recargaTipoOperacion(DTOOID dto) throws MareException, RemoteException;
    
    DTOSalida obtenerOperacionesAnulacion(DTOBelcorp dto) throws MareException, RemoteException;
    
    DTOSalida obtenerOperacionesPremio(DTOBelcorp dto) throws MareException, RemoteException;
    
    DTOSalida obtenerParamIntPais(DTOBelcorp dtoE) throws MareException, RemoteException;
    
}