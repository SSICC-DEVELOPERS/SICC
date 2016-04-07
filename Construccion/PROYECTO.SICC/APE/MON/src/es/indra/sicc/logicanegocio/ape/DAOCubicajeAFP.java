package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTODatosAgrupacion;
import es.indra.sicc.dtos.ape.DTODatosPallet;
import es.indra.sicc.dtos.ape.DTOImpresionFP;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;


/**
 * @author Rafael Romero
 * @date 26/03/2007
 */
public class DAOCubicajeAFP  {
    public DAOCubicajeAFP() {
    }
    
    /**
     * @Observaciones
     * 30/04/2007 eiraola - Como el campo NUM_AGRUP fue quitado de la tabla 
     *                      APE_LISTA_PICAD_CABEC, se obtiene desde APE_CONFI_LIAFP
     *                      (Cambio Nro 37).
     * 06/08/2007 eiraola - Como APE_CONFI_LIAFP fue desdoblada por algun motivo en Cabecera 
     *                      y Detalle procedo a adaptar la consulta sql dado que genera error.
     * 13/08/2007 eiraola - Se consideran como fuera de pedido a las Listas de picado con
     *                      consolidado en null (ya no cliente en null).
     * 08/10/2007 eiraola - Daba error al filtrar por zonificación, procedo a corregir
     *                      pero en caso de nuevo error deberá replantearse la query en su totalidad.
     */
    public DTOSalida buscarListaPicadoCubicaje(DTOImpresionFP dtoe) throws MareException {
        UtilidadesLog.debug("DAOCubicajeAFP.buscarListaPicadoCubicaje(DTOImpresionFP dtoe): Entrada");
        UtilidadesLog.debug("dtoe: "+dtoe);
        DTOSalida dtos = null;
        StringBuffer query = new StringBuffer();
        //query.append(" ");

        query.append("SELECT   aa.oid_list_pica_cabe OID, aa.cod_list_pica, ");
        query.append("         (SELECT ab.cod_regi ");
        query.append("            FROM zon_regio ab ");
        //query.append("           WHERE ab.oid_regi = (SELECT ac.zorg_oid_regi ");
        //query.append("                                FROM zon_zona ac ");
        //query.append("                               WHERE ac.oid_zona = aa.zzon_oid_zona)) cod_regi, ");
        query.append("           WHERE ab.oid_regi = aa.ZORG_OID_REGI ) cod_regi, "); // Agregado eiraola 08/10/2007
        query.append("         (SELECT ac.cod_zona ");
        query.append("            FROM zon_zona ac ");
        query.append("           WHERE ac.oid_zona = aa.zzon_oid_zona) cod_zona, ");
        query.append("         (SELECT ad.cod_secc ");
        query.append("            FROM zon_secci ad ");
        query.append("           WHERE ad.oid_secc = aa.zscc_oid_secc) cod_secci, ");
        
        // aa.num_agru, BELCORP_04_0047
        // Agrega - Inicio
				//query.append("         aa.num_agrup, ");
        query.append("         aa.num_agru, ");
				// Agrega - Fin 
        
        query.append("         aa.ind_imp1, aa.pall_asig ");
//-- En esta subquery se hacen los calculos sobre el detalle
        //query.append("FROM     (SELECT   a.oid_list_pica_cabe, a.cod_list_pica, a.zzon_oid_zona, ");
        query.append("FROM     (SELECT   a.oid_list_pica_cabe, a.cod_list_pica, a.ZORG_OID_REGI, a.zzon_oid_zona, ");
        query.append("                   a.zscc_oid_secc, a.ind_imp1, ");
        
        // a.num_agru, BELCORP_04_0047
        
        query.append("                   a.num_secu_zona_ruta, a.liar_oid_line_arma, ");
        query.append("                   DECODE (SUM (NVL2 (b.num_caja, 1, 0)), ");
        query.append("                           0, 'N', ");
        query.append("                           DECODE (  COUNT (b.oid_list_pica_deta) - SUM (NVL2 (b.num_caja, 1, 0)), ");
        query.append("                                   0, 'S',  ");
        query.append("								   'P' ) ) pall_asig ");
        // Agrega - Inicio
        //query.append("                   , clfp.num_agrup ");
        query.append("                   , clfp.num_agru ");
        // Agrega - Fin
        query.append("              FROM ape_lista_picad_cabec a, ");
        query.append("                   ape_lista_picad_detal b, ");
        query.append("                   cra_perio d ");
//--     , APE_ETIQU e 
        // Agrega - Inicio
        //query.append("                   , ape_confi_liafp clfp ");
        query.append("                   , APE_CONFI_LIAFP_CABEC clfp ");
        // Agrega - Fin
        query.append("          WHERE    b.lpca_oid_list_pica_cabe = a.oid_list_pica_cabe ");
        //query.append("               AND a.clie_oid_clie IS NULL ");          // Eliminado - eiraola 13/08/2007
        query.append("               AND a.SOCA_OID_SOLI_CABE IS NULL ");       // Agregado  - eiraola 13/08/2007
        //if(dtoe.getOidCentroDistribucion()!=null){
        query.append("               AND a.ccdi_oid_conf_cent_dist = "+dtoe.getOidCentroDistribucion()+" ");
        //}
        if(dtoe.getOidRegion()!=null){
            
            //query.append("               AND (   (    a.num_agru IS NOT NULL ");  BELCORP_04_0047
            
            query.append("                 AND (   (  EXISTS ( ");
            query.append("                               SELECT 1 ");
            //query.append("                                 FROM ape_confi_liafp c ");      // Eliminado - eiraola 08/10/2007
            query.append("                                 FROM APE_CONFI_LIAFP_CABEC c, "); // Agregado  - eiraola 08/10/2007
			query.append("               				   		APE_CONFI_LIAFP_DETAL d ");  // Agregado  - eiraola 08/10/2007
            //query.append("                                WHERE c.liar_oid_line_arma = a.liar_oid_line_arma ");           // Eliminado - eiraola 08/10/2007
            query.append("                                WHERE c.OID_CONF_LAFP_CABE = a.LIAC_OID_CONF_LAFP_CABE ");        // Agregado  - eiraola 08/10/2007
            query.append("                                    AND c.OID_CONF_LAFP_CABE = d.LIAC_OID_CONF_LAFP_CABE ");      // Agregado  - eiraola 08/10/2007
            //query.append("                                  AND c.ccdi_oid_conf_cent_dist = a.ccdi_oid_conf_cent_dist "); // Eliminado - eiraola 08/10/2007
            
            //query.append("                                  AND c.num_agrup = a.num_agru ");  BELCORP_04_0047
            
            //query.append("                                  AND c.zorg_oid_regi = "+dtoe.getOidRegion()+" "); // Eliminado - eiraola 08/10/2007
            query.append("                                    AND d.ZORG_OID_REGI = "+dtoe.getOidRegion()+" "); // Agregado  - eiraola 08/10/2007
                        
            if(dtoe.getOidZona()!=null){
                //query.append("                                  AND c.zzon_oid_zona = "+dtoe.getOidZona()+" "); // Eliminado - eiraola 08/10/2007
                query.append("                                AND (d.ZZON_OID_ZONA IS NULL OR d.ZZON_OID_ZONA = "+dtoe.getOidZona()+") "); // Agregado  - eiraola 08/10/2007
                
            }
            if(dtoe.getOidSeccion()!=null){
                //query.append("                                  AND c.zscc_oid_secc = "+dtoe.getOidSeccion()+" "); // Eliminado - eiraola 08/10/2007
                query.append("                                AND (d.ZSCC_OID_SECC IS NULL OR d.ZSCC_OID_SECC = "+dtoe.getOidSeccion()+") "); // Agregado  - eiraola 08/10/2007
            }
            query.append("                           ) ");
            query.append("                       ) ");
            //query.append("                    OR (    a.num_agru IS NULL ");
            query.append("                    OR ( a.LIAC_OID_CONF_LAFP_CABE IS NULL ");
            //query.append("                         AND EXISTS (SELECT 1 ");
            //query.append("                                      FROM zon_zona f ");
            //query.append("                                     WHERE f.zorg_oid_regi = "+dtoe.getOidRegion()+") ");
            query.append("                         AND a.ZORG_OID_REGI = "+dtoe.getOidRegion() ); // Agregado eiraola 08/10/2007
            if(dtoe.getOidZona()!=null){
                query.append("                        AND a.zzon_oid_zona = "+dtoe.getOidZona()+" ");
            }
            if(dtoe.getOidSeccion()!=null){
                query.append("                        AND a.zscc_oid_secc = "+dtoe.getOidSeccion()+" ");
            }
            query.append("                       ) ");
            query.append("                   ) ");
        }
        //if(dtoe.getFecha()!=null){
        query.append("               AND TRUNC (a.fec_crea) = TRUNC (TO_DATE ('"+(new SimpleDateFormat("ddMMyyyy")).format(dtoe.getFecha())+"', 'DDMMYYYY')) ");
        //}
        query.append("               AND a.perd_oid_peri = d.oid_peri ");
        if(dtoe.getOidMarca()!=null){
            query.append("               AND d.marc_oid_marc = "+dtoe.getOidMarca()+" ");
        }
        if(dtoe.getOidPais()!=null){
            query.append("			     AND d.pais_oid_pais = "+dtoe.getOidPais()+" ");
        }
        if(dtoe.getOidCanal()!=null){
            query.append("               AND d.cana_oid_cana = "+dtoe.getOidCanal()+" ");
        }

//--  AND e.LPCA_OID_LIST_PICA_CABE = a.OID_LIST_PICA_CABE
//--  AND e.CCDI_OID_CONF_CENT_DIST = a.CCDI_OID_CONF_CENT_DIST
//--  AND e.NUM_CAJA = b.NUM_CAJA
			  // Agrega - Inicio
        //query.append("               and a.CAFP_OID_CONF_LAFP = clfp.OID_CONF_LAFP (+) ");
        query.append("               AND a.liac_oid_conf_lafp_cabe = clfp.oid_conf_lafp_cabe(+) ");
        // Agrega - Fin

        query.append("          GROUP BY a.oid_list_pica_cabe, ");
        query.append("                   a.cod_list_pica, ");
        query.append("                   a.ZORG_OID_REGI, ");
        query.append("                   a.zzon_oid_zona, ");
        query.append("                   a.zscc_oid_secc, ");
        //-- query.append("                   a.num_agru, ");
        // Agrega - Inicio
				//query.append("                   clfp.num_agrup, ");
        query.append("                   clfp.num_agru, ");
        // Agrega - Fin
        query.append("                   a.ind_imp1, ");
        query.append("                   a.num_secu_zona_ruta, ");
        query.append("                   a.liar_oid_line_arma) aa ");
        query.append("ORDER BY  "); //--aa.num_secu_zona_ruta
        query.append("         2, 3, 4, 5, 6, (SELECT ae.num_etiq ");
        query.append("                           FROM ape_linea_armad ae ");
        query.append("                          WHERE ae.oid_line_arma = aa.liar_oid_line_arma) ");

        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("DAOCubicajeAFP.buscarListaPicadoCubicaje(DTOImpresionFP dtoe): Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if (rs.esVacio()) {
            UtilidadesLog.debug("DAOCubicajeAFP.buscarListaPicadoCubicaje(DTOImpresionFP dtoe): no hay datos ");				
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.debug("DAOCubicajeAFP.buscarListaPicadoCubicaje(DTOImpresionFP dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
        dtos = new DTOSalida(rs);
        UtilidadesLog.debug("DAOCubicajeAFP.buscarListaPicadoCubicaje(DTOImpresionFP dtoe): Salida");
        return dtos;
    }
    
    public DTOSalida buscarListaDatosPallet(DTOOID dtoe) throws MareException{
        UtilidadesLog.debug("DAOCubicajeAFP.buscarListaDatosPallet(DTOOID dtoe): Entrada");
        UtilidadesLog.debug("dtoe: "+dtoe);
        DTOSalida dtos = null;
        StringBuffer query = new StringBuffer();
        //query.append(" ");

        query.append("SELECT   a.oid_list_pica_deta OID, c.cod_sap, c.des_cort, d.num_anaq, ");
        query.append("         a.num_unid_prod, a.num_caja, a.lpca_oid_list_pica_cabe, ");
        query.append("         a.prod_oid_prod, a.val_line, a.tcem_oid_tipo_caja_emba, ");
        query.append("         a.mcdd_oid_mapa_cent_dist_deta, a.sipi_oid_sist_pica, ");
        query.append("         a.num_codi_posi, a.ind_impr, a.num_unid_pica, ");
        query.append("         a.val_nomb_pica, a.num_unid_cheq, a.val_nomb_cheq ");
        query.append("    FROM ape_lista_picad_detal a, ");
        query.append("         ape_lista_picad_cabec b, ");
        query.append("         mae_produ c, ");
        query.append("         ape_mapa_centr_distr_detal d ");
        query.append("   WHERE a.lpca_oid_list_pica_cabe = b.oid_list_pica_cabe ");
        query.append("     AND c.oid_prod = a.prod_oid_prod ");
        query.append("     AND d.oid_mapa_cent_dist_deta = a.mcdd_oid_mapa_cent_dist_deta ");
        //if(dtoe.getOid()!=null){
        query.append("     AND a.lpca_oid_list_pica_cabe = "+dtoe.getOid()+" ");
        //}
        query.append("ORDER BY 2, 3, 4, 5, 6, 7, 1 ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("DAOCubicajeAFP.buscarListaDatosPallet(DTOOID dtoe): Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if (rs.esVacio()) {
            UtilidadesLog.debug("DAOCubicajeAFP.buscarListaDatosPallet(DTOOID dtoe): no hay datos ");				
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.debug("DAOCubicajeAFP.buscarListaDatosPallet(DTOOID dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
        dtos = new DTOSalida(rs);
        UtilidadesLog.debug("DAOCubicajeAFP.buscarListaDatosPallet(DTOOID dtoe): Salida");
        return dtos;
    }

    public DTOSalida buscarDatosAgrupacion(DTODatosAgrupacion dtoe) throws MareException{
        UtilidadesLog.debug("DAOCubicajeAFP.buscarDatosAgrupacion(DTODatosAgrupacion dtoe): Entrada");
        UtilidadesLog.debug("dtoe: "+dtoe);
        DTOSalida dtos = null;
        StringBuffer query = new StringBuffer();
        //query.append(" ");

        query.append("SELECT a.oid_conf_lafp_cabe OID, c.des_marc, ");
        query.append("       (SELECT d.val_i18n ");
        query.append("          FROM gen_i18n_sicc d ");
        query.append("         WHERE d.attr_enti = 'SEG_CANAL' ");
        query.append("           AND d.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
        query.append("           AND d.val_oid = b.cana_oid_cana) des_cana, ");
        query.append("       b.cod_regi, (SELECT ac.cod_zona ");
        query.append("                      FROM zon_zona ac ");
        query.append("                     WHERE ac.oid_zona = d.zzon_oid_zona) cod_zona, ");
        query.append("       (SELECT ad.cod_secc ");
        query.append("          FROM zon_secci ad ");
        query.append("         WHERE ad.oid_secc = d.zscc_oid_secc) cod_secci ");
        query.append("  FROM ape_confi_liafp_cabec a, zon_regio b, seg_marca c, ape_confi_liafp_detal d ");
        query.append(" WHERE d.zorg_oid_regi = b.oid_regi ");
        query.append("   AND d.liac_oid_conf_lafp_cabe = a.oid_conf_lafp_cabe");
        query.append("   AND b.marc_oid_marc = c.oid_marc ");
        //if(dtoe.getNumeroAgrupacion()!=null){
        query.append("   AND a.num_agru = "+dtoe.getNumeroAgrupacion()+" ");
        //}
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("DAOCubicajeAFP.buscarDatosAgrupacion(DTODatosAgrupacion dtoe): Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if (rs.esVacio()) {
            UtilidadesLog.debug("DAOCubicajeAFP.buscarDatosAgrupacion(DTODatosAgrupacion dtoe): no hay datos ");				
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.debug("DAOCubicajeAFP.buscarDatosAgrupacion(DTODatosAgrupacion dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
        dtos = new DTOSalida(rs);
        UtilidadesLog.debug("DAOCubicajeAFP.buscarDatosAgrupacion(DTODatosAgrupacion dtoe): Salida");
        return dtos;
    }
    /*
    private Long siguienteCodigoPosicion(Long oidCabecera) throws MareException{
        UtilidadesLog.debug("DAOCubicajeAFP.siguienteCodigoPosicion(Long oidCabecera): Entrada");
        UtilidadesLog.debug("oidCabecera: ["+oidCabecera+"]");
        Long nextCodigo = new Long(-1);
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT NVL (MAX (a.num_codi_posi), 0) + 1 sig ");
        query.append("  FROM ape_lista_picad_detal a ");
        query.append(" WHERE lpca_oid_list_pica_cabe = "+oidCabecera+" ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("DAOCubicajeAFP.buscarDatosAgrupacion(DTODatosAgrupacion dtoe): Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        nextCodigo = new Long(((BigDecimal)rs.getValueAt(0,0)).toString());

        UtilidadesLog.debug("DAOCubicajeAFP.siguienteCodigoPosicion(Long oidCabecera): Salida");
        return nextCodigo;
    }
    */

    /**
     * Actualiza el atributo numeroTotalCajas en la ListaPicadoCabecera, 
     * sumando las N cajas asociadas a la cabecera que se encuentran el la entidad 
     * ListaPicadoDetalle
     */
    public void actualizarTotalDatosCajas(Long oidCabecera) throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.actualizarTotalCajas(Long oidCabecera): Entrada");
        
        UtilidadesLog.debug("   - SAP601: oidCabecera = " + oidCabecera);
        StringBuffer update = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        update.append(" UPDATE APE_LISTA_PICAD_CABEC ");
        update.append("    SET NUM_TOTA_CAJA = ( SELECT COUNT(distinct(NUM_CAJA)) ");
        update.append("                            FROM APE_LISTA_PICAD_DETAL lpd ");
        update.append("                           WHERE lpd.LPCA_OID_LIST_PICA_CABE = " + oidCabecera + ")"); 
        update.append("  WHERE OID_LIST_PICA_CABE = " + oidCabecera);
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            UtilidadesLog.debug(" se actualizo " + cantRegActualizados + " registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCubicajeAFP.actualizarTotalCajas(Long oidCabecera): Salida");
    }

    /**
     * Actualiza el campo numero de caja y numero de unidades del producto para el
     * registro de Lista Picado Detalle representado en el parametro de entrada.
     * Retorna el numero de caja anterior a realizar esta actualizacion.
     * @author eiraola
     * @date 09/May/2007
     */
    public RecordSet actualizarDatosPallets(DTODatosPallet dtoDatosPallet) throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.actualizarDatosPallets(dtoDatosPallet): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT lpd.LPCA_OID_LIST_PICA_CABE, lpd.NUM_CAJA, lpd.NUM_UNID_PROD ");
        query.append("   FROM APE_LISTA_PICAD_DETAL lpd ");
        query.append("  WHERE lpd.OID_LIST_PICA_DETA = " + dtoDatosPallet.getOid());
        query.append("    AND lpd.NUM_CAJA IS NOT NULL ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error(" No se pudo realizar la consulta JDBC - actualizarDatosPallets");
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug(" El RecordSet rs: " + rs);
        
        StringBuffer update = new StringBuffer();
        
        update.append(" UPDATE APE_LISTA_PICAD_DETAL ");
        update.append("    SET NUM_CAJA = " + dtoDatosPallet.getNumeroPallet() + ", ");
        update.append("        NUM_UNID_PROD = " + dtoDatosPallet.getUnidadesProducto());
        update.append("  WHERE OID_LIST_PICA_DETA = " + dtoDatosPallet.getOid());
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCubicajeAFP.actualizarDatosPallets(dtoDatosPallet): Salida");
        return rs;
    }

    /**
     * Debe insertar en la entidad ListaPicadoDetalle con los datos recibidos por 
     * parámetro.
     */
    public void insertarDatosPallets(DTODatosPallet dtoDatosPallet, Long oidProducto) 
            throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.insertarDatosPallets(dtoDatosPallet, oidProducto): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append(" INSERT INTO APE_LISTA_PICAD_DETAL lpd ( ");
        update.append("   lpd.OID_LIST_PICA_DETA, ");           // PK
        update.append("   lpd.LPCA_OID_LIST_PICA_CABE, ");      // UK
        update.append("   lpd.NUM_CODI_POSI, ");                // UK (actualmente se genera por Trigger)
        update.append("   lpd.NUM_UNID_PROD, ");                // Not Null
        update.append("   lpd.MCDD_OID_MAPA_CENT_DIST_DETA, "); // Not Null
        update.append("   lpd.SIPI_OID_SIST_PICA, ");           // Not Null
        update.append("   lpd.PROD_OID_PROD, ");                // Not Null
        update.append("   lpd.VAL_LINE, ");
        update.append("   lpd.NUM_CAJA, ");
        update.append("   lpd.IND_IMPR, ");
        update.append("   lpd.NUM_UNID_PICA, ");
        update.append("   lpd.VAL_NOMB_PICA, ");
        update.append("   lpd.NUM_UNID_CHEQ, ");
        update.append("   lpd.VAL_NOMB_CHEQ, ");
        update.append("   lpd.TCEM_OID_TIPO_CAJA_EMBA ");
        update.append(" ) VALUES ( ");
        update.append("   APE_LPDE_SEQ.nextval, ");
        update.append(dtoDatosPallet.getOidCabecera() + ", ");
        update.append(dtoDatosPallet.getCodigoPosicion() + ", ");
        update.append(dtoDatosPallet.getUnidadesProducto() + ", ");
        update.append(dtoDatosPallet.getOidMapaCentroDistribucionDetalle() + ", ");
        update.append(dtoDatosPallet.getOidSistemaPicado() + ", ");
        update.append(oidProducto + ", ");
        update.append(dtoDatosPallet.getValorLinea() + ", ");
        update.append(dtoDatosPallet.getNumeroPallet() + ", ");
        
        if (dtoDatosPallet.getIndicadorImpresion() != null && dtoDatosPallet.getIndicadorImpresion().length() > 0) {
            update.append(" '" + dtoDatosPallet.getIndicadorImpresion().substring(0,1) + "', ");
        } else {
            update.append("null, ");
        }
        update.append(dtoDatosPallet.getUnidadesPicadas() + ", ");
        
        if (dtoDatosPallet.getNombrePicador() != null) {
            update.append(" '" + dtoDatosPallet.getNombrePicador() + "', ");
        } else {
            update.append("null, ");
        }
        update.append(dtoDatosPallet.getUnidadesChequeadas() + ", ");
        
        if (dtoDatosPallet.getNombreChequeador() != null) {
            update.append(" '" + dtoDatosPallet.getNombreChequeador() + "', ");
        } else {
            update.append("null, ");
        }
        update.append(dtoDatosPallet.getOidTipoCajaEmbalaje());
        update.append(" ) ");
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCubicajeAFP.insertarDatosPallets(dtoDatosPallet, oidProducto): Salida");
    }

    /**
     * Recibe numeros de caja de una Lista de Picado cabecera, valida la existencia
     * de etiquetas con dichos numeros (y cabecera) y elimina aquellas etiquetas 
     * de la cabecera que posean numeros de caja no recibidos en la lista de entrada.
     * @author eiraola
     * @date 08/May/2007
     */
    public void eliminarEtiquetas(Long oidListaPicadCabec, ArrayList numerosCaja) throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.eliminarEtiquetas(oidListaPicadCabec, numerosCaja): Entrada");
        
        int cantNumCaja = numerosCaja.size();
        UtilidadesLog.debug(" cantidad de numeros de caja recibidos: " + cantNumCaja);
        
        if (cantNumCaja == 0) {
            UtilidadesLog.info("DAOCubicajeAFP.eliminarEtiquetas(ArrayList arrCabecCaja): Salida (sin datos)");
            return;
        }
        
        // Obtener numeros de caja aun existentes a partir de los originales
        ArrayList numerosCajaExistentes = this.comprobarNumerosCajaExistentes(oidListaPicadCabec, numerosCaja);
        ArrayList numerosCajaInexistentes = new ArrayList();
        Long numCaja;
        
        for (int i = 0; i < cantNumCaja; i++) {
            numCaja = (Long)numerosCaja.get(i);
            if (numCaja != null && !numerosCajaExistentes.contains(numCaja)) {
                numerosCajaInexistentes.add(numCaja);
            }
        }
        
        // Ahora tenemos en 'numerosCajaInexistentes' los numeros de caja que ya 
        // no existen para la lista de picado cabecera procedemos a eliminar las 
        // etiquetas correspondientes
        
        if ( !(numerosCajaInexistentes.size() > 0) ) {
            // Si todos los numeros de caja ya existen en BBDD entonces no eliminamos
            // ninguna etiqueta asociada
            UtilidadesLog.info("DAOCubicajeAFP.eliminarEtiquetas(oidListaPicadCabec, numerosCaja): Salida B");
            return;
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer delete = new StringBuffer();
        delete.append(" DELETE FROM APE_ETIQU eti ");
        delete.append(" WHERE eti.LPCA_OID_LIST_PICA_CABE = " + oidListaPicadCabec);
        delete.append(" AND ( eti.NUM_CAJA IN "+ this.armarListaSql("eti.NUM_CAJA", numerosCajaInexistentes) + " )");
        
        try {
            int cantRegElim = bs.dbService.executeUpdate(delete.toString()); 
            UtilidadesLog.debug("   - se eliminaron " + cantRegElim + " etiquetas");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCubicajeAFP.eliminarEtiquetas(oidListaPicadCabec, numerosCaja): Salida A");
    }

    /**
     * Actualiza o inserta, segun corresponda, las Etiquetas para la nueva asignacion 
     * de numeros de caja en la Lista de Picado.
     * @author eiraola
     * @date 08/May/2007
     * @observaciones
     *       15/Ago/2007 eiraola - Se setea el IND_IMPR a 'N' para las etiquetas que se 
     *                             actualicen.
     */
    public void mantieneEtiquetas(Long oidPais, Long oidListPicaCabec, ArrayList numerosCaja) throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.mantieneEtiquetas(oidPais, oidListPicaCabec, numerosCaja): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        // Obtenemos la cantidad total de cajas
        StringBuffer queryA = new StringBuffer();
        queryA.append(" SELECT lpc.OID_LIST_PICA_CABE, lpc.CCDI_OID_CONF_CENT_DIST, count(DISTINCT NUM_CAJA) AS CANT_CAJAS ");
        queryA.append("   FROM APE_LISTA_PICAD_CABEC lpc, ");
        queryA.append("        APE_LISTA_PICAD_DETAL lpd ");
        queryA.append("  WHERE lpc.OID_LIST_PICA_CABE = " + oidListPicaCabec);
        queryA.append("    AND lpd.LPCA_OID_LIST_PICA_CABE = lpc.OID_LIST_PICA_CABE ");
        queryA.append("  GROUP BY lpc.OID_LIST_PICA_CABE, lpc.CCDI_OID_CONF_CENT_DIST ");
        
        RecordSet rs = null;
        
        Long numTotalCajas = new Long(0);
        Long oidConfCD = null;
        try {
            rs = bs.dbService.executeStaticQuery(queryA.toString());
            UtilidadesLog.debug(" Consulta Total de cajas: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error(" No se pudo realizar la consulta JDBC - numTotalCajas");
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (rs != null && !rs.esVacio()) {
            numTotalCajas = new Long(((BigDecimal)rs.getValueAt(0, "CANT_CAJAS")).longValue());
            UtilidadesLog.debug(" --- La Cantidad total de Cajas de la lista de Picado es: " + numTotalCajas);
            
            oidConfCD = new Long(((BigDecimal)rs.getValueAt(0, "CCDI_OID_CONF_CENT_DIST")).longValue());
        }
        
        
        // Consulta sobre la entidad Etiquetas
        StringBuffer queryB = new StringBuffer();
        queryB.append(" SELECT eti.OID_ETIQ, eti.NUM_ETIQ, eti.NUM_CAJA, eti.NUM_TOTA_CAJA ");
        queryB.append("   FROM APE_ETIQU eti ");
        queryB.append("  WHERE eti.LPCA_OID_LIST_PICA_CABE = " + oidListPicaCabec);
        queryB.append("    AND eti.NUM_CAJA = ");
        String consultaEtiqueta = queryB.toString();
        
        Vector vInsertEtiquetas = new Vector();
        StringBuffer insertEtiqueta;
        ArrayList numerosCajaUpdate = new ArrayList();
        ArrayList numerosCajaInsert = new ArrayList(); // BELC400000635 - dmorello, 05/09/2007
        int cantCajas = numerosCaja.size();
        Long numCaja;
        
        // Recorremos los numeros de caja recibidos para ver si ya existia la etiqueta asociada
        for (int i = 0; i < cantCajas; i++) {
            numCaja = (numerosCaja.get(i) != null) ? (Long)numerosCaja.get(i) : null;
            UtilidadesLog.debug("  -- numeroCaja: " + numCaja);
            
            RecordSet rsExisteEtiq = null;
            
            if (numCaja != null) {
                try {
                    rsExisteEtiq = bs.dbService.executeStaticQuery(consultaEtiqueta + numCaja);
                    
                } catch (Exception e) {
                    UtilidadesLog.error(" No se pudo realizar la consulta JDBC - etiquetas " + numCaja + " - " + i);
                    e.printStackTrace();
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                if (rsExisteEtiq != null && !rsExisteEtiq.esVacio()) { // rsExisteEtiq > 0 (existe)
                    // Actualizar Etiqueta (NUM_TOTA_CAJA)
                    numerosCajaUpdate.add(numCaja);
                    
                } else { // (no existe la etiqueta)
                    // Insertar Etiqueta
                    insertEtiqueta = new StringBuffer();
                    // ALERTA!: APE_ETIQ.NUM_ETIQ  se inserta automatico mediante Trigger
                    insertEtiqueta.append("INSERT INTO APE_ETIQU eti (");
                    insertEtiqueta.append(" eti.OID_ETIQ, "); // -- Not Null
                    insertEtiqueta.append(" eti.NUM_CAJA, "); // -- Not Null
                    insertEtiqueta.append(" eti.NUM_TOTA_CAJA, "); // -- Not Null
                    /* BELC400000635 - dmorello, 05/09/2007
                     * NUM_SECU se seteará posteriormente, luego de generar NUM_ETIQ */
                    //insertEtiqueta.append(" eti.NUM_SECU, "); // -- Null
                    insertEtiqueta.append(" eti.IND_IMPR, "); // -- Not Null
                    insertEtiqueta.append(" eti.PAIS_OID_PAIS, "); // -- Not Null
                    insertEtiqueta.append(" eti.LPCA_OID_LIST_PICA_CABE, "); // -- Not Null
                    insertEtiqueta.append(" eti.CCDI_OID_CONF_CENT_DIST "); // -- Not Null 
                    insertEtiqueta.append(") VALUES (");
                    insertEtiqueta.append(" APE_ETIQ_SEQ.nextval, ");
                    insertEtiqueta.append(numCaja + ", ");
                    insertEtiqueta.append(numTotalCajas + ", ");
                    // Campo APE_ETIQU.NUM_SECU : Ultimos N digitos del numero de etiqueta, 
                    // donde el valor de N = LineaArmado.LongitudNumeroEtiqueta.
                    /* BELC400000635 - dmorello, 05/09/2007
                     * NUM_SECU se seteará posteriormente, luego de generar NUM_ETIQ */
                    //insertEtiqueta.append(
                    //"(SELECT MOD(NUMERO_ETIQUETA, POWER(10, NUM_LONG_NUME_ETIQ)) ULTI_N_DIGI_NUM_ETIQ " +
                    //"   FROM (SELECT la.NUM_LONG_NUME_ETIQ " +
                    //"           FROM APE_LISTA_PICAD_CABEC lpc, " +
                    //"                APE_LINEA_ARMAD la " +
                    //"          WHERE lpc.OID_LIST_PICA_CABE = " + oidListPicaCabec +
                    //"            AND lpc.LIAR_OID_LINE_ARMA = la.OID_LINE_ARMA), " +
	                  // IMPORTANTE!: EL SIGUIENTE SUBSELECT DEBE TENER LA MISMA FUNCIONALIDAD QUE EL TRIGGER 
	                  //"         (SELECT NVL(MAX(NUM_ETIQ), 0) + 1 NUMERO_ETIQUETA " +
                    //"            FROM APE_ETIQU))" +
                    //", ");
                    insertEtiqueta.append("'" + ConstantesAPE.IMPRESION_NO + "', ");
                    insertEtiqueta.append(oidPais + ", ");
                    insertEtiqueta.append(oidListPicaCabec + ", ");
                    insertEtiqueta.append(oidConfCD);
                    insertEtiqueta.append(");");  // Finaliza en ';' pues ejecuta tipo Script de BBDD
                    
                    vInsertEtiquetas.add(insertEtiqueta);
                    numerosCajaInsert.add(numCaja); // BELC400000635 - dmorello, 05/09/2007
                } // fin else
            } // fin if
        } // fin for
        
        
        if (numerosCajaUpdate.size() > 0) {
            UtilidadesLog.debug("*** Ejecutando Update del 'numTotalCajas' e 'impreso' de 'Ape:Etiquetas'");
            try {
                StringBuffer updateEtiquetas = new StringBuffer();
                
                updateEtiquetas.append(" UPDATE APE_ETIQU eti ");
                updateEtiquetas.append("    SET eti.NUM_TOTA_CAJA = " + numTotalCajas + ", ");
                updateEtiquetas.append("        eti.IND_IMPR = '"+ ConstantesAPE.IMPRESION_NO +"' "); // Agregado eiraola 15/08/2007
                updateEtiquetas.append("  WHERE eti.LPCA_OID_LIST_PICA_CABE = " + oidListPicaCabec);
                updateEtiquetas.append("    AND ( eti.NUM_CAJA IN " + this.armarListaSql("eti.NUM_CAJA", 
                        numerosCajaUpdate) + " )");
                
                int cantRegActualizados = bs.dbService.executeUpdate(updateEtiquetas.toString());
                UtilidadesLog.debug(" se actualizaron " + cantRegActualizados + " registros");
            } catch (Exception e) {
                e.printStackTrace();
                throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        if (vInsertEtiquetas.size() > 0) {
            UtilidadesLog.debug("*** Ejecutando Insert de 'Ape:Etiquetas' (masivo)...");
            invocarExecutor(vInsertEtiquetas);
            generarNumerosEtiquetas(oidPais);   // dmorello, 21/08/2007
            generarNumerosSecuenciaEtiquetas(oidPais); // dmorello, 29/09/2009, Cambio 20090839
        }
        
        UtilidadesLog.info("DAOCubicajeAFP.mantieneEtiquetas(oidPais, oidListPicaCabec, numerosCaja): Salida");
    }

    /**
     * [Metodo auxiliar fuera de DMCO]
     * Dado un conjunto de numeros de caja, comprueba si existen para la cabecera 
     * indicada y devuelve una lista con aquellos recibidos como parametro de entrada
     * y validados (en la lista de retorno no estan los numeros de caja inexistentes).
     * Tener en cuenta que aunque se pase null como un numero de caja, no se devolvera
     * dicho valor en la lista de retorno.
     * @author eiraola
     * @date 04/May/2007
     */
    private ArrayList comprobarNumerosCajaExistentes(Long oidListPicadCabec, ArrayList numerosCaja) 
            throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.comprobarNumerosCajaExistentes(oidListPicadCabec, numerosCaja): Entrada");
        ArrayList numerosCajaExistentes = new ArrayList();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        query.append(" SELECT DISTINCT lpd.LPCA_OID_LIST_PICA_CABE, lpd.NUM_CAJA ");
        query.append("   FROM APE_LISTA_PICAD_DETAL lpd ");
        query.append("  WHERE lpd.LPCA_OID_LIST_PICA_CABE = " + oidListPicadCabec);
        query.append("    AND ( lpd.NUM_CAJA IN " + this.armarListaSql("lpd.NUM_CAJA", numerosCaja) +" ) ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("[JDBC] - DAOCubicajeAFP.comprobarNumerosCajaExistentes");
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (rs != null && !rs.esVacio()) {
            int cantReg = rs.getRowCount();
            Long numCaja;
            
            for (int i = 0; i < cantReg; i++) {
                numCaja = new Long(((BigDecimal) rs.getValueAt(i, "NUM_CAJA")).longValue());
                numerosCajaExistentes.add(numCaja); // Agregamos directamente porque consulta tiene DISTINCT
            }
        }
        UtilidadesLog.info("DAOCubicajeAFP.comprobarNumerosCajaExistentes(oidListPicadCabec, numerosCaja): Salida");
        return numerosCajaExistentes;
    }

    /**
     * Crea una lista SQL fragmentada cada 1000 elementos por restriccion del
     * operador IN.
     * Ej.: (1723, 1728,..... 1999) OR cac.clie_oid_clie IN (322, 4545,.....)
     * @author eiraola
     * @date 04/May/2007
     */
    private StringBuffer armarListaSql(String nombreCampo, ArrayList valoresLista) throws MareException {
        StringBuffer fragmentoQuery = new StringBuffer();
        int cantValores = valoresLista.size();
        
        fragmentoQuery.append("(");
                
        for (int i = 0; i < cantValores; i++) {
            if ( (i+1) < cantValores ) {
                if ((i+1)%1000 == 0) {
                    fragmentoQuery.append(valoresLista.get(i) + ") OR "+ nombreCampo +" IN (");
                } else {
                    fragmentoQuery.append(valoresLista.get(i) + ",");
                }
            } else {
                fragmentoQuery.append(valoresLista.get(i));
            }
        }
        fragmentoQuery.append(")");
        
        return fragmentoQuery;
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
     * Ejecuta el procedimiento SQL APE_GENE_NUME_ETIQ pasándole OID de pais
     * @throws es.indra.mare.common.exception.MareException
     * @param oidPais
     * @author dmorello
     * @since 21/08/2007
     */
    private void generarNumerosEtiquetas(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.generarNumerosEtiquetas(Long oidPais): Entrada");
        UtilidadesLog.debug("oidPais: " + oidPais);
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        //String proc = "BEGIN    APE_GENE_NUME_ETIQ(" + oidPais + ");    END;";
        try {
            //bs.dbService.executeUpdate(proc);
            bs.dbService.executeProcedure("APE_GENE_NUME_ETIQ", oidPais.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.info("DAOCubicajeAFP.generarNumerosEtiquetas(Long oidPais): Salida");
    }
    
    /**
     * Genera los secuenciales para las etiquetas cuyos datos recibe por parámetro.
     * Debe ejecutarse a continuación de generarNumerosEtiquetas, ya que los números que genera este metodo
     * son los que utiliza ésta para generar los secuenciales.
     * Creado por BELC400000635 - Solución adoptada por Construcción (no figura en DMCO)
     * @author dmorello
     * @since 05-09-2007
     * 
     * CHANGELOG
     * ---------
     * 29/09/2009 - dmorello, Cambio 20090839 - Los secuenciales son por linea de armado
     */
    private void generarNumerosSecuenciaEtiquetas(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOCubicajeAFP.generarNumerosSecuenciaEtiquetas(Long oidPais): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            bs.dbService.executeProcedure("APE_GENE_SECU_ETIQ", oidPais.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCubicajeAFP.generarNumerosSecuenciaEtiquetas(Long oidPais): Salida");
    }
}