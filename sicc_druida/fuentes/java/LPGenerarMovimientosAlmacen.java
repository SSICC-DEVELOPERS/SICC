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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.sql.Timestamp;
import java.util.Vector;
import java.util.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOGMA;
import es.indra.sicc.dtos.bel.DTOGMACabecera;
import es.indra.sicc.dtos.bel.DTOGMADetalle;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString; 

 // Definicion de la clase
public class LPGenerarMovimientosAlmacen extends LPSICCBase {
    // Definicion del constructor
    public LPGenerarMovimientosAlmacen() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
             // Defino el nombre de la vista
    }

    // Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try  {	
		    //rastreo();
		    setTrazaFichero();
			traza("LPGenerarMovimientosAlmacen Entrada");
			String accion = conectorParametroLimpia("accion", "", true);
			traza("Ejecucion  Accion: "+accion);
			if(accion.equals("")){
				this.cargarPaginaGMA();							
			}else if(accion.equals("aceptar")){
		        	this.aceptar();
			}else if(accion.equals("anadir")){
				this.anadir();
			}else if(accion.equals("guardar")){
				this.guardar();
			}
	        //getConfiguracionMenu("LPGenerarMovimientosAlmacen",accion);

			traza("LPGenerarMovimientosAlmacen Salida");
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}
	}

	private void cargarPaginaGMA() throws Exception{
		traza("LPGenerarMovimientosAlmacen.cargarPaginaGMA Entrada");

		//Título de la pantalla
		pagina("contenido_movimientos_almacen_generar");
		asignarAtributo("PAGINA","contenido_movimientos_almacen_generar","cod","0367");
		asignarAtributo("PAGINA","contenido_movimientos_almacen_generar","msgle","Generar Movimientos de Almacén");
		getConfiguracionMenu("LPGenerarMovimientosAlmacen","aceptar");

		//- Se crea una instancia DTOBelcorp y se rellena con los datos de sesión. 
		//Obtenemos el pais y el idioma de la sesion
		Long pais = UtilidadesSession.getPais(this); 
		//Long pais=new Long(1);
		Long idioma = UtilidadesSession.getIdioma(this);
		//Long idioma=new Long(1);
//HAY QUE PONERLO
		Long marca = UtilidadesSession.getMarcaPorDefecto(this);
	      if (marca != null)
	               asignar("VAR", "marca", marca.toString());
/////////////////////////////////////////////////////////////////////////////////		
		//Se instancia un DTOBelcorp
		DTOBelcorp dtoEntrada = new DTOBelcorp();
		dtoEntrada.setOidPais(pais);
		dtoEntrada.setOidIdioma(idioma);

		String idNegocios[] = new String[2];
		idNegocios[0] = new String("SEGConsultaMarcas"); 
		idNegocios[1] = new String("BELObtenerTiposMovimientosAlmacen");
		
		String [] combos = new String[2];
		combos[0] = new String("cbMarca");
		combos[1] = new String("cbTipoMovimiento");
		this.cargaCombos(dtoEntrada, idNegocios, combos, null,null); 
	
		// Obtento la ip del cliente y la almaceno en un DTOString.
		//String ip = this.getRequest().getRemoteAddr(); //"127.0.0.1";
		
		DTOString dtoString = new DTOString();
		dtoString.setCadena(this.getRequest().getRemoteAddr());
		traza("************* LPGenerarMovimientosAlmacen.IP" + this.getRequest().getRemoteAddr());
		
		
		//- Se crea idNegocio "BELObtenerSubaccesoAsociado" 
		MareBusinessID idBusiness = new MareBusinessID("BELObtenerSubaccesoAsociado");
		
		
		//Almacenamos los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoString);
		paramEntrada.addElement(idBusiness);
		
		
		traza("************* LPGenerarMovimientosAlmacen antes conector ");
		//- Se invoca al ConectorCargaInicialSeleccion 
		DruidaConector conector = conectar("ConectorObtenerSubaccesoAsociado", paramEntrada);
		traza("************* LPGenerarMovimientosAlmacen despues conector ");
		
		//- Se obtiene un DTOOID con el subacceso asociado.
		DTOOID dtoOID = (DTOOID)conector.objeto("DTOOID");
		
		traza("DTOOID: "+dtoOID);
		String strOid = (dtoOID.getOid()==null)?"":dtoOID.getOid().toString();
		
		//String strOid="4";
		
		asignar("VAR", "subacceso", strOid); 
		asignar("VAR", "acceso", "BL");
		asignar("VAR", "canal", "VD");
		this.generaHiddensFormato();
		getConfiguracionMenu("LPGenerarMovimientosAlmacen", "aceptar");
		traza("LPGenerarMovimientosAlmacen.cargarPaginaGMA Salida");
	}


	private void aceptar() throws Exception{
		traza("LPGenerarMovimientosAlmacen.aceptar Entrada");
        
		pagina("contenido_movimientos_almacen_generar");
		asignarAtributo("PAGINA", "contenido_movimientos_almacen_generar", "cod", "0367");
		asignarAtributo("PAGINA", "contenido_movimientos_almacen_generar", "msgle", "Generar Movimientos de Almacén");
        	
		//-> Tomar de pantalla, del combo "tipoMovimientoAlmacenCB" la descripción del tipo de movimiento de almacén, y asignar la descripción al atributo "tipoMovimientoAlmacenLB" 
		String descTipoMovimientoAlmacen = conectorParametroLimpia("descTipoMovimientoAlmacen", "", true);
        asignar("LABELC", "lbldtTipoMovimiento1", descTipoMovimientoAlmacen);
        

		//-> Tomar de pantalla, del combo "tipoMovimientoAlmacenCB" el oid del tipo de movimiento y meterlo en un objeto DTOOID. 
		String tipoMovimientoAlmacen = conectorParametroLimpia("cbTipoMovimiento", "", true);
		Long pais = UtilidadesSession.getPais(this); 
		Long idioma = UtilidadesSession.getIdioma(this);
		DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(pais);
		dtoOid.setOidIdioma(idioma);
		dtoOid.setOid(new Long(tipoMovimientoAlmacen));

		//-> Crear un idBusiness = "BELConsultarTipoMovimientoAlmacen" pasando idBusiness y dto creado. 
		MareBusinessID idBusiness = new MareBusinessID("BELConsultarTipoMovimientoAlmacen");
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoOid);
		paramEntrada.addElement(idBusiness);

		DruidaConector conector = conectar("ConectorConsultarTipoMovimientoAlmacen", paramEntrada);

		//-> Recuperar DTOTipoMovimientoAlmacen de respuesta 
		DTOTipoMovimientoAlmacen dtoTipoMA = (DTOTipoMovimientoAlmacen)conector.objeto("DTOTipoMovimientoAlmacen");

		//-> Crear objeto DTOBelcorp con idioma y pais del usuario activo 
		DTOBelcorp dtoEntrada = new DTOBelcorp();
		dtoEntrada.setOidPais(pais);
		dtoEntrada.setOidIdioma(idioma);

		//-> Llamar al subsistema GestorCargaPantalla con la siguiente información 
		//- idBusiness = "BELObtenerAlmacenes" y DTOBelcorp => llena combos "almacenOrigen" y "almacenDestino" 
		String idNegocios[] = new String[3];
		idNegocios[0] = new String("SEGConsultaMarcas");
		idNegocios[1] = new String("BELObtenerTiposMovimientosAlmacen");
		idNegocios[2] = new String("BELObtenerAlmacenes");
		String [] combos = new String[3];
		combos[0] = new String("cbMarca");
		combos[1] = new String("cbTipoMovimiento");
		combos[2] = new String("cbAlmacenOrigen");
		String seleccionados[] = new String[3];
		seleccionados[0] = conectorParametroLimpia("cbMarca", "", true);
		seleccionados[1] = conectorParametroLimpia("cbTipoMovimiento", "", true);
		seleccionados[2] = new String("");
		
		
		String columnas[]=new String[3];
		columnas[0] = "";
		columnas[1]="";
		columnas[2]="";

		this.cargaCombos(dtoEntrada, idNegocios, combos, seleccionados,columnas);
		//this.cargaCombos(dtoEntrada, idNegocios, combos, null,null); 	
		
		asignar("VAR", "subacceso", conectorParametroLimpia("subacceso", "", true));
		asignar("VAR", "acceso", conectorParametroLimpia("acceso", "", true));
		asignar("VAR", "canal", conectorParametroLimpia("canal", "", true));
		asignar("VAR", "hid_tipoMovimiento", conectorParametroLimpia("cbTipoMovimiento", "", true));
		asignar("VAR", "hid_marca", conectorParametroLimpia("cbMarca", "", true));
      
        //-> Asigna la fecha del usuario a la variable oculta de la pantalla      
        asignarAtributo("VAR", "hid_FechaUsu", "valor" , getFechaUsu()); 
	
		//-> Tomar el atributo del DTOTipoMovimimientoAlmacen recuperado, llamado "movimientoEntreAlmacenes", si su valor es "false" ocultar el combo "almacenDestino"
		//Por defecto estará oculto y si movimientoEntreAlmacenes es true, en el onload se visualizará si la variable hidden visualizarAlmacenDestino es true
		if (dtoTipoMA.getMovimientoEntreAlmacenes() != null && dtoTipoMA.getMovimientoEntreAlmacenes().booleanValue())
			asignar("VAR", "visualizarAlmacenDestino", "true");

			
		this.generaHiddensFormato();
		getConfiguracionMenu("LPGenerarMovimientosAlmacen", "guardar");

		traza("LPGenerarMovimientosAlmacen.aceptar Salida");
	}

	private void anadir() throws Exception{
		traza("LPGenerarMovimientosAlmacen.anadir Entrada");

		//-> Asignar página "contenido_movimientos_almacen_generar_detalle" 
		pagina("contenido_movimientos_almacen_generar_detalle");
		asignarAtributo("PAGINA", "contenido_movimientos_almacen_generar_detalle", "cod", "0367");
		asignarAtributo("PAGINA", "contenido_movimientos_almacen_generar_detalle", "msgle", "Generar Movimientos de Almacén");
		getConfiguracionMenu("LPGenerarMovimientosAlmacen","anadir");
		
		this.generaHiddensFormato();
		      	
		
		//-> Crear objeto DTOBelcorp con idioma y pais del usuario activo. 
		Long pais = UtilidadesSession.getPais(this); 
		Long idioma = UtilidadesSession.getIdioma(this);
		DTOBelcorp dtoEntrada = new DTOBelcorp();
		dtoEntrada.setOidPais(pais);
		dtoEntrada.setOidIdioma(idioma);

		//-> Llamar al subsistema GestorCargaPantalla con la siguiente información: 
		//- idBusiness = "MAEObtenerProductosPais" => llena combo "producto" 
		//-> Mostrar página, habilitando los controles de pantalla y el botón aceptar
		/*
		pzerbino incidencia BELC300024255 25/09/2006	
			String idNegocios[] = new String[1];
			idNegocios[0] = new String("MAEObtenerProductosPais"); 
			String [] combos = new String[1];
			combos[0] = new String("cbProducto");
			this.cargaCombos(dtoEntrada, idNegocios, combos, null,null); 
		*/

		getConfiguracionMenu("LPGenerarMovimientosAlmacen", "anadir");

		traza("LPGenerarMovimientosAlmacen.anadir Salida");
	}
    
    private String getFechaUsu() throws Exception{
              
        String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);
        traza("formatoFechaPais" + formatoFechaPais);
	    String fechaFormateada = UtilidadesBelcorp.fechaFormateada(new Date(System.currentTimeMillis()),formatoFechaPais);
        traza("Fecha del sistema" + new Date(System.currentTimeMillis()));
        traza("Fecha formateada" + fechaFormateada);
        
        return fechaFormateada;
       
    
    }
 
	private void guardar() throws Exception{
		traza("LPGenerarMovimientosAlmacen.guardar Entrada");

		//-> Asignar pantalla "contenido_movimientos_almacen_generar" 
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "accionEjecutada()");

		//-> Crear objeto DTOGMA vacío
		DTOGMA dto = new DTOGMA();
		Long idioma = UtilidadesSession.getIdioma(this);
		Long pais = UtilidadesSession.getPais(this);
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);

		//-> Tomar los datos de la sección de cabecera y construir un objeto DTOGMACabecera. 
		DTOGMACabecera dtoCabecera = new DTOGMACabecera();
		/*String parametro = conectorParametroLimpia("subacceso", "", true);
		traza("**************Subacceso '" + parametro + "'");*/
		
		DTOString dtoString = new DTOString();
		dtoString.setCadena(this.getRequest().getRemoteAddr());
		traza("************* LPGenerarMovimientosAlmacen.IP" + this.getRequest().getRemoteAddr());
		
		
		//- Se crea idNegocio "BELObtenerSubaccesoAsociado" 
		MareBusinessID idBusiness = new MareBusinessID("BELObtenerSubaccesoAsociado");
		
		
		//Almacenamos los parametros de entrada
		Vector paramEntrada2 = new Vector();
		paramEntrada2.addElement(dtoString);
		paramEntrada2.addElement(idBusiness);
		
		
		traza("************* LPGenerarMovimientosAlmacen antes conector ");
		//- Se invoca al ConectorCargaInicialSeleccion 
		DruidaConector conector = conectar("ConectorObtenerSubaccesoAsociado", paramEntrada2);
		traza("************* LPGenerarMovimientosAlmacen despues conector ");
		
		//- Se obtiene un DTOOID con el subacceso asociado.
		DTOOID dtoOID = (DTOOID)conector.objeto("DTOOID");
		
		traza("DTOOID: "+dtoOID);
		String strOid = (dtoOID.getOid()==null)?"":dtoOID.getOid().toString();
		
		//String strOid="4";
		
		//asignar("VAR", "subacceso", strOid); 
		
		
		
		//if (!parametro.equals(""))
		dtoCabecera.setOidSubacceso(new Long(strOid));

		/*dtoCabecera.setCanal(conectorParametroLimpia("canal", "", true));
		dtoCabecera.setAcceso(conectorParametroLimpia("acceso", "", true));*/
		dtoCabecera.setCanal("VD");
		dtoCabecera.setAcceso("BL");

		String parametro = conectorParametroLimpia("hid_tipoMovimiento", "", true);
		if (!parametro.equals(""))
			dtoCabecera.setOidTipoMovimientoAlmacen(new Long(parametro));


		parametro = conectorParametroLimpia("hid_marca", "", true);
		if (!parametro.equals(""))
			dtoCabecera.setOidMarca(new Long(parametro));

		parametro = conectorParametroLimpia("txtNumDocumento", "", true);
		if (!parametro.equals(""))
			dtoCabecera.setNumeroDocumento(parametro);

		parametro = conectorParametroLimpia("cbAlmacenOrigen", "", true);
		if (!parametro.equals(""))
			dtoCabecera.setOidAlmacenOrigen(new Long(parametro));

		parametro = conectorParametroLimpia("cbAlmacenDestino", "", true);
		if (!parametro.equals(""))
			dtoCabecera.setOidAlmacenDestino(new Long(parametro));
			

		parametro = conectorParametroLimpia("atxtObservaciones", "", true);
		if (!parametro.equals(""))
			dtoCabecera.setObservaciones(parametro);
			
		parametro = conectorParametroLimpia("txtFecha", "", true);
		if (!parametro.equals("")) {
			Date fechaAux = UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, 
							UtilidadesSession.getFormatoFecha(this));
			dtoCabecera.setFecha(new Timestamp(fechaAux.getTime()));
		}else {
			dtoCabecera.setFecha(new Timestamp(System.currentTimeMillis()));
		}

		dtoCabecera.setOidPais(pais);
		dtoCabecera.setOidIdioma(idioma);
		traza("**************pais: " + pais );
		
		//-> Asignar el dto creado al atributo DTOGMA.cabecera 
		dto.setCabecera(dtoCabecera);
		
		traza("**************Cabecera: " + dtoCabecera );
		

		//-> Tomar los datos de la lista editable y por cada línea construir un objeto DTOGMADetalle
		parametro = conectorParametroLimpia("detalles", "", true);
		StringTokenizer st = new StringTokenizer(parametro, "#");
		ArrayList detalles = new ArrayList();
		String precio=null;
		while (st.countTokens() > 0) {
			
			String fila = st.nextToken();
			if (!fila.equals("-")) {
				StringTokenizer stFila = new StringTokenizer(fila, "@");
				if (stFila.countTokens() > 0) {
					DTOGMADetalle dtoGMADetalle = new DTOGMADetalle();
					dtoGMADetalle.setOidProducto(this.numero(stFila.nextToken()));
					dtoGMADetalle.setCantidad(this.numero(stFila.nextToken()));
					precio=stFila.nextToken();
					if (!precio.equals("*")) {
						dtoGMADetalle.setPrecioVentaNeto(this.numeroDecimal(precio));
					}
					precio=stFila.nextToken();
					if (!precio.equals("*")) {
						dtoGMADetalle.setPrecioContable(this.numeroDecimal(precio));
					}
					detalles.add(dtoGMADetalle);
				}
			}
		}
		//-> Asignar cada DTOGMADetalle al atributo DTOGMA.detalle, de tipo arrayList
		dto.setDetalle(detalles);
		traza("**************Detalles: " + detalles );

		//-> Crear idBusiness = "BELGuardarGMA" 
		//-> Asignar conector ConectorGuardarGMA con idBusiness y DTOGMA creado
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("BELGuardarGMA"));
		
		DruidaConector conector2 = conectar("ConectorGuardarGMA", paramEntrada);

		traza("LPGenerarMovimientosAlmacen.guardar Salida");
	}
	private BigDecimal numeroDecimal(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("-")) {
			return new BigDecimal(entrada);
		}
		return null;
	}

	private Long numero(String entrada) throws Exception {
		if (entrada != null && !entrada.equals("-")) {
			return new Long(entrada);
		}
		return null;
	}

// A partir de aquí no está hecho, es de otro caso de uso.
	private void generaHiddensFormato() throws Exception{
		traza("LPSeleccionarProvisionesDepuraciones.generaHiddensFormato Entrada");
		//Codigo para guardar valores de validación de sesion en hiddens de la página donde se debe hacer la validacion
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = ".";
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		this.generarHiddenFormatoFecha();
		traza("LPSeleccionarProvisionesDepuraciones.generaHiddensFormato Salida");
	}


	private void cargaCombos(DTOBelcorp dtoBelcorp, String idNegocios[], String[] combos, String[] seleccionados, String[] columnas) throws Exception {
		traza("*** Entrada - cargaCombos ***");
		
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = null; 
		for (int i = 0; i < idNegocios.length; i++) {
			elem=new ComposerViewElement(); 
			elem.setIDBusiness(idNegocios[i]);
			elem.setDTOE(dtoBelcorp);
			listelem.addViewElement(elem);
		}
		
		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
		//correspondiente utilizando el String que representa el BusinessID en cada caso. */
		if (seleccionados == null) {
			for(int j = 0; j < combos.length; j++) {
				asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			   	if (j == 2) {
					asignar("COMBO", "cbAlmacenDestino", conConsultar, idNegocios[j]);
				
			   	}
			}
		} else {
			for (int j = 0; j < combos.length; j++) {
				if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals("")) {
					//antiguo: asignar("COMBO", combos[j], conConsultar, idNegocios[j]);
					asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
				
			   	} else {
					
			   		asignar("COMBO", combos[j], conConsultar, idNegocios[j]);
					
			   	}
			   	if (j == 2) {
					
			   		asignar("COMBO", "cbAlmacenDestino", conConsultar, idNegocios[j]);
					
			   	}
			}
		}		
		traza("*** Salida - cargaCombos ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}

}
