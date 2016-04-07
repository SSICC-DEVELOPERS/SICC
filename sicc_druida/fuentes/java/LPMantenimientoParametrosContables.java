
/**
 * Copyright 2006 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.druida.DruidaConector;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ccc.DTOParametrosContables;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;

import java.util.StringTokenizer;
import java.util.Vector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
 
public class LPMantenimientoParametrosContables extends LPSICCBase {
			 
      private String accion = null;
      private String opcionMenu = null;
      private String oidParametrosContables = null;
      
      private String indicativoDebeHaber = null;
      private String concatenarFechaSN = null;

		private String codObtencionCuenta = null;
      private String txtTextoApunte = null;
      private String cuenta = null;
      private String subproceso = null;
      private String proceso = null;
      private Long   pais;
      private Long   idioma;
      
      private String cbProceso = null;
      private String cbSubProcesoContable = null;
      private String cbObtencionCuenta = null;
      private String cbCuentaDirecta = null;
      private String debeHaber = null;
      private String concatenarFecha = null;
        
      public LPMantenimientoParametrosContables() {
            super();
      }
          
      public void inicio() throws Exception {
      }
      
      public void ejecucion() throws Exception {
			/*
			Implementación: 

			Si accion == "" 
			llamar al método inicializar() 
			en otro caso 
			Si accion == "guardar" 
			llamar al método guardar() 
			en otro caso 
			Si accion == "modificar" 
			llamar al método modificarParametrosContables() 
			en otro caso 
			Si accion == "detalle" 
			llamar al método detalleParametrosContables()

			*/

      try  {
            rastreo();
            setTrazaFichero();
            traza("*** Entrada - LPMantenimientoParametrosContables - ejecucion ***");
            //conectorAction("LPMantenimientoParametrosContables");
            //conectorActionParametro("accion", "insertar");  
            
            accion = conectorParametroLimpia("accion", "", true);
            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            
            pais = UtilidadesSession.getPais(this); 
            idioma = UtilidadesSession.getIdioma(this);
            
            traza("*** accion_" + accion + "  opcionMenu_" + opcionMenu);
            traza("*** pais_" + pais + "  idioma_" + idioma);
            
            if (accion.equals("")) {
                  inicializar();
            }
            if (accion.equals("guardar")) {
                  guardar();
            }
            if (accion.equals("modificar")) {
                  modificarParametrosContables();
            }
            if (accion.equals("detalle")) {
                  detalleParametrosContables();
            }
							
      } catch ( Exception e )  {
            logStackTrace(e);
            lanzarPaginaError(e);
      }
           traza("*** Salida - LPMantenimientoParametrosContables - ejecucion ***");
          }
	 
      public void inicializar() throws Exception {
            traza("*** Entrada - LPMantenimientoParametrosContables  - inicializar ***");
            
            String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            traza(" **** opcionMenu : " +  opcionMenu);
            
            if ( opcionMenu.equals("InsertarParametrosContables")) {

                  cargarPGInsertarParametrosContables();                           

            }
            if( opcionMenu.equals("ModificarParametrosContables") ||
                  opcionMenu.equals("ConsultarParametrosContables") ||
                  opcionMenu.equals("EliminarParametrosContables")    ){
                  
                  cargarPGConsultarParametrosContables();                           
            }
            
            traza("*** Salida - LPMantenimientoParametrosContables  - inicializar ***");			
      } 
				
		public void guardar() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosContables  - guardar ***");

			pagina("salidaGenerica");
			this.getFormatosValidaciones();
			
			DTOParametrosContables dtoParamContab = crearDTOParametrosContables();  
			MareBusinessID businessID = new MareBusinessID("CCCActualizarParametrosContables");
			
			//Invoca a ConectorActualizarParametrosContables con el idBusiness y el DTOParametrosContables 
			traza("*** Entrada - LPMantenimientoParametrosContables  - ya tengo el DTO ***");
			
			Vector parametros = new Vector();
			parametros.add(dtoParamContab);
			parametros.add(businessID);
			conectar("ConectorActualizarParametrosContables", parametros);
			
			asignarAtributo("VAR","ejecutar","valor","limpiar();");
			asignarAtributo("VAR","ejecutarError","valor","ejecucionError();");
			
		traza("*** Salida - LPMantenimientoParametrosContables  - guardar ***");	
	}
				/*			
				Invocar al subsistema GestorCargaPantalla 
				Asigna el combo: 
				- cbProceso 
				- cbCuentaDirecta 
				- cbObtencionCuenta 

				Deshabilitar el combo cbCuentaDirecta 

				Si opcionMenu == "ConsultarParametrosContables" 
				- Ocultar el boton btGuardar 

				Si accion == "modificar" 
				- Deshabilita cbProceso, cbSubProceso y debeHaber 

				Mostrar la página PGInsertarParametrosContables pasándole además: 
				- accion 
				- opcionMenu 
				*/				

      public void cargarPGInsertarParametrosContables() throws Exception{
            traza("*** Entrada - LPMantenimientoParametrosContables - cargarPGInsertarParametrosContables  ***");
            
            try { 
		accion = conectorParametroLimpia("accion", "", true);
		traza(" **** accion en cargarPGInsertarParametrosContables_"+ accion);
			  
		
		
		pagina("contenido_parametros_contables_insertar");
		this.getFormatosValidaciones();
		
		DTOBelcorp dtoe = new DTOBelcorp();
		pais       = UtilidadesSession.getPais(this); 
		idioma     = UtilidadesSession.getIdioma(this);
		
		traza(" **** pais_" + pais + "  idioma_" + idioma);
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);
		
		//Crear una lista ComposerViewElementList 
		ComposerViewElementList lista = new ComposerViewElementList();
		
		ComposerViewElement elem1 = new ComposerViewElement();
		elem1.setIDBusiness("CCCObtenerProcesosPais");
		elem1.setDTOE(dtoe);
		lista.addViewElement(elem1);
		
		ComposerViewElement elem2 = new ComposerViewElement();
		elem2.setIDBusiness("CCCObtenerCuentasContablesPais");
		elem2.setDTOE(dtoe);
		lista.addViewElement(elem2);
		
		
		ComposerViewElement elem3 = new ComposerViewElement();
		elem3.setIDBusiness("CCCObtenerObtencionCuenta");
		elem3.setDTOE(dtoe);
		lista.addViewElement(elem3);
		

		//Invocar al subsistema GestorCargaPantalla 
		ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		
		traza(" **** CCCObtenerProcesosPais resultado[ " + resultados + " ]");
		asignar("COMBO", "cbProceso", resultados, "CCCObtenerProcesosPais");  
		
		traza(" **** CCCObtenerCuentasContablesPais resultado[ " + resultados + " ]");
		asignar("COMBO", "cbCuentaDirecta", resultados, "CCCObtenerCuentasContablesPais");                  
		
		
		traza(" **** CCCObtenerObtencionCuenta resultado[ " + resultados + " ]");
		asignar("COMBO", "cbObtencionCuenta", resultados, "CCCObtenerObtencionCuenta");                  
		
		
		traza(" **** OpcionMenu_" + opcionMenu);
		if(opcionMenu.equals("InsertarParametrosContables")){

			asignarAtributoElemento("hCbCuentaDirecta","valor","N");
			getConfiguracionMenu("LPMantenimientoParametrosContables","insertar");
			this.asignarAtributoPagina("cod", "3091");

		}
		if(opcionMenu.equals("ConsultarParametrosContables")){

			getConfiguracionMenu("LPMantenimientoParametrosContables","detalle");
			this.asignarAtributoPagina("cod", "3094");
		}

		if(opcionMenu.equals("EliminarParametrosContables")){
			getConfiguracionMenu("LPMantenimientoParametrosContables","eliminar");
			asignarAtributoPagina("cod", "3092");
		}

		if(opcionMenu.equals("ModificarParametrosContables")){
				getConfiguracionMenu("LPMantenimientoParametrosContables","modificarDetalle");
				asignarAtributoPagina("cod", "3093");
		}
		
		if(accion.equals("modificar")){
			asignarAtributo("VAR", "habilitaTxtCodCliente", "valor","N");
		}
		
					/*****************************/
		
		/*
		Mostrar la página PGInsertarParametrosContables pasándole además: 
		- accion  - opcionMenu */
		
		asignarAtributo("VAR", "accion", "valor",accion);
		asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
		
		/*
		asigno el valor de la constante, para poder utilizarla desde una funcion .js
		*/
		String codObtencionCuenta;
		codObtencionCuenta = CCCConstantes.CODIGO_CUENTA_DIRECTA;
		asignarAtributo("VAR", "codObtencionCuenta", "valor",codObtencionCuenta);
		
		
		traza("*** Salida - LPMantenimientoParametrosContables - cargarPGInsertarParametrosContables  ***");
		
            }catch( Exception e )  {
            e.printStackTrace();
            this.logStackTrace(e);
            lanzarPaginaError(e);
      }	
      
      
      }

/*
//Recupera los valores de la página PGInsertarParametrosContables y los guarda en un DTOParametrosContables 

Crear un dto del tipo DTOParametrosContables dto con los siguientes valores: 
Si opcionMenu == "InsertarParametrosContables" 
dto.oid = null 
en otro caso 
dto.oid = oidParametrosContables // variable de la página PGInsertarParametrosContables 

dto.indicativoDebeHaber = valor de debeHaber de la pagina 
dto.obtencionCuenta = codObtencionCuenta de la cuenta seleccionada en cbObtencionCuenta 
dto.textoApunte = valor de txtTextoApunte de la pagina 
dto.concatenarFechaSN = valor de concatenarFecha de la pagina 
dto.cuenta = oid de la cuenta seleccionada en cbCuentaDirecta 
dto.subproceso = oid del subproceso seleccionado en cbSubProceso 
dto.proceso = oid del proceso seleccionado en cbProceso 


dto.pais = el de sesion 
dto.idioma = el de sesion 

Devuelve el DTOParametrosContables dto
*/
      
      public DTOParametrosContables crearDTOParametrosContables() throws Exception {
      traza("*** Entrada - LPMantenimientoParametrosContables - crearDTOParametrosContables  ***");		   
      
      DTOParametrosContables dtoParametrosContables = new DTOParametrosContables();
      
		
		traza("*** El valor antes del seteo de oidParametrosContables_" + oidParametrosContables);
		traza("*** opcionMenu.equals_"+opcionMenu);
		
		if( opcionMenu.equals("InsertarParametrosContables") ){
		traza("*** if TRUE *******");
            dtoParametrosContables.setOid(null);
      
      }else{
		traza("*** ELSE *******");
            // variable de la página PGInsertarParametrosContables 
      oidParametrosContables = conectorParametroLimpia("oidParametrosContables", "", true); 
		traza("*** El valor traido de la pagina de oidParametrosContables_" + oidParametrosContables);
      
			if(oidParametrosContables != null){
			
				if(!oidParametrosContables.equals("")){
					traza("*** IF_true__oidParametrosContables != ''");
                  dtoParametrosContables.setOid(new Long(oidParametrosContables));
            }else{
					traza("*** ELSE_oidParametrosContables == '' ");
				}
				
			}else{
				traza("*** oidParametrosContables_NULLLLLLLLLL..." );
			}

		}
			
		
		//valore de RB
		traza("*** voy a obtener ...........rbDebeHaber***");		   

      indicativoDebeHaber = conectorParametroLimpia("rbDebeHaber", "", true);	
		traza("*** valor indicativoDebeHaber_" + indicativoDebeHaber);		
		
		if(!indicativoDebeHaber.equals("")){				
            dtoParametrosContables.setIndicativoDebeHaber(indicativoDebeHaber);
      }			
		traza("*** crearDTOParametrosContables  -  rbDebeHaber es.........." + indicativoDebeHaber + "  ***");		   
      
		
		concatenarFechaSN = conectorParametroLimpia("rbConcatenar", "", true);		
		traza("*** valor concatenarFechaSN_" + concatenarFechaSN);		   
		
      if(!concatenarFechaSN.equals("")){
           // if(concatenarFechaSN.equals("S")){
				if(concatenarFechaSN.equals("1")){
                  //dtoParametrosContables.setConcatenarFechaSN(Boolean.TRUE);
						traza("*** concatenarFechaSN.equals('1')--> TRUE ");		   
                  dtoParametrosContables.setConcatenarFechaSN(Boolean.TRUE.booleanValue());
            }else{
                  //dtoParametrosContables.setConcatenarFechaSN(Boolean.FALSE);
						traza("*** concatenarFechaSN.equals('1')---> FALSE ");		   
                  dtoParametrosContables.setConcatenarFechaSN(Boolean.FALSE.booleanValue());
            }												
      }
		
	
		traza("*** crearDTOParametrosContables  -  voy a obtener ...........cbObtencionCuenta***");		   
      //codObtencionCuenta de la cuenta seleccionada en cbObtencionCuenta 
      codObtencionCuenta  = conectorParametroLimpia("cbObtencionCuenta", "", true);			
      //codObtencionCuenta  = conectorParametroLimpia("seleccionadoCbObtencionCuenta", "", true);			
      if(!codObtencionCuenta.equals("")){				
            dtoParametrosContables.setObtencionCuenta(codObtencionCuenta);
      }		
      
		traza("*** crearDTOParametrosContables  -  voy a obtener ...........txtTextoApunte***");		   
      //valor de txtTextoApunte de la pagina				
      txtTextoApunte = conectorParametroLimpia("txtTextoApunte", "", true);			
      if(!txtTextoApunte.equals("")){				
            dtoParametrosContables.setTextoApunte(txtTextoApunte);
      }		
      
      
      
		traza("*** crearDTOParametrosContables  -  voy a obtener ...........cbCuentaDirecta***");		   
      //oid de la cuenta seleccionada en cbCuentaDirecta 
      cuenta = conectorParametroLimpia("cbCuentaDirecta", "", true);
		traza("*** valor cuenta_" + cuenta);
		      
      if(!cuenta.equals("")){
            dtoParametrosContables.setCuenta(new Long(cuenta));
      }
      
traza("*** crearDTOParametrosContables  -  voy a obtener ...........cbSubProceso***");		   
      //oid del subproceso seleccionado en cbSubProceso 
      subproceso = conectorParametroLimpia("cbSubprocesoContable", "", true);
      traza("Este es el subproceso: " + subproceso);
      //subproceso = conectorParametroLimpia("seleccionadoCbSubProcesoContable", "", true);
      if(!subproceso.equals("")){
            dtoParametrosContables.setSubProceso(new Long(subproceso));
      }
      
traza("*** crearDTOParametrosContables  -  voy a obtener ...........cbProceso***");		   
      //oid del proceso seleccionado en cbProceso
      proceso = conectorParametroLimpia("cbProceso", "", true);
      //proceso = conectorParametroLimpia("seleccionadoCbProceso", "", true);
      if(!proceso.equals("")){
            dtoParametrosContables.setProceso(new Long(proceso));
      }
      
      pais       = UtilidadesSession.getPais(this); 
      idioma     = UtilidadesSession.getIdioma(this);
      
      dtoParametrosContables.setOidPais( pais );
      dtoParametrosContables.setOidIdioma( idioma );			
      
      /* pais el de sesion 
      Long pais = conectorParametroLimpia("pais", "", true);
      if(!pais.equals("")){
      dtoParametrosContables.setPais(new Long(pais));
      }
      
      idioma el de sesion 
      idioma = conectorParametroLimpia("idioma", "", true);
      if(!idioma.equals("")){
      dtoParametrosContables.setPais(new Long(idioma));
      }*/				
      
      traza("*** Salida - LPMantenimientoParametrosContables - crearDTOParametrosContables  ***");
      return dtoParametrosContables;			  
      }  
				  
		private void cargarPGConsultarParametrosContables() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosContables - cargarPGConsultarParametrosContables  ***");
		try{
				pagina("contenido_parametros_contables_consultar");

				this.getFormatosValidaciones();

				DTOBelcorp dtoB = new DTOBelcorp();
				pais       = UtilidadesSession.getPais(this); 
				idioma     = UtilidadesSession.getIdioma(this);

				traza(" **** pais_" + pais + "  idioma_" + idioma);
				dtoB.setOidPais(pais);
				dtoB.setOidIdioma(idioma);

				ComposerViewElementList lista = new ComposerViewElementList();
	  
				ComposerViewElement elem1 = new ComposerViewElement();
				elem1.setIDBusiness("CCCObtenerProcesosPais");
				elem1.setDTOE(dtoB);
				lista.addViewElement(elem1);
					//Invocar al subsistema GestorCargaPantalla 
				ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
				conector.ejecucion();
				DruidaConector resultados = conector.getConector();
				
				traza(" **** CCCObtenerProcesosPais resultado[ " + resultados + " ]");
				asignar("COMBO", "cbProceso", resultados, "CCCObtenerProcesosPais");
				
				
				traza(" **** opcionMenu_" + opcionMenu);
				
				if( opcionMenu.equals("ConsultarParametrosContables") ){
					getConfiguracionMenu("LPMantenimientoParametrosContables","consultar");
					this.asignarAtributoPagina("cod", "3090");
				}
					if( opcionMenu.equals("ModificarParametrosContables") ){
					getConfiguracionMenu("LPMantenimientoParametrosContables","modificar");
					this.asignarAtributoPagina("cod", "3093");
				}
				if( opcionMenu.equals("EliminarParametrosContables") ){
					getConfiguracionMenu("LPMantenimientoParametrosContables","eliminar");
					this.asignarAtributoPagina("cod", "3092");
				}
				
				asignarAtributo("VAR", "accion", "valor",accion);
				asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
					
				asignarAtributo("VAR", "pais", "valor", pais.toString());
				asignarAtributo("VAR", "idioma", "valor", idioma.toString());						
					
    		traza("*** Salida - LPMantenimientoParametrosContables - cargarPGConsultarParametrosContables  ***");
				
			}catch( Exception e )  {
					e.printStackTrace();
					this.logStackTrace(e);
					lanzarPaginaError(e);
			}	
				
      }
				
		private void detalleParametrosContables() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosContables - detalleParametrosContables  ***");
				
			//oid del elemento seleccionado en la lista resultado "lstResultado" de la pagina PGConsultarParametrosContables 
			oidParametrosContables = conectorParametroLimpia("oidParametroContable","", true);			
			traza("*** Recibido desde la PG oidParametrosContables_" + oidParametrosContables);		
	
			DTOParametrosContables dtoParametrosContables =  obtenerParametroContable();
		
			traza("*** obtenerParametroContable() ---> DTOParametrosContables " + dtoParametrosContables);
			//Llamar al método cargarPGInsertarParametrosContables() 
			cargarPGInsertarParametrosContables();

			mostrarDatosParametrosContables( dtoParametrosContables );		

			/**************************** DESHABILITAR TODOS LOS CAMPOS DE PGInsertarParametrosContables */
				asignar("VAR","hCbSubprocesoContable","N");
				asignar("VAR","hCbObtencionCuenta","N");
				asignar("VAR","hCbCuentaDirecta","N");
				asignar("VAR","hCbProceso","N");

				asignar("VAR","hTxtTextoApunte","N");
				
				asignar("VAR","hRbConcatenar","N");
				asignar("VAR","hRbDebeHaber","N");

			/****************************** DESHABILITAR TODOS LOS CAMPOS DE PGInsertarParametrosContables */
				
		traza("*** Salida - LPMantenimientoParametrosContables - detalleParametrosContables  ***");
		} 
	
	private void modificarParametrosContables() throws Exception {
	traza("*** Entrada - LPMantenimientoParametrosContables - modificarParametrosContables  ***");
	/*Implementación: 
	oidParametrosContables = oid del elemento seleccionado en la lista resultado "lstResultado" de la pagina PGConsultarParametrosContables 
	DTOParametrosContables = Llamar al método obtenerParametroContable() 
	Llamar al método cargarPGInsertarEncuestaAplicadaAClientes()  <------- ??? NOTA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! **************
	Llamar al método mostrarDatosParametrosContables( DTOParametrosContables ) */
				
		oidParametrosContables = conectorParametroLimpia("oidParametroContable", "", true);
		DTOParametrosContables dtoParametrosContables = obtenerParametroContable();
		cargarPGInsertarParametrosContables();
		mostrarDatosParametrosContables( dtoParametrosContables );
		/**************************** DESHABILITAR TODOS LOS CAMPOS DE PGInsertarParametrosContables 
			QUE PERTENEZCAN A LA UK
		*/
			asignar("VAR","hCbProceso","N");
			asignar("VAR","hCbSubprocesoContable","N");
			asignar("VAR","hRbDebeHaber","N");
		/**************************** DESHABILITAR TODOS LOS CAMPOS DE PGInsertarParametrosContables 
			QUE PERTENEZCAN A LA UK
		*/

	traza("*** Salida - LPMantenimientoParametrosContables - modificarParametrosContables  ***");
	}

	private DTOParametrosContables obtenerParametroContable() throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosContables - obtenerParametroContable  ***");
		/*			
		Crea un DTOOID con: 
		- oid = oidParametrosContables 
		Crea un idBusiness = "CCCObtenerParametroContable" 
		Invoca a ConectorObtenerParametroContable y obtiene un DTOParametrosContables 
		Devuelve el DTOParametrosContables obtenido
		*/
		
		DTOOID dtoOid = new DTOOID();
		dtoOid.setOidPais(pais);
		dtoOid.setOidIdioma(idioma);
		dtoOid.setOid(new Long(oidParametrosContables));
		
		MareBusinessID idBusiness = new MareBusinessID("CCCObtenerParametroContable");
		
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOid);
		paramEntrada.addElement(idBusiness);
			
		DruidaConector conector = conectar("ConectorObtenerParametroContable", paramEntrada);

		traza("*** Salida - LPMantenimientoParametrosContables - obtenerParametroContable  ***");
		return (DTOParametrosContables)conector.objeto("DTOParametrosContables");
	}

	private void mostrarDatosParametrosContables(DTOParametrosContables DTOE) throws Exception {
		traza("*** Entrada - LPMantenimientoParametrosContables - mostrarDatosParametrosContables  ***");
		/*
		Muestra en la página PGInsertarParametrosContables los datos recibidos en el DTOParametrosContables 
		Cargar en la página PGInsertarParametrosContables los siguientes datos: 
		
		oidParametrosContables = DTOE.oid 
		cbProceso = DTOE.proceso 
		cbSubProceso = DTOE.subproceso 
		cbObtencionCuenta = DTOE.obtencionCuenta 
		cbCuentaDirecta = DTOE.cuenta 
		debeHaber = DTOE.indicativoDebeHaber 
		txtTextoApunte = DTOE.textoApunte 
		concatenarFecha = DTOE.concatenarFechaSN 
		*/
		//pagina("contenido_tipo_movimiento_almacen_modificar");
		//cargarMenuMensajes();
		
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  DTOE............................ " + DTOE.toString());
		oidParametrosContables = DTOE.getOid() != null ? DTOE.getOid().toString() : "";  
										
		asignarAtributo("VAR", "oidParametrosContables", "valor", oidParametrosContables);  
		//asignarAtributo("VAR", "vOidParametrosContables", "valor", oidParametrosContables);
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  oidParametrosContables.......... " + oidParametrosContables);
		
		//COMBOS
		cbProceso = DTOE.getProceso() != null ? DTOE.getProceso().toString() : "" ;  
		asignarAtributo("VAR", "vCbProceso", "valor", cbProceso); 
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  cbProceso....................... " + cbProceso);
		
		cbSubProcesoContable = DTOE.getSubProceso() != null ? DTOE.getSubProceso().toString() : "";
		asignarAtributo("VAR", "vCbSubprocesoContable", "valor", cbSubProcesoContable);     
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  cbSubProcesoContable............ " + cbSubProcesoContable);
		
		cbObtencionCuenta = DTOE.getObtencionCuenta() != null ? DTOE.getObtencionCuenta().toString() : "";		
		asignarAtributo("VAR", "vCbObtencionCuenta", "valor", cbObtencionCuenta);     
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  cbObtencionCuenta............... " + cbObtencionCuenta);
		
		cbCuentaDirecta = DTOE.getCuenta() != null ? DTOE.getCuenta().toString() : "";
		asignarAtributo("VAR", "vCbCuentaDirecta", "valor", cbCuentaDirecta);     
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  cbCuentaDirecta................. " + cbCuentaDirecta);
		
		//TEXT
		txtTextoApunte = DTOE.getTextoApunte() != null ? DTOE.getTextoApunte().toString() : "";
		asignarAtributo("CTEXTO", "txtTextoApunte", "valor", txtTextoApunte);     
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  txtTextoApunte.................. " + txtTextoApunte);
		
		
		//RADIOB
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  concatenarFecha................. " + DTOE.getConcatenarFechaSN());
		if(DTOE.getConcatenarFechaSN()){
			traza("*** Entrando por " + DTOE.getConcatenarFechaSN());
			asignarAtributo("VAR", "vRbConcatenar", "valor", "1");     		
		}else{
			traza("*** Entrando por " + DTOE.getConcatenarFechaSN());
			asignarAtributo("VAR", "vRbConcatenar", "valor", "2");     		
		}
		
		
		debeHaber = DTOE.getIndicativoDebeHaber() != null ? DTOE.getIndicativoDebeHaber().toString() : "";
		traza("*** LPMantenimientoParametrosContables - mostrarDatosParametrosContables  debeHaber....................... " + debeHaber );
		asignarAtributo("VAR", "vRbDebeHaber", "valor", debeHaber);
		
		traza("*** Salida - LPMantenimientoParametrosContables - mostrarDatosParametrosContables  ***");				
	}

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
}	
