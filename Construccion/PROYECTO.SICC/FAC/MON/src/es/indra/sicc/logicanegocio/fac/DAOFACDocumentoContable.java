/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOFACDocumentoSubacceso;
import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.fac.DTOFACAcumuladoImpuestos;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;

import es.indra.sicc.util.UtilidadesBD;

import java.math.BigDecimal;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;

import java.text.SimpleDateFormat;


public class DAOFACDocumentoContable {

    private String usuario = null; //ver incidencia 9003

    public DAOFACDocumentoContable(String usuario) {
        this.usuario = usuario; //ver incidencia 9003
    }

    public DTOFACDocumentoSubacceso obtenerDatosDocumento(Long pais,
        Long canal, Long acceso, Long subacceso, Long sociedad,
        Long tipoDocumentoLegal) throws MareException {
        
        UtilidadesLog.info("DAOFACDocumentoContable.obtenerDatosDocumento(Long pais, Long canal, Long acceso, Long subacceso, Long sociedad, Long tipoDocumentoLegal): Entrada");

        // Accede a BD para obtener información correspondiente a un documento legal 
        StringBuffer consulta = new StringBuffer("");
        Vector parametros = new Vector();

        consulta.append(" SELECT DSA.OID_DOCU_SUBA AS OID ");
        consulta.append(", DSA.SOCI_OID_SOCI AS OIDSOCIEDAD ");
        consulta.append(", DSA.SBAC_OID_SBAC AS OIDSUBACCESO ");
        consulta.append(", DSA.TIDO_OID_TIPO_DOCU AS TIPODOCUMENTO ");
        consulta.append(", DSA.VAL_SERI_DOCU_LEGA AS SERIEDOCUMENTOLEGAL ");
        consulta.append(
            ", DSA.VAL_ULTI_NUME_DOCU_LEGA AS ULTIMONUMERODOCUMENTOLEGAL ");
        consulta.append(
            ", DSA.VAL_LIMI_NUME_DOCU_LEGA AS LIMITENUMERODOCUMENTOLEGAL ");
        consulta.append(
            ", DSA.VAL_ULTI_EJER_DOCU_INTE AS ULTIMOEJERCICIODOCUMENTOINTERN "); //Debido a que el identificador habra que cambiarlo ya que es demasiado largo
        consulta.append(
            ", DSA.VAL_ULTI_NUME_DOCU_INTE AS ULTIMONUMERODOCUMENTOINTERNO ");
        consulta.append(" FROM FAC_DOCUM_SUBAC DSA ");
        consulta.append(" , SEG_SOCIE SO ");
        consulta.append(" , SEG_PAIS PA ");//ver incidencia 9003
        consulta.append(" , SEG_SUBAC SA ");
        consulta.append(" , SEG_ACCES AC ");
        consulta.append(" , SEG_CANAL CA ");//ver incidencia 9003
        consulta.append(" WHERE DSA.SOCI_OID_SOCI = SO.OID_SOCI ");
        consulta.append(" AND SO.PAIS_OID_PAIS = PA.OID_PAIS ");
        consulta.append(" AND DSA.SBAC_OID_SBAC = SA.OID_SBAC ");
        consulta.append(" AND SA.ACCE_OID_ACCE = AC.OID_ACCE ");
        consulta.append(" AND AC.CANA_OID_CANA = CA.OID_CANA ");
        consulta.append(" AND PA.OID_PAIS = ?  ");
        parametros.add(pais);
        consulta.append(" AND CA.OID_CANA = ?  ");
        parametros.add(canal);
        consulta.append(" AND AC.OID_ACCE = ?  ");
        parametros.add(acceso);
        consulta.append(" AND SA.OID_SBAC = ?  ");
        parametros.add(subacceso);
        consulta.append(" AND SO.OID_SOCI = ?  ");
        parametros.add(sociedad);
        consulta.append(" AND DSA.TIDO_OID_TIPO_DOCU = ?  ");
        parametros.add(tipoDocumentoLegal);
        /*consulta.append(" AND CA.COD_USUA = ? ");
        parametros.add(this.usuario);
        consulta.append(" AND PA.COD_USUA = ? ");
        parametros.add(this.usuario);*/ //ver incidencia 9003

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            this.logSql(" obtenerDatosDocumento. SQL: ",
                consulta.toString(), parametros);
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerDatosDocumento: Exception", e);
            this.logSql(" obtenerDatosDocumento. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //Con el RecordSet que devuelve la sentencia SQL, construye un objeto DTOFACDocumentoSubacceso
        DTOFACDocumentoSubacceso dtoFACDocumentoSubacceso = new DTOFACDocumentoSubacceso();

        if (resultado.getRowCount() > 0) {
            dtoFACDocumentoSubacceso.setOid(new Long(
                    ((BigDecimal) resultado.getValueAt(0, "OID")).longValue()));
            dtoFACDocumentoSubacceso.setOidSociedad(new Long(
                    ((BigDecimal) resultado.getValueAt(0, "OIDSOCIEDAD")).longValue()));
            dtoFACDocumentoSubacceso.setOidSubacceso(new Long(
                    ((BigDecimal) resultado.getValueAt(0, "OIDSUBACCESO")).longValue()));
            dtoFACDocumentoSubacceso.setOidTipoDocumento(new Long(
                    ((BigDecimal) resultado.getValueAt(0, "TIPODOCUMENTO")).longValue()));
            dtoFACDocumentoSubacceso.setSerieDocumentoLegal((String) resultado.getValueAt(
                    0, "SERIEDOCUMENTOLEGAL"));

            dtoFACDocumentoSubacceso.setUltimoNumeroDocumentoLegal(new Integer(
                    ((BigDecimal) resultado.getValueAt(0,
                        "ULTIMONUMERODOCUMENTOLEGAL")).intValue()));
            dtoFACDocumentoSubacceso.setLimiteNumeroDocumentoLegal(new Integer(
                    ((BigDecimal) resultado.getValueAt(0,
                        "LIMITENUMERODOCUMENTOLEGAL")).intValue()));
            dtoFACDocumentoSubacceso.setUltimoEjercicioDocumentoInterno(new Integer(
                    ((BigDecimal) resultado.getValueAt(0,
                        "ULTIMOEJERCICIODOCUMENTOINTERN")).intValue()));
            dtoFACDocumentoSubacceso.setUltimoNumeroDocumentoInterno(new Integer(
                    ((BigDecimal) resultado.getValueAt(0,
                        "ULTIMONUMERODOCUMENTOINTERNO")).intValue()));
        }

        UtilidadesLog.info("DAOFACDocumentoContable.obtenerDatosDocumento(Long pais, Long canal, Long acceso, Long subacceso, Long sociedad, Long tipoDocumentoLegal): Salida");
        return dtoFACDocumentoSubacceso;
    }

    public ArrayList obtenerAcumuladoImpuestos(DTOFACCabeceraDocContable dtoDocumentoContable) 
    throws MareException{

        UtilidadesLog.info("DAOFACDocumentoContable.obtenerAcumuladoImpuestos(DTOFACCabeceraDocContable dtoDocumentoContable): Entrada");        
        StringBuffer consulta = new StringBuffer("");
        Vector parametros = new Vector();

        consulta.append(" SELECT OID_DOC_CONT_ACUM_IMPU  AS OID ");
        consulta.append(" , NUM_BASE_IMPO_POSI_LOCA  AS BASEIMPONIBLEPOSICIONLOCAL ");
        consulta.append(" , NUM_TOTA_PREC_POSI_LOCA  AS TOTALPRECIOSPOSICIONLOCAL ");
        consulta.append(" , NUM_TOTA_DESC_CABE_LOCA  AS TOTALDESCUENTOCABECERALOCAL ");
        consulta.append(" , NUM_BASE_IMPO_DESC_CABE_LOCA AS BASEIMPONIBLEDESCUENTOCABEL ");
        consulta.append(" , NUM_BASE_IMPO_PREC_CONT_LOCA  AS BASEIMPONIBLEPRECIOCONTABLEL ");
        consulta.append(" , NUM_BASE_IMPO_FLET_LOCA  AS BASEIMPONIBLEFLETELOCAL ");
        consulta.append(" , NUM_BASE_IMPO_TOTA_LOCA  AS BASEIMPONIBLETOTALLOCAL ");
        consulta.append(" , NUM_TOTA_IMPU_LOCA  AS TOTALIMPUESTOSLOCAL ");
        consulta.append(" , NUM_TOTA_IMPO_LOCA  AS TOTALIMPORTELOCAL ");
        consulta.append(" , NUM_BASE_IMPO_POSI_DOCU  AS BASEIMPONIBLEPOSICIONDOCUMENTO ");
        consulta.append(" , NUM_TOTA_PREC_POSI_DOCU  AS TOTALPRECIOSPOSICIONDOCUMENTO ");
        consulta.append(" , NUM_TOTA_DESC_CABE_DOCU  AS TOTALDESCUENTOCABECERADOCUM ");
        consulta.append(" , NUM_BASE_IMPO_DESC_CABE_DOCU  AS BASEIMPONIBLEDESCUENCABEDOCUM ");
        consulta.append(" , NUM_BASE_IMPO_PREC_CONT_DOCU  AS BASEIMPONIBLEPRECIOCONTADOCUM ");
        consulta.append(" , NUM_BASE_IMPO_FLET_DOCU  AS BASEIMPONIBLEFLETEDOCUMENTO ");
        consulta.append(" , NUM_BASE_IMPO_TOTA_DOCU  AS BASEIMPONIBLETOTALDOCUMENTO ");
        consulta.append(" , NUM_TOTA_IMPU_DOCU  AS TOTALIMPUESTOSDOCUMENTO ");
        consulta.append(" , NUM_TOTA_IMPO_DOCU  AS TOTALIMPORTEDOCUMENTO ");
		consulta.append(" , TAIM_OID_TASA_IMPU as OIDINDICADORIMPUESTOS ");
		
        consulta.append(" FROM FAC_DOCUM_CONTA_ACUMU_IMPUE ");
        consulta.append(" WHERE DCCA_OID_CABE = ? ");

        parametros.add(dtoDocumentoContable.getOidCabeceraSolicitud());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            this.logSql(" obtenerAcumuladoImpuestos. SQL: ",
                consulta.toString(), parametros);
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerAcumuladoImpuestos: Exception", e);
            this.logSql(" obtenerAcumuladoImpuestos. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        ArrayList listaAcumuladoImpuestos = new ArrayList();
        DTOFACAcumuladoImpuestos dtoFACAcumuladoImpuestos = null;

		int tam = resultado.getRowCount();

        for(int i=0 ; i<tam; i++){

            dtoFACAcumuladoImpuestos = new DTOFACAcumuladoImpuestos();

            dtoFACAcumuladoImpuestos.setOidIndicadorImpuesto(new Long(
                ((BigDecimal)resultado.getValueAt(i,"OIDINDICADORIMPUESTOS")).toString()));
            dtoFACAcumuladoImpuestos.setBaseImponibleTotalLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLETOTALLOCAL")).toString()));
            dtoFACAcumuladoImpuestos.setTotalImpuestosLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALIMPUESTOSLOCAL")).toString()));      
            dtoFACAcumuladoImpuestos.setTotalImporteLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALIMPORTELOCAL")).toString()));      
            dtoFACAcumuladoImpuestos.setOid(new Long(
                ((BigDecimal)resultado.getValueAt(i,"OID")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponiblePosicionLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEPOSICIONLOCAL")).toString()));      
            dtoFACAcumuladoImpuestos.setTotalPreciosPosicionLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALPRECIOSPOSICIONLOCAL")).toString()));      
            dtoFACAcumuladoImpuestos.setTotalDescuentoCabeceraLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALDESCUENTOCABECERALOCAL")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponibleDescuentoCabeceraLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEDESCUENTOCABEL")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponiblePrecioContableLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEPRECIOCONTABLEL")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponibleFleteLocal(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEFLETELOCAL")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponiblePosicionDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEPOSICIONDOCUMENTO")).toString()));      
            dtoFACAcumuladoImpuestos.setTotalPreciosPosicionDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALPRECIOSPOSICIONDOCUMENTO")).toString()));      
            dtoFACAcumuladoImpuestos.setTotalDescuentoCabeceraDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALDESCUENTOCABECERADOCUM")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponibleDescuentoCabeceraDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEDESCUENCABEDOCUM")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponiblePrecioContableDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEPRECIOCONTADOCUM")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponibleFleteDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLEFLETEDOCUMENTO")).toString()));      
            dtoFACAcumuladoImpuestos.setBaseImponibleTotalDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"BASEIMPONIBLETOTALDOCUMENTO")).toString()));      
            dtoFACAcumuladoImpuestos.setTotalImpuestosDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALIMPUESTOSDOCUMENTO")).toString()));      
            dtoFACAcumuladoImpuestos.setTotalImporteDocumento(new Float(
                ((BigDecimal)resultado.getValueAt(i,"TOTALIMPORTEDOCUMENTO")).toString()));      
                
            listaAcumuladoImpuestos.add(dtoFACAcumuladoImpuestos);
                
        }
        
        UtilidadesLog.info("DAOFACDocumentoContable.obtenerAcumuladoImpuestos(DTOFACCabeceraDocContable dtoDocumentoContable): Salida");        
        
        return listaAcumuladoImpuestos;
        
    }
	public ArrayList obtenerDocumentosConsolidado(DTOOIDs listaOids) throws MareException{
		UtilidadesLog.info("DAOFACDocumentoContable.obtenerDocumentosConsolidado(DTOOIDs listaOids): Entrada");        
		ArrayList array = new ArrayList();
    try{
        Long duracionSQL = (new java.util.Date()).getTime();
        /*String oids = this.convertirArrayToString(listaOids.getOids());
        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();
        //SELECT
        consulta.append("SELECT ");
        consulta.append(" F.VAL_ALMA as CODIGOALMACEN, ");
        consulta.append(" F.VAL_EJER_DOCU_INTE as EJERCICIODOCUMENTOCONTABLE, ");
        consulta.append(" F.VAL_ESTA as ESTADO, ");
        consulta.append(" F.FEC_EMIS as FECHAEMISION, ");
        consulta.append(" F.FEC_FACT as FECHAFACTURACION, ");
        consulta.append(" F.FOPA_OID_FORM_PAGO as FORMAPAGO, ");
        consulta.append(" F.IMP_DES3_TOTA_DOCU as IMPORTEDESCUENTODOCUMENTO, ");
        consulta.append(" F.IMP_DES3_TOTAL_LOCA as IMPORTEDESCUENTO3TOTALLOCAL, ");
        consulta.append(" F.IMP_FLET_TOTA_DOCU as IMPORTEFLETETOTALDOCUMENTO, ");
        consulta.append(" F.IMP_FLET_TOTA_LOCA as IMPORTEFLETETOTALLOCAL, ");
        consulta.append(" F.IMP_FLET_IMPU_TOTA_LOCA as IMPORTEFLETESINIMPUESTOTAL, ");
        consulta.append(" F.IND_IMPR as INDICADORIMPRESION, ");
        consulta.append(" F.MONE_OID_MONE as MONEDA, ");
        consulta.append(" F.NUM_DOCU_CONT_INTE as NUMERODOCUMENTOINTERNO, ");
        consulta.append(" F.NUM_DOCU_ORIG as NUMERODOCUMENTOORIGEN, ");
        consulta.append(" F.VAL_OBSE as OBSERVACIONES, ");
        consulta.append(" F.OID_CABE as OIDCABECERASOLICITUD, ");
        consulta.append(" F.SOCA_OID_SOLI_CABE as OIDSOLICITUD, ");
        consulta.append(" F.PAIS_OID_PAIS as PAIS, ");
        consulta.append(" F.PERD_OID_PERI as PERIODO, ");
        consulta.append(" F.VAL_PUNT_EMIS as PUNTOEMISION, ");
        consulta.append(" F.ZORG_OID_REGI as REGION, ");
        consulta.append(" F.ZSCC_OID_SECC as SECCION, ");
        consulta.append(" F.SOCI_OID_SOCI as SOCIEDAD, ");
        consulta.append(" F.SBAC_OID_SBAC as SUBACCESO, ");
        consulta.append(" F.ZSGV_OID_SUBG_VENT as SUBGERENCIA, ");
        consulta.append(" F.TERR_OID_TERR as TERRITORIO, ");
        consulta.append(" F.VAL_TIPO_CAMB as TIPOCAMBIO, ");
        consulta.append(" F.TIDO_OID_TIPO_DOCU as TIPODOCUMENTOLEGAL, ");
        consulta.append(" F.NUM_ABON as NUMEROABONO, ");
        consulta.append(" F.CLDI_OID_CLIE_DIRE as OIDCLIENTEDIRECCION, ");
        consulta.append(" F.FORS_OID_FORM as OIDFORMULARIO, ");
        consulta.append(" F.VAL_TIPO_DIRE as TIPODIRECCION, ");
        consulta.append(" F.ZZON_OID_ZONA as ZONA, ");
        consulta.append(" F.VAL_APE1 as APELLIDO1, ");
        consulta.append(" F.VAL_APE2 as APELLIDO2, ");
        consulta.append(" F.VAL_NOM1 as NOMBRE1, ");
        consulta.append(" F.VAL_NOM2 as NOMBRE2, ");
        consulta.append(" F.NUM_DOCU_LEGA as NUMERODOCUMENTOLEGAL, ");
        consulta.append(" F.VAL_NUME_IDEN_FISC as NUMEROIDENTIFICACIONFISCAL, ");
        consulta.append(" F.VAL_NUME_IDEN_NNAL as NUMEROIDENTIFICACIONNACIONAL, ");
        consulta.append(" F.VAL_SERI_DOCU_LEGA as SERIEDOCUMENTOLEGAL, ");
        consulta.append(" F.VAL_PREC_CATA_IMPU as PRECIOCATALOGOSINIMPUESTOTOTAL, ");
        consulta.append(" F.VAL_PREC_CONT_IMPU as PRECIOCONTABLESINIMPUESTOTOTAL, ");
        consulta.append(" F.VAL_PREC_CATA_TOTA_LOCA_UNID as PRECIOCATALOGOTOTALLOCALUNI, ");
        consulta.append(" F.VAL_PREC_CATA_TOTA_LOCA as PRECIOCATALOGOTOTALLOCAL, ");
        consulta.append(" F.VAL_PREC_CONT_TOTA_LOCA as PRECIOCONTABLETOTALLOCAL,");
        consulta.append(" F.IMP_DES1_TOTA_LOCA as IMPORTEDESCUENTO1TOTALLOCAL, ");
        consulta.append(" F.IMP_DES1_IMPU as IMPORTEDESCUENTOSINIMPUESTOS, ");
        consulta.append(" F.VAL_PREC_FACT_TOTA_LOCA as PRECIOFACTURATOTALLOCAL, ");
        consulta.append(" F.VAL_PREC_TOTA_TOTA_LOCA as PRECIOTOTALTOTALLOCAL, ");
        consulta.append(" F.IMP_DES3_IMPU as IMPORTEDESCUENTO3SINIMPUESTOS, ");
        consulta.append(" F.IMP_DESC_TOTA_LOCA as IMPORTEDESCUENTOTOTALLOCAL, ");
        consulta.append(" F.VAL_PREC_NETO_TOTA_LOCA as PRECIONETOTOTALLOCAL, ");
        consulta.append(" F.IMP_IMPU_TOTA_LOCA as IMPORTEIMPUESTOSTOTALLOCAL, ");
        consulta.append(" F.VAL_TOTA_PAGA_LOCA as TOTALAPAGARLOCAL, ");
        consulta.append(" F.VAL_TOTA_PAGA_DOCU as TOTALAPAGARDOCUMENTO, ");
        consulta.append(" F.IMP_REDO_LOCA as IMPORTEREDONDEOLOCAL, ");
        consulta.append(" F.IMP_REDO_CONS_LOCA as IMPORTEREDONDEOCONSOLIDADO, ");
        consulta.append(" M.CLIE_OID_CLIE as OIDCLIENTE, ");
        consulta.append(" F.NUM_UNID_ATEN_TOTA as UNIDADESATENDIDAS, ");
        consulta.append(" F.VAL_PREC_CATA_TOTA_DOCU as PRECIOCATALOGOTOTALDOCUMENTO, ");
        consulta.append(" F.VAL_PREC_CATA_SIN_IMPU_TOTA as PRECIOCATALOGOSINIMPUESTO, ");
        consulta.append(" F.VAL_PREC_CONT_TOTA_DOCU as PRECIOCONTABLETOTALDOCUMENTO, ");
        consulta.append(" F.VAL_PREC_CONT_SIN_IMPU_TOTA as PRECIOCONTASINIMPUESDOCUMENTO, ");
        consulta.append(" F.IMP_DES1_TOTA_DOCU as IMPORTEDESCUENTOTOTALDOCUMENTO, ");
        consulta.append(" F.IMP_DES1_SIN_IMPU_TOTA as IMPORTEDESCUENTOSINIMPUES, ");
        consulta.append(" F.IMP_DES3_SIN_IMPU_TOTA as IMPORTEDESCUENTO3SINIMPUES, ");
        consulta.append(" F.IMP_DESC_TOTA_DOCU as IMPORTEDESCUENTOTOTALDOCUMENTO, ");
        consulta.append(" F.VAL_PREC_FACT_TOTA_DOCU as PRECIOFACTURATOTALDOCUMENTO, ");
        consulta.append(" F.IMP_IMPU_TOTA_DOCU as IMPORTEIMPUESTOSTOTALDOCUMENTO, ");
        consulta.append(" F.VAL_PREC_TOTA_TOTA_DOCU as PRECIOTOTALTOTALDOCUMENTO ");
        // Agregado por Cambio FAC-003 ------ AL 
        consulta.append(",  F.ICTP_OID_TIPO_PROG TIPO_PROG ");
        // Agregado por Cambio FAC-003 ------ AL 
        //<I> Agregado por Sapaza, fecha 01/10/2007, Cambio Sicc20070425
        consulta.append(",  F.IMP_FLET_SIN_IMPU_TOTA_DOCU ");
        //<F> Agregado por Sapaza, fecha 01/10/2007, Cambio Sicc20070425
        consulta.append(" FROM FAC_DOCUM_CONTA_CABEC F, MAE_CLIEN_DIREC M ");
        consulta.append(" WHERE M.OID_CLIE_DIRE = F.CLDI_OID_CLIE_DIRE ");
            consulta.append(" AND F.SOCA_OID_SOLI_CABE IN ("+ oids +") ");
      
        for (int i = 0; i < listaOids.getOids().length; i++){
          if(listaOids.getOids()[i]!=null){
            parametros.add(listaOids.getOids()[i]);
          }
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
            RecordSet resultado = null;
            String codigoError = null;
    
            try {
                this.logSql(" obtenerDocumentosConsolidado. SQL: ",
                    consulta.toString(), parametros);
                resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                        parametros);
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error(" obtenerDocumentosConsolidado: Exception", e);
                this.logSql(" obtenerDocumentosConsolidado. SQL: ",
                    consulta.toString(), parametros);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }

         try {
             this.logSql(" obtenerDocumentosConsolidado. SQL: ",
                 consulta.toString(), parametros);
             resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                     parametros);
         } catch (Exception e) {
             codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
             UtilidadesLog.error(" obtenerDocumentosConsolidado: Exception", e);
             this.logSql(" obtenerDocumentosConsolidado. SQL: ",
                 consulta.toString(), parametros);
             throw new MareException(e,
                 UtilidadesError.armarCodigoError(codigoError));
         }*/
        
        //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011 
        RecordSet resultado = null;
        try {
            Vector params = new Vector();
            params.add(listaOids.getOids()[0]); //oidConsolidado
            resultado = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.FAC_PR_OBTIE_DOCUM_CONSO", params);;
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerDocumentosConsolidado: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (!resultado.esVacio()){
          DTOFACCabeceraDocContable dto = null;//new DTOFACCabececeraDocContable();
          for (int i = 0; i < resultado.getRowCount(); i ++){
            dto = new DTOFACCabeceraDocContable();
            if (resultado.getValueAt(i,"CODIGOALMACEN") != null)
              dto.setCodigoAlmacen(((BigDecimal)resultado.getValueAt(i,"CODIGOALMACEN")).toString());
            if (resultado.getValueAt(i,"EJERCICIODOCUMENTOCONTABLE") != null)
              dto.setEjercicioDocumentoContableInterno(resultado.getValueAt(i,"EJERCICIODOCUMENTOCONTABLE").toString());
            if (resultado.getValueAt(i,"ESTADO") != null)
              dto.setEstado(new Long(resultado.getValueAt(i,"ESTADO").toString()));
            if (resultado.getValueAt(i,"FECHAEMISION") != null)
              dto.setFechaEmision((Date)resultado.getValueAt(i,"FECHAEMISION"));
            if (resultado.getValueAt(i,"FECHAFACTURACION") != null)
              dto.setFechaFacturacion((Date)resultado.getValueAt(i,"FECHAFACTURACION"));
            if (resultado.getValueAt(i,"FORMAPAGO") != null)
              dto.setFormaPago(new Long(resultado.getValueAt(i,"FORMAPAGO").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTODOCUMENTO") != null)
              dto.setImporteDescuento3TotalDocumento(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTODOCUMENTO").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTO3TOTALLOCAL") != null)
              dto.setImporteDescuento3TotalLocal(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTO3TOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"IMPORTEFLETETOTALDOCUMENTO") != null)
              dto.setImporteFleteTotalDocumento(new Float(resultado.getValueAt(i,"IMPORTEFLETETOTALDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"IMPORTEFLETETOTALLOCAL") != null)
              dto.setImporteFleteTotalLocal(new Float(resultado.getValueAt(i,"IMPORTEFLETETOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"IMPORTEFLETESINIMPUESTOTAL") != null)
              dto.setImporteFleteSinImpuestosTotalLocal(new Float(resultado.getValueAt(i,"IMPORTEFLETESINIMPUESTOTAL").toString()));
            if (resultado.getValueAt(i,"INDICADORIMPRESION") != null)
              dto.setIndicadorImpresion(new Boolean(resultado.getValueAt(i,"INDICADORIMPRESION").toString()));
            if (resultado.getValueAt(i,"MONEDA") != null)
              dto.setMoneda(new Long(resultado.getValueAt(i,"MONEDA").toString()));
            if (resultado.getValueAt(i,"NUMERODOCUMENTOINTERNO") != null)
              dto.setNumeroDocumentoInterno(new Integer(resultado.getValueAt(i,"NUMERODOCUMENTOINTERNO").toString()));
            if (resultado.getValueAt(i,"NUMERODOCUMENTOORIGEN") != null)
              dto.setNumeroDocumentoOrigen(new Long(resultado.getValueAt(i,"NUMERODOCUMENTOORIGEN").toString()));
            if (resultado.getValueAt(i,"OBSERVACIONES") != null)
              dto.setObservaciones((String)resultado.getValueAt(i,"OBSERVACIONES"));
            if (resultado.getValueAt(i,"OIDCABECERASOLICITUD") != null)
              dto.setOidCabeceraSolicitud(new Long(resultado.getValueAt(i,"OIDCABECERASOLICITUD").toString()));
            if (resultado.getValueAt(i,"OIDSOLICITUD") != null)
              dto.setOidSolicitud(new Long(resultado.getValueAt(i,"OIDSOLICITUD").toString()));
            if (resultado.getValueAt(i,"PAIS") != null)
              dto.setOidPais(new Long(resultado.getValueAt(i,"PAIS").toString()));
            if (resultado.getValueAt(i,"PERIODO") != null)
              dto.setPeriodo(new Long(resultado.getValueAt(i,"PERIODO").toString()));
            if (resultado.getValueAt(i,"PUNTOEMISION") != null){
              dto.setPuntoEmision(resultado.getValueAt(i,"PUNTOEMISION").toString());
            }
            if (resultado.getValueAt(i,"REGION") != null)
              dto.setRegion(new Long(resultado.getValueAt(i,"REGION").toString()));
            if (resultado.getValueAt(i,"SECCION") != null)
              dto.setSeccion(new Long(resultado.getValueAt(i,"SECCION").toString()));
            if (resultado.getValueAt(i,"SOCIEDAD") != null)
              dto.setSociedad(new Long(resultado.getValueAt(i,"SOCIEDAD").toString()));
            if (resultado.getValueAt(i,"SUBACCESO") != null)
              dto.setSubacceso(new Long(resultado.getValueAt(i,"SUBACCESO").toString()));
            if (resultado.getValueAt(i,"SUBGERENCIA") != null)
              dto.setSubgerencia(new Long(resultado.getValueAt(i,"SUBGERENCIA").toString()));
            if (resultado.getValueAt(i,"TERRITORIO") != null)
              dto.setTerritorio(new Long(resultado.getValueAt(i,"TERRITORIO").toString()));
            if (resultado.getValueAt(i,"TIPOCAMBIO") != null)
              dto.setTipoCambio((BigDecimal)resultado.getValueAt(i,"TIPOCAMBIO"));
            if (resultado.getValueAt(i,"TIPODOCUMENTOLEGAL") != null)
              dto.setTipoDocumentoLegal(new Long(resultado.getValueAt(i,"TIPODOCUMENTOLEGAL").toString()));
            if (resultado.getValueAt(i,"NUMEROABONO") != null)
              dto.setNumeroAbono(new Long(resultado.getValueAt(i,"NUMEROABONO").toString()));
            if (resultado.getValueAt(i,"OIDCLIENTEDIRECCION") != null)
              dto.setOidClienteDireccion(new Long(resultado.getValueAt(i,"OIDCLIENTEDIRECCION").toString()));
            if (resultado.getValueAt(i,"OIDFORMULARIO") != null)
              dto.setOidFormulario(new Long(resultado.getValueAt(i,"OIDFORMULARIO").toString()));
            if (resultado.getValueAt(i,"TIPODIRECCION") != null)
              dto.setTipoDireccion((String)resultado.getValueAt(i,"TIPODIRECCION"));
            if (resultado.getValueAt(i,"ZONA") != null)
              dto.setZona(new Long(resultado.getValueAt(i,"ZONA").toString()));
            dto.setApellido1(resultado.getValueAt(i,"APELLIDO1")!=null?resultado.getValueAt(i,"APELLIDO1").toString():"");
            dto.setApellido2(resultado.getValueAt(i,"APELLIDO2")!=null?resultado.getValueAt(i,"APELLIDO2").toString():"");
            dto.setNombre1(resultado.getValueAt(i,"NOMBRE1")!=null?resultado.getValueAt(i,"NOMBRE1").toString():"");
            dto.setNombre2(resultado.getValueAt(i,"NOMBRE2")!=null?resultado.getValueAt(i,"NOMBRE2").toString():"");
            if (resultado.getValueAt(i,"NUMERODOCUMENTOLEGAL") != null)
              dto.setNumeroDocumentoLegal(new Integer(resultado.getValueAt(i,"NUMERODOCUMENTOLEGAL").toString()));
            if (resultado.getValueAt(i,"NUMEROIDENTIFICACIONFISCAL") != null){
              dto.setNumeroIdentificacionFiscal(resultado.getValueAt(i,"NUMEROIDENTIFICACIONFISCAL").toString());
            }
            if (resultado.getValueAt(i,"NUMEROIDENTIFICACIONNACIONAL") != null)
              dto.setNumeroIdentificacionNacional((String)resultado.getValueAt(i,"NUMEROIDENTIFICACIONNACIONAL"));
            if (resultado.getValueAt(i,"SERIEDOCUMENTOLEGAL") != null)
              dto.setSerieDocumentoLegal((String)resultado.getValueAt(i,"SERIEDOCUMENTOLEGAL"));
            if (resultado.getValueAt(i,"PRECIOCATALOGOSINIMPUESTOTOTAL") != null)
              dto.setPrecioCatalogoSinImpuestoTotalLocal(new Float(resultado.getValueAt(i,"PRECIOCATALOGOSINIMPUESTOTOTAL").toString()));
            if (resultado.getValueAt(i,"PRECIOCONTABLESINIMPUESTOTOTAL") != null)
              dto.setPrecioContableSinImpuestoTotalLocal(new Float(resultado.getValueAt(i,"PRECIOCONTABLESINIMPUESTOTOTAL").toString()));
            if (resultado.getValueAt(i,"PRECIOCATALOGOTOTALLOCALUNI") != null)
              dto.setPrecioCatalogoTotalLocalUnidadesPorAtender(new Float(resultado.getValueAt(i,"PRECIOCATALOGOTOTALLOCALUNI").toString()));
            if (resultado.getValueAt(i,"PRECIOCATALOGOTOTALLOCAL") != null)
              dto.setPrecioCatalogoTotalLocal(new Float(resultado.getValueAt(i,"PRECIOCATALOGOTOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"PRECIOCONTABLETOTALLOCAL") != null)
              dto.setPrecioContableTotalLocal(new Float(resultado.getValueAt(i,"PRECIOCONTABLETOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTO1TOTALLOCAL") != null)
              dto.setImporteDescuento1TotalLocal(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTO1TOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTOSINIMPUESTOS") != null)
              dto.setImporteDescuento1SinImpuestosTotalLocal(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTOSINIMPUESTOS").toString()));
            if (resultado.getValueAt(i,"PRECIOFACTURATOTALLOCAL") != null)
              dto.setPrecioFacturaTotalLocal(new Float(resultado.getValueAt(i,"PRECIOFACTURATOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"PRECIOTOTALTOTALLOCAL") != null)
              dto.setPrecioTotalLocal(new Float(resultado.getValueAt(i,"PRECIOTOTALTOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTO3SINIMPUESTOS") != null)
              dto.setImporteDescuento3SinImpuestosTotalLocal(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTO3SINIMPUESTOS").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTOTOTALLOCAL") != null)
              dto.setImporteDescuentoTotalLocal(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTOTOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"PRECIONETOTOTALLOCAL") != null)
              dto.setPrecioNetoTotalLocal(new Float(resultado.getValueAt(i,"PRECIONETOTOTALLOCAL").toString()));
            else  
              dto.setPrecioNetoTotalLocal(new Float(0));
            if (resultado.getValueAt(i,"IMPORTEIMPUESTOSTOTALLOCAL") != null)
              dto.setImporteImpuestosTotalLocal(new Float(resultado.getValueAt(i,"IMPORTEIMPUESTOSTOTALLOCAL").toString()));
            if (resultado.getValueAt(i,"TOTALAPAGARLOCAL") != null)
              dto.setTotalAPagarLocal(new Float(resultado.getValueAt(i,"TOTALAPAGARLOCAL").toString()));
            if (resultado.getValueAt(i,"TOTALAPAGARDOCUMENTO") != null)
              dto.setTotalAPagarDocumento(new Float(resultado.getValueAt(i,"TOTALAPAGARDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"IMPORTEREDONDEOLOCAL") != null)
              dto.setImporteRedondeoLocal(new Float(resultado.getValueAt(i,"IMPORTEREDONDEOLOCAL").toString()));
            if (resultado.getValueAt(i,"IMPORTEREDONDEOCONSOLIDADO") != null)
              dto.setImporteRedondeoConsolidadoLocal(new Float(resultado.getValueAt(i,"IMPORTEREDONDEOCONSOLIDADO").toString()));
            if (resultado.getValueAt(i,"OIDCLIENTE") != null)
              dto.setOidCliente(new Long(resultado.getValueAt(i,"OIDCLIENTE").toString()));
            if (resultado.getValueAt(i,"UNIDADESATENDIDAS") != null)
              dto.setUnidadesAtendidasTotal(new Integer(resultado.getValueAt(i,"UNIDADESATENDIDAS").toString()));
            if (resultado.getValueAt(i,"PRECIOCATALOGOTOTALDOCUMENTO") != null)
              dto.setPrecioCatalogoTotalDocumento(new Float(resultado.getValueAt(i,"PRECIOCATALOGOTOTALDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"PRECIOCATALOGOSINIMPUESTO") != null)
              dto.setPrecioCatalogoSinImpuestoTotalLocal(new Float(resultado.getValueAt(i,"PRECIOCATALOGOSINIMPUESTO").toString()));
            else  
              dto.setPrecioCatalogoSinImpuestoTotalLocal(new Float(0));
            if (resultado.getValueAt(i,"PRECIOCONTABLETOTALDOCUMENTO") != null)
              dto.setPrecioContableTotalDocumento(new Float(resultado.getValueAt(i,"PRECIOCONTABLETOTALDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"PRECIOCONTASINIMPUESDOCUMENTO") != null)
              dto.setPrecioContableSinImpuestosTotalDocumento(new Float(resultado.getValueAt(i,"PRECIOCONTASINIMPUESDOCUMENTO").toString()));
            else
              dto.setPrecioContableSinImpuestosTotalDocumento(new Float(0));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTOTOTALDOCUMENTO") != null)
              dto.setImporteDescuento1TotalDocumento(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTOTOTALDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTOSINIMPUES") != null)
              dto.setImporteDescuento1SinImpuestoTotalDocumento(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTOSINIMPUES").toString()));
            else     
              dto.setImporteDescuento1SinImpuestoTotalDocumento(new Float(0));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTO3SINIMPUES") != null)
              dto.setImporteDescuento3SinImpuestosTotalDocumento(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTO3SINIMPUES").toString()));
            if (resultado.getValueAt(i,"IMPORTEDESCUENTOTOTALDOCUMENTO") != null)
              dto.setImporteDescuentoTotalDocumento(new Float(resultado.getValueAt(i,"IMPORTEDESCUENTOTOTALDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"PRECIOFACTURATOTALDOCUMENTO") != null)
              dto.setPrecioFacturaTotalDocumento(new Float(resultado.getValueAt(i,"PRECIOFACTURATOTALDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"IMPORTEIMPUESTOSTOTALDOCUMENTO") != null)
              dto.setImporteImpuestosTotalDocumento(new Float(resultado.getValueAt(i,"IMPORTEIMPUESTOSTOTALDOCUMENTO").toString()));
            if (resultado.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO") != null)
              dto.setPrecioTotalTotalDocumento(new Float(resultado.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO").toString()));
            /* Agregado por Cambio FAC-003 ------ AL */
            if (resultado.getValueAt(i, "TIPO_PROG") != null)  
              dto.setOidTipoConcursoPrograma(new Long(resultado.getValueAt(i, "TIPO_PROG").toString()));
            /* Agregado por Cambio FAC-003 ------ AL */
            /*<I> Agregado por Sapaza, fecha 01/10/2007, Cambio Sicc20070425*/
            if (resultado.getValueAt(i,"IMP_FLET_SIN_IMPU_TOTA_DOCU") != null)
              dto.setImporteFleteSinImpuestosTotalDocumento(new Float(resultado.getValueAt(i,"IMP_FLET_SIN_IMPU_TOTA_DOCU").toString()));
            else               
              dto.setImporteFleteSinImpuestosTotalDocumento(new Float(0));
            /*<F> Agregado por Sapaza, fecha 01/10/2007, Cambio Sicc20070425*/
            
            array.add(dto);
          }
        }
    }catch(Exception e){
        UtilidadesLog.error("Error en la consulta: ",e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
		
		
 		UtilidadesLog.info("DAOFACDocumentoContable.obtenerDocumentosConsolidado(DTOOIDs listaOids): Salida");        
		return array;
	}
    
    public void reordenarRangos (Long oidPais, Long oidSubacceso, 
    Long oidSociedad, Long oidTipoDocumentoLegal) throws MareException{//se eliminan 2 parametros por la incidencia 8881

    UtilidadesLog.info("DAOFACDocumentoContable.reordenarRangos (Long oidPais, Long oidSubacceso, Long oidSociedad, Long oidTipoDocumentoLegal): Entrada");        

        //Se modifica la select que ejecuta debido a la incidencia 8881

        /*update FAC_RANGO_NUMER_OFICI
            set( NUM_ORDE_UTIL = NUM_ORDE_UTIL - 1 )
            where PAIS_OID_PAIS = oidPais and
            SBAC_OID_SBAC = oidSubacceso and
            SOCI_OID_SOCI = oidSociedad and
            TIDO_OID_TIPO_DOCU = oidTipoDocumentoLegal*/

        Vector parametros = new Vector();
		StringBuffer consulta = new StringBuffer();

        consulta.append("UPDATE FAC_RANGO_NUMER_OFICI ");
        consulta.append("SET NUM_ORDE_UTIL = (NUM_ORDE_UTIL - 1) ");
        consulta.append("WHERE PAIS_OID_PAIS = ? ");
        parametros.add(oidPais);
        consulta.append("AND SBAC_OID_SBAC = ? ");
        parametros.add(oidSubacceso);
        consulta.append("AND SOCI_OID_SOCI = ? ");
        parametros.add(oidSociedad);
        consulta.append("AND TIDO_OID_TIPO_DOCU = ? ");
        parametros.add(oidTipoDocumentoLegal);


        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;

        try {
            this.logSql(" reordenarRangos. SQL: ", consulta.toString(), parametros);
				bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" reordenarRangos: Exception", e);
            this.logSql(" reordenarRangos. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOFACDocumentoContable.reordenarRangos (Long oidPais, Long oidSubacceso, Long oidSociedad, Long oidTipoDocumentoLegal): Salida");        
           
    }
	/**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * modificaciones: 06/07/2005 - BELC300019415 - pperanzola
     */
	public DTOSalida consultarFacturas(DTOFACConsultaFacturas dtoe) throws MareException {
		//modificado por las incidencias 8872,9024,9939,9947
		UtilidadesLog.info("DAOFACDocumentoContAND DC.CLDI_OID_CLIE_DIRE = DI.OID_CLIE_DIRE able.consultarFacturas(DTOFACConsultaFacturas dtoe): Entrada");        
		//Documentation
		//Selecciona los documentos contables que cumplen las condiciones especificadas 
		//en los valores del DTO de entrada: 
		//
		Vector parametros = new Vector();
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
        //se modif. segun inc.: 19664

		consulta.append("SELECT  DC.OID_CABE OID, CL.COD_CLIE CODIGOCLIENTE, ");
        consulta.append("TD.DES_TIPO_DOCU TIPODOCU, SO.VAL_DENO DENOMINAC, ");
        consulta.append("SGC.COD_CANA CANAL, ACCE.COD_ACCE ACCESO, ");
        consulta.append("SA.COD_SBAC SUBACCESO, trim (to_char(DC.VAL_EJER_DOCU_INTE,'09')) EJERCICIO, ");
        consulta.append("DC.NUM_DOCU_CONT_INTE NUMERODOCUMENTOINTERNO, DC.VAL_SERI_DOCU_LEGA NUMEROSERIEDOCUMENTOLEGAL, ");
        consulta.append("DC.NUM_DOCU_LEGA DOCUMENTOLEGAL, SC.VAL_NUME_SOLI NUMEROCONSOLIDADO, ");
        consulta.append("FO.VAL_NOMB_FORM NOMBREFORMU, DC.FEC_FACT FECHAFACTURACION, DC.FEC_EMIS FECHAPROCESO ");
        
		/* DBLG700000230 - dmorello, 13/11/2006: No es necesaria la tabla MAE_CLIEN_DIREC */
    //consulta.append(" FROM  FAC_DOCUM_CONTA_CABEC DC,  MAE_CLIEN_DIREC DI,   MAE_CLIEN CL, ");
    consulta.append(" FROM  FAC_DOCUM_CONTA_CABEC DC,  MAE_CLIEN CL, ");
		consulta.append(" FAC_TIPO_DOCUM TD,  VCA_SEG_SOCIE SO,  VCA_SEG_SUBAC SA, PED_SOLIC_CABEC SC, ");
		consulta.append(" FAC_FORMU FO, SEG_ACCES ACCE, CRA_PERIO CP, SEG_CANAL SGC ");

		consulta.append(" WHERE ");
		consulta.append(" DC.PAIS_OID_PAIS= ? ");
		parametros.add(dtoe.getPais());
		consulta.append(" AND FO.OID_FORM =  DC.FORS_OID_FORM ");
		consulta.append(" AND DC.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
		consulta.append(" AND TD.OID_TIPO_DOCU = DC.TIDO_OID_TIPO_DOCU ");
		consulta.append(" AND DC.SOCI_OID_SOCI = SO.OID_SOCI ");
		consulta.append(" AND DC.SBAC_OID_SBAC = SA.OID_SBAC ");
		consulta.append(" AND SA.ACCE_OID_ACCE= ACCE.OID_ACCE ");
		consulta.append(" AND SO.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append(" AND SA.COD_USUA = ? ");
		parametros.add(this.usuario);
        
        //@ssaavedra 04/10/2005 linea agregada segun inc.: BELC300021064
        //es mejor recuperar el mae_clien dede el oid de cliente de la cabecera
        consulta.append("AND cl.OID_CLIE = sc.CLIE_OID_CLIE ");
        
        //@ssaavedra 04/10/2005 linea quitada segun inc.: BELC300021064
		//consulta.append(" AND DC.CLDI_OID_CLIE_DIRE = DI.OID_CLIE_DIRE  ");
        
		/* DBLG700000230 - dmorello, 13/11/2006: No es necesaria la tabla MAE_CLIEN_DIREC */
    //consulta.append(" AND DI.CLIE_OID_CLIE = CL.OID_CLIE ");
        consulta.append(" AND SC.PERD_OID_PERI = CP.OID_PERI ");
        consulta.append(" AND CP.CANA_OID_CANA = SGC.OID_CANA ");
        
		if(dtoe.getCodigoCliente() != null){
			consulta.append(" AND CL.COD_CLIE LIKE ? ");
			parametros.add(dtoe.getCodigoCliente());
		}
		if(dtoe.getTipoDocumentoContable() != null ){
			consulta.append("AND TD.OID_TIPO_DOCU = ? ");
			parametros.add(dtoe.getTipoDocumentoContable());
		}
		if(dtoe.getEjercicio() != null){
			consulta.append(" AND DC.VAL_EJER_DOCU_INTE = ? ");
			parametros.add(dtoe.getEjercicio());
		}
		if(dtoe.getRangoDesdeDocumentoInterno() != null){
			consulta.append(" AND DC.NUM_DOCU_CONT_INTE >= ? ");
			parametros.add(dtoe.getRangoDesdeDocumentoInterno());
		}
		if(dtoe.getRangoHastaDocumentoInterno() != null){
			consulta.append(" AND DC.NUM_DOCU_CONT_INTE <= ? ");
			parametros.add(dtoe.getRangoHastaDocumentoInterno());
		}
		if(dtoe.getSerieDocumentoLegal() != null){
			consulta.append(" AND DC.VAL_SERI_DOCU_LEGA = ? ");
			parametros.add(dtoe.getSerieDocumentoLegal());
		}
		if(dtoe.getRangoDesdeDocumentoLegal() != null){
			consulta.append(" AND DC.NUM_DOCU_LEGA >= ? ");
			parametros.add(dtoe.getRangoDesdeDocumentoLegal());
		}
		if(dtoe.getRangoHastaDocumentoLegal() != null){
			consulta.append(" AND DC.NUM_DOCU_LEGA <= ? ");
			parametros.add(dtoe.getRangoHastaDocumentoLegal());
		}
		if(dtoe.getSubacceso() != null){
			consulta.append(" AND DC.SBAC_OID_SBAC = ? ");
			parametros.add(dtoe.getSubacceso());
		}
		if(dtoe.getCanal() != null){
			consulta.append(" AND ACCE.CANA_OID_CANA = ? ");
			parametros.add(dtoe.getCanal());
		}
		if(dtoe.getAcceso() != null){
			consulta.append(" AND ACCE.OID_ACCE = ? ");
			parametros.add(dtoe.getAcceso());
		}

		if(dtoe.getNumeroConsolidadoDesde() != null || dtoe.getNumeroConsolidadoHasta() != null){
			consulta.append(" AND  DC.OID_CABE in ( ");
			consulta.append(" SELECT DC.OID_CABE ");
			consulta.append(" FROM PED_SOLIC_CABEC SC,FAC_DOCUM_CONTA_CABEC DC ");
			consulta.append(" WHERE DC.SOCA_OID_SOLI_CABE=SC.OID_SOLI_CABE ");
			if(dtoe.getNumeroConsolidadoDesde() != null){
				consulta.append(" AND SC.VAL_NUME_SOLI >= ? ");
				parametros.add(dtoe.getNumeroConsolidadoDesde());
			}
			if(dtoe.getNumeroConsolidadoHasta() != null){
				consulta.append(" AND SC.VAL_NUME_SOLI <= ? ");
				parametros.add(dtoe.getNumeroConsolidadoHasta());
			}
			consulta.append(" ) ");
		}

		if(dtoe.getFechaFacturacionDesde() != null ){
			consulta.append(" AND DC.FEC_FACT >= TO_DATE( ? ,'YYYY-MM-DD') ");
			parametros.add(convertirFecha(dtoe.getFechaFacturacionDesde()));
		}
		if(dtoe.getFechaFacturacionHasta() != null ){
			consulta.append(" AND DC.FEC_FACT <= TO_DATE( ? ,'YYYY-MM-DD') ");
			parametros.add(convertirFecha(dtoe.getFechaFacturacionHasta()));
		}
		if(dtoe.getFechaProcesoDesde() != null ){
			consulta.append(" AND TO_DATE(TO_CHAR(DC.FEC_EMIS,'YYYY-MM-DD'), 'YYYY-MM-DD') >= TO_DATE( ? ,'YYYY-MM-DD') ");
			parametros.add(convertirFecha(dtoe.getFechaProcesoDesde()));
		}
		if(dtoe.getFechaProcesoHasta() != null ){
			consulta.append(" AND TO_DATE(TO_CHAR(DC.FEC_EMIS,'YYYY-MM-DD'), 'YYYY-MM-DD') <= TO_DATE( ? ,'YYYY-MM-DD') ");
            parametros.add(convertirFecha(dtoe.getFechaProcesoHasta()));
		}
		
		String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dtoe);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			this.logSql("DAOFACDocumentoContable.consultarFacturas. SQL: ",sqlPaginacion, parametros);
			rs = bs.dbService.executePreparedQuery(sqlPaginacion,parametros);
		} catch (Exception e) {
		    codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("DAOFACDocumentoContable.consultarFacturas: Exception",e);
		    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		if (rs.esVacio()){
			UtilidadesLog.debug("****DAOFACDocumentoContable.consultarFacturas: No hay datos ");
			throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(rs);

		UtilidadesLog.info("DAOFACDocumentoContable.consultarFacturas(DTOFACConsultaFacturas dtoe): Salida");        
		return dtoSalida;
	}

// Todos los campos con comentario (no se encuentra o identifier too long) tienen un nombre
// (alias) distinto al del diseño. No influye ya que solo se usan en este método
// Modifico los nombres para ponerlos en mayúsculas para no tener problemas con la clase RecordSet
// Incidencia BELC300011174.
	public ArrayList obtenerCabecerasDC (DTOOIDs listaOIDs) throws MareException {
		UtilidadesLog.info("DAOFACDocumentoContable.obtenerCabecerasDC (DTOOIDs listaOIDs): Entrada");        

		StringBuffer sql = new StringBuffer("");

		sql.append(" SELECT VAL_ALMA AS CODIGOALMACEN, ");
		/* VAL_EJER_DOCU_INTE AS ejercicioDocuentoContableInterno, identifier too long */
		sql.append(" VAL_EJER_DOCU_INTE AS EJERCICIODOCUCONTAINTE, ");
		sql.append(" VAL_ESTA AS ESTADO, ");
		sql.append(" FEC_EMIS AS FECHAEMISION, ");
		sql.append(" FEC_FACT AS FECHAFACTURACION, ");
		sql.append(" FOPA_OID_FORM_PAGO AS FORMAPAGO, ");
		/* IMP_DES3_TOTA_DOCU AS ImporteDescuento3TotalDocumento, identifier too long */
		sql.append(" IMP_DES3_TOTA_DOCU AS IMPORTEDESCU3TOTALDOCU, ");
		sql.append(" IMP_DES3_TOTAL_LOCA AS IMPORTEDESCUENTO3TOTALLOCAL, ");
		sql.append(" IMP_FLET_TOTA_DOCU AS IMPORTEFLETETOTALDOCUMENTO, ");
		sql.append(" IMP_FLET_TOTA_LOCA AS IMPORTEFLETETOTALLOCAL, ");
		/* IMP_FLET_IMPU_TOTA_LOCA AS ImporteFleteSinImpuestosTotalLocal, identifier too long */
		sql.append(" IMP_FLET_IMPU_TOTA_LOCA AS IMPORTEFLETESINIMPUTOTALLOCAL, ");
		sql.append(" IND_IMPR AS INDICADORIMPRESION, ");
		/* VAL_MARC Eliminado por la BELC300011174*/
		/*VAL_MARC AS marcaConsolidado,*/
		sql.append(" MONE_OID_MONE AS MONEDA, ");
		sql.append(" NUM_DOCU_CONT_INTE AS NUMERODOCUMENTOINTERNO, ");
		sql.append(" NUM_DOCU_ORIG AS NUMERODOCUMENTOORIGEN, ");
		sql.append(" VAL_OBSE AS OBSERVACIONES, ");
		sql.append(" OID_CABE AS OIDCABECERASOLICITUD, ");
		sql.append(" SOCA_OID_SOLI_CABE AS OIDSOLICITUD, ");
		sql.append(" PAIS_OID_PAIS AS PAIS, ");
		sql.append(" PERD_OID_PERI AS PERIODO, ");
		sql.append(" VAL_PUNT_EMIS AS PUNTOEMISION, ");
		sql.append(" ZORG_OID_REGI AS REGION, ");
		sql.append(" ZSCC_OID_SECC AS SECCION, ");
		sql.append(" SOCI_OID_SOCI AS SOCIEDAD, ");
		sql.append(" SBAC_OID_SBAC AS SUBACCESO, ");
		sql.append(" ZSGV_OID_SUBG_VENT AS SUBGERENCIA, ");
		/* COD_SUBT_CLIE Eliminado por la BELC300011174*/
		/*COD_SUBT_CLIE AS subtipoCliente,*/
		sql.append(" TERR_OID_TERR AS TERRITORIO, ");
		sql.append(" VAL_TIPO_CAMB AS TIPOCAMBIO, ");
		/* COD_TIPO_CLIE Eliminado por la BELC300011174*/
		/*COD_TIPO_CLIE AS tipoCliente,*/
		sql.append(" TIDO_OID_TIPO_DOCU AS TIPODOCUMENTOLEGAL, ");
		/* VAL_TIPO_SOLI Eliminado por la BELC300011174 */
		/*VAL_TIPO_SOLI AS tipoSolicitud,*/
		sql.append(" NUM_ABON AS NUMEROABONO, ");
		sql.append(" CLDI_OID_CLIE_DIRE AS OIDCLIENTEDIRECCION, ");
		/* oidCliente -> se accede a la tabla MAE_CLIEN usando oidClienteDireccion y se obtiene 
		 * el campo OID_CLIE 
		 No existe en MAE_CLIE. Utilizo la MAE_CLIEN_DIREC Y UTILIZO 
		 EL CAMPO mae.TIDC_OID_TIPO_DIRE */
		sql.append(" (SELECT CLIE_OID_CLIE FROM MAE_CLIEN_DIREC ");
		sql.append(" WHERE CLDI_OID_CLIE_DIRE=OID_CLIE_DIRE) AS OIDCLIENTE, "); 

		sql.append(" FORS_OID_FORM AS OIDFORMULARIO, ");
		sql.append(" VAL_TIPO_DIRE AS TIPODIRECCION, ");
		sql.append(" ZZON_OID_ZONA AS ZONA, ");
		sql.append(" VAL_APE1 AS APELLIDO1, ");
		sql.append(" VAL_APE2 AS APELLIDO2, ");
		sql.append(" VAL_NOM1 AS NOMBRE1, ");
		sql.append(" VAL_NOM2 AS NOMBRE2, ");
		sql.append(" NUM_DOCU_LEGA AS NUMERODOCUMENTOLEGAL, ");
		sql.append(" VAL_NUME_IDEN_FISC AS NUMEROIDENTIFICACIONFISCAL, ");
		sql.append(" VAL_NUME_IDEN_NNAL AS NUMEROIDENTIFICACIONNACIONAL, ");
		sql.append(" VAL_SERI_DOCU_LEGA AS SERIEDOCUMENTOLEGAL, ");
		/*VAL_PREC_CATA_IMPU AS precioCatalogoSinImpuestoTotalLocal, identifier too long */
		sql.append(" VAL_PREC_CATA_IMPU AS PRECIOCATASINIMPUTOTALLOCAL,  ");
		/*VAL_PREC_CONT_IMPU AS precioContableSinImpuestoTotalLocal, identifier too long */
		sql.append(" VAL_PREC_CONT_IMPU AS PRECIOCONTASINIMPUTOTALLOCAL, "); 
		/*VAL_PREC_CATA_TOTA_LOCA_UNID AS precioCatalogoTotalLocalUnidadesPorAtender, identifier too long */
		sql.append(" VAL_PREC_CATA_TOTA_LOCA_UNID AS PRECIOCATATLOCLUNIDAPORATNDR,  ");
		sql.append(" VAL_PREC_CATA_TOTA_LOCA AS PRECIOCATALOGOTOTALLOCAL, ");
		sql.append(" VAL_PREC_CONT_TOTA_LOCA AS PRECIOCONTABLETOTALLOCAL, ");
		sql.append(" IMP_DES1_TOTA_LOCA AS IMPORTEDESCUENTO1TOTALLOCAL, ");
		/*IMP_DES1_IMPU AS importeDescuento1SinImpuestosTotalLocal, identifier too long */
		sql.append(" IMP_DES1_IMPU AS IMPORTEDESCUSINIMPUTOTALLOCAL, ");
		sql.append(" VAL_PREC_FACT_TOTA_LOCA AS PRECIOFACTURATOTALLOCAL, ");
		sql.append(" VAL_PREC_TOTA_TOTA_LOCA AS PRECIOTOTALTOTALLOCAL, ");
		/*IMP_DES3_IMPU AS importeDescuento3SinImpuestosTotalLocal, identifier too long */
		sql.append(" IMP_DES3_IMPU AS IMPORTEDESCU3SINIMPUTOTALLOCAL, ");
		sql.append(" IMP_DESC_TOTA_LOCA AS IMPORTEDESCUENTOTOTALLOCAL, ");
		sql.append(" VAL_PREC_NETO_TOTA_LOCA AS PRECIONETOTOTALLOCAL, ");
		sql.append(" IMP_IMPU_TOTA_LOCA AS IMPORTEIMPUESTOSTOTALLOCAL, ");
		sql.append(" VAL_TOTA_PAGA_LOCA AS TOTALAPAGARLOCAL, ");
		sql.append(" VAL_TOTA_PAGA_DOCU AS TOTALAPAGARDOCUMENTO, ");
		sql.append(" IMP_REDO_LOCA AS IMPORTEREDONDEOLOCAL, ");
		/*IMP_REDO_CONS_LOCA AS importeRedondeoConsolidadoLocal, identifier too long */
		sql.append(" IMP_REDO_CONS_LOCA AS IMPORTEREDONDEOCONSOLOCAL, ");
		sql.append(" NUM_UNID_ATEN_TOTA AS UNIDADESATENDIDAS, ");
		sql.append(" VAL_PREC_CATA_TOTA_DOCU AS PRECIOCATALOGOTOTALDOCUMENTO, ");
		/*VAL_PREC_CATA_SIN_IMPU_TOTA AS precioCatalogoSinImpuestoTotalDocumento, identifier too long */
		sql.append(" VAL_PREC_CATA_SIN_IMPU_TOTA AS PRECIOCATASINIMPUTOTALDOCU, ");
		sql.append(" VAL_PREC_CONT_TOTA_DOCU AS PRECIOCONTABLETOTALDOCUMENTO, ");
		/*VAL_PREC_CONT_SIN_IMPU_TOTA AS precioContableSinImpuestoTotalDocumento, identifier too long */
		sql.append(" VAL_PREC_CONT_SIN_IMPU_TOTA AS PRECIOCONTASINIMPUTOTALDOCU, ");
		/*IMP_DES1_TOTA_DOCU AS importeDescuento1TotalDocumento,  identifier too long */
		sql.append(" IMP_DES1_TOTA_DOCU AS IMPORTEDESCUTOTALDOCU, ");
		/*IMP_DES1_SIN_IMPU_TOTA AS importeDescuento1SinImpuestosTotalDocumento,  identifier too long */
		sql.append(" IMP_DES1_SIN_IMPU_TOTA AS IMPORTEDESCU1SINIMPUTOTALDOCU, ");
		/*IMP_DES3_SIN_IMPU_TOTA AS importeDescuento3SinImpuestoTotalDocumento,  identifier too long */
		sql.append(" IMP_DES3_SIN_IMPU_TOTA AS IMPORTEDESCU3SINIMPUTOTALDOCU, ");  
		sql.append(" IMP_DESC_TOTA_DOCU AS IMPORTEDESCUENTOTOTALDOCUMENTO, ");
		sql.append(" VAL_PREC_FACT_TOTA_DOCU AS PRECIOFACTURATOTALDOCUMENTO, ");
		sql.append(" IMP_IMPU_TOTA_DOCU AS IMPORTEIMPUESTOSTOTALDOCUMENTO, ");
		sql.append(" VAL_PREC_TOTA_TOTA_DOCU AS PRECIOTOTALTOTALDOCUMENTO ");
		sql.append(" FROM FAC_DOCUM_CONTA_CABEC ");

		sql.append(" WHERE OID_CABE IN ( ");

		Long[] oids = listaOIDs.getOids();
		Vector parametrosVector = new Vector();
		int tam = oids.length;

		// Añadimos los parámetros a la estructura IN de la SQL
		for(int i=0; i<tam; i++) {
			sql.append("?, ");
			parametrosVector.add(oids[i]);
		}
		// Si hay más de un elemento, es decir si entramos en el for anterior, borramos la coma
		// del final
		if(tam>0) { 
			sql = sql.deleteCharAt(sql.length()-2);
		}
		// Añadimos el cierre de paréntesis
		sql.append(")");
		
		RecordSet rs = null;
		BelcorpService bs = null;
		
		bs = BelcorpService.getInstance();
		
		try {
			rs = bs.dbService.executePreparedQuery(sql.toString(), parametrosVector);
		} catch (Exception e) {
			throw new MareException(e, UtilidadesError.armarCodigoError(
									CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}

		// Para cada elemento del recordset, se encapsula en el DTO y de ahí a la lista
		DTOFACCabeceraDocContable dtoCabecera = null;
		tam = rs.getRowCount();
		ArrayList salida = new ArrayList(tam);

		// Los setters que se encuentran comentados están así porque no se encuentran esos campos
		// en la tabla y están también comentados en la select
		for(int i = 0; i<tam; i++) {
			dtoCabecera = new DTOFACCabeceraDocContable();

			if(rs.getValueAt(i, "CODIGOALMACEN")!=null){
				//dtoCabecera.setCodigoAlmacen(rs.getValueAt(i, "CODIGOALMACEN").toString());
                dtoCabecera.setCodigoAlmacen(((BigDecimal)rs.getValueAt(i,"CODIGOALMACEN")).toString());
			}
			if(rs.getValueAt(i, "EJERCICIODOCUCONTAINTE")!=null){
				dtoCabecera.setEjercicioDocumentoContableInterno(rs.getValueAt(i, "EJERCICIODOCUCONTAINTE").toString());
			}
			if(rs.getValueAt(i, "ESTADO")!=null){
				dtoCabecera.setEstado(new Long(((BigDecimal)rs.getValueAt(i, "ESTADO")).toString()));
			}
			if(rs.getValueAt(i, "FECHAEMISION")!=null){
				dtoCabecera.setFechaEmision((Date)rs.getValueAt(i, "FECHAEMISION"));
			}
			if(rs.getValueAt(i, "FECHAFACTURACION")!=null){
				dtoCabecera.setFechaFacturacion((Date)rs.getValueAt(i, "FECHAFACTURACION"));
			}
			if(rs.getValueAt(i, "FORMAPAGO")!=null){
				dtoCabecera.setFormaPago(new Long(((BigDecimal)rs.getValueAt(i, "FORMAPAGO")).toString()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCU3TOTALDOCU")!=null){
				dtoCabecera.setImporteDescuento3TotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCU3TOTALDOCU")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCUENTO3TOTALLOCAL")!=null){
				dtoCabecera.setImporteDescuento3TotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCUENTO3TOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEFLETETOTALDOCUMENTO")!=null){
				dtoCabecera.setImporteFleteTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEFLETETOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEFLETETOTALLOCAL")!=null){
				dtoCabecera.setImporteFleteTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEFLETETOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEFLETESINIMPUTOTALLOCAL")!=null){
				dtoCabecera.setImporteFleteSinImpuestosTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEFLETESINIMPUTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "INDICADORIMPRESION")!=null){
				dtoCabecera.setIndicadorImpresion(new Boolean(rs.getValueAt(i, "INDICADORIMPRESION").toString()));
			}
			// No está en base de datos. Eliminado por la BELC300011174
//			dtoCabecera.setMarcaConsolidado();
			if(rs.getValueAt(i, "MONEDA")!=null){
				dtoCabecera.setMoneda(new Long(((BigDecimal)rs.getValueAt(i, "MONEDA")).toString()));
			}
			if(rs.getValueAt(i, "NUMERODOCUMENTOINTERNO")!=null){
				dtoCabecera.setNumeroDocumentoInterno(new Integer(((BigDecimal)rs.getValueAt(i, "NUMERODOCUMENTOINTERNO")).toString()));
			}
			if(rs.getValueAt(i, "NUMERODOCUMENTOORIGEN")!=null){
				dtoCabecera.setNumeroDocumentoOrigen(new Long(((BigDecimal)rs.getValueAt(i, "NUMERODOCUMENTOORIGEN")).toString()));
			}
			if(rs.getValueAt(i, "OBSERVACIONES")!=null){
				dtoCabecera.setObservaciones(rs.getValueAt(i, "OBSERVACIONES").toString());
			}
			if(rs.getValueAt(i, "OIDCABECERASOLICITUD")!=null){
				dtoCabecera.setOidCabeceraSolicitud(new Long(((BigDecimal)rs.getValueAt(i, "OIDCABECERASOLICITUD")).toString()));
			}
			if(rs.getValueAt(i, "OIDSOLICITUD")!=null){
				dtoCabecera.setOidSolicitud(new Long(((BigDecimal)rs.getValueAt(i, "OIDSOLICITUD")).toString()));
			}
			if(rs.getValueAt(i, "PAIS")!=null){
				dtoCabecera.setOidPais(new Long(((BigDecimal)rs.getValueAt(i, "PAIS")).toString()));
			}
			if(rs.getValueAt(i, "PERIODO")!=null){
				dtoCabecera.setPeriodo(new Long(((BigDecimal)rs.getValueAt(i, "PERIODO")).toString()));
			}
			if(rs.getValueAt(i, "PUNTOEMISION")!=null){
				dtoCabecera.setPuntoEmision(rs.getValueAt(i, "PUNTOEMISION").toString());
			}
			if(rs.getValueAt(i, "REGION")!=null){
				dtoCabecera.setRegion(new Long(((BigDecimal)rs.getValueAt(i, "REGION")).toString()));
			}
			if(rs.getValueAt(i, "SECCION")!=null){
				dtoCabecera.setSeccion(new Long(((BigDecimal)rs.getValueAt(i, "SECCION")).toString()));
			}
			if(rs.getValueAt(i, "SOCIEDAD")!=null){
				dtoCabecera.setSociedad(new Long(((BigDecimal)rs.getValueAt(i, "SOCIEDAD")).toString()));
			}
			if(rs.getValueAt(i, "SUBACCESO")!=null){
				dtoCabecera.setSubacceso(new Long(((BigDecimal)rs.getValueAt(i, "SUBACCESO")).toString()));
			}
			if(rs.getValueAt(i, "SUBGERENCIA")!=null){
				dtoCabecera.setSubgerencia(new Long(((BigDecimal)rs.getValueAt(i, "SUBGERENCIA")).toString()));
			}
			// No está en base de datos. Eliminado por la BELC300011174
//			dtoCabecera.setSubtipoCliente();
			if(rs.getValueAt(i, "TERRITORIO")!=null){
				dtoCabecera.setTerritorio(new Long(((BigDecimal)rs.getValueAt(i, "TERRITORIO")).toString()));
			}
			if(rs.getValueAt(i, "TIPOCAMBIO")!=null){
				dtoCabecera.setTipoCambio((BigDecimal)rs.getValueAt(i, "TIPOCAMBIO"));
			}
			// No está en base de datos. Eliminado por la BELC300011174
//			dtoCabecera.setTipoCliente();
			if(rs.getValueAt(i, "TIPODOCUMENTOLEGAL")!=null){
				dtoCabecera.setTipoDocumentoLegal(new Long(((BigDecimal)rs.getValueAt(i, "TIPODOCUMENTOLEGAL")).toString()));
			}
			// No está en base de datos. Eliminado por la BELC300011174
//			dtoCabecera.setTipoSolicitud();
			if(rs.getValueAt(i, "NUMEROABONO")!=null){
				dtoCabecera.setNumeroAbono(new Long(((BigDecimal)rs.getValueAt(i, "NUMEROABONO")).toString()));
			}
			if(rs.getValueAt(i, "OIDCLIENTEDIRECCION")!=null){
				dtoCabecera.setOidClienteDireccion(new Long(((BigDecimal)rs.getValueAt(i, "OIDCLIENTEDIRECCION")).toString()));
			}
			//dtoCabecera.setOidCliente();
            
			if(rs.getValueAt(i, "OIDCLIENTE")!=null){
				dtoCabecera.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i, "OIDCLIENTE")).toString()));
			}

			if(rs.getValueAt(i, "OIDFORMULARIO")!=null){
				dtoCabecera.setOidFormulario(new Long(((BigDecimal)rs.getValueAt(i, "OIDFORMULARIO")).toString()));
			}
			if(rs.getValueAt(i, "TIPODIRECCION")!=null){
				dtoCabecera.setTipoDireccion(rs.getValueAt(i, "TIPODIRECCION").toString());
			}
			if(rs.getValueAt(i, "ZONA")!=null){
				dtoCabecera.setZona(new Long(((BigDecimal)rs.getValueAt(i, "ZONA")).longValue()));
			}
            // NOMBRE1, NOMBRE2, APELLIDO1 y APELLIDO2 pasan a ser nullables.
            // Si vienen nulos, se asignará cadena vacía al dto
			dtoCabecera.setApellido1(rs.getValueAt(i, "APELLIDO1")!=null?
                                    rs.getValueAt(i, "APELLIDO1").toString():"");
			dtoCabecera.setApellido2(rs.getValueAt(i, "APELLIDO2")!=null?
                                    rs.getValueAt(i, "APELLIDO2").toString():"");
			dtoCabecera.setNombre1(rs.getValueAt(i, "NOMBRE1")!=null?
                                    rs.getValueAt(i, "NOMBRE1").toString():"");
			dtoCabecera.setNombre2(rs.getValueAt(i, "NOMBRE2")!=null?
                                    rs.getValueAt(i, "NOMBRE2").toString():"");

			if(rs.getValueAt(i, "NUMERODOCUMENTOLEGAL")!=null){
				dtoCabecera.setNumeroDocumentoLegal(new Integer(((BigDecimal)rs.getValueAt(i, "NUMERODOCUMENTOLEGAL")).toString()));
			}
			if(rs.getValueAt(i, "NUMEROIDENTIFICACIONFISCAL")!=null){
				dtoCabecera.setNumeroIdentificacionFiscal(rs.getValueAt(i, "NUMEROIDENTIFICACIONFISCAL").toString());
			}
			if(rs.getValueAt(i, "NUMEROIDENTIFICACIONNACIONAL")!=null){
				dtoCabecera.setNumeroIdentificacionNacional(rs.getValueAt(i, "NUMEROIDENTIFICACIONNACIONAL").toString());
			}
			if(rs.getValueAt(i, "SERIEDOCUMENTOLEGAL")!=null){
				dtoCabecera.setSerieDocumentoLegal(rs.getValueAt(i, "SERIEDOCUMENTOLEGAL").toString());
			}
			if(rs.getValueAt(i, "PRECIOCATASINIMPUTOTALLOCAL")!=null){
				dtoCabecera.setPrecioCatalogoSinImpuestoTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCATASINIMPUTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOCONTASINIMPUTOTALLOCAL")!=null){
				dtoCabecera.setPrecioContableSinImpuestoTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCONTASINIMPUTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOCATATLOCLUNIDAPORATNDR")!=null){
				dtoCabecera.setPrecioCatalogoTotalLocalUnidadesPorAtender(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCATATLOCLUNIDAPORATNDR")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOCATALOGOTOTALLOCAL")!=null){
				dtoCabecera.setPrecioCatalogoTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCATALOGOTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOCONTABLETOTALLOCAL")!=null){
				dtoCabecera.setPrecioContableTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCONTABLETOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCUENTO1TOTALLOCAL")!=null){
				dtoCabecera.setImporteDescuento1TotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCUENTO1TOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCUSINIMPUTOTALLOCAL")!=null){
				dtoCabecera.setImporteDescuento1SinImpuestosTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCUSINIMPUTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOFACTURATOTALLOCAL")!=null){
				dtoCabecera.setPrecioFacturaTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOFACTURATOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOTOTALTOTALLOCAL")!=null){
				dtoCabecera.setPrecioTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOTOTALTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCU3SINIMPUTOTALLOCAL")!=null){
				dtoCabecera.setImporteDescuento3SinImpuestosTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCU3SINIMPUTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCUENTOTOTALLOCAL")!=null){
				dtoCabecera.setImporteDescuentoTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCUENTOTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIONETOTOTALLOCAL")!=null){
				dtoCabecera.setPrecioNetoTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "PRECIONETOTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEIMPUESTOSTOTALLOCAL")!=null){
				dtoCabecera.setImporteImpuestosTotalLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEIMPUESTOSTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "TOTALAPAGARLOCAL")!=null){
				dtoCabecera.setTotalAPagarLocal(new Float(((BigDecimal)rs.getValueAt(i, "TOTALAPAGARLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "TOTALAPAGARDOCUMENTO")!=null){
				dtoCabecera.setTotalAPagarDocumento(new Float(((BigDecimal)rs.getValueAt(i, "TOTALAPAGARDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEREDONDEOLOCAL")!=null){
				dtoCabecera.setImporteRedondeoLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEREDONDEOLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEREDONDEOCONSOLOCAL")!=null){
				dtoCabecera.setImporteRedondeoConsolidadoLocal(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEREDONDEOCONSOLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i, "UNIDADESATENDIDAS")!=null){
				dtoCabecera.setUnidadesAtendidasTotal(new Integer(((BigDecimal)rs.getValueAt(i, "UNIDADESATENDIDAS")).toString()));
			}
			if(rs.getValueAt(i, "PRECIOCATALOGOTOTALDOCUMENTO")!=null){
				dtoCabecera.setPrecioCatalogoTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCATALOGOTOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOCATASINIMPUTOTALDOCU")!=null){
				dtoCabecera.setPrecioCatalogoSinImpuestosTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCATASINIMPUTOTALDOCU")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOCONTABLETOTALDOCUMENTO")!=null){
				dtoCabecera.setPrecioContableTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCONTABLETOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOCONTASINIMPUTOTALDOCU")!=null){
				dtoCabecera.setPrecioContableSinImpuestosTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOCONTASINIMPUTOTALDOCU")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCUTOTALDOCU")!=null){
				dtoCabecera.setImporteDescuento1TotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCUTOTALDOCU")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCU1SINIMPUTOTALDOCU")!=null){
				dtoCabecera.setImporteDescuento1SinImpuestosTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCU1SINIMPUTOTALDOCU")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCU3SINIMPUTOTALDOCU")!=null){
				dtoCabecera.setImporteDescuento3SinImpuestosTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCU3SINIMPUTOTALDOCU")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEDESCUENTOTOTALDOCUMENTO")!=null){
				dtoCabecera.setImporteDescuentoTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEDESCUENTOTOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOFACTURATOTALDOCUMENTO")!=null){
				dtoCabecera.setPrecioFacturaTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOFACTURATOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i, "IMPORTEIMPUESTOSTOTALDOCUMENTO")!=null){
				dtoCabecera.setImporteImpuestosTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "IMPORTEIMPUESTOSTOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i, "PRECIOTOTALTOTALDOCUMENTO")!=null){
				dtoCabecera.setPrecioTotalTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i, "PRECIOTOTALTOTALDOCUMENTO")).floatValue()));
			}
			
			salida.add(dtoCabecera);
		}

		UtilidadesLog.info("DAOFACDocumentoContable.obtenerCabecerasDC (DTOOIDs listaOIDs): Salida");        
		return salida;
	}
	
    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("DAOFACDocumentoContable.logSql(String metodo, String sql, Vector params): Entrada");        
        //UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            //UtilidadesLog.debug(metodo + sParams);
        }
        UtilidadesLog.info("DAOFACDocumentoContable.logSql(String metodo, String sql, Vector params): Salida");        
    }

	private String convertirArrayToString(Long[] oids){
        UtilidadesLog.info("DAOFACDocumentoContable.convertirArrayToString(Long[] oids): Entrada");        
		String retorno = "";
		if((oids!=null)&&(oids.length!=0)){
				StringBuffer sentencia = new StringBuffer("");
				for(int i=0;i<oids.length;i++){
						//UtilidadesLog.debug("\n array[ ]=" + oids[i]);
						if(oids[i]!=null){
								sentencia.append(" ?, ");
						}
				}
				//Quitamos la coma y el espacio del final
				if (sentencia.length() > 0)
					retorno= sentencia.substring(0,sentencia.length()-2);
				 
		}else{
            UtilidadesLog.info("DAOFACDocumentoContable.convertirArrayToString(Long[] oids): Salida");        			
			return "";
		}
        UtilidadesLog.info("DAOFACDocumentoContable.convertirArrayToString(Long[] oids): Salida");        			
		return retorno;
	}
    
    private  String convertirArrayToString(ArrayList array){
        
		String retorno = "";
        if((array!=null)&&(array.size()!=0)){
			
            StringBuffer sentencia = new StringBuffer("");
            for(int i=0;i<array.size();i++){
                
                if(array.get(i)!=null){
                    sentencia.append(" ?, ");
                }
            }
            //Quitamos la coma y el espacio del final
            retorno= sentencia.substring(0,sentencia.length()-2);
            
        }else{
			return "";
		}
		return retorno;
	}//metodo

	private String convertirFecha(Date fecha) {
        UtilidadesLog.info("DAOFACDocumentoContable.convertirFecha(Date fecha): Entrada");        			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
		String sFechaDesde = sdf.format(fechaDesde);                          
        UtilidadesLog.info("DAOFACDocumentoContable.convertirFecha(Date fecha): Salida");        			
		return sFechaDesde;
	}
    
    //@ssaavedr(19/09/2005), metodo nuevo producto de la inc.: BELC300020920, que se asocia
    //con la: BELC300020843.   
    //Este método lo tendremos que invocar en el método MONImpresionSICC.generarDocFactura 
    // justo despues de la invocación al método spoolManager.addPrintableDocuments (este 
    // método se llama en 3 sitios: en el bucle que genera los documentos legales , en el 
    // de no legales y en el de mensajes). Se le invocará pasandole el siguiente parámetro
    // miDTODocLegal.DTOFACDocumentoContable.DTOFACDocumentoContableCabecera.oidCabecera.
    //Se invocará por lo tanto tantas veces como documentos se generen.
    //Modificado por mchamorro (07/10/2005)-> Recibe un array en vez de un long
    
    public void marcarDocumentoComoImpreso(ArrayList oidsCabecera) throws MareException {
        UtilidadesLog.info("DAOFACDocumentoContable.marcarDocumentoComoImpreso(ArrayList oidsCabecera): Entrada");
        
        Vector parametros = new Vector();
		StringBuffer consulta = new StringBuffer();
        
        //convertimos el array en string
        String listaCabeceras =this.convertirArrayToString(oidsCabecera);

        consulta.append("UPDATE FAC_DOCUM_CONTA_CABEC ");
        consulta.append("SET IND_IMPR = 1 ");
        consulta.append("WHERE OID_CABE IN (" +listaCabeceras+ ")" );
        //parametros.add(oidDocumento);
        
        for(int k=0;k< oidsCabecera.size();k++){
            if(oidsCabecera.get(k)!=null){
            //si es distinto de null lo pasamos a vector de la select.
                parametros.add(oidsCabecera.get(k));
            }
		}

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;        

        try {
            this.logSql("Marcamos ind_impr a verdadero para oid de cabecera: ", consulta.toString(), parametros);
    		bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOFACDocumentoContable.marcarDocumentoComoImpreso(ArrayList oidsCabecera): Salida");
    }     
 
}

	