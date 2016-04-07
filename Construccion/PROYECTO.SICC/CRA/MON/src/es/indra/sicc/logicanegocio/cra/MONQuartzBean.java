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

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Scheduler;

import java.sql.Date;

import es.indra.sicc.cra.util.Actividad;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cra.util.quartz.JobActividad;
//import es.indra.sicc.BelcorpScheduler;

//import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

public class MONQuartzBean implements SessionBean  {
  SessionContext context;
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
    this.context = ctx;
  }

  /**
   * Este metodo se encarga de crear el JobDetail para las activades
   * En Quartz, el JobDetail representa el ytrabajo a ejecutar, cuando
   * el Job es la ejecucion del mismo
   */
  public void ScheduleAdd(Actividad actividad) throws MareException {
/* Se comento pues cambio la clase actividad y se esta construyendo en base a un nuevo diseño.
try{
    
      String clave = actividad.getActividad().toString()+"__"+actividad.getFecha().getTime();
    
      JobDetail trabajo = new JobDetail(clave, "CRA" ,JobActividad.class );
    
      trabajo.setVolatility(false);
      trabajo.setDurability(true);
    
      JobDataMap data = new JobDataMap();
      data.put("actividad",actividad);
      trabajo.setJobDataMap(data);
    
      SimpleTrigger trigger = new SimpleTrigger(clave,"CRA");
      trigger.setRepeatCount(0);
      trigger.setStartTime(new java.util.Date(actividad.getFecha().getTime()));

    
      Scheduler sched = BelcorpScheduler.getScheduler();
      sched.scheduleJob(trabajo,trigger);
      
    }catch(Exception e){
      //context.setRollbackOnly();
      e.printStackTrace();
      throw new MareException(e);
    }
*/
  }

  /**
   * Este metodo permite eliminar un trabajo de la lista de trabajos
   * programados, y lo elimina fisicamente del Scheduler.
   */
  public void ScheduleRemove(Actividad actividad) throws MareException {
/* Se comento pues cambio la clase actividad y se esta construyendo en base a un nuevo diseño.

    try{
      Scheduler sched = BelcorpScheduler.getScheduler();
      String clave = actividad.getActividad().toString()+"__"+actividad.getFecha().getTime();
      sched.unscheduleJob(clave,"CRA");
      sched.deleteJob(clave,"CRA") ;
    }catch(Exception e){
      //context.setRollbackOnly();
      e.printStackTrace();
      throw new MareException(e);
    }
*/
  }

  public Actividad ScheduleFind(Long codigoActividad, Date fechaEjecucion) throws MareException {
    UtilidadesLog.info("MONQuartzBean.ScheduleFind(Long codigoActividad, Date fechaEjecucion):Entrada");
    String clave = codigoActividad.toString()+"__"+fechaEjecucion.getTime();
    UtilidadesLog.info("MONQuartzBean.ScheduleFind(Long codigoActividad, Date fechaEjecucion):Salida");
    return null;
  }
}