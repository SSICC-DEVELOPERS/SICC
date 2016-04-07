
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_cartera_cobranza_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_cartera_cobranza_generar" );
      ((Element)v.get(0)).setAttribute("cod","0818" );
      ((Element)v.get(0)).setAttribute("titulo","Generar informe cartera de cobranza" );
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
      v.add(doc.createTextNode("\r   \r   \r   function onLoad(){\r      configurarMenuSecundario('Formulario');\r      fMostrarMensajeError();\r      focaliza('Formulario.txtFechaAsignacion');\r   }\r   function generar(formato){\r    \r      if(sicc_validaciones_generales()){\r        if(validarCombosUsuarios()){\r           if(validarFecha()){\r              if(validarOrden()){\r              \r                 var a = new Object();\r                 a.accion = 'generar';\r                 a.fechaAsignacion = get('Formulario.txtFechaAsignacion');\r                 a.usuario = get('Formulario.cbUsuario');  \r                 a.usuarioDesc = get('Formulario.cbUsuario', 'T');\r                 a.grupoUsuarios = get('Formulario.cbGrupoUsuarios');\r                 a.grupoUsuariosDesc = get('Formulario.cbGrupoUsuarios', 'T');\r                 a.marca = get('Formulario.cbMarca', 'V');\r                 a.canal = get('Formulario.cbCanal','V');\r                 a.periodo = get('Formulario.cbPeriodo', 'V');\r                 a.marcaDesc = get('Formulario.cbMarca', 'T');\r                 a.canalDesc = get('Formulario.cbCanal','T');\r                 a.periodoDesc = get('Formulario.cbPeriodo', 'T');\r                 a.region = get('Formulario.cbRegion');\r                 a.regionDesc = get('Formulario.cbRegion', 'T');\r                 a.zona = get('Formulario.cbZona');\r                 a.zonaDesc = get('Formulario.cbZona', 'T');\r                 a.seccion = get('Formulario.cbSeccion');\r                 a.seccionDesc = get('Formulario.cbSeccion', 'T');\r                 a.territorio = get('Formulario.txtTerritorio');\r                 a.orden1 = camposOrden(get('Formulario.cbOrdenColumna1'));\r                 a.orden2 = camposOrden(get('Formulario.cbOrdenColumna2'));\r                 a.orden3 = camposOrden(get('Formulario.cbOrdenColumna3'));         \r                 a.formato = formato;  \r                 mostrarModalSICC('COBCarteraCobranza','generar', a);  \r                 \r\r              }\r           }\r        }\r     }\r   }\r\r\r   function validarOrden(){\r      var orden1 = get('Formulario.cbOrdenColumna1');\r      var orden2 = get('Formulario.cbOrdenColumna2');\r      var orden3 = get('Formulario.cbOrdenColumna3');\r         \r      if(orden1.toString() == orden2.toString()){\r         cdos_mostrarAlert('El campo Orden Columna 2 no puede ser igual al campo Orden Columna 1');\r         focaliza('Formulario.cbOrdenColumna2')\r         return false;\r      }\r      \r      if(orden3.toString() == orden1.toString()){\r         cdos_mostrarAlert('El campo Orden Columna 3 no puede ser igual al campo Orden Columna 1');\r         focaliza('Formulario.cbOrdenColumna3');\r         return false;\r      }else{\r         if(orden3.toString() == orden2.toString()){\r            cdos_mostrarAlert('El campo Orden Columna 3 no puede ser igual al campo Orden Columna 2');\r            focaliza('Formulario.cbOrdenColumna3');\r            return false;   \r         }\r      }\r      \r      return true;\r   \r   }\r\r   \r   function validarCombosUsuarios(){\r      var usuario       = get('Formulario.cbUsuario');\r      var grupoUsuarios = get('Formulario.cbGrupoUsuarios');\r     \r      if(usuario == '' && grupoUsuarios == ''){\r         cdos_mostrarAlert('Debe seleccionar el campo Usuario o el campo Grupo de Usuarios');\r         focaliza('Formulario.cbUsuario');\r         return false;\r      }else{\r        if(usuario != '' && grupoUsuarios != ''){\r           cdos_mostrarAlert('Solo puede seleccionar el campo Usuario o el campo Grupo de Usuarios');\r           focaliza('Formulario.cbUsuario');  \r           return false;\r        }\r      }\r      return true;\r  }\r\r   function recolectarParametros(){\r            \r      set('Formulario.fechaAsignacion', get('Formulario.txtFechaAsignacion'));\r      set('Formulario.usuario', get('Formulario.cbUsuario'));      \r      set('Formulario.grupoUsuarios', get('Formulario.cbGrupoUsuarios'));\r      set('Formulario.marca', get('Formulario.cbMarca', 'V'));\r      set('Formulario.canal', get('Formulario.cbCanal','V'));\r      set('Formulario.periodo', get('Formulario.cbPeriodo', 'V'));\r      set('Formulario.marcaDesc', get('Formulario.cbMarca', 'T'));\r      set('Formulario.canalDesc', get('Formulario.cbCanal','T'));\r      set('Formulario.periodoDesc', get('Formulario.cbPeriodo', 'T'));\r      set('Formulario.region', get('Formulario.cbRegion'));\r      set('Formulario.zona', get('Formulario.cbZona'));\r      set('Formulario.seccion', get('Formulario.cbSeccion'));\r      set('Formulario.territorio', get('Formulario.txtTerritorio'));\r      set('Formulario.orden1', camposOrden(get('Formulario.cbOrdenColumna1')));\r      set('Formulario.orden2', camposOrden(get('Formulario.cbOrdenColumna2')));\r      set('Formulario.orden3', camposOrden(get('Formulario.cbOrdenColumna3')));\r    \r              \r   }\r \r   \r\r    function camposOrden(orden){\r       var valor;\r           \r       if(orden == '1'){\r          valor = \"'REGION'\";\r       }\r       \r       if(orden == '2'){\r          valor = \"'ZONA'\";\r       }\r       \r       if(orden == '3'){\r          valor = \"'TERRITORIO'\";\r       }\r       \r       if(orden == '4'){\r          valor = \"'SECCION'\";\r       }\r       \r       if(orden == '5'){\r          valor = \"'COD_CONSULTORA'\";\r       }\r       \r       if(orden == '6'){\r          valor = \"'CONSULTORA'\";\r       }\r       \r       if(orden == '7'){\r          valor = \"'DOCUMENTO'\";\r       }\r       \r       if(orden == '8'){\r          valor = \"'TIPO_VIA, NOMBRE_VIA, NUMERO, INTERIOR, MANZANA, LOTE, KM'\";\r       }\r       \r       if(orden == '9'){\r          valor = \"'TELEFONO'\";\r       }\r       \r       if(orden == '10'){\r          valor = \"'CAMP'\";\r       }\r       \r       if(orden == '11'){\r          valor = \"'BOLETA'\";\r       }\r       \r       if(orden == '12'){\r          valor = \"'FECHA_FACT'\";\r       }\r       \r       if(orden == '13'){\r          valor = \"'IMPORTE_FACTURADO'\";\r       }\r       \r      if(orden =='14'){\r          valor = \"'SALDO'\";\r       }\r       \r       return valor;\r    \r    }\r\r   \r    function onchangeMarcaCanal(){\r        \r       marca  = get('Formulario.cbMarca');\r       canal  = get('Formulario.cbCanal');\r       pais   = get('Formulario.pais');\r       idioma = get('Formulario.idioma');\r      \r       if(marca != '' && canal != ''){\r          var arr = new Array();\r          var arr2 = new Array();\r             \r          arr[arr.length] = [\"oidIdioma\", idioma]; \r          arr[arr.length] = [\"oidPais\", pais]; \r          arr[arr.length] = [\"marca\", marca];\r          arr[arr.length] = [\"canal\", canal];\r          \r          arr2[arr2.length] = [\"oidIdioma\", idioma]; \r          arr2[arr2.length] = [\"oidPais\", pais]; \r          arr2[arr2.length] = [\"oidMarca\", marca];\r          arr2[arr2.length] = [\"oidCanal\", canal];\r           \r          recargaCombo(\"Formulario.cbPeriodo\",\"PRECargarPeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arr);\r          recargaCombo(\"Formulario.cbRegion\",\"ZONRecargaRegiones\", \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arr2);         \r\r        \r       }else{\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('Formulario.cbPeriodo', aCombo, []);\r          set_combo('Formulario.cbZona', aCombo, []);\r          set_combo('Formulario.cbSeccion', aCombo, []);\r       }\r    } \r\r   function onchange_Region(){\r         limpiarZona();\r         if(get('Formulario.cbRegion') != ''){\r              recargaCombo('Formulario.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',[[ \"oidRegion\", get('Formulario.cbRegion') ]] );\r         }\r    }\r\r\r   function limpiarZona(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbZona', aCombo, []);\r   }\r   \r   function onchange_Zona(){\r      limpiarSeccion();\r      if(get('Formulario.cbZona') != ''){\r         recargaCombo('Formulario.cbSeccion', 'ZONRecargaSecciones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',[[ \"oidZona\", get('Formulario.cbZona') ]] );  \r      }\r   \r   }\r\r   function limpiarSeccion(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('Formulario.cbSeccion', aCombo, []); \r   }\r\r\r   function fLimpiar(){\r     var aCombo = new Array(new Array(\"\",\"\"));\r     \r     set_combo('Formulario.cbPeriodo', aCombo, []); \r     set_combo('Formulario.cbRegion', aCombo, []); \r     set_combo('Formulario.cbZona', aCombo, []); \r     set_combo('Formulario.cbSeccion', aCombo, []); \r     \r     focaliza('Formulario.txtFechaAsignacion');\r   }\r\r\r  function validarFecha(){\r      var fechaAsignacion = get('Formulario.txtFechaAsignacion');\r      var formatoFecha = get('Formulario.hFormatoFechaPais');\r       \r      if (! EsFechaValida_SICC(fechaAsignacion , \"Formulario\")){\r          GestionarMensaje(\"1006\", formatoFecha, null, null);\r          focaliza(\"Formulario.txtFechaAsignacion\");\r          return false;\r      }\r        \r      return true;   \r   \r   }\r   \r\r \r\r\r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtFechaAsignacion" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1660" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbOrdenColumna1" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","2654" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbOrdenColumna2" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2655" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbOrdenColumna3" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","2656" );
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
      ((Element)v.get(19)).setAttribute("nombre","fechaAsignacion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","usuario" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","grupoUsuarios" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","marca" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","canal" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","periodo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","marcaDesc" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","canalDesc" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","periodoDesc" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","region" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","zona" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","seccion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","territorio" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","orden1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","orden2" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","orden3" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(35)).setAttribute("nombre","capa1" );
      ((Element)v.get(11)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","12" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","750" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","1" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(49)).setAttribute("class","legend" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","legend" );
      ((Element)v.get(50)).setAttribute("cod","00275" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","left" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("colspan","4" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblFechaAsignacion" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","1660" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblUsuario" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","136" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblGrupoUsuarios" );
      ((Element)v.get(70)).setAttribute("alto","13" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","2653" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(58)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:58   */

      /* Empieza nodo:73 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(77)).setAttribute("nombre","txtFechaAsignacion" );
      ((Element)v.get(77)).setAttribute("id","datosCampos" );
      ((Element)v.get(77)).setAttribute("max","10" );
      ((Element)v.get(77)).setAttribute("tipo","" );
      ((Element)v.get(77)).setAttribute("onchange","" );
      ((Element)v.get(77)).setAttribute("req","S" );
      ((Element)v.get(77)).setAttribute("size","12" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("validacion","" );
      ((Element)v.get(77)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarExcel');" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(81)).setAttribute("nombre","cbUsuario" );
      ((Element)v.get(81)).setAttribute("size","1" );
      ((Element)v.get(81)).setAttribute("multiple","N" );
      ((Element)v.get(81)).setAttribute("valorinicial","" );
      ((Element)v.get(81)).setAttribute("textoinicial","" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("req","N" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(86)).setAttribute("nombre","cbGrupoUsuarios" );
      ((Element)v.get(86)).setAttribute("size","1" );
      ((Element)v.get(86)).setAttribute("multiple","N" );
      ((Element)v.get(86)).setAttribute("valorinicial","" );
      ((Element)v.get(86)).setAttribute("textoinicial","" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).setAttribute("req","N" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:73   */

      /* Empieza nodo:90 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("colspan","4" );
   }

   private void getXML360(Document doc) {
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
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:93 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(93));

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
      ((Element)v.get(100)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","6" );
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
      ((Element)v.get(104)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","7" );
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
      ((Element)v.get(111)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(111)).setAttribute("size","1" );
      ((Element)v.get(111)).setAttribute("multiple","N" );
      ((Element)v.get(111)).setAttribute("valorinicial","" );
      ((Element)v.get(111)).setAttribute("textoinicial","" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("onchange","onchangeMarcaCanal();" );
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
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(116)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(116)).setAttribute("size","1" );
      ((Element)v.get(116)).setAttribute("multiple","N" );
      ((Element)v.get(116)).setAttribute("valorinicial","" );
      ((Element)v.get(116)).setAttribute("textoinicial","" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).setAttribute("req","N" );
      ((Element)v.get(116)).setAttribute("onchange","onchangeMarcaCanal();" );
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

      /* Empieza nodo:123 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(123));

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
      ((Element)v.get(130)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","276" );
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
      ((Element)v.get(134)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","109" );
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
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(141)).setAttribute("size","1" );
      ((Element)v.get(141)).setAttribute("multiple","N" );
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
      ((Element)v.get(137)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(146)).setAttribute("size","1" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("valorinicial","" );
      ((Element)v.get(146)).setAttribute("textoinicial","" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("req","N" );
      ((Element)v.get(146)).setAttribute("onchange","onchange_Region();" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(137)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:137   */

      /* Empieza nodo:150 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("colspan","4" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:153 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

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
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblZona" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","143" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","25" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","112" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:156   */

      /* Empieza nodo:167 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(171)).setAttribute("nombre","cbZona" );
      ((Element)v.get(171)).setAttribute("size","1" );
      ((Element)v.get(171)).setAttribute("multiple","N" );
      ((Element)v.get(171)).setAttribute("valorinicial","" );
      ((Element)v.get(171)).setAttribute("textoinicial","" );
      ((Element)v.get(171)).setAttribute("id","datosCampos" );
      ((Element)v.get(171)).setAttribute("req","N" );
      ((Element)v.get(171)).setAttribute("onchange","onchange_Zona();" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:173 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(176)).setAttribute("size","1" );
      ((Element)v.get(176)).setAttribute("multiple","N" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(167)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:167   */

      /* Empieza nodo:180 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("colspan","4" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:183 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("table"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(185)).setAttribute("border","0" );
      ((Element)v.get(185)).setAttribute("align","left" );
      ((Element)v.get(185)).setAttribute("cellspacing","0" );
      ((Element)v.get(185)).setAttribute("cellpadding","0" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).setAttribute("cod","126" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(186)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:186   */

      /* Empieza nodo:193 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(197)).setAttribute("nombre","txtTerritorio" );
      ((Element)v.get(197)).setAttribute("id","datosCampos" );
      ((Element)v.get(197)).setAttribute("max","18" );
      ((Element)v.get(197)).setAttribute("tipo","" );
      ((Element)v.get(197)).setAttribute("onchange","" );
      ((Element)v.get(197)).setAttribute("req","N" );
      ((Element)v.get(197)).setAttribute("size","20" );
      ((Element)v.get(197)).setAttribute("valor","" );
      ((Element)v.get(197)).setAttribute("validacion","" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","8" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:193   */

      /* Empieza nodo:200 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("colspan","4" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:203 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("table"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(205)).setAttribute("border","0" );
      ((Element)v.get(205)).setAttribute("align","left" );
      ((Element)v.get(205)).setAttribute("cellspacing","0" );
      ((Element)v.get(205)).setAttribute("cellpadding","0" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lblOrdenColumna1" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","2654" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblOrdenColumna2" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","2655" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(218)).setAttribute("nombre","lblOrdenColumna3" );
      ((Element)v.get(218)).setAttribute("alto","13" );
      ((Element)v.get(218)).setAttribute("filas","1" );
      ((Element)v.get(218)).setAttribute("id","datosTitle" );
      ((Element)v.get(218)).setAttribute("cod","2656" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:206   */

      /* Empieza nodo:221 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(221)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(225)).setAttribute("nombre","cbOrdenColumna1" );
      ((Element)v.get(225)).setAttribute("size","1" );
      ((Element)v.get(225)).setAttribute("multiple","N" );
      ((Element)v.get(225)).setAttribute("valorinicial","1" );
      ((Element)v.get(225)).setAttribute("textoinicial","Región" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).setAttribute("req","S" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(227)).setAttribute("ID","1" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(228)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(228)).setAttribute("TIPO","STRING" );
      ((Element)v.get(228)).setAttribute("VALOR","2" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(229)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(229)).setAttribute("TIPO","STRING" );
      ((Element)v.get(229)).setAttribute("VALOR","Zona" );
      ((Element)v.get(227)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:227   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(230)).setAttribute("ID","2" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(226)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(231)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(231)).setAttribute("TIPO","STRING" );
      ((Element)v.get(231)).setAttribute("VALOR","3" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 230   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","Seccion" );
      ((Element)v.get(230)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:230   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(233)).setAttribute("ID","3" );
      ((Element)v.get(226)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(234)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(234)).setAttribute("TIPO","STRING" );
      ((Element)v.get(234)).setAttribute("VALOR","4" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","Territorio" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:233   */

      /* Empieza nodo:236 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(236)).setAttribute("ID","4" );
      ((Element)v.get(226)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(237)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(237)).setAttribute("TIPO","STRING" );
      ((Element)v.get(237)).setAttribute("VALOR","5" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(238)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(238)).setAttribute("TIPO","STRING" );
      ((Element)v.get(238)).setAttribute("VALOR","Código consultora" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(239)).setAttribute("ID","5" );
      ((Element)v.get(226)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(240)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(240)).setAttribute("TIPO","STRING" );
      ((Element)v.get(240)).setAttribute("VALOR","6" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 239   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(241)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(241)).setAttribute("TIPO","STRING" );
      ((Element)v.get(241)).setAttribute("VALOR","Consultora" );
      ((Element)v.get(239)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(242)).setAttribute("ID","6" );
      ((Element)v.get(226)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(243)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(243)).setAttribute("TIPO","STRING" );
      ((Element)v.get(243)).setAttribute("VALOR","7" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(244)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(244)).setAttribute("TIPO","STRING" );
      ((Element)v.get(244)).setAttribute("VALOR","Id. documento" );
      ((Element)v.get(242)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(245)).setAttribute("ID","7" );
      ((Element)v.get(226)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(246)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(246)).setAttribute("TIPO","STRING" );
      ((Element)v.get(246)).setAttribute("VALOR","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 245   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(247)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(247)).setAttribute("TIPO","STRING" );
      ((Element)v.get(247)).setAttribute("VALOR","Dirección" );
      ((Element)v.get(245)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:245   */

      /* Empieza nodo:248 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(248)).setAttribute("ID","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(249)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(249)).setAttribute("TIPO","STRING" );
      ((Element)v.get(249)).setAttribute("VALOR","9" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 248   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(250)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(250)).setAttribute("TIPO","STRING" );
      ((Element)v.get(250)).setAttribute("VALOR","Teléfono" );
      ((Element)v.get(248)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:248   */

      /* Empieza nodo:251 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(251)).setAttribute("ID","9" );
      ((Element)v.get(226)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(252)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(252)).setAttribute("TIPO","STRING" );
      ((Element)v.get(252)).setAttribute("VALOR","10" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 251   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(253)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(253)).setAttribute("TIPO","STRING" );
      ((Element)v.get(253)).setAttribute("VALOR","Campaña" );
      ((Element)v.get(251)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:251   */

      /* Empieza nodo:254 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(254)).setAttribute("ID","10" );
      ((Element)v.get(226)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(255)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(255)).setAttribute("TIPO","STRING" );
      ((Element)v.get(255)).setAttribute("VALOR","11" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 254   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(256)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(256)).setAttribute("TIPO","STRING" );
      ((Element)v.get(256)).setAttribute("VALOR","Boleta" );
      ((Element)v.get(254)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:254   */

      /* Empieza nodo:257 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(257)).setAttribute("ID","11" );
      ((Element)v.get(226)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(258)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(258)).setAttribute("TIPO","STRING" );
      ((Element)v.get(258)).setAttribute("VALOR","12" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(259)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(259)).setAttribute("TIPO","STRING" );
      ((Element)v.get(259)).setAttribute("VALOR","Fecha facturación" );
      ((Element)v.get(257)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:257   */

      /* Empieza nodo:260 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(260)).setAttribute("ID","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(261)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(261)).setAttribute("TIPO","STRING" );
      ((Element)v.get(261)).setAttribute("VALOR","13" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 260   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(262)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(262)).setAttribute("TIPO","STRING" );
      ((Element)v.get(262)).setAttribute("VALOR","Facturado" );
      ((Element)v.get(260)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:260   */

      /* Empieza nodo:263 / Elemento padre: 226   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(263)).setAttribute("ID","13" );
      ((Element)v.get(226)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(264)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(264)).setAttribute("TIPO","STRING" );
      ((Element)v.get(264)).setAttribute("VALOR","14" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 263   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(265)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(265)).setAttribute("TIPO","STRING" );
      ((Element)v.get(265)).setAttribute("VALOR","Saldo de cartera" );
      ((Element)v.get(263)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:263   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:266 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","25" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(221)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(269)).setAttribute("nombre","cbOrdenColumna2" );
      ((Element)v.get(269)).setAttribute("size","1" );
      ((Element)v.get(269)).setAttribute("multiple","N" );
      ((Element)v.get(269)).setAttribute("valorinicial","1" );
      ((Element)v.get(269)).setAttribute("textoinicial","Región" );
      ((Element)v.get(269)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).setAttribute("req","S" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(271)).setAttribute("ID","1" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(272)).setAttribute("NOMBRE","CODIGO" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(272)).setAttribute("TIPO","STRING" );
      ((Element)v.get(272)).setAttribute("VALOR","2" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 271   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(273)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(273)).setAttribute("TIPO","STRING" );
      ((Element)v.get(273)).setAttribute("VALOR","Zona" );
      ((Element)v.get(271)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:271   */

      /* Empieza nodo:274 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(274)).setAttribute("ID","2" );
      ((Element)v.get(270)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(275)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(275)).setAttribute("TIPO","STRING" );
      ((Element)v.get(275)).setAttribute("VALOR","3" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 274   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(276)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(276)).setAttribute("TIPO","STRING" );
      ((Element)v.get(276)).setAttribute("VALOR","Seccion" );
      ((Element)v.get(274)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(277)).setAttribute("ID","3" );
      ((Element)v.get(270)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(278)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(278)).setAttribute("TIPO","STRING" );
      ((Element)v.get(278)).setAttribute("VALOR","4" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 277   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(279)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(279)).setAttribute("TIPO","STRING" );
      ((Element)v.get(279)).setAttribute("VALOR","Territorio" );
      ((Element)v.get(277)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:277   */

      /* Empieza nodo:280 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(280)).setAttribute("ID","4" );
      ((Element)v.get(270)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(281)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(281)).setAttribute("TIPO","STRING" );
      ((Element)v.get(281)).setAttribute("VALOR","5" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 280   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(282)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(282)).setAttribute("TIPO","STRING" );
      ((Element)v.get(282)).setAttribute("VALOR","Código consultora" );
      ((Element)v.get(280)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(283)).setAttribute("ID","5" );
      ((Element)v.get(270)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(284)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(284)).setAttribute("TIPO","STRING" );
      ((Element)v.get(284)).setAttribute("VALOR","6" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 283   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(285)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(285)).setAttribute("TIPO","STRING" );
      ((Element)v.get(285)).setAttribute("VALOR","Consultora" );
      ((Element)v.get(283)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:283   */

      /* Empieza nodo:286 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(286)).setAttribute("ID","6" );
      ((Element)v.get(270)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(287)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(287)).setAttribute("TIPO","STRING" );
      ((Element)v.get(287)).setAttribute("VALOR","7" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 286   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(288)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(288)).setAttribute("TIPO","STRING" );
      ((Element)v.get(288)).setAttribute("VALOR","Id. documento" );
      ((Element)v.get(286)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:286   */

      /* Empieza nodo:289 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(289)).setAttribute("ID","7" );
      ((Element)v.get(270)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(290)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(290)).setAttribute("TIPO","STRING" );
      ((Element)v.get(290)).setAttribute("VALOR","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 289   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(291)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(291)).setAttribute("TIPO","STRING" );
      ((Element)v.get(291)).setAttribute("VALOR","Dirección" );
      ((Element)v.get(289)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:289   */

      /* Empieza nodo:292 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(292)).setAttribute("ID","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(293)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(293)).setAttribute("TIPO","STRING" );
      ((Element)v.get(293)).setAttribute("VALOR","9" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 292   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(294)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(294)).setAttribute("TIPO","STRING" );
      ((Element)v.get(294)).setAttribute("VALOR","Teléfono" );
      ((Element)v.get(292)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(295)).setAttribute("ID","9" );
      ((Element)v.get(270)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(296)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(296)).setAttribute("TIPO","STRING" );
      ((Element)v.get(296)).setAttribute("VALOR","10" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 295   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(297)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(297)).setAttribute("TIPO","STRING" );
      ((Element)v.get(297)).setAttribute("VALOR","Campaña" );
      ((Element)v.get(295)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:295   */

      /* Empieza nodo:298 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(298)).setAttribute("ID","10" );
      ((Element)v.get(270)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(299)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(299)).setAttribute("TIPO","STRING" );
      ((Element)v.get(299)).setAttribute("VALOR","11" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 298   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(300)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(300)).setAttribute("TIPO","STRING" );
      ((Element)v.get(300)).setAttribute("VALOR","Boleta" );
      ((Element)v.get(298)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:298   */

      /* Empieza nodo:301 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(301)).setAttribute("ID","11" );
      ((Element)v.get(270)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(302)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(302)).setAttribute("TIPO","STRING" );
      ((Element)v.get(302)).setAttribute("VALOR","12" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 301   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(303)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(303)).setAttribute("TIPO","STRING" );
      ((Element)v.get(303)).setAttribute("VALOR","Fecha facturación" );
      ((Element)v.get(301)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(304)).setAttribute("ID","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(305)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(305)).setAttribute("TIPO","STRING" );
      ((Element)v.get(305)).setAttribute("VALOR","13" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 304   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(306)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(306)).setAttribute("TIPO","STRING" );
      ((Element)v.get(306)).setAttribute("VALOR","Facturado" );
      ((Element)v.get(304)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:304   */

      /* Empieza nodo:307 / Elemento padre: 270   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(307)).setAttribute("ID","13" );
      ((Element)v.get(270)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(308)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(308)).setAttribute("TIPO","STRING" );
      ((Element)v.get(308)).setAttribute("VALOR","14" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 307   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(309)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(309)).setAttribute("TIPO","STRING" );
      ((Element)v.get(309)).setAttribute("VALOR","Saldo de cartera" );
      ((Element)v.get(307)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:307   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:310 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(221)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(313)).setAttribute("nombre","cbOrdenColumna3" );
      ((Element)v.get(313)).setAttribute("size","1" );
      ((Element)v.get(313)).setAttribute("multiple","N" );
      ((Element)v.get(313)).setAttribute("valorinicial","1" );
      ((Element)v.get(313)).setAttribute("textoinicial","Región" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).setAttribute("req","S" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(315)).setAttribute("ID","1" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(316)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(316)).setAttribute("TIPO","STRING" );
      ((Element)v.get(316)).setAttribute("VALOR","2" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 315   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(317)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(317)).setAttribute("TIPO","STRING" );
      ((Element)v.get(317)).setAttribute("VALOR","Zona" );
      ((Element)v.get(315)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:315   */

      /* Empieza nodo:318 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(318)).setAttribute("ID","2" );
      ((Element)v.get(314)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(319)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(319)).setAttribute("TIPO","STRING" );
      ((Element)v.get(319)).setAttribute("VALOR","3" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 318   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(320)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(320)).setAttribute("TIPO","STRING" );
      ((Element)v.get(320)).setAttribute("VALOR","Seccion" );
      ((Element)v.get(318)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:318   */

      /* Empieza nodo:321 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(321)).setAttribute("ID","3" );
      ((Element)v.get(314)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(322)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(322)).setAttribute("TIPO","STRING" );
      ((Element)v.get(322)).setAttribute("VALOR","4" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 321   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(323)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(323)).setAttribute("TIPO","STRING" );
      ((Element)v.get(323)).setAttribute("VALOR","Territorio" );
      ((Element)v.get(321)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(324)).setAttribute("ID","4" );
      ((Element)v.get(314)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(325)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(325)).setAttribute("TIPO","STRING" );
      ((Element)v.get(325)).setAttribute("VALOR","5" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 324   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(326)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(326)).setAttribute("TIPO","STRING" );
      ((Element)v.get(326)).setAttribute("VALOR","Código consultora" );
      ((Element)v.get(324)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(327)).setAttribute("ID","5" );
      ((Element)v.get(314)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(328)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(328)).setAttribute("TIPO","STRING" );
      ((Element)v.get(328)).setAttribute("VALOR","6" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 327   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(329)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(329)).setAttribute("TIPO","STRING" );
      ((Element)v.get(329)).setAttribute("VALOR","Consultora" );
      ((Element)v.get(327)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:327   */

      /* Empieza nodo:330 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(330)).setAttribute("ID","6" );
      ((Element)v.get(314)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(331)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(331)).setAttribute("TIPO","STRING" );
      ((Element)v.get(331)).setAttribute("VALOR","7" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 330   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(332)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(332)).setAttribute("TIPO","STRING" );
      ((Element)v.get(332)).setAttribute("VALOR","Id. documento" );
      ((Element)v.get(330)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:330   */

      /* Empieza nodo:333 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(333)).setAttribute("ID","7" );
      ((Element)v.get(314)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(334)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(334)).setAttribute("TIPO","STRING" );
      ((Element)v.get(334)).setAttribute("VALOR","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 333   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(335)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(335)).setAttribute("TIPO","STRING" );
      ((Element)v.get(335)).setAttribute("VALOR","Dirección" );
      ((Element)v.get(333)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:333   */

      /* Empieza nodo:336 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(336)).setAttribute("ID","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(337)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(337)).setAttribute("TIPO","STRING" );
      ((Element)v.get(337)).setAttribute("VALOR","9" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 336   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(338)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(338)).setAttribute("TIPO","STRING" );
      ((Element)v.get(338)).setAttribute("VALOR","Teléfono" );
      ((Element)v.get(336)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:336   */

      /* Empieza nodo:339 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(339)).setAttribute("ID","9" );
      ((Element)v.get(314)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(340)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(340)).setAttribute("TIPO","STRING" );
      ((Element)v.get(340)).setAttribute("VALOR","10" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 339   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(341)).setAttribute("TIPO","STRING" );
      ((Element)v.get(341)).setAttribute("VALOR","Campaña" );
      ((Element)v.get(339)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:339   */

      /* Empieza nodo:342 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(342)).setAttribute("ID","10" );
      ((Element)v.get(314)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(343)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(343)).setAttribute("TIPO","STRING" );
      ((Element)v.get(343)).setAttribute("VALOR","11" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 342   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(344)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(344)).setAttribute("TIPO","STRING" );
      ((Element)v.get(344)).setAttribute("VALOR","Boleta" );
      ((Element)v.get(342)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:342   */

      /* Empieza nodo:345 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(345)).setAttribute("ID","11" );
      ((Element)v.get(314)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(346)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(346)).setAttribute("TIPO","STRING" );
      ((Element)v.get(346)).setAttribute("VALOR","12" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 345   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(347)).setAttribute("TIPO","STRING" );
      ((Element)v.get(347)).setAttribute("VALOR","Fecha facturación" );
      ((Element)v.get(345)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:345   */

      /* Empieza nodo:348 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(348)).setAttribute("ID","12" );
      ((Element)v.get(314)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(349)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(349)).setAttribute("TIPO","STRING" );
      ((Element)v.get(349)).setAttribute("VALOR","13" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 348   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(350)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(350)).setAttribute("TIPO","STRING" );
      ((Element)v.get(350)).setAttribute("VALOR","Facturado" );
      ((Element)v.get(348)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:348   */

      /* Empieza nodo:351 / Elemento padre: 314   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(351)).setAttribute("ID","13" );
      ((Element)v.get(314)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(352)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(352)).setAttribute("TIPO","STRING" );
      ((Element)v.get(352)).setAttribute("VALOR","14" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 351   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(353)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","Saldo de cartera" );
      ((Element)v.get(351)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:351   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:354 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("width","100%" );
      ((Element)v.get(221)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:221   */

      /* Empieza nodo:356 / Elemento padre: 205   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(205)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("colspan","4" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","8" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:51   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:359 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:44   */

      /* Empieza nodo:361 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("table"));
      ((Element)v.get(366)).setAttribute("width","100%" );
      ((Element)v.get(366)).setAttribute("border","0" );
      ((Element)v.get(366)).setAttribute("align","center" );
      ((Element)v.get(366)).setAttribute("cellspacing","0" );
      ((Element)v.get(366)).setAttribute("cellpadding","0" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("class","botonera" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(369)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(369)).setAttribute("ID","botonContenido" );
      ((Element)v.get(369)).setAttribute("tipo","html" );
      ((Element)v.get(369)).setAttribute("accion","generar('pdf')" );
      ((Element)v.get(369)).setAttribute("estado","false" );
      ((Element)v.get(369)).setAttribute("cod","2495" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 368   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(370)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(370)).setAttribute("ID","botonContenido" );
      ((Element)v.get(370)).setAttribute("tipo","html" );
      ((Element)v.get(370)).setAttribute("accion","generar('xls')" );
      ((Element)v.get(370)).setAttribute("estado","false" );
      ((Element)v.get(370)).setAttribute("cod","2526" );
      ((Element)v.get(370)).setAttribute("ontab","focaliza('Formulario.txtFechaAsignacion')" );
      ((Element)v.get(368)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:371 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","12" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:361   */

      /* Empieza nodo:373 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(374)).setAttribute("align","center" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","12" );
      ((Element)v.get(375)).setAttribute("height","12" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("width","756" );
      ((Element)v.get(373)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(373)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","12" );
      ((Element)v.get(379)).setAttribute("height","1" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:373   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:11   */


   }

}
