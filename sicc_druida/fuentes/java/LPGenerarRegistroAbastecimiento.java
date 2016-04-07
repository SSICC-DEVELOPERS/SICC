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
/*
    INDRA/CAR/PROY
    $Id: LPGenerarRegistroAbastecimiento.java,v 1.1 2009/12/03 18:38:02 pecbazalar Exp $
    DESC
*/

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import java.sql.Timestamp;

import es.indra.sicc.dtos.bel.DTOAnadirProductosRA;
import es.indra.sicc.dtos.bel.DTOEObtenerRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOERellenarRegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTOERellenarRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimientoDetalle;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import es.indra.sicc.util.xml.XMLDocument;


public class LPGenerarRegistroAbastecimiento extends LPSICCBase {
    
	private String accion = null;
	private String casoUso = null;
	private Long idioma = null;
	private Long pais = null;

    
	public LPGenerarRegistroAbastecimiento() {
		super();
	}


	public void inicio() throws Exception {
	}


	public void ejecucion() throws Exception {
         
		rastreo();
               
		try {
		   setTrazaFichero(); 
			traza("***Entrada - LPGenerarRegistroAbastecimiento - ejecucion***");
		        
			this.accion = conectorParametroLimpia("accion", "", true);
			traza("***accion : " + accion);                 
			
			this.idioma = UtilidadesSession.getIdioma(this); 
			this.pais = UtilidadesSession.getPais(this);
			
			if (accion.equals("")) {
				this.casoUso = new String("");
				this.cargarPagina();
		
			} else if (accion.equals("rellenarRegistroAbastecimiento")) {
				this.casoUso = new String("rellenarRegistroAbastecimiento");
				this.rellenarRegistroAbastecimiento();
		
			} else if (accion.equals("anadirProducto")) {
				this.casoUso = new String("anadirProducto");
				this.anadirProducto();
		
			} else if (accion.equals("guardar")) {
				this.casoUso = new String("guardar");
				this.guardar();
		
			} else if(accion.equals("cargarRegistroAbastecimiento")) {
				this.casoUso = new String("cargarRegistroAbastecimiento");
				this.cargarRegistroAbastecimiento();
		
			} else if (accion.equals("mostrarVentanaSeleccionProducto")) {
				this.casoUso = new String("mostrarVentanaSeleccionProducto");
				this.mostrarVentanaSeleccionProducto();
				
			}
			
			traza("***Salida - LPGenerarRegistroAbastecimiento - ejecucion***");
		            
		} catch(Exception e) {
		   logStackTrace(e);
		   lanzarPaginaError(e);
		}
	}
     
	private void cargarPagina() throws Exception {
   	
   	traza("***Entrada - LPGenerarRegistroAbastecimiento - cargarPagina***");
	
		// Asignar la página "contenido_registro_abastecimiento_generar" 
		pagina("contenido_registro_abastecimiento_generar");
		
		// nombre="contenido_registro_abastecimiento_generar" cod="0483" titulo="Generar registro de abastecimiento"
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar", "cod", "0483");
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar", "msgle", "Generar registro de abastecimiento");
		traza("**************** casoUso: " + this.casoUso);
		getConfiguracionMenu("LPGenerarRegistroAbastecimiento", "");
		
		asignar("VAR", "idioma", this.idioma.toString());
		asignar("VAR", "pais", this.pais.toString()); 
		asignar("VAR", "casoUso", this.casoUso); 
		
		// ejecutar método privado "obtenerSubacceso()" 
		obtenerSubacceso();
		
		// Llamar al subsistema "GestorCargaPantalla" con los siguientes datos 
		// idBusiness = "SEGConsultaMarcas" => llena el combo "marca"
			
		DTOBelcorp dtoe = new DTOBelcorp();
                        
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);

		String[] idNegocios = {"SEGConsultaMarcas"};
		
		ArrayList dtos = new ArrayList();
		dtos.add(dtoe);
		
		String[] combos = {"cbMarca"};
		
		// cada usuario tiene una marca y canal por defecto que deben seleccionarse
      Long marca = UtilidadesSession.getMarcaPorDefecto(this);
		String[] seleccionados = {marca.toString()};
		
		String[] columnas = {"VAL_OID"};

      cargaCombos(dtoe, idNegocios, dtos, combos, seleccionados, columnas);
      
		// se asignan a los elementos de la pagina los valores por defecto del usuario
		asignar("VAR", "marca", marca.toString());

			
		// Crear un objeto DTOBelcorp con el pais e idioma de sesión 
		// Crear un idBusiness = "BELObtenerAgrupacionStockCabecera" 
		// Asignar conector "ConectorObtenerAgrupacionStockCabecera" con idBusiness y dto creados 
		
      MareBusinessID idNegocio = new MareBusinessID("BELObtenerAgrupacionStockCabecera");
      
      Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoe);
      paramsEntrada.add(idNegocio);
      traza("****Antes de conectar");
      DruidaConector conector = conectar("ConectorObtenerAgrupacionStockCabecera", paramsEntrada);
		
		// Recuperar el dto de salida DTOSalida y mapear el RecordSet en el combo "agrupacionStock" de la 
		// pantalla asignada 
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();
		traza("*** Valor Recordset rs : " + rs);
			
		// En el combo se mapean las columnas "OID_AGRU_STOC_CABE" y descripción internacionalizada, 
		// para hacer esto creo un nuevo RecordSet que contenga solo las columnas que se mapearan en el combo
		RecordSet rsParcial = new RecordSet();
		rsParcial.addColumn("OID_AGRU_STOC_CABE");
		rsParcial.addColumn("DESCRIPCION");
		//Vector vFila = null;
		for (int i=0; i < rs.getRowCount(); i++) {
			Vector vFila = new Vector();
			vFila.add(rs.getValueAt(i, rs.getColumnPosition("OID_AGRU_STOC_CABE")));
			vFila.add(rs.getValueAt(i, rs.getColumnPosition("DESCRIPCION")));
			rsParcial.addRow(vFila);
		}
		traza("***Recordset parcial antes de limpiarlo:" + rsParcial);
		// a partir del nuevo RecordSet generamos un conector
		Vector cols = rsParcial.getColumnIdentifiers();
		traza("***Antes de generar un conector");
		DruidaConector conectorGenerado = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET", rsParcial, cols);
		asignar("COMBO", "cbAgrupacionStock", conectorGenerado);
						
		// y creamos un array javaScript con los valores de la columna "IND_DEFE" mapeando el atributo 
		// de pantalla "agrupacionPorDefecto" 
		// para hacer esto creo un nuevo RecordSet que contenga solo la columna "IND_DEFE"
		RecordSet rsParcial1 = new RecordSet();
		rsParcial1.addColumn("IND_DEFE");
		for (int i=0; i < rs.getRowCount(); i++) {
			Vector vFila = new Vector();
			vFila.add(rs.getValueAt(i, rs.getColumnPosition("IND_DEFE")));
			rsParcial1.addRow(vFila);
		}

		// a partir del nuevo RecordSet generamos un conector
		traza("***Antes de asignar la matriz el parcial1:" + rsParcial1);
		Vector cols1 = rsParcial1.getColumnIdentifiers();
		conectorGenerado = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET", rsParcial1, cols1);
		asignar("MATRIZJS", "agrupacionPorDefecto", conectorGenerado); 
		
		// El array "agrupacionPorDefecto" y el combo "agrupacionStock" son paralelos, 
		// y se seleccionará en el combo el valor cuyo valor paralelo en el array "agrupacionPorDefecto" valga "1" 
		// que es igual a "true" 
		////    ESTO LO HAGO EN LA FUNCION onLoadPag() de contenido_registro_abastecimiento_generar_detalle.js		
					
		// Asignar a la variable oculta "oidEstadoCreado" el valor de "ConstantesBEL.ESTADO_HOJA_DEMANDA_CREADO" 
		asignar("VAR", "oidEstadoCreado", ConstantesBEL.ESTADO_HOJA_DEMANDA_CREADO.toString());
		
		// Permitir seleccionar sólo un registro en la lista "listaRecuperacion" ?????????????????
		// esto se hace en el contenido_registro_abastecimiento_generar_detalle.js
			
	   traza("***Salida - LPGenerarRegistroAbastecimiento - cargarPagina***");		
   }


   private void obtenerSubacceso() throws Exception {
   	
   	traza("***Entrada - LPGenerarRegistroAbastecimiento - obtenerSubacceso***");		
                  
		// Obtener la dirección IP del cliente a través del request 
		String ip = this.getRequest().getRemoteAddr();

		// Crear objeto DTOString, asignando a su atributo "cadena" la dirección IP obtenida en la actividad anterior 
		DTOString dtoString = new DTOString();
		dtoString.setCadena(ip);
		dtoString.setOidPais(this.pais);
		dtoString.setOidIdioma(this.idioma);

		// Crear idBusiness = "BELObtenerSubaccesoAsociado" 
		// Asignar conector "ConectorObtenerSubaccesoAsociado" con idBusiness y dto creados 
      MareBusinessID idNegocio = new MareBusinessID("BELObtenerSubaccesoAsociado");
      
      Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoString);
      paramsEntrada.add(idNegocio);
      DruidaConector conector = conectar("ConectorObtenerSubaccesoAsociado", paramsEntrada);			
			
		// Recuperar DTOOID obtenido y mapear el oid en la variable oculta "oidSubacceso" de la pantalla asignada 
		DTOOID dtoOID = (DTOOID)conector.objeto("DTOOID");
		traza("***Antes del if - obtenerSubacceso***");
		if (dtoOID != null) {
			
			traza("***Valor asignado al subacceso :" + dtoOID.getOid());
			asignar("VAR", "oidSubacceso", dtoOID.getOid().toString());
		}
			
	   traza("***Salida - LPGenerarRegistroAbastecimiento - obtenerSubacceso***");		
   }
   
   
   private void rellenarRegistroAbastecimiento() throws Exception {
   	
   	traza("***Entrada - LPGenerarRegistroAbastecimiento - rellenarRegistroAbastecimiento***");		
                  
		// Asignar página "contenido_registro_abastecimiento_generar_detalle" 
		pagina("contenido_registro_abastecimiento_generar_detalle");
		
		// nombre="contenido_registro_abastecimiento_generar_detalle" cod="0483" titulo="Generar registro de abastecimiento"
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar_detalle", "cod", "0483");
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar_detalle", "msgle", "Generar registro de abastecimiento");
		getConfiguracionMenu("LPGenerarRegistroAbastecimiento", "cargarRegistroAbastecimiento");
		
		asignar("VAR", "idioma", this.idioma.toString());
  		asignar("VAR", "pais", this.pais.toString()); 
  		asignar("VAR", "casoUso", this.casoUso);
  		
      // se obtienen el separador de decimales y de miles
      String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
      String separadorMiles = ",";
      if (separadorDecimales.equals(",")) {
      	separadorMiles = ".";
      }
      asignar("VAR", "hid_SeparadorMiles", separadorMiles);
      asignar("VAR", "hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
      asignar("VAR", "hid_SeparadorDecimales", separadorDecimales);
  		
		// Crear variable llamada "dtoe" de tipo "DTOERellenarRegistroAbastecimiento" y hacer el siguiente mapeo: 
		DTOERellenarRegistroAbastecimiento dtoe = new DTOERellenarRegistroAbastecimiento();
		// dtoe.pais = pais de sesión 
		dtoe.setOidPais(this.pais);
		// dtoe.idioma = idioma de sesión 
		dtoe.setOidIdioma(this.idioma);
		// dtoe.subacceso = oidSubacceso de pantalla llamante "PaginaGenerarRegistroAbastecimiento" 
		dtoe.setSubacceso(new Long(conectorParametroLimpia("oidSubacceso", "", true)));
		// dtoe.marca = marca seleccionada en el combo "marca" de la pantalla llamante "PaginaGenerarRegistroAbastecimiento" 
		dtoe.setMarca(new Long(conectorParametroLimpia("cbMarca", "", true)));
		// dtoe.agrupacionStock = agrupacion de stock seleccionada en el combo "agrupacionStock" de la pantalla llamante "PaginaGenerarRegistroAbastecimiento"
		dtoe.setAgrupacionStock(new Long(conectorParametroLimpia("cbAgrupacionStock", "", true)));
		
		traza("*** pais: " + dtoe.getOidPais() + "           idioma: " + dtoe.getOidIdioma());
		traza("*** DTOERellenarRegistroAbastecimiento creado: " + dtoe);
						
		// Crear idBusiness = "BELRellenarRegistroAbastecimiento" 
		// Asignar conector "ConectorRellenarRegistroAbastecimiento" con idBusiness y dto creados 
		MareBusinessID idNegocio = new MareBusinessID("BELRellenarRegistroAbastecimiento");
		traza("*** MareBusiness :" + idNegocio);
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoe);
		paramsEntrada.add(idNegocio);
		DruidaConector conector = conectar("ConectorRellenarRegistroAbastecimiento", paramsEntrada);			
		traza("*** DruidaConector: " + conector);
		
		// Recuperar dto de salida, de tipo DTORegistroAbastecimiento 
		DTORegistroAbastecimiento dtoRegAbast = (DTORegistroAbastecimiento)conector.objeto("DTORegistroAbastecimiento");
		traza("*** DTORegistroAbastecimiento: " + dtoRegAbast);
		// Mapear el dto de salida en la pantalla del modo siguiente: 
		// LLamamos pantalla a la página y dtos al dto de salida 

		traza("************* antes de asignar los valores a los Label***");

		// pantalla.opcionCrearRegistro = "true" 
		asignar("VAR", "opcionCrearRegistro", Boolean.TRUE.toString());
		// pantalla.oidMarca = dtos.oidMarca 
		asignar("VAR", "oidMarca", dtoRegAbast.getOidMarca().toString());
		// pantalla.marca = dtos.descripcionMarca 
		asignar("LABELC", "lbldtMarca", dtoRegAbast.getDescripcionMarca());
		// pantalla.oidCanal = dtos.oidCanal 
		asignar("VAR", "oidCanal", dtoRegAbast.getOidCanal().toString());
		// pantalla.canal = dtos.descripcionCanal 
		asignar("LABELC", "lbldtCanal", dtoRegAbast.getDescripcionCanal());
		// pantalla.acceso = dtos.descripicionAcceso 
		asignar("LABELC", "lbldtAcceso", dtoRegAbast.getDescripcionAcceso());
		// pantalla.oidSubacceso = dtos.oidSubacceso 
		traza("*** Subacceso asignado en rellenarRegistroAbastecimiento:" + dtoRegAbast.getOidSubacceso());
		asignar("VAR", "oidSubacceso", dtoRegAbast.getOidSubacceso().toString());
		// pantalla.subacceso = dtos.descripcionSubacceso
		asignar("LABELC", "lbldtSubacceso", dtoRegAbast.getDescripcionSubacceso());
		// pantalla.oidAlmacen = dtos.oidAlmacen
		traza("***IMPORTANTE oidAlmacen de Rellenar:" + dtoRegAbast.getOidAlmacen()); 
		asignar("VAR", "oidAlmacen", dtoRegAbast.getOidAlmacen().toString());
		// pantalla.almacen = dtos.descripcionAlmacen 
		asignar("LABELC", "lbldtAlmacen", dtoRegAbast.getDescripcionAlmacen());
		// pantalla.numeroSolicitud = dtos.nSolicitud 
			asignar("LABELC", "lbldtNumSolicitud", dtoRegAbast.getNSolicitud().toString());
		asignar("VAR", "numeroSolicitud", dtoRegAbast.getNSolicitud().toString());
		// pantalla.oidAgrupacionStock = dtos.oidAgrupacionStock 
		asignar("VAR", "oidAgrupacionStock", dtoRegAbast.getOidAgrupacionStock().toString());
		// pantalla.oidPeriodo = dtos.oidPeriodo
	traza("*** oidPeriodo: " + dtoRegAbast.getOidPeriodo());
		
		
		// por incidencia BELC300012945 el periodo se recupera en negocio
		// a partir de pais, marca y canal
		//asignar("VAR", "oidPeriodo", dtoRegAbast.getOidPeriodo().toString());
		//asignar("VAR", "oidPeriodo", "75");

			
		traza("************* Despues de asignar los valores a los Label***");
		
		// incidencia BELC300012245. Ya implantada
		// Crear objeto DTOERellenarRegistroAbastecimientoDetalle haciendo el siguiente mapeo: 
		DTOERellenarRegistroAbastecimientoDetalle dtoERRAD = new DTOERellenarRegistroAbastecimientoDetalle();
		// DTOERellenarRegistroAbastecimientoDetalle.pais = pais de sesión 
		dtoERRAD.setOidPais(this.pais);
		// DTOERellenarRegistroAbastecimientoDetalle.idioma = idioma de sesión 
		dtoERRAD.setOidIdioma(this.idioma);
		// DTOERellenarRegistroAbastecimientoDetalle.almacen = dtos.oidAlmacen 
		dtoERRAD.setAlmacen(dtoRegAbast.getOidAlmacen());
		// DTOERellenarRegistroAbastecimientoDetalle.agrupacionStock = dtos.oidAgrupacionStock 
		dtoERRAD.setAgrupacionStock(dtoRegAbast.getOidAgrupacionStock());
		// tambien hay que asignar el subacceso porque se necesita en negocio
		dtoERRAD.setSubacceso(dtoRegAbast.getOidSubacceso());
    
    // vbongiov - inc 21741
    dtoERRAD.setMarca(new Long(conectorParametroLimpia("cbMarca", "", true)));
		
		traza("*** pais: " + dtoERRAD.getOidPais() + "           idioma: " + dtoERRAD.getOidIdioma());
		traza("**** DTOERellenarRegistroAbastecimientoDetalle creado: " + dtoERRAD);

		// Crear idBusiness = "BELRellenarRegistroAbastecimientoDetalle" 
		idNegocio = new MareBusinessID("BELRellenarRegistroAbastecimientoDetalle");
		// Asignar conector "ConectorRellenarRegistroAbastecimientoDetalle" con el idBusiness y dto creados 
		paramsEntrada = new Vector();
		paramsEntrada.add(dtoERRAD);
		paramsEntrada.add(idNegocio);
		traza("***Andes de conectar ConectorRellenarRegistroAbastecimientoDetalle");
		conector = conectar("ConectorRellenarRegistroAbastecimientoDetalle", paramsEntrada);			
		traza("*** 2º Conector: ", conector);
		
		// Recuperar el DTOSalida de respuesta y mapear el RecordSet sobre la lista editable de pantalla
		traza("***Andes de asignar la salida");
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		traza("***DTOSalida : " + dtoSalida);
		// se obtiene el RecordSet
		RecordSet rs = dtoSalida.getResultado();
		
		// de negocio nos llega el OID_PROD en la columna 1 (comienzan en 0)
		// en la lista aparece en la columna oculta 7
		// la elimino, despues de obtener su nombre y valores, y despues la añado al final del recordset
		/*String nombreColumnaOIDProducto = rs.getColumnName(1);
		Vector columnaOIDsProd = rs.getColumn(1);
		rs.removeColumn(1);
		rs.addColumn(nombreColumnaOIDProducto, columnaOIDsProd);*/
		
		Vector cols = rs.getColumnIdentifiers();
		DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET", rs, cols);
		traza("******** conectorCargaLista: ", conectorCargaLista);
		asignar("LISTAEDITABLE", "datosDeDetalle", conectorCargaLista,"DTOSalida.resultado_ROWSET");

	   traza("***Salida - LPGenerarRegistroAbastecimiento - rellenarRegistroAbastecimiento***");		
   }
   

   private void cargarRegistroAbastecimiento() throws Exception {
   	
   	traza("***Entrada - LPGenerarRegistroAbastecimiento - cargarRegistroAbastecimiento***");		
                  
		// Asignar página "contenido_registro_abastecimiento_generar_detalle" 
		pagina("contenido_registro_abastecimiento_generar_detalle");
		
		// nombre="contenido_registro_abastecimiento_generar_detalle" cod="0483" titulo="Generar registro de abastecimiento"
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar_detalle", "cod", "0483");
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar_detalle", "msgle", "Generar registro de abastecimiento");
		getConfiguracionMenu("LPGenerarRegistroAbastecimiento", this.casoUso);
		
		asignar("VAR", "idioma", this.idioma.toString());
      asignar("VAR", "pais", this.pais.toString());
      asignar("VAR", "casoUso", this.casoUso); 

		// genero los campos en la pagina que contienen el formato de fecha para el usuario
      generarHiddenFormatoFecha();
      
      // se obtienen el separador de decimales y de miles
      String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
      String separadorMiles = ",";
      if (separadorDecimales.equals(",")) {
      	separadorMiles = ".";
      }
      asignar("VAR", "hid_SeparadorMiles", separadorMiles);
      asignar("VAR", "hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
      asignar("VAR", "hid_SeparadorDecimales", separadorDecimales);

		// Tomar el campo oculto del registro seleccionado en la lista "listaRecuperacion" de la página 
		// llamante "contenido_registro_abastecimiento_generar" 
		// Crear objeto DTOOID con el oid recuperado 
		DTOOID dtoOID = new DTOOID();
		dtoOID.setOidPais(this.pais);
		dtoOID.setOidIdioma(this.idioma);
		String listaRecuperacion = conectorParametroLimpia("listaRecuperacion", "", true);
		traza("******* listaRecuperacion: " + listaRecuperacion);
		dtoOID.setOid(new Long(listaRecuperacion));

		// Crear idBusiness = "BELObtenerRegistroAbastecimiento" 
		MareBusinessID idNegocio = new MareBusinessID("BELObtenerRegistroAbastecimiento");
		traza("*** IDNegocio :" +idNegocio );
		// Asignar conector "ConectorObtenerRegistroAbastecimiento" 
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoOID);
		paramsEntrada.add(idNegocio);
		traza("***Antes de obtener el conector - cargarRegistroAbastecimiento");
		DruidaConector conector = conectar("ConectorObtenerRegistroAbastecimiento", paramsEntrada);
		traza("***Conector obtenido - cargarRegistroAbastecimiento");			
		// Recuperar objeto DTORegistroAbastecimiento y guardarlo en una variable llamada "dtos" del mismo tipo 
		DTORegistroAbastecimiento dtos = (DTORegistroAbastecimiento)conector.objeto("DTORegistroAbastecimiento");
			
		traza("***IMPORTANTE dtos.oid = " + dtos.getOid());
		// Mapear "respuesta" en la pantalla del modo siguiente: 
		// pantalla.opcionCrearRegistro = "false" 
		asignar("VAR", "opcionCrearRegistro", Boolean.FALSE.toString());
		// pantalla.oidMarca = dtos.oidMarca 
		asignar("VAR", "oidMarca", dtos.getOidMarca().toString());
		// pantalla.marca = dtos.descripcionMarca 
		asignar("LABELC", "lbldtMarca", dtos.getDescripcionMarca());
		// pantalla.oidCanal = dtos.oidCanal 
		asignar("VAR", "oidCanal", dtos.getOidCanal().toString());
		// pantalla.canal = dtos.descripcionCanal 
		asignar("LABELC", "lbldtCanal", dtos.getDescripcionCanal());
		// pantalla.acceso = dtos.descripicionAcceso 
		asignar("LABELC", "lbldtAcceso", dtos.getDescripcionAcceso());
		// pantalla.oidSubacceso = dtos.oidSubacceso 
		asignar("VAR", "oidSubacceso", dtos.getOidSubacceso().toString());
		// pantalla.subacceso = dtos.descripcionSubacceso 
		asignar("LABELC", "lbldtSubacceso", dtos.getDescripcionSubacceso());						
		// pantalla.oidAlmacen = dtos.oidAlmacen 
		traza("***IMPORTANTE oidAlmacen de Cargar:" + dtos.getOidAlmacen());
		asignar("VAR", "oidAlmacen", dtos.getOidAlmacen().toString());
		// pantalla.almacen = dtos.descripcionAlmacen 
		asignar("LABELC", "lbldtAlmacen", dtos.getDescripcionAlmacen());									
		// pantalla.numeroSolicitud = dtos.nSolicitud 
		asignar("LABELC", "lbldtNumSolicitud", dtos.getNSolicitud().toString());
		asignar("VAR", "numeroSolicitud", dtos.getNSolicitud().toString());			
		// pantalla.oidPeriodo = dtos.oidPeriodo 
		asignar("VAR", "oidPeriodo", dtos.getOidPeriodo().toString());
		// pantalla.oidRegistroAbastecimientoCabecera = dtos.oid 
		asignar("VAR", "oidRegistroAbastecimientoCabecera", dtos.getOid().toString());
		// pantalla.oidAgrupacionStock = dtos.oidAgrupacionStock 
		asignar("VAR", "oidAgrupacionStock", dtos.getOidAgrupacionStock().toString());

		// Crear idBusiness = "BELObtenerRegistroAbastecimientoDetalle" 
		idNegocio = new MareBusinessID("BELObtenerRegistroAbastecimientoDetalle");
		// Crear objeto DTOEObtenerRegistroAbastecimientoDetalle haciendo el siguiente mapeo: 
		DTOEObtenerRegistroAbastecimientoDetalle dtoORAD = new DTOEObtenerRegistroAbastecimientoDetalle();
		// DTOEObtenerRegistroAbastecimientoDetalle.pais = pais de sesión 
		dtoORAD.setOidPais(this.pais);
		// DTOEObtenerRegistroAbastecimientoDetalle.idioma = idioma de sesión 
		dtoORAD.setOidIdioma(this.idioma);
		// DTOEObtenerRegistroAbastecimientoDetalle.oidRegistroAbastecimientoCabecera = dtos.oid 
		dtoORAD.setOidRegistroAbastecimientoCabecera(dtos.getOid());
		// DTOEObtenerRegistroAbastecimientoDetalle.almacen = dtos.oidAlmacen 
		dtoORAD.setAlmacen(dtos.getOidAlmacen());
		// DTOEObtenerRegistroAbastecimientoDetalle.agrupacionStock = dtos.oidAgrupacionStock 
		dtoORAD.setAgrupacionStock(dtos.getOidAgrupacionStock());

		// Asignar conector "ConectorObtenerRegistroAbastecimientoDetalle" con el idBusiness y dto creados 
		paramsEntrada = new Vector();
		paramsEntrada.add(dtoORAD);
		paramsEntrada.add(idNegocio);
		traza("***Antes del 2º conector - cargarRegistroAbastecimiento");
		conector = conectar("ConectorObtenerRegistroAbastecimientoDetalle", paramsEntrada);			
		traza("***Valor del conector :" + conector);

		// Recuperar el DTOSalida de respuesta y mapear el RecordSet sobre la lista editable de pantalla
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		// se obtiene el RecordSet
		RecordSet rs = dtoSalida.getResultado();
		traza("***RecordSet del dtoSalida : " + rs);
		
		// de negocio nos llega el OID_PROD en la columna 1 (comienzan en 0)
		// en la lista aparece en la columna oculta 7
		// la elimino, despues de obtener su nombre y valores, y despues la añado al final del recordset
		// dicen que las columnas ocultas deben aparecer al final del recordset
		/*String nombreColumnaOIDProducto = rs.getColumnName(1);
		Vector columnaOIDsProd = rs.getColumn(1);
		rs.removeColumn(1);
		rs.addColumn(nombreColumnaOIDProducto, columnaOIDsProd);*/
		
		Vector cols = rs.getColumnIdentifiers();
		traza("***Columnas del RecordSet : " + cols);
		
		//DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.matriz_ROWSET", rs, cols);
		DruidaConector conectorCargaLista = this.generarConectorFormato("DTOSalida.combo_ROWSET", rs, cols);
		traza("***Valor del  conectorCargaLista: " , conectorCargaLista);
		asignar("LISTAEDITABLE", "datosDeDetalle", conectorCargaLista,"DTOSalida.combo_ROWSET");
		
	   traza("***Salida - LPGenerarRegistroAbastecimiento - cargarRegistroAbastecimiento***");		
   }   


   private void anadirProducto() throws Exception {
   	
   	traza("***Entrada - LPGenerarRegistroAbastecimiento - anadirProducto***");
   	
   	pagina("salidaGenerica");
   	asignar("VAR", "cerrarVentana", "true");
   	asignar("VAR", "ejecutarError", "ejecutarNoCorrecta()");
   	
		String codigoProducto = conectorParametroLimpia("txtCodProducto", "", true);
		
		traza("***Antes de las asignaciones");
				
		// Crear objeto "DTOAnadirProductosRA" 
		DTOAnadirProductosRA dtoAP= new DTOAnadirProductosRA();
		// DTOAnadirProductosRA.pais = pais de sesión 
		dtoAP.setOidPais(this.pais);
		// DTOAnadirProductosRA.idioma = idioma de sesión 
		dtoAP.setOidIdioma(this.idioma);
		// DTOAnadirProductosRA.codigoProducto = codigoProducto de pantalla 
		dtoAP.setCodigoProducto(codigoProducto);
		// DTOAnadirProductosRA.subacceso = oidSubacceso de pantalla 
		dtoAP.setSubacceso(new Long(conectorParametroLimpia("oidSubacceso", "", true)));
		// por incidencia BELC300012171 se asigna valor al atributo almacen de DTOAnadirProductosRA
		dtoAP.setAlmacen(new Long(conectorParametroLimpia("oidAlmacen", "", true)));
    // vbongiov - inc 21741
    dtoAP.setMarca(new Long(conectorParametroLimpia("oidMarca", "", true)));
		
		traza("***Despues de las asignaciones");
		traza("+++++++++++ pais: " + dtoAP.getOidPais() + "           idioma: " + dtoAP.getOidIdioma());
		traza("+++++++++++ DTOAnadirProductosRA: " + dtoAP);
		
		// Crear idBusiness = "BELAnadirProductoRA" 
		MareBusinessID idNegocio = new MareBusinessID("BELAnadirProductosRA");
		traza("***MareBusinessID: " + idNegocio);
		// Asignar al conector "ConectorAnadirProductoRA" con idBusiness y dto creados 
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoAP);
		paramsEntrada.add(idNegocio);
		traza("*************************Antes de conectar con ConectorAnadirProductosRA***");
		DruidaConector conector = conectar("ConectorAnadirProductosRA", paramsEntrada);			
		traza("*************************Despues de conectar con ConectorAnadirProductosRA***");
		
		// Recuperar el DTORegistroAbastecimientoDetalle de respuesta 
		DTORegistroAbastecimientoDetalle dtoRAD = (DTORegistroAbastecimientoDetalle)conector.objeto("DTORegistroAbastecimientoDetalle");
		traza("***DTORegistroAbastecimientoDetalle: " + dtoRAD);
		
		// a partir del DTORegistroAbastecimientoDetalle creamos una cadena de texto con los datos
		// que se insertaran en un registro de la lista editable
		// si todo funciona correctamente, se llamara a la funcion ejecutarCorrecta de 
		// contenido_registro_abastecimiento_generar_detalle2.js pasandole como parametro la cadena creada 
		
		// en la lista editable en que se carga el array aparecen los campos:
		// Cód. producto, Descripción, Stock actual, Stock mínimo, Stock máx., unidades reposición, oid Producto(oculta)
		// el oid viene null. Meto un -1 para que no de errores al insertar en la lista editable
		
		StringBuffer resultado = new StringBuffer();
		resultado.append((new Long(-1)).toString() + ",");
		resultado.append(dtoRAD.getCodigoSAP() + ",");
		resultado.append(dtoRAD.getDescripcionCorta() + ",");
		// por incidencia BELC300012918 Stock actual son unidadesEnviadas
		if (dtoRAD.getUnidadesEnviadas() != null) {
			resultado.append(dtoRAD.getUnidadesEnviadas().toString());
		}
		resultado.append(",");
		if (dtoRAD.getStockMinimo() != null) {
			resultado.append(dtoRAD.getStockMinimo().toString());
		}
		resultado.append(",");
		if (dtoRAD.getStockMaximo() != null) {
			resultado.append(dtoRAD.getStockMaximo().toString());
		}
		resultado.append(",");
		// por incidencia BELC300012918 unidades reposición son unidadesEnviadas
		if (dtoRAD.getUnidadesEnviadas() != null) {
			resultado.append(dtoRAD.getUnidadesEnviadas().toString());
		}
		// por incidencia BELC300013013 se añade el oidProducto a una columna oculta
		resultado.append(",");
		resultado.append(dtoRAD.getOidProducto().toString());
		// añado las unidades confirmadas a una columna oculta
		resultado.append(",");
		resultado.append(dtoRAD.getUnidadesConfirmadas().toString());

		
		traza("********************** resultado: " + resultado.toString());
   	
		asignar("VAR", "ejecutar", "ejecutarCorrecta('" + resultado + "')");
		
		traza("***Salida - LPGenerarRegistroAbastecimiento - anadirProducto***");		
   }   
   
   
   private void guardar() throws Exception {
   	
   	traza("***Entrada - LPGenerarRegistroAbastecimiento - guardar***");		
                  
		pagina("salidaGenerica");
     	asignar("VAR", "cerrarVentana", "false");
     	asignar("VAR", "ejecutar", "Correcto()");

		// Crear DTORegistroAbastecimiento 
		DTORegistroAbastecimiento dtoRegAbast = new DTORegistroAbastecimiento();

		// y llenarlo con los datos de pantalla, salvo el atributo "observaciones" que se llena con NULL 			
		String recuperadoDePagina = null;
		
		recuperadoDePagina = conectorParametroLimpia("oidRegistroAbastecimientoCabecera", "", true);
		traza("*** oidRegistroAbastecimientoCabecera :" + recuperadoDePagina);
		// si se esta creando un nuevo registro de abastecimiento no se ha dado valor a 
		// oidRegistroAbastecimientoCabecera
		Long registroAbastecimientoCabecera = null;
		if (!recuperadoDePagina.equals("")) {
			registroAbastecimientoCabecera = new Long(recuperadoDePagina);
			dtoRegAbast.setOid(registroAbastecimientoCabecera); 
			dtoRegAbast.setFechaEnviado(new Timestamp(System.currentTimeMillis()));  
		}
		
		recuperadoDePagina = conectorParametroLimpia("numeroSolicitud", "", true);
		traza("*** numeroSolicitud :" + recuperadoDePagina);
		dtoRegAbast.setNSolicitud(new Long(recuperadoDePagina));  
		
		//recuperadoDePagina = conectorParametroLimpia("numeroSolicitud", "", true);
		// dtoRegAbast.setFechaCreado();     
		
		//recuperadoDePagina = conectorParametroLimpia("numeroSolicitud", "", true);
		// dtoRegAbast.setFechaEnviado();     
		
		//recuperadoDePagina = conectorParametroLimpia("numeroSolicitud", "", true);
		// dtoRegAbast.setFechaConfirmado();     
		
		//recuperadoDePagina = conectorParametroLimpia("numeroSolicitud", "", true);
		// dtoRegAbast.setFechaIngresado();     
		
		//recuperadoDePagina = conectorParametroLimpia("numeroSolicitud", "", true);
		// dtoRegAbast.setIndicadorSAP();   
			
		/*recuperadoDePagina = conectorParametroLimpia("oidEstadoCreado", "", true);
		traza("*** oidEstadoCreado :" + recuperadoDePagina);*/
		// falta: otra ñapa
		dtoRegAbast.setOidEstadoHojaDemanda(ConstantesBEL.ESTADO_HOJA_DEMANDA_CREADO);   
		
		// por incidencia BELC300012945 el periodo se recupera en negocio
		// a partir de pais, marca y canal
		
		recuperadoDePagina = conectorParametroLimpia("oidMarca", "", true);
		traza("*** oidMarca :" + recuperadoDePagina);
		dtoRegAbast.setOidMarca(new Long(recuperadoDePagina));   
		
		recuperadoDePagina = conectorParametroLimpia("marca", "", true);
		traza("*** marca :" + recuperadoDePagina);
		dtoRegAbast.setDescripcionMarca(recuperadoDePagina);   
			
		recuperadoDePagina = conectorParametroLimpia("oidCanal", "", true);
		traza("*** oidCanal :" + recuperadoDePagina);
		dtoRegAbast.setOidCanal(new Long(recuperadoDePagina));     
		
		recuperadoDePagina = conectorParametroLimpia("canal", "", true);
		traza("*** canal :" + recuperadoDePagina);
		dtoRegAbast.setDescripcionCanal(recuperadoDePagina);     
		
		recuperadoDePagina = conectorParametroLimpia("acceso", "", true);
		traza("*** acceso :" + recuperadoDePagina);
		dtoRegAbast.setDescripcionAcceso(recuperadoDePagina);   
		
		recuperadoDePagina = conectorParametroLimpia("oidSubacceso", "", true);
		traza("*** oidSubacceso :" + recuperadoDePagina);
		dtoRegAbast.setOidSubacceso(new Long(recuperadoDePagina));   
		
		recuperadoDePagina = conectorParametroLimpia("subacceso", "", true);
		traza("*** subacceso :" + recuperadoDePagina);
		dtoRegAbast.setDescripcionSubacceso(recuperadoDePagina);   
		
		recuperadoDePagina = conectorParametroLimpia("oidAlmacen", "", true);
		traza("*** oidAlmacen :" + recuperadoDePagina);
		dtoRegAbast.setOidAlmacen(new Long(recuperadoDePagina));   
		
		recuperadoDePagina = conectorParametroLimpia("almacen", "", true);
		traza("*** almacen :" + recuperadoDePagina);
		dtoRegAbast.setDescripcionAlmacen(recuperadoDePagina);   
		
		recuperadoDePagina = conectorParametroLimpia("oidAgrupacionStock", "", true);
		traza("*** oidAgrupacionStock :" + recuperadoDePagina);
		dtoRegAbast.setOidAgrupacionStock(new Long(recuperadoDePagina));   
		
		recuperadoDePagina = conectorParametroLimpia("opcionCrearRegistro", "", true);
		traza("*** opcionCrearRegistro :" + recuperadoDePagina);
		dtoRegAbast.setOpcionCrearRegistro(new Boolean(recuperadoDePagina));
		
		// fecha de creacion del registro
		dtoRegAbast.setFechaCreado(new Timestamp(System.currentTimeMillis()));	
			
		// asigno valor a los atributos pais e idioma del DTO
		recuperadoDePagina = conectorParametroLimpia("pais", "", true);
		traza("*** pais :" + recuperadoDePagina);
		dtoRegAbast.setOidPais(new Long(recuperadoDePagina));
		
		recuperadoDePagina = conectorParametroLimpia("idioma", "", true);
		traza("*** idioma :" + recuperadoDePagina);
		dtoRegAbast.setOidIdioma(new Long(recuperadoDePagina));
		
		traza("*** pais: " + dtoRegAbast.getOidPais() + "           idioma: " + dtoRegAbast.getOidIdioma());
		traza("*** DTORegistroAbastecimiento :" + dtoRegAbast);
        
        
        /*
         * Modificado por Paola Cabrera
         * Se agrega por inc  BELC300020932
         * 
         * 27/09/2005
         */
        
        dtoRegAbast.setIndicadorSAP(Boolean.FALSE);
        /*
         * Fin modificacion Paola Cabrera
         * 
         */



		// Por cada línea de detalle crear un DTORegistroAbastecimientoDetalle con los datos de la línea 
		// y anadirlo al atributo DTORegistroAbastecimiento.detalle 
		DTORegistroAbastecimientoDetalle unDetalle = null;
		
		String lista = conectorParametroLimpia("detallesEnLista", "", true);
		traza("********** lista: " + lista);

		StringTokenizer st = null;
		String token = null;
		ArrayList detalles = null;
		
		// necesitamos quitar de las cantidades el separador de miles porque sino se producira
		// un error. utilizamos el metodo privado quitarSeparadorMiles
		String separadorMiles = conectorParametroLimpia("hid_SeparadorMiles", "", true);

		// recuperamos los datos de la lista editable en una cadena con el formato:
		// las columnas vienen separadas por el caracter @
      // las filas vienen separadas por el caracter #
			
		if (!lista.equals("")) {
         
         detalles = new ArrayList();
         
         st = new StringTokenizer(lista, "#");
	      
	      while (st.countTokens() > 0) {
   	   
   	      String fila = st.nextToken();
      	   
      	   if (!fila.equals("")) {
            
               StringTokenizer stFila = new StringTokenizer(fila, "@");
               traza("**********fila: " + fila);
               traza("**********tokens: " + stFila.countTokens());
            	if (stFila.countTokens() > 0) {

              		unDetalle = new DTORegistroAbastecimientoDetalle();
            		// campos de lista
               	// oid del detalle, Cód. producto, Descripción, Stock actual, Stock mínimo, Stock máx., unidades reposición (campo editable, caja de texto), oidProducto (columna oculta)
               	// si el oid -1 asigno un null, que es lo que se espera en negocio
               	// para los nuevos detalles
               	
               	token = stFila.nextToken();
               	if ((! token.equals("-1"))&&(!token.equals("-"))) {
               		unDetalle.setOid(new Long(token));
               	}
						unDetalle.setCodigoSAP(stFila.nextToken());
						unDetalle.setDescripcionCorta(stFila.nextToken());

						stFila.nextToken(); // Stock actual
						
						// si en un registro stockMInimo, stockMaximo o unidadesReposicion estaban vacios
						// vendra un "-" 
				
						// stockMInimo
						token = stFila.nextToken();
						if (! token.equals("-")) {
							token = this.quitarSeparadorMiles(token, separadorMiles);
							traza("**********stockMInimo: " + token);
							unDetalle.setStockMinimo(new Long(this.quitarSeparadorMiles(token, separadorMiles)));
						}
						// stockMaximo
						token = stFila.nextToken();
						if (! token.equals("-")) {
							token = this.quitarSeparadorMiles(token, separadorMiles);
							unDetalle.setStockMaximo(new Long(token));
						}
						// unidadesReposicion
						// por incidencia BELC300012918 unidades reposición son unidadesEnviadas
						token = stFila.nextToken();
						if (! token.equals("-")) {
							token = this.quitarSeparadorMiles(token, separadorMiles);
							unDetalle.setUnidadesEnviadas(new Long(this.quitarSeparadorMiles(token, separadorMiles)));
						}
						
						// por incidencia BELC300013013 recuperamos el oidProducto
						unDetalle.setOidProducto(new Long(stFila.nextToken()));
						
						// unidades confirmadas
						token = stFila.nextToken();
						if (! token.equals("-")) {
							unDetalle.setUnidadesConfirmadas(new Long(token));
						}else{
							unDetalle.setUnidadesConfirmadas(new Long(0));
						}

						unDetalle.setUnidadesAtendidas(new Long(0));
						
						unDetalle.setOidRegistroAbastecimientoCabecera(registroAbastecimientoCabecera);
						
						// asigno valor a pais e idioma
						unDetalle.setOidPais(new Long(conectorParametroLimpia("pais", "", true)));
						unDetalle.setOidIdioma(new Long(conectorParametroLimpia("idioma", "", true)));

						traza("*** pais: " + unDetalle.getOidPais() + "           idioma: " + unDetalle.getOidIdioma());
						traza("********** DTORegistroAbastecimientoDetalle: " + unDetalle);
						
						detalles.add(unDetalle);
					}
				}
			}
			
			// se asigna el array con los DTORegistroAbastecimientoDetalle al atributo detalle de DTORegistroAbastecimiento
			dtoRegAbast.setDetalle(detalles);
		}
		
						
		// Crear idBusiness = "BELGuardarRegistroAbastecimiento" 
		MareBusinessID idNegocio = new MareBusinessID("BELGuardarRegistroAbastecimiento");
		traza("***MareBusinessID :" + idNegocio);
      
      //--Agregado Paola Cabrera INC 20932  
      traza("-----------------------------------------");
      traza("Contenido de DTO * " +dtoRegAbast);
      traza("-----------------------------------------");
     //--Fin agregado Paola Cabrera INC 20932  
     
     
		// Asignar conector "ConectorGuardarRegistroAbastecimiento" con idBuisness y DTORegistroAbastecimiento creado
      Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoRegAbast);
      paramsEntrada.add(idNegocio);
      traza("***Antes de conectar");
      DruidaConector conector = conectar("ConectorGuardarRegistroAbastecimiento", paramsEntrada);			
	   
	   traza("***Salida - LPGenerarRegistroAbastecimiento - guardar***");		
   }   
   
   
	protected void logStackTrace(Throwable e) throws Exception {
	   traza("Se produjo la excepcion: " + e.getMessage());
	   
	   ByteArrayOutputStream baos = new ByteArrayOutputStream();
	   PrintStream ps = new PrintStream(baos);
	   e.printStackTrace(ps);
	                     
	   traza("Stack Trace: " + baos.toString());
	}
	
	
   private void cargaCombos(DTOBelcorp dtoBelcorp, 
                            String[] idNegocios, 
                            ArrayList dtos,
                            String[] combos, 
                            String[] seleccionados, 
                            String[] columnas) 
		throws Exception 
   {
      traza("*** Entrada - cargaCombos ***");
      
      try {
         //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
         ComposerViewElementList listelem = new ComposerViewElementList();
         ComposerViewElement elem = null;
         
         DTOBelcorp unDto = null;

         for (int i = 0; i < idNegocios.length; i++) {
            elem=new ComposerViewElement(); 
            elem.setIDBusiness(idNegocios[i]);
            unDto = (DTOBelcorp)dtos.get(i);
            elem.setDTOE(unDto);
            // se especifica la posicion del OID y del campo con la descripcion
            elem.setPosOID(new Byte("0").byteValue()); 
            elem.setPosDesc(new Byte("1").byteValue()); 
            
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
            }
         } else {
            for (int j = 0; j < combos.length; j++) {
               if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals("")) {
               	asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
               } else {
						asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
					}
            }
      	}
      } catch (Exception ex) {
               this.logStackTrace(ex);
      }
      traza("*** Salida - cargaCombos ***");
   }	
   

   private void mostrarVentanaSeleccionProducto() throws Exception {
   	
   	traza("***Entrada - LPGenerarRegistroAbastecimiento - mostrarVentanaSeleccionProducto***");
   	
   	String subacceso = conectorParametroLimpia("oidSubacceso", "", true);
   	traza("**** subacceso: " + subacceso);
   	String oidAlmacen = conectorParametroLimpia("oidAlmacen", "", true);
   	traza("**** oidAlmacen: " + oidAlmacen);
    // vbongiov - inc 21741
    String oidMarca = conectorParametroLimpia("oidMarca", "", true);
   	traza("**** oidMarca: " + oidMarca);
    

   	// se carga la pagina en la que se permite seleccionar un producto para añadirlo a la lista de detalles
   	pagina("contenido_registro_abastecimiento_generar_detalle2");
   	
   	// nombre="contenido_registro_abastecimiento_generar_detalle2" cod="0483" titulo="Generar registro de abastecimiento"
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar_detalle2", "cod", "0483");
		asignarAtributo("PAGINA", "contenido_registro_abastecimiento_generar_detalle2", "msgle", "Generar registro de abastecimiento");
		getConfiguracionMenu("LPGenerarRegistroAbastecimiento", this.casoUso);
		
		
		traza("**** pais: " + this.pais.toString() + "             ****idioma: " + this.idioma.toString());
		asignar("VAR", "pais", this.pais.toString()); 
		asignar("VAR", "idioma", this.idioma.toString());
		asignar("VAR", "oidSubacceso", subacceso);
		asignar("VAR", "oidAlmacen", oidAlmacen);
    // vbongiov - inc 21741
    asignar("VAR", "oidMarca", oidMarca);
		asignar("VAR", "casoUso", this.casoUso); 
   	
   	traza("***Salida - LPGenerarRegistroAbastecimiento - mostrarVentanaSeleccionProducto***");
   }
   

	private DruidaConector generarConectorFormato(String rowsetID, RecordSet datos, Vector columns) 
		throws Exception, DOMException 
	{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
		if(columns == null)
		   columns = new Vector();
		Vector columsDesc = datos.getColumnIdentifiers();
		DruidaConector conectorValoresPosibles = new DruidaConector();
		XMLDocument xmlDoc = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID", rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		for (int i = 0; i < sizeRows; i++) {
		   Element e_row = docDestino.createElement("ROW");
		   e_rows.appendChild(e_row);

		   for (int j = 0; j < sizeColums; j++) {
				if (columns.contains(columsDesc.elementAt(j))) {
					Element e_campo2 = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO", "OBJECTO");
					e_campo2.setAttribute("LONGITUD", "50");
					String dato = "";
					Object datoObj = datos.getValueAt(i, j);
					if (datoObj != null ) {
						if (datoObj instanceof java.sql.Date) {
							dato = this.obtieneCadenaFecha((java.sql.Date) datoObj);
						} 
						// primera fila no debe formatearse (oid del detalle), 
						// tampoco la 7, que contiene el oid producto (oculta)
						// tampoco la 8, que tiene las unidades confirmadas (oculta)
						else if (datoObj instanceof BigDecimal && j != 0	&& j != 7 && j != 8) { 
							dato = this.formateaNumerico(datoObj.toString());
						} else {
							dato = datoObj.toString();
						}
					}
					org.w3c.dom.Text txt = docDestino.createTextNode(dato);
					e_campo2.appendChild(txt);
					e_row.appendChild(e_campo2);
				}
			}
		}

		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		return conectorValoresPosibles;
	}

	private String obtieneCadenaFecha(java.sql.Date valor) throws Exception {
	   String fecha = new String("");
	   if (valor != null) {
			fecha = UtilidadesBelcorp.fechaFormateada(valor, UtilidadesSession.getFormatoFecha(this));
	   }
	   
	   return fecha;
	}

	private String formateaNumerico(String dineroEntrada) throws Exception 
	{
	   String separadorMiles = ",";
	   String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
	   String numeroDecimales = UtilidadesSession.getFormatoNumerico(this);
	   if (separadorDecimales.equals(",")) 
	   	separadorMiles=".";
	         
      StringTokenizer tokens=new StringTokenizer(dineroEntrada, ".");
      StringBuffer bufferEntero=new StringBuffer(tokens.nextToken());// almacena la parte entera.
      StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
      StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
	         
      //Si ya contiene los separadores de mil no formateamos la cadena
      for (int i=0; i<bufferEntero.length(); i++) {
     		if (bufferEntero.charAt(i) == separadorMiles.charAt(0)) 
     			return dineroEntrada;
      }
      int miles=0;
      while (bufferEntero.length()>0) {
         miles++;
         bufferDinero.insert(0, bufferEntero.charAt(bufferEntero.length()-1));
         bufferEntero.deleteCharAt(bufferEntero.length()-1);
         if (miles==3 && bufferEntero.length()>0) {
	         miles=0;
	         bufferDinero.insert(0, separadorMiles);
         }
      }
	
      if (numeroDecimales != null && tokens.hasMoreTokens()) { 
         bufferDecimales.append(tokens.nextToken());
         //Scale siempre vendrá a 00? //creo que en plantillas puede ser de longitud 0
         if (!bufferDecimales.substring(0, bufferDecimales.length()).equals("00") && !bufferDecimales.substring(0, bufferDecimales.length()).equals("0")) {
            if (numeroDecimales.equals("1")) 
               bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,1));
            else if (numeroDecimales.equals("2")) {
					if (bufferDecimales.length() == 2) 
					   bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 2));
					 else if (bufferDecimales.length() == 1)
					 	bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 1) + "0");
            }
         }
      }		
      return bufferDinero.toString();
	}
	
   private String quitarSeparadorMiles(String cantidad, String separadorMiles) {
   
      String resultado = new String("");
      Character separaMiles = new Character(separadorMiles.charAt(0));
      Character car = null;
      
      for (int i=0; i < cantidad.length(); i++) {
         car = new Character(cantidad.charAt(i));
         if (car.compareTo(separaMiles) != 0) {
            resultado += new String(car.toString());
         }
      }
      return resultado;
	}	

}
