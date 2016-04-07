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
package es.indra.sicc.logicanegocio.zon;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroDisp;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroResultado;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import java.util.Collection;
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.dtos.zon.DTOFicheroRezonificacion;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import java.util.HashMap;

public interface MONReestructuracionPrimeraFase extends EJBObject  {
    DTOFicheroResultado obtenerPeriodoRezonificacion(DTOFicheroDisp dto) throws MareException, RemoteException;

    DTOSalidaBatch rezonificar(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOFicheroRezonificacion rezonificarPrimeraFase(DTOFicheroDisp infoFichero) throws MareException, RemoteException;

  void realizarOperacion(DTORezonificacionRegistro registro, HashMap mapValores) throws MareException, RemoteException;

}