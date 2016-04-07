
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_configuracion_matriz_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_configuracion_matriz_generar" );
      ((Element)v.get(0)).setAttribute("cod","0794" );
      ((Element)v.get(0)).setAttribute("titulo","Generar informe de configuracion de matriz de facturaci�n" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      deshabilitar();\r      focaliza('Formulario.cbMarca');\r   }\r\r    function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r   function generar(formato){\r       var operadorCatalogo = get('Formulario.cbOperadorPrecioCatalogo');\r       var precioCatalogo   = get('Formulario.txtPrecioCatalogo');\r       var precioContable   = get('Formulario.txtPrecioContable');\r       var operadorContable = get('Formulario.cbOperadorPrecioContable');\r       \r       if(operadorCatalogo !=''){\r          sicc_cambiar_estado('txtPrecioCatalogo', true);\r       }else{\r          sicc_cambiar_estado('txtPrecioCatalogo', false);\r       }\r       \r       if(precioCatalogo != ''){\r          sicc_cambiar_estado('cbOperadorPrecioCatalogo', true);\r       }else{\r          sicc_cambiar_estado('cbOperadorPrecioCatalogo', false);\r       }\r          \r       if(operadorContable !=''){\r          sicc_cambiar_estado('txtPrecioContable', true);\r       }else{\r          sicc_cambiar_estado('txtPrecioContable', false);\r       }\r       \r       if(precioContable !=''){\r          sicc_cambiar_estado('cbOperadorPrecioContable', true);\r       }else{\r          sicc_cambiar_estado('cbOperadorPrecioContable', false);\r       }\r      \r       if(sicc_validaciones_generales()){\r         if(validacionesExternas()){\r             \r            /*recolectarParametros();\r	    set('Formulario.formatoSalida',formato);\r            set('Formulario.conectorAction', 'PREConfigMF');           \r            set('Formulario.accion', 'generar');\r      \r            enviaSICC('Formulario');*/\r            var a = new Object();\r            a.accion = 'generar';\r            a.marca = get('Formulario.cbMarca');  \r            a.canal = get('Formulario.cbCanal');\r            a.marcaDesc = get('Formulario.cbMarca', 'T');  \r            a.canalDesc = get('Formulario.cbCanal', 'T');\r            a.periodo = get('Formulario.cbPeriodo');\r            a.periodoDesc = get('Formulario.cbPeriodo','T');\r            a.acceso = quitarItemVacio(get('Formulario.cbAcceso'));             \r            a.cicloVida = get('Formulario.cbCicloVida');\r            a.tipoOferta = get('Formulario.cbTipoOferta');          \r            a.codigoProductoDesde = get('Formulario.txtCodProductoDesde');  \r            a.codigoProductoHasta = get('Formulario.txtCodProductoHasta');\r            a.codigoVentaDesde = get('Formulario.txtCodVentaDesde');           \r            a.codigoVentaHasta = get('Formulario.txtCodVentaHasta');             \r            a.tipoEstrategia = get('Formulario.cbTipoEstrategia');\r            a.operadorPrecioCatalogo = get('Formulario.cbOperadorPrecioCatalogo');\r            a.precioCatalogo = get('Formulario.txtPrecioCatalogo');  \r            a.operadorPrecioContable = get('Formulario.cbOperadorPrecioContable');\r            a.precioContable = get('Formulario.txtPrecioContable');  \r            a.catalogo = quitarItemVacio(get('Formulario.cbCatalogo'));\r            a.paginaDesde = get('Formulario.txtPaginaDesde');\r            a.paginaHasta = get('Formulario.txtPaginaHasta');  \r            a.formaPago = quitarItemVacio(get('Formulario.cbFormaPago'));\r            a.vista = get('Formulario.cbVista');\r            a.critOrden1 = obtenerCampoCriterio(get('Formulario.cbCriterioOrdenacion1'));\r            a.critOrden2 = obtenerCampoCriterio(get('Formulario.cbCriterioOrdenacion2'));\r            a.critOrden3 = obtenerCampoCriterio(get('Formulario.cbCriterioOrdenacion3'));  \r            a.formatoSalida = formato;\r            mostrarModalSICC('PREConfigMF','generar', a);  \r        }\r        \r      }\r\r   }\r\r   function recolectarParametros(){\r      \r      \r     \r      set('Formulario.marca', get('Formulario.cbMarca') );  \r      set('Formulario.canal', get('Formulario.cbCanal'));\r      set('Formulario.periodo', get('Formulario.cbPeriodo') );\r      set('Formulario.acceso', quitarItemVacio(get('Formulario.cbAcceso') ));  \r      \r      set('Formulario.cicloVida', get('Formulario.cbCicloVida'));\r      set('Formulario.tipoOferta', get('Formulario.cbTipoOferta') );\r      \r      set('Formulario.codigoProductoDesde', get('Formulario.txtCodProductoDesde') );  \r      set('Formulario.codigoProductoHasta', get('Formulario.txtCodProductoHasta'));\r      set('Formulario.codigoVentaDesde', get('Formulario.txtCodVentaDesde') );\r      \r      set('Formulario.codigoVentaHasta', get('Formulario.txtCodVentaHasta') );  \r      \r      set('Formulario.tipoEstrategia', get('Formulario.cbTipoEstrategia'));\r      set('Formulario.operadorPrecioCatalogo', get('Formulario.cbOperadorPrecioCatalogo') );\r      set('Formulario.precioCatalogo', get('Formulario.txtPrecioCatalogo') );  \r      set('Formulario.operadorPrecioContable', get('Formulario.cbOperadorPrecioContable') );\r      set('Formulario.precioContable', get('Formulario.txtPrecioContable') );  \r      set('Formulario.catalogo', quitarItemVacio(get('Formulario.cbCatalogo')));\r      set('Formulario.paginaDesde', get('Formulario.txtPaginaDesde') );\r      set('Formulario.paginaHasta', get('Formulario.txtPaginaHasta') );  \r      set('Formulario.formaPago', quitarItemVacio(get('Formulario.cbFormaPago')));\r      set('Formulario.vista', get('Formulario.cbVista') );\r      set('Formulario.critOrden1', obtenerCampoCriterio(get('Formulario.cbCriterioOrdenacion1')));\r      set('Formulario.critOrden2', obtenerCampoCriterio(get('Formulario.cbCriterioOrdenacion2')));\r      set('Formulario.critOrden3', obtenerCampoCriterio(get('Formulario.cbCriterioOrdenacion3')));\r         \r  \r   }\r \r   \r\r   function obtenerCampoCriterio(campo){\r      var criterio = campo;\r      \r      var campoCriterio;\r      \r      if(criterio == 1){\r         campoCriterio = \"'IMP_PREC_CATA'\";\r      }\r      \r      if(criterio == 2){\r         campoCriterio = \"'COD_CATA'\";\r      }\r      \r      if(criterio == 3){\r         campoCriterio = \"'Estrategia'\";\r      }\r      \r      if(criterio == 4){\r         campoCriterio = \"'VAL_CODI_VENT'\";\r      }\r      \r      if(criterio == 5){\r         campoCriterio = \"'NUM_PAGI_CATA'\";\r      }\r      \r      return campoCriterio;\r \r   }\r   function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbPeriodo', aCombo, []);\r      \r      focaliza('Formulario.cbCanal');\r \r   }\r   \r    function onchangeMarcaCanal(){\r        \r       marca  = get('Formulario.cbMarca');\r       canal  = get('Formulario.cbCanal');\r       pais   = get('Formulario.pais');\r       idioma = get('Formulario.idioma');\r       \r       \r       if(marca != '' && canal != ''){\r       \r          var arr = new Array();\r          \r              \r          arr[arr.length] = [\"oidIdioma\", idioma]; \r          arr[arr.length] = [\"oidPais\", pais]; \r          arr[arr.length] = [\"marca\", marca];\r          arr[arr.length] = [\"canal\", canal];\r          \r          \r           \r          recargaCombo(\"Formulario.cbPeriodo\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r          \r            \r       \r       }else{\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('Formulario.cbPeriodo', aCombo, []);\r       \r       }\r   \r    } \r    \r\r   function deshabilitar(){\r      accion('Formulario.txtCodProductoHasta', '.disabled=true');\r      accion('Formulario.txtCodVentaHasta', '.disabled=true');\r      accion('Formulario.txtPaginaHasta', '.disabled=true');\r   \r   \r   \r   }\r    \r\r   function habilitarCodigoVenta(){\r         \r      if(get('Formulario.txtCodVentaDesde') != ''){\r         accion('Formulario.txtCodVentaHasta', '.disabled=false');\r         focaliza('Formulario.txtCodVentaHasta');\r      }else{\r         accion('Formulario.txtCodVentaHasta', '.disabled=true');\r         focaliza('Formulario.txtCodProductoDesde');\r      }\r   \r   }\r   \r\r   function habilitarCodigoProducto(){\r         \r      if(get('Formulario.txtCodProductoDesde') != ''){\r         accion('Formulario.txtCodProductoHasta', '.disabled=false');\r         focaliza('Formulario.txtCodProductoHasta');\r      }else{\r         accion('Formulario.txtCodProductoHasta', '.disabled=true');\r         focaliza('Formulario.cbTipoEstrategia');\r      }\r   \r   }   \r   \r\r   function habilitarPagina(){\r         \r      if(get('Formulario.txtPaginaDesde') != ''){\r         accion('Formulario.txtPaginaHasta', '.disabled=false');\r         focaliza('Formulario.txtPaginaHasta');\r      }else{\r         accion('Formulario.txtPaginaHasta', '.disabled=true');\r         focaliza('Formulario.cbFormaPago');\r      }\r   \r   } \r\r    function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r    \r      set_combo('Formulario.cbPeriodo', aCombo, []);\r      focaliza('Formulario.cbMarca');\r \r   }\r\r   function onchangeVista(){\r   \r      vista = get('Formulario.cbVista');\r      \r      if(vista == 1){\r         accion('Formulario.cbCriterioOrdenacion1', '.disabled=false');    \r         accion('Formulario.cbCriterioOrdenacion2', '.disabled=false');    \r         accion('Formulario.cbCriterioOrdenacion3', '.disabled=false');    \r      }else{\r         accion('Formulario.cbCriterioOrdenacion1', '.disabled=true');    \r         accion('Formulario.cbCriterioOrdenacion2', '.disabled=true');    \r         accion('Formulario.cbCriterioOrdenacion3', '.disabled=true');    \r      \r      }\r   \r   }\r  \r    function validacionesExternas(){\r                          \r       var paginaDesde = get('Formulario.txtPaginaDesde');\r       var paginaHasta = get('Formulario.txtPaginaHasta');\r    \r       if(paginaDesde != ''){\r         if(fValidarNumero(paginaDesde, 200, 0, 9999999)!='OK'){\r             GestionarMensaje('405'); \r             focaliza('Formulario.txtPaginaDesde');\r             return false;\r         }\r       }\r       \r       if(paginaHasta != ''){\r         if(fValidarNumero(paginaHasta, 200, 0, 9999999)!='OK'){\r             GestionarMensaje('405'); \r             focaliza('Formulario.txtPaginaHasta');\r             return false;\r         }\r       }\r       \r       return true;\r   \r    }\r    \r    \r   function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r         if (elemento[k] != ''){ 			 \r            elementoADevolver[elementoADevolver.length] = elemento[k];\r         }\r      }\r        \r      return elementoADevolver;\r      \r   }\r\r    \r    \r    \r\r   \r\r   \r"));
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
      ((Element)v.get(9)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","276" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbOperadorPrecioCatalogo" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","2575" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtPrecioCatalogo" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","2576" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbOperadorPrecioContable" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","2577" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtPrecioContable" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","2578" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */

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
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","marca" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","canal" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","periodo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","acceso" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","cicloVida" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","tipoOferta" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","codigoProductoDesde" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","codigoProductoHasta" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","codigoVentaDesde" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","codigoVentaHasta" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","tipoEstrategia" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","operadorPrecioCatalogo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","precioCatalogo" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","operadorPrecioContable" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","precioContable" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","catalogo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","paginaDesde" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","paginaHasta" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","formasPago" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","vista" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","critOrden1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","critOrden2" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("nombre","critOrden3" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","formatoSalida" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(46)).setAttribute("nombre","capa1" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("height","12" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","750" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
      ((Element)v.get(54)).setAttribute("height","1" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:48   */

      /* Empieza nodo:55 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(60)).setAttribute("class","legend" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","legend" );
      ((Element)v.get(61)).setAttribute("cod","00275" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

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
      ((Element)v.get(67)).setAttribute("colspan","4" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblPais" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","5" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","6" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:69   */

      /* Empieza nodo:80 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("req","S" );
      ((Element)v.get(88)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarInforme')" );
      ((Element)v.get(88)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:80   */

      /* Empieza nodo:92 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(92));

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
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:95 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(95));

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
      ((Element)v.get(102)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","7" );
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
      ((Element)v.get(106)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","276" );
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
      ((Element)v.get(113)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("req","S" );
      ((Element)v.get(113)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
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
      ((Element)v.get(109)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(118)).setAttribute("nombre","cbPeriodo" );
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

      /* Empieza nodo:125 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(125));

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
      ((Element)v.get(132)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","10" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:128   */

      /* Empieza nodo:135 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(139)).setAttribute("nombre","cbAcceso" );
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

      /* Empieza nodo:141 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(135)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:135   */

      /* Empieza nodo:143 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(143));

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
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:146 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(146));

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
      ((Element)v.get(153)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("cod","581" );
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
      ((Element)v.get(157)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("id","datosTitle" );
      ((Element)v.get(157)).setAttribute("cod","608" );
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
   }

   private void getXML630(Document doc) {
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(164)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(164)).setAttribute("size","1" );
      ((Element)v.get(164)).setAttribute("multiple","N" );
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
      ((Element)v.get(169)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(169)).setAttribute("size","1" );
      ((Element)v.get(169)).setAttribute("multiple","N" );
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

      /* Empieza nodo:176 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(176));

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
      ((Element)v.get(183)).setAttribute("nombre","lblCodVentaDesde" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("cod","2572" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
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
   }

   private void getXML720(Document doc) {
      ((Element)v.get(187)).setAttribute("nombre","lblCodVentaHasta" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("cod","2573" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblCodProductoDesde" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("cod","2570" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblCodProductoHasta" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("cod","2571" );
      ((Element)v.get(195)).setAttribute("id","datosTitle" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:179   */

      /* Empieza nodo:198 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(202)).setAttribute("nombre","txtCodVentaDesde" );
      ((Element)v.get(202)).setAttribute("id","datosCampos" );
      ((Element)v.get(202)).setAttribute("max","18" );
      ((Element)v.get(202)).setAttribute("tipo","" );
      ((Element)v.get(202)).setAttribute("req","N" );
      ((Element)v.get(202)).setAttribute("size","24" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("validacion","" );
      ((Element)v.get(202)).setAttribute("onchange","habilitarCodigoVenta()" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(206)).setAttribute("nombre","txtCodVentaHasta" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("max","18" );
      ((Element)v.get(206)).setAttribute("tipo","" );
      ((Element)v.get(206)).setAttribute("onchange","" );
      ((Element)v.get(206)).setAttribute("req","N" );
      ((Element)v.get(206)).setAttribute("size","24" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("validacion","" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 198   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(210)).setAttribute("nombre","txtCodProductoDesde" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("max","20" );
      ((Element)v.get(210)).setAttribute("tipo","" );
      ((Element)v.get(210)).setAttribute("req","N" );
      ((Element)v.get(210)).setAttribute("size","26" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("validacion","" );
      ((Element)v.get(210)).setAttribute("onchange","habilitarCodigoProducto()" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(214)).setAttribute("nombre","txtCodProductoHasta" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("max","20" );
      ((Element)v.get(214)).setAttribute("tipo","" );
      ((Element)v.get(214)).setAttribute("onchange","" );
      ((Element)v.get(214)).setAttribute("req","N" );
      ((Element)v.get(214)).setAttribute("size","26" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("validacion","" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(198)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:198   */

      /* Empieza nodo:217 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","3" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:220 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("align","left" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(227)).setAttribute("nombre","lblTipoEstrategia" );
      ((Element)v.get(227)).setAttribute("alto","13" );
      ((Element)v.get(227)).setAttribute("filas","1" );
      ((Element)v.get(227)).setAttribute("id","datosTitle" );
      ((Element)v.get(227)).setAttribute("cod","460" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:223   */

      /* Empieza nodo:230 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(230));

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
      ((Element)v.get(233)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(230)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(234)).setAttribute("nombre","cbTipoEstrategia" );
      ((Element)v.get(234)).setAttribute("size","1" );
      ((Element)v.get(234)).setAttribute("multiple","N" );
      ((Element)v.get(234)).setAttribute("valorinicial","" );
      ((Element)v.get(234)).setAttribute("textoinicial","" );
      ((Element)v.get(234)).setAttribute("id","datosCampos" );
      ((Element)v.get(234)).setAttribute("req","N" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:236 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(230)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:230   */

      /* Empieza nodo:238 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("colspan","4" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:241 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("table"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(243)).setAttribute("border","0" );
      ((Element)v.get(243)).setAttribute("align","left" );
      ((Element)v.get(243)).setAttribute("cellspacing","0" );
      ((Element)v.get(243)).setAttribute("cellpadding","0" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(248)).setAttribute("nombre","lblOperadorPrecioCatalogo" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("id","datosTitle" );
      ((Element)v.get(248)).setAttribute("cod","2575" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(252)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(252)).setAttribute("alto","13" );
      ((Element)v.get(252)).setAttribute("filas","1" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(252)).setAttribute("id","datosTitle" );
      ((Element)v.get(252)).setAttribute("cod","2576" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","25" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(256)).setAttribute("nombre","lblOperadorPrecioContable" );
      ((Element)v.get(256)).setAttribute("alto","13" );
      ((Element)v.get(256)).setAttribute("filas","1" );
      ((Element)v.get(256)).setAttribute("id","datosTitle" );
      ((Element)v.get(256)).setAttribute("cod","2577" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","25" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(260)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(260)).setAttribute("alto","13" );
      ((Element)v.get(260)).setAttribute("filas","1" );
      ((Element)v.get(260)).setAttribute("id","datosTitle" );
      ((Element)v.get(260)).setAttribute("cod","2578" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(244)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:244   */

      /* Empieza nodo:263 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(267)).setAttribute("nombre","cbOperadorPrecioCatalogo" );
      ((Element)v.get(267)).setAttribute("size","1" );
      ((Element)v.get(267)).setAttribute("multiple","N" );
      ((Element)v.get(267)).setAttribute("valorinicial","" );
      ((Element)v.get(267)).setAttribute("textoinicial","" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
      ((Element)v.get(267)).setAttribute("req","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(269)).setAttribute("ID","1" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(270)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(270)).setAttribute("TIPO","STRING" );
      ((Element)v.get(270)).setAttribute("VALOR","1" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 269   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(271)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(271)).setAttribute("TIPO","STRING" );
      ((Element)v.get(271)).setAttribute("VALOR","<" );
      ((Element)v.get(269)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:269   */

      /* Empieza nodo:272 / Elemento padre: 268   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(272)).setAttribute("ID","2" );
      ((Element)v.get(268)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(273)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(273)).setAttribute("TIPO","STRING" );
      ((Element)v.get(273)).setAttribute("VALOR","2" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(274)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(274)).setAttribute("TIPO","STRING" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(274)).setAttribute("VALOR",">" );
      ((Element)v.get(272)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 268   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(275)).setAttribute("ID","3" );
      ((Element)v.get(268)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(276)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(276)).setAttribute("TIPO","STRING" );
      ((Element)v.get(276)).setAttribute("VALOR","3" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 275   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(277)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(277)).setAttribute("TIPO","STRING" );
      ((Element)v.get(277)).setAttribute("VALOR","=" );
      ((Element)v.get(275)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:275   */

      /* Empieza nodo:278 / Elemento padre: 268   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(278)).setAttribute("ID","4" );
      ((Element)v.get(268)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(279)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(279)).setAttribute("TIPO","STRING" );
      ((Element)v.get(279)).setAttribute("VALOR","4" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 278   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(280)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(280)).setAttribute("TIPO","STRING" );
      ((Element)v.get(280)).setAttribute("VALOR","<=" );
      ((Element)v.get(278)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:278   */

      /* Empieza nodo:281 / Elemento padre: 268   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(281)).setAttribute("ID","5" );
      ((Element)v.get(268)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(282)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(282)).setAttribute("TIPO","STRING" );
      ((Element)v.get(282)).setAttribute("VALOR","5" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(283)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(283)).setAttribute("TIPO","STRING" );
      ((Element)v.get(283)).setAttribute("VALOR",">=" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:281   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:284 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","25" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(263)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(287)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(287)).setAttribute("max","19" );
      ((Element)v.get(287)).setAttribute("tipo","" );
      ((Element)v.get(287)).setAttribute("onchange","" );
      ((Element)v.get(287)).setAttribute("req","N" );
      ((Element)v.get(287)).setAttribute("size","26" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(287)).setAttribute("validacion","" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(263)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(291)).setAttribute("nombre","cbOperadorPrecioContable" );
      ((Element)v.get(291)).setAttribute("size","1" );
      ((Element)v.get(291)).setAttribute("multiple","N" );
      ((Element)v.get(291)).setAttribute("valorinicial","" );
      ((Element)v.get(291)).setAttribute("textoinicial","" );
      ((Element)v.get(291)).setAttribute("id","datosCampos" );
      ((Element)v.get(291)).setAttribute("req","N" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(293)).setAttribute("ID","1" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(294)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(294)).setAttribute("TIPO","STRING" );
      ((Element)v.get(294)).setAttribute("VALOR","1" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 293   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(295)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(295)).setAttribute("TIPO","STRING" );
      ((Element)v.get(295)).setAttribute("VALOR","<" );
      ((Element)v.get(293)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:293   */

      /* Empieza nodo:296 / Elemento padre: 292   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(296)).setAttribute("ID","2" );
      ((Element)v.get(292)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(297)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(297)).setAttribute("TIPO","STRING" );
      ((Element)v.get(297)).setAttribute("VALOR","2" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 296   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(298)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(298)).setAttribute("TIPO","STRING" );
      ((Element)v.get(298)).setAttribute("VALOR",">" );
      ((Element)v.get(296)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:296   */

      /* Empieza nodo:299 / Elemento padre: 292   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(299)).setAttribute("ID","3" );
      ((Element)v.get(292)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(300)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(300)).setAttribute("TIPO","STRING" );
      ((Element)v.get(300)).setAttribute("VALOR","3" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(301)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(301)).setAttribute("TIPO","STRING" );
      ((Element)v.get(301)).setAttribute("VALOR","=" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 292   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(302)).setAttribute("ID","4" );
      ((Element)v.get(292)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(303)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(303)).setAttribute("TIPO","STRING" );
      ((Element)v.get(303)).setAttribute("VALOR","4" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(304)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(304)).setAttribute("TIPO","STRING" );
      ((Element)v.get(304)).setAttribute("VALOR","<=" );
      ((Element)v.get(302)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:302   */

      /* Empieza nodo:305 / Elemento padre: 292   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(305)).setAttribute("ID","5" );
      ((Element)v.get(292)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(306)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(306)).setAttribute("TIPO","STRING" );
      ((Element)v.get(306)).setAttribute("VALOR","5" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 305   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(307)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(307)).setAttribute("TIPO","STRING" );
      ((Element)v.get(307)).setAttribute("VALOR",">=" );
      ((Element)v.get(305)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:305   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:308 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(263)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(311)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(311)).setAttribute("id","datosCampos" );
      ((Element)v.get(311)).setAttribute("max","19" );
      ((Element)v.get(311)).setAttribute("tipo","" );
      ((Element)v.get(311)).setAttribute("onchange","" );
      ((Element)v.get(311)).setAttribute("req","N" );
      ((Element)v.get(311)).setAttribute("size","26" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(311)).setAttribute("validacion","" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:263   */

      /* Empieza nodo:314 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(315)).setAttribute("colspan","4" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:317 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("table"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(319)).setAttribute("border","0" );
      ((Element)v.get(319)).setAttribute("align","left" );
      ((Element)v.get(319)).setAttribute("cellspacing","0" );
      ((Element)v.get(319)).setAttribute("cellpadding","0" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(324)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(324)).setAttribute("alto","13" );
      ((Element)v.get(324)).setAttribute("filas","1" );
      ((Element)v.get(324)).setAttribute("id","datosTitle" );
      ((Element)v.get(324)).setAttribute("cod","516" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","25" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(328)).setAttribute("nombre","lblPaginaDesde" );
      ((Element)v.get(328)).setAttribute("alto","13" );
      ((Element)v.get(328)).setAttribute("filas","1" );
      ((Element)v.get(328)).setAttribute("id","datosTitle" );
      ((Element)v.get(328)).setAttribute("cod","512" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","25" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(332)).setAttribute("nombre","lblPaginaHasta" );
      ((Element)v.get(332)).setAttribute("alto","13" );
      ((Element)v.get(332)).setAttribute("filas","1" );
      ((Element)v.get(332)).setAttribute("id","datosTitle" );
      ((Element)v.get(332)).setAttribute("cod","513" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(320)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:320   */

      /* Empieza nodo:335 / Elemento padre: 319   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(319)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(335)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(339)).setAttribute("nombre","cbCatalogo" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(339)).setAttribute("size","5" );
      ((Element)v.get(339)).setAttribute("multiple","S" );
      ((Element)v.get(339)).setAttribute("valorinicial","" );
      ((Element)v.get(339)).setAttribute("textoinicial","" );
      ((Element)v.get(339)).setAttribute("id","datosCampos" );
      ((Element)v.get(339)).setAttribute("req","N" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:341 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(343)).setAttribute("valign","top" );
      ((Element)v.get(335)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(344)).setAttribute("nombre","txtPaginaDesde" );
      ((Element)v.get(344)).setAttribute("id","datosCampos" );
      ((Element)v.get(344)).setAttribute("max","3" );
      ((Element)v.get(344)).setAttribute("tipo","" );
      ((Element)v.get(344)).setAttribute("req","N" );
      ((Element)v.get(344)).setAttribute("size","3" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("validacion","" );
      ((Element)v.get(344)).setAttribute("onchange","habilitarPagina()" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","25" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(347)).setAttribute("valign","top" );
      ((Element)v.get(335)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(348)).setAttribute("nombre","txtPaginaHasta" );
      ((Element)v.get(348)).setAttribute("id","datosCampos" );
      ((Element)v.get(348)).setAttribute("max","3" );
      ((Element)v.get(348)).setAttribute("tipo","" );
      ((Element)v.get(348)).setAttribute("onchange","" );
      ((Element)v.get(348)).setAttribute("req","N" );
      ((Element)v.get(348)).setAttribute("size","3" );
      ((Element)v.get(348)).setAttribute("valor","" );
      ((Element)v.get(348)).setAttribute("validacion","" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("width","100%" );
      ((Element)v.get(335)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:335   */

      /* Empieza nodo:351 / Elemento padre: 319   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(319)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).setAttribute("colspan","4" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:354 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("table"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(356)).setAttribute("border","0" );
      ((Element)v.get(356)).setAttribute("align","left" );
      ((Element)v.get(356)).setAttribute("cellspacing","0" );
      ((Element)v.get(356)).setAttribute("cellpadding","0" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","8" );
      ((Element)v.get(359)).setAttribute("height","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 357   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("id","datosTitle" );
      ((Element)v.get(361)).setAttribute("cod","541" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 357   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","25" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 357   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(365)).setAttribute("nombre","lblVistaSalida" );
      ((Element)v.get(365)).setAttribute("alto","13" );
      ((Element)v.get(365)).setAttribute("filas","1" );
      ((Element)v.get(365)).setAttribute("id","datosTitle" );
      ((Element)v.get(365)).setAttribute("cod","2625" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 357   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","100%" );
      ((Element)v.get(357)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:357   */

      /* Empieza nodo:368 / Elemento padre: 356   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(356)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("width","8" );
      ((Element)v.get(370)).setAttribute("height","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(368)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(372)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(372)).setAttribute("size","5" );
      ((Element)v.get(372)).setAttribute("multiple","S" );
      ((Element)v.get(372)).setAttribute("valorinicial","" );
      ((Element)v.get(372)).setAttribute("textoinicial","" );
      ((Element)v.get(372)).setAttribute("id","datosCampos" );
      ((Element)v.get(372)).setAttribute("req","N" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:374 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","25" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(376)).setAttribute("valign","top" );
      ((Element)v.get(368)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(377)).setAttribute("nombre","cbVista" );
      ((Element)v.get(377)).setAttribute("size","1" );
      ((Element)v.get(377)).setAttribute("multiple","N" );
      ((Element)v.get(377)).setAttribute("valorinicial","1" );
      ((Element)v.get(377)).setAttribute("textoinicial","Vista general" );
      ((Element)v.get(377)).setAttribute("id","datosCampos" );
      ((Element)v.get(377)).setAttribute("req","" );
      ((Element)v.get(377)).setAttribute("onchange","onchangeVista();" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(379)).setAttribute("ID","1" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(380)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(380)).setAttribute("TIPO","STRING" );
      ((Element)v.get(380)).setAttribute("VALOR","2" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 379   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(381)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(381)).setAttribute("TIPO","STRING" );
      ((Element)v.get(381)).setAttribute("VALOR","Vista con sumarizaci�n por compuesta fija " );
      ((Element)v.get(379)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:382 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("width","100%" );
      ((Element)v.get(368)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","8" );
      ((Element)v.get(383)).setAttribute("height","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:368   */

      /* Empieza nodo:384 / Elemento padre: 356   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(356)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("colspan","4" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","8" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:387 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("table"));
      ((Element)v.get(389)).setAttribute("width","100%" );
      ((Element)v.get(389)).setAttribute("border","0" );
      ((Element)v.get(389)).setAttribute("align","left" );
      ((Element)v.get(389)).setAttribute("cellspacing","0" );
      ((Element)v.get(389)).setAttribute("cellpadding","0" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","8" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lblCriterioOrdenacion1" );
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("id","datosTitle" );
      ((Element)v.get(394)).setAttribute("cod","2626" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","25" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(398)).setAttribute("nombre","lblCriterioOrdenacion2" );
      ((Element)v.get(398)).setAttribute("alto","13" );
      ((Element)v.get(398)).setAttribute("filas","1" );
      ((Element)v.get(398)).setAttribute("id","datosTitle" );
      ((Element)v.get(398)).setAttribute("cod","2627" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","25" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(402)).setAttribute("nombre","lblCriterioOrdenacion3" );
      ((Element)v.get(402)).setAttribute("alto","13" );
      ((Element)v.get(402)).setAttribute("filas","1" );
      ((Element)v.get(402)).setAttribute("id","datosTitle" );
      ((Element)v.get(402)).setAttribute("cod","2628" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).setAttribute("width","100%" );
      ((Element)v.get(390)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:390   */

      /* Empieza nodo:405 / Elemento padre: 389   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(409)).setAttribute("nombre","cbCriterioOrdenacion1" );
      ((Element)v.get(409)).setAttribute("size","1" );
      ((Element)v.get(409)).setAttribute("multiple","N" );
      ((Element)v.get(409)).setAttribute("valorinicial","" );
      ((Element)v.get(409)).setAttribute("textoinicial","" );
      ((Element)v.get(409)).setAttribute("id","datosCampos" );
      ((Element)v.get(409)).setAttribute("req","N" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).setAttribute("ID","1" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(412)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(412)).setAttribute("TIPO","STRING" );
      ((Element)v.get(412)).setAttribute("VALOR","1" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 411   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(413)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(413)).setAttribute("TIPO","STRING" );
      ((Element)v.get(413)).setAttribute("VALOR","Precio" );
      ((Element)v.get(411)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:411   */

      /* Empieza nodo:414 / Elemento padre: 410   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(414)).setAttribute("ID","2" );
      ((Element)v.get(410)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(415)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(415)).setAttribute("TIPO","STRING" );
      ((Element)v.get(415)).setAttribute("VALOR","2" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 414   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","Cat�logo" );
      ((Element)v.get(414)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:414   */

      /* Empieza nodo:417 / Elemento padre: 410   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(417)).setAttribute("ID","3" );
      ((Element)v.get(410)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(418)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(418)).setAttribute("TIPO","STRING" );
      ((Element)v.get(418)).setAttribute("VALOR","3" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","Estrategia" );
      ((Element)v.get(417)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:417   */

      /* Empieza nodo:420 / Elemento padre: 410   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(420)).setAttribute("ID","4" );
      ((Element)v.get(410)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(421)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(421)).setAttribute("TIPO","STRING" );
      ((Element)v.get(421)).setAttribute("VALOR","4" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","C�digo venta" );
      ((Element)v.get(420)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:420   */

      /* Empieza nodo:423 / Elemento padre: 410   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(423)).setAttribute("ID","5" );
      ((Element)v.get(410)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(424)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(424)).setAttribute("TIPO","STRING" );
      ((Element)v.get(424)).setAttribute("VALOR","5" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","P�gina" );
      ((Element)v.get(423)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:423   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:426 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","25" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(429)).setAttribute("nombre","cbCriterioOrdenacion2" );
      ((Element)v.get(429)).setAttribute("size","1" );
      ((Element)v.get(429)).setAttribute("multiple","N" );
      ((Element)v.get(429)).setAttribute("valorinicial","" );
      ((Element)v.get(429)).setAttribute("textoinicial","" );
      ((Element)v.get(429)).setAttribute("id","datosCampos" );
      ((Element)v.get(429)).setAttribute("req","N" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(431)).setAttribute("ID","1" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(432)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(432)).setAttribute("TIPO","STRING" );
      ((Element)v.get(432)).setAttribute("VALOR","1" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 431   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(433)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(433)).setAttribute("VALOR","Precio" );
      ((Element)v.get(431)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:431   */

      /* Empieza nodo:434 / Elemento padre: 430   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(434)).setAttribute("ID","2" );
      ((Element)v.get(430)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(435)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(435)).setAttribute("TIPO","STRING" );
      ((Element)v.get(435)).setAttribute("VALOR","2" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","Cat�logo" );
      ((Element)v.get(434)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:434   */

      /* Empieza nodo:437 / Elemento padre: 430   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(437)).setAttribute("ID","3" );
      ((Element)v.get(430)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(438)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(438)).setAttribute("TIPO","STRING" );
      ((Element)v.get(438)).setAttribute("VALOR","3" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 437   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","Estrategia" );
      ((Element)v.get(437)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:437   */

      /* Empieza nodo:440 / Elemento padre: 430   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(440)).setAttribute("ID","4" );
      ((Element)v.get(430)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(441)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(441)).setAttribute("TIPO","STRING" );
      ((Element)v.get(441)).setAttribute("VALOR","4" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 440   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","C�digo venta" );
      ((Element)v.get(440)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:440   */

      /* Empieza nodo:443 / Elemento padre: 430   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(443)).setAttribute("ID","5" );
      ((Element)v.get(430)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(444)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(444)).setAttribute("TIPO","STRING" );
      ((Element)v.get(444)).setAttribute("VALOR","5" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */

      /* Empieza nodo:445 / Elemento padre: 443   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(445)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(445)).setAttribute("TIPO","STRING" );
      ((Element)v.get(445)).setAttribute("VALOR","P�gina" );
      ((Element)v.get(443)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:443   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:446 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","25" );
      ((Element)v.get(447)).setAttribute("height","8" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(449)).setAttribute("nombre","cbCriterioOrdenacion3" );
      ((Element)v.get(449)).setAttribute("size","1" );
      ((Element)v.get(449)).setAttribute("multiple","N" );
      ((Element)v.get(449)).setAttribute("valorinicial","" );
      ((Element)v.get(449)).setAttribute("textoinicial","" );
      ((Element)v.get(449)).setAttribute("id","datosCampos" );
      ((Element)v.get(449)).setAttribute("req","N" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(451)).setAttribute("ID","1" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(452)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(452)).setAttribute("TIPO","STRING" );
      ((Element)v.get(452)).setAttribute("VALOR","1" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 451   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(453)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(453)).setAttribute("TIPO","STRING" );
      ((Element)v.get(453)).setAttribute("VALOR","Precio" );
      ((Element)v.get(451)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:451   */

      /* Empieza nodo:454 / Elemento padre: 450   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(454)).setAttribute("ID","2" );
      ((Element)v.get(450)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(455)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(455)).setAttribute("TIPO","STRING" );
      ((Element)v.get(455)).setAttribute("VALOR","2" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 454   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(456)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(456)).setAttribute("TIPO","STRING" );
      ((Element)v.get(456)).setAttribute("VALOR","Cat�logo" );
      ((Element)v.get(454)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:454   */

      /* Empieza nodo:457 / Elemento padre: 450   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(457)).setAttribute("ID","3" );
      ((Element)v.get(450)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(458)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(458)).setAttribute("TIPO","STRING" );
      ((Element)v.get(458)).setAttribute("VALOR","3" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 457   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(459)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(459)).setAttribute("TIPO","STRING" );
      ((Element)v.get(459)).setAttribute("VALOR","Estrategia" );
      ((Element)v.get(457)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:457   */

      /* Empieza nodo:460 / Elemento padre: 450   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(460)).setAttribute("ID","4" );
      ((Element)v.get(450)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(461)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(461)).setAttribute("TIPO","STRING" );
      ((Element)v.get(461)).setAttribute("VALOR","4" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 460   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(462)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(462)).setAttribute("TIPO","STRING" );
      ((Element)v.get(462)).setAttribute("VALOR","C�digo venta" );
      ((Element)v.get(460)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:460   */

      /* Empieza nodo:463 / Elemento padre: 450   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(463)).setAttribute("ID","5" );
      ((Element)v.get(450)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(464)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(464)).setAttribute("TIPO","STRING" );
      ((Element)v.get(464)).setAttribute("VALOR","5" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 463   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(465)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(465)).setAttribute("TIPO","STRING" );
      ((Element)v.get(465)).setAttribute("VALOR","P�gina" );
      ((Element)v.get(463)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:463   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:466 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("width","100%" );
      ((Element)v.get(405)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","8" );
      ((Element)v.get(467)).setAttribute("height","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:405   */

      /* Empieza nodo:468 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(469)).setAttribute("colspan","4" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(470)).setAttribute("src","b.gif" );
      ((Element)v.get(470)).setAttribute("width","8" );
      ((Element)v.get(470)).setAttribute("height","8" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:62   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:471 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:55   */

      /* Empieza nodo:473 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(475)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(476)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("table"));
      ((Element)v.get(478)).setAttribute("width","100%" );
      ((Element)v.get(478)).setAttribute("border","0" );
      ((Element)v.get(478)).setAttribute("align","center" );
      ((Element)v.get(478)).setAttribute("cellspacing","0" );
      ((Element)v.get(478)).setAttribute("cellpadding","0" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("class","botonera" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(481)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(481)).setAttribute("ID","botonContenido" );
      ((Element)v.get(481)).setAttribute("tipo","html" );
      ((Element)v.get(481)).setAttribute("accion","generar();" );
      ((Element)v.get(481)).setAttribute("estado","false" );
      ((Element)v.get(481)).setAttribute("cod","2495" );
      ((Element)v.get(481)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnGenerarExcel')" );
      ((Element)v.get(481)).setAttribute("onshtab","focaliza('Formulario.cbCriterioOrdenacion3')" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 480   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(482)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(482)).setAttribute("ID","botonContenido" );
      ((Element)v.get(482)).setAttribute("tipo","html" );
      ((Element)v.get(482)).setAttribute("accion","generar('xls');" );
      ((Element)v.get(482)).setAttribute("estado","false" );
      ((Element)v.get(482)).setAttribute("cod","2526" );
      ((Element)v.get(482)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarInforme')" );
      ((Element)v.get(482)).setAttribute("ontab","focaliza('Formulario.cbMarca')" );
      ((Element)v.get(480)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:483 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(484)).setAttribute("height","12" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:473   */

      /* Empieza nodo:485 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).setAttribute("width","12" );
      ((Element)v.get(486)).setAttribute("align","center" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","12" );
      ((Element)v.get(487)).setAttribute("height","12" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).setAttribute("width","756" );
      ((Element)v.get(485)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(490)).setAttribute("width","12" );
      ((Element)v.get(485)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","12" );
      ((Element)v.get(491)).setAttribute("height","1" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:485   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:14   */


   }

}
