//$Id: LPCrearGestion.java,v 1.1 2009/12/03 18:40:26 pecbazalar Exp $ 
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
 * Autor: Viviana Bongiovanni
 */


import es.indra.sicc.util.*;
import es.indra.sicc.dtos.cob.DTOAccionCobranza;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.dtos.cob.DTOCompromisoDePago;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Date;
import java.util.Vector;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOOID;

public class LPCrearGestion extends LPSICCBase{

	String oidAccionCobGral;
   

	public LPCrearGestion()  {
	  super();
	}  

	public void inicio() throws Exception {			
		//pagina("contenido_gestion_crear");
	}


	public void ejecucion() throws Exception{

		setTrazaFichero();
		
		String accion = conectorParametroLimpia("accion", "", true);
		/* [1]
		Long oidPais = UtilidadesSession.getPais(this);
        Long oidIdioma = UtilidadesSession.getIdioma(this);
		

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
		asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());
		[1] */
		traza("accion: " + accion);

		try{
			if( accion.equals("") || accion.equals("ejecutarSeguimientoTel")){	
				inicioGestionCrear(accion);
				this.rastreo();
			}else if( accion.equals("crear") || accion.equals("crearSeguimientoTel")){
				this.cargarDatosCobranza();
				this.getFormatosValidaciones();  				
                this.crear();
			}else if( accion.equals("validarCliente") || accion.equals("validarClienteSeguimientoTel")){ 
				this.validarCliente();
			}else if( accion.equals("obtenerBloqueoCliente")){ 
				this.obtenerTipoBloqueo();
			}else if( accion.equals("crearGestion") || accion.equals("crearGestionSeguimientoTel")){
				this.crearGestion();
			}else if( accion.equals("aniadirCompromisosPago") ){
				pagina("contenido_compromiso_pago_seleccionar");
				this.getFormatosValidaciones();            
				this.añadirCompromisosPago();
			}	

	 }catch (Exception e){   

	   logStackTrace(e);
	   this.lanzarPaginaError(e);

	 }
     // Configura menu secundario
	 getConfiguracionMenu();

	}//fin ejecucion


	/*
		@author: pperanzola
		@date: 30/08/2006

	*/
	private void inicioGestionCrear(String accion)throws Exception{

		this.cargarDatosCobranza();

		Long oidPais = UtilidadesSession.getPais(this);
		Long oidIdioma = UtilidadesSession.getIdioma(this);

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
		asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());
	
	} // fin inicioGestionCrear

    private void logStackTrace(Throwable e) {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(os);

         e.printStackTrace(ps);
         try {
            traza("Se produjo la excepcion: " 
                + e.getMessage() 
                + "\n" 
                + "stackTrace = " 
                + os.toString());
         }
         catch (Exception ex) {
            e.printStackTrace ();
         }
    }



    private void crear() throws Exception{
        //traza("metodo crear()");  
        // Acciones de cobranzas
		String hOidAccionCob = conectorParametroLimpia("hOidAccionCob", "", true);
		asignarAtributo("VAR", "hOidAccionCob", "valor", hOidAccionCob);

		String accion = conectorParametroLimpia("accion", "", true);
		asignarAtributo("VAR", "accion", "valor", accion);
		
	    // Carga incial de combos
        //traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada1();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        //traza("antes del conector.ejecucion");
        conector.ejecucion();
        //traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        //traza("antes de asignar los COMBOS");
        asignar("COMBO","cbEtapa",resultados,"COBObtenerEtapasDeuda");        
		asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");    
		asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");    
		asignar("COMBO","cbSociedad",resultados,"SEGObtenerEmpresasPorPais");  
		asignar("COMBO","cbMedioPago",resultados,"BELObtenerMediosPagoCombo");    
		asignar("COMBO","cbBanco",resultados,"CCCObtieneBancos");    
		asignar("COMBO","cbMotivoNoCobro",resultados,"COBObtenerMotivosNoCobro");    

		// Valores por defecto
		Long empresaDft = UtilidadesSession.getSociedadPorDefecto(this);
		asignarAtributo("VAR", "hCbSociedad", "valor", empresaDft.toString());

        // Longitud del Codigo de cliente
		asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
		//traza("LongitudCodigoCliente: " + this.obtenerLongitudCodigoCliente().toString());
		traza("oidAccionCobGral: "+ oidAccionCobGral );
		DTOOID dtoS = new DTOOID();
		dtoS.setOid(new Long(oidAccionCobGral));
		DTOAccionCobranza dtoCob = new DTOAccionCobranza();

		Vector parametros = new Vector();
		parametros.add(dtoS);
		parametros.add(new MareBusinessID("COBObtenerAccionCobranza"));
		DruidaConector conectorDruida = conectar("ConectorObtenerAccionCobranza", parametros);
		dtoCob =  (DTOAccionCobranza) conectorDruida.objeto("DTOAccionCobranza");

		asignarAtributo("VAR", "hIndFechaHoraSeguimiento", "valor", dtoCob.getIndFechaHoraSeguimiento()==null?"":dtoCob.getIndFechaHoraSeguimiento().toString());
		asignarAtributo("VAR", "hIndFechaHoraNuevoSeguimiento", "valor", dtoCob.getIndFechaHoraNuevoSeguimiento()==null?"":dtoCob.getIndFechaHoraNuevoSeguimiento().toString());

		asignarAtributo("VAR", "hIndAportaPrueba", "valor", dtoCob.getIndAportaPrueba()==null?"":dtoCob.getIndAportaPrueba().toString());
		asignarAtributo("VAR", "hIndDescripcionPrueba", "valor", dtoCob.getIndDescripcionPrueba()==null?"":dtoCob.getIndDescripcionPrueba().toString());
		asignarAtributo("VAR", "hIndNumeroDocumentoSoporte", "valor", dtoCob.getIndNumeroDocumentoSoporte()==null?"":dtoCob.getIndNumeroDocumentoSoporte().toString());
		asignarAtributo("VAR", "hIndTipoDocumentoPago", "valor", dtoCob.getIndTipoDocumentoPago()==null?"":dtoCob.getIndTipoDocumentoPago().toString());
		asignarAtributo("VAR", "hIndBancoSucursal", "valor", dtoCob.getIndBancoSucursal()==null?"":dtoCob.getIndBancoSucursal().toString());
		asignarAtributo("VAR", "hIndNuevaDireccion", "valor", dtoCob.getIndNuevaDireccion()==null?"":dtoCob.getIndNuevaDireccion().toString());
		asignarAtributo("VAR", "hIndNuevoTelefono", "valor", dtoCob.getIndNuevoTelefono()==null?"":dtoCob.getIndNuevoTelefono().toString());
		asignarAtributo("VAR", "hIndPasaAdministrador", "valor", dtoCob.getIndPasaAdministrador()==null?"":dtoCob.getIndPasaAdministrador().toString());
		asignarAtributo("VAR", "hIndPeticionBloqueoAdministrativo", "valor", dtoCob.getIndPeticionBloqueoAdministrativo()==null?"":dtoCob.getIndPeticionBloqueoAdministrativo().toString());
		asignarAtributo("VAR", "hIndPeticionDesbloqueoAdministrativo", "valor", dtoCob.getIndPeticionDesbloqueoAdministrativo()==null?"":dtoCob.getIndPeticionDesbloqueoAdministrativo().toString());

		asignarAtributo("VAR", "hIndObservaciones", "valor", dtoCob.getIndObservaciones()==null?"":dtoCob.getIndObservaciones().toString());
		asignarAtributo("VAR", "hObservaciones", "valor", dtoCob.getObservaciones()==null?"":dtoCob.getObservaciones());

    
    }  

	


    private ComposerViewElementList crearParametrosEntrada1() throws Exception{
        //traza("metodo ComposerViewElementList");
		ComposerViewElementList lista = new ComposerViewElementList();

        DTOBelcorp dtoBel = new DTOBelcorp();
        //traza("antes de asignar al dtobelcorp");
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

        // Etapa
		ComposerViewElement etapa = new ComposerViewElement();        
		etapa.setIDBusiness("COBObtenerEtapasDeuda");
		etapa.setDTOE(dtoBel);
        
        lista.addViewElement(etapa);

		// Marca
		ComposerViewElement marca = new ComposerViewElement();        
		marca.setIDBusiness("SEGConsultaMarcas");
		marca.setDTOE(dtoBel);
        
        lista.addViewElement(marca);

		// Canal
		ComposerViewElement canal = new ComposerViewElement();        
		canal.setIDBusiness("SEGConsultaCanales");
		canal.setDTOE(dtoBel);
        
        lista.addViewElement(canal);

		// Empresa
		ComposerViewElement empresa = new ComposerViewElement();        
		empresa.setIDBusiness("SEGObtenerEmpresasPorPais");
		empresa.setDTOE(dtoBel);
        
        lista.addViewElement(empresa);

		// Medio de Pago
		ComposerViewElement medioPago = new ComposerViewElement();        
		medioPago.setIDBusiness("BELObtenerMediosPagoCombo");
		medioPago.setDTOE(dtoBel);
        
        lista.addViewElement(medioPago);

		// Banco
		ComposerViewElement banco = new ComposerViewElement();        
		banco.setIDBusiness("CCCObtieneBancos");
		banco.setDTOE(dtoBel);
        
        lista.addViewElement(banco);

		// Motivo no cobro
		ComposerViewElement motivoNoCobro = new ComposerViewElement();        
		motivoNoCobro.setIDBusiness("COBObtenerMotivosNoCobro");
		motivoNoCobro.setDTOE(dtoBel);
        
        lista.addViewElement(motivoNoCobro);

        return lista;
    }



	private void añadirCompromisosPago() throws Exception{
        //traza("metodo añadirCompromisosPago()");  

        // Cliente
		String codCliente = conectorParametroLimpia("codCliente", "", true);
		asignarAtributo("LABELC", "lbldtCodCliente", "valor", codCliente);    
       
        // Compromisos de Pago
		String compromisosDePago = conectorParametroLimpia("compromisosDePago", "", true);
		asignarAtributo("VAR", "compromisosDePago", "valor", compromisosDePago);

        // Fecha compromiso pago
        Date fechaDate = new Date(System.currentTimeMillis());
		String fechaCompromisoPago = UtilidadesBelcorp.fechaFormateada(fechaDate ,UtilidadesSession.getFormatoFecha(this));
		asignarAtributo("LABELC", "lbldtFechaCompromisoPago", "valor", fechaCompromisoPago);    
		asignarAtributo("VAR", "hFechaCompromisoPago", "valor", fechaCompromisoPago);
       
	    // Carga incial de combos
        //traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada2();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        //traza("antes del conector.ejecucion");
        conector.ejecucion();
        //traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        //traza("antes de asignar los COMBOS");
        asignar("COMBO","cbBanco",resultados,"CCCObtieneBancos");    
    
    }  
	


    private ComposerViewElementList crearParametrosEntrada2() throws Exception{
        //traza("metodo ComposerViewElementList");
		ComposerViewElementList lista = new ComposerViewElementList();

        DTOBelcorp dtoBel = new DTOBelcorp();
        //traza("antes de asignar al dtobelcorp");
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

        // Banco
		ComposerViewElement banco = new ComposerViewElement();        
		banco.setIDBusiness("CCCObtieneBancos");
		banco.setDTOE(dtoBel);
        
        lista.addViewElement(banco);

        return lista;
    }


	private void validarCliente() throws Exception{
		//traza("metodo validarCliente");

		pagina("salidaGenerica");
		asignarAtributo("VAR", "cerrarVentana", "valor", "false");

		try	{
				
			String codigoCliente = conectorParametroLimpia("txtCodigoCliente", "", true);

			// idBusiness= "MAEBusquedaRapidaClientes" 
			MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente");
			// Creamos un DTOBusquedaRapidaClientes y lo rellenamos con: 
			// - pais 
			// - idioma 
			// - codigoCliente: Valor introducido en txtCliente 
			DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
			dto.setIndicadorSituacion(new Long(0));
			dto.setTamanioPagina(new Integer(1));
			dto.setOidPais(UtilidadesSession.getPais(this));
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));

			dto.setCodigoCliente(codigoCliente);
			//traza("Código de cliente: " + codigoCliente);

			// Llamamos al ConectorBusquedaRapidaCliente con el dto creado. 
			Vector parametros = new Vector();
			parametros.add(dto);
			parametros.add(idBusiness);
			//traza("Conectando a ConectorBusquedaRapidaCliente... ");
			DruidaConector conector = conectar("ConectorBusquedaRapidaCliente", parametros);
			//traza("Conectó.");

			// Recibe un DTOSalida (con un registro) 
			DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida");
			RecordSet retorno = dtoRetornado.getResultado();
			//traza("Retornó: ");
			//traza(" - OID: " + (BigDecimal)retorno.getValueAt(0, "OID"));
			//traza(" - COD_CLIE: " + (String)retorno.getValueAt(0, "COD_CLIE"));

			String oidCliente = ((BigDecimal)retorno.getValueAt(0, "OID")).toString();
			


			String funcion = new String("asignarDatosCliente('" + oidCliente + "')");

			//traza("Funcion a ejecutar: " + funcion);
			asignarAtributo("VAR", "ejecutar", "valor", funcion);

		}catch (Exception e){   

		   asignarAtributo("VAR", "ejecutarError", "valor", "errorCliente()");
		   throw e;
		}
	}
    


    private void crearGestion() throws Exception{

		   pagina("salidaGenerica");
		   asignarAtributo("VAR", "cerrarVentana", "valor", "false");

           String utilFormatoFecha = UtilidadesSession.getFormatoFecha(this);
		   try{

			   String  oidAccionCob = conectorParametroLimpia("hOidAccionCob","",true);
		       String  oidCliente = conectorParametroLimpia("hOidCliente","",true);
               String  cbEtapa = conectorParametroLimpia("cbEtapa","",true);
		       String  cbPeriodo = conectorParametroLimpia("cbPeriodo","",true);
			   String  cbSociedad = conectorParametroLimpia("cbSociedad","",true);
		       String  cbTipoCargo = conectorParametroLimpia("cbTipoCargo","",true);
			   String  txtFechaSeguimiento = conectorParametroLimpia("txtFechaSeguimiento","",true);
		       String  txtHoraSeguimiento = conectorParametroLimpia("txtHoraSeguimiento","",true);
			   String  txtFechaReprogramacion = conectorParametroLimpia("txtFechaReprogramacion","",true);
		       String  txtHoraReprogramacion = conectorParametroLimpia("txtHoraReprogramacion","",true);
			   String  rbAportaPrueba = conectorParametroLimpia("rbAportaPrueba","",true);
		       String  txtDescripcionPrueba = conectorParametroLimpia("txtDescripcionPrueba","",true);
			   String  txtNumeroDocumentoSoporte = conectorParametroLimpia("txtNumeroDocumentoSoporte","",true);
		       String  cbMedioPago = conectorParametroLimpia("cbMedioPago","",true);
			   String  cbSucursal = conectorParametroLimpia("cbSucursal","",true);
		       String  txtNuevaDireccion = conectorParametroLimpia("txtNuevaDireccion","",true);
			   String  txtNuevoTelefono = conectorParametroLimpia("txtNuevoTelefono","",true);

			   String  rbPasaAlAdministrador = conectorParametroLimpia("rbPasaAlAdministrador","",true);
			   String  rbPeticionBloqueoAdministrativo = conectorParametroLimpia("rbPeticionBloqueoAdministrativo","",true);
			   String  rbPeticionDesBloqueoAdministrativo = conectorParametroLimpia("rbPeticionDesBloqueoAdministrativo","",true);

			   String  cbMotivoNoCobro = conectorParametroLimpia("cbMotivoNoCobro","",true);
			   String  areatxtObservaciones = conectorParametroLimpia("areatxtObservaciones","",true);
			   String  oidTipoBloqueo = conectorParametroLimpia("oidTipoBloqueo","",true);
			   


               // Arma la accion de cobranza
			   DTOGestionDeCobranza dtoGestionDeCobranza = new DTOGestionDeCobranza();

			   dtoGestionDeCobranza.setOidAccion(new Long(oidAccionCob));
			   dtoGestionDeCobranza.setOidEtapaDeuda(new Long(cbEtapa));			   
			   dtoGestionDeCobranza.setOidCliente(new Long(oidCliente));
			   dtoGestionDeCobranza.setOidPeriodo(new Long(cbPeriodo));
			   dtoGestionDeCobranza.setOidEmpresa(cbSociedad.equals("")?null:new Long(cbSociedad));
			   dtoGestionDeCobranza.setOidTipoCargoAbono(cbTipoCargo.equals("")?null:new Long(cbTipoCargo));

			   if(!txtFechaSeguimiento.equals("")) {
				    Date fechaSeguimiento = UtilidadesBelcorp.getDatefromSICCStringFormat(txtFechaSeguimiento, utilFormatoFecha);//[1] UtilidadesSession.getFormatoFecha(this));
			        //[1] java.sql.Date fechaSeguimientoSQL = new java.sql.Date(fechaSeguimiento.getTime());
					dtoGestionDeCobranza.setFechaSeguimiento(new java.sql.Date(fechaSeguimiento.getTime()));// [1] fechaSeguimientoSQL);
			   }

			   dtoGestionDeCobranza.setHoraSeguimiento(txtHoraSeguimiento);

			   if(!txtFechaReprogramacion.equals("")) {
					Date fechaReprogramacion = UtilidadesBelcorp.getDatefromSICCStringFormat(txtFechaReprogramacion, utilFormatoFecha);//[1] UtilidadesSession.getFormatoFecha(this));
					//[1] java.sql.Date fechaReprogramacionSQL = new java.sql.Date(fechaReprogramacion.getTime());
					dtoGestionDeCobranza.setFechaReprogramacion(new java.sql.Date(fechaReprogramacion.getTime()));//[1] fechaReprogramacionSQL);
			   }
 
			   dtoGestionDeCobranza.setHoraReprogramacion(txtHoraReprogramacion);

			   if(!rbAportaPrueba.equals(""))
					dtoGestionDeCobranza.setAportaPrueba(rbAportaPrueba.equals("S")?Boolean.TRUE:Boolean.FALSE);


			   dtoGestionDeCobranza.setDescripcionPrueba(txtDescripcionPrueba);
			   dtoGestionDeCobranza.setNumeroDocSoporte(txtNumeroDocumentoSoporte.equals("")?null:new Long(txtNumeroDocumentoSoporte));
			   dtoGestionDeCobranza.setOidMedioPago(cbMedioPago.equals("")?null:new Long(cbMedioPago));
			   dtoGestionDeCobranza.setOidSucursal(cbSucursal.equals("")?null:new Long(cbSucursal));
			   dtoGestionDeCobranza.setNuevaDireccion(txtNuevaDireccion);
			   dtoGestionDeCobranza.setNuevoTelefono(txtNuevoTelefono);

			   if(!rbPasaAlAdministrador.equals(""))
					dtoGestionDeCobranza.setPasaAdministrador(rbPasaAlAdministrador.equals("S")?Boolean.TRUE:Boolean.FALSE);

			   if(!rbPeticionBloqueoAdministrativo.equals(""))
					dtoGestionDeCobranza.setPeticionBloqueoAdmin(rbPeticionBloqueoAdministrativo.equals("S")?Boolean.TRUE:Boolean.FALSE);

			   if(!rbAportaPrueba.equals(""))
					dtoGestionDeCobranza.setPeticionDesbloqueoAdmin(rbPeticionDesBloqueoAdministrativo.equals("S")?Boolean.TRUE:Boolean.FALSE);   

			 

			   dtoGestionDeCobranza.setOidMotivoNoCobro(cbMotivoNoCobro.equals("")?null:new Long(cbMotivoNoCobro));
			   dtoGestionDeCobranza.setObservaciones(areatxtObservaciones);

			   dtoGestionDeCobranza.setOidTipoBloqueo(oidTipoBloqueo.equals("")?null:new Long(oidTipoBloqueo));

			   // Arma los compromisos de pago
			   String  compromisosDePago = conectorParametroLimpia("compromisosDePago","",true);
			   traza("compromisosDePago: " + compromisosDePago);

			   DTOCompromisoDePago dtoCompromisoPago = null;
			   ArrayList arrLstCompromisosDePago = new ArrayList();

			   StringTokenizer stkCompromisosDePago = new StringTokenizer(compromisosDePago,"|");

			   while (stkCompromisosDePago.hasMoreTokens()) {
				  String reg = stkCompromisosDePago.nextToken();
				  
				  //	Modificado por HRCS - Fecha 09/04/2007 - Incidencia Sicc20070179
				  //reg = this.replace(reg,"##","# #");
				  if ( reg.indexOf("####") != -1 )	{
					reg = this.replace(reg,"####","# # # #");
					traza("reg de compromiso (despues de 4): " + reg);
				  }
				  else if ( reg.indexOf("###") != -1 )	{
					reg = this.replace(reg,"###","# # #");
					traza("reg de compromiso (despues de 3): " + reg);
				  }
				  else if ( reg.indexOf("##") != -1 )	{
					reg = this.replace(reg,"##","# #");
					traza("reg de compromiso (despues de 2): " + reg);
				  }
				  //traza("reg de compromiso: " + reg);

				  StringTokenizer stkReg =  new StringTokenizer(reg,"#");

				  dtoCompromisoPago = new DTOCompromisoDePago();

                  Date fechaDePago = UtilidadesBelcorp.getDatefromSICCStringFormat(stkReg.nextToken(), utilFormatoFecha);//[1] UtilidadesSession.getFormatoFecha(this));
				  //[1] java.sql.Date fechaDePagoSQL = new java.sql.Date(fechaDePago.getTime());
				  dtoCompromisoPago.setFechaPago(new java.sql.Date(fechaDePago.getTime()));//[1] fechaDePagoSQL);

				  dtoCompromisoPago.setImportePago(new BigDecimal(desFormatearNumero(stkReg.nextToken(),LPSICCBase.FORMATO_MONEDA)));

				  Date fechaSeg = UtilidadesBelcorp.getDatefromSICCStringFormat(stkReg.nextToken(), utilFormatoFecha);//[1] UtilidadesSession.getFormatoFecha(this));
				  //[1]java.sql.Date fechaSegSQL = new java.sql.Date(fechaSeg.getTime());
				  dtoCompromisoPago.setFechaSeguimientoPrevisto(new java.sql.Date(fechaSeg.getTime()));//[1]fechaSegSQL);
                    
				  stkReg.nextToken();
				  //	Modificado por HRCS - Fecha 10/04/2007 - Incidencia Sicc20070179
				  String sucuDes = stkReg.nextToken();

				  String observacion = stkReg.nextToken();

                  dtoCompromisoPago.setObservaciones(observacion.equals(" ")?null:observacion);

				  Date fechaCom = UtilidadesBelcorp.getDatefromSICCStringFormat(stkReg.nextToken(), utilFormatoFecha);//[1] UtilidadesSession.getFormatoFecha(this));
				  //[1] java.sql.Date fechaComSQL = new java.sql.Date(fechaCom.getTime());
				  dtoCompromisoPago.setFechaCompromisoPago(new java.sql.Date(fechaCom.getTime()));//[1] fechaComSQL);

				  //	Modificado por HRCS - Fecha 10/04/2007 - Incidencia Sicc20070179
				  if (sucuDes.equals(" "))	{
					  dtoCompromisoPago.setSucursal(null);
				  }
				  else	{
					  dtoCompromisoPago.setSucursal(new Long(stkReg.nextToken()));
				  }

				  traza("dtoCompromisoPago: " + dtoCompromisoPago);

				  arrLstCompromisosDePago.add(dtoCompromisoPago);
			   }


               dtoGestionDeCobranza.setCompromisosDePago(arrLstCompromisosDePago);
			   dtoGestionDeCobranza.setOidPais(UtilidadesSession.getPais(this));


			   traza("dto: " + dtoGestionDeCobranza);

			   dtoGestionDeCobranza.setIpCliente(UtilidadesBelcorp.getIPCliente(this));				
               dtoGestionDeCobranza.setPrograma(UtilidadesSession.getFuncion(this));

			   MareBusinessID id = new MareBusinessID("COBCrearGestion");
			   Vector paramEntrada = new Vector();
			   paramEntrada.add(dtoGestionDeCobranza);
			   paramEntrada.add(id);
               traza("antes conector");
			   DruidaConector conectorGuardarGestion = conectar("ConectorGuardarGestion", paramEntrada);
			   traza("despues conector");

			   asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
		

		   }catch(Exception e){
			   asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
			   e.printStackTrace();
			   throw e;

		   }
    }

	/*public static String replace(String s, String s1, String s2) {
        int i = 0;
        int j = 0;
        int k = s1.length();
        StringBuffer stringbuffer = null;
        String s3 = s;
        while((j = s.indexOf(s1, i)) >= 0) 
        {
            if(stringbuffer == null)
            {
                stringbuffer = new StringBuffer(s.length() * 2);
            }
            stringbuffer.append(s.substring(i, j));
            stringbuffer.append(s2);
            i = j + k - 1;
        }
        if(i != 0)
        {
            stringbuffer.append(s.substring(i));
            s3 = stringbuffer.toString();
        }
        return s3;
    }*/

	//	Nuevo metodo replace - (HRCS) Fecha 12/04/2007 - Incidencia Sicc20070179
	public static String replace(String s, String what, String with) {
      StringBuffer sb = new StringBuffer();
      int index = s.indexOf(what);
      int j = 0;
      while (index != -1) {
         for (int i = j; i < index; i++)
         sb.append(s.charAt(i));
         j = index + what.length();
         sb.append(with);
         index = s.indexOf(what, j);
      }
 
      for (int i = j; i < s.length(); i++)
      sb.append(s.charAt(i));
 
      return sb.toString();
    }


	private void cargarDatosCobranza() throws Exception{

		String accion = conectorParametroLimpia("accion", "", true);
		
		Long oidPais = UtilidadesSession.getPais(this);
        Long oidIdioma = UtilidadesSession.getIdioma(this);

		/*inicio modificado ciglesias incidencia BELC300024442*/
		if ( (accion.equals("crearSeguimientoTel")) || (accion.equals("ejecutarSeguimientoTel"))) {

			String oidEtapaTxt = conectString("oidEtapa");
			String oidClienteTxt = conectString("oidCliente");
			String oidMarcaTxt = conectString("oidMarca");
			String oidCanalTxt = conectString("oidCanal");
			String oidTipoCargoAbonoTxt = conectString("oidTipoCargoAbono");
			String codigoClienteTxt = conectString("codigoCliente");
			String oidPeriodoTxt = conectString("oidPeriodo");
			oidAccionCobGral = conectString("hOidAccionCob");


			if (accion.equals("crearSeguimientoTel")) {
					pagina("contenido_gestion_crear_2"); 
			} else if (accion.equals("ejecutarSeguimientoTel")) {
					pagina("contenido_gestion_crear"); 
			}

			asignarAtributo("VAR", "hOidEtapa", "valor", oidEtapaTxt );
			asignarAtributo("VAR", "hOidCliente", "valor", oidClienteTxt );
			asignarAtributo("VAR", "hOidMarca", "valor", oidMarcaTxt );
			asignarAtributo("VAR", "hOidCanal", "valor", oidCanalTxt );
			asignarAtributo("VAR", "hOidPeriodo", "valor", oidPeriodoTxt );
			asignarAtributo("VAR", "hOidTipoCargoAbono", "valor", oidTipoCargoAbonoTxt );
			asignarAtributo("VAR", "hCodigoCliente", "valor", codigoClienteTxt );
			asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
    		asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());



		} else {
			if (accion.equals("crear")) {
				
				pagina("contenido_gestion_crear_2"); 

				Long marcaDft = UtilidadesSession.getMarcaPorDefecto(this);
				Long canalDft = UtilidadesSession.getCanalPorDefecto(this);

				asignarAtributo("VAR", "hCbMarca", "valor", marcaDft.toString());
				asignarAtributo("VAR", "hCbCanal", "valor", canalDft.toString());
				asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
        		asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());

				oidAccionCobGral = conectString("hOidAccionCob");

			} else if (accion.equals("")) {

					pagina("contenido_gestion_crear"); 
			}

		}
	}

		
	private String conectString(String campo) throws Exception{
		if (!conectorParametroLimpia(campo, "", true).equals("")) {
			traza(campo + ": " + conectorParametroLimpia(campo, "", true).toString());
			return conectorParametroLimpia(campo, "", true).toString();
		} else {
			traza(campo + ": ");
			return "";
		}
	}
		
	/*fin modificado ciglesias incidencia BELC300024442*/

	private void obtenerTipoBloqueo() throws Exception{


		pagina("salidaGenerica");
		asignarAtributo("VAR", "cerrarVentana", "valor", "false");

		try	{
				
			String oidCliente = conectorParametroLimpia("oidCliente", "", true);
			


			MareBusinessID idBusiness = new MareBusinessID("COBObtenerTipoBloqueos");

			DTOOID dto = new DTOOID();
			dto.setOidPais(UtilidadesSession.getPais(this));
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));
			dto.setOid(new Long(oidCliente));


			Vector parametros = new Vector();
			parametros.add(dto);
			parametros.add(idBusiness);
			DruidaConector conector = conectar("ConectorObjeto", parametros);
			DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida");
			RecordSet retorno = dtoRetornado.getResultado();

			String oid = ((BigDecimal)retorno.getValueAt(0, "OID")).toString();
			String descripcion = (retorno.getValueAt(0, "DES")).toString();


			String funcion = new String("asignarDatosTipoBloqueo('" + oid +";"+descripcion+ "')");
			asignarAtributo("VAR", "ejecutar", "valor", funcion);

		}catch (Exception e){   

		   asignarAtributo("VAR", "ejecutarError", "valor", "errorTipoBloqueo()");
		   throw e;
		}
	}

}
