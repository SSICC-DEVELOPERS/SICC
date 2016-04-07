/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
  
import es.indra.sicc.dtos.rec.DTOAutorizacion;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Vector;


public class LPMantenimientoAutorizacion extends LPSICCBase {

	private String accion = null;
	private String opcionMenu = null;

	private Long idioma = null;
	private Long pais = null;

	private Long oidAutorizacion = null;
    private String cbUsuario = null;
    private String cbOperacion = null;
    private String cbTipoOperacion = null;
    private String impMaximo = null;
    private String impMaxDifer = null;
    private String ingreso = null;
    private String desbloqueo = null;


	public LPMantenimientoAutorizacion() {
		super();
	}

	
	public void inicio() throws Exception { }


	public void ejecucion() throws Exception {

		rastreo();
		try {
			setTrazaFichero(); 
	    	traza("*** Entrada - LPMantenimientoAutorizacion - ejecucion ***");

			this.pais = UtilidadesSession.getPais(this);
			this.idioma = UtilidadesSession.getIdioma(this);

			accion = conectorParametroLimpia("accion", "", true);
			opcionMenu = conectorParametroLimpia("opcionMenu", "", true);


			traza("***** accion: " + accion);
			traza("***** opcionMenu: " + opcionMenu);


					  if (accion.equals("")) {
                          inicializar();
                      } else {
                              if (accion.equals("guardar")) {
                                  this.guardar();
                              } else {
                                      if (accion.equals("modificar")) {
                                          this.modificarAutorizacion();
                                      } else {
                                              if (accion.equals("detalle")) {
                                                this.detalleAutorizacion();
                                              }
                                        }
                                }
                        }

			traza("*** Salida - LPMantenimientoAutorizacion - ejecucion ***");
		} catch (Exception e) {
			 logStackTrace(e);
			 lanzarPaginaError(e);
		}

	}


	private void inicializar() throws Exception {

		traza("*** Entrada - LPMantenimientoAutorizacion - inicializar ***");
		
		
          this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
          traza(" **** opcionMenu : " + this.opcionMenu);

		try	{
			if (this.opcionMenu.equals("InsertarAutorizacion")) {
				this.cargarPGInsertarAutorizacion();
			} else if (opcionMenu.equals("ModificarAutorizacion")
						|| opcionMenu.equals("ConsultarAutorizacion")
						|| opcionMenu.equals("EliminarAutorizacion")) {
				this.cargarPGConsultarAutorizacion();
						traza("*** aca por detalle  ***");

			}
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - inicializar ***");
	}



	private void cargarPGInsertarAutorizacion() throws Exception {

		traza("*** Entrada - LPMantenimientoAutorizacion - cargarPGInsertarAutorizacion ***");
		
		try{
			pagina("contenido_mantenimiento_autorizaciones_insertar");
			getFormatosValidaciones();

			DTOBelcorp dtoe = new DTOBelcorp();
			dtoe.setOidPais(this.pais);
			dtoe.setOidIdioma(this.idioma);

			traza("*** dtoe: " + dtoe);

			ComposerViewElementList list = new ComposerViewElementList();

			// Obtenemos los usuarios
			ComposerViewElement elem = new ComposerViewElement();
			elem.setIDBusiness("MENObtenerCodUsuarios");
			elem.setDTOE(dtoe);
			list.addViewElement(elem);

			// Obtenemos las operaciones
			elem = new ComposerViewElement();
			elem.setIDBusiness("RECObtenerOperacionesDescLarga");
			elem.setDTOE(dtoe);
			list.addViewElement(elem);

		    ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
			conector.ejecucion();

			traza("*** antes de conectar");	
			DruidaConector drdConector = conector.getConector();
			traza("*** despues de conectar ");

			// Asigno los combos...
			asignar("COMBO", "cbCodUsuario", drdConector, "MENObtenerCodUsuarios"); 
			asignar("COMBO", "cbCodOperacion", drdConector, "RECObtenerOperacionesDescLarga");
			
			
			// Cargo titulo y menu secundario
			if (accion.equals("")) {
				asignarAtributoPagina("cod", "RecAutor.create.label");
				getConfiguracionMenu("LPMantenimientoAutorizacion", "InsertarAutorizacion");
			} else if (accion.equals("modificar")) {
				asignarAtributoPagina("cod", "RecAutor.update.label");
				getConfiguracionMenu("LPMantenimientoAutorizacion", "detalleModificar");
			} else if (accion.equals("detalle")) {
				getConfiguracionMenu("LPMantenimientoAutorizacion", "detalle");
				asignarAtributoPagina("cod", "RecAutor.view.label");

			}

			asignar("VAR", "varPais", this.pais.toString());
			asignar("VAR", "varIdioma", this.idioma.toString());
			asignar("VAR", "opcionMenu", this.opcionMenu);
			asignar("VAR", "accion", this.accion);

			traza("*** pais: " + this.pais);
			traza("*** idioma: " + this.idioma);


	

			// La deshabilitación del botón Guardar para el CU Consultar se hace en el JavaScript
			// Ídem para la deshabilitación de combos para la accion "modificar"
			
		} catch (Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - cargarPGInsertarAutorizacion ***");
	}


	private void guardar() throws Exception {

		traza("*** Entrada - LPMantenimientoAutorizacion - guardar ***");
		
		try	{
			pagina("salidaGenerica");

            this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");      

	        asignarAtributo("VAR","ejecutar","valor","guardoCorrectamente('" + opcionMenu + "')");
            asignarAtributo("VAR","ejecutarError","valor","noPudoGuardar()");

			DTOAutorizacion dtoAuto = this.crearDTOAutorizacion();
			traza("*** dtoAuto: " + dtoAuto);

			MareBusinessID idBusiness = new MareBusinessID("RECActualizarAutorizacion");

			Vector paramsEntrada = new Vector();
			paramsEntrada.add(dtoAuto);
			paramsEntrada.add(idBusiness);
					
			try	{
				traza("*** Antes de conectar para guardar");
				DruidaConector conector = conectar("ConectorActualizarAutorizacion", paramsEntrada);
				traza("*** Despues de conectar para guardar");
			} catch (Exception e) {
				asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar();");
				throw e;
			}

			//asignarAtributo("VAR", "ejecutar", "valor", "limpiarCampos()");
			if(opcionMenu.equals("ModificarAutorizacion")){
					asignarAtributo("VAR", "cerrar", "valor", "S");
          
			}
				
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - guardar ***");

	}


	private DTOAutorizacion crearDTOAutorizacion() throws Exception {
		traza("*** Entrada - LPMantenimientoAutorizacion - crearDTOAutorizacion ***");

		DTOAutorizacion dto = new DTOAutorizacion();

		if (opcionMenu.equals("InsertarAutorizacion")) {
			dto.setOid(null);
		} else {
			String strOid = conectorParametroLimpia("hOid", "", true);
			dto.setOid(new Long(strOid));
		}
		traza("oid: " + dto.getOid());


		String strOidUsuario = conectorParametroLimpia("hOidUsuario", "", true);
		String strOidOperacion = conectorParametroLimpia("hOidOperacion", "", true);
		String strOidTipoOperacion = conectorParametroLimpia("hOidTipoOperacion", "", true);
		String strImporteMaximo = conectorParametroLimpia("hImporteMaximo", "", true);
		String strMontoMaximoDiferencia = conectorParametroLimpia("hMontoMaximoDiferencia", "", true);
		String strIngreso = conectorParametroLimpia("hIngreso", "", true);
		String strDesbloqueo = conectorParametroLimpia("hDesbloqueo", "", true);

		traza("Información recuperada de la página:");
		traza("*** oidUsuario: " + strOidUsuario);
		traza("*** oidOperacion: " + strOidOperacion);
		traza("*** oidTipoOperacion: " + strOidTipoOperacion);
		traza("*** importeMaximo: " + strImporteMaximo);
		traza("*** montoMaximoDiferencia: " + strMontoMaximoDiferencia);
		traza("*** ingreso: " + strIngreso);
		traza("*** desbloqueo: " + strDesbloqueo);

		dto.setOidUsuario(new Long(strOidUsuario));
		dto.setOidOperacion(new Long(strOidOperacion));
		dto.setOidTipoOperacion(new Long(strOidTipoOperacion));
		dto.setOidPais(this.pais);

		if (strImporteMaximo != null & strImporteMaximo.length() > 0) {
			dto.setImporteMaximo(new BigDecimal(strImporteMaximo));
		} else {
			dto.setImporteMaximo(null);
		}

		if (strMontoMaximoDiferencia != null && strMontoMaximoDiferencia.length() > 0) {
			dto.setMontoMaximoDiferencia(new BigDecimal(strMontoMaximoDiferencia));
		} else {
			dto.setMontoMaximoDiferencia(null);
		}

		if (strIngreso.equalsIgnoreCase("S")) {
			dto.setIngreso(Boolean.TRUE);
		} else {
			dto.setIngreso(Boolean.FALSE);
		}

		if (strDesbloqueo.equalsIgnoreCase("S")) {
			dto.setDesbloqueo(Boolean.TRUE);
		} else {
			dto.setDesbloqueo(Boolean.FALSE);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - crearDTOAutorizacion ***");
		return dto;
	}


	private void cargarPGConsultarAutorizacion() throws Exception {
		traza("*** Entrada - LPMantenimientoAutorizacion - cargarPGConsultarAutorizacion ***");

		try	{
			
			pagina("contenido_mantenimiento_autorizaciones_consultar");
			
			DTOBelcorp dtoe = new DTOBelcorp();
			dtoe.setOidPais(this.pais);
			dtoe.setOidIdioma(this.idioma);

			ComposerViewElementList list = new ComposerViewElementList();
			ComposerViewElement elem;

			// Obtenemos los usuarios
			elem = new ComposerViewElement();
			elem.setIDBusiness("MENObtenerCodUsuarios");
			elem.setDTOE(dtoe);
			list.addViewElement(elem);

			// Obtenemos las operaciones
			elem = new ComposerViewElement();
			elem.setIDBusiness("RECObtenerOperacionesDescLarga");
			elem.setDTOE(dtoe);
			list.addViewElement(elem);

			ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
			conector.ejecucion();

			traza("*** antes de conectar");
			DruidaConector drdConector = conector.getConector();
			traza("*** despues de conectar");

			// Asigno los combos
			asignar("COMBO", "cbCodUsuario", drdConector, "MENObtenerCodUsuarios");
			asignar("COMBO", "cbCodOperacion", drdConector, "RECObtenerOperacionesDescLarga");




			// Cargo titulo y menu secundario
			if (opcionMenu.equals("ConsultarAutorizacion")) {
				asignarAtributoPagina("cod", "RecAutor.query.label");
				getConfiguracionMenu("LPMantenimientoAutorizacion", "ConsultarAutorizacion");
			} else if (opcionMenu.equals("ModificarAutorizacion")) {
				asignarAtributoPagina("cod", "RecAutor.update.label");
				getConfiguracionMenu("LPMantenimientoAutorizacion", "ModificarAutorizacion");
			} else if (opcionMenu.equals("EliminarAutorizacion")) {
				asignarAtributoPagina("cod", "RecAutor.remove.label");
				getConfiguracionMenu("LPMantenimientoAutorizacion", "EliminarAutorizacion");
			}

			asignar("VAR", "varPais", this.pais.toString());
			asignar("VAR", "varIdioma", this.idioma.toString());

			asignar("VAR", "opcionMenu", this.opcionMenu);
			asignar("VAR", "accion", this.accion);

			traza("*** pais: " + this.pais);
			traza("*** idioma: " + this.idioma);


			// El ocultamiento de los botones Detalle, Modificar, Eliminar
			// se realizará mediante JavaScript cuando corresponda
		}
		catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - cargarPGConsultarAutorizacion ***");
	}

	private void modificarAutorizacion() throws Exception {

		traza("*** Entrada - LPMantenimientoAutorizacion - modificarAutorizacion ***");

		try
		{
/*			String strOidAutorizacion = conectorParametroLimpia("oidAutorizacion", "", true);
			this.oidAutorizacion = new Long(strOidAutorizacion);
			traza("*** oidAutorizacion: " + this.oidAutorizacion);

			DTOAutorizacion dtoAuto = this.obtenerAutorizacion();
			traza("*** DTOAutorizacion obtenido: " + dtoAuto);
			this.mostrarDatosAutorizacion(dtoAuto);
*/

			this.cargarPGInsertarAutorizacion();
			
			String strOidAutorizacion = conectorParametroLimpia("hOid", "", true);
			traza("*** strOidAutorizacion ***" + strOidAutorizacion);
			//oidAutorizacion = new Long(strOidAutorizacion);
			
			//traza("*** oidAutorizacion ***" + oidAutorizacion);
			cbUsuario = conectorParametroLimpia("hOidUsuario", "", true);
            cbOperacion = conectorParametroLimpia("hOidOperacion", "", true);
        	cbTipoOperacion = conectorParametroLimpia("hOidTipoOperacion", "", true);
        	impMaximo = conectorParametroLimpia("hImporteMaximo", "", true);
        	impMaxDifer = conectorParametroLimpia("hMontoMaximoDiferencia", "", true); 
         	ingreso = conectorParametroLimpia("hIngreso", "", true);
        	desbloqueo = conectorParametroLimpia("hDesbloqueo", "", true);
			

            //Asigno los campos
            asignarAtributo("VAR", "hOid", "valor", strOidAutorizacion);
			asignarAtributo("VAR", "hOidUsuario", "valor", cbUsuario);
            asignarAtributo("VAR", "hOidOperacion", "valor", cbOperacion);
            asignarAtributo("VAR", "hOidTipoOperacion", "valor", cbTipoOperacion);
            asignarAtributo("VAR", "hImporteMaximo", "valor", impMaximo);
            asignarAtributo("VAR", "hMontoMaximoDiferencia", "valor", impMaxDifer);
            asignarAtributo("VAR", "hIngreso", "valor", ingreso);
            asignarAtributo("VAR", "hDesbloqueo", "valor", desbloqueo);



		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - modificarAutorizacion ***");
	}


	private void detalleAutorizacion() throws Exception {
		traza("*** Entrada - LPMantenimientoAutorizacion - detalleAutorizacion ***");

		try	{

			this.cargarPGInsertarAutorizacion();

			cbUsuario = conectorParametroLimpia("hOidUsuario", "", true);
            cbOperacion = conectorParametroLimpia("hOidOperacion", "", true);
        	cbTipoOperacion = conectorParametroLimpia("hOidTipoOperacion", "", true);
        	impMaximo = conectorParametroLimpia("hImporteMaximo", "", true);
        	impMaxDifer = conectorParametroLimpia("hMontoMaximoDiferencia", "", true); 
         	ingreso = conectorParametroLimpia("hIngreso", "", true);
        	desbloqueo = conectorParametroLimpia("hDesbloqueo", "", true);

            //Asigno los campos
            asignarAtributo("VAR", "hOidUsuario", "valor", cbUsuario);
            asignarAtributo("VAR", "hOidOperacion", "valor", cbOperacion);
            asignarAtributo("VAR", "hOidTipoOperacion", "valor", cbTipoOperacion);
            asignarAtributo("VAR", "hImporteMaximo", "valor", impMaximo);
            asignarAtributo("VAR", "hMontoMaximoDiferencia", "valor", impMaxDifer);
            asignarAtributo("VAR", "hIngreso", "valor", ingreso);
            asignarAtributo("VAR", "hDesbloqueo", "valor", desbloqueo);

			// La deshabilitación de todos los campos se realiza mediante JavaScript

		}
		catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - detalleAutorizacion ***");
	}


	private void mostrarDatosAutorizacion(DTOAutorizacion dtoe) throws Exception {
		traza("*** Entrada - LPMantenimientoAutorizacion - mostrarDatosAutorizacion ***");
		try	{
			asignar("VAR", "hOid", dtoe.getOid().toString());
			asignar("VAR", "hOidUsuario", dtoe.getOidUsuario().toString());
			asignar("VAR", "hOidOperacion", dtoe.getOidOperacion().toString());
			asignar("VAR", "hOidTipoOperacion", dtoe.getOidTipoOperacion().toString());

			String strImporteMaximo = (dtoe.getImporteMaximo() != null)?
					UtilidadesBelcorp.formateaNumeroSICC(dtoe.getImporteMaximo().toString(), this.FORMATO_DEFAULT, this) : "";
			asignar("VAR", "hImporteMaximo", strImporteMaximo);


			String strMontoMaximoDiferencia = (dtoe.getMontoMaximoDiferencia() != null)?
					UtilidadesBelcorp.formateaNumeroSICC(dtoe.getMontoMaximoDiferencia().toString(), this.FORMATO_DEFAULT, this) : "";
			asignar("VAR", "hMontoMaximoDiferencia", strMontoMaximoDiferencia);

			if (Boolean.TRUE.equals(dtoe.getIngreso()))
				asignar("VAR", "hIngreso", "S");
			else
				asignar("VAR", "hIngreso", "N");

			if (Boolean.TRUE.equals(dtoe.getDesbloqueo()))
				asignar("VAR", "hDesbloqueo", "S");
			else
				asignar("VAR", "hDesbloqueo", "N");

		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - mostrarDatosAutorizacion ***");
	}


	
	
	private DTOAutorizacion obtenerAutorizacion() throws Exception {

		traza("*** Entrada - LPMantenimientoAutorizacion - obtenerAutorizacion ***");
		DTOAutorizacion dtoAuto = null;

		try	{
			DTOOID dtoOid = new DTOOID();
			dtoOid.setOid(this.oidAutorizacion);
			dtoOid.setOidPais(this.pais);
			dtoOid.setOidIdioma(this.idioma);

			MareBusinessID businessId = new MareBusinessID("RECObtenerAutorizacion");
			Vector parametros = new Vector();
			parametros.add(dtoOid);
			parametros.add(businessId);

			traza("*** Antes de conectar para obtener autorizacion");
			DruidaConector drdConector = conectar("ConectorObtenerAutorizacion", parametros);
			traza("*** Luego de conectar, autorizacion obtenida");

			dtoAuto = (DTOAutorizacion)drdConector.objeto("dtoSalida");			
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}

		traza("*** Salida - LPMantenimientoAutorizacion - obtenerAutorizacion ***");
		return dtoAuto;
	}



	
	protected void logStackTrace(Throwable e) throws Exception {  
       traza("Se produjo la excepcion: " + e.getMessage());       
	                                                              
	   ByteArrayOutputStream baos = new ByteArrayOutputStream();  
       PrintStream ps = new PrintStream(baos);                    
       e.printStackTrace(ps);                                     
                                                                  
       traza("Stack Trace: " + baos.toString());                  
    } 
}




