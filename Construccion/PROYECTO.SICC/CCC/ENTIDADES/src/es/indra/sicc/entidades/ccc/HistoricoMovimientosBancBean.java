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

package es.indra.sicc.entidades.ccc;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.FinderException;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.SecuenciadorOID;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

import org.apache.commons.logging.Log;

public class HistoricoMovimientosBancBean implements EntityBean  {

	private EntityContext context;

	////////////////////////////////////////////////////////////////
	// atributos de la entidad
	////////////////////////////////////////////////////////////////

	///////////////////////////// OBLIGATORIOS
	public Long oid;
	public Date fechaPasoAHistorico;
	// FKs	
	public Long cc;
	public Long empresa;
	public Long subprocesoMarcasCreacion;
	public Long tiposAbonoCreacion;
	public Long cliente;
	
	
	///////////////////////////// NO  OBLIGATORIOS
	public Long subacceso;
	public Long numeroLote;
	public Long consecutivoTransaccion;
	public Integer numeroHistoria;
	public Long numeroFacturaOBoleta;
	public Date fechaPago;
	public BigDecimal importePago;
	public BigDecimal importeAplicado;
	public BigDecimal saldoPendiente;
	public Long numeroCupon;
	public String codigoConsultora;
	public Integer digitoChequeoNumFac;
    //modificado tipo a string por inc 21735
    public String oficinaRecaudadora;
	public String nombreOficina;
	public String numeroDocumento;
	public String horarioNormalAdicional;
	public String usuarioProceso;
	public Date fechaProceso;
	public Timestamp horaProceso;
	//public String codigoConsultoraReal; eliminado incidencia 8976
	public String documentoCreacionMes;
	public String documentoCreacionAnio;
	public Integer documentoCreacionNumero;
	public String documentoAplicacionMes;
	public String documentoAplicacionAnio;
	public Integer documentoAplicacionNumero;
	public Timestamp fechaMovimientoAplicacion;
	public String codigoError;
	public String estatusMovimientoTesoreria;
	public String identificadorProceso;
	public String numeroLoteContabilizacion;
	public Date fechaContabilizacion;
	public String observaciones;
	public Long numeroLoteExterno;
	//public Long nMovimientoCaja;
	// FKs
	public Long subprocesoMarcasUltimo;
	public Long tiposAbonoUltimo;
	public Long transaccion;
	public Long movimiento;
	public Long tipoError;
	
	public String codigoUsuario;
	public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException	{

		Vector parametros = new Vector();

		String consulta = "SELECT OID_MOVI_BANC FROM CCC_HISTO_MOVIM_BANCA " +
							"WHERE OID_MOVI_BANC = ?";

		parametros.add(primaryKey);

		BelcorpService bs;
		RecordSet resultado;

		try {
			resultado = ejecutaConsulta(consulta, parametros);
		} catch (EJBException ex) {
			throw new EJBException();
		}

        if (resultado.esVacio()) {
            throw new FinderException();
        }

		return primaryKey;
	}

	public void ejbActivate() {
	}

	public void ejbLoad() {
	
		Vector parametro = new Vector();

        String consulta  = "SELECT * FROM CCC_HISTO_MOVIM_BANCA WHERE OID_MOVI_BANC = ?";
		parametro.add((Long)context.getPrimaryKey());
                   
        RecordSet respuesta;
        BelcorpService bs;

        try {
	        respuesta = ejecutaConsulta(consulta, parametro);
        } catch (Exception exception) {
		    throw new EJBException(exception);
        }

		if (!respuesta.esVacio()) {
			// Al oid le damos la primary key, esto es obligatorio hacerlo, pues
			// si venimos de un findby, el oid no se cargaría
			setOid((Long)context.getPrimaryKey());

			setFechaPasoAHistorico((Date)respuesta.getValueAt(0, "fec_paso_hist".toUpperCase()));
			setCc(new Long(((BigDecimal)respuesta.getValueAt(0, "ccba_oid_cuen_corr_banc".toUpperCase())).longValue()));
			setEmpresa(new Long(((BigDecimal)respuesta.getValueAt(0, "soci_oid_soci".toUpperCase())).longValue()));
			setSubprocesoMarcasCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "subp_oid_subp_crea".toUpperCase())).longValue()));
			setTiposAbonoCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "tcab_oid_tipo_carg_abon_crea".toUpperCase())).longValue()));
			setCliente(new Long(((BigDecimal)respuesta.getValueAt(0, "clie_oid_clie".toUpperCase())).longValue()));
			
			// no obligatorios
			setSubacceso(respuesta.getValueAt(0, "sbac_oid_sbac".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "sbac_oid_sbac".toUpperCase())).longValue()): null);
			setNumeroLote(respuesta.getValueAt(0, "num_lote".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "num_lote".toUpperCase())).longValue()) : null);
			setConsecutivoTransaccion(respuesta.getValueAt(0, "num_cons_tran".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "num_cons_tran".toUpperCase())).longValue()) : null);
			setNumeroHistoria(respuesta.getValueAt(0, "num_hist".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "num_hist".toUpperCase())).intValue()) : null);
			setNumeroFacturaOBoleta(respuesta.getValueAt(0, "num_fact_bole".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "num_fact_bole".toUpperCase())).longValue()) : null);
			setFechaPago(respuesta.getValueAt(0, "fec_pago".toUpperCase()) != null ? (Date)respuesta.getValueAt(0, "fec_pago".toUpperCase()) : null);
			setImportePago(respuesta.getValueAt(0, "imp_pago".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "imp_pago".toUpperCase()) : null);			
			setImporteAplicado(respuesta.getValueAt(0, "imp_apli".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "imp_apli".toUpperCase()) : null);
			setSaldoPendiente(respuesta.getValueAt(0, "imp_sald_pend".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "imp_sald_pend".toUpperCase()) : null);
			setNumeroCupon(respuesta.getValueAt(0, "num_cupo".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "num_cupo".toUpperCase())).longValue()) : null);
			setCodigoConsultora(respuesta.getValueAt(0, "cod_cons".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "cod_cons".toUpperCase()) : null);
			setDigitoChequeoNumFac(respuesta.getValueAt(0, "val_digi_cheq_fact".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "val_digi_cheq_fact".toUpperCase())).intValue()) : null);
			//setOficinaRecaudadora(respuesta.getValueAt(0, "cod_ofic_reca".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "cod_ofic_reca".toUpperCase())).intValue()) : null);
            //modificado por incidencia 21735
            setOficinaRecaudadora(respuesta.getValueAt(0, "cod_ofic_reca".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "cod_ofic_reca".toUpperCase()) : null);
			setNombreOficina(respuesta.getValueAt(0, "val_nomb_ofic".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_nomb_ofic".toUpperCase()) : null);
			setNumeroDocumento(respuesta.getValueAt(0, "val_nume_docu".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_nume_docu".toUpperCase()) : null);						
			setHorarioNormalAdicional(respuesta.getValueAt(0, "val_hora_norm_adic".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_hora_norm_adic".toUpperCase()) : null);
			setUsuarioProceso(respuesta.getValueAt(0, "val_usua_proc".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_usua_proc".toUpperCase()) : null);			
			setFechaProceso(respuesta.getValueAt(0, "fec_proc".toUpperCase()) != null ? (Date)respuesta.getValueAt(0, "fec_proc".toUpperCase()) : null);
			setHoraProceso(respuesta.getValueAt(0, "val_hora_proc".toUpperCase()) != null ? new Timestamp(((Date)respuesta.getValueAt(0, "val_hora_proc".toUpperCase())).getTime()) : null);
			//setCodigoConsultoraReal(respuesta.getValueAt(0, "cod_cons_real".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "cod_cons_real".toUpperCase()) : null);
			setDocumentoCreacionMes(respuesta.getValueAt(0, "val_docu_crea_mes_seri".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_docu_crea_mes_seri".toUpperCase()) : null);
			setDocumentoCreacionAnio(respuesta.getValueAt(0, "val_docu_crea_anio".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_docu_crea_anio".toUpperCase()) : null);
			setDocumentoCreacionNumero(respuesta.getValueAt(0, "val_docu_crea_nume".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "val_docu_crea_nume".toUpperCase())).intValue()) : null);
			setDocumentoAplicacionMes(respuesta.getValueAt(0, "val_docu_apli_mes_seri".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_docu_apli_mes_seri".toUpperCase()) : null);			
			setDocumentoAplicacionAnio(respuesta.getValueAt(0, "val_docu_apli_anio".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_docu_apli_anio".toUpperCase()) : null);
			setDocumentoAplicacionNumero(respuesta.getValueAt(0, "val_docu_apli_nume".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "val_docu_apli_nume".toUpperCase())).intValue()) : null);
			setFechaMovimientoAplicacion(respuesta.getValueAt(0, "fec_movi_apli".toUpperCase()) != null ? new Timestamp(((Date)respuesta.getValueAt(0, "fec_movi_apli".toUpperCase())).getTime()) : null);
			setCodigoError(respuesta.getValueAt(0, "cod_erro".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "cod_erro".toUpperCase()) : null);
			setEstatusMovimientoTesoreria(respuesta.getValueAt(0, "val_esta_movi_pend".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_esta_movi_pend".toUpperCase()) : null);
			setIdentificadorProceso(respuesta.getValueAt(0, "cod_iden_proc".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "cod_iden_proc".toUpperCase()) : null);
			setNumeroLoteContabilizacion(respuesta.getValueAt(0, "val_num_lote_cont".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_num_lote_cont".toUpperCase()) : null);
			setFechaContabilizacion(respuesta.getValueAt(0, "fec_conta".toUpperCase()) != null ? (Date)respuesta.getValueAt(0, "fec_conta".toUpperCase()) : null);
			setObservaciones(respuesta.getValueAt(0, "val_obse".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_obse".toUpperCase()) : null);
			setNumeroLoteExterno(respuesta.getValueAt(0, "num_lote_exte".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "num_lote_exte".toUpperCase())).longValue()) : null);			
			//setNMovimientoCaja(respuesta.getValueAt(0, "num_movi_caja".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "num_movi_caja".toUpperCase())).longValue()) : null);
			setSubprocesoMarcasUltimo(respuesta.getValueAt(0, "subp_oid_subp_ulti".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "subp_oid_subp_ulti".toUpperCase())).longValue()) : null);
			setTiposAbonoUltimo(respuesta.getValueAt(0, "tcab_oid_tipo_carg_abon_ulti".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "tcab_oid_tipo_carg_abon_ulti".toUpperCase())).longValue()) : null);
			setTransaccion(respuesta.getValueAt(0, "ttra_oid_tipo_tran".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "ttra_oid_tipo_tran".toUpperCase())).longValue()) : null);
			setMovimiento(respuesta.getValueAt(0, "cmba_oid_movi_banc".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "cmba_oid_movi_banc".toUpperCase())).longValue()) : null);
			setTipoError(respuesta.getValueAt(0, "tier_oid_erro".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "tier_oid_erro".toUpperCase())).longValue()) : null);
			setCodigoUsuario(respuesta.getValueAt(0,"cod_usua".toUpperCase())!=null?(String)respuesta.getValueAt(0,"cod_usua".toUpperCase()):null);
		}
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
        Vector parametro = new Vector();		
        String consulta = "DELETE FROM CCC_HISTO_MOVIM_BANCA WHERE OID_MOVI_BANC = ?";
        parametro.add((Long)context.getPrimaryKey());

        BelcorpService bs;
        
        try {
			ejecutaSentencia(consulta, parametro);
        } catch (Exception exception) {
			throw new EJBException(exception);
        }
	}

	public void ejbStore() {
	
		Vector parametros = new Vector();
		StringBuffer consulta = new StringBuffer("");

		consulta.append("UPDATE CCC_HISTO_MOVIM_BANCA SET ");

		consulta.append("tcab_oid_tipo_carg_abon_crea = ?, ");
		parametros.add(getTiposAbonoCreacion());
		consulta.append("soci_oid_soci = ?, ");
		parametros.add(getEmpresa());
		consulta.append("clie_oid_clie = ?, ");
		parametros.add(getCliente());
		consulta.append("fec_paso_hist = ?, ");
		parametros.add(getFechaPasoAHistorico());
		consulta.append("subp_oid_subp_crea = ?, ");
		parametros.add(getSubprocesoMarcasCreacion());
		consulta.append("ccba_oid_cuen_corr_banc = ? ");
		parametros.add(getCc());

		// no obligatorios
		if(getSubacceso()!=null){
			consulta.append(",sbac_oid_sbac = ? ");
			parametros.add(getSubacceso());
		}else {
            consulta.append(",  sbac_oid_sbac = null ");
        }
		
        if (getUsuarioProceso() != null) {
            consulta.append(", val_usua_proc = ?");
            parametros.add(getUsuarioProceso());
        } else {
            consulta.append(",  val_usua_proc = null ");
        }
        if (getNumeroHistoria() != null) {
            consulta.append(", num_hist = ? ");
            parametros.add(getNumeroHistoria());
        } else {
            consulta.append(", num_hist = null ");
        }
        if (getMovimiento() != null) {
            consulta.append(", cmba_oid_movi_banc = ? ");
            parametros.add(getMovimiento());
        } else {
            consulta.append(", cmba_oid_movi_banc = null ");
        }
        if (getOficinaRecaudadora() != null) {
            consulta.append(", cod_ofic_reca = ? ");
            parametros.add(getOficinaRecaudadora());
        } else {
            consulta.append(", cod_ofic_reca = null ");
        }
        if (getNumeroDocumento() != null) {
            consulta.append(", val_nume_docu = ? ");
            parametros.add(getNumeroDocumento());
        } else {
            consulta.append(", val_nume_docu = null ");
        }
        if (getNumeroFacturaOBoleta() != null) {
            consulta.append(", num_fact_bole = ? ");
            parametros.add(getNumeroFacturaOBoleta());
        } else {
            consulta.append(", num_fact_bole = null ");
        }
        if (getObservaciones() != null) {
            consulta.append(", val_obse = ? ");
            parametros.add(getObservaciones());
        } else {
            consulta.append(", val_obse = null ");
        }
        if (getNumeroLoteContabilizacion() != null) {
            consulta.append(", val_num_lote_cont = ? ");
            parametros.add(getNumeroLoteContabilizacion());
        } else {
            consulta.append(", val_num_lote_cont = null ");
        }
        if (getTipoError() != null) {
            consulta.append(", tier_oid_erro = ? ");
            parametros.add(getTipoError());
        } else {
            consulta.append(", tier_oid_erro = null ");
        }
        if (getTiposAbonoUltimo() != null) {
            consulta.append(", tcab_oid_tipo_carg_abon_ulti = ? ");
            parametros.add(getTiposAbonoUltimo());
        } else {
            consulta.append(", tcab_oid_tipo_carg_abon_ulti = null ");
        }
        if (getTransaccion() != null) {
            consulta.append(", ttra_oid_tipo_tran = ? ");
            parametros.add(getTransaccion());
        } else {
            consulta.append(", ttra_oid_tipo_tran = null ");
        }
        if (getSubprocesoMarcasUltimo() != null) {
            consulta.append(", subp_oid_subp_ulti = ? ");
            parametros.add(getSubprocesoMarcasUltimo());
        } else {
            consulta.append(", subp_oid_subp_ulti = null ");
        }
        if (getSaldoPendiente() != null) {
            consulta.append(", imp_sald_pend = ? ");
            parametros.add(getSaldoPendiente());
        } else {
            consulta.append(", imp_sald_pend = null ");
        }
        if (getImporteAplicado() != null) {
            consulta.append(", imp_apli = ? ");
            parametros.add(getImporteAplicado());
        } else {
            consulta.append(", imp_apli = null ");
        }
        /*if (getNMovimientoCaja() != null) {
            consulta.append(", num_movi_caja = ? ");
            parametros.add(getNMovimientoCaja());
        } else {
            consulta.append(", num_movi_caja = null ");
        }*/
        if (getNumeroLoteExterno() != null) {
            consulta.append(", num_lote_exte = ? ");
            parametros.add(getNumeroLoteExterno());
        } else {
            consulta.append(", num_lote_exte = null ");
        }
        if (getDocumentoAplicacionMes() != null) {
            consulta.append(", val_docu_apli_mes_seri = ? ");
            parametros.add(getDocumentoAplicacionMes());
        } else {
            consulta.append(", val_docu_apli_mes_seri = null ");
        }
        if (getDocumentoAplicacionAnio() != null) {
            consulta.append(", val_docu_apli_anio = ? ");
            parametros.add(getDocumentoAplicacionAnio());
        } else {
            consulta.append(", val_docu_apli_anio = null ");
        }
        if (getDocumentoAplicacionNumero() != null) {
            consulta.append(", val_docu_apli_nume = ? ");
            parametros.add(getDocumentoAplicacionNumero());
        } else {
            consulta.append(", val_docu_apli_nume = null ");
        }
        if (getDocumentoCreacionMes() != null) {
            consulta.append(", val_docu_crea_mes_seri = ? ");
            parametros.add(getDocumentoCreacionMes());
        } else {
            consulta.append(", val_docu_crea_mes_seri = null ");
        }
        if (getDocumentoCreacionAnio() != null) {
            consulta.append(", val_docu_crea_anio = ? ");
            parametros.add(getDocumentoCreacionAnio());
        } else {
            consulta.append(", val_docu_crea_anio = null ");
        }
        if (getDigitoChequeoNumFac() != null) {
            consulta.append(", val_digi_cheq_fact = ? ");
            parametros.add(getDigitoChequeoNumFac());
        } else {
            consulta.append(", val_digi_cheq_fact = null ");
        }
        if (getNumeroLote() != null) {
            consulta.append(", num_lote = ? ");
            parametros.add(getNumeroLote());
        } else {
            consulta.append(", num_lote = null ");
        }
        if (getConsecutivoTransaccion() != null) {
            consulta.append(", num_cons_tran = ? ");
            parametros.add(getConsecutivoTransaccion());
        } else {
            consulta.append(", num_cons_tran = null ");
        }
        if (getCodigoConsultora() != null) {
            consulta.append(", cod_cons = ? ");
            parametros.add(getCodigoConsultora());
        } else {
            consulta.append(", cod_cons = null ");
        }
        if (getCodigoError() != null) {
            consulta.append(", cod_erro = ? ");
            parametros.add(getCodigoError());
        } else {
            consulta.append(", cod_erro = null ");
        }
        /*if (getCodigoConsultoraReal() != null) {
            consulta.append("cod_cons_real = ?, ");
            parametros.add(getCodigoConsultoraReal());
        } else {
            consulta.append("cod_cons_real = null, ");
        }*/
        if (getDocumentoCreacionNumero() != null) {
            consulta.append(", val_docu_crea_nume = ? ");
            parametros.add(getDocumentoCreacionNumero());
        } else {
            consulta.append(", val_docu_crea_nume = null ");
        }
        if (getIdentificadorProceso() != null) {
            consulta.append(", cod_iden_proc = ? ");
            parametros.add(getIdentificadorProceso());
        } else {
            consulta.append(", cod_iden_proc = null ");
        }
        if (getHorarioNormalAdicional() != null) {
            consulta.append(", val_hora_norm_adic = ? ");
            parametros.add(getHorarioNormalAdicional());
        } else {
            consulta.append(", val_hora_norm_adic = null ");
        }
        if (getImportePago() != null) {
            consulta.append(", imp_pago = ? ");
            parametros.add(getImportePago());
        } else {
            consulta.append(",  imp_pago = null ");
        }
        if (getNumeroCupon() != null) {
            consulta.append(", num_cupo = ? ");
            parametros.add(getNumeroCupon());
        } else {
            consulta.append(", num_cupo = null ");
        }
        if (getNombreOficina() != null) {
            consulta.append(", val_nomb_ofic = ? ");
            parametros.add(getNombreOficina());
        } else {
            consulta.append(", val_nomb_ofic = null ");
        }
        if (getHoraProceso() != null) {
            consulta.append(", val_hora_proc = ? ");
            parametros.add(getHoraProceso());
        } else {
            consulta.append(", val_hora_proc = null ");
        }
        if (getFechaContabilizacion() != null) {
            consulta.append(", fec_conta = ? ");
            parametros.add(getFechaContabilizacion());
        } else {
            consulta.append(", fec_conta = null ");
        }
        if (getEstatusMovimientoTesoreria() != null) {
            consulta.append(", val_esta_movi_pend = ? ");
            parametros.add(getEstatusMovimientoTesoreria());
        } else {
            consulta.append(", val_esta_movi_pend = null ");
        }
        if (getFechaMovimientoAplicacion() != null) {
            consulta.append(", fec_movi_apli = ? ");
            parametros.add(getFechaMovimientoAplicacion());
        } else {
            consulta.append(", fec_movi_apli = null ");
        }
        if (getFechaProceso() != null) {
            consulta.append(", fec_proc = ? ");
            parametros.add(getFechaProceso());
        } else {
            consulta.append(", fec_proc = null ");
        }
        if (getFechaPago() != null) {
            consulta.append(", fec_pago = ? ");
            parametros.add(getFechaPago());
        } else {
            consulta.append(", fec_pago = null ");
        }		
		if(getCodigoUsuario()!=null){
			consulta.append(", cod_usua = ? ");
			parametros.add(getCodigoUsuario());
		}
		else{
			consulta.append(", cod_usua = null ");
		}
		consulta.append("WHERE OID_MOVI_BANC = ?");

        parametros.add((Long)context.getPrimaryKey());
		
        try {   
			ejecutaSentencia(consulta.toString(), parametros);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EJBException(e);
		}
	
	}

	public void setEntityContext(EntityContext ctx) {
		context = ctx;
	}

	public void unsetEntityContext() {
		context = null;
	}

	public Long getCc() {
		return cc;
	}

	public void setCc(Long newCc) {
		cc = newCc;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long newCliente) {
		cliente = newCliente;
	}

	public String getCodigoConsultora() {
		return codigoConsultora;
	}

	public void setCodigoConsultora(String newCodigoConsultora) {
		codigoConsultora = newCodigoConsultora;
	}

	/*public String getCodigoConsultoraReal() {
		return codigoConsultoraReal;
	}

	public void setCodigoConsultoraReal(String newCodigoConsultoraReal) {
		codigoConsultoraReal = newCodigoConsultoraReal;
	}*/

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String newCodigoError) {
		codigoError = newCodigoError;
	}

	public Long getConsecutivoTransaccion() {
		return consecutivoTransaccion;
	}

	public void setConsecutivoTransaccion(Long newConsecutivoTransaccion) {
		consecutivoTransaccion = newConsecutivoTransaccion;
	}

	public Integer getDigitoChequeoNumFac() {
		return digitoChequeoNumFac;
	}

	public void setDigitoChequeoNumFac(Integer newDigitoChequeoNumFac) {
		digitoChequeoNumFac = newDigitoChequeoNumFac;
	}

	public String getDocumentoAplicacionAnio() {
		return documentoAplicacionAnio;
	}

	public void setDocumentoAplicacionAnio(String newDocumentoAplicacionAnio) {
		documentoAplicacionAnio = newDocumentoAplicacionAnio;
	}

	public String getDocumentoAplicacionMes() {
		return documentoAplicacionMes;
	}

	public void setDocumentoAplicacionMes(String newDocumentoAplicacionMes) {
		documentoAplicacionMes = newDocumentoAplicacionMes;
	}

	public Integer getDocumentoAplicacionNumero() {
		return documentoAplicacionNumero;
	}

	public void setDocumentoAplicacionNumero(Integer newDocumentoAplicacionNumero) {
		documentoAplicacionNumero = newDocumentoAplicacionNumero;
	}

	public String getDocumentoCreacionAnio() {
		return documentoCreacionAnio;
	}

	public void setDocumentoCreacionAnio(String newDocumentoCreacionAnio) {
		documentoCreacionAnio = newDocumentoCreacionAnio;
	}

	public String getDocumentoCreacionMes() {
		return documentoCreacionMes;
	}

	public void setDocumentoCreacionMes(String newDocumentoCreacionMes) {
		documentoCreacionMes = newDocumentoCreacionMes;
	}

	public Integer getDocumentoCreacionNumero() {
		return documentoCreacionNumero;
	}

	public void setDocumentoCreacionNumero(Integer newDocumentoCreacionNumero) {
		documentoCreacionNumero = newDocumentoCreacionNumero;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		empresa = newEmpresa;
	}

	public String getEstatusMovimientoTesoreria() {
		return estatusMovimientoTesoreria;
	}

	public void setEstatusMovimientoTesoreria(String newEstatusMovimientoTesoreria) {
		estatusMovimientoTesoreria = newEstatusMovimientoTesoreria;
	}

	public Date getFechaContabilizacion() {
		return fechaContabilizacion;
	}

	public void setFechaContabilizacion(Date newFechaContabilizacion) {
		fechaContabilizacion = newFechaContabilizacion;
	}

	public Timestamp getFechaMovimientoAplicacion() {
		return fechaMovimientoAplicacion;
	}

	public void setFechaMovimientoAplicacion(Timestamp newFechaMovimientoAplicacion) {
		fechaMovimientoAplicacion = newFechaMovimientoAplicacion;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date newFechaPago) {
		fechaPago = newFechaPago;
	}

	public Date getFechaPasoAHistorico() {
		return fechaPasoAHistorico;
	}

	public void setFechaPasoAHistorico(Date newFechaPasoAHistorico) {
		fechaPasoAHistorico = newFechaPasoAHistorico;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date newFechaProceso) {
		fechaProceso = newFechaProceso;
	}

	public Timestamp getHoraProceso() {
		return horaProceso;
	}

	public void setHoraProceso(Timestamp newHoraProceso) {
		horaProceso = newHoraProceso;
	}

	public String getHorarioNormalAdicional() {
		return horarioNormalAdicional;
	}

	public void setHorarioNormalAdicional(String newHorarioNormalAdicional) {
		horarioNormalAdicional = newHorarioNormalAdicional;
	}

	public String getIdentificadorProceso() {
		return identificadorProceso;
	}

	public void setIdentificadorProceso(String newIdentificadorProceso) {
		identificadorProceso = newIdentificadorProceso;
	}

	public BigDecimal getImporteAplicado() {
		return importeAplicado;
	}

	public void setImporteAplicado(BigDecimal newImporteAplicado) {
		importeAplicado = newImporteAplicado;
	}

	public BigDecimal getImportePago() {
		return importePago;
	}

	public void setImportePago(BigDecimal newImportePago) {
		importePago = newImportePago;
	}

	public Long getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Long newMovimiento) {
		movimiento = newMovimiento;
	}

	/*public Long getNMovimientoCaja() {
		return nMovimientoCaja;
	}

	public void setNMovimientoCaja(Long newNMovimientoCaja) {
		nMovimientoCaja = newNMovimientoCaja;
	}*/

	public String getNombreOficina() {
		return nombreOficina;
	}

	public void setNombreOficina(String newNombreOficina) {
		nombreOficina = newNombreOficina;
	}

	public Long getNumeroCupon() {
		return numeroCupon;
	}

	public void setNumeroCupon(Long newNumeroCupon) {
		numeroCupon = newNumeroCupon;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String newNumeroDocumento) {
		numeroDocumento = newNumeroDocumento;
	}

	public Long getNumeroFacturaOBoleta() {
		return numeroFacturaOBoleta;
	}

	public void setNumeroFacturaOBoleta(Long newNumeroFacturaOBoleta) {
		numeroFacturaOBoleta = newNumeroFacturaOBoleta;
	}

	public Integer getNumeroHistoria() {
		return numeroHistoria;
	}

	public void setNumeroHistoria(Integer newNumeroHistoria) {
		numeroHistoria = newNumeroHistoria;
	}

	public Long getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(Long newNumeroLote) {
		numeroLote = newNumeroLote;
	}

	public String getNumeroLoteContabilizacion() {
		return numeroLoteContabilizacion;
	}

	public void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion) {
		numeroLoteContabilizacion = newNumeroLoteContabilizacion;
	}

	public Long getNumeroLoteExterno() {
		return numeroLoteExterno;
	}

	public void setNumeroLoteExterno(Long newNumeroLoteExterno) {
		numeroLoteExterno = newNumeroLoteExterno;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		observaciones = newObservaciones;
	}

    //modificado tipo a string por inc 21735
	public String getOficinaRecaudadora() {
        return oficinaRecaudadora;
	}

    //modificado tipo a string por inc 21735
	public void setOficinaRecaudadora(String oficinaRecaudadora) {
        oficinaRecaudadora = oficinaRecaudadora;
	}

	public BigDecimal getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(BigDecimal newSaldoPendiente) {
		saldoPendiente = newSaldoPendiente;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Long getSubprocesoMarcasCreacion() {
		return subprocesoMarcasCreacion;
	}

	public void setSubprocesoMarcasCreacion(Long newSubprocesoMarcasCreacion) {
		subprocesoMarcasCreacion = newSubprocesoMarcasCreacion;
	}

	public Long getSubprocesoMarcasUltimo() {
		return subprocesoMarcasUltimo;
	}

	public void setSubprocesoMarcasUltimo(Long newSubprocesoMarcasUltimo) {
		subprocesoMarcasUltimo = newSubprocesoMarcasUltimo;
	}

	public Long getTipoError() {
		return tipoError;
	}

	public void setTipoError(Long newTipoError) {
		tipoError = newTipoError;
	}

	public Long getTiposAbonoCreacion() {
		return tiposAbonoCreacion;
	}

	public void setTiposAbonoCreacion(Long newTiposAbonoCreacion) {
		tiposAbonoCreacion = newTiposAbonoCreacion;
	}

	public Long getTiposAbonoUltimo() {
		return tiposAbonoUltimo;
	}

	public void setTiposAbonoUltimo(Long newTiposAbonoUltimo) {
		tiposAbonoUltimo = newTiposAbonoUltimo;
	}

	public Long getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Long newTransaccion) {
		transaccion = newTransaccion;
	}

	public String getUsuarioProceso() {
		return usuarioProceso;
	}

	public void setUsuarioProceso(String newUsuarioProceso) {
		usuarioProceso = newUsuarioProceso;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}
	public String getCodigoUsuario(){
		return codigoUsuario;
	}
	public void setCodigoUsuario(String newCodigoUsuario){
		codigoUsuario = newCodigoUsuario;
	}

    /** Metodo privado, para realizar consultas directas a la base por JDBC
     * @param consulta sentencia SQL con la consulta
     * @param argumentos valores de los parametros de la consulta
     * @return RecordSet con la respuesta a la consulta realizada */
	private RecordSet ejecutaConsulta(String consulta, Vector params) 
		throws EJBException
	{
		BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }

        RecordSet res;

        try {
            res = bs.dbService.executePreparedQuery(consulta, params);
        } catch (Exception e) {
            throw new EJBException(e);
        }
		loguearSql("**** BMP HistoricoMovimientosBanc: ", consulta, params);
        return res;
	}


    /** Metodo privado, para realizar consultas directas a la base por JDBC
     * @param query sentencia SQL con la consulta
     * @param argumentos valores de los parametros de la consulta
     * @return RecordSet con la respuesta a la consulta realizada */
    private int ejecutaSentencia(String query, Vector argumentos) 
		throws EJBException 
	{
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }
        try {
			loguearSql("**** BMP HistoricoMovimientosBanc: ", query, argumentos);		
		    return bs.dbService.executePreparedUpdate(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

	private void loguearSql(String metodo, String sql, Vector parametros) {

		UtilidadesLog.debug(metodo + sql);

		if (parametros != null && parametros.size() > 0) {
			String sparametros = "";
			for (int i=0; i<parametros.size(); i++) {
				if (parametros.elementAt(i) != null)
					sparametros += "param "+ (i+1) + ": " +  (parametros.elementAt(i)).toString() + ", ";
				else
					sparametros += "param "+ (i+1) + ": es nulo, ";
			}
			UtilidadesLog.debug(metodo + sparametros);
		}		
	}	

	private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
			e.printStackTrace();
			UtilidadesLog.debug("No se pudo obtener el objeto Log");
			throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}

	/**
	 * Metodo ejbCreate al que se le pasan solo los parametros obligatorios
	 */
	public Long ejbCreate(Date fechaPasoAHistorico,
							Long cc,
							Long empresa,
							Long subprocesoMarcasCreacion,
							Long tiposAbonoCreacion,
							Long cliente)
							//Long subacceso)
		throws CreateException 
	{

		Vector parametros = new Vector();

		// Asignar el nuevo oid
		try {
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_HMBA_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

		setFechaPasoAHistorico(fechaPasoAHistorico);
		setCc(cc);
		setEmpresa(empresa);
		setSubprocesoMarcasCreacion(subprocesoMarcasCreacion);
		setTiposAbonoCreacion(tiposAbonoCreacion);
		setCliente(cliente);
		//setSubacceso(subacceso);
		

		// se crea la consulta SQL
		StringBuffer consulta = new StringBuffer("");

		consulta.append("INSERT INTO CCC_HISTO_MOVIM_BANCA (");
		consulta.append("oid_movi_banc, ");
		consulta.append("tcab_oid_tipo_carg_abon_crea, ");
	  	consulta.append("soci_oid_soci, ");
		consulta.append("clie_oid_clie, ");
		consulta.append("fec_paso_hist, ");          
		consulta.append("subp_oid_subp_crea, ");
		consulta.append("ccba_oid_cuen_corr_banc ");
		//consulta.append("sbac_oid_sbac ");
		

		parametros.add(getOid());
		parametros.add(getTiposAbonoCreacion());
		parametros.add(getEmpresa());
		parametros.add(getCliente());
		parametros.add(getFechaPasoAHistorico());
		parametros.add(getSubprocesoMarcasCreacion());
		parametros.add(getCc());
		//parametros.add(getSubacceso());		

		consulta.append(") VALUES (?");
        for (int i = 1; i < parametros.size(); i++) {
            consulta.append(", ?");
        }
        consulta.append(")");

		// se ejecuta la sentencia		
		try {
			ejecutaSentencia(consulta.toString(), parametros);
		} catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else
				throw ejbe;
		}
        
        return getOid();
		
	}

	public void ejbPostCreate(Date fechaPasoAHistorico,
							Long cc,
							Long empresa,
							Long subprocesoMarcasCreacion,
							Long tiposAbonoCreacion,
							Long cliente){
							//Long subacceso) {
	}

	/**
	 * Metodo ejbCreate al que se le pasan todos los parametros
	 */
	public Long ejbCreate(Date fechaPasoAHistorico,
							Long cc,
							Long empresa,
							Long subprocesoMarcasCreacion,
							Long tiposAbonoCreacion,
							Long cliente,
							Long subacceso,
							Long numeroLote,
							Long consecutivoTransaccion,
							Integer numeroHistoria,
							Long numeroFacturaOBoleta,
							Date fechaPago,
							BigDecimal importePago,
							BigDecimal importeAplicado,
							BigDecimal saldoPendiente,
							Long numeroCupon,
							String codigoConsultora,
							Integer digitoChequeoNumFac,
                            //modificado tipo a string por inc 21735
							String oficinaRecaudadora,
							String nombreOficina,
							String numeroDocumento,
							String horarioNormalAdicional,
							String usuarioProceso,
							Date fechaProceso,
							Timestamp horaProceso,
							//String codigoConsultoraReal,
							String documentoCreacionMes,
							String documentoCreacionAnio,
							Integer documentoCreacionNumero,
							String documentoAplicacionMes,
							String documentoAplicacionAnio,
							Integer documentoAplicacionNumero,
							Timestamp fechaMovimientoAplicacion,
							String codigoError,
							String estatusMovimientoTesoreria,
							String identificadorProceso,
							String numeroLoteContabilizacion,
							Date fechaContabilizacion,
							String observaciones,
							Long numeroLoteExterno,
							//Long nMovimientoCaja,
							Long subprocesoMarcasUltimo,
							Long tiposAbonoUltimo,
							Long transaccion,
							Long movimiento,
							Long tipoError,
							String codigoUsuario) 
		throws CreateException 
	{

		Vector parametros = new Vector();

		// Asignar el nuevo oid
		try {
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_HMBA_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

		setFechaPasoAHistorico(fechaPasoAHistorico);
		setCc(cc);
		setEmpresa(empresa);
		setSubprocesoMarcasCreacion(subprocesoMarcasCreacion);
		setTiposAbonoCreacion(tiposAbonoCreacion);
		setCliente(cliente);
		setSubacceso(subacceso);

		setNumeroLote(numeroLote);
		setConsecutivoTransaccion(consecutivoTransaccion);
		setNumeroHistoria(numeroHistoria);
		setNumeroFacturaOBoleta(numeroFacturaOBoleta);
		setFechaPago(fechaPago);
		setImportePago(importePago);
		setImporteAplicado(importeAplicado);
		setSaldoPendiente(saldoPendiente);
		setNumeroCupon(numeroCupon);
		setCodigoConsultora(codigoConsultora);
		setDigitoChequeoNumFac(digitoChequeoNumFac);
		setOficinaRecaudadora(oficinaRecaudadora);
		setNombreOficina(nombreOficina);
		setNumeroDocumento(numeroDocumento);
		setHorarioNormalAdicional(horarioNormalAdicional);
		setUsuarioProceso(usuarioProceso);
		setFechaProceso(fechaProceso);
		setHoraProceso(horaProceso);
		//setCodigoConsultoraReal(codigoConsultoraReal);
		setDocumentoCreacionMes(documentoCreacionMes);
		setDocumentoCreacionAnio(documentoCreacionAnio);
		setDocumentoCreacionNumero(documentoCreacionNumero);
		setDocumentoAplicacionMes(documentoAplicacionMes);
		setDocumentoAplicacionAnio(documentoAplicacionAnio);
		setDocumentoAplicacionNumero(documentoAplicacionNumero);
		setFechaMovimientoAplicacion(fechaMovimientoAplicacion);
		setCodigoError(codigoError);
		setEstatusMovimientoTesoreria(estatusMovimientoTesoreria);
		setIdentificadorProceso(identificadorProceso);
		setNumeroLoteContabilizacion(numeroLoteContabilizacion);
		setFechaContabilizacion(fechaContabilizacion);
		setObservaciones(observaciones);
		setNumeroLoteExterno(numeroLoteExterno);
		//setNMovimientoCaja(nMovimientoCaja);
		setSubprocesoMarcasUltimo(subprocesoMarcasUltimo);
		setTiposAbonoUltimo(tiposAbonoUltimo);
		setTransaccion(transaccion);
		setMovimiento(movimiento);
		setTipoError(tipoError);
		setCodigoUsuario(codigoUsuario);
		// se crea la consulta SQL
		StringBuffer consulta = new StringBuffer("");

		consulta.append("INSERT INTO CCC_HISTO_MOVIM_BANCA (");
		consulta.append("oid_movi_banc, ");
		consulta.append("tcab_oid_tipo_carg_abon_crea, ");
	  	consulta.append("soci_oid_soci, ");
		consulta.append("clie_oid_clie, ");
		consulta.append("fec_paso_hist, ");          
		consulta.append("subp_oid_subp_crea, ");
		consulta.append("ccba_oid_cuen_corr_banc ");
		

		parametros.add(getOid());
		parametros.add(getTiposAbonoCreacion());
		parametros.add(getEmpresa());
		parametros.add(getCliente());
		parametros.add(getFechaPasoAHistorico());
		parametros.add(getSubprocesoMarcasCreacion());
		parametros.add(getCc());
		

		// CAMPOS NO OBLIGATORIOS
		if(getSubacceso()!=null){
			consulta.append(", sbac_oid_sbac ");
			parametros.add(getSubacceso());
		}
		if (getUsuarioProceso() != null) {
			consulta.append(", val_usua_proc ");			
			parametros.add(getUsuarioProceso());
		}
		if (getNumeroHistoria() != null) {
			consulta.append(", num_hist ");			
			parametros.add(getNumeroHistoria());
		}
		if (getMovimiento() != null) {
			consulta.append(", cmba_oid_movi_banc ");			
			parametros.add(getMovimiento());
		}
		if (getOficinaRecaudadora() != null) {
			consulta.append(", cod_ofic_reca ");			
			parametros.add(getOficinaRecaudadora());
		}
		if (getNumeroDocumento() != null) {
			consulta.append(", val_nume_docu ");			
			parametros.add(getNumeroDocumento());
		}				
		if (getNumeroFacturaOBoleta() != null) {
			consulta.append(", num_fact_bole ");			
			parametros.add(getNumeroFacturaOBoleta());
		}
		if (getObservaciones() != null) {
			consulta.append(", val_obse ");			
			parametros.add(getObservaciones());
		}
		if (getNumeroLoteContabilizacion() != null) {
			consulta.append(", val_num_lote_cont ");			
			parametros.add(getNumeroLoteContabilizacion());
		}
		if (getTipoError() != null) {
			consulta.append(", tier_oid_erro ");			
			parametros.add(getTipoError());
		}
		if (getTiposAbonoUltimo() != null) {
			consulta.append(", tcab_oid_tipo_carg_abon_ulti ");			
			parametros.add(getTiposAbonoUltimo());
		}				
		if (getTransaccion() != null) {
			consulta.append(", ttra_oid_tipo_tran ");			
			parametros.add(getTransaccion());
		}
		if (getSubprocesoMarcasUltimo() != null) {
			consulta.append(", subp_oid_subp_ulti ");			
			parametros.add(getSubprocesoMarcasUltimo());
		}
		if (getSaldoPendiente() != null) {
			consulta.append(", imp_sald_pend ");			
			parametros.add(getSaldoPendiente());
		}
		if (getImporteAplicado() != null) {
			consulta.append(", imp_apli ");			
			parametros.add(getImporteAplicado());
		}
		/*if (getNMovimientoCaja() != null) {
			consulta.append(", num_movi_caja");			
			parametros.add(getNMovimientoCaja());
		}*/
		if (getNumeroLoteExterno() != null) {
			consulta.append(", num_lote_exte ");			
			parametros.add(getNumeroLoteExterno());
		}
		if (getDocumentoAplicacionMes() != null) {
			consulta.append(", val_docu_apli_mes_seri ");			
			parametros.add(getDocumentoAplicacionMes());
		}
		if (getDocumentoAplicacionAnio() != null) {
			consulta.append(", val_docu_apli_anio ");			
			parametros.add(getDocumentoAplicacionAnio());
		}
		if (getDocumentoAplicacionNumero() != null) {
			consulta.append(", val_docu_apli_nume ");			
			parametros.add(getDocumentoAplicacionNumero());
		}
		if (getDocumentoCreacionMes() != null) {
			consulta.append(", val_docu_crea_mes_seri ");			
			parametros.add(getDocumentoCreacionMes());
		}				
		if (getDocumentoCreacionAnio() != null) {
			consulta.append(", val_docu_crea_anio ");			
			parametros.add(getDocumentoCreacionAnio());
		}
		if (getDigitoChequeoNumFac() != null) {
			consulta.append(", val_digi_cheq_fact ");			
			parametros.add(getDigitoChequeoNumFac());
		}
		if (getNumeroLote() != null) {
			consulta.append(", num_lote ");			
			parametros.add(getNumeroLote());
		}
		if (getConsecutivoTransaccion() != null) {
			consulta.append(", num_cons_tran ");			
			parametros.add(getConsecutivoTransaccion());
		}
		if (getCodigoConsultora() != null) {
			consulta.append(", cod_cons ");			
			parametros.add(getCodigoConsultora());
		}				
		if (getCodigoError() != null) {
			consulta.append(", cod_erro ");			
			parametros.add(getCodigoError());
		}
		/*if (getCodigoConsultoraReal() != null) {
			consulta.append(", cod_cons_real");			
			parametros.add(getCodigoConsultoraReal());
		}*/
		if (getDocumentoCreacionNumero() != null) {
			consulta.append(", val_docu_crea_nume ");			
			parametros.add(getDocumentoCreacionNumero());
		}
		if (getIdentificadorProceso() != null) {
			consulta.append(", cod_iden_proc ");			
			parametros.add(getIdentificadorProceso());
		}
		if (getHorarioNormalAdicional() != null) {
			consulta.append(", val_hora_norm_adic ");			
			parametros.add(getHorarioNormalAdicional());
		}				
		if (getImportePago() != null) {
			consulta.append(", imp_pago ");			
			parametros.add(getImportePago());
		}
		if (getNumeroCupon() != null) {
			consulta.append(", num_cupo ");			
			parametros.add(getNumeroCupon());
		}
		if (getNombreOficina() != null) {
			consulta.append(", val_nomb_ofic ");			
			parametros.add(getNombreOficina());
		}
		if (getHoraProceso() != null) {
			consulta.append(", val_hora_proc ");			
			parametros.add(getHoraProceso());
		}
		if (getFechaContabilizacion() != null) {
			consulta.append(", fec_conta ");			
			parametros.add(getFechaContabilizacion());
		}
		if (getEstatusMovimientoTesoreria() != null) {
			consulta.append(", val_esta_movi_pend ");			
			parametros.add(getEstatusMovimientoTesoreria());
		}
		if (getFechaMovimientoAplicacion() != null) {
			consulta.append(", fec_movi_apli ");			
			parametros.add(getFechaMovimientoAplicacion());
		}
		if (getFechaProceso() != null) {
			consulta.append(", fec_proc ");			
			parametros.add(getFechaProceso());
		}
		if (getFechaPago() != null) {
			consulta.append(", fec_pago ");			
			parametros.add(getFechaPago());
		}		
		if(getCodigoUsuario()!=null){
			consulta.append(", cod_usua ");
			parametros.add(getCodigoUsuario());
		}
		
		consulta.append(") VALUES (?");
        for (int i = 1; i < parametros.size(); i++) {
            consulta.append(", ?");
        }
        consulta.append(")");

		// se ejecuta la sentencia		
		try {
			ejecutaSentencia(consulta.toString(), parametros);
		} catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else
				throw ejbe;
		}
        
        return getOid();
	}	 

	public void ejbPostCreate(Date fechaPasoAHistorico,
							Long cc,
							Long empresa,
							Long subprocesoMarcasCreacion,
							Long tiposAbonoCreacion,
							Long cliente,
							Long subacceso,
							Long numeroLote,
							Long consecutivoTransaccion,
							Integer numeroHistoria,
							Long numeroFacturaOBoleta,
							Date fechaPago,
							BigDecimal importePago,
							BigDecimal importeAplicado,
							BigDecimal saldoPendiente,
							Long numeroCupon,
							String codigoConsultora,
							Integer digitoChequeoNumFac,
							String oficinaRecaudadora,
							String nombreOficina,
							String numeroDocumento,
							String horarioNormalAdicional,
							String usuarioProceso,
							Date fechaProceso,
							Timestamp horaProceso,
							//String codigoConsultoraReal,
							String documentoCreacionMes,
							String documentoCreacionAnio,
							Integer documentoCreacionNumero,
							String documentoAplicacionMes,
							String documentoAplicacionAnio,
							Integer documentoAplicacionNumero,
							Timestamp fechaMovimientoAplicacion,
							String codigoError,
							String estatusMovimientoTesoreria,
							String identificadorProceso,
							String numeroLoteContabilizacion,
							Date fechaContabilizacion,
							String observaciones,
							Long numeroLoteExterno,
							//Long nMovimientoCaja,
							Long subprocesoMarcasUltimo,
							Long tiposAbonoUltimo,
							Long transaccion,
							Long movimiento,
							Long tipoError,
							String codigoUsuario) {
	}

	
	
}