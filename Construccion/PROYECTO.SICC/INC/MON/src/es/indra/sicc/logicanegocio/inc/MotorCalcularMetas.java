package es.indra.sicc.logicanegocio.inc;


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
 * Autor : Noziglia C.
 */
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.rules.RuleService;
import es.indra.mare.common.mii.services.rules.RuleServiceException;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import javax.rules.InvalidRuleSessionException;
//import javax.rules.RuleSessionTypeUnsupportedException;
import javax.rules.StatelessRuleSession;

public class MotorCalcularMetas {
    private List objetosDelMotor;
    private StatelessRuleSession workSpace = null;
    
    //jrivas 19/01/2007 V-INC-17 Cambio Calculo Metas Performance
    //private String reglasPuntuacion = "variable_2";
    private String reglasCalcularMetas = "variable_8";

    public MotorCalcularMetas() {
    }

    /**
    * @autor Noziglia C.
    * @throws MareException
    * @param String reglasAplicable
    * @return void
    * @documentation
    *
    * @date 17/06/2005
    */
    private void crearWorkSpace(String reglasAplicables)
            throws MareException, MareMiiServiceNotFoundException/*
    1.- Creamos una instancia del objeto RuleService. y pedimos al MareMii el servicio "RuleService"
    2.- Al atributo objetosDelMotor le asignamos una nueva instancia del objeto java.util.List
    3.- Al atributo workSpace le asignamos lo que nos devuelve la llamada del método ruleService.createRuleSession(reglasAplicables,null,1)
    */
     {
        UtilidadesLog.info("MotorCalcularMetas.crearWorkSpace(String reglasAplicables):Entrada");
        try {
            RuleService ruleService = (RuleService) MareMii.getService(new MareTopic(MareMii.SERVICE_RULE));
            workSpace = (StatelessRuleSession) ruleService.createRuleSession(reglasAplicables, null, 1);
        } catch (RuleServiceException rse) {
            UtilidadesLog.error("ERROR ", rse);
            throw new MareException(rse, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("MotorCalcularMetas.crearWorkSpace(String reglasAplicables):Salida");
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param
     * @return void
     * @documentation
     *
     * @date 17/06/2005
     */
    private void arrancarMotorDeReglas() throws MareException/*
    1.- Llamamos al método executeRules() del objeto workSpace pasandole el atributo objetosDelMotor
    2.- Llamamos al método release() del objeto workSpace.
    */
     {
        UtilidadesLog.info("MotorCalcularMetas.arrancarMotorDeReglas():Entrada");
        try {
            workSpace.executeRules(objetosDelMotor);
            objetosDelMotor.clear();
            workSpace.release();
            workSpace = null;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            try {
                workSpace.release();
            } catch (Exception w) {
                UtilidadesLog.error("ERROR ", w);
            }                
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }
        UtilidadesLog.info("MotorCalcularMetas.arrancarMotorDeReglas():Salida");
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Object objeto
     * @return
     * @documentation
     *
     * @date 17/06/2005
     */
    private void insertarObjetoEnMotor(Object objeto)/*
    1.- Al atributo objetosDelMotor le concatenamos el objeto que se nos pasa por cabecera
    */
     {
        if (objeto != null) {
            objetosDelMotor.add(objeto);
        }
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param ArrayList solicitudes, Concurso concurso
     * @return void
     * @documentation
     *
     * @date 17/06/2005
     */
    public void evaluarSolicitudesParaMetas(ArrayList solicitudes, Concurso concurso)
            throws MareException/*
    AUTOR: gmamano
    ENTRADA: solicitud: java.util.ArrayList, concurso:Concurso
    SALIDA: void
    RESUMEN: Este método evalua los productos que son vállidos segun la definicion del concurso para el calculo de metas.

    1.- Llamamos al método crearWorkSpace() pasandole el valor del atributo reglasPuntuacion.
    2.- Recorremos todas las solicitudes de solicitudes. Para cada una, recorremos el array posiciones invocando al método insertarObjetoEnMotor().
    3.- Invocamos al método insertarObjetoEnMotor pasandole concurso.
    4.- Llamamos al método arrancarMotorDeReglas().
    */
     {
        try {
            UtilidadesLog.info("MotorCalcularMetas.evaluarSolicitudesParaMetas(ArrayList solicitudes, Concurso concurso):Entrada");
            crearWorkSpace(reglasCalcularMetas);

            Iterator it = solicitudes.iterator();
            objetosDelMotor = new ArrayList();

            while (it.hasNext()) {
                Solicitud aux = (Solicitud) it.next();
                if (aux != null && aux.getPosiciones() != null) {
                    int posi=aux.getPosiciones().length;
                    for (int i = 0; i < posi; i++) {
                        insertarObjetoEnMotor(aux.getPosiciones()[i]);
                    }
                }
            }

            insertarObjetoEnMotor(concurso);
            arrancarMotorDeReglas();
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw new MareException(me, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }
        UtilidadesLog.info("MotorCalcularMetas.evaluarSolicitudesParaMetas(ArrayList solicitudes, Concurso concurso):Salida");
    }
}
