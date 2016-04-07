
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_analisis_concurso_recomendacion_generar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_analisis_concurso_recomendacion_generar" );
      ((Element)v.get(0)).setAttribute("cod","0866" );
      ((Element)v.get(0)).setAttribute("titulo","Generar informe análisis de concurso de recomendación" );
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
      v.add(doc.createTextNode("\r  \r   \r  \r  function onLoad(){\r    \r    configurarMenuSecundario('Formulario');\r    fMostrarMensajeError();\r    setearPais();\r    cambioPais();\r    focaliza('Formulario.cbPais');\r  \r  }\r\r    function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r  \r  function setearPais(){\r  \r    var pais = get('Formulario.pais');\r    \r    iSeleccionado = new Array();\r    iSeleccionado[0] = pais;\r    set('Formulario.cbPais',iSeleccionado);\r  \r  }\r  \r  \r  function fLimpiar(){\r	\r    var aCombo = new Array(new Array(\"\",\"\"));\r    \r    set_combo('Formulario.cbSubgerenciaVentas', aCombo, []);\r    set_combo('Formulario.cbRegion', aCombo, []);\r    set_combo('Formulario.cbZona', aCombo, []);\r    set_combo('Formulario.cbTipoOfertaExcluir',aCombo, []);\r  	set_combo('Formulario.cbNumConcurso', aCombo, []);\r    set_combo('Formulario.cbUnidadNegocio', aCombo, []);\r  	set_combo('Formulario.cbNegocio', aCombo, []);\r	\r    focaliza('Formulario.cbPais');\r    \r  }\r   \r\r  \r  function cambioPais(){\r    \r    opciones = new Array();\r    \r    pais = get('Formulario.cbPais');\r    idioma = get('Formulario.idioma');\r    \r    if(pais != ''){\r      \r      var arr = new Array();\r      arr[arr.length] = [\"oidPais\", pais];\r      \r      recargaCombo(\"Formulario.cbSubgerenciaVentas\", \"ZONRecargaSubgerenciaVentas\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr);\r      \r      var arr2 = new Array();\r      arr2[arr2.length] = [\"oidPais\", pais];\r      arr2[arr2.length] = [\"oidIdioma\", idioma];          \r      \r      recargaCombo(\"Formulario.cbUnidadNegocio\",\"MAEObtenerUnidadesNegocioPorPais\", \"es.indra.sicc.util.DTOBelcorp\",arr2);\r      recargaCombo(\"Formulario.cbNegocio\",\"MAEObtenerNegocioPorPais\", \"es.indra.sicc.util.DTOBelcorp\",arr2);\r      \r      var arrConcurso = new Array();\r      arrConcurso[arrConcurso.length] = [\"oidPais\", pais]; \r      arrConcurso[arrConcurso.length] = [\"oidAgrugacion\", \"0\"];      \r      \r      recargaCombo('Formulario.cbNumConcurso','INCObtenerConcursosREP', 'es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado',arrConcurso);\r    \r    }else{\r    \r      var aCombo = new Array(new Array(\"\",\"\"));\r      \r      set_combo('Formulario.cbSubgerenciaVentas',aCombo, []);\r      set_combo('Formulario.cbRegion',aCombo, []);\r      set_combo('Formulario.cbZona',aCombo, []);\r      set_combo('Formulario.cbNumConcurso',aCombo, []);\r      set_combo('Formulario.cbUnidadNegocio',aCombo, []);\r      set_combo('Formulario.cbNegocio',aCombo, []);\r      \r    }\r    \r  }\r\r\r  function cambioCanal() {\r  \r    canal  = get('Formulario.cbCanal');\r    idioma = get('Formulario.idioma');\r    \r    if (canal != ''){\r      \r      var arr = new Array();\r      arr[arr.length] = [\"oid\", canal];\r      arr[arr.length] = [\"oidIdioma\", idioma];          \r      recargaCombo(\"Formulario.cbTipoOfertaExcluir\",\"PREObtenerTiposOfertaPorCanal\", \"es.indra.sicc.util.DTOOID\",arr);\r    \r    }else{\r    \r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbTipoOfertaExcluir', aCombo, []);\r    \r    }\r    \r  }\r  \r  \r  function cambioSGV(){\r    \r    opciones = new Array();\r    \r    set_combo('Formulario.cbRegion',opciones);\r    set_combo('Formulario.cbZona',opciones);\r    \r    \r    combo_add('Formulario.cbRegion', '', '');\r    \r    var sgv = get('Formulario.cbSubgerenciaVentas','V');\r    \r    for(var k=0;k<ListaRegiones.datos.longitud;k++) {\r      for(var y=0;y<sgv.length;y++){\r        if (ListaRegiones.datos.ij(k,0) == sgv[y]){\r          combo_add('Formulario.cbRegion',ListaRegiones.datos.ij(k,1),ListaRegiones.datos.ij(k,2));\r        }\r      }\r    }\r  \r  }\r  \r\r  function cambioRegion(){\r    \r    opciones = new Array();\r    set_combo('Formulario.cbZona',opciones);                      \r    \r    var region = get('Formulario.cbRegion','V');\r    combo_add('Formulario.cbZona', '', '');\r         \r    for(var k=0;k<ListaZonas.datos.longitud;k++) {\r      for(var y=0;y<region.length;y++){\r        if (ListaZonas.datos.ij(k,1) == region[y]){     \r          combo_add('Formulario.cbZona',ListaZonas.datos.ij(k,0),ListaZonas.datos.ij(k,2));\r        }\r      }\r    }\r  }\r\r\r  function generar(formato){\r      \r    if(sicc_validaciones_generales()){\r         \r      var a = new Object();\r      a.accion = 'generar';\r           \r      a.pais = get('Formulario.cbPais');  \r      a.marca = get('Formulario.cbMarca');\r      a.canal = get('Formulario.cbCanal');\r      a.subgerenciaVentas = quitarItemVacio(get('Formulario.cbSubgerenciaVentas'));\r      a.region = quitarItemVacio(get('Formulario.cbRegion'));\r      a.zona = quitarItemVacio(get('Formulario.cbZona'));\r      a.tipoVenta = get('Formulario.cbTipoVenta');\r  	  a.tipoOfertaExcluir = quitarItemVacio(get('Formulario.cbTipoOfertaExcluir'));\r      a.numeroConcurso = quitarItemVacio(get('Formulario.cbNumConcurso'));\r      a.monedaAnalisis = get('Formulario.cbMonedaAnalisis');\r  	  a.unidadNegocio = quitarItemVacio(get('Formulario.cbUnidadNegocio'));\r      a.negocio = quitarItemVacio(get('Formulario.cbNegocio'));\r      a.nroRecomendadas = quitarItemVacio(get('Formulario.cbNumRecomendadas'));\r		\r      a.formato = formato;\r      \r      mostrarModalSICC('INCAnalisisConcurso','generar', a);\r      \r    }\r    \r  }\r\r\r  \r  "));
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
      ((Element)v.get(10)).setAttribute("name","cbTipoVenta" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1622" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbNumConcurso" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1604" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbMonedaAnalisis" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","2709" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbNumRecomendadas" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","2705" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */
      /* Termina nodo:4   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","idioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","pais" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(22)).setAttribute("nombre","capa1" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","750" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(36)).setAttribute("class","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","legend" );
      ((Element)v.get(37)).setAttribute("cod","00275" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","100%" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","left" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("colspan","4" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblPais" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","5" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:45   */

      /* Empieza nodo:52 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(52));

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
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(56)).setAttribute("nombre","cbPais" );
      ((Element)v.get(56)).setAttribute("size","1" );
      ((Element)v.get(56)).setAttribute("multiple","N" );
      ((Element)v.get(56)).setAttribute("valorinicial","" );
      ((Element)v.get(56)).setAttribute("textoinicial","" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(56)).setAttribute("req","S" );
      ((Element)v.get(56)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarInforme');" );
      ((Element)v.get(56)).setAttribute("onchange","cambioPais()" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:52   */

      /* Empieza nodo:60 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("colspan","4" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:63 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","left" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","6" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","7" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(66)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:66   */

      /* Empieza nodo:77 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(81)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(81)).setAttribute("size","1" );
      ((Element)v.get(81)).setAttribute("multiple","N" );
      ((Element)v.get(81)).setAttribute("valorinicial","" );
      ((Element)v.get(81)).setAttribute("textoinicial","" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("req","S" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(86)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(86)).setAttribute("size","1" );
      ((Element)v.get(86)).setAttribute("multiple","N" );
      ((Element)v.get(86)).setAttribute("valorinicial","" );
      ((Element)v.get(86)).setAttribute("textoinicial","" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).setAttribute("req","S" );
      ((Element)v.get(86)).setAttribute("onchange","cambioCanal()" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(77)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:77   */

      /* Empieza nodo:90 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("colspan","4" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:93 / Elemento padre: 38   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(95)).setAttribute("border","0" );
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("cellpadding","0" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(100)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","124" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","25" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","109" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(96)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:96   */

      /* Empieza nodo:107 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(111)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(111)).setAttribute("size","5" );
      ((Element)v.get(111)).setAttribute("multiple","S" );
      ((Element)v.get(111)).setAttribute("valorinicial","" );
      ((Element)v.get(111)).setAttribute("textoinicial","" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("onchange","cambioSGV()" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:113 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","25" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(116)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(116)).setAttribute("size","5" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("multiple","S" );
      ((Element)v.get(116)).setAttribute("valorinicial","" );
      ((Element)v.get(116)).setAttribute("textoinicial","" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).setAttribute("req","N" );
      ((Element)v.get(116)).setAttribute("onchange","cambioRegion()" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:107   */

      /* Empieza nodo:120 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("colspan","4" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:123 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("table"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblZona" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","143" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","1622" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:126   */

      /* Empieza nodo:137 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
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
   }

   private void getXML540(Document doc) {
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbZona" );
      ((Element)v.get(141)).setAttribute("size","5" );
      ((Element)v.get(141)).setAttribute("multiple","S" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).setAttribute("valign","top" );
      ((Element)v.get(137)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(146)).setAttribute("size","1" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("valorinicial","3" );
      ((Element)v.get(146)).setAttribute("textoinicial","Venta catálogo" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("req","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(148)).setAttribute("ID","2" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(149)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(149)).setAttribute("TIPO","STRING" );
      ((Element)v.get(149)).setAttribute("VALOR","2" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 148   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(150)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(150)).setAttribute("TIPO","STRING" );
      ((Element)v.get(150)).setAttribute("VALOR","Venta neta" );
      ((Element)v.get(148)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:148   */

      /* Empieza nodo:151 / Elemento padre: 147   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(151)).setAttribute("ID","3" );
      ((Element)v.get(147)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(152)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(152)).setAttribute("TIPO","STRING" );
      ((Element)v.get(152)).setAttribute("VALOR","1" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 151   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(153)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(153)).setAttribute("TIPO","STRING" );
      ((Element)v.get(153)).setAttribute("VALOR","Venta factura" );
      ((Element)v.get(151)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:151   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:154 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(137)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:137   */

      /* Empieza nodo:156 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(156));

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
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:159 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(159));

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
   }

   private void getXML630(Document doc) {
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
      ((Element)v.get(166)).setAttribute("nombre","lblTipoOfertaExcluir" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","2704" );
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
      ((Element)v.get(170)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","1604" );
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
      ((Element)v.get(174)).setAttribute("nombre","lblMonedaAnalisis" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","2709" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:162   */

      /* Empieza nodo:177 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(181)).setAttribute("nombre","cbTipoOfertaExcluir" );
      ((Element)v.get(181)).setAttribute("size","5" );
      ((Element)v.get(181)).setAttribute("multiple","S" );
      ((Element)v.get(181)).setAttribute("valorinicial","" );
      ((Element)v.get(181)).setAttribute("textoinicial","" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("nowrap","nowrap" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(186)).setAttribute("nombre","cbNumConcurso" );
      ((Element)v.get(186)).setAttribute("size","5" );
      ((Element)v.get(186)).setAttribute("multiple","S" );
      ((Element)v.get(186)).setAttribute("valorinicial","" );
      ((Element)v.get(186)).setAttribute("textoinicial","" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("req","S" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:188 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(190)).setAttribute("valign","top" );
      ((Element)v.get(177)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(191)).setAttribute("nombre","cbMonedaAnalisis" );
      ((Element)v.get(191)).setAttribute("size","1" );
      ((Element)v.get(191)).setAttribute("multiple","N" );
      ((Element)v.get(191)).setAttribute("valorinicial","" );
      ((Element)v.get(191)).setAttribute("textoinicial","" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("req","S" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:193 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:177   */

      /* Empieza nodo:195 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("colspan","4" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:198 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("table"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(200)).setAttribute("border","0" );
      ((Element)v.get(200)).setAttribute("align","left" );
      ((Element)v.get(200)).setAttribute("cellspacing","0" );
      ((Element)v.get(200)).setAttribute("cellpadding","0" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(205)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(205)).setAttribute("alto","13" );
      ((Element)v.get(205)).setAttribute("filas","1" );
      ((Element)v.get(205)).setAttribute("id","datosTitle" );
      ((Element)v.get(205)).setAttribute("cod","1338" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","588" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","25" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblNumRecomendadas" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","2705" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:201   */

      /* Empieza nodo:216 / Elemento padre: 200   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(200)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(219)).setAttribute("valign","bottom" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(220)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(220)).setAttribute("size","5" );
      ((Element)v.get(220)).setAttribute("multiple","S" );
      ((Element)v.get(220)).setAttribute("valorinicial","" );
      ((Element)v.get(220)).setAttribute("textoinicial","" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("req","N" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:222 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(224)).setAttribute("valign","bottom" );
      ((Element)v.get(216)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(225)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(225)).setAttribute("size","5" );
      ((Element)v.get(225)).setAttribute("multiple","S" );
      ((Element)v.get(225)).setAttribute("valorinicial","" );
      ((Element)v.get(225)).setAttribute("textoinicial","" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).setAttribute("req","N" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:227 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(216)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(230)).setAttribute("nombre","cbNumRecomendadas" );
      ((Element)v.get(230)).setAttribute("size","5" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(230)).setAttribute("multiple","S" );
      ((Element)v.get(230)).setAttribute("valorinicial","1" );
      ((Element)v.get(230)).setAttribute("textoinicial","1" );
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
      ((Element)v.get(230)).setAttribute("req","S" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(232)).setAttribute("ID","2" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(233)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(233)).setAttribute("TIPO","STRING" );
      ((Element)v.get(233)).setAttribute("VALOR","2" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 232   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(234)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(234)).setAttribute("TIPO","STRING" );
      ((Element)v.get(234)).setAttribute("VALOR","2" );
      ((Element)v.get(232)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:232   */

      /* Empieza nodo:235 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(235)).setAttribute("ID","3" );
      ((Element)v.get(231)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(236)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(236)).setAttribute("TIPO","STRING" );
      ((Element)v.get(236)).setAttribute("VALOR","3" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 235   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(237)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(237)).setAttribute("TIPO","STRING" );
      ((Element)v.get(237)).setAttribute("VALOR","3" );
      ((Element)v.get(235)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:235   */

      /* Empieza nodo:238 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(238)).setAttribute("ID","4" );
      ((Element)v.get(231)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(239)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(239)).setAttribute("TIPO","STRING" );
      ((Element)v.get(239)).setAttribute("VALOR","4" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 238   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(240)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(240)).setAttribute("TIPO","STRING" );
      ((Element)v.get(240)).setAttribute("VALOR","4" );
      ((Element)v.get(238)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:238   */

      /* Empieza nodo:241 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(241)).setAttribute("ID","5" );
      ((Element)v.get(231)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(242)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(242)).setAttribute("TIPO","STRING" );
      ((Element)v.get(242)).setAttribute("VALOR","5" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 241   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(243)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(243)).setAttribute("TIPO","STRING" );
      ((Element)v.get(243)).setAttribute("VALOR","5" );
      ((Element)v.get(241)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:241   */

      /* Empieza nodo:244 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(244)).setAttribute("ID","6" );
      ((Element)v.get(231)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(245)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(245)).setAttribute("TIPO","STRING" );
      ((Element)v.get(245)).setAttribute("VALOR","6" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 244   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(246)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(246)).setAttribute("TIPO","STRING" );
      ((Element)v.get(246)).setAttribute("VALOR","6" );
      ((Element)v.get(244)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:244   */

      /* Empieza nodo:247 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(247)).setAttribute("ID","7" );
      ((Element)v.get(231)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(248)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(248)).setAttribute("TIPO","STRING" );
      ((Element)v.get(248)).setAttribute("VALOR","7" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 247   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(249)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(249)).setAttribute("TIPO","STRING" );
      ((Element)v.get(249)).setAttribute("VALOR","7" );
      ((Element)v.get(247)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:247   */

      /* Empieza nodo:250 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(250)).setAttribute("ID","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(251)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(251)).setAttribute("TIPO","STRING" );
      ((Element)v.get(251)).setAttribute("VALOR","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 250   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(252)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(252)).setAttribute("TIPO","STRING" );
      ((Element)v.get(252)).setAttribute("VALOR","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:250   */

      /* Empieza nodo:253 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(253)).setAttribute("ID","9" );
      ((Element)v.get(231)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(254)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(254)).setAttribute("TIPO","STRING" );
      ((Element)v.get(254)).setAttribute("VALOR","9" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 253   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(255)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(255)).setAttribute("TIPO","STRING" );
      ((Element)v.get(255)).setAttribute("VALOR","9" );
      ((Element)v.get(253)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:253   */

      /* Empieza nodo:256 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(256)).setAttribute("ID","10" );
      ((Element)v.get(231)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(257)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(257)).setAttribute("TIPO","STRING" );
      ((Element)v.get(257)).setAttribute("VALOR","10" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 256   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(258)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(258)).setAttribute("TIPO","STRING" );
      ((Element)v.get(258)).setAttribute("VALOR","10" );
      ((Element)v.get(256)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:256   */

      /* Empieza nodo:259 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(259)).setAttribute("ID","11" );
      ((Element)v.get(231)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(260)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(260)).setAttribute("TIPO","STRING" );
      ((Element)v.get(260)).setAttribute("VALOR","11" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(261)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(261)).setAttribute("TIPO","STRING" );
      ((Element)v.get(261)).setAttribute("VALOR","11" );
      ((Element)v.get(259)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:259   */

      /* Empieza nodo:262 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(262)).setAttribute("ID","12" );
      ((Element)v.get(231)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(263)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(263)).setAttribute("TIPO","STRING" );
      ((Element)v.get(263)).setAttribute("VALOR","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 262   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(264)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(264)).setAttribute("TIPO","STRING" );
      ((Element)v.get(264)).setAttribute("VALOR","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:262   */

      /* Empieza nodo:265 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(265)).setAttribute("ID","13" );
      ((Element)v.get(231)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(266)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(266)).setAttribute("TIPO","STRING" );
      ((Element)v.get(266)).setAttribute("VALOR","13" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 265   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(267)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(267)).setAttribute("TIPO","STRING" );
      ((Element)v.get(267)).setAttribute("VALOR","13" );
      ((Element)v.get(265)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:265   */

      /* Empieza nodo:268 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(268)).setAttribute("ID","14" );
      ((Element)v.get(231)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(269)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(269)).setAttribute("TIPO","STRING" );
      ((Element)v.get(269)).setAttribute("VALOR","14" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 268   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(270)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(270)).setAttribute("TIPO","STRING" );
      ((Element)v.get(270)).setAttribute("VALOR","14" );
      ((Element)v.get(268)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:268   */

      /* Empieza nodo:271 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(271)).setAttribute("ID","15" );
      ((Element)v.get(231)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(272)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(272)).setAttribute("TIPO","STRING" );
      ((Element)v.get(272)).setAttribute("VALOR","15" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 271   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(273)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(273)).setAttribute("TIPO","STRING" );
      ((Element)v.get(273)).setAttribute("VALOR","15" );
      ((Element)v.get(271)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:271   */

      /* Empieza nodo:274 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(274)).setAttribute("ID","16" );
      ((Element)v.get(231)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(275)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(275)).setAttribute("TIPO","STRING" );
      ((Element)v.get(275)).setAttribute("VALOR","16" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 274   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(276)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(276)).setAttribute("TIPO","STRING" );
      ((Element)v.get(276)).setAttribute("VALOR","16" );
      ((Element)v.get(274)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(277)).setAttribute("ID","17" );
      ((Element)v.get(231)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(278)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(278)).setAttribute("TIPO","STRING" );
      ((Element)v.get(278)).setAttribute("VALOR","17" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 277   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(279)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(279)).setAttribute("TIPO","STRING" );
      ((Element)v.get(279)).setAttribute("VALOR","17" );
      ((Element)v.get(277)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:277   */

      /* Empieza nodo:280 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(280)).setAttribute("ID","18" );
      ((Element)v.get(231)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(281)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(281)).setAttribute("TIPO","STRING" );
      ((Element)v.get(281)).setAttribute("VALOR","18" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 280   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(282)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(282)).setAttribute("TIPO","STRING" );
      ((Element)v.get(282)).setAttribute("VALOR","18" );
      ((Element)v.get(280)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(283)).setAttribute("ID","19" );
      ((Element)v.get(231)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(284)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(284)).setAttribute("TIPO","STRING" );
      ((Element)v.get(284)).setAttribute("VALOR","19" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 283   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(285)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(285)).setAttribute("TIPO","STRING" );
      ((Element)v.get(285)).setAttribute("VALOR","19" );
      ((Element)v.get(283)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:283   */

      /* Empieza nodo:286 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(286)).setAttribute("ID","20" );
      ((Element)v.get(231)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(287)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(287)).setAttribute("TIPO","STRING" );
      ((Element)v.get(287)).setAttribute("VALOR","20" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 286   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(288)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(288)).setAttribute("TIPO","STRING" );
      ((Element)v.get(288)).setAttribute("VALOR","20" );
      ((Element)v.get(286)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:286   */

      /* Empieza nodo:289 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(289)).setAttribute("ID","21" );
      ((Element)v.get(231)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(290)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(290)).setAttribute("TIPO","STRING" );
      ((Element)v.get(290)).setAttribute("VALOR","21" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 289   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(291)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(291)).setAttribute("TIPO","STRING" );
      ((Element)v.get(291)).setAttribute("VALOR","21" );
      ((Element)v.get(289)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:289   */

      /* Empieza nodo:292 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(292)).setAttribute("ID","22" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(231)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(293)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(293)).setAttribute("TIPO","STRING" );
      ((Element)v.get(293)).setAttribute("VALOR","22" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 292   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(294)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(294)).setAttribute("TIPO","STRING" );
      ((Element)v.get(294)).setAttribute("VALOR","22" );
      ((Element)v.get(292)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(295)).setAttribute("ID","23" );
      ((Element)v.get(231)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(296)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(296)).setAttribute("TIPO","STRING" );
      ((Element)v.get(296)).setAttribute("VALOR","23" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 295   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(297)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(297)).setAttribute("TIPO","STRING" );
      ((Element)v.get(297)).setAttribute("VALOR","23" );
      ((Element)v.get(295)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:295   */

      /* Empieza nodo:298 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(298)).setAttribute("ID","24" );
      ((Element)v.get(231)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(299)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(299)).setAttribute("TIPO","STRING" );
      ((Element)v.get(299)).setAttribute("VALOR","24" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 298   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(300)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(300)).setAttribute("TIPO","STRING" );
      ((Element)v.get(300)).setAttribute("VALOR","24" );
      ((Element)v.get(298)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:298   */

      /* Empieza nodo:301 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(301)).setAttribute("ID","25" );
      ((Element)v.get(231)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(302)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(302)).setAttribute("TIPO","STRING" );
      ((Element)v.get(302)).setAttribute("VALOR","25" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 301   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(303)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(303)).setAttribute("TIPO","STRING" );
      ((Element)v.get(303)).setAttribute("VALOR","25" );
      ((Element)v.get(301)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(304)).setAttribute("ID","26" );
      ((Element)v.get(231)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(305)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(305)).setAttribute("TIPO","STRING" );
      ((Element)v.get(305)).setAttribute("VALOR","26" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 304   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(306)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(306)).setAttribute("TIPO","STRING" );
      ((Element)v.get(306)).setAttribute("VALOR","26" );
      ((Element)v.get(304)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:304   */

      /* Empieza nodo:307 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(307)).setAttribute("ID","27" );
      ((Element)v.get(231)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(308)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(308)).setAttribute("TIPO","STRING" );
      ((Element)v.get(308)).setAttribute("VALOR","27" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 307   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(309)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(309)).setAttribute("TIPO","STRING" );
      ((Element)v.get(309)).setAttribute("VALOR","27" );
      ((Element)v.get(307)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:307   */

      /* Empieza nodo:310 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(310)).setAttribute("ID","28" );
      ((Element)v.get(231)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(311)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(311)).setAttribute("TIPO","STRING" );
      ((Element)v.get(311)).setAttribute("VALOR","28" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 310   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(312)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(312)).setAttribute("TIPO","STRING" );
      ((Element)v.get(312)).setAttribute("VALOR","28" );
      ((Element)v.get(310)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:310   */

      /* Empieza nodo:313 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(313)).setAttribute("ID","29" );
      ((Element)v.get(231)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(314)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(314)).setAttribute("TIPO","STRING" );
      ((Element)v.get(314)).setAttribute("VALOR","29" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 313   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(315)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(315)).setAttribute("TIPO","STRING" );
      ((Element)v.get(315)).setAttribute("VALOR","29" );
      ((Element)v.get(313)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:313   */

      /* Empieza nodo:316 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(316)).setAttribute("ID","30" );
      ((Element)v.get(231)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(317)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(317)).setAttribute("TIPO","STRING" );
      ((Element)v.get(317)).setAttribute("VALOR","30" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 316   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(318)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(318)).setAttribute("TIPO","STRING" );
      ((Element)v.get(318)).setAttribute("VALOR","30" );
      ((Element)v.get(316)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:316   */

      /* Empieza nodo:319 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(319)).setAttribute("ID","31" );
      ((Element)v.get(231)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(320)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(320)).setAttribute("TIPO","STRING" );
      ((Element)v.get(320)).setAttribute("VALOR","31" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 319   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(321)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(321)).setAttribute("TIPO","STRING" );
      ((Element)v.get(321)).setAttribute("VALOR","31" );
      ((Element)v.get(319)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:319   */

      /* Empieza nodo:322 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(322)).setAttribute("ID","32" );
      ((Element)v.get(231)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(323)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(323)).setAttribute("TIPO","STRING" );
      ((Element)v.get(323)).setAttribute("VALOR","32" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 322   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(324)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(324)).setAttribute("TIPO","STRING" );
      ((Element)v.get(324)).setAttribute("VALOR","32" );
      ((Element)v.get(322)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:322   */

      /* Empieza nodo:325 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(325)).setAttribute("ID","33" );
      ((Element)v.get(231)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(326)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(326)).setAttribute("TIPO","STRING" );
      ((Element)v.get(326)).setAttribute("VALOR","33" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 325   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(327)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(327)).setAttribute("TIPO","STRING" );
      ((Element)v.get(327)).setAttribute("VALOR","33" );
      ((Element)v.get(325)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(328)).setAttribute("ID","34" );
      ((Element)v.get(231)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(329)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(329)).setAttribute("TIPO","STRING" );
      ((Element)v.get(329)).setAttribute("VALOR","34" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(330)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(330)).setAttribute("TIPO","STRING" );
      ((Element)v.get(330)).setAttribute("VALOR","34" );
      ((Element)v.get(328)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:328   */

      /* Empieza nodo:331 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(331)).setAttribute("ID","35" );
      ((Element)v.get(231)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(332)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(332)).setAttribute("TIPO","STRING" );
      ((Element)v.get(332)).setAttribute("VALOR","35" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 331   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(333)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(333)).setAttribute("TIPO","STRING" );
      ((Element)v.get(333)).setAttribute("VALOR","35" );
      ((Element)v.get(331)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:331   */

      /* Empieza nodo:334 / Elemento padre: 231   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(334)).setAttribute("ID","36" );
      ((Element)v.get(231)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(335)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(335)).setAttribute("TIPO","STRING" );
      ((Element)v.get(335)).setAttribute("VALOR","36" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 334   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(336)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(336)).setAttribute("TIPO","STRING" );
      ((Element)v.get(336)).setAttribute("VALOR","36" );
      ((Element)v.get(334)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:334   */

      /* Empieza nodo:337 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(337)).setAttribute("ID","37" );
      ((Element)v.get(231)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(338)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(338)).setAttribute("TIPO","STRING" );
      ((Element)v.get(338)).setAttribute("VALOR","37" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 337   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(339)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(339)).setAttribute("TIPO","STRING" );
      ((Element)v.get(339)).setAttribute("VALOR","37" );
      ((Element)v.get(337)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:337   */

      /* Empieza nodo:340 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(340)).setAttribute("ID","38" );
      ((Element)v.get(231)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(341)).setAttribute("TIPO","STRING" );
      ((Element)v.get(341)).setAttribute("VALOR","38" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 340   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(342)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(342)).setAttribute("TIPO","STRING" );
      ((Element)v.get(342)).setAttribute("VALOR","38" );
      ((Element)v.get(340)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:340   */

      /* Empieza nodo:343 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(343)).setAttribute("ID","39" );
      ((Element)v.get(231)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(344)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(344)).setAttribute("TIPO","STRING" );
      ((Element)v.get(344)).setAttribute("VALOR","39" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 343   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(345)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(345)).setAttribute("TIPO","STRING" );
      ((Element)v.get(345)).setAttribute("VALOR","39" );
      ((Element)v.get(343)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:343   */

      /* Empieza nodo:346 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(346)).setAttribute("ID","40" );
      ((Element)v.get(231)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(347)).setAttribute("TIPO","STRING" );
      ((Element)v.get(347)).setAttribute("VALOR","40" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 346   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(348)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(348)).setAttribute("TIPO","STRING" );
      ((Element)v.get(348)).setAttribute("VALOR","40" );
      ((Element)v.get(346)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:346   */

      /* Empieza nodo:349 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(349)).setAttribute("ID","41" );
      ((Element)v.get(231)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(350)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(350)).setAttribute("TIPO","STRING" );
      ((Element)v.get(350)).setAttribute("VALOR","41" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 349   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(351)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(351)).setAttribute("TIPO","STRING" );
      ((Element)v.get(351)).setAttribute("VALOR","41" );
      ((Element)v.get(349)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:349   */

      /* Empieza nodo:352 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(352)).setAttribute("ID","42" );
      ((Element)v.get(231)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(353)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","42" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(354)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(354)).setAttribute("TIPO","STRING" );
      ((Element)v.get(354)).setAttribute("VALOR","42" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(352)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:352   */

      /* Empieza nodo:355 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(355)).setAttribute("ID","43" );
      ((Element)v.get(231)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(356)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(356)).setAttribute("TIPO","STRING" );
      ((Element)v.get(356)).setAttribute("VALOR","43" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 355   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(357)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(357)).setAttribute("TIPO","STRING" );
      ((Element)v.get(357)).setAttribute("VALOR","43" );
      ((Element)v.get(355)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:355   */

      /* Empieza nodo:358 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(358)).setAttribute("ID","44" );
      ((Element)v.get(231)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(359)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(359)).setAttribute("TIPO","STRING" );
      ((Element)v.get(359)).setAttribute("VALOR","44" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 358   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(360)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(360)).setAttribute("TIPO","STRING" );
      ((Element)v.get(360)).setAttribute("VALOR","44" );
      ((Element)v.get(358)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:358   */

      /* Empieza nodo:361 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(361)).setAttribute("ID","45" );
      ((Element)v.get(231)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(362)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(362)).setAttribute("TIPO","STRING" );
      ((Element)v.get(362)).setAttribute("VALOR","45" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 361   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(363)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(363)).setAttribute("TIPO","STRING" );
      ((Element)v.get(363)).setAttribute("VALOR","45" );
      ((Element)v.get(361)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:361   */

      /* Empieza nodo:364 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(364)).setAttribute("ID","46" );
      ((Element)v.get(231)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(365)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(365)).setAttribute("TIPO","STRING" );
      ((Element)v.get(365)).setAttribute("VALOR","46" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 364   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(366)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(366)).setAttribute("TIPO","STRING" );
      ((Element)v.get(366)).setAttribute("VALOR","46" );
      ((Element)v.get(364)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:364   */

      /* Empieza nodo:367 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(367)).setAttribute("ID","47" );
      ((Element)v.get(231)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(368)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(368)).setAttribute("TIPO","STRING" );
      ((Element)v.get(368)).setAttribute("VALOR","47" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 367   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(369)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(369)).setAttribute("TIPO","STRING" );
      ((Element)v.get(369)).setAttribute("VALOR","47" );
      ((Element)v.get(367)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:367   */

      /* Empieza nodo:370 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(370)).setAttribute("ID","48" );
      ((Element)v.get(231)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(371)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(371)).setAttribute("TIPO","STRING" );
      ((Element)v.get(371)).setAttribute("VALOR","48" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 370   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(372)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(372)).setAttribute("TIPO","STRING" );
      ((Element)v.get(372)).setAttribute("VALOR","48" );
      ((Element)v.get(370)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:370   */

      /* Empieza nodo:373 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(373)).setAttribute("ID","49" );
      ((Element)v.get(231)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(374)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(374)).setAttribute("TIPO","STRING" );
      ((Element)v.get(374)).setAttribute("VALOR","49" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 373   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(375)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(375)).setAttribute("TIPO","STRING" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(375)).setAttribute("VALOR","49" );
      ((Element)v.get(373)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:373   */

      /* Empieza nodo:376 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(376)).setAttribute("ID","50" );
      ((Element)v.get(231)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(377)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(377)).setAttribute("TIPO","STRING" );
      ((Element)v.get(377)).setAttribute("VALOR","50" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 376   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(378)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(378)).setAttribute("TIPO","STRING" );
      ((Element)v.get(378)).setAttribute("VALOR","50" );
      ((Element)v.get(376)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:376   */

      /* Empieza nodo:379 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(379)).setAttribute("ID","51" );
      ((Element)v.get(231)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(380)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(380)).setAttribute("TIPO","STRING" );
      ((Element)v.get(380)).setAttribute("VALOR","51" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 379   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(381)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(381)).setAttribute("TIPO","STRING" );
      ((Element)v.get(381)).setAttribute("VALOR","51" );
      ((Element)v.get(379)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:379   */

      /* Empieza nodo:382 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(382)).setAttribute("ID","52" );
      ((Element)v.get(231)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(383)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(383)).setAttribute("TIPO","STRING" );
      ((Element)v.get(383)).setAttribute("VALOR","52" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 382   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(384)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(384)).setAttribute("TIPO","STRING" );
      ((Element)v.get(384)).setAttribute("VALOR","52" );
      ((Element)v.get(382)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:382   */

      /* Empieza nodo:385 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(385)).setAttribute("ID","53" );
      ((Element)v.get(231)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(386)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(386)).setAttribute("TIPO","STRING" );
      ((Element)v.get(386)).setAttribute("VALOR","53" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 385   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(387)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(387)).setAttribute("TIPO","STRING" );
      ((Element)v.get(387)).setAttribute("VALOR","53" );
      ((Element)v.get(385)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:385   */

      /* Empieza nodo:388 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(388)).setAttribute("ID","54" );
      ((Element)v.get(231)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(389)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(389)).setAttribute("TIPO","STRING" );
      ((Element)v.get(389)).setAttribute("VALOR","54" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 388   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(390)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(390)).setAttribute("TIPO","STRING" );
      ((Element)v.get(390)).setAttribute("VALOR","54" );
      ((Element)v.get(388)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:388   */

      /* Empieza nodo:391 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(391)).setAttribute("ID","55" );
      ((Element)v.get(231)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(392)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(392)).setAttribute("TIPO","STRING" );
      ((Element)v.get(392)).setAttribute("VALOR","55" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */

      /* Empieza nodo:393 / Elemento padre: 391   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(393)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(393)).setAttribute("TIPO","STRING" );
      ((Element)v.get(393)).setAttribute("VALOR","55" );
      ((Element)v.get(391)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:391   */

      /* Empieza nodo:394 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(394)).setAttribute("ID","56" );
      ((Element)v.get(231)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(395)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(395)).setAttribute("TIPO","STRING" );
      ((Element)v.get(395)).setAttribute("VALOR","56" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 394   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(396)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(396)).setAttribute("TIPO","STRING" );
      ((Element)v.get(396)).setAttribute("VALOR","56" );
      ((Element)v.get(394)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:394   */

      /* Empieza nodo:397 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(397)).setAttribute("ID","57" );
      ((Element)v.get(231)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(398)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(398)).setAttribute("TIPO","STRING" );
      ((Element)v.get(398)).setAttribute("VALOR","57" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 397   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(399)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(399)).setAttribute("TIPO","STRING" );
      ((Element)v.get(399)).setAttribute("VALOR","57" );
      ((Element)v.get(397)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:397   */

      /* Empieza nodo:400 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(400)).setAttribute("ID","58" );
      ((Element)v.get(231)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(401)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(401)).setAttribute("TIPO","STRING" );
      ((Element)v.get(401)).setAttribute("VALOR","58" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 400   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(402)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(402)).setAttribute("TIPO","STRING" );
      ((Element)v.get(402)).setAttribute("VALOR","58" );
      ((Element)v.get(400)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:400   */

      /* Empieza nodo:403 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(403)).setAttribute("ID","59" );
      ((Element)v.get(231)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(404)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(404)).setAttribute("TIPO","STRING" );
      ((Element)v.get(404)).setAttribute("VALOR","59" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(405)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(405)).setAttribute("TIPO","STRING" );
      ((Element)v.get(405)).setAttribute("VALOR","59" );
      ((Element)v.get(403)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:403   */

      /* Empieza nodo:406 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(406)).setAttribute("ID","60" );
      ((Element)v.get(231)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(407)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(407)).setAttribute("TIPO","STRING" );
      ((Element)v.get(407)).setAttribute("VALOR","60" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(408)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(408)).setAttribute("TIPO","STRING" );
      ((Element)v.get(408)).setAttribute("VALOR","60" );
      ((Element)v.get(406)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:406   */

      /* Empieza nodo:409 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(409)).setAttribute("ID","61" );
      ((Element)v.get(231)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(410)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(410)).setAttribute("TIPO","STRING" );
      ((Element)v.get(410)).setAttribute("VALOR","61" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(411)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(411)).setAttribute("TIPO","STRING" );
      ((Element)v.get(411)).setAttribute("VALOR","61" );
      ((Element)v.get(409)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(412)).setAttribute("ID","62" );
      ((Element)v.get(231)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(413)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(413)).setAttribute("TIPO","STRING" );
      ((Element)v.get(413)).setAttribute("VALOR","62" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(414)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(414)).setAttribute("TIPO","STRING" );
      ((Element)v.get(414)).setAttribute("VALOR","62" );
      ((Element)v.get(412)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(415)).setAttribute("ID","63" );
      ((Element)v.get(231)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","63" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(417)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(417)).setAttribute("TIPO","STRING" );
      ((Element)v.get(417)).setAttribute("VALOR","63" );
      ((Element)v.get(415)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:415   */

      /* Empieza nodo:418 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(418)).setAttribute("ID","64" );
      ((Element)v.get(231)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","64" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(420)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(420)).setAttribute("TIPO","STRING" );
      ((Element)v.get(420)).setAttribute("VALOR","64" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:418   */

      /* Empieza nodo:421 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).setAttribute("ID","65" );
      ((Element)v.get(231)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","65" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(423)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(423)).setAttribute("TIPO","STRING" );
      ((Element)v.get(423)).setAttribute("VALOR","65" );
      ((Element)v.get(421)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:421   */

      /* Empieza nodo:424 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(424)).setAttribute("ID","66" );
      ((Element)v.get(231)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","66" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(426)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(426)).setAttribute("TIPO","STRING" );
      ((Element)v.get(426)).setAttribute("VALOR","66" );
      ((Element)v.get(424)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:424   */

      /* Empieza nodo:427 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(427)).setAttribute("ID","67" );
      ((Element)v.get(231)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(428)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(428)).setAttribute("TIPO","STRING" );
      ((Element)v.get(428)).setAttribute("VALOR","67" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 427   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(429)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(429)).setAttribute("TIPO","STRING" );
      ((Element)v.get(429)).setAttribute("VALOR","67" );
      ((Element)v.get(427)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:427   */

      /* Empieza nodo:430 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(430)).setAttribute("ID","68" );
      ((Element)v.get(231)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(431)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(431)).setAttribute("TIPO","STRING" );
      ((Element)v.get(431)).setAttribute("VALOR","68" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 430   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(432)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(432)).setAttribute("TIPO","STRING" );
      ((Element)v.get(432)).setAttribute("VALOR","68" );
      ((Element)v.get(430)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:430   */

      /* Empieza nodo:433 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(433)).setAttribute("ID","69" );
      ((Element)v.get(231)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(434)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(434)).setAttribute("TIPO","STRING" );
      ((Element)v.get(434)).setAttribute("VALOR","69" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */

      /* Empieza nodo:435 / Elemento padre: 433   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(435)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(435)).setAttribute("TIPO","STRING" );
      ((Element)v.get(435)).setAttribute("VALOR","69" );
      ((Element)v.get(433)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:433   */

      /* Empieza nodo:436 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(436)).setAttribute("ID","70" );
      ((Element)v.get(231)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(437)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(437)).setAttribute("TIPO","STRING" );
      ((Element)v.get(437)).setAttribute("VALOR","70" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 436   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(438)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(438)).setAttribute("TIPO","STRING" );
      ((Element)v.get(438)).setAttribute("VALOR","70" );
      ((Element)v.get(436)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:436   */

      /* Empieza nodo:439 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(439)).setAttribute("ID","71" );
      ((Element)v.get(231)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(440)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(440)).setAttribute("TIPO","STRING" );
      ((Element)v.get(440)).setAttribute("VALOR","71" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */

      /* Empieza nodo:441 / Elemento padre: 439   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(441)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(441)).setAttribute("TIPO","STRING" );
      ((Element)v.get(441)).setAttribute("VALOR","71" );
      ((Element)v.get(439)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:439   */

      /* Empieza nodo:442 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(442)).setAttribute("ID","72" );
      ((Element)v.get(231)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(443)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(443)).setAttribute("TIPO","STRING" );
      ((Element)v.get(443)).setAttribute("VALOR","72" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */

      /* Empieza nodo:444 / Elemento padre: 442   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(444)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(444)).setAttribute("TIPO","STRING" );
      ((Element)v.get(444)).setAttribute("VALOR","72" );
      ((Element)v.get(442)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:442   */

      /* Empieza nodo:445 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(445)).setAttribute("ID","73" );
      ((Element)v.get(231)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(446)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(446)).setAttribute("TIPO","STRING" );
      ((Element)v.get(446)).setAttribute("VALOR","73" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */

      /* Empieza nodo:447 / Elemento padre: 445   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(447)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(447)).setAttribute("TIPO","STRING" );
      ((Element)v.get(447)).setAttribute("VALOR","73" );
      ((Element)v.get(445)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:445   */

      /* Empieza nodo:448 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(448)).setAttribute("ID","74" );
      ((Element)v.get(231)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(449)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(449)).setAttribute("TIPO","STRING" );
      ((Element)v.get(449)).setAttribute("VALOR","74" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 448   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(450)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(450)).setAttribute("TIPO","STRING" );
      ((Element)v.get(450)).setAttribute("VALOR","74" );
      ((Element)v.get(448)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:448   */

      /* Empieza nodo:451 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(451)).setAttribute("ID","75" );
      ((Element)v.get(231)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(452)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(452)).setAttribute("TIPO","STRING" );
      ((Element)v.get(452)).setAttribute("VALOR","75" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 451   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(453)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(453)).setAttribute("TIPO","STRING" );
      ((Element)v.get(453)).setAttribute("VALOR","75" );
      ((Element)v.get(451)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:451   */

      /* Empieza nodo:454 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(454)).setAttribute("ID","76" );
      ((Element)v.get(231)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(455)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(455)).setAttribute("TIPO","STRING" );
      ((Element)v.get(455)).setAttribute("VALOR","76" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 454   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(456)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(456)).setAttribute("TIPO","STRING" );
      ((Element)v.get(456)).setAttribute("VALOR","76" );
      ((Element)v.get(454)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:454   */

      /* Empieza nodo:457 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(457)).setAttribute("ID","77" );
      ((Element)v.get(231)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(458)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(458)).setAttribute("TIPO","STRING" );
      ((Element)v.get(458)).setAttribute("VALOR","77" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 457   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(459)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(459)).setAttribute("TIPO","STRING" );
      ((Element)v.get(459)).setAttribute("VALOR","77" );
      ((Element)v.get(457)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:457   */

      /* Empieza nodo:460 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(460)).setAttribute("ID","78" );
      ((Element)v.get(231)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(461)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(461)).setAttribute("TIPO","STRING" );
      ((Element)v.get(461)).setAttribute("VALOR","78" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 460   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(462)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(462)).setAttribute("TIPO","STRING" );
      ((Element)v.get(462)).setAttribute("VALOR","78" );
      ((Element)v.get(460)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:460   */

      /* Empieza nodo:463 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(463)).setAttribute("ID","79" );
      ((Element)v.get(231)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(464)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(464)).setAttribute("TIPO","STRING" );
      ((Element)v.get(464)).setAttribute("VALOR","79" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 463   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(465)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(465)).setAttribute("TIPO","STRING" );
      ((Element)v.get(465)).setAttribute("VALOR","79" );
      ((Element)v.get(463)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:463   */

      /* Empieza nodo:466 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(466)).setAttribute("ID","80" );
      ((Element)v.get(231)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(467)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(467)).setAttribute("TIPO","STRING" );
      ((Element)v.get(467)).setAttribute("VALOR","80" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 466   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(468)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(468)).setAttribute("TIPO","STRING" );
      ((Element)v.get(468)).setAttribute("VALOR","80" );
      ((Element)v.get(466)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:466   */

      /* Empieza nodo:469 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(469)).setAttribute("ID","81" );
      ((Element)v.get(231)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(470)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(470)).setAttribute("TIPO","STRING" );
      ((Element)v.get(470)).setAttribute("VALOR","81" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 469   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(471)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(471)).setAttribute("TIPO","STRING" );
      ((Element)v.get(471)).setAttribute("VALOR","81" );
      ((Element)v.get(469)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:469   */

      /* Empieza nodo:472 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(472)).setAttribute("ID","82" );
      ((Element)v.get(231)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(473)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(473)).setAttribute("TIPO","STRING" );
      ((Element)v.get(473)).setAttribute("VALOR","82" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 472   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(474)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(474)).setAttribute("TIPO","STRING" );
      ((Element)v.get(474)).setAttribute("VALOR","82" );
      ((Element)v.get(472)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:472   */

      /* Empieza nodo:475 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(475)).setAttribute("ID","83" );
      ((Element)v.get(231)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(476)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(476)).setAttribute("TIPO","STRING" );
      ((Element)v.get(476)).setAttribute("VALOR","83" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 475   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(477)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(477)).setAttribute("TIPO","STRING" );
      ((Element)v.get(477)).setAttribute("VALOR","83" );
      ((Element)v.get(475)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:475   */

      /* Empieza nodo:478 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(478)).setAttribute("ID","84" );
      ((Element)v.get(231)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(479)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(479)).setAttribute("TIPO","STRING" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(479)).setAttribute("VALOR","84" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 478   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(480)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(480)).setAttribute("TIPO","STRING" );
      ((Element)v.get(480)).setAttribute("VALOR","84" );
      ((Element)v.get(478)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:478   */

      /* Empieza nodo:481 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(481)).setAttribute("ID","85" );
      ((Element)v.get(231)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(482)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(482)).setAttribute("TIPO","STRING" );
      ((Element)v.get(482)).setAttribute("VALOR","85" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 481   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(483)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(483)).setAttribute("TIPO","STRING" );
      ((Element)v.get(483)).setAttribute("VALOR","85" );
      ((Element)v.get(481)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:481   */

      /* Empieza nodo:484 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(484)).setAttribute("ID","86" );
      ((Element)v.get(231)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(485)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(485)).setAttribute("TIPO","STRING" );
      ((Element)v.get(485)).setAttribute("VALOR","86" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(486)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(486)).setAttribute("TIPO","STRING" );
      ((Element)v.get(486)).setAttribute("VALOR","86" );
      ((Element)v.get(484)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:484   */

      /* Empieza nodo:487 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(487)).setAttribute("ID","87" );
      ((Element)v.get(231)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(488)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(488)).setAttribute("TIPO","STRING" );
      ((Element)v.get(488)).setAttribute("VALOR","87" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 487   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(489)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(489)).setAttribute("TIPO","STRING" );
      ((Element)v.get(489)).setAttribute("VALOR","87" );
      ((Element)v.get(487)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:487   */

      /* Empieza nodo:490 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(490)).setAttribute("ID","88" );
      ((Element)v.get(231)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(491)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(491)).setAttribute("TIPO","STRING" );
      ((Element)v.get(491)).setAttribute("VALOR","88" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 490   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(492)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(492)).setAttribute("TIPO","STRING" );
      ((Element)v.get(492)).setAttribute("VALOR","88" );
      ((Element)v.get(490)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:490   */

      /* Empieza nodo:493 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(493)).setAttribute("ID","89" );
      ((Element)v.get(231)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(494)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(494)).setAttribute("TIPO","STRING" );
      ((Element)v.get(494)).setAttribute("VALOR","89" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 493   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(495)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(495)).setAttribute("TIPO","STRING" );
      ((Element)v.get(495)).setAttribute("VALOR","89" );
      ((Element)v.get(493)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:493   */

      /* Empieza nodo:496 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(496)).setAttribute("ID","90" );
      ((Element)v.get(231)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(497)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(497)).setAttribute("TIPO","STRING" );
      ((Element)v.get(497)).setAttribute("VALOR","90" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 496   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(498)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(498)).setAttribute("TIPO","STRING" );
      ((Element)v.get(498)).setAttribute("VALOR","90" );
      ((Element)v.get(496)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:496   */

      /* Empieza nodo:499 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(499)).setAttribute("ID","91" );
      ((Element)v.get(231)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(500)).setAttribute("NOMBRE","CODIGO" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(500)).setAttribute("TIPO","STRING" );
      ((Element)v.get(500)).setAttribute("VALOR","91" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 499   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(501)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(501)).setAttribute("TIPO","STRING" );
      ((Element)v.get(501)).setAttribute("VALOR","91" );
      ((Element)v.get(499)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:499   */

      /* Empieza nodo:502 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(502)).setAttribute("ID","92" );
      ((Element)v.get(231)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(503)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(503)).setAttribute("TIPO","STRING" );
      ((Element)v.get(503)).setAttribute("VALOR","92" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 502   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(504)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(504)).setAttribute("TIPO","STRING" );
      ((Element)v.get(504)).setAttribute("VALOR","92" );
      ((Element)v.get(502)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:502   */

      /* Empieza nodo:505 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(505)).setAttribute("ID","93" );
      ((Element)v.get(231)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(506)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(506)).setAttribute("TIPO","STRING" );
      ((Element)v.get(506)).setAttribute("VALOR","93" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 505   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(507)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(507)).setAttribute("TIPO","STRING" );
      ((Element)v.get(507)).setAttribute("VALOR","93" );
      ((Element)v.get(505)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:505   */

      /* Empieza nodo:508 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(508)).setAttribute("ID","94" );
      ((Element)v.get(231)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(509)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(509)).setAttribute("TIPO","STRING" );
      ((Element)v.get(509)).setAttribute("VALOR","94" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 508   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(510)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(510)).setAttribute("TIPO","STRING" );
      ((Element)v.get(510)).setAttribute("VALOR","94" );
      ((Element)v.get(508)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:508   */

      /* Empieza nodo:511 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(511)).setAttribute("ID","95" );
      ((Element)v.get(231)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(512)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(512)).setAttribute("TIPO","STRING" );
      ((Element)v.get(512)).setAttribute("VALOR","95" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 511   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(513)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(513)).setAttribute("TIPO","STRING" );
      ((Element)v.get(513)).setAttribute("VALOR","95" );
      ((Element)v.get(511)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:511   */

      /* Empieza nodo:514 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(514)).setAttribute("ID","96" );
      ((Element)v.get(231)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(515)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(515)).setAttribute("TIPO","STRING" );
      ((Element)v.get(515)).setAttribute("VALOR","96" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 514   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(516)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(516)).setAttribute("TIPO","STRING" );
      ((Element)v.get(516)).setAttribute("VALOR","96" );
      ((Element)v.get(514)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:514   */

      /* Empieza nodo:517 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(517)).setAttribute("ID","97" );
      ((Element)v.get(231)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(518)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(518)).setAttribute("TIPO","STRING" );
      ((Element)v.get(518)).setAttribute("VALOR","97" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */

      /* Empieza nodo:519 / Elemento padre: 517   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(519)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(519)).setAttribute("TIPO","STRING" );
      ((Element)v.get(519)).setAttribute("VALOR","97" );
      ((Element)v.get(517)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:517   */

      /* Empieza nodo:520 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(520)).setAttribute("ID","98" );
      ((Element)v.get(231)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(521)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(521)).setAttribute("TIPO","STRING" );
      ((Element)v.get(521)).setAttribute("VALOR","98" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 520   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(522)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(522)).setAttribute("TIPO","STRING" );
      ((Element)v.get(522)).setAttribute("VALOR","98" );
      ((Element)v.get(520)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:520   */

      /* Empieza nodo:523 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(523)).setAttribute("ID","99" );
      ((Element)v.get(231)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(524)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(524)).setAttribute("TIPO","STRING" );
      ((Element)v.get(524)).setAttribute("VALOR","99" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 523   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(525)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(525)).setAttribute("TIPO","STRING" );
      ((Element)v.get(525)).setAttribute("VALOR","99" );
      ((Element)v.get(523)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:523   */

      /* Empieza nodo:526 / Elemento padre: 231   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(526)).setAttribute("ID","100" );
      ((Element)v.get(231)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(527)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(527)).setAttribute("TIPO","STRING" );
      ((Element)v.get(527)).setAttribute("VALOR","100" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 526   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(528)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(528)).setAttribute("TIPO","STRING" );
      ((Element)v.get(528)).setAttribute("VALOR","100" );
      ((Element)v.get(526)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:526   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:529 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(529)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:216   */

      /* Empieza nodo:531 / Elemento padre: 200   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(200)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).setAttribute("colspan","4" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","8" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:534 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:31   */

      /* Empieza nodo:536 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("table"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(541)).setAttribute("border","0" );
      ((Element)v.get(541)).setAttribute("align","center" );
      ((Element)v.get(541)).setAttribute("cellspacing","0" );
      ((Element)v.get(541)).setAttribute("cellpadding","0" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("td"));
      ((Element)v.get(543)).setAttribute("class","botonera" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(544)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(544)).setAttribute("ID","botonContenido" );
      ((Element)v.get(544)).setAttribute("tipo","html" );
      ((Element)v.get(544)).setAttribute("accion","generar('pdf')" );
      ((Element)v.get(544)).setAttribute("estado","false" );
      ((Element)v.get(544)).setAttribute("cod","2495" );
      ((Element)v.get(544)).setAttribute("ontab","focaliza('Formulario.cbPais')" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:545 / Elemento padre: 536   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(546)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).setAttribute("width","8" );
      ((Element)v.get(546)).setAttribute("height","12" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:536   */

      /* Empieza nodo:547 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).setAttribute("width","12" );
      ((Element)v.get(548)).setAttribute("align","center" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","12" );
      ((Element)v.get(549)).setAttribute("height","12" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).setAttribute("width","756" );
      ((Element)v.get(547)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(551)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:552 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).setAttribute("width","12" );
      ((Element)v.get(547)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(553)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).setAttribute("width","12" );
      ((Element)v.get(553)).setAttribute("height","1" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:547   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:14   */


   }

}
