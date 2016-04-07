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

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesLog;
import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.BelcorpService;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOGenerarCronogramaCOBPeriodo;
import es.indra.sicc.dtos.cob.DTOCronogramaGenerado;
import es.indra.sicc.dtos.cob.DTOEBuscarCronogramaCOBPeriodo;
import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.cra.MONCronograma;
import es.indra.sicc.logicanegocio.cra.MONCronogramaHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;

import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;

import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.cob.CronogramaCobranzaLocal;
import es.indra.sicc.entidades.cob.CronogramaCobranzaLocalHome;

import java.sql.Timestamp;
import java.math.BigDecimal;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.FinderException;
import javax.ejb.CreateException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCronogramaCobranzasBean implements SessionBean 
{
  private SessionContext ctx;
  
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
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida consultarEtapasCobranza(DTOBelcorp dto) throws MareException
  {
    DAOCronogramaCobranzas daoCronoCob = new DAOCronogramaCobranzas();
    return daoCronoCob.consultarEtapasCobranza(dto);
  }
  /** 
  * @author ssantana, 28/2/2005
  * @param DTOColeccion dto
  * @return void
  * @exception MareException 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public void guardarCronogramaCobranzas(DTOColeccion dto) throws MareException{
    UtilidadesLog.info("MONCronogramaCobranzasBean.guardarCronogramaCobranzas(DTOColeccion dto): Entrada");
  
      ArrayList arrayCronogramas = dto.getLista();
      
      for (int i = 0; i < arrayCronogramas.size(); i++)
      {
        UtilidadesLog.debug("Bucle " + i);
        DTOCronogramaCobranza dtoCrono = (DTOCronogramaCobranza) arrayCronogramas.get(i);
        UtilidadesLog.debug("DTOCrono: " + dtoCrono);
        Long oidCobranza = dtoCrono.getOidCobranza();
        UtilidadesLog.debug("Obtiene oidCobranza: " + oidCobranza);
        
        if (oidCobranza == null)
        {
            // Entonces procede a generar un nuevo registro.
            UtilidadesLog.debug("OidCobranza es NULL, crea nueva tupla");
            CronogramaCobranzaLocalHome cronoLocalHome = null;
            CronogramaCobranzaLocal cronoLocal = null;
            try 
            {
              cronoLocalHome = this.getCronogramaCobranzaLocalHome();
              cronoLocal = cronoLocalHome.create( dtoCrono.getIdCartera(),   // IdCartera
                                                  dtoCrono.getFechaCierre(), // Fecha Cierre
                                                  dtoCrono.getOidPais(),  // Pais
                                                  dtoCrono.getOidPeriodo(),   // Periodo
                                                  dtoCrono.getOidSubgerenciaVentas(),   // SUBGV
                                                  dtoCrono.getOidTipoCargo(), // Tipo Cargo
                                                  dtoCrono.getOidEtapa(),  // Etapa Deuda
                                                  dtoCrono.getOidUsuarioCobranza() // Usuario Cobranza
                                                );
                } catch(PersistenceException e) {
                     ctx.setRollbackOnly();
                     e.printStackTrace();
                     throw new MareException(e,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }   
            
            cronoLocal.setFechaAsignacion(null);  // No existe en el DTO ese getter.
            cronoLocal.setFechaAuditoria(dtoCrono.getFechaAuditoria());
            cronoLocal.setFechaEvaluacion(dtoCrono.getFechaEvaluacion());
            cronoLocal.setObservaciones(dtoCrono.getObservaciones());
            
            // Setea tipificacion de ZON
            cronoLocal.setTerritorio(dtoCrono.getOidTerritorio());
            cronoLocal.setZona(dtoCrono.getOidZona());
            cronoLocal.setRegion(dtoCrono.getOidRegion());
            cronoLocal.setSeccion(dtoCrono.getOidSeccion());
            
            cronoLocalHome.merge(cronoLocal);
            
        } else
        {
            // Como ya existe la tupla, obtenemos la referencia a la misma con el 
            // oidCobranza
            UtilidadesLog.debug("OidCobranza es " + oidCobranza + ", modifica tupla existente");          
            CronogramaCobranzaLocalHome cronoLocalHome = null;
            CronogramaCobranzaLocal cronoLocal = null;
            try 
            {
              cronoLocalHome = this.getCronogramaCobranzaLocalHome();          
              cronoLocal = cronoLocalHome.findByPrimaryKey(oidCobranza);
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
            }
                            
            
            //cronoLocal.setFechaAsignacion(null);  // No existe en el DTO ese getter.
            cronoLocal.setFechaAuditoria(dtoCrono.getFechaAuditoria());
            cronoLocal.setFechaEvaluacion(dtoCrono.getFechaEvaluacion());
            
            // setFechaCierre(...) agregado por ssantana, 5/3/2005 - En Modificar Cronograma
            // la lista Editable tiene este campo como modificable.
            cronoLocal.setFechaCierre(dtoCrono.getFechaCierre());
            cronoLocal.setObservaciones(dtoCrono.getObservaciones());
            
            cronoLocalHome.merge(cronoLocal);

        } // Fin If
        
      } // Fin For
      
        UtilidadesLog.info("MONCronogramaCobranzasBean.guardarCronogramaCobranzas(DTOColeccion dto): Salida");
      
      return;
  }
  
  
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOOID dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida obtenerEtapasUsuarioCOB(DTOOID dto) throws MareException
  {
    DAOCronogramaCobranzas daoCronoCob = new DAOCronogramaCobranzas();
    return daoCronoCob.obtenerEtapasUsuarioCOB(dto);
  }
  /** 
  * @Author ssantana, 23/2/2005
  * @param DTOGenerarCronogramaCOBPeriodo dto
  * @return DTOCronogramaGenerado
  * @exception MareException 
  * @referencia SICC-DMCO-COB-201-324-N037
  * modificado 12/07/2005  pperanzola - rUsuarios puede tener columnas con valores nulos 
  */
  public DTOCronogramaGenerado generarCronogramaCobranzas(DTOGenerarCronogramaCOBPeriodo dto) throws MareException{
  
    UtilidadesLog.info("MONCronogramaCobranzasBean.generarCronogramaCobranzas(DTOGenerarCronogramaCOBPeriodo dto): Entrada");
  
    DTOCronogramaGenerado dtoResultado = null;
    DTOOID dtoOidPeriodo = null;    
    DTOOID dtoOidEtapa = null; 
    Timestamp stampFechaFacturacion = null;
    MONCronograma monCronograma = null;
    MONCronogramaHome monCronogramaHome = null;
    MONProcesosPED monProcesosPED = null;
    MONProcesosPEDHome monProcesosPEDHome = null;
    CanalLocal canalLocal= null;
    CanalLocalHome canalLocalHome = null;
    PeriodoLocal periodoLocal = null;     
    PeriodoLocalHome periodoLocalHome = null;
    MarcaLocal marcaLocal = null;
    MarcaLocalHome marcaLocalHome = null;
    DTOSalida dtoSalida = null;
    String descripcionPeriodo = null;
    String descripcionMarca = null;
    String descripcionCanal = null;
    ArrayList arrayEtapas = null;
    DAOCronogramaCobranzas daoCronoCobranzas = new DAOCronogramaCobranzas();

    try {
      monProcesosPEDHome = this.getMONProcesosPEDHome();
      monProcesosPED = monProcesosPEDHome.create();
    } catch (NamingException nEx)
    {
      UtilidadesLog.error(nEx);
      String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException( nEx, UtilidadesError.armarCodigoError(sCodigoError) );
    } catch (CreateException cEx)
    {
      UtilidadesLog.error(cEx);
      String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException( cEx, UtilidadesError.armarCodigoError(sCodigoError) );
    } catch (RemoteException rEx)
    {
      UtilidadesLog.error(rEx);
      String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException( rEx, UtilidadesError.armarCodigoError(sCodigoError) );
    }
    
    dtoResultado = new DTOCronogramaGenerado();
    dtoResultado.setMensaje(null);
    
    dtoOidPeriodo = new DTOOID();
    dtoOidPeriodo.setOid( dto.getPeriodo() );
    
    try {
      monCronogramaHome = this.getMONCronogramaHome();
      monCronograma = monCronogramaHome.create();
      //monCronograma.obtenerMayorFechaFacturacion(dtoOidPeriodo);      
      stampFechaFacturacion = monCronograma.obtenerMayorFechaFacturacion(dtoOidPeriodo);
      dtoSalida = monCronograma.buscarFechasFacPorZona(dtoOidPeriodo);
    } catch (NamingException nEx)
    {
      UtilidadesLog.error(nEx);
      String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException( nEx, UtilidadesError.armarCodigoError(sCodigoError) );
    } catch (CreateException cEx)
    {
      UtilidadesLog.error(cEx);
      String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException( cEx, UtilidadesError.armarCodigoError(sCodigoError) );
    } catch (RemoteException rEx)
    {
      UtilidadesLog.error(rEx);
      String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException( rEx, UtilidadesError.armarCodigoError(sCodigoError) );
    }
    
    RecordSet rFechasFacPorZona = dtoSalida.getResultado();
    UtilidadesLog.debug("RecordSet rFechasFacPorZona: " + rFechasFacPorZona);
    
    // ------------------------ Validamos RecordSet Fechas ---------------------------------
    if ( rFechasFacPorZona.esVacio() )
    {
      /* INC BELC300016572
       * cdos gPineda 01/06/2006
       */
      /*
      UtilidadesLog.debug("Recordset vacio - Lanza Excepcion COB-003");
      String sCodigoError = ErroresDeNegocio.COB_003;
      String sExplicacion = "Recordset vacio - Lanza Excepcion COB-003 - No se genera cronograma al no existir zonas definidas";
      throw new MareException(sExplicacion, 
                              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB,
                                                               "", 
                                                             sCodigoError));
      */
      UtilidadesLog.debug("Recordset vacio - Lanza Excepcion COB-004");
      String sCodigoError = ErroresDeNegocio.COB_004;
      String sExplicacion = "Recordset vacio - Lanza Excepcion COB-004 - No se genera cronograma de cobranzas al no existir cronograma definido para las zonas";
      throw new MareException(sExplicacion, 
                              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB,
                                                           "", 
                                                           sCodigoError));
      // FIN - BELC300016572
      
    } else
    {
        UtilidadesLog.debug("Recordset no es vacio");    
        Integer chequeoFechas = this.chequeaContenidoRecordSet(rFechasFacPorZona);
        if (chequeoFechas.intValue() == 1)   // Todas las fechas son vacias.
        {
            // Tira error COB-004
            UtilidadesLog.debug("Todas las fechas vacias - Lanza Excepcion COB-004");
            String sCodigoError = ErroresDeNegocio.COB_004;
            String sExplicacion = "Todas las fechas vacias - Lanza Excepcion COB-004 - No se genera cronograma de cobranzas al no existir cronograma definido para las zonas";
            throw new MareException(sExplicacion, 
                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB,
                                                                 "", 
                                                                 sCodigoError));
        }
        
        if (chequeoFechas.intValue() == 2)  // Hay alguna fecha vacia (pero no todas)
        {
            // Tire error COB-005
            UtilidadesLog.debug("Hay alguna fecha vacia, pero no todas - Lanza Excepcion COB-005");
            String sCodigoError = ErroresDeNegocio.COB_005;
            String sExplicacion = "Hay alguna fecha vacia - Lanza Excepcion COB-005 - No se ha encontrado cronograma de facturación para todas las zonas. Se ha generado cronograma de cobranzas con la información disponible";
            throw new MareException(sExplicacion, 
                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB,
                                                                     "", 
                                                                     sCodigoError));
        }
      
      
    }
    
    
    // ------------------------- Obtenemos Desc de Periodo, Marca y Canal ----------------------
    try {
      periodoLocalHome = new PeriodoLocalHome();
      canalLocalHome = new CanalLocalHome();
      marcaLocalHome = new MarcaLocalHome();
      
      periodoLocal = periodoLocalHome.findByPrimaryKey(dto.getPeriodo());
      marcaLocal = marcaLocalHome.findByPrimaryKey( periodoLocal.getOidMarca() );
    } catch (NoResultException e) {
      ctx.setRollbackOnly();
      UtilidadesLog.debug(e);
      String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
      throw new MareException( e, UtilidadesError.armarCodigoError(sCodigoError) );
    } catch (PersistenceException e) {
      ctx.setRollbackOnly();
      UtilidadesLog.debug(e);
      String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException( e, UtilidadesError.armarCodigoError(sCodigoError) );
    }
    
    descripcionPeriodo = periodoLocal.getNombrePeriodo();
    descripcionMarca = marcaLocal.getDes_marc();
    descripcionCanal = this.obtieneDescI18nCanal(periodoLocal.getOidCanal(), dto.getOidIdioma());
    
    // ------------------- Recorre atributo Dto.getEtapas() y arma array de Retorno ----------
    arrayEtapas = dto.getEtapas();
    UtilidadesLog.debug("Cantidad de etapas: " + arrayEtapas.size());
    ArrayList aListCronograma = new ArrayList();
    
    for (int i = 0; i < arrayEtapas.size(); i++)
    {
       UtilidadesLog.debug("**** Etapa " + i + "****");
       Long oidEtapa = (Long) arrayEtapas.get(i);
       RecordSet rUsuarios = daoCronoCobranzas.obtenerUsuariosEtapaCobranzaDetalle(dto.getOidPais(), 
                                                             oidEtapa,                                                              
                                                             dto.getOidIdioma()
                                                             );
       UtilidadesLog.debug("rUsuarios: " + rUsuarios);
       for (int j = 0; j < rUsuarios.getRowCount(); j++)
       {
          UtilidadesLog.debug("        ****** Usuario N° " + j);
          DTOCronogramaCobranza dtoCronogramaCobranza = new DTOCronogramaCobranza();
          Long nOidUsuario = null;
          Long nOidEtapa = null;
          Long nOidTipoCargoAbono = null;
          Long nOidTerritorio = null;
          Long nEdadMaxima = null;
          Long nEdadMinima = null;
          Long nOidSGV = null;
          Long nOidRegion = null;
          Long nOidZona = null;
          Long nOidSeccion = null;
          String sNumDocumento = null;
          DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
          Date sqlFechaCierre = null;
          
          /* Campos de la BD:
           * USU.OID_USUA_COBR USUARIO, 
           * EDTC.TCAB_OID_TIPO_CARG_ABON TIPO_CARGO, 
           * EDTC.ETDE_OID_ETAP_DEUD ETAPA_DEUDA, 
           * UECD.TERR_OID_TERR TERRITORIO, 
           * ED.VAL_EDAD_FINA EDAD_MAXIMA, 
             ED.VAL_EDAD_INIC EDAD_MINIMA */
             
            
          
          BigDecimal bigUsuario = (BigDecimal) rUsuarios.getValueAt(j, 0);
          if (bigUsuario != null)
           nOidUsuario = new Long(bigUsuario.longValue());
           
          BigDecimal bigTipoCargo = (BigDecimal) rUsuarios.getValueAt(j, 1);
          if (bigTipoCargo != null)
            nOidTipoCargoAbono = new Long(bigTipoCargo.longValue());
           
          BigDecimal bigEtapa = (BigDecimal) rUsuarios.getValueAt(j, 2);
          if (bigEtapa != null)
            nOidEtapa = new Long(bigEtapa.longValue());
            
            
          BigDecimal bigEdadFinal = (BigDecimal) rUsuarios.getValueAt(j, 4);
          if (bigEdadFinal != null)
            nEdadMaxima = new Long(bigEdadFinal.longValue());
            
          BigDecimal bigEdadInicial = (BigDecimal) rUsuarios.getValueAt(j, 5);
          if (bigEdadInicial != null)
            nEdadMinima = new Long(bigEdadInicial.longValue());          
          
          dtoCronogramaCobranza.setOidUsuarioCobranza(nOidUsuario);

          BigDecimal bigTerritorio = (BigDecimal) rUsuarios.getValueAt(j, 3);
          if (bigTerritorio != null)
            nOidTerritorio = new Long(bigTerritorio.longValue());
            
          String sDescUsuario = (String) rUsuarios.getValueAt(j,13);
          if (sDescUsuario == null)
            sDescUsuario = "";
          dtoCronogramaCobranza.setDescripcionUsuarioCobranza(sDescUsuario);

          String sDescTipoCargo = (String) rUsuarios.getValueAt(j,6);
          if (sDescTipoCargo == null)
              sDescTipoCargo = "";
          dtoCronogramaCobranza.setDescripcionTipoCargo(sDescTipoCargo);
          
          dtoCronogramaCobranza.setOidEtapa(nOidEtapa);
          
          String sCodEtapa = (String) rUsuarios.getValueAt(j, 7);
          if (sCodEtapa == null)
            sCodEtapa = "";
          dtoCronogramaCobranza.setCodigoEtapaDeuda(sCodEtapa);          
            
          String sDescSGV = (String) rUsuarios.getValueAt(j,8);
          if (sDescSGV == null)
            sDescSGV = "";
          dtoCronogramaCobranza.setDescripcionSubgerencia(sDescSGV);
            
          String sDescRegion = (String) rUsuarios.getValueAt(j,9);
          UtilidadesLog.debug("dEscripcion Region  "+ sDescRegion );
          if (sDescRegion == null)  
            sDescRegion = "";
          dtoCronogramaCobranza.setDescripcionRegion(sDescRegion);
          
          String sDescZona = (String) rUsuarios.getValueAt(j, 10);
          if (sDescZona == null)
            sDescZona = "";
          dtoCronogramaCobranza.setDescripcionZona(sDescZona);
          
          String sDescSeccion = (String) rUsuarios.getValueAt(j, 11);
          UtilidadesLog.debug("sDescSeccion sDescSeccion  "+ sDescSeccion );
          if (sDescSeccion == null)
            sDescSeccion = "";
          dtoCronogramaCobranza.setDescripcionSeccion(sDescSeccion);
          
          if (rUsuarios.getValueAt(j, 12) != null)
              dtoCronogramaCobranza.setDescripcionTerritorio(rUsuarios.getValueAt(j, 12).toString());
          UtilidadesLog.debug("sDescTerritorio  "+ rUsuarios.getValueAt(j, 12) );
          // Ahora manejo los Oids de la Tipificacion de ZON
          BigDecimal bigSGV = (BigDecimal) rUsuarios.getValueAt(j, 14);
          if (bigSGV != null)
            nOidSGV = new Long( bigSGV.longValue() );
          BigDecimal bigRegion = (BigDecimal) rUsuarios.getValueAt(j,15);
          if (bigRegion != null)
            nOidRegion = new Long( bigRegion.longValue());
          BigDecimal bigZona = (BigDecimal) rUsuarios.getValueAt(j, 16);
          if (bigZona != null)
            nOidZona = new Long( bigZona.longValue() );
          BigDecimal bigSeccion = (BigDecimal) rUsuarios.getValueAt(j, 17);
          if (bigSeccion != null)
            nOidSeccion = new Long( bigSeccion.longValue() );
            
          dtoCronogramaCobranza.setOidPeriodo(dto.getPeriodo());
          dtoCronogramaCobranza.setDescripcionPeriodo(descripcionPeriodo);
          dtoCronogramaCobranza.setDescripcionMarca(descripcionMarca);
          dtoCronogramaCobranza.setDescripcionCanal(descripcionCanal);
          dtoCronogramaCobranza.setOidTipoCargo(nOidTipoCargoAbono);
          dtoCronogramaCobranza.setOidTerritorio(nOidTerritorio);
          dtoCronogramaCobranza.setOidZona(nOidZona);
          dtoCronogramaCobranza.setOidSubgerenciaVentas(nOidSGV);
          dtoCronogramaCobranza.setOidSeccion(nOidSeccion);
          dtoCronogramaCobranza.setOidRegion(nOidRegion);
          
          dtoCronogramaCobranza.setOidPais(dto.getOidPais());
          
          dtoNumeroSolicitud.setOidPais(dto.getOidPais());
          dtoNumeroSolicitud.setOidIdioma(dto.getOidIdioma());
          dtoNumeroSolicitud.setOperacion("COB077");
          try {
            sNumDocumento = monProcesosPED.generaNumeroDocumento(dtoNumeroSolicitud);
          } catch (RemoteException rEx)
          {
            UtilidadesLog.error(rEx);
            String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException( rEx, UtilidadesError.armarCodigoError(sCodigoError) );
          }
          
          UtilidadesLog.debug("Obtuvo Numero Documento: " + sNumDocumento);
          dtoCronogramaCobranza.setIdCartera( new Long(sNumDocumento) );
          if (stampFechaFacturacion!=null)
            sqlFechaCierre = new java.sql.Date(stampFechaFacturacion.getTime() + nEdadMaxima.longValue()*86400000);
          dtoCronogramaCobranza.setFechaCierre(sqlFechaCierre);
          dtoCronogramaCobranza.setFechaEvaluacion(sqlFechaCierre);
          dtoCronogramaCobranza.setFechaAuditoria(null);
          dtoCronogramaCobranza.setObservaciones(null);
          dtoCronogramaCobranza.setEdadInicialEtapa(new Integer(nEdadMinima.intValue()));
          dtoCronogramaCobranza.setEdadFinalEtapa(new Integer(nEdadMaxima.intValue()));
          
          /* INC BELC300016904 cdos gPineda 02/06/2006 - INICIO */ 
          dtoCronogramaCobranza.setFechaFacturacion( stampFechaFacturacion );
          /* INC BELC300016904 cdos gPineda 02/06/2006 -  FIN   */ 
          
          aListCronograma.add(dtoCronogramaCobranza);
       }
     }
    
    // pperez 20/04/2005
    // Incidencia 16572  
    
    UtilidadesLog.debug("aListCronograma.size(): " + aListCronograma.size());
    if (aListCronograma.size() == 0)  {
            throw new MareException(new Exception(), 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB + ErroresDeNegocio.COB_004));
    }
    
    dtoResultado.setCronograma(aListCronograma);
    
    UtilidadesLog.info("MONCronogramaCobranzasBean.generarCronogramaCobranzas(DTOGenerarCronogramaCOBPeriodo dto): Salida");
    
    return dtoResultado;
  }
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOEBuscarCronogramaCOBPeriodo dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarCronogramaCOBPeriodo(DTOEBuscarCronogramaCOBPeriodo dto) throws MareException
  {
    DAOCronogramaCobranzas daoCronoCob = new DAOCronogramaCobranzas();
    return daoCronoCob.buscarCronogramaCOBPeriodo(dto);
  }

  private MONCronogramaHome getMONCronogramaHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONCronogramaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCronograma"), MONCronogramaHome.class);
  }
  
  
  private Integer chequeaContenidoRecordSet(RecordSet rFechasFacPorZona) 
  {
    // - Chequea si todas las fechas del RecordSet (que debe contener al menos 1 tupla)
    // son vacias. Si es asi, devuelve 1. 
    // - Si no, chequea si hay al menos una fecha vacia. Si es asi, retorna 2. 
    // - Si existen fechas en todas las tuplas, entonce retorna 0.
    // Nota: Formato de tupla del Recordset: [Zona, Fecha]
    
    Integer valueToReturn = new Integer(0);  // Por defecto retorna 0
    int i = 0;
    int cantFilas = rFechasFacPorZona.getRowCount();
    int nFlag = 0;
    
    while (i < cantFilas)
    {
      Object obj = rFechasFacPorZona.getValueAt(i, 1);    

      if (obj == null && nFlag != 2)  // Si es NULL y hasta ahora encontro fechas (nFlag != 2)
        nFlag = 1;
      
      if (obj != null && nFlag == 1) // Si encuentra una fecha no NULL y antes encontro alguna vacia.
        nFlag = 2;

      i++;
    }

    valueToReturn = new Integer(nFlag);
    return valueToReturn;
  }
  
  /**
   * @Author: ssantana, 22/2/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return String
   * @param Long oidIdioma
   * @param Long oidCanal
   */
  private String obtieneDescI18nCanal(Long oidCanal, Long oidIdioma) throws MareException{
    
    UtilidadesLog.info("MONCronogramaCobranzasBean.obtieneDescI18nCanal(Long oidCanal, Long oidIdioma): Entrada");
    
    String descI18n = null;
    RecordSet r = null;
    StringBuffer sqlQuery = new StringBuffer("");
    
    sqlQuery.append(" SELECT v.val_i18n ");
    sqlQuery.append(" FROM v_gen_i18n_sicc v "); 
    sqlQuery.append(" WHERE v.attr_enti = 'SEG_CANAL' ");
    sqlQuery.append(" AND v.attr_num_atri = 1 ");
    sqlQuery.append(" AND v.idio_oid_idio = " + oidIdioma);
    sqlQuery.append(" AND v.val_oid = " + oidCanal);
    
    BelcorpService bs = BelcorpService.getInstance();
    
    try {
      r = bs.dbService.executeStaticQuery(sqlQuery.toString() );
    } catch (Exception ex)
    {
      UtilidadesLog.error(ex);
      String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
      throw new MareException( ex, UtilidadesError.armarCodigoError(sCodigoError) );
    }
    
    // Si no hay Descripcion para Canal, para el Idioma solicitado
    // lanza un Error.
    if ( r.esVacio() )
    {
      String descError = "No hay Descripcion I18n para Canal " + oidCanal + 
                         ", Idioma " + oidIdioma;
      String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
      throw new MareException( descError, UtilidadesError.armarCodigoError(sCodigoError) );
    } else
    {
      // Si hay un valor, toma ese valor como String y lo retorna;
      descI18n = (String)r.getValueAt(0,0);
    }
    
    UtilidadesLog.info("MONCronogramaCobranzasBean.obtieneDescI18nCanal(Long oidCanal, Long oidIdioma): Salida");
    
    return descI18n;
  }


    private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }
  
  private CronogramaCobranzaLocalHome getCronogramaCobranzaLocalHome()
  {
   return new CronogramaCobranzaLocalHome();
  }

}
