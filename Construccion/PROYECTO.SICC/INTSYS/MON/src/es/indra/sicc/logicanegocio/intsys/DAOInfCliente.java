package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.intsys.DTOClienteFechaFinPeriodo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import java.sql.Date;

import java.util.ArrayList;

import es.indra.sicc.dtos.intsys.DTOAtributo;
import es.indra.sicc.dtos.intsys.DTODatosAdicionales;
import es.indra.sicc.dtos.intsys.DTOInfoCliente;
import es.indra.sicc.dtos.intsys.DTOVentasGis;

public class DAOInfCliente 
{
  public DAOInfCliente()
  {
  }
  
  
 /**
   *@Author: Cargain, 17/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return ArrayList
   *@param ArrayList listaOids
   *@param Long oidPeriodo
   * 
   *06/05/2005 - rgiorgi - se eliminaron los UtilidadesLog.debug 
   *                     - se formatearon algunas lineas
   *                     - se modificó la query de completarDatosCliente con right joins.
   *
   *31/08/2005 - ssaavedr -Se modifica consulta en virtud de charla con JF, dado que a la misma le
   *                       falta filtrar por el estado de las posiciones (<>ESTADO_POSICION_ANULADO)
   *                       y cabecera solicitud.FEC_FACT debe ser <> de null
   *                       Por otro lado existen filtros de sobra, que no estan el modelo:
   *                       AND (TSP.oid_tipo_soli_pais = SC.tspa_oid_tipo_soli_pais_cons)
   */                 
  /**ListaOids; Long : DTOE.oidPeriodo ArrayList */
  public ArrayList calcularMontoDevoluciones(ArrayList ListaOids ,Long oidPeriodo) throws MareException {
  /*
   * Se quiere calcular el monto total de la devolucion de la entidad solicitudPosicion de PED, la suma del campo precioCatalogoTotalLocal de los registros obtenidos. Para ello:  

        Acceder a las entidades Acceso (SEG) , SubAcceso (SEG), Periodo (CRA), PeriodoCorporativo (SEG), 
        SolicitudCabecera (PED), SolicitudPosicion (PED), TipoSolicitudPais (PED), TipoSolicitud (PED), 
        haciendo join entre ellas 
        
        filtrando por: 
        SolicitudCabecera.oidCliente IN ListaOids //Se deben tomar todos aquellos 
        registros cuyos oidCliente vengan en la ListaOids 
        TipoSolicitud.IND_DEVO=1 
        SolicitudCabecera.IND_TS_NO_CONSO=1 
        SolicitudCabecera.FEC_FACT=null 
        SolicitudCabecera.oidPeriodo=DTOE.oidPeriodo 
        
        Los de las join: SolicitudCabecera con Periodo 
        SolicitudCabecera con SubAcceso 
        SubAcceso con Acceso 
        PeriodoCorporativo con Periodo 
        SolicitudCabecera con SolicitudPosicion 
        SolicitudCabecera con TipoSolicitudPais 
        TipoSolicitudPais con TipoSolicitud 
        
        Obtener: 
        - SolicitudCabecera.oidCliente 
        - Acceso.codAcceso 
        - PeriodoCorporativo.codPeriodo 
        - SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA haciendo una suma de este 
        campo de todos los registros encontrados. 
        
        
        Agrupando por: codPeriodo, codAcceso, oidCliente 
        
        
        Con los registros obtenidos se crea una lista de objetos DTOAtributo y 
        se retorna. 
        
        DTOAtributo.oidCliente=SolicitudCabecera.oidCliente 
        DTOAtributo.codAcceso=Acceso.codAcceso 
        DTOAtributo.codPeriodo=PeriodoCorporativo.codPeriodo 
        DTOAtributo.codAtributo=ConstantesINT.COD_ATRIBUTO1 
        DTOAtributo.valorAtributo=SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA 
        haciendo una conversión a String de este valor 

   * 
   */ 
        UtilidadesLog.info("DAOInfCliente.calcularMontoDevoluciones(ArrayList ListaOids ,Long oidPeriodo): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;        
        
        StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
        
        consulta.append(" SELECT acceso.cod_acce COD_ACCE, ");
        consulta.append(" PC.cod_peri COD_PERI, ");
        //jrivas 24/2/2006 DBLG400000990
        //consulta.append(" SUM (SP.val_prec_cata_tota_loca) TOTA_LOCA, ");
        consulta.append(" SUM (SP.VAL_PREC_NETO_TOTA_LOCA) TOTA_LOCA, ");
        consulta.append(" SC.clie_oid_clie CLIE_OID_CLIE");
        consulta.append(" FROM seg_acces acceso, ");
        consulta.append(" seg_perio_corpo PC, ");
        consulta.append(" seg_subac SA, ");
        consulta.append(" cra_perio P, ");
        consulta.append(" ped_solic_cabec SC, ");
        consulta.append(" ped_solic_posic SP, ");
        consulta.append(" ped_tipo_solic_pais TSP, ");
        consulta.append(" ped_tipo_solic TS ");
        
        
        consulta.append(" WHERE (  ");
        boolean cerre = false;
        int x=0;
        int y = 0;
        while (x < ListaOids.size()){
            if (y == 0){
                if (x != 0){
                    consulta.append(" OR ");
                }
                consulta.append(" SC.clie_oid_clie IN ( ");
            }
            if (y < 999){
                consulta.append(ListaOids.get(x)).append(" ,");
                y++;
                cerre = false;
            }else{
                y = 0;
                cerre = true;
                consulta.append(ListaOids.get(x)).append(" ) ");
            }
            x++;        
            if (x == ListaOids.size() && !cerre){
                consulta.deleteCharAt(consulta.length()-1);
                consulta.append(" ) ");	
            }
        }
            
        /*parametros.add((Long)ListaOids.get(0));
        for(int i = 1; i< ListaOids.size() ; i++){
            consulta.append(" , ? ");
            parametros.add((Long)ListaOids.get(i));  
        }
        consulta.append(" ) ");*/
        
        ///Agregado
        
     /*   consulta.append("( OR SC.clie_oid_clie IN ( ?");
        parametros.add((Long)ListaOids.get(0));
        for(int i = 1; i< ListaOids.size() ; i++){
            consulta.append(" , ? ");
            parametros.add((Long)ListaOids.get(i));  
        }
        consulta.append(" ) ");*/
        
        consulta.append("AND (TS.IND_DEVO = 1 ) ");
        consulta.append("AND (SC.IND_TS_NO_CONSO=1 ) ");
        //consulta.append("AND (SC.FEC_FACT IS null ) ");
        consulta.append("AND (SC.FEC_FACT IS NOT null ) ");
        consulta.append("AND (SC.PERD_OID_PERI = ? )");
        parametros.add(oidPeriodo);
        
        /* antes!!
        consulta.append("AND (acceso.oid_acce = SA.acce_oid_acce) ");
        consulta.append("AND (acceso.oid_acce = P.acce_oid_acce) ");
        consulta.append("AND (PC.oid_peri = P.peri_oid_peri) ");
        consulta.append("AND (SA.oid_sbac = SC.sbac_oid_sbac) ");
        consulta.append("AND (P.oid_peri = SC.perd_oid_peri) ");
        consulta.append("AND (SC.oid_soli_cabe = SP.soca_oid_soli_cabe) ");
        consulta.append("AND (TSP.oid_tipo_soli_pais = SC.tspa_oid_tipo_soli_pais) ");
        consulta.append("AND (TSP.oid_tipo_soli_pais = SC.tspa_oid_tipo_soli_pais_cons) ");
        consulta.append("AND (TS.oid_tipo_soli = TSP.tsol_oid_tipo_soli)) ");
        */
        consulta.append("AND (SC.perd_oid_peri = P.oid_peri) ");  
        consulta.append("AND (SC.sbac_oid_sbac = SA.oid_sbac) ");
        consulta.append("AND (SA.acce_oid_acce = acceso.oid_acce) ");
        consulta.append("AND (PC.oid_peri = P.peri_oid_peri) ");
        consulta.append("AND (SC.oid_soli_cabe = SP.soca_oid_soli_cabe) ");
        consulta.append("AND (SC.tspa_oid_tipo_soli_pais = TSP.oid_tipo_soli_pais) ");
        consulta.append("AND (TSP.tsol_oid_tipo_soli = TS.oid_tipo_soli)) ");
        
        consulta.append("AND (SP.ESPO_OID_ESTA_POSI <> ? ) ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        consulta.append("GROUP BY PC.cod_peri, acceso.cod_acce,");
        consulta.append("SC.clie_oid_clie");
        
      //  this.logSql("calcularMontoDevoluciones",consulta.toString(),parametros);
        try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("calcularMontoDevoluciones:",e);
            
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        ArrayList ListaDTOAtributo = new ArrayList();
		for(int j= 0; j < resultado.getRowCount(); j++){
            DTOAtributo dtoA = new DTOAtributo();
            
            dtoA.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(j,
                            "CLIE_OID_CLIE")).longValue()));
            dtoA.setCodAcceso( resultado.getValueAt(j,"COD_ACCE").toString());
            dtoA.setCodPeriodo(resultado.getValueAt(j,"COD_PERI").toString());
            dtoA.setCodAtributo(ConstantesINT.COD_ATRIBUTO1);    
            dtoA.setValorAtributo(resultado.getValueAt(j,"TOTA_LOCA").toString());
            ListaDTOAtributo.add(dtoA);
        }
        UtilidadesLog.info("DAOInfCliente.calcularMontoDevoluciones(ArrayList ListaOids ,Long oidPeriodo): Salida");
        return ListaDTOAtributo;
    }
  
  
    /**
   *@Author: Cargain, 17/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return ArrayList
   *@param ArrayList listaOids
   *@param Long oidPeriodo
   *@param Integer num
   *31/08/2005 - ssaavedr -Se modifica consulta en virtud de charla con JF, dado que a la misma le
   *                       falta filtrar por el estado de las posiciones (<>ESTADO_POSICION_ANULADO)
   *                       y cabecera solicitud.FEC_FACT debe ser <> de null
   *                       Por otro lado la consulta no respetaba el modelo.
   */
  /**calcularVentas (ListaOids; Long : DTOE.oidPeriodo; Integer : num ArrayList), */
   public ArrayList calcularVentas(ArrayList ListaOids, Long OidPeriodo, HashMap listanum ) throws MareException {
  /*
   *  Se pretende obtener el importe de venta neta para cada cliente, el numero 
   *  de solicitudesCabecera leidas, las unidades atendidas y la venta por periodo. 
   *  Y el tipo de cambio a dolares para el pais,  puesto que se también se 
   *  quieren recuperar el importe de venta neta en dolares y la venta por 
   *  periodo en dolares

        Acceder a las entidades Acceso (SEG), SubAcceso (SEG), Periodo (CRA), 
        PeriodoCorporativo (SEG) , SolicitudCabecera (PED), SolicitudPosicion (PED), 
        ClaseSolicitud (PED), CabeceraMatrizFacturacion (PRE) 
        haciendo join entre ellas 
        
        
        filtrando por: 
        SolicitudCabecera.oidCliente IN ListaOids //Se deben tomar todos aquellos registros cuyos oidCliente vengan en la ListaCliente 
        ClaseSolicitud.IND_ORDE_COMP=1 
        SolicitudCabecera.IND_TS_NO_CONSO=1 
        SolicitudCabecera.FEC_FACT=null 
        SolicitudPosicion.oidEstadoPosicion=ConstantesPED.ESTADO_POSICION_ANULADO 
        SolicitudCabecera.oidPeriodo=DTOE.oidPeriodo 
        CabeceraMatrizFacturacion.oidPeriodo=DTOE.oidPeriodo 
        
        Los de las join: SolicitudCabecera con Periodo 
        SolicitudCabecera con SubAcceso 
        SubAcceso con Acceso 
        PeriodoCorporativo con Periodo 
        SolicitudCabecera con SolicitudPosicion 
        SolicitudCabecera con ClaseSolicitud 
        
        Obtener: 
        - SolicitudCabecera.oidCliente 
        - Acceso.codAcceso 
        - PeriodoCorporativo.codPeriodo 
        - SolicitudPosicion.VAL_PREC_NETO_TOTA_LOCA haciendo una suma de este campo de todos los registros encontrados. 
        - CabeceraMatrizFacturacion.VAL_TIPO_CAMB 
        - SolicitudPosicion.NUM_UNID_ATEN haciendo una suma de este campo de todos los registros encontrados 
            
        
        Agrupando por: codPeriodo, codAcceso, oidCliente, CabeceraMatrizFacturacion.VAL_TIPO_CAMB 
                
        Con los registros obtenidos se crea una lista de objetos DTOVentasGis2 y se retorna. 
        
        DTOVentasGis2.oidCliente= SolicitudCabecera.oidCliente 
        DTOVentasGis2.codAcceso=Acceso.codAcceso 
        DTOVentasGis2.codPeriodo=PeriodoCorporativo.codPeriodo 
        DTOVentasGis2.codAtributo2=ConstantesINT.COD_ATRIBUTO2 
        DTOVentasGis2.valorAtributo2=SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA haciendo una conversión a String de este valor 
        DTOVentasGis2.codAtributo4=ConstantesINT.COD_ATRIBUTO3 
        DTOVentasGis2.valorAtributo4= SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA * CabeceraMatrizFacturacion.VAL_TIPO_CAMB haciendo una conversión a String de este valor 
        DTOVentasGis2.codAtributo7=ConstantesINT.COD_ATRIBUTO7 
        DTOVentasGis2.valorAtributo7= SolicitudPosicion.VAL_PREC_NETO_TOTA_LOCA /num haciendo una conversión a String de este valor 
        DTOVentasGis2.codAtributo8=ConstantesINT.COD_ATRIBUTO8 
        DTOVentasGis2.valorAtributo8= [SolicitudPosicion.VAL_PREC_NETO_TOTA_LOCA / num ] * [CabeceraMatrizFacturacion.VAL_TIPO_CAMB] haciendo una conversión a String de este valor 
        DTOVentasGis2.codAtributo9=ConstantesINT.COD_ATRIBUTO9 
        DTOVentasGis2.valorAtributo9=SolicitudPosicion.NUM_UNID_ATEN haciendo una conversión a String de este valor 
        DTOVentasGis2.codAtributo10=ConstantesINT.COD_ATRIBUTO10 
        DTOVentasGis2.valorAtributo10=num haciendo una conversión a String de este valor 
        
       */
       UtilidadesLog.info("DAOInfCliente.calcularVentas(ArrayList ListaOids, Long OidPeriodo, Integer num): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
        UtilidadesLog.debug("calcularVentas: Entrada");
        
        StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector(); 
        
        consulta.append(" SELECT   PC.cod_peri COD_PERI,  ");
        consulta.append(" ACCESO.cod_acce COD_ACCE, ");
        consulta.append(" SC.clie_oid_clie CLIE_OID_CLIE, ");
        consulta.append(" SUM (SP.val_prec_neto_tota_loca) NETO_TOTA,  ");
        consulta.append(" MFC.val_tipo_camb TIPO_CAMB, ");
        //Incidencia BELC300022766 :Debe realizarse la suma
        consulta.append(" SUM(SP.num_unid_aten ) UNID_ATEN ");
        
        /*Incidencia : BELC300022766 Debe eliminarse de la query el campo
         val_prec_cata_tota_loca pues no es solicitado.*/
       // consulta.append(" SP.VAL_PREC_CATA_TOTA_LOCA CATA_TOTA");
       
        consulta.append(" FROM seg_acces ACCESO, ");
        consulta.append(" seg_perio_corpo PC, ");
        consulta.append(" seg_subac SA, ");
        consulta.append(" cra_perio P, ");
        consulta.append(" ped_solic_cabec SC, ");
        consulta.append(" ped_solic_posic SP, ");
        consulta.append(" ped_clase_solic CS, ");
        consulta.append(" pre_matri_factu_cabec MFC ");
        
        consulta.append(" WHERE ( SC.clie_oid_clie IN ( ?");
        parametros.add((Long)ListaOids.get(0));
        for(int i = 1; i< ListaOids.size() ; i++){
            consulta.append(" , ? ");
            parametros.add((Long)ListaOids.get(i));  
        }
        consulta.append(" ) ");        
        
        
        /// Agregado
        /*consulta.append("( OR SC.clie_oid_clie IN ( ?");
        parametros.add((Long)ListaOids.get(0));
        for(int i = 1; i< ListaOids.size() ; i++){
            consulta.append(" , ? ");
            parametros.add((Long)ListaOids.get(i));  
        }
        consulta.append(" ) ");*/
        
        consulta.append(" AND (CS.IND_ORDE_COMP=1 ) ");
        consulta.append(" AND (SC.IND_TS_NO_CONSO=1 ) ");
        //consulta.append(" AND (SC.FEC_FACT IS null ) ");
        consulta.append(" AND (SC.FEC_FACT IS NOT null ) ");
        consulta.append(" AND (SC.oid_soli_cabe = SP.soca_oid_soli_cabe) ");
        consulta.append(" AND (SP.ESPO_OID_ESTA_POSI <> ? ) ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        consulta.append(" AND (SC.perd_oid_peri= ? ) ");
        parametros.add(OidPeriodo);
        consulta.append(" AND (MFC.perd_oid_peri = ? ) ");
        parametros.add(OidPeriodo);
        
        consulta.append(" AND (SC.perd_oid_peri = P.oid_peri) ");
        consulta.append(" AND (SC.sbac_oid_sbac = SA.oid_sbac) ");
        consulta.append(" AND (SA.acce_oid_acce = ACCESO.oid_acce) ");
        consulta.append(" AND (PC.oid_peri = P.peri_oid_peri) ");
        consulta.append(" AND (SC.clso_oid_clas_soli = CS.oid_clas_soli) ) ");
        
        /*consulta.append(" AND (ACCESO.oid_acce = SA.acce_oid_acce) ");
        consulta.append(" AND (ACCESO.oid_acce = P.acce_oid_acce) ");
        consulta.append(" AND (PC.oid_peri = P.peri_oid_peri) ");
        consulta.append(" AND (SA.oid_sbac = SC.sbac_oid_sbac) ");
        consulta.append(" AND (P.oid_peri = SC.perd_oid_peri) ");
        consulta.append(" AND (CS.oid_clas_soli = SC.clso_oid_clas_soli) ");
        consulta.append(" AND (P.oid_peri = MFC.perd_oid_peri) )");*/
        
        consulta.append(" GROUP BY PC.cod_peri, ");
        consulta.append(" ACCESO.cod_acce, ");
        consulta.append(" SC.clie_oid_clie, ");
        consulta.append(" MFC.val_tipo_camb");
       
       // consulta.append(" SP.val_prec_neto_tota_loca ");
       /*Incidencia : BELC300022766 No se debe agrupar por ped_solic_posic.num_unid_aten 
        * consulta.append(" SP.num_unid_aten, ");
       */
       /*Incidencia : BELC300022766 Debe eliminarse de la query el campo val_prec_cata_tota_loca pues no es solicitado.
        * consulta.append(" SP.VAL_PREC_CATA_TOTA_LOCA "); 
        */
        
        this.logSql("calcularVentas",consulta.toString(),parametros);
        try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            UtilidadesLog.error("la consulta de calcularVentas, retorna : " + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("calcularVentas:",e);
			//this.logSql("obtenerLineasReversion",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        ArrayList ListaDTOVentasGis = new ArrayList();
        Long num = null;
		for(int j= 0; j < resultado.getRowCount(); j++){
            DTOVentasGis dtoV = new DTOVentasGis();
            Long oidClien = new Long(((BigDecimal)resultado.getValueAt(j,
                            "CLIE_OID_CLIE")).longValue());
            
            UtilidadesLog.info("listanum" + listanum);
            //Devuelvo los valores del HAshMap
            num = (Long) listanum.get(oidClien);
            
                        
            /*dtoV.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(j,
                            "CLIE_OID_CLIE")).longValue()));*/
            dtoV.setOidCliente(oidClien);
            dtoV.setCodAcceso( resultado.getValueAt(j,"COD_ACCE").toString());
            dtoV.setCodPeriodo(resultado.getValueAt(j,"COD_PERI").toString());
            dtoV.setCodAtributo2(ConstantesINT.COD_ATRIBUTO2.toString());
            /*Incidencia BELC300022766:
              Donde dice:
              DTOVentasGis.valorAtributo2=SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA 
              haciendo una conversión a String de este valor
              DTOVentasGis.codAtributo4=ConstantesINT.COD_ATRIBUTO3
              DTOVentasGis.valorAtributo4= SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA *  
              CabeceraMatrizFacturacion.VAL_TIPO_CAMB  haciendo una conversión a String de este valor”

             Debe decir:
             “DTOVentasGis.valorAtributo2=SolicitudPosicion.VAL_PREC_NETO_TOTA_LOCA 
             haciendo una conversión a String de este valor
             DTOVentasGis.codAtributo3=ConstantesINT.COD_ATRIBUTO3
             DTOVentasGis.valorAtributo3= SolicitudPosicion.VAL_PREC_NETO_TOTA_LOCA *  
             CabeceraMatrizFacturacion.VAL_TIPO_CAMB  haciendo una conversión a String de este valor”
             * */
            dtoV.setValorAtributo2(resultado.getValueAt(j,"NETO_TOTA").toString());
           
            /*Incidencia DBLG400000990 */
            dtoV.setCodAtributo3(ConstantesINT.COD_ATRIBUTO3 );
            
            //@ssaavedr 29/08/2005, este valor estaba siendo tratado como Long, maaaaal
            //al poder haber valores decimales, esta mal!          
            //float lNetoTota1  = 0;
            BigDecimal lNetoTota1;
            lNetoTota1  = ((BigDecimal)resultado.getValueAt(j,"NETO_TOTA"));
            
            //Incidencia DBLG400000990, el valor deja de ser Long y pasa a ser BigDecimal,
            //ya que puede haber decimales.
            //float lTipoCambio = 0;
            BigDecimal lTipoCambio = new BigDecimal(0);
            
            if (resultado.getValueAt(j,"TIPO_CAMB") != null){
                 lTipoCambio = ((BigDecimal)resultado.getValueAt(j,"TIPO_CAMB"));
            }
          
            //float lValorAtt3 = lNetoTota1 / lTipoCambio;
            BigDecimal lValorAtt3 = new BigDecimal(0);
            /*mdolce se agrego que verifique el tipo cambio diferente de 0, si no la division revienta*/            
            if (lTipoCambio != null){  
                if(!lTipoCambio.equals(new BigDecimal(0))){
                   lValorAtt3 = lNetoTota1.divide(lTipoCambio,2,BigDecimal.ROUND_HALF_UP);
                }    
            }
            dtoV.setValorAtributo3( String.valueOf(lValorAtt3));
            
            //En el modelo no se especifica que valor poner en el caso
            //de que el dato NETO_TOTA venga con valor null
            
            //@ssaavedr 29/08/2005, estos valores estaban siendo tratados como Long, maaaaal
            //al poder haber valores decimales, esta mal!

            dtoV.setCodAtributo7(ConstantesINT.COD_ATRIBUTO7.toString());

            //float lNetoTota = 0;
            BigDecimal lNetoTota = new BigDecimal(0);
            
            if(resultado.getValueAt(j,"NETO_TOTA") != null){
                 lNetoTota = ((BigDecimal)resultado.getValueAt(j,"NETO_TOTA"));
            }
            
            //float lAtt7;
            BigDecimal lAtt7 = new BigDecimal(0);
            UtilidadesLog.info("oidClien" + oidClien);
            UtilidadesLog.info("num --- " + num);
            UtilidadesLog.info("lNetoTota --- " + lNetoTota);
            
            BigDecimal divis = new BigDecimal(num.toString());
            
            if (num != null && num.longValue() != 0)
                         //lAtt7 = lNetoTota / num.longValue();                                               
                         lAtt7 = lNetoTota.divide(divis,2,BigDecimal.ROUND_HALF_UP);
                         
            else{            
                  num = new Long(0);
                  //lAtt7 = 0;
            }             
                         
            UtilidadesLog.debug("lAtt7 +++ " + lAtt7);
            dtoV.setValorAtributo7(String.valueOf(lAtt7));
            
            UtilidadesLog.debug(" Seteamos dtov con lAtt7   " );
            BigDecimal lAtt8 = new BigDecimal(0);
            if (lTipoCambio != null) {
               if(!lTipoCambio.equals(new BigDecimal(0))){
                  lAtt8 = lAtt7.divide(lTipoCambio,2,BigDecimal.ROUND_HALF_UP);
               }
            }   
            //float lAtt8 = (lAtt7 / lTipoCambio);
            
            //DecimalFormat df = new DecimalFormat("0.00");
            //Double lAtt8B = new Double(lAtt8);
            
            UtilidadesLog.debug("Tipo cambio : " + lTipoCambio);
            UtilidadesLog.debug(" ---- Tipo atributo 8 : " + lAtt8);
            
            dtoV.setCodAtributo8(ConstantesINT.COD_ATRIBUTO8.toString());
            
            UtilidadesLog.debug(" Seteamos dto con codigo atributo  8 " );
            
            dtoV.setValorAtributo8( String.valueOf(lAtt8));
            //dtoV.setValorAtributo8( df.format(lAtt8B));
            
            UtilidadesLog.debug(" Seteamos dto con valor lAtt8  " +String.valueOf(lAtt8));
            
            dtoV.setCodAtributo9(ConstantesINT.COD_ATRIBUTO9.toString());
            
            UtilidadesLog.debug(" Seteamos dto con codigo atributo 9 : " +ConstantesINT.COD_ATRIBUTO9.toString());
          
            if (resultado.getValueAt(j,"UNID_ATEN") != null){
                      UtilidadesLog.debug(" Unid aten NO es null");
                      dtoV.setValorAtributo9(resultado.getValueAt(j,"UNID_ATEN").toString());
                      UtilidadesLog.debug(" Unid aten : " + resultado.getValueAt(j,"UNID_ATEN").toString() );
            }
            UtilidadesLog.debug("antes de setear  codigo atributo 10 " );
            dtoV.setCodAtributo10(ConstantesINT.COD_ATRIBUTO10);
            
            UtilidadesLog.debug("seteamos  codigo atributo 10 " );
            dtoV.setValorAtributo10(num.toString());
            
            UtilidadesLog.debug("Seateamos valor  atributo 10 " +num );
            ListaDTOVentasGis.add(dtoV);
            UtilidadesLog.debug("agregamos dtov a la lista " );
        }
        
        UtilidadesLog.debug("calcularVentas: Salida + " + ListaDTOVentasGis);
        UtilidadesLog.info("DAOInfCliente.calcularVentas(ArrayList ListaOids, Long OidPeriodo, Integer num): Salida");
        return ListaDTOVentasGis;
  }
  
  
   /**
   *@Author: Cargain, 17/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return ArrayList
   *@param Long oidPais
   *@param Long oidMarca
   *@param Long oidCanal
   */
  /**obtenerDatosCliente (DTOE.oidMarca; DTOE.oidMarca; DTOE.oidCanal Long)*/
   public ArrayList obtenerDatosCliente(Long oidPais, Long oidMarca, Long oidCanal) throws MareException {
  /*
   * //Se quiere obtener los cliente del pais seleccionado y sus datos de 
   * zonificacion (el primer registro que se encuentre) 

        Acceder a las entidades , MAE Cliente, MAE ClientesUnidadesAdministrativas , 
        ZON TerritorioAdministrativo, SEG Canal , SEG Marca, ZON Seccion , ZON Territorio , 
        ZON Region, ZON Subgerencia de Ventas , ZON Zona , SEG Pais, haciendo un join entre ellas. 
        
        Filtrar por: 
        TerritorioAdministrativo.oidpais=DTOE.pais 
        TerritorioAdministrativol.oidCanal=DTOE.oidCanal 
        TerritorioAdministrativo.oidMarca=DTOE.oidMarca 
        ClientesUnidadesAdministrativas.IND_ACTI=1 
        
        Los de las join: - Cliente con ClientesUnidadesAdministrativas 
        - ClientesUnidadesAdministrativas con TerritorioAdministrativo 
        - TerritorioAdministrativo con Canal 
        - TerritorioAdministrativo con Marca 
        - TerritorioAdministrativo con Seccion 
        - Seccion con Zona 
        - Zona con Region 
        - Region con Subgerencia de ventas 
        - Territorio con TerritorioAdministrativo 
                
        obtener, el primer registro que se encuentre para dicho cliente: 
        Cliente.oidCliente 
        Cliente.codCliente 
        Marca.codMarca 
        Canal.codCanal 
        Pais.codPais 
        Subgerencia de VentasI.codSubgerenciaVentas 
        Region.codRegion 
        Zona.codZona 
        Seccion.codSeccion 
        Territorio.codTerritorio 
        
        Con los registros obtenidos se crea una lista de objetos DTOInfoCliente y se retorna. 
        DTOInfoCliente.oidCliente=Cliente.oid 
        DTOInfoCliente.codMarca= Marca.codMarca 
        DTOInfoCliente.codCanal=Canal.codCanal 
        DTOInfoCliente.codPais=Pais.codPais 
        DTOInfoCliente.codAcceso=Acceso.codAcceso 
        DTOInfoCliente.codSGV=SubgerenciaVentas.codSubgerenciaVentas 
        DTOInfoCliente.codRegion=Region.codRegion 
        DTOInfoCliente.codZona=Zona.codZona 
        DTOInfoCliente.codSeccion=Seccion.codSeccion 
        DTOInfoCliente.codTerritorio=Territorio.codTerritorio 
        DTOInfoCliente.codCliente=Cliente.codCliente 
        DTOInfoCliente.codPeriodo=Periodo.codPeriodo 

   * 
   * 
  */
        UtilidadesLog.info("DAOInfCliente.obtenerDatosCliente(Long oidPais, Long oidMarca, Long oidCanal): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
        
        UtilidadesLog.debug("obtenerDatosCliente: Entrada");
        
        StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
        
        consulta.append("SELECT CL.oid_clie OID_CLIE,  ");
        consulta.append("CL.cod_clie COD_CLIE,  ");
        consulta.append("MA.cod_marc COD_MARC, ");
        consulta.append("CA.cod_cana COD_CANA,  ");
        consulta.append("PA.cod_pais COD_PAIS, ");
        consulta.append("GV.cod_subg_vent COD_SUBG,  ");
        consulta.append("RE.cod_regi COD_REGI, ");
        consulta.append("ZO.cod_zona COD_ZONA,  ");
        consulta.append("SE.cod_secc COD_SECC,  ");
        consulta.append("TE.cod_terr COD_TERR ");
        consulta.append("FROM mae_clien CL, ");
        consulta.append("mae_clien_unida_admin UA, ");
        consulta.append("zon_terri_admin TA, ");
        consulta.append("seg_canal CA, ");
        consulta.append("seg_marca MA, ");
        consulta.append("zon_regio RE, ");
        consulta.append("zon_secci SE, ");
        consulta.append("zon_sub_geren_venta GV, ");
        consulta.append("zon_terri TE, ");
        consulta.append("zon_zona ZO, ");
        consulta.append("seg_pais PA ");
        consulta.append("WHERE (  ");
        
        consulta.append("(TA.pais_oid_pais = ? ) ");
        parametros.add(oidPais);
        consulta.append("AND (TA.cana_oid_cana = ? )  ");
        parametros.add(oidCanal);
        consulta.append("AND (TA.marc_oid_marc = ?)  ");
        parametros.add(oidMarca);
        consulta.append("AND (UA.IND_ACTI = 1) ");
        
        
        consulta.append("AND (CL.oid_clie = UA.clie_oid_clie) ");
        consulta.append("AND (UA.ztad_oid_terr_admi = TA.oid_terr_admi ) ");
        consulta.append("AND (TA.cana_oid_cana = CA.oid_cana) ");
        consulta.append("AND (TA.marc_oid_marc = MA.oid_marc) ");
        consulta.append("AND (TA.zscc_oid_secc = SE.oid_secc) ");	
        consulta.append("AND (SE.zzon_oid_zona = ZO.oid_zona) ");
        consulta.append("AND (ZO.zorg_oid_regi = RE.oid_regi) ");			
        consulta.append("AND (RE.zsgv_oid_subg_vent = GV.oid_subg_vent) ");
        consulta.append("AND (TE.oid_terr = TA.terr_oid_terr) ");
        consulta.append("AND (PA.oid_pais = TA.pais_oid_pais) )");
        
        
      //  this.logSql("obtenerDatosCliente",consulta.toString(),parametros);
        try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerDatosCliente:",e);
			//this.logSql("obtenerLineasReversion",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        ArrayList ListaDTOInfoCliente = new ArrayList();
		
    for(int j= 0; j < resultado.getRowCount(); j++){
            DTOInfoCliente dtoI = new DTOInfoCliente();
            
            
            dtoI.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(j,
                            "OID_CLIE")).longValue()));
            dtoI.setCodMarca(resultado.getValueAt(j,"COD_MARC").toString());
            dtoI.setCodCanal(resultado.getValueAt(j,"COD_CANA").toString());
            dtoI.setCodPais(resultado.getValueAt(j,"COD_PAIS").toString());
            //*DTOInfoCliente.codAcceso=Acceso.codAcceso   INCIDENCIA 13462
            dtoI.setCodSGV(resultado.getValueAt(j,"COD_SUBG").toString());
            dtoI.setCodRegion(resultado.getValueAt(j,"COD_REGI").toString());
            dtoI.setCodZona(resultado.getValueAt(j,"COD_ZONA").toString());
            dtoI.setCodSeccion(resultado.getValueAt(j,"COD_SECC").toString());
            dtoI.setCodTerritorio(resultado.getValueAt(j,"COD_TERR").toString());
            dtoI.setCodCliente(resultado.getValueAt(j,"COD_CLIE").toString());
            
            ListaDTOInfoCliente.add(dtoI);
            
        }        
        
        UtilidadesLog.info("DAOInfCliente.obtenerDatosCliente(Long oidPais, Long oidMarca, Long oidCanal): Salida");
        return ListaDTOInfoCliente;
   }
   
  /**
   *@Author: ssantana, 17/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return ArrayList
   *@param Long oidPeriodo
   *@param ArrayList listaOids
   * 
   *31/08/2005 - ssaavedr -Se modifica consulta en virtud de charla con JF, dado que a la misma le
   *                       falta filtrar por el estado de las posiciones (<>ESTADO_POSICION_ANULADO)
   *                       y aparte ped_solic_cabec.fec_fact debe ser <> de NULL
   */                       
  public ArrayList calcularMontoAnulaciones(ArrayList listaOids, Long oidPeriodo) throws MareException {
  /*
  //Se quiere calcular el monto total de la anulacion de la entidad solicitudPosicion de PED, la suma del campo precioCatalogoTotalLocal de los registros obtenidos. Para ello: 
    
    Acceder a las entidades Acceso (SEG), SubAcceso (SEG), Periodo (CRA), PeriodoCorporativo (SEG), SolicitudCabecera (PED), SolicitudPosicion (PED), TipoSolicitudPais (PED), TipoSolicitud (PED), haciendo join entre ellas 
    filtrando por: 
    SolicitudCabecera.oidCliente IN ListaOids //Se deben tomar todos aquellos registros cuyos oidCliente vengan en la ListaCliente 
    TipoSolicitud.IND_ANUL=1 
    SolicitudCabecera.IND_TS_NO_CONSO=1 
    SolicitudCabecera.FEC_FACT=null 
    SolicitudCabecera.oidPeriodo=DTOE.oidPeriodo 
    
    Los de las join: SolicitudCabecera con Periodo 
    SolicitudCabecera con SubAcceso 
    SubAcceso con Acceso 
    Periodo con PeriodoCorporativo 
    SolicitudCabecera con SolicitudPosicion 
    SolicitudCabecera con TipoSolicitudPais 
    TipoSolicitudPais con TipoSolicitud 
    
    Obtener: 
    - SolicitudCabecera.oidCliente 
    - Acceso.codAcceso 
    - PeriodoCorporativo.codPeriodo 
    - SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA haciendo una suma de este campo de todos los registros encontrados. 
    
    
    Agrupando por: codPeriodo, codAcceso, oidCliente 
    
    
    Con los registros obtenidos se crea una lista de objetos DTOAtributo y se retorna. 
    DTOAtributo.oidAtributo=SolicitudCabecera.oidCliente 
    DTOAtributo.codAcceso=Acceso.codAcceso 
    DTOAtributo.codPeriodo=PeriodoCorporativo.codPeriodo 
    DTOAtributo.codAtributo=ConstantesINT.COD_ATRIBUTO1 
    DTOAtributo.valorAtributo=SolicitudPosicion.VAL_PREC_CATA_TOTA_LOCA haciendo una conversión a String de este valor 
    
    */ 
   UtilidadesLog.info("DAOInfCliente.calcularMontoAnulaciones(ArrayList listaOids, Long oidPeriodo): Entrada");
   StringBuffer sqlSelect = new StringBuffer("");
   StringBuffer sqlFrom = new StringBuffer("");
   StringBuffer sqlWhere = new StringBuffer("");
   StringBuffer sqlGroupBy = new StringBuffer("");
   String query = null;
   RecordSet r = null;
   ArrayList aRetorno = new ArrayList();
   String cadenaOids = null;
   
   
   // ------------------------------- SELECT  --------------------------------------------
   sqlSelect.append(" SELECT   ped_solic_cabec.clie_oid_clie, seg_acces.cod_acce, ");
   sqlSelect.append(" seg_perio_corpo.cod_peri, ");
   //jrivas 24/2/2006 DBLG400000990
   //sqlSelect.append(" SUM (ped_solic_posic.val_prec_cata_tota_loca) ");
   sqlSelect.append(" SUM (ped_solic_posic.VAL_PREC_NETO_TOTA_LOCA) ");
   
   // ------------------------------- FROM  --------------------------------------------
   sqlFrom.append(" FROM seg_acces, ");
   sqlFrom.append(" seg_subac, ");
   sqlFrom.append(" cra_perio, ");
   sqlFrom.append(" seg_perio_corpo, ");
   sqlFrom.append(" ped_solic_cabec, ");
   sqlFrom.append(" ped_solic_posic, ");
   sqlFrom.append(" ped_tipo_solic_pais, ");
   sqlFrom.append(" ped_tipo_solic ");

   cadenaOids = this.armaArrayOidClientes(listaOids);
   
   // ------------------------------- WHERE  --------------------------------------------
   sqlWhere.append(" WHERE ped_tipo_solic.ind_anul = 1 ");

   if ( !cadenaOids.equals("") )
     sqlWhere.append(" AND ped_solic_cabec.clie_oid_clie IN " + cadenaOids);
     
   sqlWhere.append(" AND ped_solic_cabec.ind_ts_no_conso = 1 ");
   //sqlWhere.append(" AND ped_solic_cabec.fec_fact IS NULL ");
   sqlWhere.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
   sqlWhere.append(" AND ped_solic_cabec.perd_oid_peri = " + oidPeriodo);
   
   sqlWhere.append(" AND ped_solic_cabec.perd_oid_peri = cra_perio.oid_peri ");
   sqlWhere.append(" AND ped_solic_cabec.sbac_oid_sbac = seg_subac.oid_sbac ");
   sqlWhere.append(" AND seg_subac.acce_oid_acce = seg_acces.oid_acce ");
   sqlWhere.append(" AND cra_perio.peri_oid_peri = seg_perio_corpo.oid_peri ");
   sqlWhere.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
   sqlWhere.append(" AND ped_solic_posic.ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO.longValue());   
   sqlWhere.append(" AND ped_solic_cabec.tspa_oid_tipo_soli_pais = ped_tipo_solic_pais.oid_tipo_soli_pais ");
   sqlWhere.append(" AND ped_tipo_solic_pais.tsol_oid_tipo_soli = ped_tipo_solic.oid_tipo_soli ");
   sqlGroupBy.append(" GROUP BY ped_solic_cabec.clie_oid_clie, ");
   sqlGroupBy.append(" seg_acces.cod_acce, ");
   sqlGroupBy.append(" seg_perio_corpo.cod_peri ");
   
   query = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString() + sqlGroupBy.toString();
    
   BelcorpService bs = BelcorpService.getInstance();
   
   // Ejecutamos la consulta
   try {
    r = bs.dbService.executeStaticQuery(query);
   } catch (Exception ex)
   {
     UtilidadesLog.error(ex);
     String codigosError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
     throw new MareException(ex,  UtilidadesError.armarCodigoError(codigosError) );
   }
   
   // Armamos el ARrayList de Retorno 
    if ( !r.esVacio() )
   {
      for ( int i = 0; i < r.getRowCount(); i++)
      {
        
        DTOAtributo dtoAtributo = new DTOAtributo();
        BigDecimal bigOidCliente = (BigDecimal) r.getValueAt(i, 0);
        BigDecimal bigValorAtributo = (BigDecimal) r.getValueAt(i, 3);
        Long oidCliente = new Long( bigOidCliente.longValue());
        String codAcceso = (String) r.getValueAt(i, 1); 
        String codPeriodo = (String) r.getValueAt(i, 2);
       // 2006.03.13  Se modifica el valor del código de ConstantesINT.COD_ATRIBUTO1 
       //a ConstantesINT.COD_ATRIBUTO4 (BELC300022766)

        String codAtributo = ConstantesINT.COD_ATRIBUTO4;
        String valorAtributo = bigValorAtributo.toString();
        
        dtoAtributo.setOidCliente(oidCliente);
        dtoAtributo.setCodAcceso(codAcceso);
        dtoAtributo.setCodPeriodo(codPeriodo);
        dtoAtributo.setCodAtributo(codAtributo);
        dtoAtributo.setValorAtributo(valorAtributo);
        
        aRetorno.add(dtoAtributo); 
      }
   }
   
   UtilidadesLog.info("DAOInfCliente.calcularMontoAnulaciones(ArrayList listaOids, Long oidPeriodo): Salida");
   return aRetorno;
  
  }

    /**
   *@Author: Cargain, 17/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return ArrayList
   *@param ArrayList ListaOids
   *@param Long oidMarca
   * 
   *31/08/2005 - ssaavedr -Se modifica consulta en virtud de charla con JF, dado que 
   *                       ped_solic_cabec.fec_fact debe ser <> de NULL* 
   *                       Por otro lado existen filtros de sobra, que no estan el modelo:
   *                       consulta.append(" AND (Acceso.oid_acce = P.acce_oid_acce) ");
   */                      
  /**calcularFlete (ListaOids; Long : DTOE.oidPeriodo ArrayList),  */ 
  public ArrayList calcularFlete(ArrayList ListaOids, Long oidPeriodo) throws MareException {
  /*
   * //Se quiere calcular la suma del flete de la entidad solicitudPosicion de PED. Para ello: 

      Acceder a las entidades Acceso (SEG), SubAcceso (SEG), Periodo (CRA), 
      PeriodoCorporativo (SEG) y SolicitudCabecera (PED) haciendo join entre ellas 
      
      filtrando por: 
      SolicitudCabecera.oidCliente IN ListaOids //Se deben tomar todos aquellos registros cuyos oidCliente vengan en la ListaCliente que recibe este método 
      SolicitudCabecera.IND_TS_NO_CONSO=0 
      SolicitudCabecera.FEC_FACT=null 
      SolicitudCabecera.oidPeriodo=DTOE.oidPeriodo 
      
      Los de las join: SolicitudCabecera con Periodo 
      SolicitudCabecera con SubAcceso 
      SubAcceso con Acceso 
      Periodo con PeriodoCorporativo 
      
      Obtener: 
      - SolicitudCabecera.oidCliente 
      - Acceso.codAcceso 
      - PeriodoCorporativo.codPeriodo 
      - SolicitudCabecera.VAL_IMPO_FLET_TOTA_LOCA haciendo una suma de este campo de todos los registros encontrados. 
      
      
      Agrupando por: codPeriodo, codAcceso, oidCliente 
      
      
      Con los registros obtenidos se crea una lista de objetos DTOAtributo y se retorna. 
      DTOAtributo.oidCliente=SolicitudCabecera.oidCliente 
      DTOAtributo.codAcceso=Acceso.codAcceso 
      DTOAtributo.codPeriodo=PeriodoCorporativo.codPeriodo 
      DTOAtributo.codAtributo=ConstantesINT.COD_ATRIBUTO5 
      DTOAtributo.valorAtributo=SolicitudPosicion.VAL_IMPO_FLET_TOTA_LOCA haciendo una conversión a String de este valor 
  
   * 
  */
        UtilidadesLog.info("DAOInfCliente.calcularFlete(ArrayList ListaOids, Long oidPeriodo): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
        
        UtilidadesLog.debug("calcularFlete: Entrada");
        
        StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector(); 
        
        consulta.append(" SELECT   SC.clie_oid_clie CLIE_OID_CLIE, ");
        consulta.append(" Acceso.cod_acce COD_ACCE,");
        consulta.append(" PC.cod_peri COD_PERI, ");
        //SUM(sc.val_impo_flet_tota_loca) tota_loca
        consulta.append(" SUM(SC.val_impo_flet_tota_loca) TOTA_LOCA");
        
        //Incidencia DBLG400000992 pzerbino 14/03/2006
        //consulta.append(" SC.val_impo_flet_tota_loca TOTA_LOCA");
        consulta.append(" FROM seg_acces Acceso, ");
        consulta.append(" seg_perio_corpo PC, ");
        consulta.append(" seg_subac SA, ");
        consulta.append(" cra_perio P, ");
        consulta.append(" ped_solic_cabec SC ");
        
        consulta.append(" WHERE ( SC.clie_oid_clie IN ( ?");
        parametros.add((Long)ListaOids.get(0));
        for(int i = 1; i< ListaOids.size() ; i++){
            consulta.append(" , ? ");
            parametros.add((Long)ListaOids.get(i));  
        }
        consulta.append(" ) ");
        
        ///Agregado
      /*  consulta.append("( OR SC.clie_oid_clie IN ( ?");
        parametros.add((Long)ListaOids.get(0));
        for(int i = 1; i< ListaOids.size() ; i++){
            consulta.append(" , ? ");
            parametros.add((Long)ListaOids.get(i));  
        }
        consulta.append(" ) ");*/
        
        
        consulta.append(" AND (SC.IND_TS_NO_CONSO = 0  )");
        //consulta.append(" AND (SC.FEC_FACT IS null  )");
        consulta.append(" AND (SC.FEC_FACT IS NOT null  )");
        consulta.append(" AND (SC.PERD_OID_PERI = ? )");
        parametros.add(oidPeriodo);
        
        consulta.append(" AND (SC.perd_oid_peri = P.oid_peri) ");
        consulta.append(" AND (SC.sbac_oid_sbac = SA.oid_sbac) ");
        consulta.append(" AND (SA.acce_oid_acce = Acceso.oid_acce) ");
        consulta.append(" AND (P.peri_oid_peri = PC.oid_peri) ");
        /*
        consulta.append(" AND (Acceso.oid_acce = SA.acce_oid_acce) ");
        consulta.append(" AND (Acceso.oid_acce = P.acce_oid_acce) ");
        consulta.append(" AND (PC.oid_peri = P.peri_oid_peri) ");
        consulta.append(" AND (SA.oid_sbac = SC.sbac_oid_sbac) ");
        consulta.append(" AND (P.oid_peri = SC.perd_oid_peri) ");
        */
        
        consulta.append(" ) ");
        consulta.append(" GROUP BY PC.cod_peri, ");
        consulta.append(" Acceso.cod_acce, ");
        consulta.append(" SC.clie_oid_clie ");
        //Incidencia DBLG400000992 pzerbino 14/03/2006
        //consulta.append(" SC.val_impo_flet_tota_loca "); 
        
      //  this.logSql("calcularFlete",consulta.toString(),parametros);
        
        try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("calcularFlete:",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        ArrayList ListaDTOAtributo = new ArrayList();
		for(int j= 0; j < resultado.getRowCount(); j++){
            DTOAtributo dtoA = new DTOAtributo();
            
            dtoA.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(j,
                            "CLIE_OID_CLIE")).longValue()));
            dtoA.setCodAcceso( resultado.getValueAt(j,"COD_ACCE").toString());
            dtoA.setCodPeriodo(resultado.getValueAt(j,"COD_PERI").toString());
            dtoA.setCodAtributo(ConstantesINT.COD_ATRIBUTO5); 
                       
            if(resultado.getValueAt(j,"TOTA_LOCA") != null){
                  dtoA.setValorAtributo(resultado.getValueAt(j,"TOTA_LOCA").toString());
            }
          
            ListaDTOAtributo.add(dtoA);
        }
        UtilidadesLog.debug("query, retorna: " + resultado);
        UtilidadesLog.info("DAOInfCliente.calcularFlete(ArrayList ListaOids, Long oidPeriodo): Salida");
        return ListaDTOAtributo;
  }

  
  
  /** Incidencia BELC300013399 */
 /* public Date obtenerFechaFinPeriodo(Long oidCliente, Long oidPeriodo) throws MareException { 
  
  //Recibe una lista de oid de clientes, y el oidPeriodo 

        Acceder a las entidades Periodo (CRA), PeriodoCorporativo (SEG) y SolicitudCabecera (PED) haciendo una join entre ellas 
        Filtrando por: 
        SolicitudCabecera.oidCliente IN ListaOids //Se deben tomar todos aquellos registros cuyos oidCliente vengan en la ListaCliente 
        SolicitudCabecera.oidPeriodo=oidPeriodo //recibido 
        SolicitudCabecera.oidPeriodo=Periodo.oid // join entre las tablas 
        Periodo.oidPeriodo= PeriodoCorporativo.oid //join entre las tablas 
        
        Obtener: 
        SolicitudCabecera.oidCliente 
        Periodo.FEC_FINA 
        PeriodoCorporativo.codPeriodo 
        
        Agrupando por: oidCliente, codPeriodo 
        
        Con los registros obtenidos se crea una lista de objetos DTOClienteFechaFinPeriodo y se retorna. 
        DTOClienteFechaFinPeriodo.oidCliente=SolicitudCabecera.oidCliente 
        DTOClienteFechaFinPeriodo.fechaHasta=Periodo.FEC_FINA 
        DTOClienteFechaFinPeriodo.codPeriodo=PeriodoCorporativo.codPeriodo 
  
  *
  
  return null;
  }*/
  
   /**
   *@Author: ssantana, |7/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return 
   *@param oidPeriodo
   *@param listaOids
   */ 
  public ArrayList completarDatosCliente(ArrayList listaOids, Long oidPeriodo) throws MareException {
  /*
   * Documentation
    //Recibe una lista de oids de clientes y un oidPeriodo 
    //Se trata de completar los datos de los clientes, para ello: 
    
    Acceder a la entidad ClientesDatosAdicionales (MAE), TipoNivelSocioEconomicoPersonal (MAE) y EstatusCliente (MAE), Periodo (CRA), PeriodoCorporativo (SEG) haciendo una join entre ellas 
    filtrando por: 
    ClientesDatosAdicionales.oidCliente IN ListaOids //Se deben tomar todos aquellos registros cuyos oidCliente vengan en la ListaCliente que recibe este método 
    Periodo.oid=oidPeriodo 
    y los de las join: ClientesDatosAdicionales con TipoNivelSocioEconomicoPersonal 
    ClientesDatosAdicionales con EstatusCliente 
    PeriodoCorporativo con Periodo 
    
    Obtener: 
    ClientesDatosAdicionales.oidCliente 
    TipoNivelSocioEconomicoPersonal.codNSE 
    EstatusCliente.codEstatusCliente 
    PeriodoCorporativo.codPeriodo 
    
    Con los registros obtenidos se crea una lista de objetos DTODatosAdicionales y se retorna. 
    DTODatosAdicionales.oidCliente=ClientesDatosAdicionales.oidCliente 
    DTODatosAdicionales.codPeriodo=PeriodoCorporativo.codPeriodo 
    DTODatosAdicionales.codAcceso=null 
    DTODatosAdicionales.codAtributo11=ConstantesINT.COD_ATRIBUTO11 
    DTODatosAdicionales.valorAtributo11=TipoNivelSocioEconomicoPersonal.codNSE 
    DTODatosAdicionales.codAtributo12=ConstantesINT.COD_ATRIBUTO12 
    DTODatosAdicionales.valorAtributo12=EstatusCliente.codEstatusCliente 

   * 
   * 
   */
   UtilidadesLog.info("DAOInfCliente.completarDatosCliente(ArrayList listaOids, Long oidPeriodo): Entrada");
   StringBuffer sqlSelect = new StringBuffer("");
   StringBuffer sqlFrom = new StringBuffer("");
   StringBuffer sqlWhere = new StringBuffer("");
   RecordSet r = null;
   String cadenaOids = null;
   String query = null;
   ArrayList aRetorno = new ArrayList();
  
   // ---------------------------------- SELECT -------------------------------------------
   sqlSelect.append(" SELECT mae_clien_datos_adici.clie_oid_clie, ");
   sqlSelect.append(" mae_tipo_nivel_socec_perso.cod_nsep, ");
   sqlSelect.append(" mae_tipo_estat_clien.cod_tipo_esta, seg_perio_corpo.cod_peri ");

   // ---------------------------------- FROM -------------------------------------------
   sqlFrom.append(" FROM mae_clien_datos_adici, ");
   sqlFrom.append(" mae_tipo_nivel_socec_perso, ");
   sqlFrom.append(" mae_tipo_estat_clien, ");
   sqlFrom.append(" cra_perio, "); 
   sqlFrom.append(" seg_perio_corpo "); 
   
   // ---------------------------------- WHERE -------------------------------------------
   cadenaOids = this.armaArrayOidClientes(listaOids);

   sqlWhere.append(" WHERE cra_perio.oid_peri = " + oidPeriodo );
   if (!cadenaOids.equals(""));
     sqlWhere.append(" AND mae_clien_datos_adici.clie_oid_clie IN " + cadenaOids); 

   sqlWhere.append(" AND mae_clien_datos_adici.nsep_oid_nsep = mae_tipo_nivel_socec_perso.oid_nsep(+) ");
   sqlWhere.append(" AND mae_clien_datos_adici.esta_oid_esta_clie = mae_tipo_estat_clien.oid_tipo_esta(+)");
   sqlWhere.append(" AND cra_perio.peri_oid_peri = seg_perio_corpo.oid_peri ");
   
   // ------------------- Armamos la query ---------------------------
   query = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString();
    
   BelcorpService bs = BelcorpService.getInstance();
   
   // ----------- Ejecutamos la consulta -----------------------------
   try {
       r = bs.dbService.executeStaticQuery(query);
   } catch (Exception ex) {
       String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
   }
   
   if (!r.esVacio())
   {
     for (int i = 0; i < r.getRowCount(); i++)
     {
        DTODatosAdicionales dtoDatosAdicionales = new DTODatosAdicionales();
        
        BigDecimal bigOidCliente = (BigDecimal) r.getValueAt(i, 0);
        String codigoNSE = (String) r.getValueAt(i, 1);
        String codEstatusCliente = (String) r.getValueAt(i, 2);        
        String codPeriodo = (String) r.getValueAt(i, 3);
        
        
        dtoDatosAdicionales.setOidCliente(new Long(bigOidCliente.longValue()));
        dtoDatosAdicionales.setCodPeriodo(codPeriodo);
        dtoDatosAdicionales.setCodAcceso(null);
        dtoDatosAdicionales.setCodAtributo11(ConstantesINT.COD_ATRIBUTO11);
        dtoDatosAdicionales.setValorAtributo11(codigoNSE);
        dtoDatosAdicionales.setCodAtributo12(ConstantesINT.COD_ATRIBUTO12);
        dtoDatosAdicionales.setValorAtributo12(codEstatusCliente);
        
        aRetorno.add(dtoDatosAdicionales);
        
     }
   }
   
   UtilidadesLog.info("DAOInfCliente.completarDatosCliente(ArrayList listaOids, Long oidPeriodo): Salida");
   return aRetorno;
   
  }
  
  /**
   *@Author: ssantana, 17/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return 
   *@param oidPeriodo
   *@param listaOids
   *31/08/2005 - ssaavedr -Se modifica consulta en virtud de charla con JF, dado que 
   *                       ped_solic_cabec.fec_fact debe ser <> de NULL
   *                       y el estado de la posicion deber ser <> de anulado
   */ 
  /*public Integer obtenerNumCabLeidas(ArrayList listaOids, Long oidPeriodo) throws MareException 
  {*/
  /*
   * Vamos a obtener el número de registros de la entidad SolicitudCabecera sobre
   * el que en el método calcularVentas vamos a calcular las ventas 
        Acceder a las entidades Acceso (SEG), SubAcceso (SEG), Periodo (CRA), 
        PeriodoCorporativo (SEG) , SolicitudCabecera (PED), SolicitudPosicion (PED), 
        ClaseSolicitud (PED), CabeceraMatrizFacturacion (PRE) haciendo join entre
        ellas filtrando por: 
        SolicitudCabecera.oidCliente IN ListaOids 
        //Se deben tomar todos aquellos registros cuyos oidCliente vengan en la 
        ListaCliente 
        ClaseSolicitud.IND_ORDE_COMP=1 
        SolicitudCabecera.IND_TS_NO_CONSO=1 
        SolicitudCabecera.FEC_FACT=null 
        SolicitudPosicion.oidEstadoPosicion=ConstantesPED.ESTADO_POSICION_ANULADO 
        SolicitudCabecera.oidPeriodo=DTOE.oidPeriodo 
        CabeceraMatrizFacturacion.oidPeriodo=DTOE.oidPeriodo 
        
        Los de las join: SolicitudCabecera con Periodo 
        SolicitudCabecera con SubAcceso 
        SubAcceso con Acceso 
        PeriodoCorporativo con Periodo 
        SolicitudCabecera con SolicitudPosicion 
        SolicitudCabecera con ClaseSolicitud 
        
        Obtener: 
        - COUNT(*) //Contar el número de registros de la entidad SolicitudCabecera 
        que procesamos 
        
        
        Se devuelve este valor obtenido

   * 
   */
   /*
   UtilidadesLog.info("DAOInfCliente.obtenerNumCabLeidas(ArrayList listaOids, Long oidPeriodo): Entrada");
   StringBuffer sqlSelect = new StringBuffer("");
   StringBuffer sqlFrom = new StringBuffer("");
   StringBuffer sqlWhere = new StringBuffer("");
   String query = null;
   String cadenaOids = null;
   RecordSet r = null;
   
   // --------------------------------- SELECT ---------------------------------------
   sqlSelect.append(" SELECT count(*) ");
   
   // --------------------------------- FROM ---------------------------------------
   sqlFrom.append(" FROM seg_acces, ");
   sqlFrom.append(" seg_subac, ");
   sqlFrom.append(" cra_perio, ");
   sqlFrom.append(" seg_perio_corpo, ");
   sqlFrom.append(" ped_solic_cabec, ");
   sqlFrom.append(" ped_solic_posic, ");
   sqlFrom.append(" ped_clase_solic, ");
   sqlFrom.append(" pre_matri_factu_cabec ");
   
   // --------------------------------- WHERE ---------------------------------------
   cadenaOids = this.armaArrayOidClientes(listaOids);   
   sqlWhere.append(" WHERE ped_clase_solic.ind_orde_comp = 1 ");
   
   if ( !cadenaOids.equals("") )
      sqlWhere.append(" AND ped_solic_cabec.clie_oid_clie IN " + cadenaOids);

   sqlWhere.append(" AND ped_solic_cabec.ind_ts_no_conso = 1 ");
  
   sqlWhere.append(" AND ped_solic_cabec.fec_fact IS NOT NULL "); 
   sqlWhere.append(" AND ped_solic_posic.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO.longValue() );
   sqlWhere.append(" AND ped_solic_cabec.perd_oid_peri = " + oidPeriodo);
   sqlWhere.append(" AND pre_matri_factu_cabec.perd_oid_peri = " + oidPeriodo);
   
   sqlWhere.append(" AND ped_solic_cabec.perd_oid_peri = cra_perio.oid_peri ");
   sqlWhere.append(" AND ped_solic_cabec.sbac_oid_sbac = seg_subac.oid_sbac ");
   sqlWhere.append(" AND seg_subac.acce_oid_acce = seg_acces.oid_acce ");
   sqlWhere.append(" AND seg_perio_corpo.oid_peri = cra_perio.peri_oid_peri "); 
   sqlWhere.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.sopo_oid_soli_posi  ");
   sqlWhere.append(" AND ped_solic_cabec.clso_oid_clas_soli = ped_clase_solic.oid_clas_soli ");
   
   query = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString();
   
   // ------------------ Ejecuta la query ---------------------------
   BelcorpService bs = BelcorpService.getInstance();
   
   try {
      r = bs.dbService.executeStaticQuery(query);
   } catch (Exception ex)
   {     
     String codigosError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
     throw new MareException(ex, UtilidadesError.armarCodigoError(codigosError) );
   }
   
   BigDecimal bigCantRegs = (BigDecimal) r.getValueAt(0,0);
   Integer cantRetorno = new Integer(bigCantRegs.intValue());
   UtilidadesLog.info("DAOInfCliente.obtenerNumCabLeidas(ArrayList listaOids, Long oidPeriodo): Salida");
   return cantRetorno; 
  }
  
  */
  /**
   * @Author: ssantana, 16/2/2005
   * @return 
   * @param listaOids
   */
  private String armaArrayOidClientes(ArrayList listaOids) 
  {
    UtilidadesLog.info("DAOInfCliente.armaArrayOidClientes(ArrayList listaOids): Entrada");
    // Arma el StringBuffer de Oids de Clientes para utilizar en la consulta
    // Recibe un ArrayList con objetos Long y devuelve una cadena del tipo
    // ( xxx, yyy, zzz, ... )
    StringBuffer oidClientes = new StringBuffer("");
    if (!listaOids.isEmpty())
    {
      oidClientes.append(" ( ");
      for (int i = 0; i < listaOids.size(); i++)
      {
        if ( i != 0)
          oidClientes.append(", ");
          
        Long nOidCliente = (Long) listaOids.get(i);
        oidClientes.append( nOidCliente.toString() );
      }
      
      oidClientes.append(" ) ");
    } 
    UtilidadesLog.info("DAOInfCliente.armaArrayOidClientes(ArrayList listaOids): Salida");
    return oidClientes.toString();
  }
 
  
  /**
   * @Author: pzerbino, 21/03/2006
   * @return 
   * @param listaOids,OidPeriodo
   * 
   * Modificaciones:
   *  - 23/06/2006 - eiraola - Inc.DBLG400000996: 
   *           Se quita matriz de facturacion.
   *           Se elimina el join con las posiciones.
   */

   public HashMap obtenerNumCabLeidas(ArrayList ListaOids,Long OidPeriodo) throws MareException{
      UtilidadesLog.info("DAOInfCliente.obtenerNumCabLeidas(ArrayList listaOids,Long OidPeriodo): Entrada"); 
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      HashMap tabla = null;
              
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector(); 
            consulta.append(" SELECT   SC.clie_oid_clie CLIE_OID_CLIE, ");
            consulta.append(" COUNT(*) CANTIDAD ");
    
            consulta.append(" FROM seg_acces ACCESO, ");
            consulta.append(" seg_perio_corpo PC, ");
            consulta.append(" seg_subac SA, ");
            consulta.append(" cra_perio P, ");
            consulta.append(" ped_solic_cabec SC, ");
            //consulta.append(" ped_solic_posic SP, ");                         //Eliminado Inc.DBLG400000996
            consulta.append(" ped_clase_solic CS ");
            //consulta.append(" pre_matri_factu_cabec MFC ");                   //Eliminado Inc.DBLG400000996
            
            consulta.append(" WHERE ( SC.clie_oid_clie IN ( ?");
            parametros.add((Long)ListaOids.get(0));
            for(int i = 1; i< ListaOids.size() ; i++){
                consulta.append(" , ? ");
                parametros.add((Long)ListaOids.get(i));  
            }
            consulta.append(" ) ");        
            
            consulta.append(" AND (CS.IND_ORDE_COMP=1 ) ");
            consulta.append(" AND (SC.IND_TS_NO_CONSO=1 ) ");
            consulta.append(" AND (SC.FEC_FACT IS NOT null ) ");
            
            //consulta.append(" AND (SP.ESPO_OID_ESTA_POSI <> ? ) ");           //Eliminado Inc.DBLG400000996
            //parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);            //Eliminado Inc.DBLG400000996
            consulta.append(" AND (SC.perd_oid_peri= ? ) ");
            parametros.add(OidPeriodo);
            //consulta.append(" AND (MFC.perd_oid_peri = ? ) ");                //Eliminado Inc.DBLG400000996
            //parametros.add(OidPeriodo);                                       //Eliminado Inc.DBLG400000996
            
            consulta.append(" AND (SC.perd_oid_peri = P.oid_peri) ");
            consulta.append(" AND (SC.sbac_oid_sbac = SA.oid_sbac) ");
            consulta.append(" AND (SA.acce_oid_acce = ACCESO.oid_acce) ");
            consulta.append(" AND (PC.oid_peri = P.peri_oid_peri) ");
            //consulta.append(" AND (SC.oid_soli_cabe = SP.soca_oid_soli_cabe) ");  //Eliminado Inc.DBLG400000996
            consulta.append(" AND (SC.clso_oid_clas_soli = CS.oid_clas_soli) ) ");
                    
            consulta.append(" GROUP BY sc.clie_oid_clie ");
            consulta.append(" ORDER BY sc.clie_oid_clie ");
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error("obtenerNumCabLeidas:",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    
        tabla = this.armarRecordSet(resultado);                                
        UtilidadesLog.info("DAOInfCliente.obtenerNumCabLeidas(ArrayList listaOids,Long OidPeriodo): Salida"); 
        return tabla;            

   }
    
    /**
    * Metodo de apoyo a la clase que devuelve un hashtable con las filas del Recordset
    * en pares [clave(Colinmname de la tabla),valor(valor de la columna)]
    * no se encuentra definido en el diseño
    * fecha 21/03/06
    * Modificaciones:
    *    - 23/06/2006 - eiraola - Inc.DBLG400000996 Corrección de casteo en HashMap
    */
    private HashMap armarRecordSet(RecordSet rs) {
        UtilidadesLog.info("DAOInfClient.armarRecordSet(RecordSet rs, int i): Entrada ");        
        HashMap tabla = new HashMap();
        Vector columnas = new Vector();
        int cantReg = rs.getRowCount();
        
        Long claveOidCliente;
        Long valorCantCabPed;

        for(int j = 0; j < cantReg; j++) {
            claveOidCliente = new Long( ((BigDecimal) rs.getValueAt(j,"CLIE_OID_CLIE")).longValue() );
            valorCantCabPed = new Long( ((BigDecimal) rs.getValueAt(j,"CANTIDAD")).longValue() );
                
            tabla.put(claveOidCliente, valorCantCabPed);
        }
        UtilidadesLog.info("DAOInfClient.armarRecordSet(RecordSet rs, int i): Salida ");
        return tabla;
    }    
    
    private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.debug(metodo + sql);
        if (params!=null && params.size()>0) {
            String sParams="";
            for (int i=0; i<params.size();i++){
                sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
            }
            UtilidadesLog.debug(metodo + sParams);
        }
    }
    
    
    
  
  
}

