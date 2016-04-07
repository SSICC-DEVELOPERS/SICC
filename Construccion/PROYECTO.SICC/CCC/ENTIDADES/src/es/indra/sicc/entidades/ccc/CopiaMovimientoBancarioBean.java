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

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.SecuenciadorOID;

import es.indra.sicc.util.UtilidadesLog;
import org.apache.commons.logging.Log;

import java.math.BigDecimal;

import java.sql.Date;

//import java.sql.Time; ==>> No es usado
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;

//import java.text.SimpleDateFormat;  ==>> No es usado
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;


public class CopiaMovimientoBancarioBean implements EntityBean {
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

	public Long numeroLoteExterno; 
	public Long nMovimientoCaja; 
	public BigDecimal saldoPendiente;

	public String codigoUsuario;
	public Integer numeroHistoria;
	public BigDecimal importeAplicado; 
	public Long error; 
	public Long pais; 
	public Long subacceso;


    public Long ejbCreate() {
        return null;
    }

    public void ejbPostCreate() {
    }

    public Long ejbCreate(Long empresa, Long subprocesoMarcaCreacion, Long cuentaCorriente, Long pais, Long consultoraReal, Long tipoAbonoCreacion)
    	throws DuplicateKeyException, CreateException
	{

		Vector vector = new Vector();
		
		setEmpresa(empresa);
		setSubprocesoMarcaCreacion(subprocesoMarcaCreacion);
		setCuentaCorriente(cuentaCorriente);
		setPais(pais);
		setConsultoraReal(consultoraReal);
		setTipoAbonoCreacion(tipoAbonoCreacion);
		

		try {
			setOid(SecuenciadorOID.obtenerSiguienteValor("CCC_CMOB_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

		String query  = " INSERT INTO CCC_COPIA_MOVIM_BANCA ("+
 			"OID_MOVI_BANC, "+
 			"SOCI_OID_SOCI, "+
            "SUBP_OID_SUBP, "+
            "CCBA_OID_CC_BANC, "+            
			"PAIS_OID_PAIS, "+
			"CLIE_OID_CLIE, " +
			"TCAB_OID_ABON_CREA )	VALUES (?, ?, ?, ?, ?, ?, ?)";


		vector.add(this.getOid());
		vector.add(this.getEmpresa());
		vector.add(this.getSubprocesoMarcaCreacion());
		vector.add(this.getCuentaCorriente());
		vector.add(this.getPais());
		vector.add(this.getConsultoraReal());
		vector.add(this.getTipoAbonoCreacion());

		try {
			ejecutaUpdate(query.toString(), vector);
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

    public void ejbPostCreate(Long empresa, Long subprocesoMarcaCreacion, Long cuentaCorriente, Long pais, Long consultoraReal, Long tipoAbonoCreacion)
        throws DuplicateKeyException {
    }

    public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException {
    	try{

			Vector vec = new Vector();
			vec.add(primaryKey);
			
			UtilidadesLog.debug("dentro ejbFindByPrimaryKey " + primaryKey);
			BelcorpService rs = BelcorpService.getInstance();
			String query = " SELECT OID_MOVI_BANC FROM CCC_COPIA_MOVIM_BANCA WHERE OID_MOVI_BANC = ?" ;
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
        String query  = "SELECT * FROM CCC_COPIA_MOVIM_BANCA WHERE OID_MOVI_BANC = ?";
		vector.add((Long)context.getPrimaryKey());
                   
        RecordSet respuesta;
        try {
            respuesta = ejecutaConsulta(query.toString(), vector);
        } catch (EJBException exception) {
                throw new EJBException();
        }

		if (!respuesta.esVacio()) {
			// Al oid le damos la primary key, esto es obligatorio hacerlo, pues
			// si venimos de un findby, el oid no se cargaría
			this.setOid((Long)context.getPrimaryKey());
			
			this.setEmpresa(new Long(((BigDecimal)respuesta.getValueAt(0, "SOCI_OID_SOCI")).longValue()));
			this.setSubprocesoMarcaCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "SUBP_OID_SUBP")).longValue()));			
			this.setCuentaCorriente(new Long(((BigDecimal)respuesta.getValueAt(0, "CCBA_OID_CC_BANC")).longValue()));
			this.setPais(new Long(((BigDecimal)respuesta.getValueAt(0,"PAIS_OID_PAIS")).longValue()));
			this.setConsultoraReal(new Long(((BigDecimal)respuesta.getValueAt(0, "CLIE_OID_CLIE")).longValue()));
			this.setTipoAbonoCreacion(new Long(((BigDecimal)respuesta.getValueAt(0, "TCAB_OID_ABON_CREA")).longValue()));


			this.setTipoTransaccion(respuesta.getValueAt(0, "TTRA_OID_TIPO_TRANS") != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "TTRA_OID_TIPO_TRANS")).longValue()):null);
			this.setConsecutivoTransaccion( respuesta.getValueAt(0, "NUM_CONS_TRAN") != null ?new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_CONS_TRAN")).longValue()): null);
			this.setSubacceso(respuesta.getValueAt(0, "SBAC_OID_SBAC") != null ?new Long(((BigDecimal)respuesta.getValueAt(0, "SBAC_OID_SBAC")).longValue()): null);
			this.setNumeroLote(respuesta.getValueAt(0, "NUM_LOTE") != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_LOTE")).longValue()) : null);
			this.setCodigoConsultora(respuesta.getValueAt(0, "COD_CONS") != null?(String)respuesta.getValueAt(0, "COD_CONS"):null);
			this.setCodigoError(respuesta.getValueAt(0, "COD_ERRO") != null?(String)respuesta.getValueAt(0, "COD_ERRO"):null);
			this.setDigitoChequeoFactura(respuesta.getValueAt(0, "NUM_DIGI_CHEQ_FACT") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_DIGI_CHEQ_FACT")).intValue()):null);	
			this.setDocumentoAplicacionAnyo(respuesta.getValueAt(0, "VAL_DOCU_APLI_ANIO") != null?(String)respuesta.getValueAt(0, "VAL_DOCU_APLI_ANIO"):null);
			this.setDocumentoAplicacionMesSerie(respuesta.getValueAt(0, "VAL_DOCU_APLIC_MES_SERI") != null?(String)respuesta.getValueAt(0, "VAL_DOCU_APLIC_MES_SERI"):null);
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
		
			this.setHorarioNormalAdicional(respuesta.getValueAt(0, "FEC_HORA_NORM_ADIC") != null?(String)respuesta.getValueAt(0, "FEC_HORA_NORM_ADIC"):null);
			this.setIdentificadorProceso(respuesta.getValueAt(0, "COD_IDEN_PROC") != null?(String)respuesta.getValueAt(0, "COD_IDEN_PROC"):null);
			this.setImportePago(respuesta.getValueAt(0, "IMP_PAGO") != null?(BigDecimal)respuesta.getValueAt(0, "IMP_PAGO"):null);
			this.setNombreOficina(respuesta.getValueAt(0, "VAL_NOMB_OFIC") != null?(String)respuesta.getValueAt(0, "VAL_NOMB_OFIC"):null);
			this.setNumeroDocumento(respuesta.getValueAt(0, "VAL_NUME_DOCU") != null?(String)respuesta.getValueAt(0, "VAL_NUME_DOCU"):null);
			this.setNumeroFacturaBoleta(respuesta.getValueAt(0, "NUM_FACT_BOLE") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_FACT_BOLE")).longValue()):null);
			this.setNumeroLoteContabilizacion(respuesta.getValueAt(0, "VAL_NUME_LOTE_CONT") != null?(String)respuesta.getValueAt(0, "VAL_NUME_LOTE_CONT"):null);
			this.setObservaciones(respuesta.getValueAt(0, "VAL_OBSE") != null?(String)respuesta.getValueAt(0, "VAL_OBSE"):null);
			//modificado el tipo a String poir inc 21735
            //this.setOficinaRecaudadora(respuesta.getValueAt(0, "VAL_OFIC_RECA") != null?new Integer(((BigDecimal)respuesta.getValueAt(0, "VAL_OFIC_RECA")).intValue()):null);
            this.setOficinaRecaudadora(respuesta.getValueAt(0, "VAL_OFIC_RECA") != null? (String)respuesta.getValueAt(0, "VAL_OFIC_RECA"):null);
			this.setUsuarioProceso(respuesta.getValueAt(0, "VAL_USUA_PROC") != null?(String)respuesta.getValueAt(0, "VAL_USUA_PROC"):null);
			this.setNumeroCupon(respuesta.getValueAt(0, "NUM_CUPO") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_CUPO")).longValue()):null);
			this.setTipoAbonoUltimo(respuesta.getValueAt(0, "TCAB_OID_ABON_ULTI") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "TCAB_OID_ABON_ULTI")).longValue()):null);
			this.setSubprocesoMarcasUltimo(respuesta.getValueAt(0, "SUBP_OID_MARC_ULTI") != null?new Long(((BigDecimal)respuesta.getValueAt(0, "SUBP_OID_MARC_ULTI")).longValue()):null);
			this.setNumeroLoteExterno(respuesta.getValueAt(0, "NUM_LOTE_EXTE".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_LOTE_EXTE".toUpperCase())).longValue()) : null);
			this.setNMovimientoCaja(respuesta.getValueAt(0, "MCAC_OID_CABE".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "MCAC_OID_CABE")).longValue()) : null);
			this.setSaldoPendiente(respuesta.getValueAt(0, "IMP_SALD_PEND".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "IMP_SALD_PEND".toUpperCase()) : null);
			//this.setImporteMovimiento(respuesta.getValueAt(0, "VAL_IMPO_MOVI".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0, "VAL_IMPO_MOVI".toUpperCase()) : null);
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
        String query  = " DELETE FROM CCC_COPIA_MOVIM_BANCA WHERE OID_MOVI_BANC = ?";

        vector.add((Long)context.getPrimaryKey());
        try {
            ejecutaUpdate(query.toString(), vector);
        } catch (Exception exception) {
                throw new EJBException();
        }		
	}

	public void ejbStore() {


        Vector vector= new Vector();
        StringBuffer query  = new StringBuffer(" UPDATE CCC_COPIA_MOVIM_BANCA SET "+
            "SOCI_OID_SOCI = ?, "+
            "SUBP_OID_SUBP = ?, "+
            "CCBA_OID_CC_BANC = ?, "+
			"CLIE_OID_CLIE = ? , "+ 
			"PAIS_OID_PAIS = ? , " +
			"TCAB_OID_ABON_CREA = ? ");
			
            //"NUM_LOTE = ? "); // no es obligatorio
// el oid, primarykey, no se actualiza
        vector.add(this.getEmpresa());
        vector.add(this.getSubprocesoMarcaCreacion());
        vector.add(this.getCuentaCorriente());
        vector.add(this.getConsultoraReal());
		vector.add(this.getPais());
		vector.add(this.getTipoAbonoCreacion());
        //vector.add(this.getNumeroLote());

		if (this.getNumeroLote()!=null){
			query.append(", NUM_LOTE = ?");
			vector.add(this.getNumeroLote());
		}else {
			query.append(", NUM_LOTE = null");
		}

		if (this.getCodigoConsultora()!=null){
			query.append(", COD_CONS = ?");
			vector.add(this.getCodigoConsultora());
		}else {
			query.append(", COD_CONS = null");
		}

		if (this.getConsecutivoTransaccion()!=null){
			query.append(", NUM_CONS_TRAN = ?");
			vector.add(this.getConsecutivoTransaccion());
		}else {
			query.append(", NUM_CONS_TRAN = null");
		}
	 
		if (this.getCodigoError()!=null){
			query.append(", COD_ERRO = ?");
			vector.add(this.getCodigoError());
		}else {
			query.append(", COD_ERRO = null");
		}

		if (this.getDigitoChequeoFactura()!=null){
			query.append(", NUM_DIGI_CHEQ_FACT = ?");
			vector.add(this.getDigitoChequeoFactura());
		}else {
			query.append(", NUM_DIGI_CHEQ_FACT = null");
		}

		if (this.getDocumentoAplicacionAnyo()!=null){
			query.append(", VAL_DOCU_APLI_ANIO = ?");
			vector.add(this.getDocumentoAplicacionAnyo());
		}else {
			query.append(", VAL_DOCU_APLI_ANIO = null");
		}

		if (this.getDocumentoAplicacionMesSerie()!=null){
			query.append(", VAL_DOCU_APLIC_MES_SERI = ?");
			vector.add(this.getDocumentoAplicacionMesSerie());
		}else {
			query.append(", VAL_DOCU_APLIC_MES_SERI = null");
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
			query.append(", FEC_HORA_NORM_ADIC = ?");
			vector.add(this.getHorarioNormalAdicional());
		}else {
			query.append(", FEC_HORA_NORM_ADIC = null");
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
			query.append(", VAL_OFIC_RECA = ?");
			vector.add(this.getOficinaRecaudadora());
		}else {
			query.append(", VAL_OFIC_RECA = null");
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


		/*if (this.getImporteMovimiento()!=null){
			query.append(", VAL_IMPO_MOVI = ?");
			vector.add(this.get());
		}else {
			query.append(", VAL_IMPO_MOVI = null");
		}*/
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

    /** Metodo privado para realizar consultas a BBDD con DBService
    * @param query sentencia SQL con la consulta
    * @param argumentos valores de los parametros de la consulta
    * @return RecordSet con la respuesta a la consulta realizada */
    private int ejecutaUpdate(String query, Vector argumentos)
        throws EJBException {
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

        loguearSql("**** BMP CopiaMovimientosBancarios: ", query, argumentos);

        return res;
    }

    private void loguearSql(String metodo, String sql, Vector params) {
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                if (params.elementAt(i) != null) {
                    sParams += ("param " + (i + 1) + ": " +
                    (params.elementAt(i)).toString() + ", ");
                } else {
                    sParams += ("param " + (i + 1) + ": es nulo, ");
                }
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }

    private Log getLog() {
        Log log = null;

        try {
            return (((LoggingService) MareMii.getService(new MareTopic(
                    "LoggingService"))).getMareLog());
        } catch (Exception e) {
            e.printStackTrace();
            UtilidadesLog.debug("No se pudo obtener el objeto Log");
            throw new RuntimeException("No se pudo obtener el objeto Log");
        }
    }

    public Long getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Long newNumeroLote) {
        numeroLote = newNumeroLote;
    }

    public Long getConsecutivoTransaccion() {
        return consecutivoTransaccion;
    }

    public void setConsecutivoTransaccion(Long newConsecutivoTransaccion) {
        consecutivoTransaccion = newConsecutivoTransaccion;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Integer getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(Integer newNumeroHistoria) {
        numeroHistoria = newNumeroHistoria;
    }

    public Long getNumeroFacturaBoleta() {
        return numeroFacturaBoleta;
    }

    public void setNumeroFacturaBoleta(Long newNumeroFacturaBoleta) {
        numeroFacturaBoleta = newNumeroFacturaBoleta;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date newFechaPago) {
        fechaPago = newFechaPago;
    }

    public BigDecimal getImportePago() {
        return importePago;
    }

    public void setImportePago(BigDecimal newImportePago) {
        importePago = newImportePago;
    }

    public BigDecimal getImporteAplicado() {
        return importeAplicado;
    }

    public void setImporteAplicado(BigDecimal newImporteAplicado) {
        importeAplicado = newImporteAplicado;
    }



    public BigDecimal getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(BigDecimal newSaldoPendiente) {
        saldoPendiente = newSaldoPendiente;
    }

    public Long getNumeroCupon() {
        return numeroCupon;
    }

    public void setNumeroCupon(Long newNumeroCupon) {
        numeroCupon = newNumeroCupon;
    }

    public String getCodigoConsultora() {
        return codigoConsultora;
    }

    public void setCodigoConsultora(String newCodigoConsultora) {
        codigoConsultora = newCodigoConsultora;
    }

    public Integer getDigitoChequeoFactura() {
        return digitoChequeoFactura;
    }

    public void setDigitoChequeoFactura(Integer newDigitoChequeoFactura) {
        digitoChequeoFactura = newDigitoChequeoFactura;
    }

    //Modificado el tipo a String por inc 21735
    public String getOficinaRecaudadora() {
        return oficinaRecaudadora;
    }
    
    //Modificado el tipo a String por inc 21735
    public void setOficinaRecaudadora(String oficinaRecaudadora) {
        oficinaRecaudadora = oficinaRecaudadora;
    }

    public String getNombreOficina() {
        return nombreOficina;
    }

    public void setNombreOficina(String newNombreOficina) {
        nombreOficina = newNombreOficina;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String newNumeroDocumento) {
        numeroDocumento = newNumeroDocumento;
    }

    public String getHorarioNormalAdicional() {
        return horarioNormalAdicional;
    }

    public void setHorarioNormalAdicional(String newHorarioNormalAdicional) {
        horarioNormalAdicional = newHorarioNormalAdicional;
    }

    public String getUsuarioProceso() {
        return usuarioProceso;
    }

    public void setUsuarioProceso(String newUsuarioProceso) {
        usuarioProceso = newUsuarioProceso;
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

    public String getDocumentoCreacionMesSerie() {
        return documentoCreacionMesSerie;
    }

    public void setDocumentoCreacionMesSerie(
        String newDocumentoCreacionMesSerie) {
        documentoCreacionMesSerie = newDocumentoCreacionMesSerie;
    }

    public String getDocumentoCreacionAnyo() {
        return documentoCreacionAnyo;
    }

    public void setDocumentoCreacionAnyo(String newDocumentoCreacionAnyo) {
        documentoCreacionAnyo = newDocumentoCreacionAnyo;
    }

    public Integer getDocumentoCreacionNumero() {
        return documentoCreacionNumero;
    }

    public void setDocumentoCreacionNumero(Integer newDocumentoCreacionNumero) {
        documentoCreacionNumero = newDocumentoCreacionNumero;
    }

    public String getDocumentoAplicacionMesSerie() {
        return documentoAplicacionMesSerie;
    }

    public void setDocumentoAplicacionMesSerie(
        String newDocumentoAplicacionMesSerie) {
        documentoAplicacionMesSerie = newDocumentoAplicacionMesSerie;
    }

    public String getDocumentoAplicacionAnyo() {
        return documentoAplicacionAnyo;
    }

    public void setDocumentoAplicacionAnyo(String newDocumentoAplicacionAnyo) {
        documentoAplicacionAnyo = newDocumentoAplicacionAnyo;
    }

    public Integer getDocumentoAplicacionNumero() {
        return documentoAplicacionNumero;
    }

    public void setDocumentoAplicacionNumero(
        Integer newDocumentoAplicacionNumero) {
        documentoAplicacionNumero = newDocumentoAplicacionNumero;
    }

    public Timestamp getFechaMovimientoAplicacion() {
        return fechaMovimientoAplicacion;
    }

    public void setFechaMovimientoAplicacion(
        Timestamp newFechaMovimientoAplicacion) {
        fechaMovimientoAplicacion = newFechaMovimientoAplicacion;
    }

    public String getEstatusMovimientoPendienteAplicado() {
        return estatusMovimientoPendienteAplicado;
    }

    public void setEstatusMovimientoPendienteAplicado(
        String newEstatusMovimientoPendienteAplicado) {
        estatusMovimientoPendienteAplicado = newEstatusMovimientoPendienteAplicado;
    }

    public String getIdentificadorProceso() {
        return identificadorProceso;
    }

    public void setIdentificadorProceso(String newIdentificadorProceso) {
        identificadorProceso = newIdentificadorProceso;
    }

    public String getNumeroLoteContabilizacion() {
        return numeroLoteContabilizacion;
    }

    public void setNumeroLoteContabilizacion(
        String newNumeroLoteContabilizacion) {
        numeroLoteContabilizacion = newNumeroLoteContabilizacion;
    }

    public Date getFechaContabilizacion() {
        return fechaContabilizacion;
    }

    public void setFechaContabilizacion(Date newFechaContabilizacion) {
        fechaContabilizacion = newFechaContabilizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }

    public Long getNumeroLoteExterno() {
		return numeroLoteExterno;
    }

    public void setNumeroLoteExterno(Long newNumeroLoteExterno) {
		numeroLoteExterno = newNumeroLoteExterno;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String newCodigoUsuario) {
        codigoUsuario = newCodigoUsuario;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long newEmpresa) {
        empresa = newEmpresa;
    }

    public Long getTipoAbonoCreacion() {
        return tipoAbonoCreacion;
    }

    public void setTipoAbonoCreacion(Long newTipoAbonoCreacion) {
        tipoAbonoCreacion = newTipoAbonoCreacion;
    }

    public Long getSubacceso() {
		return subacceso;
    }

    public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
    }

    public Long getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(Long newCuentaCorriente) {
        cuentaCorriente = newCuentaCorriente;
    }

    public Long getError() {
		return error;
    }

    public void setError(Long newError) {
		error = newError;
    }

    public Long getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(Long newTipoTransaccion) {
        tipoTransaccion = newTipoTransaccion;
    }

    public Long getSubprocesoMarcasUltimo() {
		return subprocesoMarcasUltimo;
    }

    public void setSubprocesoMarcasUltimo(Long newSubprocesoMarcasUltimo) {
		subprocesoMarcasUltimo = newSubprocesoMarcasUltimo;
    }

    public Long getSubprocesoMarcaCreacion() {
		return subprocesoMarcaCreacion;
    }

    public void setSubprocesoMarcaCreacion(Long newSubprocesoMarcaCreacion) {
		subprocesoMarcaCreacion = newSubprocesoMarcaCreacion;
    }

    public Long getConsultoraReal() {
		return consultoraReal;
    }

    public void setConsultoraReal(Long newConsultoraReal) {
		consultoraReal = newConsultoraReal;
    }

    public Long getNMovimientoCaja() {
		return nMovimientoCaja;
    }

    public void setNMovimientoCaja(Long newNMovimientoCaja) {
		nMovimientoCaja = newNMovimientoCaja;
    }

    public Long getTipoAbonoUltimo() {
        return tipoAbonoUltimo;
    }

    public void setTipoAbonoUltimo(Long newTipoAbonoUltimo) {
        tipoAbonoUltimo = newTipoAbonoUltimo;
    }

    public Collection ejbFindAll() throws Exception {
        try {
            BelcorpService instance = BelcorpService.getInstance();
            String query = "SELECT * FROM CCC_COPIA_MOVIM_BANCA WHERE 1=1 ";
            Vector vec = new Vector();
            RecordSet rs = instance.dbService.executePreparedQuery(query, vec);
            ArrayList respuesta = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                this.oid = new Long(((BigDecimal) rs.getValueAt(i,
                            "OID_COPI_MOVI_BANC")).longValue());
                respuesta.add(this.oid);
            }

            return respuesta;
        } catch (Exception ex) {
            throw new FinderException("CopiaMovimientoBancario. " +
                ex.getMessage());
        }
    }

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String newCodigoError) {
		codigoError = newCodigoError;
	}
}
