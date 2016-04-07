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
	 * Componente:	ENTIDADES
	 * Fecha:       20/04/2004
	 * Observaciones:     	Componente construido de acuerdo a la especificación del 
	 *          Modelo de Componentes SICC-DMCO-CCC-201-303 CCC Paquete 
     *          Cuentas Corrientes v3
	 * Descripcion:		Este componente mapea a la tabla CCC_MOVIM_BANCA 
	 * @version		1.0
	 * @autor		dmoro
	 */
	 
package es.indra.sicc.entidades.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;

import java.sql.Date;
//import java.sql.Time; ==>> No es usado
import java.sql.Timestamp;

//import java.text.SimpleDateFormat;  ==>> No es usado

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;

import org.apache.commons.logging.Log;



public class MovimientosBancariosBean implements EntityBean  {
/////////VER INCIDENCIAS 8976 Y 9096 !!!!
	private EntityContext context;

	public String codigoConsultora;
	public Long consultoraReal;
	public String codigoError;
	public Long consecutivoTransaccion;
	public Integer digitoChequeoFactura;
	public String documentoAplicacionAnyo;
	public String documentoAplicacionMesSerie;
	public Integer documentoAplicacionNumero;
	public String documentoCreacionAnyo;
	public String documentoCreacionMesSerie;
	public Integer documentoCreacionNumero;
	public String estatusMovimientoPendienteAplicado;
	public java.sql.Date fechaContabilizacion;
	public Timestamp fechaMovimientoAplicacion;
	public java.sql.Date fechaPago; //modificado, se agrega path
	public java.sql.Date fechaProceso;
	public Timestamp horaProceso;
	public String horarioNormalAdicional; 
	public String identificadorProceso; 
	public BigDecimal importePago;
	public String nombreOficina;
	public String numeroDocumento;
	public Long numeroFacturaBoleta;
	public Long	numeroLote;
	public String numeroLoteContabilizacion;
	public String observaciones;
    //modificado el tipo a String poir inc 21735
    public String oficinaRecaudadora;
	public String usuarioProceso;
	public Long numeroCupon;
	public Long oid;
 
	public Long empresa;
	public Long tipoAbonoCreacion;
	public Long tipoAbonoUltimo;
	public Long tipoTransaccion;
	public Long subprocesoMarcaCreacion;
	public Long subprocesoMarcasUltimo;
	public Long cuentaCorriente;

	public Long numeroLoteExterno; // añadido por hoja control 20/08
	public Long nMovimientoCaja; // añadido por hoja control 20/08
	public BigDecimal saldoPendiente; // añadido por hoja control 20/08
	public BigDecimal importeMovimiento; // eliminado incidencia 9096
	public String codigoUsuario; // añadido por incidencia BELC300007615
	public Integer numeroHistoria; // añadido por incidencia BELC300007615
	public BigDecimal importeAplicado; // añadido por incidencia BELC300007615
	public Long error; // añadido por incidencia BELC300007615
	public Long pais; // añadido por incidencia BELC300007615
	public Long subacceso; // añadido por incidencia BELC300007615
	public Long oidCliente;

	public MovimientosBancariosBean() {
	}
	
	public Long ejbCreate() {
		return null;
	}
	
	/*
   * Autor: Cortaberria
   * Fecha: 03/06/2005
   * El campo getConsultoraReal() no se pasa como atributo debido a que puede ser null, lo que provoca 
   * que no se asignen los parametros que se encuentras despues del mismo.
   */
	public Long ejbCreate(Long empresa, 
							Long subprocesoMarcaCreacion, 
							Long cuentaCorriente, 												
							Long pais,
							Long consultoraReal,
							Long tipoAbonoCreacion,
							Long consecutivoTransaccion,
                            Long numeroLote)

						
		throws DuplicateKeyException, CreateException 
	{

		Vector vector = new Vector();
		
		setEmpresa(empresa);
		setSubprocesoMarcaCreacion(subprocesoMarcaCreacion);
		setCuentaCorriente(cuentaCorriente);
		setPais(pais);
		setConsultoraReal(consultoraReal);
		setTipoAbonoCreacion(tipoAbonoCreacion);
		setConsecutivoTransaccion(consecutivoTransaccion);
        setNumeroLote(numeroLote);		

		try {
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_CMBA_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

		String query  = " INSERT INTO CCC_MOVIM_BANCA ("+
 			"OID_MOVI_BANC, "+
 			"SOCI_OID_SOCI, "+
            "NUM_CONS_TRAN, "+
            "NUM_LOTE, "+
            "SUBP_OID_MARC_CREA, "+
            "CCBA_OID_CC_BANC, "+            
			"PAIS_OID_PAIS, "+
			"CLIE_OID_CLIE, " +
			"TCAB_OID_ABON_CREA )	VALUES (?, ?, ?, ?, ?, ?, ?, ";
       
      query += getConsultoraReal();
      
      query += ", ?)";

		vector.add(this.getOid());
		vector.add(this.getEmpresa());
		vector.add(this.getConsecutivoTransaccion());
        vector.add(this.getNumeroLote());
        vector.add(this.getSubprocesoMarcaCreacion());
		vector.add(this.getCuentaCorriente());
		vector.add(this.getPais());
    
		//vector.add(this.getConsultoraReal());
		vector.add(this.getTipoAbonoCreacion());
    
		try {
			ejecutaUpdate(query.toString(), vector);
		} catch (EJBException ejbe) {
    UtilidadesLog.debug("···································");
    ejbe.printStackTrace();
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

	public Long ejbCreate(
	String codigoConsultora, Long consultoraReal,	String codigoError, Long consecutivoTransaccion, 
	Integer digitoChequeoFactura, String documentoAplicacionAnyo, String documentoAplicacionMesSerie, 
	Integer documentoAplicacionNumero, String documentoCreacionAnyo, String documentoCreacionMesSerie, 
	Integer documentoCreacionNumero, String estatusMovimientoPendienteAplicado, Date fechaContabilizacion, 
	Timestamp fechaMovimientoAplicacion, Date fechaPago, Date fechaProceso, Timestamp horaProceso, String horarioNormalAdicional, String identificadorProceso, BigDecimal importePago, String nombreOficina, String numeroDocumento, Long numeroFacturaBoleta,
	Long numeroLote, String numeroLoteContabilizacion, String observaciones, 
    //modificado el tipo a String poir inc 21735
    String oficinaRecaudadora, 
    String usuarioProceso, Long numeroCupon, Long empresa, Long tipoAbonoCreacion, Long tipoAbonoUltimo, 
	Long tipoTransaccion, Long subprocesoMarcaCreacion, Long subprocesoMarcasUltimo, Long cuentaCorriente, 
	Long numeroLoteExterno, Long nMovimientoCaja, BigDecimal saldoPendiente, 
	String codigoUsuario, Integer numeroHistoria, BigDecimal importeAplicado, Long error, Long pais, Long subacceso, Long oidCliente) 
	
		throws DuplicateKeyException , CreateException
	{

		setCodigoConsultora(codigoConsultora);
		setConsultoraReal(consultoraReal);
		setCodigoError(codigoError);
		setConsecutivoTransaccion(consecutivoTransaccion);
		setDigitoChequeoFactura(digitoChequeoFactura);
		setDocumentoAplicacionAnyo(documentoAplicacionAnyo);
		setDocumentoAplicacionMesSerie(documentoAplicacionMesSerie);
		setDocumentoAplicacionNumero(documentoAplicacionNumero);
		setDocumentoCreacionAnyo(documentoCreacionAnyo);
		setDocumentoCreacionMesSerie(documentoCreacionMesSerie);
		setDocumentoCreacionNumero(documentoCreacionNumero);
		setEstatusMovimientoPendienteAplicado(estatusMovimientoPendienteAplicado);
		setFechaContabilizacion(fechaContabilizacion);
		setFechaMovimientoAplicacion(fechaMovimientoAplicacion);
		setFechaPago(fechaPago);
		setFechaProceso(fechaProceso);
		setHoraProceso(horaProceso);
		setHorarioNormalAdicional(horarioNormalAdicional);
		setIdentificadorProceso(identificadorProceso);
		setImportePago(importePago);
		setNombreOficina(nombreOficina);
		setNumeroDocumento(numeroDocumento);
		setNumeroFacturaBoleta(numeroFacturaBoleta);
		setNumeroLote(numeroLote);
		setNumeroLoteContabilizacion(numeroLoteContabilizacion);
		setObservaciones(observaciones);
		setOficinaRecaudadora(oficinaRecaudadora);
		setUsuarioProceso(usuarioProceso);
		setNumeroCupon(numeroCupon);
		setEmpresa(empresa);
		setTipoAbonoCreacion(tipoAbonoCreacion);
		setTipoAbonoUltimo(tipoAbonoUltimo);
		setTipoTransaccion(tipoTransaccion);
		setSubprocesoMarcaCreacion(subprocesoMarcaCreacion);
		setSubprocesoMarcasUltimo(subprocesoMarcasUltimo);
		setCuentaCorriente(cuentaCorriente);
		setNumeroLoteExterno(numeroLoteExterno);
		setNMovimientoCaja(nMovimientoCaja);
		setSaldoPendiente(saldoPendiente);
		setCodigoUsuario(codigoUsuario);
		setNumeroHistoria(numeroHistoria);
		setImporteAplicado(importeAplicado);
		setError(error);
		setPais(pais);
		setSubacceso(subacceso);
        setOidCliente(oidCliente);
        
		try {
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_CMBA_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

		Vector vector= new Vector();
		
		StringBuffer query  = new StringBuffer(" INSERT INTO CCC_MOVIM_BANCA ("+
 			"OID_MOVI_BANC, "+
 			"SOCI_OID_SOCI, "+
            "SUBP_OID_MARC_CREA, "+
            "CCBA_OID_CC_BANC , " + 
			"TCAB_OID_ABON_CREA ");
            
	

		vector.add(this.getOid());
		vector.add(this.getEmpresa());
		vector.add(this.getSubprocesoMarcaCreacion());
		vector.add(this.getCuentaCorriente());
		vector.add(this.getTipoAbonoCreacion());

		if(this.getConsecutivoTransaccion()!=null){
			query.append(", NUM_CONS_TRAN");
			vector.add(this.getConsecutivoTransaccion());		
		}
		if (this.getNumeroLote()!=null){
			query.append(", NUM_LOTE");
			vector.add(this.getNumeroLote());
		}

		if (this.getCodigoConsultora()!=null){
			query.append(", COD_CONS");
			vector.add(this.getCodigoConsultora());
		}
		

		query.append(", CLIE_OID_CLIE");
		vector.add(this.getConsultoraReal());

		if (this.getCodigoError()!=null){
			query.append(", COD_ERRO");
			vector.add(this.getCodigoError());
		}

		if (this.getDigitoChequeoFactura()!=null){
			query.append(", VAL_DIGI_CHEQ_FACT");
			vector.add(this.getDigitoChequeoFactura());
		}

		if (this.getDocumentoAplicacionAnyo()!=null){
			query.append(", VAL_DOCU_APLI_ANIO");
			vector.add(this.getDocumentoAplicacionAnyo());
		}

		if (this.getDocumentoAplicacionMesSerie()!=null){
			query.append(", VAL_DOCU_APLI_MES_SERI");
			vector.add(this.getDocumentoAplicacionMesSerie());
		}

		if (this.getDocumentoAplicacionNumero()!=null){
			query.append(", VAL_DOCU_APLI_NUME");
			vector.add(this.getDocumentoAplicacionNumero());
		}

		if (this.getDocumentoCreacionAnyo()!=null){
			query.append(", VAL_DOCU_CREA_ANIO");
			vector.add(this.getDocumentoCreacionAnyo());
		}

		if (this.getDocumentoCreacionMesSerie()!=null){
			query.append(", VAL_DOCU_CREA_MES_SERI");
			vector.add(this.getDocumentoCreacionMesSerie());
		}

		if (this.getDocumentoCreacionNumero()!=null){
			query.append(", VAL_DOCU_CREA_NUME");
			vector.add(this.getDocumentoCreacionNumero());
		}					

		if (this.getEstatusMovimientoPendienteAplicado()!=null){
			query.append(", VAL_ESTA_MOVI_PEND");
			vector.add(this.getEstatusMovimientoPendienteAplicado());
		}

		if (this.getFechaContabilizacion()!=null){
			query.append(", FEC_CONT");
			vector.add(this.getFechaContabilizacion());
		}

		if (this.getFechaMovimientoAplicacion()!=null){
			query.append(", FEC_MOVI_APLI");
			vector.add(this.getFechaMovimientoAplicacion());			
		}

		if (this.getFechaPago()!=null){
			query.append(", FEC_PAGO");
			vector.add(this.getFechaPago());			
		}

		if (this.getFechaProceso()!=null){
			query.append(", FEC_PROC");
			vector.add(this.getFechaProceso());			
		}

		if (this.getHoraProceso()!=null){
			query.append(", VAL_HORA_PROC");
			vector.add(this.getHoraProceso());
		}

		if (this.getHorarioNormalAdicional()!=null){
			query.append(", VAL_HORA_NORM_ADIC");
			vector.add(this.getHorarioNormalAdicional());
		}

		if (this.getIdentificadorProceso()!=null){
			query.append(", COD_IDEN_PROC");
			vector.add(this.getIdentificadorProceso());
		}

		if (this.getImportePago()!=null){
			query.append(", IMP_PAGO");
			vector.add(this.getImportePago());
		}

      if (this.getNombreOficina()!=null){
        query.append(", VAL_NOMB_OFIC");
        vector.add(this.getNombreOficina());
      }

		if (this.getNumeroDocumento()!=null){
			query.append(", VAL_NUME_DOCU");
			vector.add(this.getNumeroDocumento());
		}

		if (this.getNumeroFacturaBoleta()!=null){
			query.append(", NUM_FACT_BOLE");
			vector.add(this.getNumeroFacturaBoleta());
		}

		if (this.getNumeroLoteContabilizacion()!=null){
			query.append(", VAL_NUME_LOTE_CONT");
			vector.add(this.getNumeroLoteContabilizacion());
		}

		if (this.getObservaciones()!=null){
			query.append(", VAL_OBSE");
			vector.add(this.getObservaciones());
		}

		if (this.getOficinaRecaudadora()!=null){
			query.append(", COD_OFIC_RECA");
			vector.add(this.getOficinaRecaudadora());
		}

		if (this.getUsuarioProceso()!=null){
			query.append(", VAL_USUA_PROC");
			vector.add(this.getUsuarioProceso());
		}

		if (this.getNumeroCupon()!=null){
			query.append(", NUM_CUPO");
			vector.add(this.getNumeroCupon());
		}


		if (this.getTipoAbonoUltimo()!=null){
			query.append(", TCAB_OID_ABON_ULTI");
			vector.add(this.getTipoAbonoUltimo());
		}

		if (this.getTipoTransaccion()!=null){
			query.append(", TTRA_OID_TIPO_TRANS");
			vector.add(this.getTipoTransaccion());
		}

		if (this.getSubprocesoMarcasUltimo()!=null){
			query.append(", SUBP_OID_MARC_ULTI");
			vector.add(this.getSubprocesoMarcasUltimo());
		}

    //Se descomenta por incidencia dblg 400000602 pzerbino 23/03/2006
		if (this.getImporteMovimiento()!=null){
			query.append(", VAL_IMPO_MOVI");
			vector.add(this.getImporteMovimiento());
		}
		if (this.getNumeroLoteExterno()!=null){
			query.append(", NUM_LOTE_EXTE");
			vector.add(this.getNumeroLoteExterno());
		}
		if (this.getNMovimientoCaja()!=null){
			query.append(", MCAC_OID_CABE");
			vector.add(this.getNMovimientoCaja());
		}
		if (this.getSaldoPendiente()!=null){
			query.append(", IMP_SALD_PEND");
			vector.add(this.getSaldoPendiente());
		}

		query.append(", PAIS_OID_PAIS");
		vector.add(this.getPais());

		if(this.getSubacceso()!=null){
			query.append(", SBAC_OID_SBAC");
			vector.add(this.getSubacceso());
		}
        if (this.getOidCliente()!=null) {
			query.append(", CLIE_OID_CLIE");
			vector.add(this.getOidCliente());
        }
		if (this.getCodigoUsuario()!=null){
			query.append(", COD_USUA");
			vector.add(this.getCodigoUsuario());
		}
		if (this.getNumeroHistoria()!=null){
			query.append(", NUM_HIST");
			vector.add(this.getNumeroHistoria());
		}
		if (this.getImporteAplicado()!=null){
			query.append(", IMP_APLI");
			vector.add(this.getImporteAplicado());
		}
		if (this.getError()!=null){
			query.append(", TIER_OID_ERRO");
			vector.add(this.getError());
		}


		query.append(") VALUES (?");
        for (int i = 1; i < vector.size(); i++){
            query.append(", ?");
        }
        query.append(")");

		 try {
            ejecutaUpdate(query.toString(), vector);
		} catch (EJBException ejbe) {
      ejbe.printStackTrace();
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
	
	public void ejbPostCreate() {
	}

  public Long ejbCreate(Long oidSociedad, 
                        Long oidSubpMarcaCreacion,
                        Long oidAbonoCreacion, 
                        Long oidCuentaCorriente, 
                        Long oidPais) 
  throws MareException ,  DuplicateKeyException, CreateException 
  {
  
  	Vector vector = new Vector();
		
		setEmpresa(oidSociedad);
		setSubprocesoMarcaCreacion(oidSubpMarcaCreacion);
    setCuentaCorriente(oidCuentaCorriente);
		setPais(oidPais);
    setTipoAbonoCreacion(oidAbonoCreacion);
				
		try {
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_CMBA_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

		String query  = " INSERT INTO CCC_MOVIM_BANCA ("+
 			"OID_MOVI_BANC, "+
 			"SOCI_OID_SOCI, "+
            "SUBP_OID_MARC_CREA, "+
            "CCBA_OID_CC_BANC, "+            
			      "PAIS_OID_PAIS, "+
			      "TCAB_OID_ABON_CREA )	VALUES (?, ?, ?, ?, ?, ?)";


		vector.add(this.getOid());
		vector.add(this.getEmpresa());
		vector.add(this.getSubprocesoMarcaCreacion());
		vector.add(this.getCuentaCorriente());
		vector.add(this.getPais());
		vector.add(this.getTipoAbonoCreacion());

		try {
			ejecutaUpdate(query.toString(), vector);
		} catch (EJBException ejbe) {
    UtilidadesLog.debug("···································");
    ejbe.printStackTrace();
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
  
  

  public void ejbPostCreate(Long oidSociedad, Long oidSubpMarcaCreacion, Long oidAbonoCreacion, Long oidCuentaCorriente, Long oidPais)
  {
  }

  
	public void ejbPostCreate(Long empresa, 
							Long subprocesoMarcaCreacion, 
							Long cuentaCorriente, 												
							Long pais,
							Long consultoraReal,
							Long tipoAbonoCreacion,
							Long consecutivoTransaccion,
                            Long numeroLote) {
	}

	public void ejbPostCreate(String codigoConsultora, Long consultoraReal, String codigoError, 
	Long consecutivoTransaccion, Integer digitoChequeoFactura, String documentoAplicacionAnyo, 
	String documentoAplicacionMesSerie, Integer documentoAplicacionNumero, String documentoCreacionAnyo, 
	String documentoCreacionMesSerie, Integer documentoCreacionNumero, String estatusMovimientoPendienteAplicado, 
	Date fechaContabilizacion,	Timestamp fechaMovimientoAplicacion, Date fechaPago, Date fechaProceso, Timestamp horaProceso, 
	String horarioNormalAdicional, String identificadorProceso, BigDecimal importePago, String nombreOficina, 
	String numeroDocumento, Long numeroFacturaBoleta, Long numeroLote, String numeroLoteContabilizacion, 
	String observaciones, 
    //modificado el tipo a String poir inc 21735
    String oficinaRecaudadora, 
    String usuarioProceso, Long numeroCupon, Long empresa, 
	Long tipoAbonoCreacion, Long tipoAbonoUltimo, Long tipoTransaccion, Long subprocesoMarcaCreacion, Long subprocesoMarcasUltimo, 
	Long cuentaCorriente, Long numeroLoteExterno, Long nMovimientoCaja, BigDecimal saldoPendiente, 
	 String codigoUsuario, Integer numeroHistoria, BigDecimal importeAplicado, 
	Long error, Long pais, Long subacceso, Long oidCliente) throws DuplicateKeyException{
						
						}

	public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException {
		try{

			Vector vec = new Vector();
			vec.add(primaryKey);
			
			UtilidadesLog.debug("dentro ejbFindByPrimaryKey " + primaryKey);
			BelcorpService rs = BelcorpService.getInstance();
			String query = " SELECT OID_MOVI_BANC FROM CCC_MOVIM_BANCA WHERE OID_MOVI_BANC = ?" ;
			UtilidadesLog.debug("Ejecuta FindByPrimaryKey");
			RecordSet r = rs.dbService.executePreparedQuery(query, vec);			

			if( r.getRowCount() != 1 ){
				throw new FinderException("Entidad no existente");
			}
			
			return primaryKey;
			
		}catch(Exception ex){
			throw new FinderException("MovimientosBancarios. " + ex.getMessage());
		}
	}

	public void ejbActivate() {
	}

	public void ejbLoad() {

        Vector vector= new Vector();
        String query  = "SELECT * FROM CCC_MOVIM_BANCA WHERE OID_MOVI_BANC = ?";
		vector.add((Long)context.getPrimaryKey());
                   
        RecordSet respuesta;
        try {
            respuesta = ejecutaConsulta(query.toString(), vector);
        } catch (EJBException exception) {
            exception.printStackTrace();
            throw new EJBException();
        }

		if (!respuesta.esVacio()) {
			// Al oid le damos la primary key, esto es obligatorio hacerlo, pues
			// si venimos de un findby, el oid no se cargaría
			this.setOid((Long)context.getPrimaryKey());
			
			this.setEmpresa(new Long(((BigDecimal)respuesta.getValueAt(0, "SOCI_OID_SOCI")).longValue()));
			this.setSubprocesoMarcaCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "SUBP_OID_MARC_CREA")).longValue()));			
			this.setCuentaCorriente(new Long(((BigDecimal)respuesta.getValueAt(0, "CCBA_OID_CC_BANC")).longValue()));
			this.setPais(new Long(((BigDecimal)respuesta.getValueAt(0,"PAIS_OID_PAIS")).longValue()));
      //<inicio>Se modifico para que pueda aceptar movimientos con cliente null (cliente inexistente)
      this.setConsultoraReal(respuesta.getValueAt(0, "CLIE_OID_CLIE") != null ?new Long(((BigDecimal)respuesta.getValueAt(0, "CLIE_OID_CLIE")).longValue()): null);      
      //<fin>
			this.setTipoAbonoCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "TCAB_OID_ABON_CREA")).longValue()));


			this.setTipoTransaccion(respuesta.getValueAt(0, "TTRA_OID_TIPO_TRANS") != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "TTRA_OID_TIPO_TRANS")).longValue()):null);
			this.setConsecutivoTransaccion( respuesta.getValueAt(0, "NUM_CONS_TRAN") != null ?new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_CONS_TRAN")).longValue()): null);
			this.setSubacceso(respuesta.getValueAt(0, "SBAC_OID_SBAC") != null ?new Long(((BigDecimal)respuesta.getValueAt(0, "SBAC_OID_SBAC")).longValue()): null);
			this.setOidCliente(respuesta.getValueAt(0, "CLIE_OID_CLIE") != null ?new Long(((BigDecimal)respuesta.getValueAt(0, "CLIE_OID_CLIE")).longValue()): null);
			this.setNumeroLote(respuesta.getValueAt(0, "NUM_LOTE") != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_LOTE")).longValue()) : null);
			this.setCodigoConsultora(respuesta.getValueAt(0, "COD_CONS") != null?(String)respuesta.getValueAt(0, "COD_CONS"):null);
			this.setCodigoError(respuesta.getValueAt(0, "COD_ERRO") != null?(String)respuesta.getValueAt(0, "COD_ERRO"):null);
			this.setDigitoChequeoFactura(respuesta.getValueAt(0, "VAL_DIGI_CHEQ_FACT") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "VAL_DIGI_CHEQ_FACT")).intValue()):null);	
			this.setDocumentoAplicacionAnyo(respuesta.getValueAt(0, "VAL_DOCU_APLI_ANIO") != null?(String)respuesta.getValueAt(0, "VAL_DOCU_APLI_ANIO"):null);
			this.setDocumentoAplicacionMesSerie(respuesta.getValueAt(0, "VAL_DOCU_APLI_MES_SERI") != null?(String)respuesta.getValueAt(0, "VAL_DOCU_APLI_MES_SERI"):null);
			this.setDocumentoAplicacionNumero(respuesta.getValueAt(0, "VAL_DOCU_APLI_NUME") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "VAL_DOCU_APLI_NUME")).intValue()):null);
			this.setDocumentoCreacionAnyo(respuesta.getValueAt(0, "VAL_DOCU_CREA_ANIO") != null?(String)respuesta.getValueAt(0, "VAL_DOCU_CREA_ANIO"):null);
			this.setDocumentoCreacionMesSerie(respuesta.getValueAt(0, "VAL_DOCU_CREA_MES_SERI") != null?(String)respuesta.getValueAt(0, "VAL_DOCU_CREA_MES_SERI"):null);
			this.setDocumentoCreacionNumero(respuesta.getValueAt(0, "VAL_DOCU_CREA_NUME") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "VAL_DOCU_CREA_NUME")).intValue()):null);
// Un Character
			this.setEstatusMovimientoPendienteAplicado(respuesta.getValueAt(0, "VAL_ESTA_MOVI_PEND") != null?(String)respuesta.getValueAt(0, "VAL_ESTA_MOVI_PEND"):null);
			this.setFechaContabilizacion(respuesta.getValueAt(0, "FEC_CONT") != null?(Date)respuesta.getValueAt(0, "FEC_CONT"):null);
			this.setFechaMovimientoAplicacion(respuesta.getValueAt(0, "FEC_MOVI_APLI") != null?new Timestamp(((Date)respuesta.getValueAt(0, "FEC_MOVI_APLI")).getTime()):null);
			this.setFechaPago(respuesta.getValueAt(0, "FEC_PAGO") != null?(java.sql.Date)respuesta.getValueAt(0, "FEC_PAGO"):null);
			this.setFechaProceso(respuesta.getValueAt(0, "FEC_PROC") != null?(java.sql.Date)respuesta.getValueAt(0, "FEC_PROC"):null);
// Un Time
			this.setHoraProceso(respuesta.getValueAt(0, "VAL_HORA_PROC") != null?new Timestamp(((Date)respuesta.getValueAt(0, "VAL_HORA_PROC")).getTime()):null);
		
			this.setHorarioNormalAdicional(respuesta.getValueAt(0, "VAL_HORA_NORM_ADIC") != null?(String)respuesta.getValueAt(0, "VAL_HORA_NORM_ADIC"):null);
			this.setIdentificadorProceso(respuesta.getValueAt(0, "COD_IDEN_PROC") != null?(String)respuesta.getValueAt(0, "COD_IDEN_PROC"):null);
			this.setImportePago(respuesta.getValueAt(0, "IMP_PAGO") != null?(BigDecimal)respuesta.getValueAt(0, "IMP_PAGO"):null);
			this.setNombreOficina(respuesta.getValueAt(0, "VAL_NOMB_OFIC") != null?(String)respuesta.getValueAt(0, "VAL_NOMB_OFIC"):null);
			this.setNumeroDocumento(respuesta.getValueAt(0, "VAL_NUME_DOCU") != null?(String)respuesta.getValueAt(0, "VAL_NUME_DOCU"):null);
			this.setNumeroFacturaBoleta(respuesta.getValueAt(0, "NUM_FACT_BOLE") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_FACT_BOLE")).longValue()):null);
			this.setNumeroLoteContabilizacion(respuesta.getValueAt(0, "VAL_NUME_LOTE_CONT") != null?(String)respuesta.getValueAt(0, "VAL_NUME_LOTE_CONT"):null);
			this.setObservaciones(respuesta.getValueAt(0, "VAL_OBSE") != null?(String)respuesta.getValueAt(0, "VAL_OBSE"):null);
			//modificado el tipo a String por inc 21735
            //this.setOficinaRecaudadora(respuesta.getValueAt(0, "COD_OFIC_RECA") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "COD_OFIC_RECA")).intValue()):null);
            this.setOficinaRecaudadora(respuesta.getValueAt(0, "COD_OFIC_RECA") != null ? (String)respuesta.getValueAt(0, "COD_OFIC_RECA").toString():null);
			this.setUsuarioProceso(respuesta.getValueAt(0, "VAL_USUA_PROC") != null?(String)respuesta.getValueAt(0, "VAL_USUA_PROC"):null);
			this.setNumeroCupon(respuesta.getValueAt(0, "NUM_CUPO") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_CUPO")).longValue()):null);
			this.setTipoAbonoUltimo(respuesta.getValueAt(0, "TCAB_OID_ABON_ULTI") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "TCAB_OID_ABON_ULTI")).longValue()):null);
			this.setSubprocesoMarcasUltimo(respuesta.getValueAt(0, "SUBP_OID_MARC_ULTI") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "SUBP_OID_MARC_ULTI")).longValue()):null);
			this.setNumeroLoteExterno(respuesta.getValueAt(0, "NUM_LOTE_EXTE".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_LOTE_EXTE".toUpperCase())).longValue()) : null);
			this.setNMovimientoCaja(respuesta.getValueAt(0, "MCAC_OID_CABE".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "MCAC_OID_CABE")).longValue()) : null);
			this.setSaldoPendiente(respuesta.getValueAt(0, "IMP_SALD_PEND".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "IMP_SALD_PEND".toUpperCase()) : null);
			//Se descomenta por incidencia DBLG400000602 pzerbino 23/03/2006
      this.setImporteMovimiento(respuesta.getValueAt(0, "VAL_IMPO_MOVI".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "VAL_IMPO_MOVI".toUpperCase()) : null);
			this.setCodigoUsuario(respuesta.getValueAt(0, "COD_USUA") != null ? (String)respuesta.getValueAt(0, "COD_USUA") : null);
			this.setNumeroHistoria(respuesta.getValueAt(0, "NUM_HIST") != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_HIST")).intValue()) : null);
			this.setImporteAplicado(respuesta.getValueAt(0, "IMP_APLI") != null ? (BigDecimal)respuesta.getValueAt(0, "IMP_APLI") : null);
			this.setError(respuesta.getValueAt(0, "TIER_OID_ERRO") != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "TIER_OID_ERRO")).longValue()) : null);
						

		} else {
            throw new EJBException();
        }
		
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
		Vector vector= new Vector();
        String query  = " DELETE FROM CCC_MOVIM_BANCA WHERE OID_MOVI_BANC = ?";

        vector.add((Long)context.getPrimaryKey());
        try {
            ejecutaUpdate(query.toString(), vector);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new EJBException();
        }		
	}

	public void ejbStore() {

        Vector vector= new Vector();
        StringBuffer query  = new StringBuffer(" UPDATE CCC_MOVIM_BANCA SET ");
            query.append("SOCI_OID_SOCI = ?, ");
            vector.add(this.getEmpresa());
            query.append("SUBP_OID_MARC_CREA = ?, ");
            vector.add(this.getSubprocesoMarcaCreacion());
            query.append("CCBA_OID_CC_BANC = ?, ");
            vector.add(this.getCuentaCorriente());
			query.append("PAIS_OID_PAIS = ? , " );
            vector.add(this.getPais());
			query.append("TCAB_OID_ABON_CREA = ? , ");
            vector.add(this.getTipoAbonoCreacion());
            query.append("NUM_CONS_TRAN = ? , ");
            vector.add(this.getConsecutivoTransaccion());
        	query.append("NUM_LOTE = ?");
            vector.add(this.getNumeroLote());
		
        if(this.getConsultoraReal()!=null){
        	query.append(", CLIE_OID_CLIE = ?  "); 
            vector.add(this.getConsultoraReal());
        }else{
            query.append(", CLIE_OID_CLIE = null");
        }
		if (this.getCodigoConsultora()!=null){
			query.append(", COD_CONS = ?");
			vector.add(this.getCodigoConsultora());
		}else {
			query.append(", COD_CONS = null");
		}

	 
		if (this.getCodigoError()!=null){
			query.append(", COD_ERRO = ?");
			vector.add(this.getCodigoError());
		}else {
			query.append(", COD_ERRO = null");
		}

		if (this.getDigitoChequeoFactura()!=null){
			query.append(", VAL_DIGI_CHEQ_FACT = ?");
			vector.add(this.getDigitoChequeoFactura());
		}else {
			query.append(", VAL_DIGI_CHEQ_FACT = null");
		}

		if (this.getDocumentoAplicacionAnyo()!=null){
			query.append(", VAL_DOCU_APLI_ANIO = ?");
			vector.add(this.getDocumentoAplicacionAnyo());
		}else {
			query.append(", VAL_DOCU_APLI_ANIO = null");
		}

		if (this.getDocumentoAplicacionMesSerie()!=null){
			query.append(", VAL_DOCU_APLI_MES_SERI = ?");
			vector.add(this.getDocumentoAplicacionMesSerie());
		}else {
			query.append(", VAL_DOCU_APLI_MES_SERI = null");
		}

		if (this.getDocumentoAplicacionNumero()!=null){
			query.append(", VAL_DOCU_APLI_NUME = ?");
			vector.add(this.getDocumentoAplicacionNumero());
		}else {
			query.append(", VAL_DOCU_APLI_NUME = null");
		}

		if (this.getDocumentoCreacionAnyo()!=null){
			query.append(", VAL_DOCU_CREA_ANIO = ?");
			vector.add(this.getDocumentoCreacionAnyo());
		}else {
			query.append(", VAL_DOCU_CREA_ANIO = null");
		}

		if (this.getDocumentoCreacionMesSerie()!=null){
			query.append(", VAL_DOCU_CREA_MES_SERI = ?");
			vector.add(this.getDocumentoCreacionMesSerie());
		}else {
			query.append(", VAL_DOCU_CREA_MES_SERI = null");
		}

		if (this.getDocumentoCreacionNumero()!=null){
			query.append(", VAL_DOCU_CREA_NUME = ?");
			vector.add(this.getDocumentoCreacionNumero());
		}else {
			query.append(", VAL_DOCU_CREA_NUME = null");
		}					

		if (this.getEstatusMovimientoPendienteAplicado()!=null){
			query.append(", VAL_ESTA_MOVI_PEND = ?");
			vector.add(this.getEstatusMovimientoPendienteAplicado());
		}else {
			query.append(", VAL_ESTA_MOVI_PEND = null");
		}

		if (this.getFechaContabilizacion()!=null){
			query.append(", FEC_CONT = ?");
			//vector.add(sdf.format(this.getFechaContabilizacion(), new StringBuffer(), new java.text.FieldPosition(0)).toString());
			vector.add(this.getFechaContabilizacion());
		}else {
			query.append(", FEC_CONT = null");
		}

		if (this.getFechaMovimientoAplicacion()!=null){
			query.append(", FEC_MOVI_APLI = ?");
			//vector.add(sdf.format(this.getFechaMovimientoAplicacion(), new StringBuffer(), new java.text.FieldPosition(0)).toString());			
			vector.add(this.getFechaMovimientoAplicacion());
		}else {
			query.append(", FEC_MOVI_APLI = null");
		}

		if (this.getFechaPago()!=null){
			query.append(", FEC_PAGO = ?");
			//vector.add(sdf.format(this.getFechaPago(), new StringBuffer(), new java.text.FieldPosition(0)).toString());			
			vector.add(this.getFechaPago());			
		}else {
			query.append(", FEC_PAGO = null");
		}

		if (this.getFechaProceso()!=null){
			query.append(", FEC_PROC = ?");			
			vector.add(this.getFechaProceso());
		}else {
			query.append(", FEC_PROC = null");
		}

		if (this.getHoraProceso()!=null){
			query.append(", VAL_HORA_PROC = ?");
			vector.add(this.getHoraProceso());
		}else {
			query.append(", VAL_HORA_PROC = null");
		}

		if (this.getHorarioNormalAdicional()!=null){
			query.append(", VAL_HORA_NORM_ADIC = ?");
			vector.add(this.getHorarioNormalAdicional());
		}else {
			query.append(", VAL_HORA_NORM_ADIC = null");
		}

		if (this.getIdentificadorProceso()!=null){
			query.append(", COD_IDEN_PROC = ?");
			vector.add(this.getIdentificadorProceso());
		}else {
			query.append(", COD_IDEN_PROC = null");
		}

		if (this.getImportePago()!=null){
			query.append(", IMP_PAGO = ?");
			vector.add(this.getImportePago());
		}else {
			query.append(", IMP_PAGO = null");
		}

		if (this.getNombreOficina()!=null){
			query.append(", VAL_NOMB_OFIC = ?");
			vector.add(this.getNombreOficina());
		}else {
			query.append(", VAL_NOMB_OFIC = null");
		}

		if (this.getNumeroDocumento()!=null){
			query.append(", VAL_NUME_DOCU = ?");
			vector.add(this.getNumeroDocumento());
		}else {
			query.append(", VAL_NUME_DOCU = null");
		}

		if (this.getNumeroFacturaBoleta()!=null){
			query.append(", NUM_FACT_BOLE = ?");
			vector.add(this.getNumeroFacturaBoleta());
		}else {
			query.append(", NUM_FACT_BOLE = null");
		}

		if (this.getNumeroLoteContabilizacion()!=null){
			query.append(", VAL_NUME_LOTE_CONT = ?");
			vector.add(this.getNumeroLoteContabilizacion());
		}else {
			query.append(", VAL_NUME_LOTE_CONT = null");
		}

		if (this.getObservaciones()!=null){
			query.append(", VAL_OBSE = ?");
			vector.add(this.getObservaciones());
		}else {
			query.append(", VAL_OBSE = null");
		}

		if (this.getOficinaRecaudadora()!=null){
			query.append(", COD_OFIC_RECA = ?");
			vector.add(this.getOficinaRecaudadora());
		}else {
			query.append(", COD_OFIC_RECA = null");
		}

		if (this.getUsuarioProceso()!=null){
			query.append(", VAL_USUA_PROC = ?");
			vector.add(this.getUsuarioProceso());
		}else {
			query.append(", VAL_USUA_PROC = null");
		}

		if (this.getNumeroCupon()!=null){
			query.append(", NUM_CUPO = ?");
			vector.add(this.getNumeroCupon());
		}else {
			query.append(", NUM_CUPO = null");
		}



		if (this.getTipoAbonoUltimo()!=null){
			query.append(", TCAB_OID_ABON_ULTI = ?");
			vector.add(this.getTipoAbonoUltimo());
		}else {
			query.append(", TCAB_OID_ABON_ULTI = null");
		}

		if (this.getTipoTransaccion()!=null){
			query.append(", TTRA_OID_TIPO_TRANS  = ?");
			vector.add(this.getTipoTransaccion());
		}else {
			query.append(", TTRA_OID_TIPO_TRANS  = null");
		}

		if (this.getSubprocesoMarcasUltimo()!=null){
			query.append(", SUBP_OID_MARC_ULTI = ?");
			vector.add(this.getSubprocesoMarcasUltimo());
		}else {
			query.append(", SUBP_OID_MARC_ULTI = null");
		}

    //Se descomenta por incidencia dblg 602 pzerbino 23/03/2006
		if (this.getImporteMovimiento()!=null){
			query.append(", VAL_IMPO_MOVI = ?");
			vector.add(this.getImporteMovimiento());
		}else {
			query.append(", VAL_IMPO_MOVI = null");
		}
    
		if (this.getNumeroLoteExterno()!=null){
			query.append(", NUM_LOTE_EXTE = ?");
			vector.add(this.getNumeroLoteExterno());
		}else {
			query.append(", NUM_LOTE_EXTE = null");
		}
		if (this.getNMovimientoCaja()!=null){
			query.append(", MCAC_OID_CABE = ?");
			vector.add(this.getNMovimientoCaja());
		}else {
			query.append(", MCAC_OID_CABE = null");
		}
		if (this.getSaldoPendiente()!=null){
			query.append(", IMP_SALD_PEND = ?");
			vector.add(this.getSaldoPendiente());
		}else {
			query.append(", IMP_SALD_PEND = null");
		}

		if (this.getCodigoUsuario()!=null){
			query.append(", COD_USUA = ?");
			vector.add(this.getCodigoUsuario());
		}else {
			query.append(", COD_USUA = null");
		}
		if (this.getNumeroHistoria()!=null){
			query.append(", NUM_HIST = ?");
			vector.add(this.getNumeroHistoria());
		}else {
			query.append(", NUM_HIST = null");
		}
		if (this.getImporteAplicado()!=null){
			query.append(", IMP_APLI = ?");
			vector.add(this.getImporteAplicado());
		}else {
			query.append(", IMP_APLI = null");
		}
		if (this.getError()!=null){
			query.append(", TIER_OID_ERRO = ?");
			vector.add(this.getError());
		}else {
			query.append(", TIER_OID_ERRO = null");
		}
		

 		query.append(" WHERE OID_MOVI_BANC = ?"); 
        vector.add((Long)context.getPrimaryKey());
		
         try {   
			ejecutaUpdate(query.toString(), vector);
		 } catch (Exception e){
			 e.printStackTrace();

			 throw new EJBException(e);
		 }
	}
	
	public void setEntityContext(EntityContext ctx) {
		this.context = ctx;
	}

	public void unsetEntityContext() {
		this.context = null;
	}

	public String getCodigoConsultora() {
		return this.codigoConsultora;
	}

	public void setCodigoConsultora(String newCodigoConsultora) {
		this.codigoConsultora = newCodigoConsultora;
	}

	public Long getConsultoraReal() {
		return this.consultoraReal;
	}

	public void setConsultoraReal(Long newConsultoraReal) {
		this.consultoraReal = newConsultoraReal;
	}

	public String getCodigoError() {
		return this.codigoError;
	}

	public void setCodigoError(String newCodigoError) {
		this.codigoError = newCodigoError;
	}

	public Long getConsecutivoTransaccion() {
		return this.consecutivoTransaccion;
	}

	public void setConsecutivoTransaccion(Long newConsecutivoTransaccion) {
		this.consecutivoTransaccion = newConsecutivoTransaccion;
	}

	public EntityContext getContext() {
		return this.context;
	}

	public void setContext(EntityContext newContext) {
		this.context = newContext;
	}

	public Long getCuentaCorriente() {
		return this.cuentaCorriente;
	}

	public void setCuentaCorriente(Long newCuentaCorriente) {
		this.cuentaCorriente = newCuentaCorriente;
	}

	public Integer getDigitoChequeoFactura() {
		return this.digitoChequeoFactura;
	}

	public void setDigitoChequeoFactura(Integer newDigitoChequeoFactura) {
		this.digitoChequeoFactura = newDigitoChequeoFactura;
	}

	public String getDocumentoAplicacionAnyo() {
		return this.documentoAplicacionAnyo;
	}

	public void setDocumentoAplicacionAnyo(String newDocumentoAplicacionAnyo) {
		this.documentoAplicacionAnyo = newDocumentoAplicacionAnyo;
	}

	public String getDocumentoAplicacionMesSerie() {
		return this.documentoAplicacionMesSerie;
	}

	public void setDocumentoAplicacionMesSerie(String newDocumentoAplicacionMesSerie) {
		this.documentoAplicacionMesSerie = newDocumentoAplicacionMesSerie;
	}

	public Integer getDocumentoAplicacionNumero() {
		return this.documentoAplicacionNumero;
	}

	public void setDocumentoAplicacionNumero(Integer newDocumentoAplicacionNumero) {
		this.documentoAplicacionNumero = newDocumentoAplicacionNumero;
	}

	public String getDocumentoCreacionAnyo() {
		return this.documentoCreacionAnyo;
	}

	public void setDocumentoCreacionAnyo(String newDocumentoCreacionAnyo) {
		this.documentoCreacionAnyo = newDocumentoCreacionAnyo;
	}

	public String getDocumentoCreacionMesSerie() {
		return this.documentoCreacionMesSerie;
	}

	public void setDocumentoCreacionMesSerie(String newDocumentoCreacionMesSerie) {
		this.documentoCreacionMesSerie = newDocumentoCreacionMesSerie;
	}

	public Integer getDocumentoCreacionNumero() {
		return this.documentoCreacionNumero;
	}

	public void setDocumentoCreacionNumero(Integer newDocumentoCreacionNumero) {
		this.documentoCreacionNumero = newDocumentoCreacionNumero;
	}

	public Long getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		this.empresa = newEmpresa;
	}

	public String getEstatusMovimientoPendienteAplicado() {
		return this.estatusMovimientoPendienteAplicado;
	}

	public void setEstatusMovimientoPendienteAplicado(String newEstatusMovimientoPendienteAplicado) {
		this.estatusMovimientoPendienteAplicado = newEstatusMovimientoPendienteAplicado;
	}

	public java.sql.Date getFechaContabilizacion() {
		return this.fechaContabilizacion;
	}

	public void setFechaContabilizacion(java.sql.Date newFechaContabilizacion) {
		this.fechaContabilizacion = newFechaContabilizacion;
	}

	public Timestamp getFechaMovimientoAplicacion() {
		return this.fechaMovimientoAplicacion;
	}

	public void setFechaMovimientoAplicacion(Timestamp newFechaMovimientoAplicacion) {
		fechaMovimientoAplicacion = newFechaMovimientoAplicacion;
	}

	public java.sql.Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(java.sql.Date newFechaPago) {
		fechaPago = newFechaPago;
	}

	public java.sql.Date getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(java.sql.Date newFechaProceso) {
		fechaProceso = newFechaProceso;
	}

	public Timestamp getHoraProceso() {
		return this.horaProceso;
	}

	public void setHoraProceso(Timestamp newHoraProceso) {
		horaProceso = newHoraProceso;
	}

	public String getHorarioNormalAdicional() {
		return this.horarioNormalAdicional;
	}

	public void setHorarioNormalAdicional(String newHorarioNormalAdicional) {
		this.horarioNormalAdicional = newHorarioNormalAdicional;
	}

	public String getIdentificadorProceso() {
		return this.identificadorProceso;
	}

	public void setIdentificadorProceso(String newIdentificadorProceso) {
		this.identificadorProceso = newIdentificadorProceso;
	}

	public BigDecimal getImportePago() {
		return this.importePago;
	}

	public void setImportePago(BigDecimal newImportePago) {
		this.importePago = newImportePago;
	}



	public String getNombreOficina() {
		return this.nombreOficina;
	}

	public void setNombreOficina(String newNombreOficina) {
		this.nombreOficina = newNombreOficina;
	}

	public Long getNumeroCupon() {
		return this.numeroCupon;
	}

	public void setNumeroCupon(Long newNumeroCupon) {
		this.numeroCupon = newNumeroCupon;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String newNumeroDocumento) {
		this.numeroDocumento = newNumeroDocumento;
	}

	public Long getNumeroFacturaBoleta() {
		return this.numeroFacturaBoleta;
	}

	public void setNumeroFacturaBoleta(Long newNumeroFacturaBoleta) {
		this.numeroFacturaBoleta = newNumeroFacturaBoleta;
	}

	public Long getNumeroLote() {
		return this.numeroLote;
	}

	public void setNumeroLote(Long newNumeroLote) {
		this.numeroLote = newNumeroLote;
	}

	public String getNumeroLoteContabilizacion() {
		return this.numeroLoteContabilizacion;
	}

	public void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion) {
		this.numeroLoteContabilizacion = newNumeroLoteContabilizacion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
	}

	public String getOficinaRecaudadora() {
		return this.oficinaRecaudadora;
	}

    //modificado el tipo a String poir inc 21735
	public void setOficinaRecaudadora(String newOficinaRecaudadora) {
        this.oficinaRecaudadora = newOficinaRecaudadora;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long newOid) {
		this.oid = newOid;
	}

	public Long getSubprocesoMarcaCreacion() {
		return this.subprocesoMarcaCreacion;
	}

	public void setSubprocesoMarcaCreacion(Long newSubprocesoMarcaCreacion) {
		this.subprocesoMarcaCreacion = newSubprocesoMarcaCreacion;
	}

	public Long getSubprocesoMarcasUltimo() {
		return this.subprocesoMarcasUltimo;
	}

	public void setSubprocesoMarcasUltimo(Long newSubprocesoMarcasUltimo) {
		this.subprocesoMarcasUltimo = newSubprocesoMarcasUltimo;
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

	public Long getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(Long newTipoTransaccion) {
		this.tipoTransaccion = newTipoTransaccion;
	}

	public String getUsuarioProceso() {
		return this.usuarioProceso;
	}

	public void setUsuarioProceso(String newUsuarioProceso) {
		this.usuarioProceso = newUsuarioProceso;
	}

	/** Metodo privado para realizar consultas a BBDD con DBService
     * @param query sentencia SQL con la consulta
     * @param argumentos valores de los parametros de la consulta
     * @return RecordSet con la respuesta a la consulta realizada */

    private int ejecutaUpdate(String query, Vector argumentos) throws EJBException {
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }
        try {
		    return bs.dbService.executePreparedUpdate(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

	/** Metodo privado para realizar consultas a BBDD con DBService
     * @param query sentencia SQL con la consulta
     * @param argumentos valores de los parametros de la consulta
     * @return RecordSet con la respuesta a la consulta realizada */

    private RecordSet ejecutaConsulta(String query, Vector argumentos)
        throws EJBException {
		
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }

        RecordSet res;

        try {
            res = bs.dbService.executePreparedQuery(query, argumentos);
        } catch (Exception e) {
			e.printStackTrace();
            throw new EJBException(e);
        }
		loguearSql("**** BMP MovimientosBancarios: ", query, argumentos);
        return res;
    }

	private void loguearSql(String metodo, String sql, Vector params) {

		UtilidadesLog.debug(metodo + sql);

		if (params != null && params.size() > 0) {
			String sParams = "";
			for (int i=0; i<params.size(); i++) {
				if (params.elementAt(i) != null)
					sParams += "param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";
				else
					sParams += "param "+ (i+1) + ": es nulo, ";
			}
			UtilidadesLog.debug(metodo + sParams);
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


	public Long getNumeroLoteExterno() {
		return numeroLoteExterno;
	}

	public void setNumeroLoteExterno(Long newNumeroLoteExterno) {
		numeroLoteExterno = newNumeroLoteExterno;
	}

	public Long getNMovimientoCaja() {
		return nMovimientoCaja;
	}

	public void setNMovimientoCaja(Long newNMovimientoCaja) {
		nMovimientoCaja = newNMovimientoCaja;
	}

	public BigDecimal getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(BigDecimal newSaldoPendiente) {
		saldoPendiente = newSaldoPendiente;
	}

	public BigDecimal getImporteMovimiento() {
		return importeMovimiento;
	}

	public void setImporteMovimiento(BigDecimal newImporteMovimiento) {
		importeMovimiento = newImporteMovimiento;
	}

	public Long ejbFindByUK(Long pais, Long numeroLote, Long consecutivoTransaccion) throws FinderException	{
		Vector parametros = new Vector();
		// UK formada por campos: PAIS_OID_PAIS, NUM_LOTE, NUM_CONS_TRAN
		String consulta = " SELECT OID_MOVI_BANC FROM CCC_MOVIM_BANCA " +
							" WHERE PAIS_OID_PAIS = " + pais +
							" AND NUM_LOTE = " + numeroLote +
							" AND NUM_CONS_TRAN = " + consecutivoTransaccion ;

		BelcorpService bs;
		RecordSet resultado;

        try {
            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(consulta);
        } catch (Exception e) {
            throw new FinderException();
        }
        if (resultado.esVacio()) {
            throw new FinderException();
        }
		return new Long(((BigDecimal)resultado.getValueAt(0, "OID_MOVI_BANC")).longValue());
	}


	// ver incidencia BELC300007639
	public Collection ejbFindByParametros(Long cuentaCorriente, java.sql.Date fechaPago, BigDecimal importePago, Long consultoraReal) 
		throws FinderException 
	{	
		// se devuelve una coleccion de las claves primarias al contenedor, el cual 
		// crea a partir de esta coleccion una coleccion de objetos EJB 
		// (interfaces remotas), que devuelve al cliente
		
		Vector resultado = new Vector();

		Vector parametros = new Vector();

        RecordSet respuesta;

		// se busca por campos: CCBA_OID_CC_BANC, FEC_PAGO, IMP_PAGO, CLIE_OID_CLIE
		String consulta = "SELECT OID_MOVI_BANC FROM CCC_MOVIM_BANCA " +
							"WHERE CCBA_OID_CC_BANC = ? " +
							"AND FEC_PAGO = TO_DATE( ? ,'dd/MM/yyyy') " +
							"AND IMP_PAGO = ? " +
							"AND CLIE_OID_CLIE = ?";

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha =  sdf.format(fechaPago);
	
		parametros.add(cuentaCorriente);
		parametros.add(strFecha);		
		parametros.add(importePago);
		parametros.add(consultoraReal);

        try {
            respuesta = ejecutaConsulta(consulta.toString(), parametros);
        } catch (EJBException exception) {
                throw new EJBException();
        }

        if (respuesta == null && respuesta.esVacio()) {
            throw new FinderException();
        }

		Iterator iter = respuesta.getRecords().iterator();
		
		Long clavePrimaria = null;
		Vector tempEncontrado = null;

		while (iter.hasNext()) {
			tempEncontrado = (Vector)iter.next();
//			clavePrimaria = (Long)tempEncontrado.get(0);
			clavePrimaria = new Long( ( (BigDecimal)tempEncontrado.get(0) ).longValue() );
			resultado.add(clavePrimaria);
		}
		
		return resultado;
	}

    public Collection ejbFindAll() throws  FinderException {
        try {
            BelcorpService instance = BelcorpService.getInstance();
            String query = "SELECT * FROM CCC_MOVIM_BANCA WHERE 1=1 ";
            Vector vec = new Vector();
            RecordSet rs = instance.dbService.executePreparedQuery(query, vec);
			ArrayList respuesta = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {       
                this.oid = new Long(((BigDecimal)rs.getValueAt(i, "OID_MOVI_BANC")).longValue());
                respuesta.add(this.oid);
            }

            return respuesta;
        } catch (Exception ex) {
            throw new FinderException("MovimientoBancario. " + ex.getMessage());
        }    
    }
	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String newCodigoUsuario) {
		codigoUsuario = newCodigoUsuario;
	}

	public Integer getNumeroHistoria() {
		return numeroHistoria;
	}

	public void setNumeroHistoria(Integer newNumeroHistoria) {
		numeroHistoria = newNumeroHistoria;
	}

	public BigDecimal getImporteAplicado() {
		return importeAplicado;
	}

	public void setImporteAplicado(BigDecimal newImporteAplicado) {
		importeAplicado = newImporteAplicado;
	}

	public Long getError() {
		return error;
	}

	public void setError(Long newError) {
		error = newError;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}
  
  public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}


}