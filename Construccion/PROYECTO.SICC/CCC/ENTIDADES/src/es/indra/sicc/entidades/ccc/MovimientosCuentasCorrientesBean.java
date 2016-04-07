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

	/**
	 * Sistema:		Belcorp
	 * Modulo:	   	CCC
	 * Submódulo:		
	 * Componente:		ENTIDADES
	 * Fecha: 20/04/2004
	 * Observaciones:     	Componente construido de acuerdo a la especificación del 
	 *          Modelo de Componentes SICC-DMCO-CCC-201-303 CCC
	 * Descripcion:		Este componente mapea a la tabla CCC_MOVIM_CUENT_CORRI 
	 * @version		1.0
	 * @autor		Francisco Martín
	 */

package es.indra.sicc.entidades.ccc;

import java.util.Vector;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import java.sql.SQLException;

import java.sql.Date;
import java.sql.Timestamp;

import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.BelcorpService;

//import es.indra.mare.common.mii.MareMii;
//import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
//import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;

//import org.apache.commons.logging.Log;

public class MovimientosCuentasCorrientesBean implements EntityBean {


	// atributos del entity
	public Long oid;
	//public String numeroSerieCuota; // incidencia BELC300007548
	public Integer numeroIdentificadorCuota;
	public String ejercicioCuota;
	public Integer numeroOrdenCuota; 
	public String referenciaNumeroDocumentoExterno;
	public Timestamp fechaUltimoMovimiento;
	public Timestamp fechaDocumento;
	public Date fechaVencimiento;
	public Timestamp fechaValor;
	public Double importe;
	public Double importePagado;
	public Double importePendiente;
	public Double importeDivisa;
	public Double importePagadoDivisa;
	public String documentoMesSerie;
	public String documentoAnyo;
	public Integer documentoNumero;
	public String ultimoDocumentoMesSerie;
	public String ultimoDocumentoAnyo;
	public Integer ultimoDocumentoNumero;
	public Integer ultimoNumeroHistoria;
	public String numeroLoteContabilizacion;
	public Date fechaContabilizacion;
	public String observaciones;
	public Boolean indicaDescuentoRecargo;
	public Integer numeroLoteFacturacion; // hoja control cambios 17/08
	public BigDecimal tipoCambio; // hoja control cambios 17/08
	public String codigoUsuario; // hoja control cambios 17/08
	//public String dcAplicado; // hoja control cambios 17/08
	public BigDecimal importePago; // incidencia 7546
	public BigDecimal importePagoDivisa; // incidencia 7546
	public BigDecimal importeMovimiento; // incidencia 7552. Obligatorio
	public BigDecimal importeMovimientoDivisa; // incidencia 7546
	

	// relaciones con otras tablas. Claves foraneas
	public Long tipoAbonoCreacion;
	public Long tipoAbonoUltimo;
	public Long subprocesoDeCreacion;
	public Long subprocesoUltimo;
	public Long marcaSituacion;
	public Long cuentaOrigen;
	public Long cuentaCuota;
	public Long territorioAdministrativo;
	public Long subacceso;
	public Long empresa;
	public Long divisa;
	public Long cliente;
	public Long medioPago;
	public Long tipoCliente;
	public Long periodoDesde;
	public Long marca;
	//public Long pais; // hoja control cambios 18/08
	public Long subtipoCliente; // hoja control cambios 17/08
	public Long sugerencia; // incidencia 7546
	public Long tipoPeriodo; // incidencia 7546
	public Long seccion; // incidencia 7546
	public Long consolidado; // hoja control cambios 17/08 (SOCA_OID_SOLI_CABE). No obligatorio. Ped.SolicitudCabecera
	public Long tipoDocumentoLegal; // hoja control cambios 17/08 (TIDO_OID_TIPO_DOCU). Obligatorio. Fac.TipoDocumentoLegal
	public Long tipoSolicitud; // hoja control cambios 17/08 (TSPA_OID_TIPO_SOLI_PAIS). Obligatorio. Ped.TipoSolicitudPais
	public Long region; // hoja control cambios 17/08 (ZORG_OID_REGI). Obligatorio. Zon.Region

	private EntityContext context;

	/**
	 * Metodo ejbCreate al que se le pasan solo los parametros obligatorios
	 */
	public Long ejbCreate(Long empresa, 
						Long marcaSituacion,
						// Long divisa, // BELC300004313
						Long periodoDesde,
						Long tipoAbonoUltimo,
						Long tipoAbonoCreacion,
						Long subacceso,
						Long subprocesoUltimo,
						Long subprocesoDeCreacion,
						Long cuentaOrigen,
						//Long cuentaCuota,
						Long cliente,
						String documentoAnyo,
						//String documentoMesSerie, // deja de ser obligatorio en la implantacion 2
						Integer documentoNumero,
						String ejercicioCuota,
						Timestamp fechaDocumento,
						Timestamp fechaUltimoMovimiento,
						Date fechaVencimiento, // BELC300004213									
						Double importe,
						Double importePagado,
						Double importePendiente,
						Integer numeroIdentificadorCuota,
						Integer numeroOrdenCuota,
						//String numeroSerieCuota,
						//Long medioPago, // BELC300004457
						Long TerritorioAdministrativo,
						//Long pais,
						Long tipoCliente, // BELC300004213
						BigDecimal tipoCambio, 
						String codigoUsuario,
						Long subtipoCliente,
						Long sugerencia,
						Long seccion,
						//Long tipoDocumentoLegal,
						//Long tipoSolicitud,
						Long region, 
						BigDecimal importeMovimiento)
		throws CreateException
	{
		Vector vector= new Vector();

		setEmpresa(empresa);
		setMarcaSituacion(marcaSituacion);
		//setDivisa(divisa);
		setPeriodoDesde(periodoDesde);
		setTipoAbonoUltimo(tipoAbonoUltimo);
		setTipoAbonoCreacion(tipoAbonoCreacion);
		setSubacceso(subacceso);
		setSubprocesoUltimo(subprocesoUltimo);
		setSubprocesoDeCreacion(subprocesoDeCreacion);
		setCuentaOrigen(cuentaOrigen);
		//setCuentaCuota(cuentaCuota);
		setCliente(cliente);
		setDocumentoAnyo(documentoAnyo);
		//setDocumentoMesSerie(documentoMesSerie);
		setDocumentoNumero(documentoNumero);
		setEjercicioCuota(ejercicioCuota);
		setFechaDocumento(fechaDocumento);
		setFechaUltimoMovimiento(fechaUltimoMovimiento);
		setFechaVencimiento(fechaVencimiento);
		setImporte(importe);
		setImportePagado(importePagado);
		setImportePendiente(importePendiente);
		setNumeroIdentificadorCuota(numeroIdentificadorCuota);
		setNumeroOrdenCuota(numeroOrdenCuota);
		//setNumeroSerieCuota(numeroSerieCuota);
		//setMedioPago(medioPago);
		setTerritorioAdministrativo(TerritorioAdministrativo);
		//setPais(pais);
		setTipoCliente(tipoCliente);
		setTipoCambio(tipoCambio);
		setCodigoUsuario(codigoUsuario);
		setSubtipoCliente(subtipoCliente);
		setSugerencia(sugerencia);
		setSeccion(seccion);
		//setTipoDocumentoLegal(tipoDocumentoLegal);
		//setTipoSolicitud(tipoSolicitud);
		setRegion(region);
		setImporteMovimiento(importeMovimiento);
				
		try {
			// Asignar el nuevo oid
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_MVCC_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}
		
        String query  = "INSERT INTO CCC_MOVIM_CUENT_CORRI (" +
						"oid_movi_cc, " +
			 			"soci_oid_soci, " +
						"masi_oid_marc_situ, " +
			            //"mone_oid_mone, " +
			            "perd_oid_peri, " +
						"tcab_oid_tcab_ulti, " +
			            "tcab_oid_tcab_crea, " +
						"sbac_oid_sbac, " +
						"subp_oid_subp_ulti, " +
						"subp_oid_subp_crea, " +
						"cuco_oid_cuen_cont_orig, " +
						//"cuco_oid_cuen_cont_cuot, " +
						"clie_oid_clie, " +
						"val_docu_anio, " +
						//"val_docu_mes_seri, " +
						"val_docu_nume, " +
						"val_ejer_cuot, " +
						"fec_docu, " +
						"fec_ulti_movi, " +
						"fec_venc, " +
						"imp_movi, " +
						"imp_paga, " +
						"imp_pend, " +
						"num_iden_cuot, " +
						"num_orde_cuot, " +
						//"val_nume_seri_cuot, " +
						//"mpab_oid_medi_pago, " +
						"ztad_oid_terr_admi, " +
						//"pais_oid_pais, " +
						"ticl_oid_tipo_clie, " +
						"ind_tipo_camb, " +
						"cod_usua, " +
						"sbti_oid_subt_clie, " +
						"zsgv_oid_subg_vent, " +
						"zscc_oid_secc, " +
						//"tido_oid_tipo_docu, " +
						//"tspa_oid_tipo_soli_pais, " +
						"zorg_oid_regi , " +
						"imp_movi_cuen ) " +
						"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		vector.add(getOid());
		vector.add(getEmpresa());
		vector.add(getMarcaSituacion());
		//vector.add(getDivisa());
		vector.add(getPeriodoDesde());
		vector.add(getTipoAbonoUltimo());
		vector.add(getTipoAbonoCreacion());
		vector.add(getSubacceso());
		vector.add(getSubprocesoUltimo());
		vector.add(getSubprocesoDeCreacion());
		vector.add(getCuentaOrigen());
		//vector.add(getCuentaCuota());
		vector.add(getCliente());
		vector.add(getDocumentoAnyo());
		//vector.add(getDocumentoMesSerie());
		vector.add(getDocumentoNumero());
		vector.add(getEjercicioCuota());
		vector.add(getFechaDocumento());
		vector.add(getFechaUltimoMovimiento());
		vector.add(getFechaVencimiento());
		vector.add(getImporte());
		vector.add(getImportePagado());
		vector.add(getImportePendiente());
		vector.add(getNumeroIdentificadorCuota());
		vector.add(getNumeroOrdenCuota());
		//vector.add(getNumeroSerieCuota());
		//vector.add(getMedioPago());
		vector.add(getTerritorioAdministrativo());
		//vector.add(getPais());
		vector.add(getTipoCliente());
		vector.add(getTipoCambio());
		vector.add(getCodigoUsuario());
		vector.add(getSubtipoCliente());
		vector.add(getSugerencia());
		vector.add(getSeccion());
		//vector.add(getTipoDocumentoLegal());
		//vector.add(getTipoSolicitud());
		vector.add(getRegion());
		vector.add(getImporteMovimiento());

		try {
			this.ejecutaSentencia(query.toString(), vector);
		} catch (EJBException ejbe) {
			ejbe.printStackTrace();
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else if (falloSQL.indexOf("ORA-02290") != -1){
				UtilidadesLog.error("Error Al insertar BMP movimientosCuentasCorrientes check Constraint Violated");
				throw new CreateException();
			}
			else
				throw ejbe;
		}catch (Exception e){
        e.printStackTrace();
        throw new CreateException();
    }
        
        return getOid();
	}

	public void ejbPostCreate(Long empresa, 
						Long marcaSituacion,
						// Long divisa, // BELC300004313
						Long periodoDesde,
						Long tipoAbonoUltimo,
						Long tipoAbonoCreacion,
						Long subacceso,
						Long subprocesoUltimo,
						Long subprocesoDeCreacion,
						Long cuentaOrigen,
						//Long cuentaCuota,
						Long cliente,
						String documentoAnyo,
						//String documentoMesSerie, // deja de ser obligatorio en la implantacion 2
						Integer documentoNumero,
						String ejercicioCuota,
						Timestamp fechaDocumento,
						Timestamp fechaUltimoMovimiento,
						Date fechaVencimiento, // BELC300004213									
						Double importe,
						Double importePagado,
						Double importePendiente,
						Integer numeroIdentificadorCuota,
						Integer numeroOrdenCuota,
						//String numeroSerieCuota,
						//Long medioPago, // BELC300004457
						Long TerritorioAdministrativo,
						//Long pais,
						Long tipoCliente, // BELC300004213
						BigDecimal tipoCambio, 
						String codigoUsuario,
						Long subtipoCliente,
						Long sugerencia,
						Long seccion,
						//Long tipoDocumentoLegal,
						//Long tipoSolicitud,
						Long region,
						BigDecimal importeMovimiento) {
	}


	/**
	 * Metodo ejbCreate al que se le pasan todos los parametros
	 */
	public Long ejbCreate(Long empresa,
						Long marcaSituacion,
						Long divisa,
						Long periodoDesde,
						Long tipoAbonoUltimo,
						Long tipoAbonoCreacion,
						Long subacceso,
						Long subprocesoUltimo,
						Long subprocesoDeCreacion,
						Long cuentaOrigen,
						Long cuentaCuota,
						Long cliente,
						String documentoAnyo,
						String documentoMesSerie,
						Integer documentoNumero,
						String ejercicioCuota,
						Date fechaContabilizacion,
						Timestamp fechaDocumento,
						Timestamp fechaUltimoMovimiento,
						Timestamp fechaValor,
						Date fechaVencimiento,
						Double importe,
						Double importeDivisa,
						Double importePagado,
						Double impPagadoDivisa,
						Double importePendiente,
						Boolean indicaDtoRecargo,
						Integer numeroIdentificadorCuota,
						String numLoteContab,
						Integer numeroOrdenCuota,
						//String numeroSerieCuota,
						String observaciones,
						String referenciaNumeroDocumentoExterno,
						String ultimoDocumentoAnyo,
						String ultimoDocumentoMesSerie,
						Integer ultimoDocumentoNumero,
						Integer ultimoNumeroHistoria,
						Long medioPago,
						Long TerritorioAdministrativo,
						//Long pais,
						Long tipoCliente,
						Long marca,
						BigDecimal tipoCambio, 
						String codigoUsuario,
						Long subtipoCliente,
						Long sugerencia,
						Long seccion,
						Integer numeroLoteFacturacion,
						//String dcAplicado,
						BigDecimal importePago,
						BigDecimal importePagoDivisa,
						BigDecimal importeMovimientoDivisa,
						Long tipoPeriodo,
						Long tipoDocumentoLegal,
						Long tipoSolicitud,
						Long region,
						Long consolidado,
						BigDecimal importeMovimiento) 
		throws CreateException
	{
		Vector vector= new Vector();

		setEmpresa(empresa);
		setMarcaSituacion(marcaSituacion);
		setDivisa(divisa);
		setPeriodoDesde(periodoDesde);
		setTipoAbonoUltimo(tipoAbonoUltimo);
		setTipoAbonoCreacion(tipoAbonoCreacion);
		setSubacceso(subacceso);
		setSubprocesoUltimo(subprocesoUltimo);
		setSubprocesoDeCreacion(subprocesoDeCreacion);
		setCuentaOrigen(cuentaOrigen);
		setCuentaCuota(cuentaCuota);
		setCliente(cliente);
		setDocumentoAnyo(documentoAnyo);
		setDocumentoMesSerie(documentoMesSerie);
		setDocumentoNumero(documentoNumero);
		setEjercicioCuota(ejercicioCuota);
		setFechaContabilizacion(fechaContabilizacion);
		setFechaDocumento(fechaDocumento);
		setFechaUltimoMovimiento(fechaUltimoMovimiento);
		setFechaValor(fechaValor);
		setFechaVencimiento(fechaVencimiento);
		setImporte(importe);
		setImporteDivisa(importeDivisa);
		setImportePagado(importePagado);
		setImportePagadoDivisa(impPagadoDivisa);
		setImportePendiente(importePendiente);
		setIndicaDescuentoRecargo(indicaDtoRecargo);
		setNumeroIdentificadorCuota(numeroIdentificadorCuota);
		setNumeroLoteContabilizacion(numLoteContab);
		setNumeroOrdenCuota(numeroOrdenCuota);
		//setNumeroSerieCuota(numeroSerieCuota);
		setObservaciones(observaciones);
		setReferenciaNumeroDocumentoExterno(referenciaNumeroDocumentoExterno);
		setUltimoDocumentoAnyo(ultimoDocumentoAnyo);
		setUltimoDocumentoMesSerie(ultimoDocumentoMesSerie);
		setUltimoDocumentoNumero(ultimoDocumentoNumero);
		setUltimoNumeroHistoria(ultimoNumeroHistoria);
		setMedioPago(medioPago);
		setTerritorioAdministrativo(TerritorioAdministrativo);
		//setPais(pais);
		setTipoCliente(tipoCliente);
		setMarca(marca);

		setTipoCambio(tipoCambio);
		setCodigoUsuario(codigoUsuario);
		setSubtipoCliente(subtipoCliente);
		setSugerencia(sugerencia);
		setSeccion(seccion);

		setNumeroLoteFacturacion(numeroLoteFacturacion);	
		//setDcAplicado(dcAplicado);
		setImportePago(importePago);
		setImportePagoDivisa(importePagoDivisa);
		setImporteMovimientoDivisa(importeMovimientoDivisa);
		setTipoPeriodo(tipoPeriodo);

		setTipoDocumentoLegal(tipoDocumentoLegal);
		setTipoSolicitud(tipoSolicitud);
		setRegion(region);

		setConsolidado(consolidado);

		setImporteMovimiento(importeMovimiento);


		try {
			// Asignar el nuevo oid
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_MVCC_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}
		
        StringBuffer consulta = new StringBuffer(""); 

		consulta.append("INSERT INTO CCC_MOVIM_CUENT_CORRI (" +
						"oid_movi_cc, " +
			 			"soci_oid_soci, " +
						"masi_oid_marc_situ");
		vector.add(getOid());
		vector.add(getEmpresa());
		vector.add(getMarcaSituacion());
		if (getDivisa() != null) {
			consulta.append(", mone_oid_mone");
			vector.add(getDivisa());	
		}
		
		consulta.append(", perd_oid_peri, " +
						"tcab_oid_tcab_ulti, " +
			            "tcab_oid_tcab_crea, " +
						"sbac_oid_sbac, " +
						"subp_oid_subp_ulti, " +
						"subp_oid_subp_crea, " +
						"cuco_oid_cuen_cont_orig, " +
						"clie_oid_clie, " +
						"val_docu_anio, " +
						"val_docu_nume, " +
						"val_ejer_cuot"); 
	
		vector.add(getPeriodoDesde());
		vector.add(getTipoAbonoUltimo());
		vector.add(getTipoAbonoCreacion());
		vector.add(getSubacceso());
		vector.add(getSubprocesoUltimo());
		vector.add(getSubprocesoDeCreacion());
		vector.add(getCuentaOrigen());
		vector.add(getCliente());
		vector.add("'"+getDocumentoAnyo()+"'");
		vector.add(getDocumentoNumero());
		vector.add("'"+getEjercicioCuota()+"'");

		if (getCuentaCuota() != null) {
			consulta.append(", cuco_oid_cuen_cont_cuot");
			vector.add(getCuentaCuota());	
		}
		
		if (getDocumentoMesSerie() != null) {
			consulta.append(", val_docu_mes_seri");
			vector.add("'"+getDocumentoMesSerie()+"'");	
		}

        // formatos de fecha gdm
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");         
        SimpleDateFormat sdfHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if (getFechaContabilizacion() != null) {
          consulta.append(", fec_conta");
          vector.add("TO_DATE('"+sdf.format(this.getFechaContabilizacion())+"','DD/MM/YYYY')");
          //vector.add(new java.sql.Date(sdf.parse(sdf.format(this.getFechaContabilizacion()).toString()).getTime()));	
        }
        consulta.append(", fec_docu"); 
        vector.add("TO_DATE('"+sdf.format(this.getFechaDocumento())+"','DD/MM/YYYY')");
        //vector.add(new java.sql.Date(sdf.parse(sdf.format(this.getFechaDocumento()).toString()).getTime()));	
    
        consulta.append(", fec_ulti_movi");
        vector.add("TO_DATE('"+sdfHora.format(this.getFechaUltimoMovimiento())+"','DD/MM/YYYY HH24:MI:SS')");
        //vector.add(sdfHora.parse(sdfHora.format(this.getFechaUltimoMovimiento()).toString()));		
        
        if (getFechaValor() != null) {
          consulta.append(", fec_valo");
          vector.add("TO_DATE('"+sdf.format(this.getFechaValor())+"','DD/MM/YYYY')");
          //vector.add(new java.sql.Date(sdf.parse(sdf.format(this.getFechaValor()).toString()).getTime()));		
        }
        
        consulta.append(", fec_venc");
        vector.add("TO_DATE('"+sdf.format(this.getFechaVencimiento())+"','DD/MM/YYYY')");
        //vector.add(new java.sql.Date(sdf.parse(sdf.format(this.getFechaVencimiento()).toString()).getTime()));		
    
        consulta.append(", imp_movi"); 
        vector.add(getImporte());


		if (getImporteDivisa() != null) {
			consulta.append(", imp_divi");
			vector.add(getImporteDivisa());
		}

		consulta.append(", imp_paga");
		vector.add(getImportePagado());

		if (getImportePagadoDivisa() != null) {
			consulta.append(", imp_paga_divi");
			vector.add(getImportePagadoDivisa());
		}

		consulta.append(", imp_pend");
		vector.add(getImportePendiente());

		if (getIndicaDescuentoRecargo() != null) {
			consulta.append(", ind_dto_carg_apli");
            if(getIndicaDescuentoRecargo().booleanValue()){
                vector.add(new Integer("1"));    
            }else{
                vector.add(new Integer("0"));
            }
		}
		consulta.append(", num_iden_cuot");
		vector.add(getNumeroIdentificadorCuota());

		if (getNumeroLoteContabilizacion() != null) {
			consulta.append(", val_nume_lote_cont");
			vector.add("'"+getNumeroLoteContabilizacion()+"'");
		}

		consulta.append(", num_orde_cuot");
		vector.add(getNumeroOrdenCuota());
						
		/*consulta.append(", val_nume_seri_cuot");
		vector.add(getNumeroSerieCuota());*/

		if (getObservaciones() != null) {
			consulta.append(", val_obse");
			vector.add("'"+getObservaciones()+"'");
		}
						
		if (getReferenciaNumeroDocumentoExterno() != null) {
			consulta.append(", val_refe_nume_docu_exte");
			vector.add("'"+getReferenciaNumeroDocumentoExterno()+"'");
		}
						
		if (getUltimoDocumentoAnyo() != null) {
			consulta.append(", val_ulti_docu_anio");
			vector.add("'"+getUltimoDocumentoAnyo()+"'");
		}
						
		if (getUltimoDocumentoMesSerie() != null) {
			consulta.append(", val_ulti_docu_mes_seri");
			vector.add("'"+getUltimoDocumentoMesSerie()+"'");
		}
						
		if (getUltimoDocumentoNumero() != null) {
			consulta.append(", val_ulti_docu_nume");
			vector.add(getUltimoDocumentoNumero());
		}

		if (getUltimoNumeroHistoria() != null) {
			consulta.append(", val_ulti_nume_hist");
			vector.add(getUltimoNumeroHistoria());
		}

		if (getMedioPago() != null) {
			consulta.append(", mpab_oid_medi_pago");
			vector.add(getMedioPago());
		}
						
		consulta.append(", ztad_oid_terr_admi");
		vector.add(getTerritorioAdministrativo());
						
		/*consulta.append(", pais_oid_pais");
		vector.add(getPais());*/

		consulta.append(", ticl_oid_tipo_clie");
		vector.add(getTipoCliente());
						
		if (getMarca() != null) {
			consulta.append(", marc_oid_marc");			
			vector.add(getMarca());
		}

		consulta.append(", ind_tipo_camb");
		vector.add(getTipoCambio());
		consulta.append(", cod_usua");
		vector.add("'"+getCodigoUsuario()+"'");
		consulta.append(", sbti_oid_subt_clie");
		vector.add(getSubtipoCliente());
		consulta.append(", zsgv_oid_subg_vent");
		vector.add(getSugerencia());
		consulta.append(", zscc_oid_secc");
		vector.add(getSeccion());

		if (getNumeroLoteFacturacion() != null) {
			consulta.append(", num_lote_fact");			
			vector.add(getNumeroLoteFacturacion());
		}
		/*if (getDcAplicado() != null) {
			consulta.append(", ind_dto_carg_apli");			
			vector.add(getDcAplicado());
		}*/
		if (getImportePago() != null) {
			consulta.append(", imp_pago");	
			vector.add(getImportePago());
		}
		if (getImportePagoDivisa() != null) {
			consulta.append(", imp_pago_divi");			
			vector.add(getImportePagoDivisa());
		}else{
        consulta.append(", imp_pago_divi");	
        vector.add(new Double(0));
    }
		if (getImporteMovimientoDivisa() != null) {
			consulta.append(", imp_movi_divi");			
			vector.add(getImporteMovimientoDivisa());
		}
		if (getTipoPeriodo() != null) {
			consulta.append(", tipe_oid_tipo_peri");			
			vector.add(getTipoPeriodo());
		}

		if (getTipoDocumentoLegal() != null) {
			consulta.append(", tido_oid_tipo_docu");
			vector.add(getTipoDocumentoLegal());
		}
		if (getTipoSolicitud() != null) {
			consulta.append(", tspa_oid_tipo_soli_pais");
			vector.add(getTipoSolicitud());
		}
		consulta.append(", zorg_oid_regi");
		vector.add(getRegion());

		if (getConsolidado() != null) {
			consulta.append(", soca_oid_soli_cabe");			
			vector.add(getConsolidado());
		}
		
		consulta.append(", imp_movi_cuen ");
		vector.add(getImporteMovimiento());


		consulta.append(") VALUES (").append(vector.get(0));
        for (int i = 1; i < vector.size(); i++){
            consulta.append(", ").append(vector.get(i));
        }
        consulta.append(")");
                

		try {
            BelcorpService.getInstance().dbService.executeUpdate(consulta.toString());
		} catch (EJBException ejbe) {
            
            UtilidadesLog.error("-GA- Error en create: ",ejbe);
        
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else if (falloSQL.indexOf("ORA-02290") != -1){
				UtilidadesLog.debug("Error al Insertar BMP movimientosCuentasCorrientes: Check Constraint Violated");
				throw new CreateException();
			}
			else
				throw ejbe;
		}catch (Exception e){
            e.printStackTrace();
            throw new CreateException(e.getCause().getMessage());
        }
        return getOid();
	}

	public void ejbPostCreate(Long empresa, 
						Long marcaSituacion,
						Long divisa,
						Long periodoDesde,
						Long tipoAbonoUltimo,
						Long tipoAbonoCreacion,
						Long subacceso,
						Long subprocesoUltimo,
						Long subprocesoDeCreacion,
						Long cuentaOrigen,
						Long cuentaCuota,
						Long cliente,
						String documentoAnyo,
						String documentoMesSerie,
						Integer documentoNumero,
						String ejercicioCuota,
						Date fechaContabilizacion,
						Timestamp fechaDocumento,
						Timestamp fechaUltimoMovimiento,
						Timestamp fechaValor,
						Date fechaVencimiento,
						Double importe,
						Double importeDivisa,
						Double importePagado,
						Double impPagadoDivisa,
						Double importePendiente,
						Boolean indicaDtoRecargo,
						Integer numeroIdentificadorCuota,
						String numLoteContab,
						Integer numeroOrdenCuota,
						//String numeroSerieCuota,
						String observaciones,
						String referenciaNumeroDocumentoExterno,
						String ultimoDocumentoAnyo,
						String ultimoDocumentoMesSerie,
						Integer ultimoDocumentoNumero,
						Integer ultimoNumeroHistoria,
						Long medioPago,
						Long TerritorioAdministrativo,
						//Long pais,
						Long tipoCliente,
						Long marca,
						BigDecimal tipoCambio, 
						String codigoUsuario,
						Long subtipoCliente,
						Long sugerencia,
						Long seccion,
						Integer numeroLoteFacturacion,
						//String dcAplicado,
						BigDecimal importePago,
						BigDecimal importePagoDivisa,
						BigDecimal importeMovimientoDivisa,
						Long tipoPeriodo,
						Long tipoDocumentoLegal,
						Long tipoSolicitud,
						Long region,
						Long consolidado,
						BigDecimal importeMovimiento) {
							
	}

	public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException	{

		Vector parametros = new Vector();

		String consulta = "SELECT OID_MOVI_CC FROM CCC_MOVIM_CUENT_CORRI " +
							"WHERE OID_MOVI_CC = ?";

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

	public void ejbLoad() {

		Vector params = new Vector();

        String consulta  = "SELECT * FROM CCC_MOVIM_CUENT_CORRI WHERE OID_MOVI_CC = ?";
		params.add((Long)context.getPrimaryKey());
                   
        RecordSet respuesta;
        BelcorpService bs;

        try {
	        respuesta = this.ejecutaConsulta(consulta, params);
        } catch (Exception exception) {
		    throw new EJBException(exception);
        }


        UtilidadesLog.debug(respuesta);
		if (!respuesta.esVacio()) {
			// Al oid le damos la primary key, esto es obligatorio hacerlo, pues
			// si venimos de un findby, el oid no se cargaría
			this.setOid((Long)context.getPrimaryKey());
			setEmpresa(new Long(((BigDecimal)respuesta.getValueAt(0, "soci_oid_soci".toUpperCase())).longValue()));
            setMarcaSituacion(new Long(((BigDecimal)respuesta.getValueAt(0, "masi_oid_marc_situ".toUpperCase())).longValue()));
            setDivisa(respuesta.getValueAt(0, "mone_oid_mone".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "mone_oid_mone".toUpperCase())).longValue()) : null); // nullable
            setPeriodoDesde(new Long(((BigDecimal)respuesta.getValueAt(0, "perd_oid_peri".toUpperCase())).longValue()));
            setTipoAbonoUltimo(new Long(((BigDecimal)respuesta.getValueAt(0, "tcab_oid_tcab_ulti".toUpperCase())).longValue()));
            setTipoAbonoCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "tcab_oid_tcab_crea".toUpperCase())).longValue()));
            setSubacceso(new Long(((BigDecimal)respuesta.getValueAt(0, "sbac_oid_sbac".toUpperCase())).longValue()));
            setSubprocesoUltimo(new Long(((BigDecimal)respuesta.getValueAt(0, "subp_oid_subp_ulti".toUpperCase())).longValue()));
            setSubprocesoDeCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "subp_oid_subp_crea".toUpperCase())).longValue()));
            setCuentaOrigen(new Long(((BigDecimal)respuesta.getValueAt(0, "cuco_oid_cuen_cont_orig".toUpperCase())).longValue()));			
            setCliente(new Long(((BigDecimal)respuesta.getValueAt(0, "clie_oid_clie".toUpperCase())).longValue()));
            setDocumentoAnyo(respuesta.getValueAt(0, "val_docu_anio".toUpperCase()).toString());			
            setDocumentoNumero(new Integer(((BigDecimal)respuesta.getValueAt(0, "val_docu_nume".toUpperCase())).intValue()));
            setEjercicioCuota((String)respuesta.getValueAt(0, "val_ejer_cuot".toUpperCase()));
            setFechaVencimiento((Date)respuesta.getValueAt(0, "fec_venc".toUpperCase()));
            setFechaDocumento(new Timestamp(((Date)respuesta.getValueAt(0, "fec_docu".toUpperCase())).getTime()) );
            setFechaUltimoMovimiento(new Timestamp(((Date)respuesta.getValueAt(0, "fec_ulti_movi".toUpperCase())).getTime()) );
            setImporte(new Double(((BigDecimal)respuesta.getValueAt(0, "imp_movi".toUpperCase())).doubleValue()));
            setNumeroOrdenCuota(new Integer(((BigDecimal)respuesta.getValueAt(0, "num_orde_cuot".toUpperCase())).intValue()));
            setImportePagado(new Double(((BigDecimal)respuesta.getValueAt(0, "imp_paga".toUpperCase())).doubleValue()));
            setNumeroIdentificadorCuota(new Integer(((BigDecimal)respuesta.getValueAt(0, "num_iden_cuot".toUpperCase())).intValue()));
            setTerritorioAdministrativo(new Long(((BigDecimal)respuesta.getValueAt(0, "ztad_oid_terr_admi".toUpperCase())).longValue()));
            setTipoCliente(new Long(((BigDecimal)respuesta.getValueAt(0, "ticl_oid_tipo_clie".toUpperCase())).longValue()));
      			setDocumentoMesSerie(respuesta.getValueAt(0, "val_docu_mes_seri".toUpperCase())!=null ? (String)respuesta.getValueAt(0, "val_docu_mes_seri".toUpperCase()):null);
            setCuentaCuota(respuesta.getValueAt(0, "cuco_oid_cuen_cont_cuot".toUpperCase())!=null ? new Long(((BigDecimal)respuesta.getValueAt(0, "cuco_oid_cuen_cont_cuot".toUpperCase())).longValue()):null);
            setFechaContabilizacion(respuesta.getValueAt(0, "fec_conta".toUpperCase()) != null ? (Date)respuesta.getValueAt(0, "fec_conta".toUpperCase()) : null); // nullable
			setFechaValor(respuesta.getValueAt(0, "fec_valo".toUpperCase()) != null ? new Timestamp(((Date)respuesta.getValueAt(0, "fec_valo".toUpperCase())).getTime()) : null); // nullable
			setImporteDivisa(respuesta.getValueAt(0, "imp_divi".toUpperCase()) != null ? new Double(((BigDecimal)respuesta.getValueAt(0, "imp_divi".toUpperCase())).doubleValue()) : null); // nullable
			setImportePagadoDivisa(respuesta.getValueAt(0, "imp_paga_divi".toUpperCase()) != null ? new Double(((BigDecimal)respuesta.getValueAt(0, "imp_paga_divi".toUpperCase())).doubleValue()) : null); // nullable
            setImportePendiente(new Double(((BigDecimal)respuesta.getValueAt(0, "imp_pend".toUpperCase())).doubleValue()));
            if(respuesta.getValueAt(0, "IND_DTO_CARG_APLI")!=null){
                if(respuesta.getValueAt(0, "IND_DTO_CARG_APLI").toString().equalsIgnoreCase("0")){
                    setIndicaDescuentoRecargo(Boolean.FALSE);
                }else{
                    setIndicaDescuentoRecargo(Boolean.TRUE);
                }
            }
            //setIndicaDescuentoRecargo(respuesta.getValueAt(0, "ind_dto_carg_apli".toUpperCase()) != null ? new Boolean(((String)respuesta.getValueAt(0, "ind_dto_carg_apli".toUpperCase())).equals("1") ? true : false) : null); // nullable
			setNumeroLoteContabilizacion(respuesta.getValueAt(0, "val_nume_lote_cont".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_nume_lote_cont".toUpperCase()) : null); // nullable
			//setNumeroSerieCuota((String)respuesta.getValueAt(0, "val_nume_seri_cuot".toUpperCase()));
			setObservaciones(respuesta.getValueAt(0, "val_obse".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_obse".toUpperCase()) : null); // nullable
            setReferenciaNumeroDocumentoExterno(respuesta.getValueAt(0, "val_refe_nume_docu_exte".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_refe_nume_docu_exte".toUpperCase()) : null); // nullable
            setUltimoDocumentoAnyo(respuesta.getValueAt(0, "val_ulti_docu_anio".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_ulti_docu_anio".toUpperCase()) : null); // nullable
            setUltimoDocumentoMesSerie(respuesta.getValueAt(0, "val_ulti_docu_mes_seri".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "val_ulti_docu_mes_seri".toUpperCase()) : null); // nullable
            setUltimoDocumentoNumero(respuesta.getValueAt(0, "val_ulti_docu_nume".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "val_ulti_docu_nume".toUpperCase())).intValue()) : null); // nullable
            setUltimoNumeroHistoria(respuesta.getValueAt(0, "val_ulti_nume_hist".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "val_ulti_nume_hist".toUpperCase())).intValue()) : null); // nullable
            setMedioPago(respuesta.getValueAt(0, "mpab_oid_medi_pago".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "mpab_oid_medi_pago".toUpperCase())).longValue()) : null); // nullable
			//setPais(new Long(((BigDecimal)respuesta.getValueAt(0, "pais_oid_pais".toUpperCase())).longValue()));
			setMarca(respuesta.getValueAt(0, "marc_oid_marc".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "marc_oid_marc".toUpperCase())).longValue()) : null); // nullable
			setTipoCambio((BigDecimal)respuesta.getValueAt(0, "ind_tipo_camb".toUpperCase()));			
            setCodigoUsuario((String)respuesta.getValueAt(0, "cod_usua".toUpperCase()));				
            setSubtipoCliente(new Long(((BigDecimal)respuesta.getValueAt(0, "sbti_oid_subt_clie".toUpperCase())).longValue()));
            setSugerencia(new Long(((BigDecimal)respuesta.getValueAt(0, "zsgv_oid_subg_vent".toUpperCase())).longValue()));
            setSeccion(new Long(((BigDecimal)respuesta.getValueAt(0, "zscc_oid_secc".toUpperCase())).longValue()));
			setNumeroLoteFacturacion(respuesta.getValueAt(0, "num_lote_fact".toUpperCase()) != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "num_lote_fact".toUpperCase())).intValue()) : null); // nullable
            //setDcAplicado(respuesta.getValueAt(0, "ind_dto_carg_apli".toUpperCase()) != null ? (String)respuesta.getValueAt(0, "ind_dto_carg_apli".toUpperCase()) : null); // nullable
			setImportePago(respuesta.getValueAt(0, "imp_pago".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "imp_pago".toUpperCase()) : null); // nullable			
            setImportePagoDivisa(respuesta.getValueAt(0, "imp_pago_divi".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "imp_pago_divi".toUpperCase()) : null); // nullable			
            setImporteMovimientoDivisa(respuesta.getValueAt(0, "imp_movi_divi".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "imp_movi_divi".toUpperCase()) : null); // nullable			
            setTipoPeriodo(respuesta.getValueAt(0, "tipe_oid_tipo_peri".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "tipe_oid_tipo_peri".toUpperCase())).longValue()) : null); // nullable			
			setTipoDocumentoLegal(respuesta.getValueAt(0, "tido_oid_tipo_docu".toUpperCase())!= null ? new Long(((BigDecimal)respuesta.getValueAt(0, "tido_oid_tipo_docu".toUpperCase())).longValue()):null);			
            setTipoSolicitud(respuesta.getValueAt(0, "tspa_oid_tipo_soli_pais".toUpperCase())!=null ? new Long(((BigDecimal)respuesta.getValueAt(0, "tspa_oid_tipo_soli_pais".toUpperCase())).longValue()):null);
			setRegion(new Long(((BigDecimal)respuesta.getValueAt(0, "zorg_oid_regi".toUpperCase())).longValue()));			
			setConsolidado(respuesta.getValueAt(0, "soca_oid_soli_cabe".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "soca_oid_soli_cabe".toUpperCase())).longValue()) : null); // nullable						
			setImporteMovimiento((BigDecimal)respuesta.getValueAt(0, "imp_movi_cuen".toUpperCase()));		
		}
	}

	public void ejbRemove() {
        Vector param = new Vector();		
        String consulta = "DELETE FROM CCC_MOVIM_CUENT_CORRI WHERE OID_MOVI_CC = ?";
        param.add((Long)context.getPrimaryKey());

        BelcorpService bs;
        
        try {
			ejecutaSentencia(consulta, param);
        } catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-02292") != -1){
				UtilidadesLog.debug("Error BMP movimientos Cuentas Corrientes al eliminar:	El registro no se puede eliminar está referenciado desde otra entidad");
				throw new EJBException(new SQLException(ejbe.getCausedByException().getMessage()));
			}
		}catch(Exception exception){	
			throw new EJBException(exception);
        }
	}

	public void ejbStore() {

		Vector params = new Vector();
		StringBuffer consulta = new StringBuffer("");

		consulta.append("UPDATE CCC_MOVIM_CUENT_CORRI SET ");

		consulta.append("soci_oid_soci = ?, ");
		params.add(this.getEmpresa());

		consulta.append("masi_oid_marc_situ = ?, ");
		params.add(this.getMarcaSituacion());

        if (this.getDivisa() != null) {
            consulta.append("mone_oid_mone = ?, ");
            params.add(this.getDivisa());
        } else {
            consulta.append("mone_oid_mone = null, ");
        }

		consulta.append("perd_oid_peri = ?, ");
		params.add(this.getPeriodoDesde());

		consulta.append("tcab_oid_tcab_ulti = ?, ");
		params.add(this.getTipoAbonoUltimo());

		consulta.append("tcab_oid_tcab_crea = ?, ");
		params.add(this.getTipoAbonoCreacion());

		consulta.append("sbac_oid_sbac = ?, ");
		params.add(this.getSubacceso());
        if(this.getSubprocesoUltimo()!=null){
            consulta.append("subp_oid_subp_ulti = ?, ");
            params.add(this.getSubprocesoUltimo());
        }
		consulta.append("subp_oid_subp_crea = ?, ");
		params.add(this.getSubprocesoDeCreacion());

		consulta.append("cuco_oid_cuen_cont_orig = ?, ");
		params.add(this.getCuentaOrigen());
		
		if(this.getCuentaCuota()!=null){
		consulta.append("cuco_oid_cuen_cont_cuot = ?, ");
		params.add(this.getCuentaCuota());			
		}else{
		consulta.append("cuco_oid_cuen_cont_cuot = null, ");	
		}


		consulta.append("clie_oid_clie = ?, ");
		params.add(this.getCliente());

		consulta.append("val_docu_anio = ?, ");
		params.add(this.getDocumentoAnyo());

		if(this.getDocumentoMesSerie()!=null){
			consulta.append("val_docu_mes_seri = ?, ");
			params.add(this.getDocumentoMesSerie());
		}else{
			consulta.append("val_docu_mes_seri = null, ");
		}

		consulta.append("val_docu_nume = ?, ");
		params.add(this.getDocumentoNumero());

		consulta.append("val_ejer_cuot = ?, ");
		params.add(this.getEjercicioCuota());

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        if (this.getFechaContabilizacion() != null) {
            String sFechaConta = sdf1.format(this.getFechaContabilizacion());                                                           
            consulta.append("fec_conta = TO_DATE( ? ,'YYYY-MM-DD'), ");
            params.add(sFechaConta);
        } else {
            consulta.append("fec_conta = null, ");
        }
            
        String sFechaDocu = sdf1.format(this.getFechaDocumento());                                                           
        consulta.append("fec_docu = TO_DATE( ? ,'YYYY-MM-DD'), ");
        params.add(sFechaDocu);
		
		  SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        String sFechaUltimoMovi = sdf3.format(this.getFechaUltimoMovimiento());                                                           
        consulta.append("fec_ulti_movi = TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS'), ");
        params.add(sFechaUltimoMovi);

        if (this.getFechaValor() != null) {
            String sFechaValor = sdf1.format(this.getFechaValor());                                                           
            consulta.append("fec_valo = TO_DATE( ? ,'YYYY-MM-DD'), ");
            params.add(sFechaValor);
        } else {
            consulta.append("fec_valo = null, ");
        }
        
        String sFechaVenci = sdf1.format(this.getFechaVencimiento());                                                           
        consulta.append("fec_venc = TO_DATE( ? ,'YYYY-MM-DD'), ");
        params.add(sFechaVenci);

   		consulta.append("imp_movi = ?, ");
		params.add(this.getImporte());

        if (this.getImporteDivisa() != null) {
            consulta.append("imp_divi = ?, ");
            params.add(this.getImporteDivisa());
        } else {
            consulta.append("imp_divi = null, ");
        }
		
   		consulta.append("imp_paga = ?, ");
		params.add(this.getImportePagado());

        if (this.getImportePagadoDivisa() != null) {
            consulta.append("imp_paga_divi = ?, ");
            params.add(this.getImportePagadoDivisa());
        } else {
            consulta.append("imp_paga_divi = null, ");
        }
			 	
   		consulta.append("imp_pend = ?, ");
		params.add(this.getImportePendiente());

        if (this.getIndicaDescuentoRecargo() != null) {
            consulta.append("ind_dto_carg_apli = ?, ");
            if(this.getIndicaDescuentoRecargo().booleanValue()){
                params.add(new Integer("1"));    
            }else{
                params.add(new Integer("0"));
            }
        } else {
            consulta.append("ind_dto_carg_apli = null, ");
        }

   		consulta.append("num_iden_cuot = ?, ");
		params.add(this.getNumeroIdentificadorCuota());

        if (this.getNumeroLoteContabilizacion() != null) {
            consulta.append("val_nume_lote_cont = ?, ");
            params.add(this.getNumeroLoteContabilizacion());
        } else {
            consulta.append("val_nume_lote_cont = null, ");
        }

   		consulta.append("num_orde_cuot = ?, " );
		params.add(this.getNumeroOrdenCuota());
		
   		/*consulta.append("val_nume_seri_cuot = ?, ");
		params.add(this.getNumeroSerieCuota());*/

        if (this.getObservaciones() != null) {
            consulta.append("val_obse = ?, ");
            params.add(this.getObservaciones());
        } else {
            consulta.append("val_obse = null, ");
        }

        if (this.getReferenciaNumeroDocumentoExterno() != null) {
            consulta.append("val_refe_nume_docu_exte = ?, ");
            params.add(this.getReferenciaNumeroDocumentoExterno());
        } else {
            consulta.append("val_refe_nume_docu_exte = null, ");
        }

        if (this.getUltimoDocumentoAnyo() != null) {
            consulta.append("val_ulti_docu_anio = ?, ");
            params.add(this.getUltimoDocumentoAnyo());
        } else {
            consulta.append("val_ulti_docu_anio = null, ");
        }

        if (this.getUltimoDocumentoMesSerie() != null) {
            consulta.append("val_ulti_docu_mes_seri = ?, ");
            params.add(this.getUltimoDocumentoMesSerie());
        } else {
            consulta.append("val_ulti_docu_mes_seri = null, ");
        }

        if (this.getUltimoDocumentoNumero() != null) {
            consulta.append("val_ulti_docu_nume = ?, ");
            params.add(this.getUltimoDocumentoNumero());
        } else {
            consulta.append("val_ulti_docu_nume = null, ");
        }

        if (this.getUltimoNumeroHistoria() != null) {
            consulta.append("val_ulti_nume_hist = ?, ");
            params.add(this.getUltimoNumeroHistoria());
        } else {
            consulta.append("val_ulti_nume_hist = null, ");
        }

        if (this.getMedioPago() != null) {
            consulta.append("mpab_oid_medi_pago = ?, ");
            params.add(this.getMedioPago());
        } else {
            consulta.append("mpab_oid_medi_pago = null, ");
        }

   		consulta.append("ztad_oid_terr_admi = ?, ");
		params.add(this.getTerritorioAdministrativo());

   		/*consulta.append("pais_oid_pais = ?, ");
		params.add(this.getPais());*/

        consulta.append("ticl_oid_tipo_clie = ?, ");
        params.add(this.getTipoCliente());

        if (this.getMarca() != null) {
            consulta.append("marc_oid_marc = ?, ");
            params.add(this.getMarca());
        } else {
            consulta.append("marc_oid_marc = null, ");
        }

        consulta.append("ind_tipo_camb = ?, ");
        params.add(this.getTipoCambio());
        consulta.append("cod_usua = ?, ");
        params.add(this.getCodigoUsuario());
        consulta.append("sbti_oid_subt_clie = ?, ");
        params.add(this.getSubtipoCliente());
        consulta.append("zsgv_oid_subg_vent = ?, ");
        params.add(this.getSugerencia());
        consulta.append("zscc_oid_secc = ?, ");
        params.add(this.getSeccion());

        if (this.getNumeroLoteFacturacion() != null) {
            consulta.append("num_lote_fact = ?, ");
            params.add(this.getNumeroLoteFacturacion());
        } else {
            consulta.append("num_lote_fact = null, ");
        }
        /*if (this.getDcAplicado() != null) {
            consulta.append("ind_dto_carg_apli = ?, ");
            params.add(this.getDcAplicado());
        } else {
            consulta.append("ind_dto_carg_apli = null, ");
        }*/
        if (this.getImportePago() != null) {
            consulta.append("imp_pago = ?, ");
            params.add(this.getImportePago());
        } else {
            consulta.append("imp_pago = null, ");
        }
        if (this.getImportePagoDivisa() != null) {
            consulta.append("imp_pago_divi = ?, ");
            params.add(this.getImportePagoDivisa());
        } else {
            //consulta.append("imp_pago_divi = null, ");
            consulta.append("imp_pago_divi = 0, ");
        }
        if (this.getImporteMovimientoDivisa() != null) {
            consulta.append("imp_movi_divi = ?, ");
            params.add(this.getImporteMovimientoDivisa());
        } else {
            consulta.append("imp_movi_divi = null, ");
        }
        if (this.getTipoPeriodo() != null) {
            consulta.append("tipe_oid_tipo_peri = ?, ");
            params.add(this.getTipoPeriodo());
        } else {
            consulta.append("tipe_oid_tipo_peri = null, ");
        }

		if (this.getTipoDocumentoLegal() != null) {
			consulta.append("tido_oid_tipo_docu = ?, ");
			params.add(this.getTipoDocumentoLegal());
		} else {
            consulta.append("tido_oid_tipo_docu = null, ");
        }

		if (this.getTipoSolicitud() != null) {
			consulta.append("tspa_oid_tipo_soli_pais = ?, ");
			params.add(this.getTipoSolicitud());
		} else {
            consulta.append("tspa_oid_tipo_soli_pais = null, ");
        }

        consulta.append("zorg_oid_regi = ?, ");
        params.add(this.getRegion());

        if (this.getConsolidado() != null) {
            consulta.append("soca_oid_soli_cabe = ?, ");
            params.add(this.getConsolidado());
        } else {
            consulta.append("soca_oid_soli_cabe = null, ");
        }

		
         consulta.append("imp_movi_cuen = ? ");
        params.add(this.getImporteMovimiento());
 
		
		consulta.append("WHERE OID_MOVI_CC = ?");

        params.add((Long)context.getPrimaryKey());
        try {   
			this.ejecutaSentencia(consulta.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EJBException(e);
		}
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setEntityContext(EntityContext ctx) {
		this.context = ctx;
	}

	public void unsetEntityContext() {
		this.context = null;
	}

	public Long getCliente() {
		return this.cliente;
	}

	public void setCliente(Long newCliente) {
		this.cliente = newCliente;
	}

	public Long getCuentaCuota() {
		return this.cuentaCuota;
	}

	public void setCuentaCuota(Long newCuentaCuota) {
		this.cuentaCuota = newCuentaCuota;
	}

	public Long getCuentaOrigen() {
		return this.cuentaOrigen;
	}

	public void setCuentaOrigen(Long newCuentaOrigen) {
		this.cuentaOrigen = newCuentaOrigen;
	}

	public Long getDivisa() {
		return this.divisa;
	}

	public void setDivisa(Long newDivisa) {
		this.divisa = newDivisa;
	}

	public String getDocumentoAnyo() {
		return this.documentoAnyo;
	}

	public void setDocumentoAnyo(String newDocumentoAnyo) {
		this.documentoAnyo = newDocumentoAnyo;
	}

	public String getDocumentoMesSerie() {
		return this.documentoMesSerie;
	}

	public void setDocumentoMesSerie(String newDocumentoMesSerie) {
		this.documentoMesSerie = newDocumentoMesSerie;
	}

	public Integer getDocumentoNumero() {
		return this.documentoNumero;
	}

	public void setDocumentoNumero(Integer newDocumentoNumero) {
		this.documentoNumero = newDocumentoNumero;
	}

	public String getEjercicioCuota() {
		return this.ejercicioCuota;
	}

	public void setEjercicioCuota(String newEjercicioCuota) {
		this.ejercicioCuota = newEjercicioCuota;
	}

	public Long getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		this.empresa = newEmpresa;
	}

	public Date getFechaContabilizacion() {
		return this.fechaContabilizacion;
	}

	public void setFechaContabilizacion(Date newFechaContabilizacion) {
		this.fechaContabilizacion = newFechaContabilizacion;
	}

	public Timestamp getFechaDocumento() {
		return this.fechaDocumento;
	}

	public void setFechaDocumento(Timestamp newFechaDocumento) {
		this.fechaDocumento = newFechaDocumento;
	}

	public Timestamp getFechaUltimoMovimiento() {
		return this.fechaUltimoMovimiento;
	}

	public void setFechaUltimoMovimiento(Timestamp newFechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = newFechaUltimoMovimiento;
	}

	public Timestamp getFechaValor() {
		return this.fechaValor;
	}

	public void setFechaValor(Timestamp newFechaValor) {
		this.fechaValor = newFechaValor;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date newFechaVencimiento) {
		this.fechaVencimiento = newFechaVencimiento;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double newImporte) {
		importe = newImporte;
	}

	public Double getImporteDivisa() {
		return this.importeDivisa;
	}

	public void setImporteDivisa(Double newImporteDivisa) {
		importeDivisa = newImporteDivisa;
	}

	public Double getImportePagado() {
		return this.importePagado;
	}

	public void setImportePagado(Double newImportePagado) {
		importePagado = newImportePagado;
	}

	public Double getImportePagadoDivisa() {
		return this.importePagadoDivisa;
	}

	public void setImportePagadoDivisa(Double newImportePagadoDivisa) {
		importePagadoDivisa = newImportePagadoDivisa;
	}

	public Double getImportePendiente() {
		return this.importePendiente;
	}

	public void setImportePendiente(Double newImportePendiente) {
		importePendiente = newImportePendiente;
	}

	public Boolean getIndicaDescuentoRecargo() {
		return this.indicaDescuentoRecargo;
	}

	public void setIndicaDescuentoRecargo(Boolean newIndicaDescuentoRecargo) {
		this.indicaDescuentoRecargo = newIndicaDescuentoRecargo;
	}

	public Long getMarca() {
		return this.marca;
	}

	public void setMarca(Long newMarca) {
		this.marca = newMarca;
	}

	public Long getMarcaSituacion() {
		return this.marcaSituacion;
	}

	public void setMarcaSituacion(Long newMarcaSituacion) {
		this.marcaSituacion = newMarcaSituacion;
	}

	public Long getMedioPago() {
		return this.medioPago;
	}

	public void setMedioPago(Long newMedioPago) {
		this.medioPago = newMedioPago;
	}

	public Integer getNumeroIdentificadorCuota() {
		return this.numeroIdentificadorCuota;
	}

	public void setNumeroIdentificadorCuota(Integer newNumeroIdentificadorCuota) {
		this.numeroIdentificadorCuota = newNumeroIdentificadorCuota;
	}

	public String getNumeroLoteContabilizacion() {
		return this.numeroLoteContabilizacion;
	}

	public void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion) {
		this.numeroLoteContabilizacion = newNumeroLoteContabilizacion;
	}

	public Integer getNumeroOrdenCuota() {
		return this.numeroOrdenCuota;
	}

	public void setNumeroOrdenCuota(Integer newNumeroOrdenCuota) {
		this.numeroOrdenCuota = newNumeroOrdenCuota;
	}

	/*public String getNumeroSerieCuota() {
		return this.numeroSerieCuota;
	}

	public void setNumeroSerieCuota(String newNumeroSerieCuota) {
		this.numeroSerieCuota = newNumeroSerieCuota;
	}*/

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
	}

	public Long getOid() {
		return this.oid;
	}

	/*public Long getPais() {
		return this.pais;
	}

	public void setPais(Long newPais) {
		this.pais = newPais;
	}*/

	public Long getPeriodoDesde() {
		return this.periodoDesde;
	}

	public void setPeriodoDesde(Long newPeriodoDesde) {
		periodoDesde = newPeriodoDesde;
	}

	public String getReferenciaNumeroDocumentoExterno() {
		return this.referenciaNumeroDocumentoExterno;
	}

	public void setReferenciaNumeroDocumentoExterno(String newReferenciaNumeroDocumentoExterno) {
		this.referenciaNumeroDocumentoExterno = newReferenciaNumeroDocumentoExterno;
	}

	public Long getSubacceso() {
		return this.subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		this.subacceso = newSubacceso;
	}

	public Long getTerritorioAdministrativo() {
		return this.territorioAdministrativo;
	}

	public void setTerritorioAdministrativo(Long newTerritorioAdministrativo) {
		this.territorioAdministrativo = newTerritorioAdministrativo;
	}

	public Long getTipoAbonoCreacion() {
		return this.tipoAbonoCreacion;
	}

	public void setTipoAbonoCreacion(Long newTipoAbonoCreacion) {
		this.tipoAbonoCreacion = newTipoAbonoCreacion;
	}

	public Long getTipoAbonoUltimo() {
		return this.tipoAbonoUltimo;
	}

	public void setTipoAbonoUltimo(Long newTipoAbonoUltimo) {
		this.tipoAbonoUltimo = newTipoAbonoUltimo;
	}

	public Long getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(Long newTipoCliente) {
		this.tipoCliente = newTipoCliente;
	}

	public String getUltimoDocumentoAnyo() {
		return this.ultimoDocumentoAnyo;
	}

	public void setUltimoDocumentoAnyo(String newUltimoDocumentoAnyo) {
		this.ultimoDocumentoAnyo = newUltimoDocumentoAnyo;
	}

	public String getUltimoDocumentoMesSerie() {
		return this.ultimoDocumentoMesSerie;
	}

	public void setUltimoDocumentoMesSerie(String newUltimoDocumentoMesSerie) {
		this.ultimoDocumentoMesSerie = newUltimoDocumentoMesSerie;
	}

	public Integer getUltimoDocumentoNumero() {
		return this.ultimoDocumentoNumero;
	}

	public void setUltimoDocumentoNumero(Integer newUltimoDocumentoNumero) {
		this.ultimoDocumentoNumero = newUltimoDocumentoNumero;
	}

	public Integer getUltimoNumeroHistoria() {
		return this.ultimoNumeroHistoria;
	}

	public void setUltimoNumeroHistoria(Integer newUltimoNumeroHistoria) {
		this.ultimoNumeroHistoria = newUltimoNumeroHistoria;
	}

	public void setOid(Long newOid) {
		oid = newOid;
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
			loguearSql("**** BMP MovimientosCuentasCorrientes: ", query, argumentos);		
		    return bs.dbService.executePreparedUpdate(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

	private void loguearSql(String metodo, String sql, Vector params) {

		/*UtilidadesLog.debug(metodo + sql);

		if (params != null && params.size() > 0){
			String sParams = "";
			for (int i=0; i<params.size(); i++) {
				if (params.elementAt(i) != null)
					sParams += "param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";
				else
					sParams += "param "+ (i+1) + ": es nulo, ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}*/		
	}	

	/*private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
			e.printStackTrace();
			UtilidadesLog.debug("No se pudo obtener el objeto Log");
			throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}*/

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
		loguearSql("**** BMP MovimientosCuentasCorrientes:  Resultado : " + res, consulta, params);
        return res;
	}

	public Long getSubprocesoDeCreacion() {
		return subprocesoDeCreacion;
	}

	public void setSubprocesoDeCreacion(Long newSubprocesoDeCreacion) {
		subprocesoDeCreacion = newSubprocesoDeCreacion;
	}

	public Long getSubprocesoUltimo() {
		return subprocesoUltimo;
	}

	public void setSubprocesoUltimo(Long newSubprocesoUltimo) {
		subprocesoUltimo = newSubprocesoUltimo;
	}

	public Long ejbFindByUK(Long subacceso, 
							String ejercicioCuota,
							Integer numeroIdentificadorCuota, 
							Integer numeroOrdenCuota,
                            Long oidPais)
		throws FinderException
	{
        UtilidadesLog.debug("[CS] ATENCION ULTIMO CAMBIO, EL PAIS QUE LE LLEGA ES : " +oidPais);
		Vector parametros = new Vector();
    
		// UK formada por campos: SBAC_OID_SBAC, VAL_EJER_CUOT, NUM_IDEN_CUOT, NUM_ORDE_CUOT
		//String consulta = "SELECT OID_MOVI_CC FROM CCC_MOVIM_CUENT_CORRI " +
		//					"WHERE SBAC_OID_SBAC = ? " +
		//					"AND VAL_EJER_CUOT = ? " +
		//					"AND NUM_IDEN_CUOT = ? " +
		//					"AND NUM_ORDE_CUOT = ?";
//Mofificado por la incidencia BELC300017855 se añade el oid pais a la clave Unica.
//BELC300018543

        String consulta = " SELECT OID_MOVI_CC FROM CCC_MOVIM_CUENT_CORRI c, CRA_PERIO CRA "+         
                            " WHERE CRA.OID_PERI= c.PERD_OID_PERI "+                                    
                                " AND CRA.PAIS_OID_PAIS = ? "+   // --PARAMETRO DE ENTRADA OIDPAIS                
                                " AND SBAC_OID_SBAC = ? "+   // 8 --Parametro de entrada Subacceso                
                                " AND VAL_EJER_CUOT = ? "+   // 1 -- Parametro de entrada ejercicioCuota,         
                                " AND NUM_IDEN_CUOT = ? "+   //1 --Parametro de entrada numeroIdentificadorCuota, 
                                " AND NUM_ORDE_CUOT = ? ";  // 0 --Parametro de entrada numeroOrdenCuota)        

        
        parametros.add(oidPais);
		parametros.add(subacceso);
		parametros.add(ejercicioCuota);		
		parametros.add(numeroIdentificadorCuota);
		parametros.add(numeroOrdenCuota);

		BelcorpService bs;
		RecordSet resultado;

		try {
			resultado = ejecutaConsulta(consulta, parametros);
		} catch (EJBException ex) {
			throw new EJBException();
		}
	if(resultado!=null){
        if (resultado.esVacio()) {
            UtilidadesLog.debug(" [cs] EL FINDBYUK HA DEVUELTO UN RECORSET VACIO LANZARA UNA FINDEReXCEPTION");
            throw new FinderException();
        }
	}
		UtilidadesLog.debug("HEMOS ENCONTRADO DATOS [cs] BMP. antes de devlover oi_mov_cc");
		return new Long(((BigDecimal)resultado.getValueAt(0, "OID_MOVI_CC")).longValue());
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal newTipoCambio) {
		tipoCambio = newTipoCambio;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String newCodigoUsuario) {
		codigoUsuario = newCodigoUsuario;
	}

	public Long getTipoDocumentoLegal() {
		return tipoDocumentoLegal;
	}

	public void setTipoDocumentoLegal(Long newTipoDocumentoLegal) {
		tipoDocumentoLegal = newTipoDocumentoLegal;
	}

	public Long getSubtipoCliente() {
		return subtipoCliente;
	}

	public void setSubtipoCliente(Long newSubtipoCliente) {
		subtipoCliente = newSubtipoCliente;
	}

	public Long getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(Long newSugerencia) {
		sugerencia = newSugerencia;
	}

	public Long getSeccion() {
		return seccion;
	}

	public void setSeccion(Long newSeccion) {
		seccion = newSeccion;
	}

	public BigDecimal getImporteMovimiento() {
		return importeMovimiento;
	}

	public void setImporteMovimiento(BigDecimal newImporteMovimiento) {
		importeMovimiento = newImporteMovimiento;
	}

	public Integer getNumeroLoteFacturacion() {
		return numeroLoteFacturacion;
	}

	public void setNumeroLoteFacturacion(Integer newNumeroLoteFacturacion) {
		numeroLoteFacturacion = newNumeroLoteFacturacion;
	}

	/*public String getDcAplicado() {
		return dcAplicado;
	}

	public void setDcAplicado(String newDcAplicado) {
		dcAplicado = newDcAplicado;
	}*/

	public BigDecimal getImportePago() {
		return importePago;
	}

	public void setImportePago(BigDecimal newImportePago) {
		importePago = newImportePago;
	}

	public BigDecimal getImportePagoDivisa() {
		return importePagoDivisa;
	}

	public void setImportePagoDivisa(BigDecimal newImportePagoDivisa) {
		importePagoDivisa = newImportePagoDivisa;
	}

	public BigDecimal getImporteMovimientoDivisa() {
		return importeMovimientoDivisa;
	}

	public void setImporteMovimientoDivisa(BigDecimal newImporteMovimientoDivisa) {
		importeMovimientoDivisa = newImporteMovimientoDivisa;
	}

	public Long getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(Long newTipoPeriodo) {
		tipoPeriodo = newTipoPeriodo;
	}

	public Long getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(Long newConsolidado) {
		consolidado = newConsolidado;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long newRegion) {
		region = newRegion;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}



}