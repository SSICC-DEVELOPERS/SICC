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
 *
 */

package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cra.util.TADCronograma;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;
import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.dtos.cra.DTODatosPlanificador;
import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.dtos.cra.DTOMensajes;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.entidades.cra.ActividadLocal;
import es.indra.sicc.entidades.cra.ActividadLocalHome;
import es.indra.sicc.entidades.cra.CronogramaGruposZonaLocal;
import es.indra.sicc.entidades.cra.CronogramaGruposZonaLocalHome;
import es.indra.sicc.entidades.cra.MensajesCRALocal;
import es.indra.sicc.entidades.cra.MensajesCRALocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.logicanegocio.cra.MONGestorPlanificacion;
import es.indra.sicc.logicanegocio.cra.MONGestorPlanificacionHome;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoActividad;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoActividadHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class CNCronograma implements ICNCronograma  {
  private TADCronograma tadCrono;
  private Vector periodos = null;


  public CNCronograma() {
  }


  /** 
   * Comprueba si existen registros en cronograma que cumplan: 
   * pais, marca, canal, código de periodo. 
   **/
  public DTOBoolean existeCronograma (DTOCronograma dto) throws MareException {
      UtilidadesLog.info("CNCronograma.existeCronograma(DTOCronograma dto):Entrada");
      try {
          MONPeriodosHome mph = this.getMONPeriodosHome();
          MONPeriodos monPerio = mph.create();
          DTOPeriodo dtoParam = new DTOPeriodo();
          dtoParam.setPais(dto.getOidPais());
          dtoParam.setMarca(dto.getMarca());
          dtoParam.setCanal(dto.getCanal());
          dtoParam.setCodigoPeriodo(dto.getCodigoPeriodo());
          DTOPeriodo periodo = monPerio.obtienePeriodosPMCCodigo(dtoParam);

          if (periodo.getOid() == null) //No se encontró el período
              throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          dto.setPeriodo(periodo.getOid());

      } catch (RemoteException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(NamingException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }

      DAOCronograma daoCrono = new DAOCronograma();
      RecordSet rs = daoCrono.obtieneCronogramaPMCP(dto.getOidPais(), dto.getMarca(), 
                                                        dto.getCanal(), dto.getPeriodo());
      DTOBoolean dtoB = new DTOBoolean();
      if (rs.esVacio()) {
          dtoB.setValor(false);
      } else {
          dtoB.setValor(true);
      }    
      UtilidadesLog.info("CNCronograma.existeCronograma(DTOCronograma dto):Salida");
      return dtoB;
      
  }
  
  
  /**
   * Genera el cronograma fase 2.
   **/
  public DTOCronograma generaCronograma(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("CNCronograma.generaCronograma(DTOCronograma dto):Entrada");
      tadCrono = new TADCronograma(dto, true);
      DTOPeriodo periodo;
      StringBuffer multiplesDeletesTarea = new StringBuffer();
      StringBuffer multiplesDeletesCrono = new StringBuffer();
      Long oidCrono;
      String nombreTarea;
      try {
          MONPeriodosHome mph = this.getMONPeriodosHome();
          MONPeriodos monPerio = mph.create();
          DTOPeriodo dtoParam = new DTOPeriodo();
          dtoParam.setPais(dto.getOidPais());
          dtoParam.setMarca(dto.getMarca());
          dtoParam.setCanal(dto.getCanal());
          dtoParam.setCodigoPeriodo(dto.getCodigoPeriodo());
          periodo = monPerio.obtienePeriodosPMCCodigo(dtoParam);

      } catch (RemoteException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(NamingException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      tadCrono.estableceDiasPeriodo(periodo.getFechaInicio(), periodo.getFechaFin());
      dto.setPeriodo(periodo.getOid());

      /*
       * Eliminamos cronograma fase 2 si ya ha sido generado previamente.  
       */
      DAOCronograma daoCrono = new DAOCronograma();
      RecordSet rs = daoCrono.obtieneCronogramaPMCP(dto.getOidPais(), dto.getMarca(), dto.getCanal(), dto.getPeriodo());
      for (int i = 0; i < rs.getRowCount(); i++) {
          oidCrono = new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString());
          if (rs.getValueAt(i, "NOMBRETAREA") != null) {
              nombreTarea = (String) rs.getValueAt(i, "NOMBRETAREA");
              try {
                  this.getMONGestorPlanificacionLocalHome().create().borrarTarea(nombreTarea);
              } catch(Exception e){
                  UtilidadesLog.error("ERROR",e);
              }
          }
          multiplesDeletesTarea.append(generaDeleteTarea(oidCrono));
          multiplesDeletesCrono.append(generaDeleteCronograma(oidCrono));                
      }

      try{
          BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",multiplesDeletesTarea.toString());
          BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",multiplesDeletesCrono.toString());
      } catch(Exception e) {
          UtilidadesLog.error("Error: " + multiplesDeletesTarea.append(multiplesDeletesCrono).toString(),e);
          throw new MareException(e);
      }

      /*
       * Generamos cronograma fase 2 a partir de cronograma fase 1.
       */
      Long oidCronoGpZn;
      rs = daoCrono.obtieneCronogramaGrupoPMCP(dto.getOidPais(), dto.getMarca(), dto.getCanal(), dto.getPeriodo());
      if (rs.esVacio()) {
               throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                 ErroresDeNegocio.GRUPOS_DE_ZONA_SIN_DATOS));                  
      }
      for (int i = 0; i < rs.getRowCount(); i++) {
          oidCronoGpZn = new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString());
          this.generaActividadZona(oidCronoGpZn, dto.getOidIdioma(), dto);
      }
      UtilidadesLog.info("CNCronograma.generaCronograma(DTOCronograma dto):Salida");
      return tadCrono.getCronograma();
  }


  /** 
   * Genera una actividad de una zona del cronograma, obteniendo la información de la que se creó para su 
   * grupo de zonas del cronograma de fase 1. 
   **/
  private ArrayList generaActividadZona (Long oidCronoGrupo, Long idioma, DTOAuditableSICC dtoAudit) throws MareException {
      UtilidadesLog.info("CNCronograma.generaActividadZona (Long oidCronoGrupo, Long idioma, DTOAuditableSICC dtoAudit):Entrada");
      ActividadLocal actividad;
      CronogramaGruposZonaLocal crono;
      PeriodoLocal periodo;
      PeriodoLocalHome perioLocalHome;
      Entidadi18nLocal actividadDescripcion;
      ArrayList idVistasOrigen = null;
      DTOActividad actividadOrigen;    
      DTOActividadGrupo actividadCronoOrigen;
      Date fechaPrevista;

      try {
          CronogramaGruposZonaLocalHome cronoLocalHome = new CronogramaGruposZonaLocalHome();
          crono = cronoLocalHome.findByPrimaryKey(oidCronoGrupo);
          ActividadLocalHome actLocalHome = new ActividadLocalHome();
          actividad = actLocalHome.findByPrimaryKey(crono.getActividad());

          //Incidencia 5635
          // Comprueba si la actividad ya ha sido añadida. En tal caso, devuelve el idVista de la actividad 
          idVistasOrigen = existeActividad(crono.getActividad(), crono.getGrupoZona(), crono.getFechaPrevista());
          if (idVistasOrigen != null) {          
              return idVistasOrigen;
          }
          
          // si tiene una actividad origen, la cual no referencia a otro periodo.
          if ( crono.getOidPeriodoReferencia() == null) {
              if ((crono.getIdVistaOrigen() != null) ) {
                  UtilidadesLog.debug("con origen mismo periodo: " + crono.getActividad() + " --  " + crono.getIdVista());
                  DAOCRA dao = new DAOCRA();
                  Long cronoOrigen = dao.obtieneOrigenCronograma(crono.getOid());
                  idVistasOrigen = generaActividadZona(cronoOrigen, idioma, dtoAudit);
              }              
          } else {
              UtilidadesLog.debug("con origen otro periodo: " + crono.getActividad() + " --  " + crono.getIdVista());
          }

          perioLocalHome = new PeriodoLocalHome();
          periodo = perioLocalHome.findByPrimaryKey(crono.getPeriodo());
          Entidadi18nLocalHome i18nLocalHome = new Entidadi18nLocalHome();
          actividadDescripcion = i18nLocalHome.findByEntAtrIdioPK("CRA_ACTIV", new Long(1), idioma, crono.getActividad());
      } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            throw new MareException(finderException, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
      } catch (MareException mEx){
            UtilidadesLog.error(mEx);
            throw mEx;
      } catch (Exception exception){
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }      

      //Inc. 5635
      DAOCronograma dao = new DAOCronograma();
      RecordSet rs = dao.obtieneZonasDeGrupo(crono.getGrupoZona());
      int numeroZona = 0;
      boolean agregar = false;
      if (idVistasOrigen == null) {
          agregar = true;
          idVistasOrigen = new ArrayList();
      }
      for (int i = 0; i < rs.getRowCount(); i++) {
          DTOActividadGrupo dtoActividad = new DTOActividadGrupo();
          numeroZona = i; //Para seguir el DT

          Long oidZona = new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString());
          dtoActividad.setGrupo(oidZona);
          String desZona = (String) rs.getValueAt(i, "DESCRIPCION");
          dtoActividad.setTextoGrupo(desZona);

          dtoActividad.setFechaPrevista(crono.getFechaPrevista());
          dtoActividad.setFecha0(crono.getFecha0());
          dtoActividad.setFechaFinal(crono.getFechaFinal());
          dtoActividad.setFechaMedia(crono.getFechaMedia());
          dtoActividad.setOid(null);
          dtoActividad.setTipoDias(crono.getTipoDias());
          dtoActividad.setActividad(crono.getActividad());
          // si vuelve de la recursion, entonces encadenamos la actvidad con el idVistaOrigen
          if (!agregar) 
              dtoActividad.setActividadOrigen((Integer) idVistasOrigen.get(numeroZona));

          dtoActividad.setPeriodo(crono.getPeriodo());
          dtoActividad.setTipoFacturacion(crono.getTipoFacturacion());
          dtoActividad.setFechaIniPeriodo(periodo.getFechainicio());
          dtoActividad.setFechaFinPeriodo(periodo.getFechaFin());
          dtoActividad.setTextoActividad(actividadDescripcion.getDetalle());
          dtoActividad.setCodigo(actividad.getCodigoActividad());
          dtoActividad.setIndFija(Boolean.FALSE);
          dtoActividad.setTipoActividad(actividad.getTipoActividad());
          if ( actividad.getTipoActividad().intValue() == ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() ) {
                dtoActividad.setDiasDesplazamiento(crono.getNumDiasDesplazamiento());
                dtoActividad.setPeriodoReferencia(crono.getOidPeriodoReferencia());
                dtoActividad.setNombrePeriodoReferencia(this.obtenerNombrePeriodoReferencia(periodo));
                actividadOrigen = this.obtenerDatosActividad(actividad.getOidActividadOrigen());
                dtoActividad.setCodigoActividadOrigen(actividadOrigen.getCodigoActividad());
                dtoActividad.setNombreActividadOrigen(actividadOrigen.getNombreActividad());

                actividadCronoOrigen = this.obtenerActividadOrigenDeOtroPeriodo(crono.getOidPeriodoReferencia(), oidZona, actividad.getOidActividadOrigen());
                if (actividadCronoOrigen != null) {
                    dtoActividad.setIdVistaOrigenOtroPeriodo(actividadCronoOrigen.getIdVista());
                    // Establece la fecha prevista de forma similar a fase 1 con respecto a los feriados y demas.
                    fechaPrevista = this.estableceFechaPrevista(crono.getNumDiasDesplazamiento(), actividad, crono.getGrupoZona(), actividadCronoOrigen.getFechaPrevista());
                    dtoActividad.setFechaPrevista(new Timestamp(fechaPrevista.getTime()));
                    dtoActividad.setIndPendienteOrigen(Boolean.FALSE);
                } else {
                    if ( ! dtoActividad.getPeriodo().equals(dtoActividad.getPeriodoReferencia())) {
                        dtoActividad.setIndPendienteOrigen(Boolean.TRUE);
                    } else {
                        dtoActividad.setIndPendienteOrigen(Boolean.FALSE);
                    }
                }
          }  
          if (agregar)
              idVistasOrigen.add(tadCrono.insertaActividadGrupo(oidZona, dtoActividad));
          else
              idVistasOrigen.set(numeroZona, tadCrono.insertaActividadGrupo(oidZona, dtoActividad));
      }
      UtilidadesLog.info("CNCronograma.generaActividadZona (Long oidCronoGrupo, Long idioma, DTOAuditableSICC dtoAudit):Salida");
      return idVistasOrigen;

  }


    /**
    * Establece la fecha prevista de una actividad de tipo referencia a otro periodo.
    * Diferencia entre tipo de dias laborables o calendario.
    * - Si tipo de dias es calendario: se verifica que el día en el que se tiene que realizar la actividad
    * (Fecha de la actividad de Origen + número de días) no es festivo,
    * si lo es, se busca el siguiente día No Festivo. (Día del calendario del sistema que no esté en la entidad de feriados.).
    * - Si el tipo de días es Laborables: se debe verificar el numero de días no laborables que existen 
    * en el período de tiempo transcurrido desde el inicio de la actividad de Origen hasta el número de días,
    * y se le suman a la fecha (Fecha inicio actividad + número de días + número de festivos), 
    * validando que no caiga la nueva fecha en festivo.
    * Nota: el atributo inLaborables tiene 1 cuando son dias calendario (continuos) y 0 cuando son dias laborables.
    * @autor gdmarzi
    */
    public Date estableceFechaPrevista(Integer diasDesplazamiento, ActividadLocal actividad, Long oidGrupoZona, Timestamp fechaActividadOrigen) throws MareException {
        UtilidadesLog.info("CNCronograma.estableceFechaPrevista():Entrada");
        CNCronogramaGrupos cnCronoGrupos = new CNCronogramaGrupos();
        Date fechaOrigen;
        Date fechaPrevista;
        fechaOrigen = new Date(fechaActividadOrigen.getTime());
        // -> si tipo de dias es calendario (continuos)
        if (actividad.getInLaborables() != null && actividad.getInLaborables().booleanValue()) {
            // obtiene el siguiente dia no festivo a partir de (Fecha inicio actividad + número de días).
            fechaPrevista = cnCronoGrupos.siguienteNoFestivo(fechaOrigen, new Long(diasDesplazamiento.longValue()), actividad.getOid(), oidGrupoZona);
        } else {
            // -> si tipo de dias es laborables
            // obtiene el siguiente dia Laborable a partir de (Fecha inicio actividad + número de días + número de festivos y no laborables).
            fechaPrevista = cnCronoGrupos.fechaLaborablePrevista(fechaOrigen, new Long(diasDesplazamiento.longValue()), actividad.getOid(), oidGrupoZona);
        }
        UtilidadesLog.info("CNCronograma.estableceFechaPrevista():Salida");
        return fechaPrevista;
    }


   /**
    * Obtiene todos los periodos del año, segun el periodo referenciado.
    * @autor gdmarzi
    */
   private Vector obtenerPeriodosMismoAnio(PeriodoLocal periodo) throws MareException{
        UtilidadesLog.info("CNCronogramaGrupos.obtenerPeriodosMismoAnio():Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        Vector periodos = new Vector();
        DTOPeriodo dtoPeriodo;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        query.append(" SELECT peri.OID_PERI, peri.VAL_NOMB_PERI ");
        query.append(" FROM CRA_PERIO peri, SEG_PERIO_CORPO corpo ");
        query.append(" WHERE peri.PERI_OID_PERI = corpo.OID_PERI ");
        query.append(" AND peri.PAIS_OID_PAIS = " + periodo.getOidPais() );
        query.append(" AND peri.MARC_OID_MARC = " + periodo.getOidMarca() );
        query.append(" AND peri.CANA_OID_CANA = " + periodo.getOidCanal() );
        query.append(" AND corpo.VAL_ANIO = ( SELECT pc.VAL_ANIO ");
        query.append("                        FROM CRA_PERIO pe, SEG_PERIO_CORPO pc ");
        query.append("                        WHERE pe.OID_PERI = " + periodo.getOid());
        query.append("                        AND pe.PERI_OID_PERI = pc.OID_PERI ) ");
        query.append(" ORDER BY peri.FEC_INIC ");
        try{
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            dtoPeriodo = new DTOPeriodo();
            dtoPeriodo.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID_PERI")).longValue()));
            dtoPeriodo.setNombre((String)rs.getValueAt(i,"VAL_NOMB_PERI"));
            periodos.addElement(dtoPeriodo);
        }

        UtilidadesLog.info("CNCronograma.obtenerPeriodosMismoAnio():Salida");
        return periodos;
   }


   /**
    * Retorna el nombre del periodo de referencia.
    * @autor gdmarzi
    */
   private String obtenerNombrePeriodoReferencia(PeriodoLocal periodo) throws MareException{
        UtilidadesLog.info("CNCronograma.obtenerNombrePeriodoReferencia():Entrada");
        DTOPeriodo periodoReferencia;
        Long oidPeriodo;
        boolean encontre = false;
        //Obtiene todos los periodos del año, segun el periodo referenciado.
        if (periodos == null) {
            periodos = this.obtenerPeriodosMismoAnio(periodo);
        }
        Iterator iter = periodos.iterator();
        int ubicacion = 0;
        while (iter.hasNext() && ( ! encontre)) {
            oidPeriodo = ((DTOPeriodo)iter.next()).getOid();
            if (oidPeriodo.longValue() == periodo.getOid().longValue()) {
                encontre = true;
            } else {
                ubicacion = ubicacion + 1;
            }
        }
        periodoReferencia = (DTOPeriodo)periodos.elementAt(ubicacion);
        UtilidadesLog.info("CNCronogramaGrupos.obtenerPeriodoReferencia():Salida");
        return periodoReferencia.getNombre();        
   }


    /**
     * Actualiza las actividades del cronograma sobre CRA_CRONO.
     * @cambio mejoras por performance
     * @detalle se realiza insert masivo al crear las actividades del cronograma.
     * @detalle se utiliza un hash de procesos para cada actividad.
     * @autor gdmarzi
     * @cambio COL-CRA-01 Se actualizan las actividades de campañas anteriores que tenga como referencia
     *         las actividades de esta campaña.
     * @autor gdmarzi
     * 
     * CHANGELOG
     * ---------
     * dmorello, 02/07/2008 - Cambio CRA-01
     * - Se modifica llamada al metodo actualizarActividadesOtrosPeriodos debido a su nuevo nombre
     * - Se agrega parametro false a dicha llamada para que actualice las actividades con pendiente origen = false
     * 
     * jrivas 20080721 3/9/2008
     * Se crea el nuevo metodo, para salterase la parte de la llamada a actualizarActividadesOtrosPeriodos
     **/
    //jrivas 20080721 3/9/2008
    public void actualizaCronograma (DTOCronograma dto) throws MareException {
        this.actualizaCronograma(dto, true);
    }
    
    //jrivas 20080721 3/9/2008
    public void actualizaCronograma (DTOCronograma dto, boolean ejecutar) throws MareException {
        UtilidadesLog.info("CNCronograma.actualizaCronograma (DTOCronograma dto):Entrada");
        Cronometrador.startTransaction("actualizaCronograma");   
        BelcorpService bs;
        StringBuffer multiplesInsertsCrono = new StringBuffer();
        StringBuffer multiplesInsertsTarea = new StringBuffer();
        StringBuffer insertTarea;
        Long oidCrono;
        String nombreTarea;
        DTOActividadGrupo dtoA;
        DAOCronograma daoCrono = new DAOCronograma();
        ArrayList procesosAPlanificar = new ArrayList();
        Iterator iterProcesosAPlanificar;
        Hashtable hashActividadProcesos = new Hashtable();
        DTODatosPlanificador dtoDatosPlanificador;
        MONGestorPlanificacion monGestorPlanificacion;
        
        try {
            MONGestorPlanificacionHome monGestorPlanificacionHome = this.getMONGestorPlanificacionHome();
            monGestorPlanificacion = monGestorPlanificacionHome.create();
        } catch(NamingException e) {
              UtilidadesLog.error(e);            
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // 1.- Crea el tad cronograma
        tadCrono = new TADCronograma(dto);
        // 2.- Obtiene las actividades
        Vector actividades = tadCrono.obtieneActividades();
        if (actividades != null) {
            Cronometrador.startTransaction("crearActividadesQuartz");   
            // 3.- Por cada actividad se crea una linea en el cronograma.
            for (int i = 0; i < actividades.size(); i++) {
                dtoA = (DTOActividadGrupo) actividades.get(i);
                // Arma el insert de la actividad
                oidCrono = this.armarInsertCronograma(dtoA, multiplesInsertsCrono);                
                // si la fecha prevista de la actividad todavia no paso 
                if (dtoA.getFechaPrevista().getTime()>=System.currentTimeMillis()){
                    /** QUARTZ */
                    // 3.1. Obtenemos los procesos asociados a la activiadas para luego tratarlos como tareas programadas.
                    if ( hashActividadProcesos.containsKey(dtoA.getActividad()) ) {
                        procesosAPlanificar = (ArrayList)hashActividadProcesos.get(dtoA.getActividad());
                    } else {
                        UtilidadesLog.debug("obtenerProcesosAsociadosActividad para: " + dtoA.getActividad());
                        procesosAPlanificar = daoCrono.obtenerProcesosAsociadosActividad(dtoA.getActividad());
                        hashActividadProcesos.put(dtoA.getActividad(), procesosAPlanificar);
                    }
                    // 3.2. Por cada proceso a planificar se crea un tarea mediante quartz. 
                    iterProcesosAPlanificar = procesosAPlanificar.iterator();
                    while (iterProcesosAPlanificar.hasNext()) {
                            // 3.2.3.Creamos una instancia de un objeto DTODatosPlanificador 
                            dtoDatosPlanificador = new DTODatosPlanificador();
                            dtoDatosPlanificador.setPais(dto.getOidPais());
                            dtoDatosPlanificador.setMarca(dto.getMarca());
                            dtoDatosPlanificador.setCanal(dto.getCanal());
                            dtoDatosPlanificador.setPeriodo(dto.getPeriodo());
                            dtoDatosPlanificador.setIdNegocio((String)iterProcesosAPlanificar.next());
                            dtoDatosPlanificador.setFechaEjecucion(new Timestamp(dtoA.getFechaPrevista().getTime()));
                            // 3.2.4. Llamamos al método MONGestorPlanificador.crearTarea, pasandole el dtoDatosPlanificacion
                            try {
                                nombreTarea = monGestorPlanificacion.crearTarea(dtoDatosPlanificador);
                            } catch (RemoteException e) {
                                UtilidadesLog.error(e); 
                                throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                            }
                            // Arma el insert de la tarea
                            insertTarea = this.armarInsertTarea(nombreTarea, oidCrono);                
                            multiplesInsertsTarea.append(insertTarea);
                    }
                    // Cleal CRA-03 se elimina el llamado a compruebaActividadMensajes()
                }
            } //for
            Cronometrador.endTransaction("crearActividadesQuartz");   

            Cronometrador.startTransaction("multiplesInsertsCrono");   
            // Creamos las actividades del cronograma y las tareas de cada actividad
            UtilidadesLog.debug(multiplesInsertsCrono.toString());
            try {
                bs = BelcorpService.getInstance();
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", multiplesInsertsCrono.toString());
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", multiplesInsertsTarea.toString());
            } catch (MareException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            } catch (Exception e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            Cronometrador.endTransaction("multiplesInsertsCrono");   

            //jrivas 20080721 3/9/2008
            if (ejecutar) {
                this.actualizarActividadesOtrosPeriodos(dto, false);
            }

            // Generamos mensajes por zona
           // this.generarMensajesPorZona(actividades, dto);
           //cambio 20080793
        }
        Cronometrador.endTransaction("actualizaCronograma");   
        UtilidadesLog.info("CNCronograma.actualizaCronograma (DTOCronograma dto):Salida");
    }


  /**
   * Cambio CRA-01
   * Actualiza las actividades de otras campañas que tenga como referencia las actividades de esta campaña.
   * Las campañas donde se buscan actividades para actualizar son anteriores al DTOCronograma recibido,
   * y pueden ser posteriores en caso de que el parametro pendienteOrigen sea true, que es el caso en el cual
   * el cronograma del DTO recibido se esta eliminando.
   * @param dto DTOCronograma que contiene la info del cronograma que se está generando
   * @param pendienteOrigen flag que indica si las actividades se actualizan con IND_PEND_ORIG activado o no
   * @author dmorello
   * @since 09-jun-2008
   * 
   * CHANGELOG
   * ---------
   * dmorello, 02/07/2008 - Cambio CRA-01:
   *     - Cambia nombre del metodo de actualizarActividadesPeriodosAnteriores a actualizarActividadesOtrosPeriodos
   *     - Agrego parametro boolean pendienteOrigen
   *     - Con este cambio, el metodo sirve para generacion, modificacion y eliminacion de cronograma.
   */
  private void actualizarActividadesOtrosPeriodos(DTOCronograma dto, boolean pendienteOrigen) throws MareException {
    UtilidadesLog.info("CNCronograma.actualizarActividadesPeriodosAnteriores(DTOCronograma dto): Entrada");
    
    // 1. Obtengo el período actual
    DTOPeriodo dtoPeriodoActual = null;
    try {
        MONPeriodos mon = this.getMONPeriodosHome().create();
        dtoPeriodoActual = mon.obtienePeriodoActual(dto.getOidPais(),
                                                               dto.getMarca(),
                                                               dto.getCanal());
    } catch (NamingException e) {
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    } catch (CreateException e) {
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    } catch (RemoteException e) {
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    
    // 2. Obtengo periodos anteriores al generado y posteriores al actual
    //    Si actualizo con pendiente origen true, tomo tambien periodos posteriores al generado
    //    Si no encuentro, finaliza el método
    boolean incluirPeriodosPosterioresGenerado = pendienteOrigen;
    RecordSet periodos = this.obtenerPeriodosAnterioresCronograma(dto, dtoPeriodoActual, incluirPeriodosPosterioresGenerado);
    if (periodos != null && periodos.getRowCount() > 0) {
        UtilidadesLog.debug("cant de periodos anteriores: " + periodos.getRowCount());
    
        // 3. Busco actividades de los periodos hallados que referencien a actividades
        //    del cronograma generado. Si no las hay termina el metodo.
        Long[] oids = new Long[periodos.getRowCount()];
        for (int n = 0; n < oids.length; n++) {
            oids[n] = new Long(((BigDecimal)periodos.getValueAt(n, "OID_PERI")).longValue());
        }
        RecordSet rs = this.obtenerActividadesRefPeriodo(oids, dto.getPeriodo());
        UtilidadesLog.debug("cant actividades ref periodo generado: " + rs.getRowCount());
        if (!rs.esVacio()) {
        
            TADCronograma tad = new TADCronograma(dto);
            Vector actividades = tad.obtieneActividades();
            HashMap actividadesActualizar = new HashMap();
            
            // 4. Recorro las actividades del cronograma generado y veo si son
            //    referenciadas por alguna de las actividades de periodos anteriores 
            //    Para las que cumplan con ello armo update SQL
            for (int i = 0; i < actividades.size(); i++) {
                DTOActividadGrupo activIngresada = (DTOActividadGrupo)actividades.get(i);
                long oidActivIngresada = activIngresada.getActividad().longValue();
                long oidZonaIngresada = activIngresada.getGrupo().longValue();
                // Recorro actividades de periodos anteriores obteniendo actividad referenciada
                for (int j = 0; j < rs.getRowCount(); j++) {
                    long oidActivRef = ((BigDecimal)rs.getValueAt(j, "CACT_OID_ACTI")).longValue();
                    long oidZonaRef = ((BigDecimal)rs.getValueAt(j, "ZZON_OID_ZONA")).longValue();
                    if (oidActivIngresada == oidActivRef && oidZonaIngresada == oidZonaRef) {
                        // Calculo la nueva fecha de inicio de la actividad
                        // Si actualizo a pendienteOrigen = true, la fecha debe tomar como valor
                        // la fecha de inicio del periodo donde esta la actividad
                        Long oidCronograma = new Long(((BigDecimal)rs.getValueAt(j, "OID_CRON")).longValue());
                        Date nuevaFechaInicio = null;
                        if (pendienteOrigen) {
                            // Tomo la fecha de inicio del periodo al cual pertenece la actividad
                            long oidPeriodo = ((BigDecimal)rs.getValueAt(j, "PERD_OID_PERI")).longValue();
                            int pos = 0;
                            while (oidPeriodo != ((BigDecimal)periodos.getValueAt(pos, "OID_PERI")).longValue()) {
                                pos++;
                            }
                            nuevaFechaInicio = (Date)periodos.getValueAt(pos, "FEC_INIC");
                        } else {
                            int numDiasDespl = ((BigDecimal)rs.getValueAt(j, "NUM_DIAS_DESP")).intValue();
                            int msegDespl = numDiasDespl * 24 * 3600 * 1000;
                            nuevaFechaInicio = new Date(activIngresada.getFechaPrevista().getTime() + msegDespl);
                        }
                        Date fechaInicio = (Date)actividadesActualizar.get(oidCronograma);
                        if (fechaInicio == null) {
                            actividadesActualizar.put(oidCronograma, nuevaFechaInicio);
                        } else {
                            if (!pendienteOrigen) {
                                if (nuevaFechaInicio.compareTo(fechaInicio) < 0) {
                                    actividadesActualizar.put(oidCronograma, nuevaFechaInicio);
                                }
                            }
                        }
                        rs.removeRow(j--);
                    }
                }
            }
            
            // 5. Actualizo las actividades seleccionadas en el ciclo anterior
            if (actividadesActualizar.size() > 0) {
                this.actualizarFechaInicioActividades(actividadesActualizar, pendienteOrigen);
            }
        } else {
            UtilidadesLog.debug("No se encontraron actividades de períodos anteriores para actualizar");
        }
    } else {
        UtilidadesLog.debug("No se encontraron períodos anteriores al del cronograma generado");
    }

    UtilidadesLog.info("CNCronograma.actualizarActividadesPeriodosAnteriores(DTOCronograma dto): Salida");
  }
  
  /**
   * Cambio CRA-01
   * Busca los períodos anteriores al período generado (recibido por parámetro
   * en el DTOCronograma) cuya fecha de inicio sea posterior a la del DTOPeriodo
   * recibido; segun el valor del boolean recibido, puede tomar también (o no)
   * los periodos posteriores al del DTOCronograma, siempre que sean posteriores
   * al del DTOPeriodo.
   * 
   * @param dto DTOCronograma con la informacion del cronograma generado
   * @param dtoPeriodo DTOPeriodo que contenga la info de un periodo.
   * @param incluirPeriodosPosterioresGenerado Boolean que indica si tomo los periodos posteriores al generado.
   * @author dmorello
   * @since 09-jun-2008
   * 
   * CHANGELOG
   * ---------
   * dmorello, 02/07/2008 - Cambio CRA-01: Cambia tipo de retorno a RecordSet
   *                                       Se agrega parámetro incluirPeriodosPosterioresGenerado
   *                                       Se recupera tambien fecha de inicio
   */
  private RecordSet obtenerPeriodosAnterioresCronograma(DTOCronograma dto, DTOPeriodo dtoPeriodo,
        boolean incluirPeriodosPosterioresGenerado) throws MareException {
        
    UtilidadesLog.info("CNCronograma.obtenerPeriodosAnterioresActual(DTOCronograma dto, Date fechaIniPeriActual): Entrada");
  
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    StringBuffer query = new StringBuffer();
    Vector parametros = new Vector();
    query.append(" SELECT oid_peri, fec_inic ");
    query.append("   FROM cra_perio peri ");
    query.append("  WHERE peri.pais_oid_pais = ? ");
    parametros.add(dto.getOidPais());
    query.append("    AND peri.MARC_OID_MARC = ? ");
    parametros.add(dto.getMarca());
    query.append("    AND peri.CANA_OID_CANA = ? ");
    parametros.add(dto.getCanal());
    query.append("    AND peri.VAL_ESTA = 1 ");
    query.append("    AND peri.FEC_INIC > TO_DATE(? , 'DD/MM/YYYY')"); // Periodo actual
    parametros.add(sdf.format(dtoPeriodo.getFechaInicio()));
    if (!incluirPeriodosPosterioresGenerado) {
        query.append("    AND peri.FEC_INIC < TO_DATE(? , 'DD/MM/YYYY')"); // Periodo generado
        parametros.add(sdf.format(dto.getFechaIniPeriodo()));
    } else {
        // Excluyo de los resultados el periodo del cronograma eliminado
        query.append("    AND peri.OID_PERI != ").append(dto.getPeriodo());
    }
    
    RecordSet rs = null;
    try {
        rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
    } catch (Exception e) {
        String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    
    UtilidadesLog.info("CNCronograma.obtenerPeriodosAnterioresActual(DTOCronograma dto, Date fechaIniPeriActual): Entrada");
    return rs;
  }
  
  
  /**
   * Cambio CRA-01
   * Busca actividades en los cronogramas de un conjunto de periodos recibidos por
   * parámetro, las cuales referencien a actividades de otro período también
   * recibido por parámetro.
   * 
   * @param oidsPeriodosActiv OIDs de periodos a los que deben pertenecer las actividades
   * @param oidPeriodoRef OID del periodo que deben referenciar las actividades
   * @author dmorello
   * @since 09-jun-2008
   */
  public RecordSet obtenerActividadesRefPeriodo(Long[] oidsPeriodosActiv, Long oidPeriodoRef) throws MareException {
    UtilidadesLog.info("CNCronograma.obtenerActividadesRefPeriodoGenerado(Long[] oidsPeriodosActiv, Long oidPeriodoRef): Entrada");
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    StringBuffer query = new StringBuffer();
    query.append(" SELECT crono.OID_CRON ");
    query.append("      , activ.OID_ACTI ");      // OID actividad del cronograma
    query.append("      , crono.PERD_OID_PERI "); // Periodo de la actividad
    query.append("      , activ.CACT_OID_ACTI "); // OID actividad origen de la actividad recuperada
    query.append("      , crono.NUM_DIAS_DESP "); // Dias desplazamiento
    query.append("      , crono.ZZON_OID_ZONA "); // Zona de la actividad
    query.append("   FROM cra_crono crono ");
    query.append("      , cra_activ activ ");
    query.append("  WHERE crono.PERD_OID_PERI IN (");
    for (int i = 0; i < oidsPeriodosActiv.length; i++) {
        if (i != 0) query.append(',');
        query.append(oidsPeriodosActiv[i]);
    }
    query.append("        ) ");
    query.append("    AND crono.PERD_OID_PERI_REFE = ").append(oidPeriodoRef);
    query.append("    AND crono.CACT_OID_ACTI = activ.OID_ACTI ");
  
    RecordSet rs = null;
    try {
        rs = bs.dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
        String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    
    UtilidadesLog.info("CNCronograma.obtenerActividadesRefPeriodoGenerado(Long[] oidsPeriodosActiv, Long oidPeriodoRef): Salida");
    return rs;
  }
  
  /**
   * Cambio CRA-01
   * Actualiza la fecha de inicio y el indicador pendiente origen
   * de un conjunto de elementos de cronograma cuya info recibe por parametro.
   * @author dmorello
   * @since 09-jun-2008
   * 
   * CHANGELOG
   * ---------
   * dmorello, 02/07/2008 - Cambio CRA-01
   *    - Agrego parametro boolean pendienteOrigen
   *    - Con el valor de este parametro actualizo IND_PEND_ORIG
   */
  private void actualizarFechaInicioActividades(HashMap actividades, boolean pendienteOrigen) throws MareException {
    UtilidadesLog.info("CNCronograma.realizarUpdateActividadesAnteriores(HashMap actividades): Entrada");
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    StringBuffer updates = new StringBuffer();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Iterator it = actividades.keySet().iterator();
    while (it.hasNext()) {
        Long oidCrono = (Long)it.next();
        Date nuevaFechaInicio = (Date)actividades.get(oidCrono);
        updates.append("UPDATE cra_crono ");
        updates.append("   SET fec_inic = TO_DATE('");
        updates.append(sdf.format(nuevaFechaInicio)).append("', 'DD/MM/YYYY')");
        updates.append("    , ind_pend_orig = ").append(pendienteOrigen? 1 : 0);
        updates.append(" WHERE oid_cron = ").append(oidCrono);
        updates.append(";");
    }
    
    try {
        bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", updates.toString());
    } catch (Exception e) {
        String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    UtilidadesLog.info("CNCronograma.realizarUpdateActividadesAnteriores(HashMap actividades): Salida");
  }


    /**
    * Fecha de Creacion: 15/02/2006
    * Autor: Carlos Leal
    * Comentario: Agregado por incidencia CRA-03
    */  
  private void eliminarMensajesPorActividad(DTOActividad dto) throws MareException{
        UtilidadesLog.info("CNCronograma.eliminarMensajesPorActividad (DTOActividad dto) - Entrada");
        DAOCronograma daoCrono = new DAOCronograma();
        ActividadLocal actiLocal;
        try {
            ActividadLocalHome actiLH = new ActividadLocalHome();
            actiLocal = actiLH.findByPrimaryKey(dto.getOid());
        } catch(NoResultException e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }       
        UtilidadesLog.info("[CNCronograma.eliminarMensajesPorActividad] actiLocal fue encontrada" );
        if (actiLocal.getEbelNoticias() != null && actiLocal.getEbelNoticias().booleanValue()) {
             RecordSet rs2 = daoCrono.obtieneMensajesPeriodo(dto.getOidPeriodo());
                if (!rs2.esVacio()) {
                    Long cliente = new Long(((BigDecimal) rs2.getValueAt(0, "CLIENTE")).toString());
                    Long numero = new Long(((BigDecimal) rs2.getValueAt(0, "NUMERO")).toString());
                    Date fecha = (Date) rs2.getValueAt(0, "FECHA");
                    DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes(); 
                    dtoBuzon.setIpCliente(dto.getIpCliente()); 
                    dtoBuzon.setPrograma(dto.getPrograma()); 
                    dtoBuzon.setOidPais(dto.getOidPais()); 
                    dtoBuzon.setCodigoMensaje("CRA01"); 
                    dtoBuzon.setOidCliente(cliente == null ? null : cliente); 
                    dtoBuzon.setNumeroSecuencial(numero == null ? null : numero); 
                    dtoBuzon.setFechaGrabacion(fecha); 
                    
                    MONGestionMensajes monMSG = null;
                    try {
                        MONGestionMensajesHome mGMh = this.getMONGestionMensajesHome();
                        monMSG = mGMh.create();
                        monMSG.eliminaDatosMensaje(dtoBuzon);
                    } catch (RemoteException e) {
                        UtilidadesLog.error("ERROR",e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    } catch(NamingException e) {
                        UtilidadesLog.error("ERROR",e);
                        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    } catch (CreateException e) {
                        UtilidadesLog.error("ERROR",e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                    
                    try {
                        MensajesCRALocalHome mensajesCRALocalHome = new MensajesCRALocalHome();
                        Collection colMensa = mensajesCRALocalHome.findByPeriodo(dto.getOidPeriodo());
                        Iterator it = colMensa.iterator();
                        while(it.hasNext()){
                            MensajesCRALocal mensajesCRALocal = (MensajesCRALocal) it.next();
                                mensajesCRALocalHome.remove(mensajesCRALocal);
                        }
                    } catch (NoResultException e) {
                        UtilidadesLog.error("No hay mensajes para el periodo: "+dto.getOidPeriodo());
                    } catch (PersistenceException removeException) {
                        UtilidadesLog.error("ERROR", removeException);
                        throw new MareException(removeException,
                          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                }
        }
        
        UtilidadesLog.info("CNCronograma.eliminarMensajesPorActividad (DTOActividad dto) - Salida");
     
  }
  
  
    /**
    *  Descripción: Genera los mensajes para las actividades agrupadas por zona.
        Implementación:
          - Recorrer el array recibido como parametro (DTOActividadGrupo[] actividades)
          - Agrupar los dtos de cada posicion segun el atributo actividades[i].grupo.
          - Para cada valor diferente del atributo actividades[i].grupo:
            - Se crea un DTOMensajes dtoMensaje:
              dtoMensaje.setIpCliente(dto.getIpCliente());
              dtoMensaje.setPrograma(dto.getPrograma());
              dtoMensaje.setOidPais(dto.getOidPais());
              dtoMensaje.setOidMarca(dto.getOidMarca());
              dtoMensaje.setOidCanal(dto.getOidCanal());
              dtoMensaje.setOidPeriodo(dto.getOidPeriodo());
              dtoMensaje.setOidZona(dto.getOidGrupo());
            - Se invoca al metodo MONMantenimientoActividad.enviaMensajes(dtoMensaje)
            //Fin Para actividades[i].grupo
    * 
    * Fecha de Creacion: 15/02/2006
    * Autor: Carlos Leal
    * Comentario: Agregado por incidencia CRA-03
    * 
    * @cambio mejora por performance, se invoca solo una vez al metodo enviaMensajes() con todos los mensajes.
    * @autor gdmarzi
    */  
  private void generarMensajesPorZona(Vector actividades, DTOCronograma dtoC)throws MareException {
      UtilidadesLog.info("CNCronograma.generarMensajesPorZona (DTOActividad dto) - Entrada");
      Cronometrador.startTransaction("generarMensajesPorZona");   
      MONMantenimientoActividadHome mMAh;
      MONMantenimientoActividad monMA;
      DTOMensajes dtoMensaje;
      ArrayList mensajes = new ArrayList();
      Hashtable ht = new Hashtable();
      Iterator iterActividades;

      iterActividades = actividades.iterator();
      while (iterActividades.hasNext()) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) iterActividades.next();
          // para cada valor diferente del atributo actividades.grupo:
          if ( ! ht.containsKey(dtoA.getGrupo()) ) {
              //inserto grupo en la hash
              ht.put(dtoA.getGrupo(), dtoA);
              // agrego el mensaje a enviar
              dtoMensaje = new DTOMensajes();
              dtoMensaje.setIpCliente(dtoA.getIpCliente());
              dtoMensaje.setPrograma(dtoA.getPrograma());
              dtoMensaje.setOidPais(dtoC.getOidPais());
              dtoMensaje.setOidMarca(dtoC.getMarca());
              dtoMensaje.setOidCanal(dtoC.getCanal());
              dtoMensaje.setOidPeriodo(dtoA.getPeriodo());
              dtoMensaje.setOidZona(dtoA.getGrupo());
              dtoMensaje.setOidIdioma(dtoC.getOidIdioma());
              mensajes.add(dtoMensaje);
          }
      }

      // Envia los mensajes de cada zona
      try {
          mMAh = this.getMONMantenimientoActividadHome();
          monMA = mMAh.create();
          monMA.enviaMensajes(mensajes);
      } catch (RemoteException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(NamingException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException e) {
          UtilidadesLog.error(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      Cronometrador.endTransaction("generarMensajesPorZona");   
      UtilidadesLog.info("CNCronograma.generarMensajesPorZona (DTOActividad dto) - Salida");
  }


  /** Obtiene el cronograma filtrando por los atributos del dto. **/
  public DTOCronograma obtieneCronograma (DTOCronograma dto) throws MareException {
      UtilidadesLog.info("CNCronograma.obtieneCronograma (DTOCronograma dto):Entrada");
      try {
          //Agregado porque viene el CodPeriodo en el dto
          MONPeriodosHome mph = this.getMONPeriodosHome();
          MONPeriodos monPerio = mph.create();
          DTOPeriodo dtoParam = new DTOPeriodo();
          dtoParam.setPais(dto.getOidPais());
          dtoParam.setMarca(dto.getMarca());
          dtoParam.setCanal(dto.getCanal());
          dtoParam.setCodigoPeriodo(dto.getCodigoPeriodo());
          DTOPeriodo periodo = monPerio.obtienePeriodosPMCCodigo(dtoParam);
          UtilidadesLog.debug("DTO Periodo recibido de MONPeriodos: "+periodo);

          if (periodo.getOid() == null) //No se encontró el período
              throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          dto.setPeriodo(periodo.getOid());

      } catch (RemoteException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(NamingException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException e) {
          UtilidadesLog.error(e);
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }

      DAOCronograma dao = new DAOCronograma();
      RecordSet registros = dao.obtieneCronograma(dto.getOidPais(), dto.getMarca(), dto.getCanal(), 
                                                                          dto.getPeriodo(), dto.getGrupo(), dto.getSubgerencia(), 
                                                                          dto.getRegion(), dto.getZona(), dto.getOidIdioma());     

      if (registros.esVacio()) {
          throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      tadCrono = new TADCronograma(dto, true); 
      tadCrono.obtieneCronogramaPorRecordSet(registros); 
      UtilidadesLog.info("CNCronograma.obtieneCronograma (DTOCronograma dto):Salida");
      return tadCrono.getCronograma();
  }

    /**
     * Elimina todas las actividades del cronograma.
     **/
    //jrivas 20080721 3/9/2008
    public void eliminaCronograma (DTOCronograma dto) throws MareException {
        this.eliminaCronograma(dto, true);
    }
    
    //jrivas 20080721 3/9/2008
    public void eliminaCronograma (DTOCronograma dto, boolean ejecutar) throws MareException {
        UtilidadesLog.info("CNCronograma.eliminaCronograma (DTOCronograma dto):Entrada");
       
        tadCrono = new TADCronograma(dto); 
        Vector actividades = tadCrono.obtieneActividades();
        StringBuffer multiplesDeletesTarea = new StringBuffer();
        StringBuffer multiplesDeletesCrono = new StringBuffer();
        for (int i = 0; i < actividades.size(); i++) {
            DTOActividadGrupo dtoA = (DTOActividadGrupo) actividades.get(i);
            // 23164 - dmorello, 23/05/2006: Se preguntara por OID != null para adecuar al DMCO
            if (dtoA.getOid() != null) {
                String tarea = obtenerNombreTarea(dtoA.getOid());
                if (tarea!=null){
                    try{
                        this.getMONGestorPlanificacionLocalHome().create().borrarTarea(tarea);
                    }catch(Exception e){
                        UtilidadesLog.error("ERROR",e);
                    }
                }
                multiplesDeletesTarea.append(generaDeleteTarea(dtoA.getOid()));
                multiplesDeletesCrono.append(generaDeleteCronograma(dtoA.getOid()));                
                
                DTOActividad dtoActi = new DTOActividad(); 
                dtoActi.setOidPais(dto.getOidPais()); 
                dtoActi.setOidMarca(dto.getMarca());
                dtoActi.setOidCanal(dto.getCanal());
                dtoActi.setOid(dtoA.getActividad());
                dtoActi.setIpCliente(dto.getIpCliente());
                dtoActi.setPrograma(dto.getPrograma());
                dtoActi.setOidPeriodo(dto.getPeriodo());
                //Cleal CRA-03
                //compruebaActividadMensajes(dtoActi, dtoA.getGrupo(), zonasInformadas);
               // eliminarMensajesPorActividad(dtoActi);
                //cambio 20080793
            }
        }
        Vector vG = tadCrono.obtieneGrupos();
        for (int i = 0; i < vG.size(); i++) {
            DTOGrupoCronograma dtoG = (DTOGrupoCronograma) vG.get(i);
            Vector vB = dtoG.getBorradas();
            if (vB != null) {
                for (int j  = 0; j < vB.size(); j++) {
                    Long oidCrono = (Long) vB.get(j);
                    String tarea = obtenerNombreTarea(oidCrono);
                    if (tarea!=null){
                        try{
                            this.getMONGestorPlanificacionLocalHome().create().borrarTarea(tarea);
                        }catch(Exception e){
                            UtilidadesLog.error("ERROR",e);
                        }
                    }
                    multiplesDeletesTarea.append(generaDeleteTarea(oidCrono));
                    multiplesDeletesCrono.append(generaDeleteCronograma(oidCrono));     
                }
            } 
        }
        try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",multiplesDeletesTarea.toString());
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",multiplesDeletesCrono.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR: " + multiplesDeletesTarea.append(multiplesDeletesCrono).toString(),e);
            throw new MareException(e);
        }
        
        // CRA-01 - Actualizo actividades de otros periodos que referencian a las eliminadas
        //          y las dejo con pendiente origen = true
        //jrivas 20080721 3/9/2008
        if (ejecutar) {
            this.actualizarActividadesOtrosPeriodos(dto, true);
        }
        
        Cronometrador.endTransaction("eliminaCronograma");   
        UtilidadesLog.info("CNCronograma.eliminaCronograma (DTOCronograma dto):Salida");
    }
  
    private StringBuffer generaDeleteTarea(Long oid){
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM CRA_TAREA WHERE CRON_OID_CRON = "+oid+";");
        return sb;
    }
    
    private StringBuffer generaDeleteCronograma(Long oid){
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM CRA_CRONO WHERE OID_CRON = "+oid+";");
        return sb;
    }
    
    private String obtenerNombreTarea(Long oid)throws MareException{
        StringBuffer sb = new StringBuffer();
        sb.append("Select VAL_NOMB_TARE from CRA_TAREA Where CRON_OID_CRON = "+oid);
        RecordSet r = null;
        try{
            r = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
        }
        if (r!=null && !r.esVacio() && r.getValueAt(0,0)!=null){
            return r.getValueAt(0,0).toString();
        }
        return null;
    }
    

  //Incidencia 5635
  // Comprueba si una actividad existe en el cronograma.
  // En caso afirmativo devuelva los idVista de cada zona
  private ArrayList existeActividad(Long oidActividad, Long oidGrupoZonas, Timestamp fechaPrevista) throws MareException {
      UtilidadesLog.info("CNCronograma.existeActividad(Long oidActividad, Long oidGrupoZonas, Date fechaPrevista):Entrada");
      ArrayList idVistas = new ArrayList();
      Vector actividades = tadCrono.obtieneActividades();
      if (actividades == null || actividades.size() == 0){
          UtilidadesLog.info("CNCronograma.existeActividad(Long oidActividad, Long oidGrupoZonas, Date fechaPrevista):Salida");
          return null;
      }
      Vector actividadesGrupos = new Vector();

      // Obtiene las zonas del grupo recibido
      DAOCronograma dao = new DAOCronograma();
      RecordSet zonasGrupo = dao.obtieneZonasDeGrupo(oidGrupoZonas);

      DTOActividadGrupo primeraActividad = null;
      boolean existeAct = false;
      for (int i = 0; i < actividades.size(); i++) {
          DTOActividadGrupo dtoAG = (DTOActividadGrupo) actividades.get(i);
          if (dtoAG.getActividad().equals(oidActividad) &&
              existeGrupoEnZonasGrupo(dtoAG.getGrupo(), zonasGrupo)) {
              // si la actividad es de tipo con referencia a otro periodo                
              if ( dtoAG.getTipoActividad().intValue() == ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() ) {
                  // en el caso de actividades con refrencia a otro periodo NO se utiliza la fecha para comparar pues es unica.
                  // ademas esta aun no esta definida y es el inicio del periodo temporalmente.
                  existeAct = true;
                  primeraActividad = dtoAG;
                  actividadesGrupos.add(dtoAG);
              } else {
                  // en el caso de actividades repetitivas se utiliza la fecha para verificar que sea la misma actividad
                  if (dtoAG.getFechaPrevista().compareTo(fechaPrevista) == 0) {
                        existeAct = true;
                        primeraActividad = dtoAG;
                        actividadesGrupos.add(dtoAG);
                  }                    
              }
          }
      }

      //En el caso de repetitivas, si no existe la actividad en la fecha prevista entonces hay que agregarla.
      if (!existeAct) {
          UtilidadesLog.info("CNCronograma.existeActividad(Long oidActividad, Long oidGrupoZonas, Date fechaPrevista):Salida Uno");
          return null;
      }

      if (primeraActividad == null){
          UtilidadesLog.info("CNCronograma.existeActividad(Long oidActividad, Long oidGrupoZonas, Date fechaPrevista):Salida Dos");
          return null;
      }else {
          for (int i = 0; i < actividadesGrupos.size(); i++) {
              DTOActividadGrupo dtoAG = (DTOActividadGrupo) actividadesGrupos.get(i);
              if (dtoAG.getFechaPrevista().compareTo(primeraActividad.getFechaPrevista()) == 0)
                  idVistas.add(dtoAG.getIdVista());
          }

          if (idVistas.size() > 0) {
              UtilidadesLog.debug("Encontro actividades: "+idVistas);
              UtilidadesLog.info("CNCronograma.existeActividad(Long oidActividad, Long oidGrupoZonas, Date fechaPrevista):Salida Tres");
              return idVistas;
          } else {
              UtilidadesLog.info("CNCronograma.existeActividad(Long oidActividad, Long oidGrupoZonas, Date fechaPrevista):Salida Cuatro");
              return null;
          }
      }

  }

  private boolean existeGrupoEnZonasGrupo(Long grupo, RecordSet rs) throws MareException {
      boolean existe = false;
      for (int i = 0; i < rs.getRowCount(); i++) {
          Long grupoRS = new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString());
          if (grupoRS.equals(grupo)) {
              existe = true;
              break;
          }
      }
      return existe;
  }


    /**
     * Arma un insert sobre CRA_CRONO.
     * @autor gdmarzi
     */
    private Long armarInsertCronograma(DTOActividadGrupo dtoActividadGrupo, StringBuffer multiplesInsertsCrono) throws MareException {
        StringBuffer query = new StringBuffer();
        //Arma el insert sobre CRA_CRONO
        Long oidCrono = SecuenciadorOID.obtenerSiguienteValor("CRA_CRON_SEQ");
        query.append("INSERT INTO CRA_CRONO ( ");
        query.append("  OID_CRON,  ");
        query.append("  PERD_OID_PERI, ");
        query.append("  ZSCC_OID_SECC, ");
        query.append("  CACT_OID_ACTI, ");
        query.append("  COD_TIPO_DIAS, ");
        query.append("  FEC_INIC, ");
        query.append("  FEC_MEDI, ");
        query.append("  FEC_FINA, ");
        query.append("  ZZON_OID_ZONA, ");
        query.append("  TIFA_OID_TIPO_FACT, ");
        query.append("  VAL_FEC0, ");
        query.append("  IND_FIJA, ");
        query.append("  COD_VIST, ");
        query.append("  COD_VIST_ORIG, ");
        //CRA-003 jrivas 26/11/2007
        query.append("  NUM_DIAS_DESP, ");
        query.append("  IND_PEND_ORIG, ");
        query.append("  PERD_OID_PERI_REFE ");
        //FIN CRA-003
        query.append(" ) VALUES ( ");
        query.append( oidCrono + ", ");
        query.append( dtoActividadGrupo.getPeriodo() + ", ");
        query.append( " null" + ", ");
        query.append( dtoActividadGrupo.getActividad() + ", ");
        if (dtoActividadGrupo.getTipoDias().booleanValue()) {
            query.append(" 1 " + ", ");
        } else {
            query.append(" 0 " + ", ");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        query.append(" TO_DATE( '" + df.format(dtoActividadGrupo.getFechaPrevista()) + "', 'YYYY-MM-DD HH24:MI:SS'), ");
        if (dtoActividadGrupo.getFechaMedia() == null) {
            query.append( " null" + ", ");
        } else {
            query.append( dtoActividadGrupo.getFechaMedia() + ", ");
        }
        if (dtoActividadGrupo.getFechaFinal() == null) {
            query.append( " null" + ", ");
        } else {
            query.append(" TO_DATE( '" + dtoActividadGrupo.getFechaFinal() + "', 'YYYY-MM-DD'), ");
        }
        query.append( dtoActividadGrupo.getGrupo() + ", "); //zona
        query.append( dtoActividadGrupo.getTipoFacturacion() + ", ");
        query.append( dtoActividadGrupo.getFecha0() + ", ");
        if (dtoActividadGrupo.getIndFija().booleanValue()) {
            query.append(" 1 " + ", ");
        } else {
            query.append(" 0 " + ", ");
        }
        query.append( dtoActividadGrupo.getIdVista() + ", ");
        if (dtoActividadGrupo.getActividadOrigen() == null) {
            query.append( " null, ");
        } else {
            query.append( dtoActividadGrupo.getActividadOrigen() + ", ");
        }
        //CRA-003 jrivas 26/11/2007
        if (dtoActividadGrupo.getDiasDesplazamiento() == null) {
            query.append( " null, ");
        } else {
            query.append( dtoActividadGrupo.getDiasDesplazamiento() + ", ");
        }
        
        if (dtoActividadGrupo.getIndPendienteOrigen() != null) {
            if (dtoActividadGrupo.getIndPendienteOrigen().booleanValue()) {
                query.append(" 1 " + ", ");
            } else {
                query.append(" 0 " + ", ");
            }        
        } else {
            query.append( " null, ");
        }
        
        if (dtoActividadGrupo.getPeriodoReferencia() == null) {
            query.append( " null");
        } else {
            query.append( dtoActividadGrupo.getPeriodoReferencia());
        }  
        //FIN CRA-003
        
        query.append(" );");
        //Agrega el insert al stringBuffer
        multiplesInsertsCrono.append(query);
        return oidCrono;
    }    

    /**
     * Arma un insert sobre CRA_TAREA.
     * @autor gdmarzi
     */
    private StringBuffer armarInsertTarea(String nombreTarea, Long oidCrono) throws MareException {
        StringBuffer query = new StringBuffer();
        //Arma el insert sobre CRA_TAREA
        Long oidTarea = SecuenciadorOID.obtenerSiguienteValor("CRA_CRTA_SEQ");
        query.append("INSERT INTO CRA_TAREA ( ");
        query.append("  OID_TARE,  ");
        query.append("  CRON_OID_CRON, ");
        query.append("  VAL_NOMB_TARE ");
        query.append(" ) VALUES ( ");
        query.append( oidTarea + ", ");
        query.append( oidCrono + ", ");
        query.append( " '" + nombreTarea +"' );");
        return query;
    }


  /** No hace nada. **/
  public DTOCronograma obtieneTipoFacturacion (DTOCronograma dto) throws MareException {
    return dto;
  }


   private DTOActividad obtenerDatosActividad(Long oidActividad) throws MareException {
        UtilidadesLog.info("CNCronograma.obtenerActividadOrigen():Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        query.append(" SELECT activ.COD_ACTI, ");
        query.append("   PQ_APL_AUX.Valor_Gen_I18n_Sicc( " + ConstantesSEG.IDIOMA_DEFECTO + ", activ.OID_ACTI, 'CRA_ACTIV') NOMB_ACTIV ");
        query.append(" FROM CRA_ACTIV activ ");  
        query.append(" WHERE activ.OID_ACTI = " + oidActividad);

        try{
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        DTOActividad dtoActividad = new DTOActividad();
        dtoActividad.setCodigoActividad((String)rs.getValueAt(0,"COD_ACTI"));
        dtoActividad.setNombreActividad((String)rs.getValueAt(0,"NOMB_ACTIV"));
        UtilidadesLog.info("CNCronograma.obtenerActividadOrigen():Salida");
        return dtoActividad;
   }  

  /**
  *  Retorna el id vista de la actividad de origen de otro periodo, si es que existe.
  *  En base a periodo de referencia, zona y actividad que vienen por parametro.
  *  Si hay dos actividades, por ser repetitiva, se toma la original.
  */
  private DTOActividadGrupo obtenerActividadOrigenDeOtroPeriodo(Long oidPeriodo, Long oidZona, Long oidActividad) throws MareException {
        UtilidadesLog.info("CNCronograma.obtenerActividadOrigenDeOtroPeriodo():Entrada");

        RecordSet rs = this.obtenerActividadOrigenDeOtroPeriodoRS(oidPeriodo, oidZona, oidActividad);
        DTOActividadGrupo actividadCronoOrigen = null;
        if( ! rs.esVacio() ) {
            actividadCronoOrigen = new DTOActividadGrupo();
            actividadCronoOrigen.setIdVista(new Integer(((BigDecimal)rs.getValueAt(0,"COD_VIST")).toString()));
            actividadCronoOrigen.setFechaPrevista(new Timestamp(((Date)rs.getValueAt(0,"FEC_INIC")).getTime()));
        }   
        UtilidadesLog.info("CNCronograma.obtenerActividadOrigenDeOtroPeriodo():Salida");
        return actividadCronoOrigen;
   }
   
   /**
    *  Retorna el id vista de la actividad de origen de otro periodo, si es que existe.
    *  En base a periodo de referencia, zona y actividad que vienen por parametro.
    *  Si hay dos actividades, por ser repetitiva, se toma la original.
    */
   public RecordSet obtenerActividadOrigenDeOtroPeriodoRS(Long oidPeriodo, Long oidZona, Long oidActividad) throws MareException {
        UtilidadesLog.info("CNCronograma.obtenerActividadOrigenDeOtroPeriodoRS(Long oidPeriodo, Long oidZona, Long oidActividad):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        query.append(" SELECT COD_VIST, FEC_INIC ");
        query.append(" FROM CRA_CRONO cro ");  
        query.append(" WHERE cro.PERD_OID_PERI = " + oidPeriodo);
        query.append(" AND cro.ZZON_OID_ZONA = " + oidZona);
        query.append(" AND cro.CACT_OID_ACTI = " + oidActividad);
        query.append(" AND cro.COD_VIST_ORIG IS NULL ");

        try{
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("CNCronograma.obtenerActividadOrigenDeOtroPeriodoRS(Long oidPeriodo, Long oidZona, Long oidActividad):Salida");
        return rs;
   }


  private MONPeriodosHome getMONPeriodosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
  }

  private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
  }

  private MONMantenimientoActividadHome getMONMantenimientoActividadHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoActividadHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoActividad"), MONMantenimientoActividadHome.class);
  }

  private MONGestorPlanificacionHome getMONGestorPlanificacionHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestorPlanificacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorPlanificacion"), MONGestorPlanificacionHome.class);
  }
       
    private MONGestorPlanificacionLocalHome getMONGestorPlanificacionLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestorPlanificacionLocalHome)context.lookup("java:comp/env/ejb/local/MONGestorPlanificacion");
    }

  
}