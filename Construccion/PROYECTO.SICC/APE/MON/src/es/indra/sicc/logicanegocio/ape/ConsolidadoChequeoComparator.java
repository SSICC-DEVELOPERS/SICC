/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ape;

import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Comparator;


public class ConsolidadoChequeoComparator implements Comparator {
    public ConsolidadoChequeoComparator() {
    }
    
    /**
     * Compara los dos objetos recibidos que deben pertenecer a la clase DTOFACConsolidado
     * y devuelve -1, 0 ó 1 cuando o1 es mayor, igual o menor que o2 (por TipoRevision)
     * o -1, 0 ó 1 cuando o1 es menor, igual o mayor que o2 (por NumeroSecuenciaFacturacion).
     * Las solicitudes con revision en linea o en linea y campo son "mayores" que 
     * las que solo se chequean en campo o no se chequean. Pero ante igualdad
     * se ordena por numero de secuencia de facturacion ascendente antes de balanceo.
     * Criterios: 
     *   1. tipoRevision DESCENDENTE (se aplica en primer lugar)
     *   2. numeroSecuenciaFacturacionDiaria ASCENDENTE (en segunda instancia o sea igualdad 
     *    del primer criterio).
     * @autor eiraola
     * @since 05/Mar/2007
     */
    public int compare(Object o1, Object o2) {
        try {
            DTOFACConsolidado consolidado1 = (DTOFACConsolidado)o1;
            DTOFACConsolidado consolidado2 = (DTOFACConsolidado)o2;
            
            Long tipoRevision1 = consolidado1.getDtoCabecera().getIndicadorRevision();
            Integer secuenciaFacturacion1 = consolidado1.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria();
            
            Long tipoRevision2 = consolidado2.getDtoCabecera().getIndicadorRevision();
            Integer secuenciaFacturacion2 = consolidado2.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria();
            
            // Criterio1 (tipoRevision de 'mayor' a 'menor'):
            //           'Linea' es lo mismo que 'Ambas'
            //           'Campo' es lo mismo que null
            //           'Linea' o 'Ambas' son mayores que 'Campo' o que null
            if ( (ConstantesPED.OID_REVISION_LINEA.equals(tipoRevision1) 
                     || ConstantesPED.OID_REVISION_AMBAS.equals(tipoRevision1)) 
                 && (tipoRevision2 == null 
                     || ConstantesPED.OID_REVISION_CAMPO.equals(tipoRevision2)) ) {
                return -1;
            } else if ( (tipoRevision1 == null 
                            || ConstantesPED.OID_REVISION_CAMPO.equals(tipoRevision1) ) 
                        && (ConstantesPED.OID_REVISION_LINEA.equals(tipoRevision2) 
                            || ConstantesPED.OID_REVISION_AMBAS.equals(tipoRevision2)) ) {
                return 1;
            } else {
                // (tipoRevision1 == tipoRevision2) || 
                // (ConstantesPED.OID_REVISION_LINEA.equals(tipoRevision1) && ConstantesPED.OID_REVISION_LINEA.equals(tipoRevision2)) ||
                // (ConstantesPED.OID_REVISION_LINEA.equals(tipoRevision1) && ConstantesPED.OID_REVISION_AMBAS.equals(tipoRevision2)) ||
                // (ConstantesPED.OID_REVISION_AMBAS.equals(tipoRevision1) && ConstantesPED.OID_REVISION_AMBAS.equals(tipoRevision2)) ||
                // (ConstantesPED.OID_REVISION_AMBAS.equals(tipoRevision1) && ConstantesPED.OID_REVISION_LINEA.equals(tipoRevision2)) ||
                // (ConstantesPED.OID_REVISION_CAMPO.equals(tipoRevision1) && ConstantesPED.OID_REVISION_CAMPO.equals(tipoRevision2)) ||
                // (ConstantesPED.OID_REVISION_CAMPO.equals(tipoRevision1) && tipoRevision2 == null) ||
                // (tipoRevision1 == null && ConstantesPED.OID_REVISION_CAMPO.equals(tipoRevision2))
                
                // Criterio2 (numeroSecuenciaFacturacion de 'menor' a 'mayor')
                if (secuenciaFacturacion1 != null) {
                    if (secuenciaFacturacion2 != null) {
                        return secuenciaFacturacion1.compareTo(secuenciaFacturacion2);
                    } else {
                        return -1;
                    }
                } else {
                    if (secuenciaFacturacion2 != null) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
            
        } catch (ClassCastException cce) {
            UtilidadesLog.error("ERROR al Castear objetos para ConsolidadoChequeoComparator", cce);
            return 0;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR en ConsolidadoChequeoComparator", e);
            return 0;
        }
    }
}