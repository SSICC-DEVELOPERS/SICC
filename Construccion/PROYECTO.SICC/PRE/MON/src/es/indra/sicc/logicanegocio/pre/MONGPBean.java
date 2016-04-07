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

package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.pre.DTOEFicheroGP;
import es.indra.sicc.dtos.pre.DTOSFicheroGP;
import es.indra.sicc.logicanegocio.pre.ErroresNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
/**
 * MON de manejo de la guia de productos (GP).
 * 
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */  
public class MONGPBean implements SessionBean {

    public void ejbCreate() { }
    public void ejbActivate() { }
    public void ejbPassivate() { }
    public void ejbRemove() { }
    public void setSessionContext(SessionContext ctx) {  }
    
  /**
   * 
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   * 
   * @author pperanzola
   * @date 07/09/2005
   *          [1] cambios realizados segun DT de Código Unico de venta
   */
    public DTOSFicheroGP generarGP(DTOEFicheroGP dto) throws MareException {
        UtilidadesLog.info("MONGPBean.generarGP(DTOEFicheroGP dto): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer sQuery = new StringBuffer();
        BelcorpService bs = null;
        DTOSFicheroGP dtoS = new DTOSFicheroGP();
        Long oidCabeceraMF = dto.getOidCabeceraMF();

        //Long idioma = UtilidadesSession.getIdioma(this);
        Long idioma = dto.getOidIdioma();

        Long indicadorSituacion = dto.getIndicadorSituacion();

        Integer tamanioPagina = dto.getTamanioPagina();

        // [1]
        Long oidCatalogo = dto.getOidCatalogo();
        sQuery.append(" SELECT  ");
        //sQuery.append(" LINEA, NUM_ORDE, VAL_CODI_VENT, DESC_PRODU , IMP_PREC_CATA, OCAT_OID_CATAL  ");
        sQuery.append(" '', VAL_CODI_VENT, DESC_PRODU , IMP_PREC_CATA  ");
        sQuery.append(" FROM ");
        sQuery.append(" V_PRE_ORDEN_OFERT ");
        sQuery.append(" WHERE ");
        sQuery.append("     IND_IMPR_GP = 1 "); // Solo se recuperan los registros con indicador impresion en GP = True 
        sQuery.append(" AND IDIO_OID_IDIO= " + idioma.toString()); //oid del idioma recibido 
        sQuery.append(" AND OID_CABE = " + oidCabeceraMF.toString());
          if (oidCatalogo != null){
            sQuery.append(" AND OCAT_OID_CATAL = " + oidCatalogo );
          }
        sQuery.append(" AND LINEA > " + indicadorSituacion.toString()); // Indica el primer registro de la pagina 
        sQuery.append(" AND ROWNUM <= " + tamanioPagina.toString()); // Se recuperan como máximo tantos registros como indica el parametro tamañoPagina 
        sQuery.append(" ORDER BY  NUM_ORDE ");//CUV16       //Se elimina ordenamiento por Descr. por pedido de cambio PRE-003 (, DESC_PRODU asc )
        
  
        try {
            bs = BelcorpService.getInstance();
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        dtoS.setResultado(rs);
        
        UtilidadesLog.info("MONGPBean.generarGP(DTOEFicheroGP dto): Salida");
        return dtoS;
    }

  /**
   * 
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   * 
   * @author pperanzola
   * @date 07/09/2005
   *          [1] cambios realizados segun DT de Código Unico de venta
   */
    public DTOSFicheroGP generarCabeceraGP(DTOEFicheroGP dto) throws MareException {
        UtilidadesLog.info("MONGPBean.generarCabeceraGP(DTOEFicheroGP dto): Entrada");
        
        RecordSet rs = new RecordSet();
        RecordSet rs2 = new RecordSet();
        StringBuffer sQuery = new StringBuffer();
        StringBuffer queryS = new StringBuffer();
        BelcorpService bs = null;
        DTOSFicheroGP dtoS = new DTOSFicheroGP();

        //Long idioma = dto.getOidIdioma();
        Long oidCabeceraMF = dto.getOidCabeceraMF();
        	// /* [1]
        Long oidCatalogo = dto.getOidCatalogo();
        sQuery.append(" SELECT ");
            sQuery.append("  COUNT (*) cuenta ");
        sQuery.append(" FROM  ");
            sQuery.append(" pre_ofert_detal pod, pre_ofert po ");
        sQuery.append(" WHERE ");
            sQuery.append("     pod.ind_codi_vent_gene = 0 ");
        if (oidCatalogo != null){
            sQuery.append(" AND pod.ocat_oid_catal = " + oidCatalogo );
        }
            sQuery.append(" AND po.OID_OFER = pod.OFER_OID_OFER ");
            sQuery.append(" AND po.MFCA_OID_CABE = " + oidCabeceraMF);

        try {
            bs = BelcorpService.getInstance();
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        //UtilidadesLog.debug("Resultado: " + rs.toString());

        if (!rs.esVacio() && (((BigDecimal) rs.getValueAt(0, 0)).longValue() > 0)) {
            //UtilidadesLog.debug("Voy a tirar Exception");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0038));
        }

        queryS = new StringBuffer();

        queryS.append(" SELECT   i.val_i18n pais, s.des_marc marca, i2.val_i18n canal,  ");
        queryS.append("                  p.VAL_NOMB_PERI, m.oid_cabe OID ");
        queryS.append("            FROM v_gen_i18n_sicc i, ");
        queryS.append("                 v_gen_i18n_sicc i2, ");
        queryS.append("                 pre_matri_factu_cabec m, ");
        queryS.append("                 cra_perio p, ");
        queryS.append("                 seg_marca s ");
        queryS.append("           WHERE i.idio_oid_idio = " + dto.getOidIdioma());
        queryS.append("             AND i.attr_enti = 'SEG_PAIS' ");
        queryS.append("             AND i.attr_num_atri = 1 ");
        queryS.append("             AND i.val_oid = p.PAIS_OID_PAIS ");
        queryS.append("             AND m.perd_oid_peri = p.oid_peri ");
        queryS.append("             AND i2.idio_oid_idio = " + dto.getOidIdioma());
        queryS.append("             AND i2.attr_enti = 'SEG_CANAL' ");
        queryS.append("             AND i2.attr_num_atri = 1 ");
        queryS.append("             AND i2.val_oid = p.cana_oid_cana ");
        queryS.append("             AND m.oid_cabe = " + oidCabeceraMF);
        queryS.append("             AND s.oid_marc = p.marc_oid_marc ");

        try {
            bs = BelcorpService.getInstance();
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs2 = bs.dbService.executeStaticQuery(queryS.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //UtilidadesLog.debug("Resultado: " + rs2.toString());

        dtoS.setResultado(rs2);
        
        UtilidadesLog.info("MONGPBean.generarCabeceraGP(DTOEFicheroGP dto): Salida");
        return dtoS;
    }
}
