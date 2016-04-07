
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_no_cumplimiento_total_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_no_cumplimiento_total_generar" );
      ((Element)v.get(0)).setAttribute("cod","0885" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe No Cumplimiento Constancia Total" );
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
      v.add(doc.createTextNode("\r\r  \r\r    function onLoad(){\r      \r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      setearPais();\r      cambioPais();\r      focaliza('Formulario.cbPais');\r	  cargoComboMonto();\r      accion('Formulario.cbMoneda', '.disabled = true');\r    \r    }\r\r	function cargoComboMonto(){\r   var monto     = get('Formulario.monto');\r   var arr = new Array();\r   \r   arr[arr.length] = ['1000','1000'];\r   arr[arr.length] = ['1500','1500'];\r   arr[arr.length] = ['2000','2000'];\r   arr[arr.length] = ['2500','2500'];\r   arr[arr.length] = ['3000','3000'];\r\r   if(monto > 3000){\r      for(var k=4000;k<=monto;k+=1000) {\r	      arr[arr.length] = [k+'',k+''];   \r      }\r	}\r   \r      set_combo('Formulario.cbResultados',arr);\r}\r\r\r	  function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r\r    function cambioPais(){\r      \r      pais  = get('Formulario.cbPais');\r      idioma = get('Formulario.idioma');\r      \r      if(pais != ''){\r      \r        var arr = new Array();\r        \r        arr[arr.length] = [\"oidPais\", pais];\r        arr[arr.length] = [\"oidIdioma\", idioma];\r        \r        recargaCombo('Formulario.cbUnidadNegocio','MAEObtenerUnidadesNegocioPorPais','es.indra.sicc.util.DTOBelcorp',arr);\r        recargaCombo('Formulario.cbNegocio','MAEObtenerNegocioPorPais','es.indra.sicc.util.DTOBelcorp',arr);\r        \r      }else{\r        \r        var aCombo = new Array(new Array(\"\",\"\"));\r        \r        set_combo('Formulario.cbUnidadNegocio',aCombo, []);\r        set_combo('Formulario.cbNegocio',aCombo, []);\r      \r      }\r      \r    }\r\r    \r    function generar(formato){\r    \r      if(sicc_validaciones_generales()){\r        \r        var a = new Object();\r        a.accion = 'generar';\r        \r        a.pais = get('Formulario.cbPais');  \r        a.marca = get('Formulario.cbMarca');\r        a.canal = get('Formulario.cbCanal');\r        \r        a.sgv = quitarItemVacio(get('Formulario.cbSubgerenciaVentas'));\r        a.region = quitarItemVacio(get('Formulario.cbRegion'));\r        a.zona = quitarItemVacio(get('Formulario.cbZona'));\r        \r        a.tipoOfertaExcluir = quitarItemVacio(get('Formulario.cbTiposOfertaAExcluir'));\r        \r        a.tipoCliente = quitarItemVacio(get('Formulario.cbTipoCliente'));\r        a.subtipoCliente = quitarItemVacio(get('Formulario.cbSubtipoCliente'));\r        a.tipoClasificacion = quitarItemVacio(get('Formulario.cbTipoClasificacion'));\r        a.clasificacion = quitarItemVacio(get('Formulario.cbClasificacion'));\r        a.tipoVenta = get('Formulario.cbTipoVenta');\r        a.baseCalculo = get('Formulario.cbBaseCalculo');\r        a.unidadNegocio = quitarItemVacio(get('Formulario.cbUnidadNegocio'));\r        a.negocio = quitarItemVacio(get('Formulario.cbNegocio'));\r        a.nroConcurso = get('Formulario.cbNumConcurso');\r        a.moneda = get('Formulario.cbMoneda');\r        a.resultados = quitarItemVacio(get('Formulario.cbResultados', 'T'));\r        a.rangoDesde = get('Formulario.cbDesde');\r        a.rangoHasta = get('Formulario.cbHasta') ;\r        \r        a.formato = formato;\r        mostrarModalSICC('INCNoCumplimientoConstanciaTotal','generar', a);  \r        \r      }\r\r   }\r\r\r    function fLimpiar(){\r\r      var aCombo = new Array(new Array(\"\",\"\"));\r      \r      set_combo('Formulario.cbSubgerenciaVenta', aCombo, []);\r      set_combo('Formulario.cbRegion', aCombo, []);\r      set_combo('Formulario.cbZona', aCombo, []);\r      set_combo('Formulario.cbNegocio', aCombo, []);\r      set_combo('Formulario.cbUnidadNegocio', aCombo, []);\r      set_combo('Formulario.cbNumConcurso', aCombo, []);\r      set_combo('Formulario.cbSubtipoCliente', aCombo, []);\r      set_combo('Formulario.cbClasificacion', aCombo, []);\r      set_combo('Formulario.cbTipoClasificacion', aCombo, []);\r            \r      focaliza('Formulario.cbPais');\r      \r   }\r\r\r    function setearPais(){\r    \r      var pais = get('Formulario.pais');\r      \r      iSeleccionado = new Array(); \r      iSeleccionado[0] = pais;\r      set('Formulario.cbPais',iSeleccionado);\r      \r   }\r   \r\r    function onchangeMarcaCanalPais(){\r      \r      var pais  = get('Formulario.cbPais');\r      var marca = get('Formulario.cbMarca');\r      var canal = get('Formulario.cbCanal');\r      var tipoVenta = get('Formulario.cbTipoVenta');\r      \r      if(pais != '' && marca != '' && canal != ''){\r      \r        var arr2 = new Array();\r        \r        arr2[arr2.length] = [\"oidPais\", pais]; \r        arr2[arr2.length] = [\"oidMarca\", marca];\r        arr2[arr2.length] = [\"oidCanal\", canal];\r        \r        var arrConcurso = new Array();\r        \r        arrConcurso[arrConcurso.length] = [\"oidPais\", pais]; \r        arrConcurso[arrConcurso.length] = [\"oidMarca\", marca];\r        arrConcurso[arrConcurso.length] = [\"oidCanal\", canal];\r        arrConcurso[arrConcurso.length] = [\"oidTipoCliente\", tipoVenta];\r        arrConcurso[arrConcurso.length] = [\"oidAgrugacion\", \"5\"];\r        \r        recargaCombo('Formulario.cbSubgerenciaVenta', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr2 );\r        \r        if(tipoVenta != ''){\r           recargaCombo('Formulario.cbNumConcurso','INCObtenerConcursosREP', 'es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado',arrConcurso );\r        }\r      \r      }else{\r      \r        var aCombo = new Array(new Array(\"\",\"\"));\r        set_combo('Formulario.cbSubgerenciaVenta', aCombo, []);\r        set_combo('Formulario.cbRegion', aCombo, []);\r        set_combo('Formulario.cbZona', aCombo, []);\r        set_combo('Formulario.cbNumConcurso', aCombo, []);\r      \r      }\r      \r   }\r\r\r    function onchangeCanal(){\r      \r      var canal  = get('Formulario.cbCanal');\r      var idioma = get('Formulario.idioma');\r      \r      if(canal != ''){\r        \r        var arr = new Array();\r        arr[arr.length] = [\"oid\", canal];\r        arr[arr.length] = [\"oidIdioma\", idioma];\r          \r        recargaCombo(\"Formulario.cbTiposOfertaAExcluir\",\"PREObtenerTiposOfertaPorCanal\", \"es.indra.sicc.util.DTOOID\",arr);\r     \r      }else{\r      \r        var aCombo = new Array(new Array(\"\",\"\"));\r        set_combo('Formulario.cbTiposOfertaAExcluir', aCombo, []);\r        \r      }\r      \r    }\r\r\r  function cambioSubgerencia(){\r    \r    opciones = new Array();\r    set_combo('Formulario.cbRegion',opciones);\r    set_combo('Formulario.cbZona',opciones);\r   \r    combo_add('Formulario.cbRegion', '', '');\r    var sgvs = quitarItemVacio(get('Formulario.cbSubgerenciaVenta'));\r    var pais = get('Formulario.cbPais');\r    var sgvsConc = new String();\r    \r    for(i=0;i<sgvs.length;i++){\r       sgvsConc += sgvs[i] + \"x\";\r    }\r        \r    sgvsConc = sgvsConc.substring(0, sgvsConc.length-1);\r\r    \r    var arr = new Array();\r    arr[arr.length] = ['cadena', sgvsConc];\r    arr[arr.length] = ['oidPais', pais]\r    \r    if(sgvsConc != ''){\r       recargaCombo(\"Formulario.cbRegion\", \"REPRecargaRegiones\", \"es.indra.sicc.util.DTOString\",arr);\r    }     \r    \r   \r  \r  }\r  \r\r  function cambioRegion(){\r    \r    opciones = new Array();\r    \r	set_combo('Formulario.cbZona',opciones);\r   \r    combo_add('Formulario.cbZona', '', '');\r    var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r    var pais = get('Formulario.cbPais');\r    var regionConc = new String();\r    \r    for(i=0;i<regiones.length;i++){\r       regionConc += regiones[i] + \"x\";\r    }\r        \r    regionConc = regionConc.substring(0, regionConc.length-1);\r\r    \r    var arr = new Array();\r    arr[arr.length] = ['cadena', regionConc];\r    arr[arr.length] = ['oidPais', pais]\r    \r    if(regionConc != ''){\r       recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r    }     \r  }\r\r\r\r   \r    function cambioTipo(){\r         \r      opciones = new Array();\r      \r      set_combo('Formulario.cbSubtipoCliente',opciones);\r      set_combo('Formulario.cbTipoClasificacion',opciones);\r      set_combo('Formulario.cbClasificacion',opciones);\r     \r      tipo = get('Formulario.cbTipoCliente','V');\r      combo_add('Formulario.cbSubtipoCliente', '', '');\r       \r      for(var k=0;k<lstSubtipo.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){\r          if (lstSubtipo.datos.ij(k,1) == tipo[y]){ 			 \r            combo_add('Formulario.cbSubtipoCliente',lstSubtipo.datos.ij(k,0),lstSubtipo.datos.ij(k,2));\r          }\r        }\r      }\r    \r    }\r\r\r    function cambioSubtipo(){\r      \r      opciones = new Array();\r      \r      set_combo('Formulario.cbTipoClasificacion',opciones);\r      set_combo('Formulario.cbClasificacion',opciones);\r      \r      var subTipo = get('Formulario.cbSubtipoCliente','V');\r      combo_add('Formulario.cbTipoClasificacion', '', '');\r      \r      for(var k=0;k<lstTipoClasificacion.datos.longitud;k++) {\r        for(var y=0;y<subTipo.length;y++){\r          if (lstTipoClasificacion.datos.ij(k,1) == subTipo[y]){ 			 \r            combo_add('Formulario.cbTipoClasificacion',lstTipoClasificacion.datos.ij(k,0),lstTipoClasificacion.datos.ij(k,2));\r          }\r        }\r      }\r\r    }\r\r\r    function cambioTipoClasificacion(){\r      \r      opciones = new Array();\r      \r      set_combo('Formulario.cbClasificacion',opciones);\r\r      var tipoClasificacion = get('Formulario.cbTipoClasificacion','V');\r      combo_add('Formulario.cbClasificacion', '', '');\r      \r      for(var k=0;k<lstClasificacion.datos.longitud;k++) {\r        for(var y=0;y<tipoClasificacion.length;y++){\r          if (lstClasificacion.datos.ij(k,1) == tipoClasificacion[y]){ 			 \r            combo_add('Formulario.cbClasificacion',lstClasificacion.datos.ij(k,0),lstClasificacion.datos.ij(k,2));\r          }\r        }\r      }\r   \r   }\r\r\r    function cambioBaseCalculo(){\r\r      var baseCalculo = get('Formulario.cbBaseCalculo');\r      \r      if(baseCalculo == '1'){\r        accion('Formulario.cbMoneda', '.disabled = false');\r        sicc_cambiar_estado('cbMoneda', true);\r      }else{\r        accion('Formulario.cbMoneda', '.disabled = true');\r        sicc_cambiar_estado('cbMoneda', false);\r      }\r    \r    }\r\r\r\r   \r  \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

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
      ((Element)v.get(11)).setAttribute("name","cbBaseCalculo" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1181" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbNumConcurso" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1604" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbMoneda" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","1216" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbResultados" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","2717" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:6   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","Formulario" );
      ((Element)v.get(15)).setAttribute("oculto","N" );
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
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("nombre","idioma" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","monto" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","pais" );
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
      ((Element)v.get(45)).setAttribute("colspan","4" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
   }

   private void getXML180(Document doc) {
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
      ((Element)v.get(58)).setAttribute("onchange","onchangeMarcaCanalPais()" );
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
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(83)).setAttribute("onchange","onchangeMarcaCanalPais();" );
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
      ((Element)v.get(88)).setAttribute("onchange","onchangeMarcaCanalPais();onchangeCanal();" );
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
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:79   */

      /* Empieza nodo:92 / Elemento padre: 67   */
   }

   private void getXML360(Document doc) {
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
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:98   */

      /* Empieza nodo:105 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(109)).setAttribute("nombre","cbSubgerenciaVenta" );
      ((Element)v.get(109)).setAttribute("size","5" );
      ((Element)v.get(109)).setAttribute("multiple","S" );
      ((Element)v.get(109)).setAttribute("valorinicial","" );
      ((Element)v.get(109)).setAttribute("textoinicial","" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("onchange","cambioSubgerencia();" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:105   */

      /* Empieza nodo:113 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("colspan","4" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:116 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","25" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblZona" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("id","datosTitle" );
      ((Element)v.get(127)).setAttribute("cod","143" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:119   */

      /* Empieza nodo:130 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(134)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(134)).setAttribute("size","5" );
      ((Element)v.get(134)).setAttribute("multiple","S" );
      ((Element)v.get(134)).setAttribute("valorinicial","" );
      ((Element)v.get(134)).setAttribute("textoinicial","" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("onchange","cambioRegion();" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(139)).setAttribute("nombre","cbZona" );
      ((Element)v.get(139)).setAttribute("size","5" );
      ((Element)v.get(139)).setAttribute("multiple","S" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(139)).setAttribute("valorinicial","" );
      ((Element)v.get(139)).setAttribute("textoinicial","" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).setAttribute("req","N" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:141 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(130)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:130   */

      /* Empieza nodo:143 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","4" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:146 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(148)).setAttribute("border","0" );
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("cod","1338" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","25" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("id","datosTitle" );
      ((Element)v.get(157)).setAttribute("cod","588" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:149   */

      /* Empieza nodo:160 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(164)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(164)).setAttribute("size","5" );
      ((Element)v.get(164)).setAttribute("multiple","S" );
      ((Element)v.get(164)).setAttribute("valorinicial","" );
      ((Element)v.get(164)).setAttribute("textoinicial","" );
      ((Element)v.get(164)).setAttribute("id","datosCampos" );
      ((Element)v.get(164)).setAttribute("req","N" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:166 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(169)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(169)).setAttribute("size","5" );
      ((Element)v.get(169)).setAttribute("multiple","S" );
      ((Element)v.get(169)).setAttribute("valorinicial","" );
      ((Element)v.get(169)).setAttribute("textoinicial","" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).setAttribute("req","N" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:171 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(160)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:160   */

      /* Empieza nodo:173 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("colspan","4" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:176 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(178)).setAttribute("border","0" );
      ((Element)v.get(178)).setAttribute("align","left" );
      ((Element)v.get(178)).setAttribute("cellspacing","0" );
      ((Element)v.get(178)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","1622" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblBaseCalculo" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","1181" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:179   */

      /* Empieza nodo:190 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(194)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(194)).setAttribute("size","1" );
      ((Element)v.get(194)).setAttribute("multiple","N" );
      ((Element)v.get(194)).setAttribute("valorinicial","" );
      ((Element)v.get(194)).setAttribute("textoinicial","" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("req","S" );
      ((Element)v.get(194)).setAttribute("onchange","onchangeMarcaCanalPais();" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(196)).setAttribute("ID","1" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(197)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(197)).setAttribute("TIPO","STRING" );
      ((Element)v.get(197)).setAttribute("VALOR","3" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(198)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(198)).setAttribute("TIPO","STRING" );
      ((Element)v.get(198)).setAttribute("VALOR","Venta Catalogo" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:196   */

      /* Empieza nodo:199 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(199)).setAttribute("ID","2" );
      ((Element)v.get(195)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(200)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(200)).setAttribute("TIPO","STRING" );
      ((Element)v.get(200)).setAttribute("VALOR","1" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 199   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(201)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(201)).setAttribute("TIPO","STRING" );
      ((Element)v.get(201)).setAttribute("VALOR","Venta Neta" );
      ((Element)v.get(199)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(202)).setAttribute("ID","2" );
      ((Element)v.get(195)).appendChild((Element)v.get(202));

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
      ((Element)v.get(204)).setAttribute("VALOR","Venta Factura" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:202   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:205 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","25" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(190)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(208)).setAttribute("nombre","cbBaseCalculo" );
      ((Element)v.get(208)).setAttribute("size","1" );
      ((Element)v.get(208)).setAttribute("multiple","N" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(208)).setAttribute("valorinicial","" );
      ((Element)v.get(208)).setAttribute("textoinicial","" );
      ((Element)v.get(208)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).setAttribute("req","S" );
      ((Element)v.get(208)).setAttribute("onchange","cambioBaseCalculo();" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(210)).setAttribute("ID","1" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(211)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(211)).setAttribute("TIPO","STRING" );
      ((Element)v.get(211)).setAttribute("VALOR","1" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(212)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(212)).setAttribute("TIPO","STRING" );
      ((Element)v.get(212)).setAttribute("VALOR","Monto Ventas" );
      ((Element)v.get(210)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:210   */

      /* Empieza nodo:213 / Elemento padre: 209   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(213)).setAttribute("ID","2" );
      ((Element)v.get(209)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(214)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(214)).setAttribute("TIPO","STRING" );
      ((Element)v.get(214)).setAttribute("VALOR","2" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 213   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(215)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(215)).setAttribute("TIPO","STRING" );
      ((Element)v.get(215)).setAttribute("VALOR","Unidades Vendidas" );
      ((Element)v.get(213)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:213   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:216 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("width","100%" );
      ((Element)v.get(190)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:190   */

      /* Empieza nodo:218 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("colspan","4" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:221 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("table"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(223)).setAttribute("border","0" );
      ((Element)v.get(223)).setAttribute("align","left" );
      ((Element)v.get(223)).setAttribute("cellspacing","0" );
      ((Element)v.get(223)).setAttribute("cellpadding","0" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(228)).setAttribute("alto","13" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("id","datosTitle" );
      ((Element)v.get(228)).setAttribute("cod","1869" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","25" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(232)).setAttribute("alto","13" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("id","datosTitle" );
      ((Element)v.get(232)).setAttribute("cod","595" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(224)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:224   */

      /* Empieza nodo:235 / Elemento padre: 223   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(223)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(235)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(239)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(239)).setAttribute("size","5" );
      ((Element)v.get(239)).setAttribute("multiple","S" );
      ((Element)v.get(239)).setAttribute("valorinicial","" );
      ((Element)v.get(239)).setAttribute("textoinicial","" );
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(239)).setAttribute("req","N" );
      ((Element)v.get(239)).setAttribute("onchange","cambioTipo();" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:241 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(235)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(244)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(244)).setAttribute("size","5" );
      ((Element)v.get(244)).setAttribute("multiple","S" );
      ((Element)v.get(244)).setAttribute("valorinicial","" );
      ((Element)v.get(244)).setAttribute("textoinicial","" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("req","N" );
      ((Element)v.get(244)).setAttribute("onchange","cambioSubtipo();" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("width","100%" );
      ((Element)v.get(235)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:235   */

      /* Empieza nodo:248 / Elemento padre: 223   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(223)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("colspan","4" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:251 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("table"));
      ((Element)v.get(253)).setAttribute("width","100%" );
      ((Element)v.get(253)).setAttribute("border","0" );
      ((Element)v.get(253)).setAttribute("align","left" );
      ((Element)v.get(253)).setAttribute("cellspacing","0" );
      ((Element)v.get(253)).setAttribute("cellpadding","0" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("id","datosTitle" );
      ((Element)v.get(258)).setAttribute("cod","756" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("id","datosTitle" );
      ((Element)v.get(262)).setAttribute("cod","550" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(254)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:254   */

      /* Empieza nodo:265 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(269)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(269)).setAttribute("size","5" );
      ((Element)v.get(269)).setAttribute("multiple","S" );
      ((Element)v.get(269)).setAttribute("valorinicial","" );
      ((Element)v.get(269)).setAttribute("textoinicial","" );
      ((Element)v.get(269)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).setAttribute("req","N" );
      ((Element)v.get(269)).setAttribute("onchange","cambioTipoClasificacion();" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:271 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(265)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(274)).setAttribute("nombre","cbClasificacion" );
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

      /* Empieza nodo:276 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("width","100%" );
      ((Element)v.get(265)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:265   */

      /* Empieza nodo:278 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("colspan","4" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:281 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("table"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(283)).setAttribute("border","0" );
      ((Element)v.get(283)).setAttribute("align","left" );
      ((Element)v.get(283)).setAttribute("cellspacing","0" );
      ((Element)v.get(283)).setAttribute("cellpadding","0" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(288)).setAttribute("nombre","lblTiposOfertaAExcluir" );
      ((Element)v.get(288)).setAttribute("alto","13" );
      ((Element)v.get(288)).setAttribute("filas","1" );
      ((Element)v.get(288)).setAttribute("id","datosTitle" );
      ((Element)v.get(288)).setAttribute("cod","2688" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","25" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(292)).setAttribute("alto","13" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("id","datosTitle" );
      ((Element)v.get(292)).setAttribute("cod","1604" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","25" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblMonedaReferencia" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("id","datosTitle" );
      ((Element)v.get(296)).setAttribute("cod","2717" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(284)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:284   */

      /* Empieza nodo:299 / Elemento padre: 283   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(283)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(299)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(303)).setAttribute("nombre","cbTiposOfertaAExcluir" );
      ((Element)v.get(303)).setAttribute("size","5" );
      ((Element)v.get(303)).setAttribute("multiple","S" );
      ((Element)v.get(303)).setAttribute("valorinicial","" );
      ((Element)v.get(303)).setAttribute("textoinicial","" );
      ((Element)v.get(303)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).setAttribute("req","N" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:305 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(307)).setAttribute("valign","top" );
      ((Element)v.get(299)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(308)).setAttribute("nombre","cbNumConcurso" );
      ((Element)v.get(308)).setAttribute("size","1" );
      ((Element)v.get(308)).setAttribute("multiple","N" );
      ((Element)v.get(308)).setAttribute("valorinicial","" );
      ((Element)v.get(308)).setAttribute("textoinicial","" );
      ((Element)v.get(308)).setAttribute("id","datosCampos" );
      ((Element)v.get(308)).setAttribute("req","S" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:310 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(312)).setAttribute("valign","top" );
      ((Element)v.get(299)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(313)).setAttribute("nombre","cbMoneda" );
      ((Element)v.get(313)).setAttribute("size","1" );
      ((Element)v.get(313)).setAttribute("multiple","N" );
      ((Element)v.get(313)).setAttribute("valorinicial","" );
      ((Element)v.get(313)).setAttribute("textoinicial","" );
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).setAttribute("req","S" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:315 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("width","100%" );
      ((Element)v.get(299)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:299   */

      /* Empieza nodo:317 / Elemento padre: 283   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(283)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("colspan","4" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:320 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("table"));
      ((Element)v.get(322)).setAttribute("width","100%" );
      ((Element)v.get(322)).setAttribute("border","0" );
      ((Element)v.get(322)).setAttribute("align","left" );
      ((Element)v.get(322)).setAttribute("cellspacing","0" );
      ((Element)v.get(322)).setAttribute("cellpadding","0" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblResultados" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
      ((Element)v.get(327)).setAttribute("cod","2723" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","100%" );
      ((Element)v.get(323)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:323   */

      /* Empieza nodo:330 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","8" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(330)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(334)).setAttribute("nombre","cbResultados" );
      ((Element)v.get(334)).setAttribute("size","5" );
      ((Element)v.get(334)).setAttribute("multiple","S" );
      ((Element)v.get(334)).setAttribute("valorinicial","1" );
      ((Element)v.get(334)).setAttribute("textoinicial","1000" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(334)).setAttribute("req","S" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(336)).setAttribute("ID","2" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(337)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(337)).setAttribute("TIPO","STRING" );
      ((Element)v.get(337)).setAttribute("VALOR","2" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 336   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(338)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(338)).setAttribute("TIPO","STRING" );
      ((Element)v.get(338)).setAttribute("VALOR","1500" );
      ((Element)v.get(336)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:336   */

      /* Empieza nodo:339 / Elemento padre: 335   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(339)).setAttribute("ID","3" );
      ((Element)v.get(335)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(340)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(340)).setAttribute("TIPO","STRING" );
      ((Element)v.get(340)).setAttribute("VALOR","3" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 339   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(341)).setAttribute("TIPO","STRING" );
      ((Element)v.get(341)).setAttribute("VALOR","2000" );
      ((Element)v.get(339)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:339   */

      /* Empieza nodo:342 / Elemento padre: 335   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(342)).setAttribute("ID","4" );
      ((Element)v.get(335)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(343)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(343)).setAttribute("TIPO","STRING" );
      ((Element)v.get(343)).setAttribute("VALOR","4" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 342   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(344)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(344)).setAttribute("TIPO","STRING" );
      ((Element)v.get(344)).setAttribute("VALOR","2500" );
      ((Element)v.get(342)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:342   */

      /* Empieza nodo:345 / Elemento padre: 335   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(345)).setAttribute("ID","5" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(335)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(346)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(346)).setAttribute("TIPO","STRING" );
      ((Element)v.get(346)).setAttribute("VALOR","5" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(347)).setAttribute("TIPO","STRING" );
      ((Element)v.get(347)).setAttribute("VALOR","3000" );
      ((Element)v.get(345)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:345   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:348 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(330)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:330   */

      /* Empieza nodo:350 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("colspan","4" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:353 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("table"));
      ((Element)v.get(355)).setAttribute("width","100%" );
      ((Element)v.get(355)).setAttribute("border","0" );
      ((Element)v.get(355)).setAttribute("cellspacing","0" );
      ((Element)v.get(355)).setAttribute("cellpadding","0" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("width","12" );
      ((Element)v.get(357)).setAttribute("align","center" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","12" );
      ((Element)v.get(358)).setAttribute("height","12" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("width","750" );
      ((Element)v.get(356)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("width","12" );
      ((Element)v.get(356)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","12" );
      ((Element)v.get(362)).setAttribute("height","1" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:356   */

      /* Empieza nodo:363 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(368)).setAttribute("class","legend" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lblRangoPedidos" );
      ((Element)v.get(369)).setAttribute("alto","13" );
      ((Element)v.get(369)).setAttribute("filas","1" );
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("id","legend" );
      ((Element)v.get(369)).setAttribute("cod","00634" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("table"));
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(370)).setAttribute("border","0" );
      ((Element)v.get(370)).setAttribute("align","center" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(370)).setAttribute("cellspacing","0" );
      ((Element)v.get(370)).setAttribute("cellpadding","0" );
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("table"));
      ((Element)v.get(373)).setAttribute("width","100%" );
      ((Element)v.get(373)).setAttribute("border","0" );
      ((Element)v.get(373)).setAttribute("align","left" );
      ((Element)v.get(373)).setAttribute("cellspacing","0" );
      ((Element)v.get(373)).setAttribute("cellpadding","0" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("colspan","4" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:377 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(381)).setAttribute("nombre","lblDesde" );
      ((Element)v.get(381)).setAttribute("alto","13" );
      ((Element)v.get(381)).setAttribute("filas","1" );
      ((Element)v.get(381)).setAttribute("id","datosTitle" );
      ((Element)v.get(381)).setAttribute("cod","555" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","25" );
      ((Element)v.get(383)).setAttribute("height","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(385)).setAttribute("nombre","lblHasta" );
      ((Element)v.get(385)).setAttribute("alto","13" );
      ((Element)v.get(385)).setAttribute("filas","1" );
      ((Element)v.get(385)).setAttribute("id","datosTitle" );
      ((Element)v.get(385)).setAttribute("cod","145" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("width","100%" );
      ((Element)v.get(377)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:377   */

      /* Empieza nodo:388 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","8" );
      ((Element)v.get(390)).setAttribute("height","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(388)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(392)).setAttribute("nombre","cbDesde" );
      ((Element)v.get(392)).setAttribute("size","1" );
      ((Element)v.get(392)).setAttribute("multiple","N" );
      ((Element)v.get(392)).setAttribute("valorinicial","" );
      ((Element)v.get(392)).setAttribute("textoinicial","" );
      ((Element)v.get(392)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).setAttribute("req","N" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(394)).setAttribute("ID","1" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(395)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(395)).setAttribute("TIPO","STRING" );
      ((Element)v.get(395)).setAttribute("VALOR","1" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 394   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(396)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(396)).setAttribute("TIPO","STRING" );
      ((Element)v.get(396)).setAttribute("VALOR","1" );
      ((Element)v.get(394)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:394   */

      /* Empieza nodo:397 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(397)).setAttribute("ID","2" );
      ((Element)v.get(393)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(398)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(398)).setAttribute("TIPO","STRING" );
      ((Element)v.get(398)).setAttribute("VALOR","2" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 397   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(399)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(399)).setAttribute("TIPO","STRING" );
      ((Element)v.get(399)).setAttribute("VALOR","2" );
      ((Element)v.get(397)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:397   */

      /* Empieza nodo:400 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(400)).setAttribute("ID","3" );
      ((Element)v.get(393)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(401)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(401)).setAttribute("TIPO","STRING" );
      ((Element)v.get(401)).setAttribute("VALOR","3" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 400   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(402)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(402)).setAttribute("TIPO","STRING" );
      ((Element)v.get(402)).setAttribute("VALOR","3" );
      ((Element)v.get(400)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:400   */

      /* Empieza nodo:403 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(403)).setAttribute("ID","4" );
      ((Element)v.get(393)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(404)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(404)).setAttribute("TIPO","STRING" );
      ((Element)v.get(404)).setAttribute("VALOR","4" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(405)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(405)).setAttribute("TIPO","STRING" );
      ((Element)v.get(405)).setAttribute("VALOR","4" );
      ((Element)v.get(403)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:403   */

      /* Empieza nodo:406 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(406)).setAttribute("ID","5" );
      ((Element)v.get(393)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(407)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(407)).setAttribute("TIPO","STRING" );
      ((Element)v.get(407)).setAttribute("VALOR","5" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(408)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(408)).setAttribute("TIPO","STRING" );
      ((Element)v.get(408)).setAttribute("VALOR","5" );
      ((Element)v.get(406)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:406   */

      /* Empieza nodo:409 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(409)).setAttribute("ID","6" );
      ((Element)v.get(393)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(410)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(410)).setAttribute("TIPO","STRING" );
      ((Element)v.get(410)).setAttribute("VALOR","6" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(411)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(411)).setAttribute("TIPO","STRING" );
      ((Element)v.get(411)).setAttribute("VALOR","6" );
      ((Element)v.get(409)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(412)).setAttribute("ID","7" );
      ((Element)v.get(393)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(413)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(413)).setAttribute("TIPO","STRING" );
      ((Element)v.get(413)).setAttribute("VALOR","7" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(414)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(414)).setAttribute("TIPO","STRING" );
      ((Element)v.get(414)).setAttribute("VALOR","7" );
      ((Element)v.get(412)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 393   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(415)).setAttribute("ID","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(417)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(417)).setAttribute("TIPO","STRING" );
      ((Element)v.get(417)).setAttribute("VALOR","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:415   */

      /* Empieza nodo:418 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(418)).setAttribute("ID","9" );
      ((Element)v.get(393)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","9" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(420)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(420)).setAttribute("TIPO","STRING" );
      ((Element)v.get(420)).setAttribute("VALOR","9" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:418   */

      /* Empieza nodo:421 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).setAttribute("ID","10" );
      ((Element)v.get(393)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","10" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(423)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(423)).setAttribute("TIPO","STRING" );
      ((Element)v.get(423)).setAttribute("VALOR","10" );
      ((Element)v.get(421)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:421   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:424 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","25" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(388)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(427)).setAttribute("nombre","cbHasta" );
      ((Element)v.get(427)).setAttribute("size","1" );
      ((Element)v.get(427)).setAttribute("multiple","N" );
      ((Element)v.get(427)).setAttribute("valorinicial","" );
      ((Element)v.get(427)).setAttribute("textoinicial","" );
      ((Element)v.get(427)).setAttribute("id","datosCampos" );
      ((Element)v.get(427)).setAttribute("req","N" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(429)).setAttribute("ID","1" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(430)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(430)).setAttribute("TIPO","STRING" );
      ((Element)v.get(430)).setAttribute("VALOR","1" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 429   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(431)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(431)).setAttribute("TIPO","STRING" );
      ((Element)v.get(431)).setAttribute("VALOR","1" );
      ((Element)v.get(429)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:429   */

      /* Empieza nodo:432 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(432)).setAttribute("ID","2" );
      ((Element)v.get(428)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(433)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(433)).setAttribute("VALOR","2" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(434)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(434)).setAttribute("TIPO","STRING" );
      ((Element)v.get(434)).setAttribute("VALOR","2" );
      ((Element)v.get(432)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:432   */

      /* Empieza nodo:435 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(435)).setAttribute("ID","3" );
      ((Element)v.get(428)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(436)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","3" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(437)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(437)).setAttribute("TIPO","STRING" );
      ((Element)v.get(437)).setAttribute("VALOR","3" );
      ((Element)v.get(435)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(438)).setAttribute("ID","4" );
      ((Element)v.get(428)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","4" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(440)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(440)).setAttribute("TIPO","STRING" );
      ((Element)v.get(440)).setAttribute("VALOR","4" );
      ((Element)v.get(438)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(441)).setAttribute("ID","5" );
      ((Element)v.get(428)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","5" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(443)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(443)).setAttribute("TIPO","STRING" );
      ((Element)v.get(443)).setAttribute("VALOR","5" );
      ((Element)v.get(441)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:441   */

      /* Empieza nodo:444 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(444)).setAttribute("ID","6" );
      ((Element)v.get(428)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(445)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(445)).setAttribute("TIPO","STRING" );
      ((Element)v.get(445)).setAttribute("VALOR","6" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(446)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(446)).setAttribute("TIPO","STRING" );
      ((Element)v.get(446)).setAttribute("VALOR","6" );
      ((Element)v.get(444)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:444   */

      /* Empieza nodo:447 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(447)).setAttribute("ID","7" );
      ((Element)v.get(428)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(448)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(448)).setAttribute("TIPO","STRING" );
      ((Element)v.get(448)).setAttribute("VALOR","7" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(449)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(449)).setAttribute("TIPO","STRING" );
      ((Element)v.get(449)).setAttribute("VALOR","7" );
      ((Element)v.get(447)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:447   */

      /* Empieza nodo:450 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(450)).setAttribute("ID","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(451)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(451)).setAttribute("TIPO","STRING" );
      ((Element)v.get(451)).setAttribute("VALOR","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(452)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(452)).setAttribute("TIPO","STRING" );
      ((Element)v.get(452)).setAttribute("VALOR","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(453)).setAttribute("ID","9" );
      ((Element)v.get(428)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(454)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(454)).setAttribute("TIPO","STRING" );
      ((Element)v.get(454)).setAttribute("VALOR","9" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(455)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(455)).setAttribute("TIPO","STRING" );
      ((Element)v.get(455)).setAttribute("VALOR","9" );
      ((Element)v.get(453)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:453   */

      /* Empieza nodo:456 / Elemento padre: 428   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(456)).setAttribute("ID","10" );
      ((Element)v.get(428)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(457)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(457)).setAttribute("TIPO","STRING" );
      ((Element)v.get(457)).setAttribute("VALOR","10" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 456   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(458)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(458)).setAttribute("TIPO","STRING" );
      ((Element)v.get(458)).setAttribute("VALOR","10" );
      ((Element)v.get(456)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:456   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:459 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).setAttribute("width","100%" );
      ((Element)v.get(388)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","8" );
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:388   */

      /* Empieza nodo:461 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("colspan","4" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:464 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:363   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:466 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("colspan","4" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","12" );
      ((Element)v.get(468)).setAttribute("height","12" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:469 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(470)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:33   */

      /* Empieza nodo:471 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("table"));
      ((Element)v.get(476)).setAttribute("width","100%" );
      ((Element)v.get(476)).setAttribute("border","0" );
      ((Element)v.get(476)).setAttribute("align","center" );
      ((Element)v.get(476)).setAttribute("cellspacing","0" );
      ((Element)v.get(476)).setAttribute("cellpadding","0" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(476)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).setAttribute("class","botonera" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(479)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(479)).setAttribute("ID","botonContenido" );
      ((Element)v.get(479)).setAttribute("tipo","html" );
      ((Element)v.get(479)).setAttribute("accion","generar('pdf');" );
      ((Element)v.get(479)).setAttribute("estado","false" );
      ((Element)v.get(479)).setAttribute("cod","2495" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 478   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(480)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(480)).setAttribute("ID","botonContenido" );
      ((Element)v.get(480)).setAttribute("tipo","html" );
      ((Element)v.get(480)).setAttribute("accion","generar('xls')" );
      ((Element)v.get(480)).setAttribute("estado","false" );
      ((Element)v.get(480)).setAttribute("cod","2526" );
      ((Element)v.get(480)).setAttribute("ontab","focaliza('Formulario.cbPais')" );
      ((Element)v.get(478)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:481 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(482)).setAttribute("height","12" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:471   */

      /* Empieza nodo:483 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).setAttribute("width","12" );
      ((Element)v.get(484)).setAttribute("align","center" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","12" );
      ((Element)v.get(485)).setAttribute("height","12" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).setAttribute("width","756" );
      ((Element)v.get(483)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).setAttribute("width","12" );
      ((Element)v.get(483)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","12" );
      ((Element)v.get(489)).setAttribute("height","1" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:483   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:490 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(490)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(490)).setAttribute("alto","3" );
      ((Element)v.get(490)).setAttribute("ancho","624" );
      ((Element)v.get(490)).setAttribute("colorf","" );
      ((Element)v.get(490)).setAttribute("borde","0" );
      ((Element)v.get(490)).setAttribute("imagenf","" );
      ((Element)v.get(490)).setAttribute("repeat","" );
      ((Element)v.get(490)).setAttribute("padding","" );
      ((Element)v.get(490)).setAttribute("visibilidad","visible" );
      ((Element)v.get(490)).setAttribute("contravsb","" );
      ((Element)v.get(490)).setAttribute("x","0" );
      ((Element)v.get(490)).setAttribute("y","165" );
      ((Element)v.get(490)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(491)).setAttribute("seleccion","boton" );
      ((Element)v.get(491)).setAttribute("nombre","lstSubtipo" );
      ((Element)v.get(491)).setAttribute("x","12" );
      ((Element)v.get(491)).setAttribute("y","10" );
      ((Element)v.get(491)).setAttribute("ancho","600" );
      ((Element)v.get(491)).setAttribute("alto","3" );
      ((Element)v.get(491)).setAttribute("multisel","-1" );
      ((Element)v.get(491)).setAttribute("incy","10" );
      ((Element)v.get(491)).setAttribute("incx","10" );
      ((Element)v.get(491)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(491)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(491)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(491)).setAttribute("accion","" );
      ((Element)v.get(491)).setAttribute("sep","|" );
      ((Element)v.get(491)).setAttribute("pixelsborde","2" );
      ((Element)v.get(491)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(492)).setAttribute("nombre","cab1" );
      ((Element)v.get(492)).setAttribute("height","20" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(493)).setAttribute("ancho","40" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(494)).setAttribute("ancho","60" );
      ((Element)v.get(492)).appendChild((Element)v.get(494));

      /* Elemento padre:494 / Elemento actual: 495   */
      v.add(doc.createTextNode("Subtipo"));
      ((Element)v.get(494)).appendChild((Text)v.get(495));

      /* Termina nodo Texto:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(496)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(496)).setAttribute("ancho","440" );
      ((Element)v.get(492)).appendChild((Element)v.get(496));

      /* Elemento padre:496 / Elemento actual: 497   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(496)).appendChild((Text)v.get(497));

      /* Termina nodo Texto:497   */
      /* Termina nodo:496   */
      /* Termina nodo:492   */

      /* Empieza nodo:498 / Elemento padre: 491   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(498)).setAttribute("ancho","590" );
      ((Element)v.get(498)).setAttribute("filas","1" );
      ((Element)v.get(498)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(491)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(499)).setAttribute("ancho","40" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(499)).setAttribute("caracteres","20" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 498   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("ancho","60" );
      ((Element)v.get(500)).setAttribute("caracteres","20" );
      ((Element)v.get(498)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 498   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(501)).setAttribute("ancho","440" );
      ((Element)v.get(501)).setAttribute("caracteres","30" );
      ((Element)v.get(498)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:498   */

      /* Empieza nodo:502 / Elemento padre: 491   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(491)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:503 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(503)).setAttribute("nombre","capaTipoClasificacion" );
      ((Element)v.get(503)).setAttribute("alto","3" );
      ((Element)v.get(503)).setAttribute("ancho","624" );
      ((Element)v.get(503)).setAttribute("colorf","" );
      ((Element)v.get(503)).setAttribute("borde","0" );
      ((Element)v.get(503)).setAttribute("imagenf","" );
      ((Element)v.get(503)).setAttribute("repeat","" );
      ((Element)v.get(503)).setAttribute("padding","" );
      ((Element)v.get(503)).setAttribute("visibilidad","visible" );
      ((Element)v.get(503)).setAttribute("contravsb","" );
      ((Element)v.get(503)).setAttribute("x","0" );
      ((Element)v.get(503)).setAttribute("y","165" );
      ((Element)v.get(503)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(504)).setAttribute("seleccion","boton" );
      ((Element)v.get(504)).setAttribute("nombre","lstTipoClasificacion" );
      ((Element)v.get(504)).setAttribute("x","12" );
      ((Element)v.get(504)).setAttribute("y","10" );
      ((Element)v.get(504)).setAttribute("ancho","600" );
      ((Element)v.get(504)).setAttribute("alto","3" );
      ((Element)v.get(504)).setAttribute("multisel","-1" );
      ((Element)v.get(504)).setAttribute("incy","10" );
      ((Element)v.get(504)).setAttribute("incx","10" );
      ((Element)v.get(504)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(504)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(504)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(504)).setAttribute("accion","" );
      ((Element)v.get(504)).setAttribute("sep","|" );
      ((Element)v.get(504)).setAttribute("pixelsborde","2" );
      ((Element)v.get(504)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(505)).setAttribute("nombre","cab1" );
      ((Element)v.get(505)).setAttribute("height","20" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(506)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(506)).setAttribute("ancho","40" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(507)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(507)).setAttribute("ancho","60" );
      ((Element)v.get(505)).appendChild((Element)v.get(507));

      /* Elemento padre:507 / Elemento actual: 508   */
      v.add(doc.createTextNode("TipoClasificacion"));
      ((Element)v.get(507)).appendChild((Text)v.get(508));

      /* Termina nodo Texto:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(509)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(509)).setAttribute("ancho","440" );
      ((Element)v.get(505)).appendChild((Element)v.get(509));

      /* Elemento padre:509 / Elemento actual: 510   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(509)).appendChild((Text)v.get(510));

      /* Termina nodo Texto:510   */
      /* Termina nodo:509   */
      /* Termina nodo:505   */

      /* Empieza nodo:511 / Elemento padre: 504   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(511)).setAttribute("ancho","590" );
      ((Element)v.get(511)).setAttribute("filas","1" );
      ((Element)v.get(511)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(504)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("ancho","40" );
      ((Element)v.get(512)).setAttribute("caracteres","20" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 511   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(513)).setAttribute("ancho","60" );
      ((Element)v.get(513)).setAttribute("caracteres","20" );
      ((Element)v.get(511)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 511   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("ancho","440" );
      ((Element)v.get(514)).setAttribute("caracteres","30" );
      ((Element)v.get(511)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:511   */

      /* Empieza nodo:515 / Elemento padre: 504   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(504)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:516 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(516)).setAttribute("nombre","capaClasificacion" );
      ((Element)v.get(516)).setAttribute("alto","3" );
      ((Element)v.get(516)).setAttribute("ancho","624" );
      ((Element)v.get(516)).setAttribute("colorf","" );
      ((Element)v.get(516)).setAttribute("borde","0" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(516)).setAttribute("imagenf","" );
      ((Element)v.get(516)).setAttribute("repeat","" );
      ((Element)v.get(516)).setAttribute("padding","" );
      ((Element)v.get(516)).setAttribute("visibilidad","visible" );
      ((Element)v.get(516)).setAttribute("contravsb","" );
      ((Element)v.get(516)).setAttribute("x","0" );
      ((Element)v.get(516)).setAttribute("y","165" );
      ((Element)v.get(516)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(517)).setAttribute("seleccion","boton" );
      ((Element)v.get(517)).setAttribute("nombre","lstClasificacion" );
      ((Element)v.get(517)).setAttribute("x","12" );
      ((Element)v.get(517)).setAttribute("y","10" );
      ((Element)v.get(517)).setAttribute("ancho","600" );
      ((Element)v.get(517)).setAttribute("alto","3" );
      ((Element)v.get(517)).setAttribute("multisel","-1" );
      ((Element)v.get(517)).setAttribute("incy","10" );
      ((Element)v.get(517)).setAttribute("incx","10" );
      ((Element)v.get(517)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(517)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(517)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(517)).setAttribute("accion","" );
      ((Element)v.get(517)).setAttribute("sep","|" );
      ((Element)v.get(517)).setAttribute("pixelsborde","2" );
      ((Element)v.get(517)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(518)).setAttribute("nombre","cab1" );
      ((Element)v.get(518)).setAttribute("height","20" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(519)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(519)).setAttribute("ancho","40" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(520)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(520)).setAttribute("ancho","60" );
      ((Element)v.get(518)).appendChild((Element)v.get(520));

      /* Elemento padre:520 / Elemento actual: 521   */
      v.add(doc.createTextNode("Clasificacion"));
      ((Element)v.get(520)).appendChild((Text)v.get(521));

      /* Termina nodo Texto:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(522)).setAttribute("ancho","440" );
      ((Element)v.get(518)).appendChild((Element)v.get(522));

      /* Elemento padre:522 / Elemento actual: 523   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(522)).appendChild((Text)v.get(523));

      /* Termina nodo Texto:523   */
      /* Termina nodo:522   */
      /* Termina nodo:518   */

      /* Empieza nodo:524 / Elemento padre: 517   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(524)).setAttribute("ancho","590" );
      ((Element)v.get(524)).setAttribute("filas","1" );
      ((Element)v.get(524)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(517)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(525)).setAttribute("ancho","40" );
      ((Element)v.get(525)).setAttribute("caracteres","20" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */

      /* Empieza nodo:526 / Elemento padre: 524   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(526)).setAttribute("ancho","60" );
      ((Element)v.get(526)).setAttribute("caracteres","20" );
      ((Element)v.get(524)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 524   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(527)).setAttribute("ancho","440" );
      ((Element)v.get(527)).setAttribute("caracteres","30" );
      ((Element)v.get(524)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:524   */

      /* Empieza nodo:528 / Elemento padre: 517   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(517)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:15   */


   }

}
