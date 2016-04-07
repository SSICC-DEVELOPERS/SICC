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

import es.indra.sicc.dtos.cra.DTOBuscarActividadOrigen;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.entidades.cra.ActividadLocal;
import es.indra.sicc.util.UtilidadesLog;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.entidades.cra.TransaccionesPorActividadLocal;
import es.indra.sicc.entidades.cra.TransaccionesPorActividadLocalHome;

import java.math.BigDecimal;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.cra.ActividadLocalHome;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.cra.MONGestorPlanificacionHome;
import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;
import es.indra.sicc.dtos.cra.DTOGenerarCronogramaporZonas;
import java.sql.Date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import java.sql.Timestamp;

import es.indra.sicc.dtos.cra.DTOCronogramaFecha;
import es.indra.sicc.dtos.cra.DTONuevasActividadesCronograma;
import es.indra.sicc.logicanegocio.cra.IMONCronograma;
import es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma;
import java.util.ArrayList;
import es.indra.sicc.dtos.cra.DTOCalcularFechaPrevista;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTODate;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * 
 * @date 12/09/2005
 * @author pperanzola
 *       - Se actualiza loggeo de la clase
 */

public class MONCronogramaBean implements SessionBean, IMONCronograma {
  private SessionContext sessionContext;

  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
  }

  public void actualizaCronograma(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.actualizaCronograma(DTOCronograma dto):Entrada");
      ICNCronograma iCrono;
      try {
          iCrono = obtieneCronogramaTipo(dto); 
          iCrono.eliminaCronograma(dto); 
          iCrono.actualizaCronograma(dto);
      } catch (MareException ex) {
          UtilidadesLog.error(ex);
          sessionContext.setRollbackOnly();
          throw ex;
      }
      UtilidadesLog.info("MONCronogramaBean.actualizaCronograma(DTOCronograma dto):Salida");
  }

  public DTOCronograma compruebaFacturacion(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.compruebaFacturacion(DTOCronograma dto):Entrada");
      ICNCronograma iCrono;
      try {
          iCrono = obtieneCronogramaTipo(dto); 
      } catch (MareException ex) {
          UtilidadesLog.error(ex);
          sessionContext.setRollbackOnly();
          throw ex;
      }
      UtilidadesLog.info("MONCronogramaBean.compruebaFacturacion(DTOCronograma dto):Salida");
      return iCrono.obtieneTipoFacturacion(dto); 
  }

  public DTOBoolean existeCronograma(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.existeCronograma(DTOCronograma dto):Entrada");
      ICNCronograma iCrono;
      try {
          iCrono = obtieneCronogramaTipo(dto); 
      } catch (MareException ex) {
          UtilidadesLog.error(ex);
          sessionContext.setRollbackOnly();
          throw ex;
      }
      UtilidadesLog.info("MONCronogramaBean.existeCronograma(DTOCronograma dto):Salida");
      return iCrono.existeCronograma(dto);
  }

  public DTOCronograma generaCronograma(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.generaCronograma(DTOCronograma dto):Entrada");
      ICNCronograma iCrono;
      try {
          iCrono = obtieneCronogramaTipo(dto); 
      } catch (MareException ex) {
          UtilidadesLog.error(ex);
          sessionContext.setRollbackOnly();
          throw ex;
      }
      UtilidadesLog.info("MONCronogramaBean.generaCronograma(DTOCronograma dto):Salida");
      return iCrono.generaCronograma(dto);
  }

  public DTOCronograma obtieneCronograma(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.obtieneCronograma(DTOCronograma dto):Entrada");
      ICNCronograma iCrono;
      try {
          iCrono = obtieneCronogramaTipo(dto); 
      } catch (MareException ex) {
          UtilidadesLog.error(ex);
          sessionContext.setRollbackOnly();
          throw ex;
      }
      UtilidadesLog.info("MONCronogramaBean.obtieneCronograma(DTOCronograma dto):Salida");
      return iCrono.obtieneCronograma(dto);
  }

  public ICNCronograma obtieneCronogramaTipo(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.obtieneCronogramaTipo(DTOCronograma dto):Entrada");
      ICNCronograma iCrono; 
      if (dto.getEsZonas() != null && dto.getEsZonas().booleanValue())
          iCrono = (ICNCronograma) new CNCronograma(); 
      else
          iCrono = (ICNCronograma) new CNCronogramaGrupos(); 
      UtilidadesLog.info("MONCronogramaBean.obtieneCronogramaTipo(DTOCronograma dto):Salida");
      return iCrono;
  }

  public DTOSalida obtieneZonasPorGrupo(DTOOID dto) throws MareException {
     UtilidadesLog.info("MONCronogramaBean.obtieneZonasPorGrupo(DTOOID dto):Entrada");
     DTOSalida dtoS = new DTOSalida(); 
     DAOCronograma daoC = new DAOCronograma();
     dtoS.setResultado(daoC.obtieneZonasPorGrupo(dto.getOid()));
     UtilidadesLog.info("MONCronogramaBean.obtieneZonasPorGrupo(DTOOID dto):Salida");

    return dtoS;
  }

  public void eliminaTareasActividad(DTOOID dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.eliminaTareasActividad(DTOOID dto):Entrada");
      DAOCronograma daoC = new DAOCronograma();
      RecordSet rs = daoC.obtieneTransaccionesActividad(dto.getOid()); // -> regs [oid, fecha, codigo, ejecutable, parametros] 
      for (int i = 0; i < rs.getRowCount(); i++) {      
          try {
              TransaccionesPorActividadLocalHome transacLocalHome = new TransaccionesPorActividadLocalHome();            
              Long oidT = new Long(((BigDecimal) rs.getValueAt(i,"OID")).toString());
              TransaccionesPorActividadLocal tLocal = transacLocalHome.findByPrimaryKey(oidT);
              transacLocalHome.remove(tLocal);

          } catch(NoResultException e) {
              UtilidadesLog.debug(e);
              sessionContext.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(
                              CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          } catch (PersistenceException removeException) {
              UtilidadesLog.debug(removeException);
              sessionContext.setRollbackOnly();
              throw new MareException(removeException,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          } catch (Exception exception){
              UtilidadesLog.error(exception);
              sessionContext.setRollbackOnly();
              throw new MareException(exception,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
          }
      }
      UtilidadesLog.info("MONCronogramaBean.eliminaTareasActividad(DTOOID dto):Salida");
  }


  public void eliminaCronograma(DTOCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.eliminaCronograma(DTOCronograma dto):Entrada");
      ICNCronograma iCrono;
      try {
        iCrono = obtieneCronogramaTipo(dto); 
        iCrono.eliminaCronograma(dto);
      } catch (MareException ex) {
          UtilidadesLog.error(ex);
          sessionContext.setRollbackOnly();
          throw ex;
      }
      UtilidadesLog.info("MONCronogramaBean.eliminaCronograma(DTOCronograma dto):Salida");
  }




  /** Obtiene las actividades que tienen como origen la de dto.actividad y las devuelve 
   * en un DTOGrupoCronograma. **/
  public DTOGrupoCronograma obtieneReferenciadas(DTOActividadGrupo dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.obtieneReferenciadas(DTOActividadGrupo dto):Entrada");
      DAOCronograma dao = new DAOCronograma();
      RecordSet registros = dao.obtieneReferenciadas(dto.getActividad(),dto.getOidIdioma());
      DTOGrupoCronograma dtoS = new DTOGrupoCronograma();
      dtoS.setOid(dto.getGrupo());
      Vector vActs = new Vector();
      dtoS.setActividades(vActs);
      for (int i = 0; i < registros.getRowCount(); i++) {
          DTOActividadGrupo dtoActividad = new DTOActividadGrupo(); 
          dtoActividad.setFecha0(new Long(0));
          Integer dias;
          if (registros.getValueAt(i, "DIAS") != null) {
              dias = new Integer(((BigDecimal) registros.getValueAt(i,"DIAS")).toString());
          } else {
              dias = new Integer(0);
          }
          Calendar c = new GregorianCalendar();
          c.setTime(dto.getFechaPrevista());
          c.add(Calendar.DATE, dias.intValue());
          dtoActividad.setFechaPrevista(new Timestamp(c.getTime().getTime()));
          
          if (registros.getValueAt(i,"LABORABLES") !=null ) {
              dtoActividad.setTipoDias(new Boolean((((BigDecimal) registros.getValueAt(i,"LABORABLES")).toString() == "1")));
          } else {
              dtoActividad.setTipoDias(Boolean.FALSE); //es campo requerido en BBDD.
          }         
          if (registros.getValueAt(i,"OID") !=null ) 
              dtoActividad.setActividad(new Long(((BigDecimal) registros.getValueAt(i,"OID")).toString()));

          //dtoActividad.setActividadOrigen(dto.getActividad());
          dtoActividad.setActividadOrigen(dto.getIdVista());
          dtoActividad.setGrupo(dto.getGrupo());
          dtoActividad.setPeriodo(dto.getPeriodo());
          dtoActividad.setTipoFacturacion(dto.getTipoFacturacion());
          dtoActividad.setFechaIniPeriodo(dto.getFechaIniPeriodo());
          dtoActividad.setFechaFinPeriodo(dto.getFechaFinPeriodo());
          dtoActividad.setTextoGrupo(dto.getTextoGrupo());
          dtoActividad.setTextoActividad((String) registros.getValueAt(i,"NOMBRE"));
          dtoActividad.setCodigo((String) registros.getValueAt(i,"CODIGO"));
          dtoActividad.setIndFija(Boolean.FALSE); //(25-07-2007) modificado por Sapaza, incidencia SiCC-20070366

          vActs.add(dtoActividad);
      }
      UtilidadesLog.info("MONCronogramaBean.obtieneReferenciadas(DTOActividadGrupo dto):Salida");
      return dtoS;
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


  public DTOCronogramaFecha obtieneFechaInicioCronograma(Long zona, Long periodo, Long actividad) throws MareException {
    UtilidadesLog.info("MONCronogramaBean.obtieneFechaInicioCronograma(Long zona, Long periodo, Long actividad):Entrada");
    //Obtiene la fecha de inicio del cronograma que cumple zona, periodo, actividad y
    //cuya fecha final sea mayor o igual que la del sistema.
    DAOCronograma daoCrono = new DAOCronograma();
    RecordSet rs = new RecordSet();
    java.util.Date fechaIni = null;
    java.util.Date fechaFin = null;
    DTOCronogramaFecha dtoCF = null;
    rs = daoCrono.obtieneCronogramaZPAFechaActual(zona, periodo, actividad);

    if ( rs.esVacio() ) return null;

    fechaIni = (Date)rs.getValueAt(0,"FECHAINI");
    fechaFin = (Date)rs.getValueAt(0,"FECHAFIN");
    dtoCF = new DTOCronogramaFecha();
    dtoCF.setFechaIni( obtenerTimestamp( fechaIni ) );
    dtoCF.setFechaFin( obtenerTimestamp( fechaFin ) );
    UtilidadesLog.info("MONCronogramaBean.obtieneFechaInicioCronograma(Long zona, Long periodo, Long actividad):Salida");
    return dtoCF;
  }

  private Timestamp obtenerTimestamp( java.util.Date fecha ){
    UtilidadesLog.info("MONCronogramaBean.obtenerTimestamp( java.util.Date fecha ):Entrada");
    GregorianCalendar gc = new GregorianCalendar();
    Timestamp tmstmp = null;
    String anio = null;
    String mes = null;
    String dia = null;
    String sDate = null;

    if (fecha != null) {
      gc.setTime( fecha );
      anio = ( new Integer( gc.get( GregorianCalendar.YEAR ) ) ).toString();

      if( gc.get( GregorianCalendar.MONTH ) < 10 ){
        mes = "0" + ( new Integer( gc.get( GregorianCalendar.MONTH ) + 1 ) ).toString();
      } else{
        mes = ( new Integer( gc.get( GregorianCalendar.MONTH ) + 1 ) ).toString();
      }

      if( gc.get( GregorianCalendar.DAY_OF_MONTH ) < 10 ){
        dia = "0" + ( new Integer( gc.get( GregorianCalendar.DAY_OF_MONTH ) ) ).toString();
      } else{
        dia = ( new Integer( gc.get( GregorianCalendar.DAY_OF_MONTH ) ) ).toString();
      }
            
      sDate = anio + "-" + mes + "-" + dia + " 00:00:00";
      tmstmp = Timestamp.valueOf( sDate );
    }
    UtilidadesLog.info("MONCronogramaBean.obtenerTimestamp( java.util.Date fecha ):Salida");
    return tmstmp;
  }

  public DTOSalida obtieneNuevasActividadesCronograma(DTONuevasActividadesCronograma dtoE) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.obtieneNuevasActividadesCronograma(DTONuevasActividadesCronograma dtoE):Entrada");
      DAOCronograma dao = new DAOCronograma();
      RecordSet rs = dao.obtieneNuevasActividadesCronograma(dtoE.getOidPais(), dtoE.getOidMarca(), 
                                            dtoE.getOidCanal(), dtoE.getActividadesCronograma(), dtoE.getOidIdioma());
      DTOSalida dtoS = new DTOSalida();
      dtoS.setResultado(rs);
      UtilidadesLog.info("MONCronogramaBean.obtieneNuevasActividadesCronograma(DTONuevasActividadesCronograma dtoE):Salida");
      return dtoS;
  }

  public DTOSalida buscarFechasFacPorZona(DTOOID dto) throws MareException{
      UtilidadesLog.info("MONCronogramaBean.buscarFechasFacPorZona(DTOOID dto):Entrada");
      DTOSalida dtoSal = new DTOSalida();
      DAOCRA dao = new DAOCRA();
      dtoSal = dao.buscarFechasFacPorZona(dto);
      UtilidadesLog.info("MONCronogramaBean.buscarFechasFacPorZona(DTOOID dto):Salida");  
      return dtoSal;        
  }

  public Timestamp obtenerMayorFechaFacturacion(DTOOID dto) throws MareException {
      //Timestamp dtoSal = new Timestamp();
      UtilidadesLog.info("MONCronogramaBean.obtenerMayorFechaFacturacion(DTOOID dto):Entrada");  
      DAOCronograma dao = new DAOCronograma();
      Timestamp dtoSal = dao.obtenerMayorFechaFacturacion(dto);
      UtilidadesLog.info("MONCronogramaBean.obtenerMayorFechaFacturacion(DTOOID dto):Salida");
      return dtoSal;        
  }

  public DTOSalida consultarFechasCronograma(DTOConsultarFechasCronograma dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.consultarFechasCronograma(DTOConsultarFechasCronograma dto):Entrada");
      DTOSalida dtoSal = new DTOSalida();
      DAOCronograma dao = new DAOCronograma();
      dtoSal = dao.consultarFechasCronograma(dto);
      UtilidadesLog.info("MONCronogramaBean.consultarFechasCronograma(DTOConsultarFechasCronograma dto):Salida");  
      return dtoSal;  
  }

    /**    
     *@Author: pperez 
     *@Fecha: 17/08/2005
     *@throws: MareException
     *@return: ArrayList
     *@param: Long oidZona, Long oidPeriodo
     *@Observaciones: Incidencia BELC300011135
    */ 
    
    public ArrayList obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONCronogramaBean.obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo):Entrada");    
        DAOCRA daoCra = new DAOCRA();
        RecordSet rs = daoCra.obtenerFechasFacturacionPorPeriodoZona(oidZona, oidPeriodo);
        Date fecha = null;
        ArrayList arryListFechas = new ArrayList();
        
        int sizeRecord = rs.getRowCount();
        UtilidadesLog.info("El tamano del recordset es: " + sizeRecord);
        for (int i = 0; i < sizeRecord; i++)  {
            fecha = (Date) rs.getValueAt(i,"FECHA");
            Timestamp tmsmp = new Timestamp(fecha.getTime());
            arryListFechas.add(tmsmp);
        }

        UtilidadesLog.info("MONCronogramaBean.obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo):Salida");
        return arryListFechas;
    }


    /**
     * BRECHA CRA-003 jrivas 22/10/2007
     */   
     public DTOSalida obtenerGrupoZonas(DTOPeriodo dto) throws MareException {
        return new DAOCRA().obtenerGrupoZonas(dto);
    }

    /**
     * BRECHA CRA-003 jrivas 22/10/2007
     */   
    public DTOSalida obtenerZonas(DTOOID dto) throws MareException {
        return new DAOCRA().obtenerZonas(dto);
    }

    /**
     * BRECHA CRA-003 jrivas 22/10/2007
     */   
    public DTOBoolean validarGeneracion(DTOGenerarCronogramaporZonas dto) throws MareException
    {
        return new DAOCRA().validarGeneracion(dto);
    }

    /**
     * BRECHA CRA-003 jrivas 22/10/2007
     */   
    public void generarCronogramaporZonas(DTOGenerarCronogramaporZonas dto) throws MareException {
        UtilidadesLog.info("MONCronogramaBean.generarCronogramaporZonas(DTOGenerarCronogramaporZonas dto):Entrada");    
        try {
            DAOCRA dao = new DAOCRA();
            
            HashMap periodos = dao.obtenerPeriodosAVerificar(dto.getOidPeriodo());
            Iterator it = periodos.keySet().iterator();
            StringBuffer stringPeriodos = new StringBuffer();
            stringPeriodos.append("(");
            while (it.hasNext()) {
                stringPeriodos.append(it.next().toString()); 
                if (it.hasNext()) { 
                    stringPeriodos.append(" ,");     
                }
            } 
            stringPeriodos.append(")");
            
            DTOCronograma dtoC = new DTOCronograma();
            dtoC.setEsZonas(Boolean.TRUE);
            dtoC.setOidPais(dto.getOidPais());
            dtoC.setOidIdioma(dto.getOidIdioma());
            UtilidadesLog.info("IDIOMA " + dtoC.getOidIdioma()); 
    
            Vector actividades = new Vector();        
            DTOGrupoCronograma dtoGC = new DTOGrupoCronograma();
            dtoGC.setActividades(actividades);
            
            Vector grupos = new Vector();
            grupos.add(0, dtoGC);
            
            dtoC.setGrupos(grupos);
            
            if (dto.getHayQueBorrar().booleanValue()) {
                 dao.obtenerDatosBorrar(dto, dtoC);   
            }
            HashMap actividadesNoPendiente = dao.obtenerDatosRegenerar(dto, dtoC, periodos);
            Iterator it2 = dto.getOidsZonasRegenerar().iterator();
            Long oidZona;
            ArrayList aux;
            while (it2.hasNext()) {
                oidZona = (Long)it2.next();
                //Punto 7
                dao.procesarActividadesAEliminar(dto.getOidPeriodo(), oidZona, stringPeriodos.toString());
                
                //Punto 14
                aux = (ArrayList)actividadesNoPendiente.get(oidZona);
                if (aux != null && !aux.isEmpty()) {
                    dao.procesarActividadesNoPendientes(dto.getOidPeriodo(), oidZona, stringPeriodos.toString(), aux);
                }
            }
            
            CNCronograma iCrono = new CNCronograma(); 
            if (dto.getHayQueBorrar().booleanValue()) {
                //jrivas 20080721 3/9/2008
                iCrono.eliminaCronograma(dtoC, false); 
            }
            //jrivas 20080721 3/9/2008
            iCrono.actualizaCronograma(dtoC, false);

        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }       
        
        UtilidadesLog.info("MONCronogramaBean.generarCronogramaporZonas(DTOGenerarCronogramaporZonas dto):Salida");            
    }

    /**
     * Cambio CRA-01
     * Busca una actividad origen que coincida con los filtros recibidos por parametro
     * Si la encuentra, devuelve un DTOActividadGrupo que contiene idVista y fechaInicio
     * Si no la encuentra, devuelve null.
     * @author dmorello
     * @since 18-jun-2008
     */
    public DTOSalida obtenerActividadOrigenDeOtroPeriodo(DTOBuscarActividadOrigen dtoe) throws MareException {
        UtilidadesLog.info("MONCronogramaBean.obtenerActividadOrigenDeOtroPeriodo(DTOBuscarActividadOrigen dtoe): Entrada");
        CNCronograma cnCrono = new CNCronograma();
        Long oidPeri = dtoe.getOidPeriodo();
        Long oidZona = dtoe.getOidZona();
        Long oidActi = dtoe.getOidActividad();
        RecordSet rs = cnCrono.obtenerActividadOrigenDeOtroPeriodoRS(oidPeri, oidZona, oidActi);
        UtilidadesLog.info("MONCronogramaBean.obtenerActividadOrigenDeOtroPeriodo(DTOBuscarActividadOrigen dtoe): Salida");
        return new DTOSalida(rs);
    }

    /**
     * Cambio CRA-01
     * Calcula la fecha prevista de la actividad cuya informacion se recibe
     * en el parametro de entrada
     * @author dmorello
     * @since 19-jun-2008
     */
    public DTODate calcularFechaPrevista(DTOCalcularFechaPrevista dtoe) throws MareException {
        UtilidadesLog.info("MONCronogramaBean.calcularFechaPrevista(DTOCalcularFechaPrevista dtoe): Entrada");
        // Busco el entity bean actividad
        ActividadLocalHome actHome = null;
        ActividadLocal actividad = null;
        try {
            actHome = new ActividadLocalHome();
            actividad = actHome.findByPrimaryKey(dtoe.getOidActividad());
        } catch (NoResultException e) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        // Busco el grupo de zona al cual pertenece la zona recibida
        RecordSet rs = new DAOCRA().obtieneGrupoPMCZ(dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(), dtoe.getOidZona());
        Long oidGrupoZona = new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());
        
        // Calculo la fecha prevista para la actividad
        CNCronograma cnCrono = new CNCronograma();
        Date fechaPrevista = cnCrono.estableceFechaPrevista(dtoe.getDiasDesplazamiento(), actividad, oidGrupoZona, dtoe.getFechaActividadOrigen());
        
        DTODate dtoRetorno = new DTODate();
        dtoRetorno.setFecha(fechaPrevista);
        UtilidadesLog.info("MONCronogramaBean.calcularFechaPrevista(DTOCalcularFechaPrevista dtoe): Salida");
        return dtoRetorno;
    }
    
    public DTOSalida obtenerMensajesCRA(DTOBelcorp dto) throws MareException {
      UtilidadesLog.info("MONCronogramaBean.obtenerMensajesCRA(DTOOID dto): Entrada");
      DAOCRA dao = new DAOCRA();
      DTOSalida dtos = dao.obtenerMensajesCRA();
      UtilidadesLog.info("MONCronogramaBean.obtenerMensajesCRA(DTOOID dto): Salida");
      return dtos;
    }

    private MONGestorPlanificacionLocalHome getMONGestorPlanificacionLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestorPlanificacionLocalHome) context.lookup( "java:comp/env/ejb/local/MONGestorPlanificacion" );
    }
    
}
