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
 */
package es.indra.sicc.logicanegocio.mae;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTODataCodigoAnterior;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesPaginacion;
import javax.ejb.EJBException;

public class DAOCodigosAnteriores 
{
  public DAOCodigosAnteriores()
  {
  }
/**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * 25/07/06 - [1] - sbonanno - se modifica segun incidencia DBLG500001006
     */
  public DTOSalida buscarCodigoAnterior(DTODataCodigoAnterior dto) throws MareException {
  
    UtilidadesLog.info(" DAOCodigosAnteriores.buscarCodigoAnterior(DTODataCodigoAnterior): Entrada");
    
    DTOSalida dtos = new DTOSalida();
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    String consultaPaginacion = new String();
    
        query.append("SELECT ROWNUM OID, ");
        query.append(" i18.val_i18n paisnuevo, ");
        query.append(" cli.cod_clie clientenuevo, ");
        query.append(" ca.cod_clie_anti clienteanti, ");
        query.append(" ca.val_sist_proc sistema, ");
        query.append(" ca.PAIS_OID_PAIS, ");	   
        query.append(" cli.OID_CLIE, ");
        query.append(" ca.oid_codi_clie_ante ");
        query.append(" FROM mae_codig_clien_anter ca, ");
        query.append(" mae_clien cli, ");        
        query.append(" v_gen_i18n_sicc i18 ");// [1] query.append(" v_gen_i18n_sicc i18, ");
        //[1] query.append(" seg_pais pa ");
        query.append(" WHERE ");
        query.append(" ca.clie_oid_clie_nuev = cli.oid_clie ");
        query.append(" AND i18.ATTR_ENTI = " +  "'SEG_PAIS'");
        query.append(" AND i18.IDIO_OID_IDIO = " + dto.getOidIdioma());//dto.get(idioma)
        query.append(" AND i18.ATTR_NUM_ATRI = 1");
    
        //query.append(" AND pa.OID_PAIS = ca.PAIS_OID_PAIS");
        query.append(" AND i18.VAL_OID = ca.PAIS_OID_PAIS");
        //[1] query.append(" AND pa.OID_PAIS = cli.PAIS_OID_PAIS");
        
        if (dto.getOidCliente() != null){
            query.append(" AND ca.clie_oid_clie_nuev = " + dto.getOidCliente());  
            
        } else { 
            
            if (dto.getCodigoClienteNuevo() != null){
                query.append(" AND cli.cod_clie = " + dto.getCodigoClienteNuevo());    
                query.append(" AND ca.clie_oid_clie_nuev = cli.OID_CLIE ");
            }
        }
        if (dto.getCodigoClienteAntiguo() != null ) {
            //[1] query.append(" AND ca.oid_codi_clie_ante = " + dto.getCodigoClienteAntiguo());
            query.append(" AND ca.COD_CLIE_ANTI = " + dto.getCodigoClienteAntiguo());
        }
    
        if (dto.getSistemaProcedencia() != null){
            query.append(" AND ca.val_sist_proc = " + "'" + dto.getSistemaProcedencia() + "'");      
        }

        if (dto.getOidPaiscmb() != null) {
            query.append(" AND  ca.PAIS_OID_PAIS = " + dto.getOidPaiscmb());                  
        }
    
        try {
            consultaPaginacion = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);        
            UtilidadesLog.info(" Pase el armarquery"  + consultaPaginacion);
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(consultaPaginacion);
            UtilidadesLog.info(rs.toString());
        
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;            
            UtilidadesLog.error("DAOCodigosAnteriores.buscarCodigoAnterior(DTODataCodigoAnterior): Exception",e);
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(codigoError));
        }
        if (rs.esVacio() || rs.getValueAt(0,0) == null) {            
            UtilidadesLog.error("*******DAOCodigosAnteriores.buscarCodigoAnterior(DTODataCodigoAnterior): No hay datos ");
            throw new MareException(null, null,                                                            
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtos.setResultado(rs);
    
        UtilidadesLog.info(" DAOCodigosAnteriores.buscarCodigoAnterior(DTODataCodigoAnterior): Salida");
    
        return dtos;
  }
  
   private BelcorpService getBelcorpService() {
        try {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }
}