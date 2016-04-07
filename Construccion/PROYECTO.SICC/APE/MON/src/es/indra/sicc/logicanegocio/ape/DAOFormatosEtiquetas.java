package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODatosEtiqueta;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesPaginacion;

public class DAOFormatosEtiquetas {
    public DAOFormatosEtiquetas()  {  }
    
  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 18/1/2007
   */
    public DTOSalida consultarFormatosEtiquetas(DTODatosEtiqueta dto) throws MareException {             
        UtilidadesLog.info("DAOFormatosEtiquetas.consultarFormatosEtiquetas"+
        "(DTODatosEtiqueta dto): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        /*
         * BELC300024733 - dmorello, 17/04/2007
         * Se modifica para recuperar la descripción del programa etiqueta
         */
        query.append(" SELECT FORMATO.OID_FORM_ETIQ AS OID, ");
        query.append(" GEN1.VAL_I18N AS DESCENTRO, ");
        query.append(" GEN2.VAL_I18N AS DESLINEA,  ");
        query.append(" GEN3.VAL_I18N AS DESSUBLINEA,  ");
        //query.append(" FORMATO.VAL_FORM_ETIQ AS FORMATO, ");
        query.append(" GEN4.VAL_I18N AS PROGRAMA, ");
        query.append(" CENTRO.OID_CONF_CENT_DIST AS OIDCENTRO,  ");
        query.append(" LINEA.OID_LINE_ARMA AS OIDLINEA, ");
        query.append(" SUBLINEA.OID_SUBL_ARMA AS OIDSUBLINEA, ");
        query.append(" FORMATO.PRET_OID_PROG_ETIQ AS OIDPROGRAMA ");
        query.append(" FROM APP_CONFI_CENTR_DISTR CENTRO, ");
        query.append(" APE_LINEA_ARMAD LINEA,  ");
        query.append(" APE_SUBLI_ARMAD SUBLINEA, ");
        query.append(" APE_FORMA_ETIQU FORMATO,  ");
        query.append(" V_GEN_I18N_SICC GEN1, ");
        query.append(" V_GEN_I18N_SICC GEN2,  ");
        query.append(" V_GEN_I18N_SICC GEN3, ");
        query.append(" V_GEN_I18N_SICC GEN4 "); // Descripcion progr.etiqueta
        query.append(" WHERE CENTRO.OID_CONF_CENT_DIST = LINEA.CCDI_OID_CONF_CENT_DIST ");
        query.append(" AND LINEA.OID_LINE_ARMA = SUBLINEA.LIAR_OID_LINE_ARMA ");
        query.append(" AND SUBLINEA.OID_SUBL_ARMA = FORMATO.SBAR_OID_SUBL_ARMA ");
        
        if(dto.getOidCentroDistribucion()!=null) {
            query.append(" AND CENTRO.OID_CONF_CENT_DIST = " + dto.getOidCentroDistribucion());    
        }
        
        if(dto.getOidLineaArmado()!=null) {
            query.append(" AND LINEA.OID_LINE_ARMA = " + dto.getOidLineaArmado());    
        }
        
        if(dto.getOidSublineaArmado()!=null) {
            query.append(" AND SUBLINEA.OID_SUBL_ARMA = " + dto.getOidSublineaArmado());
        }        
        
        query.append(" AND CENTRO.OID_CONF_CENT_DIST = GEN1.VAL_OID ");
        query.append(" AND GEN1.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND GEN1.ATTR_ENTI = 'APP_CONFI_CENTR_DISTR' ");
        query.append(" AND LINEA.OID_LINE_ARMA = GEN2.VAL_OID ");
        query.append(" AND GEN2.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND GEN2.ATTR_ENTI = 'APE_LINEA_ARMAD' ");
        query.append(" AND SUBLINEA.OID_SUBL_ARMA = GEN3.VAL_OID ");
        query.append(" AND GEN3.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND GEN3.ATTR_ENTI = 'APE_SUBLI_ARMAD' ");
        // Filtros para obtener descripcion programa etiqueta
        query.append(" AND FORMATO.PRET_OID_PROG_ETIQ = GEN4.VAL_OID ");
        query.append(" AND GEN4.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND GEN4.ATTR_ENTI = 'APE_PROGR_ETIQU' ");
        /* Fin BELC300024733 dmorello 17/04/2007 */
        
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(queryPaginada);
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs == null) || rs.esVacio()) {
            throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE +
            ErroresDeNegocio.APE_0027));
        }  
        
        UtilidadesLog.info("DAOFormatosEtiquetas.consultarFormatosEtiquetas"+
        "(DTODatosEtiqueta dto): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
    
    /**
     * Recupera de BD los OIDs y las descripciones de los programas de etiquetas
     * en el idioma recibido por parámetro.
     * Creado por incidencia BELC300024733
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con OIDs y descripciones de los programas de etiquetas
     * @param dtoe DTO con idioma no nulo
     * @author dmorello
     * @since 11-04-2007
     */
    public DTOSalida obtenerProgramasEtiquetas(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOFormatosEtiquetas.obtenerProgramasEtiquetas(DTOBelcorp dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("   SELECT progr.oid_prog_etiq, gen.val_i18n ");
        query.append("     FROM ape_progr_etiqu progr, v_gen_i18n_sicc gen ");
        query.append("    WHERE progr.oid_prog_etiq = gen.val_oid ");
        query.append("      AND gen.idio_oid_idio = ").append(dtoe.getOidIdioma());
        query.append("      AND gen.attr_enti = 'APE_PROGR_ETIQU' ");
        query.append(" ORDER BY val_i18n ASC ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException (e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOFormatosEtiquetas.obtenerProgramasEtiquetas(DTOBelcorp dtoe): Salida");
        return new DTOSalida(rs);
    }
}