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
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.zon.DTOPedidosZona;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;

public class DAOEstadisticasPED  {
    public DAOEstadisticasPED() {
    }
    
    public DTOPedidosZona obtenerNumeroPedidosYMonto (DTOPedidosZona DTOE)
                                                      throws MareException{
        UtilidadesLog.info("DAOEstadisticasPED.obtenerNumeroPedidosYMonto(DTOPedidosZona DTOE): Entrada ***");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT ");
        /*
         * DBLG50000150 - dmorello, 09/08/2006
         * Ya no se contarán los OIDs de cabecera
         */
        //consulta.append(" COUNT(OID_SOLI_CABE) SOLICITUD, "); 
        /*
         * INC 22396 - dmorello, 09/02/2006
         * Agrego NVL a la suma ya que, si no se recuperan filas de la tabla,
         * da NULL y el método termina con NullPointerException
         */
        consulta.append(" NVL( ");
        consulta.append(" SUM( ");
        /*
         * DBLG500000150 - dmorello, 10/04/2006
         * Sólo se sumará el campo VAL_PREC_CATA_TOTA_LOCA.
         */
        consulta.append(" NVL(VAL_PREC_CATA_TOTA_LOCA, 0) ");
        //consulta.append(" NVL(VAL_IMPO_DESC_1_SIN_IMPU_TOTA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DESC_1_TOTA_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DESC_1_TOTA_LOCA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DESC_3_SIN_IMPU_TOTA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DESC_3_TOTA_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DESC_3_TOTA_LOCA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DESC_TOTA_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DESC_TOTA_LOCA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_DTO_1_SIN_IMP_TOT_LOC, 0) + "); 
        //consulta.append(" NVL(VAL_IMPO_DTO_3_SIN_IMP_TOT_LOC, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_FLET_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_FLET_LOCA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_FLET_SIN_IMPU_DOCU, 0) + "); 
        //consulta.append(" NVL(VAL_IMPO_FLET_SIN_IMPU_TOTA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_FLET_TOTA_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_FLET_TOTA_LOCA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_IMPU_TOTA_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_IMPU_TOTA_LOCA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_REDO_CONS_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_REDO_CONS_LOCA, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_REDO_DOCU, 0) + ");
        //consulta.append(" NVL(VAL_IMPO_REDO_LOCA,0) ");
        // dmorello, 09/02/2006: En la sig.línea cierro el NVL agregado antes.
        consulta.append(" ), 0) AS MONTO "); 
        consulta.append(" FROM PED_SOLIC_CABEC ");
        consulta.append(" WHERE PERD_OID_PERI = ? ");
        consulta.append(" AND ZZON_OID_ZONA = ? ");
        /* dmorello, 09/08/2006 - Filtros en DMCO que estaban faltando */
        consulta.append(" AND FEC_FACT IS NOT NULL ");
        consulta.append(" AND IND_OC = 1");
        consulta.append(" AND IND_TS_NO_CONSO = 1 ");
        /* DBLG500000150 - dmorello, 09/08/2006: Montos agrupados por cliente */
        consulta.append(" GROUP BY CLIE_OID_CLIE ");

        // Parametros de la consulta
        parametros.add(DTOE.getOidPeriodo());
        parametros.add(DTOE.getOidZona());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error("Exception: ", e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /* DBLG50000150 dmorello 09/08/2006: MontoTotal = suma de montos de regs */
        double sumaMontos = 0;
        int n = 0;
        
        if(rs!=null){
          if(!rs.esVacio()){
            n=rs.getRowCount();
              for(int i=0;i<n;i++){
                /* dmorello 09/08/2006: El total de pedidos se setea afuera */
                //if(rs.getValueAt(i,"SOLICITUD")!=null){
                //    DTOE.setTotalPedidos(new Integer(((BigDecimal)rs.getValueAt
                //    (i,"SOLICITUD")).intValue()));
                //}
                 if(rs.getValueAt(i,"MONTO")!=null){
                    /*
                     * DBLG500000150 dmorello 09/08/06 Sólo incremento sumaMontos
                     */
                    //DTOE.setMontoTotal(new Double(((BigDecimal)rs.getValueAt
                    //(i,"MONTO")).doubleValue()));
                    sumaMontos += ((BigDecimal)rs.getValueAt(i,"MONTO")).doubleValue();
                }
              }//for
          }
        }
        
        // Guardo los valores obtenidos en el paso anterior...
        DTOE.setTotalPedidos(new Integer(n));
        DTOE.setMontoTotal(new Double(sumaMontos));

        UtilidadesLog.info("DAOEstadisticasPED.obtenerNumeroPedidosYMonto(DTOPedidosZona DTOE): Salida  ");
        return DTOE;
    }
}