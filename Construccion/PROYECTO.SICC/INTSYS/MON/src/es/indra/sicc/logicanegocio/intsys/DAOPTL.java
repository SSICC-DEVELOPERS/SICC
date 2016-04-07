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

/**
 * Sistema:		Belcorp
 * Modulo:	   	INT 
 * Fecha:		19/01/2007
 * @version		1.0
 * @autor		SPLATASbu
 */
package es.indra.sicc.logicanegocio.intsys;

import es.indra.sicc.util.DTOOIDs;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import java.util.ArrayList;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.math.BigDecimal;
import es.indra.sicc.dtos.intsys.DTOPedidoFacturadoAPicar;
import es.indra.sicc.dtos.ape.DTOAnaquelProductoAEnviar;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;
import es.indra.sicc.dtos.intsys.DTOCompararAsignacionAnaqueles;
import es.indra.sicc.dtos.intsys.DTODiferenciaAsignacion;
import java.util.HashMap;
import es.indra.sicc.util.UtilidadesEJB;
import java.util.Iterator;
import java.util.Collection;
import es.indra.sicc.dtos.intsys.DTODatosEnviarProductosAnaquel;
import java.lang.Math;

public class DAOPTL 
{
    public DAOPTL()
    {
    }
    
    /**
     * @author SPLATAS
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList
     * Descripcion: Se accede a la entidad Lista de picado (cabecera) y (detalle) filtrando por 
     * aquellos registros cuyo valor del atributo Indicador Interface Enviado sea NULL en la 
     * cabecera y como sistema, de detalle, "PTL". Se recuperan los atributos necesarios. 
     * 
     */
    public ArrayList obtenerListasPicadoPTLNoEnviadas() throws MareException {
        UtilidadesLog.info("DAOPTL.obtenerListasPicadoPTLNoEnviadas(): Entrada");
        
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        RecordSet rs = new RecordSet();
        ArrayList pedidosAFacturar = new ArrayList();
        
        try {
            bs = BelcorpService.getInstance();
        
        } catch (MareMiiServiceNotFoundException e) {
            
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT sist.oid_sist_pica  FROM ape_siste_picad sist ");
        query.append(" WHERE sist.cod_sist_pica LIKE '" + ConstantesAPE.COD_PICADO_PTL + "' ");
        
        try {
            rs = bs.dbService.executeStaticQuery( query.toString() );
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if( !rs.esVacio() ){     
            
            String oidPicadoPTL = rs.getValueAt(0,"OID_SIST_PICA").toString();
            UtilidadesLog.debug("   - SAP601: oidPicadoPTL = " + oidPicadoPTL);
            
            StringBuffer query2 = new StringBuffer();
            RecordSet rs2 = new RecordSet();
            
            Long idiomaPorDefecto= RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
            UtilidadesLog.info("*** idiomaPorDefecto = "+idiomaPorDefecto); 
            
            /* BELC400000591 - dmorello, 19/07/2007 */
            //query2.append(" SELECT solcab.val_nume_soli, cab.ind_cheq, prod.cod_sap, prod.des_cort, ");
            query2.append(" SELECT solcab.val_nume_soli, cab.inre_oid_indi_revi, prod.cod_sap, ");
            query2.append(" Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + idiomaPorDefecto.longValue() + ", prod.OID_PROD, 'MAE_PRODU') des_cort, ");
            /* Fin BELC400000591 dmorello 19/07/2007 */
            /* dmorello, 15/08/2007 */
            //query2.append(" det.num_unid_pica, cab.oid_list_pica_cabe, det.oid_list_pica_deta ");
            query2.append(" det.num_unid_prod, cab.oid_list_pica_cabe, det.oid_list_pica_deta ");
            /* Fin dmorello 15/08/2007 */
            query2.append(" FROM ape_lista_picad_cabec cab, ape_lista_picad_detal det, ");
            query2.append(" ped_solic_cabec solcab,mae_produ prod ");
            query2.append(" WHERE cab.ind_inte_envi IS NULL ");
            query2.append(" AND solcab.oid_soli_cabe = cab.soca_oid_soli_cabe ");
            query2.append(" AND cab.oid_list_pica_cabe =  det.lpca_oid_list_pica_cabe ");
            query2.append(" AND det.sipi_oid_sist_pica = " + oidPicadoPTL);
            query2.append(" AND det.prod_oid_prod = prod.oid_prod ");
            /* BELC400000591 - dmorello, 19/07/2007 */
            //query2.append(" ORDER BY solcab.val_nume_soli, cab.ind_cheq ");
            query2.append(" ORDER BY solcab.val_nume_soli, cab.inre_oid_indi_revi NULLS FIRST ");
            /* Fin BELC400000591 dmorello 19/07/2007 */
            
            try {
                rs2 = bs.dbService.executeStaticQuery(query2.toString());    
                
            } catch (Exception ex) {
                
                ex.printStackTrace();
                throw new MareException(ex, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            
            }
            
            if( !rs2.esVacio() ){     

                UtilidadesLog.debug("   - SAP601: rs2 = " + rs2.toString());
                
                int cant = rs2.getRowCount();
                DTOPedidoFacturadoAPicar dto = null;
                
                for(int i = 0; i < cant; i++){
                    dto = new DTOPedidoFacturadoAPicar(); 
                    
                    dto.setNumSolicitud(rs2.getValueAt(i, "VAL_NUME_SOLI").toString());  // solCab.numSolicitud 
                    dto.setCodProd(rs2.getValueAt(i, "COD_SAP").toString()); // prod.codigoSAP                     
                    
                    if( rs2.getValueAt(i, "DES_CORT") != null ){
                        dto.setDescProd(rs2.getValueAt(i, "DES_CORT").toString()); // prod.descripcionCorta 
                    }else{
                        dto.setDescProd(new String(" ")); // prod.descripcionCorta 
                    }
                    UtilidadesLog.debug("   - SAP601: descProd = DES_CORT = " + dto.getDescProd());
        
                    /* dmorello, 15/08/2007 */
                    //if( rs2.getValueAt(i, "NUM_UNID_PICA") != null ){     
                    if( rs2.getValueAt(i, "NUM_UNID_PROD") != null ){
                        //dto.setUnidadesAtendidas(Long.valueOf(rs2.getValueAt(i, "NUM_UNID_PICA").toString())); // det.unidadesPicadas 
                        dto.setUnidadesAtendidas(Long.valueOf(rs2.getValueAt(i, "NUM_UNID_PROD").toString())); // det.unidadesPicadas 
                    /* Fin dmorello 15/08/2007 */
                    } else {
                        dto.setUnidadesAtendidas(new Long(0)); // det.unidadesPicadas 
                    }
                    
                    /* BELC400000591 - dmorello, 19/07/2007 */
                    //if( rs2.getValueAt(i, "IND_CHEQ") != null ){     
                    if( rs2.getValueAt(i, "INRE_OID_INDI_REVI") != null ) {
                    /* Fin BELC400000591 dmorello 19/07/2007 */
                        dto.setIndicadorChequeo(Boolean.TRUE); // cab.indicadorChequeo 
                    } else  {
                        dto.setIndicadorChequeo(Boolean.FALSE); // cab.indicadorChequeo 
                    }
                    
                    dto.setOidListaPicadoCabecera(Long.valueOf(rs2.getValueAt(i, "OID_LIST_PICA_CABE").toString())); // cab.oid 
                    dto.setOidListaPicadoDetalle(Long.valueOf(rs2.getValueAt(i, "OID_LIST_PICA_DETA").toString())); // det.oid 
                    
                    pedidosAFacturar.add(dto); 
                    
                }
                
                UtilidadesLog.debug("   - SAP601: 'pedidosAFacturar' = " + pedidosAFacturar);
                UtilidadesLog.info("DAOPTL.obtenerListasPicadoPTLNoEnviadas(): Salida");    
        
            
            } else {
                UtilidadesLog.debug("   - SAP601: No se encontraron datos RecordSet 2. ");
            }
        
        } else { 
            UtilidadesLog.debug("   - SAP601: No se encontraron datos RecordSet 1. ");
        }
        
        
        return pedidosAFacturar;
    }

    /**
     * @author SPLATAS
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoOids
     * Descripción: Se actualiza el indicador de Interface Enviado = S en los registros 
     * de ListaPicadoCabecera. 
     */
    public void actualizarListasPicadoEnviadas(DTOOIDs dtoOids)throws MareException {
        UtilidadesLog.info("DAOPTL.actualizarListasPicadoEnviadas(DTOOIDs oids): Entrada");
        
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        
        int cant = dtoOids.getOids().length;
        UtilidadesLog.debug("   - SAP601: 'oids' recibidos = " + cant);
        
        if( cant > 0 ){     
                        
            try {
                bs = BelcorpService.getInstance();
            
            } catch (MareMiiServiceNotFoundException e) {
            
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            
            // Armo el IN
            Long[] arrOids = dtoOids.getOids();
            StringBuffer sOids= new StringBuffer();
            
            for(int i=0; i < cant; i++){
                //sOids =  sOids + "," + arrOids[i];
				sOids.append(arrOids[i]);
				if(i<cant-1){
					if((i%800)!=0){
						sOids.append(",");
					}else{
						sOids.append(") OR oid_list_pica_cabe IN (");
					}
				}
            }
            sOids.append(")");
            query.append(" UPDATE ape_lista_picad_cabec SET ind_inte_envi = 'S' ");
            query.append(" WHERE oid_list_pica_cabe IN(").append(sOids);
            
            try {
                UtilidadesLog.debug("   - SAP601: hago el UPDATE.... ");
                bs.dbService.executeUpdate( query.toString() );    
                
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
        }
        
        UtilidadesLog.info("DAOPTL.actualizarListasPicadoEnviadas(DTOOIDs oids): Salida");
    }
    
    /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * @param oidCabecera
     * Descripción: Recupera los datos de las entidades AsignacionProductoAnaquelDetalle 
     * correspondientes al oid de la cabecera.  (Incidencia de referencia: BELC400000392)
     */
    public ArrayList obtenerDatosEnviarProductosAnaqueles(Long oidCabecera, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOPTL.obtenerDatosEnviarProductosAnaqueles(Long oidCabecera): Entrada");
 
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        RecordSet rs = new RecordSet();
        ArrayList pedidosAFacturar = new ArrayList();
        
        try {
            bs = BelcorpService.getInstance();
        
        } catch (MareMiiServiceNotFoundException e) {
            
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        //se cbia. la cons. x: mamontiel 14.08.07
        query.append("SELECT mapaCD.NUM_ANAQ, "); 
        query.append("produ.COD_SAP, ");
        query.append("ticaje.OID_TIPO_CAJA_EMBA, ");
        query.append("ticaje.UNMD_OID_UNID_MEDI_CAPA, ");
        query.append("ticaje.NUM_PORC_SEGU, ");
        query.append("ticaje.NUM_NIVE_APLI, ");
        query.append("ticaje.NUM_CAPA_MINI, ");
        query.append("(ticaje.VAL_ALTO*ticaje.VAL_ANCH*ticaje.VAL_LARG) volumenCaja, ");
        query.append("produ.VAL_VOLU, ");
        query.append("produ.UNMD_OID_UNID_MEDI ");
        query.append("FROM APE_ASIGN_PRODU_ANAQU_DETAL detalle, "); 
        query.append("APE_MAPA_CENTR_DISTR_DETAL mapaCD, ");
        query.append("APE_SUBLI_ARMAD subar, ");
        query.append("APE_LINEA_ARMAD linear, ");
        query.append("APE_TIPO_CAJA_EMBAL ticaje, "); 
        query.append("APE_LINEA_TIPO_CAJA_EMBAL linticaje, ");
        query.append("MAE_PRODU produ ");
        query.append("WHERE detalle.APAC_OID_ASIG_PROD_ANAQ_CABE = " + oidCabecera.longValue()); 
        query.append(" AND detalle.MCDD_OID_MAPA_CENT_DIST_DETA = mapaCD.OID_MAPA_CENT_DIST_DETA ");
        query.append("AND mapaCD.SBAR_OID_SUBL_ARMA = subar.OID_SUBL_ARMA "); 
        query.append("AND subar.SIPI_OID_SIST_PICA = " + ConstantesAPE.OID_SISTEMA_PICADO_PTL.longValue() ); 
        query.append("AND subar.LIAR_OID_LINE_ARMA = linear.OID_LINE_ARMA ");
        query.append("AND linticaje.LIAR_OID_LINE_ARMA = linear.OID_LINE_ARMA ");
        query.append("AND linticaje.TCEM_OID_TIPO_CAJA_EMBA = ticaje.OID_TIPO_CAJA_EMBA ");
        query.append("AND detalle.PROD_OID_PROD = produ.OID_PROD ");
        query.append("AND ticaje.IND_CUBI = 1 ");
        query.append("GROUP BY mapaCD.NUM_ANAQ, ");
        query.append("produ.COD_SAP, ");
        query.append("ticaje.OID_TIPO_CAJA_EMBA, ");
        query.append("ticaje.UNMD_OID_UNID_MEDI_CAPA, ");
        query.append("ticaje.NUM_PORC_SEGU, ");
        query.append("ticaje.NUM_NIVE_APLI, ");
        query.append("ticaje.NUM_CAPA_MINI, ");
        query.append("(ticaje.VAL_ALTO*ticaje.VAL_ANCH*ticaje.VAL_LARG), ");
        query.append("produ.VAL_VOLU, ");
        query.append("produ.UNMD_OID_UNID_MEDI ");        
        query.append("ORDER BY num_anaq, cod_sap, volumencaja DESC ");
        
        try {
            rs = bs.dbService.executeStaticQuery( query.toString() );
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        /* ******************************************************************************** 
        IMPORTANTE!!!! 
        NOTA FUNCIONAL: Según SICC-DECU-INT-PTL-211-315 solo se recuperarán dos registros 
        para cada par anaquel/producto diferenciados por el tipo de caja. 
        --yo no creo, peru buehh--
        ******************************************************************************** */       
        /* agregar mamontiel 14.08.07 
        solo tomo del recordSet el primer par ordenado agrupado por num_anaq y codigo_sap, los demas reg. 
        recuperados se deprecian
        -dicho en others words, corte de ctrl. x anaq. y cod. sap-
        PEROOO, siempre se deben armar 2 registros, aunque no pueda formar el par, el 2do., se arma vacio!
        
        */
        if( !rs.esVacio() ){
            UtilidadesLog.debug("consulta retorna: " + rs.getRowCount());
            HashMap paresOrdenados = new HashMap();
            
            String num_anaq, cod_sap;
            Long oid_tipo_caja_emba, unmd_oid_unid_medi_caja, num_porc_segu,  
                 val_volu, unmd_oid_unid_medi;
            float volumencaja, num_capa_mini, num_nive_apli;     
            
            int cant = rs.getRowCount();
            for(int i = 0; i < cant; i++){
                num_anaq = String.valueOf(rs.getValueAt(i, "NUM_ANAQ").toString());
                cod_sap = String.valueOf(rs.getValueAt(i, "COD_SAP").toString());
                UtilidadesLog.debug("111");       
                oid_tipo_caja_emba = Long.valueOf(rs.getValueAt(i, "OID_TIPO_CAJA_EMBA").toString());
                UtilidadesLog.debug("222");
                unmd_oid_unid_medi_caja = Long.valueOf(rs.getValueAt(i, "UNMD_OID_UNID_MEDI_CAPA").toString());
                num_porc_segu = Long.valueOf(rs.getValueAt(i, "NUM_PORC_SEGU").toString());
                num_nive_apli = ((BigDecimal)rs.getValueAt(i, "NUM_NIVE_APLI")).floatValue();
                num_capa_mini = ((BigDecimal)rs.getValueAt(i, "NUM_CAPA_MINI")).floatValue();
                volumencaja = ((BigDecimal)rs.getValueAt(i, "VOLUMENCAJA")).floatValue();
                val_volu = Long.valueOf(rs.getValueAt(i, "VAL_VOLU").toString());
                unmd_oid_unid_medi = Long.valueOf(rs.getValueAt(i, "UNMD_OID_UNID_MEDI").toString());
            
                String keyHash;
                keyHash = num_anaq.trim() + "-" + cod_sap.trim();
                
                 if (paresOrdenados.get(keyHash) == null){
                    UtilidadesLog.debug("clave: " + keyHash + ", no esta; adhiero!");
                    ArrayList listaDatosEnviarProductosAnaquel = new ArrayList();
                    DTODatosEnviarProductosAnaquel dtoDEPA = new DTODatosEnviarProductosAnaquel();      
                    
                    dtoDEPA.setNum_anaq(num_anaq);
                    dtoDEPA.setCod_sap(cod_sap);
                    dtoDEPA.setOid_tipo_caja_emba(oid_tipo_caja_emba);
                    dtoDEPA.setUnmd_oid_unid_medi_caja(unmd_oid_unid_medi_caja);
                    dtoDEPA.setNum_porc_segu(num_porc_segu);
                    dtoDEPA.setNum_nive_apli(num_nive_apli);
                    dtoDEPA.setNum_capa_mini(num_capa_mini);
                    dtoDEPA.setVolumencaja(volumencaja);
                    dtoDEPA.setVal_volu(val_volu);
                    dtoDEPA.setUnmd_oid_unid_medi(unmd_oid_unid_medi);
                    
                    listaDatosEnviarProductosAnaquel.add(dtoDEPA);
                    paresOrdenados.put(keyHash, listaDatosEnviarProductosAnaquel);
                    
                 }else{    //el segundo para formar el par
                    ArrayList listaDatosEnviarProductosAnaquel = (ArrayList)paresOrdenados.get(keyHash);
                    UtilidadesLog.debug(keyHash + "esta!");
                    if (listaDatosEnviarProductosAnaquel.size()==1){
                        UtilidadesLog.debug("para: " + keyHash + " la lista mide 1!, le agrego una pos.");
                        DTODatosEnviarProductosAnaquel dtoDEPA = new DTODatosEnviarProductosAnaquel();          
                        
                        dtoDEPA.setNum_anaq(num_anaq);
                        dtoDEPA.setCod_sap(cod_sap);
                        dtoDEPA.setOid_tipo_caja_emba(oid_tipo_caja_emba);
                        dtoDEPA.setUnmd_oid_unid_medi_caja(unmd_oid_unid_medi_caja);
                        dtoDEPA.setNum_porc_segu(num_porc_segu);
                        dtoDEPA.setNum_nive_apli(num_nive_apli);
                        dtoDEPA.setNum_capa_mini(num_capa_mini);
                        dtoDEPA.setVolumencaja(volumencaja);
                        dtoDEPA.setVal_volu(val_volu);
                        dtoDEPA.setUnmd_oid_unid_medi(unmd_oid_unid_medi);
                        
                        listaDatosEnviarProductosAnaquel.add(dtoDEPA);
                        paresOrdenados.put(keyHash, listaDatosEnviarProductosAnaquel);
                    }
                     
                 }
            }//al salir de aca, cada clave de la hash debe tener un array, con 2 posiciones, pero se debe controlar
             //por si solo en la consulta se encuentra un anaquel-cod. sap, al ser asi agrego un dto al array
             //con solo seteado el anaquel y el codigo sap
            ArrayList array = new ArrayList((Collection)paresOrdenados.values());
            Iterator it = (Iterator)array.iterator();         
            UtilidadesLog.debug("voy a reco. la hash por los dummys!!");
            while (it.hasNext()){
                ArrayList listaDatosEnviarProductosAnaquel = (ArrayList)it.next();
                if (listaDatosEnviarProductosAnaquel.size()==1){
                    UtilidadesLog.debug("lista mide 1, adh. dummy!!");
                    DTODatosEnviarProductosAnaquel aux = (DTODatosEnviarProductosAnaquel)
                                                             listaDatosEnviarProductosAnaquel.get(0);
                    DTODatosEnviarProductosAnaquel dtoDEPA = new DTODatosEnviarProductosAnaquel();                                                              
                    dtoDEPA.setNum_anaq(aux.getNum_anaq());
                    dtoDEPA.setCod_sap(aux.getCod_sap());
                    
                    listaDatosEnviarProductosAnaquel.add(dtoDEPA);
                                                             
                }
            
            }
            //ahora esta todo bien armado, sup.!
            ArrayList array1 = new ArrayList((Collection)paresOrdenados.values());
            Iterator it1 = (Iterator)array1.iterator();         
            ArrayList arrayFinal = new ArrayList();
            UtilidadesLog.debug("voy a iterar has, que mide: " + array1.size());
            while (it1.hasNext()){
                ArrayList listaDatosEnviarProductosAnaquel = (ArrayList)it1.next();
                cant = listaDatosEnviarProductosAnaquel.size();
                //se supone q' listaDatosEnviarProductosAnaquel, siempre medira 2
                RecordSet auxRS = null;
                for(int i = 0; i < cant; i++){
                    DTODatosEnviarProductosAnaquel aux = (DTODatosEnviarProductosAnaquel)
                                                         listaDatosEnviarProductosAnaquel.get(i);   
                                                         
                    auxRS = conversionStandar(oidPais, aux.getUnmd_oid_unid_medi());
                    aux.setVolumenProduConvertido( (aux.getVal_volu().floatValue() * 
                                                     ((BigDecimal)auxRS.getValueAt(0, "FACTORCONVERSION")).floatValue()) );
                    
                    auxRS = conversionStandar(oidPais, aux.getUnmd_oid_unid_medi_caja());                                  
                    aux.setVolumenCajaConvertido( (aux.getVolumencaja() *
                                                   ((BigDecimal)auxRS.getValueAt(0, "FACTORCONVERSION")).floatValue()) );
                    aux.setCapacidadMinimaConvertido( (aux.getNum_capa_mini() *
                                                   ((BigDecimal)auxRS.getValueAt(0, "FACTORCONVERSION")).floatValue()) );
                    aux.setNivelAplicacionConvertido( (aux.getNum_nive_apli() *
                                                   ((BigDecimal)auxRS.getValueAt(0, "FACTORCONVERSION")).floatValue()) );
                                         
                    UtilidadesLog.debug("adhiero a array final, el dato(VolumenProduConvertido): " + aux.getVolumenProduConvertido());
                    UtilidadesLog.debug("adhiero a array final, el dato(VolumenCajaConvertido): " + aux.getVolumenCajaConvertido());
                    UtilidadesLog.debug("adhiero a array final, el dato(CapacidadMinimaConvertido): " + aux.getCapacidadMinimaConvertido());
                    UtilidadesLog.debug("adhiero a array final, el dato(NivelAplicacionConvertido): " + aux.getNivelAplicacionConvertido());
                    
                    arrayFinal.add(aux);                                
                }
            }

            cant = arrayFinal.size();
            DTOAnaquelProductoAEnviar dto = null;
            ArrayList retorno = new ArrayList();
            Float aux = null;
            
            float unidadesProducto = 0;
            UtilidadesLog.debug("voy a reco. array final");
            for(int i = 0; i < cant; i++){
                DTODatosEnviarProductosAnaquel aux1 = (DTODatosEnviarProductosAnaquel)
                                                     arrayFinal.get(i);   
                DTODatosEnviarProductosAnaquel aux2 = (DTODatosEnviarProductosAnaquel)
                                                     arrayFinal.get(i+1);   
                                                     
            
                dto = new DTOAnaquelProductoAEnviar(); 
                
                dto.setNumeroAnaquel(aux1.getNum_anaq());
                dto.setCodProdu(aux1.getCod_sap());
                
                //caja 1
                if (aux1.getVolumenProduConvertido() > 
                    aux1.getNivelAplicacionConvertido()){
                    
                    UtilidadesLog.debug("(caja 1)VolumenProduConvertido() > NivelAplicacionConvertido(): " + 
                                        aux1.getVolumenProduConvertido() + "--" + aux1.getNivelAplicacionConvertido());
                    
                    unidadesProducto = ((aux1.getVolumenCajaConvertido() / aux1.getVolumenProduConvertido()) +
                                       ( (((aux1.getVolumenCajaConvertido() / aux1.getVolumenProduConvertido()) *
                                          aux1.getNum_porc_segu().longValue())) / 100));
                    
                }else{
                
                    UtilidadesLog.debug("(caja 1)VolumenProduConvertido() no > q' NivelAplicacionConvertido(): " + 
                                        aux1.getVolumenProduConvertido() + "--" + aux1.getNivelAplicacionConvertido());
                   
                    unidadesProducto = (aux1.getVolumenCajaConvertido() / aux1.getVolumenProduConvertido());
                }
                UtilidadesLog.debug("caja 1, unid. prod.: " + unidadesProducto);
                aux = new Float(unidadesProducto);
                UtilidadesLog.debug("aux (antes parte entera): " + aux);
                dto.setUnidadesProducto1(new Long(aux.intValue()));
                UtilidadesLog.debug("aux (desp. parte entera): " + dto.getUnidadesProducto2());
                
                //caja 2
                if (aux2.getVolumenProduConvertido() > 
                    aux2.getNivelAplicacionConvertido()){

                    UtilidadesLog.debug("(caja 2)VolumenProduConvertido() > NivelAplicacionConvertido(): " + 
                                        aux2.getVolumenProduConvertido() + "--" + aux2.getNivelAplicacionConvertido());
                    
                    unidadesProducto = ((aux2.getVolumenCajaConvertido() / aux2.getVolumenProduConvertido()) +
                                       ( (((aux2.getVolumenCajaConvertido() / aux2.getVolumenProduConvertido()) *
                                          aux2.getNum_porc_segu().floatValue())) / 100));
                    
                }else{
                    unidadesProducto = (aux2.getVolumenCajaConvertido() / aux2.getVolumenProduConvertido());
                    
                    UtilidadesLog.debug("(caja 2)VolumenProduConvertido() no > q' NivelAplicacionConvertido(): " + 
                                        aux2.getVolumenProduConvertido() + "--" + aux2.getNivelAplicacionConvertido());
                    
                }
                UtilidadesLog.debug("caja 2, unid. prod.: " + unidadesProducto);
                aux = new Float(unidadesProducto);
                
                UtilidadesLog.debug("aux (antes parte entera): " + aux);
                dto.setUnidadesProducto2(new Long(aux.intValue()));
                UtilidadesLog.debug("aux (desp. parte entera): " + dto.getUnidadesProducto2());
                retorno.add(dto);
                i=i+1;
                
            }
            UtilidadesLog.info("DAOPTL.obtenerDatosEnviarProductosAnaqueles(Long oidCabecera): Salida (sin data)");
            UtilidadesLog.debug("retorno mide: " + retorno.size());
            return retorno;
        }else{
            UtilidadesLog.info("DAOPTL.obtenerDatosEnviarProductosAnaqueles(Long oidCabecera): Salida (sin data)");
            return new ArrayList();
        }
    }
 
    /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOAsignacionProductoAnaquelCabecera 
     * Descripción: Se marcan como no asignadas para PTL todas las asignaciones producto-anaquel para el período 
     * y CD recibidos, teniendo en cuenta solo aquellas que son activas para facturación.   
     * (Incidencia de referencia: BELC400000465)
     */
    public void borrarIndAsignacionPTL(DTOAsignacionProductoAnaquelCabecera dtoe) throws MareException {
        UtilidadesLog.info("DAOPTL.borrarIndAsignacionPTL(DTOAsignacionProductoAnaquelCabecera dtoe): Entrada");
        
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try {
            bs = BelcorpService.getInstance();
        
        } catch (MareMiiServiceNotFoundException e) {
        
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }    
        query.append("UPDATE APE_ASIGN_PRODU_ANAQU_DETAL SET IND_ASIG_PETL = '' ");
        query.append("WHERE APAC_OID_ASIG_PROD_ANAQ_CABE IN ");
        query.append("(SELECT cabecera.OID_ASIG_PROD_ANAQ_CABE ");
        query.append("FROM APE_ASIGN_PRODU_ANAQU_CABEC cabecera, "); 
        query.append("APE_MAPA_CENTR_DISTR_CABEC mapaCabe "); 
        query.append("WHERE cabecera.PERD_OID_PERI = " + dtoe.getOidPeriodo().longValue()); 
        
        //cambio APE-02 
        //query.append(" AND cabecera.IND_ACTI_FACT = 'S' ");
        query.append(" AND cabecera.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCDCabecera().longValue());
        query.append(" AND cabecera.VAL_VERS = '" + dtoe.getVersion() + "' ");
        
        query.append("AND cabecera.MCDC_OID_MAPA_CENT_DIST_CABE = mapaCabe.OID_MAPA_CENT_DIST_CABE "); 
        query.append("AND mapaCabe.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOidCentroDistribucion().longValue() + ")");        
        
        try {
            UtilidadesLog.debug("   - borrarIndAsignacionPTL: hago el UPDATE.... ");
            bs.dbService.executeUpdate( query.toString() );    
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }            
        
        UtilidadesLog.info("DAOPTL.borrarIndAsignacionPTL(DTOAsignacionProductoAnaquelCabecera dtoe): Salida");
    }

    /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOAsignacionProductoAnaquelCabecera 
     * Descripción: A partir del período y el CD se recupera la asignación de prodcutos a anaqueles teniendo en 
     * cuenta la asignación activa y que solo se consideran las sublineas de PTL. 
     * (Incidencia de referencia: BELC400000465)
     */
    public HashMap obtenerNroAnaqCodProdActivosFact(DTOAsignacionProductoAnaquelCabecera dtoE) throws MareException {
        UtilidadesLog.info("DAOPTL.obtenerNroAnaqCodProdActivosFact(DTOAsignacionProductoAnaquelCabecera dtoE): Entrada");
        
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        RecordSet rs = new RecordSet();
        try {
            bs = BelcorpService.getInstance();
        
        } catch (MareMiiServiceNotFoundException e) {
        
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }    
        query.append("SELECT mapaDetalle.num_anaq, ");
        query.append("asigDetalle.oid_asig_prod_anaq, ");
        query.append("produ.cod_sap, produ.oid_prod ");
        query.append("FROM APE_ASIGN_PRODU_ANAQU_DETAL asigDetalle, "); 
        query.append("APE_ASIGN_PRODU_ANAQU_CABEC asigCabecera, "); 
        query.append("APE_MAPA_CENTR_DISTR_CABEC mapaCabecera, ");
        query.append("APE_MAPA_CENTR_DISTR_DETAL mapaDetalle, ");
        query.append("APE_SUBLI_ARMAD sublinea, ");
        query.append("MAE_PRODU produ ");
        query.append("WHERE asigDetalle.APAC_OID_ASIG_PROD_ANAQ_CABE = asigCabecera.OID_ASIG_PROD_ANAQ_CABE ");
        query.append("AND asigCabecera.PERD_OID_PERI = " + dtoE.getOidPeriodo().longValue());
        query.append("AND asigCabecera.IND_ACTI_FACT = 'S' ");
        query.append("AND asigCabecera.MCDC_OID_MAPA_CENT_DIST_CABE = mapaCabecera.OID_MAPA_CENT_DIST_CABE ");
        query.append("AND mapaCabecera.CCDI_OID_CONF_CENT_DIST = " + dtoE.getOidCentroDistribucion().longValue());
        query.append("AND asigDetalle.MCDD_OID_MAPA_CENT_DIST_DETA = mapaDetalle.OID_MAPA_CENT_DIST_DETA ");
        query.append("AND mapaDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
        query.append("AND sublinea.SIPI_OID_SIST_PICA = " + ConstantesAPE.OID_SISTEMA_PICADO_PTL.longValue());
        query.append("AND produ.OID_PROD = asigDetalle.PROD_OID_PROD ");
                
        try {
            UtilidadesLog.debug("   - obtenerNroAnaqCodProdActivosFact: consulta.... ");
            rs = bs.dbService.executeStaticQuery( query.toString() );
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }            
        if( !rs.esVacio() ){     
            UtilidadesLog.debug("   - record., no vacio, mide: " + rs.getRowCount());
            
            int cant = rs.getRowCount();
            HashMap hashRet = new HashMap();
            DTOCompararAsignacionAnaqueles dtoLinea = null;
                
            for(int i = 0; i < cant; i++){
                dtoLinea = new DTOCompararAsignacionAnaqueles();
                
                if(hashRet.get(rs.getValueAt(i, "NUM_ANAQ").toString())==null){
                   dtoLinea.setCodigoProducto(rs.getValueAt(i, "COD_SAP").toString());
                   dtoLinea.setOidAsignacionAnaquel(Long.valueOf(rs.getValueAt(i, "OID_ASIG_PROD_ANAQ").toString()));
                   dtoLinea.setOidProducto(Long.valueOf(rs.getValueAt(i, "OID_PROD").toString()));
                   hashRet.put(rs.getValueAt(i, "NUM_ANAQ").toString(), dtoLinea);
                }   
            }
            
            UtilidadesLog.debug("   - retorno hash: " + hashRet);
            UtilidadesLog.info("DAOPTL.obtenerNroAnaqCodProdActivosFact(DTOAsignacionProductoAnaquelCabecera dtoE): Salida (datos!)");
            return hashRet;
            
        }else{
            UtilidadesLog.info("DAOPTL.obtenerNroAnaqCodProdActivosFact(DTOAsignacionProductoAnaquelCabecera dtoE): Salida (nada!)");
            return new HashMap();
        }
        
    }
    
    /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOOIDs 
     * Descripción: Se marcan como asignadas para PTL todas las asignaciones producto-anaquel recibidas. 
     * (Incidencia de referencia: BELC400000465)
     */
    public void marcarAsignacionesPTL(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("DAOPTL.marcarAsignacionesPTL(DTOOIDs dtoe): Entrada");
        
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        Long[] oids = dtoe.getOids();
        
        if (oids.length > 0){
            try {
                bs = BelcorpService.getInstance();
            
            } catch (MareMiiServiceNotFoundException e) {
            
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }    
    
            query.append("UPDATE APE_ASIGN_PRODU_ANAQU_DETAL SET IND_ASIG_PETL = '1' ");
            query.append("WHERE OID_ASIG_PROD_ANAQ IN (");
            
            for (int i = 0; i < oids.length; ) {
                query.append(oids[i]);
                if (++i < oids.length) {
                    query.append(',');
                } else {
                    query.append(')');
                }
            }
            
            try {
                UtilidadesLog.debug("   - marcarAsignacionesPTL: hago el UPDATE.... ");
                bs.dbService.executeUpdate( query.toString() );    
                
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }            
        }
        UtilidadesLog.info("DAOPTL.marcarAsignacionesPTL(DTOOIDs dtoe): Salida");
    }
    
   /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOAsignacionProductoAnaquelCabecera  
     * Descripción: Se recuperan todos los anaqueles que no están marcados como asignación PTL.
     * (Incidencia de referencia: BELC400000465)
     */
    public ArrayList obtenerAnaquelesNoAsignados(DTOAsignacionProductoAnaquelCabecera dtoe) throws MareException {
        UtilidadesLog.info("DAOPTL.obtenerAnaquelesNoAsignados(DTOAsignacionProductoAnaquelCabecera dtoe): Entrada");

        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        RecordSet rs = new RecordSet();
        try {
            bs = BelcorpService.getInstance();
        
        } catch (MareMiiServiceNotFoundException e) {
        
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }    
        query.append("SELECT produ.cod_sap, ");
        query.append("mapaDetalle.num_anaq, produ.oid_prod ");
        query.append("FROM APE_ASIGN_PRODU_ANAQU_CABEC asigCabecera, ");
        query.append("APE_ASIGN_PRODU_ANAQU_DETAL asigDetalle, "); 
        query.append("APE_MAPA_CENTR_DISTR_CABEC mapaCabecera, ");
        query.append("APE_MAPA_CENTR_DISTR_DETAL mapaDetalle, ");
        query.append("MAE_PRODU produ, ");
        /*Incidencia  BELC400000718*/
        query.append("APE_SUBLI_ARMAD sublinea ");
        /*fin Incidencia  BELC400000718*/
        query.append("WHERE asigDetalle.IND_ASIG_PETL IS NULL ");
        query.append("AND asigDetalle.APAC_OID_ASIG_PROD_ANAQ_CABE = asigCabecera.OID_ASIG_PROD_ANAQ_CABE ");
        query.append("AND asigCabecera.PERD_OID_PERI = " + dtoe.getOidPeriodo().longValue());
        query.append(" AND asigCabecera.IND_ACTI_FACT = 'S' ");
        query.append("AND asigCabecera.MCDC_OID_MAPA_CENT_DIST_CABE = mapaCabecera.OID_MAPA_CENT_DIST_CABE ");
        query.append("AND mapaCabecera.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOidCentroDistribucion().longValue());
        query.append(" AND produ.OID_PROD = asigDetalle.PROD_OID_PROD ");
        query.append("AND asigDetalle.MCDD_OID_MAPA_CENT_DIST_DETA = mapaDetalle.OID_MAPA_CENT_DIST_DETA ");
        /*Incidencia  BELC400000718*/
        query.append("AND mapaDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
        query.append("AND sublinea.SIPI_OID_SIST_PICA = " + ConstantesAPE.OID_SISTEMA_PICADO_PTL.longValue());
        /*fin Incidencia  BELC400000718*/
                
        try {
            UtilidadesLog.debug("   - obtenerAnaquelesNoAsignados: consulta.... ");
            rs = bs.dbService.executeStaticQuery( query.toString() );
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }            

        if( rs.getRowCount()>0 ){     
            UtilidadesLog.debug("   - record., no vacio, mide: " + rs.getRowCount());
            ArrayList listaDev = new ArrayList();
            
            int cant = rs.getRowCount();
            DTODiferenciaAsignacion dtoLinea = null;
            String codProdUlt9Pos = null;
            for(int i = 0; i < cant; i++){
                dtoLinea = new DTODiferenciaAsignacion();
                
                codProdUlt9Pos = new String();
                codProdUlt9Pos = String.valueOf(rs.getValueAt(i, "COD_SAP").toString()).trim();
                dtoLinea.setCodProductoSiCC(codProdUlt9Pos.substring(0,9));
                dtoLinea.setOidProductoSiCC(Long.valueOf(rs.getValueAt(i, "OID_PROD").toString()));
                dtoLinea.setNumeroAnaquel(rs.getValueAt(i, "NUM_ANAQ").toString());
                UtilidadesLog.debug("adh. en lista dto: " + dtoLinea);
                listaDev.add(dtoLinea);
            }   
            UtilidadesLog.info("DAOPTL.obtenerAnaquelesNoAsignados(DTOAsignacionProductoAnaquelCabecera dtoe): Salida (con data!)");
            return listaDev;
        }else{
            UtilidadesLog.info("DAOPTL.obtenerAnaquelesNoAsignados(DTOAsignacionProductoAnaquelCabecera dtoe): Salida (sin data!)");
            return new ArrayList();
        }
    }

   /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * @param ArrayList  
     * Descripción: Se insertan registros en la entidad APE:ProdDifAsignacion.
     * (Incidencia de referencia: BELC400000465)
     */
    public void insertarDiferenciasAsignacion(HashMap diferencias) throws MareException {
        UtilidadesLog.info("DAOPTL.insertarDiferenciasAsignacion(ArrayList dtoe): Entrada");
        
        int size = diferencias.size();
        if (size>0){
            UtilidadesLog.debug("tengo: " + size + " diferencias....");
            ArrayList array = new ArrayList((Collection)diferencias.values());
            Iterator it = (Iterator)array.iterator();
            DTODiferenciaAsignacion dtoRegistro;
            StringBuffer insertarDiferencia;
            Vector vInsertarDiferencia = new Vector();
            while (it.hasNext()){
                dtoRegistro = (DTODiferenciaAsignacion)it.next();
                UtilidadesLog.debug("datos insert actual: " + dtoRegistro);
                insertarDiferencia = new StringBuffer();
                
                insertarDiferencia.append("INSERT INTO APE_PRODU_DIFER_ASIGN (");
                insertarDiferencia.append(" OID_PROD_DIFE_ASIG, ");
                insertarDiferencia.append(" COD_ANAQ ");
                 
                if (dtoRegistro.getOidProductoSiCC()!=null)
                   insertarDiferencia.append(" ,PROD_OID_PRO2 ");

                if (dtoRegistro.getCodProductoPTL()!=null)                   
                   insertarDiferencia.append(" ,COD_PROD_INTE ");
                
                insertarDiferencia.append(") VALUES (");                
                insertarDiferencia.append(" APE_PRDA_SEQ.nextval, '");
                insertarDiferencia.append(dtoRegistro.getNumeroAnaquel().trim() + "'");
                //insertarDiferencia.append(dtoLinea.getCodProductoSiCC()+ ", '");
                
                if (dtoRegistro.getOidProductoSiCC()!=null)
                    insertarDiferencia.append(" ," + dtoRegistro.getOidProductoSiCC().longValue());
                    
                if (dtoRegistro.getCodProductoPTL()!=null)    
                    insertarDiferencia.append(" ,'" + dtoRegistro.getCodProductoPTL() + "'");
                    
                insertarDiferencia.append(");");
                
                UtilidadesLog.debug("insert actual: " + insertarDiferencia);
                
                vInsertarDiferencia.add(insertarDiferencia);
                
            }
            UtilidadesLog.debug("*** Ejecutando Insert de Diferencias Asig.(masivo)...");
            invocarExecutor(vInsertarDiferencia);
            
        }
        UtilidadesLog.info("DAOPTL.insertarDiferenciasAsignacion(ArrayList dtoe): Salida");
    } 
    
   /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * @param ArrayList  
     * Descripción: Se eliminan registros de la entidad APE:ProdDifAsignacion
     * (Incidencia de referencia: BELC400000465)
     */
    public void eliminarDiferenciasAsignacion() throws MareException {
        UtilidadesLog.info("DAOPTL.eliminarDiferenciasAsignacion(): Entrada");

        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        
        } catch (MareMiiServiceNotFoundException e) {
        
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }    
    
        query.append("DELETE FROM APE_PRODU_DIFER_ASIGN");
        try {
            UtilidadesLog.debug("   - eliminarDiferenciasAsignacion: hago deleteo gral. .... ");
            int afect = bs.dbService.executeUpdate( query.toString() );    
            UtilidadesLog.debug("se deletearon: " + afect + " filas!");    
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }            
        
        UtilidadesLog.info("DAOPTL.eliminarDiferenciasAsignacion(): Salida");
    }
    
    /**
     * Metodo auxiliar para ejecutar un script con sentencias Sql tipo UPDATE, INSERT o 
     * DELETE realizando un unico acceso a BBDD (cada sentencia es un elemento de 
     * la clase StringBuffer en el Vector de entrada, y debe finalizar en ';')
     * @autor eiraola
     * @since 07/May/2007
     */
    private void invocarExecutor(Vector vExecutor) throws MareException {
        String query = new String ();
        int cantSentencias = vExecutor.size();
        UtilidadesLog.debug("    cantidad de sentencias a ejecutar_" + cantSentencias);
        if (cantSentencias == 0) return;
                
        for (int i=0; i< cantSentencias; i++){
            query = query + ((StringBuffer) vExecutor.get(i)).toString();
        }
        try {
            UtilidadesEJB.getBelcorpService().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query);
        } catch (Exception ex ) {
            UtilidadesLog.error(ex.getMessage());
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }  
    
   /**
     * @author SCSAAVEDRA
     * @throws es.indra.mare.common.exception.MareException
     * Descripción: Obtenemos el factore de conversión de las unidade recibida a la unidad 
     * estandar definida en MAE:UnidadesMedida
     * Autor: MAMONTIEL Fecha:14.08.07 
     */    
    private RecordSet conversionStandar(Long oidPais, Long oidMagnitud) throws MareException {
        UtilidadesLog.info("DAOPTL.conversionStandar(Long oidPais, Long oidMagnitud): Entrada");
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        RecordSet rs = new RecordSet();
        try {
            bs = BelcorpService.getInstance();
        
        } catch (MareMiiServiceNotFoundException e) {
        
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }    
        query.append("SELECT APE_FACTO_CONVE.UNMD_OID_UNID_MEDI_ORIG unidadMedidaOrigen, ");
        query.append("APE_FACTO_CONVE.NUM_FACT_CONV factorConversion ");
        query.append("FROM MAE_UNIDA_MEDID , APE_FACTO_CONVE ");
        query.append("WHERE APE_FACTO_CONVE.MAGN_OID_MAGN = MAE_UNIDA_MEDID.MAGN_OID_MAGN ");
        query.append("AND MAE_UNIDA_MEDID.PAIS_OID_PAIS = " + oidPais.longValue());
        query.append("AND MAE_UNIDA_MEDID.IND_UM_STND=1 ");
        query.append("AND APE_FACTO_CONVE.UNMD_OID_UNID_MEDI_ORIG = " + oidMagnitud.longValue());
        query.append("AND APE_FACTO_CONVE.UNMD_OID_UNID_MEDI_DEST = MAE_UNIDA_MEDID.OID_UNID_MEDI");
        try {
            rs = bs.dbService.executeStaticQuery( query.toString() );
            UtilidadesLog.debug("   - conversionStandar: consulta....: " + rs.getRowCount());
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }      
        UtilidadesLog.info("DAOPTL.conversionStandar(Long oidPais, Long oidMagnitud): Salida");
        return rs;
    }
    
  /**
   * Valida la existencia del numero de solicitud que se pasa por parametro
   * devolviendo el OID del registro.
   * @author eiraola
   * @since 29/Ago/2007
   * @observacion
   *     BELC400000690 eiraola
   */ 
  public Long validarExistenciaNumeroSolicitud(Long oidPais, Long numeroSolicitud) throws MareException {
      UtilidadesLog.info("DAOPTL.validarExistenciaNumeroSolicitud(oidPais, numeroSolicitud): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidSoliCabe = null;
      
      consulta.append("SELECT psc.OID_SOLI_CABE ");
      consulta.append("  FROM PED_SOLIC_CABEC psc ");
      consulta.append(" WHERE psc.PAIS_OID_PAIS = " + oidPais);
      consulta.append("   AND psc.VAL_NUME_SOLI = " + numeroSolicitud);
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error(" validarExistenciaNumeroSolicitud: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      UtilidadesLog.debug(" rs: " + rs);
      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0) != null) {
          oidSoliCabe = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
      }
      
      UtilidadesLog.info("DAOPTL.validarExistenciaNumeroSolicitud(oidPais, numeroSolicitud): Salida");
      return oidSoliCabe;
  }

  /**
   * Valida la existencia de Lista de picado para el numero de solicitud recibido
   * en la interfaz PTL-3 (indirectamente esta validando que exista el numero de solicitud).
   * @author eiraola
   * @since 07/Sep/2007
   * @observacion
   *     BELC400000719 eiraola
   */ 
  public Long validarExistenciaListaPicado(Long oidPais, Long numeroSolicitud) throws MareException {
      UtilidadesLog.info("DAOPTL.validarExistenciaListaPicado(oidPais, numeroSolicitud): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidListPicadCabec = null;
      
      consulta.append("SELECT lpc.OID_LIST_PICA_CABE, lpc.SOCA_OID_SOLI_CABE ");
      consulta.append("  FROM APE_LISTA_PICAD_CABEC lpc, ");
      consulta.append("       PED_SOLIC_CABEC psc ");
      consulta.append(" WHERE lpc.SOCA_OID_SOLI_CABE = psc.OID_SOLI_CABE ");
      consulta.append("   AND psc.PAIS_OID_PAIS = " + oidPais);
      consulta.append("   AND psc.VAL_NUME_SOLI = '" + numeroSolicitud + "' ");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error(" validarExistenciaListaPicado: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      UtilidadesLog.debug(" rs: " + rs);
      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0) != null) {
          oidListPicadCabec = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
      }
      
      UtilidadesLog.info("DAOPTL.validarExistenciaListaPicado(oidPais, numeroSolicitud): Salida");
      return oidListPicadCabec;
  } 
}









