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
 *
 */
 
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ped.*;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

public class DAODigitacion  {

	public DAODigitacion() {
	}

	private BelcorpService getBelcorpService() throws MareException{

        try {
            BelcorpService bs = BelcorpService.getInstance();
			return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }		
		
	}
	
	public RecordSet obtenerTipoSolicitudDigitacionVD(DTOBelcorp DTOE)
		throws MareException{
        UtilidadesLog.info("DAODigitacion.obtenerTipoSolicitudDigitacionVD(DTOBelcorp DTOE): Entrada ");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("SELECT tsp.oid_tipo_soli_pais, i.val_i18n ");
			query.append("  FROM ped_tipo_solic_pais tsp, ped_tipo_solic ts, v_gen_i18n_sicc i ");
			query.append("  	 , seg_acces a, seg_canal c ");
			query.append(" WHERE tsp.pais_oid_pais = " + DTOE.getOidPais());
			query.append("   AND tsp.ind_pedi_gt_zona = " + ConstantesPED.SI );
			query.append("   AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
			query.append("   AND a.cod_acce <> upper('" + ConstantesSEG.ACCESO_BELCENTER + "')");
			query.append("   AND a.cod_acce <> upper('" + ConstantesSEG.ACCESO_CALLCENTER + "')");
			query.append("   AND i.idio_oid_idio = " + DTOE.getOidIdioma());
			query.append("   AND i.val_oid = ts.OID_TIPO_SOLI ");
			query.append("   AND i.attr_num_atri = 1 ");
			query.append("   AND i.attr_enti = 'PED_TIPO_SOLIC'");
			query.append("   AND ts.acce_oid_acce = a.oid_acce ");
      query.append("   AND a.cana_oid_cana = c.oid_cana ");
			query.append("   AND c.COD_CANA = '" + ConstantesSEG.COD_CANAL_VD+ "'");
		    query.append(" order by 2 ");
		   
			respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAODigitacion.obtenerTipoSolicitudDigitacionVD(DTOBelcorp DTOE): Salida ");
		return respuesta;
	}

	public RecordSet obtenerAccesoFisico(DTOBelcorp DTOE)
		throws MareException{
        UtilidadesLog.info("DAODigitacion.obtenerAccesoFisico(DTOBelcorp DTOE): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

		    query.append("  SELECT af.oid_acce_fisi, i.val_i18n ");
		    query.append("    FROM ped_acces_fisic af, v_gen_i18n_sicc i ");
		    query.append("   WHERE i.idio_oid_idio = " + DTOE.getOidIdioma());
		    query.append("     AND i.val_oid = af.oid_acce_fisi ");
		    query.append("     AND i.attr_num_atri = 1 ");
		    query.append("     AND i.attr_enti = 'PED_ACCES_FISIC' ");
		    query.append("   ORDER BY 2 ");

			respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAODigitacion.obtenerAccesoFisico(DTOBelcorp DTOE): Salida ");
		return respuesta;		
	}
  
	public DTOSalida obtenerTiposSolicitudes(DTOBelcorp DTOE)
		throws MareException{
        UtilidadesLog.info("DAODigitacion.obtenerTiposSolicitudes(DTOBelcorp DTOE): Entrada ");
        DTOSalida dtoS = new DTOSalida();
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{
		    query.append("  SELECT tsp.oid_tipo_soli_pais, i.val_i18n,  ");
		    query.append("  ts.ACCE_OID_ACCE ACCESO, ts.MARC_OID_MARC MARCA, a.CANA_OID_CANA CANAL ");
		    query.append("  FROM ped_tipo_solic_pais tsp, ped_tipo_solic ts, v_gen_i18n_sicc i, seg_acces a  ");
		    query.append("  WHERE tsp.pais_oid_pais = "+DTOE.getOidPais()+" ");
		    query.append("  AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli "); 
		    query.append("  AND i.idio_oid_idio = "+DTOE.getOidIdioma()+" ");
		    query.append("  AND i.val_oid = ts.OID_TIPO_SOLI "); 
		    query.append("  AND i.attr_num_atri = 1  ");
		    query.append("  AND i.attr_enti = 'PED_TIPO_SOLIC' ");
		    query.append("  AND ts.acce_oid_acce = a.oid_acce  ");
		    query.append("  AND ts.IND_CONS = 0 ");
		    query.append("  ORDER BY val_i18n ");  
  

			respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        dtoS.setResultado(respuesta);
        UtilidadesLog.info("DAODigitacion.obtenerTiposSolicitudes(DTOBelcorp DTOE): Salida ");
		return dtoS;		
	}

  
	public RecordSet obtenerTipoDespacho(DTOBelcorp DTOE)
		throws MareException{
        UtilidadesLog.info("DAODigitacion.obtenerTipoDespacho(DTOBelcorp DTOE): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

		    query.append("  SELECT td.oid_tipo_desp, i.val_i18n ");
		    query.append("    FROM ped_tipo_despa td, v_gen_i18n_sicc i ");
		    query.append("   WHERE i.idio_oid_idio = " + DTOE.getOidIdioma());
		    query.append("     AND i.val_oid = td.oid_tipo_desp ");
		    query.append("     AND i.attr_num_atri = 1 ");
		    query.append("     AND i.attr_enti = 'PED_TIPO_DESPA' ");
		    query.append("     AND td.pais_oid_pais = " + DTOE.getOidPais() );
		    query.append("   ORDER BY td.ind_cron desc, i.val_i18n asc ");
			
			respuesta = bs.dbService.executeStaticQuery( query.toString() );
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAODigitacion.obtenerTipoDespacho(DTOBelcorp DTOE): Salida ");
		return respuesta;	
		
	}
	
}