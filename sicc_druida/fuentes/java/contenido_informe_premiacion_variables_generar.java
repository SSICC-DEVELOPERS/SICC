
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_premiacion_variables_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_premiacion_variables_generar" );
      ((Element)v.get(0)).setAttribute("cod","0874" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Premiación Variables por Pedido por Región por zona" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad()" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      setearPais();\r      onchangePais();\r      focaliza('Formulario.cbPais');\r   }\r    \r	function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r   function generar(formato){\r      \r      if(sicc_validaciones_generales()){\r        \r          var a = new Object();\r          a.accion = 'generar';\r          \r          a.pais = get('Formulario.cbPais');\r          a.marca = get('Formulario.cbMarca');  \r          a.canal = get('Formulario.cbCanal');\r          a.zona = quitarItemVacio(get('Formulario.cbZona'));\r          a.region = quitarItemVacio(get('Formulario.cbRegion'));\r          a.concurso = get('Formulario.cbConcurso');\r          a.periodoDesde = get('Formulario.cbPeriodoDesde');\r          a.periodoHasta = get('Formulario.cbPeriodoHasta');\r          a.variablesVenta = quitarItemVacio(get('Formulario.cbVariablesVenta'));\r          \r          a.formato = formato;\r          \r          mostrarModalSICC('INCPremiacionVariablesPedido','generar', a);\r\r      }\r\r   }\r \r   \r\r   function fLimpiar(){\r     \r     var aCombo = new Array(new Array(\"\",\"\"));\r     \r     set_combo('Formulario.cbRegion', aCombo, []); \r     set_combo('Formulario.cbZona', aCombo, []); \r     set_combo('Formulario.cbConcurso', aCombo, []); \r     \r     focaliza('Formulario.cbPais');\r     \r    }\r   \r\r    function cambioRegion(){\r		opciones = new Array();\r		set_combo('Formulario.cbZona',opciones);\r		combo_add('Formulario.cbZona', '', '');\r		var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r		var pais = get('Formulario.cbPais');\r		var regionConc = new String();\r		for(i=0;i<regiones.length;i++){\r			regionConc += regiones[i] + \"x\";\r		}\r		regionConc = regionConc.substring(0, regionConc.length-1);\r		var arr = new Array();\r		arr[arr.length] = ['cadena', regionConc];\r		arr[arr.length] = ['oidPais', pais]\r		if(regionConc != ''){\r			recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r		}\r    }\r\r     function setearPais(){\r          var pais = get('Formulario.pais');\r          \r          iSeleccionado = new Array(); \r          iSeleccionado[0] = pais;\r          set('Formulario.cbPais',iSeleccionado);\r       }\r\r    function onchangePais() {\r          pais   = get('Formulario.cbPais');\r          idioma = get('Formulario.idioma');\r          \r          if (pais != '') {\r                var arrConcurso = new Array();\r                arrConcurso[arrConcurso.length] = [\"oidPais\", pais]; \r                arrConcurso[arrConcurso.length] = [\"oidAgrugacion\", \"0\"];\r                \r                recargaCombo('Formulario.cbConcurso','INCObtenerConcursosREP', 'es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado',arrConcurso );\r          }\r    \r    }       \r\r   function onchangeMarcaCanal(){\r        \r        marca  = get('Formulario.cbMarca');\r        canal   = get('Formulario.cbCanal');\r        pais     = get('Formulario.cbPais');\r        idioma = get('Formulario.idioma');\r        \r        if(marca != '' && canal != '' && pais != ''){\r            \r            var arr2 = new Array();\r             \r            arr2[arr2.length] = [\"oidPais\", pais]; \r            arr2[arr2.length] = [\"oidMarca\", marca];\r            arr2[arr2.length] = [\"oidCanal\", canal];\r            \r            recargaCombo(\"Formulario.cbRegion\",\"ZONRecargaRegiones\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2); \r\r 		    var arr = new Array();\r            arr[arr.length] = [\"pais\", pais];\r            arr[arr.length] = [\"marca\", marca];\r            arr[arr.length] = [\"canal\", canal];\r			\r			recargaCombo(\"Formulario.cbPeriodoDesde\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r            recargaCombo(\"Formulario.cbPeriodoHasta\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r            \r\r        }else{\r\r          var aCombo = new Array(new Array(\"\",\"\"));\r          \r          set_combo('Formulario.cbRegion', aCombo, []);\r          set_combo('Formulario.cbZona', aCombo, []);\r		  set_combo('Formulario.cbPeriodoDesde', aCombo, []);\r		  set_combo('Formulario.cbPeriodoHasta', aCombo, []);\r        \r        }\r    \r    } \r\r   \r  \r    "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(4)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbPais" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","5" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbConcurso" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1604" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1175" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1176" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1176" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbVariablesVenta" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1021" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:6   */
      /* Termina nodo:4   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","idioma" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","pais" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(23)).setAttribute("nombre","capa1" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","750" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","1" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:25   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(37)).setAttribute("class","legend" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("id","legend" );
      ((Element)v.get(38)).setAttribute("cod","00275" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(42)).setAttribute("border","0" );
      ((Element)v.get(42)).setAttribute("align","left" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("colspan","4" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:46 / Elemento padre: 42   */
   }

   private void getXML180(Document doc) {
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
      ((Element)v.get(50)).setAttribute("nombre","lblPais" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","5" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(46)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:46   */

      /* Empieza nodo:53 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(57)).setAttribute("nombre","cbPais" );
      ((Element)v.get(57)).setAttribute("size","1" );
      ((Element)v.get(57)).setAttribute("multiple","N" );
      ((Element)v.get(57)).setAttribute("valorinicial","" );
      ((Element)v.get(57)).setAttribute("textoinicial","" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("req","S" );
      ((Element)v.get(57)).setAttribute("onchange","onchangePais(); onchangeMarcaCanal();" );
      ((Element)v.get(57)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarExcel');" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:53   */

      /* Empieza nodo:61 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("colspan","4" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:64 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(66)).setAttribute("border","0" );
      ((Element)v.get(66)).setAttribute("align","left" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

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
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","6" );
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
      ((Element)v.get(67)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","7" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(67)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:67   */

      /* Empieza nodo:78 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(82)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(82)).setAttribute("size","1" );
      ((Element)v.get(82)).setAttribute("multiple","N" );
      ((Element)v.get(82)).setAttribute("valorinicial","" );
      ((Element)v.get(82)).setAttribute("textoinicial","" );
      ((Element)v.get(82)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).setAttribute("req","S" );
      ((Element)v.get(82)).setAttribute("onchange","onchangeMarcaCanal()" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:84 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(87)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(87)).setAttribute("size","1" );
      ((Element)v.get(87)).setAttribute("multiple","N" );
      ((Element)v.get(87)).setAttribute("valorinicial","" );
      ((Element)v.get(87)).setAttribute("textoinicial","" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("req","S" );
      ((Element)v.get(87)).setAttribute("onchange","onchangeMarcaCanal()" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:78   */

      /* Empieza nodo:91 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","4" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:94 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("table"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(96)).setAttribute("align","left" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("cellpadding","0" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("id","datosTitle" );
      ((Element)v.get(101)).setAttribute("cod","109" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblZona" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("id","datosTitle" );
      ((Element)v.get(105)).setAttribute("cod","143" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(97)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:97   */

      /* Empieza nodo:108 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(112)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(112)).setAttribute("size","5" );
      ((Element)v.get(112)).setAttribute("multiple","S" );
      ((Element)v.get(112)).setAttribute("valorinicial","" );
      ((Element)v.get(112)).setAttribute("textoinicial","" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).setAttribute("req","N" );
      ((Element)v.get(112)).setAttribute("onchange","cambioRegion()" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","25" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 108   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(117)).setAttribute("nombre","cbZona" );
      ((Element)v.get(117)).setAttribute("size","5" );
      ((Element)v.get(117)).setAttribute("multiple","S" );
      ((Element)v.get(117)).setAttribute("valorinicial","" );
      ((Element)v.get(117)).setAttribute("textoinicial","" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("req","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(108)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:108   */

      /* Empieza nodo:121 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","4" );
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
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:124 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","100%" );
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
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblConcurso" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","1662" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","1175" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("cod","1176" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:127   */

      /* Empieza nodo:142 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","cbConcurso" );
      ((Element)v.get(146)).setAttribute("size","1" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("valorinicial","" );
      ((Element)v.get(146)).setAttribute("textoinicial","" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("req","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(150)).setAttribute("valign","top" );
      ((Element)v.get(142)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(151)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(151)).setAttribute("size","1" );
      ((Element)v.get(151)).setAttribute("multiple","N" );
      ((Element)v.get(151)).setAttribute("valorinicial","" );
      ((Element)v.get(151)).setAttribute("textoinicial","" );
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(151)).setAttribute("req","S" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:153 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(155)).setAttribute("valign","top" );
      ((Element)v.get(142)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(156)).setAttribute("size","1" );
      ((Element)v.get(156)).setAttribute("multiple","N" );
      ((Element)v.get(156)).setAttribute("valorinicial","" );
      ((Element)v.get(156)).setAttribute("textoinicial","" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("req","S" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:142   */

      /* Empieza nodo:160 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("colspan","4" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:163 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","left" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblVariablesVenta" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","1021" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:166   */

      /* Empieza nodo:173 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(177)).setAttribute("nombre","cbVariablesVenta" );
      ((Element)v.get(177)).setAttribute("size","5" );
      ((Element)v.get(177)).setAttribute("multiple","S" );
      ((Element)v.get(177)).setAttribute("valorinicial","01" );
      ((Element)v.get(177)).setAttribute("textoinicial","Activas iniciales" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("req","S" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(179)).setAttribute("ID","1" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(180)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(180)).setAttribute("TIPO","STRING" );
      ((Element)v.get(180)).setAttribute("VALOR","02" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 179   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(181)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(181)).setAttribute("TIPO","STRING" );
      ((Element)v.get(181)).setAttribute("VALOR","Activas finales" );
      ((Element)v.get(179)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(182)).setAttribute("ID","2" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(183)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(183)).setAttribute("TIPO","STRING" );
      ((Element)v.get(183)).setAttribute("VALOR","03" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 182   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(184)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(184)).setAttribute("TIPO","STRING" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(184)).setAttribute("VALOR","Ingresos" );
      ((Element)v.get(182)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(185)).setAttribute("ID","3" );
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(186)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(186)).setAttribute("TIPO","STRING" );
      ((Element)v.get(186)).setAttribute("VALOR","04" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 185   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(187)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(187)).setAttribute("TIPO","STRING" );
      ((Element)v.get(187)).setAttribute("VALOR","Reingresos" );
      ((Element)v.get(185)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:185   */

      /* Empieza nodo:188 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(188)).setAttribute("ID","4" );
      ((Element)v.get(178)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(189)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(189)).setAttribute("TIPO","STRING" );
      ((Element)v.get(189)).setAttribute("VALOR","05" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 188   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(190)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(190)).setAttribute("TIPO","STRING" );
      ((Element)v.get(190)).setAttribute("VALOR","Egresos" );
      ((Element)v.get(188)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:188   */

      /* Empieza nodo:191 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(191)).setAttribute("ID","5" );
      ((Element)v.get(178)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(192)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(192)).setAttribute("TIPO","STRING" );
      ((Element)v.get(192)).setAttribute("VALOR","06" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(193)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(193)).setAttribute("TIPO","STRING" );
      ((Element)v.get(193)).setAttribute("VALOR","Número de órdenes" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(194)).setAttribute("ID","6" );
      ((Element)v.get(178)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(195)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(195)).setAttribute("TIPO","STRING" );
      ((Element)v.get(195)).setAttribute("VALOR","07" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 194   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(196)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(196)).setAttribute("TIPO","STRING" );
      ((Element)v.get(196)).setAttribute("VALOR","Número de Pedidos" );
      ((Element)v.get(194)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(197)).setAttribute("ID","7" );
      ((Element)v.get(178)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(198)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(198)).setAttribute("TIPO","STRING" );
      ((Element)v.get(198)).setAttribute("VALOR","08" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(199)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(199)).setAttribute("TIPO","STRING" );
      ((Element)v.get(199)).setAttribute("VALOR","Unidades Vendidas" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(200)).setAttribute("ID","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(201)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(201)).setAttribute("TIPO","STRING" );
      ((Element)v.get(201)).setAttribute("VALOR","09" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 200   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(202)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(202)).setAttribute("TIPO","STRING" );
      ((Element)v.get(202)).setAttribute("VALOR","Número de clientes" );
      ((Element)v.get(200)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:200   */

      /* Empieza nodo:203 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(203)).setAttribute("ID","9" );
      ((Element)v.get(178)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(204)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(204)).setAttribute("TIPO","STRING" );
      ((Element)v.get(204)).setAttribute("VALOR","10" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 203   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(205)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(205)).setAttribute("TIPO","STRING" );
      ((Element)v.get(205)).setAttribute("VALOR","Venta neta estadisticable" );
      ((Element)v.get(203)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:203   */

      /* Empieza nodo:206 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(206)).setAttribute("ID","10" );
      ((Element)v.get(178)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(207)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(207)).setAttribute("TIPO","STRING" );
      ((Element)v.get(207)).setAttribute("VALOR","11" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 206   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(208)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(208)).setAttribute("TIPO","STRING" );
      ((Element)v.get(208)).setAttribute("VALOR","Capitalización" );
      ((Element)v.get(206)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:206   */

      /* Empieza nodo:209 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(209)).setAttribute("ID","11" );
      ((Element)v.get(178)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(210)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(210)).setAttribute("TIPO","STRING" );
      ((Element)v.get(210)).setAttribute("VALOR","12" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 209   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(211)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(211)).setAttribute("TIPO","STRING" );
      ((Element)v.get(211)).setAttribute("VALOR","Actividad" );
      ((Element)v.get(209)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:209   */

      /* Empieza nodo:212 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(212)).setAttribute("ID","12" );
      ((Element)v.get(178)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(213)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(213)).setAttribute("TIPO","STRING" );
      ((Element)v.get(213)).setAttribute("VALOR","13" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(214)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(214)).setAttribute("TIPO","STRING" );
      ((Element)v.get(214)).setAttribute("VALOR","Precio promedio unitario" );
      ((Element)v.get(212)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(215)).setAttribute("ID","13" );
      ((Element)v.get(178)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(216)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(216)).setAttribute("TIPO","STRING" );
      ((Element)v.get(216)).setAttribute("VALOR","14" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 215   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(217)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(217)).setAttribute("TIPO","STRING" );
      ((Element)v.get(217)).setAttribute("VALOR","Promedio de venta por pedido" );
      ((Element)v.get(215)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(218)).setAttribute("ID","14" );
      ((Element)v.get(178)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(219)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(219)).setAttribute("TIPO","STRING" );
      ((Element)v.get(219)).setAttribute("VALOR","15" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 218   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(220)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(220)).setAttribute("TIPO","STRING" );
      ((Element)v.get(220)).setAttribute("VALOR","Promedio Unidades por Pedido" );
      ((Element)v.get(218)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:218   */

      /* Empieza nodo:221 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(221)).setAttribute("ID","15" );
      ((Element)v.get(178)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(222)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(222)).setAttribute("TIPO","STRING" );
      ((Element)v.get(222)).setAttribute("VALOR","16" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(223)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(223)).setAttribute("TIPO","STRING" );
      ((Element)v.get(223)).setAttribute("VALOR","Promedio órdenes por pedido" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(224)).setAttribute("ID","16" );
      ((Element)v.get(178)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(225)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(225)).setAttribute("TIPO","STRING" );
      ((Element)v.get(225)).setAttribute("VALOR","17" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 224   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(226)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(226)).setAttribute("TIPO","STRING" );
      ((Element)v.get(226)).setAttribute("VALOR","Retención" );
      ((Element)v.get(224)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:224   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:227 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:173   */

      /* Empieza nodo:229 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("colspan","4" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:39   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:232 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:32   */

      /* Empieza nodo:234 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
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
      v.add(doc.createElement("table"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(239)).setAttribute("border","0" );
      ((Element)v.get(239)).setAttribute("align","center" );
      ((Element)v.get(239)).setAttribute("cellspacing","0" );
      ((Element)v.get(239)).setAttribute("cellpadding","0" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("class","botonera" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(242)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(242)).setAttribute("ID","botonContenido" );
      ((Element)v.get(242)).setAttribute("tipo","html" );
      ((Element)v.get(242)).setAttribute("accion","generar('pdf')" );
      ((Element)v.get(242)).setAttribute("estado","false" );
      ((Element)v.get(242)).setAttribute("cod","2495" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 241   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(243)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(243)).setAttribute("ID","botonContenido" );
      ((Element)v.get(243)).setAttribute("tipo","html" );
      ((Element)v.get(243)).setAttribute("accion","generar('xls')" );
      ((Element)v.get(243)).setAttribute("estado","false" );
      ((Element)v.get(243)).setAttribute("cod","2526" );
      ((Element)v.get(243)).setAttribute("ontab","focaliza('Formulario.cbPais')" );
      ((Element)v.get(241)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:244 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","12" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:234   */

      /* Empieza nodo:246 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","12" );
      ((Element)v.get(247)).setAttribute("align","center" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","12" );
      ((Element)v.get(248)).setAttribute("height","12" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("width","756" );
      ((Element)v.get(246)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","12" );
      ((Element)v.get(246)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(252)).setAttribute("height","1" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:246   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:15   */


   }

}
