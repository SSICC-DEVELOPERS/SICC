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

import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.rec.DTOBuscarEnvia;
import es.indra.sicc.dtos.rec.DTOChequeo;
import es.indra.sicc.dtos.rec.DTOChequeoEnCampo;
import es.indra.sicc.dtos.rec.DTOChequeoEnLinea;
import es.indra.sicc.dtos.rec.DTOChequeoManual;
import es.indra.sicc.dtos.rec.DTOChequeoZona;
import es.indra.sicc.dtos.rec.DTOEvaluarChequeo;
import es.indra.sicc.entidades.rec.ConfClientesChequeoEnCampoLocal;
import es.indra.sicc.entidades.rec.ConfClientesChequeoEnCampoLocalHome;
import es.indra.sicc.entidades.rec.ZonasChequeoEnCampoLocal;
import es.indra.sicc.entidades.rec.ZonasChequeoEnCampoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.rec.ConfClientesChequeoEnLineaLocal;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesError;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.rec.ClientesAChequearLocal;
import es.indra.sicc.entidades.rec.ClientesAChequearLocalHome;
import es.indra.sicc.entidades.rec.ConfClientesChequeoEnLineaLocalHome;
import es.indra.sicc.entidades.rec.ParametrizacionChequeoLocalHome;
import es.indra.sicc.entidades.rec.ParametrizacionChequeoLocal;
import es.indra.sicc.entidades.rec.ChequeoUALocalHome;
import es.indra.sicc.entidades.rec.ChequeoUALocal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.LogAPP;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoOrdenChequeoBean implements SessionBean {

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
   
   public void evaluarClientesChequear(MareDTO dtoE) throws MareException {
   
      // Permite evaluar que consultoras serán chequeadas durante el periodo recibido       
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarClientesChequear(MareDTO):Entrada");
      
      // Obtiene los clientes de chequeo en linea 
      Long oidPeriodo = new Long(dtoE.getLong(ConstantesCRA.DATO_PERIODO));

      // vbongiov -- Cambio 20080756 -- 29/04/2009
       DAORec daoRec = new DAORec();
       
       // verifica si el periodo ya fue chequeado
       if(daoRec.validarPeriodoChequeado(oidPeriodo)){
           throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC + 
                                                                                ErroresDeNegocio.PERIODO_YA_GENERADO));
       }
       
       // Evaluar consultoras Reincidentes
       // Evalua Linea
       DTOEvaluarChequeo dtoEvaluarChequeoReincidenteL = daoRec.obtenerParametrizacionChequeReincidente(oidPeriodo,
                                                                                ConstantesREC.COD_TIPO_REVISION_LINEA);
                                                                                
       if(dtoEvaluarChequeoReincidenteL!= null){
           daoRec.insertarChequeReincidenteL(dtoEvaluarChequeoReincidenteL);
       }
       
       // Evalua Campo
       DTOEvaluarChequeo dtoEvaluarChequeoReincidenteC = daoRec.obtenerParametrizacionChequeReincidente(oidPeriodo,
                                                                                ConstantesREC.COD_TIPO_REVISION_CAMPO);
                                                                                
       if(dtoEvaluarChequeoReincidenteC!= null){
           daoRec.insertarChequeReincidenteC(dtoEvaluarChequeoReincidenteC);
       }
        
       // Evaluar consultoras por Tipologia de Clientes
       // Evalua Linea
       daoRec.insertarChequeTipologiaClienteL(oidPeriodo);
       
       // Evalua Campo
       daoRec.insertarChequeTipologiaClienteC(oidPeriodo);
       
       
       // Evaluar consultoras por Unidad Administrativa
       // Evalua Linea
       daoRec.insertarChequeUnidadAdministrativaL(oidPeriodo);
       
       // Evalua Campo
       daoRec.insertarChequeUnidadAdministrativaC(oidPeriodo);
       
       // Actualiza como periodo chequeado el periodo procesado
        daoRec.insertarPeriodoChequeado(oidPeriodo);
        
       LogAPP.error("[REC] Proceso Terminado");
      
       UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarClientesChequear(MareDTO):Salida");
   }
   
  
   private void guardarClientesChequeoLinea(RecordSet clientes, Long oidPeriodo) throws MareException {
      
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.guardarClientesChequeoLinea(RecordSet clientes, Long):Entrada"); 
      
		// Guarda los clientes recibidos en la entidad ClientesAChequear 
		// Además activa el indicador Generado de la configuración de clientes en linea correspondiente a los clientes. 
		// Un grupo de clientes puede pertenecer a una misma configuración, por tanto se comprueba cada configuración con la anterior para activar el indicador una sola vez. 

      UtilidadesLog.debug("--- oidPeriodo: " + oidPeriodo);

		Long oidConfiguracion = null;
      Long oidConfiguracionActual = new Long(0); 
      
      Long oidCliente = null;
      
      ClientesAChequearLocalHome clientesCheqLocalHome = new ClientesAChequearLocalHome();
      ClientesAChequearLocal clienteChequear = null;
      
      ConfClientesChequeoEnLineaLocalHome confClientesLineaLocalHome = new ConfClientesChequeoEnLineaLocalHome();
      ConfClientesChequeoEnLineaLocal confClientesLineaLocal = null;

		// Recorre el RecordSet clientes utilizando el contador posicion  { 
      for (int posicion=0; posicion < clientes.getRowCount(); posicion++) {
      
         // oidCliente = clientes.getValueAt(posicion, "OID_CLIENTE")
         oidCliente = new Long(((BigDecimal)clientes.getValueAt(posicion, "OID_CLIENTE")).longValue());

         // Primero se comprueba si el registro existe porque se insertó manualmente. En ese caso no se 
         // vuelve a insertar. 
         // clienteChequear = ClientesAChequear.findByUK(oidCliente, oidPeriodo, tipoChequeo) 
         clienteChequear = null;
         try {
            UtilidadesLog.debug("--- oidCliente: " + oidCliente);
            // BELC300020480
            clienteChequear = clientesCheqLocalHome.findByUK(oidCliente, oidPeriodo, ConstantesPED.OID_REVISION_LINEA);
         } catch(NoResultException fe) {
         
            UtilidadesLog.debug("--- en el catch. No se encontro => se hace el create");
            
            // Si clienteChequear == null 
            // { 
            // Crea una entrada en la entidad ClientesAChequear con: 
            // - cliente = oidCliente 
            // - periodo = oidPeriodo 
            // - tipoRevision = ConstantesREC.CHEQUEO_EN_LINEA 
            // } 
            try {
               // incidencia BELC300015892, 22741
               clientesCheqLocalHome.create(ConstantesPED.OID_REVISION_LINEA, oidCliente, oidPeriodo);
            } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               UtilidadesLog.error("MONMantenimientoOrdenChequeo.guardarClientesChequeoLinea: FinderException", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }            
         }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
         
         // Activa el indicador Generado de la configuración en linea 
         // oidConfiguracion = clientes.getValueAt(posicion, "OID_CONFIGURACION") 
         oidConfiguracion = new Long(((BigDecimal)clientes.getValueAt(posicion, "OID_CONFIGURACION")).longValue());
         
         // Si oidConfiguracionActual != oidConfiguracion 
         if (oidConfiguracionActual.compareTo(oidConfiguracion) != 0) {
            // configuracionChequeo = ConfiguracionClientesChequeoEnLinea.findByPrimaryKey(oidConfiguracion) 
            try {
               confClientesLineaLocal = confClientesLineaLocalHome.findByPrimaryKey(oidConfiguracion);
            } catch(NoResultException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               UtilidadesLog.error("MONCambiosDePrecios.buscarGeneracion: Finder", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }               
            // INCIDENCIA BELC300015850
            // configuracionChequeo.indGenerado = True 
            confClientesLineaLocal.setIndGenerado(Boolean.TRUE);
             confClientesLineaLocalHome.merge(confClientesLineaLocal);
            // oidConfiguracionActual = oidConfiguracion 
            oidConfiguracionActual = oidConfiguracion;
         }
		}
   
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.guardarClientesChequeoLinea(RecordSet clientes, Long):Salida"); 
   }
   

   
   private void guardarClientesChequeoCampo(Long oidPeriodo, RecordSet clientes) throws MareException {
   
  		// Guarda los clientes recibidos en la entidad ClientesAChequear 
		// Además activa el indicador Generado de la configuración de clientes en campo 
      // correspondiente a los clientes. 
      
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.guardarClientesChequeoCampo(Long , RecordSet):Entrada"); 
      
      UtilidadesLog.debug("--- oidPeriodo: " + oidPeriodo);
      
      Long oidCliente = null;
     
      ClientesAChequearLocalHome clientesCheqLocalHome = new ClientesAChequearLocalHome();
      ClientesAChequearLocal clienteChequear = null;
      
		// Recorre el RecordSet clientes utilizando el contador posicion 
      for (int posicion=0; posicion < clientes.getRowCount(); posicion++) {
		
         // oidCliente = clientes.getValueAt(posicion, "OID_CLIENTE") 
         oidCliente = new Long(((BigDecimal)clientes.getValueAt(posicion, "CLIE_OID_CLIE")).longValue());
         
         UtilidadesLog.debug("--- antes del findByUK -> oidCliente: " + oidCliente);
   
         // Primero se comprueba si el registro existe porque se insertó manualmente. En ese caso no 
         // se vuelve a insertar. 
         // clienteChequear = ClientesAChequear.findByUK(oidCliente, oidPeriodo, tipoChequeo) 

         clienteChequear = null;
         try {
            // BELC300020480, 22741
            clienteChequear = clientesCheqLocalHome.findByUK(oidCliente, oidPeriodo, ConstantesPED.OID_REVISION_CAMPO);
         } catch(NoResultException fe) {
            
            UtilidadesLog.debug("--- en el catch. No se encontro => se hace el create");
         
            // Si clienteChequear == null 
            // { 
            // Crea una entrada en la entidad ClientesAChequear con: 
            // - cliente = oidCliente 
            // - periodo = oidPeriodo 
            // - tipoRevision = ConstantesREC.CHEQUEO_EN_CAMPO 
            // } 
            try {
               // incidencia BELC300015892,22741
               clientesCheqLocalHome.create(ConstantesPED.OID_REVISION_CAMPO, oidCliente, oidPeriodo);
            } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               UtilidadesLog.error("MONMantenimientoOrdenChequeo.guardarClientesChequeoCampo: CreateException", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }            
         }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
		}
      
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.guardarClientesChequeoCampo(Long , RecordSet):Salida"); 
   }

   // Agregado por SiCC20080563 - Rafael Romero - 19/02/2008
   // Metodo sobrecargado para limitar inserciones.
   private void guardarClientesChequeoCampo(Long oidPeriodo, RecordSet clientes, Long N) throws MareException {
   
  		// Guarda los clientes recibidos en la entidad ClientesAChequear 
		// Además activa el indicador Generado de la configuración de clientes en campo 
      // correspondiente a los clientes.
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.guardarClientesChequeoCampo(Long , RecordSet, Long):Entrada"); 
      
      UtilidadesLog.debug("--- oidPeriodo: " + oidPeriodo);
      
      long inserciones = 0;
      
      
      Long oidCliente = null;
     
      ClientesAChequearLocalHome clientesCheqLocalHome = new ClientesAChequearLocalHome();
      ClientesAChequearLocal clienteChequear = null;
      
		// Recorre el RecordSet clientes utilizando el contador posicion 
      for (int posicion=0; posicion < clientes.getRowCount(); posicion++) {
		
         // oidCliente = clientes.getValueAt(posicion, "OID_CLIENTE") 
         oidCliente = new Long(((BigDecimal)clientes.getValueAt(posicion, "OID_CLIENTE")).longValue());
         
         UtilidadesLog.debug("--- antes del findByUK -> oidCliente: " + oidCliente);
   
         // Primero se comprueba si el registro existe porque se insertó manualmente. En ese caso no 
         // se vuelve a insertar. 
         // clienteChequear = ClientesAChequear.findByUK(oidCliente, oidPeriodo, tipoChequeo) 

         clienteChequear = null;
         try {
            // BELC300020480, 22741
            clienteChequear = clientesCheqLocalHome.findByUK(oidCliente, oidPeriodo, ConstantesPED.OID_REVISION_CAMPO);
         } catch(NoResultException fe) {
            
            UtilidadesLog.debug("--- en el catch. No se encontro => se hace el create");
         
            // Si clienteChequear == null 
            // { 
            // Crea una entrada en la entidad ClientesAChequear con: 
            // - cliente = oidCliente 
            // - periodo = oidPeriodo 
            // - tipoRevision = ConstantesREC.CHEQUEO_EN_CAMPO 
            // } 
            try {
               // incidencia BELC300015892,22741
               clientesCheqLocalHome.create(ConstantesPED.OID_REVISION_CAMPO, oidCliente, oidPeriodo);
               inserciones++;
               if(inserciones==N.longValue()) break;
            } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               UtilidadesLog.error("MONMantenimientoOrdenChequeo.guardarClientesChequeoCampo: CreateException", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }            
         }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
		}
      
      UtilidadesLog.debug("El contador de insersiones finaliza en :["+inserciones+"]"); 
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.guardarClientesChequeoCampo(Long , RecordSet, Long):Salida"); 
   }
   // Fin agregado SiCC20080563


   private void evaluarConsultorasFaltanteMercaderia(Long oidConfiguracion, Long N, Long oidPeriodo) throws MareException {
      
      // Obtiene las consultoras que tengan más operaciones de faltante de mercaderías 
      
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarConsultorasFaltanteMercaderia(Long , Long, Long):Entrada");
      
      UtilidadesLog.debug("--- oidConfiguracion: " + oidConfiguracion);
      UtilidadesLog.debug("--- N: " + N);
      UtilidadesLog.debug("--- oidPeriodo: " + oidPeriodo);

		//ClientesAChequearLocalHome clientesCheqLocalHome = this.getClientesAChequearLocalHome();
      
      //Long oidCliente = null;
      
      // consultoras = DAORec.evaluarConsultorasFaltanteMercaderia(oidConfiguracion)
      RecordSet consultoras = new DAORec().obtenerConsultorasFaltanteMercaderia(oidConfiguracion);
      		
      // Modificado por SiCC20080563 - Rafael Romero - 19/02/2008
      // Genera una entrada en la entidad ClientesAChequear para los N clientes con más reclamos 

      // clientesConMasReclamos = N primeros elementos del RecordSet consultoras 
      // el RecordSet consultoras viene ordenado por NUMERO_OPERACIONES en orden descendente
      /*
      RecordSet clientesConMasReclamos = new RecordSet();
      clientesConMasReclamos.setColumnIdentifiers(consultoras.getColumnIdentifiers());
      for (int i=0; i < N.intValue(); i++) {
         
        if (i >= consultoras.getRowCount()) break;
        clientesConMasReclamos.addRow(consultoras.getRow(i));
      }
      */
      // guardarClientesChequeoCampo(oidPeriodo, clientesConMasReclamos)
      this.guardarClientesChequeoCampo(oidPeriodo, consultoras, N);
      // Fin modificado SiCC20080563
            
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarConsultorasFaltanteMercaderia(Long , Long, Long):Salida");
   }
   
   // BELC300016083
   private void generarChequeoCampoAutomatico(Long oidPeriodo) throws MareException {
      
      // Calcula el número de chequeos generados en campo y si es necesario genera nuevos 
      // chequeos para las consultoras con mayor número de operaciones de faltante de mercadería 
      
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.generarChequeoCampoAutomatico(Long):Entrada");
      
      UtilidadesLog.debug("--- oidPeriodo: " + oidPeriodo);
      
      ClientesAChequearLocalHome clientesCheqLocalHome = new ClientesAChequearLocalHome();
      Collection clientesChequear = null;
      
	  // Obtiene el número total de clientes a chequear de tipo 'en Campo' para el periodo recibido 
      int numeroTotalChequeos;
      
      try {
              //  Modificado por Incidencia Sicc20080563
              clientesChequear = clientesCheqLocalHome.findByPeriodoTipoChequeo(oidPeriodo, ConstantesPED.OID_REVISION_CAMPO);
              
              numeroTotalChequeos = clientesChequear.size();
          
              // Obtiene el número de chequeos a generar automaticamente 
              // configuracionChequeo = ConfiguracionClientesChequeoEnCampo.findByUK(oidPeriodo) 
                // numeroChequeosGenerar = configuracionChequeo.cantidadTotalConsultoras - numeroTotalChequeos 
              ConfClientesChequeoEnCampoLocal configuracionChequeo = null;
                
              try {
                 configuracionChequeo = new ConfClientesChequeoEnCampoLocalHome().findByUK(oidPeriodo);
                 int numeroChequeosGenerar = new Integer(configuracionChequeo.getCantidadTotalConsultoras()).intValue() - numeroTotalChequeos;
          
                // Si numeroChequeosGenerar > 0 
                 if (numeroChequeosGenerar > 0) {
                    // evaluarConsultorasFaltanteMercaderia(oidConfiguracion, numeroChequeosGenerar, oidPeriodo) 
                    this.evaluarConsultorasFaltanteMercaderia(configuracionChequeo.getOid(), new Long(numeroChequeosGenerar), oidPeriodo);
                 }                
              } catch(NoResultException e) {
                // ctx.setRollbackOnly();
                // String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                 UtilidadesLog.error("MONMantenimientoOrdenChequeo.generarChequeoCampoAutomatico: FinderException");
                 UtilidadesLog.error("getConfClientesChequeoEnCampoLocalHome().findByUK");
                // throw new MareException(e, UtilidadesError.armarCodigoError(error));
                 /* throw new MareException(e, UtilidadesError.armarCodigoError(error));
               * Se comenta esta linea por la inc 1046 de Belcorp. Segun el DT se deben correr ambos procesos en linea y en campo
               * pero no se encuentran configurados en algunos de los dos no implica que deba cortarse el proceso.. que es lo que estaba
               * haciendo esta MareException. mamontie 16/05/2006 Igualmente existe una incidencia pendiente con este problema. No existe 
               * un acuerdo con lo solicitado por el cliente y lo diseñado por DT
               * */                
              }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
                        
        } catch(NoResultException e) {
       //  String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         UtilidadesLog.error("MONMantenimientoOrdenChequeo.generarChequeoCampoAutomatico: findByPeriodoTipoChequeo");
         //throw new MareException(e, UtilidadesError.armarCodigoError(error));
           /* throw new MareException(e, UtilidadesError.armarCodigoError(error));
         * Se comenta esta linea por la inc 1046 de Belcorp. Segun el DT se deben correr ambos procesos en linea y en campo
         * pero no se encuentran configurados en algunos de los dos no implica que deba cortarse el proceso.. que es lo que estaba
         * haciendo esta MareException. mamontie 16/05/2006 Igualmente existe una incidencia pendiente con este problema. No existe 
         * un acuerdo con lo solicitado por el cliente y lo diseñado por DT
         * */
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.generarChequeoCampoAutomatico(Long):Salida");   
   }

   private void evaluarChequeoCampo(Long oidPeriodo) throws MareException {
      
      // Evalua los clientes a chequear en campo 
      
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarChequeoCampo(Long):Entrada");
      
      UtilidadesLog.debug("--- oidPeriodo: " + oidPeriodo);
      
		// Obtiene los clientes de chequeo en campo 
		// clientesCampo = DAORec.obtenerClientesChequeoCampo(oidPeriodo)
      RecordSet clientesCampo = new DAORec().obtenerClientesChequeoCampo(oidPeriodo);

		// Guarda los clientes recuperados 
		// guardarClientesChequeoCampo(oidPeriodo, clientesCampo)
      this.guardarClientesChequeoCampo(oidPeriodo, clientesCampo);

		// Genera el chequeo en campo automático 
		// generarChequeoCampoAutomatico(oidPeriodo, clientesCampo) 
      // BELC300016083
      this.generarChequeoCampoAutomatico(oidPeriodo);

		// Activa el indicador Generado de la configuración en linea 
		// configuracionChequeo = ConfiguracionClientesChequeoEnCampo.findByUK(oidPeriodo) 
		// configuracionChequeo.indGenerado = True      
      ConfClientesChequeoEnCampoLocal configuracionChequeo = null;
      ConfClientesChequeoEnCampoLocalHome confLH =new ConfClientesChequeoEnCampoLocalHome();
      
      try {
         configuracionChequeo = confLH.findByUK(oidPeriodo);
          // incidencia BELC300015908
        configuracionChequeo.setIndGenerado(Boolean.TRUE);   
        confLH.merge(configuracionChequeo);
      } catch(NoResultException e) {
        // ctx.setRollbackOnly();
        // String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         UtilidadesLog.error("MONMantenimientoOrdenChequeo.evaluarChequeoCampo: FinderException");
        /* throw new MareException(e, UtilidadesError.armarCodigoError(error));
         * Se comenta esta linea por la inc 1046 de Belcorp. Segun el DT se deben correr ambos procesos en linea y en campo
         * pero no se encuentran configurados en algunos de los dos no implica que deba cortarse el proceso.. que es lo que estaba
         * haciendo esta MareException. mamontie 16/05/2006 Igualmente existe una incidencia pendiente con este problema. No existe 
         * un acuerdo con lo solicitado por el cliente y lo diseñado por DT
         * */
      } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }    
      
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarChequeoCampo(Long):Salida");
   }
   
   private void evaluarChequeoLinea(Long oidPeriodo) throws MareException {
      
      // Evalua los clientes a chequear en linea 
     
      UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarChequeoLinea(Long):Entrada");
      
      RecordSet clientesLinea = new DAORec().obtenerClientesChequeoLinea(oidPeriodo); 

      // Guarda los clientes recuperados 
      this.guardarClientesChequeoLinea(clientesLinea, oidPeriodo);

      UtilidadesLog.info("MONMantenimientoOrdenChequeo.evaluarChequeoLinea(Long):Salida");
   }

   public DTOSalida obtenerTiposOrdenChequeo(DTOBelcorp dtoE) throws MareException {
      
      // Obtiene los tipos de ordenes de chequeo 

      UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerTiposOrdenChequeo(DTOBelcorp):Entrada");
      
      // Crea DTOSalida con: 
      // - resultado = DAOChequeos.obtenerTiposOrdenChequeo(DTOE) 
      RecordSet resultado = new DAOChequeos().obtenerTiposOrdenChequeo(dtoE);
      
      //Devuelve DTOSalida

      UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerTiposOrdenChequeo(DTOBelcorp):Salida");

      return new DTOSalida(resultado);
   }
   
    public DTOSalida obtenerPeriodosReclamo (DTOBelcorp dtoE) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerPeriodosReclamo(DTOBelcorp):Entrada");
        RecordSet resultado = new DAORec().obtenerPeriodosReclamo(dtoE);
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerPeriodosReclamo(DTOBelcorp):Salida");
        
        return new DTOSalida(resultado);
    }

    
    public DTOChequeoEnCampo obtenerChequeoEnCampo (DTOOID dto) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerChequeoEnCampo (DTOOID):Entrada");
        // Comprueba si para el periodo recibido existen chequeos en campo y zonas de chequeo definidos 
        ConfClientesChequeoEnCampoLocal chequeoClientes = null;
      
        try {
            chequeoClientes = new ConfClientesChequeoEnCampoLocalHome().findByUK(dto.getOid());
        } catch(NoResultException e) {
            UtilidadesLog.error("MONMantenimientoOrdenChequeo.obtenerChequeoEnCampo: FinderException", e);
        } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        DTOChequeoEnCampo dtoChequeo = new DTOChequeoEnCampo();
        if (chequeoClientes != null) {
            dtoChequeo.setOid(chequeoClientes.getOid());
            dtoChequeo.setOidPeriodo(chequeoClientes.getPeriodo()); 
            dtoChequeo.setCantidadTotalChequear(chequeoClientes.getCantidadTotalConsultoras()); 
            dtoChequeo.setOidPeriodoInicial(chequeoClientes.getPeriodoInicial());
            dtoChequeo.setOidPeriodoFinal( chequeoClientes.getPeriodoFinal());
            if (chequeoClientes.getPeriodoReclamo() != null)
                dtoChequeo.setOidPeriodoReclamo(new Long(chequeoClientes.getPeriodoReclamo())); 
            dtoChequeo.setConsultoraNueva(chequeoClientes.getIndChequearNuevas()); 
    
            dtoChequeo.setBusquedaZonas(new DAORec().obtenerZonasChequeo(chequeoClientes.getOid())); 
        }

        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerChequeoEnCampo (DTOOID):Salida");
        
        return dtoChequeo;
    }
    
    public void grabarChequeoManual (DTOChequeo dto) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoManual (DTOChequeo):Entrada");
        //Graba la lista de clientes a chequear 

        if (dto.getListaChequeos() != null ) {
            for (int i = 0; i < dto.getListaChequeos().size(); i++) {
                DTOChequeoManual cliente = (DTOChequeoManual)dto.getListaChequeos().get(i);
                // vbongiov -- Cambio 20080756 -- 29/04/2009
                this.grabarClienteAChequear(cliente); 
            }
        }

        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoManual (DTOChequeo):Salida");
    }

    public void grabarClienteAChequear (DTOChequeoManual dto) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarClienteAChequear (DTOChequeoManual):Entrada");
        // Guarda un cliente a chequear 
         DAORec daoRec = new DAORec();

        // Comprueba si el cliente existe 
        ClienteDatosBasicosLocal cliente = null;
        
        UtilidadesLog.debug("dto.getOidPais(): " + dto.getOidPais());
        UtilidadesLog.debug("dto.getCodigoCliente(): " + dto.getCodigoCliente());
      
        try {
            ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = new ClienteDatosBasicosLocalHome();
            cliente = clienteDatosBasicosLocalHome.findByCodigoYPais(dto.getOidPais(), dto.getCodigoCliente());
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONMantenimientoOrdenChequeo.grabarClienteAChequear: FinderException", e);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "",
						ErroresNegocio.PED_035));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }   
        
        // vbongiov -- Cambio 20080756 -- 29/04/2009
        try {
            RecordSet rsPeriodoAInsertar = daoRec.obtenerPeriodosAInsertar(dto.getOidPeriodoDesde(), dto.getOidPeriodoHasta());
            int cant = rsPeriodoAInsertar.getRowCount();
            
            for(int i=0; i < cant; i++){
                
                new ClientesAChequearLocalHome().create(dto.getOidTipoRevision(), cliente.getOid(), 
                                                        Long.valueOf(((BigDecimal)rsPeriodoAInsertar.getValueAt(i, "OID_PERI")).toString()));
            }        
            
        } catch(PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONMantenimientoOrdenChequeo.grabarClienteAChequear: CreateException", e);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarClienteAChequear (DTOChequeoManual):Salida");
    }
    
    
    public void grabarChequeoLineaCampo(DTOChequeo dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoLineaCampo(DTOChequeo dtoe):Entrada");
        //Graba la lista de clientes a chequear 
        try {
            if (dtoe.getListaChequeos() != null ) {
            
                DTOChequeoZona dtoChequeoZona = null;
                DAORec daoRec = new DAORec();
                ChequeoUALocalHome chequeoUALocalHome = new ChequeoUALocalHome();
                ChequeoUALocal chequeoUALocal = null;
                
                for (int i = 0; i < dtoe.getListaChequeos().size(); i++) {
                
                    dtoChequeoZona = (DTOChequeoZona)dtoe.getListaChequeos().get(i);
                    
                    RecordSet rsPeriodoAInsertar = daoRec.obtenerPeriodosAInsertar(dtoChequeoZona.getOidPeriodoDesde(), dtoChequeoZona.getOidPeriodoHasta());
                    int cant = rsPeriodoAInsertar.getRowCount();
                    
                    for(int j=0; j < cant; j++){
                    
                        chequeoUALocal = chequeoUALocalHome.create();
                        
                        chequeoUALocal.setOidPeriodo(Long.valueOf(((BigDecimal)rsPeriodoAInsertar.getValueAt(j, "OID_PERI")).toString()));
                        chequeoUALocal.setOidSubgerenciaVenta(dtoChequeoZona.getOidSubgerenciaVentas());
                        chequeoUALocal.setOidRegion(dtoChequeoZona.getOidRegion());
                        chequeoUALocal.setOidZona(dtoChequeoZona.getOidZona());
                        chequeoUALocal.setOidSeccion(dtoChequeoZona.getOidSeccion());
                        
                        if(dtoChequeoZona.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_LINEA)){
                             chequeoUALocal.setOidTipoChequeo(ConstantesREC.OID_TIPO_REVISION_LINEA);
                        } else if(dtoChequeoZona.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_CAMPO)){
                            chequeoUALocal.setOidTipoChequeo(ConstantesREC.OID_TIPO_REVISION_CAMPO);
                        }
                        
                        chequeoUALocalHome.merge(chequeoUALocal);
                    }     
                }
            }
        } catch(PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONMantenimientoOrdenChequeo.grabarChequeoLineaCampo: CreateException", e);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }   
        
        ParametrizacionChequeoLocalHome parametrizacionChequeoLocalHome = new ParametrizacionChequeoLocalHome();
        ParametrizacionChequeoLocal parametrizacionChequeoLocal = null;
            
        try{
            
            // Obtiene la parametrizacion del tipo de chequeo si existe
            if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_LINEA)){
                 parametrizacionChequeoLocal = parametrizacionChequeoLocalHome.findByUK(ConstantesREC.OID_TIPO_REVISION_LINEA);
            } else if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_CAMPO)){
                parametrizacionChequeoLocal = parametrizacionChequeoLocalHome.findByUK(ConstantesREC.OID_TIPO_REVISION_CAMPO);
            }           
            
            parametrizacionChequeoLocal.setIndConsReincidentes(dtoe.getIndConsReincidentes());
            parametrizacionChequeoLocal.setCantidadMinima(dtoe.getCantidadMinima());
            parametrizacionChequeoLocal.setCantidadPeriHaciaAtras(dtoe.getCantidadPeriHaciaAtras());
            parametrizacionChequeoLocal.setIndConsNuevas(dtoe.getIndConsNuevas());
            
            parametrizacionChequeoLocalHome.merge(parametrizacionChequeoLocal);
        
        } catch(NoResultException e) {
            try {
                parametrizacionChequeoLocal = parametrizacionChequeoLocalHome.create();
                
                parametrizacionChequeoLocal.setIndConsReincidentes(dtoe.getIndConsReincidentes());
                parametrizacionChequeoLocal.setCantidadMinima(dtoe.getCantidadMinima());
                parametrizacionChequeoLocal.setCantidadPeriHaciaAtras(dtoe.getCantidadPeriHaciaAtras());
                parametrizacionChequeoLocal.setIndConsNuevas(dtoe.getIndConsNuevas());
                
                if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_LINEA)){
                     parametrizacionChequeoLocal.setOidTipoChequeo(ConstantesREC.OID_TIPO_REVISION_LINEA);
                } else if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_CAMPO)){
                    parametrizacionChequeoLocal.setOidTipoChequeo(ConstantesREC.OID_TIPO_REVISION_CAMPO);
                }
                
                parametrizacionChequeoLocalHome.merge(parametrizacionChequeoLocal);
                
            } catch(PersistenceException ex) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONMantenimientoOrdenChequeo.grabarChequeoLineaCampo: CreateException", ex);
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }   
            
        } catch(PersistenceException e) {
           ctx.setRollbackOnly();
           String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }  

        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoLineaCampo(DTOChequeo dtoe):Salida");
    }

    
    public void grabarChequeoEnCampo(DTOChequeoEnCampo  dto) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoEnCampo(DTOChequeoEnCampo):Entrada");
        //Graba un chequeo en campo 

        // Comprueba si el chequeo se encuentra en BD 
        ConfClientesChequeoEnCampoLocal configuracionClientes = null;
        ConfClientesChequeoEnCampoLocalHome configuracionClientesHome = new ConfClientesChequeoEnCampoLocalHome();
      
        try {
            configuracionClientes = configuracionClientesHome.findByPrimaryKey(dto.getOid());
        } catch(NoResultException e) {
            UtilidadesLog.error("MONMantenimientoOrdenChequeo.grabarChequeoEnCampo: FinderException", e);
        } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        if (configuracionClientes == null) {
            //create: String cantidadTotalConsultoras, String periodoReclamo, Boolean indChequearNuevas, Boolean indGenerado, Long periodo, Long periodoInicial, Long periodofinal
            try {
                configuracionClientes = configuracionClientesHome.create(dto.getCantidadTotalChequear(), dto.getOidPeriodoReclamo().toString(), dto.getConsultoraNueva(), Boolean.FALSE, dto.getOidPeriodo(), dto.getOidPeriodoInicial(), dto.getOidPeriodoFinal());
            } catch(PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONMantenimientoOrdenChequeo.grabarChequeoEnCampo: CreateException", e);
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            // Guarda las zonas de chequeo 
            this.grabarZonasChequeo(dto.getListaZonas(), configuracionClientes.getOid());
        } else {
            this.modificarChequeoEnCampo(dto);
        }

        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoEnCampo(DTOChequeoEnCampo):Salida");
    }

    public void modificarChequeoEnCampo(DTOChequeoEnCampo  dto) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.modificarChequeoEnCampo(DTOChequeoEnCampo):Entrada");
        //Modifica un chequeo en campo 

        ConfClientesChequeoEnCampoLocal configuracionClientes = null;
        ConfClientesChequeoEnCampoLocalHome configuracionClientesHome = new ConfClientesChequeoEnCampoLocalHome();
      
        try {
            configuracionClientes = configuracionClientesHome.findByPrimaryKey(dto.getOid());
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONMantenimientoOrdenChequeo.modificarChequeoEnCampo: FinderException en configuracion", e);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        configuracionClientes.setCantidadTotalConsultoras(dto.getCantidadTotalChequear()); 
        configuracionClientes.setPeriodoInicial(dto.getOidPeriodoInicial()); 
        configuracionClientes.setPeriodoFinal(dto.getOidPeriodoFinal()); 
        configuracionClientes.setPeriodoReclamo( dto.getOidPeriodoReclamo().toString()); 
        configuracionClientes.setIndChequearNuevas(dto.getConsultoraNueva()); 
        configuracionClientes.setIndGenerado(Boolean.FALSE); 
        configuracionClientesHome.merge(configuracionClientes);
        // Elimina las zonas de chequeo y las vuelve a insertar 
        Collection zonas = null;
        ZonasChequeoEnCampoLocalHome zonasEnCampoLH = null;
        try {
            zonasEnCampoLH = new ZonasChequeoEnCampoLocalHome();
            zonas = zonasEnCampoLH.findByConfiguracionClientes(dto.getOid());
        } catch(NoResultException e) {
            UtilidadesLog.error("MONMantenimientoOrdenChequeo.modificarChequeoEnCampo: FinderException en zonas", e);
        } catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        
        if (zonas != null) {
            Object [] arrayZonas = zonas.toArray();
            for (int i = 0; i < arrayZonas.length; i++) {
                try {
                    zonasEnCampoLH.remove(((ZonasChequeoEnCampoLocal)arrayZonas[i]));
                } catch(PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("MONMantenimientoOrdenChequeo.modificarChequeoEnCampo: RemoveException en zonas", e);
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                } 
            }
        }

        // Guarda las zonas de chequeo 
        this.grabarZonasChequeo(dto.getListaZonas(), configuracionClientes.getOid());

        UtilidadesLog.info("MONMantenimientoOrdenChequeo.modificarChequeoEnCampo(DTOChequeoEnCampo):Salida");
    } 
    
    public void grabarZonasChequeo(java.util.ArrayList zonas, Long oidConfiguracionClientes) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarZonasChequeo(ArrayList , Long):Entrada");
        //Guarda las zonas de chequeo 
        if (zonas != null) {
            for ( int i = 0; i < zonas.size(); i++) {
                DTOChequeoZona chequeoZona = (DTOChequeoZona)zonas.get(i);
                //create: Long codigoZonasChequeo, Long confCliCheqCampo, Long region, Long seccion, Long subgerenciaVentas, Long zona
                // codigoZonasChequeo: Posicion en la lista (Comenzando en 1)
                try {
                    new ZonasChequeoEnCampoLocalHome().create(new Long (i + 1), oidConfiguracionClientes, chequeoZona.getOidRegion(), chequeoZona.getOidSeccion(), chequeoZona.getOidSubgerenciaVentas(), chequeoZona.getOidZona());
                } catch(PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("MONMantenimientoOrdenChequeo.grabarZonasChequeo: CreateException", e);
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        }

        UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarZonasChequeo(ArrayList , Long):Salida");
    }

   // incidencia BELC300016030 resuelta
   // BELC300016066 resuelta

    public void grabarChequeoEnLinea(DTOChequeoEnLinea dtoE) throws MareException {
      // Graba un chequeo en linea
		
		UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoEnLinea(DTOChequeoEnLinea):Entrada");

		// Crea una entrada en la entidad ConfiguracionClientesChequeoEnLinea con:
      // - periodo = DTOE.oidPeriodo
      // - subgerenciaVentas = DTOE.oidSubgerenciaVentas
      // - region = DTOE.oidRegion
      // - zona = DTOE.oidZona
      // - seccion = DTOE.oidSeccion
      // - periodoInicial = DTOE.oidPeriodoInicial
      // - periodoFinal = DTOE.oidPeriodoFinal
      // - cantidadMinimaReclamos = DTOE.cantidadMinima
      // - indChequearNuevas = DTOE.consultoraNueva
      // - indGenerado = False
	
	   try {

		   new ConfClientesChequeoEnLineaLocalHome().create(dtoE.getCantidadMinima(),
                                                               dtoE.getConsultoraNueva(),
                                                               Boolean.FALSE,
                                                               dtoE.getOidPeriodo(),
                                                               dtoE.getOidPeriodoFinal(),
                                                               dtoE.getOidZona(),
                                                               dtoE.getOidRegion(),
                                                               dtoE.getOidSubgerenciaVentas(),
                                                               dtoE.getOidSeccion(),
                                                               dtoE.getOidPeriodoInicial());
	   } catch(PersistenceException e) {
			ctx.setRollbackOnly();
			UtilidadesLog.error("*** MONMantenimientoOrdenChequeo.grabarChequeoEnLinea: CreateException", e);
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
   	}

		UtilidadesLog.info("MONMantenimientoOrdenChequeo.grabarChequeoEnLinea(DTOChequeoEnLinea):Salida");
   }

    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOSalida obtenerChequeoManual(DTOChequeoManual dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerChequeoManual(DTOChequeoManual dtoe): Entrada");
        DTOSalida dtoSalida = new DAORec().obtenerChequeoManual(dtoe);
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerChequeoManual(DTOChequeoManual dtoe): Salida");
        return dtoSalida;
    }

    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOChequeoManual verificarChequeoDefinidos(DTOChequeoManual dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.verificarChequeoDefinidos(DTOChequeoManual dtoe): Entrada");
        DTOChequeoManual dtoChequeoManual = new DAORec().verificarChequeoDefinidos(dtoe);
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.verificarChequeoDefinidos(DTOChequeoManual dtoe): Salida");
        return dtoChequeoManual;
    }

    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOSalida obtenerChequeoLineaCampo(DTOChequeoZona dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerChequeoLineaCampo(DTOChequeoZona dtoe): Entrada");
        DTOSalida dtoSalida = new DAORec().obtenerChequeoLineaCampo(dtoe);
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.obtenerChequeoLineaCampo(DTOChequeoZona dtoe): Salida");
        return dtoSalida;
    }

    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOChequeoZona verificarChequeoDefinidosLineaCampo(DTOChequeoZona dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.verificarChequeoDefinidosLineaCampo(DTOChequeoZona dtoe): Entrada");
        DTOChequeoZona dtoChequeoZona = new DAORec().verificarChequeoDefinidosLineaCampo(dtoe);
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.verificarChequeoDefinidosLineaCampo(DTOChequeoZona dtoe): Salida");
        return dtoChequeoZona;
    }

    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOBoolean validarFaltantes(DTOBuscarEnvia dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.validarFaltantes(DTOBuscarEnvia dtoe): Entrada");
        DTOBoolean dtoBoolean = new DAORec().validarFaltantes(dtoe);
        UtilidadesLog.info("MONMantenimientoOrdenChequeo.validarFaltantes(DTOBuscarEnvia dtoe): Salida");
        return dtoBoolean;
    }
}
