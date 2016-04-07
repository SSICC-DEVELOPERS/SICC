
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_seguimiento_pedidos  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_seguimiento_pedidos" );
      ((Element)v.get(0)).setAttribute("cod","0434" );
      ((Element)v.get(0)).setAttribute("titulo","Seguimiento de Pedidos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Seguimiento de Pedidos" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r     \r\rfunction busca_modi()\r{  \r  var can = listado1.codigos();\r  \r  if (can.length>0)\r  { \r    focalizaBotonHTML('botonContenido','Visualizar');  \r  }\r  else\r  {\r    focaliza('frmFormulario.cbCanalConsolidado');\r  }\r}\r\rfunction vuelve(){\rvar can = listado1.codigos();\r  \r  if (can.length>0)\r  { \r    focalizaBotonHTML('botonContenido','Visualizar');  \r  }\r  else\r  {\r    focalizaBotonHTML('botonContenido','btnBuscar');\r  }\r\r} \r\r  function buscar() \r  {\r    \r    if ((get(\"frmFormulario.cbCanalConsolidado\")!=\"\") | (get(\"frmFormulario.cbCanalConsolidado\") !=\"\") | (get(\"frmFormulario.cbAccesoConsolidado\")!=\"\") | (get(\"frmFormulario.cbSubaccesoConsolidado\") !=\"\") | (get(\"frmFormulario.cbHitoSeguimiento\") !=\"\") | (get(\"frmFormulario.cbTipoDocumento\")!=\"\") |(get(\"frmFormulario.txtNumeroConsolidado\")!=\"\"))\r    {\r      if(!sicc_validaciones_generales())\r      {\r        return false;\r      }\r     \r        var arrDatos = new Array();\r        arrDatos = armarArray();\r        configurarPaginado(mipgndo,\"PEDBuscarSeguimientoPedidos\",\"ConectorBuscarSeguimientoPedidos\",\"es.indra.sicc.dtos.ped.DTOBuscarSeguimientoPedidos\",arrDatos);\r     \r    }\r    else \r    {\r      var wnd = GestionarMensaje(\"1335\", null, null, null);\r    }\r  }\r\r/*modificaciones\r		24/06/2005 - Incidencia 16881 - pperanzola\r*/\rfunction visualizar()\r{\r  \r  if  (listado1.numSelecc()!= 1)   \r  {\r    var wnd = GestionarMensaje(\"1021\", null, null, null);\r    return\r  }else{ \r  				var indexOidSolic = 14;\r		var indexTipoDoc  = 17;\r		var indexSelect = DrIndiceEnArray(listado1.datos,listado1.codSeleccionados(),0);\r		var oidTipoDocumento  = listado1.datos[indexSelect][indexTipoDoc];\r		if((get(\"frmFormulario.KTipoDocPedido\")== oidTipoDocumento) || (get(\"frmFormulario.KTipoDocConsolidado\")== oidTipoDocumento)){\r						var accion = \"\";\r			var operacion = \"Consultar\";\r			var oidSolicitud = listado1.datos[indexSelect][indexOidSolic];\r			var obj = new Object();\r			obj.accion = accion;\r			obj.operacion = operacion;\r			obj.oidCabeceraSolicitud = oidSolicitud;\r			var ventana = mostrarModalSICC(\"LPConsultarModificarSolicitud\",accion,obj);\r\r\r		}else if (get(\"frmFormulario.KTipoDocOrdenTransporte\")== oidTipoDocumento){\r			var wnd = GestionarMensaje(\"UIPED036\", null, null, null);\r			return\r		}else if (get(\"frmFormulario.KTipoDocListaPicado\")== oidTipoDocumento){\r						\r							var accion = \"VisualizarLP\";\r				var oidSolicitud = listado1.datos[indexSelect][indexOidSolic];\r				var obj = new Object();\r				obj.accion = accion;\r				obj.oidCabeceraSolicitud = oidSolicitud;\r				var ventana = mostrarModalSICC(\"LPConsultarSeguimientoPedidos\",accion,obj);\r					}\r	}	/*eval('frmFormulario').oculto = 'S';\r	enviaSICC('frmFormulario');*/\r	buscar();\r}\r    \r\r  function armarArray(){\r      var arrDatos = new Array();\r      var i=0;\r    \r    \r      if (get(\"frmFormulario.cbCanalConsolidado\")!='')\r      {\r             arrDatos[i] = new Array('canal',get(\"frmFormulario.cbCanalConsolidado\"));\r             i++;\r      }\r      if (get(\"frmFormulario.cbAccesoConsolidado\")!=''){\r             arrDatos[i] = new Array('acceso',get(\"frmFormulario.cbAccesoConsolidado\"));\r             i++\r      \r      }\r\r      if (get(\"frmFormulario.cbSubaccesoConsolidado\")!='')\r      {\r             arrDatos[i] = new Array('subacceso',get(\"frmFormulario.cbSubaccesoConsolidado\"));\r             i++;\r      }\r      if (get(\"frmFormulario.cbHitoSeguimiento\")!=''){\r             arrDatos[i] = new Array('hito',get(\"frmFormulario.cbHitoSeguimiento\"));\r             i++\r      \r      }     \r    \r    \r    \r\r      if (get(\"frmFormulario.cbTipoDocumento\")!=''){\r             arrDatos[i] = new Array('tipoDocumento',get(\"frmFormulario.cbTipoDocumento\"));\r             i++\r      \r      }\r\r      if (get(\"frmFormulario.txtNumeroConsolidado\")!=''){\r             arrDatos[i] = new Array('numeroConsolidado',get(\"frmFormulario.txtNumeroConsolidado\"));\r             i++\r      \r      }     \r\r\r      return arrDatos;\r  }\r\r  \r  function fLimpiar() \r  {\r    var arr = new Array();\r    set(\"frmFormulario.cbCanalConsolidado\", \"\");\r    set(\"frmFormulario.cbAccesoConsolidado\", \"\");\r    set(\"frmFormulario.cbSubaccesoConsolidado\", \"\");  \r    set(\"frmFormulario.cbHitoSeguimiento\", \"\");\r    set(\"frmFormulario.cbTipoDocumento\", \"\");\r    set(\"frmFormulario.cbCanalConsolidado\", arr[0]);    \r    set(\"frmFormulario.txtNumeroConsolidado\", \"\");\r    focaliza(\"frmFormulario.cbCanalConsolidado\"); \r  }\r      \r	function onLoadPag()   \r	{\r			DrdEnsanchaConMargenDcho('listado1',12);\r			focaliza('frmFormulario.cbCanalConsolidado');\r			configurarMenuSecundario(\"frmFormulario\");\r			mostrarCodigoError();\r			listado1.maxSel=1;   \r			 ocultarCapas();\r			eval (ON_RSZ);  \r			if (window.dialogArguments) { 					btnProxy(2,1);  					btnProxy(3,0);  			}\r	}\r\rfunction fVolver() {\r                  window.close();\r}\r\rfunction mostrarCodigoError()\r  {\r    var vErrCodigo = get('frmFormulario.errCodigo');\r    var vErrDescrip = get('frmFormulario.errDescripcion');\r    if (get('frmFormulario.errDescripcion')!='')\r    {\r      var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);\r    }\r    \r  }\r  \r  function ocultarCapas()\r  {\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r	  document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	  document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	  document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	  document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"VisualizarDiv\"].style.visibility='hidden'\r	  document.all[\"primera1Div\"].style.visibility='hidden';\r	  document.all[\"ret1Div\"].style.visibility='hidden';\r	  document.all[\"ava1Div\"].style.visibility='hidden';\r	  document.all[\"separaDiv\"].style.visibility='hidden';\r    \r  }\r\r  function mostrarCapas()\r  {\r    document.all[\"Cplistado1\"].style.visibility='';\r	  document.all[\"CpLin1listado1\"].style.visibility='';\r	  document.all[\"CpLin2listado1\"].style.visibility='';\r	  document.all[\"CpLin3listado1\"].style.visibility='';\r	  document.all[\"CpLin4listado1\"].style.visibility='';\r\r	  document.all[\"primera1Div\"].style.visibility='';\r	  document.all[\"ret1Div\"].style.visibility='';\r	  document.all[\"ava1Div\"].style.visibility='';\r	  document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"VisualizarDiv\"].style.visibility=''\r    \r  }\r\r  function onchange_Canal() \r  {\r    var arrDatos = new Array();\r    var i=0;\r    arrDatos[i] = new Array('oidIdioma',get('frmFormulario.idio'));\r    i++;\r    arrDatos[i] = new Array('oidCanal',get('frmFormulario.cbCanalConsolidado'));\r    i++;\r    \r    recargaCombo('frmFormulario.cbAccesoConsolidado','SEGObtenerAccesosPorCanal','es.indra.sicc.dtos.seg.DTOAccesosPorCanal',arrDatos);\r  }\r\r  function onchange_Acesso() \r  {\r    var arrDatos = new Array();\r    var i=0;\r    arrDatos[i] = new Array('oid',get('frmFormulario.cbAccesoConsolidado'));\r    i++;\r    arrDatos[i] = new Array('oidIdioma',get('frmFormulario.idio'));\r    i++;\r    recargaCombo('frmFormulario.cbSubaccesoConsolidado','SegObtenerSubaccesosPorAcceso','es.indra.sicc.util.DTOOID',arrDatos);\r  }\r\r\r\r  function muestraLista( ultima, rowset, error)\r  {\r    var tamano = rowset.length;\r    \r    if (tamano > 0) \r    {\r      \r      mostrarCapas();\r      eval (ON_RSZ);\r      focaliza(\"frmFormulario.cbCanalConsolidado\");\r      return true;\r    } \r    else \r    {\r      \r      ocultarCapas();\r                    \r      focaliza(\"frmFormulario.cbCanalConsolidado\");\r      return false;\r    }\r  }\r\r  \r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtNumeroConsolidado" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","1419" );
      ((Element)v.get(7)).setAttribute("format","e" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","99999999999" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","LPConsultarSeguimientoPedidos" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","idio" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","pais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","KTipoDocPedido" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","KTipoDocConsolidado" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","KTipoDocOrdenTransporte" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","KTipoDocListaPicado" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(20)).setAttribute("x","0" );
      ((Element)v.get(20)).setAttribute("y","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(35)).setAttribute("cod","0075" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","695" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","3" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCanalConsolidado" );
      ((Element)v.get(47)).setAttribute("alto","13" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","2467" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblAccesoConsolidado" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","2468" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:43   */

      /* Empieza nodo:54 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(58)).setAttribute("nombre","cbCanalConsolidado" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("size","1" );
      ((Element)v.get(58)).setAttribute("multiple","N" );
      ((Element)v.get(58)).setAttribute("req","N" );
      ((Element)v.get(58)).setAttribute("valorinicial","" );
      ((Element)v.get(58)).setAttribute("textoinicial","" );
      ((Element)v.get(58)).setAttribute("onchange","onchange_Canal();" );
      ((Element)v.get(58)).setAttribute("onshtab","vuelve();" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(63)).setAttribute("nombre","cbAccesoConsolidado" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("size","1" );
      ((Element)v.get(63)).setAttribute("multiple","N" );
      ((Element)v.get(63)).setAttribute("req","N" );
      ((Element)v.get(63)).setAttribute("valorinicial","" );
      ((Element)v.get(63)).setAttribute("textoinicial","" );
      ((Element)v.get(63)).setAttribute("onchange","onchange_Acesso();" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:54   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:67 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","695" );
      ((Element)v.get(69)).setAttribute("border","0" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("align","left" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("colspan","3" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:73 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblSubaccesoConsolidado" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","2346" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblNumeroConsolidado" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","1419" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:73   */

      /* Empieza nodo:84 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbSubaccesoConsolidado" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("req","N" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","25" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("nombre","txtNumeroConsolidado" );
      ((Element)v.get(93)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).setAttribute("max","10" );
      ((Element)v.get(93)).setAttribute("tipo","" );
      ((Element)v.get(93)).setAttribute("onchange","" );
      ((Element)v.get(93)).setAttribute("req","N" );
      ((Element)v.get(93)).setAttribute("size","15" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("validacion","" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(84)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:84   */

      /* Empieza nodo:96 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("colspan","3" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","7" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:99 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","695" );
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
      ((Element)v.get(106)).setAttribute("nombre","lblHitoSeguimiento" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","2347" );
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
      ((Element)v.get(110)).setAttribute("nombre","lblTipoDocumento" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("cod","1920" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(102)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:102   */

      /* Empieza nodo:113 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(117)).setAttribute("nombre","cbHitoSeguimiento" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("size","1" );
      ((Element)v.get(117)).setAttribute("multiple","N" );
      ((Element)v.get(117)).setAttribute("req","N" );
      ((Element)v.get(117)).setAttribute("valorinicial","" );
      ((Element)v.get(117)).setAttribute("textoinicial","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(122)).setAttribute("nombre","cbTipoDocumento" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("size","1" );
      ((Element)v.get(122)).setAttribute("multiple","N" );
      ((Element)v.get(122)).setAttribute("req","N" );
      ((Element)v.get(122)).setAttribute("valorinicial","" );
      ((Element)v.get(122)).setAttribute("textoinicial","" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:124 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:113   */

      /* Empieza nodo:126 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("colspan","3" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:129 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:29   */

      /* Empieza nodo:131 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("table"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(136)).setAttribute("border","0" );
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(136)).setAttribute("cellspacing","0" );
      ((Element)v.get(136)).setAttribute("cellpadding","0" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("class","botonera" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("tipo","html" );
      ((Element)v.get(139)).setAttribute("accion","buscar();" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("cod","1" );
      ((Element)v.get(139)).setAttribute("ontab","busca_modi();" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:140 / Elemento padre: 131   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","12" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:131   */

      /* Empieza nodo:142 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","12" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","756" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","12" );
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","1" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:142   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:149 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(149)).setAttribute("nombre","listado1" );
      ((Element)v.get(149)).setAttribute("ancho","698" );
      ((Element)v.get(149)).setAttribute("alto","317" );
      ((Element)v.get(149)).setAttribute("x","12" );
      ((Element)v.get(149)).setAttribute("y","201" );
      ((Element)v.get(149)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(149)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(150)).setAttribute("precarga","S" );
      ((Element)v.get(150)).setAttribute("conROver","S" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(151)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(151)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(151)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(151)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 150   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(152)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(152)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(152)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(152)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(153)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(153)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:150   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(155)).setAttribute("borde","1" );
      ((Element)v.get(155)).setAttribute("horizDatos","1" );
      ((Element)v.get(155)).setAttribute("horizCabecera","1" );
      ((Element)v.get(155)).setAttribute("vertical","1" );
      ((Element)v.get(155)).setAttribute("horizTitulo","1" );
      ((Element)v.get(155)).setAttribute("horizBase","1" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 154   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(156)).setAttribute("borde","#999999" );
      ((Element)v.get(156)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(156)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(156)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(156)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(156)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(156)).setAttribute("horizBase","#999999" );
      ((Element)v.get(154)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 149   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(157)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(157)).setAttribute("alto","22" );
      ((Element)v.get(157)).setAttribute("imgFondo","" );
      ((Element)v.get(157)).setAttribute("cod","00135" );
      ((Element)v.get(157)).setAttribute("ID","datosTitle" );
      ((Element)v.get(149)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(158)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(158)).setAttribute("alto","22" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(158)).setAttribute("imgFondo","" );
      ((Element)v.get(149)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 149   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(159)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(159)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(159)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(159)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(159)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(159)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(149)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","120" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","120" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","120" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","100" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("ancho","120" );
      ((Element)v.get(164)).setAttribute("minimizable","S" );
      ((Element)v.get(164)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","120" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","150" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","100" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","100" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","100" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","100" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","100" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","100" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).setAttribute("oculta","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","100" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(173)).setAttribute("oculta","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","100" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(174)).setAttribute("oculta","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","100" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(175)).setAttribute("oculta","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","100" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).setAttribute("oculta","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:159   */

      /* Empieza nodo:177 / Elemento padre: 149   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(177)).setAttribute("alto","20" );
      ((Element)v.get(177)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
      ((Element)v.get(177)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(149)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","2469" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","2470" );
      ((Element)v.get(177)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","2348" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","424" );
      ((Element)v.get(177)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","2467" );
      ((Element)v.get(177)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("cod","2468" );
      ((Element)v.get(177)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","2346" );
      ((Element)v.get(177)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","1419" );
      ((Element)v.get(177)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","2347" );
      ((Element)v.get(177)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","188" );
      ((Element)v.get(177)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("colFondo","" );
      ((Element)v.get(188)).setAttribute("ID","EstCab" );
      ((Element)v.get(188)).setAttribute("cod","2471" );
      ((Element)v.get(177)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("cod","1920" );
      ((Element)v.get(177)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("cod","0000" );
      ((Element)v.get(190)).setAttribute("oculta","S" );
      ((Element)v.get(177)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("colFondo","" );
      ((Element)v.get(191)).setAttribute("ID","EstCab" );
      ((Element)v.get(191)).setAttribute("cod","0000" );
      ((Element)v.get(191)).setAttribute("oculta","S" );
      ((Element)v.get(177)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("cod","0000" );
      ((Element)v.get(192)).setAttribute("oculta","S" );
      ((Element)v.get(177)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("cod","0000" );
      ((Element)v.get(193)).setAttribute("oculta","S" );
      ((Element)v.get(177)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(194)).setAttribute("cod","0000" );
      ((Element)v.get(194)).setAttribute("oculta","S" );
      ((Element)v.get(177)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:177   */

      /* Empieza nodo:195 / Elemento padre: 149   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(195)).setAttribute("alto","22" );
      ((Element)v.get(195)).setAttribute("accion","" );
      ((Element)v.get(195)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(195)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(195)).setAttribute("maxSel","-1" );
      ((Element)v.get(195)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(195)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(195)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(195)).setAttribute("onLoad","" );
      ((Element)v.get(195)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(149)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("tipo","texto" );
      ((Element)v.get(196)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","texto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("tipo","texto" );
      ((Element)v.get(201)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("tipo","texto" );
      ((Element)v.get(202)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("tipo","texto" );
      ((Element)v.get(203)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("tipo","texto" );
      ((Element)v.get(204)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("tipo","texto" );
      ((Element)v.get(205)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("tipo","texto" );
      ((Element)v.get(206)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("tipo","texto" );
      ((Element)v.get(207)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("tipo","texto" );
      ((Element)v.get(208)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(211)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:195   */

      /* Empieza nodo:213 / Elemento padre: 149   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(149)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 149   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(214)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(214)).setAttribute("ancho","698" );
      ((Element)v.get(214)).setAttribute("sep","$" );
      ((Element)v.get(214)).setAttribute("x","12" );
      ((Element)v.get(214)).setAttribute("class","botonera" );
      ((Element)v.get(214)).setAttribute("y","495" );
      ((Element)v.get(214)).setAttribute("control","|" );
      ((Element)v.get(214)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(214)).setAttribute("rowset","" );
      ((Element)v.get(214)).setAttribute("cargainicial","N" );
      ((Element)v.get(214)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)');" );
      ((Element)v.get(149)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(215)).setAttribute("nombre","ret1" );
      ((Element)v.get(215)).setAttribute("x","37" );
      ((Element)v.get(215)).setAttribute("y","499" );
      ((Element)v.get(215)).setAttribute("ID","botonContenido" );
      ((Element)v.get(215)).setAttribute("img","retroceder_on" );
      ((Element)v.get(215)).setAttribute("tipo","0" );
      ((Element)v.get(215)).setAttribute("estado","false" );
      ((Element)v.get(215)).setAttribute("alt","" );
      ((Element)v.get(215)).setAttribute("codigo","" );
      ((Element)v.get(215)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 214   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(216)).setAttribute("nombre","ava1" );
      ((Element)v.get(216)).setAttribute("x","52" );
      ((Element)v.get(216)).setAttribute("y","499" );
      ((Element)v.get(216)).setAttribute("ID","botonContenido" );
      ((Element)v.get(216)).setAttribute("img","avanzar_on" );
      ((Element)v.get(216)).setAttribute("tipo","0" );
      ((Element)v.get(216)).setAttribute("estado","false" );
      ((Element)v.get(216)).setAttribute("alt","" );
      ((Element)v.get(216)).setAttribute("codigo","" );
      ((Element)v.get(216)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(214)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:214   */
      /* Termina nodo:149   */

      /* Empieza nodo:217 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(217)).setAttribute("nombre","primera1" );
      ((Element)v.get(217)).setAttribute("x","20" );
      ((Element)v.get(217)).setAttribute("y","499" );
      ((Element)v.get(217)).setAttribute("ID","botonContenido" );
      ((Element)v.get(217)).setAttribute("img","primera_on" );
      ((Element)v.get(217)).setAttribute("tipo","-2" );
      ((Element)v.get(217)).setAttribute("estado","false" );
      ((Element)v.get(217)).setAttribute("alt","" );
      ((Element)v.get(217)).setAttribute("codigo","" );
      ((Element)v.get(217)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(218)).setAttribute("nombre","separa" );
      ((Element)v.get(218)).setAttribute("x","59" );
      ((Element)v.get(218)).setAttribute("y","495" );
      ((Element)v.get(218)).setAttribute("ID","botonContenido" );
      ((Element)v.get(218)).setAttribute("img","separa_base" );
      ((Element)v.get(218)).setAttribute("tipo","0" );
      ((Element)v.get(218)).setAttribute("estado","false" );
      ((Element)v.get(218)).setAttribute("alt","" );
      ((Element)v.get(218)).setAttribute("codigo","" );
      ((Element)v.get(218)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(219)).setAttribute("nombre","Visualizar" );
      ((Element)v.get(219)).setAttribute("x","80" );
      ((Element)v.get(219)).setAttribute("y","496" );
      ((Element)v.get(219)).setAttribute("ID","botonContenido" );
      ((Element)v.get(219)).setAttribute("img","" );
      ((Element)v.get(219)).setAttribute("tipo","html" );
      ((Element)v.get(219)).setAttribute("estado","false" );
      ((Element)v.get(219)).setAttribute("alt","" );
      ((Element)v.get(219)).setAttribute("cod","1473" );
      ((Element)v.get(219)).setAttribute("accion","visualizar();" );
      ((Element)v.get(219)).setAttribute("ontab","focaliza('frmFormulario.cbCanalConsolidado');" );
      ((Element)v.get(219)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(8)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(220)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(220)).setAttribute("alto","12" );
      ((Element)v.get(220)).setAttribute("ancho","50" );
      ((Element)v.get(220)).setAttribute("colorf","" );
      ((Element)v.get(220)).setAttribute("borde","0" );
      ((Element)v.get(220)).setAttribute("imagenf","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(220)).setAttribute("repeat","" );
      ((Element)v.get(220)).setAttribute("padding","" );
      ((Element)v.get(220)).setAttribute("visibilidad","visible" );
      ((Element)v.get(220)).setAttribute("contravsb","" );
      ((Element)v.get(220)).setAttribute("x","0" );
      ((Element)v.get(220)).setAttribute("y","518" );
      ((Element)v.get(220)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:8   */


   }

}
