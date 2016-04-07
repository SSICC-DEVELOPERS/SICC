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
 *
 * Autor : Igor Dedough
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTOCabeceraPremElegidos;
import es.indra.sicc.dtos.inc.DTOElegirPremiosRec;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import es.indra.sicc.dtos.inc.DTOBuscarClientesConcurso;
import es.indra.sicc.util.DTODate;

public interface MONMantenimientoPremiacion extends EJBObject {
    DTOSalida buscarConcursosPremiosRec(DTOElegirPremiosRec dtoe)
            throws MareException, RemoteException;

    DTOSalida buscarNivelesPremiacion(DTOElegirPremiosRec dtoe)
            throws MareException, RemoteException;

    void guardarPremio(DTOElegirPremiosRec dtoe) throws MareException, RemoteException;

    DTOCabeceraPremElegidos buscarCabeceraDetallePremElectivos(DTOCabeceraPremElegidos dtoe)
            throws MareException, RemoteException;

    void guardarPremiosElegidos(DTOCabeceraPremElegidos dtoe)
            throws MareException, RemoteException;

    DTOSalida cargarEleccionPremios(DTOCabeceraPremElegidos dtoe)
            throws MareException, RemoteException;

    DTOSalida obtenerConcursos(DTODate dtoe) 
            throws RemoteException, MareException;

    DTOSalida obtenerClientesPorConcurso(DTOBuscarClientesConcurso dtoe) 
            throws RemoteException, MareException;
}
