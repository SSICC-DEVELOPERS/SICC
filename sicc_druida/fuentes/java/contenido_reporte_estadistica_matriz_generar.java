
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_reporte_estadistica_matriz_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_reporte_estadistica_matriz_generar" );
      ((Element)v.get(0)).setAttribute("cod","0796" );
      ((Element)v.get(0)).setAttribute("titulo","Generar reporte de estadistica de matriz de facturación" );
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
      v.add(doc.createTextNode("\r\r\r\r  \r  function onLoad(){\r    \r    configurarMenuSecundario('Formulario');\r    fMostrarMensajeError();\r    deshabilitar();\r    focaliza('Formulario.cbMarca');\r    \r  }\r\r\r  function deshabilitar(){\r    \r    accion('Formulario.cbPeriodo', '.disabled=true');\r    accion('Formulario.txtCodVentaHasta', '.disabled=true');\r    accion('Formulario.txtCodProductoHasta', '.disabled=true');\r    accion('Formulario.txtPaginaHasta', '.disabled=true');\r  \r  }\r  \r  \r  function fLimpiar(){\r  \r    deshabilitar();\r    focaliza('Formulario.cbMarca');\r    \r  }\r\r\r  function generar(formato){\r  \r    if(sicc_validaciones_generales()){\r      \r      var a = new Object();\r      a.accion = 'generar';\r      \r      a.marca = get('Formulario.cbMarca');\r      a.marcaDesc = get('Formulario.cbMarca','T');\r      \r      a.canal = get('Formulario.cbCanal');\r      a.canalDesc = get('Formulario.cbCanal','T');\r      \r      a.periodo = get('Formulario.cbPeriodo');\r      a.periodoDesc = get('Formulario.cbPeriodo','T');\r      \r      a.acceso = get('Formulario.cbAcceso');\r      a.accesoDesc = get('Formulario.cbAcceso','T');\r      \r      a.productoDesde = get('Formulario.txtCodProductoDesde');\r      a.productoHasta = get('Formulario.txtCodProductoHasta');\r      \r      a.ventaDesde = get('Formulario.txtCodVentaDesde');\r      a.ventaHasta = get('Formulario.txtCodVentaHasta');\r      \r      descr = get('Formulario.txtDescripcion');\r      \r      if (descr != ''){\r        a.descripcion = \"%\" + get('Formulario.txtDescripcion') + \"%\";\r      }else{\r        a.descripcion = descr;\r      }\r      \r      \r      \r      a.catalogo = get('Formulario.cbCatalogo');\r      \r      a.paginaDesde = get('Formulario.txtPaginaDesde');\r      a.paginaHasta = get('Formulario.txtPaginaHasta');\r      \r      a.operadorPrecioCatalogo = obtenerOperadorPrecioCatalogo();\r      a.precioCatalogo = get('Formulario.txtPrecioCatalogo');\r      \r      a.tipoSolicitud = get('Formulario.cbTipoSolicitud');\r      a.tipoLinea = get('Formulario.cbTipoLinea');\r      \r      a.operadorUnidadesTotales = obtenerOperadorUnidadesTotales();\r      a.unidadesTotales = get('Formulario.txtUnidadesTotales');\r      \r      a.operadorUnidadesFaltantes = obtenerOperadorUnidadesFaltantes();\r      a.unidadesFaltantes =  get('Formulario.txtUnidadesFaltantes');\r      \r      a.criterioOrdenacion1 = obtenerCriterioOrdenacion1();\r      a.criterioOrdenacion2 = obtenerCriterioOrdenacion2();\r      a.criterioOrdenacion3 = obtenerCriterioOrdenacion3();\r      \r      \r      var vistaElegida = get('Formulario.cbVista');\r      a.vista = vistaElegida;\r      \r      if (vistaElegida == '1'){\r        reporte = 'RD_REP-044_01';\r      }else{\r        reporte = 'RD_REP-044';\r      }\r      \r      a.reporte = reporte;\r      a.formato = formato;\r      \r      a.criteriosSeleccionDesc = concatenarCriterios();\r      \r      mostrarModalSICC('PREEstadisticasMF','generar', a);\r    \r    }\r\r  }\r\r\r  function concatenarCriterios(){\r    \r    marcaDesc = get('Formulario.cbMarca','T');\r    canalDesc = get('Formulario.cbCanal','T');\r    periodoDesc = get('Formulario.cbPeriodo','T');\r    accesoDesc = get('Formulario.cbAcceso','T');\r    \r    ventaDesde = get('Formulario.txtCodVentaDesde');\r    ventaHasta = get('Formulario.txtCodVentaHasta');\r    \r    productoDesde = get('Formulario.txtCodProductoDesde');\r    productoHasta = get('Formulario.txtCodProductoHasta');\r    \r    descripcion = get('Formulario.txtDescripcion');\r    \r    catalogoDesc = get('Formulario.cbCatalogo','T');\r    \r    paginaDesde = get('Formulario.txtPaginaDesde');\r    paginaHasta = get('Formulario.txtPaginaHasta');\r    \r    operadorPrecioCatalogo = obtenerOperadorPrecioCatalogo();\r    precioCatalogo = get('Formulario.txtPrecioCatalogo');\r    \r    tipoSolicitudDesc = get('Formulario.cbTipoSolicitud','T');\r    tipoLineaDesc = get('Formulario.cbTipoLinea','T');\r    \r    operadorUnidadesTotales = obtenerOperadorUnidadesTotales();\r    unidadesTotales = get('Formulario.txtUnidadesTotales');\r    \r    operadorUnidadesFaltantes = obtenerOperadorUnidadesFaltantes();\r    unidadesFaltantes =  get('Formulario.txtUnidadesFaltantes');\r    \r    vistaDesc = get('Formulario.cbVista','T');\r    \r    criterioOrdenacion1 = get('Formulario.cbCriterioOrdenacion1','T');\r    criterioOrdenacion2 = get('Formulario.cbCriterioOrdenacion2','T');\r    criterioOrdenacion3 = get('Formulario.cbCriterioOrdenacion3','T');\r    \r    \r    var criteriosSeleccionDesc = marcaDesc + \"--\" + canalDesc + \"--\" + periodoDesc + \"--\" + accesoDesc;\r    \r    \r    if (ventaDesde != '')\r      criteriosSeleccionDesc += \"--\" + ventaDesde;\r    \r    if (ventaHasta != '')\r      criteriosSeleccionDesc += \"--\" + ventaHasta;\r      \r    if (productoDesde != '')\r      criteriosSeleccionDesc += \"--\" + productoDesde;\r    \r    if (productoHasta != '')\r      criteriosSeleccionDesc += \"--\" + productoHasta;\r    \r    if (descripcion != '')\r      criteriosSeleccionDesc += \"--\" + descripcion;\r    \r    if (catalogoDesc != '')\r      criteriosSeleccionDesc += \"--\" + catalogoDesc;\r    \r    if (paginaDesde != '')\r      criteriosSeleccionDesc += \"--\" + paginaDesde;\r    \r    if (paginaHasta != '')\r      criteriosSeleccionDesc += \"--\" + paginaHasta;\r    \r    if (operadorPrecioCatalogo != '')\r      criteriosSeleccionDesc += \"--\" + operadorPrecioCatalogo;\r      \r    if (precioCatalogo != '')\r      criteriosSeleccionDesc += \"--\" + precioCatalogo;\r      \r    if (tipoSolicitudDesc != '')\r      criteriosSeleccionDesc += \"--\" + tipoSolicitudDesc;\r    \r    if (tipoLineaDesc != '')\r      criteriosSeleccionDesc += \"--\" + tipoLineaDesc;\r      \r    if (operadorUnidadesTotales != '')\r      criteriosSeleccionDesc += \"--\" + operadorUnidadesTotales;\r      \r    if (unidadesTotales != '')\r      criteriosSeleccionDesc += \"--\" + unidadesTotales;\r    \r    if (operadorUnidadesFaltantes != '')\r      criteriosSeleccionDesc += \"--\" + operadorUnidadesFaltantes;\r    \r    if (unidadesFaltantes != '')\r      criteriosSeleccionDesc += \"--\" + unidadesFaltantes;\r    \r    criteriosSeleccionDesc += \"--\" + vistaDesc;\r      \r    if (criterioOrdenacion1 != '')\r      criteriosSeleccionDesc += \"--\" + criterioOrdenacion1;\r      \r    if (criterioOrdenacion2 != '')\r      criteriosSeleccionDesc += \"--\" + criterioOrdenacion2;\r      \r    if (criterioOrdenacion3 != '')\r      criteriosSeleccionDesc += \"--\" + criterioOrdenacion3;\r    \r    return criteriosSeleccionDesc;\r    \r    \r  }\r  \r  \r  function obtenerOperadorPrecioCatalogo(){\r  \r    var operador = parseInt(get('Formulario.cbOperadorPrecioCatalogo'),10);\r    return (devolverOperador(operador));\r    \r  }\r\r\r  function obtenerOperadorUnidadesTotales(){\r  \r    var operador = parseInt(get('Formulario.cbOperadorUnidadesTotales'),10);\r    return (devolverOperador(operador));\r    \r  }\r\r\r  function obtenerOperadorUnidadesFaltantes(){\r  \r    var operador = parseInt(get('Formulario.cbOperadorUnidadesFaltantes'),10);\r    return (devolverOperador(operador));\r    \r  }\r\r\r  function devolverOperador(operador){\r  \r    switch (operador) {\r    \r      case 1:\r        return (\"'<'\");\r      case 2:\r        return (\"'>'\");\r      case 3:\r        return (\"'='\");\r      case 4:\r        return (\"'<='\");\r      case 5:\r        return (\"'>='\");\r      default:\r        return (\"\");\r    \r    }\r  \r  }\r\r\r  function obtenerCriterioOrdenacion1(){\r    \r    var criterio = parseInt(get('Formulario.cbCriterioOrdenacion1'),10);\r    return (devolverValorCriterio(criterio));\r  \r  }\r    \r\r  function obtenerCriterioOrdenacion2(){\r  \r    var criterio = parseInt(get('Formulario.cbCriterioOrdenacion2'),10);\r    return (devolverValorCriterio(criterio));\r  \r  }\r    \r\r  function obtenerCriterioOrdenacion3(){\r  \r    var criterio = parseInt(get('Formulario.cbCriterioOrdenacion3'),10);\r    return (devolverValorCriterio(criterio));\r  \r  }\r    \r  \r  \r  function devolverValorCriterio(criterio){\r  \r    switch (criterio) {\r      \r      case 1:\r        return (\"',UNID_TOTALES'\");\r      case 2:\r        return (\"',VAL_CODI_VENT'\");\r      case 3:\r        return (\"',COD_SAP'\");\r      case 4:\r        return (\"',NUM_PAGI_CATA'\");\r      default:\r        return (\"\");\r    \r    }\r  \r  }\r\r\r  function cargarPeriodos(){\r  \r    pais = get('Formulario.pais');\r    marca = get('Formulario.cbMarca');\r    canal = get('Formulario.cbCanal');\r    \r    if (pais != '' && marca != '' && canal != ''){\r    \r      var arr = new Array();\r      \r      arr[arr.length] = [\"pais\", pais];\r      arr[arr.length] = [\"marca\", marca];\r      arr[arr.length] = [\"canal\", canal];\r    \r      recargaCombo(\"Formulario.cbPeriodo\", \"PRECargarPeriodos\", \"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r      accion('Formulario.cbPeriodo', '.disabled=false');\r    \r    }else{\r    \r      var aCombo = new Array(new Array(\"\",\"\"));\r      \r      set_combo('Formulario.cbPeriodo',aCombo, []);\r      accion('Formulario.cbPeriodo', '.disabled=true');\r      \r    }\r\r  }\r  \r\r  function onchangeVista(){\r   \r    vista = get('Formulario.cbVista');\r      \r    if(vista == '1'){\r      \r      accion('Formulario.cbCriterioOrdenacion1', '.disabled=false');\r      accion('Formulario.cbCriterioOrdenacion2', '.disabled=false');\r      accion('Formulario.cbCriterioOrdenacion3', '.disabled=false');\r      \r    }else{\r      \r      accion('Formulario.cbCriterioOrdenacion1', '.disabled=true');    \r      accion('Formulario.cbCriterioOrdenacion2', '.disabled=true');    \r      accion('Formulario.cbCriterioOrdenacion3', '.disabled=true');    \r      \r      set('Formulario.cbCriterioOrdenacion1','');\r      set('Formulario.cbCriterioOrdenacion2','');\r      set('Formulario.cbCriterioOrdenacion3','');\r      \r    }\r    \r  }\r\r  \r  function habilitarCodigoVentaHasta(){\r           \r    if(get('Formulario.txtCodVentaDesde') != ''){\r      accion('Formulario.txtCodVentaHasta', '.disabled=false');\r      focaliza('Formulario.txtCodVentaHasta');\r    }else{\r      accion('Formulario.txtCodVentaHasta', '.disabled=true');\r      focaliza('Formulario.txtCodProductoDesde');\r    }\r    \r  }\r\r\r  function habilitarCodigoProductoHasta(){\r  \r    if(get('Formulario.txtCodProductoDesde') != ''){\r      accion('Formulario.txtCodProductoHasta', '.disabled=false');\r      focaliza('Formulario.txtCodProductoHasta');\r    }else{\r      accion('Formulario.txtCodProductoHasta', '.disabled=true');\r      focaliza('Formulario.txtDescripcion');\r    }\r    \r  }\r\r\r  function habilitarPaginaHasta(){\r  \r    if(get('Formulario.txtPaginaDesde') != ''){\r      accion('Formulario.txtPaginaHasta', '.disabled=false');\r      focaliza('Formulario.txtPaginaHasta');\r    }else{\r      accion('Formulario.txtPaginaHasta', '.disabled=true');\r      focaliza('Formulario.cbOperadorPrecioCatalogo');\r    }\r    \r  }\r\r\r  \r  function cambioOperadorCatalogo(){\r  \r    var operadorCatalogo = get('Formulario.cbOperadorPrecioCatalogo');\r    \r    if(operadorCatalogo != ''){\r      sicc_cambiar_estado('txtPrecioCatalogo', true);\r    }else{\r      sicc_cambiar_estado('txtPrecioCatalogo', false);\r    }\r  \r  }\r\r\r  function cambioPrecioCatalogo(){\r  \r    var precioCatalogo = get('Formulario.txtPrecioCatalogo');\r    \r    if(precioCatalogo != ''){\r      sicc_cambiar_estado('cbOperadorPrecioCatalogo', true);\r    }else{\r      sicc_cambiar_estado('cbOperadorPrecioCatalogo', false);\r    }\r  \r  }\r\r\r\r  function cambioOperadorTotales(){\r  \r    var operadorTotales = get('Formulario.cbOperadorUnidadesTotales');\r    \r    if(operadorTotales != ''){\r      sicc_cambiar_estado('txtUnidadesTotales', true);\r    }else{\r      sicc_cambiar_estado('txtUnidadesTotales', false);\r    }\r\r  }\r\r\r  function cambioUnidadesTotales(){\r\r    var unidadesTotales = get('Formulario.txtUnidadesTotales');\r    \r    if(unidadesTotales != ''){\r      sicc_cambiar_estado('cbOperadorUnidadesTotales', true);\r    }else{\r      sicc_cambiar_estado('cbOperadorUnidadesTotales', false);\r    }\r    \r  }\r  \r\r  function cambioOperadorFaltantes(){\r  \r    var operadorFaltantes = get('Formulario.cbOperadorUnidadesFaltantes');\r    \r    if(operadorFaltantes != ''){\r      sicc_cambiar_estado('txtUnidadesFaltantes', true);\r    }else{\r      sicc_cambiar_estado('txtUnidadesFaltantes', false);\r    }\r  \r  }\r\r\r  function cambioUnidadesFaltantes(){\r  \r    var unidadesFaltantes = get('Formulario.txtUnidadesFaltantes');\r    \r    if(unidadesFaltantes != ''){\r      sicc_cambiar_estado('cbOperadorUnidadesFaltantes', true);\r    }else{\r      sicc_cambiar_estado('cbOperadorUnidadesFaltantes', false);\r    }\r  \r  }\r\r\r\r\r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(4)).appendChild((Element)v.get(6));

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
      ((Element)v.get(9)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","276" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbAcceso" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","10" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbOperadorPrecioCatalogo" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","2575" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtPrecioCatalogo" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","2576" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbOperadorUnidadesTotales" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","2634" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtUnidadesTotales" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","1015" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbOperadorUnidadesFaltantes" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","2635" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtUnidadesFaltantes" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("cod","1459" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:6   */
      /* Termina nodo:4   */

      /* Empieza nodo:17 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(17)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","accion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 17   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","idioma" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","pais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(25)).setAttribute("nombre","capa1" );
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("table"));
      ((Element)v.get(26)).setAttribute("width","100%" );
      ((Element)v.get(26)).setAttribute("border","0" );
      ((Element)v.get(26)).setAttribute("cellspacing","0" );
      ((Element)v.get(26)).setAttribute("cellpadding","0" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","12" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","750" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("height","1" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:27   */

      /* Empieza nodo:34 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(39)).setAttribute("class","legend" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("filas","1" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(40)).setAttribute("id","legend" );
      ((Element)v.get(40)).setAttribute("cod","00275" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","100%" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(44)).setAttribute("width","100%" );
      ((Element)v.get(44)).setAttribute("border","0" );
      ((Element)v.get(44)).setAttribute("align","left" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("colspan","4" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblPais" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","5" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","25" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","6" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(48)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:48   */

      /* Empieza nodo:59 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(59));

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
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(67)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(67)).setAttribute("size","1" );
      ((Element)v.get(67)).setAttribute("multiple","N" );
      ((Element)v.get(67)).setAttribute("valorinicial","" );
      ((Element)v.get(67)).setAttribute("textoinicial","" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("req","S" );
      ((Element)v.get(67)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarExcel');" );
      ((Element)v.get(67)).setAttribute("onchange","cargarPeriodos()" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(59)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:59   */

      /* Empieza nodo:71 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(44)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("colspan","4" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:74 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("table"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("align","left" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

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
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","7" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("filas","1" );
      ((Element)v.get(85)).setAttribute("id","datosTitle" );
      ((Element)v.get(85)).setAttribute("cod","276" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(77)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:77   */

      /* Empieza nodo:88 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(92)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(92)).setAttribute("size","1" );
      ((Element)v.get(92)).setAttribute("multiple","N" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("valorinicial","" );
      ((Element)v.get(92)).setAttribute("textoinicial","" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(92)).setAttribute("req","S" );
      ((Element)v.get(92)).setAttribute("onchange","cargarPeriodos()" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(97)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(97)).setAttribute("size","1" );
      ((Element)v.get(97)).setAttribute("multiple","N" );
      ((Element)v.get(97)).setAttribute("valorinicial","" );
      ((Element)v.get(97)).setAttribute("textoinicial","" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("req","S" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:88   */

      /* Empieza nodo:101 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("colspan","4" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:104 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(106)).setAttribute("border","0" );
      ((Element)v.get(106)).setAttribute("align","left" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

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
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("id","datosTitle" );
      ((Element)v.get(111)).setAttribute("cod","10" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:107   */

      /* Empieza nodo:114 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(118)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(118)).setAttribute("size","1" );
      ((Element)v.get(118)).setAttribute("multiple","N" );
      ((Element)v.get(118)).setAttribute("valorinicial","" );
      ((Element)v.get(118)).setAttribute("textoinicial","" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("req","S" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:114   */

      /* Empieza nodo:122 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(122));

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
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:125 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(125));

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
      ((Element)v.get(132)).setAttribute("nombre","lblCodVentaDesde" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("cod","2572" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
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
      ((Element)v.get(136)).setAttribute("nombre","lblCodVentaHasta" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("cod","2573" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
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
   }

   private void getXML540(Document doc) {
      ((Element)v.get(140)).setAttribute("nombre","lblCodProductoDesde" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("cod","2570" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","25" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblCodProductoHasta" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("cod","2571" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:128   */

      /* Empieza nodo:147 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(151)).setAttribute("nombre","txtCodVentaDesde" );
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(151)).setAttribute("max","18" );
      ((Element)v.get(151)).setAttribute("tipo","" );
      ((Element)v.get(151)).setAttribute("onchange","habilitarCodigoVentaHasta()" );
      ((Element)v.get(151)).setAttribute("req","N" );
      ((Element)v.get(151)).setAttribute("size","24" );
      ((Element)v.get(151)).setAttribute("valor","" );
      ((Element)v.get(151)).setAttribute("validacion","" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","25" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(155)).setAttribute("nombre","txtCodVentaHasta" );
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(155)).setAttribute("max","18" );
      ((Element)v.get(155)).setAttribute("tipo","" );
      ((Element)v.get(155)).setAttribute("onchange","" );
      ((Element)v.get(155)).setAttribute("req","N" );
      ((Element)v.get(155)).setAttribute("size","24" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("validacion","" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(159)).setAttribute("nombre","txtCodProductoDesde" );
      ((Element)v.get(159)).setAttribute("id","datosCampos" );
      ((Element)v.get(159)).setAttribute("max","20" );
      ((Element)v.get(159)).setAttribute("tipo","" );
      ((Element)v.get(159)).setAttribute("onchange","habilitarCodigoProductoHasta()" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(159)).setAttribute("req","N" );
      ((Element)v.get(159)).setAttribute("size","26" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(159)).setAttribute("validacion","" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(163)).setAttribute("nombre","txtCodProductoHasta" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).setAttribute("max","20" );
      ((Element)v.get(163)).setAttribute("tipo","" );
      ((Element)v.get(163)).setAttribute("onchange","habilitarPaginaHasta()" );
      ((Element)v.get(163)).setAttribute("req","N" );
      ((Element)v.get(163)).setAttribute("size","26" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(163)).setAttribute("validacion","" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:147   */

      /* Empieza nodo:166 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","3" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:169 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblDescripción" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","9" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","516" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(172)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblPaginaDesde" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","512" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblPaginaHasta" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","513" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:172   */

      /* Empieza nodo:191 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(195)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("max","30" );
      ((Element)v.get(195)).setAttribute("tipo","" );
      ((Element)v.get(195)).setAttribute("onchange","" );
      ((Element)v.get(195)).setAttribute("req","N" );
      ((Element)v.get(195)).setAttribute("size","30" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("validacion","" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(199)).setAttribute("nombre","cbCatalogo" );
      ((Element)v.get(199)).setAttribute("size","1" );
      ((Element)v.get(199)).setAttribute("multiple","N" );
      ((Element)v.get(199)).setAttribute("valorinicial","" );
      ((Element)v.get(199)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("req","N" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 191   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(204)).setAttribute("nombre","txtPaginaDesde" );
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("max","3" );
      ((Element)v.get(204)).setAttribute("tipo","" );
      ((Element)v.get(204)).setAttribute("onchange","habilitarPaginaHasta()" );
      ((Element)v.get(204)).setAttribute("req","N" );
      ((Element)v.get(204)).setAttribute("size","3" );
      ((Element)v.get(204)).setAttribute("valor","" );
      ((Element)v.get(204)).setAttribute("validacion","" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","25" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(208)).setAttribute("nombre","txtPaginaHasta" );
      ((Element)v.get(208)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).setAttribute("max","3" );
      ((Element)v.get(208)).setAttribute("tipo","" );
      ((Element)v.get(208)).setAttribute("onchange","" );
      ((Element)v.get(208)).setAttribute("req","N" );
      ((Element)v.get(208)).setAttribute("size","3" );
      ((Element)v.get(208)).setAttribute("valor","" );
      ((Element)v.get(208)).setAttribute("validacion","" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:191   */

      /* Empieza nodo:211 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("colspan","4" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:214 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("table"));
      ((Element)v.get(216)).setAttribute("width","100%" );
      ((Element)v.get(216)).setAttribute("border","0" );
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(216)).setAttribute("cellspacing","0" );
      ((Element)v.get(216)).setAttribute("cellpadding","0" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblOperadorPrecioCatalogo" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("id","datosTitle" );
      ((Element)v.get(221)).setAttribute("cod","2575" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(217)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","2576" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","100%" );
      ((Element)v.get(217)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:217   */

      /* Empieza nodo:228 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(232)).setAttribute("nombre","cbOperadorPrecioCatalogo" );
      ((Element)v.get(232)).setAttribute("size","1" );
      ((Element)v.get(232)).setAttribute("multiple","N" );
      ((Element)v.get(232)).setAttribute("valorinicial","" );
      ((Element)v.get(232)).setAttribute("textoinicial","" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("req","N" );
      ((Element)v.get(232)).setAttribute("onchange","cambioOperadorCatalogo()" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(234)).setAttribute("ID","1" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","1" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(236)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(236)).setAttribute("TIPO","STRING" );
      ((Element)v.get(236)).setAttribute("VALOR","<" );
      ((Element)v.get(234)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:234   */

      /* Empieza nodo:237 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(237)).setAttribute("ID","2" );
      ((Element)v.get(233)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(238)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(238)).setAttribute("TIPO","STRING" );
      ((Element)v.get(238)).setAttribute("VALOR","2" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(239)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(239)).setAttribute("TIPO","STRING" );
      ((Element)v.get(239)).setAttribute("VALOR",">" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(240)).setAttribute("ID","3" );
      ((Element)v.get(233)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(241)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(241)).setAttribute("TIPO","STRING" );
      ((Element)v.get(241)).setAttribute("VALOR","3" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(242)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(242)).setAttribute("TIPO","STRING" );
      ((Element)v.get(242)).setAttribute("VALOR","=" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(243)).setAttribute("ID","4" );
      ((Element)v.get(233)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(244)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(244)).setAttribute("TIPO","STRING" );
      ((Element)v.get(244)).setAttribute("VALOR","4" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 243   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(245)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(245)).setAttribute("TIPO","STRING" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(245)).setAttribute("VALOR","<=" );
      ((Element)v.get(243)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 233   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(246)).setAttribute("ID","5" );
      ((Element)v.get(233)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(247)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(247)).setAttribute("TIPO","STRING" );
      ((Element)v.get(247)).setAttribute("VALOR","5" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 246   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(248)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(248)).setAttribute("TIPO","STRING" );
      ((Element)v.get(248)).setAttribute("VALOR",">=" );
      ((Element)v.get(246)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:246   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:249 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(228)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(252)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("max","19" );
      ((Element)v.get(252)).setAttribute("tipo","" );
      ((Element)v.get(252)).setAttribute("onchange","cambioPrecioCatalogo()" );
      ((Element)v.get(252)).setAttribute("req","N" );
      ((Element)v.get(252)).setAttribute("size","26" );
      ((Element)v.get(252)).setAttribute("valor","" );
      ((Element)v.get(252)).setAttribute("validacion","" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("width","100%" );
      ((Element)v.get(228)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:228   */

      /* Empieza nodo:255 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("colspan","4" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:258 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("table"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(260)).setAttribute("border","0" );
      ((Element)v.get(260)).setAttribute("align","left" );
      ((Element)v.get(260)).setAttribute("cellspacing","0" );
      ((Element)v.get(260)).setAttribute("cellpadding","0" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(265)).setAttribute("nombre","lblTipoSolicitud" );
      ((Element)v.get(265)).setAttribute("alto","13" );
      ((Element)v.get(265)).setAttribute("filas","1" );
      ((Element)v.get(265)).setAttribute("id","datosTitle" );
      ((Element)v.get(265)).setAttribute("cod","415" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","25" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 261   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lblTipoLinea" );
      ((Element)v.get(269)).setAttribute("alto","13" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("id","datosTitle" );
      ((Element)v.get(269)).setAttribute("cod","2633" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(261)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:261   */

      /* Empieza nodo:272 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(272));

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
      ((Element)v.get(275)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(276)).setAttribute("nombre","cbTipoSolicitud" );
      ((Element)v.get(276)).setAttribute("size","1" );
      ((Element)v.get(276)).setAttribute("multiple","N" );
      ((Element)v.get(276)).setAttribute("valorinicial","" );
      ((Element)v.get(276)).setAttribute("textoinicial","" );
      ((Element)v.get(276)).setAttribute("id","datosCampos" );
      ((Element)v.get(276)).setAttribute("req","N" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:278 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","25" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(272)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(281)).setAttribute("nombre","cbTipoLinea" );
      ((Element)v.get(281)).setAttribute("size","1" );
      ((Element)v.get(281)).setAttribute("multiple","N" );
      ((Element)v.get(281)).setAttribute("valorinicial","" );
      ((Element)v.get(281)).setAttribute("textoinicial","" );
      ((Element)v.get(281)).setAttribute("id","datosCampos" );
      ((Element)v.get(281)).setAttribute("req","N" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(272)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:272   */

      /* Empieza nodo:285 / Elemento padre: 260   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(260)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("colspan","4" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:288 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("table"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(290)).setAttribute("border","0" );
      ((Element)v.get(290)).setAttribute("align","left" );
      ((Element)v.get(290)).setAttribute("cellspacing","0" );
      ((Element)v.get(290)).setAttribute("cellpadding","0" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lblOperadorUnidadesTotales" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("id","datosTitle" );
      ((Element)v.get(295)).setAttribute("cod","2634" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lblUnidadesTotales" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","1015" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","25" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(303)).setAttribute("nombre","lblOperadorUnidadesFaltantes" );
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("id","datosTitle" );
      ((Element)v.get(303)).setAttribute("cod","2635" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","25" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(307)).setAttribute("nombre","lblUnidadesFaltantes" );
      ((Element)v.get(307)).setAttribute("alto","13" );
      ((Element)v.get(307)).setAttribute("filas","1" );
      ((Element)v.get(307)).setAttribute("id","datosTitle" );
      ((Element)v.get(307)).setAttribute("cod","1459" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(291)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:291   */

      /* Empieza nodo:310 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(314)).setAttribute("nombre","cbOperadorUnidadesTotales" );
      ((Element)v.get(314)).setAttribute("size","1" );
      ((Element)v.get(314)).setAttribute("multiple","N" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(314)).setAttribute("valorinicial","" );
      ((Element)v.get(314)).setAttribute("textoinicial","" );
      ((Element)v.get(314)).setAttribute("id","datosCampos" );
      ((Element)v.get(314)).setAttribute("req","N" );
      ((Element)v.get(314)).setAttribute("onchange","cambioOperadorTotales()" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(316)).setAttribute("ID","1" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(317)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(317)).setAttribute("TIPO","STRING" );
      ((Element)v.get(317)).setAttribute("VALOR","1" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 316   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(318)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(318)).setAttribute("TIPO","STRING" );
      ((Element)v.get(318)).setAttribute("VALOR","<" );
      ((Element)v.get(316)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:316   */

      /* Empieza nodo:319 / Elemento padre: 315   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(319)).setAttribute("ID","2" );
      ((Element)v.get(315)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(320)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(320)).setAttribute("TIPO","STRING" );
      ((Element)v.get(320)).setAttribute("VALOR","2" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 319   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(321)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(321)).setAttribute("TIPO","STRING" );
      ((Element)v.get(321)).setAttribute("VALOR",">" );
      ((Element)v.get(319)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:319   */

      /* Empieza nodo:322 / Elemento padre: 315   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(322)).setAttribute("ID","3" );
      ((Element)v.get(315)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(323)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(323)).setAttribute("TIPO","STRING" );
      ((Element)v.get(323)).setAttribute("VALOR","3" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 322   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(324)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(324)).setAttribute("TIPO","STRING" );
      ((Element)v.get(324)).setAttribute("VALOR","=" );
      ((Element)v.get(322)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:322   */

      /* Empieza nodo:325 / Elemento padre: 315   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(325)).setAttribute("ID","4" );
      ((Element)v.get(315)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(326)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(326)).setAttribute("TIPO","STRING" );
      ((Element)v.get(326)).setAttribute("VALOR","4" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 325   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(327)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(327)).setAttribute("TIPO","STRING" );
      ((Element)v.get(327)).setAttribute("VALOR","<=" );
      ((Element)v.get(325)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 315   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(328)).setAttribute("ID","5" );
      ((Element)v.get(315)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(329)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(329)).setAttribute("TIPO","STRING" );
      ((Element)v.get(329)).setAttribute("VALOR","5" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(330)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(330)).setAttribute("TIPO","STRING" );
      ((Element)v.get(330)).setAttribute("VALOR",">=" );
      ((Element)v.get(328)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:328   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:331 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(310)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(334)).setAttribute("nombre","txtUnidadesTotales" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(334)).setAttribute("max","13" );
      ((Element)v.get(334)).setAttribute("tipo","" );
      ((Element)v.get(334)).setAttribute("onchange","cambioUnidadesTotales()" );
      ((Element)v.get(334)).setAttribute("req","N" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(334)).setAttribute("size","18" );
      ((Element)v.get(334)).setAttribute("valor","" );
      ((Element)v.get(334)).setAttribute("validacion","" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","25" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(310)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(338)).setAttribute("nombre","cbOperadorUnidadesFaltantes" );
      ((Element)v.get(338)).setAttribute("size","1" );
      ((Element)v.get(338)).setAttribute("multiple","N" );
      ((Element)v.get(338)).setAttribute("valorinicial","" );
      ((Element)v.get(338)).setAttribute("textoinicial","" );
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(338)).setAttribute("req","N" );
      ((Element)v.get(338)).setAttribute("onchange","cambioOperadorFaltantes()" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(340)).setAttribute("ID","1" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(341)).setAttribute("TIPO","STRING" );
      ((Element)v.get(341)).setAttribute("VALOR","1" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 340   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(342)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(342)).setAttribute("TIPO","STRING" );
      ((Element)v.get(342)).setAttribute("VALOR","<" );
      ((Element)v.get(340)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:340   */

      /* Empieza nodo:343 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(343)).setAttribute("ID","2" );
      ((Element)v.get(339)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(344)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(344)).setAttribute("TIPO","STRING" );
      ((Element)v.get(344)).setAttribute("VALOR","2" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 343   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(345)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(345)).setAttribute("TIPO","STRING" );
      ((Element)v.get(345)).setAttribute("VALOR",">" );
      ((Element)v.get(343)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:343   */

      /* Empieza nodo:346 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(346)).setAttribute("ID","3" );
      ((Element)v.get(339)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(347)).setAttribute("TIPO","STRING" );
      ((Element)v.get(347)).setAttribute("VALOR","3" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 346   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(348)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(348)).setAttribute("TIPO","STRING" );
      ((Element)v.get(348)).setAttribute("VALOR","=" );
      ((Element)v.get(346)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:346   */

      /* Empieza nodo:349 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(349)).setAttribute("ID","4" );
      ((Element)v.get(339)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(350)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(350)).setAttribute("TIPO","STRING" );
      ((Element)v.get(350)).setAttribute("VALOR","4" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 349   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(351)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(351)).setAttribute("TIPO","STRING" );
      ((Element)v.get(351)).setAttribute("VALOR","<=" );
      ((Element)v.get(349)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:349   */

      /* Empieza nodo:352 / Elemento padre: 339   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(352)).setAttribute("ID","5" );
      ((Element)v.get(339)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(353)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","5" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(354)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(354)).setAttribute("TIPO","STRING" );
      ((Element)v.get(354)).setAttribute("VALOR",">=" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(352)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:352   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:355 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","25" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(310)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(358)).setAttribute("nombre","txtUnidadesFaltantes" );
      ((Element)v.get(358)).setAttribute("id","datosCampos" );
      ((Element)v.get(358)).setAttribute("max","13" );
      ((Element)v.get(358)).setAttribute("tipo","" );
      ((Element)v.get(358)).setAttribute("onchange","cambioUnidadesFaltantes()" );
      ((Element)v.get(358)).setAttribute("req","N" );
      ((Element)v.get(358)).setAttribute("size","18" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(358)).setAttribute("validacion","" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("width","100%" );
      ((Element)v.get(310)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:310   */

      /* Empieza nodo:361 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).setAttribute("colspan","4" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","8" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:364 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("table"));
      ((Element)v.get(366)).setAttribute("width","100%" );
      ((Element)v.get(366)).setAttribute("border","0" );
      ((Element)v.get(366)).setAttribute("align","left" );
      ((Element)v.get(366)).setAttribute("cellspacing","0" );
      ((Element)v.get(366)).setAttribute("cellpadding","0" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(371)).setAttribute("nombre","lblVista" );
      ((Element)v.get(371)).setAttribute("alto","13" );
      ((Element)v.get(371)).setAttribute("filas","1" );
      ((Element)v.get(371)).setAttribute("id","datosTitle" );
      ((Element)v.get(371)).setAttribute("cod","2647" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","25" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(375)).setAttribute("nombre","lblCriterioOrdenacion1" );
      ((Element)v.get(375)).setAttribute("alto","13" );
      ((Element)v.get(375)).setAttribute("filas","1" );
      ((Element)v.get(375)).setAttribute("id","datosTitle" );
      ((Element)v.get(375)).setAttribute("cod","2626" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","25" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(379)).setAttribute("nombre","lblCriterioOrdenacion2" );
      ((Element)v.get(379)).setAttribute("alto","13" );
      ((Element)v.get(379)).setAttribute("filas","1" );
      ((Element)v.get(379)).setAttribute("id","datosTitle" );
      ((Element)v.get(379)).setAttribute("cod","2627" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","25" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(383)).setAttribute("nombre","lblCriterioOrdenacion3" );
      ((Element)v.get(383)).setAttribute("alto","13" );
      ((Element)v.get(383)).setAttribute("filas","1" );
      ((Element)v.get(383)).setAttribute("id","datosTitle" );
      ((Element)v.get(383)).setAttribute("cod","2628" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(367)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:367   */

      /* Empieza nodo:386 / Elemento padre: 366   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(366)).appendChild((Element)v.get(386));

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
      ((Element)v.get(389)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(386)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(390)).setAttribute("nombre","cbVista" );
      ((Element)v.get(390)).setAttribute("size","1" );
      ((Element)v.get(390)).setAttribute("multiple","N" );
      ((Element)v.get(390)).setAttribute("valorinicial","1" );
      ((Element)v.get(390)).setAttribute("textoinicial","por código de venta" );
      ((Element)v.get(390)).setAttribute("id","datosCampos" );
      ((Element)v.get(390)).setAttribute("req","N" );
      ((Element)v.get(390)).setAttribute("onchange","onchangeVista()" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(392)).setAttribute("ID","1" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(393)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(393)).setAttribute("TIPO","STRING" );
      ((Element)v.get(393)).setAttribute("VALOR","2" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 392   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(394)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(394)).setAttribute("TIPO","STRING" );
      ((Element)v.get(394)).setAttribute("VALOR","por tipo de solicitud " );
      ((Element)v.get(392)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:395 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","25" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(386)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(398)).setAttribute("nombre","cbCriterioOrdenacion1" );
      ((Element)v.get(398)).setAttribute("size","1" );
      ((Element)v.get(398)).setAttribute("multiple","N" );
      ((Element)v.get(398)).setAttribute("valorinicial","" );
      ((Element)v.get(398)).setAttribute("textoinicial","" );
      ((Element)v.get(398)).setAttribute("id","datosCampos" );
      ((Element)v.get(398)).setAttribute("req","N" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(400)).setAttribute("ID","1" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(401)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(401)).setAttribute("TIPO","STRING" );
      ((Element)v.get(401)).setAttribute("VALOR","1" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 400   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(402)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(402)).setAttribute("TIPO","STRING" );
      ((Element)v.get(402)).setAttribute("VALOR","Unidades totales" );
      ((Element)v.get(400)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:400   */

      /* Empieza nodo:403 / Elemento padre: 399   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(403)).setAttribute("ID","2" );
      ((Element)v.get(399)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(404)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(404)).setAttribute("TIPO","STRING" );
      ((Element)v.get(404)).setAttribute("VALOR","2" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 403   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(405)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(405)).setAttribute("TIPO","STRING" );
      ((Element)v.get(405)).setAttribute("VALOR","Código venta" );
      ((Element)v.get(403)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:403   */

      /* Empieza nodo:406 / Elemento padre: 399   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(406)).setAttribute("ID","3" );
      ((Element)v.get(399)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(407)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(407)).setAttribute("TIPO","STRING" );
      ((Element)v.get(407)).setAttribute("VALOR","3" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 406   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(408)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(408)).setAttribute("TIPO","STRING" );
      ((Element)v.get(408)).setAttribute("VALOR","Código producto" );
      ((Element)v.get(406)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:406   */

      /* Empieza nodo:409 / Elemento padre: 399   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(409)).setAttribute("ID","4" );
      ((Element)v.get(399)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(410)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(410)).setAttribute("TIPO","STRING" );
      ((Element)v.get(410)).setAttribute("VALOR","4" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 409   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(411)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(411)).setAttribute("TIPO","STRING" );
      ((Element)v.get(411)).setAttribute("VALOR","Número página" );
      ((Element)v.get(409)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:409   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:412 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","25" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(386)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(415)).setAttribute("nombre","cbCriterioOrdenacion2" );
      ((Element)v.get(415)).setAttribute("size","1" );
      ((Element)v.get(415)).setAttribute("multiple","N" );
      ((Element)v.get(415)).setAttribute("valorinicial","" );
      ((Element)v.get(415)).setAttribute("textoinicial","" );
      ((Element)v.get(415)).setAttribute("id","datosCampos" );
      ((Element)v.get(415)).setAttribute("req","N" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(417)).setAttribute("ID","1" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(418)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(418)).setAttribute("TIPO","STRING" );
      ((Element)v.get(418)).setAttribute("VALOR","1" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","Unidades totales" );
      ((Element)v.get(417)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:417   */

      /* Empieza nodo:420 / Elemento padre: 416   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(420)).setAttribute("ID","2" );
      ((Element)v.get(416)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(421)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(421)).setAttribute("TIPO","STRING" );
      ((Element)v.get(421)).setAttribute("VALOR","2" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","Código venta" );
      ((Element)v.get(420)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:420   */

      /* Empieza nodo:423 / Elemento padre: 416   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(423)).setAttribute("ID","3" );
      ((Element)v.get(416)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(424)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(424)).setAttribute("TIPO","STRING" );
      ((Element)v.get(424)).setAttribute("VALOR","3" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","Código producto" );
      ((Element)v.get(423)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:423   */

      /* Empieza nodo:426 / Elemento padre: 416   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(426)).setAttribute("ID","4" );
      ((Element)v.get(416)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(427)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(427)).setAttribute("TIPO","STRING" );
      ((Element)v.get(427)).setAttribute("VALOR","4" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 426   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(428)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(428)).setAttribute("TIPO","STRING" );
      ((Element)v.get(428)).setAttribute("VALOR","Número página" );
      ((Element)v.get(426)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:426   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:429 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","25" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(386)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(432)).setAttribute("nombre","cbCriterioOrdenacion3" );
      ((Element)v.get(432)).setAttribute("size","1" );
      ((Element)v.get(432)).setAttribute("multiple","N" );
      ((Element)v.get(432)).setAttribute("valorinicial","" );
      ((Element)v.get(432)).setAttribute("textoinicial","" );
      ((Element)v.get(432)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).setAttribute("req","N" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(434)).setAttribute("ID","1" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(435)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(435)).setAttribute("TIPO","STRING" );
      ((Element)v.get(435)).setAttribute("VALOR","1" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","Unidades totales" );
      ((Element)v.get(434)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:434   */

      /* Empieza nodo:437 / Elemento padre: 433   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(437)).setAttribute("ID","2" );
      ((Element)v.get(433)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(438)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(438)).setAttribute("TIPO","STRING" );
      ((Element)v.get(438)).setAttribute("VALOR","2" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 437   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","Código venta" );
      ((Element)v.get(437)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:437   */

      /* Empieza nodo:440 / Elemento padre: 433   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(440)).setAttribute("ID","3" );
      ((Element)v.get(433)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(441)).setAttribute("NOMBRE","CODIGO" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(441)).setAttribute("TIPO","STRING" );
      ((Element)v.get(441)).setAttribute("VALOR","3" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 440   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","Código producto" );
      ((Element)v.get(440)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:440   */

      /* Empieza nodo:443 / Elemento padre: 433   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(443)).setAttribute("ID","4" );
      ((Element)v.get(433)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(444)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(444)).setAttribute("TIPO","STRING" );
      ((Element)v.get(444)).setAttribute("VALOR","4" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */

      /* Empieza nodo:445 / Elemento padre: 443   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(445)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(445)).setAttribute("TIPO","STRING" );
      ((Element)v.get(445)).setAttribute("VALOR","Número página" );
      ((Element)v.get(443)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:443   */
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:446 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).setAttribute("width","100%" );
      ((Element)v.get(386)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","8" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:386   */

      /* Empieza nodo:448 / Elemento padre: 366   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(366)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).setAttribute("colspan","4" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).setAttribute("width","8" );
      ((Element)v.get(450)).setAttribute("height","8" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:41   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:451 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:34   */

      /* Empieza nodo:453 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("table"));
      ((Element)v.get(458)).setAttribute("width","100%" );
      ((Element)v.get(458)).setAttribute("border","0" );
      ((Element)v.get(458)).setAttribute("align","center" );
      ((Element)v.get(458)).setAttribute("cellspacing","0" );
      ((Element)v.get(458)).setAttribute("cellpadding","0" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(460)).setAttribute("class","botonera" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(461)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(461)).setAttribute("ID","botonContenido" );
      ((Element)v.get(461)).setAttribute("tipo","html" );
      ((Element)v.get(461)).setAttribute("accion","generar('pdf')" );
      ((Element)v.get(461)).setAttribute("estado","false" );
      ((Element)v.get(461)).setAttribute("cod","2495" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 460   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(462)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(462)).setAttribute("ID","botonContenido" );
      ((Element)v.get(462)).setAttribute("tipo","html" );
      ((Element)v.get(462)).setAttribute("accion","generar('xls')" );
      ((Element)v.get(462)).setAttribute("estado","false" );
      ((Element)v.get(462)).setAttribute("cod","2526" );
      ((Element)v.get(462)).setAttribute("ontab","focaliza('Formulario.cbMarca')" );
      ((Element)v.get(460)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:463 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).setAttribute("width","8" );
      ((Element)v.get(464)).setAttribute("height","12" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:453   */

      /* Empieza nodo:465 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("width","12" );
      ((Element)v.get(466)).setAttribute("align","center" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","12" );
      ((Element)v.get(467)).setAttribute("height","12" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).setAttribute("width","756" );
      ((Element)v.get(465)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).setAttribute("width","12" );
      ((Element)v.get(465)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","12" );
      ((Element)v.get(471)).setAttribute("height","1" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:465   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:17   */


   }

}
