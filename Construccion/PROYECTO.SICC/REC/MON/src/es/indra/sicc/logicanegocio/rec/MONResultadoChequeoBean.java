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

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.rec.DTOInsertarResultadoChequeo;
import es.indra.sicc.dtos.rec.DTOResultadosChequeo;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;

public class MONResultadoChequeoBean implements SessionBean  {
    private SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida buscarSolicitudesCliente(DTOOIDPaginado dto) throws MareException {
        UtilidadesLog.info("MONResultadoChequeo.buscarSolicitudesCliente(DTOOIDPaginado):Entrada");
        DAOResultadoChequeo dao = new DAOResultadoChequeo();
        DTOSalida dtoSalida = dao.buscarSolicitudesCliente(dto);
        UtilidadesLog.info("MONResultadoChequeo.buscarSolicitudesCliente(DTOOIDPaginado):Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerResultadosChequeo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONResultadoChequeo.obtenerResultadosChequeo(DTOBelcorp):Entrada");
        DAOResultadoChequeo dao = new DAOResultadoChequeo();
        DTOSalida dtoSalida = dao.obtenerResultadosChequeo(dto);
        UtilidadesLog.info("MONResultadoChequeo.obtenerResultadosChequeo(DTOBelcorp):Salida");
        return dtoSalida;
    }

  /* Marta Aurora Montiel
   * 05/04/05
   * Incidencia BELC300015788
   * 
   * gPineda cdos 09/05/06
   * Incidencia BELC300021334: Se modifica el parametro de entrada para recibir un dto
   * (creado por esta incidencia) que contiene un array de dtos
   * */
  public void actualizaResultadoChequeo(DTOResultadosChequeo dto) throws MareException {
        UtilidadesLog.info("MONResultadoChequeo.actualizaResultadoChequeo(DTOResultadosChequeo):Entrada");
        DAOSolicitud dao = new DAOSolicitud();
        
        DTOInsertarResultadoChequeo[] dtos = dto.getLista();
        int length = dtos.length;
        for (int j = 0; j < length; j++){
          dao.actualizaResultadoChequeo( dtos[j] );    
        }
        UtilidadesLog.info("MONResultadoChequeo.actualizaResultadoChequeo(DTOResultadosChequeo):Salida");
  }

   /*Marta Aurora Montiel
   * 05/04/05
   * Incidencia BELC300015789
   * */
  public DTOSalida obtenerPosicionesSolicitudChequeo(DTOOIDPaginado dto) throws MareException
  {
    UtilidadesLog.info("MONResultadoChequeo.obtenerPosicionesSolicitudChequeo(DTOOIDPaginado):Entrada");
    DAOSolicitud dao = new DAOSolicitud();
    DTOSalida dts = new DTOSalida();
    dts = dao.obtenerPosicionesSolicitudChequeo(dto);
    if (dts.getResultado().esVacio()){
        // GEN-0007 --> 0005                                                                                  
        UtilidadesLog.debug("****MONResultadoChequeo.obtenerPosicionesSolicitudChequeo: No hay datos ");				
        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
    }
    UtilidadesLog.info("MONResultadoChequeo.obtenerPosicionesSolicitudChequeo(DTOOIDPaginado):Salida");
    return dts;
  }
}