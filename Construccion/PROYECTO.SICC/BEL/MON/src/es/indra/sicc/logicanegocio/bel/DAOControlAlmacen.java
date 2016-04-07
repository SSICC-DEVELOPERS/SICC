/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.bel.DTOControlAlmacen;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.Vector;

/**
 * Autor: Ariel D.
 * fecha: 23/01/2006
 */
public class DAOControlAlmacen  {

private String usuario;

  public DAOControlAlmacen() {
    this.usuario = usuario;
  }
  /**
   * Obtiene las entidades ControlesDeAlmacen que coincidan con los parámetros de la búsqueda  
   * @return RecordSet
   * @param DTOE
   * @exception MareException
   */
  RecordSet buscarControlesAlmacen (DTOControlAlmacen DTOE) throws MareException{
   /**
     Probarlo y si no funciona usar el metodo "crearPaginacion"
     */
    UtilidadesLog.info("DAOControlAlmacen.buscarControlesAlmacen(DTOControlAlmacen DTOE):Entrada");
   
    RecordSet rs = new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		RecordSet resultado = null;
    Vector parametros = new Vector();
    String codigoError = null;    
          
    consulta.append(" SELECT CTRL.OID_CTRL_ALMA OID, GEN_CANAL.VAL_I18N AS DESC_CANA, GEN_ACCES.VAL_I18N AS DESC_ACCE, ");
    consulta.append(" GEN_SBAC.VAL_I18N AS DESC_SUBA, GEN_ALMAC.VAL_I18N AS DESC_ALMA, GEN_PRODU.VAL_I18N AS DESC_PRODU,");
    consulta.append(" CTRL.VAL_STOC_MINI, CTRL.VAL_STOC_MAXI, CTRL.VAL_STOC_REPO,CTRL.IND_ACTI");        
                
    consulta.append(" FROM BEL_CONTR_ALMAC  CTRL, SEG_SUBAC  SBAC, SEG_ACCES  ACCES, "); 
    consulta.append(" V_GEN_I18N_SICC GEN_PRODU, V_GEN_I18N_SICC GEN_ALMAC, V_GEN_I18N_SICC GEN_SBAC,");        
    consulta.append(" V_GEN_I18N_SICC GEN_ACCES, V_GEN_I18N_SICC GEN_CANAL"); 	
          
    consulta.append(" WHERE CTRL.SBAC_OID_SBAC = SBAC.OID_SBAC ");
    consulta.append(" AND	SBAC.ACCE_OID_ACCE = ACCES.OID_ACCE ");
    consulta.append(" AND	GEN_PRODU.ATTR_ENTI = 'MAE_PRODU'");
    consulta.append(" AND	GEN_PRODU.ATTR_NUM_ATRI = 1");
    //consulta.append(" AND	GEN_PRODU.IDIO_OID_IDIO = :IDIOMA");
    consulta.append(" AND	GEN_PRODU.VAL_OID = CTRL.PROD_OID_PROD");
    consulta.append(" AND	GEN_ALMAC.ATTR_ENTI = 'BEL_ALMAC'");
    consulta.append(" AND	GEN_ALMAC.ATTR_NUM_ATRI = 1 ");
    //consulta.append(" AND	GEN_ALMAC.IDIO_OID_IDIO = :IDIOMA");
    consulta.append(" AND	GEN_ALMAC.VAL_OID = CTRL.ALMC_OID_ALMA");
    consulta.append(" AND	GEN_SBAC.ATTR_ENTI = 'SEG_SUBAC'");
    consulta.append(" AND	GEN_SBAC.ATTR_NUM_ATRI = 1");
    //consulta.append(" AND	GEN_SBAC.IDIO_OID_IDIO = :IDIOMA");
    consulta.append(" AND	GEN_SBAC.VAL_OID = CTRL.SBAC_OID_SBAC");
    consulta.append(" AND	GEN_ACCES.ATTR_ENTI = 'SEG_ACCES'");
    consulta.append(" AND	GEN_ACCES.ATTR_NUM_ATRI = 1");
    //consulta.append(" AND	GEN_ACCES.IDIO_OID_IDIO = :IDIOMA ");
    consulta.append(" AND	GEN_ACCES.VAL_OID = SBAC.ACCE_OID_ACCE ");
    consulta.append(" AND	GEN_CANAL.ATTR_ENTI = 'SEG_CANAL'");
    consulta.append(" AND	GEN_CANAL.ATTR_NUM_ATRI = 1 ");
    //consulta.append(" AND	GEN_CANAL.IDIO_OID_IDIO = :IDIOMA");
    consulta.append(" AND	GEN_CANAL.VAL_OID = ACCES.CANA_OID_CANA");
                  
       // (Solo se filtrará por los criterios con valor distinto a Null)     
   if (DTOE.getOidSubacceso()!= null) {
					consulta.append(" AND CTRL.SBAC_OID_SBAC = ? ");
					parametros.add(DTOE.getOidSubacceso());
		}
   if (DTOE.getOidAcceso()!= null) {
					consulta.append(" AND SBAC.ACCE_OID_ACCE = ? ");
					parametros.add(DTOE.getOidAcceso());
	  }
   if (DTOE.getOidCanal()!= null) {
					consulta.append(" AND ACCES.CANA_OID_CANA = ? ");
					parametros.add(DTOE.getOidCanal());
		}        
   if (DTOE.getOidProducto()!= null) {
					consulta.append(" AND CTRL.PROD_OID_PROD = ? ");
					parametros.add(DTOE.getOidProducto());
	  }
   if (DTOE.getStockMinimo()!= null) {
					consulta.append(" AND CTRL.VAL_STOC_MINI = ? ");
					parametros.add(DTOE.getStockMinimo());
		}
   if (DTOE.getStockMaximo()!= null) {
					consulta.append(" AND CTRL.VAL_STOC_MAXI = ? ");
					parametros.add(DTOE.getStockMaximo());
	  }       
   if (DTOE.getStockReposicion()!= null) {
					consulta.append(" AND CTRL.VAL_STOC_REPO = ? ");
					parametros.add(DTOE.getStockReposicion());
		}
        
           /************** AGREGA *******************/
   if (DTOE.getOidAlmacen() != null) {
					consulta.append(" AND	CTRL.ALMC_OID_ALMA = ? ");
					parametros.add(DTOE.getOidAlmacen());
		}
          /************** FIN AGREGA *******************/
           
       /*************** AGREGA ***************/  
   if (DTOE.getOidIdioma() != null) {
					consulta.append(" AND	GEN_PRODU.IDIO_OID_IDIO = ? ");
					parametros.add(DTOE.getOidIdioma());
          
          consulta.append(" AND GEN_ALMAC.IDIO_OID_IDIO = ? ");
					parametros.add(DTOE.getOidIdioma());
          
          consulta.append(" AND	GEN_SBAC.IDIO_OID_IDIO = ? ");
					parametros.add(DTOE.getOidIdioma());
        
        	consulta.append(" AND	GEN_ACCES.IDIO_OID_IDIO = ? ");
					parametros.add(DTOE.getOidIdioma());
           
          consulta.append(" AND	GEN_CANAL.IDIO_OID_IDIO = ? ");
					parametros.add(DTOE.getOidIdioma());
		}  
     /************* FIN AGREGA *************/       
       
       BelcorpService bs = UtilidadesEJB.getBelcorpService();	
             
      try{
          rs = bs.dbService.executePreparedQuery(UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),DTOE), parametros);      
        
      }catch (Exception e){
          UtilidadesLog.error("buscarControlesAlmacen: Exception",e);
         //	this.loguearSql("buscarFormasPagoDetalle",sqlPaginada,parametros);
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));						
       } 
       
        if (rs.esVacio() || rs.getValueAt(0,0) == null) {
             throw new MareException(null, null, 
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
       
    UtilidadesLog.info(" DAOControlAlmacen.buscarControlesAlmacen(DTOControlAlmacen DTOE):Salida ");
    return rs;
  
  }
}