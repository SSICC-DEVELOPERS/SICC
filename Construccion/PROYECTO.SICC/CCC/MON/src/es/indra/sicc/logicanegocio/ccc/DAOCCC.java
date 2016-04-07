package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOAbonoSubprocesoMarcaSituacion;
import es.indra.sicc.dtos.ccc.DTOBuscarTiposAbonoSubproceso;
import es.indra.sicc.dtos.ccc.DTOCodigoProceso;
import es.indra.sicc.dtos.ccc.DTOConsultarMarcasTipoAbono;
import es.indra.sicc.dtos.ccc.DTOFiltroCC;
import es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono;
import es.indra.sicc.dtos.ccc.DTORepBusquedaCC;
import es.indra.sicc.dtos.ccc.DTOSaldoCampana;
import es.indra.sicc.dtos.ccc.DTOBloqueo;
import es.indra.sicc.logicanegocio.ccc.HistorialNotFoundException;
import es.indra.sicc.logicanegocio.fac.ProcesoFacturacionHelper;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import es.indra.sicc.util.ExcepcionParametrizada;

import java.lang.Double;
import java.lang.Long;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.HashMap;

import javax.ejb.EJBException;


public class DAOCCC {

    // ********* aniadido por incidencia 16736, se necesita el usuario en el metodo obtenerIndEmisionVtoPais
    private String usuario = null;
    
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOCCC(String usuario) {
        this.usuario = usuario;
    }
    // *************************
    public DAOCCC(){
    }
    public DTOSalida obtieneTiposAbonoSubproceso(DTOOID dto)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtieneTiposAbonoSubproceso(DTOOID dto) Entrada ");
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT OID_TIPO_ABON_SUBP, i.val_i18n ");
        query.append(" FROM CCC_TIPO_ABONO_SUBPR e, v_gen_i18n_sicc i, CCC_SUBPR sub ");
        query.append(" WHERE i.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
        query.append(" AND i.attr_num_atri = 1 ");
        query.append(" AND i.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" AND e.TCAB_OID_TCAB = i.VAL_OID ");
        query.append(" AND e.SUBP_OID_SUBP = " + dto.getOid());
        query.append(" AND e.SUBP_OID_SUBP = sub.OID_SUBP ");
        query.append(" AND sub.VAL_INDI_GEST_MARC = 1 ");
        query.append(" ORDER BY 2 ");

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("recordset " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            //Incidencia 7627 
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOCCC.obtieneTiposAbonoSubproceso(DTOOID dto) Salida ");
        return dtoSalida;
    }

    public RecordSet obtieneBancos(DTOBelcorp dto) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtieneBancos(DTOBelcorp dto) Entrada ");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT banco.OID_BANC, banco.DES_BANC ");
        query.append(" FROM CCC_BANCO banco ");
        query.append(" WHERE banco.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" ORDER BY banco.DES_BANC ");

        RecordSet rs;
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener bancos por pais", e);
        }
        UtilidadesLog.info("DAOCCC.obtieneBancos(DTOBelcorp dto) Salida ");
        return rs;
    }

    public Double cuentasCastigadasCliente(Long cliente) {
        
        UtilidadesLog.info("DAOCCC.cuentasCastigadasCliente(Long cliente) Entrada ");
        UtilidadesLog.info("DAOCCC.cuentasCastigadasCliente(Long cliente): Salida ");
        return null;
    }

    public Long obtieneProceso(String codigo, Long pais)
        throws MareException {
        /*
                Obtiene mendiante una consulta JDBC el oid del proceso para el pais
                y el código indicado. Devuelve nulll si no existe.
                Como ambos atributos son UK en la tabla, como máximo podemos obtener un resultado.
                */
        UtilidadesLog.info("DAOCCC.obtieneProceso(String codigo, Long pais): Entrada ");
        StringBuffer query = new StringBuffer();

        // para corregir incidencia 3280
        query.append("  SELECT OID_PROC ");
        query.append("    FROM CCC_PROCE  ");
        query.append("   WHERE PAIS_OID_PAIS = " + pais);
        query.append("    AND COD_PROC =  '" + codigo + "' "); // para corregir incidencia 3280
        RecordSet rs;

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOCCC.obtieneProceso(String codigo, Long pais): Salida  1");
            return null;
        } else {
            UtilidadesLog.info("DAOCCC.obtieneProceso(String codigo, Long pais): Salida  2 ");
            return new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
        }
    }

    public Long obtieneIndActCuota(Long proceso, String codigo)
        throws MareException {
        /*
            Obtiene el oid del subproceso definido por el proceso y el código de subproceso
            especificado, null si no existe.
            Como ambos atributos son UK en la tabla, como máximo podemos obtener un resultado.
             **/
        UtilidadesLog.info("DAOCCC.obtieneIndActCuota(Long proceso, String codigo): Entrada ");
        long codigo1;

        try {
            codigo1 = Long.parseLong(codigo);
        } catch (IllegalArgumentException me) {
            throw me;
        }

        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT VAL_INDI_ACTU_CUOT   ");
        query.append("   FROM CCC_SUBPR  ");
        query.append("  WHERE CCPR_OID_PROC = " + proceso);
        query.append("    AND COD_SUBP =  " + codigo1);

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtieneIndActCuota(Long proceso, String codigo): Salida ");
        return new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
    }

    public Long obtieneIndActCuotaPais(String proceso, String codigo, Long oidPais)
        throws MareException {
        /*
            Obtiene el oid del subproceso definido por el proceso y el código de subproceso
            especificado, null si no existe.
            Como ambos atributos son UK en la tabla, como máximo podemos obtener un resultado.
             **/
        UtilidadesLog.info("DAOCCC.obtieneIndActCuotaPais(Long proceso, String codigo, Long oidPais): Entrada ");
        long codigo1;

        try {
            codigo1 = Long.parseLong(codigo);
        } catch (IllegalArgumentException me) {
            throw me;
        }

        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT VAL_INDI_ACTU_CUOT ");
        query.append("   FROM CCC_SUBPR subpr, CCC_PROCE proce ");
        query.append("   WHERE proce.PAIS_OID_PAIS = " + oidPais.longValue());
        query.append("    AND  proce.COD_PROC = '" + proceso + "'");
        query.append("    AND  subpr.CCPR_OID_PROC = proce.OID_PROC ");
        query.append("    AND  subpr.COD_SUBP =  " + codigo1);
        
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("obtieneIndActCuotaPais trae: " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCCC.obtieneIndActCuotaPais(Long proceso, String codigo, Long oidPais): Salida ");
        if ((rs != null) && (rs.getRowCount()>0))
            return new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
        else
            return null;
        
    }
    
    public Long obtieneSubproceso(Long proceso, String codigo)
        throws MareException {
        /*
            Obtiene el oid del subproceso definido por el proceso y el código de subproceso
            especificado, null si no existe.
            Como ambos atributos son UK en la tabla, como máximo podemos obtener un resultado.
             **/
        UtilidadesLog.info("DAOCCC.obtieneSubproceso(Long proceso, String codigo): Entrada ");
        long codigo1;

        try {
            codigo1 = Long.parseLong(codigo);
        } catch (IllegalArgumentException me) {
            throw me;
        }

        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT OID_SUBP   ");
        query.append("   FROM CCC_SUBPR  ");
        query.append("  WHERE CCPR_OID_PROC = " + proceso);
        query.append("    AND COD_SUBP =  " + codigo1);

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtieneSubproceso(Long proceso, String codigo): Salida ");
        return new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
    }

    public Long obtieneSubproceso(String proceso, String subproceso, Long pais)
        throws MareException {
        /*
                Optiene el oid de subproceso para los códigos de proceso y subproceso dados.
                Para ello llama a obtieneProceso de esta clase pasandole los parametros proceso y pais.
                Con el resultado de esta llamada llamamos al metodo sobrecargado obtieneSubproceso pasadonle
                tambien el código de subproceso.
                El resultado de esta llamada lo devolvemos.
                 * */
        UtilidadesLog.info("DAOCCC.obtieneSubproceso(String proceso, String subproceso, Long pais): Entrada ");
        Long subpro = obtieneProceso(proceso, pais);
        UtilidadesLog.info("DAOCCC.obtieneSubproceso(String proceso, String subproceso, Long pais): Salida ");
        return obtieneSubproceso(subpro, subproceso);
    }

    public DTOSalida obtenerSucursalesBanco(DTOOID dto)
        throws MareException {
        /*
                Documentation
                Hacemos la siguiente consulta JDBC:
                SELECT OID_SUCU, COD_SUCU
                FROM CCC_SUCUR
                WHERE CBAN_OID_BANC = dto.oid;
                */
        UtilidadesLog.info("DAOCCC.obtenerSucursalesBanco(DTOOID dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT OID_SUCU, COD_SUCU ");
        query.append("   FROM CCC_SUCUR  ");
        query.append(" WHERE CBAN_OID_BANC =  " + dto.getOid());

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtoSalida = new DTOSalida(rs);
        UtilidadesLog.info("DAOCCC.obtenerSucursalesBanco(DTOOID dto): Salida ");
        return dtoSalida;
    }

    public RecordSet obtieneSucursalesBanco(DTOOID dto)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtieneSucursalesBanco(DTOOID dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append("  SELECT OID_SUCU, COD_SUCU ");
        query.append("    FROM CCC_SUCUR ");
        query.append("   WHERE CBAN_OID_BANC = " + dto.getOid());
        query.append(" ORDER BY CCC_SUCUR.COD_SUCU");

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCCC.obtieneSucursalesBanco(DTOOID dto): Salida ");
        return rs;
    }

    public RecordSet obtieneCuentasSucursal(DTOOID dto)
        throws MareException {
        /*
                 * Documentation
                 * Hacemos una consulta JDBC para obtener el oid y
                 * descripcion (en el idioma indicado por el dto) de los
                 * registros de la tabla CCC_CUENT_CORRI_BANCA cuyo campo
                 * SUCU_OID_SUCU coincida con el oid del dto.
                 * */
        UtilidadesLog.info("DAOCCC.obtieneCuentasSucursal(DTOOID dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT ccb.oid_cuen_corr_banc, ccb.DES_CC  ");
        query.append("   FROM ccc_cuent_corri_banca ccb");
        query.append("  WHERE ccb.sucu_oid_sucu = " + dto.getOid() +
            " ORDER BY ccb.DES_CC");

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCCC.obtieneCuentasSucursal(DTOOID dto): Salida ");
        return rs;
    }

    public Long obtenerHistoricoMovimiento(Long movimiento,
        Integer numeroHistoria) throws MareException {
        /*Documentation
                Obtiene el oid del historial del movimiento indicado con el número de historial indicado.
                Si no existe lanza una HistorialNotFoundException.
        
                Si la consulta no devuelve ningún registro devolvemos null
                Si nos devuelve un resultado lo devolvemos
                Si nos devuelve más de un resultado es un error de la consulta o de la base de datos
                y lanzamos un error de sistema.
                 * */
         
        UtilidadesLog.info("DAOCCC.obtenerHistoricoMovimiento(Long movimiento, Integer numeroHistoria): Entrada ");
        //Modificado por incidencia 9728
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append("   SELECT oid_hist_movi  ");
        query.append("     FROM ccc_histo_movim_cc h ");
        query.append("    WHERE h.NUM_HIST = ?");
        query.append("      AND h.MVCC_OID_MOVI_CC = ?");

        Vector parametros = new Vector();
        parametros.add(numeroHistoria);
        parametros.add(movimiento);

        /* Eliminado por incidencia 9728
            query.append("   SELECT oid_hist_movi  ");
            query.append("     FROM ccc_histo_movim_cc h, ccc_movim_cuent_corri m  ");
            query.append("    WHERE h.pais_oid_pais = m.pais_oid_pais              ");
            query.append("      AND h.val_ejer_cuot = m.val_ejer_cuot              ");
            query.append("      AND h.num_iden_cuot = m.num_iden_cuot              ");
            query.append("      AND h.num_orde_cuot = m.num_orde_cuot              ");
            query.append("      AND h.val_nume_seri_cuot = m.val_nume_seri_cuot    ");
            query.append("      AND h.num_hist = " + numeroHistoria );
            query.append("      AND m.oid_movi_cc = " + movimiento  );
          */
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            //rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
            if (rs.esVacio()) {
                throw new HistorialNotFoundException();
            }
            if (rs.getRowCount() > 1) { //BELC300003206
                throw new IllegalArgumentException(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS);
            }
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCCC.obtenerHistoricoMovimiento(Long movimiento, Integer numeroHistoria): Salida ");
        return new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
    }

    public RecordSet obtieneProcesosPais(long pais, boolean CVDirectos, boolean completo)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtieneProcesosPais(long pais, boolean CVDirectos, boolean completo): Entrada ");
        StringBuffer query = new StringBuffer();
        Integer CVDir;

        if (CVDirectos == true) {
            CVDir = new Integer(1);
        } else {
            CVDir = new Integer(0);
        }

        query.append(" SELECT p.OID_PROC,  p.DES_PROC, p.COD_PROC  "); //BELC300004469
        query.append(" FROM CCC_PROCE p  ");
        query.append(" WHERE PAIS_OID_PAIS = " + Long.toString(pais));
		if(completo == true){
			query.append(" AND IND_CV_DIRE = " + CVDir.toString());
		}
        query.append(" ORDER BY 2 ");

        RecordSet rs;
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("recordset obtieneProcesosPais " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al realizar la consulta de procesos",
                e);
        }
        UtilidadesLog.info("DAOCCC.obtieneProcesosPais(long pais, boolean CVDirectos, boolean completo): Salida ");
        return rs;
    }

    public RecordSet obtieneCodigosSubprocesos(Long proceso)
        throws MareException {
        /* Hacemos la siguiente consulta JDBC y devolvemos el recordset con el
         * resultado
         * SELECT COD_SUBP, DES_SUBP
         * FROM CCC_SUBPR
         * WHERE CCPR_OID_PROC = proceso
         */
        UtilidadesLog.info("DAOCCC.obtieneCodigosSubprocesos(Long proceso): Entrada ");
        StringBuffer query = new StringBuffer("SELECT COD_SUBP, DES_SUBP ");
        query.append("FROM CCC_SUBPR ");
        query.append("WHERE CCPR_OID_PROC =  " + proceso);
        query.append("ORDER BY DES_SUBP ");

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCCC.obtieneCodigosSubprocesos(Long proceso): Salida ");
        return resultado;
    }

    public RecordSet obtieneProcesosPais(long pais) throws MareException {
        UtilidadesLog.info("DAOCCC.obtieneProcesosPais(long pais): Entrada ");
        UtilidadesLog.info("DAOCCC.obtieneProcesosPais(long pais): Salida ");
        return obtieneProcesosPais(pais, false, true);
    }

    public RecordSet obtenerTiposAbono(DTOBelcorp dto)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerTiposAbono(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT e.OID_TIPO_CARG_ABON, i.val_i18n ");
        query.append("   FROM CCC_TIPO_CARGO_ABONO e, v_gen_i18n_sicc i ");
        query.append("  WHERE i.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
        query.append("    AND i.attr_num_atri = 1");
        query.append("    AND i.idio_oid_idio = " + dto.getOidIdioma());
        query.append("    AND  e.PAIS_OID_PAIS = " + dto.getOidPais().toString());
        query.append("    AND i.val_oid = e.OID_TIPO_CARG_ABON ");
        query.append("  ORDER BY 2");

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("recordset obtenerTiposAbono " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al realizar la consulta de tipos abonos", e);
        }
        UtilidadesLog.info("DAOCCC.obtenerTiposAbono(DTOBelcorp dto): Salida ");
        return rs;
    }    

    public RecordSet obtenerMarcasSituacion(DTOBelcorp dto)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerMarcasSituacion(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT e.OID_MARC_SITU, i.val_i18n ");
        query.append("   FROM CCC_MARCA_SITUA e, v_gen_i18n_sicc i ");
        query.append("  WHERE i.attr_enti = 'CCC_MARCA_SITUA' ");
        query.append("    AND i.attr_num_atri = 1");
        query.append("    AND i.idio_oid_idio = " + dto.getOidIdioma());
        query.append("    AND  e.PAIS_OID_PAIS = " + dto.getOidPais().toString());
        query.append("    AND i.val_oid = e.OID_MARC_SITU ");
        query.append("  ORDER BY 2");

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("recordset obtenerMarcasSituacion " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al realizar la consulta de marca situacion",
                e);
        }
        UtilidadesLog.info("DAOCCC.obtenerMarcasSituacion(DTOBelcorp dto): Salida ");
        return rs;
    }

    public DTOSalida obtieneSubprocesos(DTOOID dto, Boolean bMarca) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtieneSubprocesos(DTOOID dto, Boolean bMarca): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT OID_SUBP, DES_SUBP  ");
        query.append("   FROM CCC_SUBPR ");
        query.append("  WHERE CCPR_OID_PROC =  " + dto.getOid());
        
        if (bMarca == Boolean.TRUE)
        {
            query.append(" AND VAL_INDI_GEST_MARC = 1 "); 
        }
        query.append("  ORDER BY 2");

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("recordset obtieneSubprocesos " + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al realizar la consulta de marca situacion",
                e);
        }

        DTOSalida salir = new DTOSalida(rs);
        UtilidadesLog.info("DAOCCC.obtieneSubprocesos(DTOOID dto, Boolean bMarca): Salida ");
        return salir;
    }

    public DTOSalida buscarMarcasPorTipoAbono(DTOMarcasPorTipoAbono dto)
        throws MareException {
        UtilidadesLog.info("DAOCCC.buscarMarcasPorTipoAbono(DTOMarcasPorTipoAbono dto): Entrada ");

        StringBuffer query = new StringBuffer();
        String queryPaginada = null;
        RecordSet rs;

        query.append(" select ");
        query.append(" e.oid_tipo_abon_subp  OID,");  
        query.append(" p.des_proc, ");
        query.append(" s.des_subp, ");
        query.append(" i3.val_i18n, ");
        query.append(" m.val_obse, ");
        query.append(" p.oid_proc, ");
        query.append(" s.oid_subp ");
        
        query.append(" from ");
        query.append(" CCC_MARCA_TIPO_ABONO m, ");
        query.append(" CCC_PROCE p, ");
        query.append(" CCC_SUBPR s, ");
        query.append(" CCC_TIPO_ABONO_SUBPR e, ");
        query.append(" CCC_TIPO_CARGO_ABONO t, ");
        query.append(" v_gen_i18n_sicc i3 ");

        query.append(" where ");
        query.append(" m.TASP_OID_TIPO_ABON_SUBP = e.OID_TIPO_ABON_SUBP and ");
        query.append(" e.SUBP_OID_SUBP = s.OID_SUBP and ");
        query.append(" s.CCPR_OID_PROC = p.OID_proc and ");
        query.append(" m.TASP_OID_TIPO_ABON_SUBP = e.OID_TIPO_ABON_SUBP and ");
        query.append(" e.TCAB_OID_TCAB = t.OID_TIPO_CARG_ABON and ");
        query.append(" t.PAIS_OID_PAIS = " + dto.getOidPais().toString() +
            " and ");
        query.append(" i3.attr_enti = 'CCC_TIPO_CARGO_ABONO' AND ");
        query.append(" i3.attr_num_atri = 1 AND ");
        query.append(" i3.idio_oid_idio = " + dto.getOidIdioma().toString() +
            " and ");
        query.append(" i3.val_oid = e.TCAB_OID_TCAB ");

        if (dto.getProceso() != null) {
            query.append(" AND p.OID_PROC = " + dto.getProceso().toString());
        }

        if (dto.getSubproceso() != null) {
            query.append(" AND s.OID_SUBP  = " +
                dto.getSubproceso().toString());
        }

        if (dto.getTipoAbono() != null) {
            query.append(" AND e.OID_TIPO_ABON_SUBP = " +
                dto.getTipoAbono().toString());
        }
        query.append(" GROUP BY p.oid_proc, p.des_proc, s.des_subp, i3.val_i18n, m.val_obse, s.oid_subp, e.OID_TIPO_ABON_SUBP	 ");
        query.append(" order by 1 ");
        
        UtilidadesLog.debug("*********** query "  + query);
        DTOSalida resu;

        try {
            queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
            rs = getBelcorpService().dbService.executeStaticQuery(queryPaginada);

            if (rs.esVacio()) {
                throw new MareException(new Exception(),
                                         UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            resu = new DTOSalida(rs);
            UtilidadesLog.debug(" ************ Recordset buscarMarcasPorTipoAbono "  + rs);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al realizar la consulta de buscar marca tipo abono",
                e);
        }
        
        UtilidadesLog.info("DAOCCC.buscarMarcasPorTipoAbono(DTOMarcasPorTipoAbono dto): Salida ");
        return resu;
    }

    public DTOConsultarMarcasTipoAbono consultarMarcasTipoAbono(DTOMarcasPorTipoAbono dto)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.consultarMarcasTipoAbono(DTOMarcasPorTipoAbono dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
            query.append("SELECT A.OID_PROC, ");
            query.append("A.DES_PROC, ");
            query.append("B.OID_SUBP, ");
            query.append("B.DES_SUBP, ");
            query.append("C.OID_TIPO_ABON_SUBP, ");
            query.append("ia.val_i18n as TIPO, ");
            query.append("E.VAL_OBSE, ");
            query.append("E.MASI_OID_MARC_SALI, ");
            query.append("ib.val_i18n as MARCA, ");
            query.append("E.IND_ENTR_SALI ");
            query.append("FROM CCC_PROCE A, ");
            query.append("CCC_SUBPR B, ");
            query.append("CCC_TIPO_ABONO_SUBPR C, ");
            query.append("CCC_TIPO_CARGO_ABONO D, ");
            query.append("CCC_MARCA_TIPO_ABONO E, ");
            query.append("v_gen_i18n_sicc ia,  ");
            query.append("v_gen_i18n_sicc ib  ");
            query.append("WHERE ");
            query.append("A.OID_PROC = " + dto.getProceso());
            query.append("AND B.CCPR_OID_PROC = A.OID_PROC ");
            query.append("AND B.OID_SUBP =  " + dto.getSubproceso());
            query.append("AND C.SUBP_OID_SUBP = B.OID_SUBP ");
            query.append("AND C.OID_TIPO_ABON_SUBP =  " + dto.getTipoAbono());
            query.append("AND D.OID_TIPO_CARG_ABON = C.TCAB_OID_TCAB ");
            query.append("AND E.TASP_OID_TIPO_ABON_SUBP = C.OID_TIPO_ABON_SUBP ");
            query.append("AND ib.attr_enti = 'CCC_MARCA_SITUA' ");
            query.append("AND ib.attr_num_atri = 1 ");
            query.append("AND ib.idio_oid_idio =  " + dto.getOidIdioma().toString());
            query.append("AND ib.val_oid = e.MASI_OID_MARC_SALI ");
            query.append("AND ia.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
            query.append("AND ia.attr_num_atri = 1 ");
            query.append("AND ia.idio_oid_idio =  " + dto.getOidIdioma().toString());
            query.append("AND ia.val_oid = c.TCAB_OID_TCAB ");

            try {
                rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
         
            //Creamos un DTOS del tipo DTOConsultarMarcasTipoAbono 
            
            //DTOS.proceso = A.OID_PROC 
            //DTOS.procesoDesc = A.DES_PROC 
            //DTOS.subproceso = B.OID_SUBP 
            //DTOS.subprocesoDesc = B.DES_SUBP 
            //DTOS.tipoAbono = D.OID_TIPO_CARG_ABON 
            //DTOS.tipoAbonoDesc = DESCRIPCION (D.OID_TIPO_CARG_ABON) 
            //DTOS.observaciones = E.VAL_OBSE 
        
            DTOConsultarMarcasTipoAbono  dtoCMTA = new DTOConsultarMarcasTipoAbono();
            int filas = rs.getRowCount();
            if ( filas > 0 ) {
                //DTOS.proceso = A.OID_PROC             
                BigDecimal bdOidProc = (BigDecimal) rs.getValueAt(0, "OID_PROC");
                long lOid1 = bdOidProc.longValue();
                dtoCMTA.setProceso(new Long(lOid1));

                //DTOS.procesoDesc = A.DES_PROC                 
                UtilidadesLog.debug("---------------------DES_PROC");
                dtoCMTA.setProcesoDesc((String) rs.getValueAt(0, "DES_PROC"));

                //DTOS.subproceso = B.OID_SUBP                 
                BigDecimal bdOidSub = (BigDecimal) rs.getValueAt(0, "OID_SUBP");
                long lOoid2 = bdOidSub.longValue();
                dtoCMTA.setSubproceso(new Long(lOoid2));

                //DTOS.subprocesoDesc = B.DES_SUBP 
                dtoCMTA.setSubprocesoDesc((String) rs.getValueAt(0, "DES_SUBP"));

                //DTOS.tipoAbono = D.OID_TIPO_CARG_ABON                 
                BigDecimal bdOidCarg = (BigDecimal) rs.getValueAt(0,
                        "OID_TIPO_ABON_SUBP");
                long lOid3 = bdOidCarg.longValue();
                dtoCMTA.setTipoAbono(new Long(lOid3));
                //DTOS.tipoAbonoDesc = DESCRIPCION (D.OID_TIPO_CARG_ABON) 
                UtilidadesLog.debug("---------------------TIPO: " +
                rs.getValueAt(0, "TIPO").toString());
                String strVal = rs.getValueAt(0, "TIPO").toString();
                UtilidadesLog.debug("*************** strVal: "  + strVal);
                dtoCMTA.setTipoAbonoDesc(strVal);
                //DTOS.observaciones = E.VAL_OBSE 
                dtoCMTA.setObservaciones((String) rs.getValueAt(0, "VAL_OBSE"));

                //i=0 
                //Para cada registro obtenido 
                //{ 
                //  Si E.IND_ENTR_SALI == "S" //solo entrará por este Si una vez 
                //  { 
                //      DTOS.marcasSituacionSalida = E.MASI_OID_MARC_SALI 
                //      DTOS.marcasSituacionSalidaDesc = DESCRIPCION(F.OID_MARC_SITU) 
                //  } 
                //  en otro caso //E.IND_ENTR_SALI == "E" 
                //  { 
                //      DTOS.marcasSituacionEntrada[i] = E.MASI_OID_MARC_SALI 
                //      DTOS.marcasSituacionEntradaDesc[i] = DESCRIPCION(F.OID_MARC_SITU) 
                //      i++ 
                //  } 
                //}
                int i = 0;
                ArrayList arrLMarSitE = new ArrayList();                
                ArrayList arrLMarSitED = new ArrayList();
                boolean entrada = false;
               // Long[] lMarSitE = new Long[];
               // String[] lMarSitED = new String[];
                
                for (i = 0 ; i < filas ; i++) {
                
                    String sIndES = rs.getValueAt(i, "IND_ENTR_SALI").toString();
                    Long lSitSalida = new Long(rs.getValueAt(i, "MASI_OID_MARC_SALI").toString());
                    String dMarcaSitu = rs.getValueAt(i, "MARCA").toString();
                    if (sIndES.equals("S")) {
                        dtoCMTA.setMarcaSituacionSalida(lSitSalida);
                        dtoCMTA.setMarcaSituacionSalidaDesc(dMarcaSitu);
                    }
                    else if (sIndES.equals("E")) {
                        arrLMarSitE.add(lSitSalida);
                        arrLMarSitED.add(dMarcaSitu);   
                        entrada = true;
                    }
                }
                
                if (entrada) {
                    dtoCMTA.setMarcasSituacionEntrada((Long[])arrLMarSitE.toArray(new Long[0]));
                    dtoCMTA.setMarcasSituacionEntradaDesc((String[])arrLMarSitED.toArray(new String[0]));
                }

            }// filas > 0
            
            UtilidadesLog.info("DAOCCC.consultarMarcasTipoAbono(DTOMarcasPorTipoAbono dto): Salida ");
            return dtoCMTA; 
         
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al realizar la consulta de buscar marca tipo abono",
                e);
        }
    }

    private BelcorpService getBelcorpService() {
        
        UtilidadesLog.info("DAOCCC.getBelcorpService(): Entrada ");
        try {
            UtilidadesLog.info("DAOCCC.getBelcorpService(): Salida ");
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " +
                mmsnfe.getMessage(), mmsnfe);
        }
       
    }

    public static void main(String[] args) {
    
        UtilidadesLog.info("DAOCCC.main(String[] args): Entrada ");
        DAOCCC dao = new DAOCCC("usuario");
        DTOBelcorp dtoin = new DTOBelcorp();
        dtoin.setOidIdioma(new Long(1));
        dtoin.setOidPais(new Long(1));

        try {
            UtilidadesLog.debug(dao.obtieneBancos(dtoin));
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
        }
        UtilidadesLog.info("DAOCCC.main(String[] args): Salida ");
    }

    // BELC300003397 
    public RecordSet obtenerTiposCargoSubproceso(Long subproceso, Long idioma)
        throws MareException {
        /*
                 * Hacemos la siguiente consulta JDBC:
                 *
                 * SELECT TCAB_OID_TCAB, TCAB_OID_TCAB(Descripcion)
                 * FROM CCC_TIPO_ABONO_SUBPR
                 * WHERE SUBP_OID_SUBP = subproceso
                 *
                 * Devolvemos el resultado de la consulta
                 *
                 */    
        UtilidadesLog.info("DAOCCC.obtenerTiposCargoSubproceso(Long subproceso, Long idioma): Entrada ");
        StringBuffer query = new StringBuffer(
                "SELECT c.TCAB_OID_TCAB, ib.val_i18n");
        query.append(" FROM v_gen_i18n_sicc ib,CCC_TIPO_ABONO_SUBPR c");
        query.append(" WHERE c.SUBP_OID_SUBP =  " + subproceso);
        query.append(
            " AND ib.attr_enti = 'CCC_TIPO_CARGO_ABONO' AND ib.attr_num_atri = 1 ");
        query.append(" AND ib.idio_oid_idio = " + idioma +
            " AND ib.val_oid = c.TCAB_OID_TCAB ");
		query.append(" ORDER BY ib.val_i18n");

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCCC.obtenerTiposCargoSubproceso(Long subproceso, Long idioma): Salida ");        
        return resultado;
    }

   /*
     * Autor: Cortaberria
     * Fecha: 23/06/2005
     * Se modifica la consulta segun lo especificado en la incidencia BELC300018869
     */
    public Long obtenerOidCC(String codigo) throws MareException {
     /* Hacemos la siguiente consulta JDBC
           SELECT OID_CUEN_CORR_BANC
           FROM CCC_CUENT_CORRI_BANCA
           WHERE COD_CC_BANC = codigo
            Y devolvemos un Long o null
         */
        UtilidadesLog.info("DAOCCC.obtenerOidCC(String codigo): Entrada ");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_CUEN_CORR_BANC ");
        query.append(" FROM CCC_CUENT_CORRI_BANCA ");
        query.append(" WHERE COD_CC = '" + codigo + "'");

        RecordSet resultado = null;
        Long salida = null;
        String codigoError = null;

        try {
            resultado = getBelcorpService().dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                salida = new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue());
            }
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCCC.obtenerOidCC(String codigo): Salida ");
        return salida;
    }

    public Long obtenerOidCabeceraCargoAbono(Integer codigoSubproceso, String codigoProceso, Long oidPais, Long oidMovCC) throws MareException {
        UtilidadesLog.info("DAOCCC.obtenerOidCabeceraCargoAbono(String codigo): Entrada ");
        StringBuffer query = new StringBuffer();
        query.append("SELECT DCA.CCAD_OID_CABE_CARG");
        query.append("  FROM CCC_SUBPR SUB, ");
        query.append("   	   CCC_PROCE PRO, ");
        query.append("       CCC_TIPO_ABONO_SUBPR TAS, ");
        query.append("       CCC_TIPO_CARGO_ABONO TCA,");
        query.append("       CCC_DETAL_CARGO_ABONO_DIREC DCA");
        query.append(" WHERE SUB.CCPR_OID_PROC = PRO.OID_PROC");
        query.append("   AND SUB.COD_SUBP = " + codigoSubproceso );
        query.append("   AND PRO.COD_PROC = '" + codigoProceso + "'");
        query.append("   AND PRO.PAIS_OID_PAIS = " + oidPais );
        query.append("   AND TAS.SUBP_OID_SUBP = SUB.OID_SUBP");
        query.append("   AND TCA.OID_TIPO_CARG_ABON = TAS.TCAB_OID_TCAB");
        query.append("   AND TCA.PAIS_OID_PAIS = PRO.PAIS_OID_PAIS");
        query.append("   AND DCA.TASP_OID_TIPO_ABON_SUBP = TAS.OID_TIPO_ABON_SUBP ");
        query.append("   AND DCA.MVCC_OID_MOVI_CC = " + oidMovCC );
        query.append("   AND DCA.NUM_HIST_GENE = 0 ");

        RecordSet resultado = null;
        Long salida = null;
        String codigoError = null;

        try {
            resultado = getBelcorpService().dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                salida = new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue());
            }
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCCC.obtenerOidCabeceraCargoAbono(String codigo): Salida ");
        return salida;
    }


    public Long obtenerOidTipoTransaccion(String codigo, Long pais)
        throws MareException {
        /*
             * Hacemos la siguiente consulta JDBC:
             * SELECT OID_TIPO_TRAN
               FROM CCC_TIPO_TRANS
               WHERE COD_TIPO_TRAN = codigo AND
               PAIS_OID_PAIS = pais
             * */
        UtilidadesLog.info("DAOCCC.obtenerOidTipoTransaccion(String codigo, Long pais): Entrada ");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_TIPO_TRAN ");
        query.append(" FROM CCC_TIPO_TRANS ");
        query.append(" WHERE COD_TIPO_TRAN = '" + codigo + "'");
        query.append(" AND PAIS_OID_PAIS = " + pais);

        RecordSet resultado = null;
        Long salida = null;
        String codigoError = null;

        try {
            resultado = getBelcorpService().dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                salida = new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue());
            }
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCCC.obtenerOidTipoTransaccion(String codigo, Long pais): Salida ");
        return salida;
    }

    public Long obtenerEmpresaCC(Long ctacte) throws MareException {
        /*
                 * Hacemos la siguiente consulta JDBC:
                 * SELECT SOCI_OID_SOCI
                   FROM CCC_CUENT_CORRI_BANCA
                   WHERE OID_CUEN_CORR_BANC = cuentaCorriente
                 * */
        UtilidadesLog.info("DAOCCC.obtenerEmpresaCC(Long ctacte): Entrada ");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT SOCI_OID_SOCI ");
        query.append(" FROM CCC_CUENT_CORRI_BANCA ");
        query.append(" WHERE OID_CUEN_CORR_BANC = " + ctacte);

        RecordSet resultado = null;
        Long salida = null;
        String codigoError = null;

        try {
            resultado = getBelcorpService().dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                salida = new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue());
            }
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCCC.obtenerEmpresaCC(Long ctacte): Salida ");
        return salida;
    }

    public DTOSalida obtenerUltimoMovHistBancario(Long pais, Long numeroLote,
        Long consecTrans) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerUltimoMovHistBancario(Long pais, Long numeroLote, Long consecTrans): Entrada ");        
        //incidencia 8958 obtenerUltimoMovHistBancario(Long,Long,Integer)
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT * ");
        consulta.append("FROM CCC_HISTO_MOVIM_BANCA  ");
        consulta.append("WHERE NUM_HIST = ( SELECT MAX(NUM_HIST) ");
        consulta.append("FROM CCC_HISTO_MOVIM_BANCA h, ");
        consulta.append("MAE_CLIEN c ");
        consulta.append("WHERE h.CLIE_OID_CLIE=c.OID_CLIE AND ");
        consulta.append("c.PAIS_OID_PAIS = ? AND ");
        consulta.append("h.NUM_LOTE = ? AND ");
        consulta.append("h.NUM_CONS_TRAN= ? ) ");

        // Parametros de la consulta
        Vector parametros = new Vector();
        parametros.add(pais);
        parametros.add(numeroLote);
        parametros.add(consecTrans);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerUltimoMovHistBancario: Exception", e);
            this.logSql("obtenerUltimoMovHistBancario. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        // Se devuelve un DTOSalida
        DTOSalida dtoSalida = new DTOSalida(resultado);

        UtilidadesLog.info("DAOCCC.obtenerUltimoMovHistBancario(Long pais, Long numeroLote, Long consecTrans): Salida ");        
        return dtoSalida;
    }

    public DTOSalida obtenerTiposAbonoSubprocesoCContable(Long pais,
        String codProceso, Integer codSubproceso) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerTiposAbonoSubprocesoCContable(Long pais, String codProceso, Integer codSubproceso): Entrada ");        

        //Recupera el primer registro asociado al codigoProceso, 
        //codigoSubproceso y pais pasados como parámetros. Devuelve un único 
        //registro con un único campo: CuentaContable
        StringBuffer consulta = new StringBuffer();
        consulta.append("	SELECT t.CUCO_OID_CUEN_CONT, t.TCAB_OID_TCAB, t.OID_TIPO_ABON_SUBP ");
        consulta.append("	FROM CCC_TIPO_ABONO_SUBPR t	");
        consulta.append("	, CCC_TIPO_CARGO_ABONO c	");
        consulta.append("	, CCC_SUBPR s	");
        consulta.append("	, CCC_PROCE p	");

        consulta.append("	WHERE t.TCAB_OID_TCAB = c.OID_TIPO_CARG_ABON ");
        consulta.append("	AND t.SUBP_OID_SUBP = s.OID_SUBP ");
        consulta.append("	AND s.CCPR_OID_PROC = p.OID_PROC ");

        //Criterios filtro
        consulta.append("	AND s.COD_SUBP = ? ");
        consulta.append("	AND p.COD_PROC = ? ");
        consulta.append("	AND c.PAIS_OID_PAIS = ? ");

        // Parametros de la consulta
        Vector parametros = new Vector();
        parametros.add(codSubproceso);
        parametros.add(codProceso);
        parametros.add(pais);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerUltimoMovHistBancario: Exception", e);
            this.logSql("obtenerUltimoMovHistBancario. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida salida = new DTOSalida();
        salida.setResultado(resultado);

        UtilidadesLog.info("DAOCCC.obtenerTiposAbonoSubprocesoCContable(Long pais, String codProceso, Integer codSubproceso): Entrada ");        
        return salida;
    }

    //BELC300008016
    public RecordSet obtenerMarcasTipoAbonoSalida(String codigoProceso,
        Integer codigoSubproceso, Long pais) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerMarcasTipoAbonoSalida(String codigoProceso,  Integer codigoSubproceso, Long pais): Entrada ");        

        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT u.OID_MARC_SITU, m.TASP_OID_TIPO_ABON_SUBP ");
        consulta.append(" FROM CCC_MARCA_SITUA u,CCC_MARCA_TIPO_ABONO m, ");
        consulta.append(" CCC_TIPO_ABONO_SUBPR t,CCC_SUBPR s,CCC_PROCE p ");
        consulta.append(" WHERE u.OID_MARC_SITU = m.MASI_OID_MARC_SALI ");
        consulta.append(
            " AND m.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP ");
        consulta.append(" AND t.SUBP_OID_SUBP = s.OID_SUBP ");
        consulta.append(" AND s.CCPR_OID_PROC = p.OID_PROC ");
        consulta.append(" AND s.COD_SUBP = ? ");
        consulta.append(" AND p.COD_PROC = ? ");

        //BELC300007990
        consulta.append(" AND p.PAIS_OID_PAIS = ? "); //BELC300010693
        consulta.append("  AND m.IND_ENTR_SALI like 'S' ");

        // Parametros de la consulta
        Vector parametros = new Vector();
        parametros.add(codigoSubproceso);
        parametros.add(codigoProceso);
        parametros.add(pais);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
            UtilidadesLog.debug("El recordset de MarcasTipoAbono es: " + resultado);         
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerMarcasTipoAbonoSalida: Exception", e);
            this.logSql("obtenerMarcasTipoAbonoSalida. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOCCC.obtenerMarcasTipoAbonoSalida(String codigoProceso,  Integer codigoSubproceso, Long pais): Salida ");        
        return resultado;
    }

    //BELC300008016
	/**Cortaberria
	 * 26/02/2005
	 * se ponia el codigo sin las comillas
	 **/
    public RecordSet obtenerMarcasTipoAbonoEntrada(String codigoProceso,
        Integer codigoSubproceso, Long pais) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerMarcasTipoAbonoEntrada(String codigoProceso, Integer codigoSubproceso, Long pais): Entrada ");        
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT u.OID_MARC_SITU, m.TASP_OID_TIPO_ABON_SUBP, ");
        consulta.append(" s.VAL_INDI_ACTU_CUOT FROM ");
        consulta.append(" CCC_MARCA_SITUA u,CCC_MARCA_TIPO_ABONO m, ");
        consulta.append(" CCC_TIPO_ABONO_SUBPR t,CCC_SUBPR s, ");
        consulta.append(" CCC_PROCE p ");
        consulta.append(" WHERE u.OID_MARC_SITU = m.MASI_OID_MARC_SALI ");
        consulta.append(" AND m.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP ");
        consulta.append(" AND t.SUBP_OID_SUBP = s.OID_SUBP ");
        consulta.append(" AND s.CCPR_OID_PROC = p.OID_PROC ");
        consulta.append(" AND s.COD_SUBP = ? ");
        consulta.append(" AND p.COD_PROC = '"+ codigoProceso +"'");

        //BELC300007990
        consulta.append(" AND u.PAIS_OID_PAIS = ? ");
        consulta.append(" AND m.IND_ENTR_SALI like 'E' ");

        // Parametros de la consulta
        Vector parametros = new Vector();
        parametros.add(codigoSubproceso);
        parametros.add(pais);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerMarcasTipoAbonoEntrada: Exception", e);
            this.logSql("obtenerMarcasTipoAbonoEntrada. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOCCC.obtenerMarcasTipoAbonoEntrada(String codigoProceso, Integer codigoSubproceso, Long pais): Salida ");        
        return resultado;
    }
    
    /**
     * 
     * @date 16/08/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidCliente
     * @param oidPais
     * @author pperanzola
     */
    public BigDecimal calcularSaldoCCCliente(Long oidPais, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOCCC.calcularSaldoCCCliente(Long oidCliente, Long oidPais): Entrada"); 

        String proceso = "CON001";
        Integer subproceso = new Integer(1);        
        StringBuffer sql = new StringBuffer();
        BigDecimal valorRetorno = null;
        RecordSet recordset = null;
        
        sql.append("  SELECT (nvl(a.SUMA,0) - nvl(b.SUMA,0)) SUMA ");
        sql.append(" FROM ");
        
        sql.append(" (SELECT SUM (imp_pend) AS SUMA ");
        sql.append("   FROM CCC_MARCA_TIPO_ABONO m ");
        sql.append("   ,CCC_SUBPR s ");
        sql.append("   ,CCC_TIPO_ABONO_SUBPR t ");
        sql.append("   ,CCC_PROCE p ");
        sql.append("   ,CCC_MOVIM_CUENT_CORRI mcc ");
        sql.append("   ,MAE_CLIEN c ");
        sql.append(" WHERE  m.tasp_oid_tipo_abon_subp = t.oid_tipo_abon_subp ");
        sql.append(" AND t.subp_oid_subp = s.oid_subp ");
        sql.append(" AND s.ccpr_oid_proc = p.oid_proc ");
        sql.append(" AND s.cod_subp = " + subproceso);
        sql.append(" AND p.cod_proc = '" + proceso +"'");
        sql.append(" AND p.pais_oid_pais = " + oidPais);
        sql.append(" AND m.ind_entr_sali LIKE 'E' ");
        sql.append(" AND c.pais_oid_pais = " + oidPais);
        sql.append(" AND mcc.clie_oid_clie = c.oid_clie ");
        sql.append(" AND mcc.clie_oid_clie = " + oidCliente);
        sql.append(" AND mcc.masi_oid_marc_situ =  m.masi_oid_marc_sali ");
        sql.append(" AND mcc.imp_movi <> mcc.imp_paga) a, ");
        
        sql.append(" ( SELECT SUM(b.imp_sald_pend) SUMA ");
	    sql.append(" FROM ccc_movim_banca b ");
	    sql.append(" WHERE b.clie_oid_clie = " + oidCliente);
	    sql.append("   AND  b.imp_sald_pend <> 0) b "); 
        
        try {
            recordset = BelcorpService.getInstance().dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("calcularSaldoCCCliente" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (!recordset.esVacio() && recordset.getValueAt(0,0) != null) {
           valorRetorno = ((BigDecimal)recordset.getValueAt(0, 0));
        } else {
            valorRetorno = new BigDecimal(0);   
        }
        UtilidadesLog.info("DAOCCC.calcularSaldoCCCliente(Long oidCliente, Long oidPais): Salida"); 
        
        return valorRetorno;
    }

   /*
    * Autor: 
    * Fecha: 
    * Descripción: Obtenemos los registros de Movimientos Cuentas Corrientes
    * @throws MareException
    * Notas:
    *       BELC300008016	BELC300008022
    *       @eiraola 14/12/2005, refac. segun modelo: GCC-CCC-001_2005.11.09 GMIOTTI DT 
    */
    public RecordSet obtenerMovCCProcSubprocCreacion(Long oidPais,
                                                     String codigoProceso, 
                                                     Integer codigoSubproceso, 
                                                     Long oidEmpresa,
                                                     Long oidSubAcceso, 
                                                     String ejercicioCuota, 
                                                     Integer numeroOrdenCuota)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerMovCCProcSubprocCreacion(Long oidPais,  String codigoProceso, Integer codigoSubproceso, Long oidEmpresa,Long oidSubAcceso, String ejercicioCuota, Integer numeroOrdenCuota): Entrada ");        
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT m.* FROM ");
        consulta.append(" CCC_MOVIM_CUENT_CORRI m, CCC_SUBPR s, CCC_PROCE p ");
        consulta.append(" WHERE m.SUBP_OID_SUBP_CREA = s.OID_SUBP ");
        consulta.append(" AND s.CCPR_OID_PROC = p.OID_PROC ");

        Vector parametros = new Vector();

        consulta.append(" AND p.COD_PROC = ? ");
        parametros.add(codigoProceso);

        consulta.append(" AND s.COD_SUBP = ? ");
        parametros.add(codigoSubproceso);

        consulta.append(" AND m.SOCI_OID_SOCI = ?  ");
        parametros.add(oidEmpresa);

        consulta.append(" AND m.SBAC_OID_SBAC = ? ");
        parametros.add(oidSubAcceso);

        consulta.append(" AND m.VAL_EJER_CUOT = ? ");
        parametros.add(ejercicioCuota);

        consulta.append(" AND m.NUM_IDEN_CUOT = ? ");
        parametros.add(numeroOrdenCuota);

        consulta.append(" AND p.PAIS_OID_PAIS =  ? ");
        parametros.add(oidPais);

        //consulta.append("ORDER BY m.SOCI_OID_SOCI "); // Eliminado GCC-CCC-001

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerMovCCProcSubprocCreacion: Exception", e);
            this.logSql("obtenerMovCCProcSubprocCreacion. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOCCC.obtenerMovCCProcSubprocCreacion(Long oidPais,  String codigoProceso, Integer codigoSubproceso, Long oidEmpresa,Long oidSubAcceso, String ejercicioCuota, Integer numeroOrdenCuota): Salida");        
        return resultado;
    }

      //Gacevedo. Se agrega el metodo 
      //en respuesta a la incidencia V-CCC-008. 13/11/2006
    public RecordSet obtenerDatosSubproceso(Long pais, String codigoProceso,
        Integer codigoSubproceso) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerDatosSubproceso(Long pais, String codigoProceso, Integer codigoSubproceso): Entrada ");        
        /* Incidencia:   BELC300007998
         * Los parámetros que recibe el método son:
         * codigoProceso => String:6
         * codigoSubproceso => Integer:1
         * pais => Long:12*/
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT s.OID_SUBP , s.VAL_INDI_ACTU_CUOT ");
        consulta.append("FROM CCC_SUBPR s, ");
        consulta.append(" CCC_PROCE p ");
        consulta.append(" WHERE s.CCPR_OID_PROC = p.OID_PROC ");
        consulta.append(" AND s.COD_SUBP = ? ");
        consulta.append(" AND p.COD_PROC = ? ");
        consulta.append(" AND p.PAIS_OID_PAIS = ? ");

        // Parametros de la consulta
        Vector parametros = new Vector();
        parametros.add(codigoSubproceso);
        parametros.add(codigoProceso);
        parametros.add(pais);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerDatosSubproceso: Exception", e);
            this.logSql("obtenerDatosSubproceso. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        if(rs.esVacio()){
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            Exception e = new Exception("No se encuentra el subproceso");
            this.logError("obtenerDatosSubproceso: Exception", e);
            this.logSql("obtenerDatosSubproceso. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
           
        }

        UtilidadesLog.info("DAOCCC.obtenerDatosSubproceso(Long pais, String codigoProceso, Integer codigoSubproceso): Salida ");        
        return rs;
    }


    public Long obtenerOIDSubproceso(Long pais, String codigoProceso,
        Integer codigoSubproceso) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerOIDSubproceso(Long pais, String codigoProceso, Integer codigoSubproceso): Entrada ");        
        /* Incidencia:   BELC300007998
         * Los parámetros que recibe el método son:
         * codigoProceso => String:6
         * codigoSubproceso => Integer:1
         * pais => Long:12*/
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT s.OID_SUBP ");
        consulta.append("FROM CCC_SUBPR s, ");
        consulta.append(" CCC_PROCE p ");
        consulta.append(" WHERE s.CCPR_OID_PROC = p.OID_PROC ");
        consulta.append(" AND s.COD_SUBP = ? ");
        consulta.append(" AND p.COD_PROC = ? ");
        consulta.append(" AND p.PAIS_OID_PAIS = ? ");

        // Parametros de la consulta
        Vector parametros = new Vector();
        parametros.add(codigoSubproceso);
        parametros.add(codigoProceso);
        parametros.add(pais);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        Long resultado = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerOIDSubproceso: Exception", e);
            this.logSql("obtenerOIDSubproceso. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOCCC.obtenerOIDSubproceso(Long pais, String codigoProceso, Integer codigoSubproceso): Salida ");        
        return resultado = new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
    }

    public DTOSalida obtenerMarcasTipoAbono(String codigoProceso,
        String codigoSubproceso, Long pais) throws MareException {
        /**
         *         Obtenemos los registros de las Marcas de situación relacionadas (por tipoAbono) en función del codigoProceso, codigoSubproceso y pais
         *
         *        SELECT u.OID_MARC_SITU, m.TASP_OID_TIPO_ABON_SUBP
         *        FROM
         *        CCC_MARCA_SITUA u,
         *        CCC_MARCA_TIPO_ABONO m,
         *        CCC_TIPO_ABONO_SUBPR t,
         *        CCC_SUBPR s,
         *        CCC_PROCE p
         *
         *        WHERE
         *        //joins
         *        u.OID_MARC_SITU = m.MASI_OID_MARC_SALI AND
         *        m.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP AND
         *        t.SUBP_OID_SUBP = s.OID_SUBP AND
         *        s.CCPR_OID_PROC = p.OID_PROC AND
         *
         *        //criterios filtro
         *        s.COD_SUBP = codigoSubproceso AND
         *        p.COD_PROC = codigoProceso AND
         *        u.PAIS_OID_PAIS = pais
         */
        UtilidadesLog.info("DAOCCC.obtenerMarcasTipoAbono(String codigoProceso, String codigoSubproceso, Long pais): Entrada ");        

        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT u.OID_MARC_SITU, m.TASP_OID_TIPO_ABON_SUBP");
        consulta.append(" FROM");
        consulta.append(" CCC_MARCA_SITUA u,");
        consulta.append(" CCC_MARCA_TIPO_ABONO m,");
        consulta.append(" CCC_TIPO_ABONO_SUBPR t,");
        consulta.append(" CCC_SUBPR s,");
        consulta.append(" CCC_PROCE p");
        consulta.append(" WHERE");
        consulta.append(" u.OID_MARC_SITU = m.MASI_OID_MARC_SALI AND");
        consulta.append(" m.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP AND");
        consulta.append(" t.SUBP_OID_SUBP = s.OID_SUBP AND");
        consulta.append(" s.CCPR_OID_PROC = p.OID_PROC AND");
        consulta.append(" s.COD_SUBP = ? AND"); //codigoSubproceso
        consulta.append(" p.COD_PROC = ? AND "); //codigoProceso
        consulta.append(" u.PAIS_OID_PAIS = ?"); //pais

        //parametros de la consulta
        Vector parametros = new Vector();
        parametros.add(codigoProceso);
        parametros.add(codigoSubproceso);
        parametros.add(pais);

        //Se ejecuta la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerMarcasTipoAbono: Exception", e);
            this.logSql("obtenerMarcasTipoAbono. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOCCC.obtenerMarcasTipoAbono(String codigoProceso, String codigoSubproceso, Long pais): Salida ");        
        return dtoSalida;
    }

    public RecordSet obtenerProcUltimoSubprocMovCC(Long oid)
        throws MareException {
        /**
                 * Devuelve un único registro con el codigoProceso y codigoSubproceso para el oid de MovimientoCuentasCorrientes y subprocesoUltimo (FK contra subprocesos).
                 *        SELECT p.COD_PROC, s.COD_SUBP
                 *
                 *        FROM
                 *        CCC_MOVIM_CUENT_CORRI m,
                 *        CCC_SUBPR s,
                 *        CCC_PROCE p,
                 *
                 *        WHERE
                 *        //joins
                 *        m.SUBP_OID_SUBP_ULTI = s.OID_SUBP AND
                 *        s.CCPR_OID_PROC = p.OID_PROC AND
                *
                 *        //criterios de filtro
                 *        v.OID_MOVI_CC = oid
                 */
        UtilidadesLog.info("DAOCCC.obtenerProcUltimoSubprocMovCC(Long oid): Entrada ");        

        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT p.COD_PROC, s.COD_SUBP");
        consulta.append(" FROM");
        consulta.append(" CCC_MOVIM_CUENT_CORRI m,");
        consulta.append(" CCC_SUBPR s,");
        consulta.append(" CCC_PROCE p");
        consulta.append(" WHERE");
        consulta.append(" m.SUBP_OID_SUBP_ULTI = s.OID_SUBP AND");
        consulta.append(" s.CCPR_OID_PROC = p.OID_PROC AND");
        consulta.append(" m.OID_MOVI_CC = ?");

        Vector parametros = new Vector();
        parametros.add(oid);

        //Se ejecuta la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerProcUltimoSubprocMovCC: Exception", e);
            this.logSql("obtenerProcUltimoSubprocMovCC. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOCCC.obtenerProcUltimoSubprocMovCC(Long oid): Salida ");
        return rs;
    }

    public DTOSalida obtenerSituacionesCupon() throws MareException {
        /**
                 *        SELECT OID_SITU_CUPO, VAL_DESC_SITU_CUPO
                 *        FROM
                 *        CCC_SITUA_CUPON
                 */
        UtilidadesLog.info("DAOCCC.obtenerSituacionesCupon(): Entrada "); 

        //Construccion de la consulta
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT OID_SITU_CUPO, VAL_DESC_SITU_CUPO");
        consulta.append(" FROM CCC_SITUA_CUPON WHERE ");
        //cambio fac 03, modulo ccc (SCS-29/01/2008) , no quiero la sit. conciliado
        consulta.append(" COD_SITU_CUPO != '" + CCCConstantes.SITUACION_CUPON_CONCILIADO + "'");
        consulta.append(" ORDER BY VAL_DESC_SITU_CUPO");
        //Se ejecuta la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerSituacionesCupon: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOCCC.obtenerSituacionesCupon(): Salida ");
        return dtoSalida;
    }
    public DTOSalida obtenerSituacionesCuponTodas() throws MareException {
        /**
                 *        SELECT OID_SITU_CUPO, VAL_DESC_SITU_CUPO
                 *        FROM
                 *        CCC_SITUA_CUPON
                 */
        UtilidadesLog.info("DAOCCC.obtenerSituacionesCuponTodas(): Entrada "); 

        //Construccion de la consulta
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT OID_SITU_CUPO, VAL_DESC_SITU_CUPO");
        consulta.append(" FROM CCC_SITUA_CUPON ");
        consulta.append(" ORDER BY VAL_DESC_SITU_CUPO");

        //Se ejecuta la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerSituacionesCupon: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOCCC.obtenerSituacionesCuponTodas(): Salida ");
        return dtoSalida;
    }
    
    public Byte obtenerIndEmisionVtoPais(Long oidPais)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerIndEmisionVtoPais(Long oidPais): Entrada ");
        //modifica por incidencia 16736: hay que filtrar por el usuario
        //se modifica por la incidencia 17292: hay que usar la tabla, no la vista
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT ");
        consulta.append(" IND_EMIS_VENC ");
        consulta.append(" FROM ");
        //consulta.append(" VCA_SEG_PAIS p ");
        consulta.append(" SEG_PAIS p");
        consulta.append(" WHERE ");
        consulta.append(" p.OID_PAIS =  " + oidPais);
        //consulta.append(" AND p.COD_USUA  = '" + this.usuario +"'");

        RecordSet resultado = null;
        Byte salida = null;
        String codigoError = null;

        try {
            resultado = getBelcorpService().dbService.executeStaticQuery(consulta.toString());

            if (!resultado.esVacio()) {
                salida = new Byte(((BigDecimal) resultado.getValueAt(0, 0)).byteValue());
            }
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            this.logError("obtenerIndEmisionVtoPais: Exception", e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOCCC.obtenerIndEmisionVtoPais(Long oidPais): Salida ");

        return salida;
    }

    //construcion gpm N0016 CCC
    public DTOOID obtenerOIDBancoPorOIDCC(DTOOID dtoOIDCC)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerOIDBancoPorOIDCC(DTOOID dtoOIDCC): Entrada ");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        DTOOID dtoBanco = new DTOOID();

        consulta.append(" SELECT b.OID_BANC ");
        consulta.append(" FROM CCC_CUENT_CORRI_BANCA c, ");
        consulta.append(" CCC_SUCUR s, ");
        consulta.append(" CCC_BANCO b ");
        consulta.append(" WHERE c.SUCU_OID_SUCU = s.OID_SUCU AND ");
        consulta.append(" s.CBAN_OID_BANC = b.OID_BANC AND ");
        consulta.append(" c.OID_CUEN_CORR_BANC = ? ");
        parametros.add(dtoOIDCC.getOid());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerOIDBancoPorOIDCC: Exception", e);
            this.logSql("obtenerOIDBancoPorOIDCC. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        dtoBanco.setOid(new Long(
                ((BigDecimal) rs.getValueAt(0, "OID_BANC")).longValue()));

        UtilidadesLog.info("DAOCCC.obtenerOIDBancoPorOIDCC(DTOOID dtoOIDCC): Salida ");
        return dtoBanco;
    }

    //construcion gpm N0016 CCC
    public DTOOID obtenerOIDSituacionCuponPorCodigo(String codigoSituacion)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerOIDSituacionCuponPorCodigo(String codigoSituacion): Entrada ");

        DTOOID dto = new DTOOID();
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT OID_SITU_CUPO ");
        consulta.append(" FROM CCC_SITUA_CUPON ");
        consulta.append(" WHERE COD_SITU_CUPO = ? ");
        parametros.add(codigoSituacion);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerOIDSituacionCuponPorCodigo: Exception",
                e);
            this.logSql("obtenerOIDSituacionCuponPorCodigo. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        dto.setOid(new Long(
                ((BigDecimal) rs.getValueAt(0, "OID_SITU_CUPO")).longValue()));

        UtilidadesLog.info("DAOCCC.obtenerOIDSituacionCuponPorCodigo(String codigoSituacion): Salida ");
        return dto;
    }

    public DTOSalida obtenerSubprocesosPorCodProceso(DTOCodigoProceso dto)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerSubprocesosPorCodProceso(DTOCodigoProceso dto): Entrada ");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT OID_SUBP, DES_SUBP ");
        consulta.append("FROM ");
        consulta.append("CCC_SUBPR s, ");
        consulta.append("CCC_PROCE p ");
        consulta.append("WHERE ");

        //joins
        consulta.append("s.CCPR_OID_PROC = p.OID_PROC  ");

        //filtros
        if (dto.getCodigoProceso() != null) {
            consulta.append(" AND COD_PROC = ? "); //dtoE.codigoProceso
            parametros.add(dto.getCodigoProceso());
        }

        //Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerSubprocesosPorCodProceso: Exception", e);
            this.logSql("obtenerSubprocesosPorCodProceso. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoS = new DTOSalida(rs);
        UtilidadesLog.info("DAOCCC.obtenerSubprocesosPorCodProceso(DTOCodigoProceso dto): Salida ");
        return dtoS;
    }

    public Integer obtenerSecuenciaPais(DTOBelcorp dto)
        throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerSecuenciaPais(DTOBelcorp dto): Entrada ");
        
        String anio = null;
        String mes = null;
        Date fecha = new Date(System.currentTimeMillis());
        StringBuffer consulta = new StringBuffer();
        StringBuffer consulta2 = new StringBuffer();
        Vector parametros = new Vector();
        Vector parametros2 = new Vector();
        RecordSet rs = null;        
        String codigoError = null;
        BelcorpService bs = null;

        try {
            MONMantenimientoSEG mantenimientoSEG = this.getIServicioSEG();

            DTOOID dtoOid = new DTOOID();
            dtoOid.setOidIdioma(dto.getOidIdioma());
            dtoOid.setOid(dto.getOidPais());

            DTOSalida dtoSalida = mantenimientoSEG.recuperarPais(dtoOid);

            RecordSet resultadoPais = dtoSalida.getResultado();
            char tipoSecuencial = resultadoPais.getValueAt(0,
                    "VAL_CONF_SECU_CCC").toString().charAt(0);

            switch (tipoSecuencial) {
            case 'U':
                anio = null;
                mes = null;

                break;

            case 'A':
                anio = UtilidadesFecha.convertirAString(fecha, "yy");
                mes = null;

                break;

            case 'M':
                anio = UtilidadesFecha.convertirAString(fecha, "yy");
                mes = UtilidadesFecha.convertirAString(fecha, "MM");

                break;
            }

            consulta.append(" SELECT OID_SECU_PAIS, NUM_SECU ");
            consulta.append(" FROM CCC_SECUE_PAIS ");
            consulta.append(" WHERE PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());

            if (anio != null) {
                consulta.append(" AND NUM_ANIO = ? ");
                parametros.add(anio);
            }

            if (mes != null) {
                consulta.append(" AND NUM_MES = ? ");
                parametros.add(mes);
            }

            consulta.append(" FOR UPDATE ");

            //Se ejecuta la consulta SQL
            bs = UtilidadesEJB.getBelcorpService();
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerSecuenciaPais: Exception", e);
            this.logSql("obtenerSecuenciaPais. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Integer secuencia = null;
        Integer pais = null;
        Integer secuenciaRecuperada = null;

        if (!rs.esVacio()) {
            pais = new Integer(((BigDecimal) rs.getValueAt(0, "OID_SECU_PAIS")).intValue());
            secuenciaRecuperada = new Integer(((BigDecimal) rs.getValueAt(0,
                        "NUM_SECU")).intValue() + 1);

            secuencia = secuenciaRecuperada;

            try {
                consulta2.append(" UPDATE CCC_SECUE_PAIS  ");
                consulta2.append(" SET NUM_SECU = ?  ");
                parametros2.add(secuencia);
                consulta2.append(" WHERE oid_secu_pais = ?  ");
                parametros2.add(pais);
                bs.dbService.executePreparedUpdate(consulta2.toString(),
                    parametros2);
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error("obtenerSecuenciaPais: Exception", e);
                this.logSql("obtenerSecuenciaPais. SQL: ",
                    consulta2.toString(), parametros2);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }
        } else {
            secuencia = new Integer("1");

            try {
                consulta2.append(" INSERT INTO CCC_SECUE_PAIS ( ");
                consulta2.append(" OID_SECU_PAIS, ");
                parametros2.add(SecuenciadorOID.obtenerSiguienteValor(
                            "CCC_SEPA_SEQ"));
                if (dto.getOidPais() != null) {
                    consulta2.append(" PAIS_OID_PAIS, ");
                    parametros2.add(dto.getOidPais());
                }

                if (anio != null) {
                    consulta2.append(" NUM_ANIO, ");
                    parametros2.add(anio);
                }

                if (mes != null) {
                    consulta2.append(" NUM_MES, ");
                    parametros2.add(mes);
                }

                consulta2.append(" NUM_SECU ");
                parametros2.add(secuencia);

                consulta2.append(") VALUES ( ?");

                for (int i = 1; i < parametros2.size(); i++) {
                    consulta2.append(", ?");
                }

                consulta2.append(" ) ");
                bs.dbService.executePreparedUpdate(consulta2.toString(), parametros2);
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error("obtenerSecuenciaPais: Exception", e);
                this.logSql("obtenerSecuenciaPais. SQL: ",
                    consulta2.toString(), parametros2);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }
        }

        UtilidadesLog.info("DAOCCC.obtenerSecuenciaPais(DTOBelcorp dto): Salida ");
        return secuencia;
    }

	public DTOSalida obtieneSubprocesosProcesoPais(DTOCodigoProceso dto) 
		throws MareException {
		
        UtilidadesLog.info("DAOCCC.obtieneSubprocesosProcesoPais(DTOCodigoProceso dto): Entrada ");
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		consulta.append("SELECT B.oid_subp, B.des_subp ");
		consulta.append("FROM ccc_proce A, ccc_subpr B ");
		consulta.append("WHERE ");
		if (dto.getOidPais() != null) {
			consulta.append("A.pais_oid_pais = ? AND ");
            parametros.add(dto.getOidPais());
        }
		if (dto.getCodigoProceso() != null) {
			consulta.append("A.cod_proc = ? AND ");
			parametros.add(dto.getCodigoProceso());
		}
		consulta.append("B.ccpr_oid_proc = A.oid_proc ");
		//Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
		try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtieneSubprocesosProcesoPais: Exception", e);
            this.logSql("obtieneSubprocesosProcesoPais. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        DTOSalida dtoS = new DTOSalida(rs);
		UtilidadesLog.info("DAOCCC.obtieneSubprocesosProcesoPais(DTOCodigoProceso dto): Salida ");
		return dtoS;
	}

	public DTOSalida obtenerTiposCargo(DTOBelcorp dto) throws MareException {
        /*
                -> Hacer consulta JDBC sobre la tabla CCC_TIPO_CARGO_ABONO con las siguientes
                condiciones:
                -> CCC_TIPO_CARGO_ABONO.PAIS_OID_PAIS = dto.pais
                -> Obtener los siguientes campos:
                    - OID_TIPO_CARG_ABON (oid del tipo)
                    - Descripción internacionalizable del tipo, tomando el idioma de dto.idioma
                -> Devolver RecordSet obtenido encapsulado en un DTOSalida
                */        
		UtilidadesLog.info("DAOCCC.obtenerTiposCargo(DTOBelcorp dto): Entrada ");
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
       
		consulta.append("SELECT OID_TIPO_CARG_ABON AS OID, ");

        consulta.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        consulta.append(" IDIO.attr_enti = 'CCC_TIPO_CARGO_ABONO' AND IDIO.idio_oid_idio = ? AND ");
        consulta.append(" IDIO.val_oid = OID_TIPO_CARG_ABON ) AS DESCRIPCION ");
        parametros.add(dto.getOidIdioma());

		consulta.append("FROM CCC_TIPO_CARGO_ABONO ");
		consulta.append("WHERE ");
		consulta.append("PAIS_OID_PAIS = ? ");
        parametros.add(dto.getOidPais());
        
        consulta.append(" ORDER BY DESCRIPCION "); 

		//Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
		try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerTiposCargo: Exception", e);
            this.logSql("obtenerTiposCargo. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        DTOSalida dtoS = new DTOSalida(rs);
		UtilidadesLog.info("DAOCCC.obtenerTiposCargo(DTOBelcorp dto): Salida ");
		return dtoS;
	}

	public String obtieneCodSubproceso(Long oidSubproceso) throws MareException {
		
        UtilidadesLog.info("DAOCCC.obtieneCodSubproceso(Long oidSubproceso): Entrada ");
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		consulta.append("SELECT cod_subp ");
		consulta.append("FROM ccc_subpr ");
		consulta.append("WHERE oid_subp = ? "); //oidSubproceso
		parametros.add(oidSubproceso);
		//Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
		try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtieneCodSubproceso: Exception", e);
            this.logSql("obtieneCodSubproceso. SQL: ", consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
		String salida = null;
		if(rs.getValueAt(0,0)!=null) {
			salida = rs.getValueAt(0,0).toString();
		}
		UtilidadesLog.info("DAOCCC.obtieneCodSubproceso(Long oidSubproceso): Salida ");
		return salida;
	}

    private MONMantenimientoSEG getIServicioSEG() throws MareException {
        
        UtilidadesLog.info("DAOCCC.getIServicioSEG(): Entrada ");

        // Se obtiene el interfaz home
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome) UtilidadesEJB.getHome("MONMantenimientoSEG",
                MONMantenimientoSEGHome.class);

        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            this.logStackTrace(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOCCC.getIServicioSEG(): Salida ");
        return ejb;
    }

    private void logStackTrace(Throwable e) {
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }

    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
    
        UtilidadesLog.debug(metodo + sql);
        if ((params != null) && (params.size() > 0)) {
            String sParams = "";
            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }
            UtilidadesLog.debug(metodo + sParams);
        }
    }

	public RecordSet obtieneProcesosPais(long pais, boolean CVDirectos) throws MareException {
		
        UtilidadesLog.info("DAOCCC.obtieneProcesosPais(long pais, boolean CVDirectos): Entrada ");
        UtilidadesLog.info("DAOCCC.obtieneProcesosPais(long pais, boolean CVDirectos): Salida ");
		return this.obtieneProcesosPais(pais, CVDirectos, true);
	}

    public void eliminarMarcasTipoAbono(Long oid) throws MareException
    {
        // DELETE FROM CCC_MARCA_TIPO_ABONO 
        //WHERE TASP_OID_TIPO_ABON_SUBP = DTOE.oid
        
        UtilidadesLog.info("DAOCCC.eliminarMarcasTipoAbono(Long oid): Entrada ");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("DELETE FROM CCC_MARCA_TIPO_ABONO ");
		consulta.append("WHERE TASP_OID_TIPO_ABON_SUBP = ?");

		parametros.add(oid);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;

		try  {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception ex) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }		
		UtilidadesLog.info("DAOCCC.eliminarMarcasTipoAbono(Long oid): Salida ");	    
    }
    
     public DTOSalida obtenerProcesosActivos(DTOBelcorp dto) throws MareException {

        UtilidadesLog.info("DAOCCC.obtenerProcesosActivos(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        DTOSalida dtoS = new DTOSalida();

        query.append(" select p.OID_PROC, p.DES_PROC ");
        query.append(" from ccc_proce p ");
        query.append(" where p.IND_CV_DIRE = 1 ");
        query.append(" and p.PAIS_OID_PAIS = " +  dto.getOidPais());
        query.append(" order by 2 "); 
        
        try  {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOCCC.obtenerProcesosActivos(DTOBelcorp dto): Salida ");
        return dtoS;
    }
    
     public DTOSalida obtenerTipoCargoProcesos(DTOBelcorp dto) throws MareException {

        UtilidadesLog.info("DAOCCC.obtenerTipoCargoProcesos(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        DTOSalida dtoS = new DTOSalida();

        query.append(" select subp.CCPR_OID_PROC,asub.OID_TIPO_ABON_SUBP, idio.VAL_I18N ");
        query.append(" from ccc_tipo_cargo_abono abono, ccc_tipo_abono_subpr asub, ccc_subpr subp ,V_GEN_I18N_SICC IDIO ");
        query.append(" where asub.TCAB_OID_TCAB = abono.OID_TIPO_CARG_ABON ");
        query.append(" and   subp.OID_SUBP = asub.SUBP_OID_SUBP ");
        query.append(" and IDIO.attr_enti = 'CCC_TIPO_CARGO_ABONO'  ");
        query.append(" AND IDIO.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" AND IDIO.val_oid = abono.OID_TIPO_CARG_ABON ");
        query.append(" group by subp.CCPR_OID_PROC,asub.OID_TIPO_ABON_SUBP, idio.VAL_I18N ");
        query.append(" order by 2  ");
        
        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOCCC.obtenerTipoCargoProcesos(DTOBelcorp dto): Salida ");
        return dtoS;

    }
    
    public DTOSalida obtenerTipoCargoCCC004(DTOBelcorp dto) throws MareException{
        
        UtilidadesLog.info("DAOCCC.obtenerTipoCargoCCC004(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        DTOSalida dtoS = new DTOSalida();

        query.append(" select abono.OID_TIPO_CARG_ABON, idio.VAL_I18N ");
        query.append(" from ccc_tipo_cargo_abono abono, ccc_tipo_abono_subpr asub, ccc_subpr subp ,V_GEN_I18N_SICC IDIO, ccc_proce proceso  ");
        query.append(" where asub.TCAB_OID_TCAB = abono.OID_TIPO_CARG_ABON  ");
        query.append(" and   subp.OID_SUBP = asub.SUBP_OID_SUBP ");
        query.append(" and   subp.CCPR_OID_PROC = proceso.OID_proc ");
        query.append(" and   proceso.COD_proc = 'CCC004'  ");
        query.append(" and IDIO.attr_enti = 'CCC_TIPO_CARGO_ABONO'   ");
        query.append(" AND IDIO.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" AND IDIO.val_oid = abono.OID_TIPO_CARG_ABON  ");
        query.append(" group by abono.OID_TIPO_CARG_ABON, idio.VAL_I18N  ");
        query.append(" order by 2 "); 
        
        try  {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOCCC.obtenerTipoCargoCCC004(DTOBelcorp dto): Salida ");
        return dtoS;
      }
      
      
       /** 
         * Método para consultar el informe de REPConsultaCC
         * @param dto DTOString con el codigo de cliente
         * @return Recordset
         * @exception MareException si no encontro nada
         * mdolce
         * 18/05/2005
         * 16/08/2006 - [1] - pperanzola, se corrige por performance
         * 09/04/2007 - [2] - Rafael Romero, se agrega campo para recuperar Fecha de Nacimiento - Incidencia SiCC 20070177
         */
           
      public RecordSet repConsultaCC(DTORepBusquedaCC dto) throws MareException {
        
        UtilidadesLog.info("DAOCCC.repConsultaCC(DTORepBusquedaCC dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT  mc.val_nom1 || ' ' || mc.val_nom2 || ' ' || mc.val_ape1 || ' ' || mc.val_ape2 AS apenom, ");
        query.append(" mc.fec_ingr, mtd.cod_tipo_docu, mci.num_docu_iden, zsgv.DES_SUBG_VENT, ");
        ///* [1] query.append(" zr.DES_REGI, zz.DES_ZONA, mcda.IMP_MONT_LINE_CRED, cnr.COD_NIVE_RIES, estadoCliente.VAL_I18N  ");
        query.append(" zr.DES_REGI, zz.DES_ZONA, mcda.IMP_MONT_LINE_CRED, cnr.COD_NIVE_RIES ");
        query.append(" ,Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",  mcda.esta_oid_esta_clie, 'MAE_ESTAT_CLIEN')  AS val_i18n  ,	mc.OID_CLIE OIDCLIENTE ");
        //*/[1]
        //  Modificado por HRCS - Fecha 02/04/2007 - Incidencia Sicc20070176
        query.append(" , tr.cod_terr territorio ");
        // [2]i Rafael Romero - 04/09/2007 - SiCC 20070177
        query.append(" , mcda.fec_naci FECHANACIMIENTO ");
        // [2]f
        query.append(" FROM mae_clien mc, mae_clien_ident mci, mae_clien_datos_adici mcda, ");
        query.append(" mae_tipo_docum mtd, mae_clien_unida_admin mcua, zon_terri_admin zta, zon_terri tr, ");   // Se agrego ZON_TERRI
        query.append(" zon_secci zs, zon_zona zz, zon_regio zr,  zon_sub_geren_venta zsgv, ");
	    query.append(" car_nivel_riesg cnr ");// [1] query.append(" car_nivel_riesg cnr, gen_i18n_sicc_comun estadoCliente, ");
	    //query.append(" mae_estat_clien msc, FAC_TIPO_DOCUM ftd   ");
        query.append(" WHERE mc.cod_clie = '" + dto.getCodCliente() + "'");
        query.append(" AND mc.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND mc.oid_clie = mci.clie_oid_clie ");
        query.append(" and mc.OID_CLIE = mcda.CLIE_OID_CLIE "); 
        query.append(" AND mci.val_iden_docu_prin = 1 ");
        query.append(" and mci.TDOC_OID_TIPO_DOCU = mtd.OID_TIPO_DOCU");
        //query.append(" AND mtd.TIDO_OID_TIPO_DOCU = ftd.OID_TIPO_DOCU "); 
        query.append(" AND mc.oid_clie = mcua.clie_oid_clie ");
        query.append(" AND mcua.ztad_oid_terr_admi = zta.oid_terr_admi ");
        query.append(" AND mcua.ind_acti = 1 ");
        query.append(" AND zta.zscc_oid_secc = zs.oid_secc ");
        query.append(" AND zs.zzon_oid_zona = zz.oid_zona ");
        query.append(" AND zz.zorg_oid_regi = zr.oid_regi ");
        query.append(" AND zr.zsgv_oid_subg_vent = zsgv.oid_subg_vent ");
        query.append(" and mcda.NIRI_OID_NIVE_RIES = cnr.OID_NIVE_RIES ");
        query.append(" and mcda.NIRI_OID_NIVE_RIES = cnr.OID_NIVE_RIES "); //[1]
        ///*[1]
        // query.append(" and mcda.ESTA_OID_ESTA_CLIE = msc.OID_ESTA_CLIE ");
        // query.append(" and msc.OID_ESTA_CLIE = estadoCliente.VAL_OID ");
        // query.append(" and estadoCliente.ATTR_ENTI = 'MAE_ESTAT_CLIEN' ");
        // query.append(" and estadoCliente.IDIO_OID_IDIO = " +  dto.getOidIdioma());
        //*/[1]
        //  Modificado por HRCS - Fecha 02/04/2007 - Incidencia Sicc20070176
        query.append(" AND zta.terr_oid_terr = tr.oid_terr ");
        query.append(" AND zta.pais_oid_pais = tr.pais_oid_pais ");
         
        try  {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());            
            if (rs.esVacio()) {
               throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }        
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex) {
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCCC.repConsultaCC(DTORepBusquedaCC dto): Salida ");
        return rs;
      }
      
      /**
     * @author pperanzola
     * @date 16/08/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
       public RecordSet obtenerDetalleConsultaCC2(DTOFiltroCC dto) throws MareException{
           UtilidadesLog.info("DAOCCC.obtenerDetalleConsultaCC2(DTOFiltroCC dto): Entrada ");
           
           StringBuffer query = new StringBuffer();
           RecordSet rs;
           //query.append(" SELECT   cargocabecera.oid_cabe_carg AS OID, ");
           query.append(" SELECT   ");
           query.append(" cargodetalle.oid_deta_carg_abon_dire, ");
           query.append(" TO_CHAR (cargocabecera.fec_docu, 'dd/MM/yyyy'), ");
           query.append(" TO_CHAR (cargocabecera.fec_valo, 'dd/MM/yyyy'), ");
           //se saca la descripcion internacionalizable y ak se hardcodea según pedido de cambio CCC-020 :S
           query.append(" CASE WHEN tipoabono.tcab_oid_tcab = 2001 THEN CASE WHEN EXISTS (");
           query.append(" SELECT oid_soli_cabe FROM ped_solic_cabec p, PED_TIPO_SOLIC_PAIS TP, ped_tipo_solic t ");
           query.append(" WHERE p.soca_oid_soli_cabe = movctacte.soca_oid_soli_cabe ");
           query.append(" AND P.TSPA_OID_TIPO_SOLI_PAIS = TP.OID_TIPO_SOLI_PAIS ");
           query.append(" AND TP.TSOL_OID_TIPO_SOLI = T.OID_TIPO_SOLI ");
           query.append(" AND p.ind_oc = 1 AND t.IND_SOLI_NEGA = 0) ");
           query.append(" THEN 'Pedido' ELSE 'Atención de Servicio' END ELSE ");
           query.append(" Pq_Apl_Aux.valor_gen_i18n_sicc ("+ dto.getOidIdioma()+ ", tipoabono.tcab_oid_tcab, 'CCC_TIPO_CARGO_ABONO') END AS val_i18n, ");
           //fin del cambio CCC-020
           query.append(" nvl2(movctacte.num_iden_cuot, movctacte.num_iden_cuot , nvl2(cargodetalle.ccba_oid_cuen_corr_banc ,(  ");
                     query.append(" select movim_banca.num_lote from  ccc_movim_banca movim_banca where movim_banca.OID_MOVI_BANC = cargodetalle.CMBA_OID_MOVI_BANC ");
           query.append(" ), ");
           query.append(" NULL ");
           query.append(" ) ");
           query.append(" ) AS numerodocumento,");
           //query.append(" CASE  WHEN (movctacte.num_iden_cuot IS NOT NULL) ");
           //    query.append("   THEN movctacte.num_iden_cuot ");
          //     query.append("   ELSE CASE WHEN (cargodetalle.ccba_oid_cuen_corr_banc IS NOT NULL) ");
           //        query.append("    THEN movctacte.num_lote_fact ");
          // query.append("  END    END AS numerodocumento, ");
           query.append("  cargocabecera.num_cabe, ");
           query.append("  (SELECT cuentacorriente.cod_cc ");
           query.append("      FROM CCC_CUENT_CORRI_BANCA cuentacorriente ");
           query.append("      WHERE cargodetalle.ccba_oid_cuen_corr_banc = cuentacorriente.oid_cuen_corr_banc ");
           query.append("      AND cuentacorriente.pais_oid_pais = "+ dto.getOidPais() +") AS banco, ");
           query.append("  (SELECT periodocorporativo.cod_peri ");
           query.append("     FROM CRA_PERIO periodocronograma, ");
           query.append("          SEG_PERIO_CORPO periodocorporativo ");
           query.append("      WHERE periodocronograma.peri_oid_peri = periodocorporativo.oid_peri ");
           query.append("      AND movctacte.perd_oid_peri = periodocronograma.oid_peri) AS periodo, ");
           query.append(" CASE WHEN subproceso.val_indi_cons = 'H' ");
           query.append("      THEN cargodetalle.imp * -1 ");
           query.append("      ELSE cargodetalle.imp ");
           query.append(" END AS importe, ");
           //query.append(" 0 AS saldo, subproceso.cod_subp, proceso.cod_proc, ");
           query.append(" 0 AS saldo, subproceso.cod_subp, ");
           query.append(" movctacte.perd_oid_peri, subproceso.val_indi_cons ");
           //  Agregado por HRCS - Fecha 21/06/2007 - Cambio Sicc20070296
           query.append(" , movctacte.soca_oid_soli_cabe consolidado ");
           //  Agregado por HRCS - Fecha 09/07/2007 - Cambio Sicc20070318
                   query.append(" , TO_CHAR (cargodetalle.fec_pago_banc, 'dd/MM/yyyy') as fec_pag ");
                   query.append(" , TO_CHAR (cargodetalle.fec_movi, 'dd/MM/yyyy') as fec_mov ");
           //jrivas CCC-04 24/7/2008
           query.append("  , TO_CHAR ((SELECT cmcc.FEC_VENC ");
           query.append("              FROM ccc_movim_cuent_corri cmcc, ");
           query.append("                            ccc_marca_situa ms, ");
           query.append("                   ccc_marca_tipo_abono mta, ");
           query.append("                   ccc_tipo_abono_subpr tas, ");
           query.append("                   ccc_subpr s, ");
           query.append("                   ccc_proce p ");
           query.append("             WHERE mta.ind_entr_sali = 'S' ");
           query.append("               AND mta.tasp_oid_tipo_abon_subp = tas.oid_tipo_abon_subp ");
           query.append("               AND tas.subp_oid_subp = s.oid_subp ");
           query.append("               AND s.cod_subp = '001' ");
           query.append("               AND s.ccpr_oid_proc = p.oid_proc ");
           query.append("               AND p.cod_proc = 'CCC001' ");
           query.append("               AND mta.masi_oid_marc_sali = ms.oid_marc_situ ");
           query.append("                    and cmcc.CLIE_OID_CLIE = " + dto.getOidCliente());
           query.append("                    and cmcc.OID_MOVI_CC = movctacte.oid_movi_cc  ");
           query.append("               AND ROWNUM = 1), 'dd/MM/yyyy') Fecha_Vencimiento ");     
           query.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC cargodetalle, ");
           query.append("      CCC_CABEC_CARGA_ABONO_DIREC cargocabecera, ");
           query.append("      CCC_TIPO_ABONO_SUBPR tipoabono, ");
           query.append("      CCC_SUBPR subproceso, ");
           //query.append("      CCC_PROCE proceso, ");
           //query.append("      CCC_MOVIM_CUENT_CORRI movctacte ");
           query.append("      (SELECT * FROM CCC_MOVIM_CUENT_CORRI  WHERE clie_oid_clie = "+ dto.getOidCliente() + ")movctacte ");
           query.append(" WHERE cargodetalle.ccad_oid_cabe_carg = cargocabecera.oid_cabe_carg ");
           query.append(" AND cargocabecera.pais_oid_pais =  " + dto.getOidPais());
           //query.append(" AND cargocabecera.clie_oid_clie =  " + dto.getOidCliente());
           query.append(" AND cargodetalle.clie_oid_clie =  " + dto.getOidCliente());
           query.append(" AND cargodetalle.tasp_oid_tipo_abon_subp = tipoabono.oid_tipo_abon_subp ");
           query.append(" AND tipoabono.subp_oid_subp = subproceso.oid_subp ");
           query.append(" AND subproceso.val_indi_cons IN ('A', 'D', 'H') ");
           //query.append(" AND subproceso.ccpr_oid_proc = proceso.oid_proc ");
           query.append(" AND cargodetalle.mvcc_oid_movi_cc = movctacte.oid_movi_cc(+) ");       

           if (dto.getOidNumeroCargo() != null) {
              query.append(" AND   movctacte.NUM_IDEN_CUOT = " + dto.getOidNumeroCargo());
           }
           
           query.append(" ORDER BY cargocabecera.fec_docu DESC "); // Se agrego ordenamiento DESC - Incidencia SICC 20070044
           
             
           try {

               rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());            
               if (rs.esVacio()) {
                  throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
               }            
           } catch (MareException me)  {
               throw me;
           } catch (Exception ex) {
               throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
           }
           UtilidadesLog.info("DAOCCC.obtenerDetalleConsultaCC2(DTOFiltroCC dto): Salida ");
           return rs;
           
       }
      
      public RecordSet obtenerDetalleConsultaCC(DTOFiltroCC dto) throws MareException{
        
        UtilidadesLog.info("DAOCCC.obtenerDetalleConsultaCC(DTOFiltroCC dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append("SELECT cargocabecera.oid_cabe_carg AS OID, ");
        query.append("    cargodetalle.oid_deta_carg_abon_dire, ");
        query.append("    TO_CHAR (cargocabecera.fec_docu, 'dd/MM/yyyy'), ");
        query.append("    TO_CHAR (cargocabecera.fec_valo, 'dd/MM/yyyy'), descripcion.val_i18n, ");
        query.append("    CASE ");
        query.append("       WHEN (movctacte.NUM_IDEN_CUOT IS NOT NULL ");
        query.append("            ) ");
        query.append("          THEN movctacte.NUM_IDEN_CUOT ");
        query.append("       ELSE CASE ");
        query.append("       WHEN (cargodetalle.ccba_oid_cuen_corr_banc IS NOT NULL) ");
        query.append("          THEN movctacte.NUM_LOTE_FACT ");
        query.append("    ELSE NULL ");
        query.append("        END ");
        query.append("        END AS numerodocumento, ");
        query.append("        cargocabecera.num_cabe, cuentacorriente.cod_cc_banc AS banco, ");
        query.append("        periodocorporativo.cod_peri AS periodo, ");
        query.append("        CASE ");
        query.append("           WHEN subproceso.val_indi_cons = 'H' ");
        query.append("              THEN cargodetalle.imp * -1 ");
        query.append("           ELSE cargodetalle.imp ");
        query.append("        END AS importe, ");
        query.append("        0 AS saldo, subproceso.cod_subp, proceso.cod_proc, ");
        query.append("        movctacte.PERD_OID_PERI, ");
//Agregado por incidencia BELC300022970 
        query.append("    	  subproceso.VAL_INDI_CONS ");
        query.append("      FROM CCC_DETAL_CARGO_ABONO_DIREC cargodetalle, ");
        query.append("        CCC_CABEC_CARGA_ABONO_DIREC cargocabecera, ");
        query.append("        CCC_CUENT_CORRI_BANCA cuentacorriente, ");
        query.append("        CCC_TIPO_ABONO_SUBPR tipoabono, ");
        query.append("        GEN_I18N_SICC_PAIS descripcion, ");
        query.append("        CCC_MOVIM_CUENT_CORRI ctacorriente, ");
        query.append("        CRA_PERIO periodocronograma, ");
        query.append("        seg_perio_corpo periodocorporativo, ");
        query.append("        CCC_SUBPR subproceso, ");
        query.append("        CCC_PROCE proceso, ");
        query.append("    	   CCC_MOVIM_CUENT_CORRI movctacte ");
        query.append("     WHERE cargodetalle.ccad_oid_cabe_carg = cargocabecera.oid_cabe_carg ");
        query.append("    AND cargocabecera.pais_oid_pais = " + dto.getOidPais());
        query.append("    AND cargodetalle.clie_oid_clie =  " + dto.getOidCliente());
        query.append("    AND cargodetalle.ccba_oid_cuen_corr_banc = cuentacorriente.oid_cuen_corr_banc(+) ");
        query.append("    AND cargodetalle.tasp_oid_tipo_abon_subp = tipoabono.oid_tipo_abon_subp ");
        query.append("    AND tipoabono.subp_oid_subp = subproceso.oid_subp ");
        query.append("    AND subproceso.val_indi_cons IN ('A', 'D', 'H') ");
        query.append("    AND tipoabono.oid_tipo_abon_subp = descripcion.val_oid ");
        query.append("    AND descripcion.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
        query.append("    AND descripcion.attr_num_atri = 1 ");
        query.append("    AND descripcion.idio_oid_idio =  " + dto.getOidIdioma());
        query.append("    AND cargodetalle.mvcc_oid_movi_cc = ctacorriente.oid_movi_cc(+) ");
        query.append("    AND ctacorriente.perd_oid_peri = periodocronograma.oid_peri(+) ");
        query.append("    AND periodocronograma.PERI_OID_PERI = periodocorporativo.oid_peri(+) ");
        query.append("    AND subproceso.ccpr_oid_proc = proceso.oid_proc ");
        query.append("    AND cargodetalle.mvcc_oid_movi_cc = movctacte.oid_movi_cc "); 

        if (dto.getOidNumeroCargo() != null) {
           query.append(" and   and   movctacte.NUM_IDEN_CUOT = " + dto.getOidNumeroCargo());
        }
       
//Modificado por incidencia BELC300022970 
//        query.append("    ORDER BY cargocabecera.num_cabe ");
        query.append("    ORDER BY cargocabecera.fec_docu ");
          
        try {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());            
            if (rs.esVacio()) {
               throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex) {
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCCC.obtenerDetalleConsultaCC(DTOFiltroCC dto): Salida ");
        return rs;
      }
      
     public String obtenerIndicadorConsulta(Long oidDetalle) throws MareException{
        
        UtilidadesLog.info("DAOCCC.obtenerIndicadorConsulta(Long oidDetalle): Entrada ");
        RecordSet rs;
        StringBuffer query = new StringBuffer();        
        query.append(" select subproceso.VAL_INDI_CONS ");
        query.append(" from ccc_subpr subproceso, ccc_detal_cargo_abono_direc cargodetalle,  ");
        query.append(" ccc_tipo_abono_subpr tipoabono ");
        query.append(" where cargodetalle.OID_DETA_CARG_ABON_DIRE = " + oidDetalle);
        query.append(" and cargodetalle.tasp_oid_tipo_abon_subp = tipoabono.oid_tipo_abon_subp ");
        query.append(" AND tipoabono.subp_oid_subp = subproceso.oid_subp ");
        
        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex) {
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
                
        if (rs.esVacio()) {
            UtilidadesLog.info("DAOCCC.obtenerIndicadorConsulta(Long oidDetalle):  Salida  1");
            return null;
        } else {
            UtilidadesLog.info("DAOCCC.obtenerIndicadorConsulta(Long oidDetalle): Salida  2");
            return new String(rs.getValueAt(0, 0).toString());
        }            
      }
      
      public RecordSet obtenerSaldoCampana(DTOSaldoCampana dto) throws MareException{
        
        UtilidadesLog.info("DAOCCC.obtenerSaldoCampana(DTOSaldoCampana dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT movctacte.CLIE_OID_CLIE as OID ,periodocorporativo.cod_peri AS periodo, tipodocumento.val_i18n as tpdoc, ");
        query.append(" movctacte.val_docu_nume AS numerodocumento, TO_CHAR(movctacte.fec_valo, 'dd/MM/yyyy') AS fechavalor,  ");
        query.append(" movctacte.imp_movi AS importe, movctacte.imp_pend AS saldo  ");
        query.append(" FROM ccc_marca_tipo_abono marcatipoabono, ccc_tipo_abono_subpr tipoabonosubp,  ");
        query.append(" ccc_subpr subp, ccc_proce proce,  ccc_marca_situa marcasitua,  ");
        query.append(" ccc_movim_cuent_corri movctacte,  cra_perio periodocronograma,  ");
        query.append(" seg_perio_corpo periodocorporativo, ccc_tipo_cargo_abono cargoabono,  ");
        query.append(" gen_i18n_sicc_pais tipodocumento ");
        query.append(" WHERE marcatipoabono.masi_oid_marc_sali = marcasitua.oid_marc_situ  ");
        query.append(" AND marcatipoabono.tasp_oid_tipo_abon_subp =  tipoabonosubp.oid_tipo_abon_subp  ");
        query.append(" AND marcasitua.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND tipoabonosubp.subp_oid_subp = subp.oid_subp  ");
        query.append(" AND subp.ccpr_oid_proc = proce.oid_proc  ");
        query.append(" AND proce.cod_proc = 'CCC001'  ");
        query.append(" AND subp.cod_subp = '1'  ");
        query.append(" AND marcatipoabono.ind_entr_sali = 'S'  ");
        query.append(" AND movctacte.masi_oid_marc_situ = marcasitua.oid_marc_situ  ");
        query.append(" AND movctacte.subp_oid_subp_crea = subp.oid_subp  ");
        query.append(" AND tipoabonosubp.tcab_oid_tcab = cargoabono.oid_tipo_carg_abon  ");
        query.append(" AND cargoabono.oid_tipo_carg_abon = tipodocumento.val_oid  ");
        query.append(" AND tipodocumento.attr_enti = 'CCC_TIPO_CARGO_ABONO'  ");
        query.append(" AND tipodocumento.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" AND movctacte.perd_oid_peri = periodocronograma.OID_PERI ");
        query.append(" and periodocronograma.OID_PERI = " + dto.getOidPeriodo());
        query.append(" and periodocronograma.PERI_OID_PERI = periodocorporativo.oid_peri ");
        query.append(" AND periodocronograma.pais_oid_pais = "+ dto.getOidPais());
        query.append(" AND movctacte.imp_pend <> 0  ");
        query.append(" and movctacte.CLIE_OID_CLIE =  " + dto.getOidCliente());
        query.append(" order by periodocorporativo.cod_peri desc, movctacte.fec_valo desc ");
        
        try  {

            rs =  getBelcorpService().dbService.executeStaticQuery(query.toString());
            
            if (rs.esVacio()) {
               throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex) {
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtenerSaldoCampana(DTOSaldoCampana dto): Salida ");
        return rs;
      }
      
      
      public RecordSet obtenerParametrosCargoDetalle(DTOOID dto) throws MareException{
        
        UtilidadesLog.info("DAOCCC.obtenerParametrosCargoDetalle(DTOOID dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT cabeceracargoabono.pais_oid_pais,  canal.oid_cana AS canal, ");
        query.append(" subacceso.acce_oid_acce AS acceso, ");
        query.append(" movctacte.sbac_oid_sbac AS subacceso, ");
	    query.append(" TO_NUMBER(movctacte.VAL_EJER_CUOT||''||LPAD(movctacte.NUM_IDEN_CUOT, 8, '0')) NUM_CONSOLIDADO ");
        query.append(" FROM ccc_detal_cargo_abono_direc detallecargoabono, ");
        query.append(" ccc_cabec_carga_abono_direc cabeceracargoabono, ");
        query.append(" seg_subac subacceso, ");
        query.append(" seg_acces acceso, ");
        query.append(" seg_canal canal, ");
        query.append(" ccc_movim_cuent_corri movctacte ");
        query.append(" WHERE detallecargoabono.oid_deta_carg_abon_dire = " + dto.getOid());
        query.append(" AND detallecargoabono.ccad_oid_cabe_carg = cabeceracargoabono.oid_cabe_carg ");
        query.append(" AND movctacte.sbac_oid_sbac = subacceso.oid_sbac ");
        query.append(" AND subacceso.acce_oid_acce = acceso.oid_acce ");
        query.append(" AND acceso.cana_oid_cana = canal.oid_cana ");
        query.append(" AND detallecargoabono.mvcc_oid_movi_cc = movctacte.oid_movi_cc ");

        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            
            if (rs.esVacio()) {
               throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtenerParametrosCargoDetalle(DTOOID dto): Salida ");        
        return rs;
      }
      
      public RecordSet obtenerDetalleCargos(Long pais, Long canal,Long acceso, Long subacceso, Long numConsolidado) throws MareException{
        
        UtilidadesLog.info("DAOCCC.obtenerDetalleCargos(Long pais, Long canal,Long acceso, Long subacceso, Long numConsolidado): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT   consolidado.val_nume_soli,ofertadetalle.val_codi_vent, p.num_unid_aten, ");
        query.append(" produ.cod_sap || ' ' || produ.des_cort AS producto, ");
        query.append(" p.val_prec_cata_tota_loca, p.val_prec_cata_tota_loca_unid, ");
        query.append(" origen.val_tota_paga_loca ");
        query.append(" FROM ped_solic_posic p, ");
        query.append(" ped_solic_cabec origen, ");
        query.append(" ped_solic_cabec consolidado, ");
        query.append(" mae_produ produ, ");
        query.append(" pre_ofert_detal ofertadetalle, ");
        query.append(" seg_subac subacceso, ");
        query.append(" seg_acces acceso "); 
        query.append(" WHERE p.soca_oid_soli_cabe = origen.oid_soli_cabe ");
        query.append(" AND origen.soca_oid_soli_cabe = consolidado.oid_soli_cabe ");
        query.append(" AND consolidado.val_nume_soli = " + numConsolidado);
        query.append(" AND consolidado.pais_oid_pais = " + pais);
        query.append(" AND consolidado.sbac_oid_sbac = " + subacceso);
        query.append(" AND subacceso.oid_sbac = " + subacceso);
        query.append(" AND subacceso.acce_oid_acce = " + acceso);
        query.append(" AND subacceso.acce_oid_acce = acceso.oid_acce ");
        query.append(" AND acceso.cana_oid_cana = " + canal);
        query.append(" AND p.ofde_oid_deta_ofer = ofertadetalle.oid_deta_ofer ");
        query.append(" AND p.prod_oid_prod = produ.oid_prod ");
        query.append(" ORDER BY ofertadetalle.val_codi_vent, p.num_unid_aten ");

        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());            
            if (rs.esVacio()) {
               throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            
        } catch (MareException me) {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtenerDetalleCargos(Long pais, Long canal,Long acceso, Long subacceso, Long numConsolidado): Salida ");        
        return rs;
      }
      
      /**
     * 
     * @date 16/08/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @author pperanzola
     */
       public RecordSet obtenerDetalleCargos2(DTOOID dto, Long oidSolicitud) throws MareException{
         /*
          * Modificado por Rafael Romero - SiCC 20070254 - 10/05/2007
          */
         UtilidadesLog.info("DAOCCC.obtenerDetalleCargos2(DTOOID dto) : Entrada ");
         StringBuffer query1 = new StringBuffer();
         RecordSet rs1;
         query1.append("SELECT distinct rec_linea_opera_recla.timo_oid_tipo_movi, origen.modu_oid_modu, ");
         query1.append(" origen.oid_soli_cabe ");
         query1.append(" FROM ped_solic_cabec origen, ");
         query1.append("      rec_linea_opera_recla, ");
         query1.append("      rec_opera_recla, ");
         query1.append("      ped_solic_cabec consolidado ");
         query1.append("  WHERE rec_linea_opera_recla.opre_oid_oper_recl =  ");
         query1.append("        rec_opera_recla.oid_oper_recl ");
         query1.append("        AND rec_opera_recla.soca_oid_soli_cabe = consolidado.oid_soli_cabe ");
         query1.append("        AND rec_linea_opera_recla.timo_oid_tipo_movi = 2 ");
         query1.append("        AND origen.soca_oid_soli_cabe = consolidado.oid_soli_cabe ");
         query1.append("        AND origen.modu_oid_modu = 1 ");
         query1.append("        AND origen.soca_oid_soli_cabe = " + oidSolicitud );
         
         try{
              rs1 = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query1.toString());   
         }catch (MareException me) {
              throw me;
         } catch (Exception ex){
             throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }     
         
         
         StringBuffer query = new StringBuffer();
         RecordSet rs;
         
         query.append(" SELECT  1, consolidado.val_nume_soli ");
         query.append(" ,ofertadetalle.val_codi_vent ");
         query.append(" ,p.num_unid_aten ");
         //hhernandez - 20070508
         query.append(" ,produ.cod_sap || ' ' ||  Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+ dto.getOidIdioma() +", produ.oid_prod, 'MAE_PRODU') AS producto");
         //query.append(" ,produ.cod_sap || ' ' || produ.des_cort AS producto ");
         /*query.append(" ,p.val_prec_cata_tota_loca ");*/
         query.append(" , p.VAL_PREC_CATA_UNIT_LOCA"); 
         query.append(" , p.VAL_PREC_FACT_UNIT_LOCA");
         //query.append(" , p.val_prec_cata_tota_loca "); // comentado Rafael Romero - SiCC 20070254 - 10/05/2007
         query.append(" , DECODE(p.val_prec_cata_unit_loca,0,0,p.val_prec_tota_tota_loca) importe ");   // insertado Rafael Romero - SiCC 20070254 - 22/05/2007
         query.append(" ,consolidado.val_tota_paga_loca ");
         //CCC_004 
         query.append(" ,(p.num_unid_por_aten - p.num_unid_aten) UNID_FALT ");
         query.append(" ,nvl(p.VAL_PORC_DESC, 0) PORC_DESC ");
         query.append(" ,0 UNID_DEVU ");
         query.append("  ,case when p.ofde_oid_deta_ofer is not null then ( ");
         query.append("     '' || (SELECT ((p.num_unid_por_aten) * p.val_prec_cata_unit_loca / NVL(pip.VAL_FACT_CONV, 1))  ");
         query.append("                      from pre_tipo_ofert tof, SEG_PARAM_INTER_PAIS pip ");
         query.append("                      where ofertadetalle.TOFE_OID_TIPO_OFER = tof.OID_TIPO_OFER and tof.IND_PUNT = 1 ");
         //CCC-05 jrivas 7/10/2008
         query.append("                                          AND ORIGEN.IND_OC = 1 ");
         query.append("                                          AND ORIGEN.MODU_OID_MODU <> 15 ");
         //FIN CCC-05
         query.append("                      and pip.PAIS_OID_PAIS =" + dto.getOidPais() + ") ");
         query.append("    ) else '' ");
         query.append("    end PUNTOS, ");
         query.append(" P.VAL_CODI_VENT || '-' || P.VAL_CODI_VENT_FICT CODVENTA, ");
         query.append(" P.NUM_UNID_POR_ATEN, P.OFDE_OID_DETA_OFER, ");
         query.append(" CASE ");
         query.append("     WHEN P.OFDE_OID_DETA_OFER IS NOT NULL ");
         query.append("        THEN (SELECT NVL (PIP.VAL_FACT_CONV, 1) ");
         query.append("                 FROM PRE_TIPO_OFERT TOF, SEG_PARAM_INTER_PAIS PIP ");
         query.append("                WHERE OFERTADETALLE.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER ");
         query.append("                    AND TOF.IND_PUNT = 1 ");
         //CCC-05 jrivas 7/10/2008
         query.append("                                    AND ORIGEN.IND_OC = 1 ");
         query.append("                                    AND ORIGEN.MODU_OID_MODU <> 15 ");
         //FIN CCC-05
         query.append("                    AND PIP.PAIS_OID_PAIS = " + dto.getOidPais() + ") ");
         query.append("     ELSE 0 ");  
         query.append("  END FACTORCONVER ");
         //FIN CCC-04
         query.append(" FROM PED_SOLIC_POSIC p, ");
         query.append(" PED_SOLIC_CABEC origen, ");
         query.append(" PED_SOLIC_CABEC consolidado, ");
         query.append(" MAE_PRODU produ, ");
         query.append(" PRE_OFERT_DETAL ofertadetalle ");
         query.append(" ,CCC_DETAL_CARGO_ABONO_DIREC detallecargoabono ");
         query.append(" ,seg_subac subacceso ");
         query.append(" ,seg_acces acceso, ");
         query.append(" CCC_MOVIM_CUENT_CORRI movctacte ");
         query.append(" WHERE p.soca_oid_soli_cabe = origen.oid_soli_cabe ");
         
         query.append(" AND origen.soca_oid_soli_cabe = consolidado.oid_soli_cabe ");
         if(!rs1.esVacio()){
            Long oidSolicitud2 = rs1.getValueAt(0,"OID_SOLI_CABE") != null?new Long(((BigDecimal)rs1.getValueAt(0,"OID_SOLI_CABE")).longValue()):null;        
            query.append(" AND origen.oid_soli_cabe = " + oidSolicitud2 );
         }
         query.append(" AND consolidado.val_nume_soli =  TO_NUMBER (   movctacte.val_ejer_cuot  || ''  || LPAD (movctacte.num_iden_cuot, 8, '0') ) ");
         query.append(" AND consolidado.pais_oid_pais = " + dto.getOidPais());
         query.append(" AND consolidado.sbac_oid_sbac = movctacte.sbac_oid_sbac ");
         query.append(" AND p.ofde_oid_deta_ofer = ofertadetalle.oid_deta_ofer(+) "); //modificado por incidencia SiCC-20070248 (Sapaza)
         query.append(" AND p.prod_oid_prod = produ.oid_prod ");
         query.append(" AND detallecargoabono.oid_deta_carg_abon_dire = " + dto.getOid());
         query.append(" AND movctacte.sbac_oid_sbac = subacceso.oid_sbac ");
         query.append(" AND subacceso.acce_oid_acce = acceso.oid_acce ");
         query.append(" AND detallecargoabono.mvcc_oid_movi_cc = movctacte.oid_movi_cc ");
         query.append(" ORDER BY ofertadetalle.val_codi_vent, p.num_unid_aten ");
       
         try  {
             rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());            
             if (rs.esVacio()) {
                throw new MareException(new Exception(),
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
             }
         } catch (MareException me) {
             throw me;
         } catch (Exception ex){
             throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
         
         //CCC-04 jrivas 29/7/2008
         //obtengo unidades devueltas
         StringBuffer query2 = new StringBuffer();
         RecordSet rs2;
         
         query2.append(" SELECT SUM(ABS(PSP.NUM_UNID_DEMA)) TOTAL_UNIDADES_DEMANDADAS,  ");
         query2.append("        PSP.VAL_CODI_VENT || '-' || PSP.VAL_CODI_VENT_FICT CODVENTA ");
         query2.append("   FROM PED_SOLIC_CABEC PSC, ");
         query2.append("        PED_TIPO_SOLIC_PAIS PTSP, ");
         query2.append("        PED_TIPO_SOLIC PTS, ");
         query2.append("        PED_SOLIC_POSIC PSP, ");
         query2.append("        PED_CLASE_SOLIC PCS ");
         query2.append("  WHERE PSC.OID_SOLI_CABE IN ( ");
         query2.append("           SELECT RSO.SOCA_OID_SOLI_CABE ");
         query2.append("             FROM REC_SOLIC_OPERA RSO, ");
         query2.append("                  PED_SOLIC_CABEC PSC, ");
         query2.append("                  REC_OPERA_RECLA ROR, ");
         query2.append("                  REC_CABEC_RECLA RCR, ");
         query2.append("                  CCC_DETAL_CARGO_ABONO_DIREC DCAD, ");
         query2.append("                  CCC_MOVIM_CUENT_CORRI MCC     ");             
         query2.append("            WHERE PSC.VAL_NUME_SOLI = ");
         query2.append("                                 TO_NUMBER (   MCC.VAL_EJER_CUOT ");
         query2.append("                                            || '' ");
         query2.append("                                            || LPAD (MCC.NUM_IDEN_CUOT, 8, '0') ");
         query2.append("                                           ) ");
         query2.append("              AND PSC.SBAC_OID_SBAC = MCC.SBAC_OID_SBAC ");
         query2.append("              AND DCAD.MVCC_OID_MOVI_CC = MCC.OID_MOVI_CC ");
         query2.append("              AND DCAD.OID_DETA_CARG_ABON_DIRE = " + dto.getOid());
         query2.append("              AND RCR.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
         query2.append("              AND RCR.PAIS_OID_PAIS = " + dto.getOidPais());
         query2.append("              AND RCR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL  ");
         query2.append("              AND ROR.OID_OPER_RECL = RSO.OPRE_OID_OPER_RECL) ");
         query2.append("     AND PSC.FEC_FACT IS NOT NULL       ");   
         query2.append("     AND PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS ");
         query2.append("     AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
         query2.append("     AND (PTS.IND_DEVO = 1 OR PTS.IND_ANUL = 1) ");
         query2.append("     AND PTS.CLSO_OID_CLAS_SOLI = PCS.OID_CLAS_SOLI ");
         query2.append("     AND PCS.IND_ORDE_COMP = 1 ");
         query2.append("     AND PSP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
         query2.append("     GROUP BY PSP.VAL_CODI_VENT, PSP.VAL_CODI_VENT_FICT    ");     
         
         try  {
             rs2 = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query2.toString());            
         } catch (MareException me) {
             throw me;
         } catch (Exception ex){
             throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }     
         
         //ubicamos las unidades devueltas en la salida.
         String cod_vent = "";
         BigDecimal unidades = null;
         BigDecimal precioCatalogo = null;
         BigDecimal unidadesPorAtend = null;
         BigDecimal detalleOferta = null;
         BigDecimal factor = null;
         
         int numDeci = this.obtenerNumDeci(dto.getOidPais()).intValue();
         
         if (rs2 != null && !rs2.esVacio()){
              for (int i = 0; i < rs2.getRowCount(); i++)  {
                 cod_vent = rs2.getValueAt(i, "CODVENTA").toString();
                 unidades = (BigDecimal)rs2.getValueAt(i, "TOTAL_UNIDADES_DEMANDADAS");
                 for (int j = 0; j < rs.getRowCount(); j++)  {
                     if (cod_vent.equals(rs.getValueAt(j, "CODVENTA").toString())) {
                         //encontre codVent, reemplazo unid_devu
                         rs.setValueAt(unidades, j, 11); //UNID_DEVU

                         precioCatalogo = (BigDecimal)rs.getValueAt(j, "VAL_PREC_CATA_UNIT_LOCA");
                         unidadesPorAtend = (BigDecimal)rs.getValueAt(j, "NUM_UNID_POR_ATEN");
                         detalleOferta = (BigDecimal)rs.getValueAt(j, "OFDE_OID_DETA_OFER");
                         factor = (BigDecimal)rs.getValueAt(j, "FACTORCONVER");
                         //miro si tiene detalleOferta, si lo tiene calculo puntos
                         if (detalleOferta != null && factor != null &&!factor.equals(new BigDecimal(0))) {
                             String puntos = ((((unidadesPorAtend.subtract(unidades)).multiply(precioCatalogo)).divide(factor, BigDecimal.ROUND_HALF_EVEN)).setScale(numDeci, BigDecimal.ROUND_HALF_UP)).toString();
                             rs.setValueAt(puntos, j, 12); //PUNTOS 
                         }
                     }
                 }
              }
          }        
         
         long totalFaltantes = 0;
         long totalDevueltas = 0;
         long totalAtendidas = 0;
         double total = 0;
         double totalPrecioCatalogo = 0;
         double totalPorcentajeDesc = 0;
         
         double precCatalAux = 0;
         double unidAtenAux = 0;
         double porceDescAux = 0;
         double descAux = 0;
          
         if (rs != null && !rs.esVacio()){
              for (int i = 0; i < rs.getRowCount(); i++)  {
                 if (rs.getValueAt(i, "UNID_FALT") != null) {
                     totalFaltantes = totalFaltantes + ((BigDecimal)rs.getValueAt(i, "UNID_FALT")).longValue();
                 }
                 if (rs.getValueAt(i, "UNID_DEVU") != null) {
                     totalDevueltas = totalDevueltas + ((BigDecimal)rs.getValueAt(i, "UNID_DEVU")).longValue();
                 }
                 if (rs.getValueAt(i, "NUM_UNID_ATEN") != null) {
                     totalAtendidas = totalAtendidas + ((BigDecimal)rs.getValueAt(i, "NUM_UNID_ATEN")).longValue();
                 }
                 if (rs.getValueAt(i, "VAL_PREC_FACT_UNIT_LOCA") != null) {
                     total = total + ((BigDecimal)rs.getValueAt(i, "VAL_PREC_FACT_UNIT_LOCA")).doubleValue();
                 }
                 if (rs.getValueAt(i, "VAL_PREC_CATA_UNIT_LOCA") != null) {
                     totalPrecioCatalogo = totalPrecioCatalogo + ((BigDecimal)rs.getValueAt(i, "VAL_PREC_CATA_UNIT_LOCA")).doubleValue();
                 }
                 if (rs.getValueAt(i, "PORC_DESC") != null && ((BigDecimal)rs.getValueAt(i, "PORC_DESC")).intValue() != 0 
                         && rs.getValueAt(i, "NUM_UNID_ATEN") != null && rs.getValueAt(i, "VAL_PREC_CATA_UNIT_LOCA") != null){
                     precCatalAux = ((BigDecimal)rs.getValueAt(i, "VAL_PREC_CATA_UNIT_LOCA")).doubleValue();
                     unidAtenAux =  ((BigDecimal)rs.getValueAt(i, "NUM_UNID_ATEN")).doubleValue();
                     porceDescAux =((BigDecimal)rs.getValueAt(i, "PORC_DESC")).doubleValue();
                     descAux = precCatalAux * unidAtenAux * ( 1 - ( porceDescAux / 100 ) );   
                     totalPorcentajeDesc = totalPorcentajeDesc + descAux;
                 }                
              }
          }
          
          //CCC-05 jrivas 7/10/2008
          Vector nuevoRegistro = new Vector();
          nuevoRegistro.add(null); //1
          nuevoRegistro.add("Totales"); //val_nume_soli
          nuevoRegistro.add(null); //val_codi_vent
          nuevoRegistro.add(new Long(totalAtendidas)); //num_unid_aten
          nuevoRegistro.add(null); //producto
          nuevoRegistro.add(new BigDecimal(totalPrecioCatalogo).setScale(numDeci, BigDecimal.ROUND_HALF_UP).toString()); //VAL_PREC_CATA_UNIT_LOCA
          nuevoRegistro.add(new BigDecimal(total).setScale(numDeci, BigDecimal.ROUND_HALF_UP).toString()); //VAL_PREC_FACT_UNIT_LOCA
          nuevoRegistro.add(null); //importe
          nuevoRegistro.add(null); //val_tota_paga_loca
          nuevoRegistro.add(new Long(totalFaltantes)); //UNID_FALT
          nuevoRegistro.add(new BigDecimal(totalPorcentajeDesc).setScale(numDeci, BigDecimal.ROUND_HALF_UP).toString()); //PORC_DESC
          nuevoRegistro.add(new Long(totalDevueltas)); //UNID_DEVU
          nuevoRegistro.add(null); //PUNTOS
          rs.addRow(nuevoRegistro);  
          
         UtilidadesLog.info("DAOCCC.obtenerDetalleCargos2(DTOOID dto) : Salida " + rs);
         return rs;
       }
      
     /**
      * Autor: Emilio Iraola
      * Fecha: 15/12/2005
      * Descripción: Metodo que obtiene y devuelve el ultimo numero secuencial
      *              de los Detalles que pertenecen a una Cabecera cuyo oid se
      *              pasa por parametro.
      * @throws MareException
      * Notas:
      *       @eiraola 15/12/2005, este método se agrega a la Clase segun
      *       modelo: GCC-CCC-001_2005.11.09 GMIOTTI DT 
      */
      public Long obtenerUltimoDetalleCargosAbonos(Long oidCabe) throws MareException {
          UtilidadesLog.info("DAOCCC.obtenerUltimoDetalleCargosAbonos(Long oid): Entrada ");
          Long ultimoNumeroLinea = null;
          StringBuffer query = new StringBuffer();
          RecordSet rs = null;
          
          query.append(" SELECT MAX( d.num_line ) ");
          query.append(" FROM ccc_detal_cargo_abono_direc d ");
          query.append(" WHERE d.ccad_oid_cabe_carg = " + oidCabe + " ");
          
          try  {
            rs = getBelcorpService().dbService.executeStaticQuery(
                    query.toString());            
            if (rs.esVacio()) {
               throw new MareException(new Exception(),
                   UtilidadesError.armarCodigoError(
                       CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
          } catch (MareException me) {
              throw me;
          } catch (Exception ex){
              throw new MareException(ex,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
          }
          if (rs.getValueAt(0, 0) == null ) {
              ultimoNumeroLinea = new Long(0);    //si no hay un maximo retorna 0
          } else {
              ultimoNumeroLinea = new Long(rs.getValueAt(0, 0).toString());
          }
          UtilidadesLog.info("DAOCCC.obtenerUltimoDetalleCargosAbonos(Long oid): Salida ");
          return ultimoNumeroLinea;
      }    
    
    
    /**
     * Descripción: Recupera los registros de la Entidad CuentasContable. 
     * @author Noziglia C.
     */
    public RecordSet obtenerCuentasContables(DTOBelcorp dto) throws MareException
    {
        UtilidadesLog.info("DAOCCC.obtenerCuentasContables(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT CCC.OID_CUEN_CONT,  ");
	    query.append("        (SELECT idio.val_i18n ");
	    query.append("          FROM v_gen_i18n_sicc idio ");
        query.append("         WHERE idio.attr_enti = 'CCC_CUENT_CONTA' ");
	    query.append("           AND idio.idio_oid_idio = "+ dto.getOidIdioma());
	    query.append("           AND idio.val_oid = CCC.OID_CUEN_CONT ) DESCRIPCION ");
	    query.append("          FROM CCC_CUENT_CONTA CCC ");
	    query.append("         WHERE CCC.PAIS_OID_PAIS = "+dto.getOidPais());


        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());            
            if (rs.esVacio()) {
               throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            
        } catch (MareException me) {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtenerCuentasContables(DTOBelcorp dto): Salida ");        
        return rs;
    }

    public DTOSalida buscarTiposAbonoSubproceso(DTOBuscarTiposAbonoSubproceso dto) throws MareException
    {
        UtilidadesLog.info("DAOCCC.buscarTiposAbonoSubproceso(DTOBuscarTiposAbonoSubproceso dto): Entrada ");
        DTOSalida dtoS = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT  * FROM ( ");
        
        query.append(" SELECT  tas.OID_TIPO_ABON_SUBP  OID,  ");
        query.append("       pro.DES_PROC ,   ");
        query.append("       sub.OID_SUBP, ");
        query.append("       sub.DES_SUBP, ");
        query.append(" 	    ta.OID_TIPO_CARG_ABON, ");
        query.append("	   (SELECT idio.val_i18n ");
        query.append("          FROM v_gen_i18n_sicc idio ");
        query.append("         WHERE idio.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
        query.append("           AND idio.idio_oid_idio = "+dto.getOidIdioma());
        query.append("           AND idio.val_oid = ta.OID_TIPO_CARG_ABON ) DESCTIPOABONO,    ");
        query.append("   	   cc.OID_CUEN_CONT,  ");
        query.append("	   (SELECT idio.val_i18n  ");
        query.append("          FROM v_gen_i18n_sicc idio  ");
        query.append("         WHERE idio.attr_enti = 'CCC_CUENT_CONTA'  ");
        query.append("           AND idio.idio_oid_idio = "+dto.getOidIdioma());
        query.append("           AND idio.val_oid = cc.OID_CUEN_CONT ) DESCCUENTACONTA  ,");
         query.append("       pro.OID_PROC ");
        query.append("   FROM CCC_TIPO_ABONO_SUBPR tas,   "); 
        query.append("	      CCC_CUENT_CONTA cc,    ");
        query.append("        CCC_PROCE pro,   ");
        query.append("        CCC_TIPO_CARGO_ABONO ta,  ");
        query.append("	      CCC_SUBPR sub   ");
        query.append("  WHERE tas.CUCO_OID_CUEN_CONT = cc.OID_CUEN_CONT  ");
        query.append("    AND tas.SUBP_OID_SUBP = sub.OID_SUBP  ");
        query.append("    AND tas.TCAB_OID_TCAB = ta.OID_TIPO_CARG_ABON   ");
        //agregado
        query.append("     AND (pro.oid_proc = sub.ccpr_oid_proc)   ");
        if(dto.getOidSubproceso()!=null){
            query.append("    AND tas.SUBP_OID_SUBP = "+dto.getOidSubproceso()); // en el caso que este valor sea distinto de null 
        }
        if(dto.getOidCuentaContable()!=null){
            query.append("    AND tas.CUCO_OID_CUEN_CONT = "+dto.getOidCuentaContable());// en el caso que este valor sea distinto de null 
        }
        if(dto.getOidTipoAbono()!=null){
            query.append("    AND tas.TCAB_OID_TCAB = "+dto.getOidTipoAbono());// en el caso que este valor sea distinto de null 
        }
        if(dto.getOidProceso()!=null){
            query.append("    AND pro.OID_PROC = "+dto.getOidProceso());// en el caso que este valor sea distinto de null 
            //query.append("    AND sub.CCPR_OID_PROC = pro.OID_PROC   "); // en el caso de que oidProceso sea distinto de null 
        }
  //puede no haberse definido ningun filtro y deben recuperarse todos los registros segun CCC:TiposAbonoSubproceso.
      query.append(" ORDER BY OID) ");
      query.append("  WHERE OID > " + dto.getIndicadorSituacion() );
      query.append("  AND ROWNUM <=   " +dto.getTamanioPagina());
   
      
        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());            
            if (rs.esVacio()) {
              UtilidadesLog.debug("El registro es vacio");
               throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            
        } catch (MareException me) {
            throw me;
        } catch (Exception ex){
           UtilidadesLog.debug("Llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOCCC.buscarTiposAbonoSubproceso(DTOBuscarTiposAbonoSubproceso dto): Salida ");        
        return dtoS;
    }
    
    public RecordSet ObtenerTipoAbonoSubprocesoRefereciados(Long oidTipoAbonoSub) throws MareException{
       
       UtilidadesLog.info("DAOCCC. ObtenerTipoAbonoSubprocesoRefereciados(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT ccc_cabec_carga_abono_direc.tasp_oid_tipo_abon_subp ");
        query.append("  FROM ccc_cabec_carga_abono_direc, ccc_tipo_abono_subpr ");
        query.append(" WHERE ccc_cabec_carga_abono_direc.tasp_oid_tipo_abon_subp =  " + oidTipoAbonoSub);
        query.append(" AND ccc_cabec_carga_abono_direc.tasp_oid_tipo_abon_subp = ");
        query.append("                                ccc_tipo_abono_subpr.oid_tipo_abon_subp  ");
        query.append(" UNION ");
        query.append(" SELECT ccc_detal_cargo_abono_direc.tasp_oid_tipo_abon_subp ");
        query.append(" FROM ccc_detal_cargo_abono_direc, ccc_tipo_abono_subpr ");
        query.append(" WHERE ccc_detal_cargo_abono_direc.tasp_oid_tipo_abon_subp =  " + oidTipoAbonoSub);
        query.append(" AND ccc_detal_cargo_abono_direc.tasp_oid_tipo_abon_subp = ");
        query.append("                                 ccc_tipo_abono_subpr.oid_tipo_abon_subp ");
        query.append(" UNION ");
        query.append(" SELECT ccc_marca_tipo_abono.tasp_oid_tipo_abon_subp ");
        query.append(" FROM ccc_marca_tipo_abono, ccc_tipo_abono_subpr ");
        query.append(" WHERE ccc_marca_tipo_abono.tasp_oid_tipo_abon_subp =  " + oidTipoAbonoSub);
        query.append(" AND ccc_marca_tipo_abono.tasp_oid_tipo_abon_subp = ");
        query.append("                                   ccc_tipo_abono_subpr.oid_tipo_abon_subp ");
        try  {
            rs =  getBelcorpService().dbService.executeStaticQuery(query.toString());            
            UtilidadesLog.debug(rs);
        } catch (MareException me) {
           UtilidadesLog.debug("ObtenerTipoAbonoSubprocesoRefereciados: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("ObtenerTipoAbonoSubprocesoRefereciados: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
      UtilidadesLog.info("DAOCCC.ObtenerTipoAbonoSubprocesoRefereciados(oidTipoAbonoSub): Salida ");        
      return rs;
    }
    
    public RecordSet obtenerTiposAbonoSubproceso(String codigoProceso, Integer codigoSubproceso, Long pais) throws MareException{
        StringBuffer query = new StringBuffer();
        RecordSet rs;
       
        //query.append(" SELECT  tipoAbonoSub.OID_TIPO_ABON_SUBP ");
        //@ssaavedr, se modifica por inc.: BELC300022992
        
        query.append(" SELECT  tipoAbonoSub.* ");
        query.append(" FROM  CCC_TIPO_ABONO_SUBPR tipoAbonoSub, ");
        query.append(" CCC_SUBPR sub, ");
        query.append(" CCC_PROCE proc ");
        query.append(" Where ");
        query.append(" sub.CCPR_OID_PROC = proc.OID_PROC ");
        query.append(" and tipoAbonoSub.SUBP_OID_SUBP = sub.OID_SUBP ");
        query.append(" and sub.COD_SUBP = " + codigoSubproceso.longValue());
        query.append(" and proc.COD_PROC = '" + codigoProceso + "'");
        query.append(" and proc.PAIS_OID_PAIS = " + pais.longValue());

        try  {
            rs =  getBelcorpService().dbService.executeStaticQuery(query.toString());            
            UtilidadesLog.debug(rs);
        } catch (MareException me) {
           UtilidadesLog.debug("obtenerTiposAbonoSubproceso: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("obtenerTiposAbonoSubproceso: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtenerTiposAbonoSubproceso(String codigoSubproceso, Integer codigoSubproceso, Long pais): Salida ");        
        
      return rs;
    }
    
    public DTOAbonoSubprocesoMarcaSituacion obtenerAsignacionSubprocesosTiposSolicitudCreacion(Long oidPais, Long oidTipoSolicitud) throws MareException{
        UtilidadesLog.info("DAOCCC.obtenerAsignacionSubprocesosTiposSolicitudCreacion(Long oidPais, DTOMovimientoCuentaCompleto dto): Entrada ");        
        ProcesoFacturacionHelper helper = ProcesoFacturacionHelper.getInstance(oidPais);
        RecordSet rs = null;
        /*query.append(" SELECT  ASTS.OID_ASIG_SUBP_POR_TIPO_SOLI");
        query.append(" ,ASTS.TSPA_OID_TIPO_SOLI_PAIS");
        query.append(" ,P.OID_PROC");
        query.append(" ,ASTS.SUBP_OID_SUBP_CREA_CUOT");
        query.append(" ,ASTS.CCBA_OID_CUEN_CORR_BANC");
        //query.append(" ,P.COD_PROC codProceso");
        //query.append(" ,S.COD_SUBP codSubproceso");
        
        query.append(" from CCC_ASIGN_SUBPR_TIPO_SOLIC ASTS, PED_TIPO_SOLIC_PAIS  TSP, CCC_PROCE P, CCC_SUBPR S");
        
        query.append(" where ASTS.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS");
        query.append(" and ASTS.SUBP_OID_SUBP_CREA_CUOT = S.OID_SUBP");
        query.append(" and S.CCPR_OID_PROC = P.OID_PROC"); 
        query.append(" and TSP.PAIS_OID_PAIS = " + oidPais.longValue());
        query.append(" and TSP.oid_tipo_soli_pais = " + oidTipoSolicitud.longValue());*/
        
        DTOAbonoSubprocesoMarcaSituacion  dtoAbonSubMarSitu = new DTOAbonoSubprocesoMarcaSituacion();

        try  {
            //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011 
            rs =  helper.getAsigSubProcTipoSolicCreac(oidTipoSolicitud);           
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("obtengo...: " + rs);
              
            if (rs != null && rs.getRowCount()>0){
                dtoAbonSubMarSitu.setOid(this.bigDecimalToLong(rs.getValueAt(0,"OID_ASIG_SUBP_POR_TIPO_SOLI")));
                dtoAbonSubMarSitu.setOidTipoSolicitud(this.bigDecimalToLong(rs.getValueAt(0,"TSPA_OID_TIPO_SOLI_PAIS")));
                
                dtoAbonSubMarSitu.setOidProcesoCreacionCtas(this.bigDecimalToLong(rs.getValueAt(0,"OID_PROC")));
                dtoAbonSubMarSitu.setOidSubprocesoCreacionCtas(this.bigDecimalToLong(rs.getValueAt(0,"SUBP_OID_SUBP_CREA_CUOT")));

                //dtoAbonSubMarSitu.setOidProcesoAplicacionCtas(this.bigDecimalToLong(rs.getValueAt(0,"CCPR_OID_PROC_APLI_CUOT")));
                //dtoAbonSubMarSitu.setOidSubprocesoAplicacionCtas(this.bigDecimalToLong(rs.getValueAt(0,"SUBP_OID_SUBP_APLI_CUOT")));
                
                dtoAbonSubMarSitu.setOidCtaCteBancaria(this.bigDecimalToLong(rs.getValueAt(0,"CCBA_OID_CUEN_CORR_BANC")));            
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug("dtoAbonSubMarSitu...: " + dtoAbonSubMarSitu);
            }            
        } catch (MareException me) {
           UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudCreacion: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudCreacion: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }    
        UtilidadesLog.info("DAOCCC.obtenerAsignacionSubprocesosTiposSolicitudCreacion(Long oidPais, DTOMovimientoCuentaCompleto dto): Salida ");        
        
        return dtoAbonSubMarSitu;
    }
    
    public DTOAbonoSubprocesoMarcaSituacion obtenerAsignacionSubprocesosTiposSolicitudAplicacion(Long oidPais, Long oidTipoSolicitud) throws MareException{
        UtilidadesLog.info("DAOCCC.obtenerAsignacionSubprocesosTiposSolicitudAplicacion(Long oidPais, DTOMovimientoCuentaCompleto dto): Entrada ");        
                
        DTOAbonoSubprocesoMarcaSituacion  dtoAbonSubMarSitu = new DTOAbonoSubprocesoMarcaSituacion();
        ProcesoFacturacionHelper helper = ProcesoFacturacionHelper.getInstance(oidPais);
        RecordSet rs = null;
        
        try  {
            //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011 
            rs =  helper.getAsigSubProcTipoSolicAplic(oidTipoSolicitud);      
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("obtengo...: " + rs);
            
            if (rs != null && rs.getRowCount()>0){
                dtoAbonSubMarSitu.setOid(this.bigDecimalToLong(rs.getValueAt(0,"OID_ASIG_SUBP_POR_TIPO_SOLI")));
                dtoAbonSubMarSitu.setOidTipoSolicitud(this.bigDecimalToLong(rs.getValueAt(0,"TSPA_OID_TIPO_SOLI_PAIS")));
                
                dtoAbonSubMarSitu.setOidProcesoAplicacionCtas(this.bigDecimalToLong(rs.getValueAt(0,"OID_PROC")));
                dtoAbonSubMarSitu.setOidSubprocesoAplicacionCtas(this.bigDecimalToLong(rs.getValueAt(0,"SUBP_OID_SUBP_APLI_CUOT")));
                
                dtoAbonSubMarSitu.setOidCtaCteBancaria(this.bigDecimalToLong(rs.getValueAt(0,"CCBA_OID_CUEN_CORR_BANC")));            
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug("dtoAbonSubMarSitu...: " + dtoAbonSubMarSitu);
            }            
        } catch (MareException me) {
           UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudAplicacion: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("obtenerAsignacionSubprocesosTiposSolicitudAplicacion: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }    
        UtilidadesLog.info("DAOCCC.obtenerAsignacionSubprocesosTiposSolicitudAplicacion(Long oidPais, DTOMovimientoCuentaCompleto dto): Salida ");        
        
        return dtoAbonSubMarSitu;
    }

    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
	public String obtieneCodProcMarcasUlti(Long SubprocesoDeCreacion, Long oidPais) 
		throws MareException {
		
        UtilidadesLog.info("DAOCCC.obtieneCodProcMarcasUlti(Long SubprocesoDeCreacion): Entrada");
        StringBuffer query = new StringBuffer();

        // para corregir incidencia 3280
        query.append("select proce.cod_proc ");
        query.append("from ccc_proce proce, ccc_subpr subproce ");
        query.append("where subproce.oid_subp = " + SubprocesoDeCreacion.longValue());
        query.append(" and subproce.ccpr_oid_proc = proce.oid_proc");
        query.append(" and proce.pais_oid_pais = " + oidPais.longValue());
        RecordSet rs;

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOCCC.obtieneCodProcMarcasUlti(Long SubprocesoDeCreacion): Entrada: Salida  1");
            return null;
        } else {
            UtilidadesLog.info("DAOCCC.obtieneCodProcMarcasUlti(Long SubprocesoDeCreacion): Entrada: Salida  2 ");
            return new String(rs.getValueAt(0, 0).toString());
        }
	}    
  
    public RecordSet obtenerTiposAbonoSubprocesoAndCtaContable(String codProcMarcasUlti, Integer codigoSubproceso, Long oidPais) throws MareException{
        UtilidadesLog.info("DAOCCC.obtenerTiposAbonoSubprocesoAndCtaContable(Long oidProcMarcasUlti, Integer codigoSubproceso, Long oidPais): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
       
        query.append(" SELECT  tipoAbonoSub.* ");
        query.append(" FROM  CCC_TIPO_ABONO_SUBPR tipoAbonoSub, ");
        query.append(" CCC_SUBPR sub, ");
        query.append(" CCC_PROCE proc ");
        query.append(" Where ");
        query.append(" tipoAbonoSub.SUBP_OID_SUBP = sub.OID_SUBP ");
        query.append(" and proc.COD_PROC = '" + codProcMarcasUlti + "'");
        query.append(" and proc.PAIS_OID_PAIS = " + oidPais.longValue());
        query.append(" and sub.CCPR_OID_PROC = proc.OID_PROC ");
        query.append(" and sub.COD_SUBP = " + codigoSubproceso.longValue());

        try  {
            rs =  getBelcorpService().dbService.executeStaticQuery(query.toString());            
            UtilidadesLog.debug("obtenerTiposAbonoSubprocesoAndCtaContable trae: " + rs);
            
            UtilidadesLog.info("DAOCCC.obtenerTiposAbonoSubprocesoAndCtaContable(Long oidProcMarcasUlti, Integer codigoSubproceso, Long oidPais): Salida ");        

            if ((rs==null) || (rs.getRowCount()==0))
                return null;
            else
                return rs;
        } catch (MareException me) {
           UtilidadesLog.debug("obtenerTiposAbonoSubprocesoAndCtaContable: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("obtenerTiposAbonoSubprocesoAndCtaContable: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }  
    
    //Agregado por cvalenzu - V-CCC-033 - 20/12/2006
    //Metodo invocado desde el MONProvisionesDepuraciones
    //Esta consulta es similiar a la del metodo DAOCCC.obtenerTiposAbonoSubprocesoAndCtaContable
    //pero para el caso en que el proceso sea CCC006 habia que filtrar por tipo
    //cargo abono, se obtiene el oid de tipo abono subproceso que luego se insertara
    //en el campo TASP_OID_TIPO_ABON_SUBP de la tabla CCC_DETAL_CARGO_ABONO_DIREC    
    
    public RecordSet obtenerOidTiposAbonoSubproceso(String codProcMarcasUlti, 
        Integer codigoSubproceso, Long oidPais, Long oidTipoCargoAbono) throws MareException{
        UtilidadesLog.info("DAOCCC.obtenerOidTiposAbonoSubproceso(String codProcMarcasUlti,"+        
        "Integer codigoSubproceso, Long oidPais, Long oidTipoCargoAbono): Entrada ");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs;
       
        query.append(" SELECT  tipoAbonoSub.* ");
        query.append(" FROM  CCC_TIPO_ABONO_SUBPR tipoAbonoSub, ");
        query.append(" CCC_SUBPR sub, ");
        query.append(" CCC_PROCE proc ");
        query.append(" Where ");
        query.append(" tipoAbonoSub.SUBP_OID_SUBP = sub.OID_SUBP ");
        query.append(" and proc.COD_PROC = '" + codProcMarcasUlti + "'");
        query.append(" and proc.PAIS_OID_PAIS = " + oidPais.longValue());
        query.append(" and sub.CCPR_OID_PROC = proc.OID_PROC ");
        query.append(" and sub.COD_SUBP = " + codigoSubproceso.longValue());        
        query.append(" AND tipoAbonoSub.TCAB_OID_TCAB = " + oidTipoCargoAbono);

        try  {
            rs =  getBelcorpService().dbService.executeStaticQuery(query.toString());            
            UtilidadesLog.debug("obtenerOidTiposAbonoSubproceso trae: " + rs);
            
            UtilidadesLog.info("DAOCCC.obtenerOidTiposAbonoSubproceso(String codProcMarcasUlti,"+
            "Integer codigoSubproceso, Long oidPais, Long oidTipoCargoAbono): Salida");

            if ((rs==null) || (rs.getRowCount()==0))
                return null;
            else
                return rs;
        }
        catch (MareException me) {
          UtilidadesLog.debug("obtenerOidTiposAbonoSubproceso: llego a la excepcion Mare"); 
          throw me;
        }
        catch (Exception ex){
          UtilidadesLog.debug("obtenerOidTiposAbonoSubproceso: llego a la excepcion desconocida");
          ex.printStackTrace();
          throw new MareException(ex,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }  
    
    public RecordSet obtenerMarcasSituacionSalida(String codProcMarcasUlti, Integer codigoSubproceso, Long oidPais, Long oidTipoAbon) throws MareException {
        
        UtilidadesLog.info("DAOCCC.obtenerMarcasSituacionSalida(Long oidProcMarcasUlti, Integer codigoSubproceso, Long oidPais, Long oidTipoAbon): Entrada ");        

        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT u.OID_MARC_SITU ");
        consulta.append(" FROM CCC_MARCA_SITUA u, CCC_MARCA_TIPO_ABONO m, ");
        consulta.append(" CCC_TIPO_ABONO_SUBPR t, CCC_SUBPR s,CCC_PROCE p ");
        consulta.append(" WHERE u.OID_MARC_SITU = m.MASI_OID_MARC_SALI ");
        consulta.append(" AND m.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP ");
        consulta.append(" AND p.COD_PROC = '" + codProcMarcasUlti + "'");
        consulta.append(" AND p.PAIS_OID_PAIS = " + oidPais.longValue()); //BELC300010693
        consulta.append(" AND s.CCPR_OID_PROC = p.OID_PROC ");
        consulta.append(" AND s.COD_SUBP = " + codigoSubproceso.longValue());
        consulta.append(" AND t.SUBP_OID_SUBP = s.OID_SUBP ");
        consulta.append(" AND m.TASP_OID_TIPO_ABON_SUBP = " + oidTipoAbon.longValue());   
        consulta.append(" AND m.IND_ENTR_SALI like 'S' ");

        // Se ejecuta la consulta         
        RecordSet rs = null;        

        try  {
            rs =  getBelcorpService().dbService.executeStaticQuery(consulta.toString());            
            UtilidadesLog.debug("obtenerMarcasSituacionSalida trae: " + rs);
            
            UtilidadesLog.info("DAOCCC.obtenerMarcasSituacionSalida(Long oidProcMarcasUlti, Integer codigoSubproceso, Long oidPais, Long oidTipoAbon): Salida ");        

            if ((rs==null) || (rs.getRowCount()==0))
                return null;
            else
                return rs;
        } catch (MareException me) {
           UtilidadesLog.debug("obtenerMarcasSituacionSalida: llego a la excepcion Mare "); 
            throw me;
        } catch (Exception ex){
            UtilidadesLog.debug("obtenerMarcasSituacionSalida: llego a la excepcion desconocida ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

    }


    public Long obtenerTipoPeriodo(Long oidCanal) throws MareException{
        UtilidadesLog.info("DAOCCC.obtenerTipoPeriodo(): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" select can.TIPE_OID_TIPO_PERI ");
        query.append(" from seg_canal can ");
        query.append(" where can.OID_CANA = " + oidCanal );

        try  {
            rs =  getBelcorpService().dbService.executeStaticQuery(query.toString());            
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception ex){
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        Long oidTipoPeriodo = this.bigDecimalToLong(rs.getValueAt(0,0));
        UtilidadesLog.info("DAOCCC.obtenerTipoPeriodo(): Salida ");        
        return oidTipoPeriodo;
    }  
    
    /* mdolce 15/02/07 Metodo para insertar registro para control de concurrencia entre:
     * Confirmacion de MOvimientos Bancarios
     * Cargos y Abonos
     * Facturacion
     * */
    public void insertarBloqueo(DTOBloqueo dto) throws MareException{
      UtilidadesLog.info("DAOCCC.insertarBloqueo(): Entrada ");


      ExcepcionParametrizada exParam;
      RecordSet rs;
      rs = this.consultarBloqueo();
      
      if(rs.getRowCount() > 0){
         String usuarioGuardado = rs.getValueAt(0,1).toString();
         String fecha = rs.getValueAt(0,2).toString();
         String descripcionProceso = rs.getValueAt(0,3).toString();
         UtilidadesLog.warn("El proceso no se puede ejecutar porque el usuario " + usuarioGuardado 
                                  + " ha bloqueado el " + fecha + " las tablas que son necesarias para el proceso " 
                                  + descripcionProceso );
        exParam = new ExcepcionParametrizada(new MareException(),   
                                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",
                                                        ErroresDeNegocio.PROCESO_BLOQUEADO_PARA_USUARIO));
        exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
        exParam.addParameter( usuarioGuardado );
        exParam.addParameter( descripcionProceso );
        throw exParam;
      }
		
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try  {
           //bs.dbService.executeUpdate(query.toString());
           ArrayList lista = new ArrayList();
           lista.add(dto.getUsuario());
           lista.add(dto.getDescripcionProceso());
           bs.dbService.executeProcedure("pq_apl_aux.Insertar_Bloqueo_CCC",lista);
        } catch (Exception ex) {
            ex.printStackTrace();
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }		
		UtilidadesLog.info("DAOCCC.insertarBloqueo(): Salida ");	    
    }
    /* mdolce 15/02/07 Metodo para eliminar registro para control de concurrencia entre:
     * Confirmacion de MOvimientos Bancarios
     * Cargos y Abonos
     * Facturacion
     * */
    public void eliminarBloqueo() throws MareException{
      UtilidadesLog.info("DAOCCC.eliminarBloqueo(): Entrada ");

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		
		try  {
                    ArrayList dummy = new ArrayList();
                    dummy.add(new String(""));
                    bs.dbService.executeProcedure("pq_apl_aux.Borrar_Bloqueo_CCC",dummy);
                } catch (Exception ex) {
                    //ex.printStackTrace();
                }		
		UtilidadesLog.info("DAOCCC.eliminarBloqueo(): Salida ");	    
    }    

   /* mdolce 15/02/07 Metodo para consultar registro para control de concurrencia entre:
     * Confirmacion de MOvimientos Bancarios
     * Cargos y Abonos
     * Facturacion
     * */
    public RecordSet consultarBloqueo() throws MareException{
       UtilidadesLog.info("DAOCCC.consultarBloqueo(): Entrada");
       
       StringBuffer query = new StringBuffer();
       RecordSet rs;
       query.append(" select * ");
       query.append(" from ccc_bloqu ");
       try  {
           rs =  getBelcorpService().dbService.executeStaticQuery(query.toString());            
       } catch(MareMiiServiceNotFoundException e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       } catch (Exception ex){
         ex.printStackTrace();
         throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
       
       UtilidadesLog.info("DAOCCC.consultarBloqueo(): Salida");
      
       return rs;
          
    }
    
    public String obtenerDireccionPpalCliente(Long oidCliente) throws MareException{
        UtilidadesLog.debug("DAOCCC.obtenerDireccionPpalCliente(Long oidCliente): Entrada");
        UtilidadesLog.debug("oidCliente:["+oidCliente+"]");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        String salida = null;

        try {
            query.append(" SELECT v1.val_i18n, v2.val_i18n, val_nomb_via, ");
            query.append("        num_ppal, val_inte, val_manz, val_lote, val_km, val_cod_post, ");
            query.append("        clie_oid_clie, oid_clie_dire ");
            query.append("   FROM mae_clien_direc, v_gen_i18n_sicc v1, v_gen_i18n_sicc v2 ");
            query.append("  WHERE clie_oid_clie = "+oidCliente.toString()+" ");
            query.append("    AND ind_elim = 0 ");
            query.append("    AND ind_dire_ppal = 1 ");
            query.append("    AND v1.attr_enti = 'MAE_TIPO_DIREC' ");
            query.append("    AND v1.attr_num_atri = 1 ");
            query.append("    AND v1.idio_oid_idio = 1 ");
            query.append("    AND v1.val_oid = mae_clien_direc.tidc_oid_tipo_dire ");
            query.append("    AND v2.attr_enti = 'SEG_TIPO_VIA' ");
            query.append("    AND v2.attr_num_atri = 1 ");
            query.append("    AND v2.idio_oid_idio = 1 ");
            query.append("    AND v2.val_oid = mae_clien_direc.tivi_oid_tipo_via ");

            bs = BelcorpService.getInstance();

            RecordSet resultado = bs.dbService.executeStaticQuery(query.toString());
            
            if(resultado.getRowCount()>0){
                //if(resultado.getValueAt(0, 0)!=null) salida += (resultado.getValueAt(0, 0).toString() + " ");
                if(resultado.getValueAt(0, 1)!=null) salida = (resultado.getValueAt(0, 1).toString() + " ");
                if(resultado.getValueAt(0, 2)!=null) salida += (resultado.getValueAt(0, 2).toString() + " ");
                if(resultado.getValueAt(0, 3)!=null) salida += (resultado.getValueAt(0, 3).toString() + " ");
                if(resultado.getValueAt(0, 4)!=null) salida += (((BigDecimal) resultado.getValueAt(0, 4)).intValue() + " ");
                if(resultado.getValueAt(0, 5)!=null) salida += (((BigDecimal) resultado.getValueAt(0, 5)).intValue() + " ");
                if(resultado.getValueAt(0, 6)!=null) salida += (((BigDecimal) resultado.getValueAt(0, 6)).intValue() + " ");
                if(resultado.getValueAt(0, 7)!=null) salida += (((BigDecimal) resultado.getValueAt(0, 7)).intValue() + " ");
                if(resultado.getValueAt(0, 8)!=null) salida += (resultado.getValueAt(0, 8).toString());
            }else{
                UtilidadesLog.error("No se han encontrado direccion para oidCliente:["+oidCliente+"]");
            }
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
       UtilidadesLog.info("DAOCCC.obtenerDireccionPpalCliente(Long oidCliente): Salida");
       return salida;
    }

    /**
     * Metodo que trae las solicitudes origen de una solictud RECLAMO
     * Agregado por HRCS - Fecha 21/06/2007 - Cambio Sicc20070296
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList con la o las solicitudes origen
     * @param oidConsolidado
     */
    public ArrayList obtenerSolicitudesOrigenReclamo(Long oidConsolidado) throws MareException {
        UtilidadesLog.debug("DAOCCC.obtenerSolicitudesOrigenReclamo(Long oidConsolidado): Entrada"); 
        
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        query.append(" SELECT ");
        query.append("   cons.oid_soli_cabe as CONSOLIDADO ");
        query.append("   , cons.val_tota_paga_loca as CONVTPL ");
        query.append("   , solicRecla.oid_soli_cabe as RECLAMO ");
        query.append("   , solicRecla.modu_oid_modu as RECMOD ");
        query.append("   , solicRecla.val_tota_paga_loca as RECVTPL ");
        query.append("   , solicRecla.soca_oid_docu_refe as RECSOLREF ");
        query.append("   , sum(posicRecla.val_prec_fact_tota_loca - posicRecla.val_prec_cont_tota_loca + cons.val_impo_flet_tota_loca) as RECPOSSUM ");
        query.append("   , 'C' || perioCorpo.cod_peri || ' ' || opera.val_desc_larg || ' NRO.' || cabecRecla.num_recl as DESCRIP ");
        query.append(" FROM ");
        query.append("   ped_solic_cabec cons ");
        query.append("   , ped_solic_cabec solicRecla ");
        query.append("   , ped_solic_cabec solicOrigen ");
        query.append("   , ped_solic_posic posicRecla ");
        query.append("   , rec_solic_opera solicOpera ");
        query.append("   , rec_opera_recla operaRecla ");
        query.append("   , rec_cabec_recla cabecRecla ");
        query.append("   , rec_tipos_opera tiposOpera ");
        query.append("   , rec_opera opera ");
        query.append("   , cra_perio perio ");
        query.append("   , seg_perio_corpo perioCorpo ");
        query.append(" WHERE ");
        query.append("   cons.oid_soli_cabe = ? ");
        parametros.add(oidConsolidado);
        query.append("   AND cons.oid_soli_cabe = solicRecla.soca_oid_soli_cabe ");
        query.append("   AND solicRecla.oid_soli_cabe = posicRecla.soca_oid_soli_cabe(+) ");
        query.append("   AND solicRecla.soca_oid_docu_refe is not null ");    // Esto para validar si es reclamo
        query.append("   AND solicRecla.oid_soli_cabe = solicOpera.soca_oid_soli_cabe ");
        query.append("   AND solicOpera.opre_oid_oper_recl = operaRecla.oid_oper_recl ");
        query.append("   AND operaRecla.care_oid_cabe_recl = cabecRecla.oid_cabe_recl ");
        query.append("   AND operaRecla.tiop_oid_tipo_oper = tiposOpera.oid_tipo_oper ");
        query.append("   AND tiposOpera.rope_oid_oper = opera.oid_oper ");
        query.append("   AND solicRecla.soca_oid_docu_refe = solicOrigen.oid_soli_cabe ");
        query.append("   AND solicOrigen.perd_oid_peri = perio.oid_peri ");
        query.append("   AND perio.peri_oid_peri = perioCorpo.oid_peri ");
        query.append(" GROUP BY ");
        query.append("   cons.oid_soli_cabe ");
        query.append("   , cons.val_tota_paga_loca ");
        query.append("   , solicRecla.oid_soli_cabe ");
        query.append("   , solicRecla.modu_oid_modu ");
        query.append("   , solicRecla.val_tota_paga_loca ");
        query.append("   , solicRecla.soca_oid_docu_refe ");
        query.append("   , cabecRecla.num_recl ");
        query.append("   , opera.val_desc_larg ");
        query.append("   , perioCorpo.cod_peri ");
        query.append("   , cons.val_impo_flet_tota_loca");
    
        RecordSet rs = new RecordSet();
        try {
            rs = BelcorpService.getInstance().dbService.executePreparedQuery(query.toString(),parametros);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        //  Volcamos los resultados en un HasMap
        ArrayList solicitudes = new ArrayList();
        try {
        if (rs!=null && !rs.esVacio())  {
            for (int i = 0; i < rs.getRowCount(); i++)  {
                HashMap solicitud = new HashMap();
                solicitud.put( "CONSOLIDADO", (rs.getValueAt(i,0)!=null? new Long( ((BigDecimal)rs.getValueAt(i,0)).longValue() ) : null ) );
                solicitud.put( "CONVTPL", (rs.getValueAt(i,1)!=null? new Double( ((BigDecimal)rs.getValueAt(i,1)).doubleValue() ) : null ) );
                solicitud.put( "RECLAMO", (rs.getValueAt(i,2)!=null? new Long( ((BigDecimal)rs.getValueAt(i,2)).longValue() ) : null ) );
                solicitud.put( "RECMOD", rs.getValueAt(i,3) );
                solicitud.put( "RECVTPL", (rs.getValueAt(i,4)!=null? new Double( ((BigDecimal)rs.getValueAt(i,4)).doubleValue() ) : null ) );
                solicitud.put( "RECSOLREF", (rs.getValueAt(i,5)!=null? new Long( ((BigDecimal)rs.getValueAt(i,5)).longValue() ) : null ) );
                solicitud.put( "RECPOSSUM", (rs.getValueAt(i,6)!=null? new Double( ((BigDecimal)rs.getValueAt(i,6)).doubleValue() ) : null ) );
                solicitud.put( "DESCRIP", rs.getValueAt(i,7) );
                //  Agregando al array de solicitudes
                solicitudes.add( solicitud );
            }
        }
        UtilidadesLog.debug("DAOCCC.obtenerSolicitudesOrigenReclamo(Long oidConsolidado): Salida"); 
        }
        catch(Exception e)  {
            UtilidadesLog.debug("Error: " + e.getMessage() );     
            e.printStackTrace();
        }
        return solicitudes;
    }
    
  public long obtenerDiasCruceCup3(long pais) throws MareException {
        //cambio fac 03, modulo ccc (SCS-29/01/2008)
		UtilidadesLog.info("DAOCCC.obtenerDiasCruceCup3(long pais): Entrada");
        long diasCruce = 0;
	    RecordSet rs;
	    StringBuffer consulta = new StringBuffer();

        consulta.append("SELECT NUM_DIAS_CUPO_CRUC ");
  	    consulta.append("FROM ");
	    consulta.append("SEG_PARAM_INTER_PAIS spip ");
  	    consulta.append("WHERE ");
  	    consulta.append("spip.PAIS_OID_PAIS = " + pais);
      
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if ((rs != null) && (rs.getRowCount()>0))
            if (!(rs.getValueAt(0, 0)==null))
                diasCruce = ((BigDecimal) rs.getValueAt(0, 0)).longValue();
            else
                UtilidadesLog.debug("dias cruce nulo!!");
        else
            UtilidadesLog.debug("no hay registro");
            
        UtilidadesLog.debug("dias cruce..: " + diasCruce);
        UtilidadesLog.info("DAOCCC.obtenerDiasCruceCup3(long pais): Salida");
        return diasCruce;
  }  
  
  public boolean aplicaCupon3(long pais) throws MareException {
        //cambio fac 03, modulo ccc (SCS-29/01/2008)
		UtilidadesLog.info("DAOCCC.aplicaCupon3(long pais): Entrada");
        boolean aplica = false;
	    RecordSet rs;
	    StringBuffer consulta = new StringBuffer();

        consulta.append("SELECT IND_APLI_CUPO_TRES ");
  	    consulta.append("FROM ");
	    consulta.append("SEG_PARAM_INTER_PAIS spip ");
  	    consulta.append("WHERE ");
  	    consulta.append("spip.PAIS_OID_PAIS = " + pais);
      
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if ((rs != null) && (rs.getRowCount()>0)) 
            if (((BigDecimal) rs.getValueAt(0, 0)).longValue()==1)
                aplica=true;
       
        UtilidadesLog.debug("aplica..: " + aplica);
        UtilidadesLog.info("DAOCCC.aplicaCupon3(long pais): Salida");
        return aplica;
  }    
  
    /**
     * 
     * @date 24/07/2008
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidCliente
     * @author jrivas
     */
     //CCC-04
    public BigDecimal calcularPagoSaldoVencido(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOCCC.calcularPagoSaldoVencido(Long oidCliente): Entrada"); 

        StringBuffer sql = new StringBuffer();
        BigDecimal valorRetorno = null;
        RecordSet recordset = null;
        
        sql.append(" SELECT SUM (MCC.IMP_PEND) SALDO_PENDIENTE ");
        sql.append("   FROM ccc_movim_cuent_corri mcc ");
        sql.append("   WHERE mcc.clie_oid_clie =" + oidCliente);
        sql.append("            AND MCC.FEC_VENC <= SYSDATE ");
        
        try {
            recordset = BelcorpService.getInstance().dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("calcularPagoSaldoVencido" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (!recordset.esVacio() && recordset.getValueAt(0,0) != null) {
            valorRetorno = ((BigDecimal)recordset.getValueAt(0, 0));
        } else {
            valorRetorno = new BigDecimal(0);   
        }
        UtilidadesLog.info("DAOCCC.calcularPagoSaldoVencido(Long oidCliente): Salida"); 
        
        return valorRetorno;
    } 
    
    /**
     * 
     * @date 24/07/2008
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidCliente
     * @author jrivas
     */
     //CCC-04
    public BigDecimal calcularSaldoPorVencer(Long oidCliente, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOCCC.calcularSaldoPorVencer(Long oidCliente, Long oidPais): Entrada"); 

        StringBuffer sql = new StringBuffer();
        BigDecimal valorRetorno = null;
        RecordSet recordset = null;
        
        sql.append(" SELECT SUM (mcc.imp_pend) saldo_pendiente ");
        sql.append("   FROM ccc_movim_cuent_corri mcc ");
        sql.append("  WHERE mcc.clie_oid_clie =" + oidCliente);
        sql.append("    AND mcc.fec_venc <=  ");
        sql.append("           (SELECT  fec_inic FROM ");        
        sql.append("               (SELECT   cc.fec_inic ");
        sql.append("                 FROM cra_crono cc, ");
        sql.append("                      zon_zona zz, ");
        sql.append("                      cra_activ ca, ");
        sql.append("                      mae_clien_unida_admin mcua, ");
        sql.append("                      zon_terri_admin zta, ");
        sql.append("                      zon_secci zs ");
        sql.append("                WHERE cc.fec_inic >= SYSDATE ");
        sql.append("                  AND cc.cact_oid_acti = ca.oid_acti ");
        sql.append("                  AND ca.cod_acti = 'FA' ");
        sql.append("                  AND cc.zzon_oid_zona = zz.oid_zona ");
        sql.append("                  AND mcua.clie_oid_clie =" + oidCliente);
        sql.append("                  AND mcua.ztad_oid_terr_admi = zta.oid_terr_admi ");
        sql.append("                  AND zta.zscc_oid_secc = zs.oid_secc ");
        sql.append("                  AND zs.zzon_oid_zona = zz.oid_zona ");
        sql.append("                  AND zz.ind_acti = 1 ");
        sql.append("                  AND zz.ind_borr = 0 ");
        sql.append("                  AND mcua.IND_ACTI = 1 ");
        sql.append("                  AND zz.pais_oid_pais =" + oidPais);
        sql.append("             ORDER BY FEC_INIC ASC)");
        sql.append("            WHERE ROWNUM = 1) ");
        
        try {
            recordset = BelcorpService.getInstance().dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("calcularSaldoPorVencer" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (!recordset.esVacio() && recordset.getValueAt(0,0) != null) {
            if (((BigDecimal)recordset.getValueAt(0, 0)).longValue() >= 0) {    
                valorRetorno = ((BigDecimal)recordset.getValueAt(0, 0));    
            } else {
                valorRetorno = new BigDecimal(0);   
            }
        } else {
            valorRetorno = new BigDecimal(0);   
        }
        UtilidadesLog.info("DAOCCC.calcularSaldoPorVencer(Long oidCliente, Long oidPais): Salida"); 
        
        return valorRetorno;
    }     
    
    public Integer obtenerNumDeci(Long oidPais) throws MareException{
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT MON_PAI.NUM_DECI NUM_DECI_PAIS ");
      query.append(" FROM SEG_PAIS PAIS, ");
      query.append("      SEG_MONED MON_PAI ");  
      query.append(" WHERE PAIS.OID_PAIS = " + oidPais);
      query.append("   AND PAIS.MONE_OID_MONE = MON_PAI.OID_MONE ");
      
      RecordSet rs = null;     
      try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("obtenerNumDeci" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      if (!(rs == null) && !(rs.esVacio())){
                return new Integer(this.bigDecimalToLong(rs.getValueAt(0,"NUM_DECI_PAIS")).intValue());
      } else {
            return new Integer(2);
      }
    }   

    //CCC-04
    public RecordSet obtenerDatosDetalle(Long oidPais, Long oidIdioma, Long oid) throws MareException {
        UtilidadesLog.info("DAOCCC.obtenerDatosDetalle(Long oidPais, Long oidIdioma, Long oid): Entrada"); 

        StringBuffer sql = new StringBuffer();
        BigDecimal valorRetorno = null;
        RecordSet recordset = null;

        sql.append(" SELECT MC.OID_CLIE, MC.COD_CLIE, MOVCTACTE.PERD_OID_PERI,");
        sql.append("        MC.VAL_NOM1 || ' ' || MC.VAL_NOM2 || ' ' || MC.VAL_APE1 || ' ' ");
        sql.append("        || MC.VAL_APE2 AS APENOM, ");
        sql.append("        (SELECT PERIODOCORPORATIVO.COD_PERI ");
        sql.append("           FROM CRA_PERIO PERIODOCRONOGRAMA, ");
        sql.append("                SEG_PERIO_CORPO PERIODOCORPORATIVO ");
        sql.append("          WHERE PERIODOCRONOGRAMA.PERI_OID_PERI = PERIODOCORPORATIVO.OID_PERI ");
        sql.append("            AND MOVCTACTE.PERD_OID_PERI = PERIODOCRONOGRAMA.OID_PERI) AS CAMPANIA, ");
        sql.append("        (NVL2 (MOVCTACTE.NUM_IDEN_CUOT, ");
        sql.append("               MOVCTACTE.NUM_IDEN_CUOT, ");
        sql.append("               NVL2 (DETALLECARGOABONO.CCBA_OID_CUEN_CORR_BANC, ");
        sql.append("                     (SELECT MOVIM_BANCA.NUM_LOTE ");
        sql.append("                        FROM CCC_MOVIM_BANCA MOVIM_BANCA ");
        sql.append("                       WHERE MOVIM_BANCA.OID_MOVI_BANC = ");
        sql.append("                                                       DETALLECARGOABONO.CMBA_OID_MOVI_BANC), ");
        sql.append("                     NULL ");
        sql.append("                    ) ");
        sql.append("               ) ");
        sql.append("        ) AS NUM_CONSOLIDADO, ");
        sql.append("        CARGOCABECERA.FEC_VALO FECHA_FACTURACION, ");
        sql.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC ("+oidIdioma+", ");
        sql.append("                                        CONSOLIDADO.INRE_OID_INDI_REVI, ");
        sql.append("                                        'PED_INDIC_REVIS' ");
        sql.append("                                       ) IND_CHEQUEO, ");
        sql.append("        CONSOLIDADO.VAL_IMPO_FLET_TOTA_LOCA IMPORTE_FLETE, ");
        sql.append("        CONSOLIDADO.VAL_IMPO_IMPU_TOTA_LOCA IMPUESTOS ");
        //CCC-05 jrivas 6/10/08
        sql.append("        , CONSOLIDADO.PERD_OID_PERI PERIODO_SOLICITUD, ");
        sql.append("        consolidado.oid_soli_cabe");
        
        sql.append("   FROM MAE_CLIEN MC, ");
        sql.append("        CCC_CABEC_CARGA_ABONO_DIREC CARGOCABECERA, ");
        sql.append("        CCC_DETAL_CARGO_ABONO_DIREC DETALLECARGOABONO, ");
        sql.append("        CCC_MOVIM_CUENT_CORRI  MOVCTACTE,  ");
        sql.append("        PED_SOLIC_CABEC CONSOLIDADO ");
        sql.append("  WHERE MC.OID_CLIE = DETALLECARGOABONO.CLIE_OID_CLIE");
        sql.append("    AND MC.PAIS_OID_PAIS =" + oidPais);
        sql.append("    AND DETALLECARGOABONO.OID_DETA_CARG_ABON_DIRE = " + oid);
        sql.append("    AND DETALLECARGOABONO.MVCC_OID_MOVI_CC = MOVCTACTE.OID_MOVI_CC(+) ");
        sql.append("    AND DETALLECARGOABONO.CCAD_OID_CABE_CARG = CARGOCABECERA.OID_CABE_CARG ");
        sql.append("    AND CARGOCABECERA.PAIS_OID_PAIS =" + oidPais);
        sql.append("    AND MOVCTACTE.SOCA_OID_SOLI_CABE = CONSOLIDADO.OID_SOLI_CABE(+) ");
           
        try {
            recordset = BelcorpService.getInstance().dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("obtenerDatosDetalle" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCCC.obtenerDatosDetalle(Long oidPais, Long oidIdioma, Long oid): Salida"); 
        
        return recordset;
    }     
    
    //CCC-04
    public RecordSet obtenerNumeroFactura(Long oid) throws MareException {
        UtilidadesLog.info("DAOCCC.obtenerNumeroFactura(Long oid): Entrada"); 

        StringBuffer sql = new StringBuffer();
        BigDecimal valorRetorno = null;
        RecordSet recordset = null;

        sql.append(" SELECT NVL(DCC.VAL_SERI_DOCU_LEGA || '-' || DCC.NUM_DOCU_LEGA, '') NUMERO_FACTURA ");
        sql.append(" FROM FAC_DOCUM_CONTA_CABEC DCC,  CCC_DETAL_CARGO_ABONO_DIREC DCAC, ");
        sql.append("        CCC_MOVIM_CUENT_CORRI  MCC ");
        sql.append(" WHERE DCAC.OID_DETA_CARG_ABON_DIRE = " + oid);
        sql.append("    AND DCAC.MVCC_OID_MOVI_CC = MCC.OID_MOVI_CC ");
        sql.append("    AND MCC.SOCA_OID_SOLI_CABE = DCC.SOCA_OID_SOLI_CABE  ");

        try {
            recordset = BelcorpService.getInstance().dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("obtenerNumeroFactura" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCCC.obtenerNumeroFactura(Long oid): Salida "); 
        
        return recordset;
    }         
    
    //CCC-04
    public String obtenerSaldoPendiente(Long oidPais, Long oidCliente, Long periodoSolicitud) throws MareException{
      UtilidadesLog.info("DAOCCC.obtenerSaldoPendiente(Long oidPais, Long oidCliente): Entreda");       
      StringBuffer query = new StringBuffer();
      
        query.append(" SELECT NVL(SUM (MCC.IMP_PEND), 0) SALDO_PENDIENTE  ");
        query.append("   FROM ccc_movim_cuent_corri mcc ");
        query.append("  WHERE mcc.clie_oid_clie = " + oidCliente); 
        query.append("     and mcc.IMP_PEND > 0 ");
        query.append("     and ( mcc.FEC_VENC >= (select (SELECT cc.fec_inic ");
        query.append("                FROM cra_crono cc, ");
        query.append("                     zon_zona zz, ");
        query.append("                     cra_activ ca, ");
        query.append("                     mae_clien_unida_admin mcua, ");
        query.append("                     zon_terri_admin zta, ");
        query.append("                     zon_secci zs ");
        //CCC-05 jrivas 6/10/08
        //query.append("               WHERE CC.PERD_OID_PERI = (SELECT C.OID_PERI FROM CRA_PERIO C WHERE C.FEC_INIC <= SYSDATE AND C.FEC_FINA >= SYSDATE AND ROWNUM =1)  ");
        query.append("               WHERE CC.PERD_OID_PERI = " + periodoSolicitud);
        query.append("                 AND cc.cact_oid_acti = ca.oid_acti ");
        query.append("                 AND ca.cod_acti = 'FA'  ");
        query.append("                 AND cc.zzon_oid_zona = zz.oid_zona  ");
        query.append("                 AND mcua.clie_oid_clie = " + oidCliente); 
        query.append("                 AND mcua.ztad_oid_terr_admi = zta.oid_terr_admi ");
        query.append("                 AND zta.zscc_oid_secc = zs.oid_secc ");
        query.append("                 AND zs.zzon_oid_zona = zz.oid_zona ");
        query.append("                 AND zz.ind_acti = 1 ");
        query.append("                 AND zz.ind_borr = 0 ");
        query.append("                 AND zz.pais_oid_pais =  " + oidPais); 
        query.append("                 AND ROWNUM = 1)+1 from dual))   ");
        query.append("     and (mcc.FEC_VENC <= (SELECT   cc.fec_inic ");
        query.append("                             FROM cra_crono cc, ");
        query.append("                                  zon_zona zz, ");
        query.append("                                  cra_activ ca, ");
        query.append("                                  mae_clien_unida_admin mcua, ");
        query.append("                                  zon_terri_admin zta, ");
        query.append("                                  zon_secci zs ");
        //CCC-05 jrivas 6/10/08
        //query.append("                            WHERE CC.PERD_OID_PERI = (select OID_PERI from (SELECT C.OID_PERI FROM CRA_PERIO C WHERE C.FEC_INIC >= SYSDATE order by c.fec_inic) WHERE ROWNUM=1)  ");
        query.append("                            WHERE CC.PERD_OID_PERI =  (SELECT OID_PERI ");
        query.append("                                                         FROM (SELECT   C.OID_PERI ");
        query.append("                                                                   FROM CRA_PERIO C, CRA_PERIO C2 ");
        query.append("                                                                  WHERE C2.OID_PERI = " + periodoSolicitud + " AND C.FEC_INIC > C2.FEC_INIC ");
        query.append("                                                               ORDER BY C.FEC_INIC) ");
        query.append("                                                        WHERE ROWNUM = 1) ");
        query.append("                              AND cc.cact_oid_acti = ca.oid_acti ");
        query.append("                              AND ca.cod_acti = 'FA'  ");
        query.append("                              AND cc.zzon_oid_zona = zz.oid_zona  ");
        query.append("                              AND mcua.clie_oid_clie =  " + oidCliente);  
        query.append("                              AND mcua.ztad_oid_terr_admi = zta.oid_terr_admi ");
        query.append("                              AND zta.zscc_oid_secc = zs.oid_secc ");
        query.append("                              AND zs.zzon_oid_zona = zz.oid_zona ");
        query.append("                              AND zz.ind_acti = 1 ");
        query.append("                              AND zz.ind_borr = 0 ");
        query.append("                              AND zz.pais_oid_pais =  " + oidPais); 
        query.append("                              AND ROWNUM = 1)) "); 

      RecordSet rs = null;     
      try {
            rs = (RecordSet) BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("obtenerSaldoPendiente" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      String salida = "";
      if (rs != null && !rs.esVacio()){
            salida =  rs.getValueAt(0,"SALDO_PENDIENTE").toString();
      }

      UtilidadesLog.info("DAOCCC.obtenerSaldoPendiente(Long oidPais, Long oidCliente): Salida " + salida);       
      return salida;
    }       
    
    //CCC-04
    public String obtenerPagosPosteriores(Long oidPais, Long oidCliente, Long oidPeriodo, Long periodoSolicitud) throws MareException{
      UtilidadesLog.info("DAOCCC.obtenerPagosPosteriores(Long oidPais, Long oidCliente, Long oidPeriodo): Entreda");       
      StringBuffer query = new StringBuffer();

        query.append(" SELECT NVL(SUM (MCC.IMP_PEND), 0) PAGOS_POSTERIORES ");
        query.append("   FROM CCC_MOVIM_CUENT_CORRI MCC ");
        query.append("  WHERE MCC.CLIE_OID_CLIE =  " + oidCliente);
        query.append("    AND MCC.PERD_OID_PERI = " + oidPeriodo);
        query.append("    AND MCC.IMP_PEND > 0 ");
        query.append("    AND MCC.FEC_VENC > ");
        query.append("           (SELECT CC.FEC_INIC ");
        query.append("              FROM CRA_CRONO CC, ");
        query.append("                   ZON_ZONA ZZ, ");
        query.append("                   CRA_ACTIV CA, ");
        query.append("                   MAE_CLIEN_UNIDA_ADMIN MCUA, ");
        query.append("                   ZON_TERRI_ADMIN ZTA, ");
        query.append("                   ZON_SECCI ZS ");
        query.append("             WHERE CC.PERD_OID_PERI = ");
        //CCC-05 jrivas 6/10/08
        query.append("                            (SELECT OID_PERI ");
        query.append("                                FROM (SELECT   C.OID_PERI ");
        query.append("                                           FROM CRA_PERIO C, CRA_PERIO C2 ");
        query.append("                                           WHERE C2.OID_PERI = " + periodoSolicitud + " AND C.FEC_INIC > C2.FEC_INIC ");
        query.append("                                           ORDER BY C.FEC_INIC) ");
        query.append("                              WHERE ROWNUM = 1) ");
        query.append("               AND CC.CACT_OID_ACTI = CA.OID_ACTI ");
        query.append("               AND CA.COD_ACTI = 'FA' ");
        query.append("               AND CC.ZZON_OID_ZONA = ZZ.OID_ZONA ");
        query.append("               AND MCUA.CLIE_OID_CLIE = " + oidCliente);
        query.append("               AND MCUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
        query.append("               AND ZTA.ZSCC_OID_SECC = ZS.OID_SECC ");
        query.append("               AND ZS.ZZON_OID_ZONA = ZZ.OID_ZONA ");
        query.append("               AND ZZ.IND_ACTI = 1 ");
        query.append("               AND ZZ.IND_BORR = 0 ");
        query.append("               AND ZZ.PAIS_OID_PAIS = " + oidPais);
        query.append("               AND ROWNUM = 1)     ");
        
      RecordSet rs = null;     
      try {
            rs = (RecordSet) BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("obtenerPagosPosteriores" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      String salida = "";
      if (rs != null && !rs.esVacio()){
            salida =  rs.getValueAt(0,"PAGOS_POSTERIORES").toString();
      }

      UtilidadesLog.info("DAOCCC.obtenerPagosPosteriores(Long oidPais, Long oidCliente, Long oidPeriodo): Salida " + salida);       
      return salida;
    }      
    
    //CCC-04
    public String obtenerPagosDiferidos(Long oidPais, Long oidCliente, Long oidPeriodo, Long periodoSolicitud) throws MareException{
      UtilidadesLog.info("DAOCCC.obtenerPagosDiferidos(Long oidPais, Long oidCliente, Long oidPeriodo): Entreda");       
      StringBuffer query = new StringBuffer();

        query.append(" SELECT NVL(SUM (MCC.IMP_PEND), 0) PAGOS_DIFERIDOS ");
        query.append("   FROM CCC_MOVIM_CUENT_CORRI MCC ");
        query.append("  WHERE MCC.CLIE_OID_CLIE = " + oidCliente);
        query.append("    AND MCC.PERD_OID_PERI <> " + oidPeriodo);
        query.append("    AND MCC.IMP_PEND > 0 ");
        query.append("    AND (    MCC.FEC_VENC >= ");
        query.append("                (SELECT   (SELECT CC.FEC_INIC ");
        query.append("                             FROM CRA_CRONO CC, ");
        query.append("                                  ZON_ZONA ZZ, ");
        query.append("                                  CRA_ACTIV CA, ");
        query.append("                                  MAE_CLIEN_UNIDA_ADMIN MCUA, ");
        query.append("                                  ZON_TERRI_ADMIN ZTA, ");
        query.append("                                  ZON_SECCI ZS ");
        //CCC-05 jrivas 6/10/08
        query.append("                            WHERE CC.PERD_OID_PERI = " + periodoSolicitud);
        query.append("                              AND CC.CACT_OID_ACTI = CA.OID_ACTI ");
        query.append("                              AND CA.COD_ACTI = 'FA' ");
        query.append("                              AND CC.ZZON_OID_ZONA = ZZ.OID_ZONA ");
        query.append("                              AND MCUA.CLIE_OID_CLIE = " + oidCliente);
        query.append("                              AND MCUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
        query.append("                              AND ZTA.ZSCC_OID_SECC = ZS.OID_SECC ");
        query.append("                              AND ZS.ZZON_OID_ZONA = ZZ.OID_ZONA ");
        query.append("                              AND ZZ.IND_ACTI = 1 ");
        query.append("                              AND ZZ.IND_BORR = 0 ");
        query.append("                              AND ZZ.PAIS_OID_PAIS = " + oidPais);
        query.append("                              AND ROWNUM = 1) ");
        query.append("                        + 1 ");
        query.append("                   FROM DUAL) ");
        query.append("         AND MCC.FEC_VENC <= ");
        query.append("                (SELECT   (SELECT CC.FEC_INIC ");
        query.append("                             FROM CRA_CRONO CC, ");
        query.append("                                  ZON_ZONA ZZ, ");
        query.append("                                  CRA_ACTIV CA, ");
        query.append("                                  MAE_CLIEN_UNIDA_ADMIN MCUA, ");
        query.append("                                  ZON_TERRI_ADMIN ZTA, ");
        query.append("                                  ZON_SECCI ZS ");
        query.append("                            WHERE CC.PERD_OID_PERI = ");
        //CCC-05 jrivas 6/10/08
        query.append("                            (SELECT OID_PERI ");
        query.append("                                FROM (SELECT   C.OID_PERI ");
        query.append("                                           FROM CRA_PERIO C, CRA_PERIO C2 ");
        query.append("                                           WHERE C2.OID_PERI = " + periodoSolicitud + " AND C.FEC_INIC > C2.FEC_INIC ");
        query.append("                                           ORDER BY C.FEC_INIC) ");
        query.append("                              WHERE ROWNUM = 1) ");
        query.append("                              AND CC.CACT_OID_ACTI = CA.OID_ACTI ");
        query.append("                              AND CA.COD_ACTI = 'FA' ");
        query.append("                              AND CC.ZZON_OID_ZONA = ZZ.OID_ZONA ");
        query.append("                              AND MCUA.CLIE_OID_CLIE = " + oidCliente);
        query.append("                              AND MCUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
        query.append("                              AND ZTA.ZSCC_OID_SECC = ZS.OID_SECC ");
        query.append("                              AND ZS.ZZON_OID_ZONA = ZZ.OID_ZONA ");
        query.append("                              AND ZZ.IND_ACTI = 1 ");
        query.append("                              AND ZZ.IND_BORR = 0 ");
        query.append("                              AND ZZ.PAIS_OID_PAIS = " + oidPais);
        query.append("                              AND ROWNUM = 1) ");
        query.append("                        - 1 ");
        query.append("                   FROM DUAL) ");
        query.append("        ) "); 

      RecordSet rs = null;     
      try {
            rs = (RecordSet) BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch(Exception ex){
            UtilidadesLog.error(ex);
            UtilidadesLog.error("obtenerPagosDiferidos" + ex.getMessage());
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      String salida = "";
      if (rs != null && !rs.esVacio()){
            salida =  rs.getValueAt(0,"PAGOS_DIFERIDOS").toString();
      }

      UtilidadesLog.info("DAOCCC.obtenerPagosDiferidos(Long oidPais, Long oidCliente, Long oidPeriodo): Salida " + salida);       
      return salida;
    }   

}
