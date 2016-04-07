/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.logicanegocio.edu;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.edu.DTODruidaBusqueda;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.dtos.edu.DTODependientesCarga;
import es.indra.mare.common.exception.MareException;

public interface MONUtilidadesBD extends EJBObject {

    public DTOSalida obtieneFrecuenciasCurso(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneParametros(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneTiposCurso(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneRegalos(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneCursos(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneMarcas(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneCanales(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneAccesos(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtienePeriodos(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneTiposCliente(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneSubtiposCliente(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneClasificaciones(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneTiposClasificaciones(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneStatusClientes(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneSubgerenciasVentas(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneRegiones(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneZonas(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneSecciones(DTODruidaBusqueda dto) throws MareException, RemoteException;
    public DTOSalida obtieneTerritorios(DTODruidaBusqueda dto) throws MareException, RemoteException;	
    public DTOSalida obtieneCapacitadores(DTODruidaBusqueda dto) throws MareException, RemoteException;	
	public DTOSalida obtieneMomentoEntrega(DTODruidaBusqueda dto) throws MareException, RemoteException;
	public DTODependientesCarga obtieneDependientes(DTOCargaCursos dto) throws RemoteException, MareException;
		
}