
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_msg_imprimir  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_msg_imprimir" );
      ((Element)v.get(0)).setAttribute("cod","0330" );
      ((Element)v.get(0)).setAttribute("titulo","Imprimir mensajes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Imprimir mensajes" );
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
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag()  {\r          var a = chequeaErrores();\r		  \r          configurarMenuSecundario(\"frmMsgImprimir\");\r          focaliza('frmMsgImprimir.comboPatron');\r          btnProxy(1, 0);\r          btnProxy(2, 0);\r          btnProxy(3, 0);\r          btnProxy(4, 0); \r          \r          if (get('frmMsgImprimir.errDescripcion')!='') {\r           var wnd = fMostrarMensajeError(get('frmMsgImprimir.errCodigo'), get('frmMsgImprimir.errDescripcion'));\r          }\r}\r\r\rfunction accionBuscarCliente() {\r          var obj = new Object();\r              var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);\r              if(whnd==null){\r\r              }else{\r                  var oid;\r              \r                  var oid = whnd[0];\r                  var cod = whnd[1];\r                  var nombre1 = whnd[2];\r                  var apellido1 = whnd[4];\r                  set(\"frmMsgImprimir.txtCliente\", cod);    \r              \r              }     \r }\r\r\rfunction tipoPeriodoOnChange2(){\r		\r		    var cmb1 = document.getElementById(\"comboTipoPeriodo\");\r			\r			if(cmb1.options(cmb1.selectedIndex).text==\"\"){\r				\r								var cmb = document.getElementById(\"comboPeriodo\");\r				var opciones = cmb.options;\r				\r				\r				for(var i=0;i < opciones.length;i++){\r				\r					cmb.all.item(i).text=\"\";\r				}\r				return;\r			}\r			\r			\r			var arr = new Array();\r            arr[arr.length] = new Array(\"oidPais\", get('frmMsgImprimir.hPais'));\r            arr[arr.length] = new Array(\"oidIdioma\", get('frmMsgImprimir.hIdioma'));\r            arr[arr.length] = new Array(\"oidTipoPeriodo\", getIndiceSeleccionado('comboTipoPeriodo'));\r\r\r            recargaCombo('frmMsgImprimir.comboPeriodo','SEGObtenerPeriodosPorTipoPeriodo',\r                              'es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo',arr); \r							  \r			\r}\r\rfunction tipoPeriodoOnChange(){\r			var arr = new Array();\r         arr[arr.length] = new Array(\"oidPais\", get('frmMsgImprimir.hPais'));\r         arr[arr.length] = new Array(\"oidIdioma\", get('frmMsgImprimir.hIdioma'));\r         arr[arr.length] = new Array(\"oidTipoPeriodo\", get('frmMsgImprimir.comboTipoPeriodo'));\r         \r			recargaCombo('frmMsgImprimir.comboPeriodo','SEGObtenerPeriodosPorTipoPeriodo','es.indra.sicc.dtos.seg.DTOPeriodosPorTipoPeriodo',arr); \r}\r\r\rfunction getIndiceSeleccionado(name){\r          var obj = document.all.tags(\"SELECT\");\r          for(var i = 0; i<obj.length;i++){\r     \r          if(obj.item(i).name==\"comboPeriodo\"){ \r             return  obj.item(i).selectedIndex;\r       \r          }\r          if(obj.item(i).name==\"comboTipoPeriodo\"){ \r            return  obj.item(i).selectedIndex;\r        \r          }\r          if(obj.item(i).name==\"comboPatron\"){ \r            return  obj.item(i).selectedIndex;\r        \r          }\r        }\r}\r\r\rfunction errorAlGuardar(){  	  \r    if (get('frmMsgImprimir.errCodigo') == \"60021\") {\r        btnProxy(1, 0);\r        btnProxy(2, 0);\r        btnProxy(3, 0);\r        btnProxy(4, 0);                    \r    } \r}\r\rfunction  chequeaErrores() {\r		var errCod = get(\"frmMsgImprimir.errCodigo\");\r\r		if (errCod != null)\r		{\r				fMostrarMensajeError();\r        focaliza('frmMsgImprimir.comboPatron');\r				return true;\r		}   \r		return false;\r}\r\rfunction imprimir(){  \r  if (sicc_validaciones_generales()){    \r     var patron = get(\"frmMsgImprimir.comboPatron\");\r     var cliente =  get(\"frmMsgImprimir.txtCliente\");\r     var periodo = get(\"frmMsgImprimir.comboPeriodo\"); \r          \r     set(\"frmMsgImprimir.oidPatronH\", patron);\r     set(\"frmMsgImprimir.codigoClienteH\", cliente);\r     set(\"frmMsgImprimir.oidPeriodo\", periodo);\r\r	 set('frmMsgImprimir.accion','Imprimir mensajes');\r	 eval('frmMsgImprimir').oculto = 'S';\r	 set(\"frmMsgImprimir.conectorAction\", \"LPImprimirMensajesEditor\");\r	 enviaSICC('frmMsgImprimir'); \r  }  \r}\r\rfunction seteaValores(){ \r  btnProxy(1, 0);\r  btnProxy(2, 0);\r  btnProxy(3, 0);\r  btnProxy(4, 0);\r}\r\rfunction TabShift(){  \r	var obj=document.getElementsByName(\"btnImprimir\");\r	obj.item(0).focus();	\r}\r\rfunction TabUp(){  \r	focaliza(\"frmMsgImprimir.comboPatron\");	\r}\r\rfunction fLimpiar(){   \r	set(\"frmMsgImprimir.comboPatron\", \"\");\r	set(\"frmMsgImprimir.txtCliente\", \"\");\r	set(\"frmMsgImprimir.comboTipoPeriodo\",\"\");\r	set(\"frmMsgImprimir.comboPeriodo\",\"\");	 \r    focaliza('frmMsgImprimir.comboPatron');  \r}\r\rfunction llenarDigitos(){\r              var txt  = document.getElementsByName(\"txtCliente\").item(0);\r              if(get('frmMsgImprimir.txtCliente') != ''){\r              txt.value = get('frmMsgImprimir.txtCliente');\r              var uno = txt.value;\r              \r              \r              var valor = new Array(10);\r              var valoraux = new Array();\r               \r              valor = txt.value;\r              \r            \r              var con = Math.abs(11);\r              \r              \r              var dif = con-valor.length;\r              if(valor.length == con){\r                return;\r              }\r             if(valor.length < con){\r                   \r                  for(var i=0; i<dif;i++){\r                   valoraux= valoraux + '0';\r                }\r                \r                                             set('frmMsgImprimir.txtCliente', valoraux + uno );\r\r              }else{ \r                  txt.value= \"\";\r            \r            }\r          }else{\r           \r          }\r        }\r\r \r\r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","comboPatron" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","823" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmMsgImprimir" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidPeriodo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidPatronH" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","codigoClienteH" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(19)).setAttribute("width","100%" );
      ((Element)v.get(19)).setAttribute("border","0" );
      ((Element)v.get(19)).setAttribute("cellspacing","0" );
      ((Element)v.get(19)).setAttribute("cellpadding","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("align","center" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","750" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","1" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:20   */

      /* Empieza nodo:27 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(32)).setAttribute("class","legend" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(33)).setAttribute("nombre","Seleccion" );
      ((Element)v.get(33)).setAttribute("alto","13" );
      ((Element)v.get(33)).setAttribute("filas","1" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(33)).setAttribute("id","legend" );
      ((Element)v.get(33)).setAttribute("cod","00513" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","480" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","left" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("colspan","6" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","codPatron" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","823" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","25" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("colspan","2" );
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","codCliente" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","263" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","TipoPeriodo" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","132" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","Periodo" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","276" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(41)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:41   */

      /* Empieza nodo:60 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","comboPatron" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","S" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(64)).setAttribute("onshtab","TabShift();" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","25" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(69)).setAttribute("nombre","txtCliente" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("max","15" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("tipo","" );
      ((Element)v.get(69)).setAttribute("onchange","llenarDigitos();" );
      ((Element)v.get(69)).setAttribute("req","N" );
      ((Element)v.get(69)).setAttribute("size","15" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("validacion","" );
      ((Element)v.get(69)).setAttribute("onchane","llenarDigitos()" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(72)).setAttribute("onclick","accionBuscarCliente();" );
      ((Element)v.get(70)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:70   */

      /* Empieza nodo:73 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(76)).setAttribute("nombre","comboTipoPeriodo" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("size","1" );
      ((Element)v.get(76)).setAttribute("multiple","N" );
      ((Element)v.get(76)).setAttribute("req","N" );
      ((Element)v.get(76)).setAttribute("valorinicial","" );
      ((Element)v.get(76)).setAttribute("textoinicial","" );
      ((Element)v.get(76)).setAttribute("onchange","tipoPeriodoOnChange();" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(81)).setAttribute("nombre","comboPeriodo" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("size","1" );
      ((Element)v.get(81)).setAttribute("multiple","N" );
      ((Element)v.get(81)).setAttribute("req","N" );
      ((Element)v.get(81)).setAttribute("valorinicial","" );
      ((Element)v.get(81)).setAttribute("textoinicial","" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:60   */

      /* Empieza nodo:85 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("colspan","6" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:88 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:27   */

      /* Empieza nodo:90 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(95)).setAttribute("border","0" );
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("cellpadding","0" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("class","botonera" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(98)).setAttribute("nombre","btnImprimir" );
      ((Element)v.get(98)).setAttribute("ID","botonContenido" );
      ((Element)v.get(98)).setAttribute("tipo","html" );
      ((Element)v.get(98)).setAttribute("accion","imprimir();" );
      ((Element)v.get(98)).setAttribute("estado","false" );
      ((Element)v.get(98)).setAttribute("cod","1157" );
      ((Element)v.get(98)).setAttribute("ontab","TabUp();" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:99 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","12" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:90   */

      /* Empieza nodo:101 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","12" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","756" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","1" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:101   */
      /* Termina nodo:19   */
      /* Termina nodo:9   */


   }

}
