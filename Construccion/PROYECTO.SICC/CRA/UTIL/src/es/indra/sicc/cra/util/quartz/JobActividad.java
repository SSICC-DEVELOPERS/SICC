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

package es.indra.sicc.cra.util.quartz;

import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.sicc.cra.util.Actividad;
import es.indra.sicc.dtos.cra.DTODatosPlanificador;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesLog;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.mare.enterprise.mln.BusinessFacade;
import java.rmi.RemoteException;
import java.util.Hashtable;
import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.rmi.PortableRemoteObject;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.cra.ConstantesCRA;

import org.apache.commons.configuration.*;


public class JobActividad implements Job, Serializable {

    private JobDataMap jobDataMap = new JobDataMap();

    public JobActividad() {
        super();
    }

    /**
     * Asocia una actividad al JobDataMap, la cual pasa a estar disponible para ser ejecutada.
     */
    public void asociarActividad(Actividad actividad) {
        //1.- Creamos un objeto JobDataMap y almacenamos en el el objeto actividad    
        jobDataMap.put("actividad", actividad);
    }



    /**
     * 
     */
    public void execute(JobExecutionContext context) { //throws JobExecutionException {
        UtilidadesLog.info("JobActividad.execute(JobExecutionContext context):Entrada");
        Context ctx;
        BusinessFacadeHome businessFacadeHome;
        BusinessFacade businessFacade;

        try {
            ctx = getInitialContext();
            businessFacadeHome = (BusinessFacadeHome)PortableRemoteObject.narrow(ctx.lookup("mare.mln.BusinessFacade"), BusinessFacadeHome.class);
            businessFacade = businessFacadeHome.create();
        } catch(RemoteException e) {
            UtilidadesLog.error(e);
            return;
        } catch(NamingException e) {
            UtilidadesLog.error(e);
            return;
        } catch(CreateException e) {
            UtilidadesLog.error(e);
            return;
        }

        //1.- Recuperamos el objeto Actividad almacenado en JobActividad.
        Actividad actividad = (Actividad)context.getJobDetail().getJobDataMap().get("actividad");
        UtilidadesLog.debug("actividad a ejecutar con bussinesID: " + actividad.getIdNegocio());

        //2.- Recuperamos su atributo "programa", con este IDBusiness invocamos la BusinessFacade pasandole Actividad (con pais, marca, canal y periodo) para que ejecute el método apropiado.
        MareBusinessID bussinesID = new MareBusinessID(actividad.getIdNegocio());

        // 2.- Recuperamos su atributo "programa", con esos datos compondremos un MareDTO con los atributos 
        // pais, marca, canal y periodo, con el IDBusiness(IdNegocio) de Actividad invocamos la
        // BusinessFacade pasandole el MareDTO para que ejecute el método apropiado.
        // Usamos como propiedades del MareDTO de ConstantesCRA: DATO_PAIS, DATO_MARCA, DATO_CANAL, DATO_PERIODO
        IMareDTO mareDTO = new MareDTO();
        mareDTO.addProperty(ConstantesCRA.DATO_PAIS, actividad.getPais());
        mareDTO.addProperty(ConstantesCRA.DATO_MARCA, actividad.getMarca());
        mareDTO.addProperty(ConstantesCRA.DATO_CANAL, actividad.getCanal());
        mareDTO.addProperty(ConstantesCRA.DATO_PERIODO, actividad.getPeriodo());
        mareDTO.addProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_CRA));
        UtilidadesLog.debug("mareDTO: " + mareDTO);

        try {
            IMareDTO dtoSalida = businessFacade.execute(mareDTO, bussinesID);
        } catch(MareException ex) {
            UtilidadesLog.error(ex);
        } catch(RemoteException e) {
            UtilidadesLog.error(e);
        } catch(Throwable e) {
            UtilidadesLog.error(e);
        }
        UtilidadesLog.info("JobActividad.execute(JobExecutionContext context):Salida");
    }


    private static Context getInitialContext() throws NamingException {
        UtilidadesLog.info("JobActividad.getInitialContext():Entrada");
        Hashtable env = new Hashtable();
        try {
            // MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic("SchedulingService"));
            PropertiesConfiguration properties = new PropertiesConfiguration(System.getProperty("MareConfigurationRoot") + "/services/quartz.properties");
            String rmi = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.factory.initial");
            String url = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.provider.url");
            String usr = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.security.principal");
            String password = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.security.credentials");
            UtilidadesLog.debug("rmi " + rmi);
            UtilidadesLog.debug("url " + url);
            UtilidadesLog.debug("usr " + usr);
            UtilidadesLog.debug("password " + password);
                   
            env.put(Context.INITIAL_CONTEXT_FACTORY, rmi);
            env.put(Context.SECURITY_PRINCIPAL, usr);
            env.put(Context.SECURITY_CREDENTIALS, password);
            env.put(Context.PROVIDER_URL, url);
        } catch (Exception e) {
            UtilidadesLog.error(e);
        }
        UtilidadesLog.info("JobActividad.getInitialContext():Salida");
        return new InitialContext(env);
    }

}
