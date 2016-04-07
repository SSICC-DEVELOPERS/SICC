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
 *
 * @author Sergio Saavedra
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;

import java.util.Comparator;


public class ComparadorPeriodos implements Comparator {
    public ComparadorPeriodos() {
    }

    /**
    * @Autor S.Saavedra
    * @return int
    * @param o2
    * @param o1
    */
    public int compare(Object o1, Object o2) {
        UtilidadesLog.info("ComparadorPeriodos.compare(Object o1, Object o2)"
            +":Entrada");

        try {
            Periodo p1 = (Periodo) o1;
            Periodo p2 = (Periodo) o2;

            long fecha1 = p1.getFechaDesde().getTime();
            long fecha2 = p2.getFechaDesde().getTime();

            if (fecha1 < fecha2) {
                UtilidadesLog.info("ComparadorPeriodos.compare(Object o1, " +
                    "Object o2):Salida");

                return -1;
            } else if (fecha1 > fecha2) {
                UtilidadesLog.info("ComparadorPeriodos.compare(Object o1, " +
                    "Object o2):Salida");

                return 1;
            } else if (fecha1 == fecha2) {
                UtilidadesLog.info("ComparadorPeriodos.compare(Object o1, " +
                    "Object o2):Salida");

                return 0;
            }

            UtilidadesLog.info("ComparadorPeriodos.compare(Object o1, Obj"
                +"ect o2):Salida");

            return 0;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            UtilidadesLog.info("ComparadorPeriodos.compare(Object o1, Obj"
                +"ect o2):Salida");

            return 0;
        }
    }
}
