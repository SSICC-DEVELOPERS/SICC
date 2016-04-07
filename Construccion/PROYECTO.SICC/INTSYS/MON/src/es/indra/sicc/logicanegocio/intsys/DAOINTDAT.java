/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 * Privado y Confidencial.obtenerGerentesZonasNIVEL
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.interfaces.InterfazDef;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.intsys.DTOCambiosTerritorio;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOINTAccesos;
import es.indra.sicc.dtos.intsys.DTOINTAptaCurso;
import es.indra.sicc.dtos.intsys.DTOINTBoletasDespacho;
import es.indra.sicc.dtos.intsys.DTOINTCampaniaAnio;
import es.indra.sicc.dtos.intsys.DTOINTCliente;
import es.indra.sicc.dtos.intsys.DTOINTCobranza;
import es.indra.sicc.dtos.intsys.DTOINTCurso;
import es.indra.sicc.dtos.intsys.DTOINTDatosConsultora;
import es.indra.sicc.dtos.intsys.DTOINTEmpresa;
import es.indra.sicc.dtos.intsys.DTOINTEstatusCliente;
import es.indra.sicc.dtos.intsys.DTOINTEstatusZona;
import es.indra.sicc.dtos.intsys.DTOINTGerente;
import es.indra.sicc.dtos.intsys.DTOINTHijaDupla;
import es.indra.sicc.dtos.intsys.DTOINTInfoCampania;
import es.indra.sicc.dtos.intsys.DTOINTLider;
import es.indra.sicc.dtos.intsys.DTOINTMatrizCampania;
import es.indra.sicc.dtos.intsys.DTOINTProductoReemplazo;
import es.indra.sicc.dtos.intsys.DTOINTRegionCerrada;
import es.indra.sicc.dtos.intsys.DTOINTRegiones;
import es.indra.sicc.dtos.intsys.DTOINTSecciones;
import es.indra.sicc.dtos.intsys.DTOINTTipoOferta;
import es.indra.sicc.dtos.intsys.DTOINTTxCliente;
import es.indra.sicc.dtos.intsys.DTOINTUnidadGeografica;
import es.indra.sicc.dtos.intsys.DTOINTUnidadGeograficaCampania;
import es.indra.sicc.dtos.intsys.DTOINTZona;
import es.indra.sicc.dtos.intsys.DTOINTZonasRealesPorRegion;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTODate;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
// SPLATAS - PERFORMANCE(06/12/2006)
import es.indra.sicc.dtos.intsys.DTOINTEstatusCliente2;
import java.util.Hashtable;


import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


public class DAOINTDAT {
    private String usuario;

    public DAOINTDAT() {
    }

    public DAOINTDAT(String usuario) {
        this.usuario = usuario;
    }

    public ArrayList obtenerTiposCurso(Long pais, Long marca, Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerTiposCurso(Long pais, Long marca, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();

        consulta.append(" SELECT tc.COD_TIPO_CURS,  ");
        consulta.append("  (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  ");
        consulta.append("   WHERE idio.ATTR_ENTI = 'EDU_TIPO_CURSO' ");
        consulta.append("   AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append("   AND idio.VAL_OID = tc.OID_TIPO_CURS ) DESC_TIPO ");

        consulta.append("  FROM EDU_TIPO_CURSO tc ");
        consulta.append("  WHERE  tc.MARC_OID_MARC = ? ");
        parametros.add(marca);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerFechaDesde: Exception", e);
            this.logSql(" obtenerFechaDesde. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        //      con el RecordSet obtenido se construyen objetos DTOConsultaCurso y los retorna en una lista.
        DTOConsultaCurso dto = null;

        //UtilidadesLog.debug("\n\n rs devuelto -->" +rs);
        if (rs != null) {
            if (!rs.esVacio()) {
                int n = rs.getRowCount();

                for (int i = 0; i < n; i++) {
                    dto = new DTOConsultaCurso();

                    if (rs.getValueAt(i, "COD_TIPO_CURS") != null) {
                        dto.setCodigo(new Integer(((BigDecimal) rs.getValueAt(i, "COD_TIPO_CURS")).intValue()));
                    }

                    if (rs.getValueAt(i, "DESC_TIPO") != null) {
                        dto.setNombre((String) rs.getValueAt(i, "DESC_TIPO"));
                    }

                    array.add(dto);
                } //for
            }
        } //(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerTiposCurso(Long pais, Long marca, Long idioma): Salida");

        //UtilidadesLog.debug("***DAOINTDAT.obtenerTiposCurso  - Salida\n\n\n   array " +array);
        return array;
    }

    public ArrayList obtenerEmpresas(Long pais, Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerEmpresas(Long pais, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();
        
        // Modificado por Noziglia C. INC: 20051
        /*
        consulta.append(" SELECT tc.COD_SOCI CODIGO, ");
        consulta.append("  (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio   ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_SOCIE'  ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append(" AND idio.VAL_OID = tc.OID_SOCI ) DESCRIPCION ");

        //consulta.append(" FROM VCA_SEG_SOCIE tc  ");
        consulta.append(" FROM SEG_SOCIE tc  ");
        consulta.append(" WHERE  tc.PAIS_OID_PAIS = ?  ");
        parametros.add(pais); 
          
        //consulta.append("    AND  tc.COD_USUA = ?    ");
        //parametros.add(this.usuario);
        */

        consulta.append("SELECT tc.COD_SOCI CODIGO, ");
        consulta.append("       tc.VAL_DENO DESCRIPCION ");
        consulta.append("  FROM SEG_SOCIE tc ");
        consulta.append(" WHERE tc.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        //FIN de la modificacion Noziglia C. 22/09/2005
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerEmpresas : Exception", e);
            this.logSql(" obtenerEmpresas . SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        // - con los registros obtenidos se construyen objetos DTOINTEmpresa y se retornan en una lista
        //UtilidadesLog.debug("\n\n rs devuelto -->" +rs);
        DTOINTEmpresa dto = null;

        //UtilidadesLog.debug("\n\n rs devuelto -->" +rs);
        if (rs != null) {
            if (!rs.esVacio()) {
                int n = rs.getRowCount();

                for (int i = 0; i < n; i++) {
                    dto = new DTOINTEmpresa();

                    if (rs.getValueAt(i, "CODIGO") != null) {
                        dto.setCodigoEmpresa((String) rs.getValueAt(i, "CODIGO"));
                    }

                    if (rs.getValueAt(i, "DESCRIPCION") != null) {
                        dto.setDescripcion((String) rs.getValueAt(i, "DESCRIPCION"));
                    }

                    array.add(dto);
                } //for
            }
        } //(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerEmpresas(Long pais, Long idioma): Salida");

        //UtilidadesLog.debug("***DAOINTDAT.obtenerEmpresas   - Salida\n\n\n   array " +array);
        return array;
    }

    public java.util.Date obtenerUltimaFecha(Long pais, String codigoInterfaz) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerUltimaFecha(Long pais, String codigoInterfaz): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();

        consulta.append(" SELECT MAX( FEC_FIN_PROC )  ");
        consulta.append("  FROM INT_HISTO_LOTES ");
        consulta.append("  WHERE  PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append("  AND  COD_INTE LIKE ? ");
        parametros.add(codigoInterfaz);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerUltimaFecha: Exception", e);
            this.logSql(" obtenerUltimaFecha. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        /*
        - con el registro obtenido se construye un objeto java.util.Date y se retorna.
        - si no se obtiene ningún registro, se retorna null.
        */

        //UtilidadesLog.debug("\n\n rs devuelto -->" +rs);
        java.util.Date fecha = null;

        if (rs != null) {
            if (!rs.esVacio()) {
                if (rs.getValueAt(0, 0) != null) {
                    fecha = new java.util.Date(((java.sql.Date) rs.getValueAt(0, 0)).getTime());
                }
            }
        } //(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerUltimaFecha(Long pais, String codigoInterfaz): Salida");

        // UtilidadesLog.debug("***DAOINTDAT.obtenerUltimaFecha  - Salida\n\n\n   fecha " +fecha);
        return fecha;
    }

    /**
     * 23-07-2007    agregado por Sapaza, incidencia SiCC-20070341, se obtendra los lideres a partir 
     * de los gerentes de zona, region y seccion.
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param canal
     * @param marca
     * @param pais
     */
    public ArrayList obtenerInformacionLideres (Long pais, Long marca, Long canal) throws MareException { 
        UtilidadesLog.info("DAOINTDAT.obtenerInformacionLideres(Long pais, Long marca, Long canal): Entrada");
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector(); 
        ArrayList array=new ArrayList(); 

        consulta.append(" SELECT CLI.COD_CLIE CODIGOCONSULTORA,  ");           
        consulta.append(" SUBSTR (   TRIM(CLI.VAL_NOM1) || ' ' || TRIM(CLI.VAL_NOM2)    ");   
        consulta.append("           || ' ' || TRIM(CLI.VAL_APE1) || ' ' || TRIM(CLI.VAL_APE2), 1, 55) NOMBRELIDER, ");           
        consulta.append(" SUBSTR (   TRIM(TVIA.DES_ABRV_TIPO_VIA) || ' '  || TRIM(DIR.VAL_NOMB_VIA) "); 
        consulta.append("           || ' ' || TRIM(DIR.NUM_PPAL), 1,80) DIRECCIONLIDER, ");   
        consulta.append(" SUBSTR (NVL(FONO.VAL_TEXT_COMU,''), 1, 15) TELEFONO, ");   
        consulta.append(" SUBSTR((SELECT MIN(TO_CHAR(P.FEC_INIC,'YYYYMMDD') || PC.COD_PERI) ");   
        consulta.append("         FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");   
        consulta.append("         WHERE P.PAIS_OID_PAIS = ? ");           
        parametros.add(pais); 
        consulta.append("           AND P.MARC_OID_MARC = ? ");           
        parametros.add(marca); 
        consulta.append("           AND P.CANA_OID_CANA = ? ");           
        parametros.add(canal); 
        consulta.append("           AND P.PERI_OID_PERI = PC.OID_PERI ");  
        // enguanco- cambio 20080859 
        consulta.append("           AND P.FEC_INIC <= zhg.fec_desd ");           
        consulta.append("           AND P.FEC_FINA >= zhg.fec_desd ),9) PERIODO ");           
        
        consulta.append("  FROM  MAE_CLIEN CLI, ");                             
        consulta.append("        MAE_CLIEN_DIREC DIR, "); 
        consulta.append("        SEG_TIPO_VIA TVIA, "); 
        
        // vbongiov -- RI 20080664 DAT10 -- 26/08/2008
        consulta.append(" ( ");        
        /* 
        consulta.append("        (SELECT ZZ.CLIE_OID_CLIE ");                             
        consulta.append("         FROM ZON_ZONA ZZ  "); 
        consulta.append("         WHERE ZZ.CLIE_OID_CLIE IS NOT NULL ");   
        consulta.append("           AND ZZ.PAIS_OID_PAIS = ? ");   
        parametros.add(pais); 
        consulta.append("           AND ZZ.MARC_OID_MARC = ? ");   
        parametros.add(marca); 
        consulta.append("           AND ZZ.CANA_OID_CANA = ? ");   
        parametros.add(canal); 
        consulta.append("           AND ZZ.IND_BORR = 0 ");   
        consulta.append("         UNION ");    
        */
         // enguanco- cambio 20080859 
        consulta.append("         SELECT ZS.CLIE_OID_CLIE,  zon_sub_geren_venta.cod_subg_vent || ");           
        consulta.append("               zon_regio.COD_REGI || zz.COD_ZONA || zs.cod_secc ua    ");
        consulta.append("         FROM ZON_SECCI ZS,ZON_ZONA ZZ,  ");
        consulta.append("              zon_regio, zon_sub_geren_venta  ");
        consulta.append("         WHERE ZS.CLIE_OID_CLIE IS NOT NULL ");           
        consulta.append("           AND ZS.ZZON_OID_ZONA = ZZ.OID_ZONA ");                   
        consulta.append("           AND ZZ.PAIS_OID_PAIS = ? ");           
        parametros.add(pais); 
        consulta.append("           AND ZZ.MARC_OID_MARC = ? ");           
        parametros.add(marca); 
        consulta.append("           AND ZZ.CANA_OID_CANA = ? ");           
        parametros.add(canal); 
        consulta.append("           AND ZS.IND_BORR = 0 ");                   
        // enguanco- cambio 20080859 
        consulta.append("           AND zz.ZORG_OID_REGI = ZON_REGIO.OID_REGI    ");
        consulta.append("           AND ZON_REGIO.ZSGV_OID_SUBG_VENT = ZON_SUB_GEREN_VENTA.OID_SUBG_VENT  ");
        
        // vbongiov -- RI 20080664 DAT10 -- 26/08/2008
        /* 
        consulta.append("         UNION ");           
        consulta.append("         SELECT ZR.CLIE_OID_CLIE ");           
        consulta.append("         FROM ZON_REGIO ZR ");           
        consulta.append("         WHERE ZR.CLIE_OID_CLIE IS NOT NULL ");           
        consulta.append("           AND ZR.PAIS_OID_PAIS = ? ");           
        parametros.add(pais); 
        consulta.append("           AND ZR.MARC_OID_MARC = ? ");           
        parametros.add(marca); 
        consulta.append("           AND ZR.CANA_OID_CANA = ? ");           
        parametros.add(canal); 
        consulta.append("           AND ZR.IND_BORR = 0) LIDER, ");      
        */
        consulta.append(" ) LIDER, ");   
        
        consulta.append("           (SELECT COM1.CLIE_OID_CLIE, COM1.VAL_TEXT_COMU ");                   
        consulta.append("            FROM MAE_CLIEN_COMUN COM1, MAE_TIPO_COMUN TCOM1 ");                   
        consulta.append("            WHERE COM1.TICM_OID_TIPO_COMU = TCOM1.OID_TIPO_COMU ");                           
        consulta.append("              AND TCOM1.COD_TIPO_COMU = ?) FONO,  ");                   
        parametros.add(ConstantesMAE.TIPO_COMUNICACION_TFNO_STRING); 
        // enguanco- cambio 20080859 
        consulta.append("             ZON_HISTO_GEREN zhg  ");
        /*consulta.append("  WHERE  CLI.OID_CLIE IN ( "); 
        //cambio porincidencia V-INTDAT-10
        consulta.append("SELECT clie_oid_clie  ");
        consulta.append("  FROM v_mae_tipif_clien cli, ");
        consulta.append("       mae_tipo_clien tcli, ");
        consulta.append("       mae_tipo_clasi_clien tcla, ");
        consulta.append("       mae_clasi cla ");
        consulta.append(" WHERE cli.ticl_oid_tipo_clie = tcli.oid_tipo_clie ");
        consulta.append("   AND tcli.cod_tipo_clie = ? ");
        parametros.add(ConstantesMAE.TIPO_CLIENTE_CONSULTORA);
        consulta.append("   AND cli.tccl_oid_tipo_clasi = tcla.oid_tipo_clas ");
        consulta.append("   AND tcla.cod_tipo_clas = ? ");
        parametros.add(ConstantesMAE.COD_TIPO_CLASIFICACION_LIDER); 
        consulta.append("   AND cli.clas_oid_clas = cla.oid_clas ");
        consulta.append("   AND cla.cod_clas = ? ");
        parametros.add(ConstantesMAE.COD_CLASIFICACION_LIDER); 
        consulta.append("       )  "); */
        //fin cambio porincidencia V-INTDAT-10
        
        consulta.append(" WHERE LIDER.CLIE_OID_CLIE = CLI.OID_CLIE "); 
        // enguanco- cambio 20080859 
        consulta.append("   AND cli.COD_CLIE = zhg.GERE ");
        consulta.append("   AND zhg.UA = lider.ua ");
        consulta.append("   AND zhg.OID_HIST_GERE = (SELECT ZG.OID_HIST_GERE  ");
        consulta.append("                        from ZON_HISTO_GEREN zg ");
        consulta.append("                             where zg.GERE = cli.COD_CLIE  ");
        consulta.append("                             AND zg.UA = lider.ua  AND ZG.FEC_HAST IS NULL ");
        consulta.append("                             )  ");        
        consulta.append("   AND FONO.CLIE_OID_CLIE(+) = CLI.OID_CLIE "); 
        consulta.append("   AND DIR.CLIE_OID_CLIE(+) = CLI.OID_CLIE "); 
        consulta.append("   AND DIR.TIVI_OID_TIPO_VIA = TVIA.OID_TIPO_VIA(+) "); 
        consulta.append("   AND DIR.IND_DIRE_PPAL(+) = 1 "); 
        consulta.append("   AND DIR.IND_ELIM (+) =0 "); 
        consulta.append(" ORDER BY NOMBRELIDER "); 
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
                   UtilidadesLog.error(" obtenerInformacionLideres : Exception",e); 
            this.logSql(" obtenerInformacionLideres SQL: ",consulta.toString(),parametros); 
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
      }//catch 
     //UtilidadesLog.debug("\n\n rs devuelto -->" +rs); 

    //  - con los registros obtenidos se construyen objetos de tipo DTOINTLider y se retornan en una lista. 
     DTOINTLider dto = null; 
          
         if(rs!=null){ 
           if(!rs.esVacio()){ 
            int n=rs.getRowCount(); 
              for(int i=0;i<n;i++){ 
                dto =new DTOINTLider();     
                if(rs.getValueAt(i,"CODIGOCONSULTORA")!=null){ 
                    dto.setCodigoConsultora((String)rs.getValueAt(i,"CODIGOCONSULTORA")); 
                } 
                 if(rs.getValueAt(i,"NOMBRELIDER")!=null){ 
                    dto.setNombreLider((String)rs.getValueAt(i,"NOMBRELIDER")); 
                } 
                 if(rs.getValueAt(i,"DIRECCIONLIDER")!=null){ 
                    dto.setDireccionLider((String)rs.getValueAt(i,"DIRECCIONLIDER")); 
                } 
                 if(rs.getValueAt(i,"TELEFONO")!=null){ 
                    dto.setTelefono((String)rs.getValueAt(i,"TELEFONO")); 
                } 
                 if(rs.getValueAt(i,"PERIODO")!=null){ 
                    dto.setAnioCampaniaEsLider((String)rs.getValueAt(i,"PERIODO")); 
                } 
                array.add(dto); 
            }//for 
           } 
         }//(rs!=null) 
        UtilidadesLog.info("DAOINTDAT.obtenerInformacionLideres(Long pais, Long marca, Long canal): Salida"); 

        return array; 
    }

    /**
     * Metodo que obtiene los gerentes de zona
     * Modificado por HRCS - Fecha 11/05/2007 - Cambio Sicc20070255
     * Modificado por Sapaza - Fecha 05/06/2007 - Cambio Sicc20070291, 
     *            se deshace el cambio hecho por la incidencia Sicc20070283
     * Modificado por dmorello - 13/11/2008 - Cambio RI 20080664
     * - Se elimina parametro fecha y el filtrado por el mismo,
     *   es decir, la verificacion de novedad.
     */
     public ArrayList obtenerGerentesZonas(Long pais, Long marca, Long canal) throws MareException {
         UtilidadesLog.info("DAOINTDAT.obtenerGerentesZonas(Long pais, Long marca, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();
        
        consulta.append("SELECT DISTINCT ");
        consulta.append("  cli.cod_clie codigo_gerente_zona, ");
        consulta.append("  cli.val_nom1 ");
        consulta.append("  || ' ' ");
        consulta.append("  || cli.val_nom2 ");
        consulta.append("  || ' ' ");
        consulta.append("  || cli.val_ape1 ");
        consulta.append("  || ' ' ");
        consulta.append("  || cli.val_ape2 nombre_gerente_zona, ");
        //consulta.append("  zon.cod_zona codigo_zona_gerente , "); // cambio 20090866
        consulta.append("  ' ' AS codigo_zona_gerente, ");
        consulta.append("  tvia.des_abrv_tipo_via ");
        consulta.append("  || ' ' ");
        consulta.append("  || dir.val_nomb_via ");
        consulta.append("  || ' ' ");
        consulta.append("  || dir.num_ppal direccion_gerente, ");
        consulta.append("  (SELECT iden.num_docu_iden ");
        consulta.append("   FROM mae_clien_ident iden, mae_tipo_docum tdo ");
        consulta.append("   WHERE iden.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND iden.tdoc_oid_tipo_docu = tdo.oid_tipo_docu ");
        consulta.append("   AND tdo.cod_tipo_docu = ? ");
        parametros.add(ConstantesMAE.COD_TIPO_DOCUM_PASAPORTE);
        consulta.append("   ) numeropasaporte, ");
        consulta.append("  (SELECT nivel.des_geog ");
        consulta.append("   FROM zon_valor_estru_geopo nivel ");
        consulta.append("   WHERE nivel.orde_1 = geo.orde_1 ");
        consulta.append("   AND nivel.orde_2 IS NULL ");
        consulta.append("   AND nivel.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("   AND ROWNUM = 1) nombre_departamento_geografico, ");
        consulta.append("  CASE ");
        consulta.append("  WHEN (geo.orde_2 IS NULL) ");
        consulta.append("    THEN NULL ");
        consulta.append("  ELSE (SELECT nivel.des_geog ");
        consulta.append("        FROM zon_valor_estru_geopo nivel ");
        consulta.append("        WHERE nivel.orde_1 = geo.orde_1 ");
        consulta.append("        AND nivel.orde_2 = geo.orde_2 ");
        consulta.append("        AND nivel.orde_3 IS NULL ");
        consulta.append("        AND nivel.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("        AND ROWNUM = 1) ");
        consulta.append("  END nombre_provincia_geografica, ");
        consulta.append("  CASE ");
        consulta.append("  WHEN (geo.orde_3 IS NULL) ");
        consulta.append("    THEN NULL ");
        consulta.append("  ELSE (SELECT nivel.des_geog ");
        consulta.append("        FROM zon_valor_estru_geopo nivel ");
        consulta.append("        WHERE nivel.orde_1 = geo.orde_1 ");
        consulta.append("        AND nivel.orde_2 = geo.orde_2 ");
        consulta.append("        AND nivel.orde_3 = geo.orde_3 ");
        consulta.append("        AND nivel.orde_4 IS NULL ");
        consulta.append("        AND nivel.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("        AND ROWNUM = 1) ");
        consulta.append("  END nombre_distrito_geografico, ");
        consulta.append("  CASE ");
        consulta.append("  WHEN (geo.orde_4 IS NULL) ");
        consulta.append("    THEN NULL ");
        consulta.append("  ELSE (SELECT idio.val_i18n ");
        consulta.append("        FROM v_gen_i18n_sicc idio ");
        consulta.append("        WHERE idio.attr_enti = 'ZON_SUBES_GEOPO' ");
        consulta.append("        AND idio.idio_oid_idio = ? ");
        parametros.add(ConstantesSEG.IDIOMA_DEFECTO);
        consulta.append("        AND idio.val_oid = (SELECT nivel.sgeo_oid_sube_geop ");
        consulta.append("                            FROM zon_valor_estru_geopo nivel ");
        consulta.append("                            WHERE nivel.orde_1 = geo.orde_1 ");
        consulta.append("                            AND nivel.orde_2 = geo.orde_2 ");
        consulta.append("                            AND nivel.orde_3 = geo.orde_3 ");
        consulta.append("                            AND nivel.orde_4 = geo.orde_4 ");
        consulta.append("                            AND nivel.orde_5 IS NULL ");
        consulta.append("                            AND nivel.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("                            AND ROWNUM = 1)) ");
        consulta.append("  END desc_tipo_centro_poblado, ");
        consulta.append("  CASE ");
        consulta.append("  WHEN (geo.orde_4 IS NULL) ");
        consulta.append("    THEN NULL ");
        consulta.append("  ELSE (SELECT nivel.des_geog ");
        consulta.append("        FROM zon_valor_estru_geopo nivel ");
        consulta.append("        WHERE nivel.orde_1 = geo.orde_1 ");
        consulta.append("        AND nivel.orde_2 = geo.orde_2 ");
        consulta.append("        AND nivel.orde_3 = geo.orde_3 ");
        consulta.append("        AND nivel.orde_4 = geo.orde_4 ");
        consulta.append("        AND nivel.orde_5 IS NULL ");
        consulta.append("        AND nivel.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("        AND ROWNUM = 1) ");
        consulta.append("  END descripcion_centro_poblado, ");
        consulta.append("  (SELECT zsg.cod_sube ");
        consulta.append("   FROM zon_subes_geopo zsg ");
        consulta.append("   WHERE zsg.oid_sube_geop = (SELECT nivel.sgeo_oid_sube_geop ");
        consulta.append("                              FROM zon_valor_estru_geopo nivel ");
        consulta.append("                              WHERE nivel.orde_1 = geo.orde_1 ");
        consulta.append("                              AND nivel.orde_2 = geo.orde_2 ");
        consulta.append("                              AND nivel.orde_3 = geo.orde_3 ");
        consulta.append("                              AND nivel.orde_4 = geo.orde_4 ");
        consulta.append("                              AND nivel.orde_5 IS NULL ");
        consulta.append("                              AND nivel.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("                              AND ROWNUM = 1)) codigo_tipo_centro_poblado, ");
        consulta.append("  (SELECT nivel.orde_4 ");
        consulta.append("   FROM zon_valor_estru_geopo nivel ");
        consulta.append("   WHERE nivel.orde_1 = geo.orde_1 ");
        consulta.append("   AND nivel.orde_2 = geo.orde_2 ");
        consulta.append("   AND nivel.orde_3 = geo.orde_3 ");
        consulta.append("   AND nivel.orde_4 = geo.orde_4 ");
        consulta.append("   AND nivel.orde_5 IS NULL ");
        consulta.append("   AND nivel.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("   AND ROWNUM = 1) codigo_centro_poblado, ");
        consulta.append("  geo.orde_1 ");
        consulta.append("  || geo.orde_2 ");
        consulta.append("  || geo.orde_3 ");
        consulta.append("  || geo.orde_4 ");
        consulta.append("  || geo.orde_5 ");
        consulta.append("  || geo.orde_6 ");
        consulta.append("  || geo.orde_7 ");
        consulta.append("  || geo.orde_8 ");
        consulta.append("  || geo.orde_9 codigo_ubigeo, ");
        consulta.append("  (SELECT c.val_text_comu ");
        consulta.append("   FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("   WHERE c.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("   AND tc.cod_tipo_comu = ? ");
        parametros.add(ConstantesMAE.TIPO_COMUNICACION_TFNO_STRING);
        consulta.append("   AND ROWNUM = 1) telefono_casa, ");
        consulta.append("  (SELECT c.val_text_comu ");
        consulta.append("   FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("   WHERE c.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("   AND tc.cod_tipo_comu = ? ");
        parametros.add(ConstantesMAE.TIPO_COMUN_FAX);
        consulta.append("   AND ROWNUM = 1) numero_fax, ");
        consulta.append("  (SELECT c.val_text_comu ");
        consulta.append("   FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("   WHERE c.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("   AND tc.cod_tipo_comu = ? ");
        parametros.add(ConstantesMAE.TIPO_COMUN_TMOVIL);
        consulta.append("   AND ROWNUM = 1) numero_celular, ");
        consulta.append("  (SELECT idio.val_i18n ");
        consulta.append("   FROM v_gen_i18n_sicc idio ");
        consulta.append("   WHERE idio.attr_enti = 'MAE_ESTAD_CIVIL' ");
        consulta.append("   AND idio.idio_oid_idio = ? ");
        parametros.add(ConstantesSEG.IDIOMA_DEFECTO);
        consulta.append("   AND idio.val_oid = adi.escv_oid_esta_civi) estado_civil, ");
        consulta.append("  (SELECT tdo.cod_tipo_docu ");
        consulta.append("   FROM mae_clien_ident iden, ");
        consulta.append("   mae_tipo_docum tdo ");
        consulta.append("   WHERE iden.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND iden.val_iden_docu_prin = 1 ");
        consulta.append("   AND tdo.oid_tipo_docu = iden.tdoc_oid_tipo_docu ");
        consulta.append("   AND ROWNUM = 1) cod_tipo_documento_identidad, ");
        consulta.append("  (SELECT iden.num_docu_iden ");
        consulta.append("   FROM mae_clien_ident iden ");
        consulta.append("   WHERE iden.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND iden.val_iden_docu_prin = 1 ");
        consulta.append("   AND ROWNUM = 1) numero_documento_identidad, ");
        consulta.append("   adi.fec_naci fecha_nacimiento, ");
        consulta.append("  (SELECT c.val_text_comu ");
        consulta.append("   FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("   WHERE c.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("   AND tc.cod_tipo_comu = ? ");
        parametros.add(ConstantesMAE.TIPO_COMUN_EMAIL);
        consulta.append("   AND ROWNUM = 1) email ");
        consulta.append("FROM   mae_clien cli, ");
        consulta.append("  mae_clien_unida_admin adm, ");
        consulta.append("  mae_clien_ident ide, ");
        consulta.append("  mae_clien_datos_adici adi, ");
        consulta.append("  mae_clien_direc dir, ");
        consulta.append("  zon_zona zon, ");
        consulta.append("  zon_terri_admin tad, ");
        consulta.append("  zon_valor_estru_geopo geo, ");
        consulta.append("  zon_terri ter, ");
        consulta.append("  seg_tipo_via tvia, ");
        consulta.append("  mae_clien_comun com ");
        consulta.append("WHERE zon.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append("  AND zon.marc_oid_marc = ? ");
        parametros.add(marca);
        consulta.append("  AND zon.cana_oid_cana = ? ");
        parametros.add(canal);        
        
        //modificado por Sapaza, fecha 21-08-2007, incidencia SiCC-20070391 (Manuel)
        consulta.append("  AND zon.ind_borr = 0 ");
        consulta.append("  AND zon.ind_acti = 1 ");
        consulta.append("  AND adm.ind_acti = 1 ");
        consulta.append("  AND ter.ind_borr = 0 ");
        
        consulta.append("  AND zon.clie_oid_clie = cli.oid_clie ");
        consulta.append("  AND cli.oid_clie = ide.clie_oid_clie ");
        consulta.append("  AND adi.clie_oid_clie(+) = cli.oid_clie ");
        consulta.append("  AND adm.clie_oid_clie(+) = cli.oid_clie ");
        consulta.append("  AND adm.ztad_oid_terr_admi = tad.oid_terr_admi(+) ");
        consulta.append("  AND tad.terr_oid_terr = ter.oid_terr(+) ");
        consulta.append("  AND ter.vepo_oid_valo_estr_geop = geo.oid_valo_estr_geop ");
        consulta.append("  AND tad.ind_borr = 0 ");
        consulta.append("  AND cli.oid_clie = com.clie_oid_clie(+) ");
        consulta.append("  AND dir.clie_oid_clie = cli.oid_clie ");
        consulta.append("  AND dir.ind_dire_ppal = 1 ");
        consulta.append("  AND dir.ind_elim = 0 ");
        consulta.append("  AND dir.tivi_oid_tipo_via = tvia.oid_tipo_via ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerGerentesZonas : Exception", e);
            this.logSql(" obtenerGerentesZonas SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        // - con los registros obtenidos se construyen objetos de tipo DTOINTGerente y se retorna en una lista.
        DTOINTGerente dto = null;

        if (rs != null) {
            if (!rs.esVacio()) {
                int n = rs.getRowCount();

                for (int i = 0; i < n; i++) {
                    dto = new DTOINTGerente();

                    if (rs.getValueAt(i, "CODIGO_GERENTE_ZONA") != null) {
                        dto.setCodigoGerente((String) rs.getValueAt(i, "CODIGO_GERENTE_ZONA"));
                    }

                    if (rs.getValueAt(i, "NOMBRE_GERENTE_ZONA") != null) {
                        dto.setNombreGerente((String) rs.getValueAt(i, "NOMBRE_GERENTE_ZONA"));
                    }

                    if (rs.getValueAt(i, "CODIGO_ZONA_GERENTE") != null) {
                        dto.setCodigoZonaGerente((String) rs.getValueAt(i, "CODIGO_ZONA_GERENTE"));
                    }                    
                    
                    if (rs.getValueAt(i, "NOMBRE_DEPARTAMENTO_GEOGRAFICO") != null) {
                        dto.setNombreDepartamentoGeografico((String) rs.getValueAt(i, "NOMBRE_DEPARTAMENTO_GEOGRAFICO"));
                    }
                    
                    if (rs.getValueAt(i, "NOMBRE_PROVINCIA_GEOGRAFICA") != null) {
                        dto.setNombreProvinciaGeografica((String) rs.getValueAt(i, "NOMBRE_PROVINCIA_GEOGRAFICA"));
                    }
                    
                    if (rs.getValueAt(i, "NOMBRE_DISTRITO_GEOGRAFICO") != null) {
                        dto.setNombreDistritoGeografico((String) rs.getValueAt(i, "NOMBRE_DISTRITO_GEOGRAFICO"));
                    }
                    
                    if (rs.getValueAt(i, "DESC_TIPO_CENTRO_POBLADO") != null) {
                        dto.setDescripcionTipoCentroPoblado((String) rs.getValueAt(i, "DESC_TIPO_CENTRO_POBLADO"));
                    }
                    
                    if (rs.getValueAt(i, "DESCRIPCION_CENTRO_POBLADO") != null) {
                        dto.setDescripcionCentroPoblado((String) rs.getValueAt(i, "DESCRIPCION_CENTRO_POBLADO"));
                    }
                    
                    if (rs.getValueAt(i, "CODIGO_TIPO_CENTRO_POBLADO") != null) {
                        dto.setCodigoTipoCentroPoblado(((BigDecimal) rs.getValueAt(i, "CODIGO_TIPO_CENTRO_POBLADO")).toString());
                    }
                    
                    if (rs.getValueAt(i, "CODIGO_CENTRO_POBLADO") != null) {
                        dto.setCodigoCentroPoblado((String) rs.getValueAt(i, "CODIGO_CENTRO_POBLADO"));
                    }
                    if (rs.getValueAt(i, "CODIGO_UBIGEO") != null) {
                        dto.setCodigoUbigeo((String) rs.getValueAt(i, "CODIGO_UBIGEO"));
                    }

                    if (rs.getValueAt(i, "DIRECCION_GERENTE") != null) {
                        dto.setDireccionGerente((String) rs.getValueAt(i, "DIRECCION_GERENTE"));
                    }

                    if (rs.getValueAt(i, "TELEFONO_CASA") != null) {
                        dto.setTelefonoDomicilio((String) rs.getValueAt(i, "TELEFONO_CASA"));
                    }

                    if (rs.getValueAt(i, "NUMERO_FAX") != null) {
                        dto.setFaxDomicilio((String) rs.getValueAt(i, "NUMERO_FAX"));
                    }

                    if (rs.getValueAt(i, "NUMERO_CELULAR") != null) {
                        dto.setNumeroTelefonoCelular((String) rs.getValueAt(i, "NUMERO_CELULAR"));
                    }

                    if (rs.getValueAt(i, "ESTADO_CIVIL") != null) {
                        dto.setEstadoCivil((String) rs.getValueAt(i, "ESTADO_CIVIL"));
                    }

                    if (rs.getValueAt(i, "COD_TIPO_DOCUMENTO_IDENTIDAD") != null) {
                        dto.setTipoDocumentoIdentidad((String) rs.getValueAt(i, "COD_TIPO_DOCUMENTO_IDENTIDAD"));
                    }

                    if (rs.getValueAt(i, "NUMERO_DOCUMENTO_IDENTIDAD") != null) {
                        dto.setNumeroDocumentoIdentidad((String) rs.getValueAt(i, "NUMERO_DOCUMENTO_IDENTIDAD"));
                    }

                    if (rs.getValueAt(i, "FECHA_NACIMIENTO") != null) {
                        dto.setFechaNacimiento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHA_NACIMIENTO")).getTime()));
                    }

                    if (rs.getValueAt(i, "EMAIL") != null) {
                        dto.setEmail((String) rs.getValueAt(i, "EMAIL"));
                    }
     
                    if (rs.getValueAt(i, "NUMEROPASAPORTE") != null) {
                        dto.setNumPasaporte((String) rs.getValueAt(i, "NUMEROPASAPORTE"));
                    }
                    array.add(dto);
                } //for
            }
        } //(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerGerentesZonas(Long pais, Long marca, Long canal): Salida");

        return array;
    }

    /**
     * Metodo que obtiene los gerentes regionales
     * Modificado por HRCS - Fecha 11/05/2007 - Cambio Sicc20070255
     * Modificado por dmorello - Cambio RI 20080664 - 13/11/2008
     * - Se elimina parametro fecha y verificacion de novedad a partir del mismo
     */
     public ArrayList obtenerGerentesRegionales(Long pais, Long marca, Long canal) throws MareException {
         UtilidadesLog.info("DAOINTDAT.obtenerGerentesRegionales(Long pais, Long marca, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();
        
        consulta.append(" SELECT DISTINCT ");
        consulta.append("   cli.cod_clie codigo, ");
        consulta.append("   cli.val_nom1 nombre1, ");
        consulta.append("   cli.val_nom2 nombre2, ");
        consulta.append("   cli.val_ape1 apellido1, ");
        consulta.append("   cli.val_ape2 apellido2, ");
        consulta.append("   cli2.cod_clie codconsultora, ");
        //consulta.append("   reg.cod_regi codregion, ");
        consulta.append("   ' ' AS codregion, ");
        consulta.append("   orden1.des_geog departamento, ");
        consulta.append("   orden2.des_geog provincia, ");
        consulta.append("   orden3.des_geog distrito, ");
        consulta.append("   (SELECT idio.val_i18n ");
        consulta.append("    FROM v_gen_i18n_sicc idio ");
        consulta.append("    WHERE idio.attr_enti = 'ZON_NIVEL_GEOGR' ");
        consulta.append("    AND idio.idio_oid_idio = ? ");
        parametros.add(ConstantesSEG.IDIOMA_DEFECTO);
        consulta.append("    AND idio.val_oid = tipo_poblado.oid_divi_poli) descripciontipocentro, ");
        consulta.append("   orden4.des_geog descripcioncentro, ");
        consulta.append("   cod_tipo_poblado.cod_sube codigotipocentro, ");
        consulta.append("   orden4.orde_4 codigocentro, ");
        consulta.append("   cli.val_nom1 ");
        consulta.append("    || ' ' ");
        consulta.append("    || cli.val_nom2 ");
        consulta.append("    || ' ' ");
        consulta.append("    || cli.val_ape1 ");
        consulta.append("    || ' ' ");
        consulta.append("    || cli.val_ape2 nombre, ");
        consulta.append("   geo.orde_1 ");
        consulta.append("    || geo.orde_2 ");
        consulta.append("    || geo.orde_3 ");
        consulta.append("    || geo.orde_4 ");
        consulta.append("    || geo.orde_5 ");
        consulta.append("    || geo.orde_6 ");
        consulta.append("    || geo.orde_7 ");
        consulta.append("    || geo.orde_8 ");
        consulta.append("    || geo.orde_9 ubigeo, ");
        consulta.append("   tvia.des_abrv_tipo_via ");
        consulta.append("    || ' ' ");
        consulta.append("    || dir.val_nomb_via ");
        consulta.append("    || ' ' ");
        consulta.append("    || dir.num_ppal direccion, ");
        consulta.append("   (SELECT idio.val_i18n ");
        consulta.append("    FROM v_gen_i18n_sicc idio ");
        consulta.append("    WHERE idio.attr_enti = 'MAE_ESTAD_CIVIL' ");
        consulta.append("    AND idio.idio_oid_idio = ? ");
        parametros.add(ConstantesSEG.IDIOMA_DEFECTO);
        consulta.append("    AND idio.val_oid = civ.oid_esta_civi) estadocivil, ");
        consulta.append("   tdoc.cod_tipo_docu tipodoc, ");
        consulta.append("   ide.num_docu_iden numdoc, ");
        consulta.append("   adi.fec_naci fecha, ");
        consulta.append("   CASE ");
        consulta.append("    WHEN (tdoc1.cod_tipo_docu <> ? OR tdoc1.cod_tipo_docu IS NULL ) ");
        parametros.add(ConstantesMAE.COD_TIPO_DOCUM_PASAPORTE);
        consulta.append("    THEN NULL ");
        consulta.append("    ELSE cliden.num_docu_iden ");
        consulta.append("    END pasaporte, ");
        consulta.append("   (SELECT c.val_text_comu ");
        consulta.append("    FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("    WHERE c.clie_oid_clie = cli.oid_clie ");
		consulta.append("    AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("    AND cod_tipo_comu = ?) telefono, ");
        parametros.add(ConstantesMAE.CODIGO_TIPO_COMUNICACION_TFNO);
        consulta.append("   (SELECT c.val_text_comu ");
        consulta.append("    FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("    WHERE c.clie_oid_clie = cli.oid_clie ");
		consulta.append("    AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("    AND cod_tipo_comu = ?) email, ");
        parametros.add(ConstantesMAE.CODIGO_TIPO_COMUNICACION_EMAIL);
        consulta.append("   (SELECT c.val_text_comu ");
        consulta.append("    FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("    WHERE c.clie_oid_clie = cli.oid_clie ");
		consulta.append("    AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("    AND cod_tipo_comu = ?) movil, ");
        parametros.add(ConstantesMAE.TIPO_COMUN_TMOVIL);
        consulta.append("   (SELECT c.val_text_comu ");
        consulta.append("    FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append("    WHERE c.clie_oid_clie = cli.oid_clie ");
		consulta.append("    AND c.ticm_oid_tipo_comu = tc.oid_tipo_comu ");
        consulta.append("    AND cod_tipo_comu = ?) fax ");
        parametros.add(ConstantesMAE.CODIGO_TIPO_COMUNICACION_FAX);
        consulta.append(" FROM zon_regio reg, ");
        consulta.append("      mae_clien cli, ");
        consulta.append("      mae_clien cli2, ");
        consulta.append("      mae_clien_unida_admin adm, ");
        consulta.append("      mae_clien_datos_adici adi, ");
        consulta.append("      mae_estad_civil civ, ");
        consulta.append("      mae_clien_ident ide, ");
        consulta.append("      mae_tipo_docum tdoc, ");
        consulta.append("      mae_clien_direc dir, ");
        consulta.append("      zon_valor_estru_geopo geo, ");
        consulta.append("      zon_terri_admin tad, ");
        consulta.append("      zon_terri terr, ");
        consulta.append("      zon_secci secc, ");
        consulta.append("      zon_zona zon, ");
        consulta.append("      seg_tipo_via tvia, ");
        consulta.append("      mae_clien_ident cliden, ");
        consulta.append("      mae_tipo_docum tdoc1, ");
        consulta.append("      zon_valor_estru_geopo orden1, ");
        consulta.append("      zon_valor_estru_geopo orden2, ");
        consulta.append("      zon_valor_estru_geopo orden3, ");
        consulta.append("      zon_valor_estru_geopo orden4, ");
        consulta.append("      zon_estru_geopo estru, ");
        consulta.append("      zon_nivel_geogr tipo_poblado, ");
        consulta.append("      zon_subes_geopo cod_tipo_poblado, ");
	    consulta.append("      mae_clien_comun com ");
        consulta.append(" WHERE reg.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND cli.oid_clie = cli2.oid_clie ");
        consulta.append("   AND adm.clie_oid_clie = cli2.oid_clie ");
        consulta.append("   AND adm.ztad_oid_terr_admi = tad.oid_terr_admi ");
        consulta.append("   AND tad.terr_oid_terr = terr.oid_terr ");
        consulta.append("   AND tad.zscc_oid_secc = secc.oid_secc ");
        consulta.append("   AND secc.zzon_oid_zona = zon.oid_zona ");
        consulta.append("   AND terr.vepo_oid_valo_estr_geop = geo.oid_valo_estr_geop ");
        consulta.append("   AND adi.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND adi.escv_oid_esta_civi = civ.oid_esta_civi(+) ");
        consulta.append("   AND ide.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND ide.tdoc_oid_tipo_docu = tdoc.oid_tipo_docu ");
        consulta.append("   AND dir.clie_oid_clie(+) = cli.oid_clie ");
        consulta.append("   AND dir.ind_dire_ppal = 1 ");
        consulta.append("   AND dir.tivi_oid_tipo_via = tvia.oid_tipo_via ");
        consulta.append("   AND dir.ind_elim = 0 ");
        consulta.append("   AND reg.ind_acti = 1 ");
        consulta.append("   AND reg.ind_borr = 0 ");
        consulta.append("   AND adm.ind_acti = 1 ");
        
        //modificado por Sapaza, fecha 21-08-2007, incidencia SiCC-20070391 (Manuel)
        consulta.append("  AND zon.ind_borr = 0 ");
        consulta.append("  AND zon.ind_acti = 1 ");
        consulta.append("  AND terr.ind_borr = 0 ");
        consulta.append("  AND secc.ind_borr = 0 ");
        consulta.append("  AND secc.ind_acti = 1 ");
        
        consulta.append("   AND cli.oid_clie = com.clie_oid_clie(+) ");
        consulta.append(" AND reg.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append(" AND reg.marc_oid_marc = ? ");
        parametros.add(marca);
        consulta.append(" AND reg.cana_oid_cana = ? ");
        parametros.add(canal);
        consulta.append("   AND cliden.clie_oid_clie(+) = cli.oid_clie ");
        consulta.append("   AND cliden.tdoc_oid_tipo_docu = tdoc1.oid_tipo_docu ");
        consulta.append("   AND orden1.orde_1(+) = geo.orde_1 ");
        consulta.append("   AND orden1.orde_2 IS NULL ");
        consulta.append("   AND orden1.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("   AND orden2.orde_1(+) = geo.orde_1 ");
        consulta.append("   AND orden2.orde_2(+) = geo.orde_2 ");
        consulta.append("   AND orden2.orde_3 IS NULL ");
        consulta.append("   AND orden2.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("   AND orden3.orde_1(+) = geo.orde_1 ");
        consulta.append("   AND orden3.orde_2(+) = geo.orde_2 ");
        consulta.append("   AND orden3.orde_3(+) = geo.orde_3 ");
        consulta.append("   AND orden3.orde_4 IS NULL ");
        consulta.append("   AND orden3.pais_oid_pais = geo.pais_oid_pais ");
        consulta.append("   AND orden4.orde_1(+) = geo.orde_1 ");
        consulta.append("   AND orden4.orde_2(+) = geo.orde_2 ");
        consulta.append("   AND orden4.orde_3(+) = geo.orde_3 ");
        consulta.append("   AND orden4.orde_4(+) = geo.orde_4 ");
        consulta.append("   AND orden4.orde_5 IS NULL ");
        consulta.append("   AND orden4.pais_oid_pais(+) = geo.pais_oid_pais ");
        consulta.append("   AND estru.oid_estr_geop(+) = orden4.egeo_oid_estr_geop ");
        consulta.append("   AND cod_tipo_poblado.oid_sube_geop(+) = orden4.sgeo_oid_sube_geop ");
        consulta.append("   AND tipo_poblado.oid_divi_poli(+) = estru.dipo_oid_divi_poli ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerGerentesRegionales  : Exception", e);
            this.logSql(" obtenerGerentesRegionales  SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        //UtilidadesLog.debug("\n\n rs devuelto -->" +rs);
        // - con los registros obtenidos se construyen objetos de tipo DTOINTGerente y se retornan en una lista
        DTOINTGerente dto = null;

        if (rs != null) {
            if (!rs.esVacio()) {
                int n = rs.getRowCount();

                for (int i = 0; i < n; i++) {
                    dto = new DTOINTGerente();

                    if (rs.getValueAt(i, "CODIGO") != null) {
                        dto.setCodigoGerente((String) rs.getValueAt(i, "CODIGO"));
                    }

                    if (rs.getValueAt(i, "CODCONSULTORA") != null) {
                        dto.setCodigoGerenteComoConsultora((String) rs.getValueAt(i, "CODCONSULTORA"));
                    }

                    if (rs.getValueAt(i, "NOMBRE") != null) {
                        dto.setNombreGerente((String) rs.getValueAt(i, "NOMBRE"));
                    }

                    if (rs.getValueAt(i, "CODREGION") != null) {
                        dto.setCodigoRegionGerente((String) rs.getValueAt(i, "CODREGION"));
                    }

                    if (rs.getValueAt(i, "UBIGEO") != null) {
                        dto.setCodigoUbigeo((String) rs.getValueAt(i, "UBIGEO"));
                    }

                    if (rs.getValueAt(i, "DIRECCION") != null) {
                        dto.setDireccionGerente((String) rs.getValueAt(i, "DIRECCION"));
                    }

                    if (rs.getValueAt(i, "TELEFONO") != null) {
                        dto.setTelefonoDomicilio((String) rs.getValueAt(i, "TELEFONO"));
                    }

                    if (rs.getValueAt(i, "FAX") != null) {
                        dto.setFaxDomicilio((String) rs.getValueAt(i, "FAX"));
                    }

                    if (rs.getValueAt(i, "MOVIL") != null) {
                        dto.setNumeroTelefonoCelular((String) rs.getValueAt(i, "MOVIL"));
                    }

                    if (rs.getValueAt(i, "ESTADOCIVIL") != null) {
                        dto.setEstadoCivil((String) rs.getValueAt(i, "ESTADOCIVIL"));
                    }

                    if (rs.getValueAt(i, "TIPODOC") != null) {
                        dto.setTipoDocumentoIdentidad((String) rs.getValueAt(i, "TIPODOC"));
                    }

                    if (rs.getValueAt(i, "NUMDOC") != null) {
                        dto.setNumeroDocumentoIdentidad((String) rs.getValueAt(i, "NUMDOC"));
                    }

                    if (rs.getValueAt(i, "FECHA") != null) {
                        dto.setFechaNacimiento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHA")).getTime()));
                    }

                    if (rs.getValueAt(i, "EMAIL") != null) {
                        dto.setEmail((String) rs.getValueAt(i, "EMAIL"));
                    }

                    //BELC300018338
                    if (rs.getValueAt(i, "PASAPORTE") != null) {
                        dto.setNumPasaporte((String) rs.getValueAt(i, "PASAPORTE"));
                    }

                    //BELC300018551
                    if (rs.getValueAt(i, "DEPARTAMENTO") != null) {
                        dto.setNombreDepartamentoGeografico((String) rs.getValueAt(i, "DEPARTAMENTO"));
                    }

                    if (rs.getValueAt(i, "PROVINCIA") != null) {
                        dto.setNombreProvinciaGeografica((String) rs.getValueAt(i, "PROVINCIA"));
                    }

                    if (rs.getValueAt(i, "DISTRITO") != null) {
                        dto.setNombreDistritoGeografico((String) rs.getValueAt(i, "DISTRITO"));
                    }

                    if (rs.getValueAt(i, "DESCRIPCIONTIPOCENTRO") != null) {
                        dto.setDescripcionTipoCentroPoblado((String) rs.getValueAt(i, "DESCRIPCIONTIPOCENTRO"));
                    }

                    if (rs.getValueAt(i, "DESCRIPCIONCENTRO") != null) {
                        dto.setDescripcionCentroPoblado((String) rs.getValueAt(i, "DESCRIPCIONCENTRO"));
                    }

                    if (rs.getValueAt(i, "CODIGOTIPOCENTRO") != null) {
                        dto.setCodigoTipoCentroPoblado(((BigDecimal) rs.getValueAt(i, "CODIGOTIPOCENTRO")).toString());
                    }

                    if (rs.getValueAt(i, "CODIGOCENTRO") != null) {
                        dto.setCodigoCentroPoblado((String) rs.getValueAt(i, "CODIGOCENTRO"));
                    }

                    array.add(dto);
                } //for
            }
        } //(rs!=null)

         UtilidadesLog.info("DAOINTDAT.obtenerGerentesRegionales(Long pais, Long marca, Long canal): Salida");

        return array;
    }

    public void obtenerTablaClientes(Long pais, Long marca, Long canal, java.util.Date fecha, Long idioma, String pathArchivo, String nombreArchivo, InterfazInfo interfaz) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerTablaClientes(Long pais, Long marca, Long canal, java.util.Date fecha, Long idioma, String pathArchivo, String nombreArchivo, InterfazInfo interfaz): Entrada");
        StringBuffer consulta = new StringBuffer();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ultimaFechaProceso =null;
        
        UtilidadesLog.debug("pathArchivo: " + pathArchivo);
        UtilidadesLog.debug("nombreArchivo: " + nombreArchivo);
        
        if(fecha != null){
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            ultimaFechaProceso = sdf.format(fechaSQL);
        }    
        
        consulta.append("SELECT DISTINCT  cli.oid_clie oidconsultora, dir.val_nomb_via, tvia.cod_tipo_via,");
        consulta.append(" cli.cod_clie codigoconsultora, terr.cod_terr codifoterritorio, ");
        consulta.append(" cli.val_nom1 nombre1, cli.val_nom2 nombre2, ");
        consulta.append(" cli.val_ape1 apellidopaterno, cli.val_ape2 apellidomaterno, ");
        consulta.append(" tnse.cod_nsep nse, ");
        // vbongiov --  Sicc 20080664 - DAT2 -- 27/08/2008
        // vbongiov --  Cambio 20090928 -- 12/08/2009
        consulta.append(" CASE WHEN ((EXISTS (SELECT 1 FROM mae_clien_prime_conta mp WHERE mp.clie_oid_clie = cli.oid_clie )) ");
        consulta.append(" AND  ((SELECT mp.PERD_OID_PERI FROM mae_clien_prime_conta mp WHERE mp.clie_oid_clie = cli.oid_clie ) IS NOT NULL))  ");
        consulta.append(" THEN (SELECT pcor.cod_peri FROM seg_perio_corpo pcor, cra_perio per WHERE pcor.oid_peri = per.peri_oid_peri  ");
        consulta.append(" AND per.oid_peri = (SELECT MIN (perd_oid_peri) FROM mae_clien_prime_conta mp WHERE mp.clie_oid_clie = cli.oid_clie)) ");
        consulta.append(" ELSE CASE WHEN EXISTS ( SELECT 1 FROM mae_clien_histo_estat mh WHERE mh.clie_oid_clie = cli.oid_clie) ");
        consulta.append(" THEN (Select pcor.cod_peri from seg_perio_corpo pcor, cra_perio per where pcor.oid_peri = per.peri_oid_peri  ");
        consulta.append(" AND per.oid_peri = (SELECT MIN (perd_oid_peri) FROM mae_clien_histo_estat mh WHERE mh.clie_oid_clie = cli.oid_clie)) ELSE ' ' END END AS anicampaniaingreso, ");
     
        consulta.append(" adi.fec_naci fechanacimineto, ");
        consulta.append(" pq_apl_aux.valor_gen_i18n_sicc ("+idioma.toString()+", civ.oid_esta_civi, 'MAE_ESTAD_CIVIL') AS estadocivil, ");
        consulta.append(" (SELECT obtener_ultima_fecha_fact(cli.oid_clie, "+pais.toString()+") FROM DUAL) AS aniocapanaultimopedido,");
        consulta.append(" obtener_indicadores (cli.oid_clie, 1) indicadorestrella, ");
        // Comentado por Cambio Sicc20070293
        //consulta.append(" CASE WHEN (EXISTS (SELECT * FROM edu_histo_curso h WHERE cli.oid_clie = h.clie_oid_clie))");
        //consulta.append(" THEN (SELECT t.cod_tipo_curs FROM edu_histo_curso h, edu_matri_curso m, edu_tipo_curso t ");
        //consulta.append(" WHERE cli.oid_clie = h.clie_oid_clie AND h.mcur_oid_curs = m.oid_curs ");
        //consulta.append(" AND m.ticu_oid_tipo_curs = t.oid_tipo_curs AND m.fec_lanz = ");
        //consulta.append(" (SELECT MAX (fec_lanz) FROM edu_matri_curso m1, edu_histo_curso h1 ");
        //consulta.append(" WHERE m1.oid_curs = h1.mcur_oid_curs AND h1.clie_oid_clie = cli.oid_clie)) ");
        //consulta.append(" ELSE NULL ");
        //consulta.append(" END AS codigoultimocursorecibido, ");
        //  Agregado por HRCS - Fecha 05/06/2007 - Cambio Sicc20070293
        consulta.append(" pq_apl_int.func_obten_tipo_curso_clien(cli.oid_clie) AS codigoultimocursorecibido, ");
        consulta.append(" tdoc.cod_tipo_docu tipodocumentoidentidad, ");
        consulta.append(" ide.num_docu_iden numerodocumentoidentidad, ");
        consulta.append(" NVL (ecdat.ind_activ, 0) AS indicadoractiva, ");
        consulta.append(" case when (est.COD_ESTA_CLIE = '"+ConstantesMAE.ESTATUS_EGRESADA+"' ");
        consulta.append(" and adi.NUM_CAMP_SIN_PEDI > "+ConstantesINT.NRO_CAMP_SIN_PEDI+")  then ");
	    consulta.append(" pq_apl_aux.valor_gen_i18n_sicc("+idioma.toString()+",(select est2.oid_esta_clie from mae_estat_clien est2 ");
        consulta.append(" where cod_esta_clie = '"+ConstantesMAE.ESTATUS_RETIRADO+"'), ");
        // gPineda - 07/03/2007 - Cambios INT-DATPRD11
        //consulta.append(" 'MAE_ESTAT_CLIEN') else pq_apl_aux.valor_gen_i18n_sicc("+idioma.toString()+", est.oid_esta_clie,'MAE_ESTAT_CLIEN') end  AS estatusventavigente, ");
        consulta.append(" 'MAE_ESTAT_CLIEN') ELSE CASE WHEN ( est.cod_esta_clie = '"+ ConstantesMAE.ESTATUS_REACTIVADO +"' ) THEN ");
        consulta.append(" pq_apl_aux.valor_gen_i18n_sicc ("+ idioma.toString() +", "+ ConstantesMAE.OID_ESTATUS_NUEVA +" , 'MAE_ESTAT_CLIEN' ) ELSE ");
        consulta.append(" pq_apl_aux.valor_gen_i18n_sicc("+idioma.toString()+", est.oid_esta_clie,'MAE_ESTAT_CLIEN') end  END AS estatusventavigente, ");
        consulta.append(" CASE WHEN EXISTS (SELECT * FROM mae_clien_comun c, mae_tipo_comun tc ");
        consulta.append(" WHERE c.ticm_oid_tipo_comu = tc.oid_tipo_comu AND c.clie_oid_clie = cli.oid_clie ");
        consulta.append(" AND cod_tipo_comu = '"+ConstantesMAE.TIPO_COMUNICACION_TFNO_STRING+"') THEN (SELECT c.val_text_comu FROM ");
        consulta.append(" mae_clien_comun c, mae_tipo_comun tc WHERE c.ticm_oid_tipo_comu = ");
        consulta.append(" tc.oid_tipo_comu AND c.clie_oid_clie = cli.oid_clie ");
        consulta.append(" AND cod_tipo_comu = '"+ConstantesMAE.TIPO_COMUNICACION_TFNO_STRING+"') ELSE NULL END AS telefono, ");
        consulta.append(" CASE WHEN EXISTS (SELECT * FROM mae_clien_comun c WHERE c.ticm_oid_tipo_comu = "+ConstantesMAE.TIPO_COMUNICACION_TFNO_TRABAJO+" ");
        consulta.append(" AND c.clie_oid_clie = cli.oid_clie) ");
        consulta.append(" THEN (SELECT val_text_comu FROM mae_clien_comun c WHERE c.ticm_oid_tipo_comu = "+ConstantesMAE.TIPO_COMUNICACION_TFNO_TRABAJO+" ");
        consulta.append(" AND c.clie_oid_clie = cli.oid_clie) ELSE NULL  END AS telefonotrabajo, ");
        consulta.append(" SUBSTR(tvia.des_abrv_tipo_via|| ' '|| (CASE WHEN dir.val_nomb_via IS NOT NULL ");
        consulta.append(" THEN dir.val_nomb_via WHEN (    (dir.val_nomb_via IS NULL) ");
        consulta.append(" AND (dir.tivi_oid_tipo_via IS NOT NULL)) ");
        consulta.append(" THEN (SELECT nom_via FROM zon_via z ");
        consulta.append(" WHERE z.pais_oid_pais = "+pais.toString()+"  AND z.oid_via = dir.zvia_oid_via) ");
        consulta.append(" WHEN (    (dir.val_nomb_via IS NULL) AND (dir.tivi_oid_tipo_via IS NULL)) ");
        consulta.append(" THEN '' END)|| ' '|| RTRIM (LTRIM (num_ppal))|| ' '|| RTRIM (LTRIM (val_inte)) ");
        consulta.append(" || ' '|| RTRIM (LTRIM (val_obse)),0,80) direccion, ");
        consulta.append(" (SELECT nivel.des_geog  FROM zon_valor_estru_geopo nivel ");
        consulta.append(" WHERE nivel.orde_1 = egeop.orde_1 AND nivel.orde_2 IS NULL ");
        consulta.append(" AND nivel.pais_oid_pais = egeop.pais_oid_pais AND ROWNUM = 1) nombredepartamento, ");
        consulta.append(" CASE  WHEN (egeop.orde_2 IS NULL) THEN NULL  ELSE (SELECT nivel.des_geog ");
        consulta.append(" FROM zon_valor_estru_geopo nivel WHERE nivel.orde_1 = egeop.orde_1 ");
        consulta.append(" AND nivel.orde_2 = egeop.orde_2 AND nivel.orde_3 IS NULL ");
        consulta.append(" AND nivel.pais_oid_pais = egeop.pais_oid_pais AND ROWNUM = 1) END provincia, ");
        consulta.append(" CASE  WHEN (egeop.orde_3 IS NULL) THEN NULL ELSE (SELECT nivel.des_geog ");
        consulta.append(" FROM zon_valor_estru_geopo nivel WHERE nivel.orde_1 = egeop.orde_1 ");
        consulta.append(" AND nivel.orde_2 = egeop.orde_2  AND nivel.orde_3 = egeop.orde_3 AND nivel.orde_4 IS NULL ");
        consulta.append(" AND nivel.pais_oid_pais = egeop.pais_oid_pais  AND ROWNUM = 1) END distrito, ");
        consulta.append(" CASE  WHEN (egeop.orde_4 IS NULL) THEN NULL ELSE (SELECT pq_apl_aux.valor_gen_i18n_sicc ");
        consulta.append(" ("+idioma.toString()+", (SELECT nivel.sgeo_oid_sube_geop FROM zon_valor_estru_geopo nivel ");
        consulta.append(" WHERE nivel.orde_1 = egeop.orde_1  AND nivel.orde_2 = egeop.orde_2 ");
        consulta.append(" AND nivel.orde_3 = egeop.orde_3 AND nivel.orde_4 = egeop.orde_4 ");
        consulta.append(" AND nivel.orde_5 IS NULL AND nivel.pais_oid_pais = egeop.pais_oid_pais ");
        consulta.append(" AND ROWNUM = 1),  'ZON_SUBES_GEOPO' ) FROM DUAL) ");
        consulta.append(" END descripciontipocentropoblado, ");
        consulta.append(" CASE WHEN (egeop.orde_4 IS NULL) THEN NULL ELSE (SELECT nivel.des_geog ");
        consulta.append(" FROM zon_valor_estru_geopo nivel WHERE nivel.orde_1 = egeop.orde_1 ");
        consulta.append(" AND nivel.orde_2 = egeop.orde_2 AND nivel.orde_3 = egeop.orde_3 ");
        consulta.append(" AND nivel.orde_4 = egeop.orde_4 AND nivel.orde_5 IS NULL ");
        consulta.append(" AND nivel.pais_oid_pais = egeop.pais_oid_pais AND ROWNUM = 1) ");
        consulta.append(" END descripcioncentropoblado, ");
        consulta.append(" lider.val_nom1 nombre1lider, lider.val_nom2 nombre2lider, ");
        consulta.append(" lider.val_ape1 apellido1lider, lider.val_ape2 apellido2lider, ");
        consulta.append(" (SELECT zsg.cod_sube FROM zon_subes_geopo zsg WHERE zsg.oid_sube_geop = ");
        consulta.append(" (SELECT nivel.sgeo_oid_sube_geop FROM zon_valor_estru_geopo nivel ");
        consulta.append(" WHERE nivel.orde_1 = egeop.orde_1 AND nivel.orde_2 = egeop.orde_2 ");
        consulta.append(" AND nivel.orde_3 = egeop.orde_3 AND nivel.orde_4 = egeop.orde_4 ");
        consulta.append(" AND nivel.orde_5 IS NULL AND nivel.pais_oid_pais = egeop.pais_oid_pais ");
        consulta.append(" AND ROWNUM = 1)) codigotipocentropoblado, (SELECT nivel.orde_4 ");
        consulta.append(" FROM zon_valor_estru_geopo nivel WHERE nivel.orde_1 = egeop.orde_1 ");
        consulta.append(" AND nivel.orde_2 = egeop.orde_2 AND nivel.orde_3 = egeop.orde_3 ");
        consulta.append(" AND nivel.orde_4 = egeop.orde_4 AND nivel.orde_5 IS NULL ");
        consulta.append(" AND nivel.pais_oid_pais = egeop.pais_oid_pais AND ROWNUM = 1) codigocentropoblado, ");
        consulta.append(" egeop.orde_1 orden1, egeop.orde_2 orden2, egeop.orde_3 orden3, ");
        consulta.append(" egeop.orde_4 orden4, egeop.orde_5 orden5, egeop.orde_6 orden6, ");
        consulta.append(" egeop.orde_7 orden7, egeop.orde_8 orden8, egeop.orde_9 orden9, ");
        consulta.append(" obtener_indicadores (cli.oid_clie, 2) indicadorlider, ");
        consulta.append(" obtener_indicadores (cli.oid_clie, 3) indicadorgerentezona, ");
        consulta.append(" obtener_indicadores (cli.oid_clie, 4) indicadorgerenteregion, ");
        consulta.append(" (SELECT cli2.cod_clie FROM mae_clien_vincu mcv, mae_tipo_vincu mtv, mae_clien cli2 ");
        consulta.append(" WHERE cli2.oid_clie = mcv.clie_oid_clie_vnte ");
        consulta.append(" AND mcv.tivc_oid_tipo_vinc = mtv.oid_tipo_vinc ");
        consulta.append(" AND mtv.ind_reco = 1 ");
		consulta.append(" and mcv.CLIE_OID_CLIE_VNdo = cli.oid_clie) AS codigoconsultorarecomendante, ");
        consulta.append(" pricont.cod_tipo_cont codigofuenteingresos, ");
        consulta.append(" cant.cod_clie_anti codigoanterior, flagtipoaccion as flagtipoaccion ");
        consulta.append(" ,nvl(clasi.flag,'0') flagduplacyzone ");  //  Cambio DuplaCyzone Sicc20070164
        consulta.append(" FROM (SELECT cli.oid_clie, cli.cod_clie AS cod_clie,");
        consulta.append(" cli.pais_oid_pais, cli.val_nom1, ");
        consulta.append(" cli.val_nom2, cli.val_ape1, cli.val_ape2, ");
        consulta.append(" '0' AS flagtipoaccion , cli.fec_ulti_actu FROM mae_clien cli WHERE ");
        consulta.append(" NOT TRUNC (cli.fec_ulti_actu) > TRUNC (cli.fec_crea) ");
        if(fecha != null){
            consulta.append(" AND cli.fec_ulti_actu > ");
            consulta.append(" TO_DATE ('"+ultimaFechaProceso+"', 'YYYY-MM-DD') ");
        }
        consulta.append(" UNION SELECT DISTINCT cli.oid_clie, cli.cod_clie, cli.pais_oid_pais, ");
        consulta.append(" cli.val_nom1, cli.val_nom2, cli.val_ape1, cli.val_ape2, '1', cli.fec_ulti_actu ");
        consulta.append(" FROM mae_clien cli, mae_clien_vincu vin, mae_clien_datos_adici adi, ");
        consulta.append(" mae_clien_unida_admin adm, mae_estat_clien est, mae_clien_direc dir, ");
        // vbongiov --  Cambio 20090928 -- 12/08/2009
        consulta.append(" mae_clien_prime_conta pricont, ");
        //sb 23/02/2010
        consulta.append(" mae_clien_comun mcc ");        
        consulta.append(" WHERE cli.oid_clie = adi.clie_oid_clie AND cli.oid_clie = adm.clie_oid_clie ");
        consulta.append(" AND adi.esta_oid_esta_clie = est.oid_esta_clie(+) AND cli.oid_clie = vin.clie_oid_clie_vndo(+) ");
        consulta.append(" AND cli.oid_clie = dir.clie_oid_clie  ");
        // vbongiov --  Cambio 20090928 -- 12/08/2009
        consulta.append(" AND cli.oid_clie = pricont.clie_oid_clie(+) ");
        //sb 23/02/2010
        consulta.append(" AND cli.oid_clie = mcc.clie_oid_clie(+) ");
        consulta.append(" AND trunc(cli.fec_ulti_actu) > trunc(cli.fec_crea) ");
        if(fecha != null){
            consulta.append(" AND (cli.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"', 'YYYY-MM-DD' ) FROM DUAL )");
            consulta.append(" OR adi.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR adm.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR vin.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR est.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            // vbongiov --  Cambio 20090928 -- 12/08/2009
            consulta.append(" OR pricont.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR dir.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR mcc.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL )) ");
        }
        consulta.append(" ) cli, ");
        consulta.append(" (SELECT mcts.clie_oid_clie, '1' AS flag ");
        consulta.append("  FROM mae_clien_clasi mcc, ");
        consulta.append("       mae_clien_tipo_subti mcts, ");
        consulta.append("       mae_clasi mc, ");
        consulta.append("       mae_tipo_clasi_clien mtcc, ");
        consulta.append("       mae_subti_clien msc, ");
        consulta.append("       mae_tipo_clien mtc ");
        consulta.append("  WHERE mcc.ctsu_oid_clie_tipo_subt = mcts.oid_clie_tipo_subt ");
        consulta.append("    AND mcc.clas_oid_clas = mc.oid_clas ");
        consulta.append("    AND mcc.tccl_oid_tipo_clasi = mtcc.oid_tipo_clas ");
        consulta.append("    AND mcts.ticl_oid_tipo_clie = mtc.oid_tipo_clie ");
        consulta.append("    AND mcts.sbti_oid_subt_clie = msc.oid_subt_clie ");
        consulta.append("    AND mc.cod_clas = '"+ConstantesMAE.COD_CLASIFICACION_DULPACYZONE +"' ");
        consulta.append("    AND mtcc.cod_tipo_clas = '"+ConstantesMAE.COD_TIPO_CLASIFICACION_DULPACYZONE +"' ");
        consulta.append(" ) clasi, ");  //  Cambio DuplaCyzone Sicc20070164
        consulta.append(" mae_clien_datos_adici adi, ");
        consulta.append(" mae_clien_unida_admin adm, ");
        consulta.append(" mae_estat_clien est, ");
        consulta.append(" int_dat_estat_clien ecdat, ");
        consulta.append(" mae_clien_direc dir, ");
        consulta.append(" mae_tipo_nivel_socec_perso tnse, ");
        consulta.append(" mae_estad_civil civ, ");
        consulta.append(" seg_nivel_socio_econo_asoci nse, ");
        consulta.append(" zon_terri_admin tad, ");
        consulta.append(" zon_terri terr, ");
        /* vbongiov --  Sicc 20080664 - DAT2 -- 27/08/2008
        consulta.append(" cra_perio per, ");
        consulta.append(" seg_perio_corpo pcor, ");
        */
        consulta.append(" mae_clien_prime_conta pricont, ");
        consulta.append(" mae_clien_ident ide, ");
        consulta.append(" mae_tipo_docum tdoc, ");
        consulta.append(" zon_valor_estru_geopo egeop, ");
        consulta.append(" seg_tipo_via tvia, ");
        consulta.append(" mae_clien lider, ");
        consulta.append(" zon_secci secc, ");
        consulta.append(" mae_codig_clien_anter cant, ");
        consulta.append(" mae_clien_vincu vin, ");
        //sb
         consulta.append(" mae_clien_comun mcc ");         
        /* vbongiov --  Sicc 20080664 - DAT2 -- 27/08/2008
        consulta.append(" mae_clien_histo_estat hist ");
        */
        consulta.append(" WHERE cli.OID_CLIE = adi.CLIE_OID_CLIE ");
        consulta.append(" AND cli.oid_clie = adm.clie_oid_clie ");
        consulta.append(" AND cli.oid_clie = ide.clie_oid_clie ");
        consulta.append(" AND cli.oid_clie = dir.clie_oid_clie ");
        consulta.append(" AND cli.oid_clie = cant.clie_oid_clie_nuev(+) ");
        consulta.append(" AND cli.oid_clie = pricont.clie_oid_clie(+) ");
        consulta.append(" AND cli.oid_clie = clasi.clie_oid_clie(+) "); //  Cambio DuplaCyzone Sicc20070164
        consulta.append(" AND adi.esta_oid_esta_clie = est.oid_esta_clie(+) ");
        consulta.append(" AND est.oid_esta_clie = ecdat.esta_oid_esta_clie(+) ");
        consulta.append(" AND adi.nsep_oid_nsep = tnse.oid_nsep(+) ");
        consulta.append(" AND adi.escv_oid_esta_civi = civ.oid_esta_civi(+) ");
        consulta.append(" AND tnse.oid_nsep = nse.nsep_oid_tipo_nive_soec_pers(+) ");
        consulta.append(" AND adm.ztad_oid_terr_admi = tad.oid_terr_admi ");
        consulta.append(" AND tad.terr_oid_terr = terr.oid_terr ");
        consulta.append(" AND ide.tdoc_oid_tipo_docu = tdoc.oid_tipo_docu ");
        consulta.append(" AND terr.vepo_oid_valo_estr_geop = egeop.oid_valo_estr_geop(+) ");
        consulta.append(" AND dir.tivi_oid_tipo_via = tvia.oid_tipo_via ");
        consulta.append(" AND tad.zscc_oid_secc = secc.oid_secc ");
        consulta.append(" AND secc.clie_oid_clie = lider.oid_clie(+) ");
        consulta.append(" AND ide.val_iden_docu_prin = 1 ");
        consulta.append(" AND adm.ind_acti = 1 ");
        /* vbongiov --  Sicc 20080664 - DAT2 -- 27/08/2008
        consulta.append(" AND per.peri_oid_peri = pcor.oid_peri ");
        consulta.append(" AND hist.perd_oid_peri = per.oid_peri ");
        consulta.append(" AND hist.perd_oid_peri = (SELECT MIN (perd_oid_peri) ");// MAX x MIN  SiCC 20070130
        consulta.append(" FROM mae_clien_histo_estat mh ");
        consulta.append(" WHERE mh.clie_oid_clie = cli.oid_clie )  ");//solo el estatus activo
        //se quito AND mh.PERD_OID_PERI_PERI_FIN is null por incidencia SiCC 20070130
        consulta.append(" AND cli.oid_clie = hist.clie_oid_clie ");
        */
        consulta.append(" AND cli.pais_oid_pais = "+pais.toString()+" ");
        consulta.append(" AND dir.ind_dire_ppal = 1 ");
        consulta.append(" AND dir.ind_elim = 0 ");
        consulta.append(" AND cli.oid_clie = vin.clie_oid_clie_vndo(+) ");
        //sb 23/02/2010
        consulta.append(" AND cli.oid_clie = mcc.clie_oid_clie(+) ");
        if (fecha != null) {
            consulta.append(" AND (cli.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"', 'YYYY-MM-DD' ) FROM DUAL ) ");
            consulta.append(" OR adi.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR adm.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR vin.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR est.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            // vbongiov --  Cambio 20090928 -- 12/08/2009
            consulta.append(" OR pricont.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");            
            consulta.append(" OR dir.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL ) ");
            consulta.append(" OR mcc.fec_ulti_actu > (SELECT TO_DATE ('"+ultimaFechaProceso+"','YYYY-MM-DD') FROM DUAL )) ");
        }
       // consulta.append(" order by 2 ");

        UtilidadesLog.debug("SQL-DAT 02: "+consulta.toString());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        java.sql.Connection connection = null;
        java.sql.CallableStatement pstmt = null;
        try {
             connection = bs.dbService.getConnection();
             pstmt = connection.prepareCall("{call DAT_ENVIA_CLIENTES(?,?,?,?,?,?,?,?,?,?)}");
             pstmt.setString(1, consulta.toString());
             pstmt.setString(2, pathArchivo);
             pstmt.setString(3, nombreArchivo);

             //jrivas 23/1/2007 Se le agrega mas parametros para la inserción en INT_HISTO_LOTES
             pstmt.setString(4, interfaz.getCodigoInterfaz());
             pstmt.setString(5, interfaz.getNumeroLote());
             pstmt.setString(6, interfaz.getDescripcionLote());
             pstmt.setString(7, interfaz.getObservaciones());
             pstmt.setLong(8, interfaz.getPais().longValue());
             pstmt.setString(9, interfaz.getCriteriosConsulta());
             pstmt.setLong(10, interfaz.getPeriodo());
            
             pstmt.executeUpdate();
             if (pstmt != null){
                 pstmt.close();
            }
            
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerTablaClientes  : Exception", e);
            //this.logSql(" obtenerTablaClientes  SQL: ", consulta.toString());
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } finally{
           if (connection != null){
                try {connection.close();}catch (Exception e) {;}
           }
        }
        UtilidadesLog.info("DAOINTDAT.obtenerTablaClientes(Long pais, Long marca, Long canal, java.util.Date fecha, Long idioma, String pathArchivo, String nombreArchivo, InterfazInfo interfaz): *Salida");
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080664 - dmorello, 13/11/2008
     * - Se descartan zonas/regiones sin cliente asignado
     * - Se descartan secciones/zonas/regiones no activas o borradas
     */
    public ArrayList obtenerUnidadesGeograficas(Long pais, Long marca, Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerUnidadesGeograficas(Long pais, Long marca, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();

        consulta.append(" SELECT ");
        consulta.append(" TER.COD_TERR CODIGOTERRITORIO,");
        consulta.append(" SEC.COD_SECC CODIGOSECCION,");
        consulta.append(" SEC.DES_SECCI,");
        //consulta.append(" CLISEC.COD_CLIE LIDERSECCION, ");
        consulta.append("  NVL(CLISEC.COD_CLIE,' ') LIDERSECCION, "); //cambio 20090866
        consulta.append(" CLISEC.VAL_NOM1 || ' ' || CLISEC.VAL_NOM2 ||' ' || CLISEC.VAL_APE1 ||' ' || CLISEC.VAL_APE2 NOMBRELIDERSECCION,");
        consulta.append(" ZON.COD_ZONA CODIGOZONA,");
        consulta.append(" ZON.DES_ZONA NOMBREZONA,");
        //consulta.append(" CLIZON.COD_CLIE GERENTEZONA,");
        consulta.append("  NVL(CLIZON.COD_CLIE,' ') GERENTEZONA, "); // cambio 20090866
        consulta.append(" CLIZON.VAL_NOM1 || ' ' || CLIZON.VAL_NOM2 ||' ' || CLIZON.VAL_APE1 ||' ' || CLIZON.VAL_APE2 NOMBREGERENTEZONA,");
        consulta.append(" REG.COD_REGI CODIGOREGION,");
        consulta.append(" REG.DES_REGI NOMBREREGIO, ");
        //consulta.append(" CLIREG.COD_CLIE GERENTEREGION, ");        
        consulta.append("  NVL(CLIREG.COD_CLIE,' ') GERENTEREGION, "); // cambio 20090866
        consulta.append(" CLIREG.VAL_NOM1 || ' ' || CLIREG.VAL_NOM2 ||' ' || CLIREG.VAL_APE1 ||' ' || CLIREG.VAL_APE2 NOMBREGERENTEREGION, ");
        //esta linea se modifica a pedido de Rocio Ugarteche (Belcorp). Modificado 05/10/2006 por Gacevedo
        consulta.append(" CASE WHEN TRIM(TER.COD_NSE2) IS NULL THEN TRIM(TER.COD_NSE1) ELSE TRIM(TER.COD_NSE2) END NIVEL, ");
        consulta.append(" NIVEL1.ORDE_1 CODIGODEPARTAMENTOGEOGRAFICO, ");
        consulta.append(" NIVEL1.DES_GEOG NOMBREDEPARTAMENTOGEOGRAFICO, ");
        consulta.append(" NIVEL2.ORDE_2 CODIGOPROVINCIAGEOGRAFICO, ");
        consulta.append(" NIVEL2.DES_GEOG NOMBREPROVINCIAGEOGRAFICA, ");
        consulta.append(" NIVEL3.ORDE_3 CODIGODISTRITOGEOGRAFICO, ");
        consulta.append(" NIVEL3.DES_GEOG NOMBREDISTRITOGEOGRAFICO, ");
        consulta.append(" GEO.ORDE_1 || GEO.ORDE_2 || GEO.ORDE_3 ||");
        consulta.append(" GEO.ORDE_4 || GEO.ORDE_5 || GEO.ORDE_6 ||");
        consulta.append(" GEO.ORDE_7 || GEO.ORDE_8 || GEO.ORDE_9 CODIGOUBIGEO, ");
        consulta.append(" SVG.COD_SUBG_VENT CODIGOSUBGERENCIAVENTAS, ");
        consulta.append(" SVG.DES_SUBG_VENT NOMBRESUBGERENCIAVENTAS, ");
        consulta.append(" PAIS.COD_PAIS CODIGOPAIS, ");
        consulta.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO   ");
        consulta.append("   WHERE IDIO.ATTR_ENTI = 'SEG_PAIS'  ");
        consulta.append("   AND IDIO.IDIO_OID_IDIO = ? ");
        parametros.add(ConstantesSEG.IDIOMA_DEFECTO);
        consulta.append("   AND IDIO.VAL_OID = PAIS.OID_PAIS) NOMBREPAIS ");

        consulta.append(" FROM ");
        consulta.append(" ZON_TERRI_ADMIN TAD, ");
        consulta.append(" ZON_TERRI TER, ");
        consulta.append(" ZON_ZONA ZON, ");
        consulta.append(" ZON_SECCI SEC, ");
        consulta.append(" ZON_REGIO REG, ");
        consulta.append(" ZON_SUB_GEREN_VENTA SVG, ");
        consulta.append(" MAE_CLIEN CLIZON, ");
        consulta.append(" MAE_CLIEN CLIREG, ");
        consulta.append(" MAE_CLIEN CLISEC, ");
        consulta.append(" ZON_VALOR_ESTRU_GEOPO GEO, ");
        consulta.append(" ZON_VALOR_ESTRU_GEOPO nivel1, ");
        consulta.append(" ZON_VALOR_ESTRU_GEOPO nivel2, ");
        consulta.append(" ZON_VALOR_ESTRU_GEOPO nivel3, ");
        consulta.append(" SEG_PAIS PAIS  ");

        consulta.append(" WHERE ");
        consulta.append(" TAD.PAIS_OID_PAIS = ? "); //1//--pais /*parametro de entrada*/
        parametros.add(pais);
        consulta.append(" AND TAD.MARC_OID_MARC =? "); //1--   marca /*parametro de entrada*/
        parametros.add(marca);
        consulta.append(" AND TAD.CANA_OID_CANA = ? "); //1-- canal /*parametro de entrada*/
        parametros.add(canal);
        consulta.append(" AND TAD.IND_BORR = 0 ");
        consulta.append(" AND PAIS.OID_PAIS= ?  "); //--pais /*parametro de entrada*/
        parametros.add(pais);
        consulta.append(" AND TAD.TERR_OID_TERR = TER.OID_TERR ");
        consulta.append(" AND TAD.ZSCC_OID_SECC = SEC.OID_SECC ");
        consulta.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        consulta.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
        consulta.append(" AND REG.ZSGV_OID_SUBG_VENT=SVG.OID_SUBG_VENT ");
        consulta.append(" AND ZON.CLIE_OID_CLIE = CLIZON.OID_CLIE  (+)");
        consulta.append(" AND REG.CLIE_OID_CLIE = CLIREG.OID_CLIE (+) ");
        consulta.append(" AND SEC.CLIE_OID_CLIE = CLISEC.OID_CLIE (+) ");
        consulta.append(" AND TER.VEPO_OID_VALO_ESTR_GEOP = GEO.OID_VALO_ESTR_GEOP  ");
        consulta.append(" and nivel1.ORDE_1 = geo.ORDE_1 and nivel1.ORDE_2 is null ");
        consulta.append(" and nivel1.PAIS_OID_PAIS =geo.PAIS_OID_PAIS ");
        consulta.append(" and nivel2.ORDE_1 = geo.ORDE_1 and nivel2.ORDE_2 = geo.ORDE_2 ");
        consulta.append(" and nivel2.ORDE_3 is null and ");
        consulta.append(" nivel2.PAIS_OID_PAIS = geo.PAIS_OID_PAIS ");
        consulta.append(" and nivel3.ORDE_1 = geo.ORDE_1 and nivel3.ORDE_2 = geo.ORDE_2 ");
        consulta.append(" and nivel3.ORDE_3 = geo.ORDE_3 ");
        consulta.append(" and nivel3.ORDE_4 is null and nivel3.PAIS_OID_PAIS = geo.PAIS_OID_PAIS ");
        consulta.append(" and nivel1.IND_ACTI= 1 AND nivel1.IND_BORR=0 ");
        consulta.append(" and nivel2.IND_ACTI= 1 AND nivel2.IND_BORR=0 ");
        consulta.append(" and nivel3.IND_ACTI= 1 AND nivel3.IND_BORR=0 ");
        consulta.append(" AND SEC.IND_ACTI = 1 ");
        consulta.append(" AND ZON.IND_ACTI = 1 AND ZON.IND_BORR = 0 ");
        consulta.append(" AND REG.IND_ACTI = 1 AND REG.IND_BORR = 0 ");

        //- con los registros obtenidos se construyen objetos de tipo DTOINTUnidadGeografica y se retornan en un alista.
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerGerentesRegionales  : Exception", e);
            this.logSql(" obtenerGerentesRegionales  SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        DTOINTUnidadGeografica dto = null;

        if (rs != null) {
            if (!rs.esVacio()) {
                int n = rs.getRowCount();

                for (int i = 0; i < n; i++) {
                    dto = new DTOINTUnidadGeografica();

                    if (rs.getValueAt(i, "CODIGOTERRITORIO") != null) {
                        dto.setCodigoTerritorio(rs.getValueAt(i, "CODIGOTERRITORIO").toString());
                    }

                    //COGIGO DE SECCION, LA DESCRIPCION DE SECCION NO HAY PORPIEDAD EN EL dto
                    if (rs.getValueAt(i, "CODIGOSECCION") != null) {
                        dto.setCodigoSeccion((String) rs.getValueAt(i, "CODIGOSECCION"));
                    }

                    //CODIGO LIDER SECCION Y NOMBRE DE LIDER
                    if (rs.getValueAt(i, "LIDERSECCION") != null) {
                        dto.setCodigoLiderSeccion((String) rs.getValueAt(i, "LIDERSECCION"));
                    }

                    if (rs.getValueAt(i, "NOMBRELIDERSECCION") != null) {
                        dto.setNombreLider((String) rs.getValueAt(i, "NOMBRELIDERSECCION"));
                    }

                    //CODIGO Y NOBRE DE ZONA
                    if (rs.getValueAt(i, "CODIGOZONA") != null) {
                        dto.setCodigoZona((String) rs.getValueAt(i, "CODIGOZONA"));
                    }

                    if (rs.getValueAt(i, "NOMBREZONA") != null) {
                        dto.setNombreZona((String) rs.getValueAt(i, "NOMBREZONA"));
                    }

                    //CODIGO Y NOMBRE DE REGION 
                    if (rs.getValueAt(i, "CODIGOREGION") != null) {
                        dto.setCodigoRegion((String) rs.getValueAt(i, "CODIGOREGION"));
                    }

                    if (rs.getValueAt(i, "NOMBREREGIO") != null) {
                        dto.setNombreRegion((String) rs.getValueAt(i, "NOMBREREGIO"));
                    }

                    //CODIGO Y NOMBRE DE GERENTE DE ZONA
                    if (rs.getValueAt(i, "GERENTEZONA") != null) {
                        dto.setCodigoGerenteZona((String) rs.getValueAt(i, "GERENTEZONA"));
                    }

                    if (rs.getValueAt(i, "NOMBREGERENTEZONA") != null) {
                        dto.setNombreGerenteZona((String) rs.getValueAt(i, "NOMBREGERENTEZONA"));
                    }

                    //CODIGO Y NOMBRE DE GERENTE REGIONAL
                    if (rs.getValueAt(i, "GERENTEREGION") != null) {
                        dto.setCodigoGerenteRegional((String) rs.getValueAt(i, "GERENTEREGION"));
                    }

                    if (rs.getValueAt(i, "NOMBREGERENTEREGION") != null) {
                        dto.setNombreGerenteRegional((String) rs.getValueAt(i, "NOMBREGERENTEREGION"));
                    }

                    if (rs.getValueAt(i, "NIVEL") != null) {
                        dto.setNivelSocioeconomico((String) rs.getValueAt(i, "NIVEL"));
                    }

                    //CODIGO Y NOMBRE DE PAIS
                    if (rs.getValueAt(i, "NOMBREPAIS") != null) {
                        dto.setNombrePais((String) rs.getValueAt(i, "NOMBREPAIS"));
                    }

                    if (rs.getValueAt(i, "CODIGOPAIS") != null) {
                        dto.setCodigoPais((String) rs.getValueAt(i, "CODIGOPAIS"));
                    }

                    //codigo y nombre de departamento GEografico
                    if (rs.getValueAt(i, "CODIGODEPARTAMENTOGEOGRAFICO") != null) {
                        dto.setCodigoDepartamentoGeografico((String) rs.getValueAt(i, "CODIGODEPARTAMENTOGEOGRAFICO"));
                    }

                    if (rs.getValueAt(i, "NOMBREDEPARTAMENTOGEOGRAFICO") != null) {
                        dto.setNombreDepartamentoGeografico((String) rs.getValueAt(i, "NOMBREDEPARTAMENTOGEOGRAFICO"));
                    }

                    //codigo y nombre de departamento PROVINCIA GEOGRAFICO
                    if (rs.getValueAt(i, "CODIGOPROVINCIAGEOGRAFICO") != null) {
                        dto.setCodigoProvinciaGeografico((String) rs.getValueAt(i, "CODIGOPROVINCIAGEOGRAFICO"));
                    }

                    if (rs.getValueAt(i, "NOMBREPROVINCIAGEOGRAFICA") != null) {
                        dto.setNombreProvinciaGeografica((String) rs.getValueAt(i, "NOMBREPROVINCIAGEOGRAFICA"));
                    }

                    //codigo y nombre de departamento DISTRITO GEOGRAFICO
                    if (rs.getValueAt(i, "CODIGODISTRITOGEOGRAFICO") != null) {
                        dto.setCodigoDistritoGeografico((String) rs.getValueAt(i, "CODIGODISTRITOGEOGRAFICO"));
                    }

                    if (rs.getValueAt(i, "NOMBREDISTRITOGEOGRAFICO") != null) {
                        dto.setNombreDistritoGeografico((String) rs.getValueAt(i, "NOMBREDISTRITOGEOGRAFICO"));
                    }

                    //codigo y nombre de departamento DISTRITO GEOGRAFICO
                    if (rs.getValueAt(i, "CODIGOSUBGERENCIAVENTAS") != null) {
                        dto.setCodigoSubgerenciaVentas((String) rs.getValueAt(i, "CODIGOSUBGERENCIAVENTAS"));
                    }

                    if (rs.getValueAt(i, "NOMBRESUBGERENCIAVENTAS") != null) {
                        dto.setNombreSubgerenciaVentas((String) rs.getValueAt(i, "NOMBRESUBGERENCIAVENTAS"));
                    }

                    if (rs.getValueAt(i, "CODIGOUBIGEO") != null) {
                        dto.setCodigoUbigeo((String) rs.getValueAt(i, "CODIGOUBIGEO"));
                    }

                    // dto.set
                    array.add(dto);
                } //for
            }
        } //(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerUnidadesGeograficas(Long pais, Long marca, Long canal): Salida");

        return array;
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080664 - dmorello, 13/11/2008
     * - Se modifica firma quedando: pais, marca, canal
     * - Se elimina de la query la tabla PED_SOLIC_CABEC
     * - Se agregan filtros para secc/zona/reg: activo y no borrado
     * - Se descartan zonas y regiones si no poseen cliente asignado
     */
    public ArrayList obtenerUnidadesGeograficasCampania(Long pais, Long marca, Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerUnidadesGeograficasCampania(Long pais, Long marca, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();

        consulta.append(" SELECT DISTINCT ");
        consulta.append(" TERR.COD_TERR CODTERR,  ");
        consulta.append(" SECC.COD_SECC CODSEC,  ");
        //consulta.append(" CLISECC.COD_CLIE CODLIDER,  ");
        consulta.append("  NVL(CLISECC.COD_CLIE,' ') CODLIDER, ");  //cambio 20090866       
        consulta.append(" ZON.COD_ZONA CODZON,  ");
        consulta.append(" REG.COD_REGI CODREG,  ");
        //consulta.append(" CLIZON.COD_CLIE GERENTEZON,  ");
        consulta.append("   NVL(CLIZON.COD_CLIE,' ') GERENTEZON, ");  //cambio 20090866
       // consulta.append(" CLIREG.COD_CLIE GERENTEREG,  ");
        consulta.append("     NVL(CLIREG.COD_CLIE,' ') GERENTEREG,  ");   //cambio 20090866
        consulta.append(" GEO.ORDE_1 UBI1,  ");
        consulta.append(" GEO.ORDE_2 UBI2,  ");
        consulta.append(" GEO.ORDE_3 UBI3,  ");
        consulta.append(" GEO.ORDE_4 UBI4,  ");
        consulta.append(" GEO.ORDE_5 UBI5,  ");
        consulta.append(" GEO.ORDE_6 UBI6,  ");
        consulta.append(" GEO.ORDE_7 UBI7,  ");
        consulta.append(" GEO.ORDE_8 UBI8,  ");
        consulta.append(" GEO.ORDE_9 UBI9,  ");
        consulta.append(" REG.DES_REGI NOMBREREG,  ");
        consulta.append(" ZON.DES_ZONA NOMBREZON,  ");
        consulta.append(" CLISECC.VAL_NOM1 NOMBRE1LIDERSEC,  ");
        consulta.append(" CLISECC.VAL_NOM2 NOMBRE2LIDERSEC,  ");
        consulta.append(" CLISECC.VAL_APE1 APE1LIDERSEC,  ");
        consulta.append(" CLISECC.VAL_APE2 APE2LIDERSEC,  ");
        consulta.append(" CLIREG.VAL_NOM1 NOM1GERENREG,  ");
        consulta.append(" CLIREG.VAL_NOM2 NOM2GERENREG,  ");
        consulta.append(" CLIREG.VAL_APE1 APE2GERENREG,  ");
        consulta.append(" CLIREG.VAL_APE2 APE2GERENREG,  ");
        consulta.append(" CLIZON.VAL_NOM1 NOM1GERENZON,  ");
        consulta.append(" CLIZON.VAL_NOM2 NOM2GERENZON,  ");
        consulta.append(" CLIZON.VAL_APE1 APE1GERENZON,  ");
        consulta.append(" CLIZON.VAL_APE2 APE2GERENZON,  ");
        consulta.append(" EST.COD_ESTA_ZONA ESTATUS,  ");
        consulta.append(" SUBG.COD_SUBG_VENT CODIGOSUBGEREN,  ");
        consulta.append(" SUBG.DES_SUBG_VENT NOMBRESUBGEREN  ");

        consulta.append(" FROM  ");
        consulta.append(" ZON_ZONA ZON,  ");
        consulta.append(" ZON_REGIO REG,  ");
        consulta.append(" ZON_SUB_GEREN_VENTA SUBG,  ");
        consulta.append(" ZON_TERRI_ADMIN TAD,  ");
        consulta.append(" ZON_TERRI TERR,  ");
        consulta.append(" ZON_SECCI SECC,  ");
        consulta.append(" ZON_VALOR_ESTRU_GEOPO GEO,  ");
        consulta.append(" ZON_ESTAD_ZONA EST, ");
        consulta.append(" MAE_CLIEN CLISECC,  ");
        consulta.append(" MAE_CLIEN CLIZON,  ");
        consulta.append(" MAE_CLIEN CLIREG  ");
        consulta.append(" WHERE SECC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        consulta.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI  ");
        consulta.append(" AND ZON.ESZO_OID_ESTA_ZONA = EST.OID_ESTA_ZONA(+) ");
        consulta.append(" AND REG.ZSGV_OID_SUBG_VENT = SUBG.OID_SUBG_VENT  ");
        consulta.append(" AND TAD.TERR_OID_TERR = TERR.OID_TERR  ");
        consulta.append(" AND TERR.VEPO_OID_VALO_ESTR_GEOP = GEO.OID_VALO_ESTR_GEOP  ");
        consulta.append(" AND TAD.ZSCC_OID_SECC = SECC.OID_SECC  ");
        consulta.append(" AND SECC.CLIE_OID_CLIE = CLISECC.OID_CLIE(+) ");  //cambio 20090866
        consulta.append(" AND ZON.CLIE_OID_CLIE = CLIZON.OID_CLIE (+) ");    //cambio 20090866
        consulta.append(" AND REG.CLIE_OID_CLIE = CLIREG.OID_CLIE (+) ");    //cambio 20090866
        consulta.append(" AND TAD.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND TAD.MARC_OID_MARC = ? ");
        parametros.add(marca);
        consulta.append(" AND TAD.CANA_OID_CANA = ? ");
        parametros.add(canal);
        consulta.append(" AND TAD.IND_BORR = 0 ");
        consulta.append(" AND SECC.IND_ACTI = 1 ");
        consulta.append(" AND ZON.IND_ACTI = 1 AND ZON.IND_BORR = 0 ");
        consulta.append(" AND REG.IND_ACTI = 1 AND REG.IND_BORR = 0 ");
        consulta.append(" AND SUBG.IND_ACTI = 1 AND SUBG.IND_BORR = 0 ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerUnidadesGeograficasCampania  : Exception", e);
            this.logSql(" obtenerUnidadesGeograficasCampania  SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        //UtilidadesLog.debug("\n\n rs devuelto -->" +rs);
        // con los registros obtenidos se construyen objetos de tipo DTOINTUnidadGeograficaCampania, y se retornan en una lista.
        DTOINTUnidadGeograficaCampania dto = null;

        if (rs != null) {
            if (!rs.esVacio()) {
                int n = rs.getRowCount();

                for (int i = 0; i < n; i++) {
                    dto = new DTOINTUnidadGeograficaCampania();

                    if (rs.getValueAt(i, "CODTERR") != null) {
                        dto.setCodigoTerritorio(rs.getValueAt(i, "CODTERR").toString());
                    }

                    if (rs.getValueAt(i, "CODSEC") != null) {
                        dto.setCodigoSeccion((String) rs.getValueAt(i, "CODSEC"));
                    }

                    if (rs.getValueAt(i, "CODLIDER") != null) {
                        dto.setCodigoLiderSeccion((String) rs.getValueAt(i, "CODLIDER"));
                    }

                    if (rs.getValueAt(i, "CODZON") != null) {
                        dto.setCodigoZona((String) rs.getValueAt(i, "CODZON"));
                    }

                    if (rs.getValueAt(i, "CODREG") != null) {
                        dto.setCodigoRegion((String) rs.getValueAt(i, "CODREG"));
                    }

                    if (rs.getValueAt(i, "GERENTEZON") != null) {
                        dto.setCodigoGerenteZona((String) rs.getValueAt(i, "GERENTEZON"));
                    }

                    if (rs.getValueAt(i, "GERENTEREG") != null) {
                        dto.setCodigoGerenteRegional((String) rs.getValueAt(i, "GERENTEREG"));
                    }

                    if (rs.getValueAt(i, "UBI1") != null) {
                        dto.setUbigeoOrden1((String) rs.getValueAt(i, "UBI1"));
                    }

                    if (rs.getValueAt(i, "UBI2") != null) {
                        dto.setUbigeoOrden2((String) rs.getValueAt(i, "UBI2"));
                    }

                    if (rs.getValueAt(i, "UBI3") != null) {
                        dto.setUbigeoOrden3((String) rs.getValueAt(i, "UBI3"));
                    }

                    if (rs.getValueAt(i, "UBI4") != null) {
                        dto.setUbigeoOrden4((String) rs.getValueAt(i, "UBI4"));
                    }

                    if (rs.getValueAt(i, "UBI5") != null) {
                        dto.setUbigeoOrden5((String) rs.getValueAt(i, "UBI5"));
                    }

                    if (rs.getValueAt(i, "UBI6") != null) {
                        dto.setUbigeoOrden6((String) rs.getValueAt(i, "UBI6"));
                    }

                    if (rs.getValueAt(i, "UBI7") != null) {
                        dto.setUbigeoOrden7((String) rs.getValueAt(i, "UBI7"));
                    }

                    if (rs.getValueAt(i, "UBI8") != null) {
                        dto.setUbigeoOrden8((String) rs.getValueAt(i, "UBI8"));
                    }

                    if (rs.getValueAt(i, "UBI9") != null) {
                        dto.setUbigeoOrden9((String) rs.getValueAt(i, "UBI9"));
                    }

                    if (rs.getValueAt(i, "NOMBREREG") != null) {
                        dto.setNombreRegion((String) rs.getValueAt(i, "NOMBREREG"));
                    }

                    if (rs.getValueAt(i, "NOMBREZON") != null) {
                        dto.setNombreZona((String) rs.getValueAt(i, "NOMBREZON"));
                    }

                    if (rs.getValueAt(i, "NOMBRE1LIDERSEC") != null) {
                        dto.setNombre1LiderSeccion((String) rs.getValueAt(i, "NOMBRE1LIDERSEC"));
                    }

                    if (rs.getValueAt(i, "NOMBRE2LIDERSEC") != null) {
                        dto.setNombre2LiderSeccion((String) rs.getValueAt(i, "NOMBRE2LIDERSEC"));
                    }

                    if (rs.getValueAt(i, "APE1LIDERSEC") != null) {
                        dto.setApellido1LiderSeccion((String) rs.getValueAt(i, "APE1LIDERSEC"));
                    }

                    if (rs.getValueAt(i, "APE2LIDERSEC") != null) {
                        dto.setApellido2LiderSeccion((String) rs.getValueAt(i, "APE2LIDERSEC"));
                    }

                    if (rs.getValueAt(i, "NOM1GERENREG") != null) {
                        dto.setNombre1GerenteRegional((String) rs.getValueAt(i, "NOM1GERENREG"));
                    }

                    if (rs.getValueAt(i, "NOM2GERENREG") != null) {
                        dto.setNombre2GerenteRegional((String) rs.getValueAt(i, "NOM2GERENREG"));
                    }

                    if (rs.getValueAt(i, "APE2GERENREG") != null) {
                        dto.setApellido2GerenteRegional((String) rs.getValueAt(i, "APE2GERENREG"));
                    }

                    if (rs.getValueAt(i, "APE2GERENREG") != null) {
                        dto.setApellido2GerenteRegional((String) rs.getValueAt(i, "APE2GERENREG"));
                    }

                    if (rs.getValueAt(i, "NOM1GERENZON") != null) {
                        dto.setNombre1GerenteZona((String) rs.getValueAt(i, "NOM1GERENZON"));
                    }

                    if (rs.getValueAt(i, "NOM2GERENZON") != null) {
                        dto.setNombre2GerenteZona((String) rs.getValueAt(i, "NOM2GERENZON"));
                    }

                    if (rs.getValueAt(i, "APE1GERENZON") != null) {
                        dto.setApellido1GerenteZona((String) rs.getValueAt(i, "APE1GERENZON"));
                    }

                    if (rs.getValueAt(i, "APE2GERENZON") != null) {
                        dto.setApellido2GerenteZona((String) rs.getValueAt(i, "APE2GERENZON"));
                    }

                    if (rs.getValueAt(i, "ESTATUS") != null) {
                        dto.setEstatusZona((String) rs.getValueAt(i, "ESTATUS"));
                    }

                    if (rs.getValueAt(i, "CODIGOSUBGEREN") != null) {
                        dto.setCodigoSubgerenciaVentas((String) rs.getValueAt(i, "CODIGOSUBGEREN"));
                    }

                    if (rs.getValueAt(i, "NOMBRESUBGEREN") != null) {
                        dto.setNombreSubgerenciaVentas((String) rs.getValueAt(i, "NOMBRESUBGEREN"));
                    }

                    array.add(dto);
                } //for
            }
        } //(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerUnidadesGeograficasCampania(Long pais, Long marca, Long canal): Salida");

        return array;
    }

    //************************************************    
    // DAOS CURSO
    //************************************************
    public ArrayList obtenerAccesos(Long canal, Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerAccesos(Long canal, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT ac.COD_ACCE CODIGOACCESO,  ");
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  ");
        consulta.append("  WHERE idio.ATTR_ENTI = 'SEG_ACCES' ");
        consulta.append("  AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append("  AND idio.VAL_OID = ac.OID_ACCE ) DESCRIPCIONACCESO  ");
        consulta.append("  FROM SEG_CANAL ca,SEG_ACCES ac ");
        consulta.append("  WHERE ac.CANA_OID_CANA = ca.OID_CANA ");

        if (canal != null) {
            consulta.append("  AND  ca.OID_CANA = ? ");
            parametros.add(canal);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerAccesos: Exception", e);
            this.logSql("  obtenerAccesos. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTAccesos acceso = null;

        if (rs != null) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                acceso = new DTOINTAccesos();

                if (rs.getValueAt(i, "CODIGOACCESO") != null) {
                    acceso.setCodigoAcceso((String) rs.getValueAt(i, "CODIGOACCESO"));
                }

                if (rs.getValueAt(i, "DESCRIPCIONACCESO") != null) {
                    acceso.setDescripcionAcceso((String) rs.getValueAt(i, "DESCRIPCIONACCESO"));
                }

                lista.add(acceso);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerAccesos(Long canal, Long idioma): Salida");

        return lista;
    }

    public ArrayList obtenerCampaniasAnio(Long pais, Long marca, Long canal, Integer anio) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerCampaniasAnio(Long pais, Long marca, Long canal, Integer anio): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT P.FEC_INIC FECHAINICIO, P.FEC_FINA FECHAFIN, PC.COD_PERI CODIGOPERIODO  ");
        consulta.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
        consulta.append(" WHERE PC.OID_PERI = P.PERI_OID_PERI ");

        if (canal != null) {
            consulta.append(" AND P.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }

        if (pais != null) {
            consulta.append(" AND P.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (marca != null) {
            consulta.append(" AND P.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }

        if (anio != null) {
            consulta.append(" AND PC.VAL_ANIO = ?  ");
            parametros.add(anio);
        }

        //gPineda - 02/02/2007 - INT-DATPRD5
        consulta.append(" ORDER BY p.FEC_INIC ASC ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerCampaniasAnio: Exception", e);
            this.logSql("  obtenerCampaniasAnio. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTCampaniaAnio campaniaAnio = null;

        if (rs != null) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                campaniaAnio = new DTOINTCampaniaAnio();

                if (rs.getValueAt(i, "FECHAINICIO") != null) {
                    campaniaAnio.setFechaInicio(new Date(((java.sql.Date) rs.getValueAt(i, "FECHAINICIO")).getTime()));
                }

                if (rs.getValueAt(i, "FECHAFIN") != null) {
                    campaniaAnio.setFechaFin(new Date(((java.sql.Date) rs.getValueAt(i, "FECHAFIN")).getTime()));
                }

                if (rs.getValueAt(i, "CODIGOPERIODO") != null) {
                    campaniaAnio.setCodigoPeriodo((String) rs.getValueAt(i, "CODIGOPERIODO"));
                }

                lista.add(campaniaAnio);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerCampaniasAnio(Long pais, Long marca, Long canal, Integer anio): Salida");

        return lista;
    }

    public ArrayList obtenerZonasRealesPorRegion(Long pais, Long marca, Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerZonasRealesPorRegion(Long pais, Long marca, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT A.COD_REGI REGION, A.CANA_OID_CANA, A.PAIS_OID_PAIS, A.MARC_OID_MARC, COUNT(*) NUM_ZONAS ");
        consulta.append(" FROM ZON_REGIO A, ZON_ZONA B ");
        consulta.append(" WHERE A.OID_REGI = B.ZORG_OID_REGI ");
        consulta.append(" AND B.IND_ACTI = 1 ");
        consulta.append(" AND A.IND_BORR = 0 ");
        consulta.append(" AND B.IND_BORR = 0 ");

        if (pais != null) {
            consulta.append(" AND A.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (marca != null) {
            consulta.append(" AND A.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }

        if (canal != null) {
            consulta.append(" AND A.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }

        consulta.append(" GROUP BY A.COD_REGI, A.CANA_OID_CANA, A.PAIS_OID_PAIS, A.MARC_OID_MARC ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerZonasRealesPorRegion: Exception", e);
            this.logSql("  obtenerZonasRealesPorRegion. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTZonasRealesPorRegion zonasReales = null;

        if (rs != null) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                zonasReales = new DTOINTZonasRealesPorRegion();

                if (rs.getValueAt(i, "REGION") != null) {
                    zonasReales.setCodigoRegion((String) rs.getValueAt(i, "REGION"));
                }

                if (rs.getValueAt(i, "NUM_ZONAS") != null) {
                    zonasReales.setNumZonas(new Long(((BigDecimal) rs.getValueAt(i, "NUM_ZONAS")).longValue()));
                }

                lista.add(zonasReales);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerZonasRealesPorRegion(Long pais, Long marca, Long canal): Salida");

        return lista;
    }

    public ArrayList obtenerSecciones(Long pais, Long marca, Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerSecciones(Long pais, Long marca, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT sgv.COD_SUBG_VENT CODIGOSGV,re.COD_REGI CODIGOREGION,se.COD_SECC CODIGOSECCION,  ");
        consulta.append("        zz.COD_ZONA CODIGOZONA,sgv.DES_SUBG_VENT NOMBRESGV,re.DES_REGI NOMBREREGION,  ");
        consulta.append("        zz.DES_ZONA NOMBREZONA,mc.COD_CLIE CODIGOLIDER,mc.VAL_NOM1 NOMBRE1,mc.VAL_NOM2 NOMBRE2,  ");
        consulta.append("        mc.VAL_APE1 APELLIDO1,mc.VAL_APE2 APELLIDO2,  ");
        consulta.append("        LID_FN_DEVUE_FLAG_LIDER(zz.PAIS_OID_PAIS,zz.MARC_OID_MARC,re.CANA_OID_CANA,zz.OID_ZONA,se.OID_SECC) FLAGLIDER ");
        consulta.append(" FROM ZON_REGIO re , ZON_SUB_GEREN_VENTA sgv , ZON_ZONA zz , ZON_SECCI se , MAE_CLIEN mc  ");
        consulta.append(" WHERE se.ZZON_OID_ZONA = zz.OID_ZONA AND mc.OID_CLIE (+)= se.CLIE_OID_CLIE AND  ");
        consulta.append("       zz.ZORG_OID_REGI = re.OID_REGI AND re.ZSGV_OID_SUBG_VENT = sgv.OID_SUBG_VENT AND ");
        consulta.append("       zz.IND_ACTI = 1 AND se.IND_ACTI = 1 AND re.IND_ACTI = 1 AND sgv.IND_ACTI = 1  ");

        //AÑADIDO POR INCIDENCIA 20303
        consulta.append(" AND zz.IND_BORR = 0 "); //FALSE
        consulta.append(" AND se.IND_BORR = 0 "); //FALSE
        consulta.append(" AND re.IND_BORR = 0 "); //FALSE
        consulta.append(" AND sgv.IND_BORR = 0"); //FALSE
        
        consulta.append(" AND zz.PAIS_OID_PAIS = re.PAIS_OID_PAIS "); 
        consulta.append(" AND zz.MARC_OID_MARC = re.MARC_OID_MARC "); 
        consulta.append(" AND zz.CANA_OID_CANA = re.CANA_OID_CANA "); 
        consulta.append(" AND re.PAIS_OID_PAIS = sgv.PAIS_OID_PAIS "); 
        consulta.append(" AND re.MARC_OID_MARC = sgv.MARC_OID_MARC "); 
        consulta.append(" AND re.CANA_OID_CANA = sgv.CANA_OID_CANA "); 

        //Se filtrara por los campos de entrada que no sean NULL
        if (pais != null) {
            consulta.append("   AND sgv.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (marca != null) {
            consulta.append("   AND sgv.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }

        if (canal != null) {
            consulta.append("   AND sgv.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerSecciones: Exception", e);
            this.logSql("  obtenerSecciones. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTSecciones secciones = null;

        if (rs != null) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                secciones = new DTOINTSecciones();

                if (rs.getValueAt(i, "CODIGOSGV") != null) {
                    secciones.setCodigoSGV((String) rs.getValueAt(i, "CODIGOSGV"));
                }

                if (rs.getValueAt(i, "CODIGOREGION") != null) {
                    secciones.setCodigoRegion((String) rs.getValueAt(i, "CODIGOREGION"));
                }

                if (rs.getValueAt(i, "CODIGOSECCION") != null) {
                    secciones.setCodigoSeccion((String) rs.getValueAt(i, "CODIGOSECCION"));
                }

                if (rs.getValueAt(i, "CODIGOZONA") != null) {
                    secciones.setCodigoZona((String) rs.getValueAt(i, "CODIGOZONA"));
                }

                if (rs.getValueAt(i, "NOMBRESGV") != null) {
                    secciones.setNombreSGV((String) rs.getValueAt(i, "NOMBRESGV"));
                }

                if (rs.getValueAt(i, "NOMBREREGION") != null) {
                    secciones.setNombreRegion((String) rs.getValueAt(i, "NOMBREREGION"));
                }

                if (rs.getValueAt(i, "NOMBREZONA") != null) {
                    secciones.setNombreZona((String) rs.getValueAt(i, "NOMBREZONA"));
                }

                if (rs.getValueAt(i, "CODIGOLIDER") != null) {
                    secciones.setCodigoLider((String) rs.getValueAt(i, "CODIGOLIDER"));
                }

                if (rs.getValueAt(i, "NOMBRE1") != null) {
                    secciones.setNombre1((String) rs.getValueAt(i, "NOMBRE1"));
                }

                if (rs.getValueAt(i, "NOMBRE2") != null) {
                    secciones.setNombre2((String) rs.getValueAt(i, "NOMBRE2"));
                }

                if (rs.getValueAt(i, "APELLIDO1") != null) {
                    secciones.setApellido1((String) rs.getValueAt(i, "APELLIDO1"));
                }

                if (rs.getValueAt(i, "APELLIDO2") != null) {
                    secciones.setApellido2((String) rs.getValueAt(i, "APELLIDO2"));
                }

                if (rs.getValueAt(i, "FLAGLIDER") != null) {
                    secciones.setFlagAptaLider((String) rs.getValueAt(i, "FLAGLIDER"));
                }
                lista.add(secciones);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerSecciones(Long pais, Long marca, Long canal): Salida");

        return lista;
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 2008664 - dmorello, 13/11/2008
     * - Se descartan regiones sin cliente asignado
     */
    public ArrayList obtenerRegiones(Long pais, Long marca, Long canal, Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerRegiones(Long pais, Long marca, Long canal, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" select SGV.COD_SUBG_VENT CODIGOSGV , ");
        consulta.append(" SGV.DES_SUBG_VENT NOMBRESGV , ");
        consulta.append(" RE.COD_REGI CODIGOREGION , ");
        consulta.append(" RE.DES_REGI NOMBREREGION , ");
        consulta.append(" PA.COD_PAIS CODIGOPAIS , ");
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_PAIS' AND idio.IDIO_OID_IDIO = ? AND idio.VAL_OID = PA.OID_PAIS ) NOMBREPAIS , ");
        parametros.add(idioma);
        consulta.append(" MC.COD_CLIE CODIGOGERENTEREGIONAL , ");
        consulta.append(" MC.VAL_NOM1 NOMBRE1 , ");
        consulta.append(" MC.VAL_NOM2 NOMBRE2 , ");
        consulta.append(" MC.VAL_APE1 APELLIDO1 , ");
        consulta.append(" MC.VAL_APE2 APELLIDO2 ");
        consulta.append(" from ZON_REGIO RE, ZON_SUB_GEREN_VENTA SGV, MAE_CLIEN MC, SEG_PAIS PA ");
        consulta.append(" where SGV.PAIS_OID_PAIS = PA.OID_PAIS ");
        consulta.append(" and RE.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append(" and RE.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
        consulta.append(" and RE.IND_ACTI = 1 "); //true
        consulta.append(" and SGV.IND_ACTI = 1 "); //true

        //añadido por incidencia 20302
        consulta.append(" and RE.IND_BORR = 0 "); //false
        consulta.append(" and SGV.IND_BORR =0 "); //false

        if (pais != null) {
            consulta.append(" and SGV.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (marca != null) {
            consulta.append(" and SGV.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }

        if (canal != null) {
            consulta.append(" and SGV.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerRegiones: Exception", e);
            this.logSql(" obtenerRegiones. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList regiones = new ArrayList();

        if (rs != null) {
            int numResultados = rs.getRowCount();

            for (int i = 0; i < numResultados; i++) {
                DTOINTRegiones dtointRegiones = new DTOINTRegiones();

                if (rs.getValueAt(i, "CODIGOSGV") != null) {
                    dtointRegiones.setCodigoSGV((String) rs.getValueAt(i, "CODIGOSGV"));
                }

                if (rs.getValueAt(i, "NOMBRESGV") != null) {
                    dtointRegiones.setNombreSGV((String) rs.getValueAt(i, "NOMBRESGV"));
                }

                if (rs.getValueAt(i, "CODIGOREGION") != null) {
                    dtointRegiones.setCodigoRegion((String) rs.getValueAt(i, "CODIGOREGION"));
                }

                if (rs.getValueAt(i, "NOMBREREGION") != null) {
                    dtointRegiones.setNombreRegion((String) rs.getValueAt(i, "NOMBREREGION"));
                }

                if (rs.getValueAt(i, "CODIGOPAIS") != null) {
                    dtointRegiones.setCodigoPais((String) rs.getValueAt(i, "CODIGOPAIS"));
                }

                if (rs.getValueAt(i, "NOMBREPAIS") != null) {
                    dtointRegiones.setNombrePais((String) rs.getValueAt(i, "NOMBREPAIS"));
                }

                if (rs.getValueAt(i, "CODIGOGERENTEREGIONAL") != null) {
                    dtointRegiones.setCodigoGerenteRegional((String) rs.getValueAt(i, "CODIGOGERENTEREGIONAL"));
                }

                if (rs.getValueAt(i, "NOMBRE1") != null) {
                    dtointRegiones.setNombre1((String) rs.getValueAt(i, "NOMBRE1"));
                }

                if (rs.getValueAt(i, "NOMBRE2") != null) {
                    dtointRegiones.setNombre2((String) rs.getValueAt(i, "NOMBRE2"));
                }

                if (rs.getValueAt(i, "APELLIDO1") != null) {
                    dtointRegiones.setApellido1((String) rs.getValueAt(i, "APELLIDO1"));
                }

                if (rs.getValueAt(i, "APELLIDO2") != null) {
                    dtointRegiones.setApellido2((String) rs.getValueAt(i, "APELLIDO2"));
                }

                regiones.add(dtointRegiones);
            } //for
        } //if(rs != null)

        UtilidadesLog.info("DAOINTDAT.obtenerRegiones(Long pais, Long marca, Long canal, Long idioma): Salida");

        return regiones;
    }

    public ArrayList obtenerBoletasDespachoCanje(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion, ArrayList listaOids) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespachoCanje(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion, ArrayList listaOids): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT DISTINCT pc.COD_PERI ANIOCAMPANIA,  "); 
        consulta.append("        ca.COD_CANA CODIGOCANAL , "); 
        consulta.append("        ac.COD_ACCE CODIGOACCESO , ");
        consulta.append("        sc2.VAL_NUME_SOLI NUMDOCUMENTOFACTURACION , ");
        consulta.append("        te.COD_TERR CODIGOTERRITORIO , "); 
        consulta.append("        mc.COD_CLIE CODIGOCONSULTORA , ");
        consulta.append("        mc.OID_CLIE OIDCONSULTORA , ");
        consulta.append("        sc2.FEC_CRON FECHADOCUMENTO , ");   
        consulta.append("        mc2.OID_CLIE CODIGOCLIENTERECEPTOR , ");
        consulta.append("        ts.IND_ANUL FLAGANULACION , ");
        consulta.append("        ts.IND_DEVO flagDevolucion , ");        
        consulta.append("        sc.VAL_TOTA_PAGA_LOCA VENTAFACTURA , "); 
        consulta.append("        sc.VAL_IMPO_FLET_TOTA_LOCA MONTOFLETE , ");
        consulta.append("        sc.NUM_CLIEN NUMEROCLIENTES  "); 
        consulta.append(" FROM   CRA_PERIO pe , ");        
        consulta.append("        SEG_PERIO_CORPO pc ,  ");        
        consulta.append("        SEG_CANAL ca , ");        
        consulta.append("        PED_SOLIC_CABEC sc , ");
        consulta.append("        PED_SOLIC_CABEC sc2 , ");        
        consulta.append("        SEG_ACCES ac , ");        
        consulta.append("        SEG_SUBAC sa , ");        
        consulta.append("        ZON_TERRI te , ");        
        consulta.append("        MAE_CLIEN mc , ");
        consulta.append("        MAE_CLIEN mc2 , ");
        consulta.append("        PED_TIPO_SOLIC ts , ");
        consulta.append("        PED_TIPO_SOLIC_PAIS sp , ");	
        consulta.append("        INT_DAT_SOLIC_CANJE dsc , ");
        consulta.append("        PED_SOLIC_POSIC pos, ");
        //PZERBINO 8/11/2006 Se  vuelve a agregar.
        consulta.append("        rec_opera op, ");
        consulta.append("        rec_opera_recla orec, ");
        consulta.append("        REC_SOLIC_OPERA solop, ");
        consulta.append("        REC_TIPOS_OPERA tiop ");
        
        consulta.append(" WHERE  pe.PERI_OID_PERI = pc.OID_PERI (+) ");
        consulta.append("        AND pe.CANA_OID_CANA = ca.OID_CANA (+) ");
        consulta.append("        AND sc.PERD_OID_PERI = pe.OID_PERI ");
        consulta.append("        AND sc.SBAC_OID_SBAC = sa.OID_SBAC (+) ");
        consulta.append("        AND sa.ACCE_OID_ACCE = ac.OID_ACCE (+) ");
        consulta.append("        AND sc.TERR_OID_TERR = te.OID_TERR (+) ");
        consulta.append("        AND sc.CLIE_OID_CLIE = mc2.OID_CLIE ");
        consulta.append("        AND sc.soca_oid_soli_cabe = sc2.oid_soli_cabe ");
        consulta.append("        AND sc.CLIE_OID_CLIE_RECE_FACT = mc2.OID_CLIE ");
        consulta.append("        AND sc.TSPA_OID_TIPO_SOLI_PAIS = sp.OID_TIPO_SOLI_PAIS ");       
        consulta.append("        AND sp.TSOL_OID_TIPO_SOLI = dsc.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append("        AND pos.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE (+) ");
				consulta.append("        AND pos.NUM_UNID_POR_ATEN > pos.NUM_UNID_COMPR	");
        consulta.append("        AND sc2.IND_TS_NO_CONSO = 0 ");
        //consulta.append("        AND sc2.IND_OC = 0 ");
        //consulta.append("        AND (sc2.IND_PEDI_PRUE = 0 OR sc2.IND_PEDI_PRUE IS NULL) ");


        if (!listaOids.isEmpty()){
          String lista = this.convertirArrayToString(listaOids, parametros); 
          UtilidadesLog.info("lista OIDS +++-- " + listaOids.toString());
          consulta.append(" AND sc.SOCA_OID_SOLI_CABE IN ("+ lista +") "); //lista de OidsConsolidados
        }

       //Se filtrara por los campos de entrada que no sean NULL
        if (periodo != null) {
          consulta.append("    AND pe.OID_PERI = ? ");
          parametros.add(periodo);
        }

        if (pais != null) {
          consulta.append("    AND sc.PAIS_OID_PAIS = ? ");
          parametros.add(pais);
        }

        if (acceso != null) {
            consulta.append("    AND ac.OID_ACCE = ? ");
            parametros.add(acceso);
        }
        
        //PZERBINO 8/11/2006 Se  vuelve a agregar.
        if (fechaFacturacion != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime());

            String sFecha = sdf.format(fecha);
            consulta.append("    AND sc2.FEC_FACT = TRUNC(TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFecha);
        }
        
        //PZERBINO 20/11/2006 POR CAMBIOS DOCUMENTO DE VUELTA
        consulta.append("        AND pe.cana_oid_cana = 1 ");
        consulta.append("        AND sc2.oid_soli_cabe = solop.soca_oid_soli_cabe ");
        consulta.append("        AND solop.TSPA_OID_TIPO_SOLI_PAIS = dsc.tspa_oid_tipo_soli_pais ");
        consulta.append("        AND solop.OPRE_OID_OPER_RECL = orec.OID_OPER_RECL ");
        consulta.append("        AND orec.TIOP_OID_TIPO_OPER = tiop.OID_TIPO_OPER ");
        consulta.append("        AND tiop.ROPE_OID_OPER = op.oid_oper ");
        consulta.append("        AND op.TSPA_OID_SOLI_CON_STOC = dsc.tspa_oid_tipo_soli_pais");
        
        UtilidadesLog.info("consulta 11111+++  " + consulta.toString());
        UtilidadesLog.info("parametros 11111+++  " + parametros);
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerBoletasDespacho: Exception", e);
            this.logSql("  obtenerBoletasDespachoCanje. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTBoletasDespacho boletasDespacho = null;
        UtilidadesLog.debug("Numero de filas =  " + rs.getRowCount());

        int n = rs.getRowCount();
        UtilidadesLog.debug("Numero de filas =  " + n);
        if (!rs.esVacio()) {
            for (int i = 0; i < n; i++) {
                boletasDespacho = new DTOINTBoletasDespacho();

                if (rs.getValueAt(i, "ANIOCAMPANIA") != null) {
                    boletasDespacho.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIA"));
                }

                if (rs.getValueAt(i, "CODIGOCANAL") != null) {
                    boletasDespacho.setCodigoCanal((String) rs.getValueAt(i, "CODIGOCANAL"));
                }

                if (rs.getValueAt(i, "CODIGOACCESO") != null) {
                    boletasDespacho.setCodigoAcceso((String) rs.getValueAt(i, "CODIGOACCESO"));
                }

                if (rs.getValueAt(i, "NUMDOCUMENTOFACTURACION") != null) {
                    boletasDespacho.setNumDocumentoFacturacion(new Long(((BigDecimal) rs.getValueAt(i, "NUMDOCUMENTOFACTURACION")).longValue()));
                }

                if (rs.getValueAt(i, "CODIGOTERRITORIO") != null) { //????
                    boletasDespacho.setCodigoTerritorio(Long.valueOf(rs.getValueAt(i, "CODIGOTERRITORIO").toString()));
                }

                if (rs.getValueAt(i, "CODIGOCONSULTORA") != null) {
                    boletasDespacho.setCodigoConsultora((String) rs.getValueAt(i, "CODIGOCONSULTORA"));
                }

                //boletasDespacho.setCodigoConsultora((String) rs.getValueAt(i,"CODIGOCONSULTORA"));
                if (rs.getValueAt(i, "OIDCONSULTORA") != null) { //?????
                    boletasDespacho.setOidConsultora(new Long(((BigDecimal) rs.getValueAt(i, "OIDCONSULTORA")).longValue()));
                }

                if (rs.getValueAt(i, "FECHADOCUMENTO") != null) {
                    boletasDespacho.setFechaDocumento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHADOCUMENTO")).getTime()));
                }

                if (rs.getValueAt(i, "CODIGOCLIENTERECEPTOR") != null) { //????
                    boletasDespacho.setOidClienteReceptor(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOCLIENTERECEPTOR")).longValue())); //(new Long((String) rs.getValueAt(i,"CODIGOCLIENTERECEPTOR")));
                }

                if (rs.getValueAt(i, "FLAGANULACION") != null) {
                    boletasDespacho.setFlagAnulacion(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGANULACION")).intValue()));
                }
                
                if (rs.getValueAt(i, "FLAGDEVOLUCION") != null) {
                    boletasDespacho.setFlagAnulacion(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGDEVOLUCION")).intValue()));
                }
                
                if (rs.getValueAt(i, "VENTAFACTURA") != null) {
                    boletasDespacho.setVentaFactura((BigDecimal) rs.getValueAt(i, "VENTAFACTURA"));
                }

                if (rs.getValueAt(i, "MONTOFLETE") != null) {
                    boletasDespacho.setMontoFlete((BigDecimal) rs.getValueAt(i, "MONTOFLETE"));
                }

                if (rs.getValueAt(i, "NUMEROCLIENTES") != null) {
                    boletasDespacho.setNumeroClientes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCLIENTES")).longValue()));
                }
                                
                lista.add(boletasDespacho);
            } //fin bucle for            
        }//fin if rs
        UtilidadesLog.info("boletasDespachoCanje ******** " + boletasDespacho);
                

        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespachoCanje(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion, ArrayList listaOids): Salida");
        return lista;
    }



    public ArrayList obtenerBoletasDespacho(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespacho(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT DISTINCT pc.COD_PERI ANIOCAMPANIA , "); 
        consulta.append("        ca.COD_CANA CODIGOCANAL , "); 
        consulta.append("        ac.COD_ACCE CODIGOACCESO , ");
        consulta.append("        sc.VAL_NUME_SOLI NUMDOCUMENTOFACTURACION , ");
        consulta.append("        te.COD_TERR CODIGOTERRITORIO , "); 
        consulta.append("        mc.COD_CLIE CODIGOCONSULTORA , ");
        consulta.append("        mc.OID_CLIE OIDCONSULTORA , ");
        consulta.append("        sc2.FEC_CRON FECHADOCUMENTO , ");   
        consulta.append("        mc2.OID_CLIE CODIGOCLIENTERECEPTOR , ");
        consulta.append("        ts.IND_ANUL FLAGANULACION , ");
        consulta.append("        sc.VAL_TOTA_PAGA_LOCA VENTAFACTURA , "); 
        consulta.append("        sc.VAL_IMPO_FLET_TOTA_LOCA MONTOFLETE , ");
        consulta.append("        sc.NUM_CLIEN NUMEROCLIENTES , "); 
        consulta.append("        sc.PAIS_OID_PAIS , ");
        //pzerbino 26/10/2006 Inc 24361
        consulta.append("        ts.IND_DEVO flagDevolucion , ");
        consulta.append("        pc2.COD_PERI anioCampaniaRef , ");
        consulta.append("        ca2.COD_CANA codigoCanalRef , ");
        consulta.append("        ac2.COD_ACCE codigoAccesoRef , ");
        consulta.append("        scref.VAL_NUME_SOLI numDocumFactRef , ");
        consulta.append("        te2.COD_TERR codTerritRef , ");
        consulta.append("        scref.FEC_CRON fechaDocumRef , ");
        consulta.append("        scref.VAL_TOTA_PAGA_LOCA ventafactRef , ");
        consulta.append("        scref.VAL_IMPO_FLET_TOTA_LOCA montoFleteRef , ");        
        consulta.append("        sc2.OID_SOLI_CABE oIdConsolidado ");
        consulta.append(" FROM   CRA_PERIO pe , ");
        consulta.append("        CRA_PERIO pe2 , ");
        consulta.append("        SEG_PERIO_CORPO pc ,  ");
        consulta.append("        SEG_PERIO_CORPO pc2 , ");        
        consulta.append("        SEG_CANAL ca , ");
        consulta.append("        SEG_CANAL ca2 , ");
        consulta.append("        PED_SOLIC_CABEC sc , ");
        consulta.append("        PED_SOLIC_CABEC sc2 , ");
        consulta.append("        PED_SOLIC_CABEC scref , ");
        consulta.append("        SEG_ACCES ac , ");
        consulta.append("        SEG_ACCES ac2 , ");
        consulta.append("        SEG_SUBAC sa , ");
        consulta.append("        SEG_SUBAC sa2 , ");
        consulta.append("        ZON_TERRI te , ");
        consulta.append("        ZON_TERRI te2 , ");
        consulta.append("        MAE_CLIEN mc , ");
        consulta.append("        MAE_CLIEN mc2 , ");
        consulta.append("        PED_TIPO_SOLIC ts , ");
        consulta.append("        PED_TIPO_SOLIC_PAIS sp ");	         
        consulta.append(" WHERE  pe.PERI_OID_PERI = pc.OID_PERI ");
        consulta.append("        AND pe.CANA_OID_CANA = ca.OID_CANA ");
        consulta.append("        AND sc.PERD_OID_PERI = pe.OID_PERI ");
        consulta.append("        AND sc.SBAC_OID_SBAC = sa.OID_SBAC ");
        consulta.append("        AND sa.ACCE_OID_ACCE = ac.OID_ACCE ");
        consulta.append("        AND sc.SOCA_OID_SOLI_CABE = sc2.OID_SOLI_CABE ");
        consulta.append("        AND sc.TERR_OID_TERR = te.OID_TERR ");
        consulta.append("        AND sc.CLIE_OID_CLIE = mc.OID_CLIE ");       
        consulta.append("        AND sc.CLIE_OID_CLIE_RECE_FACT = mc2.OID_CLIE ");
        consulta.append("        AND sc.TSPA_OID_TIPO_SOLI_PAIS = sp.OID_TIPO_SOLI_PAIS ");       
        consulta.append("        AND sp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");        
        consulta.append("        AND sc2.IND_TS_NO_CONSO = 0 ");
        consulta.append("        AND sc2.IND_OC = 0 ");
        consulta.append("        AND (sc2.IND_PEDI_PRUE = 0 OR sc2.IND_PEDI_PRUE IS NULL) ");


       //Se filtrara por los campos de entrada que no sean NULL
        if (periodo != null) {
            consulta.append("    AND pe.OID_PERI = ? ");
            parametros.add(periodo);
        }

        if (pais != null) {
            consulta.append("    AND sc.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (acceso != null) {
            consulta.append("    AND ac.OID_ACCE = ? ");
            parametros.add(acceso);
        }

        if (fechaFacturacion != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime());

            String sFecha = sdf.format(fecha);
            consulta.append("    AND sc2.FEC_FACT = TRUNC(TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')) ");
            parametros.add(sFecha);
        }
        //PZERBINO 26/10/2006 Inc 24361
        consulta.append("        AND  sc.SOCA_OID_DOCU_REFE = scref.OID_SOLI_CABE(+) ");
			  consulta.append("        AND  pe2.PERI_OID_PERI = pc2.OID_PERI(+) ");
			  consulta.append("        AND  pe2.CANA_OID_CANA = ca2.OID_CANA(+) ");
			  consulta.append("        AND  scref.PERD_OID_PERI = pe2.OID_PERI(+) ");
			  consulta.append("        AND  scref.SBAC_OID_SBAC = sa2.OID_SBAC(+) ");
			  consulta.append("        AND  sa2.ACCE_OID_ACCE = ac2.OID_ACCE(+) ");
			  consulta.append("        AND  scref.TERR_OID_TERR = te2.OID_TERR(+) ");
 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerBoletasDespacho: Exception", e);
            this.logSql("  obtenerBoletasDespacho. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        ArrayList listaOidsConso = new ArrayList();
        DTOINTBoletasDespacho boletasDespacho = null;
        UtilidadesLog.debug("Numero de filas =  " + rs.getRowCount());

        int n = rs.getRowCount();
        UtilidadesLog.debug("Numero de filas =  " + n);

        if (!rs.esVacio()) {
            for (int i = 0; i < n; i++) {
                boletasDespacho = new DTOINTBoletasDespacho();

                if (rs.getValueAt(i, "ANIOCAMPANIA") != null) {
                    boletasDespacho.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIA"));
                }

                if (rs.getValueAt(i, "CODIGOCANAL") != null) {
                    boletasDespacho.setCodigoCanal((String) rs.getValueAt(i, "CODIGOCANAL"));
                }

                if (rs.getValueAt(i, "CODIGOACCESO") != null) {
                    boletasDespacho.setCodigoAcceso((String) rs.getValueAt(i, "CODIGOACCESO"));
                }

                if (rs.getValueAt(i, "NUMDOCUMENTOFACTURACION") != null) {
                    boletasDespacho.setNumDocumentoFacturacion(new Long(((BigDecimal) rs.getValueAt(i, "NUMDOCUMENTOFACTURACION")).longValue()));
                }

                if (rs.getValueAt(i, "CODIGOTERRITORIO") != null) { //????
                    boletasDespacho.setCodigoTerritorio(Long.valueOf(rs.getValueAt(i, "CODIGOTERRITORIO").toString()));
                }

                if (rs.getValueAt(i, "CODIGOCONSULTORA") != null) {
                    boletasDespacho.setCodigoConsultora((String) rs.getValueAt(i, "CODIGOCONSULTORA"));
                }

                //boletasDespacho.setCodigoConsultora((String) rs.getValueAt(i,"CODIGOCONSULTORA"));
                if (rs.getValueAt(i, "OIDCONSULTORA") != null) { //?????
                    boletasDespacho.setOidConsultora(new Long(((BigDecimal) rs.getValueAt(i, "OIDCONSULTORA")).longValue()));
                }

                if (rs.getValueAt(i, "FECHADOCUMENTO") != null) {
                    boletasDespacho.setFechaDocumento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHADOCUMENTO")).getTime()));
                }

                if (rs.getValueAt(i, "CODIGOCLIENTERECEPTOR") != null) { //????
                    boletasDespacho.setOidClienteReceptor(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOCLIENTERECEPTOR")).longValue())); //(new Long((String) rs.getValueAt(i,"CODIGOCLIENTERECEPTOR")));
                }

                if (rs.getValueAt(i, "FLAGANULACION") != null) {
                    boletasDespacho.setFlagAnulacion(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGANULACION")).intValue()));
                }else {
                    boletasDespacho.setFlagAnulacion(new Integer(0));
                }

                if (rs.getValueAt(i, "VENTAFACTURA") != null) {
                    boletasDespacho.setVentaFactura((BigDecimal) rs.getValueAt(i, "VENTAFACTURA"));
                }

                if (rs.getValueAt(i, "MONTOFLETE") != null) {
                    boletasDespacho.setMontoFlete((BigDecimal) rs.getValueAt(i, "MONTOFLETE"));
                }

                if (rs.getValueAt(i, "NUMEROCLIENTES") != null) {
                    boletasDespacho.setNumeroClientes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCLIENTES")).longValue()));
                }
                
                if (rs.getValueAt(i, "PAIS_OID_PAIS") != null) {
                    boletasDespacho.setOidPais(new Long(((BigDecimal) rs.getValueAt(i, "PAIS_OID_PAIS")).longValue()));
                }
                
                String indDevol = new String();
                //pzerbino 26/10/2006 Incidencia 24361
                if (rs.getValueAt(i, "FLAGDEVOLUCION") != null) {
                    indDevol =  rs.getValueAt(i, "FLAGDEVOLUCION").toString();
                }   
                if (indDevol.equals("1") || boletasDespacho.getFlagAnulacion().equals(new Integer(1))){
                       if (rs.getValueAt(i, "ANIOCAMPANIAREF") != null) {
                                boletasDespacho.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIAREF"));
                       }
            
                       if (rs.getValueAt(i, "CODIGOCANALREF") != null) {
                                boletasDespacho.setCodigoCanal((String) rs.getValueAt(i, "CODIGOCANALREF"));
                       }
            
                       if (rs.getValueAt(i, "CODIGOACCESOREF") != null) {
                                boletasDespacho.setCodigoAcceso((String) rs.getValueAt(i, "CODIGOACCESOREF"));
                       }
            
                       if (rs.getValueAt(i, "NUMDOCUMFACTREF") != null) {
                                boletasDespacho.setNumDocumentoFacturacion(new Long(((BigDecimal) rs.getValueAt(i, "NUMDOCUMFACTREF")).longValue()));
                       }
            
                       if (rs.getValueAt(i, "CODTERRITREF") != null) { //????
                                boletasDespacho.setCodigoTerritorio(Long.valueOf(rs.getValueAt(i, "CODTERRITREF").toString()));
                       }

                       if (rs.getValueAt(i, "FECHADOCUMREF") != null) {
                                boletasDespacho.setFechaDocumento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHADOCUMREF")).getTime()));
                       }

                       if (rs.getValueAt(i, "VENTAFACTREF") != null) {
                                boletasDespacho.setVentaFactura((BigDecimal) rs.getValueAt(i, "VENTAFACTREF"));
                       }
            
                       if (rs.getValueAt(i, "MONTOFLETEREF") != null) {
                              boletasDespacho.setMontoFlete((BigDecimal) rs.getValueAt(i, "MONTOFLETEREF"));
                       }
                    }
                //Insertar dtoboleta
                UtilidadesLog.info("boletasDespacho+++++ " + boletasDespacho);
                lista.add(boletasDespacho);
                //carga de oidsconsolidados
                UtilidadesLog.info("oIdConsolidado+++++ " + rs.getValueAt(i, "OIDCONSOLIDADO"));
                listaOidsConso.add(rs.getValueAt(i, "OIDCONSOLIDADO"));
                
            } //fin bucle for            
        }//fin if rs
        
        ArrayList listaCanje = new ArrayList();
        listaCanje =  obtenerBoletasDespachoCanje(pais, acceso, periodo, fechaFacturacion, listaOidsConso);
        /*pzerbino 28/10/2006 
        * Esto es una burrada, pero a ningun craneo se le ocurrio otra cosa
        */
        if(lista.size() > 0){
           DTOINTBoletasDespacho boletasDespa = null;
           DTOINTBoletasDespacho boletasDespaCanje = null;           
           ArrayList listaCanjeInsert = new ArrayList();
           Iterator  it = lista.iterator();
           Iterator itCanje = listaCanje.iterator();
           while (it.hasNext()){
               boletasDespa = new DTOINTBoletasDespacho(); 
               String datoConsolidados = "";
               boletasDespa = (DTOINTBoletasDespacho) it.next();

               datoConsolidados =    boletasDespa.getAnioCampania() + "*" +
                                     boletasDespa.getCodigoAcceso()+ "*" +
                                     boletasDespa.getCodigoCanal()+ "*" + 
                                     boletasDespa.getCodigoConsultora()+ "*" +
                                     boletasDespa.getCodigoTerritorio()+ "*" +
                                     boletasDespa.getFechaDocumento()+ "*" +
                                     boletasDespa.getFlagAnulacion()+ "*" +
                                     boletasDespa.getMontoFlete()+ "*" +
                                     boletasDespa.getNumDocumentoFacturacion()+ "*" +
                                     boletasDespa.getNumeroClientes()+ "*" +
                                     boletasDespa.getOidClienteReceptor()+ "*" +
                                     boletasDespa.getOidConsultora()+ "*" +
                                     boletasDespa.getVentaFactura()+ "*";

                                
                while(itCanje.hasNext()){
                     boolean igual = false;
                     String datoCanje = "";
                     boletasDespaCanje = new DTOINTBoletasDespacho();  
                     boletasDespaCanje = (DTOINTBoletasDespacho) itCanje.next();
                     
                     datoCanje =   boletasDespaCanje.getAnioCampania() + "*" +
                                   boletasDespaCanje.getCodigoAcceso()+ "*" +
                                   boletasDespaCanje.getCodigoCanal()+ "*" + 
                                   boletasDespaCanje.getCodigoConsultora()+ "*" +
                                   boletasDespaCanje.getCodigoTerritorio()+ "*" +
                                   boletasDespaCanje.getFechaDocumento()+ "*" +
                                   boletasDespaCanje.getFlagAnulacion()+ "*" +
                                   boletasDespaCanje.getMontoFlete()+ "*" +
                                   boletasDespaCanje.getNumDocumentoFacturacion()+ "*" +
                                   boletasDespaCanje.getNumeroClientes()+ "*" +
                                   boletasDespaCanje.getOidClienteReceptor()+ "*" +
                                   boletasDespaCanje.getOidConsultora()+ "*" +
                                   boletasDespaCanje.getVentaFactura()+ "*";
                    
                    if (!(datoConsolidados.equals(datoCanje))){
                        listaCanjeInsert.add(boletasDespaCanje);                      
                    }
                             
                }               
           }
          
          /*if (listaCanjeInsert.size() > 0) {
              listaCanjeInsert.add(boletasDespaCanje);
          }*/
          Iterator  ite = listaCanjeInsert.iterator();

           while (ite.hasNext()){                              
               boletasDespa = (DTOINTBoletasDespacho) ite.next();
               lista.add(boletasDespa);
           }     
        }
        
        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespacho(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion): Salida");
        return lista;
    }

    /**
     * NOTAS:
     *    - Cambio SiCC 20070511 - dmorello
     *      Se agrega el parámetro Long pais
     *      Se modifica query para joinear con PRE_VENTA_EXCLU y PRE_VENTA_EXCLU_TIPO_CLASI
     */
    public ArrayList obtenerMatrizCampania(Long periodo, java.util.Date fechaUltimoProceso, Long idioma, Long pais) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerMatrizCampania(Long periodo, java.util.Date fechaUltimoProceso, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT ca.COD_CANA CODIGOCANAL, pc.COD_PERI ANIOCAMPANIA, "); //Aquí no sé si está mal, en lugar de COD_PERI, sería VAL_ANIO
        consulta.append(" mp.COD_SAP CODIGOPRODUCTO, tof.COD_TIPO_OFER CODIGOTIPOOFERTA, ");
        consulta.append(" od.VAL_CODI_VENT CODIGOVENTA, ");

        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);

        consulta.append(" AND idio.VAL_OID = tof.OID_TIPO_OFER ) DESCRIPCIONTIPOOFERTA, ");
        consulta.append(" OD.PRECIO_UNITARIO PRECIOOFERTA, tof.IND_ESTA FLAGESTADISTICABLE "); //modificado por incidencia SiCC-20070228
        // Cambio SiCC 20070511 - dmorello
        consulta.append(", DECODE(ventaex.aux, NULL, '0', '1') AS flagperteneceprogsessionexpert ");
        //S.B
         consulta.append(", od.IMP_PREC_PUBL AS PRECIOVENTA ");
         consulta.append(", od.IMP_PREC_POSI AS PRECIOVENTANORMAL ");

        consulta.append(" FROM CRA_PERIO pe , SEG_PERIO_CORPO pc , SEG_CANAL ca , ");
        consulta.append(" PRE_MATRI_FACTU_CABEC mc , PRE_MATRI_FACTU mf , ");
        consulta.append(" PRE_OFERT_DETAL od , MAE_PRODU mp , PRE_TIPO_OFERT tof ");
        // Cambio SiCC 20070511 - dmorello
        consulta.append(" , (SELECT vex.ofer_oid_ofer, COUNT(*) AS aux ");
        consulta.append("      FROM pre_venta_exclu vex, pre_venta_exclu_tipo_clasi vextc ");
        consulta.append("     WHERE vextc.pais_oid_pais = ").append(pais);
        consulta.append("       AND vex.ticl_oid_tipo_clie = vextc.ticl_oid_tipo_clie ");
        consulta.append("       AND vex.sbti_oid_subt_clie = vextc.sbti_oid_subt_clie ");
        consulta.append("       AND vex.tccl_oid_tipo_clas = vextc.tccl_oid_tipo_clas ");
        consulta.append("       AND vex.clas_oid_clas = vextc.clas_oid_clas ");
        consulta.append("  GROUP BY ofer_oid_ofer) ventaex ");
        // Fin dmorello
        
        consulta.append(" WHERE ");

        if (periodo != null) {
            consulta.append(" pe.OID_PERI = ? AND ");
            parametros.add(periodo);
        }

        consulta.append(" pe.PERI_OID_PERI = pc.OID_PERI AND ");
        consulta.append(" pe.CANA_OID_CANA = ca.OID_CANA AND ");
        consulta.append(" mc.PERD_OID_PERI = pe.OID_PERI AND ");
        consulta.append(" mf.MFCA_OID_CABE = mc.OID_CABE AND ");
        consulta.append(" mf.OFDE_OID_DETA_OFER = od.OID_DETA_OFER AND ");
        consulta.append(" od.PROD_OID_PROD = mp.OID_PROD AND ");
        consulta.append(" od.TOFE_OID_TIPO_OFER = tof.OID_TIPO_OFER ");

        /*20090831 SICC-GCC-INT-DAT-2009-001 DAT-11 Retirar Flitro de eventualidad
        //<inicio>incidencia SiCC-20070218, se cambia fechaUltimoProceso a formato fecha (yyyy-MM-dd)
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (fechaUltimoProceso != null) {
            //la fecha del DTO siempre sera java.util.Date
            //java.sql.Date fechaDesde = new java.sql.Date(fechaUltimoProceso.getTime());
            //String sFechaDesde = sdf.format(fechaDesde);
            consulta.append(" AND (od.FEC_ULTI_ACTU >= TO_DATE( ? ,'YYYY-MM-DD') ) ");
            parametros.add(formateaFecha(fechaUltimoProceso));
        }
        //<fin>incidencia SiCC-20070218
        */

        // Cambio SiCC 20070511 - dmorello
        consulta.append(" AND od.ofer_oid_ofer = ventaex.ofer_oid_ofer (+)");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        ArrayList retorno = new ArrayList();

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString().toUpperCase(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMatrizCampania: Exception", e);
            this.logSql(" obtenerMatrizCampania. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        if (rs != null) {
            int tamano = rs.getRowCount();

            for (int i = 0; i < tamano; i++) {
                DTOINTMatrizCampania matrizCampania = new DTOINTMatrizCampania();

                if (rs.getValueAt(i, "ANIOCAMPANIA") != null) {
                    matrizCampania.setAnioCampania(rs.getValueAt(i, "ANIOCAMPANIA").toString());
                }

                if (rs.getValueAt(i, "CODIGOCANAL") != null) {
                    matrizCampania.setCodigoCanal(rs.getValueAt(i, "CODIGOCANAL").toString());
                }

                if (rs.getValueAt(i, "CODIGOPRODUCTO") != null) {
                    matrizCampania.setCodigoProducto(rs.getValueAt(i, "CODIGOPRODUCTO").toString());
                }

                if (rs.getValueAt(i, "CODIGOTIPOOFERTA") != null) {
                    matrizCampania.setCodigoTipoOferta(rs.getValueAt(i, "CODIGOTIPOOFERTA").toString());
                }

                if (rs.getValueAt(i, "CODIGOVENTA") != null) {
                    matrizCampania.setCodigoVenta(rs.getValueAt(i, "CODIGOVENTA").toString());
                }

                if (rs.getValueAt(i, "DESCRIPCIONTIPOOFERTA") != null) {
                    matrizCampania.setDescripcionTipoOferta(rs.getValueAt(i, "DESCRIPCIONTIPOOFERTA").toString());
                }

                if (rs.getValueAt(i, "FLAGESTADISTICABLE") != null) {
                    matrizCampania.setFlagEstadisticable(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGESTADISTICABLE")).intValue()));
                }

                if (rs.getValueAt(i, "PRECIOOFERTA") != null) {
                    matrizCampania.setPrecioOferta((BigDecimal) rs.getValueAt(i, "PRECIOOFERTA"));
                }

                // Cambio SiCC 20070511 - dmorello
                if (rs.getValueAt(i, "FLAGPERTENECEPROGSESSIONEXPERT") != null) {
                    matrizCampania.setFlagPerteneceProgramaSessionExpert(rs.getValueAt(i, "FLAGPERTENECEPROGSESSIONEXPERT").toString());
                }

                // SBUCHELLI
                if (rs.getValueAt(i, "PRECIOVENTA") != null) {
                    matrizCampania.setPrecioVenta((BigDecimal) rs.getValueAt(i, "PRECIOVENTA"));
                }
                if (rs.getValueAt(i, "PRECIOVENTANORMAL") != null) {
                    matrizCampania.setPrecioVentaNormal((BigDecimal) rs.getValueAt(i, "PRECIOVENTANORMAL"));
                }                

                retorno.add(matrizCampania);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerMatrizCampania(Long periodo, java.util.Date fechaUltimoProceso, Long idioma): Salida");

        return retorno;
    }

    public ArrayList obtenerCampanias(Long pais, Long canal, Long marca, Integer anio) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerCampanias(Long pais, Long canal, Long marca, Integer anio): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT PCOR.COD_PERI CODIGOPERIODO, PER.FEC_INIC FECHAINICIO ");
        consulta.append(" FROM CRA_PERIO PER, SEG_PERIO_CORPO PCOR ");
        consulta.append(" WHERE PER.PERI_OID_PERI = PCOR.OID_PERI ");
        consulta.append(" AND PER.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND PER.CANA_OID_CANA = ? ");
        parametros.add(canal);
        consulta.append(" AND PER.MARC_OID_MARC = ? ");
        parametros.add(marca);
        consulta.append(" AND PCOR.VAL_ANIO = ? "); // INCIDENCIA 15919
        parametros.add(anio);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerCampanias: Exception", e);
            this.logSql(" obtenerCampanias. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList campanias = new ArrayList();

        if (rs != null) {
            int numResultados = rs.getRowCount();

            for (int i = 0; i < numResultados; i++) {
                DTOINTCampaniaAnio dtointCampaniaAnio = new DTOINTCampaniaAnio();

                if (rs.getValueAt(i, "CODIGOPERIODO") != null) {
                    dtointCampaniaAnio.setCodigoPeriodo((String) rs.getValueAt(i, "CODIGOPERIODO"));
                }

                if (rs.getValueAt(i, "FECHAINICIO") != null) {
                    dtointCampaniaAnio.setFechaInicio(new java.util.Date(((java.sql.Date) rs.getValueAt(i, "FECHAINICIO")).getTime()));
                }

                campanias.add(dtointCampaniaAnio);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerCampanias(Long pais, Long canal, Long marca, Integer anio): Salida");

        return campanias;
    }

    public ArrayList obtenerSaldosCobranzas(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Long[] oidCargosDirectos, Long[] oidAnulacionesCreditos) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerSaldosCobranzas(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Long[] oidCargosDirectos, Long[] oidAnulacionesCreditos): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        /*consulta.append(" SELECT PAI.COD_PAIS CODIGOPAIS, ZON.COD_ZONA CODIGOZONA, ");
        consulta.append(" CLI.OID_CLIE OIDCLIENTE, CLI.COD_CLIE CODIGOCLIENTE, ");
        consulta.append(" DECODE(SUM(CAD.IMP),NULL, 0, SUM(CAD.IMP)) TOTALCARGOSDIRECTOS, ");
        consulta.append(" DECODE(SUM(CAD2.IMP),NULL, 0, SUM(CAD2.IMP))  TOTALAJUSTESNOTASCREDITOS, ");
        consulta.append(" DECODE(SUM(MCC.IMP_PEND),NULL, 0, SUM(MCC.IMP_PEND)) TOTALDEPURACIONES, ");
        consulta.append(" DECODE(SUM(MCC2.IMP_PAGO),NULL, 0, SUM(MCC2.IMP_PAGO)) ABONOSMONETARIOS21DIAS, ");
        consulta.append(" DECODE(SUM(MCC3.IMP_PAGO),NULL, 0, SUM(MCC3.IMP_PAGO)) ABONOSMONETARIOS31DIAS, ");
        consulta.append(" DECODE(SUM(MCC6.IMP_PAGO),NULL, 0, SUM(MCC6.IMP_PAGO)) ABONOSMONETARIOS42DIAS, ");
        consulta.append(" DECODE(SUM(MCC4.IMP_PAGO),NULL, 0, SUM(MCC4.IMP_PAGO)) ABONOSMONETARIOS63DIAS, ");
        consulta.append(" DECODE(SUM(MCC5.IMP_PAGO),NULL, 0, SUM(MCC5.IMP_PAGO)) ABONOSMONETARIOSMAYORES63DIAS ");
        consulta.append(" FROM  MAE_CLIEN_UNIDA_ADMIN ADM,  MAE_CLIEN CLI, ");
        consulta.append(" CRA_PERIO PER, ZON_TERRI_ADMIN TAD, ZON_SECCI SECC, ");
        consulta.append(" SEG_PAIS PAI, SEG_MARCA MARC, SEG_CANAL CANA, ");
        consulta.append(" ZON_ZONA ZON, CCC_DETAL_CARGO_ABONO_DIREC CAD, ");
        consulta.append(" CCC_DETAL_CARGO_ABONO_DIREC CAD2, ");
        consulta.append(" CCC_TIPO_ABONO_SUBPR TAB, CCC_TIPO_ABONO_SUBPR TAB2, ");
        consulta.append(" CCC_TIPO_CARGO_ABONO TCAB, CCC_TIPO_CARGO_ABONO TCAB2, ");
        consulta.append(" INT_TIPOS_ABONO_DAT TABD, INT_TIPOS_ABONO_DAT TABD2, ");
        consulta.append(" CCC_MOVIM_CUENT_CORRI MCC, CCC_MOVIM_CUENT_CORRI MCC2, ");
        consulta.append(" CCC_MOVIM_CUENT_CORRI MCC3, CCC_MOVIM_CUENT_CORRI MCC4, ");
        consulta.append(" CCC_MOVIM_CUENT_CORRI MCC5, CCC_MOVIM_CUENT_CORRI MCC6, ");
        consulta.append(" CCC_MARCA_SITUA MSI, CCC_HISTO_MOVIM_CC HMOV, ");
        consulta.append(" CCC_HISTO_MOVIM_CC HMOV2, CCC_HISTO_MOVIM_CC HMOV3, ");
        consulta.append(" CCC_HISTO_MOVIM_CC HMOV4, CCC_HISTO_MOVIM_CC HMOV5 ");
        consulta.append(" WHERE  ADM.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND ADM.PERD_OID_PERI_INI = PER.OID_PERI ");
        consulta.append(" AND ADM.ZTAD_OID_TERR_ADMI = TAD.OID_TERR_ADMI ");
        consulta.append(" AND TAD.PAIS_OID_PAIS = PAI.OID_PAIS ");
        consulta.append(" AND TAD.MARC_OID_MARC = MARC.OID_MARC ");
        consulta.append(" AND TAD.CANA_OID_CANA = CANA.OID_CANA ");
        consulta.append(" AND TAD.ZSCC_OID_SECC = SECC.OID_SECC ");
        consulta.append(" AND SECC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        consulta.append(" AND CAD.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND CAD2.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND CAD.TASP_OID_TIPO_ABON_SUBP = TAB.OID_TIPO_ABON_SUBP ");
        consulta.append(" AND CAD2.TASP_OID_TIPO_ABON_SUBP = TAB2.OID_TIPO_ABON_SUBP ");
        consulta.append(" AND TAB.TCAB_OID_TCAB = TCAB.OID_TIPO_CARG_ABON ");
        consulta.append(" AND TAB2.TCAB_OID_TCAB = TCAB2.OID_TIPO_CARG_ABON ");
        consulta.append(" AND TABD.TCAB_OID_TIPO_CARG_ABON = TCAB.OID_TIPO_CARG_ABON ");
        consulta.append(" AND TABD2.TCAB_OID_TIPO_CARG_ABON = TCAB2.OID_TIPO_CARG_ABON ");
        consulta.append(" AND MCC.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND MCC2.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND MCC3.CLIE_OID_CLIE = CLI.OID_CLIE");
        consulta.append(" AND MCC4.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND MCC5.CLIE_OID_CLIE = CLI.OID_CLIE");
        consulta.append(" AND MCC6.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND MCC.MASI_OID_MARC_SITU = MSI.OID_MARC_SITU ");
        consulta.append(" AND HMOV.MVCC_OID_MOVI_CC = MCC2.OID_MOVI_CC ");
        consulta.append(" AND HMOV.IMP_PAGO <> 0 ");

        String sfechaFac = null;
        if(fechaFacturacion!=null){
            //la fecha del DTO siempre sera java.util.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fechaFac = new java.sql.Date(fechaFacturacion.getTime());
            sfechaFac = sdf.format(fechaFac);
            consulta.append(" AND (HMOV.FEC_MOVI = TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sfechaFac);
        }
        consulta.append(" AND (HMOV.FEC_MOVI - HMOV.FEC_DOCU) <= 21 ");
        consulta.append(" AND HMOV2.MVCC_OID_MOVI_CC = MCC3.OID_MOVI_CC ");
        consulta.append(" AND HMOV2.IMP_PAGO <> 0 ");
        if(sfechaFac!=null){
            consulta.append(" AND (HMOV2.FEC_MOVI = TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sfechaFac);
        }
        consulta.append(" AND (HMOV2.FEC_MOVI - HMOV2.FEC_DOCU) > 21 ");
        consulta.append(" AND (HMOV2.FEC_MOVI - HMOV2.FEC_DOCU) <= 31 ");
        consulta.append(" AND HMOV3.MVCC_OID_MOVI_CC = MCC4.OID_MOVI_CC ");
        consulta.append(" AND HMOV3.IMP_PAGO <> 0 ");
        if(sfechaFac!=null){
            consulta.append(" AND (HMOV3.FEC_MOVI = TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sfechaFac);
        }
        consulta.append(" AND (HMOV3.FEC_MOVI - HMOV3.FEC_DOCU) > 31 ");
        consulta.append(" AND (HMOV3.FEC_MOVI - HMOV3.FEC_DOCU) <= 42 ");
        consulta.append(" AND HMOV4.MVCC_OID_MOVI_CC = MCC5.OID_MOVI_CC ");
        consulta.append(" AND HMOV4.IMP_PAGO <> 0 ");
        if(sfechaFac!=null){
            consulta.append(" AND (HMOV4.FEC_MOVI = TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sfechaFac);
        }
        consulta.append(" AND (HMOV4.FEC_MOVI - HMOV4.FEC_DOCU) > 42 ");
        consulta.append(" AND (HMOV4.FEC_MOVI - HMOV4.FEC_DOCU) <= 63 ");
        consulta.append(" AND HMOV5.MVCC_OID_MOVI_CC = MCC6.OID_MOVI_CC ");
        consulta.append(" AND HMOV5.IMP_PAGO <> 0 ");
        if(sfechaFac!=null){
            consulta.append(" AND (HMOV5.FEC_MOVI = TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sfechaFac);
        }
        consulta.append(" AND (HMOV5.FEC_MOVI - HMOV5.FEC_DOCU) > 63 ");
        if(pais!=null){
            consulta.append(" AND CLI.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }
        if(marca!=null){
            consulta.append(" AND PER.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }
        if(canal!=null){
            consulta.append(" AND PER.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
        if(indicadorActivo!=null){
            consulta.append(" AND ADM.IND_ACTI = ? ");
            parametros.add(indicadorActivo);
        }
        consulta.append(" AND TABD.IND_INDI = ? ");
        parametros.add(CCCConstantes.TIPO_ABONO_CARGO_DIRECTO);
        consulta.append(" AND ( TABD2.IND_INDI = ? ");
        parametros.add(CCCConstantes.TIPO_ABONO_AJUSTE);
        consulta.append("       OR TABD2.IND_INDI = ? ) ");
        parametros.add(CCCConstantes.TIPO_ABONO_NOTA_CREDITO);
        consulta.append(" AND MSI.IND_CUEN_CAST = 1 ");
        consulta.append(" GROUP BY  PAI.COD_PAIS,  ZON.COD_ZONA,  CLI.OID_CLIE,  CLI.COD_CLIE ");*/
        //Modificada consulta por incidencia 18459
        
        
        consulta.append(" SELECT ");
        consulta.append(" ZONA.COD_ZONA,UA_CLIENTE.CLIE_OID_CLIE, ");
        if ((oidCargosDirectos != null) && (oidCargosDirectos.length != 0)) {
            consulta.append(" CA_DIRECTO.IMP CARGOS_DIRECTOS, ");
        }else{
            consulta.append(" 0 CARGOS_DIRECTOS, ");// se envia ceros 
        }
        
        if ((oidAnulacionesCreditos != null) && (oidAnulacionesCreditos.length != 0)){ 
            consulta.append(" AJUSTES_NOTAS_DIRECTO.IMP AJUSTES_NOTAS_CREDITO, ");
        }else{
            consulta.append(" 0 AJUSTES_NOTAS_CREDITO, "); //se envia ceros
        }
        consulta.append(" DEPURACIONES.IMP_PEND DEPURACIONES,ABO_MON_21.IMP_PAGO ");
        consulta.append(" ABONO_MONETARIO_21,ABO_MON_31.IMP_PAGO ABONO_MONETARIO_31,ABO_MON_42.IMP_PAGO ");
        consulta.append(" ABONO_MONETARIO_42,ABO_MON_63.IMP_PAGO ");
        consulta.append(" ABONO_MONETARIO_63,ABO_MON_MAS_63.IMP_PAGO ABONO_MONETARIO_MAYOR_63 ");

        consulta.append(" FROM ");
        consulta.append(" MAE_CLIEN_UNIDA_ADMIN UA_CLIENTE, ");
        consulta.append(" ZON_ZONA ZONA, ");
        consulta.append(" ZON_SECCI SEC, ");
        consulta.append(" ZON_TERRI_ADMIN TA, ");

        /*VISTA PARA OBTENER EL TOTAL DE CARGOS DIRECTOS: AGRUPA POR CLIENTE Y FILTRA POR LOS TIPOS DE ABONO
        SUBPROCESO OBTENIDOS A TRAVES DE LA TABLA INT_TIPOS_ABONO_DAT ABONOS CON IND='C'*/
        /*parametro entrada: oidCargosDirectos*/

        if ((oidCargosDirectos != null) && (oidCargosDirectos.length != 0)) {
            consulta.append(" (SELECT CLIE_OID_CLIE,SUM(IMP) IMP FROM CCC_DETAL_CARGO_ABONO_DIREC WHERE ");
            consulta.append(" TASP_OID_TIPO_ABON_SUBP IN (");

            for (int i = 0; i < oidCargosDirectos.length; i++) {
                if (oidCargosDirectos[i] != null) {
                    consulta.append("?,");
                }

                parametros.add(oidCargosDirectos[i]);
            }

            consulta = new StringBuffer(consulta.substring(0, consulta.length() - 1)); //Quitar la ultima coma.*/          
            consulta.append(") GROUP BY ");
            consulta.append(" CLIE_OID_CLIE) CA_DIRECTO, ");
        } else {
            UtilidadesLog.error(" ERROR***********oidCargosDirectos es NULL ó esta Vacío ********");
        }

        /*VISTA PARA OBTENER EL TOTAL DE AJUSTES Y NOTAS DE CRÉDITO: AGRUPA POR CLIENTE Y FILTRA POR LOS TIPOS DE
        ABONO SUBPROCESO OBTENIDOS A TRAVES DE LA TABLA INT_TIPOS_ABONO_DAT ABONOS CON IND='A' O
         'N'*/
        /* parametro de entrada: oidAnulacionesCreditos*/
        

        if ((oidAnulacionesCreditos != null) && (oidAnulacionesCreditos.length != 0)) {
            consulta.append(" (SELECT CLIE_OID_CLIE,SUM(IMP) IMP FROM CCC_DETAL_CARGO_ABONO_DIREC WHERE ");
            consulta.append(" TASP_OID_TIPO_ABON_SUBP IN (");

            for (int i = 0; i < oidAnulacionesCreditos.length; i++) {
                if (oidAnulacionesCreditos[i] != null) {
                    consulta.append("?,");
                }

                parametros.add(oidAnulacionesCreditos[i]);
            }

            consulta = new StringBuffer(consulta.substring(0, consulta.length() - 1)); //Quitar la ultima coma.*/            
            consulta.append(") GROUP BY ");
            consulta.append(" CLIE_OID_CLIE) AJUSTES_NOTAS_DIRECTO, ");
        } else {
            UtilidadesLog.error(" ERROR***********oidAnulacionesCreditos es NULL ó esta Vacío ********");
        }

        /*VISTA PARA OBTENER EL TOTAL POR DEPURACIONES: AGRUPANDO POR CLIENTE Y FILTRANDO POR LOS QUE TIENEN
        MARCA DE SITUACION EL INDICADOR DE CASTIGADA */
        consulta.append(" (SELECT CC.CLIE_OID_CLIE,SUM(CC.IMP_PEND) IMP_PEND FROM ");
        consulta.append(" CCC_MOVIM_CUENT_CORRI CC,CCC_MARCA_SITUA MS WHERE ");
        consulta.append(" CC.MASI_OID_MARC_SITU=MS.OID_MARC_SITU AND MS.IND_CUEN_CAST=1 GROUP BY ");
        consulta.append(" CC.CLIE_OID_CLIE) DEPURACIONES, ");

        /* VISTA PARA OBTENER LOS ABONOS MONETARIOS A 21 DÍAS: UNE LAS TABLAS DE MOVIMIENTOS EN CUENTAS
        CORRIENTES Y HISTORICO DE MOVIMIENTOS EN CUENTA CORRIENTO OBTENIENDO LOS MOVIMIENTO CUYA FECHA
        DE ULTIMO MOVIMIENTO ES LA FECHA RECIBIDA COMO PARAMETRO. FILTRA POR LO QUE LA FECHA DE
        MOVIMIENTO - FECHA DE DOCUMENTO ESTA COMPRENDIDO ENTRE LOS DIAS DEFINIDOS, AGRUPANDO POR
        CLIENTE*/
        consulta.append(" (SELECT CLIE_OID_CLIE,SUM(IMP_PAGO) IMP_PAGO FROM ");
        consulta.append(" (SELECT ");
        consulta.append(" CC.CLIE_OID_CLIE,CC.IMP_PAGO,TRUNC(CC.FEC_ULTI_MOVI,'DDD')-TRUNC(CC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC WHERE CC.IMP_PAGO IS NOT NULL AND ");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaSQL = new java.sql.Date(fechaFacturacion.getTime());
        String fechaFacturacionS = sdf.format(fechaSQL);

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append("     UNION ");
        consulta.append(" SELECT ");
        consulta.append(" HCC.CLIE_OID_CLIE,HCC.IMP_PAGO,TRUNC(HCC.FEC_MOVI,'DDD')-TRUNC(HCC.FEC_DOCU,'DDD')");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC,CCC_HISTO_MOVIM_CC HCC WHERE ");
        consulta.append(" HCC.MVCC_OID_MOVI_CC = CC.OID_MOVI_CC AND CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append(" 	) PAGOS ");
        consulta.append("  WHERE DIAS<=21 GROUP BY CLIE_OID_CLIE) ABO_MON_21, ");

        /* VISTA PARA OBTENER LOS ABONOS MONETARIOS A 21 DÍAS: UNE LAS TABLAS DE MOVIMIENTOS EN CUENTAS
        CORRIENTES Y HISTORICO DE MOVIMIENTOS EN CUENTA CORRIENTO OBTENIENDO LOS MOVIMIENTO CUYA FECHA
        DE ULTIMO MOVIMIENTO ES LA FECHA RECIBIDA COMO PARAMETRO. FILTRA POR LO QUE LA FECHA DE
        MOVIMIENTO - FECHA DE DOCUMENTO ESTA COMPRENDIDO ENTRE LOS DIAS DEFINIDOS, AGRUPANDO POR
        CLIENTE*/
        consulta.append("  (SELECT CLIE_OID_CLIE,SUM(IMP_PAGO) IMP_PAGO FROM ");
        consulta.append(" (SELECT  ");
        consulta.append(" CC.CLIE_OID_CLIE,CC.IMP_PAGO,TRUNC(CC.FEC_ULTI_MOVI,'DDD')-TRUNC(CC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC WHERE CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append("     UNION ");
        consulta.append(" SELECT  ");
        consulta.append(" HCC.CLIE_OID_CLIE,HCC.IMP_PAGO,TRUNC(HCC.FEC_MOVI,'DDD')-TRUNC(HCC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC,CCC_HISTO_MOVIM_CC HCC WHERE ");
        consulta.append(" HCC.MVCC_OID_MOVI_CC = CC.OID_MOVI_CC AND CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append(" 	) PAGOS ");
        consulta.append("  WHERE DIAS>21 AND DIAS<=31 GROUP BY CLIE_OID_CLIE) ABO_MON_31, ");

        /* VISTA PARA OBTENER LOS ABONOS MONETARIOS A 21 DÍAS: UNE LAS TABLAS DE MOVIMIENTOS EN CUENTAS
        CORRIENTES Y HISTORICO DE MOVIMIENTOS EN CUENTA CORRIENTO OBTENIENDO LOS MOVIMIENTO CUYA FECHA
        DE ULTIMO MOVIMIENTO ES LA FECHA RECIBIDA COMO PARAMETRO. FILTRA POR LO QUE LA FECHA DE
        MOVIMIENTO - FECHA DE DOCUMENTO ESTA COMPRENDIDO ENTRE LOS DIAS DEFINIDOS , AGRUPANDO POR
        CLIENTE*/
        consulta.append("  (SELECT CLIE_OID_CLIE,SUM(IMP_PAGO) IMP_PAGO FROM ");
        consulta.append(" (SELECT ");
        consulta.append(" CC.CLIE_OID_CLIE,CC.IMP_PAGO,TRUNC(CC.FEC_ULTI_MOVI,'DDD')-TRUNC(CC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC WHERE CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append("     UNION ");
        consulta.append(" SELECT ");
        consulta.append(" HCC.CLIE_OID_CLIE,HCC.IMP_PAGO,TRUNC(HCC.FEC_MOVI,'DDD')-TRUNC(HCC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC,CCC_HISTO_MOVIM_CC HCC WHERE ");
        consulta.append(" HCC.MVCC_OID_MOVI_CC = CC.OID_MOVI_CC AND CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append(" 	) PAGOS ");
        consulta.append("  WHERE DIAS>31 AND DIAS<=42 GROUP BY CLIE_OID_CLIE) ABO_MON_42, ");

        /* VISTA PARA OBTENER LOS ABONOS MONETARIOS A 21 DÍAS: UNE LAS TABLAS DE MOVIMIENTOS EN CUENTAS
        CORRIENTES Y HISTORICO DE MOVIMIENTOS EN CUENTA CORRIENTO OBTENIENDO LOS MOVIMIENTO CUYA FECHA
        DE ULTIMO MOVIMIENTO ES LA FECHA RECIBIDA COMO PARAMETRO. FILTRA POR LO QUE LA FECHA DE
        MOVIMIENTO - FECHA DE DOCUMENTO ESTA COMPRENDIDO ENTRE LOS DIAS DEFINIDOS , AGRUPANDO POR
        CLIENTE*/
        consulta.append("  (SELECT CLIE_OID_CLIE,SUM(IMP_PAGO) IMP_PAGO FROM ");
        consulta.append(" (SELECT ");
        consulta.append(" CC.CLIE_OID_CLIE,CC.IMP_PAGO,TRUNC(CC.FEC_ULTI_MOVI,'DDD')-TRUNC(CC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC WHERE CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append("     UNION ");
        consulta.append(" SELECT ");
        consulta.append(" HCC.CLIE_OID_CLIE,HCC.IMP_PAGO,TRUNC(HCC.FEC_MOVI,'DDD')-TRUNC(HCC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC,CCC_HISTO_MOVIM_CC HCC WHERE ");
        consulta.append(" HCC.MVCC_OID_MOVI_CC = CC.OID_MOVI_CC AND CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append(" 	) PAGOS ");
        consulta.append("  WHERE DIAS>42 AND DIAS<=63 GROUP BY CLIE_OID_CLIE) ABO_MON_63, ");

        /* VISTA PARA OBTENER LOS ABONOS MONETARIOS A 21 DÍAS: UNE LAS TABLAS DE MOVIMIENTOS EN CUENTAS
        CORRIENTES Y HISTORICO DE MOVIMIENTOS EN CUENTA CORRIENTO OBTENIENDO LOS MOVIMIENTO CUYA FECHA
        DE ULTIMO MOVIMIENTO ES LA FECHA RECIBIDA COMO PARAMETRO. FILTRA POR LO QUE LA FECHA DE
        MOVIMIENTO - FECHA DE DOCUMENTO ESTA COMPRENDIDO ENTRE LOS DIAS DEFINIDOS , AGRUPANDO POR
        CLIENTE*/
        consulta.append("  (SELECT CLIE_OID_CLIE,SUM(IMP_PAGO) IMP_PAGO FROM ");
        consulta.append(" (SELECT ");
        consulta.append(" CC.CLIE_OID_CLIE,CC.IMP_PAGO,TRUNC(CC.FEC_ULTI_MOVI,'DDD')-TRUNC(CC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC WHERE CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append("     UNION ");
        consulta.append(" SELECT ");
        consulta.append(" HCC.CLIE_OID_CLIE,HCC.IMP_PAGO,TRUNC(HCC.FEC_MOVI,'DDD')-TRUNC(HCC.FEC_DOCU,'DDD') ");
        consulta.append(" DIAS FROM CCC_MOVIM_CUENT_CORRI CC,CCC_HISTO_MOVIM_CC HCC WHERE ");
        consulta.append(" HCC.MVCC_OID_MOVI_CC = CC.OID_MOVI_CC AND CC.IMP_PAGO IS NOT NULL AND ");

        if (fechaFacturacion != null) {
            consulta.append(" CC.IMP_PAGO <>0 AND TRUNC(CC.FEC_ULTI_MOVI,'DDD')= TO_DATE(?, 'YYYY-MM-DD') "); /*FECHA FACTURACION */
            parametros.add(fechaFacturacionS);
        }

        consulta.append(" 	) PAGOS ");
        consulta.append("  WHERE DIAS>63 GROUP BY CLIE_OID_CLIE) ABO_MON_MAS_63 ");
        consulta.append(" WHERE ");

        /* FILTROS PARA OBTENER LAS ZONAS Y LOS CLIENTES*/
        consulta.append(" ZONA.OID_ZONA=SEC.ZZON_OID_ZONA ");
        consulta.append(" AND SEC.OID_SECC= TA.ZSCC_OID_SECC ");
        consulta.append(" AND TA.OID_TERR_ADMI=UA_CLIENTE.ZTAD_OID_TERR_ADMI ");
        
        // Eliminacion by ssantana, 9/9/2005, a pedido de JRivas (Peru)
        // consulta.append(" AND UA_CLIENTE.IND_ACTI=1 ");
        // Fin eliminacion by ssantana, 9/9/2005

        if (canal != null) {
            consulta.append(" AND ZONA.CANA_OID_CANA= ? "); /*PARAMETRO DE ENTRADA: CANAL*/
            parametros.add(canal);
        }

        if (marca != null) {
            consulta.append(" AND ZONA.MARC_OID_MARC= ? "); /*PARAMETRO DE ENTRADA: MARCA*/
            parametros.add(marca);
        }

        if (pais != null) {
            consulta.append(" AND ZONA.PAIS_OID_PAIS= ? "); /*PARAMETRO DE ENTRADA: PAIS*/
            parametros.add(pais);
        }

        /* FILTROS PARA HACER LOS JOIN CON LAS DIFERENTES VISTAS OBTENIDAS */
        if ((oidCargosDirectos != null) && (oidCargosDirectos.length != 0)) {
            consulta.append(" AND CA_DIRECTO.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");
        }
        if ((oidAnulacionesCreditos != null) && (oidAnulacionesCreditos.length != 0)) {
            consulta.append(" AND AJUSTES_NOTAS_DIRECTO.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");
        }
        consulta.append(" AND DEPURACIONES.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");
        consulta.append(" AND ABO_MON_21.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");
        consulta.append(" AND ABO_MON_31.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");
        consulta.append(" AND ABO_MON_42.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");
        consulta.append(" AND ABO_MON_63.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");
        consulta.append(" AND ABO_MON_MAS_63.CLIE_OID_CLIE (+) = UA_CLIENTE.CLIE_OID_CLIE ");

        //MUY IMPORTANTE ORDENAR POR ZONA PARA LUEGO PODER AGRUPAR EN enviarSaldosCobranzas del Mon.
        consulta.append(" ORDER BY ZONA.COD_ZONA  ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerSaldosCobranzas: Exception", e);
            this.logSql(" obtenerSaldosCobranzas. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTOINTCobranza dtoCobranza = new DTOINTCobranza();

                if (rs.getValueAt(i, "ABONO_MONETARIO_21") != null) {
                    dtoCobranza.setAbonosMonetarios21Dias((BigDecimal) rs.getValueAt(i, "ABONO_MONETARIO_21"));
                }

                if (rs.getValueAt(i, "ABONO_MONETARIO_31") != null) {
                    dtoCobranza.setAbonosMonetarios31Dias((BigDecimal) rs.getValueAt(i, "ABONO_MONETARIO_31"));
                }

                if (rs.getValueAt(i, "ABONO_MONETARIO_42") != null) {
                    dtoCobranza.setAbonosMonetarios42Dias((BigDecimal) rs.getValueAt(i, "ABONO_MONETARIO_42"));
                }

                if (rs.getValueAt(i, "ABONO_MONETARIO_63") != null) {
                    dtoCobranza.setAbonosMonetarios63Dias((BigDecimal) rs.getValueAt(i, "ABONO_MONETARIO_63"));
                }

                if (rs.getValueAt(i, "ABONO_MONETARIO_MAYOR_63") != null) {
                    dtoCobranza.setAbonosMonetariosMayores63Dias((BigDecimal) rs.getValueAt(i, "ABONO_MONETARIO_MAYOR_63"));
                }

                if (rs.getValueAt(i, "COD_ZONA") != null) {
                    dtoCobranza.setCodigoZona(rs.getValueAt(i,"COD_ZONA").toString());
                }

                /*if(rs.getValueAt(i,"CODIGOPAIS") != null){
                    dtoCobranza.setCodigoPais(rs.getValueAt(i, "CODIGOPAIS").toString());
                }*/
                if (rs.getValueAt(i, "CLIE_OID_CLIE") != null) {
                    dtoCobranza.setOidCliente(new Long(((BigDecimal) rs.getValueAt(i, "CLIE_OID_CLIE")).longValue()));
                }

                /*if(rs.getValueAt(i,"CODIGOCLIENTE") != null){
                    dtoCobranza.setCodigoCliente(rs.getValueAt(i, "CODIGOCLIENTE").toString());
                }*/
                if (rs.getValueAt(i, "AJUSTES_NOTAS_CREDITO") != null) {
                    dtoCobranza.setTotalAjustesNotasCreditos((BigDecimal) rs.getValueAt(i, "AJUSTES_NOTAS_CREDITO"));
                }

                if (rs.getValueAt(i, "CARGOS_DIRECTOS") != null) {
                    dtoCobranza.setTotalCargosDirectos((BigDecimal) rs.getValueAt(i, "CARGOS_DIRECTOS"));
                }

                if (rs.getValueAt(i, "DEPURACIONES") != null) {
                    dtoCobranza.setTotalDepuraciones((BigDecimal) rs.getValueAt(i, "DEPURACIONES"));
                }

                lista.add(dtoCobranza);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerSaldosCobranzas(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Long[] oidCargosDirectos, Long[] oidAnulacionesCreditos): Salida");

        return lista;
    }

    public ArrayList obtenerProductosReemplazo(Long pais, Long canal, Long marca, Long periodo, java.util.Date fechaUltimaEjecucion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerProductosReemplazo(Long pais, Long canal, Long marca, Long periodo, java.util.Date fechaUltimaEjecucion): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT CANA.COD_CANA CODIGOCANALVENTA, PCOR.COD_PERI ANIOCAMPANIA, ");
        consulta.append(" PRO1.COD_SAP CODIGOPRODUCTOREEMPLAZADO, TOF1.COD_TIPO_OFER CODIGOTIPOOFERTAREEMPLAZADO, ");

        //consulta.append(" OFD1.COD_VENT CODIGOVENTAREEMPLAZADO, ");
        consulta.append(" OFD1.VAL_CODI_VENT CODIGOVENTAREEMPLAZADO, ");

        consulta.append(" PRO2.COD_SAP CODIGOPRODUCTOREEMPLAZO, ");
        consulta.append(" TOF2.COD_TIPO_OFER CODIGOTIPOOFERTAREEMPLAZO, ");

        //consulta.append(" OFD2.COD_VENT CODIGOVENTAREEMPLAZO, ");
        consulta.append(" OFD2.VAL_CODI_VENT CODIGOVENTAREEMPLAZO, ");

        consulta.append(" PRO1.DES_CORT DESCRIPCIONPRODUCTOREEMPLAZADO, PRO2.DES_CORT DESCRIPCIONPRODUCTOREEMPLAZO ");
        consulta.append(" FROM PRE_MATRI_REEMP MRE, PRE_MATRI_FACTU MFAC, PRE_MATRI_FACTU MFACR, ");
        consulta.append(" PRE_MATRI_FACTU_CABEC MFACAB, CRA_PERIO PER, SEG_PERIO_CORPO PCOR, ");
        consulta.append(" SEG_CANAL CANA, MAE_PRODU PRO1, MAE_PRODU PRO2, PRE_OFERT_DETAL OFD1, ");
        consulta.append(" PRE_OFERT_DETAL OFD2, PRE_TIPO_OFERT TOF1, PRE_TIPO_OFERT TOF2 ");
        consulta.append(" WHERE MRE.MAFA_OID_COD_PPAL = MFAC.OID_MATR_FACT ");
        consulta.append(" AND MRE.MAFA_OID_COD_REEM = MFACR.OID_MATR_FACT ");
        consulta.append(" AND MFAC.MFCA_OID_CABE = MFACAB.OID_CABE ");
        consulta.append(" AND MFACAB.PERD_OID_PERI = PER.OID_PERI ");
        consulta.append(" AND PER.CANA_OID_CANA = CANA.OID_CANA ");
        consulta.append(" AND MFAC.OFDE_OID_DETA_OFER = OFD1.OID_DETA_OFER ");
        consulta.append(" AND MFACR.OFDE_OID_DETA_OFER = OFD2.OID_DETA_OFER ");
        consulta.append(" AND OFD1.PROD_OID_PROD = PRO1.OID_PROD ");
        consulta.append(" AND OFD2.PROD_OID_PROD = PRO2.OID_PROD ");
        consulta.append(" AND PER.PERI_OID_PERI = PCOR.OID_PERI ");
        consulta.append(" AND OFD1.TOFE_OID_TIPO_OFER = TOF1.OID_TIPO_OFER ");
        consulta.append(" AND OFD2.TOFE_OID_TIPO_OFER = TOF2.OID_TIPO_OFER ");
        consulta.append(" AND PER.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND PER.CANA_OID_CANA = ? ");
        parametros.add(canal);
        consulta.append(" AND PER.MARC_OID_MARC = ? ");
        parametros.add(marca);

        //BELC300018334
        consulta.append(" AND PER.OID_PERI = ? ");
        parametros.add(periodo);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (fechaUltimaEjecucion != null) {
            java.sql.Date sqlFechaUltimaEjecucion = new java.sql.Date(fechaUltimaEjecucion.getTime());
            String sFechaUltimaEjecucion = sdf.format(sqlFechaUltimaEjecucion);
            consulta.append(" AND (MRE.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) ");
            parametros.add(sFechaUltimaEjecucion);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerProductosReemplazo: Exception", e);
            this.logSql(" obtenerProductosReemplazo. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList productosReemplazo = new ArrayList();

        if (rs != null) {
            int numResultados = rs.getRowCount();

            for (int i = 0; i < numResultados; i++) {
                DTOINTProductoReemplazo dtointProductoReemplazo = new DTOINTProductoReemplazo();

                if (rs.getValueAt(i, "CODIGOCANALVENTA") != null) {
                    dtointProductoReemplazo.setCodigoCanalVenta((String) rs.getValueAt(i, "CODIGOCANALVENTA"));
                }

                if (rs.getValueAt(i, "ANIOCAMPANIA") != null) {
                    dtointProductoReemplazo.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIA"));
                }

                if (rs.getValueAt(i, "CODIGOPRODUCTOREEMPLAZADO") != null) {
                    dtointProductoReemplazo.setCodigoProductoReemplazado((String) rs.getValueAt(i, "CODIGOPRODUCTOREEMPLAZADO"));
                }

                if (rs.getValueAt(i, "CODIGOTIPOOFERTAREEMPLAZADO") != null) {
                    dtointProductoReemplazo.setCodigoTipoOfertaReemplazado((String) rs.getValueAt(i, "CODIGOTIPOOFERTAREEMPLAZADO"));
                }

                if (rs.getValueAt(i, "CODIGOVENTAREEMPLAZADO") != null) {
                    dtointProductoReemplazo.setCodigoVentaReemplazado((String) rs.getValueAt(i, "CODIGOVENTAREEMPLAZADO"));
                }

                if (rs.getValueAt(i, "CODIGOPRODUCTOREEMPLAZO") != null) {
                    dtointProductoReemplazo.setCodigoProductoReemplazo((String) rs.getValueAt(i, "CODIGOPRODUCTOREEMPLAZO"));
                }

                if (rs.getValueAt(i, "CODIGOTIPOOFERTAREEMPLAZO") != null) {
                    dtointProductoReemplazo.setCodigoTipoOfertaReemplazo((String) rs.getValueAt(i, "CODIGOTIPOOFERTAREEMPLAZO"));
                }

                if (rs.getValueAt(i, "CODIGOVENTAREEMPLAZO") != null) {
                    dtointProductoReemplazo.setCodigoVentaReemplazo((String) rs.getValueAt(i, "CODIGOVENTAREEMPLAZO"));
                }

                if (rs.getValueAt(i, "DESCRIPCIONPRODUCTOREEMPLAZADO") != null) {
                    dtointProductoReemplazo.setDescripcionProductoReemplazado((String) rs.getValueAt(i, "DESCRIPCIONPRODUCTOREEMPLAZADO"));
                }

                if (rs.getValueAt(i, "DESCRIPCIONPRODUCTOREEMPLAZO") != null) {
                    dtointProductoReemplazo.setDescripcionProductoReemplazo((String) rs.getValueAt(i, "DESCRIPCIONPRODUCTOREEMPLAZO"));
                }

                productosReemplazo.add(dtointProductoReemplazo);
            } //for
        } //if(rs != null)

        UtilidadesLog.info("DAOINTDAT.obtenerProductosReemplazo(Long pais, Long canal, Long marca, Long periodo, java.util.Date fechaUltimaEjecucion): Salida");

        return productosReemplazo;
    }

    public ArrayList obtenerTiposOferta(Long idioma, Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerTiposOferta(Long idioma, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT CANA.COD_CANA CODIGOCANAL, TOF.COD_TIPO_OFER CODIGOTIPOOFERTA, ");
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PRE_TIPO_OFERT' AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append(" AND idio.VAL_OID = TOF.OID_TIPO_OFER ) DESCTIPOOFERTA, ");
        consulta.append(" TOF.VAL_FORM_VENT CODIGOTIPOPROFIT ");
        consulta.append(" FROM PRE_TIPO_OFERT TOF, SEG_CANAL CANA ");
        consulta.append(" WHERE TOF.CANA_OID_CANA = CANA.OID_CANA ");
        consulta.append(" AND TOF.CANA_OID_CANA= ? ");
        parametros.add(canal);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerTiposOferta: Exception", e);
            this.logSql(" obtenerTiposOferta. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList tiposOfertas = new ArrayList();

        if (rs != null) {
            int numResultados = rs.getRowCount();

            for (int i = 0; i < numResultados; i++) {
                DTOINTTipoOferta dtointTipoOferta = new DTOINTTipoOferta();

                if (rs.getValueAt(i, "CODIGOCANAL") != null) {
                    dtointTipoOferta.setCodigoCanal((String) rs.getValueAt(i, "CODIGOCANAL"));
                }

                if (rs.getValueAt(i, "CODIGOTIPOOFERTA") != null) {
                    dtointTipoOferta.setCodigoTipoOferta((String) rs.getValueAt(i, "CODIGOTIPOOFERTA"));
                }

                if (rs.getValueAt(i, "DESCTIPOOFERTA") != null) {
                    dtointTipoOferta.setDescripcionTipoOferta((String) rs.getValueAt(i, "DESCTIPOOFERTA"));
                }

                if (rs.getValueAt(i, "CODIGOTIPOPROFIT") != null) {
                    dtointTipoOferta.setCodigoTipoProfit(rs.getValueAt(i, "CODIGOTIPOPROFIT").toString());
                }

                tiposOfertas.add(dtointTipoOferta);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerTiposOferta(Long idioma, Long canal): Salida");

        return tiposOfertas;
    }

    public ArrayList obtenerEstatusZona(Long pais, Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerEstatusZona(Long pais, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT EST.COD_ESTA_ZONA CODIGOESTATUSZONA,(Select idio.VAL_I18N ");
        consulta.append("                                            From V_GEN_I18N_SICC idio ");
        consulta.append("                                            Where idio.ATTR_ENTI = 'ZON_ESTAD_ZONA' ");
        consulta.append("                                            And idio.IDIO_OID_IDIO = ? ");
        consulta.append("                                            And idio.VAL_OID = EST.OID_ESTA_ZONA) As DESCRIPCIONESTATUSZONA ");
        parametros.add(idioma);
        consulta.append(" FROM ZON_ESTAD_ZONA EST ");
        consulta.append(" WHERE PAIS_OID_PAIS = ? ");
        parametros.add(pais);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerEstatusZona: Exception", e);
            this.logSql(" obtenerEstatusZona. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTOINTEstatusZona dto = new DTOINTEstatusZona();

                if (rs.getValueAt(i, 0) != null) {
                    dto.setCodigoEstatusZona(rs.getValueAt(i, "CODIGOESTATUSZONA").toString());
                }

                if (rs.getValueAt(i, 1) != null) {
                    dto.setDescripcionEstatusZona(rs.getValueAt(i, "DESCRIPCIONESTATUSZONA").toString());
                }

                lista.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerEstatusZona(Long pais, Long idioma): Salida");

        return lista;
    }

    /**
     * 18-09-2007       Modificado por Sapaza, cambio Sicc20070392. Para el caso que la fecha de Facturación 
     *                  es mayor a la Fecha Disponible, se trae los registros que fecha UltActualizacion > fechaUltProcInterfaces,
     *                  ademas se recupera el oid de la entidad AptaCurso, para utilizarlo en la actualizacion del indicador enviado.
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param fechaUltProcStr
     * @param fechaUltProc
     * @param tipoCliente
     * @param fechaFacturacion
     * @param canal
     * @param marca
     * @param pais
     */
    public ArrayList obtenerCursos(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Long tipoCliente, java.util.Date fechaUltProc, String fechaUltProcStr ) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerCursos(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Long tipoCliente): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        //BELC300018261 
        consulta.append(" SELECT MCUR.FEC_DISP_CURS FECHACONCRETACURSO, PCUR.OID_CABE CODIGOPLANTILLA,  ");
        consulta.append("        MCUR.COD_CURS CODIGOCURSO, TCUR.COD_TIPO_CURS TIPOCURSO  ");
        consulta.append(" FROM   EDU_MATRI_CURSO MCUR, EDU_TIPO_CURSO TCUR,  ");
        consulta.append("        EDU_PLANT_CURSO_CABEC PCUR  ");
        consulta.append(" WHERE  ");
        consulta.append("        MCUR.TICU_OID_TIPO_CURS = TCUR.OID_TIPO_CURS AND MCUR.CPLC_OID_CABE_PLAN_CURS = PCUR.OID_CABE  ");

        if (pais != null) {
            consulta.append("   AND MCUR.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (marca != null) {
            consulta.append("   AND MCUR.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }

        if (canal != null) {
            consulta.append("   AND MCUR.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }

        if (fechaFacturacion != null) {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime());
            UtilidadesLog.debug(" >>> fechaFacturacion: " + fechaFacturacion );
            UtilidadesLog.debug(" >>> fecha: " + fecha );
            String sFecha = sdf2.format(fecha);
            UtilidadesLog.debug(" >>> sFecha: " + sFecha );
            consulta.append("    AND MCUR.FEC_DISP_CURS <= TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");
            parametros.add(sFecha);
        }

        if (tipoCliente != null) {
            consulta.append("   AND MCUR.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(tipoCliente);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerCursos: Exception", e);
            this.logSql("  obtenerCursos. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch 

        ArrayList listaAptas = new ArrayList();
        ArrayList listaCursosFF = new ArrayList();
        ArrayList listaCursosPRE = new ArrayList();
        DTOINTCurso curso = null;

        //Realizo la separacion por listas 
        if (rs != null) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                curso = new DTOINTCurso();

                if (rs.getValueAt(i, "FECHACONCRETACURSO") != null) {
                    curso.setFechaCurso(new Date(((java.sql.Date) rs.getValueAt(i, "FECHACONCRETACURSO")).getTime()));
                }

                if (rs.getValueAt(i, "CODIGOPLANTILLA") != null) {
                    curso.setCodigoPlantilla(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOPLANTILLA")).longValue()));
                }

                if (rs.getValueAt(i, "CODIGOCURSO") != null) {
                    curso.setCodigoCurso((BigDecimal) rs.getValueAt(i, "CODIGOCURSO") + "");
                }

                if (rs.getValueAt(i, "TIPOCURSO") != null) {
                    curso.setTipoCurso((BigDecimal) rs.getValueAt(i, "TIPOCURSO") + "");
                }

                Date fechaCurso = new Date(((java.sql.Date) rs.getValueAt(i, "FECHACONCRETACURSO")).getTime());
                
                //  Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070122
                //if (fechaFacturacion.compareTo(fechaCurso) == 0) { //BELC300018539 
                if ( fechaFacturacion!=null && fechaUltProc!=null && 
                     ( fechaFacturacion.compareTo(fechaCurso) == 0 || fechaFacturacion.compareTo(fechaCurso) > 0 ) &&
                     fechaUltProc.compareTo(fechaCurso) < 0 ) {
                    listaCursosFF.add(curso);
                } else {
                    if (fechaFacturacion!=null && fechaFacturacion.compareTo(fechaCurso) > 0) {
                        listaCursosPRE.add(curso);
                    }
                }
            }
        }

        //Recorrer la lista CursosFF         
        DTOINTAptaCurso aptaCurso = null;

        for (int i = 0; i < listaCursosFF.size(); i++) {
            curso = (DTOINTCurso) listaCursosFF.get(i);

            consulta.delete(0, consulta.length());
            parametros.clear();

            consulta.append(" SELECT CLI.COD_CLIE CODIGOCLIENTE,APCU.FEC_ASIS FECHAASISTENCIA,APCU.IND_INVI INDICADORINVITADA,APCU.OID_APTA OIDAPTACURSO, ");
            consulta.append("        APCU.NUM_CONV NUMEROCONVOCATORIA,PCOR.COD_PERI PERIODO,TCUR.COD_TIPO_CURS CODIGOTIPOCURSO, ");
            //consulta.append("        CANA.COD_CANA CODIGOCMCURANALVENTA,MCUR.FEC_CONC_CURS FECHACAPACITACION,APCU.IND_ASIS INDICADORASISTENCIA,  ");
            consulta.append("        CANA.COD_CANA CODIGOCANALVENTA,mcur.fec_disp_curs FECHACAPACITACION,APCU.IND_ASIS INDICADORASISTENCIA,  "); // eiraola - Inc.DBLG400000745
            consulta.append("        APCU.IND_INVI FLAGEXTEMPORANEA,APCU.IND_APTA_CURS FLAGAPTA,APCU.NUM_CONV OPCION,MCUR.FEC_FIN_CURS FECHAFINCURSO ");
            consulta.append(" FROM   EDU_APTAS_CURSO APCU,EDU_MATRI_CURSO MCUR,EDU_PLANT_CURSO_CABEC PCUR,MAE_CLIEN CLI,CRA_PERIO PERI, ");
            consulta.append("        SEG_PERIO_CORPO PCOR,EDU_TIPO_CURSO TCUR,SEG_CANAL CANA ");
            consulta.append(" WHERE  APCU.MCUR_OID_CURS = MCUR.OID_CURS AND MCUR.CPLC_OID_CABE_PLAN_CURS = PCUR.OID_CABE ");
            consulta.append("        AND APCU.CLIE_OID_CLIE = CLI.OID_CLIE AND MCUR.PERD_OID_PERI_INGR = PERI.OID_PERI(+) ");
            consulta.append("        AND PERI.PERI_OID_PERI = PCOR.OID_PERI(+) AND MCUR.TICU_OID_TIPO_CURS = TCUR.OID_TIPO_CURS ");
            consulta.append("        AND MCUR.CANA_OID_CANA = CANA.OID_CANA AND IND_PRUE = 0 ");

            if (pais != null) {
                consulta.append("    AND MCUR.PAIS_OID_PAIS = ? ");
                parametros.add(pais);
            }

            if (marca != null) {
                consulta.append("    AND MCUR.MARC_OID_MARC = ? ");
                parametros.add(marca);
            }

            if (canal != null) {
                consulta.append("    AND MCUR.CANA_OID_CANA = ? ");
                parametros.add(canal);
            }

            if (curso.getCodigoPlantilla() != null) {
                consulta.append("    AND PCUR.OID_CABE = ? ");
                parametros.add(curso.getCodigoPlantilla());
            }

            if (curso.getCodigoCurso() != null) {
                consulta.append("    AND MCUR.COD_CURS = ? ");
                parametros.add(curso.getCodigoCurso());
            }

            try {
                rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error("  obtenerCursos: Exception", e);
                this.logSql("  obtenerCursos. SQL: ", consulta.toString(), parametros);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } //catch 

            if (rs != null) {
                for (int j = 0; j < rs.getRowCount(); j++) {
                    aptaCurso = new DTOINTAptaCurso();
                    aptaCurso.setIndicadorFF(Boolean.TRUE);

                    if (rs.getValueAt(j, "CODIGOCLIENTE") != null) {
                        aptaCurso.setCodigoCliente((String) rs.getValueAt(j, "CODIGOCLIENTE"));
                    }

                    if (rs.getValueAt(j, "FECHAASISTENCIA") != null) {
                        aptaCurso.setFechaAsistencia(new Date(((java.sql.Date) rs.getValueAt(j, "FECHAASISTENCIA")).getTime()));
                    }

                    if (rs.getValueAt(j, "INDICADORINVITADA") != null) {
                        aptaCurso.setIndicadorInvitada((BigDecimal) rs.getValueAt(j, "INDICADORINVITADA") + "");
                    }

                    if (rs.getValueAt(j, "NUMEROCONVOCATORIA") != null) {
                        aptaCurso.setNumeroConvocatoria(new Integer(((BigDecimal) rs.getValueAt(j, "NUMEROCONVOCATORIA")).intValue()));
                    }

                    if (rs.getValueAt(j, "PERIODO") != null) {
                        aptaCurso.setPeriodo((String) rs.getValueAt(j, "PERIODO"));
                    }

                    if (rs.getValueAt(j, "CODIGOTIPOCURSO") != null) {
                        aptaCurso.setCodigoTipoCurso((BigDecimal) rs.getValueAt(j, "CODIGOTIPOCURSO") + "");
                    }

                    if (rs.getValueAt(j, "CODIGOCANALVENTA") != null) {
                        aptaCurso.setCodigoCanalVenta((String) rs.getValueAt(j, "CODIGOCANALVENTA"));
                    }

                    if (rs.getValueAt(j, "FECHACAPACITACION") != null) {
                        aptaCurso.setFechaCapacitacion(new Date(((java.sql.Date) rs.getValueAt(j, "FECHACAPACITACION")).getTime()));
                    }

                    if (rs.getValueAt(j, "INDICADORASISTENCIA") != null) {
                        aptaCurso.setIndicadorAsistencia((BigDecimal) rs.getValueAt(j, "INDICADORASISTENCIA") + "");
                    }

                    if (rs.getValueAt(j, "FLAGEXTEMPORANEA") != null) {
                        aptaCurso.setFlagExtemporanea((BigDecimal) rs.getValueAt(j, "FLAGEXTEMPORANEA") + "");
                    }

                    if (rs.getValueAt(j, "FLAGAPTA") != null) {
                        aptaCurso.setFlagApta((BigDecimal) rs.getValueAt(j, "FLAGAPTA") + "");
                    }

                    if (rs.getValueAt(j, "OPCION") != null) {
                        aptaCurso.setOpcion(new Integer(((BigDecimal) rs.getValueAt(j, "OPCION")).intValue()));
                    }

                    if (rs.getValueAt(j, "FECHAFINCURSO") != null) {
                        aptaCurso.setFechaFinCurso(new Date(((java.sql.Date) rs.getValueAt(j, "FECHAFINCURSO")).getTime()));
                    }

                    aptaCurso.setOidAptaCurso(new Long(((BigDecimal) rs.getValueAt(j, "OIDAPTACURSO")).longValue()));

                    listaAptas.add(aptaCurso);
                }
            }
        }

        //Recorrer la lista CursosPRE 
        for (int i = 0; i < listaCursosPRE.size(); i++) {
            curso = (DTOINTCurso) listaCursosPRE.get(i);

            consulta.delete(0, consulta.length());
            parametros.clear();

            consulta.append(" SELECT CLI.COD_CLIE CODIGOCLIENTE,APCU.FEC_ASIS FECHAASISTENCIA,APCU.IND_INVI INDICADORINVITADA,APCU.OID_APTA OIDAPTACURSO, ");
            consulta.append("        APCU.NUM_CONV NUMEROCONVOCATORIA,PCOR.COD_PERI PERIODO,TCUR.COD_TIPO_CURS CODIGOTIPOCURSO, ");
            //consulta.append("        CANA.COD_CANA CODIGOCANALVENTA,MCUR.FEC_CONC_CURS FECHACAPACITACION,APCU.IND_ASIS INDICADORASISTENCIA,  ");
            consulta.append("        CANA.COD_CANA CODIGOCANALVENTA,mcur.fec_disp_curs FECHACAPACITACION,APCU.IND_ASIS INDICADORASISTENCIA,  "); // eiraola - Inc.DBLG400000745
            consulta.append("        APCU.IND_INVI FLAGEXTEMPORANEA,APCU.IND_APTA_CURS FLAGAPTA,APCU.NUM_CONV OPCION,MCUR.FEC_FIN_CURS FECHAFINCURSO ");
            consulta.append(" FROM   EDU_APTAS_CURSO APCU,EDU_MATRI_CURSO MCUR,EDU_PLANT_CURSO_CABEC PCUR,MAE_CLIEN CLI,CRA_PERIO PERI, ");
            consulta.append("        SEG_PERIO_CORPO PCOR,EDU_TIPO_CURSO TCUR,SEG_CANAL CANA ");
            consulta.append(" WHERE  APCU.MCUR_OID_CURS = MCUR.OID_CURS AND MCUR.CPLC_OID_CABE_PLAN_CURS = PCUR.OID_CABE ");
            consulta.append("        AND APCU.CLIE_OID_CLIE = CLI.OID_CLIE AND MCUR.PERD_OID_PERI_INGR = PERI.OID_PERI(+) ");
            consulta.append("        AND PERI.PERI_OID_PERI = PCOR.OID_PERI(+) AND MCUR.TICU_OID_TIPO_CURS = TCUR.OID_TIPO_CURS ");
            consulta.append("        AND MCUR.CANA_OID_CANA = CANA.OID_CANA ");

            if (pais != null) {
                consulta.append("    AND MCUR.PAIS_OID_PAIS = ? ");
                parametros.add(pais);
            }

            if (marca != null) {
                consulta.append("    AND MCUR.MARC_OID_MARC = ? ");
                parametros.add(marca);
            }

            if (canal != null) {
                consulta.append("    AND MCUR.CANA_OID_CANA = ? ");
                parametros.add(canal);
            }

            if (curso.getCodigoPlantilla() != null) {
                consulta.append("    AND PCUR.OID_CABE = ? ");
                parametros.add(curso.getCodigoPlantilla());
            }

            if (curso.getCodigoCurso() != null) {
                consulta.append("    AND MCUR.COD_CURS = ? ");
                parametros.add(curso.getCodigoCurso());
            }

            if (fechaFacturacion!=null && fechaUltProc!=null) {
                //  Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070122
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime());
                //String sFecha = sdf.format(fecha);

                /*consulta.append("    AND ( APCU.FEC_ULTI_ACTU between TO_DATE(?, 'YYYY-MM-DD') and ");
                parametros.add( formateaFecha(fechaUltProc) );
                consulta.append("       TO_DATE(?, 'YYYY-MM-DD') ) ");
                parametros.add( formateaFecha(fechaFacturacion) );
                consulta.append("    AND APCU.FEC_ASIS is not null ");*/
                
                //Modificado por Sapaza, fecha 18-09-2007, cambio Sicc20070392
                consulta.append("    AND APCU.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ");
                parametros.add( fechaUltProcStr );
                consulta.append("    AND APCU.FEC_ASIS is not null ");
            }

            try {
                rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error("  obtenerCursos: Exception", e);
                this.logSql("  obtenerCursos. SQL: ", consulta.toString(), parametros);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } //catch 

            if (rs != null) {
                for (int j = 0; j < rs.getRowCount(); j++) {
                    aptaCurso = new DTOINTAptaCurso();
                    aptaCurso.setIndicadorFF(Boolean.FALSE);

                    if (rs.getValueAt(j, "CODIGOCLIENTE") != null) {
                        aptaCurso.setCodigoCliente((String) rs.getValueAt(j, "CODIGOCLIENTE"));
                    }

                    if (rs.getValueAt(j, "FECHAASISTENCIA") != null) {
                        aptaCurso.setFechaAsistencia(new Date(((java.sql.Date) rs.getValueAt(j, "FECHAASISTENCIA")).getTime()));
                    }

                    if (rs.getValueAt(j, "INDICADORINVITADA") != null) {
                        aptaCurso.setIndicadorInvitada((BigDecimal) rs.getValueAt(j, "INDICADORINVITADA") + "");
                    }

                    if (rs.getValueAt(j, "NUMEROCONVOCATORIA") != null) {
                        aptaCurso.setNumeroConvocatoria(new Integer(((BigDecimal) rs.getValueAt(j, "NUMEROCONVOCATORIA")).intValue()));
                    }

                    if (rs.getValueAt(j, "PERIODO") != null) {
                        aptaCurso.setPeriodo((String) rs.getValueAt(j, "PERIODO"));
                    }

                    if (rs.getValueAt(j, "CODIGOTIPOCURSO") != null) {
                        aptaCurso.setCodigoTipoCurso((BigDecimal) rs.getValueAt(j, "CODIGOTIPOCURSO") + "");
                    }

                    if (rs.getValueAt(j, "CODIGOCANALVENTA") != null) {
                        aptaCurso.setCodigoCanalVenta((String) rs.getValueAt(j, "CODIGOCANALVENTA"));
                    }

                    if (rs.getValueAt(j, "FECHACAPACITACION") != null) {
                        aptaCurso.setFechaCapacitacion(new Date(((java.sql.Date) rs.getValueAt(j, "FECHACAPACITACION")).getTime()));
                    }

                    if (rs.getValueAt(j, "INDICADORASISTENCIA") != null) {
                        aptaCurso.setIndicadorAsistencia((BigDecimal) rs.getValueAt(j, "INDICADORASISTENCIA") + "");
                    }

                    if (rs.getValueAt(j, "FLAGEXTEMPORANEA") != null) {
                        aptaCurso.setFlagExtemporanea((BigDecimal) rs.getValueAt(j, "FLAGEXTEMPORANEA") + "");
                    }

                    if (rs.getValueAt(j, "FLAGAPTA") != null) {
                        aptaCurso.setFlagApta((BigDecimal) rs.getValueAt(j, "FLAGAPTA") + "");
                    }

                    if (rs.getValueAt(j, "OPCION") != null) {
                        aptaCurso.setOpcion(new Integer(((BigDecimal) rs.getValueAt(j, "OPCION")).intValue()));
                    }

                    if (rs.getValueAt(j, "FECHAFINCURSO") != null) {
                        aptaCurso.setFechaFinCurso(new Date(((java.sql.Date) rs.getValueAt(j, "FECHAFINCURSO")).getTime()));
                    }

                    aptaCurso.setOidAptaCurso(new Long(((BigDecimal) rs.getValueAt(j, "OIDAPTACURSO")).longValue()));

                    listaAptas.add(aptaCurso);
                }
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerCursos(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Long tipoCliente): Salida");

        return listaAptas;
    }

  /**
   * Modificado por Sapaza - Fecha 05/06/2007 - Cambio Sicc20070291, 
   *            se deshace el cambio hecho por la incidencia Sicc20070283
   * Modificado por dmorello - 13/11/2008 - Cambio RI 20080664
   * - Se descartan zonas/regiones sin cliente asignado
   * - Se toman solo regiones activas y no borradas
   * - Se elimina filtro por novedad y parametro fechaUltimaEjecucion
   */
   public ArrayList obtenerTablaZonas(Long pais, Long marca, Long canal, Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerTablaZonas(Long pais, Long marca, Long canal, java.util.Date fechaUltimaEjecucion, Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT ZON.COD_ZONA codigoZona, CLI.COD_CLIE codigoGerenteZona, ");
        consulta.append(" CLI.VAL_NOM1 nombre1Gerente, CLI.VAL_NOM2 nombre2Gerente, ");
        consulta.append(" CLI.VAL_APE1 apellido1Gerente, CLI.VAL_APE2 apellido2Gerente, ");
        // Modificado por ssantana, 8/9/2005, a pedido de JRivas (PERU)
        consulta.append(" REG.COD_REGI codigoRegion, DECODE( ZON.IND_ACTI, 1, '1', '0' ) indicadorActiva, ");
        // Fin modificacion ssantana, 8/9/2005
        consulta.append(" CLI2.COD_CLIE codigoGerenteRegional, CLI2.VAL_NOM1 nombre1GerenteRegional, ");
        consulta.append(" CLI2.VAL_NOM2 nombre2GerenteRegional, CLI2.VAL_APE1 apellido1GerenteRegional, ");
        consulta.append(" CLI2.VAL_APE2 apellido2GerenteRegional, REG.DES_REGI nombreRegion, ");
        consulta.append(" PAI.COD_PAIS codigoPais, (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_PAIS' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append(" AND idio.VAL_OID = PAI.OID_PAIS ) NOMBREPAIS, ");
        consulta.append(" ESTZ.COD_ESTA_ZONA estatusZona, SUBG.COD_SUBG_VENT codigoSubgerencia, ");
        consulta.append(" SUBG.DES_SUBG_VENT nombreSubgerencia, ZON.DES_ZONA nombreZona ");
        consulta.append(" FROM ZON_ZONA ZON, ZON_REGIO REG, ZON_ESTAD_ZONA ESTZ, ");
        consulta.append(" MAE_CLIEN CLI, MAE_CLIEN CLI2, SEG_PAIS PAI, ZON_SUB_GEREN_VENTA SUBG ");
        consulta.append(" WHERE ZON.CLIE_OID_CLIE = CLI.OID_CLIE AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
        consulta.append(" AND REG.CLIE_OID_CLIE = CLI2.OID_CLIE AND ZON.PAIS_OID_PAIS = PAI.OID_PAIS ");
        consulta.append(" AND ZON.ESZO_OID_ESTA_ZONA = ESTZ.OID_ESTA_ZONA (+)");
        consulta.append(" AND REG.ZSGV_OID_SUBG_VENT = SUBG.OID_SUBG_VENT ");
        consulta.append(" AND ZON.PAIS_OID_PAIS = ? ");
        parametros.add(pais);

        if (marca != null) {
            consulta.append(" AND ZON.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }

        if (canal != null) {
            consulta.append(" AND ZON.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
        consulta.append("AND REG.IND_ACTI = 1 AND REG.IND_BORR = 0");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        ArrayList retorno = new ArrayList();

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString().toUpperCase(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerTablaZonas: Exception", e);
            this.logSql(" obtenerTablaZonas. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        if (rs != null) {
            int tamano = rs.getRowCount();

            for (int i = 0; i < tamano; i++) {
                DTOINTZona zona = new DTOINTZona();

                if (rs.getValueAt(i, "APELLIDO1GERENTEREGIONAL") != null) {
                    zona.setApellido1GerenteRegional(rs.getValueAt(i, "APELLIDO1GERENTEREGIONAL").toString());
                }

                if (rs.getValueAt(i, "APELLIDO1GERENTE") != null) {
                    zona.setApellido1GerenteZona(rs.getValueAt(i, "APELLIDO1GERENTE").toString());
                }

                if (rs.getValueAt(i, "APELLIDO2GERENTEREGIONAL") != null) {
                    zona.setApellido2GerenteRegional(rs.getValueAt(i, "APELLIDO2GERENTEREGIONAL").toString());
                }

                if (rs.getValueAt(i, "APELLIDO2GERENTE") != null) {
                    zona.setApellido2GerenteZona(rs.getValueAt(i, "APELLIDO2GERENTE").toString());
                }

                if (rs.getValueAt(i, "CODIGOGERENTEREGIONAL") != null) {
                    zona.setCodigoGerenteRegional(rs.getValueAt(i, "CODIGOGERENTEREGIONAL").toString());
                }

                if (rs.getValueAt(i, "CODIGOGERENTEZONA") != null) {
                    zona.setCodigoGerenteZona(rs.getValueAt(i, "CODIGOGERENTEZONA").toString());
                }

                if (rs.getValueAt(i, "CODIGOPAIS") != null) {
                    zona.setCodigoPais(rs.getValueAt(i, "CODIGOPAIS").toString());
                }

                if (rs.getValueAt(i, "CODIGOREGION") != null) {
                    zona.setCodigoRegion(rs.getValueAt(i, "CODIGOREGION").toString());
                }

                if (rs.getValueAt(i, "CODIGOSUBGERENCIA") != null) {
                    zona.setCodigoSubgerencia(rs.getValueAt(i, "CODIGOSUBGERENCIA").toString());
                }

                if (rs.getValueAt(i, "CODIGOZONA") != null) {
                    zona.setCodigoZona(rs.getValueAt(i, "CODIGOZONA").toString());
                }

                if (rs.getValueAt(i, "INDICADORACTIVA") != null) {
                    zona.setIndicadorActiva(rs.getValueAt(i, "INDICADORACTIVA").toString());
                }

                if (rs.getValueAt(i, "NOMBRE1GERENTEREGIONAL") != null) {
                    zona.setNombre1GerenteRegional(rs.getValueAt(i, "NOMBRE1GERENTEREGIONAL").toString());
                }

                if (rs.getValueAt(i, "NOMBRE1GERENTE") != null) {
                    zona.setNombre1GerenteZona(rs.getValueAt(i, "NOMBRE1GERENTE").toString());
                }

                if (rs.getValueAt(i, "NOMBRE2GERENTEREGIONAL") != null) {
                    zona.setNombre2GerenteRegional(rs.getValueAt(i, "NOMBRE2GERENTEREGIONAL").toString());
                }

                if (rs.getValueAt(i, "NOMBRE2GERENTE") != null) {
                    zona.setNombre2GerenteZona(rs.getValueAt(i, "NOMBRE2GERENTE").toString());
                }

                if (rs.getValueAt(i, "NOMBREPAIS") != null) {
                    zona.setNombrePais(rs.getValueAt(i, "NOMBREPAIS").toString());
                }

                if (rs.getValueAt(i, "NOMBREREGION") != null) {
                    zona.setNombreRegion(rs.getValueAt(i, "NOMBREREGION").toString());
                }

                if (rs.getValueAt(i, "NOMBRESUBGERENCIA") != null) {
                    zona.setNombreSubgerencia(rs.getValueAt(i, "NOMBRESUBGERENCIA").toString());
                }

                if (rs.getValueAt(i, "NOMBREZONA") != null) {
                    zona.setNombreZona(rs.getValueAt(i, "NOMBREZONA").toString());
                }
                
                if (rs.getValueAt(i, "ESTATUSZONA") != null) { 
                    zona.setEstatusZona(rs.getValueAt(i, "ESTATUSZONA").toString()); 
                } 

                retorno.add(zona);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerTablaZonas(Long pais, Long marca, Long canal, java.util.Date fechaUltimaEjecucion, Long idioma): Salida");

        return retorno;
    }

    public ArrayList obtenerEstatusClientes(Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerEstatusClientes(Long idioma): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT COD_ESTA_CLIE CODIGOCLIENTE,  ");
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_ESTAT_CLIEN' ");
        consulta.append(" AND idio.IDIO_OID_IDIO =? ");
        parametros.add(idioma);
        consulta.append(" AND idio.VAL_OID = EST.oid_esta_clie) DESCRIPCION ");
        consulta.append(" FROM MAE_ESTAT_CLIEN EST ORDER BY COD_ESTA_CLIE ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerEstatusClientes: Exception", e);
            this.logSql(" obtenerEstatusClientes. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();

        if (rs != null) {
            int x = rs.getRowCount();

            for (int i = 0; i < x; i++) {
                DTOINTEstatusCliente estCliente = new DTOINTEstatusCliente();

                if (rs.getValueAt(i, "CODIGOCLIENTE") != null) {
                    estCliente.setCodigoEstatus(rs.getValueAt(i, "CODIGOCLIENTE").toString());
                }

                if (rs.getValueAt(i, "DESCRIPCION") != null) {
                    estCliente.setDescripcionEstatus(rs.getValueAt(i, "DESCRIPCION").toString());
                }

                lista.add(estCliente);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerEstatusClientes(Long idioma): Salida");

        return lista;
    }

   public ArrayList obtenerClientes (Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion) throws MareException{ 
        UtilidadesLog.info("DAOINTDAT.obtenerClientes(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Entrada");
        
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector(); 

        consulta.append(" SELECT distinct CLI.OID_CLIE OIDCLIENTE, CLI.COD_CLIE CODIGOCLIENTE, TERR.COD_TERR CODIGOTERRITORIO  ");           
        consulta.append(" FROM   PED_SOLIC_CABEC SOC, CRA_PERIO PERI, MAE_CLIEN CLI, ZON_TERRI TERR, SEG_SUBAC SUBAC    ");           
        consulta.append(" WHERE  SOC.PERD_OID_PERI = PERI.OID_PERI AND SOC.CLIE_OID_CLIE = CLI.OID_CLIE  ");           
        consulta.append("        AND SOC.TERR_OID_TERR = TERR.OID_TERR AND SOC.IND_TS_NO_CONSO = 1 ");           
        consulta.append("        AND IND_OC = 1 AND IND_PEDI_PRUE = 0 AND SOC.SBAC_OID_SBAC = SUBAC.OID_SBAC ");           

        if(canal != null){ 
            consulta.append("    AND PERI.CANA_OID_CANA = ? ");           
            parametros.add(canal); 
        } 

        if(acceso != null){ 
            consulta.append("    AND SUBAC.ACCE_OID_ACCE = ? ");           
            parametros.add(acceso); 
        } 
        
        if(marca != null){ 
            consulta.append("    AND PERI.MARC_OID_MARC = ? ");           
            parametros.add(marca); 
        } 
        
        if(pais != null){ 
            consulta.append("    AND SOC.PAIS_OID_PAIS = ? ");           
            parametros.add(pais); 
        } 

        if(periodo != null){ 
            //BELC300017218 
            consulta.append("    AND PERI.OID_PERI = ? ");           
            parametros.add(periodo); 
        } 
        
        if(fechaFacturacion != null){ 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime()); 
    
            String sFecha = sdf.format(fecha);                                                           
            consulta.append("    AND SOC.FEC_FACT = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");           
            parametros.add(sFecha); 
        } 


        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
            rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros); 
        } 
        catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("  obtenerClientes: Exception",e); 
            this.logSql("  obtenerClientes. SQL: ",consulta.toString(),parametros); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
        
        ArrayList lista = new ArrayList(); 
        DTOINTCliente cliente = null; 
        int n = rs.getRowCount(); 
        if(rs != null){ 
            for(int i=0;i<n;i++){ 
                cliente = new DTOINTCliente(); 
                if(rs.getValueAt(i,"OIDCLIENTE") != null) 
                    cliente.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).longValue())); 
                if(rs.getValueAt(i,"CODIGOCLIENTE") != null) 
                    cliente.setCodigoCliente((String) rs.getValueAt(i,"CODIGOCLIENTE")); 
                if(rs.getValueAt(i,"CODIGOTERRITORIO") != null) 
                    cliente.setCodigoTerritorio(new Long(rs.getValueAt(i,"CODIGOTERRITORIO").toString())); 
                lista.add(cliente); 
            } 
        } 
        
        UtilidadesLog.info("DAOINTDAT.obtenerClientes(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Salida");             
        return lista; 
    }

    public ArrayList obtenerEstatusClientes(Long periodo, ArrayList listaOIDClientes, java.util.Date fechaFacturacion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerEstatusClientes(Long periodo, ArrayList listaOIDClientes): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT CLI.OID_CLIE OIDCLIENTE, EST.COD_ESTA_CLIE CODIGOESTATUS, DECODE (tipif.control, 1, 1, 0) INDICADORESESTRELLA, ");
        // gPineda - 06/03/07 - A pedido del equipo de Belcorp
        //consulta.append("        MCUR.COD_CURS CODIGOCURSO, COUNT(SOC.OID_SOLI_CABE) NUMEROTOTALORDENES ");
        consulta.append("        MCUR.COD_CURS CODIGOCURSO, COUNT( DISTINCT SOC.CLIE_OID_CLIE) NUMEROTOTALORDENES ");
        consulta.append(" FROM   MAE_CLIEN CLI, MAE_CLIEN_DATOS_ADICI ADI, MAE_ESTAT_CLIEN EST, PED_SOLIC_CABEC SOC, ");
        consulta.append("        EDU_HISTO_CURSO HCUR, EDU_MATRI_CURSO MCUR,  ");

        //Primer SubSelect
        consulta.append("        (SELECT vtc.clie_oid_clie , 1 control ");
        consulta.append("         FROM V_MAE_TIPIF_CLIEN VTC ");
        consulta.append("         WHERE  VTC.TICL_OID_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
        consulta.append("                AND VTC.TCCL_OID_TIPO_CLASI = ?  ");
        parametros.add(ConstantesMAE.OID_TIPO_CLASIFICACION_ESTRELLA);
        consulta.append("                AND VTC.CLAS_OID_CLAS = ? ");
        parametros.add(ConstantesMAE.OID_CLASIFICACION_ESTRELLA);
        consulta.append("        ) TIPIF, ");

        //Segundo SubSelect
        consulta.append("        (SELECT * FROM CRA_PERIO ");
        consulta.append("         WHERE ROWNUM = 1  ");

        if (periodo != null) {
            consulta.append("     AND OID_PERI = ? ");
            parametros.add(periodo);
        }

        consulta.append("         ORDER BY FEC_FINA ) PERI ");

        consulta.append(" WHERE  ADI.CLIE_OID_CLIE = CLI.OID_CLIE AND ADI.ESTA_OID_ESTA_CLIE = EST.OID_ESTA_CLIE ");
        consulta.append("        AND HCUR.CLIE_OID_CLIE (+)= CLI.OID_CLIE AND MCUR.OID_CURS (+)= HCUR.MCUR_OID_CURS  ");
        consulta.append("        AND SOC.CLIE_OID_CLIE = CLI.OID_CLIE AND PERI.FEC_INIC (+)>= MCUR.FEC_FIN_CURS AND MCUR.FEC_FIN_CURS(+) IS NOT NULL ");
        consulta.append("        AND PERI.FEC_FINA (+)<= MCUR.FEC_FIN_CURS AND ADI.IND_ACTI = 1  ");
        if(fechaFacturacion != null){ 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime()); 
    
            String sFecha = sdf.format(fecha);                                                           
            consulta.append("    AND SOC.FEC_FACT = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");           
            parametros.add(sFecha); 
        }
        consulta.append("    AND tipif.CLIE_OID_CLIE (+)= cli.OID_CLIE ");
        
        /* mdolce - 14/06/2006
         * AND SOC.IND_TS_NO_CONSO = 1 AND SOC.IND_OC = 1 AND SOC.IND_PEDI_PRUE = 0 
         * Este filtro se remueve por revalidacion de incidencia DBLG400000716
         * El decu dice: “Se manda cada vez que se factura la información de las 
         * consultoras que pasaron pedido,  y al Cierre de la Zona es necesario enviar 
         * la información de todas las Consultoras de la Zona que se esta cerrando con 
         * su respectivo Status alcanzado en la campaña, haya o no pasado pedido “.
         * */

        if (listaOIDClientes != null) {
            int num = listaOIDClientes.size();
            int h=0;
            if (num > 0) {
                consulta.append("        AND CLI.OID_CLIE IN ( ");

                for (int i = 0; i < num; i++) {
                    if(h>999){
                        consulta = consulta.delete(consulta.length() - 1, consulta.length());
                        consulta.append("  ) OR CLI.OID_CLIE IN (  ");
                        h=0;
                    }
                    consulta.append(" ? ,");
                    parametros.add((Long) listaOIDClientes.get(i));
                    h++;
                    
                }

                consulta = consulta.delete(consulta.length() - 1, consulta.length());
                consulta.append("        )   ");
            }
        }

        consulta.append(" GROUP BY CLI.OID_CLIE, EST.COD_ESTA_CLIE, tipif.control, MCUR.COD_CURS ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerEstatusClientes: Exception", e);
            this.logSql("  obtenerEstatusClientes. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTEstatusCliente estatusCliente = null;
        int n = rs.getRowCount();

        if (rs != null) {
            for (int i = 0; i < n; i++) {
                estatusCliente = new DTOINTEstatusCliente();

                if (rs.getValueAt(i, "OIDCLIENTE") != null) {
                    estatusCliente.setOidCliente(new Long(((BigDecimal) rs.getValueAt(i, "OIDCLIENTE")).longValue()));
                }

                if (rs.getValueAt(i, "CODIGOESTATUS") != null) {
                    estatusCliente.setCodigoEstatus((String) rs.getValueAt(i, "CODIGOESTATUS"));
                }

                if (rs.getValueAt(i, "INDICADORESESTRELLA") != null) {
                    estatusCliente.setIndicadorEsEstrella((BigDecimal) rs.getValueAt(i, "INDICADORESESTRELLA") + "");
                }

                if (rs.getValueAt(i, "CODIGOCURSO") != null) {
                    estatusCliente.setCodigoTipoCurso(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOCURSO")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROTOTALORDENES") != null) {
                    estatusCliente.setNumeroTotalOrdenes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROTOTALORDENES")).longValue()));
                }

                lista.add(estatusCliente);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerEstatusClientes(Long periodo, ArrayList listaOIDClientes): Salida");

        return lista;
    }

    /*
     * rgiorgi - 20/8/2005: inc. Peru JPB.
     * */
    public ArrayList obtenerInfoCampania (Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion)throws MareException{ 
        UtilidadesLog.info("DAOINTDAT.obtenerInfoCampania(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Entrada");
        
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector(); 
        
        //jrivas 21/1/2007 INT-DATPRD4 Se rehizo la query.        
        consulta.append(" SELECT   MFAC.VAL_TIPO_CAMB TIPOCAMBIO,  "); 
        consulta.append(" 		 SUM (SOC.NUM_CLIEN) NUMEROCLIENTES, "); 
        consulta.append("      MIN (MM.VAL_NIV1) MONTOMINIMO, "); 
        consulta.append("      COUNT (SOC.OID_SOLI_CABE) NUMEROORDENESCOMPRA,  "); 
        consulta.append(" 		 COUNT (DISTINCT (SOC.CLIE_OID_CLIE)) NUMEROPEDIDOS		 "); 
        consulta.append("     FROM PED_SOLIC_CABEC SOC, "); 
        consulta.append("          PRE_MATRI_FACTU_CABEC MFAC, "); 
        consulta.append("          PED_MONTO_MINIM MM, "); 
        consulta.append("          PED_TIPO_SOLIC_PAIS TSP, "); 
        consulta.append("          MAE_CLIEN_TIPO_SUBTI CTS "); 

        if(acceso!=null){ 
            consulta.append(" , SEG_SUBAC SUBAC"); 
        }   
        
        consulta.append("    WHERE SOC.PERD_OID_PERI = " + periodo ); 
        consulta.append("      AND MFAC.PERD_OID_PERI = " + periodo ); 
        consulta.append("      AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS "); 
        consulta.append("      AND MM.TSPA_OID_TIPO_SOLI_PAIS(+) = TSP.OID_TIPO_SOLI_PAIS "); 
        //sbuchelli 15/03/2010
        consulta.append("      AND mm.CLAS_OID_CLAS IS NULL  "); 
        consulta.append("      AND mm.TCCL_OID_TIPO_CLAS IS NULL  "); 
                
        consulta.append("      AND CTS.CLIE_OID_CLIE = SOC.CLIE_OID_CLIE "); 

        if(pais!=null){ 
            consulta.append(" AND SOC.PAIS_OID_PAIS = ? "); 
            parametros.add(pais); 
        } 
        if(acceso!=null){ 
            consulta.append(" AND SUBAC.ACCE_OID_ACCE = ? "); 
            parametros.add(acceso); 
        }        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        
        if(fechaFacturacion != null){ 
          //la fecha del DTO siempre sera java.util.Date 
            java.sql.Date fechaDesde = new 
            java.sql.Date(fechaFacturacion.getTime()); 
        
            String sFechaDesde = sdf.format(fechaDesde);                                                           
            consulta.append(" AND (SOC.FEC_FACT =  TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) "); 
            parametros.add(sFechaDesde); 
        } 
        
        consulta.append("      AND SOC.IND_TS_NO_CONSO = 1 "); 
        consulta.append("      AND SOC.IND_OC = 1 "); 
        consulta.append("      AND SOC.IND_PEDI_PRUE = 0 "); 
        consulta.append("      AND CTS.TICL_OID_TIPO_CLIE = ? "); 
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA); 
        consulta.append(" GROUP BY SOC.PAIS_OID_PAIS, "); 
        consulta.append("          MFAC.VAL_TIPO_CAMB "); 

        
        /*
        consulta.append(" SELECT MFAC.VAL_TIPO_CAMB TIPOCAMBIO, "); 
        consulta.append(" SUM(SOC.NUM_CLIEN) NUMEROCLIENTES, "); 
        consulta.append(" MIN(MM.VAL_NIV1) MONTOMINIMO, "); 
        consulta.append(" COUNT(SOC.OID_SOLI_CABE) NUMEROORDENESCOMPRA, "); 
        consulta.append(" COUNT(DISTINCT( CLI.OID_CLIE )) NUMEROPEDIDOS "); 
        consulta.append(" FROM PED_SOLIC_CABEC SOC, PED_SOLIC_CABEC SOC2, "); 
        consulta.append(" CRA_PERIO PER, SEG_CANAL CANA, PRE_MATRI_FACTU_CABEC MFAC, "); 
        consulta.append(" PED_MONTO_MINIM MM, PED_TIPO_SOLIC_PAIS TSP, MAE_CLIEN CLI, "); 
        consulta.append(" MAE_CLIEN_TIPO_SUBTI CTS, SEG_SUBAC SUBAC  "); 
        consulta.append(" WHERE SOC.PERD_OID_PERI = PER.OID_PERI AND SOC2.PERD_OID_PERI = PER.OID_PERI "); 
        consulta.append(" AND PER.CANA_OID_CANA = CANA.OID_CANA AND SOC2.SOCA_OID_SOLI_CABE = SOC.SOCA_OID_SOLI_CABE "); 
        consulta.append(" AND MFAC.PERD_OID_PERI = PER.OID_PERI AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS "); 
        consulta.append(" AND MM.TSPA_OID_TIPO_SOLI_PAIS (+)= TSP.OID_TIPO_SOLI_PAIS AND SOC2.CLIE_OID_CLIE = CLI.OID_CLIE "); 
        consulta.append(" AND CTS.CLIE_OID_CLIE = CLI.OID_CLIE "); 
        consulta.append(" AND SOC.SBAC_OID_SBAC = SUBAC.OID_SBAC "); 
        
         if(pais!=null){ 
            consulta.append(" AND SOC.PAIS_OID_PAIS = ? "); 
            parametros.add(pais); 
        } 
        if(marca!=null){ 
            consulta.append(" AND PER.MARC_OID_MARC = ? "); 
            parametros.add(marca); 
        } 
        if(canal!=null){ 
            consulta.append(" AND PER.CANA_OID_CANA = ? "); 
            parametros.add(canal); 
        } 
        if(acceso!=null){ 
            consulta.append(" AND SUBAC.ACCE_OID_ACCE = ? "); 
            parametros.add(acceso); 
        } 
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        
        if(fechaFacturacion != null){ 
          //la fecha del DTO siempre sera java.util.Date 
            java.sql.Date fechaDesde = new 
            java.sql.Date(fechaFacturacion.getTime()); 
        
            String sFechaDesde = sdf.format(fechaDesde);                                                           
            consulta.append(" AND (SOC.FEC_FACT =  TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ) "); 
            parametros.add(sFechaDesde); 
        } 
        
        if(periodo!=null){ 
            consulta.append(" AND PER.OID_PERI = ? "); 
            parametros.add(periodo); 
        } 
        consulta.append(" AND SOC.IND_TS_NO_CONSO = 1 AND SOC.IND_OC = 1 AND SOC.IND_PEDI_PRUE = 0 "); 
        consulta.append(" AND SOC2.IND_TS_NO_CONSO = 1 AND SOC2.IND_OC = 1 AND SOC2.IND_PEDI_PRUE = 0 "); 

        consulta.append(" AND CTS.TICL_OID_TIPO_CLIE = ? "); 
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA); 
        consulta.append(" GROUP BY SOC.PAIS_OID_PAIS, CANA.COD_CANA, MFAC.VAL_TIPO_CAMB, "); 
        consulta.append(" PER.MARC_OID_MARC, PER.OID_PERI, CLI.OID_CLIE "); */
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error(" obtenerInfoCampania: Exception",e); 
            this.logSql(" obtenerInfoCampania. SQL: ", 
            consulta.toString(),parametros); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
        
        ArrayList lista = new ArrayList(); 
        
        // Rellenamos el ArrayList con objetos 'DTOINTTxCliente' 
        if(rs != null){ 
            int x = rs.getRowCount(); 
            for(int i = 0; i < x; i++){ 
                DTOINTInfoCampania dto = new DTOINTInfoCampania(); 
                
                    if(rs.getValueAt(i,"MONTOMINIMO") != null){                 
                        dto.setMontoMinimo((BigDecimal)rs.getValueAt(i,"MONTOMINIMO")); 
                    } 
                    if(rs.getValueAt(i,"NUMEROCLIENTES") != null){                 
                        dto.setNumeroClientes(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROCLIENTES")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"NUMEROORDENESCOMPRA") != null){                 
                        dto.setNumeroOrdenesCompra(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROORDENESCOMPRA")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"NUMEROPEDIDOS") != null){                 
                        dto.setNumeroPedidos(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROPEDIDOS")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"TIPOCAMBIO") != null){                 
                        dto.setTipoCambio((BigDecimal)rs.getValueAt(i,"TIPOCAMBIO")); 
                    }                     

                    lista.add(dto); 
                } 
            } 
        // Traza de salida 
        UtilidadesLog.info("DAOINTDAT.obtenerInfoCampania(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Salida");
        return lista; 
        
    }

    /**
     *Ver incidencia BELC300016354
     * Datos para pruebas 1,1,1,1,1
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param indicadorActivo
     * @param zona
     * @param canal
     * @param marca
     * @param pais
     */
    public ArrayList obtenerClientesCierreZona(Long periodo, Long zona, Boolean indicadorActivo) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerClientesCierreZona(Long pais, Long marca, Long canal, Long zona, Boolean indicadorActivo): Entrada");

        ArrayList listado = new ArrayList();
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        //INICIO CONSULTA
        consulta.append(" SELECT DISTINCT ");
        consulta.append(" CLI.OID_CLIE oidCliente, ");
        consulta.append(" CLI.COD_CLIE codigoCliente, ");
        consulta.append(" TERR.COD_TERR codigoTerritorio ");

        consulta.append(" FROM ");
        consulta.append(" MAE_CLIEN_UNIDA_ADMIN ADM, ");
        consulta.append(" MAE_CLIEN CLI, ");
        consulta.append(" CRA_PERIO PERI, ");
        consulta.append(" CRA_PERIO PERIINI, ");
        consulta.append(" CRA_PERIO PERIFIN, ");
        consulta.append(" ZON_TERRI_ADMIN TADM, ");
        consulta.append(" ZON_TERRI TERR, ");
        consulta.append(" ZON_SECCI SECC ");

        consulta.append(" WHERE ");
        consulta.append(" ADM.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND ADM.PERD_OID_PERI_INI = PERIINI.OID_PERI ");
        consulta.append(" AND PERIINI.FEC_INIC <= PERI.FEC_INIC ");
        consulta.append(" AND (( ADM.PERD_OID_PERI_FIN IS NULL) OR (");
        consulta.append(" ADM.PERD_OID_PERI_FIN = PERIFIN.OID_PERI AND PERIFIN.FEC_FINA >= PERI.FEC_FINA)) ");
        consulta.append(" AND ADM.PERD_OID_PERI_INI = PERIINI.OID_PERI ");
        consulta.append(" AND ADM.ZTAD_OID_TERR_ADMI = TADM.OID_TERR_ADMI ");
        consulta.append(" AND TADM.ZSCC_OID_SECC = SECC.OID_SECC ");
        consulta.append(" AND TADM.TERR_OID_TERR = TERR.OID_TERR ");

        if (periodo != null) {
            consulta.append(" AND PERI.OID_PERI = ? ");
            parametros.add(periodo);
        }
        if (zona != null) {
            consulta.append(" AND SECC.ZZON_OID_ZONA = ? ");
            parametros.add(zona);
        }

        if (indicadorActivo != null) {
            consulta.append(" AND ADM.IND_ACTI = ? ");
            parametros.add(indicadorActivo);
        }

        consulta.append(" ORDER BY ");
        consulta.append(" CLI.COD_CLIE ");

        //FIN CONSUTA
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerClientesCierreZona  : Exception", e);
            this.logSql(" obtenerClientesCierreZona  SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        DTOINTCliente dto = null;

        if (rs != null) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                dto = new DTOINTCliente();

                if (rs.getValueAt(i, "CODIGOCLIENTE") != null) {
                    dto.setCodigoCliente((String) rs.getValueAt(i, "CODIGOCLIENTE"));
                }

                if (rs.getValueAt(i, "CODIGOTERRITORIO") != null) {
                    dto.setCodigoTerritorio(new Long(rs.getValueAt(i, "CODIGOTERRITORIO").toString()));
                }

                if (rs.getValueAt(i, "OIDCLIENTE") != null) {
                    dto.setOidCliente(new Long(((BigDecimal) rs.getValueAt(i, "OIDCLIENTE")).longValue()));
                }

                listado.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerClientesCierreZona(Long pais, Long marca, Long canal, Long zona, Boolean indicadorActivo): Salida");

        return listado;
    }

    /*aplicadas BELC300016410, BELC300016332*/
    public ArrayList obtenerResumenTxPorSeccion(Long pais, Long canal, Long periodo) //, Long zona) BELC300016332
        throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerResumenTxPorSeccion(Long pais, Long canal, Long periodo): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        /*consulta.append(" select ");
        consulta.append(" FVR.PAIS_OID_PAIS, ");
        consulta.append(" CANA.COD_CANA CODCANALVENTA, ");

        /*aplicando BELC300016410
        consulta.append(" PERI.OID_PERI, ");* /
        consulta.append(" ZON.COD_ZONA CODZONA, ");
        consulta.append(" SUM(ACUM.NUM_ORDE) NUMORDENES, ");
        consulta.append(" SUM(ACUM.NUM_CLIE) NUMCLIENTES, ");
        //gPineda - 14/02/2007
        //consulta.append(" SUM(FVR.NUM_ACTI_FINA - FVR.NUM_ACTI_INIC) NUMCONSULTORASACTIVAS, ");
        consulta.append(" SUM(FVR.NUM_ACTI_FINA ) NUMCONSULTORASACTIVAS, ");
        consulta.append(" SUM(FVR.NUM_ACTI_INIC) NUMACTIVASINICIOCAMPANIA, ");
        consulta.append(" SUM(FVR.NUM_INGR) NUMINGRESOS, ");
        consulta.append(" SUM(FVR.NUM_EGRE) NUMEGRESOS, ");
        consulta.append(" SUM(FVR.NUM_REIN) NUMCONSULTORASREINGRESO, ");
        consulta.append(" SUM(FVR.NUM_REZO_RECI) NUMCONSULTORASRECIBIDAS, ");
        consulta.append(" SUM(FVR.NUM_REZO_ENTR) NUMCONSULTORASENTREGADAS, ");
        consulta.append(" SUM(ACUM.NUM_PEDI) NUMREALPEDIDOS ");
        consulta.append(" from ");
        consulta.append(" INT_FUENT_VENTAS_REAL FVR, INT_FUENT_VENTA_REAL_VACUM ACUM, ");
        consulta.append(" CRA_PERIO PERI, ZON_ZONA ZON, SEG_CANAL CANA ");
        consulta.append(" where ");

        //BELC300018824
        //consulta.append(" FVR.OID_FUEN_VENT_REAL = ACUM.OID_FUEN_VENT_REAL_VACU ");
        consulta.append(" ACUM.PERD_OID_PERI = FVR.PERD_OID_PERI ");
        consulta.append(" AND ACUM.ZZON_OID_ZONA = FVR.ZZON_OID_ZONA ");
        consulta.append(" AND ACUM.PAIS_OID_PAIS = FVR.PAIS_OID_PAIS ");

        consulta.append(" AND FVR.PERD_OID_PERI = PERI.OID_PERI ");
        consulta.append(" AND FVR.ZZON_OID_ZONA = ZON.OID_ZONA ");
        consulta.append(" AND PERI.CANA_OID_CANA = CANA.OID_CANA ");

        if (pais != null) {
            consulta.append(" AND FVR.PAIS_OID_PAIS = ?  "); // 1 --pais
            parametros.add(pais);
        }

        if (canal != null) {
            consulta.append(" AND PERI.CANA_OID_CANA = ?  "); // 1 --canal
            parametros.add(canal);
        }

        if (periodo != null) {
            consulta.append(" AND PERI.OID_PERI = ?  "); // 1 --periodo 
            parametros.add(periodo);
        }

        consulta.append(" group by ");
        consulta.append(" FVR.PAIS_OID_PAIS, CANA.COD_CANA, PERI.OID_PERI, ZON.COD_ZONA "); */
        
        // gPineda - 15/02/2007 - CAMBIO INT-DAT-003
        consulta.append("SELECT   fvr.pais_oid_pais, cana.cod_cana codcanalventa, zon.cod_zona codzona, secc.cod_secc, ");
        consulta.append("         SUM (fvr.num_acti_fina) numconsultorasactivas, ");
        consulta.append("         SUM (fvr.num_acti_inic) numactivasiniciocampania, ");
        consulta.append("         SUM (fvr.num_ingr) numingresos,  ");
        consulta.append("		  SUM (fvr.num_egre) numegresos, ");
        consulta.append("         SUM (fvr.num_rein) numconsultorasreingreso, ");
        consulta.append("         SUM (fvr.num_rezo_reci) numconsultorasrecibidas, ");
        consulta.append("         SUM (fvr.num_rezo_entr) numconsultorasentregadas, ");
        consulta.append("         (SELECT SUM (acum.num_orde)  ");
        consulta.append("            FROM int_fuent_venta_real_vacum acum, ");
        consulta.append("                 zon_terri_admin zta ");
        consulta.append("           WHERE acum.perd_oid_peri = peri.oid_peri ");
        consulta.append("             AND acum.pais_oid_pais = fvr.pais_oid_pais ");
        consulta.append("             AND acum.terr_oid_terr = zta.terr_oid_terr ");
        consulta.append("             AND zta.IND_BORR = 0 ");
        consulta.append("             AND zta.zscc_oid_secc = secc.oid_secc) numordenes, ");
        consulta.append("         (SELECT SUM (acum.num_clie)  ");
        consulta.append("            FROM int_fuent_venta_real_vacum acum, ");
        consulta.append("                 zon_terri_admin zta ");
        consulta.append("           WHERE acum.perd_oid_peri = peri.oid_peri ");
        consulta.append("             AND acum.pais_oid_pais = fvr.pais_oid_pais ");
        consulta.append("             AND acum.terr_oid_terr = zta.terr_oid_terr ");
        consulta.append("             AND zta.IND_BORR = 0 ");
        consulta.append("             AND zta.zscc_oid_secc = secc.oid_secc) numclientes, ");
        consulta.append("         (SELECT SUM (acum.num_pedi)  ");
        consulta.append("            FROM int_fuent_venta_real_vacum acum, ");
        consulta.append("                 zon_terri_admin zta ");
        consulta.append("           WHERE acum.perd_oid_peri = peri.oid_peri ");
        consulta.append("             AND acum.pais_oid_pais = fvr.pais_oid_pais ");
        consulta.append("             AND acum.terr_oid_terr = zta.terr_oid_terr ");
        consulta.append("             AND zta.IND_BORR = 0 ");
        consulta.append("             AND zta.zscc_oid_secc = secc.oid_secc) numrealpedidos ");
        consulta.append("    FROM int_fuent_ventas_real fvr, ");
        consulta.append("         cra_perio peri, ");
        consulta.append("         zon_zona zon, ");
        consulta.append("         seg_canal cana, ");
        consulta.append("         zon_terri_admin zta, ");
        consulta.append("         zon_secci secc ");
        consulta.append("   WHERE fvr.perd_oid_peri = peri.oid_peri ");
        consulta.append("     AND fvr.zzon_oid_zona = zon.oid_zona ");
        consulta.append("     AND fvr.terr_oid_terr = zta.terr_oid_terr ");
        consulta.append("     AND zta.zscc_oid_secc = secc.oid_secc ");
        
        //31-07-2007 (Sapaza) incidencia SiCC-20070370, solo se trae unidades administrativas activas
        consulta.append("     AND zta.ind_borr =0 ");
        consulta.append("     AND (secc.ind_borr=0 AND secc.ind_acti=1) ");
        consulta.append("     AND (zon.ind_borr =0 AND zon.ind_acti=1) ");
        
        consulta.append("     AND peri.cana_oid_cana = cana.oid_cana ");
        if (pais != null) {
            consulta.append(" AND FVR.PAIS_OID_PAIS = ?  "); // 1 --pais
            parametros.add(pais);
        }
        if (canal != null) {
            consulta.append(" AND PERI.CANA_OID_CANA = ?  "); // 1 --canal
            parametros.add(canal);
        }
        if (periodo != null) {
            consulta.append(" AND PERI.OID_PERI = ?  "); // 1 --periodo 
            parametros.add(periodo);
        }
        consulta.append("GROUP BY fvr.pais_oid_pais, ");
        consulta.append("         cana.oid_cana, ");
        consulta.append("         cana.cod_cana, ");
        consulta.append("         peri.oid_peri, ");
        consulta.append("         zon.oid_zona, ");
        consulta.append("         zon.cod_zona, ");
        consulta.append("         secc.oid_secc, ");
        consulta.append("         secc.cod_secc ");
        

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerResumenTxPorSeccion: Exception", e);
            this.logSql(" obtenerResumenTxPorSeccion. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList resumen = new ArrayList();

        if (rs != null) {
            int numResultados = rs.getRowCount();

            for (int i = 0; i < numResultados; i++) {
                DTOINTTxCliente dtoINTTxCliente = new DTOINTTxCliente();

                if (rs.getValueAt(i, "PAIS_OID_PAIS") != null) {
                    dtoINTTxCliente.setOidPais(new Long(((BigDecimal) (rs.getValueAt(i, "PAIS_OID_PAIS"))).longValue()));
                }

                if (rs.getValueAt(i, "CODCANALVENTA") != null) {
                    dtoINTTxCliente.setCodigoVenta((String) rs.getValueAt(i, "CODCANALVENTA"));
                }

                /*aplicando BELC300016410
                if(rs.getValueAt(i,"OID_PERI") != null){
                  dtoINTTxCliente.setPeriodoDocumentoReferencia(new String(((BigDecimal)rs.getValueAt(i,"OID_PERI")).toString()));
                }*/
                if (rs.getValueAt(i, "CODZONA") != null) {
                    dtoINTTxCliente.setCodigoZona((String) rs.getValueAt(i, "CODZONA"));
                }

                if (rs.getValueAt(i, "NUMORDENES") != null) {
                    dtoINTTxCliente.setNumeroOrdenes(new Long(((BigDecimal) (rs.getValueAt(i, "NUMORDENES"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMCLIENTES") != null) {
                    dtoINTTxCliente.setNumeroClientes(new Long(((BigDecimal) (rs.getValueAt(i, "NUMCLIENTES"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMCONSULTORASACTIVAS") != null) {
                    dtoINTTxCliente.setNumeroConsultorasActivas(new Long(((BigDecimal) (rs.getValueAt(i, "NUMCONSULTORASACTIVAS"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMACTIVASINICIOCAMPANIA") != null) {
                    dtoINTTxCliente.setNumeroActivasInicioCampania(new Long(((BigDecimal) (rs.getValueAt(i, "NUMACTIVASINICIOCAMPANIA"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMINGRESOS") != null) {
                    dtoINTTxCliente.setNumeroIngresos(new Long(((BigDecimal) (rs.getValueAt(i, "NUMINGRESOS"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMEGRESOS") != null) {
                    dtoINTTxCliente.setNumeroEgresos(new Long(((BigDecimal) (rs.getValueAt(i, "NUMEGRESOS"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMCONSULTORASREINGRESO") != null) {
                    dtoINTTxCliente.setNumeroConsultorasReingreso(new Long(((BigDecimal) (rs.getValueAt(i, "NUMCONSULTORASREINGRESO"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMCONSULTORASRECIBIDAS") != null) {
                    dtoINTTxCliente.setNumeroConsultorasRecibidas(new Long(((BigDecimal) (rs.getValueAt(i, "NUMCONSULTORASRECIBIDAS"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMCONSULTORASENTREGADAS") != null) {
                    dtoINTTxCliente.setNumeroConsultorasEntregadas(new Long(((BigDecimal) (rs.getValueAt(i, "NUMCONSULTORASENTREGADAS"))).longValue()));
                }

                if (rs.getValueAt(i, "NUMREALPEDIDOS") != null) {
                    dtoINTTxCliente.setNumeroRealPedidos(new Long(((BigDecimal) (rs.getValueAt(i, "NUMREALPEDIDOS"))).longValue()));
                }
                
                if (rs.getValueAt(i, "COD_SECC") != null) {
                    dtoINTTxCliente.setCodigoSeccion( (String)rs.getValueAt(i, "COD_SECC") );
                }
                resumen.add(dtoINTTxCliente);
            } //for
        } //if(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerResumenTxPorSeccion(Long pais, Long canal, Long periodo): Salida");

        return resumen;
    } //obtenerResumenTxPorSeccion    

    /**
     * Obtiene el resumen de transacciones por zona
     * Modificado por HRCS - Fecha 11/05/2007 - Cambio Sicc20070255
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList
     * @param periodo Oid del Periodo
     * @param canal Oid del Canal
     * @param pais Oid del Pais
     * @param marca Oid de marca
     */
    public ArrayList obtenerResumenTxPorZona(Long pais, Long canal, Long periodo, Long marca) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerResumenTxPorZona(Long pais, Long canal, Long periodo): Entrada");

        ArrayList listado = new ArrayList();
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT cana.cod_cana, zon.cod_zona codigozona, peri.oid_peri, ");
        consulta.append("   percop.cod_peri codigoperiodo, ");
        consulta.append("   NVL (SUM (fvr.num_acti_fina), 0) numeroconsultorasactivas, ");
        consulta.append("   NVL (SUM (fvr.num_acti_inic), 0) numeroactivasiniciocampania, ");
        consulta.append("   NVL (SUM (fvr.num_ingr), 0) numeroingresos, ");
        consulta.append("   NVL (SUM (fvr.num_egre), 0) numeroegresos, ");
        consulta.append("   NVL (SUM (fvr.num_rein), 0) numeroconsultorasreingreso, ");
        consulta.append("   NVL (SUM (fvr.num_rezo_reci), 0) numeroconsultorasrecibidas, ");
        consulta.append("   NVL (SUM (fvr.num_rezo_entr), 0) numeroconsultorasentregadas, ");
        consulta.append("   (SELECT NVL (SUM (acum.num_orde), 0) ");
        consulta.append("    FROM int_fuent_venta_real_vacum acum ");
        consulta.append("    WHERE acum.zzon_oid_zona = zon.oid_zona ");
        consulta.append("    AND acum.perd_oid_peri = peri.oid_peri) AS numeroordenes, ");
        consulta.append("   (SELECT NVL (SUM (acum.num_clie), 0) ");
        consulta.append("    FROM int_fuent_venta_real_vacum acum ");
        consulta.append("    WHERE acum.zzon_oid_zona = zon.oid_zona ");
        consulta.append("    AND acum.perd_oid_peri = peri.oid_peri) AS numeroclientes, ");
        consulta.append("   (SELECT NVL (SUM (acum.num_pedi), 0) ");
        consulta.append("    FROM int_fuent_venta_real_vacum acum ");
        consulta.append("    WHERE acum.zzon_oid_zona = zon.oid_zona ");
        consulta.append("    AND acum.perd_oid_peri = peri.oid_peri) AS numerorealpedidos, ");
        consulta.append("   NVL (pre.num_unid_vend, 0) estimadounidadesvendidas, ");
        consulta.append("   NVL (pre.val_vent_neta_esta, 0) estimadoventasnetas, ");
        consulta.append("   NVL (pre.num_pedi, 0) estimadonumeropedidos, ");
        consulta.append("   NVL (pre.num_clie, 0) estimadonumeroclientes, ");
        consulta.append("   NVL (pre.num_acti_fina, 0) estimadonumeroactivas, ");
        consulta.append("   NVL (pre.num_ingr, 0) estimadonumeroingresos, ");
        consulta.append("   NVL (pre.num_egre, 0) estimadonumeroegresos, ");
        consulta.append("   NVL (pre.num_rein, 0) estimadonumeroreingresos ");
        // 
        consulta.append(" , NVL ( (SELECT VAL_PORC_ACTI_FINA ");
        consulta.append(" FROM LID_ACTIV_FINAL_ZONA Z, SEG_PAIS X , SEG_MARCA Y");
        consulta.append(" WHERE    X.COD_PAIS= Z.COD_PAIS ");
        consulta.append("  AND X.OID_PAIS= ? ");
        parametros.add(pais);
        consulta.append("  AND  Y.COD_MARC= Z.COD_MARC ");
        consulta.append("  AND Y.OID_MARC= ? ");
        parametros.add(marca);        
        consulta.append("  AND Z.COD_PERI = percop.cod_peri");
        consulta.append("  AND Z.COD_ZONA = zon.cod_zona),");
        consulta.append("  0) AS actividadinfladazona");
        //Cambio SiCC 20070511 - dmorello
        consulta.append(" , NVL(pre.num_cons_clie_priv, 0) AS consultorasclientesprivilege ");
        consulta.append(" , NVL(pre.num_clie_insc_priv, 0) AS clientesinscritosprivilege ");
        consulta.append(" , NVL(pre.num_clie_tran_priv, 0) AS clientestransaccionesprivilege ");
        consulta.append(" , NVL(pre.val_rete_2do_pedi, 0) AS retencion2dopedido ");
        consulta.append(" , NVL(pre.val_rete_3er_pedi, 0) AS retencion3erpedido ");
        consulta.append(" , NVL(pre.val_rete_4to_pedi, 0) AS retencion4topedido ");
        consulta.append(" , NVL(pre.val_rete_acti, 0) AS retencionactivas ");
        consulta.append(" , NVL(pre.val_porc_rota, 0) AS porcentajerotacion ");
        consulta.append(" , NVL(pre.num_posi_egre, 0) AS posiblesegresos ");
        consulta.append(" , NVL(pre.val_rete_posi_egre, 0) AS retencionposiblesegresos ");
        consulta.append(" , NVL(pre.val_porc_egre, 0) AS porcentajeegresos ");
        consulta.append(" , NVL(pre.val_pup, 0) AS pup ");
        consulta.append(" , NVL(pre.val_ppu, 0) AS ppu ");
        // Fin cambio SiCC 20070511 - dmorello
        consulta.append(" FROM ");
        consulta.append("   int_fuent_venta_previ_sap pre, ");
        consulta.append("   cra_perio peri, ");
        consulta.append("   seg_perio_corpo percop, ");
        consulta.append("   seg_canal cana, ");
        consulta.append("   zon_zona zon, ");
        consulta.append("   int_fuent_ventas_real fvr ");
        consulta.append(" WHERE ");
        consulta.append("   pre.perd_oid_peri = peri.oid_peri ");
        consulta.append("   AND pre.zzon_oid_zona = zon.oid_zona ");
        consulta.append("   AND peri.cana_oid_cana = cana.oid_cana ");
        consulta.append("   AND pre.perd_oid_peri = fvr.perd_oid_peri(+) ");
        consulta.append("   AND pre.zzon_oid_zona = fvr.zzon_oid_zona(+) ");
        consulta.append("   AND peri.peri_oid_peri = percop.oid_peri ");
        if (pais != null) {
            consulta.append("   AND peri.pais_oid_pais = ?  "); //1 -- pais
            parametros.add(pais);
        }
        if (canal != null) {
            consulta.append("   AND peri.cana_oid_cana = ?  "); //1 -- canal
            parametros.add(canal);
        }
        if (periodo != null) {
            consulta.append("   AND peri.oid_peri >= ?  "); //1 -- periodo 
            parametros.add(periodo);
        }
        consulta.append(" GROUP BY cana.oid_cana, ");
        consulta.append("  cana.cod_cana, ");
        consulta.append("  peri.oid_peri, ");
        consulta.append("  percop.cod_peri, ");
        consulta.append("  zon.oid_zona, ");
        consulta.append("  zon.cod_zona, ");
        consulta.append("  pre.num_unid_vend, ");
        consulta.append("  pre.num_pedi, ");
        consulta.append("  pre.val_vent_neta_esta, ");
        consulta.append("  pre.num_clie, ");
        consulta.append("  pre.num_acti_fina, ");
        consulta.append("  pre.num_ingr, ");
        consulta.append("  pre.num_egre, ");
        consulta.append("  pre.num_rein ");
        // Cambio SiCC 20070511 - dmorello
        consulta.append(", pre.val_acti_infl_zona ");
        consulta.append(", pre.num_cons_clie_priv ");
        consulta.append(", pre.num_clie_insc_priv ");
        consulta.append(", pre.num_clie_tran_priv ");
        consulta.append(", pre.val_rete_2do_pedi ");
        consulta.append(", pre.val_rete_3er_pedi ");
        consulta.append(", pre.val_rete_4to_pedi ");
        consulta.append(", pre.val_rete_acti ");
        consulta.append(", pre.val_porc_rota ");
        consulta.append(", pre.num_posi_egre ");
        consulta.append(", pre.val_rete_posi_egre ");
        consulta.append(", pre.val_porc_egre ");
        consulta.append(", pre.val_pup ");
        consulta.append(", pre.val_ppu ");
        // Fin cambio SiCC 20070511 - dmorello
        //Fin consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString().toUpperCase(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerResumenTxPorZona  : Exception", e);
            this.logSql(" obtenerResumenTxPorZona  SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        DTOINTTxCliente dto = null;

        if (rs != null) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                dto = new DTOINTTxCliente();

                if (rs.getValueAt(i, "CODIGOZONA") != null) {
                    dto.setCodigoZona((String) rs.getValueAt(i, "CODIGOZONA"));
                }
                
                if (rs.getValueAt(i, "CODIGOPERIODO") != null) {
                    dto.setPeriodoDocumento((String) rs.getValueAt(i, "CODIGOPERIODO"));
                }
                
                if (rs.getValueAt(i, "NUMEROORDENES") != null) {
                    dto.setNumeroOrdenes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROORDENES")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROCLIENTES") != null) {
                    dto.setNumeroClientes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCLIENTES")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROCONSULTORASACTIVAS") != null) {
                    dto.setNumeroConsultorasActivas(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCONSULTORASACTIVAS")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROACTIVASINICIOCAMPANIA") != null) {
                    dto.setNumeroActivasInicioCampania(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROACTIVASINICIOCAMPANIA")).longValue()));
                }
                if (rs.getValueAt(i, "NUMEROINGRESOS") != null) {
                    dto.setNumeroIngresos(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROINGRESOS")).longValue()));
                }
                if (rs.getValueAt(i, "NUMEROEGRESOS") != null) {
                    dto.setNumeroEgresos(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROEGRESOS")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROCONSULTORASREINGRESO") != null) {
                    dto.setNumeroConsultorasReingreso(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCONSULTORASREINGRESO")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROCONSULTORASRECIBIDAS") != null) {
                    dto.setNumeroConsultorasRecibidas(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCONSULTORASRECIBIDAS")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROCONSULTORASENTREGADAS") != null) {
                    dto.setNumeroConsultorasEntregadas(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCONSULTORASENTREGADAS")).longValue()));
                }

                if (rs.getValueAt(i, "NUMEROREALPEDIDOS") != null) {
                    dto.setNumeroRealPedidos(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROREALPEDIDOS")).longValue()));
                }

                if (rs.getValueAt(i, "ESTIMADOUNIDADESVENDIDAS") != null) {
                    dto.setUnidadesVendidas(new Integer(((BigDecimal) rs.getValueAt(i, "ESTIMADOUNIDADESVENDIDAS")).intValue()));
                }

                if (rs.getValueAt(i, "ESTIMADOVENTASNETAS") != null) {
                    dto.setEstimadoVentasNetas((BigDecimal) rs.getValueAt(i, "ESTIMADOVENTASNETAS"));
                }

                if (rs.getValueAt(i, "ESTIMADONUMEROPEDIDOS") != null) {
                    dto.setEstimadoNumeroPedidos(new Long(((BigDecimal) rs.getValueAt(i, "ESTIMADONUMEROPEDIDOS")).longValue()));
                }

                if (rs.getValueAt(i, "ESTIMADONUMEROCLIENTES") != null) {
                    dto.setEstimadoNumeroClientes(new Long(((BigDecimal) rs.getValueAt(i, "ESTIMADONUMEROCLIENTES")).longValue()));
                }

                if (rs.getValueAt(i, "ESTIMADONUMEROACTIVAS") != null) {
                    dto.setEstimadoNumeroActivas(new Long(((BigDecimal) rs.getValueAt(i, "ESTIMADONUMEROACTIVAS")).longValue()));
                }

                if (rs.getValueAt(i, "ESTIMADONUMEROINGRESOS") != null) {
                    dto.setEstimadoNumeroIngresos(new Long(((BigDecimal) rs.getValueAt(i, "ESTIMADONUMEROINGRESOS")).longValue()));
                }

                if (rs.getValueAt(i, "ESTIMADONUMEROEGRESOS") != null) {
                    dto.setEstimadoNumeroEgresos(new Long(((BigDecimal) rs.getValueAt(i, "ESTIMADONUMEROEGRESOS")).longValue()));
                }

                if (rs.getValueAt(i, "ESTIMADONUMEROREINGRESOS") != null) {
                    dto.setEstimadoNumeroReingresos(new Long(((BigDecimal) rs.getValueAt(i, "ESTIMADONUMEROREINGRESOS")).longValue()));
                }
                // Cambio SiCC 20070511 - dmorello
                if (rs.getValueAt(i, "ACTIVIDADINFLADAZONA") != null) {
                    dto.setActividadInfladaZona((BigDecimal)rs.getValueAt(i, "ACTIVIDADINFLADAZONA"));
                }
                if (rs.getValueAt(i, "CONSULTORASCLIENTESPRIVILEGE") != null) {
                    dto.setNroConsultorasClientesPrivilege(new Long(((BigDecimal)rs.getValueAt(i, "CONSULTORASCLIENTESPRIVILEGE")).longValue()));
                }
                if (rs.getValueAt(i, "CLIENTESINSCRITOSPRIVILEGE") != null) {
                    dto.setNroClientesInscritosPrivilege(new Long(((BigDecimal)rs.getValueAt(i, "CLIENTESINSCRITOSPRIVILEGE")).longValue()));
                }
                if (rs.getValueAt(i, "CLIENTESTRANSACCIONESPRIVILEGE") != null) {
                    dto.setNroClientesTransaccionesPrivilege(new Long(((BigDecimal)rs.getValueAt(i, "CLIENTESTRANSACCIONESPRIVILEGE")).longValue()));
                }
                if (rs.getValueAt(i, "RETENCION2DOPEDIDO") != null) {
                    dto.setRetencion2doPedido(new Long(((BigDecimal)rs.getValueAt(i, "RETENCION2DOPEDIDO")).longValue()));
                }
                if (rs.getValueAt(i, "RETENCION3ERPEDIDO") != null) {
                    dto.setRetencion3erPedido(new Long(((BigDecimal)rs.getValueAt(i, "RETENCION3ERPEDIDO")).longValue()));
                }
                if (rs.getValueAt(i, "RETENCION4TOPEDIDO") != null) {
                    dto.setRetencion4toPedido(new Long(((BigDecimal)rs.getValueAt(i, "RETENCION4TOPEDIDO")).longValue()));
                }
                if (rs.getValueAt(i, "RETENCIONACTIVAS") != null) {
                    dto.setRetencionActivas(new Long(((BigDecimal)rs.getValueAt(i, "RETENCIONACTIVAS")).longValue()));
                }
                if (rs.getValueAt(i, "PORCENTAJEROTACION") != null) {
                    dto.setPorcentajeRotacion((BigDecimal)rs.getValueAt(i, "PORCENTAJEROTACION"));
                }
                if (rs.getValueAt(i, "POSIBLESEGRESOS") != null) {
                    dto.setPosiblesEgresos(new Long(((BigDecimal)rs.getValueAt(i, "POSIBLESEGRESOS")).longValue()));
                }
                if (rs.getValueAt(i, "RETENCIONPOSIBLESEGRESOS") != null) {
                    dto.setRetencionPosiblesEgresos(new Long(((BigDecimal)rs.getValueAt(i, "RETENCIONPOSIBLESEGRESOS")).longValue()));
                }
                if (rs.getValueAt(i, "PORCENTAJEEGRESOS") != null) {
                    dto.setPorcentajeEgresos((BigDecimal)rs.getValueAt(i, "PORCENTAJEEGRESOS"));
                }
                if (rs.getValueAt(i, "PUP") != null) {
                    dto.setPup((BigDecimal)rs.getValueAt(i, "PUP"));
                }
                if (rs.getValueAt(i, "PPU") != null) {
                    dto.setPpu((BigDecimal)rs.getValueAt(i, "PPU"));
                }
                // Fin cambio SiCC 20070511 - dmorello

                listado.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerResumenTxPorZona(Long pais, Long canal, Long periodo): Salida");

        return listado;
    }

    /**
     * Datos utlizados para poder realizar las pruebas del metodo obtenerInfoPedidosPorDia
     * pais = 1
     * marca = 1
     * canal =  1
     * acceso = 1
     * periodo = 57
     * fechaFacturacion = '2005-11-11'
    */
    public ArrayList obtenerInfoPedidosPorDia (Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion) throws MareException{ 
      
        UtilidadesLog.info("DAOINTDAT.obtenerInfoPedidosPorDia(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Entrada");
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector(); 
    
        consulta.append(" SELECT "); 
        consulta.append("         SOC.PAIS_OID_PAIS PAIS, "); 
        consulta.append("         PERI.CANA_OID_CANA CANAL, "); 
        consulta.append("         SOCI.COD_SOCI CODIGO_EMPRESA, "); 
        consulta.append("         PERI.OID_PERI PERIODO, "); 
        consulta.append("         COUNT(SOC.OID_SOLI_CABE) NUMERO_ORDENES_COMPRA, "); 
        consulta.append("         COUNT(DISTINCT(CLI.OID_CLIE)) NUMERO_PEDIDOS "); 
        
        consulta.append(" FROM "); 
        consulta.append("         PED_SOLIC_CABEC SOC, "); 
        consulta.append("         CRA_PERIO PERI, "); 
        consulta.append("         SEG_SOCIE SOCI, "); 
        consulta.append("         MAE_CLIEN CLI, "); 
        consulta.append("         MAE_CLIEN_TIPO_SUBTI CTS, "); 
        consulta.append("         SEG_SUBAC SUBAC, "); 
        //pzerbino 18/10/2006 Incidencia 24361
        consulta.append("         PED_TIPO_SOLIC_PAIS TSP, "); 
        consulta.append("         PED_TIPO_SOLIC TS  ");
        
        consulta.append(" WHERE "); 
        consulta.append("         SOC.SOCI_OID_SOCI = SOCI.OID_SOCI "); 
        consulta.append("         AND SOC.PERD_OID_PERI = PERI.OID_PERI "); 
        consulta.append("         AND SOC.CLIE_OID_CLIE = CLI.OID_CLIE "); 
        consulta.append("         AND CTS.CLIE_OID_CLIE = CLI.OID_CLIE "); 
        consulta.append("         AND SOC.SBAC_OID_SBAC = SUBAC.OID_SBAC ");         
        consulta.append("         AND SOC.PAIS_OID_PAIS = ? "); 
        
        parametros.add(pais);                     
        if (marca != null){ 
            consulta.append("         AND PERI.MARC_OID_MARC = ? "); 
            parametros.add(marca);                             
        } 
        
        if (canal != null){ 
            consulta.append("         AND PERI.CANA_OID_CANA = ?  "); 
            parametros.add(canal);                             
        }         
        
        if (acceso != null){ 
            consulta.append("         AND SUBAC.ACCE_OID_ACCE = ? "); 
            parametros.add(acceso);                 
        } 

        if (fechaFacturacion != null){ 
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
            java.sql.Date fechaDesde1 = new java.sql.Date(fechaFacturacion.getTime());             
            String sFechaDesde1 = sdf1.format(fechaDesde1);            
            consulta.append(" AND TO_DATE(TO_CHAR(SOC.FEC_FACT, 'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS') = TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ");             
            parametros.add(sFechaDesde1);         
        } 
        
        if (periodo != null){ 
            consulta.append("         AND PERI.OID_PERI = ? "); 
            parametros.add(periodo);             
        } 
        
        consulta.append("         AND SOC.IND_TS_NO_CONSO = 1 "); 
        consulta.append("         AND SOC.IND_OC = 1 "); 
        consulta.append("         AND SOC.IND_PEDI_PRUE = 0 "); 
        consulta.append("         AND CTS.TICL_OID_TIPO_CLIE = ? "); 
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);         
        //pzerbino 18/10/2006 Incidencia 24361
        consulta.append("         AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS "); 
        consulta.append("         AND TS.OID_TIPO_SOLI = TSP.TSOL_OID_TIPO_SOLI "); 
        consulta.append("         AND TS.IND_DEVO = 0 "); 
        consulta.append("         AND TS.IND_ANUL = 0 ");         
        consulta.append(" GROUP BY "); 
        consulta.append("         SOC.PAIS_OID_PAIS, "); 
        consulta.append("         PERI.CANA_OID_CANA, "); 
        consulta.append("         SOCI.COD_SOCI, "); 
        consulta.append("         PERI.OID_PERI "); 
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
         UtilidadesLog.info("consulta.toString()" +consulta.toString());
        
        try{ 
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);            
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error(" obtenerInfoPedidosPorDia : Exception",e); 
            this.logSql(" obtenerInfoPedidosPorDia . SQL: ",consulta.toString(),parametros); 
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
        
        ArrayList resultado = new ArrayList(); 
        UtilidadesLog.info("rs" + rs);
        UtilidadesLog.info("rsrowcant" + rs.getRowCount());
        if (!rs.esVacio()){ 
            for (int i=0; i<rs.getRowCount(); i++){ 
                
                DTOINTInfoCampania   dto = new DTOINTInfoCampania (); 

                if (rs.getValueAt(i,"CODIGO_EMPRESA") != null) 
                    dto.setCodigoEmpresa((String)rs.getValueAt(i,"CODIGO_EMPRESA"));                 
                    
                if (rs.getValueAt(i,"NUMERO_ORDENES_COMPRA") != null) 
                    dto.setNumeroOrdenesCompra(new Long(((BigDecimal)rs.getValueAt(i,"NUMERO_ORDENES_COMPRA")).longValue())); 
                
                if (rs.getValueAt(i,"NUMERO_PEDIDOS") != null) 
                    dto.setNumeroPedidos(new Long(((BigDecimal)rs.getValueAt(i,"NUMERO_PEDIDOS")).longValue()));                 

                UtilidadesLog.info("dto antes de poner en arraylist " + dto);
                resultado.add(dto); 
            } 
        } 
        
        UtilidadesLog.info("DAOINTDAT.obtenerInfoPedidosPorDia(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Salida");     
        return resultado; 
    }

    /**
     * @CHANGELOG MGRODRIGUEZ SICC-DMCO-INTSAB-GCC-001-003
     * */
    public ArrayList obtenerTransaccionesCliente (Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion) throws MareException { 
        //Traza de entrada 
        UtilidadesLog.info("DAOINTDAT.obtenerTransaccionesCliente(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Entrada");
        
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector(); 
        
        // Consulta SQL (Incidencia BELC300016329) 
        /*consulta.append(" SELECT DISTINCT CLI.COD_CLIE CODIGOCLIENTE, ACCE.COD_ACCE CODIGOACCESO, ");
        consulta.append("        TERR.COD_TERR CODIGOTERRITORIO, SOC.VAL_NUME_SOLI NUMEROSOLICITUD, ");
        consulta.append("        SOC.FEC_FACT FECHAFACTURACION, PCOR.COD_PERI PERIODODOCUMENTOREFERENCIA, ");           
        consulta.append("        TS.COD_TIPO_SOLI TIPOSOLICITUD, ");
        consulta.append("        DECODE( TS.IND_DEVO, 1, 'true', 0, 'false' ) INDICADORDEVOLUCIONES, ");
        consulta.append("        DECODE( TS.IND_ANUL, 1, 'true', 0, 'false' ) INDICADORANULACIONES,  "); 
        consulta.append("        PRO.COD_SAP CODIGOPRODUCTO, POS.VAL_CODI_VENT CODIGOVENTA, ");
        consulta.append("        TOF.COD_TIPO_OFER TIPOOFERTA, POS.NUM_UNID_ATEN UNIDADESATENDIDAS, ");
        consulta.append("        DECODE(POS.NUM_UNID_DEMA, 0, 0, POS.NUM_UNID_DEMA-POS.NUM_UNID_ATEN) UNIDADESNOATENDIDAS,  "); 
        consulta.append("        POS.VAL_PREC_NETO_UNIT_LOCA PRECIONETOUNITARIOLOCAL, ");
        consulta.append("        POS.VAL_PREC_NETO_TOTA_LOCA PRECIONETOTOTALLOCAL, ");
        consulta.append("        POS.VAL_PREC_FACT_UNIT_LOCA PRECIOFACTURAUNITARIOLOCAL, ");
        consulta.append("        POS.VAL_PREC_FACT_TOTA_LOCA PRECIOFACTURATOTALLOCAL,   "); 
        consulta.append("        MARC.DES_MARC_PROD MARCAPRODUCTO,  "); 
        //Modificado por Cristian Valenzuela - 10/2/2006
        //En vez de concatenar los dos primeros niveles del ubigeo,
        //como pide el DECU, los sumaba!!!!!!
        //consulta.append("        (VAL.ORDE_1 + VAL.ORDE_2) UBICACIONGEOGRAFICA  "); 
        consulta.append("        VAL.ORDE_1 || VAL.ORDE_2 UBICACIONGEOGRAFICA "); 
        //FIN - Modificado por Cristian Valenzuela - 10/2/2006
               
        consulta.append("   FROM PED_SOLIC_CABEC SOC, PED_SOLIC_CABEC DREF, PED_SOLIC_POSIC POS, ");
        consulta.append("        PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS, PED_ESTAD_POSIC EST,  "); 
        consulta.append("        CRA_PERIO PERI, CRA_PERIO PERI2, SEG_PERIO_CORPO PCOR, MAE_CLIEN CLI, ");
        consulta.append("        MAE_CLIEN_UNIDA_ADMIN ADM, ZON_TERRI_ADMIN TAD, ZON_TERRI TERR, SEG_ACCES ACCE, "); 
        consulta.append("        MAE_PRODU PRO, PRE_OFERT_DETAL OFD, PRE_TIPO_OFERT TOF, SEG_SUBAC SUBAC,  "); 
        consulta.append("        ZON_VALOR_ESTRU_GEOPO VAL, SEG_MARCA_PRODU MARC  "); 
              
        consulta.append("  WHERE SOC.PERD_OID_PERI = PERI.OID_PERI ");
        consulta.append("        AND SOC.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append("        AND POS.SOCA_OID_SOLI_CABE = SOC.OID_SOLI_CABE "); 
        consulta.append("        AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        consulta.append("        AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");//AND PERI.ACCE_OID_ACCE = ACCE.OID_ACCE(+) "); 
        consulta.append("        AND ADM.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append("        AND ADM.ZTAD_OID_TERR_ADMI = TAD.OID_TERR_ADMI ");//AND ADM.PERD_OID_PERI_INI = PERI.OID_PERI "); 
        consulta.append("        AND TAD.TERR_OID_TERR = TERR.OID_TERR ");
        consulta.append("        AND POS.ESPO_OID_ESTA_POSI = EST.OID_ESTA_POSI ");
        consulta.append("        AND POS.PROD_OID_PROD = PRO.OID_PROD "); 
        consulta.append("        AND subac.acce_oid_acce = acce.OID_ACCE ");
        consulta.append("        AND POS.VAL_CODI_VENT = OFD.VAL_CODI_VENT ");
        consulta.append("        AND OFD.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER ");

        //jrivas 22/3/2006 Inc. DBLG40000677
        //consulta.append("        AND SOC.SOCA_OID_SOLI_CABE = DREF.OID_SOLI_CABE "); 
        consulta.append("        AND SOC.SOCA_OID_DOCU_REFE = DREF.OID_SOLI_CABE(+) "); 
        consulta.append("        AND DREF.PERD_OID_PERI = PERI2.OID_PERI(+) ");
        consulta.append("        AND PERI2.PERI_OID_PERI = PCOR.OID_PERI(+) ");


        consulta.append("        AND SOC.SBAC_OID_SBAC = SUBAC.OID_SBAC ");
        consulta.append("        AND EST.OID_ESTA_POSI <> ? "); 
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO); 
        consulta.append("        AND POS.PROD_OID_PROD = PRO.OID_PROD "); 
        consulta.append("        AND MARC.OID_MARC_PROD = PRO.MAPR_OID_MARC_PROD "); 
        consulta.append("        AND VAL.OID_VALO_ESTR_GEOP = SOC.VEPO_OID_VALO_ESTR_GEOP "); 
                             
        if(pais != null){ 
            consulta.append(" AND SOC.PAIS_OID_PAIS = ? "); 
            parametros.add(pais); 
        } 
        if(marca != null){ 
            consulta.append(" AND PERI.MARC_OID_MARC = ? "); 
            parametros.add(marca); 
        } 
        if(canal != null){ 
            consulta.append(" AND PERI.CANA_OID_CANA = ? "); 
            parametros.add(canal); 
        } 
        if(acceso != null){ 
            consulta.append(" AND SUBAC.ACCE_OID_ACCE = ? "); 
            parametros.add(acceso); 
        } 
        if(periodo != null){ 
            consulta.append(" AND PERI.OID_PERI = ? "); 
            parametros.add(periodo); 
        } 
        if(fechaFacturacion != null){ 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime()); 

            String sFecha = sdf.format(fecha);                                                           
            consulta.append(" AND SOC.FEC_FACT <= TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");           
            parametros.add(sFecha); 
        } 

        //jrivas 22/3/2006 Inc. DBLG40000677
        //consulta.append(" AND SOC.IND_TS_NO_CONSO = 1 AND SOC.IND_OC = 1 AND SOC.IND_PEDI_PRUE = 0  "); 
        consulta.append(" AND ((soc.SOCA_OID_DOCU_REFE IS NULL ");
        consulta.append(" AND soc.ind_ts_no_conso = 1 ");
        consulta.append(" AND soc.ind_oc = 1 ");
        consulta.append(" AND soc.ind_pedi_prue = 0) OR ");
        consulta.append(" (soc.SOCA_OID_DOCU_REFE IS NOT NULL ");
        consulta.append(" AND dref.ind_ts_no_conso = 0 "); 
        consulta.append(" AND dref.ind_oc = 1 ");
        consulta.append(" AND dref.ind_pedi_prue = 0)) ");*/
        
      
        consulta.append("        SELECT DISTINCT cli.cod_clie codigocliente,  ");
        consulta.append("        acce.cod_acce codigoacceso, ");
        consulta.append("        terr.cod_terr codigoterritorio, ");
        consulta.append("        soc.val_nume_soli numerosolicitud, ");
        consulta.append("        soc.fec_fact fechafacturacion, ");
        consulta.append("        pcor.cod_peri periododocumentoreferencia, ");
        consulta.append("        ts.cod_tipo_soli tiposolicitud, ");
        consulta.append("        DECODE (ts.ind_devo, 1, 'true', 0, 'false' ) indicadordevoluciones, ");
        consulta.append("        DECODE (ts.ind_anul, 1, 'true', 0, 'false' ) indicadoranulaciones, ");
        consulta.append("        pro.cod_sap codigoproducto, ");
        consulta.append("        pos.val_codi_vent codigoventa, ");
        consulta.append("        tof.cod_tipo_ofer tipooferta, ");
        consulta.append("        NVL (pos.num_unid_aten, 0) unidadesatendidas, ");
        consulta.append("        NVL (DECODE (pos.num_unid_dema, 0, 0, pos.num_unid_dema - pos.num_unid_aten),0) unidadesnoatendidas, ");
        consulta.append("        NVL (pos.val_prec_neto_unit_loca,0) precionetounitariolocal, ");
        consulta.append("        NVL (pos.val_prec_neto_tota_loca,0) precionetototallocal, ");
        consulta.append("        NVL (pos.val_prec_fact_unit_loca,0) preciofacturaunitariolocal, ");
        consulta.append("        NVL (pos.val_prec_fact_tota_loca,0) preciofacturatotallocal, ");
        consulta.append("        marc.des_marc_prod marcaproducto, ");
        //pzerbino 30/10/2006 incidencia 24361
        //consulta.append("        val.orde_1 || val.orde_2 ubicaciongeografica, ");
                        
                        //Se agrrega por cambios en dat 22 24361
        consulta.append("        pcor.cod_peri periododocumento, ca.cod_cana codigocanal,");
        consulta.append("        ca2.cod_cana codigocanalref, ac2.cod_acce codigoaccesoref,");
        consulta.append("        te2.cod_terr codigoterritorioref, ");
        consulta.append("        dref.val_nume_soli numerosolicitudref, ");
        consulta.append("        dref.fec_fact fechafacturacionref ");
        consulta.append("   FROM ped_solic_cabec soc, ");
        consulta.append("        ped_solic_cabec dref, ");
        consulta.append("        ped_solic_posic pos, ");
        consulta.append("        ped_tipo_solic_pais tsp, ");
        consulta.append("        ped_tipo_solic ts, ");
        consulta.append("        ped_estad_posic est, ");
        consulta.append("        cra_perio peri, ");
        consulta.append("        cra_perio peri2, ");
        consulta.append("        seg_perio_corpo pcor, ");
        consulta.append("        mae_clien cli, ");
        consulta.append("        mae_clien_unida_admin adm, ");
        consulta.append("        zon_terri_admin tad, ");
        consulta.append("        zon_terri terr, ");
        consulta.append("        seg_acces acce, ");
        consulta.append("        mae_produ pro, ");
        consulta.append("        pre_ofert_detal ofd, ");
        consulta.append("        pre_tipo_ofert tof, ");
        //consulta.append("        seg_subac subac, ");
                        //zon_valor_estru_geopo val,
        consulta.append("        seg_marca_produ marc, ");
        consulta.append("        mae_produ prod, ");
                        //Se agrega por cambio INT_DAT_:002
        consulta.append("        seg_perio_corpo pcor2, ");
        consulta.append("        zon_terri te2, ");
        consulta.append("        seg_canal ca, ");
        consulta.append("        seg_canal ca2, ");
        consulta.append("        seg_acces ac2, ");
        consulta.append("        seg_subac sa2 ");
        consulta.append("  WHERE soc.perd_oid_peri = peri.oid_peri ");
        consulta.append("        AND soc.clie_oid_clie = cli.oid_clie ");
        consulta.append("        AND pos.soca_oid_soli_cabe = soc.oid_soli_cabe ");
        consulta.append("        AND soc.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        consulta.append("        AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
        consulta.append("        AND peri.acce_oid_acce = acce.oid_acce(+) ");
        consulta.append("        AND adm.clie_oid_clie = cli.oid_clie ");
        consulta.append("        AND adm.ztad_oid_terr_admi = tad.oid_terr_admi ");
        consulta.append("        AND adm.perd_oid_peri_ini = peri.oid_peri ");
        consulta.append("        AND tad.terr_oid_terr = terr.oid_terr ");
        consulta.append("        AND pos.espo_oid_esta_posi = est.oid_esta_posi ");
        consulta.append("        AND pos.prod_oid_prod = pro.oid_prod ");
        consulta.append("        AND ofd.prod_oid_prod = pro.oid_prod ");
        consulta.append("        AND ofd.tofe_oid_tipo_ofer = tof.oid_tipo_ofer ");
        consulta.append("        AND soc.soca_oid_docu_refe = dref.oid_soli_cabe(+) ");
        consulta.append("        AND dref.perd_oid_peri = peri2.oid_peri(+) ");
        consulta.append("        AND peri2.peri_oid_peri = pcor.oid_peri(+) ");
        consulta.append("        AND est.oid_esta_posi <> ? ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO); 
        
        if(pais != null){ 
            consulta.append(" AND SOC.PAIS_OID_PAIS = ? "); 
            parametros.add(pais); 
        } 
        if(marca != null){ 
            consulta.append(" AND PERI.MARC_OID_MARC = ? "); 
            parametros.add(marca); 
        } 
        if(canal != null){ 
            consulta.append(" AND PERI.CANA_OID_CANA = ? "); 
            parametros.add(canal); 
        } 
        if(acceso != null){ 
            consulta.append(" AND SUBAC.ACCE_OID_ACCE = ? "); 
            parametros.add(acceso); 
        } 
        if(periodo != null){ 
            consulta.append(" AND PERI.OID_PERI = ? "); 
            parametros.add(periodo); 
        } 
        if(fechaFacturacion != null){ 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime()); 

            String sFecha = sdf.format(fecha);                                                           
            consulta.append(" AND SOC.FEC_FACT <= TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");           
            parametros.add(sFecha); 
        } 
        consulta.append("        AND (   (    soc.soca_oid_docu_refe IS NULL ");
        consulta.append("        AND soc.ind_ts_no_conso = 1 ");
        consulta.append("        AND soc.ind_oc = 1 ");
        consulta.append("        AND soc.ind_pedi_prue = 0 ");
        consulta.append("        ) ");
        consulta.append("        OR (    soc.soca_oid_docu_refe IS NOT NULL ");
        consulta.append("        AND dref.ind_ts_no_conso = 0 ");
        consulta.append("        AND dref.ind_oc = 0 ");
        consulta.append("        AND dref.ind_pedi_prue = 0 ");
        consulta.append("        ) ");
        consulta.append("        ) ");
        consulta.append("        AND pos.prod_oid_prod = prod.oid_prod ");
        consulta.append("        AND marc.oid_marc_prod = prod.mapr_oid_marc_prod ");
        //POr cambios incidencia 24361
        //AND val.oid_valo_estr_geop = soc.vepo_oid_valo_estr_geop
        consulta.append("        AND peri.cana_oid_cana = ca.oid_cana ");
        consulta.append("        AND peri.peri_oid_peri = pcor.oid_peri ");
        consulta.append("        AND soc.soca_oid_docu_refe = dref.oid_soli_cabe(+) ");
        consulta.append("        AND dref.perd_oid_peri = peri2.oid_peri(+) ");
        consulta.append("        AND peri2.peri_oid_peri = pcor2.oid_peri(+) ");
        consulta.append("        AND peri2.cana_oid_cana = ca2.oid_cana(+) ");
        consulta.append("        AND dref.perd_oid_peri = peri2.oid_peri(+) ");
        consulta.append("        AND dref.sbac_oid_sbac = sa2.oid_sbac(+) ");
        consulta.append("        AND sa2.acce_oid_acce = ac2.oid_acce(+) ");
        consulta.append("        AND dref.terr_oid_terr = te2.oid_terr(+) ");
           //Se cambio por incidencia 24361
        /*AND pos.prod_oid_prod = pro.oid_prod
          AND marc.oid_marc_prod = pro.mapr_oid_marc_prod
          AND subac.acce_oid_acce = acce.oid_acce
          AND pos.val_codi_vent = ofd.val_codi_vent
          AND soc.sbac_oid_sbac = subac.oid_sbac
        */  
        UtilidadesLog.info("consulta ***** " + consulta.toString());              
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error(" obtenerTransaccionesCliente: Exception",e); 
            this.logSql(" obtenerTransaccionesCliente. SQL: ", 
            consulta.toString(),parametros); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
        
        ArrayList lista = new ArrayList(); 
        
        // Rellenamos el ArrayList con objetos 'DTOINTTxCliente' 
        if(rs != null){ 
            int x = rs.getRowCount(); 
            for(int i = 0; i < x; i++){ 
                DTOINTTxCliente dto = new DTOINTTxCliente(); 

               
                    if(rs.getValueAt(i,"CODIGOCLIENTE") != null){                 
                        dto.setCodigoCliente(rs.getValueAt(i,"CODIGOCLIENTE").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOACCESO") != null){ 
                        dto.setCodigoAcceso(rs.getValueAt(i,"CODIGOACCESO").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOTERRITORIO") != null){ 
                        dto.setCodigoTerritorio(new Long(rs.getValueAt(i,"CODIGOTERRITORIO").toString())); 
                    } 
                    if(rs.getValueAt(i,"NUMEROSOLICITUD") != null){ 
                        dto.setNumeroSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROSOLICITUD")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"FECHAFACTURACION") != null){ 
                        dto.setFechaFacturacion(new Date(((java.sql.Date)rs.getValueAt(i,"FECHAFACTURACION")).getTime())); 
                    } 
                    if(rs.getValueAt(i,"PERIODODOCUMENTO") != null){ 
                        dto.setPeriodoDocumento(rs.getValueAt(i,"PERIODODOCUMENTO").toString()); 
                    } 
                    if(rs.getValueAt(i,"PERIODODOCUMENTOREFERENCIA") != null){ 
                        dto.setPeriodoDocumentoReferencia(rs.getValueAt(i,"PERIODODOCUMENTOREFERENCIA").toString()); 
                    } 
                    if(rs.getValueAt(i,"TIPOSOLICITUD") != null){ 
                        dto.setTipoSolicitud(rs.getValueAt(i,"TIPOSOLICITUD").toString()); 
                    } 
                    if(rs.getValueAt(i,"INDICADORDEVOLUCIONES") != null){ 
                        if ((rs.getValueAt(i,"INDICADORDEVOLUCIONES").toString()).equals("false")){ 
                            dto.setIndicadorDevoluciones(Boolean.FALSE); 
                        }else{ 
                            dto.setIndicadorDevoluciones(Boolean.TRUE); 
                        } 
                    } 
                    if(rs.getValueAt(i,"INDICADORANULACIONES") != null){ 
                        if ((rs.getValueAt(i,"INDICADORANULACIONES").toString()).equals("false")){ 
                            dto.setIndicadorAnulaciones(Boolean.FALSE); 
                        }else{ 
                            dto.setIndicadorAnulaciones(Boolean.TRUE); 
                        } 
                    } 
                    if(rs.getValueAt(i,"CODIGOPRODUCTO") != null){                 
                        dto.setCodigoProducto(rs.getValueAt(i,"CODIGOPRODUCTO").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOVENTA") != null){                 
                        dto.setCodigoVenta(rs.getValueAt(i,"CODIGOVENTA").toString()); 
                    } 
                    if(rs.getValueAt(i,"TIPOOFERTA") != null){                 
                        dto.setTipoOferta(rs.getValueAt(i,"TIPOOFERTA").toString()); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESATENDIDAS") != null){ 
                        dto.setUnidadesAtendidas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESATENDIDAS")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESNOATENDIDAS") != null){ 
                        dto.setUnidadesNoAtendidas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESNOATENDIDAS")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"PRECIONETOUNITARIOLOCAL") != null){ 
                        dto.setPrecioNetoUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIONETOUNITARIOLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIONETOTOTALLOCAL") != null){ 
                        dto.setPrecioNetoTotalLocal((BigDecimal)rs.getValueAt(i,"PRECIONETOTOTALLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIOFACTURAUNITARIOLOCAL") != null){ 
                        dto.setPrecioFacturaUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIOFACTURAUNITARIOLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIOFACTURATOTALLOCAL") != null){ 
                        dto.setPrecioFacturaTotalLocal((BigDecimal)rs.getValueAt(i,"PRECIOFACTURATOTALLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"CODIGOCANAL") != null){ 
                        dto.setCodigoCanal(rs.getValueAt(i,"CODIGOCANAL").toString()); 
                    } 
                    
                    /* vbongiov -- 12/10/2006 - Reversión del cambio "INT-001 Interfaces Calypso-Retail"     
                    //Agregado por Cristian Valenzuela - 10/02/2006
                    //Se habian agregado dos campos nuevos a la interface de salida
                    //pero no se estaban seteando en el DTO que luego se usa
                    //para generar los registros del fichero.
                    if(rs.getValueAt(i, "MARCAPRODUCTO")!=null) {
                        dto.setMarcaProducto(rs.getValueAt(i, "MARCAPRODUCTO").toString());
                    }       
                    if(rs.getValueAt(i, "UBICACIONGEOGRAFICA")!=null) {
                        dto.setUbicacionGeografica(rs.getValueAt(i, "UBICACIONGEOGRAFICA").toString());
                    }                    
                    //FIN - Agregado por Cristian Valenzuela - 10/02/2006
                    */
                    
                    if (dto.getIndicadorAnulaciones().booleanValue() || dto.getIndicadorDevoluciones().booleanValue()){
                       
                        if(rs.getValueAt(i,"CODIGOCANALREF") != null){ 
                           dto.setPrecioFacturaTotalLocal((BigDecimal)rs.getValueAt(i,"CODIGOCANALREF")); 
                        } 
                        if(rs.getValueAt(i,"CODIGOACCESOREF") != null){ 
                           dto.setCodigoAcceso(rs.getValueAt(i,"CODIGOACCESOREF").toString()); 
                        } 
                        if(rs.getValueAt(i,"CODIGOTERRITORIOREF") != null){ 
                            dto.setCodigoTerritorio(new Long(rs.getValueAt(i,"CODIGOTERRITORIOREF").toString())); 
                        } 
                        if(rs.getValueAt(i,"NUMEROSOLICITUDREF") != null){ 
                            dto.setNumeroSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROSOLICITUDREF")).longValue())); 
                        } 
                        if(rs.getValueAt(i,"FECHAFACTURACIONREF") != null){ 
                            dto.setFechaFacturacion(new Date(((java.sql.Date)rs.getValueAt(i,"FECHAFACTURACIONREF")).getTime())); 
                        }                                             
                    }
                    
                    lista.add(dto); 
                } 
            } 
        // Traza de salida 
        UtilidadesLog.info("DAOINTDAT.obtenerTransaccionesCliente(Long pais, Long marca, Long canal, Long acceso, Long periodo, java.util.Date fechaFacturacion): Salida"); 
        return lista; 
    }

    /**
     *  Incidencia 18459
     */
    public Long[] obtenerTiposAbonoSubproceso(Long pais, String[] indicadores) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerTiposAbonoSubproceso(Long pais, String[] indicadores): Entrada");

        Long[] resultado = new Long[0];
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT DISTINCT(TIPO_SUBPROCESO.OID_TIPO_ABON_SUBP)  ");
        consulta.append(" FROM  ");
        consulta.append(" CCC_DETAL_CARGO_ABONO_DIREC CA_DIRECTO, ");
        consulta.append(" INT_TIPOS_ABONO_DAT ABONOS_DAT, ");
        consulta.append(" CCC_TIPO_ABONO_SUBPR TIPO_SUBPROCESO, ");
        consulta.append(" CCC_TIPO_CARGO_ABONO TIPO_CA ");
        consulta.append(" WHERE  ");

        if (pais != null) {
            consulta.append(" TIPO_CA.PAIS_OID_PAIS= ?  ");
            parametros.add(pais);
        }

        consulta.append(" AND ABONOS_DAT.TCAB_OID_TIPO_CARG_ABON= TIPO_CA.OID_TIPO_CARG_ABON ");

        /*parametros- Aqui se agregan todos los indicadores recibidos separados por coma*/
        int tamLista = indicadores.length;

        if (tamLista != 0) {
            consulta.append(" AND ABONOS_DAT.IND_INDI IN (");

            for (int i = 0; i < tamLista; i++) {
                consulta.append("?,");
                parametros.add(indicadores[i]);
            }

            consulta = new StringBuffer(consulta.substring(0, consulta.length() - 1)); //Quitar la ultima coma.
            consulta.append(") ");
        }

        consulta.append(" AND TIPO_CA.OID_TIPO_CARG_ABON=TIPO_SUBPROCESO.TCAB_OID_TCAB ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerTiposAbonoSubproceso: Exception", e);
            this.logSql(" obtenerTiposAbonoSubproceso. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        if (rs != null) {
            int n = rs.getRowCount();
            resultado = new Long[n];

            for (int i = 0; i < n; i++) {
                if (rs.getValueAt(i, "OID_TIPO_ABON_SUBP") != null) {
                    resultado[i] = new Long(((BigDecimal) rs.getValueAt(i, "OID_TIPO_ABON_SUBP")).longValue());
                }
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerTiposAbonoSubproceso(Long pais, String[] indicadores): Salida");

        return resultado;
    }

    public ArrayList obtenerCambiosTerritorio(Long oidPais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimaEjecucion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerCambiosTerritorio(Long oidPais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimaEjecucion): Entrada");

        //vamos a obtener los cambios de territorio que se hayan realizado 
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append("SELECT HZ.VAL_UNID_ADM1 CODIGOUA1, ");
        consulta.append("HZ.VAL_UNID_ADM2 CODIGOUA2, ");
        consulta.append("HZ.VAL_UNID_ADM3 CODIGOUA3, ");
        consulta.append("HZ.VAL_TIPO_MODI TIPOMODIFICACION, ");
        consulta.append("pc.cod_peri PERIODO ");

        //FROM
        consulta.append(" FROM ZON_HISTO_ZONAS hz, CRA_PERIO cp, ");
        consulta.append(" seg_perio_corpo pc ");

        //WHERE
        consulta.append(" WHERE HZ.PERD_OID_PERI_ACTI = CP.OID_PERI ");
        consulta.append(" AND cp.PERI_OID_PERI = pc.oid_peri ");

        if (fechaUltimaEjecucion != null) {
            consulta.append("AND HZ.FEC_CREA >= TO_DATE( ? ,'YYYY-MM-DD') "); //fechaUltimaEjecucion
            parametros.add(formateaFecha(fechaUltimaEjecucion));
        }

        if (oidPais != null) {
            consulta.append("AND CP.PAIS_OID_PAIS = ? ");
            parametros.add(oidPais);
        }

        if (oidMarca != null) {
            consulta.append("AND CP.MARC_OID_MARC = ? ");
            parametros.add(oidMarca);
        }

        if (oidCanal != null) {
            consulta.append("AND CP.CANA_OID_CANA = ? ");
            parametros.add(oidCanal);
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" DAOINTDAT.obtenerCambiosTerritorio: Exception", e);
            this.logSql(" DAOINTDAT.obtenerCambiosTerritorio. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        ArrayList lista = new ArrayList();
        DTOCambiosTerritorio dto = null;

        // Con los registros obtenidos devolver una colección de objetos del tipo DTOCambiosTerritorio
        if (rs != null) {
            int tamano = rs.getRowCount();

            for (int i = 0; i < tamano; i++) {
                dto = new DTOCambiosTerritorio();

                if (rs.getValueAt(i, "CODIGOUA1") != null) {
                    dto.setCodigoUA1((String) rs.getValueAt(i, "CODIGOUA1"));
                }

                if (rs.getValueAt(i, "CODIGOUA2") != null) {
                    dto.setCodigoUA2((String) rs.getValueAt(i, "CODIGOUA2"));
                }

                if (rs.getValueAt(i, "CODIGOUA3") != null) {
                    dto.setCodigoUA3((String) rs.getValueAt(i, "CODIGOUA3"));
                }

                if (rs.getValueAt(i, "TIPOMODIFICACION") != null) {
                    dto.setTipoModificacion((String) rs.getValueAt(i, "TIPOMODIFICACION"));
                }

                if (rs.getValueAt(i, "PERIODO") != null) {
                    dto.setCodPeriodo((String) rs.getValueAt(i, "PERIODO"));
                }

                lista.add(dto);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerCambiosTerritorio(Long oidPais, Long oidMarca, Long oidCanal, java.util.Date fechaUltimaEjecucion): Salida");

        return lista;
    }

/*
 PZERBINO 19/10/2006 por incidencia 24361
 */
    public BigDecimal obtenerTipoCambio(Long oidPais, java.util.Date fechaFacturacion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerTipoCambio(Long oidPais, java.util.Date fechaFacturacion): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        BigDecimal tipocambio = new BigDecimal(0);
        consulta.append(" SELECT * FROM (  ");
        consulta.append(" SELECT tipocambio.VAL_TIPO_CAMB AS TIPOCAMBIO ");
        consulta.append(" FROM  SEG_PAIS PAIS,  ");
        consulta.append(" SEG_TIPO_CAMBI TIPOCAMBIO ");
        consulta.append(" WHERE tipocambio.MONE_OID_MON1 = pais.MONE_OID_MONE_ALT ");
        consulta.append(" AND tipocambio.MONE_OID_MON2 = pais.MONE_OID_MONE  ");
        
        if (fechaFacturacion != null) {
            consulta.append(" AND tipocambio.FEC_DESD <=  TO_DATE (?, 'YYYY-MM-DD') ");            
            parametros.add(formateaFecha(fechaFacturacion));
        }
                
        if (oidPais != null) {
            consulta.append(" AND pais.OID_PAIS = ? ");                    
            parametros.add(oidPais);
        }
        
        //pzerbino 8/11/2006 por incidencia de peru
        consulta.append(" ORDER BY FEC_DESD DESC ");
        consulta.append(" ) WHERE rownum = 1 ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" DAOINTDAT.obtenerTipoCambio: Exception", e);
            this.logSql(" DAOINTDAT.obtenerTipoCambio. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("rs ///// " + rs);
        UtilidadesLog.info("tipocambio /////  " + tipocambio);
        if (!rs.esVacio()) {            
            tipocambio = (BigDecimal)rs.getValueAt(0, "TIPOCAMBIO");
            UtilidadesLog.info("tipocambio *******  " + tipocambio);
        }

        UtilidadesLog.info("DAOINTDAT.obtenerTipoCambio(Long oidPais, java.util.Date fechaFacturacion): Salida");
        return tipocambio;
    }


    private String formateaFecha(java.util.Date fecha) {
        UtilidadesLog.info("DAOINTDAT.formateaFecha(java.util.Date fecha): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaD = new java.sql.Date(fecha.getTime());
        String fechaFormateada = sdf.format(fechaD);
        UtilidadesLog.info("DAOINTDAT.formateaFecha(java.util.Date fecha): Salida");
        return fechaFormateada;
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) + ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }
    
    //pzerbino 27/10/2006 Importada de DaoInt
    private  String convertirArrayToString(ArrayList array, Vector parametros){
        UtilidadesLog.info("DAOINTDAT.convertirArrayToString(ArrayList array): Entrada");
	    	String retorno = "";
        if((array!=null)&&(array.size()!=0)){
			   	StringBuffer sentencia = new StringBuffer("");
			    for(int i=0;i<array.size();i++){
            UtilidadesLog.debug("\n -  array[ ]=" + array.get(i));
              if(array.get(i)!=null){
            	  sentencia.append(" ?, ");
                parametros.add(array.get(i));
             }
           }
           //Quitamos la coma y el espacio del final
           retorno= sentencia.substring(0,sentencia.length()-2);
				   UtilidadesLog.debug(retorno);
         }else{
            UtilidadesLog.info("DAOINTDAT.convertirArrayToString(ArrayList array): Salida");
		     }
			  UtilidadesLog.info("DAOINTDAT.convertirArrayToString(ArrayList array): Salida");
		return retorno;
	}


   /**
    * Método agregado por Inc. DBLG400000745. 
    * Devuelve el codigo de periodo (de menor fecha inicial) que contiene la 
    * fecha indicada. Dicho codigo es varchar(6) en BD.
    * @author Emilio Iraola
    * @date 06/04/2006
    */
    public String obtenerPeriodoCorporativo(DTODate fecha, Long pais, Long marca,
            Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerPeriodoCorporativo(DTODate fecha): Entrada");
        String codigoPeriodo = null;
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT pcor.COD_PERI ");
        consulta.append("   FROM cra_perio per, ");
        consulta.append("        seg_perio_corpo pcor ");
        consulta.append("  WHERE per.OID_PERI = pcor.OID_PERI ");
        if(pais != null){
            consulta.append(" AND per.PAIS_OID_PAIS = ? ");
            parametros.add(pais); 
        }
        if(marca != null){
            consulta.append(" AND per.MARC_OID_MARC = ? ");
            parametros.add(marca); 
        }
        if(canal != null){
            consulta.append(" AND per.CANA_OID_CANA = ? ");
            parametros.add(canal); 
        }     
        if(fecha.getFecha() != null){
            String fechaPeri = this.formateaFecha(fecha.getFecha());
            consulta.append(" AND (TO_DATE( ? ,'YYYY-MM-DD') ");
            consulta.append("      BETWEEN FEC_INIC AND FEC_FINA) ");
            parametros.add(fechaPeri); 
        }
        consulta.append(" ORDER BY per.FEC_INIC "); // Orden ascendente por Fecha inicial
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try { 
            rs = bs.dbService.executePreparedQuery(consulta.toString(), 
                parametros); 
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error(" obtenerPeriodoCorporativo: Exception", e); 
            this.logSql(" obtenerPeriodoCorporativo. SQL: ", 
                consulta.toString(),parametros); 
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(codigoError));   
        } 
        
        if(rs != null) {
            int cantRegistros = rs.getRowCount();
            UtilidadesLog.debug(" para la fecha dada se recuperaron_" + cantRegistros + " Codigos");    
            if(cantRegistros > 0) { // El primero pues es el de menor Fecha inicial
                codigoPeriodo = (String) rs.getValueAt(0, "COD_PERI"); // es NOT NULL
            }
        }
        UtilidadesLog.debug(" el Codigo de Periodo devuelto es_" + codigoPeriodo);
        UtilidadesLog.info("DAOINTDAT.obtenerPeriodoCorporativo(DTODate fecha): Salida");
        return codigoPeriodo;
    }


  /**
   * 04-07-2007   modificado por incidencia Sicc-20070309 (Sapaza), se agrega para que se envien devoluciones
   *              cuyos productos apunten a producto de solicitudes de O/C del consolidado de referencia,
   *              ademas se comentan la busqueda de canjes.
   * 17-07-2007   modificado por incidencia Sicc-20070309 (Sapaza), se agrega para que se envien anulaciones
   *              cuyos productos apunten a producto de solicitudes de O/C del consolidado de referencia.
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param fechaFacturacion
   * @param periodo
   * @param acceso
   * @param pais
   */
    public ArrayList obtenerBoletasDespachoPerf(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespachoPerf(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion): Entrada");
        
        //PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS , 
        //se obtine el codigo periodo
        String codigoPeriodo = obtenerCodigoPeriodo(periodo);
        Long indicadorCruce = obtenerIndicadorCruce(periodo);//SI ESTA DESACTIVADO SE REALIZA EL NUEVO FILTRO
        Long periodoSiguiente= obtenerNPeriodo(codigoPeriodo,pais,1);        
        UtilidadesLog.info("codigoPeriodo "+codigoPeriodo+" periodoSiguiente "+periodoSiguiente+" indicadorCruce "+indicadorCruce);
        //
        
        ArrayList insertOIDS = new ArrayList();
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT SC.OID_SOLI_CABE OIDSOLICITUD,  "); 
        consulta.append(" 	     PC.COD_PERI ANIOCAMPANIA,  "); 
        consulta.append(" 	     CA.COD_CANA CODIGOCANAL, "); 
        consulta.append("        AC.COD_ACCE CODIGOACCESO,  "); 
        consulta.append(" 	     CONSO.VAL_NUME_SOLI NUMDOCUMENTOFACTURACION, "); 
        consulta.append("        TE.COD_TERR CODIGOTERRITORIO,  "); 
        consulta.append(" 	     MC.COD_CLIE CODIGOCONSULTORA, "); 
        consulta.append("        MC.OID_CLIE OIDCONSULTORA,  "); 
        consulta.append(" 	     CONSO.FEC_FACT FECHADOCUMENTO, "); 
        consulta.append("        SC.CLIE_OID_CLIE_RECE_FACT CODIGOCLIENTERECEPTOR, "); 
        
        //consulta.append("        TS.IND_ANUL FLAGANULACION,  "); 
        consulta.append("        (CASE WHEN ts.ind_anul = 1 and  pt.num_unid_anul = 1 THEN 1 ");
        consulta.append("             ELSE 0 END)     FLAGANULACION,        ");

        consulta.append(" 	 SC.VAL_TOTA_PAGA_LOCA VENTAFACTURA, "); 
        consulta.append("        SC.VAL_IMPO_FLET_TOTA_LOCA MONTOFLETE,  "); 
        consulta.append(" 	     SC.NUM_CLIEN NUMEROCLIENTES, "); 
        consulta.append("        SC.PAIS_OID_PAIS,  "); 
        consulta.append(" 	     TS.IND_DEVO FLAGDEVOLUCION, "); 
        consulta.append("        PC2.COD_PERI ANIOCAMPANIAREF,  "); 
        consulta.append(" 	     CA2.COD_CANA CODIGOCANALREF, "); 
        consulta.append("        AC2.COD_ACCE CODIGOACCESOREF,  "); 
        consulta.append(" 	     SCREF.VAL_NUME_SOLI NUMDOCUMFACTREF, "); 
        consulta.append("        TE2.COD_TERR CODTERRITREF,  "); 
        consulta.append(" 	     SCREF.FEC_CRON FECHADOCUMREF, "); 
        consulta.append("        SCREF.VAL_TOTA_PAGA_LOCA VENTAFACTREF, "); 
        consulta.append("        SCREF.VAL_IMPO_FLET_TOTA_LOCA MONTOFLETEREF, "); 
        consulta.append("        PQ_APL_REP.FN_CU_CALC_SALDO_CTA_CTE (MC.OID_CLIE) SALDO, SC.MODU_OID_MODU "); 
        consulta.append("   FROM PED_SOLIC_CABEC SC, "); 
        consulta.append("        CRA_PERIO PE, "); 
        consulta.append("        SEG_PERIO_CORPO PC, "); 
        consulta.append("        SEG_CANAL CA, "); 
        consulta.append("        SEG_ACCES AC, "); 
        consulta.append("        SEG_SUBAC SA, "); 
        consulta.append("        ZON_TERRI TE, "); 
        consulta.append("        (SELECT C.OID_CLIE, C.COD_CLIE "); 
        consulta.append("           FROM MAE_CLIEN C) MC, "); 
        consulta.append("        (SELECT S.OID_SOLI_CABE, S.VAL_NUME_SOLI, S.FEC_FACT "); 
        consulta.append("           FROM PED_SOLIC_CABEC S, CRA_PERIO P1 "); 
        
        if (acceso != null) {
            consulta.append("          , SEG_SUBAC SA, SEG_ACCES AC"); 
        }
        
        consulta.append("          WHERE S.PAIS_OID_PAIS = " + pais); 
        
        if (acceso != null) {
            consulta.append("            AND S.SBAC_OID_SBAC = SA.OID_SBAC "); 
            consulta.append("            AND SA.ACCE_OID_ACCE = AC.OID_ACCE "); 
            consulta.append("            AND AC.OID_ACCE = " + acceso); 
        }
        
        consulta.append("            AND S.PERD_OID_PERI = P1.OID_PERI "); 
        consulta.append("            AND ( P1.OID_PERI = " + periodo); 
        consulta.append("                 OR ( "+indicadorCruce +"=0 AND P1.OID_PERI = " + periodoSiguiente+") )"); 
        
        if (fechaFacturacion != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime());
        
            String sFecha = sdf.format(fecha);
            consulta.append("            AND S.FEC_FACT = TRUNC (TO_DATE ('" + sFecha + "', 'YYYY-MM-DD')) "); 
        }
        
        consulta.append("            AND S.IND_TS_NO_CONSO = 0 "); 
        consulta.append("            AND (S.IND_PEDI_PRUE = 0 OR S.IND_PEDI_PRUE IS NULL)) CONSO, "); 
        consulta.append("        PED_TIPO_SOLIC TS, "); 
        consulta.append("        PED_TIPO_SOLIC_PAIS SP, "); 
        consulta.append("        PED_SOLIC_CABEC SCREF, "); 
        consulta.append("        CRA_PERIO PE2, "); 
        consulta.append("        SEG_PERIO_CORPO PC2, "); 
        consulta.append("        SEG_CANAL CA2, "); 
        consulta.append("        SEG_ACCES AC2, "); 
        consulta.append("        SEG_SUBAC SA2, "); 
        consulta.append("        ZON_TERRI TE2, "); 
        consulta.append("        INT_PARAM_TIPO_SOLIC PT "); 
        consulta.append("  WHERE SC.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE "); 
        //consulta.append("    AND SC.IND_OC = 1 "); 
        consulta.append("    AND PT.TSPA_OID_TIPO_SOLI_PAIS = SP.OID_TIPO_SOLI_PAIS "); 
        consulta.append("    AND SC.TSPA_OID_TIPO_SOLI_PAIS = SP.OID_TIPO_SOLI_PAIS "); 
        consulta.append("    AND SP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI "); 
        consulta.append("    AND SC.CLIE_OID_CLIE = MC.OID_CLIE "); 
        consulta.append("    AND SC.PERD_OID_PERI = PE.OID_PERI "); 
        consulta.append("    AND PE.PERI_OID_PERI = PC.OID_PERI "); 
        consulta.append("    AND PE.CANA_OID_CANA = CA.OID_CANA "); 
        consulta.append("    AND SC.SBAC_OID_SBAC = SA.OID_SBAC "); 
        consulta.append("    AND SA.ACCE_OID_ACCE = AC.OID_ACCE "); 
        consulta.append("    AND SC.TERR_OID_TERR = TE.OID_TERR "); 
        
        //consulta.append("    AND (   (TS.IND_DEVO = 0 AND TS.IND_ANUL=0) "); 
        //consulta.append("         OR (FN_DAT_VALIDAR_PROD_SOLI_DEVO (SC.OID_SOLI_CABE, NULL) > 0)) "); 
        consulta.append("    AND ( "); 
        consulta.append("         (PT.num_unid_vend = 1 AND TS.ind_anul = 0 AND TS.ind_devo = 0 AND SC.ind_oc = 1) "); 
        consulta.append("           OR "); 
        consulta.append("         (PT.num_unid_falt = 1 AND TS.ind_anul = 0 AND TS.ind_devo = 0 AND SC.ind_oc = 1)  "); 
        consulta.append("           OR "); 
        consulta.append("         (PT.num_unid_devu = 1 AND   "); 
        consulta.append("          FN_DAT_VALIDAR_PROD_SOLI_DEVO(SC.OID_SOLI_CABE, null)>0) "); 
        consulta.append("           OR "); 
        consulta.append("         (PT.num_unid_anul = 1 AND   "); 
        consulta.append("          FN_DAT_VALIDAR_PROD_SOLI_DEVO(SC.OID_SOLI_CABE, null)>0) "); 
        consulta.append("           OR "); 
        consulta.append("         (PT.num_unid_canj = 1 AND    "); 
        consulta.append("          FN_DAT_VALIDAR_PROD_SOLI_DEVO(SC.OID_SOLI_CABE, null)>0) "); 
        consulta.append("           OR "); 
        consulta.append("         (PT.num_unid_true = 1 AND    "); 
        consulta.append("          FN_DAT_VALIDAR_PROD_SOLI_DEVO(SC.OID_SOLI_CABE, null)>0) "); 
        consulta.append("        ) "); 
        
        consulta.append("    AND SC.SOCA_OID_DOCU_REFE = SCREF.OID_SOLI_CABE(+) "); 
        consulta.append("    AND SCREF.PERD_OID_PERI = PE2.OID_PERI(+) "); 
        consulta.append("    AND PE2.PERI_OID_PERI = PC2.OID_PERI(+) "); 
        consulta.append("    AND PE2.CANA_OID_CANA = CA2.OID_CANA(+) "); 
        consulta.append("    AND SCREF.SBAC_OID_SBAC = SA2.OID_SBAC(+) "); 
        consulta.append("    AND SA2.ACCE_OID_ACCE = AC2.OID_ACCE(+) "); 
        consulta.append("    AND SCREF.TERR_OID_TERR = TE2.OID_TERR(+) "); 

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerBoletasDespachoPerf: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        ArrayList listaOidsSoli = new ArrayList();
        ArrayList listaOidsDevo = new ArrayList();
        
        Map mapDocumentos = new HashMap();
        
        DTOINTBoletasDespacho boletasDespacho = null;
        String anioCampañaReferencia = null;
        int n = rs.getRowCount();
        if (!rs.esVacio()) {
            for (int i = 0; i < n; i++) {
                boletasDespacho = new DTOINTBoletasDespacho();

                if (rs.getValueAt(i, "ANIOCAMPANIA") != null) {
                    boletasDespacho.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIA"));
                }

                if (rs.getValueAt(i, "CODIGOCANAL") != null) {
                    boletasDespacho.setCodigoCanal((String) rs.getValueAt(i, "CODIGOCANAL"));
                }

                if (rs.getValueAt(i, "CODIGOACCESO") != null) {
                    boletasDespacho.setCodigoAcceso((String) rs.getValueAt(i, "CODIGOACCESO"));
                }

                if (rs.getValueAt(i, "NUMDOCUMENTOFACTURACION") != null) {
                    boletasDespacho.setNumDocumentoFacturacion(new Long(((BigDecimal) rs.getValueAt(i, "NUMDOCUMENTOFACTURACION")).longValue()));
                }

                if (rs.getValueAt(i, "CODIGOTERRITORIO") != null) { //????
                    boletasDespacho.setCodigoTerritorio(Long.valueOf(rs.getValueAt(i, "CODIGOTERRITORIO").toString()));
                }

                if (rs.getValueAt(i, "CODIGOCONSULTORA") != null) {
                    boletasDespacho.setCodigoConsultora((String) rs.getValueAt(i, "CODIGOCONSULTORA"));
                }

                if (rs.getValueAt(i, "OIDCONSULTORA") != null) { //?????
                    boletasDespacho.setOidConsultora(new Long(((BigDecimal) rs.getValueAt(i, "OIDCONSULTORA")).longValue()));
                }

                if (rs.getValueAt(i, "FECHADOCUMENTO") != null) {
                    boletasDespacho.setFechaDocumento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHADOCUMENTO")).getTime()));
                }

                if (rs.getValueAt(i, "CODIGOCLIENTERECEPTOR") != null) { //????
                    boletasDespacho.setOidClienteReceptor(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOCLIENTERECEPTOR")).longValue())); //(new Long((String) rs.getValueAt(i,"CODIGOCLIENTERECEPTOR")));
                }

                if (rs.getValueAt(i, "FLAGANULACION") != null) {
                    boletasDespacho.setFlagAnulacion(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGANULACION")).intValue()));
                }else {
                    boletasDespacho.setFlagAnulacion(new Integer(0));
                }

                if (rs.getValueAt(i, "VENTAFACTURA") != null) {
                    boletasDespacho.setVentaFactura((BigDecimal) rs.getValueAt(i, "VENTAFACTURA"));
                }

                if (rs.getValueAt(i, "MONTOFLETE") != null) {
                    boletasDespacho.setMontoFlete((BigDecimal) rs.getValueAt(i, "MONTOFLETE"));
                }

                if (rs.getValueAt(i, "NUMEROCLIENTES") != null) {
                    boletasDespacho.setNumeroClientes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCLIENTES")).longValue()));
                }
                
                if (rs.getValueAt(i, "PAIS_OID_PAIS") != null) {
                    boletasDespacho.setOidPais(new Long(((BigDecimal) rs.getValueAt(i, "PAIS_OID_PAIS")).longValue()));
                }
                
                if (rs.getValueAt(i, "SALDO") != null) {
                    boletasDespacho.setSaldoCC((BigDecimal) rs.getValueAt(i, "SALDO"));
                } else {
                    boletasDespacho.setSaldoCC((BigDecimal) new BigDecimal(0));
                }
                boletasDespacho.setOidModulo(this.bigDecimalToLong(rs.getValueAt(i, "MODU_OID_MODU")));

                if (rs.getValueAt(i, "FLAGDEVOLUCION") != null) {
                    boletasDespacho.setFlagDevolucion(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGDEVOLUCION")).intValue()));
                }else {
                    boletasDespacho.setFlagDevolucion(new Integer(0));
                }
                
                if (rs.getValueAt(i, "NUMDOCUMFACTREF") != null){
                       if (rs.getValueAt(i, "ANIOCAMPANIAREF") != null) {
                                //  Modificado por Sapaza - Fecha 25/05/2007 - Incidencia SICC 20070280
                                boletasDespacho.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIAREF"));
                                //anioCampañaReferencia = boletasDespacho.getAnioCampania();
                                anioCampañaReferencia = (String) rs.getValueAt(i, "ANIOCAMPANIAREF");
                       }
            
                       if (rs.getValueAt(i, "CODIGOCANALREF") != null) {
                                boletasDespacho.setCodigoCanal((String) rs.getValueAt(i, "CODIGOCANALREF"));
                       }
            
                       if (rs.getValueAt(i, "CODIGOACCESOREF") != null) {
                                boletasDespacho.setCodigoAcceso((String) rs.getValueAt(i, "CODIGOACCESOREF"));
                       }
            
                       if (rs.getValueAt(i, "NUMDOCUMFACTREF") != null) {
                                boletasDespacho.setNumDocumentoFacturacion(new Long(((BigDecimal) rs.getValueAt(i, "NUMDOCUMFACTREF")).longValue()));
                       }
            
                       if (rs.getValueAt(i, "CODTERRITREF") != null) { //????
                                boletasDespacho.setCodigoTerritorio(Long.valueOf(rs.getValueAt(i, "CODTERRITREF").toString()));
                       }

                       if (rs.getValueAt(i, "FECHADOCUMREF") != null) {
                                boletasDespacho.setFechaDocumento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHADOCUMREF")).getTime()));
                       }

                       if (rs.getValueAt(i, "VENTAFACTREF") != null) {
                                boletasDespacho.setVentaFactura((BigDecimal) rs.getValueAt(i, "VENTAFACTREF"));
                       }
            
                       if (rs.getValueAt(i, "MONTOFLETEREF") != null) {
                              boletasDespacho.setMontoFlete((BigDecimal) rs.getValueAt(i, "MONTOFLETEREF"));
                       }
                }
                //Insertar dtoboleta
                //Modificado por Sapaza - Fecha 03/08/2007 - Incidencia SiCC-20070377
                //Para el caso de devoluciones, se enviara un solo registro por NumDoc Facturacion del consolidado de referencia
                if(boletasDespacho.getFlagDevolucion().equals(new Integer(1))) {
                    if (!listaOidsDevo.contains(rs.getValueAt(i, "NUMDOCUMFACTREF").toString())) {
                        listaOidsDevo.add(rs.getValueAt(i, "NUMDOCUMFACTREF").toString());
                        adiccionarBoletaDespacho(lista, mapDocumentos, boletasDespacho);
                    }
                }else {    
                    adiccionarBoletaDespacho(lista, mapDocumentos, boletasDespacho);
                }
                
                //carga de oidsSolicitudes
                listaOidsSoli.add(rs.getValueAt(i, "OIDSOLICITUD").toString());
                
                //  Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070120
                //  Grabara solo las solicitudes O/C, anulaciones, devoluciones y que no sean 'otros reclamos' 
                /*if ( boletasDespacho.getOidModulo().longValue() != new Long(ConstantesSEG.MODULO_REC).longValue() || 
                     boletasDespacho.getFlagAnulacion().equals(new Integer(1)) ||
                     boletasDespacho.getFlagDevolucion().equals(new Integer(1)) )   {
                    //jrivas 18/12/2006 DAT-24
                    insertOIDS.add(this.armarInsertOIDSoli(rs.getValueAt(i, "OIDSOLICITUD").toString(), 
                                boletasDespacho.getFechaDocumento(), boletasDespacho.getNumDocumentoFacturacion(), 
                                boletasDespacho.getCodigoAcceso(), boletasDespacho.getCodigoTerritorio(), 
                                 (String) rs.getValueAt(i, "ANIOCAMPANIA"), anioCampañaReferencia, boletasDespacho.getCodigoCanal())); //  Modificado por Sapaza - Fecha 25/05/2007 - Incidencia SICC 20070280
                }*/
                
                insertOIDS.add(this.armarInsertOIDSoli(rs.getValueAt(i, "OIDSOLICITUD").toString(), 
                          boletasDespacho.getFechaDocumento(), boletasDespacho.getNumDocumentoFacturacion(), 
                          boletasDespacho.getCodigoAcceso(), boletasDespacho.getCodigoTerritorio(), 
                           (String) rs.getValueAt(i, "ANIOCAMPANIA"), anioCampañaReferencia, boletasDespacho.getCodigoCanal())); //  Modificado por Sapaza - Fecha 25/05/2007 - Incidencia SICC 20070280

                anioCampañaReferencia = null;
                            
            } //fin bucle for            
        }//fin if rs
        
        //(Sapaza) comentado por incidencia SiCC-20070309 (03-07-2007)
        /*ArrayList listaCanje = new ArrayList();
        listaCanje =  obtenerBoletasDespachoCanjePerf(pais, acceso, periodo, fechaFacturacion, listaOidsSoli, insertOIDS);
        lista.addAll(listaCanje);*/

        //jrivas 18/12/2006 DAT-24
        this.guardarOIDSSolicitudes(insertOIDS);

        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespachoPerf(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion): Salida");
        return lista;
    }
    
    /**
     * 10-03-2011       Agregado por Sapaza, cambio RCR PER-SiCC-2011-0120 ajuste de consolidar en DAT-12
     * 
     * @throws es.indra.mare.common.exception.MareException
     */
    private void adiccionarBoletaDespacho(ArrayList lista, Map mapDocumentos, DTOINTBoletasDespacho boletasDespacho) {
        if(mapDocumentos.get(boletasDespacho.getNumDocumentoFacturacion().toString()) == null) {
            mapDocumentos.put(boletasDespacho.getNumDocumentoFacturacion().toString(), String.valueOf(lista.size()));
            lista.add(boletasDespacho);
        }    
        else {
            String posiciones = (String)mapDocumentos.get(boletasDespacho.getNumDocumentoFacturacion().toString());
            String arrposiciones[] = posiciones.split(",");
            boolean encontrado = false;
            
            for(int i=0; i<arrposiciones.length; i++) {
                int posicion = Integer.parseInt(arrposiciones[i]);
                DTOINTBoletasDespacho boletaAux = (DTOINTBoletasDespacho)lista.get(posicion);
                
                UtilidadesLog.debug("posicion: " + posicion);
                UtilidadesLog.debug("boletaAux: " + boletaAux);
                UtilidadesLog.debug("boletasDespacho: " + boletasDespacho);
                
                if(boletaAux.getAnioCampania().equals(boletasDespacho.getAnioCampania()) &&
                   boletaAux.getCodigoCanal().equals(boletasDespacho.getCodigoCanal()) && 
                   boletaAux.getCodigoAcceso().equals(boletasDespacho.getCodigoAcceso()) &&
                   boletaAux.getNumDocumentoFacturacion().longValue() == boletasDespacho.getNumDocumentoFacturacion().longValue() &&
                   boletaAux.getCodigoTerritorio().equals(boletasDespacho.getCodigoTerritorio()) &&
                   boletaAux.getFechaDocumento().getTime() ==  boletasDespacho.getFechaDocumento().getTime() &&
                   boletaAux.getFlagAnulacion().intValue() == boletasDespacho.getFlagAnulacion().intValue() &&
                   boletaAux.getSaldoCC().doubleValue() == boletasDespacho.getSaldoCC().doubleValue()
                   ) {
                    Long numeroClientes = new Long(0);
                    
                    if(boletaAux.getNumeroClientes()!=null)
                        numeroClientes = numeroClientes + boletaAux.getNumeroClientes().longValue();
                     if(boletasDespacho.getNumeroClientes()!=null)
                         numeroClientes = numeroClientes + boletasDespacho.getNumeroClientes().longValue();
                    
                    // sapaza -- PER-SiCC-2011-0262 -- 13/04/2011    
                    if(boletasDespacho.getMontoFlete().doubleValue() > boletaAux.getMontoFlete().doubleValue())
                        boletaAux.setMontoFlete(boletasDespacho.getMontoFlete());
                        
                    boletaAux.setNumeroClientes(numeroClientes);
                    boletaAux.setVentaFactura(boletaAux.getVentaFactura().add(boletasDespacho.getVentaFactura()));
                    lista.set(posicion, boletaAux);
                    encontrado = true;
                    break;
                 }   
            } 
            
            if(!encontrado) {
                posiciones = posiciones + "," + String.valueOf(lista.size());
                mapDocumentos.put(boletasDespacho.getNumDocumentoFacturacion().toString(), posiciones);                 
                lista.add(boletasDespacho);
            }
        }
    }
    
    public ArrayList obtenerBoletasDespachoCanjePerf(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion, ArrayList listaOidsSoli, ArrayList insertOIDS) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespachoCanjePerf(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion, ArrayList listaOids): Entrada");

        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT  ");
        consulta.append(" PC.COD_PERI ANIOCAMPANIA,   ");
        consulta.append(" CA.COD_CANA CODIGOCANAL ,  ");
        consulta.append(" AC.COD_ACCE CODIGOACCESO ,  ");
        consulta.append(" CONSO.VAL_NUME_SOLI NUMDOCUMENTOFACTURACION ,  ");
        consulta.append(" TE.COD_TERR CODIGOTERRITORIO , ");
        consulta.append(" MC.COD_CLIE CODIGOCONSULTORA , ");
        consulta.append(" MC.OID_CLIE OIDCONSULTORA , "); 
        consulta.append(" CONSO.FEC_CRON FECHADOCUMENTO ,  ");
        consulta.append(" SC.CLIE_OID_CLIE_RECE_FACT CODIGOCLIENTERECEPTOR , ");
        consulta.append(" TS.IND_ANUL FLAGANULACION , ");
        consulta.append(" TS.IND_DEVO FLAGDEVOLUCION , ");
        consulta.append(" SC.VAL_TOTA_PAGA_LOCA VENTAFACTURA , ");
        consulta.append(" SC.VAL_IMPO_FLET_TOTA_LOCA MONTOFLETE , ");
        consulta.append(" SC.NUM_CLIEN NUMEROCLIENTES, ");
        consulta.append(" SC.OID_SOLI_CABE OIDSOLICITUD, ");        
        consulta.append(" PQ_APL_REP.FN_CU_CALC_SALDO_CTA_CTE (MC.OID_CLIE) SALDO "); 
        consulta.append(" FROM ");
        consulta.append(" PED_SOLIC_CABEC SC, ");
        consulta.append(" PED_TIPO_SOLIC TS,  ");
        consulta.append(" PED_TIPO_SOLIC_PAIS SP, ");
        consulta.append(" INT_DAT_SOLIC_CANJE DSC,  ");
        consulta.append(" (SELECT C.OID_CLIE, C.COD_CLIE FROM MAE_CLIEN C) MC, ");
        consulta.append("        (SELECT S.OID_SOLI_CABE, S.VAL_NUME_SOLI, S.FEC_CRON"); 
        consulta.append("           FROM PED_SOLIC_CABEC S, CRA_PERIO P1 "); 
        
        if (acceso != null) {
            consulta.append("          , SEG_SUBAC SA, SEG_ACCES AC"); 
        }
        
        consulta.append("          WHERE S.PAIS_OID_PAIS = " + pais); 
        
        if (acceso != null) {
            consulta.append("            AND S.SBAC_OID_SBAC = SA.OID_SBAC "); 
            consulta.append("            AND SA.ACCE_OID_ACCE = AC.OID_ACCE "); 
            consulta.append("            AND AC.OID_ACCE = " + acceso); 
        }
        
        consulta.append("            AND S.PERD_OID_PERI = P1.OID_PERI "); 
        consulta.append("            AND P1.OID_PERI = " + periodo); 
        
        if (fechaFacturacion != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime());
        
            String sFecha = sdf.format(fecha);
            consulta.append("            AND S.FEC_FACT = TRUNC (TO_DATE ('" + sFecha + "', 'YYYY-MM-DD')) "); 
        }
        
        consulta.append("            AND S.IND_TS_NO_CONSO = 0 "); 
        consulta.append("            AND (S.IND_PEDI_PRUE = 0 OR S.IND_PEDI_PRUE IS NULL)) CONSO, "); 

        consulta.append(" CRA_PERIO PE ,  ");
        consulta.append(" SEG_PERIO_CORPO PC,  ");
        consulta.append(" SEG_CANAL CA ,  ");
        consulta.append(" SEG_ACCES AC ,  ");
        consulta.append(" SEG_SUBAC SA , ");
        consulta.append(" ZON_TERRI TE, ");
        consulta.append(" REC_OPERA OP,  ");
        consulta.append(" REC_OPERA_RECLA OREC,  ");
        consulta.append(" REC_SOLIC_OPERA SOLOP,  ");
        consulta.append(" REC_TIPOS_OPERA TIOP  ");
        consulta.append(" WHERE    ");
        consulta.append(" SC.PAIS_OID_PAIS = " + pais); 
        consulta.append(" AND SC.TSPA_OID_TIPO_SOLI_PAIS = SP.OID_TIPO_SOLI_PAIS  ");
        consulta.append(" AND SP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI  ");
        consulta.append(" AND SC.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append(" AND  SC.PERD_OID_PERI = PE.OID_PERI ");
        consulta.append(" AND  PE.PERI_OID_PERI = PC.OID_PERI ");
        consulta.append(" AND  PE.CANA_OID_CANA = CA.OID_CANA ");
        consulta.append(" AND  SC.SBAC_OID_SBAC = SA.OID_SBAC  ");
        consulta.append(" AND  SA.ACCE_OID_ACCE = AC.OID_ACCE ");
        consulta.append(" AND  SC.TERR_OID_TERR = TE.OID_TERR ");
        consulta.append(" AND SC.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE ");
        consulta.append(" AND SC.TSPA_OID_TIPO_SOLI_PAIS = DSC.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append(" AND EXISTS  ");
        consulta.append(" (SELECT * FROM PED_SOLIC_POSIC POS ");
        consulta.append(" WHERE POS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
        consulta.append(" AND POS.ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO); 
        consulta.append(" AND POS.NUM_UNID_POR_ATEN > POS.NUM_UNID_COMPR) ");
        consulta.append(" AND CONSO.OID_SOLI_CABE = SOLOP.SOCA_OID_SOLI_CABE  ");
        consulta.append(" AND SOLOP.TSPA_OID_TIPO_SOLI_PAIS = DSC.TSPA_OID_TIPO_SOLI_PAIS  ");
        consulta.append(" AND SOLOP.OPRE_OID_OPER_RECL = OREC.OID_OPER_RECL  ");
        consulta.append(" AND OREC.TIOP_OID_TIPO_OPER = TIOP.OID_TIPO_OPER  ");
        consulta.append(" AND TIOP.ROPE_OID_OPER = OP.OID_OPER  ");
        consulta.append(" AND (OP.TSPA_OID_SOLI_CON_STOC = DSC.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append(" OR OP.TSPA_OID_SOLI_SIN_STOC = DSC.TSPA_OID_TIPO_SOLI_PAIS) ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerBoletasDespachoCanjePerf: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTBoletasDespacho boletasDespacho = null;
        int n = rs.getRowCount();
        if (!rs.esVacio()) {
            for (int i = 0; i < n; i++) {

                if (!listaOidsSoli.contains(rs.getValueAt(i, "OIDSOLICITUD").toString())) {
                    listaOidsSoli.add(rs.getValueAt(i, "OIDSOLICITUD").toString());

                    boletasDespacho = new DTOINTBoletasDespacho();
    
                    if (rs.getValueAt(i, "ANIOCAMPANIA") != null) {
                        boletasDespacho.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIA"));
                    }
    
                    if (rs.getValueAt(i, "CODIGOCANAL") != null) {
                        boletasDespacho.setCodigoCanal((String) rs.getValueAt(i, "CODIGOCANAL"));
                    }
    
                    if (rs.getValueAt(i, "CODIGOACCESO") != null) {
                        boletasDespacho.setCodigoAcceso((String) rs.getValueAt(i, "CODIGOACCESO"));
                    }
    
                    if (rs.getValueAt(i, "NUMDOCUMENTOFACTURACION") != null) {
                        boletasDespacho.setNumDocumentoFacturacion(new Long(((BigDecimal) rs.getValueAt(i, "NUMDOCUMENTOFACTURACION")).longValue()));
                    }
    
                    if (rs.getValueAt(i, "CODIGOTERRITORIO") != null) { //????
                        boletasDespacho.setCodigoTerritorio(Long.valueOf(rs.getValueAt(i, "CODIGOTERRITORIO").toString()));
                    }
    
                    if (rs.getValueAt(i, "CODIGOCONSULTORA") != null) {
                        boletasDespacho.setCodigoConsultora((String) rs.getValueAt(i, "CODIGOCONSULTORA"));
                    }
    
                    if (rs.getValueAt(i, "OIDCONSULTORA") != null) { //?????
                        boletasDespacho.setOidConsultora(new Long(((BigDecimal) rs.getValueAt(i, "OIDCONSULTORA")).longValue()));
                    }
    
                    if (rs.getValueAt(i, "FECHADOCUMENTO") != null) {
                        boletasDespacho.setFechaDocumento(new Date(((java.sql.Date) rs.getValueAt(i, "FECHADOCUMENTO")).getTime()));
                    }
    
                    if (rs.getValueAt(i, "CODIGOCLIENTERECEPTOR") != null) { //????
                        boletasDespacho.setOidClienteReceptor(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOCLIENTERECEPTOR")).longValue())); //(new Long((String) rs.getValueAt(i,"CODIGOCLIENTERECEPTOR")));
                    }
    
                    if (rs.getValueAt(i, "FLAGANULACION") != null) {
                        boletasDespacho.setFlagAnulacion(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGANULACION")).intValue()));
                    }
                    
                    if (rs.getValueAt(i, "FLAGDEVOLUCION") != null) {
                        boletasDespacho.setFlagAnulacion(new Integer(((BigDecimal) rs.getValueAt(i, "FLAGDEVOLUCION")).intValue()));
                    }
                    
                    if (rs.getValueAt(i, "VENTAFACTURA") != null) {
                        boletasDespacho.setVentaFactura((BigDecimal) rs.getValueAt(i, "VENTAFACTURA"));
                    }
    
                    if (rs.getValueAt(i, "MONTOFLETE") != null) {
                        boletasDespacho.setMontoFlete((BigDecimal) rs.getValueAt(i, "MONTOFLETE"));
                    }
    
                    if (rs.getValueAt(i, "NUMEROCLIENTES") != null) {
                        boletasDespacho.setNumeroClientes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROCLIENTES")).longValue()));
                    }
                    
                    if (rs.getValueAt(i, "SALDO") != null) {
                        boletasDespacho.setSaldoCC((BigDecimal) rs.getValueAt(i, "SALDO"));
                    }
                    
                    lista.add(boletasDespacho);
                    
                    //jrivas 18/12/2006 DAT-24
                    insertOIDS.add(this.armarInsertOIDSoli(rs.getValueAt(i, "OIDSOLICITUD").toString(), 
                                boletasDespacho.getFechaDocumento(), boletasDespacho.getNumDocumentoFacturacion(), 
                                boletasDespacho.getCodigoAcceso(), boletasDespacho.getCodigoTerritorio(), 
                                boletasDespacho.getAnioCampania(), null, boletasDespacho.getCodigoCanal()));
                   
                }//fin no existe
            } //fin bucle for            
        }//fin if rs
        UtilidadesLog.info("obtenerBoletasDespachoCanjePerf ******** " + boletasDespacho);
                

        UtilidadesLog.info("DAOINTDAT.obtenerBoletasDespachoCanjePerf(Long pais, Long acceso, Long periodo, java.util.Date fechaFacturacion, ArrayList listaOids): Salida");
        return lista;
    } 
     private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    // SPLATAS - PERFORMANCE(06/12/2006)
    public ArrayList obtenerEstatusClientes2(Long pais, Long marca, Long canal, Long acceso, 
        Long periodo, java.util.Date fechaFacturacion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerEstatusClientes2(Pais, Marca, Canal, Acceso, Periodo, FechaFacturacion): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        // SUBSTR(EST.COD_ESTA_CLIE,2,1) se corta el codigo de estado incidencia DBLG700000282
        // gPineda - 06/03/07 - A pedido del equipo de Belcorp
        //consulta.append(" SELECT CLI.OID_CLIE OIDCLIENTE, SUBSTR(EST.COD_ESTA_CLIE,2,1) CODIGOESTATUS, DECODE (tipif.control, 1, 1, 0) INDICADORESESTRELLA, ");
        consulta.append(" SELECT CLI.OID_CLIE OIDCLIENTE, SUBSTR(");
        consulta.append(" CASE WHEN EST.COD_ESTA_CLIE = ? AND ADI.NUM_CAMP_SIN_PEDI > ? THEN ? ELSE ");
        parametros.add( ConstantesMAE.ESTATUS_EGRESADA );
        parametros.add( ConstantesINT.NRO_CAMP_SIN_PEDI );
        parametros.add( ConstantesMAE.ESTATUS_RETIRADO );
        
        consulta.append(" CASE WHEN ( EST.COD_ESTA_CLIE = ? ) THEN ? ELSE EST.COD_ESTA_CLIE END END ");
        parametros.add( ConstantesMAE.ESTATUS_REACTIVADO );
        parametros.add( ConstantesMAE.ESTATUS_NUEVO );
        
        consulta.append(" ,2,1) CODIGOESTATUS, DECODE (tipif.control, 1, 1, 0) INDICADORESESTRELLA, ");
        // gPineda - 06/03/07 - A pedido del equipo de Belcorp
        //consulta.append("        MCUR.COD_CURS CODIGOCURSO, COUNT(SOC.OID_SOLI_CABE) NUMEROTOTALORDENES, ");
        consulta.append("        MCUR.COD_CURS CODIGOCURSO, COUNT( DISTINCT SOC.CLIE_OID_CLIE) NUMEROTOTALORDENES, ");
        consulta.append("        clientes.codigocliente CODIGOCLIENTE, clientes.codigoterritorio CODIGOTERRITORIO ");
        consulta.append(" FROM   MAE_CLIEN CLI, MAE_CLIEN_DATOS_ADICI ADI, MAE_ESTAT_CLIEN EST, PED_SOLIC_CABEC SOC, ");
        consulta.append("        EDU_HISTO_CURSO HCUR, EDU_MATRI_CURSO MCUR,  ");

        //Primer SubSelect
        consulta.append("        (SELECT vtc.clie_oid_clie , 1 control ");
        consulta.append("         FROM V_MAE_TIPIF_CLIEN VTC ");
        consulta.append("         WHERE  VTC.TICL_OID_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
        consulta.append("                AND VTC.TCCL_OID_TIPO_CLASI = ?  ");
        parametros.add(ConstantesMAE.OID_TIPO_CLASIFICACION_ESTRELLA);
        consulta.append("                AND VTC.CLAS_OID_CLAS = ? ");
        parametros.add(ConstantesMAE.OID_CLASIFICACION_ESTRELLA);
        consulta.append("        ) TIPIF, ");

        //Segundo SubSelect
        consulta.append("        (SELECT * FROM CRA_PERIO ");
        consulta.append("         WHERE ROWNUM = 1  ");
        consulta.append("           AND OID_PERI = ? ");
        parametros.add(periodo);
        consulta.append("         ORDER BY FEC_FINA ) PERI, ");
        
        // Tercer Subselect
        
        //jrivas 21-2-2007 INTDATPRD-7 Si la query trae el oid de la sol. me puede trear mas de 1 vez el mismo cliente.
        //consulta.append(" (SELECT distinct CLI.OID_CLIE OIDCLIENTE, CLI.COD_CLIE CODIGOCLIENTE, TERR.COD_TERR CODIGOTERRITORIO, scabec.OID_SOLI_CABE  ");           
        consulta.append(" (SELECT distinct CLI.OID_CLIE OIDCLIENTE, CLI.COD_CLIE CODIGOCLIENTE, TERR.COD_TERR CODIGOTERRITORIO  ");
        
        consulta.append("  FROM   PED_SOLIC_CABEC scabec, CRA_PERIO PERI, MAE_CLIEN CLI, ZON_TERRI TERR   ");           
        consulta.append("  WHERE  scabec.PERD_OID_PERI = PERI.OID_PERI AND scabec.CLIE_OID_CLIE = CLI.OID_CLIE  ");           
        consulta.append("       AND scabec.TERR_OID_TERR = TERR.OID_TERR AND scabec.IND_TS_NO_CONSO = 1 ");           
        consulta.append("       AND scabec.IND_OC = 1 AND scabec.IND_PEDI_PRUE = 0 ");           
        consulta.append("       AND PERI.CANA_OID_CANA = ? ");           
        parametros.add(canal); 

        if(acceso != null){ 
            consulta.append("    AND SUBAC.ACCE_OID_ACCE = ? ");           
            parametros.add(acceso); 
        } 

        consulta.append("    AND PERI.MARC_OID_MARC = ? ");           
        parametros.add(marca); 
        consulta.append("    AND scabec.PAIS_OID_PAIS = ? ");           
        parametros.add(pais); 
        consulta.append("    AND PERI.OID_PERI = ? ");           
        parametros.add(periodo); 
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime()); 
        String sFecha = sdf.format(fecha);                                                           
        consulta.append("    AND scabec.FEC_FACT = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ) clientes");           
        parametros.add(sFecha); 
        
        consulta.append(" WHERE  ADI.CLIE_OID_CLIE = CLI.OID_CLIE AND ADI.ESTA_OID_ESTA_CLIE = EST.OID_ESTA_CLIE ");
        consulta.append("        AND HCUR.CLIE_OID_CLIE (+)= CLI.OID_CLIE AND MCUR.OID_CURS (+)= HCUR.MCUR_OID_CURS  ");
        //consulta.append("        AND SOC.CLIE_OID_CLIE = CLI.OID_CLIE AND PERI.FEC_INIC (+)>= MCUR.FEC_FIN_CURS AND MCUR.FEC_FIN_CURS(+) IS NOT NULL ");
        consulta.append("        AND SOC.CLIE_OID_CLIE = CLI.OID_CLIE AND PERI.FEC_INIC (+)<= MCUR.FEC_FIN_CURS ");
        //consulta.append("        AND PERI.FEC_FINA (+)<= MCUR.FEC_FIN_CURS AND ADI.IND_ACTI = 1  ");
        consulta.append("        AND PERI.FEC_FINA (+)<= MCUR.FEC_FIN_CURS AND ADI.IND_ACTI = 1  ");
        consulta.append("    AND SOC.FEC_FACT = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");           
        parametros.add(sFecha); 
        
        consulta.append("    and soc.perd_oid_peri =  ? ");
        parametros.add(periodo);
        
        consulta.append("    AND tipif.CLIE_OID_CLIE (+)= cli.OID_CLIE ");
        consulta.append("    AND cli.oid_clie = clientes.oidcliente   ");

        //jrivas 21/1/2007 INT-DATPRD4       
        consulta.append(" AND soc.ind_ts_no_conso = 1 ");
        consulta.append(" AND soc.ind_oc = 1	 ");
        consulta.append(" AND soc.ind_pedi_prue = 0 ");

        consulta.append(" GROUP BY CLI.OID_CLIE, EST.COD_ESTA_CLIE, tipif.control, MCUR.COD_CURS, ");
        consulta.append("       clientes.codigocliente, clientes.codigoterritorio ");
        consulta.append("       , ADI.NUM_CAMP_SIN_PEDI ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("  obtenerEstatusClientes2: Exception", e);
            this.logSql("  obtenerEstatusClientes2. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        ArrayList lista = new ArrayList();
        DTOINTEstatusCliente2 estatusCliente = null;
        
        if (rs != null) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                estatusCliente = new DTOINTEstatusCliente2();

                estatusCliente.setOidCliente(new Long(((BigDecimal) rs.getValueAt(i, "OIDCLIENTE")).longValue()));
                estatusCliente.setCodigoEstatus((String) rs.getValueAt(i, "CODIGOESTATUS"));
                estatusCliente.setIndicadorEsEstrella((BigDecimal) rs.getValueAt(i, "INDICADORESESTRELLA") + "");

                if (rs.getValueAt(i, "CODIGOCURSO") != null) {
                    estatusCliente.setCodigoTipoCurso(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOCURSO")).longValue()));
                }

                estatusCliente.setNumeroTotalOrdenes(new Long(((BigDecimal) rs.getValueAt(i, "NUMEROTOTALORDENES")).longValue()));
                estatusCliente.setCodigoCliente(new String(rs.getValueAt(i, "CODIGOCLIENTE").toString()));
                estatusCliente.setCodigoTerritorio(new Long(((BigDecimal) rs.getValueAt(i, "CODIGOTERRITORIO")).longValue()));
                
                lista.add(estatusCliente);
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerEstatusClientes2(Pais, Marca, Canal, Acceso, Periodo, FechaFacturacion): Salida");

        return lista;
    }
    public RecordSet obtenerZonasDeUAActivas(Long pais, Long marca, Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerZonasActivas(Long pais, Long marca, Long canal): Entrada");

        StringBuffer consulta = new StringBuffer();

        consulta.append("SELECT DISTINCT zon.OID_ZONA, zon.COD_ZONA ");
        consulta.append("  FROM (SELECT DISTINCT uad.ZTAD_OID_TERR_ADMI ");
        consulta.append("          FROM mae_clien_unida_admin uad ");
        consulta.append("         WHERE uad.IND_ACTI = 1 ");
        consulta.append("         ORDER BY uad.ZTAD_OID_TERR_ADMI) uniAdmActivas, ");
        consulta.append("       zon_terri_admin zta,");
        consulta.append("       zon_secci sec, ");
        consulta.append("       zon_zona zon ");
        consulta.append(" WHERE uniAdmActivas.ztad_oid_terr_admi = zta.oid_terr_admi ");
        consulta.append("   AND zta.zscc_oid_secc = sec.oid_secc ");
        consulta.append("   AND sec.zzon_oid_zona = zon.oid_zona ");

        if (pais != null) {
            consulta.append(" AND zon.pais_oid_pais = " + pais);
        }
        if (marca != null) {
            consulta.append(" AND zon.marc_oid_marc = " + marca);
        }
        if (canal != null) {
            consulta.append(" AND zon.cana_oid_cana = " + canal);
        }
        
        consulta.append("ORDER BY zon.COD_ZONA ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet zonasRS = null;
        String codigoError;

        try {
            zonasRS = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error("No se pudieron recuperar las Zonas", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOINTDAT.obtenerZonasActivas(Long pais, Long marca, Long canal): Salida");

        return zonasRS;
    }
    
    public RecordSet obtenerSaldosCobranzasZona( java.util.Date fechaFacturacion, String conAuxCargDire
                                                , String conAuxAjuste
                                                ,String strMarcaSitu
                                                , Long pais, Long marca, Long canal) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerSaldosCobranzasZona(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Vector oidCargosDirectos, Vector oidAnulacionesCreditos, Long oidZona): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        String conAux = new String ();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaSQL = new java.sql.Date(fechaFacturacion.getTime());
        String fechaFacturacionS = sdf.format(fechaSQL);
       
        
        consulta.append("SELECT   sec.zzon_oid_zona, zona.cod_zona COD_ZONA");
        consulta.append("	     ,NVL(SUM (csmcc.imp_pend ),0)  AS mont_deud_pend ");
        consulta.append("		 ,NVL (SUM(csmcc.imp_pendMS),0) tota_depu");
        consulta.append("		 ,NVL (SUM( A1  ) ,0)abon_mone_21 ");
        consulta.append("	     ,NVL (SUM( A2) ,0) abon_mone_31   ");
        consulta.append("         ,NVL (SUM( A3)  ,0)abon_mone_42 ");
        consulta.append("		,NVL (SUM( A4) ,0) abon_mone_63 ");
        consulta.append("		 ,NVL (SUM( A5)  ,0)abon_mone_mas63 ");
        consulta.append("		 	 ,NVL (SUM (A6),0)carg_dire");
        consulta.append("	   ,NVL (SUM(A7), 0)ajus_nota_credi  ");										   
        consulta.append("    FROM ");
        consulta.append("	   MAE_CLIEN_UNIDA_ADMIN ua,");
        consulta.append("         ZON_SECCI sec, zon_zona zona, ");
        consulta.append("         ZON_TERRI_ADMIN ta,");
        consulta.append("        	( (SELECT clie_oid_clie , imp_pend , NULL imp_pendMS , NULL A0, NULL  A1 ,  NULL  A2 ,  NULL  A3, NULL A4 ,    NULL A5,NULL A6 ,    NULL A7 ");
        consulta.append("		  		 FROM CCC_MOVIM_CUENT_CORRI m");
        consulta.append("           		  WHERE m.fec_docu <= TO_DATE ('"+fechaFacturacionS+"', 'yyyy-MM-dd') ");
        //consulta.append("             	  AND m.fec_docu >= TO_DATE ('" + ConstantesINT.FECHA_COBRANZAS_DESDE +"', 'YYYY-MM-DD')");
        consulta.append("             	  AND m.fec_docu >=  TO_DATE ( TO_CHAR (TO_DATE('"+fechaFacturacionS+"', 'yyyy-MM-dd'),'yyyy-mm')|| '-01','yyyy-MM-dd')");
        consulta.append("             	  AND m.masi_oid_marc_situ IN (" + strMarcaSitu + " )");
        consulta.append("             	  AND m.imp_movi <> m.imp_paga");
        consulta.append("		     ) UNION    ");
        consulta.append("			(SELECT clie_oid_clie,  sald_imp_pend   , NULL imp_pendMS  , NULL A0, NULL  A1 ,  NULL  A2 ,  NULL  A3, NULL A4 ,    NULL A5,NULL A6 ,    NULL A7 ");
        consulta.append("			   FROM CCC_SALDO_MOVIM_CUENT_CORRI csmcc ");
        consulta.append("			   WHERE csmcc.masi_oid_marc_situ IN (" + strMarcaSitu + ") ");
        consulta.append("			   AND csmcc.anio_mes >= 200001 ");
        consulta.append("			   AND csmcc.anio_mes <   TO_NUMBER (TO_CHAR (TO_DATE ('"+fechaFacturacionS+"', 'yyyy-MM-dd'),'yyyyMM')) ");
        consulta.append(" 	         ) UNION        ");
        consulta.append("         	 ( SELECT clie_oid_clie , NULL imp_pend , imp_pend imp_pendMS ,   NULL A0, NULL  A1 ,  NULL  A2 ,  NULL  A3, NULL A4 ,    NULL A5  ,NULL A6 ,    NULL A7 ");
        consulta.append("			        FROM CCC_MARCA_SITUA ms, CCC_MOVIM_CUENT_CORRI cc");
        consulta.append("                   WHERE ms.ind_cuen_cast = 1");
        consulta.append("                   AND ms.pais_oid_pais = " + pais);
        consulta.append("                   AND cc.masi_oid_marc_situ = ms.oid_marc_situ");
        consulta.append("             ) UNION     ");
        
        consulta.append("	 (SELECT cc.clie_oid_clie, NULL imp_pend , NULL imp_pendMS ,  cc.imp_pago, ");
        consulta.append("             CASE WHEN TRUNC (hcc.FEC_MOVI, 'DDD') - TRUNC(hcc.fec_docu, 'DDD') <= 21 ");
        consulta.append("                   THEN  cc.imp_pago + hcc.imp_pago ");
        consulta.append("                   ELSE 0");
        consulta.append("              END dias_21,");
        consulta.append("              CASE WHEN ((TRUNC (hcc.FEC_MOVI, 'DDD') - TRUNC(hcc.fec_docu, 'DDD') > 21) ");
        consulta.append("                           AND (TRUNC (hcc.FEC_MOVI, 'DDD')- TRUNC(cc.fec_docu, 'DDD') <= 31)) ");
        consulta.append("                   THEN cc.imp_pago + hcc.imp_pago ");
        consulta.append("                   ELSE 0");
        consulta.append("              END dias_31,");
        consulta.append("              CASE WHEN ((TRUNC (hcc.FEC_MOVI, 'DDD') - TRUNC(hcc.fec_docu, 'DDD') > 31) ");
        consulta.append("                           AND (TRUNC (hcc.FEC_MOVI, 'DDD') - TRUNC(cc.fec_docu, 'DDD') <= 42)) ");
        consulta.append("                   THEN cc.imp_pago+ hcc.imp_pago ");
        consulta.append("                   ELSE 0");
        consulta.append("              END dias_42,");
        consulta.append("              CASE WHEN ((TRUNC (hcc.FEC_MOVI, 'DDD') - TRUNC(hcc.fec_docu, 'DDD') > 42) ");
        consulta.append("                           AND (TRUNC (hcc.FEC_MOVI, 'DDD') - TRUNC(cc.fec_docu, 'DDD') <= 63))");
        consulta.append("                   THEN cc.imp_pago+hcc.imp_pago ");
        consulta.append("                   ELSE 0");
        consulta.append("              END dias_63,");
        consulta.append("              CASE WHEN TRUNC (hcc.FEC_MOVI, 'DDD') - TRUNC(hcc.fec_docu, 'DDD') > 63 ");
        consulta.append("                   THEN cc.imp_pago+hcc.imp_pago ");
        consulta.append("                   ELSE 0");
        consulta.append("              END dias_mayor     ,NULL A6 ,    NULL A7   ");
        consulta.append("         FROM  (      SELECT * FROM  CCC_MOVIM_CUENT_CORRI cc ");
        consulta.append("		  WHERE TRUNC (cc.fec_ulti_movi, 'DDD') = TO_DATE (?, 'YYYY-MM-DD')");/*FECHA FACTURACION */
        parametros.add(fechaFacturacionS);
        consulta.append("		   AND cc.imp_pago IS NOT NULL ");
        consulta.append("         AND cc.imp_pago <> 0)	cc 	");
        consulta.append("			 ,  CCC_HISTO_MOVIM_CC hcc ");
        consulta.append("     WHERE hcc.mvcc_oid_movi_cc(+) = cc.oid_movi_cc ");
        consulta.append("	 ) UNION ");
        
        if (conAuxCargDire != null){
            conAux = conAuxCargDire;
        }
        if (conAuxAjuste != null){
            if (conAux.equals("")){
                conAux = conAuxAjuste;
            }else {
                conAux = conAux + "," + conAuxAjuste;
            }
            
        }
        if (conAux.equals("")){
            consulta.append(" (SELECT  NULL clie_oid_clie ,NULL imp_pend,  NULL imp_pendMS , NULL A0, NULL  A1 ,  NULL  A2 ,  NULL  A3, NULL A4 ,    NULL A5, 0 imp_subp1 ,0	imp_subp2 FROM dual)  ");
        } else{
            consulta.append("  (SELECT clie_oid_clie,NULL imp_pend , NULL imp_pendMS ,   NULL A0, NULL  A1 ,  NULL  A2 ,  NULL  A3, NULL A4 ,    NULL A5, ");
            consulta.append("	        CASE WHEN dcad.tasp_oid_tipo_abon_subp IN (" + conAuxCargDire + ")");
            consulta.append("			            THEN dcad.imp");
            consulta.append("			            ELSE 0");
            consulta.append("	                    END imp_subp1,");
            consulta.append("	        CASE WHEN dcad.tasp_oid_tipo_abon_subp IN ("+ conAuxAjuste +")");
            consulta.append("	                THEN dcad.imp ");
            consulta.append("			        ELSE 0");
            consulta.append("	        END imp_subp2");
            consulta.append("       FROM (SELECT dcad.clie_oid_Clie , dcad.imp, dcad.tasp_oid_tipo_abon_subp FROM  CCC_DETAL_CARGO_ABONO_DIREC dcad ");
            consulta.append("		WHERE dcad.tasp_oid_tipo_abon_subp in ("+ conAux + " ))dcad");
            consulta.append("		) ");
        }
        consulta.append("  )csmcc ");
        consulta.append("   WHERE  sec.zzon_oid_zona in ( ");
        consulta.append(" SELECT DISTINCT zon.OID_ZONA ");
        consulta.append(" FROM (SELECT DISTINCT uad.ZTAD_OID_TERR_ADMI  ");
        consulta.append(" FROM mae_clien_unida_admin uad  ");
        consulta.append(" WHERE uad.IND_ACTI = 1  ");
        consulta.append(" ORDER BY uad.ZTAD_OID_TERR_ADMI) uniAdmActivas,  ");
        consulta.append(" zon_terri_admin zta, ");
        consulta.append(" zon_secci sec,  ");
        consulta.append(" zon_zona zon  ");
        consulta.append(" WHERE uniAdmActivas.ztad_oid_terr_admi = zta.oid_terr_admi  ");
        consulta.append(" AND zta.zscc_oid_secc = sec.oid_secc  ");
        consulta.append(" AND sec.zzon_oid_zona = zon.oid_zona  ");
        consulta.append(" AND zon.pais_oid_pais =  "+pais);
        consulta.append(" AND zon.marc_oid_marc =  "+marca);
        consulta.append(" AND zon.cana_oid_cana =  "+canal);
        consulta.append("   ) AND sec.oid_secc = ta.zscc_oid_secc ");
        consulta.append("   AND ta.oid_terr_admi = ua.ztad_oid_terr_admi ");
        consulta.append("   AND csmcc.clie_oid_clie(+) = ua.clie_oid_clie ");
        consulta.append("   AND	ua.IND_ACTI = 1");
        
        // gPineda - 20/02/2007 
        consulta.append("   and sec.zzon_oid_zona = zona.oid_zona ");
        
        consulta.append("  GROUP BY sec.zzon_oid_zona, cod_zona ");
		consulta.append("  order by cod_zona ");
        

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerSaldosCobranzas: Exception", e);
            this.logSql(" obtenerSaldosCobranzas. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }


        UtilidadesLog.info("DAOINTDAT.obtenerSaldosCobranzasZona(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Vector oidCargosDirectos, Vector oidAnulacionesCreditos, Long oidZona): Salida");
        return rs;
    }
    
    public Hashtable obtenerTiposAbonoSubprocesoPerf(Long pais , Vector indicadores) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerTiposAbonoSubprocesoPerf(Long pais, Vector indicadores): Entrada");
        
        String indicadores1= (String)indicadores.get(0);
        String indicadores2= (String)indicadores.get(1);
        
        Hashtable listaRes = new Hashtable();
        listaRes.put(indicadores1,new Vector());
        listaRes.put(indicadores2,new Vector());
        
        Vector aux = new Vector();      
       
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT DISTINCT abonos_dat.ind_indi  ");
        consulta.append(" , tipo_subproceso.oid_tipo_abon_subp  ");
        
        consulta.append(" FROM       INT_TIPOS_ABONO_DAT abonos_dat,  ");
        consulta.append("   CCC_TIPO_ABONO_SUBPR tipo_subproceso,  ");
        consulta.append("   CCC_TIPO_CARGO_ABONO tipo_ca ");
        consulta.append("  WHERE tipo_ca.pais_oid_pais = " + pais);
        consulta.append("  AND abonos_dat.tcab_oid_tipo_carg_abon = tipo_ca.oid_tipo_carg_abon ");
        consulta.append("  AND abonos_dat.ind_indi IN ( "+indicadores1 + "," + indicadores2 + ") ");
        consulta.append("  AND tipo_ca.oid_tipo_carg_abon = tipo_subproceso.tcab_oid_tcab ");


        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerTiposAbonoSubproceso: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {
            int n = rs.getRowCount();
            Long tmpOid;
            String tmpIndi;
            for (int i = 0; i < n; i++) {
                if (rs.getValueAt(i, "OID_TIPO_ABON_SUBP") != null) {
                    tmpOid = new Long(((BigDecimal) rs.getValueAt(i, "OID_TIPO_ABON_SUBP")).longValue());
                    tmpIndi = (String)rs.getValueAt(i, "IND_INDI");
                    if (indicadores1.indexOf(tmpIndi)!= -1){
                        aux =(Vector)listaRes.get(indicadores1);
                    }else {
                        aux =(Vector)listaRes.get(indicadores2);
                    }
                    aux.add(tmpOid);
                }
            }
        }

        UtilidadesLog.info("DAOINTDAT.obtenerTiposAbonoSubproceso(Long pais, String[] indicadores): Salida");

        return listaRes;
    }
    
    //jrivas 18/12/2006 DAT-24
    private void guardarOIDSSolicitudes(ArrayList listaOidsSoli) throws MareException {
        UtilidadesLog.info("DAOINTDAT.guardarOIDSSolicitudes()- entrada");        
    
        BelcorpService bs;
        StringBuffer oid;
        StringBuffer variasQuerys = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        // -> Armamos querys de insert
        Iterator iter = listaOidsSoli.iterator();
        while(iter.hasNext()) {
            oid = (StringBuffer)iter.next();
            variasQuerys.append(oid);
            variasQuerys.append(";");
        }

        try {
            UtilidadesLog.info("borrar");        
            bs.dbService.executeUpdate("DELETE INT_DAT_SOLIC");
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", variasQuerys.toString());
        } catch (Exception e) {
            UtilidadesLog.error("Error en guardarOIDSSolicitudes",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOINTDAT.guardarOIDSSolicitudes()- salida");        
    }    
    
    //jrivas 18/12/2006 DAT-24
    private StringBuffer armarInsertOIDSoli(String oid, java.util.Date fecha, Long numeroSolic, 
                    String codAcce, Long codTerr, String peri, String periRef, String codCana) {
        
        Vector parametros = new Vector();
        StringBuffer query  = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        String fechaFact = sdf.format(fechaSQL);
        
        query.append("INSERT INTO INT_DAT_SOLIC ( SOCA_OID_SOLI_CABE, FEC_FACT, VAL_NUME_SOLI, ");
        query.append(" COD_ACCE, COD_TERR, VAL_PERI_DOCU, VAL_PERI_DOCU_REFE, COD_CANA ");
        query.append(") VALUES (");
        query.append(oid).append(", ");
        query.append("TO_DATE('"+fechaFact+"', 'YYYY-MM-DD')").append(", ");
        query.append(numeroSolic).append(", ");
        query.append("'"+codAcce+"'").append(", ");
        query.append(codTerr).append(", ");
        query.append("'"+peri+"'").append(", ");
        if (periRef != null)
            query.append("'"+periRef+"'").append(", ");
        else 
            query.append((StringBuffer)null).append(", ");
        query.append("'"+codCana+"'").append(")");
        return query;
    }    

    //jrivas 18/12/2006 DAT-24
    /**
     * CHANGELOG
     * ---------
     * 28/04/2009 - dmorello, Cambio 20080824
     *     - Se agrega recuperacion de datos de INT_PARAM_TIPO_SOLIC
     *     - Se modifican algunos calculos segun lo recuperado de la tabla anterior
     * 07/05/2009 - dmorello - Se modifica calculo de unidades no atendidas para que concuerde con el DECU
     * 26/05/2009 - dmorello, Cambio 20080824 - Se corrigen errores detectados por el cliente
     * 04/06/2009 - dmorello, Cambio 20080824 - Se corrigen errores detectados por el cliente
     * 29/06/2009 - dmorello, Cambio 20090956 - Se modifica cálculo de unidades no atendidas
     */
    public ArrayList obtenerTransaccionesClientePerf(String oids) throws MareException { 
        UtilidadesLog.info("DAOINTDAT.obtenerTransaccionesClientePerf(): Entrada");     
        StringBuffer consulta = new StringBuffer(); 
        
        consulta.append(" SELECT MC.COD_CLIE                                   CODIGOCLIENTE,  ");
        consulta.append("        SOC.COD_ACCE                                  CODIGOACCESO,  ");
        consulta.append("        SOC.COD_TERR                                  CODIGOTERRITORIO,  ");
        consulta.append("        (CASE WHEN soc2.soca_oid_docu_refe is not null THEN SCREF.val_nume_soli ELSE soc.val_nume_soli END) NUMEROSOLICITUD, ");
        consulta.append("        MAX(SOC.FEC_FACT)                                  FECHAFACTURACION,  ");
        consulta.append("        SOC.VAL_PERI_DOCU                             PERIODODOCUMENTO,  ");
        consulta.append("        (CASE WHEN soc2.soca_oid_docu_refe is not null THEN PC.COD_PERI ELSE NULL END)  PERIODODOCUMENTOREFERENCIA, ");
        consulta.append("        DECODE (MAX(TS.IND_DEVO), 1, 'true', 0, 'false')     INDICADORDEVOLUCIONES,  ");
        consulta.append("        DECODE (MAX(TS.IND_ANUL), 1, 'true', 0, 'false')     INDICADORANULACIONES,  ");
        consulta.append("        PRO.COD_SAP                                   CODIGOPRODUCTO,  ");
        consulta.append("        POS.VAL_CODI_VENT                             CODIGOVENTA,  ");
        consulta.append("        TOF.COD_TIPO_OFER                             TIPOOFERTA,  ");
        consulta.append("        SUM(  ");
        consulta.append("           CASE WHEN PTS.NUM_UNID_VEND = 1 OR PTS.NUM_UNID_VEND_OTRO = 1 ");
        consulta.append("           THEN ABS(NVL (POS.NUM_UNID_ATEN, 0))  ");
        consulta.append("           ELSE 0 END");
        consulta.append("        ) UNIDADESATENDIDAS,  ");
        consulta.append("        SUM(  ");
        consulta.append("           CASE WHEN PTS.NUM_UNID_FALT = 1 OR PTS.NUM_UNID_FALT_OTRO = 1 ");
        consulta.append("           THEN (POS.NUM_UNID_DEMA_REAL - POS.NUM_UNID_COMPR)  ");
        consulta.append("           ELSE 0 END");
        consulta.append("        ) UNIDADESNOATENDIDAS,  ");
        consulta.append("        SUM (ABS (case when pts.num_unid_devu = 1 then (NVL (POS.NUM_UNID_ATEN, 0)) else 0 end)) UNIDADESDEVUELTAS,  ");        
        consulta.append("        SUM (ABS (case when pts.num_unid_anul = 1 then (NVL (POS.NUM_UNID_ATEN, 0)) else 0 end)) UNIDADESANULADAS,  ");        
        consulta.append("        SUM (ABS(NVL (POS.VAL_PREC_NETO_UNIT_LOCA, 0))) PRECIONETOUNITARIOLOCAL, ");
        consulta.append("        SUM(ABS(NVL (POS.VAL_PREC_NETO_TOTA_LOCA, 0))) PRECIONETOTOTALLOCAL, ");
        consulta.append("        ABS (NVL (SUM(POS.VAL_PREC_FACT_UNIT_LOCA), 0))     PRECIOFACTURAUNITARIOLOCAL,  ");
        // vbongiov -- Cambio 20080763 -- 16/10/2008
        
        consulta.append("  SUM (ABS (CASE   ");
        consulta.append("             WHEN pts.num_unid_vend = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN  ");
        consulta.append("                 pos.val_prec_fact_tota_loca  ");
        consulta.append("             ELSE 0 END))       PRECIOFACTURATOTALLOCAL, "); 

        consulta.append("        ABS (NVL (SUM(POS.VAL_PREC_CATA_UNIT_LOCA), 0))     PRECIOCATALOGOUNITARIOLOCAL,  ");
        consulta.append("        SOC.COD_CANA                                  CODIGOCANAL,  ");
        consulta.append(" SUM(CASE WHEN PTS.NUM_UNID_VEND = 1 OR PTS.NUM_UNID_VEND_OTRO = 1 THEN " +
              " decode(pos.val_prec_cata_unit_loca,0,0,((pos.num_unid_dema_real-pos.num_unid_compr)*pos.val_prec_neto_unit_loca))");     
        consulta.append("  ELSE 0 END ) MONTO_FALTANTE,");
        
        //sbuchelli oportunidad ahorro
        //NVL( PED_SOLIC_POSIC.Val_Prec_Publ_Unit_Loca ) - NVL( PED_SOLIC_POSIC.Val_Prec_Fact_Tota_Loca )
        //NVL(PED_SOLIC_POSIC.val_prec_publ_tota_loca,0) + ( NVL(PED_SOLIC_POSIC.val_impo_desc_unit_loca,0) * PED_SOLIC_POSIC.num_unid_compr )
         consulta.append(" SUM(CASE WHEN  TS.cod_tipo_soli = 'SOC' AND SOC2.ind_oc = 1  AND SOC2.modu_oid_modu !=13  and  SOC2.modu_oid_modu !=15  THEN " +
               "NVL(POS.val_impo_desc_unit_loca, 0)*NVL(POS.num_unid_compr,0)  +  NVL(POS.val_prec_publ_tota_loca, 0) " +
               "  ELSE 0 END)  OPORTUNIDADAHORRO, ");
               
        consulta.append(" SUM (ABS (CASE ");               
        consulta.append("       WHEN pts.num_unid_canj = 1 THEN (NVL (pos.num_unid_aten, 0))   ");               
        consulta.append("       ELSE 0 ");               
        consulta.append("           END)) UNIDADESRETORNO, ");               
        consulta.append(" SUM (ABS (CASE ");               
        consulta.append("       WHEN pts.num_unid_true = 1 THEN (NVL (pos.num_unid_aten, 0))   ");               
        consulta.append("       ELSE 0 ");               
        consulta.append("           END)) UNIDADESATENCION, ");               
        
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_canj = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETORETORNO, ");               
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_true = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETOATENCION, ");                              
        
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_vend = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETOVENTA, ");                              
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_devu = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETODEVOLUCION, ");                              
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_anul = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETOANULACION ");                              
        
        consulta.append("   FROM INT_DAT_SOLIC   SOC,  ");
        consulta.append("        PED_SOLIC_POSIC POS,  ");
        consulta.append("        (SELECT A.CLIE_OID_CLIE, A.OID_SOLI_CABE, A.TSPA_OID_TIPO_SOLI_PAIS, A.SOCA_OID_SOLI_CABE, A.MODU_OID_MODU, A.SOCA_OID_DOCU_REFE, A.ind_oc ");
        consulta.append("           FROM PED_SOLIC_CABEC A) SOC2,  ");
        consulta.append("        PED_TIPO_SOLIC_PAIS TSP,  ");
        consulta.append("        PED_TIPO_SOLIC TS,  ");
        consulta.append("        (SELECT C.OID_CLIE, C.COD_CLIE FROM MAE_CLIEN C) MC,  ");
        consulta.append("        MAE_PRODU PRO,  ");
        consulta.append("        PRE_OFERT_DETAL OFD,  ");
        consulta.append("        PRE_TIPO_OFERT TOF,  ");
        consulta.append("        (SELECT OID_SOLI_CABE, PERD_OID_PERI, val_nume_soli FROM PED_SOLIC_CABEC) SCREF,  ");        
        consulta.append("        CRA_PERIO PE,  ");                
        consulta.append("        SEG_PERIO_CORPO PC  ");                        
        consulta.append("      , INT_PARAM_TIPO_SOLIC PTS ");
        consulta.append("  WHERE POS.SOCA_OID_SOLI_CABE       = SOC.SOCA_OID_SOLI_CABE  ");
        consulta.append("    AND SOC2.CLIE_OID_CLIE           = MC.OID_CLIE  ");
        consulta.append("    AND SOC2.OID_SOLI_CABE           = SOC.SOCA_OID_SOLI_CABE  ");
        consulta.append("    AND SOC2.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS  ");
        consulta.append("    AND TSP.TSOL_OID_TIPO_SOLI       = TS.OID_TIPO_SOLI  ");
        consulta.append("    AND POS.OFDE_OID_DETA_OFER       = OFD.OID_DETA_OFER             (+)  ");
        consulta.append("    AND OFD.PROD_OID_PROD            = PRO.OID_PROD                  (+)  ");
        consulta.append("    AND OFD.TOFE_OID_TIPO_OFER       = TOF.OID_TIPO_OFER             (+)  ");
        consulta.append("    AND POS.ESPO_OID_ESTA_POSI      <> " + ConstantesPED.ESTADO_POSICION_ANULADO); 
        consulta.append("    AND SOC.SOCA_OID_SOLI_CABE IN (" + oids+ ")  ");
        //consulta.append("    AND (   (TS.IND_DEVO = 0 AND TS.IND_ANUL=0) "); 
        //consulta.append("         OR (FN_DAT_VALIDAR_PROD_SOLI_DEVO (SOC2.OID_SOLI_CABE, POS.OID_SOLI_POSI) > 0)) "); 
        
        consulta.append("    AND (  ");
        consulta.append("         (pts.num_unid_vend = 1 AND ts.ind_anul = 0 AND ts.ind_devo = 0)     ");
        consulta.append("           OR  ");
        consulta.append("         (pts.num_unid_falt = 1 AND ts.ind_anul = 0 AND ts.ind_devo = 0 )   ");
        consulta.append("           OR  ");
        consulta.append("         (pts.num_unid_devu = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
        consulta.append("           OR  ");
        consulta.append("         (pts.num_unid_anul = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
        consulta.append("           OR  ");
        consulta.append("         (pts.num_unid_canj = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
        consulta.append("           OR  ");
        consulta.append("         (pts.num_unid_true = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
        consulta.append("        )  ");
        
        consulta.append("    AND SOC2.SOCA_OID_DOCU_REFE = SCREF.OID_SOLI_CABE(+)  ");
        consulta.append("    AND SCREF.PERD_OID_PERI = PE.OID_PERI(+)  ");
        consulta.append("    AND PE.PERI_OID_PERI = PC.OID_PERI(+)  ");        
        consulta.append("    AND PTS.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        consulta.append(" GROUP BY  "); 
        consulta.append("  SOC.VAL_PERI_DOCU,  ");
        consulta.append("  SOC.COD_ACCE,  ");        
        consulta.append("  (CASE WHEN soc2.soca_oid_docu_refe is not null THEN SCREF.val_nume_soli ELSE soc.val_nume_soli END), ");        
        consulta.append("  soc.COD_CANA,  ");
        consulta.append("  (CASE WHEN soc2.soca_oid_docu_refe is not null THEN PC.COD_PERI ELSE NULL END),  ");        
        consulta.append("  PRO.COD_SAP,  ");
        consulta.append("  SOC.COD_TERR,  ");
        consulta.append("  MC.COD_CLIE,  ");
        consulta.append("  TOF.COD_TIPO_OFER,  ");
        consulta.append("  POS.VAL_CODI_VENT  ");
        //consulta.append(", PTS.OID_PARA_TIPO_SOLI ");  //sapaza -- PER-SiCC-2010-0713E -- 09/12/2010
        consulta.append(", PTS.NUM_UNID_VEND_OTRO ");
        consulta.append(", PTS.NUM_UNID_FALT_OTRO ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
            rs =bs.dbService.executeStaticQuery(consulta.toString()); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("obtenerTransaccionesClientePerf: Exception",e); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
        
        ArrayList lista = new ArrayList(); 
        
        // Rellenamos el ArrayList con objetos 'DTOINTTxCliente' 
        if(rs != null){ 
            int x = rs.getRowCount(); 
            for(int i = 0; i < x; i++){ 
                DTOINTTxCliente dto = new DTOINTTxCliente(); 

                    if(rs.getValueAt(i,"CODIGOCLIENTE") != null){                 
                        dto.setCodigoCliente(rs.getValueAt(i,"CODIGOCLIENTE").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOACCESO") != null){ 
                        dto.setCodigoAcceso(rs.getValueAt(i,"CODIGOACCESO").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOTERRITORIO") != null){ 
                        dto.setCodigoTerritorio(new Long(rs.getValueAt(i,"CODIGOTERRITORIO").toString())); 
                    } 
                    if(rs.getValueAt(i,"NUMEROSOLICITUD") != null){ 
                        dto.setNumeroSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROSOLICITUD")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"FECHAFACTURACION") != null){ 
                        dto.setFechaFacturacion(new Date(((java.sql.Date)rs.getValueAt(i,"FECHAFACTURACION")).getTime())); 
                    } 
                    if(rs.getValueAt(i,"PERIODODOCUMENTO") != null){ 
                        dto.setPeriodoDocumento(rs.getValueAt(i,"PERIODODOCUMENTO").toString()); 
                    } 
                    if(rs.getValueAt(i,"PERIODODOCUMENTOREFERENCIA") != null){ 
                        dto.setPeriodoDocumentoReferencia(rs.getValueAt(i,"PERIODODOCUMENTOREFERENCIA").toString()); 
                    } 
                    /*if(rs.getValueAt(i,"TIPOSOLICITUD") != null){ 
                        dto.setTipoSolicitud(rs.getValueAt(i,"TIPOSOLICITUD").toString()); 
                    }*/ 
                    if(rs.getValueAt(i,"INDICADORDEVOLUCIONES") != null){ 
                        if ((rs.getValueAt(i,"INDICADORDEVOLUCIONES").toString()).equals("false")){ 
                            dto.setIndicadorDevoluciones(Boolean.FALSE); 
                        }else{ 
                            dto.setIndicadorDevoluciones(Boolean.TRUE); 
                        } 
                    } 
                    if(rs.getValueAt(i,"INDICADORANULACIONES") != null){ 
                        if ((rs.getValueAt(i,"INDICADORANULACIONES").toString()).equals("false")){ 
                            dto.setIndicadorAnulaciones(Boolean.FALSE); 
                        }else{ 
                            dto.setIndicadorAnulaciones(Boolean.TRUE); 
                        } 
                    } 
                    if(rs.getValueAt(i,"CODIGOPRODUCTO") != null){                 
                        dto.setCodigoProducto(rs.getValueAt(i,"CODIGOPRODUCTO").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOVENTA") != null){                 
                        dto.setCodigoVenta(rs.getValueAt(i,"CODIGOVENTA").toString()); 
                    } 
                    if(rs.getValueAt(i,"TIPOOFERTA") != null){                 
                        dto.setTipoOferta(rs.getValueAt(i,"TIPOOFERTA").toString()); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESATENDIDAS") != null){ 
                        dto.setUnidadesAtendidas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESATENDIDAS")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESNOATENDIDAS") != null){ 
                        dto.setUnidadesNoAtendidas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESNOATENDIDAS")).longValue())); 
                    } 

                    //<inicio> Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147                    
                    if(rs.getValueAt(i,"UNIDADESDEVUELTAS") != null){ 
                        dto.setUnidadesDevueltas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESDEVUELTAS")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESANULADAS") != null){ 
                        dto.setUnidadesAnuladas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESANULADAS")).longValue())); 
                    } 
                    //<fin> Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147

                    if(rs.getValueAt(i,"PRECIONETOUNITARIOLOCAL") != null){ 
                        dto.setPrecioNetoUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIONETOUNITARIOLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIONETOTOTALLOCAL") != null){ 
                        dto.setPrecioNetoTotalLocal((BigDecimal)rs.getValueAt(i,"PRECIONETOTOTALLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIOFACTURAUNITARIOLOCAL") != null){ 
                        dto.setPrecioFacturaUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIOFACTURAUNITARIOLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIOFACTURATOTALLOCAL") != null){ 
                        dto.setPrecioFacturaTotalLocal((BigDecimal)rs.getValueAt(i,"PRECIOFACTURATOTALLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"CODIGOCANAL") != null){ 
                        dto.setCodigoCanal(rs.getValueAt(i,"CODIGOCANAL").toString()); 
                    } 
                    //  Agregado por HRCS - Fecha 21/03/2007 - Cambio Sicc20070147
                    if (rs.getValueAt(i,"PRECIOCATALOGOUNITARIOLOCAL") != null)   {
                        dto.setPrecioCatalogoUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIOCATALOGOUNITARIOLOCAL"));
                    }
                    
                    if (rs.getValueAt(i,"MONTO_FALTANTE") != null)   {
                        dto.setMontoFaltante((BigDecimal)rs.getValueAt(i,"MONTO_FALTANTE"));
                    }                    
                    //OPORTUNIDADAHORRO
                     if (rs.getValueAt(i,"OPORTUNIDADAHORRO") != null)   {
                         dto.setOportunidadAhorro((BigDecimal)rs.getValueAt(i,"OPORTUNIDADAHORRO"));
                     }              
                     
                    //<inicio> Agregado por Sapaza - Fecha 01/09/2011 - RCR PER-SiCC-2011-0566                    
                    if(rs.getValueAt(i,"UNIDADESRETORNO") != null){ 
                        dto.setUnidadesRetorno(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESRETORNO")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESATENCION") != null){ 
                        dto.setUnidadesAtencion(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESATENCION")).longValue())); 
                    }
                    if (rs.getValueAt(i,"MONTONETORETORNO") != null)   {
                        dto.setMontoNetoRetorno((BigDecimal)rs.getValueAt(i,"MONTONETORETORNO"));
                    }
                    if (rs.getValueAt(i,"MONTONETOATENCION") != null)   {
                        dto.setMontoNetoAtencion((BigDecimal)rs.getValueAt(i,"MONTONETOATENCION"));
                    }
                    if (rs.getValueAt(i,"MONTONETOVENTA") != null)   {
                        dto.setMontoNetoVenta((BigDecimal)rs.getValueAt(i,"MONTONETOVENTA"));
                    }
                    if (rs.getValueAt(i,"MONTONETODEVOLUCION") != null)   {
                        dto.setMontoNetoDevolucion((BigDecimal)rs.getValueAt(i,"MONTONETODEVOLUCION"));
                    }
                    if (rs.getValueAt(i,"MONTONETOANULACION") != null)   {
                        dto.setMontoNetoAnulacion((BigDecimal)rs.getValueAt(i,"MONTONETOANULACION"));
                    }
                    //<fin> Agregado por Sapaza - Fecha 01/09/2011 - RCR PER-SiCC-2011-0566
                     
                    lista.add(dto); 
                } 
            } 
        // Traza de salida 
        UtilidadesLog.info("DAOINTDAT.obtenerTransaccionesClientePerf(): Salida"); 
        return lista; 
    }
    
    //jrivas 18/12/2006 DAT-24
    public RecordSet obtenerSolicitudesTransaccionesClientePerf() throws MareException { 
        UtilidadesLog.info("DAOINTDAT.obtenerSolicitudesTransaccionesClientePerf(): Entrada");
        
        StringBuffer consulta = new StringBuffer(); 
 
        //<inicio>modificado por Sapaza, para que ordene por cliente       
        /*consulta.append(" SELECT DISTINCT SOCA_OID_SOLI_CABE ");
        consulta.append(" FROM INT_DAT_SOLIC ");
        consulta.append(" ORDER BY 1 ");*/
        consulta.append(" SELECT DISTINCT DAT.SOCA_OID_SOLI_CABE, PED.CLIE_OID_CLIE ");
        consulta.append(" FROM   INT_DAT_SOLIC DAT, PED_SOLIC_CABEC PED ");
        consulta.append(" WHERE  DAT.SOCA_OID_SOLI_CABE = PED.OID_SOLI_CABE ");
        consulta.append(" ORDER  BY PED.CLIE_OID_CLIE ");
        //<fin>

        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
            rs =bs.dbService.executeStaticQuery(consulta.toString()); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("obtenerTransaccionesClientePerf: Exception",e); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
        
        return rs;
    }
    
    public void actualizarEnvioCursosDat(Long pais, Long marca, Long canal, java.util.Date fechaFacturacion, Long tipoCliente) throws MareException {
        UtilidadesLog.info("DAOINTDAT.actualizarEnvioCursosDat19(): Entrada");
        
        StringBuffer update = new StringBuffer();
        Vector parametros = new Vector();
       
        update.append(" UPDATE EDU_APTAS_CURSO apcu2 SET IND_ENVI=1 WHERE  apcu2.OID_APTA IN ( SELECT APCU.OID_APTA ");
        update.append(" FROM   EDU_APTAS_CURSO APCU,EDU_MATRI_CURSO MCUR,EDU_PLANT_CURSO_CABEC PCUR,MAE_CLIEN CLI,CRA_PERIO PERI, ");
        update.append("        SEG_PERIO_CORPO PCOR,EDU_TIPO_CURSO TCUR,SEG_CANAL CANA ");
        update.append(" WHERE  APCU.MCUR_OID_CURS = MCUR.OID_CURS AND MCUR.CPLC_OID_CABE_PLAN_CURS = PCUR.OID_CABE ");
        update.append("        AND APCU.CLIE_OID_CLIE = CLI.OID_CLIE AND MCUR.PERD_OID_PERI_INGR = PERI.OID_PERI(+) ");
        update.append("        AND PERI.PERI_OID_PERI = PCOR.OID_PERI(+) AND MCUR.TICU_OID_TIPO_CURS = TCUR.OID_TIPO_CURS ");
        update.append("        AND MCUR.CANA_OID_CANA = CANA.OID_CANA ");
        update.append(" 	   AND IND_ENVI=0 ");
        
        if (pais != null) {
            update.append("   AND MCUR.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        if (marca != null) {
            update.append("   AND MCUR.MARC_OID_MARC = ? ");
            parametros.add(marca);
        }

        if (canal != null) {
            update.append("   AND MCUR.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }

        if (fechaFacturacion != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date fecha = new java.sql.Date(fechaFacturacion.getTime());

            String sFecha = sdf.format(fecha);
            update.append("    AND MCUR.FEC_DISP_CURS <= TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ");
            parametros.add(sFecha);
        }

        if (tipoCliente != null) {
            update.append("   AND MCUR.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(tipoCliente);
        }
        
        update.append(") ");
        
        try{ 
            UtilidadesEJB.getBelcorpService().dbService.executePreparedUpdate( update.toString() , parametros ); 
        }catch (Exception e) { 
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("actualizarEnvioCursosDat19: Exception",e); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }
        UtilidadesLog.info("DAOINTDAT.actualizarEnvioCursosDat19(): Salida");
    }
    
    /**
     * Nuevo metodo que trae el codigo periodo de PeriodoCorporativo para un cliente nuevo, sumandole
     * al periodo inicial un numero de campanias
     * @throws es.indra.mare.common.exception.MareException
     * @return codigo periodo
     * @param numeroAdicionalCampanias
     * @param cliente
     */
    public String obtenerPeriodoCorpoDeClienteNuevo( String cliente, int numeroAdicionalCampanias) throws MareException { 
        UtilidadesLog.debug("DAOINTDAT.obtenerPeriodoCorpoDeClienteNuevo: Entrada");
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector();
        
        /*consulta.append(" select pc.cod_peri ");
        consulta.append(" from mae_clien mc, mae_clien_histo_estat mch, cra_perio cp, seg_perio_corpo pc ");
        consulta.append(" where mc.cod_clie = ? and ");
        parametros.add(cliente);
        consulta.append("  mc.oid_clie = mch.clie_oid_clie and ");
        consulta.append("  mch.esta_oid_esta_clie = "+ ConstantesMAE.OID_ESTATUS_NUEVA +" and ");
        consulta.append("  cp.oid_peri = (mch.perd_oid_peri+"+ numeroAdicionalCampanias +") and ");
        consulta.append("  cp.peri_oid_peri = pc.oid_peri ");
        */
        //se modifica en el marco del cambio: SiCC20070488, (SCS-10/12/07)
        consulta.append(" select pc.cod_peri from");
        consulta.append(" mae_clien mc, mae_clien_prime_conta cpc, cra_perio cp, seg_perio_corpo pc");
        consulta.append(" where mc.cod_clie = ? and");
        parametros.add(cliente);
        consulta.append(" mc.oid_clie = cpc.CLIE_OID_CLIE and");
        consulta.append(" cp.oid_peri = (cpc.perd_oid_peri + " + numeroAdicionalCampanias + ") and");
        consulta.append(" cp.peri_oid_peri = pc.oid_peri");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerPeriodoCorpoDeClienteNuevo: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        String periodoCorpo = "0";
        if (!rs.esVacio())   {
            periodoCorpo = (String)rs.getValueAt( 0, 0);
        }
        UtilidadesLog.debug("DAOINTDAT.obtenerPeriodoCorpoDeClienteNuevo: Salida");
        return periodoCorpo;
    }
    
    /**
     * Metodo que valida los indicadores de asistencia y convocatoria para obtener el periodo corporativo
     * @throws es.indra.mare.common.exception.MareException
     * @return periodo corporativo
     * @param dto
     */
    public String obtenerPeriodoCorpoParaAnioCampaniaCapac( DTOINTAptaCurso dto ) throws MareException { 
        UtilidadesLog.debug("DAOINTDAT.obtenerPeriodoCorpoParaAnioCampaniaCapac: Entrada");

        String periodoCorpo = "";
        if ( dto.getIndicadorAsistencia()!=null && dto.getIndicadorAsistencia().equals("1") )   {
            if ( dto.getNumeroConvocatoria()!=null && dto.getNumeroConvocatoria().equals( new Integer(1)) ) {
                periodoCorpo = obtenerPeriodoCorpoDeClienteNuevo( dto.getCodigoCliente(), 1 );  //  Se suma una campania
            }
            else if ( dto.getNumeroConvocatoria()!=null && dto.getNumeroConvocatoria().equals( new Integer(2)) ) {
                periodoCorpo = obtenerPeriodoCorpoDeClienteNuevo( dto.getCodigoCliente(), 2 );  //  Se suma mas dos campanias
            }
        }
        else if ( dto.getIndicadorAsistencia()!=null && dto.getIndicadorAsistencia().equals("2") )   {
            
            StringBuffer consulta = new StringBuffer(); 
            Vector parametros = new Vector();
            consulta.append(" select pc.cod_peri ");
            consulta.append(" from cra_perio cp, seg_perio_corpo pc ");
            consulta.append(" where ");
            consulta.append("  cp.peri_oid_peri = pc.oid_peri and ");
            consulta.append("  TO_DATE( ? ,'YYYY-MM-DD') between cp.fec_inic and cp.fec_fina ");
            parametros.add( formateaFecha(dto.getFechaAsistencia()) );
            consulta.append("  and rownum = 1 ");
            consulta.append(" order by cp.fec_inic ");
    
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            RecordSet rs = null;
            try {
                rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            } catch (Exception e) {
                UtilidadesLog.error(" obtenerPeriodoCorpoParaAnioCampaniaCapac: Exception", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            if (!rs.esVacio())   {
                periodoCorpo = (String)rs.getValueAt( 0, 0);
            }
        }
        
        UtilidadesLog.debug("DAOINTDAT.obtenerPeriodoCorpoParaAnioCampaniaCapac: Salida");
        return periodoCorpo;
    }    
    
    /**
     * Obtiene la ultima fecha de procesamiento de historico lotes
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param pais Codigo pais
     * @param codigoInterfaz Codigo de la Interfaz
     */
    public java.sql.Date obtenerUltimaFechaProceHistoLotes( String codigoInterfaz, Long pais ) throws MareException { 
        UtilidadesLog.debug("DAOINTDAT.obtenerUltimaFechaProceHistoLotes: Entrada");
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector();
        
        consulta.append(" select max(fec_fin_proc) ");
        consulta.append(" from int_histo_lotes ");
        consulta.append(" where cod_inte = ? ");
        parametros.add(codigoInterfaz);
        consulta.append("  and pais_oid_pais = ? ");
        parametros.add(pais);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerUltimaFechaProceHistoLotes: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        java.sql.Date fecha = null;
        if (rs != null) {
            if (!rs.esVacio()) {
                if (rs.getValueAt(0, 0) != null) {
                    fecha = (java.sql.Date)rs.getValueAt( 0, 0);
                }
            }
        }
        UtilidadesLog.debug("DAOINTDAT.obtenerUltimaFechaProceHistoLotes: Salida");
        return fecha;
    }    
    
    /**
     * Obtiene la ultima fecha de procesamiento de historico lotes
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param pais Codigo pais
     * @param codigoInterfaz Codigo de la Interfaz
     */
    public String obtenerUltimaFechaProceHistoLotesSTR( String codigoInterfaz, Long pais ) throws MareException { 
        UtilidadesLog.debug("DAOINTDAT.obtenerUltimaFechaProceHistoLotesSTR: Entrada");
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector();
        
        consulta.append(" select to_char( max(fec_fin_proc), 'YYYY-MM-DD HH24:MI:SS' )  ");
        consulta.append(" from int_histo_lotes ");
        consulta.append(" where cod_inte = ? ");
        parametros.add(codigoInterfaz);
        consulta.append("  and pais_oid_pais = ? ");
        parametros.add(pais);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerUltimaFechaProceHistoLotesSTR: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        String fecha = null;
        if (rs != null) {
            if (!rs.esVacio()) {
                if (rs.getValueAt(0, 0) != null) {
                    fecha = rs.getValueAt( 0, 0).toString();
                }
            }
        }
        UtilidadesLog.debug("DAOINTDAT.obtenerUltimaFechaProceHistoLotesSTR: Salida");
        return fecha;
    }    
    
    /**
     * Metodo que obtiene las interfaces a visualizar en una pantalla
     * Creado por HRCS - Fecha 17/04/2007 - Cambio Sicc20070215
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param pais
     * @param interfaz
     */
    public RecordSet obtenerInterfacesParaVisualizar( String interfaz, Long pais ) throws MareException { 
        UtilidadesLog.info("DAOINTDAT.obtenerInterfacesParaVisualizar(): Entrada");
        
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector();
        
        consulta.append(" select oid_visu_inte, cod_fluj, val_desc, 'S' as checked ");
        consulta.append(" from int_visua_inter ");
        consulta.append(" where pais_oid_pais = ? and ");
        parametros.add(pais);
	    consulta.append(" val_inte = ? and ");
        parametros.add(interfaz);
        consulta.append(" ind_activ = 1 ");
        consulta.append(" order by oid_visu_inte ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerInterfacesParaVisualizar: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("DAOINTDAT.obtenerInterfacesParaVisualizar: Salida");
        return rs;
    }
  
    /**
     * Metodo que obtiene los procesos a ejecutar para las interfaces
     * Creado por HRCS - Fecha 18/04/2007 - Cambio Sicc20070215
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param codigos
     */
    public RecordSet obtenerProcesosInterfacesParaEnviar( String codigos ) throws MareException { 
        UtilidadesLog.info("DAOINTDAT.obtenerProcesosInterfacesParaEnviar(): Entrada");
        
        StringBuffer consulta = new StringBuffer(); 
        Vector parametros = new Vector();
        
        consulta.append(" select vi.cod_fluj, vi.val_desc, t.cod_proc, t.val_prog_ejec ");
        consulta.append(" from int_visua_inter vi, cra_trans t ");
        consulta.append(" where vi.tran_oid_tran = t.oid_tran and ");
        consulta.append(" vi.oid_visu_inte in ( "+ codigos +" ) ");
        consulta.append(" order by vi.oid_visu_inte ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerProcesosInterfacesParaEnviar: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("DAOINTDAT.obtenerProcesosInterfacesParaEnviar: Salida");
        return rs;
    }

    /**
     * Metodo que obtiene la ultima fecha procesada de un determinado periodo para la interfaz DAT-11
     * Creado por SA - Fecha 18/04/2007 - Cambio Sicc20070218
     * @throws es.indra.mare.common.exception.MareException
     * @return Date
     * @param pais
     * @param codigoInterfaz
     * @param periodo 
     */
    public java.util.Date obtenerUltimaFechaPeriodo(Long pais, String codigoInterfaz, Long periodo) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerUltimaFechaPeriodo(Long pais, String codigoInterfaz, Long periodo): Entrada");

        StringBuffer consulta = new StringBuffer();
        StringBuffer consulta1 = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();

        /* consulta.append(" SELECT MAX(trunc(HL.FEC_FIN_PROC)) ");
        consulta.append(" FROM CRA_PERIO CP, INT_HISTO_LOTES HL ");
        consulta.append(" WHERE CP.FEC_INIC <= trunc(HL.FEC_FIN_PROC) ");
        consulta.append("   AND CP.FEC_FINA >= trunc(HL.FEC_FIN_PROC) ");        
        consulta.append("   AND CP.OID_PERI = ? ");                        
        parametros.add(periodo);        
        consulta.append("   AND HL.PAIS_OID_PAIS = ? ");                
        parametros.add(pais);
        consulta.append("   AND HL.COD_INTE LIKE ? ");
        parametros.add(codigoInterfaz);*/
        
        consulta.append(" SELECT MAX (TRUNC (hl.fec_fin_proc)) ");
        consulta.append("   FROM int_histo_lotes hl ");
        consulta.append("  WHERE  hl.peri_oid_peri = ? ");
        parametros.add(periodo);        
        consulta.append("    AND hl.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append("    AND hl.cod_inte LIKE ? ");
        parametros.add(codigoInterfaz);

        consulta1.append(" SELECT MAX (TRUNC (ihl.fec_fin_proc)) ");
        consulta1.append("   FROM cra_perio cp, int_histo_lotes ihl ");
        consulta1.append("  WHERE ihl.fec_fin_proc < cp.fec_inic  ");
        consulta1.append("    AND cp.oid_peri = ? ");
        consulta1.append("    AND ihl.pais_oid_pais = ? ");
        consulta1.append("    AND ihl.cod_inte LIKE ? ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            if (rs == null || rs.esVacio()) {
              UtilidadesLog.info(" Primera ejecucion para este Periodo ");
              rs = bs.dbService.executePreparedQuery(consulta1.toString(), parametros);
            }
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerUltimaFechaPeriodo: Exception", e);
            this.logSql(" obtenerUltimaFechaPeriodo. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        /*
        - con el registro obtenido se construye un objeto java.util.Date y se retorna.
        - si no se obtiene ningún registro, se retorna null.
        */

        java.util.Date fecha = null;

        if (rs != null) {
            if (!rs.esVacio()) {
                if (rs.getValueAt(0, 0) != null) {
                    fecha = new java.util.Date(((java.sql.Date) rs.getValueAt(0, 0)).getTime());
                }
            }
        } 

        UtilidadesLog.info("DAOINTDAT.obtenerUltimaFechaPeriodo(Long pais, String codigoInterfaz, Long periodo): Salida");

        return fecha;
    }

    /**
     * Metodo que obtiene la ultima fecha procesada menor de la fecha de facturacion
     * de un determinado periodo para la interfaz DAT-11
     * Creado por SA - Fecha 18/04/2007 - Cambio Sicc20070218
     * @throws es.indra.mare.common.exception.MareException
     * @return Date
     * @param pais
     * @param codigoInterfaz
     * @param periodo 
     * @param fechaFacturacion
     */
    public java.util.Date obtenerUltimaFechaMenorFacturacion(Long pais, String codigoInterfaz, Long periodo, java.util.Date fechaFacturacion) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerUltimaFechaMenorFacturacion(Long pais, String codigoInterfaz, Long periodo, Date fechaFacturacion): Entrada");

        StringBuffer consulta = new StringBuffer();
               StringBuffer consulta1 = new StringBuffer();
               Vector parametros = new Vector();
               Vector parametros1 = new Vector();
               ArrayList array = new ArrayList();

               consulta.append(" SELECT MAX(trunc(HL.FEC_FIN_PROC)) ");
               consulta.append(" FROM CRA_PERIO CP, INT_HISTO_LOTES HL ");
               consulta.append(" WHERE CP.FEC_INIC <= trunc(HL.FEC_FIN_PROC) ");
               consulta.append("   AND CP.FEC_FINA >= trunc(HL.FEC_FIN_PROC) ");        
               consulta.append("   AND CP.OID_PERI = ? ");                        
               parametros.add(periodo);        
               consulta.append("   AND HL.PAIS_OID_PAIS = ? ");                
               parametros.add(pais);
               consulta.append("   AND HL.COD_INTE LIKE ? ");
               parametros.add(codigoInterfaz);
               consulta.append("   AND trunc(HL.FEC_FIN_proc) < to_Date(?, 'YYYY-MM-DD') ");        
               parametros.add(formateaFecha(fechaFacturacion));
               
               consulta1.append(" SELECT MAX (TRUNC (ihl.fec_fin_proc)) ");
               consulta1.append("   FROM cra_perio cp, int_histo_lotes ihl ");
               consulta1.append("  WHERE ihl.fec_fin_proc < cp.fec_inic  ");
               consulta1.append("    AND cp.oid_peri = ? ");
               parametros1.add(periodo);       
               consulta1.append("    AND ihl.pais_oid_pais = ? ");
               parametros1.add(pais);
               consulta1.append("    AND ihl.cod_inte LIKE ? ");
               parametros1.add(codigoInterfaz);
               
               BelcorpService bs = UtilidadesEJB.getBelcorpService();
               RecordSet rs = null;
               String codigoError = null;

               try {
                   rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
                   if (rs == null || rs.esVacio() || rs.getValueAt(0, 0) == null ) {
                     UtilidadesLog.info(" Query de Reproceso sin datos ejecutamos la segunda ");
                     rs = bs.dbService.executePreparedQuery(consulta1.toString(), parametros1);
                   }
            } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerUltimaFechaMenorFacturacion: Exception", e);
            this.logSql(" obtenerUltimaFechaMenorFacturacion. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        /*
        - con el registro obtenido se construye un objeto java.util.Date y se retorna.
        - si no se obtiene ningún registro, se retorna null.
        */

        java.util.Date fecha = null;

        if (rs != null) {
            if (!rs.esVacio()) {
                if (rs.getValueAt(0, 0) != null) {
                    fecha = new java.util.Date(((java.sql.Date) rs.getValueAt(0, 0)).getTime());
                }
            }
        } 

        UtilidadesLog.info("DAOINTDAT.obtenerUltimaFechaMenorFacturacion(Long pais, String codigoInterfaz, Long periodo, Date fechaFacturacion): Salida");

        return fecha;
    }

    /**
     * 09-07-2007     Agregado por Sapaza, incidencia SiCC-20070307. Se obtienes las regionces cerradas
     *                para un determinado periodo, con sus respectivas zonas
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param fecha
     * @param canal
     * @param marca
     * @param pais
     */
    public ArrayList obtenerRegionesCerradas(Long pais, Long marca, Long canal, Long periodo, String fecha) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerRegionesCerradas(Long pais, Long marca, Long canal, Long periodo, String fecha): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();
        
        consulta.append(" SELECT PCOR.COD_PERI ANIOCAMPANIA, ");
        consulta.append("        REG.COD_REGI CODIGOREGION, ");
        consulta.append("        ZON.COD_ZONA CODIGOZONA, ");
        consulta.append("        '0' FLAGIMPRESION, ");
        consulta.append("        '0' FLAGSTATUSFACTURACION ");
        consulta.append(" FROM  (SELECT FCC.PERD_OID_PERI, FCC.ZORG_OID_REGI, COUNT(FCC.OID_CTRL) NUM_PROC_CIER, MAX(FCC.FEC_ULTI_ACTU) FEC_ULTI_ACTU ");
        consulta.append("        FROM FAC_CONTR_CIERR FCC, FAC_TIPOS_CIERR FTC ");
        consulta.append("        WHERE FCC.PERD_OID_PERI = ? ");
        parametros.add(periodo);        
        consulta.append("          AND FCC.PAIS_OID_PAIS = ? ");
        parametros.add(pais);                
        consulta.append("          AND FCC.TCIE_OID_TIPO_CIER = FTC.OID_TIPO_CIER ");
        consulta.append("          AND FCC.VAL_RESU_PROC = 'OK' ");
        consulta.append("          AND FTC.COD_TIPO_CIER = ? ");
        parametros.add(ConstantesFAC.TIPO_CIERRE_REGION);                
        consulta.append("        GROUP BY FCC.PERD_OID_PERI,FCC.ZORG_OID_REGI) CIE_REG, ZON_ZONA ZON, ");
        consulta.append("        ZON_REGIO REG, CRA_PERIO CPER, SEG_PERIO_CORPO PCOR ");
        consulta.append("  WHERE CIE_REG.ZORG_OID_REGI = REG.OID_REGI ");
        consulta.append("    AND CIE_REG.PERD_OID_PERI = CPER.OID_PERI ");
        consulta.append("    AND CPER.PERI_OID_PERI = PCOR.OID_PERI ");
        consulta.append("    AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        consulta.append("    AND REG.PAIS_OID_PAIS = ? ");
        parametros.add(pais);        
        consulta.append("    AND REG.MARC_OID_MARC  = ? ");
        parametros.add(marca);
        consulta.append("    AND REG.CANA_OID_CANA = ? ");
        parametros.add(canal);
        consulta.append("    AND ZON.IND_ACTI = 1 ");
        consulta.append("    AND ZON.IND_BORR = 0 ");
        consulta.append("    AND CIE_REG.NUM_PROC_CIER = (SELECT COUNT(FP.OID_PROC_CIER) FROM FAC_PROCE_CIERR FP,FAC_TIPOS_CIERR FT ");
        consulta.append("                                 WHERE FP.TCIE_OID_TIPO_CIER = FT.OID_TIPO_CIER AND FT.COD_TIPO_CIER = ? ) ");
        parametros.add(ConstantesFAC.TIPO_CIERRE_REGION);                
        
        if (fecha != null) {
            consulta.append("    AND CIE_REG.FEC_ULTI_ACTU > TO_DATE (?,'YYYY-MM-DD HH24:MI:SS') ");
            parametros.add(fecha);
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerRegionesCerrados  : Exception", e);
            this.logSql(" obtenerRegionesCerrados  SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        // - con los registros obtenidos se construyen objetos de tipo DTOINTRegionCerrada y se retornan en una lista
        DTOINTRegionCerrada dto = null;

        if ((rs != null) && !rs.esVacio()) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                dto = new DTOINTRegionCerrada();

                if (rs.getValueAt(i, "ANIOCAMPANIA") != null) {
                    dto.setAnioCampania((String) rs.getValueAt(i, "ANIOCAMPANIA"));
                }

                if (rs.getValueAt(i, "CODIGOREGION") != null) {
                    dto.setCodigoRegion((String) rs.getValueAt(i, "CODIGOREGION"));
                }

                if (rs.getValueAt(i, "CODIGOZONA") != null) {
                    dto.setCodigoZona((String) rs.getValueAt(i, "CODIGOZONA"));
                }

                if (rs.getValueAt(i, "FLAGIMPRESION") != null) {
                    dto.setFlagImpresion((String) rs.getValueAt(i, "FLAGIMPRESION"));
                }

                if (rs.getValueAt(i, "FLAGSTATUSFACTURACION") != null) {
                    dto.setFlagStatusFacturacion((String) rs.getValueAt(i, "FLAGSTATUSFACTURACION"));
                }

                array.add(dto);
            } //for
        } else {    
            //en caso que no haya registros, se envia solo campaña facturacion con marca 'XXXXXX'
            UtilidadesLog.debug("-->Recordset vacio<--");
            dto = new DTOINTRegionCerrada();
            dto.setAnioCampania("XXXXXX");            
            array.add(dto);
        } //(rs!=null)

        UtilidadesLog.info("DAOINTDAT.obtenerRegionesCerradas(Long pais, Long marca, Long canal, Long periodo, String fecha): Salida");

        return array;
    }

    /**
     * 17-07-2007     Agregado por Sapaza, incidencia SiCC-20070323. Se obtiene informacion de hijas duplas
     *                con su correspondiente madre dupla
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param fecha
     * @param canal
     * @param marca
     * @param pais
     */
    public ArrayList obtenerMaestroHijasDuplas(Long pais, Long marca, Long canal, String fecha) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerMaestroHijasDuplas(Long pais, Long marca, Long canal, String fecha): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();
        
        consulta.append(" SELECT MC.COD_CLIE CODIGOCLIENTE, MAD_DUP.COD_CLIE CODIGOMADREDUPLA, ");
        consulta.append("        SUBSTR(TRIM(MC.VAL_APE1 || ' ' || MC.VAL_APE2) || ' ' || TRIM(MC.VAL_NOM1 || ' '|| MC.VAL_NOM2), 1, 45) NOMBRECOMPLETO, ");
        consulta.append("        SUBSTR(NVL(MC.VAL_APE1,''),1,15) APELLIDOPATERNO, ");
        consulta.append("        SUBSTR(NVL(MC.VAL_APE2,''),1,15) APELLIDOMATERNO, ");
        consulta.append("        TRIM(SUBSTR(MC.VAL_NOM1 || ' ' || MC.VAL_NOM2,1,15)) NOMBRE, ");
        consulta.append("        TO_CHAR(CA.FEC_NACI,'YYYYMMDD') FECHANACIMIENTO, ");
        consulta.append("        (SELECT C.VAL_TEXT_COMU ");
        consulta.append("         FROM MAE_CLIEN_COMUN C, MAE_TIPO_COMUN TC ");
        consulta.append("         WHERE C.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append("           AND C.TICM_OID_TIPO_COMU = TC.OID_TIPO_COMU ");
        consulta.append("           AND TC.COD_TIPO_COMU = ? ");
        parametros.add(ConstantesMAE.CODIGO_TIPO_COMUNICACION_EMAIL);        
        consulta.append("           AND ROWNUM = 1) EMAIL, ");
        consulta.append("        (SELECT C.VAL_TEXT_COMU ");
        consulta.append("         FROM MAE_CLIEN_COMUN C, MAE_TIPO_COMUN TC ");
        consulta.append("         WHERE C.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append("           AND C.TICM_OID_TIPO_COMU = TC.OID_TIPO_COMU ");
        consulta.append("           AND TC.COD_TIPO_COMU = ? ");
        parametros.add(ConstantesMAE.CODIGO_TIPO_COMUNICACION_TFNO);        
        consulta.append("           AND ROWNUM = 1) TELEFONOFIJO, ");
        consulta.append("        (SELECT C.VAL_TEXT_COMU ");
        consulta.append("         FROM MAE_CLIEN_COMUN C, MAE_TIPO_COMUN TC ");
        consulta.append("         WHERE C.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append("           AND C.TICM_OID_TIPO_COMU = TC.OID_TIPO_COMU ");
        consulta.append("           AND TC.COD_TIPO_COMU = ? ");
        parametros.add(ConstantesMAE.TIPO_COMUN_TMOVIL);        
        consulta.append("           AND ROWNUM = 1) TELEFONOMOVIL, ");
        consulta.append("        DECODE(NVL(CO.VAL_DIA_COMU,''),'L','1','M','1','I','1','J','1','V','1','S','1','D','1','0') INDICADORCONTACTADA, ");
        consulta.append("        DECODE(NVL(EC.COD_ESTA_CLIE,''),?,'1','0') ESTATUS, ");
        parametros.add(ConstantesMAE.ESTATUS_REGISTRADO);        
        consulta.append("        SUBSTR((SELECT MIN(TO_CHAR(P.FEC_INIC,'YYYYMMDD') || PC.COD_PERI) ");
        consulta.append("        FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
        consulta.append("        WHERE P.PAIS_OID_PAIS = ? ");
        parametros.add(pais);                
        consulta.append("          AND P.MARC_OID_MARC = ? ");
        parametros.add(marca);                
        consulta.append("          AND P.CANA_OID_CANA = ? ");  
        parametros.add(canal);                
        consulta.append("          AND P.PERI_OID_PERI = PC.OID_PERI ");        
        consulta.append("          AND P.FEC_INIC <= MC.FEC_INGR ");        
        consulta.append("          AND P.FEC_FINA >= MC.FEC_INGR),9) CAMPANIAINGRESO, ");        
        consulta.append("        TO_CHAR(MC.FEC_INGR,'YYYYMMDD') FECHAINGRESO, ");        
        consulta.append("        TO_CHAR(SYSDATE,'YYYYMMDD') FECHAULTIMAACTUALIZACION, ");        
        consulta.append("        DECODE(NVL(PC.COD_TIPO_CONT,''),'W','W','C') CODIGOCANALINGRESO, ");       
        //SB anhadiendo confimacion de datos de comunicacion PER-SiCC-2010-0002 Implementar nuevo atributo en Interfaces
         consulta.append("        NVL((SELECT DECODE(C.IND_CONF_COMU,'1','1','0') ");
         consulta.append("         FROM MAE_CLIEN_COMUN C, MAE_TIPO_COMUN TC ");
         consulta.append("         WHERE C.CLIE_OID_CLIE = MC.OID_CLIE ");
         consulta.append("           AND C.TICM_OID_TIPO_COMU = TC.OID_TIPO_COMU ");
         consulta.append("           AND TC.COD_TIPO_COMU = ? ");
         parametros.add(ConstantesMAE.CODIGO_TIPO_COMUNICACION_EMAIL);        
         consulta.append("           AND ROWNUM = 1),'0') INDICADORCONFIRMACION");
        consulta.append("  FROM  MAE_CLIEN MC, ");
        consulta.append("        MAE_CLIEN_TIPO_SUBTI CT, ");
        consulta.append("        MAE_TIPO_CLIEN TC, ");
        consulta.append("        MAE_SUBTI_CLIEN SC, ");
        consulta.append("        MAE_CLIEN_COMUN CO, ");
        consulta.append("        MAE_CLIEN_DATOS_ADICI CA, ");
        consulta.append("        MAE_CLIEN_VINCU CV, ");
        consulta.append("        MAE_TIPO_VINCU TV, ");
        consulta.append("        MAE_ESTAT_CLIEN EC, ");
        consulta.append("        MAE_CLIEN_PRIME_CONTA PC, ");
        consulta.append("        (SELECT OID_CLIE, COD_CLIE FROM MAE_CLIEN) MAD_DUP ");
        consulta.append("  WHERE MC.PAIS_OID_PAIS = ? ");
        parametros.add(pais);                        
        consulta.append("    AND MC.OID_CLIE = CT.CLIE_OID_CLIE ");
        consulta.append("    AND CT.TICL_OID_TIPO_CLIE = TC.OID_TIPO_CLIE ");
        consulta.append("    AND TC.COD_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA);                        
        consulta.append("    AND CT.SBTI_OID_SUBT_CLIE = SC.OID_SUBT_CLIE ");
        consulta.append("    AND SC.COD_SUBT_CLIE = ? ");
        parametros.add(ConstantesMAE.COD_SUBTIPO_CLIEN_HIJADUPLA);                        
        consulta.append("    AND MC.OID_CLIE = CA.CLIE_OID_CLIE(+) ");
        consulta.append("    AND MC.OID_CLIE = CO.CLIE_OID_CLIE(+) ");
        consulta.append("    AND CO.IND_COMU_PPAL(+) = 1 ");
        consulta.append("    AND MC.OID_CLIE = CV.CLIE_OID_CLIE_VNDO ");
        consulta.append("    AND CA.ESTA_OID_ESTA_CLIE = EC.OID_ESTA_CLIE(+) ");
        consulta.append("    AND MAD_DUP.OID_CLIE = CV.CLIE_OID_CLIE_VNTE ");        
        consulta.append("    AND CV.TIVC_OID_TIPO_VINC = TV.OID_TIPO_VINC ");
        consulta.append("    AND TV.COD_TIPO_VINC = ? ");        
        parametros.add(ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE);                        
        consulta.append("    AND MC.OID_CLIE = PC.CLIE_OID_CLIE(+) ");        
        consulta.append("    AND CV.FEC_HAST IS NULL "); //modificado por Sapaza, fecha 21-08-2007, cambio SiCC-20070389 
                
        if (fecha != null) {
            consulta.append("     AND ( ");
            consulta.append("           MC.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
            parametros.add( fecha );
            consulta.append("           CO.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
            parametros.add( fecha );
            consulta.append("           CA.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
            parametros.add( fecha );
            consulta.append("           PC.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
            parametros.add( fecha );
            consulta.append("           CT.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
            parametros.add( fecha );
            consulta.append("           CV.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ");
            parametros.add( fecha );
            consulta.append("         ) ");
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMaestroHijasDuplas  : Exception", e);
            this.logSql(" obtenerMaestroHijasDuplas  SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        // - con los registros obtenidos se construyen objetos de tipo DTOINTHijaDupla y se retornan en una lista
        DTOINTHijaDupla dto = null;

        if ((rs != null) && !rs.esVacio()) {
            int n = rs.getRowCount();

            for (int i = 0; i < n; i++) {
                dto = new DTOINTHijaDupla();

                if (rs.getValueAt(i, "CODIGOCLIENTE") != null) {
                    dto.setCodigoCliente((String) rs.getValueAt(i, "CODIGOCLIENTE"));
                }

                if (rs.getValueAt(i, "CODIGOMADREDUPLA") != null) {
                    dto.setCodigoMadreDupla((String) rs.getValueAt(i, "CODIGOMADREDUPLA"));
                }

                if (rs.getValueAt(i, "NOMBRECOMPLETO") != null) {
                    dto.setNombreCompleto((String) rs.getValueAt(i, "NOMBRECOMPLETO"));
                }

                if (rs.getValueAt(i, "APELLIDOPATERNO") != null) {
                    dto.setApellidoPaterno((String) rs.getValueAt(i, "APELLIDOPATERNO"));
                }

                if (rs.getValueAt(i, "APELLIDOMATERNO") != null) {
                    dto.setApellidoMaterno((String) rs.getValueAt(i, "APELLIDOMATERNO"));
                }

                if (rs.getValueAt(i, "NOMBRE") != null) {
                    dto.setNombre((String) rs.getValueAt(i, "NOMBRE"));
                }

                if (rs.getValueAt(i, "FECHANACIMIENTO") != null) {
                    dto.setFechaNacimiento((String) rs.getValueAt(i, "FECHANACIMIENTO"));
                }

                if (rs.getValueAt(i, "EMAIL") != null) {
                    dto.setEmail((String) rs.getValueAt(i, "EMAIL"));
                }

                if (rs.getValueAt(i, "TELEFONOFIJO") != null) {
                    dto.setTelefonoFijo((String) rs.getValueAt(i, "TELEFONOFIJO"));
                }

                if (rs.getValueAt(i, "TELEFONOMOVIL") != null) {
                    dto.setTelefonoMovil((String) rs.getValueAt(i, "TELEFONOMOVIL"));
                }

                if (rs.getValueAt(i, "INDICADORCONTACTADA") != null) {
                    dto.setIndicadorContactada((String) rs.getValueAt(i, "INDICADORCONTACTADA"));
                }

                if (rs.getValueAt(i, "ESTATUS") != null) {
                    dto.setEstatus((String) rs.getValueAt(i, "ESTATUS"));
                }

                if (rs.getValueAt(i, "CAMPANIAINGRESO") != null) {
                    dto.setCampaniaIngreso((String) rs.getValueAt(i, "CAMPANIAINGRESO"));
                }

                if (rs.getValueAt(i, "FECHAINGRESO") != null) {
                    dto.setFechaIngreso((String) rs.getValueAt(i, "FECHAINGRESO"));
                }

                if (rs.getValueAt(i, "FECHAULTIMAACTUALIZACION") != null) {
                    dto.setFechaUltimaActualizacion((String) rs.getValueAt(i, "FECHAULTIMAACTUALIZACION"));
                }

                if (rs.getValueAt(i, "CODIGOCANALINGRESO") != null) {
                    dto.setCodigoCanalIngreso((String) rs.getValueAt(i, "CODIGOCANALINGRESO"));
                }

        /// SB PER-SiCC-2010-0002 Implementar nuevo atributo en Interfaces CONFICOMUNICACION
                     dto.setIndicadorConfirmacion((String) rs.getValueAt(i, "INDICADORCONFIRMACION"));
                     
                array.add(dto);
            } //for
        } 
        
        UtilidadesLog.info("DAOINTDAT.obtenerMaestroHijasDuplas(Long pais, Long marca, Long canal, String fecha): Salida");

        return array;
    }
    
    /**
     * 18-09-2007       Agregado por Sapaza, cambio Sicc20070392. Para actualizar las consultoras
     *                  que han sido enviadas en las interfaces de capacitacion consultora y gerentes.
     * @throws es.indra.mare.common.exception.MareException
     * @param aptas
     */
    public void actualizarEnvioCursosDat(ArrayList aptas) throws MareException {
        UtilidadesLog.info("DAOINTDAT.actualizarEnvioCursosDat(ArrayList aptas): Entrada");
        
        int longi = aptas.size() - 1;
        int f = 0;
        int h = 0;        
        String aux = "";
        ArrayList sOids = new ArrayList();
        
        UtilidadesLog.debug("cantidad de registros a actualizar: " + aptas.size());

        while (f <= longi) { 
            while(f < longi && h < 500) {
                DTOINTAptaCurso dto =(DTOINTAptaCurso)aptas.get(f);

                aux = aux + dto.getOidAptaCurso().toString() + ", ";
                f++;
                h++;
            }
            
            if (f == longi) {
                DTOINTAptaCurso dto =(DTOINTAptaCurso)aptas.get(f);            
                aux = aux + dto.getOidAptaCurso().toString();
                f++;
            }
            else {
                aux = aux.substring(0, aux.length() - 2);
            }     
            
            sOids.add(aux);
            h = 0;
            aux = "";
        }        

        UtilidadesLog.debug("cantidad de bloques a actualizar: " + sOids.size());

        for (int m = 0; m < sOids.size(); m++) {
            StringBuffer update = new StringBuffer();
            Vector parametros = new Vector();
        
            update.append(" UPDATE EDU_APTAS_CURSO SET IND_ENVI=1 ");
            update.append(" WHERE  OID_APTA IN ( " + (String)sOids.get(m) + ") ");
            
            try{ 
                UtilidadesEJB.getBelcorpService().dbService.executePreparedUpdate( update.toString() , parametros ); 
            }catch (Exception e) { 
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
                UtilidadesLog.error("actualizarEnvioCursosDat: Exception",e); 
                throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
            }
        }
        
        UtilidadesLog.info("DAOINTDAT.actualizarEnvioCursosDat(ArrayList aptas): Salida");
    }
  
    /**
     * 23-11-2010       Agregado por DOliva, cambio PER-SiCC-2010-0658 Modificar Interfase de ventas para Ecuador.
     *                  Devuelve la cantidad de registros
     * @throws es.indra.mare.common.exception.MareException
     */
    public int obtenerCantidadEquivalencias() throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerCantidadEquivalencias(): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        consulta.append(" select 1                                      ");
        consulta.append("   from pre_matri_factu_cabec a,               ");
        consulta.append("        pre_ofert             b,               ");
        consulta.append("        pre_ofert_detal       c,               ");
        consulta.append("        pre_matri_factu       d,               ");
        consulta.append("        cra_perio             e,               ");
        consulta.append("        seg_perio_corpo       f,               ");
        consulta.append("        pre_ofert_detal       g,               ");
        consulta.append("        pre_matri_factu       h,               ");
        consulta.append("        pre_matri_codig_alter i,               ");
        consulta.append("        mae_produ             j,               ");
        consulta.append("        mae_produ             k,               ");
        consulta.append("        gen_i18n_sicc_pais    l,               ");
        consulta.append("        gen_i18n_sicc_pais    m,               ");
        consulta.append("        pre_tipo_ofert        t,               ");
        consulta.append("        pre_tipo_ofert        u,               ");
        consulta.append("        pre_prod_alter_ice    equi             ");
        consulta.append("  where a.OID_CABE = b.MFCA_OID_CABE           ");
        consulta.append("    and b.OID_OFER = c.OFER_OID_OFER           ");
        consulta.append("    and c.OID_DETA_OFER = d.OFDE_OID_DETA_OFER ");
        consulta.append("    and a.PERD_OID_PERI = e.OID_PERI           ");
        consulta.append("    and i.MAFA_OID_COD_PPAL = d.OID_MATR_FACT  ");
        consulta.append("    and i.MAFA_OID_COD_ALTE = h.OID_MATR_FACT  ");
        consulta.append("    and h.OFDE_OID_DETA_OFER = g.OID_DETA_OFER ");
        consulta.append("    and f.OID_PERI = e.PERI_OID_PERI           ");
        consulta.append("    and c.PROD_OID_PROD = j.OID_PROD           ");
        consulta.append("    and j.OID_PROD = l.VAL_OID                 ");
        consulta.append("    and l.ATTR_ENTI = 'MAE_PRODU'              ");
        consulta.append("    and g.PROD_OID_PROD = k.OID_PROD           ");
        consulta.append("    and k.OID_PROD = m.VAL_OID                 ");
        consulta.append("    and m.ATTR_ENTI = 'MAE_PRODU'              ");
        consulta.append("    and g.tofe_oid_tipo_ofer = t.oid_tipo_ofer ");
        consulta.append("    and c.tofe_oid_tipo_ofer = u.oid_tipo_ofer ");
        consulta.append("    and j.COD_SAP = equi.COD_SAP_PPAL          ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerCantidadEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {
            return rs.getRowCount();            
        }

        UtilidadesLog.info("DAOINTDAT.obtenerCantidadEquivalencias(): Salida");

        return 0;
    }
    
    /**
     * 24-11-2010       Agregado por DOliva, cambio PER-SiCC-2010-0658 Modificar Interfase de ventas para Ecuador.
     *                  Limpia la tabla e inserta los valores a la tabla temporal que se utilizara en el proceso
     *                  de reemplazo de equivalencias
     * @throws es.indra.mare.common.exception.MareException
     */    
    public void cargarTemporalTransaccionesClientePerf(String oids) throws MareException { 
        UtilidadesLog.info("DAOINTDAT.cargarTemporalTransaccionesClientePerf(): Entrada");

        StringBuffer consulta = new StringBuffer(); 
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        
        // Limpia tabla temporal
        try {
            UtilidadesLog.info("borrar");        
            bs.dbService.executeUpdate("DELETE TMP_TRANS_CLIEN_PERFI");
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
                        
        //Inserta el resultado del select
        consulta.append(" insert into TMP_TRANS_CLIEN_PERFI ");
        consulta.append(" (cod_clie, cod_acce, cod_terr, val_nume_soli, fec_fact, val_peri_docu, cod_peri, ind_devo, ind_anul, cod_sap, val_codi_vent, cod_tipo_ofer, num_unid_aten, num_unid_noat, ");
        consulta.append(" num_unid_devu, num_unid_anul, val_prec_unit_loca, val_prec_tota_loca, val_prec_fact_unit_loca, val_prec_fact_tota_loca, val_prec_cata_unit_loca, cod_cana, val_mont_falt, ");
        consulta.append(" num_unid_reto, num_unid_atec, val_mont_neto_reto, val_mont_neto_aten, val_mont_neto_vent, val_mont_neto_devo, val_mont_neto_anul ) ");
        consulta.append(" (SELECT MC.COD_CLIE                                   CODIGOCLIENTE,  ");
        consulta.append("        SOC.COD_ACCE                                  CODIGOACCESO,  ");
        consulta.append("        SOC.COD_TERR                                  CODIGOTERRITORIO,  ");
        consulta.append("        (CASE WHEN soc2.soca_oid_docu_refe is not null  THEN SCREF.val_nume_soli ELSE soc.val_nume_soli END) NUMEROSOLICITUD, ");
        consulta.append("        MAX(SOC.FEC_FACT)                                  FECHAFACTURACION,  ");
        consulta.append("        SOC.VAL_PERI_DOCU                             PERIODODOCUMENTO,  ");
        consulta.append("        (CASE WHEN soc2.soca_oid_docu_refe is not null   THEN PC.COD_PERI ELSE NULL END)  PERIODODOCUMENTOREFERENCIA, ");
        consulta.append("        DECODE (MAX(TS.IND_DEVO), 1, 'true', 0, 'false')     INDICADORDEVOLUCIONES,  ");
        consulta.append("        DECODE (MAX(TS.IND_ANUL), 1, 'true', 0, 'false')     INDICADORANULACIONES,  ");
        consulta.append("        PRO.COD_SAP                                   CODIGOPRODUCTO,  ");
        consulta.append("        POS.VAL_CODI_VENT                             CODIGOVENTA,  ");
        consulta.append("        TOF.COD_TIPO_OFER                             TIPOOFERTA,  ");
        consulta.append("        SUM(  ");
        consulta.append("           CASE WHEN PTS.NUM_UNID_VEND = 1 OR PTS.NUM_UNID_VEND_OTRO = 1 ");
        consulta.append("           THEN ABS(NVL (POS.NUM_UNID_ATEN, 0))  ");
        consulta.append("           ELSE 0 END");
        consulta.append("        ) UNIDADESATENDIDAS,  ");
        consulta.append("        SUM(  ");
        consulta.append("           CASE WHEN PTS.NUM_UNID_FALT = 1 OR PTS.NUM_UNID_FALT_OTRO = 1 ");
        consulta.append("           THEN (POS.NUM_UNID_DEMA_REAL - POS.NUM_UNID_COMPR)  ");
        consulta.append("           ELSE 0 END");
        consulta.append("        ) UNIDADESNOATENDIDAS,  ");
        consulta.append("        SUM (ABS (case when pts.num_unid_devu = 1  then (NVL (POS.NUM_UNID_ATEN, 0)) else 0 end)) UNIDADESDEVUELTAS,  ");        
        consulta.append("        SUM (ABS (case when pts.num_unid_anul = 1  then (NVL (POS.NUM_UNID_ATEN, 0)) else 0 end)) UNIDADESANULADAS,  ");        
        consulta.append("        SUM (ABS(NVL (POS.VAL_PREC_NETO_UNIT_LOCA, 0))) PRECIONETOUNITARIOLOCAL, ");
        consulta.append("        SUM(ABS(NVL (POS.VAL_PREC_NETO_TOTA_LOCA, 0))) PRECIONETOTOTALLOCAL, ");
        consulta.append("        ABS (NVL (SUM(POS.VAL_PREC_FACT_UNIT_LOCA), 0))     PRECIOFACTURAUNITARIOLOCAL,  ");
        // vbongiov -- Cambio 20080763 -- 16/10/2008
        
         consulta.append("  SUM (ABS (CASE   ");
         consulta.append("             WHEN pts.num_unid_vend = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN  ");
         consulta.append("                 pos.val_prec_fact_tota_loca  ");
         consulta.append("             ELSE 0 END))       PRECIOFACTURATOTALLOCAL, "); 
        
        consulta.append("        ABS (NVL (SUM(POS.VAL_PREC_CATA_UNIT_LOCA), 0))     PRECIOCATALOGOUNITARIOLOCAL,  ");
        consulta.append("        SOC.COD_CANA                                  CODIGOCANAL,  ");
        
        // sapaza -- PER-SiCC-2011-0239 -- 31/03/2011
        consulta.append(" SUM(CASE WHEN PTS.NUM_UNID_VEND = 1 OR PTS.NUM_UNID_VEND_OTRO = 1 THEN " +
              " decode(pos.val_prec_cata_unit_loca,0,0,((pos.num_unid_dema_real-pos.num_unid_compr)*pos.val_prec_neto_unit_loca))");     
        consulta.append("  ELSE 0 END ) MONTO_FALTANTE, ");
        
        consulta.append(" SUM (ABS (CASE ");               
        consulta.append("       WHEN pts.num_unid_canj = 1 THEN (NVL (pos.num_unid_aten, 0))   ");               
        consulta.append("       ELSE 0 ");               
        consulta.append("           END)) UNIDADESRETORNO, ");               
        consulta.append(" SUM (ABS (CASE ");               
        consulta.append("       WHEN pts.num_unid_true = 1 THEN (NVL (pos.num_unid_aten, 0))   ");               
        consulta.append("       ELSE 0 ");               
        consulta.append("           END)) UNIDADESATENCION, ");               
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_canj = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETORETORNO, ");               
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_true = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETOATENCION, ");                              
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_vend = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETOVENTA, ");                              
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_devu = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETODEVOLUCION, ");                              
        consulta.append(" SUM (ABS (CASE  ");               
        consulta.append("       WHEN pts.num_unid_anul = 1 AND pos.val_prec_cata_unit_loca <> 0 THEN ");               
        consulta.append("            pos.VAL_PREC_NETO_TOTA_LOCA ");               
        consulta.append("       ELSE 0 ");               
        consulta.append(" END)) MONTONETOANULACION ");                              
        
        consulta.append("   FROM INT_DAT_SOLIC   SOC,  ");
        consulta.append("        PED_SOLIC_POSIC POS,  ");
        consulta.append("        (SELECT A.CLIE_OID_CLIE, A.OID_SOLI_CABE, A.TSPA_OID_TIPO_SOLI_PAIS, A.SOCA_OID_SOLI_CABE, A.MODU_OID_MODU, A.SOCA_OID_DOCU_REFE ");
        consulta.append("           FROM PED_SOLIC_CABEC A) SOC2,  ");
        consulta.append("        PED_TIPO_SOLIC_PAIS TSP,  ");
        consulta.append("        PED_TIPO_SOLIC TS,  ");
        consulta.append("        (SELECT C.OID_CLIE, C.COD_CLIE FROM MAE_CLIEN C) MC,  ");
        consulta.append("        MAE_PRODU PRO,  ");
        consulta.append("        PRE_OFERT_DETAL OFD,  ");
        consulta.append("        PRE_TIPO_OFERT TOF,  ");
        consulta.append("        (SELECT OID_SOLI_CABE, PERD_OID_PERI, val_nume_soli FROM PED_SOLIC_CABEC) SCREF,  ");        
        consulta.append("        CRA_PERIO PE,  ");                
        consulta.append("        SEG_PERIO_CORPO PC  ");                        
        consulta.append("      , INT_PARAM_TIPO_SOLIC PTS ");
        consulta.append("  WHERE POS.SOCA_OID_SOLI_CABE       = SOC.SOCA_OID_SOLI_CABE  ");
        consulta.append("    AND SOC2.CLIE_OID_CLIE           = MC.OID_CLIE  ");
        consulta.append("    AND SOC2.OID_SOLI_CABE           = SOC.SOCA_OID_SOLI_CABE  ");
        consulta.append("    AND SOC2.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS  ");
        consulta.append("    AND TSP.TSOL_OID_TIPO_SOLI       = TS.OID_TIPO_SOLI  ");
        consulta.append("    AND POS.OFDE_OID_DETA_OFER       = OFD.OID_DETA_OFER             (+)  ");
        consulta.append("    AND OFD.PROD_OID_PROD            = PRO.OID_PROD                  (+)  ");
        consulta.append("    AND OFD.TOFE_OID_TIPO_OFER       = TOF.OID_TIPO_OFER             (+)  ");
        consulta.append("    AND POS.ESPO_OID_ESTA_POSI      <> " + ConstantesPED.ESTADO_POSICION_ANULADO); 
        consulta.append("    AND SOC.SOCA_OID_SOLI_CABE IN (" + oids+ ")  ");
        
        /*consulta.append("    AND (   (TS.IND_DEVO = 0 AND TS.IND_ANUL=0) "); 
        consulta.append("         OR (FN_DAT_VALIDAR_PROD_SOLI_DEVO (SOC2.OID_SOLI_CABE, POS.OID_SOLI_POSI) > 0)) "); */
         consulta.append("    AND (  ");
         consulta.append("         (pts.num_unid_vend = 1 AND ts.ind_anul = 0 AND ts.ind_devo = 0)     ");
         consulta.append("           OR  ");
         consulta.append("         (pts.num_unid_falt = 1 AND ts.ind_anul = 0 AND ts.ind_devo = 0 )   ");
         consulta.append("           OR  ");
         consulta.append("         (pts.num_unid_devu = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
         consulta.append("           OR  ");
         consulta.append("         (pts.num_unid_anul = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
         consulta.append("           OR  ");
         consulta.append("         (pts.num_unid_canj = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
         consulta.append("           OR  ");
         consulta.append("         (pts.num_unid_true = 1 AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc2.oid_soli_cabe, pos.oid_soli_posi)>0 )   "); 
         consulta.append("        )  ");
         
        consulta.append("    AND SOC2.SOCA_OID_DOCU_REFE = SCREF.OID_SOLI_CABE(+)  ");
        consulta.append("    AND SCREF.PERD_OID_PERI = PE.OID_PERI(+)  ");
        consulta.append("    AND PE.PERI_OID_PERI = PC.OID_PERI(+)  ");        
        consulta.append("    AND PTS.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        consulta.append(" GROUP BY  "); 
        consulta.append("  SOC.VAL_PERI_DOCU,  ");
        consulta.append("  SOC.COD_ACCE,  ");        
        consulta.append("  (CASE WHEN soc2.soca_oid_docu_refe is not null  THEN SCREF.val_nume_soli ELSE soc.val_nume_soli END), ");        
        consulta.append("  soc.COD_CANA,  ");
        consulta.append("  (CASE WHEN soc2.soca_oid_docu_refe is not null  THEN PC.COD_PERI ELSE NULL END),  ");        
        consulta.append("  PRO.COD_SAP,  ");
        consulta.append("  SOC.COD_TERR,  ");
        consulta.append("  MC.COD_CLIE,  ");
        consulta.append("  TOF.COD_TIPO_OFER,  ");
        consulta.append("  POS.VAL_CODI_VENT  ");
        //consulta.append(", PTS.OID_PARA_TIPO_SOLI ");
        consulta.append(", PTS.NUM_UNID_VEND_OTRO ");
        consulta.append(", PTS.NUM_UNID_FALT_OTRO )");

        //BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        
         String codigoError = null; 
        try{ 
            bs.dbService.executeUpdate(consulta.toString()); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("obtenerTransaccionesClientePerf: Exception",e); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
                
        // Traza de salida 
        UtilidadesLog.info("DAOINTDAT.cargarTemporalTransaccionesClientePerf(): Salida"); 
        
    }
  
    /**
     * 24-11-2010       Agregado por DOliva, cambio PER-SiCC-2010-0658 Modificar Interfase de ventas para Ecuador.
     *                  Ejecuta el proceso de reemplazo de equivalencias
     *                  
     * 03-03-2011       Agregado por Sapaza, cambio PER-SiCC-2011-0148
     *                  
     * @throws es.indra.mare.common.exception.MareException
     */    
    public void ejecutarProcesoEquivalencia(Long oidPais) throws MareException { 
        UtilidadesLog.info("DAOINTDAT.ejecutarProcesoEquivalencia(Long oidPais): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        java.sql.Connection connection = null;
        java.sql.CallableStatement pstmt = null;
        try {
             connection = bs.dbService.getConnection();
             bs.dbService.executeProcedure("DAT_EJEC_EQUI", oidPais.toString());
             /*
             pstmt = connection.prepareCall("{call DAT_EJEC_EQUI()}");                
             pstmt.executeUpdate();
             if (pstmt != null){
                 pstmt.close();
            }
            */
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" ejecutarProcesoEquivalencia  : Exception", e);            
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } finally{
           if (connection != null){
                try {connection.close();}catch (Exception e) {;}
           }
        }
        // Traza de salida 
        UtilidadesLog.info("DAOINTDAT.ejecutarProcesoEquivalencia(Long oidPais): Salida"); 
        
    }
  
    /**
     * 24-11-2010       Agregado por DOliva, cambio PER-SiCC-2010-0658 Modificar Interfase de ventas para Ecuador.
     *                  Obtiene el listado, luego de haber ejecutado el proceso de equivalencias
     * @throws es.indra.mare.common.exception.MareException
     */ 
    public ArrayList obtenerEquivalenciaTransaccionesClientePerf() throws MareException { 
        UtilidadesLog.info("DAOINTDAT.obtenerEquivalenciaTransaccionesClientePerf(): Entrada");
        
        StringBuffer consulta = new StringBuffer(); 
        
        consulta.append(" select cod_clie                       CODIGOCLIENTE              ,");
        consulta.append("        cod_acce                       CODIGOACCESO               ,");
        consulta.append("        cod_terr                       CODIGOTERRITORIO           ,");
        consulta.append("        val_nume_soli                  NUMEROSOLICITUD            ,");     
        consulta.append("        fec_fact                       FECHAFACTURACION           ,");
        consulta.append("        val_peri_docu                  PERIODODOCUMENTO           ,");     
        consulta.append("        cod_peri                       PERIODODOCUMENTOREFERENCIA ,");
        consulta.append("        ind_devo                       INDICADORDEVOLUCIONES      ,"); 
        consulta.append("        ind_anul                       INDICADORANULACIONES       ,"); 
        consulta.append("        cod_sap                        CODIGOPRODUCTO             ,");  
        consulta.append("        val_codi_vent                  CODIGOVENTA                ,");      
        consulta.append("        cod_tipo_ofer                  TIPOOFERTA                 ,");     
        consulta.append("        SUM(num_unid_aten)             UNIDADESATENDIDAS          ,");  
        consulta.append("        SUM(num_unid_noat)             UNIDADESNOATENDIDAS        ,");  
        consulta.append("        SUM(num_unid_devu)             UNIDADESDEVUELTAS          ,");  
        consulta.append("        SUM(num_unid_anul)             UNIDADESANULADAS           ,");  
        consulta.append("        SUM(val_prec_unit_loca)        PRECIONETOUNITARIOLOCAL    ,");           
        consulta.append("        SUM(val_prec_tota_loca)        PRECIONETOTOTALLOCAL       ,");    
        consulta.append("        SUM(val_prec_fact_unit_loca)   PRECIOFACTURAUNITARIOLOCAL ,");          
        consulta.append("        SUM(val_prec_fact_tota_loca)   PRECIOFACTURATOTALLOCAL    ,");           
        consulta.append("        SUM(val_prec_cata_unit_loca)   PRECIOCATALOGOUNITARIOLOCAL,");           
        consulta.append("        cod_cana                       CODIGOCANAL                ,");
        consulta.append("        SUM(val_mont_falt)             MONTO_FALTANTE             ,"); // sapaza -- PER-SiCC-2011-0239 -- 31/03/2011
        consulta.append("        SUM(num_unid_reto)             UNIDADESRETORNO          ,");  
        consulta.append("        SUM(num_unid_atec)             UNIDADESATENCION         , ");  
        consulta.append("        SUM(val_mont_neto_reto)        MONTONETORETORNO         , ");  
        consulta.append("        SUM(val_mont_neto_aten)        MONTONETOATENCION        ,  ");  
        consulta.append("        SUM(val_mont_neto_vent)        MONTONETOVENTA           , ");  
        consulta.append("        SUM(val_mont_neto_devo)        MONTONETODEVOLUCION      ,  ");  
        consulta.append("        SUM(val_mont_neto_anul)        MONTONETOANULACION          ");  
        
        consulta.append("   from TMP_TRANS_CLIEN_PERFI                                      ");
        consulta.append("    group by val_peri_docu,                                        ");
        consulta.append("             cod_cana,                                             ");
        consulta.append("             cod_acce,                                             ");
        consulta.append("             cod_sap,                                              ");
        consulta.append("             cod_terr,                                             ");
        consulta.append("             cod_clie,                                             ");
        consulta.append("             cod_tipo_ofer,                                        ");
        consulta.append("             val_nume_soli,                                        ");
        consulta.append("             val_codi_vent,                                        ");
        consulta.append("             cod_peri,                                             ");
        consulta.append("             fec_fact,                                             ");
        consulta.append("             ind_devo,                                             ");
        consulta.append("             ind_anul                                              ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
            rs =bs.dbService.executeStaticQuery(consulta.toString()); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("obtenerTransaccionesClientePerf: Exception",e); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }//catch 
        
        ArrayList lista = new ArrayList(); 
        
        // Rellenamos el ArrayList con objetos 'DTOINTTxCliente' 
        if(rs != null){ 
            int x = rs.getRowCount(); 
            for(int i = 0; i < x; i++){ 
                DTOINTTxCliente dto = new DTOINTTxCliente(); 

                    if(rs.getValueAt(i,"CODIGOCLIENTE") != null){                 
                        dto.setCodigoCliente(rs.getValueAt(i,"CODIGOCLIENTE").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOACCESO") != null){ 
                        dto.setCodigoAcceso(rs.getValueAt(i,"CODIGOACCESO").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOTERRITORIO") != null){ 
                        dto.setCodigoTerritorio(new Long(rs.getValueAt(i,"CODIGOTERRITORIO").toString())); 
                    } 
                    if(rs.getValueAt(i,"NUMEROSOLICITUD") != null){ 
                        dto.setNumeroSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROSOLICITUD")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"FECHAFACTURACION") != null){ 
                        dto.setFechaFacturacion(new Date(((java.sql.Date)rs.getValueAt(i,"FECHAFACTURACION")).getTime())); 
                    } 
                    if(rs.getValueAt(i,"PERIODODOCUMENTO") != null){ 
                        dto.setPeriodoDocumento(rs.getValueAt(i,"PERIODODOCUMENTO").toString()); 
                    } 
                    if(rs.getValueAt(i,"PERIODODOCUMENTOREFERENCIA") != null){ 
                        dto.setPeriodoDocumentoReferencia(rs.getValueAt(i,"PERIODODOCUMENTOREFERENCIA").toString()); 
                    } 
                    /*if(rs.getValueAt(i,"TIPOSOLICITUD") != null){ 
                        dto.setTipoSolicitud(rs.getValueAt(i,"TIPOSOLICITUD").toString()); 
                    }*/ 
                    if(rs.getValueAt(i,"INDICADORDEVOLUCIONES") != null){ 
                        if ((rs.getValueAt(i,"INDICADORDEVOLUCIONES").toString()).equals("false")){ 
                            dto.setIndicadorDevoluciones(Boolean.FALSE); 
                        }else{ 
                            dto.setIndicadorDevoluciones(Boolean.TRUE); 
                        } 
                    } 
                    if(rs.getValueAt(i,"INDICADORANULACIONES") != null){ 
                        if ((rs.getValueAt(i,"INDICADORANULACIONES").toString()).equals("false")){ 
                            dto.setIndicadorAnulaciones(Boolean.FALSE); 
                        }else{ 
                            dto.setIndicadorAnulaciones(Boolean.TRUE); 
                        } 
                    } 
                    if(rs.getValueAt(i,"CODIGOPRODUCTO") != null){                 
                        dto.setCodigoProducto(rs.getValueAt(i,"CODIGOPRODUCTO").toString()); 
                    } 
                    if(rs.getValueAt(i,"CODIGOVENTA") != null){                 
                        dto.setCodigoVenta(rs.getValueAt(i,"CODIGOVENTA").toString()); 
                    } 
                    if(rs.getValueAt(i,"TIPOOFERTA") != null){                 
                        dto.setTipoOferta(rs.getValueAt(i,"TIPOOFERTA").toString()); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESATENDIDAS") != null){ 
                        dto.setUnidadesAtendidas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESATENDIDAS")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESNOATENDIDAS") != null){ 
                        dto.setUnidadesNoAtendidas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESNOATENDIDAS")).longValue())); 
                    } 

                    //<inicio> Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147                    
                    if(rs.getValueAt(i,"UNIDADESDEVUELTAS") != null){ 
                        dto.setUnidadesDevueltas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESDEVUELTAS")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESANULADAS") != null){ 
                        dto.setUnidadesAnuladas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESANULADAS")).longValue())); 
                    } 
                    //<fin> Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147

                    if(rs.getValueAt(i,"PRECIONETOUNITARIOLOCAL") != null){ 
                        dto.setPrecioNetoUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIONETOUNITARIOLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIONETOTOTALLOCAL") != null){ 
                        dto.setPrecioNetoTotalLocal((BigDecimal)rs.getValueAt(i,"PRECIONETOTOTALLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIOFACTURAUNITARIOLOCAL") != null){ 
                        dto.setPrecioFacturaUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIOFACTURAUNITARIOLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"PRECIOFACTURATOTALLOCAL") != null){ 
                        dto.setPrecioFacturaTotalLocal((BigDecimal)rs.getValueAt(i,"PRECIOFACTURATOTALLOCAL")); 
                    } 
                    if(rs.getValueAt(i,"CODIGOCANAL") != null){ 
                        dto.setCodigoCanal(rs.getValueAt(i,"CODIGOCANAL").toString()); 
                    } 
                    //  Agregado por HRCS - Fecha 21/03/2007 - Cambio Sicc20070147
                    if (rs.getValueAt(i,"PRECIOCATALOGOUNITARIOLOCAL") != null)   {
                        dto.setPrecioCatalogoUnitarioLocal((BigDecimal)rs.getValueAt(i,"PRECIOCATALOGOUNITARIOLOCAL"));
                    }
                    
                    // sapaza -- PER-SiCC-2011-0239 -- 31/03/2011
                    if (rs.getValueAt(i,"MONTO_FALTANTE") != null)   {
                        dto.setMontoFaltante((BigDecimal)rs.getValueAt(i,"MONTO_FALTANTE"));
                    }
                    
                    //<inicio> Agregado por Sapaza - Fecha 01/09/2011 - RCR PER-SiCC-2011-0566                    
                    if(rs.getValueAt(i,"UNIDADESRETORNO") != null){ 
                        dto.setUnidadesRetorno(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESRETORNO")).longValue())); 
                    } 
                    if(rs.getValueAt(i,"UNIDADESATENCION") != null){ 
                        dto.setUnidadesAtencion(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESATENCION")).longValue())); 
                    } 
                    if (rs.getValueAt(i,"MONTONETORETORNO") != null)   {
                        dto.setMontoNetoRetorno((BigDecimal)rs.getValueAt(i,"MONTONETORETORNO"));
                    }
                    if (rs.getValueAt(i,"MONTONETOATENCION") != null)   {
                        dto.setMontoNetoAtencion((BigDecimal)rs.getValueAt(i,"MONTONETOATENCION"));
                    }
                    if (rs.getValueAt(i,"MONTONETOVENTA") != null)   {
                        dto.setMontoNetoVenta((BigDecimal)rs.getValueAt(i,"MONTONETOVENTA"));
                    }
                    if (rs.getValueAt(i,"MONTONETODEVOLUCION") != null)   {
                        dto.setMontoNetoDevolucion((BigDecimal)rs.getValueAt(i,"MONTONETODEVOLUCION"));
                    }
                    if (rs.getValueAt(i,"MONTONETOANULACION") != null)   {
                        dto.setMontoNetoAnulacion((BigDecimal)rs.getValueAt(i,"MONTONETOANULACION"));
                    }
                    //<fin> Agregado por Sapaza - Fecha 01/09/2011 - RCR PER-SiCC-2011-0566
                    
                    lista.add(dto); 
                } 
            } 
        // Traza de salida 
        UtilidadesLog.info("DAOINTDAT.obtenerEquivalenciaTransaccionesClientePerf(): Salida"); 
        return lista; 
    }
  
    /**
     * 19-01-2011       Agregado por DOliva, cambio RCR PER-SiCC-2011-0044 ajuste de equivalencias con uso de indicador.
     *                  Devuelve el indicador de ejecucion de equivalencias
     * @throws es.indra.mare.common.exception.MareException
     */
    public String obtenerIndicadorEquivalencias(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorEquivalencias(Long oidPais): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append(" select nvl(bp.ind_equi,'0')      ");
        consulta.append("   from bas_pais bp, seg_pais sp  ");
        consulta.append("  where sp.cod_pais = bp.cod_pais ");
        consulta.append("    and sp.oid_pais =  ?          ");
        
        parametros.add(oidPais);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorEquivalencias(Long oidPais): Salida");

        return "0";
    }
    
    /**
     * 30-06-2011       Agregado por SBuchelli, cambio PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS.
     *                  Devuelve el codigo Periodo Facturacion
     * @throws es.indra.mare.common.exception.MareException
     */
    public String obtenerCodigoPeriodo(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerCodigoPeriodo(Long oidPeriodo): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append("  SELECT A.COD_PERI      ");
        consulta.append("  FROM SEG_PERIO_CORPO A,CRA_PERIO B,SEG_CANAL C, SEG_MARCA D  ");
        consulta.append("  WHERE A.OID_PERI = B.PERI_OID_PERI ");
        consulta.append("   AND B.OID_PERI = ?          ");
        consulta.append("   AND B.CANA_OID_CANA = C.OID_CANA ");
        consulta.append("   AND B.MARC_OID_MARC = D.OID_MARC ");
        consulta.append("   AND C.COD_CANA = 'VD' ");
        consulta.append("   AND D.COD_MARC = 'T' ");
        
        
        parametros.add(oidPeriodo);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerCodigoPeriodo: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerCodigoPeriodo(Long oidPeriodo): Salida");

        return "";
    }
    
    
    /**
     * 30-06-2011       Agregado por SBuchelli, cambio PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS.
     *                  Devuelve el codigo Periodo Facturacion
     * @throws es.indra.mare.common.exception.MareException
     */
    public Long obtenerNPeriodo(String codPeriodo,Long oidPais,Integer ncampanha) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerNPeriodo(String codPeriodo,Long oidPais,int ncampanha): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append("  SELECT GEN_PKG_GENER.GEN_FN_DEVUELVE_ID_CRA_PERIO2(   ");
        consulta.append("    PER_PKG_REPOR_PERCE.PER_FN_OBTIE_PERIO(?,  ");
        consulta.append("  ?, ");
        consulta.append("   GEN_PKG_GENER.GEN_FN_DEVUELVE_ID_MARCA('T'),");
        consulta.append("   GEN_PKG_GENER.GEN_FN_DEVUELVE_ID_CANAL('VD'), ");
        consulta.append("  ? )) ");
        consulta.append("   FROM DUAL ");        
        
        parametros.add(codPeriodo);
        parametros.add(oidPais);
        parametros.add(ncampanha);


        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerNPeriodo: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return ((BigDecimal)rs.getValueAt(0,0)).longValue();        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerNPeriodo(String codPeriodo,Long oidPais,int ncampanha): Salida");

        return null;
    }
    
    
    /**
     * 30-06-2011       Agregado por SBuchelli, cambio PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS.
     *                  Devuelve el codigo Periodo Facturacion
     * @throws es.indra.mare.common.exception.MareException
     */
    public Long obtenerIndicadorCruce(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorCruce(Long oidPeriodo): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append("  SELECT IND_PERI_CRUC   ");
        consulta.append("   FROM CRA_PERIO  ");
        consulta.append("  WHERE OID_PERI =? ");
        
        parametros.add(oidPeriodo);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorCruce: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return ((BigDecimal)rs.getValueAt(0,0)).longValue();        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorCruce(Long oidPeriodo): Salida");

        return new Long(0);
    }
    
} //clase
  