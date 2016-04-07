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
	 * Fecha: 24/08/2004
	 * Observaciones:     	Componente construido de acuerdo a la especificación del 
	 *          Modelo de Componentes SICC-DMCO-CCC-201-344-N011A 
	 * Descripcion:		Este componente mapea a la tabla FAC_REGIS_UNICO_VENTA 
	 * @version		1.0
	 * @autor		L. Javier Collazos
	 */
package es.indra.sicc.entidades.fac;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.EJBException;           
import javax.ejb.FinderException;        
import javax.ejb.CreateException;        
import javax.ejb.DuplicateKeyException;  
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

import java.sql.Date;
import java.util.Vector;
import java.math.BigDecimal;

import es.indra.sicc.util.SecuenciadorOID;  
import es.indra.sicc.util.BelcorpService;   
import java.text.SimpleDateFormat;

import es.indra.mare.common.mii.MareMii;                       
import es.indra.mare.common.mii.MareTopic;                     
import es.indra.mare.common.exception.MareException;           
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import org.apache.commons.logging.Log;

public class RegistroUnicoVentasBean implements EntityBean  {

	private EntityContext context;

	public Long oidNumeroRUV;
	public Long pais;
	public Long sociedadVenta;

	public Date fechaEmision;
	public BigDecimal baseImponible;
	public BigDecimal importeImpuesto;
	public BigDecimal importeTotal;
	// public Long tipoDocumentoContable; se elimina este campo BELC300007694
	public String numeroIdentificacionFiscal;
    
    // nombre1, nombre2, apellido1 y apellido2 pasan a ser nulables. Se cambia el set y el get
	public String nombre1;
	public String nombre2;
	public String apellido1;
	public String apellido2;
    
	public Long cliente;
	public Boolean transferenciaGratuita;
	public Long Impuesto;
	public Long tipoDocumentoLegal;
    public Long numeroDocumentoLegal;  // Cambiado a Long por la BELC300015038
	public String serieDocumentoLegal;
		
	//  nullables
	public Long subacceso; // Puede ser nullable por inicencia: 8146
	public Long cabDocContable;
	public String numeroIdentificacionNacional;
	public String serieDocumentoReferencia;
    public Long numeroDocumentoReferencia;  // Cambiado a Long por la BELC300015038
	public String puntoEmision;
	public Long documentoInterno;
    public String ejercicioDocumentoInterno;
	public Long tipoDocumentoReferencia;
	public BigDecimal interesesMora;
	public BigDecimal descuento;
	public BigDecimal comisiones;
	public BigDecimal flete;
	public BigDecimal baseImponibleNeto;
	public Boolean estado;
	public Boolean facturaGratuita;
	public Date fechaCierre;
	public String estadoRUV;
	public String documentoInternoHipersale;
        private String fechaEmisionDocumento;
        private Long oidTipoDocumentoIdentidad;
        private String valNombreCliente;
	
	public Long ejbCreate() {
		return null;
	}

	public void ejbPostCreate() {
	}

	/**
	 * Metodo ejbCreate al que se le pasan solo los parametros obligatorios
	 */
	public Long ejbCreate(	Long pais,
							Long sociedadVenta,
							Date fechaEmision,
							BigDecimal baseImponible,
							BigDecimal importeImpuesto,
							BigDecimal importeTotal,
							String numeroIdentificacionFiscal,
							String nombre1,
							String nombre2,
							String apellido1,
							String apellido2,
							Long cliente,
							Boolean transferenciaGratuita,
							Long impuesto,
							Long tipoDocumentoLegal,
							Long numeroDocumentoLegal,
							String serieDocumentoLegal,
                                                        String fechaEmisionDocumento,
                                                        Long oidTipoDocumentoIdentidad,
                                                        String valNombreCliente)
		throws CreateException,DuplicateKeyException {

		Vector vector= new Vector();

		this.setPais(pais);
		this.setSociedadVenta(sociedadVenta);
		this.setFechaEmision(fechaEmision);
		this.setBaseImponible(baseImponible);
		this.setImporteImpuesto(importeImpuesto);
		this.setImporteTotal(importeTotal);
		this.setNumeroIdentificacionFiscal(numeroIdentificacionFiscal);
		this.setNombre1(nombre1);
		this.setNombre2(nombre2);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
		this.setCliente(cliente);
		this.setTransferenciaGratuita(transferenciaGratuita);
		this.setImpuesto(impuesto);// incidencia 7618
		this.setTipoDocumentoLegal(tipoDocumentoLegal);
		this.setNumeroDocumentoLegal(numeroDocumentoLegal);
		this.setSerieDocumentoLegal(serieDocumentoLegal);
                this.setFechaEmisionDocumento(fechaEmisionDocumento);
                this.setOidTipoDocumentoIdentidad(oidTipoDocumentoIdentidad);
                this.setValNombreCliente(valNombreCliente);
		//this.setTipoDocumentoContable(tipoDocumentoContable); se elimina BELC300007694
		// estos campos pasan a no ser obligatorios BELC300007694
		//this.setCabDocContable(cabDocContable);
		//this.setPuntoEmision(puntoEmision);
		//this.setDocumentoInterno(documentoInterno);
		//this.setEjercicioDocumentoInterno(ejercicioDocumentoInterno);
		//this.setNumeroIdentificacionNacional(numeroIdentificacionNacional);
		//this.setSerieDocumentoReferencia(serieDocumentoReferencia);
		//this.setNumeroDocumentoReferencia(numeroDocumentoReferencia);
			
		try {
			// Asignar el nuevo oid
			this.setOidNumeroRUV(SecuenciadorOID.obtenerSiguienteValor("FAC_RUVE_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}
		StringBuffer query  = new StringBuffer( "INSERT INTO FAC_REGIS_UNICO_VENTA (" +
						" OID_REGI, " +
						" PAIS_OID_PAIS, " +
						" SOCI_OID_SOCI, " +
						" FEC_EMIS, " +
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
						" TAIM_OID_TASA_IMPU," + // incidencia 	7618
						" TIDO_OID_TIPO_DOCU, " +
						" VAL_NUME_DOCU_LEGA, " +
                                                " FEC_EMIS_REFE, " +                                                
                                                " TDOC_OID_TIPO_DOCU, " +
                                                " VAL_NOMB, " +
						" VAL_SERI_DOCU_LEGA  ");

						// modificaciones de BELC300007694
						//" VAL_EJER_DOCU_INTE, " +
						//" NUM_DOCU_CONT_INTE, " +
						//" VAL_PUNT_EMIS, " +
						//" VAL_DOCU_INTE, " +
						//" VAL_NUME_IDEN_NNAL, " +
						//" VAL_SERI_DOCU_REFE, " +
						//" VAL_NUME_DOCU_REFE, " +
						//" DCCA_OID_CABE, " +

		vector.add(this.getOidNumeroRUV());
		vector.add(this.getPais());
		vector.add(this.getSociedadVenta());
		vector.add(this.getFechaEmision());
		vector.add(this.getBaseImponible());
		vector.add(this.getImporteImpuesto());
		vector.add(this.getImporteTotal());
		vector.add(this.getNumeroIdentificacionFiscal());
		vector.add(this.getNombre1());
		vector.add(this.getNombre2());
		vector.add(this.getApellido1());
		vector.add(this.getApellido2());
		vector.add(this.getCliente());
		vector.add(this.getTransferenciaGratuita());
		vector.add(this.getImpuesto());
		vector.add(this.getTipoDocumentoLegal());
		vector.add(this.getNumeroDocumentoLegal());
	        //vector.add(this.getFechaEmisionDocumento());
	        vector.add(" TO_DATE('" + this.getFechaEmisionDocumento() + "', 'yyyy-MM-DD')");
	        vector.add(this.getOidTipoDocumentoIdentidad());
                vector.add("'"+this.getValNombreCliente()+"'");
		vector.add('\'' + this.getSerieDocumentoLegal() + '\'');

		// modificaciones de BELC300007694
		//vector.add(this.getCabDocContable());
		//vector.add(this.getEjercicioDocumentoInterno());
		//vector.add(this.getTipoDocumentoContable());
		//vector.add(this.getPuntoEmision());
		//vector.add(this.getDocumentoInterno());
		//vector.add(this.getNumeroIdentificacionNacional());
		//vector.add(this.getSerieDocumentoReferencia());
		//vector.add(this.getNumeroDocumentoReferencia());

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
        
        return this.getOidNumeroRUV();
	}

	public void ejbPostCreate( Long pais,
								Long sociedadVenta,
								Date fechaEmision,
								BigDecimal baseImponible,
								BigDecimal importeImpuesto,
								BigDecimal importeTotal,
								String numeroIdentificacionFiscal,
								String nombre1,
								String nombre2,
								String apellido1,
								String apellido2,
								Long cliente,
								Boolean transferenciaGratuita,
								Long impuesto,
								Long tipoDocumentoLegal,
								Long numeroDocumentoLegal,
								String serieDocumentoLegal,
								String fechaEmisionDocumento,
								Long oidTipoDocumentoIdentidad,
                                                                String valNombreCliente) {
	}

	/**
	 * Metodo ejbCreate al que se le pasan todos los parametros 
	 */

	public Long ejbCreate( Long pais,
						Long sociedadVenta,
						Long subacceso,
						String ejercicioDocumentoInterno, //tipo modificado por incidencia 10384
						Date fechaEmision,
						BigDecimal baseImponible,
						BigDecimal importeImpuesto,
						BigDecimal importeTotal,
						String puntoEmision,
						Long documentoInterno,
						String numeroIdentificacionFiscal,
						String numeroIdentificacionNacional,
						String serieDocumentoReferencia,
						Long numeroDocumentoReferencia,
						String nombre1,
						String nombre2,
						String apellido1,
						String apellido2,
						Long cliente,
						Boolean transferenciaGratuita,
						Long cabDocContable,
						Long impuesto,
						Long tipoDocumentoLegal,
						Long numeroDocumentoLegal,
						String serieDocumentoLegal,
						Long tipoDocumentoReferencia,
						BigDecimal interesesMora,
						BigDecimal descuento,
						BigDecimal comisiones,
						BigDecimal flete,
						BigDecimal baseImponibleNeto,
						Boolean estado,
						Boolean facturaGratuita,
						Date fechaCierre,
						String estadoRUV,
						String documentoInternoHipersale,
						String fechaEmisionDocumento,
						Long oidTipoDocumentoIdentidad,
                                                String valNombreCliente) 
		throws CreateException, DuplicateKeyException {

		Vector vector= new Vector();

		this.setPais(pais);
		this.setSociedadVenta(sociedadVenta);
		this.setSubacceso(subacceso);
		this.setEjercicioDocumentoInterno(ejercicioDocumentoInterno);
		//this.setTipoDocumentoContable(tipoDocumentoContable);
		this.setFechaEmision(fechaEmision);
		this.setBaseImponible(baseImponible);
		this.setImporteImpuesto(importeImpuesto);
		this.setImporteTotal(importeTotal);
		this.setPuntoEmision(puntoEmision);
		this.setDocumentoInterno(documentoInterno);
		this.setNumeroIdentificacionFiscal(numeroIdentificacionFiscal);
		this.setNumeroIdentificacionNacional(numeroIdentificacionNacional);
		this.setSerieDocumentoReferencia(serieDocumentoReferencia);
		this.setNumeroDocumentoReferencia(numeroDocumentoReferencia);
		this.setNombre1(nombre1);
		this.setNombre2(nombre2);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
		this.setCliente(cliente);
		this.setTransferenciaGratuita(transferenciaGratuita);
		this.setCabDocContable(cabDocContable);
		this.setImpuesto(impuesto); 
		this.setTipoDocumentoLegal(tipoDocumentoLegal);
		this.setNumeroDocumentoLegal(numeroDocumentoLegal);
		this.setSerieDocumentoLegal(serieDocumentoLegal);
		this.setTipoDocumentoReferencia(tipoDocumentoReferencia);
		this.setInteresesMora(interesesMora);
		this.setDescuento(descuento);
		this.setComisiones(comisiones);
		this.setFlete(flete);
		this.setBaseImponibleNeto(baseImponibleNeto);
		this.setEstado(estado);
		this.setFacturaGratuita(facturaGratuita);
		this.setFechaCierre(fechaCierre);
		this.setEstadoRUV(estadoRUV);
		this.setDocumentoInternoHipersale(documentoInternoHipersale);	
	        this.setFechaEmisionDocumento(fechaEmisionDocumento);
	        this.setOidTipoDocumentoIdentidad(oidTipoDocumentoIdentidad);
	        this.setValNombreCliente(valNombreCliente);
		try {
			// Asignar el nuevo oid
			this.setOidNumeroRUV(SecuenciadorOID.obtenerSiguienteValor("FAC_RUVE_SEQ"));
		} catch (MareException me) {
			throw new CreateException();
		}

		
		StringBuffer query  = new StringBuffer( "INSERT INTO FAC_REGIS_UNICO_VENTA (" +
						" OID_REGI, " +
						" PAIS_OID_PAIS, " +
						" SOCI_OID_SOCI, " );
						// Cambiado por incidencia 8146
						if(this.getSubacceso() != null){
							query.append(" SBAC_OID_SBAC , ");
						}
						
						//" VAL_EJER_DOCU_INTE, " +
						//" NUM_DOCU_CONT_INTE, " +
						query.append(" FEC_EMIS, " +
						" VAL_BASE_IMPO, " +
						" IMP_IMPU, " +
						" IMP_TOTA, " );
						//" VAL_PUNT_EMIS, " +
						//" VAL_DOCU_INTE, " +
						if(this.getNumeroIdentificacionFiscal() != null && !this.getNumeroIdentificacionFiscal().equals("")){
                     query.append(" VAL_NUME_IDEN_FISC, ");
                  }
						//" VAL_NUME_IDEN_NNAL, " +
						//" VAL_SERI_DOCU_REFE, " +
						//" VAL_NUME_DOCU_REFE, " +
                  if(this.getNombre1() != null && !this.getNombre1().equals("")){
						   query.append(" VAL_NOM1, " );
                  }
						
                  if(this.getNombre2() != null && !this.getNombre2().equals("")){
                     query.append(" VAL_NOM2, ");
                  }
                  if(this.getApellido1() != null && !this.getApellido1().equals(""))   {
						   query.append(" VAL_APE1, " );
                  }
                  
                  if(this.getApellido2() != null  && !this.getApellido2().equals("")){
						   query.append(" VAL_APE2, " );
                  }
                  
                  if(this.getCliente() != null){
                     query.append(" CLIE_OID_CLIE, ");
                  }
						
                  query.append(" IND_TRAN_GRAT, " +
						//" DCCA_OID_CABE, " +
						" TAIM_OID_TASA_IMPU, " + //  incidencia	7618
						" TIDO_OID_TIPO_DOCU, " +
						" VAL_NUME_DOCU_LEGA, " +
                                                " FEC_EMIS_REFE, " +                                                
                                                " TDOC_OID_TIPO_DOCU, " +   
                                                " VAL_NOMB, " +
						" VAL_SERI_DOCU_LEGA  ");
						
		vector.add(this.getOidNumeroRUV());
		vector.add(this.getPais());
		vector.add(this.getSociedadVenta());
		if(this.getSubacceso() != null){
			vector.add(this.getSubacceso());
		}
		//vector.add(this.getEjercicioDocumentoInterno());
		//vector.add(this.getTipoDocumentoContable());
      
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
      String fechaEm = formato.format(this.getFechaEmision());
		
      vector.add(" TO_DATE('" + fechaEm + "', 'yyyy-MM-DD')");
		vector.add(this.getBaseImponible());
		vector.add(this.getImporteImpuesto());
		vector.add(this.getImporteTotal());
		//vector.add(this.getPuntoEmision());
		//vector.add(this.getDocumentoInterno());
		if(this.getNumeroIdentificacionFiscal() != null && !this.getNumeroIdentificacionFiscal().equals("")){
         vector.add("'" + this.getNumeroIdentificacionFiscal()+ "'");
      }
		//vector.add(this.getNumeroIdentificacionNacional());
		//vector.add(this.getSerieDocumentoReferencia());
		//vector.add(this.getNumeroDocumentoReferencia());
		 if(this.getNombre1() != null  && !this.getNombre1().equals("")){
         vector.add("'"+this.getNombre1()+"'");
      }
	   
      if(this.getNombre2() != null  && !this.getNombre2().equals("")){
         vector.add("'"+this.getNombre2()+"'");
      }
		
      if(this.getApellido1() != null  && !this.getApellido1().equals("")){
         vector.add("'"+this.getApellido1()+"'");
      }
		
      if(this.getApellido2() != null  && !this.getApellido2().equals("")){
         vector.add("'"+this.getApellido2()+"'");
      }
		
      if(this.getCliente() != null){
         vector.add(this.getCliente());
      }
      if(this.getTransferenciaGratuita().booleanValue()){
		   vector.add("1");
      }else{
         vector.add("0");
      }
		//vector.add(this.getCabDocContable());
		vector.add(this.getImpuesto());
		vector.add(this.getTipoDocumentoLegal());
		vector.add(this.getNumeroDocumentoLegal());
	        //vector.add(this.getFechaEmisionDocumento());
	        vector.add(" TO_DATE('" + this.getFechaEmisionDocumento() + "', 'yyyy-MM-DD')");
	        vector.add(this.getOidTipoDocumentoIdentidad());
                vector.add("'"+this.getValNombreCliente()+"'");
		vector.add('\'' + this.getSerieDocumentoLegal() + '\'');
      
          
    	if(this.getEjercicioDocumentoInterno() != null){
			query.append(" , VAL_EJER_DOCU_INTE ");
			vector.add(this.getEjercicioDocumentoInterno());
		}
		if(this.getDocumentoInternoHipersale() != null){
			query.append(" , NUM_DOCU_CONT_INTE "); 
			vector.add(this.getDocumentoInternoHipersale());
		}
		if(this.getPuntoEmision() != null && !this.getPuntoEmision().equals("")){
			query.append(" , VAL_PUNT_EMIS ");
			vector.add(this.getPuntoEmision());
		}
		if(this.getDocumentoInterno() != null){
			query.append(" , VAL_DOCU_INTE ");				
			vector.add(this.getDocumentoInterno());
		}
		if(this.getNumeroIdentificacionNacional() != null && !this.getNumeroIdentificacionNacional().equals("")){
			query.append(" , VAL_NUME_IDEN_NNAL ");
			vector.add("'" + this.getNumeroIdentificacionNacional()+"'");
		}
		if(this.getSerieDocumentoReferencia() != null && !this.getSerieDocumentoReferencia().equals("")){
			query.append(" , VAL_SERI_DOCU_REFE ");
			vector.add("'" +this.getSerieDocumentoReferencia()+"'" );
		}
		if(this.getNumeroDocumentoReferencia() != null){
			query.append(" , VAL_NUME_DOCU_REFE ");
			vector.add(this.getNumeroDocumentoReferencia());
		}
		if(this.getCabDocContable() != null){
			query.append(" , DCCA_OID_CABE ");
			vector.add(this.getCabDocContable());
		}
		if(this.getTipoDocumentoReferencia() != null){
			query.append(" , TIDO_TIPO_DOCU_REFE ");
			vector.add(this.getTipoDocumentoReferencia());
		}
		if(this.getInteresesMora() != null){
			query.append(" , VAL_INTE_MORA ");
			vector.add(this.getInteresesMora());
		}
		if(this.getDescuento() != null){
			query.append(" , VAL_DESC ");
			vector.add(this.getDescuento());
		}
		if(this.getComisiones() != null){
			query.append(" , VAL_COMI ");
			vector.add(this.getComisiones());
		}
		if(this.getFlete() != null){
			query.append(" , VAL_FLET ");
			vector.add(this.getFlete());
		}
		if(this.getBaseImponibleNeto() != null){
			query.append(" , VAL_BASE_IMPO_NETO ");
			vector.add(this.getBaseImponibleNeto());
		}else{
      query.append(" , VAL_BASE_IMPO_NETO ");
			vector.add(new Long(0));
      }
		if(this.getEstado() != null){
			query.append(" , IND_ESTA ");
         if(this.getEstado().booleanValue()){
			   vector.add("1");
         }else{
            vector.add("0");
         }
		}
		if(this.getFacturaGratuita() != null){
         query.append(" , IND_FACT_GRAT ");
         if(this.getFacturaGratuita().booleanValue() ){
			   vector.add("1");
         }else{
            vector.add("0");
         }
		}
		if(this.getFechaCierre() != null){
			query.append(" , FEC_CIER ");
			vector.add(this.getFechaCierre());
		}
		if(this.getEstadoRUV() != null){
			query.append(" , VAL_INDI_RUV ");
			vector.add("'"+this.getEstadoRUV()+"'");
		}
		
		query.append(") VALUES (");
      for (int i = 0; i < vector.size(); i++){
         query.append(vector.get(i) + ", ");
      }
      query = new StringBuffer(query.substring(0,query.length() - 2));
      query.append(")");
      UtilidadesLog.warn("MAD SQL " + query.toString());  
      UtilidadesLog.warn("MAD PARAMETROS " + vector);
							
		BelcorpService bs;                                                                                          
                                                                                                                
		try {                                                                                                       
		  bs = BelcorpService.getInstance();                                                                      
		} catch (MareMiiServiceNotFoundException e) {                                                               
		  throw new EJBException(e);                                                                              
		}                                                                                                           
		try {                                                                                                       
			bs.dbService.executeUpdate(query.toString());                                           
		} catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else
				throw ejbe;
		}
      catch (Exception e) {                                                                                     
			throw new EJBException(e);                                                                              
		}                    
    
      return this.getOidNumeroRUV();
	}

	public void ejbPostCreate( Long pais,
							Long sociedadVenta,
							Long subacceso,
							String ejercicioDocumentoInterno,
							Date fechaEmision,
							BigDecimal baseImponible,
							BigDecimal importeImpuesto,
							BigDecimal importeTotal,
							String puntoEmision,
							Long documentoInterno,
							String numeroIdentificacionFiscal,
							String numeroIdentificacionNacional,
							String serieDocumentoReferencia,
							Long numeroDocumentoReferencia, 
							String nombre1,
							String nombre2,
							String apellido1,
							String apellido2,
							Long cliente,
							Boolean transferenciaGratuita,
							Long cabDocContable,
							Long impuesto,
							Long tipoDocumentoLegal,
							Long numeroDocumentoLegal,
							String serieDocumentoLegal,
							Long tipoDocumentoReferencia,
							BigDecimal interesesMora,
							BigDecimal descuento, 
							BigDecimal comisiones,
							BigDecimal flete,
							BigDecimal baseImponibleNeto,
							Boolean estado,
							Boolean facturaGratuita,
							Date fechaCierre,
							String estadoRUV,
							String documentoInternoHipersale,
							String fechaEmisionDocumento,
							Long oidTipoDocumentoIdentidad,
                                                        String valNombreCliente) {
	}
	
	public Long ejbFindByPrimaryKey(Long primaryKey) throws FinderException {
		Vector parametros = new Vector();

		String consulta = "SELECT OID_REGI FROM FAC_REGIS_UNICO_VENTA  " +
							"WHERE OID_REGI = ?";

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
		Vector params = new Vector();                                                                                  
    try{                                                                                                          
		String consulta  = "SELECT * FROM FAC_REGIS_UNICO_VENTA WHERE OID_REGI  = ?";                                
		params.add((Long)context.getPrimaryKey());                                                                     
                                                                                                               
		RecordSet respuesta;                                                                                           
		BelcorpService bs;                                                                                             
                                                                                                               
		try {                                                                                                          
			respuesta = this.ejecutaConsulta(consulta, params);                                                        
		} catch (Exception exception) {                                                                                
			 throw new EJBException(exception);                                                                         
		}                                                                                                              
		
    if (!respuesta.esVacio()) {                                                                                    
			// Al oid le damos la primary key, esto es obligatorio hacerlo, pues                                       
			// si venimos de un findby, el oid no se cargaría                                                          
			this.setOidNumeroRUV((Long)context.getPrimaryKey());                                                                

	        this.setPais(new Long(((BigDecimal)respuesta.getValueAt(0,"pais_oid_pais".toUpperCase())).longValue()));
			this.setSociedadVenta(new Long(((BigDecimal)respuesta.getValueAt(0,"soci_oid_soci".toUpperCase())).longValue()));
			//this.setSubacceso(new Long(((BigDecimal)respuesta.getValueAt(0,"sbac_oid_sbac".toUpperCase())).longValue()));
			// cambiado por Incidencia 8146
			this.setSubacceso(respuesta.getValueAt(0,"sbac_oid_sbac".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0,"sbac_oid_sbac".toUpperCase())).longValue()) : null);

			this.setFechaEmision((Date)respuesta.getValueAt(0,"fec_emis".toUpperCase()));
			this.setBaseImponible((BigDecimal)respuesta.getValueAt(0,"val_base_impo".toUpperCase()));
			this.setImporteImpuesto((BigDecimal)respuesta.getValueAt(0,"imp_impu".toUpperCase()));
			this.setImporteTotal((BigDecimal)respuesta.getValueAt(0,"imp_tota".toUpperCase()));
			this.setNumeroIdentificacionFiscal((String)respuesta.getValueAt(0,"val_nume_iden_fisc".toUpperCase()));
            // nombre1, nombre2, apellido1 y apellido2 pasan a ser nullables.
			this.setNombre1(respuesta.getValueAt(0,"val_nom1".toUpperCase())!=null?(String)respuesta.getValueAt(0,"val_nom1".toUpperCase()):"");
			this.setNombre2(respuesta.getValueAt(0,"val_nom2".toUpperCase())!=null?(String)respuesta.getValueAt(0,"val_nom2".toUpperCase()):"");
			this.setApellido1(respuesta.getValueAt(0,"val_ape1".toUpperCase())!=null?(String)respuesta.getValueAt(0,"val_ape1".toUpperCase()):"");
			this.setApellido2(respuesta.getValueAt(0,"val_ape2".toUpperCase())!=null?(String)respuesta.getValueAt(0,"val_ape2".toUpperCase()):"");
			this.setCliente(new Long(((BigDecimal)respuesta.getValueAt(0,"clie_oid_clie".toUpperCase())).longValue()));
			if (respuesta.getValueAt(0, "IND_TRAN_GRAT") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_TRAN_GRAT")).intValue()==1)
                    this.setTransferenciaGratuita(new Boolean(true));
                else
                    this.setTransferenciaGratuita(new Boolean(false));
            } else
                 this.setTransferenciaGratuita(null);
			
			this.setImpuesto(new Long(((BigDecimal)respuesta.getValueAt(0,"taim_oid_tasa_impu".toUpperCase())).longValue()));
			this.setTipoDocumentoLegal(new Long(((BigDecimal)respuesta.getValueAt(0,"tido_oid_tipo_docu".toUpperCase())).longValue()));
			this.setNumeroDocumentoLegal(new Long(((BigDecimal)respuesta.getValueAt(0,"val_nume_docu_lega".toUpperCase())).longValue()));
			this.setSerieDocumentoLegal((String)respuesta.getValueAt(0,"val_seri_docu_lega".toUpperCase()));

			//campos nullables
			
      // DBLG700000069 pto 6 - gPineda - 29/09/06
      //this.setEjercicioDocumentoInterno(respuesta.getValueAt(0,"val_ejer_docu_inte".toUpperCase()) != null ? (respuesta.getValueAt(0, "tido_tipo_docu_refe".toUpperCase())).toString() : null);
      this.setEjercicioDocumentoInterno(respuesta.getValueAt(0,"val_ejer_docu_inte".toUpperCase()) != null ? (respuesta.getValueAt(0, "val_ejer_docu_inte".toUpperCase())).toString() : null);
      
			this.setDocumentoInternoHipersale(respuesta.getValueAt(0,"num_docu_cont_inte".toUpperCase()) != null ? (String)respuesta.getValueAt(0,"num_docu_cont_inte".toUpperCase()) : null );
			this.setPuntoEmision(respuesta.getValueAt(0,"val_punt_emis".toUpperCase())!= null ? (String)respuesta.getValueAt(0,"val_punt_emis".toUpperCase()) : null);
			this.setDocumentoInterno(respuesta.getValueAt(0,"val_docu_inte".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0,"val_docu_inte".toUpperCase())).longValue()) : null);
			this.setNumeroIdentificacionNacional(respuesta.getValueAt(0,"val_nume_iden_nnal".toUpperCase()) != null ? (String)respuesta.getValueAt(0,"val_nume_iden_nnal".toUpperCase()) : null);
			this.setSerieDocumentoReferencia(respuesta.getValueAt(0,"val_seri_docu_refe".toUpperCase()) != null ? (String)respuesta.getValueAt(0,"val_seri_docu_refe".toUpperCase()) : null);
			this.setNumeroDocumentoReferencia(respuesta.getValueAt(0,"val_nume_docu_refe".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0,"val_nume_docu_refe".toUpperCase())).longValue()) : null);
			this.setCabDocContable(respuesta.getValueAt(0,"dcca_oid_cabe".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0,"dcca_oid_cabe".toUpperCase())).longValue()) : null);

			this.setTipoDocumentoReferencia(respuesta.getValueAt(0, "tido_tipo_docu_refe".toUpperCase()) != null ? new Long(((BigDecimal)respuesta.getValueAt(0, "tido_tipo_docu_refe".toUpperCase())).longValue()) : null);
			this.setInteresesMora(respuesta.getValueAt(0,"val_inte_mora".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0,"val_inte_mora".toUpperCase()) : null);
			this.setDescuento(respuesta.getValueAt(0,"val_desc".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0,"val_des".toUpperCase()) : null);
			this.setComisiones(respuesta.getValueAt(0,"val_comi".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0,"val_comi".toUpperCase()) : null);
			this.setFlete(respuesta.getValueAt(0,"val_flet".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0,"val_flet".toUpperCase()) : null);
			this.setBaseImponibleNeto(respuesta.getValueAt(0,"val_base_impo_neto".toUpperCase()) != null ? (BigDecimal)respuesta.getValueAt(0,"val_base_impo_neto2".toUpperCase()) : null);
			
			if (respuesta.getValueAt(0, "IND_ESTA") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_ESTA")).intValue()==1)
                    this.setEstado(new Boolean(true));
                else
                    this.setEstado(new Boolean(false));
            } else
                 this.setEstado(null);
			
			if (respuesta.getValueAt(0, "IND_FACT_GRAT") != null) {
                if (((BigDecimal)respuesta.getValueAt(0, "IND_FACT_GRAT")).intValue()==1)
                    this.setFacturaGratuita(new Boolean(true));
                else
                    this.setFacturaGratuita(new Boolean(false));
            } else
                 this.setFacturaGratuita(null);
			this.setFechaCierre(respuesta.getValueAt(0,"fec_cier".toUpperCase()) != null ? (Date)respuesta.getValueAt(0,"fec_cier".toUpperCase()) : null);
			this.setEstadoRUV(respuesta.getValueAt(0,"val_indi_ruv".toUpperCase()) != null ? (String)respuesta.getValueAt(0,"val_indi_ruv".toUpperCase()) : null);
							
		}
    } catch(RuntimeException e)
    {
      UtilidadesLog.error("RegistroUnicoVenta.ejbLoad()",e);
      throw e;
    }
	}
	public void ejbPassivate() {
	}

	public void ejbRemove() {

		Vector param = new Vector();		
        String consulta = "DELETE FROM FAC_REGIS_UNICO_VENTA WHERE OID_REGI = ?";
        param.add((Long)context.getPrimaryKey());

        BelcorpService bs;
        
        try {
			ejecutaSentencia(consulta, param);
        } catch (Exception exception) {
			throw new EJBException(exception);
        }
	}

	public void ejbStore() {
		Vector params = new Vector();
		StringBuffer consulta = new StringBuffer("");

		consulta.append("UPDATE FAC_REGIS_UNICO_VENTA SET ");

		consulta.append(" PAIS_OID_PAIS = " + this.getPais());
		consulta.append(" , SOCI_OID_SOCI = " +  this.getSociedadVenta());
    
		if (this.getSubacceso() != null) {
			consulta.append(" , SBAC_OID_SBAC = " + this.getSubacceso());
		}
    else {
			consulta.append(" , SBAC_OID_SBAC = null");
		}
    
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
      String fechaEm = formato.format(this.getFechaEmision());
		     
		consulta.append(" , FEC_EMIS = TO_DATE('" + fechaEm + "', 'yyyy-MM-DD')");		
		consulta.append(" , VAL_BASE_IMPO = " + this.getBaseImponible());
		consulta.append(" , IMP_IMPU = " + this.getImporteImpuesto());
		consulta.append(" , IMP_TOTA = " + this.getImporteTotal());
      
      if(this.getNumeroIdentificacionFiscal() != null && !this.getNumeroIdentificacionFiscal().equals("")){
		   consulta.append(" , VAL_NUME_IDEN_FISC = '" + this.getNumeroIdentificacionFiscal() + "' " );
      }else{
         consulta.append(" , VAL_NUME_IDEN_FISC = null");
      }
		if(this.getNombre1()!=null && !this.getNombre1().equals("")){
         consulta.append(" , VAL_NOM1 = '" + this.getNombre1() + "' " );
		}else{
         consulta.append(" , VAL_NOM1 = null");
      }
     
      if(this.getNombre2() !=null && !this.getNombre2().equals("")){
         consulta.append(" , VAL_NOM2 = '" + this.getNombre2() + "' " );
		}else{
         consulta.append(" , VAL_NOM2 = null");
      }
      if(this.getApellido1() !=null && !this.getApellido1().equals("")){
         consulta.append(" , VAL_APE1 = '" + this.getApellido1() + "' " );
      }
		if(this.getApellido2() !=null && !this.getApellido2().equals("")){
         consulta.append(" , VAL_APE2 = '" + this.getApellido2() + "' " );
      }else{
         consulta.append(" , VAL_APE2 = null");
      }
		if(this.getCliente()!=null){
         consulta.append(" , CLIE_OID_CLIE = " + this.getCliente());
		}else{
         consulta.append(" , CLIE_OID_CLIE = null ");
      }
      
      if(this.getTransferenciaGratuita().booleanValue()){
		   consulta.append(" , IND_TRAN_GRAT = 1 ");
      }else{
         consulta.append(" , IND_TRAN_GRAT = 0 ");
      }     		
		
    consulta.append(" , TAIM_OID_TASA_IMPU = " + this.getImpuesto());
		consulta.append(" , TIDO_OID_TIPO_DOCU = " + this.getTipoDocumentoLegal());
		consulta.append(" , VAL_NUME_DOCU_LEGA = " + this.getNumeroDocumentoLegal());
		consulta.append(" , VAL_SERI_DOCU_LEGA = '" + this.getSerieDocumentoLegal() + "' " );
		
		// campos nulables
		if (this.getEjercicioDocumentoInterno() != null) {
			consulta.append(" , VAL_EJER_DOCU_INTE = '" + this.getEjercicioDocumentoInterno() + "' " );
		} else {
			consulta.append(" , VAL_EJER_DOCU_INTE = null ");
		}
		if(this.getDocumentoInternoHipersale() != null) {
			consulta.append(" , NUM_DOCU_CONT_INTE = '" + this.getDocumentoInternoHipersale() + "' " );
		} else {
			consulta.append(" , NUM_DOCU_CONT_INTE = null ");
		}
		if(this.getPuntoEmision() != null && !this.getPuntoEmision().equals("")) {
			consulta.append(" , VAL_PUNT_EMIS = '" + this.getPuntoEmision() + "' " );
		} else {
			consulta.append(" , VAL_PUNT_EMIS = null "); 	
		}
		if(this.getDocumentoInterno() != null){
			consulta.append(" , VAL_DOCU_INTE = " + this.getDocumentoInterno());
		} else {
			consulta.append(" , VAL_DOCU_INTE = null ");	
		}
		if(this.getNumeroIdentificacionNacional() != null && !this.getNumeroIdentificacionNacional().equals("")){
			consulta.append(" , VAL_NUME_IDEN_NNAL = '" + this.getNumeroIdentificacionNacional() + "' " );
		} else {
			consulta.append(" , VAL_NUME_IDEN_NNAL = null ");	
		}
		if(this.getSerieDocumentoReferencia() != null && !this.getSerieDocumentoReferencia().equals("")) {
			consulta.append(" , VAL_SERI_DOCU_REFE = '" + this.getSerieDocumentoReferencia() + "' " );
		} else{
			consulta.append(" , VAL_SERI_DOCU_REFE = null ");	
		}
		if(this.getNumeroDocumentoReferencia() != null){
			consulta.append(" , VAL_NUME_DOCU_REFE = " + this.getNumeroDocumentoReferencia());
		} else {
			consulta.append(" , VAL_NUME_DOCU_REFE = null ");	
		}
		if(this.getCabDocContable() != null){
			consulta.append(" , DCCA_OID_CABE = " + this.getCabDocContable());
		} else {
			consulta.append(" , DCCA_OID_CABE = null ");	
		}
        if (this.getTipoDocumentoReferencia() != null) {
            consulta.append(" , TIDO_TIPO_DOCU_REFE = " + this.getTipoDocumentoReferencia());
        } else {
            consulta.append(" , TIDO_TIPO_DOCU_REFE = null ");
        }
		if (this.getInteresesMora() != null) {
            consulta.append(" , VAL_INTE_MORA = " + this.getInteresesMora());
        } else {
            consulta.append(" , VAL_INTE_MORA = null");
        }
		if (this.getDescuento() != null) {
            consulta.append(" , VAL_DESC = " +  this.getDescuento());
        } else {
            consulta.append(" , VAL_DESC = null ");
        }

		if (this.getComisiones() != null) {
            consulta.append(" , VAL_COMI = " + this.getComisiones());
        } else {
            consulta.append(" , VAL_COMI = null ");
        }

		if (this.getFlete() != null) {
            consulta.append(" , VAL_FLET = " + this.getFlete());
        } else {
            consulta.append(" , VAL_FLET = null ");
        }

		if (this.getBaseImponibleNeto() != null) {
            consulta.append(" , VAL_BASE_IMPO_NETO = " + this.getBaseImponibleNeto());
        } else {
            consulta.append(" , VAL_BASE_IMPO_NETO = 0 ");
        }
		if (this.getEstado() != null) {            
         if(this.getEstado().booleanValue()){
            consulta.append(" , IND_ESTA = 1 ");
         }else{
            consulta.append(" , IND_ESTA = 0 ");
         }
		}else{
         consulta.append(" , IND_ESTA = null ");      
      }
      
		if (this.getFacturaGratuita() != null) {
         if(this.getFacturaGratuita().booleanValue() ){
			  consulta.append(" , IND_FACT_GRAT = 1 ");
         }else{
           consulta.append(" , IND_FACT_GRAT = 0 ");
         }
      }else{
         consulta.append(" , IND_FACT_GRAT = null ");
      }

		if (this.getFechaCierre() != null) {
            consulta.append(" , FEC_CIER = " + this.getFechaCierre());
        } else {
            consulta.append(" , FEC_CIER = null ");
        }

		if (this.getEstadoRUV() != null) {
            consulta.append(" , VAL_INDI_RUV = '" + this.getEstadoRUV().toUpperCase() + "' " );
        } else {
            consulta.append(" , VAL_INDI_RUV = null ");
        }

		consulta.append(" WHERE OID_REGI = " + (Long)context.getPrimaryKey());
         
      UtilidadesLog.warn("MAD SQL " + consulta.toString());  
      
      
      BelcorpService bs;    
      try {                                                                                                       
		  bs = BelcorpService.getInstance();                                                                      
		} catch (MareMiiServiceNotFoundException e) {                                                               
		  throw new EJBException(e);                                                                              
		}                                                                                                     

      try {   
			bs.dbService.executeUpdate(consulta.toString());
		} catch (Exception e) {
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

	public Long getOidNumeroRUV() {
		return oidNumeroRUV;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date newFechaEmision) {
		fechaEmision = newFechaEmision;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String newNombre1) {
		nombre1 = (newNombre1!=null?newNombre1:"");
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String newNombre2) {
		nombre2 = (newNombre2!=null?newNombre2:"");
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String newApellido1) {
		apellido1 = (newApellido1!=null?newApellido1:"");
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String newApellido2) {
		apellido2 = (newApellido2!=null?newApellido2:"");
	}

	public String getPuntoEmision() {
		return puntoEmision;
	}

	public void setPuntoEmision(String newPuntoEmision) {
		puntoEmision = newPuntoEmision;
	}

	public String getSerieDocumentoLegal() {
		return serieDocumentoLegal;
	}

	public void setSerieDocumentoLegal(String newSerieDocumentoLegal) {
		serieDocumentoLegal = newSerieDocumentoLegal;
	}

	public Long getNumeroDocumentoLegal() {
		return numeroDocumentoLegal;
	}

	public void setNumeroDocumentoLegal(Long newNumeroDocumentoLegal) {
		numeroDocumentoLegal = newNumeroDocumentoLegal;
	}

	public String getEjercicioDocumentoInterno() {
        return ejercicioDocumentoInterno;
	}

	public void setEjercicioDocumentoInterno(String newEjercicioDocumentoInterno) {
        ejercicioDocumentoInterno = newEjercicioDocumentoInterno;
	}

	public Long getDocumentoInterno() {
		return documentoInterno;
	}

	public void setDocumentoInterno(Long newDocumentoInterno) {
		documentoInterno = newDocumentoInterno;
	}

	public String getNumeroIdentificacionFiscal() {
		return numeroIdentificacionFiscal;
	}

	public void setNumeroIdentificacionFiscal(String newNumeroIdentificacionFiscal) {
		numeroIdentificacionFiscal = newNumeroIdentificacionFiscal;
	}

	public String getNumeroIdentificacionNacional() {
		return numeroIdentificacionNacional;
	}

	public void setNumeroIdentificacionNacional(String newNumeroIdentificacionNacional) {
		numeroIdentificacionNacional = newNumeroIdentificacionNacional;
	}

	public String getSerieDocumentoReferencia() {
		return serieDocumentoReferencia;
	}

	public void setSerieDocumentoReferencia(String newSerieDocumentoReferencia) {
		serieDocumentoReferencia = newSerieDocumentoReferencia;
	}

	public Long getNumeroDocumentoReferencia() {
		return numeroDocumentoReferencia;
	}

	public void setNumeroDocumentoReferencia(Long newNumeroDocumentoReferencia) {
		numeroDocumentoReferencia = newNumeroDocumentoReferencia;
	}

	public BigDecimal getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(BigDecimal newBaseImponible) {
		baseImponible = newBaseImponible;
	}

	public BigDecimal getBaseImponibleNeto() {
		return baseImponibleNeto;
	}

	public void setBaseImponibleNeto(BigDecimal newBaseImponibleNeto) {
		baseImponibleNeto = newBaseImponibleNeto;
	}

	public BigDecimal getImporteImpuesto() {
		return importeImpuesto;
	}

	public void setImporteImpuesto(BigDecimal newImporteImpuesto) {
		importeImpuesto = newImporteImpuesto;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal newImporteTotal) {
		importeTotal = newImporteTotal;
	}

	public BigDecimal getInteresesMora() {
		return interesesMora;
	}

	public void setInteresesMora(BigDecimal newInteresesMora) {
		interesesMora = newInteresesMora;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal newDescuento) {
		descuento = newDescuento;
	}

	public BigDecimal getComisiones() {
		return comisiones;
	}

	public void setComisiones(BigDecimal newComisiones) {
		comisiones = newComisiones;
	}

	public BigDecimal getFlete() {
		return flete;
	}

	public void setFlete(BigDecimal newFlete) {
		flete = newFlete;
	}

	public Boolean getFacturaGratuita() {
		return facturaGratuita;
	}

	public void setFacturaGratuita(Boolean newFacturaGratuita) {
		facturaGratuita = newFacturaGratuita;
	}

	public Boolean getTransferenciaGratuita() {
		return transferenciaGratuita;
	}

	public void setTransferenciaGratuita(Boolean newTransferenciaGratuita) {
		transferenciaGratuita = newTransferenciaGratuita;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date newFechaCierre) {
		fechaCierre = newFechaCierre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean newEstado) {
		estado = newEstado;
	}

	public String getEstadoRUV() {
		return estadoRUV;
	}

	public void setEstadoRUV(String newEstadoRUV) {
		estadoRUV = newEstadoRUV;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long newCliente) {
		cliente = newCliente;
	}



	public Long getTipoDocumentoReferencia() {
		return tipoDocumentoReferencia;
	}

	public void setTipoDocumentoReferencia(Long newTipoDocumentoReferencia) {
		tipoDocumentoReferencia = newTipoDocumentoReferencia;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Long getSociedadVenta() {
		return sociedadVenta;
	}

	public void setSociedadVenta(Long newSociedadVenta) {
		sociedadVenta = newSociedadVenta;
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	}

	public Long getCabDocContable() {
		return cabDocContable;
	}

	public void setCabDocContable(Long newCabDocContable) {
		cabDocContable = newCabDocContable;
	}

	public Long getImpuesto() {
		return Impuesto;
	}

	public void setImpuesto(Long newImpuesto) {
		Impuesto = newImpuesto;
	}
	
	public Long getTipoDocumentoLegal() {
		return tipoDocumentoLegal;
	}

	public void setTipoDocumentoLegal(Long newTipoDocumentoLegal) {
		tipoDocumentoLegal = newTipoDocumentoLegal;
	}

	public void setOidNumeroRUV(Long newOidNumeroRUV) {
		oidNumeroRUV = newOidNumeroRUV;
	}

	public String getDocumentoInternoHipersale() {
		return documentoInternoHipersale;
	}

	public void setDocumentoInternoHipersale(String newDocumentoInternoHipersale) {
		documentoInternoHipersale = newDocumentoInternoHipersale;
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
			loguearSql("**** BMP  RegistroUnicoVentas: ", query, argumentos);		                        
			return bs.dbService.executePreparedUpdate(query, argumentos);                                           
		} catch (Exception e) {                                                                                     
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
		loguearSql("**** BMP RegistroUnicoVentas: ", consulta, params);                                    
		return res;                                                                                                 
	}

    public String getFechaEmisionDocumento() {
        return fechaEmisionDocumento;
    }

    public void setFechaEmisionDocumento(String fechaEmisionDocumento) {
        this.fechaEmisionDocumento = fechaEmisionDocumento;
    }

    public Long getOidTipoDocumentoIdentidad() {
        return oidTipoDocumentoIdentidad;
    }

    public void setOidTipoDocumentoIdentidad(Long oidTipoDocumentoIdentidad) {
        this.oidTipoDocumentoIdentidad = oidTipoDocumentoIdentidad;
    }

    public String getValNombreCliente() {
        return valNombreCliente;
    }

    public void setValNombreCliente(String valNombreCliente) {
        this.valNombreCliente = valNombreCliente;
    }
}
