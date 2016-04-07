
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_resultados_campana_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_resultados_campana_generar" );
      ((Element)v.get(0)).setAttribute("cod","0872" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe Resultados y Puestos al Cierre de Campaña" );
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
      v.add(doc.createTextNode("\r\r\r\r  function onLoad(){\r    \r    configurarMenuSecundario('Formulario');\r    fMostrarMensajeError();\r    setearPais();\r    setearNumeroPuestos();\r    onchangePais();\r    focaliza('Formulario.cbPais');\r\r  }\r\r    function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r\r  function setearNumeroPuestos(){\r  \r    set('Formulario.textNumPuestos',20);\r    \r  }\r\r\r  function generar(formato){\r    \r    if(sicc_validaciones_generales()){\r        \r        var a = new Object();\r        a.accion = 'generar';\r        \r        a.pais = get('Formulario.cbPais');\r        a.marca = get('Formulario.cbMarca');  \r        a.marcaDesc = get('Formulario.cbMarca', 'T');  \r        a.canal = get('Formulario.cbCanal');\r        a.subgerenciaVentas = quitarItemVacio(get('Formulario.cbSubgerenciaVentas'));\r        a.region = quitarItemVacio(get('Formulario.cbRegion'));\r        a.zona = quitarItemVacio(get('Formulario.cbZona'));\r        a.territorio = quitarItemVacio(get('Formulario.cbTerritorio'));\r        a.tipoCliente = get('Formulario.cbTipoCliente');\r        a.subtipoCliente = get('Formulario.cbSubtipoCliente');\r        a.tipoClasificacion = get('Formulario.cbTipoClasificacion');\r        a.clasificacion = get('Formulario.cbClasificacion');\r        a.unidadNegocio = quitarItemVacio(get('Formulario.cbUnidadNegocio'));\r        a.negocio = quitarItemVacio(get('Formulario.cbNegocio'));\r        a.numeroConcurso = quitarItemVacio(get('Formulario.cbNumConcurso'));\r        a.numeroPuestos = get('Formulario.textNumPuestos');\r        a.periodoDesde = get('Formulario.cbPeriodoDesde');\r        a.periodoHasta = get('Formulario.cbPeriodoHasta');\r        \r        a.formato = formato;\r        \r        a.reporte = armarIdReporte();\r        \r        var LP = get(\"Formulario.lp\");\r        mostrarModalSICC(LP,'generar', a);\r      \r    }\r  \r  }\r\r\r    function armarIdReporte(){\r    \r      var zona = get('Formulario.cbZona');\r      var region = get('Formulario.cbRegion');\r      var reporte;\r      var lp = get('Formulario.lp');\r      \r      if(lp == 'INCResultadosCierreCampana'){\r         if(zona != ''){\r            reporte = 'RD_REP-063';\r         }else{\r            if((region != '') && (zona == '' )){\r               reporte = 'RD_REP-063_01';\r            }else{\r               if(region == ''){\r                  reporte = 'RD_REP-063_02';\r               }\r            }\r         }\r      }else{\r         if(zona != ''){\r	    reporte = 'RD_REP-064';\r	 }else{\r	    if((region != '') && (zona == '' )){\r	       reporte = 'RD_REP-064_01';\r	    }else{\r	       if(region == ''){\r	          reporte = 'RD_REP-064_02';\r	       }\r	    }\r	 }\r      }\r      return reporte;\r        \r    }\r\r\r  function fLimpiar(){\r  \r    var aCombo = new Array(new Array(\"\",\"\"));\r    \r    set_combo('Formulario.cbSubgerenciaVentas', aCombo, []); \r     \r    set_combo('Formulario.cbRegion', aCombo, []); \r    set_combo('Formulario.cbZona', aCombo, []); \r    set_combo('Formulario.cbTerritorio', aCombo, []); \r    \r    set_combo('Formulario.cbNumConcurso', aCombo, []);\r    \r    setearNumeroPuestos();\r    \r    set_combo('Formulario.cbSubtipoCliente', aCombo, []);\r    set_combo('Formulario.cbTipoClasificacion', aCombo, []);\r    set_combo('Formulario.cbClasificacion', aCombo, []);\r    \r    set_combo('Formulario.cbUnidadNegocio', aCombo, []);\r    set_combo('Formulario.cbNegocio', aCombo, []);\r    \r    set_combo('Formulario.cbPeriodoDesde',aCombo, []);\r    set_combo('Formulario.cbPeriodoHasta',aCombo, []);\r    \r    focaliza('Formulario.cbPais');\r\r  }\r   \r \r  function cambioSubgerencia(){\r     \r    opciones = new Array();\r    \r    set_combo('Formulario.cbRegion',opciones);\r    set_combo('Formulario.cbZona',opciones);\r    set_combo('Formulario.cbTerritorio',opciones);\r        \r    var subGerencia = get('Formulario.cbSubgerenciaVentas','V');\r    \r    combo_add('Formulario.cbRegion', '', '');\r    \r    for(var k=0;k<lstRegiones.datos.longitud;k++) {\r      for(var y=0;y<subGerencia.length;y++){\r        if (lstRegiones.datos.ij(k,0) == subGerencia[y]){     \r          combo_add('Formulario.cbRegion',lstRegiones.datos.ij(k,1),lstRegiones.datos.ij(k,2));\r        }\r      }\r    }\r  }\r\r\r  function cambioRegion(){\r    \r    opciones = new Array();\r    \r    set_combo('Formulario.cbZona',opciones);\r    set_combo('Formulario.cbTerritorio',opciones);\r        \r    var region = get('Formulario.cbRegion','V');\r    combo_add('Formulario.cbZona', '', '');\r    \r    for(var k=0;k<lstZonas.datos.longitud;k++) {\r      for(var y=0;y<region.length;y++){\r        if (lstZonas.datos.ij(k,1) == region[y]){     \r          combo_add('Formulario.cbZona',lstZonas.datos.ij(k,0),lstZonas.datos.ij(k,2));\r        }\r      }\r    }\r  \r  }\r\r\r  function cambioTipo(){\r         \r    opciones = new Array();\r    set_combo('Formulario.cbSubtipoCliente',opciones);                      \r    set_combo('Formulario.cbTipoClasificacion',opciones);                      \r    set_combo('Formulario.cbClasificacion',opciones);                      \r    \r    tipo = get('Formulario.cbTipoCliente','V');\r    combo_add('Formulario.cbSubtipoCliente', '', '');\r     \r    for(var k=0;k<lstSubtipo.datos.longitud;k++) {\r      for(var y=0;y<tipo.length;y++){\r        if (lstSubtipo.datos.ij(k,1) == tipo[y]){ 			 \r          combo_add('Formulario.cbSubtipoCliente',lstSubtipo.datos.ij(k,0),lstSubtipo.datos.ij(k,2));\r        }\r      }\r    }\r  \r  }\r\r\r  function cambioSubtipo(){\r  \r    opciones = new Array();\r    set_combo('Formulario.cbTipoClasificacion',opciones); \r    set_combo('Formulario.cbClasificacion',opciones);      \r    var subTipo = get('Formulario.cbSubtipoCliente','V');\r    combo_add('Formulario.cbTipoClasificacion', '', '');\r    \r    for(var k=0;k<lstTipoClasificacion.datos.longitud;k++) {\r      for(var y=0;y<subTipo.length;y++){\r        if (lstTipoClasificacion.datos.ij(k,1) == subTipo[y]){ 			 \r          combo_add('Formulario.cbTipoClasificacion',lstTipoClasificacion.datos.ij(k,0),lstTipoClasificacion.datos.ij(k,2));\r        }\r      }\r    }\r  \r  }\r\r\r  function cambioTipoClasificacion(){\r\r    opciones = new Array();\r    set_combo('Formulario.cbClasificacion',opciones);                      \r    var tipoClasificacion = get('Formulario.cbTipoClasificacion','V');\r    combo_add('Formulario.cbClasificacion', '', '');\r    \r    for(var k=0;k<lstClasificacion.datos.longitud;k++) {\r      for(var y=0;y<tipoClasificacion.length;y++){\r        if (lstClasificacion.datos.ij(k,1) == tipoClasificacion[y]){ 			 \r          combo_add('Formulario.cbClasificacion',lstClasificacion.datos.ij(k,0),lstClasificacion.datos.ij(k,2));\r        }\r      }\r    }\r   \r  }\r\r\r  function setearPais(){\r\r    var pais = get('Formulario.pais');\r    \r    iSeleccionado = new Array(); \r    iSeleccionado[0] = pais;\r    set('Formulario.cbPais',iSeleccionado);\r  \r  }\r\r\r  function cambioZona(){\r  \r    opciones = new Array();\r    set_combo('Formulario.cbTerritorio',opciones);                      \r        \r    var zona = get('Formulario.cbZona','V');\r    combo_add('Formulario.cbTerritorio', '', '');\r    \r    for(var k=0;k<ListaTerri.datos.longitud;k++) {\r      for(var y=0;y<zona.length;y++){\r        if (ListaTerri.datos.ij(k,0) == zona[y]){     \r          combo_add('Formulario.cbTerritorio',ListaTerri.datos.ij(k,1),ListaTerri.datos.ij(k,2));\r        }\r      }\r    }\r  }\r\r\r  function onchangePais() {\r    \r    pais   = get('Formulario.cbPais');\r    idioma = get('Formulario.idioma');\r    \r    if (pais != '') {\r    \r      var arr2 = new Array();\r      arr2[arr2.length] = [\"oidPais\", pais]; \r      \r      recargaCombo(\"Formulario.cbSubgerenciaVentas\",\"ZONRecargaSubgerenciaVentas\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2); \r      \r      var arrConcurso = new Array();\r      arrConcurso[arrConcurso.length] = [\"oidPais\", pais]; \r      arrConcurso[arrConcurso.length] = [\"oidAgrugacion\", \"6\"];\r      \r      recargaCombo('Formulario.cbNumConcurso','INCObtenerConcursosREP', 'es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado',arrConcurso );\r      \r      var arrUnidadNegocio = new Array();\r      arrUnidadNegocio[arrUnidadNegocio.length] = [\"oidPais\", pais];\r      arrUnidadNegocio[arrUnidadNegocio.length] = [\"oidIdioma\", idioma];          \r      \r      recargaCombo(\"Formulario.cbUnidadNegocio\",\"MAEObtenerUnidadesNegocioPorPais\", \"es.indra.sicc.util.DTOBelcorp\",arrUnidadNegocio);\r      recargaCombo(\"Formulario.cbNegocio\",\"MAEObtenerNegocioPorPais\", \"es.indra.sicc.util.DTOBelcorp\",arrUnidadNegocio);           \r      \r	  cargarConcursos();\r      cargaPeriodos();\r      \r    }else{\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbSubgerenciaVentas',aCombo, []);\r      set_combo('Formulario.cbRegion',aCombo, []);\r      set_combo('Formulario.cbZona',aCombo, []);\r      set_combo('Formulario.cbTerritorio',aCombo, []);\r      set_combo('Formulario.cbNumConcurso',aCombo, []);\r      set_combo('Formulario.cbUnidadNegocio',aCombo, []);\r      set_combo('Formulario.cbNegocio',aCombo, []);\r      set_combo('Formulario.cbPeriodoDesde',aCombo, []);\r      set_combo('Formulario.cbPeriodoHasta',aCombo, []);\r    }\r  }\r\r  function cargarConcursos(){\r    pais   = get('Formulario.cbPais');\r    idioma = get('Formulario.idioma');\r    \r    if (pais != '') {\r         \r      var arrConcurso = new Array();\r      arrConcurso[arrConcurso.length] = [\"oidPais\", pais]; \r      arrConcurso[arrConcurso.length] = [\"oidAgrugacion\", \"6\"];\r      \r      recargaCombo('Formulario.cbNumConcurso','INCObtenerConcursosREP', 'es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado',arrConcurso );\r   }  \r}\r\r\rfunction onchangeMarca(){\r	onchangeCanal();\r}\r\rfunction onchangeCanal(){\r	if(!cargaPeriodos()){\r      set_combo('Formulario.cbPeriodoDesde',new Array(new Array(\"\",\"\")), []);\r      set_combo('Formulario.cbPeriodoHasta',new Array(new Array(\"\",\"\")), []);\r	}\r}\r\r\r\r  function cargaPeriodos() {\r  \r    var marca = get(\"Formulario.cbMarca\");\r    var canal = get(\"Formulario.cbCanal\");\r    var pais = get(\"Formulario.pais\");\r    var idioma = get(\"Formulario.idioma\");\r\r    \r    var arr = new Array();\r    \r    arr[arr.length] = [\"oidIdioma\", idioma];\r    arr[arr.length] = [\"oidPais\", pais]; \r    arr[arr.length] = [\"marca\", marca];\r    arr[arr.length] = [\"canal\", canal];\r   \r    if ( marca != \"\" && canal != \"\" && pais != \"\"){\r       recargaCombo(\"Formulario.cbPeriodoDesde\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r       recargaCombo(\"Formulario.cbPeriodoHasta\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r	   return true;\r    }\r	return false;\r  }\r\r\r \r  \r    \r    "));
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
      ((Element)v.get(10)).setAttribute("name","cbNumConcurso" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1604" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","textNumPuestos" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","99999" );
      ((Element)v.get(11)).setAttribute("cod","2711" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1869" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1175" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1176" );
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
      ((Element)v.get(23)).setAttribute("nombre","lp" );
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
      ((Element)v.get(58)).setAttribute("onchange","onchangePais()" );
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
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(72)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","124" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:68   */

      /* Empieza nodo:75 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(79)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(79)).setAttribute("size","5" );
      ((Element)v.get(79)).setAttribute("multiple","S" );
      ((Element)v.get(79)).setAttribute("valorinicial","" );
      ((Element)v.get(79)).setAttribute("textoinicial","" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("onchange","cambioSubgerencia()" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(75)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:75   */

      /* Empieza nodo:83 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("colspan","4" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:86 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("align","left" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","6" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(97)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("id","datosTitle" );
      ((Element)v.get(97)).setAttribute("cod","7" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:89   */

      /* Empieza nodo:100 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(104)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(104)).setAttribute("size","1" );
      ((Element)v.get(104)).setAttribute("multiple","N" );
      ((Element)v.get(104)).setAttribute("valorinicial","" );
      ((Element)v.get(104)).setAttribute("textoinicial","" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("req","S" );
      ((Element)v.get(104)).setAttribute("onchange","onchangeMarca()" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:106 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","25" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(100)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(109)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(109)).setAttribute("size","1" );
      ((Element)v.get(109)).setAttribute("multiple","N" );
      ((Element)v.get(109)).setAttribute("valorinicial","" );
      ((Element)v.get(109)).setAttribute("textoinicial","" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("req","S" );
      ((Element)v.get(109)).setAttribute("onchange","onchangeCanal()" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:100   */

      /* Empieza nodo:113 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("colspan","4" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:116 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("id","datosTitle" );
      ((Element)v.get(123)).setAttribute("cod","109" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:119   */

      /* Empieza nodo:126 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(126));

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
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(130)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(130)).setAttribute("size","5" );
      ((Element)v.get(130)).setAttribute("multiple","S" );
      ((Element)v.get(130)).setAttribute("valorinicial","" );
      ((Element)v.get(130)).setAttribute("textoinicial","" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("req","N" );
      ((Element)v.get(130)).setAttribute("onchange","cambioRegion()" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:132 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:126   */

      /* Empieza nodo:134 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("colspan","4" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:137 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("table"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(139)).setAttribute("border","0" );
      ((Element)v.get(139)).setAttribute("align","left" );
      ((Element)v.get(139)).setAttribute("cellspacing","0" );
      ((Element)v.get(139)).setAttribute("cellpadding","0" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblZona" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","143" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(148)).setAttribute("alto","13" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("id","datosTitle" );
      ((Element)v.get(148)).setAttribute("cod","126" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(140)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:140   */

      /* Empieza nodo:151 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(155)).setAttribute("nombre","cbZona" );
      ((Element)v.get(155)).setAttribute("size","5" );
      ((Element)v.get(155)).setAttribute("multiple","S" );
      ((Element)v.get(155)).setAttribute("valorinicial","" );
      ((Element)v.get(155)).setAttribute("textoinicial","" );
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(155)).setAttribute("req","N" );
      ((Element)v.get(155)).setAttribute("onchange","cambioZona()" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","25" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(160)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(160)).setAttribute("size","5" );
      ((Element)v.get(160)).setAttribute("multiple","S" );
      ((Element)v.get(160)).setAttribute("valorinicial","" );
      ((Element)v.get(160)).setAttribute("textoinicial","" );
      ((Element)v.get(160)).setAttribute("id","datosCampos" );
      ((Element)v.get(160)).setAttribute("req","N" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:162 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","100%" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:151   */

      /* Empieza nodo:164 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("colspan","4" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:167 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("table"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(169)).setAttribute("border","0" );
      ((Element)v.get(169)).setAttribute("align","left" );
      ((Element)v.get(169)).setAttribute("cellspacing","0" );
      ((Element)v.get(169)).setAttribute("cellpadding","0" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","1604" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblNumPuestos" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","2711" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("width","100%" );
      ((Element)v.get(170)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:170   */

      /* Empieza nodo:181 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(181));

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
      ((Element)v.get(184)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(185)).setAttribute("nombre","cbNumConcurso" );
      ((Element)v.get(185)).setAttribute("size","5" );
      ((Element)v.get(185)).setAttribute("multiple","S" );
      ((Element)v.get(185)).setAttribute("valorinicial","" );
      ((Element)v.get(185)).setAttribute("textoinicial","" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("req","S" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
   }

   private void getXML720(Document doc) {
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
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).setAttribute("valign","top" );
      ((Element)v.get(181)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(190)).setAttribute("nombre","textNumPuestos" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("max","5" );
      ((Element)v.get(190)).setAttribute("tipo","" );
      ((Element)v.get(190)).setAttribute("onchange","" );
      ((Element)v.get(190)).setAttribute("req","N" );
      ((Element)v.get(190)).setAttribute("size","6" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("validacion","" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(181)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:181   */

      /* Empieza nodo:193 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("colspan","4" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:196 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("table"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(198)).setAttribute("border","0" );
      ((Element)v.get(198)).setAttribute("align","left" );
      ((Element)v.get(198)).setAttribute("cellspacing","0" );
      ((Element)v.get(198)).setAttribute("cellpadding","0" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","1869" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","25" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(207)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("id","datosTitle" );
      ((Element)v.get(207)).setAttribute("cod","595" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:199   */

      /* Empieza nodo:210 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(214)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(214)).setAttribute("size","1" );
      ((Element)v.get(214)).setAttribute("multiple","N" );
      ((Element)v.get(214)).setAttribute("valorinicial","" );
      ((Element)v.get(214)).setAttribute("textoinicial","" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("req","S" );
      ((Element)v.get(214)).setAttribute("onchange","cambioTipo()" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:216 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","25" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(210)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(219)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(219)).setAttribute("size","1" );
      ((Element)v.get(219)).setAttribute("multiple","N" );
      ((Element)v.get(219)).setAttribute("valorinicial","" );
      ((Element)v.get(219)).setAttribute("textoinicial","" );
      ((Element)v.get(219)).setAttribute("id","datosCampos" );
      ((Element)v.get(219)).setAttribute("req","N" );
      ((Element)v.get(219)).setAttribute("onchange","cambioSubtipo()" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:221 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","100%" );
      ((Element)v.get(210)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:210   */

      /* Empieza nodo:223 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("colspan","4" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:226 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("table"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(228)).setAttribute("border","0" );
      ((Element)v.get(228)).setAttribute("align","left" );
      ((Element)v.get(228)).setAttribute("cellspacing","0" );
      ((Element)v.get(228)).setAttribute("cellpadding","0" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(233)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(233)).setAttribute("alto","13" );
      ((Element)v.get(233)).setAttribute("filas","1" );
      ((Element)v.get(233)).setAttribute("id","datosTitle" );
      ((Element)v.get(233)).setAttribute("cod","756" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","25" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(237)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(237)).setAttribute("alto","13" );
      ((Element)v.get(237)).setAttribute("filas","1" );
      ((Element)v.get(237)).setAttribute("id","datosTitle" );
      ((Element)v.get(237)).setAttribute("cod","550" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("width","100%" );
      ((Element)v.get(229)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:229   */

      /* Empieza nodo:240 / Elemento padre: 228   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(228)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(240)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(244)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(244)).setAttribute("size","1" );
      ((Element)v.get(244)).setAttribute("multiple","N" );
      ((Element)v.get(244)).setAttribute("valorinicial","" );
      ((Element)v.get(244)).setAttribute("textoinicial","" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("req","N" );
      ((Element)v.get(244)).setAttribute("onchange","cambioTipoClasificacion()" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(240)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(249)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(249)).setAttribute("size","1" );
      ((Element)v.get(249)).setAttribute("multiple","N" );
      ((Element)v.get(249)).setAttribute("valorinicial","" );
      ((Element)v.get(249)).setAttribute("textoinicial","" );
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(249)).setAttribute("req","N" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:251 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(240)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:240   */

      /* Empieza nodo:253 / Elemento padre: 228   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(228)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("colspan","4" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:256 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("table"));
      ((Element)v.get(258)).setAttribute("width","100%" );
      ((Element)v.get(258)).setAttribute("border","0" );
      ((Element)v.get(258)).setAttribute("align","left" );
      ((Element)v.get(258)).setAttribute("cellspacing","0" );
      ((Element)v.get(258)).setAttribute("cellpadding","0" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(263)).setAttribute("alto","13" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","1338" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","25" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(267)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("id","datosTitle" );
      ((Element)v.get(267)).setAttribute("cod","588" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(259)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:259   */

      /* Empieza nodo:270 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(274)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(274)).setAttribute("size","5" );
      ((Element)v.get(274)).setAttribute("multiple","S" );
      ((Element)v.get(274)).setAttribute("valorinicial","" );
      ((Element)v.get(274)).setAttribute("textoinicial","" );
      ((Element)v.get(274)).setAttribute("id","datosCampos" );
      ((Element)v.get(274)).setAttribute("req","N" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:276 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","25" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(270)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(279)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(279)).setAttribute("size","5" );
      ((Element)v.get(279)).setAttribute("multiple","S" );
      ((Element)v.get(279)).setAttribute("valorinicial","" );
      ((Element)v.get(279)).setAttribute("textoinicial","" );
      ((Element)v.get(279)).setAttribute("id","datosCampos" );
      ((Element)v.get(279)).setAttribute("req","N" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:281 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(270)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:270   */

      /* Empieza nodo:283 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("colspan","4" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:286 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("table"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(288)).setAttribute("border","0" );
      ((Element)v.get(288)).setAttribute("align","left" );
      ((Element)v.get(288)).setAttribute("cellspacing","0" );
      ((Element)v.get(288)).setAttribute("cellpadding","0" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(293)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(293)).setAttribute("alto","13" );
      ((Element)v.get(293)).setAttribute("filas","1" );
      ((Element)v.get(293)).setAttribute("id","datosTitle" );
      ((Element)v.get(293)).setAttribute("cod","1175" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","25" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(297)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(297)).setAttribute("alto","13" );
      ((Element)v.get(297)).setAttribute("filas","1" );
      ((Element)v.get(297)).setAttribute("id","datosTitle" );
      ((Element)v.get(297)).setAttribute("cod","1176" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(289)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","8" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:289   */

      /* Empieza nodo:300 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(304)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(304)).setAttribute("size","1" );
      ((Element)v.get(304)).setAttribute("multiple","N" );
      ((Element)v.get(304)).setAttribute("valorinicial","" );
      ((Element)v.get(304)).setAttribute("textoinicial","" );
      ((Element)v.get(304)).setAttribute("id","datosCampos" );
      ((Element)v.get(304)).setAttribute("req","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:306 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(309)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(309)).setAttribute("size","1" );
      ((Element)v.get(309)).setAttribute("multiple","N" );
      ((Element)v.get(309)).setAttribute("valorinicial","" );
      ((Element)v.get(309)).setAttribute("textoinicial","" );
      ((Element)v.get(309)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).setAttribute("req","S" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:311 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).setAttribute("width","100%" );
      ((Element)v.get(300)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:300   */

      /* Empieza nodo:313 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("colspan","4" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:316 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:33   */

      /* Empieza nodo:318 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("table"));
      ((Element)v.get(323)).setAttribute("width","100%" );
      ((Element)v.get(323)).setAttribute("border","0" );
      ((Element)v.get(323)).setAttribute("align","center" );
      ((Element)v.get(323)).setAttribute("cellspacing","0" );
      ((Element)v.get(323)).setAttribute("cellpadding","0" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("class","botonera" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(326)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(326)).setAttribute("ID","botonContenido" );
      ((Element)v.get(326)).setAttribute("tipo","html" );
      ((Element)v.get(326)).setAttribute("accion","generar('pdf')" );
      ((Element)v.get(326)).setAttribute("estado","false" );
      ((Element)v.get(326)).setAttribute("cod","2495" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(326)).setAttribute("ontab","focaliza('Formulario.cbPais')" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:327 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","12" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:318   */

      /* Empieza nodo:329 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","12" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("width","756" );
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).setAttribute("width","12" );
      ((Element)v.get(329)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","12" );
      ((Element)v.get(335)).setAttribute("height","1" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:329   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:336 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(336)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(336)).setAttribute("alto","3" );
      ((Element)v.get(336)).setAttribute("ancho","624" );
      ((Element)v.get(336)).setAttribute("colorf","" );
      ((Element)v.get(336)).setAttribute("borde","0" );
      ((Element)v.get(336)).setAttribute("imagenf","" );
      ((Element)v.get(336)).setAttribute("repeat","" );
      ((Element)v.get(336)).setAttribute("padding","" );
      ((Element)v.get(336)).setAttribute("visibilidad","visible" );
      ((Element)v.get(336)).setAttribute("contravsb","" );
      ((Element)v.get(336)).setAttribute("x","0" );
      ((Element)v.get(336)).setAttribute("y","165" );
      ((Element)v.get(336)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(337)).setAttribute("seleccion","boton" );
      ((Element)v.get(337)).setAttribute("nombre","lstSubtipo" );
      ((Element)v.get(337)).setAttribute("x","12" );
      ((Element)v.get(337)).setAttribute("y","10" );
      ((Element)v.get(337)).setAttribute("ancho","600" );
      ((Element)v.get(337)).setAttribute("alto","3" );
      ((Element)v.get(337)).setAttribute("multisel","-1" );
      ((Element)v.get(337)).setAttribute("incy","10" );
      ((Element)v.get(337)).setAttribute("incx","10" );
      ((Element)v.get(337)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(337)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(337)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(337)).setAttribute("accion","" );
      ((Element)v.get(337)).setAttribute("sep","|" );
      ((Element)v.get(337)).setAttribute("pixelsborde","2" );
      ((Element)v.get(337)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(338)).setAttribute("nombre","cab1" );
      ((Element)v.get(338)).setAttribute("height","20" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(339)).setAttribute("ancho","40" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(340)).setAttribute("ancho","60" );
      ((Element)v.get(338)).appendChild((Element)v.get(340));

      /* Elemento padre:340 / Elemento actual: 341   */
      v.add(doc.createTextNode("Subtipo"));
      ((Element)v.get(340)).appendChild((Text)v.get(341));

      /* Termina nodo Texto:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(342)).setAttribute("ancho","440" );
      ((Element)v.get(338)).appendChild((Element)v.get(342));

      /* Elemento padre:342 / Elemento actual: 343   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(342)).appendChild((Text)v.get(343));

      /* Termina nodo Texto:343   */
      /* Termina nodo:342   */
      /* Termina nodo:338   */

      /* Empieza nodo:344 / Elemento padre: 337   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(344)).setAttribute("ancho","590" );
      ((Element)v.get(344)).setAttribute("filas","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(344)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(337)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("ancho","40" );
      ((Element)v.get(345)).setAttribute("caracteres","20" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 344   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("ancho","60" );
      ((Element)v.get(346)).setAttribute("caracteres","20" );
      ((Element)v.get(344)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("ancho","440" );
      ((Element)v.get(347)).setAttribute("caracteres","30" );
      ((Element)v.get(344)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:344   */

      /* Empieza nodo:348 / Elemento padre: 337   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(337)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:349 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(349)).setAttribute("nombre","capaTipoClasificacion" );
      ((Element)v.get(349)).setAttribute("alto","3" );
      ((Element)v.get(349)).setAttribute("ancho","624" );
      ((Element)v.get(349)).setAttribute("colorf","" );
      ((Element)v.get(349)).setAttribute("borde","0" );
      ((Element)v.get(349)).setAttribute("imagenf","" );
      ((Element)v.get(349)).setAttribute("repeat","" );
      ((Element)v.get(349)).setAttribute("padding","" );
      ((Element)v.get(349)).setAttribute("visibilidad","visible" );
      ((Element)v.get(349)).setAttribute("contravsb","" );
      ((Element)v.get(349)).setAttribute("x","0" );
      ((Element)v.get(349)).setAttribute("y","165" );
      ((Element)v.get(349)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(350)).setAttribute("seleccion","boton" );
      ((Element)v.get(350)).setAttribute("nombre","lstTipoClasificacion" );
      ((Element)v.get(350)).setAttribute("x","12" );
      ((Element)v.get(350)).setAttribute("y","10" );
      ((Element)v.get(350)).setAttribute("ancho","600" );
      ((Element)v.get(350)).setAttribute("alto","3" );
      ((Element)v.get(350)).setAttribute("multisel","-1" );
      ((Element)v.get(350)).setAttribute("incy","10" );
      ((Element)v.get(350)).setAttribute("incx","10" );
      ((Element)v.get(350)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(350)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(350)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(350)).setAttribute("accion","" );
      ((Element)v.get(350)).setAttribute("sep","|" );
      ((Element)v.get(350)).setAttribute("pixelsborde","2" );
      ((Element)v.get(350)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(351)).setAttribute("nombre","cab1" );
      ((Element)v.get(351)).setAttribute("height","20" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(352)).setAttribute("ancho","40" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(353)).setAttribute("ancho","60" );
      ((Element)v.get(351)).appendChild((Element)v.get(353));

      /* Elemento padre:353 / Elemento actual: 354   */
      v.add(doc.createTextNode("TipoClasificacion"));
      ((Element)v.get(353)).appendChild((Text)v.get(354));

      /* Termina nodo Texto:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(355)).setAttribute("ancho","440" );
      ((Element)v.get(351)).appendChild((Element)v.get(355));

      /* Elemento padre:355 / Elemento actual: 356   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(355)).appendChild((Text)v.get(356));

      /* Termina nodo Texto:356   */
      /* Termina nodo:355   */
      /* Termina nodo:351   */

      /* Empieza nodo:357 / Elemento padre: 350   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(357)).setAttribute("ancho","590" );
      ((Element)v.get(357)).setAttribute("filas","1" );
      ((Element)v.get(357)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(350)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("ancho","40" );
      ((Element)v.get(358)).setAttribute("caracteres","20" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 357   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("ancho","60" );
      ((Element)v.get(359)).setAttribute("caracteres","20" );
      ((Element)v.get(357)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 357   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("ancho","440" );
      ((Element)v.get(360)).setAttribute("caracteres","30" );
      ((Element)v.get(357)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:357   */

      /* Empieza nodo:361 / Elemento padre: 350   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(350)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:362 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(362)).setAttribute("nombre","capaClasificacion" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(362)).setAttribute("alto","3" );
      ((Element)v.get(362)).setAttribute("ancho","624" );
      ((Element)v.get(362)).setAttribute("colorf","" );
      ((Element)v.get(362)).setAttribute("borde","0" );
      ((Element)v.get(362)).setAttribute("imagenf","" );
      ((Element)v.get(362)).setAttribute("repeat","" );
      ((Element)v.get(362)).setAttribute("padding","" );
      ((Element)v.get(362)).setAttribute("visibilidad","visible" );
      ((Element)v.get(362)).setAttribute("contravsb","" );
      ((Element)v.get(362)).setAttribute("x","0" );
      ((Element)v.get(362)).setAttribute("y","165" );
      ((Element)v.get(362)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(363)).setAttribute("seleccion","boton" );
      ((Element)v.get(363)).setAttribute("nombre","lstClasificacion" );
      ((Element)v.get(363)).setAttribute("x","12" );
      ((Element)v.get(363)).setAttribute("y","10" );
      ((Element)v.get(363)).setAttribute("ancho","600" );
      ((Element)v.get(363)).setAttribute("alto","3" );
      ((Element)v.get(363)).setAttribute("multisel","-1" );
      ((Element)v.get(363)).setAttribute("incy","10" );
      ((Element)v.get(363)).setAttribute("incx","10" );
      ((Element)v.get(363)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(363)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(363)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(363)).setAttribute("accion","" );
      ((Element)v.get(363)).setAttribute("sep","|" );
      ((Element)v.get(363)).setAttribute("pixelsborde","2" );
      ((Element)v.get(363)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(364)).setAttribute("nombre","cab1" );
      ((Element)v.get(364)).setAttribute("height","20" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(365)).setAttribute("ancho","40" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(366)).setAttribute("ancho","60" );
      ((Element)v.get(364)).appendChild((Element)v.get(366));

      /* Elemento padre:366 / Elemento actual: 367   */
      v.add(doc.createTextNode("Clasificacion"));
      ((Element)v.get(366)).appendChild((Text)v.get(367));

      /* Termina nodo Texto:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(368)).setAttribute("ancho","440" );
      ((Element)v.get(364)).appendChild((Element)v.get(368));

      /* Elemento padre:368 / Elemento actual: 369   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(368)).appendChild((Text)v.get(369));

      /* Termina nodo Texto:369   */
      /* Termina nodo:368   */
      /* Termina nodo:364   */

      /* Empieza nodo:370 / Elemento padre: 363   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(370)).setAttribute("ancho","590" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(363)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("ancho","40" );
      ((Element)v.get(371)).setAttribute("caracteres","20" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("ancho","60" );
      ((Element)v.get(372)).setAttribute("caracteres","20" );
      ((Element)v.get(370)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("ancho","440" );
      ((Element)v.get(373)).setAttribute("caracteres","30" );
      ((Element)v.get(370)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:370   */

      /* Empieza nodo:374 / Elemento padre: 363   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(363)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:15   */


   }

}
