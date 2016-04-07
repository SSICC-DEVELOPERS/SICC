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
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ccc.DTONumero;
import es.indra.sicc.dtos.ccc.DTOEntidad;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasDtoRecargo;
import es.indra.sicc.dtos.ccc.DTOCodigoProceso;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.util.DTOSalida;
import java.util.StringTokenizer;

public class LPGenerarDtoRecargo extends LPSICCBase {
         
         private String accion = null;
         private String casoUso = null;
                  
         public LPGenerarDtoRecargo() {
                 super();
         }

         public void inicio() throws Exception {
                  
         }
         public void ejecucion() throws Exception {
            setTrazaFichero();
            
			try{	
			    traza("LPGenerarDtoRecargo Entrada");
			    Long idioma = UtilidadesSession.getIdioma(this);
                Long pais = UtilidadesSession.getPais(this);
                accion = conectorParametroLimpia("accion","", true);
                traza("[MAH]accion definida : "+accion);

                if(accion.equals("insertar")){
				   casoUso = "insertar"; 
				   accionInsertar(idioma,pais);
                }
                
				if(accion.equals("confirmar")){
				   casoUso = "confirmar"; 
                   accionConfirmar(idioma,pais);
                }
			
				if(accion.equals("")){
                   accionVacia(idioma,pais);
                }

				if(accion.equals("borrarBloqueo")){
				   borrarBloqueo();   
				}
                traza("LPGenerarDtoRecargo Salida");
			}catch ( Exception e )  {
                           e.printStackTrace();
                           logStackTrace(e);
                           lanzarPaginaError(e);
            }		
         }

		 private void borrarBloqueo() throws Exception  {
			 traza("*** Entrada - LPGenerarDtoRecargo - borrarBloqueo ***");
			 pagina("salidaGenerica");

			 Vector paramEntrada = new Vector();
			 DTOBelcorp dto = new DTOBelcorp();
		   
			 paramEntrada.add(dto);
			 paramEntrada.add(new MareBusinessID("CCCEliminarBloqueo"));

			 DruidaConector conector = conectar("ConectorEliminarBloqueo", paramEntrada);          

			 traza("*** Salida - LPGenerarDtoRecargo - borrarBloqueo ***");	
	     }

         private void accionVacia(Long idioma, Long pais) throws Exception {
	        traza("[MAH]LPGenerarDtoRecargo - accionVacia - Entrada");
		// Cargar la pagina 
		        pagina("contenido_descuento_recargo_automatico_generar");

			    this.getFormatosValidaciones();

				  /*mdolce Para validar la concurrencia de procesos de CCC*/
					Vector paramEntradaValidar = new Vector();
					DTOBelcorp dtoValidar = new DTOBelcorp();
					/*uso el atributo pais para poder diferenciar luego en el mon que descripcion insertar
					  uso ese atributo para no modificar todo, solo envio una constante y no la uso como pais*/
					dtoValidar.setOidPais(new Long("2"));

					paramEntradaValidar.add(dtoValidar);
					paramEntradaValidar.add(new MareBusinessID("CCCInsertarBloqueo"));  

					DruidaConector conectorValidar = conectar("ConectorRecuperarDatosInicialesCargosAbonos", paramEntradaValidar);

					/*Fin validacion concurrencia*/
		
                //Byte longitud = this.obtenerLongitudCodigoCliente();
                //Long longitudCodigoCliente = new Long(longitud.longValue());
                Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
                asignarAtributo("VAR","longitudCodigoCliente","valor",longitudCodigoCliente.toString());
                
                //Rellena datos generales de la pagina
                asignarAtributo("VAR", "idioma", "valor", idioma.toString());
                asignarAtributo("VAR", "pais", "valor", pais.toString());

		//Título de la pantalla
                asignarAtributo("PAGINA","contenido_descuento_recargo_automatico_generar","cod","0192");
                asignarAtributo("PAGINA","contenido_descuento_recargo_automatico_generar","msgle","Generar descuento recargo automatico");
		this.getConfiguracionMenu("LPGenerarDtoRecargo", "");
                  
                //Guardamos los valores de los separadores
                String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
	      	String separadorMiles = ",";
                if (separadorDecimales.equals(",")) {
                          separadorMiles = ".";
                }
                asignar("VAR","hid_SeparadorMiles", separadorMiles);
                asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
                asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
	
		// Generar hiddens del formato de la fecha
		this.generarHiddenFormatoFecha();

		/*
		Llamamos al GestorCargaPantalla para cargar los COMBOS: 
		empresa (IdBusiness="SEGObtenerEmpresasPorPais"), 
		canales (IdBusiness="SEGConsultaCanales"), 
		subprocesos (IdBusiness="CCCObtieneSubprocesos", codigoProceso="CCC005"). 
		*/

             	ComposerViewElementList listelem = new ComposerViewElementList();
                ComposerViewElement elemEmpresa = null;
		ComposerViewElement elemCanales = null;                           
		ComposerViewElement elemSubprocesos = null;                           
                           
                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                dtoBelcorp.setOidIdioma(idioma);
                dtoBelcorp.setOidPais(pais);
                
	        elemEmpresa=new ComposerViewElement(); 
        	elemEmpresa.setIDBusiness(new String("SEGObtenerEmpresasPorPais")); //SEGObtenerEmpresasPorPais
           	elemEmpresa.setDTOE(dtoBelcorp);
           	listelem.addViewElement(elemEmpresa);

	        elemCanales=new ComposerViewElement(); 
        	elemCanales.setIDBusiness(new String("SEGConsultaCanales")); //SEGConsultaCanales
           	elemCanales.setDTOE(dtoBelcorp);
           	listelem.addViewElement(elemCanales);

                DTOOID dtoOID = new DTOOID();
                dtoOID.setOidIdioma(idioma);
                dtoOID.setOidPais(pais);
		
		
		// Modificado por el nuevo diseño		
		elemSubprocesos=new ComposerViewElement(); 
        	elemSubprocesos.setIDBusiness(new String("CCCObtieneSubprocesosProcesoPais"));
		DTOCodigoProceso dtoCodigoProceso = new DTOCodigoProceso();
		dtoCodigoProceso.setCodigoProceso(CCCConstantes.PROCESO_DTO_RECARGO_AUTO);
		dtoCodigoProceso.setOidPais(pais);
		dtoCodigoProceso.setOidIdioma(idioma);
           	elemSubprocesos.setDTOE(dtoCodigoProceso);
           	listelem.addViewElement(elemSubprocesos);
		/*elemSubprocesos=new ComposerViewElement(); 
        	elemSubprocesos.setIDBusiness(new String("CCCObtieneSubprocesos")); //CCCObtieneSubprocesos
           	elemSubprocesos.setDTOE(dtoBelcorp);
           	listelem.addViewElement(elemSubprocesos);
		*/


             	traza("antes del conector");
                /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
           	conector.ejecucion();
           	DruidaConector conConsultar = conector.getConector();
           
           	traza("despues del conector");
           	/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
           	correspondiente utilizando el String que representa el BusinessID en cada caso. */
                asignar("COMBO","cbEmpresa", conConsultar, "SEGObtenerEmpresasPorPais"); 
                asignar("COMBO","cbCanal" , conConsultar, "SEGConsultaCanales"); 
                asignar("COMBO","cbSubproceso" , conConsultar, "CCCObtieneSubprocesosProcesoPais"); 


		
		/*Generamos el número de cabecera (número de lote) 
		Invocamos al "ConectorObtenerSiguienteNumeroDtoRecargo" con 
		IdBusiness="CCCObtenerSiguienteNumeroDtoRecargo" y pasándole 
		un DTOBelcorp y obtenemos un DTONumero dtoNumero. 
		numero = dtoNumero.numero; */
		
		
		// Asignación del hidden 'numero'
	   	Vector paramConector = new Vector();
	   	paramConector.add(dtoBelcorp);
        	paramConector.add(new MareBusinessID("CCCObtenerSiguienteNumeroDtoRecargo"));           
        	traza("[MAH]Antes de Conectar ConectorObtenerSiguienteNumeroDtoRecargo");
        	DruidaConector conector2 = conectar("ConectorObtenerSiguienteNumeroDtoRecargo", paramConector);							
        	traza("[MAH]Despues de Conectar ConectorObtenerSiguienteNumeroDtoRecargo");
        	Object objeto = conector2.objeto("DTONumero");
        	traza("[MAH]Objeto recogido"+objeto);
        	DTONumero  dtoNumero = (DTONumero)conector2.objeto("DTONumero");
        	traza("[MAH]DTOSalida obtenido");
        	traza("[MAH]DTONumero Valor: "+dtoNumero.getNumero());
        	String num = dtoNumero.getNumero().toString();
        	asignarAtributo("LABELC","lblNLoteActual","valor",(num != null) ? num: "");			
        	asignar("VAR", "numero", dtoNumero.getNumero().toString());
				
		/* VALORES INICIALES
		anio = año de la fecha del sistema 
		mes = mes de la fecha del sistema 
		fechaDoc = fecha del sistema 
		importeFijoDtoRecargo=0; 
		*/

		java.sql.Date fec = new java.sql.Date(System.currentTimeMillis());
		
		// anho
		traza("Anio");
                String anho = new String(fec.toString().substring(2,4));
                asignarAtributo("LABELC","lblAnoActual","valor",(anho != null) ? anho: "");
                asignar("VAR", "anio", anho);
                  
                // mes
                traza("mes");
                String mes = new String(fec.toString().substring(5,7));
                asignarAtributo("LABELC","lblMesActual","valor",(mes != null) ? mes: "");
                asignar("VAR", "mes", mes);
                  
                //Fecha documento- lbldtFechaDoc
                //System.currentTimeMilis()
                Date fechaDoc = new Date();
                traza("fecha");
                String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		String fechaDocumento = null;
                if (fechaDoc != null) {
                         fechaDocumento = UtilidadesBelcorp.fechaFormateada(fechaDoc,formatoFecha);
                }
                traza("FechaDocumento: "+fechaDocumento + "[formatoFecha] "+formatoFecha+ " [fechaDoc] "+fechaDoc);
                asignarAtributo("LABELC","lbldtFechaDoc","valor",fechaDocumento);
		
	
		asignarAtributo("CTEXTO","textImporteFijo","valor","0");

          	traza("[MAH]LPGenerarDtoRecargo - accionVacia - Salida");
         }
         
         private void accionConfirmar(Long idioma, Long pais) throws Exception {
	        traza("[MAH]LPGenerarDtoRecargo - accionConfirmar - Entrada");		
		pagina("salidaGenerica");
		//Creamos un array de DTOEntidad con el array de 2 columnas (oid y entidad) recibido de la pantalla.                                                                        
		String parametro = null;
		StringTokenizer st = null; 
		int tam = 0;
		Long[] oids = null;
		Integer[] entidades = null;
		Long empresa = null;
		Long subproceso = null;
		String referenciaExterna = null;
		String observaciones = null;
		String clienteDesde = null;
		String clienteHasta = null;
		Long canal = null;
		Long acceso = null;
		Long subacceso = null;
		Date fechaDocD = null;
		Date fechaDocH = null;
		Date fechaVenD = null;
		Date fechaVenH = null;
		Integer diasCadencia = null;
		Integer diasCorte = null;
		BigDecimal tipoInteres = null;
		BigDecimal importeFijo = null;
		String mes = null;
		String anio = null;
		Integer numero = null;
		parametro = conectorParametroLimpia("oids", "", true);
		traza("**********OIDS: " + parametro);
		if(!parametro.equals("")) {
			st = new StringTokenizer(parametro, ",");
			tam = st.countTokens();
			traza("tam = "+tam);
			oids = new Long[tam];
			for(int i=0; i<tam; i++) {
				Long oid = new Long(st.nextToken());
				traza("oid = "+oid);
				oids[i]=oid;
			}
		}
		parametro = conectorParametroLimpia("entidades", "", true);
		traza("**********ENTIDADES: " + parametro);
		if(!parametro.equals("")) {
			st = new StringTokenizer(parametro, ",");
			tam = st.countTokens();
			traza("tam = "+tam);
			entidades = new Integer[tam];
			for(int i=0; i<tam; i++) {
				Integer entidad = new Integer(st.nextToken());
				traza("entidad = "+entidad);
				entidades[i]=entidad;
			}
		}
		traza("oids = "+oids);
		traza("entidades = "+entidades);
		DTOEntidad[] dtoEntidades = new DTOEntidad[tam];
		for(int j=0; j<tam; j++) {
			DTOEntidad dtoEntidad = new DTOEntidad();
			dtoEntidad.setOid(oids[j]);
			dtoEntidad.setEntidad(entidades[j]);
			dtoEntidad.setOidPais(pais);
			dtoEntidad.setOidIdioma(idioma);
			dtoEntidades[j]=dtoEntidad;
		}
		traza("dtoEntidades = "+dtoEntidades);
		// Obtengo los valores procedentes de la página	
		//empresa
		parametro = conectorParametroLimpia("cbEmpresa", "", true);
		if(!parametro.equals("")) {
			empresa = new Long(parametro);
		}
		traza("empresa = "+empresa);
		//subproceso
		parametro = conectorParametroLimpia("cbSubproceso", "", true);
		if(!parametro.equals("")) {
			subproceso = new Long(parametro);
		}
		traza("subproceso = "+subproceso);
		//referencia externa
		parametro = conectorParametroLimpia("textReferenciaExterna", "", true);
		if(!parametro.equals("")) {
			referenciaExterna = parametro;
		}
		traza("referenciaExterna = "+referenciaExterna);
		//observaciones
		parametro = conectorParametroLimpia("textObservaciones", "", true);
		if(!parametro.equals("")) {
			observaciones = parametro;
		}
		traza("observaciones = "+observaciones);
		//canal
		parametro = conectorParametroLimpia("cbCanal", "", true);
		if(!parametro.equals("")) {
			canal = new Long(parametro);
		}
		traza("canal = "+canal);
		//acceso
		parametro = conectorParametroLimpia("cbAcceso", "", true);
		if(!parametro.equals("")) {
			acceso = new Long(parametro);
		}
		traza("acceso = "+acceso);
		//subacceso
		parametro = conectorParametroLimpia("cbSubacceso", "", true);
		if(!parametro.equals("")) {
			subacceso = new Long(parametro);
		}
		traza("subacceso = "+subacceso);
		//cliente desde
		parametro = conectorParametroLimpia("textClienteD", "", true);
		if(!parametro.equals("")) {
			clienteDesde = parametro;
		}
		traza("clienteDesde = "+clienteDesde);
		//cliente hasta
		parametro = conectorParametroLimpia("textClienteH", "", true);
		if(!parametro.equals("")) {
			clienteHasta = parametro;
		}
		traza("clienteHasta = "+clienteHasta);
		//fecha documento desde
		parametro = conectorParametroLimpia("textFechaDocD", "", true);
		if(!parametro.equals("")) {
			//fechaDocD = UtilidadesFecha.convertirAFecha(parametro,"dd-MM-yyyy");
			fechaDocD = UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this));
		}
		traza("fecha documento desde = "+fechaDocD);
		//fecha documento hasta
		parametro = conectorParametroLimpia("textFechaDocH", "", true);
		if(!parametro.equals("")) {
			//fechaDocH = UtilidadesFecha.convertirAFecha(parametro,"dd-MM-yyyy");
			fechaDocH = UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this));
		}
		traza("fecha documento hasta = "+fechaDocH);
		//fecha vencimiento desde
		parametro = conectorParametroLimpia("textFechaVenD", "", true);
		if(!parametro.equals("")) {
			//fechaVenD = UtilidadesFecha.convertirAFecha(parametro,"dd-MM-yyyy");
			fechaVenD = UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this));
		}
		traza("fecha vencimiento desde = "+fechaVenD);
		//fecha vencimiento hasta
		parametro = conectorParametroLimpia("textFechaVenH", "", true);
		if(!parametro.equals("")) {
			//fechaVenH = UtilidadesFecha.convertirAFecha(parametro,"dd-MM-yyyy");
			fechaVenH = UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this));
		}
		traza("fecha vencimiento hasta = "+fechaVenH);
		//dias cadencia
		parametro = conectorParametroLimpia("textDiasCadencia", "", true);
		if(!parametro.equals("")) {
			diasCadencia = new Integer(parametro);
		}
		//dias corte
		parametro = conectorParametroLimpia("textDiasCorte", "", true);
		if(!parametro.equals("")) {
			diasCorte = new Integer(parametro);
		}
		//tipo interes
		parametro = conectorParametroLimpia("textTipoInteres", "", true);
		if(!parametro.equals("")) {
			tipoInteres = new BigDecimal(parametro);
		}
		//impuesto fijo
		parametro = conectorParametroLimpia("textImporteFijo", "", true);
		if(!parametro.equals("")) {
			importeFijo = new BigDecimal(parametro);
		}
		//anio
		parametro = conectorParametroLimpia("anio", "", true);
		if(!parametro.equals("")) {
			anio = parametro;
		}
		//mes
		parametro = conectorParametroLimpia("mes", "", true);
		if(!parametro.equals("")) {
			mes = parametro;
		}
		//numero
		parametro = conectorParametroLimpia("numero", "", true);
		if(!parametro.equals("")) {
			numero = new Integer(parametro);
		}
		/*String lista = conectorParametroLimpia("listaRegistros","",true);*/
		
		//Creamos un DTOBuscarCuotasDtoRecargo con todos los datos recibidos del formulario y 
		//asignándole (seleccionados) el objeto array de tipo DTOEntidad que acabamos de crear. 
		DTOBuscarCuotasDtoRecargo dtoBuscarCuotas = new DTOBuscarCuotasDtoRecargo();
		dtoBuscarCuotas.setOidPais(pais);
		dtoBuscarCuotas.setOidIdioma(idioma);		
		dtoBuscarCuotas.setSeleccionados(dtoEntidades);
		dtoBuscarCuotas.setOidEmpresa(empresa);
		dtoBuscarCuotas.setOidSubproceso(subproceso);
		dtoBuscarCuotas.setRefExterna(referenciaExterna);
		dtoBuscarCuotas.setObservaciones(observaciones);
		dtoBuscarCuotas.setOidCanal(canal);
		dtoBuscarCuotas.setOidAcceso(acceso);
		dtoBuscarCuotas.setOidSubacceso(subacceso);
		dtoBuscarCuotas.setCodigoClienteDesde(clienteDesde);
		dtoBuscarCuotas.setCodigoClienteHasta(clienteHasta);
		dtoBuscarCuotas.setFechaDocDesde(fechaDocD);
		dtoBuscarCuotas.setFechaDocHasta(fechaDocH);
		dtoBuscarCuotas.setFechaVtoDesde(fechaVenD);
		dtoBuscarCuotas.setFechaVtoHasta(fechaVenH);
		dtoBuscarCuotas.setDiasCadencia(diasCadencia);
		dtoBuscarCuotas.setDiasCorte(diasCorte);
		dtoBuscarCuotas.setTipoInteres(tipoInteres);
		dtoBuscarCuotas.setImporteFijo(importeFijo);
		dtoBuscarCuotas.setAnio(anio);
		dtoBuscarCuotas.setMes(mes);
		dtoBuscarCuotas.setNumero(numero);
		traza("*********** Dto =  "+dtoBuscarCuotas+"***********");
		//Llamamos al ConectorConfirmarDtoRecargo con IdBusiness="CCCConfirmarDtoRecargo".
		Vector paramConector = new Vector();
	   	paramConector.add(dtoBuscarCuotas);           
           	paramConector.add(new MareBusinessID("CCCConfirmarDtoRecargo"));
           	traza("Antes de Conectar ConectorConfirmarDtoRecargo");
           	DruidaConector conector = conectar("ConectorConfirmarDtoRecargo", paramConector);							
           	traza("Despues de Conectar ConectorConfirmarDtoRecargo");
          	traza("LPGenerarDtoRecargo - accionConfirmar - Salida");
         }
         
         private void accionInsertar(Long idioma, Long pais) throws Exception {
	        traza("[MAH]LPGenerarDtoRecargo - accionInsertar - Entrada");		

		// Cargar la pagina 
		pagina("contenido_cuotas_manualmente_insertar");
		
		// Obtengo los parámetros para poder asignárselo a la página nueva.
		String oidEmpresa = conectorParametroLimpia("oidEmpresa","", true);
		String oidSubproceso = conectorParametroLimpia("oidSubproceso","", true);
		String diasCadencia = conectorParametroLimpia("diasCadencia","nada", true);
		String diasCorte = conectorParametroLimpia("diasCorte","", true);
		String tipoInteres = conectorParametroLimpia("tipoInteres","", true);
		String importeFijoDtoRecargo = conectorParametroLimpia("importeFijoDtoRecargo","", true);

		// Asigno estos parámetros a la página nueva
		asignarAtributo("VAR", "oidEmpresa", "valor", oidEmpresa);
		asignarAtributo("VAR", "oidSubproceso", "valor", oidSubproceso);
		asignarAtributo("VAR", "diasCadencia", "valor", diasCadencia);
		asignarAtributo("VAR", "diasCorte", "valor", diasCorte);
		asignarAtributo("VAR", "tipoInteres", "valor", tipoInteres);
		asignarAtributo("VAR", "importeFijoDtoRecargo", "valor", importeFijoDtoRecargo);

		traza("Opcion insertar--> diasCadencia="+diasCadencia);

                //Byte longitud = this.obtenerLongitudCodigoCliente();
                //Long longitudCodigoCliente = new Long(longitud.longValue());
                Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
                asignarAtributo("VAR","longitudCodigoCliente","valor",longitudCodigoCliente.toString());
                
                //Rellena datos generales de la pagina
                asignarAtributo("VAR", "idioma", "valor", idioma.toString());
                asignarAtributo("VAR", "pais", "valor", pais.toString());

		//Título de la pantalla
		// Cambia el codigo a 0339, incidencia 12216
                asignarAtributo("PAGINA","contenido_cuotas_manualmente_insertar","cod","0339");
                asignarAtributo("PAGINA","contenido_cuotas_manualmente_insertar","msgle","Insertar cuotas manualmente");
		this.getConfiguracionMenu("LPGenerarDtoRecargo", "Insertar");

          	traza("[MAH]LPGenerarDtoRecargo - accionInsertar - Salida");
         }                  

        private void accionRellenar(Long idioma, Long pais) throws Exception {
		traza("[MAH]LPGenerarDtoRecargo - accionRellenar - Entrada");
		try{	
			// Cargar la pagina 
			// pagina("contenido_cuotas_manualmente_insertar");

			// Obtengo los parámetros con los que realizaremos la búsqueda para la lista editable
			String oidEmpresa = conectorParametroLimpia("oidEmpresa","", true);
			String oidSubproceso = conectorParametroLimpia("oidSubproceso","", true);
			String diasCadencia = conectorParametroLimpia("diasCadencia","nada", true);
			String diasCorte = conectorParametroLimpia("diasCorte","", true);
			String tipoInteres = conectorParametroLimpia("tipoInteres","", true);
			String importeFijoDtoRecargo = conectorParametroLimpia("importeFijoDtoRecargo","", true);
			String codigoCliente = conectorParametroLimpia("textCodCliente","", true);

			DTOBuscarCuotasDtoRecargo dto = new DTOBuscarCuotasDtoRecargo();

			dto.setOidEmpresa(new Long(oidEmpresa));
            		dto.setOidSubproceso(new Long(oidSubproceso));
            		dto.setDiasCadencia(new Integer(diasCadencia));
            		dto.setDiasCorte(new Integer(diasCorte));
            		dto.setTipoInteres(new BigDecimal(tipoInteres));
            		dto.setImporteFijo(new BigDecimal(importeFijoDtoRecargo));
            		dto.setCodigoCliente(codigoCliente);
			dto.setOidIdioma(idioma);
			dto.setOidPais(pais);
            
            		// IdBusiness de la llamada a negocio
			MareBusinessID idBusiness = new MareBusinessID("CCCBuscarCuotasDtoRecargo");

			Vector entrada = new Vector();
			entrada.add(dto);
			entrada.add(idBusiness);

			traza("Antes de conectar");
			DruidaConector conector = conectar("ConectorBuscarCuotasDtoRecargo", entrada);
			traza("Despues de conectar");

			DTOSalida dtoSalida = new DTOSalida();
			dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
			traza("Salida = "+dtoSalida);

			traza("Antes de generar o dar forma a la salida");
			// Generamos/Damos forma a la salida
			RecordSet filas = dtoSalida.getResultado();
			Vector cols = filas.getColumnIdentifiers();
			traza("Despues de generar o dar forma a la salida");

			traza("Antes de generar el druida conector");			
			DruidaConector conectorLista = UtilidadesBelcorp.generarConector("DTOSalida.resultado", filas, cols);
			traza("Despues de generar el druida conector");			

			traza("Antes de asignar a la lista");			
			asignar("LISTAEDITABLE", "listado1", conectorLista, "DTOSalida.resultado");
			traza("Despues de asignar a la lista");			
		}catch(Exception e){
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("[MAH]LPGenerarDtoRecargo - accionRellenar - Salida");
	}	       
                   
         private void logStackTrace(Throwable e) throws Exception {
	        traza("[MAH]Se produjo la excepcion: " + e.getMessage());		
          	ByteArrayOutputStream baos = new ByteArrayOutputStream();
          	PrintStream ps = new PrintStream(baos);
          	e.printStackTrace(ps);		
          	traza("[MAH]Stack Trace: " + baos.toString());
         }	

}
                   
