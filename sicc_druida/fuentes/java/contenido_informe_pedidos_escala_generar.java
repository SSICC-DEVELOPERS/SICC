
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_pedidos_escala_generar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_pedidos_escala_generar" );
      ((Element)v.get(0)).setAttribute("cod","0855" );
      ((Element)v.get(0)).setAttribute("titulo","Generar informe pedidos a escala" );
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
      v.add(doc.createTextNode("\r\r \r   \r  function onLoad(){\r    \r    configurarMenuSecundario('Formulario');\r    fMostrarMensajeError();\r    set('Formulario.txtAnio',get('Formulario.anio'));\r    setearPais();\r    focaliza('Formulario.cbPais');\r    \r  }\r\r    function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r\r  function generar(formato){\r      \r    if(sicc_validaciones_generales()){\r      \r      var a = new Object();\r      a.accion = 'generar';\r        \r      a.pais = get('Formulario.cbPais');\r      a.marca = get('Formulario.cbMarca');\r      a.marcaDesc = get('Formulario.cbMarca','T');\r      a.canal = get('Formulario.cbCanal');\r      a.subgerenciaVentas = quitarItemVacio(get('Formulario.cbSubgerenciaVenta'));\r      a.subgerenciaVentasDesc = quitarItemVacio(get('Formulario.cbSubgerenciaVenta','T'));\r      a.region = quitarItemVacio(get('Formulario.cbRegion'));\r      a.regionDesc = quitarItemVacio(get('Formulario.cbRegion','T'));\r      a.zona = quitarItemVacio(get('Formulario.cbZona'));\r      a.zonaDesc = quitarItemVacio(get('Formulario.cbZona','T'));\r      a.tipoVenta = get('Formulario.cbTipoVenta');\r      a.tipoVentaDesc = get('Formulario.cbTipoVenta','T');\r      a.tipoOfertaExcluir = quitarItemVacio(get('Formulario.cbTiposOferta'));\r      a.tipoCliente = quitarItemVacio(get('Formulario.cbTipoCliente'));\r      \r      a.subtipoCliente = quitarItemVacio(get('Formulario.cbSubtipoCliente'));\r      a.tipoClasificacion = quitarItemVacio(get('Formulario.cbTipoClasificacionCliente'));\r      a.clasificacion = quitarItemVacio(get('Formulario.cbClasificacionCliente'));\r      \r      a.percentil = quitarItemVacio(get('Formulario.cbPercentil'));\r      a.moneda = get('Formulario.cbMoneda');\r      a.monedaDesc = get('Formulario.cbMoneda','T');\r      a.unidadNegocio = quitarItemVacio(get('Formulario.cbUnidadNegocio'));\r      a.negocio = quitarItemVacio(get('Formulario.cbNegocio'));\r      a.anio = get('Formulario.txtAnio');\r      \r      a.formato = formato;\r      \r      mostrarModalSICC('INCPedidosEscala','generar', a);  \r      \r    }\r    \r  }\r\r\r  function fLimpiar(){\r  \r    var aCombo = new Array(new Array(\"\",\"\"));\r     \r    set_combo('Formulario.cbSubgerenciaVenta', aCombo, []); \r    set_combo('Formulario.cbRegion', aCombo, []); \r    set_combo('Formulario.cbZona', aCombo, []); \r    \r    set_combo('Formulario.cbTiposOferta', aCombo, []); \r    \r    set_combo('Formulario.cbSubtipoCliente', aCombo, []);\r    set_combo('Formulario.cbTipoClasificacionCliente', aCombo, []);\r    set_combo('Formulario.cbClasificacionCliente', aCombo, []);\r    \r    set_combo('Formulario.cbUnidadNegocio', aCombo, []); \r    set_combo('Formulario.cbNegocio', aCombo, []);           \r    \r    focaliza('Formulario.cbPais');\r    \r    set('Formulario.txtAnio',get('Formulario.anio'));\r\r  }\r      \r\r  function onchangeMarcaCanal(){\r        \r    marca  = get('Formulario.cbMarca');\r    canal  = get('Formulario.cbCanal');\r    pais   = get('Formulario.cbPais');\r    idioma = get('Formulario.idioma');\r    \r    var aCombo = new Array(new Array(\"\",\"\"));\r    \r    if(marca != '' && canal != '' && pais != ''){\r    \r      var arr2 = new Array();\r      \r      arr2[arr2.length] = [\"oidPais\", pais]; \r      arr2[arr2.length] = [\"oidMarca\", marca];\r      arr2[arr2.length] = [\"oidCanal\", canal];\r      \r      var arrUnidadNegocio = new Array();\r      arrUnidadNegocio[arrUnidadNegocio.length] = [\"oidPais\", pais];\r      arrUnidadNegocio[arrUnidadNegocio.length] = [\"oidIdioma\", idioma];          \r      \r      recargaCombo(\"Formulario.cbSubgerenciaVenta\",\"ZONRecargaSubgerenciaVentas\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2); \r      recargaCombo(\"Formulario.cbUnidadNegocio\",\"MAEObtenerUnidadesNegocioPorPais\", \"es.indra.sicc.util.DTOBelcorp\",arrUnidadNegocio);\r      recargaCombo(\"Formulario.cbNegocio\",\"MAEObtenerNegocioPorPais\", \"es.indra.sicc.util.DTOBelcorp\",arrUnidadNegocio);           \r      \r    }else{\r      \r      set_combo('Formulario.cbSubgerenciaVenta', aCombo, []); \r      set_combo('Formulario.cbUnidadNegocio', aCombo, []); \r      set_combo('Formulario.cbNegocio', aCombo, []);           \r    }\r  \r    set_combo('Formulario.cbRegion', aCombo, []);\r    set_combo('Formulario.cbZona', aCombo, []);\r\r  } \r\r\r  function onchangeCanal() {\r    \r    canal  = get('Formulario.cbCanal');\r    idioma = get('Formulario.idioma');\r    \r    var arr = new Array();\r    arr[arr.length] = [\"oid\", canal];\r    arr[arr.length] = [\"oidIdioma\", idioma];          \r    \r    recargaCombo(\"Formulario.cbTiposOferta\",\"PREObtenerTiposOfertaPorCanal\", \"es.indra.sicc.util.DTOOID\",arr);           \r\r  }\r\r\r  function cambioSubgerencia(){\r  \r    opciones = new Array();\r    set_combo('Formulario.cbRegion',opciones);                      \r    set_combo('Formulario.cbZona',opciones);                      \r    \r    var subGerencia = get('Formulario.cbSubgerenciaVenta','V');\r    \r    combo_add('Formulario.cbRegion', '', '');\r    \r    for(var k=0;k<lstRegiones.datos.longitud;k++) {\r      for(var y=0;y<subGerencia.length;y++){\r        if (lstRegiones.datos.ij(k,0) == subGerencia[y]){     \r          combo_add('Formulario.cbRegion',lstRegiones.datos.ij(k,1),lstRegiones.datos.ij(k,2));\r        }\r      }\r    }\r   \r  }\r\r\r  function cambioRegion(){\r    \r    opciones = new Array();\r    set_combo('Formulario.cbZona',opciones);                      \r    \r    var region = get('Formulario.cbRegion','V');\r    combo_add('Formulario.cbZona', '', '');\r    \r    for(var k=0;k<lstZonas.datos.longitud;k++) {\r      for(var y=0;y<region.length;y++){\r        if (lstZonas.datos.ij(k,1) == region[y]){     \r          combo_add('Formulario.cbZona',lstZonas.datos.ij(k,0),lstZonas.datos.ij(k,2));\r        }\r      }\r    }\r    \r  }\r\r\r  function cambioTipo(){\r         \r     opciones = new Array();\r     set_combo('Formulario.cbSubtipoCliente',opciones);                      \r     set_combo('Formulario.cbTipoClasificacionCliente',opciones);                      \r     set_combo('Formulario.cbClasificacionCliente',opciones);                      \r     tipo = get('Formulario.cbTipoCliente','V');\r     combo_add('Formulario.cbSubtipoCliente', '', '');\r       \r      for(var k=0;k<lstSubtipo.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){\r          if (lstSubtipo.datos.ij(k,1) == tipo[y]){ 			 \r            combo_add('Formulario.cbSubtipoCliente',lstSubtipo.datos.ij(k,0),lstSubtipo.datos.ij(k,2));\r          }\r        }\r      }\r  \r  }\r\r\r  function cambioSubtipo(){\r  \r    opciones = new Array();\r    set_combo('Formulario.cbTipoClasificacionCliente',opciones); \r    set_combo('Formulario.cbClasificacionCliente',opciones);      \r    var subTipo = get('Formulario.cbSubtipoCliente','V');\r    combo_add('Formulario.cbTipoClasificacionCliente', '', '');\r    \r    for(var k=0;k<lstTipoClasificacion.datos.longitud;k++) {\r      for(var y=0;y<subTipo.length;y++){\r        if (lstTipoClasificacion.datos.ij(k,1) == subTipo[y]){ 			 \r          combo_add('Formulario.cbTipoClasificacionCliente',lstTipoClasificacion.datos.ij(k,0),lstTipoClasificacion.datos.ij(k,2));\r        }\r      }\r    }\r    \r  }\r\r\r  function cambioTipoClasificacion(){\r  \r    opciones = new Array();\r    set_combo('Formulario.cbClasificacionCliente',opciones);                      \r    var tipoClasificacion = get('Formulario.cbTipoClasificacionCliente','V');\r    combo_add('Formulario.cbClasificacionCliente', '', '');\r    \r    for(var k=0;k<lstClasificacion.datos.longitud;k++) {\r      for(var y=0;y<tipoClasificacion.length;y++){\r        if (lstClasificacion.datos.ij(k,1) == tipoClasificacion[y]){ 			 \r          combo_add('Formulario.cbClasificacionCliente',lstClasificacion.datos.ij(k,0),lstClasificacion.datos.ij(k,2));\r        }\r      }\r    }\r  }\r\r\r \r\r\r  function setearPais(){\r  \r    var pais = get('Formulario.pais');\r    \r    iSeleccionado = new Array(); \r    iSeleccionado[0] = pais;\r    set('Formulario.cbPais',iSeleccionado);\r\r  }\r\r\r \r  \r    "));
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
      ((Element)v.get(10)).setAttribute("name","cbSubgerenciaVenta" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","124" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoVenta" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1622" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbPercentil" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","2689" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbMoneda" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1216" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtAnio" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","171" );
      ((Element)v.get(14)).setAttribute("format","e" );
      ((Element)v.get(14)).setAttribute("min","1900" );
      ((Element)v.get(14)).setAttribute("max","9999" );
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
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","idioma" );
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
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","anio" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(24)).setAttribute("nombre","capa1" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("align","center" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","750" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("height","1" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:26   */

      /* Empieza nodo:33 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(38)).setAttribute("class","legend" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("id","legend" );
      ((Element)v.get(39)).setAttribute("cod","00275" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("align","left" );
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
      ((Element)v.get(45)).setAttribute("colspan","4" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:47 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblPais" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","5" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:47   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(54));

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
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(58)).setAttribute("nombre","cbPais" );
      ((Element)v.get(58)).setAttribute("size","1" );
      ((Element)v.get(58)).setAttribute("multiple","N" );
      ((Element)v.get(58)).setAttribute("valorinicial","" );
      ((Element)v.get(58)).setAttribute("textoinicial","" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("req","S" );
      ((Element)v.get(58)).setAttribute("onchange","onchangeMarcaCanal()" );
      ((Element)v.get(58)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarExcel');" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:54   */

      /* Empieza nodo:62 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("colspan","4" );
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
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:65 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("align","left" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","6" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","7" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:68   */

      /* Empieza nodo:79 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(83)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(83)).setAttribute("size","1" );
      ((Element)v.get(83)).setAttribute("multiple","N" );
      ((Element)v.get(83)).setAttribute("valorinicial","" );
      ((Element)v.get(83)).setAttribute("textoinicial","" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("req","S" );
      ((Element)v.get(83)).setAttribute("onchange","onchangeMarcaCanal()" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("req","S" );
      ((Element)v.get(88)).setAttribute("onchange","onchangeCanal(); onchangeMarcaCanal()" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:79   */

      /* Empieza nodo:92 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("colspan","4" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:95 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("table"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(97)).setAttribute("border","0" );
      ((Element)v.get(97)).setAttribute("align","left" );
      ((Element)v.get(97)).setAttribute("cellspacing","0" );
      ((Element)v.get(97)).setAttribute("cellpadding","0" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","124" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","109" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:98   */

      /* Empieza nodo:109 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbSubgerenciaVenta" );
      ((Element)v.get(113)).setAttribute("size","5" );
      ((Element)v.get(113)).setAttribute("multiple","S" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("req","S" );
      ((Element)v.get(113)).setAttribute("onchange","cambioSubgerencia()" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 109   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).setAttribute("valign","bottom" );
      ((Element)v.get(109)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(118)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(118)).setAttribute("size","5" );
      ((Element)v.get(118)).setAttribute("multiple","S" );
      ((Element)v.get(118)).setAttribute("valorinicial","" );
      ((Element)v.get(118)).setAttribute("textoinicial","" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("req","N" );
      ((Element)v.get(118)).setAttribute("onchange","cambioRegion()" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:109   */

      /* Empieza nodo:122 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("colspan","4" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:125 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("align","left" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblZona" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","143" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","1622" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(138)).setAttribute("width","25" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblTiposOfertaExcluir" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","2688" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:128   */

      /* Empieza nodo:143 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(143));

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
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(147)).setAttribute("nombre","cbZona" );
      ((Element)v.get(147)).setAttribute("size","5" );
      ((Element)v.get(147)).setAttribute("multiple","S" );
      ((Element)v.get(147)).setAttribute("valorinicial","" );
      ((Element)v.get(147)).setAttribute("textoinicial","" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("req","N" );
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
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).setAttribute("valign","top" );
      ((Element)v.get(143)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(152)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(152)).setAttribute("size","1" );
      ((Element)v.get(152)).setAttribute("multiple","N" );
      ((Element)v.get(152)).setAttribute("valorinicial","1" );
      ((Element)v.get(152)).setAttribute("textoinicial","Venta Catálogo" );
      ((Element)v.get(152)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).setAttribute("req","S" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(154)).setAttribute("ID","2" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(155)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(155)).setAttribute("TIPO","STRING" );
      ((Element)v.get(155)).setAttribute("VALOR","2" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 154   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(156)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(156)).setAttribute("TIPO","STRING" );
      ((Element)v.get(156)).setAttribute("VALOR","Venta Neta" );
      ((Element)v.get(154)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 153   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(157)).setAttribute("ID","3" );
      ((Element)v.get(153)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(158)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(158)).setAttribute("TIPO","STRING" );
      ((Element)v.get(158)).setAttribute("VALOR","3" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 157   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(159)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(159)).setAttribute("TIPO","STRING" );
      ((Element)v.get(159)).setAttribute("VALOR","Venta Factura" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(157)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:157   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:160 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(163)).setAttribute("nombre","cbTiposOferta" );
      ((Element)v.get(163)).setAttribute("size","5" );
      ((Element)v.get(163)).setAttribute("multiple","S" );
      ((Element)v.get(163)).setAttribute("valorinicial","" );
      ((Element)v.get(163)).setAttribute("textoinicial","" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).setAttribute("req","N" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(143)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:143   */

      /* Empieza nodo:167 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("colspan","4" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:170 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("table"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("align","left" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

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
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(177)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(177)).setAttribute("alto","13" );
      ((Element)v.get(177)).setAttribute("filas","1" );
      ((Element)v.get(177)).setAttribute("id","datosTitle" );
      ((Element)v.get(177)).setAttribute("cod","1869" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","25" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","595" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:173   */

      /* Empieza nodo:184 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(188)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(188)).setAttribute("size","5" );
      ((Element)v.get(188)).setAttribute("multiple","S" );
      ((Element)v.get(188)).setAttribute("valorinicial","" );
      ((Element)v.get(188)).setAttribute("textoinicial","" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("req","N" );
      ((Element)v.get(188)).setAttribute("onchange","cambioTipo()" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","25" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(184)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(193)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(193)).setAttribute("size","5" );
      ((Element)v.get(193)).setAttribute("multiple","S" );
      ((Element)v.get(193)).setAttribute("valorinicial","" );
      ((Element)v.get(193)).setAttribute("textoinicial","" );
      ((Element)v.get(193)).setAttribute("id","datosCampos" );
      ((Element)v.get(193)).setAttribute("req","N" );
      ((Element)v.get(193)).setAttribute("onchange","cambioSubtipo()" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:195 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:184   */

      /* Empieza nodo:197 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("colspan","4" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","8" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:200 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("table"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(202)).setAttribute("border","0" );
      ((Element)v.get(202)).setAttribute("align","left" );
      ((Element)v.get(202)).setAttribute("cellspacing","0" );
      ((Element)v.get(202)).setAttribute("cellpadding","0" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(207)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("id","datosTitle" );
      ((Element)v.get(207)).setAttribute("cod","756" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","550" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","25" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(215)).setAttribute("nombre","lblPercentil" );
      ((Element)v.get(215)).setAttribute("alto","13" );
      ((Element)v.get(215)).setAttribute("filas","1" );
      ((Element)v.get(215)).setAttribute("id","datosTitle" );
      ((Element)v.get(215)).setAttribute("cod","2689" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("width","100%" );
      ((Element)v.get(203)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:203   */

      /* Empieza nodo:218 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(221)).setAttribute("valign","bottom" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(222)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(222)).setAttribute("size","5" );
      ((Element)v.get(222)).setAttribute("multiple","S" );
      ((Element)v.get(222)).setAttribute("valorinicial","" );
      ((Element)v.get(222)).setAttribute("textoinicial","" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("req","N" );
      ((Element)v.get(222)).setAttribute("onchange","cambioTipoClasificacion()" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","25" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(226)).setAttribute("valign","bottom" );
      ((Element)v.get(218)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(227)).setAttribute("nombre","cbClasificacionCliente" );
      ((Element)v.get(227)).setAttribute("size","5" );
      ((Element)v.get(227)).setAttribute("multiple","S" );
      ((Element)v.get(227)).setAttribute("valorinicial","" );
      ((Element)v.get(227)).setAttribute("textoinicial","" );
      ((Element)v.get(227)).setAttribute("id","datosCampos" );
      ((Element)v.get(227)).setAttribute("req","N" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:229 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","25" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(218)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(232)).setAttribute("nombre","cbPercentil" );
      ((Element)v.get(232)).setAttribute("size","5" );
      ((Element)v.get(232)).setAttribute("multiple","S" );
      ((Element)v.get(232)).setAttribute("valorinicial","0.10" );
      ((Element)v.get(232)).setAttribute("textoinicial","0.10" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("req","S" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(234)).setAttribute("ID","2" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","0.20" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(236)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(236)).setAttribute("TIPO","STRING" );
      ((Element)v.get(236)).setAttribute("VALOR","0.20" );
      ((Element)v.get(234)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:234   */

      /* Empieza nodo:237 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(237)).setAttribute("ID","3" );
      ((Element)v.get(233)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(238)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(238)).setAttribute("TIPO","STRING" );
      ((Element)v.get(238)).setAttribute("VALOR","0.30" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(239)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(239)).setAttribute("TIPO","STRING" );
      ((Element)v.get(239)).setAttribute("VALOR","0.30" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(240)).setAttribute("ID","4" );
      ((Element)v.get(233)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(241)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(241)).setAttribute("TIPO","STRING" );
      ((Element)v.get(241)).setAttribute("VALOR","0.40" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(242)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(242)).setAttribute("TIPO","STRING" );
      ((Element)v.get(242)).setAttribute("VALOR","0.40" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(243)).setAttribute("ID","5" );
      ((Element)v.get(233)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(244)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(244)).setAttribute("TIPO","STRING" );
      ((Element)v.get(244)).setAttribute("VALOR","0.50" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 243   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(245)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(245)).setAttribute("TIPO","STRING" );
      ((Element)v.get(245)).setAttribute("VALOR","0.50" );
      ((Element)v.get(243)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(246)).setAttribute("ID","6" );
      ((Element)v.get(233)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(247)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(247)).setAttribute("TIPO","STRING" );
      ((Element)v.get(247)).setAttribute("VALOR","0.60" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 246   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(248)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(248)).setAttribute("TIPO","STRING" );
      ((Element)v.get(248)).setAttribute("VALOR","0.60" );
      ((Element)v.get(246)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:246   */

      /* Empieza nodo:249 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(249)).setAttribute("ID","7" );
      ((Element)v.get(233)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(250)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(250)).setAttribute("TIPO","STRING" );
      ((Element)v.get(250)).setAttribute("VALOR","0.70" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 249   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(251)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(251)).setAttribute("TIPO","STRING" );
      ((Element)v.get(251)).setAttribute("VALOR","0.70" );
      ((Element)v.get(249)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:249   */

      /* Empieza nodo:252 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(252)).setAttribute("ID","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(253)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(253)).setAttribute("TIPO","STRING" );
      ((Element)v.get(253)).setAttribute("VALOR","0.80" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 252   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(254)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(254)).setAttribute("TIPO","STRING" );
      ((Element)v.get(254)).setAttribute("VALOR","0.80" );
      ((Element)v.get(252)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:252   */

      /* Empieza nodo:255 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(255)).setAttribute("ID","9" );
      ((Element)v.get(233)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(256)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(256)).setAttribute("TIPO","STRING" );
      ((Element)v.get(256)).setAttribute("VALOR","0.90" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 255   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(257)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(257)).setAttribute("TIPO","STRING" );
      ((Element)v.get(257)).setAttribute("VALOR","0.90" );
      ((Element)v.get(255)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(258)).setAttribute("ID","10" );
      ((Element)v.get(233)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(259)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(259)).setAttribute("TIPO","STRING" );
      ((Element)v.get(259)).setAttribute("VALOR","1" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 258   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(260)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(260)).setAttribute("TIPO","STRING" );
      ((Element)v.get(260)).setAttribute("VALOR","1" );
      ((Element)v.get(258)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:258   */

      /* Empieza nodo:261 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(261)).setAttribute("ID","11" );
      ((Element)v.get(233)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(262)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(262)).setAttribute("TIPO","STRING" );
      ((Element)v.get(262)).setAttribute("VALOR","2" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 261   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(263)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(263)).setAttribute("TIPO","STRING" );
      ((Element)v.get(263)).setAttribute("VALOR","2" );
      ((Element)v.get(261)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:261   */

      /* Empieza nodo:264 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(264)).setAttribute("ID","12" );
      ((Element)v.get(233)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(265)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(265)).setAttribute("TIPO","STRING" );
      ((Element)v.get(265)).setAttribute("VALOR","3" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 264   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(266)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(266)).setAttribute("TIPO","STRING" );
      ((Element)v.get(266)).setAttribute("VALOR","3" );
      ((Element)v.get(264)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:264   */

      /* Empieza nodo:267 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(267)).setAttribute("ID","13" );
      ((Element)v.get(233)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(268)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(268)).setAttribute("TIPO","STRING" );
      ((Element)v.get(268)).setAttribute("VALOR","4" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 267   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(269)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(269)).setAttribute("TIPO","STRING" );
      ((Element)v.get(269)).setAttribute("VALOR","4" );
      ((Element)v.get(267)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:267   */

      /* Empieza nodo:270 / Elemento padre: 233   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(270)).setAttribute("ID","14" );
      ((Element)v.get(233)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(271)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(271)).setAttribute("TIPO","STRING" );
      ((Element)v.get(271)).setAttribute("VALOR","5" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 270   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(272)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(272)).setAttribute("TIPO","STRING" );
      ((Element)v.get(272)).setAttribute("VALOR","5" );
      ((Element)v.get(270)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:270   */

      /* Empieza nodo:273 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(273)).setAttribute("ID","15" );
      ((Element)v.get(233)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(274)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(274)).setAttribute("TIPO","STRING" );
      ((Element)v.get(274)).setAttribute("VALOR","6" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 273   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(275)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(275)).setAttribute("TIPO","STRING" );
      ((Element)v.get(275)).setAttribute("VALOR","6" );
      ((Element)v.get(273)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:273   */

      /* Empieza nodo:276 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(276)).setAttribute("ID","16" );
      ((Element)v.get(233)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(277)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(277)).setAttribute("TIPO","STRING" );
      ((Element)v.get(277)).setAttribute("VALOR","7" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 276   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(278)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(278)).setAttribute("TIPO","STRING" );
      ((Element)v.get(278)).setAttribute("VALOR","7" );
      ((Element)v.get(276)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:276   */

      /* Empieza nodo:279 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(279)).setAttribute("ID","17" );
      ((Element)v.get(233)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(280)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(280)).setAttribute("TIPO","STRING" );
      ((Element)v.get(280)).setAttribute("VALOR","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 279   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(281)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(281)).setAttribute("TIPO","STRING" );
      ((Element)v.get(281)).setAttribute("VALOR","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:279   */

      /* Empieza nodo:282 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(282)).setAttribute("ID","18" );
      ((Element)v.get(233)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(283)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(283)).setAttribute("TIPO","STRING" );
      ((Element)v.get(283)).setAttribute("VALOR","9" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 282   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(284)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(284)).setAttribute("TIPO","STRING" );
      ((Element)v.get(284)).setAttribute("VALOR","9" );
      ((Element)v.get(282)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:282   */

      /* Empieza nodo:285 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(285)).setAttribute("ID","19" );
      ((Element)v.get(233)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(286)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(286)).setAttribute("TIPO","STRING" );
      ((Element)v.get(286)).setAttribute("VALOR","10" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 285   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(287)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(287)).setAttribute("TIPO","STRING" );
      ((Element)v.get(287)).setAttribute("VALOR","10" );
      ((Element)v.get(285)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:285   */

      /* Empieza nodo:288 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(288)).setAttribute("ID","20" );
      ((Element)v.get(233)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(289)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(289)).setAttribute("TIPO","STRING" );
      ((Element)v.get(289)).setAttribute("VALOR","11" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 288   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(290)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(290)).setAttribute("TIPO","STRING" );
      ((Element)v.get(290)).setAttribute("VALOR","11" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(288)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:288   */

      /* Empieza nodo:291 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(291)).setAttribute("ID","21" );
      ((Element)v.get(233)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(292)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(292)).setAttribute("TIPO","STRING" );
      ((Element)v.get(292)).setAttribute("VALOR","12" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 291   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(293)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(293)).setAttribute("TIPO","STRING" );
      ((Element)v.get(293)).setAttribute("VALOR","12" );
      ((Element)v.get(291)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:291   */

      /* Empieza nodo:294 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(294)).setAttribute("ID","22" );
      ((Element)v.get(233)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(295)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(295)).setAttribute("TIPO","STRING" );
      ((Element)v.get(295)).setAttribute("VALOR","13" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 294   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(296)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(296)).setAttribute("TIPO","STRING" );
      ((Element)v.get(296)).setAttribute("VALOR","13" );
      ((Element)v.get(294)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:294   */

      /* Empieza nodo:297 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(297)).setAttribute("ID","23" );
      ((Element)v.get(233)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(298)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(298)).setAttribute("TIPO","STRING" );
      ((Element)v.get(298)).setAttribute("VALOR","14" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 297   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(299)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(299)).setAttribute("TIPO","STRING" );
      ((Element)v.get(299)).setAttribute("VALOR","14" );
      ((Element)v.get(297)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(300)).setAttribute("ID","24" );
      ((Element)v.get(233)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(301)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(301)).setAttribute("TIPO","STRING" );
      ((Element)v.get(301)).setAttribute("VALOR","15" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 300   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(302)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(302)).setAttribute("TIPO","STRING" );
      ((Element)v.get(302)).setAttribute("VALOR","15" );
      ((Element)v.get(300)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:300   */

      /* Empieza nodo:303 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(303)).setAttribute("ID","25" );
      ((Element)v.get(233)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(304)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(304)).setAttribute("TIPO","STRING" );
      ((Element)v.get(304)).setAttribute("VALOR","16" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 303   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(305)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(305)).setAttribute("TIPO","STRING" );
      ((Element)v.get(305)).setAttribute("VALOR","16" );
      ((Element)v.get(303)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:303   */

      /* Empieza nodo:306 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(306)).setAttribute("ID","26" );
      ((Element)v.get(233)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(307)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(307)).setAttribute("TIPO","STRING" );
      ((Element)v.get(307)).setAttribute("VALOR","17" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 306   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(308)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(308)).setAttribute("TIPO","STRING" );
      ((Element)v.get(308)).setAttribute("VALOR","17" );
      ((Element)v.get(306)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:306   */

      /* Empieza nodo:309 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(309)).setAttribute("ID","27" );
      ((Element)v.get(233)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(310)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(310)).setAttribute("TIPO","STRING" );
      ((Element)v.get(310)).setAttribute("VALOR","18" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 309   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(311)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(311)).setAttribute("TIPO","STRING" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(311)).setAttribute("VALOR","18" );
      ((Element)v.get(309)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:309   */

      /* Empieza nodo:312 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(312)).setAttribute("ID","28" );
      ((Element)v.get(233)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(313)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(313)).setAttribute("TIPO","STRING" );
      ((Element)v.get(313)).setAttribute("VALOR","19" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 312   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(314)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(314)).setAttribute("TIPO","STRING" );
      ((Element)v.get(314)).setAttribute("VALOR","19" );
      ((Element)v.get(312)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:312   */

      /* Empieza nodo:315 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(315)).setAttribute("ID","29" );
      ((Element)v.get(233)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(316)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(316)).setAttribute("TIPO","STRING" );
      ((Element)v.get(316)).setAttribute("VALOR","20" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 315   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(317)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(317)).setAttribute("TIPO","STRING" );
      ((Element)v.get(317)).setAttribute("VALOR","20" );
      ((Element)v.get(315)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:315   */

      /* Empieza nodo:318 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(318)).setAttribute("ID","30" );
      ((Element)v.get(233)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(319)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(319)).setAttribute("TIPO","STRING" );
      ((Element)v.get(319)).setAttribute("VALOR","21" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 318   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(320)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(320)).setAttribute("TIPO","STRING" );
      ((Element)v.get(320)).setAttribute("VALOR","21" );
      ((Element)v.get(318)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:318   */

      /* Empieza nodo:321 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(321)).setAttribute("ID","31" );
      ((Element)v.get(233)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(322)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(322)).setAttribute("TIPO","STRING" );
      ((Element)v.get(322)).setAttribute("VALOR","22" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 321   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(323)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(323)).setAttribute("TIPO","STRING" );
      ((Element)v.get(323)).setAttribute("VALOR","22" );
      ((Element)v.get(321)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(324)).setAttribute("ID","32" );
      ((Element)v.get(233)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(325)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(325)).setAttribute("TIPO","STRING" );
      ((Element)v.get(325)).setAttribute("VALOR","23" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 324   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(326)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(326)).setAttribute("TIPO","STRING" );
      ((Element)v.get(326)).setAttribute("VALOR","23" );
      ((Element)v.get(324)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(327)).setAttribute("ID","33" );
      ((Element)v.get(233)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(328)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(328)).setAttribute("TIPO","STRING" );
      ((Element)v.get(328)).setAttribute("VALOR","24" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 327   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(329)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(329)).setAttribute("TIPO","STRING" );
      ((Element)v.get(329)).setAttribute("VALOR","24" );
      ((Element)v.get(327)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:327   */

      /* Empieza nodo:330 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(330)).setAttribute("ID","34" );
      ((Element)v.get(233)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(331)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(331)).setAttribute("TIPO","STRING" );
      ((Element)v.get(331)).setAttribute("VALOR","25" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 330   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(332)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(332)).setAttribute("TIPO","STRING" );
      ((Element)v.get(332)).setAttribute("VALOR","25" );
      ((Element)v.get(330)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:330   */

      /* Empieza nodo:333 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(333)).setAttribute("ID","35" );
      ((Element)v.get(233)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(334)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(334)).setAttribute("TIPO","STRING" );
      ((Element)v.get(334)).setAttribute("VALOR","26" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 333   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(335)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(335)).setAttribute("TIPO","STRING" );
      ((Element)v.get(335)).setAttribute("VALOR","26" );
      ((Element)v.get(333)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:333   */

      /* Empieza nodo:336 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(336)).setAttribute("ID","36" );
      ((Element)v.get(233)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(337)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(337)).setAttribute("TIPO","STRING" );
      ((Element)v.get(337)).setAttribute("VALOR","27" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 336   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(338)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(338)).setAttribute("TIPO","STRING" );
      ((Element)v.get(338)).setAttribute("VALOR","27" );
      ((Element)v.get(336)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:336   */

      /* Empieza nodo:339 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(339)).setAttribute("ID","37" );
      ((Element)v.get(233)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(340)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(340)).setAttribute("TIPO","STRING" );
      ((Element)v.get(340)).setAttribute("VALOR","28" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 339   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(341)).setAttribute("TIPO","STRING" );
      ((Element)v.get(341)).setAttribute("VALOR","28" );
      ((Element)v.get(339)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:339   */

      /* Empieza nodo:342 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(342)).setAttribute("ID","38" );
      ((Element)v.get(233)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(343)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(343)).setAttribute("TIPO","STRING" );
      ((Element)v.get(343)).setAttribute("VALOR","29" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 342   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(344)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(344)).setAttribute("TIPO","STRING" );
      ((Element)v.get(344)).setAttribute("VALOR","29" );
      ((Element)v.get(342)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:342   */

      /* Empieza nodo:345 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(345)).setAttribute("ID","39" );
      ((Element)v.get(233)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(346)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(346)).setAttribute("TIPO","STRING" );
      ((Element)v.get(346)).setAttribute("VALOR","30" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(347)).setAttribute("TIPO","STRING" );
      ((Element)v.get(347)).setAttribute("VALOR","30" );
      ((Element)v.get(345)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:345   */

      /* Empieza nodo:348 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(348)).setAttribute("ID","40" );
      ((Element)v.get(233)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(349)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(349)).setAttribute("TIPO","STRING" );
      ((Element)v.get(349)).setAttribute("VALOR","31" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(350)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(350)).setAttribute("TIPO","STRING" );
      ((Element)v.get(350)).setAttribute("VALOR","31" );
      ((Element)v.get(348)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:348   */

      /* Empieza nodo:351 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(351)).setAttribute("ID","41" );
      ((Element)v.get(233)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(352)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(352)).setAttribute("TIPO","STRING" );
      ((Element)v.get(352)).setAttribute("VALOR","32" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 351   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(353)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","32" );
      ((Element)v.get(351)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:351   */

      /* Empieza nodo:354 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(354)).setAttribute("ID","42" );
      ((Element)v.get(233)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(355)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(355)).setAttribute("TIPO","STRING" );
      ((Element)v.get(355)).setAttribute("VALOR","33" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 354   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(356)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(356)).setAttribute("TIPO","STRING" );
      ((Element)v.get(356)).setAttribute("VALOR","33" );
      ((Element)v.get(354)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:354   */

      /* Empieza nodo:357 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(357)).setAttribute("ID","43" );
      ((Element)v.get(233)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(358)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(358)).setAttribute("TIPO","STRING" );
      ((Element)v.get(358)).setAttribute("VALOR","34" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 357   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(359)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(359)).setAttribute("TIPO","STRING" );
      ((Element)v.get(359)).setAttribute("VALOR","34" );
      ((Element)v.get(357)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:357   */

      /* Empieza nodo:360 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(360)).setAttribute("ID","44" );
      ((Element)v.get(233)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(361)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(361)).setAttribute("TIPO","STRING" );
      ((Element)v.get(361)).setAttribute("VALOR","35" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(362)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(362)).setAttribute("TIPO","STRING" );
      ((Element)v.get(362)).setAttribute("VALOR","35" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:360   */

      /* Empieza nodo:363 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(363)).setAttribute("ID","45" );
      ((Element)v.get(233)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(364)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(364)).setAttribute("TIPO","STRING" );
      ((Element)v.get(364)).setAttribute("VALOR","36" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 363   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(365)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(365)).setAttribute("TIPO","STRING" );
      ((Element)v.get(365)).setAttribute("VALOR","36" );
      ((Element)v.get(363)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:363   */

      /* Empieza nodo:366 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(366)).setAttribute("ID","46" );
      ((Element)v.get(233)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(367)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(367)).setAttribute("TIPO","STRING" );
      ((Element)v.get(367)).setAttribute("VALOR","37" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 366   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(368)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(368)).setAttribute("TIPO","STRING" );
      ((Element)v.get(368)).setAttribute("VALOR","37" );
      ((Element)v.get(366)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:366   */

      /* Empieza nodo:369 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(369)).setAttribute("ID","47" );
      ((Element)v.get(233)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(370)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(370)).setAttribute("TIPO","STRING" );
      ((Element)v.get(370)).setAttribute("VALOR","38" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 369   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(371)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(371)).setAttribute("TIPO","STRING" );
      ((Element)v.get(371)).setAttribute("VALOR","38" );
      ((Element)v.get(369)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:369   */

      /* Empieza nodo:372 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(372)).setAttribute("ID","48" );
      ((Element)v.get(233)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(373)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(373)).setAttribute("TIPO","STRING" );
      ((Element)v.get(373)).setAttribute("VALOR","39" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 372   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(374)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(374)).setAttribute("TIPO","STRING" );
      ((Element)v.get(374)).setAttribute("VALOR","39" );
      ((Element)v.get(372)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:372   */

      /* Empieza nodo:375 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(375)).setAttribute("ID","49" );
      ((Element)v.get(233)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(376)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(376)).setAttribute("TIPO","STRING" );
      ((Element)v.get(376)).setAttribute("VALOR","40" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 375   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(377)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(377)).setAttribute("TIPO","STRING" );
      ((Element)v.get(377)).setAttribute("VALOR","40" );
      ((Element)v.get(375)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:375   */

      /* Empieza nodo:378 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(378)).setAttribute("ID","50" );
      ((Element)v.get(233)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(379)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(379)).setAttribute("TIPO","STRING" );
      ((Element)v.get(379)).setAttribute("VALOR","41" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 378   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(380)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(380)).setAttribute("TIPO","STRING" );
      ((Element)v.get(380)).setAttribute("VALOR","41" );
      ((Element)v.get(378)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:378   */

      /* Empieza nodo:381 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(381)).setAttribute("ID","51" );
      ((Element)v.get(233)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(382)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(382)).setAttribute("TIPO","STRING" );
      ((Element)v.get(382)).setAttribute("VALOR","42" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 381   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(383)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(383)).setAttribute("TIPO","STRING" );
      ((Element)v.get(383)).setAttribute("VALOR","42" );
      ((Element)v.get(381)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(384)).setAttribute("ID","52" );
      ((Element)v.get(233)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(385)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(385)).setAttribute("TIPO","STRING" );
      ((Element)v.get(385)).setAttribute("VALOR","43" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 384   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(386)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(386)).setAttribute("TIPO","STRING" );
      ((Element)v.get(386)).setAttribute("VALOR","43" );
      ((Element)v.get(384)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:384   */

      /* Empieza nodo:387 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(387)).setAttribute("ID","53" );
      ((Element)v.get(233)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(388)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(388)).setAttribute("TIPO","STRING" );
      ((Element)v.get(388)).setAttribute("VALOR","44" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 387   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(389)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(389)).setAttribute("TIPO","STRING" );
      ((Element)v.get(389)).setAttribute("VALOR","44" );
      ((Element)v.get(387)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:387   */

      /* Empieza nodo:390 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(390)).setAttribute("ID","54" );
      ((Element)v.get(233)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(391)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(391)).setAttribute("TIPO","STRING" );
      ((Element)v.get(391)).setAttribute("VALOR","45" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 390   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(392)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(392)).setAttribute("TIPO","STRING" );
      ((Element)v.get(392)).setAttribute("VALOR","45" );
      ((Element)v.get(390)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:390   */

      /* Empieza nodo:393 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(393)).setAttribute("ID","55" );
      ((Element)v.get(233)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(394)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(394)).setAttribute("TIPO","STRING" );
      ((Element)v.get(394)).setAttribute("VALOR","46" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 393   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(395)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(395)).setAttribute("TIPO","STRING" );
      ((Element)v.get(395)).setAttribute("VALOR","46" );
      ((Element)v.get(393)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:393   */

      /* Empieza nodo:396 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(396)).setAttribute("ID","56" );
      ((Element)v.get(233)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(397)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(397)).setAttribute("TIPO","STRING" );
      ((Element)v.get(397)).setAttribute("VALOR","47" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 396   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(398)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(398)).setAttribute("TIPO","STRING" );
      ((Element)v.get(398)).setAttribute("VALOR","47" );
      ((Element)v.get(396)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:396   */

      /* Empieza nodo:399 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(399)).setAttribute("ID","57" );
      ((Element)v.get(233)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(400)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(400)).setAttribute("TIPO","STRING" );
      ((Element)v.get(400)).setAttribute("VALOR","48" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */

      /* Empieza nodo:401 / Elemento padre: 399   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(401)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(401)).setAttribute("TIPO","STRING" );
      ((Element)v.get(401)).setAttribute("VALOR","48" );
      ((Element)v.get(399)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:399   */

      /* Empieza nodo:402 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(402)).setAttribute("ID","58" );
      ((Element)v.get(233)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(403)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(403)).setAttribute("TIPO","STRING" );
      ((Element)v.get(403)).setAttribute("VALOR","49" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 402   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(404)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(404)).setAttribute("TIPO","STRING" );
      ((Element)v.get(404)).setAttribute("VALOR","49" );
      ((Element)v.get(402)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:402   */

      /* Empieza nodo:405 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(405)).setAttribute("ID","59" );
      ((Element)v.get(233)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(406)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(406)).setAttribute("TIPO","STRING" );
      ((Element)v.get(406)).setAttribute("VALOR","50" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 405   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(407)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(407)).setAttribute("TIPO","STRING" );
      ((Element)v.get(407)).setAttribute("VALOR","50" );
      ((Element)v.get(405)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(408)).setAttribute("ID","60" );
      ((Element)v.get(233)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(409)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(409)).setAttribute("TIPO","STRING" );
      ((Element)v.get(409)).setAttribute("VALOR","51" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 408   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(410)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(410)).setAttribute("TIPO","STRING" );
      ((Element)v.get(410)).setAttribute("VALOR","51" );
      ((Element)v.get(408)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:408   */

      /* Empieza nodo:411 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).setAttribute("ID","61" );
      ((Element)v.get(233)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(412)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(412)).setAttribute("TIPO","STRING" );
      ((Element)v.get(412)).setAttribute("VALOR","52" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 411   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(413)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(413)).setAttribute("TIPO","STRING" );
      ((Element)v.get(413)).setAttribute("VALOR","52" );
      ((Element)v.get(411)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:411   */

      /* Empieza nodo:414 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(414)).setAttribute("ID","62" );
      ((Element)v.get(233)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(415)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(415)).setAttribute("TIPO","STRING" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(415)).setAttribute("VALOR","53" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 414   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","53" );
      ((Element)v.get(414)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:414   */

      /* Empieza nodo:417 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(417)).setAttribute("ID","63" );
      ((Element)v.get(233)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(418)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(418)).setAttribute("TIPO","STRING" );
      ((Element)v.get(418)).setAttribute("VALOR","54" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","54" );
      ((Element)v.get(417)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:417   */

      /* Empieza nodo:420 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(420)).setAttribute("ID","64" );
      ((Element)v.get(233)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(421)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(421)).setAttribute("TIPO","STRING" );
      ((Element)v.get(421)).setAttribute("VALOR","55" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","55" );
      ((Element)v.get(420)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:420   */

      /* Empieza nodo:423 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(423)).setAttribute("ID","65" );
      ((Element)v.get(233)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(424)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(424)).setAttribute("TIPO","STRING" );
      ((Element)v.get(424)).setAttribute("VALOR","56" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","56" );
      ((Element)v.get(423)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:423   */

      /* Empieza nodo:426 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(426)).setAttribute("ID","66" );
      ((Element)v.get(233)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(427)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(427)).setAttribute("TIPO","STRING" );
      ((Element)v.get(427)).setAttribute("VALOR","57" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 426   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(428)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(428)).setAttribute("TIPO","STRING" );
      ((Element)v.get(428)).setAttribute("VALOR","57" );
      ((Element)v.get(426)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:426   */

      /* Empieza nodo:429 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(429)).setAttribute("ID","67" );
      ((Element)v.get(233)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(430)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(430)).setAttribute("TIPO","STRING" );
      ((Element)v.get(430)).setAttribute("VALOR","58" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 429   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(431)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(431)).setAttribute("TIPO","STRING" );
      ((Element)v.get(431)).setAttribute("VALOR","58" );
      ((Element)v.get(429)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:429   */

      /* Empieza nodo:432 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(432)).setAttribute("ID","68" );
      ((Element)v.get(233)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(433)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(433)).setAttribute("VALOR","59" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(434)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(434)).setAttribute("TIPO","STRING" );
      ((Element)v.get(434)).setAttribute("VALOR","59" );
      ((Element)v.get(432)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:432   */

      /* Empieza nodo:435 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(435)).setAttribute("ID","69" );
      ((Element)v.get(233)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","CODIGO" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","60" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(437)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(437)).setAttribute("TIPO","STRING" );
      ((Element)v.get(437)).setAttribute("VALOR","60" );
      ((Element)v.get(435)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(438)).setAttribute("ID","70" );
      ((Element)v.get(233)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","61" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(440)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(440)).setAttribute("TIPO","STRING" );
      ((Element)v.get(440)).setAttribute("VALOR","61" );
      ((Element)v.get(438)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(441)).setAttribute("ID","71" );
      ((Element)v.get(233)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","62" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(443)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(443)).setAttribute("TIPO","STRING" );
      ((Element)v.get(443)).setAttribute("VALOR","62" );
      ((Element)v.get(441)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:441   */

      /* Empieza nodo:444 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(444)).setAttribute("ID","72" );
      ((Element)v.get(233)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(445)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(445)).setAttribute("TIPO","STRING" );
      ((Element)v.get(445)).setAttribute("VALOR","63" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(446)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(446)).setAttribute("TIPO","STRING" );
      ((Element)v.get(446)).setAttribute("VALOR","63" );
      ((Element)v.get(444)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:444   */

      /* Empieza nodo:447 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(447)).setAttribute("ID","73" );
      ((Element)v.get(233)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(448)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(448)).setAttribute("TIPO","STRING" );
      ((Element)v.get(448)).setAttribute("VALOR","64" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(449)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(449)).setAttribute("TIPO","STRING" );
      ((Element)v.get(449)).setAttribute("VALOR","64" );
      ((Element)v.get(447)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:447   */

      /* Empieza nodo:450 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(450)).setAttribute("ID","74" );
      ((Element)v.get(233)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(451)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(451)).setAttribute("TIPO","STRING" );
      ((Element)v.get(451)).setAttribute("VALOR","65" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(452)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(452)).setAttribute("TIPO","STRING" );
      ((Element)v.get(452)).setAttribute("VALOR","65" );
      ((Element)v.get(450)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(453)).setAttribute("ID","75" );
      ((Element)v.get(233)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(454)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(454)).setAttribute("TIPO","STRING" );
      ((Element)v.get(454)).setAttribute("VALOR","66" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(455)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(455)).setAttribute("TIPO","STRING" );
      ((Element)v.get(455)).setAttribute("VALOR","66" );
      ((Element)v.get(453)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:453   */

      /* Empieza nodo:456 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(456)).setAttribute("ID","76" );
      ((Element)v.get(233)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(457)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(457)).setAttribute("TIPO","STRING" );
      ((Element)v.get(457)).setAttribute("VALOR","67" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 456   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(458)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(458)).setAttribute("TIPO","STRING" );
      ((Element)v.get(458)).setAttribute("VALOR","67" );
      ((Element)v.get(456)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:456   */

      /* Empieza nodo:459 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(459)).setAttribute("ID","77" );
      ((Element)v.get(233)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(460)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(460)).setAttribute("TIPO","STRING" );
      ((Element)v.get(460)).setAttribute("VALOR","68" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 459   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(461)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(461)).setAttribute("TIPO","STRING" );
      ((Element)v.get(461)).setAttribute("VALOR","68" );
      ((Element)v.get(459)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:459   */

      /* Empieza nodo:462 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(462)).setAttribute("ID","78" );
      ((Element)v.get(233)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(463)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(463)).setAttribute("TIPO","STRING" );
      ((Element)v.get(463)).setAttribute("VALOR","69" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 462   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(464)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(464)).setAttribute("TIPO","STRING" );
      ((Element)v.get(464)).setAttribute("VALOR","69" );
      ((Element)v.get(462)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:462   */

      /* Empieza nodo:465 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(465)).setAttribute("ID","79" );
      ((Element)v.get(233)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(466)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(466)).setAttribute("TIPO","STRING" );
      ((Element)v.get(466)).setAttribute("VALOR","70" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 465   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(467)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(467)).setAttribute("TIPO","STRING" );
      ((Element)v.get(467)).setAttribute("VALOR","70" );
      ((Element)v.get(465)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:465   */

      /* Empieza nodo:468 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(468)).setAttribute("ID","80" );
      ((Element)v.get(233)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(469)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(469)).setAttribute("TIPO","STRING" );
      ((Element)v.get(469)).setAttribute("VALOR","71" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */

      /* Empieza nodo:470 / Elemento padre: 468   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(470)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(470)).setAttribute("TIPO","STRING" );
      ((Element)v.get(470)).setAttribute("VALOR","71" );
      ((Element)v.get(468)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:468   */

      /* Empieza nodo:471 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(471)).setAttribute("ID","81" );
      ((Element)v.get(233)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(472)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(472)).setAttribute("TIPO","STRING" );
      ((Element)v.get(472)).setAttribute("VALOR","72" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 471   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(473)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(473)).setAttribute("TIPO","STRING" );
      ((Element)v.get(473)).setAttribute("VALOR","72" );
      ((Element)v.get(471)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:471   */

      /* Empieza nodo:474 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(474)).setAttribute("ID","82" );
      ((Element)v.get(233)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(475)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(475)).setAttribute("TIPO","STRING" );
      ((Element)v.get(475)).setAttribute("VALOR","73" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 474   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(476)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(476)).setAttribute("TIPO","STRING" );
      ((Element)v.get(476)).setAttribute("VALOR","73" );
      ((Element)v.get(474)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:474   */

      /* Empieza nodo:477 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(477)).setAttribute("ID","83" );
      ((Element)v.get(233)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(478)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(478)).setAttribute("TIPO","STRING" );
      ((Element)v.get(478)).setAttribute("VALOR","74" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 477   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(479)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(479)).setAttribute("TIPO","STRING" );
      ((Element)v.get(479)).setAttribute("VALOR","74" );
      ((Element)v.get(477)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:477   */

      /* Empieza nodo:480 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(480)).setAttribute("ID","84" );
      ((Element)v.get(233)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(481)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(481)).setAttribute("TIPO","STRING" );
      ((Element)v.get(481)).setAttribute("VALOR","75" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 480   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(482)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(482)).setAttribute("TIPO","STRING" );
      ((Element)v.get(482)).setAttribute("VALOR","75" );
      ((Element)v.get(480)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:480   */

      /* Empieza nodo:483 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(483)).setAttribute("ID","85" );
      ((Element)v.get(233)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(484)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(484)).setAttribute("TIPO","STRING" );
      ((Element)v.get(484)).setAttribute("VALOR","76" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 483   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(485)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(485)).setAttribute("TIPO","STRING" );
      ((Element)v.get(485)).setAttribute("VALOR","76" );
      ((Element)v.get(483)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:483   */

      /* Empieza nodo:486 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(486)).setAttribute("ID","86" );
      ((Element)v.get(233)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(487)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(487)).setAttribute("TIPO","STRING" );
      ((Element)v.get(487)).setAttribute("VALOR","77" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 486   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(488)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(488)).setAttribute("TIPO","STRING" );
      ((Element)v.get(488)).setAttribute("VALOR","77" );
      ((Element)v.get(486)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:486   */

      /* Empieza nodo:489 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(489)).setAttribute("ID","87" );
      ((Element)v.get(233)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(490)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(490)).setAttribute("TIPO","STRING" );
      ((Element)v.get(490)).setAttribute("VALOR","78" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 489   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(491)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(491)).setAttribute("TIPO","STRING" );
      ((Element)v.get(491)).setAttribute("VALOR","78" );
      ((Element)v.get(489)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:489   */

      /* Empieza nodo:492 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(492)).setAttribute("ID","88" );
      ((Element)v.get(233)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(493)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(493)).setAttribute("TIPO","STRING" );
      ((Element)v.get(493)).setAttribute("VALOR","79" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 492   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(494)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(494)).setAttribute("TIPO","STRING" );
      ((Element)v.get(494)).setAttribute("VALOR","79" );
      ((Element)v.get(492)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:492   */

      /* Empieza nodo:495 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(495)).setAttribute("ID","89" );
      ((Element)v.get(233)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(496)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(496)).setAttribute("TIPO","STRING" );
      ((Element)v.get(496)).setAttribute("VALOR","80" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 495   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(497)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(497)).setAttribute("TIPO","STRING" );
      ((Element)v.get(497)).setAttribute("VALOR","80" );
      ((Element)v.get(495)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:495   */

      /* Empieza nodo:498 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(498)).setAttribute("ID","90" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(233)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(499)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(499)).setAttribute("TIPO","STRING" );
      ((Element)v.get(499)).setAttribute("VALOR","81" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 498   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(500)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(500)).setAttribute("TIPO","STRING" );
      ((Element)v.get(500)).setAttribute("VALOR","81" );
      ((Element)v.get(498)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:498   */

      /* Empieza nodo:501 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(501)).setAttribute("ID","91" );
      ((Element)v.get(233)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(502)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(502)).setAttribute("TIPO","STRING" );
      ((Element)v.get(502)).setAttribute("VALOR","82" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 501   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(503)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(503)).setAttribute("TIPO","STRING" );
      ((Element)v.get(503)).setAttribute("VALOR","82" );
      ((Element)v.get(501)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:501   */

      /* Empieza nodo:504 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(504)).setAttribute("ID","92" );
      ((Element)v.get(233)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(505)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(505)).setAttribute("TIPO","STRING" );
      ((Element)v.get(505)).setAttribute("VALOR","83" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 504   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(506)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(506)).setAttribute("TIPO","STRING" );
      ((Element)v.get(506)).setAttribute("VALOR","83" );
      ((Element)v.get(504)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:504   */

      /* Empieza nodo:507 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(507)).setAttribute("ID","93" );
      ((Element)v.get(233)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(508)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(508)).setAttribute("TIPO","STRING" );
      ((Element)v.get(508)).setAttribute("VALOR","84" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 507   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(509)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(509)).setAttribute("TIPO","STRING" );
      ((Element)v.get(509)).setAttribute("VALOR","84" );
      ((Element)v.get(507)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:507   */

      /* Empieza nodo:510 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(510)).setAttribute("ID","94" );
      ((Element)v.get(233)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(511)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(511)).setAttribute("TIPO","STRING" );
      ((Element)v.get(511)).setAttribute("VALOR","85" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 510   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(512)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(512)).setAttribute("TIPO","STRING" );
      ((Element)v.get(512)).setAttribute("VALOR","85" );
      ((Element)v.get(510)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:510   */

      /* Empieza nodo:513 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(513)).setAttribute("ID","95" );
      ((Element)v.get(233)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(514)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(514)).setAttribute("TIPO","STRING" );
      ((Element)v.get(514)).setAttribute("VALOR","86" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 513   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(515)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(515)).setAttribute("TIPO","STRING" );
      ((Element)v.get(515)).setAttribute("VALOR","86" );
      ((Element)v.get(513)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:513   */

      /* Empieza nodo:516 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(516)).setAttribute("ID","96" );
      ((Element)v.get(233)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(517)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(517)).setAttribute("TIPO","STRING" );
      ((Element)v.get(517)).setAttribute("VALOR","87" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 516   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(518)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(518)).setAttribute("TIPO","STRING" );
      ((Element)v.get(518)).setAttribute("VALOR","87" );
      ((Element)v.get(516)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:516   */

      /* Empieza nodo:519 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(519)).setAttribute("ID","97" );
      ((Element)v.get(233)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(520)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(520)).setAttribute("TIPO","STRING" );
      ((Element)v.get(520)).setAttribute("VALOR","88" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 519   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(521)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(521)).setAttribute("TIPO","STRING" );
      ((Element)v.get(521)).setAttribute("VALOR","88" );
      ((Element)v.get(519)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:519   */

      /* Empieza nodo:522 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(522)).setAttribute("ID","98" );
      ((Element)v.get(233)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(523)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(523)).setAttribute("TIPO","STRING" );
      ((Element)v.get(523)).setAttribute("VALOR","89" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 522   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(524)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(524)).setAttribute("TIPO","STRING" );
      ((Element)v.get(524)).setAttribute("VALOR","89" );
      ((Element)v.get(522)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:522   */

      /* Empieza nodo:525 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(525)).setAttribute("ID","99" );
      ((Element)v.get(233)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(526)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(526)).setAttribute("TIPO","STRING" );
      ((Element)v.get(526)).setAttribute("VALOR","90" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 525   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(527)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(527)).setAttribute("TIPO","STRING" );
      ((Element)v.get(527)).setAttribute("VALOR","90" );
      ((Element)v.get(525)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:525   */

      /* Empieza nodo:528 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(528)).setAttribute("ID","100" );
      ((Element)v.get(233)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(529)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(529)).setAttribute("TIPO","STRING" );
      ((Element)v.get(529)).setAttribute("VALOR","91" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */

      /* Empieza nodo:530 / Elemento padre: 528   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(530)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(530)).setAttribute("TIPO","STRING" );
      ((Element)v.get(530)).setAttribute("VALOR","91" );
      ((Element)v.get(528)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:528   */

      /* Empieza nodo:531 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(531)).setAttribute("ID","101" );
      ((Element)v.get(233)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(532)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(532)).setAttribute("TIPO","STRING" );
      ((Element)v.get(532)).setAttribute("VALOR","92" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */

      /* Empieza nodo:533 / Elemento padre: 531   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(533)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(533)).setAttribute("TIPO","STRING" );
      ((Element)v.get(533)).setAttribute("VALOR","92" );
      ((Element)v.get(531)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:531   */

      /* Empieza nodo:534 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(534)).setAttribute("ID","102" );
      ((Element)v.get(233)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(535)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(535)).setAttribute("TIPO","STRING" );
      ((Element)v.get(535)).setAttribute("VALOR","93" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 534   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(536)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(536)).setAttribute("TIPO","STRING" );
      ((Element)v.get(536)).setAttribute("VALOR","93" );
      ((Element)v.get(534)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:534   */

      /* Empieza nodo:537 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(537)).setAttribute("ID","103" );
      ((Element)v.get(233)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(538)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(538)).setAttribute("TIPO","STRING" );
      ((Element)v.get(538)).setAttribute("VALOR","94" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */

      /* Empieza nodo:539 / Elemento padre: 537   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(539)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(539)).setAttribute("TIPO","STRING" );
      ((Element)v.get(539)).setAttribute("VALOR","94" );
      ((Element)v.get(537)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:537   */

      /* Empieza nodo:540 / Elemento padre: 233   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(540)).setAttribute("ID","104" );
      ((Element)v.get(233)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(541)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(541)).setAttribute("TIPO","STRING" );
      ((Element)v.get(541)).setAttribute("VALOR","95" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 540   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(542)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(542)).setAttribute("TIPO","STRING" );
      ((Element)v.get(542)).setAttribute("VALOR","95" );
      ((Element)v.get(540)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:540   */

      /* Empieza nodo:543 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(543)).setAttribute("ID","105" );
      ((Element)v.get(233)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(544)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(544)).setAttribute("TIPO","STRING" );
      ((Element)v.get(544)).setAttribute("VALOR","96" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 543   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(545)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(545)).setAttribute("TIPO","STRING" );
      ((Element)v.get(545)).setAttribute("VALOR","96" );
      ((Element)v.get(543)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:543   */

      /* Empieza nodo:546 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(546)).setAttribute("ID","106" );
      ((Element)v.get(233)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(547)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(547)).setAttribute("TIPO","STRING" );
      ((Element)v.get(547)).setAttribute("VALOR","97" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */

      /* Empieza nodo:548 / Elemento padre: 546   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(548)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(548)).setAttribute("TIPO","STRING" );
      ((Element)v.get(548)).setAttribute("VALOR","97" );
      ((Element)v.get(546)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:546   */

      /* Empieza nodo:549 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(549)).setAttribute("ID","107" );
      ((Element)v.get(233)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(550)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(550)).setAttribute("TIPO","STRING" );
      ((Element)v.get(550)).setAttribute("VALOR","98" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */

      /* Empieza nodo:551 / Elemento padre: 549   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(551)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(551)).setAttribute("TIPO","STRING" );
      ((Element)v.get(551)).setAttribute("VALOR","98" );
      ((Element)v.get(549)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:549   */

      /* Empieza nodo:552 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(552)).setAttribute("ID","108" );
      ((Element)v.get(233)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(553)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(553)).setAttribute("TIPO","STRING" );
      ((Element)v.get(553)).setAttribute("VALOR","99" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 552   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(554)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(554)).setAttribute("TIPO","STRING" );
      ((Element)v.get(554)).setAttribute("VALOR","99" );
      ((Element)v.get(552)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:552   */

      /* Empieza nodo:555 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(555)).setAttribute("ID","109" );
      ((Element)v.get(233)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(556)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(556)).setAttribute("TIPO","STRING" );
      ((Element)v.get(556)).setAttribute("VALOR","100" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 555   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(557)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(557)).setAttribute("TIPO","STRING" );
      ((Element)v.get(557)).setAttribute("VALOR","100" );
      ((Element)v.get(555)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:555   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:558 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("width","100%" );
      ((Element)v.get(218)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:218   */

      /* Empieza nodo:560 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).setAttribute("colspan","4" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","8" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:563 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("table"));
      ((Element)v.get(565)).setAttribute("width","100%" );
      ((Element)v.get(565)).setAttribute("border","0" );
      ((Element)v.get(565)).setAttribute("align","left" );
      ((Element)v.get(565)).setAttribute("cellspacing","0" );
      ((Element)v.get(565)).setAttribute("cellpadding","0" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(565)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).setAttribute("width","8" );
      ((Element)v.get(568)).setAttribute("height","8" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 566   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(570)).setAttribute("nombre","lblMoneda" );
      ((Element)v.get(570)).setAttribute("alto","13" );
      ((Element)v.get(570)).setAttribute("filas","1" );
      ((Element)v.get(570)).setAttribute("id","datosTitle" );
      ((Element)v.get(570)).setAttribute("cod","1216" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 566   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","25" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 566   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(574)).setAttribute("nombre","lblAnio" );
      ((Element)v.get(574)).setAttribute("alto","13" );
      ((Element)v.get(574)).setAttribute("filas","1" );
      ((Element)v.get(574)).setAttribute("id","datosTitle" );
      ((Element)v.get(574)).setAttribute("cod","171" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:575 / Elemento padre: 566   */
      v.add(doc.createElement("td"));
      ((Element)v.get(575)).setAttribute("width","100%" );
      ((Element)v.get(566)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:566   */

      /* Empieza nodo:577 / Elemento padre: 565   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(565)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(579)).setAttribute("height","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(580)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(577)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(581)).setAttribute("nombre","cbMoneda" );
      ((Element)v.get(581)).setAttribute("size","1" );
      ((Element)v.get(581)).setAttribute("multiple","N" );
      ((Element)v.get(581)).setAttribute("valorinicial","" );
      ((Element)v.get(581)).setAttribute("textoinicial","" );
      ((Element)v.get(581)).setAttribute("id","datosCampos" );
      ((Element)v.get(581)).setAttribute("req","S" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */

      /* Empieza nodo:583 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","25" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(585)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(577)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(586)).setAttribute("nombre","txtAnio" );
      ((Element)v.get(586)).setAttribute("id","datosCampos" );
      ((Element)v.get(586)).setAttribute("max","4" );
      ((Element)v.get(586)).setAttribute("tipo","" );
      ((Element)v.get(586)).setAttribute("onchange","" );
      ((Element)v.get(586)).setAttribute("req","S" );
      ((Element)v.get(586)).setAttribute("size","4" );
      ((Element)v.get(586)).setAttribute("valor","" );
      ((Element)v.get(586)).setAttribute("validacion","" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(587)).setAttribute("width","100%" );
      ((Element)v.get(577)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","8" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:577   */

      /* Empieza nodo:589 / Elemento padre: 565   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(565)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("colspan","4" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(591)).setAttribute("height","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:565   */
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:592 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("table"));
      ((Element)v.get(594)).setAttribute("width","100%" );
      ((Element)v.get(594)).setAttribute("border","0" );
      ((Element)v.get(594)).setAttribute("align","left" );
      ((Element)v.get(594)).setAttribute("cellspacing","0" );
      ((Element)v.get(594)).setAttribute("cellpadding","0" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","8" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(599)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(599)).setAttribute("alto","13" );
      ((Element)v.get(599)).setAttribute("filas","1" );
      ((Element)v.get(599)).setAttribute("id","datosTitle" );
      ((Element)v.get(599)).setAttribute("cod","1338" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","25" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(603)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(603)).setAttribute("alto","13" );
      ((Element)v.get(603)).setAttribute("filas","1" );
      ((Element)v.get(603)).setAttribute("id","datosTitle" );
      ((Element)v.get(603)).setAttribute("cod","588" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(595)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","8" );
      ((Element)v.get(605)).setAttribute("height","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */
      /* Termina nodo:595   */

      /* Empieza nodo:606 / Elemento padre: 594   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(594)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(608)).setAttribute("width","8" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(606)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(610)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(610)).setAttribute("size","5" );
      ((Element)v.get(610)).setAttribute("multiple","S" );
      ((Element)v.get(610)).setAttribute("valorinicial","" );
      ((Element)v.get(610)).setAttribute("textoinicial","" );
      ((Element)v.get(610)).setAttribute("id","datosCampos" );
      ((Element)v.get(610)).setAttribute("req","N" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:612 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(613)).setAttribute("src","b.gif" );
      ((Element)v.get(613)).setAttribute("width","25" );
      ((Element)v.get(613)).setAttribute("height","8" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:614 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(614)).setAttribute("valign","top" );
      ((Element)v.get(606)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(615)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(615)).setAttribute("size","5" );
      ((Element)v.get(615)).setAttribute("multiple","S" );
      ((Element)v.get(615)).setAttribute("valorinicial","" );
      ((Element)v.get(615)).setAttribute("textoinicial","" );
      ((Element)v.get(615)).setAttribute("id","datosCampos" );
      ((Element)v.get(615)).setAttribute("req","N" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:617 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).setAttribute("width","100%" );
      ((Element)v.get(606)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(618)).setAttribute("width","8" );
      ((Element)v.get(618)).setAttribute("height","8" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:606   */

      /* Empieza nodo:619 / Elemento padre: 594   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(594)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).setAttribute("colspan","4" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(621)).setAttribute("height","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:592   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:622 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:33   */

      /* Empieza nodo:624 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("table"));
      ((Element)v.get(629)).setAttribute("width","100%" );
      ((Element)v.get(629)).setAttribute("border","0" );
      ((Element)v.get(629)).setAttribute("align","center" );
      ((Element)v.get(629)).setAttribute("cellspacing","0" );
      ((Element)v.get(629)).setAttribute("cellpadding","0" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(629)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).setAttribute("class","botonera" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(632)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(632)).setAttribute("ID","botonContenido" );
      ((Element)v.get(632)).setAttribute("tipo","html" );
      ((Element)v.get(632)).setAttribute("accion","generar('pdf')" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(632)).setAttribute("estado","false" );
      ((Element)v.get(632)).setAttribute("cod","2495" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */

      /* Empieza nodo:633 / Elemento padre: 631   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(633)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(633)).setAttribute("ID","botonContenido" );
      ((Element)v.get(633)).setAttribute("tipo","html" );
      ((Element)v.get(633)).setAttribute("accion","generar('xls')" );
      ((Element)v.get(633)).setAttribute("estado","false" );
      ((Element)v.get(633)).setAttribute("cod","2526" );
      ((Element)v.get(633)).setAttribute("ontab","focaliza('Formulario.cbPais')" );
      ((Element)v.get(631)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:631   */
      /* Termina nodo:630   */
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:634 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","8" );
      ((Element)v.get(635)).setAttribute("height","12" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */
      /* Termina nodo:624   */

      /* Empieza nodo:636 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(637)).setAttribute("width","12" );
      ((Element)v.get(637)).setAttribute("align","center" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","12" );
      ((Element)v.get(638)).setAttribute("height","12" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */

      /* Empieza nodo:639 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).setAttribute("width","756" );
      ((Element)v.get(636)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */

      /* Empieza nodo:641 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).setAttribute("width","12" );
      ((Element)v.get(636)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(642)).setAttribute("src","b.gif" );
      ((Element)v.get(642)).setAttribute("width","12" );
      ((Element)v.get(642)).setAttribute("height","1" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */
      /* Termina nodo:636   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:643 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(643)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(643)).setAttribute("alto","3" );
      ((Element)v.get(643)).setAttribute("ancho","624" );
      ((Element)v.get(643)).setAttribute("colorf","" );
      ((Element)v.get(643)).setAttribute("borde","0" );
      ((Element)v.get(643)).setAttribute("imagenf","" );
      ((Element)v.get(643)).setAttribute("repeat","" );
      ((Element)v.get(643)).setAttribute("padding","" );
      ((Element)v.get(643)).setAttribute("visibilidad","visible" );
      ((Element)v.get(643)).setAttribute("contravsb","" );
      ((Element)v.get(643)).setAttribute("x","0" );
      ((Element)v.get(643)).setAttribute("y","165" );
      ((Element)v.get(643)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(644)).setAttribute("seleccion","boton" );
      ((Element)v.get(644)).setAttribute("nombre","lstSubtipo" );
      ((Element)v.get(644)).setAttribute("x","12" );
      ((Element)v.get(644)).setAttribute("y","10" );
      ((Element)v.get(644)).setAttribute("ancho","600" );
      ((Element)v.get(644)).setAttribute("alto","3" );
      ((Element)v.get(644)).setAttribute("multisel","-1" );
      ((Element)v.get(644)).setAttribute("incy","10" );
      ((Element)v.get(644)).setAttribute("incx","10" );
      ((Element)v.get(644)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(644)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(644)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(644)).setAttribute("accion","" );
      ((Element)v.get(644)).setAttribute("sep","|" );
      ((Element)v.get(644)).setAttribute("pixelsborde","2" );
      ((Element)v.get(644)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(645)).setAttribute("nombre","cab1" );
      ((Element)v.get(645)).setAttribute("height","20" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(646)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(646)).setAttribute("ancho","40" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */

      /* Empieza nodo:647 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(647)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(647)).setAttribute("ancho","60" );
      ((Element)v.get(645)).appendChild((Element)v.get(647));

      /* Elemento padre:647 / Elemento actual: 648   */
      v.add(doc.createTextNode("Subtipo"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(647)).appendChild((Text)v.get(648));

      /* Termina nodo Texto:648   */
      /* Termina nodo:647   */

      /* Empieza nodo:649 / Elemento padre: 645   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(649)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(649)).setAttribute("ancho","440" );
      ((Element)v.get(645)).appendChild((Element)v.get(649));

      /* Elemento padre:649 / Elemento actual: 650   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(649)).appendChild((Text)v.get(650));

      /* Termina nodo Texto:650   */
      /* Termina nodo:649   */
      /* Termina nodo:645   */

      /* Empieza nodo:651 / Elemento padre: 644   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(651)).setAttribute("ancho","590" );
      ((Element)v.get(651)).setAttribute("filas","1" );
      ((Element)v.get(651)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(644)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("ancho","40" );
      ((Element)v.get(652)).setAttribute("caracteres","20" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("ancho","60" );
      ((Element)v.get(653)).setAttribute("caracteres","20" );
      ((Element)v.get(651)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 651   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("ancho","440" );
      ((Element)v.get(654)).setAttribute("caracteres","30" );
      ((Element)v.get(651)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:651   */

      /* Empieza nodo:655 / Elemento padre: 644   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(644)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:644   */
      /* Termina nodo:643   */

      /* Empieza nodo:656 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(656)).setAttribute("nombre","capaTipoClasificacion" );
      ((Element)v.get(656)).setAttribute("alto","3" );
      ((Element)v.get(656)).setAttribute("ancho","624" );
      ((Element)v.get(656)).setAttribute("colorf","" );
      ((Element)v.get(656)).setAttribute("borde","0" );
      ((Element)v.get(656)).setAttribute("imagenf","" );
      ((Element)v.get(656)).setAttribute("repeat","" );
      ((Element)v.get(656)).setAttribute("padding","" );
      ((Element)v.get(656)).setAttribute("visibilidad","visible" );
      ((Element)v.get(656)).setAttribute("contravsb","" );
      ((Element)v.get(656)).setAttribute("x","0" );
      ((Element)v.get(656)).setAttribute("y","165" );
      ((Element)v.get(656)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(657)).setAttribute("seleccion","boton" );
      ((Element)v.get(657)).setAttribute("nombre","lstTipoClasificacion" );
      ((Element)v.get(657)).setAttribute("x","12" );
      ((Element)v.get(657)).setAttribute("y","10" );
      ((Element)v.get(657)).setAttribute("ancho","600" );
      ((Element)v.get(657)).setAttribute("alto","3" );
      ((Element)v.get(657)).setAttribute("multisel","-1" );
      ((Element)v.get(657)).setAttribute("incy","10" );
      ((Element)v.get(657)).setAttribute("incx","10" );
      ((Element)v.get(657)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(657)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(657)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(657)).setAttribute("accion","" );
      ((Element)v.get(657)).setAttribute("sep","|" );
      ((Element)v.get(657)).setAttribute("pixelsborde","2" );
      ((Element)v.get(657)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(658)).setAttribute("nombre","cab1" );
      ((Element)v.get(658)).setAttribute("height","20" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(659)).setAttribute("ancho","40" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(660)).setAttribute("ancho","60" );
      ((Element)v.get(658)).appendChild((Element)v.get(660));

      /* Elemento padre:660 / Elemento actual: 661   */
      v.add(doc.createTextNode("TipoClasificacion"));
      ((Element)v.get(660)).appendChild((Text)v.get(661));

      /* Termina nodo Texto:661   */
      /* Termina nodo:660   */

      /* Empieza nodo:662 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(662)).setAttribute("ancho","440" );
      ((Element)v.get(658)).appendChild((Element)v.get(662));

      /* Elemento padre:662 / Elemento actual: 663   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(662)).appendChild((Text)v.get(663));

      /* Termina nodo Texto:663   */
      /* Termina nodo:662   */
      /* Termina nodo:658   */

      /* Empieza nodo:664 / Elemento padre: 657   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(664)).setAttribute("ancho","590" );
      ((Element)v.get(664)).setAttribute("filas","1" );
      ((Element)v.get(664)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(657)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(665)).setAttribute("ancho","40" );
      ((Element)v.get(665)).setAttribute("caracteres","20" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */

      /* Empieza nodo:666 / Elemento padre: 664   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(666)).setAttribute("ancho","60" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(666)).setAttribute("caracteres","20" );
      ((Element)v.get(664)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */

      /* Empieza nodo:667 / Elemento padre: 664   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(667)).setAttribute("ancho","440" );
      ((Element)v.get(667)).setAttribute("caracteres","30" );
      ((Element)v.get(664)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:664   */

      /* Empieza nodo:668 / Elemento padre: 657   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(657)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:669 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(669)).setAttribute("nombre","capaClasificacion" );
      ((Element)v.get(669)).setAttribute("alto","3" );
      ((Element)v.get(669)).setAttribute("ancho","624" );
      ((Element)v.get(669)).setAttribute("colorf","" );
      ((Element)v.get(669)).setAttribute("borde","0" );
      ((Element)v.get(669)).setAttribute("imagenf","" );
      ((Element)v.get(669)).setAttribute("repeat","" );
      ((Element)v.get(669)).setAttribute("padding","" );
      ((Element)v.get(669)).setAttribute("visibilidad","visible" );
      ((Element)v.get(669)).setAttribute("contravsb","" );
      ((Element)v.get(669)).setAttribute("x","0" );
      ((Element)v.get(669)).setAttribute("y","165" );
      ((Element)v.get(669)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(670)).setAttribute("seleccion","boton" );
      ((Element)v.get(670)).setAttribute("nombre","lstClasificacion" );
      ((Element)v.get(670)).setAttribute("x","12" );
      ((Element)v.get(670)).setAttribute("y","10" );
      ((Element)v.get(670)).setAttribute("ancho","600" );
      ((Element)v.get(670)).setAttribute("alto","3" );
      ((Element)v.get(670)).setAttribute("multisel","-1" );
      ((Element)v.get(670)).setAttribute("incy","10" );
      ((Element)v.get(670)).setAttribute("incx","10" );
      ((Element)v.get(670)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(670)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(670)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(670)).setAttribute("accion","" );
      ((Element)v.get(670)).setAttribute("sep","|" );
      ((Element)v.get(670)).setAttribute("pixelsborde","2" );
      ((Element)v.get(670)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(671)).setAttribute("nombre","cab1" );
      ((Element)v.get(671)).setAttribute("height","20" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(672)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(672)).setAttribute("ancho","40" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */

      /* Empieza nodo:673 / Elemento padre: 671   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(673)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(673)).setAttribute("ancho","60" );
      ((Element)v.get(671)).appendChild((Element)v.get(673));

      /* Elemento padre:673 / Elemento actual: 674   */
      v.add(doc.createTextNode("Clasificacion"));
      ((Element)v.get(673)).appendChild((Text)v.get(674));

      /* Termina nodo Texto:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 671   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(675)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(675)).setAttribute("ancho","440" );
      ((Element)v.get(671)).appendChild((Element)v.get(675));

      /* Elemento padre:675 / Elemento actual: 676   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(675)).appendChild((Text)v.get(676));

      /* Termina nodo Texto:676   */
      /* Termina nodo:675   */
      /* Termina nodo:671   */

      /* Empieza nodo:677 / Elemento padre: 670   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(677)).setAttribute("ancho","590" );
      ((Element)v.get(677)).setAttribute("filas","1" );
      ((Element)v.get(677)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(670)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(678)).setAttribute("ancho","40" );
      ((Element)v.get(678)).setAttribute("caracteres","20" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */

      /* Empieza nodo:679 / Elemento padre: 677   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(679)).setAttribute("ancho","60" );
      ((Element)v.get(679)).setAttribute("caracteres","20" );
      ((Element)v.get(677)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */

      /* Empieza nodo:680 / Elemento padre: 677   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(680)).setAttribute("ancho","440" );
      ((Element)v.get(680)).setAttribute("caracteres","30" );
      ((Element)v.get(677)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:677   */

      /* Empieza nodo:681 / Elemento padre: 670   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(670)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:670   */
      /* Termina nodo:669   */
      /* Termina nodo:15   */


   }

}
