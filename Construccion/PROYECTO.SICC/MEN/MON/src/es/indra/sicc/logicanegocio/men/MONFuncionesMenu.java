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

package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.men.DTOElementoMenu;
import es.indra.sicc.dtos.men.DTOEntradaFuncionSeleccionada;
import es.indra.sicc.dtos.men.DTOEntradaInsertarElementodeMenu;
import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;
import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;
import es.indra.sicc.dtos.men.DTOFuncionMenu;
import es.indra.sicc.dtos.men.DTOModificarElementoMenu;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.men.DTOOIDs;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

/**
 * Sistema:       Belcorp
 * Modulo:        MEN
 * Componente:    MONFuncionesMenu - Interfaz remota
 * Fecha:         01/04/2003
 * 
 * @version       1.0
 * @author        Pablo Daniel Iorio
 */

public interface MONFuncionesMenu extends EJBObject {

    void insertar(DTOEntradaInsertarElementodeMenu dtoe)  throws RemoteException, MareException;

    void elimina( DTOEntradaFuncionSeleccionada dtoe)
                        throws RemoteException, MareException;
    
    void elimina(DTOOIDs dto) throws MareException;

    void modifica( DTOModificarElementoMenu dtoe)
                        throws RemoteException, MareException;
                      
    DTOSalida obtieneFunciones( DTOEntradaPresentarMenu dTOEntradaPresentarMenu)
                        throws RemoteException, MareException;

    DTOSalida obtieneMenu( DTOEntradaObtieneFuncion dtoe)
                        throws RemoteException, MareException;

    DTOSalida obtieneFuncion(DTOEntradaObtieneFuncion dtoe) 
                        throws RemoteException, MareException;

    RecordSet obtieneFuncionesConfigurarAyuda(String usuario, Long idIdioma) throws RemoteException, MareException;

    DTOSalida consulta(DTOEntradaFuncionSeleccionada dtoe) throws RemoteException, MareException;

	DTOElementoMenu obtenerMenuUsuario(DTOBoolean dto) throws RemoteException, MareException;

	void guarda(DTOFuncionMenu dto) throws RemoteException, MareException;


    DTOFuncionMenu consulta(DTOOID dto) throws RemoteException, MareException;

	DTOElementoMenu obtenerMenuCompleto(DTOBelcorp dto) throws RemoteException, MareException;

	DTOSalida obtieneFuncionesUsuario(DTOString usuario) throws RemoteException, MareException;

    DTOElementoMenu construirArbolMenu(boolean hojas, RecordSet elementos) throws RemoteException, MareException;


}
