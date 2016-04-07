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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.DBService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.fac.DTOApFormPagE;
import es.indra.sicc.dtos.fac.DTOFACAcumuladoImpuestos;
import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraEntrada;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraSalida;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosEntrada;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosSalida;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;
import es.indra.sicc.dtos.fac.DTOFACDocumentoSubacceso;
import es.indra.sicc.dtos.fac.DTOFACPosicionDocContable;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.fac.CabeceraDocumentoContableLocalHome;
import es.indra.sicc.entidades.fac.FormularioLocal;
import es.indra.sicc.entidades.fac.FormularioLocalHome;
import es.indra.sicc.entidades.fac.FormulariosTipoSolicitudLocal;
import es.indra.sicc.entidades.fac.FormulariosTipoSolicitudLocalHome;
import es.indra.sicc.entidades.fac.LineaDocumentoContableLocalHome;
import es.indra.sicc.entidades.fac.MensajesFacturacionLocal;
import es.indra.sicc.entidades.fac.MensajesFacturacionLocalHome;
import es.indra.sicc.entidades.fac.ParametrosFacturacionLocal;
import es.indra.sicc.entidades.fac.ParametrosFacturacionLocalHome;
import es.indra.sicc.entidades.fac.RangosNumeracionOficialLocal;
import es.indra.sicc.entidades.fac.RangosNumeracionOficialLocalHome;
import es.indra.sicc.entidades.fac.RegistroUnicoVentasLocalHome;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocalHome;
import es.indra.sicc.entidades.mae.TipoDocumentoLocal;
import es.indra.sicc.entidades.mae.TipoDocumentoLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.TipoViaLocal;
import es.indra.sicc.entidades.seg.TipoViaLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacen;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientesHome;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientesPerf;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientesPerfHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.fac.DAOFACDocumentoContable;
import es.indra.sicc.logicanegocio.fac.DAOSolicitudCabecera;
import es.indra.sicc.logicanegocio.fac.DatosTipoDocumento;
import es.indra.sicc.logicanegocio.mae.DAOMAEMaestroClientes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidos;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidosHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;


import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONTratamientosContablesBean implements SessionBean  {

	private SessionContext ctx = null;
	
	private Boolean esDocumentoMonopagina;
	private Hashtable hashTiposDocumento;
	private Integer limiteNumeroDocumentoLegal;
	private String serieDocumentoLegal;
	private Integer ultimoDocumentoInterno;
	private Integer ultimoEjercicioDocumento;
	private Integer ultimoEjercicioDocumentoInterno;
    private Hashtable hashCatalogos;
    private UtilidadesLog log = new UtilidadesLog();

	public void ejbCreate() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}


    public void regenerarCuentaCorriente(DTOOIDs tiposSolicitud) throws MareException {
        UtilidadesLog.info("MONTratamientosContablesBean.regenerarCuentaCorriente(Date fechaFacturacion, ArrayList tiposSolicitud): Entrada");


    try{
        java.util.Date fecha = new java.util.Date();
        fecha.setTime(tiposSolicitud.getOidIdioma().longValue());
        String fechaFact = convertirFecha2(fecha);
        UtilidadesLog.debug("Fecha: "+fechaFact);
        //obtengo los lotes del dia
        RecordSet lotes = obtenerLotesFacturacion(fechaFact, tiposSolicitud);
        int largoLotes = lotes.getRowCount();
        for(int i=0; i< largoLotes; i++){
            String numeroLote = lotes.getValueAt(i,0).toString();
            //para cada lote cargo los consolidados, sus solicitudes y las posiciones de estas
            ArrayList consolidados =obtenerConsolidadosYCabecerasPorLote(fechaFact, numeroLote, tiposSolicitud);
            //para cada consolidado, ejecutamos el proceso generarRegistroCC;
            int largoConsolidados = consolidados.size();
            for(int n=0; n<largoConsolidados;n++){
                DTOFACConsolidado actual = (DTOFACConsolidado)consolidados.get(n);
                //UtilidadesLog.warn("Cabeceras: "+actual.getListaSolicitudes().size());
                if(actual.getDtoCabecera().getIndicadorPedidoPrueba().booleanValue()){
                    continue;
                }
                actual.setListaPosiciones(obtenerPosicionesPorConsolidado(actual.getDtoCabecera().getOidConsolidado()));
                //UtilidadesLog.warn("Posiciones: "+actual.getListaPosiciones().size());
                calcularTotalesDocumento(actual);
                this.generarRegistroCC( actual ); 
                actual.setListaPosiciones(null);//intento deseperado por liberar memoria viteh
                actual.setListaSolicitudes(null);//idem
            }
        }
    }catch(Exception e){
        e.printStackTrace();
        if(e instanceof MareException){
            throw (MareException)e;
        }else{
            throw new MareException(e);
        }
    }
        UtilidadesLog.info("MONTratamientosContablesBean.regenerarCuentaCorriente(Date fechaFacturacion, ArrayList tiposSolicitud): Salida");     
    }
    
    private void calcularTotalesDocumento(DTOFACConsolidado dtoConso){
        ArrayList lista = dtoConso.getListaPosiciones();
        float sumaTD = 0F;
        float sumaTL = 0F;
        int largo = lista.size();
        for(int i=0; i<largo;i++ ){
            DTOFACPosicionSolicitud posicion = (DTOFACPosicionSolicitud)lista.get(i);
            if(posicion.getPrecioTotalTD()!=null){
                sumaTD=sumaTD+posicion.getPrecioTotalTD().floatValue();
            }
            if(posicion.getPrecioTotalTL()!=null){
                sumaTL=sumaTL+posicion.getPrecioTotalTL().floatValue();
            }
        }
        dtoConso.getDtoCabecera().setPrecioTotalTotalDocumento(new Float(sumaTD));
        dtoConso.getDtoCabecera().setPrecioTotalTotalLocal(new Float(sumaTL));
    }
    private ArrayList obtenerPosicionesPorConsolidado(Long oidConsolidado)throws MareException{
        
        StringBuffer buff = new StringBuffer();
        buff.append(" select p.OID_SOLI_POSI, p.SOCA_OID_SOLI_CABE, ");
	    buff.append(" p.VAL_PREC_CATA_TOTA_DOCU, p.VAL_PREC_CATA_TOTA_LOCA, p.FOPA_OID_FORM_PAGO, ");
        buff.append(" p.VAL_PREC_TOTA_TOTA_LOCA, p.VAL_PREC_TOTA_TOTA_DOCU ");
        buff.append(" from ped_solic_posic p ");
        buff.append(" where p.SOCA_OID_SOLI_CABE in(select p1.OID_SOLI_CABE from ped_solic_cabec p1 ");
        buff.append(" where  p1.SOCA_OID_SOLI_CABE = ").append(oidConsolidado).append(") ");
        buff.append(" order by p.SOCA_OID_SOLI_CABE, p.COD_POSI");
        
        RecordSet posiciones = null;
        try{
            posiciones = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
        }catch(Exception e){
            UtilidadesLog.error("MONTratamientosContablesBean.obtenerLotesFacturacion",e);
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException(e);
            }
        }
        int largoPos = posiciones.getRowCount();
        ArrayList salida = new ArrayList();
        for(int i=0; i<largoPos; i++){
            DTOFACPosicionSolicitud posicion = new DTOFACPosicionSolicitud();
            if(posiciones.getValueAt(i,"FOPA_OID_FORM_PAGO")!=null){
                posicion.setOidFormaPago(new Long(posiciones.getValueAt(i,"FOPA_OID_FORM_PAGO").toString()));
            }
            if(posiciones.getValueAt(i,"VAL_PREC_CATA_TOTA_DOCU")!=null){
                posicion.setPrecioCatalogoTD(new Float(((BigDecimal)posiciones.getValueAt(i,"VAL_PREC_CATA_TOTA_DOCU")).floatValue()));
            }
            if(posiciones.getValueAt(i,"VAL_PREC_CATA_TOTA_LOCA")!=null){
                posicion.setPrecioCatalogoTL(new Float(((BigDecimal)posiciones.getValueAt(i,"VAL_PREC_CATA_TOTA_LOCA")).floatValue()));
            }
            if(posiciones.getValueAt(i,"VAL_PREC_TOTA_TOTA_DOCU")!=null){
                posicion.setPrecioTotalTD(new Float(((BigDecimal)posiciones.getValueAt(i,"VAL_PREC_TOTA_TOTA_DOCU")).floatValue()));
            }
            if(posiciones.getValueAt(i,"VAL_PREC_TOTA_TOTA_LOCA")!=null){
                posicion.setPrecioTotalTL(new Float(((BigDecimal)posiciones.getValueAt(i,"VAL_PREC_TOTA_TOTA_LOCA")).floatValue()));
            }
            salida.add(posicion);
        }
        return salida;
    }
    
    private ArrayList obtenerConsolidadosYCabecerasPorLote(String fechaFacturacion, String numeroLote, DTOOIDs tiposSolicitud)throws MareException{
        UtilidadesLog.info("MONTratamientosContablesBean.obtenerConsolidadosPorLote(Long numeroLote, DTOOIDs tiposSolicitud): Entrada");
        StringBuffer buff = new StringBuffer();
        
        buff.append(" select * from ");
        buff.append(" (select to_char(oid_soli_cabe)||'a' as numero_conso, p.*, c.marc_oid_marc, ");
        buff.append(" c.acce_oid_acce, c.cana_oid_cana, z.OID_SUBG_VENT, r.ZORG_OID_REGI, zt.ZSCC_OID_SECC ");
        buff.append(" from ped_solic_cabec p, cra_perio c, ZON_SUB_GEREN_VENTA z, zon_zona r , zon_terri_admin zt");
        buff.append(" WHERE p.ind_ts_no_conso = 0 ");
        buff.append(" AND p.IND_GENE_CC = 1 ");
        buff.append(" AND p.IND_PEDI_PRUE = 0 ");
        buff.append(" AND p.tspa_oid_tipo_soli_pais IN (");
        Long[] oids = tiposSolicitud.getOids();
        int largo = oids.length;
        for(int i=0; i< largo;i++){
            buff.append(oids[i].toString()).append(",");
        }
        buff.delete(buff.length()-1,buff.length());
        buff.append(") ");
        buff.append(" AND p.fec_fact = TO_DATE ('").append(fechaFacturacion).append("', 'DD-MM-YYYY') ");
        buff.append(" AND p.VAL_TOTA_PAGA_LOCA <> 0 ");
        buff.append(" AND num_lote_fact = ").append(numeroLote);
        buff.append(" AND p.PERD_OID_PERI = c.oid_peri ");
        buff.append(" AND c.PAIS_OID_PAIS = z.PAIS_OID_PAIS ");
        buff.append(" AND c.marc_oid_marc = z.marc_oid_marc ");
        buff.append(" AND c.cana_oid_cana = z.cana_oid_cana ");
        buff.append(" AND p.ZZON_OID_ZONA = r.oid_zona ");
        buff.append(" AND zt.OID_TERR_ADMI = p.ZTAD_OID_TERR_ADMI ");
        buff.append(" union ");
        buff.append(" select to_char(SOCA_OID_SOLI_CABE)||'b',p.*, ");
        buff.append(" c.marc_oid_marc, c.acce_oid_acce, c.cana_oid_cana, z.OID_SUBG_VENT, r.ZORG_OID_REGI, zt.ZSCC_OID_SECC ");
        buff.append(" from ped_solic_cabec p, cra_perio c, ZON_SUB_GEREN_VENTA z, zon_zona r ,zon_terri_admin zt");
        buff.append(" where  p.VAL_TOTA_PAGA_LOCA <> 0 ");
        buff.append(" AND p.SOCA_OID_SOLI_CABE in( ");
        buff.append(" select p1.OID_SOLI_CABE from ped_solic_cabec p1 ");
        buff.append(" WHERE p1.ind_ts_no_conso = 0 ");
        buff.append(" AND p1.IND_GENE_CC = 1 ");
        buff.append(" AND p1.IND_PEDI_PRUE = 0 ");
        buff.append(" AND p.tspa_oid_tipo_soli_pais IN (");
        for(int i=0; i< largo;i++){
            buff.append(oids[i].toString()).append(",");
        }
        buff.delete(buff.length()-1,buff.length());
        buff.append(") ");
        buff.append(" AND p1.fec_fact = TO_DATE ('").append(fechaFacturacion).append("', 'DD-MM-YYYY') ");
        buff.append(" AND p1.VAL_TOTA_PAGA_LOCA <> 0 ");
        buff.append(" AND p.PERD_OID_PERI = c.oid_peri ");
        buff.append(" AND c.PAIS_OID_PAIS = z.PAIS_OID_PAIS ");
        buff.append(" AND c.marc_oid_marc = z.marc_oid_marc ");
        buff.append(" AND c.cana_oid_cana = z.cana_oid_cana ");
        buff.append(" AND p.ZZON_OID_ZONA = r.oid_zona ");
        buff.append(" AND zt.OID_TERR_ADMI = p.ZTAD_OID_TERR_ADMI ");
        buff.append(" AND p1.num_lote_fact = ").append(numeroLote).append(")) ");
        buff.append(" order by numero_conso, OID_SOLI_CABE ");
        RecordSet solicitudes = null;
        try{
            solicitudes = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
        }catch(Exception e){
            UtilidadesLog.error("MONTratamientosContablesBean.obtenerLotesFacturacion",e);
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException(e);
            }
        }
        ArrayList salida = generarListaConsolidados(solicitudes);
        UtilidadesLog.info("MONTratamientosContablesBean.obtenerConsolidadosPorLote(Long numeroLote, DTOOIDs tiposSolicitud): Entrada");
        return salida;
    }
    
    private ArrayList generarListaConsolidados(RecordSet consolidados){
        ArrayList salida = new ArrayList();
        int largoConsolidados = consolidados.getRowCount();
        //el recordset viene ordenado por consolidado y solicitudes
        //a modo de header detalle.
        DTOFACConsolidado conso = null;
        
        for(int i=0; i<largoConsolidados; i++){
            if(consolidados.getValueAt(i,"IND_TS_NO_CONSO").toString().equals("0")){//si es un consolidado
                conso = new DTOFACConsolidado();
                conso.setDtoCabecera(obtenerDtoCabecera(consolidados,i));
                conso.setListaSolicitudes(new ArrayList());
                salida.add(conso);
            }else{
                conso.getListaSolicitudes().add(obtenerDtoCabecera(consolidados,i));
            }
        }
        return salida;
    }
    

    private DTOFACCabeceraSolicitud obtenerDtoCabecera(RecordSet consolidados, int i){
        
        DTOFACCabeceraSolicitud dto = new DTOFACCabeceraSolicitud();
        dto.setAcceso(new Long(consolidados.getValueAt(i,"ACCE_OID_ACCE").toString()));
        dto.setSubacceso(new Long(consolidados.getValueAt(i,"SBAC_OID_SBAC").toString()));
        dto.setCanal(new Long(consolidados.getValueAt(i,"CANA_OID_CANA").toString()));
        dto.setFechaFacturacion((Date)consolidados.getValueAt(i,"FEC_FACT"));
        dto.setFecha((Date)consolidados.getValueAt(i,"FEC_CRON"));
        dto.setFechaPrevistaFacturacion((Date)consolidados.getValueAt(i,"FEC_PROG_FACT"));
        dto.setFormaPago(new Long(consolidados.getValueAt(i,"FOPA_OID_FORM_PAGO").toString()));
        dto.setPeriodo(new Long(consolidados.getValueAt(i,"PERD_OID_PERI").toString()));
        dto.setOidCabeceraSolicitud(new Long(consolidados.getValueAt(i,"OID_SOLI_CABE").toString()));
        dto.setOidPais(new Long(consolidados.getValueAt(i,"PAIS_OID_PAIS").toString()));
        dto.setSociedad(new Long(consolidados.getValueAt(i,"SOCI_OID_SOCI").toString()));
        dto.setTipoSolicitud(new Long(consolidados.getValueAt(i,"TSPA_OID_TIPO_SOLI_PAIS").toString()));
        if(consolidados.getValueAt(i,"SOCA_OID_SOLI_CABE")==null){
            dto.setNumeroConsolidado(new Long(consolidados.getValueAt(i,"OID_SOLI_CABE").toString()));    
            dto.setOidConsolidado(new Long(consolidados.getValueAt(i,"OID_SOLI_CABE").toString()));
        }
        dto.setNumeroSolicitud(new Long(consolidados.getValueAt(i,"VAL_NUME_SOLI").toString()));
        dto.setMarca(new Long(consolidados.getValueAt(i,"MARC_OID_MARC").toString()));
        dto.setSubgerencia(new Long(consolidados.getValueAt(i,"OID_SUBG_VENT").toString()));
        dto.setOidSubgVentas(new Long(consolidados.getValueAt(i,"OID_SUBG_VENT").toString()));
        dto.setZona(new Long(consolidados.getValueAt(i,"ZZON_OID_ZONA").toString()));
        if(consolidados.getValueAt(i,"TIDO_OID_TIPO_DOCU")!=null){
            dto.setTipoDocumentoLegal(new Long(consolidados.getValueAt(i,"TIDO_OID_TIPO_DOCU").toString()));
        }
        dto.setOidPagadorFactura(new Long(consolidados.getValueAt(i,"CLIE_OID_CLIE_PAGA").toString()));
        dto.setOidCliente(new Long(consolidados.getValueAt(i,"CLIE_OID_CLIE").toString()));
        if(consolidados.getValueAt(i,"MONE_OID_MONE")!=null){
            dto.setMoneda(new Long(consolidados.getValueAt(i,"MONE_OID_MONE").toString()));
        }
        if(consolidados.getValueAt(i,"VAL_TIPO_CAMB")!=null){
            dto.setTipoCambio((BigDecimal)consolidados.getValueAt(i,"VAL_TIPO_CAMB"));
        }
        if(consolidados.getValueAt(i,"VAL_USUA")!=null){
            dto.setUsuario(consolidados.getValueAt(i,"VAL_USUA").toString());
        }
        if(consolidados.getValueAt(i,"IND_PEDI_PRUE")!=null){
            if(consolidados.getValueAt(i,"IND_PEDI_PRUE").toString().equals("0")){
                dto.setIndicadorPedidoPrueba(new Boolean(false));   
            }else{
                dto.setIndicadorPedidoPrueba(new Boolean(true));   
            }
        }else{
            dto.setIndicadorPedidoPrueba(new Boolean(false));
        }
        if(consolidados.getValueAt(i,"VAL_TOTA_PAGA_LOCA")!=null){
            dto.setTotalAPagarLocal(new Float(((BigDecimal)consolidados.getValueAt(i,"VAL_TOTA_PAGA_LOCA")).floatValue()));    
        }
        if(consolidados.getValueAt(i,"VAL_TOTA_PAGA_DOCU")!=null){
            dto.setTotalAPagarLocal(new Float(((BigDecimal)consolidados.getValueAt(i,"VAL_TOTA_PAGA_DOCU")).floatValue()));    
        }
        if(consolidados.getValueAt(i,"NUM_LOTE_FACT")!=null){
            dto.setNumeroLoteFacturacion(new Long(consolidados.getValueAt(i,"NUM_LOTE_FACT").toString()));
        }
        if(consolidados.getValueAt(i,"TICL_OID_TIPO_CLIE")!=null){
            dto.setTipoCliente(new Long(consolidados.getValueAt(i,"TICL_OID_TIPO_CLIE").toString()));    
        }
        if(consolidados.getValueAt(i,"SBTI_OID_SUBT_CLIE")!=null){
            dto.setSubtipoCliente(new Long(consolidados.getValueAt(i,"SBTI_OID_SUBT_CLIE").toString()));    
        }
        if(consolidados.getValueAt(i,"ZTAD_OID_TERR_ADMI")!=null){
            dto.setTerritorioCliente(new Long(consolidados.getValueAt(i,"ZTAD_OID_TERR_ADMI").toString()));
        }
        if(consolidados.getValueAt(i,"TERR_OID_TERR")!=null){
            dto.setTerritorio(new Long(consolidados.getValueAt(i,"TERR_OID_TERR").toString()));
        }
        dto.setRegion(new Long(consolidados.getValueAt(i,"ZORG_OID_REGI").toString()));
        dto.setSeccion(new Long(consolidados.getValueAt(i,"ZSCC_OID_SECC").toString()));
        return dto;
    }
    
    private RecordSet obtenerLotesFacturacion(String fechaFacturacion, DTOOIDs tiposSolicitud)throws MareException{
        UtilidadesLog.info("MONTratamientosContablesBean.obtenerLotesFacturacion(Date fechaFacturacion, ArrayList tiposSolicitud): Entrada");
        StringBuffer buff = new StringBuffer();
        buff.append(" SELECT   num_lote_fact   FROM ped_solic_cabec p  WHERE p.ind_ts_no_conso = 0 ");
        buff.append(" AND p.IND_GENE_CC = 1	 AND p.IND_PEDI_PRUE = 0 ");
        buff.append(" AND p.VAL_TOTA_PAGA_LOCA <> 0 ");
        buff.append(" AND p.fec_fact = TO_DATE ('"+fechaFacturacion+"', 'DD-MM-YYYY') ");
        buff.append(" AND p.tspa_oid_tipo_soli_pais IN (");
        Long[] oids = tiposSolicitud.getOids();
        int largo = oids.length;
        for(int i=0; i< largo;i++){
            buff.append(oids[i].toString()).append(",");
        }
        buff.delete(buff.length()-1,buff.length());
        buff.append(") ");
        buff.append(" GROUP BY num_lote_fact ");
        buff.append(" ORDER BY 1 ");
        RecordSet salida = null;
        try{
            salida = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
        }catch(Exception e){
            UtilidadesLog.error("MONTratamientosContablesBean.obtenerLotesFacturacion",e);
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException(e);
            }
        }
        UtilidadesLog.info("MONTratamientosContablesBean.obtenerLotesFacturacion(Date fechaFacturacion, ArrayList tiposSolicitud): Salida");
        return salida;
    }


	/**
         * CHANGELOG
         * ---------
         * Cambio 20090884 - dmorello, 17/04/2009: Se guarda registro con impuestos de productos gratis
         * Cambio 20090904 - dmorello, 10/06/2009: No se crea nuevo registro para guardar impuesto de productos gratis
         *                                         sino que se guarda en uno de los existentes.
         */
        public void generarRegistroCC(DTOFACConsolidado dtoConso) throws MareException {
		UtilidadesLog.info("MONTratamientosContablesBean.generarRegistroCC(DTOFACConsolidado dtoConso): Entrada");
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                    UtilidadesLog.debug("*** DTOFACConsolidado: "+ dtoConso);

	    // sapaza -- PER-SiCC-2011-0053 -- 20/01/2011
	    
        //SB PER-SiCC-2012-0266 03/04/2012
	//  Long suma = getNumUnidadCompra(dtoConso.getDtoCabecera().getOidCabeceraSolicitud());//SI ES NULO DEVUELVE CERO
	//  if(suma == 0) {            
	  if(dtoConso.getDtoCabecera().getNumeroUnidadesAtendidasTotal().longValue() == 0) {
	        UtilidadesLog.debug("getNumeroUnidadesAtendidasTotal es cero");
	        UtilidadesLog.info("MONTratamientosContablesBean.generarRegistroCC(DTOFACConsolidado dtoConso): Salida");
	        return;
	    }

        if ( dtoConso.getDtoCabecera().getIndicadorPedidoPrueba().booleanValue() ) {
            UtilidadesLog.debug("IndicadorPedidoPrueba = true, se termina el CU");
            return; 
        } else {
            AccesoLocalHome accesoHome = this.getAccesoLocalHome();
            AccesoLocal accesoLocal = null;
            try{
                accesoLocal = accesoHome.findByPrimaryKey(dtoConso.getDtoCabecera().getAcceso());
            } catch(NoResultException fe) {
                UtilidadesLog.error("generarRegistroCC: FinderException",fe);
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            }
            
            if (accesoLocal.getIndicador().equals("B")) {
                // INCIDENCIA 14979
                //Finaliza el CU. Devuelve el control para que la aplicación de Belcenter 
                //pueda cobrar la solicitud.
                return;
            } else {
                //Tratamos la cabecera y los detalles del consolidado 
                ArrayList regFPagos=new ArrayList(); 
                double sumaImporteLocal=0D; 
                double sumaImporteDoc=0D;
                double sumaImpuestoLocal=0D;
                double sumaImpuestoDoc=0D;
                FormaPago fp = null; 
                double auxCompare = 0D;
                BigDecimal impLocal = null;
                BigDecimal impDoc = null;        
                double impuestoLocal = 0D;
                double impuestoDoc = 0D;
                
                ArrayList posiciones=dtoConso.getListaPosiciones();
                UtilidadesLog.debug("posiciones  size " + posiciones.size());
                DTOFACPosicionSolicitud posi=null; 
                
                UtilidadesLog.debug("numero de decimales de redondeo: " + dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue());
        
                for (int i=0; i<posiciones.size(); i++) { 

                    posi=(DTOFACPosicionSolicitud)posiciones.get(i); 
                    fp = new FormaPago();
                    
                    // Cambio 20090884 - dmorello, 17/04/2009 - Calculo impuesto local y documento
                    // para todos los productos, incluyendo productos gratis
                    if (posi.getPrecioCatalogoTL() != null && posi.getPrecioCatalogoTL().floatValue() == 0
                            && posi.getPrecioContableTL() != null && posi.getPrecioContableTL().floatValue() > 0) {
                        impuestoLocal = posi.getImporteImpuestoTL().floatValue();
                        impuestoDoc = posi.getImporteImpuestoTD().floatValue();
                    } else {
                        impuestoLocal = 0D;
                        impuestoDoc = 0D;
                    }
                     
                    sumaImpuestoLocal += impuestoLocal;
                    sumaImpuestoDoc += impuestoDoc;
                    UtilidadesLog.debug("- DM - sumaImpuestoLocal(" + i +"): " + sumaImpuestoLocal);
                    UtilidadesLog.debug("- DM - sumaImpuestoDoc(" + i +"): " + sumaImpuestoDoc);
                    
                    if (posi.getOidFormaPago() == null || posi.getOidFormaPago().longValue()== dtoConso.getDtoCabecera().getFormaPago().longValue()) {
                         continue;
                    }
                    fp.setOidFormaPago(posi.getOidFormaPago());
                    
                    /*Se modifico por Cambio SiCC 20080585 --- AL --- 13/08/2008 */
                    if (posi.getPrecioCatalogoTL() != null && posi.getPrecioCatalogoTL().floatValue() != 0) {
                        //fp.setImporteLocal(new BigDecimal(posi.getPrecioCatalogoTL().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN)); 
                        //scs - 10/07/2008; RI20080645, tema: generacion de Cta.Cte con 0 decimales.
                        if (posi.getPrecioFacturaTL() != null) {
                            fp.setImporteLocal(new BigDecimal(posi.getPrecioFacturaTL().doubleValue()).setScale(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue(), BigDecimal.ROUND_HALF_EVEN)); 
                        } else {
                            UtilidadesLog.debug("MONTratamientosContablesBean.generarRegistroCC -- Precio Factura Total Local es NULL --> Importe Local = 0");
                            fp.setImporteLocal(new BigDecimal(0));
                        }                        
                    } else {
                        fp.setImporteLocal(new BigDecimal(0));
                    }
                    if (posi.getPrecioCatalogoTD()!=null && posi.getPrecioCatalogoTD().floatValue() != 0) {
                        //fp.setImporteDoc(new BigDecimal(posi.getPrecioCatalogoTD().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN));
                        //fp.setImporteDoc(new BigDecimal(posi.getPrecioCatalogoTD().doubleValue()).setScale(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue(), BigDecimal.ROUND_HALF_EVEN));
                        if (posi.getPrecioFacturaTD() != null) {
                            fp.setImporteDoc(new BigDecimal(posi.getPrecioFacturaTD().doubleValue()).setScale(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue(), BigDecimal.ROUND_HALF_EVEN)); 
                        } else {
                            UtilidadesLog.debug("MONTratamientosContablesBean.generarRegistroCC -- Precio Factura Total Documento es NULL --> Importe Documento = 0");
                            fp.setImporteDoc(new BigDecimal(0));
                        }                        
                    } else {
                        fp.setImporteDoc(new BigDecimal(0));
                    }
                    /*Se modifico por Cambio SiCC 20080585 --- AL --- 13/08/2008 Fin Modificaciones */
                    
                    if (fp.getImporteLocal()!=null) {
                        UtilidadesLog.debug(" fp.getImporteLocal(): " + fp.getImporteLocal());                        
                        //UtilidadesLog.debug(" !!!   fp.getImporteLocal().intValue()  : " + fp.getImporteLocal().intValue());                        
                        sumaImporteLocal += fp.getImporteLocal().doubleValue();
                        UtilidadesLog.debug(" sumaImporteLocal: " + sumaImporteLocal);
                    }
                    if (fp.getImporteDoc()!=null) {
                        sumaImporteDoc+=fp.getImporteDoc().doubleValue(); 
                    }
                    UtilidadesLog.debug("- GA - fp("+i+").getImporteDoc():"+fp.getImporteDoc());
                    UtilidadesLog.debug("- GA - fp("+i+").getImporteLocal():"+fp.getImporteLocal());
                    
                    //sbuchelli PER-SiCC-2009-0573
                    int index= buscarFormaPago(fp,regFPagos);
                    UtilidadesLog.debug("index encontrado "+ index);
                    if(index!=-1){//existe
                        //se sumarizan los importes de las posiciones que tengan igual forma de pago
                         UtilidadesLog.debug("actualizando forma pago");
                        FormaPago fpAux= (FormaPago)regFPagos.get(index);
                        fpAux.setImporteDoc(new BigDecimal(fpAux.getImporteDoc().doubleValue() + fp.getImporteDoc().doubleValue()));
                        fpAux.setImporteLocal(new BigDecimal(fpAux.getImporteLocal().doubleValue() + fp.getImporteLocal().doubleValue()));
                    }else{//si no existe se agrega al arreglo
                        UtilidadesLog.debug("insertando forma pago");
                        regFPagos.add(fp); 
                    }
                } 
                
                //SolicitudCabecera (Cabecera)
                fp = new FormaPago();
                boolean agregar = false; // Flag que indicara si fp debe agregarse a regFPagos
                if (dtoConso.getDtoCabecera().getFormaPago()!=null) {
                    fp.setOidFormaPago(dtoConso.getDtoCabecera().getFormaPago());
                }
                if (dtoConso.getDtoCabecera().getTotalAPagarLocal()!=null) {
                    //sapaza -- PER-SiCC-2012-0088 -- 08/02/2012
                    double gastoAdministrativo = obtenerGastoAdministrativo(dtoConso.getDtoCabecera().getOidCabeceraSolicitud());
                    impLocal = new BigDecimal((dtoConso.getDtoCabecera().getTotalAPagarLocal().doubleValue()) - sumaImporteLocal + gastoAdministrativo).setScale(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue(), BigDecimal.ROUND_HALF_EVEN);
                }
                if (impLocal!=null) {
                    fp.setImporteLocal(new BigDecimal(impLocal.doubleValue()));
                }
                if (dtoConso.getDtoCabecera().getTotalAPagarDocumento()!=null) {
                    impDoc = new BigDecimal((dtoConso.getDtoCabecera().getTotalAPagarDocumento().doubleValue()) - sumaImporteDoc).setScale(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue(), BigDecimal.ROUND_HALF_EVEN);
                }
                if (dtoConso.getDtoCabecera().getPrecioTotalTotalDocumento()!=null) {
                    impDoc = new BigDecimal((dtoConso.getDtoCabecera().getPrecioTotalTotalDocumento().doubleValue()) - sumaImporteDoc).setScale(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue(), BigDecimal.ROUND_HALF_EVEN);
                }
                if (impDoc!=null) {
                    fp.setImporteDoc(new BigDecimal(impDoc.doubleValue()).setScale(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue(), BigDecimal.ROUND_HALF_EVEN));
                }	
                if ((fp.getImporteLocal().doubleValue() != auxCompare) || (fp.getImporteDoc().doubleValue() != auxCompare)){
                    agregar = true;
                }
                
                // Verifico si para el pais corresponde cobrar impuestos de productos gratis
                Boolean indImpuProdGratis = this.obtenerIndImpuestosProdGratis(dtoConso.getOidPais());
                UtilidadesLog.debug("indImpuProdGratis: " + indImpuProdGratis);
                
                if (indImpuProdGratis != null && indImpuProdGratis.booleanValue()) {
                
                    // Se suma al ultimo registro el impuesto de los productos gratis
                    
                    BigDecimal bdSumaImpLocal = new BigDecimal(Double.toString(sumaImpuestoLocal));
                    if (fp.getImporteLocal() != null) {
                        BigDecimal nuevoImpLocal = fp.getImporteLocal().add(bdSumaImpLocal);
                        fp.setImporteLocal(nuevoImpLocal);
                    } else {
                        fp.setImporteLocal(bdSumaImpLocal);
                    }
                    
                    BigDecimal bdSumaImpDoc = new BigDecimal(Double.toString(sumaImpuestoDoc));
                    if (fp.getImporteDoc() != null) {
                        BigDecimal nuevoImpDoc = fp.getImporteLocal().add(bdSumaImpDoc);
                        fp.setImporteDoc(nuevoImpDoc);
                    } else {
                        fp.setImporteDoc(bdSumaImpDoc);
                    }
                    
                    agregar = true;
                    
                    UtilidadesLog.debug("- DM - sumaImpuestoLocal: " + sumaImpuestoLocal);
                    UtilidadesLog.debug("- DM - sumaImpuestoDoc: " + sumaImpuestoDoc);
                    UtilidadesLog.debug("- DM - nuevoImpLocal: " + fp.getImporteLocal());
                    UtilidadesLog.debug("- DM - nuevoImpDoc: " + fp.getImporteDoc());
                }
                
                // Agrego el registro a la lista si corresponde
                if (agregar) {
                    regFPagos.add(fp);
                }
                
                //Llamamos al CU Generar Apuntes Forma Pago por cada una de las Formas de Pago creadas 
                ArrayList todosDesgloses=new ArrayList(); 
                DTOApFormPagE dtoApFPE;
                ArrayList tempo = null;                
                for (int i=0; i<regFPagos.size(); i++) { 
                    fp=(FormaPago)regFPagos.get(i); 
                    UtilidadesLog.debug("- GA - Forma de pago("+i+").getImporteDoc():"+fp.getImporteDoc());
                    UtilidadesLog.debug("- GA - Forma de pago("+i+").getImporteLocal():"+fp.getImporteLocal());
                    dtoApFPE=new DTOApFormPagE(); 
                    if (new BigDecimal(fp.getImporteLocal().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue() != 0.0){
                        dtoApFPE.setImporteFracLocal(fp.getImporteLocal());
                        dtoApFPE.setImporteFracDoc(fp.getImporteDoc());
                        dtoApFPE.setOidFormaPago(fp.getOidFormaPago());
                        dtoApFPE.setFechaFacturacion(dtoConso.getDtoCabecera().getFechaFacturacion());
                        dtoApFPE.setOidMarca(dtoConso.getDtoCabecera().getMarca());
                        dtoApFPE.setOidCanal(dtoConso.getDtoCabecera().getCanal());
                        dtoApFPE.setOidPeriodo(dtoConso.getDtoCabecera().getPeriodo());
                        dtoApFPE.setOidZona(dtoConso.getDtoCabecera().getZona());
                        dtoApFPE.setOidPais(dtoConso.getDtoCabecera().getOidPais());
                        //scs - 10/07/2008; RI20080645, tema: generacion de Cta.Cte con 0 decimales.
                        //tempo = this.generarApuntesFormaPago(dtoApFPE);
                        tempo = this.generarApuntesFormaPago(dtoApFPE, dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo().intValue());
                        Iterator iteraTempo = tempo.iterator();
                        int n=0;
                        while(iteraTempo.hasNext()){
                            Desglose des = (Desglose)iteraTempo.next();
                            UtilidadesLog.debug("- GA - Desglose("+n+").getImporteCuotaFracDoc(): "+des.getImporteCuotaFracDoc());
                            UtilidadesLog.debug("- GA - Desglose("+n+").getImporteCuotaFracLocal(): "+des.getImporteCuotaFracLocal());
                            todosDesgloses.add(des);
                            n+=1;
                        }
                    }                
                } 
                //Ordenamos por fechaVto y oidMedioPago 
                //Para ello el objeto Desglose implementa la interface java.lang.Comparable 	
                Collections.sort(todosDesgloses);     
        
                //Generar MovimientosCuentaCorriente 
                UtilidadesLog.debug("Numero de Desgloses =" +todosDesgloses.size());
                DTOMovimientoCuentaCompleto[] mccArray=new DTOMovimientoCuentaCompleto[todosDesgloses.size()]; 

                //Obtenemos el Tipo Periodo segun el canal 
                CanalLocalHome home = this.getCanalLocalHome();
                CanalLocal canalLocal = null;
                try{
                    canalLocal = home.findByPrimaryKey(dtoConso.getDtoCabecera().getCanal()); 
                }catch(NoResultException fe){
                    UtilidadesLog.error("generarRegistroCC: FinderException",fe);
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                }
                Long oidTipoPeriodo = canalLocal.getOidTipoPeriodo();

                DTOMovimientoCuentaCompleto mcc=null; 
                int numOrden=0; 
                
                /*
                * DBLG400000977 - dmorello, 18/04/2006
                * Si el cliente contra el cual se genera la solicitud
                * no coincide con el pagador, se buscan los datos de éste.
                */
                Long oidClientePagador = null;
                Long oidTipoClientePagador = null;
                Long oidSubTipoClientePagador = null;
                RecordSet rAdm = null;
                if (todosDesgloses.size() > 0){
                    if (dtoConso.getDtoCabecera().getOidPagadorFactura().longValue()
                            == dtoConso.getDtoCabecera().getOidCliente().longValue()) {
                        UtilidadesLog.debug("Cliente y Pagador coinciden");    
                        oidClientePagador = dtoConso.getDtoCabecera().getOidCliente(); 
                        oidTipoClientePagador = dtoConso.getDtoCabecera().getTipoCliente(); 
                        oidSubTipoClientePagador = dtoConso.getDtoCabecera().getSubtipoCliente();                         
                    } else {
                        UtilidadesLog.debug("Cliente y pagador no coinciden");
                        // Busco tipo y subtipo del pagador con su OID
                        ClienteTipoSubTipoLocalHome ctsHome = this.getClienteTipoSubTipoLocalHome();
                        Long oidPagadorFactura = dtoConso.getDtoCabecera().getOidPagadorFactura();
                        Collection ts;
                        try {
                            ts = ctsHome.findByCliente(oidPagadorFactura);
                        } catch (NoResultException e) {
                            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                        }
                        // Si no se recuperan datos, arrojo excepción
                        if (ts.isEmpty()) {
                            String error = "*** No se encontró ClienteTipoSubTipo para el pagador ***";
                            String codError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                            UtilidadesLog.debug(error);
                            throw new MareException(error, UtilidadesError.armarCodigoError(codError));
                        }
                        // MOD - clopez - 17/04/2006
                        // Se tomará el PRIMER tipo-subtipo hallado
                        Iterator itTipo = ts.iterator();
                        ClienteTipoSubTipoLocal tipoSubTipoPagador = null;
                        while (itTipo.hasNext()){
                            tipoSubTipoPagador = (ClienteTipoSubTipoLocal)ts.iterator().next();
                            if (tipoSubTipoPagador.getInd_ppal()!=null && tipoSubTipoPagador.getInd_ppal().longValue() == 1){
                                break;
                            }                                
                        }   
                        oidClientePagador = tipoSubTipoPagador.getClie_oid_clie(); 
                        oidTipoClientePagador = tipoSubTipoPagador.getTicl_oid_tipo_clie(); 
                        oidSubTipoClientePagador = tipoSubTipoPagador.getSbti_oid_subt_clie();
                        rAdm = this.buscarDatosAdministrativos(tipoSubTipoPagador.getClie_oid_clie());
                    }
                }
                for(int i=0; i<todosDesgloses.size(); i++) { 
                    Desglose desglose=(Desglose)todosDesgloses.get(i); 
                    mcc=new DTOMovimientoCuentaCompleto(); 
                    mcc.setOidPais(dtoConso.getDtoCabecera().getOidPais()); 
                    mcc.setEmpresa(dtoConso.getDtoCabecera().getSociedad()); 
                    mcc.setOidTipoSolicitud(dtoConso.getDtoCabecera().getTipoSolicitud()); //incidencia  BELC300016584
                    mcc.setNumeroIdentificadorCuota(new Integer(dtoConso.getDtoCabecera().getNumeroSolicitud().intValue()));
                    numOrden++;
                    mcc.setNumeroOrdenCuota(new Integer (numOrden));
                    mcc.setOidCanal(dtoConso.getDtoCabecera().getCanal()); 
                    mcc.setOidAcceso(dtoConso.getDtoCabecera().getAcceso()); 
                    mcc.setSubacceso(dtoConso.getDtoCabecera().getSubacceso()); 
                    mcc.setMarca(dtoConso.getDtoCabecera().getMarca()); 
                    mcc.setOidSugerenciaVenta(dtoConso.getDtoCabecera().getOidSubgVentas()); 
                    mcc.setOidRegion(dtoConso.getDtoCabecera().getRegion()); 
                    mcc.setOidSeccion(dtoConso.getDtoCabecera().getSeccion()); 
                    mcc.setOidTipoDocumentoLegal(dtoConso.getDtoCabecera().getTipoDocumentoLegal());
                    mcc.setTerritorioAdministrativo(dtoConso.getDtoCabecera().getTerritorioCliente()); //incidencia 18566
                    //mcc.setOidPedidoSolicitudCab(dtoConso.getDtoCabecera().getOidDocumentoReferencia()); //incidencia 16800 e incidencia 18566
                    mcc.setTipoPeriodoDesde(oidTipoPeriodo); 
                    mcc.setPeriodoDesde(desglose.getOidPerioCCC()); //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
                    /*
                     * DBLG400000977 - dmorello, 18/04/2006
                     * Si el cliente contra el cual se genera la solicitud
                     * no coincide con el pagador, se buscan los datos de éste.
                     */
                    if (dtoConso.getDtoCabecera().getOidPagadorFactura().longValue()
                            == dtoConso.getDtoCabecera().getOidCliente().longValue()) {
                        UtilidadesLog.debug("Cliente y Pagador coinciden");    
                        mcc.setOidCliente(oidClientePagador); 
                        mcc.setTipoCliente(oidTipoClientePagador); 
                        mcc.setOidSubtipoCliente(oidSubTipoClientePagador);
                    } else {
                    
                        UtilidadesLog.debug("Cliente y pagador no coinciden");
                        mcc.setOidCliente(oidClientePagador); 
                        mcc.setTipoCliente(oidTipoClientePagador); 
                        mcc.setOidSubtipoCliente(oidSubTipoClientePagador);
                        mcc = this.completarDatosAdministrativos (mcc, rAdm);
                    }
                    // Fin DBLG400000977 dmorello
                    mcc.setFechaDocumento(dtoConso.getDtoCabecera().getFecha());
                    mcc.setFechaVencimiento(desglose.getFechaVto());
                    mcc.setFechaValor(dtoConso.getDtoCabecera().getFecha());
                    if (desglose.getImporteCuotaFracLocal()!=null) {
                        mcc.setImporte(new Double(desglose.getImporteCuotaFracLocal().doubleValue()));
                    }
                    
                    mcc.setImportePagado(new Double("0"));
                    mcc.setImportePendiente(new Double(desglose.getImporteCuotaFracLocal().doubleValue()));
        
                    if (dtoConso.getDtoCabecera().getMoneda() == null){
                        mcc.setImporteDivisa(new Double("0")); 
                    }else{
                        mcc.setImporteDivisa(new Double(desglose.getImporteCuotaFracDoc().doubleValue()));
                    }
                    
                    mcc.setImportePagadoDivisa(new Double("0")); 
                    if(dtoConso.getDtoCabecera().getTipoCambio() != null){
                        mcc.setTipoCambio(dtoConso.getDtoCabecera().getTipoCambio()); 
                    }else{
                        mcc.setTipoCambio(new BigDecimal("0"));
                    }
                    mcc.setMedioPago(desglose.getOidMedioPago()); 
                    if (dtoConso.getDtoCabecera().getUsuario()==null){
                        String usuario = ctx.getCallerPrincipal().getName();
                        UtilidadesLog.debug("*** Usuario = "+usuario);
                        mcc.setUsuario(usuario); 
                    }else{
                        mcc.setUsuario(dtoConso.getDtoCabecera().getUsuario());
                    }
        
                    mcc.setObservaciones(dtoConso.getDtoCabecera().getObservaciones());
                    //Obtenemos el año y el mes de dtoConso.dtoCabecera.fecha 
                    String anio = null;
                    String mes = null;
                    if(dtoConso.getDtoCabecera().getFecha()!=null){
                        java.sql.Date fechaSql = new 
                        java.sql.Date(dtoConso.getDtoCabecera().getFecha().getTime());
                        StringTokenizer st=new StringTokenizer(fechaSql.toString(),"-");
                        if (st.countTokens()>0){	
                            anio=st.nextToken().toString();
                            mes=st.nextToken().toString();    
                        }
                        anio = anio.substring(2);
                        mcc.setDocumentoMesSerie(mes);
                        mcc.setDocumentoAnyo(anio);
                       // mcc.setEjercicioCuota(anio); se rellena en el metodo generarCuentaCorriente
                    }
                    mcc.setDocumentoNumero(new Integer(0));
                    /*
                     * DBLG500000979 - dmorello, 07/08/2006
                     * El campo referenciaNumeroDocumentoExterno no debe escribirse
                     */
                    //if (dtoConso.getDtoCabecera().getOidDocumentoReferencia()!=null){
                    //    mcc.setReferenciaNumeroDocumentoExterno(dtoConso.getDtoCabecera().getOidDocumentoReferencia().toString());
                    //}
                    mcc.setOidPedidoSolicitudCab(dtoConso.getDtoCabecera().getOidCabeceraSolicitud());
                    if (dtoConso.getDtoCabecera().getNumeroLoteFacturacion()!=null){
                        mcc.setNumeroLoteFactu(new Integer(dtoConso.getDtoCabecera().getNumeroLoteFacturacion().intValue()));
                    }
                    //scs - 10/07/2008; RI20080645, tema: generacion de Cta.Cte con 0 decimales.                    
                    mcc.setNumDecimales(dtoConso.getDtoCabecera().getNumeroDecimalesRedondeo());
        
                    mccArray[i] = mcc;    
                }//fin del bucle for                

                /*
                 * Si hay movimientos cuentas corrientes.
                 * Llamamos al CU Generar Cuenta Corriente pasándole el array de objetos tipo DTOMovimientoCuentaCompleto.
                 * 
                 */
                UtilidadesLog.debug("size MovCC = "+mccArray.length); 
                if (mccArray.length > 0) {
                    MONCuentasCorrientesPerf mONCuentasCorrientesPerf = this.getMONCuentasCorrientesPerf();
                    try{                
                        mONCuentasCorrientesPerf.generarCuentaCorriente( mccArray ); 
                    }catch(RemoteException re){
                        UtilidadesLog.error("Error en generarCuentaCorriente",re);
                        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
                    }
                }
                 
/*                MONCuentasCorrientes mONCuentasCorrientes = this.getMONCuentasCorrientes();
                try{
                    mONCuentasCorrientes.generarCuentaCorriente( mccArray ); 
                }catch(RemoteException re){
                    UtilidadesLog.error("Error en generarCuentaCorriente",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
                }
*/
            }
        }
        UtilidadesLog.info("MONTratamientosContablesBean.generarRegistroCC(DTOFACConsolidado dtoConso): Salida");
	} 

  
    private DTOMovimientoCuentaCompleto completarDatosAdministrativos (DTOMovimientoCuentaCompleto mcc, RecordSet rs){
        if (rs!=null && !rs.esVacio()){
            if (rs.getValueAt(0,0)!=null){
                mcc.setOidSugerenciaVenta(new Long(rs.getValueAt(0,0).toString()));
            }
            if (rs.getValueAt(0,1)!=null){
                mcc.setOidSeccion(new Long(rs.getValueAt(0,1).toString()));
            }
            if (rs.getValueAt(0,2)!=null){
                mcc.setOidRegion(new Long(rs.getValueAt(0,2).toString()));
            }
            if (rs.getValueAt(0,3)!=null){
                mcc.setTerritorioAdministrativo(new Long(rs.getValueAt(0,3).toString()));
            }
        }
        return mcc;
    }
    
    private RecordSet buscarDatosAdministrativos (Long cliente){
        RecordSet rs = null;
        try{
            StringBuffer sb = new StringBuffer("SELECT sgad.oid_subg_vent, zad.zscc_oid_secc, rad.oid_regi, zad.oid_terr_admi ");
            sb.append( " FROM mae_clien_unida_admin ad, ");
            sb.append( " zon_terri_admin zad, ");
            sb.append( " zon_secci sad, ");
            sb.append( " zon_zona zoad, ");
            sb.append( " zon_regio rad, ");
            sb.append( " zon_sub_geren_venta sgad ");
            sb.append( " WHERE ad.clie_oid_clie = "+cliente);
            sb.append( " AND ad.perd_oid_peri_fin IS NULL ");
            sb.append( " AND ad.ind_acti = 1 ");
            sb.append( " AND zad.oid_terr_admi = ad.ztad_oid_terr_admi ");
            sb.append( " AND sad.oid_secc = zad.zscc_oid_secc ");
            sb.append( " AND zoad.oid_zona = sad.zzon_oid_zona ");
            sb.append( " AND rad.oid_regi = zoad.zorg_oid_regi ");
            sb.append( " AND sgad.oid_subg_vent = rad.zsgv_oid_subg_vent ");
            
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
          
        }catch (Exception e){
            UtilidadesLog.error("ERROR AL OBTENER LA UNIDAD ADMINISTRATIVA DEL CLIENTE PAGADOR");
        }
        return rs;
    
    }

    /**
     * Desglose del importe, en función de las Formas de Pago de cabecera
     * o posición del consolidado (SolicitudCabecera y SolicitudPosicion),
     * para su imputación como cuotas en cuenta corriente (MovimientosCuentaCorriente).
     */
    public ArrayList generarApuntesFormaPago(DTOApFormPagE dtoE, int numDecimales) throws MareException {
        /* Desglose del importe, en función de las Formas de Pago de cabecera
         * o posición del consolidado (SolicitudCabecera y SolicitudPosicion),
         * para su imputación como cuotas
         * en cuenta corriente (MovimientosCuentaCorriente).
         */
        UtilidadesLog.info("MONTratamientosContablesBean.generarApuntesFormaPago(DTOApFormPagE dtoE): Entrada");
        double diferenciaCuotaFracLocal = 0; 
        double diferenciaCuotaFracDoc   = 0;
        String usuario = ctx.getCallerPrincipal().getName();
        boolean findPeriodo;

        //Recuperar detalles de formas de pago 
        //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
        ProcesoFacturacionHelper helper = ProcesoFacturacionHelper.getInstance(dtoE.getOidPais());
        RecordSet regfp = null;
        DTOSalida dtoFP = helper.getFPagoDetalNumPosi(dtoE.getOidFormaPago());
        regfp = dtoFP.getResultado();
        /*DAOFormasPagoDetalle dao = new DAOFormasPagoDetalle(usuario);
        RecordSet regfp = null;
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(dtoE.getOidFormaPago());
        DTOSalida dtoFP = helper.consultarFPagoDetalNumPosi(dtoE.getOidFormaPago());*/
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("*** Tamanio regfp = "+regfp.getRowCount());
          UtilidadesLog.debug("*** regfp = " + regfp);
        }     
        int longitud = regfp.getRowCount();

        //Generamos los desgloses por cada línea de detalle de formas de pago obtenida. 
        ArrayList desgloses = new ArrayList();
        Desglose desglose = null;
        BigDecimal sumaImporteFracLocal = new BigDecimal(0);
        BigDecimal sumaImporteFracDoc = new BigDecimal(0);

        DAOCRA daoCra = new DAOCRA();
        RecordSet regFechaCrono = null;
        DTOSalida dtoSFechas = null;
        
        PeriodoLocal periodoLocal=null;
        PeriodoLocalHome periodoLocalHome= this.getPeriodoLocalHome();
        try {
            periodoLocal=periodoLocalHome.findByPrimaryKey(dtoE.getOidPeriodo());
            findPeriodo = true;
        }catch(NoResultException fe) {
            UtilidadesLog.debug("No hay datos en finderPrimaryKey de la entidad Periodo");
            findPeriodo = false;
        }

        Date fechaTemporal=null;
        for (int i = 0; i < longitud; i++) {
            desglose = new Desglose();
            desglose.setNumeroOrden(new Integer(regfp.getValueAt(i,"NUM_POSI_DETA").toString()));
            desglose.setOidMedioPago(new Long(regfp.getValueAt(i,"MPAB_OID_MEDI_PAGO").toString()));
            //segun inc.: 21546 dvjuiz; se sacan las 2 lineas de la condicion verdadera del if!
            //scs - 10/07/2008; RI20080645, tema: generacion de Cta.Cte con 0 decimales.
            //desglose.setImporteCuotaFracLocal(new BigDecimal( (dtoE.getImporteFracLocal().doubleValue() * ((BigDecimal)regfp.getValueAt(i, "VAL_PORC_PAGO")).doubleValue()) / new Double(100.0).doubleValue() ).setScale(2,BigDecimal.ROUND_HALF_EVEN));
            //desglose.setImporteCuotaFracDoc(new BigDecimal( (dtoE.getImporteFracDoc().doubleValue() * ((BigDecimal)regfp.getValueAt(i, "VAL_PORC_PAGO")).doubleValue()) / new Double(100.0).doubleValue() ).setScale(2,BigDecimal.ROUND_HALF_EVEN));
            desglose.setImporteCuotaFracLocal(new BigDecimal( (dtoE.getImporteFracLocal().doubleValue() * ((BigDecimal)regfp.getValueAt(i, "VAL_PORC_PAGO")).doubleValue()) / new Double(100.0).doubleValue() ).setScale(numDecimales,BigDecimal.ROUND_HALF_EVEN));
            desglose.setImporteCuotaFracDoc(new BigDecimal( (dtoE.getImporteFracDoc().doubleValue() * ((BigDecimal)regfp.getValueAt(i, "VAL_PORC_PAGO")).doubleValue()) / new Double(100.0).doubleValue() ).setScale(numDecimales,BigDecimal.ROUND_HALF_EVEN));
            
            //sumaImporteFracLocal = new BigDecimal(sumaImporteFracLocal.doubleValue() + desglose.getImporteCuotaFracLocal().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
            //sumaImporteFracDoc = new BigDecimal(sumaImporteFracDoc.doubleValue() + desglose.getImporteCuotaFracDoc().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
            sumaImporteFracLocal = new BigDecimal(sumaImporteFracLocal.doubleValue() + desglose.getImporteCuotaFracLocal().doubleValue()).setScale(numDecimales, BigDecimal.ROUND_HALF_EVEN);
            sumaImporteFracDoc = new BigDecimal(sumaImporteFracDoc.doubleValue() + desglose.getImporteCuotaFracDoc().doubleValue()).setScale(numDecimales, BigDecimal.ROUND_HALF_EVEN);
            
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("*** desglose.ImporteCuotaFracLocal, es: " + desglose.getImporteCuotaFracLocal());
              UtilidadesLog.debug("*** desglose.ImporteCuotaFracDoc, es: " + desglose.getImporteCuotaFracDoc());
              UtilidadesLog.debug("*** sumaImporteFracLocal, es: " + sumaImporteFracLocal);
              UtilidadesLog.debug("*** sumaImporteFracDoc, es: " + sumaImporteFracDoc);
            }  
        
            //Calcular Fecha de Vencimiento 
            char valor = ((String)regfp.getValueAt(i, "COD_INDI_DIAS")).charAt(0); 
            
            //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
            desglose.setOidPerioCCC(dtoE.getOidPeriodo());
				
            if(valor == ConstantesBEL.FPAGO_NUMERODIAS.charValue()) {
                int dias = regfp.getValueAt(i, "NUM_DIAS") !=null ? ((BigDecimal) regfp.getValueAt(i, "NUM_DIAS")).intValue() :0 ;
                desglose.setFechaVto(UtilidadesFecha.addDays(dtoE.getFechaFacturacion(), dias));
            }
			
            if(valor == ConstantesBEL.FPAGO_ACTIVIDAD.charValue()) {
                if ((((BigDecimal)regfp.getValueAt(i, "MARC_OID_MARC")).intValue() == dtoE.getOidMarca().intValue()) &&
                        (((BigDecimal)regfp.getValueAt(i, "CANA_OID_CANA")).intValue() == dtoE.getOidCanal().intValue())) {
                    //modificado por incidencia 19187
                    
                    //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
                    Long dias = regfp.getValueAt(i, "NUM_DIAS") !=null ? ((BigDecimal) regfp.getValueAt(i, "NUM_DIAS")).longValue() :0 ;
                    Long perioCCC = helper.getPeriodoPosterior(dtoE.getOidPeriodo(),  dias);
                    
                    dtoSFechas = daoCra.obtieneFechasCronograma(dtoE.getOidPais(), dtoE.getOidMarca(), dtoE.getOidCanal(), 
                                dtoE.getOidPeriodo(), dtoE.getOidZona(), new Long(regfp.getValueAt(i, "CACT_OID_ACTI").toString()));                                
                    
                    //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
                    desglose.setOidPerioCCC(perioCCC);
        
                    regFechaCrono = dtoSFechas.getResultado();
                    if (regFechaCrono.getRowCount()>0) {
                        //Modificado por : Cristian Valenzuela
                        //Incidencia: V-CCC-017
                        //Este recorset siempre tendra 1 registro
                        //por lo tanto tiraba NullPointerException
                        //en el segundo ciclo del bucle porque utilizaba i para obtener
                        //la fila, se cambia a 0, el unico registro que tiene.
                        //desglose.setFechaVto((Date)regFechaCrono.getValueAt(i, "FEC_INIC"));
                        desglose.setFechaVto((Date)regFechaCrono.getValueAt(0, "FEC_INIC"));
                        //FIN Modificado por : Cristian Valenzuela
                        UtilidadesLog.debug("*** Tamanio regFechaCrono = "+regFechaCrono.getRowCount());  
                    }
                } else {
                    desglose.setFechaVto(dtoE.getFechaFacturacion());
                }
            }

            if( valor == ConstantesBEL.FPAGO_DURACION.charValue()) {
                //modificado por incidencia 19187
                if ( findPeriodo ) {
                    java.sql.Date fechaFinal = periodoLocal.getFechaFin();
                    java.sql.Date fechaInicial = periodoLocal.getFechainicio();
                    Long diferencia = new Long(fechaFinal.getTime() - fechaInicial.getTime());
                    Long diasDif = new Long(diferencia.longValue() / 86400000);
                    diasDif = new Long(diasDif.longValue() + 1);
                    desglose.setFechaVto(UtilidadesFecha.addDays(dtoE.getFechaFacturacion(), diasDif.intValue()));
                } else {
                    desglose.setFechaVto(dtoE.getFechaFacturacion());
                }

                    
            }
            if(valor == ConstantesBEL.FPAGO_FINAL.charValue()){
                //modificado por incidencia 19187
                if ( findPeriodo ) {
                    desglose.setFechaVto(periodoLocal.getFechaFin());
                } else {
                    desglose.setFechaVto(dtoE.getFechaFacturacion());
                }
            }
            if (desglose.getFechaVto()==null){
                desglose.setFechaVto(dtoE.getFechaFacturacion());
            }
            UtilidadesLog.debug("*** Se añade un desglose ***");
            desgloses.add(desglose);
        } //Fin del for 
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("antes de tocar la ultima cuota, tengo.....: " + mostrarArrayList(desgloses).toString());
        
        diferenciaCuotaFracLocal = (dtoE.getImporteFracLocal().doubleValue() - sumaImporteFracLocal.doubleValue()); 
        diferenciaCuotaFracDoc   = (dtoE.getImporteFracDoc().doubleValue() - sumaImporteFracDoc.doubleValue());
        
        if(log.isDebugEnabled()) { //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("diferenciaCuotaFracLocal, es: " + diferenciaCuotaFracLocal);
          UtilidadesLog.debug("diferenciaCuotaFracDoc, es: " + diferenciaCuotaFracDoc);
        }  
        
        Collections.sort(desgloses);
        desglose = (Desglose)desgloses.get(desgloses.size()-1);
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("--> luego de ir a la posicion: " + (desgloses.size()-1));
          UtilidadesLog.debug("FechaVto, es: " + desglose.getFechaVto());
          UtilidadesLog.debug("ImporteCuotaFracDoc, es: " + desglose.getImporteCuotaFracDoc());
          UtilidadesLog.debug("ImporteCuotaFracLocal, es: " + desglose.getImporteCuotaFracLocal());
          UtilidadesLog.debug("NumeroOrden, es: " + desglose.getNumeroOrden());
          UtilidadesLog.debug("MedioPago, es: " + desglose.getOidMedioPago());
        }  
        
        desglose.setImporteCuotaFracLocal(new BigDecimal( (desglose.getImporteCuotaFracLocal().doubleValue() + diferenciaCuotaFracLocal)));
        desglose.setImporteCuotaFracDoc(new BigDecimal( (desglose.getImporteCuotaFracDoc().doubleValue() + diferenciaCuotaFracDoc)));
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("ImporteCuotaFracDoc, es: " + desglose.getImporteCuotaFracDoc());
          UtilidadesLog.debug("ImporteCuotaFracLocal, es: " + desglose.getImporteCuotaFracLocal());
          UtilidadesLog.debug("luego de tocar la ultima cuota, tengo.....: " + mostrarArrayList(desgloses).toString());
        }
    
        UtilidadesLog.info("MONTratamientosContablesBean.generarApuntesFormaPago(DTOApFormPagE dtoE): Salida");
        return desgloses;
    }

    private CanalLocalHome getCanalLocalHome() throws MareException {
        return new CanalLocalHome();
    }


    /**
     * @cambio RI 20090926 Cambio en la forma de obtener y actualizar los numeros de documento legal.
     */
    public DTOFACDocumentoSubacceso activarNuevoRangoNumeracionOficial(DTOFACCabeceraSolicitud consolidado, Long tipoDocumentoLegal) throws MareException {
        UtilidadesLog.info("MONTratamientosContablesBean.activarNuevoRangoNumeracionOficial(DTOFACCabeceraSolicitud consolidado, Long tipoDocumentoLegal): Entrada");
        String usuario = ctx.getCallerPrincipal().getName();
        DAOFACDocumentoContable daoFACDocumentoContable = new DAOFACDocumentoContable(usuario);
        DTOFACDocumentoSubacceso dto = new DTOFACDocumentoSubacceso();
        try{
            RangosNumeracionOficialLocalHome rmoHome = this.getRangosNumeracionOficialLocalHome();
            RangosNumeracionOficialLocal primerRango = null;
            
            UtilidadesLog.debug("*** Se realiza el findbyUk en Rangos con pais = "+consolidado.getOidPais()+
                              ",subacceso = "+consolidado.getSubacceso()+",Sociedad = "+consolidado.getSociedad()+",tipoDocumento = "+ tipoDocumentoLegal);

            primerRango = rmoHome.findByUK(consolidado.getOidPais(), consolidado.getSubacceso(), consolidado.getSociedad(), tipoDocumentoLegal, new Long(1));
                  

                  
            UtilidadesLog.debug("*** SCS, voy a remover el rango : " + primerRango.getSerieDocumento() + " -- " + primerRango.getSubacceso() + " -- " + primerRango.getTipoDocumento());
            rmoHome.remove(primerRango);            
            
            daoFACDocumentoContable.reordenarRangos(consolidado.getOidPais(), consolidado.getSubacceso(), consolidado.getSociedad(), tipoDocumentoLegal);            // ***** Modificado por incidencia 17444
            
            primerRango = rmoHome.findByUK(consolidado.getOidPais(), consolidado.getSubacceso(), consolidado.getSociedad(), tipoDocumentoLegal, new Long(1));
            
            UtilidadesLog.debug("*** SCS, el nuevo primer rango es: " + primerRango.getSerieDocumento() + " -- " + primerRango.getSubacceso() + " -- " + primerRango.getTipoDocumento());
                  
            dto.setSerieDocumentoLegal(primerRango.getSerieDocumento());
            dto.setUltimoNumeroDocumentoLegal(new Integer(primerRango.getInicioRangoNumeracion().intValue()));
            dto.setLimiteNumeroDocumentoLegal(new Integer(primerRango.getFinRangoNumeracion().intValue()));
            
        }catch (NoResultException ex){
            UtilidadesLog.error("*** Error en activarNuevoRangoNumeracionOficial:finderException",ex);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            ctx.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }catch (PersistenceException ex){
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error en activarNuevoRangoNumeracionOficial",ex);
            String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));                 
        }
        UtilidadesLog.info("MONTratamientosContablesBean.activarNuevoRangoNumeracionOficial(DTOFACCabeceraSolicitud consolidado, Long tipoDocumentoLegal): Salida");
        return dto;
    }


    // modificado por incidencia 18507
	public void generarMensajeProductoFueraDocumento(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable) throws MareException {
		//se invoca al caso de uso "Insertar en Buzón de Mensajes" (MSG) 
		UtilidadesLog.info("MONTratamientosContablesBean.generarMensajeProductoFueraDocumento(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable): Entrada");
		// gPineda - 26/01/2007 - DBLG700000309
        if ( dtoPosicionContable.getUnidadesComprometidas() == null ||
                dtoPosicionContable.getUnidadesComprometidas().equals( new Integer(0) ) ){
                    UtilidadesLog.info("MONTratamientosContablesBean.generarMensajeProductoFueraDocumento(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable): Salida por unid compr == 0");
                    return;
                }
        
        DTOBuzonMensajes dtoMensaje = new DTOBuzonMensajes();
		
		dtoMensaje.setOidPais(dtoCabeceraContable.getOidPais());		
		dtoMensaje.setCodigoMensaje(ConstantesFAC.COD_MENSAJE_01);
		dtoMensaje.setOidCliente(dtoCabeceraContable.getOidCliente());
        //cambio por incidencia BELC300013490, se usa ConstantesSEG
        //dtoMensaje.setModuloOrigen(ConstantesFAC.MODULO_ORIGEN_FAC);
		dtoMensaje.setModuloOrigen(new Long(ConstantesSEG.MODULO_FAC)); 
		dtoMensaje.setDatoVariable1(dtoPosicionContable.getCodigoVenta());
		dtoMensaje.setDatoVariable2(dtoPosicionContable.getDescripcionSAP());
		dtoMensaje.setDatoVariable3("0");
		if(dtoPosicionContable.getUnidadesComprometidas()!=null){
			dtoMensaje.setDatoVariable4(dtoPosicionContable.getUnidadesComprometidas().toString());
		}
		
		dtoMensaje.setDatoVariable5("0");
		dtoMensaje.setDatoVariable6("0");
        // modificado por incidencia 15873
    	//dtoMensaje.setDatoVariable7(dtoPosicionContable.getTipoOferta().toString());
        dtoMensaje.setDatoVariable7(dtoPosicionContable.getCodigoTipoOferta());

		if(dtoPosicionContable.getIndicadorDentroFueraCajaBolsa()!=null){
        dtoMensaje.setDatoVariable8(dtoPosicionContable.getIndicadorDentroFueraCajaBolsa());
    }
		
        dtoMensaje.setListaConsultoras(ConstantesFAC.LISTA_CONSULTORAS_N);
		dtoMensaje.setCodigoPatron(null);
		MONGestionMensajes monGestionMensajes = this.getMONGestionMensajes();
        DTOBuzonMensajes dtoMensajeSalida = null; 
		try{
			dtoMensajeSalida = monGestionMensajes.insertaDatosMensajeBatch(dtoMensaje);			
		}
		catch (Exception ex){
			UtilidadesLog.error("*** Error en generarMensajeProductoFueraDocumento",ex);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));			
		}
        
        //- se almacena la información en la entidad MensajesFacturacion, con los datos del
        // objeto DTOBuzonMensajes creado en el punto anterior, más la fecha del sistema,
        // y un secuencial generado automáticamente. 
        if(dtoCabeceraContable.getOidCabeceraSolicitud() != null     &&
           dtoMensajeSalida.getOid() != null){  
            MensajesFacturacionLocalHome mensajesFacturacionLH = this.getMensajesFacturacionLocalHome();
            MensajesFacturacionLocal mensajesFacturacionLocal = null;
    
            try{
               // ejbCreate(Long cliente, Long numeroSecuencial, Timestamp fecha, 
                //String datoVariable1, Long modulo, Boolean listaConsultoras, Boolean borrado, 
                //String codMensaje, Long cabecera)
                Timestamp fecha = new Timestamp(dtoMensajeSalida.getFechaGrabacion().getTime());
                Long numSecuencial = dtoMensajeSalida.getNumeroSecuencial();
                UtilidadesLog.debug("*** numSecuencial = "+numSecuencial);
                Long oidBuzonMensaje = dtoMensajeSalida.getOid();
                UtilidadesLog.debug("*** oidBuzonMensaje = "+oidBuzonMensaje);
                Boolean listaConsultoras = ConstantesFAC.IND_INACTIVO;
                mensajesFacturacionLocal = mensajesFacturacionLH.create(dtoMensaje.getOidCliente(),numSecuencial,fecha, 
                                            dtoMensaje.getDatoVariable1(),dtoMensaje.getModuloOrigen(),
                                            listaConsultoras,  
                                            ConstantesFAC.IND_INACTIVO,
                                            dtoMensaje.getCodigoMensaje(),
                                            dtoCabeceraContable.getOidCabeceraSolicitud(), 
                                            oidBuzonMensaje );
                                            
                
            }catch(PersistenceException e ){
                ctx.setRollbackOnly();
                UtilidadesLog.error("*** Error en generarMensajeProductoFueraDocumento al crear MensajeFacturacion",e);
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
            }
            mensajesFacturacionLocal.setDatoVariable2(dtoMensaje.getDatoVariable2());
            mensajesFacturacionLocal.setDatoVariable3(dtoMensaje.getDatoVariable3());
            mensajesFacturacionLocal.setDatoVariable4(dtoMensaje.getDatoVariable4());
            mensajesFacturacionLocal.setDatoVariable5(dtoMensaje.getDatoVariable5());
            mensajesFacturacionLocal.setDatoVariable6(dtoMensaje.getDatoVariable6());
            mensajesFacturacionLocal.setDatoVariable7(dtoMensaje.getDatoVariable7());
            mensajesFacturacionLocal.setDatoVariable8(dtoMensaje.getDatoVariable8());
            mensajesFacturacionLH.merge(mensajesFacturacionLocal);
        }else{
            UtilidadesLog.debug("*** No se pueden generar mensajes en FAC porque no se generaron documentos Contables ***");
            UtilidadesLog.debug("*** Todas las posiciones son no imprimibles ***");            
        }
		UtilidadesLog.info("MONTratamientosContablesBean.generarMensajeProductoFueraDocumento(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable): Salida");
	}
    
    private void grabarTodosLosMensajes (ArrayList array )throws MareException{
        try{
            DTOBuzonMensajes[] dtoBuzonMensajes = new DTOBuzonMensajes[array.size()];
                for ( int x = 0 ; x < array.size() ; x++ ){
                    dtoBuzonMensajes[x] = (DTOBuzonMensajes)array.get(x);
                }
			dtoBuzonMensajes =  getMONGestionMensajesLocalHome().create().insertarDatosMensajesBatch(dtoBuzonMensajes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0 ; i < dtoBuzonMensajes.length ; i++){
                if (dtoBuzonMensajes[i].getOidCabeceraSolicitudTemp()!=null && dtoBuzonMensajes[i].getOid()!=null){
                    sb.append(generaInsertMensajeFacturacion(dtoBuzonMensajes[i]));
                }
            }            
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());            
		}
		catch (Exception ex){
			UtilidadesLog.error("*** Error en generarMensajeProductoFueraDocumento",ex);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));			
		}
    }
    
    private StringBuffer generaInsertMensajeFacturacion (DTOBuzonMensajes dto){
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO fac_mensa_factu ");
        sb.append(" (oid_mens_fact, clie_oid_clie, val_nume_secu, ");
        sb.append(" fec_mens_fact, ");
        sb.append(" val_dato_var1, val_dato_var2, val_dato_var3, val_dato_var4, ");
        sb.append(" val_dato_var5, val_dato_var6, val_dato_var7, val_dato_var8, ");
        sb.append(" modu_oid_modu, ind_list_cons, ind_borr, cod_mens, dcca_oid_cabe, ");
        sb.append(" perd_oid_peri, ind_perm_mens, val_buzo_mens ");
        sb.append(" ) ");
        sb.append(" VALUES (FAC_MEFA_SEQ.nextval ");
        sb.append(" ,"+dto.getOidCliente());
        sb.append(" ,"+dto.getNumeroSecuencial());
        sb.append(" ,sysdate");
        sb.append(" ,'"+ajustarVariable(dto.getDatoVariable1()));
        sb.append("' ,'"+ajustarVariable(dto.getDatoVariable2()));
        sb.append("' ,'"+ajustarVariable(dto.getDatoVariable3()));
        sb.append("' ,'"+ajustarVariable(dto.getDatoVariable4()));
        sb.append("' ,'"+ajustarVariable(dto.getDatoVariable5()));
        sb.append("' ,'"+ajustarVariable(dto.getDatoVariable6()));
        sb.append("' ,'"+ajustarVariable(dto.getDatoVariable7()));
        sb.append("' ,'"+ajustarVariable(dto.getDatoVariable8()));
        sb.append("' ,"+dto.getModuloOrigen());        
        sb.append(" ,0");//sb.append(" ,"+ConstantesFAC.IND_INACTIVO);
        sb.append(" ,0");//sb.append(" ,"+ConstantesFAC.IND_INACTIVO);
        sb.append(" ,'"+dto.getCodigoMensaje());
        sb.append("' ,"+dto.getOidCabeceraSolicitudTemp());
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" ,"+dto.getOid());
        sb.append(" );");
        return sb;
    }
    
    private String ajustarVariable(String dato){
        return dato.replaceAll("'","''");
    }
    
    private DTOBuzonMensajes generarDTOMensaje(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable) throws MareException {
		//se invoca al caso de uso "Insertar en Buzón de Mensajes" (MSG) 
		UtilidadesLog.info("MONTratamientosContablesBean.generarDTOMensaje(DTOFACCabeceraDocContable dtoCabeceraContable, DTOFACPosicionDocContable dtoPosicionContable): Entrada");
		DTOBuzonMensajes dtoMensaje = new DTOBuzonMensajes();
		
		dtoMensaje.setOidPais(dtoCabeceraContable.getOidPais());		
		dtoMensaje.setCodigoMensaje(ConstantesFAC.COD_MENSAJE_01);
		dtoMensaje.setOidCliente(dtoCabeceraContable.getOidCliente());
        //cambio por incidencia BELC300013490, se usa ConstantesSEG
        //dtoMensaje.setModuloOrigen(ConstantesFAC.MODULO_ORIGEN_FAC);
		dtoMensaje.setModuloOrigen(new Long(ConstantesSEG.MODULO_FAC)); 
		dtoMensaje.setDatoVariable1(dtoPosicionContable.getCodigoVenta());
		dtoMensaje.setDatoVariable2(dtoPosicionContable.getDescripcionSAP());
		dtoMensaje.setDatoVariable3("0");
		if(dtoPosicionContable.getUnidadesComprometidas()!=null){
			dtoMensaje.setDatoVariable4(dtoPosicionContable.getUnidadesComprometidas().toString());
		}
		
		dtoMensaje.setDatoVariable5("0");
		dtoMensaje.setDatoVariable6("0");
        // modificado por incidencia 15873
    	//dtoMensaje.setDatoVariable7(dtoPosicionContable.getTipoOferta().toString());
        dtoMensaje.setDatoVariable7(dtoPosicionContable.getCodigoTipoOferta());
        
        dtoMensaje.setOidCabeceraSolicitudTemp(dtoCabeceraContable.getOidCabeceraSolicitud());

		if(dtoPosicionContable.getIndicadorDentroFueraCajaBolsa()!=null){
            dtoMensaje.setDatoVariable8(dtoPosicionContable.getIndicadorDentroFueraCajaBolsa());
        }
		
        dtoMensaje.setListaConsultoras(ConstantesFAC.LISTA_CONSULTORAS_N);
		dtoMensaje.setCodigoPatron(null);
        return dtoMensaje;
	}

    //@ssaavedr 29/06/2006 - optimizacion
    public void generarRegistroUnicoVenta(DTOFACConsolidado dtoConsolidado) throws MareException {
        UtilidadesLog.info("MONTratamientosContablesBean.generarRegistroUnicoVenta(DTOFACConsolidado dtoConsolidado): Entrada");
        String usuario = ctx.getCallerPrincipal().getName();
        // Se obtienen de BD los documentos contables del consolidado 
        DAOFACDocumentoContable daoFACDocumentoContable = new DAOFACDocumentoContable(usuario);
        ArrayList listaDocumentosContables = null;
        BelcorpService bs;
        
        DTOOIDs dtoOIDs = new DTOOIDs();
        Long[] oids = new Long[1];
        oids[0] = dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud();
        dtoOIDs.setOids(oids);
        listaDocumentosContables = daoFACDocumentoContable.obtenerDocumentosConsolidado(dtoOIDs);
        DTOFACCabeceraDocContable dtoDocContable = new DTOFACCabeceraDocContable();
        ArrayList listaAcumuladoImpuestos = new ArrayList();
        Iterator iteradorLista = listaDocumentosContables.iterator();
        
        StringBuffer strInsercion = new StringBuffer();
        
        while (iteradorLista.hasNext()){
            dtoDocContable = (DTOFACCabeceraDocContable)iteradorLista.next();

            listaAcumuladoImpuestos = daoFACDocumentoContable.obtenerAcumuladoImpuestos(dtoDocContable);
            // Se genera un registro único de ventas por cada registro de impuestos acumulados obtenido 
            DTOFACAcumuladoImpuestos dtoAcumulado = null;
            Iterator iteradorImp = listaAcumuladoImpuestos.iterator();
            while (iteradorImp.hasNext()){ 
                dtoAcumulado = (DTOFACAcumuladoImpuestos)iteradorImp.next(); 
                Long numeroDocumentoRef=null;
                if (dtoDocContable.getNumeroDocumentoReferencia()!=null) {
                  numeroDocumentoRef = new Long(dtoDocContable.getNumeroDocumentoReferencia().longValue());
                }
                
                try {
                  strInsercion.append(this.genLineInsert(dtoDocContable, dtoAcumulado, numeroDocumentoRef));
                } catch (CreateException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("*** Error en generarRegistroUnicoVenta (creando lineas de insercion)",e);
                  String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                  throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
                } catch (Exception e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("*** Error en generarRegistroUnicoVenta (creando lineas de insercion)",e);
                  String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                  throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
                }
            }         
        }
                                                                                                                    
        try {                                     
            bs = BelcorpService.getInstance();
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", strInsercion.toString());
        } catch (MareMiiServiceNotFoundException e) {                                                               
            throw new EJBException(e);                                                                              
        } catch (Exception e) {                                                                                     
            throw new EJBException(e);                                                                              
        }                                                                                                           
        
        
        UtilidadesLog.info("MONTratamientosContablesBean.generarRegistroUnicoVenta(DTOFACConsolidado dtoConsolidado): Salida");
    }
    
    /**
     * 01-10-2007       modificado por Sapaza, cambio 20070425.Se requiere que al generar el registro único de venta se grabe 
     *                  el importe de descuento, la base imponible y base imponible neta.     
     * 15-10-2007       modificado por Sapaza, incidencia 20070477. Se requiere grabar el número contable interno.
     * @throws java.lang.Exception
     * @return 
     * @param numeroDocumentoRef
     * @param dtoAcumulado
     * @param dtoContable
     */
    private StringBuffer genLineInsert(DTOFACCabeceraDocContable dtoContable, DTOFACAcumuladoImpuestos dtoAcumulado, Long numeroDocumentoRef) throws Exception{
        StringBuffer query  = new StringBuffer( 
        "INSERT INTO FAC_REGIS_UNICO_VENTA (" +
        " OID_REGI, " +
        " PAIS_OID_PAIS, " +
        " SOCI_OID_SOCI, " );
      
        // Cambiado por incidencia 8146        
        if (dtoContable.getSubacceso()!= null){
            query.append(" SBAC_OID_SBAC , ");       
        }
      
        query.append(" FEC_EMIS, " +
        " VAL_BASE_IMPO, " +
        " IMP_IMPU, " +
        " IMP_TOTA, " +
        " VAL_NUME_IDEN_FISC, " +
      
        " VAL_NOM1, " +
        " VAL_NOM2, " +
        " VAL_APE1, " +
        " VAL_APE2, " +
        " CLIE_OID_CLIE, " +
        " IND_TRAN_GRAT, " +
      
        " TAIM_OID_TASA_IMPU, " + //  incidencia	7618
        " TIDO_OID_TIPO_DOCU " );

        if(dtoContable.getNumeroDocumentoLegal() != null){
            query.append(" , VAL_NUME_DOCU_LEGA ");
        }
        
        if(dtoContable.getSerieDocumentoLegal() != null){
            query.append(" , VAL_SERI_DOCU_LEGA ");
        }
                              
        if(dtoContable.getEjercicioDocumentoContableInterno() != null){
          query.append(" , VAL_EJER_DOCU_INTE ");
        }
        if(dtoContable.getPuntoEmision() != null){
          query.append(" , VAL_PUNT_EMIS ");
          
        }
        if(dtoContable.getNumeroDocumentoInterno() != null){
          query.append(" , VAL_DOCU_INTE ");				
          query.append(" , NUM_DOCU_CONT_INTE ");
        }
        if(dtoContable.getNumeroIdentificacionNacional() != null){
          query.append(" , VAL_NUME_IDEN_NNAL ");
        }
        if(numeroDocumentoRef != null){
          query.append(" , VAL_NUME_DOCU_REFE ");
        }
        if(dtoContable.getOidCabeceraSolicitud() != null){
          query.append(" , DCCA_OID_CABE ");
        }
        if(dtoContable.getOidDocumentoReferencia() != null){
          query.append(" , TIDO_TIPO_DOCU_REFE ");
        }
        
        query.append(" , VAL_BASE_IMPO_NETO ");
        
        query.append(" , VAL_DESC ");

        query.append(" , IND_ESTA ");
                            
        query.append(" , VAL_INDI_RUV ");
                              
        query.append(") VALUES (");
        
        query.append("FAC_RUVE_SEQ.nextval, " + dtoContable.getOidPais() + ", " + dtoContable.getSociedad());
        
        if (dtoContable.getSubacceso()!= null){
            query.append(" ," + dtoContable.getSubacceso());       
        }
        
        query.append(" , TO_DATE('" + convertirFecha2(new java.sql.Date(dtoContable.getFechaFacturacion().getTime())) + "','DD-MM-YYYY'), " + 
                     new BigDecimal(String.valueOf(dtoContable.getPrecioCatalogoSinImpuestoTotalLocal().floatValue() +
                                    dtoContable.getPrecioContableSinImpuestosTotalDocumento().floatValue() +
                                    dtoContable.getImporteFleteSinImpuestosTotalDocumento().floatValue())) + ", " + 
                     new BigDecimal(dtoAcumulado.getTotalImpuestosLocal().toString()) + ", " + 
                     new BigDecimal(dtoAcumulado.getTotalImporteLocal().toString()) + ", '" +
                     dtoContable.getNumeroIdentificacionFiscal() + "', ");
                     if (dtoContable.getNombre1() != null) {
                       query.append("'"+ dtoContable.getNombre1().replaceAll("'","''")   + "', ");
                     } else {
                       query.append("'',");
                     }
                     if (dtoContable.getNombre2() != null) {
                        query.append("'"+ dtoContable.getNombre2().replaceAll("'","''")   + "', ");
                     } else {
                       query.append("'',");
                     }
                     if (dtoContable.getApellido1() != null) {
                        query.append("'"+ dtoContable.getApellido1().replaceAll("'","''")   + "', ");
                     } else {
                       query.append("'',");
                     }
                     if (dtoContable.getApellido2() != null) {
                        query.append("'"+ dtoContable.getApellido2().replaceAll("'","''")   + "', ");
                     } else {
                       query.append("'',");
                     }
                     query.append(dtoContable.getOidCliente() + ", ");
                     
                     /* Agregado por Cambio FAC-003 ------ AL */
                     if (dtoContable.getOidTipoConcursoPrograma() != null) {
                       query.append(new Long(1) + ", ");
                     } else {
                       query.append(new Long(0) + ", ");
                     } 
                     /* Agregado por Cambio FAC-003 ------ AL */
                     /* Eliminado por Cambio FAC-003 ------ AL
                     query.append(new Long(0) + ", ");
                     Eliminado por Cambio FAC-003 ------ AL */
                     query.append(dtoAcumulado.getOidIndicadorImpuesto() + ", " + dtoContable.getTipoDocumentoLegal());                   

        if(dtoContable.getNumeroDocumentoLegal() != null){
            query.append(" ," + new Long(dtoContable.getNumeroDocumentoLegal().longValue()));
        }
        
        if(dtoContable.getSerieDocumentoLegal() != null){
            query.append(" ,'" + dtoContable.getSerieDocumentoLegal() + "'");
        }

                     
        if(dtoContable.getEjercicioDocumentoContableInterno() != null){
          query.append(" ," + dtoContable.getEjercicioDocumentoContableInterno());
        }
        if(dtoContable.getPuntoEmision() != null){
          query.append(" ,'" + dtoContable.getPuntoEmision() + "'");
        }
        if(dtoContable.getNumeroDocumentoInterno() != null){
          query.append(" ," + new Long(dtoContable.getNumeroDocumentoInterno().longValue()));
          query.append(" ,'" + dtoContable.getNumeroDocumentoInterno().toString() + "'");
        }
        if(dtoContable.getNumeroIdentificacionNacional() != null){
          query.append(" ,'" + dtoContable.getNumeroIdentificacionNacional() +"'"); // Modificado por HRCS (Fecha 10/01/2007)
        }
        if(numeroDocumentoRef != null){
          query.append(" ," + numeroDocumentoRef);
        }
        if(dtoContable.getOidCabeceraSolicitud() != null){
          query.append(" ," + dtoContable.getOidCabeceraSolicitud());
        }
        if(dtoContable.getOidDocumentoReferencia() != null){
          query.append(" ," + dtoContable.getOidDocumentoReferencia());
        }
        query.append(" ," + new BigDecimal(dtoContable.getPrecioNetoTotalLocal().toString()));
        if (dtoContable.getImporteRedondeoLocal() == null) {
            dtoContable.setImporteRedondeoLocal(new Float(0));
        }
        query.append(" ," + new BigDecimal(String.valueOf(dtoContable.getImporteDescuento1SinImpuestoTotalDocumento().floatValue()+
                            dtoContable.getPrecioContableSinImpuestosTotalDocumento().floatValue() + dtoContable.getImporteRedondeoLocal().floatValue())));

        //query.append(" ," + new Boolean(false));
        query.append(" ," + new Long(0));
                            
        query.append(" ,'" + ConstantesFAC.ESTADO_RUV_ACTIVO + "'");                     
        
        query.append(" );");                     
        
        return query;
    }
    
	  private String convertirFecha2(Date fecha) {
    		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    		java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
    		String sFechaDesde = sdf.format(fechaDesde);                                                          
        return sFechaDesde;
	  }
  
    private void insertarRegistroUnicoVenta(Long pais, Long sociedadVenta, Long subacceso, String ejercicioDocumentoInterno, Date fechaEmision, BigDecimal baseImponible,
                                            BigDecimal importeImpuesto, BigDecimal importeTotal, String puntoEmision, Long documentoInterno, String numeroIdentificacionFiscal,
                                            String numeroIdentificacionNacional, String serieDocumentoReferencia, Long numeroDocumentoReferencia, String nombre1,  String nombre2,
                                            String apellido1, String apellido2, Long cliente, Boolean transferenciaGratuita, Long cabDocContable, Long impuesto, Long tipoDocumentoLegal,
                                            Long numeroDocumentoLegal, String serieDocumentoLegal, Long tipoDocumentoReferencia,  BigDecimal interesesMora, BigDecimal descuento, BigDecimal comisiones, 
                                            BigDecimal flete, BigDecimal baseImponibleNeto, Boolean estado, Boolean facturaGratuita, Date fechaCierre, String estadoRUV, String documentoInternoHipersale ) throws Exception{
        Vector vector = new Vector();
        StringBuffer query  = new StringBuffer( "INSERT INTO FAC_REGIS_UNICO_VENTA (" +
						" OID_REGI, " +
						" PAIS_OID_PAIS, " +
						" SOCI_OID_SOCI, " );
						// Cambiado por incidencia 8146
						if(subacceso != null){
							query.append(" SBAC_OID_SBAC , ");
						}
						
						//" VAL_EJER_DOCU_INTE, " +
						//" NUM_DOCU_CONT_INTE, " +
						query.append(" FEC_EMIS, " +
						" VAL_BASE_IMPO, " +
						" IMP_IMPU, " +
						" IMP_TOTA, " +
						//" VAL_PUNT_EMIS, " +
						//" VAL_DOCU_INTE, " +
						" VAL_NUME_IDEN_FISC, " +
						//" VAL_NUME_IDEN_NNAL, " +
						//" VAL_SERI_DOCU_REFE, " +
						//" VAL_NUME_DOCU_REFE, " +
						" VAL_NOM1, " +
						" VAL_NOM2, " +
						" VAL_APE1, " +
						" VAL_APE2, " +
						" CLIE_OID_CLIE, " +
						" IND_TRAN_GRAT, " +
						//" DCCA_OID_CABE, " +
						" TAIM_OID_TASA_IMPU, " + //  incidencia	7618
						" TIDO_OID_TIPO_DOCU, " +
						" VAL_NUME_DOCU_LEGA, " +
						" VAL_SERI_DOCU_LEGA  ");
						
        vector.add(SecuenciadorOID.obtenerSiguienteValor("FAC_RUVE_SEQ"));
        vector.add(pais);
        vector.add(sociedadVenta);
        if(subacceso != null){
          vector.add(subacceso);
        }
        //vector.add(this.getEjercicioDocumentoInterno());
        //vector.add(this.getTipoDocumentoContable());
        vector.add(fechaEmision);
        vector.add(baseImponible);
        vector.add(importeImpuesto);
        vector.add(importeTotal);
        vector.add(numeroIdentificacionFiscal);
        vector.add(nombre1);
        vector.add(nombre2);
        vector.add(apellido1);
        vector.add(apellido2);
        vector.add(cliente);
        vector.add(transferenciaGratuita);
        //vector.add(this.getCabDocContable());
        vector.add(impuesto);
        vector.add(tipoDocumentoLegal);
        vector.add(numeroDocumentoLegal);
        vector.add(serieDocumentoLegal);
    
        if(ejercicioDocumentoInterno != null){
          query.append(" , VAL_EJER_DOCU_INTE ");
          vector.add(ejercicioDocumentoInterno);
        }
        if(documentoInternoHipersale != null){
          query.append(" , NUM_DOCU_CONT_INTE "); 
          vector.add(documentoInternoHipersale);
        }
        if(puntoEmision != null){
          query.append(" , VAL_PUNT_EMIS ");
          vector.add(puntoEmision);
        }
        if(documentoInterno != null){
          query.append(" , VAL_DOCU_INTE ");				
          vector.add(documentoInterno);
        }
        if(numeroIdentificacionNacional != null){
          query.append(" , VAL_NUME_IDEN_NNAL ");
          vector.add(numeroIdentificacionNacional);
        }
        if(serieDocumentoReferencia != null){
          query.append(" , VAL_SERI_DOCU_REFE ");
          vector.add(serieDocumentoReferencia);
        }
        if(numeroDocumentoReferencia != null){
          query.append(" , VAL_NUME_DOCU_REFE ");
          vector.add(numeroDocumentoReferencia);
        }
        if(cabDocContable != null){
          query.append(" , DCCA_OID_CABE ");
          vector.add(cabDocContable);
        }
        if(tipoDocumentoReferencia != null){
          query.append(" , TIDO_TIPO_DOCU_REFE ");
          vector.add(tipoDocumentoReferencia);
        }
        if(interesesMora != null){
          query.append(" , VAL_INTE_MORA ");
          vector.add(interesesMora);
        }
        if(descuento != null){
          query.append(" , VAL_DESC ");
          vector.add(descuento);
        }
        if(comisiones != null){
          query.append(" , VAL_COMI ");
          vector.add(comisiones);
        }
        if(flete != null){
          query.append(" , VAL_FLET ");
          vector.add(flete);
        }
        if(baseImponibleNeto != null){
          query.append(" , VAL_BASE_IMPO_NETO ");
          vector.add(baseImponibleNeto);
        }else{
          query.append(" , VAL_BASE_IMPO_NETO ");
          vector.add(new Long(0));
        }
        if(estado != null){
          query.append(" , IND_ESTA ");
          vector.add(estado);
        }
        if(facturaGratuita != null){
          query.append(" , IND_FACT_GRAT ");
          vector.add(facturaGratuita);
        }
        if(fechaCierre != null){
          query.append(" , FEC_CIER ");
          vector.add(fechaCierre);
        }
        if(estadoRUV != null){
          query.append(" , VAL_INDI_RUV ");
          vector.add(estadoRUV);
        }
        
        query.append(") VALUES (?");
        for (int i = 1; i < vector.size(); i++){
            query.append(", ?");
        }
        query.append(")");
                  
        try {
            this.ejecutaSentencia(query.toString(), vector);
        } catch (EJBException ejbe) {
            String falloSQL = (ejbe.getCausedByException()).getMessage();
            if (falloSQL.indexOf("ORA-00001") != -1)
                throw new DuplicateKeyException();
            else if (falloSQL.indexOf("ORA-02291") != -1)
                throw new CreateException();
            else
              throw ejbe;
        }
    }
    
    private int ejecutaSentencia(String query, Vector argumentos) throws EJBException {                                                                           
	                                                                                                             
        BelcorpService bs;                                                                                          
                                                                                                                    
        try {                                                                                                       
            bs = BelcorpService.getInstance();                                                                      
        } catch (MareMiiServiceNotFoundException e) {                                                               
            throw new EJBException(e);                                                                              
        }                                                                                                           
        try {                                                                                                       
            loguearSql("**** BMP  RegistroUnicoVentas: ", query, argumentos);		                        
            return bs.dbService.executePreparedUpdate(query, argumentos);                                           
        } catch (Exception e) {                                                                                     
            throw new EJBException(e);                                                                              
        }                                                                                                           
	}   
  
    private void loguearSql(String metodo, String sql, Vector params) {                                             
                                                                                                                
        UtilidadesLog.info(metodo + sql);                                                                           
                                                                                                                    
        if (params != null && params.size() > 0) {                                                                  
            String sParams = "";                                                                                    
            for (int i=0; i<params.size(); i++) {                                                                   
                if (params.elementAt(i) != null)                                                                    
                    sParams += "param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";                   
                else                                                                                                
                    sParams += "param "+ (i+1) + ": es nulo, ";                                                     
            }                                                                                                       
            UtilidadesLog.info(metodo + sParams);                                                                   
        }		                                                                                                    
	}	


    
        /**
         * CHANGELOG
         * ---------
         * 02/06/2009 - dmorello, Cambio 20090923
         *    - El documento tendra la misma direccion que el consolidado, no la principal del cliente
         * 06/07/2009 - dmorello, Cambio 20090908
         *    - La clave de busqueda en hashTiposDocumento pasa a ser "clave-oidTipoPrograma-oidDocumLegalRef"
         *    - Se modifica llamada a actualizarNumeroDocumentoLegal agregando param oidDocumLegalRef
         * 08/07/2009 - dmorello, Cambio 20090923
         *    - Se busca la info de la direccion en BD y no entre las direcciones recuperadas junto con la info del cliente
         */
	public void grabarDocumentoContable(DTOFACConsolidado dtoConsolidado) throws MareException {
        UtilidadesLog.info("MONTratamientosContablesBean.grabarDocumentoContable(DTOFACConsolidado dtoConsolidado): Entrada");
        Long oidCabeceraDocumentoLegal;
        BelcorpService bs = null;
        hashCatalogos = new Hashtable();
        
	// sapaza -- PER-SiCC-2011-0053 -- 20/01/2011
        
        //SB PER-SiCC-2012-0266 03/04/2012
        //Long suma = getNumUnidadCompra(dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud());//SI ES NULO DEVUELVE CERO
        //if(suma == 0) {        
         if(dtoConsolidado.getDtoCabecera().getNumeroUnidadesAtendidasTotal().longValue() == 0) {
            UtilidadesLog.debug("getNumeroUnidadesAtendidasTotal es cero");
            UtilidadesLog.info("MONTratamientosContablesBean.grabarDocumentoContable(DTOFACConsolidado dtoConsolidado): Salida");
            return;
        }
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw e;
        }
		try{
            //UtilidadesLog.debug("DTOConsolidado que le llega al metodo = " + dtoConsolidado);
            String usuario = ctx.getCallerPrincipal().getName();
            DTOFACCabeceraSolicitud consolidado = null;
            consolidado = dtoConsolidado.getDtoCabecera();
            
            Long oidIdioma = ConstantesSEG.IDIOMA_DEFECTO;
            Long oidPais = consolidado.getOidPais();
            Boolean indicadorImpuestosIncluidos = this.obtenerIndicadorImpuestoIncluidos(oidPais);
            
            ArrayList listaSolicitudes = null;
            ArrayList listaPosiciones = null;
            
            listaSolicitudes = dtoConsolidado.getListaSolicitudes();
            listaPosiciones = dtoConsolidado.getListaPosiciones();
            
            String descTipoVia=null; //añadido por incidencia 21005
            String dirCompleta="";
            ArrayList listaPosicionesDocumentoContable = new ArrayList();
            Float sumaTotalAPagarLocal = new Float("0");
            Float sumaTotalAPagarDocumento = new Float("0");
            Float tempSumaTotalAPagarLocal = new Float("0");
            Float tempSumaTotalAPagarDocumento = new Float("0");
            Integer numeroFacturasGeneradas = new Integer("0");
            //se accede a la entidad 'ParametrosFacturacion' por el pais activo, 
            //para recuperar el atributo 'esDocumentoMonopagina', y se guarda en una variable
            Integer numeroPaginas = new Integer("0");
            
            ParametrosFacturacionLocal parametrosFacturacionLocal= null;
            ParametrosFacturacionLocalHome parametrosFacturacionLocalHome = this.getParametrosFacturacionLocalHome();
            try{
                Collection colParametrosFacturacion = parametrosFacturacionLocalHome.findByPais(consolidado.getOidPais());
                if (colParametrosFacturacion.size() == 0) {
                    UtilidadesLog.error("*** Error en grabarDocumentoContable: No se obtienen parametros de facturacion ***");
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
                }
                Iterator itParametrosFacturacion = colParametrosFacturacion.iterator();
                parametrosFacturacionLocal = (ParametrosFacturacionLocal)itParametrosFacturacion.next();
                if (parametrosFacturacionLocal.getEsDocumentoMonopagina().longValue() == 1 ) {
                    this.esDocumentoMonopagina = Boolean.TRUE;
                } else {
                    this.esDocumentoMonopagina = Boolean.FALSE;
                }
                UtilidadesLog.debug("esDocumentoMonopagina " + esDocumentoMonopagina);
            }catch (NoResultException ex){
                UtilidadesLog.error("*** Error en grabarDocumentoContable: finderException",ex);
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
            }
            // Se obtienen los tipos de documento legal del consolidado:
            this.hashTiposDocumento = this.recuperarTiposDocumento(dtoConsolidado);
        
            UtilidadesLog.debug("*** Comienza la obtencion de datos de clientes ***");       
            DAOMAEMaestroClientes daoMAEMaestroClientes = new DAOMAEMaestroClientes(usuario);
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(consolidado.getReceptorFactura());
            dtoOid.setOidPais(oidPais);
            dtoOid.setOidIdioma(oidIdioma);
            DTOCliente dtoCliente = daoMAEMaestroClientes.obtenerClienteBatch(dtoOid);
        
            String nombre1 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getNombre1();
            String nombre2 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getNombre2();
            String apellido1 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getApellido1();
            String apellido2 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getApellido2();
        
            // Cambio 20090923 - dmorello, 08/07/2009 - Busco la info de la direccion del consolidado
            Long oidDireccionConsolidado = dtoConsolidado.getDtoCabecera().getOidDireccionCliente();
            DTODireccion direccion = daoMAEMaestroClientes.obtenerDireccionPorOID(oidDireccionConsolidado);
            
            TipoViaLocalHome tipoVia = this.getTipoViaLocalHome();
            TipoViaLocal tipoViaLocal=null;
            try {
              tipoViaLocal = tipoVia.findByPrimaryKey(direccion.getTipoVia());
              descTipoVia = tipoViaLocal.getDescAbreTipoVia();
            } catch (NoResultException ex){
              UtilidadesLog.error("*** Error en grabarDocumentoContable: NoResultException",ex);
              String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
              throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
            } catch (PersistenceException ex) {
                UtilidadesLog.error("*** Error en grabarDocumentoContable: PersistenceException",ex);
                String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
            }
            // Fin cambio 20090923 - dmorello, 08/07/2009

            DTOIdentificacion listaIdentificaciones []  = null;
            listaIdentificaciones = ((DTOCrearClienteBasico)dtoCliente.getBase()).getIdentificaciones();
            ArrayList temp = new ArrayList();
            for (int i=0; i<listaIdentificaciones.length; i++) {
                 temp.add(listaIdentificaciones[i]);
            }
            Iterator iteratorListaID = temp.iterator();
            DTOIdentificacion identificacion = null;
            String numeroIdentificacionNacional = null;
            String numeroIdentificacionFiscal = null;
            while (iteratorListaID.hasNext()) {
                identificacion = (DTOIdentificacion)iteratorListaID.next();
                TipoDocumentoLocal tipoDocumentoLocal = null;
                TipoDocumentoLocalHome tipoDocumentoLocalHome = this.getTipoDocumentoLocalHome();
                try {
                    tipoDocumentoLocal = tipoDocumentoLocalHome.findByPrimaryKey(
                    identificacion.getTipoDocumento());
                } catch (NoResultException ex){
                    UtilidadesLog.error("*** Error en grabarDocumentoContable: finderException",ex);
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                } //incidencia 9018
                if (tipoDocumentoLocal.getInd_dni() != null) {
                    if (tipoDocumentoLocal.getInd_dni().longValue()==1) {
                        UtilidadesLog.debug("Entra identificacion nacional");
                        numeroIdentificacionNacional = identificacion.getNumeroDocumento();
                        UtilidadesLog.debug("numeroIdentificacionNacional: "+numeroIdentificacionNacional);
                    }
                }
                
                if (tipoDocumentoLocal.getInd_doc_iden_fisc() != null ) {
                    if (tipoDocumentoLocal.getInd_doc_iden_fisc().longValue()==1) {
                        numeroIdentificacionFiscal = identificacion.getNumeroDocumento();
                        UtilidadesLog.debug("numeroIdentificacionFiscal: "+numeroIdentificacionFiscal);
                    }
                }
               //INC DBLG700000130 (Gacevedo)
               //Si tenemos documento principal, terminamos el bucle,
               //ya que es el que debemos usar
                if(identificacion.getEsPrincipal().booleanValue()){
                   break;
                }
            }
            if (numeroIdentificacionFiscal == null) {
               ctx.setRollbackOnly();
               String strError = "--> No se ha encontrado el numeroIdentificacionFiscal para el cliente = " + consolidado.getReceptorFactura();
               UtilidadesLog.error(strError);
               LogAPP.info(strError); 
               throw new MareException(strError);                
            }

            UtilidadesLog.debug("*** Despues de obtener datos de clientes ***");
            
            ArrayList listaPosicionesDoc = null;
            ArrayList listaPosicionesDocOrden = null;
            ArrayList lineasDocumentosContableGrabar = new ArrayList();
            DTOFACDocumentoSubacceso dtoDatos = null;
            DTOFACCabeceraDocContable dtoDocContableTemp  = new DTOFACCabeceraDocContable();
            numeroFacturasGeneradas = new Integer("0");
            ArrayList listaPosicionesDocContable = new ArrayList();
             Boolean indFlete = new Boolean(true);
            Iterator itTiposDocumento = (Iterator)((Collection)this.hashTiposDocumento.values()).iterator();      
            while (itTiposDocumento.hasNext()) {//1
                
                DatosTipoDocumento datos = (DatosTipoDocumento)itTiposDocumento.next();
                listaPosicionesDoc = datos.getListaPosiciones();       
                listaPosicionesDocOrden = this.ordenarListaPosicionesDoc(listaPosicionesDoc);        
                datos.setListaPosiciones(listaPosicionesDocOrden);
                numeroPaginas = new Integer("0");
                Long oidConcursoSolicitud = null;

                Iterator listaTempIterator = listaPosicionesDocOrden.iterator();
                UtilidadesLog.debug("Se inserta la cabecera de documento contable.");
                MONTratamientosContables monT =  getMONTratamientosContablesHome().create();
                while (listaTempIterator.hasNext()) {//2
                    numeroFacturasGeneradas = new Integer(numeroFacturasGeneradas.intValue() + 1);
                    UtilidadesLog.debug("numeroFacturasGeneradas = "+ numeroFacturasGeneradas);
                    // Obtencion de los datos del documento contable que no procesan las solicitudes
                    this.hashTiposDocumento = monT.actualizarNumeroDocumentoLegal(consolidado, hashTiposDocumento, datos.getOidTipoDocumento(), datos.getOidTipoConcursoPrograma(), datos.getOidDocumentoLegalReferencia());
                    // Se crea la cabecera del documento contable en BD, haciendo uso del entity "CabeceraDocumentoContable", 
                    // Se asignan los siguientes valores a dtoDocContableTemp
                    UtilidadesLog.debug("*** Asignaciones ***");		
                    dtoDocContableTemp.setOidCliente(consolidado.getReceptorFactura());
                    dtoDocContableTemp.setNumeroDecimalesRedondeo(consolidado.getNumeroDecimalesRedondeo());
                    dtoDocContableTemp.setOidCabeceraSolicitud(consolidado.getOidCabeceraSolicitud());                     
                    dtoDocContableTemp.setOidPais(consolidado.getOidPais());
                    dtoDocContableTemp.setSubgerencia(consolidado.getOidSubgVentas());
                    dtoDocContableTemp.setRegion(consolidado.getRegion());
                    dtoDocContableTemp.setSeccion(consolidado.getSeccion());
                    dtoDocContableTemp.setZona(consolidado.getZona());
                    dtoDocContableTemp.setTerritorio(consolidado.getTerritorio());
                    dtoDocContableTemp.setNombre1(nombre1);
                    dtoDocContableTemp.setNombre2(nombre2);
                    dtoDocContableTemp.setApellido1(apellido1);
                    dtoDocContableTemp.setApellido2(apellido2);
                    dtoDocContableTemp.setOidClienteDireccion(direccion.getOid());
                    dtoDocContableTemp.setSubacceso(consolidado.getSubacceso());
                    dtoDocContableTemp.setEstado(new Long("1"));
                    dtoDocContableTemp.setMarca(consolidado.getMarca());
                    dtoDocContableTemp.setPeriodo(consolidado.getPeriodo());
                    dtoDocContableTemp.setFechaEmision(new Date(System.currentTimeMillis()));            
                    dtoDocContableTemp.setPuntoEmision(consolidado.getPuntoEmision());
                    dtoDocContableTemp.setFechaFacturacion(consolidado.getFechaFacturacion());
                    dtoDocContableTemp.setOidFormulario(datos.getOidFormulario());
                    dtoDocContableTemp.setTipoDocumento(datos.getOidTipoDocumento());
                    
                    String hashKey = datos.getOidTipoDocumento() + "-" + datos.getOidTipoConcursoPrograma() + "-" + datos.getOidDocumentoLegalReferencia();
                    DatosTipoDocumento dtd = (DatosTipoDocumento)this.hashTiposDocumento.get(hashKey);
                    
                    dtoDocContableTemp.setSerieDocumentoLegal(dtd.getSerieDocumentoLegal());
                    dtoDocContableTemp.setNumeroDocumentoLegal(dtd.getNumeroDocumentoLegal());
                    dtoDocContableTemp.setEjercicioDocumentoContableInterno(dtd.getEjercicioDocumentoInterno().toString());
                    dtoDocContableTemp.setNumeroDocumentoInterno(dtd.getNumeroDocumentoInterno());
                    dtoDocContableTemp.setNumeroDocumentoReferencia(consolidado.getNumeroDocumentoReferencia());
                    dtoDocContableTemp.setNumeroIdentificacionFiscal(numeroIdentificacionFiscal);
                    dtoDocContableTemp.setNumeroIdentificacionNacional(numeroIdentificacionNacional);
                    dtoDocContableTemp.setNumeroAbono(null);
                    dtoDocContableTemp.setNumeroDocumentoOrigen(consolidado.getNumeroDocumentoOrigen());
                    // Modificado por SICC20070410 - Rafael Romero - 11/09/2007
                    //dtoDocContableTemp.setObservaciones(consolidado.getObservaciones());
                    dtoDocContableTemp.setObservaciones(datos.getObservaciones());
                    // Fin modificado SICC20070410
                    dtoDocContableTemp.setSociedad(consolidado.getSociedad());
                    dtoDocContableTemp.setFormaPago(consolidado.getFormaPago());
                    dtoDocContableTemp.setMoneda(consolidado.getMoneda());
                    dtoDocContableTemp.setTipoCambio(consolidado.getTipoCambio());
                    dtoDocContableTemp.setIndicadorImpresion(Boolean.FALSE);
                    dtoDocContableTemp.setIndicadorImpuestosFlete(consolidado.getIndicadorImpuestosFlete());
                    dtoDocContableTemp.setAlmacen(consolidado.getAlmacen());
                    //Si indicador exento flete es null se toma false.  Incidencia 13458.
                    if ((consolidado.getIndicadorExentoFlete() != null) && (consolidado.getIndicadorExentoFlete().booleanValue())) {
                        dtoDocContableTemp.setIndicadorExentoFlete(Boolean.TRUE);
                    } else {
                        dtoDocContableTemp.setIndicadorExentoFlete(Boolean.FALSE);
                    }
                    if (consolidado.getIndicadorDireccionSeparada().booleanValue()) {
    
                        //añadido por incidencia 21005
                        if (descTipoVia != null) {
                            dirCompleta += descTipoVia;  
                        }
                        if (direccion.getNombreVia()!= null) {
                            dirCompleta += " " + direccion.getNombreVia();
                        }
                        if (direccion.getNumeroPrincipal() != null) {
                            dirCompleta += " " + direccion.getNumeroPrincipal().toString();
                        }
                        if (direccion.getObservaciones()!= null) {
                            dirCompleta += " " + direccion.getObservaciones();
                        }
                        dirCompleta=dirCompleta.trim();
                        //by ssantana, inc. BELC300022470 se trunca la cadena a 140 caracteres, si es mayor.
                        if (dirCompleta.length() > 140) {
                           UtilidadesLog.debug("Long. dirCompleta es " + dirCompleta.length() + ", se trunca a 140");
                           dirCompleta = dirCompleta.substring(0,140); 
                        }
                        UtilidadesLog.debug("La direccion completa es: "+dirCompleta);
                    /* Agregado por Cambio FAC-001 ------ AL */
                    } else {              
                      if (direccion.getObservaciones()!= null) {                        
                        dirCompleta = direccion.getObservaciones();
                      }
                    }
                    /* Agregado por Cambio FAC-001 ------ AL */
                    dtoDocContableTemp.setDireccionCompleta(dirCompleta);
                    //vaciamos la variable dirCompleta 
                    dirCompleta="";
                    UtilidadesLog.debug("Fin asignaciones parcial.");       
                    
                    // Los campos siguientes sólo se insertarán si se está creando la primera cabecera 
                    // de documento contable del consolidado. En las siguientes cabeceras se pondrán a cero

                    //Agregado por SiCC20070484 - Rafael Romero - 23/10/2007
                    boolean primeraNotaCreditoAsignable = true;
                    if((datos.getCodigoTipoDocumento().equals("020")||
                            datos.getCodigoTipoDocumento().equals("021")||
                            datos.getCodigoTipoDocumento().equals("022"))&&
                            datos.getOidTipoConcursoPrograma()!=null){
                        primeraNotaCreditoAsignable = false;
                    }
                    // Fin agregado SiCC20070484
                    if (indFlete.booleanValue() && !datos.getCodigoTipoDocumento().equals("012") && primeraNotaCreditoAsignable) { // Modificado SiCC20070484
                        if (consolidado.getImporteFleteTotalLocal()!=null)
                          dtoDocContableTemp.setImporteFleteTotalLocal(consolidado.getImporteFleteTotalLocal());
                        if (consolidado.getImporteFleteSinImpuestosTotalLocal()!=null)
                          dtoDocContableTemp.setImporteFleteSinImpuestosTotalLocal(consolidado.getImporteFleteSinImpuestosTotalLocal());
                        if (consolidado.getImporteDescuento3TotalLocal()!=null)
                          dtoDocContableTemp.setImporteDescuento3TotalLocal(consolidado.getImporteDescuento3TotalLocal());
                        if (consolidado.getImporteFleteTotalDocumento()!=null)
                          dtoDocContableTemp.setImporteFleteTotalDocumento(consolidado.getImporteFleteTotalDocumento());
                        if (consolidado.getImporteFleteSinImpuestosTotalDocumento()!=null)
                          dtoDocContableTemp.setImporteFleteSinImpuestosTotalDocumento(consolidado.getImporteFleteSinImpuestosTotalDocumento());
                        if (consolidado.getImporteDescuento3TotalDocumento()!=null)
                          dtoDocContableTemp.setImporteDescuento3TotalDocumento(consolidado.getImporteDescuento3TotalDocumento());
                        indFlete = Boolean.FALSE;
                    } else {
                        dtoDocContableTemp.setImporteFleteTotalLocal(new Float("0"));
                        dtoDocContableTemp.setImporteFleteSinImpuestosTotalLocal(new Float("0"));
                        dtoDocContableTemp.setImporteDescuento3TotalLocal(new Float("0"));
                        dtoDocContableTemp.setImporteFleteTotalDocumento(new Float("0"));
                        dtoDocContableTemp.setImporteFleteSinImpuestosTotalDocumento(new Float("0"));
                        dtoDocContableTemp.setImporteDescuento3TotalDocumento(new Float("0"));
                    }
                    dtoDocContableTemp.setOidTipoConcursoPrograma(datos.getOidTipoConcursoPrograma());          

                    //Grabamos la cabecera del documento contable, luego de haber obtenido todos los datos a grabar                    
                    oidCabeceraDocumentoLegal = this.grabarCabeceraDocumentContable(dtoDocContableTemp,bs);
                    // - asignamos el oid del registro creado al dto:
                    dtoDocContableTemp.setOidCabeceraSolicitud(oidCabeceraDocumentoLegal);
                    dtoDocContableTemp.setTasaImpuestoFlete(consolidado.getTasaImpuestoFlete());
                    
                    // Se Insertan los Regiistros de Posicion
                    UtilidadesLog.debug("*** Se insertan los registros de posicion ***");
                    Integer contadorLineas = new Integer("0");
                    Integer numeroLinea = new Integer("1");
                    DTOFACPosicionSolicitud posicion = null;
                    listaPosicionesDocContable.clear();
                    while (listaTempIterator.hasNext() ) {   
                        //Se coge la primera posicion de la lista
                        posicion =(DTOFACPosicionSolicitud)listaTempIterator.next();
                        //añadido por incidencia 12343
                        if (posicion.getEstado() == null) {
                            UtilidadesLog.debug("El estado de la posicion es null y se lanza una excepcion");
                            throw new MareException("El estado de la posición es null");
                        }
                        
                        //modificado por incidencia 12343
                        UtilidadesLog.debug("El estado es: "+posicion.getEstado());
                        UtilidadesLog.debug("El valor de la constante de ped es: "+ConstantesPED.ESTADO_POSICION_ANULADO);
                        UtilidadesLog.debug("El indicador no imprimible es: "+posicion.getIndicadorNoImprimible());
                        
                        if (posicion.getEstado().longValue() != ConstantesPED.ESTADO_POSICION_ANULADO.longValue()) {
                          UtilidadesLog.debug("esMono " + datos.getMonoPagina().booleanValue() );                            
                          if (( !(datos.getMonoPagina().booleanValue()) ) ||( contadorLineas.intValue() < datos.getNumeroLineasPorPagina().intValue()) || posicion.getIndicadorNoImprimible().booleanValue() ) {               
                                try {
                                    if (posicion.getUnidadesAtendidas() == null) {
                                        posicion.setUnidadesAtendidas(new Integer(0));
                                    }
                                    lineasDocumentosContableGrabar.add((StringBuffer)this.armarLineaDocumentoContable(posicion, oidCabeceraDocumentoLegal, numeroLinea, dtoDocContableTemp.getMoneda()));
                                } catch (Exception e) {
                                    ctx.setRollbackOnly();
                                    UtilidadesLog.error("*** Error en grabarDocumentoContable al crear la linea de doc contable",e);
                                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
                                }
                                   
                                // Asimismo, se crea un objeto DTOFACPosicionDocContable con los atributos anteriores, 
                                // (los valores de la derecha de las asignaciones), y se almacena en 'listaPosicionesDocContable'
                                listaPosicionesDocContable.add((DTOFACPosicionDocContable)this.armarDtoPosicionDocumentoContable(posicion, dtoDocContableTemp.getOidCabeceraSolicitud()));                            

                                lineasDocumentosContableGrabar.add(this.generarStringUpdateMatriz(posicion.getOidDetaOferta()));

                                // Se agrego por la incidencia 22138
                                if (posicion.getIndicadorNoImprimible().booleanValue()) {
                                    UtilidadesLog.debug("posicion : " + posicion.getOidPosicion() + 
                                    ", de solicitud: " + posicion.getOidCabecera() + 
                                    " es no imprimible, se genera mensaje de ProductoFueraDocumento");
                                    DTOFACPosicionDocContable dtoPDCMensaje = new DTOFACPosicionDocContable();
                                    dtoPDCMensaje.setCodigoVenta(posicion.getCodigoVenta());
                                    dtoPDCMensaje.setDescripcionSAP(obtenerDescripcionI18NProducto(posicion.getProducto(),oidIdioma));
                                    dtoPDCMensaje.setUnidadesComprometidas(posicion.getUnidadesComprometidas());
                                    dtoPDCMensaje.setCodigoTipoOferta(posicion.getCodigoTipoOferta());
                                    if(posicion.getIndicadorDentroFueraCajaBolsa() == null) {
                                        //si es null, se asigna cero-> se modifica y si es null, se le pone dentro de caja
                                        dtoPDCMensaje.setIndicadorDentroFueraCajaBolsa("C");
                                    } else {
                                        dtoPDCMensaje.setIndicadorDentroFueraCajaBolsa(posicion.getIndicadorDentroFueraCajaBolsa());
                                    }                                
                                    this.generarMensajeProductoFueraDocumento(dtoDocContableTemp,dtoPDCMensaje);
                                } else {
                                    Integer intTemp1 = new Integer(contadorLineas.intValue() + 1);
                                    contadorLineas = intTemp1;
                                    
                                    //Incidencia 22873 - dmorello. El contador se incrementa sólo con posiciones imprimibles.
                                    if(datos.getOidTipoConcursoPrograma()!=null && datos.getCodigoTipoConcursoPrograma().equalsIgnoreCase("B") &&
                                       (datos.getCodigoTipoDocumento().equalsIgnoreCase("012") || datos.getCodigoTipoDocumento().equalsIgnoreCase("020"))){
                                    
                                        if((oidConcursoSolicitud == null) || (oidConcursoSolicitud.longValue() != posicion.getOidConcursoSolicitud().longValue())) {
                                            intTemp1 = new Integer(contadorLineas.intValue() + 1);
                                            contadorLineas = intTemp1;
                                            oidConcursoSolicitud = posicion.getOidConcursoSolicitud();
                                        }
                                    } 
                                }
                                
                                Integer intTemp = new Integer(numeroLinea.intValue() + 1);
                                numeroLinea = intTemp;
                                listaPosicionesDocOrden.remove(0);
                                listaTempIterator = listaPosicionesDocOrden.iterator();                  
                                UtilidadesLog.debug("**** Quedan "+ listaPosicionesDocOrden.size() + "por procesar para el tipoDocumento = " + datos.getOidTipoDocumento());  
                            } else {
                                listaTempIterator = listaPosicionesDocOrden.iterator();
                                UtilidadesLog.debug("*** Se ha completado una cabecera ***");
                                break; 
                            }
                        } //fin if estado 
                    } //fin while

                    //Se recalcula la cabecera 
                    UtilidadesLog.debug("*** Se recalcula la cabecera ***");
                    DTOFACCalculosImpuestosEntrada dtoCalculosImpuestosE =  new DTOFACCalculosImpuestosEntrada();
                    dtoCalculosImpuestosE.setDtoConsolidado(dtoDocContableTemp);
                    dtoCalculosImpuestosE.setListaPosiciones(listaPosicionesDocContable);
                    dtoCalculosImpuestosE.setIndicadorCalculo(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)));
                    dtoCalculosImpuestosE.setMoneda(dtoDocContableTemp.getMoneda());
                    if (dtoDocContableTemp.getTipoCambio() != null) {
                        dtoCalculosImpuestosE.setTipoCambio(new Float(dtoDocContableTemp.getTipoCambio().floatValue()));
                    }
                    dtoCalculosImpuestosE.setIndicadorImpuestosIncluidos(indicadorImpuestosIncluidos);
                    dtoCalculosImpuestosE.setImporteFleteSinImpuestosTotalLocal(dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal());
                    dtoCalculosImpuestosE.setImporteFleteSinImpuestosTotalDocumento(dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento());
                    dtoCalculosImpuestosE.setIndicadorImpuestoFlete(dtoDocContableTemp.getIndicadorImpuestosFlete());
                    if (datos.getCodigoTipoConcursoPrograma() != null) {
                      dtoCalculosImpuestosE.setCodigoTipoProgramaConcurso(datos.getCodigoTipoConcursoPrograma().toString());  
                    }
                    dtoCalculosImpuestosE.setTasaImpuestoFlete(dtoDocContableTemp.getTasaImpuestoFlete());

                    DTOFACCalculosImpuestosSalida dtoCalculosImpuestosS = null;
                    MONFacturacionLocal monFacturacion = this.getMONFacturacionLocal();
                    DTOFACCalculosCabeceraSalida dtoCalculosCabeceraS = null;
                    
                    dtoCalculosImpuestosS = monFacturacion.realizarCalculosImpuestos(dtoCalculosImpuestosE);

                    DTOFACCalculosCabeceraEntrada dtoCalculosCabeceraE =  new DTOFACCalculosCabeceraEntrada();
                    dtoCalculosCabeceraE.setDtoConsolidado(dtoDocContableTemp);
                    dtoCalculosCabeceraE.setListaPosiciones(listaPosicionesDocContable);
                    dtoCalculosCabeceraE.setIndicadorCalculo(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)));
                    dtoCalculosCabeceraE.setMoneda(dtoDocContableTemp.getMoneda());
                    if (dtoDocContableTemp.getTipoCambio() != null) {
                        dtoCalculosCabeceraE.setTipoCambio(new Float(dtoDocContableTemp.getTipoCambio().floatValue()));
                    }
                    dtoCalculosCabeceraE.setIndicadorImpuestosIncluidos(indicadorImpuestosIncluidos);
                    dtoCalculosCabeceraE.setBaseImponibleDescuento3Local(dtoCalculosImpuestosS.getBaseImponibleDescuento3Local());
                    dtoCalculosCabeceraE.setBaseImponibleDescuento3Documento(dtoCalculosImpuestosS.getBaseImponibleDescuento3Documento());
                    dtoCalculosCabeceraE.setBaseImponiblePrecioContableLocal(dtoCalculosImpuestosS.getBaseImponiblePrecioContableLocal());
                    dtoCalculosCabeceraE.setBaseImponiblePrecioContableDocumento(dtoCalculosImpuestosS.getBaseImponiblePrecioContableDocumento());
                    dtoCalculosCabeceraE.setTotalBaseImponibleLocal(dtoCalculosImpuestosS.getTotalBaseImponibleLocal());
                    dtoCalculosCabeceraE.setTotalBaseImponibleDocumento(dtoCalculosImpuestosS.getTotalBaseImponibleDocumento());
                    dtoCalculosCabeceraE.setTotalImporteLocal(dtoCalculosImpuestosS.getTotalImporteLocal());
                    dtoCalculosCabeceraE.setTotalImporteDocumento(dtoCalculosImpuestosS.getTotalImporteDocumento());
                    dtoCalculosCabeceraE.setTotalImpuestosLocal(dtoCalculosImpuestosS.getTotalImpuestosLocal());
                    dtoCalculosCabeceraE.setTotalImpuestosDocumento(dtoCalculosImpuestosS.getTotalImpuestosDocumento());
                    if (datos.getCodigoTipoConcursoPrograma() != null) {
                      dtoCalculosCabeceraE.setCodigoTipoProgramaConcurso(datos.getCodigoTipoConcursoPrograma().toString());
                    }

                    dtoCalculosCabeceraS = monFacturacion.realizarCalculosCabecera(dtoCalculosCabeceraE);
                    
                    // Se actualiza la entidad 'CabeceraDocumentoContable', mediante los métodos 'set' de los
                    // atributos contenidos en las variables 'dtoCalculosCabeceraS' y 'dtoCalculosImpuestosS'
                    this.updateCabeceraDocumentoContable(oidCabeceraDocumentoLegal, dtoCalculosCabeceraS,bs);
                    
                    if (dtoDocContableTemp.getOidTipoConcursoPrograma() == null) {

                       tempSumaTotalAPagarLocal = new Float(sumaTotalAPagarLocal.floatValue() + dtoCalculosCabeceraS.getTotalAPagarLocal().floatValue());
                        sumaTotalAPagarLocal = tempSumaTotalAPagarLocal;
                        UtilidadesLog.debug("SumaTotalAPagarLocal es: "+sumaTotalAPagarLocal);
    
                        tempSumaTotalAPagarDocumento = new Float(sumaTotalAPagarDocumento.floatValue() + dtoCalculosCabeceraS.getTotalAPagarDocumento().floatValue());
                        sumaTotalAPagarDocumento = tempSumaTotalAPagarDocumento;
                    }
                } //2 Fin Proceso de las Posiciones de Tipo Documento Actual
            } //1 Fin Proceso por Tipo Documento Legal
            hashCatalogos.clear();

            // se insertan todas las lineas de documentos contables.
            this.grabarVariasLineasDocumentoContable(lineasDocumentosContableGrabar);

            // se actuliza la matriz de facturacion
            MONMantenimientoMF monMantenimientoMF = this.getMONMantenimientoMF();
            try{
                //  Agregado por HRCS - Fecha 18/05/2007 - Cambio Sicc20070235
                if (consolidado.getUnidadesAtendidasTotal()!=null && consolidado.getUnidadesAtendidasTotal().intValue()>0)   {
                    monMantenimientoMF.actualizarMatrizFacturada(consolidado.getPeriodo(),Boolean.TRUE);		
                }
            } catch (RemoteException ex) {
                UtilidadesLog.error("Error en actualizarMatrizFacturada", ex);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));			
            }
            
            Boolean actualizarRedondeoLocal = Boolean.FALSE;
            Boolean actualizarRedondeoDocumento = Boolean.FALSE;
            if (numeroFacturasGeneradas.intValue() > 1) {
                //se genera mas de una cabecera de documento contable
                if (sumaTotalAPagarLocal.floatValue() - consolidado.getTotalAPagarLocal().floatValue() != 0) {
                    UtilidadesLog.debug("Entra a comprobar valores redondeo");
                    UtilidadesLog.debug("Total a pagar local redondeo es: "+consolidado.getTotalAPagarLocal());
                    UtilidadesLog.debug("sumaTotalAPagarLocal: "+sumaTotalAPagarLocal);
                    consolidado.setImporteRedondeoConsolidadoLocal(new Float(
                        sumaTotalAPagarLocal.floatValue() - consolidado.getTotalAPagarLocal().floatValue()));
                        consolidado.setTotalAPagarLocal(new Float(consolidado.getTotalAPagarLocal().floatValue()
                        + consolidado.getImporteRedondeoConsolidadoLocal().floatValue()));
                    actualizarRedondeoLocal = Boolean.TRUE;
                    if ( (sumaTotalAPagarDocumento.floatValue() - consolidado.getTotalAPagarDocumento().floatValue()) != 0 ) {
                        consolidado.setImporteRedondeoConsolidadoDocumento(new Float(
                            sumaTotalAPagarDocumento.floatValue() - consolidado.getTotalAPagarDocumento().floatValue()));
                        consolidado.setTotalAPagarDocumento(new Float(consolidado.
                            getTotalAPagarDocumento().floatValue() + consolidado.
                            getImporteRedondeoConsolidadoDocumento().floatValue()));
                        actualizarRedondeoDocumento = Boolean.TRUE;
                    }
                }
                // Comprobacion de que al menos una de las variables es true
                if (actualizarRedondeoLocal.booleanValue() || actualizarRedondeoDocumento.booleanValue()) { 
                    DAOSolicitudCabecera dao = new DAOSolicitudCabecera(); 
                    dao.actualizarRedondeosConsolidado(consolidado,actualizarRedondeoLocal,actualizarRedondeoDocumento);
                }        
            }

        } catch(Exception e) {
            e.printStackTrace();
            if (e instanceof MareException){
                throw (MareException) e;
            }
            UtilidadesLog.error(e);    
            //ctx.setRollbackOnly();
            throw new MareException (e);
        }     
        UtilidadesLog.info("MONTratamientosContablesBean.grabarDocumentoContable(DTOFACConsolidado dtoConsolidado): Salida");
	}


    private Boolean obtenerIndicadorImpuestoIncluidos(Long oidPais) throws MareException {
        // Se accede a la entidad Pais para obtener el indicador de impuestos incluidos en los precios
        PaisLocalHome paisLocalHome = null;
        PaisLocal paisLocal = null;
        paisLocalHome = this.getPaisLocalHome();
        try{
            paisLocal = paisLocalHome.findByPrimaryKey(oidPais);
        } catch (NoResultException ex) {
            UtilidadesLog.error("*** Error en obtenerIndicadorImpuestoIncluidos: finderException",ex);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("El indicador de impuestos incluidos es 1: " + paisLocal.getInd_impu_incl());
        return paisLocal.getInd_impu_incl();
    }

  
    private String obtenerDescripcionI18NProducto (Long producto, Long idioma){
      try{
          StringBuffer sb = new StringBuffer("  select val_i18n from v_gen_i18n_sicc where attr_enti = 'MAE_PRODU' ");
          sb.append(" and idio_oid_idio = "+idioma);
          sb.append(" and val_oid = "+producto );
          RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
          if (rs!=null && !rs.esVacio()){
              return rs.getValueAt(0,0).toString();
          }
      }catch(Exception e){
          UtilidadesLog.error("ERROR AL OBTENER DESCRIPCION I18N del PRODUCTO NO IMPRIMIBLE");
      }
      return "";
    }
    
    private BigDecimal toBigDecimal(Object valor){
        return new BigDecimal((valor != null ? valor.toString() : "0"));
    }

  private void updateCabeceraDocumentoContable(Long oidCabe, DTOFACCalculosCabeceraSalida dtoCalculosCabeceraS, BelcorpService bs)throws MareException {
      
      StringBuffer query  = new StringBuffer( "UPDATE FAC_DOCUM_CONTA_CABEC SET ");
      
      StringBuffer query2  = new StringBuffer();
      if(dtoCalculosCabeceraS.getUnidadesAtendidasTotal()!=null){
        query2.append(",NUM_UNID_ATEN_TOTA="+dtoCalculosCabeceraS.getUnidadesAtendidasTotal());
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocal()!=null){
        query2.append(",VAL_PREC_CATA_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocalUnidadesPorAtender()!=null){
        query2.append(",VAL_PREC_CATA_TOTA_LOCA_UNID="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocalUnidadesPorAtender().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalLocal()!=null){
        query2.append(",VAL_PREC_CATA_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableTotalLocal()!=null){
        query2.append(",VAL_PREC_CONT_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalLocal()!=null){
        query2.append(",VAL_PREC_CONT_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1TotalLocal()!=null){
        query2.append(",IMP_DES1_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1TotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalLocal()!=null){
        query2.append(",IMP_DES1_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalLocal()!=null){
        query2.append(",IMP_DES3_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuentoTotalLocal()!=null){
        query2.append(",IMP_DESC_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuentoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioFacturaTotalLocal()!=null){
        query2.append(",VAL_PREC_FACT_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioFacturaTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioNetoTotalLocal()!=null){
        query2.append(",VAL_PREC_NETO_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioNetoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteImpuestosTotalLocal()!=null){
        query2.append(",IMP_IMPU_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteImpuestosTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioTotalTotalLocal()!=null){
        query2.append(",VAL_PREC_TOTA_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioTotalTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoLocal()!=null){
        query2.append(",IMP_REDO_CONS_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoLocal()!=null){
        query2.append(",IMP_REDO_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getTotalAPagarLocal()!=null){
        query2.append(",VAL_TOTA_PAGA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getTotalAPagarLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoTotalDocumento()!=null){
        query2.append(",VAL_PREC_CATA_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalDocumento()!=null){
        query2.append(",VAL_PREC_CATA_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableTotalDocumento()!=null){
        query2.append(",VAL_PREC_CONT_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalDocumento()!=null){
        query2.append(",VAL_PREC_CONT_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1TotalDocumento()!=null){
        query2.append(",IMP_DES1_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1TotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalDocumento()!=null){
        query2.append(",IMP_DES1_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalDocumento()!=null){
        query2.append(",IMP_DES3_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuentoTotalDocumento()!=null){
        query2.append(",IMP_DESC_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuentoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioFacturaTotalDocumento()!=null){
        query2.append(",VAL_PREC_FACT_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioFacturaTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioNetoTotalDocumento()!=null){
        query2.append(",VAL_PREC_NETO_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioNetoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteImpuestosTotalDocumento()!=null){
        query2.append(",IMP_IMPU_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteImpuestosTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioTotalTotalDocumento()!=null){
        query2.append(",VAL_PREC_TOTA_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioTotalTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoDocumento()!=null){
        query2.append(",IMP_REDO_CONS_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoDocumento()!=null){
        query2.append(",IMP_REDO_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getTotalAPagarDocumento()!=null){
        query2.append(",VAL_TOTA_PAGA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getTotalAPagarDocumento().toString()));
      }
      
      query.append(query2.substring(1));
      
      query.append(" WHERE OID_CABE="+oidCabe);
      
        try {
          bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error en grabarDocumentoContable al updatear la cabecera del Doc Contable",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
    
  }
  
    private StringBuffer generarUpdateCabeceraDocumentoContable(Long oidCabe, DTOFACCalculosCabeceraSalida dtoCalculosCabeceraS)throws MareException {
      
      StringBuffer query  = new StringBuffer( "UPDATE FAC_DOCUM_CONTA_CABEC SET ");
      
      StringBuffer query2  = new StringBuffer();
      if(dtoCalculosCabeceraS.getUnidadesAtendidasTotal()!=null){
        query2.append(",NUM_UNID_ATEN_TOTA="+dtoCalculosCabeceraS.getUnidadesAtendidasTotal());
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocal()!=null){
        query2.append(",VAL_PREC_CATA_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocalUnidadesPorAtender()!=null){
        query2.append(",VAL_PREC_CATA_TOTA_LOCA_UNID="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoTotalLocalUnidadesPorAtender().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalLocal()!=null){
        query2.append(",VAL_PREC_CATA_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableTotalLocal()!=null){
        query2.append(",VAL_PREC_CONT_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalLocal()!=null){
        query2.append(",VAL_PREC_CONT_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1TotalLocal()!=null){
        query2.append(",IMP_DES1_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1TotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalLocal()!=null){
        query2.append(",IMP_DES1_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalLocal()!=null){
        query2.append(",IMP_DES3_IMPU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuentoTotalLocal()!=null){
        query2.append(",IMP_DESC_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuentoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioFacturaTotalLocal()!=null){
        query2.append(",VAL_PREC_FACT_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioFacturaTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioNetoTotalLocal()!=null){
        query2.append(",VAL_PREC_NETO_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioNetoTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteImpuestosTotalLocal()!=null){
        query2.append(",IMP_IMPU_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteImpuestosTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioTotalTotalLocal()!=null){
        query2.append(",VAL_PREC_TOTA_TOTA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioTotalTotalLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoLocal()!=null){
        query2.append(",IMP_REDO_CONS_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoLocal()!=null){
        query2.append(",IMP_REDO_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getTotalAPagarLocal()!=null){
        query2.append(",VAL_TOTA_PAGA_LOCA="+new BigDecimal(dtoCalculosCabeceraS.getTotalAPagarLocal().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoTotalDocumento()!=null){
        query2.append(",VAL_PREC_CATA_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalDocumento()!=null){
        query2.append(",VAL_PREC_CATA_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioCatalogoSinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableTotalDocumento()!=null){
        query2.append(",VAL_PREC_CONT_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalDocumento()!=null){
        query2.append(",VAL_PREC_CONT_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getPrecioContableSinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1TotalDocumento()!=null){
        query2.append(",IMP_DES1_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1TotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalDocumento()!=null){
        query2.append(",IMP_DES1_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento1SinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalDocumento()!=null){
        query2.append(",IMP_DES3_SIN_IMPU_TOTA="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuento3SinImpuestoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteDescuentoTotalDocumento()!=null){
        query2.append(",IMP_DESC_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteDescuentoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioFacturaTotalDocumento()!=null){
        query2.append(",VAL_PREC_FACT_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioFacturaTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioNetoTotalDocumento()!=null){
        query2.append(",VAL_PREC_NETO_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioNetoTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteImpuestosTotalDocumento()!=null){
        query2.append(",IMP_IMPU_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteImpuestosTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getPrecioTotalTotalDocumento()!=null){
        query2.append(",VAL_PREC_TOTA_TOTA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getPrecioTotalTotalDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoDocumento()!=null){
        query2.append(",IMP_REDO_CONS_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoConsolidadoDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getImporteRedondeoDocumento()!=null){
        query2.append(",IMP_REDO_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getImporteRedondeoDocumento().toString()));
      }
      if(dtoCalculosCabeceraS.getTotalAPagarDocumento()!=null){
        query2.append(",VAL_TOTA_PAGA_DOCU="+new BigDecimal(dtoCalculosCabeceraS.getTotalAPagarDocumento().toString()));
      }
      
      query.append(query2.substring(1));
      
      query.append(" WHERE OID_CABE="+oidCabe);
      
      return query;
    }
    
   /* Modificado por Cambio FAC-001 ------ AL */
	private Long grabarCabeceraDocumentContable( DTOFACCabeceraDocContable dtoDocContableTemp, BelcorpService bs) throws  MareException  {
        
        Long oid=SecuenciadorOID.obtenerSiguienteValor("FAC_DCCA_SEQ");
        Vector vector= new Vector();

      	StringBuffer query  = new StringBuffer( "INSERT INTO FAC_DOCUM_CONTA_CABEC (" +
        " OID_CABE, " +
        " NUM_DOCU_CONT_INTE, " +
        " ZZON_OID_ZONA , " +
        " ZSGV_OID_SUBG_VENT, " +
        " ZSCC_OID_SECC, " +
        " ZORG_OID_REGI, " +
        " TERR_OID_TERR, " +
        " SOCI_OID_SOCI, " +
        " FOPA_OID_FORM_PAGO, " +
        " CLDI_OID_CLIE_DIRE, " +
        " PAIS_OID_PAIS, " +
        " PERD_OID_PERI, " +
        " SBAC_OID_SBAC, " +
        " SOCA_OID_SOLI_CABE," + 
        " FORS_OID_FORM, " +
        " TIDO_OID_TIPO_DOCU, " +
        " FEC_EMIS, " +
        " FEC_FACT, " +
        " VAL_ESTA, " +
        " VAL_EJER_DOCU_INTE, " +
        " VAL_NOM1, " +
        " VAL_NOM2, " +
        " VAL_APE1, " +
        " VAL_APE2, "+
        " VAL_SERI_DOCU_LEGA, " +
        " VAL_DIRE_COMP ");
        if (dtoDocContableTemp.getNumeroDocumentoLegal()!=null){
            query.append(",NUM_DOCU_LEGA");
        }
        if (dtoDocContableTemp.getNumeroIdentificacionFiscal()!=null){
           query.append(",VAL_NUME_IDEN_FISC");
        }
        if(dtoDocContableTemp.getNumeroIdentificacionNacional() != null){
            query.append(",VAL_NUME_IDEN_NNAL");
        }
        if(dtoDocContableTemp.getPuntoEmision()!= null){
            query.append(",VAL_PUNT_EMIS");
        }
        if(dtoDocContableTemp.getObservaciones()!= null){
            query.append(",VAL_OBSE");
        }
        if(dtoDocContableTemp.getNumeroAbono()!= null){
            query.append(",NUM_ABON");
        }
        if(dtoDocContableTemp.getIndicadorImpresion()!= null){
            query.append(",IND_IMPR");
        }
        if(dtoDocContableTemp.getNumeroDocumentoOrigen()!= null){
            query.append(",NUM_DOCU_ORIG");
        }
        if(dtoDocContableTemp.getTipoDireccion()!= null){
            query.append(",VAL_TIPO_DIRE");
        }
        if(dtoDocContableTemp.getAlmacen()!= null){
            query.append(",VAL_ALMA");
        }
        if (dtoDocContableTemp.getImporteFleteTotalLocal()!=null){
            query.append(",IMP_FLET_TOTA_LOCA");
        }
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal()!=null){
            query.append(",IMP_FLET_IMPU_TOTA_LOCA");
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalLocal()!=null){
          query.append(",IMP_DES3_TOTAL_LOCA");
        }
        if (dtoDocContableTemp.getImporteFleteTotalDocumento()!=null){
          query.append(",IMP_FLET_TOTA_DOCU");
        }
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento()!=null){
          query.append(",IMP_FLET_SIN_IMPU_TOTA_DOCU");
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalDocumento()!=null){
          query.append(",IMP_DES3_TOTA_DOCU");
        }
        if (dtoDocContableTemp.getOidTipoConcursoPrograma() != null){
          query.append(",ICTP_OID_TIPO_PROG");
        }
        query.append(", VAL_TELE_FIJO");
        query.append(", VAL_TELE_CELU");
        query.append(", VAL_BARR");
        query.append(", VAL_IMPO_IVA_ASUM_EMPR");
        query.append(") VALUES (");
        query.append(oid + ",");
        query.append(new Long(dtoDocContableTemp.getNumeroDocumentoInterno().toString())+ ",");
        query.append(dtoDocContableTemp.getZona()+ ",");
        query.append(dtoDocContableTemp.getSubgerencia()+ ",");
        query.append(dtoDocContableTemp.getSeccion()+ ",");
        query.append(dtoDocContableTemp.getRegion()+ ",");
        query.append(dtoDocContableTemp.getTerritorio()+ ",");
        query.append(dtoDocContableTemp.getSociedad()+ ",");
        query.append(dtoDocContableTemp.getFormaPago()+ ",");
        query.append(dtoDocContableTemp.getOidClienteDireccion()+ ",");
        query.append(dtoDocContableTemp.getOidPais()+ ",");
        query.append(dtoDocContableTemp.getPeriodo()+ ",");
        query.append(dtoDocContableTemp.getSubacceso()+ ",");
        query.append(dtoDocContableTemp.getOidCabeceraSolicitud()+ ",");
        query.append(dtoDocContableTemp.getOidFormulario()+ ",");
        query.append(dtoDocContableTemp.getTipoDocumento()+ ",");
      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
   	    /*Date fechaEmision = new java.sql.Date(dtoDocContableTemp.getFechaEmision().getTime()); 
	    String sFechaEmision = sdf.format(fechaEmision);     */
        query.append("SYSDATE,");
   	    Date fechaFact = new java.sql.Date(dtoDocContableTemp.getFechaFacturacion().getTime()); 
	    String sFechaFact = sdf.format(fechaFact);     
        query.append("TO_DATE('" + sFechaFact + "','YYYY-MM-DD'),");
        query.append(dtoDocContableTemp.getEstado() + ",");
        query.append("'" + dtoDocContableTemp.getEjercicioDocumentoContableInterno().toString()+ "',");
        query.append("'").append(dtoDocContableTemp.getNombre1()!=null?dtoDocContableTemp.getNombre1():"").append("',");
        query.append("'").append(dtoDocContableTemp.getNombre2()!=null?dtoDocContableTemp.getNombre2():"").append("',");
        query.append("'").append(dtoDocContableTemp.getApellido1()!=null?dtoDocContableTemp.getApellido1():"").append("',");
        query.append("'").append(dtoDocContableTemp.getApellido2()!=null?dtoDocContableTemp.getApellido2():"").append("',");
        query.append("'" + dtoDocContableTemp.getSerieDocumentoLegal()+ "',");
        query.append("'").append(dtoDocContableTemp.getDireccionCompleta()!=null?dtoDocContableTemp.getDireccionCompleta():"").append("'");

        if (dtoDocContableTemp.getNumeroDocumentoLegal()!=null){
            query.append("," + dtoDocContableTemp.getNumeroDocumentoLegal());
        }         
        if (dtoDocContableTemp.getNumeroIdentificacionFiscal()!=null){
            if (dtoDocContableTemp.getNumeroIdentificacionFiscal().length()>15){
                query.append(",'" +dtoDocContableTemp.getNumeroIdentificacionFiscal().substring(0,15) + "'");
            }else{
                query.append(",'" +dtoDocContableTemp.getNumeroIdentificacionFiscal() + "'");
            }
        }
        if(dtoDocContableTemp.getNumeroIdentificacionNacional() != null){
            query.append(",'" + dtoDocContableTemp.getNumeroIdentificacionNacional() + "'");
        }
        if(dtoDocContableTemp.getPuntoEmision()!= null){
            query.append(",'" +dtoDocContableTemp.getPuntoEmision()).append("'");
        }
        if(dtoDocContableTemp.getObservaciones()!= null){
            query.append(",'" +dtoDocContableTemp.getObservaciones() + "'");
        }
        if(dtoDocContableTemp.getNumeroAbono()!= null){
            query.append("," +new Integer(dtoDocContableTemp.getNumeroAbono().toString()));
        }
        if(dtoDocContableTemp.getIndicadorImpresion()!= null){
            if (dtoDocContableTemp.getIndicadorImpresion().booleanValue()) {
                query.append(",1");
            } else {
                query.append(",0");
            }
        }
        if(dtoDocContableTemp.getNumeroDocumentoOrigen()!= null){
            query.append("," +dtoDocContableTemp.getNumeroDocumentoOrigen());
        }
        if(dtoDocContableTemp.getTipoDireccion()!= null){
            query.append("," +dtoDocContableTemp.getTipoDireccion());
        }
        if(dtoDocContableTemp.getAlmacen()!= null){
            query.append("," +dtoDocContableTemp.getAlmacen().toString());
        }

        if (dtoDocContableTemp.getImporteFleteTotalLocal()!=null){
            query.append("," +dtoDocContableTemp.getImporteFleteTotalLocal());
        }
        
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal()!=null){
            query.append("," +dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal());
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalLocal()!=null){
          query.append("," +dtoDocContableTemp.getImporteDescuento3TotalLocal());
        }
        if (dtoDocContableTemp.getImporteFleteTotalDocumento()!=null){
          query.append("," +dtoDocContableTemp.getImporteFleteTotalDocumento());
        }
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento()!=null){
          query.append("," +dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento());
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalDocumento()!=null){
          query.append("," +dtoDocContableTemp.getImporteDescuento3TotalDocumento());
        }
        
        if (dtoDocContableTemp.getOidTipoConcursoPrograma() != null){
          query.append("," +dtoDocContableTemp.getOidTipoConcursoPrograma());
        }
  		  query.append(",(SELECT  CASE WHEN (PIP.IND_BUSQ_TELE = 1) THEN ");
          query.append("            	(SELECT MCC.VAL_TEXT_COMU ");
          query.append("	                  FROM MAE_CLIEN_COMUN MCC, "); 
          query.append("	                       MAE_TIPO_COMUN MTC ");
          query.append("	                  WHERE MCC.TICM_OID_TIPO_COMU = MTC.OID_TIPO_COMU  ");
          query.append("	                    AND MTC.COD_TIPO_COMU = 'TF' "); 
          query.append("	                    AND MCC.CLIE_OID_CLIE = " + dtoDocContableTemp.getOidCliente() + ") ");
          query.append("	       END TELEF_FIJO ");
          query.append("		FROM SEG_PARAM_INTER_PAIS PIP ");
          query.append("		WHERE PIP.PAIS_OID_PAIS = " + dtoDocContableTemp.getOidPais() + ") ");           
        
          query.append(",(SELECT  CASE WHEN (PIP.IND_BUSQ_TELE = 1) THEN ");
          query.append("            	(SELECT MCC.VAL_TEXT_COMU ");
          query.append("	                  FROM MAE_CLIEN_COMUN MCC, "); 
          query.append("	                       MAE_TIPO_COMUN MTC ");
          query.append("	                  WHERE MCC.TICM_OID_TIPO_COMU = MTC.OID_TIPO_COMU  ");
          query.append("	                    AND MTC.COD_TIPO_COMU = 'TC' "); 
          query.append("	                    AND MCC.CLIE_OID_CLIE = " + dtoDocContableTemp.getOidCliente() + ") ");
          query.append("	       END TELEF_FIJO ");
          query.append("		FROM SEG_PARAM_INTER_PAIS PIP ");
          query.append("		WHERE PIP.PAIS_OID_PAIS = " + dtoDocContableTemp.getOidPais() + ") ");  

          query.append(",(SELECT MCD.VAL_BARR ");
		  query.append(" FROM MAE_CLIEN_DIREC MCD ");            
          query.append(" WHERE MCD.IND_DIRE_PPAL = 1");
          query.append("   AND MCD.IND_ELIM = 0");
          query.append("   AND MCD.CLIE_OID_CLIE = " + dtoDocContableTemp.getOidCliente() + ")");

        query.append("," + dtoDocContableTemp.getIVAasumidoEmpresa());
        
        query.append(");");

        try {
          bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("Query con error :"+query.toString(),e);
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error en grabarDocumentoContable al crear la cabecera del Doc Contable",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
       
        return oid;
	}
/* Modificado por Cambio FAC-001 ------ AL */


    /**
     * Graba varias lineas de documento contable de forma masiva.
     */
    private void grabarVariasLineasDocumentoContable(ArrayList lineasDocumentosContables) throws MareException {
        UtilidadesLog.info("MONTratamientoContable.grabarVariasLineasDocumentoContable() - entrada");        
        BelcorpService bs;
        StringBuffer lineaDoc; 
        StringBuffer variasQuerys = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        // -> Armamos querys de insert
        Iterator iter = lineasDocumentosContables.iterator();
        while(iter.hasNext()) {
            lineaDoc = (StringBuffer)iter.next();
            variasQuerys.append(lineaDoc);
            variasQuerys.append(";");
        }
        // -> Ejecutamos multiples inserts          
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", variasQuerys.toString());
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error en grabarDocumentoContable al crear varias lineas del Doc Contable",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONTratamientoContable.grabarVariasLineasDocumentoContable()- salida");        
    }


    /**
     * Retorna el codigo de catalogo a partir de el oidCatalogo.
     */
    private String obtenerCodigoCatalogo(Integer oidCatalogo, BelcorpService bs) {
        String codigoCatalogo = " ";
        if (hashCatalogos.containsKey(oidCatalogo)) {
            codigoCatalogo = (String)hashCatalogos.get(oidCatalogo);
        } else {
            try{
                StringBuffer sb = new StringBuffer("select COD_CATA from pre_catal where oid_cata = "+oidCatalogo.toString());
                RecordSet rs = bs.dbService.executeStaticQuery(sb.toString());
                if (rs != null && !rs.esVacio()) {
                  codigoCatalogo = (String)rs.getValueAt(0,0).toString();
                }
            }catch (Exception e){
                UtilidadesLog.error("*** Error al obtener el codigo de catalogo******  ",e);
            }
            hashCatalogos.put(oidCatalogo, codigoCatalogo);
        }
        return codigoCatalogo;
    }
  
  
    /**
     * CHANGELOG
     * ---------
     * RI 20090926 Cambio en la forma de obtener y actualizar los numeros de documento legal.
     * Cambio 20090908 - dmorello, 06/07/2009 - Se agrega parametro oidDocumLegalRef y se usa para buscar en el hashTiposDocumento
     */
    public Hashtable actualizarNumeroDocumentoLegal(DTOFACCabeceraSolicitud consolidado, Hashtable hashTiposDocumento, Long clave, Long oidTipoPrograma, Long oidDocumLegalRef) throws MareException{
         UtilidadesLog.info("MONTratamientosContables.actualizarNumeroDocumentoLegal(): Entrada");
         StringBuffer consulta = new StringBuffer();
         StringBuffer update = new StringBuffer();
         RecordSet rs = null;        
         BelcorpService bs = UtilidadesEJB.getBelcorpService();

         UtilidadesLog.debug("-> Subacceso = "+consolidado.getSubacceso() +", sociedad = "+ consolidado.getSociedad()+" , tipoDocumento = "+clave+" y pais = "+consolidado.getOidPais());  

         consulta.append(" SELECT OID_DOCU_SUBA, VAL_ULTI_NUME_DOCU_LEGA, VAL_LIMI_NUME_DOCU_LEGA, VAL_ULTI_EJER_DOCU_INTE, VAL_SERI_DOCU_LEGA, VAL_ULTI_NUME_DOCU_INTE ");
         consulta.append(" FROM FAC_DOCUM_SUBAC ");
         consulta.append(" WHERE SBAC_OID_SBAC = " + consolidado.getSubacceso() );
         consulta.append(" AND SOCI_OID_SOCI = " + consolidado.getSociedad() );
         consulta.append(" AND TIDO_OID_TIPO_DOCU = " + clave ); //se pasa el tipo de documento legal que es la clave del hashTable//consolidado.getTipoDocumentoLegal());
         consulta.append(" AND PAIS_OID_PAIS = " + consolidado.getOidPais() );
         consulta.append(" FOR UPDATE ");
         try {
             rs = bs.dbService.executeStaticQuery(consulta.toString());
         } catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }

         Long oidDocumSubacceso = new Long(((BigDecimal)rs.getValueAt(0, "OID_DOCU_SUBA")).intValue());
         String serieDocLegal = (String)rs.getValueAt(0, "VAL_SERI_DOCU_LEGA");
         Integer ultimoNumDocLegal = new Integer(((BigDecimal)rs.getValueAt(0, "VAL_ULTI_NUME_DOCU_LEGA")).intValue());
         Integer limiteNumDocLegal = new Integer(((BigDecimal)rs.getValueAt(0, "VAL_LIMI_NUME_DOCU_LEGA")).intValue());
         Integer ultimoEjercicioDocInterno = new Integer(((BigDecimal)rs.getValueAt(0, "VAL_ULTI_EJER_DOCU_INTE")).intValue());
         Integer ultimoNumDocInterno = new Integer(((BigDecimal)rs.getValueAt(0, "VAL_ULTI_NUME_DOCU_INTE")).intValue());
         
         // Obtengo el objeto DatosTipoDocumento del hashTiposDocumento segun los params de entrada
         String hashKey = clave + "-" + oidTipoPrograma + "-" + oidDocumLegalRef;
         DatosTipoDocumento datos = ((DatosTipoDocumento)hashTiposDocumento.get(hashKey));

         datos.setSerieDocumentoLegal(serieDocLegal);
         datos.setNumeroDocumentoLegal(ultimoNumDocLegal);
         datos.setLimiteNumeroDocumentoLegal(limiteNumDocLegal);
         datos.setEjercicioDocumentoInterno(ultimoEjercicioDocInterno);
         datos.setNumeroDocumentoInterno(ultimoNumDocInterno);

         // Cálculo de los números interno y legal de documento 
         this.calcularNumerosDocumento(consolidado, hashTiposDocumento, clave, oidTipoPrograma, oidDocumLegalRef); //Ya que la clave de la hashtable es el tipo de documento
         
         UtilidadesLog.debug(" NumeroDocumentoInterno = " + datos.getNumeroDocumentoInterno() );   
         UtilidadesLog.debug(" EjercicioDocumentoInterno = " + datos.getEjercicioDocumentoInterno() );
         UtilidadesLog.debug(" NumeroDocumentoLegal = " + datos.getNumeroDocumentoLegal() );
         UtilidadesLog.debug(" NumeroLineasPorPagina = " + datos.getNumeroLineasPorPagina() );
         UtilidadesLog.debug(" SerieDocumentoLegal = " + datos.getSerieDocumentoLegal() );
         UtilidadesLog.debug("--> Se actualiza la entidad DocumentoPorSubacceso con los últimos números de documento calculados ");

         // Modificado por SiCC20070484 - Rafael Romero - 07/11/2007
         if(datos.getNumeroDocumentoLegal() != null){
              ultimoNumDocLegal = new Integer(datos.getNumeroDocumentoLegal().toString());            
         } // Fin modificado SiCC20070484
         ultimoEjercicioDocInterno = new Integer(datos.getEjercicioDocumentoInterno().toString());
         ultimoNumDocInterno = new Integer(datos.getNumeroDocumentoInterno().toString());
         serieDocLegal = datos.getSerieDocumentoLegal();
         
         update.append(" UPDATE FAC_DOCUM_SUBAC ");
         update.append(" SET VAL_ULTI_NUME_DOCU_LEGA = " + ultimoNumDocLegal + ", ");
         update.append("   VAL_ULTI_EJER_DOCU_INTE = " + ultimoEjercicioDocInterno + ", ");
         update.append("   VAL_ULTI_NUME_DOCU_INTE = " + ultimoNumDocInterno + ", ");
         update.append("   VAL_SERI_DOCU_LEGA = '" + serieDocLegal + "' " );
         update.append(" WHERE OID_DOCU_SUBA = " + oidDocumSubacceso );
         try {
             bs.dbService.executeUpdate(update.toString());
         } catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
         }

         UtilidadesLog.info("MONTratamientosContables.actualizarNumeroDocumentoLegal(): Salida");
         return hashTiposDocumento;               
     }


	public Hashtable recuperarTiposDocumento(DTOFACConsolidado dtoConsolidado) throws MareException{
		UtilidadesLog.info("MONTratamientosContablesBean.recuperarTiposDocumento(DTOFACConsolidado dtoConsolidado): Entrada");
        DTOFACCabeceraSolicitud consolidado = null;
        ArrayList listaSolicitudes = null;
        ArrayList listaPosiciones = null;
        consolidado = dtoConsolidado.getDtoCabecera();
        listaSolicitudes = dtoConsolidado.getListaSolicitudes();
        listaPosiciones = dtoConsolidado.getListaPosiciones();
        
        UtilidadesLog.debug("-GA- Tenemos "+ listaSolicitudes.size() +" solicitudes y "+listaPosiciones.size()+" posiciones en el consolidado "+dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
        ArrayList listaTiposDocumento = new ArrayList();
        /* Agregado por Cambio FAC-003 ------ AL */
        HashMap hashDocumProgramaINC = new HashMap();  
        HashMap hashCodigoProgramasINC = new HashMap();
        /* Agregado por Cambio FAC-003 ------ AL */
        Hashtable hash = new Hashtable();
        
        DTOFACCabeceraSolicitud solicitud = new DTOFACCabeceraSolicitud();
    
        if (consolidado.getTipoDocumentoLegal() == null) {
            Iterator iteratorListaSolicitudes = listaSolicitudes.iterator();
            while (iteratorListaSolicitudes.hasNext()) {
                solicitud = (DTOFACCabeceraSolicitud)iteratorListaSolicitudes.next();                
                if(!listaTiposDocumento.contains(solicitud.getTipoDocumentoLegal())) {
                    listaTiposDocumento.add(solicitud.getTipoDocumentoLegal());
                }
                if (consolidado.getTipoSolicitudConsolidado() == null) {
                    consolidado.setTipoSolicitudConsolidado(solicitud.getTipoSolicitudConsolidado());
                }
                /* Agregado por Cambio FAC-003 ------ AL */
                ArrayList listaTiposProgramaIncentivos;
                if (hashDocumProgramaINC.containsKey(solicitud.getTipoDocumentoLegal())) {
                  listaTiposProgramaIncentivos = (ArrayList)hashDocumProgramaINC.get(solicitud.getTipoDocumentoLegal());
                } else {
                  listaTiposProgramaIncentivos = new ArrayList();
                }
                listaTiposProgramaIncentivos.add(solicitud.getOidTipoConcursoPrograma());    
                hashDocumProgramaINC.put(solicitud.getTipoDocumentoLegal(), listaTiposProgramaIncentivos);                  
                hashCodigoProgramasINC.put(solicitud.getOidTipoConcursoPrograma(), solicitud.getCodigoTipoProgramaConcu());
                /* Agregado por Cambio FAC-003 ------ AL */
            }
        } else {
          listaTiposDocumento.add(consolidado.getTipoDocumentoLegal());
          /* Agregado por Cambio FAC-003 ------ AL */
          Iterator iteratorListaSolicitudes = listaSolicitudes.iterator();
          while (iteratorListaSolicitudes.hasNext()) {
            solicitud = (DTOFACCabeceraSolicitud)iteratorListaSolicitudes.next();                
            ArrayList listaTiposProgramaIncentivos;
            if (hashDocumProgramaINC.containsKey(solicitud.getTipoDocumentoLegal())) {
              listaTiposProgramaIncentivos = (ArrayList)hashDocumProgramaINC.get(solicitud.getTipoDocumentoLegal());
            } else {
              listaTiposProgramaIncentivos = new ArrayList();
            }
            listaTiposProgramaIncentivos.add(solicitud.getOidTipoConcursoPrograma());             
            hashDocumProgramaINC.put(solicitud.getTipoDocumentoLegal(), listaTiposProgramaIncentivos);            
            hashCodigoProgramasINC.put(solicitud.getOidTipoConcursoPrograma(), solicitud.getCodigoTipoProgramaConcu());
          }
          /* Agregado por Cambio FAC-003 ------ AL */
        }
        
        HashMap hashCodigosTipoDocumento = this.obtenerCodigosTipoDocumento(listaTiposDocumento);
        
        // Cambio 20090908 - dmorello, 29/06/2009
        // Armo una lista con los diferentes OIDs de documentos legales de referencia
        // tomados de las posiciones del consolidado
        ArrayList listaDocsLegalesRef = new ArrayList();
        Iterator itPosiciones = dtoConsolidado.getListaPosiciones().iterator();
        while (itPosiciones.hasNext()) {
            DTOFACPosicionSolicitud dto = (DTOFACPosicionSolicitud)itPosiciones.next();
            if (! listaDocsLegalesRef.contains(dto.getOidDocumentoLegalReferencia())) {
                listaDocsLegalesRef.add(dto.getOidDocumentoLegalReferencia());
            }
        }
        UtilidadesLog.debug("listaDocsLegalesRef: " + listaDocsLegalesRef);
        
        UtilidadesLog.debug("-GA- Tipos de documentos a procesar: " + listaTiposDocumento.size());
        Collections.sort(listaTiposDocumento);

        UtilidadesLog.debug("-GA- Tipos de documentos a procesar luego de ordenar: " + listaTiposDocumento.size());
        DatosTipoDocumento datos = null;

        HashMap mapaTiposDoc = new HashMap();
        Iterator iteratorListaTiposDocumento = listaTiposDocumento.iterator();
        while (iteratorListaTiposDocumento.hasNext()) {
            Long tipoDocumento  = null;
            tipoDocumento = (Long)iteratorListaTiposDocumento.next();
            if (mapaTiposDoc.get(tipoDocumento)!=null) {
               UtilidadesLog.debug("El tipo de documento "+tipoDocumento.toString()+" ya existía. No lo tengo en cuenta.");
               continue;
            } else {
               mapaTiposDoc.put(tipoDocumento, tipoDocumento);
            }
            UtilidadesLog.debug("*** Tipo de documento = "+tipoDocumento);
            FormularioLocalHome formularioLocalHome = null;
            FormularioLocal formularioLocal = null;
            Collection registros = null;
            formularioLocalHome = this.getFormularioLocalHome();
            try {
                registros = formularioLocalHome.findByTipoDocumento(tipoDocumento);
            } catch(NoResultException fe) {
                throw new MareException(fe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            UtilidadesLog.debug("*** Numero de registros obtenidos = "+registros.size());
				
            if (registros.size() == 0) {
                UtilidadesLog.error("*** No de registros igual a cero ***");
                throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            Iterator formulario = registros.iterator();
            formularioLocal = obtieneFormularioPorAsociacionTipoSolicitud(formulario, consolidado.getTipoSolicitud());
            
            /* Agregado por Cambio FAC-003 ------ AL */
            Iterator itTipoProgramasConcu = ((ArrayList)hashDocumProgramaINC.get(tipoDocumento)).iterator();
            while (itTipoProgramasConcu.hasNext()) {
            /* Agregado por Cambio FAC-003 ------ AL */
              Long oidTipoPrograma = (Long)itTipoProgramasConcu.next();
                
              Iterator itDocsLegalesRef = listaDocsLegalesRef.iterator();
              while (itDocsLegalesRef.hasNext()) {
              Long oidDocumLegalRef = (Long)itDocsLegalesRef.next();
                
              datos = new DatosTipoDocumento();
              datos.setCodigoTipoDocumento(hashCodigosTipoDocumento.get(tipoDocumento).toString());
              datos.setOidFormulario(formularioLocal.getOid());
              datos.setCodigoFormulario(formularioLocal.getCodigo());
              datos.setOidTipoDocumento(tipoDocumento);
              datos.setOidTipoConcursoPrograma(oidTipoPrograma);
              if(esDocumentoMonopagina.booleanValue()){
                /* Agregado por Cambio FAC-003 ------ AL */
                if (oidTipoPrograma != null) {
                  if (hashCodigoProgramasINC.get(oidTipoPrograma).toString().equalsIgnoreCase("B") && 
                     (hashCodigosTipoDocumento.get(tipoDocumento).toString().equalsIgnoreCase("012") || hashCodigosTipoDocumento.get(tipoDocumento).toString().equalsIgnoreCase("020"))) {  
                    datos.setNumeroLineasPorPagina(new Integer(formularioLocal.getNumLineasPagina().intValue() - 2));  // Esto es porque se agregan 5 lineas en la Boleta de Venta                    
                  } else {
                    datos.setNumeroLineasPorPagina(new Integer(formularioLocal.getNumLineasPagina().toString()));      
                  }
                } else {
                  datos.setNumeroLineasPorPagina(new Integer(formularioLocal.getNumLineasPagina().toString()));      
                }                                
                /* Agregado por Cambio FAC-003 ------ AL */
                /* Eliminado por Cambio FAC-003 ------ AL 
                datos.setNumeroLineasPorPagina(new Integer(formularioLocal.getNumLineasPagina().toString()));      
                Eliminado por Cambio FAC-003 ------ AL */
                datos.setMonoPagina(Boolean.TRUE);
              } else {
                datos.setMonoPagina(Boolean.FALSE);   
              }
              if (formularioLocal.getNumeracionOficial() != null) {
                datos.setEsNumeracionOficial(formularioLocal.getNumeracionOficial());
              } else {
                datos.setEsNumeracionOficial(Boolean.FALSE);
              }
              /* Agregado por Cambio FAC-003 ------ AL */
              // Modificado por SICC20070410 - Rafael Romero - 11/09/2007
               this.seleccionarPosiciones(datos, dtoConsolidado, tipoDocumento, oidTipoPrograma, oidDocumLegalRef);
              // Fin modificado SICC20070410
              if (oidTipoPrograma != null) {
                datos.setCodigoTipoConcursoPrograma(hashCodigoProgramasINC.get(oidTipoPrograma).toString());                
              }
              if (oidDocumLegalRef != null) {
                  datos.setOidDocumentoLegalReferencia(oidDocumLegalRef);
              }
              hash.put(tipoDocumento + "-" + oidTipoPrograma + "-" + oidDocumLegalRef, datos);   
              }
            }
            /* Agregado por Cambio FAC-003 ------ AL */
            /* Eliminado por Cambio FAC-003 ------ AL 
            datos.setListaPosiciones(this.seleccionarPosiciones(dtoConsolidado, tipoDocumento));
            UtilidadesLog.debug("-GA- Posiciones seleccionadas: "+datos.getListaPosiciones().size());
            hash.put(tipoDocumento, datos);
            Eliminado por Cambio FAC-003 ------ AL */
        }
        UtilidadesLog.info("MONTratamientosContablesBean.recuperarTiposDocumento(DTOFACConsolidado dtoConsolidado): Salida");
        return hash;
    }
    
    private FormularioLocal obtieneFormularioPorAsociacionTipoSolicitud (Iterator formulario, Long tipoSolConsolidado) throws MareException{
        try{
            Collection col = this.getFormulariosTipoSolicitudLocalHome().findByTipoSolicitud(tipoSolConsolidado);
            if (col.size() == 0){
                UtilidadesLog.error("NO HAY DATOS en FormulariosTipoSolicitud para el tipoSolConsolidado: "+tipoSolConsolidado);
                throw new Exception("NO HAY DATOS en FormulariosTipoSolicitud para el tipoSolConsolidado");
            }
            Object[] lista = col.toArray();
            while (formulario.hasNext()){
                FormularioLocal formularioLocal = (FormularioLocal)formulario.next();
                for (int i = 0; i < lista.length; i++){
                    FormulariosTipoSolicitudLocal formTipoSolLocal = (FormulariosTipoSolicitudLocal)lista[i];
                    if (formTipoSolLocal.getFormulario().longValue() == formularioLocal.getOid().longValue()){
                        return formularioLocal;
                    }
                }
            }
        }catch (Exception e){
            UtilidadesLog.error("ERROR AL ASOCIAR EL FORMULARIO CON EL TIPO DE SOLICITUD",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.error("----------------------------------------------------------------------------------------");
        UtilidadesLog.error("EL o LOS FORMULARIOS NO TIENEN ASOCIADO EL TIPO DE SOLICITUD EN FormulariosTipoSolicitud");
        UtilidadesLog.error("----------------------------------------------------------------------------------------");
        throw new MareException("EL o LOS FORMULARIOS NO TIENEN ASOCIADO EL TIPO DE SOLICITUD EN FormulariosTipoSolicitud");
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio 20090908 - dmorello, 06/07/2009 - Agrego parametro oidDocumLegalRef y lo uso para buscar en hashTiposDocumento
     */
    public void calcularNumerosDocumento(DTOFACCabeceraSolicitud consolidado, Hashtable hashTiposDocumento, Long tipoDocumento, Long oidTipoPrograma, Long oidDocumLegalRef) throws MareException {
        UtilidadesLog.info("MONTratamientosContablesBean.calcularNumerosDocumento(DTOFACCabeceraSolicitud consolidado, Long tipoDocumento, Long oidTipoPrograma): Entrada");
        Integer ultimoEjercicioDocInterno;
        DatosTipoDocumento datos = (DatosTipoDocumento)hashTiposDocumento.get(tipoDocumento + "-" + oidTipoPrograma + "-" + oidDocumLegalRef);
        String fecha[] = this.obtenerAnioMesDia(consolidado.getFecha());
            
        ultimoEjercicioDocInterno = datos.getEjercicioDocumentoInterno();
        
        UtilidadesLog.debug("El ultimo ejercicio documento interno es: " + ultimoEjercicioDocInterno);
        if( datos.getEjercicioDocumentoInterno().intValue() == new Integer(fecha[0]).intValue()  ){
            datos.setNumeroDocumentoInterno(
            new Integer(datos.getNumeroDocumentoInterno().intValue() + 1));
        } else {
            UtilidadesLog.debug("*** Numero documento = 1 ***");
            datos.setNumeroDocumentoInterno(new Integer(1));
            datos.setEjercicioDocumentoInterno(new Integer(fecha[0]));
        }
        
        // Modificado por SiCC20070484 - Rafael Romero - 07/11/2007
        if(datos.getMonoPagina().booleanValue()){
            datos.setNumeroDocumentoLegal(null);
        }else{
            if(!datos.getEsNumeracionOficial().booleanValue()){ // Numeración libre
        
                    UtilidadesLog.debug("Es numeración libre");
              if(ultimoEjercicioDocInterno.intValue() == new Integer(fecha[0]).intValue()){
                UtilidadesLog.debug("No es el primer documento del año");
                        datos.setNumeroDocumentoLegal(new Integer(datos.getNumeroDocumentoLegal().intValue() + 1));
              } else{
                UtilidadesLog.debug("Es el primer documento del año");
                        datos.setNumeroDocumentoLegal(new Integer(1));
              }
            } else{  // Numeración oficial
              UtilidadesLog.debug("Es numeración oficial");
                    datos.setNumeroDocumentoLegal(new Integer(datos.getNumeroDocumentoLegal().intValue() + 1));
            }
        
            DTOFACDocumentoSubacceso nuevoRango = new DTOFACDocumentoSubacceso();
                
            UtilidadesLog.debug("*** SCS tengo limite de doc. legal?? : " + datos.getLimiteNumeroDocumentoLegal().intValue());
        
            if( datos.getLimiteNumeroDocumentoLegal().intValue() > 0 ){
                UtilidadesLog.debug("*** SCS comparo NumeroDocumentoLegal contra LimiteNumeroDocumentoLegal: " + datos.getNumeroDocumentoLegal().intValue() + " -- " + datos.getLimiteNumeroDocumentoLegal()); 
                if(datos.getNumeroDocumentoLegal().intValue() > datos.getLimiteNumeroDocumentoLegal().intValue() ){
                    nuevoRango = this.activarNuevoRangoNumeracionOficial(consolidado, tipoDocumento);                
                    datos.setNumeroDocumentoLegal(nuevoRango.getUltimoNumeroDocumentoLegal());
                    datos.setSerieDocumentoLegal(nuevoRango.getSerieDocumentoLegal());
                }
            }
        }
        // Fin modificado SiCC20070484
        
        UtilidadesLog.info("MONTratamientosContablesBean.calcularNumerosDocumento(DTOFACCabeceraSolicitud consolidado, Long tipoDocumento, Long oidTipoPrograma): Salida");
    }

	public ArrayList seleccionarPosiciones(DTOFACConsolidado dtoConsolidado, Long tipoDocumento) throws MareException {
		UtilidadesLog.info("MONTratamientosContablesBean.seleccionarPosiciones(DTOFACConsolidado dtoConsolidado, Long tipoDocumento): Entrada");
        ArrayList listaRetorno = new ArrayList();
        Iterator iteradorListaPosiciones = null;
        Iterator iteradorListaSolicitudes = dtoConsolidado.getListaSolicitudes().iterator();
        while(iteradorListaSolicitudes.hasNext()){
            DTOFACCabeceraSolicitud cabecera = null;
            cabecera = (DTOFACCabeceraSolicitud)iteradorListaSolicitudes.next();
            if(cabecera.getTipoDocumentoLegal().longValue() == tipoDocumento.longValue()){
                iteradorListaPosiciones = dtoConsolidado.getListaPosiciones().iterator();
                while(iteradorListaPosiciones.hasNext()){
                    DTOFACPosicionSolicitud posicion = null;
                    posicion = (DTOFACPosicionSolicitud) iteradorListaPosiciones.next();
                    if(posicion.getOidCabecera().longValue() ==  cabecera.getOidCabeceraSolicitud().longValue()){
                        listaRetorno.add(posicion);
                    }
                }
            } //incidencia 9051
        }
		UtilidadesLog.info("MONTratamientosContablesBean.seleccionarPosiciones(DTOFACConsolidado dtoConsolidado, Long tipoDocumento): Salida");
		return listaRetorno;
	}

    /**
    * Sistema:     Belcorp
    * Modulo:      XXX
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */   
	public void actualizarStockSeguimiento(DTOFACConsolidado dtoConsolidado) throws MareException {
		/*Documentation
		 Permite actualizar el stock comprometido para los tipos de solicitudes que 
		 lo tengan parametrizado  y el seguimiento de pedidos para las solicitudes
		 que sean de tipo orden de compra. 
		*/
		UtilidadesLog.info("MONTratamientosContablesBean.actualizarStockSeguimiento(DTOFACConsolidado dtoConsolidado): Entrada");
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                    UtilidadesLog.debug("El dto que llega es: " + dtoConsolidado);
		DTOFACCabeceraSolicitud consolidado = dtoConsolidado.getDtoCabecera(); 
		ArrayList listaSolicitudes = dtoConsolidado.getListaSolicitudes(); 
		ArrayList listaPosiciones = dtoConsolidado.getListaPosiciones(); 

		// Bucle de tratamiento de las solicitudes 
		Iterator iterator = listaSolicitudes.iterator();
        Hashtable ht = new Hashtable();
		while(iterator.hasNext()){
			DTOFACCabeceraSolicitud solicitud = new DTOFACCabeceraSolicitud();
			solicitud = (DTOFACCabeceraSolicitud)iterator.next();
            if (!ht.containsKey(solicitud.getOidCabeceraSolicitud())){
                ht.put(solicitud.getOidCabeceraSolicitud(), solicitud);
            
                // Generar movimiento de almacén 
                /* Se verifica que el tipo de solicitud de la solicitud en curso tiene
                parametrizado movimiento de almacén, 
                accediendo a la entidad "Tipos Solicitud por País", comprobando si el 
                atributo "Tipo Movimiento a realizar 
                en facturación" está relleno 
                */
                TiposSolicitudPaisLocalHome  tiposSolPaisHome = this.getTiposSolicitudPaisLocalHome();
                TiposSolicitudPaisLocal tiposSolPaisLocal = null;
    
                try{
                    tiposSolPaisLocal = tiposSolPaisHome.findByPrimaryKey(solicitud.getTipoSolicitud()); 
                } catch(NoResultException fe){
                      UtilidadesLog.error("actualizarStockSeguimiento: FinderException",fe);
                      String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                      throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                } 

                UtilidadesLog.debug("El tipo de movimiento de facturacion es: " + tiposSolPaisLocal.getOidTipoMovFacturacion());
                if(tiposSolPaisLocal.getOidTipoMovFacturacion() != null ){
                    UtilidadesLog.debug("Entra para llamar a BEL");
                    //Si( tiposSolicitudPais.getOidTipoMovFacturacion != null ) { 
                    // Invocar al caso de uso "Movimiento de Almacén y Stock" (BEL) 
                    DTOMovimientoAlmacen dtoMovimiento = new DTOMovimientoAlmacen(); 
                    DTOMovimientoAlmacenCabecera dtoMovCabecera = new DTOMovimientoAlmacenCabecera(); 
                    
                    dtoMovCabecera.setNumeroDocumento(null); 
                    dtoMovCabecera.setOidTipoMovimientoAlmacen(null); 
                    dtoMovCabecera.setFecha(consolidado.getFecha()); 
                    dtoMovCabecera.setOidAlmacenSalida(null); 
                    dtoMovCabecera.setOidAlmacenEntrada(null); 
                    dtoMovCabecera.setOidMarca(solicitud.getMarca()); 
                    dtoMovCabecera.setOidCanal(solicitud.getCanal()); 
                    dtoMovCabecera.setOidAcceso(solicitud.getAcceso()); 
                    dtoMovCabecera.setOidSubacceso(solicitud.getSubacceso()); 
                    dtoMovCabecera.setOidPeriodo(solicitud.getPeriodo()); 
                    dtoMovCabecera.setObservaciones(solicitud.getObservaciones()); 
                    dtoMovCabecera.setIndicadorNoGenerarCabecera(Boolean.FALSE); 
                    dtoMovCabecera.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
                    dtoMovCabecera.setOidPais(solicitud.getOidPais());
                    
                    dtoMovimiento.setCabecera(dtoMovCabecera); 
                    dtoMovimiento.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
                    dtoMovimiento.setOidPais(solicitud.getOidPais());
                    
                    // Con listaPosiciones, que contiene objetos DTOFACPosicionSolicitud, hay que 
                    // construir una nueva lista de objetos DTOMovimientoAlmacenDetalle, 
                    // y se asigna a dtoMovimiento.detalle 
                    ArrayList listaNueva = new ArrayList();
                    
                    
                    Iterator listaPos = listaPosiciones.iterator();
                    while(listaPos.hasNext()){
                        DTOFACPosicionSolicitud posicion = new DTOFACPosicionSolicitud();
                        posicion = (DTOFACPosicionSolicitud)listaPos.next();
                        
                        /* Se agrega para que no se generen movimientos de almacen para las posiciones anuladas */
                        if (posicion.getEstado().longValue() != ConstantesPED.ESTADO_POSICION_ANULADO.longValue()) {          
                            /* Añadido por incidencia:
                            BELC300019256:Solo crearemos el siguiente objeto posicion si la 
                            posicion correspondiente a la vuelta del
                            bucle pertenece a la cabecera que hemos creado antes en dicha vuelta.
                            */
                            UtilidadesLog.debug("El oid de la solicitud es: " + solicitud.getOidCabeceraSolicitud().longValue());
                            UtilidadesLog.debug("El oid de la posicion es: " + posicion.getOidCabecera().longValue());
                            if(posicion.getOidCabecera().longValue()==solicitud.getOidCabeceraSolicitud().longValue()){
                                UtilidadesLog.debug("La posicion pertenece a la solicitud");
                                
                                DTOMovimientoAlmacenDetalle dtoMovDetalle = new DTOMovimientoAlmacenDetalle();
                                dtoMovDetalle.setOidCanal(solicitud.getCanal()); //incidencia 9066
                                dtoMovDetalle.setOidAcceso(solicitud.getAcceso()); //incidencia 9066
                                dtoMovDetalle.setOidSubacceso(solicitud.getSubacceso()); //incidencia 9066
                                dtoMovDetalle.setNumeroMovimiento(null);
                                dtoMovDetalle.setOidTipoMovimientoAlmacen(tiposSolPaisLocal.getOidTipoMovFacturacion());
                                dtoMovDetalle.setOidAlmacenSalida(solicitud.getAlmacen()); //incidencia 9066
                                dtoMovDetalle.setOidAlmacenEntrada(null);
                                dtoMovDetalle.setOidProducto(posicion.getProducto());
                                if(posicion.getUnidadesAtendidas() != null){
                                    dtoMovDetalle.setCantidad(new Long(posicion.getUnidadesAtendidas().longValue()));	
                                }else{ 
                                    //generarLOG(ERROR,"Las unidades atendidas para la posiciones=? es NULL se asigna cero a la cantidad del detalle de moviento de Almacen") 
                                    UtilidadesLog.error("Las unidades atendidas para la posicion= "+posicion.getOidPosicion() +" es NULL, se asigna cero a la cantidad del detalle de movimiento de Almacen");
                                    dtoMovDetalle.setCantidad(new Long(0));     
                                }                 
                                if(posicion.getPrecioNetoTD() != null){
                                    dtoMovDetalle.setPrecioVentaNeto(new BigDecimal(posicion.getPrecioNetoTD().doubleValue()));	
                                }
                                if(posicion.getPrecioContableTD() != null){
                                    dtoMovDetalle.setPrecioContable(new BigDecimal(posicion.getPrecioContableTD().doubleValue()));	
                                }
                                //dtoMovDetalle.setObservaciones(null);
                                dtoMovDetalle.setNumeroPosicionReferencia(posicion.getNumeroPosicion()); //incidencia 9066
                                dtoMovDetalle.setNumeroDocumentoReferencia(solicitud.getNumeroSolicitud());//incidencia 9066
                                dtoMovDetalle.setOperacion(ConstantesFAC.COD_OP_ACTUALIZAR_STOCK_FAC);
                                dtoMovDetalle.setOidTipoOferta(posicion.getTipoOferta());
                                //Agregado por Cristian Valenzuela - 26/9/2005
                                //CAMBIOS SAM-001
                                dtoMovDetalle.setOidTipoPosicion(posicion.getOidTipoPosicion());
                                dtoMovDetalle.setOidSubtipoPosicion(posicion.getOidSubtipoPosicion());                        
                                //FIN - Agregado por Cristian Valenzuela - 26/9/2005
                                listaNueva.add(dtoMovDetalle);
                            }//Fin if posiciones
                        }//Fin if Estado 
                    } // Fin bucle listaPosiciones 
                    
                    dtoMovimiento.setDetalle(listaNueva); 
                    
                    DTOReportePedidos dtoReporte = new DTOReportePedidos();
                    
                    MONGenerarMovimientoAlmacen mONGenerarMovimientoAlmacen = this.getMONGenerarMovimientoAlmacen();
                    try{
                    mONGenerarMovimientoAlmacen.grabarMovimientoAlmacenYStock(dtoMovimiento);
                    }catch(RemoteException re){
                    UtilidadesLog.error("*** Error en actualizarStockSeguimiento",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
                    }
                }
                // Actualizar Seguimiento de Pedidos 
                // Se verifica que el tipo de solicitud es orden de compra 
                //Si( solicitud.indicadorOrdenCompra ) { 
                if(solicitud.getIndicadorOrdenCompra().booleanValue()){
                    // Invocar al caso de uso "Actualizar Seguimiento de Pedidos" (PED) 
                    DTOSeguimientoPedidos dtoPedidos = new DTOSeguimientoPedidos();
                    dtoPedidos.setConsolidado(consolidado.getOidCabeceraSolicitud());
                    dtoPedidos.setHitoSeguimiento(ConstantesPED.HITO_05);
                    dtoPedidos.setNumeroDocumento(null);
                    //dtoPedidos.setFecha(consolidado.getFecha()); se elimina por incidencia 15418 
                    dtoPedidos.setIndCompleto(null);
                    MONSeguimientoPedidos mONSeguimientoPedidos = this.getMONSeguimientoPedidos();
                    try{
                        mONSeguimientoPedidos.actualizarSeguimientoPedidos(dtoPedidos);
                    }catch(RemoteException re){
                        UtilidadesLog.error("*** Error en actualizarStockSeguimiento",re);
                        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
                    }            
                }
            }
		} // Fin bucle listaSolicitudes
		UtilidadesLog.info("MONTratamientosContablesBean.actualizarStockSeguimiento(DTOFACConsolidado dtoConsolidado): Salida");
	}


	public DTOSalida consultarFacturas(DTOFACConsultaFacturas dtoe) throws MareException {
		UtilidadesLog.info("MONTratamientosContablesBean.consultarFacturas(DTOFACConsultaFacturas dtoe): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
        DAOFACDocumentoContable daoFACDocumentoContable = new DAOFACDocumentoContable(usuario);
		DTOSalida dtoSalida = daoFACDocumentoContable.consultarFacturas(dtoe);
		UtilidadesLog.info("MONTratamientosContablesBean.consultarFacturas(DTOFACConsultaFacturas dtoe): Salida");
		return dtoSalida;
	}


    private RegistroUnicoVentasLocalHome getRegistroUnicoVentasLocalHome() throws MareException {
		UtilidadesLog.info("MONTratamientosContablesBean.getRegistroUnicoVentasLocalHome(): Entrada");
        RegistroUnicoVentasLocalHome registroUnicoVentasLocalHome = (RegistroUnicoVentasLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/RegistroUnicoVentas");
		UtilidadesLog.info("MONTratamientosContablesBean.getRegistroUnicoVentasLocalHome(): Entrada");
        return registroUnicoVentasLocalHome;
	}

    private RangosNumeracionOficialLocalHome getRangosNumeracionOficialLocalHome() throws MareException {
        return new RangosNumeracionOficialLocalHome();
    }

    private TiposSolicitudPaisLocalHome getTiposSolicitudPaisLocalHome() throws MareException {
       return new TiposSolicitudPaisLocalHome();
    }

    private MONCuentasCorrientes getMONCuentasCorrientes() throws MareException {
	
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONCuentasCorrientes(): Entrada");
        MONCuentasCorrientesHome home = (MONCuentasCorrientesHome)UtilidadesEJB.getHome(
        "MONCuentasCorrientes", MONCuentasCorrientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONCuentasCorrientes ejb = null;
        try {
		
            ejb = home.create();
			
        } catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONCuentasCorrientes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			
        } 
		
		UtilidadesLog.info("MONTratamientosContablesBean.getMONCuentasCorrientes(): Salida");
        return ejb;
	}	

    private MONReversionFAC getMONReversionFAC() throws MareException {
	
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONReversionFAC(): Entrada");
        MONReversionFACHome home = (MONReversionFACHome)UtilidadesEJB.getHome(
        "MONReversionFAC", MONReversionFACHome.class);
            
        // Se obtiene el interfaz remoto
        MONReversionFAC ejb = null;
        try {
		
            ejb = home.create();
			
        } catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONReversionFAC",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			
        } 
		
		UtilidadesLog.info("MONTratamientosContablesBean.getMONReversionFAC(): Salida");
        return ejb;
	}	

    
	private MONGestionMensajes getMONGestionMensajes() throws MareException {
	
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONGestionMensajes(): Entrada");
        MONGestionMensajesHome home = (MONGestionMensajesHome)UtilidadesEJB.getHome(
        "MONGestionMensajes", MONGestionMensajesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestionMensajes ejb = null;
        try {
		
            ejb = home.create();
			
        } catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONGestionMensajes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			
        } 
		
		UtilidadesLog.info("MONTratamientosContablesBean.getMONGestionMensajes(): Salida");
        return ejb;
	}



	private MONGenerarMovimientoAlmacen getMONGenerarMovimientoAlmacen() throws MareException {
	
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONGenerarMovimientoAlmacen(): Entrada");
       MONGenerarMovimientoAlmacenHome home = (MONGenerarMovimientoAlmacenHome)UtilidadesEJB.getHome(
        "MONGenerarMovimientoAlmacen", MONGenerarMovimientoAlmacenHome.class);
            
        // Se obtiene el interfaz remoto
       MONGenerarMovimientoAlmacen ejb = null;
        try {
		
            ejb = home.create();
			
        } catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONGenerarMovimientoAlmacen",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			
        } 
		
		UtilidadesLog.info("MONTratamientosContablesBean.getMONGenerarMovimientoAlmacen(): Salida");
        return ejb;
	}	
	
	private MONSeguimientoPedidos getMONSeguimientoPedidos() throws MareException {
	
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONSeguimientoPedidos(): Entrada");
       MONSeguimientoPedidosHome home = (MONSeguimientoPedidosHome)UtilidadesEJB.getHome(
        "MONSeguimientoPedidos", MONSeguimientoPedidosHome.class);
            
        // Se obtiene el interfaz remoto
       MONSeguimientoPedidos ejb = null;
        try {
		
            ejb = home.create();
			
        } catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONSeguimientoPedidos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			
        } 
		
		UtilidadesLog.info("MONTratamientosContablesBean.getMONSeguimientoPedidos(): Salida");
        return ejb;
	}

    private ParametrosFacturacionLocalHome getParametrosFacturacionLocalHome() throws MareException {
       return new ParametrosFacturacionLocalHome(); 
    }

    private TipoDocumentoLocalHome getTipoDocumentoLocalHome() throws MareException {
       return new TipoDocumentoLocalHome();  
    }

    private ArrayList ordenarListaPosicionesDoc(ArrayList listaPosicionesDoc){
        UtilidadesLog.info("MONTratamientosContablesBean.ordenarListaPosicionesDoc(ArrayList listaPosicionesDoc): Entrada");
        int i = 0;
        int j = 0;
        int posicionMenor = 0;

        DTOFACPosicionSolicitud dtoMenor = null;
        DTOFACPosicionSolicitud dtoAuxiliar = null;
        ArrayList dtosordenaos = new ArrayList();

        if(listaPosicionesDoc.size() > 1){

            while(listaPosicionesDoc.size() > 0 ){
				i = 0;
                dtoMenor = (DTOFACPosicionSolicitud)listaPosicionesDoc.get(i);
                posicionMenor = 0;
				if(dtoMenor.getIndicadorDentroFueraCajaBolsa()==null){
                    //si es null, se le pone dentro de caja
					dtoMenor.setIndicadorDentroFueraCajaBolsa("C");					
				}
				if(dtoMenor.getCatalogo()==null){
					dtoMenor.setCatalogo(new Integer(0));
				}
				if(dtoMenor.getPagina()==null){
					dtoMenor.setPagina(new Integer(0));
				}
				if(dtoMenor.getCodigoVenta()==null){
					dtoMenor.setCodigoVenta("");
				}
				
                for(i=0; i<listaPosicionesDoc.size(); i++){
					dtoAuxiliar = (DTOFACPosicionSolicitud)listaPosicionesDoc.get(i);

    				if(dtoAuxiliar.getIndicadorDentroFueraCajaBolsa()==null){
                        //si es null, se le pone dentro de caja
        				dtoAuxiliar.setIndicadorDentroFueraCajaBolsa("C");					
            		}
            		if(dtoAuxiliar.getCatalogo()==null){
                		dtoAuxiliar.setCatalogo(new Integer(0));
                	}
                	if(dtoAuxiliar.getPagina()==null){
                    	dtoAuxiliar.setPagina(new Integer(0));
                    }
                	if(dtoAuxiliar.getCodigoVenta()==null){
                    	dtoAuxiliar.setCodigoVenta("");
                    }
                    if(dtoMenor.getIndicadorDentroFueraCajaBolsa().compareTo(dtoAuxiliar.getIndicadorDentroFueraCajaBolsa()) > 0){
                    
                        dtoMenor =  (DTOFACPosicionSolicitud)listaPosicionesDoc.get(i);
                        posicionMenor = i;
					
                    }else{

                        if(dtoMenor.getIndicadorDentroFueraCajaBolsa().compareTo(dtoAuxiliar.getIndicadorDentroFueraCajaBolsa()) == 0){
                   
                            if(dtoMenor.getCatalogo().intValue() > dtoAuxiliar.getCatalogo().intValue()){
                                dtoMenor =  dtoAuxiliar;
                                posicionMenor = i;
                            }else{
                                if(dtoMenor.getCatalogo().intValue() == dtoAuxiliar.getCatalogo().intValue()){

                                    if(dtoMenor.getPagina().intValue() > dtoAuxiliar.getPagina().intValue()){
                                        dtoMenor =  dtoAuxiliar;
                                        posicionMenor = i;
                                    }else{
                                        if(dtoMenor.getPagina().intValue() == dtoAuxiliar.getPagina().intValue()){
                                            if(dtoMenor.getCodigoVenta().compareTo(dtoAuxiliar.getCodigoVenta()) > 0){
                                                dtoMenor =  dtoAuxiliar;
                                                posicionMenor = i;
                                            }else{
                                                if(dtoMenor.getCodigoVenta().compareTo(dtoAuxiliar.getCodigoVenta()) == 0){
                                                    if(dtoMenor.getProducto().longValue() > dtoAuxiliar.getProducto().longValue()){
                                                        dtoMenor =  dtoAuxiliar;
                                                        posicionMenor = i;
                                                    }else{
                                                        if(dtoMenor.getProducto().longValue() == dtoAuxiliar.getProducto().longValue()){
                                                            if(dtoMenor.getOidCabecera().longValue() > dtoAuxiliar.getOidCabecera().longValue()){
                                                                dtoMenor =  dtoAuxiliar;
                                                                posicionMenor = i; 
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                /*dtoAuxiliar = (DTOFACPosicionSolicitud)listaPosicionesDoc.get(j);
                dtoMenor = (DTOFACPosicionSolicitud)listaPosicionesDoc.get(posicionMenor);
                listaPosicionesDoc.set(j, dtoMenor);
                listaPosicionesDoc.set(posicionMenor,dtoAuxiliar);*/
				listaPosicionesDoc.remove(posicionMenor);

                dtosordenaos.add(dtoMenor);
            }
            return dtosordenaos;
        }
        UtilidadesLog.info("MONTratamientosContablesBean.ordenarListaPosicionesDoc(ArrayList listaPosicionesDoc): Salida");
        return listaPosicionesDoc;
    }
	
    private LineaDocumentoContableLocalHome getLineaDocumentoContableLocalHome() throws MareException {

        UtilidadesLog.info("MONTratamientosContablesBean.getLineaDocumentoContableLocalHome(): Entrada");
		LineaDocumentoContableLocalHome lineaDocumentoContableLocalHome = (LineaDocumentoContableLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/LineaDocumentoContable");
		UtilidadesLog.info("MONTratamientosContablesBean.getLineaDocumentoContableLocalHome(): Salida");
		return lineaDocumentoContableLocalHome;
    }


    private FormularioLocalHome getFormularioLocalHome() throws MareException {
       return new FormularioLocalHome();    
    }

    private CabeceraDocumentoContableLocalHome getCabeceraDocumentoContableLocalHome() throws MareException {

        UtilidadesLog.info("MONTratamientosContablesBean.getCabeceraDocumentoContableLocalHome(): Entrada");
		CabeceraDocumentoContableLocalHome cabeceraDocumentoContableLocalHome = (CabeceraDocumentoContableLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/CabeceraDocumentoContable");
		UtilidadesLog.info("MONTratamientosContablesBean.getCabeceraDocumentoContableLocalHome(): Salida");
		return cabeceraDocumentoContableLocalHome;
    }

    private MONMantenimientoMF getMONMantenimientoMF() throws MareException {
	
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONMantenimientoMF(): Entrada");
       MONMantenimientoMFHome home = (MONMantenimientoMFHome)UtilidadesEJB.getHome(
        "MONMantenimientoMF", MONMantenimientoMFHome.class);
            
        // Se obtiene el interfaz remoto
       MONMantenimientoMF ejb = null;
        try {
		
            ejb = home.create();
			
        } catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONMantenimientoMF",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			
        } 
		
		UtilidadesLog.info("MONTratamientosContablesBean.getMONMantenimientoMF(): Salida");
        return ejb;
	}

    private MONFacturacionLocal getMONFacturacionLocal() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONFacturacionLocal(): Entrada");
        MONFacturacionLocalHome localHome = (MONFacturacionLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONFacturacion");
       
        // Se obtiene el interfaz remoto
        MONFacturacionLocal ejb = null;
        try {
			ejb = localHome.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONFacturacionLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONTratamientosContablesBean.getMONFacturacionLocal(): Salida");
        return ejb;
	}

    private AccesoLocalHome getAccesoLocalHome() throws MareException {
        return new AccesoLocalHome();
    }


    private String[] obtenerAnioMesDia(java.util.Date fechaEntrada){

		UtilidadesLog.info("MONTratamientosContablesBean.obtenerAnioMesDia(java.util.Date fechaEntrada): Entrada");

		String fecha[] = new String[3];
		
		//Obtenemos la fecha en formato aaaa-mm-dd
		java.sql.Date fechaSql =  new java.sql.Date(fechaEntrada.getTime());

		StringTokenizer st=new StringTokenizer(fechaSql.toString(),"-");
		if (st.countTokens()>0){	

			String anio=st.nextToken().toString();
			fecha[0] = anio.substring(anio.length()-2);
			String mes=st.nextToken().toString();
			fecha[1] = mes;
			String dia=st.nextToken().toString();
			fecha[2] = dia;
				
		}

		UtilidadesLog.info("MONTratamientosContablesBean.obtenerAnioMesDia(java.util.Date fechaEntrada): Salida");
		
		return fecha;
	}

    private PaisLocalHome getPaisLocalHome() throws MareException {
        return new PaisLocalHome();
    }

    private MONFacturacionLocalHome getMONFacturacionLocalHome() throws NamingException
    {
        UtilidadesLog.info("MONTratamientosContablesBean.getMONFacturacionLocalHome(): Entrada");
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONTratamientosContablesBean.getMONFacturacionLocalHome(): Salida");
        return (MONFacturacionLocalHome)context.lookup("java:comp/env/ejb/local/MONFacturacion");
    }

    private MensajesFacturacionLocalHome getMensajesFacturacionLocalHome() throws MareException {
        return new MensajesFacturacionLocalHome();
   }

    private PeriodoLocalHome getPeriodoLocalHome() throws MareException {
       return new PeriodoLocalHome();
    }

    private TipoViaLocalHome getTipoViaLocalHome() throws MareException {
        return new TipoViaLocalHome();
    }

    private String mostrarArrayList(ArrayList arrayDesgloses) throws MareException
    {
        Iterator iteraTempo = arrayDesgloses.iterator();
        //String registros = "#-";
        
        //while(iteraTempo.hasNext()){
        //    Desglose registro = (Desglose)iteraTempo.next();
        //    String registroS = "Fecha vto: " + registro.getFechaVto().toString() + 
        //                      " ImporteCuotaFracDoc: " + registro.getImporteCuotaFracDoc().toString() +
        //                      " ImporteCuotaFracLocal: " + registro.getImporteCuotaFracLocal().toString() +
        //                      " NumeroOrden: " + registro.getNumeroOrden().toString() + 
        //                      " OidMedioPago: " + registro.getOidMedioPago().toString() + "-#-";
        //    registros += registroS;
        //}
        
        StringBuffer registros = new StringBuffer("#-");
        while(iteraTempo.hasNext()) {
            Desglose registro = (Desglose)iteraTempo.next();
            registros.append("Fecha vto: ");
            if (registro.getFechaVto() != null) {
                registros.append(registro.getFechaVto().toString());
            } else {
                registros.append("null");
            }
            registros.append(" ImporteCuotaFracDoc: ");
            if (registro.getImporteCuotaFracDoc() != null) {
                registros.append(registro.getImporteCuotaFracDoc().toString());
            } else {
                registros.append("null");
            }            
            registros.append(" ImporteCuotaFracLocal: ");
            if (registro.getImporteCuotaFracLocal() != null) {
                registros.append(registro.getImporteCuotaFracLocal().toString());
            } else {
                registros.append("null");
            }            
            registros.append(" NumeroOrden: ");
            if (registro.getNumeroOrden() != null) {
                registros.append(registro.getNumeroOrden().toString());
            } else {
                registros.append("null");
            }
            registros.append(" OidMedioPago: ");
            if (registro.getOidMedioPago() != null) {
                registros.append(registro.getOidMedioPago().toString());
            } else {
                registros.append("null");
            }
            registros.append("-#-");
        }
        
        return registros.toString();
    }   

   
    
    private MONTratamientosContablesLocal getMONTratamientosContablesLocal() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONProcesosFacturacionLocal(): Entrada");
        MONTratamientosContablesLocalHome localHome = (MONTratamientosContablesLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONTratamientosContables");
        // Se obtiene el interfaz remoto
        MONTratamientosContablesLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONTratamientosContablesLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONTratamientosContablesBean.getMONProcesosFacturacionLocal(): Salida");
        return ejb;
    }

    private MONTratamientosContablesHome getMONTratamientosContablesHome() throws NamingException{
      final InitialContext context = new InitialContext();
      return (MONTratamientosContablesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/ejb/MONTratamientosContables"), MONTratamientosContablesHome.class);
    }

    private FormulariosTipoSolicitudLocalHome getFormulariosTipoSolicitudLocalHome() throws MareException {
      return new FormulariosTipoSolicitudLocalHome();
    }

    private ClienteTipoSubTipoLocalHome getClienteTipoSubTipoLocalHome() throws MareException {
      return new ClienteTipoSubTipoLocalHome();  
    }

    private MONCuentasCorrientesPerf getMONCuentasCorrientesPerf() throws MareException {
	
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONTratamientosContablesBean.getMONCuentasCorrientes(): Entrada");
        MONCuentasCorrientesPerfHome home = (MONCuentasCorrientesPerfHome)UtilidadesEJB.getHome(
        "MONCuentasCorrientesPerf", MONCuentasCorrientesPerfHome.class);
            
        // Se obtiene el interfaz remoto
        MONCuentasCorrientesPerf ejb = null;
        try {
		
            ejb = home.create();
			
        } catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONCuentasCorrientes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			
        } 
		
		UtilidadesLog.info("MONTratamientosContablesBean.getMONCuentasCorrientes(): Salida");
        return ejb;
	}	

    //jrivas 17/10/2006
  /**
   * CHANGELOG
   * ---------
   * 02/06/2009 - dmorello, Cambio 20090923
   *    - El documento tendra la misma direccion que el consolidado, no la principal del cliente
   * 08/07/2009 - dmorello, Cambio 20090923
   *    - Se busca la info de la direccion en BD y no entre las direcciones recuperadas junto con la info del cliente
   */
  public void grabarDocumentoContableBatch(DTOFACConsolidado dtoConsolidado) throws MareException    {
    UtilidadesLog.info("MONTratamientosContablesBean.grabarDocumentoContableBatch(DTOFACConsolidado dtoConsolidado): Entrada");
    Long oidCabeceraDocumentoLegal;
    BelcorpService bs = null;
    hashCatalogos = new Hashtable();
    
    // sapaza -- PER-SiCC-2011-0053 -- 20/01/2011
   
   //SB PER-SiCC-2012-0266 03/04/2012
   //Long suma = getNumUnidadCompra(dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud());//SI ES NULO DEVUELVE CERO
    //if(suma == 0) {
     if(dtoConsolidado.getDtoCabecera().getNumeroUnidadesAtendidasTotal().longValue() == 0) {
      UtilidadesLog.debug("getNumeroUnidadesAtendidasTotal es cero");
      UtilidadesLog.info("MONTratamientosContablesBean.grabarDocumentoContableBatch(DTOFACConsolidado dtoConsolidado): Salida");
      return;
    }
    
    try {
      bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
      throw e;
    }    
	try {
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
        UtilidadesLog.debug("DTOConsolidado que le llega al metodo = " + dtoConsolidado);
      String usuario = ctx.getCallerPrincipal().getName();
      DTOFACCabeceraSolicitud consolidado = null;
      consolidado = dtoConsolidado.getDtoCabecera();
            
      Long oidIdioma = ConstantesSEG.IDIOMA_DEFECTO;
      Long oidPais = consolidado.getOidPais();
      Boolean indicadorImpuestosIncluidos = this.obtenerIndicadorImpuestoIncluidos(oidPais);
            
      ArrayList listaSolicitudes = null;
      ArrayList listaPosiciones = null;
            
      listaSolicitudes = dtoConsolidado.getListaSolicitudes();
      listaPosiciones = dtoConsolidado.getListaPosiciones();
            
      String descTipoVia=null; //añadido por incidencia 21005
      String dirCompleta="";
      ArrayList listaPosicionesDocumentoContable = new ArrayList();
      Float sumaTotalAPagarLocal = new Float("0");
      Float sumaTotalAPagarDocumento = new Float("0");
      Float tempSumaTotalAPagarLocal = new Float("0");
      Float tempSumaTotalAPagarDocumento = new Float("0");
      Integer numeroFacturasGeneradas = new Integer("0");

      Integer numeroPaginas = new Integer("0");

      ParametrosFacturacionLocal parametrosFacturacionLocal= null;
      ParametrosFacturacionLocalHome parametrosFacturacionLocalHome = this.getParametrosFacturacionLocalHome();
      try {
        Collection colParametrosFacturacion = parametrosFacturacionLocalHome.findByPais(consolidado.getOidPais());
        if (colParametrosFacturacion.size() == 0) {
          UtilidadesLog.error("*** Error en grabarDocumentoContable: No se obtienen parametros de facturacion ***");
          String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }
        Iterator itParametrosFacturacion = colParametrosFacturacion.iterator();
        parametrosFacturacionLocal = (ParametrosFacturacionLocal)itParametrosFacturacion.next();
        if (parametrosFacturacionLocal.getEsDocumentoMonopagina().longValue() == 1 ) {
          this.esDocumentoMonopagina = Boolean.TRUE;
        } else {
          this.esDocumentoMonopagina = Boolean.FALSE;
        }
        UtilidadesLog.debug("esDocumentoMonopagina " + esDocumentoMonopagina);
      } catch (NoResultException ex) {
        UtilidadesLog.error("*** Error en grabarDocumentoContable: finderException",ex);
        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }

      this.hashTiposDocumento = this.recuperarTiposDocumento(dtoConsolidado);

      UtilidadesLog.debug("*** Comienza la obtencion de datos de clientes ***");       
      DAOMAEMaestroClientes daoMAEMaestroClientes = new DAOMAEMaestroClientes(usuario);
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOid(consolidado.getReceptorFactura());
      dtoOid.setOidPais(oidPais);
      dtoOid.setOidIdioma(oidIdioma);
      DTOCliente dtoCliente = daoMAEMaestroClientes.obtenerClienteBatch(dtoOid);
        
      String nombre1 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getNombre1();
      String nombre2 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getNombre2();
      String apellido1 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getApellido1();
      String apellido2 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getApellido2();
        
      // Cambio 20090923 - dmorello, 08/07/2009 - Busco la info de la direccion del consolidado
      Long oidDireccionConsolidado = dtoConsolidado.getDtoCabecera().getOidDireccionCliente();
      DTODireccion direccion = daoMAEMaestroClientes.obtenerDireccionPorOID(oidDireccionConsolidado);
    
      TipoViaLocalHome tipoVia = this.getTipoViaLocalHome();
      TipoViaLocal tipoViaLocal=null;
      try {
        tipoViaLocal = tipoVia.findByPrimaryKey(direccion.getTipoVia());
        descTipoVia = tipoViaLocal.getDescAbreTipoVia();
      } catch (NoResultException ex){
        UtilidadesLog.error("*** Error en grabarDocumentoContable: NoResultException",ex);
        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      } catch (PersistenceException ex) {
          UtilidadesLog.error("*** Error en grabarDocumentoContable: PersistenceException",ex);
          String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      // Fin cambio 20090923 - dmorello, 08/07/2009
      
      DTOIdentificacion listaIdentificaciones []  = null;
      listaIdentificaciones = ((DTOCrearClienteBasico)dtoCliente.getBase()).getIdentificaciones();
      ArrayList temp = new ArrayList();
      
      for (int i=0; i<listaIdentificaciones.length; i++) {
        temp.add(listaIdentificaciones[i]);
      }
      
      Iterator iteratorListaID = temp.iterator();
      DTOIdentificacion identificacion = null;
      String numeroIdentificacionNacional = null;
      String numeroIdentificacionFiscal = null;
      
      while (iteratorListaID.hasNext()) {
        identificacion = (DTOIdentificacion)iteratorListaID.next();
        TipoDocumentoLocal tipoDocumentoLocal = null;
        TipoDocumentoLocalHome tipoDocumentoLocalHome = this.getTipoDocumentoLocalHome();
        try {
          tipoDocumentoLocal = tipoDocumentoLocalHome.findByPrimaryKey(identificacion.getTipoDocumento());
        } catch (NoResultException ex) {
          UtilidadesLog.error("*** Error en grabarDocumentoContable: finderException",ex);
          String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
          throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        } 
        if (tipoDocumentoLocal.getInd_dni() != null) {
          if (tipoDocumentoLocal.getInd_dni().longValue() == 1) {
            UtilidadesLog.debug("Entra identificacion nacional");
            numeroIdentificacionNacional = identificacion.getNumeroDocumento();
            UtilidadesLog.debug("numeroIdentificacionNacional: "+numeroIdentificacionNacional);
          }
        }
                
        if (tipoDocumentoLocal.getInd_doc_iden_fisc() != null ) {
          if (tipoDocumentoLocal.getInd_doc_iden_fisc().longValue()==1) {
            numeroIdentificacionFiscal = identificacion.getNumeroDocumento();
            UtilidadesLog.debug("numeroIdentificacionNacional: "+numeroIdentificacionNacional);
          }
        }
        
        // sapaza -- PER-SiCC-2011-0092 -- 09/02/2011
        if(identificacion.getEsPrincipal().booleanValue()){
            break;
        }
      }
      
      if (numeroIdentificacionFiscal == null) {
        String strError = "---> No se ha encontrado el numeroIdentificacionFiscal para el cliente = " + consolidado.getReceptorFactura();
        UtilidadesLog.error(strError);
        LogAPP.info(strError); 
        throw new MareException(strError);                
      }
      UtilidadesLog.debug("*** Despues de obtener datos de clientes ***");
     
      ArrayList listaPosicionesDoc = null;
      ArrayList listaPosicionesDocOrden = null;
      ArrayList lineasDocumentosContableGrabar = new ArrayList();
      ArrayList updatesCabeceras = new ArrayList();
      ArrayList lineasSecuenciaDocumentos = new ArrayList();
      ArrayList arrayDTOMensaje = new ArrayList();
      DTOFACDocumentoSubacceso dtoDatos = null;
      DTOFACCabeceraDocContable dtoDocContableTemp  = new DTOFACCabeceraDocContable();
      numeroFacturasGeneradas = new Integer("0");
      ArrayList listaPosicionesDocContable = new ArrayList();
      Boolean indFlete = new Boolean(true);
      

      Iterator itTiposDocumento = (Iterator)((Collection)this.hashTiposDocumento.values()).iterator();      
      while (itTiposDocumento.hasNext()) {//1
        
        DatosTipoDocumento datos = (DatosTipoDocumento)itTiposDocumento.next();
        listaPosicionesDoc = datos.getListaPosiciones();       
        listaPosicionesDocOrden = this.ordenarListaPosicionesDoc(listaPosicionesDoc);        
        datos.setListaPosiciones(listaPosicionesDocOrden);
        numeroPaginas = new Integer("0");
        Long oidConcursoSolicitud = null;
          
        Iterator listaTempIterator = listaPosicionesDocOrden.iterator();
        UtilidadesLog.debug("Se inserta la cabecera de documento contable.");
        MONTratamientosContables monT =  getMONTratamientosContablesHome().create();
        while (listaTempIterator.hasNext()) {//2
          numeroPaginas = new Integer(numeroPaginas.intValue() + 1);
          UtilidadesLog.debug("numeroPaginas = "+ numeroPaginas);
          numeroFacturasGeneradas = new Integer(numeroFacturasGeneradas.intValue() + 1);
          UtilidadesLog.debug("numeroFacturasGeneradas = "+ numeroFacturasGeneradas);
          UtilidadesLog.debug("*** Asignaciones ***");		
          dtoDocContableTemp.setOidCliente(consolidado.getReceptorFactura());
          dtoDocContableTemp.setNumeroDecimalesRedondeo(consolidado.getNumeroDecimalesRedondeo());
          dtoDocContableTemp.setOidCabeceraSolicitud(consolidado.getOidCabeceraSolicitud());                     
          dtoDocContableTemp.setOidPais(consolidado.getOidPais());
          dtoDocContableTemp.setSubgerencia(consolidado.getOidSubgVentas());
          dtoDocContableTemp.setRegion(consolidado.getRegion());
          dtoDocContableTemp.setSeccion(consolidado.getSeccion());
          dtoDocContableTemp.setZona(consolidado.getZona());
          dtoDocContableTemp.setTerritorio(consolidado.getTerritorio());
          dtoDocContableTemp.setNombre1(nombre1);
          dtoDocContableTemp.setNombre2(nombre2);
          dtoDocContableTemp.setApellido1(apellido1);
          dtoDocContableTemp.setApellido2(apellido2);
          dtoDocContableTemp.setOidClienteDireccion(direccion.getOid());
          dtoDocContableTemp.setSubacceso(consolidado.getSubacceso());
          dtoDocContableTemp.setEstado(new Long("1"));
          dtoDocContableTemp.setMarca(consolidado.getMarca());
          dtoDocContableTemp.setPeriodo(consolidado.getPeriodo());
          dtoDocContableTemp.setFechaEmision(new Date(System.currentTimeMillis()));            
          dtoDocContableTemp.setPuntoEmision(consolidado.getPuntoEmision());
          dtoDocContableTemp.setFechaFacturacion(consolidado.getFechaFacturacion());
          dtoDocContableTemp.setOidFormulario(datos.getOidFormulario());
          dtoDocContableTemp.setTipoDocumento(datos.getOidTipoDocumento());
          
          dtoDocContableTemp.setNumeroDocumentoReferencia(consolidado.getNumeroDocumentoReferencia());
          dtoDocContableTemp.setNumeroIdentificacionFiscal(numeroIdentificacionFiscal);
          dtoDocContableTemp.setNumeroIdentificacionNacional(numeroIdentificacionNacional);
          dtoDocContableTemp.setNumeroAbono(null);
          dtoDocContableTemp.setNumeroDocumentoOrigen(consolidado.getNumeroDocumentoOrigen());
          // Modificado por SICC20070410 - Rafael Romero - 11/09/2007
          //dtoDocContableTemp.setObservaciones(consolidado.getObservaciones());
          dtoDocContableTemp.setObservaciones(datos.getObservaciones());
          // Fin modificado SICC20070410
          dtoDocContableTemp.setSociedad(consolidado.getSociedad());
          dtoDocContableTemp.setFormaPago(consolidado.getFormaPago());
          dtoDocContableTemp.setMoneda(consolidado.getMoneda());
          dtoDocContableTemp.setTipoCambio(consolidado.getTipoCambio());
          dtoDocContableTemp.setIndicadorImpresion(Boolean.FALSE);
          dtoDocContableTemp.setIndicadorImpuestosFlete(consolidado.getIndicadorImpuestosFlete());
          dtoDocContableTemp.setAlmacen(consolidado.getAlmacen());
          if ((consolidado.getIndicadorExentoFlete() != null) && (consolidado.getIndicadorExentoFlete().booleanValue())) {
            dtoDocContableTemp.setIndicadorExentoFlete(Boolean.TRUE);
          } else {
            dtoDocContableTemp.setIndicadorExentoFlete(Boolean.FALSE);
          }
          
          if (consolidado.getIndicadorDireccionSeparada().booleanValue()) {
              if (descTipoVia != null) {
                dirCompleta += descTipoVia;  
              }
              if (direccion.getNombreVia()!= null) {
                dirCompleta += " " + direccion.getNombreVia();
              }
              if (direccion.getNumeroPrincipal() != null) {
                dirCompleta += " " + direccion.getNumeroPrincipal().toString();
              }
              if (direccion.getObservaciones()!= null) {
                dirCompleta += " " + direccion.getObservaciones();
              }
              dirCompleta=dirCompleta.trim();
              if (dirCompleta.length() > 140) {
                UtilidadesLog.debug("Long. dirCompleta es " + dirCompleta.length() + ", se trunca a 140");
                dirCompleta = dirCompleta.substring(0,140); 
              }
              UtilidadesLog.debug("La direccion completa es: "+dirCompleta);
          } else {                
              if (direccion.getObservaciones()!= null) {
                dirCompleta = direccion.getObservaciones();
              }
          }
          
          dtoDocContableTemp.setDireccionCompleta(dirCompleta);
          dirCompleta="";
          UtilidadesLog.debug("Fin asignaciones parcial.");       
            // Los campos siguientes sólo se insertarán si se está creando la primera cabecera 
            // de documento contable del consolidado. En las siguientes cabeceras se pondrán a cero
            
            //Agregado por SiCC20070484 - Rafael Romero - 07/11/2007
            boolean primeraNotaCreditoAsignable = true;
            if((datos.getCodigoTipoDocumento().equals("020")||
                    datos.getCodigoTipoDocumento().equals("021")||
                    datos.getCodigoTipoDocumento().equals("022"))&&
                    datos.getOidTipoConcursoPrograma()!=null){
                primeraNotaCreditoAsignable = false;
            }
            // Fin agregado SiCC20070484
          if (indFlete.booleanValue() && !datos.getCodigoTipoDocumento().equals("012") && primeraNotaCreditoAsignable) { // Modificado SiCC20070484
            if (consolidado.getImporteFleteTotalLocal()!=null)
              dtoDocContableTemp.setImporteFleteTotalLocal(consolidado.getImporteFleteTotalLocal());
            if (consolidado.getImporteFleteSinImpuestosTotalLocal()!=null)
              dtoDocContableTemp.setImporteFleteSinImpuestosTotalLocal(consolidado.getImporteFleteSinImpuestosTotalLocal());
            if (consolidado.getImporteDescuento3TotalLocal()!=null)
              dtoDocContableTemp.setImporteDescuento3TotalLocal(consolidado.getImporteDescuento3TotalLocal());
            if (consolidado.getImporteFleteTotalDocumento()!=null)
              dtoDocContableTemp.setImporteFleteTotalDocumento(consolidado.getImporteFleteTotalDocumento());
            if (consolidado.getImporteFleteSinImpuestosTotalDocumento()!=null)
              dtoDocContableTemp.setImporteFleteSinImpuestosTotalDocumento(consolidado.getImporteFleteSinImpuestosTotalDocumento());
            if (consolidado.getImporteDescuento3TotalDocumento()!=null)
              dtoDocContableTemp.setImporteDescuento3TotalDocumento(consolidado.getImporteDescuento3TotalDocumento());
            indFlete = new Boolean(false);  
          } else {
            dtoDocContableTemp.setImporteFleteTotalLocal(new Float("0"));
            dtoDocContableTemp.setImporteFleteSinImpuestosTotalLocal(new Float("0"));
            dtoDocContableTemp.setImporteDescuento3TotalLocal(new Float("0"));
            dtoDocContableTemp.setImporteFleteTotalDocumento(new Float("0"));
            dtoDocContableTemp.setImporteFleteSinImpuestosTotalDocumento(new Float("0"));
            dtoDocContableTemp.setImporteDescuento3TotalDocumento(new Float("0"));
          }
          dtoDocContableTemp.setOidTipoConcursoPrograma(datos.getOidTipoConcursoPrograma());          
          /* Agregado por Cambio FAC-001 ------ AL */
          dtoDocContableTemp.setIVAasumidoEmpresa(consolidado.getIVAasumidoEmpresa());
          /* Agregado por Cambio FAC-001 ------ AL */

          oidCabeceraDocumentoLegal = this.grabarCabeceraDocumentContableBatch(dtoDocContableTemp, bs);
          dtoDocContableTemp.setOidCabeceraSolicitud(oidCabeceraDocumentoLegal);
          dtoDocContableTemp.setTasaImpuestoFlete(consolidado.getTasaImpuestoFlete());
                    
          UtilidadesLog.debug("*** Se insertan los registros de posicion ***");
          Integer contadorLineas = new Integer("0");
          Integer numeroLinea = new Integer("1");
          DTOFACPosicionSolicitud posicion = null;
          listaPosicionesDocContable.clear();
          while (listaTempIterator.hasNext() ) {   
            posicion =(DTOFACPosicionSolicitud)listaTempIterator.next();
            if (posicion.getEstado() == null) {
              UtilidadesLog.debug("El estado de la posicion es null y se lanza una excepcion");
              throw new MareException("El estado de la posición es null");
            }
            UtilidadesLog.debug("El estado es: "+posicion.getEstado());
            UtilidadesLog.debug("El valor de la constante de ped es: "+ConstantesPED.ESTADO_POSICION_ANULADO);
            UtilidadesLog.debug("El indicador no imprimible es: "+posicion.getIndicadorNoImprimible());
                        
            if (posicion.getEstado().longValue() != ConstantesPED.ESTADO_POSICION_ANULADO.longValue()) {
              
              UtilidadesLog.debug("esMono " + datos.getMonoPagina().booleanValue() );                            
              if (( !(datos.getMonoPagina().booleanValue()) ) ||( contadorLineas.intValue() < datos.getNumeroLineasPorPagina().intValue()) || posicion.getIndicadorNoImprimible().booleanValue() ) {               
                try {
                  if (posicion.getUnidadesAtendidas() == null) {
                    posicion.setUnidadesAtendidas(new Integer(0));
                  }
                   lineasDocumentosContableGrabar.add((StringBuffer)this.armarLineaDocumentoContable(posicion, oidCabeceraDocumentoLegal, numeroLinea, dtoDocContableTemp.getMoneda()));
                } catch (Exception e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("*** Error en grabarDocumentoContableBatch al crear la linea de doc contable",e);
                  String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                  throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
                }
                                   
                listaPosicionesDocContable.add((DTOFACPosicionDocContable)this.armarDtoPosicionDocumentoContable(posicion, dtoDocContableTemp.getOidCabeceraSolicitud()));                                                      


                /* Se Modifica para una mejor Performance del Proceso ----- 09/08/2007 ----- AL */
                //  Agregado por HRCS - Fecha 12/07/2007 - Incidencia Sicc20070353
                //  Se actualiza el indicador de Matriz Facturada para la posicion con OidDetalleOferta
                // this.actualizaMatrizFactuPorOidOferta( posicion.getOidDetaOferta() , bs );
                updatesCabeceras.add(this.generarStringUpdateMatriz(posicion.getOidDetaOferta()));
                /* Se Modifica para una mejor Performance del Proceso ----- 09/08/2007 ----- AL */
                
                                
                if (posicion.getIndicadorNoImprimible().booleanValue()) {
                  if (posicion.getUnidadesComprometidas() != null && ! posicion.getUnidadesComprometidas().equals(new Integer(0))) {
                    UtilidadesLog.debug("posicion : " + posicion.getOidPosicion() + ", de solicitud: " + posicion.getOidCabecera() + " es no imprimible, se genera mensaje de ProductoFueraDocumento");
                                        
                    DTOFACPosicionDocContable dtoPDCMensaje = new DTOFACPosicionDocContable();
                    dtoPDCMensaje.setCodigoVenta(posicion.getCodigoVenta());
                    dtoPDCMensaje.setDescripcionSAP(obtenerDescripcionI18NProducto(posicion.getProducto(),oidIdioma));
                    dtoPDCMensaje.setUnidadesComprometidas(posicion.getUnidadesComprometidas());
                    dtoPDCMensaje.setCodigoTipoOferta(posicion.getCodigoTipoOferta());
                    if(posicion.getIndicadorDentroFueraCajaBolsa() == null) {
                      dtoPDCMensaje.setIndicadorDentroFueraCajaBolsa("C");
                    } else {
                      dtoPDCMensaje.setIndicadorDentroFueraCajaBolsa(posicion.getIndicadorDentroFueraCajaBolsa());
                    }
                    arrayDTOMensaje.add(this.generarDTOMensaje(dtoDocContableTemp,dtoPDCMensaje));
                  } else {
                    UtilidadesLog.debug("posicion : " + posicion.getOidPosicion() + ", de solicitud: " + posicion.getOidCabecera() + " tiene unidades comprometidas == 0, no se genera mensaje de ProductoFueraDocumento");
                  }
                } else {
                
                  if (posicion.getUnidadesAtendidas().longValue() != 0) {
                      Integer intTemp1 = new Integer(contadorLineas.intValue() + 1);
                      contadorLineas = intTemp1;
                      
                      if(datos.getOidTipoConcursoPrograma()!=null && datos.getCodigoTipoConcursoPrograma().equalsIgnoreCase("B") &&
                         (datos.getCodigoTipoDocumento().equalsIgnoreCase("012") || datos.getCodigoTipoDocumento().equalsIgnoreCase("020"))){
                      
                          if((oidConcursoSolicitud == null) || (oidConcursoSolicitud.longValue() != posicion.getOidConcursoSolicitud().longValue())) {
                              intTemp1 = new Integer(contadorLineas.intValue() + 1);
                              contadorLineas = intTemp1;
                              oidConcursoSolicitud = posicion.getOidConcursoSolicitud();
                          }
                      } 
                  }
                }
                                
                Integer intTemp = new Integer(numeroLinea.intValue() + 1);
                numeroLinea = intTemp;

                listaPosicionesDocOrden.remove(0);
                listaTempIterator = listaPosicionesDocOrden.iterator();                  
                UtilidadesLog.debug("**** Quedan "+ listaPosicionesDocOrden.size() + "por procesar para el tipoDocumento = " + datos.getOidTipoDocumento());  
                
              } else {                
                listaTempIterator = listaPosicionesDocOrden.iterator();
                UtilidadesLog.debug("*** Se ha completado una cabecera ***");
                break; 
              }
            } else {//fin if estado 
              listaPosicionesDocOrden.remove(0);
              listaTempIterator = listaPosicionesDocOrden.iterator();                  
              UtilidadesLog.debug("**** Quedan "+ listaPosicionesDocOrden.size() + "por procesar para el tipoDocumento = " + datos.getOidTipoDocumento());  
            }
          } //fin while

          DTOFACCalculosImpuestosEntrada dtoCalculosImpuestosE =  new DTOFACCalculosImpuestosEntrada();
          dtoCalculosImpuestosE.setDtoConsolidado(dtoDocContableTemp);
          dtoCalculosImpuestosE.setListaPosiciones(listaPosicionesDocContable);
          dtoCalculosImpuestosE.setIndicadorCalculo(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)));
          dtoCalculosImpuestosE.setMoneda(dtoDocContableTemp.getMoneda());
          if (dtoDocContableTemp.getTipoCambio() != null) {
            dtoCalculosImpuestosE.setTipoCambio(new Float(dtoDocContableTemp.getTipoCambio().floatValue()));
          }
          dtoCalculosImpuestosE.setIndicadorImpuestosIncluidos(indicadorImpuestosIncluidos);
          dtoCalculosImpuestosE.setImporteFleteSinImpuestosTotalLocal(dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal());
          dtoCalculosImpuestosE.setImporteFleteSinImpuestosTotalDocumento(dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento());
          dtoCalculosImpuestosE.setIndicadorImpuestoFlete(dtoDocContableTemp.getIndicadorImpuestosFlete());
          if (datos.getCodigoTipoConcursoPrograma() != null) {
            dtoCalculosImpuestosE.setCodigoTipoProgramaConcurso(datos.getCodigoTipoConcursoPrograma().toString());  
          }
          dtoCalculosImpuestosE.setTasaImpuestoFlete(dtoDocContableTemp.getTasaImpuestoFlete());
          
          DTOFACCalculosImpuestosSalida dtoCalculosImpuestosS = null;
          MONFacturacionLocal monFacturacion = this.getMONFacturacionLocal();
          DTOFACCalculosCabeceraSalida dtoCalculosCabeceraS = null;
        
          dtoCalculosImpuestosS = monFacturacion.realizarCalculosImpuestos(dtoCalculosImpuestosE);
 
          DTOFACCalculosCabeceraEntrada dtoCalculosCabeceraE =  new DTOFACCalculosCabeceraEntrada();
          dtoCalculosCabeceraE.setDtoConsolidado(dtoDocContableTemp);
          dtoCalculosCabeceraE.setListaPosiciones(listaPosicionesDocContable);
          dtoCalculosCabeceraE.setIndicadorCalculo(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)));
          dtoCalculosCabeceraE.setMoneda(dtoDocContableTemp.getMoneda());
          if (dtoDocContableTemp.getTipoCambio() != null) {
            dtoCalculosCabeceraE.setTipoCambio(new Float(dtoDocContableTemp.getTipoCambio().floatValue()));
          }
          dtoCalculosCabeceraE.setIndicadorImpuestosIncluidos(indicadorImpuestosIncluidos);
          dtoCalculosCabeceraE.setBaseImponibleDescuento3Local(dtoCalculosImpuestosS.getBaseImponibleDescuento3Local());
          dtoCalculosCabeceraE.setBaseImponibleDescuento3Documento(dtoCalculosImpuestosS.getBaseImponibleDescuento3Documento());
          dtoCalculosCabeceraE.setBaseImponiblePrecioContableLocal(dtoCalculosImpuestosS.getBaseImponiblePrecioContableLocal());
          dtoCalculosCabeceraE.setBaseImponiblePrecioContableDocumento(dtoCalculosImpuestosS.getBaseImponiblePrecioContableDocumento());
          dtoCalculosCabeceraE.setTotalBaseImponibleLocal(dtoCalculosImpuestosS.getTotalBaseImponibleLocal());
          dtoCalculosCabeceraE.setTotalBaseImponibleDocumento(dtoCalculosImpuestosS.getTotalBaseImponibleDocumento());
          dtoCalculosCabeceraE.setTotalImporteLocal(dtoCalculosImpuestosS.getTotalImporteLocal());
          dtoCalculosCabeceraE.setTotalImporteDocumento(dtoCalculosImpuestosS.getTotalImporteDocumento());
          dtoCalculosCabeceraE.setTotalImpuestosLocal(dtoCalculosImpuestosS.getTotalImpuestosLocal());
          dtoCalculosCabeceraE.setTotalImpuestosDocumento(dtoCalculosImpuestosS.getTotalImpuestosDocumento());
          if (datos.getCodigoTipoConcursoPrograma() != null) {
            dtoCalculosCabeceraE.setCodigoTipoProgramaConcurso(datos.getCodigoTipoConcursoPrograma().toString());
          }
          dtoCalculosCabeceraS = monFacturacion.realizarCalculosCabecera(dtoCalculosCabeceraE);
                    
          updatesCabeceras.add(this.generarUpdateCabeceraDocumentoContable(oidCabeceraDocumentoLegal, dtoCalculosCabeceraS));
          
          if (dtoDocContableTemp.getOidTipoConcursoPrograma() == null) {
              tempSumaTotalAPagarLocal = new Float(sumaTotalAPagarLocal.floatValue() + dtoCalculosCabeceraS.getTotalAPagarLocal().floatValue());
              sumaTotalAPagarLocal = tempSumaTotalAPagarLocal;
              UtilidadesLog.debug("SumaTotalAPagarLocal es: "+sumaTotalAPagarLocal);
    
              tempSumaTotalAPagarDocumento = new Float(sumaTotalAPagarDocumento.floatValue() + dtoCalculosCabeceraS.getTotalAPagarDocumento().floatValue());
              sumaTotalAPagarDocumento = tempSumaTotalAPagarDocumento;
          }
        } //2 Fin Proceso de las Posiciones de Tipo Documento Actual
        
        lineasSecuenciaDocumentos.add(this.armarFacSecuenciaDocum(numeroPaginas, consolidado.getOidCabeceraSolicitud(), datos.getOidTipoDocumento(), dtoConsolidado.getIDSpool(), consolidado.getNumeroSecuenciaImpresion(), datos.getOidTipoConcursoPrograma()));
      } //1 Fin Proceso por Tipo Documento Legal
      hashCatalogos.clear();
            
      this.grabarTodosLosMensajes(arrayDTOMensaje);

      updatesCabeceras.addAll(lineasDocumentosContableGrabar);
      updatesCabeceras.addAll(lineasSecuenciaDocumentos);
      this.grabarVariasLineasDocumentoContable(updatesCabeceras);
      updatesCabeceras = null;
      lineasDocumentosContableGrabar = null;
      lineasSecuenciaDocumentos = null;
      MONMantenimientoMF monMantenimientoMF = this.getMONMantenimientoMF();
      try {
          //  Agregado por HRCS - Fecha 18/05/2007 - Cambio Sicc20070235
          if (consolidado.getUnidadesAtendidasTotal()!=null && consolidado.getUnidadesAtendidasTotal().intValue()>0)   {            
            monMantenimientoMF.actualizarMatrizFacturada(consolidado.getPeriodo(),Boolean.TRUE);		
          }
      } catch (RemoteException ex) {
        UtilidadesLog.error("Error en actualizarMatrizFacturada", ex);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));			
      }
            
      Boolean actualizarRedondeoLocal = Boolean.FALSE;
      Boolean actualizarRedondeoDocumento = Boolean.FALSE;
      if (numeroFacturasGeneradas.intValue() > 1) {
        if (sumaTotalAPagarLocal.floatValue() - consolidado.getTotalAPagarLocal().floatValue() != 0) {
          UtilidadesLog.debug("Entra a comprobar valores redondeo");
          UtilidadesLog.debug("Total a pagar local redondeo es: "+consolidado.getTotalAPagarLocal());
          UtilidadesLog.debug("sumaTotalAPagarLocal: "+sumaTotalAPagarLocal);
          consolidado.setImporteRedondeoConsolidadoLocal(new Float(sumaTotalAPagarLocal.floatValue() - consolidado.getTotalAPagarLocal().floatValue()));
          consolidado.setTotalAPagarLocal(new Float(consolidado.getTotalAPagarLocal().floatValue() + consolidado.getImporteRedondeoConsolidadoLocal().floatValue()));
          actualizarRedondeoLocal = Boolean.TRUE;
          if ( (sumaTotalAPagarDocumento.floatValue() - consolidado.getTotalAPagarDocumento().floatValue()) != 0 ) {
            consolidado.setImporteRedondeoConsolidadoDocumento(new Float(sumaTotalAPagarDocumento.floatValue() - consolidado.getTotalAPagarDocumento().floatValue()));
            consolidado.setTotalAPagarDocumento(new Float(consolidado.getTotalAPagarDocumento().floatValue() + consolidado.getImporteRedondeoConsolidadoDocumento().floatValue()));
            actualizarRedondeoDocumento = Boolean.TRUE;
          }
        }
        if (actualizarRedondeoLocal.booleanValue() || actualizarRedondeoDocumento.booleanValue()) { 
          DAOSolicitudCabecera dao = new DAOSolicitudCabecera(); 
          dao.actualizarRedondeosConsolidado(consolidado, actualizarRedondeoLocal, actualizarRedondeoDocumento);
        }        
      }
    } catch (Exception e) {
      e.printStackTrace();
      if (e instanceof MareException){
        throw (MareException) e;
      }
      UtilidadesLog.error(e);    
      throw new MareException (e);
    }
    UtilidadesLog.info("MONTratamientosContablesBean.grabarDocumentoContableBatch(DTOFACConsolidado dtoConsolidado): Salida");
  }
    
     /* Modificado por Cambio FAC-001 ------ AL */
    private Long grabarCabeceraDocumentContableBatch( DTOFACCabeceraDocContable dtoDocContableTemp, BelcorpService bs) throws  MareException  {
        
        Long oid=SecuenciadorOID.obtenerSiguienteValor("FAC_DCCA_SEQ");
        Vector vector= new Vector();


      	StringBuffer query  = new StringBuffer( "INSERT INTO FAC_DOCUM_CONTA_CABEC (" +
        " OID_CABE, " +
        " ZZON_OID_ZONA , " +
        " ZSGV_OID_SUBG_VENT, " +
        " ZSCC_OID_SECC, " +
        " ZORG_OID_REGI, " +
        " TERR_OID_TERR, " +
        " SOCI_OID_SOCI, " +
        " FOPA_OID_FORM_PAGO, " +
        " CLDI_OID_CLIE_DIRE, " +
        " PAIS_OID_PAIS, " +
        " PERD_OID_PERI, " +
        " SBAC_OID_SBAC, " +
        " SOCA_OID_SOLI_CABE," + 
        " FORS_OID_FORM, " +
        " TIDO_OID_TIPO_DOCU, " +
        " FEC_EMIS, " +
        " FEC_FACT, " +
        " VAL_ESTA, " +
        " VAL_NOM1, " +
        " VAL_NOM2, " +
        " VAL_APE1, " +
        " VAL_APE2, "+
        " VAL_DIRE_COMP ");
         
        if (dtoDocContableTemp.getNumeroIdentificacionFiscal()!=null){
           query.append(",VAL_NUME_IDEN_FISC");
        }
        
        if(dtoDocContableTemp.getNumeroIdentificacionNacional() != null){
            query.append(",VAL_NUME_IDEN_NNAL");
        }
        if(dtoDocContableTemp.getPuntoEmision()!= null){
            query.append(",VAL_PUNT_EMIS");
        }
        if(dtoDocContableTemp.getObservaciones()!= null){
            query.append(",VAL_OBSE");
        }
        if(dtoDocContableTemp.getNumeroAbono()!= null){
            query.append(",NUM_ABON");
        }
        if(dtoDocContableTemp.getIndicadorImpresion()!= null){
            query.append(",IND_IMPR");
        }
        if(dtoDocContableTemp.getNumeroDocumentoOrigen()!= null){
            query.append(",NUM_DOCU_ORIG");
        }
        if(dtoDocContableTemp.getTipoDireccion()!= null){
            query.append(",VAL_TIPO_DIRE");
        }
        if(dtoDocContableTemp.getAlmacen()!= null){
            query.append(",VAL_ALMA");
        }

        if (dtoDocContableTemp.getImporteFleteTotalLocal()!=null){
            query.append(",IMP_FLET_TOTA_LOCA");
        }
        
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal()!=null){
            query.append(",IMP_FLET_IMPU_TOTA_LOCA");
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalLocal()!=null){
            query.append(",IMP_DES3_TOTAL_LOCA");
        }
        if (dtoDocContableTemp.getImporteFleteTotalDocumento()!=null){
          query.append(",IMP_FLET_TOTA_DOCU");
        }
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento()!=null){
          query.append(",IMP_FLET_SIN_IMPU_TOTA_DOCU");
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalDocumento()!=null){
          query.append(",IMP_DES3_TOTA_DOCU");
        }
        if (dtoDocContableTemp.getOidTipoConcursoPrograma() != null){
          query.append(",ICTP_OID_TIPO_PROG");
        }
        query.append(", VAL_TELE_FIJO");
        query.append(", VAL_TELE_CELU");
        query.append(", VAL_BARR");
        query.append(", VAL_IMPO_IVA_ASUM_EMPR");

        query.append(") VALUES (");

        query.append(oid + ",");
        query.append(dtoDocContableTemp.getZona()+ ",");
        query.append(dtoDocContableTemp.getSubgerencia()+ ",");
        query.append(dtoDocContableTemp.getSeccion()+ ",");
        query.append(dtoDocContableTemp.getRegion()+ ",");
        query.append(dtoDocContableTemp.getTerritorio()+ ",");
        query.append(dtoDocContableTemp.getSociedad()+ ",");
        query.append(dtoDocContableTemp.getFormaPago()+ ",");
        query.append(dtoDocContableTemp.getOidClienteDireccion()+ ",");
        query.append(dtoDocContableTemp.getOidPais()+ ",");
        query.append(dtoDocContableTemp.getPeriodo()+ ",");
        query.append(dtoDocContableTemp.getSubacceso()+ ",");
        query.append(dtoDocContableTemp.getOidCabeceraSolicitud()+ ",");
        query.append(dtoDocContableTemp.getOidFormulario()+ ",");
        query.append(dtoDocContableTemp.getTipoDocumento()+ ",");
      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
   	    /*Date fechaEmision = new java.sql.Date(dtoDocContableTemp.getFechaEmision().getTime()); 
	    String sFechaEmision = sdf.format(fechaEmision);  */
        query.append("SYSDATE,");
   	    Date fechaFact = new java.sql.Date(dtoDocContableTemp.getFechaFacturacion().getTime()); 
	    String sFechaFact = sdf.format(fechaFact);     
        query.append("TO_DATE('" + sFechaFact + "','YYYY-MM-DD'),");
        query.append(dtoDocContableTemp.getEstado() + ",");
        query.append("'").append(dtoDocContableTemp.getNombre1()!=null?dtoDocContableTemp.getNombre1():"").append("',");
        query.append("'").append(dtoDocContableTemp.getNombre2()!=null?dtoDocContableTemp.getNombre2():"").append("',");
        query.append("'").append(dtoDocContableTemp.getApellido1()!=null?dtoDocContableTemp.getApellido1():"").append("',");
        query.append("'").append(dtoDocContableTemp.getApellido2()!=null?dtoDocContableTemp.getApellido2():"").append("'," );
        query.append("'").append(dtoDocContableTemp.getDireccionCompleta()!=null?dtoDocContableTemp.getDireccionCompleta():"").append("'");

         
        if(dtoDocContableTemp.getNumeroIdentificacionNacional() != null){
            query.append(",'" + dtoDocContableTemp.getNumeroIdentificacionNacional()  + "'");
        }
        if (dtoDocContableTemp.getNumeroIdentificacionFiscal()!=null){
            if (dtoDocContableTemp.getNumeroIdentificacionFiscal().length() > 30){
                query.append(",'" +dtoDocContableTemp.getNumeroIdentificacionFiscal().substring(0,30) + "'");
            }else{
                query.append(",'" +dtoDocContableTemp.getNumeroIdentificacionFiscal() + "'");
            }
        }

        if(dtoDocContableTemp.getPuntoEmision()!= null){
            query.append(",'" + dtoDocContableTemp.getPuntoEmision()).append("'");
        }
        if(dtoDocContableTemp.getObservaciones()!= null){
            query.append(",'" + dtoDocContableTemp.getObservaciones() + "'");
        }
        if(dtoDocContableTemp.getNumeroAbono()!= null){
            query.append("," + new Integer(dtoDocContableTemp.getNumeroAbono().toString()));
        }
        if(dtoDocContableTemp.getIndicadorImpresion()!= null){
            if (dtoDocContableTemp.getIndicadorImpresion().booleanValue()) {
                query.append(",1");
            } else {
                query.append(",0");
            }
            
        }
        if(dtoDocContableTemp.getNumeroDocumentoOrigen()!= null){
            query.append("," + dtoDocContableTemp.getNumeroDocumentoOrigen());
        }
        if(dtoDocContableTemp.getTipoDireccion()!= null){
            query.append("," + dtoDocContableTemp.getTipoDireccion());
        }
        if(dtoDocContableTemp.getAlmacen()!= null){
            query.append("," + dtoDocContableTemp.getAlmacen().toString());
        }

        if (dtoDocContableTemp.getImporteFleteTotalLocal()!=null){
            query.append("," + dtoDocContableTemp.getImporteFleteTotalLocal());
        }
        
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal()!=null){
            query.append("," + dtoDocContableTemp.getImporteFleteSinImpuestosTotalLocal());
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalLocal()!=null){
          query.append("," + dtoDocContableTemp.getImporteDescuento3TotalLocal());
        }
        if (dtoDocContableTemp.getImporteFleteTotalDocumento()!=null){
          query.append("," + dtoDocContableTemp.getImporteFleteTotalDocumento());
        }
        if (dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento()!=null){
          query.append("," + dtoDocContableTemp.getImporteFleteSinImpuestosTotalDocumento());
        }
        if (dtoDocContableTemp.getImporteDescuento3TotalDocumento()!=null){
          query.append("," + dtoDocContableTemp.getImporteDescuento3TotalDocumento());
        }
        if (dtoDocContableTemp.getOidTipoConcursoPrograma() != null){
          query.append("," + dtoDocContableTemp.getOidTipoConcursoPrograma());
        }
          query.append(",(SELECT  CASE WHEN (PIP.IND_BUSQ_TELE = 1) THEN ");
          query.append("            	(SELECT MCC.VAL_TEXT_COMU ");
          query.append("	                  FROM MAE_CLIEN_COMUN MCC, "); 
          query.append("	                       MAE_TIPO_COMUN MTC ");
          query.append("	                  WHERE MCC.TICM_OID_TIPO_COMU = MTC.OID_TIPO_COMU  ");
          query.append("	                    AND MTC.COD_TIPO_COMU = 'TF' "); 
          query.append("	                    AND MCC.CLIE_OID_CLIE = " + dtoDocContableTemp.getOidCliente() + ") ");
          query.append("	       END TELEF_FIJO ");
          query.append("		FROM SEG_PARAM_INTER_PAIS PIP ");
          query.append("		WHERE PIP.PAIS_OID_PAIS = " + dtoDocContableTemp.getOidPais() + ") ");           
        
          query.append(",(SELECT  CASE WHEN (PIP.IND_BUSQ_TELE = 1) THEN ");
          query.append("            	(SELECT MCC.VAL_TEXT_COMU ");
          query.append("	                  FROM MAE_CLIEN_COMUN MCC, "); 
          query.append("	                       MAE_TIPO_COMUN MTC ");
          query.append("	                  WHERE MCC.TICM_OID_TIPO_COMU = MTC.OID_TIPO_COMU  ");
          query.append("	                    AND MTC.COD_TIPO_COMU = 'TC' "); 
          query.append("	                    AND MCC.CLIE_OID_CLIE = " + dtoDocContableTemp.getOidCliente() + ") ");
          query.append("	       END TELEF_FIJO ");
          query.append("		FROM SEG_PARAM_INTER_PAIS PIP ");
          query.append("		WHERE PIP.PAIS_OID_PAIS = " + dtoDocContableTemp.getOidPais() + ") ");  

          query.append(",(SELECT MCD.VAL_BARR ");
		  query.append(" FROM MAE_CLIEN_DIREC MCD ");    
          query.append(" WHERE MCD.IND_DIRE_PPAL = 1");
          query.append("   AND MCD.IND_ELIM = 0");
          query.append("   AND MCD.CLIE_OID_CLIE = ").append(dtoDocContableTemp.getOidCliente()).append(")");
           
          query.append(", (SELECT PSC.VAL_IMPO_IVA_ASUM_EMPR ");
          query.append(" FROM PED_SOLIC_CABEC PSC ");
          query.append(" WHERE PSC.OID_SOLI_CABE = ").append(dtoDocContableTemp.getOidCabeceraSolicitud()).append(")");

          query.append(");");

          
        try {        
          bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("Query con error :"+query.toString(),e);
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error en grabarDocumentoContable al crear la cabecera del Doc Contable",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
        }
       
        return oid;
	}
    /* Modificado por Cambio FAC-001 ------ AL */

     
    /**
     * Arma una insert para una linea Fac Secuencia Docum
     */
    //jrivas 17/10/2006
    /* Se modifica por Cambio FAC-003, se agrega el tipo de programa de Incentivos para armar los documentos de imprension --- AL */
    private StringBuffer armarFacSecuenciaDocum(Integer cantidadPaginas, Long oidConsolidado, Long oidTipoDocumento, Long spool, Integer numeroSecuencia, Long oidTipoProgInc) throws MareException {
        Vector parametros = new Vector();
        Long oid = new Long(SecuenciadorOID.obtenerSiguienteValor("FAC_SDIN_SEQ").longValue());
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();
        query.append(" INSERT INTO FAC_SECUE_DOCUM_INTER ( OID_SECU_DOCU_INTE, VAL_CANT_PAGI, SOCA_OID_SOLI_CABE, ");        
        query.append(" TIDO_OID_TIPO_DOCU, GSPO_OID_SPOO, NUM_SECU, ICTP_OID_TIPO_PROG ");

        values.append(oid).append(",");
        values.append(cantidadPaginas).append(",");
        values.append(oidConsolidado).append(",");
        values.append(oidTipoDocumento).append(",");
        values.append(spool).append(",");
        values.append(numeroSecuencia).append(",");
        values.append(oidTipoProgInc); 
        query.append(") VALUES (");
        query.append(values);
        query.append(")");
        
        return query;
    }

    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }




    /* Este metodo (actualizaMatrizFactuPorOidOferta) no se utiliza mas ya que fue reemplazado por generarStringUpdateMatriz para una mejor Performance del Proceso ----- 09/08/2007 ------ AL  */
    /**
     * Agregado por HRCS - Fecha 12/07/2007 - Incidencia Sicc20070353
     * @param oidDetaOfer Oid del Detalle Oferta
     * @param bs Objeto BelcorpService
     * @throws MareException MARE Excepcion
     */
    private void actualizaMatrizFactuPorOidOferta( Long oidDetaOferta, BelcorpService bs ) throws  MareException  {
        
        Vector vector = new Vector();
        StringBuffer query  = new StringBuffer();
        query.append(" SELECT ind_matr_fact ");
        query.append(" FROM pre_matri_factu ");
        query.append(" WHERE ofde_oid_deta_ofer = " + oidDetaOferta );
        try {
            RecordSet rs = bs.dbService.executePreparedQuery(query.toString(), vector);
            if (rs!=null && !rs.esVacio())  {
                //  Valida que el indicador no se encuentre activo
                if ( rs.getValueAt(0,0)==null || ((BigDecimal)rs.getValueAt(0,0)).intValue()!=ConstantesFAC.INDICADOR_ACTIVO.intValue() )   {
                    StringBuffer query2  = new StringBuffer();
                    query2.append(" UPDATE pre_matri_factu ");
                    query2.append(" SET ind_matr_fact = " + ConstantesFAC.INDICADOR_ACTIVO );
                    query2.append(" WHERE ofde_oid_deta_ofer = " + oidDetaOferta );
                    
                    bs.dbService.executePreparedUpdate(query2.toString(), vector);
                }
            }
        } catch (Exception e) {
            UtilidadesLog.error("*** Error actualizando el indicador de la Matriz de Facturacion",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
	}


    /* Agregado por Cambio FAC-003 ------ AL */
    // Modificado por SICC20070410 - Rafael Romero - 11/09/2007
    // Para no afectar el rendimiento, se aprovecha que aqui se leen las solicitudes y se van tomando las observaciones respectivas.
    // Se modifica la firma del metodo para pasar la instancia de la clase que almacena los datos del tipo documento haciendo en este metodo el set
    // de las posiciones y las observaciones.
     private void seleccionarPosiciones(DatosTipoDocumento datosTipoDocumento, DTOFACConsolidado dtoConsolidado, Long tipoDocumento, Long oidTipoPrograma, Long oidDocumLegalRef) throws MareException {
		UtilidadesLog.info("MONTratamientosContablesBean.seleccionarPosiciones(DTOFACConsolidado dtoConsolidado, Long tipoDocumento, Long oidTipoPrograma): Entrada");
        ArrayList listaRetorno = new ArrayList();
        Iterator iteradorListaPosiciones = null;
        Iterator iteradorListaSolicitudes = dtoConsolidado.getListaSolicitudes().iterator();
        HashMap tmpObser = new HashMap();
        String cabecObser = null;
        StringBuffer acObservaciones = new StringBuffer();
        while(iteradorListaSolicitudes.hasNext()){
          DTOFACCabeceraSolicitud cabecera = null;
          cabecera = (DTOFACCabeceraSolicitud)iteradorListaSolicitudes.next();
          if(cabecera.getTipoDocumentoLegal().longValue() == tipoDocumento.longValue()){
            if ((oidTipoPrograma == null && cabecera.getOidTipoConcursoPrograma() == null) || (oidTipoPrograma != null && cabecera.getOidTipoConcursoPrograma() != null && oidTipoPrograma.longValue() == cabecera.getOidTipoConcursoPrograma().longValue())) {              
              cabecObser = cabecera.getObservaciones()==null ? "" : cabecera.getObservaciones();
              if(cabecObser.length()>0 && !tmpObser.containsKey(cabecObser)){
                tmpObser.put(cabecObser,cabecObser);
                acObservaciones.append(" " + cabecObser);
              }
              iteradorListaPosiciones = dtoConsolidado.getListaPosiciones().iterator();
              while(iteradorListaPosiciones.hasNext()){
                 DTOFACPosicionSolicitud posicion = null;
                 posicion = (DTOFACPosicionSolicitud) iteradorListaPosiciones.next();
                 Long oidDocumLegalRefPos = posicion.getOidDocumentoLegalReferencia();
                 if(posicion.getOidCabecera().longValue() ==  cabecera.getOidCabeceraSolicitud().longValue()) {
                     if ( (oidDocumLegalRef == null && oidDocumLegalRefPos == null)
                             || (oidDocumLegalRef != null && oidDocumLegalRef.equals(oidDocumLegalRefPos)) ) {
                         listaRetorno.add(posicion);
                     }
                 }
              }
            }
          } //incidencia 9051
        }
        datosTipoDocumento.setObservaciones(acObservaciones.toString().trim());
        datosTipoDocumento.setListaPosiciones(listaRetorno);
		UtilidadesLog.info("MONTratamientosContablesBean.seleccionarPosiciones(DTOFACConsolidado dtoConsolidado, Long tipoDocumento, Long oidTipoPrograma): Salida");
		//return listaRetorno;
	}
    /* Agregado por Cambio FAC-003 ------ AL */

    private StringBuffer generarStringUpdateMatriz(Long oidDetaOferta) {
      StringBuffer query  = new StringBuffer();
      query.append("UPDATE PRE_MATRI_FACTU ");
      query.append(" SET IND_MATR_FACT = " + ConstantesFAC.INDICADOR_ACTIVO);
      query.append(" WHERE OFDE_OID_DETA_OFER=" + oidDetaOferta + " AND NVL(IND_MATR_FACT,0)="+ConstantesFAC.INDICADOR_DESACTIVO ); // Sicc20070424
      return query;    
    }
    
    /* Agregado por Cambio FAC-003 ------ AL */
    private HashMap obtenerCodigosTipoDocumento(ArrayList arrayOidDocumentos) throws MareException {
      UtilidadesLog.info("MONTratamientosContablesBean.obtenerCodigosTipoDocumento(ArrayList arrayOidDocumentos): Entrada");  
      HashMap hashCodigos = new HashMap();
      StringBuffer query = new StringBuffer();
      
      query.append("SELECT OID_TIPO_DOCU, COD_TIPO_DOCU ");
      query.append("FROM FAC_TIPO_DOCUM ");
      query.append("WHERE OID_TIPO_DOCU IN (");
      
      int sizeArray = arrayOidDocumentos.size();
      
      for (int i=0;i<sizeArray;i++) {
        if (i == 0) {
          query.append(arrayOidDocumentos.get(i));
        } else {
          query.append("," + arrayOidDocumentos.get(i));
        }
      }
      query.append(")");
      
      RecordSet rs = this.executeQuery(query.toString());
      
      if (rs != null && !(rs.esVacio())) {
        int sizeRS = rs.getRowCount();
        for (int i = 0; i< sizeRS;i++){
           hashCodigos.put(this.bigDecimalToLong(rs.getValueAt(i,"OID_TIPO_DOCU")), this.bigDecimalToString(rs.getValueAt(i,"COD_TIPO_DOCU"))); 
        }
      }
      
      UtilidadesLog.info("MONTratamientosContablesBean.obtenerCodigosTipoDocumento(ArrayList arrayOidDocumentos): Salida");      
      return hashCodigos;
    }
    
    
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONTratamientosContablesBean.executeQuery(String query): Entrada");
    RecordSet rs = null;    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONTratamientosContablesBean.executeQuery(String query): Salida");  
    return rs;
  }
  
  private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
   }
   
   private String bigDecimalToString(Object ob) {
        if (ob != null) {
            return ob.toString();
        } else {
            return null;
        }
    } 
    /* Agregado por Cambio FAC-003 ------ AL */
    
    /* Agregado por Cambio FAC-001 ------ AL */
    /* Se reemplaza el metodo armarLineaDocumentContable(con 50 parametros) por armarLineaDocumentoContable(con 4 parametros) */
    /**
     * CHANGELOG
     * ---------
     * dmorello, 09/06/2009 - Se agrega seteo del nuevo campo IMP_IMPU_TOTA_PROD_NACI
     */
    private StringBuffer armarLineaDocumentoContable(DTOFACPosicionSolicitud dtoPosicion, Long oidCabeceraDocumentoLegal, Integer numeroLinea, Long moneda) {
        Vector parametros = new Vector();
        
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();
        
        query.append(" INSERT INTO FAC_DOCUM_CONTA_LINEA ");
        query.append(" (OID, ");
        values.append("FAC_DCLI_SEQ.NEXTVAL,");
        query.append(" DCCA_OID_CABE, ");
        values.append(oidCabeceraDocumentoLegal).append(",");
        query.append(" NUM_UNID_ATEN, ");
        values.append(dtoPosicion.getUnidadesAtendidas()).append(",");
        query.append(" SOPO_OID_SOLI_POSI, ");
        values.append(dtoPosicion.getOidPosicion()).append(",");
        query.append(" PROD_OID_PROD, ");
        values.append(dtoPosicion.getProducto()).append(",");
        query.append(" NUM_LINEA, ");
        values.append(numeroLinea).append(",");  
        if (moneda != null) {
            query.append("MONE_OID_MONE,");
            values.append(moneda).append(",");
        }
        if (dtoPosicion.getPrecioCatalogoTD() != null) {
            query.append("VAL_PREC_CATA_TOTA_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioCatalogoTD())).append(",");
        }
        if (dtoPosicion.getPrecioNetoTD() != null) {
            query.append("VAL_PREC_NETO_TOTA_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioNetoTD())).append(",");
        }
        if (dtoPosicion.getImporteImpuestoTD() != null) {
            query.append("IMP_IMPU_TOTA_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getImporteImpuestoTD())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoSinImpuestosTD() != null) {
            query.append("IMP_DESC_SIN_IMPU_TOTA_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoSinImpuestosTD())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoTD() != null) {
            query.append("IMP_DESC_TOTA_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoTD())).append(",");
        }
        if (dtoPosicion.getPrecioFacturaTD() != null) {
            query.append("VAL_PREC_FACT_TOTA_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioFacturaTD())).append(",");
        }
        if (dtoPosicion.getPrecioTotalTD() != null) {
            query.append("VAL_PREC_TOTA_TOTA_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioTotalTD())).append(",");
        }
        if (dtoPosicion.getPrecioContableTD() != null) {
            query.append(" VAL_PREC_CONT_TOTA_DOCU , "); 
            values.append(toBigDecimal(dtoPosicion.getPrecioContableTD())).append(",");
        }
        if (dtoPosicion.getPrecioTotalUD() != null) {
            query.append("VAL_PREC_TOTA_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioTotalUD())).append(",");
        }
        if (dtoPosicion.getImporteImpuestoUD() != null) {
            query.append("IMP_IMPU_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getImporteImpuestoUD())).append(",");
        }
        if (dtoPosicion.getPrecioNetoUD() != null) {
            query.append("VAL_PREC_NETO_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioNetoUD())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoSinImpuestosUD() != null) {
            query.append("IMP_DESC_SIN_IMPU_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoSinImpuestosUD())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoUD() != null) {
            query.append("IMP_DESC_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoUD())).append(",");
        }
        if (dtoPosicion.getPorcentajeDescuento() != null) {
            query.append("VAL_PORC_DESC,");
            values.append(toBigDecimal(dtoPosicion.getPorcentajeDescuento())).append(",");
        }
        if (dtoPosicion.getPrecioSinImpuestosUD() != null) {
            query.append("VAL_PREC_SIN_IMPU_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioSinImpuestosUD())).append(",");
        }
        if (dtoPosicion.getPrecioFacturaUD() != null) {
            query.append("VAL_PREC_FACT_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioFacturaUD())).append(",");
        }
        if (dtoPosicion.getPrecioContableUD() != null) {
            query.append("VAL_PREC_CONT_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioContableUD())).append(",");
        }
        if (dtoPosicion.getPrecioCatalogoUD() != null) {
            query.append("VAL_PREC_CATA_UNIT_DOCU,");
            values.append(toBigDecimal(dtoPosicion.getPrecioCatalogoUD())).append(",");
        }
        if (dtoPosicion.getPrecioTotalTL() != null) {
            query.append("VAL_PREC_TOTA_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioTotalTL())).append(",");
        }
        if (dtoPosicion.getImporteImpuestoTL() != null) {
            query.append("IMP_IMPU_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getImporteImpuestoTL())).append(",");
        }
        if (dtoPosicion.getPrecioNetoTL() != null) {
            query.append("VAL_PREC_NETO_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioNetoTL())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoSinImpuestosTL() != null) { 
            query.append("IMP_DESC_SIN_IMPU_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoSinImpuestosTL())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoTL() != null) {
            query.append("IMP_DESC_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoTL())).append(",");
        }
        if (dtoPosicion.getPrecioSinImpuestosTL() != null) {
            query.append("VAL_PREC_SIN_IMPU_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioSinImpuestosTL())).append(",");
        }
        if (dtoPosicion.getPrecioFacturaTL() != null) {
            query.append("VAL_PREC_FACT_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioFacturaTL())).append(",");
        }
        if (dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal() != null) {
            query.append("VAL_PREC_CATA_LOCA_UNID_DEMA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal())).append(",");
        }
        if (dtoPosicion.getPrecioCatalogoTL() != null) {
            query.append("VAL_PREC_CATA_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioCatalogoTL())).append(",");
        }
        if (dtoPosicion.getPrecioContableTL() != null) {
            query.append("VAL_PREC_CONT_TOTA_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioContableTL())).append(",");
        }
        if (dtoPosicion.getPrecioTotalUL() != null) {
            query.append("VAL_PREC_TOTA_UNIT_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioTotalUL())).append(",");
        }
        if (dtoPosicion.getImporteImpuestoUL() != null) {
            query.append("IMP_IMPU_UNIT_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getImporteImpuestoUL())).append(",");
        }
        if (dtoPosicion.getPrecioNetoUL() != null) {
            query.append("VAL_PREC_NETO_UNIT_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioNetoUL())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoUL() != null) {
            query.append("IMP_DESC_UNIT_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoUL())).append(",");
        }
        if (dtoPosicion.getPrecioSinImpuestosUL() != null) {
            query.append("VAL_PREC_SIN_IMPU_UNIT,");
            values.append(toBigDecimal(dtoPosicion.getPrecioSinImpuestosUL())).append(",");
        }
        if (dtoPosicion.getImporteDescuentoSinImpuestosUL() != null) {
            query.append("IMP_DESC_SIN_IMPU_UNIT,");
            values.append(toBigDecimal(dtoPosicion.getImporteDescuentoSinImpuestosUL())).append(",");
        }
        if (dtoPosicion.getPrecioFacturaUL() != null) {
            query.append("VAL_PREC_FACT_UNIT_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioFacturaUL())).append(",");
        }
        if (dtoPosicion.getPrecioContableUL() != null) {
            query.append("VAL_PREC_CONT_UNIT_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioContableUL())).append(",");
        }
        if (dtoPosicion.getPrecioCatalogoUL() != null) {
            query.append("VAL_PREC_CATA_UNIT_LOCA,");
            values.append(toBigDecimal(dtoPosicion.getPrecioCatalogoUL())).append(",");
        }
        if (dtoPosicion.getPrecioSinImpuestosTD() != null) {
            query.append("VAL_PREC_SIN_IMPU_TOTA_DOCU,");
            values.append(dtoPosicion.getPrecioSinImpuestosTD()).append(",");
        }
        if (dtoPosicion.getPagina() != null) {
            query.append("NUM_PAGI,");
            values.append(dtoPosicion.getPagina()).append(",");
        }
        if (dtoPosicion.getIndicadorDentroFueraCajaBolsa() != null && dtoPosicion.getIndicadorDentroFueraCajaBolsa().length() > 0) {
            query.append("IND_DENT_FUER_CAJA_BOLS,");
            values.append("'").append(dtoPosicion.getIndicadorDentroFueraCajaBolsa()).append("'").append(",");
        } else {
            query.append("IND_DENT_FUER_CAJA_BOLS,");
            values.append("'C'").append(",");
        }
        if (dtoPosicion.getIndicadorNoImprimible() != null) {
            query.append("IND_NO_IMPR,");
            if (dtoPosicion.getIndicadorNoImprimible().booleanValue()) {
                values.append("1").append(",");
            } else {
                values.append("0").append(",");
            }
        }
        if (dtoPosicion.getCatalogo() != null){
            query.append("VAL_CATA,");
            values.append(" (select COD_CATA from pre_catal where oid_cata = " + dtoPosicion.getCatalogo().toString() + " ),");
        }
        
        // Cambio 20090922 - dmorello, 09/06/2009
        // Obtengo impuesto producto nacional y lo multiplico por las unidades atendidas
        // El resultado se setea en el campo IMP_IMPU_TOTA_PROD_NACI
        query.append("IMP_IMPU_TOTA_PROD_NACI,");
        values.append(" (").append(dtoPosicion.getUnidadesAtendidas()).append(" * ");
        values.append("(SELECT val_impu_prod_naci FROM (");
        //values.append("   SELECT   NVL (val_impu_prod_naci, 0) AS val_impu_prod_naci ");
        values.append("   SELECT   NVL(decode((select val_tota_paga_loca from fac_docum_conta_cabec where oid_cabe='"+oidCabeceraDocumentoLegal+"'),0,0, val_impu_prod_naci), 0) AS val_impu_prod_naci ");        
        values.append("   FROM int_impue_produ_nacio ");
        values.append("   WHERE prod_oid_prod = ").append(dtoPosicion.getProducto());
        values.append("   ORDER BY fec_carg DESC NULLS LAST ");
        values.append(" ) WHERE ROWNUM = 1)");
        values.append("),");
        
        query = query.delete(query.length()-1,query.length());  // para quitar la ultima coma.
        query.append(") VALUES (");
        values = values.delete(values.length()-1,values.length());  // para quitar la ultima coma.
        query.append(values);
        query.append(")");
        return query;
    }
    
    private DTOFACPosicionDocContable armarDtoPosicionDocumentoContable (DTOFACPosicionSolicitud dtoPosicion, Long oidCabeceraSolicitud) {
        DTOFACPosicionDocContable dtoPosicionDocContable = new DTOFACPosicionDocContable();
        dtoPosicionDocContable.setIndicadorImpuestos(dtoPosicion.getIndicadorImpuestos());
        dtoPosicionDocContable.setTasaImpuesto(dtoPosicion.getTasaImpuesto());    
        dtoPosicionDocContable.setPrecioContableSinImpuestosUL(dtoPosicion.getPrecioContableSinImpuestosUL());    
        dtoPosicionDocContable.setPrecioCatalogoUL(dtoPosicion.getPrecioCatalogoUL());    
        dtoPosicionDocContable.setPrecioContableUL(dtoPosicion.getPrecioContableUL());    
        dtoPosicionDocContable.setImporteDescuentoSinImpuestosUL(dtoPosicion.getImporteDescuentoSinImpuestosUL());    
        dtoPosicionDocContable.setImporteDescuentoUL(dtoPosicion.getImporteDescuentoUL());    
        dtoPosicionDocContable.setPrecioFacturaUL(dtoPosicion.getPrecioFacturaUL());    
        dtoPosicionDocContable.setPrecioNetoUL(dtoPosicion.getPrecioNetoUL());    
        dtoPosicionDocContable.setImporteImpuestoUL(dtoPosicion.getImporteImpuestoUL());    
        dtoPosicionDocContable.setPrecioTotalUL(dtoPosicion.getPrecioTotalUL());   
        dtoPosicionDocContable.setPrecioContableTL(dtoPosicion.getPrecioContableTL());    
        dtoPosicionDocContable.setUnidadesComprometidas(dtoPosicion.getUnidadesComprometidas());    
        dtoPosicionDocContable.setPrecioCatalogoTL(dtoPosicion.getPrecioCatalogoTL());    
        dtoPosicionDocContable.setPrecioCatalogoTLUnidadesDemandaReal(dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal());    
        dtoPosicionDocContable.setPrecioFacturaTL(dtoPosicion.getPrecioFacturaTL());    
        dtoPosicionDocContable.setPrecioSinImpuestosTL(dtoPosicion.getPrecioSinImpuestosTL());    
        dtoPosicionDocContable.setImporteDescuentoTL(dtoPosicion.getImporteDescuentoTL());    
        dtoPosicionDocContable.setImporteDescuentoSinImpuestosTL(dtoPosicion.getImporteDescuentoSinImpuestosTL());    
        dtoPosicionDocContable.setPrecioNetoTL(dtoPosicion.getPrecioNetoTL());    
        dtoPosicionDocContable.setImporteImpuestoTL(dtoPosicion.getImporteImpuestoTL());    
        dtoPosicionDocContable.setPrecioTotalTL(dtoPosicion.getPrecioTotalTL());    
        dtoPosicionDocContable.setPrecioContableSinImpuestosUD(dtoPosicion.getPrecioContableSinImpuestosUD());    
        dtoPosicionDocContable.setPrecioCatalogoUD(dtoPosicion.getPrecioCatalogoUD());    
        dtoPosicionDocContable.setPrecioContableUD(dtoPosicion.getPrecioContableUD());   
        dtoPosicionDocContable.setImporteDescuentoSinImpuestosUD(dtoPosicion.getImporteDescuentoSinImpuestosUD());    
        dtoPosicionDocContable.setImporteDescuentoUD(dtoPosicion.getImporteDescuentoUD());    
        dtoPosicionDocContable.setPrecioFacturaUD(dtoPosicion.getPrecioFacturaUD());    
        dtoPosicionDocContable.setPrecioNetoUD(dtoPosicion.getPrecioNetoUD());    
        dtoPosicionDocContable.setImporteImpuestoUD(dtoPosicion.getImporteImpuestoUD());    
        dtoPosicionDocContable.setPrecioTotalUD(dtoPosicion.getPrecioTotalUD());    
        dtoPosicionDocContable.setPrecioContableTD(dtoPosicion.getPrecioContableTD());    
        dtoPosicionDocContable.setPrecioCatalogoTD(dtoPosicion.getPrecioCatalogoTD());    
        dtoPosicionDocContable.setPrecioCatalogoTDUnidadesDemandaReal(dtoPosicion.getPrecioCatalogoTDUnidadesDemandaReal());    
        dtoPosicionDocContable.setPrecioFacturaTD(dtoPosicion.getPrecioFacturaTD());    
        dtoPosicionDocContable.setPrecioSinImpuestosTD(dtoPosicion.getPrecioSinImpuestosTD());    
        dtoPosicionDocContable.setImporteDescuentoTD(dtoPosicion.getImporteDescuentoTD());   
        dtoPosicionDocContable.setImporteDescuentoSinImpuestosTD(dtoPosicion.getImporteDescuentoSinImpuestosTD());    
        dtoPosicionDocContable.setUnidadesDemandaReal(dtoPosicion.getUnidadesDemandaReal());    
        dtoPosicionDocContable.setPrecioNetoTD(dtoPosicion.getPrecioNetoTD());    
        dtoPosicionDocContable.setImporteImpuestoTD(dtoPosicion.getImporteImpuestoTD());    
        dtoPosicionDocContable.setPrecioTotalTD(dtoPosicion.getPrecioTotalTD());    
        dtoPosicionDocContable.setUnidadesPorAtender(dtoPosicion.getUnidadesPorAtender());    
        dtoPosicionDocContable.setCodigoProducto(dtoPosicion.getCodigoProducto());    
        dtoPosicionDocContable.setPrecioSinImpuestosUL(dtoPosicion.getPrecioContableSinImpuestosUL());    
        dtoPosicionDocContable.setPrecioSinImpuestosUD(dtoPosicion.getPrecioSinImpuestosUD());    
        dtoPosicionDocContable.setOidPosicion(dtoPosicion.getOidPosicion());    
        dtoPosicionDocContable.setFecha(dtoPosicion.getFecha());    
        dtoPosicionDocContable.setCodigoVenta(dtoPosicion.getCodigoVenta());   
        dtoPosicionDocContable.setDescripcionSAP(dtoPosicion.getDescripcionSAP());    
        dtoPosicionDocContable.setTipoOferta(dtoPosicion.getTipoOferta());    
        dtoPosicionDocContable.setOidFormaPago(dtoPosicion.getOidFormaPago());    
        dtoPosicionDocContable.setOidCabecera(oidCabeceraSolicitud);   
        dtoPosicionDocContable.setProducto(dtoPosicion.getProducto());
        dtoPosicionDocContable.setIndicadorNoImprimible(dtoPosicion.getIndicadorNoImprimible());
        dtoPosicionDocContable.setUnidadesAtendidas(dtoPosicion.getUnidadesAtendidas());
        dtoPosicionDocContable.setNumeroPosicion(dtoPosicion.getNumeroPosicion()); //Incidencia 9066
        if (dtoPosicion.getIndicadorDentroFueraCajaBolsa()== null || dtoPosicion.getIndicadorDentroFueraCajaBolsa().trim().length()<1){
            dtoPosicionDocContable.setIndicadorDentroFueraCajaBolsa("C");
        }else{
            dtoPosicionDocContable.setIndicadorDentroFueraCajaBolsa(dtoPosicion.getIndicadorDentroFueraCajaBolsa());
        }
        dtoPosicionDocContable.setNumeroConsolidado(dtoPosicion.getNumeroConsolidado());
        dtoPosicionDocContable.setCatalogo(dtoPosicion.getCatalogo());
        dtoPosicionDocContable.setPagina(dtoPosicion.getPagina());
        dtoPosicionDocContable.setNegocioProducto(dtoPosicion.getNegocioProducto());
        dtoPosicionDocContable.setEstado(dtoPosicion.getEstado()); 
        return dtoPosicionDocContable;
    }
    
    /* Agregado por Cambio FAC-001 ------ AL */
    
    
    /**
     * Creado por Cambio 20090884.
     * Obtiene el indicador de impuesto para productos gratis de la tabla
     * SEG_PARAM_INTER_PAIS para el pais cuyo OID recibe por parametro.
     * @author dmorello
     * @since 17-abr-2009
     */
    private Boolean obtenerIndImpuestosProdGratis(Long oidPais) throws MareException {
        UtilidadesLog.info("MONTratamientosContablesBean.obtenerIndImpuestosProdGratis(Long oidPais): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String query = "SELECT IND_IMPU_PROD_GRAT FROM SEG_PARAM_INTER_PAIS WHERE PAIS_OID_PAIS = " + oidPais;
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Boolean flag = null;
        if (!rs.esVacio()) {
            Object objFlag = rs.getValueAt(0,0);
            if (objFlag != null) {
                flag = Boolean.valueOf(objFlag.toString().equals("1"));
            }
        }
        
        UtilidadesLog.info("MONTratamientosContablesBean.obtenerIndImpuestosProdGratis(Long oidPais): Salida");
        return flag;
    }
    
    /* 
     * @Autor Sergio Buchelli
     * Retorna -1 si no encuentra forma de pago en el vector de Pagos
     *  caso contrario retorna e indice donde se encuntra la forma de pago
     *
     * */
    private int buscarFormaPago(FormaPago fp, ArrayList<FormaPago> regFPagos) {
       int i=0;
       boolean encontro=false;
       for(FormaPago formaPago : regFPagos){
         if(formaPago.getOidFormaPago().longValue() == fp.getOidFormaPago().longValue()){
            encontro = true;
            break;
          }     
           ++i;
       }
        return (encontro?i:-1);
    }

    //sapaza -- PER-SiCC-2012-0088 -- 08/02/2012
    public double obtenerGastoAdministrativo(Long oidConsolidado) throws MareException {
        ArrayList arrayParametros = new ArrayList();
        arrayParametros.add(oidConsolidado);
        
        String gastoAdministrativo = null;
        try {       
          gastoAdministrativo = BelcorpService.getInstance().dbService.ExecuteFunction("PQ_PLANI.PED_FN_OBTEN_GASTO_ADMIN", arrayParametros);        
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        } 
        
        return Double.parseDouble(gastoAdministrativo);
    }
    
    
    // sbuchelli --  -- 03/04/2012
    private Long getNumUnidadCompra(Long oidSolicitudCabecera) throws MareException {
        StringBuffer query = new StringBuffer();
        Long num = new Long("0");
                
        query.append("SELECT SUM (num_unid_compr) UNID_COMPR ");
        query.append(" FROM ped_solic_cabec a, ped_solic_posic b, pre_ofert_detal c ");
        query.append(" WHERE a.oid_soli_cabe = b.soca_oid_soli_cabe ");
        query.append(" AND b.ofde_oid_deta_ofer = c.oid_deta_ofer ");
        query.append(" AND NOT EXISTS (SELECT 1 FROM fac_tipo_ofert_exclu WHERE tofe_oid_tipo_ofer = c.tofe_oid_tipo_ofer) ");        
        query.append(" AND a.soca_oid_soli_cabe = ").append(oidSolicitudCabecera);
                
        RecordSet rs = null;
                
        rs = UtilidadesBD.executeQuery(query.toString());

        if (rs != null && !rs.esVacio()) {
            num =  this.bigDecimalToLong(rs.getValueAt(0, "UNID_COMPR"));
        }
        
        return num;
    }

    // sapaza -- PER-SiCC-2012-0377 -- 25/04/2012
    public void generarRegistroCC2(DTOFACConsolidado dtoConso) throws MareException {
        UtilidadesLog.info("MONTratamientosContablesBean.generarRegistroCC2(DTOFACConsolidado dtoConso): Entrada ");

        try{
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("FAC_PKG_PROC.FAC_PR_GENERA_CCC", dtoConso.getDtoCabecera().getOidCabeceraSolicitud().toString());
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONTratamientosContablesBean.generarRegistroCC2(DTOFACConsolidado dtoConso): Salida ");
    }
    
}


