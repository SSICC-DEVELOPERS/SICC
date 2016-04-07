package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.inc.ErroresDeNegocio;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

public class DAOUnidadesAdministrativas {
    private String user;    
    public DAOUnidadesAdministrativas(){}    
    public DAOUnidadesAdministrativas(String user){this.user = user;}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       28/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida recargaRegionesCliente(DTOUnidadAdministrativa dto) 
		throws MareException{       
		UtilidadesLog.info("DAOUnidadesAdministrativas.recargaRegionesCliente(DTOUnidadAdministrativa dto): Entrada");        
        StringBuffer sb1 = new StringBuffer();
        
        sb1.append(" SELECT DISTINCT REG.OID_REGI, REG.DES_REGI   ");
        sb1.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNADM,   ");
        sb1.append(" ZON_TERRI_ADMIN TERRA,   ");
        sb1.append(" VCA_ZON_SECCI SEC,   ");
        sb1.append(" VCA_ZON_ZONA ZON,   ");
        sb1.append(" VCA_ZON_REGIO REG   ");
        sb1.append(" WHERE 1 = 1  ");
        
        if(dto.getOidCliente()!=null) {
            sb1.append(" AND UNADM.CLIE_OID_CLIE = " + dto.getOidCliente());
        }        

        sb1.append(" AND UNADM.ZTAD_OID_TERR_ADMI = TERRA.OID_TERR_ADMI  ");
        sb1.append(" AND TERRA.ZSCC_OID_SECC = SEC.OID_SECC  ");
        sb1.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA  ");
        sb1.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI  ");
        sb1.append(" AND SEC.COD_USUA = '" + user + "' ");
        sb1.append(" AND ZON.COD_USUA = '" + user + "' ");
        sb1.append(" AND REG.COD_USUA = '" + user + "' ");
        
        if(dto.getOidSGV()!=null) {
            sb1.append(" AND REG.ZSGV_OID_SUBG_VENT = " + dto.getOidSGV());    
        }        

        DTOSalida dtoSalida = new DTOSalida();
		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executeStaticQuery(sb1.toString());
	    }
		catch (Exception e) {
			UtilidadesLog.error(e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }

		dtoSalida.setResultado(rs);        
		UtilidadesLog.info("DAOUnidadesAdministrativas.recargaRegionesCliente(DTOUnidadAdministrativa dto): Salida");
        return dtoSalida;
	}
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       01/12/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
	public DTOSalida recargaZonasCliente(DTOUnidadAdministrativa dto) 
		throws MareException{       
		UtilidadesLog.info("DAOUnidadesAdministrativas.recargaZonasCliente(DTOUnidadAdministrativa dto): Entrada");        
        StringBuffer sb1 = new StringBuffer();
        
        sb1.append(" SELECT DISTINCT ZON.OID_ZONA, ZON.DES_ZONA   ");
        sb1.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNADM,   ");
        sb1.append(" ZON_TERRI_ADMIN TERRA,   ");
        sb1.append(" VCA_ZON_SECCI SEC,   ");
        sb1.append(" VCA_ZON_ZONA ZON   ");
        sb1.append(" WHERE 1=1  ");
        
        if(dto.getOidCliente()!=null) {
            sb1.append(" AND UNADM.CLIE_OID_CLIE = " + dto.getOidCliente());    
        }
		
        sb1.append(" AND UNADM.ZTAD_OID_TERR_ADMI = TERRA.OID_TERR_ADMI   ");
        sb1.append(" AND TERRA.ZSCC_OID_SECC = SEC.OID_SECC   ");
        sb1.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA   ");
        sb1.append(" AND SEC.COD_USUA = '" + user + "'   ");
        sb1.append(" AND ZON.COD_USUA = '" + user + "'   ");
        
        if(dto.getOidRegion()!=null) {
            sb1.append(" AND ZON.ZORG_OID_REGI = " + dto.getOidRegion());    
        }
        
        DTOSalida dtoSalida = new DTOSalida();
		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executeStaticQuery(sb1.toString());
	    }
		catch (Exception e) {
			UtilidadesLog.error(e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }

		dtoSalida.setResultado(rs);                
		UtilidadesLog.info("DAOUnidadesAdministrativas.recargaZonasCliente(DTOUnidadAdministrativa dto): Salida");
        return dtoSalida;
	}
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       28/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida recargaSeccionesCliente(DTOUnidadAdministrativa dto) 
		throws MareException{       
		UtilidadesLog.info("DAOUnidadesAdministrativas.recargaSeccionesCliente(DTOUnidadAdministrativa dto): Entrada");
		StringBuffer sb1 = new StringBuffer();
        
        sb1.append(" SELECT DISTINCT SEC.OID_SECC, SEC.DES_SECCI   ");
        sb1.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNADM,   ");
        sb1.append(" ZON_TERRI_ADMIN TERRA,   ");
        sb1.append(" VCA_ZON_SECCI SEC   ");
        sb1.append(" WHERE 1=1 ");
        
        if(dto.getOidCliente()!=null) {
            sb1.append(" AND UNADM.CLIE_OID_CLIE = " + dto.getOidCliente());    
        }
		
        sb1.append(" AND UNADM.ZTAD_OID_TERR_ADMI = TERRA.OID_TERR_ADMI   ");
        sb1.append(" AND TERRA.ZSCC_OID_SECC = SEC.OID_SECC   ");
        sb1.append(" AND SEC.COD_USUA = '" + user + "'  ");
        
        if(dto.getOidZona()!=null) {
            sb1.append(" AND SEC.ZZON_OID_ZONA = " + dto.getOidZona());    
        }

        DTOSalida dtoSalida = new DTOSalida();
		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executeStaticQuery(sb1.toString());
	    }
		catch (Exception e) {
			UtilidadesLog.error(e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }

		dtoSalida.setResultado(rs);                       
		UtilidadesLog.info("DAOUnidadesAdministrativas.recargaSeccionesCliente(DTOUnidadAdministrativa dto): Salida");
        return dtoSalida;
	}
  
   /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       31/3/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
   public DTOSalida recargaUnidadesAdministrativasCliente(DTOUnidadAdministrativa dtoe) 
    throws MareException {          
        UtilidadesLog.info("DAOUnidadesAdministrativas.recargaUnidadesAdministrativasCliente(DTOUnidadAdministrativa dto): Entrada");
        StringBuffer sb1 = new StringBuffer();
        
        sb1.append(" SELECT ua.oid_clie_unid_admi OID, ua.ind_acti ind_acti, ");
        sb1.append(" r.des_regi || z.des_zona || s.des_secci descrip ");
        sb1.append(" FROM mae_clien_unida_admin ua, ");
        sb1.append(" zon_terri_admin ta, ");
        sb1.append(" zon_secci s, ");
        sb1.append(" zon_zona z, ");
        sb1.append(" zon_regio r ");
        sb1.append(" WHERE ua.clie_oid_clie = " + dtoe.getOidCliente());
        sb1.append(" AND ua.ztad_oid_terr_admi = ta.oid_terr_admi ");
        sb1.append(" AND ta.zscc_oid_secc = s.oid_secc ");
        sb1.append(" AND s.zzon_oid_zona = z.oid_zona ");
        sb1.append(" AND z.zorg_oid_regi = r.oid_regi ");
        
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService;    
		 
        try {
          belcorpService = BelcorpService.getInstance();
          rs = belcorpService.dbService.executeStaticQuery(sb1.toString());
        }
        catch (Exception e) {
          UtilidadesLog.error(e);
	        throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);                       
        UtilidadesLog.info("DAOUnidadesAdministrativas.recargaUnidadesAdministrativasCliente(DTOUnidadAdministrativa dto): Salida");
        return dtoSalida;   
    }   
}