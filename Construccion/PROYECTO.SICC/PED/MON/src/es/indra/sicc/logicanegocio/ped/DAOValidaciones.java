package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;

import es.indra.sicc.dtos.ped.DTORegistrarSolicitud;


public class DAOValidaciones  {
    public DAOValidaciones() {
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


    public String obtenerAcceso(Long tipoSolicitud) throws MareException{
        
        /*
        Documentation
        Obtiene el acceso asociado al tipo de solicitud recibido 

        Accede a la tabla PED_TIPO_SOLIC filtrando por: 
        - OID_TIPO_SOLI == (Accede a la tabla PED_TIPO_SOLIC_PAIS filtrando por 
        tipoSolicitud y obtiene TSOL_OID_TIPO_SOLI)   y obtiene: 
        - ACCE_OID_ACCE 

        Devuelve ACCE_OID_ACCE
        */
        UtilidadesLog.info("DAOValidaciones.obtenerAcceso(Long tipoSolicitud): Entrada ");
        String codigoAcc = null;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("   SELECT cod_acce   ");
			query.append("     FROM ped_tipo_solic,   ");
			query.append(" 		 seg_acces   ");
			query.append("    WHERE oid_tipo_soli = (SELECT tsol_oid_tipo_soli   ");
			query.append("                             FROM ped_tipo_solic_pais   ");
			query.append("                            WHERE oid_tipo_soli_pais = " + tipoSolicitud + " )  ");
			query.append(" 	AND  acce_oid_acce = oid_acce  ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        codigoAcc = (String)respuesta.getValueAt(0,0);
        UtilidadesLog.info("DAOValidaciones.obtenerAcceso(Long tipoSolicitud): Salida ");
        return codigoAcc;
    }

    public Boolean validarProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso) throws MareException {
        /*
        Documentation
        // Busca el proceso recibido en la secuencia de procesos correspondiente 
        al tipo de solicitud y grupo de procesos recibido 

        Accede a la tabla PED_SECUE_PROCE filtrando por: 
        - TSPA_OID_TIPO_SOLI_PAIS = tipoSolicitud 
        - GRPR_OID_GRUP_PROC = grupoProcesos 
        - PROC_OID_PROC = proceso 
        Si obtiene resultados 
        devuelve True 
        sino 
        devuelve False
        */
        UtilidadesLog.info("DAOValidaciones.validarProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append(" SELECT oid_secu_proc   ");
			query.append("   FROM ped_secue_proce   ");
			query.append("  WHERE tspa_oid_tipo_soli_pais = " +  tipoSolicitud );
			query.append("    AND grpr_oid_grup_proc =  "  + grupoProcesos );
			query.append("    AND proc_oid_proc =  "  + proceso);

            respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOValidaciones.validarProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso): Salida ");
        if (respuesta.esVacio())  
            return Boolean.FALSE;    
        else
            return Boolean.TRUE;
    }

    public Boolean validarRegistroSolicitud (Long cliente, int numeroRegistradas, 
                    int numeroDigitadas, Date fecha1, Date fecha2) throws MareException{
        UtilidadesLog.info("DAOValidaciones.validarRegistroSolicitud (Long cliente, int numeroRegistradas, int numeroDigitadas, Date fecha1, Date fecha2): Entrada ");
        /*
        Documentation
        // Comprueba si existen entradas en registro de solicitud para los parámetros recibidos 

        Accede a la tabla PED_REGIS_SOLIC filtrando por: 
        - CLIE_OID_CLIE = cliente 
        - NUM_REGI = numeroRegistradas 
        - NUM_DIGI = numeroDigitadas 
        - (Accede a la tabla PED_LOTE filtrando por OID_LOTE == PED_REGIS_SOLIC.LOTE_OID_LOTE Y 
        FEC_REGI == fecha1 OR fecha2) 

        Si obtiene resultados 
        devuelve True 
        sino 
        devuelve False
        */
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
        String fecha1Str = sdf.format(fecha1);
        String fecha2Str = sdf.format(fecha2);
		
        BelcorpService bs = getBelcorpService();

		try{
			query.append("  SELECT oid_lote                                             ");
			query.append("    FROM ped_regis_solic, ped_lote                            ");
			query.append("   WHERE clie_oid_clie =    " + cliente);
			query.append("     AND num_regi =   " + numeroRegistradas);
			query.append("     AND num_digi =   " + numeroDigitadas );
			query.append("     AND oid_lote = lote_oid_lote                             ");
			query.append("     AND (   fec_regi = TO_DATE ('" + fecha1Str +  "', 'dd/MM/yyyy')  ");
			query.append("          OR fec_regi = TO_DATE ('" + fecha2Str +  "', 'dd/MM/yyyy')  ");
			query.append("         )                                                    ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOValidaciones.validarRegistroSolicitud (Long cliente, int numeroRegistradas, int numeroDigitadas, Date fecha1, Date fecha2): Salida ");
        if (respuesta.esVacio())  
            return Boolean.FALSE;    
        else
            return Boolean.TRUE;
    }

    public Long obtenerMonedaTipoSolicitud(Long oidTipoSolicitud) throws MareException{
        /*
        Documentation
        // Obtiene la moneda asociada al tipo de solicitud por pais recibido 
        Accede a la tabla PED_TIPO_SOLIC_PAIS filtrando por: 
        - OID_TIPO_SOLI_PAIS == oidTipoSolicitud 
        y obtiene: 
        - MONE_OID_MONE 
        Devuelve MONE_OID_MONE 
        */
        UtilidadesLog.info("DAOValidaciones.obtenerMonedaTipoSolicitud(Long oidTipoSolicitud): Entrada ");
        Long oidMoneda = null;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append(" SELECT mone_oid_mone ");
			query.append("   FROM ped_tipo_solic_pais ");
			query.append("  WHERE oid_tipo_soli_pais =  " + oidTipoSolicitud);
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        BigDecimal oidMonedaBD = (BigDecimal)respuesta.getValueAt(0,0);
        if (oidMonedaBD != null)  {
            oidMoneda = new Long(oidMonedaBD.longValue());
        }
        UtilidadesLog.info("DAOValidaciones.obtenerMonedaTipoSolicitud(Long oidTipoSolicitud): Salida ");
        return oidMoneda;
    }

    public Boolean validarSubacceso(Long tipoSolicitudPais) throws MareException{
        /*
        Documentation
        // Comprueba si existe un subacceso para el acceso y canal del tipo de solicitud por pais recibido 
        Accede a la tabla SEG_SUBAC filtrando por: 
        - ACCE_OID_ACCE == (Accede a la tabla PED_TIPO_SOLIC_PAIS filtrando por OID_TIPO_SOLI_PAIS == tipoSolicitudPais y obtiene TSOL_OID_TIPO_SOLI. 
        Accede a la tabla PED_TIPO_SOLIC filtrando por OID_TIPO_SOLI == PED_TIPO_SOLIC_PAIS.TSOL_OID_TIPO_SOLI y obtiene ACCE_OID_ACCE) 
        y obtiene: 
        - OID_SBAC 
        Si recupera información 
        Devuelve True 
        sino 
        Devuelve False 
        */
        UtilidadesLog.info("DAOValidaciones.validarSubacceso(Long tipoSolicitudPais): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{
			query.append("  SELECT   oid_sbac  ");
			query.append("      FROM seg_subac  ");
			query.append("     WHERE seg_subac.acce_oid_acce =  ");
			query.append("              (SELECT pd.acce_oid_acce  ");
			query.append("                 FROM ped_tipo_solic pd  ");
			query.append("                WHERE pd.oid_tipo_soli = (SELECT pds.tsol_oid_tipo_soli  ");
			query.append("                                            FROM ped_tipo_solic_pais pds  ");
			query.append("                                           WHERE pds.oid_tipo_soli_pais = " + tipoSolicitudPais + " ))  ");
			query.append("  ORDER BY oid_sbac  ");
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOValidaciones.validarSubacceso(Long tipoSolicitudPais): Salida ");
        if (respuesta.esVacio())  
            return Boolean.FALSE;    
        else
            return Boolean.TRUE;
    }

    public Boolean validarSolicitudCliente (Long periodo, Long pais, String cliente, Long tipoSolicitud) throws MareException {
        /*
        Documentation
        El método accede a la tabla PED_SOLIC_CABEC filtrando por: 

        - PERD_OID_PERI = periodo 
        - TSPA_OID_TIPO_SOLI_PAIS = tipoSolicitud 
        - CLIE_OID_CLIE = (Accede a la tabla MAE_CLIEN filtrando por PAIS_OID_PAIS == pais y COD_CLIE == cliente y recupera OID_CLIE) 

        Si recupera datos 
        devuelve True 
        sino 
        devuelve False 
        */        

        UtilidadesLog.info("DAOValidaciones.validarSolicitudCliente (Long periodo, Long pais, String cliente, Long tipoSolicitud): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{
			query.append("  SELECT psc.OID_SOLI_CABE ");
			query.append("    FROM ped_solic_cabec psc ");
			query.append("   WHERE psc.perd_oid_peri =  " + periodo );
			query.append("     AND psc.tspa_oid_tipo_soli_pais =  " + tipoSolicitud);
			query.append("        AND psc.clie_oid_clie =   ");
			query.append("                  (SELECT mae.oid_clie ");
			query.append("                     FROM mae_clien mae ");
			query.append("                    WHERE mae.pais_oid_pais = " + pais);
			query.append("                      AND mae.cod_clie =  '" +  cliente + "' ) ");
        
            respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOValidaciones.validarSolicitudCliente (Long periodo, Long pais, String cliente, Long tipoSolicitud): Salida ");
        if (respuesta.esVacio())  
            return Boolean.FALSE;    
        else
            return Boolean.TRUE;
    }

    public Boolean validarUltimoProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso) throws MareException {
        /*
        Documentation
        // Comprueba si el proceso recibido es el último en la secuencia de procesos correspondiente al tipo de solicitud y grupo de procesos recibido 
        // Para ello, se comprueba que no exista un proceso con oid mayor al recibido 

        Accede a la tabla PED_SECUE_PROCE filtrando por: 
        - TSPA_OID_TIPO_SOLI_PAIS = tipoSolicitud 
        - GRPR_OID_GRUP_PROC = grupoProcesos 
        - PROC_OID_PROC > proceso 

        Si obtiene resultados 
        devuelve False 
        sino 
        devuelve True
        */

        UtilidadesLog.info("DAOValidaciones.validarUltimoProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{
			
      query.append(" SELECT proc_oid_proc  ");   
      query.append(" FROM (SELECT   s.proc_oid_proc  ");   
      query.append("         FROM ped_secue_proce s  ");   
      query.append("        WHERE s.grpr_oid_grup_proc = "  + grupoProcesos);   
      query.append("          AND s.tspa_oid_tipo_soli_pais = " + tipoSolicitud);   
      query.append("     ORDER BY cod_secu DESC)  ");   
      query.append(" WHERE ROWNUM = 1        ");   
      
      respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

		//pperez: 
        UtilidadesLog.info("DAOValidaciones.validarUltimoProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso): Salida ");
        if (respuesta.esVacio())  
            return Boolean.FALSE;    
        else
          if (((BigDecimal)respuesta.getValueAt(0,0)).intValue() == proceso.intValue()) 
              return Boolean.TRUE;
          else
              return Boolean.FALSE;
    }
    
    
    public DTORegistrarSolicitud validarClienteRegistro(Long periodo, DTORegistrarSolicitud dtoe) throws MareException {
    
        // Intenta recuperar información de la tabla Cliente Unidad 
        // Administrativa filtrando por periodo, cliente 
  
        UtilidadesLog.info("DAOValidaciones.validarClienteRegistro(Long periodo, DTORegistrarSolicitud dtoe): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();		
        BelcorpService bs = getBelcorpService();
    
        try {
            query.append("   SELECT DISTINCT reg.zsgv_oid_subg_vent subgerencia_ventas, reg.oid_regi region,    ");
            query.append("          zona.oid_zona zona, cliente.oid_clie cliente    ");
            query.append("     FROM mae_clien_unida_admin cl,    ");
            query.append("          cra_perio p1,    ");
            query.append("          cra_perio p2,    ");
            query.append("          cra_perio pbusqueda,    ");
            query.append("          zon_terri_admin tadm,    ");
            query.append("          zon_secci secc,    ");
            query.append("          zon_zona zona,    ");
            query.append("          zon_regio reg,    ");
            query.append("          mae_clien cliente    ");
            query.append("    WHERE    ");
/* Periodo */
/* Buscamos la unidad administrativa con periodo inicio y periodo fin */
/* que contenga al periodo recibido. */
/* Periodo fin puede ser nulo. En ese caso, utilizamod nvl para asignar la fecha actual */
            query.append("          (p1.oid_peri = cl.perd_oid_peri_fin  OR cl.perd_oid_peri_fin IS NULL)   ");
            query.append("      AND p2.oid_peri = cl.perd_oid_peri_ini    ");
            query.append("      AND pbusqueda.fec_inic >= p2.fec_inic    ");
            query.append("      AND pbusqueda.fec_fina <= NVL (p1.fec_fina, SYSDATE)    ");
/* Cliente */
            query.append("      AND cliente.pais_oid_pais =   " + dtoe.getOidPais());
            query.append("      AND cliente.cod_clie =   '" + dtoe.getCliente() + "'");
            query.append("      AND cl.clie_oid_clie = cliente.oid_clie  ");
            query.append("      AND pbusqueda.oid_peri = " + periodo);
/* Region, zona, sección y territorio */
            query.append("      AND reg.oid_regi = zona.zorg_oid_regi ");
            query.append("      AND zona.oid_zona = secc.zzon_oid_zona ");
            query.append("      AND secc.oid_secc = tadm.zscc_oid_secc ");
            query.append("      AND tadm.oid_terr_admi = cl.ztad_oid_terr_admi ");
/* El cliente debe estar activo */ 
            query.append("      AND cl.IND_ACTI = 1 ");      // BELC300015512 - 31/05/2006

            respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!respuesta.esVacio()) {
            dtoe.setSubgerenciaVentas(new Long(((BigDecimal)respuesta.getValueAt(0,"SUBGERENCIA_VENTAS")).longValue()));
            dtoe.setRegion(new Long(((BigDecimal)respuesta.getValueAt(0,"REGION")).longValue()));
            dtoe.setZona(new Long(((BigDecimal)respuesta.getValueAt(0,"ZONA")).longValue()));
            dtoe.setOidCliente(new Long(((BigDecimal)respuesta.getValueAt(0,"CLIENTE")).longValue()));
            dtoe.setOk(Boolean.TRUE);
        }else{
            dtoe.setOk(Boolean.FALSE);
        }
        UtilidadesLog.info("DAOValidaciones.validarClienteRegistro(Long periodo, DTORegistrarSolicitud dtoe): Salida ");
        return dtoe;

    }

    //jrivas 16/07/2007 FAC-003
    public Long obtenerTipoPrograma(Long oidConcurso, Long tipoSolicitud) throws MareException{

        UtilidadesLog.info("DAOValidaciones.obtenerTipoPrograma(Long oidConcurso, Long tipoSolicitud): Entrada ");
        Long tipoPrograma = null;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

		if (oidConcurso != null) {
            query.append(" SELECT ICTP_OID_TIPO_PROG FROM INC_CONCU_PARAM_GENER ");
            query.append(" WHERE OID_PARA_GRAL = " + oidConcurso );
        } else {
            query.append(" SELECT ICTP_OID_TIPO_PROG FROM PED_TIPOS_SOLIC_PROGR_INCEN ");
            query.append(" WHERE TSPA_OID_TIPO_SOLI_PAIS = " + tipoSolicitud );
        }

		try{
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!respuesta.esVacio() && respuesta.getValueAt(0,0) != null) {
            tipoPrograma = new Long(respuesta.getValueAt(0,0).toString());
        }
        UtilidadesLog.info("DAOValidaciones.obtenerTipoPrograma(Long oidConcurso, Long tipoSolicitud): Salida " + tipoPrograma);
        return tipoPrograma;
    }
    
}
