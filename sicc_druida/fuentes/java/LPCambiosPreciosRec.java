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


import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import es.indra.druida.DruidaConector;


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

import java.util.Vector;
import java.util.StringTokenizer;

import java.math.BigDecimal;

import es.indra.sicc.dtos.rec.DTOCargaListas;
import es.indra.sicc.dtos.rec.DTOGuardarModificacion;
import es.indra.sicc.dtos.rec.DTORecuperarCabeGen;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

 
public class LPCambiosPreciosRec extends LPSICCBase {

	private Long idioma = null; 
    private Long pais = null;
    private String accion = null;
    private String separadorMiles = null;
    private String separadorDecimales = null;
	
	
	public LPCambiosPreciosRec() {
    	super();
    }
    
    public void inicio() throws Exception {

    }

	public void ejecucion() throws Exception {
    	
    	setTrazaFichero();
        traza("*** Entrada - LPCambiosPreciosRec - ejecucion ***");
        try  {
      		this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion","",true);
            traza("Accion definida : "+this.accion);

			this.separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
            this.separadorMiles = ",";
            if (this.separadorDecimales.equals(",")) {
            	this.separadorMiles = ".";
            }
            traza("separador miles(al darle valor): " + this.separadorMiles);
            traza("separador decimales(al darle valor): " + this.separadorDecimales);
			
			/*Si accion="inicializar" { 
			llama al metodo mostrarPantallaBuscar() 
			muestra la PantallaBuscarCambiosPrecios 
			} */
			if(this.accion.equals("inicializar")){
				traza("***Entrada Accion inicializar ***");
				pagina("contenido_masivos_buscar");
				asignarAtributo("VAR","accion","valor",this.accion);
                asignar("VAR", "idioma", this.idioma.toString());
                traza("->Idioma : "+this.idioma);
                asignar("VAR", "pais", this.pais.toString());   
                traza("->Pais : "+this.pais);
                this.generarHiddenFormatoFecha();
                Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
                asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
				getConfiguracionMenu("LPCambiosPreciosRec", "");
				this.mostrarPantallaBuscar();	
				
				traza("***Salida Accion inicializar ***");
			}
			/*
			Si accion="modificar" { 
			- Crear un DTOE del tipo DTOCargaListas con : (además del pais y el idioma) 
			- el oidCabecera (primer campo) de la lista 
			- indicador = 0 
			- Invocar al conector ConectorRecuperarCabeceraGeneracion con el DTOE 
			- Crear IDBusiness="RECRecuperarCabeceraGeneracion" 
			
			- Mostrar la ventana modal y emergente PantallaDetalleGeneracionCambios asignando: 		
			
			} */
			if(this.accion.equals("modificar")){
				traza("***Entrada Accion modificar ***");
				DTOCargaListas dtoE = new DTOCargaListas();
				String oid = conectorParametroLimpia("oid","",true);
				traza("*** OID = "+oid);
				String codVenta = conectorParametroLimpia("codVenta","",true); 
				traza("*** codVenta = "+codVenta);
				String codVentaGen = conectorParametroLimpia("codVentaGen","",true); 
				traza("*** codVentaGen = "+codVentaGen);
								
				dtoE.setOidCabecera(new Long(oid));
				dtoE.setIndicador(new Integer(0));
				
				Vector paramConector = new Vector();
				paramConector.add(dtoE);
                paramConector.add(new MareBusinessID("RECRecuperarCabeceraGeneracion"));            
                traza("Antes de Conectar ConectorRecuperarCabeceraGeneracion");
                DruidaConector conector = conectar("ConectorRecuperarCabeceraGeneracion", paramConector);							
                traza("Despues de Conectar ConectorRecuperarCabeceraGeneracion");
                Object objeto=conector.objeto("DTORecuperarCabeGen");
                traza("Objeto recogido"+objeto);
                DTORecuperarCabeGen salida = (DTORecuperarCabeGen)conector.objeto("DTORecuperarCabeGen");
                traza("DTORecuperarCabeGen obtenido");
				
				pagina("contenido_cambios_precios_masivos_detalle");
				asignarAtributo("VAR","accion","valor",this.accion);
                asignar("VAR", "idioma", this.idioma.toString());
                traza("->Idioma : "+this.idioma);
                asignar("VAR", "pais", this.pais.toString());   
                traza("->Pais : "+this.pais);
                asignarAtributo("PAGINA","contenido_cambios_precios_masivos_detalle", "cod", "0160");
                asignarAtributo("PAGINA","contenido_cambios_precios_masivos_detalle", "msgle", "Mantener Masivos");
                /*- y a las variables ocultas: 
				- modificar = true 
				- guardado = true  
				- oidCabecera = oidCabecera recibido de la pantallaBuscarCambiosPrecios 
				*/
				asignarAtributo("VAR","modificar","valor", "true");
                asignarAtributo("VAR","guardado","valor","true");
				asignarAtributo("VAR","oidCabecera","valor",oid);
				getConfiguracionMenu("LPCambiosPreciosRec", "mantenerMasivos");
                
                //se asigna los valores a la pagina
				//- codVentaOrigen = codVenta recibido de la pantallaBuscarCambiosPrecios 
				asignarAtributo("LABELC","lbldtCodigoVentaOrigen","valor",codVenta);
				//- codVentaDestino = codVentaGenerar recibido de la pantallaBuscarCambiosPrecios 
				asignarAtributo("LABELC","lbldtCodigoVentaDestino","valor",codVentaGen);
				//- descripcionCatalogoOrigen = DTORecuperarCabeGen.descripcionOrigen 
				if(salida.getDescripcionOrigen() != null)
					asignarAtributo("LABELC","lbldtDescripcionOrigen","valor",salida.getDescripcionOrigen());
				//- descripcionCatalogoDestino = DTORecuperarCabeGen.descripcionDestino 
				if(salida.getDescripcionDestino() != null)
					asignarAtributo("LABELC","lbldtDescripcionDestino","valor",salida.getDescripcionDestino());
				//- precioCatalogoOrigen = DTORecuperarCabeGen.precioCatalogoOrigen 
				if(salida.getPrecioCatalogoOrigen() != null)
					asignarAtributo("LABELC","lbldtPrecioCatalogoOrigen","valor",salida.getPrecioCatalogoOrigen().toString());
				//- precioCatalogoOrigen = DTORecuperarCabeGen.precioCatalogoOrigen 
				if(salida.getPrecioCatalogoDestino() != null)
					asignarAtributo("LABELC","lbldtPrecioCatalogoDestino","valor",salida.getPrecioCatalogoDestino().toString());
				
				//- lstNoGenerar = DTORecuperarCabeGen.lstNoGenerar 
				if(salida.getLstNoGenerar() != null){
					RecordSet rs = salida.getLstNoGenerar();
					
                	Vector cols = null;
                	DruidaConector conectorCargaLista = null; 	
                	if (rs != null ) {
                		cols = rs.getColumnIdentifiers();
                	    conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, cols);
                	    asignar("LISTAEDITABLE", "listado2", conectorCargaLista, "DTOSalida.combo_ROWSET");
                	}	
                }	
				
				traza("***Salida Accion modificar ***");
			}
			
			/*			
			Si accion = "guardar" { 
			- Crear un DTOE del tipo DTOGuardarModificacion con el oidCabecera y la lstNoGenerar recibidos de la pantalla (además del pais y el idioma) 
			- Invocar al conector ConectorGuardarModificacionREC con el DTOE 
			- Crear IDBusiness="RECGuardarModificacionREC" 
			} 
			*/

			// se modifica por incidencia BELC300020340
			// tambien se recibe de la pagina la lista de detalles, que se debe enviar tambien a negocio

			if(this.accion.equals("guardar")) {

					traza("*** Entrada Accion guardar ***");
					
					DTOGuardarModificacion dto = new DTOGuardarModificacion();
					dto.setOidIdioma(this.idioma);
					dto.setOidPais(this.pais);	
					String oidCabecera = conectorParametroLimpia("oidCabecera","",true);
					traza("*** OIDCabecera = "+oidCabecera);
					dto.setOidCabecera(new Long(oidCabecera));
				
					/////////////////////////////////////////////////////////////////////
					// se recogen las listas que llegan como cadenas de texto y se crean RecordSets
					RecordSet rs = null;
					String lista = "";

      			StringTokenizer st = null;
      			StringTokenizer stFila = null;
      			String token = null;
      			String fila = "";
      			Vector vectorFila = null;
      			
      			/////////// campos ambas listas: (para la creación de los RecordSets) 
      			// oidSoliCabe (OID oculto),
      			// oidCliente (columna oculta), cód. cliente, 
      			// nombre 1, nombre 2, apellido 1, apellido 2, 
      			// nº unidades, 
      			// precio catálogo origen, importe neto origen, descuento origen, 
      			// precio catálogo destino, importe neto destino, 
      			// importe diferencia, 
      			// oidTipoSolicitud (columna oculta)
      			// oidPosicionSolicitud (columna oculta) // BELC300019647
      			// oidDetalleGeneracion (columna oculta) // BELC300016257
      			String []nombresColumnas = {"OIDSOLICABE", 
      												"OIDCLIENTE", "CODCLIENTE",
      												"NOMBRE1", "NOMBRE2", "APE1", "APE2",
      												"NUMUNIDADES", 
      												"PRECIOCATALORIG", "IMPORTNETOORIG", "DESCUENTOORIG",
             	                           "PRECIOCATALDEST", "IMPORTNETODEST", 
             	                           "IMPORTDIFER", 
             	                           "OIDTIPOSOLICITUD",
             	                           "OIDPOSICIONSOLICITUD", 
             	                           "OIDDETALLEGENERA"};
      			
      			
					///////////////////////////////////////////////////////////////////// lista detalles
					rs = new RecordSet();
      		   lista = conectorParametroLimpia("reclamosDetalle", "", true);
      			traza("********** lista de reclamos detalles: " + lista);

      			// recuperamos los datos de la lista editable en una cadena con el formato:
      			// las columnas vienen separadas por el caracter @
      			// las filas vienen separadas por el caracter #
      			                        
      			if (! lista.equals("")) {
           
         			st = new StringTokenizer(lista, "#");
         			 
         			rs.setColumnIdentifiers(nombresColumnas);
                	  
          			while (st.countTokens() > 0) {
                		fila = st.nextToken();
                	   if (!fila.equals("")) {
                	   	stFila = new StringTokenizer(fila, "@");
                	    	traza("********** fila: " + fila);
                	 		traza("********** numero de tokens: " + stFila.countTokens());
                	    	
                	 		vectorFila = new Vector();
                	    	
                	 		if (stFila.countTokens() > 0) {
                	    	 	// si en la lista editable el campo de la columna recuperada es vacio nos llega "-"
                	    		// Si en los campos Long y BigDecimal llega "-" los inicializo a 0
                	    		// Si en los campos String llega "-" los inicializo a ""
                	    	    
                	    		// OIDSOLICABE
                	    		token = stFila.nextToken();
                	    		vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
	             	    	   // OIDCLIENTE
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
	             	    	   // CODCLIENTE
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
	             	    	   // NOMBRE1 
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
	             	    	   // NOMBRE2 
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
	             	    	   // APE1 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
                	    	   // APE2 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
                	    	   // NUMUNIDADES 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	   // PRECIOCATALORIG 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // IMPORTNETOORIG 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // DESCUENTOORIG
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // PRECIOCATALDEST 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // IMPORTNETODEST 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // IMPORTDIFER 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // OIDTIPOSOLICITUD
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	   // OIDPOSICIONSOLICITUD
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	   // OIDDETALLEGENERA
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	               
                	    	   rs.addRow(vectorFila);
                	    	}
                		}
             		}
             	}
             	traza("**************** RecordSet con los registros en lista detalles: " + rs);
               dto.setLstDetalles(rs); // es un RecordSet con los campos de la lista de detalle (la primera de la pagina)
					
					
					///////////////////////////////////////////////////////////////////// lista no generar
					rs = new RecordSet();
      		   lista = conectorParametroLimpia("reclamosNoGenerar", "", true);
      			traza("********** lista de reclamos no generar: " + lista);

      			// recuperamos los datos de la lista editable en una cadena con el formato:
      			// las columnas vienen separadas por el caracter @
      			// las filas vienen separadas por el caracter #
      			                        
      			if (! lista.equals("")) {
           
         			st = new StringTokenizer(lista, "#");
         			 
         			rs.setColumnIdentifiers(nombresColumnas);
                	  
          			while (st.countTokens() > 0) {
                		fila = st.nextToken();
                	   if (!fila.equals("")) {
                	   	stFila = new StringTokenizer(fila, "@");
                	    	traza("********** fila: " + fila);
                	 		traza("********** numero de tokens: " + stFila.countTokens());
                	    	
                	 		vectorFila = new Vector();
                	    	
                	 		if (stFila.countTokens() > 0) {
                	    	 	// si en la lista editable el campo de la columna recuperada es vacio nos llega "-"
                	    		// Si en los campos Long y BigDecimal llega "-" los inicializo a 0
                	    		// Si en los campos String llega "-" los inicializo a ""
                	    	    
                	    		// OIDSOLICABE
                	    		token = stFila.nextToken();
                	    		vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
	             	    	   // OIDCLIENTE
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
	             	    	   // CODCLIENTE
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
	             	    	   // NOMBRE1 
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
	             	    	   // NOMBRE2 
	             	    	   token = stFila.nextToken();
	             	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
	             	    	   // APE1 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
                	    	   // APE2 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new String(! token.equals("-") ? token : ""));
                	    	   // NUMUNIDADES 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	   // PRECIOCATALORIG 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // IMPORTNETOORIG 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // DESCUENTOORIG
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // PRECIOCATALDEST 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // IMPORTNETODEST 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // IMPORTDIFER 
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? obtenerPrecioFormateado(token) : "0"));
                	    	   // OIDTIPOSOLICITUD
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	   // OIDPOSICIONSOLICITUD
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	   // OIDDETALLEGENERA
                	    	   token = stFila.nextToken();
                	    	   vectorFila.add(new BigDecimal(! token.equals("-") ? token : "0"));
                	    	               
                	    	   rs.addRow(vectorFila);
                	    	}
                		}
             		}
             	}
             	traza("**************** RecordSet con los registros en lista no generar: " + rs);
               dto.setLstNoGenerar(rs); // es un RecordSet con los campos de la lista de no generar (la segunda de la pagina)
								
				
					pagina("salidaGenerica");
               asignar("VAR", "cerrarVentana", "false");
                                    
               Vector paramConector = new Vector();
               paramConector.add(dto);
               paramConector.add(new MareBusinessID("RECGuardarModificacionREC"));            
               traza("Antes de Conectar ConectorGuardarModificacionREC");
               DruidaConector conector = conectar("ConectorGuardarModificacionREC", paramConector);							
               traza("Despues de Conectar ConectorGuardarModificacionREC");
			
					asignar("VAR", "ejecutar", "ponerGuardadoTrue()");
					traza("*** Salida Accion guardar ***");
			}			
					
			/*
			Si accion = "anular" { 
			- Crear un DTOE del tipo DTOOid con el oidCabecera (además del pais y el idioma) 
			- Invocar al conector ConectorAnularReclamo con el DTOE 
			- Crear IDBusiness="RECAnularReclamo" 
			
			- Se cierra esta ventana a través de la salida generica 
			}*/
			if(this.accion.equals("anular")){
				traza("***Entrada Accion anular ***");
				DTOOID dto = new DTOOID();
				dto.setOidIdioma(this.idioma);
				dto.setOidPais(this.pais);
				String oidCabecera = conectorParametroLimpia("oidCabecera","",true);
				traza("*** OIDCabecera = "+oidCabecera);
				dto.setOid(new Long(oidCabecera));
				
				pagina("salidaGenerica");
                asignar("VAR", "cerrarVentana", "true");
                
				Vector paramConector = new Vector();
                paramConector.add(dto);
                paramConector.add(new MareBusinessID("RECAnularReclamo"));            
                traza("Antes de Conectar ConectorAnularReclamo");
                DruidaConector conector = conectar("ConectorAnularReclamo", paramConector);							
                traza("Despues de Conectar ConectorAnularReclamo");
				
				traza("***Salida Accion anular ***");
			}
			

        }catch ( Exception e ) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    	traza("*** Salida - LPCambiosPreciosRec - ejecucion ***");
	}
	
	public void mostrarPantallaBuscar() throws Exception{

		traza("*** Entrada - LPCambiosPreciosRec - mostrarPantallaBuscar ***");
		/*Crear un DTOBelcorp dtoe con: 
		- pais = Pais activo 
		- idioma = Idioma del usuario 
		*/
		
		DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(this.pais);
        dtoe.setOidIdioma(this.idioma);
                  
        //Crear una lista ComposerViewElementList 
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = new ComposerViewElement(); 
		 
		
		//Canales 
		/*Crear un elemento de tipo ComposerViewElement() para cargar los canales 
		elem.IDBusiness="SEGConsultaCanales"; 
		elem.DTOE=dtoe; 
		elem.posOID=1; 
		elem.posDesc=3; 
		Añadir el elemento a la lista 
		*/
		elem.setIDBusiness("SEGConsultaCanales");
        elem.setDTOE(dtoe);
        elem.setPosOID(new Byte("0").byteValue()); 
        elem.setPosDesc(new Byte("1").byteValue());
        listelem.addViewElement(elem);
        traza("Elemento 1 aniadido");

		
		//Marcas 
		/*Crear un elemento de tipo ComposerViewElement() para cargar las marcas 
		elem.IDBusiness="SEGConsultaMarcas"; 
		elem.DTOE=dtoe; 
		elem.posOID=1; 
		elem.posDesc=3; 
		Añadir el elemento a la lista 
		*/
		elem = new ComposerViewElement();
        elem.setIDBusiness("SEGConsultaMarcas");
        elem.setDTOE(dtoe);
        elem.setPosOID(new Byte("0").byteValue());
        elem.setPosDesc(new Byte("1").byteValue());        
        listelem.addViewElement(elem);
        traza("Elemento 2 aniadido");
		
		//TipoSolicitud // De seleccion múltiple 
		/*Crear un elemento de tipo ComposerViewElement() para cargar los TipoSolicitudGenera 
		elem.IDBusiness="PEDobtieneTiposSolicitudPorPais"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista 
		*/
		elem = new ComposerViewElement();
        elem.setIDBusiness("PEDconsultaTiposConsolidado");
        elem.setDTOE(dtoe);
        elem.setPosOID(new Byte("0").byteValue());
        elem.setPosDesc(new Byte("1").byteValue());
        listelem.addViewElement(elem);
        traza("Elemento 3 aniadido");
		
		//Codigos Operacion 
		/*Crear un elemento de tipo ComposerViewElement() para cargar los codOperacion 
		elem.IDBusiness="RECObtenerCodigosOperacion"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista 
		*/
		elem = new ComposerViewElement();
        elem.setIDBusiness("RECObtenerCodigosOperacion");
        elem.setDTOE(dtoe);
        elem.setPosOID(new Byte("0").byteValue());
        elem.setPosDesc(new Byte("1").byteValue());
        listelem.addViewElement(elem);
        traza("Elemento 4 aniadido");
		
		//Invocar al subsistema GestorCargaPantalla 
		ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
        traza("conector creado");
        conector.ejecucion();
        traza("ejecutado");
        DruidaConector conConsultar = conector.getConector();
        traza("Obtener conConsultar");
		// cada usuario tiene una marca y canal por defecto que deben seleccionarse
      	Long marca = UtilidadesSession.getMarcaPorDefecto(this);
      	Long canal = UtilidadesSession.getCanalPorDefecto(this);
      
      	// se asignan estos valores a campos ocultos de la pagina
     	asignar("VAR", "oidMarca", marca.toString());
      	asignar("VAR", "oidCanal", canal.toString()); 
		
		/*Asigna los combos: 
		- cbCanal <- SEGConsultaCanales 
		- cbMarca <- SEGConsultaMarcas 
		- cbTipoSolicitud <- PEDobtieneTiposSolicitudPorPais 
		- cbCodOperacion <- RECObtenerCodigosOperacion
		*/
		
        asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales", "VAL_OID", canal.toString()); 
        asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas", "VAL_OID", marca.toString());
        asignar("COMBO","cbTipoSolicitud", conConsultar,"PEDconsultaTiposConsolidado");
        asignar("COMBO","cbCodigoOperacionReclamos", conConsultar,"RECObtenerCodigosOperacion");
		
		traza("*** Salida - LPCambiosPreciosRec - mostrarPantallaBuscar ***");
		
	}
	// esta funcion se utiliza para tratar cantidades monetarias
    // Se obtiene una cadena de texto eliminando el separador de miles y haciendo
    // que el separador de decimales sea '.'
    private String obtenerPrecioFormateado(String cantidad) throws Exception {
         
    	traza("*** Entrada - LPCambiosPreciosREC - obtenerPrecioFormateado ***");
        traza("---- cantidad a formatear: " + cantidad);
  
    	String resultado = new String("");
    	Character separaMiles = new Character(this.separadorMiles.charAt(0));
    	Character car = null;
      
    	// primero eliminamos el separador de miles
      
    	for (int i=0; i < cantidad.length(); i++) {
        	car = new Character(cantidad.charAt(i));
            if (car.compareTo(separaMiles) != 0) {
            	resultado += new String(car.toString());
            }
        }
        resultado = resultado.replace(this.separadorDecimales.charAt(0), '.');
	    traza("---- cantidad formateada: " + resultado);
        traza("*** Salida - LPCambiosDePreciosREC - obtenerPrecioFormateado ***");
        return resultado;
	}	
	
	
    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);
         traza("Stack Trace: " + baos.toString());
    }

}
