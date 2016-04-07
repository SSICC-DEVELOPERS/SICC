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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.Date;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.cal.DTOInterfazIVR;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;
import es.indra.sicc.dtos.cal.DTOMensajeCallCenter; //18381
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.util.StringTokenizer;

public class LPRecepcionLlamadas extends LPSICCBase {
	private String accion = null;
	private String casoUso = null;
	private String oidTipoCliente = null;

	public LPRecepcionLlamadas() {
		super();
	}

	public void inicio() throws Exception {

	}
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {         
			traza("LPRecepcionLlamadas Entrada");
			Long idioma = UtilidadesSession.getIdioma(this);
			Long pais = UtilidadesSession.getPais(this);
			this.accion = conectorParametroLimpia("accion","", true);
			traza("[MAH]accion definida : "+accion);
			
			if(this.accion.equals("")){
				this.cargarPGRecepcionarLlamadas(pais, idioma);
			}
			if(this.accion.equals("Buscar Por Telefono")){
				this.obtenerClientePorTelefono(pais, idioma);
			}
			if(this.accion.equals("Buscar")){
				//se llama desde la PGDatosSeleccion del CU Presentar clientes -consultas internas- 
				this.mostrarPGBuscarClientes(pais, idioma);
			}
			traza("LPRecepcionLlamadas Salida");
	          }catch ( Exception e )  {
	                    e.printStackTrace();
	                    logStackTrace(e);
	                    lanzarPaginaError(e);
	          }              
	}

	//18381
	private void cargarPGRecepcionarLlamadas(Long idioma, Long pais) throws Exception {
	        traza("[MAH]LPRecepcionLlamadas - cargarPGRecepcionarLlamadas - Entrada");
	        
	        // Cargar la pagina 
	        pagina("contenido_llamadas_recepcionar");

	        //Rellena datos generales de la pagina
	        asignarAtributo("VAR", "idioma", "valor", idioma.toString());
	        asignarAtributo("VAR", "pais", "valor", pais.toString());

	        //Título de la pantalla
	        asignarAtributo("PAGINA","contenido_llamadas_recepcionar","cod","0559");
	        this.getConfiguracionMenu("LPRecepcionLlamadas", "");

	        DTOBelcorp dto = new DTOBelcorp();
			dto.setOidPais(pais);
			dto.setOidIdioma(idioma);

			Vector paramConector = new Vector();
			
			paramConector.add(dto);
			paramConector.add(new MareBusinessID("CALObtenerMensajeCallCenter"));
			traza("Antes de Conectar ConectorObtenerMensajeCallCenter");
			DruidaConector conector = conectar("ConectorObtenerMensajeCallCenter", paramConector);
			traza("******Conector-Mensajes = ", conector);
			/*DTOString  dtoS = (DTOString)conector.objeto("DTOString");
			traza("******Mensaje = " + dtoS);
			if (dtoS != null && dtoS.getCadena() != null) {
		        asignarAtributo("PAGINA", "contenido_llamadas_recepcionar", "msgle", dtoS.getCadena());
		        asignar("VAR", "mensaje", dtoS.getCadena());
			}*/

			DTOMensajeCallCenter  dtoS = (DTOMensajeCallCenter)conector.objeto("dtoSalida");
			traza("******Mensaje = " + dtoS);
			if (dtoS != null && dtoS.getTextoMensaje() != null) {
		        //asignarAtributo("PAGINA", "contenido_llamadas_recepcionar", "msgle", dtoS.getTextoMensaje());
		        asignar("VAR", "mensaje", dtoS.getTextoMensaje());
	    	}

			//Debería quedar como un texto que se mueve continuamente, es decir, un mensaje que aparece de derecha a izquierda continuamente
	        
	        //Habilitar el boton buscar
	        asignarAtributoElemento("btnBuscar","disabled","N");
	        traza("[MAH]LPRecepcionLlamadas - cargarPGRecepcionarLlamadas - Salida");
	}
	
	private void obtenerClientePorTelefono(Long pais, Long idioma) throws Exception {
		traza("[MAH]LPRecepcionLlamadas - obtenerClientePorTelefono - Entrada");
		// Obtiene el teléfono de la PGRecepcionarLlamadas 
		DTOInterfazIVR DTOE = new DTOInterfazIVR();
		String parametro = conectorParametroLimpia("telefono","", true);
		Long telefono = null;
		if(!parametro.equals(""))
			telefono = new Long(parametro);
		DTOE.setTelefono(telefono);
		DTOE.setOidPais(pais);
		DTOE.setOidIdioma(idioma);
		Vector paramConector = new Vector();
            	
            	paramConector.add(DTOE);
            	paramConector.add(new MareBusinessID("CALObtenerClientePorTelefono"));
            	traza("Antes de Conectar ConectorObtenerClientePorTelefono");
		DruidaConector conector = conectar("ConectorObtenerClientePorTelefono", paramConector);
		traza("Despues de Conectar ConectorObtenerClientePorTelefono");
		traza("prueba = ",conector);
		//Guardamos los datos recuperados en la LP 
		//Incidencias: 12600 y 12598.
		DTOInterfazIVR  DTOS = (DTOInterfazIVR)conector.objeto("DTOInterfazIVR");
		traza("DTOS = "+DTOS);
		telefono = DTOS.getTelefono();
		traza("Telefono: "+telefono);
		String oidCliente = null;
		String oidTipoCliente = null;
		if (DTOS.getOidCliente()!=null){
			oidCliente = (DTOS.getOidCliente()).toString();
			traza("Oid cliente: "+oidCliente);
		}
		if (DTOS.getOidTipoCliente()!=null){
			oidTipoCliente = (DTOS.getOidTipoCliente()).toString();
			traza("Oid Tipo Cliente: "+oidTipoCliente);
		}

		if(oidCliente==null) //modificado 13023
		{
			this.mostrarPGBuscarClientes(pais, idioma);
		}else{
			this.mostrarPGFichaCliente(telefono, oidCliente, oidTipoCliente);
		}
		traza("[MAH]LPRecepcionLlamadas - obtenerClientePorTelefono - Salida");
	}         
	          
	private void mostrarPGBuscarClientes(Long pais, Long idioma) throws Exception {
		traza("[MAH]LPRecepcionLlamadas - mostrarPGBuscarClientes - Entrada");
		//Muestra la página PGBuscarClientes 
		pagina("contenido_llamadas_clientes_buscar");
		//Rellena datos generales de la pagina
	        asignarAtributo("VAR", "idioma", "valor", idioma.toString());
	        asignarAtributo("VAR", "pais", "valor", pais.toString());
		
		Byte longitudCodClien = this.obtenerLongitudCodigoCliente();
		asignar("VAR","longitudCodigoCliente", longitudCodClien.toString());
	        
	        //Título de la pantalla
	        asignarAtributo("PAGINA","contenido_llamadas_clientes_buscar","cod","0559");
	        asignarAtributo("PAGINA","contenido_llamadas_clientes_buscar","msgle","Recepcionar pantallas");
	        this.getConfiguracionMenu("LPRecepcionLlamadas", "Buscar");
	        DTOBelcorp dtoe = new DTOBelcorp();
	        dtoe.setOidPais(pais);
	        dtoe.setOidIdioma(idioma);
	        traza("DTOBelcorp dtoe= "+dtoe);
		//Crear una lista ComposerViewElementList 
		ComposerViewElementList listelem = new ComposerViewElementList();
                // TIPOS DOCUMENTO 
                
                ComposerViewElement elemTipoDoc = new ComposerViewElement();
                elemTipoDoc.setIDBusiness(new String("MAEObtenerTiposDocumentoPorPais")); //MAEObtenerTiposDocumentoPorPais
                elemTipoDoc.setDTOE(dtoe);
                listelem.addViewElement(elemTipoDoc);
                
                // MARCAS 
                ComposerViewElement elemMarcas = new ComposerViewElement();
                elemMarcas.setIDBusiness(new String("SEGConsultaMarcas")); //SEGConsultaMarcas
                elemMarcas.setDTOE(dtoe);
                listelem.addViewElement(elemMarcas);
                // CANALES 
                ComposerViewElement elemCanales = new ComposerViewElement();
                elemCanales.setIDBusiness(new String("SEGConsultaCanales")); //SEGConsultaCanales
                elemCanales.setDTOE(dtoe);
                listelem.addViewElement(elemCanales);
		//Invocar al subsistema GestorCargaPantalla 
		traza("[MAH]Antes del conector");
		//Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		traza("[MAH]Despues del conector");
		//Asigna los combos: 
		//- cbTipoDocumento 
		//- cbMarca 
		//- cbCanal 
		asignar("COMBO","cbTipoDoc", conConsultar, "MAEObtenerTiposDocumentoPorPais"); 
		asignar("COMBO","cbMarca" , conConsultar, "SEGConsultaMarcas"); 
		asignar("COMBO","cbCanal" , conConsultar, "SEGConsultaCanales"); 
		//Activa la página PGBuscarClientes 
		//Se habilita el botón Buscar 
		asignarAtributoElemento("btnBuscar","disabled","N");
		//Enviar a la página la variable accion 
		asignarAtributo("VAR", "accion", "valor", this.accion);
		traza("[MAH]LPRecepcionLlamadas - mostrarPGBuscarClientes - Salida");
	}
        
        private void mostrarPGFichaCliente(Long telefono, String codigoCliente, String codigoTipoCliente) throws Exception {
        	traza("[MAH]LPRecepcionLlamadas - mostrarPGFichaCliente - Entrada");
        	//se invoca al CU Presentar clientes 
		/*Activar LPPresentarClientes con: 
		- accion="Ver Ficha" 
		- telefono 
		- codigoCliente 
		- codigoTipoCliente */
		conectorAction("LPPresentarClientes");
		conectorActionParametro("accion","Ver Ficha");
		conectorActionParametro("telefono",telefono.toString());
		conectorActionParametro("oidCliente",codigoCliente); //modificado por incidencia 13023
		conectorActionParametro("oidTipoCliente",codigoTipoCliente);
		traza("[MAH]LPRecepcionLlamadas - mostrarPGFichaCliente - Salida");
        }
                  
	private void logStackTrace(Throwable e) throws Exception {
		traza("[MAH]Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("[MAH]Stack Trace: " + baos.toString());
	}         
}                 
                  
                  
                  
                  
                  
                  
                  