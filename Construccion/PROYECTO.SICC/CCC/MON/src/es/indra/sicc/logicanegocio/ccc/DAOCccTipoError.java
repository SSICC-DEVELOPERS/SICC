package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoErrorData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Vector;

public class DAOCccTipoError {
    public DAOCccTipoError() {
    }
    public Vector query(CccTipoErrorData cccTipoErrorFrom, CccTipoErrorData cccTipoErrorTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
      {
        UtilidadesLog.info("DAOCccTipoError.query(CccTipoErrorData cccTipoErrorFrom, CccTipoErrorData cccTipoErrorTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        if(pageCount == null)
        {
             pageCount = new Integer(1);
        }
        if(pageSize == null)
        {
             pageSize = new Integer(0x7fffffff);
        }
            
        RecordSet rs = new RecordSet();
           
        StringBuffer query = new StringBuffer();
            
        BelcorpService bs;
        try {
             bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                            
       }
       query.append(" SELECT CCC_TIPO_ERROR.OID_ERRO, CCC_TIPO_ERROR.COD_ERRO, ");
       query.append("         V_GEN_I18N_SICC.VAL_I18N ");
       query.append("         FROM CCC_TIPO_ERROR, V_GEN_I18N_SICC ");
       query.append("             WHERE  1 = 1  ");
       if(cccTipoErrorFrom.getCodErro() != null)
       {
          query.append("                AND CCC_TIPO_ERROR.COD_ERRO LIKE  '" + cccTipoErrorFrom.getCodErro() + "'");
       }
       query.append("                   AND  V_GEN_I18N_SICC.ATTR_ENTI = 'CCC_TIPO_ERROR' ");
       query.append("                   AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
       query.append("                   AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("                   AND V_GEN_I18N_SICC.VAL_OID = CCC_TIPO_ERROR.OID_ERRO ");
       if(cccTipoErrorFrom.getDescripcion() != null)
       {
          query.append("                AND V_GEN_I18N_SICC.VAL_I18N LIKE  '" + cccTipoErrorFrom.getDescripcion() +"'");
       }
       if(cccTipoErrorFrom.getId() != null)
       {
          query.append("                AND CCC_TIPO_ERROR.OID_ERRO = " + cccTipoErrorFrom.getId());
       }
        
       try {
                
               rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
            
              ex.printStackTrace();
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        CccTipoErrorData cccTipoError = null;
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
            
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
            
        for(int i=0; i < cant; i++){
            
            if(i < rsSaltar ) {
                  continue;
            }
            if(i < rsMostrar){
               try{
                    cccTipoError = new CccTipoErrorData();
                    cccTipoError.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ERRO")).toString()));
                    cccTipoError.setCodErro((String)rs.getValueAt(i,"COD_ERRO"));
                    cccTipoError.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                    result.add(cccTipoError);
                }catch(Exception ex)
                {
                   ex.printStackTrace();
                   UtilidadesLog.error("ERROR ", ex);
                }
                }else
                {
                  break;
                }
            }    
            UtilidadesLog.debug("result: " + result);
            UtilidadesLog.info("DAOCccTipoError.query(CccTipoErrorData cccTipoErrorFrom, CccTipoErrorData cccTipoErrorTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");      
            return result;
      }
}
