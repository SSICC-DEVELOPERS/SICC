package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;


public class DAOMAE 
{
  public DAOMAE()
  {
  }

	public ArrayList obtenerDireccionesAsociadasaTerritorio (Long oidTerritorio) throws MareException {
  
    UtilidadesLog.info("DAOMAE.obtenerDireccionesAsociadasaTerritorio (Long oidTerritorio): Entrada");
    
        String codigoError;
		RecordSet respuesta;
		BelcorpService bs;        
        StringBuffer buf = new StringBuffer();

		try {
			bs = BelcorpService.getInstance();
		} catch (MareMiiServiceNotFoundException e) {
			codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
		try {
			buf.append("select OID_CLIE_DIRE cantidad from MAE_CLIEN_DIREC ");
			buf.append(" where TERR_OID_TERR = " + oidTerritorio);
            respuesta = bs.dbService.executeStaticQuery(buf.toString());			      
            
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
    
    UtilidadesLog.info("DAOMAE.obtenerDireccionesAsociadasaTerritorio (Long oidTerritorio): Salida");
		return new ArrayList(respuesta.getRecords());
	}

	public Integer  obtenerNumeroConsultorasenZona (Long oidZona) throws MareException {
  
    UtilidadesLog.info("DAOMAE.obtenerNumeroConsultorasenZona (Long oidZona): Entrada");
    
        String codigoError;
		RecordSet respuesta;
		BelcorpService bs;        
        StringBuffer buf = new StringBuffer();

		try {
			bs = BelcorpService.getInstance();
		} catch (MareMiiServiceNotFoundException e) {
			codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		try {

			buf.append("SELECT COUNT(UA.OID) cantidad ");
			buf.append(" FROM ZON_SECCI SEC, ");
			buf.append(" ZON_TERRI_ADMIN TA, ");
			buf.append(" MAE_CLIEN_UNIDA_ADMIN UA ");
			buf.append(" WHERE ");
			buf.append(" SEC.OIDZONA= " + oidZona ); 
			buf.append(" AND SEC.OID_SECC = TA.OID_SECC AND ");
			buf.append(" UA.ZTAD_OID_TERR_ADMI = TA.OID_TERR_ADMI AND ");
			buf.append(" UA.IND_ACTI = 1 ");

           respuesta = bs.dbService.executeStaticQuery(buf.toString());			      
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
    
    UtilidadesLog.info("DAOMAE.obtenerNumeroConsultorasenZona (Long oidZona): Salida");        
		return new Integer(((BigDecimal)respuesta.getValueAt(0, "cantidad")).intValue());        
	}


	public ArrayList obtenerDireccionesAsociadasaTerritorioCliente (Long oidTerr, Long oidCliente) throws MareException {
		return null;
	}

    public Long obtenerOidCliente(String codCliente, Long oidPais)  throws MareException {
    
      UtilidadesLog.info("DAOMAE.obtenerOidCliente(String codCliente, Long oidPais): Entrada");
      
        String codigoError;
		RecordSet respuesta;
		BelcorpService bs;        
        StringBuffer buf = new StringBuffer();
		try {
			bs = BelcorpService.getInstance();
		} catch (MareMiiServiceNotFoundException e) {
			codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		try {
			buf.append(" select OID_CLIE from mae_clien ");
			buf.append(" where COD_CLIE = '"+ codCliente +"' ");
			buf.append(" and PAIS_OID_PAIS = " + oidPais);

           respuesta = bs.dbService.executeStaticQuery(buf.toString());			      
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
		if (respuesta.esVacio()) {
      UtilidadesLog.info("DAOMAE.obtenerOidCliente(String codCliente, Long oidPais): Salida");
			return null;
		} else {
      UtilidadesLog.info("DAOMAE.obtenerOidCliente(String codCliente, Long oidPais): Salida");
			return new Long(((BigDecimal)respuesta.getValueAt(0, "OID_CLIE")).intValue());        			
		}

	} 
}