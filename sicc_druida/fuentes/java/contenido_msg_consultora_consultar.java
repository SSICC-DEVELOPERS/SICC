
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_msg_consultora_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_msg_consultora_consultar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar mensajes por consultoras" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar mensajes por consultoras" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","ConstantesJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r \r\rvar varNoLimpiarSICC = true;\r\rfunction onLoadPag(){   \r		configurarMenuSecundario(\"frmMsgConsultar\");\r    btnProxy(5,'1');\r	 if (window.dialogArguments) {             btnProxy(2,1);              btnProxy(3,0);      }\r\r		DrdEnsanchaConMargenDcho('listado1',12);\r		ocultarLista();    \r		eval(ON_RSZ);\r		focaliza(\"frmMsgConsultar.codCliente\");  \r    accion(\"frmMsgConsultar.comboPeriodo\",\".disabled=true\");\r  \r    if (get('frmMsgConsultar.errDescripcion')!='') {\r		   var wnd = fMostrarMensajeError(get('frmMsgConsultar.errCodigo'), get('frmMsgConsultar.errDescripcion'));\r			 ocultarLista();\r	  }\r}\r\rfunction ocultarLista(){\r    listado1.setDatos(new Array());\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r}\r\rfunction buscar(){\r	ocultarLista();  \r  var formatoFecha = get(\"frmMsgConsultar.hFormatoFechaPais\" );  \r  var fec = get(\"frmMsgConsultar.FImpresion\");  \r  var OK = true;\r   \r  if (sicc_validaciones_generales() && OK){  \r  \r    if (fec != \"\") {\r     if (!EsFechaValida_SICC(fec , \"frmMsgConsultar\") ){\r                             GestionarMensaje(\"1006\", formatoFecha, null, null);\r                             focaliza(\"frmMsgConsultar.FImpresion\");\r                             return false;\r     }\r   }else\r         OK = true;\r  \r     var cliente =  get(\"frmMsgConsultar.codCliente\");\r     var patron = get(\"frmMsgConsultar.cbCodPatron\");\r     var Tperiodo = get(\"frmMsgConsultar.comboTipoPeriodo\"); \r     var periodo = get(\"frmMsgConsultar.comboPeriodo\");\r     var lote  = get(\"frmMsgConsultar.NloteImpresion\");\r     var impresion = get(\"frmMsgConsultar.FImpresion\");  \r          \r     set(\"frmMsgConsultar.oidPatronH\", patron);\r     set(\"frmMsgConsultar.codigoClienteH\", cliente);\r     set(\"frmMsgConsultar.oidPeriodoH\", Tperiodo);\r     set(\"frmMsgConsultar.oidPeriodo\", periodo);\r     set(\"frmMsgConsultar.lote\", lote);\r     set(\"frmMsgConsultar.impresion\", impresion);\r     \r     set(\"frmMsgConsultar.conectorAction\",\"LPConsultarMensajes\");   \r     set(\"frmMsgConsultar.accion\",\"Consultar mensajes consultora\");\r     enviaSICC('frmMsgConsultar');\r	 }	\r}\r\rfunction seteaValores(sRs){\r\r  /*\r   * dmorello, 13/01/2006\r   * Se observó que, si el texto del mensaje se compone de varias líneas,\r   * no se muestra la lista de resultados en pantalla. Esto se debe a que la llamada\r   * a seteaValores queda formada también por esos saltos de línea, resultando, por\r   * ejemplo:\r   *         seteaValores('&lt;txt&gt;Linea 1&lt;/txt&gt;\r   * \r   *         &lt;txt/&gt;')\r   *\r   * De este modo, nos queda una llamada a JavaScript incorrecta.\r   * Para evitar esto, los caracteres fin de línea fueron reemplazados por otros en la LP\r   * a fin de que aquí sean restaurados y se pueda realizar adecuadamente el seteo de valores.\r   */\r  \r  /*\r   * dmorello, 18/01/2006\r   * Se restaura el String original con los cambios de línea\r   */\r  var sRsArray = sRs.split(\"~\");\r  var sRsArrayLength = sRsArray.length;\r  sRs = \"\";\r  for (var i = 0; i < sRsArrayLength; i++) {\r           sRs += sRsArray[i];\r           if (i < sRsArrayLength - 1) {\r                sRs += '\\r\\n';\r           }\r  }\r\r  \r  var lineas = sRs.split(\"|\"); \r  \r\r  mostrarLista();\r  var datosLista = new Array();\r  \r if (lineas!= ''){ \r     for ( var i = 0; i < lineas.length; i++)\r      {	\r            var valor =lineas[i].split(\"@\");\r            \r            var elementoDos = \"\";\r            \r            if ( valor[1] != \" \"  ){\r             elementoDos = valor[0] + ', '  + valor[1];         \r             }\r            else{\r             elementoDos = valor[0];\r             }\r            datosLista[i]  = [i, elementoDos];\r            \r      \r      } \r      \r     \r      listado1.setDatos(datosLista);\r   }else{\r   \r   }   \r      \r}\r\r\r \r        \rfunction tipoPeriodoOnChange(){\r	var pais = get('frmMsgConsultar.hPais');\r	var idioma = get('frmMsgConsultar.hIdioma');\r	var arr = new Array();\r\r	arr[arr.length] = new Array(\"oidPais\", pais );\r	arr[arr.length] = new Array(\"oidIdioma\", idioma );  \r	arr[arr.length] = new Array(\"oidTipoPeriodo\", get(\"frmMsgConsultar.comboTipoPeriodo\")+\"\");\r  \r  accion(\"frmMsgConsultar.comboPeriodo\",\".disabled=false\");\r  recargaCombo('frmMsgConsultar.comboPeriodo', 'SEGObtenerPeriodosPorTipoPeriodo', 'es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo',arr);\r\r}\r\rfunction buscarCliente() {\r          var obj = new Object();\r              var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);\r              if(whnd==null){\r\r              }else{\r                  var oid;\r              \r                  var oid = whnd[0];\r                  var cod = whnd[1];\r                  var nombre1 = whnd[2];\r                  var apellido1 = whnd[4];\r                  set(\"frmMsgConsultar.codCliente\", cod);    \r              \r              }     \r }\r\r\rfunction fLimpiar(){   \r	set(\"frmMsgConsultar.codCliente\", \"\");\r	set(\"frmMsgConsultar.FImpresion\", \"\");\r	set(\"frmMsgConsultar.NloteImpresion\",\"\");\r	set(\"frmMsgConsultar.comboPeriodo\",\"\");	\r  set(\"frmMsgConsultar.comboTipoPeriodo\", \"\");\r  var aCombo = new Array(new Array(\"\",\"\"));\r	set_combo(\"frmMsgConsultar.comboPeriodo\",aCombo,[]);	\r  accion(\"frmMsgConsultar.comboPeriodo\",\".disabled=true\");\r  focaliza(\"frmMsgConsultar.codCliente\");	\r  \r}\r\rfunction mostrarLista(){\r	  document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r}\r\r\rfunction muestraLista(ultima, rowset) { \r  var tamanio = rowset.length;\r  if (tamanio > 0) { \r			mostrarLista();\r			mipgndo.lista.maxSel = -1;\r			return true;\r }\r else {\r			ocultarLista();\r			return false;\r		}\r}\r\rfunction cerrarVentana(){\r		window.close();\r}		\r\rfunction fVolver(){	\r		window.close();\r}\rfunction focalizaShTab(){  \r	focalizaBotonHTML('botonContenido','btnBuscar');	\r}\r\rfunction focalizaTab(){\r	focaliza(\"frmMsgConsultar.codCliente\");	\r}\r\r\rfunction clienteOnBlur() {\r\r	 var longiCod = get('frmMsgConsultar.hLongCliente');\r	 var elTexto  = get('frmMsgConsultar.codCliente');\r\r	 if(elTexto.length!=0){\r		var faltantes = longiCod -  elTexto.length;\r		var resultCod = new String(\"\");\r		if(faltantes > 0){\r			for(var t = 0 ; t<faltantes; t++){\r				resultCod = resultCod + \"0\";\r			}\r	  }\r	  resultCod = resultCod + elTexto;\r	  set('frmMsgConsultar.codCliente', resultCod);\r	 }\r              \r}\r\r       \r  \r \r\r\r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","codCliente" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","263" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","comboTipoPeriodo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","132" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","comboPeriodo" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","276" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","NloteImpresion" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","936" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999999999999" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(12)).setAttribute("nombre","frmMsgConsultar" );
      ((Element)v.get(12)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hPais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidPatronH" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","codigoClienteH" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidPeriodoH" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","lote" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","impresion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 12   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hLongCliente" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(12)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 12   */
      v.add(doc.createElement("table"));
      ((Element)v.get(27)).setAttribute("width","100%" );
      ((Element)v.get(27)).setAttribute("border","0" );
      ((Element)v.get(27)).setAttribute("cellspacing","0" );
      ((Element)v.get(27)).setAttribute("cellpadding","0" );
      ((Element)v.get(12)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","12" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","750" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(28)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("height","1" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:28   */

      /* Empieza nodo:35 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(40)).setAttribute("class","legend" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","Seleccion" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","legend" );
      ((Element)v.get(41)).setAttribute("cod","0075" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(42)).setAttribute("border","0" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(45)).setAttribute("width","581" );
      ((Element)v.get(45)).setAttribute("border","0" );
      ((Element)v.get(45)).setAttribute("align","left" );
      ((Element)v.get(45)).setAttribute("cellspacing","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("colspan","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:49 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","2" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","CodCliente" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","263" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","TipoPeriodo" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","132" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","Periodo" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","276" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","25" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","CodPatron" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","823" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:49   */

      /* Empieza nodo:68 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(72)).setAttribute("nombre","codCliente" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("max","15" );
      ((Element)v.get(72)).setAttribute("tipo","" );
      ((Element)v.get(72)).setAttribute("onblur","clienteOnBlur();" );
      ((Element)v.get(72)).setAttribute("req","S" );
      ((Element)v.get(72)).setAttribute("size","15" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("validacion","" );
      ((Element)v.get(72)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(75)).setAttribute("onclick","buscarCliente();" );
      ((Element)v.get(73)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(79)).setAttribute("nombre","comboTipoPeriodo" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("size","1" );
      ((Element)v.get(79)).setAttribute("multiple","N" );
      ((Element)v.get(79)).setAttribute("req","S" );
      ((Element)v.get(79)).setAttribute("valorinicial","" );
      ((Element)v.get(79)).setAttribute("textoinicial","" );
      ((Element)v.get(79)).setAttribute("onchange","tipoPeriodoOnChange();" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","comboPeriodo" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("req","S" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("valign","bottom" );
      ((Element)v.get(68)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).setAttribute("nombre","cbCodPatron" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:68   */

      /* Empieza nodo:93 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("colspan","9" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:96 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","581" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","NLoteImpresionLabel" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","936" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblFImpresion" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","1159" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:99   */

      /* Empieza nodo:110 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("valign","bottom" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(114)).setAttribute("nombre","NloteImpresion" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("max","10" );
      ((Element)v.get(114)).setAttribute("tipo","" );
      ((Element)v.get(114)).setAttribute("onchange","" );
      ((Element)v.get(114)).setAttribute("req","N" );
      ((Element)v.get(114)).setAttribute("size","10" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("validacion","" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).setAttribute("valign","bottom" );
      ((Element)v.get(110)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(118)).setAttribute("nombre","FImpresion" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("max","10" );
      ((Element)v.get(118)).setAttribute("tipo","" );
      ((Element)v.get(118)).setAttribute("onchange","" );
      ((Element)v.get(118)).setAttribute("req","N" );
      ((Element)v.get(118)).setAttribute("size","10" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("validacion","" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:110   */

      /* Empieza nodo:121 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","9" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:42   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:124 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:35   */

      /* Empieza nodo:126 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("class","botonera" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
      ((Element)v.get(134)).setAttribute("tipo","html" );
      ((Element)v.get(134)).setAttribute("accion","buscar();" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("cod","1" );
      ((Element)v.get(134)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:135 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","12" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:126   */

      /* Empieza nodo:137 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("height","12" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","756" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","12" );
      ((Element)v.get(137)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(143)).setAttribute("height","1" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:137   */
      /* Termina nodo:27   */

      /* Empieza nodo:144 / Elemento padre: 12   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(144)).setAttribute("nombre","listado1" );
      ((Element)v.get(144)).setAttribute("ancho","585" );
      ((Element)v.get(144)).setAttribute("alto","317" );
      ((Element)v.get(144)).setAttribute("x","12" );
      ((Element)v.get(144)).setAttribute("y","169" );
      ((Element)v.get(144)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(144)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(12)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(145)).setAttribute("precarga","S" );
      ((Element)v.get(145)).setAttribute("conROver","S" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(146)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(146)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(146)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(146)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(147)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(147)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(147)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(147)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(148)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(148)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:145   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(150)).setAttribute("borde","1" );
      ((Element)v.get(150)).setAttribute("horizDatos","1" );
      ((Element)v.get(150)).setAttribute("horizCabecera","1" );
      ((Element)v.get(150)).setAttribute("vertical","1" );
      ((Element)v.get(150)).setAttribute("horizTitulo","1" );
      ((Element)v.get(150)).setAttribute("horizBase","1" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 149   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(151)).setAttribute("borde","#999999" );
      ((Element)v.get(151)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(151)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(151)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(151)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(151)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(151)).setAttribute("horizBase","#999999" );
      ((Element)v.get(149)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:149   */

      /* Empieza nodo:152 / Elemento padre: 144   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(152)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(152)).setAttribute("alto","22" );
      ((Element)v.get(152)).setAttribute("imgFondo","" );
      ((Element)v.get(152)).setAttribute("cod","00135" );
      ((Element)v.get(152)).setAttribute("ID","datosTitle" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 144   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(153)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(153)).setAttribute("alto","22" );
      ((Element)v.get(153)).setAttribute("imgFondo","" );
      ((Element)v.get(144)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 144   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(154)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(154)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(154)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(154)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(154)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(154)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(144)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","1000" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 144   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(156)).setAttribute("alto","20" );
      ((Element)v.get(156)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(156)).setAttribute("imgFondo","" );
      ((Element)v.get(156)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(156)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(144)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(157)).setAttribute("cod","531" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("Menasajes"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:159 / Elemento padre: 144   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(159)).setAttribute("alto","22" );
      ((Element)v.get(159)).setAttribute("accion","" );
      ((Element)v.get(159)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(159)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(159)).setAttribute("maxSel","-1" );
      ((Element)v.get(159)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(159)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(159)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(159)).setAttribute("onLoad","" );
      ((Element)v.get(159)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(144)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("tipo","texto" );
      ((Element)v.get(160)).setAttribute("ID","EstDat" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 144   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(144)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 144   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(162)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(162)).setAttribute("ancho","585" );
      ((Element)v.get(162)).setAttribute("sep","$" );
      ((Element)v.get(162)).setAttribute("x","12" );
      ((Element)v.get(162)).setAttribute("class","botonera" );
      ((Element)v.get(162)).setAttribute("y","463" );
      ((Element)v.get(162)).setAttribute("control","|" );
      ((Element)v.get(162)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(162)).setAttribute("rowset","" );
      ((Element)v.get(162)).setAttribute("cargainicial","N" );
      ((Element)v.get(162)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(144)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(163)).setAttribute("nombre","ret1" );
      ((Element)v.get(163)).setAttribute("x","37" );
      ((Element)v.get(163)).setAttribute("y","467" );
      ((Element)v.get(163)).setAttribute("ID","botonContenido" );
      ((Element)v.get(163)).setAttribute("img","retroceder_on" );
      ((Element)v.get(163)).setAttribute("tipo","0" );
      ((Element)v.get(163)).setAttribute("estado","false" );
      ((Element)v.get(163)).setAttribute("alt","" );
      ((Element)v.get(163)).setAttribute("codigo","" );
      ((Element)v.get(163)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 162   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(164)).setAttribute("nombre","ava1" );
      ((Element)v.get(164)).setAttribute("x","52" );
      ((Element)v.get(164)).setAttribute("y","467" );
      ((Element)v.get(164)).setAttribute("ID","botonContenido" );
      ((Element)v.get(164)).setAttribute("img","avanzar_on" );
      ((Element)v.get(164)).setAttribute("tipo","0" );
      ((Element)v.get(164)).setAttribute("estado","false" );
      ((Element)v.get(164)).setAttribute("alt","" );
      ((Element)v.get(164)).setAttribute("codigo","" );
      ((Element)v.get(164)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(162)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:162   */
      /* Termina nodo:144   */

      /* Empieza nodo:165 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(165)).setAttribute("nombre","primera1" );
      ((Element)v.get(165)).setAttribute("x","20" );
      ((Element)v.get(165)).setAttribute("y","467" );
      ((Element)v.get(165)).setAttribute("ID","botonContenido" );
      ((Element)v.get(165)).setAttribute("img","primera_on" );
      ((Element)v.get(165)).setAttribute("tipo","-2" );
      ((Element)v.get(165)).setAttribute("estado","false" );
      ((Element)v.get(165)).setAttribute("alt","" );
      ((Element)v.get(165)).setAttribute("codigo","" );
      ((Element)v.get(165)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(12)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 12   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(166)).setAttribute("nombre","separa" );
      ((Element)v.get(166)).setAttribute("x","59" );
      ((Element)v.get(166)).setAttribute("y","463" );
      ((Element)v.get(166)).setAttribute("ID","botonContenido" );
      ((Element)v.get(166)).setAttribute("img","separa_base" );
      ((Element)v.get(166)).setAttribute("tipo","0" );
      ((Element)v.get(166)).setAttribute("estado","false" );
      ((Element)v.get(166)).setAttribute("alt","" );
      ((Element)v.get(166)).setAttribute("codigo","" );
      ((Element)v.get(166)).setAttribute("accion","" );
      ((Element)v.get(12)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 12   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(167)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(167)).setAttribute("alto","12" );
      ((Element)v.get(167)).setAttribute("ancho","100%" );
      ((Element)v.get(167)).setAttribute("colorf","" );
      ((Element)v.get(167)).setAttribute("borde","0" );
      ((Element)v.get(167)).setAttribute("imagenf","" );
      ((Element)v.get(167)).setAttribute("repeat","" );
      ((Element)v.get(167)).setAttribute("padding","" );
      ((Element)v.get(167)).setAttribute("visibilidad","visible" );
      ((Element)v.get(167)).setAttribute("contravsb","" );
      ((Element)v.get(167)).setAttribute("x","0" );
      ((Element)v.get(167)).setAttribute("y","483" );
      ((Element)v.get(167)).setAttribute("zindex","" );
      ((Element)v.get(12)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:12   */


   }

}
