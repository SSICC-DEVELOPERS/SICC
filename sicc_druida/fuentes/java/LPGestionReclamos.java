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
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.rec.DTODesbloqueoRechazoREC;
import es.indra.sicc.dtos.rec.DTOBuscarReclamosREC;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPGestionReclamos extends LPSICCBase {
          
	private String accion = "";
	private String opcion = "";
	private Long idioma;
	private Long pais;
	
	public LPGestionReclamos() {
	        super();
	}
	
	public void inicio() throws Exception {
	        
	}
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {         
			traza("*** Entrada - LPGestionReclamos - ejecucion ***"); 
			
			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			traza("Pasa recogida datos de sesion");
			traza("Idioma = "+this.idioma);
			traza("Pais = "+this.pais);
			
			traza("obtencion de la ACCION");
			this.accion = conectorParametroLimpia("accion","", true);
			traza("Accion: "+this.accion);
			
			traza("Obtencion de la OPCION");
			this.opcion = conectorParametroLimpia("opcion","", true);
			traza("Opcion: "+this.opcion);
						
			if(this.accion.equals("gestionar reclamos bloqueados")){
				traza("Antes de llamar a mostrarPgBuscarReclamosBloqueados");
				this.mostrarPgBuscarReclamosBloqueados();
			}
			//Incidencia 14401
			//Se modifica la LPGestionReclamos:
			//ejecucion --> Si acccion="mostrarPgGestionarReclamosBloqueados"{
			//  Llama al metodo mostrarPgGestionarReclamosBloqueados()
			// }
			if(this.accion.equals("mostrarPgGestionarReclamosBloqueados")){
				traza("Antes de llamar a mostrarPgGestionarReclamosBloqueados");  
				this.mostrarPgGestionarReclamosBloqueados();
			}
			// Incidencia 14425
			//Si accion = "detalle" {
 			//Mostrar la ventana PgDetalleReclamosBloqueados, enviando el valor del oid recibido }   
			if(this.accion.equals("detalle")){
				traza("Antes de llamar a mostrarPgDetalleReclamosBloqueados");  
				this.mostrarPgDetalleReclamosBloqueados();
			}
			
			if(this.accion.equals("desbloquear")){
				traza("Antes de llamar a desbloquear");
				this.desbloquear();
			}
			
			if(this.accion.equals("rechazar")){
				traza("Antes de llamar a rechazar");
				this.rechazar();
			}  
			                      
			
			traza("*** Salida - LPGestionReclamos - ejecucion ***"); 
		}catch ( Exception e )  {
		      e.printStackTrace();
		      logStackTrace(e);
		      lanzarPaginaError(e);
		}              
	}
	
	private void mostrarPgBuscarReclamosBloqueados() throws Exception{
		traza("*** Entrada - LPGestionReclamos - mostrarPgBuscarReclamosBloqueados ***"); 
		/* -> Llamar al metodo privado cargaCombos() 
		-> Muestra la pantalla PgBuscarReclamosBloqueados
		*/
		pagina("contenido_reclamos_bloqueados_buscar");
		this.cargaCombos();
		this.cargarCombosMotivo();
		asignar("VAR", "idioma", this.idioma.toString());
		traza("->Idioma : "+this.idioma);
		asignar("VAR", "pais", this.pais.toString());   
		traza("->Pais : "+this.pais);
		getConfiguracionMenu("LPGestionReclamos", "buscar");
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "opcion", this.opcion);
		this.generarHiddenFormatoFecha();
		Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
		asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
		
		traza("*** Salida - LPGestionReclamos - mostrarPgBuscarReclamosBloqueados ***"); 
	}
	
	private void mostrarPgDetalleReclamosBloqueados() throws Exception{
		traza("*** Entrada - LPGestionReclamos - mostrarPgDetalleReclamosBloqueados ***"); 
		/* -> Muestra la pantalla PgDetalleReclamosBloqueados
		*/
		pagina("contenido_reclamos_bloqueados_gestionar_detalle");
		asignar("VAR", "idioma", this.idioma.toString());
		traza("->Idioma : "+this.idioma);
		asignar("VAR", "pais", this.pais.toString());   
		traza("->Pais : "+this.pais);
		asignar("VAR", "oid", conectorParametroLimpia("oid","", true));
       	traza("OID: "+conectorParametroLimpia("oid","", true));
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "opcion", this.opcion);
		getConfiguracionMenu("LPGestionReclamos", "detalle");
		traza("*** Salida - LPGestionReclamos - mostrarPgDetalleReclamosBloqueados ***"); 
	}	
	
	private void cargaCombos() throws Exception{
		traza("*** Entrada - LPGestionReclamos - cargaCombos ***");
		
		DTOBelcorp dtoE = new DTOBelcorp();
		dtoE.setOidPais(this.pais);
		dtoE.setOidIdioma(this.idioma);

		//Crear una lista ComposerViewElementList 
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = new ComposerViewElement(); 

		//operacionReclamos 
		/*Crear un elemento de tipo ComposerViewElement() para cargar las operaciones del reclamo 
		elem.IDBusiness="RECObtenerOperacionesDescripcion"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista 		*/
		elem.setIDBusiness("RECObtenerOperacionesDescripcion");
        elem.setDTOE(dtoE);
        listelem.addViewElement(elem);
        traza("Elemento primero aniadido");
		
		//tipoBloqueo 
		/*Crear un elemento de tipo ComposerViewElement() para cargar las operaciones del reclamo 
		elem.IDBusiness="RECObtenerTiposBloqueo"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista 		*/
		elem = new ComposerViewElement(); 
        elem.setIDBusiness("RECObtenerTiposBloqueo");
        elem.setDTOE(dtoE);
        listelem.addViewElement(elem);
        traza("Elemento segundo aniadido");
		
		//marca 
		/*Crear un elemento de tipo ComposerViewElement() para cargar las marcas 
		elem.IDBusiness="SEGConsultaMarcas"; 
		elem.DTOE=dtoe; 
		elem.posOID=1; 
		elem.posDesc=3; 
		Añadir el elemento a la lista 		*/
		elem = new ComposerViewElement(); 
        elem.setIDBusiness("SEGConsultaMarcas");
        elem.setDTOE(dtoE);
        listelem.addViewElement(elem);
        traza("Elemento tercero aniadido");
		
		//canal 
		/*Crear un elemento de tipo ComposerViewElement() para cargar los canales 
		elem.IDBusiness="SEGConsultaCanales"; 
		elem.DTOE=dtoe; 
		elem.posOID=1; 
		elem.posDesc=3; 
		Añadir el elemento a la lista 		*/
		elem = new ComposerViewElement(); 
        elem.setIDBusiness("SEGConsultaCanales");
        elem.setDTOE(dtoE);
        listelem.addViewElement(elem);
        traza("Elemento cuarto aniadido");
		
		/*Invocar al subsistema GestorCargaPantalla 
		Asignar los combos: 
		- operacionReclamos <- "RECObtenerOperacionesDescripcion" 
		- tipoBloqueo <- "RECObtenerTiposBloqueo" 
		- cbMarca <- "SEGConsultaMarcas" 
		- cbCanal <- "SEGConsultaCanales" 
		*/
		ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
        traza("conector creado");
        conector.ejecucion();
        traza("ejecutado");
        DruidaConector conConsultar = conector.getConector();
        traza("Obtener conConsultar");
        
        asignar("COMBO","cbOperacion", conConsultar,"RECObtenerOperacionesDescripcion");
        asignar("COMBO","cbTipoBloqueo", conConsultar,"RECObtenerTiposBloqueo");
		asignar("COMBO","cbMarca", conConsultar,"SEGConsultaMarcas");
        asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
				
		traza("*** Salida - LPGestionReclamos - cargaCombos ***");
	}
	private void desbloquear() throws Exception{
		traza("*** Entrada - LPGestionReclamos - desbloquear ***");
		/*Si opcion = "reclamo" { 
		- Llamar al metodo de esta LP validarAcceso() 
		- Si se captura excepcion REC-XXXXX { 
		- Mostrar mensaje informativo "El usuario no tiene acceso a alguno de los reclamos seleccionados" } 
		- Si no { 
		- Crear un DTODesbloqueoRechazoREC: 
		dto.oids[] = oids de los registros seleccionados en la lista lstResultados // oid de la cabecera 
		dto.oidMotivo = oid del valor seleccionado en cbMotivoDesbloqueo 
		- Invocar conector ConectorDesbloquearRechazarReclamoGestion enviando el DTOE creado 
		- Crear IDBusiness="RECDesbloquearReclamoGestion" 
		} 
		*/
		
		if(this.opcion.equals("reclamo")){
			traza ("Entra en opcion RECLAMO antes ValidarAcceso");
			pagina("salidaGenerica");
        	asignar("VAR", "cerrarVentana", "false");
			this.validarAcceso();
			traza ("Despues de validar Acceso rellenamos el DTO");
			DTODesbloqueoRechazoREC dto = new DTODesbloqueoRechazoREC();
			ArrayList oids = new ArrayList();
			String oidsLista = conectorParametroLimpia("oidsLista","", true);
			traza ("OIDsLista: "+oidsLista);
			String oidMotivo = conectorParametroLimpia("oidMotivoDesbloqueo","", true);
			traza ("Motivo Rechazo: "+oidMotivo);
			dto.setOidMotivo(new Long(oidMotivo));
			StringTokenizer st = new StringTokenizer(oidsLista,",");
			while(st.hasMoreTokens()){
				String oid = st.nextToken();
				oids.add(new Long(oid));
				traza ("OID del ST: "+ oid);
			}
			dto.setOids(oids);
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma);
			traza("DTO = "+dto);
			Vector paramConector = new Vector();
			paramConector.add(dto);
			paramConector.add(new MareBusinessID("RECDesbloquearReclamoGestion"));            
			traza("Antes de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION RECLAMO");
			DruidaConector conector = conectar("ConectorDesbloquearRechazarReclamoGestion", paramConector);							
			traza("Despues de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION RECLAMO");
			asignarAtributo("VAR", "ejecutar", "valor", "correcto()");
		}
		
		/*
		-> Si opcion = "operacion" { 
		- Llamar al metodo de esta LP validarAcceso() 
		- Si se captura excepcion REC-XXXXX { 
		- Mostrar mensaje informativo "El usuario no tiene acceso a algua de las operaciones seleccionadas" } 
		- Si no { 
		- Crear un DTODesbloqueoRechazoREC: 
		dto.oidsOperacion[] = oids de los registros seleccionados en la lista lstOperaciones // oid de la cabecera 
		dto.oidMotivo = oid del valor seleccionado en cbMotivoDesbloqueo 
		- Invocar conector ConectorDesbloquearRechazarReclamoGestion enviando el DTOE creado 
		- Crear IDBusiness="RECDesbloquearReclamoGestion" 
		}
		*/
		
		if(this.opcion.equals("operacion")){
			traza("Entra en opcion OPERACION antes ValidarAcceso");
			pagina("salidaGenerica");
        	asignar("VAR", "cerrarVentana", "false");
			this.validarAcceso();
			
			traza("Despues validar acceso rellenamos DTODesbloqueoRechazoREC");
			DTODesbloqueoRechazoREC dto = new DTODesbloqueoRechazoREC();
			ArrayList oids = new ArrayList();
			String oidsLista = conectorParametroLimpia("oidsLista","", true);
			traza("OidsLista: "+oidsLista);
			String oidMotivo = conectorParametroLimpia("oidMotivoDesbloqueo","", true);
			traza("OidMotivo: "+oidMotivo);
			dto.setOidMotivo(new Long(oidMotivo));
			StringTokenizer st = new StringTokenizer(oidsLista,",");
			while(st.hasMoreTokens()){
				String oid = st.nextToken();
				oids.add(new Long(oid));
				traza("Oid del ST: "+oid);
			}
			dto.setOidsOperacion(oids);
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma);
			Vector paramConector = new Vector();
			paramConector.add(dto);
			paramConector.add(new MareBusinessID("RECDesbloquearReclamoGestion"));            
			traza("Antes de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION OPERACION");
			DruidaConector conector = conectar("ConectorDesbloquearRechazarReclamoGestion", paramConector);							
			traza("Despues de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION OPERACION");  
			asignarAtributo("VAR", "ejecutar", "valor", "correctoOperacion()");          
		}
		
		traza("*** Salida - LPGestionReclamos - desbloquear ***");
	}
	private void rechazar() throws Exception{
		traza("*** Entrada - LPGestionReclamos - rechazar ***");
		/*-> Si opcion = "reclamo" { 
		- Llamar al metodo de esta LP validarAcceso() 
		- Si se captura excepcion REC-XXXXX { 
		- Mostrar mensaje informativo "El usuario no tiene acceso a alguno de los reclamos seleccionados" } 
		- Si no { 
		- Crear un DTODesbloqueoRechazoREC: 
		dto.oids[] = oids de los registros seleccionados en la lista lstResultados // oid de la cabecera 
		dto.oidMotivo = oid del valor seleccionado en cbMotivoRechazo 
		- Invocar conector ConectorDesbloquearRechazarReclamoGestion enviando el DTOE creado 
		- Crear IDBusiness="RECRechazarReclamoGestion" 
		} */
		
		if(this.opcion.equals("reclamo")){
			traza("Entra en OPCION RECLAMO antes ValidarAcceso");	
			pagina("salidaGenerica");
        	asignar("VAR", "cerrarVentana", "false");		
			this.validarAcceso();
			
			traza("Despues validarAcceso se rellena el DTO");
			DTODesbloqueoRechazoREC dto = new DTODesbloqueoRechazoREC();
			ArrayList oids = new ArrayList();
			String oidsLista = conectorParametroLimpia("oidsLista","", true);
			traza("OIDsLista: "+oidsLista);
			String oidMotivo = conectorParametroLimpia("oidMotivoRechazo","", true);
			traza("OidMotivo: "+oidMotivo);
			dto.setOidMotivo(new Long(oidMotivo));
			StringTokenizer st = new StringTokenizer(oidsLista,",");
			while(st.hasMoreTokens()){
				String oid = st.nextToken();
				oids.add(new Long(oid));
				traza("Oid en ST: "+oid);
			}
			dto.setOids(oids);
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma);
			Vector paramConector = new Vector();
			paramConector.add(dto);
			paramConector.add(new MareBusinessID("RECRechazarReclamoGestion"));            
			traza("Antes de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION RECLAMO");
			DruidaConector conector = conectar("ConectorDesbloquearRechazarReclamoGestion", paramConector);							
			traza("Despues de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION RECLAMO");
			asignarAtributo("VAR", "ejecutar", "valor", "correcto()");
		}
		/*-> Si opcion = "operacion" { 
		- Llamar al metodo de esta LP validarAcceso() 
		- Si se captura excepcion REC-XXXXX { 
		- Mostrar mensaje informativo "El usuario no tiene acceso a algua de las operaciones seleccionadas" } 
		- Si no { 
		- Crear un DTODesbloqueoRechazoREC: 
		dto.oidsOperacion[] = oids de los registros seleccionados en la lista lstOperaciones // oid de la cabecera 
		dto.oidMotivo = oid del valor seleccionado en cbMotivoRechazo 
		- Invocar conector ConectorDesbloquearRechazarReclamoGestion enviando el DTOE creado 
		- Crear IDBusiness="RECRechazarReclamoGestion" 
		}*/
		if(this.opcion.equals("operacion")){
			traza("Entra en OPCION OPERACION antes ValidarAcceso");
			pagina("salidaGenerica");
        	asignar("VAR", "cerrarVentana", "false");		
			this.validarAcceso();		
			DTODesbloqueoRechazoREC dto = new DTODesbloqueoRechazoREC();
			ArrayList oids = new ArrayList();
			String oidsLista = conectorParametroLimpia("oidsLista","", true);
			String oidMotivo = conectorParametroLimpia("oidMotivoRechazo","", true);
			dto.setOidMotivo(new Long(oidMotivo));
			StringTokenizer st = new StringTokenizer(oidsLista,",");
			while(st.hasMoreTokens()){
				String oid = st.nextToken();
				oids.add(new Long(oid));
			}
			dto.setOidsOperacion(oids);
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma);
			Vector paramConector = new Vector();
			paramConector.add(dto);
			traza("*** DTO = "+dto);
			paramConector.add(new MareBusinessID("RECRechazarReclamoGestion"));            
			traza("Antes de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION OPERACION");
			DruidaConector conector = conectar("ConectorDesbloquearRechazarReclamoGestion", paramConector);							
			traza("Despues de Conectar ConectorDesbloquearRechazarReclamoGestion OPCION OPERACION");
			asignarAtributo("VAR", "ejecutar", "valor", "correctoOperacion()");
		}
		
		traza("*** Salida - LPGestionReclamos - rechazar ***");
	}
	
	private void validarAcceso() throws Exception{
		traza("*** Entrada - LPGestionReclamos - validarAcceso ***");
		/*Si opcion = "reclamo" { 
		- Crear DTOE de tipo DTOBuscarReclamosREC con los valores recibidos: 
		dto.oidsReclamo[] <-- oids de los valores seleccionados en lstResultados 
		resto de valores del dto a NULL 
		- Invocar conector ConectorObtenerReclamosGestion enviando el DTOE creado 
		- Crear IDBusiness="RECObtenerAutorizacionAcceso" 
		} */
		traza("Opcion: "+this.opcion);
		if(this.opcion.equals("reclamo")){
			traza("Entra en opcion RECLAMO");
			DTOBuscarReclamosREC dto = new DTOBuscarReclamosREC();
			ArrayList oids = new ArrayList();
			String oidsLista = conectorParametroLimpia("oidsLista","", true);
			traza("Lista: "+oidsLista);
			StringTokenizer st = new StringTokenizer(oidsLista,",");
			while(st.hasMoreTokens()){
				String oid = st.nextToken();
				oids.add(new Long(oid));
			}
			dto.setOidsReclamo(oids);
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma); 
			traza("DTO = "+dto);			
			Vector paramConector = new Vector();
			paramConector.add(dto);
			paramConector.add(new MareBusinessID("RECObtenerAutorizacionAcceso"));            
			traza("Antes de Conectar ConectorObtenerAutorizacionAcceso");
			DruidaConector conector = conectar("ConectorObtenerAutorizacionAcceso", paramConector);							
			traza("Despues de Conectar ConectorObtenerAutorizacionAcceso");					
		}
		
		/*Si opcion = "operacion" { 
		- Crear DTOE de tipo DTOBuscarReclamosREC con los valores recibidos: 
		dto.oidsOperaciones[] <-- oids de los valores seleccionados en lstOperaciones 
		resto de valores del dto a NULL 
		- Invocar conector ConectorObtenerReclamosGestion enviando el DTOE creado 
		- Crear IDBusiness="RECObtenerAutorizacionAcceso" 
		}*/
		if(this.opcion.equals("operacion")){
			traza("Entra en opcion OPERACION");
			DTOBuscarReclamosREC dto = new DTOBuscarReclamosREC();
			ArrayList oids = new ArrayList();
			String oidsLista = conectorParametroLimpia("oidsLista","", true);
			StringTokenizer st = new StringTokenizer(oidsLista,",");
			while(st.hasMoreTokens()){
				String oid = st.nextToken();
				oids.add(new Long(oid));
			}
			dto.setOidsOperaciones(oids); 
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma); 
			Vector paramConector = new Vector();
            paramConector.add(dto);
            traza("*** DTO = "+dto);
            paramConector.add(new MareBusinessID("RECObtenerAutorizacionAcceso"));            
            traza("Antes de Conectar ConectorObtenerAutorizacionAcceso");
            DruidaConector conector = conectar("ConectorObtenerAutorizacionAcceso", paramConector);							
            traza("Despues de Conectar ConectorObtenerAutorizacionAcceso");
					
		}
				
		traza("*** Salida - LPGestionReclamos - validarAcceso ***");
	}
	
	private void mostrarPgGestionarReclamosBloqueados() throws Exception{
		/*-> Muestra la pantalla PgGestionarReclamosBloqueados, enviando:
		 - oid del registro seleccionado
		 - oids de los valores seleccionados en el combo operacioneReclamos
		 - oids de los valores seleccionados en el combo tipoBloqueo
		*/
		traza("*** Entrada - LPGestionReclamos - mostrarPgGestionarReclamosBloqueados ***");
		
		pagina("contenido_reclamos_bloqueados_gestionar");
		asignar("VAR", "idioma", this.idioma.toString());
		traza("->Idioma : "+this.idioma);
		asignar("VAR", "pais", this.pais.toString());   
       	traza("->Pais : "+this.pais);
       	getConfiguracionMenu("LPGestionReclamos", "detalle");
       	asignar("VAR", "accion", this.accion);
       	asignar("VAR", "opcion", this.opcion);       	
       	asignar("VAR", "oid", conectorParametroLimpia("oid","", true));
       	traza("OID: "+conectorParametroLimpia("oid","", true));
		asignar("VAR", "oidsOperaciones", conectorParametroLimpia("oidsOperaciones","", true));
		traza("OIDsOperaciones: "+conectorParametroLimpia("oidsOperaciones","", true));
		asignar("VAR", "oidsTiposBloqueo", conectorParametroLimpia("oidsTiposBloqueo","", true));
		traza("OIDsTiposBloqueo: "+conectorParametroLimpia("oidsTiposBloqueo","", true));
		this.cargarCombosMotivo();
		String fila = conectorParametroLimpia("fila","", true);
		this.cargaEtiquetas(fila);
						
		traza("*** Salida - LPGestionReclamos - mostrarPgGestionarReclamosBloqueados ***");
	}
	private void cargaEtiquetas(String fila) throws Exception{
		traza("*** Entrada - LPGestionReclamos - cargaEtiquetas ***");	
		traza("*** FILA = "+fila);
		
		StringTokenizer st = new StringTokenizer(fila,",");
		String numAtencion = st.nextToken();
		String codCliente = st.nextToken();
		String nombreApeCliente = st.nextToken();
		String fechaDoc = st.nextToken();
		String numDocRef = st.nextToken();
		String periodoRef = st.nextToken();
		String totalEnvia = st.nextToken();		
		String totalDevuelve = st.nextToken();
		String saldoAPagar = st.nextToken();
		String fechaReclamo = st.nextToken();
		String estadoCabecera = st.nextToken();
		String motivoBloqueo= st.nextToken();
		
		if(!numAtencion.equals("-"))
			asignarAtributo("LABELC","lblNatencionX","valor",numAtencion);
		if(!codCliente.equals("-"))
			asignarAtributo("LABELC","lblCodClienteX","valor",codCliente);
		if(!nombreApeCliente.equals("-"))
			asignarAtributo("LABELC","lblNomApeClienteX","valor",nombreApeCliente);
		if(!fechaDoc.equals("-"))
			asignarAtributo("LABELC","lblFechaDocX","valor",fechaDoc);
		if(!numDocRef.equals("-"))
			asignarAtributo("LABELC","lblNumDocRefX","valor",numDocRef);
		if(!periodoRef.equals("-"))
			asignarAtributo("LABELC","lblPerRefX","valor",periodoRef);
		if(!totalEnvia.equals("-"))
			asignarAtributo("LABELC","lblTotalEnviaX","valor",totalEnvia);
		if(!totalDevuelve.equals("-"))
			asignarAtributo("LABELC","lblTotalDevuelveX","valor",totalDevuelve);
		if(!saldoAPagar.equals("-"))
			asignarAtributo("LABELC","lblSaldoPagX","valor",saldoAPagar);
		if(!fechaReclamo.equals("-"))
			asignarAtributo("LABELC","lblFechaRecX","valor",fechaReclamo);
		if(!estadoCabecera.equals("-"))
			asignarAtributo("LABELC","lblEstadoCabX","valor",estadoCabecera);
		if(!motivoBloqueo.equals("-"))
			asignarAtributo("LABELC","lblMotivoBloqueoX","valor",motivoBloqueo);
		
		
		traza("*** Salida - LPGestionReclamos - cargaEtiquetas ***");
	}
	
	private void cargarCombosMotivo() throws Exception{

		traza("*** Entrada - LPGestionReclamos - cargarCombosMotivo ***");
		/*Documentation
		Crear un DTOBelcorp dtoe con: 
		- pais = Pais activo 
		- idioma = Idioma del usuario */
		DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(this.pais);
        dtoe.setOidIdioma(this.idioma);
		
		//Crear una lista ComposerViewElementList 
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = new ComposerViewElement(); 
				
		//cbMotivoDesbloqueo 
		/*Crear un elemento de tipo ComposerViewElement() para cargar las operaciones del reclamo 
		elem.IDBusiness="RECObtenerMotivosRechazoDesbloqueo"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista */
		elem.setIDBusiness("RECObtenerMotivosRechazoDesbloqueo");
        elem.setDTOE(dtoe);
        listelem.addViewElement(elem);
        traza("Elemento primero aniadido");
		
		//cbMotivoRechazo 
		/*Crear un elemento de tipo ComposerViewElement() para cargar las operaciones del reclamo 
		elem.IDBusiness="RECObtenerMotivosRechazoDesbloqueo"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista */
		
		// con crear un elemento vale
		/*elem = new ComposerViewElement(); 
        elem.setIDBusiness("RECObtenerMotivosRechazoDesbloqueo");
        elem.setDTOE(dtoe);
        listelem.addViewElement(elem);
        traza("Elemento segundo aniadido");
        */
		
		/*Invocar al subsistema GestorCargaPantalla 
		Asignar los combos: 
		- cbMotivoDesbloqueo <- "RECObtenerMotivoRechazoDesbloqueo"   cbMotivoDesbloqueo
		- cbMotivoRechazo <- "RECObtenerMotivoRechazoDesbloqueo"   cbMotivoRechazo
		*/
		ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
        traza("conector creado");
        conector.ejecucion();
        traza("ejecutado");
        DruidaConector conConsultar = conector.getConector();
        traza("Obtener conConsultar");
        
        asignar("COMBO","cbMotivoDesbloqueo", conConsultar,"RECObtenerMotivosRechazoDesbloqueo");
        asignar("COMBO","cbMotivoRechazo", conConsultar,"RECObtenerMotivosRechazoDesbloqueo");
		traza("*** Salida - LPGestionReclamos - cargarCombosMotivo ***");
	}
		
	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());		
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);		
	      traza("Stack Trace: " + baos.toString());
	}	
}