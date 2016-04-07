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
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.edu.DTOCurso;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones;
import es.indra.sicc.dtos.edu.DTORelacionesCurso;
import es.indra.sicc.dtos.edu.DTOBusquedaFichaTecnica;

public interface MONCursos extends EJBObject {

    /** 
     * Método para obtener los registros de la tabla EDU_MATRI_CURSO que cumplen 
     * los criterios de busqueda determinados en el parámetro de entrada
     * @param dto DTOConsultaCurso con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
    public DTOSalida obtieneCursos(DTOConsultaCurso dto) throws MareException, RemoteException;

    /** 
     * Método que obtiene la información para cargar los campos de búsqueda de curso 
     * @param dto DTOBelcorp con los criterios para obtener la informacion
     * @return DTOCargaCursos con la informacion encontrada.
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontro informacion
     */
    public DTOCargaCursos cargaDatosConsulta(DTOBelcorp dto) throws MareException, RemoteException;
    
    /** 
     * Método que obtiene la información de un curso 
     * @param dto DTOOID con el oid del curso
     * @return DTOCargaCursos con la informacion encontrada.
     * @exception MareException si no se pudo acceder a la base de datos o no 
     * existe el curso
     */
    public DTOCargaCursos obtieneDetallesCurso(DTOOID dto) throws MareException, RemoteException;
    
    /** 
     * Método para insertar un registro en la tabla EDU_MATRI_CURSO y sus registros relacionados
     * @param dto DTOCurso con los datos necesarios para la inserción
     * @exception MareException si no se pudo acceder a la base de datos, si PK repetida o
	 * si hay error de integridad 
     */
    public void insertaCurso(DTOCurso dto) throws MareException, RemoteException;

    /** 
     * Método para modificar un registro en la tabla EDU_MATRI_CURSO y sus registros relacionados
     * @param dto DTOCurso con los nuevos datos del registro
     * @exception MareException si no se pudo acceder a la base de datos, si PK repetida o
	 * si hay error de integridad 
     */
    public void modificaCurso(DTOCurso dto) throws MareException, RemoteException;

    /** 
     * Método para eliminar cursos de la tabla EDU_MATRI_CURSO
     * @param dto DTOOIDs con los oids de los registros a eliminar
     */
    public void eliminaCurso(DTOOIDs dto) throws MareException, RemoteException;


    /** 
     * Método para copiar cursos de la tabla EDU_MATRI_CURSO
     * @param dto DTOOIDs con los oids de los registros a copiar
     * @return DTOOID con el oid del nuevo curso.
     * @exception MareException si no se pudo acceder a la base de datos,
	 * si hay error de integridad o si no se encontró ningún elemento a copiar 
     */
    public DTOOID copiaCurso(DTOOIDs dto) throws MareException, RemoteException;

	public void aceptaMatriz(DTOOID dto) throws MareException, RemoteException;

    DTOSalida consultarCursosReuniones(DTOBuscarCursosReuniones dto) throws RemoteException, MareException;

  DTOSalida obtenerCursos(DTORelacionesCurso dto) throws MareException, RemoteException;

  DTOSalida obtenerTipoCurso(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida obtenerOidPlantilla(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida buscarFichaTecnica(DTOBusquedaFichaTecnica dto) throws MareException, RemoteException;

    

}