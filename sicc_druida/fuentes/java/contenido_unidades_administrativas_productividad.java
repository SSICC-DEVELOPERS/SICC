
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_unidades_administrativas_productividad  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_unidades_administrativas_productividad" );
      ((Element)v.get(0)).setAttribute("cod","0736" );
      ((Element)v.get(0)).setAttribute("titulo","Productividad por unidades administrativas" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      focaliza('Formulario.cbMarca');\r   }\r   function generar(){\r      \r      if(sicc_validaciones_generales()){\r   \r        var a = new Object();\r        a.accion = 'generar';\r        a.marca = get('Formulario.cbMarca');\r        a.canal = get('Formulario.cbCanal');\r        a.marcaDesc = get('Formulario.cbMarca', 'T');\r        a.canalDesc = get('Formulario.cbCanal', 'T');\r        a.sgv = get('Formulario.cbSubgerenciaVentas');\r        a.region = get('Formulario.cbRegion');\r        a.zona = get('Formulario.cbZona');\r        a.seccion = get('Formulario.cbSeccion');\r        a.territorio = get('Formulario.cbTerritorio');\r        a.periodoDesde = get('Formulario.cbPeriodoDesde');\r        a.periodoHasta = get('Formulario.cbPeriodoHasta');\r        a.tipoInforme = get('Formulario.cbTipoInforme');       \r        mostrarModalSICC('LPProductividadUA','generar', a); \r      }\r\r   }\r   function recolectarParametros(){\r      \r      set('Formulario.marca', get('Formulario.cbMarca') );\r      set('Formulario.canal', get('Formulario.cbCanal'));\r      set('Formulario.sgv', get('Formulario.cbSubgerenciaVentas'));\r      set('Formulario.region', get('Formulario.cbRegion'));\r      set('Formulario.zona', get('Formulario.cbZona'));\r      set('Formulario.seccion', get('Formulario.cbSeccion'));\r      set('Formulario.territorio', get('Formulario.cbTerritorio'));\r      set('Formulario.periodoDesde', get('Formulario.cbPeriodoDesde'));\r      set('Formulario.periodoHasta', get('Formulario.cbPeriodoHasta'));\r      set('Formulario.tipoInforme', get('Formulario.cbTipoInforme'));\r    \r  \r   }\r   \r   \r   function recargaSGV(){\r      var marca = get(\"Formulario.cbMarca\");\r      var canal = get(\"Formulario.cbCanal\");\r      var pais = get(\"Formulario.pais\");\r           \r      var arr = new Array();\r      var arr2 = new Array();\r            \r      arr[arr.length] = [\"oidPais\", pais]; \r      arr[arr.length] = [\"marca\", marca];\r      arr[arr.length] = [\"canal\", canal];\r          \r      arr2[arr2.length] = [\"oidMarca\", marca]; \r      arr2[arr2.length] = [\"oidCanal\", canal]; \r      \r      if ( marca != \"\" && canal != \"\"){\r         recargaCombo(\"Formulario.cbSubgerenciaVentas\",\"ZONRecargaSubgerenciaVentas\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2);\r         recargaCombo(\"Formulario.cbPeriodoDesde\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r         recargaCombo(\"Formulario.cbPeriodoHasta\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r      }else{\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);\r          set_combo('Formulario.cbPeriodoDesde', aCombo, []);\r          set_combo('Formulario.cbPeriodoHasta', aCombo, []);\r          limpiar('1');  \r            \r      }\r   }\r\r   function onchangeSgv(){\r      limpiar('1');   \r      recargaCombo(\"Formulario.cbRegion\",\"ZONRecargaRegiones\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",[[\"oidSGV\", get('Formulario.cbSubgerenciaVentas')]]);        \r   \r   }\r    function onchange_Region(){\r        limpiar('2');\r        if(get('Formulario.cbRegion') != ''){\r             recargaCombo('Formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',[[ \"oidRegion\", get('Formulario.cbRegion') ]] );\r        }\r    }\r\r   function onchange_Zona(){\r		limpiar('3');\r		opciones = new Array();\r		set_combo('Formulario.cbSeccion',opciones);\r		combo_add('Formulario.cbSeccion', '', '');\r		var zonas = quitarItemVacio(get('Formulario.cbZona'));\r		var pais = get(\"Formulario.pais\");\r		var zonaConc = new String();\r		for(i=0;i<zonas.length;i++){\r			zonaConc += zonas[i] + \"x\";\r		}\r		zonaConc = zonaConc.substring(0, zonaConc.length-1);\r		var arr = new Array();\r		arr[arr.length] = ['cadena', zonaConc];\r		arr[arr.length] = ['oidPais', pais]\r		if(zonaConc != ''){\r			recargaCombo(\"Formulario.cbSeccion\", \"REPRecargaSecciones\", \"es.indra.sicc.util.DTOString\",arr);\r		}\r      /*if(get('Formulario.cbZona') != ''){\r      \r          recargaCombo('Formulario.cbSeccion', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',[[ \"oidZona\", get('Formulario.cbZona') ]] );  \r      }*/\r   }\r   \r\r function onchange_Seccion(){\r		limpiar('4');\r		opciones = new Array();\r		set_combo('Formulario.cbTerritorio',opciones);\r		combo_add('Formulario.cbTerritorio', '', '');\r		var secciones = quitarItemVacio(get('Formulario.cbSeccion'));\r		var pais = get('Formulario.cbPais');\r		var seccionConc = new String();\r		for(i=0;i<secciones.length;i++){\r			seccionConc += secciones[i] + \"x\";\r		}\r		seccionConc = seccionConc.substring(0, seccionConc.length-1);\r		var arr = new Array();\r		arr[arr.length] = ['cadena', seccionConc];\r		arr[arr.length] = ['oidPais', pais]\r		if(seccionConc != ''){\r			recargaCombo(\"Formulario.cbTerritorio\", \"REPRecargaTerrPorSecciones\", \"es.indra.sicc.util.DTOString\",arr);\r		}     \r      /*if(get('Formulario.cbSeccion') != ''){\r         recargaCombo('Formulario.cbTerritorio', 'ZONRecargaTerritorios', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',[[ \"oidSeccion\", get('Formulario.cbSeccion') ]] );  \r      }*/\r   }\r   \r\r  function limpiar(param){\r     var aCombo = new Array(new Array(\"\",\"\"));\r     \r     if(param == '1'){\r        set_combo('Formulario.cbRegion', aCombo, []);\r        set_combo('Formulario.cbZona', aCombo, []);\r        set_combo('Formulario.cbSeccion', aCombo, []);\r        set_combo('Formulario.cbTerritorio', aCombo, []);\r     }\r     \r     if(param == '2'){\r        set_combo('Formulario.cbZona', aCombo, []);\r        set_combo('Formulario.cbSeccion', aCombo, []);\r        set_combo('Formulario.cbTerritorio', aCombo, []);\r     }\r     \r     if(param == '3'){\r        set_combo('Formulario.cbSeccion', aCombo, []);\r        set_combo('Formulario.cbTerritorio', aCombo, []);\r     }\r     \r     if(param == '4'){\r        set_combo('Formulario.cbTerritorio', aCombo, []);\r     }\r  \r  \r  }\r  function fLimpiar(){\r     var aCombo = new Array(new Array(\"\",\"\"));\r     set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);\r     limpiar('1') ;\r  }\r\r  function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r         if (elemento[k] != ''){ 			 \r            elementoADevolver[elementoADevolver.length] = elemento[k];\r         }\r      }\r        \r      return elementoADevolver;\r   }\r   \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1175" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbTipoInforme" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","2496" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:6   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","pais" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","marca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","canal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","sgv" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","region" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","zona" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","seccion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","territorio" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","periodoDesde" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","periodoHasta" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","tipoInforme" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(29)).setAttribute("nombre","capa" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));

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
      ((Element)v.get(44)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","legend" );
      ((Element)v.get(44)).setAttribute("cod","00275" );
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
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","100%" );
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
      ((Element)v.get(50)).setAttribute("colspan","4" );
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
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","5" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:52   */

      /* Empieza nodo:59 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(59));

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
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:59   */

      /* Empieza nodo:66 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("colspan","4" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:69 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("align","left" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","6" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","7" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:72   */

      /* Empieza nodo:83 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(83));

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
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(87)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(87)).setAttribute("size","1" );
      ((Element)v.get(87)).setAttribute("multiple","N" );
      ((Element)v.get(87)).setAttribute("valorinicial","" );
      ((Element)v.get(87)).setAttribute("textoinicial","" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("req","S" );
      ((Element)v.get(87)).setAttribute("onchange","recargaSGV();" );
      ((Element)v.get(87)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarInforme')" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(92)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(92)).setAttribute("size","1" );
      ((Element)v.get(92)).setAttribute("multiple","N" );
      ((Element)v.get(92)).setAttribute("valorinicial","" );
      ((Element)v.get(92)).setAttribute("textoinicial","" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(92)).setAttribute("req","S" );
      ((Element)v.get(92)).setAttribute("onchange","recargaSGV();" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:83   */

      /* Empieza nodo:96 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("colspan","4" );
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
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:99 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","100%" );
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
      ((Element)v.get(106)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","124" );
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
      ((Element)v.get(110)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("cod","109" );
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
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(117)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(117)).setAttribute("size","1" );
      ((Element)v.get(117)).setAttribute("multiple","N" );
      ((Element)v.get(117)).setAttribute("valorinicial","" );
      ((Element)v.get(117)).setAttribute("textoinicial","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("onchange","onchangeSgv();" );
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
      ((Element)v.get(122)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(122)).setAttribute("size","1" );
      ((Element)v.get(122)).setAttribute("multiple","N" );
      ((Element)v.get(122)).setAttribute("valorinicial","" );
      ((Element)v.get(122)).setAttribute("textoinicial","" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("onchange","onchange_Region();" );
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
      ((Element)v.get(127)).setAttribute("colspan","4" );
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

      /* Empieza nodo:129 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("align","left" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblZona" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","143" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","25" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","112" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:132   */

      /* Empieza nodo:143 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(147)).setAttribute("nombre","cbZona" );
      ((Element)v.get(147)).setAttribute("size","1" );
      ((Element)v.get(147)).setAttribute("multiple","N" );
      ((Element)v.get(147)).setAttribute("valorinicial","" );
      ((Element)v.get(147)).setAttribute("textoinicial","" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("onchange","onchange_Zona();" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:149 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","25" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(152)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(152)).setAttribute("size","1" );
      ((Element)v.get(152)).setAttribute("multiple","N" );
      ((Element)v.get(152)).setAttribute("valorinicial","" );
      ((Element)v.get(152)).setAttribute("textoinicial","" );
      ((Element)v.get(152)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).setAttribute("onchange","onchange_Seccion();" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(143)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:143   */

      /* Empieza nodo:156 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("colspan","4" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:159 / Elemento padre: 45   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("table"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblTerritorio" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","126" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","1175" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","1176" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblTipoInforme" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("valor","" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","2496" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:162   */

      /* Empieza nodo:181 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("valign","bottom" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(185)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(185)).setAttribute("size","1" );
      ((Element)v.get(185)).setAttribute("multiple","N" );
      ((Element)v.get(185)).setAttribute("valorinicial","" );
      ((Element)v.get(185)).setAttribute("textoinicial","" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(181)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(190)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(190)).setAttribute("size","1" );
      ((Element)v.get(190)).setAttribute("multiple","N" );
      ((Element)v.get(190)).setAttribute("valorinicial","" );
      ((Element)v.get(190)).setAttribute("textoinicial","" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("req","S" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:192 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).setAttribute("valign","bottom" );
      ((Element)v.get(181)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(195)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(195)).setAttribute("size","1" );
      ((Element)v.get(195)).setAttribute("multiple","N" );
      ((Element)v.get(195)).setAttribute("valorinicial","" );
      ((Element)v.get(195)).setAttribute("textoinicial","" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","25" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(181)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(200)).setAttribute("nombre","cbTipoInforme" );
      ((Element)v.get(200)).setAttribute("size","1" );
      ((Element)v.get(200)).setAttribute("multiple","N" );
      ((Element)v.get(200)).setAttribute("valorinicial","1" );
      ((Element)v.get(200)).setAttribute("textoinicial","Completo" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("req","S" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(202)).setAttribute("id","1" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(203)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(203)).setAttribute("TIPO","STRING" );
      ((Element)v.get(203)).setAttribute("VALOR","2" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(204)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(204)).setAttribute("TIPO","STRING" );
      ((Element)v.get(204)).setAttribute("VALOR","Resumen" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:205 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(181)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:181   */

      /* Empieza nodo:207 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("colspan","4" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:45   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:210 / Elemento padre: 38   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:38   */

      /* Empieza nodo:212 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("align","center" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("class","botonera" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(220)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(220)).setAttribute("ID","botonContenido" );
      ((Element)v.get(220)).setAttribute("tipo","html" );
      ((Element)v.get(220)).setAttribute("accion","generar();" );
      ((Element)v.get(220)).setAttribute("estado","false" );
      ((Element)v.get(220)).setAttribute("cod","2495" );
      ((Element)v.get(220)).setAttribute("ontab","focaliza('Formulario.cbMarca')" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","12" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:212   */

      /* Empieza nodo:223 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("align","center" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(225)).setAttribute("height","12" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","756" );
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(229)).setAttribute("height","1" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:223   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:11   */


   }

}
