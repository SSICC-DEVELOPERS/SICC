package es.indra.sicc.logicanegocio.bel;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class MONGestionFormasPagoDetalleBean implements SessionBean  {
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
  }

    public RecordSet obtenerFormasPagoPorPais(DTOBelcorp dto) throws MareException {
      UtilidadesLog.info("MONGestionFormasPagoDetalleBean.obtenerFormasPagoPorPais(DTOBelcorp dto):Entrada");
      
      StringBuffer query = new StringBuffer();
    
      query.append("Select fPago.OID_FORM_PAGO, i18n.VAL_I18N "); 
      query.append("      ,fPago.COD_FORM_PAGO ");  // sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
      query.append(" FROM BEL_FORMA_PAGO fPago, V_GEN_I18N_SICC i18n");
      query.append(" WHERE fPago.PAIS_OID_PAIS = " + dto.getOidPais());
      query.append(" AND fPago.OID_FORM_PAGO = i18n.VAL_OID");
      query.append(" AND i18n.ATTR_ENTI = 'BEL_FORMA_PAGO'");
      query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
      query.append(" ORDER BY i18n.VAL_I18N");

      
      RecordSet rSet = new RecordSet();
      
      BelcorpService belcorpService = null;
    
      try {
           rSet = (RecordSet) belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch (MareException me) {
           throw me;
      } catch (Exception e) {
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }    
      
      UtilidadesLog.info("MONGestionFormasPagoDetalleBean.obtenerFormasPagoPorPais(DTOBelcorp dto):Salida");
      return rSet;
  
  }
    
}