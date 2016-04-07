package es.indra.sicc.logicanegocio.men;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.men.DTOSFormato;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONGestionMenuBean implements SessionBean  {
    private SessionContext ctx;
    private BelcorpService belcorpService;
	
	public void ejbCreate() {
        UtilidadesLog.info("MONGestionMenuBean.ejbCreate(): Entrada");
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " +
                mmsnfe.getMessage(), mmsnfe);
        }
        
        UtilidadesLog.info("MONGestionMenuBean.ejbCreate(): Salida");
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}

	public DTOSFormato cargaformatosSesion(DTOPais dtoe) throws MareException {
        UtilidadesLog.info("MONGestionMenuBean.cargaformatosSesion(DTOPais dtoe): Entrada");
        
        RecordSet recordSet = null;
        String codigoError;
        StringBuffer query = new StringBuffer();
		DTOSFormato dtos = new DTOSFormato();

//        query.append("select val_form_fech, to_char(num_deci) num_deci, val_sepa_mile, val_sepa_deci, i.val_i18n ");
        query.append("select val_form_fech, val_sepa_mile, val_sepa_deci, i.val_i18n, m.NUM_DECI decimales, ma.NUM_DECI decimalesAlt ");		
        query.append("  from seg_pais p, v_gen_i18n_sicc i, seg_moned m, seg_moned ma  ");
        query.append(" where p.oid_pais = i.val_oid ");
        query.append("   and i.attr_enti = 'SEG_PAIS' ");
        query.append("   and i.attr_num_atri = 1 ");
        query.append("   and i.idio_oid_idio = " + dtoe.getOidIdioma() );
        query.append("   and p.oid_pais = " + dtoe.getPais() );
        query.append("   and p.MONE_OID_MONE = m.OID_MONE ");
        query.append("   and p.MONE_OID_MONE_ALT = ma.OID_MONE  ");

   
        try {
            recordSet = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

		if (recordSet.esVacio() == false){
			dtos.setFormatoFecha( (String) recordSet.getValueAt(0,0) );
			dtos.setSeperadorMiles( (String) recordSet.getValueAt(0,1) );
			dtos.setSeparadorDecimal( (String) recordSet.getValueAt(0,2) );
			dtos.setDescripcion( (String) recordSet.getValueAt(0,3) );
			dtos.setNumeroDeDecimales( recordSet.getValueAt(0,4).toString() );			
			dtos.setNumeroDeDecimalesAlternativa(  recordSet.getValueAt(0,5).toString() );						
		}
		
    UtilidadesLog.info("MONGestionMenuBean.cargaformatosSesion(DTOPais dtoe): Salida");
    return dtos;
	}
}