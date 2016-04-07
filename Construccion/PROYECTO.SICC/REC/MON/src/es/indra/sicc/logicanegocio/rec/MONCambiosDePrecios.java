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
import es.indra.sicc.dtos.rec.DTOBuscarGeneracion;
import es.indra.sicc.dtos.rec.DTODatosPreRec;
import es.indra.sicc.dtos.rec.DTODetallePreRec;
import es.indra.sicc.dtos.rec.DTOGuardarGeneracion;
import es.indra.sicc.dtos.rec.DTONumDocFecha;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import es.indra.sicc.dtos.rec.DTOBuscarCambiosPrecios;
import es.indra.sicc.dtos.rec.DTOCargaListas;
import es.indra.sicc.dtos.rec.DTORecuperarCabeGen;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.rec.DTOGuardarModificacion;

public interface MONCambiosDePrecios extends EJBObject 
{
    DTONumDocFecha obtenerNumeroDocumento(DTOBelcorp dto) throws MareException, RemoteException;

    DTODatosPreRec buscarGeneracion(DTOBuscarGeneracion dto) throws MareException, RemoteException;

    DTOSalida obtenerDetalleGeneracion(DTODetallePreRec dtoe) throws MareException, RemoteException;

    ArrayList convertirString(String solicitud) throws MareException, RemoteException;

    DTOOID guardarGeneracion(DTOGuardarGeneracion dto) throws RemoteException, MareException;

    DTOSalida obtenerCodigosOperaciones(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida buscarCambiosPrecios(DTOBuscarCambiosPrecios dtoE) throws MareException, RemoteException;

    DTOSalida obtenerEstadosGeneracion(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTORecuperarCabeGen  recuperarCabeceraGeneracion(DTOCargaListas dtoE) throws MareException, RemoteException;

    DTOSalida recuperarDetalleGeneracion(DTOCargaListas dtoE) throws MareException, RemoteException;

    void generarReclamo(DTOOID dtoE) throws MareException, RemoteException;

    void  guardarModificacion(DTOGuardarModificacion dtoE) throws MareException, RemoteException;

    void anularReclamo(DTOOID dtoE) throws MareException, RemoteException;


}