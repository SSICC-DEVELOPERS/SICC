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

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;

import org.quartz.SchedulerFactory;
import org.quartz.Scheduler;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.SchedulerException;

import es.indra.sicc.dtos.cra.DTODatosPlanificador;
import es.indra.sicc.cra.util.Actividad;
import es.indra.sicc.cra.util.quartz.JobActividad;
import es.indra.sicc.cra.util.SchedulingActividades;
import es.indra.sicc.util.UtilidadesLog;


/**
 * 
 * @date 12/09/2005
 * @author pperanzola
 *             - se modifica los log de la clase
 */
public class MONGestorPlanificacionBean implements SessionBean {
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


    /**
     * Crea una tarea y la añade al planificador. Retorna el nombre de la tarea.
     */
    public String crearTarea(DTODatosPlanificador datosActividad) throws MareException {
        UtilidadesLog.info("MONGestorPlanificacionBean.crearTarea(DTODatosPlanificador datosActividad):Entrada");
        Scheduler sched;
        /*String urlmare = System.getProperty("MareConfigurationRoot") + "/services/quartz.properties";
        UtilidadesLog.debug("urlmare " + urlmare);*/
        //1.- Llamamos al método FactoriaPlanificador.getPlanificador 
        sched = SchedulingActividades.getScheduler();
    
        // 2.-Con los datos de la cabecera creamos y rellenamos un objeto Actividad. 
        Actividad actividad = new Actividad();
        actividad.setPais(datosActividad.getPais());
        actividad.setMarca(datosActividad.getMarca());
        actividad.setCanal(datosActividad.getCanal());
        actividad.setPeriodo(datosActividad.getPeriodo());
        actividad.setIdNegocio(datosActividad.getIdNegocio());
        // 3.-Creamos una instancia del objeto JobActividad y le asociamos la actividad invocando a su método 
        // asociarActividad, pasandole el objeto Actividad creado en el paso anterior. 
        String strJobDetail = "jobActividad_" + System.currentTimeMillis();
        JobActividad jobActividad = new JobActividad();
        jobActividad.asociarActividad(actividad);
        JobDetail jobDetail = new JobDetail(strJobDetail,
                                      sched.DEFAULT_GROUP,
                                      JobActividad.class);
        jobDetail.getJobDataMap().put("actividad", actividad);
        jobDetail.setVolatility(false);
        jobDetail.setRequestsRecovery(true);
        // 4.- Con datosActividad.fechaInicioActividad deberemos crear un disparador que contenga la fecha de activacion de la tarea (datosActividad.fechaInicioActividad). 
        String strMyTrigger = "myTrigger" + System.currentTimeMillis();
        SimpleTrigger trigger = new SimpleTrigger(strMyTrigger,
                                            sched.DEFAULT_GROUP,
                                            datosActividad.getFechaEjecucion(),
                                            null,
                                            0,
                                            0L);
        // 5.- Deberemos asociar la actividad y el disparador a la instancia del planificador.
        try {
            sched.scheduleJob(jobDetail, trigger);
        } catch(SchedulerException e) {
            UtilidadesLog.error(e);
            throw new MareException(e);
        }
        UtilidadesLog.info("MONGestorPlanificacionBean.crearTarea(DTODatosPlanificador datosActividad):Salida");
        return strJobDetail;
    }

    public void borrarTarea(String nombreTarea) throws MareException{
        UtilidadesLog.info("MONGestorPlanificacionBean.borrarTarea(String nombreTarea):Entrada");
        Scheduler sched;
        try{
            //1.- Llamamos al método FactoriaPlanificador.getPlanificador 
            sched = SchedulingActividades.getScheduler();
            UtilidadesLog.info("MONGestorPlanificacionBean.borrarTarea(String nombreTarea):Salida");
            sched.deleteJob(nombreTarea, sched.DEFAULT_GROUP);
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
    }

}