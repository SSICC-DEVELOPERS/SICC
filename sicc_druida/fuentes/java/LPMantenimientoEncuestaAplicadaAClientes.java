
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
import es.indra.sicc.dtos.mae.DTOEncuestaAplicadaPorCliente;

import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mae.DTOEncuestaAplicadaPorCliente;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.util.Vector;
 
public class LPMantenimientoEncuestaAplicadaAClientes extends LPSICCBase {

		Long pais = null;
		Long idioma = null;
			
		private Long oidEncuestaAplicadaCliente = null;
		private String opcionMenu = null;
		private String accion = null;		
	
		private String activado = null;
		private String sOidCliente  = null;
		private String txtCodigoProducto = null;
		private String sTxtCodigoCliente = null;
		private String sCodigoCliente = null;
		private String sOidRespuesta = null;
		private String sCbRespuesta = null;
	   private String sOidPregunta = null;
		private String sCbPregunta = null;		
		private String sOidEncuestaCliente = null;

  public LPMantenimientoEncuestaAplicadaAClientes() {
                   super();
  }
          
   public void inicio() throws Exception {
          
   }

   public void ejecucion() throws Exception {
		traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - ejecucion ***");
      rastreo();
      setTrazaFichero();
      
		 try  {
            accion = conectorParametroLimpia("accion", "", true);
				opcionMenu = conectorParametroLimpia("opcionMenu", "", true);						
				pais = UtilidadesSession.getPais(this); 
				idioma = UtilidadesSession.getIdioma(this);
				

				if (accion.equals("")) {
						inicializar(); 
				}
				else {
						if (accion.equals("guardar")) {
								guardar();
						}
						else {
								if (accion.equals("modificar")) {
										modificarEncuestaAplicadaCliente();
								}
								else {
										if (accion.equals("detalle")) {
  												detalleEncuestaAplicadaCliente();
										}
								}
							}
					}
		      
			}catch ( Exception e )  {
                traza("....Excepcion LPMantenimientoEncuestaAplicadaAClientes - opcionMenu: " + opcionMenu);
										
                              if ((opcionMenu.equals("InsertarEncuestaAplicadaAClientes")) || 
											(opcionMenu.equals("ModificarEncuestaAplicadaAClientes")) ){
												cargarPGInsertarEncuestaAplicadaAClientes();
												 asignarAtributo("CTEXTO", "txtCodCliente", "valor", conectorParametro("txtCodCliente"));
												 asignarAtributo("VAR", "hPregunta", "valor", conectorParametro("oidPregunta"));
												 asignarAtributo("VAR", "hRespuesta", "valor", conectorParametro("oidRespuesta"));
												 asignarAtributo("VAR", "oidEncuestaAplicadaCliente", "valor", conectorParametro("oidEncuestaAplicadaCliente"));
												 asignarAtributo("VAR", "oidCliente", "valor", conectorParametro("oidCliente"));
												 asignarAtributo("VAR", "oidPregunta", "valor", conectorParametro("cbPregunta"));
												 asignarAtributo("VAR", "oidRespuesta", "valor", conectorParametro("cbRespuesta"));
												 asignarAtributo("VAR", "recupera", "valor", "S");
                              }
									   logStackTrace(e);
                              lanzarPaginaError(e);
          }
			

          traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - ejecucion ***");			 
    }

    private void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                    
                    traza("Stack Trace: " + baos.toString());
     }

	private void inicializar() throws Exception {
		traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - inicializar ***");
		
			opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			traza(" **** opcionMenu : " + opcionMenu);
			
			if (opcionMenu.equals("InsertarEncuestaAplicadaAClientes")) {
   				cargarPGInsertarEncuestaAplicadaAClientes();
			
			}
			else {
	 			if (opcionMenu.equals("ModificarEncuestaAplicadaAClientes") || opcionMenu.equals("ConsultarEncuestaAplicadaAClientes") 
																					|| opcionMenu.equals("EliminarEncuestaAplicadaAClientes")) {
				   					
					cargarPGConsultarEncuestaAplicadaAClientes();
				}
			}
		traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - inicializar ***");		
	}

	public void guardar()throws Exception{
   	traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - guardar ***");
	
		DTOEncuestaAplicadaPorCliente dtoEAC = crearDTOEncuestaAplicadaPorCliente(); 
		MareBusinessID businessID = new MareBusinessID("MAEActualizarEncuestaAplicadaCliente");
		
		Vector parametros = new Vector();
		parametros.add(dtoEAC);  
		parametros.add(businessID);
		
		traza("**** ANTES DE CONECTAR  ****");
		conectar("ConectorActualizarEncuestaAplicadaCliente", parametros);
		traza("**** DESPUES DE CONECTAR  ***");

		cargarPGInsertarEncuestaAplicadaAClientes();

		if(opcionMenu.equals("ModificarEncuestaAplicadaAClientes")){
					asignarAtributo("VAR", "cerrar", "valor", "S");
		}

		traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - guardar ***");
	}
	
	public void detalleEncuestaAplicadaCliente() throws Exception{
		traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - detalleEncuestaAplicadaCliente ***");
		DTOEncuestaAplicadaPorCliente dtoEAC = obtenerEncuestaAplicadaPorCliente();
		cargarPGInsertarEncuestaAplicadaAClientes();
		mostrarDatosEncuestaAplicadaClientes(dtoEAC);
		
		asignarAtributo("VAR", "habilitarEdicionCampos", "valor","N");

		traza("*** Salida- LPMantenimientoEncuestaAplicadaAClientes  - detalleEncuestaAplicadaCliente ***");
	}
	
	public DTOEncuestaAplicadaPorCliente obtenerEncuestaAplicadaPorCliente()  throws Exception{
		traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - obtenerEncuestaAplicadaPorCliente ***");
	
		DTOOID dtoID = new DTOOID();
		sOidEncuestaCliente = conectorParametroLimpia("oidEncuestaCliente", "", true);
		dtoID.setOid(Long.valueOf(sOidEncuestaCliente));
						
		MareBusinessID idBusiness = new MareBusinessID("MAEObtenerEncuestaAplicadaCliente");
		Vector parametros = new Vector();
		parametros.add(dtoID);
		parametros.add(idBusiness);
																					
		traza("******** Antes de conectar");
		DruidaConector conect = conectar("ConectorObtenerEncuestaAplicadaCliente", parametros);
		traza("******** Despues de conectar");
																														
		DTOEncuestaAplicadaPorCliente dtoEA = (DTOEncuestaAplicadaPorCliente)conect.objeto("DTOEncuestaAplicadaPorCliente");

		traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - obtenerEncuestaAplicadaPorCliente ***");
		return dtoEA;

	} 


	/**
		Muestra en la página PGInsertarEncuestaAplicadaAClientes los datos recibidos en 
		el DTOEncuestaAplicadaPorCliente 
	*/
	public void mostrarDatosEncuestaAplicadaClientes (DTOEncuestaAplicadaPorCliente DTOE)  throws Exception{
	   traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - mostrarDatosEncuestaAplicadaClientes ***");	

		sOidEncuestaCliente = DTOE.getOid() != null ? DTOE.getOid().toString(): "";
		asignarAtributo("VAR", "oidEncuestaAplicadaCliente", "valor", sOidEncuestaCliente);     
		
		sOidCliente = DTOE.getOidCliente() != null ? DTOE.getOidCliente().toString(): "";
		asignarAtributo("VAR", "oidCliente", "valor", sOidCliente);     
	
		sCodigoCliente = DTOE.getCodigoCliente() != null ? DTOE.getCodigoCliente().toString(): "";
		asignarAtributo("VAR", "codigoCliente", "valor", sCodigoCliente);    
		asignarAtributo("CTEXTO", "txtCodCliente", "valor", sCodigoCliente);     

		sOidPregunta = DTOE.getOidPregunta() != null ? DTOE.getOidPregunta().toString(): "";
		asignarAtributo("VAR", "oidPregunta", "valor", sOidPregunta);     

		sOidRespuesta = DTOE.getOidRespuesta() != null ? DTOE.getOidRespuesta().toString(): "";
		asignarAtributo("VAR", "oidRespuesta", "valor", sOidRespuesta);     

	   traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - mostrarDatosEncuestaAplicadaClientes ***");	
	}
	
	public void modificarEncuestaAplicadaCliente() throws Exception{
		traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - modificarEncuestaAplicadaCliente ***");
	
		sOidEncuestaCliente = conectorParametroLimpia("oidEncuestaCliente", "", true);
		oidEncuestaAplicadaCliente   = Long.valueOf(sOidEncuestaCliente);
		DTOEncuestaAplicadaPorCliente dtoEAC = obtenerEncuestaAplicadaPorCliente();
		cargarPGInsertarEncuestaAplicadaAClientes();
		mostrarDatosEncuestaAplicadaClientes(dtoEAC);
		
		traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - modificarEncuestaAplicadaCliente ***");
	}


	/**
		Recupera los valores de la página PGInsertarEncuestaAplicadaAClientes y los guarda 
		en un DTOEncuestaAplicadaPorCliente 
	*/
	public DTOEncuestaAplicadaPorCliente crearDTOEncuestaAplicadaPorCliente() throws Exception{
   traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - crearDTOEncuestaAplicadaPorCliente ***");
		
		 DTOEncuestaAplicadaPorCliente dtoEAC = new DTOEncuestaAplicadaPorCliente(); 	
         dtoEAC.setOidPais(pais);
		 dtoEAC.setOidIdioma(idioma);
		 if (opcionMenu.equals("InsertarEncuestaAplicadaAClientes")) {
   				dtoEAC.setOid(null);
					
	    }else{
					// oidEncuestaAplicadaCliente variable de la página PGInsertarEncuestaAplicadaAClientes 				
					sOidEncuestaCliente = conectorParametroLimpia("oidEncuestaAplicadaCliente", "", true);
					dtoEAC.setOid(Long.valueOf(sOidEncuestaCliente));		 
		 }

         sOidCliente = conectorParametroLimpia("oidCliente", "", true);
		 dtoEAC.setOidCliente(sOidCliente.equals("")? null:Long.valueOf(sOidCliente));

		 sTxtCodigoCliente = conectorParametroLimpia("txtCodCliente", "", true);
		 dtoEAC.setCodigoCliente(sTxtCodigoCliente);

		 sOidPregunta = conectorParametroLimpia("cbPregunta", "", true);
		 dtoEAC.setOidPregunta(Long.valueOf(sOidPregunta));

		 sOidRespuesta = conectorParametroLimpia("cbRespuesta", "", true);
		 dtoEAC.setOidRespuesta(Long.valueOf(sOidRespuesta));	

	traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - crearDTOEncuestaAplicadaPorCliente ***");
	return dtoEAC;	
	}
		
	public void cargarPGConsultarEncuestaAplicadaAClientes()throws Exception{
	traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - cargarPGConsultarEncuestaAplicadaAClientes ***");
		
			traza("***    0  ****** ");
				pagina("contenido_encuestas_clientes_consultar");
			traza("***    1  ****** ");
            this.getFormatosValidaciones();
		  traza("***    2  ****** ");
			   DTOBelcorp dtoe = new DTOBelcorp();			  		
				pais = UtilidadesSession.getPais(this); 
				idioma = UtilidadesSession.getIdioma(this);
			traza("***    3  ****** ");
				dtoe.setOidPais(pais);
				dtoe.setOidIdioma(idioma);
			traza("***    4  ****** ");
		      ComposerViewElementList lista = new ComposerViewElementList();
			traza("***    5  ****** ");
				/*Obtenemos las preguntas*/	
				ComposerViewElement elem1 = new ComposerViewElement();							
				elem1.setIDBusiness("MAEObtenerPreguntasEncuesta");

				elem1.setDTOE(dtoe);
			 traza("***    6  ****** ");
				lista.addViewElement(elem1);

	//		   Invocar al  subsistema GestorCargaPantalla
			 traza("***    7  ****** ");
				ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
								
		      traza("*** antes del conector ejecucion***");
				conector.ejecucion();
				traza("*** despues del conector ejecucion ***");

				DruidaConector resultados = conector.getConector();

				traza("*** despues conector.getConector ***");

				asignar("COMBO", "cbPregunta", resultados, "MAEObtenerPreguntasEncuesta");

				if(opcionMenu.equals("ConsultarEncuestaAplicadaAClientes")){
					traza("*** ConsultarEncuestaAplicadaAClientes");						
					getConfiguracionMenu("LPMantenimientoEncuestaAplicadaAClientes","consultar");
					//this.asignarAtributoPagina("cod", "01042");
					asignarAtributoPagina("cod", "01042");
					//asignarAtributo("VAR", "habilitaBtnDetalle", "valor","N");
				
				}			
			traza("***    8  ****** ");
				if(opcionMenu.equals("ModificarEncuestaAplicadaAClientes")){
          traza("*** ModificarEncuestaAplicadaAClientes");
					getConfiguracionMenu("LPMantenimientoEncuestaAplicadaAClientes","modificar");
					//this.asignarAtributoPagina("cod", "01043");
					asignarAtributoPagina("cod", "01043");
					//asignarAtributo("VAR", "habilitaBtnModificar", "valor","N");
				}
			traza("***    9  ****** ");
				if(opcionMenu.equals("EliminarEncuestaAplicadaAClientes")){
          traza("*** EliminarEncuestaAplicadaAClientes");
					getConfiguracionMenu("LPMantenimientoEncuestaAplicadaAClientes","eliminar");
					//this.asignarAtributoPagina("cod", "01044");
					asignarAtributoPagina("cod", "01044");
					//asignarAtributo("VAR", "habilitaBtnEliminar", "valor","S");

				}
				traza("***    10  ****** ");
				asignarAtributo("VAR", "accion", "valor",accion);
				asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
				asignarAtributo("VAR", "pais", "valor", pais.toString());
				asignarAtributo("VAR", "idioma", "valor", idioma.toString());						
				
			traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - cargarPGConsultarEncuestaAplicadaAClientes ***");	
	 

	 }


	public void cargarPGInsertarEncuestaAplicadaAClientes()throws Exception{
	traza("*** Entrada - LPMantenimientoEncuestaAplicadaAClientes  - cargarPGInsertarEncuestaAplicadaAClientes ***");	
				/*
Mostrar la página PGInsertarEncuestaAplicadaAClientes pasándole además: 
- accion 
- opcionMenu*/

   			pagina("contenido_encuestas_clientes_insertar");
            this.getFormatosValidaciones();
		  
			   DTOBelcorp dtoe = new DTOBelcorp();			  		
				pais = UtilidadesSession.getPais(this); 
				idioma = UtilidadesSession.getIdioma(this);

				dtoe.setOidPais(pais);
				dtoe.setOidIdioma(idioma);

		      ComposerViewElementList lista = new ComposerViewElementList();
	
				ComposerViewElement elem1 = new ComposerViewElement();
				elem1.setIDBusiness("MAEObtenerPreguntasEncuesta");

				elem1.setDTOE(dtoe);
				lista.addViewElement(elem1);

//				Invocar al subsistema GestorCargaPantalla 
         	ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());

		      traza("*** antes del conector ejecucion***");
				conector.ejecucion();
				traza("*** despues del conector ejecucion ***");
				DruidaConector resultados = conector.getConector();

				asignar("COMBO", "cbPregunta", resultados, "MAEObtenerPreguntasEncuesta");

				if(opcionMenu.equals("InsertarEncuestaAplicadaAClientes")){

					getConfiguracionMenu("LPMantenimientoEncuestaAplicadaAClientes","insertar");
					//this.asignarAtributoPagina("cod", "01041"); 
					asignarAtributoPagina("cod", "01041"); 
					//asignarAtributo("VAR", "habilitaBtBuscarCliente", "valor","S");
				}
				if(opcionMenu.equals("ConsultarEncuestaAplicadaAClientes")){

					getConfiguracionMenu("LPMantenimientoEncuestaAplicadaAClientes","detalle");
					this.asignarAtributoPagina("cod", "01045");
					//asignarAtributo("VAR", "habilitaBtGuardar", "valor","N");
				}

				if(opcionMenu.equals("EliminarEncuestaAplicadaAClientes")){
					getConfiguracionMenu("LPMantenimientoEncuestaAplicadaAClientes","detalle");
					//this.asignarAtributoPagina("cod", "01044");
					asignarAtributoPagina("cod", "01045");

				}

				if(opcionMenu.equals("ModificarEncuestaAplicadaAClientes")){
   					getConfiguracionMenu("LPMantenimientoEncuestaAplicadaAClientes","modificarDetalle");
                   //this.asignarAtributoPagina("cod", "01043");
				   asignarAtributoPagina("cod", "01043");
				}
				
				if(accion.equals("modificar")){
					asignarAtributo("VAR", "habilitaTxtCodCliente", "valor","N");
				}
			
				asignarAtributo("VAR", "accion", "valor",accion);
				asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
				asignarAtributo("VAR", "pais", "valor", pais.toString());
				asignarAtributo("VAR", "idioma", "valor", idioma.toString());						

		traza("*** Salida - LPMantenimientoEncuestaAplicadaAClientes  - cargarPGInsertarEncuestaAplicadaAClientes ***");	
	}
 
}
