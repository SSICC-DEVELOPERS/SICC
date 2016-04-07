
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_status_producto_generar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_campana_generar" );
      ((Element)v.get(0)).setAttribute("cod","0773" );
      ((Element)v.get(0)).setAttribute("titulo","Generar informe status de producto de MAV" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      setearPais();\r      accion('Formulario.txtCodProductoHasta','.disabled=true');\r      accion('Formulario.txtCodVentaHasta','.disabled=true');\r      focaliza('Formulario.cbPais');\r   }\r\r    function quitarItemVacio(elemento){\r      var elementoADevolver = new Array();\r     \r      for(var k=0;k<elemento.length;k++) {\r          if (elemento[k] != ''){                            \r             elementoADevolver[elementoADevolver.length] = elemento[k];\r          }\r      }\r         \r      return elementoADevolver;\r      \r   }\r   function generar(formato){\r      \r      if(sicc_validaciones_generales()){\r         if(validaCantidad()){\r    \r            var a = new Object();\r            a.accion = 'generar';\r            a.paisSelec = get('Formulario.cbPais');  \r            a.marca = get('Formulario.cbMarca');\r            a.canal = get('Formulario.cbCanal');\r			a.marcaDesc = get('Formulario.cbMarca', 'T');\r            a.canalDesc = get('Formulario.cbCanal', 'T');\r            a.periodo = get('Formulario.cbPeriodo');\r            a.periodoDesc = get('Formulario.cbPeriodo','T');\r            a.actividad = quitarItemVacio(get('Formulario.cbActividad'));\r            a.codProdDesde = get('Formulario.txtCodProductoDesde');\r            a.codProdHasta = get('Formulario.txtCodProductoHasta');\r            a.codVentaDesde = get('Formulario.txtCodVentaDesde');\r            a.codVentaHasta = get('Formulario.txtCodVentaHasta');\r            a.operadorPrecioCatalogo = get('Formulario.cbOperadorPrecioCatalogo');\r            a.precioCatalogo = get('Formulario.txtPrecioCatalogo');\r            a.operadorPrecioContable = get('Formulario.cbOperadorPrecioContable');\r            a.precioContable = get('Formulario.txtPrecioContable');\r            a.operadorUnidadesEstimadas =get('Formulario.cbOperadorCantidadEstimadas');\r            a.unidadesEstimadas = get('Formulario.txtCantidadEstimadas');\r            a.tipoCliente = quitarItemVacio(get('Formulario.cbTipoCliente'));\r            a.cicloVida = quitarItemVacio(get('Formulario.cbCicloVida'));\r            a.tipoOferta = quitarItemVacio(get('Formulario.cbTipoOferta'));\r            a.seleccion = get('Formulario.cbTipoSeleccion');          \r			a.seleccionCriterio = get('Formulario.cbTipoSeleccionCriterio');          \r            mostrarModalSICC('MAVStatusProductoMav','generar', a);  \r         }\r    \r      }\r\r   }\r\r\r   function validaCantidad(){\r      var cantidadEstimada = get('Formulario.txtCantidadEstimadas') ;\r      if(cantidadEstimada != ''){\r         if(fValidarNumero(cantidadEstimada, 200, 0, 9999999)!='OK'){\r            GestionarMensaje('405'); \r            focaliza('Formulario.txtCantidadEstimadas');\r            return false;\r          }\r      }\r      \r      return true;\r \r   }\r\r   function recolectarParametros(){\r      \r           \r      set('Formulario.paisSelec', get('Formulario.cbPais') );  \r      set('Formulario.marca', get('Formulario.cbMarca'));\r      set('Formulario.canal', get('Formulario.cbCanal'));\r      set('Formulario.periodo', get('Formulario.cbPeriodo'));\r      set('Formulario.actividad', get('Formulario.cbActividad'));\r      set('Formulario.codProdDesde', get('Formulario.txtCodProductoDesde'));\r      set('Formulario.codProdHasta', get('Formulario.txtCodProductoHasta'));\r      set('Formulario.codVentaDesde', get('Formulario.txtCodVentaDesde'));\r      set('Formulario.codVentaHasta', get('Formulario.txtCodVentaHasta'));\r      set('Formulario.operadorPrecioCatalogo', get('Formulario.cbOperadorPrecioCatalogo'));\r      set('Formulario.precioCatalogo', get('Formulario.txtPrecioCatalogo'));\r      set('Formulario.operadorPrecioContable', get('Formulario.cbOperadorPrecioContable'));\r      set('Formulario.precioContable', get('Formulario.txtPrecioContable'));\r      set('Formulario.operadorUnidadesEstimadas', get('Formulario.cbOperadorCantidadEstimadas'));\r      set('Formulario.unidadesEstimadas', get('Formulario.txtCantidadEstimadas'));\r      set('Formulario.tipoCliente', get('Formulario.cbTipoCliente'));\r      set('Formulario.cicloVida', get('Formulario.cbCicloVida'))\r      set('Formulario.tipoOferta', get('Formulario.cbTipoOferta'));\r      set('Formulario.seleccion', get('Formulario.cbTipoSeleccion'));\r   }\r \r   \r\r   function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbPeriodo', aCombo, []);\r      \r      \r      focaliza('Formulario.cbPais');\r \r   }\r   \r    function onchangeMarcaCanal(){\r        \r       marca  = get('Formulario.cbMarca');\r       canal  = get('Formulario.cbCanal');\r       pais   = get('Formulario.pais');\r       idioma = get('Formulario.idioma');\r        \r       if(marca != '' && canal != ''){\r       \r          var arr = new Array();\r               \r          arr[arr.length] = [\"oidIdioma\", idioma]; \r          arr[arr.length] = [\"oidPais\", pais]; \r          arr[arr.length] = [\"marca\", marca];\r          arr[arr.length] = [\"canal\", canal];\r          \r          var arr2 = new Array();\r             \r          arr2[arr2.length] = ['oidMarca', marca];\r          arr2[arr2.length] = ['oidCanal', canal];\r          arr2[arr2.length] = ['oidPais', pais];\r          arr2[arr2.length] = ['oidIdioma', idioma];\r\r             \r          recargaCombo(\"Formulario.cbPeriodo\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r		  recargaCombo(\"Formulario.cbActividad\",\"MAVObtieneActividadesMAV\", \"es.indra.sicc.dtos.mav.DTOActividadMAV\", arr2); \r\r      \r       }else{\r         var aCombo = new Array(new Array(\"\",\"\"));\r         set_combo('Formulario.cbPeriodo', aCombo, []);          \r       }   \r    } \r \r\r    function hablitar(campoOrigen, campoDestino){\r    \r       if(get('Formulario.'+campoOrigen) != ''){\r          accion('Formulario.'+campoDestino,'.disabled=false');\r          focaliza('Formulario.' + campoDestino)\r       }else{\r          accion('Formulario.'+campoDestino,'.disabled=true');\r       }\r   \r    }\r\r\r   function setearPais(){\r      var pais = get('Formulario.pais');\r      \r      iSeleccionado = new Array(); \r      iSeleccionado[0] = pais;\r      set('Formulario.cbPais',iSeleccionado);\r   }\r\r   \r"));
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
      ((Element)v.get(7)).setAttribute("cod","6" );
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
      ((Element)v.get(9)).setAttribute("name","cbMarca" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","276" );
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
      ((Element)v.get(17)).setAttribute("nombre","idioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","pais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","paisSelec" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","marca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","canal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","periodo" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","actividad" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","codProdDesde" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","codProdHasta" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","codVentaDesde" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","codVentaHasta" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","operadorPrecioCatalogo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","precioCatalogo" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","operadorPrecioContable" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","precioContable" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","operadorCantidadEstimada" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","cantidadEstimada" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","tipoCliente" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","cicloVida" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","tipoOferta" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(37)).setAttribute("nombre","capa" );
      ((Element)v.get(11)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","750" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","12" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("height","1" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:39   */

      /* Empieza nodo:46 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(51)).setAttribute("class","legend" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","legend" );
      ((Element)v.get(52)).setAttribute("cod","00275" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","4" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblPais" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","5" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","6" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(69));

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
      /* Termina nodo:60   */

      /* Empieza nodo:71 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(75)).setAttribute("nombre","cbPais" );
      ((Element)v.get(75)).setAttribute("size","1" );
      ((Element)v.get(75)).setAttribute("multiple","N" );
      ((Element)v.get(75)).setAttribute("valorinicial","" );
      ((Element)v.get(75)).setAttribute("textoinicial","" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("req","S" );
      ((Element)v.get(75)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarInforme');" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:77 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(80)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(80)).setAttribute("size","1" );
      ((Element)v.get(80)).setAttribute("multiple","N" );
      ((Element)v.get(80)).setAttribute("valorinicial","" );
      ((Element)v.get(80)).setAttribute("textoinicial","" );
      ((Element)v.get(80)).setAttribute("id","datosCampos" );
      ((Element)v.get(80)).setAttribute("req","S" );
      ((Element)v.get(80)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:71   */

      /* Empieza nodo:84 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("colspan","4" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:87 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(89)).setAttribute("border","0" );
      ((Element)v.get(89)).setAttribute("align","left" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","7" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","276" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:90   */

      /* Empieza nodo:101 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(105)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(105)).setAttribute("size","1" );
      ((Element)v.get(105)).setAttribute("multiple","N" );
      ((Element)v.get(105)).setAttribute("valorinicial","" );
      ((Element)v.get(105)).setAttribute("textoinicial","" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("req","S" );
      ((Element)v.get(105)).setAttribute("onchange","onchangeMarcaCanal();" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:107 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(110)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(110)).setAttribute("size","1" );
      ((Element)v.get(110)).setAttribute("multiple","N" );
      ((Element)v.get(110)).setAttribute("valorinicial","" );
      ((Element)v.get(110)).setAttribute("textoinicial","" );
      ((Element)v.get(110)).setAttribute("id","datosCampos" );
      ((Element)v.get(110)).setAttribute("req","S" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:112 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(101)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:101   */

      /* Empieza nodo:114 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("colspan","4" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:117 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(119)).setAttribute("border","0" );
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("cellpadding","0" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","173" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:120   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(127));

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
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(131)).setAttribute("nombre","cbActividad" );
      ((Element)v.get(131)).setAttribute("size","5" );
      ((Element)v.get(131)).setAttribute("multiple","S" );
      ((Element)v.get(131)).setAttribute("valorinicial","" );
      ((Element)v.get(131)).setAttribute("textoinicial","" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:133 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:127   */

      /* Empieza nodo:135 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("colspan","4" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:138 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("table"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(140)).setAttribute("border","0" );
      ((Element)v.get(140)).setAttribute("align","left" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(140)).setAttribute("cellspacing","0" );
      ((Element)v.get(140)).setAttribute("cellpadding","0" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lblCodProductoDesde" );
      ((Element)v.get(145)).setAttribute("alto","13" );
      ((Element)v.get(145)).setAttribute("filas","1" );
      ((Element)v.get(145)).setAttribute("cod","2570" );
      ((Element)v.get(145)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","25" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lblCodProductoHasta" );
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("cod","2571" );
      ((Element)v.get(149)).setAttribute("id","datosTitle" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","25" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lblCodVentaDesde" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("cod","2572" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","25" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblCodVentaHasta" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("cod","2573" );
      ((Element)v.get(157)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(141)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:141   */

      /* Empieza nodo:160 / Elemento padre: 140   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(140)).appendChild((Element)v.get(160));

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
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(164)).setAttribute("nombre","txtCodProductoDesde" );
      ((Element)v.get(164)).setAttribute("id","datosCampos" );
      ((Element)v.get(164)).setAttribute("max","20" );
      ((Element)v.get(164)).setAttribute("tipo","" );
      ((Element)v.get(164)).setAttribute("req","N" );
      ((Element)v.get(164)).setAttribute("size","26" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("validacion","" );
      ((Element)v.get(164)).setAttribute("onchange","hablitar('txtCodProductoDesde', 'txtCodProductoHasta');" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(168)).setAttribute("nombre","txtCodProductoHasta" );
      ((Element)v.get(168)).setAttribute("id","datosCampos" );
      ((Element)v.get(168)).setAttribute("max","20" );
      ((Element)v.get(168)).setAttribute("tipo","" );
      ((Element)v.get(168)).setAttribute("onchange","" );
      ((Element)v.get(168)).setAttribute("req","N" );
      ((Element)v.get(168)).setAttribute("size","26" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("validacion","" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(172)).setAttribute("nombre","txtCodVentaDesde" );
      ((Element)v.get(172)).setAttribute("id","datosCampos" );
      ((Element)v.get(172)).setAttribute("max","18" );
      ((Element)v.get(172)).setAttribute("tipo","" );
      ((Element)v.get(172)).setAttribute("req","N" );
      ((Element)v.get(172)).setAttribute("size","24" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("validacion","" );
      ((Element)v.get(172)).setAttribute("onchange","hablitar('txtCodVentaDesde', 'txtCodVentaHasta');" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(176)).setAttribute("nombre","txtCodVentaHasta" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("max","18" );
      ((Element)v.get(176)).setAttribute("tipo","" );
      ((Element)v.get(176)).setAttribute("onchange","" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(176)).setAttribute("size","24" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("validacion","" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(160)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:160   */

      /* Empieza nodo:179 / Elemento padre: 140   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(140)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("colspan","3" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:182 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("table"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(184)).setAttribute("border","0" );
      ((Element)v.get(184)).setAttribute("align","left" );
      ((Element)v.get(184)).setAttribute("cellspacing","0" );
      ((Element)v.get(184)).setAttribute("cellpadding","0" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lblOperadorPrecioCatalogo" );
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("id","datosTitle" );
      ((Element)v.get(189)).setAttribute("cod","2575" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","25" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(193)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(193)).setAttribute("alto","13" );
      ((Element)v.get(193)).setAttribute("filas","1" );
      ((Element)v.get(193)).setAttribute("id","datosTitle" );
      ((Element)v.get(193)).setAttribute("cod","2576" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","25" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lblOperadorPrecioContable" );
      ((Element)v.get(197)).setAttribute("alto","13" );
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("id","datosTitle" );
      ((Element)v.get(197)).setAttribute("cod","2577" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(201)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(201)).setAttribute("alto","13" );
      ((Element)v.get(201)).setAttribute("filas","1" );
      ((Element)v.get(201)).setAttribute("id","datosTitle" );
      ((Element)v.get(201)).setAttribute("cod","2578" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(185)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:185   */

      /* Empieza nodo:204 / Elemento padre: 184   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(184)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(208)).setAttribute("nombre","cbOperadorPrecioCatalogo" );
      ((Element)v.get(208)).setAttribute("size","1" );
      ((Element)v.get(208)).setAttribute("multiple","N" );
      ((Element)v.get(208)).setAttribute("valorinicial","1" );
      ((Element)v.get(208)).setAttribute("textoinicial","<" );
      ((Element)v.get(208)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).setAttribute("req","N" );
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
      ((Element)v.get(211)).setAttribute("VALOR","2" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(212)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(212)).setAttribute("TIPO","STRING" );
      ((Element)v.get(212)).setAttribute("VALOR",">" );
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
      ((Element)v.get(214)).setAttribute("VALOR","3" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 213   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(215)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(215)).setAttribute("TIPO","STRING" );
      ((Element)v.get(215)).setAttribute("VALOR","=" );
      ((Element)v.get(213)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:213   */

      /* Empieza nodo:216 / Elemento padre: 209   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(216)).setAttribute("ID","3" );
      ((Element)v.get(209)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(217)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(217)).setAttribute("TIPO","STRING" );
      ((Element)v.get(217)).setAttribute("VALOR","4" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 216   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(218)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(218)).setAttribute("TIPO","STRING" );
      ((Element)v.get(218)).setAttribute("VALOR","<=" );
      ((Element)v.get(216)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:216   */

      /* Empieza nodo:219 / Elemento padre: 209   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(219)).setAttribute("ID","4" );
      ((Element)v.get(209)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(220)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(220)).setAttribute("TIPO","STRING" );
      ((Element)v.get(220)).setAttribute("VALOR","5" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(221)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(221)).setAttribute("TIPO","STRING" );
      ((Element)v.get(221)).setAttribute("VALOR",">=" );
      ((Element)v.get(219)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:219   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:222 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(204)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(225)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).setAttribute("max","19" );
      ((Element)v.get(225)).setAttribute("tipo","" );
      ((Element)v.get(225)).setAttribute("onchange","" );
      ((Element)v.get(225)).setAttribute("req","N" );
      ((Element)v.get(225)).setAttribute("size","26" );
      ((Element)v.get(225)).setAttribute("valor","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(225)).setAttribute("validacion","" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(204)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(229)).setAttribute("nombre","cbOperadorPrecioContable" );
      ((Element)v.get(229)).setAttribute("size","1" );
      ((Element)v.get(229)).setAttribute("multiple","N" );
      ((Element)v.get(229)).setAttribute("valorinicial","1" );
      ((Element)v.get(229)).setAttribute("textoinicial","<" );
      ((Element)v.get(229)).setAttribute("id","datosCampos" );
      ((Element)v.get(229)).setAttribute("req","N" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(231)).setAttribute("ID","1" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","2" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 231   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(233)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(233)).setAttribute("TIPO","STRING" );
      ((Element)v.get(233)).setAttribute("VALOR",">" );
      ((Element)v.get(231)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:231   */

      /* Empieza nodo:234 / Elemento padre: 230   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(234)).setAttribute("ID","2" );
      ((Element)v.get(230)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","3" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(236)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(236)).setAttribute("TIPO","STRING" );
      ((Element)v.get(236)).setAttribute("VALOR","=" );
      ((Element)v.get(234)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:234   */

      /* Empieza nodo:237 / Elemento padre: 230   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(237)).setAttribute("ID","3" );
      ((Element)v.get(230)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(238)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(238)).setAttribute("TIPO","STRING" );
      ((Element)v.get(238)).setAttribute("VALOR","4" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(239)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(239)).setAttribute("TIPO","STRING" );
      ((Element)v.get(239)).setAttribute("VALOR","<=" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 230   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(240)).setAttribute("ID","4" );
      ((Element)v.get(230)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(241)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(241)).setAttribute("TIPO","STRING" );
      ((Element)v.get(241)).setAttribute("VALOR","5" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(242)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(242)).setAttribute("TIPO","STRING" );
      ((Element)v.get(242)).setAttribute("VALOR",">=" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:243 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(204)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(246)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(246)).setAttribute("id","datosCampos" );
      ((Element)v.get(246)).setAttribute("max","19" );
      ((Element)v.get(246)).setAttribute("tipo","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(246)).setAttribute("onchange","" );
      ((Element)v.get(246)).setAttribute("req","N" );
      ((Element)v.get(246)).setAttribute("size","26" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(246)).setAttribute("validacion","" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(204)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:204   */

      /* Empieza nodo:249 / Elemento padre: 184   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(184)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("colspan","4" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:252 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("table"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(254)).setAttribute("border","0" );
      ((Element)v.get(254)).setAttribute("align","left" );
      ((Element)v.get(254)).setAttribute("cellspacing","0" );
      ((Element)v.get(254)).setAttribute("cellpadding","0" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(259)).setAttribute("nombre","lblOperadorCantidadEstimada" );
      ((Element)v.get(259)).setAttribute("alto","13" );
      ((Element)v.get(259)).setAttribute("filas","1" );
      ((Element)v.get(259)).setAttribute("id","datosTitle" );
      ((Element)v.get(259)).setAttribute("cod","2579" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblCantidadEstimada" );
      ((Element)v.get(263)).setAttribute("alto","13" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","2580" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(255)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:255   */

      /* Empieza nodo:266 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(270)).setAttribute("nombre","cbOperadorCantidadEstimadas" );
      ((Element)v.get(270)).setAttribute("size","1" );
      ((Element)v.get(270)).setAttribute("multiple","N" );
      ((Element)v.get(270)).setAttribute("valorinicial","1" );
      ((Element)v.get(270)).setAttribute("textoinicial","<" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(272)).setAttribute("ID","1" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

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
      ((Element)v.get(274)).setAttribute("VALOR",">" );
      ((Element)v.get(272)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 271   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(275)).setAttribute("ID","2" );
      ((Element)v.get(271)).appendChild((Element)v.get(275));

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

      /* Empieza nodo:278 / Elemento padre: 271   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(278)).setAttribute("ID","3" );
      ((Element)v.get(271)).appendChild((Element)v.get(278));

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

      /* Empieza nodo:281 / Elemento padre: 271   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(281)).setAttribute("ID","4" );
      ((Element)v.get(271)).appendChild((Element)v.get(281));

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
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:284 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","25" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(266)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(287)).setAttribute("nombre","txtCantidadEstimadas" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(287)).setAttribute("max","10" );
      ((Element)v.get(287)).setAttribute("tipo","" );
      ((Element)v.get(287)).setAttribute("onchange","" );
      ((Element)v.get(287)).setAttribute("req","N" );
      ((Element)v.get(287)).setAttribute("size","12" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(287)).setAttribute("validacion","" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:266   */

      /* Empieza nodo:290 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("colspan","4" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:293 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("table"));
      ((Element)v.get(295)).setAttribute("width","100%" );
      ((Element)v.get(295)).setAttribute("border","0" );
      ((Element)v.get(295)).setAttribute("align","left" );
      ((Element)v.get(295)).setAttribute("cellspacing","0" );
      ((Element)v.get(295)).setAttribute("cellpadding","0" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("id","datosTitle" );
      ((Element)v.get(300)).setAttribute("cod","1869" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","25" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("id","datosTitle" );
      ((Element)v.get(304)).setAttribute("cod","581" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(296)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:296   */

      /* Empieza nodo:307 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(311)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(311)).setAttribute("size","5" );
      ((Element)v.get(311)).setAttribute("multiple","S" );
      ((Element)v.get(311)).setAttribute("valorinicial","" );
      ((Element)v.get(311)).setAttribute("textoinicial","" );
      ((Element)v.get(311)).setAttribute("id","datosCampos" );
      ((Element)v.get(311)).setAttribute("req","N" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:313 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","25" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(307)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(316)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(316)).setAttribute("size","5" );
      ((Element)v.get(316)).setAttribute("multiple","S" );
      ((Element)v.get(316)).setAttribute("valorinicial","" );
      ((Element)v.get(316)).setAttribute("textoinicial","" );
      ((Element)v.get(316)).setAttribute("id","datosCampos" );
      ((Element)v.get(316)).setAttribute("req","N" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:318 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("width","100%" );
      ((Element)v.get(307)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:307   */

      /* Empieza nodo:320 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("colspan","4" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:323 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("table"));
      ((Element)v.get(325)).setAttribute("width","1%" );
      ((Element)v.get(325)).setAttribute("border","0" );
      ((Element)v.get(325)).setAttribute("align","left" );
      ((Element)v.get(325)).setAttribute("cellspacing","0" );
      ((Element)v.get(325)).setAttribute("cellpadding","0" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(330)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(330)).setAttribute("alto","13" );
      ((Element)v.get(330)).setAttribute("filas","1" );
      ((Element)v.get(330)).setAttribute("id","datosTitle" );
      ((Element)v.get(330)).setAttribute("cod","608" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(334)).setAttribute("nombre","lblTipoSeleccion" );
      ((Element)v.get(334)).setAttribute("alto","13" );
      ((Element)v.get(334)).setAttribute("filas","1" );
      ((Element)v.get(334)).setAttribute("id","datosTitle" );
      ((Element)v.get(334)).setAttribute("cod","2581" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(326)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(326)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lblTipoSeleccion2" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("id","datosTitle" );
      ((Element)v.get(338)).setAttribute("cod","837" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("width","100%" );
      ((Element)v.get(326)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:326   */

      /* Empieza nodo:341 / Elemento padre: 325   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(325)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(345)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(345)).setAttribute("size","5" );
      ((Element)v.get(345)).setAttribute("multiple","S" );
      ((Element)v.get(345)).setAttribute("valorinicial","" );
      ((Element)v.get(345)).setAttribute("textoinicial","" );
      ((Element)v.get(345)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).setAttribute("req","N" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:347 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","25" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(349)).setAttribute("valign","top" );
      ((Element)v.get(341)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(350)).setAttribute("nombre","cbTipoSeleccion" );
      ((Element)v.get(350)).setAttribute("size","1" );
      ((Element)v.get(350)).setAttribute("multiple","N" );
      ((Element)v.get(350)).setAttribute("valorinicial","1" );
      ((Element)v.get(350)).setAttribute("textoinicial","Resumido" );
      ((Element)v.get(350)).setAttribute("id","datosCampos" );
      ((Element)v.get(350)).setAttribute("req","N" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(352)).setAttribute("ID","1" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(353)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","2" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 352   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(354)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(354)).setAttribute("TIPO","STRING" );
      ((Element)v.get(354)).setAttribute("VALOR","Detallado" );
      ((Element)v.get(352)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:355 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).setAttribute("width","100%" );
      ((Element)v.get(341)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","25" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(357)).setAttribute("valign","top" );
      ((Element)v.get(341)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(358)).setAttribute("nombre","cbTipoSeleccionCriterio" );
      ((Element)v.get(358)).setAttribute("size","1" );
      ((Element)v.get(358)).setAttribute("multiple","N" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(358)).setAttribute("valorinicial","1" );
      ((Element)v.get(358)).setAttribute("textoinicial","Por Formula y Variable de Venta" );
      ((Element)v.get(358)).setAttribute("id","datosCampos" );
      ((Element)v.get(358)).setAttribute("req","N" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(360)).setAttribute("ID","1" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(361)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(361)).setAttribute("TIPO","STRING" );
      ((Element)v.get(361)).setAttribute("VALOR","2" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(362)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(362)).setAttribute("TIPO","STRING" );
      ((Element)v.get(362)).setAttribute("VALOR","Por Atributos" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:363 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(341)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","8" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:341   */

      /* Empieza nodo:365 / Elemento padre: 325   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(325)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("colspan","4" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:53   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:368 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:46   */

      /* Empieza nodo:370 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("table"));
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(375)).setAttribute("border","0" );
      ((Element)v.get(375)).setAttribute("align","center" );
      ((Element)v.get(375)).setAttribute("cellspacing","0" );
      ((Element)v.get(375)).setAttribute("cellpadding","0" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("class","botonera" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(378)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(378)).setAttribute("ID","botonContenido" );
      ((Element)v.get(378)).setAttribute("tipo","html" );
      ((Element)v.get(378)).setAttribute("accion","generar();" );
      ((Element)v.get(378)).setAttribute("estado","false" );
      ((Element)v.get(378)).setAttribute("cod","2495" );
      ((Element)v.get(378)).setAttribute("ontab","focaliza('Formulario.cbPais');" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:379 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","8" );
      ((Element)v.get(380)).setAttribute("height","12" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:370   */

      /* Empieza nodo:381 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("width","12" );
      ((Element)v.get(382)).setAttribute("align","center" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(383)).setAttribute("width","12" );
      ((Element)v.get(383)).setAttribute("height","12" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","756" );
      ((Element)v.get(381)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("width","12" );
      ((Element)v.get(381)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","12" );
      ((Element)v.get(387)).setAttribute("height","1" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:381   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:11   */


   }

}
