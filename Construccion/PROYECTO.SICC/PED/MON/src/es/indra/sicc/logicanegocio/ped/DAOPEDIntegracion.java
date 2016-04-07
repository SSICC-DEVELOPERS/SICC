package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTODatosFlete;
import es.indra.sicc.dtos.ped.DTODatosMontoMinimo;
import es.indra.sicc.dtos.ped.DTOIndicadoresFlete;
import es.indra.sicc.dtos.ped.DTOLimVentaPosicion;
import es.indra.sicc.dtos.ped.DTOPrecioPosicion;
import es.indra.sicc.dtos.ped.DTOPrecioPosiciones;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;


public class DAOPEDIntegracion {
    private UtilidadesLog log = new UtilidadesLog();
    
    private BelcorpService getBelcorpService() throws MareException {
        try {
            BelcorpService bs = BelcorpService.getInstance();

            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }

    /**
     * Obtiene los precios de las posiciones para una solicitud. 
     * @cambio incidencia 23752 se obtiene el precio unitario que es precio catalogo sobre factor de repeticion.
     * @autor gdmarzi
     */
    public DTOPrecioPosiciones obtenerPreciosPosicionesMatriz(Long oidSolicitud, Integer numDecimales) throws MareException {
        UtilidadesLog.info("DAOPEDIntegracion.obtenerPreciosPosicionesMatriz(Long oidSolicitud): Entrada ");
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            /*query.append("SELECT P.OID_SOLI_POSI,O.OID_OFER,D.IMP_PREC_CATA,D.IMP_PREC_POSI,O.OID_OFER OFERTA,COUNT(VE.OID_VENT_EXCL) VENTA_EXCL ");
            query.append("FROM PED_SOLIC_POSIC P,PRE_OFERT O,PRE_OFERT_DETAL D,PRE_VENTA_EXCLU VE ");
            query.append("where P.SOCA_OID_SOLI_CABE= " + oidSolicitud);
            query.append(" AND P.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
            query.append(" AND ((P.val_prec_cata_unit_loca = 0) or (P.val_prec_cata_unit_loca is NULL)) ");
            query.append(" AND ((P.val_prec_cont_unit_loca = 0) or (P.val_prec_cont_unit_loca is NULL)) ");            
            query.append(" AND P.val_codi_vent IS NOT NULL");
            query.append(" AND P.OFDE_OID_DETA_OFER=D.OID_DETA_OFER ");
            query.append(" AND D.OFER_OID_OFER=O.OID_OFER ");
            query.append(" AND VE.OFER_OID_OFER (+)=O.OID_OFER ");
            query.append(" GROUP BY P.OID_SOLI_POSI,OID_DETA_OFER,O.OID_OFER,D.IMP_PREC_CATA,D.IMP_PREC_POSI ");*/
            ArrayList array = new ArrayList();
            array.add(oidSolicitud.toString());
            array.add(ConstantesPED.ESTADO_POSICION_ANULADO.toString());
            
            //respuesta = bs.dbService.executeStaticQuery(query.toString());
            //respuesta = bs.dbService.executeProcedure("PQ_PLANI.PED_OBTENER_PREC_POSIC_MATRIZ", array);
            
            StringBuffer buf = new StringBuffer();
            buf.append("select * from table(CAST(PED_OBTENER_MATRIZ_PREC_POSIC(");
            buf.append(oidSolicitud.toString()+"," + ConstantesPED.ESTADO_POSICION_ANULADO.toString());
            buf.append(") as OBJ_PED_SOL_PREC_POSIC_TABLE))");
            
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
             
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
			if(log.isDebugEnabled())
				UtilidadesLog.debug("resu, cons. obtenerPreciosPosicionesMatriz: " + respuesta);
				
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOPrecioPosiciones dto = new DTOPrecioPosiciones();
        Vector interno = new Vector();
        BigDecimal precioCatalogo, factorRepeticion;
        if(respuesta!=null && !respuesta.esVacio()){
            if(respuesta.getValueAt(0,0)!=null){ // por el procedure puede venir con una posicion nula y no vacia
                for (int i = 0; i < respuesta.getRowCount(); i++) {
                    DTOPrecioPosicion pPosic = new DTOPrecioPosicion();
                    pPosic.setOidPosicion(new Long(respuesta.getValueAt(i,0).toString()));
        
                    //controlo nulidad, si es nulo = 0 
                    if (respuesta.getValueAt(i,3) != null) {
                        pPosic.setPrecioContable(new BigDecimal(respuesta.getValueAt(i,3).toString()));
                    } else {
                        pPosic.setPrecioContable(new BigDecimal(0));
                    }
        
                    if (respuesta.getValueAt(i,2) != null) {
                        precioCatalogo = new BigDecimal(respuesta.getValueAt(i,2).toString());
                        factorRepeticion = new BigDecimal(respuesta.getValueAt(i,6).toString());
                        pPosic.setPrecioUnitario(precioCatalogo.divide(factorRepeticion, numDecimales.intValue(), BigDecimal.ROUND_HALF_UP));
                    } else { 
                        pPosic.setPrecioUnitario(new BigDecimal(0));
                    }  
        
                    Long valLong = new Long(respuesta.getValueAt(i,5).toString());
                                
        
                    if (valLong.longValue()==0) {
                        pPosic.setIndVentaExclusivo(Boolean.FALSE);
                    } else {
                        pPosic.setIndVentaExclusivo(Boolean.TRUE);
                        if (respuesta.getValueAt(i,4)!=null){
                            pPosic.setOidOferta(new Long( respuesta.getValueAt(i,4).toString()));
                        }
                    }
        
                    interno.add(pPosic);
                }
            }
        }
        dto.setPrecioPosiciones(interno);
        UtilidadesLog.info("DAOPEDIntegracion.obtenerPreciosPosicionesMatriz(Long oidSolicitud): Salida ");
        return dto;
    }

    public DTOPrecioPosiciones obtenerPreciosPosicionesMaestro(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOPEDIntegracion.obtenerPreciosPosicionesMaestro(Long oidSolicitud): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            query.append(" SELECT A.oid_soli_posi oid, B.val_prec_posi posicion, B.val_prec_cata catalogo, B.val_prec_cont contable ");
            query.append(" FROM ped_solic_posic A, mae_produ B ");
            query.append(" WHERE A.soca_oid_soli_cabe =  " + oidSolicitud);
            query.append(" AND A.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
            query.append(" AND (A.val_prec_cata_unit_loca IS NULL or A.val_prec_cata_unit_loca = 0 )");
            query.append(" AND (A.val_prec_cont_unit_loca IS NULL or A.val_prec_cont_unit_loca = 0 ) ");
            query.append(" AND A.val_codi_vent IS NULL ");
            query.append(" AND B.oid_prod = A.prod_oid_prod ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOPrecioPosiciones dto = new DTOPrecioPosiciones();
        Vector interno = new Vector();

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            DTOPrecioPosicion pPosic = new DTOPrecioPosicion();
            pPosic.setOidPosicion((Long) this.castBigDecimal(
                    (BigDecimal) respuesta.getColumn(0).get(i)));

            pPosic.setPrecioContable((BigDecimal) respuesta.getColumn(3).get(i));

            pPosic.setPrecioCatalogo((BigDecimal) respuesta.getColumn(2).get(i));

            pPosic.setPrecioPosicion((BigDecimal) respuesta.getColumn(1).get(i));

            interno.add(pPosic);
        }

        dto.setPrecioPosiciones(interno);
        UtilidadesLog.info("DAOPEDIntegracion.obtenerPreciosPosicionesMaestro(Long oidSolicitud): Salida ");
        return dto;
        
    }

    public Boolean validarClienteVentaExclusiva(Long oidCliente, Long oidOferta)
        throws MareException {
        UtilidadesLog.info("DAOPEDIntegracion.validarClienteVentaExclusiva(Long oidCliente, Long oidOferta): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            query.append(
                "SELECT  COUNT(*) FROM V_MAE_TIPIF_CLIEN TP, PRE_VENTA_EXCLU VE, MAE_CLIEN_UNIDA_ADMIN cua, ZON_TERRI_ADMIN zta, ZON_SECCI zs, ZON_ZONA zz ");
            query.append("WHERE ");
            query.append(" TP.CLIE_OID_CLIE = " + oidCliente);
            query.append(" AND VE.OFER_OID_OFER = " + oidOferta);
            query.append(" AND TP.TICL_OID_TIPO_CLIE =VE.TICL_OID_TIPO_CLIE");
            query.append(
                " AND (TP.SBTI_OID_SUBT_CLIE = VE.SBTI_OID_SUBT_CLIE OR VE.SBTI_OID_SUBT_CLIE IS NULL)");
            query.append(
                " AND (TP.TCCL_OID_TIPO_CLASI=VE.TCCL_OID_TIPO_CLAS OR VE.TCCL_OID_TIPO_CLAS IS NULL)");
            query.append(
                " AND (TP.CLAS_OID_CLAS=VE.CLAS_OID_CLAS OR VE.CLAS_OID_CLAS IS NULL)");
            query.append(" AND cua.CLIE_OID_CLIE = tp.clie_oid_clie ");
            query.append(" AND cua.IND_ACTI = 1 ");
            query.append(" AND cua.ZTAD_OID_TERR_ADMI = zta.OID_TERR_ADMI ");
            query.append(" AND zta.ZSCC_OID_SECC = zs.OID_SECC ");
            query.append(" AND zs.ZZON_OID_ZONA = zz.OID_ZONA ");
            query.append(" AND (   zz.OID_ZONA = ve.ZZON_OID_ZONA ");
            query.append(" OR ve.ZZON_OID_ZONA IS NULL ) ");
            query.append(" AND (   zz.ZORG_OID_REGI = ve.ZORG_OID_REGI ");
            query.append(" OR ve.ZORG_OID_REGI IS NULL ) ");
            query.append(" AND (   TP.ESTA_OID_ESTA_CLIE = ve.ESTA_OID_ESTA_CLIE ");
            query.append(" OR ve.ESTA_OID_ESTA_CLIE IS NULL ) ");            
                
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        String s = respuesta.getRow(0).get(0).toString();

        Integer value = new Integer(s);
        if (value.equals(new Integer(0))) {
            UtilidadesLog.info("DAOPEDIntegracion.validarClienteVentaExclusiva(Long oidCliente, Long oidOferta): Salida ");
            return Boolean.FALSE;
        } else {
            UtilidadesLog.info("DAOPEDIntegracion.validarClienteVentaExclusiva(Long oidCliente, Long oidOferta): Salida ");
            return Boolean.TRUE;
        }
    }

    private Long castBigDecimal(BigDecimal param) {
        String s = param.toString();
        Long valLong = new Long(s);

        return valLong;
    }

    /**
     * CHANGELOG
     * ---------
     * 14/07/2009 - dmorello, Cambio 20090916: Se recupera el campo OID_FLET
     */
    public ArrayList obtenerValoreFlete(Long oidSolicitud)
        throws MareException {
        
        UtilidadesLog.info("DAOPEDIntegracion.obtenerValoreFlete(Long oidSolicitud): Entrada ");
        ArrayList miArray = new ArrayList();
        StringBuffer query = new StringBuffer(); 
        RecordSet rs;
        BelcorpService bs = getBelcorpService();
        query.append("	SELECT CA.VAL_RECA_FLET_LOCA, ");
        query.append(" (SELECT SUM(NUM_UNID_COMPR*(NVL(VAL_PREC_CATA_UNIT_LOCA,0)-NVL(VAL_IMPO_DESC_UNIT_LOCA,0))) FROM PED_SOLIC_POSIC WHERE SOCA_OID_SOLI_CABE = CA.OID_SOLI_CABE) VAL_BASE_FLET_LOCA,");
        query.append(" FL.VAL_MONT_FIJO,FL.VAL_FLET_MINI,FL.VAL_FLET_MAXI,FL.VAL_CONT_ENTR,FL.VAL_TASA,FL.CLAS_OID_CLAS,FL.TCCL_OID_TIPO_CLAS,CL.COD_CLIE,TS.COD_TIPO_SOLI 	 ");
        query.append(",FL.OID_FLETE ");
        query.append(" 	FROM PED_FLETE FL, 	 ");
        query.append(" 	V_MAE_TIPIF_CLIEN TP, 	 ");
        query.append(" 	PED_SOLIC_CABEC CA, 	 ");
        query.append(" 	MAE_CLIEN CL, 	 ");
        query.append(" 	PED_TIPO_SOLIC_PAIS TSP, 	 ");
        query.append(" 	PED_TIPO_SOLIC TS 	 ");
        query.append(" 	WHERE 	 ");
        query.append(" 	CA.OID_SOLI_CABE = " + oidSolicitud);
        query.append(" 	AND CL.OID_CLIE=CA.CLIE_OID_CLIE 	 ");
        query.append(" 	AND TSP.OID_TIPO_SOLI_PAIS=CA.TSPA_OID_TIPO_SOLI_PAIS 	 ");
        //jrivas 4/5/2005 Estaba el select
        //query.append(" 	AND TSP.OID_TIPO_SOLI_PAIS=TS.OID_TIPO_SOLI 	 ");
        query.append("	AND tsp.TSOL_OID_TIPO_SOLI  = ts.oid_tipo_soli ");
        query.append(" 	AND TP.CLIE_OID_CLIE=CA.CLIE_OID_CLIE 	 ");
        query.append(" 	AND FL.TICL_OID_TIPO_CLIE=TP.TICL_OID_TIPO_CLIE 	 ");
        query.append(" 	AND (FL.SBTI_OID_SUBT_CLIE IS NULL OR FL.SBTI_OID_SUBT_CLIE=TP.SBTI_OID_SUBT_CLIE) 	 ");
        
        //jrivas 4/5/2005 Estaba el select
        //query.append(" 	AND (FL.TCCL_OID_TIPO_CLAS IS NULL OR FL.SBTI_OID_SUBT_CLIE=TP.TCCL_OID_TIPO_CLASI) 	 ");
        query.append(" 	AND (   fl.tccl_oid_tipo_clas IS NULL        OR fl.tccl_oid_tipo_clas = tp.tccl_oid_tipo_clasi       ) ");
        
        //jrivas 4/5/2005 Estaba el select
        //query.append(" 	AND (FL.CLAS_OID_CLAS IS NULL OR FL.SBTI_OID_SUBT_CLIE=TP.CLAS_OID_CLAS) 	 ");
        query.append(" 	AND (fl.clas_oid_clas IS NULL OR fl.clas_oid_clas = tp.clas_oid_clas       ) ");

        query.append(" 	AND (FL.TIDS_OID_TIPO_DESP=CA.TIDS_OID_TIPO_DESP) 	 ");
        query.append(" 	AND (FL.ZZON_ZONA IS NULL OR FL.ZZON_ZONA=CA.ZZON_OID_ZONA) 	 ");
        query.append(" 	AND (FL.VEPO_UBIG IS NULL OR FL.VEPO_UBIG=CA.VEPO_OID_VALO_ESTR_GEOP) 	 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("consulta: obtenerValoreFlete, retorna: " + rs);

            if (rs.esVacio()) {
                UtilidadesLog.info("DAOPEDIntegracion.obtenerValoreFlete(Long oidSolicitud): Salida ");
                return null;
            } else {
                DTODatosFlete miDto = new DTODatosFlete();

                for (int i = 0; i < rs.getRowCount(); i++) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("recorro recordset, puntero: " + i);
                    
                    if (rs.getValueAt(i, 0)!=null)
                     miDto.setSolRecargoFleteLocal((BigDecimal) rs.getValueAt(i, 0));
                    else
                     miDto.setSolRecargoFleteLocal(new BigDecimal("0"));
                     
                    if (rs.getValueAt(i, 1)!=null) 
                      miDto.setSolbaseFleteLocal((BigDecimal) rs.getValueAt(i, 1));
                    else
                      miDto.setSolbaseFleteLocal(new BigDecimal("0"));
                    
                    if (rs.getValueAt(i, 2)!=null)
                      miDto.setMontoFijo((BigDecimal) rs.getValueAt(i, 2));
                    else
                      miDto.setMontoFijo(new BigDecimal("0"));
                    
                    if (rs.getValueAt(i, 3)!=null)
                      miDto.setFleteMinimo((BigDecimal) rs.getValueAt(i, 3));
                    else
                      miDto.setFleteMinimo(new BigDecimal("0"));
                    
                    if (rs.getValueAt(i, 4)!=null)
                      miDto.setFleteMaximo((BigDecimal) rs.getValueAt(i, 4));
                    else
                      miDto.setFleteMaximo(new BigDecimal("0"));
                      
                    if (rs.getValueAt(i, 5)!=null)  
                      miDto.setContraEntrega((BigDecimal) rs.getValueAt(i, 5));
                    else  
                      miDto.setContraEntrega(new BigDecimal("0"));
                    //SCS, protejo........
                    if (rs.getValueAt(i, 6)!=null)
                      miDto.setTasa(new Double(rs.getValueAt(i, 6).toString()));
                    if (rs.getValueAt(i, 7)!=null)
                      miDto.setClasificacion(new Long (rs.getValueAt(i, 7).toString()));
                    if (rs.getValueAt(i, 8)!=null)  
                      miDto.setTipoClasificacion(new Long (rs.getValueAt(i, 8).toString()));
                    if (rs.getValueAt(i, 9)!=null)    
                      miDto.setCodCliente(rs.getValueAt(i, 9).toString());
                    if (rs.getValueAt(i, 10)!=null)      
                      miDto.setCodTipoSolicitud(rs.getValueAt(i, 10).toString());
                      
                    miDto.setOidFlete(UtilidadesBD.convertirALong(rs.getValueAt(i,11)));
                    
                    miArray.add(miDto);
                }
            }
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",(MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception ",e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOPEDIntegracion.obtenerValoreFlete(Long oidSolicitud): Salida ");
        return miArray;
    }

    /**
    * @Autor Hugo Andrés Mansi
    * @fecha 01/09/2004
    *
    */
    public DTOIndicadoresFlete obtenerIndicadoresFlete(Long oidSolicitud, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOPEDIntegracion.obtenerIndicadoresFlete(Long oidSolicitud, Long oidCliente): Entrada ");
        //StringBuffer query = new StringBuffer();
        RecordSet rs;
        DTOIndicadoresFlete miDto = new DTOIndicadoresFlete();
        BelcorpService bs = getBelcorpService();
        /*query.append(
            " 	SELECT CA.OID_SOLI_CABE,CA.IND_EXEN_FLET,TS.IND_SUJE_FLET,MAX(EXP.MAE_IND_EXEN_FLET) MAE_IND_EXEN_FLET 	 ");
        query.append(" 	FROM PED_TIPO_SOLIC_PAIS TS, 	 ");
        query.append(" 	PED_SOLIC_CABEC CA, 	 ");
        query.append(
            " 	(SELECT EX.PAIS_OID_PAIS,EX.IND_EXEN_FLET MAE_IND_EXEN_FLET 	 ");
        query.append(" 	FROM MAE_EXENC_FLETE EX, 	 ");
        query.append(" 	V_MAE_TIPIF_CLIEN TP 	 ");
        query.append(" 	WHERE TP.CLIE_OID_CLIE= " + oidCliente);
        query.append(" 	AND EX.TICL_OID_TIPO_CLIE=TP.TICL_OID_TIPO_CLIE 	 ");
        query.append(
            " 	AND (EX.SBTI_OID_SUBT_CLIE IS NULL OR EX.SBTI_OID_SUBT_CLIE=TP.SBTI_OID_SUBT_CLIE) 	 ");
        query.append(
            " 	AND (EX.TCCL_OID_TIPO_CLAS IS NULL OR EX.TCCL_OID_TIPO_CLAS=TP.TCCL_OID_TIPO_CLASI) 	 ");
        query.append(
            " 	AND (EX.CLAS_OID_CLAS IS NULL OR EX.CLAS_OID_CLAS=TP.CLAS_OID_CLAS) 	 ");
        query.append(" 	) EXP 	 ");
        query.append(" 	WHERE 	 ");
        query.append(" 	CA.OID_SOLI_CABE = " + oidSolicitud);
        query.append(
            " 	AND CA.TSPA_OID_TIPO_SOLI_PAIS=TS.OID_TIPO_SOLI_PAIS 	 ");
        query.append(" 	AND EXP.PAIS_OID_PAIS(+) =CA.PAIS_OID_PAIS 	 ");
        query.append(
            " 	GROUP BY CA.OID_SOLI_CABE,CA.IND_EXEN_FLET,TS.IND_SUJE_FLET 	 ");*/
        ArrayList array = new ArrayList();
        array.add(oidCliente.toString());
        array.add(oidSolicitud.toString());
       
        try {
            //rs = bs.dbService.executeStaticQuery(query.toString());
            rs = bs.dbService.executeProcedure("PQ_PLANI.PED_OBTENER_INDICADORES_FLETE",array);
            if(rs.getValueAt(0,0)==null){
              miDto.setOidSolicitud(null);
            }else{
                    miDto.setOidSolicitud(new Long (rs.getValueAt(0,0).toString()));
            }
            if(rs.getValueAt(0,1)==null){
              miDto.setIndSolicitud(Boolean.FALSE);
            }else{
                if ( new Long(rs.getValueAt(0,1).toString()).longValue() == 0)
                  miDto.setIndSolicitud(new Boolean (false));
                else
                  miDto.setIndSolicitud(new Boolean (true));
            }
            if(rs.getValueAt(0,2)==null){
               miDto.setIndTipoSolicitud(Boolean.FALSE); 
            }else{
               if ( new Long(rs.getValueAt(0,2).toString()).longValue() == 0)
                 miDto.setIndTipoSolicitud(Boolean.FALSE);  
               else
                 miDto.setIndTipoSolicitud(Boolean.TRUE); 
            }
      
            if(rs.getValueAt(0,3)==null){
              miDto.setIndTipoCliExencion(Boolean.FALSE);
            }else{
               if ( new Long(rs.getValueAt(0,3).toString()).longValue() == 0)
                 miDto.setIndTipoCliExencion(Boolean.FALSE);
               else
                 miDto.setIndTipoCliExencion(Boolean.TRUE);
            }

        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",(MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOPEDIntegracion.obtenerIndicadoresFlete(Long oidSolicitud, Long oidCliente): Salida ");
        return miDto;
    }

		    /**
     * Se realiza la siguiente consulta: 
     * 
     * SELECT MM.OID_MONT_MINI,MM.VAL_NIV1,MM.VAL_NIV2,MM.VAL_NIV3,MM.VAL_RECA,MM.VAL_MONT_MINI_NOMI,CA.VAL_PREC_CATA_TOTA_LOCA 
     * FROM 
     * PED_MONTO_MINIM MM, 
     * PED_SOLIC_CABEC CA, 
     * V_MAE_TIPIF_CLIEN TP 
     * WHERE 
     * CA.OID_SOLI_CABE=? (oidSolicitud) 
     * AND MM.TSPA_OID_TIPO_SOLI_PAIS=CA.TSPA_OID_TIPO_SOLI_PAIS 
     * AND MM.TICL_OID_TIPO_CLIE=TP.TICL_OID_TIPO_CLIE 
     * AND (MM.SBTI_OID_SUBT_CLIE IS NULL OR MM.SBTI_OID_SUBT_CLIE=TP.SBTI_OID_SUBT_CLIE) 
     * AND (MM.TCCL_OID_TIPO_CLAS IS NULL OR MM.SBTI_OID_SUBT_CLIE=TP.TCCL_OID_TIPO_CLASI) 
     * AND (MM.CLAS_OID_CLAS IS NULL OR MM.SBTI_OID_SUBT_CLIE=TP.CLAS_OID_CLAS) 
     * 
     * Para cada registro que se obtiene se crea un DTODatosMontoMinimo 
     * 
     * Una vez recorrido todos los registros del recordSet se retorna un arreglo de DTODatosMontoMinimo. (Si la consulta no retorna ningun registro se retorna NULL). 
     */
    public DTODatosMontoMinimo[] obtenerValoresMontoMinimo(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOPEDIntegracion.obtenerValoresMontoMinimo(Long oidSolicitud): Entrada ");
        RecordSet	 	rs;
        BelcorpService 	bs = getBelcorpService();

        try {
            ArrayList array = new ArrayList();
            array.add(oidSolicitud.toString());
            rs = bs.dbService.executeProcedure("PQ_PLANI.PED_OBTENER_VAL_MONTO_MINIMO",array);
            bs = null;
            if (rs.esVacio()) {
                return null;
            } else {
                DTODatosMontoMinimo []dtoDatosMontoMinimo = new DTODatosMontoMinimo[rs.getRowCount()];

                for (int i = 0; i < rs.getRowCount(); i++) {

                    dtoDatosMontoMinimo[i] = new DTODatosMontoMinimo();
                    dtoDatosMontoMinimo[i].setOidMontoMinimo(new Long( rs.getValueAt(i, 0).toString()));					
                    if (rs.getValueAt(i,1)!=null){
                        dtoDatosMontoMinimo[i].setNivel1( new BigDecimal(rs.getValueAt(i,1).toString()));
                    }
                    if (rs.getValueAt(i,2)!=null){
                        dtoDatosMontoMinimo[i].setNivel2( new BigDecimal(rs.getValueAt(i,2).toString()));
                    }
                    if (rs.getValueAt(i,3)!=null){
                        dtoDatosMontoMinimo[i].setNivel3( new BigDecimal(rs.getValueAt(i,3).toString()));
                    }
                    if (rs.getValueAt(i,4)!=null){
                        dtoDatosMontoMinimo[i].setRecargo( new BigDecimal(rs.getValueAt(i,4).toString()));
                    }
                    if (rs.getValueAt(i,5)!=null){
                        dtoDatosMontoMinimo[i].setMontoMinimoNomi( new BigDecimal(rs.getValueAt(i,5).toString()));
                    }
                    if (rs.getValueAt(i,6)!=null){
                        dtoDatosMontoMinimo[i].setSolPreCatalogoTotalLocal( new BigDecimal(rs.getValueAt(i,6).toString()));
                    }
                    
                }
                UtilidadesLog.debug("toDatosMontoMinimo" + dtoDatosMontoMinimo);
                UtilidadesLog.info("DAOPEDIntegracion.obtenerValoresMontoMinimo(Long oidSolicitud): Salida ");
                return dtoDatosMontoMinimo;						
            }
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",(MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }


    /**
     * Se retorna un ArrayList con todos los DTOLimVentaPosicion obtenidos (uno para cada posicion de la solicitud)
     * 
     * CHANGELOG
     * ---------
     * Incidencia MSiCC 20090080 - dmorello, 09/03/2009: Pasa a usar la funcion SQL PED_OBTENER_LIMITE_VENTA2
     */
    public ArrayList obtenerPosicionesLimiteVentas(Long lngOidSolicitud, Long lngOidCliente, Long oidPeriodo, Long idioma) throws MareException {
        UtilidadesLog.info("DAOPEDIntegracion.obtenerPosicionesLimiteVentas(Long lngOidSolicitud, Long lngOidCliente, Long oidPeriodo): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        BelcorpService bs = getBelcorpService();
        
		//doliva -- cambio Optimizacion Logs -- 09/04/2010
		if(log.isDebugEnabled())
			UtilidadesLog.debug("obtenerPosicionesLimiteVentas, para: " + lngOidSolicitud + " " + lngOidCliente + " " + oidPeriodo);
        
        if (idioma == null){
            idioma = ConstantesSEG.IDIOMA_DEFECTO;
        }

        try {
            query.append("SELECT * FROM TABLE (CAST(PED_OBTENER_LIMITE_VENTA2(");
            query.append(oidPeriodo).append(',');
            query.append(lngOidCliente).append(',');
            query.append(lngOidSolicitud).append(',');
            query.append(ConstantesPED.ESTADO_POSICION_ANULADO).append(',');
            query.append(idioma).append(") AS OBJ_PED_OBT_LIMITE_VENTA_TABLE)) ");

        
            rs = bs.dbService.executeStaticQuery(query.toString());
      		  if (rs.getRowCount() > 0) {
                ArrayList lista = new ArrayList(); 
                for (int row = 0; row < rs.getRowCount(); row++) {    
                     DTOLimVentaPosicion dtoLimVentaPosicion = new DTOLimVentaPosicion();
                     dtoLimVentaPosicion.setOidPosicion(new Long(rs.getValueAt(row, 0).toString()));
                     dtoLimVentaPosicion.setNumUniDemandadas(new Long(rs.getValueAt(row, 1).toString()));
                     dtoLimVentaPosicion.setNumUniPorAtender(new Long(rs.getValueAt(row, 2).toString()));
                     dtoLimVentaPosicion.setCodVenta((String) rs.getValueAt(row, 3));
                     dtoLimVentaPosicion.setCodCliente((String) rs.getValueAt(row, 4));
                     dtoLimVentaPosicion.setNumLimVenta(new Long(rs.getValueAt(row, 6).toString()));
                     if (rs.getValueAt(row, 7)!=null){
                        dtoLimVentaPosicion.setDescripcionProducto(rs.getValueAt(row, 7).toString());
                     }else{
                        dtoLimVentaPosicion.setDescripcionProducto("");
                     }
                 
                     lista.add(dtoLimVentaPosicion);
                } // end if
                UtilidadesLog.info("DAOPEDIntegracion.obtenerPosicionesLimiteVentas(Long lngOidSolicitud, Long lngOidCliente, Long oidPeriodo): Salida ");
                return lista; 			
            } // end for		  
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPEDIntegracion.obtenerPosicionesLimiteVentas(Long lngOidSolicitud, Long lngOidCliente, Long oidPeriodo): Salida ");
        return null;
    }

	  //jquiroga - 8/2/2005 - PED Applet
    /*
     * Autor Cortaberria
     * Fecha 25/04/2005
     * Modificacion por incidencia 16918
     */
	  public DTOOID obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona) throws MareException {
  		try {
            UtilidadesLog.info("DAOPEDIntegracion.obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Entrada ");
            DTOOID dtoOID=new DTOOID();
            StringBuffer buf = new StringBuffer();
            BelcorpService bs = BelcorpService.getInstance();
            RecordSet rs;        
         
           /* Modificacion por Performance 13/07/2006 alorenzo */
            
           buf.append(" SELECT MAX (VAL_LIMI_CTRL_VENT) VAL_LIMI_CTRL_VENT ");
           buf.append(" FROM PED_GESTI_STOCK ST, ");
           buf.append("      V_MAE_TIPIF_CLIEN TP, ");
           buf.append("      PRE_OFERT_DETAL CV ");
           buf.append(" WHERE IND_ULTI_NOTI = 1 ");
           buf.append("   AND ST.PERD_OID_PERI = " + oidPeriodo);
           buf.append("   AND CV.VAL_CODI_VENT = '" + codVenta + "' ");
           buf.append("   AND ST.OFDE_OID_DETA_OFER = CV.OID_DETA_OFER ");
           buf.append("   AND VAL_LIMI_CTRL_VENT IS NOT NULL ");
           buf.append("   AND TP.CLIE_OID_CLIE = "+ oidCliente);
           buf.append("   AND ST.TICL_OID_TIPO_CLIE = TP.TICL_OID_TIPO_CLIE ");
           buf.append("   AND ( ST.SBTI_OID_SUBT_CLIE IS NULL OR ST.SBTI_OID_SUBT_CLIE = TP.SBTI_OID_SUBT_CLIE ) ");
           buf.append("   AND ( ST.TCCL_OID_TIPO_CLAS IS NULL OR ST.TCCL_OID_TIPO_CLAS = TP.TCCL_OID_TIPO_CLASI ) ");
           buf.append("   AND ( ST.CLAS_OID_CLAS IS NULL OR ST.CLAS_OID_CLAS = TP.CLAS_OID_CLAS) ");
           buf.append("   AND (ST.ZZON_OID_ZONA IS NULL OR ST.ZZON_OID_ZONA = " + oidZona + ") ");

      /*      
            buf.append("SELECT MAX(VAL_LIMI_CTRL_VENT) VAL_LIMI_CTRL_VENT ");
            buf.append("FROM ZON_ZONA ZO, MAE_CLIEN CL, PRE_OFERT_DETAL CV, ");
            buf.append("(SELECT * FROM PED_GESTI_STOCK ST, V_MAE_TIPIF_CLIEN TP ");
            buf.append("WHERE IND_ULTI_NOTI=1 ");
            buf.append("AND ST.PERD_OID_PERI=" + oidPeriodo + " ");
            buf.append("AND VAL_LIMI_CTRL_VENT is not NULL ");
            buf.append("AND TP.CLIE_OID_CLIE=" + oidCliente + " ");
            buf.append("AND ST.TICL_OID_TIPO_CLIE=TP.TICL_OID_TIPO_CLIE ");
            buf.append("AND (ST.SBTI_OID_SUBT_CLIE IS NULL OR ST.SBTI_OID_SUBT_CLIE=TP.SBTI_OID_SUBT_CLIE) ");
            buf.append("AND (ST.TCCL_OID_TIPO_CLAS IS NULL OR ST.TCCL_OID_TIPO_CLAS =TP.TCCL_OID_TIPO_CLASI) ");
            buf.append("AND (ST.CLAS_OID_CLAS IS NULL OR ST.CLAS_OID_CLAS =TP.CLAS_OID_CLAS)) ST ");
            buf.append("WHERE ");
            buf.append("CV.VAL_CODI_VENT='" + codVenta + "' ");
            buf.append("AND ZO.OID_ZONA=" + oidZona + " ");
            buf.append("AND CL.OID_CLIE=" + oidCliente + " ");
            buf.append("AND ST.OFDE_OID_DETA_OFER=CV.OID_DETA_OFER ");
            buf.append("AND (ST.ZORG_OID_REGI IS NULL OR ST.ZORG_OID_REGI=ZO.ZORG_OID_REGI) ");
            buf.append("AND (ST.ZZON_OID_ZONA IS NULL OR ST.ZZON_OID_ZONA=ZO.OID_ZONA) ");
            buf.append("GROUP BY CV.VAL_CODI_VENT,CL.COD_CLIE,CV.OID_DETA_OFER");
      
      */
      
      /* Fin Modificacion por Performance 13/07/2006 alorenzo */
      
            rs = bs.dbService.executeStaticQuery(buf.toString());
            if ( (! rs.esVacio()) && (rs.getValueAt(0, "VAL_LIMI_CTRL_VENT") != null) ) {
              dtoOID.setOid(new Long(((BigDecimal) rs.getValueAt(0, "VAL_LIMI_CTRL_VENT")).longValue()));
              UtilidadesLog.info("DAOPEDIntegracion.obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Salida ");
            } else {
                dtoOID.setOid(new Long(0));
            }
            UtilidadesLog.info("DAOPEDIntegracion.obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Salida ");
            return dtoOID;

     } catch (MareMiiServiceNotFoundException Me) {
         throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
     } catch (Exception e) {
         throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));	  
     }
  }
  
  
  /**
   * Creado por cambio 20090916.
   * Busca en la tabla PED_DETAL_FLETE el registro correspondiente al OID de flete recibido
   * tal que un importe base flete local recibido se encuentre entre RANGO_INFE y RANG_SUPE
   * y devuelve el campo VALO_MONT_FIJO del registro en cuestion.
   * Si no encuentra registro devuelve null.
   * @author dmorello
   * @since 14-Jul-2009
   */
  public BigDecimal obtenerMontoFijoDetalleFlete(Long oidFlete, BigDecimal impBaseFleteLocal) throws MareException {
      UtilidadesLog.info("DAOPEDIntegracion.obtenerMontoFijoDetalleFlete(Long oidFlete, BigDecimal impBaseFleteLocal): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      StringBuffer query = new StringBuffer();
      
      query.append("SELECT valo_mont_fijo ");
      query.append("  FROM ped_detal_flete d ");
      query.append(" WHERE flet_oid_flet = ").append(oidFlete);
      query.append("   AND rango_infe <= ").append(impBaseFleteLocal);
      query.append("   AND rang_supe >= ").append(impBaseFleteLocal);
      
      RecordSet rs = null;
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.debug("rs: " + rs);
      
      // Se espera que la query devuelva un registro a lo sumo
      BigDecimal montoFijo = null;
      if (rs != null && !rs.esVacio()) {
          montoFijo = (BigDecimal)rs.getValueAt(0,0);
      }
      
      UtilidadesLog.info("DAOPEDIntegracion.obtenerMontoFijoDetalleFlete(Long oidFlete, BigDecimal impBaseFleteLocal): Salida");
      return montoFijo;
  }
}
