package es.indra.sicc.logicanegocio.ccc;

//~--- non-JDK imports --------------------------------------------------------

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTODatosAbonoSubprocesoMarcaSituacion;
import es.indra.sicc.dtos.ccc.DTOIdentificadoresDeCuota;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTOOrdenaMovimientosFechaVencimiento;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

//~--- JDK imports ------------------------------------------------------------

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.ejb.SessionContext;

//~--- classes ----------------------------------------------------------------

public class HelperCancelacion {
   private HelperCancelacion(){
      super();
   }

   public HelperCancelacion(SessionContext session){
      super();
   }

   public static synchronized HashMap obtenerSubprocesos(Long oidPais, Long oidTipoSolicPais[]) throws MareException{
      UtilidadesLog.info("HelperCancelacion.obtenerAbonoSubprocesoMarcaSituacion(" + "Long oidPais, Long oidTipoSolicPais[]): Entrada ");

      StringBuffer query = new StringBuffer();
      RecordSet rs;
      HashMap salida = new HashMap();
      String indicadorVcto = null;

      try{
         query.append(" SELECT ");
         query.append(" IND_EMIS_VENC ");
         query.append(" FROM ");
         query.append(" SEG_PAIS p");
         query.append(" WHERE ");
         query.append(" p.OID_PAIS =  " + oidPais);
         rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
         indicadorVcto = rs.getValueAt(0, 0).toString();

         // agregamos los tipos de solicitud pais al hash de salida
         // y luego completamos el dto asociado a cada una de las
         // entradas
         for (int i = 0; i < oidTipoSolicPais.length; i++){
            salida.put(new Long(oidTipoSolicPais[i].longValue()), new DTODatosAbonoSubprocesoMarcaSituacion());
         }

         query = new StringBuffer();
         query.append(" SELECT SUB.OID_SUBP, SUB.VAL_INDI_ACTU_CUOT, ");
         query.append(" asts.oid_asig_subp_por_tipo_soli, asts.tspa_oid_tipo_soli_pais, ");
         query.append(" asts.subp_oid_subp_crea_cuot, asts.ccba_oid_cuen_corr_banc ");
         query.append(" FROM CCC_SUBPR SUB, ccc_asign_subpr_tipo_solic asts, ");
         query.append(" ped_tipo_solic_pais tsp ");
         query.append(" WHERE  SUB.OID_SUBP = asts.SUBP_OID_SUBP_APLI_CUOT ");
         query.append(" AND asts.TSPA_OID_TIPO_SOLI_PAIS = tsp.OID_TIPO_SOLI_PAIS");
         query.append(" and TSP.PAIS_OID_PAIS = " + oidPais.longValue());
         // query.append(" and TSP.oid_tipo_soli_pais = " + oidTipoSolicitud.longValue());
         query.append(" AND (TSP.oid_tipo_soli_pais IN( ");

         Iterator it = salida.keySet().iterator();
         int contador = 0;

         while (it.hasNext()){
            query.append(it.next().toString()).append(",");
            contador += 1;

            if ((contador % 800) == 0){
               query.delete(query.length() - 1, query.length());

               if (it.hasNext()){
                  query.append(") OR TSP.oid_tipo_soli_pais IN (");
               }
            }
         }

         if (query.substring(query.length() - 1).equals(",")){
            query.delete(query.length() - 1, query.length());
         }

         query.append(" ))");
         rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());

         int registros = rs.getRowCount();

         if ((rs != null) && (registros > 0)){
            // creo los dtos relacionados al tipo de solicitud encontrado, los que no se encuentran,
            // se obtienen mas abajo por el metodo tradicional
            for (int i = 0; i < registros; i++){
               DTODatosAbonoSubprocesoMarcaSituacion dtoTemp = (DTODatosAbonoSubprocesoMarcaSituacion) salida.get(bigDecimalToLong(rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")));

               dtoTemp.setIndicadorAsigTipoSolic(new Boolean("TRUE"));
               dtoTemp.setOidSubProceso(bigDecimalToLong(rs.getValueAt(i, "OID_SUBP")));
               dtoTemp.setIndicadorEmisionVctoPais(indicadorVcto);

               if (bigDecimalToLong(rs.getValueAt(i, "VAL_INDI_ACTU_CUOT")).intValue() == 1){
                  dtoTemp.setIndicadorActualizaCuota(new Boolean("TRUE"));
               }else{
                  dtoTemp.setIndicadorActualizaCuota(new Boolean("FALSE"));
               }
            }
         }
      }catch (MareException me){
         UtilidadesLog.debug("HelperCancelacion.obtenerAbonoSubprocesoMarcaSituacion: llego a la excepcion Mare ");
         throw me;
      }catch (Exception ex){
         UtilidadesLog.debug("HelperCancelacion.obtenerAbonoSubprocesoMarcaSituacion: llego a la excepcion desconocida ");
         ex.printStackTrace();
         throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      UtilidadesLog.info("HelperCancelacion.obtenerAbonoSubprocesoMarcaSituacion(" + "Long oidPais, Long oidTipoSolicPais[]): Salida");
      return salida;
   }

   public static synchronized void completarDatosProcesoSubproceso(HashMap tiposSolicitud, String proceso, Integer subProceso, Long oidPais) throws MareException{
      try{
         StringBuffer query;

         query = new StringBuffer();
         query.append(" SELECT SUB.OID_SUBP, ");
         query.append(" SUB.VAL_INDI_ACTU_CUOT ");
         query.append(" FROM CCC_SUBPR SUB, ");
         query.append(" CCC_PROCE PRO ");
         query.append(" WHERE SUB.CCPR_OID_PROC = PRO.OID_PROC ");
         query.append(" AND PRO.PAIS_OID_PAIS = " + oidPais.longValue());
         query.append(" AND PRO.COD_PROC = '" + proceso + "' ");
         query.append(" AND SUB.COD_SUBP = '" + subProceso.intValue() + "' ");

         Iterator it = tiposSolicitud.keySet().iterator();
         Long oidSubProc = null;
         Boolean indicadorActualiza = null;
         RecordSet rs = null;

         while (it.hasNext()){
            Long oidTipoSolic = (Long) it.next();
            DTODatosAbonoSubprocesoMarcaSituacion dtoTemp = (DTODatosAbonoSubprocesoMarcaSituacion) tiposSolicitud.get(oidTipoSolic);

            if ((dtoTemp.getIndicadorAsigTipoSolic() != null) && dtoTemp.getIndicadorAsigTipoSolic().booleanValue()){
               continue;
            }else{
               if (rs == null){    // para ejecutarlo solo 1 vez
                  rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
                  oidSubProc = bigDecimalToLong(rs.getValueAt(0, "OID_SUBP"));

                  if (bigDecimalToLong(rs.getValueAt(0, "VAL_INDI_ACTU_CUOT")).intValue() == 1){
                     indicadorActualiza = new Boolean("TRUE");
                  }else{
                     indicadorActualiza = new Boolean("FALSE");
                  }
               }

               dtoTemp.setIndicadorAsigTipoSolic(new Boolean("FALSE"));
               dtoTemp.setOidSubProceso(oidSubProc);
               dtoTemp.setIndicadorActualizaCuota(indicadorActualiza);
            }
         }
      }catch (MareException me){
         UtilidadesLog.debug("HelperCancelacion.obtenerAbonoSubprocesoMarcaSituacion: llego a la excepcion Mare ");
         throw me;
      }catch (Exception ex){
         UtilidadesLog.debug("HelperCancelacion.obtenerAbonoSubprocesoMarcaSituacion: llego a la excepcion desconocida ");
         ex.printStackTrace();
         throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      UtilidadesLog.info("HelperCancelacion.obtenerAbonoSubprocesoMarcaSituacion(String proceso, Integer subProceso, " + "Long oidPais, Long oidTipoSolicPais[]): Entrada ");
   }

   private static synchronized Long bigDecimalToLong(Object numero){
      if (numero != null){
         return new Long(((BigDecimal) numero).longValue());
      }else{
         return null;
      }
   }

   public static synchronized DTOIdentificadoresDeCuota obtenerDatosDocumentoReferencia(Long oidDocumentoReferencia) throws MareException{
      StringBuffer buff = new StringBuffer();

      buff.append("SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC WHERE OID_SOLI_CABE = " + oidDocumentoReferencia.toString());

      DTOIdentificadoresDeCuota dtoSalida = null;

      try{
         RecordSet salida = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());

         if (!salida.esVacio()){
            if (salida.getValueAt(0, 0) != null){
               String numeroSolicitud = salida.getValueAt(0, 0).toString();

               // como lo encontre, actualizo el dto con los datos de la solictud
               // original, para poder ubicar el movimiento CCC que corresponde
               numeroSolicitud = HelperCancelacion.cerosIzq(numeroSolicitud, 10);
               UtilidadesLog.debug("- GA - numero de solicitud formateado: " + numeroSolicitud);
               dtoSalida = new DTOIdentificadoresDeCuota();
               dtoSalida.setEjercicioCuota(numeroSolicitud.substring(0, 2));
               dtoSalida.setIdentificadorEjercicioCuota(numeroSolicitud.substring(2));
               UtilidadesLog.debug("- GA - DTOIdentificadoresDeCuota: " + dtoSalida);
            }
         }
      }catch (Exception e){
         UtilidadesLog.error("Error el buscar la solicitud de referencia: ", e);
      }

      return dtoSalida;
   }

   public static synchronized DTOMovimientoCuentaCompleto[] ordenarPorVencimiento(DTOMovimientoCuentaCompleto[] movimientos){
      ArrayList tmp = new ArrayList();

      for (int i = 0; i < movimientos.length; i++){
         tmp.add(new DTOOrdenaMovimientosFechaVencimiento(movimientos[i].getOid(), movimientos[i].getFechaVencimiento(), movimientos[i]));
      }

      Collections.sort(tmp);

      DTOMovimientoCuentaCompleto[] salida = new DTOMovimientoCuentaCompleto[movimientos.length];

      for (int i = 0; i < tmp.size(); i++){
         salida[i] = ((DTOOrdenaMovimientosFechaVencimiento) tmp.get(i)).getMovimiento();
      }

      return salida;
   }

   private static synchronized String cerosIzq(String cadena1, int cantidad){
      StringBuffer cantCeros = new StringBuffer(cantidad);
      int numeros = cantidad - cadena1.length();

      for (int i = 0; i < numeros; i++){
         cantCeros.append("0");
      }

      cantCeros.append(cadena1);
      return cantCeros.toString();
   }
}
