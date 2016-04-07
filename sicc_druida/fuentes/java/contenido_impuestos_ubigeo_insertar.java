
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_impuestos_ubigeo_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_impuestos_ubigeo_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar Impuestos por Ubigeo" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(3)).setAttribute("name","txtCodigoSap" );
      ((Element)v.get(3)).setAttribute("required","true" );
      ((Element)v.get(3)).setAttribute("cod","585" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","cbCanal" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","7" );
      ((Element)v.get(2)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbAcceso" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","10" );
      ((Element)v.get(2)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbSubacceso" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","122" );
      ((Element)v.get(2)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:2   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Elemento padre:7 / Elemento actual: 8   */
      v.add(doc.createTextNode("\r   \r\r  var varNoLimpiarSICC = true;\r  var formName = \"frmFormulario\";\r\r  function onLoad(){     \r     configurarMenuSecundario(formName);\r     focaliza('frmFormulario.txtCodigoSap');\r     \r\r     if(get('frmFormulario.hidCasodeUso') == 'modificar'){\r        cargarPantalla();\r     }\r\r     if(get('frmFormulario.hidCasodeUso') == 'consultar'){\r        cargarPantallaConsultar();\r     }   \r     \r  }\r   function canalOnChange(){\r     var combo=window.event.srcElement.getAttribute(\"NAME\");\r	   var option=window.event.srcElement.options;\r	   for(var i=0;i<option.length;i++){\r		   if(option.item(i).getAttribute(\"selected\")){\r			   set('frmFormulario.nameComboSelected',combo);\r			   set('frmFormulario.valueComboSelected',option.item(i).getAttribute(\"value\"));\r         borrarCombo();\r			   cargarComboEditable();\r		   }\r	   }\r   }\r\r   function cargarComboEditable(){\r	    var name = get('frmFormulario.nameComboSelected');\r      var cad = new String();\r	    cad=name;\r      var largo = cad.length;\r\r      var Lista = document.getElementById(\"cbAcceso\");\r      for(var k=0;k<Lista1.datos.longitud;k++) {\r         if ( Lista1.datos.ij(k,2) == get('frmFormulario.valueComboSelected')) {\r   	 	      var option =  document.createElement(\"OPTION\");\r            Lista.options.add(option);\r        		option.innerText=Lista1.datos.ij(k,1);\r			      option.value= Lista1.datos.ij(k,0);\r		     }\r	    }\r   }\r\r\r   function borrarCombo(){    \r\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('frmFormulario.cbAcceso',aCombo, []);\r      set_combo('frmFormulario.cbSubacceso',aCombo, []);\r    }\r      \r   function accesoOnChange(){\r     var combo=window.event.srcElement.getAttribute(\"NAME\");\r	   var option=window.event.srcElement.options;\r	   for(var i=0;i<option.length;i++){\r   		 if(option.item(i).getAttribute(\"selected\")){\r     \r			   set('frmFormulario.nameComboSelected2',combo);\r			   set('frmFormulario.valueComboSelected2',option.item(i).getAttribute(\"value\"));\r         borrarCombo2();\r			   cargarComboEditable2();\r		   }\r	   }\r   }\r\r   \r\r   function cargarComboEditable2(){\r	    var name = get('frmFormulario.nameComboSelected2');\r      var cad = new String();\r	    cad=name;\r      var largo = cad.length;\r      \r      var Lista = document.getElementById(\"cbSubacceso\");\r      for(var k=0;k<Lista2.datos.longitud;k++) {\r         if ( Lista2.datos.ij(k,2) == get('frmFormulario.valueComboSelected2')) {\r     	 	    var option =  document.createElement(\"OPTION\");\r            Lista.options.add(option);\r        		option.innerText=Lista2.datos.ij(k,1);\r			      option.value= Lista2.datos.ij(k,0);\r		     }\r	    }\r   }\r\r\r   function borrarCombo2(){\r	    var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('frmFormulario.cbSubacceso',aCombo, []);\r   }\r   \r\r   function fGuardar(){\r       if(!sicc_validaciones_generales()){\r			   return false;\r		  }else{\r                 \r         if(get('frmFormulario.hidCasodeUso') == 'modificar'){\r            set('frmFormulario.conectorAction', 'LPModificacionImpuestos')\r            set('frmFormulario.accion', 'guardar');\r            eval('frmFormulario').oculto = 'S';\r            enviaSICC('frmFormulario');\r\r         }else{\r            set('frmFormulario.conectorAction', 'LPInsertarImpuestosUBIGEO')\r            set('frmFormulario.accion', 'guardar');\r            eval('frmFormulario').oculto = 'S';\r            enviaSICC('frmFormulario');\r         }\r         \r      }\r	}\r\r  function guardoOk(){\r     set('frmFormulario.txtCodigoSap', '');\r     focaliza('frmFormulario.txtCodigoSap');\r     set('frmFormulario.cbIndicadorImpuesto', '');\r     set('frmFormulario.cbCanal', '');\r     var aCombo = new Array(new Array(\"\",\"\"));\r     set_combo('frmFormulario.cbAcceso',aCombo, []);\r     set_combo('frmFormulario.cbSubacceso',aCombo, []);\r     \r  }\r\r  function fVolver(){\r     this.close();\r  }\r\r  function noGuardo(){\r  }\r\r  function fLimpiar(){\r     if(get('frmFormulario.hidCasodeUso') == 'modificar'){\r        var oid = get('frmFormulario.hOidImpuesto');\r        set(\"frmFormulario.cbIndicadorImpuesto\",new Array(oid));\r        focaliza('frmFormulario.cbIndicadorImpuesto');\r     }else{\r        if(get('frmFormulario.hidCasodeUso') != 'consultar'){\r           guardoOk();\r        }\r     } \r   \r  }\r\r  function cargarPantalla(){\r\r     set('frmFormulario.txtCodigoSap', get('frmFormulario.hProducto'));\r     accion(\"frmFormulario.txtCodigoSap\",\".disabled=true\");\r\r     combo_add(\"frmFormulario.cbCanal\",\"1\",get(\"frmFormulario.hCanal\"));\r     set(\"frmFormulario.cbCanal\",new Array(\"1\"));\r     accion(\"frmFormulario.cbCanal\",\".disabled=true\");\r         \r     combo_add(\"frmFormulario.cbAcceso\",\"2\",get(\"frmFormulario.hAcceso\"));\r     set(\"frmFormulario.cbAcceso\",new Array(\"2\"));\r     accion(\"frmFormulario.cbAcceso\",\".disabled=true\");\r\r     combo_add(\"frmFormulario.cbSubacceso\",\"3\",get(\"frmFormulario.hSubacceso\"));\r     set(\"frmFormulario.cbSubacceso\",new Array(\"3\"));\r     accion(\"frmFormulario.cbSubacceso\",\".disabled=true\");\r     \r     var oid = get('frmFormulario.hOidImpuesto');\r     set(\"frmFormulario.cbIndicadorImpuesto\",new Array(oid));\r     focaliza('frmFormulario.cbIndicadorImpuesto');\r\r     \r     \r  }\r\r  function cargarPantallaConsultar(){\r\r     set('frmFormulario.txtCodigoSap', get('frmFormulario.hProducto'));\r     accion(\"frmFormulario.txtCodigoSap\",\".disabled=true\");\r\r     combo_add(\"frmFormulario.cbIndicadorImpuesto\",\"5\",get(\"frmFormulario.hImpuesto\"));\r     set(\"frmFormulario.cbIndicadorImpuesto\",new Array(\"5\"));\r     accion(\"frmFormulario.cbIndicadorImpuesto\",\".disabled=true\");\r\r     combo_add(\"frmFormulario.cbCanal\",\"1\",get(\"frmFormulario.hCanal\"));\r     set(\"frmFormulario.cbCanal\",new Array(\"1\"));\r     accion(\"frmFormulario.cbCanal\",\".disabled=true\");\r         \r     combo_add(\"frmFormulario.cbAcceso\",\"2\",get(\"frmFormulario.hAcceso\"));\r     set(\"frmFormulario.cbAcceso\",new Array(\"2\"));\r     accion(\"frmFormulario.cbAcceso\",\".disabled=true\");\r\r     combo_add(\"frmFormulario.cbSubacceso\",\"3\",get(\"frmFormulario.hSubacceso\"));\r     set(\"frmFormulario.cbSubacceso\",new Array(\"3\"));\r     accion(\"frmFormulario.cbSubacceso\",\".disabled=true\");\r     \r     \r\r\r\r  }\r\r  function modificoOk(){\r      \r  }\r\r  function noModifico(){\r\r  }\r\r\r\r   \r   \r"));
      ((Element)v.get(7)).appendChild((Text)v.get(8));

      /* Termina nodo Texto:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
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
      ((Element)v.get(14)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","nameComboSelected2" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","valueComboSelected2" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidCasodeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hProducto" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hOidImpuesto" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hCanal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hSubacceso" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oid" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hImpuesto" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(26)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(26)).setAttribute("x","0" );
      ((Element)v.get(26)).setAttribute("y","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("table"));
      ((Element)v.get(27)).setAttribute("width","100%" );
      ((Element)v.get(27)).setAttribute("border","0" );
      ((Element)v.get(27)).setAttribute("cellspacing","0" );
      ((Element)v.get(27)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

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
      ((Element)v.get(41)).setAttribute("nombre","lblDatosAlta" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","legend" );
      ((Element)v.get(41)).setAttribute("cod","00125" );
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
      ((Element)v.get(44)).setAttribute("colspan","3" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblCodigoSap" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","585" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","25" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblIndicadorImpuesto" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","1333" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","25" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","7" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(46)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:46   */

      /* Empieza nodo:61 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(65)).setAttribute("nombre","txtCodigoSap" );
      ((Element)v.get(65)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).setAttribute("max","20" );
      ((Element)v.get(65)).setAttribute("tipo","" );
      ((Element)v.get(65)).setAttribute("onchange","" );
      ((Element)v.get(65)).setAttribute("req","S" );
      ((Element)v.get(65)).setAttribute("size","27" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("validacion","" );
      ((Element)v.get(65)).setAttribute("onshtab","focaliza('frmFormulario.cbSubacceso')" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("width","25" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(69)).setAttribute("nombre","cbIndicadorImpuesto" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("size","1" );
      ((Element)v.get(69)).setAttribute("multiple","N" );
      ((Element)v.get(69)).setAttribute("req","N" );
      ((Element)v.get(69)).setAttribute("valorinicial","" );
      ((Element)v.get(69)).setAttribute("textoinicial","" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:71 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(74)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("size","1" );
      ((Element)v.get(74)).setAttribute("multiple","N" );
      ((Element)v.get(74)).setAttribute("req","S" );
      ((Element)v.get(74)).setAttribute("valorinicial","" );
      ((Element)v.get(74)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:61   */

      /* Empieza nodo:78 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("colspan","3" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","7" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:42   */

      /* Empieza nodo:81 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(81)).setAttribute("border","0" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
      ((Element)v.get(81)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","10" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(82)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","122" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:82   */

      /* Empieza nodo:93 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(97)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("size","1" );
      ((Element)v.get(97)).setAttribute("multiple","N" );
      ((Element)v.get(97)).setAttribute("req","S" );
      ((Element)v.get(97)).setAttribute("valorinicial","" );
      ((Element)v.get(97)).setAttribute("textoinicial","" );
      ((Element)v.get(97)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(102)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("size","1" );
      ((Element)v.get(102)).setAttribute("multiple","N" );
      ((Element)v.get(102)).setAttribute("req","S" );
      ((Element)v.get(102)).setAttribute("valorinicial","" );
      ((Element)v.get(102)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).setAttribute("ontab","focaliza('frmFormulario.txtCodigoSap')" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:93   */

      /* Empieza nodo:106 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","3" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","7" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:81   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:109 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:35   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:9   */


   }

}
