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
	 * Modulo:	   	FAC
	 * Submódulo:		
	 * Componente:		ENTIDADES
	 * Fecha: 28/09/2004
	 * Observaciones:     	Componente construido de acuerdo a la especificación del 
	 *          Modelo de Componentes SICC-DMCO-CCC-201-344-N0005 
	 * Descripcion:		Este componente mapea a la tabla FAC_DOCUM_CONTA_CABEC 
	 * @version		1.0
	 * @autor		Carlos Sánchez Hernández  csanchezh
	 */


package es.indra.sicc.entidades.fac;
import javax.ejb.EntityBean;
import javax.ejb.DuplicateKeyException; 
import javax.ejb.EntityContext;
import javax.ejb.CreateException; 
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import es.indra.sicc.util.UtilidadesLog;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Vector;
import java.math.BigDecimal;


import es.indra.sicc.util.SecuenciadorOID;  
import es.indra.sicc.util.BelcorpService; 

import es.indra.mare.common.mii.MareMii;                       
import es.indra.mare.common.mii.MareTopic;                     
import es.indra.mare.common.exception.MareException;           
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import org.apache.commons.logging.Log;
 

public class CabeceraDocumentoContableBean implements EntityBean  {
    
	private EntityContext context;

	public Long oid;
	public Long numDocumentoContableInterno;
	public Long zona;
	public Long sugerenciaVenta;
	public Long seccion;
	public Long region;
	public Long territorio;
	public Long empresa;
	public Long formaPagoCabecera;
	public Long clienteDirecion;
	public Long pais;
	public Long periodo;
	public Long subacceso;
	public Long solicitudCabecera;
	public Long formulario;
	public Long moneda;
	public Long tipoDocumento;
             
	public Timestamp fechaEmision;
	public Timestamp fechaFacturacion;
	public Boolean status;
                
	public String puntoEmision;
	public String ejercicioDocumentoInterno;
	public String numIdentificacionFiscal;
	public String numIdentificacionNacional;
	public String observaciones;
	public String nombre1;
	public String nombre2;
	public String apellido1;
	public String apellido2;
                
	public String serieDocumentolegal;
	public Integer numeroAbono;
	public Long numeroDocumentoLegal;

	//Añadidos por la incidencia 10073
	public Integer unidadesAtendidasTotal;
	public BigDecimal precioCatalogoTotalDocumento;
	public BigDecimal precioCatalogoSinImpuestoTotalDocumento;
	public BigDecimal precioContableTotalDocumento;
	public BigDecimal precioContableSinImpuestoTotalDocumento;
	public BigDecimal importeDescuento1TotalDocumento;
	public BigDecimal importeDescuento1SinImpuestosTotalDocumento;
	public BigDecimal importeDescuento3SinImpuestoTotalDocumento;
	public BigDecimal importeDescuentoTotalDocumento;
	public BigDecimal precioFacturaTotalDocumento;
	public BigDecimal importeImpuestosTotalDocumento;
	public BigDecimal precioTotalTotalDocumento;

	
	//añididos por la incidencia BELC300012285
	public Boolean indicadorImpresion; 

	public Long  numeroDocumentoOrigen;

	public String tipoDireccion;
	public String almacen;

	public BigDecimal precioCatalogoSinImpuestoTotalLocal;                         
	public BigDecimal precioContableSinImpuestosTotalLocal;                         
	public BigDecimal precioCatalogoTotalLocal;                         
	public BigDecimal precioCatalogoTotalLocalUnidadesPorAtender;                         
	public BigDecimal precioContableTotalLocal;                         
	public BigDecimal importeDescuento1TotalLocal;                         
	public BigDecimal importeDescuento1SinImpuestosTotalLocal;                         
	public BigDecimal precioFacturaTotalLocal;                         
	public BigDecimal precioTotalTotalLocal;                         
	public BigDecimal importeDescuento3SinImpuestosTotalLocal;                         
	public BigDecimal importeDescuentoTotalLocal;                         
	public BigDecimal precioNetoTotalLocal;                         
	public BigDecimal importeImpuestosTotalLocal;                         
	public BigDecimal totalAPagarLocal;                         
	public BigDecimal totalAPagarDocumento;                         
	public BigDecimal importeRedondeoLocal;                         
	public BigDecimal importeRedondeoConsolidadoLocal;                                
	public BigDecimal tipoCambio;                          
	public BigDecimal importeFleteTotalLocal;                         
	public BigDecimal importeFleteTotalDocumento;                         
	public BigDecimal importeDescuento3TotalLocal;                                      
	public BigDecimal importeDescuento3TotalDocumento;                              
	public BigDecimal precioNetoTotalDocumento;
	public BigDecimal importeFleteSinImpuestosTotalDocumento;
	public BigDecimal importeRedondeoConsolidadoDocumento;                         
	public BigDecimal importeRedondeoDocumento; 

    // Añadidos por la BELC300013384
    public Date fechaContabilizacion;
    public String numeroLoteContabilizacion;
    public BigDecimal importeFleteSinImpuestosTotalLocal;
    
    //Añadido por incidencia BELC300021005
    public String direccionCompleta;

	public Long ejbCreate( 
		Long numDocumentoContableInterno, Long zona, Long sugerenciaVenta, 
        Long seccion, Long region, Long territorio, Long empresa, 
        Long formaPagoCabecera, Long clienteDirecion, Long pais, Long periodo, 
        Long subacceso, Long solicitudCabecera, Long formulario, 
        Long tipoDocumento, Timestamp fechaEmision, 
        Timestamp fechaFacturacion, Boolean status, 
        String ejercicioDocumentoInterno, String nombre1, String nombre2, 
        String apellido1, String apellido2, String numeroIdentificacionFiscal, 
        Long numeroDocumentoLegal, String serieDocumentoLegal, 
        String direccionCompleta) throws  CreateException, DuplicateKeyException  {
        
        UtilidadesLog.debug("*** SCS dentro de ejbCreate: Cabecera Documento Contable....");

		Vector vector= new Vector();

		//this.setOid(oid);
		this.setNumDocumentoContableInterno(numDocumentoContableInterno);
		this.setZona(zona);
		this.setSugerenciaVenta(sugerenciaVenta);
		this.setSeccion(seccion);
		this.setRegion(region);
		this.setTerritorio(territorio);
		this.setEmpresa(empresa);
		this.setFormaPagoCabecera(formaPagoCabecera);
		this.setClienteDirecion(clienteDirecion);
		this.setPais(pais);
		this.setPeriodo(periodo);
		this.setSubacceso(subacceso);
		this.setSolicitudCabecera(solicitudCabecera);
		this.setFormulario(formulario);
		//this.setMoneda(moneda);
				this.setTipoDocumento(tipoDocumento);//ojo añadido
		this.setFechaEmision(fechaEmision);
		this.setFechaFacturacion(fechaFacturacion);
		this.setStatus(status);
		this.setEjercicioDocumentoInterno(ejercicioDocumentoInterno);
        
        // nombre1, nombre2, apellido1, apellido2 son nulables. En los casos en los que venga nulo
        // insertaremos cadena vacía
		this.setNombre1(nombre1!=null?nombre1:"");
		this.setNombre2(nombre2!=null?nombre2:"");
		this.setApellido1(apellido1!=null?apellido1:"");
		this.setApellido2(apellido2!=null?apellido2:"");
        //se añaden al create 
        this.setNumIdentificacionFiscal(numeroIdentificacionFiscal);
		this.setNumeroDocumentoLegal(numeroDocumentoLegal);
		this.setSerieDocumentolegal(serieDocumentoLegal);
        //añadido por incidencia 21005
        // insertaremos cadena vacía si viene a null
        this.setDireccionCompleta(direccionCompleta!=null?direccionCompleta:"");
        
        UtilidadesLog.debug("*** SCS, luego de los seteos, obtengo secuencia");
        
		try {
			// Asignar el nuevo oid
			this.setOid(SecuenciadorOID.obtenerSiguienteValor("FAC_DCCA_SEQ"));
		} catch (MareException me) {
			//throw new CreateException();
		}
        
        UtilidadesLog.debug("*** SCS, obtuve secuencia");

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
						//" MONE_OID_MONE, " +
						" TIDO_OID_TIPO_DOCU, " +
						" FEC_EMIS, " +
						" FEC_FACT, " +
						" VAL_ESTA, " +
						" VAL_EJER_DOCU_INTE, " +
						" VAL_NOM1, " +
						" VAL_NOM2, " +
						" VAL_APE1, " +
						" VAL_APE2, "+
                        " VAL_NUME_IDEN_FISC, "+
						" NUM_DOCU_LEGA, " +
						" VAL_SERI_DOCU_LEGA, " +
                        " VAL_DIRE_COMP ");

		UtilidadesLog.debug("*** [cs] Pais - " + this.getPais());

		vector.add(this.getOid());
		vector.add(this.getNumDocumentoContableInterno());
		vector.add(this.getZona());
		vector.add(this.getSugerenciaVenta());
		vector.add(this.getSeccion());
		vector.add(this.getRegion());
		vector.add(this.getTerritorio());
		vector.add(this.getEmpresa());
		vector.add(this.getFormaPagoCabecera());
		vector.add(this.getClienteDirecion());
		vector.add(this.getPais());
		vector.add(this.getPeriodo());
		vector.add(this.getSubacceso());
		vector.add(this.getSolicitudCabecera());
		vector.add(this.getFormulario());
		
		//vector.add(this.getMoneda());
		vector.add(this.getTipoDocumento());
		vector.add(this.getFechaEmision());
		vector.add(this.getFechaFacturacion());
		
		vector.add(this.getStatus());

		vector.add(this.getEjercicioDocumentoInterno());
		vector.add(this.getNombre1());
		vector.add(this.getNombre2());
		vector.add(this.getApellido1());
		vector.add(this.getApellido2());
        
        vector.add(this.getNumIdentificacionFiscal());
		vector.add(this.getNumeroDocumentoLegal());
		vector.add(this.getSerieDocumentolegal());
        
        //añadido por incidencia 21005
        vector.add(this.getDireccionCompleta());
		UtilidadesLog.debug("*** SCS, vector de parametros: " + vector);
		query.append(") VALUES (?");
        for (int i = 1; i < vector.size(); i++){
            query.append(", ?");
        }
        query.append(")");
		
        UtilidadesLog.debug("SCS sql del create sobre: CabeceraDocumentoContable: " + query.toString());
        loguearSql("**** SCS  CabeceraDocumentoContable: ", query.toString(), vector);
        
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
        
        return this.getOid();
	}
	public void ejbPostCreate(Long numDocumentoContableInterno, Long zona, Long sugerenciaVenta, Long seccion, Long region, Long territorio, Long empresa, Long formaPagoCabecera, Long clienteDirecion, Long pais, Long periodo, Long subacceso, Long solicitudCabecera, Long formulario, Long tipoDocumento, Timestamp fechaEmision, Timestamp fechaFacturacion, Boolean status, String ejercicioDocumentoInterno, String nombre1, String nombre2, String apellido1, String apellido2, 
                String numeroIdentificacionFiscal, Long numeroDocumentoLegal, String serieDocumentoLegal, String direccionCompleta) throws  CreateException, DuplicateKeyException{
	}
	/**
	 * Metodo ejbCreate al que se le pasan todos los parametros 
	 */
	public Long ejbCreate( 
		Long numDocumentoContableInterno, Long zona, Long sugerenciaVenta, 
        Long seccion, Long region, Long territorio, Long empresa, 
        Long formaPagoCabecera, Long clienteDirecion, Long pais, 
        Long periodo, Long subacceso, Long solicitudCabecera, 
        Long formulario, Long moneda, Long tipoDocumento, 
        Timestamp fechaEmision, Timestamp fechaFacturacion, 
        Boolean status, String puntoEmision, 
        String ejercicioDocumentoInterno, String numIdentificacionFiscal, 
        String numIdentificacionNacional, String observaciones, 
        String nombre1, String nombre2, String apellido1, String apellido2, 
        String serieDocumentolegal, Integer numeroAbono, 
        Long numeroDocumentoLegal, Integer unidadesAtendidasTotal, 
        BigDecimal precioCatalogoTotalDocumento, 
        BigDecimal precioCatalogoSinImpuestoTotalDocumento, 
        BigDecimal precioContableTotalDocumento, 
        BigDecimal precioContableSinImpuestoTotalDocumento, 
        BigDecimal importeDescuento1TotalDocumento, 
        BigDecimal importeDescuento1SinImpuestosTotalDocumento, 
        BigDecimal importeDescuento3SinImpuestoTotalDocumento, 
        BigDecimal importeDescuentoTotalDocumento, 
        BigDecimal precioFacturaTotalDocumento, 
        BigDecimal importeImpuestosTotalDocumento, 
        BigDecimal precioTotalTotalDocumento, Boolean indicadorImpresion, 
        Long numeroDocumentoOrigen, String tipoDireccion, String almacen, 
        BigDecimal precioCatalogoSinImpuestoTotalLocal, 
        BigDecimal precioContableSinImpuestosTotalLocal, 
        BigDecimal precioCatalogoTotalLocal, 
        BigDecimal precioCatalogoTotalLocalUnidadesPorAtender, 
        BigDecimal precioContableTotalLocal, 
        BigDecimal importeDescuento1TotalLocal, 
        BigDecimal importeDescuento1SinImpuestosTotalLocal, 
        BigDecimal precioFacturaTotalLocal, BigDecimal precioTotalTotalLocal, 
        BigDecimal importeDescuento3SinImpuestosTotalLocal, 
        BigDecimal importeDescuentoTotalLocal, 
        BigDecimal precioNetoTotalLocal, 
        BigDecimal importeImpuestosTotalLocal, BigDecimal totalAPagarLocal, 
        BigDecimal totalAPagarDocumento, BigDecimal importeRedondeoLocal, 
        BigDecimal importeRedondeoConsolidadoLocal, BigDecimal tipoCambio, 
        BigDecimal importeFleteTotalLocal, 
        BigDecimal importeFleteTotalDocumento, 
        BigDecimal importeDescuento3TotalLocal, 
        BigDecimal importeDescuento3TotalDocumento, 
        BigDecimal precioNetoTotalDocumento, 
        BigDecimal importeFleteSinImpuestosTotalDocumento, 
        BigDecimal importeRedondeoConsolidadoDocumento, 
        BigDecimal importeRedondeoDocumento, Date fechaContabilizacion, 
        String numeroLoteContablilizacion, 
        BigDecimal importeFleteSinImpuestosTotalLocal, 
        String direccionCompleta) throws  CreateException, DuplicateKeyException   {



		Vector vector= new Vector();
		//this.setOid(oid);
		this.setNumDocumentoContableInterno(numDocumentoContableInterno);
		this.setZona(zona);
		this.setSugerenciaVenta(sugerenciaVenta);
		this.setSeccion(seccion);
		this.setRegion(region);
		this.setTerritorio(territorio);
		this.setEmpresa(empresa);
		this.setFormaPagoCabecera(formaPagoCabecera);
		this.setClienteDirecion(clienteDirecion);
		this.setPais(pais);
		this.setPeriodo(periodo);
		this.setSubacceso(subacceso);
		this.setSolicitudCabecera(solicitudCabecera);
		this.setFormulario(formulario);
		this.setMoneda(moneda);
		this.setTipoDocumento(tipoDocumento);
		this.setFechaEmision(fechaEmision);
		this.setFechaFacturacion(fechaFacturacion);
		this.setStatus(status);
		this.setPuntoEmision(puntoEmision);
		this.setEjercicioDocumentoInterno(ejercicioDocumentoInterno);
		this.setNumIdentificacionFiscal(numIdentificacionFiscal);
		this.setNumIdentificacionNacional(numIdentificacionNacional);
		this.setObservaciones(observaciones);

        // nombre1, nombre2, apellido1, apellido2 son nulables. En los casos en los que venga nulo
        // insertaremos cadena vacía
		this.setNombre1(nombre1!=null?nombre1:"");
		this.setNombre2(nombre2!=null?nombre2:"");
		this.setApellido1(apellido1!=null?apellido1:"");
		this.setApellido2(apellido2!=null?apellido2:"");

		this.setSerieDocumentolegal(serieDocumentolegal);
		this.setNumeroAbono(numeroAbono);
		this.setNumeroDocumentoLegal(numeroDocumentoLegal);
		//Añadidos por incidencia 10073
		this.setUnidadesAtendidasTotal(unidadesAtendidasTotal);
		this.setPrecioCatalogoTotalDocumento(precioCatalogoTotalDocumento);
		this.setPrecioCatalogoSinImpuestoTotalDocumento(precioCatalogoSinImpuestoTotalDocumento);
		this.setPrecioContableTotalDocumento(precioContableTotalDocumento);
		this.setPrecioContableSinImpuestoTotalDocumento(precioContableSinImpuestoTotalDocumento);
		this.setImporteDescuento1SinImpuestosTotalDocumento(importeDescuento1SinImpuestosTotalDocumento);
		this.setImporteDescuento1TotalDocumento(importeDescuento1TotalDocumento);
		this.setImporteDescuento3SinImpuestoTotalDocumento(importeDescuento3SinImpuestoTotalDocumento);
		this.setImporteDescuentoTotalDocumento(importeDescuentoTotalDocumento);
		this.setPrecioTotalTotalDocumento(precioTotalTotalDocumento);

		//añadidos por incidencia BELC300012285
		this.setIndicadorImpresion(indicadorImpresion);     
		this.setNumeroDocumentoOrigen(numeroDocumentoOrigen);    
		this.setTipoDireccion(tipoDireccion); 
		this.setAlmacen(almacen);    
		this.setPrecioCatalogoSinImpuestoTotalLocal(precioCatalogoSinImpuestoTotalLocal);                            
		this.setPrecioContableSinImpuestosTotalLocal(precioContableSinImpuestosTotalLocal);                             
		this.setPrecioCatalogoTotalLocal(precioCatalogoTotalLocal);                             
		this.setPrecioCatalogoTotalLocalUnidadesPorAtender(precioCatalogoTotalLocalUnidadesPorAtender);                             
		this.setPrecioContableTotalLocal(precioContableTotalLocal);                            
		this.setImporteDescuento1TotalLocal(importeDescuento1TotalLocal);                             
		this.setImporteDescuento1SinImpuestosTotalLocal(importeDescuento1SinImpuestosTotalLocal);                             
		this.setPrecioFacturaTotalLocal(precioFacturaTotalLocal);                             
		this.setPrecioTotalTotalLocal(precioTotalTotalLocal);                             
		this.setImporteDescuento3SinImpuestosTotalLocal(importeDescuento3SinImpuestosTotalLocal);                             
		this.setImporteDescuentoTotalLocal(importeDescuentoTotalLocal);                             
		this.setPrecioNetoTotalLocal(precioNetoTotalLocal);                             
		this.setImporteImpuestosTotalLocal(importeImpuestosTotalLocal);                             
		this.setTotalAPagarLocal(totalAPagarLocal);                             
		this.setTotalAPagarDocumento(totalAPagarDocumento);                             
		this.setImporteRedondeoLocal(importeRedondeoLocal);                             
		this.setImporteRedondeoConsolidadoLocal(importeRedondeoConsolidadoLocal);                                    
		this.setTipoCambio(tipoCambio);                              
		this.setImporteFleteTotalLocal(importeFleteTotalLocal);                             
		this.setImporteFleteTotalDocumento(importeFleteTotalDocumento);                             
		this.setImporteDescuento3TotalLocal(importeDescuento3TotalLocal);                                          
		this.setImporteDescuento3TotalDocumento(importeDescuento3TotalDocumento);                                  
		this.setPrecioNetoTotalDocumento(precioNetoTotalDocumento);  
        this.setImporteFleteSinImpuestosTotalDocumento(importeFleteSinImpuestosTotalDocumento);                             
		this.setImporteRedondeoConsolidadoDocumento(importeRedondeoConsolidadoDocumento);                             
		this.setImporteRedondeoDocumento(importeRedondeoDocumento);
		this.setFechaContabilizacion(fechaContabilizacion);
        this.setNumeroLoteContabilizacion(numeroLoteContablilizacion);
        this.setImporteFleteSinImpuestosTotalLocal(importeFleteSinImpuestosTotalLocal);
        
        //añadido por incidencia 21005
        // insertaremos cadena vacía
        this.setDireccionCompleta(direccionCompleta!=null?direccionCompleta:"");

		try {
			// Asignar el nuevo oid
			this.setOid(SecuenciadorOID.obtenerSiguienteValor("FAC_DCCA_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

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
						//" MONE_OID_MONE, " + es opcional
						" TIDO_OID_TIPO_DOCU, " +
						" FEC_EMIS, " +
						" FEC_FACT, " +
						" VAL_ESTA, " +
						" VAL_EJER_DOCU_INTE, " +
						//" VAL_NUME_IDEN_FISC, " + es opcional
						" VAL_NOM1, " +
						" VAL_NOM2, " +
						" VAL_APE1, " +
						" VAL_APE2, " +
                        " VAL_DIRE_COMP ");

		vector.add(this.getOid());
		vector.add(this.getNumDocumentoContableInterno());
		vector.add(this.getZona());
		vector.add(this.getSugerenciaVenta());
		vector.add(this.getSeccion());
		vector.add(this.getRegion());
		vector.add(this.getTerritorio());
		vector.add(this.getEmpresa());
		vector.add(this.getFormaPagoCabecera());
		vector.add(this.getClienteDirecion());
		vector.add(this.getPais());
		vector.add(this.getPeriodo());
		vector.add(this.getSubacceso());
		vector.add(this.getSolicitudCabecera());
		vector.add(this.getFormulario());
		//vector.add(this.getMoneda()); es opcional
		vector.add(this.getTipoDocumento());
		vector.add(this.getFechaEmision());
		vector.add(this.getFechaFacturacion());
		vector.add(this.getStatus());
		
		vector.add(this.getEjercicioDocumentoInterno());
				
		vector.add(this.getNombre1());
		vector.add(this.getNombre2());
		vector.add(this.getApellido1());
		vector.add(this.getApellido2());
		if(this.getMoneda()!=null){
			query.append(" , MONE_OID_MONE ");
			vector.add(this.getMoneda());
		}
		if(this.getSerieDocumentolegal() != null){
			query.append(" , VAL_SERI_DOCU_LEGA ");
			vector.add(this.getSerieDocumentolegal());
		}
		if(this.getNumeroAbono() != null){
			query.append(" , NUM_ABON ");
			vector.add(this.getNumeroAbono());
		}
		if(this.getNumeroDocumentoLegal() != null){
			query.append(" , NUM_DOCU_LEGA ");
			vector.add(this.getNumeroDocumentoLegal());
		}
		//añadidos por incidencia 10073
		if(this.getUnidadesAtendidasTotal() != null){
			query.append(", NUM_UNID_ATEN_TOTA ");
			vector.add(this.getUnidadesAtendidasTotal());
		}
		if(this.getPrecioCatalogoTotalDocumento() != null){
			query.append(", VAL_PREC_CATA_TOTA_DOCU ");
			vector.add(this.getPrecioCatalogoTotalDocumento());
		}
		if(this.getPrecioCatalogoSinImpuestoTotalDocumento() != null){
			query.append(", VAL_PREC_CATA_SIN_IMPU_TOTA ");
			vector.add(this.getPrecioCatalogoSinImpuestoTotalDocumento());
		}
		if(this.getPrecioContableTotalDocumento() != null){
			query.append(", VAL_PREC_CONT_TOTA_DOCU ");
			vector.add(this.getPrecioContableTotalDocumento());
		}
		if(this.getPrecioContableSinImpuestoTotalDocumento() != null){
			query.append(", VAL_PREC_CONT_SIN_IMPU_TOTA ");
			vector.add(this.getPrecioContableSinImpuestoTotalDocumento());
		}
		if(this.getImporteDescuento1TotalDocumento() != null){
			query.append(", IMP_DES1_TOTA_DOCU ");
			vector.add(this.getImporteDescuento1TotalDocumento());
		}
		if(this.getImporteDescuento1SinImpuestosTotalDocumento() != null){
			query.append(", IMP_DES1_SIN_IMPU_TOTA ");
			vector.add(this.getImporteDescuento1SinImpuestosTotalDocumento());
		}
		if(this.getImporteDescuento3SinImpuestoTotalDocumento() != null){
			query.append(", IMP_DES3_SIN_IMPU_TOTA ");
			vector.add(this.getImporteDescuento3SinImpuestoTotalDocumento());
		}
		if(this.getImporteDescuentoTotalDocumento() != null){
			query.append(", IMP_DESC_TOTA_DOCU ");
			vector.add(this.getImporteDescuentoTotalDocumento());
		}
		if(this.getPrecioFacturaTotalDocumento() != null){
			query.append(", VAL_PREC_FACT_TOTA_DOCU ");
			vector.add(this.getPrecioFacturaTotalDocumento());
		}
		if(this.getImporteDescuentoTotalDocumento() != null){
			query.append(", IMP_IMPU_TOTA_DOCU ");
			vector.add(this.getImporteImpuestosTotalDocumento());
		}
		if(this.getPrecioTotalTotalDocumento() != null){
			query.append(", VAL_PREC_TOTA_TOTA_DOCU ");
			vector.add(this.getPrecioTotalTotalDocumento());
		}
		//Pasan a ser nullables. Incidencia 10104
		
		if(this.getObservaciones() != null){
			query.append(", VAL_OBSE ");
			vector.add(this.getObservaciones());
		}
		if(this.getPuntoEmision() != null){
			query.append(", VAL_PUNT_EMIS ");
			vector.add(this.getPuntoEmision());
		}
		if(this.getNumIdentificacionNacional() != null){
			query.append(", VAL_NUME_IDEN_NNAL ");
			vector.add(this.getNumIdentificacionNacional());
		}
		if(this.getNumIdentificacionFiscal() != null){
			query.append(", VAL_NUME_IDEN_FISC ");
			vector.add(this.getNumIdentificacionFiscal());
		}


		//añadidos por la incidencia 12485
		if(this.getIndicadorImpresion()!=null){
			query.append(", IND_IMPR ");
			vector.add(this.getIndicadorImpresion());
		}
		if(this.getNumeroDocumentoOrigen()!=null){
			query.append(", NUM_DOCU_ORIG ");
			vector.add(this.getNumeroDocumentoOrigen());
		}
		if(this.getTipoDireccion()!=null){
			query.append(", VAL_TIPO_DIRE ");
			vector.add(this.getTipoDireccion());
		}
		if(this.getAlmacen()!=null){
			query.append(", VAL_ALMA ");
			vector.add(this.getAlmacen());
		}		
		if(this.getPrecioCatalogoSinImpuestoTotalLocal()!=null){
			query.append(", VAL_PREC_CATA_IMPU ");
			vector.add(this.getPrecioCatalogoSinImpuestoTotalLocal());
		}
		if(this.getPrecioContableSinImpuestosTotalLocal()!=null){
			query.append(", VAL_PREC_CONT_IMPU ");
			vector.add(this.getPrecioContableSinImpuestosTotalLocal());
		}
		if(this.getPrecioCatalogoTotalLocal()!=null){
			query.append(", VAL_PREC_CATA_TOTA_LOCA ");
			vector.add(this.getPrecioCatalogoTotalLocal());
		}
		if(this.getPrecioCatalogoTotalLocalUnidadesPorAtender()!=null){
			query.append(", VAL_PREC_CATA_TOTA_LOCA_UNID ");
			vector.add(this.getPrecioCatalogoTotalLocalUnidadesPorAtender());
		}
		if(this.getPrecioContableTotalLocal()!=null){
			query.append(", VAL_PREC_CONT_TOTA_LOCA ");
			vector.add(this.getPrecioContableTotalLocal());
		}
		if(this.getImporteDescuento1TotalLocal()!=null){
			query.append(", IMP_DES1_TOTA_LOCA ");
			vector.add(this.getImporteDescuento1TotalLocal());
		}
		if(this.getImporteDescuento1SinImpuestosTotalLocal()!=null){ 
			query.append(", IMP_DES1_IMPU ");//imp_des1_impu
			vector.add(this.getImporteDescuento1SinImpuestosTotalLocal());
		}
		if(this.getPrecioFacturaTotalLocal()!=null){
			query.append(", VAL_PREC_FACT_TOTA_LOCA ");
			vector.add(this.getPrecioFacturaTotalLocal());
		}
		if(this.getPrecioTotalTotalLocal()!=null){
			query.append(", VAL_PREC_TOTA_TOTA_LOCA ");
			vector.add(this.getPrecioTotalTotalLocal());
		}
		if(this.getImporteDescuento3SinImpuestosTotalLocal()!=null){
			query.append(", IMP_DES3_IMPU ");
			vector.add(this.getImporteDescuento3SinImpuestosTotalLocal());
		}
		if(this.getImporteDescuentoTotalLocal()!=null){
			query.append(", IMP_DESC_TOTA_LOCA ");
			vector.add(this.getImporteDescuentoTotalLocal());
		}
		if(this.getPrecioNetoTotalLocal()!=null){
			query.append(", VAL_PREC_NETO_TOTA_LOCA ");
			vector.add(this.getPrecioNetoTotalLocal());
		}
		if(this.getImporteImpuestosTotalLocal()!=null){
			query.append(", IMP_IMPU_TOTA_LOCA ");
			vector.add(this.getPrecioNetoTotalLocal());
		}
		if(this.getTotalAPagarLocal()!=null){
			query.append(", VAL_TOTA_PAGA_LOCA ");
			vector.add(this.getTotalAPagarLocal());
		}
		if(this.getTotalAPagarDocumento()!=null){
			query.append(", VAL_TOTA_PAGA_DOCU ");
			vector.add(this.getTotalAPagarDocumento());
		}
		if(this.getImporteRedondeoLocal()!=null){
			query.append(", IMP_REDO_LOCA ");
			vector.add(this.getImporteRedondeoLocal());
		}
		if(this.getImporteRedondeoConsolidadoLocal()!=null){
			query.append(", IMP_REDO_CONS_LOCA ");
			vector.add(this.getImporteRedondeoConsolidadoLocal());
		}
		if(this.getTipoCambio()!=null){
			query.append(", VAL_TIPO_CAMB ");
			vector.add(this.getTipoCambio());
		}
		if(this.getImporteFleteTotalLocal()!=null){
			query.append(", IMP_FLET_TOTA_LOCA ");
			vector.add(this.getImporteFleteTotalLocal());
		}
		if(this.getImporteFleteTotalDocumento()!=null){
			query.append(", IMP_FLET_TOTA_DOCU ");
			vector.add(this.getImporteFleteTotalDocumento());
		}
		if(this.getImporteDescuento3TotalLocal()!=null){
			query.append(", IMP_DES3_TOTAL_LOCA ");
			vector.add(this.getImporteDescuento3TotalLocal());
		}
		if(this.getImporteDescuento3TotalDocumento()!=null){
			query.append(", IMP_DES3_TOTA_DOCU ");
			vector.add(this.getImporteDescuento3TotalDocumento());
		}
		if(this.getPrecioNetoTotalDocumento()!=null){
                query.append(", VAL_PREC_NETO_TOTA_DOCU ");
                vector.add(this.getPrecioNetoTotalDocumento());
		}//VAL_PREC_NETO_TOTA_DOCU
		if(this.getImporteFleteSinImpuestosTotalDocumento()!=null){
                query.append(", IMP_FLET_SIN_IMPU_TOTA_DOCU ");
                vector.add(this.getImporteFleteSinImpuestosTotalDocumento());
		}//IMP_FLET_SIN_IMPU_TOTA_DOCU
        if(this.getImporteFleteSinImpuestosTotalLocal()!=null){
                query.append(", IMP_FLET_IMPU_TOTA_LOCA ");
                vector.add(this.getImporteFleteSinImpuestosTotalLocal());
		}//IMP_FLET_IMPU_TOTA_LOCA

		if(this.getImporteRedondeoConsolidadoDocumento()!=null){
                query.append(", IMP_REDO_CONS_DOCU ");
                vector.add(this.getImporteRedondeoConsolidadoDocumento());
		}//IMP_REDO_CONS_DOCU
		if(this.getImporteRedondeoDocumento()!=null){
                query.append(", IMP_REDO_DOCU ");
                vector.add(this.getImporteRedondeoDocumento());
		}//IMP_REDO_DOCU
        
        // Incidencia BELC300013384
		if(this.getFechaContabilizacion()!=null){
                query.append(", FEC_CONT ");
                vector.add(this.getFechaContabilizacion());
		}
		if(this.getNumeroLoteContabilizacion()!=null){
                query.append(", NUM_LOTE_CONT ");
                vector.add(this.getNumeroLoteContabilizacion());
		}
        
        //añadido por incidencia 21005
        vector.add(this.getDireccionCompleta());
		
        
                            
		query.append(") VALUES (?");
        for (int i = 1; i < vector.size(); i++){
            query.append(", ?");
        }
        query.append(")");
							
		try {
            loguearSql("**** BMP  CabeceraDocumentoContable: ", query.toString(), vector);
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
        
        return this.getOid();
	}


	public void ejbPostCreate(Long numDocumentoContableInterno, Long zona, Long sugerenciaVenta, Long seccion, Long region, Long territorio, Long empresa, Long formaPagoCabecera, Long clienteDirecion, Long pais, Long periodo, Long subacceso, Long solicitudCabecera, Long formulario, Long moneda, Long tipoDocumento, Timestamp fechaEmision, Timestamp fechaFacturacion, Boolean status, String puntoEmision, String ejercicioDocumentoInterno, String numIdentificacionFiscal, String numIdentificacionNacional, String observaciones, String nombre1, String nombre2, String apellido1, String apellido2, String serieDocumentolegal, Integer numeroAbono, Long numeroDocumentoLegal, Integer unidadesAtendidasTotal, BigDecimal precioCatalogoTotalDocumento, BigDecimal precioCatalogoSinImpuestoTotalDocumento, BigDecimal precioContableTotalDocumento, BigDecimal precioContableSinImpuestoTotalDocumento, BigDecimal importeDescuento1TotalDocumento, BigDecimal importeDescuento1SinImpuestosTotalDocumento, BigDecimal importeDescuento3SinImpuestoTotalDocumento, BigDecimal importeDescuentoTotalDocumento, BigDecimal precioFacturaTotalDocumento, BigDecimal importeImpuestosTotalDocumento, BigDecimal precioTotalTotalDocumento, Boolean indicadorImpresion, Long numeroDocumentoOrigen, String tipoDireccion, String almacen, BigDecimal precioCatalogoSinImpuestoTotalLocal, BigDecimal precioContableSinImpuestosTotalLocal, BigDecimal precioCatalogoTotalLocal, BigDecimal precioCatalogoTotalLocalUnidadesPorAtender, BigDecimal precioContableTotalLocal, BigDecimal importeDescuento1TotalLocal, BigDecimal importeDescuento1SinImpuestosTotalLocal, BigDecimal precioFacturaTotalLocal, BigDecimal precioTotalTotalLocal, BigDecimal importeDescuento3SinImpuestosTotalLocal, BigDecimal importeDescuentoTotalLocal, BigDecimal precioNetoTotalLocal, BigDecimal importeImpuestosTotalLocal, BigDecimal totalAPagarLocal, BigDecimal totalAPagarDocumento, BigDecimal importeRedondeoLocal, BigDecimal importeRedondeoConsolidadoLocal, BigDecimal tipoCambio, BigDecimal importeFleteTotalLocal, BigDecimal importeFleteTotalDocumento, BigDecimal importeDescuento3TotalLocal, BigDecimal importeDescuento3TotalDocumento, BigDecimal precioNetoTotalDocumento, BigDecimal importeFleteSinImpuestosTotalDocumento, BigDecimal importeRedondeoConsolidadoDocumento, BigDecimal importeRedondeoDocumento, Date fechaContabilizacion, String numeroLoteContablilizacion, BigDecimal importeFleteSinImpuestosTotalLocal, String direccionCompleta
	) throws  CreateException, DuplicateKeyException{
	}


	public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException {

		Vector parametros = new Vector();
		String consulta = "SELECT OID_CABE FROM FAC_DOCUM_CONTA_CABEC  " +
							"WHERE OID_CABE = ?";

		parametros.add(primaryKey);

		BelcorpService bs;
		RecordSet resultado;

		try {
            loguearSql("**** BMP  CabeceraDocumentoContable: ", consulta.toString(), parametros);
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

		Vector params = new Vector();                                                                                  
                                                                                                               
		String consulta  = "SELECT * FROM FAC_DOCUM_CONTA_CABEC WHERE OID_CABE  = ?";                                
		params.add((Long)context.getPrimaryKey());                                                                     
                                                                                                               
		RecordSet respuesta;                                                                                           
		BelcorpService bs;                                                                                             
                                                                                                               
		try {
            loguearSql("**** BMP  CabeceraDocumentoContable: ", consulta.toString(), params);                                                                                                          
			respuesta = this.ejecutaConsulta(consulta, params);                                                        
		} catch (Exception exception) {                                                                                
			 throw new EJBException(exception);                                                                         
		}                                                                                                              
                                                                                                               
		if (!respuesta.esVacio()) {                                                                                    
			// Al oid le damos la primary key, esto es obligatorio hacerlo, pues                                       
			// si venimos de un findby, el oid no se cargaría                                                          
			this.setOid((Long)context.getPrimaryKey()); 
			
			this.setNumDocumentoContableInterno( new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_DOCU_CONT_INTE")).longValue()));
			this.setZona(new Long(((BigDecimal)respuesta.getValueAt(0, "ZZON_OID_ZONA")).longValue()));
			this.setSugerenciaVenta(new Long(((BigDecimal)respuesta.getValueAt(0, "ZSGV_OID_SUBG_VENT")).longValue()));
			this.setSeccion(new Long(((BigDecimal)respuesta.getValueAt(0, "ZSCC_OID_SECC")).longValue()));
			this.setRegion(new Long(((BigDecimal)respuesta.getValueAt(0, "ZORG_OID_REGI")).longValue()));
			this.setTerritorio(new Long(((BigDecimal)respuesta.getValueAt(0, "TERR_OID_TERR")).longValue()));
			this.setEmpresa(new Long(((BigDecimal)respuesta.getValueAt(0, "SOCI_OID_SOCI")).longValue()));
			this.setFormaPagoCabecera(new Long(((BigDecimal)respuesta.getValueAt(0, "FOPA_OID_FORM_PAGO")).longValue()));
			this.setClienteDirecion(new Long(((BigDecimal)respuesta.getValueAt(0, "CLDI_OID_CLIE_DIRE")).longValue()));
			this.setPais(new Long(((BigDecimal)respuesta.getValueAt(0, "PAIS_OID_PAIS")).longValue()));
			this.setPeriodo(new Long(((BigDecimal)respuesta.getValueAt(0, "PERD_OID_PERI")).longValue()));
			this.setSubacceso(new Long(((BigDecimal)respuesta.getValueAt(0, "SBAC_OID_SBAC")).longValue()));
			this.setSolicitudCabecera(new Long(((BigDecimal)respuesta.getValueAt(0, "SOCA_OID_SOLI_CABE")).longValue()));
			this.setFormulario(new Long(((BigDecimal)respuesta.getValueAt(0, "FORS_OID_FORM")).longValue()));
			
			this.setTipoDocumento(new Long(((BigDecimal)respuesta.getValueAt(0, "TIDO_OID_TIPO_DOCU")).longValue()));

			this.setFechaEmision(new Timestamp(((Date)respuesta.getValueAt(0, "FEC_EMIS")).getTime()) );
			this.setFechaFacturacion(new Timestamp(((Date)respuesta.getValueAt(0, "FEC_FACT")).getTime()) );
			
			this.setStatus(new Boolean(((BigDecimal)respuesta.getValueAt(0, "VAL_ESTA" )).intValue() == 1 ? true : false));
			
			this.setEjercicioDocumentoInterno((String)respuesta.getValueAt(0, "VAL_EJER_DOCU_INTE"));

            // nombre1, nombre2, apellido1, apellido2 son nulables. En los casos en los que venga nulo
            // insertaremos cadena vacía
        	this.setNombre1(respuesta.getValueAt(0, "VAL_NOM1")!=null?(String)respuesta.getValueAt(0, "VAL_NOM1"):"");
			this.setNombre2(respuesta.getValueAt(0, "VAL_NOM2")!=null?(String)respuesta.getValueAt(0, "VAL_NOM2"):"");
			this.setApellido1(respuesta.getValueAt(0, "VAL_APE1")!=null?(String)respuesta.getValueAt(0, "VAL_APE1"):"");
			this.setApellido2(respuesta.getValueAt(0, "VAL_APE2")!=null?(String)respuesta.getValueAt(0, "VAL_APE2"):"");

			//Campos nulables
			this.setMoneda(respuesta.getValueAt(0, "MONE_OID_MONE")!=null? new Long(((BigDecimal)respuesta.getValueAt(0, "MONE_OID_MONE")).longValue()):null);
			this.setSerieDocumentolegal(respuesta.getValueAt(0,"VAL_SERI_DOCU_LEGA") != null ? (String)respuesta.getValueAt(0,"VAL_SERI_DOCU_LEGA") : null );
			this.setNumeroAbono(respuesta.getValueAt(0,"NUM_ABON") != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_ABON")).intValue()) : null);
			this.setNumeroDocumentoLegal(respuesta.getValueAt(0,"NUM_DOCU_LEGA") != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_DOCU_LEGA")).longValue()) : null);
			//añadidos por incidencia 10073		
			this.setUnidadesAtendidasTotal(respuesta.getValueAt(0,"NUM_UNID_ATEN_TOTA") != null ? new Integer(((BigDecimal)respuesta.getValueAt(0, "NUM_UNID_ATEN_TOTA")).intValue()) : null);
			this.setPrecioCatalogoTotalDocumento(respuesta.getValueAt(0,"VAL_PREC_CATA_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CATA_TOTA_DOCU") : null );
			this.setPrecioCatalogoSinImpuestoTotalDocumento(respuesta.getValueAt(0,"VAL_PREC_CATA_SIN_IMPU_TOTA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CATA_SIN_IMPU_TOTA") : null );
			this.setPrecioContableTotalDocumento(respuesta.getValueAt(0,"VAL_PREC_CONT_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CONT_TOTA_DOCU") : null );
			this.setPrecioContableSinImpuestoTotalDocumento(respuesta.getValueAt(0,"VAL_PREC_CONT_SIN_IMPU_TOTA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CONT_SIN_IMPU_TOTA") : null );
			this.setImporteDescuento1TotalDocumento(respuesta.getValueAt(0,"IMP_DES1_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES1_TOTA_DOCU") : null );
			this.setImporteDescuento1SinImpuestosTotalDocumento(respuesta.getValueAt(0,"IMP_DES1_SIN_IMPU_TOTA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES1_SIN_IMPU_TOTA") : null );
			this.setImporteDescuento3SinImpuestoTotalDocumento(respuesta.getValueAt(0,"IMP_DES3_SIN_IMPU_TOTA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES3_SIN_IMPU_TOTA") : null );
			this.setImporteDescuentoTotalDocumento(respuesta.getValueAt(0,"IMP_DESC_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DESC_TOTA_DOCU") : null );
			this.setPrecioFacturaTotalDocumento(respuesta.getValueAt(0,"VAL_PREC_FACT_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_FACT_TOTA_DOCU") : null );
			this.setImporteImpuestosTotalDocumento(respuesta.getValueAt(0,"IMP_IMPU_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_IMPU_TOTA_DOCU") : null );
			this.setPrecioTotalTotalDocumento(respuesta.getValueAt(0,"VAL_PREC_TOTA_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_TOTA_TOTA_DOCU") : null );
			//Pasan a ser nullables. Incidencia 10104
			this.setObservaciones(respuesta.getValueAt(0, "VAL_OBSE") != null ? (String)respuesta.getValueAt(0, "VAL_OBSE") : null);
			this.setPuntoEmision(respuesta.getValueAt(0, "VAL_PUNT_EMIS") != null ? (String)respuesta.getValueAt(0, "VAL_PUNT_EMIS") : null);
			this.setNumIdentificacionNacional(respuesta.getValueAt(0, "VAL_NUME_IDEN_NNAL") != null ? (String)respuesta.getValueAt(0, "VAL_NUME_IDEN_NNAL") : null);
			this.setNumIdentificacionFiscal(respuesta.getValueAt(0, "VAL_NUME_IDEN_FISC") != null ? (String)respuesta.getValueAt(0, "VAL_NUME_IDEN_FISC") : null);

			//Añadidos por la incidencia BEL 012285
            if(((BigDecimal)respuesta.getValueAt(0,"IND_IMPR"))!=null){
				      this.setIndicadorImpresion(new Boolean(((BigDecimal)respuesta.getValueAt(0, "IND_IMPR" )).intValue() == 1 ? true : false));
			}
            //Boolean
            this.setNumeroDocumentoOrigen(respuesta.getValueAt(0, "NUM_DOCU_ORIG")!=null? new Long(((BigDecimal)respuesta.getValueAt(0, "NUM_DOCU_ORIG")).longValue()):null);
            //String
            this.setTipoDireccion(respuesta.getValueAt(0, "VAL_TIPO_DIRE")!=null ? (String)respuesta.getValueAt(0, "VAL_TIPO_DIRE"): null);
            this.setAlmacen(respuesta.getValueAt(0, "VAL_ALMA")!=null  ? respuesta.getValueAt(0, "VAL_ALMA").toString() : null);
            //BigDecimal
            this.setPrecioCatalogoSinImpuestoTotalLocal(respuesta.getValueAt(0,"VAL_PREC_CATA_IMPU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CATA_IMPU") : null );
            this.setPrecioContableSinImpuestosTotalLocal(respuesta.getValueAt(0,"VAL_PREC_CONT_IMPU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CONT_IMPU") : null );
            this.setPrecioCatalogoTotalLocal(respuesta.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA") : null );
            this.setPrecioCatalogoTotalLocalUnidadesPorAtender(respuesta.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA_UNID") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA_UNID") : null );
            this.setPrecioContableTotalLocal(respuesta.getValueAt(0,"VAL_PREC_CONT_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_CONT_TOTA_LOCA") : null );
            this.setImporteDescuento1TotalLocal(respuesta.getValueAt(0,"IMP_DES1_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES1_TOTA_LOCA") : null );
            this.setImporteDescuento1SinImpuestosTotalLocal(respuesta.getValueAt(0,"IMP_DES1_IMPU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES1_IMPU") : null );
            this.setPrecioFacturaTotalLocal(respuesta.getValueAt(0,"VAL_PREC_FACT_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_FACT_TOTA_LOCA") : null );
            this.setPrecioTotalTotalLocal(respuesta.getValueAt(0,"VAL_PREC_TOTA_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_TOTA_TOTA_LOCA") : null );
            this.setImporteDescuento3SinImpuestosTotalLocal(respuesta.getValueAt(0,"IMP_DES3_IMPU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES3_IMPU") : null );
            this.setImporteDescuentoTotalLocal(respuesta.getValueAt(0,"IMP_DESC_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DESC_TOTA_LOCA") : null );
            this.setPrecioNetoTotalLocal(respuesta.getValueAt(0,"VAL_PREC_NETO_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_NETO_TOTA_LOCA") : null );
            this.setImporteImpuestosTotalLocal(respuesta.getValueAt(0,"IMP_IMPU_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_IMPU_TOTA_LOCA") : null );
            this.setTotalAPagarLocal(respuesta.getValueAt(0,"VAL_TOTA_PAGA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_TOTA_PAGA_LOCA") : null );
            this.setTotalAPagarDocumento(respuesta.getValueAt(0,"VAL_TOTA_PAGA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_TOTA_PAGA_DOCU") : null );
            this.setImporteRedondeoLocal(respuesta.getValueAt(0,"IMP_REDO_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_REDO_LOCA") : null );
            this.setImporteRedondeoConsolidadoLocal(respuesta.getValueAt(0,"IMP_REDO_CONS_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_REDO_CONS_LOCA") : null );
            this.setTipoCambio(respuesta.getValueAt(0,"VAL_TIPO_CAMB") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_TIPO_CAMB") : null );
            this.setImporteFleteTotalLocal(respuesta.getValueAt(0,"IMP_FLET_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_FLET_TOTA_LOCA") : null );
            this.setImporteFleteTotalDocumento(respuesta.getValueAt(0,"IMP_FLET_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_FLET_TOTA_DOCU") : null );
            this.setImporteDescuento3TotalLocal(respuesta.getValueAt(0,"IMP_DES3_TOTAL_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES3_TOTAL_LOCA") : null );
            this.setImporteDescuento3TotalDocumento(respuesta.getValueAt(0,"IMP_DES3_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_DES3_TOTA_DOCU") : null );
            this.setPrecioNetoTotalDocumento(respuesta.getValueAt(0,"VAL_PREC_NETO_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"VAL_PREC_NETO_TOTA_DOCU") : null );
            this.setImporteFleteSinImpuestosTotalDocumento(respuesta.getValueAt(0,"IMP_FLET_SIN_IMPU_TOTA_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_FLET_SIN_IMPU_TOTA_DOCU") : null );
            this.setImporteRedondeoConsolidadoDocumento(respuesta.getValueAt(0,"IMP_REDO_CONS_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_REDO_CONS_DOCU") : null );
            this.setImporteRedondeoDocumento(respuesta.getValueAt(0,"IMP_REDO_DOCU") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_REDO_DOCU") : null );

            // Añadido por la BELC300013384
            this.setNumeroLoteContabilizacion(respuesta.getValueAt(0,"NUM_LOTE_CONT ") != null ? (String)respuesta.getValueAt(0,"NUM_LOTE_CONT") : null );
            this.setFechaContabilizacion(respuesta.getValueAt(0,"FEC_CONT") != null ? (Date)respuesta.getValueAt(0,"FEC_CONT") : null );
            this.setImporteFleteSinImpuestosTotalLocal(respuesta.getValueAt(0,"IMP_FLET_IMPU_TOTA_LOCA") != null ? (BigDecimal)respuesta.getValueAt(0,"IMP_FLET_IMPU_TOTA_LOCA") : null);
            
            //añadido por incidencia 21005
            // insertaremos cadena vacía
            this.setDireccionCompleta(respuesta.getValueAt(0, "VAL_DIRE_COMP")!=null?(String)respuesta.getValueAt(0,"VAL_DIRE_COMP"):"");
		}//if !respuesta.esVacio
	}//Metodo EJbLoad

	public void ejbPassivate() {
	}

	public void ejbRemove() {
		Vector param = new Vector();		
        String consulta = "DELETE FROM FAC_DOCUM_CONTA_CABEC WHERE OID_CABE = ?";
        param.add((Long)context.getPrimaryKey());

        BelcorpService bs;
        
        try {
            loguearSql("**** BMP  CabeceraDocumentoContable: ", consulta.toString(), param);
			ejecutaSentencia(consulta, param);
        } catch (Exception exception) {
			throw new EJBException(exception);
        }
	
	}

	public void ejbStore() {

		Vector params = new Vector();
		StringBuffer consulta = new StringBuffer("");

		consulta.append("UPDATE FAC_DOCUM_CONTA_CABEC SET ");//EL iod no se pone
		
		consulta.append(" NUM_DOCU_CONT_INTE = ?, ");
		params.add(this.getNumDocumentoContableInterno());
		consulta.append(" ZZON_OID_ZONA = ? ");
		params.add(this.getZona());
		consulta.append(" , ZSGV_OID_SUBG_VENT = ? ");
		params.add(this.getSugerenciaVenta());
		consulta.append(" , ZSCC_OID_SECC = ? ");
		params.add(this.getSeccion());
		consulta.append(" , ZORG_OID_REGI= ? ");
		params.add(this.getRegion());
		consulta.append(" , TERR_OID_TERR= ? ");
		params.add(this.getTerritorio());
		consulta.append(" , SOCI_OID_SOCI= ? ");
		params.add(this.getEmpresa());
		consulta.append(" , FOPA_OID_FORM_PAGO= ? ");
		params.add(this.getFormaPagoCabecera());
		consulta.append(" , CLDI_OID_CLIE_DIRE= ? ");
		params.add(this.getClienteDirecion());
		consulta.append(" , PAIS_OID_PAIS= ? ");
		params.add(this.getPais());
		consulta.append(" , PERD_OID_PERI= ? ");
		params.add(this.getPeriodo());
		consulta.append(" , SBAC_OID_SBAC= ? ");
		params.add(this.getSubacceso());
		consulta.append(" , SOCA_OID_SOLI_CABE= ? ");
		params.add(this.getSolicitudCabecera());
		consulta.append(" , FORS_OID_FORM= ? ");
		params.add(this.getFormulario());


		consulta.append(" , TIDO_OID_TIPO_DOCU= ? ");
		params.add(this.getTipoDocumento());

		
		
		consulta.append(" , FEC_EMIS = ? ");
		params.add(this.getFechaEmision());
		consulta.append(" , FEC_FACT= ? ");
		params.add(this.getFechaFacturacion());
		consulta.append(" , VAL_ESTA= ? ");
		params.add(this.getStatus());

		consulta.append(" , VAL_EJER_DOCU_INTE= ? ");
		params.add(this.getEjercicioDocumentoInterno());

        // nombre1, nombre2, apellido1, apellido2 son nulables. En los casos en los que venga nulo
        // insertaremos cadena vacía
		consulta.append(" , VAL_NOM1 = ? ");
		params.add(this.getNombre1()!=null?this.getNombre1():"");
		consulta.append(" , VAL_NOM2= ? ");
		params.add(this.getNombre2()!=null?this.getNombre2():"");
		consulta.append(" , VAL_APE1= ? ");
		params.add(this.getApellido1()!=null?this.getApellido1():"");
		consulta.append(" , VAL_APE2= ? ");
		params.add(this.getApellido2()!=null?this.getApellido2():"");
/*		 VAL_SERI_DOCU_LEGA
		 NUM_ABON
		 NUM_DOCU_LEGA*/
		// campos nulables
		if(this.getMoneda()!= null){
			consulta.append(" , MONE_OID_MONE = ? ");
			params.add(this.getMoneda());
			
		}else{
			consulta.append(" , MONE_OID_MONE = null ");
		}

		if (this.getSerieDocumentolegal() != null) {
			consulta.append(", VAL_SERI_DOCU_LEGA = ? ");
			params.add(this.getSerieDocumentolegal());
		} else {
			consulta.append(", VAL_SERI_DOCU_LEGA = null ");
		}
		if (this.getNumeroAbono() != null) {
			consulta.append(", NUM_ABON = ? ");
			params.add(this.getNumeroAbono());
		} else {
			consulta.append(", NUM_ABON = null ");
		}
		if (this.getNumeroDocumentoLegal() != null) {
			consulta.append(", NUM_DOCU_LEGA = ? ");
			params.add(this.getNumeroDocumentoLegal());
		} else {
			consulta.append(", NUM_DOCU_LEGA = null ");
		}
		//Añadidos por la incidencia 10073
		if(this.getUnidadesAtendidasTotal() != null){
			consulta.append(", NUM_UNID_ATEN_TOTA = ? ");
			params.add(this.getUnidadesAtendidasTotal());
		} else{
			consulta.append(", NUM_UNID_ATEN_TOTA = null ");
		}
		if(this.getPrecioCatalogoTotalDocumento() != null){
			consulta.append(", VAL_PREC_CATA_TOTA_DOCU = ? ");
			params.add(this.getPrecioCatalogoTotalDocumento());
		} else{
			consulta.append(", VAL_PREC_CATA_TOTA_DOCU = null ");
		}
		if(this.getPrecioCatalogoSinImpuestoTotalDocumento() != null){
			consulta.append(", VAL_PREC_CATA_SIN_IMPU_TOTA = ? ");
			params.add(this.getPrecioCatalogoSinImpuestoTotalDocumento());
		} else{
			consulta.append(", VAL_PREC_CATA_SIN_IMPU_TOTA = null ");
		}
		if(this.getPrecioContableTotalDocumento() != null){
			consulta.append(", VAL_PREC_CONT_TOTA_DOCU = ? ");
			params.add(this.getPrecioContableTotalDocumento());
		} else{
			consulta.append(", VAL_PREC_CONT_TOTA_DOCU = null ");
		}
		if(this.getPrecioContableSinImpuestoTotalDocumento() != null){
			consulta.append(", VAL_PREC_CONT_SIN_IMPU_TOTA = ? ");
			params.add(this.getPrecioContableSinImpuestoTotalDocumento());
		} else{
			consulta.append(", VAL_PREC_CONT_SIN_IMPU_TOTA = null ");
		}
		if(this.getImporteDescuento1TotalDocumento() != null){
			consulta.append(", IMP_DES1_TOTA_DOCU = ? ");
			params.add(this.getImporteDescuento1TotalDocumento());
		} else{
			consulta.append(", IMP_DES1_TOTA_DOCU = null ");
		}
		if(this.getImporteDescuento1SinImpuestosTotalDocumento() != null){
			consulta.append(", IMP_DES1_SIN_IMPU_TOTA = ? ");
			params.add(this.getImporteDescuento1SinImpuestosTotalDocumento());
		} else{
			consulta.append(", IMP_DES1_SIN_IMPU_TOTA = null ");
		}
		if(this.getImporteDescuento3SinImpuestoTotalDocumento() != null){
			consulta.append(", IMP_DES3_SIN_IMPU_TOTA = ? ");
			params.add(this.getImporteDescuento3SinImpuestoTotalDocumento());
		} else{
			consulta.append(", IMP_DES3_SIN_IMPU_TOTA = null ");
		}
		if(this.getImporteDescuentoTotalDocumento() != null){
			consulta.append(", IMP_DESC_TOTA_DOCU = ? ");
			params.add(this.getImporteDescuentoTotalDocumento());
		} else{
			consulta.append(", IMP_DESC_TOTA_DOCU = null ");
		}
		if(this.getPrecioFacturaTotalDocumento() != null){
			consulta.append(", VAL_PREC_FACT_TOTA_DOCU = ? ");
			params.add(this.getPrecioFacturaTotalDocumento());
		} else{
			consulta.append(", VAL_PREC_FACT_TOTA_DOCU = null ");
		}
		if(this.getImporteImpuestosTotalDocumento() != null){
			consulta.append(", IMP_IMPU_TOTA_DOCU = ? ");
			params.add(this.getImporteImpuestosTotalDocumento());
		} else{
			consulta.append(", IMP_IMPU_TOTA_DOCU = null ");
		}
		if(this.getPrecioTotalTotalDocumento() != null){
			consulta.append(", VAL_PREC_TOTA_TOTA_DOCU = ? ");
			params.add(this.getPrecioTotalTotalDocumento());
		} else{
			consulta.append(", VAL_PREC_TOTA_TOTA_DOCU = null ");
		}
		//pasan a ser nullables. Incidencia 10104
		if(this.getObservaciones() != null){
			consulta.append(", VAL_OBSE= ? ");
			params.add(this.getObservaciones());
		} else{
			consulta.append(", VAL_OBSE= null ");
		}
		if(this.getPuntoEmision() != null){
			consulta.append(", VAL_PUNT_EMIS= ? ");
			params.add(this.getPuntoEmision());
		} else{
			consulta.append(", VAL_PUNT_EMIS= null ");
		}
		if(this.getNumIdentificacionNacional() != null){
			consulta.append(",  VAL_NUME_IDEN_NNAL= ? ");
			params.add(this.getNumIdentificacionNacional());
		} else{
			consulta.append(", VAL_NUME_IDEN_NNAL= null ");
		}
		if(this.getNumIdentificacionFiscal() != null){
			consulta.append(", VAL_NUME_IDEN_FISC= ? ");
			params.add(this.getNumIdentificacionFiscal());
		} else{
			consulta.append(", VAL_NUME_IDEN_FISC= null ");
		}
        
       
       if(this.getIndicadorImpresion() != null){
			consulta.append(", IND_IMPR= ? ");
			params.add(this.getIndicadorImpresion());
		} else{
			consulta.append(", IND_IMPR= null ");
            
		}
        
         if(this.getNumeroDocumentoOrigen() != null){
			consulta.append(", NUM_DOCU_ORIG= ? ");
			params.add(this.getNumeroDocumentoOrigen());
		} else{
			consulta.append(", NUM_DOCU_ORIG= null ");
            
		}
        
         if(this.getTipoDireccion() != null){
			consulta.append(", VAL_TIPO_DIRE= ? ");
			params.add(this.getTipoDireccion());
		} else{
			consulta.append(", VAL_TIPO_DIRE= null ");
            
		}
        if(this.getAlmacen() != null){
			consulta.append(", VAL_ALMA= ? ");
			params.add(this.getAlmacen());
		} else{
			consulta.append(", VAL_ALMA= null ");
            
		}
       
        
         if(this.getPrecioCatalogoSinImpuestoTotalLocal() != null){
			consulta.append(", VAL_PREC_CATA_IMPU= ? ");
			params.add(this.getPrecioCatalogoSinImpuestoTotalLocal());
		} else{
			consulta.append(", VAL_PREC_CATA_IMPU= null ");
            
		}
         if(this.getPrecioContableSinImpuestosTotalLocal() != null){
			consulta.append(", VAL_PREC_CONT_IMPU= ? ");
			params.add(this.getPrecioContableSinImpuestosTotalLocal());
		} else{
			consulta.append(", VAL_PREC_CONT_IMPU= null ");
            
		}
        
         if(this.getPrecioCatalogoTotalLocal() != null){
			consulta.append(", VAL_PREC_CATA_TOTA_LOCA= ? ");
			params.add(this.getPrecioCatalogoTotalLocal());
		} else{
			consulta.append(", VAL_PREC_CATA_TOTA_LOCA= null ");
            
		}
         if(this.getPrecioCatalogoTotalLocalUnidadesPorAtender() != null){
			consulta.append(", VAL_PREC_CATA_TOTA_LOCA_UNID= ? ");
			params.add(this.getPrecioCatalogoTotalLocalUnidadesPorAtender());
		} else{
			consulta.append(", VAL_PREC_CATA_TOTA_LOCA_UNID= null ");
            
		}
         if(this.getPrecioContableTotalLocal() != null){
			consulta.append(", VAL_PREC_CONT_TOTA_LOCA= ? ");
			params.add(this.getPrecioContableTotalLocal());
		} else{
			consulta.append(", VAL_PREC_CONT_TOTA_LOCA = null ");
            
		}
          if(this.getImporteDescuento1TotalLocal() != null){
			consulta.append(", IMP_DES1_TOTA_LOCA= ? ");
			params.add(this.getImporteDescuento1TotalLocal());
		} else{
			consulta.append(", IMP_DES1_TOTA_LOCA = null ");
            
		}
         if(this.getImporteDescuento1SinImpuestosTotalLocal() != null){
			consulta.append(", IMP_DES1_IMPU= ? ");
			params.add(this.getImporteDescuento1SinImpuestosTotalLocal());
		} else{
			consulta.append(", IMP_DES1_IMPU = null ");
            
		}
        
         if(this.getPrecioFacturaTotalLocal() != null){
			consulta.append(", VAL_PREC_FACT_TOTA_LOCA= ? ");
			params.add(this.getPrecioFacturaTotalLocal());
		} else{
			consulta.append(", VAL_PREC_FACT_TOTA_LOCA = null ");
            
		}
        if(this.getPrecioTotalTotalLocal() != null){
			consulta.append(", VAL_PREC_TOTA_TOTA_LOCA= ? ");
			params.add(this.getPrecioTotalTotalLocal());
		} else{
			consulta.append(", VAL_PREC_TOTA_TOTA_LOCA = null ");
            
		}
          if(this.getImporteDescuento3SinImpuestosTotalLocal() != null){
			consulta.append(", IMP_DES3_IMPU= ? ");
			params.add(this.getImporteDescuento3SinImpuestosTotalLocal());
		} else{
			consulta.append(", IMP_DES3_IMPU = null ");
            
		}
         if(this.getImporteDescuentoTotalLocal() != null){
			consulta.append(", IMP_DESC_TOTA_LOCA= ? ");
			params.add(this.getImporteDescuentoTotalLocal());
		} else{
			consulta.append(", IMP_DESC_TOTA_LOCA = null ");
            
		}
        
          if(this.getPrecioNetoTotalLocal() != null){
			consulta.append(", VAL_PREC_NETO_TOTA_LOCA= ? ");
			params.add(this.getPrecioNetoTotalLocal());
		} else{
			consulta.append(", VAL_PREC_NETO_TOTA_LOCA = null ");
            
		}
         if(this.getImporteImpuestosTotalLocal() != null){
			consulta.append(", IMP_IMPU_TOTA_LOCA= ? ");
			params.add(this.getImporteImpuestosTotalLocal());
		} else{
			consulta.append(", IMP_IMPU_TOTA_LOCA = null ");
            
		}
        if(this.getTotalAPagarLocal() != null){
			consulta.append(", VAL_TOTA_PAGA_LOCA= ? ");
			params.add(this.getTotalAPagarLocal());
		} else{
			consulta.append(", VAL_TOTA_PAGA_LOCA = null ");
            
		}
        if(this.getTotalAPagarDocumento() != null){
			consulta.append(", VAL_TOTA_PAGA_DOCU= ? ");
			params.add(this.getTotalAPagarDocumento());
		} else{
			consulta.append(", VAL_TOTA_PAGA_DOCU = null ");
            
		}
         if(this.getImporteRedondeoLocal() != null){
			consulta.append(", IMP_REDO_LOCA= ? ");
			params.add(this.getImporteRedondeoLocal());
		} else{
			consulta.append(", IMP_REDO_LOCA = null ");
            
		}
         if(this.getImporteRedondeoConsolidadoLocal() != null){
			consulta.append(", IMP_REDO_CONS_LOCA= ? ");
			params.add(this.getImporteRedondeoConsolidadoLocal());
		} else{
			consulta.append(", IMP_REDO_CONS_LOCA = null ");
            
		}
         if(this.getTipoCambio() != null){
			consulta.append(", VAL_TIPO_CAMB= ? ");
			params.add(this.getTipoCambio());
		} else{
			consulta.append(", VAL_TIPO_CAMB = null ");
            
		}
         if(this.getImporteFleteTotalLocal() != null){
			consulta.append(", IMP_FLET_TOTA_LOCA= ? ");
			params.add(this.getImporteFleteTotalLocal());
		} else{
			consulta.append(", IMP_FLET_TOTA_LOCA = null ");
            
		}
         if(this.getImporteFleteTotalDocumento() != null){
			consulta.append(", IMP_FLET_TOTA_DOCU= ? ");
			params.add(this.getImporteFleteTotalDocumento());
		} else{
			consulta.append(", IMP_FLET_TOTA_DOCU = null ");
            
		}
         if(this.getImporteDescuento3TotalLocal() != null){
			consulta.append(", IMP_DES3_TOTAL_LOCA= ? ");
			params.add(this.getImporteDescuento3TotalLocal());
		} else{
			consulta.append(", IMP_DES3_TOTAL_LOCA = null ");
            
		}
         if(this.getImporteDescuento3TotalDocumento() != null){
			consulta.append(", IMP_DES3_TOTA_DOCU= ? ");
			params.add(this.getImporteDescuento3TotalDocumento());
		} else{
			consulta.append(", IMP_DES3_TOTA_DOCU = null ");
            
		}
        
        if(this.getPrecioNetoTotalDocumento() != null){
			consulta.append(", VAL_PREC_NETO_TOTA_DOCU= ? ");
			params.add(this.getPrecioNetoTotalDocumento());
		} else{
			consulta.append(", VAL_PREC_NETO_TOTA_DOCU = null ");
            
		}
        if(this.getImporteFleteSinImpuestosTotalDocumento() != null){
			consulta.append(", IMP_FLET_SIN_IMPU_TOTA_DOCU= ? ");
			params.add(this.getImporteFleteSinImpuestosTotalDocumento());
		} else{
			consulta.append(", IMP_FLET_SIN_IMPU_TOTA_DOCU = null ");
                       
		}
        if(this.getImporteRedondeoConsolidadoDocumento() != null){
			consulta.append(", IMP_REDO_CONS_DOCU= ? ");
			params.add(this.getImporteRedondeoConsolidadoDocumento());
		} else{
			consulta.append(", IMP_REDO_CONS_DOCU = null ");
                       
		}
         if(this.getImporteRedondeoDocumento() != null){
			consulta.append(", IMP_REDO_DOCU= ? ");
			params.add(this.getImporteRedondeoDocumento());
		} else{
			consulta.append(", IMP_REDO_DOCU = null ");
                       
		}
        
        // Incidencia BELC300013384
        if(this.getNumeroLoteContabilizacion() != null){
			consulta.append(", NUM_LOTE_CONT= ? ");
			params.add(this.getNumeroLoteContabilizacion());
		} else{
			consulta.append(", NUM_LOTE_CONT = null ");
		}
        if(this.getFechaContabilizacion() != null){
			consulta.append(", FEC_CONT= ? ");
			params.add(this.getFechaContabilizacion());
		} else{
			consulta.append(", FEC_CONT = null ");
		}
        if(this.getImporteFleteSinImpuestosTotalLocal() != null){
            consulta.append(", IMP_FLET_IMPU_TOTA_LOCA = ? ");
            params.add(this.getImporteFleteSinImpuestosTotalLocal());
        }else{
            consulta.append (", IMP_FLET_IMPU_TOTA_LOCA = null ");
        }
        
        //añadido por incidencia 21005
        // insertaremos cadena vacía
        consulta.append(" , VAL_DIRE_COMP = ? ");
        params.add(this.getDireccionCompleta()!=null?this.getDireccionCompleta():"");
		
		consulta.append("WHERE OID_CABE = ?");
        params.add((Long)context.getPrimaryKey());

        try {   
			this.ejecutaSentencia(consulta.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EJBException(e);
		}

	}//fin de metodo Store

	public void setEntityContext(EntityContext ctx) {
		this.context = ctx;
	}

	public void unsetEntityContext() {
		this.context = null;
	}

	public String getApellido1() {
		return apellido1;
	}

    // Si es nulo insertamos cadena vacía
	public void setApellido1(String newApellido1) {
		apellido1 = (newApellido1 != null?newApellido1:"");
	}

	public String getApellido2() {
		return apellido2;
	}

    // Si es nulo insertamos cadena vacía
	public void setApellido2(String newApellido2) {
		apellido2 = (newApellido2 != null?newApellido2:"");
	}

	public Long getClienteDirecion() {
		return clienteDirecion;
	}

	public void setClienteDirecion(Long newClienteDirecion) {
		clienteDirecion = newClienteDirecion;
	}

	public String getEjercicioDocumentoInterno() {
		return ejercicioDocumentoInterno;
	}

	public void setEjercicioDocumentoInterno(String newEjercicioDocumentoInterno) {
		ejercicioDocumentoInterno = newEjercicioDocumentoInterno;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		empresa = newEmpresa;
	}

	public Timestamp getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Timestamp newFechaEmision) {
		fechaEmision = newFechaEmision;
	}

	public Timestamp getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Timestamp newFechaFacturacion) {
		fechaFacturacion = newFechaFacturacion;
	}

	public Long getFormaPagoCabecera() {
		return formaPagoCabecera;
	}

	public void setFormaPagoCabecera(Long newFormaPagoCabecera) {
		formaPagoCabecera = newFormaPagoCabecera;
	}

	public Long getFormulario() {
		return formulario;
	}

	public void setFormulario(Long newFormulario) {
		formulario = newFormulario;
	}

	public Long getMoneda() {
		return moneda;
	}

	public void setMoneda(Long newMoneda) {
		moneda = newMoneda;
	}

	public String getNombre1() {
		return nombre1;
	}

    // No puede ser nulo. Si viene nulo, inserto cadena vacía
	public void setNombre1(String newNombre1) {
		nombre1 = (newNombre1 != null?newNombre1:"");
	}

	public String getNombre2() {
		return nombre2;
	}

    // No puede ser nulo. Si viene nulo, inserto cadena vacía
	public void setNombre2(String newNombre2) {
		nombre2 = (newNombre2 != null?newNombre2:"");
	}

	public Long getNumDocumentoContableInterno() {
		return numDocumentoContableInterno;
	}

	public void setNumDocumentoContableInterno(Long newNumDocumentoContableInterno) {
		numDocumentoContableInterno = newNumDocumentoContableInterno;
	}

	public String getNumIdentificacionFiscal() {
		return numIdentificacionFiscal;
	}

	public void setNumIdentificacionFiscal(String newNumIdentificacionFiscal) {
		numIdentificacionFiscal = newNumIdentificacionFiscal;
	}

	public String getNumIdentificacionNacional() {
		return numIdentificacionNacional;
	}

	public void setNumIdentificacionNacional(String newNumIdentificacionNacional) {
		numIdentificacionNacional = newNumIdentificacionNacional;
	}

	public Integer getNumeroAbono() {
		return numeroAbono;
	}

	public void setNumeroAbono(Integer newNumeroAbono) {
		numeroAbono = newNumeroAbono;
	}

	public Long getNumeroDocumentoLegal() {
		return numeroDocumentoLegal;
	}

	public void setNumeroDocumentoLegal(Long newNumeroDocumentoLegal) {
		numeroDocumentoLegal = newNumeroDocumentoLegal;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		observaciones = newObservaciones;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public String getPuntoEmision() {
		return puntoEmision;
	}

	public void setPuntoEmision(String newPuntoEmision) {
		puntoEmision = newPuntoEmision;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long newRegion) {
		region = newRegion;
	}

	public Long getSeccion() {
		return seccion;
	}

	public void setSeccion(Long newSeccion) {
		seccion = newSeccion;
	}

	public String getSerieDocumentolegal() {
		return serieDocumentolegal;
	}

	public void setSerieDocumentolegal(String newSerieDocumentolegal) {
		serieDocumentolegal = newSerieDocumentolegal;
	}

	public Long getSolicitudCabecera() {
		return solicitudCabecera;
	}

	public void setSolicitudCabecera(Long newSolicitudCabecera) {
		solicitudCabecera = newSolicitudCabecera;
	}

	//public Boolean getStatus() {
	//	return status;
	//}
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean newStatus) {
		status = newStatus;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Long getSugerenciaVenta() {
		return sugerenciaVenta;
	}

	public void setSugerenciaVenta(Long newSugerenciaVenta) {
		sugerenciaVenta = newSugerenciaVenta;
	}

	public Long getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Long newTerritorio) {
		territorio = newTerritorio;
	}

	public Long getZona() {
		return zona;
	}

	public void setZona(Long newZona) {
		zona = newZona;
	}
	public Long getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Long newTipoDocumento) {
		tipoDocumento = newTipoDocumento;
	}

	/** Metodo privado, para realizar consultas directas a la base por JDBC                                         
	* @param query sentencia SQL con la consulta                                                                   
	 * @param argumentos valores de los parametros de la consulta                                                   
	* @return RecordSet con la respuesta a la consulta realizada */                                                
	private int ejecutaSentencia(String query, Vector argumentos) throws EJBException {                                                                           
	                                                                                                             
		BelcorpService bs;                                                                                          
                                                                                                                
		try {                                                                                                       
		  bs = BelcorpService.getInstance();                                                                      
		} catch (MareMiiServiceNotFoundException e) {                                                               
		  throw new EJBException(e);                                                                              
		}                                                                                                           
		try {                                                                                                       
			//loguearSql("**** BMP  CabeceraDocumentoContable: ", query, argumentos);		                        
			return bs.dbService.executePreparedUpdate(query, argumentos);                                           
		} catch (Exception e) {                                                                                     
			e.printStackTrace();		
			throw new EJBException(e);                                                                              
		}                                                                                                           
	}                                                                                                               
                                                                                                                
	private void loguearSql(String metodo, String sql, Vector params) {                                             
                                                                                                                
		this.getLog().info(metodo + sql);                                                                           
                                                                                                                
		if (params != null && params.size() > 0) {                                                                  
			String sParams = "";                                                                                    
			for (int i=0; i<params.size(); i++) {                                                                   
				if (params.elementAt(i) != null)                                                                    
					sParams += "param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";                   
				else                                                                                                
					sParams += "param "+ (i+1) + ": es nulo, ";                                                     
			}                                                                                                       
			this.getLog().info(metodo + sParams);                                                                   
		}		                                                                                                    
	}	                                                                                                            
                                                                                                                
	private Log getLog() {                                                                                          
		Log log = null;                                                                                             
		try {                                                                                                       
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());            
		} catch (Exception e) {                                                                                     
			e.printStackTrace();                                                                                    
			//System.out.println ("No se pudo obtener el objeto Log");                                                
			throw new RuntimeException ("No se pudo obtener el objeto Log");                                        
		}                                                                                                           
	}	                                                                                                               
                                                                                                                
	/** Metodo privado, para realizar consultas directas a la base por JDBC                                         
	 * @param consulta sentencia SQL con la consulta                                                                
	 * @param argumentos valores de los parametros de la consulta                                                   
	 * @return RecordSet con la respuesta a la consulta realizada */                                                
	private RecordSet ejecutaConsulta(String consulta, Vector params) throws EJBException {                                                                
                                                                                                               
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
		//loguearSql("**** BMP CabeceraDocumentoContable: ", consulta, params);                                    
		return res;                                                                                                 
	}                                                                                                               


	public Integer getUnidadesAtendidasTotal() {
		return unidadesAtendidasTotal;
	}

	public void setUnidadesAtendidasTotal(Integer newUnidadesAtendidasTotal) {
		unidadesAtendidasTotal = newUnidadesAtendidasTotal;
	}

	public BigDecimal getPrecioCatalogoTotalDocumento() {
		return precioCatalogoTotalDocumento;
	}

	public void setPrecioCatalogoTotalDocumento(BigDecimal newPrecioCatalogoTotalDocumento) {
		precioCatalogoTotalDocumento = newPrecioCatalogoTotalDocumento;
	}

	public BigDecimal getPrecioCatalogoSinImpuestoTotalDocumento() {
		return precioCatalogoSinImpuestoTotalDocumento;
	}

	public void setPrecioCatalogoSinImpuestoTotalDocumento(BigDecimal newPrecioCatalogoSinImpuestoTotalDocumento) {
		precioCatalogoSinImpuestoTotalDocumento = newPrecioCatalogoSinImpuestoTotalDocumento;
	}

	public BigDecimal getPrecioContableTotalDocumento() {
		return precioContableTotalDocumento;
	}

	public void setPrecioContableTotalDocumento(BigDecimal newPrecioContableTotalDocumento) {
		precioContableTotalDocumento = newPrecioContableTotalDocumento;
	}

	public BigDecimal getPrecioContableSinImpuestoTotalDocumento() {
		return precioContableSinImpuestoTotalDocumento;
	}

	public void setPrecioContableSinImpuestoTotalDocumento(BigDecimal newPrecioContableSinImpuestoTotalDocumento) {
		precioContableSinImpuestoTotalDocumento = newPrecioContableSinImpuestoTotalDocumento;
	}

	public BigDecimal getImporteDescuento1TotalDocumento() {
		return importeDescuento1TotalDocumento;
	}

	public void setImporteDescuento1TotalDocumento(BigDecimal newImporteDescuento1TotalDocumento) {
		importeDescuento1TotalDocumento = newImporteDescuento1TotalDocumento;
	}

	public BigDecimal getImporteDescuento1SinImpuestosTotalDocumento() {
		return importeDescuento1SinImpuestosTotalDocumento;
	}

	public void setImporteDescuento1SinImpuestosTotalDocumento(BigDecimal newImporteDescuento1SinImpuestosTotalDocumento) {
		importeDescuento1SinImpuestosTotalDocumento = newImporteDescuento1SinImpuestosTotalDocumento;
	}

	public BigDecimal getImporteDescuento3SinImpuestoTotalDocumento() {
		return importeDescuento3SinImpuestoTotalDocumento;
	}

	public void setImporteDescuento3SinImpuestoTotalDocumento(BigDecimal newImporteDescuento3SinImpuestoTotalDocumento) {
		importeDescuento3SinImpuestoTotalDocumento = newImporteDescuento3SinImpuestoTotalDocumento;
	}

	public BigDecimal getImporteDescuentoTotalDocumento() {
		return importeDescuentoTotalDocumento;
	}

	public void setImporteDescuentoTotalDocumento(BigDecimal newImporteDescuentoTotalDocumento) {
		importeDescuentoTotalDocumento = newImporteDescuentoTotalDocumento;
	}

	public BigDecimal getPrecioFacturaTotalDocumento() {
		return precioFacturaTotalDocumento;
	}

	public void setPrecioFacturaTotalDocumento(BigDecimal newPrecioFacturaTotalDocumento) {
		precioFacturaTotalDocumento = newPrecioFacturaTotalDocumento;
	}

	public BigDecimal getImporteImpuestosTotalDocumento() {
		return importeImpuestosTotalDocumento;
	}

	public void setImporteImpuestosTotalDocumento(BigDecimal newImporteImpuestosTotalDocumento) {
		importeImpuestosTotalDocumento = newImporteImpuestosTotalDocumento;
	}

	public BigDecimal getPrecioTotalTotalDocumento() {
		return precioTotalTotalDocumento;
	}

	public void setPrecioTotalTotalDocumento(BigDecimal newPrecioTotalTotalDocumento) {
		precioTotalTotalDocumento = newPrecioTotalTotalDocumento;
	}
	     
   
 
	public void setIndicadorImpresion(Boolean  newIndicadorImpresion){
		indicadorImpresion = newIndicadorImpresion;
	}
	public Boolean getIndicadorImpresion(){
		return indicadorImpresion;
	}
	public void setNumeroDocumentoOrigen(Long newNumeroDocumentoOrigen){
		numeroDocumentoOrigen = newNumeroDocumentoOrigen;
	}
	public Long getNumeroDocumentoOrigen(){
		return numeroDocumentoOrigen;
	}
	public void setTipoDireccion(String newTipoDireccion){
		tipoDireccion = newTipoDireccion;
	}
	public String getTipoDireccion(){
		return tipoDireccion;
	}
	public void setAlmacen(String newAlmacen){
		almacen = newAlmacen;
	}
	public String getAlmacen(){
		 return almacen;
	}
	public void setPrecioCatalogoSinImpuestoTotalLocal(BigDecimal newPrecioCatalogoSinImpuestoTotalLocal){
		precioCatalogoSinImpuestoTotalLocal = newPrecioCatalogoSinImpuestoTotalLocal;
	}
    public BigDecimal getPrecioCatalogoSinImpuestoTotalLocal(){
		return precioCatalogoSinImpuestoTotalLocal;
	}
	public BigDecimal getImporteDescuento1SinImpuestosTotalLocal() {
		return importeDescuento1SinImpuestosTotalLocal;
	}

	public void setImporteDescuento1SinImpuestosTotalLocal(BigDecimal newImporteDescuento1SinImpuestosTotalLocal) {
		importeDescuento1SinImpuestosTotalLocal = newImporteDescuento1SinImpuestosTotalLocal;
	}

	public BigDecimal getImporteDescuento1TotalLocal() {
		return importeDescuento1TotalLocal;
	}

	public void setImporteDescuento1TotalLocal(BigDecimal newImporteDescuento1TotalLocal) {
		importeDescuento1TotalLocal = newImporteDescuento1TotalLocal;
	}

	public BigDecimal getImporteDescuento3SinImpuestosTotalLocal() {
		return importeDescuento3SinImpuestosTotalLocal;
	}

	public void setImporteDescuento3SinImpuestosTotalLocal(BigDecimal newImporteDescuento3SinImpuestosTotalLocal) {
		importeDescuento3SinImpuestosTotalLocal = newImporteDescuento3SinImpuestosTotalLocal;
	}

	public BigDecimal getImporteDescuento3TotalDocumento() {
		return importeDescuento3TotalDocumento;
	}

	public void setImporteDescuento3TotalDocumento(BigDecimal newImporteDescuento3TotalDocumento) {
		importeDescuento3TotalDocumento = newImporteDescuento3TotalDocumento;
	}

	public BigDecimal getImporteDescuento3TotalLocal() {
		return importeDescuento3TotalLocal;
	}

	public void setImporteDescuento3TotalLocal(BigDecimal newImporteDescuento3TotalLocal) {
		importeDescuento3TotalLocal = newImporteDescuento3TotalLocal;
	}

	public BigDecimal getImporteDescuentoTotalLocal() {
		return importeDescuentoTotalLocal;
	}

	public void setImporteDescuentoTotalLocal(BigDecimal newImporteDescuentoTotalLocal) {
		importeDescuentoTotalLocal = newImporteDescuentoTotalLocal;
	}

	public BigDecimal getImporteFleteSinImpuestosTotalDocumento() {
		return importeFleteSinImpuestosTotalDocumento;
	}

	public void setImporteFleteSinImpuestosTotalDocumento(BigDecimal newImporteFleteSinImpuestosTotalDocumento) {
		importeFleteSinImpuestosTotalDocumento = newImporteFleteSinImpuestosTotalDocumento;
	}

	public BigDecimal getImporteFleteTotalDocumento() {
		return importeFleteTotalDocumento;
	}

	public void setImporteFleteTotalDocumento(BigDecimal newImporteFleteTotalDocumento) {
		importeFleteTotalDocumento = newImporteFleteTotalDocumento;
	}

	public BigDecimal getImporteFleteTotalLocal() {
		return importeFleteTotalLocal;
	}

	public void setImporteFleteTotalLocal(BigDecimal newImporteFleteTotalLocal) {
		importeFleteTotalLocal = newImporteFleteTotalLocal;
	}

	public BigDecimal getImporteImpuestosTotalLocal() {
		return importeImpuestosTotalLocal;
	}

	public void setImporteImpuestosTotalLocal(BigDecimal newImporteImpuestosTotalLocal) {
		importeImpuestosTotalLocal = newImporteImpuestosTotalLocal;
	}

	public BigDecimal getImporteRedondeoConsolidadoDocumento() {
		return importeRedondeoConsolidadoDocumento;
	}

	public void setImporteRedondeoConsolidadoDocumento(BigDecimal newImporteRedondeoConsolidadoDocumento) {
		importeRedondeoConsolidadoDocumento = newImporteRedondeoConsolidadoDocumento;
	}

	public BigDecimal getImporteRedondeoConsolidadoLocal() {
		return importeRedondeoConsolidadoLocal;
	}

	public void setImporteRedondeoConsolidadoLocal(BigDecimal newImporteRedondeoConsolidadoLocal) {
		importeRedondeoConsolidadoLocal = newImporteRedondeoConsolidadoLocal;
	}

	public BigDecimal getImporteRedondeoDocumento() {
		return importeRedondeoDocumento;
	}

	public void setImporteRedondeoDocumento(BigDecimal newImporteRedondeoDocumento) {
		importeRedondeoDocumento = newImporteRedondeoDocumento;
	}

	public BigDecimal getImporteRedondeoLocal() {
		return importeRedondeoLocal;
	}

	public void setImporteRedondeoLocal(BigDecimal newImporteRedondeoLocal) {
		importeRedondeoLocal = newImporteRedondeoLocal;
	}

	public BigDecimal getPrecioCatalogoTotalLocal() {
		return precioCatalogoTotalLocal;
	}

	public void setPrecioCatalogoTotalLocal(BigDecimal newPrecioCatalogoTotalLocal) {
		precioCatalogoTotalLocal = newPrecioCatalogoTotalLocal;
	}

	public BigDecimal getPrecioCatalogoTotalLocalUnidadesPorAtender() {
		return precioCatalogoTotalLocalUnidadesPorAtender;
	}

	public void setPrecioCatalogoTotalLocalUnidadesPorAtender(BigDecimal newPrecioCatalogoTotalLocalUnidadesPorAtender) {
		precioCatalogoTotalLocalUnidadesPorAtender = newPrecioCatalogoTotalLocalUnidadesPorAtender;
	}

	public BigDecimal getPrecioContableSinImpuestosTotalLocal() {
		return precioContableSinImpuestosTotalLocal;
	}

	public void setPrecioContableSinImpuestosTotalLocal(BigDecimal newPrecioContableSinImpuestosTotalLocal) {
		precioContableSinImpuestosTotalLocal = newPrecioContableSinImpuestosTotalLocal;
	}

	public BigDecimal getPrecioContableTotalLocal() {
		return precioContableTotalLocal;
	}

	public void setPrecioContableTotalLocal(BigDecimal newPrecioContableTotalLocal) {
		precioContableTotalLocal = newPrecioContableTotalLocal;
	}

	public BigDecimal getPrecioFacturaTotalLocal() {
		return precioFacturaTotalLocal;
	}

	public void setPrecioFacturaTotalLocal(BigDecimal newPrecioFacturaTotalLocal) {
		precioFacturaTotalLocal = newPrecioFacturaTotalLocal;
	}

	public BigDecimal getPrecioNetoTotalDocumento() {
		return precioNetoTotalDocumento;
	}

	public void setPrecioNetoTotalDocumento(BigDecimal newPrecioNetoTotalDocumento) {
		precioNetoTotalDocumento = newPrecioNetoTotalDocumento;
	}

	public BigDecimal getPrecioNetoTotalLocal() {
		return precioNetoTotalLocal;
	}

	public void setPrecioNetoTotalLocal(BigDecimal newPrecioNetoTotalLocal) {
		precioNetoTotalLocal = newPrecioNetoTotalLocal;
	}

	public BigDecimal getPrecioTotalTotalLocal() {
		return precioTotalTotalLocal;
	}

	public void setPrecioTotalTotalLocal(BigDecimal newPrecioTotalTotalLocal) {
		precioTotalTotalLocal = newPrecioTotalTotalLocal;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal newTipoCambio) {
		tipoCambio = newTipoCambio;
	}

	public BigDecimal getTotalAPagarDocumento() {
		return totalAPagarDocumento;
	}

	public void setTotalAPagarDocumento(BigDecimal newTotalAPagarDocumento) {
		totalAPagarDocumento = newTotalAPagarDocumento;
	}

	public BigDecimal getTotalAPagarLocal() {
		return totalAPagarLocal;
	}

	public void setTotalAPagarLocal(BigDecimal newTotalAPagarLocal) {
		totalAPagarLocal = newTotalAPagarLocal;
	}

    public String getNumeroLoteContabilizacion() {
        return numeroLoteContabilizacion;
    }

    public void setNumeroLoteContabilizacion(String numeroLoteContabilizacion) {
        this.numeroLoteContabilizacion = numeroLoteContabilizacion;
    }

    public Date getFechaContabilizacion() {
        return fechaContabilizacion;
    }

    public void setFechaContabilizacion(Date fechaContabilizacion) {
        this.fechaContabilizacion = fechaContabilizacion;
    }

    public BigDecimal getImporteFleteSinImpuestosTotalLocal()
    {
        return importeFleteSinImpuestosTotalLocal;
    }

    public void setImporteFleteSinImpuestosTotalLocal(BigDecimal importeFleteSinImpuestosTotalLocal)
    {
        this.importeFleteSinImpuestosTotalLocal = importeFleteSinImpuestosTotalLocal;
    }

    public String getDireccionCompleta()
    {
        return direccionCompleta;
    }

    // Si es nulo insertamos cadena vacía
    public void setDireccionCompleta(String direccionCompleta)
    {
        this.direccionCompleta = (direccionCompleta != null?direccionCompleta:"");
    }

	
}//clase

	
