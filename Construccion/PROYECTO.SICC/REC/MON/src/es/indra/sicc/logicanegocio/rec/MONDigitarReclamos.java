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
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.rec.DTOCargaInicialDigitarReclamos;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;

public interface MONDigitarReclamos extends EJBObject 
{
    DTOCargaInicialDigitarReclamos cargaInicial(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerCodigosTipoOperacion(DTOOID dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTiposMovimiento(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTiposMovimientoRecarga(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerMotivosDevolucionOperacion(DTOOID dtoE) throws MareException, RemoteException;

    DTOSalida obtenerMotivosDevolucionOperacionRecarga(DTOOID dtoE) throws MareException, RemoteException;

    void guardarReclamoDigitado(DTOReclamo dtoE) throws MareException, RemoteException;

    DTOReclamo guardarCabeceraReclamoDigitado(DTOReclamo cabecera) throws MareException , RemoteException;

    void guardarOperacionReclamoDigitado(DTOOperacionReclamo operacion, Long cabecera) throws MareException, RemoteException;

    void guardarLineaOperacionReclamoDigitado(DTOLineaOperacion lineaOperacion, Long operacion) throws RemoteException, MareException;

    DTOSalida existenReclamosDigitados(DTOBelcorp dtoe) throws MareException, RemoteException;

    DTOSalida obtenerReclamosDigitados(DTOBelcorp dtoe) throws MareException, RemoteException;

    void EliminaReclamosDigitados(DTOBelcorp dtoe) throws MareException, RemoteException;
    
    
    
}