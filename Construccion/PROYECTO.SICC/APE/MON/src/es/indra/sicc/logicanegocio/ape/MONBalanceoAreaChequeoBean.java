/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 */ 
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOParamBalanceoAreaChequeo;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.rec.DTOChequeoZona;
import es.indra.sicc.entidades.ape.ParametrosBalanceoAreaChequeoLocal;
import es.indra.sicc.entidades.ape.ParametrosBalanceoAreaChequeoLocalHome;
import es.indra.sicc.entidades.ape.TipoSolicitudBalanceoAreaChequeoLocal;
import es.indra.sicc.entidades.ape.TipoSolicitudBalanceoAreaChequeoLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONBalanceoAreaChequeoBean implements SessionBean  {
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
    /**
   * @throws es.indra.mare.common.exception.MareException
   * @return void
   * @param dtoE DTOParamBalanceoAreaChequeo 
   * @author hhernandez
   * @since 07-01-2007
   */
  public void guardarParamBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE) throws RemoteException,MareException {
    UtilidadesLog.info("MONBalanceoAreaChequeoBean.guardarParamBalanceoAreaChequeo():Entrada");  
    if (dtoE.getOidParametros () == null) //insertar
    {
      try
      {
          UtilidadesLog.debug("DTO CREATE:" + dtoE );
          ParametrosBalanceoAreaChequeoLocalHome parametrosBalanceoAreaChequeoHome = new ParametrosBalanceoAreaChequeoLocalHome();

          UtilidadesLog.debug("antes de guardar");
          //Obteniendo el siguiente valor de codigo agrupacion
          ParametrosBalanceoAreaChequeoLocal parametrosBalanceoAreaChequeoLocal = 
          parametrosBalanceoAreaChequeoHome.create(new Long(dtoE.getPedidosArmadoHoras()),
                                                   new Long(dtoE.getUnidadesChequeoHoraPersona()),
                                                   new Long(dtoE.getParametroDistribucion()),
                                                   dtoE.getOidCentroDistribucion(),
                                                   dtoE.getOidLineaArmado(),
                                                   dtoE.getDiaHora(),
                                                   dtoE.getCodAgrupacion());

          UtilidadesLog.debug("antes guardarListaSolicitudes");
          insertarListaSolicitudes(parametrosBalanceoAreaChequeoLocal.getOid(), dtoE.getListaSolicitudes());
          
      } catch(PersistenceException e) 
      {
          ctx.setRollbackOnly();
          UtilidadesLog.error("****Error Metodo: guardarParamBalanceoAreaChequeo: PersistenceException: " +
              e.getMessage());
          UtilidadesLog.error(e);
  
          throw new MareException(e,UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }      
    }
    else //modificar
    {
      UtilidadesLog.debug("DTO CREATE:" + dtoE);
		  ParametrosBalanceoAreaChequeoLocalHome parametrosBalanceoAreaChequeoLocalHome = new ParametrosBalanceoAreaChequeoLocalHome();
		  UtilidadesLog.debug("antes de guardar");
		  ParametrosBalanceoAreaChequeoLocal parametrosBalanceoAreaChequeoLocal = null;
      try 
      {
        parametrosBalanceoAreaChequeoLocal = parametrosBalanceoAreaChequeoLocalHome.findByPrimaryKey(dtoE.getOidParametros());
        //(Long codAgru, Long numPediHoraArma, Long numPersArma, Long numUnidHoraPersCheq, Long numParaDist, Long ccdiOidConfCentDist, Long liarOidLineArma)
        parametrosBalanceoAreaChequeoLocal.setNumPediHoraArma(new Long(dtoE.getPedidosArmadoHoras()));
        //parametrosBalanceoAreaChequeoLocal.getNumPersArma(dtoE.get)
        parametrosBalanceoAreaChequeoLocal.setNumUnidHoraPersCheq(new Long(dtoE.getUnidadesChequeoHoraPersona()));
        parametrosBalanceoAreaChequeoLocal.setNumParaDist(new Long(dtoE.getParametroDistribucion()));
        parametrosBalanceoAreaChequeoLocal.setCcdiOidConfCentDist(dtoE.getOidCentroDistribucion());
        parametrosBalanceoAreaChequeoLocal.setLiarOidLineArma(dtoE.getOidLineaArmado());
        parametrosBalanceoAreaChequeoLocal.setHoraDias(dtoE.getDiaHora());
        
        try {
            parametrosBalanceoAreaChequeoLocalHome.merge(parametrosBalanceoAreaChequeoLocal);
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error al hacer merge: ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("Ahora Modificando la lista de solicitudes");
        modificarListaSolicitudes(parametrosBalanceoAreaChequeoLocal.getOid(), dtoE.getListaSolicitudes());

      } catch (NoResultException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("****Error Metodo: guardarParamBalanceoAreaChequeo -- modificar: NoResultException: " +
            e.getMessage());
        UtilidadesLog.error(e);
        throw new MareException(e,UtilidadesError.armarCodigoError(
        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
      } catch (PersistenceException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("****Error Metodo: guardarParamBalanceoAreaChequeo -- modificar: PersistenceException: " +
            e.getMessage());
        UtilidadesLog.error(e);
        throw new MareException(e,UtilidadesError.armarCodigoError(
        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));            
      }
    }
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.guardarConfiguracionCD():Salida");      
  }

	private void insertarListaSolicitudes(Long oid, DTOOIDs listaSolicitudes) throws MareException
	{
      UtilidadesLog.info("MONBalanceoAreaChequeoBean.insertarListaSolicitudes(Long oid,DTOOIDs listaSolicitudes): Entrada");
      try {
          int cant = listaSolicitudes.getOids().length  ;
          TipoSolicitudBalanceoAreaChequeoLocalHome tipoSolicitudBalanceoAreaChequeoLH  = new TipoSolicitudBalanceoAreaChequeoLocalHome();
		  	  
          for(int i=0; i<cant; i++){     
                  UtilidadesLog.debug("Insercion i:" + i);
                  tipoSolicitudBalanceoAreaChequeoLH.create(oid,
                                       listaSolicitudes.getOids()[i]);     
          }
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONBalanceoAreaChequeoBean.insertarListaSolicitudes(Long oid,DTOOIDs listaSolicitudes): Salida");
  }  
 
  private void modificarListaSolicitudes(Long oid, DTOOIDs listaSolicitudes) throws MareException
	{
      UtilidadesLog.info("MONBalanceoAreaChequeoBean.modificarListaSolicitudes(Long oid,DTOOIDs listaSolicitudes): Entrada");
      try {
          TipoSolicitudBalanceoAreaChequeoLocalHome tipoSolicitudBalanceoAreaChequeoLH  = new TipoSolicitudBalanceoAreaChequeoLocalHome();
          Collection tipoSolicitudBalanceoAreaChequeoColl = tipoSolicitudBalanceoAreaChequeoLH.findByParametros(oid);
          
          UtilidadesLog.info("Eliminando los registros recuperados");
          Iterator ite = tipoSolicitudBalanceoAreaChequeoColl.iterator();
          while(ite.hasNext()){
            TipoSolicitudBalanceoAreaChequeoLocal tsbac = (TipoSolicitudBalanceoAreaChequeoLocal)ite.next();
            try {
                tipoSolicitudBalanceoAreaChequeoLH.remove(tsbac);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Error al hacer remove: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
          }
          
          UtilidadesLog.info("Añadir lista desolicitudes");
          insertarListaSolicitudes(oid, listaSolicitudes);
          
      }
        catch (NoResultException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }   catch (PersistenceException e) {  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

	  UtilidadesLog.info("MONBalanceoAreaChequeoBean.modificarListaSolicitudes(Long oid,DTOOIDs listaSolicitudes): Salida");
  }
 
    /** 
    * Autor: hhernandez
    * Fecha: 07-02-2007
    * Descripcion: elimina los registros segun los parametros de entrada  
    * @param dtoE DTOOIDs 
    * @return void
    * @exception MareException 
    */   
  public void eliminarParamBalanceoAreaChequeo(DTOOIDs dtoE) throws MareException {
      //try{
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.eliminarParamBalanceoAreaChequeo(DTOOIDs dtoE): Salida");                      
        if ((dtoE != null) && (dtoE.getOids() != null)) {
          int cant = dtoE.getOids().length  ;
          UtilidadesLog.debug("Se eliminaran " + cant + " ParamBalanceoAreaChequeo");
          
          for (int i = 0; i < cant; i++) {
            try{
              UtilidadesLog.debug("Primero se elimina los TipoSolicitudBalanceoAreaChequeo con OID: " + dtoE.getOids()[i]);
              
              TipoSolicitudBalanceoAreaChequeoLocalHome tipoSolicitudBalanceoAreaChequeoLH  = new TipoSolicitudBalanceoAreaChequeoLocalHome();
              Collection tipoSolicitudBalanceoAreaChequeoColl = tipoSolicitudBalanceoAreaChequeoLH.findByParametros(dtoE.getOids()[i]);
            
              Iterator ite = tipoSolicitudBalanceoAreaChequeoColl.iterator();
              while(ite.hasNext()){
                TipoSolicitudBalanceoAreaChequeoLocal tsbac = (TipoSolicitudBalanceoAreaChequeoLocal)ite.next();
                try {
                    tipoSolicitudBalanceoAreaChequeoLH.remove(tsbac);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error al hacer remove: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
              }
              UtilidadesLog.debug("Despues se elimina ParametrosBalanceoAreaChequeo con OID: " + dtoE.getOids()[i]);
              
              ParametrosBalanceoAreaChequeoLocalHome parametrosBalanceoAreaChequeoLH = new ParametrosBalanceoAreaChequeoLocalHome();
              ParametrosBalanceoAreaChequeoLocal parametrosBalanceoAreaChequeoL = null;
              parametrosBalanceoAreaChequeoL = parametrosBalanceoAreaChequeoLH.findByPrimaryKey(dtoE.getOids()[i]);
              try {
                parametrosBalanceoAreaChequeoLH.remove(parametrosBalanceoAreaChequeoL);
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("Error al hacer remove: ", e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
              }
            } catch (NoResultException e) {
              UtilidadesLog.error("DAOAsignacionProductos.eliminarEstimadosProducto: NoResultException", e);
              UtilidadesLog.debug("Se continua con el siguiente");
              //EN CASO NO ENCUENTRE QUIERE DECIR QUE YA LO BORRO PREVIAMENTE,
              //SE CONTINUA CON EL SIGUIENTE 
              //throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Error en finder: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
          }
        }
      /*} catch (RemoveException re) {
            UtilidadesLog.error("Exception: ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }*/
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.eliminarParamBalanceoAreaChequeo(DTOOIDs dtoE): Salida");  
  }

    /** 
    * Autor: hhernandez
    * Fecha: 07-02-2007
    * Descripcion: invoca al metodo del DAO para recuperar los parametros de balanceo de area de chequeo 
    * @param dtoE DTOParamBalanceoAreaChequeo  
    * @return DTOSalida 
    * @exception MareException 
    */  
  public DTOSalida consultarParamBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE) throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.buscarEtiquetas(DTOParamBalanceoAreaChequeo dtoE): Entrada");
        DTOSalida dtoSalida=new DTOSalida();
        DAOBalanceoAreaChequeo daoBalanceoAreaChequeo= new DAOBalanceoAreaChequeo();
        dtoSalida=daoBalanceoAreaChequeo.consultarParamBalanceoAreaChequeo(dtoE);
        RecordSet rs=new RecordSet();
        rs=dtoSalida.getResultado();
         if (rs.esVacio()) {
          UtilidadesLog.debug("****consultarParamBalanceoAreaChequeo: no hay datos ");				
                throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            UtilidadesLog.info("MONBalanceoAreaChequeoBean.buscarEtiquetas(DTOParamBalanceoAreaChequeo dtoE): Salida");
        return dtoSalida;        
  }

    /** 
    * Autor: hhernandez
    * Fecha: 07-02-2007
    * Descripcion: recupera los valores de solicitudes de parametros de balanceo de area de chequeo 
    * @param dtoE DTOParamBalanceoAreaChequeo  
    * @return DTOSalida 
    * @exception MareException 
    */   
  public DTOSalida obtenerSolicitudesBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE) throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerSolicitudesBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE): Entrada");
        DTOSalida dtoSalida = new DAOBalanceoAreaChequeo().obtenerSolicitudesBalanceoAreaChequeo(dtoE);
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerSolicitudesBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE): Salida");
        return dtoSalida;
  }
  
    /*
     * Obtiene el indicador de revision para el cliente del consolidado recibido.
     * @autor eiraola
     * @since 01/Mar/2007
     * @observacion 23/Mar/2007 Se deja de utilizar por ajuste de performance
     */
    /*private DTOOID obtenerTipoRevisionCliente(DTOFACCabeceraSolicitud cabecera) throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerTipoRevisionCliente(dtoe): Entrada");
        
        Long indicadorRevision = cabecera.getIndicadorRevision();
        UtilidadesLog.debug(" ... el oid de Indicador Revision del cliente inicial_" + indicadorRevision);
        
        DAOBalanceoAreaChequeo daoBalACheq = new DAOBalanceoAreaChequeo();
        
        // REC:ClientesAChequear
        // Se determina si particularmente este cliente debe ser chequeado y obtenemos
        // el nivel de dicho chequeo
        DTOOID dtoOid = daoBalACheq.obtenerRevisionClientesAChequear(cabecera);
        Long indicadorTemporal = dtoOid.getOid();
        indicadorRevision = this.determinarValorIndicadorRevision(indicadorRevision, indicadorTemporal);
        
        
        // MAE:ClientesDatosAdicionales
        // Comprobamos si es una consultora nueva, en caso de serlo verificamos si 
        // le corresponde el chequeo (REC:ConfigChequeosLinea y REC:ConfigChequeosCampo)
        ClienteDatosAdicionalesLocalHome clienDatosAdicLH = this.getClienteDatosAdicionalesLocalHome();
        ClienteDatosAdicionalesLocal clienDatosAdicL;
        
        try {
            clienDatosAdicL = clienDatosAdicLH.findByCliente(cabecera.getOidCliente());
        } catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        Long estatusCliente = clienDatosAdicL.getEsta_oid_esta_clie();
        
        if (ConstantesMAE.OID_ESTATUS_NUEVA.equals(estatusCliente)) {
            dtoOid = daoBalACheq.obtenerRevisionClientesNuevos(cabecera);
            indicadorTemporal = dtoOid.getOid();
            indicadorRevision = this.determinarValorIndicadorRevision(indicadorRevision, indicadorTemporal);
        }
        
        
        // REC:ZonasChequeoEnCampo
        // Verificamos (para las consultoras que hasta ahora no chequean en Campo) 
        // si corresponde chequeo en campo por su UA
        if ( !ConstantesPED.OID_REVISION_CAMPO.equals(indicadorRevision) && 
             !ConstantesPED.OID_REVISION_AMBAS.equals(indicadorRevision) ) {
            dtoOid = daoBalACheq.obtenerRevisionClientesZonaChequeo(cabecera);
            indicadorTemporal = dtoOid.getOid();
            indicadorRevision = this.determinarValorIndicadorRevision(indicadorRevision, indicadorTemporal);
        }
        
        
        UtilidadesLog.debug(" ... el oid de Indicador Revision del cliente resulta_" + indicadorRevision);
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerTipoRevisionCliente(dtoe): Salida");
        dtoOid.setOid(indicadorRevision);
        return dtoOid;
    }*/

    /**
     * Metodo que realiza el CU Balancear area de chequeo (APE-119), debe llamarse
     * desde "FAC Arrancar facturacion"
     * @TODO: Deben eliminarse las variables inicio, fin y duracion. Tambien quitar
     *        las llamadas a mostrarArrayDtosFC(....)
     * @autor eiraola
     * @since 23/03/2007
     * @observaciones
     *     31/05/2007 eiraola BELC400000459 Se agrega seteo del dato OrigenChequeo y 
     *                                      se actualiza en PED_SOLIC_CABEC.
     */
    public DTOFACConsolidado[] balancearAreaChequeo(DTOFACConsolidado[] listaConsolidados) 
            throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.balancearAreaChequeoPerf(listaConsolidados): Entrada");
        Date inicio = new Date(); // debug
        try {
            int cantidadConsolidados = listaConsolidados.length;
            
            if ( !(cantidadConsolidados > 0) ) {
                UtilidadesLog.debug("*** La lista no contiene consolidados!");
                UtilidadesLog.info("MONBalanceoAreaChequeoBean.balancearAreaChequeoPerf(listaConsolidados): Salida");
                return listaConsolidados;
            }
        
            UtilidadesLog.debug("==== ENTRADA - Resumen de los consolidados recibidos:");
            this.mostrarArrayDtosFC(listaConsolidados); // Traza para debug
            
            // Agrupar por periodo a los consolidados
            Hashtable consolidadosPorPeriodo = this.agruparConsolidadosPorPeriodo(listaConsolidados);
            
            // Vamos a procesar el indicador de revision por periodo
            Set periodos = consolidadosPorPeriodo.keySet();
            Iterator it = periodos.iterator();
            
            Long periodo;
            Long oidCliente;
            Long oidIndiRevi = null;
            Long oidIndiReviAux = null;
            DTOFACConsolidado dtoConsolidado;
            ArrayList consolidados;
            ArrayList oidsClientes;
            Hashtable clientesAChequear;
            ArrayList consultorasEstatusNueva;
            ArrayList zonasChequeoEnCampo;
            int cantZonasChequeoEnCampo;
            
            UtilidadesLog.debug("(1)********* INICIO de Evaluacion de Indicador de Revision");
            
            while (it.hasNext()) {
                periodo = (Long)it.next();
                UtilidadesLog.debug(" --- Consolidados correspondientes al periodo "+periodo+" ---");
                consolidados = (ArrayList)consolidadosPorPeriodo.get(periodo);
                
                oidsClientes = this.obtenerListaClientes(consolidados);
                clientesAChequear = this.obtenerClientesAChequear(oidsClientes, periodo);
                consultorasEstatusNueva = this.obtenerListaConsultorasEstatusNueva(oidsClientes);
                zonasChequeoEnCampo = this.obtenerZonasChequeoEnCampo(periodo);
                cantZonasChequeoEnCampo = zonasChequeoEnCampo.size();
                
                // Actualizamos el indicador de revision para los consolidados del periodo en proceso
                int cantConsolidados = consolidados.size();
                //boolean actualizar;
                
                for (int i = 0; i < cantConsolidados; i++) {
                    //actualizar = false;
                    dtoConsolidado = (DTOFACConsolidado)consolidados.get(i);
                    oidCliente = dtoConsolidado.getDtoCabecera().getOidCliente();
                    oidIndiRevi = dtoConsolidado.getDtoCabecera().getIndicadorRevision(); // Importante inicializo con valor del dto
                    UtilidadesLog.debug(" *** Cliente oid: " + oidCliente + " indicadorRevision al inicio: " 
                                        + dtoConsolidado.getDtoCabecera().getIndicadorRevision());
                    if (clientesAChequear.containsKey(oidCliente)) {
                        UtilidadesLog.debug("     ===> es un Cliente a chequear");
                        oidIndiReviAux = (Long)clientesAChequear.get(oidCliente);
                        oidIndiRevi = this.determinarValorIndicadorRevision(oidIndiRevi, oidIndiReviAux);
                        dtoConsolidado.getDtoCabecera().setIndicadorRevision(oidIndiRevi);
                        //ciglesias incidencia 523
                        //dtoConsolidado.getDtoCabecera().setOrigenChequeo(ConstantesAPE.CHEQUEO_CAPTURA_MANUAL); // Agregado eiraola Inc. BELC400000459
                        dtoConsolidado.getDtoCabecera().setOrigenChequeo(ConstantesAPE.CHEQUEO_EVALUACION_RECLAMOS); // Agregado eiraola Inc. BELC400000459
                        //actualizar = true;
                    }
                    
                    if (consultorasEstatusNueva.contains(oidCliente)) {
                        UtilidadesLog.debug("     ===> es un Cliente con estatus 'Nueva'");
                        oidIndiReviAux = this.obtenerIndicadorRevisionNueva(dtoConsolidado.getDtoCabecera());
                        oidIndiRevi = this.determinarValorIndicadorRevision(oidIndiRevi, oidIndiReviAux);
                        dtoConsolidado.getDtoCabecera().setIndicadorRevision(oidIndiRevi);
                        dtoConsolidado.getDtoCabecera().setOrigenChequeo(ConstantesAPE.CHEQUEO_PRIMER_PEDIDO); // Agregado eiraola Inc. BELC400000459
                        //actualizar = true;
                    }
                    
                    if (cantZonasChequeoEnCampo > 0) {
                        if (! (ConstantesPED.OID_REVISION_CAMPO.equals(dtoConsolidado.getDtoCabecera().getIndicadorRevision())
                             || ConstantesPED.OID_REVISION_AMBAS.equals(dtoConsolidado.getDtoCabecera().getIndicadorRevision())) ) {
                            UtilidadesLog.debug("     ===> verificamos Zonas de chequeo en Campo");
                            if (this.validarAmbitoGeograficoConsultora(zonasChequeoEnCampo, dtoConsolidado.getDtoCabecera())) {
                                oidIndiRevi = this.determinarValorIndicadorRevision(oidIndiRevi, ConstantesPED.OID_REVISION_CAMPO);
                                dtoConsolidado.getDtoCabecera().setIndicadorRevision(oidIndiRevi);
                                //ciglesias incidencia 523 
                                //dtoConsolidado.getDtoCabecera().setOrigenChequeo(ConstantesAPE.CHEQUEO_EVALUACION_RECLAMOS); // Agregado eiraola Inc. BELC400000459
                                dtoConsolidado.getDtoCabecera().setOrigenChequeo(ConstantesAPE.CHEQUEO_CAPTURA_MANUAL); // Agregado eiraola Inc. BELC400000459
                                //actualizar = true;
                            }
                        }
                    }
                    
                    // ELIMINADO - eiraola - 06/Ago/2007 - [INICIO]
                    //if (actualizar) {
                    //    modificados.add(dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
                    //}
                    // ELIMINADO - eiraola - 06/Ago/2007 - [FIN]
                    UtilidadesLog.debug(" ***************  al salir, indicadorRevision: " + 
                                        dtoConsolidado.getDtoCabecera().getIndicadorRevision() +
                                        " / origenChequeo: " + dtoConsolidado.getDtoCabecera().getOrigenChequeo());
                } // fin for
            } // fin while periodos
            UtilidadesLog.debug("(1)********* FIN de Evaluacion de Indicador de Revision");
            
            
            // Actualizamos PED_SOLIC_CABEC solo aquellos registros cuyo indicadorRevision 
            // fue modificado en este CU:
            
            /* =================================================================
             * ELIMINADO - eiraola - 06/Ago/2007 - [INICIO]
             * ================================================================= 
             //  Por cuestion tecnica no se realiza Update sobre PED_SOLIC_CABEC pues
             //  los consolidados existen en memoria pero no tienen Numero ni Oid dado
             //  que no fueron Insertados en la Base de datos hasta este punto (a 
             //  diferencia de lo que indica el DECU).
             
            // Agregado - eiraola - Inc. BELC400000459 - INICIO
            UtilidadesLog.debug("(2)********* INICIO de Actualizacion en BBDD de Indicador de Revision y Origen Chequeo");
            Vector vUpdatePSC = new Vector();
            Hashtable datosUpdatePedSolicCabec = new Hashtable();
            CombinacionValoresCamposUpdate combinacionDatosUpdate;
            ArrayList oidsRegistrosPedSolicCabec;
            
            Long oidCabeceraSolicitud;
            Long oidTipoRevision; // Campo1
            String origenChequeo; // Campo2
            
            for (int i = 0; i < cantidadConsolidados; i++) {
                dtoConsolidado = listaConsolidados[i];
                oidCabeceraSolicitud = dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud();
                
                // No generamos el script de update para aquellos no modificados en este CU
                if (!modificados.contains(oidCabeceraSolicitud)) {
                    continue;
                }
                
                oidTipoRevision = dtoConsolidado.getDtoCabecera().getIndicadorRevision();
                origenChequeo = dtoConsolidado.getDtoCabecera().getOrigenChequeo();
                combinacionDatosUpdate = new CombinacionValoresCamposUpdate(oidTipoRevision, origenChequeo);
                
                // Acumulamos los oids de SolicitudCabecera para luego actualizar el campo 
                // indicadorRevision y origenChequeo de dicha entidad de PED. 
                // Agrupamos por valores comunes a actualizar (indicadorRevision/origenChequeo).
                
                if (datosUpdatePedSolicCabec.containsKey(combinacionDatosUpdate)) {
                    oidsRegistrosPedSolicCabec = (ArrayList)datosUpdatePedSolicCabec.get(combinacionDatosUpdate);
                    
                    if (!oidsRegistrosPedSolicCabec.contains(oidCabeceraSolicitud)) {
                        oidsRegistrosPedSolicCabec.add(oidCabeceraSolicitud);
                        datosUpdatePedSolicCabec.put(combinacionDatosUpdate, oidsRegistrosPedSolicCabec);
                    }
                } else {
                    oidsRegistrosPedSolicCabec = new ArrayList();
                    oidsRegistrosPedSolicCabec.add(oidCabeceraSolicitud);
                    datosUpdatePedSolicCabec.put(combinacionDatosUpdate, oidsRegistrosPedSolicCabec);
                }
                
            } // fin for
            
            
            // Preparacion de los update sobre PED_SOLIC_CABEC: INRE_OID_INDI_REVI y VAL_ORIG_CHEQ
            Enumeration combinacionesUpdate = datosUpdatePedSolicCabec.keys();  // Conjunto de keys del Hashtable
            CombinacionValoresCamposUpdate combinacion; // key
            ArrayList oidsPedSolicCabec;                // value
            Long oidPedSolicCabec;                      // elementos del ArrayList oidsPedSolicCabec
            
            while(combinacionesUpdate.hasMoreElements()) {
                combinacion = (CombinacionValoresCamposUpdate)combinacionesUpdate.nextElement();
                oidsPedSolicCabec = (ArrayList)datosUpdatePedSolicCabec.get(combinacion);
                    
                vUpdatePSC.add(this.armarUpdatePSC(oidsPedSolicCabec, combinacion));
            }
            
            
            // Ejecucion del script con los update
            UtilidadesLog.debug("*** Ejecutando Updates del 'indicadorRevision' y 'origenChequeo' " +
                                "de 'Ped:Solicitud Cabecera' (masivo)...");
            invocarExecutor(vUpdatePSC);   // Actualiza el oid de Indicador de Revision y el codigo de Origen de Chequeo
            
            UtilidadesLog.debug("(2)********* FIN de Actualizacion en BBDD de Indicador de Revision y Origen Chequeo");
            // Agregado - eiraola - Inc. BELC400000459 - FIN
             * =================================================================
             * ELIMINADO - eiraola - 06/Ago/2007 - [FIN] 
             * ================================================================= */
            
            // Eliminado - eiraola - Inc. BELC400000459 - INICIO
            /*Vector vUpdatePSCIndicadorRevision = new Vector();
            Vector vOidsPSC_IndRevi_Linea = new Vector();
            Vector vOidsPSC_IndRevi_Campo = new Vector();
            Vector vOidsPSC_IndRevi_Ambas = new Vector();
            Vector vOidsPSC_IndRevi_Nulo = new Vector();
            
            UtilidadesLog.debug("(2)********* INICIO de Actualizacion en BBDD de Indicador de Revision");
            Long oidCabeceraSolicitud;
            Long oidTipoRevision;
            
            for (int i = 0; i < cantidadConsolidados; i++) {
                dtoConsolidado = listaConsolidados[i];
                oidCabeceraSolicitud = dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud();
                
                // No generamos el script de update para aquellos no modificados en este CU
                if (!modificados.contains(oidCabeceraSolicitud)) {
                    continue;
                }
                
                oidTipoRevision = dtoConsolidado.getDtoCabecera().getIndicadorRevision();          
                
                // Acumulamos los oids de SolicitudCabecera para luego actualizar el campo 
                // indicadorRevision de dicha entidad de PED. Agrupamos por valor a actualizar.
                if (oidTipoRevision == null) {
                    vOidsPSC_IndRevi_Nulo.add(oidCabeceraSolicitud);
                    
                } else if (oidTipoRevision.equals(ConstantesPED.OID_REVISION_LINEA)) {
                    vOidsPSC_IndRevi_Linea.add(oidCabeceraSolicitud);
                    
                } else if (oidTipoRevision.equals(ConstantesPED.OID_REVISION_CAMPO)) {
                    vOidsPSC_IndRevi_Campo.add(oidCabeceraSolicitud);
                    
                } else if (oidTipoRevision.equals(ConstantesPED.OID_REVISION_AMBAS)) {
                    vOidsPSC_IndRevi_Ambas.add(oidCabeceraSolicitud);
                    
                }
            } // fin for
            
            
            // Preparacion de los update sobre PED_SOLIC_CABEC.INRE_OID_INDI_REVI
            Vector vUpdateAux;
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Nulo, null);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Linea, ConstantesPED.OID_REVISION_LINEA);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Campo, ConstantesPED.OID_REVISION_CAMPO);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Ambas, ConstantesPED.OID_REVISION_AMBAS);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            // Ejecucion del script con los update
            UtilidadesLog.debug("*** Ejecutando Update del 'indicadorRevision' de 'Ped:Solicitud Cabecera' (masivo)...");
            invocarExecutor(vUpdatePSCIndicadorRevision);   // Actualiza el oid de Indicador de Revision
            
            UtilidadesLog.debug("(2)********* FIN de Actualizacion en BBDD de Indicador de Revision");
            */
            // Eliminado - eiraola - Inc. BELC400000459 - FIN
            
            UtilidadesLog.debug("(3)********* INICIO Resecuenciar consolidados");
            this.resecuenciarConsolidados(listaConsolidados);
            UtilidadesLog.debug("(3)********* FIN Resecuenciar consolidados");
            
            // Agregado eiraola 20/07/2007 - (aunque parezca mentira es por la Inc. BELC400000587)
            // Ordeno en memoria la lista de consolidados recibida por:
            //  - Numero de secuencia zona-ruta
            //  - Numero de secuencia de facturacion (el nuevo!)
            UtilidadesLog.debug("(4)********* INICIO Ordenando consolidados en memoria (por Zona-Ruta y Secue Factu");
            listaConsolidados = this.ordenarConsolidados(listaConsolidados);
            UtilidadesLog.debug("(4)********* FIN Ordenando consolidados en memoria (por Zona-Ruta y Secue Factu");
            
            UtilidadesLog.debug("==== SALIDA - Resumen de los consolidados (con IndRevi actualizado y Resecuenciados):");
            this.mostrarArrayDtosFC(listaConsolidados); // Traza para debug
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            e.printStackTrace();
            throw new MareException("Error al balancearAreaChequeo", e);
        }
        Date fin = new Date(); // debug
        long duracion = fin.getTime() - inicio.getTime(); // debug
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.balancearAreaChequeoPerf(listaConsolidados): Salida " 
                           + duracion + " miliseg.");
        return listaConsolidados;
    }

    /**
     * Resecuencia la lista de consolidados recibida.
     * Para no afectar el orden recibido se trabaja sobre una copia de la lista 
     * de consolidados y luego se modifica solo el numero de secuencia de la lista original.
     * @autor eiraola
     * @since 05/Mar/2007
     */
    private void resecuenciarConsolidados(DTOFACConsolidado[] listaConsolidados) {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.resecuenciarConsolidados(listaConsolidados): Entrada");
        Date inicio = new Date(); // Debugging
        int cantConsolidados = listaConsolidados.length;
        UtilidadesLog.debug("   Cantidad de consolidados a procesar: " + cantConsolidados);
        ArrayList listaConsolidadosResecuenciados = new ArrayList();
        
        // Realizamos una copia del array, sin embargo los objetos DTOFACConsolidado
        // seran los mismos recibidos por parametro y cualquier cambio realizado persistira.
        DTOFACConsolidado[] listaConsolidadosAuxiliar = (DTOFACConsolidado[])listaConsolidados.clone();
        
        for (int i = 0; i < cantConsolidados; i++) {
            listaConsolidadosResecuenciados.clear(); // Vacia la lista
            DTOFACConsolidado dtoFACConso = listaConsolidadosAuxiliar[i];
            if (dtoFACConso == null) { // null son los ya procesados
                continue;
            }
            Integer numeroSecuenciaZonaRuta = dtoFACConso.getDtoCabecera().getNumeroSecuenciaZonaRuta();
            UtilidadesLog.debug("   --> Numero Secuencia Zona-Ruta: " + numeroSecuenciaZonaRuta);
            
            DTOFACConsolidado[] listaConsolidadosZonaRuta = extraerDTOsPorNumeroSecuenciaZonaRuta(
                    listaConsolidadosAuxiliar, numeroSecuenciaZonaRuta);
            int cantConsolidadosZonaRuta = listaConsolidadosZonaRuta.length;
            
            // De la sublista obtenida (consolidados de una misma SecuenciaZona-Ruta) 
            // vamos a tomar grupos de la misma zona y copiarlos en otra sublista para ordenarla
            for (int j = 0; j < cantConsolidadosZonaRuta; j++) {
                DTOFACConsolidado dtoFACConsoZR = listaConsolidadosZonaRuta[j];
                if (dtoFACConsoZR == null) { // null son los ya procesados
                    continue;
                }
                Long oidZona = dtoFACConsoZR.getDtoCabecera().getZona();
                UtilidadesLog.debug("    -> Zona: " + oidZona);
                ArrayList listaConsolidadosOrdenar = extraerDTOsPorZona(listaConsolidadosZonaRuta, oidZona);
                UtilidadesLog.debug("           (" + listaConsolidadosOrdenar.size() + " consolidados) ");
                // Ordenamos los Consolidados por IndicadorRevision y NumeroSecuenciaFacturacion (original)
                Collections.sort(listaConsolidadosOrdenar, new ConsolidadoChequeoComparator());
                listaConsolidadosResecuenciados.addAll(listaConsolidadosOrdenar);
            }
            
            // Vamos a recorrer la lista ordenada para asignarle una nueva secuencia 
            // y sobreescribir en la lista recibida el número de secuencia
            UtilidadesLog.debug("    ...regeneramos los Numeros Secuencia Facturacion de la Zona-Ruta");
            int nuevaSecuencia = 1;
            int cantConsolidadosAResecuenciar = listaConsolidadosResecuenciados.size();
            DTOFACConsolidado dtoFACConsoAResecuenciar;
            
            for (int j = 0; j < cantConsolidadosAResecuenciar; j++) {
                dtoFACConsoAResecuenciar = (DTOFACConsolidado)listaConsolidadosResecuenciados.get(j);
                dtoFACConsoAResecuenciar.getDtoCabecera().setNumeroSecuenciaFacturacionDiaria(new Integer(nuevaSecuencia));
                nuevaSecuencia++;
            }
            
        }
        Date fin = new Date(); // Debugging
        long duracion = fin.getTime() - inicio.getTime(); // Debugging
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.resecuenciarConsolidados(listaConsolidados): Salida_" + duracion + " milisegundos");
    }

    /**
     * Metodo auxiliar que da soporte a resecuenciarConsolidados(...)
     * Del array de consolidados quita todos los pertenecientes al numero de secuencia
     * Zona-Ruta que se indica por parametro y los devuelve en un nuevo array
     * ordenado por numero de secuencia de facturacion.
     * @autor eiraola
     * @since 07/Mar/2007
     */
    private DTOFACConsolidado[] extraerDTOsPorNumeroSecuenciaZonaRuta(DTOFACConsolidado[] 
            listaConsolidadosAuxiliar, Integer numeroSecuenciaZonaRuta) {
        int cantConsolidados = listaConsolidadosAuxiliar.length;
        ArrayList listaConsolidadosDeMismaSecuenciaZR = new ArrayList();
        DTOFACConsolidado dtoFACConso;
        Integer numeroSecuenciaZR;
        
        for (int i = 0; i < cantConsolidados; i++) {
            dtoFACConso = listaConsolidadosAuxiliar[i];
            if (dtoFACConso == null) {
                continue;
            }
            numeroSecuenciaZR = dtoFACConso.getDtoCabecera().getNumeroSecuenciaZonaRuta();
            if ( (numeroSecuenciaZonaRuta != null && numeroSecuenciaZonaRuta.equals(numeroSecuenciaZR))
                 || (numeroSecuenciaZonaRuta == null && numeroSecuenciaZR == null) ) {
                listaConsolidadosDeMismaSecuenciaZR.add(dtoFACConso);
                listaConsolidadosAuxiliar[i] = null;
            }
        }
        
        // Se ordenan los consolidados (que son de una misma Zona-Ruta) 
        // por Numero secuencia facturacion de menor a mayor
        Collections.sort(listaConsolidadosDeMismaSecuenciaZR, new Comparator() {
              public int compare(Object o1, Object o2) {
                DTOFACConsolidado dto1 = (DTOFACConsolidado) o1;
                DTOFACConsolidado dto2 = (DTOFACConsolidado) o2;
                
                Integer numSecueFactu1 = dto1.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria();
                Integer numSecueFactu2 = dto2.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria();
                
                // Criterio: numeroSecuenciaFacturacion de 'menor' a 'mayor'
                if (numSecueFactu1 != null) {
                    if (numSecueFactu2 != null) {
                        return numSecueFactu1.compareTo(numSecueFactu2);
                    } else {
                        return -1;
                    }
                } else {
                    if (numSecueFactu2 != null) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
              }
            });
        
        return (DTOFACConsolidado[])listaConsolidadosDeMismaSecuenciaZR.toArray(
                new DTOFACConsolidado[listaConsolidadosDeMismaSecuenciaZR.size()]);
    }

    /**
     * Metodo auxiliar que da soporte a resecuenciarConsolidados(...)
     * Del array de consolidados recibido (son del mismo Numero Secuencia Zona-Ruta) 
     * quita todos los pertenecientes a la zona que se indica por parametro y los 
     * devuelve en un nuevo array.
     * @autor eiraola
     * @since 07/Mar/2007
     */
    private ArrayList extraerDTOsPorZona(DTOFACConsolidado[] listaConsolidadosZonaRuta, Long oidZona) {
        int cantConsolidadosZR = listaConsolidadosZonaRuta.length;
        ArrayList listaConsolidadosDeMismaZona = new ArrayList();        
        DTOFACConsolidado dtoFACConso;
        Long oidZonaZR;
        
        for (int i = 0; i < cantConsolidadosZR; i++) {
            dtoFACConso = listaConsolidadosZonaRuta[i];
            if (dtoFACConso == null) {
                continue;
            }
            oidZonaZR = dtoFACConso.getDtoCabecera().getZona();
            if ( (oidZona != null && oidZona.equals(oidZonaZR))
                 || (oidZona == null && oidZonaZR == null) ) {
                listaConsolidadosDeMismaZona.add(dtoFACConso);
                listaConsolidadosZonaRuta[i] = null;
            }
        }
        return listaConsolidadosDeMismaZona;
    }

    /*
     * Metodo que realiza el CU Balancear area de chequeo (APE-119), debe llamarse
     * desde "FAC Arrancar facturacion"
     * @TODO: Deben eliminarse las variables inicio, fin y duracion. Tambien quitar
     *        las llamadas a mostrarArrayDtosFC(....)
     * @autor eiraola
     * @since 07/Mar/2007
     * @observaciones 23/Mar/2007 Se deja de utilizar por performance reemplazado por
     *                metodo de igual firma
     */
   /* public DTOFACConsolidado[] balancearAreaChequeo(DTOFACConsolidado[] listaConsolidados) 
            throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.balancearAreaChequeo(listaConsolidados): Entrada");
        Date inicio = new Date(); // debug
        try {
            UtilidadesLog.debug("ENTRADA - Resumen de los consolidados recibidos:");
            this.mostrarArrayDtosFC(listaConsolidados); // Traza para debug
            
            int cantidadConsolidados = listaConsolidados.length;
            DTOFACConsolidado consolidado;
            DTOOID dtoOid;
            Long oidCabeceraSolicitud;
            Long oidTipoRevision;
            
            Vector vUpdatePSCIndicadorRevision = new Vector();
            Vector vOidsPSC_IndRevi_Linea = new Vector();
            Vector vOidsPSC_IndRevi_Campo = new Vector();
            Vector vOidsPSC_IndRevi_Ambas = new Vector();
            Vector vOidsPSC_IndRevi_Nulo = new Vector();
            
            UtilidadesLog.debug("INDICADOR DE REVISION... *******************************");
            for (int i = 0; i < cantidadConsolidados; i++) {
                consolidado = listaConsolidados[i];
                UtilidadesLog.debug("== Cliente(oid): "+ consolidado.getDtoCabecera().getOidCliente() 
                                   +" ===================================================");
                oidCabeceraSolicitud = consolidado.getDtoCabecera().getOidCabeceraSolicitud();
                dtoOid = this.obtenerTipoRevisionCliente(consolidado.getDtoCabecera());
                oidTipoRevision = dtoOid.getOid();
                consolidado.getDtoCabecera().setIndicadorRevision(oidTipoRevision);
                
                // Acumulamos los oids de SolicitudCabecera para luego actualizar el campo 
                // indicadorRevision de dicha entidad de PED. Agrupamos por valor a actualizar.
                if (oidTipoRevision == null) {
                    vOidsPSC_IndRevi_Nulo.add(oidCabeceraSolicitud);
                    
                } else if (oidTipoRevision.equals(ConstantesPED.OID_REVISION_LINEA)) {
                    vOidsPSC_IndRevi_Linea.add(oidCabeceraSolicitud);
                    
                } else if (oidTipoRevision.equals(ConstantesPED.OID_REVISION_CAMPO)) {
                    vOidsPSC_IndRevi_Campo.add(oidCabeceraSolicitud);
                    
                } else if (oidTipoRevision.equals(ConstantesPED.OID_REVISION_AMBAS)) {
                    vOidsPSC_IndRevi_Ambas.add(oidCabeceraSolicitud);
                    
                }                
            } // fin for
            
            
            // Preparacion de los update sobre PED_SOLIC_CABEC.INRE_OID_INDI_REVI
            Vector vUpdateAux;
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Nulo, null);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Linea, ConstantesPED.OID_REVISION_LINEA);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Campo, ConstantesPED.OID_REVISION_CAMPO);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            vUpdateAux = this.armarUpdatePSCIndicadorRevision(vOidsPSC_IndRevi_Ambas, ConstantesPED.OID_REVISION_AMBAS);
            vUpdatePSCIndicadorRevision.addAll(vUpdateAux);
            
            // Ejecucion del script con los update
            UtilidadesLog.debug("*** Ejecutando Update del 'indicadorRevision' de 'Ped:Solicitud Cabecera' (masivo)...");
            invocarExecutor(vUpdatePSCIndicadorRevision);   // Actualiza el oid de Indicador de Revision
            
            
            UtilidadesLog.debug("RESECUENCIANDO CONSOLIDADOS... *************************");
            this.resecuenciarConsolidados(listaConsolidados);
            
            UtilidadesLog.debug("SALIDA - Resumen de los consolidados (con IndRevi actualizado y Resecuenciados):");
            this.mostrarArrayDtosFC(listaConsolidados); // Traza para debug
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            e.printStackTrace();
            throw new MareException("Error al balancearAreaChequeo", e);
        }
        Date fin = new Date(); // debug
        long duracion = fin.getTime() - inicio.getTime(); // debug
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.balancearAreaChequeo(listaConsolidados): Salida " + duracion + " miliseg.");
        return listaConsolidados;
    }*/

    /**
     * Recibe por parametro el valor actual del indicador de revision y un nuevo 
     * valor obtenido por otro concepto para el mismo cliente, y determina el valor 
     * final. Por ejemplo: Si el actual es “Linea” y el nuevo valor "Campo" retorna 
     * "Ambas" (el oid de dichos niveles de revision).
     * @autor eiraola
     * @since 12/Mar/2007
     * @observacion Metodo creado por Inc. BELC400000233
     */
    private Long determinarValorIndicadorRevision(Long oidIndRevisionActual, Long oidIndRevisionNuevo) 
            throws MareException {
        
        if (oidIndRevisionNuevo == null) {
            return oidIndRevisionActual;
        }
        
        if (oidIndRevisionActual == null) {
            return oidIndRevisionNuevo;
        }
        
        // Si alguno de los dos es "Ambas" o tienen valores no nulos y distintos
        if (oidIndRevisionActual.equals(ConstantesPED.OID_REVISION_AMBAS) || 
           oidIndRevisionNuevo.equals(ConstantesPED.OID_REVISION_AMBAS) ||
           !oidIndRevisionActual.equals(oidIndRevisionNuevo)) {
            return ConstantesPED.OID_REVISION_AMBAS;     // Ambas
        }
        
        // En cualquier otro caso (que sería cuando son iguales, ambos ya son "Campo"
        // o ambos "Linea") retornar el valor actual
        return oidIndRevisionActual;
    }

    /*
     * Genera un script sql para ejecutar un Update sobre PED_SOLIC_CABEC del
     * campo Oid de Indicador de Revision.
     * El script en cuestion se genera con los oids recibidos de los registros que 
     * actualizaremos y con el valor comun en cuestion para el campo.
     * Ej. UPDATE PED_SOLIC_CABEC SET INRE_OID_INDI_REVI = 3 WHERE OID_SOLI_CABE IN (1469, 1560, ....);
     * @autor eiraola
     * @since 09/Mar/2007
     * @observaciones:
     *     31/May/2007 eiraola - BELC400000459 - Metodo reemplazado por armarUpdatePSC
     */
    /*private Vector armarUpdatePSCIndicadorRevision(Vector oidsSolicitudCabecera, Long oidIndicadorRevision) 
            throws MareException {
        int cantUpdates = oidsSolicitudCabecera.size();
        Vector vUpdatePSCIndRevi = new Vector();
        if ( !(cantUpdates > 0) ) {
            return vUpdatePSCIndRevi;
        }
        
        UtilidadesLog.debug(" *** Se van a actualizar "+ cantUpdates 
                           +" registros de PedSolicCabec en su Indicador de Revision a: " + oidIndicadorRevision);
               
        StringBuffer updatePSCIndRevi = new StringBuffer();
        updatePSCIndRevi.append("UPDATE PED_SOLIC_CABEC");
        updatePSCIndRevi.append(" SET INRE_OID_INDI_REVI = "+ oidIndicadorRevision);
        updatePSCIndRevi.append(" WHERE OID_SOLI_CABE IN (");
        
        for (int i = 0; i < cantUpdates; i++) {
            if ( (i+1) < cantUpdates ) {
                if ((i+1)%1000 == 0) { // Fracciono la lista sql de a 1000 elementos (por restriccion del operador IN)
                    updatePSCIndRevi.append(oidsSolicitudCabecera.get(i) + ") OR OID_SOLI_CABE IN (");
                } else {
                    updatePSCIndRevi.append(oidsSolicitudCabecera.get(i) + ",");
                }
            } else {
                updatePSCIndRevi.append(oidsSolicitudCabecera.get(i));
            }
        }
        updatePSCIndRevi.append(");");
        
        vUpdatePSCIndRevi.add(updatePSCIndRevi);
        return vUpdatePSCIndRevi;
    }*/
    
    /**
     * Genera un script sql para ejecutar un Update sobre PED_SOLIC_CABEC de los
     * campos: Oid de Indicador de Revision y Codigo de Origen de Chequeo
     * El script en cuestion se genera con los oids recibidos de los registros que 
     * actualizaremos y con la combinacion de valores en comun pasada por parametro.
     * Ej. UPDATE PED_SOLIC_CABEC SET INRE_OID_INDI_REVI = 3, VAL_ORIG_CHEQ = 'M' 
     * WHERE OID_SOLI_CABE IN (1469, 1560, ....);
     * @autor eiraola
     * @since 31/May/2007
     */
    private StringBuffer armarUpdatePSC(ArrayList oidsSolicitudCabecera, CombinacionValoresCamposUpdate combinacionDatos) 
            throws MareException {
        int cantUpdates = oidsSolicitudCabecera.size();
        StringBuffer updatePSC = new StringBuffer();
        
        if ( !(cantUpdates > 0) ) {
            return updatePSC;
        }
        
        UtilidadesLog.debug(" *** Se van a actualizar "+ cantUpdates 
                           +" registros de PedSolicCabec en su Indicador de Revision a: " 
                           + combinacionDatos.getValorCampo1()
                           + " y Cod Origen Chequeo a: " + combinacionDatos.getValorCampo2());
        
        updatePSC.append("UPDATE PED_SOLIC_CABEC");
        updatePSC.append(" SET INRE_OID_INDI_REVI = "+ combinacionDatos.getValorCampo1());
        
        if (combinacionDatos.getValorCampo2() == null) {
            updatePSC.append(" , VAL_ORIG_CHEQ = NULL");
        } else {
            updatePSC.append(" , VAL_ORIG_CHEQ = '" + combinacionDatos.getValorCampo2() + "'");
        }
        
        updatePSC.append(" WHERE OID_SOLI_CABE IN (");
        
        for (int i = 0; i < cantUpdates; i++) {
            if ( (i+1) < cantUpdates ) {
                if ((i+1)%1000 == 0) { // Fracciono la lista sql de a 1000 elementos (por restriccion del operador IN)
                    updatePSC.append(oidsSolicitudCabecera.get(i) + ") OR OID_SOLI_CABE IN (");
                } else {
                    updatePSC.append(oidsSolicitudCabecera.get(i) + ",");
                }
            } else {
                updatePSC.append(oidsSolicitudCabecera.get(i));
            }
        }
        updatePSC.append(");");
        
        return updatePSC;
    }

    /**
     * Metodo auxiliar para ejecutar un script con sentencias Sql tipo UPDATE o 
     * DELETE realizando un unico acceso a BBDD (cada sentencia es un elemento de 
     * la clase StringBuffer en el Vector de entrada, y debe finalizar en ';')
     * @autor eiraola
     * @since 09/Mar/2007
     */
    private void invocarExecutor(Vector vExecutor) throws MareException {
        String query = new String ();
        int cantSentencias = vExecutor.size();
        UtilidadesLog.debug("    cantidad de sentencias a ejecutar_" + cantSentencias);
        if (cantSentencias == 0) return;
                
        for (int i=0; i< cantSentencias; i++){
            query = query + ((StringBuffer) vExecutor.get(i)).toString();
        }
        try {
            UtilidadesEJB.getBelcorpService().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query);
        } catch (Exception ex ) {
            UtilidadesLog.error(ex.getMessage());
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Agrupa los consolidados por periodo. Utiliza un hashtable donde la clave
     * es oidPerido y el valor es un ArrayList con los dtos (DTOFACConsolidado).
     * @author eiraola
     * @date 23/03/2007
     */
    private Hashtable agruparConsolidadosPorPeriodo(DTOFACConsolidado[] listaConsolidados) throws MareException {
        int cantConsolidados = listaConsolidados.length;
        Hashtable consolidadosAgrupados = new Hashtable();
        Long oidPeriodo;
        Long oidCliente;
        DTOFACConsolidado consolidado;
        ArrayList consolidadosPeriodo;
        
        for (int j = 0; j < cantConsolidados; j++) {
            consolidado = listaConsolidados[j];
            
            oidPeriodo = consolidado.getDtoCabecera().getPeriodo();
            oidCliente = consolidado.getDtoCabecera().getOidCliente();
            
            if (consolidadosAgrupados.containsKey(oidPeriodo)) {
                consolidadosPeriodo = (ArrayList)consolidadosAgrupados.get(oidPeriodo);
            } else {
                consolidadosPeriodo = new ArrayList();
            }
            consolidadosPeriodo.add(consolidado);
            consolidadosAgrupados.put(oidPeriodo, consolidadosPeriodo);
        }
        return consolidadosAgrupados;
    }

    /**
     * Arma una lista con los oids de cliente de los consolidados en proceso.
     * Utilizado en 'obtenerListaConsultorasEstatusNueva' para mediante una unica
     * consulta determinar cuales son las consultoras con estatus nueva
     * @author eiraola
     * @date 23/03/2007
     */
    private ArrayList obtenerListaClientes(ArrayList consolidados) throws MareException {
        ArrayList clientes = new ArrayList();
        DTOFACConsolidado dtoFacConso;
        Long oidCliente;
        
        int cantConsolidados = consolidados.size();
        for (int i = 0; i < cantConsolidados; i++) {
            dtoFacConso = (DTOFACConsolidado)consolidados.get(i);
            oidCliente = dtoFacConso.getDtoCabecera().getOidCliente();
            
            if (!clientes.contains(oidCliente)) {
                clientes.add(oidCliente);
            }
        }
        return clientes;
    }

    /**
     * Determina si la UA de la consultora del Consolidado (Sgv/region/zona/seccion)
     * corresponde (está incluida) con el ambito geografico de las UA que se pasan
     * por parametro (y que son las definidas en REC: Zonas de Chequeo en Campo).
     * Tiene en cuenta que si un nivel es null para alguna de las UA de REC: Zonas de 
     * Chequeo en Campo entonces significa 'todas validas' para dicho nivel.
     * @author eiraola
     * @date 23/03/2007
     */
    private boolean validarAmbitoGeograficoConsultora(ArrayList zonasChequeoCampo, DTOFACCabeceraSolicitud cabecera) {
        int cantZonasChq = zonasChequeoCampo.size();
        DTOChequeoZona zonaChq;
        Long oidSgv = cabecera.getOidSubgVentas();
        Long oidRegio = cabecera.getRegion();
        Long oidZona = cabecera.getZona();
        Long oidSecci = cabecera.getSeccion();
        
        boolean ambitoIncluido = false;
        
        UtilidadesLog.debug("          UA del cliente es (sgv/reg/zon/secc): " + oidSgv + "/" 
                                       + oidRegio + "/" + oidZona + "/" + oidSecci );
        for (int i = 0; i < cantZonasChq; i++) {
            zonaChq = (DTOChequeoZona)zonasChequeoCampo.get(i);
            
            
            if (zonaChq.getOidSubgerenciaVentas().equals(oidSgv)) {
                if (zonaChq.getOidRegion() == null) {
                    UtilidadesLog.debug("          Coincide SGV y Todas las Regiones son validas (para REC_ZONAS_CAMPO oid:"
                                        +zonaChq.getOid()+")");
                    ambitoIncluido = true;
                    break;
                    
                } else if (zonaChq.getOidRegion().equals(oidRegio)) {
                    if (zonaChq.getOidZona() == null) {
                        UtilidadesLog.debug("          Coincide SGV y Region y Todas las Zonas son validas (para REC_ZONAS_CAMPO oid:"
                                            +zonaChq.getOid()+")");
                        ambitoIncluido = true;
                        break;
                        
                    } else if (zonaChq.getOidZona().equals(oidZona)) {
                        if (zonaChq.getOidSeccion() == null) {
                            UtilidadesLog.debug("          Coincide SGV, Region y Zona y Todas las Secciones son validas (para REC_ZONAS_CAMPO oid:"
                                                +zonaChq.getOid()+")");
                            ambitoIncluido = true;
                            break;
                            
                        } else if (zonaChq.getOidSeccion().equals(oidSecci)) {
                            UtilidadesLog.debug("          Coincide SGV, Region, Zona y Seccion (para REC_ZONAS_CAMPO oid:"
                                                +zonaChq.getOid()+")");
                            ambitoIncluido = true;
                            break;
                        } // fin else if (seccion)
                    } // fin else if (zona)
                } // fin else if (region)
            } // fin if (sgv)
        } // fin for
        
        if (!ambitoIncluido) {
            UtilidadesLog.debug("          La UA del cliente no esta definida como 'Zona de Chequeo en Campo'");
        }
        
        return ambitoIncluido;
    }


    /** 
     * Dado el conjunto de oids de clientes de los consolidados en proceso y su periodo, 
     * se recupera de la entidad 'REC:Clientes a chequear' aquellos oids de consultoras
     * especificadas para chequeo y su indicador a aplicar.
     * Devolvemos un Hashtable cuya clave es oid del Cliente y el valor oid del Indicador de revision.
     * @author eiraola
     * @date 23/03/2007
     */
    public Hashtable obtenerClientesAChequear(ArrayList oidsClientes, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerClientesAChequear(oidsClientes, oidPeriodo): Entrada");
        Hashtable clientesAChequear = new Hashtable();
        
        DTOSalida dtoS = new DAOBalanceoAreaChequeo().obtenerClientesAChequear(oidsClientes, oidPeriodo);
        RecordSet rs = dtoS.getResultado();
        int cantClienACheq = rs.getRowCount();
        UtilidadesLog.debug(" --- Clientes a chequear ("+cantClienACheq+"): " + rs);
        
        Long oidCliente;
        Long oidIndiRevi;
        
        for (int i = 0; i < cantClienACheq; i++) {
            oidCliente = new Long(((BigDecimal) rs.getValueAt(i, "CLIE_OID_CLIE")).longValue());
            oidIndiRevi = new Long(((BigDecimal) rs.getValueAt(i, "INRE_OID_INDI_REVI")).longValue());
            
            clientesAChequear.put(oidCliente, oidIndiRevi);
        }
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerClientesAChequear(oidsClientes, oidPeriodo): Salida");
        return clientesAChequear;
    }

    /**
     * Dado el conjunto de oids de clientes de los consolidados que vamos a procesar
     * se recuperan los oids de clientes que corresponden a consultoras con estatus
     * 'Nueva'.
     * @author eiraola
     * @date 23/03/2007
     */
    public ArrayList obtenerListaConsultorasEstatusNueva(ArrayList oidsCliente) throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerListaConsultorasEstatusNueva(oidsClientes): Entrada");
        ArrayList consultorasEstatusNueva = new ArrayList();
        
        DTOSalida dtoS = new DAOBalanceoAreaChequeo().obtenerListaConsultorasEstatusNueva(oidsCliente);
        RecordSet rs = dtoS.getResultado();
        int cantNuevas = rs.getRowCount();
        UtilidadesLog.debug(" --- Clientes con estatus 'Nueva' ("+cantNuevas+"): " + rs);
        
        Long oidCliente;
        
        for (int i = 0; i < cantNuevas; i++) {
            oidCliente = new Long(((BigDecimal) rs.getValueAt(i, "CLIE_OID_CLIE")).longValue());
            consultorasEstatusNueva.add(oidCliente);
        }
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerListaConsultorasEstatusNueva(oidsClientes): Salida");
        return consultorasEstatusNueva;
    }

    /**
     * Obtiene la configuracion de Zonas de chequeo en Campo (REC) que determina
     * las UA especificadas para chequear en campo de forma completa.
     * @author eiraola
     * @date 23/03/2007
     */
    public ArrayList obtenerZonasChequeoEnCampo(Long periodo) throws MareException {
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerZonasChequeoEnCampo(periodo): Entrada");
        ArrayList zonasChequeoEnCampo = new ArrayList();
        
        DTOSalida dtoS = new DAOBalanceoAreaChequeo().obtenerZonasChequeoEnCampo(periodo);
        RecordSet rs = dtoS.getResultado();
        int cantZonasChequeo = rs.getRowCount();
        UtilidadesLog.debug(" --- Zonas de chequeo en campo ("+cantZonasChequeo+"): " + rs);
        
        DTOChequeoZona zonaChkCampo;
        Long oidZonaChequeoCampo;
        Long oidSgv;
        Long oidRegion;
        Long oidZona;
        Long oidSeccion;
        
        for (int i = 0; i < cantZonasChequeo; i++) {
            zonaChkCampo = new DTOChequeoZona();
            
            oidZonaChequeoCampo = new Long(((BigDecimal) rs.getValueAt(i, "OID_ZONA_CAMP")).longValue());
            
            oidSgv = new Long(((BigDecimal) rs.getValueAt(i, "ZSGV_OID_SUBG_VENT")).longValue());
            
            oidRegion = (rs.getValueAt(i, "ZORG_OID_REGI") != null) 
                     ? new Long(((BigDecimal) rs.getValueAt(i, "ZORG_OID_REGI")).longValue())
                     : null;
            
            oidZona = (rs.getValueAt(i, "ZZON_OID_ZONA") != null) 
                     ? new Long(((BigDecimal) rs.getValueAt(i, "ZZON_OID_ZONA")).longValue())
                     : null;
            
            oidSeccion = (rs.getValueAt(i, "ZSCC_OID_SECC") != null) 
                     ? new Long(((BigDecimal) rs.getValueAt(i, "ZSCC_OID_SECC")).longValue())
                     : null;
            
            zonaChkCampo.setOid(oidZonaChequeoCampo);
            zonaChkCampo.setOidSubgerenciaVentas(oidSgv);
            zonaChkCampo.setOidRegion(oidRegion);
            zonaChkCampo.setOidZona(oidZona);
            zonaChkCampo.setOidSeccion(oidSeccion);
            
            zonasChequeoEnCampo.add(zonaChkCampo);
        }
        UtilidadesLog.info("MONBalanceoAreaChequeoBean.obtenerZonasChequeoEnCampo(periodo): Salida");
        return zonasChequeoEnCampo;
    }

    /**
     * A traves del dao recupera el oid de revision apropiado a partir de la Configuracion
     * de Linea y de Campo para las consultoras nuevas en el periodo y UA del Consolidado. 
     * Como precondicion debe haberse validado que la consultora (cliente) del consolidado 
     * de entrada posea estatus 'nueva'.
     * @author eiraola
     * @date 23/03/2007
     */
    private Long obtenerIndicadorRevisionNueva(DTOFACCabeceraSolicitud cabecera) throws MareException {
        DTOOID dtoOid = new DAOBalanceoAreaChequeo().obtenerRevisionClientesNuevos(cabecera);
        return dtoOid.getOid();
    }
    
    /**
     * Ordenamos los consolidados por:
     *  Zona-Ruta y luego por el Numero de secuencia de Facturacion
     * @autor eiraola
     * @since 20/Jul/2007
     */
    private DTOFACConsolidado[] ordenarConsolidados(DTOFACConsolidado[] listaConsolidados) {
        int cantConsolidados = listaConsolidados.length;
        UtilidadesLog.debug(" --- procediendo a reordenar los " + cantConsolidados + " consolidados de la lista recibida");
        ArrayList listaConsolidadosAux = new ArrayList();
        
        for (int i = 0; i < cantConsolidados; i++) {
            listaConsolidadosAux.add(listaConsolidados[i]);
        }
        
        Collections.sort(listaConsolidadosAux, new Comparator() {
              public int compare(Object o1, Object o2) {
                DTOFACConsolidado dto1 = (DTOFACConsolidado) o1;
                DTOFACConsolidado dto2 = (DTOFACConsolidado) o2;
                
                /** PRIMER CRITERIO: Numero de secuencia Zona-ruta (de 'menor' a 'mayor')*/
                Integer numSecueZonaRuta1 = dto1.getDtoCabecera().getNumeroSecuenciaZonaRuta() ;
                Integer numSecueZonaRuta2 = dto2.getDtoCabecera().getNumeroSecuenciaZonaRuta();
                
                if (numSecueZonaRuta1 != null) {
                    if (numSecueZonaRuta2 != null) {
                        if (numSecueZonaRuta1.compareTo(numSecueZonaRuta2) == 0) {
                            /** SEGUNDO CRITERIO: Numero de secuencia facturacion (de 'menor' a 'mayor')*/
                            Integer numSecueFactu1 = dto1.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria();
                            Integer numSecueFactu2 = dto2.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria();
                            
                            if (numSecueFactu1 != null) {
                                if (numSecueFactu2 != null) {
                                    return numSecueFactu1.compareTo(numSecueFactu2);
                                } else {
                                    return -1;
                                }
                            } else {
                                if (numSecueFactu2 != null) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                            }
                            /** ************************************************/
                        } else {
                            return numSecueZonaRuta1.compareTo(numSecueZonaRuta2);
                        }
                    } else {
                        return -1;
                    }
                } else {
                    if (numSecueZonaRuta2 != null) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                /** ************************************************/
                
              }
            });
        
        return (DTOFACConsolidado[])listaConsolidadosAux.toArray(new DTOFACConsolidado[cantConsolidados]);
    }

    /**
     * Metodo unicamente para debug.
     * @TODO: Eliminar este metodo y sus llamadas en este MON.
     * @autor eiraola
     * @since 07/Mar/2007
     */
    private void mostrarArrayDtosFC(DTOFACConsolidado[] arra) {
        int cantDtos = arra.length;
        UtilidadesLog.debug("Conso (oidCabeceraSolicitud) | oidClie | SecueZ-R | Zona | NumSecueFactu | IndRevis (oidIndRevi)");
        UtilidadesLog.debug("-------------------------------------------------------------------------");
        for (int i = 0; i < cantDtos; i++) {
            Long tipoRevision = arra[i].getDtoCabecera().getIndicadorRevision();
            String tipoRevi = new String();
            
            if (tipoRevision != null) {
                switch (tipoRevision.intValue()) {
                  case 1:
                      tipoRevi = "L (1)";
                      break;
                  case 2:
                      tipoRevi = "C (2)";
                      break;
                  case 3:
                      tipoRevi = "A (3)";
                      break;
                  default:
                      break;
                }
            }
            UtilidadesLog.debug(arra[i].getDtoCabecera().getOidCabeceraSolicitud() + "  "
                    + arra[i].getDtoCabecera().getOidCliente() + "  "
                    + arra[i].getDtoCabecera().getNumeroSecuenciaZonaRuta() + "  "
                    + arra[i].getDtoCabecera().getZona() + "  "
                    + arra[i].getDtoCabecera().getNumeroSecuenciaFacturacionDiaria() + "  "
                    + tipoRevi);
        }
    }


    /**
     * INNER CLASS que se utiliza solamente como "estructura de datos" para organizar
     * la generacion del UPDATE de PED_SOLIC_CABEC en el metodo balancearAreaChequeo
     * NO forma parte del DMCO
     * @author eiraola
     * @since 31/05/2007
     */
    private class CombinacionValoresCamposUpdate {
        private Long valorCampo1;
        private String valorCampo2;
        
        public CombinacionValoresCamposUpdate(Long v1, String v2) {
            this.valorCampo1 = v1;
            this.valorCampo2 = v2;
        }
        
        public Long getValorCampo1() {
            return this.valorCampo1;
        }
        
        public String getValorCampo2() {
            return this.valorCampo2;
        }
        
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            
            CombinacionValoresCamposUpdate otraCombinacion = (CombinacionValoresCamposUpdate) obj;
            
            // Verificamos igualdad de valor en Campo1
            if (this.getValorCampo1() == null) {
                if (otraCombinacion.getValorCampo1() != null) {
                    return false;
                }
            } else if (!this.getValorCampo1().equals(otraCombinacion.getValorCampo1())) {
                return false;
            }
            
            // Verificamos igualdad de valor en Campo2
            if (this.getValorCampo2() == null) {
                if (otraCombinacion.getValorCampo2() != null) {
                    return false;
                }
            } else if (!this.getValorCampo2().equals(otraCombinacion.getValorCampo2())) {
                return false;
            }
            
            return true;
        }
        
        public int hashCode() {
            int hash;
            hash = ((this.getValorCampo1() == null) ? 0 : this.getValorCampo1().hashCode())
                   + ((this.getValorCampo2() == null) ? 0 : this.getValorCampo2().hashCode());
            return hash;
        }
        
        public String toString() {
            return "(" + this.valorCampo1 + ", " + this.valorCampo2 + ")";
        }
    } // fin INNER CLASS CombinacionValoresCamposUpdate
}