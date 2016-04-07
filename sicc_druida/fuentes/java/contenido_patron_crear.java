
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_patron_crear  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_patron_crear" );
      ((Element)v.get(0)).setAttribute("cod","0248" );
      ((Element)v.get(0)).setAttribute("titulo","Crear patrón" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Crear patrón" );
      ((Element)v.get(0)).setAttribute("onload","onload();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(2)).setAttribute("name","txtCodPatron" );
      ((Element)v.get(2)).setAttribute("required","true" );
      ((Element)v.get(2)).setAttribute("cod","823" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(3)).setAttribute("name","txtDescripcion" );
      ((Element)v.get(3)).setAttribute("required","true" );
      ((Element)v.get(3)).setAttribute("cod","9" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","cmbFormulario" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","2285" );
      ((Element)v.get(1)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","comboMedioEnvio" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","913" );
      ((Element)v.get(1)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */
      /* Termina nodo:1   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r \r\rvar oidPatron;\rvar oidPatronOrigen;\rvar oidPeriodo;\rvar oidPatronPeriodo;\rvar copiarPatron;\rvar codigoCopiarPatron;\rvar casoDeUso;\rvar varNoLimpiarSICC = true;\r\rfunction onload(){\r	configurarMenuSecundario('frmFormulario');\r		oidPatron = get('frmFormulario.hOidPatron');\r	oidPatronOrigen = get('frmFormulario.hOidPatronOrigen');\r	oidPeriodo = get('frmFormulario.hOidPeriodo');\r	oidPatronPeriodo = get('frmFormulario.hOidPatronPeriodo');\r	copiarPatron = get('frmFormulario.hCopiarPatron');\r	codigoCopiarPatron = get('frmFormulario.hCodigoCopiarPatron');\r	cargarDatosIniciales();\r	recargaComboSecciones();\r	fMostrarMensajeError();\r}\r\r\rfunction cargarDatosIniciales(){\r\r	set('frmFormulario.txtCodPatron',get('frmFormulario.hCodigoPatron'));\r	set('frmFormulario.txtDescripcion',get('frmFormulario.hDescripcionPatron'));\r\r	var iSeleccionado = new Array(); \r	iSeleccionado[0] = get('frmFormulario.hOidFormulario');\r	set('frmFormulario.cmbFormulario',iSeleccionado);\r	\r	var iSeleccionado = new Array(); \r	iSeleccionado[0] = get('frmFormulario.hOidMedioEnvio'); \r	set('frmFormulario.comboMedioEnvio',iSeleccionado);\r\r	if (get('frmFormulario.hPatronPeriodo') == 'true')\r		set('frmFormulario.chIndicadorPatronPeriodo', 'S');\r	else deshabilitarHabilitarBoton('botonContenido','btnDefinirPeriodo','D');\r\r	if (get('frmFormulario.hActivo') == 'true')\r		set('frmFormulario.rbActivo', 'S');\r	else if (get('frmFormulario.hActivo') == 'false')\r		set('frmFormulario.rbActivo', 'N');\r\r\r	if (get('frmFormulario.hCodigoPatronHabilitado') == 'false'){\r		accion( 'frmFormulario.txtCodPatron', '.disabled=true' );\r		focaliza('frmFormulario.txtDescripcion','');\r	}else{\r		focaliza('frmFormulario.txtCodPatron','');\r	}\r\r	if (get('frmFormulario.hMedioEnvioHabilitado') == 'false')\r		accion( 'frmFormulario.comboMedioEnvio', '.disabled=true' );		\r	\r	if (get('frmFormulario.hCopiarPatronHabilitado') == 'false')\r		deshabilitarHabilitarBoton('botonContenido','btnCopiarPatron','D');\r\r	if (get('frmFormulario.hVerPatronHabilitado') == 'false')\r		deshabilitarHabilitarBoton('botonContenido','btnVerPatron','D');\r\r	if (get('frmFormulario.hAnadirSeccionHabilitado') == 'false')\r		deshabilitarHabilitarBoton('botonContenido','btnSeccion','D');\r\r	if (get('frmFormulario.hModificarSeccionHabilitado') == 'false')\r		deshabilitarHabilitarBoton('botonContenido','btnModificarSeccion','D');\r\r	if (get('frmFormulario.hEliminarSeccionHabilitado') == 'false')\r		deshabilitarHabilitarBoton('botonContenido','btnEliminarSeccion','D');\r}\r\r\r\rfunction fLimpiar(){\r	if (get('frmFormulario.opcionMenu') == 'Modificar patron')  {\r		cargarDatosIniciales();\r	} else {\r		var arrCheck = document.all[\"rbActivo\"];\r		for(var i=0; i< arrCheck.length; i++){\r			if(arrCheck[i].type && arrCheck[i].type.toUpperCase() == \"RADIO\"){\r				document.all[\"rbActivo\"][i].checked = false;\r			}\r		}\r		var arrayCmb = new Array();\r		arrayCmb[arrayCmb.length] =  '';\r		set('frmFormulario.chIndicadorPatronPeriodo', 'N');\r		set('frmFormulario.txtDescripcion','');\r		set('frmFormulario.cmbFormulario',arrayCmb);\r		set('frmFormulario.comboMedioEnvio',arrayCmb);\r		set('frmFormulario.txtCodPatron', '');\r		accion( 'frmFormulario.txtCodPatron', '.disabled=false' );		\r		set('frmFormulario.hCodigoPatronHabilitado','true');\r		set_combo('frmFormulario.comboSeccion', new Array(new Array(\"\",\"\")));\r		limpiarHidden();\r		oidPatron = '';\r		oidPatronOrigen = '';\r		oidPeriodo = '';\r		oidPatronPeriodo = '';\r		copiarPatron = '';\r		codigoCopiarPatron = '';\r		deshabilitarHabilitarBoton('botonContenido','btnCopiarPatron','A');\r		deshabilitarHabilitarBoton('botonContenido','btnVerPatron','D');\r		deshabilitarHabilitarBoton('botonContenido','btnSeccion','A');\r		deshabilitarHabilitarBoton('botonContenido','btnModificarSeccion','D');\r		deshabilitarHabilitarBoton('botonContenido','btnEliminarSeccion','D');\r		focaliza('frmFormulario.txtCodPatron','');\r	}\r}\r\rfunction accionDefinirPeriodo(){\r	var estado = get('frmFormulario.chIndicadorPatronPeriodo');\r\r	if (estado == 'S')  {\r		var oid;\r		var obj = new Object();\r		obj.hCodigoPatron = get('frmFormulario.txtCodPatron') + ' ' + get('frmFormulario.txtDescripcion');\r		obj.esCopiar = get('frmFormulario.esCopiar');\r		obj.oidPatronOrigen = get('frmFormulario.hOidPatronOrigen');\r		var whnd = mostrarModalSICC('LPMantenimientoPatrones','Cargar pagina PGAsignarPeriodo',obj, '795', '210');\r		if (whnd != null)  {\r			oidPeriodo =  whnd[0];\r			oidPatronOrigen = whnd[1];\r			set('frmFormulario.hOidPeriodo', oidPeriodo);\r			set('frmFormulario.hOidPatronOrigen', oidPatronOrigen);				\r			set('frmFormulario.chIndicadorPatronPeriodo', 'S');\r		} else {\r			set('frmFormulario.chIndicadorPatronPeriodo', 'N');\r			deshabilitarHabilitarBoton('botonContenido','btnDefinirPeriodo','D');\r		}		\r	}\r}\r\rfunction accionAnadirSeccion(){\r	if(get('frmFormulario.chIndicadorPatronPeriodo')=='S'&& get('frmFormulario.hOidPeriodo')=='')\r			return GestionarMensaje(\"MSG014\");\r\r	var correcto = comprobarDatosCabecera();\r	var elementos = document.getElementById('comboSeccion');\r	casoDeUso = 'Crear Seccion';\r\r	if (correcto == 'true')  {\r		var numeroSecciones = elementos.length - 1;\r		var numeroSeccion = numeroSecciones + 1;\r		var seccion = null;\r		mostrarDatosSeccion(seccion, numeroSeccion, numeroSecciones) \r	}}\r\rfunction comprobarDatosCabecera(){\r	if (sicc_validaciones_generales())  {\r		var codigoPatron = get('frmFormulario.txtCodPatron');\r		if (codigoPatron == codigoCopiarPatron)\r			GestionarMensaje('1425');\r		return 'true';\r	} else {\r		return 'false';\r	}\r}\r\rfunction accionModificarSeccion(){\r	if(get('frmFormulario.chIndicadorPatronPeriodo')=='S'&& get('frmFormulario.hOidPatron')=='')\r			return GestionarMensaje(\"MSG014\");\r\r	var seccion = get('frmFormulario.comboSeccion');\r	var correcto = comprobarDatosCabecera();\r	casoDeUso = 'Modificar Seccion';\r\r	if (correcto == \"true\")  {\r		if (seccion != '')  {\r			var elementoSecciones = document.getElementById('comboSeccion');\r			var numeroSecciones = elementoSecciones.length - 1;\r			var numeroSeccion = elementoSecciones.selectedIndex;\r			mostrarDatosSeccion(seccion, numeroSeccion, numeroSecciones) 			\r		}			\r	}}\r\rfunction mostrarDatosSeccion (oidSeccion, numeroSeccion, numeroSecciones){\r\r	var obj = new Object();\r	obj.casoDeUso = casoDeUso;\r	obj.oidPatron = oidPatron;\r	obj.oidSeccion = oidSeccion;\r	obj.oidPeriodo = oidPeriodo;\r	obj.oidPatronOrigen = oidPatronOrigen;\r	obj.oidPatronPeriodo = oidPatronPeriodo;\r	obj.numeroSeccion = numeroSeccion;\r	obj.numeroSecciones = numeroSecciones;\r	obj.codigoPatron = get('frmFormulario.txtCodPatron');\r	obj.descripcionPatron = get('frmFormulario.txtDescripcion');\r	obj.oidMedioEnvio = get('frmFormulario.comboMedioEnvio');\r	obj.oidFormulario = get('frmFormulario.cmbFormulario');\r	obj.activo = get('frmFormulario.rbActivo');\r	obj.patronPeriodo = get('frmFormulario.chIndicadorPatronPeriodo');\r	var whnd = mostrarModalSICC('LPDatosSeccion','', obj);\r\r	if (whnd != null){\r		oidPatron = whnd[0];\r		oidPatronPeriodo = whnd[1];\r		if (oidPatronPeriodo == null){\r				oidPatronPeriodo = '';\r		}\r\r		\r		set('frmFormulario.hOidPatron', oidPatron);\r		set('frmFormulario.hOidPatronPeriodo', oidPatronPeriodo);\r	}\r	recargaComboSecciones();\r	configurarPagina();\r}\r\rfunction recargaComboSecciones(){\r\r	if (oidPatron != '')  {\r		var arr = new Array();\r		arr[arr.length] = new Array(\"oid\", oidPatron);\r		recargaCombo('frmFormulario.comboSeccion','MSGSGObtenerSecciones',\r					'es.indra.sicc.util.DTOOID',arr, 'configurarSeccion(datos)');\r	}	\r}\r\r\rfunction configurarSeccion(datos){\r	var  arr = new Array();\r\r	arr[arr.length] = new Array([''],['']);\r	for (var i=0 ;i< datos.length ; i++)  {\r		arr[arr.length] = datos[i];\r	}\r	set_combo('frmFormulario.comboSeccion', arr);\r	configurarPagina();\r}\r\rfunction accionEliminarSeccion(){\r	var oidSeccion = get('frmFormulario.comboSeccion');\r	if (oidSeccion != '')  {\r		setearHidden();\r		set('frmFormulario.hOidSeccion', oidSeccion);\r		set('frmFormulario.accion', 'Eliminar seccion');\r		enviaSICC('frmFormulario','','','N');\r	}\r}\r\rfunction fGuardar(){\r	if(get('frmFormulario.chIndicadorPatronPeriodo')=='S'&& get('frmFormulario.hOidPeriodo')=='')\r			return GestionarMensaje(\"MSG014\");\r	accionGuardar();\r}\r\rfunction accionGuardar(){\r	var cantSecciones = document.getElementById('comboSeccion').length - 1;\r\r	if ((oidPatron != '') && (cantSecciones > 0)) {\r		setearHidden();\r		set('frmFormulario.accion', 'Guardar patron');\r		eval('frmFormulario').oculto = 'S';\r		enviaSICC('frmFormulario');\r	}else{\r		GestionarMensaje('1422');\r	}	\r}\r\rfunction setearHidden(){\r	set('frmFormulario.hDescripcionPatron', get('frmFormulario.txtDescripcion'));\r	set('frmFormulario.hCodigoPatron', get('frmFormulario.txtCodPatron'));\r	set('frmFormulario.hOidFormulario', get('frmFormulario.cmbFormulario'));\r	set('frmFormulario.hActivo', get('frmFormulario.rbActivo'));\r	set('frmFormulario.hOidMedioEnvio', get('frmFormulario.comboMedioEnvio'));\r	set('frmFormulario.hPatronPeriodo', get('frmFormulario.chIndicadorPatronPeriodo'));\r}\r\rfunction guardarOK(){\r	eval('frmFormulario').oculto = 'N';\r	accion( 'frmFormulario.txtCodPatron', '.disabled=false' );\r	set('frmFormulario.hCodigoPatronHabilitado','true');\r	set_combo('frmFormulario.comboSeccion', new Array(new Array(\"\",\"\")));\r	limpiarHidden();\r	oidPatron = '';\r	oidPatronOrigen = '';\r	oidPeriodo = '';\r	oidPatronPeriodo = '';\r	copiarPatron = '';\r	codigoCopiarPatron = '';\r	deshabilitarHabilitarBoton('botonContenido','btnCopiarPatron','A');\r	deshabilitarHabilitarBoton('botonContenido','btnVerPatron','D');\r	deshabilitarHabilitarBoton('botonContenido','btnSeccion','A');\r	deshabilitarHabilitarBoton('botonContenido','btnModificarSeccion','D');\r	deshabilitarHabilitarBoton('botonContenido','btnEliminarSeccion','D');\r	fLimpiar();\r}\r\rfunction limpiarHidden(){\r\r	set('frmFormulario.hOidPatron','');\r	set('frmFormulario.hOidPeriodo','');\r	set('frmFormulario.hOidPatronOrigen','');\r	set('frmFormulario.hOidPatronPeriodo','');\r	set('frmFormulario.hCodigoPatron','');\r	set('frmFormulario.hDescripcionPatron','');\r	set('frmFormulario.hOidFormulario','');\r	set('frmFormulario.hOidMedioEnvio','');\r	set('frmFormulario.hActivo','');\r	set('frmFormulario.hPatronPeriodo','');\r	set('frmFormulario.hCodigoCopiarPatron','');\r	set('frmFormulario.hCopiarPatron','');\r	set('frmFormulario.hOidSeccion','');\r}\r\rfunction guardarKO(){\r}\r\rfunction configurarPagina(){\r	var cantSecciones = document.getElementById('comboSeccion').length - 1;\r	if (cantSecciones > 0)  {\r		deshabilitarHabilitarBoton('botonContenido','btnModificarSeccion','A');\r		deshabilitarHabilitarBoton('botonContenido','btnVerPatron','A');\r		deshabilitarHabilitarBoton('botonContenido','btnEliminarSeccion','A');\r	} else {\r		deshabilitarHabilitarBoton('botonContenido','btnModificarSeccion','D');\r		deshabilitarHabilitarBoton('botonContenido','btnVerPatron','D');\r		deshabilitarHabilitarBoton('botonContenido','btnEliminarSeccion','D');\r	}\r\r	if (oidPatron != '')\r		accion( 'frmFormulario.txtCodPatron', '.disabled=true' );\r		set('frmFormulario.hCodigoPatronHabilitado','false');\r}\r\rfunction accionCopiarPatron(){\r	tomarValoresActuales();\r	set('frmFormulario.accion', 'Mostrar lista patrones');\r	enviaSICC('frmFormulario','','','N');\r}\r\rfunction tomarValoresActuales(){\r	var arr = new Array();\r	if(get('frmFormulario.txtCodPatron')!=\"\")\r		arr[0] = ['codPatron',get('frmFormulario.txtCodPatron')];\r   else arr[0] = ['codPatron',\"NAN\"];\r	if(get('frmFormulario.txtDescripcion')!=\"\")\r		arr[1] = ['descripcion',get('frmFormulario.txtDescripcion')];\r   else  arr[1] = ['descripcion',\"NAN\"];\r	if(get('frmFormulario.cmbFormulario')!=\"\")\r		arr[2] = ['formulario',get('frmFormulario.cmbFormulario')];\r   else arr[2] = ['formulario',\"NAN\"];\r	if(get('frmFormulario.comboMedioEnvio')!=\"\")\r		arr[3] = ['medioEnvio',get('frmFormulario.comboMedioEnvio')];\r   else arr[3] = ['medioEnvio',\"NAN\"];\r	if(get('frmFormulario.rbActivo')!=\"\")\r		arr[4] = ['activo',get('frmFormulario.rbActivo')];\r   else arr[4] = ['activo',\"NAN\"];\r	arr[5] = ['periodo',get('frmFormulario.chIndicadorPatronPeriodo')];\r	set('frmFormulario.valores',arr);\r}\r\rfunction fVolver(){\r	window.close();\r}\r\rfunction accionVerPatron(){\r	var correcto = comprobarDatosCabecera() ;\r	\r	if (correcto == 'true')  {\r		var cantSecciones = document.getElementById('comboSeccion').length - 1;\r		if (cantSecciones > 0)  {\r			var obj = new Object();\r			obj.hOidPatron = get('frmFormulario.hOidPatron');\r			var whnd = mostrarModalSICC('LPMantenimientoPatrones','Mostrar detalle patron',obj);\r		} else {\r			GestionarMensaje('1424');\r		}\r\r	}	\r}\r\rfunction onshtab_CodPatron(){\r	var cantSecciones = document.getElementById('comboSeccion').length - 1;\r	if (cantSecciones > 0)  {\r		focalizaBotonHTML('botonContenido', 'btnEliminarSeccion');\r	} else {\r		focaliza('frmFormulario.comboSeccion');\r	}\r}\r\rfunction onshtab_Descripcion(){\r	if (oidPatron != '') {\r		var cantSecciones = document.getElementById('comboSeccion').length - 1;\r		if (cantSecciones > 0)  {\r			focalizaBotonHTML('botonContenido', 'btnEliminarSeccion');\r		} else {\r			focaliza('frmFormulario.comboSeccion');\r		}\r	} else {\r		focaliza('frmFormulario.txtCodPatron');\r	}\r}\r\rfunction ontab_Secciones(){\r	var cantSecciones = document.getElementById('comboSeccion').length - 1;\r	if (cantSecciones > 0)  {\r		focalizaBotonHTML('botonContenido', 'btnModificarSeccion');\r	} else {\r		focaliza('frmFormulario.txtCodPatron');\r	}\r\r}\r\rfunction ontab_Eliminar(){\r	if (oidPatron != '') {\r		focaliza('frmFormulario.txtDescripcion');\r	} else {\r		focaliza('frmFormulario.txtCodPatron');\r	}\r}\r\rfunction verificarPeriodo(){\r	if(get('frmFormulario.chIndicadorPatronPeriodo')=='S')\r		deshabilitarHabilitarBoton('botonContenido','btnDefinirPeriodo','A');\r	else 	if(get('frmFormulario.chIndicadorPatronPeriodo')=='N')\r					deshabilitarHabilitarBoton('botonContenido','btnDefinirPeriodo','D');\r}\r\r \r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(8)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(9)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(10)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","LPMantenimientoPatrones" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hPais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hCopiarPatronHabilitado" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hVerPatronHabilitado" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hAnadirSeccionHabilitado" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hModificarSeccionHabilitado" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hEliminarSeccionHabilitado" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hOidPatron" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hOidPeriodo" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hOidPatronOrigen" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hOidPatronPeriodo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hCodigoPatron" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hDescripcionPatron" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hOidFormulario" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hOidMedioEnvio" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hActivo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hPatronPeriodo" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hCodigoCopiarPatron" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hCopiarPatron" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hOidSeccion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hCodigoPatronHabilitado" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hMedioEnvioHabilitado" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","valores" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","esCopiar" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(42)).setAttribute("nombre","capaPrototipo" );
      ((Element)v.get(11)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","750" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("height","1" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:44   */

      /* Empieza nodo:51 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(56)).setAttribute("class","legend" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","Alta" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","legend" );
      ((Element)v.get(57)).setAttribute("cod","00127" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","636" );
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("align","left" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("cellpadding","0" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("colspan","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblCodigoPatron" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
      ((Element)v.get(69)).setAttribute("cod","823" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblDesc" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","9" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblFormulario" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","2285" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:65   */

      /* Empieza nodo:80 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(84)).setAttribute("nombre","txtCodPatron" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("max","4" );
      ((Element)v.get(84)).setAttribute("tipo","" );
      ((Element)v.get(84)).setAttribute("onchange","" );
      ((Element)v.get(84)).setAttribute("req","S" );
      ((Element)v.get(84)).setAttribute("size","4" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("validacion","" );
      ((Element)v.get(84)).setAttribute("onshtab","onshtab_CodPatron();" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(88)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("max","40" );
      ((Element)v.get(88)).setAttribute("tipo","" );
      ((Element)v.get(88)).setAttribute("onchange","" );
      ((Element)v.get(88)).setAttribute("req","S" );
      ((Element)v.get(88)).setAttribute("size","40" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("validacion","" );
      ((Element)v.get(88)).setAttribute("onshtab","onshtab_Descripcion();" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(92)).setAttribute("nombre","cmbFormulario" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(92)).setAttribute("size","1" );
      ((Element)v.get(92)).setAttribute("multiple","N" );
      ((Element)v.get(92)).setAttribute("req","S" );
      ((Element)v.get(92)).setAttribute("valorinicial","" );
      ((Element)v.get(92)).setAttribute("textoinicial","" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:80   */

      /* Empieza nodo:96 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("colspan","9" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:99 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","636" );
      ((Element)v.get(101)).setAttribute("border","0" );
      ((Element)v.get(101)).setAttribute("align","left" );
      ((Element)v.get(101)).setAttribute("cellspacing","0" );
      ((Element)v.get(101)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblMedioEnvio" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","913" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblActivo" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("cod","795" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","25" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblIndicadorPatronPeriodo" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("id","datosTitle" );
      ((Element)v.get(114)).setAttribute("cod","965" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(102)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:102   */

      /* Empieza nodo:117 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(121)).setAttribute("nombre","comboMedioEnvio" );
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(121)).setAttribute("size","1" );
      ((Element)v.get(121)).setAttribute("multiple","N" );
      ((Element)v.get(121)).setAttribute("req","S" );
      ((Element)v.get(121)).setAttribute("valorinicial","" );
      ((Element)v.get(121)).setAttribute("textoinicial","" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:123 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("valign","bottom" );
      ((Element)v.get(117)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("class","datosCampos" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(129)).setAttribute("nombre","rbActivo" );
      ((Element)v.get(129)).setAttribute("tipo","H" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(130)).setAttribute("valor","S" );
      ((Element)v.get(130)).setAttribute("check","N" );
      ((Element)v.get(130)).setAttribute("onfocus","" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("cod","117" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Elemento padre:130 / Elemento actual: 131   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(130)).appendChild((Text)v.get(131));

      /* Termina nodo Texto:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(132)).setAttribute("valor","N" );
      ((Element)v.get(132)).setAttribute("check","N" );
      ((Element)v.get(132)).setAttribute("onfocus","" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("cod","87" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Elemento padre:132 / Elemento actual: 133   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(132)).appendChild((Text)v.get(133));

      /* Termina nodo Texto:133   */
      /* Termina nodo:132   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:134 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("valign","bottom" );
      ((Element)v.get(117)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(137)).setAttribute("nombre","chIndicadorPatronPeriodo" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
      ((Element)v.get(137)).setAttribute("onclick","verificarPeriodo();" );
      ((Element)v.get(137)).setAttribute("check","N" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(117)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:117   */

      /* Empieza nodo:140 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("colspan","9" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:58   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:143 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:51   */

      /* Empieza nodo:145 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("class","botonera" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(153)).setAttribute("nombre","btnCopiarPatron" );
      ((Element)v.get(153)).setAttribute("ID","botonContenido" );
      ((Element)v.get(153)).setAttribute("tipo","html" );
      ((Element)v.get(153)).setAttribute("accion","accionCopiarPatron();" );
      ((Element)v.get(153)).setAttribute("estado","false" );
      ((Element)v.get(153)).setAttribute("cod","834" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(154)).setAttribute("nombre","btnVerPatron" );
      ((Element)v.get(154)).setAttribute("ID","botonContenido" );
      ((Element)v.get(154)).setAttribute("tipo","html" );
      ((Element)v.get(154)).setAttribute("accion","accionVerPatron();" );
      ((Element)v.get(154)).setAttribute("estado","false" );
      ((Element)v.get(154)).setAttribute("cod","2273" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(155)).setAttribute("nombre","btnSeccion" );
      ((Element)v.get(155)).setAttribute("ID","botonContenido" );
      ((Element)v.get(155)).setAttribute("tipo","html" );
      ((Element)v.get(155)).setAttribute("accion","accionAnadirSeccion();" );
      ((Element)v.get(155)).setAttribute("estado","false" );
      ((Element)v.get(155)).setAttribute("cod","798" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(157)).setAttribute("nombre","comboSeccion" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).setAttribute("size","1" );
      ((Element)v.get(157)).setAttribute("multiple","N" );
      ((Element)v.get(157)).setAttribute("req","N" );
      ((Element)v.get(157)).setAttribute("valorinicial","" );
      ((Element)v.get(157)).setAttribute("textoinicial","" );
      ((Element)v.get(157)).setAttribute("ontab","ontab_Secciones();" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 152   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(159)).setAttribute("nombre","btnModificarSeccion" );
      ((Element)v.get(159)).setAttribute("ID","botonContenido" );
      ((Element)v.get(159)).setAttribute("tipo","html" );
      ((Element)v.get(159)).setAttribute("accion","accionModificarSeccion();" );
      ((Element)v.get(159)).setAttribute("estado","false" );
      ((Element)v.get(159)).setAttribute("cod","2274" );
      ((Element)v.get(152)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 152   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(160)).setAttribute("nombre","btnEliminarSeccion" );
      ((Element)v.get(160)).setAttribute("ID","botonContenido" );
      ((Element)v.get(160)).setAttribute("tipo","html" );
      ((Element)v.get(160)).setAttribute("accion","accionEliminarSeccion();" );
      ((Element)v.get(160)).setAttribute("estado","false" );
      ((Element)v.get(160)).setAttribute("cod","2275" );
      ((Element)v.get(160)).setAttribute("ontab","ontab_Eliminar();" );
      ((Element)v.get(152)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 152   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(161)).setAttribute("nombre","btnDefinirPeriodo" );
      ((Element)v.get(161)).setAttribute("ID","botonContenido" );
      ((Element)v.get(161)).setAttribute("tipo","html" );
      ((Element)v.get(161)).setAttribute("accion","accionDefinirPeriodo();" );
      ((Element)v.get(161)).setAttribute("estado","false" );
      ((Element)v.get(161)).setAttribute("cod","2852" );
      ((Element)v.get(152)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:162 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:145   */

      /* Empieza nodo:164 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(166)).setAttribute("height","12" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","756" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("height","1" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:164   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:11   */


   }

}
