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
package es.indra.sicc.logicanegocio.intsys;


import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.intsys.DTOINTCargosAbonos;
import es.indra.sicc.dtos.intsys.DTOINTDocumentoContable;
import es.indra.sicc.dtos.intsys.DTOINTDocumentosContables;
import es.indra.sicc.dtos.intsys.DTOINTEnviarApuntesContables;
import es.indra.sicc.dtos.intsys.DTOINTParametrosContablesCCC;
import es.indra.sicc.dtos.intsys.DTOINTParametrosContablesFAC;
import es.indra.sicc.dtos.intsys.DTOINT;

import es.indra.sicc.dtos.intsys.DTOParametrosContablesFAC;
import es.indra.sicc.entidades.ccc.CuentasContablesLocal;
import es.indra.sicc.entidades.ccc.CuentasContablesLocalHome;
import es.indra.sicc.entidades.ccc.CuentasCorrientesLocal;
import es.indra.sicc.entidades.ccc.CuentasCorrientesLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocalHome;

import es.indra.sicc.entidades.fac.CabeceraDocumentoContableLocal;
import es.indra.sicc.entidades.fac.CabeceraDocumentoContableLocalHome;
import es.indra.sicc.entidades.intsys.DatosSAPFILocal;
import es.indra.sicc.entidades.intsys.DatosSAPFILocalHome;

//import es.indra.sicc.entidades.intsys.ImportesContabilizacionLocal;
import es.indra.sicc.entidades.intsys.ParametrosContablesLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.seg.MonedaLocalHome;

import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;

import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;


import es.indra.sicc.logicanegocio.ccc.ExcelIncorrectoException;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.ClassCastException;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.Date;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.intsys.ParametrosContablesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.intsys.ImpuestoProductoNacionalLocalHome;
import es.indra.sicc.entidades.intsys.ImpuestoProductoNacionalLocal;

import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.mae.NegocioLocal;
import es.indra.sicc.entidades.mae.NegocioLocalHome;
import es.indra.sicc.entidades.seg.IdiomaLocal;
import es.indra.sicc.entidades.seg.IdiomaLocalHome;
import es.indra.sicc.logicanegocio.intsys.PaqueteDeAyudaIdioma.GestorIdiomasINT;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
//import es.indra.sicc.entidades.intsys.ImportesContabilizacionLocalHome;



public class MONINTSAPFIBean implements SessionBean  {

   private String numeroLote;
   private Long moneda;
   private Long pais;
   private ArrayList listaError = new ArrayList();
   
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
    *
    */
   public DTOSalidaBatch generarApuntesContablesCC(DTOBatch dtoe) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.generarApuntesContablesCC(DTOBatch dtoe): Entrada");
      DTOINTEnviarApuntesContables dto;
      DAOINT dao = new DAOINT();

      dto = (DTOINTEnviarApuntesContables)dtoe.getDTOOnline();

      /**
       * COMPROBAR IMPORTES Y ALMACENAR REGISTROS EN LA ENTIDAD INT_DATOS_SAP_FI 
       */
      MONGestorInterfaces gi = this.getMONGestorInterfaces();
      InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAF1C, dto.getNumeroLote(), dto.getOidPais());
      UtilidadesLog.debug("DTOENTRADA - CC: " + dto);
      UtilidadesLog.debug("INTERFAZ ApuntesContablesCC: " + info); 
      try {
         info = gi.crearInterfaz(info);
         info.setDescripcionLote(dto.getDescripcion());
         info.setObservaciones(dto.getObservaciones());
      } catch (InterfacesException ie) {
         UtilidadesLog.error("Excepcion de la Interfaz: " + ie.getMotivo() ,ie); 
      } catch(RemoteException ne){
         UtilidadesLog.debug("error RemoteException");
         throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }      
      // BELC300015019 
      ArrayList listaProcesos = dao.obtenerProcesosCCC();
      UtilidadesLog.warn("-->listaProcesos " + listaProcesos.size());
      
      if (listaProcesos.isEmpty()) {
          // se registra con MareLogging el mensaje INT-0059
          UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: No hay procesos de Cuentas Corrientes");
          try{
            gi.enviarInterfaz(info);
          } catch (InterfacesException ie) {
             UtilidadesLog.error("Excepcion de la Interfaz: " + ie.getMotivo() ,ie);
          } catch(RemoteException ne){
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(ne,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }  
          return new DTOSalidaBatch(0, "generarApuntesContablesCC sin procesos");
      }
      
      // BELC300013442 y BELC300015019 
      //modificado por incidencia SiCC-20070233 (Sapaza)
      ArrayList listaCargosAbonos = dao.obtenerCargosAbonos(dto.getOidPais(), dto.getFechaHasta());
      UtilidadesLog.warn("Cantidad de Cargos abonos a procesar " + listaCargosAbonos.size());
      if (listaCargosAbonos.isEmpty()) {
          // se registra con MareLogging el mensaje INT-0058
          UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: No hay Cargos/Abonos para procesar");
          try{
              gi.enviarInterfaz(info);
          } catch (InterfacesException ie) {
              UtilidadesLog.error("Excepcion de la Interfaz: " + ie.getMotivo() ,ie);
          } catch(RemoteException ne){
              UtilidadesLog.debug("error RemoteException");
              throw new MareException(ne,
              UtilidadesError.armarCodigoError(
              CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
          return new DTOSalidaBatch(0, "generarApuntesContablesCC sin abonos/cargos");
      }
      
      /*
       * COMPLETAR CUENTA CONTABLE RESULTANTE, BANCO Y FECHA PAGO BANCOS 
       */
      DTOINTCargosAbonos dtoCA;
      DTOINTCargosAbonos dtoCATemp = null;
      ArrayList listaDTOs = new ArrayList();
      DTOINTParametrosContablesCCC dtoPC1;
      DTOINTParametrosContablesCCC dtoPC2;
      DTOINTParametrosContablesCCC dtoIPC;
      
      ArrayList temp = new ArrayList(); // contendra los DTOs que queremos eliminar de listaCargosAbonos
      ArrayList proceDH = new ArrayList();

      Iterator it = listaCargosAbonos.iterator();
      while (it.hasNext()) {
         dtoCA = (DTOINTCargosAbonos)it.next();
         /*
          * Se busca en 'listaProcesos' los objetos DTOINTParametrosContablesCCC cuyos 
          * atributos 'proceso' y 'subproceso' sean iguales a los del objeto dtoCA; 
          * la búsqueda puede retornar uno o dos objetos, correspondientes a la UK 'debe' y 'haber': 
          * listaDTOS = listaProcesos( proceso = dtoCA.proceso, subproceso = dtoCA.subproceso ) 
          */
         for (int i=0; i < listaProcesos.size(); i++) {
            dtoIPC = (DTOINTParametrosContablesCCC)listaProcesos.get(i);
            if ((dtoIPC.getProceso().compareTo(dtoCA.getProceso()) == 0) && 
                  dtoIPC.getSubproceso().compareTo(dtoCA.getSubproceso()) == 0) 
            {
               listaDTOs.add(dtoIPC);
            }
         }

         // - Si se ha obtenido un solo objeto, se asigna su atributo 'indicativoDebeHaber' a dtoCA.indicadorDebeHaber: 
         if (listaDTOs.size() == 1) {
            dtoPC1 = (DTOINTParametrosContablesCCC)listaDTOs.get(0);
            dtoCA.setIndicadorDebeHaber(dtoPC1.getIndicativoDebeHaber());
            // - se asigna valor al atributo 'cuentaContable'
            this.asignarCuentaContable(dtoCA, dtoPC1, info);
            // - se comprueba el valor del atributo 'banco': 
            this.comprobarProcesosTesoreria(dtoCA);

         } else if (listaDTOs.size() == 2){ 
            /*
             * - Si se han obtenido dos objetos: 
             * - se debe comprobar que uno tiene el atributo 'indicativoDebeHaber' 
             * igual a CCCConstantes.COD_DEBE y el otro igual a CCCConstantes.COD_HABER; 
             */
            // se obtienen los indicadores del primer y segundo elementos
            String indAux0 = ((DTOINTParametrosContablesCCC)listaDTOs.get(0)).getIndicativoDebeHaber().toUpperCase();
            String indAux1 = ((DTOINTParametrosContablesCCC)listaDTOs.get(1)).getIndicativoDebeHaber().toUpperCase();
            
            if (indAux0.equals(CCCConstantes.COD_DEBE) && indAux1.equals(CCCConstantes.COD_HABER)) {
               dtoPC1 = (DTOINTParametrosContablesCCC)listaDTOs.get(0);
               dtoPC2 = (DTOINTParametrosContablesCCC)listaDTOs.get(1);
            } else if (indAux0.equals(CCCConstantes.COD_HABER) && indAux1.equals(CCCConstantes.COD_DEBE)) {
               dtoPC1 = (DTOINTParametrosContablesCCC)listaDTOs.get(1);
               dtoPC2 = (DTOINTParametrosContablesCCC)listaDTOs.get(0);
            } else {
               String codigoError = ErroresDeNegocio.INT_0034 + "Debe: " + CCCConstantes.COD_DEBE + " - Haber: " + CCCConstantes.COD_HABER;               
               UtilidadesLog.error("MONINTSAFI.asignarCuentaContable: " + codigoError);
               listaDTOs.clear();
               continue;
            }
            
            // - asigna el indicador debe: dtoCA.indicadorDebeHaber = ConstantesINT.COD_DEBE 
            dtoCA.setIndicadorDebeHaber(CCCConstantes.COD_DEBE);
            // - asigna la cuenta contable resultante
            this.asignarCuentaContable(dtoCA, dtoPC1, info);
            // - se comprueba el valor del proceso: comprobarProcesosTesoreria( dtoCA ) 
            this.comprobarProcesosTesoreria(dtoCA);
            // - se duplica la entrada actual: dtoCATemp = dtoCA.clone() 
            try {
               dtoCATemp = (DTOINTCargosAbonos)dtoCA.clone();
            } catch (CloneNotSupportedException cnse) {               
               UtilidadesLog.error(cnse);
            }

            // incidencia BELC300013494
            dtoCATemp.setIndicadorDebeHaber(CCCConstantes.COD_HABER);
            // se asigna la cuenta contable
            this.asignarCuentaContable(dtoCATemp,dtoPC2, info);
            // Se comprueba el valor del proceso: comprobarProcesosTesoreria( dtoCATemp ) 
            this.comprobarProcesosTesoreria(dtoCATemp);
            // agrego la entrada duplicada a la lista de cargos y abonos.
            UtilidadesLog.debug("dtoCETemp "+dtoCATemp);   
            proceDH.add(dtoCATemp);
         } else { 
             /* incidencia BELC300016408
              * Si no se encuentra ningún objeto, se elimina el objeto dtoCA de la lista 
              * y se toma el siguiente del bucle se añaden a un ArrayList 
              * y se eliminan cuando se acabe el bucle
              */
             temp.add(dtoCA);
         }
         listaDTOs.clear();
      }

      // incidencia BELC300016408
      /*
       * se eliminan de listaCargosAbonos los DTOINTCargosAbonos cuyos valores de 
       * 'proceso' y 'subproceso' no coincidan con los valores de 'proceso' y 'subproceso' 
       * de ninguno de los DTOINTParametrosContablesCCC contenidos en listaProcesos
       */
      listaCargosAbonos.removeAll(temp);
      UtilidadesLog.warn("listaCargosAbonos sin coincidentes " + listaCargosAbonos.size());
      listaCargosAbonos.addAll(proceDH);
      UtilidadesLog.warn("listaCargosAbonos con proceDH " + listaCargosAbonos.size());

      // después de procesar listaCargosAbonos en el bucle, se debe comprobar que no ha quedado vacía
      if (listaCargosAbonos.isEmpty()) {
         UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC. No existe ningun cargo/abono cuyos valores de 'proceso' y 'subproceso' coincidan con los valores de 'proceso' y 'subproceso' de alguno de los DTOINTParametrosContablesCCC contenidos en listaProcesos");
         // se registra con MareLogging el mensaje INT-0058
         UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: No hay Cargos/Abonos para procesar");
        try{
              gi.enviarInterfaz(info);
              } catch (InterfacesException ie) {
                 UtilidadesLog.error("Excepcion de la Interfaz: " + ie.getMotivo() ,ie);
              } catch(RemoteException ne){
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }  
         return new DTOSalidaBatch(0, "generarApuntesContablesCC sin abonos/cargos");                  
      }

      /*
       * SE SELECCIONAN LOS REGISTROS CUYO PROCESO NO SEA CCC004: 
       * los que tengan CCC004 se añaden a listaFinal y se eliminan de listaCargosAbonos.
       */
      ArrayList listaFinal = new ArrayList(); 
      temp = new ArrayList(); // contendra los DTOs que queremos eliminar de listaCargosAbonos
      
      it = listaCargosAbonos.iterator();
      while (it.hasNext()) {
         dtoCA = (DTOINTCargosAbonos)it.next();
         if (dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.PROCESO_GESTION_CHEQUES)) {
            listaFinal.add(dtoCA);
            temp.add(dtoCA);
         }
      }
      UtilidadesLog.warn(" Se remueven de lista cargos abonos " + temp.size());
      listaCargosAbonos.removeAll(temp);

      /*
       * SE AGRUPAN LOS REGISTROS DE listaCargosAbonos según los siguientes criterios: 
       * pais 
       * fechaDocumento 
       * fechaValor 
       * empresa 
       * canal 
       * acceso 
       * subacceso 
       * proceso 
       * subproceso 
       * cuentaContable 
       * banco 
       * fechaPagoBancos 
       *
       * - Agrupar estos objetos significa refundir todos aquellos que tengan los atributos 
       * anteriores iguales en un solo objeto, y haciendo el sumatorio del atributo 'importe'.
       * Se crea una nueva lista, 'listaAgrupados', que contendrá estos objetos. 
       */
      if(listaCargosAbonos.size()!=0) {
          UtilidadesLog.warn(" listaCargosAbonos ANTES de agrupar: " + listaCargosAbonos.size());
          ArrayList listaAgrupados = this.agruparDTOINTCargosAbonos(listaCargosAbonos);
          UtilidadesLog.warn(" listaAgrupados DESPUES de agrupar: " + listaAgrupados.size());
          /* - Una vez realizada la agrupación, hay que unir los objetos de agrupación 
           * y los que se guardaron en 'listaFinal': listaFinal = listaFinal + listaAgrupados,
           * con lo que ahora, en 'listaFinal', tendremos los objetos agrupados 
           * más los objetos correspondientes al proceso CCC004, que no había que agrupar. 
           */
           listaFinal.addAll(listaAgrupados);      
           UtilidadesLog.warn("lista final + agrupados " + listaFinal.size());  
      }
      
      UtilidadesLog.warn(" en listaFinal ANTES de ordenar: " + listaFinal.size());
      
      /*
       * - Se ordenan los objetos contenidos en 'listaFinal', de mayor a menor, por los siguientes criterios: 
       * codigoPais 
       * fechaDocumento
       * codigoEmpresa 
       * codigoCanal 
       * codigoAcceso 
       * codigoSubacceso 
       * codigoCuentaContable 
       * indicadorDebeHaber( primero Debe ) 
       * codigoBanco
       * fechaPagoBancos 
       */
      listaFinal = this.ordenar7(listaFinal);
      UtilidadesLog.warn("lista final ordenada siete " + listaFinal.size());  
      
      UtilidadesLog.debug("Despues de crear Interfaz: "+info);
      RegistroSicc registro = new RegistroSicc();
      
      UtilidadesLog.warn(" listaFinal ANTES del bucle de generacion interfaz: " + listaFinal.size());
      it = listaFinal.iterator();
      while (it.hasNext()) {
         dtoCA = (DTOINTCargosAbonos)it.next();
         // Almacenamos el objeto en la entidad INT_DATOS_SAP_FI 
         String descripcionApunte = "";
         String codigoDeBanco = "";
         if (dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.PROCESO_MOVIMIENTO_AUTOMATICO) 
              || dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.PROCESO_MOVIMIENTO_MANUAL) 
              || dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.TESP01_PERCEP_RECAUDOS_BANCARIOS)
              || dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.CCCEN1_PAGOS_EN_EXCESO_NEGATIVO)
              || dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.CCCP07_PERCEP_DECUENTOS_A_PERSONAL)
              || dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.CCCP11_PERCEP_ABONOS_CANAL_INTERNET)) {
            descripcionApunte = "Cobranza " + dtoCA.getDescripcionCuentaCorriente(); 
            codigoDeBanco =dtoCA.getCodigoBanco();
         } else {
            descripcionApunte = ConstantesINT.GLOSA_NO_TESORERIA; // BELC300013581
            codigoDeBanco = "";
         }
         // incidencia BELC300016071 
         if (descripcionApunte.length() > ConstantesINT.ANCHURA_GLOSA_SAPFI.intValue()) {
            descripcionApunte = descripcionApunte.substring(0, ConstantesINT.ANCHURA_GLOSA_SAPFI.intValue());
         }

         String anyo = "";
         String mes = "";
         try {
            anyo = UtilidadesFecha.convertirAString(dtoCA.getFechaDocumento(), "yyyy");		
            mes = UtilidadesFecha.convertirAString(dtoCA.getFechaDocumento(), "MM");
         } catch (ParseException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
         }
         
          // BELC300013578, BELC300013581, BELC300013495
          DatosSAPFILocalHome datosSAPFILocalHome = this.getDatosSAPFILocalHome();
          DatosSAPFILocal datosSAPFI;
        
         if(dtoCA.getCuentaContable()!=null && !dtoCA.getCuentaContable().equals(new Long(0))){
             try {
                   datosSAPFI = datosSAPFILocalHome.create(
                                   ConstantesINT.INDICADOR_CUENTA_CORRIENTE,
                                   dto.getNumeroLote(),
                                   dtoCA.getFechaDocumento(),
                                   ConstantesINT.TIPO_ASIENTO_CUENTA_CORRIENTE,
                                   dtoCA.getCuentaContable(), // incidencia 18477
                                   descripcionApunte,
                                   dtoCA.getIndicadorDebeHaber(),
                                   dtoCA.getImporte(),
                                   mes,
                                   new Short(anyo),
                                   dtoCA.getSubacceso(),
                                   dtoCA.getMoneda(),
                                   dtoCA.getEmpresa());
             } catch (PersistenceException ce) {
                ctx.setRollbackOnly(); 
                ce.printStackTrace();
                UtilidadesLog.error(ce);            
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
             if(dtoCA.getCodigoProceso()!=null && 
               dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.PROCESO_GESTION_CHEQUES)){
               
               datosSAPFI.setFechaDocumento(dtoCA.getFechaValor());  
             }else{
                datosSAPFI.setFechaDocumento(null);  
             }
             datosSAPFI.setFechaValorBanco(dtoCA.getFechaValor());                    
             datosSAPFI.setFechaPagoBanco(dtoCA.getFechaPagoBancos());      
             datosSAPFI.setCodigoBancoSICC(dtoCA.getBanco());      
             datosSAPFI.setNegocio(null);                                        
             datosSAPFILocalHome.merge(datosSAPFI);

             // Se graba el registro en el fichero de interfaz 
             try {
                registro.anyadirCampo(IRegistroSicc.SAPFI_NUMERO_LOTE_TRANSACCION, dto.getNumeroLote()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_PAIS, dtoCA.getCodigoPais()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_FECHA_CONTABLE, dtoCA.getFechaDocumento()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_SOCIEDAD, dtoCA.getCodigoEmpresa()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_CANAL, dtoCA.getCodigoCanal().equals("-")?null:dtoCA.getCodigoCanal());
                registro.anyadirCampo(IRegistroSicc.SAPFI_ACCESO, dtoCA.getCodigoAcceso().equals("-")?null:dtoCA.getCodigoAcceso());
                registro.anyadirCampo(IRegistroSicc.SAPFI_SUBACCESO, dtoCA.getCodigoSubacceso().equals("-")?null:dtoCA.getCodigoSubacceso());
                registro.anyadirCampo(IRegistroSicc.SAPFI_TIPO_PERIODO_COMERCIAL, new String());
                registro.anyadirCampo(IRegistroSicc.SAPFI_PERIODO_COMERCIAL, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_EJERCICIO_COMERCIAL, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_TIPOS_ASIENTO, ConstantesINT.TIPO_ASIENTO_CUENTA_CORRIENTE); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_TIPO_MOVIMIENTO_SAPFI, dtoCA.getCodigoCuentaContable());
                registro.anyadirCampo(IRegistroSicc.SAPFI_DOCUMENTO_IDENTIDAD_RUC_TRANSPORTISTA, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_DESCRIPCION_APUNTE, descripcionApunte);
                registro.anyadirCampo(IRegistroSicc.SAPFI_DEBE_HABER, dtoCA.getIndicadorDebeHaber()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_MARCA_PRODUCTO, new String());
                registro.anyadirCampo(IRegistroSicc.SAPFI_GRUPO_ARTICULOS, new String());
                registro.anyadirCampo(IRegistroSicc.SAPFI_NEGOCIO_PRODUCTO, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_TIPO_OFERTA, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_CICLO_VIDA, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_IMPORTE, dtoCA.getImporte().setScale(2).abs());                      
                registro.anyadirCampo(IRegistroSicc.SAPFI_MONEDA, dtoCA.getCodigoMoneda());
                registro.anyadirCampo(IRegistroSicc.SAPFI_PERIODO_CONTABLE, mes); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_EJERCICIO_CONTABLE, anyo); 
                if(dtoCA.getCodigoProceso()!=null && dtoCA.getCodigoProceso().toUpperCase().equals(CCCConstantes.PROCESO_GESTION_CHEQUES)){
                    registro.anyadirCampo(IRegistroSicc.SAPFI_FECHA, dtoCA.getFechaValor());
                }else{
                    registro.anyadirCampo(IRegistroSicc.SAPFI_FECHA, null);
                }
                registro.anyadirCampo(IRegistroSicc.SAPFI_CODIGO_BANCO_SICC, codigoDeBanco.equals("-")?null:codigoDeBanco);
                registro.anyadirCampo(IRegistroSicc.SAPFI_FECHA_PAGO_BANCOS, dtoCA.getFechaPagoBancos()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_FECHA_VALOR, dtoCA.getFechaValor()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_NUMERO_COMPROBANTE, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_RECAUDADORA_SUCURSAL, new String()); 
                registro.anyadirCampo(IRegistroSicc.SAPFI_ZONA, new String()); 
             } catch (InterfacesException ie) {
                ctx.setRollbackOnly();
                ie.printStackTrace();
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: error InterfacesException");
                throw new MareException(ie,UtilidadesError.armarCodigoError(ie.getMotivo()));            
             }
             
             // Se añade el registro al fichero de interfaz 
             try { 
                gi.anyadirRegistro(info, registro); 
             } catch (InterfacesException iex) {
                ctx.setRollbackOnly();
                // - se hace log de la excepción mediante el servicio MareLogging 
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: error InterfacesException "+iex);
                throw new MareException(iex, UtilidadesError.armarCodigoError(iex.getMotivo()));            
             } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: error RemoteException "+ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ));
             }
    
             registro.vaciar();

         } //if cuenta contable
         
      } // Fin tratamiento Cargos/Abonos 

      try { 
         
         gi.enviarInterfaz(info);
      
      } catch(InterfacesException iex) {
      
         DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0009 + info.getCodigoInterfaz() + "Lote: " + info.getNumeroLote()); 
         try {
            gi.registrarError(dtoError); 
         } catch(InterfacesException iex2) {   
            ctx.setRollbackOnly();
            UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: error InterfacesException");
            throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
         } catch (RemoteException ne) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: error RemoteException");
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
         }
      } catch (RemoteException ne) {
         ctx.setRollbackOnly();
         UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesCC: error RemoteException");
         throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ));
      }

      /*
       * Actualiza lote y fecha de contabilizacion en  cabecera de cargos y abonos directos, 
       * Movimientos Bancarios y en Movimientos en Cuenta Corriente.
       */
      dao.actualizarRegistros(dto.getNumeroLote(), dto.getFecha(), dto.getOidPais(), dto.getFechaHasta());
      
      UtilidadesLog.info("MONINTSAPFIBean.generarApuntesContablesCC(DTOBatch dtoe): Salida");
      return new DTOSalidaBatch(0, "generarApuntesContablesCC finalizado");
   }


   public Long getMoneda() {
      return moneda;
   }

   public void setMoneda(Long moneda) {
      this.moneda = moneda;
   }

   public String getNumeroLote() {
      return numeroLote;
   }

   public void setNumeroLote(String numeroLote) {
      this.numeroLote = numeroLote;
   }

   public Long getPais() {
      return pais;
   }

   public void setPais(Long pais) {
      this.pais = pais;
   }


    /**
    * Genera apuntes contables FAC para Ventas, Abonos y Transportistas.
    * @cambio se procesa por cada zona por necesidad de performance de obtener menos registros a procesar.
    */
    public DTOSalidaBatch generarApuntesContablesFAC(DTOBatch dtoE) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.generarApuntesContablesFAC(DTOBatch dtoE): Entrada");
        DTOINTEnviarApuntesContables dtoEnviarApuntesContables;
        DAOINT daoInt = new DAOINT();
        RecordSet rsZonas;
        Long oidZona;

        //Actualización previa del campo Importe Redondeo.
        this.actualizarImporteRedondeo();

        dtoEnviarApuntesContables = (DTOINTEnviarApuntesContables)dtoE.getDTOOnline();

        //Creamos la intefaz sap-fi de fac
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        InterfazInfo intefazInfo = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAF1F, dtoEnviarApuntesContables.getNumeroLote(), dtoEnviarApuntesContables.getOidPais());
        UtilidadesLog.debug("Interfaz ApuntesContables: " + intefazInfo);

        try {
            intefazInfo = gi.crearInterfaz(intefazInfo);
            intefazInfo.setDescripcionLote(dtoEnviarApuntesContables.getDescripcion());
            intefazInfo.setObservaciones(dtoEnviarApuntesContables.getObservaciones());            
        } catch (InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: " + ie.getMotivo() ,ie); 
            ctx.setRollbackOnly();
            throw new MareException(ie,UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ));
        } catch(RemoteException ne){            
            UtilidadesLog.debug("error RemoteException");
            ctx.setRollbackOnly();
            throw new MareException(ne,UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }            

        //Obtenemos las distintas zonas para el pais activo y con lote de contabilizacion en nulo.
        rsZonas = daoInt.obtenerZonasSinContabilizar(dtoEnviarApuntesContables.getOidPais());
        UtilidadesLog.debug("zonas a procesar: "+ rsZonas );

        //Generamos apuntes contables por cada zona
        for(int i=0; i<rsZonas.getRowCount(); i++) {
            oidZona = new Long(((BigDecimal)rsZonas.getValueAt(i,"ZONA")).longValue());
            this.generarApuntesContablesFACPorZona(dtoEnviarApuntesContables, oidZona, intefazInfo);
        }        

        // cerramos la inteface sap-fi de fac
        try { 
            gi.enviarInterfaz(intefazInfo);
        } catch(InterfacesException iex) {
            UtilidadesLog.debug("InterfacesException: " + iex.getMotivo());
            DTOINTError dtoError = new DTOINTError(intefazInfo, null, ErroresDeNegocio.INT_0009 + intefazInfo.getCodigoInterfaz() + "Lote: " + intefazInfo.getNumeroLote()); 
            try {
                  gi.registrarError(dtoError); 
             } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();                
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFAC: error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
             } catch (RemoteException ne) {
                ctx.setRollbackOnly();                
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFAC: error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
             }
        } catch (RemoteException ne) {
             ctx.setRollbackOnly();             
             UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFAC: error RemoteException");
             throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ));
        }

        UtilidadesLog.info("MONINTSAPFIBean.generarApuntesContablesFAC(DTOBatch dtoE): Salida");
        return new DTOSalidaBatch( 0, "enviarApuntesContablesFAC finalizado correctamente" );
    }


    /**
    *  Genera apuntes contables FAC para Ventas, Abonos y Transportistas para una zona determinada.
    */
    private DTOSalidaBatch generarApuntesContablesFACPorZona(DTOINTEnviarApuntesContables dto, Long oidZona, InterfazInfo intefazInfo) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.generarApuntesContablesFACPorZona(): Entrada");
        UtilidadesLog.warn("zona: " + oidZona );
        ArrayList listaGrupos = new ArrayList();
        ArrayList listaDocumentos = new ArrayList();
        String anyo;
        String mes;
        DAOINT dao = new DAOINT(); 
        this.setPais(dto.getOidPais());
        this.setNumeroLote(dto.getNumeroLote());

        //Obtenemos la moneda para el pais activo 
        PaisLocalHome paisLocalHome = this.getPaisLocalHome();
        PaisLocal pais;
        try {
          pais = paisLocalHome.findByPrimaryKey( dto.getOidPais());
        }catch(NoResultException fe){
            UtilidadesLog.debug(fe);            
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Long moneda = pais.getMone_oid_mone(); 
        String codigoMoneda;
        this.setMoneda(moneda);
        try {
            codigoMoneda = (this.getMonedaLocalHome().findByPrimaryKey(moneda)).getCodMoneda();
        }catch(NoResultException fe){
            UtilidadesLog.debug(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // obtenemos los documentos contables de la zona indicada
        //modificado por incidencia SiCC-20070233 (Sapaza)
        DTOINTDocumentosContables dtoDCs = dao.obtenerDocumentosContables(dto.getOidPais(), oidZona, dto.getFechaHasta());

        if (dtoDCs.getDocumentosVentasSinTransportista() == null && dtoDCs.getDocumentosAbonosSinTransportista() == null && dtoDCs.getDocumentosTransportistas() == null) {
            String mensaje = "Metodo MONINTSAPFI.generarApuntesContablesFACPorZona: finalizado sin registros procesados para la zona: " + oidZona;
            UtilidadesLog.debug(mensaje);
            return new DTOSalidaBatch(0, mensaje);
        }
        
        if (dtoDCs.getDocumentosVentasSinTransportista() == null){
            listaDocumentos.add(0, new ArrayList());
        }else{      
            listaDocumentos.add(0, dtoDCs.getDocumentosVentasSinTransportista());
        }
        
        if (dtoDCs.getDocumentosAbonosSinTransportista() ==null){
            listaDocumentos.add(1, new ArrayList());
        }else{
            listaDocumentos.add(1, dtoDCs.getDocumentosAbonosSinTransportista());
        }
        
        if (dtoDCs.getDocumentosTransportistas() == null){
            listaDocumentos.add(2, new ArrayList());
        }else{
            listaDocumentos.add(2, dtoDCs.getDocumentosTransportistas());
        }
        
        DTOINTDocumentoContable dtoAUX = new DTOINTDocumentoContable();
        ArrayList listaAux = new ArrayList();
        
        if (dtoDCs.getDocumentosVentasSinTransportista() != null) {
            UtilidadesLog.warn("DocumentosVentasSinTransportista");
            listaGrupos = this.procesarDocumentos( ConstantesINT.TIPO_ASIENTO_VN, dtoDCs.getDocumentosVentasSinTransportista(), oidZona ); 
            for (int i=0;i<listaGrupos.size();i++) {
                dtoAUX = (DTOINTDocumentoContable) listaGrupos.get(i);
                if(dtoAUX.getCuentaContable()!= null && dtoAUX.getCuentaContable().equals(new Long(0))){
                   listaError.add(dtoAUX);
                }
            }
            UtilidadesLog.warn("listaGrupos dvst: " + listaGrupos.size());
        }
        
        if (dtoDCs.getDocumentosAbonosSinTransportista() != null) { 
           UtilidadesLog.warn("DocumentosAbonosSinTransportista");
           listaAux = this.procesarDocumentos( ConstantesINT.TIPO_ASIENTO_AB, dtoDCs.getDocumentosAbonosSinTransportista(), oidZona );
           for (int i=0;i<listaAux.size();i++) {
                listaGrupos.add(listaAux.get(i));  
                dtoAUX = (DTOINTDocumentoContable) listaAux.get(i);
                if(dtoAUX.getCuentaContable()!= null && dtoAUX.getCuentaContable().equals(new Long(0))){
                    listaError.add(dtoAUX);
                }
            }
           UtilidadesLog.warn("listaGrupos dast: " + listaGrupos.size());
        }

        if (dtoDCs.getDocumentosTransportistas() != null) {         
           UtilidadesLog.warn("DocumentosTransportistas");
           listaAux = this.procesarDocumentos( ConstantesINT.TIPO_ASIENTO_TN, dtoDCs.getDocumentosTransportistas(), oidZona );
           for (int i=0;i<listaAux.size();i++) {
              listaGrupos.add(listaAux.get(i));  
              dtoAUX = (DTOINTDocumentoContable) listaAux.get(i);
              if(dtoAUX.getCuentaContable()!= null && dtoAUX.getCuentaContable().equals(new Long(0))){
                  listaError.add(dtoAUX);
              }
           }
           UtilidadesLog.warn("listaGrupos dt: " + listaGrupos.size());
        }
        
        // obetemos el gestor de intefaces       
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        if(intefazInfo.getCodigoInterfaz().equals(IGestorInterfaces.COD_INTERFAZ_SAF1F)){
            for(int w=0; w < listaError.size();w++){
                dtoAUX = (DTOINTDocumentoContable) listaError.get(w);
                UtilidadesLog.debug("Cabecera sin cuenta contable ----> " + dtoAUX.getOidCabecera());      
            }
            listaError.clear();
        }

        // ordenar lista de grupos
        listaGrupos = this.ordenar(listaGrupos);

        RegistroSicc registro = new RegistroSicc();
        DTOINTDocumentoContable dtoDC = new DTOINTDocumentoContable();
        for (int i=0;i<listaGrupos.size();i++ ) {
            dtoDC = (DTOINTDocumentoContable)listaGrupos.get(i);
            try {
                anyo = UtilidadesFecha.convertirAString(dtoDC.getFecha(), "yyyy");		
                mes = UtilidadesFecha.convertirAString(dtoDC.getFecha(), "MM");
            } catch (ParseException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
            }
            try {
                  registro.anyadirCampo( IRegistroSicc.SAPFI_NUMERO_LOTE_TRANSACCION, dto.getNumeroLote() );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_PAIS, pais.getCod_pais() );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_FECHA_CONTABLE, dtoDC.getFecha());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_SOCIEDAD, dtoDC.getCodigoEmpresa());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_CANAL, dtoDC.getCodigoCanal());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_ACCESO, dtoDC.getCodigoAcceso());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_SUBACCESO, dtoDC.getCodigoSubacceso());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_TIPO_PERIODO_COMERCIAL, dtoDC.getCodigoTipoPeriodo());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_PERIODO_COMERCIAL, dtoDC.getCodigoPeriodo().substring(dtoDC.getCodigoPeriodo().length()-2));
                  registro.anyadirCampo( IRegistroSicc.SAPFI_EJERCICIO_COMERCIAL, dtoDC.getEjercicioComercial());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_TIPOS_ASIENTO, dtoDC.getTipoAsiento());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_TIPO_MOVIMIENTO_SAPFI, dtoDC.getTipoMovimientoSAPFI());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_DOCUMENTO_IDENTIDAD_RUC_TRANSPORTISTA, dtoDC.getRUC());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_DESCRIPCION_APUNTE, this.obtenerGlosa(dtoDC));
                  registro.anyadirCampo( IRegistroSicc.SAPFI_DEBE_HABER, dtoDC.getIndicadorDebeHaber());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_MARCA_PRODUCTO, dtoDC.getCodigoMarcaProducto());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_GRUPO_ARTICULOS, dtoDC.getCodigoGrupoProductos());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_NEGOCIO_PRODUCTO, dtoDC.getCodigoNegocio());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_TIPO_OFERTA, dtoDC.getCodigoTipoOferta());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_CICLO_VIDA, dtoDC.getCodigoCicloVida());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_IMPORTE, dtoDC.getImporte().setScale(2).abs());
                  registro.anyadirCampo( IRegistroSicc.SAPFI_MONEDA, codigoMoneda);
                  registro.anyadirCampo( IRegistroSicc.SAPFI_PERIODO_CONTABLE, mes);
                  registro.anyadirCampo( IRegistroSicc.SAPFI_EJERCICIO_CONTABLE,anyo );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_FECHA, dtoDC.getFecha() );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_CODIGO_BANCO_SICC, new String() );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_FECHA_PAGO_BANCOS, null );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_FECHA_VALOR, dtoDC.getFecha() );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_NUMERO_COMPROBANTE, new String() );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_RECAUDADORA_SUCURSAL, new String() );
                  registro.anyadirCampo( IRegistroSicc.SAPFI_ZONA, new String() );
            } catch( InterfacesException iex ){
                    ctx.setRollbackOnly();                    
                    UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFACPorZona: error InterfacesException");
                    throw new MareException(iex,UtilidadesError.armarCodigoError(iex.getMotivo()));            
            } catch( Exception ex ){
                  ctx.setRollbackOnly();                    
                  UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFAC: error Exception");
                  throw new MareException(ex,UtilidadesError.armarCodigoError(ex.getMessage()));    
            }

            // Se añade el registro al fichero de interfaz
            try{
                gi.anyadirRegistro( intefazInfo, registro );
            } catch( InterfacesException iex ){
                ctx.setRollbackOnly();                
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFAC: error InterfacesException");
                throw new MareException(iex,UtilidadesError.armarCodigoError(iex.getMotivo()));            
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();                
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFAC: error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ));
            } catch( Exception ex ){
                ctx.setRollbackOnly();                    
                UtilidadesLog.debug("MONINTSAPFI.generarApuntesContablesFAC: error Exception");
                throw new MareException(ex,UtilidadesError.armarCodigoError(ex.getMessage()));            
            }
            registro.vaciar();
        } //fin for lista grupos

        //Actualizar Cabeceras de Documentos Procesados para la zona tratada
        this.actualizarCabecera(oidZona, dto.getFechaHasta());

        //Limpiamos documento contables de memoria para la proxima ejecucion
        listaDocumentos.clear();

        UtilidadesLog.info("MONINTSAPFIBean.generarApuntesContablesFACPorZona(DTOBatch dtoE): Salida");
        return new DTOSalidaBatch( 0, "enviarApuntesContablesFAC finalizado correctamente" );
    }
    
    
    /*
     * Modificado por incidencia BELC300013542
     */
    private ArrayList agruparCabecera (ArrayList listaDocumentos, Boolean primeraAgrupacion,
                                        String tipoAsientos) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.agruparCabecera(ArrayList listaDocumentos, Boolean primeraAgrupacion, String tipoAsientos): Entrada");
        ArrayList listaAgrupados = new ArrayList();
        ArrayList listaAgrupadosOrdenados = new ArrayList();
        DTOINTDocumentoContable dtoDC = new DTOINTDocumentoContable();
        
        UtilidadesLog.debug("primeraAgrupacion: " + primeraAgrupacion);
        UtilidadesLog.debug("tipoAsientos: " + tipoAsientos);
        UtilidadesLog.warn("agruparCabecera() listaDocumentos: " + listaDocumentos.size());
            
        if(primeraAgrupacion.booleanValue()) { 
            
            listaAgrupados = this.agruparDTOINTDocumentoContable(listaDocumentos,primeraAgrupacion);
            UtilidadesLog.info("listaAgrupados: " + listaAgrupados);
            listaAgrupadosOrdenados = this.ordenar3(listaAgrupados, tipoAsientos);
        }else { 
            
            listaAgrupados = this.agruparDTOINTDocumentoContable(listaDocumentos,primeraAgrupacion);
            UtilidadesLog.info("listaAgrupados: " + listaAgrupados);
            listaAgrupadosOrdenados = this.ordenar4(listaAgrupados, tipoAsientos);
        }

        UtilidadesLog.info("MONINTSAPFIBean.agruparCabecera(ArrayList listaDocumentos, Boolean primeraAgrupacion, String tipoAsientos): Salida");
        return listaAgrupadosOrdenados;
    }

  
  /**
   * 
   */
  private ArrayList agruparDTOINTDocumentoContable (ArrayList listaSinAgrupar, Boolean primeraAgrupacion) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTDocumentoContable(ArrayList listaSinAgrupar, Boolean primeraAgrupacion): Entrada");
      ArrayList listaAgrupada = new ArrayList();
      DTOINTDocumentoContable dtoNoAgrupado = null;
      DTOINTDocumentoContable dtoAgrupado = null;
      
      boolean encontrado;
      // metemos el primer elemento en la lista agrupada
      if(listaSinAgrupar.size()>0) {
          listaAgrupada.add((DTOINTDocumentoContable)listaSinAgrupar.get(0));
      
          for (int i=1; i < listaSinAgrupar.size(); i++) {
         
              dtoNoAgrupado = new DTOINTDocumentoContable();
              dtoNoAgrupado = (DTOINTDocumentoContable)listaSinAgrupar.get(i);
              
              encontrado = false;
              
              for (int j=0; j < listaAgrupada.size(); j++) {
                
                dtoAgrupado = new DTOINTDocumentoContable();
                dtoAgrupado = (DTOINTDocumentoContable)listaAgrupada.get(j);
                if (primeraAgrupacion.booleanValue()){
                    UtilidadesLog.debug("primeraAgrupacion: " + primeraAgrupacion);
                    
                    if (this.comparaDTOINTDocumentoContable(dtoNoAgrupado, dtoAgrupado).booleanValue()) { // se deben agrupar
                       
                       if (dtoAgrupado.getImporte50() != null && dtoNoAgrupado.getImporte50() != null) 
                         dtoAgrupado.setImporte50(dtoAgrupado.getImporte50().add(dtoNoAgrupado.getImporte50()));
                       
                       if (dtoAgrupado.getImporte55() != null && dtoNoAgrupado.getImporte55() != null) 
                         dtoAgrupado.setImporte55(dtoAgrupado.getImporte55().add(dtoNoAgrupado.getImporte55()));
                       
                       if (dtoAgrupado.getImporte60() != null && dtoNoAgrupado.getImporte60() != null) 
                         dtoAgrupado.setImporte60(dtoAgrupado.getImporte60().add(dtoNoAgrupado.getImporte60()));
                       
                       if (dtoAgrupado.getImporte70() != null && dtoNoAgrupado.getImporte70() != null) 
                         dtoAgrupado.setImporte70(dtoAgrupado.getImporte70().add(dtoNoAgrupado.getImporte70()));
                       
                       if (dtoAgrupado.getImporte80() != null && dtoNoAgrupado.getImporte80() != null) 
                         dtoAgrupado.setImporte80(dtoAgrupado.getImporte80().add(dtoNoAgrupado.getImporte80()));
                       
                       if (dtoAgrupado.getImporte84() != null && dtoNoAgrupado.getImporte84() != null) 
                         dtoAgrupado.setImporte84(dtoAgrupado.getImporte84().add(dtoNoAgrupado.getImporte84()));
                       
                       if (dtoAgrupado.getImporte88() != null && dtoNoAgrupado.getImporte88() != null) 
                         dtoAgrupado.setImporte88(dtoAgrupado.getImporte88().add(dtoNoAgrupado.getImporte88()));
                         
                       //cambio SAPFI-001  (SCS-07/05/08)  
                       if (dtoAgrupado.getImporte90() != null && dtoNoAgrupado.getImporte90() != null) 
                         dtoAgrupado.setImporte90(dtoAgrupado.getImporte90().add(dtoNoAgrupado.getImporte90()));
                       
                       //añadimos el dtoAgrupado modificado a la listaAgrupada
                       listaAgrupada.set(j,dtoAgrupado);
                       encontrado = true;
                       break;
                     }
                    
                }
                else //no es primera agrupacion
                {
                    UtilidadesLog.debug("primeraAgrupacion: " + primeraAgrupacion);
                    
                    if (this.comparaDTOINTDocumentoContable2(dtoNoAgrupado, dtoAgrupado).booleanValue()) { // se deben agrupar
                                              
                        if (dtoAgrupado.getImporte50() != null && dtoNoAgrupado.getImporte50() != null) 
                        dtoAgrupado.setImporte50(dtoAgrupado.getImporte50().add(dtoNoAgrupado.getImporte50()));
                        
                        if (dtoAgrupado.getImporte55() != null && dtoNoAgrupado.getImporte55() != null) 
                        dtoAgrupado.setImporte55(dtoAgrupado.getImporte55().add(dtoNoAgrupado.getImporte55()));
                        
                        if (dtoAgrupado.getImporte60() != null && dtoNoAgrupado.getImporte60() != null) 
                        dtoAgrupado.setImporte60(dtoAgrupado.getImporte60().add(dtoNoAgrupado.getImporte60()));
                        
                        if (dtoAgrupado.getImporte70() != null && dtoNoAgrupado.getImporte70() != null) 
                        dtoAgrupado.setImporte70(dtoAgrupado.getImporte70().add(dtoNoAgrupado.getImporte70()));
                        
                        if (dtoAgrupado.getImporte80() != null && dtoNoAgrupado.getImporte80() != null) 
                        dtoAgrupado.setImporte80(dtoAgrupado.getImporte80().add(dtoNoAgrupado.getImporte80()));
                        
                        if (dtoAgrupado.getImporte84() != null && dtoNoAgrupado.getImporte84() != null) 
                        dtoAgrupado.setImporte84(dtoAgrupado.getImporte84().add(dtoNoAgrupado.getImporte84()));
                        
                        if (dtoAgrupado.getImporte88() != null && dtoNoAgrupado.getImporte88() != null) 
                        dtoAgrupado.setImporte88(dtoAgrupado.getImporte88().add(dtoNoAgrupado.getImporte88()));
                        
                        //cambio SAPFI-001  (SCS-07/05/08)  
                        if (dtoAgrupado.getImporte90() != null && dtoNoAgrupado.getImporte90() != null) 
                          dtoAgrupado.setImporte90(dtoAgrupado.getImporte90().add(dtoNoAgrupado.getImporte90()));
                        
                        //añadimos el dtoAgrupado modificado a la listaAgrupada
                        if (dtoAgrupado.getImporte() != null && dtoNoAgrupado.getImporte() != null){
                            dtoAgrupado.setImporte(dtoAgrupado.getImporte().add(dtoNoAgrupado.getImporte()));
                        }
                        listaAgrupada.set(j,dtoAgrupado);
                        encontrado = true;
                        break;    
                    }
              
                  }
              }
              
              UtilidadesLog.debug("encontrado: " + encontrado);
              
              if (! encontrado) {
                listaAgrupada.add(dtoNoAgrupado);
              }
        }//fin primer for
        
        UtilidadesLog.warn("listaAgrupada cant: " + listaAgrupada.size());
                
        if ( primeraAgrupacion.booleanValue() ) {
            UtilidadesLog.debug("listaAgrupada absolutos: " + listaAgrupada.size());
        }else {
            ArrayList listaAgrupadaDebeHaber = new ArrayList();
                
            for (int i=0; i < listaAgrupada.size(); i++) {
                 /*
                  * Si el resultado final de 'importe' > 0 -> indicadorDebeHaber(del grupo) = ConstantesINT.COD_DEBE
                  * Si el resultado final de 'importe' < 0 -> indicadorDebeHaber(del grupo) = ConstantesINT.COD_HABER
                  * Si el resultado final de 'importe' = 0 -> se elimina el registro de agrupamiento
                  * producto = null
                  * codigoProducto = null
                  */
                 dtoAgrupado = (DTOINTDocumentoContable)listaAgrupada.get(i);

                 if ( (dtoAgrupado.getImporte() == null) || (dtoAgrupado.getImporte().compareTo(new BigDecimal(0)) == 0) ) {
                    UtilidadesLog.debug("no adiciona este registro a listaAgrupadaDebeHaber");                
                 } else if (dtoAgrupado.getImporte().compareTo(new BigDecimal(0)) > 0) {
                    dtoAgrupado.setIndicadorDebeHaber(CCCConstantes.COD_DEBE);
                    
                    dtoAgrupado.setProducto(null);
                    dtoAgrupado.setCodigoProducto(null);
                    dtoAgrupado.setCodigoCicloVida(null);//dblg4000852
                    dtoAgrupado.setCodigoNegocio(null);//dblg4000852
                    dtoAgrupado.setMarcaProducto(null);//dblg4000852
                    dtoAgrupado.setCodigoMarcaProducto(null);//dblg4000852
                    dtoAgrupado.setCodigoTipoOferta(null);//dblg4000852
                    dtoAgrupado.setCodigoGrupoProductos(null);//dblg4000852
                    
                    
                    listaAgrupadaDebeHaber.add(dtoAgrupado);
                    
                 } else if (dtoAgrupado.getImporte().compareTo(new BigDecimal(0)) < 0) {
                    dtoAgrupado.setIndicadorDebeHaber(CCCConstantes.COD_HABER);
                    
                    dtoAgrupado.setProducto(null);
                    dtoAgrupado.setCodigoProducto(null);
                    dtoAgrupado.setCodigoCicloVida(null);//dblg4000852
                    dtoAgrupado.setCodigoNegocio(null);//dblg4000852
                    dtoAgrupado.setMarcaProducto(null);//dblg4000852
                    dtoAgrupado.setCodigoMarcaProducto(null);//dblg4000852
                    dtoAgrupado.setCodigoTipoOferta(null);//dblg4000852
                    dtoAgrupado.setCodigoGrupoProductos(null);//dblg4000852
                    
                    listaAgrupadaDebeHaber.add(dtoAgrupado);
                 }
            }  
            listaAgrupada = listaAgrupadaDebeHaber;
            UtilidadesLog.warn("listaAgrupadaDebeHaber cant: " + listaAgrupada.size());
        }
      }
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTDocumentoContable(ArrayList listaSinAgrupar, Boolean primeraAgrupacion): Salida");
      return listaAgrupada;
  }
   

    /**
     * 
     */
    private Boolean comparaDTOINTDocumentoContable (DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2) throws MareException {
        //Compara 2  DTOINTDocumentoContable   
        UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Entrada");
        /*
         codigoPais 
         codigoEmpresa 
         codigoCanal 
         codigoAcceso 
         codigoSubacceso 
         codigoTipoPeriodo 
         codigoPeriodo 
         fecha 
        */
        if (dto1.getCodigoPais()!=null && dto2.getCodigoPais()!=null) {
            if (! dto1.getCodigoPais().equals(dto2.getCodigoPais())) {
                UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPais()!=dto2.getCodigoPais()) {
            UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoEmpresa()!=null && dto2.getCodigoEmpresa()!=null) {
            if (! dto1.getCodigoEmpresa().equals(dto2.getCodigoEmpresa())) {
                UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoEmpresa() != dto2.getCodigoEmpresa()) {
            UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoCanal()!=null && dto2.getCodigoCanal()!=null){
            if (! dto1.getCodigoCanal().equals(dto2.getCodigoCanal())){
                UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoCanal() != dto2.getCodigoCanal()){
            UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoAcceso()!=null && dto2.getCodigoAcceso()!=null){
            if (! dto1.getCodigoAcceso().equals(dto2.getCodigoAcceso())){
                UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoAcceso() != dto2.getCodigoAcceso()){
            UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        
        if (dto1.getCodigoSubacceso()!=null && dto2.getCodigoSubacceso()!=null){
            if (! dto1.getCodigoSubacceso().equals(dto2.getCodigoSubacceso())){
                UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoSubacceso() != dto2.getCodigoSubacceso()){
            UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoTipoPeriodo()!=null && dto2.getCodigoTipoPeriodo()!=null){
            if (! dto1.getCodigoTipoPeriodo().equals(dto2.getCodigoTipoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoTipoPeriodo() != dto2.getCodigoTipoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoPeriodo()!=null && dto2.getCodigoPeriodo()!=null){
            if (! dto1.getCodigoPeriodo().equals(dto2.getCodigoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPeriodo() != dto2.getCodigoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

            if (dto1.getRUC()!=null && dto2.getRUC()!=null){
                if (! dto1.getRUC().equals(dto2.getRUC())){
                    UtilidadesLog.info("****Metodo  getRUC: Salida False");
                    UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                    return new Boolean(false);
                }
            }else if (dto1.getRUC() != dto2.getRUC()){
                UtilidadesLog.info("****Metodo  getRUC: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }

           
        if (dto1.getFecha()!=null && dto2.getFecha()!=null){
            if (dto1.getFecha().compareTo(dto2.getFecha()) != 0){
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getFecha() != dto2.getFecha()){
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
        return new Boolean(true);
    }
    
    
    private Boolean comparaDTOINTDocumentoContable2 (DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2) throws MareException {
        //Compara 2  DTOINTDocumentoContable   
        UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Entrada");
        /*codigoPais 
        codigoEmpresa 
        codigoCanal 
        codigoAcceso 
        codigoSubacceso 
        codigoTipoPeriodo 
        codigoPeriodo 
        RUC
        codigoApunte 
        tipoAsiento 
        tipoMovimientoSAPFI 
        codigoImporteAContabilizar
        */
        if (dto1.getCodigoPais()!=null && dto2.getCodigoPais()!=null){
            if (! dto1.getCodigoPais().equals(dto2.getCodigoPais())){
                UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPais()!=dto2.getCodigoPais()){
            UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoEmpresa()!=null && dto2.getCodigoEmpresa()!=null){
            if (! dto1.getCodigoEmpresa().equals(dto2.getCodigoEmpresa())) {
                UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoEmpresa() != dto2.getCodigoEmpresa()){
            UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoCanal()!=null && dto2.getCodigoCanal()!=null){
            if (! dto1.getCodigoCanal().equals(dto2.getCodigoCanal())){
                UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoCanal() != dto2.getCodigoCanal()){
            UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoAcceso()!=null && dto2.getCodigoAcceso()!=null){
            if (! dto1.getCodigoAcceso().equals(dto2.getCodigoAcceso())){
                UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoAcceso() != dto2.getCodigoAcceso()){
            UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoSubacceso()!=null && dto2.getCodigoSubacceso()!=null){
            if (! dto1.getCodigoSubacceso().equals(dto2.getCodigoSubacceso())){
                UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoSubacceso() != dto2.getCodigoSubacceso()){
            UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoTipoPeriodo()!=null && dto2.getCodigoTipoPeriodo()!=null){
            if (! dto1.getCodigoTipoPeriodo().equals(dto2.getCodigoTipoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoTipoPeriodo() != dto2.getCodigoTipoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoPeriodo()!=null && dto2.getCodigoPeriodo()!=null){
            if (! dto1.getCodigoPeriodo().equals(dto2.getCodigoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPeriodo() != dto2.getCodigoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
         if (dto1.getRUC()!=null && dto2.getRUC()!=null){
             if (! dto1.getRUC().equals(dto2.getRUC())){
                        UtilidadesLog.info("****Metodo  getRUC: Salida False");
                        UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                        return new Boolean(false);
                    }
                }else if (dto1.getRUC() != dto2.getRUC()){
                    UtilidadesLog.info("****Metodo  getRUC: Salida False");
                    UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                    return new Boolean(false);
                }
         if (dto1.getCodigoApunte()!=null && dto2.getCodigoApunte()!=null){
            if (! dto1.getCodigoApunte().equals(dto2.getCodigoApunte())){
                 UtilidadesLog.info("****Metodo  getCodigoApunte: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoApunte() != dto2.getCodigoApunte()){
             UtilidadesLog.info("****Metodo  getCodigoApunte: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
         if (dto1.getTipoAsiento()!=null && dto2.getTipoAsiento()!=null){
            if (! dto1.getTipoAsiento().equals(dto2.getTipoAsiento())){
                UtilidadesLog.info("****Metodo  getTipoAsiento: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getTipoAsiento() != dto2.getTipoAsiento()){
            UtilidadesLog.info("****Metodo  getTipoAsiento: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }  
         
        if (dto1.getTipoMovimientoSAPFI()!=null && dto2.getTipoMovimientoSAPFI()!=null){
            if (! dto1.getTipoMovimientoSAPFI().equals(dto2.getTipoMovimientoSAPFI())){
                UtilidadesLog.info("****Metodo  getTipoMovimientoSAPFI: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getTipoMovimientoSAPFI() != dto2.getTipoMovimientoSAPFI()){
            UtilidadesLog.info("****Metodo  getTipoMovimientoSAPFI: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }    
       
        if (dto1.getCodigoImporteAContabilizar()!=null && dto2.getCodigoImporteAContabilizar()!=null){
            if (! dto1.getCodigoImporteAContabilizar().equals(dto2.getCodigoImporteAContabilizar())){
                UtilidadesLog.info("****Metodo  getCodigoImporteAContabilizar: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoImporteAContabilizar() != dto2.getCodigoImporteAContabilizar()){
            UtilidadesLog.info("****Metodo  getCodigoImporteAContabilizar: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }   
       if (dto1.getFecha()!=null && dto2.getFecha()!=null){
            if (! dto1.getFecha().equals(dto2.getFecha())){
                UtilidadesLog.info("****Metodo  getCodigoImporteAContabilizar: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getFecha() != dto2.getFecha()){
            UtilidadesLog.info("****Metodo  getCodigoImporteAContabilizar: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }    
         if (dto1.getImporteAContabilizar()!=null && dto2.getImporteAContabilizar()!=null){
            if (! dto1.getImporteAContabilizar().equals(dto2.getImporteAContabilizar())){
                UtilidadesLog.info("****Metodo  getCodigoImporteAContabilizar: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getImporteAContabilizar() != dto2.getImporteAContabilizar()){
            UtilidadesLog.info("****Metodo  getCodigoImporteAContabilizar: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }    
        
        UtilidadesLog.info("MONINTSAPFIBean.comparaDTOINTDocumentoContable2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
        return new Boolean(true);
    }
    

    /*
     * 
     */
    private ArrayList agruparCabeceraDetalle (ArrayList listaDocumentos, Boolean agruparProducto, String tipoAsiento) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.agruparCabeceraDetalle(ArrayList listaDocumentos, Boolean agruparProducto, String tipoAsiento): Entrada");        
        UtilidadesLog.debug("agruparProducto: " + agruparProducto);
        UtilidadesLog.debug("tipoAsiento: " + tipoAsiento);
        
        ArrayList listaAgrupados = new ArrayList();
        ArrayList listaAgrupadoOrdenados = new ArrayList();
        
        // Se agrupan y ordenan los elementos de la lista 'listaDocumentos' según los siguientes atributos 

        //- la agrupación de los elementos de 'listaDocumentos' se hará sobre una nueva lista, 'listaAgrupados', que contendrá un objeto DTOINTDocumentoContable por cada agrupación; además, durante el proceso de agrupación, se irá calculando el sumatorio de los importes correspondientes. Al finalizar el proceso de agrupamiento, 'importe01' e 'importe03' se modificarán a su valor absoluto. 
        
        UtilidadesLog.debug("agruparProducto: " + agruparProducto);

        if( agruparProducto.booleanValue() ) { 
            listaAgrupados = this.agruparDTOINTCabeceraDetalle(listaDocumentos);
            listaAgrupadoOrdenados = this.ordenar5(listaAgrupados);
 
        } else { 
            // Segunda agrupación de detalle 
            listaAgrupados = this.agruparDTOINTCabeceraDetalle2(listaDocumentos);
            // incidencia BELC300013913 
            listaAgrupadoOrdenados = this.ordenar6(listaAgrupados, tipoAsiento);
        } 
        
        UtilidadesLog.info("listaAgrupadoOrdenados cant: " + listaAgrupadoOrdenados.size());
        UtilidadesLog.info("listaAgrupadoOrdenados: " + listaAgrupadoOrdenados);
        
        UtilidadesLog.info("MONINTSAPFIBean.agruparCabeceraDetalle(ArrayList listaDocumentos, Boolean agruparProducto, String tipoAsiento): Salida");
        return listaAgrupadoOrdenados;
    }


    private Boolean compararDTOINTDocumentoContableDetalle2 (DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2) throws MareException {
        //Compara   DTOINTDocumentoContable   
        UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Entrada");
     /*
      * codigoPais 
codigoEmpresa 
codigoCanal 
codigoAcceso 
codigoSubacceso 
codigoTipoPeriodo 
codigoPeriodo 
RUC 
codigoMarcaProducto 
codigoGrupoProductos 
codigoNegocio 
codigoTipoOferta 
codigoCicloVida 
codigoApunte 
tipoAsiento 
tipoMovimientoSAPFI 
codigoImporteAContabilizar 
      * */
     
        if (dto1.getCodigoPais()!=null && dto2.getCodigoPais()!=null){
            if (! dto1.getCodigoPais().equals(dto2.getCodigoPais())){
                UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPais()!=dto2.getCodigoPais()){
            UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoEmpresa()!=null && dto2.getCodigoEmpresa()!=null){
            if (! dto1.getCodigoEmpresa().equals(dto2.getCodigoEmpresa())){
                UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoEmpresa() != dto2.getCodigoEmpresa()){
            UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoCanal()!=null && dto2.getCodigoCanal()!=null){
            if (! dto1.getCodigoCanal().equals(dto2.getCodigoCanal())){
                UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoCanal() != dto2.getCodigoCanal()){
            UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoAcceso()!=null && dto2.getCodigoAcceso()!=null){
            if (! dto1.getCodigoAcceso().equals(dto2.getCodigoAcceso())){
                UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoAcceso() != dto2.getCodigoAcceso()){
            UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        
        if (dto1.getCodigoSubacceso()!=null && dto2.getCodigoSubacceso()!=null){
            if (! dto1.getCodigoSubacceso().equals(dto2.getCodigoSubacceso())){
                UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoSubacceso() != dto2.getCodigoSubacceso()){
            UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoTipoPeriodo()!=null && dto2.getCodigoTipoPeriodo()!=null){
            if (! dto1.getCodigoTipoPeriodo().equals(dto2.getCodigoTipoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoTipoPeriodo() != dto2.getCodigoTipoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoPeriodo()!=null && dto2.getCodigoPeriodo()!=null){
            if (! dto1.getCodigoPeriodo().equals(dto2.getCodigoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPeriodo() != dto2.getCodigoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        if (dto1.getRUC()!=null && dto2.getRUC()!=null){
            if (! dto1.getRUC().equals(dto2.getRUC())){
                UtilidadesLog.info("****Metodo  getRUC: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
            }else if (dto1.getRUC() != dto2.getRUC()){
                UtilidadesLog.info("****Metodo  getRUC: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
        }
         if (dto1.getCodigoMarcaProducto()!=null && dto2.getCodigoMarcaProducto()!=null){
            if (! dto1.getCodigoMarcaProducto().equals(dto2.getCodigoMarcaProducto())){
                UtilidadesLog.info("****Metodo  getCodigoMarcaProducto: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoMarcaProducto() != dto2.getCodigoMarcaProducto()){
            UtilidadesLog.info("****Metodo  getCodigoMarcaProducto: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

        if (dto1.getCodigoGrupoProductos()!=null && dto2.getCodigoGrupoProductos()!=null){
            if (! dto1.getCodigoGrupoProductos().equals(dto2.getCodigoGrupoProductos())){
                UtilidadesLog.info("****Metodo  getCodigoGrupoProductos: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoGrupoProductos() != dto2.getCodigoGrupoProductos()){
            UtilidadesLog.info("****Metodo  getCodigoGrupoProductos: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
         if (dto1.getCodigoNegocio()!=null && dto2.getCodigoNegocio()!=null){
            if (! dto1.getCodigoNegocio().equals(dto2.getCodigoNegocio())){
                UtilidadesLog.info("****Metodo  getCodigoNegocio: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoNegocio() != dto2.getCodigoNegocio()){
            UtilidadesLog.info("****Metodo  getCodigoNegocio: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
         if (dto1.getCodigoTipoOferta()!=null && dto2.getCodigoTipoOferta()!=null){
            if (! dto1.getCodigoTipoOferta().equals(dto2.getCodigoTipoOferta())){
                UtilidadesLog.info("****Metodo  getCodigoTipoOferta: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoTipoOferta() != dto2.getCodigoTipoOferta()){
            UtilidadesLog.info("****Metodo  getCodigoTipoOferta: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
         if (dto1.getCodigoCicloVida()!=null && dto2.getCodigoCicloVida()!=null){
            if (! dto1.getCodigoCicloVida().equals(dto2.getCodigoCicloVida())){
                UtilidadesLog.info("****Metodo  getCicloVida: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoCicloVida() != dto2.getCodigoCicloVida()){
            UtilidadesLog.info("****Metodo  getCicloVida: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoApunte()!=null && dto2.getCodigoApunte()!=null){
            if (! dto1.getCodigoApunte().equals(dto2.getCodigoApunte())){
                UtilidadesLog.info("****Metodo  getCodigoApunte: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoApunte() != dto2.getCodigoApunte()){
            UtilidadesLog.info("****Metodo  getCodigoApunte: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getTipoAsiento()!=null && dto2.getTipoAsiento()!=null){
            if (! dto1.getTipoAsiento().equals(dto2.getTipoAsiento())){
                UtilidadesLog.info("****Metodo  getTipoAsiento: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getTipoAsiento() != dto2.getTipoAsiento()){
            UtilidadesLog.info("****Metodo  getTipoAsiento: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getTipoMovimientoSAPFI()!=null && dto2.getTipoMovimientoSAPFI()!=null){
            if (! dto1.getTipoMovimientoSAPFI().equals(dto2.getTipoMovimientoSAPFI())){
                UtilidadesLog.info("****Metodo  getTipoMovimientoSAPFI: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getTipoMovimientoSAPFI() != dto2.getTipoMovimientoSAPFI()){
            UtilidadesLog.info("****Metodo  getTipoMovimientoSAPFI: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoImporteAContabilizar()!=null && dto2.getCodigoImporteAContabilizar()!=null){
            if (! dto1.getCodigoImporteAContabilizar().equals(dto2.getCodigoImporteAContabilizar())){
                UtilidadesLog.info("****Metodo  getImporteAContabilizar: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoImporteAContabilizar() != dto2.getCodigoImporteAContabilizar()){
            UtilidadesLog.info("****Metodo  getImporteAContabilizar: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        if (dto1.getFecha()!=null && dto2.getFecha()!=null){
            if (dto1.getFecha().compareTo(dto2.getFecha()) != 0) {
                UtilidadesLog.info("****Metodo  comparaCabecera: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getFecha() != dto2.getFecha()){
            UtilidadesLog.info("****Metodo  comparaCabecera: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
                if (dto1.getImporteAContabilizar()!=null && dto2.getImporteAContabilizar()!=null){
            if (dto1.getImporteAContabilizar().compareTo(dto2.getImporteAContabilizar()) != 0) {
                UtilidadesLog.info("****Metodo  comparaCabecera: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getImporteAContabilizar() != dto2.getImporteAContabilizar()){
            UtilidadesLog.info("****Metodo  comparaCabecera: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

        UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle2(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
        return new Boolean(true);
    }
    
     // BELC300013913. RUC solo se utiliza para ordenar si el tipoAsiento es de transporte 
     // con transportista
    private ArrayList ordenar6(ArrayList listaRegistros, String tipoAsientos) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.ordenar6(ArrayList listaRegistros, String tipoAsientos): Entrada");
        UtilidadesLog.warn("ordenar6() listaRegistros.size "+ listaRegistros.size());
        listaRegistros = cambioDeNulos(listaRegistros, Boolean.TRUE);
        int i;
        int j;
        int n=listaRegistros.size();
        int posicionMenor;
        DTOINTDocumentoContable  dtoMenor=null;        
        DTOINTDocumentoContable  dtoAux=null;        
      
        ArrayList listaOrdenada = new ArrayList();
	      j = 0;
      
        while (j < n) {
		      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(j);  
          posicionMenor = j;
          
          for (i = j+1; i < n; i++) {
                if (dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) > 0 ){
                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                    posicionMenor = i;
                }else{ //si no es mmayor puede ser igual
                    if(dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) == 0 ){
                    //codigoEmpresa 
                        if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) > 0 ){
                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                            posicionMenor = i;
                        } else {
                            if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) == 0 ){
                            //codigoCanal 
                                if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) > 0 ){
                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                    posicionMenor = i;
                                }else {
                                    if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) == 0 ){
                                    // codigoAcceso 
                                        if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) > 0 ){
                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                            posicionMenor = i;
                                        } else {
                                            if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso())== 0 ){
                                            //codigoSubacceso 
                                                if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) > 0 ){
                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                    posicionMenor = i;
                                                }else {
                                                    if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) == 0 ){
                                                    //codigoTipoPeriodo 
                                                         if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) > 0 ){
                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                            posicionMenor = i;
                                                        } else {
                                                            if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) == 0 ){
                                                            //CodigoPeriodo
                                                                if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) > 0 ){
                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                    posicionMenor = i;
                                                                } else {
                                                                    if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) == 0 ){
                                                                    //RUC 
                                                                        // por BELC300013913 RUC sólo se utiliza en las ordenaciones de 
                                                                        // documentos de Transportistas
                                                                        if (tipoAsientos.toUpperCase().equals( ConstantesINT.TIPO_ASIENTO_TN )) {
                                                                           if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) > 0 ){
                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                               posicionMenor = i;
                                                                           } else {
                                                                               if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) == 0 ){
                                                                               //codigoMarcaProducto 
                                                                                   if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) > 0 ){
                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                       posicionMenor = i;
                                                                                   } else {
                                                                                       if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) == 0 ){
                                                                                       //codigoGrupoProductos 
                                                                                           if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) > 0 ){
                                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                               posicionMenor = i;
                                                                                           } else {
                                                                                               if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) == 0 ){
                                                                                               //codigoNegocio 
                                                                                                   if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) > 0 ){
                                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                       posicionMenor = i;
                                                                                                   } else {
                                                                                                       if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) == 0 ){
                                                                                                       //codigoTipoOferta 
                                                                                                           if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) > 0 ){
                                                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                               posicionMenor = i;
                                                                                                           } else {
                                                                                                               if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) == 0 ){
                                                                                                               //codigoCicloVida  
                                                                                                                   if (dtoMenor.getCodigoCicloVida().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCicloVida()) > 0 ){
                                                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                       posicionMenor = i;
                                                                                                                   } else {
                                                                                                                       if (dtoMenor.getCodigoCicloVida().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCicloVida()) == 0 ){
                                                                                                                       //codigoApunte 
                                                                                                                           // incidencia BELC300017884
                                                                                                                           if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) > 0 ){
                                                                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                               posicionMenor = i;
                                                                                                                           } else {
                                                                                                                               // incidencia BELC300017884
                                                                                                                               if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) == 0 ){    
                                                                                                                               //tipoAsiento 
                                                                                                                                   if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) > 0 ){
                                                                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                       posicionMenor = i;
                                                                                                                                   } else {
                                                                                                                                       if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) == 0 ){
                                                                                                                                       //tipoMovimientoSAPFI 
                                                                                                                                           UtilidadesLog.debug(dtoMenor.getTipoMovimientoSAPFI()+" y5 "+((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI());
                                                                                                                                           UtilidadesLog.debug("dio: "+ dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()));
                                                                                                                                           if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) > 0 ){
                                                                                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                               posicionMenor = i;
                                                                                                                                           } else {
                                                                                                                                               if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) == 0 ){
                                                                                                                                               //codigoImporteAContabilizar   
                                                                                                                                                   if (dtoMenor.getCodigoImporteAContabilizar().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoImporteAContabilizar()) > 0 ){
                                                                                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                       posicionMenor = i;
                                                                                                                                                   }
                                                                                                                                               }
                                                                                                                                           }
                                                                                                                                       }
                                                                                                                                   }
                                                                                                                               }
                                                                                                                           }
                                                                                                                       }
                                                                                                                   }
                                                                                                               }
                                                                                                           }
                                                                                                       }
                                                                                                   }
                                                                                               }
                                                                                           }
                                                                                       }
                                                                                   }
                                                                               }
                                                                           }                                                                           
                                                                        } else { // el tipo de asiento es de venta con transportista
                                                                            //codigoMarcaProducto 
                                                                             if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) > 0 ){
                                                                                 dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                 posicionMenor = i;
                                                                             } else {
                                                                                 if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) == 0 ){
                                                                                 //codigoGrupoProductos 
                                                                                     if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) > 0 ){
                                                                                         dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                         posicionMenor = i;
                                                                                     } else {
                                                                                         if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) == 0 ){
                                                                                         //codigoNegocio 
                                                                                             if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) > 0 ){
                                                                                                 dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                 posicionMenor = i;
                                                                                             } else {
                                                                                                 if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) == 0 ){
                                                                                                   //codigoTipoOferta 
                                                                                                     if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) > 0 ){
                                                                                                         dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                         posicionMenor = i;
                                                                                                     } else {
                                                                                                         if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) == 0 ){
                                                                                                             // incidencia BELC300017884
                                                                                                             if (dtoMenor.getCodigoCicloVida().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCicloVida()) > 0 ){
                                                                                                                 dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                 posicionMenor = i;
                                                                                                             } else {
                                                                                                                // incidencia BELC300017884
                                                                                                                if (dtoMenor.getCodigoCicloVida().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCicloVida()) == 0 ){
                                                                                                                     //codigoApunte 
                                                                                                                     if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) > 0 ){
                                                                                                                         dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                         posicionMenor = i;
                                                                                                                     } else {
                                                                                                                         if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) == 0 ){    
                                                                                                                         //tipoAsiento 
                                                                                                                             if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) > 0 ){
                                                                                                                                 dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                 posicionMenor = i;
                                                                                                                             } else {
                                                                                                                                 if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) == 0 ){
                                                                                                                                 //tipoMovimientoSAPFI 
                                                                                                                                     UtilidadesLog.debug(dtoMenor.getTipoMovimientoSAPFI()+" y6 "+((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI());
                                                                                                                                        UtilidadesLog.debug("dio: "+ dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()));
                                                                                                                                     if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) > 0 ){
                                                                                                                                         dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                         posicionMenor = i;
                                                                                                                                     } else {
                                                                                                                                         if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) == 0 ){
                                                                                                                                         //codigoImporteAContabilizar   
                                                                                                                                             if (dtoMenor.getCodigoImporteAContabilizar().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoImporteAContabilizar()) > 0 ){
                                                                                                                                                 dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                 posicionMenor = i;
                                                                                                                                             }
                                                                                                                                         }
                                                                                                                                     }
                                                                                                                                 }
                                                                                                                             }
                                                                                                                         }
                                                                                                                     }
                                                                                                                 }//fin ciclo vida
                                                                                                             }
                                                                                                         }
                                                                                                     }
                                                                                                 }
                                                                                             }
                                                                                         }
                                                                                     }
                                                                                 }
                                                                             }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

          }//FOR
          dtoAux=(DTOINTDocumentoContable)listaRegistros.get(j);//guardamos el registro que vamos a quitar de la listaRegistro en la posicion del menor
          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(posicionMenor);//guardamos el registro de la posicion menor
          listaRegistros.set(posicionMenor,dtoAux);//ponemos el auxiliar en la lista de nuevo, en la psicion delmenor.
          listaOrdenada.add(dtoMenor);//añadimos a la nueva lista ordenada el menor
          j++;
    
        }//while 
        listaOrdenada = cambioDeNulos(listaOrdenada,Boolean.FALSE);
       UtilidadesLog.info("MONINTSAPFIBean.ordenar6(ArrayList listaRegistros, String tipoAsientos): Salida");     
     return listaOrdenada;
     
    }


    /**
    * - criterios de agrupamiento: 
    * codigoPais
    * codigoEmpresa
    * codigoCanal 
    * codigoAcceso 
    * codigoSubacceso 
    * codigoTipoPeriodo 
    * codigoPeriodo 
    * RUC 
    * codigoMarcaProducto 
    * codigoGrupoProductos 
    * codigoNegocio 
    * codigoTipoOferta 
    * codigoCicloVida 
    * codigoApunte 
    * tipoAsiento 
    * tipoMovimientoSAPFI 
    * codigoImporteAContabilizar 
    */
    private ArrayList agruparDTOINTCabeceraDetalle2 (ArrayList listaSinAgrupar) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTCabeceraDetalle2(ArrayList listaSinAgrupar): Entrada");
      UtilidadesLog.warn("listaSinAgrupar cant: " + listaSinAgrupar.size());
      ArrayList listaAgrupada = new ArrayList();
      DTOINTDocumentoContable dtoNoAgrupado;
      DTOINTDocumentoContable dtoAgrupado;
      boolean encontrado;
      
      if(listaSinAgrupar.size()>0){
          // metemos el primer elemento en la lista agrupada
          listaAgrupada.add((DTOINTDocumentoContable)listaSinAgrupar.get(0));
          
          for (int i=1; i < listaSinAgrupar.size(); i++) {
             
             dtoNoAgrupado = (DTOINTDocumentoContable)listaSinAgrupar.get(i);
             
             encontrado = false;
             
             for (int j=0; j < listaAgrupada.size(); j++) {
                
                dtoAgrupado = (DTOINTDocumentoContable)listaAgrupada.get(j);
          
                if (this.compararDTOINTDocumentoContableDetalle2(dtoNoAgrupado, dtoAgrupado).booleanValue()) { // se deben agrupar
                 
                   dtoAgrupado.setImporte01(dtoAgrupado.getImporte01()!=null?dtoAgrupado.getImporte01():new BigDecimal(0));
                   dtoAgrupado.setImporte03(dtoAgrupado.getImporte03()!=null?dtoAgrupado.getImporte03():new BigDecimal(0));
                   // vbongiov -- Cambio 20090922 -- 28/05/2009
                   dtoAgrupado.setImporte04(dtoAgrupado.getImporte04()!=null?dtoAgrupado.getImporte04():new BigDecimal(0));
                    
                   dtoAgrupado.setImporte05(dtoAgrupado.getImporte05()!=null?dtoAgrupado.getImporte05():new BigDecimal(0));
                   dtoAgrupado.setImporte07(dtoAgrupado.getImporte07()!=null?dtoAgrupado.getImporte07():new BigDecimal(0));
                   
                   dtoNoAgrupado.setImporte01(dtoNoAgrupado.getImporte01()!=null?dtoNoAgrupado.getImporte01():new BigDecimal(0));
                   dtoNoAgrupado.setImporte03(dtoNoAgrupado.getImporte03()!=null?dtoNoAgrupado.getImporte03():new BigDecimal(0));
                   // vbongiov -- Cambio 20090922 -- 28/05/2009
                   dtoNoAgrupado.setImporte04(dtoNoAgrupado.getImporte04()!=null?dtoNoAgrupado.getImporte04():new BigDecimal(0)); 
                   
                   dtoNoAgrupado.setImporte05(dtoNoAgrupado.getImporte05()!=null?dtoNoAgrupado.getImporte05():new BigDecimal(0));
                   dtoNoAgrupado.setImporte07(dtoNoAgrupado.getImporte07()!=null?dtoNoAgrupado.getImporte07():new BigDecimal(0));
                 
                   dtoAgrupado.setImporte01(dtoAgrupado.getImporte01().add(dtoNoAgrupado.getImporte01()));
                   dtoAgrupado.setImporte03(dtoAgrupado.getImporte03().add(dtoNoAgrupado.getImporte03()));
                   
                   // vbongiov -- Cambio 20090922 -- 28/05/2009
                   dtoAgrupado.setImporte04(dtoAgrupado.getImporte04().add(dtoNoAgrupado.getImporte04()));
                   
                   dtoAgrupado.setImporte05(dtoAgrupado.getImporte05().add(dtoNoAgrupado.getImporte05()));
                   dtoAgrupado.setImporte07(dtoAgrupado.getImporte07().add(dtoNoAgrupado.getImporte07()));
                    
                    dtoAgrupado.setImporte(dtoAgrupado.getImporte()!=null?dtoAgrupado.getImporte():new BigDecimal(0));   
                    dtoNoAgrupado.setImporte(dtoNoAgrupado.getImporte()!=null?dtoNoAgrupado.getImporte():new BigDecimal(0));   
                    
                    dtoAgrupado.setImporte(dtoAgrupado.getImporte().add(dtoNoAgrupado.getImporte()));   
                    
                    //se añaden los cambios del dtoAgrupado a la listaAgrupada
                    listaAgrupada.set(j,dtoAgrupado);
                    encontrado = true;
                    break;
                }
             }
             if (! encontrado) {
                listaAgrupada.add(dtoNoAgrupado);
             }
          }      
          
          ArrayList listaAgrupadaDebeHaber = new ArrayList();
          
          for (int i=0; i < listaAgrupada.size(); i++) {
             /*
              * Si el resultado final de 'importe' > 0 -> indicadorDebeHaber(del grupo) = ConstantesINT.COD_DEBE
              * Si el resultado final de 'importe' < 0 -> indicadorDebeHaber(del grupo) = ConstantesINT.COD_HABER
              * Si el resultado final de 'importe' = 0 -> se elimina el registro de agrupamiento
              * producto = null
              * codigoProducto = null
              */
             dtoAgrupado = (DTOINTDocumentoContable)listaAgrupada.get(i);

             if ((dtoAgrupado.getImporte() == null) || (dtoAgrupado.getImporte().compareTo(new BigDecimal(0)) == 0)) {
                UtilidadesLog.info("no adiciona este registro a listaAgrupadaDebeHaber");  
             } else if (dtoAgrupado.getImporte().compareTo(new BigDecimal(0)) > 0) {
                dtoAgrupado.setIndicadorDebeHaber(CCCConstantes.COD_DEBE);
                
                dtoAgrupado.setProducto(null);
                dtoAgrupado.setCodigoProducto(null);
                
                listaAgrupadaDebeHaber.add(dtoAgrupado);
                
             } else if (dtoAgrupado.getImporte().compareTo(new BigDecimal(0)) < 0) {
                dtoAgrupado.setIndicadorDebeHaber(CCCConstantes.COD_HABER);
                
                dtoAgrupado.setProducto(null);
                dtoAgrupado.setCodigoProducto(null);
                
                listaAgrupadaDebeHaber.add(dtoAgrupado);
             }
          }
          
          listaAgrupada = listaAgrupadaDebeHaber;
      }
      UtilidadesLog.warn("listaAgrupadaDebeHaber size: " + listaAgrupada.size());
      
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTCabeceraDetalle2(ArrayList listaSinAgrupar): Salida");
      return listaAgrupada;
   }

   
   private ArrayList ordenar5(ArrayList listaRegistros) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.ordenar5(): Entrada");
        UtilidadesLog.warn("ordenar5() listaRegistros.size "+ listaRegistros.size());
        listaRegistros = this.cambioDeNulos(listaRegistros,Boolean.TRUE);
        int i;
        int j;
        int n=listaRegistros.size();
        int posicionMenor;
        DTOINTDocumentoContable  dtoMenor=null;        
        DTOINTDocumentoContable  dtoAux=null;        
      
        ArrayList listaOrdenada = new ArrayList();
	      j = 0;
      
        while (j < n) {
		      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(j);  
          posicionMenor = j;
          
          for (i = j+1; i < n; i++) {
                
                if (dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) > 0 ){
                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                    posicionMenor = i;
                }else{ //si no es mmayor puede ser igual
                        if(dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) == 0 ){
                        //Si es iguakl decide el segundo parametro 
                             if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) > 0 ){
                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                       posicionMenor = i;
                             }else{  
                                  if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) == 0 ){   
                                  //si es igual decide el 4 parametro
                                       if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) > 0 ){   
                                          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                          posicionMenor = i;
                                      }else{
                                             if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) == 0 ){   
                                             //decide el 5
                                                 if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) > 0 ){   
                                                     dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                     posicionMenor = i;
                                                 }else { 
                                                     if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) == 0 ){   
                                                         //decide el 6
                                                         if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) > 0 ){   
                                                             dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                             posicionMenor = i;
                                                         }else {
                                                             if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) == 0 ){   
                                                             //decide 7
                                                                 if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) > 0 ){   
                                                                     dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                     posicionMenor = i;
                                                                 }else {
                                                                     if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) == 0 ){   
                                                                     //decide el 8
                                                                         if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) > 0 ){   
                                                                             dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                             posicionMenor = i;
                                                                         }else {
                                                                             if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) == 0 ){   
                                                                             //decide el 9
                                                                                  if (dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) > 0 ){   
                                                                                      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                      posicionMenor = i;
                                                                                  } else {
                                                                                      if (dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) == 0 ){   
                                                                                      //decide 12
                                                                                         if (dtoMenor.getCodigoProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoProducto()) > 0 ){   
                                                                                             dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                             posicionMenor = i;
                                                                                         }else {
                                                                                             if (dtoMenor.getCodigoProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoProducto()) == 0 ){   
                                                                                             //decide 13
                                                                                                 if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) > 0 ){   
                                                                                                     dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                     posicionMenor = i;
                                                                                                 } else {
                                                                                                     if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) == 0 ){   
                                                                                                     //decide 14
                                                                                                         // incidencia BELC300017884
                                                                                                         if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) > 0 ){   
                                                                                                             dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                             posicionMenor = i;
                                                                                                         } else {
                                                                                                             // incidencia BELC300017884
                                                                                                             if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) == 0 ){   
                                                                                                             //decide 15
                                                                                                                 if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) > 0 ){   
                                                                                                                     dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                     posicionMenor = i;
                                                                                                                 } else {
                                                                                                                     if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) == 0 ){   
                                                                                                                     //decide 16
                                                                                                                         if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) > 0 ){   
                                                                                                                             dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                             posicionMenor = i;
                                                                                                                         } else {
                                                                                                                             if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) == 0 ){   
                                                                                                                             //decide 17
                                                                                                                                 // incidencia BELC300017884
                                                                                                                                 if (dtoMenor.getCodigoCicloVida().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCicloVida()) > 0) {   
                                                                                                                                     dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                     posicionMenor = i;
                                                                                                                                 }
                                                                                                                         }
                                                                                                                               
                                                                                                                      }
                                                                                                                    }
                                                                                                                 }   
                                                                                                             }
                                                                                                         }
                                                                                                    }
                                                                                          
                                                                                                }
                                                                                           }
                                                                                       }
                                                                               }
                                                                           
                                                                       }
                                                                   }
                                                               }
                                                           }
                                                       }
                                                   }
                                               }
                                           }
                                       }
                                   }
                               }
                           }
                       }
                   }
                }
          }//FOR
          dtoAux=(DTOINTDocumentoContable)listaRegistros.get(j);//guardamos el registro que vamos a quitar de la listaRegistro en la posicion del menor
          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(posicionMenor);//guardamos el registro de la posicion menor
          listaRegistros.set(posicionMenor,dtoAux);//ponemos el auxiliar en la lista de nuevo, en la psicion delmenor.
          listaOrdenada.add(dtoMenor);//añadimos a la nueva lista ordenada el menor
          j++;
    
        }//while 
       listaOrdenada = cambioDeNulos(listaOrdenada,Boolean.FALSE);
       UtilidadesLog.info("MONINTSAPFIBean.ordenar5(): Salida");     
       return listaOrdenada;     
    }


  
   private ArrayList agruparDTOINTCabeceraDetalle (ArrayList listaSinAgrupar) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTCabeceraDetalle(ArrayList listaSinAgrupar): Entrada");
      ArrayList listaAgrupada = new ArrayList();
      DTOINTDocumentoContable dtoNoAgrupado = null;
      DTOINTDocumentoContable dtoAgrupado = null;
      boolean encontrado;
      
      // metemos el primer elemento en la lista agrupada
      if (listaSinAgrupar.size() > 0) {
        listaAgrupada.add((DTOINTDocumentoContable)listaSinAgrupar.get(0));
      }
      
      for (int i=1; i < listaSinAgrupar.size(); i++) {
         
         dtoNoAgrupado = new DTOINTDocumentoContable();
         dtoNoAgrupado = (DTOINTDocumentoContable)listaSinAgrupar.get(i);
         
         encontrado = false;
         
         for (int j=0; j < listaAgrupada.size(); j++) {
            
            dtoAgrupado = new DTOINTDocumentoContable();
            dtoAgrupado = (DTOINTDocumentoContable)listaAgrupada.get(j);

            if (this.compararDTOINTDocumentoContableDetalle(dtoNoAgrupado, dtoAgrupado).booleanValue()) { // se deben agrupar
               dtoAgrupado.setImporte01(dtoAgrupado.getImporte01()!=null?dtoAgrupado.getImporte01():new BigDecimal(0));
               dtoAgrupado.setImporte03(dtoAgrupado.getImporte03()!=null?dtoAgrupado.getImporte03():new BigDecimal(0));
               
               // vbongiov -- Cambio 20090922 -- 28/05/2009
               dtoAgrupado.setImporte04(dtoAgrupado.getImporte04()!=null?dtoAgrupado.getImporte04():new BigDecimal(0));
                
               dtoAgrupado.setImporte05(dtoAgrupado.getImporte05()!=null?dtoAgrupado.getImporte05():new BigDecimal(0));
               dtoAgrupado.setImporte07(dtoAgrupado.getImporte07()!=null?dtoAgrupado.getImporte07():new BigDecimal(0));
               
               dtoNoAgrupado.setImporte01(dtoNoAgrupado.getImporte01()!=null?dtoNoAgrupado.getImporte01():new BigDecimal(0));
               dtoNoAgrupado.setImporte03(dtoNoAgrupado.getImporte03()!=null?dtoNoAgrupado.getImporte03():new BigDecimal(0));
               
               // vbongiov -- Cambio 20090922 -- 28/05/2009
               dtoNoAgrupado.setImporte04(dtoNoAgrupado.getImporte04()!=null?dtoNoAgrupado.getImporte04():new BigDecimal(0));
               
               dtoNoAgrupado.setImporte05(dtoNoAgrupado.getImporte05()!=null?dtoNoAgrupado.getImporte05():new BigDecimal(0));
               dtoNoAgrupado.setImporte07(dtoNoAgrupado.getImporte07()!=null?dtoNoAgrupado.getImporte07():new BigDecimal(0));
               
               dtoAgrupado.setImporte01(dtoAgrupado.getImporte01().add(dtoNoAgrupado.getImporte01()));
               dtoAgrupado.setImporte03(dtoAgrupado.getImporte03().add(dtoNoAgrupado.getImporte03()));
               
               // vbongiov -- Cambio 20090922 -- 28/05/2009
               dtoAgrupado.setImporte04(dtoAgrupado.getImporte04().add(dtoNoAgrupado.getImporte04()));
                 
               dtoAgrupado.setImporte05(dtoAgrupado.getImporte05().add(dtoNoAgrupado.getImporte05()));
               dtoAgrupado.setImporte07(dtoAgrupado.getImporte07().add(dtoNoAgrupado.getImporte07()));
               
                //añadimos el dtoAgrupado modificado a la listaAgrupada
                listaAgrupada.set(j,dtoAgrupado);
               encontrado = true;
               break;
            }
         }
         if (! encontrado) {
            
            listaAgrupada.add(dtoNoAgrupado);
         }
      }     
      
      UtilidadesLog.warn("listaAgrupada 1 cant: " + listaAgrupada.size());
      
      // al finalizar el agrupamiento se modifican tanto importe01 como importe03 
      // a su valor absoluto
      for (int i=0; i < listaAgrupada.size(); i++) {
         dtoAgrupado = (DTOINTDocumentoContable)listaAgrupada.get(i);
         
         dtoAgrupado.setImporte01(dtoAgrupado.getImporte01());
         dtoAgrupado.setImporte03(dtoAgrupado.getImporte03());
         
         // vbongiov -- Cambio 20090922 -- 28/05/2009
         dtoAgrupado.setImporte04(dtoAgrupado.getImporte04());
          
         dtoAgrupado.setImporte05(dtoAgrupado.getImporte05());
         dtoAgrupado.setImporte07(dtoAgrupado.getImporte07());
         //se añade el valor absoluto a la lista
         listaAgrupada.set(i,dtoAgrupado);
      }
      
      UtilidadesLog.warn("listaAgrupada 2 cant: " + listaAgrupada.size());
      
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTCabeceraDetalle(ArrayList listaSinAgrupar): Salida");
      return listaAgrupada;
    }
    
    private Boolean compararDTOINTDocumentoContableDetalle (DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2) throws MareException {
        //Compara   DTOINTDocumentoContable   
        UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Entrada");
      /*codigoPais 
        codigoEmpresa 
        codigoCanal 
        codigoAcceso 
        codigoSubacceso 
        codigoTipoPeriodo 
        codigoPeriodo 
        fecha 
        codigoProducto 
        codigoMarcaProducto 
        codigoNegocio 
        grupoProducto 
        codigoTipoOferta 
        codigoCicloVida */
        if (dto1.getCodigoPais()!=null && dto2.getCodigoPais()!=null){
            if (!dto1.getCodigoPais().equals(dto2.getCodigoPais())){
                UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPais()!=dto2.getCodigoPais()){
            UtilidadesLog.info("****Metodo  getCodigoPais: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoEmpresa()!=null && dto2.getCodigoEmpresa()!=null){
            if (! dto1.getCodigoEmpresa().equals(dto2.getCodigoEmpresa())){
                UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoEmpresa() != dto2.getCodigoEmpresa()){
            UtilidadesLog.info("****Metodo  getCodigoEmpresa: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoCanal()!=null && dto2.getCodigoCanal()!=null){
            if (! dto1.getCodigoCanal().equals(dto2.getCodigoCanal())){
                UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoCanal() != dto2.getCodigoCanal()){
            UtilidadesLog.info("****Metodo  getCodigoCanal: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoAcceso()!=null && dto2.getCodigoAcceso()!=null){
            if (! dto1.getCodigoAcceso().equals(dto2.getCodigoAcceso())){
                UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoAcceso() != dto2.getCodigoAcceso()){
            UtilidadesLog.info("****Metodo  getCodigoAcceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        
        if (dto1.getCodigoSubacceso()!=null && dto2.getCodigoSubacceso()!=null){
            if (! dto1.getCodigoSubacceso().equals(dto2.getCodigoSubacceso())){
                UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoSubacceso() != dto2.getCodigoSubacceso()){
            UtilidadesLog.info("****Metodo  getCodigoSubacceso: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoTipoPeriodo()!=null && dto2.getCodigoTipoPeriodo()!=null){
            if (! dto1.getCodigoTipoPeriodo().equals(dto2.getCodigoTipoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoTipoPeriodo() != dto2.getCodigoTipoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoTipoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoPeriodo()!=null && dto2.getCodigoPeriodo()!=null){
            if (! dto1.getCodigoPeriodo().equals(dto2.getCodigoPeriodo())){
                UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoPeriodo() != dto2.getCodigoPeriodo()){
            UtilidadesLog.info("****Metodo  getCodigoPeriodo: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
                
        if (dto1.getRUC()!=null && dto2.getRUC()!=null){
            if (! dto1.getRUC().equals(dto2.getRUC())){
                UtilidadesLog.info("****Metodo  getRUC: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
            }else if (dto1.getRUC() != dto2.getRUC()){
                UtilidadesLog.info("****Metodo  getRUC: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
  
        if (dto1.getFecha()!=null && dto2.getFecha()!=null){
            if (dto1.getFecha().compareTo(dto2.getFecha()) != 0) {
                UtilidadesLog.info("****Metodo  comparaCabecera: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getFecha() != dto2.getFecha()){
            UtilidadesLog.info("****Metodo  comparaCabecera: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        if (dto1.getCodigoProducto()!=null && dto2.getCodigoProducto()!=null){
            if (! dto1.getCodigoProducto().equals(dto2.getCodigoProducto())){
                UtilidadesLog.info("****Metodo  getCodigoProducto: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoProducto() != dto2.getCodigoProducto()){
            UtilidadesLog.info("****Metodo  getCodigoProducto: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

        if (dto1.getCodigoMarcaProducto()!=null && dto2.getCodigoMarcaProducto()!=null){
            if (! dto1.getCodigoMarcaProducto().equals(dto2.getCodigoMarcaProducto())){
                UtilidadesLog.info("****Metodo  getCodigoMarcaProducto: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoMarcaProducto() != dto2.getCodigoMarcaProducto()){
            UtilidadesLog.info("****Metodo  getCodigoMarcaProducto: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

        if (dto1.getCodigoNegocio()!=null && dto2.getCodigoNegocio()!=null){
            if (! dto1.getCodigoNegocio().equals(dto2.getCodigoNegocio())){
                UtilidadesLog.info("****Metodo  getCodigoNegocio: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoNegocio() != dto2.getCodigoNegocio()){
            UtilidadesLog.info("****Metodo  getCodigoNegocio: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

        if (dto1.getCodigoGrupoProductos()!=null && dto2.getCodigoGrupoProductos()!=null){
            if (! dto1.getCodigoGrupoProductos().equals(dto2.getCodigoGrupoProductos())){
                UtilidadesLog.info("****Metodo  getCodigoGrupoProductos: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoGrupoProductos() != dto2.getCodigoGrupoProductos()){
            UtilidadesLog.info("****Metodo  getCodigoGrupoProductos: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

        if (dto1.getCodigoTipoOferta()!=null && dto2.getCodigoTipoOferta()!=null){
            if (! dto1.getCodigoTipoOferta().equals(dto2.getCodigoTipoOferta())){
                UtilidadesLog.info("****Metodo  getCodigoTipoOferta: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoTipoOferta() != dto2.getCodigoTipoOferta()){
            UtilidadesLog.info("****Metodo  getCodigoTipoOferta: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }
        
        if (dto1.getCodigoCicloVida()!=null && dto2.getCodigoCicloVida()!=null){
            if (! dto1.getCodigoCicloVida().equals(dto2.getCodigoCicloVida())){
                UtilidadesLog.info("****Metodo  getCodigoCicloVida: Salida False");
                UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
                return new Boolean(false);
            }
        }else if (dto1.getCodigoCicloVida() != dto2.getCodigoCicloVida()){
            UtilidadesLog.info("****Metodo  getCodigoCicloVida: Salida False");
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
            return new Boolean(false);
        }

        UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTDocumentoContableDetalle(DTOINTDocumentoContable dto1, DTOINTDocumentoContable dto2): Salida");
        return new Boolean(true);
    }
    
    private String obtenerGlosa (DTOINTDocumentoContable dtoe) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.obtenerGlosa(DTOINTDocumentoContable dtoe): Entrada");
        String tipoAsiento = dtoe.getTipoAsiento().toUpperCase();
        String glosa = "";
      
        if ( tipoAsiento.equals(ConstantesINT.TIPO_ASIENTO_VN)) { 
            glosa = "Venta "; 
        } 
        else if (tipoAsiento.equals( ConstantesINT.TIPO_ASIENTO_TN )) { 
            glosa = "Venta Transportista " ;
        } 
        else if ( tipoAsiento.equals( ConstantesINT.TIPO_ASIENTO_AB )) { 
            glosa = "Nota de crédito ";
        } 
        SimpleDateFormat formato=new SimpleDateFormat("yyyyMMdd");
        String fecha= formato.format(dtoe.getFecha()); 
        
        glosa = glosa.concat(fecha);
        
        //--Se modifica por incidencia 21244 
        //-- Paola Cabrera
        //-- 03/11/2005 ---
        glosa = glosa.concat(" " + dtoe.getCodigoCanal());// se dejo este por la incidencia 21244 01/06/2006
        //glosa = glosa.concat(" " + dtoe.getDescripcionCanal());
        //--FIN Paola Cabrera
        //-- 03/11/2005 ---
        
        
        UtilidadesLog.info("MONINTSAPFIBean.obtenerGlosa(DTOINTDocumentoContable dtoe): Salida");
        return glosa.length()>40?glosa.substring(0,40):glosa;
    }


    /**
    * Obtiene los parametros contables DEBE y HABER para el documento contable.
    * @creado incidencia V-SAP-FI-005
    */
    private ArrayList obtenerParametroContable( DTOINTDocumentoContable dtoDoc, ArrayList listaParametros, String[] listaImportes,
                                                String tipoAsientos, String identificadorCabeceraDetalle) throws MareException  {
        ArrayList parametroDebeHaber;
        ArrayList parametrosHaber;
        /*
         * Obtenemos los parametros contables con indicador DEBE.
         */
        parametroDebeHaber = this.obtenerParametroContableDebe(dtoDoc, listaParametros, listaImportes, tipoAsientos, identificadorCabeceraDetalle);

        /*
         * Obtenemos los parametros contables con indicador HABER.
         */
        parametrosHaber = this.obtenerParametroContableHaber(dtoDoc, listaParametros, listaImportes, tipoAsientos, identificadorCabeceraDetalle);
        parametroDebeHaber.addAll(parametrosHaber);

        //Retornamos los parametros contables con indicador DEBE y HABER.
        return parametroDebeHaber;
    }    

    /**
    * Obtiene los parametros contables DEBE para el documento contable.
    */
    private ArrayList obtenerParametroContableDebe(
                                                DTOINTDocumentoContable dtoDoc,
                                                ArrayList listaParametros,
                                                String[] listaImportes,
                                                String tipoAsientos, 
                                                String identificadorCabeceraDetalle
                                                )      throws MareException  {
        UtilidadesLog.info("MONINTSAPFIBean.obtenerParametroContableDebe(DTOINTDocumentoContable dtoDoc, ArrayList listaParametros, String[] listaImportes, String tipoAsientos, String identificadorCabeceraDetalle): Entrada");
        UtilidadesLog.debug("tipoAsientos: " + tipoAsientos);
        UtilidadesLog.debug("DTOINTDocumentoContable: " + dtoDoc);
        UtilidadesLog.debug("listaParametros: " + listaParametros);
        UtilidadesLog.debug("identificadorCabeceraDetalle: " + identificadorCabeceraDetalle);
        
        ArrayList listaRetorno=new ArrayList();
        DTOINTParametrosContablesFAC dtoTemp = null, dtoAux = null;
        DTOINTDocumentoContable dtoRetorno = null;
        String importe = null;
        String impAux = null;
        String indicador;
        ArrayList listaTemp = new ArrayList();
        
        CuentasContablesLocalHome cucoLocalHome = this.getCuentasContablesLocalHome();
        CuentasContablesLocal cucoLocal = null;
      
        for(int i=0; i < listaImportes.length; i++) {
            importe = listaImportes[i];
            UtilidadesLog.info("importe: " + importe);
            listaTemp = new ArrayList();
            /* 
             * se filtra listaParametros para obtener solo los que tienen
             * atributo codigoImporteAContabilizar = importe y
             * atributo indicadorDebeHaber() = COD_DEBE
             */
            for (int j=0; j < listaParametros.size(); j++){
                 impAux = ((DTOINTParametrosContablesFAC)listaParametros.get(j)).getCodigoImporteAContabilizar();
                 indicador = ((DTOINTParametrosContablesFAC)listaParametros.get(j)).getIndicadorDebeHaber().toUpperCase();
                 UtilidadesLog.info("impAux: " + impAux);
                 if ( impAux!=null && impAux.equals(importe) && indicador.equals(CCCConstantes.COD_DEBE)) {
                    listaTemp.add(listaParametros.get(j));          
                 }
            }
            
            dtoTemp = null;
            UtilidadesLog.info("listaTemp: " + listaTemp);
            
            if ( listaTemp != null && !listaTemp.isEmpty() ){
            
                boolean encontrado = false;
                //HASTA ACA OK//
                if (identificadorCabeceraDetalle.equals(ConstantesINT.INDICADOR_DETALLE)){
                    
                
                   // en 'listaTemp', se busca un objeto que tenga valor en el atributo 'producto', y se guarda en dtoTemp   
                   for (int j=0; j < listaTemp.size(); j++) {
                   
                      dtoTemp = null;
                      dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                      UtilidadesLog.info("dtoAux 1: " + dtoAux);
                      
                      if (dtoDoc.getProducto()!= null && dtoDoc.getProducto().equals(dtoAux.getProducto())) {
                         dtoTemp = new DTOINTParametrosContablesFAC();
                         dtoTemp = dtoAux;
                         UtilidadesLog.info("dtoTemp 1: " + dtoTemp);
                         encontrado = true;
                         break;
                      }
                   }
                   
                   UtilidadesLog.info("encontrado 1: " + encontrado);
                   // si no se encuentra, se busca uno que tenga valor en 'grupoArticulos', y se guarda en dtoTemp
                   if (! encontrado) {
                      for (int j=0; j < listaTemp.size(); j++) {
                      
                         dtoTemp = null;
                         dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                         UtilidadesLog.info("dtoAux 2: " + dtoAux);
                         
                         if (dtoDoc.getCodigoGrupoProductos()!= null &&
                             dtoDoc.getCodigoGrupoProductos().equals(dtoAux.getGrupoArticulos())) {
                            dtoTemp = new DTOINTParametrosContablesFAC();
                            dtoTemp = dtoAux;
                            UtilidadesLog.info("dtoTemp 2: " + dtoTemp);
                            encontrado = true;
                            break;
                         }
                      }
                      
                      UtilidadesLog.info("encontrado 2: " + encontrado);
                
                      // si no se encuentra, se busca uno que tenga valor en 'marcaProducto', y se guarda en dtoTemp
                      if (! encontrado) {
                         for (int j=0; j < listaTemp.size(); j++) {
                         
                            dtoTemp = null;
                            dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                            UtilidadesLog.info("dtoAux 3: " + dtoAux);
                            
                            if (dtoDoc.getMarcaProducto()!= null && 
                                dtoDoc.getMarcaProducto().equals(dtoAux.getMarcaProducto())) {
                               dtoTemp = new DTOINTParametrosContablesFAC();
                               dtoTemp = dtoAux;
                               UtilidadesLog.info("dtoTemp 3: " + dtoTemp);
                               encontrado = true;
                               break;
                            }
                         }
                
                         UtilidadesLog.info("encontrado 3: " + encontrado);
                         // si no se encuentra, se busca uno que tenga valor en 'negocio', y se guarda en dtoTemp
                         if (! encontrado) {
                            for (int j=0; j < listaTemp.size(); j++) {
                            
                               dtoTemp = null;
                               dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                               UtilidadesLog.info("dtoAux 4: " + dtoAux);
                               
                               if (dtoDoc.getNegocio()!= null &&
                                   dtoDoc.getNegocio().equals(dtoAux.getNegocio())) {
                                  dtoTemp = new DTOINTParametrosContablesFAC();
                                  dtoTemp = dtoAux;
                                  UtilidadesLog.info("dtoTemp 4: " + dtoTemp);
                                  encontrado = true;
                                  break;
                               }
                            }
                         }
                         
                         UtilidadesLog.info("encontrado 4: " + encontrado);
                         
                         // si no se encuentra, se toma un objeto de 'listaTemp' con 'producto', 'grupoArticulos', 'marcaProducto' y 'negocio' vacíos, y se guarda en dtoTemp
                         if (! encontrado) {
                            for (int j=0; j < listaTemp.size(); j++) {
                            
                               dtoTemp = null;
                               dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                               UtilidadesLog.info("dtoAux 5: " + dtoAux);
                               
                               if (dtoAux.getProducto()==null && dtoAux.getGrupoArticulos()==null && dtoAux.getMarcaProducto()== null && dtoAux.getNegocio() == null) {
                                  dtoTemp = new DTOINTParametrosContablesFAC();
                                  dtoTemp = dtoAux;
                                  UtilidadesLog.info("dtoTemp 5: " + dtoTemp);
                                  encontrado = true;
                                  break;
                               }
                            }
                         }
                      }
                   }
                }//fin identificadorCabeceraDetalle==ConstantesINT.INDICADOR_DETALLE
                
                if (identificadorCabeceraDetalle.equals(ConstantesINT.INDICADOR_CABECERA)) 
                {
                   for (int j=0; j < listaTemp.size(); j++) {
                      dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                      if(dtoAux.getCodigoImporteAContabilizar()!=null&&
                          dtoAux.getCodigoImporteAContabilizar().equals(importe)){
                          dtoTemp = dtoAux;
                      }
                   }
                }
            }
            
            UtilidadesLog.info("dtoTemp ultimo: " + dtoTemp);
            
            //  Si( dtoTemp != null ) // se ha encontrado objeto de parámetros contables
            if (dtoTemp != null) {
              
              UtilidadesLog.info("i: " + i);
                 // dtoRetorno = new DTOINTDocumentoContable( dtoDoc ) 
                 // es decir, se crea un nuevo objeto con los mismos valores que el recibido como parámetro
                 dtoRetorno = new DTOINTDocumentoContable(dtoDoc);
                 dtoRetorno.setTipoAsiento(tipoAsientos);
                 dtoRetorno.setIndicadorDebeHaber(dtoTemp.getIndicadorDebeHaber());
                 dtoRetorno.setCodigoImporteAContabilizar(dtoTemp.getCodigoImporteAContabilizar());
                 dtoRetorno.setCodigoApunte(dtoTemp.getCodigoApunte() != null ? dtoTemp.getOid() : new Long(0));
                 dtoRetorno.setImporteAContabilizar(dtoTemp.getImporteAContabilizar());
                
                 if(dtoRetorno.getIndicadorDebeHaber().toUpperCase().equals(CCCConstantes.COD_HABER)){
                      dtoRetorno.setImporte(this.obtenerImporte(dtoRetorno).negate());   
                 } else {
                      dtoRetorno.setImporte(this.obtenerImporte(dtoRetorno));
                 }
                 
                 // dtoRetorno.tipoMovimientoSAPFI = ( se accede a la entidad CuentasContables por PK, usando dtoTemp.cuentaContable, y se obtiene el atributo 'codigo' )
                 try {
                    cucoLocal = cucoLocalHome.findByPrimaryKey(dtoTemp.getCuentaContable());
                    dtoRetorno.setTipoMovimientoSAPFI(cucoLocal.getCodigo());
                    dtoRetorno.setCuentaContable(cucoLocal.getOid());
                    
                 } catch (NoResultException fe) {
                    dtoRetorno.setTipoMovimientoSAPFI("");
                    dtoRetorno.setCuentaContable(dtoTemp.getCuentaContable());
                 }  catch (PersistenceException ce) {   
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                 }
                 if( dtoTemp.getCodigoImporteAContabilizar()!=null && 
                      dtoTemp.getCodigoImporteAContabilizar().equals(importe)){
                      listaRetorno.add(dtoRetorno);
                  }
                 UtilidadesLog.info("dtoRetorno: " + dtoRetorno);
            }else{//  Si no // No se ha encontrado objeto de parámetros contables {
                UtilidadesLog.info("i: " + i);
                // Si( i == 0 ) // se está tratando el primer importe (Detalle:01, cabecera:50) {
                UtilidadesLog.info("no generar dtoDoc: " + dtoDoc);
            }
        } // Fin bucle for
        
        UtilidadesLog.info("listaRetornO: " + listaRetorno);
        UtilidadesLog.info("MONINTSAPFIBean.obtenerParametroContableDebe(DTOINTDocumentoContable dtoDoc, ArrayList listaParametros, String[] listaImportes, String tipoAsientos, String identificadorCabeceraDetalle): Salida");
        return listaRetorno;
   }


    /**
    * Obtiene los parametros contables HABER para el documento contable.
    */
    private ArrayList obtenerParametroContableHaber(
                                                DTOINTDocumentoContable dtoDoc,
                                                ArrayList listaParametros,
                                                String[] listaImportes,
                                                String tipoAsientos, 
                                                String identificadorCabeceraDetalle
                                                )      throws MareException  {
        UtilidadesLog.info("MONINTSAPFIBean.obtenerParametroContableHaber(DTOINTDocumentoContable dtoDoc, ArrayList listaParametros, String[] listaImportes, String tipoAsientos, String identificadorCabeceraDetalle): Entrada");
        UtilidadesLog.debug("tipoAsientos: " + tipoAsientos);
        UtilidadesLog.debug("DTOINTDocumentoContable: " + dtoDoc);
        UtilidadesLog.debug("listaParametros: " + listaParametros);
        UtilidadesLog.debug("identificadorCabeceraDetalle: " + identificadorCabeceraDetalle);
        
        ArrayList listaRetorno=new ArrayList();
        DTOINTParametrosContablesFAC dtoTemp = null, dtoAux = null;
        DTOINTDocumentoContable dtoRetorno = null;
        String importe = null;
        String impAux = null;
        String indicador;
        ArrayList listaTemp = new ArrayList();
        
        CuentasContablesLocalHome cucoLocalHome = this.getCuentasContablesLocalHome();
        CuentasContablesLocal cucoLocal = null;
      
        for(int i=0; i < listaImportes.length; i++) {
            importe = listaImportes[i];
            UtilidadesLog.info("importe: " + importe);
            listaTemp = new ArrayList();
            /* 
             * se filtra listaParametros para obtener solo los que tienen
             * atributo codigoImporteAContabilizar = importe y
             * atributo indicadorDebeHaber() = COD_HABER
             */
            for (int j=0; j < listaParametros.size(); j++){
                 impAux = ((DTOINTParametrosContablesFAC)listaParametros.get(j)).getCodigoImporteAContabilizar();
                 indicador = ((DTOINTParametrosContablesFAC)listaParametros.get(j)).getIndicadorDebeHaber().toUpperCase();
                 UtilidadesLog.info("impAux: " + impAux);
                 if ( impAux!=null && impAux.equals(importe) && indicador.equals(CCCConstantes.COD_HABER)) {
                    listaTemp.add(listaParametros.get(j));          
                 }
            }
            
            dtoTemp = null;
            UtilidadesLog.info("listaTemp: " + listaTemp);
            
            if ( listaTemp != null && !listaTemp.isEmpty() ){
            
                boolean encontrado = false;
                //HASTA ACA OK//
                if (identificadorCabeceraDetalle.equals(ConstantesINT.INDICADOR_DETALLE)){
                    
                
                   // en 'listaTemp', se busca un objeto que tenga valor en el atributo 'producto', y se guarda en dtoTemp   
                   for (int j=0; j < listaTemp.size(); j++) {
                   
                      dtoTemp = null;
                      dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                      UtilidadesLog.info("dtoAux 1: " + dtoAux);
                      
                      if (dtoDoc.getProducto()!= null && dtoDoc.getProducto().equals(dtoAux.getProducto())) {
                         dtoTemp = new DTOINTParametrosContablesFAC();
                         dtoTemp = dtoAux;
                         UtilidadesLog.info("dtoTemp 1: " + dtoTemp);
                         encontrado = true;
                         break;
                      }
                   }
                   
                   UtilidadesLog.info("encontrado 1: " + encontrado);
                   // si no se encuentra, se busca uno que tenga valor en 'grupoArticulos', y se guarda en dtoTemp
                   if (! encontrado) {
                      for (int j=0; j < listaTemp.size(); j++) {
                      
                         dtoTemp = null;
                         dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                         UtilidadesLog.info("dtoAux 2: " + dtoAux);
                         
                         if (dtoDoc.getCodigoGrupoProductos()!= null &&
                             dtoDoc.getCodigoGrupoProductos().equals(dtoAux.getGrupoArticulos())) {
                            dtoTemp = new DTOINTParametrosContablesFAC();
                            dtoTemp = dtoAux;
                            UtilidadesLog.info("dtoTemp 2: " + dtoTemp);
                            encontrado = true;
                            break;
                         }
                      }
                      
                      UtilidadesLog.info("encontrado 2: " + encontrado);
                
                      // si no se encuentra, se busca uno que tenga valor en 'marcaProducto', y se guarda en dtoTemp
                      if (! encontrado) {
                         for (int j=0; j < listaTemp.size(); j++) {
                         
                            dtoTemp = null;
                            dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                            UtilidadesLog.info("dtoAux 3: " + dtoAux);
                            
                            if (dtoDoc.getMarcaProducto()!= null && 
                                dtoDoc.getMarcaProducto().equals(dtoAux.getMarcaProducto())) {
                               dtoTemp = new DTOINTParametrosContablesFAC();
                               dtoTemp = dtoAux;
                               UtilidadesLog.info("dtoTemp 3: " + dtoTemp);
                               encontrado = true;
                               break;
                            }
                         }
                
                         UtilidadesLog.info("encontrado 3: " + encontrado);
                         // si no se encuentra, se busca uno que tenga valor en 'negocio', y se guarda en dtoTemp
                         if (! encontrado) {
                            for (int j=0; j < listaTemp.size(); j++) {
                            
                               dtoTemp = null;
                               dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                               UtilidadesLog.info("dtoAux 4: " + dtoAux);
                               
                               if (dtoDoc.getNegocio()!= null &&
                                   dtoDoc.getNegocio().equals(dtoAux.getNegocio())) {
                                  dtoTemp = new DTOINTParametrosContablesFAC();
                                  dtoTemp = dtoAux;
                                  UtilidadesLog.info("dtoTemp 4: " + dtoTemp);
                                  encontrado = true;
                                  break;
                               }
                            }
                         }
                         
                         UtilidadesLog.info("encontrado 4: " + encontrado);
                         
                         // si no se encuentra, se toma un objeto de 'listaTemp' con 'producto', 'grupoArticulos', 'marcaProducto' y 'negocio' vacíos, y se guarda en dtoTemp
                         if (! encontrado) {
                            for (int j=0; j < listaTemp.size(); j++) {
                            
                               dtoTemp = null;
                               dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                               UtilidadesLog.info("dtoAux 5: " + dtoAux);
                               
                               if (dtoAux.getProducto()==null && dtoAux.getGrupoArticulos()==null && dtoAux.getMarcaProducto()== null && dtoAux.getNegocio() == null) {
                                  dtoTemp = new DTOINTParametrosContablesFAC();
                                  dtoTemp = dtoAux;
                                  UtilidadesLog.info("dtoTemp 5: " + dtoTemp);
                                  encontrado = true;
                                  break;
                               }
                            }
                         }
                      }
                   }
                }//fin identificadorCabeceraDetalle==ConstantesINT.INDICADOR_DETALLE
                
                if (identificadorCabeceraDetalle.equals(ConstantesINT.INDICADOR_CABECERA)) 
                {
                   for (int j=0; j < listaTemp.size(); j++) {
                      dtoAux = (DTOINTParametrosContablesFAC)listaTemp.get(j);
                      if(dtoAux.getCodigoImporteAContabilizar()!=null&&
                          dtoAux.getCodigoImporteAContabilizar().equals(importe)){
                          dtoTemp = dtoAux;
                      }
                   }
                }
            }
            
            UtilidadesLog.info("dtoTemp ultimo: " + dtoTemp);
            
            //  Si( dtoTemp != null ) // se ha encontrado objeto de parámetros contables
            if (dtoTemp != null) {
              
              UtilidadesLog.info("i: " + i);
                 // dtoRetorno = new DTOINTDocumentoContable( dtoDoc ) 
                 // es decir, se crea un nuevo objeto con los mismos valores que el recibido como parámetro
                 dtoRetorno = new DTOINTDocumentoContable(dtoDoc);
                 dtoRetorno.setTipoAsiento(tipoAsientos);
                 dtoRetorno.setIndicadorDebeHaber(dtoTemp.getIndicadorDebeHaber());
                 dtoRetorno.setCodigoImporteAContabilizar(dtoTemp.getCodigoImporteAContabilizar());
                 dtoRetorno.setCodigoApunte(dtoTemp.getCodigoApunte() != null ? dtoTemp.getOid() : new Long(0));
                 dtoRetorno.setImporteAContabilizar(dtoTemp.getImporteAContabilizar());
                
                 if(dtoRetorno.getIndicadorDebeHaber().toUpperCase().equals(CCCConstantes.COD_HABER)){
                      dtoRetorno.setImporte(this.obtenerImporte(dtoRetorno).negate());   
                 } else {
                      dtoRetorno.setImporte(this.obtenerImporte(dtoRetorno));
                 }
                 
                 // dtoRetorno.tipoMovimientoSAPFI = ( se accede a la entidad CuentasContables por PK, usando dtoTemp.cuentaContable, y se obtiene el atributo 'codigo' )
                 try {
                    cucoLocal = cucoLocalHome.findByPrimaryKey(dtoTemp.getCuentaContable());
                    dtoRetorno.setTipoMovimientoSAPFI(cucoLocal.getCodigo());
                    dtoRetorno.setCuentaContable(cucoLocal.getOid());
                    
                 } catch (NoResultException fe) {
                    dtoRetorno.setTipoMovimientoSAPFI("");
                    dtoRetorno.setCuentaContable(dtoTemp.getCuentaContable());
                 }  catch (PersistenceException ce) {   
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                 }
                 if( dtoTemp.getCodigoImporteAContabilizar()!=null && 
                      dtoTemp.getCodigoImporteAContabilizar().equals(importe)){
                      listaRetorno.add(dtoRetorno);
                  }
                 UtilidadesLog.info("dtoRetorno: " + dtoRetorno);
            }else{//  Si no // No se ha encontrado objeto de parámetros contables {
                UtilidadesLog.info("i: " + i);
                // Si( i == 0 ) // se está tratando el primer importe (Detalle:01, cabecera:50) {
                UtilidadesLog.info("no generar dtoDoc: " + dtoDoc);
            }
        } // Fin bucle for
        
        UtilidadesLog.info("listaRetornO: " + listaRetorno);
        UtilidadesLog.info("MONINTSAPFIBean.obtenerParametroContableHaber(DTOINTDocumentoContable dtoDoc, ArrayList listaParametros, String[] listaImportes, String tipoAsientos, String identificadorCabeceraDetalle): Salida");
        return listaRetorno;
   }


    private BigDecimal obtenerImporte (DTOINTDocumentoContable dtoe) throws MareException {
    //Cambiado por BELC300013438 
    UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Entrada");
    
        String codigo = dtoe.getCodigoImporteAContabilizar().toUpperCase();
        if (codigo.equals(ConstantesINT.IMPORTE_01)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
            dtoe.setImporte01(dtoe.getImporte01()!=null?dtoe.getImporte01():new BigDecimal(0));
             return dtoe.getImporte01();
        } else if (codigo.equals(ConstantesINT.IMPORTE_03)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
            dtoe.setImporte03(dtoe.getImporte03()!=null?dtoe.getImporte03():new BigDecimal(0));
            return dtoe.getImporte03(); 
            // vbongiov -- Cambio 20090922 -- 28/05/2009
        } else if (codigo.equals(ConstantesINT.IMPORTE_04)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
            dtoe.setImporte04(dtoe.getImporte04()!=null?dtoe.getImporte04():new BigDecimal(0));
            return dtoe.getImporte04();
        } else if (codigo.equals(ConstantesINT.IMPORTE_05)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
            dtoe.setImporte05(dtoe.getImporte05()!=null?dtoe.getImporte05():new BigDecimal(0));
            return dtoe.getImporte05(); 
        } else if (codigo.equals(ConstantesINT.IMPORTE_07)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
            dtoe.setImporte07(dtoe.getImporte07()!=null?dtoe.getImporte07():new BigDecimal(0));
            return dtoe.getImporte07(); 
        } else if (codigo.equals(ConstantesINT.IMPORTE_50)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
            dtoe.setImporte50(dtoe.getImporte50()!=null?dtoe.getImporte50():new BigDecimal(0));
            return dtoe.getImporte50();
        } else if (codigo.equals(ConstantesINT.IMPORTE_55)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
             dtoe.setImporte55(dtoe.getImporte55()!=null?dtoe.getImporte55():new BigDecimal(0));
             return dtoe.getImporte55();
        } else if (codigo.equals(ConstantesINT.IMPORTE_60)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
            dtoe.setImporte60(dtoe.getImporte60()!=null?dtoe.getImporte60():new BigDecimal(0));
            return dtoe.getImporte60(); 
        } else if (codigo.equals(ConstantesINT.IMPORTE_70)){
             UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
             dtoe.setImporte70(dtoe.getImporte70()!=null?dtoe.getImporte70():new BigDecimal(0));
             return dtoe.getImporte70();
        } else if (codigo.equals(ConstantesINT.IMPORTE_80)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
             dtoe.setImporte80(dtoe.getImporte80()!=null?dtoe.getImporte80():new BigDecimal(0));
             return dtoe.getImporte80(); 
        } else if (codigo.equals(ConstantesINT.IMPORTE_84)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
             dtoe.setImporte84(dtoe.getImporte84()!=null?dtoe.getImporte84():new BigDecimal(0));
             return dtoe.getImporte84();
        } else if (codigo.equals(ConstantesINT.IMPORTE_88)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
             dtoe.setImporte88(dtoe.getImporte88()!=null?dtoe.getImporte88():new BigDecimal(0));
             return dtoe.getImporte88();
        //cambio SAPFI-001  (SCS-07/05/08)     
        } else if (codigo.equals(ConstantesINT.IMPORTE_90)){
            UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
             dtoe.setImporte90(dtoe.getImporte90()!=null?dtoe.getImporte90():new BigDecimal(0));
             return dtoe.getImporte90();
        }else {   
        UtilidadesLog.info("El importe a contabilizar NO existe ");
        UtilidadesLog.info("MONINTSAPFIBean.obtenerImporte(DTOINTDocumentoContable dtoe): Salida");
        return null;
        }
    }


    /**
    * Proceso de Contabilizacion de los Documento de Detalle y de Cabecera.
    */
    private  ArrayList procesarDocumentos (String tipoAsientos, ArrayList listaDocumentos, Long oidZona) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.procesarDocumentos(String tipoAsientos, ArrayList listaDocumentos): Entrada");
        UtilidadesLog.warn("tipoAsientos: " + tipoAsientos);
        ArrayList listaSalida = new ArrayList(); 
        DTOINTDocumentoContable dto;
        DTOINTDocumentoContable dtoDocCont;
        DTOINTParametrosContablesFAC dtoFAC;
        ArrayList parametrosContables;
        ArrayList listaTemp;
        ArrayList registrosNuevos = new ArrayList();
        DAOINT daoInt = new DAOINT();
        ArrayList resultado;
        DatosSAPFILocalHome datosSAPFILocalHome = this.getDatosSAPFILocalHome();
        DatosSAPFILocal datosSAPFILocal;
        String anyo;
        String mes;

        /**
         * 1.- PRIMERA AGRUPACIÓN DE LOS REGISTROS DE DETALLE con true
         */
        ArrayList listaAgrupados = this.agruparCabeceraDetalle(listaDocumentos, Boolean.TRUE, tipoAsientos);
        parametrosContables = daoInt.obtenerParametrosFAC(this.getPais(),ConstantesINT.INDICADOR_DETALLE, tipoAsientos );
        //Completar datos de contabilizacion
        // vbongiov -- Cambio 20090922 -- 28/05/2009
        String[] importes = {ConstantesINT.IMPORTE_01,ConstantesINT.IMPORTE_03, ConstantesINT.IMPORTE_04, ConstantesINT.IMPORTE_05, ConstantesINT.IMPORTE_07};
        for (int k=0; k<listaAgrupados.size();k++){
            dto = (DTOINTDocumentoContable)listaAgrupados.get(k);
            resultado = this.obtenerParametroContable(dto, parametrosContables,importes,tipoAsientos,ConstantesINT.INDICADOR_DETALLE);
            registrosNuevos.addAll(resultado);
        }
        listaAgrupados = registrosNuevos;            

        UtilidadesLog.warn("1.-listaAgrupados: " + listaAgrupados.size());
        
        /**
         * 2.- SEGUNDA AGRUPACIÓN DE LOS REGISTROS DE DETALLE con false
         */
        listaAgrupados = this.agruparCabeceraDetalle(listaAgrupados, Boolean.FALSE, tipoAsientos);
        // Insercion de registros en la entidad INT_DATOS_SAP_FI   
        listaAgrupados = this.ordenar(listaAgrupados);
        UtilidadesLog.warn("2.-listaAgrupados:" + listaAgrupados.size());
        for (int k=0;k<listaAgrupados.size();k++) {
            dto = (DTOINTDocumentoContable)listaAgrupados.get(k);      
            if ( dto.getImporte() != null && dto.getImporte().doubleValue() != 0) {
                try {
                    anyo = UtilidadesFecha.convertirAString(dto.getFecha(), "yyyy");		
                    mes = UtilidadesFecha.convertirAString(dto.getFecha(), "MM");
                } catch (ParseException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
                }
                if (dto.getCuentaContable()!=null && !dto.getCuentaContable().equals(new Long(0))) {
                    try {   
                        datosSAPFILocal = datosSAPFILocalHome.create( 
                                               ConstantesINT.INDICADOR_FACTURA, //String indicadorFacturaCCC, 
                                               this.numeroLote, //String numeroLote, 
                                               dto.getFecha(),
                                               dto.getTipoAsiento(),//String tipoAsiento, 
                                               dto.getCuentaContable(), // incidencia 18477 - Long tipoMovimientoSAPFI, 
                                               this.obtenerGlosa(dto), //String glosa, 
                                               dto.getIndicadorDebeHaber(),//String indicadorDebeHaber, 
                                               dto.getImporte(),//BigDecimal importe, 
                                               mes,//String periodoContable, //periodoContable = ( el mes del atributo 'fecha', con dos dígitos, rellenando con cero a la izquierda si es necesario ) 
                                               new Short(anyo),//Short ejercicioContable, //ejercicioContable = ( el año del atributo 'fecha', con cuatro dígitos, rellenando con cero a la izquierda si es necesario ) 
                                               dto.getSubacceso(),//Long subacceso, 
                                               this.moneda, //Long moneda, 
                                               dto.getEmpresa()  );            
                        datosSAPFILocal.setPeriodoComercial(dto.getPeriodo()); //periodoCorporativo
                        datosSAPFILocal.setEjercicioComercial(new Short(dto.getEjercicioComercial()));
                        datosSAPFILocal.setFechaDocumento(dto.getFecha());
                        datosSAPFILocal.setFechaPagoBanco(null);
                        datosSAPFILocal.setFechaValorBanco(dto.getFecha());                    
                        datosSAPFILocal.setCicloVida(dto.getCicloVida());
                        datosSAPFILocal.setCodigoApunte(dto.getCodigoApunte());
                        datosSAPFILocal.setImporteAContabilizar(dto.getImporteAContabilizar());
                        datosSAPFILocal.setMarcaProducto(dto.getMarcaProducto());
                        datosSAPFILocal.setTipoOferta(dto.getTipoOferta());
                        datosSAPFILocal.setNegocio(dto.getNegocio());
                        datosSAPFILocal.setNumeroDocumentoRUC(dto.getRUC());
                        datosSAPFILocal.setGrupoArticulos(dto.getCodigoGrupoProductos());
                        datosSAPFILocal.setZona(oidZona);
                        datosSAPFILocalHome.merge(datosSAPFILocal);
                    }catch(PersistenceException ex){
                        UtilidadesLog.error(ex);
                        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                    // agregamos al listado que luego va a la interface
                    listaSalida.add(dto);
                }
            }
        } 
        
        /**
         * 3.- PRIMERA AGRUPACIÓN DE LOS REGISTROS DE CABECERA con true
         */
        registrosNuevos = new ArrayList();
        listaAgrupados = new ArrayList();
        parametrosContables = new ArrayList();
        listaTemp = new ArrayList();
        //agregado por importes de cabeceras repetidas
        listaDocumentos = this.eliminarCabecerasIguales(listaDocumentos);
        listaAgrupados = this.agruparCabecera(listaDocumentos, Boolean.TRUE, tipoAsientos);      
        UtilidadesLog.warn("3.-listaAgrupados: " + listaAgrupados.size());
        parametrosContables = daoInt.obtenerParametrosFAC(this.getPais(),ConstantesINT.INDICADOR_CABECERA, tipoAsientos );

        String[] importes1 = {ConstantesINT.IMPORTE_50,ConstantesINT.IMPORTE_55,ConstantesINT.IMPORTE_60,
        ConstantesINT.IMPORTE_70,ConstantesINT.IMPORTE_80,ConstantesINT.IMPORTE_84,ConstantesINT.IMPORTE_88,
        ConstantesINT.IMPORTE_90};       

        for (int k=0; k<listaAgrupados.size();k++) {    
            dto = (DTOINTDocumentoContable)listaAgrupados.get(k);
            resultado = this.obtenerParametroContable(dto, parametrosContables,importes1,tipoAsientos,ConstantesINT.INDICADOR_CABECERA);
            registrosNuevos.addAll(resultado);
        }   
        listaAgrupados = registrosNuevos;
        UtilidadesLog.warn("listaAgrupados despues de importes1: " + listaAgrupados.size());

        /**
         * 4.- SEGUNDA AGRUPACIÓN DE LOS REGISTROS DE CABECERA con false
         */
        listaAgrupados = this.agruparCabecera(listaAgrupados, Boolean.FALSE, tipoAsientos);
        UtilidadesLog.warn("listaAgrupados segunda cabecera: " + listaAgrupados.size());
        ArrayList listaOrdenadosAgrupados = this.ordenar2(listaAgrupados, tipoAsientos);
        UtilidadesLog.warn("listaOrdenadosAgrupados: " + listaOrdenadosAgrupados.size());
        // Insercion de registros en la entidad INT_DATOS_SAP_FI 
        for (int k=0;k<listaOrdenadosAgrupados.size();k++){
            ((DTOINTDocumentoContable)listaOrdenadosAgrupados.get(k)).setCodigoCicloVida(null);//dblg4000852
            ((DTOINTDocumentoContable)listaOrdenadosAgrupados.get(k)).setCodigoNegocio(null);//dblg4000852
            ((DTOINTDocumentoContable)listaOrdenadosAgrupados.get(k)).setMarcaProducto(null);//dblg4000852
            ((DTOINTDocumentoContable)listaOrdenadosAgrupados.get(k)).setCodigoMarcaProducto(null);//dblg4000852
            ((DTOINTDocumentoContable)listaOrdenadosAgrupados.get(k)).setCodigoTipoOferta(null);//dblg4000852
            ((DTOINTDocumentoContable)listaOrdenadosAgrupados.get(k)).setCodigoGrupoProductos(null);//dblg4000852
            
            dto = (DTOINTDocumentoContable)listaOrdenadosAgrupados.get(k); 
            
            if (dto.getImporte() != null && dto.getImporte().doubleValue() != 0) {
                try {
                    anyo = UtilidadesFecha.convertirAString(dto.getFecha(), "yyyy");		
                    mes = UtilidadesFecha.convertirAString(dto.getFecha(), "MM");
                } catch (ParseException e){
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
                }
                if (dto.getCuentaContable()!=null && !dto.getCuentaContable().equals(new Long(0))) {               
                    try{
                        datosSAPFILocal = datosSAPFILocalHome.create(
                                           ConstantesINT.INDICADOR_FACTURA, //String indicadorFacturaCCC, 
                                           this.numeroLote, //String numeroLote, 
                                           dto.getFecha(),
                                           dto.getTipoAsiento(),//String tipoAsiento, 
                                           dto.getCuentaContable(), // incidencia 18477
                                           this.obtenerGlosa(dto), //String glosa, 
                                           dto.getIndicadorDebeHaber(),//String indicadorDebeHaber, 
                                           dto.getImporte(),//BigDecimal importe, 
                                           mes,//String periodoContable, //periodoContable = ( el mes del atributo 'fecha', con dos dígitos, rellenando con cero a la izquierda si es necesario ) 
                                           new Short(anyo),//Short ejercicioContable, //ejercicioContable = ( el año del atributo 'fecha', con cuatro dígitos, rellenando con cero a la izquierda si es necesario ) 
                                           dto.getSubacceso(),//Long subacceso, 
                                           this.moneda, //Long moneda, 
                                           dto.getEmpresa()//Long sociedad
                        );
                        datosSAPFILocal.setPeriodoComercial(dto.getPeriodo()); //periodoCorporativo
                        datosSAPFILocal.setEjercicioComercial(new Short(dto.getEjercicioComercial()));
                        datosSAPFILocal.setFechaDocumento(dto.getFecha());
                        datosSAPFILocal.setFechaPagoBanco(null);
                        datosSAPFILocal.setFechaValorBanco(dto.getFecha());
                        datosSAPFILocal.setCicloVida(null);
                        datosSAPFILocal.setCodigoApunte(dto.getCodigoApunte());
                        datosSAPFILocal.setImporteAContabilizar(dto.getImporteAContabilizar());
                        datosSAPFILocal.setMarcaProducto(null);
                        datosSAPFILocal.setTipoOferta(null);
                        datosSAPFILocal.setNumeroDocumentoRUC(dto.getRUC());
                        datosSAPFILocal.setNegocio(null);
                        datosSAPFILocal.setGrupoArticulos(null);
                        datosSAPFILocal.setZona(oidZona);
                        datosSAPFILocalHome.merge(datosSAPFILocal);
                    }catch(PersistenceException ex){
                        UtilidadesLog.error(ex);
                        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }   
                    // agregamos al listado que luego va a la interface
                    listaSalida.add(dto);
                }
            }       
        } 
        UtilidadesLog.warn("listaSalida cant: " + listaSalida.size());
        UtilidadesLog.info("MONINTSAPFIBean.procesarDocumentos(String tipoAsientos, ArrayList listaDocumentos): Salida");
        return listaSalida;
    }
     
     
     /*
     * 
     * BELC300013913. RUC solo se utiliza para ordenar si el tipoAsiento es de transporte con transportista.
     */
     private ArrayList ordenar(ArrayList listaRegistros) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.ordenar(ArrayList listaRegistros, String tipoAsientos): Entrada");
        UtilidadesLog.warn("ordenar() listaRegistros.size "+ listaRegistros.size());
        listaRegistros = cambioDeNulos(listaRegistros,Boolean.TRUE);
        int i;
        int j;
        int n=listaRegistros.size();
        int posicionMenor;
        DTOINTDocumentoContable  dtoMenor=null;        
        DTOINTDocumentoContable  dtoAux=null;        
      
        ArrayList listaOrdenada = new ArrayList();
	      j = 0;
      
        while (j < n) {
            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(j);  
            posicionMenor = j;
          
          for (i = j+1; i < n; i++) {
                
                if (dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) > 0 ){
                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                    posicionMenor = i;
                }else{ //si no es mmayor puede ser igual
                        if(dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) == 0 ){
                        //Si es iguakl decide el segundo parametro 
                                if (dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) > 0 ){
                                          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                          posicionMenor = i;
                                }else{
                                     if(dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) == 0 ){
                                                //Si es igual decide el tercer parametro 
                                               if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) > 0 ){   
                                                      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                      posicionMenor = i;
                                              }else{   
                                                    if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) == 0 ){   
                                                    //si es igual decide el 4 parametro
                                                         if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) > 0 ){   
                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                            posicionMenor = i;
                                                        }else{
                                                            if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) == 0 ){   
                                                            //decide el 5
                                                                if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) > 0 ){   
                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                    posicionMenor = i;
                                                                }else { 
                                                                    if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) == 0 ){   
                                                                        //decide el 6
                                                                        if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) > 0 ){   
                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                            posicionMenor = i;
                                                                        }else {
                                                                            if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) == 0 ){   
                                                                            //decide 7
                                                                                if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) > 0 ){   
                                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                    posicionMenor = i;
                                                                                }else {
                                                                                    if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) == 0 ){   
                                                                                    //decide el 8
                                                                                        if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) > 0 ){   
                                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                            posicionMenor = i;
                                                                                        }else {
                                                                                            if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) == 0 ){   
                                                                                            //decide el 9
                                                                                                if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) > 0 ){   
                                                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                    posicionMenor = i;
                                                                                                }else {
                                                                                                    if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) == 0 ){   
                                                                                                    //decide el 10
                                                                                                    
                                                                                                        // incidencia BELC300017884
                                                                                                        UtilidadesLog.debug(dtoMenor.getTipoMovimientoSAPFI()+" y1 "+((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI());
                                                                                                        UtilidadesLog.debug("dio: "+ dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()));
                                                                                                        if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) > 0  ){   
                                                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                            posicionMenor = i;
                                                                                                            
                                                                                                         }else {
                                                                                                            // incidencia BELC300017884
                                                                                                            if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) == 0 ){   
                                                                                                            //decide 11
                                                                                                                if (dtoMenor.getTipoAsiento().toUpperCase().equals(ConstantesINT.TIPO_ASIENTO_TN)) {
                                                                                                                      if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) > 0 ){   
                                                                                                                          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                          posicionMenor = i;
                                                                                                                      }else {
                                                                                                                          if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) == 0 ){   
                                                                                                                          //decide el 12
                                                                                                                          if (dtoMenor.getIndicadorDebeHaber().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getIndicadorDebeHaber()) > 0 ){   
                                                                                                                              dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                              posicionMenor = i;
                                                                                                                          }else {
                                                                                                                              if (dtoMenor.getIndicadorDebeHaber().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getIndicadorDebeHaber()) == 0 ){   
                                                                                                                              //decide el 13
                                                                                                                                  if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) > 0 ){   
                                                                                                                                      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                      posicionMenor = i;
                                                                                                                                  } else {
                                                                                                                                      if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) == 0 ){   
                                                                                                                                      //decide el 14
                                                                                                                                          if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) > 0 ){   
                                                                                                                                              dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                              posicionMenor = i;
                                                                                                                                          }else {
                                                                                                                                              if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) == 0 ){       
                                                                                                                                              //decide 15
                                                                                                                                                  if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) > 0 ){   
                                                                                                                                                      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                      posicionMenor = i;
                                                                                                                                                  }else {
                                                                                                                                                      if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) == 0 ){   
                                                                                                                                                  //decide 16
                                                                                                                                                          if (dtoMenor.getTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoOferta()) > 0 ){   
                                                                                                                                                              dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                              posicionMenor = i;
                                                                                                                                                          }else{
                                                                                                                                                              if (dtoMenor.getTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoOferta()) == 0 ){   
                                                                                                                                                              //decide el 17
                                                                                                                                                                  if (dtoMenor.getCodigoCicloVida().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCicloVida()) > 0 ){   
                                                                                                                                                                      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                                      posicionMenor = i;
                                                                                                                                                                  }
                                                                                                                                                              }
                                                                                                                                                          }
                                                                                                                                                      }
                                                                                                                                                  }
                                                                                                                                              }
                                                                                                                                          }
                                                                                                                                      }   
                                                                                                                                  }       
                                                                                                                              }
                                                                                                                          }
                                                                                                                      }
                                                                                                                  }
                                                                                                                   
                                                                                                                } else {
                                                                                                                    //decide el 12
                                                                                                                    if (dtoMenor.getIndicadorDebeHaber().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getIndicadorDebeHaber()) > 0 ){   
                                                                                                                        dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                        posicionMenor = i;
                                                                                                                    }else {
                                                                                                                        if (dtoMenor.getIndicadorDebeHaber().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getIndicadorDebeHaber()) == 0 ){   
                                                                                                                        //decide el 13
                                                                                                                            if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) > 0 ){   
                                                                                                                                dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                posicionMenor = i;
                                                                                                                            } else {
                                                                                                                                if (dtoMenor.getCodigoMarcaProducto().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoMarcaProducto()) == 0 ){   
                                                                                                                                //decide el 14
                                                                                                                                    if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) > 0 ){   
                                                                                                                                        dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                        posicionMenor = i;
                                                                                                                                    }else {
                                                                                                                                        if (dtoMenor.getCodigoGrupoProductos().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoGrupoProductos()) == 0 ){       
                                                                                                                                        //decide 15
                                                                                                                                            if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) > 0 ){   
                                                                                                                                                dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                posicionMenor= i;
                                                                                                                                            }else {
                                                                                                                                                if (dtoMenor.getCodigoNegocio().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoNegocio()) == 0 ){   
                                                                                                                                            //decide 16
                                                                                                                                                    if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) > 0 ){   
                                                                                                                                                        dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                        posicionMenor = i;
                                                                                                                                                    }else{
                                                                                                                                                        if (dtoMenor.getCodigoTipoOferta().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoOferta()) == 0 ){   
                                                                                                                                                        //decide el 17
                                                                                                                                                            if (dtoMenor.getCodigoCicloVida().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCicloVida()) > 0 ){   
                                                                                                                                                                dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                                                                posicionMenor = i;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }   
                                                                                                                            }       
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
          }//FOR
          dtoAux=(DTOINTDocumentoContable)listaRegistros.get(j);//guardamos el registro que vamos a quitar de la listaRegistro en la posicion del menor
          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(posicionMenor);//guardamos el registro de la posicion menor
          listaRegistros.set(posicionMenor,dtoAux);//ponemos el auxiliar en la lista de nuevo, en la psicion delmenor.
          listaOrdenada.add(dtoMenor);//añadimos a la nueva lista ordenada el menor
          j++;
    
        }//while 
        
       listaOrdenada = cambioDeNulos(listaOrdenada,Boolean.FALSE);
       UtilidadesLog.info("MONINTSAPFIBean.ordenar(ArrayList listaRegistros, String tipoAsientos): Salida");     
     return listaOrdenada;     
    }
    
    // BELC300013913 . Afecta a la inclusion de RUC entre los criterios de ordenacion
    // Solo se utiliza si tratamos con documentos de ventas con transportista
    private ArrayList ordenar2(ArrayList listaRegistros, String tipoAsientos) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.ordenar2(ArrayList listaRegistros, String tipoAsientos): Entrada");
        UtilidadesLog.warn("ordenar2() listaRegistros.size "+ listaRegistros.size());
        listaRegistros = cambioDeNulos(listaRegistros,Boolean.TRUE);
        int i;
        int j;
        int n=listaRegistros.size();
        int posicionMenor;
        DTOINTDocumentoContable  dtoMenor=null;        
        DTOINTDocumentoContable  dtoAux=null;        
      
        ArrayList listaOrdenada = new ArrayList();
	      j = 0;
      
        while (j < n) {
		      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(j);  
          posicionMenor = j;
          
          for (i = j+1; i < n; i++) {
                
                if (dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) > 0 ){
                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                    posicionMenor = i;
                }else{ //si no es mmayor puede ser igual
                        if(dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) == 0 ){
                        //Si es iguakl decide el segundo parametro 
                                if (dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) > 0 ){
                                          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                          posicionMenor = i;
                                }else{
                                     if(dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) == 0 ){
                                                //Si es igual decide el tercer parametro 
                                               if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) > 0 ){   
                                                      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                      posicionMenor = i;
                                              }else{   
                                                    if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) == 0 ){   
                                                    //si es igual decide el 4 parametro
                                                         if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) > 0 ){   
                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                            posicionMenor = i;
                                                        }else{
                                                            if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) == 0 ){   
                                                            //decide el 5
                                                                if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) > 0 ){   
                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                    posicionMenor = i;
                                                                }else { 
                                                                    if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) == 0 ){   
                                                                        //decide el 6
                                                                        if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) > 0 ){   
                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                            posicionMenor = i;
                                                                        }else {
                                                                            if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) == 0 ){   
                                                                            //decide 7
                                                                                if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) > 0 ){   
                                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                    posicionMenor = i;
                                                                                }else {
                                                                                    if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) == 0 ){   
                                                                                    //decide el 8
                                                                                        if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) > 0 ){   
                                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                            posicionMenor = i;
                                                                                        }else {
                                                                                            if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) == 0 ){   
                                                                                            //decide el 9
                                                                                                if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) > 0 ){   
                                                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                    posicionMenor = i;
                                                                                                }else {
                                                                                                    if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) == 0 ){   
                                                                                                    //decide el 10
                                                                                                        // incidencia BELC300017884
                                                                                                        UtilidadesLog.debug(dtoMenor.getTipoMovimientoSAPFI()+" y2 "+((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI());
                                                                                                        UtilidadesLog.debug("dio: "+ dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()));
                                                                                                        if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) > 0 ){   
                                                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                            posicionMenor = i;
                                                                                                        }else {
                                                                                                            // incidencia BELC300017884
                                                                                                            if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) == 0 ){   
                                                                                                            //decide 11
                                                                                                               if (tipoAsientos.toUpperCase().equals(ConstantesINT.TIPO_ASIENTO_TN)) {
                                                                                                                   if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) > 0 ){   
                                                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                       posicionMenor = i;
                                                                                                                   }else {
                                                                                                                       if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) == 0 ){   
                                                                                                                       //decide el 12
                                                                                                                          if (dtoMenor.getIndicadorDebeHaber().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getIndicadorDebeHaber()) > 0 ){   
                                                                                                                              dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                              posicionMenor = i;
                                                                                                                          }
                                                                                                                     } 
                                                                                                                  }                                                                                                                  
                                                                                                               } else {
                                                                                                                    if (dtoMenor.getIndicadorDebeHaber().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getIndicadorDebeHaber()) > 0 ){   
                                                                                                                        dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                        posicionMenor = i;
                                                                                                                    }
                                                                                                                  
                                                                                                               }

                                                                                                         }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
          }//FOR
          dtoAux=(DTOINTDocumentoContable)listaRegistros.get(j);//guardamos el registro que vamos a quitar de la listaRegistro en la posicion del menor
          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(posicionMenor);//guardamos el registro de la posicion menor
          listaRegistros.set(posicionMenor,dtoAux);//ponemos el auxiliar en la lista de nuevo, en la psicion delmenor.
          listaOrdenada.add(dtoMenor);//añadimos a la nueva lista ordenada el menor
          j++;
    
        }//while 
       listaOrdenada = cambioDeNulos(listaOrdenada,Boolean.FALSE);
       UtilidadesLog.info("MONINTSAPFIBean.ordenar2(ArrayList listaRegistros, String tipoAsientos): Salida");     
     return listaOrdenada;
     
    }

     // BELC300013913. RUC solo se utiliza para ordenar si el tipoAsiento es de transporte 
     // con transportista
   private ArrayList ordenar3(ArrayList listaRegistros, String tipoAsientos) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.ordenar3(ArrayList listaRegistros, String tipoAsientos): Entrada");
        UtilidadesLog.warn("ordenar3() listaRegistros.size "+ listaRegistros.size());
        listaRegistros = cambioDeNulos(listaRegistros,Boolean.TRUE);
        int i;
        int j;
        int n=listaRegistros.size();
        int posicionMenor;
        DTOINTDocumentoContable  dtoMenor=null;        
        DTOINTDocumentoContable  dtoAux=null;        
      
        ArrayList listaOrdenada = new ArrayList();
	      j = 0;
      
        while (j < n) {
		      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(j);  
          posicionMenor = j;
          
          for (i = j+1; i < n; i++) {
                
                if (dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) > 0 ){
                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                    posicionMenor = i;
                }else{ //si no es mmayor puede ser igual
                        if(dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) == 0 ){
                        //Si es iguakl decide el segundo parametro 
                                if (dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) > 0 ){
                                          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                          posicionMenor = i;
                                }else{  
                                                    if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) == 0 ){   
                                                    //si es igual decide el 4 parametro
                                                         if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) > 0 ){   
                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                            posicionMenor = i;
                                                        }else{
                                                            if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) == 0 ){   
                                                            //decide el 5
                                                                if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) > 0 ){   
                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                    posicionMenor = i;
                                                                }else { 
                                                                    if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) == 0 ){   
                                                                        //decide el 6
                                                                        if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) > 0 ){   
                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                            posicionMenor = i;
                                                                        }else {
                                                                            if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) == 0 ){   
                                                                            //decide 7
                                                                                if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) > 0 ){   
                                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                    posicionMenor = i;
                                                                                }else {
                                                                                    if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) == 0 ){   
                                                                                    //decide el 8
                                                                                        if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) > 0 ){   
                                                                                            dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                            posicionMenor = i;
                                                                                        }else {
                                                                                            if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) == 0 ){   
                                                                                            //decide el 9
                                                                                                if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) > 0 ){   
                                                                                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                    posicionMenor = i;
                                                                        
                                                                                                }else {
                                                                                                
                                                                                                    if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) == 0 ){   
                                                                                                    //decide 10
                                                                                                        if (tipoAsientos.toUpperCase().equals(ConstantesINT.TIPO_ASIENTO_TN)) {
                                                                                                           if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) > 0 ){   
                                                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                               posicionMenor = i;
                                                                                                           } else {
                                                                                                               if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) == 0 ){   
                                                                                                               //decide 11
                                                                                                                   if (dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) > 0 ){   
                                                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                       posicionMenor = i;
                                                                                                                   }
                                                                                                       
                                                                                                               }
                                                                                                            }                                                                                                        
                                                                                                        } else {
                                                                                                            //decide 11
                                                                                                             if (dtoMenor.getFecha().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getFecha()) > 0 ){   
                                                                                                                 dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                 posicionMenor = i;
                                                                                                             }
                                                                                                                                                                                                                  
                                                                                                        }

                                                                                        }
                                                                                    
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                }
          }//FOR
          dtoAux=(DTOINTDocumentoContable)listaRegistros.get(j);//guardamos el registro que vamos a quitar de la listaRegistro en la posicion del menor
          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(posicionMenor);//guardamos el registro de la posicion menor
          listaRegistros.set(posicionMenor,dtoAux);//ponemos el auxiliar en la lista de nuevo, en la psicion delmenor.
          listaOrdenada.add(dtoMenor);//añadimos a la nueva lista ordenada el menor
          j++;
    
        }//while 
       listaOrdenada = cambioDeNulos(listaOrdenada,Boolean.FALSE);
       UtilidadesLog.info("MONINTSAPFIBean.ordenar3(ArrayList listaRegistros, String tipoAsientos): Salida");     
     return listaOrdenada;
     
    }


  /*
   * BELC300013913. RUC solo se utiliza para ordenar si el tipoAsiento es de transporte con transportista.
    criterios de ordenación:
         codigoPais 
         codigoEmpresa 
         codigoCanal 
         codigoAcceso 
         codigoSubacceso 
         codigoTipoPeriodo 
         codigoPeriodo 
         RUC 
         codigoApunte 
         tipoAsiento 
         tipoMovimientoSAPFI 
         codigoImporteAContabilizar 
   */ 
   private ArrayList ordenar4(ArrayList listaRegistros, String tipoAsientos) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.ordenar4(ArrayList listaRegistros, String tipoAsientos): Entrada");
        UtilidadesLog.warn("ordenar4() listaRegistros.size "+ listaRegistros.size());
        listaRegistros = cambioDeNulos(listaRegistros,Boolean.TRUE);
        int i;
        int j;
        int n=listaRegistros.size();
        int posicionMenor;
        DTOINTDocumentoContable  dtoMenor=null;        
        DTOINTDocumentoContable  dtoAux=null;        
      
        ArrayList listaOrdenada = new ArrayList();
	      j = 0;
      
        while (j < n) {
		      dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(j);  
          posicionMenor = j;
          
          for (i = j+1; i < n; i++) {
                
                if (dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) > 0 ){
                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                    posicionMenor = i;
                }else{ //si no es mmayor puede ser igual
                     if(dtoMenor.getCodigoPais().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPais()) == 0 ){
                     //Si es iguakl decide el segundo parametro 
                          if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) > 0 ){
                                    dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                    posicionMenor = i;
                          }else{  
                               if (dtoMenor.getCodigoEmpresa().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoEmpresa()) == 0 ){   
                               //si es igual decide el 4 parametro
                                    if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) > 0 ){   
                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                       posicionMenor = i;
                                   }else{
                                       if (dtoMenor.getCodigoCanal().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoCanal()) == 0 ){   
                                       //decide el 5
                                           if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) > 0 ){   
                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                               posicionMenor = i;
                                           }else { 
                                               if (dtoMenor.getCodigoAcceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoAcceso()) == 0 ){   
                                                   //decide el 6
                                                   if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) > 0 ){   
                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                       posicionMenor = i;
                                                   }else {
                                                       if (dtoMenor.getCodigoSubacceso().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoSubacceso()) == 0 ){   
                                                       //decide 7
                                                           if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) > 0 ){   
                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                               posicionMenor = i;
                                                           }else {
                                                               if (dtoMenor.getCodigoTipoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoTipoPeriodo()) == 0 ){   
                                                               //decide el 8
                                                                   if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) > 0 ){   
                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                       posicionMenor = i;
                                                                   }else {
                                                                       if (dtoMenor.getCodigoPeriodo().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoPeriodo()) == 0 ){   
                                                                       //decide el 9
                                                                           if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) > 0 ){   
                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                               posicionMenor = i;
                                                   
                                                                           }else {
                                                                           
                                                                               if (dtoMenor.getTipoAsiento().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoAsiento()) == 0 ){   
                                                                               //decide 10
                                                                                   if (tipoAsientos.toUpperCase().equals(ConstantesINT.TIPO_ASIENTO_TN)) {
                                                                                         if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) > 0 ){   
                                                                                             dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                             posicionMenor = i;
                                                                                         } else {
                                                                                             if (dtoMenor.getRUC().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getRUC()) == 0 ){   
                                                                                             //decide 11
                                                                                                 if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) > 0 ){   
                                                                                                     dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                     posicionMenor = i;
                                                                                                 }else {
                                                                                                     if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) == 0 ){   
                                                                                                         //decide 12
                                                                                                            // incidencia BELC300017884
                                                                                                        UtilidadesLog.debug(dtoMenor.getTipoMovimientoSAPFI()+" y3 "+((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI());
                                                                                                        UtilidadesLog.debug("dio: "+ dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()));
                                                                                                             if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) > 0 ){   
                                                                                                                 dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                 posicionMenor = i;
                                                                                                             }else { 
                                                                                                                  // incidencia BELC300017884
                                                                                                                 if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) == 0 ){   
                                                                                                                 //decide 12
                                                                                                                     if (dtoMenor.getCodigoImporteAContabilizar().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoImporteAContabilizar()) > 0 ){   
                                                                                                                             dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                             posicionMenor = i;
                                                                                                                     }
                                                                                                                 }
                                                                                                             }
                                                                                                         }
                                                                                             
                                                                                                   }
                                                                                     
                                                                                                }
                                                                                          }     
                                                                                   } else {
                                                                                      
                                                                                         //decide 11
                                                                                           // incidencia BELC300017884
                                                                                           if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) > 0 ){   
                                                                                               dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                               posicionMenor = i;
                                                                                           }else {
                                                                                               // incidencia BELC300017884
                                                                                               if (dtoMenor.getCodigoApunte().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoApunte()) == 0 ){   
                                                                                                   //decide 12
                                                                                                        UtilidadesLog.debug(dtoMenor.getTipoMovimientoSAPFI()+" y4 "+((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI());
                                                                                                        UtilidadesLog.debug("dio: "+ dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()));
                                                                                                       if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) > 0 ){   
                                                                                                           dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                           posicionMenor = i;
                                                                                                       }else { 
                                                                                                           if (dtoMenor.getTipoMovimientoSAPFI().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getTipoMovimientoSAPFI()) == 0 ){   
                                                                                                           //decide 12
                                                                                                               if (dtoMenor.getCodigoImporteAContabilizar().compareTo(((DTOINTDocumentoContable)listaRegistros.get(i)).getCodigoImporteAContabilizar()) > 0 ){   
                                                                                                                       dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(i); 
                                                                                                                       posicionMenor = i;
                                                                                                               }
                                                                                                           }
                                                                                                       }
                                                                                                   }
                                                                                       
                                                                                             }                                                                                   
                                                                                   
                                                                                   
                                                                                   }

                                                                                 }
                                                                                    
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                }
          }//FOR
          dtoAux=(DTOINTDocumentoContable)listaRegistros.get(j);//guardamos el registro que vamos a quitar de la listaRegistro en la posicion del menor
          dtoMenor=(DTOINTDocumentoContable)listaRegistros.get(posicionMenor);//guardamos el registro de la posicion menor
          listaRegistros.set(posicionMenor,dtoAux);//ponemos el auxiliar en la lista de nuevo, en la psicion delmenor.
          listaOrdenada.add(dtoMenor);//añadimos a la nueva lista ordenada el menor
          j++;
    
        }//while 
      listaOrdenada = cambioDeNulos(listaOrdenada,Boolean.FALSE);
       UtilidadesLog.info("MONINTSAPFIBean.ordenar4(ArrayList listaRegistros, String tipoAsientos): Salida");     
     return listaOrdenada;
     
    }


    private void loguearSql(String metodo, String sql, Vector params) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.loguearSql(String metodo, String sql, Vector params): Entrada");
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                if (params.elementAt(i) != null) {
                    sParams += ("param " + (i + 1) + ": " +
                    (params.elementAt(i)).toString() + ", ");
                } else {
                    sParams += ("param " + (i + 1) + ": es nulo, ");
                }
            }

            UtilidadesLog.debug(metodo + sParams);
        }
        UtilidadesLog.info("MONINTSAPFIBean.loguearSql(String metodo, String sql, Vector params): Salida");
    }


    /**
     * 
     */
   private void asignarCuentaContable(DTOINTCargosAbonos dtoCA, DTOINTParametrosContablesCCC dtoPC, InterfazInfo info) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.asignarCuentaContable(DTOINTCargosAbonos dtoCA, DTOINTParametrosContablesCCC dtoPC): Entrada");
      String obtencion = dtoPC.getObtencionCuenta().toUpperCase();
      MONGestorInterfaces gi = this.getMONGestorInterfaces();
      String codigoError;
      CuentasContablesLocal cuContLocal = null;
      CuentasContablesLocalHome cucoLocalHome = this.getCuentasContablesLocalHome();
      CuentasCorrientesLocal cuCorrLocal = null;
      CuentasCorrientesLocalHome cuenCorriLocalHome = this.getCuentasCorrientesLocalHome();
		
      if (obtencion.equals(CCCConstantes.CODIGO_CUENTA_DIRECTA)) {
         try {
            cuContLocal = cucoLocalHome.findByPrimaryKey(dtoPC.getCuentaDirecta());
         } catch (NoResultException fe) {
            // se hace log con el mensaje INT-0010 + "CuentasContables" 
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasContables: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010 + "CuentasContables"); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }            
         
         // BELC300013463 
         dtoCA.setCuentaContable(dtoPC.getCuentaDirecta());
         if(cuContLocal!=null){
            dtoCA.setCodigoCuentaContable(cuContLocal.getCodigo());
         }

      } else if (obtencion.equals(CCCConstantes.CODIGO_CUENTA_BANCO)) {
      
         try {
            cuCorrLocal = cuenCorriLocalHome.findByUK(dtoCA.getCodigoBanco(), dtoCA.getOidPais());
         } catch (NoResultException fe) {
            // - se hace log con el mensaje INT-0010 + "CuentasCorrientes - pais: " + dtoCA.codigoPais + " - codigo: " + dtaCA.banco 
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasCorrientes: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010 + "CuentasCorrientes - pais: "
                                                            + dtoCA.getCodigoPais() + " - codigo: " + dtoCA.getCodigoBanco() ); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }

         if(cuCorrLocal!=null){
            dtoCA.setCuentaContable(cuCorrLocal.getCuentaTesoreria());
         }
         try {
            cuContLocal = cucoLocalHome.findByPrimaryKey(dtoCA.getCuentaContable());
         } catch (NoResultException fe) {
            // se hace log con el mensaje INT-0010 + "CuentasContables" 
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasContables: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010 + "CuentasContables" ); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
         if(cuContLocal!=null){
            dtoCA.setCodigoCuentaContable(cuContLocal.getCodigo());
         }

      } else if (obtencion.equals(CCCConstantes.CODIGO_CUENTA_PUENTE_BANCO)) {
      
         try {
            cuCorrLocal = cuenCorriLocalHome.findByUK(dtoCA.getCodigoBanco(), dtoCA.getOidPais());
         } catch (NoResultException fe) {  
            // se hace log con el mensaje INT-0010 + "CuentasCorrientes - pais: " + dtoCA.codigoPais + " - codigo: " + dtaCA.banco 
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasCorrientes: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010 + "CuentasCorrientes - pais: "
                                                            + dtoCA.getCodigoPais() + " - codigo: " + dtoCA.getCodigoBanco() ); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }

         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         } 
         if(cuCorrLocal!=null){
            dtoCA.setCuentaContable(cuCorrLocal.getCuentaPuente());
         }
         try {
            cuContLocal = cucoLocalHome.findByPrimaryKey(dtoCA.getCuentaContable());
         } catch (NoResultException fe) {
            // se hace log con el mensaje INT-0010 + "CuentasContables" la excepcion es parametrizada.
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasContables: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010 + "CuentasContables" ); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
         if(cuContLocal!=null){
            dtoCA.setCodigoCuentaContable(cuContLocal.getCodigo());
         }

      } else if (obtencion.equals(CCCConstantes.CODIGO_CUENTA_ABONO_CARGO)) {

         TiposAbonoSubprocesoLocal tiposAbonoLocal = null;
         try {
            tiposAbonoLocal = this.getTiposAbonoSubprocesoLocalHome().findByPrimaryKey(dtoCA.getTipoAbonoSubprocesoDetalle());
         } catch (NoResultException fe) {
            // se hace log con el mensaje INT-0010 + "TiposAbonoSubproceso - pais: " + dtoCA.codigoPais + " - tipo abono: " + dtoCA.tipoCargoAbono + " - subproceso: " + dtoCA.codigoSubproceso 
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en TiposAbonoSubproceso: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010  + "TiposAbonoSubproceso - pais: " 
                                                   + dtoCA.getCodigoPais() + " - tipo abono: " + dtoCA.getTipoCargoAbono() 
                                                   + " - subproceso: " + dtoCA.getCodigoSubproceso()); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
        if(tiposAbonoLocal!=null){
            dtoCA.setCuentaContable(tiposAbonoLocal.getCuenta());
        }
         try {
            cuContLocal = cucoLocalHome.findByPrimaryKey(tiposAbonoLocal.getCuenta());
         } catch (NoResultException fe) {
            // se hace log con el mensaje INT-0010 + "CuentasContables" 
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasContables: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010  + "CuentasContables"); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
         if(cuContLocal!=null){
            dtoCA.setCodigoCuentaContable(cuContLocal.getCodigo()); 
         }

      } else if (obtencion.equals(CCCConstantes.CODIGO_CUENTA_CUOTA_ANTERIOR)) {

         dtoCA.setCuentaContable(dtoCA.getCuentaContableCuotaAnterior());
         try {
            cuContLocal = cucoLocalHome.findByPrimaryKey(dtoCA.getCuentaContable());
         } catch (NoResultException fe) {   
            // se hace log con el mensaje INT-0010 + "CuentasContables" la excepcion es parametrizada.
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasContables: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010  + "CuentasContables"); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
         
         if(cuContLocal!=null){
            dtoCA.setCodigoCuentaContable(cuContLocal.getCodigo());
         }

      } else if (obtencion.equals(CCCConstantes.CODIGO_CUENTA_CUOTA_NUEVA)) {
      
         dtoCA.setCuentaContable(dtoCA.getCuentaContableCuotaNueva());
         try {
            cuContLocal = cucoLocalHome.findByPrimaryKey(dtoCA.getCuentaContable());
         } catch (NoResultException fe) {
            // se hace log con el mensaje INT-0010 + "CuentasContables" la excepcion es parametrizada.
            UtilidadesLog.error("Metodo MONINTSAFI.asignarCuentaContable: FinderException al buscar en CuentasContables: " + fe);
            DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0010  + "CuentasContables"); 
            try {
                gi.registrarError(dtoError); 
            } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error InterfacesException");
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
            } catch (RemoteException ne) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("MONINTSAFI.asignarCuentaContable. error RemoteException");
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
         if(cuContLocal!=null){
            dtoCA.setCodigoCuentaContable(cuContLocal.getCodigo());
         }
        }
      UtilidadesLog.info("MONINTSAPFIBean.asignarCuentaContable(DTOINTCargosAbonos dtoCA, DTOINTParametrosContablesCCC dtoPC): Salida");
   }


    /**
     * incidencia BELC300013467
     * Si el proceso asociado al registro de Cargos/Abonos no es "TES0001" ni "TES002", 
     * se modifican los atributos 'banco' y 'fechaPagoBancos', poniéndolos a nulo"
     * PROCESO_MOVIMIENTO_AUTOMATICO = "TES001"
     * PROCESO_MOVIMIENTO_MANUAL = "TES002"
     * @cambio en salida a produccion se agregan los procesos TESP01, CCCEN1, CCCP07 y CCCP11.
     * @autor gdmarzi (in situ)
     */
   private void comprobarProcesosTesoreria(DTOINTCargosAbonos dtoCA) {
      UtilidadesLog.info("MONINTSAPFIBean.comprobarProcesosTesoreria(DTOINTCargosAbonos dtoCA): Entrada");
      String codProceso = dtoCA.getCodigoProceso().toUpperCase();
     
      if ( ! (codProceso.equals(CCCConstantes.PROCESO_MOVIMIENTO_AUTOMATICO) 
            || codProceso.equals(CCCConstantes.PROCESO_MOVIMIENTO_MANUAL)
            || codProceso.equals(CCCConstantes.TESP01_PERCEP_RECAUDOS_BANCARIOS)
            || codProceso.equals(CCCConstantes.CCCEN1_PAGOS_EN_EXCESO_NEGATIVO)
            || codProceso.equals(CCCConstantes.CCCP07_PERCEP_DECUENTOS_A_PERSONAL)
            || codProceso.equals(CCCConstantes.CCCP11_PERCEP_ABONOS_CANAL_INTERNET)) ) {
         dtoCA.setBanco(null);
         dtoCA.setFechaPagoBancos(null);
      }
      UtilidadesLog.info("MONINTSAPFIBean.comprobarProcesosTesoreria(DTOINTCargosAbonos dtoCA): Salida");
   }


   private ArrayList agruparDTOINTCargosAbonos(ArrayList listaSinAgrupar) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTCargosAbonos(ArrayList listaSinAgrupar): Entrada");

      ArrayList listaAgrupada = new ArrayList();

      DTOINTCargosAbonos dtoNoAgrupado = null;
      DTOINTCargosAbonos dtoAgrupado = null;
      
      boolean encontrado;
      
      // metemos el primer elemento en la lista agrupada
      if (listaSinAgrupar.size() > 0) {
        listaAgrupada.add((DTOINTCargosAbonos)listaSinAgrupar.get(0));
      }
      
      for (int i=1; i < listaSinAgrupar.size(); i++) {
         
         dtoNoAgrupado = (DTOINTCargosAbonos)listaSinAgrupar.get(i);
         
         encontrado = false;
         
         for (int j=0; j < listaAgrupada.size(); j++) {
            
            dtoAgrupado = (DTOINTCargosAbonos)listaAgrupada.get(j);

            if (this.compararDTOINTCargosAbonos(dtoNoAgrupado, dtoAgrupado)) { // se deben agrupar
               if(dtoNoAgrupado.getImporte() !=null && dtoAgrupado.getImporte() !=null){
                    dtoAgrupado.setImporte(dtoAgrupado.getImporte().add(dtoNoAgrupado.getImporte()));
               }else if(dtoNoAgrupado.getImporte()!=null){
                   dtoAgrupado.setImporte(dtoNoAgrupado.getImporte());
               }
               encontrado = true;
               break;
            }
         }
         if (! encontrado) {
            listaAgrupada.add(dtoNoAgrupado);
         }
      }
      
      UtilidadesLog.info("MONINTSAPFIBean.agruparDTOINTCargosAbonos(ArrayList listaSinAgrupar): Salida");
      return listaAgrupada;
   }
   
   
   /**
   * Criterios de agrupacion
   * pais 
   * fechaDocumento 
   * fechaValor 
   * empresa 
   * canal 
   * acceso 
   * subacceso 
   * proceso 
   * subproceso 
   * cuentaContable // no obligatorio 
   * banco // no obligatorio
   * fechaPagoBancos // no obligatorio
   */
   private boolean compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Entrada");
      boolean resultado = true;

      if(x.getOidPais()!=null&&y.getOidPais()!=null){
          if(x.getOidPais().compareTo(y.getOidPais()) != 0){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getOidPais()!= y.getOidPais()){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
      }
      
      if(x.getFechaDocumento()!=null && y.getFechaDocumento()!=null){
          if (x.getFechaDocumento().compareTo(y.getFechaDocumento()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getFechaDocumento()!=y.getFechaDocumento()){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
      }
      if(x.getFechaValor()!=null&&y.getFechaValor()!=null){
          if (x.getFechaValor().compareTo(y.getFechaValor()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getFechaValor()!=y.getFechaValor()){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
      }
      if(x.getEmpresa()!=null && y.getEmpresa()!= null){    
          if (x.getEmpresa().compareTo(y.getEmpresa()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;      
          }
      }else if(x.getEmpresa()!=y.getEmpresa()){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
      }
      if(x.getCanal()!=null && y.getCanal()!=null){
          if (x.getCanal().compareTo(y.getCanal()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getCanal()!=y.getCanal()){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
      }      
      if(x.getAcceso()!=null&& y.getAcceso()!=null){
          if (x.getAcceso().compareTo(y.getAcceso()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getAcceso()!= y.getAcceso()){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
      }
      if(x.getSubacceso()!=null&& y.getSubacceso()!=null){
          if (x.getSubacceso().compareTo(y.getSubacceso()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getSubacceso()!= y.getSubacceso()){
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
      }
      if(x.getProceso()!=null&&y.getProceso()!=null){
          if (x.getProceso().compareTo(y.getProceso()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getProceso()!=y.getProceso()){
          UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
          return false;
      }
      if(x.getSubproceso()!=null&&y.getSubproceso()!=null){
          if (x.getSubproceso().compareTo(y.getSubproceso()) != 0) {
             UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
             return false;
          }
      }else if(x.getSubproceso()!=y.getSubproceso()){
          UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
          return false;
      }
      if (x.getCuentaContable() != null && y.getCuentaContable() != null) {
         if (x.getCuentaContable().compareTo(y.getCuentaContable()) != 0) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      } else {
         if (x.getCuentaContable() != y.getCuentaContable()) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      }
      if (x.getBanco() != null && y.getBanco() != null) {
         if (x.getBanco().compareTo(y.getBanco()) != 0) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      } else {
         if (x.getBanco() != y.getBanco()) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      }
      if (x.getFechaPagoBancos() != null && y.getFechaPagoBancos() != null) {
         if (x.getFechaPagoBancos().compareTo(y.getFechaPagoBancos()) != 0) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      } else {
         if (x.getFechaPagoBancos() != y.getFechaPagoBancos()) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      }
      if (x.getIndicadorDebeHaber() != null && y.getIndicadorDebeHaber() != null) {
         if (x.getIndicadorDebeHaber().compareTo(y.getIndicadorDebeHaber()) != 0) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      } else {
         if (x.getIndicadorDebeHaber() != y.getIndicadorDebeHaber()) {
            UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");
            return false;
         }
      }
      UtilidadesLog.info("MONINTSAPFIBean.compararDTOINTCargosAbonos(DTOINTCargosAbonos x, DTOINTCargosAbonos y): Salida");      
      return resultado;
   }   
   
   
   private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTSAPFIBean.getMONGestorInterfaces(): Entrada");
        MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONGestroInterfaces",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTSAPFIBean.getMONGestorInterfaces(): Salida");
        return ejb;
	}   
   
   private ArrayList ordenar7(ArrayList listaRegistros) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.ordenar7(ArrayList listaRegistros): Entrada");
      UtilidadesLog.warn("ordenar7() listaRegistros.size "+ listaRegistros.size());
      // - Se ordenan los objetos contenidos en 'listaFinal', de mayor a menor, 
      // por los siguientes criterios: 
      // codigoPais
      // fechaDocumento ///////////////    incidencia  BELC300013544
      // codigoEmpresa
      // codigoCanal
      // codigoAcceso
      // codigoSubacceso
      // codigoCuentaContable
      // indicadorDebeHaber( primero Debe )
      // codigoBanco
      // fechaPagoBancos
         
      int i;
      int j;
      int n = listaRegistros.size();
      int posicionMayor;
      DTOINTCargosAbonos dtoMayor = null;        
      DTOINTCargosAbonos dtoAux = null;        
      DTOINTCargosAbonos dtoCargosAbonos;
      
      ArrayList listaOrdenada = new ArrayList();
      j = 0;

      /*
       * Si el Importe es negativo, Si (D)ebe/(H)aber es D, se modifica como H y viceversa.
       */
      for (i = 0; i < n ; i++) {
          dtoCargosAbonos = (DTOINTCargosAbonos)listaRegistros.get(i);
          if (dtoCargosAbonos.getImporte().compareTo(new BigDecimal(0)) < 0) {
              if (dtoCargosAbonos.getIndicadorDebeHaber().toUpperCase().equals(CCCConstantes.COD_DEBE)) {
                  dtoCargosAbonos.setIndicadorDebeHaber(CCCConstantes.COD_HABER);
              } else {
                  dtoCargosAbonos.setIndicadorDebeHaber(CCCConstantes.COD_DEBE);
              }
              // luego, antes de enviar el registro a la interfaz se coloca en valor absoluto.
          }
      }
      
      while (j < n) {

         dtoMayor = (DTOINTCargosAbonos)listaRegistros.get(j);  
        
         posicionMayor = j;
         for (i = j + 1; i < n ; i++) {
             //añadido 
             dtoCargosAbonos = (DTOINTCargosAbonos)listaRegistros.get(i);
            
             //modificado
             if (dtoMayor.getCodigoPais()!=null && dtoCargosAbonos.getCodigoPais()!=null && dtoMayor.getCodigoPais().compareTo(dtoCargosAbonos.getCodigoPais()) < 0) {
                 dtoMayor = dtoCargosAbonos; //(DTOINTCargosAbonos)listaRegistros.get(i); 
                 posicionMayor = i;
                 UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 1");
             } else { // si no es mayor puede ser igual
                     UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 1a");
                     if ((dtoMayor.getCodigoPais()==null && dtoCargosAbonos.getCodigoPais()==null)||dtoMayor.getCodigoPais()!=null  && dtoCargosAbonos.getCodigoPais()!=null &&dtoMayor.getCodigoPais().compareTo(dtoCargosAbonos.getCodigoPais()) == 0) {
                     // Si es igual decide fechaDocumento. Incidencia BELC300013544)
                             if (dtoMayor.getFechaDocumento()!=null && dtoCargosAbonos.getFechaDocumento()!=null && dtoMayor.getFechaDocumento().compareTo(dtoCargosAbonos.getFechaDocumento()) < 0) {
                                 dtoMayor = dtoCargosAbonos; //(DTOINTCargosAbonos)listaRegistros.get(i); 
                                 posicionMayor = i;
                                 UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 2");
                             } else{
                                 UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 2a");
                                       if((dtoMayor.getFechaDocumento()==null && dtoCargosAbonos.getFechaDocumento()==null)||dtoMayor.getFechaDocumento()!=null && dtoCargosAbonos.getFechaDocumento()!=null && dtoMayor.getFechaDocumento().compareTo(dtoCargosAbonos.getFechaDocumento()) == 0) {
                                             //Si es igual decide el codigoEmpresa
                                            if (dtoMayor.getCodigoEmpresa()!=null && dtoCargosAbonos.getCodigoEmpresa()!=null && dtoMayor.getCodigoEmpresa().compareTo(dtoCargosAbonos.getCodigoEmpresa()) < 0) {   
                                                   dtoMayor = dtoCargosAbonos; //(DTOINTCargosAbonos)listaRegistros.get(i); 
                                                   posicionMayor = i;
                                                UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 3");
                                           }else{   
                                                UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 3a");
                                                 if ((dtoMayor.getCodigoEmpresa()==null && dtoCargosAbonos.getCodigoEmpresa()==null)||dtoMayor.getCodigoEmpresa()!=null && dtoCargosAbonos.getCodigoEmpresa()!=null &&  dtoMayor.getCodigoEmpresa().compareTo(dtoCargosAbonos.getCodigoEmpresa()) == 0) {   
                                                 // si es igual decide el codigoCanal
                                                      if (dtoMayor.getCodigoCanal()!=null && dtoCargosAbonos.getCodigoCanal()!=null && dtoMayor.getCodigoCanal().compareTo(dtoCargosAbonos.getCodigoCanal()) < 0) {   
                                                         dtoMayor = dtoCargosAbonos; //(DTOINTCargosAbonos)listaRegistros.get(i); 
                                                         posicionMayor = i;
                                                         UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 4");
                                                     }else{
                                                         UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 4a");
                                                         if ((dtoMayor.getCodigoCanal()==null && dtoCargosAbonos.getCodigoCanal()==null)||dtoMayor.getCodigoCanal()!=null && dtoCargosAbonos.getCodigoCanal()!=null &&  dtoMayor.getCodigoCanal().compareTo(dtoCargosAbonos.getCodigoCanal()) == 0) {   
                                                         //decide el codigoAcceso
                                                             if (dtoMayor.getCodigoAcceso()!=null && dtoCargosAbonos.getCodigoAcceso()!=null && dtoMayor.getCodigoAcceso().compareTo(dtoCargosAbonos.getCodigoAcceso()) < 0) {   
                                                                 dtoMayor = dtoCargosAbonos; //(DTOINTCargosAbonos)listaRegistros.get(i); 
                                                                 posicionMayor = i;
                                                                 UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 5");
                                                             }else { 
                                                                UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 5a");
                                                                 if ((dtoMayor.getCodigoAcceso()==null && dtoCargosAbonos.getCodigoAcceso()==null)||dtoMayor.getCodigoAcceso()!=null && dtoCargosAbonos.getCodigoAcceso()!=null && dtoMayor.getCodigoAcceso().compareTo(dtoCargosAbonos.getCodigoAcceso()) == 0) {   
                                                                     //decide el codigoSubacceso
                                                                     if (dtoMayor.getCodigoSubacceso()!=null && dtoCargosAbonos.getCodigoSubacceso()!=null && dtoMayor.getCodigoSubacceso().compareTo(dtoCargosAbonos.getCodigoSubacceso()) < 0) {   
                                                                         
                                                                         dtoMayor = dtoCargosAbonos; //(DTOINTCargosAbonos)listaRegistros.get(i); 
                                                                         posicionMayor = i;
                                                                        UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 6");
                                                                     }else {
                                                                         UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 6a");
                                                                         if ((dtoMayor.getCodigoSubacceso()==null && dtoCargosAbonos.getCodigoSubacceso()==null)||dtoMayor.getCodigoSubacceso()!=null  && dtoCargosAbonos.getCodigoSubacceso()!=null  && dtoMayor.getCodigoSubacceso().compareTo(dtoCargosAbonos.getCodigoSubacceso()) == 0) {   
                                                                         //decide codigoCuentaContable   
                                                                             if (dtoMayor.getCodigoCuentaContable()!=null && dtoCargosAbonos.getCodigoCuentaContable()!=null && dtoMayor.getCodigoCuentaContable().compareTo(dtoCargosAbonos.getCodigoCuentaContable()) < 0) {
                                                                                 UtilidadesLog.debug(dtoMayor.getCodigoCuentaContable()+" y 2a "+ dtoCargosAbonos.getCodigoCuentaContable());
                                                                                 dtoMayor = dtoCargosAbonos; //(DTOINTCargosAbonos)listaRegistros.get(i); 
                                                                                 posicionMayor = i;
                                                                                UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 7");
                                                                             }else {
                                                                                 UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 7a");
                                                                                 if ((dtoMayor.getCodigoCuentaContable()==null && dtoCargosAbonos.getCodigoCuentaContable()==null)
                                                                                      ||dtoMayor.getCodigoCuentaContable()!=null && dtoCargosAbonos.getCodigoCuentaContable()!=null && dtoMayor.getCodigoCuentaContable().compareTo(dtoCargosAbonos.getCodigoCuentaContable()) == 0) {
                                                                                      UtilidadesLog.debug(dtoMayor.getCodigoCuentaContable()+" y 2b "+ dtoCargosAbonos.getCodigoCuentaContable());
                                                                                 //decide indicadorDebeHaber( primero Debe )
                                                                                     if (dtoMayor.getIndicadorDebeHaber()!=null && dtoMayor.getIndicadorDebeHaber().equals(CCCConstantes.COD_HABER) && dtoCargosAbonos.getIndicadorDebeHaber()!=null && dtoCargosAbonos.getIndicadorDebeHaber().equals(CCCConstantes.COD_DEBE)) {
                                                                                         dtoMayor=dtoCargosAbonos; 
                                                                                         posicionMayor = i;
                                                                                
                                                                                        UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 8");
                                                                                     }else {
                                                                                         UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 8a");
                                                                                         if (dtoMayor.getIndicadorDebeHaber()!=null && dtoMayor.getIndicadorDebeHaber().equals(dtoCargosAbonos.getIndicadorDebeHaber())) {   
                                                                                            //decide el codigoBanco
                                                                                             // decide CodigoBanco, que puede ser null
                                                                                             // si los 2 tienen valor distinto de null en CodigoBanco se comparan
                                                                                             // si los 2 tienen valor null en CodigoBanco se dejan en el orden en que estan
                                                                                             // si el mayor tiene valor distinto de null y el evaluado igual a null se dejan como estan
                                                                                             // si el mayor tiene valor null y el evaluado distinto de null se cambia el orden
                                                                                             if(dtoMayor.getCodigoBanco() != null && dtoCargosAbonos.getCodigoBanco() != null &&
                                                                                                  dtoMayor.getCodigoBanco().compareTo(dtoCargosAbonos.getCodigoBanco()) < 0) {   
                                                                                                     dtoMayor=dtoCargosAbonos; 
                                                                                                     posicionMayor = i;                                                                                                     
                                                                                                    UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 9");
                                                                                             }else if((dtoMayor.getCodigoBanco()==null && dtoCargosAbonos.getCodigoBanco()==null)||(dtoMayor.getCodigoBanco()!=null &&
                                                                                                        dtoCargosAbonos.getCodigoBanco() != null && dtoMayor.getCodigoBanco().compareTo(dtoCargosAbonos.getCodigoBanco()) == 0)) {  
                                                                                                       UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 10");
                                                                                                       // decide fechaPagoBancos, que puede ser null
                                                                                                       // si los 2 tienen valor distinto de null en fechaPagoBancos se comparan
                                                                                                       // si los 2 tienen valor null en fechaPagoBancos se dejan en el orden en que estan
                                                                                                       // si el mayor tiene valor distinto de null y el evaluado igual a null se dejan como estan
                                                                                                       // si el mayor tiene valor null y el evaluado distinto de null se cambia el orden
                                                                                                       if(dtoMayor.getFechaPagoBancos() != null && dtoCargosAbonos.getFechaPagoBancos() != null &&
                                                                                                          dtoMayor.getFechaPagoBancos().compareTo(dtoCargosAbonos.getFechaPagoBancos()) < 0) {   
                                                                                                              dtoMayor=dtoCargosAbonos; 
                                                                                                              posicionMayor = i;
                                                                                                              UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 10a");
                                                                                                       } else if(dtoMayor.getFechaPagoBancos() == null && dtoCargosAbonos.getFechaPagoBancos() != null) {
                                                                                                          UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 10b");
                                                                                                          dtoMayor=dtoCargosAbonos; 
                                                                                                          posicionMayor = i;
                                                                                                       } 
                                                                                              } else if(dtoMayor.getCodigoBanco() == null && dtoCargosAbonos.getCodigoBanco() != null) {
                                                                                                     dtoMayor=dtoCargosAbonos; 
                                                                                                     posicionMayor = i;
                                                                                                     UtilidadesLog.debug("MONINTSAPFIBean.ordenar7 12");
                                                                                              }
                                                                                         }
                                                                                     }
                                                                                }
                                                                             }
                                                                         }
                                                                     }
                                                                 }
                                                             }
                                                         }
                                                     }
                                                 }
                                           }
                                       }
                             }
                     }
             }
            UtilidadesLog.debug("for posicion "+i); 
         } //FOR

         dtoAux = (DTOINTCargosAbonos)listaRegistros.get(j); //guardamos el registro que vamos a quitar de la listaRegistro en la posicion del mayor
         dtoMayor = (DTOINTCargosAbonos)listaRegistros.get(posicionMayor); //guardamos el registro de la posicion mayor
         listaRegistros.set(posicionMayor, dtoAux); //ponemos el auxiliar en la lista de nuevo, en la posicion del mayor.
         listaOrdenada.add(dtoMayor); //añadimos a la nueva lista ordenada el mayor
         j++;
      
      } //while       
      
      UtilidadesLog.info("MONINTSAPFIBean.ordenar7(ArrayList listaRegistros): Salida");
      return listaOrdenada;
   }


    /**
     * Inteface SAP-FI Enviar Apuntes Contables.
     * Invoca a Enviar Apuntes Contables Cuentas Corrientes y Enviar Apuntes Contables Facturacion.
     */
    public DTOSalidaBatch enviarApuntesContables(DTOINT dtoE) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.enviarApuntesContables(DTOINT dtoE): Entrada");
        DTOINTEnviarApuntesContables dto = new DTOINTEnviarApuntesContables(); 
        dto.setNumeroLote(dtoE.getNumeroLote().toString()); 
        dto.setDescripcion(dtoE.getDescripcionLote());
        dto.setObservaciones(dtoE.getObservaciones());
        dto.setFecha(new Date());
        dto.setOidPais(dtoE.getOidPais());
        dto.setOidIdioma(dtoE.getOidIdioma());
        dto.setFechaHasta(dtoE.getFechaHasta()); //agregado por incidencia SiCC-20070233 (Sapaza)

        DTOBatch dtoBatch = new DTOBatch( "enviarApuntesContablesCC", new MareBusinessID( "INTGenerarApuntesContablesCC" ),dto);
        try{
      			BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ); 
        } catch(RemoteException e){            
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }

        dtoBatch = new DTOBatch( "enviarApuntesContablesFAC", new MareBusinessID( "INTGenerarApuntesContablesFAC" ),dto);
        try{
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ); 
        } catch(RemoteException e){            
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }

        UtilidadesLog.info("MONINTSAPFIBean.enviarApuntesContables(DTOINT dtoE): Salida");
        return new DTOSalidaBatch( 0, "enviarApuntesContables finalizado" );
    }


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }
   
   private ArrayList agruparPorCodigoImporte(ArrayList listaSinAgrupar, String []importes) throws MareException {
      UtilidadesLog.info("MONINTSAPFIBean.agruparPorCodigoImporte(ArrayList listaSinAgrupar, String []importes): Entrada");
      
      ArrayList listaTemp = new ArrayList();

      DTOINTParametrosContablesFAC dtoNoAgrupado = null;
      
      ArrayList []listas = new ArrayList[importes.length];
      for (int i=0; i < listas.length; i++) {
         listas[i] = new ArrayList();
      }
            
      for (int i=0; i < listaSinAgrupar.size(); i++) {
         
         dtoNoAgrupado = new DTOINTParametrosContablesFAC();
         dtoNoAgrupado = (DTOINTParametrosContablesFAC)listaSinAgrupar.get(i);
         
         for (int j=0; j < importes.length; j++) {
            if (dtoNoAgrupado.getCodigoImporteAContabilizar().equals(importes[j])) {
               listas[j].add(dtoNoAgrupado);
               break;
            }
         }
      }
      
      for (int i=0; i < listas.length; i++) {
         listaTemp.add(listas[i]);
      }
    
      UtilidadesLog.info("MONINTSAPFIBean.agruparPorCodigoImporte(ArrayList listaSinAgrupar, String []importes): Salida");
      return listaTemp;
   }
   
    
  private void validaAccesos(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio) throws MareException 
	{
        
        UtilidadesLog.info("MONINTSAPFIBean.validaAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais +
            ",sociedad = " + sociedad + ", marca=" + marca + ", canal= " +
            canal + ", acceso=" + acceso + ",subacceso = " + subacceso +
            ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal,
                    acceso, subacceso, subgerencia, region, zona, seccion,
                    territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRegistroAbastecimiento.validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRegistroAbastecimiento.validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONINTSAPFIBean.validaAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
    }

    private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.getMONValidacion(): Entrada");

        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion",
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {            
            UtilidadesLog.error(e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONINTSAPFIBean.getMONValidacion(): Salida");
        return ejb;
    }

    private void gestionarIntVacia(DTOINTEnviarApuntesContables dtoEntrada) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.gestionarIntVacia(): Entrada");
        
        // Se obtiene una referencia al subsistema de interfaces: 
        MONGestorInterfaces gi = this.getMONGestorInterfaces();

        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAF1C, 
        dtoEntrada.getNumeroLote(), 
        dtoEntrada.getOidPais());
        
        UtilidadesLog.debug("***DTOENTRADA - CC: " + dtoEntrada);
        UtilidadesLog.debug("***INTERFAZ ApuntesContablesCC: "+info); 
        UtilidadesLog.debug("******************************* Antes crearIntefaz");
        
        try {
           info = gi.crearInterfaz(info);
           info.setDescripcionLote(dtoEntrada.getDescripcion());
           info.setObservaciones(dtoEntrada.getObservaciones());
        } catch (InterfacesException ie) {
           UtilidadesLog.error("Excepcion de la Interfaz: " + ie.getMotivo() ,ie); 
        } catch(RemoteException ne){
           UtilidadesLog.debug("error RemoteException");
           throw new MareException(ne,
                  UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }            
        UtilidadesLog.debug("Despues de crear Interfaz: "+info);
        
        try { 
            gi.enviarInterfaz(info);
        } catch(InterfacesException iex) {
      
         DTOINTError dtoError = new DTOINTError(info, null, ErroresDeNegocio.INT_0009 + info.getCodigoInterfaz() + "Lote: " + info.getNumeroLote()); 
         try {
                gi.registrarError(dtoError); 
             } catch(InterfacesException iex2) {   
                ctx.setRollbackOnly();                
                UtilidadesLog.debug("***** MONINTSAPFI.generarApuntesContablesFAC: error InterfacesException");
                // falta codigo registrar error
                throw new MareException(iex2, UtilidadesError.armarCodigoError(iex2.getMotivo()));
             } catch (RemoteException ne) {
                ctx.setRollbackOnly();                
                UtilidadesLog.debug("***** MONINTSAPFI.generarApuntesContablesFAC: error RemoteException");
                // falta codigo registrar error
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
             }
        } catch (RemoteException ne) {
             ctx.setRollbackOnly();             
             UtilidadesLog.debug("***** MONINTSAPFI.generarApuntesContablesFAC: error RemoteException");
             throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ));
        }      
        
        UtilidadesLog.info("MONINTSAPFIBean.gestionarIntVacia(): Salida");
        
    }
    
    
    /**
     * @Módulo:  INT
     * @Fecha:   03/11/2005
     * @Autor:   Paola Cabrera
     * @Observaciones;  Se ha agregado este metodo dada la incidencia 21244
     * 
     * @cambio por performance
     * @autor gdmarzi
     * Se actualiza mediante una query masiva. Se trabaja con criterios de seleccion usados 
     * para obtener los ducumentos contables tratados para la zona dada y 
     * que poseen numero lote contable nulo.
     *  @mejora incidencia 20070233 se agrega filtro fechaHasta
     *  @autor gdmarzi
     */
    private void actualizarCabecera(Long oidZona, Date fechaHasta) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.actualizarCabecera(): Entrada");
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector();
    		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        consulta.append(" UPDATE fac_docum_conta_cabec ");
        consulta.append(" SET ");
        consulta.append("   num_lote_cont = ?, ");
        parametros.add(this.getNumeroLote());
        consulta.append("   fec_cont = SYSDATE ");
        consulta.append(" WHERE ");
        consulta.append("   pais_oid_pais = " + this.getPais());
        consulta.append("   AND num_lote_cont IS NULL ");
        consulta.append("   AND zzon_oid_zona = " + oidZona);
        if (fechaHasta != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date dFechaHasta = new java.sql.Date(fechaHasta.getTime());
            String sFechaHasta = sdf.format(dFechaHasta);
            consulta.append("   AND trunc(fec_fact) <= TO_DATE (?, 'YYYY-MM-DD') " );    
            parametros.add(sFechaHasta);
        }      

        try {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch(Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;         
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }     
        UtilidadesLog.info("MONINTSAPFIBean.actualizarCabecera(): Salida");
    }

   
    private CabeceraDocumentoContableLocalHome getCabeceraDocumentoContableLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (CabeceraDocumentoContableLocalHome)context.lookup("java:comp/env/CabeceraDocumentoContable");
    }
    
   /* private ImportesContabilizacionLocalHome getImportesContabilizacionLocalHome() throws MareException
    {
        UtilidadesLog.info("MONImpresionSICCBean.getImportesContabilizacionLocalHome(): Entrada");
        ImportesContabilizacionLocalHome importesContabilizacionLocalHome = (ImportesContabilizacionLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ImportesContabilizacion");
   		UtilidadesLog.info("MONImpresionSICCBean.getImportesContabilizacionLocalHome(): Salida");
        return importesContabilizacionLocalHome;
    }*/
    private ArrayList cambioDeNulos (ArrayList arrayDTOs, Boolean poneoSaca) throws MareException {
        
         String relleno = "#$#|#$#";
         Long rellenoLon = new Long(-9);
        if(poneoSaca.equals(Boolean.TRUE)){
        
            for(int i=0;i<arrayDTOs.size();i++)  {
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoAcceso()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoAcceso(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoCanal()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoCanal(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoCicloVida()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoCicloVida(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoCliente()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoCliente(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoEmpresa()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoEmpresa(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoGrupoProductos()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoGrupoProductos(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoImporteAContabilizar()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoImporteAContabilizar(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoMarcaProducto()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoMarcaProducto(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoNegocio()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoNegocio(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoPais()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoPais(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoPeriodo()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoPeriodo(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoProducto()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoProducto(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoSubacceso()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoSubacceso(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoTipoOferta()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoTipoOferta(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoTipoPeriodo()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoTipoPeriodo(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getDescripcionCanal()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setDescripcionCanal(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getEjercicioComercial()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setEjercicioComercial(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getRUC()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setRUC(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getTipoAsiento()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setTipoAsiento(relleno);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getTipoMovimientoSAPFI()==null){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setTipoMovimientoSAPFI(relleno);
                }
            }
        }else{
            
                        for(int i=0;i<arrayDTOs.size();i++)  {
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoAcceso().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoAcceso(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoCanal().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoCanal(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoCicloVida().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoCicloVida(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoCliente().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoCliente(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoEmpresa().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoEmpresa(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoGrupoProductos().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoGrupoProductos(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoImporteAContabilizar().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoImporteAContabilizar(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoMarcaProducto().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoMarcaProducto(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoNegocio().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoNegocio(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoPais().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoPais(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoPeriodo().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoPeriodo(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoProducto().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoProducto(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoSubacceso().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoSubacceso(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoTipoOferta().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoTipoOferta(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getCodigoTipoPeriodo().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setCodigoTipoPeriodo(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getDescripcionCanal().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setDescripcionCanal(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getEjercicioComercial().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setEjercicioComercial(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getRUC().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setRUC(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getTipoAsiento().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setTipoAsiento(null);
                }
                if(((DTOINTDocumentoContable)arrayDTOs.get(i)).getTipoMovimientoSAPFI().equals(relleno)){
                    ((DTOINTDocumentoContable)arrayDTOs.get(i)).setTipoMovimientoSAPFI(null);
                }
         }
       
      }
    return arrayDTOs;
    }
  
  
  /**
   * Se queda con un unico registro por cada oid de cabecera de documento contable.
   */
  private ArrayList eliminarCabecerasIguales(ArrayList listaSinAcumular) throws MareException {
      ArrayList listaAcumulada = new ArrayList();
      DTOINTDocumentoContable dtoNoAgrupado;
      DTOINTDocumentoContable dtoAgrupado;
      boolean encontrado;
      // metemos el primer elemento en la lista agrupada
      if (listaSinAcumular.size() > 0) {
          listaAcumulada.add((DTOINTDocumentoContable)listaSinAcumular.get(0));
      }
      for (int i=1; i < listaSinAcumular.size(); i++) {
         dtoNoAgrupado = (DTOINTDocumentoContable)listaSinAcumular.get(i);
         encontrado = false;
         for (int j=0; j < listaAcumulada.size(); j++) {
            dtoAgrupado = (DTOINTDocumentoContable)listaAcumulada.get(j);
            // se debe absorver la cabecera que ya esta en el listado
            if (dtoNoAgrupado.getOidCabecera().equals(dtoAgrupado.getOidCabecera())) {
               encontrado = true;
               break;
            }
         }
         if ( ! encontrado ) {
            listaAcumulada.add(dtoNoAgrupado);
         }
      }     
      return listaAcumulada;
    }


    /**
     * Creado por incidencia DBLG500001104
     * @author dmorello
     * @since 14-09-2006
     */
    public DTOSalida obtenerImportesContablesFAC() throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.obtenerImportesContablesFAC(): Entrada");
        DTOSalida dtoSalida = new DAOINTSAPFI().obtenerImportesContablesFAC();
        UtilidadesLog.info("MONINTSAPFIBean.obtenerImportesContablesFAC(): Salida");
        return dtoSalida;
    }
  
    /**
     * Creado por incidencia DBLG500001104
     * @author dmorello
     * @since 14-09-2006
     */
    public DTOSalida buscarParametrosContablesFAC(DTOParametrosContablesFAC dtoE) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.buscarParametrosContablesFAC(DTOParametrosContablesFAC dtoE): Entrada");
        DTOSalida dtoSalida = new DAOINTSAPFI().buscarParametrosContablesFAC(dtoE);
        UtilidadesLog.info("MONINTSAPFIBean.buscarParametrosContablesFAC(DTOParametrosContablesFAC dtoE): Salida");
        return dtoSalida;
    }
  
    /**
     * Creado por incidencia DBLG500001104
     * @author dmorello
     * @since 14-09-2006
     */
    public void actualizarParametrosContablesFAC(DTOParametrosContablesFAC dtoe) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.actualizarParametrosContablesFAC(DTOParametrosContablesFAC dtoe): Entrada");
        UtilidadesLog.debug("DTOParametrosContablesFAC recibido: " + dtoe);
        
        MaestroProductosLocalHome mpHome = this.getMaestroProductosLocalHome();
        MaestroProductosLocal mpLocal = null;

        // Valido el codigo de producto
        Long oidProducto = null;
        if (dtoe.getCodProductoSAP() != null && dtoe.getCodProductoSAP().length() > 0) {
            try {
                mpLocal = mpHome.findByUK(dtoe.getOidPais(), dtoe.getCodProductoSAP());
                oidProducto = mpLocal.getOid();
            } catch (ObjectNotFoundException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT, "", ErroresDeNegocio.INT_0005));
            } catch (FinderException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.debug("oidProducto: " + oidProducto);
        
        ParametrosContablesLocalHome pcHome = this.getParametrosContablesLocalHome();
        ParametrosContablesLocal pcLocal = null;
        
        try {
            if (dtoe.getOid() == null) {
                // Creo la entidad
                pcLocal = pcHome.create(dtoe.getCodApunte(),        // String codigoApunte
                                        dtoe.getTipoAsiento(),      // String tipoAsiento,
                                        dtoe.getCabeceraDetalle(),  // String identificadorCabeceraDetalle
                                        dtoe.getDescripcion(),      // String descripcion
                                        dtoe.getDebeHaber(),        // String indicadorDebeHaber
                                        dtoe.getOidPais(),          // Long pais
                                        dtoe.getCuentaContable(),   // Long cuentaContable
                                        dtoe.getCodImporte());      // Long importeAContabilizar
                                        
                pcLocal.setGrupoArticulos(dtoe.getGrupoProductos());
                pcLocal.setMarcaProducto(dtoe.getMarcaProductos());
                pcLocal.setNegocio(dtoe.getNegocio());
                pcLocal.setProducto(oidProducto);
                pcHome.merge(pcLocal);
                UtilidadesLog.debug("Acabo de crear el entity, OID = " + pcLocal.getOid());
            } else {
                // Actualizo la entidad existente
                pcLocal = pcHome.findByPrimaryKey(dtoe.getOid());
                UtilidadesLog.debug("Actualizo el entity con OID " + dtoe.getOid());
                
                pcLocal.setTipoAsiento(dtoe.getTipoAsiento());
                pcLocal.setIdentificadorCabeceraDetalle(dtoe.getCabeceraDetalle());
                pcLocal.setDescripcion(dtoe.getDescripcion());
                pcLocal.setGrupoArticulos(dtoe.getGrupoProductos());
                pcLocal.setIndicadorDebeHaber(dtoe.getDebeHaber());
                pcLocal.setCuentaContable(dtoe.getCuentaContable());
                pcLocal.setImporteAContabilizar(dtoe.getCodImporte());
                pcLocal.setMarcaProducto(dtoe.getMarcaProductos());
                pcLocal.setNegocio(dtoe.getNegocio());
                pcLocal.setProducto(oidProducto);
                pcHome.merge(pcLocal);
                UtilidadesLog.debug("Ya actualice el entity");
            }
        } catch (NoResultException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONINTSAPFIBean.actualizarParametrosContablesFAC(DTOParametrosContablesFAC dtoe): Salida");
    }
  
    /**
     * Creado por incidencia DBLG500001104
     * @author dmorello
     * @since 14-09-2006
     */
    public void eliminarParametrosContablesFAC(DTOOIDs oids) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.eliminarParametrosContablesFAC(DTOOIDs oids): Entrada");
        try {
            ParametrosContablesLocalHome home = this.getParametrosContablesLocalHome();
            ParametrosContablesLocal pcLocal = null;
            
            for (int i = 0; i < oids.getOids().length; i++) {
                UtilidadesLog.debug("A punto de buscar el elemento de OID " + oids.getOids()[i]);
                pcLocal = home.findByPrimaryKey(oids.getOids()[i]);
                UtilidadesLog.debug("Se encontro el elemento");
                home.remove(pcLocal);
                UtilidadesLog.debug("Se elimino el elemento");
            }
        } catch (NoResultException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        
        UtilidadesLog.info("MONINTSAPFIBean.eliminarParametrosContablesFAC(DTOOIDs oids): Salida");
    }


    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.getMaestroProductosLocalHome(): Entrada");
        MaestroProductosLocalHome localHome = (MaestroProductosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MaestroProductos");
        UtilidadesLog.info("MONINTSAPFIBean.getMaestroProductosLocalHome(): Salida");
        return localHome;
    }

    /**
    * Actualización previa del campo Importe Redondeo.
    * Nota Funcional: el campo Importe Redondeo está actualizado por FAC de forma errónea: 
    * como es un campo que sólo utiliza SAP-FI, en esta actividad se actualizado de forma correcta 
    * este campo antes de procesar la interface como tal.
    * @autor gdmarzi
    */
    public void actualizarImporteRedondeo() throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.actualizarImporteRedondeo() Entrada");
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer query = new StringBuffer();
        query.append(" UPDATE fac_docum_conta_cabec cab ");
        query.append(" SET  imp_redo_docu = ");
        query.append("          (SELECT   SUM (dcl.val_prec_sin_impu_tota_docu) ");
        query.append("                  - SUM (dcl.val_prec_neto_tota_docu) ");
        query.append("                  - SUM (dcl.imp_desc_sin_impu_tota_docu) red_docum ");
        query.append("          FROM fac_docum_conta_cabec dcc, fac_docum_conta_linea dcl ");
        query.append("          WHERE dcc.oid_cabe = dcl.dcca_oid_cabe ");
        query.append("          AND dcc.oid_cabe = cab.oid_cabe), ");
        query.append("      imp_redo_loca = ");
        query.append("          (SELECT   SUM (dcl.val_prec_sin_impu_tota_loca) ");
        query.append("                  - SUM (dcl.val_prec_neto_tota_loca) ");
        query.append("                  - SUM (dcl.imp_desc_sin_impu_tota_loca) red_local ");
        query.append("          FROM fac_docum_conta_cabec dcc, fac_docum_conta_linea dcl ");
        query.append("          WHERE dcc.oid_cabe = dcl.dcca_oid_cabe ");
        query.append("          AND dcc.oid_cabe = cab.oid_cabe) ");
        query.append(" WHERE cab.num_lote_cont IS NULL ");
        try {
              bs.dbService.executeUpdate(query.toString());
              UtilidadesLog.warn("actualizarImporteRedondeo() ejecutado");
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONINTSAPFIBean.actualizarImporteRedondeo() Salida");
    }
    
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }

    private MonedaLocalHome getMonedaLocalHome() {
            return new MonedaLocalHome();
    }

    private CuentasContablesLocalHome getCuentasContablesLocalHome() {
            return new CuentasContablesLocalHome();
    }

    private TiposAbonoSubprocesoLocalHome getTiposAbonoSubprocesoLocalHome() {
            return new TiposAbonoSubprocesoLocalHome();
    } 
    
    private CuentasCorrientesLocalHome getCuentasCorrientesLocalHome() {
            return new CuentasCorrientesLocalHome();
    }

    private DatosSAPFILocalHome getDatosSAPFILocalHome() {
            return new DatosSAPFILocalHome();
    }

    private ParametrosContablesLocalHome getParametrosContablesLocalHome() {
            return new ParametrosContablesLocalHome();
    }


    // vbongiov -- Cambio 20090922 -- 28/05/2009

    public DTOSalidaBatch recepcionarImpuestosProdNacionales(DTOBatch dtoe) throws MareException {
        UtilidadesLog.info("MONINTSAPFIBean.recepcionarImpuestosProdNacionales(DTOBatch dtoe): Entrada");

        Long oidPais = null;
        IMareDTO dtoPais = (DTOString)dtoe.getDTOOnline();
        DTOOID dtoOid = new DTOOID();
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try{
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            oidPais = paisLocal.getOid();

        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.recepcionarImpuestosProdNacionales: FinderException, no existe Pais = "+dtoPais.getString("cadena"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

        }

        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        InterfazInfo interfaz=null;

        try {
          IRegistroSicc registro=null;
          String codigoSAP=null;
          BigDecimal impuestoProdNacional = null;
          MaestroProductosLocalHome maeProducLocalHome = getMaestroProductosLocalHome();
          MaestroProductosLocal maeProducLocal = null;
          Long oidProducto = null;
          Date fechaActualizacion = null;
          ImpuestoProductoNacionalLocalHome impuestoProductoNacionalLocalHome = new ImpuestoProductoNacionalLocalHome();
          ImpuestoProductoNacionalLocal impuestoProductoNacionalLocal = new ImpuestoProductoNacionalLocal();

          interfaz=gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAF2,paisLocal.getOid());

          while ((registro=gi.cargarRegistro(interfaz))!=null) {

            codigoSAP = (String)registro.obtenerCampo(IRegistroSicc.SAF2_CODIGO_SAP);
            if (codigoSAP==null || codigoSAP.trim().equals("")) {
                DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0011 + " codigoSAP");
                gi.registrarError(dtoError);
                continue;

            } else {
                try {
                    maeProducLocal = maeProducLocalHome.findByUK(oidPais, codigoSAP.trim());
                    oidProducto = maeProducLocal.getOid();

                } catch (FinderException fe) {
                  UtilidadesLog.debug("*** Error FinderException: " + codigoSAP.trim());
                  DTOINTError dtoError =new DTOINTError(interfaz,registro, "El código SAP no existe " + codigoSAP.trim());
                  gi.registrarError(dtoError);
                  continue;

                }
            }

            impuestoProdNacional = (BigDecimal)registro.obtenerCampo(IRegistroSicc.SAF2_IMPUESTO_PROD_NACIONAL);
            if (impuestoProdNacional==null){
                impuestoProdNacional = new BigDecimal(0);
            }

            fechaActualizacion = (Date)registro.obtenerCampo(IRegistroSicc.SAF2_FECHA_ACTUALIZACION);

            // Verifica si el registro ya existe
            try {
                impuestoProductoNacionalLocal = impuestoProductoNacionalLocalHome.findByCodSAPYFecha(oidProducto, new java.sql.Date(fechaActualizacion.getTime()));

                impuestoProductoNacionalLocal.setImpuestoProdNacional(impuestoProdNacional);
                impuestoProductoNacionalLocalHome.merge(impuestoProductoNacionalLocal);

            } catch (NoResultException fex) {

                    // No existe el registro se crea
                    try {
                        UtilidadesLog.debug("No existe el registro");
                        impuestoProductoNacionalLocal = impuestoProductoNacionalLocalHome.create(oidProducto);
                        impuestoProductoNacionalLocal.setImpuestoProdNacional(impuestoProdNacional);
                        impuestoProductoNacionalLocal.setFechaCarga(new java.sql.Date(fechaActualizacion.getTime()));

                        impuestoProductoNacionalLocalHome.merge(impuestoProductoNacionalLocal);

                    } catch(PersistenceException ce) {
                        UtilidadesLog.error("*** Error create: ", ce);
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Impuesto Producto Nacional " + "Exception: " + ce.getMessage());
                        gi.registrarError(dtoError);
                        continue;
                    }//fin try

             }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
             }
          }//fin while

        } catch (RemoteException re) {
              ctx.getRollbackOnly();
              UtilidadesLog.error("***MONINTSAPFIBean.recepcionarImpuestosProdNacionales: error RemoteException");
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
              ie.printStackTrace();
              ctx.getRollbackOnly();
              UtilidadesLog.error("***ACABA CASO DE USO MONINTSAPFIBean.recepcionarImpuestosProdNacionales: error InterfacesException");
              return null;
        }

        UtilidadesLog.info("MONINTSAPFIBean.recepcionarImpuestosProdNacionales(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0,"Proceso recepcionarImpuestosProdNacionales finalizado");
    }
}
