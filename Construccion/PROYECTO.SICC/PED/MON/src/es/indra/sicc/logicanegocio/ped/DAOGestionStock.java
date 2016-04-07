package es.indra.sicc.logicanegocio.ped;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOGestionStock;
import es.indra.sicc.dtos.ped.DTOListaGestionStock;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.BelcorpService;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.util.Hashtable;

public class DAOGestionStock {

    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * 
     * 07/06/2006 - [1] Se modifica por pruebas de performance
     * 11/06/2007 - [2] - Rafael Romero - SiCC20070284 - Se agrega relacion con tabla MAE_PRODUC para recuperar luego la descripcion del producto relacionado al codigo de venta
     */
  public RecordSet obtieneGestionStock( DTOListaGestionStock dto ) throws MareException {
    UtilidadesLog.info("DAOGestionStock.obtieneGestionStock(DTOListaGestionStock dto): Entrada ");
    
    
    BelcorpService bs = null;
    RecordSet rs = null;
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT DISTINCT");
    query.append(" G.OID_GEST_STOC OID,");
    query.append(" G.COD_GEST_STOC ID,");
    query.append(" G.OFDE_OID_DETA_OFER OIDCODIGOVENTA,");
    query.append(" D.VAL_CODI_VENT CODIGOVENTA,");
    query.append(" (SELECT val_i18n ");
    query.append("    FROM gen_i18n_sicc i18 ");
    query.append("   WHERE i18.attr_enti = 'MAE_PRODU' ");
    query.append("     AND i18.attr_num_atri = 1 ");
    query.append("     AND i18.idio_oid_idio = "+dto.getOidIdioma()+" ");
    query.append("     AND i18.val_oid = p.oid_prod) DES_SAP,");
    query.append(" T_CATAL.COD_CATA AS CATALOGO,");
    query.append(" D.NUM_PAGI_CATA NUMPAGINA,");
    query.append(" G.ZORG_OID_REGI OIDREGION,");
    query.append(" T_REGION.DES_REGI AS REGION,");
    query.append(" G.ZZON_OID_ZONA OIDZONA,");
    query.append(" T_ZONA.DES_ZONA AS ZONA,");
    query.append(" G.TICL_OID_TIPO_CLIE OIDTIPOCLIENTE,");
    query.append(" T_TIPO_CLIENTE.VAL_I18N AS TIPOCLIENTE,");
    query.append(" G.SBTI_OID_SUBT_CLIE OIDSUBTIPOCLIENTE,");
    query.append(" T_SUB_TIPO_CLIENTE.VAL_I18N AS SUBTIPOCLIENTE,");
    query.append(" G.TCCL_OID_TIPO_CLAS OIDTIPOCLASIFICACION,");
    query.append(" T_TIPO_CLASIFICACION.VAL_I18N AS TIPOCLASIFICACION,");
    query.append(" G.CLAS_OID_CLAS OIDCLASIFICACION,");
    query.append(" T_CLASIFICACION.VAL_I18N AS CLASIFICACION,");
    query.append(" G.VAL_LIMI_CTRL_VENT LIMITEVENTA,");
    query.append(" G.VAL_UNID CONTROLSTOCK,");
    query.append(" G.VAL_PORC CONTROLSOCKPORCENTUAL,");
    query.append(" G.IND_CTRL_LIQU CONTROLLIQUIDACION,");
    query.append(" G.IND_ULTI_NOTI ULTIMASNOTICIAS");
    
    query.append(" FROM");
    query.append(" PED_GESTI_STOCK G,");
    query.append(" PRE_OFERT_DETAL D,");
    query.append(" PRE_CATAL T_CATAL,");    
    query.append(" MAE_PRODU P,");    
    query.append(" ZON_REGIO T_REGION,");
    query.append(" ZON_ZONA T_ZONA,");
    query.append(" V_GEN_I18N_SICC T_TIPO_CLIENTE,");
    query.append(" V_GEN_I18N_SICC T_SUB_TIPO_CLIENTE,");
    query.append(" V_GEN_I18N_SICC T_TIPO_CLASIFICACION,");
    query.append(" V_GEN_I18N_SICC T_CLASIFICACION");
    
    query.append(" WHERE D.OID_DETA_OFER = G.OFDE_OID_DETA_OFER");

    if( dto != null && dto.getPeriodo() != null ){
      query.append(" AND G.PERD_OID_PERI = " + dto.getPeriodo().toString() ); // valor del dto
    }
    
    query.append(" AND d.prod_oid_prod = p.oid_prod(+) ");
    
    query.append(" AND D.OCAT_OID_CATAL = T_CATAL.OID_CATA(+)");    
    query.append(" AND G.ZORG_OID_REGI = T_REGION.OID_REGI(+)");    
    query.append(" AND G.ZZON_OID_ZONA = T_ZONA.OID_ZONA(+)");
    
    query.append(" AND G.TICL_OID_TIPO_CLIE = T_TIPO_CLIENTE.VAL_OID(+)");
    query.append(" AND T_TIPO_CLIENTE.ATTR_ENTI(+) = 'MAE_TIPO_CLIEN'");
    query.append(" AND T_TIPO_CLIENTE.ATTR_NUM_ATRI(+) = 1");
    query.append(" AND T_TIPO_CLIENTE.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
    
    query.append(" AND G.SBTI_OID_SUBT_CLIE = T_SUB_TIPO_CLIENTE.VAL_OID(+)");
    query.append(" AND T_SUB_TIPO_CLIENTE.ATTR_ENTI(+) = 'MAE_SUBTI_CLIEN'");
    query.append(" AND T_SUB_TIPO_CLIENTE.ATTR_NUM_ATRI(+) = 1");
    query.append(" AND T_SUB_TIPO_CLIENTE.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
    
    query.append(" AND G.TCCL_OID_TIPO_CLAS = T_TIPO_CLASIFICACION.VAL_OID(+)");
    query.append(" AND T_TIPO_CLASIFICACION.ATTR_ENTI(+) = 'MAE_TIPO_CLASI_CLIEN'");
    query.append(" AND T_TIPO_CLASIFICACION.ATTR_NUM_ATRI(+) = 1");
    query.append(" AND T_TIPO_CLASIFICACION.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
    
    query.append(" AND G.CLAS_OID_CLAS = T_CLASIFICACION.VAL_OID(+)");
    query.append(" AND T_CLASIFICACION.ATTR_ENTI(+) = 'MAE_CLASI'");
    query.append(" AND T_CLASIFICACION.ATTR_NUM_ATRI(+) = 1");
    query.append(" AND T_CLASIFICACION.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
    
    //query.append(" AND ROWNUM < 40 "); //  (a) [1]
    if (dto.getCodigoVentaBuscar()!= null){
        query.append(" AND d.VAL_CODI_VENT = '" + dto.getCodigoVentaBuscar() + "'");
    }
    query.append(" ORDER BY G.COD_GEST_STOC");
    
    
   String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto); //[1]


    try {
      bs = BelcorpService.getInstance();
      
      rs = bs.dbService.executeStaticQuery(sqlPaginada);//query.toString());
    } catch(MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("MareMiiServiceNotFoundException: ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    } catch(Exception e) {
        UtilidadesLog.error("Exception: ",e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
/*
    if( rs == null || rs.esVacio() ){
      throw new MareException( new Exception(), UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE ) );
    }
*/
    UtilidadesLog.info("DAOGestionStock.obtieneGestionStock(DTOListaGestionStock dto): Salida ");
    return rs;
  }

/*
  public static void main(String args[]){
    DAOGestionStock dao = new DAOGestionStock();
    DTOListaGestionStock dto = new DTOListaGestionStock();
    dto.setPeriodo(new Long("1"));
    try{
      RecordSet rs = dao.obtieneGestionStock(null);
    }catch(Exception e){}
  }
*/
   
  /**
	* Obtiene las ventas que tienen control de stock para un periodo dado
	* @author MarioBobadilla
	* fecha 24/08/04
	**/
  public RecordSet obtieneVentasStock(Long oidPeriodo, RecordSet solicitudes) throws MareException {
       UtilidadesLog.info("DAOGestionStock.obtieneVentasStock(Long oidPeriodo): Entrada ");
	   BelcorpService bs = null;
	   StringBuffer query = new StringBuffer();
       RecordSet rs;

	   try{
	        query.append( "SELECT ");
			query.append( "B.val_codi_vent venta, ");
			query.append( "A.val_porc porcentaje, ");
			query.append( "A.val_unid unidades, ");
			query.append( "A.zorg_oid_regi region, ");
			query.append( "A.zzon_oid_zona zona, ");
			query.append( "A.ticl_oid_tipo_clie tipocliente, ");
			query.append( "A.sbti_oid_subt_clie subtipocliente, ");
			query.append( "A.tccl_oid_tipo_clas tipoclasificacion, ");
			query.append( "A.clas_oid_clas clasificacion ");

			query.append( "FROM ");
			query.append( "ped_gesti_stock A,"); 
			query.append( "pre_ofert_detal B ");

			query.append( "WHERE ");
			query.append( "A.perd_oid_peri = " + oidPeriodo  + " AND ");
			query.append( "(A.val_porc IS NOT NULL OR ");
			query.append( "A.val_unid IS NOT NULL) AND ");
			query.append( "B.oid_deta_ofer = A.ofde_oid_deta_ofer ");
            
            if (solicitudes.getValueAt(0,"REGION")!=null){
                query.append( "and (a.zorg_oid_regi is null or a.zorg_oid_regi = "+solicitudes.getValueAt(0,"REGION").toString()+") ");
            }
            if (solicitudes.getValueAt(0,"ZONA")!=null){
                query.append( "and (a.zzon_oid_zona is null or a.zzon_oid_zona = "+solicitudes.getValueAt(0,"ZONA").toString()+") ");
            }
            if (solicitudes.getValueAt(0,"TIPOCLIENTE")!=null){
                query.append( "and (a.ticl_oid_tipo_clie is null or a.ticl_oid_tipo_clie = "+solicitudes.getValueAt(0,"TIPOCLIENTE").toString()+") ");
            }
            if (solicitudes.getValueAt(0,"SUBTIPOCLIENTE")!=null){
                query.append( "and (a.sbti_oid_subt_clie is null or a.sbti_oid_subt_clie = "+solicitudes.getValueAt(0,"SUBTIPOCLIENTE").toString()+") ");
            }
            if (solicitudes.getValueAt(0,"TIPOCLASIFICACION")!=null){
                query.append( "and (a.tccl_oid_tipo_clas is null or a.tccl_oid_tipo_clas = "+solicitudes.getValueAt(0,"TIPOCLASIFICACION").toString()+") ");
            }
            if (solicitudes.getValueAt(0,"CLASIFICACION")!=null){
                query.append( "and (a.clas_oid_clas is null or a.clas_oid_clas = "+solicitudes.getValueAt(0,"CLASIFICACION").toString()+") ");
            }
			bs = BelcorpService.getInstance();
			rs = bs.dbService.executeStaticQuery(query.toString());

	   }catch (Exception e) {
            
 
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException ",((MareException) e));
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
	   }
       UtilidadesLog.info("DAOGestionStock.obtieneVentasStock(Long oidPeriodo): Salida ");
	   return rs;
		
	}

  /**
	* Obtiene las ventas que tienen control de liquidación para un periodo dado.
	* @author Guido Pons
	* fecha 26/08/04
	**/
  public RecordSet obtieneVentasLiquidacion(Long oidPeriodo) throws MareException {
  	 try{
          UtilidadesLog.info("DAOGestionStock.obtieneVentasLiquidacion(Long oidPeriodo): Entrada");
          StringBuffer query = new StringBuffer();
          BelcorpService bs = BelcorpService.getInstance();
          RecordSet rs;

          query.append("SELECT ");
        	query.append("B.val_codi_vent venta, ");
          query.append("A.zorg_oid_regi region, ");
    			query.append("A.zzon_oid_zona zona, ");
    			query.append("A.ticl_oid_tipo_clie tipocliente, ");
        	query.append("A.sbti_oid_subt_clie subtipocliente, " );
          query.append("A.tccl_oid_tipo_clas tipoclasificacion, ");
          query.append("A.clas_oid_clas clasificacion ");
          query.append("FROM ");
          query.append("ped_gesti_stock A, ");
          query.append("pre_ofert_detal B ");
          query.append("WHERE ");
          query.append("A.perd_oid_peri = " + oidPeriodo + " AND ");
          query.append("A.ind_ctrl_liqu = " + ConstantesCMN.VAL_TRUE + " AND "); 
          query.append("B.oid_deta_ofer = A.ofde_oid_deta_ofer ");

          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.info("DAOGestionStock.obtieneVentasLiquidacion(Long oidPeriodo): Salida ");          
          return rs;
     } catch (MareMiiServiceNotFoundException Me) {
         UtilidadesLog.error("MareMiiServiceNotFoundException: ",Me);
         throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
     }catch (Exception e) {
        UtilidadesLog.error("Exception: ",e);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));	  
     }
	}
  
 /**
	* Obtiene las ventas que tienen límite de control de ventas para un periodo dado.
	* @author Guido Pons
	* fecha 26/08/04
	**/
  public RecordSet obtieneVentasPeriodo(Long oidPeriodo) throws MareException {
        try{
          UtilidadesLog.info("DAOGestionStock.obtieneVentasPeriodo(Long oidPeriodo): Entrada ");
          StringBuffer query = new StringBuffer();
          BelcorpService bs = BelcorpService.getInstance();
          RecordSet rs;

          query.append("SELECT ");
          query.append("C.cod_cata catalogo, "); 
          query.append("B.num_pagi_cata paginacatalogo, "); 
          query.append("B.val_codi_vent venta, ");
          query.append("A.zorg_oid_regi region, ");
          query.append("A.zzon_oid_zona zona, ");
          query.append("A.ticl_oid_tipo_clie tipocliente, "); 
          query.append("A.sbti_oid_subt_clie subtipocliente, ");
          query.append("A.tccl_oid_tipo_clas tipoclasificacion, ");
          query.append("A.clas_oid_clas clasificacion ");
          query.append("FROM ");
          query.append("ped_gesti_stock A, "); 
          query.append("pre_ofert_detal B, ");
          query.append("pre_catal C ");
          query.append("WHERE ");
          query.append("A.perd_oid_peri = " + oidPeriodo + " AND "); 
          query.append("A.val_limi_ctrl_vent IS NOT NULL AND "); 
          query.append("B.oid_deta_ofer = A.ofde_oid_deta_ofer AND "); 
          query.append("C.oid_cata = B.ocat_oid_catal "); 
          query.append("ORDER BY ");
          query.append("C.cod_cata, ");
          query.append("B.num_pagi_cata ");

          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.info("DAOGestionStock.obtieneVentasPeriodo(Long oidPeriodo): Salida ");
          return rs;

        } catch (MareMiiServiceNotFoundException Me) {
          UtilidadesLog.error("MareMiiServiceNotFoundException: ",Me);
          throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }catch (Exception e) {
          UtilidadesLog.error("Exception: ",e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));	  
        }	
    }

	//jquiroga - 8/2/2004 - PED Applet
    public RecordSet obtieneVentasStock2(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona) throws MareException {
        try{
            UtilidadesLog.info("DAOGestionStock.obtieneVentasStock2(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Entrada");
            BelcorpService bs = null;
            StringBuffer query = new StringBuffer();
            RecordSet rs;
            
            
             /* Modificacion por Performance 13/07/2006 alorenzo */
            
            query.append( " SELECT A.VAL_PORC PORCENTAJE, A.VAL_UNID UNIDADES  ");
            query.append( " FROM PED_GESTI_STOCK A,  ");
            query.append( "      PRE_OFERT_DETAL B,  ");
            query.append( "      V_MAE_TIPIF_CLIEN C ");
            query.append( " WHERE A.PERD_OID_PERI = " + oidPeriodo );
            query.append( "   AND (A.VAL_PORC IS NOT NULL OR A.VAL_UNID IS NOT NULL) ");
            query.append( "   AND B.OID_DETA_OFER = A.OFDE_OID_DETA_OFER ");
            query.append( "   AND B.VAL_CODI_VENT = '" + codVenta + "' ");
            query.append( "   AND C.CLIE_OID_CLIE =  " + oidCliente );
            query.append( "   AND ( A.TICL_OID_TIPO_CLIE IS NULL OR C.TICL_OID_TIPO_CLIE = A.TICL_OID_TIPO_CLIE) ");
            query.append( "   AND ( A.SBTI_OID_SUBT_CLIE IS NULL OR C.SBTI_OID_SUBT_CLIE = A.SBTI_OID_SUBT_CLIE) ");
            query.append( "   AND ( A.TCCL_OID_TIPO_CLAS IS NULL OR C.TCCL_OID_TIPO_CLASI = A.TCCL_OID_TIPO_CLAS) ");
            query.append( "   AND (A.CLAS_OID_CLAS IS NULL OR C.CLAS_OID_CLAS = A.CLAS_OID_CLAS) ");
            query.append( "   AND (A.ZZON_OID_ZONA IS NULL OR A.ZZON_OID_ZONA = " + oidZona + ") ");


            /*
            query.append( "SELECT ");
            query.append( "A.val_porc porcentaje, A.val_unid unidades ");
            query.append( "FROM ");
            query.append( "ped_gesti_stock A, pre_ofert_detal B, v_mae_tipif_clien C, zon_zona D "); 
            query.append( "WHERE ");
            query.append( "A.perd_oid_peri = " + oidPeriodo  + " AND ");
            query.append( "(A.val_porc IS NOT NULL OR A.val_unid IS NOT NULL) AND ");
            query.append( "B.oid_deta_ofer = A.ofde_oid_deta_ofer AND B.val_codi_vent = '"+codVenta+"' AND ");
            query.append( "C.clie_oid_clie = " + oidCliente  + " AND ");
            query.append( "(A.ticl_oid_tipo_clie IS NULL OR C.ticl_oid_tipo_clie = A.ticl_oid_tipo_clie) AND ");
            query.append( "(A.sbti_oid_subt_clie IS NULL OR C.sbti_oid_subt_clie = A.sbti_oid_subt_clie) AND ");
            query.append( "(A.tccl_oid_tipo_clas IS NULL OR C.tccl_oid_tipo_clasi = A.tccl_oid_tipo_clas) AND ");
            query.append( "(A.clas_oid_clas IS NULL OR C.clas_oid_clas = A.clas_oid_clas) AND D.oid_zona = "+oidZona+" AND ");
            query.append( "(A.zzon_oid_zona IS NULL OR D.oid_zona = A.zzon_oid_zona) AND ");
            query.append( "(A.zorg_oid_regi IS NULL OR D.zorg_oid_regi = A.zorg_oid_regi) ");
            */
            
            /* Fin Modificacion por Performance 13/07/2006 alorenzo */
            
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("DAOGestionStock.obtieneVentasStock2(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Salida ");
            return rs;
        } catch (Exception e) { 
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",(MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }
 
  //jquiroga - 8/2/2004 - PED Applet 
    public Integer obtieneVentasLiquidacion2(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona) throws MareException {
        UtilidadesLog.info("DAOGestionStock.obtieneVentasLiquidacion2(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Entrada ");
        try{
            StringBuffer query = new StringBuffer();
            BelcorpService bs = BelcorpService.getInstance();
            RecordSet rs;
            
            /* Modificacion por Performance 13/07/2006 alorenzo */
            
            query.append(" SELECT COUNT (*)");
            query.append(" FROM PED_GESTI_STOCK A,");
            query.append("      PRE_OFERT_DETAL B, ");
            query.append("      V_MAE_TIPIF_CLIEN C  ");
            query.append(" WHERE A.PERD_OID_PERI = " + oidPeriodo );
            query.append("   AND A.IND_CTRL_LIQU = " + ConstantesCMN.VAL_TRUE);
            query.append("   AND B.OID_DETA_OFER = A.OFDE_OID_DETA_OFER");
            query.append("   AND B.VAL_CODI_VENT = '" + codVenta + "'");
            query.append("   AND C.CLIE_OID_CLIE = " + oidCliente);
            query.append("   AND ( A.TICL_OID_TIPO_CLIE IS NULL OR C.TICL_OID_TIPO_CLIE = A.TICL_OID_TIPO_CLIE)");
            query.append("   AND ( A.SBTI_OID_SUBT_CLIE IS NULL OR C.SBTI_OID_SUBT_CLIE = A.SBTI_OID_SUBT_CLIE)");
            query.append("   AND ( A.TCCL_OID_TIPO_CLAS IS NULL OR C.TCCL_OID_TIPO_CLASI = A.TCCL_OID_TIPO_CLAS)");
            query.append("   AND (A.CLAS_OID_CLAS IS NULL OR C.CLAS_OID_CLAS = A.CLAS_OID_CLAS)");
            query.append("   AND (A.ZZON_OID_ZONA IS NULL OR A.ZZON_OID_ZONA = "+ oidZona +")");
            
            /*
            query.append("SELECT COUNT(*) ");
            query.append("FROM ped_gesti_stock A, pre_ofert_detal B, v_mae_tipif_clien C, zon_zona D ");
            query.append("WHERE ");
            query.append("A.perd_oid_peri = " + oidPeriodo + " AND ");
            query.append("A.ind_ctrl_liqu = " + ConstantesCMN.VAL_TRUE + " AND ");
            query.append("B.oid_deta_ofer = A.ofde_oid_deta_ofer AND ");
            query.append("B.val_codi_vent = '" + codVenta + "' AND ");
            query.append("C.clie_oid_clie = " + oidCliente + " AND ");
            query.append("(A.ticl_oid_tipo_clie IS NULL OR C.ticl_oid_tipo_clie = A.ticl_oid_tipo_clie) AND ");
            query.append("(A.sbti_oid_subt_clie IS NULL OR C.sbti_oid_subt_clie = A.sbti_oid_subt_clie) AND ");
            query.append("(A.tccl_oid_tipo_clas IS NULL OR C.tccl_oid_tipo_clasi = A.tccl_oid_tipo_clas) AND ");
            query.append("(A.clas_oid_clas IS NULL OR C.clas_oid_clas = A.clas_oid_clas) AND ");
            query.append("D.oid_zona = " + oidZona + " AND ");
            query.append("(A.zzon_oid_zona IS NULL OR D.oid_zona = A.zzon_oid_zona) AND ");
            query.append("(A.zorg_oid_regi IS NULL OR D.zorg_oid_regi = A.zorg_oid_regi)");
            */
            /* Fin Modificacion por Performance 13/07/2006 alorenzo */
            
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("DAOGestionStock.obtieneVentasLiquidacion2(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Salida ");            
            if (rs.getRowCount()<1){
                return null;
            }
            return new Integer(((BigDecimal)rs.getValueAt(0,0)).intValue());
        } catch (MareMiiServiceNotFoundException Me) {
            UtilidadesLog.error("MareMiiServiceNotFoundException: ",Me);
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));	  
        }
    }
    
    /**
     * Metodo que valida si existe un registro en la lista de gestion de stock
     * Agregado por HRCS. Incidencia S-PED-01
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet Objeto con los resultados
     * @param codVenta Codigo de Venta
     * @param oidPeriodo ID del Periodo
     */
    public RecordSet existeEnListaGestionStock(Long oidPeriodo, DTOGestionStock dto) throws MareException {
        try{
            UtilidadesLog.info("DAOGestionStock.existeEnListaGestionStock(Long oidPeriodo, Long codVenta): Entrada");
            BelcorpService bs = null;
            StringBuffer query = new StringBuffer();
            RecordSet rs;
            
            query.append( " SELECT g.oid_gest_stoc, g.perd_oid_peri, g.ofde_oid_deta_ofer ");
            query.append( " FROM ped_gesti_stock g ");
            query.append( " WHERE  g.perd_oid_peri = " + oidPeriodo );
            query.append( " AND g.ofde_oid_deta_ofer = " + dto.getCodigoVenta() );
            /*
             * Modificado por Rafael Romero - 16/05/2007 - SiCC 20070263
             * Aunque los campos del DTO sean nulos, debe preguntarse 
             * por el valor nulo de los respectivos campos en la BD.
             * La BD soporta valores NULOS en los campos de Zona Geografica
             * y Tipificacion de Cliente
             */
            query.append( " AND g.ZORG_OID_REGI "+((dto.getRegion()!=null) ? ("= " + dto.getRegion().toString()) : "IS NULL"));
            query.append( " and g.ZZON_OID_ZONA "+((dto.getZona()!=null) ? ("= " + dto.getZona().toString()) : "IS NULL"));
            query.append( " and g.SBTI_OID_SUBT_CLIE "+((dto.getSubtipoCliente()!=null) ? ("= " + dto.getSubtipoCliente().toString()) : "IS NULL"));
            query.append( " and g.TCCL_OID_TIPO_CLAS "+((dto.getTipoClasificacion()!=null) ? ("= " + dto.getTipoClasificacion().toString()) : "IS NULL"));
            query.append( " and g.TICL_OID_TIPO_CLIE "+((dto.getTipoCliente()!=null) ? ("= " + dto.getTipoCliente().toString()) : "IS NULL"));
            query.append( " and g.CLAS_OID_CLAS "+((dto.getClasificacion()!=null) ? ("= " + dto.getClasificacion().toString()) : "IS NULL"));
            /*
             * Fin modificacion RRV
             */
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("DAOGestionStock.existeEnListaGestionStock(Long oidPeriodo, Long codVenta): Salida ");
            return rs;
        } catch (Exception e) { 
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",(MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }
}