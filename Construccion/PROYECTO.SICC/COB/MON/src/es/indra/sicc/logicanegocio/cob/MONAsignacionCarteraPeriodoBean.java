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

package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.cob.DTOAsignacionCobranza;
import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.dtos.cob.DTOCuotasAsignacion;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.cob.AsignacionCobranzaLocal;
import es.indra.sicc.entidades.cob.CronogramaCobranzaLocalHome;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.HashMap;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOColeccion;
import java.util.ArrayList;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOConsultarAsignacionCartera;
import es.indra.sicc.dtos.cob.DTOEBuscarEtapas;
import es.indra.sicc.dtos.cob.DTOActualizacionCartera;
import es.indra.sicc.dtos.cob.DTOConsultarResumenAsignacion;
import es.indra.sicc.entidades.cob.AsignacionCobranzaLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.entidades.cob.EtapasDeudaLocalHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;

import java.util.Collections;

import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocal;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocalHome;

import java.util.Vector;
import java.util.Iterator;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONAsignacionCarteraPeriodoBean implements SessionBean 
{
  SessionContext ctx = null;
  
  //-------------------------- VARIABLES DE ASIGNACION DE CARTERA PARA PERIODO ---------------------------------------
  Long clienteActual = null;
  Long cronoCronoUsuActual = null;
  Long oidCronoUsuActual = null;  
  BigDecimal totalActual = null;
  BigDecimal totalSaldoCuotasEtapaActual = new BigDecimal (0);
  BigDecimal totalAsignarASupervisor = null;
  private static HashMap hashIdSupervisor = null;
  int cronoUsuPos = 0;  
  //------------------------------------------------------------------------------------------------------------------
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
    this.ctx = ctx;
  }

   //05/11/2007, se modifica el metodo en el marco, de: pet cbio. 7 (469)
   public void asignarCarteraPeriodo(DTOColeccion dto) throws MareException{
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCarteraPeriodo(DTOColeccion dto): Entrada");
      //Este metodo se crea para reemplazar el metodo original
      //el cual no cumple con la funcionalidad requerida.
      ArrayList lista = dto.getLista();
      int largo = lista.size();
      if(largo==0){
         return;
      }
      
      //verifico exist de us. sup. activo (pet cbio. 7 SCS)
      DAOAsignacionCarteraPeriodo daoAsignCarPeri = new DAOAsignacionCarteraPeriodo();
      Long usuaSuper = daoAsignCarPeri.verifExistUsSup(dto.getOidPais().longValue());
      if (usuaSuper==null){
          UtilidadesLog.debug("no existe usua supervisor");
          throw new MareException(null, null, 
                                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_017));      
      } 
      
      Long oidPais = ((DTOCronogramaCobranza)lista.get(0)).getOidPais();
      Long oidIdioma = ((DTOCronogramaCobranza)lista.get(0)).getOidIdioma();
      Long oidUsuarioSupervisorPais = obtenerUsuarioSupervisor(oidPais);
      Long oidPeriodo = ((DTOCronogramaCobranza)lista.get(0)).getOidPeriodo();
      
      ArrayList cronoOrdenados = new ArrayList();
      for(int i=0; i<largo; i++){
         DTOCronogramaCobranza dtoCC = (DTOCronogramaCobranza)lista.get(i);
            if (dtoCC.getOidSubgerenciaVentas()==null)
                dtoCC.setOidSubgerenciaVentas(new Long(0));
            if (dtoCC.getOidRegion()==null)
                dtoCC.setOidRegion(new Long(0));
            if (dtoCC.getOidZona()==null)
                dtoCC.setOidZona(new Long(0)); 
            if (dtoCC.getOidSeccion()==null)
                dtoCC.setOidSeccion(new Long(0));
            if (dtoCC.getOidTerritorio()==null)
                dtoCC.setOidTerritorio(new Long(0));             
         cronoOrdenados.add(dtoCC);
      }   
      
      UtilidadesLog.debug("cronoOrdenados, antes de ord., mide " + cronoOrdenados.size());
      //ordeno de lo + especifico a lo mas gral.
      Collections.sort(cronoOrdenados, new cronogramasComparator()); 
      //agrupo los criterios para obtener el distinct
      largo = cronoOrdenados.size();
      for(int i=0; i<largo; i++){
         DTOCronogramaCobranza dtoCCob = (DTOCronogramaCobranza)cronoOrdenados.get(i);
         UtilidadesLog.debug("ordenadas: " + 
                                 dtoCCob.getOidEtapa() + "-" + 
                                 dtoCCob.getOidSubgerenciaVentas() + "-" + 
                                 dtoCCob.getOidRegion() + "-" + 
                                 dtoCCob.getOidZona() + "-" + 
                                 dtoCCob.getOidSeccion() + "-" + 
                                 dtoCCob.getOidTerritorio());
      }      
      try {
          //voy armando una consulta por cada "registro" seleccionado en la pantalla
          for(int i=0; i<largo; i++) {
              DTOCronogramaCobranza dtoCroCob = (DTOCronogramaCobranza)cronoOrdenados.get(i);
              StringBuffer queryCuotasEtapa = new StringBuffer();
              
              UtilidadesLog.debug("meto en consulta: " + 
                                   dtoCroCob.getOidEtapa() + "-" + 
                                   dtoCroCob.getOidSubgerenciaVentas() + "-" + 
                                   dtoCroCob.getOidRegion() + "-" + 
                                   dtoCroCob.getOidZona() + "-" + 
                                   dtoCroCob.getOidSeccion() + "-" + 
                                   dtoCroCob.getOidTerritorio());          
              
              queryCuotasEtapa.append(" SELECT m.OID_MOVI_CC,m.IMP_MOVI as IMPORTEINICIAL, m.IMP_PEND AS IMPORTEPENDIENTE, ");
              queryCuotasEtapa.append(" m.NUM_IDEN_CUOT AS NUMEROIDENTIFICADOR, m.NUM_ORDE_CUOT AS NUMEROORDEN, ");
              queryCuotasEtapa.append(" m.CLIE_OID_CLIE AS CLIENTE, e.OID_ETAP_DEUD AS ETAPA, m.MARC_OID_MARC AS MARCA, ");
              queryCuotasEtapa.append(" m.SOCI_OID_SOCI AS SOCIEDAD, m.SBAC_OID_SBAC AS SUBACCESO, ");
              queryCuotasEtapa.append(" m.ZORG_OID_REGI AS REGION, zc.ZZON_OID_ZONA AS ZONA, m.ZSCC_OID_SECC AS SECCION, ");
              queryCuotasEtapa.append(" m.ZSGV_OID_SUBG_VENT AS SUBGERENCIAVENTAS, m.ZTAD_OID_TERR_ADMI AS TERRITORIO, zta.terr_oid_terr territorioReal, ");
              queryCuotasEtapa.append(" E.IND_TELF AS TELEFONOETAPA, m.TCAB_OID_TCAB_CREA AS TIPOCARGO, ");
              queryCuotasEtapa.append(" m.PERD_OID_PERI AS PERIODO, ");
              queryCuotasEtapa.append(" (select count(*) from mae_clien_comun mcc, mae_tipo_comun mtc ");
              queryCuotasEtapa.append(" where    mtc.OID_TIPO_COMU = mcc.TICM_OID_TIPO_COMU ");
              queryCuotasEtapa.append(" AND mtc.COD_TIPO_COMU = ?").append(" AND mcc.CLIE_OID_CLIE = m.CLIE_OID_CLIE ) as TELEFONO, ");
              queryCuotasEtapa.append(" sum(m.IMP_PEND) over(partition by m.CLIE_OID_CLIE) as DEUDATOTALCLIENTEETAPA, ");
              queryCuotasEtapa.append(" e.TBAL_OID_TIPO_BALA as TIPOBALANCEO, E.IMP_DESD IMPORTEDESDE, E.IMP_HAST IMPORTEHASTA, ");
              queryCuotasEtapa.append(" E.VAL_EDAD_INIC EDADDESDE,  E.VAL_EDAD_FINA EDADHASTA ");
              queryCuotasEtapa.append(" FROM ccc_movim_cuent_corri m, ");
              queryCuotasEtapa.append(" cob_etapa_deuda e, zon_secci zc ");      
          
              queryCuotasEtapa.append(" , ZON_TERRI_ADMIN zta ");
          
              queryCuotasEtapa.append(" WHERE E.OID_ETAP_DEUD = ? ");
              queryCuotasEtapa.append(" AND TRUNC (SYSDATE) >= m.fec_venc + e.val_edad_inic ");
              queryCuotasEtapa.append(" AND TRUNC (SYSDATE) <= m.fec_venc + e.val_edad_fina ");
              queryCuotasEtapa.append(" AND m.masi_oid_marc_situ IN ( ");
              queryCuotasEtapa.append(" SELECT mta.masi_oid_marc_sali ");
              queryCuotasEtapa.append(" FROM ccc_proce p,  ccc_subpr sp, ccc_tipo_abono_subpr tas, ccc_marca_tipo_abono mta ");
              queryCuotasEtapa.append(" WHERE p.cod_proc = ? ");
              queryCuotasEtapa.append(" AND p.oid_proc = sp.ccpr_oid_proc ");
              queryCuotasEtapa.append(" AND tas.subp_oid_subp = sp.oid_subp AND mta.tasp_oid_tipo_abon_subp = tas.oid_tipo_abon_subp ");
              queryCuotasEtapa.append(" AND mta.ind_entr_sali = ?) ");
              queryCuotasEtapa.append(" AND m.TCAB_OID_TCAB_CREA in(");      
          
              StringBuffer query2 = new StringBuffer(") ");
              query2.append(" AND e.ind_excl = ? ");
              query2.append(" AND m.perd_oid_peri = ?");
              query2.append(" AND m.IMP_PEND <> 0 AND zc.OID_SECC = m.ZSCC_OID_SECC");      
          
              Long etapaActual = dtoCroCob.getOidEtapa();
              UtilidadesLog.debug("Tratando etapa: "+etapaActual);
    
              Vector parametros = new Vector();
              parametros.add(ConstantesMAE.TIPO_COMUNICACION_TFNO_STRING);
              parametros.add(etapaActual);
              parametros.add(CCCConstantes.PROCESO_CON001);
              parametros.add(CCCConstantes.MARCA_ENTRADA);
    
             HashMap HashTiposAbonos=new HashMap();
             ArrayList cronogramasEtapaActual = new ArrayList();
             for(int j=0; j< largo;j++){
                DTOCronogramaCobranza dtoActual = (DTOCronogramaCobranza)cronoOrdenados.get(j);
                if(dtoActual.getOidEtapa().longValue()==etapaActual.longValue()){
                   HashTiposAbonos.put(dtoActual.getOidTipoCargo(),null);   
                   cronogramasEtapaActual.add(dtoActual);
                }
             }
             
             UtilidadesLog.debug("- GA - Cronogramas de la etapa: ");
             for(int n=0; n<cronogramasEtapaActual.size();n++){
                UtilidadesLog.debug(n+":"+ (DTOCronogramaCobranza)cronogramasEtapaActual.get(n));
             }
             
             Iterator itTiposAbonos = HashTiposAbonos.keySet().iterator();
             StringBuffer signitos = new StringBuffer();
             while(itTiposAbonos.hasNext()){
                Long tipoAbono = (Long)itTiposAbonos.next();
                signitos.append("?");
                parametros.add(tipoAbono);
                if(itTiposAbonos.hasNext()){
                   signitos.append(",");
                }
             }
             parametros.add(new Long(1));
             parametros.add(oidPeriodo);
             
             queryCuotasEtapa.append(signitos).append(query2);
             queryCuotasEtapa.append(" AND m.ZTAD_OID_TERR_ADMI = zta.OID_TERR_ADMI ");
             
             if (dtoCroCob.getOidSubgerenciaVentas().longValue()!=0){
                 queryCuotasEtapa.append(" AND m.zsgv_oid_subg_vent = " + dtoCroCob.getOidSubgerenciaVentas().longValue());     
             }
             if (dtoCroCob.getOidRegion().longValue()!=0){
                 queryCuotasEtapa.append(" AND m.zorg_oid_regi = " + dtoCroCob.getOidRegion().longValue());     
             }
             if (dtoCroCob.getOidZona().longValue()!=0){
                 queryCuotasEtapa.append(" AND zc.zzon_oid_zona = " + dtoCroCob.getOidZona().longValue());     
             }
             if (dtoCroCob.getOidSeccion().longValue()!=0){
                 queryCuotasEtapa.append(" AND m.zscc_oid_secc = " + dtoCroCob.getOidSeccion().longValue());     
             }
             if (dtoCroCob.getOidTerritorio().longValue()!=0){
                 queryCuotasEtapa.append(" AND  zta.terr_oid_terr = " + dtoCroCob.getOidTerritorio().longValue());     
             }
             queryCuotasEtapa.append(" order by m.clie_oid_clie ");
             
             RecordSet cuotas = new RecordSet();
             try{
                cuotas = BelcorpService.getInstance().dbService.executePreparedQuery(queryCuotasEtapa.toString(),parametros);
             }catch(Exception e){
                if(e instanceof MareException){
                   throw (MareException)e;
                }else{
                   throw new MareException(e);   
                }
             }
             
             UtilidadesLog.debug("query grossa: " + queryCuotasEtapa.toString());
             UtilidadesLog.debug("rdo.: " + cuotas);
             
             if(cuotas.esVacio()){
                UtilidadesLog.debug("cuotas, vacio!");
                continue;
             }
             ArrayList arrayCuotas = armarArrayCuotas(cuotas);
             
             UtilidadesLog.debug("- GA - Largo de cuotas: "+arrayCuotas.size());
             
             //ya tengo el total de la deuda a procesar para la etapa. Comienzo el tratamiento
             int largoCuotas = arrayCuotas.size();
             for(int k=0; k<largoCuotas;k++){
                 DTOCuotasAsignacion dtoCuotaActual = (DTOCuotasAsignacion)arrayCuotas.get(k);
                 UtilidadesLog.debug("Tratando cuota: "+dtoCuotaActual);
                 /////////////////////////////////////////////////
                 
                 //si tiene deuda en etapas anteriores la reasigno
                 //modificado por Sapaza, fecha 27-12-2007, incidencia SiCC-20070538, se envia el oidCuota
                 //reasignarEnEtapasAnteriores(dtoCuotaActual.getOidCliente(), dtoCuotaActual.getEdadEtapaDesde() );
                 reasignarEnEtapasAnteriores(dtoCuotaActual.getOidMovCC(), dtoCuotaActual.getEdadEtapaDesde() );
                 
                 //Si la cuota ya esta asignada en la etapa a procesar, paso a la siguiente.
                 //etapa igual!.
                 if(existeEnEtapa(dtoCuotaActual.getOidMovCC(),dtoCuotaActual.getOidEtapa()).booleanValue()){
                    continue;//siguiente cuota
                 }
                 ////////////////////////////////////////////////
                 //verifico la existencia de una etapa posterior para el cliente
                 RecordSet rsEtapasPosteriores = encontrarEtapasPosteriores(dtoCuotaActual.getOidCliente(), dtoCuotaActual.getEdadEtapaDesde());
                 if(!rsEtapasPosteriores.esVacio()){
                    //existe en etapa posterior, me fijo si tengo que insertar
                    int largoEtapasPosteriores = rsEtapasPosteriores.getRowCount();
                    for(int j=0; j<largoEtapasPosteriores; j++){
                       Long movCC = new Long(rsEtapasPosteriores.getValueAt(j, "MVCC_OID_MOVI_CC").toString());
                       if(dtoCuotaActual.getOidMovCC().longValue()==movCC.longValue()){
                           UtilidadesLog.debug("no coinciden los oid de moviemiento de CC, siguiente cuota...");
                          continue;//ya existe, siguiente cuota;
                       }
                    }
                    //si llegue ak no existe, inserto en asignacion de cobranzas
                    //usando los datos del primer registro, ya que la deuda se
                    //asigna siempre al mismo cronograma.
                    Long oidCronograma = new Long(rsEtapasPosteriores.getValueAt(0, "CRCO_OID_CRON_COBR").toString());
                    //insertarDeudaPosterior(dtoCuotaActual, oidCronograma, oidPais );
                    //cbio. 7
                    UtilidadesLog.debug("voy a insertar deuda posterior...........(antes recupero ID de Cartera!)");
                    insertarDeudaPosterior(dtoCuotaActual, this.recuperoIdCartera(dtoCuotaActual, oidPais, usuaSuper, oidIdioma, oidPeriodo), oidPais);
                    continue;//siguiente registro
                 }
                
                 //las siguientes 2 validaciones estan planteadas segun cambia el cliente,
                 //pero por disposicion de datos, es mas simple hacerlo cuota a cuota.
                 if(dtoCuotaActual.getImporteDesdeEtapa().doubleValue()>dtoCuotaActual.getDeudaTotalCliente().doubleValue()||
                    dtoCuotaActual.getImporteHastaEtapa().doubleValue()<dtoCuotaActual.getDeudaTotalCliente().doubleValue()){
                    //asignar al usuario supervisor
                    UtilidadesLog.debug("dif. de importes, voy a: buscarCronogramaSupervisor(...");
                    DTOCronogramaCobranza dtoSup = buscarCronogramaSupervisor(dtoCuotaActual, oidUsuarioSupervisorPais,
                                                                              oidPais,oidIdioma,oidPeriodo);
                    UtilidadesLog.debug("dtoSup: " + dtoSup);
                    ArrayList listaSup = new ArrayList();
                    listaSup.add(dtoSup);
                    UtilidadesLog.debug("dif. de importes, voy a: asignarCuotaCronograma(...");
                    asignarCuotaCronograma(dtoCuotaActual, listaSup);
                    UtilidadesLog.debug("cont. con otra 1!");
                    continue;
                 } 
                 if(dtoCuotaActual.getTelefonoEtapa().booleanValue() && 
                    !dtoCuotaActual.getTelefonoCliente().booleanValue()){
                    //asignar al usuario supervisor
                    UtilidadesLog.debug("dif. de telefonos, voy a: buscarCronogramaSupervisor(...");
                    DTOCronogramaCobranza dtoSup = buscarCronogramaSupervisor(dtoCuotaActual, oidUsuarioSupervisorPais,
                                                                              oidPais,oidIdioma,oidPeriodo);
                    UtilidadesLog.debug("dtoSup: " + dtoSup);                                                                              
                    ArrayList listaSup = new ArrayList();
                    listaSup.add(dtoSup);
                    UtilidadesLog.debug("dif. de telefonos, voy a: asignarCuotaCronograma(...");
                    asignarCuotaCronograma(dtoCuotaActual, listaSup);
                    UtilidadesLog.debug("cont. con otra 2!");
                    continue;
                 }
                 UtilidadesLog.debug("asignarCuotaCronograma(....");
                 asignarCuotaCronograma(dtoCuotaActual, cronogramasEtapaActual);
             } 
             //Balanceo
             UtilidadesLog.debug("BalancearCuotas(....");
             BalancearCuotas(arrayCuotas, cronogramasEtapaActual,((DTOCuotasAsignacion)arrayCuotas.get(0)).getTipoBalanceoEtapa().longValue() );
             //ahora grabo las cuotas en cob_asign_cobra
             UtilidadesLog.debug("grabarAsignacionCuotas(....");
             grabarAsignacionCuotas(arrayCuotas,oidPais);
             
             
             UtilidadesLog.debug("Paso a sgte. registro de pantalla!");
          }
      }catch(Exception e){
          e.printStackTrace();
          if(e instanceof MareException){
              throw (MareException)e;
          }else{
              throw new MareException(e);
          }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCarteraPeriodo(DTOColeccion dto): Salida");
   }

   
   private void BalancearCuotas(ArrayList cuotas, ArrayList cronogramas, long tipoBalanceo){
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.BalancearCuotas(ArrayList cuotas, ArrayList cronogramas, long tipoBalanceo): Entrada");
      //Segun el tipo de Balanceo armo los arrayList de Balanceo.
      BigDecimal mediaAsignar = null;
      
      HashMap cuotasZonificadas = agruparCuotasXZonificacion(cuotas);
      Iterator itZonas = cuotasZonificadas.keySet().iterator();
      UtilidadesLog.debug("cuotasZonificadas, mide: " + cuotasZonificadas.size());
      while(itZonas.hasNext()){
         String zonificacion = itZonas.next().toString();
         UtilidadesLog.debug("- GA - La zonficacion actual es: "+zonificacion);
         ArrayList cuotasZona = (ArrayList)cuotasZonificadas.get(zonificacion);
         if(cuotasZona.size()<=1){//nada que balancear
            UtilidadesLog.debug("cuotasZona.size()<=1");
            continue;
         }
         ArrayList cronogramasZona = obtenerCronogramasXZonificacion(zonificacion,cronogramas);
         if(cronogramasZona.size()<=1){
            UtilidadesLog.debug("cronogramasZona.size()<=1");
            continue;
         }
         if(ConstantesCOB.TIPO_BALANCEO_CONSULTORA.longValue()==tipoBalanceo){
            mediaAsignar = new BigDecimal("999999999.99");
         }else{
            mediaAsignar = new BigDecimal("0");
            int largoCuotas = cuotasZona.size();
            for(int n=0; n<largoCuotas;n++){
               mediaAsignar = mediaAsignar.add(((DTOCuotasAsignacion)cuotasZona.get(n)).getImportePendiente());
            }
            mediaAsignar = mediaAsignar.divide(new BigDecimal(cronogramasZona.size()),2,BigDecimal.ROUND_HALF_UP);
         }
         UtilidadesLog.debug("mediaAsignar es: " + mediaAsignar);
         UtilidadesLog.debug("voy a aplicarBalanceo");
         aplicarBalanceo(cuotasZona,cronogramasZona,mediaAsignar);
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.BalancearCuotas(ArrayList cuotas, ArrayList cronogramas, long tipoBalanceo): Salida");
   }
   
   private void aplicarBalanceo(ArrayList cuotas, ArrayList cronogramas, BigDecimal media){
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.aplicarBalanceo(ArrayList cuotas, ArrayList cronogramas, BigDecimal media): Entrada");
      //tengo las cuotas y cronogramas correspondientes a la misma zonificacion
      //debo balancear la asignacion de cuotas hasta llegar al limite marcado
      //por la variable media. Una vez que el cronograma llegue a la media, dejo de asignarle cuotas.
      int largo = cuotas.size();
      int cronogramaActual=0;
      int largoCronogramas = cronogramas.size();
      boolean primerAsignacion = true;
      
      //para el null
      for(int i=0; i<largoCronogramas;i++){
         DTOCronogramaCobranza dtoCrono = (DTOCronogramaCobranza)cronogramas.get(i);
         dtoCrono.setImporteAsignado(new BigDecimal("0"));
         dtoCrono.setAsignadoEnExceso(new Boolean(false));
      }

      UtilidadesLog.debug("- GA - Comenzamos el balanceo para "+cronogramas.size()+" cronogramas");
      for(int i=0; i< largo; i++){
         DTOCuotasAsignacion dto = (DTOCuotasAsignacion)cuotas.get(i);
         UtilidadesLog.debug("- GA - Cuota: "+dto.getOidMovCC());
         BigDecimal importe = dto.getImportePendiente();
         if(i>0 && (i%largoCronogramas)==0 ){
            UtilidadesLog.debug("- GA - Reinicio el control de conogramas");
            cronogramaActual = 0;
            primerAsignacion = false;
         }
         DTOCronogramaCobranza dtoCrono = (DTOCronogramaCobranza)cronogramas.get(cronogramaActual);
         UtilidadesLog.debug("- GA - Cronograma actual: "+dtoCrono.getOidCobranza());
         if(i+1<largo){//si no es la ultima cuota
            UtilidadesLog.debug("- GA - no es la ultima cuota");
            if(!primerAsignacion){//si no es la primer asignacion, tengo en cuenta el pago en exceso
                UtilidadesLog.debug("- GA - no es la primera asignacion");
                if((cronogramaActual%2)==0){//las pares no pagan en exceso
                    UtilidadesLog.debug("- GA - NO paga en exceso");
                    if((dtoCrono.getImporteAsignado().doubleValue()+ importe.doubleValue() )<media.doubleValue() ){
                        UtilidadesLog.debug("- GA - se asigna sin exceso");
                        dto.setOidConograma(dtoCrono.getOidCobranza());
                        dtoCrono.setImporteAsignado(dtoCrono.getImporteAsignado().add(importe).setScale(2,BigDecimal.ROUND_HALF_UP));
                    }else{
                        UtilidadesLog.debug("- GA - No se asigna porq se excederia");
                    }
                }else{//las impares pagan en exceso
                    UtilidadesLog.debug("- GA - SI paga en exceso");
                    if(!dtoCrono.getAsignadoEnExceso().booleanValue()){//siempre y cuando no esten ya excedidas
                        dtoCrono.setImporteAsignado(dtoCrono.getImporteAsignado().add(importe).setScale(2,BigDecimal.ROUND_HALF_UP));
                        dto.setOidConograma(dtoCrono.getOidCobranza());
                        if(dtoCrono.getImporteAsignado().doubleValue()>media.doubleValue()){
                           dtoCrono.setAsignadoEnExceso(new Boolean(true)); 
                        }
                    }else{
                        UtilidadesLog.debug("- GA - No se asigna porque ya esta excedida");
                    }
                }
            }else{//la primer vuelta, asigno sin preguntar nada.
                UtilidadesLog.debug("- GA - Es la primera asignacion");
                 dto.setOidConograma(dtoCrono.getOidCobranza());
                 dtoCrono.setImporteAsignado(dtoCrono.getImporteAsignado().add(importe).setScale(2,BigDecimal.ROUND_HALF_UP));
                 if(dtoCrono.getImporteAsignado().doubleValue()>media.doubleValue()){
                   dtoCrono.setAsignadoEnExceso(new Boolean(true)); 
                 }
            }
         }else{//es la ultima, busco al que menos asigne y se la asigno a ese.
            UtilidadesLog.debug("- GA - Es la ultima cuota. Asigno al que tenga menos");
             DTOCronogramaCobranza dtoCronoMenor = (DTOCronogramaCobranza)cronogramas.get(0);
             for(int n=1; n<largoCronogramas;n++){
                 if(((DTOCronogramaCobranza)cronogramas.get(n)).getImporteAsignado().doubleValue() < 
                                        dtoCronoMenor.getImporteAsignado().doubleValue()){
                     dtoCronoMenor = (DTOCronogramaCobranza)cronogramas.get(n);
                 }
             }
             dto.setOidConograma(dtoCronoMenor.getOidCobranza());
             dtoCronoMenor.setImporteAsignado(dtoCronoMenor.getImporteAsignado().add(importe).setScale(2,BigDecimal.ROUND_HALF_UP));
         }         
         cronogramaActual+=1;
      }
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.aplicarBalanceo(ArrayList cuotas, ArrayList cronogramas, BigDecimal media): Salida");
   }
   
   private ArrayList obtenerCronogramasXZonificacion(String zonificacion, ArrayList cronogramas){
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerCronogramasXZonificacion(String zonificacion, ArrayList cronogramas): Entrada");
      //en el arraylist de entrada, buscamos los cronogramas que cumplen con
      //la zonificacion necesaria y devolvemos el arrayList.
      //Siempre habra al menos uno.
      int largo = cronogramas.size();
      ArrayList salida = new ArrayList();
      for(int i=0; i<largo;i++){
         DTOCronogramaCobranza dto = (DTOCronogramaCobranza)cronogramas.get(i);
         String zonificacionCrono = obtenerStringNivelZonificacion(obtenerNivelZonificacion(dto),dto);
         if(zonificacionCrono.equals(zonificacion)){
            salida.add(dto);
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerCronogramasXZonificacion(String zonificacion, ArrayList cronogramas): Salida");
      return salida;      
   }

   private HashMap agruparCuotasXZonificacion(ArrayList cuotas){
     UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.agruparCuotasXZonificacion(ArrayList cuotas): Entrada");
      HashMap salida = new HashMap();
      int largo = cuotas.size();
      for(int i=0; i< largo; i++){
         DTOCuotasAsignacion dto = (DTOCuotasAsignacion)cuotas.get(i);
         if(dto.getOidConograma()!=null){
             String zonificacion = obtenerStringNivelZonificacion(dto.getNivelAsignado().intValue(),dto);
             ArrayList zona = (ArrayList)salida.get(zonificacion);
             
             UtilidadesLog.info("zonificacion: " + zonificacion);
             UtilidadesLog.info("zona: " + zona);
             
             if(zona == null){
                zona = new ArrayList();
                salida.put(zonificacion,zona);
             }
             zona.add(dto);
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.agruparCuotasXZonificacion(ArrayList cuotas): Salida");
      UtilidadesLog.info("retorno zonas: " + salida.size());
      return salida;
   }

   private void grabarAsignacionCuotas(ArrayList cuotas, Long oidPais)throws MareException{
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.grabarAsignacionCuotas(ArrayList cuotas, Long oidPais): Entrada");
      int largo = cuotas.size();

      StringBuffer buff = new StringBuffer();
      HashMap cronos = new HashMap();
      
      UtilidadesLog.info("voy a recorrer: " + largo + " cuotas!");

      for(int i=0; i<largo;i++){
         DTOCuotasAsignacion dto = (DTOCuotasAsignacion)cuotas.get(i);
         UtilidadesLog.debug("- GA - Cuota a grabar: " + dto);
         if(dto.getOidConograma()!=null){
            cronos.put(dto.getOidConograma(),null);
            buff.append("INSERT INTO COB_ASIGN_COBRA ( OID_ASIG_COBR, ");
            buff.append("IMP_ORIG_DEUD, IMP_DEUD_ASIG, IMP_DEUD_CANC, FEC_ASIG,");
            buff.append("PAIS_OID_PAIS, MVCC_OID_MOVI_CC,");
            buff.append("SOCI_OID_SOCI, CRCO_OID_CRON_COBR, ");
            buff.append("ESAS_OID_ESTA_ASIG, TCAB_OID_TIPO_CARG_ABON) VALUES (");      
            buff.append("COB_ASCO_SEQ.NEXTVAL,");
            buff.append(dto.getImporteOriginal().setScale(2,BigDecimal.ROUND_HALF_UP)).append(",");
            buff.append(dto.getImportePendiente().setScale(2,BigDecimal.ROUND_HALF_UP)).append(",");
            buff.append("0,");
            buff.append("TRUNC(SYSDATE),");
            buff.append(oidPais).append(",");
            buff.append(dto.getOidMovCC()).append(",");
            buff.append(dto.getOidSociedad()).append(",");
            buff.append(dto.getOidConograma()).append(",");
            buff.append(ConstantesCOB.OID_ESTA_ASIG_ABIERTA).append(",");
            buff.append(dto.getOidTipoCargo()).append(");");
         }
      }
      
      if(buff==null || buff.length()==0){
         UtilidadesLog.debug("- GA - Nada para grabar");
         return;
      }
   
      Iterator it = cronos.keySet().iterator();
      
      while(it.hasNext()){
         Long idCrono = (Long)it.next();
         buff.append("UPDATE COB_CRONO_COBRA SET FEC_ASIG = TRUNC(SYSDATE) WHERE OID_CRON_COBR=");
         buff.append(idCrono.longValue()).append(";");
      }
      
      try{
         BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",buff.toString());
      }catch(Exception e){
         if(e instanceof MareException){
            throw (MareException) e;
         }else{
            throw new MareException(e);
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.grabarAsignacionCuotas(ArrayList cuotas, Long oidPais): Salida");
   }

   private DTOCronogramaCobranza buscarCronogramaSupervisor(DTOCuotasAsignacion cuota, 
                                                            Long oidSupervisor, 
                                                            Long pais,
                                                            Long idioma,
                                                            Long periodo) throws MareException{
      
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.buscarCronogramaSupervisor(...): Entrada");
      
      DTOCronogramaCobranza salida = new DTOCronogramaCobranza();
      
      StringBuffer buff = new StringBuffer();
      buff.append(" SELECT OID_CRON_COBR,  COD_CART,  FEC_CIER, ");
	   buff.append(" PAIS_OID_PAIS,  PERD_OID_PERI, ETDE_OID_ETAP_DEUD, ");
	   buff.append(" TCAB_OID_TIPO_CARG_ABON, USCO_OID_USUA_COBR, ZSGV_OID_SUBG_VENT,");
	   buff.append(" ZORG_OID_REGI, ZZON_OID_ZONA, TERR_OID_TERR, ZSCC_OID_SECC FROM ( ");
      buff.append(" SELECT c.*, 'a'||to_char(c.ZSGV_OID_SUBG_VENT)||nvl(c.ZORG_OID_REGI,'')");
      buff.append("||nvl(c.ZZON_OID_ZONA,'')||nvl(c.ZSCC_OID_SECC,'')||nvl(c.TERR_OID_TERR,'') AS concatenado ");
      buff.append(" FROM COB_CRONO_COBRA C  WHERE  C.PAIS_OID_PAIS = ").append(pais);
      buff.append(" AND C.USCO_OID_USUA_COBR = ").append(oidSupervisor).append(" AND C.ETDE_OID_ETAP_DEUD = ").append(cuota.getOidEtapa());
	   buff.append(" AND C.TCAB_OID_TIPO_CARG_ABON = ").append(cuota.getOidTipoCargo()).append(" AND C.PERD_OID_PERI = ").append(periodo);
      buff.append(" AND C.ZSGV_OID_SUBG_VENT = ").append(cuota.getOidSubGerencia());
      buff.append(" AND (c.ZORG_OID_REGI = ");
      if(cuota.getOidRegion()==null){
         buff.append("-1 ");
      }else{
         buff.append(cuota.getOidRegion());
      }
      buff.append(" OR c.ZORG_OID_REGI IS NULL) ");
	   buff.append(" AND (c.ZZON_OID_ZONA = ");
      if(cuota.getOidZona()==null){
         buff.append("-1 ");
      }else{
         buff.append(cuota.getOidZona());
      }
      buff.append(" OR c.ZZON_OID_ZONA IS NULL) ");
	   buff.append(" AND (c.ZSCC_OID_SECC = ");
      if(cuota.getOidSeccion() ==null){
         buff.append("-1 ");
      }else{
         buff.append(cuota.getOidSeccion());
      }
      buff.append(" OR c.ZSCC_OID_SECC IS NULL) ");
      buff.append(" AND (c.TERR_OID_TERR = ");
      if(cuota.getOidTerritorio() ==null){
         buff.append("-1 ");
      }else{
         buff.append(cuota.getOidTerritorio());
      }      
	   buff.append(" OR c.TERR_OID_TERR IS NULL) ");
      buff.append(" ORDER BY CONCATENADO DESC) ");
      buff.append(" WHERE ROWNUM = 1"); 
      
      RecordSet rs = null;
      try{
         rs = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
      }catch(Exception e){
         if(e instanceof MareException){
            throw (MareException) e;
         }else{
            throw new MareException(e);
         }
      }
      
      UtilidadesLog.debug("consulta, retorna: " + rs);

      if(rs.esVacio()){//tengo que insertarlo
         DTOCronogramaCobranza tmp = new DTOCronogramaCobranza();
         tmp.setOidPais(pais);
         tmp.setOidIdioma(idioma);
         SecuenciadorOID sec = new SecuenciadorOID();
         Long proximo = sec.obtenerSiguienteValor("COB_CRCO_SEQ");
         Long cartera = obtenerIdCartera(tmp);
         buff = new StringBuffer();
         buff.append(" INSERT INTO COB_CRONO_COBRA ( OID_CRON_COBR, COD_CART, FEC_CIER, ");
         buff.append(" PAIS_OID_PAIS, PERD_OID_PERI, ZSGV_OID_SUBG_VENT,  ");
         buff.append(" TCAB_OID_TIPO_CARG_ABON, ETDE_OID_ETAP_DEUD, USCO_OID_USUA_COBR ");
         buff.append(" ) VALUES ( " );
         buff.append(proximo).append(",");
         buff.append(cartera).append(",");
         buff.append(" TRUNC(SYSDATE), ");
         buff.append(pais).append(",");
         buff.append(periodo).append(",");
         buff.append(cuota.getOidSubGerencia()).append(",");
         buff.append(cuota.getOidTipoCargo()).append(",");
         buff.append(cuota.getOidEtapa()).append(",");
         buff.append(oidSupervisor).append(")");
         try{
            BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
         }catch(Exception e){
            if(e instanceof MareException){
               throw (MareException) e;
            }else{
               throw new MareException(e);
            }
         }
         salida.setOidCobranza(proximo);
         salida.setOidUsuarioCobranza(oidSupervisor);
         salida.setOidSubgerenciaVentas(new Long(cuota.getOidSubGerencia().longValue()));
         salida.setOidTipoCargo(new Long(cuota.getOidTipoCargo().longValue()));
         salida.setOidPeriodo(new Long(periodo.longValue()));
         salida.setOidPais(new Long(pais.longValue()));
         salida.setOidIdioma(new Long(idioma.longValue()));
         salida.setIdCartera(new Long(cartera.longValue()));
         salida.setOidEtapa(new Long(cuota.getOidEtapa().longValue()));
      }else{
         salida.setOidCobranza(new Long(rs.getValueAt(0,"OID_CRON_COBR").toString()));
         salida.setOidUsuarioCobranza(new Long(rs.getValueAt(0,"USCO_OID_USUA_COBR").toString()));
         salida.setOidSubgerenciaVentas(new Long(rs.getValueAt(0,"ZSGV_OID_SUBG_VENT").toString()));
         salida.setOidPeriodo(new Long(rs.getValueAt(0,"PERD_OID_PERI").toString()));
         salida.setOidTipoCargo(new Long(rs.getValueAt(0,"TCAB_OID_TIPO_CARG_ABON").toString()));
         salida.setIdCartera(new Long(rs.getValueAt(0,"COD_CART").toString()));
         salida.setOidPais(pais);
         salida.setOidIdioma(idioma);
         salida.setOidEtapa(new Long(rs.getValueAt(0,"ETDE_OID_ETAP_DEUD").toString()));
         if(rs.getValueAt(0,"ZORG_OID_REGI")!=null){
            salida.setOidRegion(new Long(rs.getValueAt(0,"ZORG_OID_REGI").toString()));
         }
         if(rs.getValueAt(0,"ZZON_OID_ZONA")!=null){
            salida.setOidZona(new Long(rs.getValueAt(0,"ZZON_OID_ZONA").toString()));
         }
         if(rs.getValueAt(0,"TERR_OID_TERR")!=null){
            salida.setOidTerritorio(new Long(rs.getValueAt(0,"TERR_OID_TERR").toString()));
         }
         if(rs.getValueAt(0,"ZSCC_OID_SECC")!=null){
            salida.setOidSeccion(new Long(rs.getValueAt(0,"ZSCC_OID_SECC").toString()));
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.buscarCronogramaSupervisor(...): Salida");
      return salida;
      
   }

   private void asignarCuotaCronograma(DTOCuotasAsignacion cuota, ArrayList cronogramas){
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCuotaCronograma(DTOCuotasAsignacion cuota, ArrayList cronogramas): Entrada");
      //debo comparar la cuota contra la lista de cronogramas posibles.
      //para ello, usando el nivel de zonificacion de cuota, primero busco cronogramas
      //del mismo nivel, si alguno cumple con exactamente la misma zonificacion, siendo el 
      //mismo nivel, a la cuota le asigno el oid de cronograma correspondiente, sino
      //uso el nivel anterior de cuota y repito el proceso, hasta llegar a nivel 0.
      //si no existe cronograma que cumpla, al menos con el nivel 0 de zonificacion, 
      //la cuota queda sin asignar.
      int nivelCuota = obtenerNivelZonificacion(cuota);      
      UtilidadesLog.debug("- GA - Nivel de Cuota: "+nivelCuota+" para la cuota: "+cuota.getOidMovCC());
      int largoCronogramas = cronogramas.size();
      UtilidadesLog.debug("- GA - Cronogramas a comparar: "+largoCronogramas);
      for(int i=0; i<largoCronogramas;i++){
         int nivelCronograma= obtenerNivelZonificacion((DTOCronogramaCobranza)cronogramas.get(i));
         //solo trato los cronogramas con un nivel de zonificacion igual o inferior al nivel de
         //zonificacion de la cuota, pero degradando el nivel de zonificacion de cuota luego
         //de no encontrar un solo cronograma de ese mismo nivel que cumpla.
         UtilidadesLog.debug("nivelCronograma/nivelCuota : " + nivelCronograma + " / " + nivelCuota);
         
         if(nivelCronograma!=nivelCuota ){
            if(nivelCronograma>nivelCuota){
                continue;
            }
            UtilidadesLog.debug("- GA - El nivel de zonificacion no coincide");
         }else{
            //tiene el mismo nivel, verifico si es la misma zonificacion
            String zonificacionCuota = obtenerStringNivelZonificacion(nivelCuota,cuota);
            UtilidadesLog.debug("- GA - Zonificacion cuota: "+zonificacionCuota);
            String zonificacionCronograma = obtenerStringNivelZonificacion(nivelCronograma,(DTOCronogramaCobranza)cronogramas.get(i));
            UtilidadesLog.debug("- GA - Zonificacion cronograma: "+zonificacionCronograma);
            //if(zonificacionCuota.equals(zonificacionCronograma)){
            //pregunto por contencion, no por igualdad
            if (zonificacionCuota.indexOf(zonificacionCronograma)!=-1 ){   //la zona del crono. esta contenida x la zona de la cuota
               UtilidadesLog.debug("- GA - Se asigna cronograma para cuota: "+cuota.getOidMovCC());
               cuota.setOidConograma(((DTOCronogramaCobranza)cronogramas.get(i)).getOidCobranza());
               cuota.setNivelAsignado(new Long(nivelCuota));
               break;
            }else{
               UtilidadesLog.debug("- GA - No coincide la zonificacion");
            }
         }
         //si no quedan mas cronogramas y puedo bajar el nivel de zonificacion de la cuota, 
         //reinicio el bucle con el nivel inferior de zonificacion de cuota.
         UtilidadesLog.debug("- GA - Valor de I: "+i+". Nivel actual: "+nivelCuota);
         if(nivelCuota>0 &&  i+1==largoCronogramas   ){
            UtilidadesLog.debug("- GA - Se baja el nivel de zonificacion de la cuota");
            nivelCuota-=1;
            UtilidadesLog.debug("nivelCuota, ahora q'da: " + nivelCuota);
            i=-1;
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCuotaCronograma(DTOCuotasAsignacion cuota, ArrayList cronogramas): Salida");
   }
   
   private int obtenerNivelZonificacion(DTOAuditableSICC dto){
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerNivelZonificacion(DTOAuditableSICC dto): Entrada");
   
      if(!(dto instanceof DTOCronogramaCobranza) && !(dto instanceof DTOCuotasAsignacion)){
         throw new ClassCastException("La clase del dto de entrada no es del tipo esperado");
      }
      int salida =0;//siempre tiene subgerencia
      if(dto instanceof DTOCronogramaCobranza){
         if(((DTOCronogramaCobranza)dto).getOidRegion()!=null){
            salida = 1;
            if(((DTOCronogramaCobranza)dto).getOidZona()!=null){
               salida=2;
               if(((DTOCronogramaCobranza)dto).getOidSeccion()!=null){
                  salida=3;
                  if(((DTOCronogramaCobranza)dto).getOidTerritorio()!=null){
                     salida=4;
                  }
               }
            }
         }
      }else{
         if(((DTOCuotasAsignacion)dto).getOidRegion()!=null){
            salida = 1;
            if(((DTOCuotasAsignacion)dto).getOidZona()!=null){
               salida=2;
               if(((DTOCuotasAsignacion)dto).getOidSeccion()!=null){
                  salida=3;
                  if(((DTOCuotasAsignacion)dto).getOidTerritorio()!=null){
                     salida=4;
                  }
               }
            }
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerNivelZonificacion(DTOAuditableSICC dto): Salida");
      return salida;      
   }

   private String obtenerStringNivelZonificacion(int nivel, DTOAuditableSICC dto){
   
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerStringNivelZonificacion(int nivel, DTOAuditableSICC dto): Entrada");
   
      if(!(dto instanceof DTOCronogramaCobranza) && !(dto instanceof DTOCuotasAsignacion)){
         throw new ClassCastException("La clase del dto de entrada no es del tipo esperado");
      }
      
      StringBuffer salida=new StringBuffer();      
      //la idea es devolver un string con la concatenazion de
      //la zonificacion del dto de entrada en base al parametro nivel,
      //de modo que: 0-Subgerencia 1-Region  2-Zona 3-Seccion 4-Territorio
      //teniendo en cuenta que un nivel mayor, incluye necesariamente a los demas
      //ya que no se puede definir nivel 3 sin definir, a su vez, nivel 0, 1, 2
      if(dto instanceof DTOCronogramaCobranza){
         switch(nivel){
            case 4: 
               if (((DTOCronogramaCobranza)dto).getOidTerritorio().longValue()!=0)
                   salida.append(((DTOCronogramaCobranza)dto).getOidTerritorio().toString());
            case 3:
               if (((DTOCronogramaCobranza)dto).getOidSeccion().longValue()!=0) 
                   salida.append(((DTOCronogramaCobranza)dto).getOidSeccion().toString());
            case 2:
               if (((DTOCronogramaCobranza)dto).getOidZona().longValue()!=0)  
                   salida.append(((DTOCronogramaCobranza)dto).getOidZona().toString());
            case 1:
               if (((DTOCronogramaCobranza)dto).getOidRegion().longValue()!=0)  
                   salida.append(((DTOCronogramaCobranza)dto).getOidRegion().toString());
            case 0:
               if (((DTOCronogramaCobranza)dto).getOidSubgerenciaVentas().longValue()!=0)  
                   salida.append(((DTOCronogramaCobranza)dto).getOidSubgerenciaVentas().toString());
         }
      }else{
         switch(nivel){
            case 4: 
               if (((DTOCuotasAsignacion)dto).getOidTerritorio().longValue()!=0)
                   salida.append(((DTOCuotasAsignacion)dto).getOidTerritorio().toString());
            case 3:
               if (((DTOCuotasAsignacion)dto).getOidSeccion().longValue()!=0)
                   salida.append(((DTOCuotasAsignacion)dto).getOidSeccion().toString());
            case 2:
               if (((DTOCuotasAsignacion)dto).getOidZona().longValue()!=0)
                   salida.append(((DTOCuotasAsignacion)dto).getOidZona().toString() );
            case 1:
               if (((DTOCuotasAsignacion)dto).getOidRegion().longValue()!=0)
                   salida.append(((DTOCuotasAsignacion)dto).getOidRegion().toString());
            case 0:
               if (((DTOCuotasAsignacion)dto).getOidSubGerencia().longValue()!=0)
                   salida.append(((DTOCuotasAsignacion)dto).getOidSubGerencia().toString());
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerStringNivelZonificacion(int nivel, DTOAuditableSICC dto): Salida");
      return salida.toString();
      
   }

   private static Long obtenerUsuarioSupervisor(Long pais)throws MareException{
   
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerUsuarioSupervisor(Long pais): Entrada");
   
      if(hashIdSupervisor==null){
         hashIdSupervisor=new HashMap();
      }
      Long salida = (Long)hashIdSupervisor.get(pais);
      if(salida==null){
         //obtenemos el usuario supervisor
         StringBuffer buff = new StringBuffer();
         buff.append(" SELECT OID_USUA_COBR FROM COB_USUAR_COBRA ");
         buff.append(" WHERE PAIS_OID_PAIS = 2001 AND ");
         buff.append(" IND_USUA_SUPE = 1 AND ROWNUM = 1 ");
         try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
            if(!rs.esVacio()){
               salida = new Long(rs.getValueAt(0,0).toString());
               //la siguiente asignacion elimina la referencia
               hashIdSupervisor.put(new Long(pais.longValue()),new Long(salida.longValue()));
            }
         }catch(Exception e){
            if(e instanceof MareException){
               throw (MareException) e;
            }else{
               throw new MareException(e);
            }
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerUsuarioSupervisor(Long pais): Salida");
      return salida;
   }

   //private void insertarDeudaPosterior(DTOCuotasAsignacion dto, Long cronograma, Long pais)throws MareException{
   private void insertarDeudaPosterior(DTOCuotasAsignacion dto, Long oidCartera, Long pais)throws MareException{

      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.insertarDeudaPosterior(DTOCuotasAsignacion dto, Long cronograma, Long pais): Entrada");
   
      StringBuffer buff = new StringBuffer();
      
      buff.append("INSERT INTO COB_ASIGN_COBRA ( OID_ASIG_COBR, IMP_ORIG_DEUD, IMP_DEUD_ASIG, IMP_DEUD_CANC, FEC_ASIG,");
      buff.append(" PAIS_OID_PAIS, MVCC_OID_MOVI_CC, SOCI_OID_SOCI, CRCO_OID_CRON_COBR, HICC_OID_HIST_COMI_COBR, ");
      buff.append(" ESAS_OID_ESTA_ASIG, TCAB_OID_TIPO_CARG_ABON ) VALUES ( ");
      buff.append(" COB_ASCO_SEQ.NEXTVAL, ");
      buff.append( dto.getImporteOriginal().setScale(2,BigDecimal.ROUND_HALF_UP)).append(",");
      buff.append( dto.getImportePendiente().setScale(2,BigDecimal.ROUND_HALF_UP)).append(",");
      buff.append("0,");
      buff.append( "TRUNC(SYSDATE),");
      buff.append( pais ).append(",");
      buff.append( dto.getOidMovCC()).append(",");
      buff.append( dto.getOidSociedad()).append(",");
      buff.append(oidCartera).append(",");
      buff.append("null,");
      buff.append( ConstantesCOB.OID_ESTA_ASIG_ABIERTA).append(",");
      buff.append(dto.getOidTipoCargo()).append(")");
      
      try{
         BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
      }catch(Exception e){
         if(e instanceof MareException){
            throw (MareException) e;
         }else{
            throw new MareException(e);
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.insertarDeudaPosterior(DTOCuotasAsignacion dto, Long cronograma, Long pais): Salida");
   }

   private RecordSet encontrarEtapasPosteriores(Long oidCliente, Long edadDesdeEtapaReferencia)throws MareException{
      
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.encontrarEtapasPosteriores(Long oidCliente, Long edadDesdeEtapaReferencia): Entrada");
   
      StringBuffer buff = new StringBuffer();
      Vector parametros = new Vector();
      
      buff.append(" SELECT ca.oid_asig_cobr, ca.mvcc_oid_movi_cc, ca.crco_oid_cron_cobr, ");
      buff.append(" cc.cod_cart  FROM cob_asign_cobra ca, ");
      buff.append(" cob_crono_cobra cc, cob_etapa_deuda ce, ccc_movim_cuent_corri cm ");
      buff.append(" WHERE ca.mvcc_oid_movi_cc = cm.oid_movi_cc ");
      buff.append(" AND ca.crco_oid_cron_cobr = cc.oid_cron_cobr ");
      buff.append(" AND cc.etde_oid_etap_deud = ce.oid_etap_deud ");
      buff.append(" AND ce.val_edad_inic = (SELECT NVL (MAX (ce.val_edad_inic), -1) ");
      buff.append(" FROM cob_asign_cobra ca, cob_crono_cobra cc, cob_etapa_deuda ce, ccc_movim_cuent_corri cm ");
      buff.append(" WHERE ca.mvcc_oid_movi_cc = cm.oid_movi_cc ");
      buff.append(" AND ca.crco_oid_cron_cobr = cc.oid_cron_cobr  AND cc.etde_oid_etap_deud = ce.oid_etap_deud ");
      buff.append(" AND ce.val_edad_inic > ? AND ca.esas_oid_esta_asig = ? ");
      parametros.add(edadDesdeEtapaReferencia);
      parametros.add(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
      buff.append(" AND cm.clie_oid_clie = ?) AND ca.esas_oid_esta_asig = ? AND cm.clie_oid_clie = ? ");
      parametros.add(oidCliente);
      parametros.add(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
      parametros.add(oidCliente);
      
      RecordSet salida = null;
      try{
         salida = BelcorpService.getInstance().dbService.executePreparedQuery(buff.toString(),parametros);
      }catch(Exception e){
         if(e instanceof MareException){
            throw (MareException) e;
         }else{
            throw new MareException(e);
         }
      }
      UtilidadesLog.info("Encontrar en Etapas Posteriores, ret: " + salida + ", midiendo: " + salida.getRowCount());
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.encontrarEtapasPosteriores(Long oidCliente, Long edadDesdeEtapaReferencia): Salida");
      return salida;
   }

   private void reasignarEnEtapasAnteriores(Long oidMovimientoCC, Long edadInicialReferencia)throws MareException{
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.reasignarEnEtapasAnteriores(Long oidMovimientoCC, Long edadInicialReferencia): Entrada");
      
      StringBuffer buff = new StringBuffer();
      Vector parametros = new Vector();
      buff.append(" UPDATE COB_ASIGN_COBRA ");
      buff.append(" SET ESAS_OID_ESTA_ASIG = ").append(ConstantesCOB.OID_ESTA_ASIG_REASIGNADA);
      buff.append(" WHERE OID_ASIG_COBR IN(SELECT CA.OID_ASIG_COBR ");
      buff.append(" FROM COB_ASIGN_COBRA CA,COB_CRONO_COBRA CC,COB_ETAPA_DEUDA CE,CCC_MOVIM_CUENT_CORRI CM");
      buff.append(" WHERE CA.MVCC_OID_MOVI_CC = CM.OID_MOVI_CC AND CA.CRCO_OID_CRON_COBR = CC.OID_CRON_COBR ");
      buff.append(" AND CC.ETDE_OID_ETAP_DEUD = CE.OID_ETAP_DEUD ");
      buff.append(" AND CE.VAL_EDAD_INIC < ? ");
      parametros.add(edadInicialReferencia);
      buff.append(" AND CA.ESAS_OID_ESTA_ASIG =  ").append(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
      buff.append(" AND CM.OID_MOVI_CC = ? )");
      parametros.add(oidMovimientoCC);
      try{
         int updateados = BelcorpService.getInstance().dbService.executePreparedUpdate(buff.toString(),parametros);
         UtilidadesLog.debug("reasignarEnEtapasAnteriores, se updatearon: " + updateados + ", registros!!");
      }catch(Exception e){
         if(e instanceof MareException){
            throw (MareException) e;
         }else{
            throw new MareException(e);
         }
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.reasignarEnEtapasAnteriores(Long oidMovimientoCC, Long edadInicialReferencia): Salida");
   }

   private Boolean existeEnEtapa(Long oidMovimientoCC, Long oidEtapa) throws MareException{
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.existeEnEtapa(Long oidMovimientoCC, Long oidEtapa): Entrada");
      StringBuffer buff = new StringBuffer();
      Vector parametros = new Vector();
      buff.append("SELECT COUNT(*) AS CUENTA ");
      buff.append(" FROM COB_ASIGN_COBRA CA,COB_CRONO_COBRA CC ");
      buff.append(" WHERE CA.MVCC_OID_MOVI_CC = ? ");
      parametros.add(oidMovimientoCC);
      buff.append(" AND CA.CRCO_OID_CRON_COBR = CC.OID_CRON_COBR ");
      buff.append(" AND CC.ETDE_OID_ETAP_DEUD = ? ");
      parametros.add(oidEtapa);
      buff.append(" AND CA.ESAS_OID_ESTA_ASIG = ").append(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
      
      RecordSet rs = null;
      try{
         rs = BelcorpService.getInstance().dbService.executePreparedQuery(buff.toString(),parametros);
      }catch(Exception e){
         if(e instanceof MareException){
            throw (MareException) e;
         }else{
            throw new MareException(e);
         }
      }
      
      UtilidadesLog.debug("existeEnEtapa, retorna: " + rs.getRowCount() + ", registros!");
      
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.existeEnEtapa(Long oidMovimientoCC, Long oidEtapa): Salida");
      return new Boolean(new Long(rs.getValueAt(0,0).toString()).longValue()!=0L);
   }
   

   private ArrayList armarArrayCuotas(RecordSet cuotas){
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.armarArrayCuotas(RecordSet cuotas): Entrada");
      ArrayList salida = new ArrayList();
      if(cuotas == null || cuotas.esVacio()){
         return salida;
      }

      int largoRs = cuotas.getRowCount();
      for(int i=0; i<largoRs;i++){
         DTOCuotasAsignacion dto = new DTOCuotasAsignacion();
         dto.setOidCliente(new Long(cuotas.getValueAt(i,"CLIENTE").toString()));
         dto.setDeudaTotalCliente((BigDecimal)cuotas.getValueAt(i,"DEUDATOTALCLIENTEETAPA"));
         dto.setImporteDesdeEtapa((BigDecimal)cuotas.getValueAt(i,"IMPORTEDESDE"));
         dto.setImporteHastaEtapa((BigDecimal)cuotas.getValueAt(i,"IMPORTEHASTA"));
         dto.setImportePendiente((BigDecimal)cuotas.getValueAt(i,"IMPORTEPENDIENTE"));
         dto.setImporteOriginal((BigDecimal)cuotas.getValueAt(i,"IMPORTEINICIAL"));
         dto.setNumeroIdentificadorCuota(new Long(cuotas.getValueAt(i,"NUMEROIDENTIFICADOR").toString()));
         dto.setNumeroOrdenCuota(new Long(cuotas.getValueAt(i,"NUMEROORDEN").toString()));
         dto.setOidEtapa(new Long(cuotas.getValueAt(i,"ETAPA").toString()));
         dto.setOidMarca(new Long(cuotas.getValueAt(i,"MARCA").toString()));
         dto.setOidMovCC(new Long(cuotas.getValueAt(i,"OID_MOVI_CC").toString()));
         
         if(cuotas.getValueAt(i,"REGION")!=null){
            dto.setOidRegion(new Long(cuotas.getValueAt(i,"REGION").toString()));
         }
         if(cuotas.getValueAt(i,"SECCION")!=null){
            dto.setOidSeccion(new Long(cuotas.getValueAt(i,"SECCION").toString()));   
         }
         //scs, veamos...
         /*if(cuotas.getValueAt(i,"TERRITORIO")!=null){
            dto.setOidTerritorio(new Long(cuotas.getValueAt(i,"TERRITORIO").toString()));   
         }*/
         if(cuotas.getValueAt(i,"TERRITORIOREAL")!=null){
            dto.setOidTerritorio(new Long(cuotas.getValueAt(i,"TERRITORIOREAL").toString()));   
         }
         if(cuotas.getValueAt(i,"ZONA")!=null){
            dto.setOidZona(new Long(cuotas.getValueAt(i,"ZONA").toString()));
         }
         dto.setOidSociedad(new Long(cuotas.getValueAt(i,"SOCIEDAD").toString()));
         dto.setOidSubAcceso(new Long(cuotas.getValueAt(i,"SUBACCESO").toString()));
         dto.setOidSubGerencia(new Long(cuotas.getValueAt(i,"SUBGERENCIAVENTAS").toString()));
         dto.setOidTipoCargo(new Long(cuotas.getValueAt(i,"TIPOCARGO").toString()));
         dto.setEdadEtapaDesde(new Long(cuotas.getValueAt(i,"EDADDESDE").toString()));
         dto.setEdadEtapaHasta(new Long(cuotas.getValueAt(i,"EDADHASTA").toString()));
         if(new Long(cuotas.getValueAt(i,"TELEFONO").toString()).longValue()==0){
            dto.setTelefonoCliente(new Boolean(false));
         }else{
            dto.setTelefonoCliente(new Boolean(true));
         }
         if(new Long(cuotas.getValueAt(i,"TELEFONOETAPA").toString()).longValue()==0){
            dto.setTelefonoEtapa(new Boolean(false));
         }else{
            dto.setTelefonoEtapa(new Boolean(true));
         }
         if(cuotas.getValueAt(i,"TIPOBALANCEO")!=null){
            dto.setTipoBalanceoEtapa(new Long(cuotas.getValueAt(i,"TIPOBALANCEO").toString()));
         }else{
            dto.setTipoBalanceoEtapa(new Long(-1));
         }
         salida.add(dto);
      }
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.armarArrayCuotas(RecordSet cuotas): Salida");
      return salida;
   }


 /** 
  * Método privado que compara si estamos dentro de los mismos valores
  * @param boolean
  * @return Long tipocargoActual,Long periodoActual, Long terrAdminActual,DTOCronogramaCobranza dtoCronoActual
  * @exception MareException 
  * @author enozigli
  * @referencia incidencia 13426
  */
  private boolean compararTuplas(Long tipocargoActual,Long periodoActual, Long sbgventas,Long  region,Long zona,Long seccion,Long territorio,DTOCronogramaCobranza dtoCronoActual) throws MareException{ 
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.compararTuplas(Long tipocargoActual,Long periodoActual, Long sbgventas,Long  region,Long zona,Long seccion,Long territorio,DTOCronogramaCobranza dtoCronoActual): Entrada");
  
       UtilidadesLog.info("getOidTipoCargo"+dtoCronoActual.getOidTipoCargo());
       UtilidadesLog.info("getOidPeriodo"+dtoCronoActual.getOidPeriodo());
       UtilidadesLog.info("getOidSubgerenciaVentas"+dtoCronoActual.getOidSubgerenciaVentas());
       UtilidadesLog.info("getOidRegion"+dtoCronoActual.getOidRegion());
       UtilidadesLog.info("getOidZona"+dtoCronoActual.getOidZona());
       UtilidadesLog.info("getOidSeccion"+dtoCronoActual.getOidSeccion());
       UtilidadesLog.info("getOidTerritorio"+dtoCronoActual.getOidTerritorio());
       
      if (((tipocargoActual!=null)&&(tipocargoActual.equals(dtoCronoActual.getOidTipoCargo())))&&
          ((periodoActual!=null)&&(periodoActual.equals(dtoCronoActual.getOidPeriodo())))&&
          ((sbgventas!=null)&&(sbgventas.equals(dtoCronoActual.getOidSubgerenciaVentas())))&&
          (((region!=null)&&(region.equals(dtoCronoActual.getOidRegion())))||(region==null&&dtoCronoActual.getOidRegion()==null))&&
          (((zona!=null)&&(zona.equals(dtoCronoActual.getOidZona())))||(zona==null&&dtoCronoActual.getOidZona()==null))&&
          (((seccion!=null)&&(seccion.equals(dtoCronoActual.getOidSeccion())))||(seccion==null&&dtoCronoActual.getOidSeccion()==null))&&
          (((territorio!=null)&&(territorio.equals(dtoCronoActual.getOidTerritorio())))||(territorio==null&&dtoCronoActual.getOidTerritorio()==null))) 
          {
            UtilidadesLog.info("true");
            
            UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.compararTuplas(Long tipocargoActual,Long periodoActual, Long sbgventas,Long  region,Long zona,Long seccion,Long territorio,DTOCronogramaCobranza dtoCronoActual): Salida");
            
            return true;
          } else 
          {
            UtilidadesLog.info("false");
            
            UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.compararTuplas(Long tipocargoActual,Long periodoActual, Long sbgventas,Long  region,Long zona,Long seccion,Long territorio,DTOCronogramaCobranza dtoCronoActual): Salida");
            
            return false;
          }
  }
  /** 
  * Método privado para obtener un id de Cartera de PED
  * @param DTOOID dto
  * @return Long idcartera
  * @exception MareException 
  * @author enozigli
  * @referencia incidencia 13426
  */
  private Long obtenerIdCartera(DTOCronogramaCobranza dtoCrono) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerIdCartera(DTOCronogramaCobranza dtoCrono): Entrada");
  
    try{
        MONProcesosPEDHome mph = (MONProcesosPEDHome)this.getMONProcesosPEDHome();
        MONProcesosPED procPED = mph.create();  
        DTONumeroSolicitud numeroSolicitud = new DTONumeroSolicitud();
        numeroSolicitud.setOidPais(dtoCrono.getOidPais());
        numeroSolicitud.setOidIdioma(dtoCrono.getOidIdioma());
        numeroSolicitud.setOperacion(new String("COB077"));
        String sidCartera = procPED.generaNumeroDocumento(numeroSolicitud); 
        Long idCartera = Long.valueOf(sidCartera); 
        
        UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.obtenerIdCartera(DTOCronogramaCobranza dtoCrono): Salida");
        
        return idCartera;
    } catch (CreateException ne) {
        ctx.setRollbackOnly();
        UtilidadesLog.error(ne);
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    } catch (RemoteException ne) {
        ctx.setRollbackOnly();
        UtilidadesLog.error(ne);
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (NamingException ne) {
        ctx.setRollbackOnly();
        UtilidadesLog.error(ne);
        throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }     
  }  
  /** 
  * Método para llamar al DAOAsignacionCarteraPeriodo de manera remota para obtener 
  * un detalle de cobranza
  * @param DTOOID dto
  * @return DTOSalida con el Recordset de resultados
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida detalleCobranza(DTOOIDPaginado dto) throws MareException{
    DAOAsignacionCarteraPeriodo daoAsignCarPeri = new DAOAsignacionCarteraPeriodo();
    return daoAsignCarPeri.detalleCobranza(dto);
  }
  /** 
  * Metodo que devuelve un arraylist bidimensional ordenado por etapa,tipocargo,periodo,unid. admin. 
  * @param DTOColeccion dto
  * @return ArrayList
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037 e incidencia 13426
  */
  public ArrayList organizarUsuariosEtapas(DTOColeccion dto) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.organizarUsuariosEtapas(DTOColeccion dto): Entrada");
  
    ArrayList dtos = dto.getLista();
    ArrayList sinordenar = new ArrayList();    
    for(int i=0;i<dtos.size();i++)
    {
        ArrayList crit = new ArrayList();
        DTOCronogramaCobranza dtoActual = (DTOCronogramaCobranza)dtos.get(i);
        String cadena = new String();
        cadena = cadena.concat(completarConCeros(dtoActual.getOidEtapa()));
        cadena = cadena.concat(completarConCeros(dtoActual.getOidTipoCargo()));
        cadena = cadena.concat(completarConCeros(dtoActual.getOidPeriodo()));
        cadena = cadena.concat(completarConCeros(dtoActual.getOidSubgerenciaVentas()));
        cadena = cadena.concat(completarConCeros(dtoActual.getOidRegion()));
        cadena = cadena.concat(completarConCeros(dtoActual.getOidZona()));
        cadena = cadena.concat(completarConCeros(dtoActual.getOidSeccion()));
        cadena = cadena.concat(completarConCeros(dtoActual.getOidTerritorio()));
        crit.add(dtoActual);
        crit.add(cadena);
        sinordenar.add(crit);
    }
    
    ArrayList ordenado = ordenar(sinordenar);    
    ArrayList oidsEtapas = new ArrayList();    
    HashMap etapasDtos = new HashMap();
    for(int i=0; i<ordenado.size();i++)
    {
        UtilidadesLog.info((String)((ArrayList)ordenado.get(i)).get(1));
        DTOCronogramaCobranza dtoActual = (DTOCronogramaCobranza)(((ArrayList)ordenado.get(i)).get(0));
        if ((oidsEtapas==null)||((oidsEtapas!=null)&&(!oidsEtapas.contains(dtoActual.getOidEtapa()))))
        {
            oidsEtapas.add(dtoActual.getOidEtapa());
            ArrayList unaEtapa = new ArrayList();
            unaEtapa.add(dtoActual);
            etapasDtos.put(dtoActual.getOidEtapa(),unaEtapa);
        } else 
        {
            ((ArrayList)etapasDtos.get(dtoActual.getOidEtapa())).add(dtoActual);
        }        
    }
    
    ArrayList organizado = new ArrayList();
    for (int i=0;i<oidsEtapas.size();i++)
    {
        ArrayList etapa = (ArrayList)etapasDtos.get((Long)oidsEtapas.get(i));
        organizado.add(etapa);
    }
    UtilidadesLog.info("DTOsCrono organizados:"+organizado);
    
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.organizarUsuariosEtapas(DTOColeccion dto): Salida");
    
    return organizado;
  }  
 /** 
  * Metodo forma un string con el oid de tamaño 12 que es el tamaño del oid en BD BigDecimal(12)
  * @param Long oid
  * @return String
  * @exception MareException 
  * @author enozigli
  * @referencia  incidencia 13426
  */
  private String completarConCeros(Long oid) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.completarConCeros(Long oid): Entrada");
  
      String oidToStringConDoceCeros = new String("");      
      int cerosFaltantes = 0;
      if (oid!=null){
        cerosFaltantes =12-oid.toString().length();
      } else {
        cerosFaltantes =12;
      }
      String sCeros= new String("");      
      for(int i=0;i<cerosFaltantes;i++)
      {
        sCeros = sCeros.concat("0");
      }
      if (oid!=null){
        oidToStringConDoceCeros = sCeros.concat(oid.toString());
      } else {
        oidToStringConDoceCeros = sCeros;
      }
      
        UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.completarConCeros(Long oid): Salida");
      
      return oidToStringConDoceCeros;
  }
 /** 
  * Metodo que burbujea un ArrayList de ArrayList de 2 posiciones:1ra pos(objeto), 2da pos(criterio de
  * ordenamiento en formato String)
  * @param ArrayList 
  * @return ArrayList
  * @exception MareException 
  * @author enozigli
  * @referencia  incidencia 13426
  */
  private ArrayList ordenar(ArrayList sinordenar) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.ordenar(ArrayList sinordenar): Entrada");
  
      for(int i=1;i<sinordenar.size();i++)
      {
        for(int j=0;j<sinordenar.size()-1;j++)
        {
            String critIzq = (String)((ArrayList)sinordenar.get(j)).get(1);
            String critDer = (String)((ArrayList)sinordenar.get(j+1)).get(1);
            if (critIzq.compareTo(critDer)<0) //Lo cambie porque tiene que venir de mas especifico a menos especifico
            {
              ArrayList temp = ((ArrayList)sinordenar.get(j+1));
              sinordenar.add(j, temp); 
              sinordenar.remove(j+2);
            }
        }
      }
      
        UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.ordenar(ArrayList sinordenar): Salida");
      
      return sinordenar;
  }
  /** 
  * Método para ver si un importe esta entre dos valores
  * @param BigDecimal importeDesde, BigDecimal importeHasta, BigDecimal importeOriginal
  * @return Boolean
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public Boolean validarImporte(BigDecimal importeDesde, BigDecimal importeHasta, BigDecimal importeOriginal) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.validarImporte importeDesde :" +importeDesde + " - importeHasta : " + importeHasta + " - importeOriginal :" + importeOriginal + " Entrada");
  
    if ((importeDesde.compareTo(importeOriginal)<=0)&&
        (importeHasta.compareTo(importeOriginal)>=0)){
            UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.validarImporte Salida TRUE");
        
            return Boolean.TRUE;
        }else{
            UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.validarImporte Salida FALSE");
        
            return Boolean.FALSE;
        }
  }   

  /** 
  * Método para ver si el usuario especial esta en el arraylist del parametro
  * @param ArrayList arrayList, Long oidUsuarioEspecial
  * @return Long 
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public Long verificarUsuarioEspecial(ArrayList arrayList, Long oidUsuarioEspecial) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.verificarUsuarioEspecial(ArrayList arrayList, Long oidUsuarioEspecial): Entrada");
  
    boolean encontro = false;
    Long oidCrono = null;
    int i=0;
    while(i<arrayList.size()&&!encontro)
    {
      DTOCronogramaCobranza dtoCrono = (DTOCronogramaCobranza)arrayList.get(i);
      if ((dtoCrono.getOidUsuarioCobranza()!=null)&&
          (dtoCrono.getOidUsuarioCobranza().equals(oidUsuarioEspecial))){
          encontro = true;
          oidCrono = dtoCrono.getOidCobranza();
      }
      i++;
    }
    
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.verificarUsuarioEspecial(ArrayList arrayList, Long oidUsuarioEspecial): Salida");
    
    return oidCrono;
  }
  /** 
  * Metodo para buscar las asignaciones de cartera del criterio de filtro
  * @param DTOConsultarAsignacionCartera dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida consultarAsignacionCartera(DTOConsultarAsignacionCartera dto) throws MareException
  {
    DAOAsignacionCarteraPeriodo daoAsignCarPeri = new DAOAsignacionCarteraPeriodo();
    return daoAsignCarPeri.consultarAsignacionCartera(dto);
  }
  /** 
  * Metodo que llama al DAOAsignacionCarteraPeriodo para ser llamado remotamente
  * @param DTOEBuscarEtapas dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida listadoEtapa(DTOEBuscarEtapas dto) throws MareException
  {
    DAOAsignacionCarteraPeriodo daoAsignCarPeri = new DAOAsignacionCarteraPeriodo();
    return daoAsignCarPeri.listadoEtapas(dto);
  }
  /** 
  * Metodo que actualiza el estado de la cartera seleccionada
  * @param DTOActualizacionCartera dto
  * @return void
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037 e incidencia 13159
  */
  public void actualizarEstadoCartera(DTOActualizacionCartera dto) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.actualizarEstadoCartera(DTOActualizacionCartera dto): Entrada");
      StringBuffer query = new StringBuffer();
      query.append("UPDATE COB_ASIGN_COBRA  SET IMP_DEUD_CANC = round("+ dto.getImporteDeudaCancelada() + 
                  ",2) - NVL (imp_orig_deud, 0) + NVL (imp_deud_asig, 0), ");
	   query.append(" ESAS_OID_ESTA_ASIG = case when (round("+ dto.getImporteDeudaCancelada().
                        setScale(2,BigDecimal.ROUND_HALF_UP) + ",2) = imp_orig_deud ) ");
                        
       //modificado por Sapaza, fecha 29-10-2007, incidencia SiCC-20070491
	   //query.append(" then ESAS_OID_ESTA_ASIG else OBTENER_ESTADO_CARTERA("+dto.getOidCuota()+" ) end");
       query.append(" then OBTENER_ESTADO_CARTERA("+dto.getOidCuota()+" ) else ESAS_OID_ESTA_ASIG end");
       
      query.append(" WHERE OID_ASIG_COBR in (SELECT asi.OID_ASIG_COBR FROM COB_ASIGN_COBRA asi ");
      query.append(" WHERE asi.HICC_OID_HIST_COMI_COBR IS NULL AND asi.MVCC_OID_MOVI_CC = "+dto.getOidCuota());
      query.append(" AND asi.ESAS_OID_ESTA_ASIG = "+ConstantesCOB.OID_ESTA_ASIG_ABIERTA+" )");
      
      try{
         BelcorpService.getInstance().dbService.executeUpdate(query.toString());
      }catch(Exception e){
         throw new MareException( "Error al actualizar la cartera de clientes",e);
      }
      
      
      UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.actualizarEstadoCartera(DTOActualizacionCartera dto): Salida");
  }
  
  /** 
  * Metodo para la consulta del resumen de asignacion llama al DAOAsignacionCarteraPeriodo
  * @param DTOConsultarResumenAsignacion dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida consultarResumenAsignacion(DTOConsultarResumenAsignacion dto) throws MareException
  {
    DAOAsignacionCarteraPeriodo daoAsignCarPeri = new DAOAsignacionCarteraPeriodo();
    return daoAsignCarPeri.consultarResumenAsignacion(dto);
  }
  
  /** 
  * Metodo de apoyo que transforma un BigDecimal a Long
  * @param Object num
  * @return Long
  * @exception 
  * @author enozigli
  * @referencia 
  */  
  private Long BigToLong(Object num) {
    if (num != null) {
        return (new Long(((BigDecimal) num).longValue()));
    } else {
        return null;
    }
  }
  /** 
  * Metodo vuelve a cero todas las variables globales para asignacion cartera
  * @param void
  * @return void
  * @exception 
  * @author enozigli
  * @referencia incidencia 13426
  */  
  private void reiniciarVariables() {
      this.clienteActual = null;
      this.cronoCronoUsuActual = null;
      this.totalActual = null;
      this.cronoUsuPos = 0;
  }
  /** 
  * Metodo que asigna una cuota a un cobrador poniendola en su cronograma de cobranzas(cartera)
  * @param DTOAsignacionCobranza, ArrayList, Long
  * @return void
  * @exception 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037 incidencia 13426
  */  
  public void asignarCuota(DTOAsignacionCobranza dtoAsignacion, ArrayList oidsCronoUsuEtapa, Long balanceo) throws MareException{
     UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCuota(DTOAsignacionCobranza dtoAsignacion, ArrayList oidsCronoUsuEtapa, Long balanceo): Entrada");
     Boolean bFlag = null;
     DAOAsignacionCarteraPeriodo dao = new DAOAsignacionCarteraPeriodo();
     try { 
        MovimientosCuentasCorrientesLocalHome moviCCCLH = this.getMovimientosCuentasCorrientesLocalHome();
        MovimientosCuentasCorrientesLocal moviCCCL = moviCCCLH.findByPrimaryKey(dtoAsignacion.getOidCuota());
        this.asignarCuotaEtapasPosteriores(moviCCCL.getCliente());
        
        bFlag = dao.validarAsignacionExistente(moviCCCL.getOid(), dtoAsignacion.getOidEtapa()  ); 
     } catch ( Exception ex) {
        ex.printStackTrace();
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
     }
     
     
     if (!bFlag.booleanValue()) {
        //este metodo es RequiredNew para que haga persitencia luego de terminar el metodo
        UtilidadesLog.info("Entra a asignarCuota:"+oidsCronoUsuEtapa+" Balanceo:" + balanceo);
        if ( oidsCronoUsuEtapa != null ) {//balanceos
           if( (balanceo==null)||
                ((balanceo!=null)&&(balanceo.equals(ConstantesCOB.TIPO_BALANCEO_CONSULTORA)))) {
                
               UtilidadesLog.info("balanceo por consultora");
               if ((this.clienteActual==null)||((this.clienteActual!=null)&&(dtoAsignacion.getOidCliente().equals(this.clienteActual)))){
                  UtilidadesLog.info("consultora1");
                  dtoAsignacion.setOidCobranza((Long)oidsCronoUsuEtapa.get(this.cronoUsuPos));
               }else{
                  UtilidadesLog.info("consultora2");
                  this.cronoUsuPos++;
                  if (oidsCronoUsuEtapa.size() <= this.cronoUsuPos){this.cronoUsuPos=0;}
                      dtoAsignacion.setOidCobranza((Long)oidsCronoUsuEtapa.get(this.cronoUsuPos));            
              }
              //4.Como se hace en todos los casos al final es lo mismo que se haga una sola vez al final
            } else if ((balanceo!=null)&&(balanceo.equals(ConstantesCOB.TIPO_BALANCEO_SALDO)))
            { UtilidadesLog.info("balanceo por saldo");
              BigDecimal promedio = new BigDecimal(totalSaldoCuotasEtapaActual.longValue()/oidsCronoUsuEtapa.size());
              UtilidadesLog.info("promedio: " + promedio);
              if ((totalActual==null)||((totalActual!=null)&&((totalActual.add(dtoAsignacion.getImporteDeudaAsignada())).compareTo(promedio) < 0))){
                UtilidadesLog.info("saldo 1");
                dtoAsignacion.setOidCobranza((Long)oidsCronoUsuEtapa.get(this.cronoUsuPos));
                //incidencia 15723 y segun reunion DT (hmansi)
              } else {
                UtilidadesLog.info("saldo 2");
                if ((this.clienteActual==null)||((this.clienteActual!=null)&&(dtoAsignacion.getOidCliente().equals(this.clienteActual))))
                { UtilidadesLog.info("saldo 1a");
                  dtoAsignacion.setOidCobranza((Long)oidsCronoUsuEtapa.get(this.cronoUsuPos));
                } else 
                { UtilidadesLog.info("saldo 1b");
                  this.cronoUsuPos++;
                  totalActual = null;//reinicio el total acumulado ya que cambia el us cob.
                  if (oidsCronoUsuEtapa.size() <= this.cronoUsuPos){this.cronoUsuPos=0;}
                  dtoAsignacion.setOidCobranza((Long)oidsCronoUsuEtapa.get(this.cronoUsuPos));            
                }//incidencia 15723 y segun reunion DT (hmansi)
                /*this.cronoUsuPos++;
                totalActual = null;
                if (oidsCronoUsuEtapa.size() < this.cronoUsuPos){this.cronoUsuPos=0;}
                dtoAsignacion.setOidCobranza((Long)oidsCronoUsuEtapa.get(this.cronoUsuPos));*/ 
              }
              //4.Como se hace en todos los casos al final es lo mismo que se haga una sola vez al final
              totalActual = new BigDecimal(((totalActual!=null)?totalActual.longValue():0)+((dtoAsignacion.getImporteDeudaAsignada()!=null)?dtoAsignacion.getImporteDeudaAsignada().longValue():0));
            }
            this.clienteActual = dtoAsignacion.getOidCliente();
            this.oidCronoUsuActual = (Long)oidsCronoUsuEtapa.get(this.cronoUsuPos);
          } else 
          { //es usuarioEspecial        
            //4.Como se hace en todos los casos al final es lo mismo que se haga una sola vez al final
          }
          
          //4. Hacer un create en la entidad Asignacion Cobranzas con dtoAsignacion
          asignarCobranza(dtoAsignacion);
     }
     UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCuota(DTOAsignacionCobranza dtoAsignacion, ArrayList oidsCronoUsuEtapa, Long balanceo): Salida");
  }

  /** 
  * Metodo que asocia la cobranza de la cuota en la entidad AsignacionCobranza
  * @param DTOAsignacionCobranza
  * @return void
  * @exception 
  * @author enozigli
  * @referencia incidencia 13426
  */  
  private void asignarCobranza(DTOAsignacionCobranza dtoAsignacion) throws MareException{
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCobranza(DTOAsignacionCobranza dtoAsignacion): Entrada");
  
    try{
        AsignacionCobranzaLocalHome aclh = (AsignacionCobranzaLocalHome)this.getAsignacionCobranzaLocalHome();
        AsignacionCobranzaLocal acl = aclh.create(dtoAsignacion.getOidPais(),
                                                  dtoAsignacion.getOidCuota(),
                                                  dtoAsignacion.getOidSociedad(),
                                                  dtoAsignacion.getOidCobranza());
        acl.setOidEstadoAsignacion(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
        acl.setImporteDeudaAsignada(dtoAsignacion.getImporteDeudaAsignada());
        acl.setImporteDeudaCancelada(new BigDecimal(0));
        acl.setImporteOriginalDeuda(dtoAsignacion.getImporteOriginal());
        acl.setFechaAsignacion(new Date(System.currentTimeMillis()));
        
        aclh.merge(acl);        
        
        UtilidadesLog.info("asigno a:"+dtoAsignacion);
        
        //acl.setLiquidacion();//HICC_OID_HIST_COMI_COBR
        //parametros del create de asignacioncobranza
        //(Long pais, Long codigoCliente(me fije y es el oidclientetiposubtipo), Long datosMovimientosCCC(es la cuota), Long sociedad, Long cartera(es el oidcobranza))        
     } catch(PersistenceException e) {
          ctx.setRollbackOnly();
          e.printStackTrace();
          throw new MareException(e,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
     }     
    
    UtilidadesLog.info("MONAsignacionCarteraPeriodoBean.asignarCobranza(DTOAsignacionCobranza dtoAsignacion): Salida");
  }


    private MONInterfaceModulosHome getMONInterfaceModulosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONInterfaceModulosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONInterfaceModulos"), MONInterfaceModulosHome.class);
  }


    private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }


    /**
     * @author: ssantana, 14/9/2005, por inc. COB-04
     * @throws es.indra.mare.common.exception.MareException
     * @param Long oidCliente
     */
  private void asignarCuotaEtapasPosteriores(Long oidCliente) throws MareException {
    UtilidadesLog.info("MONAsignacionCarteraPeriodo.asignarCuotaEtapasPosteriores(Long oidCliente):Entrada");
    RecordSet rEtapas = null;
    RecordSet rCuotas = null;
    Long[] arrayRetorno = null;
    DAOAsignacionCarteraPeriodo dao = new DAOAsignacionCarteraPeriodo();
    rEtapas = dao.recuperarEtapasCliente(oidCliente);
    AsignacionCobranzaLocalHome asigCobraLH = null;
    AsignacionCobranzaLocal asigCobraL = null;
    AsignacionCobranzaLocal asigCobraLCopia = null;
    try { 
        asigCobraLH =  this.getAsignacionCobranzaLocalHome();
        
        if ( !rEtapas.esVacio() ) {
           // Obtengo los oid de las Etapas. 
           Vector v = new Vector();
           long longitudR = rEtapas.getRowCount();
           BigDecimal bigBuffer = null;
           
           for (int i = 0; i <  longitudR; i++) {
             bigBuffer = (BigDecimal)rEtapas.getValueAt(i,0);
             v.add(new Long(bigBuffer.longValue()));
           }
           arrayRetorno = (Long[]) v.toArray(new Object[v.size()]);
           
           // Obtengo las cuotas del Cliente para esas Etapas
           rCuotas = dao.recuperarCuotasEtapasCliente(oidCliente, arrayRetorno);
           
           // Obtenemos el oid de Cronograma de Cobranzas del ultimo registro
           // (es la etapa mas avanzada).
           bigBuffer = (BigDecimal)rCuotas.getValueAt(rCuotas.getRowCount()-1, 2);
           Long oidCronoCobra = new Long(bigBuffer.longValue());
           /* 
            * Ahora recorremos el RecordSet de Cuotas, asignando las cuotas de las etapas
            * anteriores, a la Etapa mas Posterior (mas avanzada) y que la Asign.
            * tenga estado abierto.-
            */
            long longRCuotas = rCuotas.getRowCount();
            BigDecimal bigOidCuota = null;
            BigDecimal bigOidAsign = null;
            for (int i = 0; i < (longRCuotas-1); i++) {
               bigOidAsign = (BigDecimal) rCuotas.getValueAt(i,3);
               asigCobraL = asigCobraLH.findByPrimaryKey(new Long(bigOidAsign.longValue()));
               asigCobraL.setOidEstadoAsignacion(ConstantesCOB.OID_ESTA_ASIG_REASIGNADA);
               
               asigCobraLH.merge(asigCobraL);
               
               //Long pais, Long datosMovimientosCCC, Long sociedad, Long cartera
               asigCobraLCopia = asigCobraLH.create(asigCobraL.getPais(),
                                  asigCobraL.getDatosMovimientosCCC(),
                                  asigCobraL.getSociedad(),
                                  oidCronoCobra);
                                  
              asigCobraLCopia.setOidEstadoAsignacion(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
              asigCobraLCopia.setFechaAsignacion(asigCobraL.getFechaAsignacion());
              asigCobraLCopia.setImporteDeudaAsignada(asigCobraL.getImporteDeudaAsignada());
              asigCobraLCopia.setImporteDeudaCancelada(asigCobraL.getImporteDeudaCancelada());
              asigCobraLCopia.setImporteOriginalDeuda(asigCobraL.getImporteOriginalDeuda());
              asigCobraLCopia.setLiquidacion(asigCobraL.getLiquidacion());
              
              asigCobraLH.merge(asigCobraLCopia);
           }
        }
    
    } catch(NoResultException nre) {
        ctx.setRollbackOnly();
        nre.printStackTrace();
        throw new MareException(nre, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch(PersistenceException pex) {
        ctx.setRollbackOnly();
        pex.printStackTrace();
        throw new MareException(pex, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    } catch (MareException ex) {
       UtilidadesLog.error(ex);
       throw ex;
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    
    UtilidadesLog.info("MONAsignacionCarteraPeriodo.asignarCuotaEtapasPosteriores(Long oidCliente):Salida");
    return; 
  }

  private MovimientosCuentasCorrientesLocalHome getMovimientosCuentasCorrientesLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MovimientosCuentasCorrientesLocalHome)context.lookup("java:comp/env/MovimientosCuentasCorrientes");
  }


    /**@Autor: Hugo Mansi
     * @Fecha: 19/05/2005
     * @Recibe: dtoSalida con recordset
     * @Devuelve: BigDecimal con el total de la deuda a asignar al Supervisor en la etapa
     * @Descripcion: Suma todas las deudas que no estan en el rango de la etapa para conocer 
     * la cantidad a asignar al supervisor
     */
  
  private BigDecimal recuperarSumaASupervisor(DTOSalida dtoSalida){
    UtilidadesLog.info("recuperarSumaASupervisor:Entrada");
    BigDecimal total = new BigDecimal(0);
    RecordSet rs = dtoSalida.getResultado();
    if (!rs.esVacio()){
      UtilidadesLog.info("rs no es vacio " + dtoSalida.getResultado());
      for (int i = 0 ; i< rs.getRowCount(); i++){
       total = total.add((BigDecimal)rs.getValueAt(i,1));
      }
    }
    UtilidadesLog.info("recuperarSumaASupervisor:Salida " + total);
    return total;
  }
  
  /**@Autor: Hugo Mansi
   * @Fecha: 19/05/2005
   * @Recibe: Long oidCliente de la cuota que se está tratando
   * @Devuelve: boolean que indica si las deudas del cliente seran asignadas al supervisor 
   * @Descripcion: Este método retorna un valor que indica si la deuda del cliente sera 
   * asignada al supervisor
   */
   private boolean asignarASupervisor(Long oidCliente, DTOSalida dto){
       UtilidadesLog.info("asignarASupervisor:Entrada");
       RecordSet rs = dto.getResultado();
       if (!rs.esVacio()){
         for (int i = 0; i < rs.getRowCount(); i++){
           Long auxOidCli = new Long (((BigDecimal) rs.getValueAt(i,0)).longValue());
           if (oidCliente.equals(auxOidCli)){
             UtilidadesLog.info("asignarASupervisor: TRUE");
             return true;
           }
         }
       } 
       UtilidadesLog.info("asignarASupervisor: FALSE");
       return false;
     }
     
     private Long recuperoIdCartera(DTOCuotasAsignacion dtoCuotaActual, Long pais, 
                                    Long usuaSuper, Long idioma, Long oidPeri) throws MareException {
        UtilidadesLog.info("MONAsignacionCarteraPeriodo.recuperoIdCartera(DTOCuotasAsignacion dtoCuotaActual): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        Long resu = new Long(0);
        
        try
        {   bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException ex)
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }      
        
        if ((dtoCuotaActual.getOidRegion()!=null) &&
            (dtoCuotaActual.getOidZona()!=null) &&
            (dtoCuotaActual.getOidSeccion()!=null) &&
            (dtoCuotaActual.getOidTerritorio()!=null)){        
            
            query.append("Select cc.OID_CRON_COBR as IDCARTERA ");
            query.append("FROM COB_CRONO_COBRA cc ");
            query.append("WHERE cc.PAIS_OID_PAIS = " + pais.longValue());
            query.append(" AND cc.USCO_OID_USUA_COBR = " + usuaSuper.longValue());
            query.append(" AND cc.ETDE_OID_ETAP_DEUD = " + dtoCuotaActual.getOidEtapa().longValue());
            query.append(" AND cc.TCAB_OID_TIPO_CARG_ABON = " + dtoCuotaActual.getOidTipoCargo().longValue());
            query.append(" AND cc.ZSGV_OID_SUBG_VENT = " + dtoCuotaActual.getOidSubGerencia().longValue());
    
            query.append(" AND cc.ZORG_OID_REGI = " + dtoCuotaActual.getOidRegion().longValue());
            query.append(" AND cc.ZZON_OID_ZONA = " + dtoCuotaActual.getOidZona().longValue());
            query.append(" AND cc.ZSCC_OID_SECC = " + dtoCuotaActual.getOidSeccion().longValue());
            query.append(" AND cc.TERR_OID_TERR = " + dtoCuotaActual.getOidTerritorio().longValue());
            
            query.append(" AND cc.PERD_OID_PERI = " + oidPeri.longValue());
        
            try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            }
            catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex,
               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }    
        //si no recupero registros voy llendo hacia arriba, hasta encontrar o llegar a sub-gerencia ventas
        if ((rs==null)||(rs.esVacio())) {
            if ((dtoCuotaActual.getOidRegion()!=null) &&
                (dtoCuotaActual.getOidZona()!=null) &&
                (dtoCuotaActual.getOidSeccion()!=null)){
                
                StringBuffer query1 = new StringBuffer(); 
                query1.append("Select cc.OID_CRON_COBR as IDCARTERA ");
                query1.append("FROM COB_CRONO_COBRA cc ");
                query1.append("WHERE cc.PAIS_OID_PAIS = " + pais.longValue());
                query1.append(" AND cc.USCO_OID_USUA_COBR = " + usuaSuper.longValue());
                query1.append(" AND cc.ETDE_OID_ETAP_DEUD = " + dtoCuotaActual.getOidEtapa().longValue());
                query1.append(" AND cc.TCAB_OID_TIPO_CARG_ABON = " + dtoCuotaActual.getOidTipoCargo().longValue());
                query1.append(" AND cc.ZSGV_OID_SUBG_VENT = " + dtoCuotaActual.getOidSubGerencia().longValue());
        
                if (dtoCuotaActual.getOidRegion()!=null)
                    query1.append(" AND cc.ZORG_OID_REGI = " + dtoCuotaActual.getOidRegion().longValue());
                    
                if (dtoCuotaActual.getOidZona()!=null)    
                    query1.append(" AND cc.ZZON_OID_ZONA = " + dtoCuotaActual.getOidZona().longValue());
                    
                if (dtoCuotaActual.getOidSeccion()!=null)        
                    query1.append(" AND cc.ZSCC_OID_SECC = " + dtoCuotaActual.getOidSeccion().longValue());
                
                query1.append(" AND cc.PERD_OID_PERI = " + oidPeri.longValue());      
                try {
                   rs = bs.dbService.executeStaticQuery(query1.toString());
                }
                catch (Exception ex) {
                   UtilidadesLog.error("ERROR ", ex);
                   throw new MareException(ex,
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }
        if ((rs==null)||(rs.esVacio())) {
            if ((dtoCuotaActual.getOidRegion()!=null) &&
                (dtoCuotaActual.getOidZona()!=null)){
                
                StringBuffer query2 = new StringBuffer(); 
                query2.append("Select cc.OID_CRON_COBR as IDCARTERA ");
                query2.append("FROM COB_CRONO_COBRA cc ");
                query2.append("WHERE cc.PAIS_OID_PAIS = " + pais.longValue());
                query2.append(" AND cc.USCO_OID_USUA_COBR = " + usuaSuper.longValue());
                query2.append(" AND cc.ETDE_OID_ETAP_DEUD = " + dtoCuotaActual.getOidEtapa().longValue());
                query2.append(" AND cc.TCAB_OID_TIPO_CARG_ABON = " + dtoCuotaActual.getOidTipoCargo().longValue());
                query2.append(" AND cc.ZSGV_OID_SUBG_VENT = " + dtoCuotaActual.getOidSubGerencia().longValue());
        
                query2.append(" AND cc.ZORG_OID_REGI = " + dtoCuotaActual.getOidRegion().longValue());
                    
                query2.append(" AND cc.ZZON_OID_ZONA = " + dtoCuotaActual.getOidZona().longValue());
                    
                query2.append(" AND cc.PERD_OID_PERI = " + oidPeri.longValue());      
                try {
                   rs = bs.dbService.executeStaticQuery(query2.toString());
                }
                catch (Exception ex) {
                   UtilidadesLog.error("ERROR ", ex);
                   throw new MareException(ex,
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }
        if ((rs==null)||(rs.esVacio())) {
            if ((dtoCuotaActual.getOidRegion()!=null)){
                
                StringBuffer query3 = new StringBuffer(); 
                query3.append("Select cc.OID_CRON_COBR as IDCARTERA ");
                query3.append("FROM COB_CRONO_COBRA cc ");
                query3.append("WHERE cc.PAIS_OID_PAIS = " + pais.longValue());
                query3.append(" AND cc.USCO_OID_USUA_COBR = " + usuaSuper.longValue());
                query3.append(" AND cc.ETDE_OID_ETAP_DEUD = " + dtoCuotaActual.getOidEtapa().longValue());
                query3.append(" AND cc.TCAB_OID_TIPO_CARG_ABON = " + dtoCuotaActual.getOidTipoCargo().longValue());
                query3.append(" AND cc.ZSGV_OID_SUBG_VENT = " + dtoCuotaActual.getOidSubGerencia().longValue());
        
                query3.append(" AND cc.ZORG_OID_REGI = " + dtoCuotaActual.getOidRegion().longValue());
                    
                query3.append(" AND cc.PERD_OID_PERI = " + oidPeri.longValue());      
                try {
                   rs = bs.dbService.executeStaticQuery(query3.toString());
                }
                catch (Exception ex) {
                   UtilidadesLog.error("ERROR ", ex);
                   throw new MareException(ex,
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }
        if ((rs==null)||(rs.esVacio())) {
            StringBuffer query4 = new StringBuffer(); 
            query4.append("Select cc.OID_CRON_COBR as IDCARTERA ");
            query4.append("FROM COB_CRONO_COBRA cc ");
            query4.append("WHERE cc.PAIS_OID_PAIS = " + pais.longValue());
            query4.append(" AND cc.USCO_OID_USUA_COBR = " + usuaSuper.longValue());
            query4.append(" AND cc.ETDE_OID_ETAP_DEUD = " + dtoCuotaActual.getOidEtapa().longValue());
            query4.append(" AND cc.TCAB_OID_TIPO_CARG_ABON = " + dtoCuotaActual.getOidTipoCargo().longValue());
            query4.append(" AND cc.ZSGV_OID_SUBG_VENT = " + dtoCuotaActual.getOidSubGerencia().longValue());
    
            query4.append(" AND cc.PERD_OID_PERI = " + oidPeri.longValue());      
            try {
               rs = bs.dbService.executeStaticQuery(query4.toString());
            }
            catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex,
               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.debug("recuperoIdCartera, rs: " + rs);
        if ((rs==null)||(rs.esVacio())) {
            UtilidadesLog.debug("inserto en cronograma cobranza");  
            //inserto reg. en crono cobr., id de cartera seobtiene mediante:: genrar nro. de doc. de ped
            DTOCronogramaCobranza tmp = new DTOCronogramaCobranza();            
            tmp.setOidPais(pais);
            tmp.setOidIdioma(idioma);
            SecuenciadorOID sec = new SecuenciadorOID();
            Long proximo = sec.obtenerSiguienteValor("COB_CRCO_SEQ");
            Long cartera = obtenerIdCartera(tmp);            

            StringBuffer buff = new StringBuffer();
            buff.append(" INSERT INTO COB_CRONO_COBRA ( OID_CRON_COBR, COD_CART, FEC_CIER, FEC_ASIG, ");
            buff.append(" PAIS_OID_PAIS, PERD_OID_PERI, ZSGV_OID_SUBG_VENT,  ");
            buff.append(" TCAB_OID_TIPO_CARG_ABON, ETDE_OID_ETAP_DEUD, USCO_OID_USUA_COBR ");
            buff.append(" ) VALUES ( " );
            buff.append(proximo).append(",");
            buff.append(cartera).append(",");
            buff.append(" TRUNC(SYSDATE), ");
            buff.append(" TRUNC(SYSDATE), ");
            buff.append(pais).append(",");
            buff.append(oidPeri).append(",");
            buff.append(dtoCuotaActual.getOidSubGerencia()).append(",");
            buff.append(dtoCuotaActual.getOidTipoCargo()).append(",");
            buff.append(dtoCuotaActual.getOidEtapa()).append(",");
            buff.append(usuaSuper).append(")");
            UtilidadesLog.debug("insert: " + buff.toString());  
            try{
               BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
            }catch(Exception e){
               if(e instanceof MareException){
                  throw (MareException) e;
               }else{
                  throw new MareException(e);
               }
            }
         
            UtilidadesLog.info("MONAsignacionCarteraPeriodo.recuperoIdCartera(DTOCuotasAsignacion dtoCuotaActual): Salida (a)");
            return proximo;
        }
        
        //me q'do con el 1er. registro
        resu = this.bigDecimalToLong(rs.getValueAt(0, "IDCARTERA"));
        UtilidadesLog.info("MONAsignacionCarteraPeriodo.recuperoIdCartera(DTOCuotasAsignacion dtoCuotaActual): Salida (b)");
        return resu;
      }   
      
    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }          
    
 private CronogramaCobranzaLocalHome getCronogramaCobranzaLocalHome()
  {
    return new CronogramaCobranzaLocalHome();
  }
  private AsignacionCobranzaLocalHome getAsignacionCobranzaLocalHome()
  {
    return new AsignacionCobranzaLocalHome();
  }  

    private EtapasDeudaLocalHome getEtapasDeudaLocalHome()
  {
    return new EtapasDeudaLocalHome();
  }
    
}//fin del MON

