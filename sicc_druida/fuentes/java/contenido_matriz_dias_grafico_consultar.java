
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_dias_grafico_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_dias_grafico_consultar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag(); inicializacion();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","0665" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r\r   \r\r	/*\r	* Carga el estado inicial\r	*/\r	function onLoadPag()   {  \r		try{\r			tdContenedor.onresize();\r		}catch(e){\r			;\r		}\r		try{\r			tdContenedorDos.onresize();\r		}catch(e){\r			;\r		}\r		configurarMenuSecundario(\"frmConsultarMatrizDias\");\r		fMostrarMensajeError();\r		DrdEnsanchaConMargenDcho('lstFueraPeriodo',12);\r		DrdEnsanchaConMargenDcho('lstOtraCampana',12);\r\r		if (get('frmConsultarMatrizDias.hListaFueraPeriodoMostrar') == \"SI\") {\r			mostrarListaEditable();\r		} else {		\r			ocultarListaEditable();\r		}\r		eval (ON_RSZ);  \r				setMV('frmConsultarMatrizDias.cbMarcas','N');\r		setMV('frmConsultarMatrizDias.cbCanales','N');\r	}\r\r\r	/*\r	* Inicializa la pagina\r	*/\r	function inicializacion() {		\r		txt_to('lblValorPais', get('frmConsultarMatrizDias.hPaisDescripcion')); \r		posicionarCombo(); \r		focaliza('frmConsultarMatrizDias.cbMarcas','');\r	}\r\r	/*\r	* Se llama a esta función javascript cuando se pulsa sobre el botón btnBuscar. \r	* Llama a LPMantieneMatrizDias con accion = \"consultar\"\r	*/\r	function onClickBuscar() {\r				if( ! sicc_validaciones_generales('grupoBuscar') ) {\r			return false;\r		}		\r\r				obtenerMarcaCanalGrupos();\r\r				set('frmConsultarMatrizDias.accion', 'consultar');\r		enviaSICC('frmConsultarMatrizDias');\r	}\r\r\r	/*\r	* Este método se activa al seleccionar un valor en cbMarcas\r	*/\r	function onChangeMarca() {\r		cambiaFiltro();\r	}\r\r\r	/*\r	* Este método se activa al seleccionar un valor en cbCanales\r	*/\r	function onChangeCanal() {\r		cambiaFiltro();\r	}\r\r\r	/*\r	* Función javascript recarga el combo de cbGrupoDeZonas\r	*/\r	function cambiaFiltro() {\r				if (seleccionoMarcaCanal()) {\r						recargaCombo('frmConsultarMatrizDias.cbGrupoDeZonas', 'CRAObtieneGruposZonas', 'es.indra.sicc.dtos.cra.DTOGrupoZonas', armarArrayParametrosDTO());\r		}\r\r							}\r\r\r		function fLimpiar() { \r				set_combo('frmConsultarMatrizDias.cbGrupoDeZonas', new Array() );\r		focaliza('frmConsultarMatrizDias.cbMarcas');\r	} \r\r\r		function focalizaDesdeBusqueda() {  \r		document.selection.empty();\r		focaliza('frmConsultarMatrizDias.cbMarcas');\r	}\r\r\r		function focalizaShift() {  \r		document.selection.empty();\r						document.all.btnBuscar.focus();\r	}\r\r\r	/*\r	* Al seleccionar una actividad en la matriz, guarda su idVista en hActividadSeleccionada.\r	* Luego se utiliza este valor para identificar que actividad se desea modificar o eliminar.\r	*/\r	function seleccionaActividad(idVistaActividad) {\r					}\r\r\r		function armarArrayParametrosDTO()  {\r		var array = new Array();\r		var i = 0;\r		array[i] = new Array('oidIdioma',get('frmConsultarMatrizDias.hIdioma'));\r\r		if (get('frmConsultarMatrizDias.hPais') != '')  {\r			i++;\r			array[i] = new Array('oidPais',get('frmConsultarMatrizDias.hPais'));\r		}\r		if (get('frmConsultarMatrizDias.cbMarcas') != '')  {\r			i++;\r			array[i] = new Array('oidMarca',get('frmConsultarMatrizDias.cbMarcas'));\r		}\r		if (get('frmConsultarMatrizDias.cbCanales') != '')  {\r			i++;\r			array[i] = new Array('oidCanal',get('frmConsultarMatrizDias.cbCanales'));\r		}\r				return array;\r	}\r\r\r		function seleccionoMarcaCanal() {\r		if ( (get('frmConsultarMatrizDias.cbMarcas') != null) && (get('frmConsultarMatrizDias.cbMarcas') != '') &&\r			 (get('frmConsultarMatrizDias.cbCanales') != null) && (get('frmConsultarMatrizDias.cbCanales') != '') ) {\r			return true;\r		}\r		return false;\r	}\r\r\r		function obtenerMarcaCanalGrupos(){ \r		set('frmConsultarMatrizDias.hCanal', get('frmConsultarMatrizDias.cbCanales')); \r		set('frmConsultarMatrizDias.hMarca', get('frmConsultarMatrizDias.cbMarcas')); \r		set('frmConsultarMatrizDias.hGruposZonas', get('frmConsultarMatrizDias.cbGrupoDeZonas')); \r	} \r\r\r		function posicionarCombo() { \r				var iSeleccionadoMarca = new Array(); \r		iSeleccionadoMarca[0] = get('frmConsultarMatrizDias.hMarca'); \r		set('frmConsultarMatrizDias.cbMarcas',iSeleccionadoMarca); \r\r				var iSeleccionadoCanal = new Array(); \r		iSeleccionadoCanal[0] = get('frmConsultarMatrizDias.hCanal'); \r		set('frmConsultarMatrizDias.cbCanales',iSeleccionadoCanal); \r\r				var gruposZonas = get('frmConsultarMatrizDias.hGruposZonas');\r		iSeleccionadoGrupos = gruposZonas.split(\",\");\r		set('frmConsultarMatrizDias.cbGrupoDeZonas',iSeleccionadoGrupos);\r	}\r\r\r		function mostrarListaEditable() {\r				document.all[\"CplstFueraPeriodo\"].style.visibility='visible';\r		document.all[\"CpLin1lstFueraPeriodo\"].style.visibility='visible';\r		document.all[\"CpLin2lstFueraPeriodo\"].style.visibility='visible';\r		document.all[\"CpLin3lstFueraPeriodo\"].style.visibility='visible';\r		document.all[\"CpLin4lstFueraPeriodo\"].style.visibility='visible';\r		\r		document.all[\"primera2Div\"].style.visibility='visible';\r		document.all[\"ret2Div\"].style.visibility='visible';\r		document.all[\"ava2Div\"].style.visibility='visible';\r		document.all[\"separa2Div\"].style.visibility='visible';\r\r				document.all[\"CplstOtraCampana\"].style.visibility='visible';\r		document.all[\"CpLin1lstOtraCampana\"].style.visibility='visible';\r		document.all[\"CpLin2lstOtraCampana\"].style.visibility='visible';\r		document.all[\"CpLin3lstOtraCampana\"].style.visibility='visible';\r		document.all[\"CpLin4lstOtraCampana\"].style.visibility='visible';\r		\r		document.all[\"primera3Div\"].style.visibility='visible';\r		document.all[\"ret3Div\"].style.visibility='visible';\r		document.all[\"ava3Div\"].style.visibility='visible';\r		document.all[\"separa3Div\"].style.visibility='visible';\r	}\r\r\r		function ocultarListaEditable() {\r				document.all[\"CplstFueraPeriodo\"].style.visibility='hidden';\r		document.all[\"CpLin1lstFueraPeriodo\"].style.visibility='hidden';\r		document.all[\"CpLin2lstFueraPeriodo\"].style.visibility='hidden';\r		document.all[\"CpLin3lstFueraPeriodo\"].style.visibility='hidden';\r		document.all[\"CpLin4lstFueraPeriodo\"].style.visibility='hidden';\r		\r		document.all[\"primera2Div\"].style.visibility='hidden';\r		document.all[\"ret2Div\"].style.visibility='hidden';\r		document.all[\"ava2Div\"].style.visibility='hidden';\r		document.all[\"separa2Div\"].style.visibility='hidden';\r\r				document.all[\"CplstOtraCampana\"].style.visibility='hidden';\r		document.all[\"CpLin1lstOtraCampana\"].style.visibility='hidden';\r		document.all[\"CpLin2lstOtraCampana\"].style.visibility='hidden';\r		document.all[\"CpLin3lstOtraCampana\"].style.visibility='hidden';\r		document.all[\"CpLin4lstOtraCampana\"].style.visibility='hidden';\r		\r		document.all[\"primera3Div\"].style.visibility='hidden';\r		document.all[\"ret3Div\"].style.visibility='hidden';\r		document.all[\"ava3Div\"].style.visibility='hidden';\r		document.all[\"separa3Div\"].style.visibility='hidden';\r	}\r\r\r   \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbMarcas" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","6" );
      ((Element)v.get(6)).setAttribute("group","grupoBuscar" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbCanales" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","7" );
      ((Element)v.get(7)).setAttribute("group","grupoBuscar" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmConsultarMatrizDias" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","varTipo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPMantieneMatrizDias" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hPais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hPaisDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hMarca" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hCanal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hGruposZonas" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hListaFueraPeriodoMostrar" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(21)).setAttribute("nombre","capaBusqueda" );
      ((Element)v.get(21)).setAttribute("x","0" );
      ((Element)v.get(21)).setAttribute("y","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","750" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","1" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:23   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(35)).setAttribute("class","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","legend" );
      ((Element)v.get(36)).setAttribute("cod","0075" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","705" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","left" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","3" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblPais" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","5" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","6" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","25" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","7" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:44   */

      /* Empieza nodo:59 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("valign","bottom" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblValorPais" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(67)).setAttribute("nombre","cbMarcas" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("size","1" );
      ((Element)v.get(67)).setAttribute("multiple","N" );
      ((Element)v.get(67)).setAttribute("req","S" );
      ((Element)v.get(67)).setAttribute("valorinicial","" );
      ((Element)v.get(67)).setAttribute("textoinicial","" );
      ((Element)v.get(67)).setAttribute("onchange","onChangeMarca();" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("onshtab","focalizaShift();" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(72)).setAttribute("nombre","cbCanales" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("size","1" );
      ((Element)v.get(72)).setAttribute("multiple","N" );
      ((Element)v.get(72)).setAttribute("req","S" );
      ((Element)v.get(72)).setAttribute("valorinicial","" );
      ((Element)v.get(72)).setAttribute("textoinicial","" );
      ((Element)v.get(72)).setAttribute("onchange","onChangeCanal();" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:74 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(59)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:59   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:76 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("table"));
      ((Element)v.get(79)).setAttribute("width","705" );
      ((Element)v.get(79)).setAttribute("border","0" );
      ((Element)v.get(79)).setAttribute("align","left" );
      ((Element)v.get(79)).setAttribute("cellspacing","0" );
      ((Element)v.get(79)).setAttribute("cellpadding","0" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("colspan","3" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblGrupoDeZonas" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","2195" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:83   */

      /* Empieza nodo:90 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(79)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","cbGrupoDeZonas" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("size","5" );
      ((Element)v.get(94)).setAttribute("multiple","S" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:90   */

      /* Empieza nodo:98 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","3" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:101 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:30   */

      /* Empieza nodo:103 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("class","botonera" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("tipo","html" );
      ((Element)v.get(111)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("cod","1" );
      ((Element)v.get(111)).setAttribute("ontab","focalizaDesdeBusqueda();" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:112 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","12" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:103   */

      /* Empieza nodo:114 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("height","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","756" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(120)).setAttribute("height","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:114   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:121 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(121)).setAttribute("nombre","capaTablaGrafica" );
      ((Element)v.get(121)).setAttribute("borde","0" );
      ((Element)v.get(121)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(121)).setAttribute("x","0" );
      ((Element)v.get(121)).setAttribute("y","188" );
      ((Element)v.get(8)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(125)).setAttribute("height","19" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","750" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(123)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","1" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:123   */

      /* Empieza nodo:130 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("table"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(135)).setAttribute("border","0" );
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("cellpadding","0" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).setAttribute("valign","top" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("id","tdContenedor" );
      ((Element)v.get(137)).setAttribute("style","border:1px solid #CECFCE" );
      ((Element)v.get(137)).setAttribute("onresize","try{document.getElementById('miscroll').style.width=this.offsetWidth-0;          }catch(e){;}" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(138)).setAttribute("nombre","rejMatrizDias" );
      ((Element)v.get(138)).setAttribute("alto","317" );
      ((Element)v.get(138)).setAttribute("ancho","708" );
      ((Element)v.get(138)).setAttribute("x","12" );
      ((Element)v.get(138)).setAttribute("y","209" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:139 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","705" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","left" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","291" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:145 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).setAttribute("bgcolor","#CECFCE" );
      ((Element)v.get(135)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","790" );
      ((Element)v.get(146)).setAttribute("height","26" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","12" );
      ((Element)v.get(147)).setAttribute("height","12" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:148 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:130   */

      /* Empieza nodo:150 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("height","12" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","756" );
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","1" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:150   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:157 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(157)).setAttribute("nombre","lstFueraPeriodo" );
      ((Element)v.get(157)).setAttribute("ancho","708" );
      ((Element)v.get(157)).setAttribute("alto","317" );
      ((Element)v.get(157)).setAttribute("x","12" );
      ((Element)v.get(157)).setAttribute("y","551" );
      ((Element)v.get(157)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(157)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(158)).setAttribute("precarga","S" );
      ((Element)v.get(158)).setAttribute("conROver","S" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(159)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(159)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(159)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(159)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 158   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(160)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(160)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(160)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(160)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(161)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(161)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:158   */

      /* Empieza nodo:162 / Elemento padre: 157   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(157)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(163)).setAttribute("borde","1" );
      ((Element)v.get(163)).setAttribute("horizDatos","1" );
      ((Element)v.get(163)).setAttribute("horizCabecera","1" );
      ((Element)v.get(163)).setAttribute("vertical","1" );
      ((Element)v.get(163)).setAttribute("horizTitulo","1" );
      ((Element)v.get(163)).setAttribute("horizBase","1" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 162   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(164)).setAttribute("borde","#999999" );
      ((Element)v.get(164)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(164)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(164)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(164)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(164)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(164)).setAttribute("horizBase","#999999" );
      ((Element)v.get(162)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 157   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(165)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(165)).setAttribute("alto","22" );
      ((Element)v.get(165)).setAttribute("imgFondo","" );
      ((Element)v.get(165)).setAttribute("cod","0046" );
      ((Element)v.get(165)).setAttribute("ID","datosTitle" );
      ((Element)v.get(157)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(166)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(166)).setAttribute("alto","22" );
      ((Element)v.get(166)).setAttribute("imgFondo","" );
      ((Element)v.get(157)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 157   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(167)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(167)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(167)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(167)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(167)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(167)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(157)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","80" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","60" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","170" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","100" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","120" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","80" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","100" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","120" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:167   */

      /* Empieza nodo:176 / Elemento padre: 157   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(176)).setAttribute("alto","20" );
      ((Element)v.get(176)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(176)).setAttribute("imgFondo","" );
      ((Element)v.get(176)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(157)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","2195" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","261" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","192" );
      ((Element)v.get(176)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","151" );
      ((Element)v.get(176)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","174" );
      ((Element)v.get(176)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","193" );
      ((Element)v.get(176)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("cod","194" );
      ((Element)v.get(176)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","293" );
      ((Element)v.get(176)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:176   */

      /* Empieza nodo:185 / Elemento padre: 157   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(185)).setAttribute("alto","22" );
      ((Element)v.get(185)).setAttribute("accion","" );
      ((Element)v.get(185)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(185)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(185)).setAttribute("maxSel","-1" );
      ((Element)v.get(185)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(185)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(185)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(185)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(157)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:185   */

      /* Empieza nodo:194 / Elemento padre: 157   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(157)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 157   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(195)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(195)).setAttribute("ancho","708" );
      ((Element)v.get(195)).setAttribute("sep","$" );
      ((Element)v.get(195)).setAttribute("x","12" );
      ((Element)v.get(195)).setAttribute("class","botonera" );
      ((Element)v.get(195)).setAttribute("y","845" );
      ((Element)v.get(195)).setAttribute("control","|" );
      ((Element)v.get(195)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(195)).setAttribute("rowset","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(195)).setAttribute("cargainicial","N" );
      ((Element)v.get(157)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(196)).setAttribute("nombre","ret2" );
      ((Element)v.get(196)).setAttribute("x","37" );
      ((Element)v.get(196)).setAttribute("y","849" );
      ((Element)v.get(196)).setAttribute("ID","botonContenido" );
      ((Element)v.get(196)).setAttribute("img","retroceder_on" );
      ((Element)v.get(196)).setAttribute("tipo","0" );
      ((Element)v.get(196)).setAttribute("estado","false" );
      ((Element)v.get(196)).setAttribute("alt","" );
      ((Element)v.get(196)).setAttribute("codigo","" );
      ((Element)v.get(196)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(197)).setAttribute("nombre","ava2" );
      ((Element)v.get(197)).setAttribute("x","52" );
      ((Element)v.get(197)).setAttribute("y","849" );
      ((Element)v.get(197)).setAttribute("ID","botonContenido" );
      ((Element)v.get(197)).setAttribute("img","avanzar_on" );
      ((Element)v.get(197)).setAttribute("tipo","0" );
      ((Element)v.get(197)).setAttribute("estado","false" );
      ((Element)v.get(197)).setAttribute("alt","" );
      ((Element)v.get(197)).setAttribute("codigo","" );
      ((Element)v.get(197)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:195   */
      /* Termina nodo:157   */

      /* Empieza nodo:198 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(198)).setAttribute("nombre","primera2" );
      ((Element)v.get(198)).setAttribute("x","20" );
      ((Element)v.get(198)).setAttribute("y","849" );
      ((Element)v.get(198)).setAttribute("ID","botonContenido" );
      ((Element)v.get(198)).setAttribute("img","primera_on" );
      ((Element)v.get(198)).setAttribute("tipo","-2" );
      ((Element)v.get(198)).setAttribute("estado","false" );
      ((Element)v.get(198)).setAttribute("alt","" );
      ((Element)v.get(198)).setAttribute("codigo","" );
      ((Element)v.get(198)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(199)).setAttribute("nombre","separa2" );
      ((Element)v.get(199)).setAttribute("x","59" );
      ((Element)v.get(199)).setAttribute("y","845" );
      ((Element)v.get(199)).setAttribute("ID","botonContenido" );
      ((Element)v.get(199)).setAttribute("img","separa_base" );
      ((Element)v.get(199)).setAttribute("tipo","0" );
      ((Element)v.get(199)).setAttribute("estado","false" );
      ((Element)v.get(199)).setAttribute("alt","" );
      ((Element)v.get(199)).setAttribute("codigo","" );
      ((Element)v.get(199)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(200)).setAttribute("nombre","lstOtraCampana" );
      ((Element)v.get(200)).setAttribute("ancho","593" );
      ((Element)v.get(200)).setAttribute("alto","317" );
      ((Element)v.get(200)).setAttribute("x","12" );
      ((Element)v.get(200)).setAttribute("y","892" );
      ((Element)v.get(200)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(200)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(201)).setAttribute("precarga","S" );
      ((Element)v.get(201)).setAttribute("conROver","S" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(202)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(202)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(202)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(202)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 201   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(203)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(203)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(203)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(203)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(201)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(204)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(204)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(201)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:201   */

      /* Empieza nodo:205 / Elemento padre: 200   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(200)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(206)).setAttribute("borde","1" );
      ((Element)v.get(206)).setAttribute("horizDatos","1" );
      ((Element)v.get(206)).setAttribute("horizCabecera","1" );
      ((Element)v.get(206)).setAttribute("vertical","1" );
      ((Element)v.get(206)).setAttribute("horizTitulo","1" );
      ((Element)v.get(206)).setAttribute("horizBase","1" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 205   */
      v.add(doc.createElement("COLOR"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(207)).setAttribute("borde","#999999" );
      ((Element)v.get(207)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(207)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(207)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(207)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(207)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(207)).setAttribute("horizBase","#999999" );
      ((Element)v.get(205)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:205   */

      /* Empieza nodo:208 / Elemento padre: 200   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(208)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(208)).setAttribute("alto","22" );
      ((Element)v.get(208)).setAttribute("imgFondo","" );
      ((Element)v.get(208)).setAttribute("cod","00682" );
      ((Element)v.get(208)).setAttribute("ID","datosTitle" );
      ((Element)v.get(200)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 200   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(209)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(209)).setAttribute("alto","22" );
      ((Element)v.get(209)).setAttribute("imgFondo","" );
      ((Element)v.get(200)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 200   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(210)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(210)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(210)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(210)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(210)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(210)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(200)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("ancho","80" );
      ((Element)v.get(211)).setAttribute("minimizable","S" );
      ((Element)v.get(211)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("ancho","60" );
      ((Element)v.get(212)).setAttribute("minimizable","S" );
      ((Element)v.get(212)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("ancho","170" );
      ((Element)v.get(213)).setAttribute("minimizable","S" );
      ((Element)v.get(213)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","100" );
      ((Element)v.get(214)).setAttribute("minimizable","S" );
      ((Element)v.get(214)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","120" );
      ((Element)v.get(215)).setAttribute("minimizable","S" );
      ((Element)v.get(215)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","80" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 210   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","100" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:210   */

      /* Empieza nodo:218 / Elemento padre: 200   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(218)).setAttribute("alto","30" );
      ((Element)v.get(218)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(218)).setAttribute("imgFondo","" );
      ((Element)v.get(218)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(200)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("colFondo","" );
      ((Element)v.get(219)).setAttribute("ID","EstCab" );
      ((Element)v.get(219)).setAttribute("cod","2195" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("colFondo","" );
      ((Element)v.get(220)).setAttribute("ID","EstCab" );
      ((Element)v.get(220)).setAttribute("cod","151" );
      ((Element)v.get(218)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("colFondo","" );
      ((Element)v.get(221)).setAttribute("ID","EstCab" );
      ((Element)v.get(221)).setAttribute("cod","174" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("colFondo","" );
      ((Element)v.get(222)).setAttribute("ID","EstCab" );
      ((Element)v.get(222)).setAttribute("cod","152" );
      ((Element)v.get(218)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(223)).setAttribute("colFondo","" );
      ((Element)v.get(223)).setAttribute("ID","EstCab" );
      ((Element)v.get(223)).setAttribute("cod","3206" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("cod","3226" );
      ((Element)v.get(218)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("colFondo","" );
      ((Element)v.get(225)).setAttribute("ID","EstCab" );
      ((Element)v.get(225)).setAttribute("cod","192" );
      ((Element)v.get(218)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:218   */

      /* Empieza nodo:226 / Elemento padre: 200   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(226)).setAttribute("alto","22" );
      ((Element)v.get(226)).setAttribute("accion","" );
      ((Element)v.get(226)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(226)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(226)).setAttribute("maxSel","-1" );
      ((Element)v.get(226)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(226)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(226)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(226)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(200)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("tipo","texto" );
      ((Element)v.get(227)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("tipo","texto" );
      ((Element)v.get(228)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("tipo","texto" );
      ((Element)v.get(229)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("tipo","texto" );
      ((Element)v.get(230)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","texto" );
      ((Element)v.get(231)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("tipo","texto" );
      ((Element)v.get(232)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("tipo","texto" );
      ((Element)v.get(233)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:226   */

      /* Empieza nodo:234 / Elemento padre: 200   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(200)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 200   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(235)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(235)).setAttribute("ancho","593" );
      ((Element)v.get(235)).setAttribute("sep","$" );
      ((Element)v.get(235)).setAttribute("x","12" );
      ((Element)v.get(235)).setAttribute("class","botonera" );
      ((Element)v.get(235)).setAttribute("y","1155" );
      ((Element)v.get(235)).setAttribute("control","|" );
      ((Element)v.get(235)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(235)).setAttribute("rowset","" );
      ((Element)v.get(235)).setAttribute("cargainicial","N" );
      ((Element)v.get(200)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(236)).setAttribute("nombre","ret3" );
      ((Element)v.get(236)).setAttribute("x","37" );
      ((Element)v.get(236)).setAttribute("y","1190" );
      ((Element)v.get(236)).setAttribute("ID","botonContenido" );
      ((Element)v.get(236)).setAttribute("img","retroceder_on" );
      ((Element)v.get(236)).setAttribute("tipo","0" );
      ((Element)v.get(236)).setAttribute("estado","false" );
      ((Element)v.get(236)).setAttribute("alt","" );
      ((Element)v.get(236)).setAttribute("codigo","" );
      ((Element)v.get(236)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 235   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(237)).setAttribute("nombre","ava3" );
      ((Element)v.get(237)).setAttribute("x","52" );
      ((Element)v.get(237)).setAttribute("y","1190" );
      ((Element)v.get(237)).setAttribute("ID","botonContenido" );
      ((Element)v.get(237)).setAttribute("img","avanzar_on" );
      ((Element)v.get(237)).setAttribute("tipo","0" );
      ((Element)v.get(237)).setAttribute("estado","false" );
      ((Element)v.get(237)).setAttribute("alt","" );
      ((Element)v.get(237)).setAttribute("codigo","" );
      ((Element)v.get(237)).setAttribute("accion","mipgndo3.avanzar();" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(235)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:235   */
      /* Termina nodo:200   */

      /* Empieza nodo:238 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","primera3" );
      ((Element)v.get(238)).setAttribute("x","20" );
      ((Element)v.get(238)).setAttribute("y","1190" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("img","primera_on" );
      ((Element)v.get(238)).setAttribute("tipo","-2" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("alt","" );
      ((Element)v.get(238)).setAttribute("codigo","" );
      ((Element)v.get(238)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(239)).setAttribute("nombre","separa3" );
      ((Element)v.get(239)).setAttribute("x","59" );
      ((Element)v.get(239)).setAttribute("y","1186" );
      ((Element)v.get(239)).setAttribute("ID","botonContenido" );
      ((Element)v.get(239)).setAttribute("img","separa_base" );
      ((Element)v.get(239)).setAttribute("tipo","0" );
      ((Element)v.get(239)).setAttribute("estado","false" );
      ((Element)v.get(239)).setAttribute("alt","" );
      ((Element)v.get(239)).setAttribute("codigo","" );
      ((Element)v.get(239)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(240)).setAttribute("nombre","capaTablaNoGrafica" );
      ((Element)v.get(240)).setAttribute("alto","752" );
      ((Element)v.get(240)).setAttribute("ancho","100%" );
      ((Element)v.get(240)).setAttribute("colorf","" );
      ((Element)v.get(240)).setAttribute("borde","0" );
      ((Element)v.get(240)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(240)).setAttribute("x","0" );
      ((Element)v.get(240)).setAttribute("y","1219" );
      ((Element)v.get(8)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("table"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(241)).setAttribute("border","0" );
      ((Element)v.get(241)).setAttribute("cellspacing","0" );
      ((Element)v.get(241)).setAttribute("cellpadding","0" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","12" );
      ((Element)v.get(243)).setAttribute("align","center" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","12" );
      ((Element)v.get(244)).setAttribute("height","19" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("width","750" );
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","12" );
      ((Element)v.get(242)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","12" );
      ((Element)v.get(248)).setAttribute("height","1" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:242   */

      /* Empieza nodo:249 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("table"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(254)).setAttribute("border","0" );
      ((Element)v.get(254)).setAttribute("align","center" );
      ((Element)v.get(254)).setAttribute("cellspacing","0" );
      ((Element)v.get(254)).setAttribute("cellpadding","0" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).setAttribute("valign","top" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("id","tdContenedorDos" );
      ((Element)v.get(256)).setAttribute("style","border:1px solid #CECFCE" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(256)).setAttribute("onresize","try{document.getElementById('miscrolldos').style.width=this.offsetWidth-0;}catch(e){;}" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(257)).setAttribute("nombre","rejMatrizDiasNoGrafica" );
      ((Element)v.get(257)).setAttribute("alto","317" );
      ((Element)v.get(257)).setAttribute("ancho","708" );
      ((Element)v.get(257)).setAttribute("x","12" );
      ((Element)v.get(257)).setAttribute("y","1240" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("table"));
      ((Element)v.get(260)).setAttribute("width","705" );
      ((Element)v.get(260)).setAttribute("border","0" );
      ((Element)v.get(260)).setAttribute("align","left" );
      ((Element)v.get(260)).setAttribute("cellspacing","0" );
      ((Element)v.get(260)).setAttribute("cellpadding","0" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","291" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:264 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(264)).setAttribute("bgcolor","#CECFCE" );
      ((Element)v.get(254)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","790" );
      ((Element)v.get(265)).setAttribute("height","26" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","12" );
      ((Element)v.get(266)).setAttribute("height","12" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:267 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:249   */

      /* Empieza nodo:269 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","12" );
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("height","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("width","756" );
      ((Element)v.get(269)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("width","12" );
      ((Element)v.get(269)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("height","1" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:269   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:276 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(276)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(276)).setAttribute("alto","18" );
      ((Element)v.get(276)).setAttribute("ancho","100" );
      ((Element)v.get(276)).setAttribute("colorf","" );
      ((Element)v.get(276)).setAttribute("borde","0" );
      ((Element)v.get(276)).setAttribute("imagenf","" );
      ((Element)v.get(276)).setAttribute("repeat","" );
      ((Element)v.get(276)).setAttribute("padding","" );
      ((Element)v.get(276)).setAttribute("visibilidad","visible" );
      ((Element)v.get(276)).setAttribute("contravsb","" );
      ((Element)v.get(276)).setAttribute("x","0" );
      ((Element)v.get(276)).setAttribute("y","1210" );
      ((Element)v.get(276)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:8   */


   }

}
