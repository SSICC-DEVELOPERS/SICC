
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_usuarios_cronograma_cobranzas_detalle_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_usuarios_cronograma_cobranzas_detalle_modificar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
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
      v.add(doc.createTextNode("\r     \r      \r	function onLoadPag(){\r     ocultarLista();\r     DrdEnsanchaConMargenDcho('listado1',12);\r     eval (ON_RSZ);  \r     configurarMenuSecundario('Formulario');\r     fMostrarMensajeError();\r     focaliza('Formulario.cbUsuario');\r     eval (ON_RSZ);  \r	}\r\r\r   function fBorrar(){\r      if(listado1.numSelecc() >= 1){\r         eliminarFilas(listado1.codSeleccionados(),\"COBEliminarAsignacionUsuario\", mipgndo);\r      }else{\r         GestionarMensaje('4');\r      }\r    }\r\r\r\r  function onchangeUsuario(){\r      var usuario = get('Formulario.cbUsuario');\r      \r      if(usuario != ''){\r         recargaCombo(\"Formulario.cbCodigoEtapaDeuda\",\"COBRecargaEtapaDeuda\", \"es.indra.sicc.util.DTOOID\",[['oid', usuario]]); \r      }\r   \r   } \r   \r\r   function buscar(){\r      var usuario         = get('Formulario.cbUsuario');\r      var etapaDeuda      = get('Formulario.cbEtapaDeuda');\r      var tipoCargo       = get('Formulario.cbTipoCargo');\r          \r      var arrayDatos = new Array();\r         \r      arrayDatos[arrayDatos.length] = ['oidUsuarioEtapCobra', usuario];\r      arrayDatos[arrayDatos.length] = ['oidEtapaDeudaTCarg', etapaDeuda]\r      arrayDatos[arrayDatos.length] = ['oidTipoCargo', tipoCargo]\r            \r      configurarPaginado( mipgndo, \"COBConsultarUsuariosCronogramaCobranzaDetalle\", \"ConectorConsultarUsuariosCronogramaCobranzaDetalle\", \"es.indra.sicc.dtos.cob.DTOUsuarEtapaCobraDetal\", arrayDatos);\r      \r   }\r\r\r   function ocultarLista() {\r         document.all[\"Cplistado1\"].style.visibility='hidden'; \r         document.all[\"CpLin1listado1\"].style.visibility='hidden';\r         document.all[\"CpLin2listado1\"].style.visibility='hidden' ;\r         document.all[\"CpLin3listado1\"].style.visibility='hidden' ;\r         document.all[\"CpLin4listado1\"].style.visibility='hidden';\r         document.all[\"primera1Div\"].style.visibility='hidden'; \r         document.all[\"ret1Div\"].style.visibility='hidden'; \r         document.all[\"ava1Div\"].style.visibility='hidden';   \r         document.all[\"separaDiv\"].style.visibility='hidden';\r         \r         document.all[\"ModificarDiv\"].style.visibility='hidden';\r         document.all[\"DetalleDiv\"].style.visibility='hidden';\r         \r    }\r          \r    \r    function mostrarLista() {\r        document.all[\"Cplistado1\"].style.visibility='visible';\r        document.all[\"CpLin1listado1\"].style.visibility='visible';\r        document.all[\"CpLin2listado1\"].style.visibility='visible';\r        document.all[\"CpLin3listado1\"].style.visibility='visible';\r        document.all[\"CpLin4listado1\"].style.visibility='visible';\r        document.all[\"primera1Div\"].style.visibility='visible';\r        document.all[\"ret1Div\"].style.visibility='visible';\r        document.all[\"ava1Div\"].style.visibility='visible';\r        document.all[\"separaDiv\"].style.visibility='visible';\r        \r        if(get('Formulario.casoDeUso') == 'modificar'){\r           document.all[\"ModificarDiv\"].style.visibility='visible';\r           document.all[\"DetalleDiv\"].style.visibility='hidden';\r        }else{\r           document.all[\"ModificarDiv\"].style.visibility='hidden';\r           document.all[\"DetalleDiv\"].style.visibility='visible';\r        }\r        \r        if(get('Formulario.casoDeUso') == 'eliminar'){\r           btnProxy(4,1);\r        }\r   }\r\r\r    function prueba(ultima, rowset, error){\r        var tamano = rowset.length;\r    \r        if (tamano > 0) {\r           mostrarLista();\r           return true;\r        }else{\r           ocultarLista(); \r           cdos_mostrarAlert(error);\r           return false;\r     }\r  } \r\r   function fLimpiar(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      \r      set_combo('Formulario.cbCodigoEtapaDeuda', aCombo, []);\r      focaliza('Formulario.cbUsuario');\r   \r   }\r   \r      \r  function accionModificar(){   \r    if (listado1.codSeleccionados().length == 1) {    \r            var a = new Object();\r            a.oid = listado1.codSeleccionados();   \r            a.casoDeUso = get('Formulario.casoDeUso');\r            a.accion = 'modificarUsuario';\r            mostrarModalSICC('LPUsuariosCronogramaCobranzaDetalleMantenimiento', 'modificarUsuario', a, 795, 505);\r            buscar();\r    }else {   \r            GestionarMensaje('4');   \r    }   \r  }   \r\r\r   function accionDetalle(){   \r    if (listado1.codSeleccionados().length == 1) {    \r            var a = new Object();   \r            a.oid = listado1.codSeleccionados();   \r            a.accion = 'detalleUsuario';\r            a.casoDeUso = get('Formulario.casoDeUso');\r            mostrarModalSICC('LPUsuariosCronogramaCobranzaDetalleMantenimiento', 'detalleUsuario', a, 795, 505);\r            buscar();\r    }else {\r            GestionarMensaje('4');   \r    }   \r  }   \r\r\r	function onchangeCodEtapaDeuda(){\r      var codEtapaDeuda = get('Formulario.cbCodigoEtapaDeuda');\r      \r      if(codEtapaDeuda != ''){\r\r		  var arr = new Array();\r                \r          arr[arr.length] = [\"oidPais\", get('Formulario.pais')]; \r          arr[arr.length] = [\"oidIdioma\", get('Formulario.idioma')];\r          arr[arr.length] = [\"oid\", codEtapaDeuda];\r\r         recargaCombo(\"Formulario.cbTipoCargo\",\"COBRecupTiposCargoPorEtapa\", \"es.indra.sicc.util.DTOOID\",arr); \r      }\r   \r    }\r\r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","pais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oid" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","indicadorCU" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(30)).setAttribute("class","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("id","legend" );
      ((Element)v.get(31)).setAttribute("cod","0075" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","566" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","left" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("colspan","3" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:39 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblUsuario" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","1219" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","25" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCodigoEtapaDeuda" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("cod","818" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblTipoCargo" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","999" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(39)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:39   */

      /* Empieza nodo:54 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(54));

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
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(58)).setAttribute("nombre","cbUsuario" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("size","1" );
      ((Element)v.get(58)).setAttribute("multiple","N" );
      ((Element)v.get(58)).setAttribute("req","N" );
      ((Element)v.get(58)).setAttribute("valorinicial","" );
      ((Element)v.get(58)).setAttribute("textoinicial","" );
      ((Element)v.get(58)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(58)).setAttribute("onchange","onchangeUsuario();" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(63)).setAttribute("nombre","cbCodigoEtapaDeuda" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("size","1" );
      ((Element)v.get(63)).setAttribute("multiple","N" );
      ((Element)v.get(63)).setAttribute("req","N" );
      ((Element)v.get(63)).setAttribute("valorinicial","" );
      ((Element)v.get(63)).setAttribute("textoinicial","" );
      ((Element)v.get(63)).setAttribute("onchange","onchangeCodEtapaDeuda();" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","cbTipoCargo" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("req","N" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:54   */

      /* Empieza nodo:72 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("colspan","3" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","7" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:75 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:25   */

      /* Empieza nodo:77 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("class","botonera" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(85)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(85)).setAttribute("ID","botonContenido" );
      ((Element)v.get(85)).setAttribute("tipo","html" );
      ((Element)v.get(85)).setAttribute("accion","buscar();" );
      ((Element)v.get(85)).setAttribute("estado","false" );
      ((Element)v.get(85)).setAttribute("cod","1" );
      ((Element)v.get(85)).setAttribute("ontab","focaliza('Formulario.cbUsuario')" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:86 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","12" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:77   */

      /* Empieza nodo:88 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("height","12" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","756" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(94)).setAttribute("height","1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:88   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:95 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(95)).setAttribute("nombre","listado1" );
      ((Element)v.get(95)).setAttribute("ancho","569" );
      ((Element)v.get(95)).setAttribute("alto","317" );
      ((Element)v.get(95)).setAttribute("x","12" );
      ((Element)v.get(95)).setAttribute("y","122" );
      ((Element)v.get(95)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(95)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(96)).setAttribute("precarga","S" );
      ((Element)v.get(96)).setAttribute("conROver","S" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(97)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(97)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(97)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(97)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 96   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(98)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(98)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(98)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(98)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(99)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(99)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:96   */

      /* Empieza nodo:100 / Elemento padre: 95   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(95)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(101)).setAttribute("borde","1" );
      ((Element)v.get(101)).setAttribute("horizDatos","1" );
      ((Element)v.get(101)).setAttribute("horizCabecera","1" );
      ((Element)v.get(101)).setAttribute("vertical","1" );
      ((Element)v.get(101)).setAttribute("horizTitulo","1" );
      ((Element)v.get(101)).setAttribute("horizBase","1" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 100   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(102)).setAttribute("borde","#999999" );
      ((Element)v.get(102)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(102)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(102)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(102)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(102)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(102)).setAttribute("horizBase","#999999" );
      ((Element)v.get(100)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 95   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(103)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(103)).setAttribute("alto","22" );
      ((Element)v.get(103)).setAttribute("imgFondo","" );
      ((Element)v.get(103)).setAttribute("cod","00135" );
      ((Element)v.get(103)).setAttribute("ID","datosTitle" );
      ((Element)v.get(95)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 95   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(104)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(104)).setAttribute("alto","22" );
      ((Element)v.get(104)).setAttribute("imgFondo","" );
      ((Element)v.get(95)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 95   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(105)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(105)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(105)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(105)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(105)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(105)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(95)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","150" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","150" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","100" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","100" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","150" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("ancho","100" );
      ((Element)v.get(112)).setAttribute("minimizable","S" );
      ((Element)v.get(112)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("ancho","100" );
      ((Element)v.get(113)).setAttribute("minimizable","S" );
      ((Element)v.get(113)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("ancho","100" );
      ((Element)v.get(114)).setAttribute("minimizable","S" );
      ((Element)v.get(114)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","100" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:105   */

      /* Empieza nodo:116 / Elemento padre: 95   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(116)).setAttribute("alto","20" );
      ((Element)v.get(116)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(116)).setAttribute("imgFondo","" );
      ((Element)v.get(116)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(95)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","1219" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","818" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","999" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","6" );
      ((Element)v.get(116)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("cod","7" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("colFondo","" );
      ((Element)v.get(122)).setAttribute("ID","EstCab" );
      ((Element)v.get(122)).setAttribute("cod","124" );
      ((Element)v.get(116)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","109" );
      ((Element)v.get(116)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("colFondo","" );
      ((Element)v.get(124)).setAttribute("ID","EstCab" );
      ((Element)v.get(124)).setAttribute("cod","143" );
      ((Element)v.get(116)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("colFondo","" );
      ((Element)v.get(125)).setAttribute("ID","EstCab" );
      ((Element)v.get(125)).setAttribute("cod","112" );
      ((Element)v.get(116)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","126" );
      ((Element)v.get(116)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:116   */

      /* Empieza nodo:127 / Elemento padre: 95   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(127)).setAttribute("alto","22" );
      ((Element)v.get(127)).setAttribute("accion","" );
      ((Element)v.get(127)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(127)).setAttribute("formaEnvio","xml" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(127)).setAttribute("maxSel","-1" );
      ((Element)v.get(127)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(127)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(127)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(127)).setAttribute("onLoad","" );
      ((Element)v.get(127)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(95)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("tipo","texto" );
      ((Element)v.get(135)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:127   */

      /* Empieza nodo:138 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 95   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(139)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(139)).setAttribute("ancho","569" );
      ((Element)v.get(139)).setAttribute("sep","$" );
      ((Element)v.get(139)).setAttribute("x","12" );
      ((Element)v.get(139)).setAttribute("class","botonera" );
      ((Element)v.get(139)).setAttribute("y","416" );
      ((Element)v.get(139)).setAttribute("control","|" );
      ((Element)v.get(139)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(139)).setAttribute("rowset","" );
      ((Element)v.get(139)).setAttribute("cargainicial","N" );
      ((Element)v.get(139)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'prueba(ultima, rowset)')" );
      ((Element)v.get(95)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","ret1" );
      ((Element)v.get(140)).setAttribute("x","37" );
      ((Element)v.get(140)).setAttribute("y","420" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("img","retroceder_on" );
      ((Element)v.get(140)).setAttribute("tipo","0" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("alt","" );
      ((Element)v.get(140)).setAttribute("codigo","" );
      ((Element)v.get(140)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 139   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","ava1" );
      ((Element)v.get(141)).setAttribute("x","52" );
      ((Element)v.get(141)).setAttribute("y","420" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("img","avanzar_on" );
      ((Element)v.get(141)).setAttribute("tipo","0" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("alt","" );
      ((Element)v.get(141)).setAttribute("codigo","" );
      ((Element)v.get(141)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(139)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:139   */
      /* Termina nodo:95   */

      /* Empieza nodo:142 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","primera1" );
      ((Element)v.get(142)).setAttribute("x","20" );
      ((Element)v.get(142)).setAttribute("y","420" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
      ((Element)v.get(142)).setAttribute("img","primera_on" );
      ((Element)v.get(142)).setAttribute("tipo","-2" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("alt","" );
      ((Element)v.get(142)).setAttribute("codigo","" );
      ((Element)v.get(142)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(143)).setAttribute("nombre","separa" );
      ((Element)v.get(143)).setAttribute("x","59" );
      ((Element)v.get(143)).setAttribute("y","416" );
      ((Element)v.get(143)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).setAttribute("img","separa_base" );
      ((Element)v.get(143)).setAttribute("tipo","0" );
      ((Element)v.get(143)).setAttribute("estado","false" );
      ((Element)v.get(143)).setAttribute("alt","" );
      ((Element)v.get(143)).setAttribute("codigo","" );
      ((Element)v.get(143)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","Modificar" );
      ((Element)v.get(144)).setAttribute("x","80" );
      ((Element)v.get(144)).setAttribute("y","417" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("tipo","html" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("cod","2" );
      ((Element)v.get(144)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","Detalle" );
      ((Element)v.get(145)).setAttribute("x","80" );
      ((Element)v.get(145)).setAttribute("y","417" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("tipo","html" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("cod","3" );
      ((Element)v.get(145)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(6)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(146)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(146)).setAttribute("alto","12" );
      ((Element)v.get(146)).setAttribute("ancho","50" );
      ((Element)v.get(146)).setAttribute("colorf","" );
      ((Element)v.get(146)).setAttribute("borde","0" );
      ((Element)v.get(146)).setAttribute("imagenf","" );
      ((Element)v.get(146)).setAttribute("repeat","" );
      ((Element)v.get(146)).setAttribute("padding","" );
      ((Element)v.get(146)).setAttribute("visibilidad","visible" );
      ((Element)v.get(146)).setAttribute("contravsb","" );
      ((Element)v.get(146)).setAttribute("x","0" );
      ((Element)v.get(146)).setAttribute("y","439" );
      ((Element)v.get(146)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:6   */


   }

}
