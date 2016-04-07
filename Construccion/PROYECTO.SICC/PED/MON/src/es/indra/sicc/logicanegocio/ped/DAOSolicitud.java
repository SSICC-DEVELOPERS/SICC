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
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.bel.DTOObtenerNotasCreditoPendientes;
import es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro;
import es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados;
import es.indra.sicc.dtos.car.DTOCalculoPedidos;
import es.indra.sicc.dtos.dto.DTOBuscarSolicitudesDTO;
import es.indra.sicc.dtos.dto.DTOObtenerCabeceraDTO;
import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesCriterio;
import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesGrupo;
import es.indra.sicc.dtos.ped.DTOBuscarSolicitud;
import es.indra.sicc.dtos.ped.DTOBuscarSolicitudVerificacion;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOCalcularTotales;
import es.indra.sicc.dtos.ped.DTODatosAnulacion;
import es.indra.sicc.dtos.ped.DTOEGrupoReversion;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;
import es.indra.sicc.dtos.ped.DTOListaSolicitudes;
import es.indra.sicc.dtos.ped.DTOPeriodoDocumentoReferencia;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.dtos.ped.DTOSolicitudLimiteCredito;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOTipifYUnidadAdminCliente;
import es.indra.sicc.dtos.ped.DTOTipificacion;
import es.indra.sicc.dtos.ped.applet.DTOPresentarFlete;
import es.indra.sicc.dtos.ped.applet.DTOSolicitudesAnteriores;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.rec.DTOInsertarResultadoChequeo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.seg.MonedaLocal;
import es.indra.sicc.entidades.seg.MonedaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.dto.UtilidadesDTO;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DAOSolicitud {
    private SessionContext ctx;
	private static UtilidadesLog logAux = new UtilidadesLog();
	
    public DAOSolicitud() {
    }

    private BelcorpService getBelcorpService() throws MareException {
        try {
            BelcorpService bs = BelcorpService.getInstance();
            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }

    /**
     * Se obtienen los acumulados de venta para el mismo periodo y cliente que la solicitud de entrada.
     * Devuelve la suma de monto venta y la suma de numeto de unidades por atender de posiciones agrupadas
     * por el criterio de base calculo descuento y anulacion/devolucion.
     * No se incluyen las posiciones de la solicitud de referencia.
     * No se incluyen las posiciones con estado nulo o bloqueado o anulado. 
     * @autor gdmarzi
     */
    public DTOSalida obtenerPosicionesAcumuladasPeriodoClienteBaseCalculoDTO(Long oidSolicitud, Long oidPeriodo, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesPeriodoDTO(Long oidCabecera): Entrada ");
        BelcorpService belcorpService;
        RecordSet rsPosicionesPeriodo;
        String codigoError;
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" SELECT ");
        stringBuffer.append("  SUM (POS.NUM_UNID_POR_ATEN * POS.VAL_PREC_CATA_UNIT_LOCA) sumaAgrupadaMontoVentaPosicion,");
        stringBuffer.append("  SUM (POS.NUM_UNID_POR_ATEN) sumaAgrupadaUnidadesPorAtender, ");
        stringBuffer.append("  PRO.MAPR_OID_MARC_PROD oidMarcaProducto, ");
        stringBuffer.append("  PRO.UNEG_OID_UNID_NEGO oidUnidadNegocio, ");
        stringBuffer.append("  PRO.NEGO_OID_NEGO oidNegocio, ");
        stringBuffer.append("  PRO.SGEN_OID_SUPE_GENE oidSuperGenerico, ");
        stringBuffer.append("  PRO.GENE_OID_GENE oidGenerico, ");
        stringBuffer.append("  DET.TOFE_OID_TIPO_OFER oidTipoOferta, ");
        stringBuffer.append("  DET.CIVI_OID_CICLO_VIDA oidCicloVida, ");
        stringBuffer.append("  POS.PROD_OID_PROD oidProducto, ");
        stringBuffer.append("  decode(TS.IND_DEVO,1,'true','false') indicadorDevolucion, ");
        stringBuffer.append("  decode(TS.IND_ANUL,1,'true','false') indicadorAnulacion ");
        stringBuffer.append(" FROM ");
        stringBuffer.append("  PED_SOLIC_CABEC CAB, PED_SOLIC_POSIC POS, ");
        stringBuffer.append("  PRE_OFERT_DETAL DET, MAE_PRODU PRO, PRE_TIPO_OFERT TIP, ");
        stringBuffer.append("  PED_TIPO_SOLIC_PAIS TSP , PED_TIPO_SOLIC TS, ped_solic_cabec cab2 ");
        stringBuffer.append(" WHERE ");
        stringBuffer.append("  CAB.OID_SOLI_CABE <> ? ");
        stringBuffer.append("  AND CAB.PERD_OID_PERI = ? ");
        stringBuffer.append("  AND CAB.CLIE_OID_CLIE = ? ");
        stringBuffer.append("  AND CAB.OID_SOLI_CABE = POS.SOCA_OID_SOLI_CABE ");
        stringBuffer.append("  AND POS.OFDE_OID_DETA_OFER = DET.OID_DETA_OFER ");
        stringBuffer.append("  AND PRO.OID_PROD = POS.PROD_OID_PROD ");
        stringBuffer.append("  AND TIP.OID_TIPO_OFER = DET.TOFE_OID_TIPO_OFER ");
        stringBuffer.append("  AND POS.ESPO_OID_ESTA_POSI is not null ");
        stringBuffer.append("  AND POS.ESPO_OID_ESTA_POSI <> ? ");
        stringBuffer.append("  AND POS.ESPO_OID_ESTA_POSI <> ? ");
        stringBuffer.append("  AND TIP.IND_APOR_MONT_ESCA = 1 ");
        stringBuffer.append("  AND CAB.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        stringBuffer.append("  AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        stringBuffer.append("  AND cab.SOCA_OID_DOCU_REFE = cab2.OID_SOLI_CABE(+) ");
        stringBuffer.append("  AND (cab2.PERD_OID_PERI = ? or cab2.PERD_OID_PERI is null) ");
        stringBuffer.append("  AND cab.ESSO_OID_ESTA_SOLI <> ? ");
        stringBuffer.append(" GROUP BY ");
        stringBuffer.append("  MAPR_OID_MARC_PROD, UNEG_OID_UNID_NEGO, NEGO_OID_NEGO, ");
        stringBuffer.append("  SGEN_OID_SUPE_GENE, GENE_OID_GENE, TOFE_OID_TIPO_OFER, ");
        stringBuffer.append("  CIVI_OID_CICLO_VIDA, POS.PROD_OID_PROD, TS.IND_DEVO, TS.IND_ANUL ");

        Vector parametros = new Vector();
        parametros.add(oidSolicitud);
        parametros.add(oidPeriodo);
        parametros.add(oidCliente);
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        parametros.add(ConstantesPED.ESTADO_POSICION_BLOQUEADO);
        parametros.add(oidPeriodo);
        parametros.add(ConstantesPED.ESTADO_SOLICITUD_RECHAZADO);
        
        try {
            rsPosicionesPeriodo = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(), parametros);
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rsPosicionesPeriodo);
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesPeriodoDTO(Long oidCabecera): Salida ");
        return dtoSalida;
    }


    public void eliminarSolicitudesGrupo(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("DAOSolicitud.eliminarSolicitudesGrupo(DTOOIDs dto): Entrada ");
        Long[] list = (dto == null) ? null : dto.getOids();

        if ((dto == null) || (list == null) || (list.length < 1)) {
            return;
        }

        try {
            StringBuffer listBuffer = new StringBuffer();
            listBuffer.append(list[0]);

            for (int i = 1; i < list.length; i++) {
                listBuffer.append(", ").append(list[i]);
            }

            StringBuffer query = new StringBuffer();

            query.append("update PED_SOLIC_CABEC a ")
                 .append("set a.VAL_GRUP_REVE=NULL ")
                 .append(" where  a.OID_SOLI_CABE in (").append(listBuffer)
                 .append(") ").append(" and TSPA_OID_TIPO_SOLI_PAIS in ")
                 .append("   (select OID_TIPO_SOLI_PAIS ")
                 .append("   from PED_TIPO_SOLIC_PAIS b ").append("   where b.IND_PERM_REVE=1)  ");

            BelcorpService bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.eliminarSolicitudesGrupo(DTOOIDs dto): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public RecordSet obtenerSolicitudesPorConsolidado(Long consolidado) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudesPorConsolidado(Long consolidado): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" select OID_SOLI_CABE ");
            buf.append(" from PED_SOLIC_CABEC ");
            buf.append(" WHERE ");
            buf.append(" SOCA_OID_SOLI_CABE = '" + consolidado.longValue() + "'");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudesPorConsolidado(Long consolidado): Salida ");
        return respuesta;
    }

    /**
     * Obtiene el periodo correspondiente al documento de referencia para la soliitud recibida como parámetro.
     */
    public DTOPeriodoDocumentoReferencia obtenerPeriodoDocumentoReferencia(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerPeriodoDocumentoReferencia(Long oidSolicitud): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet rsSolicitudOidPeriodo;
        DTOPeriodoDocumentoReferencia dtoPeriodoDocumentoReferencia = new DTOPeriodoDocumentoReferencia();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT PED_SOLIC_CABEC_DOS.PERD_OID_PERI, CRA_PERIO.VAL_NOMB_PERI ");
            query.append(" FROM PED_SOLIC_CABEC, PED_SOLIC_CABEC PED_SOLIC_CABEC_DOS, CRA_PERIO ");
            query.append(" WHERE PED_SOLIC_CABEC.OID_SOLI_CABE = ? ");
            query.append(" AND PED_SOLIC_CABEC_DOS.OID_SOLI_CABE = PED_SOLIC_CABEC.SOCA_OID_DOCU_REFE ");
            query.append(" AND CRA_PERIO.OID_PERI = PED_SOLIC_CABEC_DOS.PERD_OID_PERI ");

            Vector parametros = new Vector();
            parametros.add(oidSolicitud);

            rsSolicitudOidPeriodo = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long oidPeriodo = new Long(((BigDecimal) rsSolicitudOidPeriodo.getValueAt(0, "PERD_OID_PERI")).longValue());
        String nombrePeriodo = rsSolicitudOidPeriodo.getValueAt(0, "VAL_NOMB_PERI").toString();

        dtoPeriodoDocumentoReferencia.setPeriodoDocumentoReferencia(oidPeriodo);
        dtoPeriodoDocumentoReferencia.setNombrePeriodoDocumentoReferencia(nombrePeriodo);

        UtilidadesLog.info("DAOSolicitud.obtenerPeriodoDocumentoReferencia(Long oidSolicitud): Salida ");
        return dtoPeriodoDocumentoReferencia;
    }

    /**
     * Este metodo realiza una operación UPDATE sobre la entidad PED:SolicitudPosicion actualizando los valores siguiente a NULL
     */
    public void borrarPreciosSolicitud(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.borrarPreciosSolicitud(Long oidSolicitud): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            query.append(" UPDATE PED_SOLIC_POSIC ");
            query.append(" SET ");
            query.append(" VAL_PREC_CATA_UNIT_LOCA = 0, ");
            query.append(" VAL_PREC_CONT_UNIT_LOCA = 0, ");
            query.append(" VAL_PREC_CATA_UNIT_DOCU = 0, ");
            query.append(" VAL_PREC_CONTA_UNIT_DOCU = 0 ");
            query.append(" WHERE SOCA_OID_SOLI_CABE = " + oidSolicitud);
            query.append(" AND ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.borrarPreciosSolicitud(Long oidSolicitud): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void guardarCabecera(DTOCabeceraSolicitud DTOE) throws MareException {
        // Guarda una entrada en la tabla de SolicitudCabecera con la información contenida en DTOE 
        // En primer lugar obtengo el valor del oid que se asignará a la cabecera de la solicitud 
        UtilidadesLog.info("DAOSolicitud.guardarCabecera(DTOCabeceraSolicitud DTOE): Entrada ");
        DTOE.setOidCabeceraSolicitud(new Long(SecuenciadorOID.obtenerSiguienteValor("PED_SOCA_SEQ").longValue()));

        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("INSERT INTO PED_SOLIC_CABEC ( ");
            query.append(" ACFI_OID_ACCE_FISI, ");
            query.append(" ALMC_OID_ALMA, ");
            query.append(" CLDI_OID_CLIE_DIRE, ");
            query.append(" CLIE_OID_CLIE, ");
            query.append(" CLIE_OID_CLIE_DEST, ");
            query.append(" CLIE_OID_CLIE_PAGA, ");
            query.append(" CLIE_OID_CLIE_RECE_FACT, ");
            query.append(" CLIE_OID_CONS_ASOC, ");
            query.append(" CLSO_OID_CLAS_SOLI, ");
            query.append(" COPA_OID_PARA_GENE, ");
            query.append(" ESSO_OID_ESTA_SOLI, ");
            query.append(" FEC_CRON, ");
            query.append(" FEC_PROG_FACT, ");
            query.append(" FOPA_OID_FORM_PAGO, ");
            query.append(" GRPR_OID_GRUP_PROC, ");
            query.append(" IND_OC, ");
            query.append(" IND_PEDI_PRUE, ");
            query.append(" IND_PERM_UNIO_SOL, ");
            query.append(" IND_TS_NO_CONSO, ");
            query.append(" MODU_OID_MODU, ");
            query.append(" MONE_OID_MONE, ");
            query.append(" NUM_CLIEN, ");
            query.append(" NUM_DOCU_ORIG, ");
            query.append(" NUM_PREM, ");
            query.append(" OID_SOLI_CABE, ");
            query.append(" OPER_OID_OPER, ");
            query.append(" PAIS_OID_PAIS, ");
            query.append(" PERD_OID_PERI, ");
            query.append(" PROC_OID_PROC, ");
            query.append(" SBAC_OID_SBAC, ");
            query.append(" SBTI_OID_SUBT_CLIE, ");
            query.append(" SOCA_OID_DOCU_REFE, ");
            query.append(" SOCI_OID_SOCI, ");
            query.append(" TDOC_OID_TIPO_DOCU, ");
            query.append(" TERR_OID_TERR, ");
            query.append(" TICL_OID_TIPO_CLIE, ");
            query.append(" TIDO_OID_TIPO_DOCU, ");
            query.append(" TIDS_OID_TIPO_DESP, ");
            query.append(" TSPA_OID_TIPO_SOLI_PAIS, ");
            query.append(" TSPA_OID_TIPO_SOLI_PAIS_CONS, ");
            query.append(" VAL_GLOS_OBSE, ");
            query.append(" VAL_NUME_SOLI, ");
            query.append(" VAL_USUA, ");
            query.append(" VEPO_OID_VALO_ESTR_GEOP, ");
            query.append(" VAL_TIPO_CAMB, ");
            query.append(" ZZON_OID_ZONA, ");
            query.append(" ZTAD_OID_TERR_ADMI, "); 
            //jrivas 16/07/2007 FAC-003
            query.append(" ICTP_OID_TIPO_PROG "); 
            query.append(" ) VALUES ( ");
            query.append(DTOE.getAccesoFisico() + ", ");
            query.append(DTOE.getAlmacen() + ", ");
            query.append(DTOE.getDestino() + ", ");
            query.append(DTOE.getOidCliente() + ", ");
            query.append(DTOE.getDestinatario() + ", ");
            query.append(DTOE.getOidPagadorFactura() + ", ");
            query.append(DTOE.getOidReceptorFactura() + ", ");
            query.append(DTOE.getConsultoraAsociada() + ", ");
            query.append(DTOE.getClaseSolicitud() + ", ");
            query.append(DTOE.getOidConcursoParametros() + ", ");
            query.append(DTOE.getEstado() + ", ");
            query.append(" TO_Date( '" + DTOE.getFecha() + "', 'YYYY-MM-DD'), ");
            query.append(" TRUNC(TO_DATE (substr('" + DTOE.getFechaPrevistaFacturacion() +"', 1, 19), 'YYYY-MM-DD HH24:MI:SS')),  ");
            query.append(DTOE.getFormaPago() + ", ");
            query.append(ConstantesPED.GP1 + ", ");
            query.append(booleanALong(DTOE.getOrdenCompra()) + ", ");
            query.append(booleanALong(DTOE.getIndPedidoPrueba()) + ", ");
            query.append(booleanALong(DTOE.getPermiteUnionSolicitudes()) + ", ");
            query.append(booleanALong(DTOE.getIndTSNoConsolidado()) + ", ");
            query.append(DTOE.getModulo() + ", ");
            query.append(DTOE.getMoneda() + ", ");
            query.append(DTOE.getNumeroClientes() + ", ");
            query.append(DTOE.getNumeroDocumentoOrigen() + ", ");
            query.append(DTOE.getNumeroPremio() + ", ");
            query.append(DTOE.getOidCabeceraSolicitud() + ", ");
            query.append(DTOE.getOperacion() + ", ");
            query.append(DTOE.getOidPais() + ", ");
            query.append(DTOE.getPeriodo() + ", ");
            query.append(DTOE.getProceso() + ", ");
            query.append(DTOE.getSubacceso() + ", ");
            query.append(DTOE.getSubtipoCliente() + ", ");
            query.append(DTOE.getOidDocumentoReferencia() + ", ");
            query.append(DTOE.getSociedad() + ", ");
            query.append(DTOE.getTipoDocumento() + ", ");
            query.append(DTOE.getTerritorio() + ", ");
            query.append(DTOE.getTipoCliente() + ", ");
            query.append(DTOE.getTipoDocumentoLegal() + ", ");
            query.append(DTOE.getTipoDespacho() + ", ");
            query.append(DTOE.getTipoSolicitud() + ", ");
            query.append(DTOE.getTipoConsolidado() + ", ");
            if (DTOE.getObservaciones()!=null){
                query.append("'" + DTOE.getObservaciones() + "', ");
            }else{
                query.append(" NULL, ");
            }
            query.append(DTOE.getNumeroSolicitud() + ", ");
            query.append("'" + DTOE.getUsuario() + "', ");
            query.append(DTOE.getUbigeo() + ", ");
            query.append(DTOE.getTipoCambio() + ", ");
            query.append(DTOE.getZona() + ", ");
            query.append(DTOE.getOidTerritorioAdministrativo() + ", ");
            //jrivas 16/07/2007 FAC-003
            query.append(DTOE.getOidTipoProgramaIncentivos());
            query.append(");");

            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.guardarCabecera(DTOCabeceraSolicitud DTOE): Salida ");
    }


    /**
     * Guarda la información de una posicion de solicitud recibida.
     */
    public DTOPosicionSolicitud guardarPosicion(DTOPosicionSolicitud DTOE, Long oidCabeceraSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOPosicionSolicitud DTOE, Long oidCabeceraSolicitud): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        // Accede a la tabla PED_SOLIC_POSIC y guarda un registro con la siguiente información: 
        try {
            query.append(" INSERT INTO PED_SOLIC_POSIC ( ");
            query.append(" OID_SOLI_POSI, ");
            query.append(" SOCA_OID_SOLI_CABE, ");
            query.append(" COD_POSI, ");
            query.append(" NUM_UNID_DEMA, ");
            query.append(" NUM_UNID_POR_ATEN, ");
            query.append(" TPOS_OID_TIPO_POSI, ");
            query.append(" PROD_OID_PROD, ");
            query.append(" FOPA_OID_FORM_PAGO, ");
            query.append(" VAL_CODI_VENT, ");
            query.append(" ESPO_OID_ESTA_POSI, ");
            query.append(" STPO_OID_SUBT_POSI, ");
            query.append(" VAL_CODI_VENT_FICT, ");
            query.append(" NUM_UNID_DEMA_REAL, ");
            query.append(" VAL_PREC_CATA_UNIT_LOCA, ");
            query.append(" VAL_PREC_CONT_UNIT_LOCA, ");
            query.append(" VAL_PREC_CATA_UNIT_DOCU, ");
            query.append(" VAL_PREC_CONTA_UNIT_DOCU, ");
            query.append(" VAL_PORC_DESC, ");
            query.append(" VAL_IMPO_DESC_UNIT_DOCU, ");
            query.append(" OFDE_OID_DETA_OFER, ");
            query.append(" SOPO_OID_SOLI_POSI, ");
            query.append(" NUM_UNID_COMPR, ");
            query.append(" VAL_IMPO_DESC_UNIT_LOCA, ");
            query.append(" NUM_PAGI_CATA, ");
            query.append(" VAL_CATA ");
            query.append(" ) VALUES ( ");
            query.append("PED_SOPO_SEQ.NEXTVAL,");
            query.append(oidCabeceraSolicitud + ", ");
            query.append( "(select nvl((max (cod_posi))+1,0) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+oidCabeceraSolicitud+" ),");
            query.append(DTOE.getUnidadesDemandadas() + ", ");
            query.append(DTOE.getUnidadesPorAtender() + ", ");
            query.append(DTOE.getTipoPosicion() + ", ");
            query.append(DTOE.getProducto() + ", ");
            query.append(DTOE.getFormaPago() + ", ");
            query.append( ((DTOE.getCodigoVenta() != null) ? ("'" + DTOE.getCodigoVenta() + "'") : null) + ", " );
            query.append(DTOE.getEstadoPosicion() + ", ");
            query.append(DTOE.getSubtipoPosicion() + ", ");
            query.append(DTOE.getCodigoVentaFicticio() + ", ");
            query.append(DTOE.getUnidadesDemandaReal() + ", ");
            query.append(DTOE.getPrecioCatalogoUnitarioLocal() + ", ");
            query.append(DTOE.getPrecioContableUnitarioLocal() + ", ");
            query.append(DTOE.getPrecioCatalogoUnitarioDocumento() + ", ");
            query.append(DTOE.getPrecioContableUnitarioDocumento() + ", ");
            query.append(DTOE.getPorcentajeDescuento() + ", ");
            query.append(DTOE.getImporteDescuentoUnitarioDocumento() + ", ");
            query.append(DTOE.getOidDetalleOferta() + ", ");
            query.append(DTOE.getPosicionRecuperacion() + ", ");
            query.append(DTOE.getUnidadesComprometidas()+ ", ");
            query.append(DTOE.getImporteDescuentoUnitarioLocal()+ ", ");
            query.append(DTOE.getPagina()+ ", ");
            query.append(DTOE.getCatalogo());
            query.append(" ) ");

            int h = bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOPosicionSolicitud DTOE, Long oidCabeceraSolicitud): Salida ");
        return DTOE;
    }
    
    /**
     * Guarda la información de una posicion de solicitud recibida.
     */
    public DTOPosicionSolicitud guardarPosicion(DTOPosicionSolicitud DTOE, Long oidCabeceraSolicitud, Boolean indDigitacion) throws MareException {
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOPosicionSolicitud DTOE, Long oidCabeceraSolicitud): Entrada ");
       
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        // Accede a la tabla PED_SOLIC_POSIC y guarda un registro con la siguiente información: 
        try {
            query.append(" INSERT INTO PED_SOLIC_POSIC ( ");
            query.append(" OID_SOLI_POSI, ");
            query.append(" SOCA_OID_SOLI_CABE, ");
            query.append(" COD_POSI, ");
            query.append(" NUM_UNID_DEMA, ");
            query.append(" NUM_UNID_POR_ATEN, ");
            query.append(" TPOS_OID_TIPO_POSI, ");
            query.append(" PROD_OID_PROD, ");
            query.append(" FOPA_OID_FORM_PAGO, ");
            query.append(" VAL_CODI_VENT, ");
            query.append(" ESPO_OID_ESTA_POSI, ");
            query.append(" STPO_OID_SUBT_POSI, ");
            query.append(" VAL_CODI_VENT_FICT, ");
            query.append(" NUM_UNID_DEMA_REAL, ");
            query.append(" VAL_PREC_CATA_UNIT_LOCA, ");
            query.append(" VAL_PREC_CONT_UNIT_LOCA, ");
            query.append(" VAL_PREC_CATA_UNIT_DOCU, ");
            query.append(" VAL_PREC_CONTA_UNIT_DOCU, ");
            query.append(" VAL_PORC_DESC, ");
            query.append(" VAL_IMPO_DESC_UNIT_DOCU, ");
            query.append(" OFDE_OID_DETA_OFER, ");
            query.append(" SOPO_OID_SOLI_POSI, ");
            query.append(" NUM_UNID_COMPR, ");
            query.append(" VAL_IMPO_DESC_UNIT_LOCA, ");
            query.append(" NUM_PAGI_CATA, ");
            query.append(" VAL_CATA ");
            query.append(" ) VALUES ( ");
            query.append("PED_SOPO_SEQ.NEXTVAL,");
            query.append(oidCabeceraSolicitud + ", ");
            if (indDigitacion!=null && indDigitacion.booleanValue()){
                query.append( "(select nvl((max (cod_posi))+10,0) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+oidCabeceraSolicitud+" ),");
            }else{
                query.append( "(select nvl((max (cod_posi))+1,0) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+oidCabeceraSolicitud+" ),");
            }
            query.append(DTOE.getUnidadesDemandadas() + ", ");
            query.append(DTOE.getUnidadesPorAtender() + ", ");
            query.append(DTOE.getTipoPosicion() + ", ");
            query.append(DTOE.getProducto() + ", ");
            query.append(DTOE.getFormaPago() + ", ");
            query.append( ((DTOE.getCodigoVenta() != null) ? ("'" + DTOE.getCodigoVenta() + "'") : null) + ", " );
            query.append(DTOE.getEstadoPosicion() + ", ");
            query.append(DTOE.getSubtipoPosicion() + ", ");
            query.append(DTOE.getCodigoVentaFicticio() + ", ");
            query.append(DTOE.getUnidadesDemandaReal() + ", ");
            query.append(DTOE.getPrecioCatalogoUnitarioLocal() + ", ");
            query.append(DTOE.getPrecioContableUnitarioLocal() + ", ");
            query.append(DTOE.getPrecioCatalogoUnitarioDocumento() + ", ");
            query.append(DTOE.getPrecioContableUnitarioDocumento() + ", ");
            query.append(DTOE.getPorcentajeDescuento() + ", ");
            query.append(DTOE.getImporteDescuentoUnitarioDocumento() + ", ");
            query.append(DTOE.getOidDetalleOferta() + ", ");
            query.append(DTOE.getPosicionRecuperacion() + ", ");
            query.append(DTOE.getUnidadesComprometidas()+ ", ");
            query.append(DTOE.getImporteDescuentoUnitarioLocal()+ ", ");
            query.append(DTOE.getPagina()+ ", ");
            query.append(DTOE.getCatalogo());
            query.append(" ) ");

            int h = bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOPosicionSolicitud DTOE, Long oidCabeceraSolicitud): Salida ");
        return DTOE;
    }
    
    public StringBuffer generarGuardarPosicion(DTOPosicionSolicitud DTOE, Long oidCabeceraSolicitud, Boolean indDigitacion) throws MareException {
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        query.append("INSERT INTO PED_SOLIC_POSIC ( ");
        query.append(" OID_SOLI_POSI, ");
        query.append(" SOCA_OID_SOLI_CABE, ");
        query.append(" COD_POSI, ");
        query.append(" NUM_UNID_DEMA, ");
        query.append(" NUM_UNID_POR_ATEN, ");
        query.append(" TPOS_OID_TIPO_POSI, ");
        query.append(" PROD_OID_PROD, ");
        query.append(" FOPA_OID_FORM_PAGO, ");
        query.append(" VAL_CODI_VENT, ");
        query.append(" ESPO_OID_ESTA_POSI, ");
        query.append(" STPO_OID_SUBT_POSI, ");
        query.append(" VAL_CODI_VENT_FICT, ");
        query.append(" NUM_UNID_DEMA_REAL, ");
        query.append(" VAL_PREC_CATA_UNIT_LOCA, ");
        query.append(" VAL_PREC_CONT_UNIT_LOCA, ");
        query.append(" VAL_PREC_CATA_UNIT_DOCU, ");
        query.append(" VAL_PREC_CONTA_UNIT_DOCU, ");
        query.append(" VAL_PORC_DESC, ");
        query.append(" VAL_IMPO_DESC_UNIT_DOCU, ");
        query.append(" OFDE_OID_DETA_OFER, ");
        query.append(" SOPO_OID_SOLI_POSI, ");
        query.append(" NUM_UNID_COMPR, ");
        query.append(" VAL_IMPO_DESC_UNIT_LOCA, ");
        query.append(" NUM_PAGI_CATA, ");
        query.append(" VAL_CATA ");
        
        // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
        query.append(" ,ALMC_OID_ALMC ");
        
        query.append(" ) VALUES ( ");
        query.append("PED_SOPO_SEQ.NEXTVAL,");
        query.append(oidCabeceraSolicitud + ", ");
        if (indDigitacion!=null && indDigitacion.booleanValue()){
            query.append( "(select nvl((max (cod_posi))+10,0) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+oidCabeceraSolicitud+" ),");
        }else{
            query.append( "(select nvl((max (cod_posi))+1,0) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+oidCabeceraSolicitud+" ),");
        }
        query.append(DTOE.getUnidadesDemandadas() + ", ");
        query.append(DTOE.getUnidadesPorAtender() + ", ");
        query.append(DTOE.getTipoPosicion() + ", ");
        query.append(DTOE.getProducto() + ", ");
        query.append(DTOE.getFormaPago() + ", ");
        query.append( ((DTOE.getCodigoVenta() != null) ? ("'" + DTOE.getCodigoVenta() + "'") : null) + ", " );
        query.append(DTOE.getEstadoPosicion() + ", ");
        query.append(DTOE.getSubtipoPosicion() + ", ");
        query.append(DTOE.getCodigoVentaFicticio() + ", ");
        query.append(DTOE.getUnidadesDemandaReal() + ", ");
        query.append(DTOE.getPrecioCatalogoUnitarioLocal() + ", ");
        query.append(DTOE.getPrecioContableUnitarioLocal() + ", ");
        query.append(DTOE.getPrecioCatalogoUnitarioDocumento() + ", ");
        query.append(DTOE.getPrecioContableUnitarioDocumento() + ", ");
        query.append(DTOE.getPorcentajeDescuento() + ", ");
        query.append(DTOE.getImporteDescuentoUnitarioDocumento() + ", ");
        query.append(DTOE.getOidDetalleOferta() + ", ");
        query.append(DTOE.getPosicionRecuperacion() + ", ");
        query.append(DTOE.getUnidadesComprometidas()+ ", ");
        query.append(DTOE.getImporteDescuentoUnitarioLocal()+ ", ");
        query.append(DTOE.getPagina()+ ", ");
        query.append(DTOE.getCatalogo());
        
        // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
        query.append(", " + DTOE.getOidAlmacen());
        
        query.append(" );");
        return query;
    }


    public void asignarValoresDefectoCabecera(Long oidCabeceraSolicitud,
        Long oidTipoSolicitud, Long oidModulo) throws MareException {
        
        UtilidadesLog.info("DAOSolicitud.asignarValoresDefectoCabecera(Long oidCabeceraSolicitud, Long oidTipoSolicitud, Long oidModulo): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        ArrayList campos = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ate.cod_atri, vd.val_defe_oid, vd.val_valo_defe      ");
            query.append("   FROM ped_atrib_espec ate, ped_valor_defec_tipo_solic vd   ");
            query.append("  WHERE ate.modu_oid_modu = " + oidModulo);
            query.append("    AND ate.val_form = 'PED_SOLIC_CABEC' ");
            query.append("    AND vd.tspa_oid_tipo_soli_pais = " + oidTipoSolicitud);
            query.append("    AND vd.atre_oid_atri_espe = ate.oid_atri_espe ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta.esVacio()) {
            ArrayList PK = new ArrayList();
            PK.add(new String("OID_SOLI_CABE"));
            PK.add(new String(oidCabeceraSolicitud.toString()));
            campos.add(PK);

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ArrayList atributo = new ArrayList();
                atributo.add((String) respuesta.getValueAt(i, 0));

                if (respuesta.getValueAt(i, 1) != null) {
                    String oidValor = ((BigDecimal) respuesta.getValueAt(i, 1)).toString();
                    atributo.add(oidValor);
                } else if (respuesta.getValueAt(i, 2) != null) {
                    String valor = (String) respuesta.getValueAt(i, 2);
                    atributo.add(valor);
                }

                campos.add(atributo);
            }

            HashSet camposFecha = obtenerCamposFechaCabeceraSolicitud();
            actualizarValorDefectoBBDD("PED_SOLIC_CABEC", campos, camposFecha);
        }

        UtilidadesLog.info("DAOSolicitud.asignarValoresDefectoCabecera(Long oidCabeceraSolicitud, Long oidTipoSolicitud, Long oidModulo): Salida ");
    }

  public void asignarValoresDefectoPosicion(Long oidPosicionSolicitud,
        Long oidTipoSolicitud, Long oidModulo) throws MareException {
        
        UtilidadesLog.info("DAOSolicitud.asignarValoresDefectoPosicion(Long oidPosicionSolicitud, Long oidTipoSolicitud, Long oidModulo): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        ArrayList campos = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ate.cod_atri, vd.val_defe_oid, vd.val_valo_defe      ");
            query.append("   FROM ped_atrib_espec ate, ped_valor_defec_tipo_solic vd   ");
            query.append("  WHERE ate.modu_oid_modu = " + oidModulo);
            query.append("    AND ate.val_form = 'PED_SOLIC_POSIC' ");
            query.append("    AND vd.tspa_oid_tipo_soli_pais = " + oidTipoSolicitud);
            query.append("    AND vd.atre_oid_atri_espe = ate.oid_atri_espe ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta.esVacio()) {
            ArrayList PK = new ArrayList();
            PK.add(new String("OID_SOLI_POSI"));
            PK.add(new String(oidPosicionSolicitud.toString()));
            campos.add(PK);

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ArrayList atributo = new ArrayList();
                atributo.add((String) respuesta.getValueAt(i, 0));

                if (respuesta.getValueAt(i, 1) != null) {
                    String oidValor = ((BigDecimal) respuesta.getValueAt(i, 1)).toString();
                    atributo.add(oidValor);
                } else if (respuesta.getValueAt(i, 2) != null) {
                    String valor = (String) respuesta.getValueAt(i, 2);
                    atributo.add(valor);
                }

                campos.add(atributo);
            }
            actualizarValorDefectoBBDD("PED_SOLIC_POSIC", campos, null);
        }
        UtilidadesLog.info("DAOSolicitud.asignarValoresDefectoPosicion(Long oidPosicionSolicitud, Long oidTipoSolicitud, Long oidModulo): Salida ");
    }

    public Long obtenerResgistroSolicitud(Long cliente) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerResgistroSolicitud(Long cliente): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();
        long hoy = System.currentTimeMillis();
        long ayer = (hoy - ConstantesPED.CONSTANTE_DIA);

        try {
            query.append(" select OID_REGI_SOLI from PED_REGIS_SOLIC p, PED_LOTE l  ");
            query.append(" where  ");
            query.append(" p.CLIE_OID_CLIE = " + cliente);
            query.append(" and p.LOTE_OID_LOTE = l.OID_LOTE ");
            query.append(" and (l.FEC_REGI = to_date('" + new java.sql.Date(hoy) + "', 'YYYY - MM - DD')");
            query.append(" or l.FEC_REGI = to_date('" + new java.sql.Date(ayer) + "', 'YYYY - MM - DD'))");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta.esVacio()) {
            UtilidadesLog.info("DAOSolicitud.obtenerResgistroSolicitud(Long cliente): Salida ");
            return new Long(respuesta.getValueAt(0, 0).toString());
        }
        UtilidadesLog.info("DAOSolicitud.obtenerResgistroSolicitud(Long cliente): Salida ");
        return null;
    }
  
    private StringBuffer generarFiltroOidSolicitudes(ArrayList solicitudes) {
      UtilidadesLog.info("DAOSolicitud.generarFiltroOidSolicitudes(ArrayList solicitudes): Entrada ");
      Iterator it = solicitudes.iterator();
      StringBuffer query = new StringBuffer();      
      int count = 0;
      String oidsSolicitud = "";
      query.append(" AND (");
      while (it.hasNext()){
        Long oid = (Long) it.next();
        if (count == 0) {
           oidsSolicitud = oid.toString();
        } else { 
           oidsSolicitud += "," + oid.toString();
        }
        if (count == 999)  {
           query.append(" PSC.OID_SOLI_CABE IN (" + oidsSolicitud.toString() + ") ");                     
           if (it.hasNext()){
              query.append("  OR ");
           }                    
           count = 0;
        } else {
           if (!it.hasNext()){
              query.append(" PSC.OID_SOLI_CABE IN (" + oidsSolicitud.toString() + ") ");        
           }                    
           count++;            
        } 
             
        if (!it.hasNext()){              
          query.append(")");
        }
     }      
     UtilidadesLog.info("DAOSolicitud.generarFiltroOidSolicitudes(ArrayList solicitudes): Salida ");
     return query;
    }
    

    public ArrayList crearDTOSolicitudValidacion(ArrayList solicitudes, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOSolicitud.crearDTOSolicitudValidacion(ArrayList solicitudes, Long oidPais): Entrada ");
        // Para cada solicitud recibida crea un DTOSolicitudValidacion y los devuelve 
        ArrayList listaSolicitudes = new ArrayList();
        if (solicitudes.size() > 0) {
        
          // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
          String valParametro = obtenerValorParametroPais(oidPais, "PED", "012");
          boolean validacionPROL = false;
          if(valParametro != null && valParametro.equals("S"))
            validacionPROL = true;
                                
          StringBuffer query = new StringBuffer();
          query.append("SELECT PSC.PAIS_OID_PAIS, ");
          query.append("       PSC.OID_SOLI_CABE, ");
          query.append("       PSC.PERD_OID_PERI, ");
          query.append("       PER.MARC_OID_MARC, ");
          query.append("       PER.CANA_OID_CANA, ");
          query.append("       PSC.MONE_OID_MONE,  ");
          query.append("       PSC.TSPA_OID_TIPO_SOLI_PAIS, ");
          query.append("       PSC.CLIE_OID_CLIE, ");
          query.append("       PSC.SBAC_OID_SBAC, ");
          query.append("       PSC.IND_PEDI_PRUE, ");
          query.append("       PSC.IND_OC, ");
          query.append("       TSP.IND_PEDI_GT_ZONA, ");
          query.append("       PSC.ZZON_OID_ZONA, ");
          query.append("       PSC.VEPO_OID_VALO_ESTR_GEOP, ");
          query.append("       PSC.MODU_OID_MODU, ");          
          query.append("       PSC.VAL_TIPO_CAMB, ");
          query.append("       SBAC.ACCE_OID_ACCE,  ");
          query.append("       PSC.VAL_NUME_SOLI, ");
          query.append("       PSC.IND_PERM_UNIO_SOL, ");
          query.append("       PQ_APL_AUX.Valor_Gen_I18n_Sicc(1, PER.CANA_OID_CANA ,'SEG_CANAL') as desCanal, ");
          query.append("       PER.VAL_NOMB_PERI,");
          query.append("       CASE WHEN ((PSC.GRPR_OID_GRUP_PROC + 1) = 5) THEN ");
          query.append("         FN_OBT_IND_EJEC_ONLINE((PSC.GRPR_OID_GRUP_PROC + 1), TSP.TSOL_OID_TIPO_CONS) ");
          query.append("       ELSE ");
          query.append("         FN_OBT_IND_EJEC_ONLINE((PSC.GRPR_OID_GRUP_PROC + 1), TSP.OID_TIPO_SOLI_PAIS) ");
          query.append("       END IND_EJEC_ONLI,  ");
          //jrivas 29/1/2008 2007437
          query.append("       CASE WHEN ((TS.IND_ANUL = 1) OR (TS.IND_DEVO = 1)) THEN 1 ");
          query.append("       ELSE 0 ");
          query.append("       END DEV_ANU, ");
          query.append("       PSC.FEC_PROG_FACT, ");
          query.append("       PSC.IND_RECE_ONLI "); // sapaza -- PER-SiCC-2011-0726 -- 08/11/2011
          query.append("       ,PSC.IND_VALI_PROL "); // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
          query.append("FROM PED_SOLIC_CABEC PSC, ");
          query.append("     CRA_PERIO PER, ");
          query.append("     PED_TIPO_SOLIC_PAIS TSP, ");
          query.append("     ped_tipo_solic ts,  ");     
          query.append("     SEG_SUBAC SBAC ");
          query.append("WHERE PSC.PERD_OID_PERI = PER.OID_PERI ");
          query.append("  AND TSP.OID_TIPO_SOLI_PAIS = PSC.TSPA_OID_TIPO_SOLI_PAIS ");
          query.append("  AND SBAC.OID_SBAC = PSC.SBAC_OID_SBAC ");
          query.append("  and tsp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
          query.append(this.generarFiltroOidSolicitudes(solicitudes).toString());;

          RecordSet respuesta = null;
       
          respuesta = this.executeQuery(query.toString());
        
          if (respuesta != null && !respuesta.esVacio() ) {
             int resSize = respuesta.getRowCount();
             for (int i = 0; i < resSize; i++) {
               DTOSolicitudValidacion dtos = new DTOSolicitudValidacion();
                
               dtos.setOidAcceso(this.bigDecimalToLong(respuesta.getValueAt(i,"ACCE_OID_ACCE")));
               if (!respuesta.getValueAt(i, "VAL_NUME_SOLI").equals(null)) {
                 dtos.setNumSolicitud((respuesta.getValueAt(i ,"VAL_NUME_SOLI").toString()));
               }
               dtos.setIndUnionSolicitud(this.bigDToBoolean(respuesta.getValueAt(i,"IND_PERM_UNIO_SOL")));
               dtos.setOidSolicitud(this.bigDecimalToLong(respuesta.getValueAt(i,"OID_SOLI_CABE")));
               dtos.setOidPais(this.bigDecimalToLong(respuesta.getValueAt(i, "PAIS_OID_PAIS")));
               dtos.setOidPeriodo(this.bigDecimalToLong(respuesta.getValueAt(i, "PERD_OID_PERI")));
               dtos.setOidMarca(this.bigDecimalToLong(respuesta.getValueAt(i, "MARC_OID_MARC")));
               dtos.setOidCanal(this.bigDecimalToLong(respuesta.getValueAt(i, "CANA_OID_CANA")));
               dtos.setOidMoneda(this.bigDecimalToLong(respuesta.getValueAt(i, "MONE_OID_MONE")));
               dtos.setOidTipoSolPais(this.bigDecimalToLong(respuesta.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")));
               dtos.setOidCliente(this.bigDecimalToLong(respuesta.getValueAt(i, "CLIE_OID_CLIE")));
               dtos.setOidSubAcceso(this.bigDecimalToLong(respuesta.getValueAt(i, "SBAC_OID_SBAC")));
               dtos.setIndSimulacion(this.bigDToBoolean(respuesta.getValueAt(i,"IND_PEDI_PRUE")));
               dtos.setIndOrdenCompra(this.bigDToBoolean(respuesta.getValueAt(i,"IND_OC")));
               dtos.setIndPedGTZona(this.bigDToBoolean(respuesta.getValueAt(i, "IND_PEDI_GT_ZONA")));
               dtos.setZona(this.bigDecimalToLong(respuesta.getValueAt(i, "ZZON_OID_ZONA")));
               dtos.setUbigeo(this.bigDecimalToLong(respuesta.getValueAt(i, "VEPO_OID_VALO_ESTR_GEOP")));
               dtos.setOidModulo(this.bigDecimalToLong(respuesta.getValueAt(i, "MODU_OID_MODU")));
               if (respuesta.getValueAt(i, "VAL_TIPO_CAMB") != null) {
                  dtos.setTipoCambio((BigDecimal) respuesta.getValueAt(i, "VAL_TIPO_CAMB"));
               }
               if (respuesta.getValueAt(i, "DESCANAL") != null) {
                  dtos.setDescripcionCanal(respuesta.getValueAt(i, "DESCANAL").toString());
               }
               if (respuesta.getValueAt(i, "VAL_NOMB_PERI") != null) {
                  dtos.setNombrePeriodo(respuesta.getValueAt(i, "VAL_NOMB_PERI").toString());
               }
               dtos.setIndEjecOnLine(this.bigDToBoolean(respuesta.getValueAt(i, "IND_EJEC_ONLI")));
               
               //jrivas 29/1/2008 2007437
               dtos.setIndDevoAnul(this.bigDToBoolean(respuesta.getValueAt(i, "DEV_ANU")));
               if (respuesta.getValueAt(i, "FEC_PROG_FACT") != null) {
                    dtos.setFechaProceso((java.sql.Date)respuesta.getValueAt(i, "FEC_PROG_FACT"));
               }                  
               
                // sapaza -- PER-SiCC-2011-0726 -- 08/11/2011
                if (respuesta.getValueAt(i, "IND_RECE_ONLI") != null) {
                    if(respuesta.getValueAt(i, "IND_RECE_ONLI").toString().equals("1"))
                        dtos.setIndRecepcionOnline(Boolean.TRUE);
                    else    
                        dtos.setIndRecepcionOnline(Boolean.FALSE);
                } else    
                    dtos.setIndRecepcionOnline(Boolean.FALSE);
                    
                // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
                if (respuesta.getValueAt(i, "IND_VALI_PROL") != null) {
                    if(validacionPROL && respuesta.getValueAt(i, "IND_VALI_PROL").toString().equals("1"))
                        dtos.setIndValidacionPROL(Boolean.TRUE);
                    else    
                        dtos.setIndValidacionPROL(Boolean.FALSE);
                } else    
                    dtos.setIndValidacionPROL(Boolean.FALSE);                    
               
               listaSolicitudes.add(dtos);
            }
          }  
        }
        UtilidadesLog.info("DAOSolicitud.crearDTOSolicitudValidacion(ArrayList solicitudes, Long oidPais): Salida ");
        return listaSolicitudes;
    }

    private Long booleanALong(Boolean valor) {
        if (valor != null) {
            if (valor.booleanValue()) {
                return new Long(1);
            } else {
                return new Long(0);
            }
        }
        return null;
    }

    public RecordSet consultarProcesoSolicitud(Long oidSolicitud, Long oidIdioma)
        throws MareException {
        UtilidadesLog.info("DAOSolicitud.consultarProcesoSolicitud(Long oidSolicitud, Long oidIdioma): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("Select SC.OID_SOLI_CABE, SC.VAL_NUME_SOLI, IEstadosSol.VAL_I18N, ");
            query.append(" GP.DES_GRUP_PROC, IProcesosPed.VAL_I18N");
            query.append(" FROM PED_SOLIC_CABEC SC, V_GEN_I18N_SICC IEstadosSol, PED_GRUPO_PROCE GP, V_GEN_I18N_SICC IProcesosPed");
            query.append(" WHERE SC.OID_SOLI_CABE = '" + oidSolicitud.longValue() + "'");
            query.append(" AND sc.GRPR_OID_GRUP_proc = gp.OID_GRUP_PROC ");
            query.append(" AND IEstadosSol.ATTR_ENTI = 'PED_ESTAD_SOLIC' ");
            query.append(" AND IEstadosSol.IDIO_OID_IDIO = '" + oidIdioma.longValue() + "'");
            query.append(" AND IEstadosSol.VAL_OID = SC.ESSO_OID_ESTA_SOLI ");
            query.append(" AND IEstadosSol.ATTR_NUM_ATRI = 1");
            query.append(" AND IProcesosPed.ATTR_ENTI(+) = 'PED_PROCE' ");
            query.append(" AND IProcesosPed.IDIO_OID_IDIO(+) = '" + oidIdioma.longValue() + "'");
            query.append(" AND IProcesosPed.VAL_OID(+) = SC.PROC_OID_PROC ");
            query.append(" AND IProcesosPed.ATTR_NUM_ATRI(+) = 1");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("Resultado de la cons.: consultarProcesoSolicitud.. " + respuesta);
            UtilidadesLog.info("DAOSolicitud.consultarProcesoSolicitud(Long oidSolicitud, Long oidIdioma): Salida ");
            return respuesta;
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public Boolean validarFinalizacionGrupoProceso(Long oidSolicitud,
        Long oidTipoSolicitud, Long oidGrupoProceso) throws MareException {
        
        UtilidadesLog.info("DAOSolicitud.validarFinalizacionGrupoProceso(Long oidSolicitud, Long oidTipoSolicitud, Long oidGrupoProceso): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("SELECT OID_SOLI_CABE FROM PED_SOLIC_CABEC SOL");
            query.append(" WHERE SOL.OID_SOLI_CABE = '" + oidSolicitud + "'");
            query.append(" AND SOL.GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "'");
            query.append(" AND SOL.ESSO_OID_ESTA_SOLI IN");
            query.append(" ('" + ConstantesPED.ESTADO_SOLICITUD_VALIDADO + "', '" + ConstantesPED.ESTADO_SOLICITUD_LIBERADO + "')");
            query.append(" AND SOL.PROC_OID_PROC IN (");
            query.append("SELECT * FROM");
            query.append(" (SELECT S.PROC_OID_PROC FROM PED_SECUE_PROCE S");
            query.append(" where S.GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "'");
            query.append(" AND S.TSPA_OID_TIPO_SOLI_PAIS = '" + oidTipoSolicitud.longValue() + "'");
            query.append(" order by cod_secu desc)");
            query.append(" WHERE ROWNUM=1)");

            respuesta = bs.dbService.executeStaticQuery(query.toString());

            UtilidadesLog.debug("Resultado de query: validarFinalizacionGrupoProceso " + respuesta);

            UtilidadesLog.info("DAOSolicitud.validarFinalizacionGrupoProceso(Long oidSolicitud, Long oidTipoSolicitud, Long oidGrupoProceso): Salida ");
            if (respuesta.getRowCount() > 0) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
            
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    public ArrayList validarFinalizacionGrupoProceso(ArrayList soli, Long oidGrupoProceso) throws MareException {
        UtilidadesLog.info("DAOSolicitud.validarFinalizacionGrupoProceso(ArrayList soli, Long oidGrupoProceso): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        ArrayList rechazadas = new ArrayList();
        ArrayList respuestaL = new ArrayList();
        Long oidTipoSolicitud = null;
        StringBuffer solIn = new StringBuffer();
        int listaSize = soli.size();
        for (int i = 0 ; i < listaSize ; i++ ){
            DTOSolicitudValidacion dto = (DTOSolicitudValidacion)soli.get(i);
            if (oidTipoSolicitud == null){
                oidTipoSolicitud = dto.getOidTipoSolPais();
            }
            if (i == (listaSize-1)){
                solIn.append(dto.getOidSolicitud()+" ");
            }else{
                solIn.append(dto.getOidSolicitud()+", ");
            }
        }
        

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("SELECT OID_SOLI_CABE FROM PED_SOLIC_CABEC SOL");
            query.append(" WHERE SOL.OID_SOLI_CABE in ( ").append(solIn).append(" ) ");
            query.append(" AND SOL.GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "'");
            query.append(" AND SOL.ESSO_OID_ESTA_SOLI NOT IN");
            query.append(" ('" + ConstantesPED.ESTADO_SOLICITUD_VALIDADO + "', '" + ConstantesPED.ESTADO_SOLICITUD_LIBERADO + "')");
            query.append(" AND SOL.PROC_OID_PROC IN (");
            query.append("SELECT * FROM");
            query.append(" (SELECT S.PROC_OID_PROC FROM PED_SECUE_PROCE S");
            query.append(" where S.GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "'");
            query.append(" AND S.TSPA_OID_TIPO_SOLI_PAIS = '" + oidTipoSolicitud.longValue() + "'");
            query.append(" order by cod_secu desc)");
            query.append(" WHERE ROWNUM=1)");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            int rowCount = respuesta.getRowCount();
            int listasize = soli.size();
            for (int i = 0 ; i < listasize ; i++ ){
                DTOSolicitudValidacion dto = (DTOSolicitudValidacion)soli.get(i);
                boolean encontro = false;
                for (int x = 0 ; x < rowCount ; x++ ){
                    Long oid = Long.valueOf(respuesta.getValueAt(x,0).toString());
                    if (oid.longValue() == dto.getOidSolicitud().longValue()){
                        encontro = true;
                        break;
                    }
                }
                if (!encontro){
                    respuestaL.add(dto);
                }else{
                    rechazadas.add(dto);
                }
            }
            
            for (int i = 0; i < rechazadas.size(); i++) {
                DTOSolicitudValidacion dtoR = (DTOSolicitudValidacion)rechazadas.get(i);
                RecordSet rs = this.consultarProcesoSolicitud(dtoR.getOidSolicitud(), ConstantesSEG.IDIOMA_DEFECTO);
                UtilidadesLog.debug("daoSol.consultarProcesoSolicitud(, retorna: " + rs); 
                if (rs == null) {
                    LogAPP.error("La consulta de Proceso Solicitud no devolvio datos");
                    return null;
                }
    
                if (!(rs.getRowCount() > 0)) {
                    //APPLoggingService!!
                    LogAPP.error("La consulta de Proceso Solicitud no devolvio datos");
                } else {
    
                    Long oidSolicitud = ( rs.getValueAt(0,0)==null ? null : new Long(((BigDecimal) rs.getValueAt(0,0)).toString()) );
                    Long numeSoli = ( rs.getValueAt(0,1)==null ? null : new Long(((BigDecimal) rs.getValueAt(0,1)).toString()) );
                    String descEstado   = ( rs.getValueAt(0,2)==null ? null : new String( rs.getValueAt(0,2).toString()));
                    String descGrupProc = ( rs.getValueAt(0,3)==null ? null : new String( rs.getValueAt(0,3).toString()));
                    String descProc     = ( rs.getValueAt(0,4)==null ? null : new String( rs.getValueAt(0,4).toString()));
            
                    //APPLoggingService!!
                  LogAPP.error("No se pudo procesar la solicitud, Oid Solicitud: " + oidSolicitud + " Nº de Solicitud: " + numeSoli + 
                                " Estado: " + descEstado + " Grupo: " + descGrupProc + " Proceso: " + descProc);
                } 
            }
            
            return respuestaL;            
        } catch (Exception exception) {
            UtilidadesLog.error("ERROR", exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOObtenerCabeceraDTO obtenerCabeceraDTO(Long oidCabecera) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerCabeceraDTO(Long oidCabecera): Entrada ");

        StringBuffer query = new StringBuffer();
        RecordSet rs;
        DTOObtenerCabeceraDTO cab = null;

        try {
            query.append(" select pc.OID_SOLI_CABE, ");
            query.append(" pc.TSPA_OID_TIPO_SOLI_PAIS, ");
            query.append(" COD_CLIE, ");
            query.append(" VAL_NOM1,VAL_APE1,VAL_APE2, ");
            query.append(" p.VAL_NOMB_PERI, ");
            query.append(" pc.FEC_CRON, ");
            query.append(" pc.VAL_TOTA_PAGA_LOCA, ");
            query.append(" pc.VAL_IMPO_DESC_3_TOTA_LOCA, ");
            query.append(" pc.CLIE_OID_CLIE, ");
            query.append(" pc.ZZON_OID_ZONA, ");
            query.append(" p.OID_PERI ");
            query.append(" from PED_SOLIC_CABEC pc, ");
            query.append(" MAE_CLIEN c,");
            query.append(" CRA_PERIO p");
            query.append(" where pc.OID_SOLI_CABE = " + oidCabecera);
            query.append(" and c.OID_CLIE = pc.CLIE_OID_CLIE ");
            query.append(" and pc.PERD_OID_PERI = p.OID_PERI ");

            rs = UtilidadesDTO.getQuery(query.toString());

            cab = new DTOObtenerCabeceraDTO();

            cab.setOidCabecera(UtilidadesDTO.getLong(rs.getValueAt(0, 0)));
            cab.setOidTipoSolicitudPais(UtilidadesDTO.getLong(rs.getValueAt(0, 1)));
            cab.setCodigoCliente((String) rs.getValueAt(0, 2));
            cab.setNombre((String) rs.getValueAt(0, 3));
            cab.setApellido1((String) rs.getValueAt(0, 4));
            cab.setApellido2((String) rs.getValueAt(0, 5));
            cab.setNombrePeriodo((String) rs.getValueAt(0, 6));
            cab.setFechaSolicitud((java.sql.Date) rs.getValueAt(0, 7));
            cab.setMontoTotalSolicitud((BigDecimal) rs.getValueAt(0, 8));
            cab.setImporteDescuento3TotalLocal((BigDecimal) rs.getValueAt(0, 9));
            cab.setOidCliente(UtilidadesDTO.getLong(rs.getValueAt(0, 10)));
            cab.setOidZona(UtilidadesDTO.getLong(rs.getValueAt(0, 11)));
            cab.setOidPeriodo(UtilidadesDTO.getLong(rs.getValueAt(0, 12)));
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerCabeceraDTO(Long oidCabecera): Salida ");
        return cab;
    }

    /**
     * Método que recupera de la tabla SolicitudPosicion, dado el oid de SolicitudCabecera,
     * los siguientes campos: oidSolicitudCabecera, oidSolicitudPosicion, codigoVenta,
     * oidProducto, descripcionProducto, cantidad, unidadesPorAtender, precioUnitarioCatalogoLocal,
     * valorTotal, descuento, porcentajeDescuento, productoComisionable,
     * productoAportaMontoAEscala, estadoPosicion, oidTipoOferta, oidCicloVida,
     * oidMarcaProducto, oidUnidadNegocio, oidNegocio, oidSuperGenerico, oidGenerico;
     * para aquellas posiciones con estadoPosicion == null.
     * El resultado de la búsqueda debe ordenarse por oidSolicitudCabecera y oidSolicitudPosicion.
     * Además solo recuperamos las posiciones con estadoPosicion == null (ESPO_OID_ESTA_POSI).
     * @autor gdmarzi
     */
    public DTOSalida obtenerPosicionesDTO(Long oidCabecera) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesDTO(Long oidCabecera): Entrada ");
        String oidSolicitudCabecera;
        String oidSolicitudPosicion;
        String codigoVenta;
        String oidProducto;
        String descripcionProducto;
        String cantidad;
        String unidadesPorAtender;
        String precioUnitarioCatalogoLocal;
        String valorTotal;
        String descuento;
        String porcentajeDescuento;
        String productoComisionable;
        String productoAportaMontoAEscala;
        String estadoPosicion;
        String oidTipoOferta;
        String oidCicloVida;
        String oidMarcaProducto;
        String oidUnidadNegocio;
        String oidNegocio;
        String oidSuperGenerico;
        String oidGenerico;
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet rsPosiciones;
        Vector parametros = new Vector();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT SOCA_OID_SOLI_CABE oidSolicitudCabecera, ");
            query.append("  OID_SOLI_POSI oidSolicitudPosicion, ");
            query.append("  PED_SOLIC_POSIC.VAL_CODI_VENT codigoVenta, ");
            query.append("  PED_SOLIC_POSIC.PROD_OID_PROD oidProducto, ");
            query.append("  NUM_UNID_DEMA cantidad, ");
            query.append("  NUM_UNID_POR_ATEN unidadesPorAtender, ");
            query.append("  VAL_PREC_CATA_UNIT_LOCA precioUnitarioCatalogoLocal, ");
            query.append("  (NUM_UNID_POR_ATEN * VAL_PREC_CATA_UNIT_LOCA) valorTotal, ");
            query.append("  VAL_IMPO_DESC_TOTA_LOCA descuento, ");
            query.append("  VAL_PORC_DESC porcentajeDescuento, ");
            query.append("  ESPO_OID_ESTA_POSI estadoPosicion, ");
            query.append("  TOFE_OID_TIPO_OFER oidTipoOferta, ");
            query.append("  CIVI_OID_CICLO_VIDA oidCicloVida, ");
            query.append("  DES_CORT descripcionProducto, ");
            query.append("  MAPR_OID_MARC_PROD oidMarcaProducto, ");
            query.append("  UNEG_OID_UNID_NEGO oidUnidadNegocio, ");
            query.append("  NEGO_OID_NEGO oidNegocio, ");
            query.append("  SGEN_OID_SUPE_GENE oidSuperGenerico, ");
            query.append("  GENE_OID_GENE oidGenerico, ");
            query.append("  IND_COMI productoComisionable, ");
            query.append("  IND_APOR_MONT_ESCA productoAportaMontoAEscala, ped_solic_posic.OFDE_OID_DETA_OFER, PRE_MATRI_FACTU.OID_MATR_FACT ");
            query.append(" FROM PED_SOLIC_POSIC, PRE_OFERT_DETAL, MAE_PRODU, PRE_TIPO_OFERT, PRE_MATRI_FACTU ");
            query.append(" WHERE PED_SOLIC_POSIC.SOCA_OID_SOLI_CABE = ? ");
            query.append("  AND PRE_OFERT_DETAL.OID_DETA_OFER = PED_SOLIC_POSIC.OFDE_OID_DETA_OFER ");
            query.append("  AND MAE_PRODU.OID_PROD = PED_SOLIC_POSIC.PROD_OID_PROD ");
            query.append("  AND PRE_TIPO_OFERT.OID_TIPO_OFER = PRE_OFERT_DETAL.TOFE_OID_TIPO_OFER ");
            query.append("  AND 1E12 >= -ESPO_OID_ESTA_POSI  ");
            query.append(" AND PRE_OFERT_DETAL.OID_DETA_OFER = PRE_MATRI_FACTU.OFDE_OID_DETA_OFER ");
            query.append(" ORDER BY SOCA_OID_SOLI_CABE, OID_SOLI_POSI ");
            parametros.add(oidCabecera);

            rsPosiciones = bs.dbService.executePreparedQuery(query.toString(), parametros);

        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        // Crea un DTOSalida con el RecordSet obtenido de la consulta: 
        DTOSalida dtoSalidaPosiciones = new DTOSalida();
        dtoSalidaPosiciones.setResultado(rsPosiciones);
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesDTO(Long oidCabecera): Salida ");
        return dtoSalidaPosiciones;
    }


    /**
     * Realiza una búsqueda de solicitudes a partir de los parámetros de entrada.
     */
    public RecordSet buscarSolicitudesDTO(DTOBuscarSolicitudesDTO dtoe)
        throws MareException {
        
        UtilidadesLog.info("DAOSolicitud.buscarSolicitudesDTO(DTOBuscarSolicitudesDTO dtoe): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;
        DTOSalida sal = null;

        try {
            query.append("  SELECT DISTINCT cab.OID_SOLI_CABE OID, ");
            query.append("	   c.COD_CLIE, ");
            query.append("	   c.VAL_NOM1 || ' ' || c.VAL_APE1 || ' ' || c.VAL_APE2, ");
            query.append("	   pp.VAL_NOMB_PERI, ");
            query.append("	   cab.FEC_CRON, ");
            query.append("	   cab.VAL_TOTA_PAGA_LOCA	");
            query.append(" FROM  ");
            query.append("	PED_SOLIC_CABEC cab, ");
            query.append("	PED_SOLIC_POSIC pos, ");
            query.append("	MAE_CLIEN c, ");
            query.append("	CRA_PERIO pp ");
            query.append(" WHERE 1=1 ");

            if (dtoe.getOidCliente() != null) {
                query.append(" AND cab.CLIE_OID_CLIE = " + dtoe.getOidCliente());
            }

            query.append("	 AND cab.PERD_OID_PERI in( SELECT oid_peri      ");
            query.append("	 				   	   FROM   CRA_PERIO p       ");
            query.append("						   WHERE 1=1                ");

            if (dtoe.getOidPais() != null) {
                query.append(" AND p.PAIS_OID_PAIS = " + dtoe.getOidPais());
            }

            if (dtoe.getOidMarca() != null) {
                query.append(" AND p.MARC_OID_MARC = " + dtoe.getOidMarca());
            }

            if (dtoe.getOidCanal() != null) {
                query.append(" AND 	  p.CANA_OID_CANA = " + dtoe.getOidCanal());
            }

            query.append("	            )                                   ");
            query.append("	AND cab.SBAC_OID_SBAC  in( SELECT oid_SBAC      ");
            query.append("						   FROM   SEG_SUBAC s       ");

            if (dtoe.getOidAcceso() != null) {
                query.append("	WHERE  s.ACCE_OID_ACCE = " + dtoe.getOidAcceso());
            }

            query.append("	            )                                   ");
            query.append("	AND cab.CLIE_OID_CLIE = c.OID_CLIE              ");
            query.append("	AND pp.OID_PERI = cab.PERD_OID_PERI             ");
            query.append("	AND cab.OID_SOLI_CABE = pos.SOCA_OID_SOLI_CABE  ");

            if (dtoe.getCodigoVenta() != null) {
                query.append("	AND pos.VAL_CODI_VENT = '" + dtoe.getCodigoVenta().toUpperCase() + "' ");
            }

            String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);
            rs = UtilidadesDTO.getQuery(sqlPaginado);

            if (rs.esVacio()) {
                throw new MareException(new MareException(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        } catch (MareException e) {
            throw e;
        } catch (Exception ex) {
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.buscarSolicitudesDTO(DTOBuscarSolicitudesDTO dtoe): Salida ");
        return rs;
    }

    public void agregarSolicitudesGrupo(DTOAgregarSolicitudesGrupo dto) throws MareException {
        UtilidadesLog.info("DAOSolicitud.agregarSolicitudesGrupo(DTOAgregarSolicitudesGrupo dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;

        if ((dto == null) || (dto.getListaSolicitudes() == null) || (dto.getListaSolicitudes().size() < 1)) {
            return;
        }

        try {
            query.append(" UPDATE PED_SOLIC_CABEC ");
            query.append(" SET ");
            query.append(" VAL_GRUP_REVE =  " + "'" + dto.getGrupoReversion() + "'");
            query.append(" WHERE EXISTS ");
            query.append("(SELECT OID_TIPO_SOLI_PAIS FROM PED_TIPO_SOLIC_PAIS A WHERE A.IND_PERM_REVE = 1 AND A.OID_TIPO_SOLI_PAIS = TSPA_OID_TIPO_SOLI_PAIS) ");
            query.append(" AND (OID_SOLI_CABE = " + (Long) dto.getListaSolicitudes().get(0));

            for (int i = 1; i < dto.getListaSolicitudes().size(); i++) {
                query.append(" OR  OID_SOLI_CABE = " + (Long) dto.getListaSolicitudes().get(i));
            }
            query.append(" )");

            BelcorpService bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.agregarSolicitudesGrupo(DTOAgregarSolicitudesGrupo dto): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void actualizarProcesoSolicitud(Long oidSolicitud, Long oidGrupoProceso, Long oidProceso, Long Estatus) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarProcesoSolicitud(Long oidSolicitud, Long oidGrupoProceso, Long oidProceso, Long Estatus): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet rsSolicitudOidPeriodo;
		//doliva -- cambio Optimizacion Logs -- 09/04/2010
		if(logAux.isDebugEnabled()){
			UtilidadesLog.debug("oidSolicitud: " + oidSolicitud);
			UtilidadesLog.debug("oidGrupoProceso: " + oidGrupoProceso);
			UtilidadesLog.debug("oidProceso: " + oidProceso);
			UtilidadesLog.debug("Estatus: " + Estatus);
		}
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("Update PED_SOLIC_CABEC");
            query.append(" set GRPR_OID_GRUP_PROC = '" + oidGrupoProceso.longValue() + "',");
            query.append(" PROC_OID_PROC = '" + oidProceso.longValue() + "',");
            query.append(" ESSO_OID_ESTA_SOLI = '" + Estatus.longValue() + "'");
            query.append(" where OID_SOLI_CABE = '" + oidSolicitud.longValue() + "'");
            
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarProcesoSolicitud(Long oidSolicitud, Long oidGrupoProceso, Long oidProceso, Long Estatus): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    public void actualizarAcumuladosSolicitudes(Long tipoSolic, Long zona, Long subacceso, Date fecha, Long grupoProceso, boolean indReversion) throws MareException {
        StringBuffer st = new StringBuffer();
        BelcorpService bs;
        RecordSet r = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
        long gp1 = 0;
        long gp2 = 0;
        long gp3 = 0;
        long gp4 = 0;
        long gp5 = 0;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try{
            st.append(" SELECT p.oid_acum OID, p.sbac_oid_sbac, p.fec_proc, p.tspa_oid_tipo_soli_pais, ");
            st.append(" p.val_acum_gp1 GP1, p.val_acum_gp2 GP2, p.val_acum_gp3 GP3, p.val_acum_gp4 GP4, ");
            st.append(" p.val_acum_gp5 GP5, p.zzon_oid_zona ");
            st.append(" FROM ped_solic_cabec_acum p ");
            st.append(" where p.TSPA_OID_TIPO_SOLI_PAIS = "+tipoSolic);
            st.append(" and p.ZZON_OID_ZONA = "+zona);
            st.append(" and p.FEC_PROC = to_date('"+df.format(fecha)+"','dd/MM/yyyy')");
            r = bs.dbService.executeStaticQuery(st.toString());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (r.esVacio()){
            //Creo la entrada
            try{
                st = new StringBuffer();
                st.append(" INSERT INTO PED_SOLIC_CABEC_ACUM ( OID_ACUM, TSPA_OID_TIPO_SOLI_PAIS, ZZON_OID_ZONA, SBAC_OID_SBAC, ");
                st.append(" FEC_PROC, VAL_ACUM_GP1, VAL_ACUM_GP2, VAL_ACUM_GP3, VAL_ACUM_GP4, VAL_ACUM_GP5 ) VALUES ( ");
                st.append(" ped_scaa_seq.nextval, "+tipoSolic+" , "+zona+" , "+subacceso+" , to_date( '"+df.format(fecha)+"','dd/MM/yyyy'), ");
                switch (grupoProceso.intValue()){
                    case 1: gp1 = 1; break;
                    case 2: gp2 = 1; break;
                    case 3: gp3 = 1; break;
                    case 4: gp4 = 1; break;
                    case 5: gp5 = 1; break;
                }
                st.append(gp1+", "+gp2+", "+gp3+", "+gp4+", "+gp5+") ");
                bs.dbService.executeUpdate(st.toString());
            }catch(Exception e){
                UtilidadesLog.error("Error",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }else{
            //Actualizo dependiendo el gp
            try{
                gp1 = ((BigDecimal)r.getValueAt(0,"GP1")).longValue();
                gp2 = ((BigDecimal)r.getValueAt(0,"GP2")).longValue();
                gp3 = ((BigDecimal)r.getValueAt(0,"GP3")).longValue();
                gp4 = ((BigDecimal)r.getValueAt(0,"GP4")).longValue();
                gp5 = ((BigDecimal)r.getValueAt(0,"GP5")).longValue();
                long oid = ((BigDecimal)r.getValueAt(0,"OID")).longValue();
                
                switch (grupoProceso.intValue()){
                    case 1: if (indReversion){
                                gp2--;
                            }
                            gp1++;
                            break;
                    case 2: if (!indReversion){
                                gp2++;
                                gp1--;
                            }else{
                                gp2++;
                                gp3--;
                            }
                            break;
                    case 3: if (!indReversion){
                                gp3++;
                                gp2--;
                            }else{
                                gp3++;
                                gp4--;
                            }                        
                            break;
                    case 4: if (!indReversion){
                                gp4++;
                                gp3--;
                            }else{
                                gp4++;
                                gp5--;
                            } 
                            break;
                    case 5: if (!indReversion){
                                gp4--;
                            }
                            gp5++;
                            break;
                }
                
                st = new StringBuffer();
                st.append(" update PED_SOLIC_CABEC_ACUM set VAL_ACUM_GP1 = "+gp1);
                st.append(" , VAL_ACUM_GP2 = "+gp2);
                st.append(" , VAL_ACUM_GP3 = "+gp3);
                st.append(" , VAL_ACUM_GP4 = "+gp4);
                st.append(" , VAL_ACUM_GP5 = "+gp5);
                st.append(" where OID_ACUM = "+oid);
                bs.dbService.executeUpdate(st.toString());
            }catch(Exception e){
                UtilidadesLog.error("Error",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

    public void actualizarEstado(Long oidSolicitud, Integer estado) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarEstado(Long oidSolicitud, Integer estado): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet rsSolicitudOidPeriodo;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("Update PED_SOLIC_CABEC");
            query.append(" set ESSO_OID_ESTA_SOLI = " + estado.longValue());
            query.append(" where OID_SOLI_CABE = " + oidSolicitud.longValue());

            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarEstado(Long oidSolicitud, Integer estado): Salida ");
        } catch (Exception exception) {
            UtilidadesLog.error("Exception: ",exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida contarSolicitudesGrupo(DTOEGrupoReversion dto) throws MareException {
        UtilidadesLog.info("DAOSolicitud.contarSolicitudesGrupo(DTOEGrupoReversion dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta = null;

        try {
            query.append(" SELECT COUNT(*) AS NUMERO ");
            query.append(" FROM PED_SOLIC_CABEC ");
            query.append(" WHERE VAL_GRUP_REVE = " + "'" +
                dto.getGrupoReversion() + "'");
            respuesta = UtilidadesDTO.getQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtosalida = new DTOSalida();
        dtosalida.setResultado(respuesta);
        UtilidadesLog.info("DAOSolicitud.contarSolicitudesGrupo(DTOEGrupoReversion dto): Salida ");
        return dtosalida;
    }

    public void agregarSolicitudesCriterio(DTOAgregarSolicitudesCriterio dto) throws MareException {
        UtilidadesLog.info("DAOSolicitud.agregarSolicitudesCriterio(DTOAgregarSolicitudesCriterio dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta = null;

        try {
            query.append(" UPDATE PED_SOLIC_CABEC ");
            query.append(" SET ");
            query.append(" VAL_GRUP_REVE =  '" + dto.getGrupoReversion() +"' ");
            query.append(" WHERE EXISTS ( ");
            query.append("                            SELECT OID_TIPO_SOLI_PAIS ");
            query.append("                            FROM PED_TIPO_SOLIC_PAIS A ");
            query.append("                            WHERE A.OID_TIPO_SOLI_PAIS = TSPA_OID_TIPO_SOLI_PAIS ");
            query.append("                            AND A.OID_TIPO_SOLI_PAIS = " + dto.getOidTipoSolicitudPais());
            query.append("                            AND A.IND_PERM_REVE = 1) ");
            if (dto.getOidSubacceso() != null)
                query.append(" AND SBAC_OID_SBAC  = " + dto.getOidSubacceso());
            if (dto.getNumeroSolicitud() != null)
                query.append("AND VAL_NUME_SOLI = " + dto.getNumeroSolicitud());

            BelcorpService bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.agregarSolicitudesCriterio(DTOAgregarSolicitudesCriterio dto): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public Long obtenerNumeroPedidosConsultoraPeriodos(Long oidCliente, DTOOIDs periodos) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerNumeroPedidosConsultoraPeriodos(Long oidCliente, DTOOIDs periodos): Entrada ");
        RecordSet rs = new RecordSet();

        try {
            StringBuffer query = new StringBuffer(" SELECT 1 FROM PED_SOLIC_CABEC WHERE   ");
            query.append(" CLIE_OID_CLIE=  " + oidCliente);

            if (periodos.getOids().length == 1) {
                Long[] numero = periodos.getOids();
                query.append(" AND  PERD_OID_PERI = " + numero[0]);
            } else {
                StringBuffer datos = new StringBuffer();
                Long[] numero = periodos.getOids();
                datos.append(numero[0]);

                for (int i = 1; i < numero.length; i++) {
                    datos.append(" , " + numero[i]);
                }

                query.append(" AND PERD_OID_PERI IN ( " + datos + " ) ");
            }

            query.append(" AND IND_OC = 1  ");

            rs = UtilidadesDTO.getQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Integer total = null;

        if (rs.esVacio()) {
            total = new Integer(0);
        } else {
            int cant = rs.getRowCount();
            total = new Integer(cant);
        }

        UtilidadesLog.info("DAOSolicitud.obtenerNumeroPedidosConsultoraPeriodos(Long oidCliente, DTOOIDs periodos): Salida ");
        return new Long(total.longValue());
    }

    public BigDecimal obtenerMontoVentasConsultoraPeriodos(Long oidCliente, DTOOIDs periodos) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerMontoVentasConsultoraPeriodos(Long oidCliente, DTOOIDs periodos): Entrada ");
        RecordSet rs = new RecordSet();

        try {
            StringBuffer query = new StringBuffer(" select sum (VAL_TOTA_PAGA_LOCA + VAL_IMPO_IMPU_TOTA_LOCA) as suma FROM PED_SOLIC_CABEC WHERE   ");
            query.append(" CLIE_OID_CLIE=  " + oidCliente);

            if (periodos.getOids().length == 1) {
                Long[] numero = periodos.getOids();
                query.append(" AND  PERD_OID_PERI = " + numero[0]);
            } else {
                StringBuffer datos = new StringBuffer();
                Long[] numero = periodos.getOids();
                datos.append(numero[0]);

                for (int i = 1; i < numero.length; i++) {
                    datos.append(" , " + numero[i]);
                }

                query.append(" AND PERD_OID_PERI IN ( " + datos + " ) ");
            }

            rs = UtilidadesDTO.getQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        BigDecimal total = null;

        if (rs.esVacio()) {
            total = new BigDecimal(0);
        } else {
            Vector salida = rs.getColumn(0);
            total = (BigDecimal) salida.firstElement();
        }

        UtilidadesLog.info("DAOSolicitud.obtenerMontoVentasConsultoraPeriodos(Long oidCliente, DTOOIDs periodos): Salida ");
        return total;
    }

    // sapaza -- PER-SiCC-2012-0412 -- 23/05/2012
    public void actualizarMontoDescuento3(Long oidCabecera, BigDecimal montoDescuento3, Long moneda, BigDecimal tipoCambio, BigDecimal montoBaseCalculo) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarMontoDescuento3(Long oidCabecera, BigDecimal montoDescuento3, Long moneda, BigDecimal tipoCambio, BigDecimal montoBaseCalculo): Entrada ");
        StringBuffer query = new StringBuffer();
        BigDecimal montoDescuento3_docu;
        
        if (montoDescuento3 != null) {
           if (moneda == null) {
               montoDescuento3_docu = montoDescuento3;
           } else {
               montoDescuento3_docu = montoDescuento3.divide(tipoCambio, BigDecimal.ROUND_UNNECESSARY);
           }
           
           query.append(" UPDATE PED_SOLIC_CABEC ");
           query.append(" SET VAL_IMPO_DESC_3_TOTA_LOCA = " + montoDescuento3.toString());
           query.append(" , VAL_IMPO_DESC_3_TOTA_DOCU = " + montoDescuento3_docu.toString());    
           
           // sapaza -- PER-SiCC-2012-0412 -- 23/05/2012
           if(montoBaseCalculo != null)
               query.append(" , VAL_MONT_BAPL_DCTO = " + montoBaseCalculo.toString());    
           else
               query.append(" , VAL_MONT_BAPL_DCTO = 0 ");    
           
           query.append(" WHERE OID_SOLI_CABE = " + oidCabecera.toString());

        } else {
            query.append(" UPDATE PED_SOLIC_CABEC ");
            
            if(montoBaseCalculo != null)
                query.append(" SET VAL_MONT_BAPL_DCTO = " + montoBaseCalculo.toString());    
            else
                query.append(" SET VAL_MONT_BAPL_DCTO = 0 ");

            query.append(" WHERE OID_SOLI_CABE = " + oidCabecera.toString());
        }
        
        try {
             int i = BelcorpService.getInstance().dbService.executeUpdate(query.toString());
             UtilidadesLog.info("DAOSolicitud.actualizarMontoDescuento3(Long oidCabecera, BigDecimal montoDescuento3, Long moneda, BigDecimal tipoCambio, BigDecimal montoBaseCalculo): Salida ");
        } catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

    }
    public void actualizarPorcentajeDescuento(Long oidPosicion,
        BigDecimal porcentaje, BigDecimal descuento, Long moneda, BigDecimal tipoCambio) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarPorcentajeDescuento(Long oidPosicion, BigDecimal porcentaje, BigDecimal descuento, Long moneda, BigDecimal tipoCambio): Entrada ");
        BigDecimal descuento_docu;

        StringBuffer query = new StringBuffer();

        if (moneda == null) {
            descuento_docu = descuento;
        } else {
            descuento_docu = descuento.divide(tipoCambio, BigDecimal.ROUND_HALF_EVEN);
        }

        query.append(" UPDATE PED_SOLIC_POSIC SET ");
        query.append(" VAL_IMPO_DESC_UNIT_LOCA = " + descuento.toString());
        query.append(" , VAL_IMPO_DESC_UNIT_DOCU = " + descuento_docu.toString());        
        if(porcentaje!=null){
            query.append(", VAL_PORC_DESC = " + porcentaje.toString());
        }
        
        query.append(" WHERE OID_SOLI_POSI = " + oidPosicion.toString());

        try {
            int i = BelcorpService.getInstance().dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarPorcentajeDescuento(Long oidPosicion, BigDecimal porcentaje, BigDecimal descuento, Long moneda, BigDecimal tipoCambio): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    

    /**
    *  Jrivas Inc. 17873  7/5/2005
    *  Faltaba actualizar el valor del Documento.
    *  @cambio incidencia 20070245, solo se actualizan las posiciones con descuentos mayores que cero.
    *  @autor gdmarzi.
    */
    public String generarActualizarPorcentajeDescuento(Long oidPosicion, BigDecimal porcentaje, BigDecimal descuento, Long moneda, BigDecimal tipoCambio,
                                                        Long oidBaseAplicacion, Long oidEscala) throws MareException {
        UtilidadesLog.info("DAOSolicitud.generarActualizarPorcentajeDescuento(Long oidPosicion, BigDecimal porcentaje, BigDecimal descuento, Long moneda, BigDecimal tipoCambio): Entrada ");
        BigDecimal descuento_docu;
        StringBuffer query = new StringBuffer();

        //Solo actualizamos el descuento si este es mayor que cero.
        if ((porcentaje != null) && (porcentaje.floatValue() > 0) && (descuento != null) && (descuento.floatValue() > 0)) {
            if (moneda == null) {
                descuento_docu = descuento;
            } else {
                descuento_docu = descuento.multiply(tipoCambio);
            }
            query.append(" UPDATE PED_SOLIC_POSIC SET ");
            query.append(" VAL_IMPO_DESC_UNIT_LOCA = " + descuento.toString());
            query.append(" , VAL_IMPO_DESC_UNIT_DOCU = " + descuento_docu.toString());        
            query.append(" , VAL_PORC_DESC = " + porcentaje.toString());
            
            // sapaza -- PER-SiCC-2012-0335 -- 20/04/2012
            if(oidEscala != null) {
                query.append(" , BACA_OID_CABE = " + oidBaseAplicacion.toString());
                query.append(" , ESLO_OID_ESLN = " + oidEscala.toString());
            }    
            
            query.append(" WHERE OID_SOLI_POSI = " + oidPosicion.toString());
            query.append(";");
        }

        UtilidadesLog.info("DAOSolicitud.generarActualizarPorcentajeDescuento(Long oidPosicion, BigDecimal porcentaje, BigDecimal descuento, Long moneda, BigDecimal tipoCambio): Salida ");
        return query.toString();            
    }


    /**
     * Autor: Hugo Mansi
     * Fecha: 17/08/2004
     * Recibe  DTOOID
     * Devuelve DTOOID
     *
    **/
    public DTOOID obtenerTiposDocumentoLegalReclamos(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerTiposDocumentoLegalReclamos(DTOOID dtoE): Entrada ");
        DTOOID dtoOid = new DTOOID();
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        BelcorpService bs = getBelcorpService();

        query.append(" SELECT CAB.TIDO_OID_TIPO_DOCU, ");
        query.append(" CAB.IND_OC ");
        query.append(" FROM PED_SOLIC_CABEC CAB ");
        query.append(" WHERE CAB.SOCA_OID_SOLI_CABE = " + dtoE.getOid());
        query.append(" ORDER BY CAB.VAL_NUME_SOLI ASC ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());

            if (rs.esVacio()) {
                return null;
            } else {
                BigDecimal bd = (BigDecimal)rs.getValueAt(0, 0);
                dtoOid.setOid(new Long( bd.longValue()));
                for (int i = 0; i < rs.getRowCount(); i++) {
                    if (rs.getRow(i).elementAt(1).equals(Boolean.TRUE)) {                        
                         bd = (BigDecimal)rs.getValueAt(i, 0);
                         dtoOid.setOid(new Long( bd.longValue()));
                         break;
                    } //FIN SI
                } //FIN FOR
            }  //FIN ELSE 
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerTiposDocumentoLegalReclamos(DTOOID dtoE): Salida ");
        return dtoOid;
    }

    public DTOSalida cargarGrupoReversion(DTOEGrupoReversion dto) throws MareException {
        UtilidadesLog.info("DAOSolicitud.cargarGrupoReversion(DTOEGrupoReversion dto): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        DTOSalida out = new DTOSalida();

        try {
            query.append(" SELECT  D.OID_SOLI_CABE AS OID , E.VAL_I18N DESCRIP_TIPO_SOLIC, F.VAL_I18N AS DESCRIP_SEG, D.VAL_NUME_SOLI ");
            query.append(" FROM PED_TIPO_SOLIC A , SEG_SUBAC B , PED_TIPO_SOLIC_PAIS C , PED_SOLIC_CABEC D, GEN_I18N_SICC E ,GEN_I18N_SICC F ");
            query.append(" WHERE D.SBAC_OID_SBAC = B.OID_SBAC ");
            query.append(" AND D.TSPA_OID_TIPO_SOLI_PAIS = C.OID_TIPO_SOLI_PAIS ");
            query.append(" AND A.OID_TIPO_SOLI = C.TSOL_OID_TIPO_SOLI ");
            query.append(" AND E.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
            query.append(" AND E.VAL_OID = A.OID_TIPO_SOLI ");
            query.append(" AND E.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND F.ATTR_ENTI = 'SEG_SUBAC' ");
            query.append(" AND F.VAL_OID = B.OID_SBAC ");
            query.append(" AND F.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND D.VAL_GRUP_REVE = '" + dto.getGrupoReversion() + "'");

            String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
            rs = UtilidadesDTO.getQuery(sqlPaginado);
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        out.setResultado(rs);
        UtilidadesLog.info("DAOSolicitud.cargarGrupoReversion(DTOEGrupoReversion dto): Salida ");
        return out;
    }

  /**
   * @author Emilio Noziglia
   * @since 16/10/2005
   * @param Long oidSolicitud
   * @return RecordSet 
   * @throws MareException
   * @reference UBEL004
   */ 
    public RecordSet obtenerSolicitudAsignacionStock(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudAsignacionStock(Long oidSolicitud): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT a.oid_soli_cabe OID, a.val_nume_soli numerosolicitud, ");
            buf.append(" a.almc_oid_alma almacen, a.clie_oid_clie cliente, ");
            buf.append(" a.num_prem numeropremio, ");
            buf.append(" b.tmal_oid_tipo_movi_asig movimientoasignacion, ");
            buf.append(" b.tmal_oid_tipo_movi_rese movimientoreserva, ");
            buf.append(" b.tsol_oid_tipo_soli tiposolicitud, a.ind_oc ordencompra, ");
            buf.append(" c.pais_oid_pais pais, c.marc_oid_marc marca, c.cana_oid_cana canal, ");
            buf.append(" c.oid_peri periodo, d.acce_oid_acce acceso, a.sbac_oid_sbac subacceso, ");
            buf.append(" a.val_glos_obse observaciones, e.cod_modu moduloorigen, ");
            buf.append(" (CASE ");
            buf.append(" WHEN (b.tsol_oid_tipo_soli IN (SELECT b.tsol_oid_tipo_soli tiposolicitud ");
            buf.append(" FROM ped_tipo_solic_proce a, ped_tipo_solic_pais b ");
            buf.append(" WHERE a.oper_oid_oper IN (" +ConstantesBEL.INC020+" , "+ ConstantesBEL.INC030+ " , ");
            buf.append("  " + ConstantesBEL.INC040+" , "+ ConstantesBEL.INC050+ ") ");
            buf.append(" AND oid_tipo_soli_pais = a.tspa_oid_tipo_soli_pais ");
            buf.append(" AND b.pais_oid_pais = c.pais_oid_pais)) ");
            buf.append(" THEN 1 ");
            buf.append(" ELSE 0 ");
            buf.append(" END ");
            buf.append(" ) incentivos" );
            buf.append(" FROM ped_solic_cabec a, ");
            buf.append(" ped_tipo_solic_pais b, ");
            buf.append(" cra_perio c, ");
            buf.append(" seg_subac d, ");
            buf.append(" seg_modul e ");
            buf.append(" WHERE a.oid_soli_cabe = " + oidSolicitud);
            buf.append(" AND b.oid_tipo_soli_pais = a.tspa_oid_tipo_soli_pais ");
            buf.append(" AND c.oid_peri = a.perd_oid_peri ");
            buf.append(" AND d.oid_sbac = a.sbac_oid_sbac ");
            buf.append(" AND a.modu_oid_modu = e.oid_modu ");        

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudAsignacionStock(Long oidSolicitud): Salida ");
        return respuesta;
    }

    public void anularReporteFaltantes(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.anularReporteFaltantes(Long oidSolicitud): Entrada ");
        try {
            StringBuffer query = new StringBuffer();
            query.append(" UPDATE ped_solic_cabec SET ");
            query.append(" val_lote_repo_falt = NULL, fec_repo_falt = NULL ");
            query.append(" WHERE oid_soli_cabe =  " + oidSolicitud);

            BelcorpService bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.anularReporteFaltantes(Long oidSolicitud): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
    * Obtiene la tipificación de cliente, región/zona y país, marca y canal de una solicitud.
    * @author Mario Bobadilla
    * creado el 24/08/04

    */
    public RecordSet obtenerTipificacionClienteRegionZona(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerTipificacionClienteRegionZona(Long oidSolicitud): Entrada ");
        BelcorpService bs = getBelcorpService();

        StringBuffer query = new StringBuffer();
        RecordSet rs;

        try {
            query.append(" SELECT ");
            query.append(" B.pais_oid_pais pais, ");
            query.append(" B.marc_oid_marc marca, ");
            query.append(" B.cana_oid_cana canal, ");
            query.append(" B.oid_peri periodo, ");
            query.append(" E.zorg_oid_regi region, ");
            query.append(" E.oid_zona zona, ");
            query.append(" A.clie_oid_clie oidcliente, ");
            query.append(" F.ticl_oid_tipo_clie tipocliente, ");
            query.append(" F.sbti_oid_subt_clie subtipocliente, ");
            query.append(" G.tccl_oid_tipo_clasi tipoclasificacion, ");
            query.append(" G.clas_oid_clas clasificacion ");

            query.append(" FROM ");
            query.append(" ped_solic_cabec A, ");
            query.append(" cra_perio B, ");
            query.append(" zon_terri_admin C, ");
            query.append(" zon_secci D, ");
            query.append(" zon_zona E, ");
            query.append(" mae_clien_tipo_subti F, ");
            query.append(" mae_clien_clasi G ");

            query.append(" WHERE ");
            query.append(" A.oid_soli_cabe = " + oidSolicitud);

            query.append(" AND B.oid_peri = A.perd_oid_peri ");
            query.append(" AND C.oid_terr_admi (+) = A.ztad_oid_terr_admi ");
            query.append(" AND D.oid_secc (+) = C.zscc_oid_secc  ");
            query.append(" AND E.oid_zona (+) = D.zzon_oid_zona ");
            query.append(" AND F.clie_oid_clie = A.clie_oid_clie  ");
            query.append(" AND G.ctsu_oid_clie_tipo_subt (+) = F.oid_clie_tipo_subt ");
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSolicitud.obtenerTipificacionClienteRegionZona(Long oidSolicitud): Salida ");
        return rs;
    }


    /**
         * Autor Pablo Perez
    */
    private void actualizarValorDefectoBBDD(String entidad, ArrayList campos,HashSet camposFecha) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarValorDefectoBBDD(String entidad, ArrayList campos, HashSet camposFecha): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet rsSolicitudOidPeriodo;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("UPDATE " + entidad);
            query.append("   SET  ");

            for (int i = 1; i < campos.size(); i++) {
                ArrayList atributo = (ArrayList) campos.get(i);
                String nombreCampo = (String) atributo.get(0);
                String valor = (String) atributo.get(1);

                if ((camposFecha != null) &&
                        (camposFecha.contains(nombreCampo))) {
                    query.append("  " + nombreCampo + "  = TO_DATE('" + valor + "','dd/MM/yyyy'),");
                } else {
                    query.append("  " + nombreCampo + "  = '" + valor + "',");
                }
            }

            query.deleteCharAt(query.length() - 1);

            ArrayList PK = (ArrayList) campos.get(0);
            String oidCampo = (String) PK.get(0);
            String oidValor = (String) PK.get(1);
            query.append("   WHERE " + oidCampo + " = " + oidValor);

            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarValorDefectoBBDD(String entidad, ArrayList campos, HashSet camposFecha): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * @Autor Hugo Andrés Mansi
     * @fecha 01/09/2004
     * @Recibe el identificador del tipo de solicitud y la cantidad de decimales
     * @Devuelve NADA
     * @Descripción Cálculo de los valores totales (bruto y neto) de la solicitud
     *
     */
    public void calcularTotales(Long oidSolicitud, Integer numDecimales, Long oidMoneda, BigDecimal tipoCambio, Boolean indRecepcionOnline) throws MareException {
        UtilidadesLog.info("DAOSolicitud.calcularTotales(Long oidSolicitud, Integer numDecimales, Long oidMoneda, BigDecimal tipoCambio): Entrada ");
        DTOCalcularTotales miDto = new DTOCalcularTotales();
        
        // sapaza -- PER-SiCC-2011-0726 -- 07/02/2011, se comenta el llamado al stored de Stock Online
        // sapaza -- PER-SiCC-2011-0726 -- 08/11/2011
        /*if(indRecepcionOnline!=null && indRecepcionOnline) {
            UtilidadesLog.debug("esRecepcionOnline.....");
            ejecutarStockOnline(oidSolicitud);
        }*/
        
        UtilidadesLog.debug("voy a calcular totales.....");
        miDto = realizarCalculo(oidSolicitud, numDecimales);
        UtilidadesLog.debug("calcule totales.....");
        miDto.setOidSolicitud(oidSolicitud);

        if (oidMoneda != null) {
			//doliva -- cambio Optimizacion Logs -- 09/04/2010
			if(logAux.isDebugEnabled()){
				UtilidadesLog.debug("miDto.getImporteDescuento: " + miDto.getImporteDescuento());
				UtilidadesLog.debug("tipoCambio: " + tipoCambio);
			}
          miDto.setBaseFleteDocumento(miDto.getPrecioCatalogo().divide(tipoCambio, BigDecimal.ROUND_HALF_EVEN));
          BigDecimal importeDescuento = miDto.getImporteDescuento().divide(tipoCambio, BigDecimal.ROUND_HALF_EVEN);
          miDto.setBaseFleteDocumento(miDto.getBaseFleteDocumento().subtract(importeDescuento));
        } else {
          miDto.setBaseFleteDocumento(miDto.getPrecioCatalogo());
          miDto.setBaseFleteDocumento(miDto.getBaseFleteDocumento().subtract(miDto.getImporteDescuento()));
        }

        actualizarSolicitudCalculoTotales(miDto);
        
        // sapaza -- PER-SICC-2012-0169 -- 29/02/2012
        if(miDto.getIndOC().booleanValue()){
            if (!((miDto.getIndAnul().booleanValue()) || (miDto.getIndDevo().booleanValue())) ) 
                this.actualizarAcumulador2(miDto);
        }
        
        UtilidadesLog.info("DAOSolicitud.calcularTotales(Long oidSolicitud, Integer numDecimales, Long oidMoneda, BigDecimal tipoCambio): Salida ");
    }

    /**
       * @Autor Hugo Andrés Mansi
       * @fecha 01/09/2004
       * @Recibe el identificador del tipo de moneda y el identificador del pais
       * @Devuelve Integer con el número de decimales
       * @Descripción Cálculo de los valores totales (bruto y neto) de la solicitud
       *
       */
    public Integer obtenerDecimales(Long oidMoneda, Long oidPaisLocal) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerDecimales(Long oidMoneda, Long oidPaisLocal): Entrada ");

        Long numeroDecimales;

        if (oidMoneda != null) {
            UtilidadesLog.debug("El oidMoneda es : " + oidMoneda);

            try {
                MonedaLocalHome monedaLH = new MonedaLocalHome();
                MonedaLocal moneda = monedaLH.findByPrimaryKey(oidMoneda);
                numeroDecimales = moneda.getNumDeci();
            } catch (NoResultException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        } else {
            UtilidadesLog.debug("el oidMoneda es nulo");

            try {
                PaisLocalHome paisLH = new PaisLocalHome();
                PaisLocal pais = paisLH.findByPrimaryKey(oidPaisLocal);
                MonedaLocalHome monedaLH = new MonedaLocalHome();
                MonedaLocal moneda = monedaLH.findByPrimaryKey(pais.getMone_oid_mone());
                numeroDecimales = moneda.getNumDeci();
            } catch (NoResultException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSolicitud.obtenerDecimales(Long oidMoneda, Long oidPaisLocal): Salida ");
        return new Integer(numeroDecimales.intValue());
    }

    //Fin obtenerDecimales

    /**
       * @Autor Hugo Andrés Mansi
       * @fecha 01/09/2004
       * @Recibe (Long) oid de la solicitud y número de (Integer) numero de decimales
       * @Devuelve DTOCalcularTotales
       * @Descripción Cálculo de los valores totales (bruto y neto) de la solicitud
       *
       */
    public DTOCalcularTotales realizarCalculo(Long oidSolicitud, Integer numeroDecimales) throws MareException {
        UtilidadesLog.info("DAOSolicitud.realizarCalculo(Long oidSolicitud, Integer numeroDecimales): Entrada ");   

        RecordSet rs;
        BelcorpService bs = getBelcorpService();

        try {
            ArrayList array = new ArrayList();
            array.add(oidSolicitud.toString());
            array.add(ConstantesPED.ESTADO_POSICION_ANULADO.toString());
            array.add(numeroDecimales.toString());
            
            rs = bs.dbService.executeProcedure("PQ_PLANI.PED_REALIZAR_CALCULO",array);
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        DTOCalcularTotales miDto = new DTOCalcularTotales();
        
        miDto.setPrecioCatalogo(new BigDecimal(0));
        miDto.setPrecioDemandaReal(new BigDecimal(0));
        miDto.setPrecioContable(new BigDecimal(0));
        miDto.setUnidadesAtender(new Long(0));
        miDto.setUnidadesDemandaReal(new Long(0));
        miDto.setIndAnul(Boolean.FALSE);
        miDto.setIndDevo(Boolean.FALSE);
        miDto.setIndOC(Boolean.FALSE);

        UtilidadesLog.debug("rs: " + rs);

        if (!rs.esVacio()) {
            if (rs.getValueAt(0, 0) != null) {
                miDto.setPrecioCatalogo(new BigDecimal(rs.getValueAt(0, 0).toString()));
            }
            if (rs.getValueAt(0, 1) != null) {
                miDto.setPrecioDemandaReal(new BigDecimal(rs.getValueAt(0, 1).toString()));
            }
            if (rs.getValueAt(0, 2) != null) {
                miDto.setPrecioContable(new BigDecimal(rs.getValueAt(0, 2).toString()));
            }
            if (rs.getValueAt(0, 3) != null) {
                miDto.setUnidadesAtender(new Long(rs.getValueAt(0, 3).toString()));
            }

            if (rs.getValueAt(0, 4) != null) {
                miDto.setUnidadesDemandaReal(new Long( rs.getValueAt(0, 4).toString()));
            }

            if (rs.getValueAt(0, 5) != null && rs.getValueAt(0, 5).toString().equals("1")) {
                miDto.setIndAnul(Boolean.TRUE);
            }      
            
            if (rs.getValueAt(0, 6) != null && rs.getValueAt(0, 6).toString().equals("1")) {
                miDto.setIndDevo(Boolean.TRUE);
            } 
            
            if (rs.getValueAt(0, 7) != null) {
                miDto.setOidPeriodo(new Long( rs.getValueAt(0, 7).toString()));
            }
            
            if (rs.getValueAt(0, 8) != null) {
                miDto.setOidCliente(new Long( rs.getValueAt(0, 8).toString()));
            }            
            
            if (rs.getValueAt(0, 9) != null && rs.getValueAt(0, 9).toString().equals("1")) {
                miDto.setIndOC(Boolean.TRUE);
            } 
            if (rs.getValueAt(0, 10) != null) {
                miDto.setImporteDescuento(new BigDecimal(rs.getValueAt(0, 10).toString()));
            } else {
                miDto.setImporteDescuento(new BigDecimal(0));
            }
        }

        UtilidadesLog.debug("DTO a devolver " + miDto);
        UtilidadesLog.info("DAOSolicitud.realizarCalculo(Long oidSolicitud, Integer numeroDecimales): Salida ");
        return miDto;
    }

    //fin realizaCalculo

    /**
    * @Autor Hugo Andrés Mansi
    * @fecha 01/09/2004
    * @Recibe DTOCalcularTotales
    * @Devuelve Nada
    */
    public void actualizarSolicitudCalculoTotales(DTOCalcularTotales DTOE)
        throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarSolicitudCalculoTotales(DTOCalcularTotales DTOE): Entrada ");

        RecordSet rs;
        BelcorpService bs = getBelcorpService();
        StringBuffer query = new StringBuffer();
        query.append(" 	update PED_SOLIC_CABEC	 ");
        query.append(" 	set VAL_PREC_CATA_TOTA_LOCA = 	 ");
        query.append(DTOE.getPrecioCatalogo());
        query.append(" 	 ,VAL_PREC_CONT_TOTA_LOCA = 	 ");
        query.append(DTOE.getPrecioContable());
        query.append(" 	 ,VAL_TOTA_PAGA_LOCA = 	 ");
        query.append(DTOE.getPrecioCatalogo());
        query.append(" 	 ,VAL_PREC_CATA_TOTA_LOC_UNI_DEM =  ");
        query.append(DTOE.getPrecioDemandaReal());
        query.append(" 	 ,VAL_UNID_DEMA_REAL_TOTA = 	 ");
        query.append(DTOE.getUnidadesDemandaReal());
        query.append(" 	 ,NUM_UNID_POR_ATEN_TOTA = 	 ");
        query.append(DTOE.getUnidadesAtender());
        query.append(" 	 ,VAL_BASE_FLET_LOCA = 	 ");
        query.append(DTOE.getPrecioCatalogo().subtract(DTOE.getImporteDescuento()));
        query.append(" 	 ,VAL_BASE_FLET_DOCU =   ");
        query.append(DTOE.getBaseFleteDocumento());        
        query.append(" 	Where OID_SOLI_CABE = 	 ");
        query.append(DTOE.getOidSolicitud());

        try {
            bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarSolicitudCalculoTotales(DTOCalcularTotales DTOE): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }


    /**
      * @Autor Hugo Andrés Mansi
      * @fecha 01/09/2004
      * @Recibe DTOCalcularTotales
      * @Devuelve Nada
      */
    public void actualizarCalculoFleteExento(Long oidSolicitud, BigDecimal tipoCambio, Integer numDecimales) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarCalculoFleteExento(Long oidSolicitud, BigDecimal tipoCambio, Integer numDecimales): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        if (numDecimales == null) {
            numDecimales = new Integer(2);
        }
        
        if (tipoCambio == null || tipoCambio.longValue() == 0){
            tipoCambio = new BigDecimal(1);
        }

        query.append(" UPDATE PED_SOLIC_CABEC CA ");
        query.append(" SET VAL_IMPO_FLET_TOTA_LOCA=0, ");
        query.append(" VAL_IMPO_FLET_TOTA_DOCU=0, ");
        query.append(" VAL_TOTA_FLET_LOCA= ROUND(NVL(VAL_RECA_FLET_LOCA,0) + NVL(VAL_OTRO_RECA_LOCA,0), ");
        query.append(numDecimales);
        query.append(" ), ");
        query.append(" VAL_TOTA_PAGA_LOCA= ROUND(NVL(VAL_TOTA_PAGA_LOCA,0) + NVL(VAL_RECA_FLET_LOCA,0) + NVL(VAL_OTRO_RECA_LOCA,0), ");
        query.append(numDecimales);
        query.append(" ), ");
        query.append(" VAL_TOTA_FLET_DOCU = ROUND((NVL(VAL_RECA_FLET_LOCA,0) + NVL(VAL_OTRO_RECA_LOCA,0))/ ");
        query.append(tipoCambio);
        query.append("  , ");
        query.append(numDecimales);
        query.append(" ), ");
        query.append(" VAL_TOTA_PAGA_DOCU = ROUND((NVL(VAL_TOTA_PAGA_LOCA,0) + NVL(VAL_RECA_FLET_LOCA,0) + NVL(VAL_OTRO_RECA_LOCA,0))/ ");
        query.append(tipoCambio);
        query.append("  , ");
        query.append(numDecimales);
        query.append(" ) WHERE ");
        query.append(" CA.OID_SOLI_CABE = ");
        query.append(oidSolicitud);

        try {
            bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarCalculoFleteExento(Long oidSolicitud, BigDecimal tipoCambio, Integer numDecimales): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    // FIN actualizarCalculoFleteExento

    /**
      * @Autor Hugo Andrés Mansi
      * @fecha 01/09/2004
      * @Recibe DTOCalcularTotales
      * @Devuelve Nada
      */
    public void actualizarCalculoFlete(Long oidSolicitud, BigDecimal importeFleteLocal, BigDecimal otrosRecargosLocal,
        BigDecimal totalFleteLocal, BigDecimal importeFleteTotalLocal, Long tipoClasificacion, Long clasificacion,
        BigDecimal importeFleteDocumento, BigDecimal otrosRecargosDocumento, BigDecimal totalFleteDocumento, BigDecimal importeFleteTotalDocumento, BigDecimal importeBaseFlete)
        throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarCalculoFlete(Long oidSolicitud, BigDecimal importeFleteLocal, BigDecimal otrosRecargosLocal, BigDecimal totalFleteLocal, BigDecimal importeFleteTotalLocal, Long tipoClasificacion, Long clasificacion, BigDecimal importeFleteDocumento, BigDecimal otrosRecargosDocumento, BigDecimal totalFleteDocumento, BigDecimal importeFleteTotalDocumento): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        query.append(" Update PED_SOLIC_CABEC  	 ");
        query.append(" set VAL_IMPO_FLET_LOCA = 	 ");
        query.append(importeFleteLocal);
        query.append(" ,VAL_OTRO_RECA_LOCA = 	 ");
        query.append(otrosRecargosLocal);
        query.append(" ,VAL_TOTA_FLET_LOCA = 	 ");
        query.append(totalFleteLocal);
        query.append(" ,VAL_IMPO_FLET_TOTA_LOCA = 	 ");
        query.append(importeFleteTotalLocal);
        query.append(" ,TCCL_OID_TCCL_FLET = 	 ");
        query.append(tipoClasificacion);
        query.append(" ,CLAS_OID_CLAS_FLET = 	 ");
        query.append(clasificacion);
        query.append(" ,VAL_OTRO_RECA_DOCU = 	 ");
        query.append(otrosRecargosDocumento);
        query.append(" ,VAL_TOTA_FLET_DOCU = 	 ");
        query.append(totalFleteDocumento);
        query.append(" ,VAL_IMPO_FLET_TOTA_DOCU = 	 ");
        query.append(importeFleteTotalDocumento);
        query.append(" ,VAL_IMPO_FLET_DOCU = 	 ");
        query.append(importeFleteDocumento);
        query.append(" ,VAL_BASE_FLET_LOCA = ");
        query.append(importeBaseFlete);
        query.append(" where OID_SOLI_CABE =  " + oidSolicitud);

        try {
            bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarCalculoFlete(Long oidSolicitud, BigDecimal importeFleteLocal, BigDecimal otrosRecargosLocal, BigDecimal totalFleteLocal, BigDecimal importeFleteTotalLocal, Long tipoClasificacion, Long clasificacion, BigDecimal importeFleteDocumento, BigDecimal otrosRecargosDocumento, BigDecimal totalFleteDocumento, BigDecimal importeFleteTotalDocumento): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    //fin actualizarCalculoFlete

    /**
    * @Autor Hugo Andrés Mansi
    * @fecha 02/09/2004
    * @Recibe el oid de la solicitud
    * @Devuelve un dto con los datos de la anulacion
    */
    public DTODatosAnulacion obtenerDatosAnulacion(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerDatosAnulacion(Long oidSolicitud): Entrada ");

        DTODatosAnulacion miDto = new DTODatosAnulacion();
        RecordSet rs;
        BelcorpService bs = getBelcorpService();
        StringBuffer query = new StringBuffer();
        query.append(" 	SELECT CA.OID_SOLI_CABE,TS.IND_ANUL,CA.SOCA_OID_DOCU_REFE, ");
        query.append(" 	CA.COPA_OID_PARA_GENE, CA.NUM_PREM, CA.ICTP_OID_TIPO_PROG ");
        query.append(" 	FROM PED_TIPO_SOLIC TS, 	 ");
        query.append(" 	PED_TIPO_SOLIC_PAIS TSP, 	 ");
        query.append(" 	PED_SOLIC_CABEC CA 	 ");
        query.append(" 	WHERE 	 ");
        query.append(" 	CA.OID_SOLI_CABE=	 " + oidSolicitud);
        query.append(" 	AND CA.TSPA_OID_TIPO_SOLI_PAIS=TSP.OID_TIPO_SOLI_PAIS 	 ");
        query.append(" 	AND TSP.TSOL_OID_TIPO_SOLI=TS.OID_TIPO_SOLI 	 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());

            if (rs.getValueAt(0, 0) == null) {
                miDto.setOidSolicitud(null);
            } else {
                miDto.setOidSolicitud(new Long(rs.getValueAt(0, 0).toString()));
            }

            if (rs.getValueAt(0, 1) == null) {
                miDto.setIndAnulacion(Boolean.FALSE);
            } else {
                if ( this.castBigDecimal((BigDecimal) rs.getValueAt(0, 1)).longValue() == 0)
                  miDto.setIndAnulacion(Boolean.FALSE);
                else
                  miDto.setIndAnulacion(Boolean.TRUE);
            }

            if (rs.getValueAt(0, 2) == null) {
                miDto.setOidSolicitudReferencia(null);
            } else {
                miDto.setOidSolicitudReferencia(new Long(rs.getValueAt(0, 2).toString()));
            }
            
            if (rs.getValueAt(0, 3) == null) {
                miDto.setOidConcurso(null);
            } else {
                miDto.setOidConcurso(new Long(rs.getValueAt(0, 3).toString()));
            }
            if (rs.getValueAt(0, 4) == null) {
                miDto.setNumeroPremio(null);
            } else {
                miDto.setNumeroPremio(new Long(rs.getValueAt(0, 4).toString()));
            }
            if (rs.getValueAt(0, 5) == null) {
                miDto.setOidTipoPrograma(null);
            } else {
                miDto.setOidTipoPrograma(new Long(rs.getValueAt(0, 5).toString()));
            }
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSolicitud.obtenerDatosAnulacion(Long oidSolicitud): Salida ");
        return miDto;
    }

    //FIN obtenerDatosAnulacion

    /**
    * @Autor ssaavedr
    * @fecha 20/02/2006
    * @Recibe el oid de la solicitud de referencia
    * @Devuelve NADA
    */
    public void anularSolRef(Long oidSolicitudReferencia) throws MareException {
        UtilidadesLog.info("DAOSolicitud.anularSolRef(Long oidSolicitudReferencia): Entrada ");

        BelcorpService bs = getBelcorpService();
        try {
            StringBuffer query = new StringBuffer();
            query.append(" UPDATE ped_solic_cabec ");
            query.append(" SET ESSO_OID_ESTA_SOLI = " + ConstantesPED.ESTADO_SOLICITUD_ANULADO.longValue());
            query.append(" where OID_SOLI_CABE = " + oidSolicitudReferencia.longValue());
            bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.anularSolRef(Long oidSolicitudReferencia): Salida ");
    }


    /**
    * @Autor Hugo Andrés Mansi
    * @fecha 02/09/2004
    * @Recibe el oid de la solicitud de origen y el oid de la solicitud de destino
    * @Devuelve NADA
    * @ssaavedr INC.: 23213==>>Se modifica la actualización de los datos de posición
    */
    public void copiarDatosAnulacion(Long oidSolicitudOrigen, Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.copiarDatosAnulacion(Long oidSolicitudOrigen, Long oidSolicitud): Entrada ");
        int i = 0;
        RecordSet rs;

        BelcorpService bs = getBelcorpService();
        StringBuffer query = new StringBuffer();
        int procesados = 0;
        query.append(" 	SELECT COPA_OID_PARA_GENE,	 ");
        query.append(" 	NUM_PREM,	 ");
        query.append(" 	IND_EXEN_FLET,	 ");
        query.append(" 	VAL_BASE_FLET_LOCA,	 ");
        query.append(" 	VAL_IMPO_FLET_LOCA,	 ");
        query.append(" 	VAL_RECA_FLET_LOCA,	 ");
        query.append(" 	VAL_OTRO_RECA_LOCA,	 ");
        query.append(" 	VAL_TOTA_FLET_LOCA,	 ");
        query.append(" 	VAL_IMPO_FLET_TOTA_LOCA,	 ");
        query.append(" 	VAL_BASE_FLET_DOCU,	 ");
        query.append(" 	VAL_IMPO_FLET_DOCU,	 ");
        query.append(" 	VAL_RECA_FLET_DOCU,	 ");
        query.append(" 	VAL_OTRO_RECA_DOCU,	 ");
        query.append(" 	VAL_TOTA_FLET_DOCU,	 ");
        query.append(" 	VAL_IMPO_FLET_TOTA_DOCU,	 ");
        query.append(" 	VAL_IMPO_DESC_3_TOTA_LOCA,  	 ");
        query.append(" 	VAL_TOTA_PAGA_DOCU	 ");
        query.append(" 	FROM ped_solic_cabec 	 ");
        query.append(" 	where OID_SOLI_CABE = 	 " + oidSolicitudOrigen);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        try {
        
            BigDecimal valorNegativo = null;
        
            query = new StringBuffer();
            query.append(" UPDATE ped_solic_cabec ");
            query.append(" SET COPA_OID_PARA_GENE = ");
            query.append(rs.getValueAt(0, 0));
            query.append(" ,NUM_PREM = ");
            query.append(rs.getValueAt(0, 1));
            query.append("  ,IND_EXEN_FLET = ");
            query.append(rs.getValueAt(0, 2));
            query.append(" ,VAL_BASE_FLET_LOCA = ");
            if(rs.getValueAt(0, 3)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 3).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_IMPO_FLET_LOCA = ");
            if(rs.getValueAt(0, 4)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 4).toString()).multiply(new BigDecimal("-1"));;
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            
            query.append(" ,VAL_RECA_FLET_LOCA = ");
            if(rs.getValueAt(0, 5)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 5).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_OTRO_RECA_LOCA = ");
            if(rs.getValueAt(0, 6)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 6).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_TOTA_FLET_LOCA = ");
            if(rs.getValueAt(0, 7)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 7).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_IMPO_FLET_TOTA_LOCA = ");
            if(rs.getValueAt(0, 8)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 8).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_BASE_FLET_DOCU = ");
            if(rs.getValueAt(0, 9)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 9).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_IMPO_FLET_DOCU = ");
            if(rs.getValueAt(0, 10)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 10).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_RECA_FLET_DOCU = ");
            if(rs.getValueAt(0, 11)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 11).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_OTRO_RECA_DOCU = ");
            if(rs.getValueAt(0, 12)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 12).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_TOTA_FLET_DOCU = ");
            if(rs.getValueAt(0, 13)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 13).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" ,VAL_IMPO_FLET_TOTA_DOCU = ");
            if(rs.getValueAt(0, 14)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 14).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");
            }
            query.append(" ,VAL_IMPO_DESC_3_TOTA_LOCA =  ");
            if(rs.getValueAt(0, 15)!=null){
                query.append(rs.getValueAt(0, 15));
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19 
            }
            query.append(" ,VAL_TOTA_PAGA_DOCU =  ");
            if(rs.getValueAt(0, 16)!=null){
               valorNegativo = new BigDecimal(rs.getValueAt(0, 16).toString()).multiply(new BigDecimal("-1"));
               query.append(valorNegativo.toString());
            }else{
               query.append(" 0 ");// si viene null que inserte 0 V-REC-19
            }
            query.append(" 	where OID_SOLI_CABE = " + oidSolicitud);
            bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        rs = null;
        query = new StringBuffer();
        query.append("Select psc.oid_soli_cabe ");
        query.append("from PED_SOLIC_CABEC psc");
        query.append(" where psc.SOCA_OID_SOLI_CABE = " + oidSolicitudOrigen.longValue());
        query.append(" and psc.IND_TS_NO_CONSO = 1 ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        ArrayList posicionesOrigen = new ArrayList();
        UtilidadesLog.debug("Las solicitudes origen del consolidado, son: " + rs);
        if (rs.getRowCount()>0) 
        {
            
            //recorro las solicitudes origen recuperadas ....
            long oidSoliCabe = ((BigDecimal)rs.getValueAt(0, 0)).longValue();
            RecordSet rs1;
            for (int ii = 0; ii < rs.getRowCount(); ii++) {
            
                oidSoliCabe = ((BigDecimal)rs.getValueAt(ii, 0)).longValue();
                //Leo las posiciones del documento origen con los datos: precioCatalogoUnitarioLocal, precioContableUnitarioLocal, 
                //importeDescuentoUnitarioLocal, porcentajeDescuento, codigoVentaFicticio.
                
                query = new StringBuffer();
                query.append("Select psp.OID_SOLI_POSI, ");
                query.append("psp.VAL_CODI_VENT, ");
                query.append("psp.NUM_UNID_ATEN, ");
                query.append("psp.VAL_PREC_CATA_UNIT_LOCA, ");
                query.append("psp.VAL_PREC_CONT_UNIT_LOCA, ");
                query.append("psp.VAL_IMPO_DESC_UNIT_LOCA, ");
                query.append("psp.VAL_PORC_DESC, ");
                query.append("psp.VAL_CODI_VENT_FICT, ");
                query.append("psp.VAL_IMPO_DESC_UNIT_DOCU, ");
                query.append("psp.VAL_PREC_CATA_UNIT_DOCU ");
                query.append("from PED_SOLIC_POSIC psp ");
                query.append("where psp.SOCA_OID_SOLI_CABE = " + oidSoliCabe);
                query.append(" and psp.ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO.longValue());
        
                try {
                    rs1 = bs.dbService.executeStaticQuery(query.toString());
                } catch (Exception e) {
                    if (e instanceof MareException) {
                        UtilidadesLog.error("MareException: ",e);
                        throw (MareException) e;
                    } else {
                        UtilidadesLog.error("Exception: ",e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
                }
                UtilidadesLog.debug("Leo las posiciones del documento origen, para la solicitud: " + oidSoliCabe + ", son: " + rs1);
                try {
                    for (int iii = 0; iii < rs1.getRowCount(); iii++) {
                        DTOPosicionSolicitud posicion = new DTOPosicionSolicitud();
                        
                        if (rs1.getValueAt(iii,0)!=null){
                            posicion.setOidPosicionSolicitud(stringToLong(rs1.getValueAt(iii,0)));
                        }    
                        if (rs1.getValueAt(iii,1)!=null){
                            posicion.setCodigoVenta((rs1.getValueAt(iii,1)).toString());
                        }else{
                            posicion.setCodigoVenta(new String());
                        }
                        if (rs1.getValueAt(iii,2)!=null){
                            posicion.setUnidadesAtendidas(stringToLong(rs1.getValueAt(iii,2)));
                        }
                        if (rs1.getValueAt(iii,3)!=null){
                            posicion.setPrecioCatalogoUnitarioLocal(new BigDecimal(rs1.getValueAt(iii,3).toString()));
                        }                    
                        if (rs1.getValueAt(iii,4)!=null){
                            posicion.setPrecioContableUnitarioLocal(new BigDecimal(rs1.getValueAt(iii,4).toString()));
                        }                    
                        if (rs1.getValueAt(iii,5)!=null){
                            posicion.setImporteDescuentoUnitarioDocumento(new BigDecimal(rs1.getValueAt(iii,5).toString()));
                        }                    
                        if (rs1.getValueAt(iii,6)!=null){
                            posicion.setPorcentajeDescuento(new Double(rs1.getValueAt(iii,6).toString()));
                        }                    
                        if (rs1.getValueAt(iii,7)!=null){
                            posicion.setCodigoVentaFicticio(stringToLong(rs1.getValueAt(iii,7)));
                        }
                        if(rs1.getValueAt(iii,"VAL_IMPO_DESC_UNIT_DOCU")!=null){
                           posicion.setImporteDescuentoUnitarioDocumento(new BigDecimal(rs1.getValueAt(iii,"VAL_IMPO_DESC_UNIT_DOCU").toString()));
                        }
                        if(rs1.getValueAt(iii,"VAL_PREC_CATA_UNIT_DOCU")!=null){
                           posicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal(rs1.getValueAt(iii,"VAL_PREC_CATA_UNIT_DOCU").toString()));
                        }
                        posicionesOrigen.add(posicion);
                    }
                
                } catch (Exception e){
                    UtilidadesLog.error("Exception: ",e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }
            
            }  //fin recorro las solicitudes origen recuperadas ....
            
        } 
        ComparadorPosicionesOrigen comparator = new ComparadorPosicionesOrigen();
        Collections.sort(posicionesOrigen, comparator);            
        
        ArrayList posicionesQueSeTratan = new ArrayList();
        rs = null;
        query = new StringBuffer();
        query.append("Select psp.OID_SOLI_POSI, ");
        query.append("psp.VAL_CODI_VENT, ");
        query.append("psp.NUM_UNID_DEMA, ");
        query.append("psp.SOPO_OID_SOLI_POSI ");
        query.append("from PED_SOLIC_POSIC psp ");
        query.append("where psp.SOCA_OID_SOLI_CABE = " + oidSolicitud.longValue());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.debug("Las posiciones para el documento origen, son: " + rs);
        try {
            for (int iiii = 0; iiii < rs.getRowCount(); iiii++) {
                DTOPosicionSolicitud posicion = new DTOPosicionSolicitud();
                
                if (rs.getValueAt(iiii,0)!=null){
                    posicion.setOidPosicionSolicitud(stringToLong(rs.getValueAt(iiii,0)));
                }    
                if (rs.getValueAt(iiii,1)!=null){
                    posicion.setCodigoVenta((rs.getValueAt(iiii,1)).toString());
                }else{
                    posicion.setCodigoVenta(new String());
                }
                if (rs.getValueAt(iiii,2)!=null){
                   posicion.setUnidadesDemandadas(
                            (stringToLong(rs.getValueAt(iiii,2)).longValue()<0)
                            ? new Long((stringToLong(rs.getValueAt(iiii,2)).longValue() * -1))
                            : new Long(rs.getValueAt(iiii,2).toString()));
                }
                //PED-001
                if (rs.getValueAt(iiii,3)!=null){
                    posicion.setPosicionRecuperacion(stringToLong(rs.getValueAt(iiii,0)));
                }    
            
                posicionesQueSeTratan.add(posicion);
            }
        
        } catch (Exception e){
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        Collections.sort(posicionesQueSeTratan, comparator);         
        
        //recorro posicionesOrigen
        String codVta = new String();
        int unidades = -1;
        Long oidPosOrigen;
        Long oidPosRecuperacion;
        UtilidadesLog.debug("voy a leer del array: posicionesOrigen");
        for (int j = 0; j < posicionesOrigen.size(); j++) {
            DTOPosicionSolicitud dtoPosicionSolicitudOrigen = (DTOPosicionSolicitud)posicionesOrigen.get(j);
            UtilidadesLog.debug("el dato que leo, es: " + dtoPosicionSolicitudOrigen);
            
            if ((dtoPosicionSolicitudOrigen.getCodigoVenta().compareTo(codVta) != 0) && 
                    dtoPosicionSolicitudOrigen.getUnidadesAtendidas().intValue() != unidades)
            {
                codVta = dtoPosicionSolicitudOrigen.getCodigoVenta();
                unidades = dtoPosicionSolicitudOrigen.getUnidadesAtendidas().intValue();
                oidPosOrigen = dtoPosicionSolicitudOrigen.getOidPosicionSolicitud();
                oidPosRecuperacion = dtoPosicionSolicitudOrigen.getPosicionRecuperacion();
                
                ArrayList posicionesOrigenIgualCodigo = new ArrayList();
                ArrayList posicionesQueSeTratanIgualCodigo = new ArrayList();

                UtilidadesLog.debug("codigo de venta y unidades: " + codVta + "-" + unidades);
                UtilidadesLog.debug("oidPosicionOrigen y oidPosicionRecuperacion : " + oidPosOrigen + "-" + oidPosRecuperacion);
                
                this.adhieroEnArrayOrigen(codVta, unidades, oidPosOrigen, posicionesOrigen, posicionesOrigenIgualCodigo);
                
                this.adhieroEnArrayDestino(codVta, unidades, oidPosRecuperacion, posicionesQueSeTratan, posicionesQueSeTratanIgualCodigo);

                if (posicionesOrigenIgualCodigo.size() != posicionesQueSeTratanIgualCodigo.size()) {
                    UtilidadesLog.error("ERROR GRAVE, existe diferencia en cantidad de posiciones entre; posiciones origen y las que se tratan, para el cod. de vta.: " + codVta);
                } else {
                
                    for (int k = 0; k < posicionesOrigenIgualCodigo.size(); k++) {
                        DTOPosicionSolicitud posicionUno = (DTOPosicionSolicitud)posicionesOrigenIgualCodigo.get(k);
                        DTOPosicionSolicitud posicionDos = (DTOPosicionSolicitud)posicionesQueSeTratanIgualCodigo.get(k);
                        
                        try {
                            bs = getBelcorpService();
                            
                            query = new StringBuffer();
                            query.append(" UPDATE PED_SOLIC_POSIC ");
                            query.append(" SET VAL_PREC_CATA_UNIT_LOCA =  ");
                            query.append(posicionUno.getPrecioCatalogoUnitarioLocal());
                            query.append(" ,VAL_PREC_CONT_UNIT_LOCA =  ");
                            query.append(posicionUno.getPrecioContableUnitarioLocal());
                            query.append(" ,VAL_IMPO_DESC_UNIT_LOCA =  ");
                            query.append(posicionUno.getImporteDescuentoUnitarioDocumento());
                            query.append(" ,VAL_PORC_DESC =  ");
                            query.append(posicionUno.getPorcentajeDescuento());
                            query.append(" ,VAL_CODI_VENT_FICT =  ");
                            query.append(posicionUno.getCodigoVentaFicticio());
                            
                            query.append(" ,VAL_IMPO_DESC_UNIT_DOCU=  ");
                            query.append(posicionUno.getImporteDescuentoUnitarioDocumento());
                            query.append(" ,VAL_PREC_CATA_UNIT_DOCU=  ");
                            query.append(posicionUno.getPrecioCatalogoUnitarioDocumento());  

                              
                            query.append(" 	where OID_SOLI_POSI = " + posicionDos.getOidPosicionSolicitud());
                            UtilidadesLog.debug("actualizo la posicion: " + query.toString());
                            bs.dbService.executeUpdate(query.toString());
                        } catch (Exception e) {
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
    
                    }
                }
            
            } //Fin Si posicionOrigen.codigoVenta != codigoVenta && posicionOrigen.unidadesAtendidas != unidades
        } //fin lazo posiciones origen

        UtilidadesLog.info("DAOSolicitud.copiarDatosAnulacion(Long oidSolicitudOrigen, Long oidSolicitud): Salida ");
    }

    public boolean aplicaCupTres(long oidPais) throws MareException {
        UtilidadesLog.info("DAOSolicitud.aplicaCupTres(long oidPais): Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("select spip.IND_APLI_CUPO_TRES ");
            buf.append("from SEG_PARAM_INTER_PAIS spip ");
            buf.append("WHERE spip.PAIS_OID_PAIS = " + oidPais);

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
            if ((respuesta!=null)&&(respuesta.getRowCount()>0)){
                if (((BigDecimal)respuesta.getValueAt(0, "IND_APLI_CUPO_TRES")).longValue() == 0) {
                    UtilidadesLog.info("DAOSolicitud.aplicaCupTres(long oidPais): Salida (false)");
                    return false;
                }else{
                    if (((BigDecimal)respuesta.getValueAt(0, "IND_APLI_CUPO_TRES")).longValue() == 1) {
                        UtilidadesLog.info("DAOSolicitud.aplicaCupTres(long oidPais): Salida (true)");
                        return true;
                    }else{
                        UtilidadesLog.info("DAOSolicitud.aplicaCupTres(long oidPais): Salida (false)");
                        return false;
                    }    
                }    
            }else{
                UtilidadesLog.info("DAOSolicitud.aplicaCupTres(long oidPais): Salida (false)");
                return false;
            }
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public void blanqueoSolCab(Long oidSolRefe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.blanqueoSolCab(Long oidSolRefe): Entrada");
        try {
            StringBuffer query = new StringBuffer();

            query.append("update CCC_DETAL_CUPON_TRAMI_DEPUR ")
                 .append("set SOCA_OID_SOLI_CABE=NULL ")
                 .append(" where SOCA_OID_SOLI_CABE in (")
                 .append(oidSolRefe)
                 .append(")");

            BelcorpService bs = getBelcorpService();
            UtilidadesLog.debug("se blanquearon: " + bs.dbService.executeUpdate(query.toString()) + ", registros..");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOSolicitud.blanqueoSolCab(Long oidSolRefe): Salida");
    }        

    public void reversarCalculoFlete(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.reversarCalculoFlete(Long oidSolicitud): Entrada ");
        try {
            StringBuffer query = new StringBuffer();

            UtilidadesLog.debug("reverso, flete, de solicitud: " + oidSolicitud);

            query.append("update PED_SOLIC_CABEC a ");
            query.append("set a.VAL_BASE_FLET_LOCA = 0 , ");
            query.append("a.VAL_BASE_FLET_DOCU = 0 , ");
            query.append("a.VAL_IMPO_FLET_LOCA = 0 , ");
            query.append("a.VAL_IMPO_FLET_DOCU = 0 , ");
            query.append("a.VAL_OTRO_RECA_LOCA = 0 , ");
            query.append("a.VAL_OTRO_RECA_DOCU = 0 , ");
            query.append("a.VAL_TOTA_FLET_LOCA = 0 , ");
            query.append("a.VAL_TOTA_FLET_DOCU = 0 , ");
            query.append("a.VAL_IMPO_FLET_TOTA_LOCA = 0 , ");
            query.append("a.VAL_IMPO_FLET_TOTA_DOCU=0 , ");
            query.append("a.TCCL_OID_TCCL_FLET = NULL , ");
            query.append("a.CLAS_OID_CLAS_FLET = NULL ");
            query.append("where  a.OID_SOLI_CABE = " + oidSolicitud);

            BelcorpService bs = getBelcorpService();
            bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSolicitud.reversarCalculoFlete(Long oidSolicitud): Salida ");
    }

    public DTOListaSolicitudes obtenerSolicitudporPrefacturar(DTOInfoMonitor dtoin) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporPrefacturar(DTOInfoMonitor dtoin): Entrada ");
        BelcorpService belcorpService;
        RecordSet rsSolCabec;
        String codigoError;
        Boolean oidMoneNULL = Boolean.FALSE;
        String sFInicio = new String();
        String sFFinal = new String();

        int j;

        DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();

        Vector registroLista = new Vector();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }

        //recorro los tipos de solicitud recibidos....
        ArrayList lista = new ArrayList();
        lista = dtoin.getSecuencia();

        try {
            if ((lista != null) && (lista.size() > 0)) {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");

                StringBuffer query = new StringBuffer();
                query.append("Select * from( ");

                for (int i = 0; i < lista.size(); i++) {
                    DTOSecuenciaSolicitudes elmDtoSecSol = (DTOSecuenciaSolicitudes) lista.get(i);

                    sFInicio = simpledateformat.format(dtoin.getFechaInicio());
                    sFFinal = simpledateformat.format(dtoin.getFechaFin());

                    query.append(" (Select ");
                    query.append(" pedSOLCAB.OID_SOLI_CABE,");
                    query.append(" craPER.MARC_OID_MARC,");
                    query.append(" craPER.CANA_OID_CANA,");
                    query.append(" pedSOLCAB.PERD_OID_PERI,");
                    query.append(" pedSOLCAB.MONE_OID_MONE,");
                    query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS,");
                    query.append(" pedSOLCAB.CLIE_OID_CLIE,");
                    query.append(" pedSOLCAB.SBAC_OID_SBAC,");
                    query.append(" pedSOLCAB.IND_PEDI_PRUE,");
                    query.append(" pedSOLCAB.IND_OC,");
                    query.append(" pedTISOPA.IND_PEDI_GT_ZONA,");
                    query.append(" pedSOLCAB.ZZON_OID_ZONA,");
                    query.append(" pedSOLCAB.VEPO_OID_VALO_ESTR_GEOP,");
                    query.append(" pedSOLCAB.MODU_OID_MODU,");

                    query.append(" segMONE1.NUM_DECI NUM_DEC1,");
                    query.append(" segMONE2.NUM_DECI NUM_DEC2,");

                    query.append(" pedSOLCAB.VAL_TIPO_CAMB,");
                    query.append(" segSUB.ACCE_OID_ACCE,");
                    query.append(" pedSOLCAB.VAL_NUME_SOLI,");
                    query.append(" pedSOLCAB.IND_PERM_UNIO_SOL");

                    query.append(
                        " From PED_SOLIC_CABEC pedSOLCAB, CRA_PERIO craPER, PED_TIPO_SOLIc_PAIS pedTISOPA,");
                    query.append(" SEG_MONED segMONE1,");
                    query.append(" SEG_MONED segMONE2,");
                    query.append(" SEG_SUBAC segSUB,");
                    query.append(" SEG_ACCES segACCES,");
                    query.append(" SEG_CANAL segCANA,");
                    query.append(" SEG_PAIS segPAIS");

                    query.append(" WHERE pedSOLCAB.FEC_PROG_FACT_COMP >= TO_NUMBER('"+ sFInicio +"') and");
                    query.append(" pedSOLCAB.FEC_PROG_FACT_COMP <= TO_NUMBER('"+ sFFinal +"') and");
                    query.append(" pedSOLCAB.ZZON_OID_ZONA = '" + elmDtoSecSol.getOidZona().longValue() + "' and");
                    query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS = '" + elmDtoSecSol.getOidTipoSolicitud().longValue() +
                        "' and");
                    query.append(" pedSOLCAB.GRPR_OID_GRUP_PROC = '" + dtoin.getGP().longValue() + "' and");
                    query.append(" pedSOLCAB.PERD_OID_PERI = craPER.OID_PERI and");
                    query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS = pedTISOPA.OID_TIPO_SOLI_PAIS and");

                    query.append(" pedSOLCAB.MONE_OID_MONE = segMONE1.OID_MONE (+) and");
                    query.append(" pedSOLCAB.PAIS_OID_PAIS = segPAIS.OID_PAIS and");
                    query.append(" segMONE2.OID_MONE = segPAIS.MONE_OID_MONE and");

                    query.append(" pedSOLCAB.SBAC_OID_SBAC = segSUB.OID_SBAC and");
                    query.append(" pedSOLCAB.IND_OC = 1 and");

                    //inc.: BELC300007960
                    query.append(" segSUB.ACCE_OID_ACCE = segACCES.OID_ACCE and");
                    query.append(" segACCES.CANA_OID_CANA = segCANA.OID_CANA and");
                    query.append(" segCANA.COD_CANA = '" + ConstantesSEG.COD_CANAL_VD + "') ");

                    if (i < (lista.size() - 1)) {
                        query.append(" UNION ");
                    }
                }

                query.append(" ) ");

                //ejecutamos la consulta
                rsSolCabec = belcorpService.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug(
                    "Seleccion, obtenerSolicitudporPrefacturar, retorna: " +
                    rsSolCabec);

                if (rsSolCabec.getRowCount() > 0) {
                    for (j = 0; j < rsSolCabec.getRowCount(); j++) {
                         DTOSolicitudValidacion dtoSV = new DTOSolicitudValidacion();
                        if (rsSolCabec.getValueAt(j, "OID_SOLI_CABE") != null) {
                            dtoSV.setOidSolicitud(new Long(rsSolCabec.getValueAt(j, "OID_SOLI_CABE").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "MARC_OID_MARC") != null) {
                            dtoSV.setOidMarca(new Long(rsSolCabec.getValueAt(j, "MARC_OID_MARC").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "CANA_OID_CANA") != null) {
                            dtoSV.setOidCanal(new Long(rsSolCabec.getValueAt(j, "CANA_OID_CANA").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "PERD_OID_PERI") != null) {
                            dtoSV.setOidPeriodo(new Long(rsSolCabec.getValueAt(j, "PERD_OID_PERI").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "MONE_OID_MONE") != null) {
                            dtoSV.setOidMoneda(new Long(rsSolCabec.getValueAt(j, "MONE_OID_MONE").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS") != null) {
                            dtoSV.setOidTipoSolPais(new Long(rsSolCabec.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "CLIE_OID_CLIE") != null) {
                            dtoSV.setOidCliente(new Long(rsSolCabec.getValueAt(j, "CLIE_OID_CLIE").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "SBAC_OID_SBAC") != null) {
                            dtoSV.setOidSubAcceso(new Long(rsSolCabec.getValueAt(j, "SBAC_OID_SBAC").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "IND_PEDI_PRUE") != null) {
                          if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_PRUE")).longValue() == 0)
                            dtoSV.setIndSimulacion(Boolean.FALSE);
                          else
                            dtoSV.setIndSimulacion(Boolean.TRUE); 
                        }else{
                          dtoSV.setIndSimulacion(Boolean.FALSE);
                        }

                        if (rsSolCabec.getValueAt(j, "IND_OC") != null) {
                          if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_OC")).longValue() == 0)
                            dtoSV.setIndOrdenCompra(Boolean.FALSE);
                          else
                            dtoSV.setIndOrdenCompra(Boolean.TRUE);
                        }else{
                          dtoSV.setIndOrdenCompra(Boolean.FALSE);
                        }

                        if (rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA") != null) {
                          if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA")).longValue() == 0)
                            dtoSV.setIndPedGTZona(Boolean.FALSE);
                          else
                            dtoSV.setIndPedGTZona(Boolean.TRUE);
                        }else{
                          dtoSV.setIndPedGTZona(Boolean.FALSE);
                        }

                        if (rsSolCabec.getValueAt(j, "ZZON_OID_ZONA") != null) {
                            dtoSV.setZona(new Long(rsSolCabec.getValueAt(j,"ZZON_OID_ZONA").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP") != null) {
                            dtoSV.setUbigeo(new Long(rsSolCabec.getValueAt(j,"VEPO_OID_VALO_ESTR_GEOP").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "MODU_OID_MODU") != null) {
                            dtoSV.setOidModulo(new Long(rsSolCabec.getValueAt(j, "MODU_OID_MODU").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "NUM_DEC1") != null) {
                            dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC1").toString()));
                        } else {
                            if (rsSolCabec.getValueAt(j, "NUM_DEC2") != null) {
                                dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC2").toString()));
                            }
                        }

                        if (rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB") != null) {
                            dtoSV.setTipoCambio(new BigDecimal(rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "ACCE_OID_ACCE") != null) {
                            dtoSV.setOidAcceso(new Long(rsSolCabec.getValueAt(j, "ACCE_OID_ACCE").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "VAL_NUME_SOLI") != null) {
                            dtoSV.setNumSolicitud(new String(rsSolCabec.getValueAt(j, "VAL_NUME_SOLI").toString()));
                        }

                        if (rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL") != null) {
                          if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL")).longValue() == 0)
                            dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                          else
                            dtoSV.setIndUnionSolicitud(Boolean.TRUE);
                        }else{
                          dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                        }

                        registroLista.add(dtoSV);
                    }

                    dtoLS.setLista(registroLista);
                }
            }
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporPrefacturar(DTOInfoMonitor dtoin): Salida ");
        return dtoLS;
    }
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoin
     * pperanzola - 21/09/2005 - se corrige porque se detecto un error
     */
    public DTOListaSolicitudes obtenerSolicitudporGrupoReversion(
        DTOEGrupoReversion dtoin) throws MareException {
        
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporGrupoReversion(DTOEGrupoReversion dtoin): Entrada ");
        BelcorpService belcorpService;
        RecordSet rsSolCabec;
        String codigoError;
        DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();

        int j;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }

        Vector registroLista = new Vector();

        try {
            StringBuffer query = new StringBuffer();

            query.append("Select ");
            query.append(" pedSOLCAB.OID_SOLI_CABE,");
            query.append(" craPER.MARC_OID_MARC,");
            query.append(" craPER.CANA_OID_CANA,");
            query.append(" pedSOLCAB.PERD_OID_PERI,");
            query.append(" pedSOLCAB.MONE_OID_MONE,");
            query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS,");
            query.append(" pedSOLCAB.CLIE_OID_CLIE,");
            query.append(" pedSOLCAB.SBAC_OID_SBAC,");
            query.append(" pedSOLCAB.IND_PEDI_PRUE,");
            query.append(" pedSOLCAB.IND_OC,");
            query.append(" pedTISOPA.IND_PEDI_GT_ZONA,");
            query.append(" pedSOLCAB.ZZON_OID_ZONA,");
            query.append(" pedSOLCAB.VEPO_OID_VALO_ESTR_GEOP,");
            query.append(" pedSOLCAB.MODU_OID_MODU,");
            query.append(" segMONE1.NUM_DECI NUM_DEC1,");
            query.append(" segMONE2.NUM_DECI NUM_DEC2,");
            query.append(" pedSOLCAB.VAL_TIPO_CAMB,");
            query.append(" segSUB.ACCE_OID_ACCE,");
            query.append(" pedSOLCAB.VAL_NUME_SOLI,");
            query.append(" pedSOLCAB.IND_PERM_UNIO_SOL,");
            query.append(" pedSOLCAB.PAIS_OID_PAIS");
            query.append(
                " From PED_SOLIC_CABEC pedSOLCAB, CRA_PERIO craPER, PED_TIPO_SOLIc_PAIS pedTISOPA,");
            query.append(" SEG_MONED segMONE1,");
            query.append(" SEG_MONED segMONE2,");
            query.append(" SEG_SUBAC segSUB,");
            query.append(" SEG_PAIS segPAIS");

            query.append(" Where pedSOLCAB.VAL_GRUP_REVE = '" +
                dtoin.getGrupoReversion() + "'");
            query.append(" and pedSOLCAB.PERD_OID_PERI = craPER.OID_PERI and");
            query.append(
                " pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS = pedTISOPA.OID_TIPO_SOLI_PAIS and");

            query.append(" pedSOLCAB.MONE_OID_MONE = segMONE1.OID_MONE (+) and");
            query.append(" pedSOLCAB.PAIS_OID_PAIS = segPAIS.OID_PAIS and");
            query.append(" segMONE2.OID_MONE = segPAIS.MONE_OID_MONE and");

            query.append(" pedSOLCAB.SBAC_OID_SBAC = segSUB.OID_SBAC");

            //ejecutamos la consulta
            rsSolCabec = belcorpService.dbService.executeStaticQuery(query.toString());

            if (rsSolCabec.getRowCount() > 0) {
                for (j = 0; j < rsSolCabec.getRowCount(); j++) {
                    DTOSolicitudValidacion dtoSV = new DTOSolicitudValidacion();
                    if (rsSolCabec.getValueAt(j, "OID_SOLI_CABE") != null) {
                        dtoSV.setOidSolicitud(new Long(
                                rsSolCabec.getValueAt(j, "OID_SOLI_CABE")
                                          .toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "MARC_OID_MARC") != null) {
                        dtoSV.setOidMarca(new Long(rsSolCabec.getValueAt(j, "MARC_OID_MARC").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "CANA_OID_CANA") != null) {
                        dtoSV.setOidCanal(new Long(rsSolCabec.getValueAt(j, "CANA_OID_CANA").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "PERD_OID_PERI") != null) {
                        dtoSV.setOidPeriodo(new Long(rsSolCabec.getValueAt(j, "PERD_OID_PERI").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "MONE_OID_MONE") != null) {
                        dtoSV.setOidMoneda(new Long(rsSolCabec.getValueAt(j, "MONE_OID_MONE").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS") != null) {
                        dtoSV.setOidTipoSolPais(new Long(rsSolCabec.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "CLIE_OID_CLIE") != null) {
                        dtoSV.setOidCliente(new Long(rsSolCabec.getValueAt(j, "CLIE_OID_CLIE").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "SBAC_OID_SBAC") != null) {
                        dtoSV.setOidSubAcceso(new Long(rsSolCabec.getValueAt(j, "SBAC_OID_SBAC").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "IND_PEDI_PRUE") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_PRUE")).longValue() == 0)
                        dtoSV.setIndSimulacion(Boolean.TRUE);
                      else
                        dtoSV.setIndSimulacion(Boolean.FALSE);
                    }else{
                      dtoSV.setIndSimulacion(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "IND_OC") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_OC")).longValue() == 0)
                        dtoSV.setIndOrdenCompra(Boolean.TRUE);
                      else
                        dtoSV.setIndOrdenCompra(Boolean.FALSE);
                    }else{
                      dtoSV.setIndOrdenCompra(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA")).longValue() == 0)
                        dtoSV.setIndPedGTZona(Boolean.FALSE);
                      else
                        dtoSV.setIndPedGTZona(Boolean.TRUE);
                    }else{
                      dtoSV.setIndPedGTZona(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "ZZON_OID_ZONA") != null) {
                        dtoSV.setZona(new Long(rsSolCabec.getValueAt(j, "ZZON_OID_ZONA").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP") != null) {
                        dtoSV.setUbigeo(new Long(rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "MODU_OID_MODU") != null) {
                        dtoSV.setOidModulo(new Long(rsSolCabec.getValueAt(j, "MODU_OID_MODU").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "NUM_DEC1") != null) {
                        dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC1").toString()));
                    } else {
                        if (rsSolCabec.getValueAt(j, "NUM_DEC2") != null) {
                            dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC2").toString()));
                        }
                    }

                    if (rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB") != null) {
                        dtoSV.setTipoCambio(new BigDecimal(rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "ACCE_OID_ACCE") != null) {
                        dtoSV.setOidAcceso(new Long(rsSolCabec.getValueAt(j, "ACCE_OID_ACCE").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "VAL_NUME_SOLI") != null) {
                        dtoSV.setNumSolicitud(new String(rsSolCabec.getValueAt(j, "VAL_NUME_SOLI").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL")).longValue() == 0)
                        dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                      else
                        dtoSV.setIndUnionSolicitud(Boolean.TRUE);
                    } else {
                      dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "PAIS_OID_PAIS") != null) {  
                        dtoSV.setOidPais(new Long(rsSolCabec.getValueAt(j, "PAIS_OID_PAIS").toString()));
                    }

                    registroLista.add(dtoSV);
                }

                dtoLS.setLista(registroLista);
            }
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporGrupoReversion(DTOEGrupoReversion dtoin): Salida ");
        return dtoLS;
    }

    private HashSet obtenerCamposFechaCabeceraSolicitud() throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerCamposFechaCabeceraSolicitud(): Entrada ");
        HashSet camposFecha = new HashSet();
        camposFecha.add("FEC_PROG_FACT");
        camposFecha.add("FEC_FACT");
        camposFecha.add("FEC_CRON");
        camposFecha.add("FEC_REPO_FALT");
        UtilidadesLog.info("DAOSolicitud.obtenerCamposFechaCabeceraSolicitud(): Salida ");
        return camposFecha;
    }

    public void actualizarValoresFlete(Long oidSolicitud, BigDecimal recargoFleteLocal, BigDecimal recargoFleteDocumento, Integer numDecimales) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarValoresFlete(Long oidSolicitud, BigDecimal recargoFleteLocal, BigDecimal recargoFleteDocumento, Integer numDecimales): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (numDecimales == null) {
            numDecimales = new Integer(2);
        }

        try {
            query.append(" Update PED_SOLIC_CABEC ");
            query.append(" set VAL_RECA_FLET_DOCU = ROUND(" +
            recargoFleteDocumento + "," + numDecimales + " ),");
            query.append(" VAL_RECA_FLET_LOCA = ROUND(" +
            recargoFleteLocal + "," + numDecimales + " ),");
            query.append(" IND_EXEN_FLET = 0 ");
            query.append(" where  OID_SOLI_CABE = " + oidSolicitud.longValue());
            bs.dbService.executeUpdate(query.toString());            
            UtilidadesLog.info("DAOSolicitud.actualizarValoresFlete(Long oidSolicitud, BigDecimal recargoFleteLocal, BigDecimal recargoFleteDocumento, Integer numDecimales): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void revertirEstadoSolicitud(Long oidSolicitud, Long antiguoEstado, Long nuevoEstado) throws MareException {
        UtilidadesLog.info("DAOSolicitud.revertirEstadoSolicitud(Long oidSolicitud, Long antiguoEstado,Long nuevoEstado): Entrada ");
        
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" Update PED_SOLIC_CABEC ");
            query.append(" set ESSO_OID_ESTA_SOLI = " + nuevoEstado.longValue());
            query.append(" where  OID_SOLI_CABE = " + oidSolicitud.longValue());
            query.append(" and ESSO_OID_ESTA_SOLI = " + antiguoEstado.longValue());
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.revertirEstadoSolicitud(Long oidSolicitud, Long antiguoEstado,Long nuevoEstado): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Realiza un UPDATE a la table PED_SOLIC_CABEC filtrando por el oidSolicitud en el campo OID_SOLI_CABE y actualizado el valor del campo IND_EXEN_FLET depdendien del valor recibido en la variable exento.
     * Si exento = TRUE entonces IND_EXEN_FLET=1
     * Si exento = FALSE entonces IND_EXEN_FLET=0
     */
    public void actualizarExentoFlete(Long lngOidSolicitud, Boolean bExento) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarExentoFlete(Long lngOidSolicitud, Boolean bExento): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("Update PED_SOLIC_CABEC ");
            if (bExento.booleanValue()) {
                query.append(" set IND_EXEN_FLET = 1 ");
            } else {
                query.append(" set IND_EXEN_FLET = 0 ");
            }

            query.append(" where  OID_SOLI_CABE = " + lngOidSolicitud);
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOSolicitud.actualizarExentoFlete(Long lngOidSolicitud, Boolean bExento): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
      Accede a la tabla PED_SOLIC_POSIC y elimina todas las entradas con:

      - SOCA_OID_SOLI_CABE == oidSolicitud
      - TPOS_OID_TIPO_POSI == oidTipoPosicion
    *
    *@autor jpbosnja
    **/
    public void eliminarPosicionesCuadre(Long oidSolicitud, Long oidTipoPosicion) throws MareException {
        UtilidadesLog.info("DAOSolicitud.eliminarPosicionesCuadre(Long oidSolicitud, Long oidTipoPosicion): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        query.append(" DELETE PED_SOLIC_POSIC ");
        query.append(" WHERE SOCA_OID_SOLI_CABE = "+ oidSolicitud);
        query.append(" AND TPOS_OID_TIPO_POSI = "+ oidTipoPosicion);

        try {
            bs.dbService.executeUpdate(query.toString());
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.eliminarPosicionesCuadre(Long oidSolicitud, Long oidTipoPosicion): Salida ");
    }

    public void actualizarPosicionesRevertirCuadre(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarPosicionesRevertirCuadre(Long oidSolicitud): Entrada ");

        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        query.append(" UPDATE PED_SOLIC_POSIC ");
        query.append(" SET NUM_UNID_POR_ATEN = NUM_UNID_DEMA ");
        query.append(" , NUM_UNID_DEMA_REAL = NUM_UNID_DEMA ");
        query.append(" WHERE SOCA_OID_SOLI_CABE = "+ oidSolicitud);

        try {
            bs.dbService.executeUpdate(query.toString());
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.actualizarPosicionesRevertirCuadre(Long oidSolicitud): Salida ");
}

    /**
      // Actualiza la posicion recibida
      Accede a la tabla PED_SOLIC_POSIC filtrando por:
      - OID_SOLI_POSI == DTOE.oidPosicionSolicitud
      y actualiza:
      - NUM_UNID_POR_ATEN = DTOE.unidadesPorAtender
      - NUM_UNID_DEMA_REAL = DTOE.unidadesPorAtender
    *
    *@autor jpbosnja
    * modificaciones - 08/08/2005 - BELC300014487 - pperanzola
    **/
    public void actualizarPosicionCuadre(DTOPosicionSolicitud dtoe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarPosicionCuadre(DTOPosicionSolicitud dtoe): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();
        boolean actualizar  = false;
        query.append(" UPDATE PED_SOLIC_POSIC ");
        query.append(" SET ");
        UtilidadesLog.debug(" getUnidadesModificadas = "+  dtoe.getUnidadesModificadas()); 
        UtilidadesLog.debug(" getProductoReemplazado = "+  dtoe.getProductoReemplazado()); 
        
        if (Boolean.TRUE.equals(dtoe.getUnidadesModificadas())){
            query.append(" NUM_UNID_POR_ATEN = "+ dtoe.getUnidadesPorAtender());
            query.append(" , NUM_UNID_DEMA_REAL = "+ dtoe.getUnidadesPorAtender());
            actualizar = true;
        }
        
        if (Boolean.TRUE.equals(dtoe.getProductoReemplazado())){
            if (actualizar){
                query.append(" , ");  
            }
            query.append(" OFDE_OID_DETA_OFER = "+ dtoe.getOidDetalleOferta());
            query.append(" ,VAL_CODI_VENT = '" + dtoe.getCodigoVenta() + "' ");
            query.append(" ,PROD_OID_PROD = "+ dtoe.getProducto() );
            actualizar = true;
        }
        query.append(" WHERE OID_SOLI_POSI = "+ dtoe.getOidPosicionSolicitud());

        try {
            UtilidadesLog.debug(" actualizar = " +  actualizar); 
            if (actualizar){
                bs.dbService.executeUpdate(query.toString());
            }
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.actualizarPosicionCuadre(DTOPosicionSolicitud dtoe): Salida ");
    }
    
    public String generarActualizarPosicionCuadre(DTOPosicionSolicitud dtoe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.generarActualizarPosicionCuadre(DTOPosicionSolicitud dtoe): Entrada ");
        StringBuffer query = new StringBuffer();
        boolean actualizar  = false;
        query.append(" UPDATE PED_SOLIC_POSIC ");
        query.append(" SET ");
		//doliva -- cambio Optimizacion Logs -- 09/04/2010
		if(logAux.isDebugEnabled()){
			UtilidadesLog.debug(" getUnidadesModificadas = "+  dtoe.getUnidadesModificadas()); 
			UtilidadesLog.debug(" getProductoReemplazado = "+  dtoe.getProductoReemplazado()); 
			UtilidadesLog.debug(" VAL_CODI_VENT = " + dtoe.getCodigoVenta() ); 
			UtilidadesLog.debug(" OID_SOLI_POSI = "+ dtoe.getOidPosicionSolicitud() );
		}
        if (Boolean.TRUE.equals(dtoe.getUnidadesModificadas())){
            query.append(" NUM_UNID_POR_ATEN = "+ dtoe.getUnidadesPorAtender());
            query.append(" , NUM_UNID_DEMA_REAL = "+ dtoe.getUnidadesPorAtender());
            actualizar = true;
        }

        if (Boolean.TRUE.equals(dtoe.getProductoReemplazado())){
            if (actualizar){
                query.append(" , ");  
            }
            /*query.append(" OFDE_OID_DETA_OFER = "+ dtoe.getOidDetalleOferta());
            query.append(" ,VAL_CODI_VENT = '" + dtoe.getCodigoVenta() + "' ");
            query.append(" ,PROD_OID_PROD = "+ dtoe.getProducto() );
            query.append(" ,VAL_PREC_CATA_UNIT_LOCA = "+dtoe.getPrecioCatalogoUnitarioLocal());
            // Modificado por SICC20070315 - Rafael Romero - 03/08/2007
            //if  (dtoe.getPrecioCatalogoUnitarioDocumento()!=null){
            //    query.append(" ,VAL_PREC_CONT_UNIT_LOCA = "+dtoe.getPrecioCatalogoUnitarioDocumento());
            //}
            query.append(" ,VAL_PREC_CATA_UNIT_DOCU = "+dtoe.getPrecioCatalogoUnitarioDocumento());
            query.append(" ,VAL_PREC_CONT_UNIT_LOCA = "+dtoe.getPrecioContableUnitarioLocal());
            query.append(" ,VAL_PREC_CONTA_UNIT_DOCU = "+dtoe.getPrecioContableUnitarioDocumento());
            query.append(" ,FOPA_OID_FORM_PAGO = "+dtoe.getFormaPago());
            // Fin modificado SICC20070315*/
            
            query.append(" TPOS_OID_TIPO_POSI = "+ dtoe.getTipoPosicion());
            query.append(" , STPO_OID_SUBT_POSI = "+ dtoe.getSubtipoPosicion());
            if (!actualizar){
                query.append(" , NUM_UNID_DEMA_REAL = "+ dtoe.getUnidadesDemandaReal());
                query.append(" , NUM_UNID_POR_ATEN = "+ dtoe.getUnidadesPorAtender());    
            }
            query.append(" , NUM_UNID_COMPR = "+ dtoe.getUnidadesComprometidas());
            actualizar = true;
        }
        
        query.append(" WHERE OID_SOLI_POSI = "+ dtoe.getOidPosicionSolicitud());

        if (actualizar){
            UtilidadesLog.info("DAOSolicitud.generarActualizarPosicionCuadre(DTOPosicionSolicitud dtoe): Salida ");
            return query.toString();
        }else{
            UtilidadesLog.info("DAOSolicitud.generarActualizarPosicionCuadre(DTOPosicionSolicitud dtoe): Salida ");
            return null;
        }        
    }

    /**
     * Obtiene cabecera de solicitud para oidSolicitud.
     * @autor gdmarzi
     */
    public DTOCabeceraSolicitud obtenerCabeceraSolicitud(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerCabeceraSolicitud(Long oidSolicitud): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();

        query.append(" SELECT PSC.PAIS_OID_PAIS, PSC.PERD_OID_PERI, PSC.SBAC_OID_SBAC, SS.ACCE_OID_ACCE, PSC.CLIE_OID_CLIE  ");
        query.append(" , PSC.TSPA_OID_TIPO_SOLI_PAIS  ");
        query.append(" , PSC.SOCA_OID_DOCU_REFE, PSC.VAL_TIPO_CAMB, PSC.ZZON_OID_ZONA , ZZ.ZORG_OID_REGI ");
        query.append(" FROM PED_SOLIC_CABEC PSC, SEG_SUBAC SS, ZON_ZONA ZZ ");
        query.append(" WHERE PSC.OID_SOLI_CABE = " + oidSolicitud );
        query.append(" AND SS.OID_SBAC =  PSC.SBAC_OID_SBAC  ");
        query.append(" AND PSC.ZZON_OID_ZONA = ZZ.OID_ZONA   ");      

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        DTOCabeceraSolicitud dtoCabeceraSolicitud = new DTOCabeceraSolicitud();
        dtoCabeceraSolicitud.setOidCabeceraSolicitud(oidSolicitud);
        dtoCabeceraSolicitud.setOidPais(new Long(((BigDecimal)rs.getValueAt(0,"PAIS_OID_PAIS")).toString()));
        dtoCabeceraSolicitud.setPeriodo(new Long(((BigDecimal)rs.getValueAt(0,"PERD_OID_PERI")).toString()));
        dtoCabeceraSolicitud.setSubacceso(new Long(((BigDecimal)rs.getValueAt(0,"SBAC_OID_SBAC")).toString()));
        dtoCabeceraSolicitud.setAcceso(new Long(((BigDecimal)rs.getValueAt(0,"ACCE_OID_ACCE")).toString()));
        dtoCabeceraSolicitud.setOidCliente(new Long(((BigDecimal)rs.getValueAt(0,"CLIE_OID_CLIE")).toString()));
        dtoCabeceraSolicitud.setTipoSolicitud(new Long(((BigDecimal)rs.getValueAt(0,"TSPA_OID_TIPO_SOLI_PAIS")).toString()));
        dtoCabeceraSolicitud.setZona(new Long(((BigDecimal)rs.getValueAt(0,"ZZON_OID_ZONA")).toString()));
        dtoCabeceraSolicitud.setRegion(new Long(((BigDecimal)rs.getValueAt(0,"ZORG_OID_REGI")).toString()));        
        BigDecimal oidDocumentoReferencia = (BigDecimal)rs.getValueAt(0,"SOCA_OID_DOCU_REFE");
        if (oidDocumentoReferencia != null)
          dtoCabeceraSolicitud.setOidDocumentoReferencia(new Long(oidDocumentoReferencia.longValue()));
        BigDecimal tipoCambio = (BigDecimal)rs.getValueAt(0,"VAL_TIPO_CAMB");
        if (tipoCambio != null)
          dtoCabeceraSolicitud.setTipoCambio(new Double(tipoCambio.longValue()));          
        
        UtilidadesLog.info("DAOSolicitud.obtenerCabeceraSolicitud(Long oidSolicitud): Salida ");
        return dtoCabeceraSolicitud;
    }


    /**
     * Retorna un ArrayList con las posiones de la solicitud con oidSolicitud.
     * @autor gdmarzi
     * 
     */
    public ArrayList obtenerPosicionesSolicitud(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesSolicitud(Long oidSolicitud): Entrada ");
        Cronometrador.startTransaction("DAOSolicitud.obtenerPosicionesSolicitud");
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();
        ArrayList posiciones = new ArrayList();

        try {

            ArrayList array = new ArrayList();
            array.add(oidSolicitud.toString());
            StringBuffer buf = new StringBuffer();
            buf.append("select * from table(CAST(OBTENER_POSICIONES_SOLICITUD(");
            buf.append(oidSolicitud.toString()+") as OBJ_PED_SPOSIC_CONS_TABLE))");

            rs = bs.dbService.executeStaticQuery(buf.toString());

            for(int i=0; i < rs.getRowCount(); i++) {
                DTOPosicionSolicitud posicion = new DTOPosicionSolicitud();
                posicion.setTipoEstrategia(stringToLong(rs.getValueAt(i,12))); 
                posicion.setOidPosicionSolicitud(stringToLong(rs.getValueAt(i,0))); 
                posicion.setCodigoVenta((rs.getValueAt(i,1)).toString()); 
                posicion.setUnidadesDemandadas(stringToLong(rs.getValueAt(i,2))); 
                posicion.setUnidadesAtendidas(stringToLong(rs.getValueAt(i,3))); 
                if ( (posicion.getTipoEstrategia().intValue() == ConstantesPRE.INDIVIDUAL) ||           //1 o 2!!
                     (posicion.getTipoEstrategia().intValue() == ConstantesPRE.COMPUESTA_FIJA)){
                    posicion.setUnidadesPorAtender(stringToLong(rs.getValueAt(i,2)));
                }else{
                    posicion.setUnidadesPorAtender(stringToLong(rs.getValueAt(i,4))); 
                }
                
                posicion.setUnidadesPorAtender(stringToLong(rs.getValueAt(i,4))); 
                posicion.setUnidadesDemandaReal(stringToLong(rs.getValueAt(i,5))); 
                posicion.setOidDetalleOferta(stringToLong(rs.getValueAt(i,6))); 
                posicion.setTipoPosicion(stringToLong(rs.getValueAt(i,7))); 
                posicion.setSubtipoPosicion(stringToLong(rs.getValueAt(i,8))); 
                posicion.setOidOferta(stringToLong(rs.getValueAt(i,9))); 
                posicion.setNumeroOferta(stringToInteger(rs.getValueAt(i,10))); 
                posicion.setGrupo(stringToInteger(rs.getValueAt(i,11))); 
                posicion.setIndicadorCuadre(stringToLong(rs.getValueAt(i,13))); 
                posicion.setFactorCuadre(stringToLong(rs.getValueAt(i,14)));
                if ((rs.getValueAt(i,15) != null) && (new Long(rs.getValueAt(i,15).toString()).longValue() == 1)) {
                    posicion.setIndCondicionante(Boolean.TRUE); 
                } else {
                    posicion.setIndCondicionante(Boolean.FALSE); 
                    
                }
                posicion.setPosicionRanking(stringToLong(rs.getValueAt(i,16)));  
                posicion.setPagina(stringToInteger(rs.getValueAt(i,17)));
                if (rs.getValueAt(i,18)!=null){
                    posicion.setPrecioCatalogoUnitarioLocal(new BigDecimal(rs.getValueAt(i,18).toString()));
                }
                posicion.setNumeroPosicion(stringToLong(rs.getValueAt(i,19)));
                posicion.setFactorRepeticion(stringToInteger(rs.getValueAt(i,20)));                
                posicion.setProducto(stringToLong(rs.getValueAt(i,21)));
                posicion.setLineaProducto(stringToLong(rs.getValueAt(i,22)));
                posicion.setOidProducto(stringToLong(rs.getValueAt(i,21)));
                if(rs.getValueAt(i,23)!=null){
                  posicion.setCatalogo(new Long(rs.getValueAt(i,23).toString()));
                }
                posiciones.add(posicion);
            }

        } catch (MareException me){
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch (Exception e){
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesSolicitud(Long oidSolicitud): Salida ");
        Cronometrador.endTransaction("DAOSolicitud.obtenerPosicionesSolicitud");
        return posiciones;
    }

    /**
     * Retorna un ArrayList con las tipificaciones y duplas region zona del cliente de la solicitud con oidSolicitud.
     * @autor enozigli
     * enozigli 13/02/09 cambio por solic. PRE-012
     */
    public DTOTipifYUnidadAdminCliente obetenerTipifyUAClienSoli(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obetenerTipifyUAClienSoli(Long oidSolicitud): Entrada ");
        Cronometrador.startTransaction("DAOSolicitud.obetenerTipifyUAClienSoli");
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();
        DTOTipifYUnidadAdminCliente dtoRes = new DTOTipifYUnidadAdminCliente();

        try {

            ArrayList arrayTipif = new ArrayList();
            ArrayList arrayUA = new ArrayList();            
            StringBuffer buf = new StringBuffer();            
            
            buf.append(" SELECT TIP.TICL_OID_TIPO_CLIE TIPO_CLIENTE, TIP.SBTI_OID_SUBT_CLIE SUBTIPO_CLIENTE, ");
            buf.append(" TIP.TCCL_OID_TIPO_CLASI TIPO_CLASI, TIP.CLAS_OID_CLAS CLASIFICACION ");
            buf.append(" FROM PED_SOLIC_CABEC PSC, V_MAE_TIPIF_CLIEN TIP ");
            buf.append(" WHERE PSC.OID_SOLI_CABE = "+oidSolicitud+" ");
            buf.append(" AND PSC.CLIE_OID_CLIE = TIP.CLIE_OID_CLIE ");            

            rs = bs.dbService.executeStaticQuery(buf.toString());
            
            for(int i=0; i < rs.getRowCount(); i++) {
                DTOTipificacion dtoTip = new DTOTipificacion();
                dtoTip.setOidTipoCliente(stringToLong(rs.getValueAt(i,0))); 
                dtoTip.setOidSubtipoCliente(stringToLong(rs.getValueAt(i,1))); 
                dtoTip.setOidTipoClasificacion(stringToLong(rs.getValueAt(i,2))); 
                dtoTip.setOidClasificacion(stringToLong(rs.getValueAt(i,3))); 
                
                arrayTipif.add(dtoTip);
            }
            
            dtoRes.setTipificaciones(arrayTipif);

            buf = new StringBuffer();
            rs = new RecordSet();
            
            buf.append(" SELECT ZZ.ZORG_OID_REGI REGION, ZZ.OID_ZONA ZONA ");
            buf.append(" FROM PED_SOLIC_CABEC PSC, MAE_CLIEN_UNIDA_ADMIN UA, ZON_TERRI_ADMIN TA, ZON_SECCI ZS, ZON_ZONA ZZ ");
            buf.append(" WHERE PSC.OID_SOLI_CABE = "+oidSolicitud+" ");
            buf.append(" AND PSC.CLIE_OID_CLIE = UA.CLIE_OID_CLIE ");
            //--AND UA.IND_ACTI = 1
            buf.append(" AND UA.ZTAD_OID_TERR_ADMI = TA.OID_TERR_ADMI ");
            buf.append(" AND TA.IND_BORR = 0 ");
            buf.append(" AND TA.ZSCC_OID_SECC = ZS.OID_SECC ");
            buf.append(" AND ZS.IND_BORR = 0 ");
            //--AND ZS.IND_ACTI = 1
            buf.append(" AND ZS.ZZON_OID_ZONA = ZZ.OID_ZONA ");    
            
            // sapaza -- SIN RCR-20130521 REEMPLAZO CATALOGO PERU -- 21/05/2013
            buf.append(" AND UA.PERD_OID_PERI_FIN IS NULL ");

            rs = bs.dbService.executeStaticQuery(buf.toString());
            
            for(int i=0; i < rs.getRowCount(); i++) {
                DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
                dtoUA.setOidRegion(stringToLong(rs.getValueAt(i,0)));                 
                dtoUA.setOidZona(stringToLong(rs.getValueAt(i,1))); 
                
                arrayUA.add(dtoUA);
            }
            
            dtoRes.setUnidadesAdmin(arrayUA);
            
        } catch (MareException me){
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch (Exception e){
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obetenerTipifyUAClienSoli(Long oidSolicitud): Salida ");
        Cronometrador.endTransaction("DAOSolicitud.obetenerTipifyUAClienSoli");
        return dtoRes;
    }

    private Long bigDecimalToLong(BigDecimal number) throws Exception{
        if (number==null)
            return null;
        return new Long(number.longValue());
    }
    
    private Long stringToLong(Object number) throws Exception{
        if (number==null)
            return null;
        return new Long(number.toString());
    }
    
    private Integer stringToInteger(Object number) throws Exception{
        if (number==null)
            return null;
        return new Integer(number.toString());
    }

    private Integer bigDecimalToInteger(BigDecimal number) throws Exception{
        if (number==null)
            return null;
        return new Integer(number.intValue());
    }

    private Boolean bigDecimalToBoolean(BigDecimal number) throws Exception{
        if (number==null)
            return null;
        if (number.longValue()==0)
            return Boolean.FALSE;
        else if (number.longValue()==1)
            return Boolean.TRUE;
        else return null;
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    public Long obtenerEstadoSolicitud(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerEstadoSolicitud(Long oidSolicitud): Entrada ");
        String codigoError;
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        

        try {
            buf.append(" SELECT ESSO_OID_ESTA_SOLI ");
            buf.append(" FROM PED_SOLIC_CABEC ");           
            buf.append(" WHERE OID_SOLI_CABE = " + oidSolicitud );            

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(respuesta.esVacio()) {
             codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOSolicitud.obtenerEstadoSolicitud(Long oidSolicitud): Salida ");
        return new Long(((BigDecimal)respuesta.getValueAt(0, "ESSO_OID_ESTA_SOLI")).intValue());
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    public BigDecimal calcularMontoSolicitudesNuevas(Long oidCliente) throws MareException{
        UtilidadesLog.info("DAOSolicitud.calcularMontoSolicitudesNuevas(Long oidCliente): Entrada ");
        String codigoError;
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        

        try {
            buf.append(" SELECT SUM(CA.VAL_TOTA_PAGA_LOCA) MONTO_SOLICITUDES_NUEVAS ");
            buf.append(" FROM PED_SOLIC_CABEC CA ");           
            buf.append(" WHERE CA.CLIE_OID_CLIE = " + oidCliente );
            buf.append(" AND CA.FEC_FACT IS NULL " );       
            buf.append(" AND (CA.ESSO_OID_ESTA_SOLI= " + ConstantesPED.ESTADO_SOLICITUD_VALIDADO );
            buf.append(" OR CA.ESSO_OID_ESTA_SOLI= " + ConstantesPED.ESTADO_SOLICITUD_LIBERADO + ") ");   
            buf.append(" AND (CA.IND_PEDI_PRUE is NULL OR CA.IND_PEDI_PRUE<>1) " );   

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        if(respuesta.getValueAt(0, "MONTO_SOLICITUDES_NUEVAS") == null) {
            UtilidadesLog.info("DAOSolicitud.calcularMontoSolicitudesNuevas(Long oidCliente): Salida ");
            return new BigDecimal(0);
        } else {
            UtilidadesLog.info("DAOSolicitud.calcularMontoSolicitudesNuevas(Long oidCliente): Salida ");
            return (BigDecimal)respuesta.getValueAt(0, "MONTO_SOLICITUDES_NUEVAS");  
        }        
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    public void actualizarEstatusCredito(Long oidSolicitud, Long estatusCredito) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarEstatusCredito(Long oidSolicitud, Long estatusCredito): Entrada ");
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();  

        buf.append(" UPDATE PED_SOLIC_CABEC "); 
        buf.append(" SET ESPE_OID_ESTA_PEDI = " + estatusCredito );      
        buf.append(" WHERE OID_SOLI_CABE = " + oidSolicitud );   
              
        int rowsAffected = 0;
        try{
          rowsAffected = bs.dbService.executeUpdate(buf.toString());

        } catch(Exception e){
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));              
        }   
              
        if (rowsAffected < 1)
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        UtilidadesLog.info("DAOSolicitud.actualizarEstatusCredito(Long oidSolicitud, Long estatusCredito): Salida ");
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    public DTOSolicitudLimiteCredito obtenerFechaMontoTotalSolicitud(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerFechaMontoTotalSolicitud(Long oidSolicitud): Entrada ");
        String codigoError;
        RecordSet respuesta;
        DTOSolicitudLimiteCredito solicitudLimiteCredito = new DTOSolicitudLimiteCredito();
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        

        try {
            buf.append(" SELECT OID_SOLI_CABE, FEC_CRON, VAL_TOTA_PAGA_LOCA ");
            buf.append(" FROM PED_SOLIC_CABEC ");           
            buf.append(" WHERE OID_SOLI_CABE = " + oidSolicitud );            

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(respuesta.esVacio()) {
             codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        // Construye el dto salida
        solicitudLimiteCredito.setOidSolicitud(new Long(((BigDecimal)respuesta.getValueAt(0, "OID_SOLI_CABE")).intValue()));
        solicitudLimiteCredito.setFechaSolicitud((Date)respuesta.getValueAt(0, "FEC_CRON"));
        solicitudLimiteCredito.setMontoSolicitud((BigDecimal)respuesta.getValueAt(0, "VAL_TOTA_PAGA_LOCA"));
        UtilidadesLog.info("DAOSolicitud.obtenerFechaMontoTotalSolicitud(Long oidSolicitud): Salida ");
        return solicitudLimiteCredito;
    }


    /**
     * Autor: Hugo Mansi
     * Fecha: 17/08/2004
     * Recibe  Long oidSolicitud y Long oidIndicadorRevision
     * Devuelve nada
     * Descripción: Modifica el indicador de revisión para una solicitud determinada
    **/
	public void actualizarIndicadorRevision(Long oidSolicitud, Long oidIndicadorRevision) throws MareException{
        UtilidadesLog.info("DAOSolicitud.actualizarIndicadorRevision(Long oidSolicitud, Long oidIndicadorRevision): Entrada ");
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();  

        buf.append(" UPDATE PED_SOLIC_CABEC "); 
        buf.append(" SET INRE_OID_INDI_REVI =  " + oidIndicadorRevision );      
        buf.append(" WHERE OID_SOLI_CABE =  " + oidSolicitud );   
              
        int rowsAffected = 0;
        try{

          rowsAffected = bs.dbService.executeUpdate(buf.toString());

        } catch(Exception e){
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));              
        }   
              
        if (rowsAffected < 1)
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        UtilidadesLog.info("DAOSolicitud.actualizarIndicadorRevision(Long oidSolicitud, Long oidIndicadorRevision): Salida ");
    }
    
    private Long castBigDecimal(BigDecimal param) {
        String s = param.toString();
        Long valLong = new Long(s);

        return valLong;
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       23/12/2004
	 * @version     1.0
	 * @autor       Perez Pablo
	 */
   
    public RecordSet buscarSolicitudVerificacion(DTOBuscarSolicitudVerificacion DTOE) throws MareException {
        UtilidadesLog.info("DAOSolicitud.buscarSolicitudVerificacion(DTOBuscarSolicitudVerificacion DTOE): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
        
        try {
/* Formatted on 2005/01/05 12:36 (Formatter Plus v4.8.0) */
          buf.append("  SELECT sc.oid_soli_cabe OID, gen_canal.val_i18n canal,   ");
          buf.append("         gen_acceso.val_i18n acceso, gen_sb.val_i18n subacceso,   ");
          buf.append("         gen_p.val_i18n periodo, cl.cod_clie codigo_cliente,   ");
          buf.append("         sc.val_nume_soli numero_solicitud, sc.fec_cron fecha_documento,   ");
          buf.append("         tdl.des_tipo_docu tipo_documento_legal   ");
          buf.append("    FROM ped_solic_cabec sc,   ");
          buf.append("         gen_i18n_sicc gen_canal,   ");
          buf.append("         cra_perio p,   ");
          buf.append("         gen_i18n_sicc gen_acceso,   ");
          buf.append("         gen_i18n_sicc gen_sb,   ");
          buf.append("         seg_subac sb,   ");
          buf.append("         gen_i18n_sicc gen_p,   ");
          buf.append("         seg_perio_corpo pc,   ");
          buf.append("         mae_clien cl,   ");
          buf.append("         fac_tipo_docum tdl   ");
          buf.append("   WHERE   ");
          buf.append("         p.oid_peri = sc.perd_oid_peri   ");
          buf.append("     AND gen_canal.val_oid = p.cana_oid_cana   ");
          buf.append("     AND gen_canal.idio_oid_idio =  " + DTOE.getOidIdioma());
          buf.append("     AND gen_canal.attr_enti = 'SEG_CANAL'   ");
          buf.append("     AND   ");
          buf.append("         sb.oid_sbac = sc.sbac_oid_sbac   ");
          buf.append("     AND gen_acceso.val_oid = sb.acce_oid_acce   ");
          buf.append("     AND gen_acceso.idio_oid_idio =  " + DTOE.getOidIdioma());
          buf.append("     AND gen_acceso.attr_enti = 'SEG_ACCES'   ");
          buf.append("     AND   ");
          buf.append("         sb.oid_sbac = sc.sbac_oid_sbac   ");
          buf.append("     AND gen_sb.val_oid = sc.sbac_oid_sbac   ");
          buf.append("     AND gen_sb.idio_oid_idio =  " + DTOE.getOidIdioma());
          buf.append("     AND gen_sb.attr_enti = 'SEG_SUBAC'   ");
          buf.append("     AND   ");
          buf.append("         sc.perd_oid_peri =  " + DTOE.getOidPeriodo());
          buf.append("     AND p.oid_peri = sc.perd_oid_peri   ");
          buf.append("     AND pc.oid_peri = p.peri_oid_peri   ");
          buf.append("     AND gen_p.val_oid = pc.oid_peri   ");
          buf.append("     AND gen_p.idio_oid_idio =  " + DTOE.getOidIdioma());
          buf.append("     AND gen_p.attr_enti = 'SEG_PERIO_CORPO'   ");
          buf.append("     AND   ");
          buf.append("         sc.clie_oid_clie =  " + DTOE.getOidCliente());
          buf.append("     AND cl.oid_clie = sc.clie_oid_clie   ");
          buf.append("     AND   ");
          buf.append("         tdl.oid_tipo_docu = sc.tido_oid_tipo_docu   ");
          buf.append("     AND   ");
          buf.append("         sc.proc_oid_proc =  " + DTOE.getOidProceso());
          buf.append("     AND  ");
          buf.append("         sc.tspa_oid_tipo_soli_pais =  " + DTOE.getOidTipoSolicitud());

          String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), DTOE);
          respuesta = bs.dbService.executeStaticQuery( queryPaginada );
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSolicitud.buscarSolicitudVerificacion(DTOBuscarSolicitudVerificacion DTOE): Salida ");
        return respuesta;
        
    }   

    public RecordSet obtenerPosicionesDigitacion(Long oidCabeceraSolicitud) throws MareException {
        
        /*
        // Obtiene las posiciones de una solicitud que va a ser verificada 
        // De cada posición recuperamos el oid, codigo de venta y las unidades demandadas 
        // Añadimos 3 columnas más al RecordSet en la consulta que serán rellenadas posteriormente 
        // El formato final del RecordSet es el siguiente: 
        // OID | ESTADO | CV_DIGITACION | UD_DIGITACION | CV_VERIFICACION | UD_VERIFICACION 
         * */
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesDigitacion(Long oidCabeceraSolicitud): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
        
        try 
        {
              buf.append("      ");
              buf.append("   SELECT sp.oid_soli_posi OID, '' estado, sp.val_codi_vent cv_digitacion,   ");
              buf.append("          sp.num_unid_dema ud_digitacion, '' cv_verificacion, '' ud_verificacion   ");
              buf.append("     FROM ped_solic_posic sp   ");
              buf.append("    WHERE sp.soca_oid_soli_cabe =  " + oidCabeceraSolicitud);

              respuesta = bs.dbService.executeStaticQuery(buf.toString());
        
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesDigitacion(Long oidCabeceraSolicitud): Salida ");
        return respuesta;    
    }
    
    public RecordSet obtenerValoresTSRegistro(Long oidTipoSolicitudPais) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerValoresTSRegistro(Long oidTipoSolicitudPais): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
    
        try {
        
            buf.append("  SELECT ts.marc_oid_marc MARCA, ac.cana_oid_cana CANAL, tsp.num_soli_lote NSL  ");
            buf.append("    FROM ped_tipo_solic ts, ped_tipo_solic_pais tsp, seg_acces ac  ");
            buf.append("   WHERE ts.acce_oid_acce = ac.oid_acce  ");
            buf.append("     AND tsp.oid_tipo_soli_pais =  " +  oidTipoSolicitudPais);
            buf.append("     AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli      ");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerValoresTSRegistro(Long oidTipoSolicitudPais): Salida ");
        return respuesta;    

    }
    
    
  /**
  * Sistema:     Belcorp
  * Modulo:      PED
  * Fecha:       04/01/2005
  * @version     3.3
  * @autor       Pablo Perez (pperez)
  * Descripcion: 
  * @param    
  * @return   
  * @throws es.indra.mare.common.exception.MareException
  */

    public RecordSet consultarCabeceraSolicitud(DTOOID dtoOid) throws MareException {

        // Consulta la información de la cabecera de la solicitud recibida 
        // Las descripciones traducibles se deben obtener para el idioma DTOOID.idioma 
        UtilidadesLog.info("DAOSolicitud.consultarCabeceraSolicitud(DTOOID dtoOid): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
    
        try {
    			buf.append("select * from table(CAST(pq_ped_solic.ObtenerDetalleSolicitud(");
        	buf.append(dtoOid.getOid()+","+dtoOid.getOidIdioma()+") as OBJ_PED_SOLIC_CONSULTA_TABLE))");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        UtilidadesLog.debug("MONEDA (antes) es: " + respuesta.getValueAt(0,"MONEDA"));
        UtilidadesLog.debug("MONTO1 (antes) es: " + respuesta.getValueAt(0,"MONTO1"));
        UtilidadesLog.debug("MONTO2 (antes) es: " + respuesta.getValueAt(0,"MONTO2"));
        UtilidadesLog.debug("MONTO3 (antes) es: " + respuesta.getValueAt(0,"MONTO3"));
        UtilidadesLog.debug("FLETE (antes) es: " + respuesta.getValueAt(0,"FLETE"));
        UtilidadesLog.debug("IMPORTE_IMPUESTO (antes) es: " + respuesta.getValueAt(0,"IMPORTE_IMPUESTO"));
        UtilidadesLog.debug("TOTAL_PAGAR (antes) es: " + respuesta.getValueAt(0,"TOTAL_PAGAR"));               
            
        //Se cambia el indice por inc. BELC300023533    
            if (respuesta.getValueAt(0,39) == null)  {
                for (int i=1;i<=6;i++) {
                    respuesta.removeColumn(40);
                }
                UtilidadesLog.debug("MONEDA es: " + respuesta.getValueAt(0,"MONEDA"));
                UtilidadesLog.debug("MONTO1_2 es: " + respuesta.getValueAt(0,"MONTO1_2"));
                UtilidadesLog.debug("MONTO2_2 es: " + respuesta.getValueAt(0,"MONTO2_2"));
                UtilidadesLog.debug("MONTO3_2 es: " + respuesta.getValueAt(0,"MONTO3_2"));
                UtilidadesLog.debug("FLETE_1 es: " + respuesta.getValueAt(0,"FLETE_1"));
                UtilidadesLog.debug("IMPORTE_IMPUESTO_1 es: " + respuesta.getValueAt(0,"IMPORTE_IMPUESTO_1"));
                UtilidadesLog.debug("TOTAL_PAGAR_1 es: " + respuesta.getValueAt(0,"TOTAL_PAGAR_1"));
            } else {
                for (int i=1;i<=6;i++) {
                    respuesta.removeColumn(46);
                }
                UtilidadesLog.debug("MONEDA es: " + respuesta.getValueAt(0,"MONEDA"));
                UtilidadesLog.debug("MONTO1 es: " + respuesta.getValueAt(0,"MONTO1"));
                UtilidadesLog.debug("MONTO2 es: " + respuesta.getValueAt(0,"MONTO2"));
                UtilidadesLog.debug("MONTO3 es: " + respuesta.getValueAt(0,"MONTO3"));
                UtilidadesLog.debug("FLETE es: " + respuesta.getValueAt(0,"FLETE"));
                UtilidadesLog.debug("IMPORTE_IMPUESTO es: " + respuesta.getValueAt(0,"IMPORTE_IMPUESTO"));
                UtilidadesLog.debug("TOTAL_PAGAR es: " + respuesta.getValueAt(0,"TOTAL_PAGAR"));               
            }
            
            respuesta.removeColumn(39);
              
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        
        UtilidadesLog.debug("consultarCabeceraSolicitud==>>respuesta es: " + respuesta);
        UtilidadesLog.info("DAOSolicitud.consultarCabeceraSolicitud(DTOOID dtoOid): Salida ");
        return respuesta;    
    }
    
    
    
    public RecordSet obtenerBloquesInformacionPosicion(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerBloquesInformacionPosicion(DTOBelcorp dtoe): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
    
        try {
            buf.append("    SELECT bi.oid_bloq, PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dtoe.getOidIdioma()+",bi.oid_bloq,'PED_BLOQU_INFOR_POSIC')    ");
            buf.append("      FROM ped_bloqu_infor_posic bi   ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerBloquesInformacionPosicion(DTOBelcorp dtoe): Salida ");
        return respuesta;    
    }
    
    public RecordSet obtenerTiposSolicitudModificar(DTOBelcorp dtoe) throws MareException{
        UtilidadesLog.info("DAOSolicitud.obtenerTiposSolicitudModificar(DTOBelcorp dtoe): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
    
        try {
            buf.append("      ");
            buf.append("   SELECT tsp.oid_tipo_soli_pais, gen_ts.val_i18n tipo_solicitud   ");
            buf.append("     FROM ped_tipo_solic_pais tsp,   ");
            buf.append("          gen_i18n_sicc gen_ts,   ");
            buf.append("          ped_tipo_solic ts,   ");
            buf.append("          ped_clase_solic cs,   ");
            buf.append("          seg_acces ac   ");
            buf.append("    WHERE gen_ts.val_oid = tsp.tsol_oid_tipo_soli   ");
            buf.append("      AND gen_ts.idio_oid_idio =  " + dtoe.getOidIdioma());
            buf.append("      AND gen_ts.attr_enti = 'PED_TIPO_SOLIC'   ");
            buf.append("      AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli   ");
            buf.append("      AND cs.ind_orde_comp = 1   ");
            buf.append("      AND ts.clso_oid_clas_soli = cs.oid_clas_soli   ");
            buf.append("      AND ts.acce_oid_acce = ac.oid_acce    ");
            buf.append("      AND (tsp.ind_pedi_gt_zona = 1 OR ac.ind_acce = 'C' OR ac.ind_acce = 'B')   ");
            buf.append("     order by tipo_solicitud  ");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerTiposSolicitudModificar(DTOBelcorp dtoe): Salida ");
        return respuesta;    
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       30/12/2004
    * @version     3.3
    * @autor       Pablo Perez (pperez)
    * Descripcion: 
    * @param    
    * @return   
    * @throws es.indra.mare.common.exception.MareException
    */

    public RecordSet obtenerEstadosSolicitud(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerEstadosSolicitud(DTOBelcorp dtoe): Entrada ");
        String codigoError;
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        

        try {
            buf.append("  SELECT es.oid_esta_soli, PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dtoe.getOidIdioma()+",es.oid_esta_soli,'PED_ESTAD_SOLIC')  ");
            buf.append("    FROM ped_estad_solic es ");
   
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerEstadosSolicitud(DTOBelcorp dtoe): Salida ");
        return respuesta;
    }

    public RecordSet buscarSolicitud(DTOBuscarSolicitud dtoe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.buscarSolicitud(DTOBuscarSolicitud dtoe): Entrada ");
        String codigoError;
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer(); 
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            buf.append("  SELECT sc.oid_soli_cabe OID,  ");
            buf.append("         sc.val_nume_soli numero_solicitud,   ");
            buf.append("         gen_canal.val_i18n canal,  ");
            buf.append("         gen_acceso.val_i18n acceso,   ");
            buf.append("         gen_sb.val_i18n subacceso,  ");
            buf.append("         gen_tsc.val_i18n tipo_solicitud,   ");
            buf.append("         cl.cod_clie codigo_cliente,  ");
            buf.append("         gp.des_grup_proc grupo_procesos,   ");
            buf.append("         pr.cod_proc proceso,  ");
            buf.append("         p.val_nomb_peri  periodo, ");
            buf.append("         sc.fec_cron fecha_documento, ");
            buf.append("         gen_es.val_i18n estado, ");
            buf.append("         SC.MONE_OID_MONE,  ");
            buf.append("         sc.val_tota_paga_docu total_pagar_docu,          ");
            buf.append("         sc.val_tota_paga_loca total_pagar_local   ");
            buf.append("    FROM ped_solic_cabec sc,   ");
            buf.append("         gen_i18n_sicc gen_canal,   ");
            buf.append("         gen_i18n_sicc gen_acceso,   ");
            buf.append("         gen_i18n_sicc gen_sb,   ");
            buf.append("         gen_i18n_sicc gen_tsc,   ");
            buf.append("         gen_i18n_sicc gen_es,   ");            
            buf.append("         ped_tipo_solic ts,   ");
            buf.append("         ped_tipo_solic_pais tsp,   ");
            buf.append("         cra_perio p,   ");
            buf.append("         seg_subac sb,   ");
            buf.append("         mae_clien cl,   ");
            buf.append("         mae_clien cl2,   ");            
            buf.append("         mae_clien cl3,   ");
            buf.append("         ped_grupo_proce gp,   ");
            buf.append("         ped_estad_solic es,  ");
            buf.append("         ped_proce pr,   ");
            buf.append("         seg_acces acc   ");
            buf.append("   WHERE p.oid_peri = sc.perd_oid_peri   ");
            UtilidadesLog.debug("numero solicitud: " + dtoe.getNumeroSolicitud());
            if(dtoe.getNumeroSolicitud()!=null)            
              buf.append("     AND sc.val_nume_soli = " + dtoe.getNumeroSolicitud());
            if (dtoe.getOperacion()!=null && dtoe.getOperacion().equals("M")){
                buf.append("   AND sc.ind_oc = 1 ");
            }
            buf.append("     AND sc.esso_oid_esta_soli = es.oid_esta_soli ");
            buf.append("     AND gen_es.val_oid = es.oid_esta_soli   ");            
            buf.append("     AND gen_es.idio_oid_idio =   " + dtoe.getOidIdioma());
            buf.append("     AND gen_es.attr_enti = 'PED_ESTAD_SOLIC'   ");              
            UtilidadesLog.debug("canal");
            if(dtoe.getCanal()!=null)            
              buf.append("     AND p.cana_oid_cana =  " + dtoe.getCanal());
            buf.append("     AND gen_canal.val_oid = p.cana_oid_cana   ");
            buf.append("     AND gen_canal.idio_oid_idio =   " + dtoe.getOidIdioma());
            buf.append("     AND gen_canal.attr_enti = 'SEG_CANAL'   ");
            UtilidadesLog.debug("acceso");
            if(dtoe.getAcceso()!=null)           
              buf.append("     AND sb.acce_oid_acce =  " + dtoe.getAcceso());
            buf.append("     AND sb.oid_sbac = sc.sbac_oid_sbac   ");
            buf.append("  AND gen_acceso.val_oid = sb.acce_oid_acce ");
            buf.append("  AND acc.OID_ACCE = sb.acce_oid_acce ");
            buf.append("     AND gen_acceso.idio_oid_idio =  " + dtoe.getOidIdioma());
            buf.append("     AND gen_acceso.attr_enti = 'SEG_ACCES'   ");
            UtilidadesLog.debug("subacceso");
            if(dtoe.getSubacceso()!=null)            
              buf.append("     AND  sc.sbac_oid_sbac =   " + dtoe.getSubacceso());
            buf.append("     AND sb.oid_sbac = sc.sbac_oid_sbac   ");
            buf.append("     AND gen_sb.val_oid = sc.sbac_oid_sbac   ");
            buf.append("     AND gen_sb.idio_oid_idio =  " + dtoe.getOidIdioma());
            buf.append("     AND gen_sb.attr_enti = 'SEG_SUBAC'   ");
            UtilidadesLog.debug("tipo solicitud");
            if(dtoe.getTipoSolicitud()!=null)           
              buf.append("     AND sc.tspa_oid_tipo_soli_pais = " + dtoe.getTipoSolicitud());
            buf.append("     AND tsp.oid_tipo_soli_pais = sc.tspa_oid_tipo_soli_pais   ");
            buf.append("     AND ts.oid_tipo_soli = tsp.tsol_oid_tipo_soli   ");
            buf.append("     AND gen_tsc.val_oid = ts.oid_tipo_soli   ");
            buf.append("     AND gen_tsc.idio_oid_idio =   " + dtoe.getOidIdioma());
            buf.append("     AND gen_tsc.attr_enti = 'PED_TIPO_SOLIC'   ");
            if (dtoe.getOperacion()!=null && dtoe.getOperacion().equals("M")){
                buf.append(" AND (   (tsp.ind_pedi_gt_zona = 1 AND sb.ACCE_OID_ACCE = acc.OID_ACCE) ");
                buf.append("  OR (sb.acce_oid_acce = acc.oid_acce AND acc.cod_acce = 'CL' ) )");           
            }
            
            if (dtoe.getOidPais()!=null){
                buf.append(" AND p.pais_oid_pais =  "+dtoe.getOidPais());
            }
            
            if(dtoe.getCliente()!=null)            
              buf.append("     AND cl.cod_clie =   '" + dtoe.getCliente() + "' ");
            buf.append("     AND sc.clie_oid_clie = cl.oid_clie   ");
            buf.append("     AND cl.pais_oid_pais =  " + dtoe.getOidPais());
            if(dtoe.getReceptor()!=null)            
              buf.append("     AND cl3.cod_clie =   '" + dtoe.getReceptor() + "' ");
            buf.append("     AND sc.clie_oid_clie_rece_fact = cl3.oid_clie   ");
            buf.append("     AND cl3.pais_oid_pais =  " + dtoe.getOidPais());            

            if(dtoe.getPagador()!=null)            
              buf.append("     AND cl2.cod_clie =   '" + dtoe.getPagador() + "' ");
            buf.append("     AND sc.clie_oid_clie_paga = cl2.oid_clie   ");
            buf.append("     AND cl2.pais_oid_pais =  " + dtoe.getOidPais());                        

            if(dtoe.getGrupoProcesos()!=null)
              buf.append("     AND sc.grpr_oid_grup_proc =  " + dtoe.getGrupoProcesos());
            buf.append("     AND sc.grpr_oid_grup_proc = gp.oid_grup_proc   ");

            if(dtoe.getProceso()!=null)
              buf.append("     AND sc.proc_oid_proc = " + dtoe.getProceso());
            buf.append("     AND sc.proc_oid_proc = pr.oid_proc   ");


            buf.append("   AND  P.OID_PERI = SC.PERD_OID_PERI " );            
            if(dtoe.getMarca()!=null)
              {
                    UtilidadesLog.debug("marca");
                    buf.append("     AND P.MARC_OID_MARC =  " + dtoe.getMarca()); 
              }



/* PERIODO */
            
            if(dtoe.getPeriodo()!=null){
                    UtilidadesLog.debug("periodo");
                    buf.append("     AND sc.perd_oid_peri = " + dtoe.getPeriodo());
                    buf.append("     AND p.pais_oid_pais =  " + dtoe.getOidPais());            
            }
/* FECHA DOC. DESDE */
/* FECHA DOC. HASTA */
            
            String sFDesde="";
            String sFHasta="";
            if(dtoe.getFechaDesde()!=null){
                    UtilidadesLog.debug("FECHA DOC. DESDE");
                    sFDesde = simpledateformat.format(dtoe.getFechaDesde());
                    buf.append(" AND SC.FEC_CRON >= TO_Date( '" + sFDesde + "', 'DD-MM-YYYY') " );
              }else {
                buf.append(" AND SC.FEC_CRON >= TO_Date( '01/01/1900', 'DD-MM-YYYY') " );
              }

            if(dtoe.getFechaHasta()!=null){
              UtilidadesLog.debug("FECHA DOC. HASTA");
              sFHasta = simpledateformat.format(dtoe.getFechaHasta());
              buf.append(" AND SC.FEC_CRON <= TO_Date( '" + sFHasta + "', 'DD-MM-YYYY') " );
            }else {
              buf.append(" AND SC.FEC_CRON <= TO_Date( '31/12/2050', 'DD-MM-YYYY') " );
            }
            
            if(dtoe.getEstado()!=null){
               UtilidadesLog.debug("ESTADO SOLICITUD");
               buf.append(" AND SC.ESSO_OID_ESTA_SOLI =  " + dtoe.getEstado());   
            }


/* TOTAL A PAGAR DESDE */
/* TOTAL A PAGAR HASTA */

            UtilidadesLog.debug("TOTAL A PAGAR DESDE - TOTAL A PAGAR HASTA");
            
            String a ="";
            String b ="";
            String c ="";
            String d ="";
            if (dtoe.getTotalPagarDesde() != null){
                   UtilidadesLog.debug("TOTAL A PAGAR DESDE");
                   a = " AND SC.VAL_TOTA_PAGA_LOCA >= " + dtoe.getTotalPagarDesde();
            }else  a ="";
                        
            
            if (dtoe.getTotalPagarHasta() != null){
                              b = " AND SC.VAL_TOTA_PAGA_LOCA <= " + dtoe.getTotalPagarHasta();  
            }else     
                               b ="";
            
            if (dtoe.getTotalPagarDesde() != null){
                     UtilidadesLog.debug(" TOTAL A PAGAR HASTA");
                     c = " AND SC.VAL_TOTA_PAGA_DOCU >= " + dtoe.getTotalPagarDesde();
             }else  c ="";
                
              
              if (dtoe.getTotalPagarHasta() != null){
                                  d = "AND SC.VAL_TOTA_PAGA_DOCU <= " + dtoe.getTotalPagarHasta();
              }else      
                  d ="";         
                         
                        
            if (!(a.equals("")&&b.equals("")&&c.equals("")&&d.equals(""))){ 
                buf.append(" AND (    ( SC.MONE_OID_MONE is null" + a + b + ")");
                buf.append(" OR (     ( SC.MONE_OID_MONE is not null"  + c + d + ")" + ")" + ")" );
            }
            
            String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(buf.toString(),dtoe);
            respuesta = UtilidadesDTO.getQuery(sqlPaginado);            
            if (!respuesta.esVacio())  {
                if (respuesta.getValueAt(0,12) == null)
                  respuesta.removeColumn(13);
                else
                  respuesta.removeColumn(14);            
                
                respuesta.removeColumn(12);                    
            } else {
                throw new MareException(new MareException(),
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
            }
            
        } catch(MareException me) {
            throw me;
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSolicitud.buscarSolicitud(DTOBuscarSolicitud dtoe): Salida ");
        return respuesta;
    }


    public void modificarCabecera(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("DAOSolicitud.modificarCabecera(DTOCabeceraSolicitud DTOE): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append(" UPDATE PED_SOLIC_CABEC psc    ");
            query.append(" SET ");
            if (DTOE.getAccesoFisico() != null) {
                query.append("  psc.ACFI_OID_ACCE_FISI = " + DTOE.getAccesoFisico() + ", ");
            }
            if (DTOE.getTipoDespacho() != null) {
                query.append(" 	psc.TIDS_OID_TIPO_DESP = " + DTOE.getTipoDespacho() + ", ");
            }
            if (DTOE.getConsultoraAsociada() != null) {
                query.append(" 	psc.CLIE_OID_CONS_ASOC = " + DTOE.getConsultoraAsociada() + ",  ");
            }
            if (DTOE.getOidReceptorFactura() != null) {
                query.append(" 	psc.CLIE_OID_CLIE_RECE_FACT = " + DTOE.getOidReceptorFactura() + ",  ");
            }
            if (DTOE.getOidPagadorFactura() != null) {
                query.append(" 	psc.CLIE_OID_CLIE_PAGA = "  + DTOE.getOidPagadorFactura() + ",  ");
            }
            if (DTOE.getNumeroClientes() != null) {
                query.append(" 	psc.NUM_CLIEN = " + DTOE.getNumeroClientes() + ",  ");
            }
            if (DTOE.getTipoDocumento() != null) {
                query.append(" 	psc.TDOC_OID_TIPO_DOCU = "  + DTOE.getTipoDocumento() + ",  ");
            }
            if (DTOE.getFormaPago() != null) {
                query.append(" 	psc.FOPA_OID_FORM_PAGO = " + DTOE.getFormaPago() + ",  ");
            }
            if (DTOE.getFechaPrevistaFacturacion() != null) {
                query.append(" 	psc.FEC_PROG_FACT = TRUNC(TO_DATE (substr('" + DTOE.getFechaPrevistaFacturacion() + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')) , ");
            }
            query.append("  psc.OID_SOLI_CABE = " + DTOE.getOidCabeceraSolicitud() ); //pues podrian ser todos nulos
            query.append(" WHERE  ");
            query.append(" 	 psc.OID_SOLI_CABE =  " + DTOE.getOidCabeceraSolicitud());


            bs.dbService.executeUpdate(query.toString());
            int h = bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.modificarCabecera(DTOCabeceraSolicitud DTOE): Salida ");
    }


    public BigDecimal calcularPedidoPromedio(DTOCalculoPedidos dtoe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.calcularPedidoPromedio(DTOCalculoPedidos dtoe): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();
        Integer iNumPeriodos = null;
        RecordSet respuesta;

        try {
                  iNumPeriodos =  this.calcularPeriodosPedido(dtoe);
                  if (iNumPeriodos.equals(new Integer(0))){
                          iNumPeriodos = new Integer(1);
                    }
                  
                  query.append(" SELECT NVL(SUM(A.val_tota_paga_loca), 0) TOTAL ");
                  query.append(" FROM ped_solic_cabec A, cra_perio B, cra_perio C, cra_perio D ");
                  query.append(" WHERE   A.clie_oid_clie = " + dtoe.getOidCliente() + " ");
                  query.append(" AND     A.clso_oid_clas_soli = " + dtoe.getOidClaseSolicitud() + " ");
                  query.append(" AND A.fec_fact IS NOT NULL ");
                  //  Modificado por HRCS - Fecha 11/07/2007 - Incidencia Sicc20070350
                  query.append(" AND NVL(A.ind_ts_no_conso, "+ ConstantesCMN.VAL_FALSE +") = " + ConstantesCMN.VAL_TRUE + " ");  //  Si es '1' es un pedido
                  query.append(" AND NVL(A.ind_pedi_prue, "+ ConstantesCMN.VAL_FALSE +") = " + ConstantesCMN.VAL_FALSE + " ");
                  query.append(" AND B.oid_peri = A.perd_oid_peri  ");
                  query.append(" AND C.oid_peri = " + dtoe.getOidPeriodo1() + " ");
                  query.append(" AND D.oid_peri = " + dtoe.getOidPeriodo2() + " ");
                  query.append(" AND B.fec_inic >= C.fec_inic ");
                  query.append(" AND B.fec_fina <= D.fec_fina ");
                  respuesta = bs.dbService.executeStaticQuery(query.toString());
            
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        if(respuesta.esVacio()) {
            UtilidadesLog.info("DAOSolicitud.calcularPedidoPromedio(DTOCalculoPedidos dtoe): Salida ");
            return new BigDecimal(0);
        } else {
            UtilidadesLog.info("DAOSolicitud.calcularPedidoPromedio(DTOCalculoPedidos dtoe): Salida ");
            return ((BigDecimal)respuesta.getValueAt(0, "TOTAL")).divide(new BigDecimal(iNumPeriodos.intValue()),2,BigDecimal.ROUND_HALF_UP );  
        }    
    }
    

  /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return Integer
   * @param DTOCalculoPedidos to
   */
  public Integer calcularPeriodosPedido(DTOCalculoPedidos dto) throws MareException {
    UtilidadesLog.info("DAOSolicitud.calcularPeriodosPedido(DTOCalculoPedidos dto): Entrada ");
    StringBuffer query = new StringBuffer();
    query.append(" SELECT COUNT(*) FROM (");
    query.append(" SELECT DISTINCT A.perd_oid_peri");
    query.append(" FROM");
    query.append(" ped_solic_cabec A,");
    query.append(" cra_perio B,");
    query.append(" cra_perio C,");
    query.append(" cra_perio D");
    query.append(" WHERE");
    query.append(" A.clie_oid_clie = ").append(dto.getOidCliente());
    query.append(" AND A.clso_oid_clas_soli = ").append(dto.getOidClaseSolicitud());
    query.append(" AND A.fec_fact IS NOT NULL");
    //  Modificado por HRCS - Fecha 11/07/2007 - Incidencia Sicc20070350
    query.append(" AND NVL(A.ind_ts_no_conso, ").append(ConstantesCMN.VAL_FALSE).append(") = ").append(ConstantesCMN.VAL_TRUE); //  Si es '1' es un pedido
    query.append(" AND NVL(A.ind_pedi_prue, ").append(ConstantesCMN.VAL_FALSE).append(") = ").append(ConstantesCMN.VAL_FALSE);
    query.append(" AND B.oid_peri = A.perd_oid_peri");
    query.append(" AND C.oid_peri = ").append(dto.getOidPeriodo1());
    query.append(" AND D.oid_peri = ").append(dto.getOidPeriodo2());
    query.append(" AND B.fec_inic >= C.fec_inic");
    query.append(" AND B.fec_fina <= D.fec_fina");
    query.append(" )");
  
  
    BelcorpService bs = getBelcorpService();
    Integer i = null;
    
    try {
      RecordSet respuesta = bs.dbService.executeStaticQuery(query.toString());
      if(respuesta.esVacio()) {
        i = new Integer(0);
      } else {
        i = new Integer(((BigDecimal)respuesta.getValueAt(0,0)).intValue());
      }
    } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }

    UtilidadesLog.info("DAOSolicitud.calcularPeriodosPedido(DTOCalculoPedidos dto): Salida ");
    return i;
  }
  
  /**
   * @Autor Cristian Valenzuela
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOBuscarPedidosNoFacturados
   */
  public DTOSalida buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto) throws MareException {
      UtilidadesLog.info("DAOSolicitud.buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto): Entrada ");
    
      DTOSalida dtoSalida = new DTOSalida();
      StringBuffer query = new StringBuffer();
      RecordSet rs;
      query.append(" SELECT A.oid_soli_cabe OID, ");   
      query.append(" C.val_i18n as tipoSolicitud, ");   
      query.append(" A.val_nume_soli as numSolicitud, ");   
      query.append(" D.val_i18n as claseSolicitud, ");   
      query.append(" DECODE(A.mone_oid_mone, NULL, A.val_prec_neto_tota_loca, A.val_prec_neto_tota_docu) as totalBruto, ");   
      query.append(" DECODE(A.mone_oid_mone, NULL, A.val_tota_paga_loca, A.val_tota_paga_docu) as totalPagar, ");   
      query.append(" E.val_i18n as estadoSolicitud ");      
      query.append(" FROM ped_solic_cabec A, ");
      query.append(" cra_perio F, ");   
      query.append(" ped_tipo_solic_pais B, ");   
      query.append(" v_gen_i18n_sicc C, ");   
      query.append(" v_gen_i18n_sicc D, ");   
      query.append(" v_gen_i18n_sicc E ");         
      query.append(" WHERE A.oid_soli_cabe > " + dto.getIndicadorSituacion() + " AND ");
      query.append(" F.peri_oid_peri = " + dto.getOidPeriodoCorpo() + " AND ");   
      query.append(" A.perd_oid_peri = F.oid_peri AND ");   
      query.append(" A.fec_fact IS NULL AND ");  
     
      if (dto.getOidCliente()!= null){
        query.append(" A.clie_oid_clie = "+dto.getOidCliente()+"AND");
      }
      
      if (dto.getOidPais()!=null){
        query.append(" A.pais_oid_pais ="+ dto.getOidPais() + "AND");
      }
      query.append(" B.oid_tipo_soli_pais = A.tspa_oid_tipo_soli_pais AND ");   
      query.append(" C.attr_enti = 'PED_TIPO_SOLIC' AND ");   
      query.append(" C.attr_num_atri = 1 AND ");   
      query.append(" C.idio_oid_idio = " + dto.getOidIdioma() + " AND ");   
      query.append(" C.val_oid = B.tsol_oid_tipo_soli AND ");   
      query.append(" D.attr_enti (+) = 'PED_CLASE_SOLIC' AND ");   
      query.append(" D.attr_num_atri (+) = 1 AND ");   
      query.append(" D.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");   
      query.append(" D.val_oid (+) = A.clso_oid_clas_soli AND ");   
      query.append(" E.attr_enti = 'PED_ESTAD_SOLIC' AND ");   
      query.append(" E.attr_num_atri = 1 AND ");   
      query.append(" E.idio_oid_idio = " + dto.getOidIdioma() + " AND ");   
      query.append(" E.val_oid = A.esso_oid_esta_soli ");   
      query.append(" ORDER BY OID");
      try {
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
      }
      catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      if (rs.esVacio()) {
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOSolicitud.buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto): Salida ");
      return dtoSalida;    
  }

      public RecordSet obtenerFlete(DTOPresentarFlete dtoe) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerFlete(DTOPresentarFlete dtoe): Entrada ");
        UtilidadesLog.debug("Entro con DTOPresentarFlete: " + dtoe);
        
        String codigoError;
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
 
        try {
            buf.append(" SELECT "); 
            buf.append(" FL.OID_FLETE OID, ");
            buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( " + dtoe.getOidIdioma() + ",FL.OID_FLETE ,'PED_FLETE') As DESCRIPCION, ");
            buf.append(" FL.VAL_MONT_FIJO MONTO_FIJO, "); 
            buf.append(" FL.VAL_TASA TASA, "); 
            buf.append(" FL.VAL_FLET_MINI FLETE_MINIMO, "); 
            buf.append(" FL.VAL_FLET_MAXI FLETE_MAXIMO, "); 
            buf.append(" FL.VAL_CONT_ENTR CONTRA_ENTREGA, "); 
            buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( " + dtoe.getOidIdioma() + ", FL.TIDS_OID_TIPO_DESP ,'PED_FLETE') AS TIPODESPACHO ");
            buf.append(" FROM "); 
            buf.append(" PED_FLETE FL, "); 
            buf.append(" MAE_CLIEN_CLASI CL, "); 
            buf.append(" MAE_CLIEN_TIPO_SUBTI CTS, "); 
            buf.append(" CRA_PERIO periCli, "); 
            buf.append(" CRA_PERIO periSol "); 
            buf.append(" WHERE "); 
            buf.append(" FL.MARC_OID_MARC = " + dtoe.getOidMarca() + " AND "); 
            buf.append(" FL.CANA_OID_CANA = " + dtoe.getOidCanal() + " AND "); 
            buf.append(" CL.CTSU_OID_CLIE_TIPO_SUBT = CTS.OID_CLIE_TIPO_SUBT AND "); 
            buf.append(" CTS.TICL_OID_TIPO_CLIE = " + dtoe.getOidTipoCliente() + " AND "); 
            buf.append(" CTS.SBTI_OID_SUBT_CLIE = " + dtoe.getOidSubtipoCliente() + " AND "); 
            buf.append(" CTS.CLIE_OID_CLIE = " + dtoe.getOidCliente() + " AND "); 
            buf.append(" CL.PERD_OID_PERI = periCli.OID_PERI AND "); 
            buf.append(" periSol.OID_PERI = " + dtoe.getOidPeriodo() + " AND "); 
            buf.append(" periCli.FEC_INIC <= periSol.FEC_INIC AND "); 
            
            if( Boolean.TRUE.equals(dtoe.getFleteZona()) ) {
              buf.append(" FL.ZZON_ZONA = " + dtoe.getOidZona() + " AND "); 
            }
            else {
              buf.append(" FL.VEPO_UBIG = " + dtoe.getOidUbigeo() + " AND "); 
            }
            buf.append(" FL.TIDS_OID_TIPO_DESP = " + dtoe.getOidTipoDespacho() + " AND "); 
            buf.append(" CTS.TICL_OID_TIPO_CLIE = FL.TICL_OID_TIPO_CLIE AND "); 
            buf.append(" CTS.SBTI_OID_SUBT_CLIE = FL.SBTI_OID_SUBT_CLIE AND "); 
            buf.append(" CL.TCCL_OID_TIPO_CLASI = FL.TCCL_OID_TIPO_CLAS AND "); 
            buf.append(" CL.CLAS_OID_CLAS = FL.CLAS_OID_CLAS ");
   
            if(dtoe.getIndicadorSituacion() != null)
              buf.append(" AND FL.OID_FLETE > ").append(dtoe.getIndicadorSituacion());
            
            if(dtoe.getTamanioPagina() != null)
              buf.append(" AND ROWNUM <= ").append(dtoe.getTamanioPagina());
            
            buf.append(" ORDER BY FL.OID_FLETE ");
 
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch(Exception e) {
           codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
       }
       UtilidadesLog.info("DAOSolicitud.obtenerFlete(DTOPresentarFlete dtoe): Salida ");
       return respuesta;
    }
    
    /**
   * Autor: Cortaberria
   * Fecha: 23/3/2005
   * Modificacion por incidencia BELC300013377
   */
    public RecordSet obtenerSolicitudesAnteriores(DTOSolicitudesAnteriores dto) throws MareException {
      UtilidadesLog.info("DAOSolicitud.obtenerSolicitudesAnteriores(DTOSolicitudesAnteriores dto): Entrada ");
      BelcorpService bs;
      RecordSet respuesta;
      StringBuffer buf = new StringBuffer();

      try {
        bs = BelcorpService.getInstance();
      }
      catch (MareException e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      try {     
        buf.append(" SELECT * from ( ");
        buf.append(" SELECT xxx.*, ROWNUM linea from ( ");
        buf.append(" SELECT ");
        buf.append(" SC.OID_SOLI_CABE OID, ");
        buf.append(" SC.VAL_NUME_SOLI NUMERO_SOLICITUD, ");
        buf.append(" PE.VAL_NOMB_PERI PERIODO, ");
        buf.append(" PR.COD_PROC PROCESO, ");
        buf.append(" I18N_ES.VAL_I18N ESTADO, ");
        buf.append(" SC.VAL_TOTA_PAGA_LOCA TOTAL_PAGAR ");
        buf.append(" FROM ");
        buf.append(" PED_SOLIC_CABEC SC, ");
        buf.append(" SEG_SUBAC SB, ");
        buf.append(" SEG_ACCES AC, ");
        buf.append(" CRA_PERIO PE, ");
        buf.append(" PED_PROCE PR, ");
        buf.append(" GEN_I18N_SICC I18N_ES ");
        buf.append(" WHERE ");
        buf.append(" SC.CLIE_OID_CLIE = " + dto.getOidCliente() + " AND ");
        buf.append(" SC.FEC_FACT IS NULL AND ");
        buf.append(" SC.SBAC_OID_SBAC = SB.OID_SBAC AND ");
        buf.append(" SB.ACCE_OID_ACCE = AC.OID_ACCE AND ");
        buf.append(" AC.CANA_OID_CANA = 1 AND ");
        buf.append(" SC.PERD_OID_PERI = PE.OID_PERI AND ");
        buf.append(" SC.PROC_OID_PROC = PR.OID_PROC AND ");
        buf.append(" SC.ESSO_OID_ESTA_SOLI = I18N_ES.VAL_OID AND ");
        buf.append(" I18N_ES.ATTR_ENTI = 'PED_ESTAD_SOLIC' AND ");
        buf.append(" I18N_ES.IDIO_OID_IDIO = ").append(dto.getOidIdioma()).append(" AND ");
        buf.append(" I18N_ES.ATTR_NUM_ATRI = 1 ");
        buf.append(" ORDER BY ");
        buf.append(" NUMERO_SOLICITUD DESC,SB.COD_SBAC DESC ");
        buf.append(" ) xxx ) ");
        
        if(dto.getIndicadorSituacion() != null || dto.getTamanioPagina() != null) {
          buf.append(" WHERE ");
        }
        
        if(dto.getIndicadorSituacion() != null) {
          buf.append(" linea > ").append(dto.getIndicadorSituacion());
        } else {
          buf.append(" linea > 0 ");
        }
        
        if (dto.getTamanioPagina() != null) {
          buf.append(" AND ROWNUM <= ").append(dto.getTamanioPagina());
        }
        
        respuesta = bs.dbService.executeStaticQuery(buf.toString());
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("DAOSolicitud.obtenerSolicitudesAnteriores(DTOSolicitudesAnteriores dto): Salida ");
      return respuesta;
    }

    //jquiroga - 25/02/2005
    /*
     * Autor: Cortaberria
     * Fecha: 13/05/2005
     * Modificaciones indicadas en la incidencia 17879
     */
    public RecordSet obtenerImportesCobro(DTOOID dtoOID) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerImportesCobro(DTOOID dtoOID): Entrada ");
      BelcorpService bs;
      RecordSet respuesta;
      StringBuffer buf = new StringBuffer();

      try {
        bs = BelcorpService.getInstance();
      }
      catch (MareException e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      try {          
        buf.append(" SELECT ");
        buf.append(" SC2.OID_SOLI_CABE OID_CONSOLIDADO, ");
        buf.append(" SC2.VAL_NUME_SOLI NUMERO_CONSOLIDADO, ");
        buf.append(" P.COD_PROC PROCESO,  ");
        buf.append(" SC2.GRPR_OID_GRUP_PROC GRUPO_PROCESOS,  ");
        buf.append(" SC2.VAL_TOTA_PAGA_LOCA TOTAL_PAGAR_LOCAL,  ");
        buf.append(" SC2.VAL_TOTA_PAGA_DOCU TOTAL_PAGAR_DOCUMENTO,  ");
        buf.append(" I18N.VAL_I18N DIVISA ");
        buf.append(" FROM  ");
        buf.append(" PED_SOLIC_CABEC SC,  ");
        buf.append(" PED_SOLIC_CABEC SC2,  ");
        buf.append(" PED_PROCE P,  ");
        buf.append(" gen_i18n_sicc I18N");
        buf.append(" WHERE  ");
        buf.append(" SC.OID_SOLI_CABE = " + dtoOID.getOid() + " AND  ");
        buf.append(" SC2.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE AND ");
        buf.append(" SC2.PROC_OID_PROC = P.OID_PROC AND ");
        buf.append(" I18N.IDIO_OID_IDIO = " + dtoOID.getOidIdioma() + " AND "); 
        buf.append(" I18N.ATTR_NUM_ATRI = 1 AND "); 
        buf.append(" I18N.ATTR_ENTI = 'SEG_MONED' ");
        buf.append(" AND ( ");
		buf.append(" (I18N.val_oid = SC2.mone_oid_mone AND SC2.mone_oid_mone IS NOT NULL) ");
        buf.append("   OR ( SC2.mone_oid_mone IS NULL AND I18N.val_oid = ");
		buf.append("  (SELECT pais.mone_oid_mone FROM seg_pais pais WHERE pais.oid_pais = " + dtoOID.getOidPais() + " )))");
        
        respuesta = bs.dbService.executeStaticQuery(buf.toString());
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
        UtilidadesLog.info("DAOSolicitud.obtenerImportesCobro(DTOOID dtoOID): Salida ");
      return respuesta;
    }
    
    //jquiroga - 01/03/2005
    public DTOObtenerSolicitudCobro obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE) throws MareException {    
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE): Entrada ");
      BelcorpService bs;
      RecordSet respuesta;
      StringBuffer buf = new StringBuffer();

      try {
        bs = BelcorpService.getInstance();
      }
      catch (MareException e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      try {     
        buf.append(" SELECT  ");
        buf.append(" SC.OID_SOLI_CABE OID_SOLICITUD,  ");
        buf.append(" SC.MONE_OID_MONE MONEDA,  ");
        buf.append(" SC.VAL_TOTA_PAGA_LOCA TOTAL_PAGAR_LOCAL,  ");
        buf.append(" SC.VAL_TOTA_PAGA_DOCU TOTAL_PAGAR_DOCUMENTO  ");
        buf.append(" FROM  ");
        buf.append(" PED_SOLIC_CABEC SC,  ");
        buf.append(" CRA_PERIO P  ");
        buf.append(" WHERE  ");        
        buf.append(" SC.PERD_OID_PERI = P.OID_PERI AND  ");
        buf.append(" P.PAIS_OID_PAIS = " + dtoE.getOidPais() + " AND  ");
        buf.append(" SC.SBAC_OID_SBAC = " + dtoE.getOidSubacceso() + " AND  ");
        buf.append(" SC.VAL_NUME_SOLI = " + dtoE.getNumeroSolicitud() + " AND  ");
        buf.append(" (SC.IND_GENE_CC = 0 OR SC.IND_GENE_CC is null) AND  ");
        buf.append(" (SC.IND_APLI_MANU = 0 OR SC.IND_APLI_MANU is null) AND  ");
        buf.append(" (SC.IND_TS_NO_CONSO = 0 OR SC.IND_TS_NO_CONSO is null) ");
    
        respuesta = bs.dbService.executeStaticQuery(buf.toString());        
        if(respuesta.esVacio())
          return null;

        dtoE.setOidSolicitud(objectToLong(respuesta.getValueAt(0, "OID_SOLICITUD")));
        dtoE.setOidMoneda(objectToLong(respuesta.getValueAt(0, "MONEDA")));
        dtoE.setTotalPagarLocal(objectToBigDecimal(respuesta.getValueAt(0, "TOTAL_PAGAR_LOCAL")));
        dtoE.setTotalPagarDocumento(objectToBigDecimal(respuesta.getValueAt(0, "TOTAL_PAGAR_DOCUMENTO")));
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE): Salida ");
      return dtoE;
    }
    
    //jquiroga - 01/03/2005
    /*
     * Autor: Cortaberria
     * Fecha: 19/05/2005
     * Se agrega en la query validación de que la moneda sea distinta de null y que en 
     * el caso de que lo sea se trae la moneda del pais
     * 
     * Autor: Cortaberria
     * Fecha: 26/05/2005
     * SE MODIFICA LA QUERY SEGON LO ESECIFICADO EN INCIDENCIA BELC300018387
     */
    public RecordSet obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE) throws MareException {    
        UtilidadesLog.info("DAOSolicitud.obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE): Entrada ");
      BelcorpService bs;
      RecordSet respuesta;
      StringBuffer buf = new StringBuffer();

      try {
        bs = BelcorpService.getInstance();
      }
      catch (MareException e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      try {     
        buf.append(" SELECT  ");
        buf.append(" SC.VAL_NUME_SOLI NUMERO_CONSOLIDADO,  ");
        buf.append(" SC.FEC_CRON FECHA,  ");
        buf.append(" SC.VAL_TOTA_PAGA_LOCA TOTAL_PAGAR,  ");
        buf.append(" MO.COD_MONE MONEDA,  ");
        buf.append(" SC.VAL_TOTA_PAGA_DOCU TOTAL_PAGAR_DOCUMENTO ");
        buf.append(" FROM  ");
        buf.append(" PED_SOLIC_CABEC SC,  ");
        buf.append(" CRA_PERIO P,  ");
        buf.append(" SEG_MONED MO ");
        buf.append(" WHERE  ");
        buf.append(" SC.PERD_OID_PERI = P.OID_PERI AND  ");
        buf.append(" P.PAIS_OID_PAIS = " + dtoE.getOidPais() + " AND  ");
        buf.append(" SC.SBAC_OID_SBAC = " + dtoE.getOidSubacceso() + " AND  ");
        buf.append(" SC.CLIE_OID_CLIE = " + dtoE.getOidCliente() + " AND  ");
        buf.append(" (SC.IND_GENE_CC = 0 OR SC.IND_GENE_CC is null) AND  ");
        buf.append(" (SC.IND_APLI_MANU = 0 OR SC.IND_APLI_MANU is null) AND  ");
        buf.append(" (SC.IND_TS_NO_CONSO = 0 OR SC.IND_TS_NO_CONSO is null) AND  ");
        buf.append(" SC.MONE_OID_MONE = MO.OID_MONE(+) ");
    
        respuesta = bs.dbService.executeStaticQuery(buf.toString());
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
        UtilidadesLog.info("DAOSolicitud.obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE): Salida ");
      return respuesta;      
    }
    
    //jquiroga - 01/03/2005
    public void actualizarAplicacionManual(DTOOID  dtoOId) throws MareException {    
        UtilidadesLog.info("DAOSolicitud.actualizarAplicacionManual(DTOOID  dtoOId): Entrada ");
      BelcorpService bs;
      StringBuffer buf = new StringBuffer();

      try {
        bs = BelcorpService.getInstance();
      }
      catch (MareException e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      try {     
        buf.append(" UPDATE ");  
        buf.append(" PED_SOLIC_CABEC ");  
        buf.append(" SET "); 
        buf.append(" IND_APLI_MANU=1 ");  
        buf.append(" WHERE "); 
        buf.append(" OID_SOLI_CABE = " + dtoOId.getOid());    
    
        bs.dbService.executePreparedUpdate(buf.toString(), new Vector());
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
        UtilidadesLog.info("DAOSolicitud.actualizarAplicacionManual(DTOOID  dtoOId): Salida ");
    }
    
    private Long objectToLong(Object obj) {
      if (obj != null) {
        Long result = new Long(((BigDecimal)obj).longValue());
        return result;
      } else {
        return null;
      }
    }
  
    private BigDecimal objectToBigDecimal(Object obj) {
      if (obj != null) {
        return (BigDecimal)obj;
      } else {
        return null;
      }
    }     

    /*
     * Se agrega al arrayList posicionesOrigenIgualCodigo, todas las posiciones de 
     * posicionesOrigen que posean el mismo codigoVenta y unidadesAtendidas que 
     * se está tratando, manteniendo el orden que tienen en posicionesOrigen.
     * Si el codigoVenta es null se verifica por la igualdad del oidPosicion.
     * @cambio por Ped-001
     */
    private void adhieroEnArrayOrigen(String codigoVta, int unidades, Long oidPosOrigen, ArrayList arrayBusqueda, ArrayList arrayDestino) {
        UtilidadesLog.info("DAOSolicitud.adhieroEnArrayOrigen(): Entrada");
        //comparo contra unidades atendidas
        UtilidadesLog.debug("utilizoUnidadesAtendidas..."); 
        for (int a = 0; a < arrayBusqueda.size(); a++) {
            DTOPosicionSolicitud dtoPosicionSolicitudOrigen = (DTOPosicionSolicitud)arrayBusqueda.get(a);
            UtilidadesLog.debug("unidadesAtendidasBusqueda: " + dtoPosicionSolicitudOrigen.getUnidadesAtendidas() + " - unidadesAtendidasOrigen: " + unidades);
            if (dtoPosicionSolicitudOrigen.getUnidadesAtendidas().intValue() == unidades) {
                if (dtoPosicionSolicitudOrigen.getCodigoVenta() != null) {
                    if (dtoPosicionSolicitudOrigen.getCodigoVenta().equals(codigoVta)) {
                        UtilidadesLog.debug("por igual codigo venta, adhiero en posicionesOrigenIgualCodigo: " + dtoPosicionSolicitudOrigen);
                        arrayDestino.add(dtoPosicionSolicitudOrigen);
                    }
                } else {
                    if (dtoPosicionSolicitudOrigen.getOidPosicionSolicitud().equals(oidPosOrigen)) {
                        UtilidadesLog.debug("por igual oidPosicion, adhiero en posicionesOrigenIgualCodigo: " + dtoPosicionSolicitudOrigen);
                        arrayDestino.add(dtoPosicionSolicitudOrigen);
                    }
                }
            }
        }
        UtilidadesLog.info("DAOSolicitud.adhieroEnArrayOrigen(): Salida");        
    }     


    /*
     * Se agrega al arrayList posicionesQueSeTratanIgualCodigo, todas las posiciones de
     * posicionesQueSeTratan que posean el mismo codigoVenta y unidadesDemandadas = unidadesAtendidas
     * que se está tratando, manteniendo el orden que tienen en posicionesQueSeTratan.
     * Si el codigoVenta es null se verifica por la igualdad oidPosicionRecuperacion = oidPosicionOrigen.
     * @cambio por Ped-001
     */
    private void adhieroEnArrayDestino(String codigoVta, int unidades, Long oidPosRecuperacion, ArrayList arrayBusqueda, ArrayList arrayDestino) {
        UtilidadesLog.info("DAOSolicitud.adhieroEnArrayDestino(): Entrada");
        //Comparo contra unidades demandadas
        UtilidadesLog.debug("no utilizoUnidadesAtendidas...");
        for (int b = 0; b < arrayBusqueda.size(); b++) {
            DTOPosicionSolicitud dtoPosicionSolicitudOrigen = (DTOPosicionSolicitud)arrayBusqueda.get(b);
            UtilidadesLog.debug("unidadesDemandadasBusqueda: " + dtoPosicionSolicitudOrigen.getUnidadesDemandadas() + " - unidadesAtendidasOrigen: " + unidades);
            if (dtoPosicionSolicitudOrigen.getUnidadesDemandadas().intValue() == unidades) {
                if (dtoPosicionSolicitudOrigen.getCodigoVenta() != null) {
                    if (dtoPosicionSolicitudOrigen.getCodigoVenta().equals(codigoVta)) {
                        UtilidadesLog.debug("por igual codigo venta, adhiero en posicionesQueSeTratanIgualCodigo: " + dtoPosicionSolicitudOrigen);
                        arrayDestino.add(dtoPosicionSolicitudOrigen);
                    }
                } else {
                    if (dtoPosicionSolicitudOrigen.getOidPosicionSolicitud().equals(oidPosRecuperacion)) {
                        UtilidadesLog.debug("por igual oidPosicion, adhiero en posicionesQueSeTratanIgualCodigo: " + dtoPosicionSolicitudOrigen);
                        arrayDestino.add(dtoPosicionSolicitudOrigen);
                    }
                }
            }
        }
        UtilidadesLog.info("DAOSolicitud.adhieroEnArrayDestino(): Salida");        
    }     


    
     /*Marta Aurora Montiel
       * 05/04/05
       * Incidencia BELC300015788
       * */
      public void actualizaResultadoChequeo(DTOInsertarResultadoChequeo dto) throws MareException {
          UtilidadesLog.info("DAOSolicitud.actualizaResultadoChequeo(DTOInsertarResultadoChequeo dto): Entrada ");
           StringBuffer query = new StringBuffer();
           BelcorpService bs =  BelcorpService.getInstance();
           String codigoError = "";
           try{           
               query.append(" UPDATE PED_SOLIC_CABEC sol ");
               query.append(" SET sol.RECQ_OID_RESU_CHEQ = " + dto.getOidResultadoChequeo());
               query.append(" , sol.VAL_OBSE_REVI = '" + dto.getObservaciones());
               query.append("'");
               query.append(" WHERE sol.OID_SOLI_CABE = " + dto.getOidSolicitudCabecera());
               bs.dbService.executeUpdate(query.toString());

           } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
           }
      
          UtilidadesLog.info("DAOSolicitud.actualizaResultadoChequeo(DTOInsertarResultadoChequeo dto): Salida ");      
      }

       public DTOSalida obtenerPosicionesSolicitudChequeo(DTOOIDPaginado dto) throws MareException {
           UtilidadesLog.info("DAOSolicitud.obtenerPosicionesSolicitudChequeo(DTOOIDPaginado dto): Entrada ");
           StringBuffer query = new StringBuffer();
           BelcorpService bs =  BelcorpService.getInstance();
           String codigoError = "";
           String sql = "";
           RecordSet rs=  new RecordSet();
           DTOSalida dts = new DTOSalida();
           try{
               query.append(" SELECT solp.SOCA_OID_SOLI_CABE OID, solp.val_codi_vent codigo, ");
               query.append(" produ.des_cort descripcion, solp.num_unid_aten numunidad ");
               query.append(" FROM ped_solic_cabec consolidado, ped_solic_cabec solicitud, ped_solic_posic solp, mae_produ produ ");
               query.append(" WHERE solp.prod_oid_prod = produ.oid_prod ");
               query.append(" AND consolidado.OID_SOLI_CABE = " + dto.getOid() +" ");
               query.append(" AND solicitud.SOCA_OID_SOLI_CABE = consolidado.OID_SOLI_CABE ");
               query.append(" AND solp.SOCA_OID_SOLI_CABE = solicitud.OID_SOLI_CABE ");    
               sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto); 
           } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
           }
        
            try {
            rs = bs.dbService.executeStaticQuery(sql);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        dts.setResultado(rs);
        UtilidadesLog.info("DAOSolicitud.obtenerPosicionesSolicitudChequeo(DTOOIDPaginado dto): Salida ");
        return dts;
       
       }
       
    
    /**
    * @autor Juan Pablo Bosnjak
    * @date 24/05/05
    **/
    public ArrayList obtenerSolicitudPorListaConsolidados(ArrayList array) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudPorListaConsolidados(ArrayList array): Entrada ");
        ArrayList salida = new ArrayList();
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;
        RecordSet rsSolCabec=  new RecordSet();
        DTOSalida dts = new DTOSalida();
        query.append(" Select ");
        query.append(" pedSOLCAB.OID_SOLI_CABE,");
        query.append(" craPER.MARC_OID_MARC,");
        query.append(" craPER.CANA_OID_CANA,");
        query.append(" pedSOLCAB.PERD_OID_PERI,");
        query.append(" pedSOLCAB.MONE_OID_MONE,");
        query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS,");
        query.append(" pedSOLCAB.CLIE_OID_CLIE,");
        query.append(" pedSOLCAB.SBAC_OID_SBAC,");
        query.append(" pedSOLCAB.IND_PEDI_PRUE,");
        query.append(" pedSOLCAB.IND_OC,");
        query.append(" pedTISOPA.IND_PEDI_GT_ZONA,");
        query.append(" pedSOLCAB.ZZON_OID_ZONA,");
        query.append(" pedSOLCAB.FEC_PROG_FACT,");
        query.append(" pedSOLCAB.VEPO_OID_VALO_ESTR_GEOP,");
        query.append(" pedSOLCAB.MODU_OID_MODU,");
        query.append(" segMONE1.NUM_DECI NUM_DEC1,");
        query.append(" segMONE2.NUM_DECI NUM_DEC2,");
        query.append(" pedSOLCAB.VAL_TIPO_CAMB,");
        query.append(" segSUB.ACCE_OID_ACCE,");
        query.append(" pedSOLCAB.VAL_NUME_SOLI,");
        query.append(" pedSOLCAB.IND_PERM_UNIO_SOL,");
        query.append(" pedSOLCAB.PAIS_OID_PAIS ");
        query.append(" From PED_SOLIC_CABEC pedSOLCAB, CRA_PERIO craPER, PED_TIPO_SOLIc_PAIS pedTISOPA,");
        query.append(" SEG_MONED segMONE1,");
        query.append(" SEG_MONED segMONE2,");
        query.append(" SEG_SUBAC segSUB,");
        query.append(" SEG_PAIS segPAIS");
        query.append(" Where ");
        query.append(" pedsolcab.PERD_OID_PERI = craper.OID_PERI ");
        query.append(" and pedsolcab.TSPA_OID_TIPO_SOLI_PAIS = pedtisopa.OID_TIPO_SOLI_PAIS  ");
        query.append(" and segmone1.OID_MONE(+) = pedsolcab.MONE_OID_MONE ");
        query.append(" and segmone2.OID_MONE(+) = pedsolcab.MONE_OID_MONE ");        
        query.append(" and pedsolcab.SBAC_OID_SBAC = segsub.OID_SBAC ");        
        query.append(" and pedsolcab.PAIS_OID_PAIS = segpais.OID_PAIS ");
        query.append(" and pedSOLCAB.SOCA_OID_SOLI_CABE in ( ");
        for (int i=0 ; i<array.size(); i++){
            DTOSolicitudValidacion dtoe = ( array.get(i)!=null?(DTOSolicitudValidacion)array.get(i):new DTOSolicitudValidacion());
            if(dtoe.getOidSolicitud()!=null){
                query.append(""+dtoe.getOidSolicitud().longValue());
                if (i<(array.size()-1))
                    query.append(", ");
            }
        }
        query.append(" ) order by TSPA_OID_TIPO_SOLI_PAIS");
        
        UtilidadesLog.debug("query obtenerSolicitudPorListaConsolidados  " + query);
        
        try{
            belcorpService = BelcorpService.getInstance();
            rsSolCabec = belcorpService.dbService.executeStaticQuery(query.toString());
        }catch(Exception e ){
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rsSolCabec.getRowCount() > 0) {
            UtilidadesLog.debug("y retorna: " + rsSolCabec.toString());
            for (int j = 0; j < rsSolCabec.getRowCount(); j++) {
                DTOSolicitudValidacion dtoSV = new DTOSolicitudValidacion();
                if (rsSolCabec.getValueAt(j, "OID_SOLI_CABE") != null) {
                dtoSV.setOidSolicitud(new Long(rsSolCabec.getValueAt(j, "OID_SOLI_CABE").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "MARC_OID_MARC") != null) {
                dtoSV.setOidMarca(new Long(rsSolCabec.getValueAt(j, "MARC_OID_MARC").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "CANA_OID_CANA") != null) {
                dtoSV.setOidCanal(new Long(rsSolCabec.getValueAt(j, "CANA_OID_CANA").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "PERD_OID_PERI") != null) {
                dtoSV.setOidPeriodo(new Long(rsSolCabec.getValueAt(j, "PERD_OID_PERI").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "MONE_OID_MONE") != null) {
                dtoSV.setOidMoneda(new Long(rsSolCabec.getValueAt(j, "MONE_OID_MONE").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS") != null) {
                dtoSV.setOidTipoSolPais(new Long(rsSolCabec.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "CLIE_OID_CLIE") != null) {
                dtoSV.setOidCliente(new Long(rsSolCabec.getValueAt(j, "CLIE_OID_CLIE").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "SBAC_OID_SBAC") != null) {
                dtoSV.setOidSubAcceso(new Long(rsSolCabec.getValueAt(j, "SBAC_OID_SBAC").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "IND_PEDI_PRUE") != null) {
                if ( this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_PRUE")).longValue() == 0)
                  dtoSV.setIndSimulacion(Boolean.FALSE);
                else
                  dtoSV.setIndSimulacion(Boolean.TRUE);
                } else {
                dtoSV.setIndSimulacion(Boolean.FALSE);
                }
                
                if (rsSolCabec.getValueAt(j, "IND_OC") != null) {
                    if ( this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_OC")).longValue() == 0)
                      dtoSV.setIndOrdenCompra(Boolean.FALSE);
                    else
                      dtoSV.setIndOrdenCompra(Boolean.TRUE);
                } else {
                    dtoSV.setIndOrdenCompra(Boolean.FALSE);
                }
                
                if (rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA") != null) {
                    if ( this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA")).longValue() == 0)
                       dtoSV.setIndPedGTZona(Boolean.FALSE);
                    else
                       dtoSV.setIndPedGTZona(Boolean.TRUE);
                }else{
                    dtoSV.setIndPedGTZona(Boolean.FALSE);
                }
                
                if (rsSolCabec.getValueAt(j, "ZZON_OID_ZONA") != null) {
                    dtoSV.setZona(new Long(rsSolCabec.getValueAt(j, "ZZON_OID_ZONA").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "FEC_PROG_FACT") != null) {
                    dtoSV.setFechaProceso((java.sql.Date)rsSolCabec.getValueAt(j, "FEC_PROG_FACT"));
                }                  
                
                if (rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP") != null) {
                dtoSV.setUbigeo(new Long(rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "MODU_OID_MODU") != null) {
                dtoSV.setOidModulo(new Long(rsSolCabec.getValueAt(j, "MODU_OID_MODU").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "NUM_DEC1") != null) {
                dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC1").toString()));
                } else {
                if (rsSolCabec.getValueAt(j, "NUM_DEC2") != null) {
                    dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC2").toString()));
                }
                }
                
                if (rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB") != null) {
                dtoSV.setTipoCambio(new BigDecimal(rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "ACCE_OID_ACCE") != null) {
                dtoSV.setOidAcceso(new Long(rsSolCabec.getValueAt(j, "ACCE_OID_ACCE").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "VAL_NUME_SOLI") != null) {
                dtoSV.setNumSolicitud(new String(rsSolCabec.getValueAt(j, "VAL_NUME_SOLI").toString()));
                }
                
                if (rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL") != null) {
                if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL")).longValue() == 0)
                dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                else
                dtoSV.setIndUnionSolicitud(Boolean.TRUE);
                }else{
                dtoSV.setIndUnionSolicitud(Boolean.FALSE); 
                }
                
                if (rsSolCabec.getValueAt(j, "PAIS_OID_PAIS") != null) {
                dtoSV.setOidPais(new Long(rsSolCabec.getValueAt(j, "PAIS_OID_PAIS").toString()));
                }
                
                salida.add(dtoSV);
            }
        } else {
            UtilidadesLog.debug("Consulta de obtenerSolicitudporTipoSolicitudyZona, no retorna nada");
        }
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudPorListaConsolidados(ArrayList array): Salida ");
        return salida;
    }        


    /**
     * Actualiza las posiciones de una linea faltante, contenidas en el objeto cabecera.
     */
    public void actualizarPosicionFaltante(DTOCabeceraSolicitud cabecera, Long estado, Boolean indRecupObligatoria) throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarPosicionFaltante(DTOCabeceraSolicitud cabecera, Long estado, Boolean indRecupObligatoria): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();
        Long indicadprRecuperacionObligatoria;
        StringBuffer listaOIDs = new StringBuffer();
        
        // si tenemos posiciones faltantes a actualizar
        if ( ! cabecera.getPosiciones().isEmpty() ) {
            Iterator iter = cabecera.getPosiciones().iterator();
            DTOPosicionSolicitud dtoPosicionSolicitud = (DTOPosicionSolicitud)iter.next();
            listaOIDs.append(dtoPosicionSolicitud.getOidPosicionSolicitud());
            while (iter.hasNext()) {
                dtoPosicionSolicitud = (DTOPosicionSolicitud)iter.next();
                listaOIDs.append(", " + dtoPosicionSolicitud.getOidPosicionSolicitud());
            }
            if (indRecupObligatoria.booleanValue()) {
                indicadprRecuperacionObligatoria = new Long(1);
            } else {
                indicadprRecuperacionObligatoria = new Long(0);
            }
    
            try {
                query.append(" UPDATE PED_SOLIC_POSIC ");
                query.append(" SET ");
                query.append("  ESPO_OID_ESTA_POSI = " + estado + ", ");
                query.append("  IND_RECU_OBLI = " + indicadprRecuperacionObligatoria);
                query.append(" WHERE OID_SOLI_POSI IN ( " + listaOIDs + " )" );
                bs.dbService.executeUpdate(query.toString());
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSolicitud.actualizarPosicionFaltante(DTOCabeceraSolicitud cabecera, Long estado, Boolean indRecupObligatoria): Salida ");
    }



  /**
    * @autor mamontie
    * @date 19/01/06
    * Incidencia 22468 Error al reversar GP5
    **/
   public DTOListaSolicitudes obtenerSoliGrupoReverConsolidado(DTOEGrupoReversion dtoin) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerSoliGrupoReverConsolidado -  Entrada dtoin " + dtoin );
        BelcorpService belcorpService;
        RecordSet rsSolCabec;
        String codigoError;
        DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();

        int j;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }

        Vector registroLista = new Vector();

        try {
            StringBuffer query = new StringBuffer();

            query.append("Select ");
            query.append(" pedSOLCAB.OID_SOLI_CABE,");
            query.append(" pedSOLCAB.FEC_PROG_FACT,");
            query.append(" craPER.MARC_OID_MARC,");
            query.append(" craPER.CANA_OID_CANA,");
            query.append(" pedSOLCAB.PERD_OID_PERI,");
            query.append(" pedSOLCAB.MONE_OID_MONE,");
            query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS,");
            query.append(" pedSOLCAB.CLIE_OID_CLIE,");
            query.append(" pedSOLCAB.SBAC_OID_SBAC,");
            query.append(" pedSOLCAB.IND_PEDI_PRUE,");
            query.append(" pedSOLCAB.IND_OC,");
            query.append(" pedTISOPA.IND_PEDI_GT_ZONA,");
            query.append(" pedSOLCAB.ZZON_OID_ZONA,");
            query.append(" pedSOLCAB.VEPO_OID_VALO_ESTR_GEOP,");
            query.append(" pedSOLCAB.MODU_OID_MODU,");
            query.append(" segMONE1.NUM_DECI NUM_DEC1,");
            query.append(" segMONE2.NUM_DECI NUM_DEC2,");
            query.append(" pedSOLCAB.VAL_TIPO_CAMB,");
            query.append(" segSUB.ACCE_OID_ACCE,");
            query.append(" pedSOLCAB.VAL_NUME_SOLI,");
            query.append(" pedSOLCAB.IND_PERM_UNIO_SOL,");
            query.append(" pedSOLCAB.PAIS_OID_PAIS");
            query.append(" From PED_SOLIC_CABEC pedSOLCAB, CRA_PERIO craPER, PED_TIPO_SOLIc_PAIS pedTISOPA,");
            query.append(" SEG_MONED segMONE1,");
            query.append(" SEG_MONED segMONE2,");
            query.append(" SEG_SUBAC segSUB,");
            query.append(" SEG_PAIS segPAIS");
            query.append(" Where ");
            query.append(" pedSOLCAB.PERD_OID_PERI = craPER.OID_PERI and");
            query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS = pedTISOPA.OID_TIPO_SOLI_PAIS and");
            query.append(" pedSOLCAB.MONE_OID_MONE = segMONE1.OID_MONE (+) and");
            query.append(" pedSOLCAB.PAIS_OID_PAIS = segPAIS.OID_PAIS and");
            query.append(" segMONE2.OID_MONE = segPAIS.MONE_OID_MONE and");
            query.append(" pedSOLCAB.SBAC_OID_SBAC = segSUB.OID_SBAC");
            query.append(" AND IND_TS_NO_CONSO = 0 ");
            query.append(" AND pedsolcab.val_grup_reve = '" + dtoin.getGrupoReversion() + "'");
            UtilidadesLog.debug("la consulta de obtenerSoliGrupoReverConsolidado, es: " + query.toString());
            rsSolCabec = belcorpService.dbService.executeStaticQuery(query.toString());

            if (rsSolCabec.getRowCount() > 0) {
                for (j = 0; j < rsSolCabec.getRowCount(); j++) {
                    DTOSolicitudValidacion dtoSV = new DTOSolicitudValidacion();
                    if (rsSolCabec.getValueAt(j, "OID_SOLI_CABE") != null) {
                        dtoSV.setOidSolicitud(new Long(rsSolCabec.getValueAt(j, "OID_SOLI_CABE").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "MARC_OID_MARC") != null) {
                        dtoSV.setOidMarca(new Long(rsSolCabec.getValueAt(j,"MARC_OID_MARC").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "CANA_OID_CANA") != null) {
                        dtoSV.setOidCanal(new Long(rsSolCabec.getValueAt(j, "CANA_OID_CANA").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "PERD_OID_PERI") != null) {
                        dtoSV.setOidPeriodo(new Long(rsSolCabec.getValueAt(j, "PERD_OID_PERI").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "MONE_OID_MONE") != null) {
                        dtoSV.setOidMoneda(new Long(rsSolCabec.getValueAt(j, "MONE_OID_MONE").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS") != null) {
                        dtoSV.setOidTipoSolPais(new Long(rsSolCabec.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "CLIE_OID_CLIE") != null) {
                        dtoSV.setOidCliente(new Long(rsSolCabec.getValueAt(j, "CLIE_OID_CLIE").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "SBAC_OID_SBAC") != null) {
                        dtoSV.setOidSubAcceso(new Long(rsSolCabec.getValueAt(j, "SBAC_OID_SBAC").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "IND_PEDI_PRUE") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_PRUE")).longValue() == 0)
                        dtoSV.setIndSimulacion(Boolean.TRUE);
                      else
                        dtoSV.setIndSimulacion(Boolean.FALSE);
                    }else{
                      dtoSV.setIndSimulacion(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "IND_OC") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_OC")).longValue() == 0)
                        dtoSV.setIndOrdenCompra(Boolean.TRUE);
                      else
                        dtoSV.setIndOrdenCompra(Boolean.FALSE);
                    }else{
                      dtoSV.setIndOrdenCompra(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA")).longValue() == 0)
                        dtoSV.setIndPedGTZona(Boolean.FALSE);
                      else
                        dtoSV.setIndPedGTZona(Boolean.TRUE);
                    }else{
                      dtoSV.setIndPedGTZona(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "ZZON_OID_ZONA") != null) {
                        dtoSV.setZona(new Long(rsSolCabec.getValueAt(j, "ZZON_OID_ZONA").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP") != null) {
                        dtoSV.setUbigeo(new Long(rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "MODU_OID_MODU") != null) {
                        dtoSV.setOidModulo(new Long(rsSolCabec.getValueAt(j, "MODU_OID_MODU").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "NUM_DEC1") != null) {
                        dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC1").toString()));
                    } else {
                        if (rsSolCabec.getValueAt(j, "NUM_DEC2") != null) {
                            dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC2").toString()));
                        }
                    }

                    if (rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB") != null) {
                        dtoSV.setTipoCambio(new BigDecimal(rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "ACCE_OID_ACCE") != null) {
                        dtoSV.setOidAcceso(new Long(rsSolCabec.getValueAt(j, "ACCE_OID_ACCE").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "VAL_NUME_SOLI") != null) {
                        dtoSV.setNumSolicitud(new String(rsSolCabec.getValueAt(j, "VAL_NUME_SOLI").toString()));
                    }

                    if (rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL") != null) {
                      if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL")).longValue() == 0)
                        dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                      else
                        dtoSV.setIndUnionSolicitud(Boolean.TRUE);
                    } else {
                      dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                    }

                    if (rsSolCabec.getValueAt(j, "PAIS_OID_PAIS") != null) {  
                        dtoSV.setOidPais(new Long(rsSolCabec.getValueAt(j, "PAIS_OID_PAIS").toString()));
                    }
                    
                    if (rsSolCabec.getValueAt(j, "FEC_PROG_FACT") != null) {
                        dtoSV.setFechaProceso((java.sql.Date)rsSolCabec.getValueAt(j, "FEC_PROG_FACT"));
                    }                    

                    registroLista.add(dtoSV);
                }

                dtoLS.setLista(registroLista);
            }
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerSoliGrupoReverConsolidado(DTOEGrupoReversion dtoin): Salida " + dtoLS);
        return dtoLS;
    }


    public RecordSet recuperarValoresDefectoPosicion(Long oidTipoSolicitud, Long oidModulo) throws MareException {
        UtilidadesLog.info("DAOSolicitud.recuperarValoresDefectoPosicion(Long oidTipoSolicitud, Long oidModulo): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        ArrayList campos = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ate.cod_atri, vd.val_defe_oid, vd.val_valo_defe      ");
            query.append("   FROM ped_atrib_espec ate, ped_valor_defec_tipo_solic vd   ");
            query.append("  WHERE ate.modu_oid_modu = " + oidModulo);
            query.append("    AND ate.val_form = 'PED_SOLIC_POSIC' ");
            query.append("    AND vd.tspa_oid_tipo_soli_pais = " + oidTipoSolicitud);
            query.append("    AND vd.atre_oid_atri_espe = ate.oid_atri_espe ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

      UtilidadesLog.info("DAOSolicitud.recuperarValoresDefectoPosicion(Long oidTipoSolicitud, Long oidModulo): Salida ");
      return respuesta;
    }
    
  public void asignarValoresDefectoPosicion(Long oidCabeceraSolicitud, RecordSet respuesta) throws MareException {
        UtilidadesLog.info("DAOSolicitud.asignarValoresDefectoPosicion(Long oidCabeceraSolicitud, RecordSet respuesta): Entrada ");
        ArrayList campos = new ArrayList();

        if (!respuesta.esVacio()) {
            ArrayList PK = new ArrayList();
            PK.add(new String("SOCA_OID_SOLI_CABE"));
            PK.add(new String(oidCabeceraSolicitud.toString()));
            campos.add(PK);

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ArrayList atributo = new ArrayList();
                atributo.add((String) respuesta.getValueAt(i, 0));

                if (respuesta.getValueAt(i, 1) != null) {
                    String oidValor = ((BigDecimal) respuesta.getValueAt(i, 1)).toString();
                    atributo.add(oidValor);
                } else if (respuesta.getValueAt(i, 2) != null) {
                    String valor = (String) respuesta.getValueAt(i, 2);
                    atributo.add(valor);
                }
                campos.add(atributo);
            }
            actualizarValorDefectoBBDD("PED_SOLIC_POSIC", campos, null);
        }
        UtilidadesLog.info("DAOSolicitud.asignarValoresDefectoPosicion(Long oidCabeceraSolicitud, RecordSet respuesta): Salida ");        
    }
    
    /**
     * Guarda la información de las posiciones de una Solicitud Cabecera recibida.
     */
    public DTOCabeceraSolicitud guardarPosicion(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOCabeceraSolicitud dtoCabecera): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();
        ArrayList posiciones = dtoCabecera.getPosiciones();
        for (int linea=0; linea < posiciones.size(); linea++){ 
            DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) posiciones.get(linea);
            dtoPos.setOidPosicionSolicitud(SecuenciadorOID.obtenerSiguienteValor("PED_SOPO_SEQ"));

            query.append("INSERT INTO PED_SOLIC_POSIC ( ");
            query.append(" OID_SOLI_POSI, ");
            query.append(" SOCA_OID_SOLI_CABE, ");
            query.append(" COD_POSI, ");
            query.append(" NUM_UNID_DEMA, ");
            query.append(" NUM_UNID_POR_ATEN, ");
            query.append(" TPOS_OID_TIPO_POSI, ");
            query.append(" PROD_OID_PROD, ");
            query.append(" FOPA_OID_FORM_PAGO, ");
            query.append(" VAL_CODI_VENT, ");
            query.append(" ESPO_OID_ESTA_POSI, ");
            query.append(" STPO_OID_SUBT_POSI, ");
            query.append(" VAL_CODI_VENT_FICT, ");
            query.append(" NUM_UNID_DEMA_REAL, ");
            query.append(" VAL_PREC_CATA_UNIT_LOCA, ");
            query.append(" VAL_PREC_CONT_UNIT_LOCA, ");
            query.append(" VAL_PREC_CATA_UNIT_DOCU, ");
            query.append(" VAL_PREC_CONTA_UNIT_DOCU, ");
            query.append(" VAL_PORC_DESC, ");
            query.append(" VAL_IMPO_DESC_UNIT_DOCU, ");
            query.append(" OFDE_OID_DETA_OFER, ");
            query.append(" SOPO_OID_SOLI_POSI, ");
            query.append(" NUM_UNID_COMPR, ");
            query.append(" VAL_IMPO_DESC_UNIT_LOCA, ");
            query.append(" NUM_PAGI_CATA, ");
            query.append(" VAL_CATA ");
            query.append(" ) VALUES ( ");
            query.append(dtoPos.getOidPosicionSolicitud() + ", ");
            query.append(dtoCabecera.getOidCabeceraSolicitud() + ", ");
            if (dtoCabecera.getIndicadorDigitacion()!=null && dtoCabecera.getIndicadorDigitacion().booleanValue()){
                query.append( "(select nvl((max (cod_posi))+10,0) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+dtoCabecera.getOidCabeceraSolicitud()+" ),");
            }else{
                query.append( "(select nvl((max (cod_posi))+1,0) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+dtoCabecera.getOidCabeceraSolicitud()+" ),");
            }
            query.append(dtoPos.getUnidadesDemandadas() + ", ");
            query.append(dtoPos.getUnidadesPorAtender() + ", ");
            query.append(dtoPos.getTipoPosicion() + ", ");
            query.append(dtoPos.getProducto() + ", ");
            query.append(dtoPos.getFormaPago() + ", ");
            query.append( ((dtoPos.getCodigoVenta() != null) ? ("'" + dtoPos.getCodigoVenta() + "'") : null) + ", " );
            query.append(dtoPos.getEstadoPosicion() + ", ");
            query.append(dtoPos.getSubtipoPosicion() + ", ");
            query.append(dtoPos.getCodigoVentaFicticio() + ", ");
            query.append(dtoPos.getUnidadesDemandaReal() + ", ");
            query.append(dtoPos.getPrecioCatalogoUnitarioLocal() + ", ");
            query.append(dtoPos.getPrecioContableUnitarioLocal() + ", ");
            query.append(dtoPos.getPrecioCatalogoUnitarioDocumento() + ", ");
            query.append(dtoPos.getPrecioContableUnitarioDocumento() + ", ");
            query.append(dtoPos.getPorcentajeDescuento() + ", ");
            query.append(dtoPos.getImporteDescuentoUnitarioDocumento() + ", ");
            query.append(dtoPos.getOidDetalleOferta() + ", ");
            query.append(dtoPos.getPosicionRecuperacion() + ", ");
            query.append(dtoPos.getUnidadesComprometidas()+ ", "); 
            query.append(dtoPos.getImporteDescuentoUnitarioLocal()+ ", ");
            query.append(dtoPos.getPagina()+ ", ");
            query.append(dtoPos.getCatalogo());
            query.append(" );");
            posiciones.set(linea, dtoPos);
            dtoCabecera.setPosiciones(posiciones);
        } 
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR: "+query.toString(),e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOCabeceraSolicitud dtoCabecera): Salida ");
        return dtoCabecera;
    }

    //jrivas 20/9/2006 se agrega el acumulador de calctulosTotales.
    private void actualizarAcumulador(DTOCalcularTotales miDto)  throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarAcumulador Entrada ");
        
        BelcorpService bs = getBelcorpService();
        Long cantidad = new Long(1);
        Long oidPeriodo = miDto.getOidPeriodo();
        boolean actualizar = true;

        if (miDto.getIndOC().booleanValue()) {
            if ((miDto.getIndAnul().booleanValue()) || (miDto.getIndDevo().booleanValue())) {
                RecordSet rs2;
                StringBuffer query2 = new StringBuffer();
                query2.append(" SELECT (-1 * COUNT(SC3.OID_SOLI_CABE)) CANTIDAD, SC2.PERD_OID_PERI ");
                query2.append(" FROM PED_SOLIC_CABEC SC, PED_SOLIC_CABEC SC2, PED_SOLIC_CABEC SC3 ");
                query2.append(" WHERE SC.OID_SOLI_CABE = " + miDto.getOidSolicitud());
                query2.append(" AND SC.SOCA_OID_DOCU_REFE = SC2.OID_SOLI_CABE ");
                query2.append(" AND SC2.OID_SOLI_CABE = SC3.SOCA_OID_SOLI_CABE ");
                //Gacevedo. Agregado por cambio SiCC 20070282 en forma tardia por error de analisis
                query2.append(" AND SC3.IND_OC = 1 ");
                //fin de agregado
                query2.append(" GROUP BY SC2.PERD_OID_PERI, SC2.OID_SOLI_CABE ");
                
                try {
                    bs = getBelcorpService();
                    rs2 = bs.dbService.executeStaticQuery(query2.toString());
                } catch (Exception e) {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
    
                if (!rs2.esVacio()) {
                    if (rs2.getValueAt(0, "PERD_OID_PERI") != null) {
                        oidPeriodo = new Long(rs2.getValueAt(0, "PERD_OID_PERI").toString());
                        cantidad = new Long(rs2.getValueAt(0, "CANTIDAD").toString());
                    }
                }
                
                // Si es anulacion o devolucion y el consolidado no contiene OC. Incidencia SiCC 20070282
                if ( rs2.esVacio() ) {
                    actualizar = false;
                }
            } 
            
            //UPDATE
            if (actualizar) {
                RecordSet rs3;
                int aux;
                StringBuffer query3 = new StringBuffer();
                query3.append(" UPDATE PED_SOLIC_CABEC_ACUM2 ");
                query3.append(" SET VAL_MONT_TOTA = VAL_MONT_TOTA + " + miDto.getPrecioDemandaReal());
                if ((!miDto.getIndDevo().booleanValue())) {
                    query3.append(" , VAL_CANT_PEDI = VAL_CANT_PEDI + " + cantidad);
                }
                query3.append(" WHERE CLIE_OID_CLIE = " + miDto.getOidCliente());
                query3.append(" AND PERD_OID_PERI = " + oidPeriodo);
                try {
                    bs = getBelcorpService();
                    aux = bs.dbService.executeUpdate(query3.toString());
                } catch (Exception e) {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }        
                
                if (aux == 0) {        
                    //CREATE
                    query3 = new StringBuffer();
                    query3.append(" INSERT INTO PED_SOLIC_CABEC_ACUM2 (  ");
                    query3.append(" OID_SOCA_ACU2, CLIE_OID_CLIE, PERD_OID_PERI, VAL_CANT_PEDI, VAL_MONT_TOTA )  ");
                    query3.append(" VALUES (PED_SCA2_SEQ.nextval, " + miDto.getOidCliente() + ", " + oidPeriodo + ", " +cantidad+ ", " + miDto.getPrecioDemandaReal() +")");
                    try {
                        bs = getBelcorpService();
                        aux = bs.dbService.executeUpdate(query3.toString());
                    } catch (Exception e) {
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 
                }
            }
        }
        UtilidadesLog.info("DAOSolicitud.actualizarAcumulador Salida ");
    }
    
    //jrivas 21/9/2006 se agrega la reversion del acumulador de calctulosTotales.
    public void revertirAcumulador(DTOSolicitudValidacion dtoin) throws MareException {    
        UtilidadesLog.info("DAOSolicitud.revertirAcumulador Entrada ");
        
        BelcorpService bs = getBelcorpService();
        Long cantidad = new Long(-1);
        Long oidPeriodo = dtoin.getOidPeriodo();
        boolean actualizar = true;

        RecordSet rs;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT pts.IND_ANUL, pts.IND_DEVO, sol_anul.IND_OC, ");
        query.append(" (sol_anul.VAL_PREC_CATA_TOTA_LOC_UNI_DEM) PRECIODEMANDAREAL, ");
        query.append(" sol_anul.FEC_CRON fecCronAnul, sol_anul.FEC_FACT fecFactAnul ");
        query.append(" FROM PED_SOLIC_CABEC sol_anul,  ");
        query.append(" PED_TIPO_SOLIC_PAIS ptsp,  ");
        query.append(" PED_TIPO_SOLIC pts  ");
        query.append(" WHERE sol_anul.OID_SOLI_CABE = " + dtoin.getOidSolicitud());
        query.append(" AND sol_anul.TSPA_OID_TIPO_SOLI_PAIS = ptsp.OID_TIPO_SOLI_PAIS  ");
        query.append(" AND ptsp.TSOL_OID_TIPO_SOLI = pts.OID_TIPO_SOLI  ");
        
        try {
                rs = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        boolean indAnul = false;
        boolean indDevol = false;
        boolean indOC = false;
        BigDecimal precioDemandaReal = new BigDecimal(0);
        
        if (!rs.esVacio()) {
            if (rs.getValueAt(0, "IND_ANUL") != null && rs.getValueAt(0, "IND_ANUL").toString().equals("1")) {
                indAnul = true;
            }      

            if (rs.getValueAt(0, "IND_DEVO") != null && rs.getValueAt(0, "IND_DEVO").toString().equals("1")) {
                indDevol = true;
            } 
            
            if (rs.getValueAt(0, "PRECIODEMANDAREAL") != null) {
                precioDemandaReal = (BigDecimal) rs.getValueAt(0, "PRECIODEMANDAREAL");
            } 

            if (rs.getValueAt(0, "IND_OC") != null && rs.getValueAt(0, "IND_OC").toString().equals("1")) {
                indOC = true;
            } 
            
        }
    
        if (indOC) {
            if ((indAnul) || (indDevol)) {
                RecordSet rs2;
                StringBuffer query2 = new StringBuffer();
                query2.append(" SELECT (-1 * COUNT(SC3.OID_SOLI_CABE)) CANTIDAD, SC2.PERD_OID_PERI ");
                query2.append(" FROM PED_SOLIC_CABEC SC, PED_SOLIC_CABEC SC2, PED_SOLIC_CABEC SC3 ");
                query2.append(" WHERE SC.OID_SOLI_CABE = " + dtoin.getOidSolicitud());
                query2.append(" AND SC.SOCA_OID_DOCU_REFE = SC2.OID_SOLI_CABE ");
                query2.append(" AND SC2.OID_SOLI_CABE = SC3.SOCA_OID_SOLI_CABE ");
                //Gacevedo. Agregado por cambio SiCC 20070282 en forma tardia por error de analisis
                query2.append(" AND SC3.IND_OC = 1 ");
                query2.append(" GROUP BY SC2.PERD_OID_PERI, SC2.OID_SOLI_CABE ");
                
                try {
                    bs = getBelcorpService();
                    rs2 = bs.dbService.executeStaticQuery(query2.toString());
                } catch (Exception e) {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
    
                if (!rs2.esVacio()) {
                    if (rs2.getValueAt(0, "PERD_OID_PERI") != null) {
                        oidPeriodo = new Long(rs2.getValueAt(0, "PERD_OID_PERI").toString());
                        cantidad = new Long(rs2.getValueAt(0, "CANTIDAD").toString());
                    }
                }

                // Si es anulacion o devolucion y el consolidado no contiene OC. Incidencia SiCC 20070282
                if (rs2.esVacio() ) {
                    actualizar = false;
                }
            } 
            
            //UPDATE
            if (actualizar) {
                RecordSet rs3;
                int aux;
                StringBuffer query3 = new StringBuffer();
                query3.append(" UPDATE PED_SOLIC_CABEC_ACUM2 ");
                query3.append(" SET VAL_MONT_TOTA = VAL_MONT_TOTA + " + precioDemandaReal);
                if (!indDevol) {
                    query3.append(" , VAL_CANT_PEDI = VAL_CANT_PEDI + " + cantidad);
                }
                query3.append(" WHERE CLIE_OID_CLIE = " + dtoin.getOidCliente());
                query3.append(" AND PERD_OID_PERI = " + oidPeriodo);
                try {
                    bs = getBelcorpService();
                    aux = bs.dbService.executeUpdate(query3.toString());
                } catch (Exception e) {
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }        
                
                if (aux == 0) {        
                    UtilidadesLog.info("DAOSolicitud.revertirAcumulador NO LO ENCONTRO");    
                } 
            }
        }
        UtilidadesLog.info("DAOSolicitud.revertirAcumulador Salida ");

    }
    
    /** gPineda - 15/01/2007 V_PED_12
     *  Luego de rechazada se actualiza campos,
     *  para no perder el valor del cálculo con el rollback.
     */
    public void actualizarSolicitudRechazo(DTOSolicitudValidacion dtoin) throws MareException{
        UtilidadesLog.info("DAOSolicitud.actualizarSolicitudRechazo(DTOSolicitudValidacion dtoin) : Entrada");
        Vector parametros = new Vector();
        StringBuffer upd = new StringBuffer(" UPDATE PED_SOLIC_CABEC psc SET ");
        
        upd.append(" VAL_TOTA_PAGA_LOCA = ? ");
        parametros.add( dtoin.getPreCatalogoTotalLocal() ); // igual valor que VAL_TOTA_PAGA_LOCA
        
        upd.append(" WHERE psc.OID_SOLI_CABE = ? ");
        parametros.add( dtoin.getOidSolicitud() );
        
        try{
            BelcorpService.getInstance().dbService.executePreparedUpdate(upd.toString(), parametros);
        }catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.actualizarSolicitudRechazo(DTOSolicitudValidacion dtoin) : Salida");
    }
  
    public DTOListaSolicitudes obtenerSolicitudporTipoSolicitudyZonaPerf(DTOInfoMonitor dtoin) throws MareException {
      UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporTipoSolicitudyZonaPerf(DTOInfoMonitor dtoin): Entrada ");
      ArrayList lista = null;        
      lista = dtoin.getSecuencia();
      DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();      
      if ((lista != null) && (lista.size() > 0)) {
        try {
           String sFechaControl = this.insertarZonasYTSPTemporal(lista);
           RecordSet rs = null; 
           
           if (dtoin.getGP().longValue() == ConstantesPED.GP1.longValue()) {
               boolean existenPedidosOC = validaPedidosOrdenesCompra(dtoin, sFechaControl);
               dtoin.setIndOrdenesCompra(existenPedidosOC);
           }
           
           if (dtoin.getGP().longValue() == ConstantesPED.GP3.longValue() || dtoin.getGP().longValue() == ConstantesPED.GP4.longValue()) {
             boolean existeOC = existeOrdenesCompra(dtoin, sFechaControl);
             
             if (existeOC) {
                 String grupoProceso = "GP5";
                 if(dtoin.getGP().longValue() == ConstantesPED.GP3.longValue()) {
                    grupoProceso = "GP4";
                 }
                 
                 String procesosValidados = validarProcesosDependientes(dtoin, grupoProceso);
                
                 if(procesosValidados.length() > 0) { //Hay procesos pendientes de ejecucion, se lanza una excepcion
                    this.deleteZonasYTSPTemporal(sFechaControl);
                     
                    UtilidadesLog.error("Exception: No han culminado Los procesos de " + grupoProceso + 
                                            " en SSICC para la campaña activa y fecha de proceso");
                    
                     //excepcion parametrizada
                     ExcepcionParametrizada exParam = new ExcepcionParametrizada(new MareException(),   
                                                           UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED,"",
                                                               ErroresNegocio.PED_086));
                     exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                     exParam.addParameter( grupoProceso );
                     exParam.addParameter( procesosValidados );
                     throw exParam;
                 }
             }    
           }
           
           rs = this.generarQueryTSPyZonaPerf(dtoin, sFechaControl);
           this.deleteZonasYTSPTemporal(sFechaControl);
           dtoLS = (DTOListaSolicitudes)this.armarDTOSolValidacion(rs);
        } catch (MareException me) {
           throw me; 
        } catch (Exception e) {
           String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
           UtilidadesLog.error("obtenerSolicitudporTipoSolicitudyZonaPerf: Exception",e); 
           throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
        }
      }  
      UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporTipoSolicitudyZonaPerf(DTOInfoMonitor dtoin): Salida ");
      return dtoLS;
    }

   private String insertarZonasYTSPTemporal(ArrayList lista) throws Exception{
     UtilidadesLog.info("DAOSolicitud.insertarZonasYTSPTemporal(ArrayList lista): Entrada ");
     SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
     String sFechaControl = simpledateformat.format(new Date(System.currentTimeMillis()));
     BelcorpService bs = UtilidadesEJB.getBelcorpService();
     long comienzo = System.currentTimeMillis();
     bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", armarInsertPED_TIPO_SOLIC_ZONA_TEMP(lista, sFechaControl).toString());
     //doliva -- cambio Optimizacion Logs -- 09/04/2010
	 if(logAux.isWarnEnabled())
		UtilidadesLog.warn("INSERT TEMPORAL: "+(System.currentTimeMillis()-comienzo));
     UtilidadesLog.info("DAOSolicitud.insertarZonasYTSPTemporal(ArrayList lista): Salida ");
     return sFechaControl;
   }
  
   private StringBuffer armarInsertPED_TIPO_SOLIC_ZONA_TEMP(ArrayList lista, String sFechaControl) {
    StringBuffer salida = new StringBuffer();
     for (int i = 0; i < lista.size(); i++) {
        DTOSecuenciaSolicitudes elmDtoSecSol = (DTOSecuenciaSolicitudes) lista.get(i);
        salida.append(this.INSERT_PED_TIPO_SOLIC_ZONA_TEMP).append(elmDtoSecSol.getOidTipoSolicitud()).append(",");
        salida.append(elmDtoSecSol.getOidZona()).append(",").append(i).append(",");
        salida.append(sFechaControl).append(");");
     }  
     return salida;
   } 
   
   private static String INSERT_PED_TIPO_SOLIC_ZONA_TEMP = "INSERT INTO PED_TIPO_SOLIC_ZONA_TEMP (TSPA_OID_TIPO_SOLI_PAIS, ZZON_OID_ZONA, NUM_ORDE, FEC_CONT) VALUES ("; 
   
   private RecordSet generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl) throws Exception {
     UtilidadesLog.info("DAOSolicitud.generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl): Entrada");
     StringBuffer query = new StringBuffer();
     SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
     String sFInicio = simpledateformat.format(dtoin.getFechaInicio());
     String sFFinal = simpledateformat.format(dtoin.getFechaFin());

     // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
     String valParametro = obtenerValorParametroPais(dtoin.getOidPais(), "PED", "012");
     boolean validacionPROL = false;
     if(valParametro != null && valParametro.equals("S"))
       validacionPROL = true;
         
     query.append("SELECT PSC.OID_SOLI_CABE, ");
   	 query.append("  PER.MARC_OID_MARC, ");
   	 query.append("  PER.CANA_OID_CANA, ");
   	 query.append("  PSC.PERD_OID_PERI, ");
   	 query.append("  PSC.MONE_OID_MONE, ");
   	 query.append("  PSC.TSPA_OID_TIPO_SOLI_PAIS, ");
   	 query.append("  PSC.CLIE_OID_CLIE, ");
   	 query.append("  PSC.SBAC_OID_SBAC, ");
   	 query.append("  PSC.IND_PEDI_PRUE, ");
   	 query.append("  PSC.IND_OC, ");
   	 query.append("  PTSP.IND_PEDI_GT_ZONA, ");
   	 query.append("  PSC.ZZON_OID_ZONA, ");
   	 query.append("  PSC.VEPO_OID_VALO_ESTR_GEOP, ");
   	 query.append("  PSC.MODU_OID_MODU, ");
   	 query.append("  MONED1.NUM_DECI NUM_DEC1, ");
   	 query.append("  MONED2.NUM_DECI NUM_DEC2, ");
   	 query.append("  PSC.VAL_TIPO_CAMB, ");
   	 query.append("  SUBAC.ACCE_OID_ACCE, ");
   	 query.append("  PSC.VAL_NUME_SOLI, ");
   	 query.append("  PSC.IND_PERM_UNIO_SOL, ");
   	 query.append("  PSC.PAIS_OID_PAIS, ");
   	 query.append("  PSC.FEC_PROG_FACT, ");   
   	 query.append("  PSC.IND_TS_NO_CONSO, ");   
   	 query.append("  PSC.GRPR_OID_GRUP_PROC, ");   
   	 query.append("  PQ_APL_AUX.Valor_Gen_I18n_Sicc(").append(dtoin.getOidIdioma()).append(", PER.CANA_OID_CANA ,'SEG_CANAL') as desCanal, ");
   	 query.append("  PER.VAL_NOMB_PERI, ");
	   query.append("  CASE WHEN ((PSC.GRPR_OID_GRUP_PROC + 1) = 5) THEN ");
	   query.append("		  FN_OBT_IND_EJEC_ONLINE((PSC.GRPR_OID_GRUP_PROC + 1), PTSP.TSOL_OID_TIPO_CONS) ");
	   query.append("  ELSE ");
   	 query.append("  		FN_OBT_IND_EJEC_ONLINE((PSC.GRPR_OID_GRUP_PROC + 1), PTSP.OID_TIPO_SOLI_PAIS) ");
     query.append("  END IND_EJEC_ONLI, TSZT.NUM_ORDE, NULL AS ORDEN_TIPIF, ");
      //jrivas 29/1/2008 2007437
      query.append("       CASE WHEN ((TS.IND_ANUL = 1) OR (TS.IND_DEVO = 1)) THEN 1 ");
      query.append("       ELSE 0 ");
      query.append("       END DEV_ANU ");
      
       // sapaza -- PER-SiCC-2011-0726 -- 08/11/2011
       query.append("      ,PSC.IND_RECE_ONLI ");
       
       // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
       if(validacionPROL)
         query.append("      ,PSC.IND_VALI_PROL ");
       else
         query.append("      ,NULL IND_VALI_PROL ");
         
     query.append("FROM PED_SOLIC_CABEC PSC, "); 
	   query.append("     CRA_PERIO PER, ");
	   query.append("     PED_TIPO_SOLIC_PAIS PTSP, ");
	   query.append("     SEG_MONED MONED1, ");
	   query.append("     SEG_MONED MONED2, ");
	   query.append("     SEG_SUBAC SUBAC, ");
	   query.append("     SEG_PAIS PAIS, ");
        query.append("     ped_tipo_solic ts,  ");     
	   query.append("     PED_TIPO_SOLIC_ZONA_TEMP TSZT ");
     query.append("WHERE PSC.FEC_PROG_FACT_COMP >= TO_NUMBER('").append(sFInicio).append("') "); 
     query.append("  AND PSC.FEC_PROG_FACT_COMP <= TO_NUMBER('").append(sFFinal).append("') "); 
     query.append("  AND PSC.ZZON_OID_ZONA = TSZT.ZZON_OID_ZONA "); 
     query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = TSZT.TSPA_OID_TIPO_SOLI_PAIS "); 
     query.append("  AND PSC.GRPR_OID_GRUP_PROC = ").append(dtoin.getGP().longValue()); 
     query.append("  AND PSC.PERD_OID_PERI = PER.OID_PERI ");  
     query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS "); 
     query.append("  AND PSC.MONE_OID_MONE = MONED1.OID_MONE (+) "); 
     query.append("  AND PSC.PAIS_OID_PAIS = PAIS.OID_PAIS "); 
     query.append("  AND MONED2.OID_MONE = PAIS.MONE_OID_MONE "); 
     query.append("  AND PSC.SBAC_OID_SBAC = SUBAC.OID_SBAC "); 
     query.append("  and PTSP.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
     query.append("  AND TSZT.FEC_CONT = TO_NUMBER('").append(sFechaControl).append("') "); 
     
     // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011  
     if(dtoin.getOidPeriodoSiguiente()==null)
        query.append("  AND PSC.PERD_OID_PERI = " + dtoin.getOidPeriodo()); 
     else   
        query.append("  AND PSC.PERD_OID_PERI IN (" + dtoin.getOidPeriodo() + "," + dtoin.getOidPeriodoSiguiente()+ ")"); 
         
     query.append(" ORDER BY TSZT.NUM_ORDE, OID_SOLI_CABE "); 
     
     RecordSet rs = null;
     long comienzo = System.currentTimeMillis();
     rs = this.executeQuery(query.toString());    
	 //doliva -- cambio Optimizacion Logs -- 09/04/2010
	 if(logAux.isWarnEnabled())
		UtilidadesLog.warn("QUERY OBTENER SOLICITUDES POR ZONA Y TSP: "+(System.currentTimeMillis()-comienzo));
     UtilidadesLog.info("DAOSolicitud.generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl): Salida");
     return rs;
   }   
   
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("DAOSolicitud.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery(query);
    } catch ( Exception ex ) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }       
    UtilidadesLog.info("DAOSolicitud.executeQuery(String query): Salida");  
    return rs;
  }

  private Long bigDecimalToLong(Object numero) {    
    if (numero != null) {
      return new Long(((BigDecimal) numero).longValue());
    } else {
      return null;
    }
  }
  
  private void deleteZonasYTSPTemporal (String sFechaControl) throws Exception {
    UtilidadesLog.info("DAOSolicitud.deleteZonasYTSPTemporal(String sFechaControl): Entrada");
    BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
    long comienzo = System.currentTimeMillis();
    StringBuffer delete = new StringBuffer();
    delete.append(DELETE_PED_TIPO_SOLIC_ZONA_TEMP).append(sFechaControl).append("');");
    bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", delete.toString());
	//doliva -- cambio Optimizacion Logs -- 09/04/2010
    if(logAux.isWarnEnabled())
		UtilidadesLog.warn("DELETE TEMPORAL: "+(System.currentTimeMillis()-comienzo));
    UtilidadesLog.info("DAOSolicitud.deleteZonasYTSPTemporal(String sFechaControl): Salida");
  }
  
  private static String DELETE_PED_TIPO_SOLIC_ZONA_TEMP = "DELETE PED_TIPO_SOLIC_ZONA_TEMP WHERE FEC_CONT = TO_NUMBER('";
  
  private DTOListaSolicitudes armarDTOSolValidacion(RecordSet rs) {
    Vector registroLista = new Vector();
    DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();
    if (rs != null && !rs.esVacio()) {
      int size = rs.getRowCount();
      for (int i=0; i<size;i++) {
        DTOSolicitudValidacion dtoSV = new DTOSolicitudValidacion();
        dtoSV.setOidSolicitud(this.bigDecimalToLong(rs.getValueAt(i, "OID_SOLI_CABE")));
        dtoSV.setOidMarca(this.bigDecimalToLong(rs.getValueAt(i, "MARC_OID_MARC")));
        dtoSV.setOidCanal(this.bigDecimalToLong(rs.getValueAt(i, "CANA_OID_CANA")));
        dtoSV.setOidPeriodo(this.bigDecimalToLong(rs.getValueAt(i, "PERD_OID_PERI")));
        dtoSV.setOidMoneda(this.bigDecimalToLong(rs.getValueAt(i, "MONE_OID_MONE")));
        dtoSV.setOidTipoSolPais(this.bigDecimalToLong(rs.getValueAt(i,"TSPA_OID_TIPO_SOLI_PAIS")));
        dtoSV.setOidCliente(this.bigDecimalToLong(rs.getValueAt(i, "CLIE_OID_CLIE")));
        dtoSV.setOidSubAcceso(this.bigDecimalToLong(rs.getValueAt(i, "SBAC_OID_SBAC")));
        dtoSV.setIndSimulacion(this.bigDToBoolean(rs.getValueAt(i, "IND_PEDI_PRUE")));
        dtoSV.setIndOrdenCompra(this.bigDToBoolean(rs.getValueAt(i, "IND_OC")));   
        dtoSV.setIndPedGTZona(this.bigDToBoolean(rs.getValueAt(i, "IND_PEDI_GT_ZONA")));        
        dtoSV.setZona(this.bigDecimalToLong(rs.getValueAt(i, "ZZON_OID_ZONA")));
        dtoSV.setUbigeo(this.bigDecimalToLong(rs.getValueAt(i, "VEPO_OID_VALO_ESTR_GEOP")));
        dtoSV.setOidModulo(this.bigDecimalToLong(rs.getValueAt(i, "MODU_OID_MODU")));
        if (rs.getValueAt(i, "NUM_DEC1") != null) {
          dtoSV.setNumDecimales(new Integer(rs.getValueAt(i, "NUM_DEC1").toString()));
        } else {
          if (rs.getValueAt(i, "NUM_DEC2") != null) {
            dtoSV.setNumDecimales(new Integer(rs.getValueAt(i, "NUM_DEC2").toString()));
          }
        }
        if (rs.getValueAt(i, "VAL_TIPO_CAMB") != null) {
           dtoSV.setTipoCambio(new BigDecimal(rs.getValueAt(i, "VAL_TIPO_CAMB").toString()));
        }
        dtoSV.setOidAcceso(this.bigDecimalToLong(rs.getValueAt(i, "ACCE_OID_ACCE")));
        if (rs.getValueAt(i, "VAL_NUME_SOLI") != null) {
          dtoSV.setNumSolicitud(new String(rs.getValueAt(i, "VAL_NUME_SOLI").toString()));
        }
        dtoSV.setIndUnionSolicitud(this.bigDToBoolean(rs.getValueAt(i, "IND_PERM_UNIO_SOL")));   
        dtoSV.setOidPais(this.bigDecimalToLong(rs.getValueAt(i, "PAIS_OID_PAIS")));
        if (rs.getValueAt(i, "FEC_PROG_FACT") != null) {
           dtoSV.setFechaProceso((java.sql.Date)rs.getValueAt(i, "FEC_PROG_FACT"));
        }
        dtoSV.setIndNoConso(this.bigDecimalToLong(rs.getValueAt(i, "IND_TS_NO_CONSO")));
        dtoSV.setGP(this.bigDecimalToLong(rs.getValueAt(i, "GRPR_OID_GRUP_PROC")));
        if (rs.getValueAt(i, "DESCANAL") != null) {
          dtoSV.setDescripcionCanal(rs.getValueAt(i, "DESCANAL").toString());
        }
        if (rs.getValueAt(i, "VAL_NOMB_PERI") != null) {
          dtoSV.setNombrePeriodo(rs.getValueAt(i, "VAL_NOMB_PERI").toString());
        }
        dtoSV.setIndEjecOnLine(this.bigDToBoolean(rs.getValueAt(i, "IND_EJEC_ONLI")));
        dtoSV.setNumeroOrden(this.bigDecimalToLong(rs.getValueAt(i, "NUM_ORDE")));    
        dtoSV.setOrdenTipificacion(this.bigDecimalToLong(rs.getValueAt(i, "ORDEN_TIPIF")));
        if (dtoSV.getOrdenTipificacion() == null) {
          dtoSV.setOrdenTipificacion(new Long(-1));
        }
        //jrivas 29/1/2008 2007437
        dtoSV.setIndDevoAnul(this.bigDToBoolean(rs.getValueAt(i, "DEV_ANU")));
        
        // sapaza -- PER-SiCC-2011-0726 -- 08/11/2011
        if (rs.getValueAt(i, "IND_RECE_ONLI") != null) {
            if(rs.getValueAt(i, "IND_RECE_ONLI").toString().equals("1"))
                dtoSV.setIndRecepcionOnline(Boolean.TRUE);
            else    
                dtoSV.setIndRecepcionOnline(Boolean.FALSE);
        } else    
            dtoSV.setIndRecepcionOnline(Boolean.FALSE);
            
        // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
        if (rs.getValueAt(i, "IND_VALI_PROL") != null) {
            if(rs.getValueAt(i, "IND_VALI_PROL").toString().equals("1"))
                dtoSV.setIndValidacionPROL(Boolean.TRUE);
            else    
                dtoSV.setIndValidacionPROL(Boolean.FALSE);
        } else    
            dtoSV.setIndValidacionPROL(Boolean.FALSE);            
        
        registroLista.add(dtoSV);
      }
    }  
    if (registroLista != null && registroLista.size()>0) {
      dtoLS.setLista(registroLista);
    } else {
      UtilidadesLog.debug( "ConsultaS de obtenerSolicitudporTipoSolicitudyZona, no retornaron nada");                
    }
    return dtoLS;
  }
  
   private Boolean bigDToBoolean(Object indicador) {    
     if (indicador != null) {
       if (((BigDecimal) indicador).intValue() == 1)  { 
          return Boolean.TRUE;
       } else {
          return Boolean.FALSE;           
       }           
    } else {
       return Boolean.FALSE;
    }
  }
  
  public DTOListaSolicitudes obtenerSolicitudXTipificacionPerf(DTOInfoMonitor dtoin) throws MareException {
      UtilidadesLog.info("DAOSolicitud.obtenerSolicitudXTipificacionPerf(DTOInfoMonitor dtoin): Entrada ");
      ArrayList lista = null;        
      lista = dtoin.getSecuencia();
      DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();      
      if ((lista != null) && (lista.size() > 0)) {
        try {
           String sFechaControl = this.insertarZonasYTSPTemporal(lista);
           RecordSet rs = null; 
           rs = this.generarQueryTificacionPerf(dtoin, sFechaControl);
           this.deleteZonasYTSPTemporal(sFechaControl);
           dtoLS = (DTOListaSolicitudes)this.armarDTOSolValidacion(rs);
        } catch (Exception e) {
           String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
           UtilidadesLog.error("obtenerSolicitudXTipificacionPerf: Exception",e); 
           throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
        }
      }  
      UtilidadesLog.info("DAOSolicitud.obtenerSolicitudXTipificacionPerf(DTOInfoMonitor dtoin): Salida ");
      return dtoLS;
    }

  
   private RecordSet generarQueryTificacionPerf(DTOInfoMonitor dtoin, String sFechaControl) throws Exception {
     UtilidadesLog.info("DAOSolicitud.generarQueryTificacionPerf(DTOInfoMonitor dtoin, String sFechaControl): Entrada");
     StringBuffer query = new StringBuffer();
     SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
     String sFInicio = simpledateformat.format(dtoin.getFechaInicio());
     String sFFinal = simpledateformat.format(dtoin.getFechaFin());

     query.append("SELECT PSC.OID_SOLI_CABE, ");
   	 query.append("  PER.MARC_OID_MARC, ");
   	 query.append("  PER.CANA_OID_CANA, ");
   	 query.append("  PSC.PERD_OID_PERI, ");
   	 query.append("  PSC.MONE_OID_MONE, ");
   	 query.append("  PSC.TSPA_OID_TIPO_SOLI_PAIS, ");
   	 query.append("  PSC.CLIE_OID_CLIE, ");
   	 query.append("  PSC.SBAC_OID_SBAC, ");
   	 query.append("  PSC.IND_PEDI_PRUE, ");
   	 query.append("  PSC.IND_OC, ");
   	 query.append("  PTSP.IND_PEDI_GT_ZONA, ");
   	 query.append("  PSC.ZZON_OID_ZONA, ");
   	 query.append("  PSC.VEPO_OID_VALO_ESTR_GEOP, ");
   	 query.append("  PSC.MODU_OID_MODU, ");
   	 query.append("  MONED1.NUM_DECI NUM_DEC1, ");
   	 query.append("  MONED2.NUM_DECI NUM_DEC2, ");
   	 query.append("  PSC.VAL_TIPO_CAMB, ");
   	 query.append("  SUBAC.ACCE_OID_ACCE, ");
   	 query.append("  PSC.VAL_NUME_SOLI, ");
   	 query.append("  PSC.IND_PERM_UNIO_SOL, ");
   	 query.append("  PSC.PAIS_OID_PAIS, ");
   	 query.append("  PSC.FEC_PROG_FACT, ");   
   	 query.append("  PSC.IND_TS_NO_CONSO, ");   
   	 query.append("  PSC.GRPR_OID_GRUP_PROC, ");   
   	 query.append("  PQ_APL_AUX.Valor_Gen_I18n_Sicc(").append(dtoin.getOidIdioma()).append(", PER.CANA_OID_CANA ,'SEG_CANAL') as desCanal, ");
   	 query.append("  PER.VAL_NOMB_PERI, ");
	   query.append("  CASE WHEN ((PSC.GRPR_OID_GRUP_PROC + 1) = 5) THEN ");
	   query.append("		  FN_OBT_IND_EJEC_ONLINE((PSC.GRPR_OID_GRUP_PROC + 1), PTSP.TSOL_OID_TIPO_CONS) ");
	   query.append("  ELSE ");
   	 query.append("  		FN_OBT_IND_EJEC_ONLINE((PSC.GRPR_OID_GRUP_PROC + 1), PTSP.OID_TIPO_SOLI_PAIS) ");
     query.append("  END IND_EJEC_ONLI, TSZT.NUM_ORDE, ");
     query.append("	 (SELECT MIN(PST.NUM_ORDE) ");
	   query.append("   FROM PED_SECUE_TIPIF PST, ");
     query.append("        V_MAE_TIPIF_CLIEN VT ");
		 query.append("   WHERE VT.TICL_OID_TIPO_CLIE = PST.TICL_OID_TIPO_CLIE ");
		 query.append("     AND VT.SBTI_OID_SUBT_CLIE = PST.SBTI_OID_SUBT_CLIE ");
		 query.append("     AND VT.CLAS_OID_CLAS = PST.CLAS_OID_CLAS ");
		 query.append("     AND VT.TCCL_OID_TIPO_CLASI = PST.TCCL_OID_TIPO_CLAS "); 
     query.append("     AND VT.CLIE_OID_CLIE = PSC.CLIE_OID_CLIE "); 
	   query.append("  ) ORDEN_TIPIF, ");
      //jrivas 29/1/2008 2007437
      query.append("       CASE WHEN ((TS.IND_ANUL = 1) OR (TS.IND_DEVO = 1)) THEN 1 ");
      query.append("       ELSE 0 ");
      query.append("       END DEV_ANU ");
     query.append("FROM PED_SOLIC_CABEC PSC, "); 
	   query.append("     CRA_PERIO PER, ");
	   query.append("     PED_TIPO_SOLIC_PAIS PTSP, ");
	   query.append("     SEG_MONED MONED1, ");
	   query.append("     SEG_MONED MONED2, ");
	   query.append("     SEG_SUBAC SUBAC, ");
	   query.append("     SEG_PAIS PAIS, ");
        query.append("     ped_tipo_solic ts,  ");     
	   query.append("     PED_TIPO_SOLIC_ZONA_TEMP TSZT ");
     query.append("WHERE PSC.FEC_PROG_FACT_COMP >= TO_NUMBER('").append(sFInicio).append("') "); 
     query.append("  AND PSC.FEC_PROG_FACT_COMP <= TO_NUMBER('").append(sFFinal).append("') "); 
     query.append("  AND PSC.ZZON_OID_ZONA = TSZT.ZZON_OID_ZONA "); 
     query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = TSZT.TSPA_OID_TIPO_SOLI_PAIS "); 
     query.append("  AND PSC.GRPR_OID_GRUP_PROC = ").append(dtoin.getGP().longValue()); 
     query.append("  AND PSC.PERD_OID_PERI = PER.OID_PERI ");  
     query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS "); 
     query.append("  AND PSC.MONE_OID_MONE = MONED1.OID_MONE (+) "); 
     query.append("  AND PSC.PAIS_OID_PAIS = PAIS.OID_PAIS "); 
     query.append("  AND MONED2.OID_MONE = PAIS.MONE_OID_MONE "); 
     query.append("  AND PSC.SBAC_OID_SBAC = SUBAC.OID_SBAC "); 
     query.append("  and PTSP.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");     
     query.append("  AND TSZT.FEC_CONT = TO_NUMBER('").append(sFechaControl).append("') "); 
     query.append("ORDER BY ORDEN_TIPIF, TSZT.NUM_ORDE, OID_SOLI_CABE "); 
     
     RecordSet rs = null;
     
     rs = this.executeQuery(query.toString());    
     UtilidadesLog.info("DAOSolicitud.generarQueryTificacionPerf(DTOInfoMonitor dtoin, String sFechaControl): Salida");
     return rs;
   }     

    public DTOListaSolicitudes obtenerSolicitudporGestionStock(DTOInfoMonitor dtoin) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporGestionStock(DTOInfoMonitor dtoin): Entrada ");
        BelcorpService belcorpService;
        RecordSet rsSolGestStk;
        String codigoError;
        Boolean oidMoneNULL = Boolean.FALSE;
        String sFInicio = new String();
        String sFFinal = new String();

        StringBuffer SUBquery  = new StringBuffer();
        StringBuffer SUBquery2 = new StringBuffer();

        int j;

        DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();

        Vector registroLista = new Vector();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }

        ArrayList lista = new ArrayList();
        lista = dtoin.getSecuencia();

        try {
          if ((lista != null) && (lista.size() > 0)) {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");                

            SUBquery.append("SELECT * FROM ");
            SUBquery2.append("SELECT * FROM ");

            for (int i = 0; i < lista.size(); i++) {
              DTOSecuenciaSolicitudes elmDtoSecSol = (DTOSecuenciaSolicitudes) lista.get(i);

              SUBquery.append(" (Select 9999999 ORDEN, " + elmDtoSecSol.getSecuencia().longValue() + " ORDEN_MONITOR, CA.*");
                
              SUBquery2.append(" (SELECT 9999999 ORDEN, "+ elmDtoSecSol.getSecuencia().longValue() + " ORDEN_MONITOR, CA.OID_SOLI_CABE OID_SOLI_CABE FROM PED_SOLIC_CABEC CA ");
              SUBquery2.append(" WHERE CA.ZZON_OID_ZONA = '" +  elmDtoSecSol.getOidZona().longValue() + "'");
              SUBquery2.append(" AND CA.TSPA_OID_TIPO_SOLI_PAIS = '" + elmDtoSecSol.getOidTipoSolicitud().longValue() + "' and");

              sFInicio = simpledateformat.format(dtoin.getFechaInicio());
              sFFinal = simpledateformat.format(dtoin.getFechaFin());

              SUBquery2.append(" CA.FEC_PROG_FACT_COMP >= TO_NUMBER('"+ sFInicio +"') and");
              SUBquery2.append(" CA.FEC_PROG_FACT_COMP <= TO_NUMBER('"+ sFFinal +"') ");
                   
              SUBquery2.append(" AND ca.grpr_oid_grup_proc = " + ConstantesPED.GP3.longValue());
                        
              SUBquery.append(" from PED_SOLIC_CABEC CA");
              SUBquery.append(" where");
              SUBquery.append(" CA.ZZON_OID_ZONA = '" + elmDtoSecSol.getOidZona().longValue() + "'");
              SUBquery.append(" AND CA.TSPA_OID_TIPO_SOLI_PAIS = '" + elmDtoSecSol.getOidTipoSolicitud().longValue() + "' and");

              SUBquery.append(" CA.FEC_PROG_FACT_COMP >= TO_NUMBER('"+ sFInicio +"') and");
              SUBquery.append(" CA.FEC_PROG_FACT_COMP <= TO_NUMBER('"+ sFFinal +"') ");
                    
              SUBquery.append(" AND ca.grpr_oid_grup_proc = " + ConstantesPED.GP3.longValue());
              if (i < (lista.size() - 1)) {
                 SUBquery.append(") UNION ");
                 SUBquery2.append(") UNION ");
              }
           }

                SUBquery.append(") ");
                SUBquery2.append(") ");


                //ya tengo todos los selects unidos por union.....
                StringBuffer query = new StringBuffer();

                query.append(
                    "SELECT XX.ORDEN,XX.ORDEN_MONITOR,SOL.OID_SOLI_CABE, craPER.MARC_OID_MARC,");
                query.append(
                    "craPER.CANA_OID_CANA, SOL.PERD_OID_PERI, SOL.MONE_OID_MONE, SOL.TSPA_OID_TIPO_SOLI_PAIS, SOL.CLIE_OID_CLIE,");
                query.append(
                    "SOL.SBAC_OID_SBAC, SOL.IND_PEDI_PRUE, SOL.IND_OC, pedTISOPA.IND_PEDI_GT_ZONA, SOL.ZZON_OID_ZONA,");
                query.append(
                    "SOL.VEPO_OID_VALO_ESTR_GEOP, SOL.MODU_OID_MODU, segMONE1.NUM_DECI NUM_DEC1, segMONE2.NUM_DECI NUM_DEC2,");
                query.append(
                    "SOL.VAL_TIPO_CAMB, segSUB.ACCE_OID_ACCE, SOL.VAL_NUME_SOLI, SOL.IND_PERM_UNIO_SOL, SOL.PAIS_OID_PAIS FROM");

                query.append(
                    " (SELECT MIN(ORDEN) ORDEN,ORDEN_MONITOR,OID_SOLI_CABE");

                query.append(" FROM (SELECT MIN(ST.NUM_ORDE) ORDEN, CA.ORDEN_MONITOR, CA.OID_SOLI_CABE OID_SOLI_CABE");
                query.append(" FROM PED_SECUE_TIPIF ST, V_MAE_TIPIF_CLIEN CL,(");

                //1ER SUBCONSULTA........                
                query.append(" " + SUBquery + ") CA");

                query.append(" WHERE");

                query.append(" (CA.PAIS_OID_PAIS=ST.PAIS_OID_PAIS");
                query.append(" AND CA.CLIE_OID_CLIE=CL.CLIE_OID_CLIE");
                query.append(" AND ST.TICL_OID_TIPO_CLIE=Cl.TICL_OID_TIPO_CLIE");
                query.append(" AND (ST.SBTI_OID_SUBT_CLIE IS NULL OR");
                query.append(" ST.SBTI_OID_SUBT_CLIE=Cl.SBTI_OID_SUBT_CLIE)");
                query.append(" AND (ST.TCCL_OID_TIPO_CLAS IS NULL OR");
                query.append(" ST.TCCL_OID_TIPO_CLAS=CL.TCCL_OID_TIPO_CLASI)");
                query.append(
                    " AND (ST.CLAS_OID_CLAS IS NULL OR ST.CLAS_OID_CLAS=CL.CLAS_OID_CLAS))");
                query.append(" GROUP BY CA.OID_SOLI_CABE,ORDEN_MONITOR UNION");
                
                query.append(" " + SUBquery2 + ") MEGACONSULTA");
                
                query.append(" GROUP BY ORDEN_MONITOR,OID_SOLI_CABE");
                query.append(" ORDER BY ORDEN,ORDEN_MONITOR )");
                
                query.append(" xx, PED_SOLIC_CABEC SOL, CRA_PERIO craPER,");
               query.append(" PED_TIPO_SOLIc_PAIS pedTISOPA, SEG_MONED segMONE1,");
                query.append(" SEG_MONED segMONE2, SEG_PAIS segPAIS, SEG_SUBAC segSUB");

                query.append(" WHERE XX.OID_SOLI_CABE=SOL.OID_SOLI_CABE AND");
                query.append(" SOL.PERD_OID_PERI = craPER.OID_PERI AND");
                query.append(
                    " SOL.TSPA_OID_TIPO_SOLI_PAIS = pedTISOPA.OID_TIPO_SOLI_PAIS AND");

                query.append(" SOL.MONE_OID_MONE = segMONE1.OID_MONE (+) AND");
                query.append(" SOL.PAIS_OID_PAIS = segPAIS.OID_PAIS AND");
                query.append(" segMONE2.OID_MONE = segPAIS.MONE_OID_MONE AND");
                query.append(" SOL.SBAC_OID_SBAC = segSUB.OID_SBAC");
                query.append(" order by orden, orden_monitor ");
                

                //ejecutamos la consulta
                rsSolGestStk = belcorpService.dbService.executeStaticQuery(query.toString());

                UtilidadesLog.debug("Resultado de busqueda obtenerSolicitudporGestionStock: " +rsSolGestStk);

                if (rsSolGestStk.getRowCount() > 0) {

                    for (j = 0; j < rsSolGestStk.getRowCount(); j++) {
                         DTOSolicitudValidacion dtoSV = new DTOSolicitudValidacion();
                        if (rsSolGestStk.getValueAt(j, "OID_SOLI_CABE") != null) {
                            dtoSV.setOidSolicitud(new Long(rsSolGestStk.getValueAt(j, "OID_SOLI_CABE").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "MARC_OID_MARC") != null) {
                            dtoSV.setOidMarca(new Long(rsSolGestStk.getValueAt(j, "MARC_OID_MARC").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "CANA_OID_CANA") != null) {
                            dtoSV.setOidCanal(new Long(rsSolGestStk.getValueAt(j, "CANA_OID_CANA").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "PERD_OID_PERI") != null) {
                            dtoSV.setOidPeriodo(new Long(rsSolGestStk.getValueAt(j, "PERD_OID_PERI").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "MONE_OID_MONE") != null) {
                            dtoSV.setOidMoneda(new Long(rsSolGestStk.getValueAt(j, "MONE_OID_MONE").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS") != null) {
                            dtoSV.setOidTipoSolPais(new Long(rsSolGestStk.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "CLIE_OID_CLIE") != null) {
                            dtoSV.setOidCliente(new Long(rsSolGestStk.getValueAt(j, "CLIE_OID_CLIE").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "SBAC_OID_SBAC") != null) {
                            dtoSV.setOidSubAcceso(new Long(rsSolGestStk.getValueAt(j, "SBAC_OID_SBAC").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "IND_PEDI_PRUE") != null) {
                           if ( this.castBigDecimal((BigDecimal) rsSolGestStk.getValueAt(j,"IND_PEDI_PRUE")).longValue() == 0)
                             dtoSV.setIndSimulacion(Boolean.FALSE);
                           else
                             dtoSV.setIndSimulacion(Boolean.TRUE);
                        }else{
                          dtoSV.setIndSimulacion(Boolean.FALSE);
                        }

                        if (rsSolGestStk.getValueAt(j, "IND_OC") != null) {
                          if (this.castBigDecimal((BigDecimal) rsSolGestStk.getValueAt(j, "IND_OC")).longValue() == 0)
                           dtoSV.setIndOrdenCompra(Boolean.FALSE);
                          else
                            dtoSV.setIndOrdenCompra(Boolean.TRUE);
                        }else{
                          dtoSV.setIndOrdenCompra(Boolean.FALSE);
                        }

                        if (rsSolGestStk.getValueAt(j, "IND_PEDI_GT_ZONA") != null) {
                          if (this.castBigDecimal((BigDecimal) rsSolGestStk.getValueAt(j, "IND_PEDI_GT_ZONA")).longValue() == 0)
                            dtoSV.setIndPedGTZona(Boolean.FALSE);
                          else
                            dtoSV.setIndPedGTZona(Boolean.TRUE);
                        }else{
                          dtoSV.setIndPedGTZona(Boolean.FALSE);
                        }

                        if (rsSolGestStk.getValueAt(j, "ZZON_OID_ZONA") != null) {
                            dtoSV.setZona(new Long(rsSolGestStk.getValueAt(j,"ZZON_OID_ZONA").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP") != null) {
                            dtoSV.setUbigeo(new Long(rsSolGestStk.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "MODU_OID_MODU") != null) {
                            dtoSV.setOidModulo(new Long(rsSolGestStk.getValueAt(j, "MODU_OID_MODU").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "NUM_DEC1") != null) {
                            dtoSV.setNumDecimales(new Integer(rsSolGestStk.getValueAt(j, "NUM_DEC1").toString()));
                        } else {
                            if (rsSolGestStk.getValueAt(j, "NUM_DEC2") != null) {
                                dtoSV.setNumDecimales(new Integer(rsSolGestStk.getValueAt(j, "NUM_DEC2").toString()));
                            }
                        }

                        if (rsSolGestStk.getValueAt(j, "VAL_TIPO_CAMB") != null) {
                            dtoSV.setTipoCambio(new BigDecimal(rsSolGestStk.getValueAt(j, "VAL_TIPO_CAMB").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "ACCE_OID_ACCE") != null) {
                            dtoSV.setOidAcceso(new Long(rsSolGestStk.getValueAt(j, "ACCE_OID_ACCE").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "VAL_NUME_SOLI") != null) {
                            dtoSV.setNumSolicitud(new String(rsSolGestStk.getValueAt(j, "VAL_NUME_SOLI").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "IND_PERM_UNIO_SOL") != null) {
                          if (this.castBigDecimal((BigDecimal) rsSolGestStk.getValueAt(j, "IND_PERM_UNIO_SOL")).longValue() == 0)
                            dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                          else
                            dtoSV.setIndUnionSolicitud(Boolean.TRUE);
                        }else{
                          dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                        }
                        
                        if (rsSolGestStk.getValueAt(j, "ORDEN") != null) {
                            dtoSV.setOrden(new Long(rsSolGestStk.getValueAt(j, "ORDEN").toString()));
                        }
                        
                        if (rsSolGestStk.getValueAt(j, "ORDEN_MONITOR") != null) {
                            dtoSV.setOrdenMonitor(new Long(rsSolGestStk.getValueAt(j, "ORDEN_MONITOR").toString()));
                        }

                        if (rsSolGestStk.getValueAt(j, "PAIS_OID_PAIS") != null) {
                            dtoSV.setOidPais(new Long(rsSolGestStk.getValueAt(j, "PAIS_OID_PAIS").toString()));
                        }
                        
                        
                        registroLista.add(dtoSV);
                    }

                    dtoLS.setLista(registroLista);
                }
            }
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporGestionStock(DTOInfoMonitor dtoin): Salida ");
        return dtoLS;
    }

    public DTOListaSolicitudes obtenerSolicitudporTipoSolicitudyZona(DTOInfoMonitor dtoin) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporTipoSolicitudyZona(DTOInfoMonitor dtoin): Entrada ");
        BelcorpService belcorpService;
        RecordSet rsSolCabec;
        String codigoError;
        String sFInicio = null;
        String sFFinal = null;

        DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();

        Vector registroLista = new Vector();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }

        //recorro los tipos de solicitud recibidos....
        ArrayList lista = null;
        int j = 0;
        lista = dtoin.getSecuencia();

        try {
            if ((lista != null) && (lista.size() > 0)) {                
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");

                for (int i = 0; i < lista.size(); i++) {
                    StringBuffer query = new StringBuffer();
                    DTOSecuenciaSolicitudes elmDtoSecSol = (DTOSecuenciaSolicitudes) lista.get(i);

                    sFInicio = simpledateformat.format(dtoin.getFechaInicio());
                    sFFinal = simpledateformat.format(dtoin.getFechaFin());

                    query.append(" Select ");
                    query.append(" pedSOLCAB.OID_SOLI_CABE,");
                    query.append(" craPER.MARC_OID_MARC,");
                    query.append(" craPER.CANA_OID_CANA,");
                    query.append(" pedSOLCAB.PERD_OID_PERI,");
                    query.append(" pedSOLCAB.MONE_OID_MONE,");
                    query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS,");
                    query.append(" pedSOLCAB.CLIE_OID_CLIE,");
                    query.append(" pedSOLCAB.SBAC_OID_SBAC,");
                    query.append(" pedSOLCAB.IND_PEDI_PRUE,");
                    query.append(" pedSOLCAB.IND_OC,");
                    query.append(" pedTISOPA.IND_PEDI_GT_ZONA,");
                    query.append(" pedSOLCAB.ZZON_OID_ZONA,");
                    query.append(" pedSOLCAB.VEPO_OID_VALO_ESTR_GEOP,");
                    query.append(" pedSOLCAB.MODU_OID_MODU,");
                    query.append(" segMONE1.NUM_DECI NUM_DEC1,");
                    query.append(" segMONE2.NUM_DECI NUM_DEC2,");
                    query.append(" pedSOLCAB.VAL_TIPO_CAMB,");
                    query.append(" segSUB.ACCE_OID_ACCE,");
                    query.append(" pedSOLCAB.VAL_NUME_SOLI,");
                    query.append(" pedSOLCAB.IND_PERM_UNIO_SOL,");
                    query.append(" pedSOLCAB.PAIS_OID_PAIS, ");
                    query.append(" pedSOLCAB.FEC_PROG_FACT, ");   
                    query.append(" pedSOLCAB.IND_TS_NO_CONSO, ");   
                    query.append(" pedSOLCAB.GRPR_OID_GRUP_PROC, ");   
                    query.append(" pedSOLCAB.IND_TS_NO_CONSO, ");   
                    query.append(" pedSOLCAB.GRPR_OID_GRUP_PROC, ");   
                    query.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dtoin.getOidIdioma()+",craPER.CANA_OID_CANA ,'SEG_CANAL') as desCanal, ");
                    query.append(" craPER.VAL_NOMB_PERI ");                    
                    query.append(" From PED_SOLIC_CABEC pedSOLCAB, CRA_PERIO craPER, PED_TIPO_SOLIc_PAIS pedTISOPA,");
                    query.append(" SEG_MONED segMONE1,");
                    query.append(" SEG_MONED segMONE2,");
                    query.append(" SEG_SUBAC segSUB,");
                    query.append(" SEG_PAIS segPAIS");
                    query.append(" WHERE pedSOLCAB.FEC_PROG_FACT_COMP >= TO_NUMBER('"+ sFInicio +"') and");
                    query.append(" pedSOLCAB.FEC_PROG_FACT_COMP <= TO_NUMBER('"+ sFFinal +"') and");
                    query.append(" pedSOLCAB.ZZON_OID_ZONA = '" + elmDtoSecSol.getOidZona().longValue() + "' and");
                    query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS = '" + elmDtoSecSol.getOidTipoSolicitud().longValue() + "' and");
                    query.append(" pedSOLCAB.GRPR_OID_GRUP_PROC = '" + dtoin.getGP().longValue() + "' and");
                    query.append(" pedSOLCAB.PERD_OID_PERI = craPER.OID_PERI and");
                    query.append(" pedSOLCAB.TSPA_OID_TIPO_SOLI_PAIS = pedTISOPA.OID_TIPO_SOLI_PAIS and");
                    query.append(" pedSOLCAB.MONE_OID_MONE = segMONE1.OID_MONE (+) and");
                    query.append(" pedSOLCAB.PAIS_OID_PAIS = segPAIS.OID_PAIS and");
                    query.append(" segMONE2.OID_MONE = segPAIS.MONE_OID_MONE and");
                    query.append(" pedSOLCAB.SBAC_OID_SBAC = segSUB.OID_SBAC");
                    
                    rsSolCabec = belcorpService.dbService.executeStaticQuery(query.toString());

                    if (rsSolCabec.getRowCount() > 0) {
                        int size = rsSolCabec.getRowCount();
                        j=0;
                        for (j=0; j<size;j++){
                            DTOSolicitudValidacion dtoSV = new DTOSolicitudValidacion();
                            if (rsSolCabec.getValueAt(j, "OID_SOLI_CABE") != null) {
                                dtoSV.setOidSolicitud(new Long(rsSolCabec.getValueAt(j, "OID_SOLI_CABE").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "MARC_OID_MARC") != null) {
                                dtoSV.setOidMarca(new Long(rsSolCabec.getValueAt(j, "MARC_OID_MARC").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "CANA_OID_CANA") != null) {
                                dtoSV.setOidCanal(new Long(rsSolCabec.getValueAt(j, "CANA_OID_CANA").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "PERD_OID_PERI") != null) {
                                dtoSV.setOidPeriodo(new Long(rsSolCabec.getValueAt(j, "PERD_OID_PERI").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "MONE_OID_MONE") != null) {
                                dtoSV.setOidMoneda(new Long(rsSolCabec.getValueAt(j, "MONE_OID_MONE").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "TSPA_OID_TIPO_SOLI_PAIS") != null) {
                                dtoSV.setOidTipoSolPais(new Long(rsSolCabec.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "CLIE_OID_CLIE") != null) {
                                dtoSV.setOidCliente(new Long(rsSolCabec.getValueAt(j, "CLIE_OID_CLIE").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "SBAC_OID_SBAC") != null) {
                                dtoSV.setOidSubAcceso(new Long(rsSolCabec.getValueAt(j, "SBAC_OID_SBAC").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "IND_PEDI_PRUE") != null) {
                                if ( this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_PRUE")).longValue() == 0)
                                  dtoSV.setIndSimulacion(Boolean.FALSE);
                                else
                                  dtoSV.setIndSimulacion(Boolean.TRUE);
                            } else {
                              dtoSV.setIndSimulacion(Boolean.FALSE);
                            }
    
                            if (rsSolCabec.getValueAt(j, "IND_OC") != null) {
                                if ( this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_OC")).longValue() == 0)
                                  dtoSV.setIndOrdenCompra(Boolean.FALSE);
                                else
                                  dtoSV.setIndOrdenCompra(Boolean.TRUE);
                            } else {
                              dtoSV.setIndOrdenCompra(Boolean.FALSE);
                            }
    
                            if (rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA") != null) {
                               if ( this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PEDI_GT_ZONA")).longValue() == 0)
                                 dtoSV.setIndPedGTZona(Boolean.FALSE);
                               else
                                 dtoSV.setIndPedGTZona(Boolean.TRUE);
                            }else{
                              dtoSV.setIndPedGTZona(Boolean.FALSE);
                            }
    
                            if (rsSolCabec.getValueAt(j, "ZZON_OID_ZONA") != null) {
                                dtoSV.setZona(new Long(rsSolCabec.getValueAt(j, "ZZON_OID_ZONA").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP") != null) {
                                dtoSV.setUbigeo(new Long(rsSolCabec.getValueAt(j, "VEPO_OID_VALO_ESTR_GEOP").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "MODU_OID_MODU") != null) {
                                dtoSV.setOidModulo(new Long(rsSolCabec.getValueAt(j, "MODU_OID_MODU").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "NUM_DEC1") != null) {
                                dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC1").toString()));
                            } else {
                                if (rsSolCabec.getValueAt(j, "NUM_DEC2") != null) {
                                    dtoSV.setNumDecimales(new Integer(rsSolCabec.getValueAt(j, "NUM_DEC2").toString()));
                                }
                            }
    
                            if (rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB") != null) {
                                dtoSV.setTipoCambio(new BigDecimal(rsSolCabec.getValueAt(j, "VAL_TIPO_CAMB").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "ACCE_OID_ACCE") != null) {
                                dtoSV.setOidAcceso(new Long(rsSolCabec.getValueAt(j, "ACCE_OID_ACCE").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "VAL_NUME_SOLI") != null) {
                                dtoSV.setNumSolicitud(new String(rsSolCabec.getValueAt(j, "VAL_NUME_SOLI").toString()));
                            }
    
                            if (rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL") != null) {
                              if (this.castBigDecimal((BigDecimal) rsSolCabec.getValueAt(j, "IND_PERM_UNIO_SOL")).longValue() == 0)
                                dtoSV.setIndUnionSolicitud(Boolean.FALSE);
                              else
                                dtoSV.setIndUnionSolicitud(Boolean.TRUE);
                            }else{
                              dtoSV.setIndUnionSolicitud(Boolean.FALSE); 
                            }
    
                            if (rsSolCabec.getValueAt(j, "PAIS_OID_PAIS") != null) {
                                dtoSV.setOidPais(new Long(rsSolCabec.getValueAt(j, "PAIS_OID_PAIS").toString()));
                            }
                            
                            if (rsSolCabec.getValueAt(j, "FEC_PROG_FACT") != null) {
                                dtoSV.setFechaProceso((java.sql.Date)rsSolCabec.getValueAt(j, "FEC_PROG_FACT"));
                            }
                            
                            if (rsSolCabec.getValueAt(j, "IND_TS_NO_CONSO") != null) {
                                dtoSV.setIndNoConso(new Long(rsSolCabec.getValueAt(j, "IND_TS_NO_CONSO").toString()));
                            }
                            if (rsSolCabec.getValueAt(j, "GRPR_OID_GRUP_PROC") != null) {
                                dtoSV.setGP(new Long(rsSolCabec.getValueAt(j, "GRPR_OID_GRUP_PROC").toString()));
                            }
                            if (rsSolCabec.getValueAt(j, "DESCANAL") != null) {
                                dtoSV.setDescripcionCanal(rsSolCabec.getValueAt(j, "DESCANAL").toString());
                            }
                            if (rsSolCabec.getValueAt(j, "VAL_NOMB_PERI") != null) {
                                dtoSV.setNombrePeriodo(rsSolCabec.getValueAt(j, "VAL_NOMB_PERI").toString());
                            }
    
                            registroLista.add(dtoSV);
                        }
                    }
                }
                if (registroLista != null){
                    if (!(registroLista.size()>0)){
                         UtilidadesLog.debug("ConsultaS de obtenerSolicitudporTipoSolicitudyZona, no retornaron nada");
                    }
                    dtoLS.setLista(registroLista);
                } else   
                    UtilidadesLog.debug( "ConsultaS de obtenerSolicitudporTipoSolicitudyZona, no retornaron nada");                
            }
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitud.obtenerSolicitudporTipoSolicitudyZona(DTOInfoMonitor dtoin): Salida ");
        return dtoLS;
    }

    // sapaza -- PER-SiCC-2011-0079 -- 25/02/2011
    public String validarProcesosDependientes(DTOInfoMonitor dtoin, String grupoProceso) throws MareException {
        UtilidadesLog.info("DAOSolicitud.validarProcesosDependientes(String codigoPais, String grupoProceso): Entrada ");
        StringBuffer query = new StringBuffer();
        String listaProcesosBatch = "";
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(dtoin.getFechaProceso());

        query.append(" SELECT BAT.DES_PROC_BATC,  ");
        query.append("       (SELECT COUNT(1) FROM BAS_PROCE_BATCH_HISTO ");
        query.append("         WHERE PAIS_COD_PAIS = BAT.PAIS_COD_PAIS ");
        query.append("           AND SIST_COD_SIST = BAT.SIST_COD_SIST ");
        query.append("           AND PRBA_COD_PROC_BATC = BAT.COD_PROC_BATC ");
        query.append("           AND COD_PERI = '" +  dtoin.getCodigoPeriodo() + "'");
        query.append("           AND FEC_PROC = TO_DATE('" + fecha + "', 'YYYY-MM-DD') ");
        query.append("           AND EPBA_COD_ESTA_PROC = '10') TOT_PROC ");
        query.append("   FROM BAS_PROCE_BATCH BAT ");
        query.append("  WHERE BAT.PAIS_COD_PAIS = '" + dtoin.getCodigoPais() + "'");
        query.append("    AND BAT.COD_GRUP_DEPE = '" + grupoProceso + "'");
        query.append("    AND BAT.EST_PROC_BATC = '1' ");
        query.append("  ORDER BY BAT.DES_PROC_BATC ");        
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        if( rs.esVacio() ) {
            UtilidadesLog.info("DAOMonitor.validarProcesosDependientes(String codigoPais, String grupoProceso): Salida ");
            return "";
        } else {
            
            for (int i = 0; i < rs.getRowCount(); i++) {
                String procesoBatch = (String) rs.getValueAt(i, 0);
                BigDecimal bd = (BigDecimal)rs.getValueAt(i, 1);
                
                if( bd.intValue() == 0 ){
                    if(listaProcesosBatch.length() > 0)
                        listaProcesosBatch = listaProcesosBatch + ", " + procesoBatch; 
                    else    
                        listaProcesosBatch = procesoBatch; 
                }
            }
        }   
            
        return listaProcesosBatch;            
    }  

    private boolean existeOrdenesCompra(DTOInfoMonitor dtoin, String sFechaControl) throws Exception {
      UtilidadesLog.info("DAOSolicitud.generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl): Entrada");
      StringBuffer query = new StringBuffer();
      SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
      String sFInicio = simpledateformat.format(dtoin.getFechaInicio());
      String sFFinal = simpledateformat.format(dtoin.getFechaFin());

      query.append("SELECT COUNT(1) ");
      query.append("FROM PED_SOLIC_CABEC PSC, "); 
      query.append("     PED_TIPO_SOLIC_PAIS PTSP, ");
      query.append("     PED_TIPO_SOLIC ts,  ");     
      query.append("     PED_TIPO_SOLIC_ZONA_TEMP TSZT ");
      query.append("WHERE PSC.FEC_PROG_FACT_COMP >= TO_NUMBER('").append(sFInicio).append("') "); 
      query.append("  AND PSC.FEC_PROG_FACT_COMP <= TO_NUMBER('").append(sFFinal).append("') "); 
      query.append("  AND PSC.ZZON_OID_ZONA = TSZT.ZZON_OID_ZONA "); 
      query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = TSZT.TSPA_OID_TIPO_SOLI_PAIS "); 
      query.append("  AND PSC.GRPR_OID_GRUP_PROC = ").append(dtoin.getGP().longValue()); 
      query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS "); 
      query.append("  and PTSP.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
      query.append("  AND TSZT.FEC_CONT = TO_NUMBER('").append(sFechaControl).append("') "); 
      
      // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011  
      if(dtoin.getOidPeriodoSiguiente()==null)
         query.append("  AND PSC.PERD_OID_PERI = " + dtoin.getOidPeriodo()); 
      else   
         query.append("  AND PSC.PERD_OID_PERI IN (" + dtoin.getOidPeriodo() + "," + dtoin.getOidPeriodoSiguiente()+ ")"); 
          
      query.append(" AND PSC.IND_OC = 1 "); 
      query.append(" AND TS.IND_SOLI_NEGA = 0 "); 
      
      RecordSet rs = null;
      rs = this.executeQuery(query.toString());    
      
      if( rs == null ) {
        UtilidadesLog.info("DAOSolicitud.generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl): Salida ");
        return false;
      }    
            
      BigDecimal bd = (BigDecimal)rs.getValueAt(0, 0);

      if( bd.intValue() > 0 ){
        UtilidadesLog.info("DAOSolicitud.generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl): Salida ");
        return true;
      } else{
        UtilidadesLog.info("DAOSolicitud.generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl): Salida ");
        return false;
      }            
      
    }   

    // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011
    private boolean validaPedidosOrdenesCompra(DTOInfoMonitor dtoin, String sFechaControl) throws Exception {
      UtilidadesLog.info("DAOSolicitud.validaPedidosOrdenesCompra(DTOInfoMonitor dtoin, String sFechaControl): Entrada");
      StringBuffer query = new StringBuffer();

      query.append("SELECT COUNT(1) ");
      query.append("FROM PED_TIPO_SOLIC_PAIS PTSP, ");
      query.append("     PED_TIPO_SOLIC ts,  ");     
      query.append("     PED_TIPO_SOLIC_ZONA_TEMP TSZT ");
      query.append("WHERE PTSP.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI "); 
      query.append("  AND TSZT.FEC_CONT = TO_NUMBER('").append(sFechaControl).append("') "); 
      query.append("  AND PTSP.OID_TIPO_SOLI_PAIS = TSZT.TSPA_OID_TIPO_SOLI_PAIS "); 
      query.append("  AND TS.COD_TIPO_SOLI = 'SOC' "); 
      
      RecordSet rs = null;
      rs = this.executeQuery(query.toString());    
      
      if( rs == null ) {
        UtilidadesLog.info("DAOSolicitud.validaPedidosOrdenesCompra(DTOInfoMonitor dtoin, String sFechaControl): Salida ");
        return false;
      }    
            
      BigDecimal bd = (BigDecimal)rs.getValueAt(0, 0);

      if( bd.intValue() > 0 ){
        UtilidadesLog.info("DAOSolicitud.validaPedidosOrdenesCompra(DTOInfoMonitor dtoin, String sFechaControl): Salida ");
        return true;
      } else{
        UtilidadesLog.info("DAOSolicitud.generarQueryTSPyZonaPerf(DTOInfoMonitor dtoin, String sFechaControl): Salida ");
        return false;
      }            
      
    }   

    // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011
    public void ejecutarProcesosEspeciales(Long oidPais, String codigoUsuario) throws MareException {
        UtilidadesLog.info("DAOSolicitud.ejecutarProcesosEspeciales(Long oidPais, String codigoUsuario): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            ArrayList params = new ArrayList();
            params.add(oidPais.toString());
            params.add(codigoUsuario);
            
            bs.dbService.executeProcedure("PQ_PLANI.OCR_PR_COMP_MONT_MINIMO", params);
            
            UtilidadesLog.info("DAOSolicitud.ejecutarProcesosEspeciales(Long oidPais, String codigoUsuario): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    // sapaza -- PER-SiCC-2011-0726 -- 08/11/2011
    public void ejecutarStockOnline(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.ejecutarStockOnline(Long oidSolicitud): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            bs.dbService.executeProcedure("PED_PKG_CUADR_OFERT.PED_PR_STOCK_ONLINE", oidSolicitud.toString());
            
            UtilidadesLog.info("DAOSolicitud.ejecutarStockOnline(Long oidSolicitud): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    // sapaza -- PER-SiCC-2011-0726 -- 25/01/2012
    public void generarProductosAlternativos(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitud.generarProductosAlternativos(Long oidSolicitud): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            bs.dbService.executeProcedure("PQ_PLANI.PED_PR_GENER_PRODU_ALTER_FALTA", oidSolicitud.toString());
            
            UtilidadesLog.info("DAOSolicitud.generarProductosAlternativos(Long oidSolicitud): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    // sapaza -- PER-SiCC-2011-0726 -- 07/02/2011
    public void ejecutarProcesosEspecialesxSolicitud(Long oidPais, Long oidSolicitud, String codigoUsuario) throws MareException {
        UtilidadesLog.info("DAOSolicitud.ejecutarProcesosEspecialesxSolicitud(Long oidPais, Long oidSolicitud, String codigoUsuario): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            ArrayList params = new ArrayList();
            params.add(oidPais.toString());
            params.add(oidSolicitud.toString());
            params.add(codigoUsuario);
            
            bs.dbService.executeProcedure("PQ_PLANI.OCR_PR_PROCE_ESPEC", params);
            
            UtilidadesLog.info("DAOSolicitud.ejecutarProcesosEspecialesxSolicitud(Long oidPais, Long oidSolicitud, String codigoUsuario): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    // sapaza -- PER-SICC-2012-0169 -- 29/02/2012
    private void actualizarAcumulador2(DTOCalcularTotales miDto)  throws MareException {
        UtilidadesLog.info("DAOSolicitud.actualizarAcumulador2 Entrada ");
        
        BelcorpService bs = getBelcorpService();
        Long cantidad = new Long(1);
        Long oidPeriodo = miDto.getOidPeriodo();

        RecordSet rs3;
        int aux;
        StringBuffer query3 = new StringBuffer();
        query3.append(" UPDATE PED_SOLIC_CABEC_ACUM2 ");
        query3.append(" SET VAL_MONT_TOTA = VAL_MONT_TOTA + " + miDto.getPrecioDemandaReal());
        query3.append("   , VAL_CANT_PEDI = " + cantidad);
        query3.append(" WHERE CLIE_OID_CLIE = " + miDto.getOidCliente());
        query3.append(" AND PERD_OID_PERI = " + oidPeriodo);
        
        try {
            bs = getBelcorpService();
            aux = bs.dbService.executeUpdate(query3.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }        
        
        if (aux == 0) {        
            //CREATE
            query3 = new StringBuffer();
            query3.append(" INSERT INTO PED_SOLIC_CABEC_ACUM2 (  ");
            query3.append(" OID_SOCA_ACU2, CLIE_OID_CLIE, PERD_OID_PERI, VAL_CANT_PEDI, VAL_MONT_TOTA )  ");
            query3.append(" VALUES (PED_SCA2_SEQ.nextval, " + miDto.getOidCliente() + ", " + oidPeriodo + ", " +cantidad+ ", " + miDto.getPrecioDemandaReal() +")");
            try {
                bs = getBelcorpService();
                aux = bs.dbService.executeUpdate(query3.toString());
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
        }
        
        UtilidadesLog.info("DAOSolicitud.actualizarAcumulador2 Salida ");
    }

    // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
        public String obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT pp.val_para      ");
        consulta.append("   FROM bas_param_pais pp, bas_pais bp, seg_pais sp  ");
        consulta.append("  WHERE sp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND sp.oid_pais =  " + oidPais.toString());
        consulta.append("    AND pp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND pp.cod_sist = '" + codigoModulo + "'");
        consulta.append("    AND pp.cod_para = '" + codigoParametro + "'");
        consulta.append("    AND pp.ind_acti =  '1' ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOSolicitud.obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Salida");

        return null;
    }    
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    public String obtenerTipoSegmentacion() throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerTipoSegmentacion(): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT IND_SEGM ");
        consulta.append("   FROM BAS_PARAM_SEGME_DINAM  ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerTipoSegmentacion: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        UtilidadesLog.info("DAOSolicitud.obtenerTipoSegmentacion(): Salida");
        
        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        } else
            return ConstantesPED.TIPO_SEGMENTACION_PROPERTIES;

    }
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    public void ejecutarCalculoSegmentacion(String procesoMonitor, String grupoProceso, Long cantidadPedidos) throws MareException {
        UtilidadesLog.info("DAOSolicitud.ejecutarCalculoSegmentacion(String procesoMonitor, String grupoProceso, Long cantidadPedidos): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = getBelcorpService();

        try {
            ArrayList params = new ArrayList();
            params.add(procesoMonitor);
            params.add(grupoProceso);
            params.add(cantidadPedidos.toString());
            
            bs.dbService.executeProcedure("PQ_PLANI.gen_pr_calcu_segme_sicc", params);
            
            UtilidadesLog.info("DAOSolicitud.ejecutarCalculoSegmentacion(String procesoMonitor, String grupoProceso, Long cantidadPedidos): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    public String obtenerTamanioSegmento(String procesoMonitor, String grupoProceso) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerTamanioSegmento(String procesoMonitor, String grupoProceso): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT NUM_TAMA_SEGM ");
        consulta.append("   FROM BAS_MONIT_SEGME  "); 
        consulta.append("  WHERE COD_PROC = '" + procesoMonitor + "' ");
        consulta.append("    AND VAL_GRUP_PROC = '" + grupoProceso + "'");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerTamanioSegmento: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        } 

        UtilidadesLog.info("DAOSolicitud.obtenerTamanioSegmento(String procesoMonitor, String grupoProceso): Salida");

        return null;
    }
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    public String obtenerTamanioSubSegmento(String procesoMonitor, String grupoProceso) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerTamanioSubSegmento(String procesoMonitor, String grupoProceso): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT NUM_TAMA_SUB_SEGM ");
        consulta.append("   FROM BAS_MONIT_SEGME  "); 
        consulta.append("  WHERE COD_PROC = '" + procesoMonitor + "' ");
        consulta.append("    AND VAL_GRUP_PROC = '" + grupoProceso + "'");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerTamanioSubSegmento: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        } 

        UtilidadesLog.info("DAOSolicitud.obtenerTamanioSubSegmento(String procesoMonitor, String grupoProceso): Salida");

        return null;
    }

    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    public String obtenerMaxCantSegmento(String procesoMonitor, String grupoProceso) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerMaxCantSegmento(String procesoMonitor, String grupoProceso): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT NUM_MAXI_CANT_SEGM ");
        consulta.append("   FROM BAS_MONIT_SEGME  "); 
        consulta.append("  WHERE COD_PROC = '" + procesoMonitor + "' ");
        consulta.append("    AND VAL_GRUP_PROC = '" + grupoProceso + "'");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerMaxCantSegmento: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        } 

        UtilidadesLog.info("DAOSolicitud.obtenerMaxCantSegmento(String procesoMonitor, String grupoProceso): Salida");

        return null;
    }
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    public String obtenerTamanioSegmentoInicio(String procesoMonitor, String grupoProceso) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerTamanioSegmentoInicio(String procesoMonitor, String grupoProceso): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT NUM_TAMA_SEGM_INIC ");
        consulta.append("   FROM BAS_MONIT_SEGME  "); 
        consulta.append("  WHERE COD_PROC = '" + procesoMonitor + "' ");
        consulta.append("    AND VAL_GRUP_PROC = '" + grupoProceso + "'");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerTamanioSegmentoInicio: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        } 

        UtilidadesLog.info("DAOSolicitud.obtenerTamanioSegmentoInicio(String procesoMonitor, String grupoProceso): Salida");

        return null;
    }
    
}
