
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_dias_grafico_insertar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML720(doc);
         

      getXML810(doc);
         

      getXML900(doc);
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         

      getXML1710(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_dias_grafico_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag(); inicializacion();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","0663" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r\r    \r\r         var objActividadClick=null;\r\r                  function onLoadPag() {\r                  try{\r                           tdContenedor.onresize();\r                  }catch(e){\r                           ;\r                  }\r                  try{\r                           tdContenedorDos.onresize();\r                  }catch(e){\r                           ;\r                  }\r                  configurarMenuSecundario(\"frmInsertarMatrizDias\");\r                  fMostrarMensajeError();\r                  DrdEnsanchaConMargenDcho('lstFueraPeriodo',24);\r                  DrdEnsanchaConMargenDcho('lstOtraCampana',24);\r                  if (get('frmInsertarMatrizDias.hListaFueraPeriodoMostrar') == \"SI\") {\r                           mostrarListaEditable();\r                  } else {		\r                           ocultarListaEditable();\r                  }\r                  eval (ON_RSZ);  \r                                    setMV('frmInsertarMatrizDias.cbMarcas','N');\r                  setMV('frmInsertarMatrizDias.cbCanales','N');\r                  setMV('frmInsertarMatrizDias.cbGrupoDeZonas','N');\r                  setMV('frmInsertarMatrizDias.cbGrupoDeZonasSeleccionados','N');\r                  setMV('frmInsertarMatrizDias.cbActividades','N');\r\r				  var accion = get('frmInsertarMatrizDias.accion');\r				  				  if ((accion == \"insertaGrupo\") || (accion == \"insertaActividad\") \r						|| (accion == \"\") || (accion == \"eliminar\")) {\r					  					  deshabilitarHabilitarBoton('botonContenido','btnModoGrafico','D');\r					  deshabilitarHabilitarBoton('botonContenido','btnModoNoGrafico','D');\r				  } else {\r					  					  deshabilitarHabilitarBoton('botonContenido','btnModoGrafico','A');\r					  deshabilitarHabilitarBoton('botonContenido','btnModoNoGrafico','A');\r				  }\r\r				  				  if (get('frmInsertarMatrizDias.hMostrarCreada') == \"si\") {\r												btnProxy('1','0');\r						deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');\r						deshabilitarHabilitarBoton('botonContenido','btnAnyadir','D');	\r						deshabilitarHabilitarBoton('botonContenido','btnAnyadirActividad','D');		\r						deshabilitarHabilitarBoton('botonContenido','btnModificar1','D');		\r						deshabilitarHabilitarBoton('botonContenido','btnEliminar1','D');			\r						deshabilitarHabilitarBoton('botonContenido','btnModificarFueraPeriodo','D');\r						deshabilitarHabilitarBoton('botonContenido','btnEliminarFueraPeriodo','D');\r						deshabilitarHabilitarBoton('botonContenido','btnModificarOtraCampana','D');\r						deshabilitarHabilitarBoton('botonContenido','btnEliminarOtraCampana','D');\r				  }\r		 }\r\r         \r         /*\r         * Inicializa la pagina\r         */\r         function inicializacion() {		\r                  txt_to('lblValorPais', get('frmInsertarMatrizDias.hPaisDescripcion')); \r                  posicionarCombo(); \r                  focaliza('frmInsertarMatrizDias.cbMarcas','');\r         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnBuscar. \r         * Llama a LPMantieneMatrizDias con accion = \"buscar\".\r         */\r         function onClickBuscar() {\r                                    if( ! sicc_validaciones_generales('grupoBuscar') ) {\r                           return false;\r                  }		\r\r                                    obtenerMarcaCanal();\r\r                                    if ( get_visibilidad('capaSeleccion') ) {\r                                                      if ( ! GestionarMensaje(751) ) {\r                                    return;\r                           }\r                  }\r\r                                    set('frmInsertarMatrizDias.accion', 'buscar');\r                  enviaSICC('frmInsertarMatrizDias');\r         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnAnyadir. \r         * Llama a LPMantieneMatrizDias con accion = \"insertaGrupo\"\r         */\r        function onClickAnyadir() {\r                                    if( ! sicc_validaciones_generales('grupoAnyadirGrupoZona') ) {\r                           return false;\r                  }\r\r                                    var arrOidsGruposAnyadir = get('frmInsertarMatrizDias.cbGrupoDeZonas');\r                  set('frmInsertarMatrizDias.hOidsGruposAnyadir', arrOidsGruposAnyadir);			\r\r                                    var arrNombresGruposAnyadir = get('frmInsertarMatrizDias.cbGrupoDeZonas','T');\r                  set('frmInsertarMatrizDias.hNombresGruposAnyadir', arrNombresGruposAnyadir);\r                  \r                                    set('frmInsertarMatrizDias.accion', 'insertaGrupo');\r                  enviaSICC('frmInsertarMatrizDias');\r         }\r\r         \r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnAnyadirActividad.\r         * Llama a LPMantieneMatrizDias con accion = \"insertaActividad\"\r         */\r         function onClickAnyadirActividad() {\r                                    if( ! sicc_validaciones_generales('grupoAnyadirActividad') ) {\r                           return false;\r                  }		\r\r                                    var arrOidsGruposAnyadirMatriz = get('frmInsertarMatrizDias.cbGrupoDeZonasSeleccionados');\r                  set('frmInsertarMatrizDias.hOidsGruposAnyadirMatriz', arrOidsGruposAnyadirMatriz);			\r\r                                    var oidActividadAnyadirMatriz = get('frmInsertarMatrizDias.cbActividades');\r                  set('frmInsertarMatrizDias.hOidActividadAnyadirMatriz', oidActividadAnyadirMatriz);\r\r                                    set('frmInsertarMatrizDias.accion', 'insertaActividad');\r                  enviaSICC('frmInsertarMatrizDias');\r         }\r\r         \r         /*\r         * Al seleccionar una actividad en la matriz, guarda su idVista en hActividadSeleccionada.\r         * Luego se utiliza este valor para identificar que actividad se desea modificar o eliminar.\r         */\r        function seleccionaActividad(idVistaActividad) {\r                                    set('frmInsertarMatrizDias.hActividadSeleccionada', idVistaActividad);\r                                                      if(objActividadClick!=null){\r                           objActividadClick.style.color = objActividadClick.normalColor;\r                           objActividadClick.style.fontWeight = \"normal\";\r                  }\r                  objActividadClick = event.srcElement;\r                  objActividadClick.normalColor = objActividadClick.style.color;\r				  objActividadClick.style.color = \"#000000\";					  objActividadClick.style.fontWeight = \"bold\";	         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnEliminar.\r         * Llama a LPMantieneMatrizDias con accion = \"eliminar\"\r         */\r        function onClickEliminar() {\r                  var idVistaActividad = get('frmInsertarMatrizDias.hActividadSeleccionada');\r                                    if ( (idVistaActividad != null) && (idVistaActividad != '') ) {\r                                                      set('frmInsertarMatrizDias.accion', 'eliminar');\r                           enviaSICC('frmInsertarMatrizDias');\r                  }\r         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnModificar.\r         * Llama a LPMantieneMatrizDias con accion = \"modificar\"\r         */\r        function onClickModificar() {\r                  var idVistaActividad = get('frmInsertarMatrizDias.hActividadSeleccionada');\r                                    if ( (idVistaActividad != null) && (idVistaActividad != '') ) {\r                                                      set('frmInsertarMatrizDias.accion', 'modificar');\r\r                                                      var parametros = new Object();  \r                           parametros.idVistaActividadModificar = idVistaActividad;\r                           parametros.varTipo = get('frmInsertarMatrizDias.varTipo');\r                           parametros.varModo = get('frmInsertarMatrizDias.varModo');\r                           mostrarModalSICC(\"LPMantieneMatrizDias\",\"modificar\", parametros, '650', '250');\r\r                                                      set('frmInsertarMatrizDias.accion', 'refrescaModificacion');\r                           enviaSICC('frmInsertarMatrizDias');\r                  }\r         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnEliminar \r         * Llama a LPMantieneMatrizDias con accion = \"eliminar\" pasandole \r         * las actividades seleccionada en la lista de actividades fuera de periodo.\r         */\r       function onClickEliminarFueraPeriodo() {\r                                    var idVistaActividad = lstFueraPeriodo.codSeleccionados();\r                  set('frmInsertarMatrizDias.hActividadSeleccionada', idVistaActividad);\r                                    onClickEliminar();\r         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnModificarFueraPeriodo.\r         * Llama a LPMantieneMatrizDias con accion = \"modificar\" pasandole\r         * la actividad seleccionada en la lista de actividades fuera de periodo.\r         */\r        function onClickModificarFueraPeriodo() {\r                                    var idVistaActividad = lstFueraPeriodo.codSeleccionados();\r                  set('frmInsertarMatrizDias.hActividadSeleccionada', idVistaActividad);\r                                    onClickModificar();\r         }\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnEliminar \r         * Llama a LPMantieneMatrizDias con accion = \"eliminar\" pasandole \r         * las actividades seleccionada en la lista de actividades otra camapaña.\r         */\r       function onClickEliminarOtraCampana() {\r                                    var idVistaActividad = lstOtraCampana.codSeleccionados();\r                  set('frmInsertarMatrizDias.hActividadSeleccionada', idVistaActividad);\r                                    onClickEliminar();\r         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnModificarFueraPeriodo.\r         * Llama a LPMantieneMatrizDias con accion = \"modificar\" pasandole\r         * la actividad seleccionada en la lista de actividades otra campaña.\r         */\r        function onClickModificarOtraCampana() {\r                                    var idVistaActividad = lstOtraCampana.codSeleccionados();\r                  set('frmInsertarMatrizDias.hActividadSeleccionada', idVistaActividad);\r                                    onClickModificar();\r         }\r\r\r         /*\r         * Se llama a esta función javascript cuando se pulsa sobre el botón btnVerMatriz.\r         * Llama a LPMantieneMatrizDias con accion = \"verMatriz\".\r         */\r        function onClickVerMatriz() {\r                                    set('frmInsertarMatrizDias.accion', 'verMatriz');\r                  enviaSICC('frmInsertarMatrizDias');\r         }\r\r\r         /*\r         * Esta función javascript se realiza cuando se pulsa sobre \"Guardar\" en el menú. \r         * En diseño es accionGuardar().\r         * - Llama a LPMantieneMatrizDias con accion = \"guardar\"\r         */\r        function fGuardar() {\r                                                      set('frmInsertarMatrizDias.accion', 'guardar');\r                  enviaSICC('frmInsertarMatrizDias');\r                  \r         }\r\r\r                 function fLimpiar() { \r                                    focaliza('frmInsertarMatrizDias.cbMarcas');\r         } \r\r\r         /*\r         * Este método se activa al seleccionar un valor en cbMarcas.\r         */\r        function onChangeMarca() {\r                  cambiaFiltro();\r         }\r\r\r         /*\r         * Este método se activa al seleccionar un valor en cbCanales.\r         */\r        function onChangeCanal() {\r                  cambiaFiltro();\r         }\r\r\r         /*\r         * Si existe un valor seleccionado (no vacio) en cmbMarca\r         * y existe un valor seleccionado (no vacio) en cmbCanal, habilitar btnBuscar.\r         */\r        function cambiaFiltro() {\r                  var botonBuscar = document.getElementById('btnBuscar');\r                  if ( (get('frmInsertarMatrizDias.cbMarcas') != null) && (get('frmInsertarMatrizDias.cbMarcas') != '') &&\r                            (get('frmInsertarMatrizDias.cbCanales') != null) && (get('frmInsertarMatrizDias.cbCanales') != '') ) {\r                                                      botonBuscar.enable = true;\r                  } else {\r                                                      botonBuscar.enable = false;\r                  }\r         }\r\r\r                 function focalizaDesdeBusqueda() {  \r                  document.selection.empty();\r                                    if ( ! get_visibilidad('capaSeleccion') ) {\r                           focaliza('frmInsertarMatrizDias.cbMarcas');\r                  } else {\r                           focaliza('frmInsertarMatrizDias.cbGrupoDeZonas');\r                  }\r         }\r\r\r                 function focalizaDesdeSeleccion() {  \r                  document.selection.empty();\r                                    if ( ! (get_visibilidad('capaTablaGrafica') || get_visibilidad('capaTablaNoGrafica')) ) {\r                           focaliza('frmInsertarMatrizDias.cbMarcas');\r                  } else {\r                                                                                 document.all.btnModificar1.focus();\r                  }\r         }\r\r\r                 function focalizaDesdeMatriz() {  \r                  document.selection.empty();\r                  focaliza('frmInsertarMatrizDias.cbMarcas');\r         }\r\r\r                 function focalizaShift() {  \r                  document.selection.empty();\r                                    if (get_visibilidad('capaTablaGrafica')) {\r                                                                                 document.all.btnModoNoGrafico.focus();\r                           return;\r                  }\r                                    if (get_visibilidad('capaTablaNoGrafica')) {\r                                                                                 document.all.btnModoGrafico.focus();\r                           return;\r                  }		\r                                    if (get_visibilidad('capaSeleccion')) {\r                                                                                 document.all.btnAnyadirActividad.focus();\r                           return;\r                  }\r                                    if (get_visibilidad('capaBusqueda')) {\r                                                                                 document.all.btnBuscar.focus();\r                           return;\r                  }\r         }\r\r\r                 function obtenerMarcaCanal(){ \r                  set('frmInsertarMatrizDias.hCanal', get('frmInsertarMatrizDias.cbCanales')); \r                  set('frmInsertarMatrizDias.hMarca', get('frmInsertarMatrizDias.cbMarcas')); \r         } \r\r\r                 function posicionarCombo() { \r                                    var iSeleccionadoMarca = new Array(); \r                  iSeleccionadoMarca[0] = get('frmInsertarMatrizDias.hMarca'); \r                  set('frmInsertarMatrizDias.cbMarcas',iSeleccionadoMarca); \r\r                                    var iSeleccionadoCanal = new Array(); \r                  iSeleccionadoCanal[0] = get('frmInsertarMatrizDias.hCanal'); \r                  set('frmInsertarMatrizDias.cbCanales',iSeleccionadoCanal); \r\r                                    var oidsGruposAnyadir = get('frmInsertarMatrizDias.hOidsGruposAnyadir'); \r                  iSeleccionadoGrupos = oidsGruposAnyadir.split(\",\");\r                  set('frmInsertarMatrizDias.cbGrupoDeZonas',iSeleccionadoGrupos); \r\r                                    var oidsGruposAnyadirMatriz = get('frmInsertarMatrizDias.hOidsGruposAnyadirMatriz'); \r                  iSeleccionadoGruposSelMatriz = oidsGruposAnyadirMatriz.split(\",\");\r                  set('frmInsertarMatrizDias.cbGrupoDeZonasSeleccionados',iSeleccionadoGruposSelMatriz); \r\r                                    var iSeleccionadoActividad = new Array();\r                  iSeleccionadoActividad[0] = get('frmInsertarMatrizDias.hOidActividadAnyadirMatriz'); \r                  set('frmInsertarMatrizDias.cbActividades',iSeleccionadoActividad); \r         } \r\r\r                 function mostrarListaEditable() {\r                                    document.all[\"CplstFueraPeriodo\"].style.visibility='visible';\r                  document.all[\"CpLin1lstFueraPeriodo\"].style.visibility='visible';\r                  document.all[\"CpLin2lstFueraPeriodo\"].style.visibility='visible';\r                  document.all[\"CpLin3lstFueraPeriodo\"].style.visibility='visible';\r                  document.all[\"CpLin4lstFueraPeriodo\"].style.visibility='visible';\r\r                  document.all[\"primera2Div\"].style.visibility='visible';\r                  document.all[\"ret2Div\"].style.visibility='visible';\r                  document.all[\"ava2Div\"].style.visibility='visible';\r                  document.all[\"separa2Div\"].style.visibility='visible';\r\r                  document.all[\"btnModificarFueraPeriodoDiv\"].style.visibility='visible';\r                  document.all[\"btnEliminarFueraPeriodoDiv\"].style.visibility='visible';\r\r		                    document.all[\"CplstOtraCampana\"].style.visibility='visible';\r                  document.all[\"CpLin1lstOtraCampana\"].style.visibility='visible';\r                  document.all[\"CpLin2lstOtraCampana\"].style.visibility='visible';\r                  document.all[\"CpLin3lstOtraCampana\"].style.visibility='visible';\r                  document.all[\"CpLin4lstOtraCampana\"].style.visibility='visible';\r\r                  document.all[\"primera3Div\"].style.visibility='visible';\r                  document.all[\"ret3Div\"].style.visibility='visible';\r                  document.all[\"ava3Div\"].style.visibility='visible';\r                  document.all[\"separa3Div\"].style.visibility='visible';\r\r                  document.all[\"btnModificarOtraCampanaDiv\"].style.visibility='visible';\r                  document.all[\"btnEliminarOtraCampanaDiv\"].style.visibility='visible';\r         }\r\r\r                 function ocultarListaEditable() {\r                                    document.all[\"CplstFueraPeriodo\"].style.visibility='hidden';\r                  document.all[\"CpLin1lstFueraPeriodo\"].style.visibility='hidden';\r                  document.all[\"CpLin2lstFueraPeriodo\"].style.visibility='hidden';\r                  document.all[\"CpLin3lstFueraPeriodo\"].style.visibility='hidden';\r                  document.all[\"CpLin4lstFueraPeriodo\"].style.visibility='hidden';\r\r                  document.all[\"primera2Div\"].style.visibility='hidden';\r                  document.all[\"ret2Div\"].style.visibility='hidden';\r                  document.all[\"ava2Div\"].style.visibility='hidden';\r                  document.all[\"separa2Div\"].style.visibility='hidden';\r\r                  document.all[\"btnModificarFueraPeriodoDiv\"].style.visibility='hidden';\r                  document.all[\"btnEliminarFueraPeriodoDiv\"].style.visibility='hidden';\r\r		                    document.all[\"CplstOtraCampana\"].style.visibility='hidden';\r                  document.all[\"CpLin1lstOtraCampana\"].style.visibility='hidden';\r                  document.all[\"CpLin2lstOtraCampana\"].style.visibility='hidden';\r                  document.all[\"CpLin3lstOtraCampana\"].style.visibility='hidden';\r                  document.all[\"CpLin4lstOtraCampana\"].style.visibility='hidden';\r\r                  document.all[\"primera3Div\"].style.visibility='hidden';\r                  document.all[\"ret3Div\"].style.visibility='hidden';\r                  document.all[\"ava3Div\"].style.visibility='hidden';\r                  document.all[\"separa3Div\"].style.visibility='hidden';\r\r                  document.all[\"btnModificarOtraCampanaDiv\"].style.visibility='hidden';\r                  document.all[\"btnEliminarOtraCampanaDiv\"].style.visibility='hidden';		  \r         }\r\r\r   \r\r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbMarcas" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","6" );
      ((Element)v.get(5)).setAttribute("group","grupoBuscar" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbCanales" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","7" );
      ((Element)v.get(6)).setAttribute("group","grupoBuscar" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbGrupoDeZonas" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","2195" );
      ((Element)v.get(7)).setAttribute("group","grupoAnyadirGrupoZona" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbGrupoDeZonasSeleccionados" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","238" );
      ((Element)v.get(8)).setAttribute("group","grupoAnyadirActividad" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbActividades" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","173" );
      ((Element)v.get(9)).setAttribute("group","grupoAnyadirActividad" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:4   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmInsertarMatrizDias" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","varModo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","varTipo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(14)).setAttribute("valor","LPMantieneMatrizDias" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hPais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hPaisDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hMarca" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hCanal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hOidsGruposAnyadir" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hNombresGruposAnyadir" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hOidsGruposAnyadirMatriz" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hOidActividadAnyadirMatriz" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hActividadSeleccionada" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hListaFueraPeriodoMostrar" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hMostrarCreada" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(29)).setAttribute("nombre","capaBusqueda" );
      ((Element)v.get(29)).setAttribute("x","0" );
      ((Element)v.get(29)).setAttribute("y","0" );
      ((Element)v.get(29)).setAttribute("visibilidad","visible" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("height","12" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","750" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(31)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","1" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:31   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(43)).setAttribute("class","legend" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("id","legend" );
      ((Element)v.get(44)).setAttribute("cod","0075" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
      ((Element)v.get(45)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","705" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("align","left" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("colspan","3" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:52 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lblPais" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","5" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","6" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","7" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:52   */

      /* Empieza nodo:67 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("valign","bottom" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblValorPais" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(75)).setAttribute("nombre","cbMarcas" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("size","1" );
      ((Element)v.get(75)).setAttribute("multiple","N" );
      ((Element)v.get(75)).setAttribute("req","S" );
      ((Element)v.get(75)).setAttribute("valorinicial","" );
      ((Element)v.get(75)).setAttribute("textoinicial","" );
      ((Element)v.get(75)).setAttribute("accion","onChangeMarca();" );
      ((Element)v.get(75)).setAttribute("onshtab","focalizaShift();" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:77 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(80)).setAttribute("nombre","cbCanales" );
      ((Element)v.get(80)).setAttribute("id","datosCampos" );
      ((Element)v.get(80)).setAttribute("size","1" );
      ((Element)v.get(80)).setAttribute("multiple","N" );
      ((Element)v.get(80)).setAttribute("req","S" );
      ((Element)v.get(80)).setAttribute("valorinicial","" );
      ((Element)v.get(80)).setAttribute("textoinicial","" );
      ((Element)v.get(80)).setAttribute("accion","onChangeCanal();" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(67)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:67   */

      /* Empieza nodo:84 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("colspan","3" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:87 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:38   */

      /* Empieza nodo:89 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(30)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","center" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("class","botonera" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(97)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(97)).setAttribute("ID","botonContenido" );
      ((Element)v.get(97)).setAttribute("tipo","html" );
      ((Element)v.get(97)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(97)).setAttribute("estado","false" );
      ((Element)v.get(97)).setAttribute("cod","1" );
      ((Element)v.get(97)).setAttribute("ontab","focalizaDesdeBusqueda();" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","12" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:89   */

      /* Empieza nodo:100 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","12" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","756" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","1" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:107 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(107)).setAttribute("nombre","capaSeleccion" );
      ((Element)v.get(107)).setAttribute("x","0" );
      ((Element)v.get(107)).setAttribute("y","102" );
      ((Element)v.get(107)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(10)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","12" );
      ((Element)v.get(111)).setAttribute("height","12" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","750" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(115)).setAttribute("height","1" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:109   */

      /* Empieza nodo:116 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(121)).setAttribute("class","legend" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblSeleccionDatos" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","legend" );
      ((Element)v.get(122)).setAttribute("cod","0099" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("cellpadding","0" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","705" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("colspan","3" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblGrupoDeZonas" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","2195" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:130   */

      /* Empieza nodo:137 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbGrupoDeZonas" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("size","5" );
      ((Element)v.get(141)).setAttribute("multiple","S" );
      ((Element)v.get(141)).setAttribute("req","S" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(137)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:137   */

      /* Empieza nodo:145 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("colspan","3" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:148 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:116   */

      /* Empieza nodo:150 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("class","botonera" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(158)).setAttribute("nombre","btnAnyadir" );
      ((Element)v.get(158)).setAttribute("ID","botonContenido" );
      ((Element)v.get(158)).setAttribute("tipo","html" );
      ((Element)v.get(158)).setAttribute("accion","onClickAnyadir();" );
      ((Element)v.get(158)).setAttribute("estado","false" );
      ((Element)v.get(158)).setAttribute("cod","404" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:150   */

      /* Empieza nodo:161 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("colspan","3" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","15" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(169)).setAttribute("class","legend" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblSeleccionDatos" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","legend" );
      ((Element)v.get(170)).setAttribute("cod","0099" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","center" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","705" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("align","left" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("colspan","3" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblGrupoDeZonasSeleccionados" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","238" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","173" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:178   */

      /* Empieza nodo:189 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(193)).setAttribute("nombre","cbGrupoDeZonasSeleccionados" );
      ((Element)v.get(193)).setAttribute("id","datosCampos" );
      ((Element)v.get(193)).setAttribute("size","5" );
      ((Element)v.get(193)).setAttribute("multiple","S" );
      ((Element)v.get(193)).setAttribute("req","S" );
      ((Element)v.get(193)).setAttribute("valorinicial","" );
      ((Element)v.get(193)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:195 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("valign","top" );
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(198)).setAttribute("nombre","cbActividades" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("size","1" );
      ((Element)v.get(198)).setAttribute("multiple","N" );
      ((Element)v.get(198)).setAttribute("req","S" );
      ((Element)v.get(198)).setAttribute("valorinicial","" );
      ((Element)v.get(198)).setAttribute("textoinicial","" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(189)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:189   */

      /* Empieza nodo:202 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("colspan","3" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:205 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:164   */

      /* Empieza nodo:207 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("table"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(212)).setAttribute("border","0" );
      ((Element)v.get(212)).setAttribute("align","center" );
      ((Element)v.get(212)).setAttribute("cellspacing","0" );
      ((Element)v.get(212)).setAttribute("cellpadding","0" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("class","botonera" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(215)).setAttribute("nombre","btnAnyadirActividad" );
      ((Element)v.get(215)).setAttribute("ID","botonContenido" );
      ((Element)v.get(215)).setAttribute("tipo","html" );
      ((Element)v.get(215)).setAttribute("accion","onClickAnyadirActividad();" );
      ((Element)v.get(215)).setAttribute("estado","false" );
      ((Element)v.get(215)).setAttribute("cod","256" );
      ((Element)v.get(215)).setAttribute("ontab","focalizaDesdeSeleccion();" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:216 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","12" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:207   */

      /* Empieza nodo:218 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("width","12" );
      ((Element)v.get(219)).setAttribute("align","center" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(220)).setAttribute("height","12" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","756" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("width","12" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("height","1" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:218   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:225 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(225)).setAttribute("nombre","capaTablaGrafica" );
      ((Element)v.get(225)).setAttribute("borde","0" );
      ((Element)v.get(225)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(225)).setAttribute("x","0" );
      ((Element)v.get(225)).setAttribute("y","400" );
      ((Element)v.get(10)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("table"));
      ((Element)v.get(226)).setAttribute("width","100%" );
      ((Element)v.get(226)).setAttribute("border","0" );
      ((Element)v.get(226)).setAttribute("cellspacing","0" );
      ((Element)v.get(226)).setAttribute("cellpadding","0" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(228)).setAttribute("align","center" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(229)).setAttribute("height","12" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("width","750" );
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("width","12" );
      ((Element)v.get(227)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(233)).setAttribute("height","1" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:227   */

      /* Empieza nodo:234 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(239)).setAttribute("class","legend" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblDatosDeModoGrafico" );
      ((Element)v.get(240)).setAttribute("alto","13" );
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("id","legend" );
      ((Element)v.get(240)).setAttribute("cod","00552" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("table"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(241)).setAttribute("border","0" );
      ((Element)v.get(241)).setAttribute("align","center" );
      ((Element)v.get(241)).setAttribute("cellspacing","0" );
      ((Element)v.get(241)).setAttribute("cellpadding","0" );
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(242)).setAttribute("valign","top" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("id","tdContenedor" );
      ((Element)v.get(243)).setAttribute("style","border:1px solid #CECFCE" );
      ((Element)v.get(243)).setAttribute("onresize","try{document.getElementById('miscroll').style.width=this.offsetWidth-15;             document.getElementById('capaBotones').style.width=this.offsetWidth-6;           }catch(e){;}" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(244)).setAttribute("nombre","rejMatrizDias" );
      ((Element)v.get(244)).setAttribute("alto","317" );
      ((Element)v.get(244)).setAttribute("ancho","684" );
      ((Element)v.get(244)).setAttribute("x","24" );
      ((Element)v.get(244)).setAttribute("y","437" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("table"));
      ((Element)v.get(247)).setAttribute("width","705" );
      ((Element)v.get(247)).setAttribute("border","0" );
      ((Element)v.get(247)).setAttribute("align","left" );
      ((Element)v.get(247)).setAttribute("cellspacing","0" );
      ((Element)v.get(247)).setAttribute("cellpadding","0" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","1010" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:241   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:251 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:234   */

      /* Empieza nodo:253 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("table"));
      ((Element)v.get(258)).setAttribute("width","100%" );
      ((Element)v.get(258)).setAttribute("border","0" );
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(258)).setAttribute("cellspacing","0" );
      ((Element)v.get(258)).setAttribute("cellpadding","0" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("class","botonera" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(261)).setAttribute("nombre","btnModoNoGrafico" );
      ((Element)v.get(261)).setAttribute("ID","botonContenido" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(261)).setAttribute("tipo","html" );
      ((Element)v.get(261)).setAttribute("accion","onClickVerMatriz();" );
      ((Element)v.get(261)).setAttribute("estado","false" );
      ((Element)v.get(261)).setAttribute("cod","2283" );
      ((Element)v.get(261)).setAttribute("ontab","focalizaDesdeMatriz();" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:262 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:253   */

      /* Empieza nodo:264 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","12" );
      ((Element)v.get(265)).setAttribute("align","center" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","12" );
      ((Element)v.get(266)).setAttribute("height","12" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","756" );
      ((Element)v.get(264)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("width","12" );
      ((Element)v.get(264)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","12" );
      ((Element)v.get(270)).setAttribute("height","1" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:264   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:271 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(271)).setAttribute("nombre","lstFueraPeriodo" );
      ((Element)v.get(271)).setAttribute("ancho","684" );
      ((Element)v.get(271)).setAttribute("alto","317" );
      ((Element)v.get(271)).setAttribute("x","24" );
      ((Element)v.get(271)).setAttribute("y","779" );
      ((Element)v.get(271)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(271)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(272)).setAttribute("precarga","S" );
      ((Element)v.get(272)).setAttribute("conROver","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(273)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(273)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(273)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(273)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 272   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(274)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(274)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(274)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(274)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(275)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(275)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:272   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(271)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(277)).setAttribute("borde","1" );
      ((Element)v.get(277)).setAttribute("horizDatos","1" );
      ((Element)v.get(277)).setAttribute("horizCabecera","1" );
      ((Element)v.get(277)).setAttribute("vertical","1" );
      ((Element)v.get(277)).setAttribute("horizTitulo","1" );
      ((Element)v.get(277)).setAttribute("horizBase","1" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 276   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(278)).setAttribute("borde","#999999" );
      ((Element)v.get(278)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(278)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(278)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(278)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(278)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(278)).setAttribute("horizBase","#999999" );
      ((Element)v.get(276)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:276   */

      /* Empieza nodo:279 / Elemento padre: 271   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(279)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(279)).setAttribute("alto","22" );
      ((Element)v.get(279)).setAttribute("imgFondo","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(279)).setAttribute("cod","0046" );
      ((Element)v.get(279)).setAttribute("ID","datosTitle" );
      ((Element)v.get(271)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 271   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(280)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(280)).setAttribute("alto","22" );
      ((Element)v.get(280)).setAttribute("imgFondo","" );
      ((Element)v.get(271)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 271   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(281)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(281)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(281)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(281)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(281)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(281)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("ancho","80" );
      ((Element)v.get(282)).setAttribute("minimizable","S" );
      ((Element)v.get(282)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("ancho","60" );
      ((Element)v.get(283)).setAttribute("minimizable","S" );
      ((Element)v.get(283)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("ancho","170" );
      ((Element)v.get(284)).setAttribute("minimizable","S" );
      ((Element)v.get(284)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("ancho","100" );
      ((Element)v.get(285)).setAttribute("minimizable","S" );
      ((Element)v.get(285)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("ancho","120" );
      ((Element)v.get(286)).setAttribute("minimizable","S" );
      ((Element)v.get(286)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("ancho","80" );
      ((Element)v.get(287)).setAttribute("minimizable","S" );
      ((Element)v.get(287)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("ancho","100" );
      ((Element)v.get(288)).setAttribute("minimizable","S" );
      ((Element)v.get(288)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","120" );
      ((Element)v.get(289)).setAttribute("minimizable","S" );
      ((Element)v.get(289)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:281   */

      /* Empieza nodo:290 / Elemento padre: 271   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(290)).setAttribute("alto","20" );
      ((Element)v.get(290)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(290)).setAttribute("imgFondo","" );
      ((Element)v.get(290)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(271)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("colFondo","" );
      ((Element)v.get(291)).setAttribute("ID","EstCab" );
      ((Element)v.get(291)).setAttribute("cod","2195" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("colFondo","" );
      ((Element)v.get(292)).setAttribute("ID","EstCab" );
      ((Element)v.get(292)).setAttribute("cod","261" );
      ((Element)v.get(290)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("colFondo","" );
      ((Element)v.get(293)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).setAttribute("cod","192" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("colFondo","" );
      ((Element)v.get(294)).setAttribute("ID","EstCab" );
      ((Element)v.get(294)).setAttribute("cod","151" );
      ((Element)v.get(290)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("cod","174" );
      ((Element)v.get(290)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("colFondo","" );
      ((Element)v.get(296)).setAttribute("ID","EstCab" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(296)).setAttribute("cod","193" );
      ((Element)v.get(290)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).setAttribute("cod","194" );
      ((Element)v.get(290)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 290   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("colFondo","" );
      ((Element)v.get(298)).setAttribute("ID","EstCab" );
      ((Element)v.get(298)).setAttribute("cod","293" );
      ((Element)v.get(290)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:290   */

      /* Empieza nodo:299 / Elemento padre: 271   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(299)).setAttribute("alto","22" );
      ((Element)v.get(299)).setAttribute("accion","" );
      ((Element)v.get(299)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(299)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(299)).setAttribute("maxSel","1" );
      ((Element)v.get(299)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(299)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(299)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(299)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(271)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","texto" );
      ((Element)v.get(302)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("tipo","texto" );
      ((Element)v.get(305)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("tipo","texto" );
      ((Element)v.get(306)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("tipo","texto" );
      ((Element)v.get(307)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:299   */

      /* Empieza nodo:308 / Elemento padre: 271   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(271)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 271   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(309)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(309)).setAttribute("ancho","684" );
      ((Element)v.get(309)).setAttribute("sep","$" );
      ((Element)v.get(309)).setAttribute("x","24" );
      ((Element)v.get(309)).setAttribute("class","botonera" );
      ((Element)v.get(309)).setAttribute("y","1073" );
      ((Element)v.get(309)).setAttribute("control","|" );
      ((Element)v.get(309)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(309)).setAttribute("rowset","" );
      ((Element)v.get(309)).setAttribute("cargainicial","N" );
      ((Element)v.get(271)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(310)).setAttribute("nombre","ret2" );
      ((Element)v.get(310)).setAttribute("x","49" );
      ((Element)v.get(310)).setAttribute("y","1077" );
      ((Element)v.get(310)).setAttribute("ID","botonContenido" );
      ((Element)v.get(310)).setAttribute("img","retroceder_on" );
      ((Element)v.get(310)).setAttribute("tipo","0" );
      ((Element)v.get(310)).setAttribute("estado","false" );
      ((Element)v.get(310)).setAttribute("alt","" );
      ((Element)v.get(310)).setAttribute("codigo","" );
      ((Element)v.get(310)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 309   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","ava2" );
      ((Element)v.get(311)).setAttribute("x","64" );
      ((Element)v.get(311)).setAttribute("y","1077" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("img","avanzar_on" );
      ((Element)v.get(311)).setAttribute("tipo","0" );
      ((Element)v.get(311)).setAttribute("estado","false" );
      ((Element)v.get(311)).setAttribute("alt","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(311)).setAttribute("codigo","" );
      ((Element)v.get(311)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(309)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:309   */
      /* Termina nodo:271   */

      /* Empieza nodo:312 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(312)).setAttribute("nombre","primera2" );
      ((Element)v.get(312)).setAttribute("x","32" );
      ((Element)v.get(312)).setAttribute("y","1077" );
      ((Element)v.get(312)).setAttribute("ID","botonContenido" );
      ((Element)v.get(312)).setAttribute("img","primera_on" );
      ((Element)v.get(312)).setAttribute("tipo","-2" );
      ((Element)v.get(312)).setAttribute("estado","false" );
      ((Element)v.get(312)).setAttribute("alt","" );
      ((Element)v.get(312)).setAttribute("codigo","" );
      ((Element)v.get(312)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(313)).setAttribute("nombre","separa2" );
      ((Element)v.get(313)).setAttribute("x","71" );
      ((Element)v.get(313)).setAttribute("y","1073" );
      ((Element)v.get(313)).setAttribute("ID","botonContenido" );
      ((Element)v.get(313)).setAttribute("img","separa_base" );
      ((Element)v.get(313)).setAttribute("tipo","0" );
      ((Element)v.get(313)).setAttribute("estado","false" );
      ((Element)v.get(313)).setAttribute("alt","" );
      ((Element)v.get(313)).setAttribute("codigo","" );
      ((Element)v.get(313)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(314)).setAttribute("nombre","btnModificarFueraPeriodo" );
      ((Element)v.get(314)).setAttribute("x","92" );
      ((Element)v.get(314)).setAttribute("y","1074" );
      ((Element)v.get(314)).setAttribute("ID","botonContenido" );
      ((Element)v.get(314)).setAttribute("tipo","html" );
      ((Element)v.get(314)).setAttribute("estado","false" );
      ((Element)v.get(314)).setAttribute("cod","2" );
      ((Element)v.get(314)).setAttribute("accion","onClickModificarFueraPeriodo();" );
      ((Element)v.get(10)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(315)).setAttribute("nombre","btnEliminarFueraPeriodo" );
      ((Element)v.get(315)).setAttribute("x","158" );
      ((Element)v.get(315)).setAttribute("y","1074" );
      ((Element)v.get(315)).setAttribute("ID","botonContenido" );
      ((Element)v.get(315)).setAttribute("tipo","html" );
      ((Element)v.get(315)).setAttribute("estado","false" );
      ((Element)v.get(315)).setAttribute("cod","1254" );
      ((Element)v.get(315)).setAttribute("accion","onClickEliminarFueraPeriodo();" );
      ((Element)v.get(10)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(316)).setAttribute("nombre","lstOtraCampana" );
      ((Element)v.get(316)).setAttribute("ancho","684" );
      ((Element)v.get(316)).setAttribute("alto","317" );
      ((Element)v.get(316)).setAttribute("x","24" );
      ((Element)v.get(316)).setAttribute("y","1116" );
      ((Element)v.get(316)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(316)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(317)).setAttribute("precarga","S" );
      ((Element)v.get(317)).setAttribute("conROver","S" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(318)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(318)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(318)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(318)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 317   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(319)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(319)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(319)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(319)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(317)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(320)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(320)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:317   */

      /* Empieza nodo:321 / Elemento padre: 316   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(316)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(322)).setAttribute("borde","1" );
      ((Element)v.get(322)).setAttribute("horizDatos","1" );
      ((Element)v.get(322)).setAttribute("horizCabecera","1" );
      ((Element)v.get(322)).setAttribute("vertical","1" );
      ((Element)v.get(322)).setAttribute("horizTitulo","1" );
      ((Element)v.get(322)).setAttribute("horizBase","1" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 321   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(323)).setAttribute("borde","#999999" );
      ((Element)v.get(323)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(323)).setAttribute("vertDatos","#FFFFFF" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(323)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(323)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(323)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(323)).setAttribute("horizBase","#999999" );
      ((Element)v.get(321)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 316   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(324)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(324)).setAttribute("alto","22" );
      ((Element)v.get(324)).setAttribute("imgFondo","" );
      ((Element)v.get(324)).setAttribute("cod","00682" );
      ((Element)v.get(324)).setAttribute("ID","datosTitle" );
      ((Element)v.get(316)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 316   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(325)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(325)).setAttribute("alto","22" );
      ((Element)v.get(325)).setAttribute("imgFondo","" );
      ((Element)v.get(316)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 316   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(326)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(326)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(326)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(326)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(326)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(326)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(316)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("ancho","80" );
      ((Element)v.get(327)).setAttribute("minimizable","S" );
      ((Element)v.get(327)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("ancho","100" );
      ((Element)v.get(328)).setAttribute("minimizable","S" );
      ((Element)v.get(328)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("ancho","120" );
      ((Element)v.get(329)).setAttribute("minimizable","S" );
      ((Element)v.get(329)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("ancho","100" );
      ((Element)v.get(330)).setAttribute("minimizable","S" );
      ((Element)v.get(330)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("ancho","100" );
      ((Element)v.get(331)).setAttribute("minimizable","S" );
      ((Element)v.get(331)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("ancho","120" );
      ((Element)v.get(332)).setAttribute("minimizable","S" );
      ((Element)v.get(332)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("ancho","120" );
      ((Element)v.get(333)).setAttribute("minimizable","S" );
      ((Element)v.get(333)).setAttribute("minimizada","N" );
      ((Element)v.get(326)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:326   */

      /* Empieza nodo:334 / Elemento padre: 316   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(334)).setAttribute("alto","30" );
      ((Element)v.get(334)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(334)).setAttribute("imgFondo","" );
      ((Element)v.get(334)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(316)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("colFondo","" );
      ((Element)v.get(335)).setAttribute("ID","EstCab" );
      ((Element)v.get(335)).setAttribute("cod","2195" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Elemento padre:335 / Elemento actual: 336   */
      v.add(doc.createTextNode("Grupo zona"));
      ((Element)v.get(335)).appendChild((Text)v.get(336));

      /* Termina nodo Texto:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("colFondo","" );
      ((Element)v.get(337)).setAttribute("ID","EstCab" );
      ((Element)v.get(337)).setAttribute("cod","151" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Elemento padre:337 / Elemento actual: 338   */
      v.add(doc.createTextNode("codigoActividad"));
      ((Element)v.get(337)).appendChild((Text)v.get(338));

      /* Termina nodo Texto:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("colFondo","" );
      ((Element)v.get(339)).setAttribute("ID","EstCab" );
      ((Element)v.get(339)).setAttribute("cod","174" );
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Elemento padre:339 / Elemento actual: 340   */
      v.add(doc.createTextNode("nombreActividad"));
      ((Element)v.get(339)).appendChild((Text)v.get(340));

      /* Termina nodo Texto:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("colFondo","" );
      ((Element)v.get(341)).setAttribute("ID","EstCab" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(341)).setAttribute("cod","152" );
      ((Element)v.get(334)).appendChild((Element)v.get(341));

      /* Elemento padre:341 / Elemento actual: 342   */
      v.add(doc.createTextNode("tipo actividad"));
      ((Element)v.get(341)).appendChild((Text)v.get(342));

      /* Termina nodo Texto:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("colFondo","" );
      ((Element)v.get(343)).setAttribute("ID","EstCab" );
      ((Element)v.get(343)).setAttribute("cod","3206" );
      ((Element)v.get(334)).appendChild((Element)v.get(343));

      /* Elemento padre:343 / Elemento actual: 344   */
      v.add(doc.createTextNode("campañas desplazamiento"));
      ((Element)v.get(343)).appendChild((Text)v.get(344));

      /* Termina nodo Texto:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("colFondo","" );
      ((Element)v.get(345)).setAttribute("ID","EstCab" );
      ((Element)v.get(345)).setAttribute("cod","3226" );
      ((Element)v.get(334)).appendChild((Element)v.get(345));

      /* Elemento padre:345 / Elemento actual: 346   */
      v.add(doc.createTextNode("nombreActividadOrigen"));
      ((Element)v.get(345)).appendChild((Text)v.get(346));

      /* Termina nodo Texto:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("colFondo","" );
      ((Element)v.get(347)).setAttribute("ID","EstCab" );
      ((Element)v.get(347)).setAttribute("cod","192" );
      ((Element)v.get(334)).appendChild((Element)v.get(347));

      /* Elemento padre:347 / Elemento actual: 348   */
      v.add(doc.createTextNode("diasRespectoActividadOrigen"));
      ((Element)v.get(347)).appendChild((Text)v.get(348));

      /* Termina nodo Texto:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("colFondo","" );
      ((Element)v.get(349)).setAttribute("ID","EstCab" );
      ((Element)v.get(349)).setAttribute("codigo","" );
      ((Element)v.get(334)).appendChild((Element)v.get(349));

      /* Elemento padre:349 / Elemento actual: 350   */
      v.add(doc.createTextNode("idVista"));
      ((Element)v.get(349)).appendChild((Text)v.get(350));

      /* Termina nodo Texto:350   */
      /* Termina nodo:349   */
      /* Termina nodo:334   */

      /* Empieza nodo:351 / Elemento padre: 316   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(351)).setAttribute("alto","22" );
      ((Element)v.get(351)).setAttribute("accion","" );
      ((Element)v.get(351)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(351)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(351)).setAttribute("maxSel","1" );
      ((Element)v.get(351)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(351)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(351)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(351)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(316)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("tipo","texto" );
      ((Element)v.get(352)).setAttribute("ID","EstDat" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("tipo","texto" );
      ((Element)v.get(353)).setAttribute("ID","EstDat2" );
      ((Element)v.get(351)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("tipo","texto" );
      ((Element)v.get(354)).setAttribute("ID","EstDat" );
      ((Element)v.get(351)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("tipo","texto" );
      ((Element)v.get(355)).setAttribute("ID","EstDat2" );
      ((Element)v.get(351)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("tipo","texto" );
      ((Element)v.get(356)).setAttribute("ID","EstDat" );
      ((Element)v.get(351)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("tipo","texto" );
      ((Element)v.get(357)).setAttribute("ID","EstDat2" );
      ((Element)v.get(351)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","texto" );
      ((Element)v.get(358)).setAttribute("ID","EstDat" );
      ((Element)v.get(351)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:351   */

      /* Empieza nodo:359 / Elemento padre: 316   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(316)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 316   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(360)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(360)).setAttribute("ancho","684" );
      ((Element)v.get(360)).setAttribute("sep","$" );
      ((Element)v.get(360)).setAttribute("x","24" );
      ((Element)v.get(360)).setAttribute("class","botonera" );
      ((Element)v.get(360)).setAttribute("y","1155" );
      ((Element)v.get(360)).setAttribute("control","|" );
      ((Element)v.get(360)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(360)).setAttribute("rowset","" );
      ((Element)v.get(360)).setAttribute("cargainicial","N" );
      ((Element)v.get(316)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(361)).setAttribute("nombre","ret3" );
      ((Element)v.get(361)).setAttribute("x","49" );
      ((Element)v.get(361)).setAttribute("y","1414" );
      ((Element)v.get(361)).setAttribute("ID","botonContenido" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(361)).setAttribute("img","retroceder_on" );
      ((Element)v.get(361)).setAttribute("tipo","0" );
      ((Element)v.get(361)).setAttribute("estado","false" );
      ((Element)v.get(361)).setAttribute("alt","" );
      ((Element)v.get(361)).setAttribute("codigo","" );
      ((Element)v.get(361)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(362)).setAttribute("nombre","ava3" );
      ((Element)v.get(362)).setAttribute("x","64" );
      ((Element)v.get(362)).setAttribute("y","1414" );
      ((Element)v.get(362)).setAttribute("ID","botonContenido" );
      ((Element)v.get(362)).setAttribute("img","avanzar_on" );
      ((Element)v.get(362)).setAttribute("tipo","0" );
      ((Element)v.get(362)).setAttribute("estado","false" );
      ((Element)v.get(362)).setAttribute("alt","" );
      ((Element)v.get(362)).setAttribute("codigo","" );
      ((Element)v.get(362)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:360   */
      /* Termina nodo:316   */

      /* Empieza nodo:363 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(363)).setAttribute("nombre","primera3" );
      ((Element)v.get(363)).setAttribute("x","32" );
      ((Element)v.get(363)).setAttribute("y","1414" );
      ((Element)v.get(363)).setAttribute("ID","botonContenido" );
      ((Element)v.get(363)).setAttribute("img","primera_on" );
      ((Element)v.get(363)).setAttribute("tipo","-2" );
      ((Element)v.get(363)).setAttribute("estado","false" );
      ((Element)v.get(363)).setAttribute("alt","" );
      ((Element)v.get(363)).setAttribute("codigo","" );
      ((Element)v.get(363)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(364)).setAttribute("nombre","separa3" );
      ((Element)v.get(364)).setAttribute("x","71" );
      ((Element)v.get(364)).setAttribute("y","1410" );
      ((Element)v.get(364)).setAttribute("ID","botonContenido" );
      ((Element)v.get(364)).setAttribute("img","separa_base" );
      ((Element)v.get(364)).setAttribute("tipo","0" );
      ((Element)v.get(364)).setAttribute("estado","false" );
      ((Element)v.get(364)).setAttribute("alt","" );
      ((Element)v.get(364)).setAttribute("codigo","" );
      ((Element)v.get(364)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(365)).setAttribute("nombre","btnModificarOtraCampana" );
      ((Element)v.get(365)).setAttribute("x","82" );
      ((Element)v.get(365)).setAttribute("y","1411" );
      ((Element)v.get(365)).setAttribute("ID","botonContenido" );
      ((Element)v.get(365)).setAttribute("tipo","html" );
      ((Element)v.get(365)).setAttribute("estado","false" );
      ((Element)v.get(365)).setAttribute("cod","2" );
      ((Element)v.get(365)).setAttribute("accion","onClickModificarOtraCampana();" );
      ((Element)v.get(10)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(366)).setAttribute("nombre","btnEliminarOtraCampana" );
      ((Element)v.get(366)).setAttribute("x","148" );
      ((Element)v.get(366)).setAttribute("y","1411" );
      ((Element)v.get(366)).setAttribute("ID","botonContenido" );
      ((Element)v.get(366)).setAttribute("tipo","html" );
      ((Element)v.get(366)).setAttribute("estado","false" );
      ((Element)v.get(366)).setAttribute("cod","1254" );
      ((Element)v.get(366)).setAttribute("accion","onClickEliminarOtraCampana();" );
      ((Element)v.get(10)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(367)).setAttribute("nombre","capaTablaNoGrafica" );
      ((Element)v.get(367)).setAttribute("alto","752" );
      ((Element)v.get(367)).setAttribute("ancho","100%" );
      ((Element)v.get(367)).setAttribute("colorf","" );
      ((Element)v.get(367)).setAttribute("borde","0" );
      ((Element)v.get(367)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(367)).setAttribute("x","0" );
      ((Element)v.get(367)).setAttribute("y","400" );
      ((Element)v.get(10)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("table"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(368)).setAttribute("border","0" );
      ((Element)v.get(368)).setAttribute("cellspacing","0" );
      ((Element)v.get(368)).setAttribute("cellpadding","0" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("width","12" );
      ((Element)v.get(370)).setAttribute("align","center" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(371)).setAttribute("height","12" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 369   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).setAttribute("width","750" );
      ((Element)v.get(369)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(369)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","12" );
      ((Element)v.get(375)).setAttribute("height","1" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:369   */

      /* Empieza nodo:376 / Elemento padre: 368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(368)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(381)).setAttribute("class","legend" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(382)).setAttribute("nombre","lblDatosDeModoNoGrafico" );
      ((Element)v.get(382)).setAttribute("alto","13" );
      ((Element)v.get(382)).setAttribute("filas","1" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(382)).setAttribute("id","legend" );
      ((Element)v.get(382)).setAttribute("cod","00553" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 380   */
      v.add(doc.createElement("table"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(383)).setAttribute("border","0" );
      ((Element)v.get(383)).setAttribute("align","center" );
      ((Element)v.get(383)).setAttribute("cellspacing","0" );
      ((Element)v.get(383)).setAttribute("cellpadding","0" );
      ((Element)v.get(380)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(384)).setAttribute("valign","top" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("id","tdContenedorDos" );
      ((Element)v.get(385)).setAttribute("style","border:1px solid #CECFCE" );
      ((Element)v.get(385)).setAttribute("onresize","try{document.getElementById('miscroll').style.width=this.offsetWidth-15;            document.getElementById('capaBotones').style.width=this.offsetWidth-6;           }catch(e){;}" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(386)).setAttribute("nombre","rejMatrizDiasNoGrafica" );
      ((Element)v.get(386)).setAttribute("alto","317" );
      ((Element)v.get(386)).setAttribute("ancho","684" );
      ((Element)v.get(386)).setAttribute("x","24" );
      ((Element)v.get(386)).setAttribute("y","437" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:387 / Elemento padre: 383   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(383)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("table"));
      ((Element)v.get(389)).setAttribute("width","705" );
      ((Element)v.get(389)).setAttribute("border","0" );
      ((Element)v.get(389)).setAttribute("align","left" );
      ((Element)v.get(389)).setAttribute("cellspacing","0" );
      ((Element)v.get(389)).setAttribute("cellpadding","0" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","8" );
      ((Element)v.get(392)).setAttribute("height","341" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:383   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:393 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:376   */

      /* Empieza nodo:395 / Elemento padre: 368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(368)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 395   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("table"));
      ((Element)v.get(400)).setAttribute("width","100%" );
      ((Element)v.get(400)).setAttribute("border","0" );
      ((Element)v.get(400)).setAttribute("align","center" );
      ((Element)v.get(400)).setAttribute("cellspacing","0" );
      ((Element)v.get(400)).setAttribute("cellpadding","0" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).setAttribute("class","botonera" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(403)).setAttribute("nombre","btnModoGrafico" );
      ((Element)v.get(403)).setAttribute("ID","botonContenido" );
      ((Element)v.get(403)).setAttribute("tipo","html" );
      ((Element)v.get(403)).setAttribute("accion","onClickVerMatriz();" );
      ((Element)v.get(403)).setAttribute("estado","false" );
      ((Element)v.get(403)).setAttribute("cod","2282" );
      ((Element)v.get(403)).setAttribute("ontab","focalizaDesdeMatriz();" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:404 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","12" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:395   */

      /* Empieza nodo:406 / Elemento padre: 368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(368)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).setAttribute("width","12" );
      ((Element)v.get(407)).setAttribute("align","center" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","12" );
      ((Element)v.get(408)).setAttribute("height","12" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("width","756" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("width","12" );
      ((Element)v.get(406)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","12" );
      ((Element)v.get(412)).setAttribute("height","1" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:406   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:10   */


   }

}
