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

package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOParametrosContables;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
//import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.Vector;

import javax.ejb.EJBException;

public class DAOParametrosContables  {
  
  public DAOParametrosContables() {  
  }
    
  /**
  * Obtiene las entidades Procesos que coincidan con el país del dto de entrada 
  */
  public DTOSalida obtenerProcesosPais(DTOBelcorp dtoE) throws MareException{
   UtilidadesLog.info("DAOParametrosContables.obtenerProcesosPais(DTOBelcorp dtoE): Entrada ");
    
      
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
                
        try {
        
        query.append(" SELECT OID_PROC, DES_PROC          ");
        query.append(" FROM CCC_PROCE                     ");
        query.append(" WHERE PAIS_OID_PAIS = " + dtoE.getOidPais().toString());
        query.append(" ORDER BY DES_PROC                  ");
                
         rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
//         UtilidadesLog.debug("recordset " + rs);
        
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
             throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOParametrosContables.obtenerProcesosPais(DTOBelcorp dtoE): Salida ");
        return dtoSalida;
  }
  
  /**
   * Obtiene las entidades CuentasContables que coincidan con el país del dto de entrada 
   */
  public DTOSalida obtenerCuentasContablesPais(DTOBelcorp dtoE) throws MareException{
  UtilidadesLog.info("DAOParametrosContables.obtenerCuentasContablesPais(DTOBelcorp dtoE): Entrada ");
 
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT OID_CUEN_CONT, COD_CUEN_CONT ");
        query.append(" FROM CCC_CUENT_CONTA                ");
        query.append(" WHERE PAIS_OID_PAIS = " + dtoE.getOidPais().toString());
        query.append(" ORDER BY COD_CUEN_CONT               ");
        
//        UtilidadesLog.debug("***** Consulta " + query.toString());        
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
//            UtilidadesLog.debug("recordset " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
             throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        dtoSalida.setResultado(rs);
   
  UtilidadesLog.info("DAOParametrosContables.obtenerCuentasContablesPais(DTOBelcorp dtoE): Salida ");
    return dtoSalida;
  } 
 
 /**
  * Obtiene las entidades Subprocesos que coincidan con el proceso del dto de entrada 
  */
  public DTOSalida obtenerSubProcesosPorProceso(DTOOID dtoE) throws MareException{
  UtilidadesLog.info("DAOParametrosContables.obtenerSubProcesosPorProceso(DTOBelcorp dtoE): Entrada ");
 
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        
        try {        
        query.append(" SELECT OID_SUBP, DES_SUBP     ");
        query.append(" FROM CCC_SUBPR                ");
        query.append(" WHERE CCPR_OID_PROC = " + dtoE.getOid().toString());
        query.append(" ORDER BY DES_SUBP              ");
         
//        UtilidadesLog.debug("***** Consulta " + query.toString());               
        
        rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
//        UtilidadesLog.debug("recordset " + rs);
        
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
             throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        dtoSalida.setResultado(rs); 
 
  UtilidadesLog.info("DAOParametrosContables.obtenerSubProcesosPorProceso(DTOBelcorp dtoE): Salida ");
    return dtoSalida;
  } 
  
 /**
  * Obtiene las entidades ObtencionCuenta que coincidan con el país del dto de entrada  
  */  
  public DTOSalida obtenerObtencionCuenta(DTOBelcorp dtoE) throws MareException{
  UtilidadesLog.info("DAOParametrosContables.obtenerObtencionCuenta(DTOBelcorp dtoE): Entrada ");
  
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        
        try {
        query.append(" SELECT VAL_CODI AS CODIGO,                         ");
        query.append("  (SELECT idio.val_i18n                            ");
        query.append("   FROM v_gen_i18n_sicc idio                       ");
        query.append("   WHERE idio.attr_enti = 'CCC_OBTEN_CUENT'        ");
        query.append("   AND idio.idio_oid_idio = " + dtoE.getOidIdioma().toString());
        query.append("   AND idio.val_oid = OID_OBTE_CUEN) AS descripcion");
        query.append(" FROM CCC_OBTEN_CUENT                              ");
        query.append(" ORDER BY descripcion                              ");
//        UtilidadesLog.debug("***** Consulta " + query.toString());               
        rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
//        UtilidadesLog.debug("recordset " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
             throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        dtoSalida.setResultado(rs); 
 
  UtilidadesLog.info("DAOParametrosContables.obtenerObtencionCuenta(DTOBelcorp dtoE): Salida ");
    return dtoSalida;
  } 
      
  /**
   * Obtiene las entidades ParametrosContables que coincidan con los parámetros de la búsqueda
   */
  public DTOSalida buscarParametrosContables(DTOParametrosContables dtoPC) throws MareException{
  UtilidadesLog.info("DAOParametrosContables.buscarParametrosContables(DTOParametrosContables dto): Entrada ");
    
    DTOSalida dtoSalida = new DTOSalida();
    RecordSet rs = new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros = new Vector();
    String codigoError = null;    
   
    try{       
    consulta.append(" SELECT parametroCont.OID_PARA_CONT OID,  ");
    consulta.append("        proceso.DES_PROC,             ");
    consulta.append("        subproceso.DES_SUBP,          ");
    consulta.append("        parametroCont.VAL_DEBE_HABE,  ");
    //consulta.append("        parametroCont.VAL_OBTE_CUEN,  ");
    consulta.append("        DESC_OBT_CUEN.VAL_OBTE_CUEN,  ");
    consulta.append("        parametroCont.VAL_TEXT_APUN   ");
    consulta.append(" FROM   CCC_PARAM_CONTA parametroCont,  ");
    consulta.append("        CCC_PROCE proceso,  ");
    consulta.append("        CCC_SUBPR subProceso, ");    
    consulta.append("        ( ");
    consulta.append("         SELECT  ");
	  consulta.append("             OB_CUE.VAL_CODI AS CODIGO, ");
    consulta.append(" 	   	      I18N.VAL_I18N AS VAL_OBTE_CUEN  "); 
    consulta.append("         FROM    ");
    consulta.append(" 		        CCC_OBTEN_CUENT OB_CUE,   ");
    consulta.append(" 		        V_GEN_I18N_SICC I18N   ");
    consulta.append("         WHERE   ");
    consulta.append(" 	          I18N.ATTR_ENTI = 'CCC_OBTEN_CUENT' ");
    consulta.append(" 		        AND I18N.ATTR_NUM_ATRI = 1 "); 
    consulta.append(" 		        AND I18N.IDIO_OID_IDIO = "+ dtoPC.getOidIdioma().toString());
    consulta.append(" 		        AND i18n.val_oid = ob_cue.oid_obte_cuen ");
    consulta.append("         ) DESC_OBT_CUEN ");
    consulta.append(" WHERE  subproceso.OID_SUBP = parametroCont.SUBP_OID_SUBP ");
    consulta.append("     AND proceso.OID_PROC = subproceso.CCPR_OID_PROC ");
    consulta.append("     AND parametroCont.VAL_OBTE_CUEN = DESC_OBT_CUEN.CODIGO(+) ");
    
    if (dtoPC.getIndicativoDebeHaber()!= null) {
        consulta.append(" AND parametroCont.VAL_DEBE_HABE  = ? ");
        parametros.add(dtoPC.getIndicativoDebeHaber());
    }
    if (dtoPC.getSubProceso()!= null) {
        consulta.append(" AND parametroCont.SUBP_OID_SUBP  = ? ");
        parametros.add(dtoPC.getSubProceso());
    }
    if (dtoPC.getProceso()!= null) {
          consulta.append(" AND proceso.OID_PROC  = ? ");
					parametros.add(dtoPC.getProceso());
		}
    consulta.append(" ORDER BY 2, 3");
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();	    
    
    // La consulta debe ser paginada
    rs = bs.dbService.executePreparedQuery(UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dtoPC), parametros);      
                
    }catch (Exception e){
          UtilidadesLog.error("DAOParametrosContables.buscarParametrosContables: Exception",e);
         //	this.loguearSql("buscarFormasPagoDetalle",sqlPaginada,parametros);
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));						
     } 
    /*   
     if (rs.esVacio() || rs.getValueAt(0,0) == null) {
             throw new MareException(null, null, 
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }
      */
   
   dtoSalida.setResultado(rs);
   
   UtilidadesLog.info("DAOParametrosContables.buscarParametrosContables(DTOParametrosContables dto): Salida ");
    return dtoSalida;
  } 
  
  
  private BelcorpService getBelcorpService() {
  UtilidadesLog.info("DAOParametrosContables.getBelcorpService(): Entrada ");
        try {
            UtilidadesLog.info("DAOParametrosContables.getBelcorpService(): Salida ");
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " +
                mmsnfe.getMessage(), mmsnfe);
        }
       
  }

  
  
  
}