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

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.edu.DTOPlantillaCurso;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.util.DTOOIDs;


public interface MONPlantillaCurso extends EJBObject 
{
    DTOSalida obtienePlantillas(DTOPlantillaCurso dto) throws MareException, RemoteException;
    DTOCargaCursos obtieneDetallesPlantilla (DTOOID dto) throws MareException, RemoteException;
    void insertaPlantilla (DTOPlantillaCurso dto) throws MareException, RemoteException;
    void modificaPlantilla (DTOPlantillaCurso dto) throws MareException, RemoteException;
    void eliminaPlantilla (DTOOIDs dto) throws MareException, RemoteException;
    DTOOID copiaPlantilla (DTOOIDs dto) throws MareException, RemoteException;
    DTOCargaCursos cargaPantalla (DTOBelcorp dto) throws MareException, RemoteException; 
}