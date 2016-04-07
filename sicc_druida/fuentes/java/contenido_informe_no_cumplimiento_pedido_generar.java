
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_no_cumplimiento_pedido_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_no_cumplimiento_pedido_generar" );
      ((Element)v.get(0)).setAttribute("cod","0886" );
      ((Element)v.get(0)).setAttribute("titulo","Generar Informe No cumplimiento de constancia un Pedido" );
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
      v.add(doc.createTextNode("\r\r  \r\r    function onLoad(){\r    \r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      setearPais();\r      cambioPais();\r	  cargoComboMonto();\r      focaliza('Formulario.cbPais');\r      accion('Formulario.cbMoneda', '.disabled = true');\r    \r    }\r\r	\r  	function cargoComboMonto(){\r   var monto     = get('Formulario.monto');\r   var arr = new Array();\r   \r   arr[arr.length] = ['1000','1000'];\r   arr[arr.length] = ['1500','1500'];\r   arr[arr.length] = ['2000','2000'];\r   arr[arr.length] = ['2500','2500'];\r   arr[arr.length] = ['3000','3000'];\r\r   if(monto > 3000){\r      for(var k=4000;k<=monto;k+=1000) {\r	      arr[arr.length] = [k+'',k+''];   \r      }\r	}\r   \r      set_combo('Formulario.cbResultados',arr);\r}\r\r	  function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r\r\r    function cambioPais(){\r      \r      pais  = get('Formulario.cbPais');\r      idioma = get('Formulario.idioma');\r      \r      if(pais != ''){\r      \r         var arr = new Array();\r         \r         arr[arr.length] = [\"oidPais\", pais];\r         arr[arr.length] = [\"oidIdioma\", idioma];\r         \r         recargaCombo('Formulario.cbUnidadNegocio','MAEObtenerUnidadesNegocioPorPais','es.indra.sicc.util.DTOBelcorp',arr);\r         recargaCombo('Formulario.cbNegocio','MAEObtenerNegocioPorPais','es.indra.sicc.util.DTOBelcorp',arr);\r         \r      }else{\r         \r         var aCombo = new Array(new Array(\"\",\"\"));\r         \r         set_combo('Formulario.cbUnidadNegocio',aCombo, []);\r         set_combo('Formulario.cbNegocio',aCombo, []);\r      \r      }\r      \r    }\r\r\r    function generar(formato){\r      \r      if(sicc_validaciones_generales()){\r        \r        var a = new Object();\r        a.accion = 'generar';\r        \r        a.pais = get('Formulario.cbPais');  \r        a.marca = get('Formulario.cbMarca');\r        a.canal = get('Formulario.cbCanal');\r        a.sgv = quitarItemVacio(get('Formulario.cbSubgerenciaVentas'));\r        a.region = quitarItemVacio(get('Formulario.cbRegion'));\r        a.zona = quitarItemVacio(get('Formulario.cbZona'));\r        a.tipoOfertaExcluir = quitarItemVacio(get('Formulario.cbTiposOfertaAExcluir'));\r        a.tipoCliente = quitarItemVacio(get('Formulario.cbTipoCliente'));\r        a.subtipoCliente = quitarItemVacio(get('Formulario.cbSubtipoCliente'));\r        a.tipoClasificacion = quitarItemVacio(get('Formulario.cbTipoClasificacionCliente'));\r        a.clasificacion = quitarItemVacio(get('Formulario.cbClasificacionCliente'));\r        a.tipoVenta = get('Formulario.cbTipoVenta');\r        a.baseCalculo = get('Formulario.cbBaseCalculo');\r        a.unidadNegocio = quitarItemVacio(get('Formulario.cbUnidadNegocio'));\r        a.negocio = quitarItemVacio(get('Formulario.cbNegocio'));\r        a.nroConcurso = get('Formulario.cbNumConcurso');\r        a.moneda = get('Formulario.cbMoneda');\r        a.resultados = quitarItemVacio(get('Formulario.cbResultados', 'T'));\r        a.rangoDesde = get('Formulario.cbDesde');\r        a.rangoHasta = get('Formulario.cbHasta');\r        \r        a.formato = formato;\r        mostrarModalSICC('INCNoCumplimientoConstanciaPedido','generar', a);\r        \r      }\r      \r    }\r\r\r    function fLimpiar(){\r    \r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbSubgerenciaVenta', aCombo, []);\r      set_combo('Formulario.cbRegion', aCombo, []);\r      set_combo('Formulario.cbZona', aCombo, []);\r      set_combo('Formulario.cbNegocio', aCombo, []);\r      set_combo('Formulario.cbUnidadNegocio', aCombo, []);\r      set_combo('Formulario.cbNumConcurso', aCombo, []);\r      set_combo('Formulario.cbSubtipoCliente', aCombo, []);\r      set_combo('Formulario.cbClasificacion', aCombo, []);\r      set_combo('Formulario.cbTipoClasificacion', aCombo, []);\r      set_combo('Formulario.cbTiposOfertaAExcluir', aCombo, []);\r      \r      focaliza('Formulario.cbPais');\r      \r   }\r\r\r    function setearPais(){\r    \r      var pais = get('Formulario.pais');\r      \r      iSeleccionado = new Array(); \r      iSeleccionado[0] = pais;\r      set('Formulario.cbPais',iSeleccionado);\r\r    }\r\r\r    function onchangeMarcaCanalPais(){\r      \r      var pais  = get('Formulario.cbPais');\r      var marca = get('Formulario.cbMarca');\r      var canal = get('Formulario.cbCanal');\r      var tipoVenta = get('Formulario.cbTipoVenta');\r      \r      if(pais != '' && marca != '' && canal != ''){\r      \r        var arr2 = new Array();\r        \r        arr2[arr2.length] = [\"oidPais\", pais]; \r        arr2[arr2.length] = [\"oidMarca\", marca];\r        arr2[arr2.length] = [\"oidCanal\", canal];\r        \r        var arrConcurso = new Array();\r        \r        arrConcurso[arrConcurso.length] = [\"oidPais\", pais]; \r        arrConcurso[arrConcurso.length] = [\"oidMarca\", marca];\r        arrConcurso[arrConcurso.length] = [\"oidCanal\", canal];\r        arrConcurso[arrConcurso.length] = [\"oidTipoCliente\", tipoVenta];\r        arrConcurso[arrConcurso.length] = [\"oidAgrugacion\", \"5\"];\r        \r        recargaCombo('Formulario.cbSubgerenciaVenta', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr2 );\r        \r        if(tipoVenta != ''){\r           recargaCombo('Formulario.cbNumConcurso','INCObtenerConcursosREP', 'es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado',arrConcurso );\r        }\r      \r      }else{\r      \r        var aCombo = new Array(new Array(\"\",\"\"));\r        set_combo('Formulario.cbSubgerenciaVenta', aCombo, []);\r        set_combo('Formulario.cbRegion', aCombo, []);\r        set_combo('Formulario.cbZona', aCombo, []);\r        set_combo('Formulario.cbNumConcurso', aCombo, []);\r      \r      }\r      \r   }\r\r\r    function onchangeCanal(){\r\r      var canal  = get('Formulario.cbCanal');\r      var idioma = get('Formulario.idioma');\r      \r      if(canal != ''){\r      \r        var arr = new Array();\r        arr[arr.length] = [\"oid\", canal];\r        arr[arr.length] = [\"oidIdioma\", idioma];\r        \r        recargaCombo(\"Formulario.cbTiposOfertaAExcluir\",\"PREObtenerTiposOfertaPorCanal\", \"es.indra.sicc.util.DTOOID\",arr); \r     \r      }else{\r        \r        var aCombo = new Array(new Array(\"\",\"\"));\r        set_combo('Formulario.cbTiposOfertaAExcluir', aCombo, []);\r        \r      }\r      \r    }\r\r\r  function cambioSubgerencia(){\r    \r    opciones = new Array();\r    set_combo('Formulario.cbRegion',opciones);\r    set_combo('Formulario.cbZona',opciones);\r   \r    combo_add('Formulario.cbRegion', '', '');\r    var sgvs = quitarItemVacio(get('Formulario.cbSubgerenciaVenta'));\r    var pais = get('Formulario.cbPais');\r    var sgvsConc = new String();\r    \r    for(i=0;i<sgvs.length;i++){\r       sgvsConc += sgvs[i] + \"x\";\r    }\r        \r    sgvsConc = sgvsConc.substring(0, sgvsConc.length-1);\r\r    \r    var arr = new Array();\r    arr[arr.length] = ['cadena', sgvsConc];\r    arr[arr.length] = ['oidPais', pais]\r    \r    if(sgvsConc != ''){\r       recargaCombo(\"Formulario.cbRegion\", \"REPRecargaRegiones\", \"es.indra.sicc.util.DTOString\",arr);\r    }     \r    \r   \r  \r  }\r  \r\r  function cambioRegion(){\r    \r    opciones = new Array();\r    \r	set_combo('Formulario.cbZona',opciones);\r   \r    combo_add('Formulario.cbZona', '', '');\r    var regiones = quitarItemVacio(get('Formulario.cbRegion'));\r    var pais = get('Formulario.cbPais');\r    var regionConc = new String();\r    \r    for(i=0;i<regiones.length;i++){\r       regionConc += regiones[i] + \"x\";\r    }\r        \r    regionConc = regionConc.substring(0, regionConc.length-1);\r\r    \r    var arr = new Array();\r    arr[arr.length] = ['cadena', regionConc];\r    arr[arr.length] = ['oidPais', pais]\r    \r    if(regionConc != ''){\r       recargaCombo(\"Formulario.cbZona\", \"REPRecargaZonas\", \"es.indra.sicc.util.DTOString\",arr);\r    }     \r  }\r\r\r\r    function cambioTipo(){\r    \r      opciones = new Array();\r      set_combo('Formulario.cbSubtipoCliente',opciones);\r      set_combo('Formulario.cbTipoClasificacionCliente',opciones);\r      set_combo('Formulario.cbClasificacionCliente',opciones);\r      tipo = get('Formulario.cbTipoCliente','V');\r      combo_add('Formulario.cbSubtipoCliente', '', '');\r      \r      for(var k=0;k<lstSubtipo.datos.longitud;k++) {\r        for(var y=0;y<tipo.length;y++){\r          if (lstSubtipo.datos.ij(k,1) == tipo[y]){ 			 \r            combo_add('Formulario.cbSubtipoCliente',lstSubtipo.datos.ij(k,0),lstSubtipo.datos.ij(k,2));\r          }\r        }\r      }\r  \r    }\r\r\r    function cambioSubtipo(){\r      \r      opciones = new Array();\r      set_combo('Formulario.cbTipoClasificacionCliente',opciones);\r      set_combo('Formulario.cbClasificacionCliente',opciones);\r      var subTipo = get('Formulario.cbSubtipoCliente','V');\r      combo_add('Formulario.cbTipoClasificacionCliente', '', '');\r     \r      for(var k=0;k<lstTipoClasificacion.datos.longitud;k++) {\r        for(var y=0;y<subTipo.length;y++){\r          if (lstTipoClasificacion.datos.ij(k,1) == subTipo[y]){ 			 \r            combo_add('Formulario.cbTipoClasificacionCliente',lstTipoClasificacion.datos.ij(k,0),lstTipoClasificacion.datos.ij(k,2));\r          }\r        }\r      }\r\r    }\r\r\r    function cambioTipoClasificacion(){\r    \r      opciones = new Array();\r      set_combo('Formulario.cbClasificacionCliente',opciones);                      \r      var tipoClasificacion = get('Formulario.cbTipoClasificacionCliente','V');\r      combo_add('Formulario.cbClasificacionCliente', '', '');\r        \r      for(var k=0;k<lstClasificacion.datos.longitud;k++) {\r        for(var y=0;y<tipoClasificacion.length;y++){\r          if (lstClasificacion.datos.ij(k,1) == tipoClasificacion[y]){ 			 \r            combo_add('Formulario.cbClasificacionCliente',lstClasificacion.datos.ij(k,0),lstClasificacion.datos.ij(k,2));\r          }\r        }\r      }\r      \r    }\r\r\r    function cambioBaseCalculo(){\r    \r      var baseCalculo = get('Formulario.cbBaseCalculo');\r      \r      if(baseCalculo == '1'){\r        accion('Formulario.cbMoneda', '.disabled = false');\r        sicc_cambiar_estado('cbMoneda', true);\r      }else{\r        accion('Formulario.cbMoneda', '.disabled = true');\r        sicc_cambiar_estado('cbMoneda', false);\r      }\r    \r    }\r\r\r  \r  \r"));
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
      ((Element)v.get(22)).setAttribute("nombre","pais" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","monto" );
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
      ((Element)v.get(58)).setAttribute("onchange","onchangeMarcaCanalPais();cambioPais()" );
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
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(88)).setAttribute("onchange","onchangeMarcaCanalPais(); onchangeCanal()" );
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
   }

   private void getXML360(Document doc) {
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
   }

   private void getXML450(Document doc) {
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
   }

   private void getXML540(Document doc) {
      ((Element)v.get(139)).setAttribute("multiple","S" );
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
      ((Element)v.get(153)).setAttribute("nombre","lblTiposOfertaAExcluir" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("cod","2688" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:149   */

      /* Empieza nodo:156 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(160)).setAttribute("nombre","cbTiposOfertaAExcluir" );
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

      /* Empieza nodo:162 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:156   */

      /* Empieza nodo:164 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(164));

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
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

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
      ((Element)v.get(174)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","1869" );
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
      ((Element)v.get(178)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","595" );
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
      ((Element)v.get(185)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(185)).setAttribute("size","5" );
      ((Element)v.get(185)).setAttribute("multiple","S" );
      ((Element)v.get(185)).setAttribute("valorinicial","" );
      ((Element)v.get(185)).setAttribute("textoinicial","" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("req","N" );
      ((Element)v.get(185)).setAttribute("onchange","cambioTipo();" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML720(Document doc) {
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
      ((Element)v.get(181)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(190)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(190)).setAttribute("size","5" );
      ((Element)v.get(190)).setAttribute("multiple","S" );
      ((Element)v.get(190)).setAttribute("valorinicial","" );
      ((Element)v.get(190)).setAttribute("textoinicial","" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("req","N" );
      ((Element)v.get(190)).setAttribute("onchange","cambioSubtipo();" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:192 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(181)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:181   */

      /* Empieza nodo:194 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("colspan","4" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:197 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("table"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(199)).setAttribute("border","0" );
      ((Element)v.get(199)).setAttribute("align","left" );
      ((Element)v.get(199)).setAttribute("cellspacing","0" );
      ((Element)v.get(199)).setAttribute("cellpadding","0" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(204)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(204)).setAttribute("alto","13" );
      ((Element)v.get(204)).setAttribute("filas","1" );
      ((Element)v.get(204)).setAttribute("id","datosTitle" );
      ((Element)v.get(204)).setAttribute("cod","756" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","25" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(208)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(208)).setAttribute("alto","13" );
      ((Element)v.get(208)).setAttribute("filas","1" );
      ((Element)v.get(208)).setAttribute("id","datosTitle" );
      ((Element)v.get(208)).setAttribute("cod","550" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","100%" );
      ((Element)v.get(200)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:200   */

      /* Empieza nodo:211 / Elemento padre: 199   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(199)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(211)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(215)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(215)).setAttribute("size","5" );
      ((Element)v.get(215)).setAttribute("multiple","S" );
      ((Element)v.get(215)).setAttribute("valorinicial","" );
      ((Element)v.get(215)).setAttribute("textoinicial","" );
      ((Element)v.get(215)).setAttribute("id","datosCampos" );
      ((Element)v.get(215)).setAttribute("req","N" );
      ((Element)v.get(215)).setAttribute("onchange","cambioTipoClasificacion();" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:217 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(211)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(220)).setAttribute("nombre","cbClasificacionCliente" );
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

      /* Empieza nodo:222 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(211)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:211   */

      /* Empieza nodo:224 / Elemento padre: 199   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(199)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("colspan","4" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:227 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("table"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(229)).setAttribute("border","0" );
      ((Element)v.get(229)).setAttribute("align","left" );
      ((Element)v.get(229)).setAttribute("cellspacing","0" );
      ((Element)v.get(229)).setAttribute("cellpadding","0" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(234)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("id","datosTitle" );
      ((Element)v.get(234)).setAttribute("cod","1622" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblBaseCalculo" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","1181" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(230)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:230   */

      /* Empieza nodo:241 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(241)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(245)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(245)).setAttribute("size","1" );
      ((Element)v.get(245)).setAttribute("multiple","N" );
      ((Element)v.get(245)).setAttribute("valorinicial","3" );
      ((Element)v.get(245)).setAttribute("textoinicial","Venta Catalogo" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("req","S" );
      ((Element)v.get(245)).setAttribute("onchange","onchangeMarcaCanalPais();" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(247)).setAttribute("ID","1" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(248)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(248)).setAttribute("TIPO","STRING" );
      ((Element)v.get(248)).setAttribute("VALOR","1" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 247   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(249)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(249)).setAttribute("TIPO","STRING" );
      ((Element)v.get(249)).setAttribute("VALOR","Venta Neta" );
      ((Element)v.get(247)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:247   */

      /* Empieza nodo:250 / Elemento padre: 246   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(250)).setAttribute("ID","3" );
      ((Element)v.get(246)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(251)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(251)).setAttribute("TIPO","STRING" );
      ((Element)v.get(251)).setAttribute("VALOR","2" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 250   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(252)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(252)).setAttribute("TIPO","STRING" );
      ((Element)v.get(252)).setAttribute("VALOR","Venta Factura" );
      ((Element)v.get(250)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:250   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:253 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","25" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(241)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(256)).setAttribute("nombre","cbBaseCalculo" );
      ((Element)v.get(256)).setAttribute("size","1" );
      ((Element)v.get(256)).setAttribute("multiple","N" );
      ((Element)v.get(256)).setAttribute("valorinicial","" );
      ((Element)v.get(256)).setAttribute("textoinicial","" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("req","S" );
      ((Element)v.get(256)).setAttribute("onchange","cambioBaseCalculo();" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(258)).setAttribute("ID","1" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

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
      ((Element)v.get(260)).setAttribute("VALOR","Monto Ventas" );
      ((Element)v.get(258)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:258   */

      /* Empieza nodo:261 / Elemento padre: 257   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(261)).setAttribute("ID","2" );
      ((Element)v.get(257)).appendChild((Element)v.get(261));

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
      ((Element)v.get(263)).setAttribute("VALOR","Unidades Vendidas" );
      ((Element)v.get(261)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:261   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:264 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(241)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:241   */

      /* Empieza nodo:266 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("colspan","4" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:269 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("table"));
      ((Element)v.get(271)).setAttribute("width","100%" );
      ((Element)v.get(271)).setAttribute("border","0" );
      ((Element)v.get(271)).setAttribute("align","left" );
      ((Element)v.get(271)).setAttribute("cellspacing","0" );
      ((Element)v.get(271)).setAttribute("cellpadding","0" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","1338" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(280)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(280)).setAttribute("alto","13" );
      ((Element)v.get(280)).setAttribute("filas","1" );
      ((Element)v.get(280)).setAttribute("id","datosTitle" );
      ((Element)v.get(280)).setAttribute("cod","588" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(272)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:272   */

      /* Empieza nodo:283 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(283)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(287)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(287)).setAttribute("size","5" );
      ((Element)v.get(287)).setAttribute("multiple","S" );
      ((Element)v.get(287)).setAttribute("valorinicial","" );
      ((Element)v.get(287)).setAttribute("textoinicial","" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(287)).setAttribute("req","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:289 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","25" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(283)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(292)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(292)).setAttribute("size","5" );
      ((Element)v.get(292)).setAttribute("multiple","S" );
      ((Element)v.get(292)).setAttribute("valorinicial","" );
      ((Element)v.get(292)).setAttribute("textoinicial","" );
      ((Element)v.get(292)).setAttribute("id","datosCampos" );
      ((Element)v.get(292)).setAttribute("req","N" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:294 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("width","100%" );
      ((Element)v.get(283)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:283   */

      /* Empieza nodo:296 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("colspan","4" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:299 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("table"));
      ((Element)v.get(301)).setAttribute("width","100%" );
      ((Element)v.get(301)).setAttribute("border","0" );
      ((Element)v.get(301)).setAttribute("align","left" );
      ((Element)v.get(301)).setAttribute("cellspacing","0" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(301)).setAttribute("cellpadding","0" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(306)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(306)).setAttribute("alto","13" );
      ((Element)v.get(306)).setAttribute("filas","1" );
      ((Element)v.get(306)).setAttribute("id","datosTitle" );
      ((Element)v.get(306)).setAttribute("cod","1604" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","25" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(310)).setAttribute("nombre","lblMonedaReferencia" );
      ((Element)v.get(310)).setAttribute("alto","13" );
      ((Element)v.get(310)).setAttribute("filas","1" );
      ((Element)v.get(310)).setAttribute("id","datosTitle" );
      ((Element)v.get(310)).setAttribute("cod","2717" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).setAttribute("width","100%" );
      ((Element)v.get(302)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:302   */

      /* Empieza nodo:313 / Elemento padre: 301   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(301)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(316)).setAttribute("valign","top" );
      ((Element)v.get(313)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(317)).setAttribute("nombre","cbNumConcurso" );
      ((Element)v.get(317)).setAttribute("size","1" );
      ((Element)v.get(317)).setAttribute("multiple","N" );
      ((Element)v.get(317)).setAttribute("valorinicial","" );
      ((Element)v.get(317)).setAttribute("textoinicial","" );
      ((Element)v.get(317)).setAttribute("id","datosCampos" );
      ((Element)v.get(317)).setAttribute("req","S" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:319 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","25" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(321)).setAttribute("valign","top" );
      ((Element)v.get(313)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(322)).setAttribute("nombre","cbMoneda" );
      ((Element)v.get(322)).setAttribute("size","1" );
      ((Element)v.get(322)).setAttribute("multiple","N" );
      ((Element)v.get(322)).setAttribute("valorinicial","" );
      ((Element)v.get(322)).setAttribute("textoinicial","" );
      ((Element)v.get(322)).setAttribute("id","datosCampos" );
      ((Element)v.get(322)).setAttribute("req","N" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 313   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(313)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:313   */

      /* Empieza nodo:326 / Elemento padre: 301   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(301)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("colspan","4" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:329 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("table"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(331)).setAttribute("border","0" );
      ((Element)v.get(331)).setAttribute("align","left" );
      ((Element)v.get(331)).setAttribute("cellspacing","0" );
      ((Element)v.get(331)).setAttribute("cellpadding","0" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(336)).setAttribute("nombre","lblResultados" );
      ((Element)v.get(336)).setAttribute("alto","13" );
      ((Element)v.get(336)).setAttribute("filas","1" );
      ((Element)v.get(336)).setAttribute("id","datosTitle" );
      ((Element)v.get(336)).setAttribute("cod","2723" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:332   */

      /* Empieza nodo:339 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(343)).setAttribute("nombre","cbResultados" );
      ((Element)v.get(343)).setAttribute("size","5" );
      ((Element)v.get(343)).setAttribute("multiple","S" );
      ((Element)v.get(343)).setAttribute("valorinicial","1" );
      ((Element)v.get(343)).setAttribute("textoinicial","1000" );
      ((Element)v.get(343)).setAttribute("id","datosCampos" );
      ((Element)v.get(343)).setAttribute("req","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(345)).setAttribute("ID","2" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(346)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(346)).setAttribute("TIPO","STRING" );
      ((Element)v.get(346)).setAttribute("VALOR","2" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(347)).setAttribute("TIPO","STRING" );
      ((Element)v.get(347)).setAttribute("VALOR","1500" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(345)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:345   */

      /* Empieza nodo:348 / Elemento padre: 344   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(348)).setAttribute("ID","3" );
      ((Element)v.get(344)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(349)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(349)).setAttribute("TIPO","STRING" );
      ((Element)v.get(349)).setAttribute("VALOR","3" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(350)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(350)).setAttribute("TIPO","STRING" );
      ((Element)v.get(350)).setAttribute("VALOR","2000" );
      ((Element)v.get(348)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:348   */

      /* Empieza nodo:351 / Elemento padre: 344   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(351)).setAttribute("ID","4" );
      ((Element)v.get(344)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(352)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(352)).setAttribute("TIPO","STRING" );
      ((Element)v.get(352)).setAttribute("VALOR","4" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 351   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(353)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","2500" );
      ((Element)v.get(351)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:351   */

      /* Empieza nodo:354 / Elemento padre: 344   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(354)).setAttribute("ID","5" );
      ((Element)v.get(344)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(355)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(355)).setAttribute("TIPO","STRING" );
      ((Element)v.get(355)).setAttribute("VALOR","5" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 354   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(356)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(356)).setAttribute("TIPO","STRING" );
      ((Element)v.get(356)).setAttribute("VALOR","3000" );
      ((Element)v.get(354)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:354   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:357 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("width","100%" );
      ((Element)v.get(339)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","8" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:339   */

      /* Empieza nodo:359 / Elemento padre: 331   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(331)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).setAttribute("colspan","4" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","8" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:362 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("table"));
      ((Element)v.get(364)).setAttribute("width","100%" );
      ((Element)v.get(364)).setAttribute("border","0" );
      ((Element)v.get(364)).setAttribute("cellspacing","0" );
      ((Element)v.get(364)).setAttribute("cellpadding","0" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","12" );
      ((Element)v.get(366)).setAttribute("align","center" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","12" );
      ((Element)v.get(367)).setAttribute("height","12" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","750" );
      ((Element)v.get(365)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("width","12" );
      ((Element)v.get(365)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(371)).setAttribute("height","1" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:365   */

      /* Empieza nodo:372 / Elemento padre: 364   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(364)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(377)).setAttribute("class","legend" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(378)).setAttribute("nombre","lblRangoPedidos" );
      ((Element)v.get(378)).setAttribute("alto","13" );
      ((Element)v.get(378)).setAttribute("filas","1" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("id","legend" );
      ((Element)v.get(378)).setAttribute("cod","00634" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("table"));
      ((Element)v.get(379)).setAttribute("width","100%" );
      ((Element)v.get(379)).setAttribute("border","0" );
      ((Element)v.get(379)).setAttribute("align","center" );
      ((Element)v.get(379)).setAttribute("cellspacing","0" );
      ((Element)v.get(379)).setAttribute("cellpadding","0" );
      ((Element)v.get(376)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("table"));
      ((Element)v.get(382)).setAttribute("width","100%" );
      ((Element)v.get(382)).setAttribute("border","0" );
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(382)).setAttribute("cellspacing","0" );
      ((Element)v.get(382)).setAttribute("cellpadding","0" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("colspan","4" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:386 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(390)).setAttribute("nombre","lblDesde" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("id","datosTitle" );
      ((Element)v.get(390)).setAttribute("cod","555" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","25" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lblHasta" );
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("id","datosTitle" );
      ((Element)v.get(394)).setAttribute("cod","145" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(386)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","8" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:386   */

      /* Empieza nodo:397 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","8" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(397)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(401)).setAttribute("nombre","cbDesde" );
      ((Element)v.get(401)).setAttribute("size","1" );
      ((Element)v.get(401)).setAttribute("multiple","N" );
      ((Element)v.get(401)).setAttribute("valorinicial","" );
      ((Element)v.get(401)).setAttribute("textoinicial","" );
      ((Element)v.get(401)).setAttribute("id","datosCampos" );
      ((Element)v.get(401)).setAttribute("req","N" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(403)).setAttribute("ID","1" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(404)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(404)).setAttribute("TIPO","STRING" );
      ((Element)v.get(404)).setAttribute("VALOR","1" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(405)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(405)).setAttribute("TIPO","STRING" );
      ((Element)v.get(405)).setAttribute("VALOR","1" );
      ((Element)v.get(403)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:403   */

      /* Empieza nodo:406 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(406)).setAttribute("ID","2" );
      ((Element)v.get(402)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(407)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(407)).setAttribute("TIPO","STRING" );
      ((Element)v.get(407)).setAttribute("VALOR","2" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(408)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(408)).setAttribute("TIPO","STRING" );
      ((Element)v.get(408)).setAttribute("VALOR","2" );
      ((Element)v.get(406)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:406   */

      /* Empieza nodo:409 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(409)).setAttribute("ID","3" );
      ((Element)v.get(402)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(410)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(410)).setAttribute("TIPO","STRING" );
      ((Element)v.get(410)).setAttribute("VALOR","3" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(411)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(411)).setAttribute("TIPO","STRING" );
      ((Element)v.get(411)).setAttribute("VALOR","3" );
      ((Element)v.get(409)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(412)).setAttribute("ID","4" );
      ((Element)v.get(402)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(413)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(413)).setAttribute("TIPO","STRING" );
      ((Element)v.get(413)).setAttribute("VALOR","4" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(414)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(414)).setAttribute("TIPO","STRING" );
      ((Element)v.get(414)).setAttribute("VALOR","4" );
      ((Element)v.get(412)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(415)).setAttribute("ID","5" );
      ((Element)v.get(402)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","5" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(417)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(417)).setAttribute("TIPO","STRING" );
      ((Element)v.get(417)).setAttribute("VALOR","5" );
      ((Element)v.get(415)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:415   */

      /* Empieza nodo:418 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(418)).setAttribute("ID","6" );
      ((Element)v.get(402)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","6" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(420)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(420)).setAttribute("TIPO","STRING" );
      ((Element)v.get(420)).setAttribute("VALOR","6" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:418   */

      /* Empieza nodo:421 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).setAttribute("ID","7" );
      ((Element)v.get(402)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","7" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(423)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(423)).setAttribute("TIPO","STRING" );
      ((Element)v.get(423)).setAttribute("VALOR","7" );
      ((Element)v.get(421)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:421   */

      /* Empieza nodo:424 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(424)).setAttribute("ID","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(426)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(426)).setAttribute("TIPO","STRING" );
      ((Element)v.get(426)).setAttribute("VALOR","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:424   */

      /* Empieza nodo:427 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(427)).setAttribute("ID","9" );
      ((Element)v.get(402)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(428)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(428)).setAttribute("TIPO","STRING" );
      ((Element)v.get(428)).setAttribute("VALOR","9" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 427   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(429)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(429)).setAttribute("TIPO","STRING" );
      ((Element)v.get(429)).setAttribute("VALOR","9" );
      ((Element)v.get(427)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:427   */

      /* Empieza nodo:430 / Elemento padre: 402   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(430)).setAttribute("ID","10" );
      ((Element)v.get(402)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(431)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(431)).setAttribute("TIPO","STRING" );
      ((Element)v.get(431)).setAttribute("VALOR","10" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 430   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(432)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(432)).setAttribute("TIPO","STRING" );
      ((Element)v.get(432)).setAttribute("VALOR","10" );
      ((Element)v.get(430)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:430   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:433 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","25" );
      ((Element)v.get(434)).setAttribute("height","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(435)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(397)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(436)).setAttribute("nombre","cbHasta" );
      ((Element)v.get(436)).setAttribute("size","1" );
      ((Element)v.get(436)).setAttribute("multiple","N" );
      ((Element)v.get(436)).setAttribute("valorinicial","" );
      ((Element)v.get(436)).setAttribute("textoinicial","" );
      ((Element)v.get(436)).setAttribute("id","datosCampos" );
      ((Element)v.get(436)).setAttribute("req","N" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(438)).setAttribute("ID","1" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","1" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(440)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(440)).setAttribute("TIPO","STRING" );
      ((Element)v.get(440)).setAttribute("VALOR","1" );
      ((Element)v.get(438)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(441)).setAttribute("ID","12" );
      ((Element)v.get(437)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","2" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(443)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(443)).setAttribute("TIPO","STRING" );
      ((Element)v.get(443)).setAttribute("VALOR","2" );
      ((Element)v.get(441)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:441   */

      /* Empieza nodo:444 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(444)).setAttribute("ID","3" );
      ((Element)v.get(437)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(445)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(445)).setAttribute("TIPO","STRING" );
      ((Element)v.get(445)).setAttribute("VALOR","3" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(446)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(446)).setAttribute("TIPO","STRING" );
      ((Element)v.get(446)).setAttribute("VALOR","3" );
      ((Element)v.get(444)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:444   */

      /* Empieza nodo:447 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(447)).setAttribute("ID","4" );
      ((Element)v.get(437)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(448)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(448)).setAttribute("TIPO","STRING" );
      ((Element)v.get(448)).setAttribute("VALOR","4" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(449)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(449)).setAttribute("TIPO","STRING" );
      ((Element)v.get(449)).setAttribute("VALOR","4" );
      ((Element)v.get(447)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:447   */

      /* Empieza nodo:450 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(450)).setAttribute("ID","5" );
      ((Element)v.get(437)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(451)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(451)).setAttribute("TIPO","STRING" );
      ((Element)v.get(451)).setAttribute("VALOR","5" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(452)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(452)).setAttribute("TIPO","STRING" );
      ((Element)v.get(452)).setAttribute("VALOR","5" );
      ((Element)v.get(450)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(453)).setAttribute("ID","6" );
      ((Element)v.get(437)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(454)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(454)).setAttribute("TIPO","STRING" );
      ((Element)v.get(454)).setAttribute("VALOR","6" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(455)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(455)).setAttribute("TIPO","STRING" );
      ((Element)v.get(455)).setAttribute("VALOR","6" );
      ((Element)v.get(453)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:453   */

      /* Empieza nodo:456 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(456)).setAttribute("ID","7" );
      ((Element)v.get(437)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(457)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(457)).setAttribute("TIPO","STRING" );
      ((Element)v.get(457)).setAttribute("VALOR","7" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 456   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(458)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(458)).setAttribute("TIPO","STRING" );
      ((Element)v.get(458)).setAttribute("VALOR","7" );
      ((Element)v.get(456)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:456   */

      /* Empieza nodo:459 / Elemento padre: 437   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(459)).setAttribute("ID","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(460)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(460)).setAttribute("TIPO","STRING" );
      ((Element)v.get(460)).setAttribute("VALOR","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 459   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(461)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(461)).setAttribute("TIPO","STRING" );
      ((Element)v.get(461)).setAttribute("VALOR","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:459   */

      /* Empieza nodo:462 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(462)).setAttribute("ID","9" );
      ((Element)v.get(437)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(463)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(463)).setAttribute("TIPO","STRING" );
      ((Element)v.get(463)).setAttribute("VALOR","9" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 462   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(464)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(464)).setAttribute("TIPO","STRING" );
      ((Element)v.get(464)).setAttribute("VALOR","9" );
      ((Element)v.get(462)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:462   */

      /* Empieza nodo:465 / Elemento padre: 437   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(465)).setAttribute("ID","10" );
      ((Element)v.get(437)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(466)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(466)).setAttribute("TIPO","STRING" );
      ((Element)v.get(466)).setAttribute("VALOR","10" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 465   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(467)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(467)).setAttribute("TIPO","STRING" );
      ((Element)v.get(467)).setAttribute("VALOR","10" );
      ((Element)v.get(465)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:465   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:468 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).setAttribute("width","100%" );
      ((Element)v.get(397)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:397   */

      /* Empieza nodo:470 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).setAttribute("colspan","4" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","8" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:473 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:372   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:475 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(476)).setAttribute("colspan","4" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","12" );
      ((Element)v.get(477)).setAttribute("height","12" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:478 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:33   */

      /* Empieza nodo:480 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 480   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("table"));
      ((Element)v.get(485)).setAttribute("width","100%" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(485)).setAttribute("border","0" );
      ((Element)v.get(485)).setAttribute("align","center" );
      ((Element)v.get(485)).setAttribute("cellspacing","0" );
      ((Element)v.get(485)).setAttribute("cellpadding","0" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).setAttribute("class","botonera" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(488)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(488)).setAttribute("ID","botonContenido" );
      ((Element)v.get(488)).setAttribute("tipo","html" );
      ((Element)v.get(488)).setAttribute("accion","generar('pdf');" );
      ((Element)v.get(488)).setAttribute("estado","false" );
      ((Element)v.get(488)).setAttribute("cod","2495" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 487   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(489)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(489)).setAttribute("ID","botonContenido" );
      ((Element)v.get(489)).setAttribute("tipo","html" );
      ((Element)v.get(489)).setAttribute("accion","generar('xls');" );
      ((Element)v.get(489)).setAttribute("estado","false" );
      ((Element)v.get(489)).setAttribute("cod","2526" );
      ((Element)v.get(489)).setAttribute("ontab","focaliza('Formulario.cbPais');" );
      ((Element)v.get(487)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:490 / Elemento padre: 480   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(491)).setAttribute("height","12" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:480   */

      /* Empieza nodo:492 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).setAttribute("width","12" );
      ((Element)v.get(493)).setAttribute("align","center" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","12" );
      ((Element)v.get(494)).setAttribute("height","12" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("width","756" );
      ((Element)v.get(492)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).setAttribute("width","12" );
      ((Element)v.get(492)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","12" );
      ((Element)v.get(498)).setAttribute("height","1" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:492   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:499 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(499)).setAttribute("nombre","capaSubtipo" );
      ((Element)v.get(499)).setAttribute("alto","3" );
      ((Element)v.get(499)).setAttribute("ancho","624" );
      ((Element)v.get(499)).setAttribute("colorf","" );
      ((Element)v.get(499)).setAttribute("borde","0" );
      ((Element)v.get(499)).setAttribute("imagenf","" );
      ((Element)v.get(499)).setAttribute("repeat","" );
      ((Element)v.get(499)).setAttribute("padding","" );
      ((Element)v.get(499)).setAttribute("visibilidad","visible" );
      ((Element)v.get(499)).setAttribute("contravsb","" );
      ((Element)v.get(499)).setAttribute("x","0" );
      ((Element)v.get(499)).setAttribute("y","165" );
      ((Element)v.get(499)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(500)).setAttribute("seleccion","boton" );
      ((Element)v.get(500)).setAttribute("nombre","lstSubtipo" );
      ((Element)v.get(500)).setAttribute("x","12" );
      ((Element)v.get(500)).setAttribute("y","10" );
      ((Element)v.get(500)).setAttribute("ancho","600" );
      ((Element)v.get(500)).setAttribute("alto","3" );
      ((Element)v.get(500)).setAttribute("multisel","-1" );
      ((Element)v.get(500)).setAttribute("incy","10" );
      ((Element)v.get(500)).setAttribute("incx","10" );
      ((Element)v.get(500)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(500)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(500)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(500)).setAttribute("accion","" );
      ((Element)v.get(500)).setAttribute("sep","|" );
      ((Element)v.get(500)).setAttribute("pixelsborde","2" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(500)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(501)).setAttribute("nombre","cab1" );
      ((Element)v.get(501)).setAttribute("height","20" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(502)).setAttribute("ancho","40" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 501   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(503)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(503)).setAttribute("ancho","60" );
      ((Element)v.get(501)).appendChild((Element)v.get(503));

      /* Elemento padre:503 / Elemento actual: 504   */
      v.add(doc.createTextNode("Subtipo"));
      ((Element)v.get(503)).appendChild((Text)v.get(504));

      /* Termina nodo Texto:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 501   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(505)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(505)).setAttribute("ancho","440" );
      ((Element)v.get(501)).appendChild((Element)v.get(505));

      /* Elemento padre:505 / Elemento actual: 506   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(505)).appendChild((Text)v.get(506));

      /* Termina nodo Texto:506   */
      /* Termina nodo:505   */
      /* Termina nodo:501   */

      /* Empieza nodo:507 / Elemento padre: 500   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(507)).setAttribute("ancho","590" );
      ((Element)v.get(507)).setAttribute("filas","1" );
      ((Element)v.get(507)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(500)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(508)).setAttribute("ancho","40" );
      ((Element)v.get(508)).setAttribute("caracteres","20" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 507   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(509)).setAttribute("ancho","60" );
      ((Element)v.get(509)).setAttribute("caracteres","20" );
      ((Element)v.get(507)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 507   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("ancho","440" );
      ((Element)v.get(510)).setAttribute("caracteres","30" );
      ((Element)v.get(507)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:507   */

      /* Empieza nodo:511 / Elemento padre: 500   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(500)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:512 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(512)).setAttribute("nombre","capaTipoClasificacion" );
      ((Element)v.get(512)).setAttribute("alto","3" );
      ((Element)v.get(512)).setAttribute("ancho","624" );
      ((Element)v.get(512)).setAttribute("colorf","" );
      ((Element)v.get(512)).setAttribute("borde","0" );
      ((Element)v.get(512)).setAttribute("imagenf","" );
      ((Element)v.get(512)).setAttribute("repeat","" );
      ((Element)v.get(512)).setAttribute("padding","" );
      ((Element)v.get(512)).setAttribute("visibilidad","visible" );
      ((Element)v.get(512)).setAttribute("contravsb","" );
      ((Element)v.get(512)).setAttribute("x","0" );
      ((Element)v.get(512)).setAttribute("y","165" );
      ((Element)v.get(512)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(513)).setAttribute("seleccion","boton" );
      ((Element)v.get(513)).setAttribute("nombre","lstTipoClasificacion" );
      ((Element)v.get(513)).setAttribute("x","12" );
      ((Element)v.get(513)).setAttribute("y","10" );
      ((Element)v.get(513)).setAttribute("ancho","600" );
      ((Element)v.get(513)).setAttribute("alto","3" );
      ((Element)v.get(513)).setAttribute("multisel","-1" );
      ((Element)v.get(513)).setAttribute("incy","10" );
      ((Element)v.get(513)).setAttribute("incx","10" );
      ((Element)v.get(513)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(513)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(513)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(513)).setAttribute("accion","" );
      ((Element)v.get(513)).setAttribute("sep","|" );
      ((Element)v.get(513)).setAttribute("pixelsborde","2" );
      ((Element)v.get(513)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(514)).setAttribute("nombre","cab1" );
      ((Element)v.get(514)).setAttribute("height","20" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(515)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(515)).setAttribute("ancho","40" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 514   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(516)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(516)).setAttribute("ancho","60" );
      ((Element)v.get(514)).appendChild((Element)v.get(516));

      /* Elemento padre:516 / Elemento actual: 517   */
      v.add(doc.createTextNode("TipoClasificacion"));
      ((Element)v.get(516)).appendChild((Text)v.get(517));

      /* Termina nodo Texto:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 514   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(518)).setAttribute("id","datosCamposCabecera" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(518)).setAttribute("ancho","440" );
      ((Element)v.get(514)).appendChild((Element)v.get(518));

      /* Elemento padre:518 / Elemento actual: 519   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(518)).appendChild((Text)v.get(519));

      /* Termina nodo Texto:519   */
      /* Termina nodo:518   */
      /* Termina nodo:514   */

      /* Empieza nodo:520 / Elemento padre: 513   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(520)).setAttribute("ancho","590" );
      ((Element)v.get(520)).setAttribute("filas","1" );
      ((Element)v.get(520)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(513)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(521)).setAttribute("ancho","40" );
      ((Element)v.get(521)).setAttribute("caracteres","20" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 520   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("ancho","60" );
      ((Element)v.get(522)).setAttribute("caracteres","20" );
      ((Element)v.get(520)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 520   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(523)).setAttribute("ancho","440" );
      ((Element)v.get(523)).setAttribute("caracteres","30" );
      ((Element)v.get(520)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:520   */

      /* Empieza nodo:524 / Elemento padre: 513   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(513)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:525 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(525)).setAttribute("nombre","capaClasificacion" );
      ((Element)v.get(525)).setAttribute("alto","3" );
      ((Element)v.get(525)).setAttribute("ancho","624" );
      ((Element)v.get(525)).setAttribute("colorf","" );
      ((Element)v.get(525)).setAttribute("borde","0" );
      ((Element)v.get(525)).setAttribute("imagenf","" );
      ((Element)v.get(525)).setAttribute("repeat","" );
      ((Element)v.get(525)).setAttribute("padding","" );
      ((Element)v.get(525)).setAttribute("visibilidad","visible" );
      ((Element)v.get(525)).setAttribute("contravsb","" );
      ((Element)v.get(525)).setAttribute("x","0" );
      ((Element)v.get(525)).setAttribute("y","165" );
      ((Element)v.get(525)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(526)).setAttribute("seleccion","boton" );
      ((Element)v.get(526)).setAttribute("nombre","lstClasificacion" );
      ((Element)v.get(526)).setAttribute("x","12" );
      ((Element)v.get(526)).setAttribute("y","10" );
      ((Element)v.get(526)).setAttribute("ancho","600" );
      ((Element)v.get(526)).setAttribute("alto","3" );
      ((Element)v.get(526)).setAttribute("multisel","-1" );
      ((Element)v.get(526)).setAttribute("incy","10" );
      ((Element)v.get(526)).setAttribute("incx","10" );
      ((Element)v.get(526)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(526)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(526)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(526)).setAttribute("accion","" );
      ((Element)v.get(526)).setAttribute("sep","|" );
      ((Element)v.get(526)).setAttribute("pixelsborde","2" );
      ((Element)v.get(526)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(527)).setAttribute("nombre","cab1" );
      ((Element)v.get(527)).setAttribute("height","20" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(528)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(528)).setAttribute("ancho","40" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */

      /* Empieza nodo:529 / Elemento padre: 527   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(529)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(529)).setAttribute("ancho","60" );
      ((Element)v.get(527)).appendChild((Element)v.get(529));

      /* Elemento padre:529 / Elemento actual: 530   */
      v.add(doc.createTextNode("Clasificacion"));
      ((Element)v.get(529)).appendChild((Text)v.get(530));

      /* Termina nodo Texto:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 527   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(531)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(531)).setAttribute("ancho","440" );
      ((Element)v.get(527)).appendChild((Element)v.get(531));

      /* Elemento padre:531 / Elemento actual: 532   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(531)).appendChild((Text)v.get(532));

      /* Termina nodo Texto:532   */
      /* Termina nodo:531   */
      /* Termina nodo:527   */

      /* Empieza nodo:533 / Elemento padre: 526   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(533)).setAttribute("ancho","590" );
      ((Element)v.get(533)).setAttribute("filas","1" );
      ((Element)v.get(533)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(526)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(534)).setAttribute("ancho","40" );
      ((Element)v.get(534)).setAttribute("caracteres","20" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */

      /* Empieza nodo:535 / Elemento padre: 533   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(535)).setAttribute("ancho","60" );
      ((Element)v.get(535)).setAttribute("caracteres","20" );
      ((Element)v.get(533)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 533   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(536)).setAttribute("ancho","440" );
      ((Element)v.get(536)).setAttribute("caracteres","30" );
      ((Element)v.get(533)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:533   */

      /* Empieza nodo:537 / Elemento padre: 526   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(526)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:15   */


   }

}
