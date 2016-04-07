package es.indra.sicc.cmn.negocio.i18n;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegIdiomData;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import es.indra.mare.common.exception.MareException;

public class DAOI18nMMG {
    public DAOI18nMMG() {
    }
    
    public Vector query(GenDetaSiccData genDetaSiccFrom, GenDetaSiccData genDetaSiccTo, HashMap userProperties) throws MareException
        {
            UtilidadesLog.info("DAOMotivoPremioConsuelo.query(GenDetaSiccData genDetaSiccFrom, GenDetaSiccData genDetaSiccTo, HashMap userProperties): Entrada");
            
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
        
            try {
              bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            query.append(" select i18n.VAL_OID, i18n.IDIO_OID_IDIO, i18n.VAL_I18N ");
            query.append(" from GEN_I18N_SICC_COMUN i18n ");
            query.append(" where i18n.ATTR_ENTI = '" + genDetaSiccFrom.getEnti() + "' ");
            query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
            query.append(" and i18n.VAL_OID = " + genDetaSiccFrom.getEntiPk());
            query.append(" UNION ");
            query.append(" select i18n.VAL_OID, i18n.IDIO_OID_IDIO, i18n.VAL_I18N ");
            query.append(" from GEN_I18N_SICC_PAIS i18n ");
            query.append(" where i18n.ATTR_ENTI = '" + genDetaSiccFrom.getEnti() + "' ");
            query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
            query.append(" and i18n.VAL_OID = " + genDetaSiccFrom.getEntiPk());
            
            try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        
            int cant = rs.getRowCount();
            Vector result = new Vector();
            
            GenDetaSiccData genDetaSiccData = null;
            SegIdiomData segIdiomData = null;
            
            for(int i=0; i < cant; i++){        
             
                genDetaSiccData = new GenDetaSiccData();
                
                genDetaSiccData.setEntiPk(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                
                segIdiomData = new SegIdiomData();            
                segIdiomData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IDIO_OID_IDIO")).toString()));
                genDetaSiccData.setIdioOidIdio(segIdiomData);
                
                genDetaSiccData.setDeta((String)rs.getValueAt(i,"VAL_I18N"));                
                
                result.add(genDetaSiccData);               
               
            }
                   
            UtilidadesLog.info("DAOMotivoPremioConsuelo.query(GenDetaSiccData genDetaSiccFrom, GenDetaSiccData genDetaSiccTo, HashMap userProperties): Salida");
            return result;
            
        }
}
