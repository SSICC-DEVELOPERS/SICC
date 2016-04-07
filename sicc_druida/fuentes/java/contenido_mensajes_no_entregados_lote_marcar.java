
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_mensajes_no_entregados_lote_marcar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_mensajes_no_entregados_lote_marcar" );
      ((Element)v.get(0)).setAttribute("cod","0266" );
      ((Element)v.get(0)).setAttribute("titulo","Marcar Mensajes No Entregados por Lote" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Marcar Mensajes No Entregados por Lote" );
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
      v.add(doc.createTextNode("\r     \r      \r	function onLoadPag()   \r	{\r	    DrdEnsanchaConMargenDcho('listado1',12);\r      configurarMenuSecundario(\"frmFormulario\");                      \r     DrdEnsanchaConMargenDcho('listado1',12);                    \r     if (get('frmFormulario.ListadoDisponible') == \"SI\") {   \r              mostrarListaEditable();   \r     } else {    \r              ocultarListaEditable();   \r     }\r     posicionarCombo();\r     eval (ON_RSZ);  \r	}\r  \r  \r  function ocultarListaEditable() {   \r      document.all[\"Cplistado1\"].style.visibility='hidden';\r	    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r\r	    document.all[\"primera1Div\"].style.visibility='hidden';\r	    document.all[\"ret1Div\"].style.visibility='hidden';\r	    document.all[\"ava1Div\"].style.visibility='hidden';\r	    document.all[\"separaDiv\"].style.visibility='hidden';   \r          }   \r    \r    \r  function mostrarListaEditable() {   \r      document.all[\"Cplistado1\"].style.visibility='';\r	    document.all[\"CpLin1listado1\"].style.visibility='';\r	    document.all[\"CpLin2listado1\"].style.visibility='';\r	    document.all[\"CpLin3listado1\"].style.visibility='';\r	    document.all[\"CpLin4listado1\"].style.visibility='';\r\r	    document.all[\"primera1Div\"].style.visibility='';\r	    document.all[\"ret1Div\"].style.visibility='';\r	    document.all[\"ava1Div\"].style.visibility='';\r	    document.all[\"separaDiv\"].style.visibility='';   \r          } \r  function onClickGuardar(){\r      var valoresEditados = tomaValoresEditadosLista();\r            set('frmFormulario.conectorAction', 'LPMarcarMensajesNoEnviadosLotes');\r      set('frmFormulario.valoresEditadosLista', valoresEditados);\r      set('frmFormulario.accion', 'guardar');\r      enviaSICC('frmFormulario');\r      \r  }\r  \r  function onClickBuscar(){\r      set('frmFormulario.oidLote', get('frmFormulario.cbIdentificadorLote')); \r      set('frmFormulario.conectorAction', 'LPMarcarMensajesNoEnviadosLotes');\r      set('frmFormulario.accion', 'buscar');\r      enviaSICC('frmFormulario');\r      \r  }\r  \r  function posicionarCombo() {    \r                   var iSeleccionadoM = new Array();    \r                   iSeleccionadoM[0] = get('frmFormulario.oidLote');    \r                   set('frmFormulario.cbIdentificadorLote',iSeleccionadoM); \r\r          }   \r   \r  function tomaValoresEditadosLista(){\r  valoresConcatenados = \"\";\r  listado1.save();\r  var lista = listado1.datos;\r  var filas = listado1.datos.length;\r  var columnas = lista[0].length;\r  \r  for ( var i = 0; i < filas; i++) {\r    for(var j=0;j<columnas;j++){\r      if(valoresConcatenados==\"\" || j==0) {\r                valoresConcatenados = valoresConcatenados + lista[i][j];\r            }\r            else {\r            	  valoresConcatenados = valoresConcatenados +\"^\"+ lista[i][j];\r            }\r      }\r      if (i!=filas-1){\r      valoresConcatenados = valoresConcatenados + \"|\";}\r      \r    }\r    return valoresConcatenados;\r  }\r  \r  function fGuardar(){\r  onClickGuardar();\r  }\r  \rfunction modificaFormatoFecha(formatoFechaUsuario){\rif(formatoFechaUsuario==null){\r	return;}\r\rvar arrFormatoFecha = null;\rvar strFecha = formatoFechaUsuario.replace('-', '/');\r\rarrFormatoFecha = strFecha.split(\"/\");\r\rfor(var i=0;i<3;i++){\rif(arrFormatoFecha[i].charAt(0)==\"d\" || arrFormatoFecha[i].charAt(0)==\"D\"){arrFormatoFecha[i]=\"D\";} \r	else \rif(arrFormatoFecha[i].charAt(0)==\"m\" || arrFormatoFecha[i].charAt(0)==\"M\"){arrFormatoFecha[i]=\"M\";}\r		else \rif(arrFormatoFecha[i].charAt(0)==\"y\" || arrFormatoFecha[i].charAt(0)==\"Y\"){arrFormatoFecha[i]=\"Y\";}\r			else \rif(arrFormatoFecha[i].charAt(0)==\"a\" || arrFormatoFecha[i].charAt(0)==\"A\"){arrFormatoFecha[i]=\"y\";}\r}\rvar a= arrFormatoFecha[0];\rvar b= arrFormatoFecha[1];\rvar c= arrFormatoFecha[2];\rreturn a+\"/\"+b+\"/\"+c;\r}\r\rfunction obtenerPosicionListaEditable(clave, lista){\r  this.posicion = 0;\r  if (lista.codSeleccionados().length > 0){\r     for(var k=0;k<lista.datos.length;k++) {\r           if (lista.datos[k][0] == clave) {\r              posicion=k;\r              break;\r           }\r     }         \r     return posicion;\r   }\r}\r\rfunction verificaFecha(){\rvar formatoFechaUsuario = get('frmFormulario.hFormatoFechaPais');\rvar formato = modificaFormatoFecha(formatoFechaUsuario);\rvar laFecha = window.event.srcElement;\rvar valorFecha = laFecha.value;\rvar msgValidaFecha = ValidaFecha(valorFecha,formato,valorFecha,valorFecha);\rif (msgValidaFecha != 'OK') {\revent.returnValue=false;\revent.cancelBubble=true;   \rcdos_mostrarAlert(msgValidaFecha);}\r\r}\r\r  \r  \r  \r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","LPMarcarMensajesNoEnviadosLotes" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidPais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidLote" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","valoresEditadosLista" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","ListadoDisponible" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errorValidaDatos" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","msgValidaDatos" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(19)).setAttribute("x","0" );
      ((Element)v.get(19)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(34)).setAttribute("cod","0075" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","504" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("colspan","3" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblIdentificadorLote" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","893" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:42   */

      /* Empieza nodo:49 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(53)).setAttribute("nombre","cbIdentificadorLote" );
      ((Element)v.get(53)).setAttribute("id","datosCampos" );
      ((Element)v.get(53)).setAttribute("size","1" );
      ((Element)v.get(53)).setAttribute("multiple","N" );
      ((Element)v.get(53)).setAttribute("req","N" );
      ((Element)v.get(53)).setAttribute("valorinicial","" );
      ((Element)v.get(53)).setAttribute("textoinicial","" );
      ((Element)v.get(53)).setAttribute("ontab","document.all.btnBuscar.focus();" );
      ((Element)v.get(53)).setAttribute("onshtab","document.all.btnBuscar.focus();" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:49   */

      /* Empieza nodo:57 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","3" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","7" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:60 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:28   */

      /* Empieza nodo:62 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("class","botonera" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(70)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(70)).setAttribute("ID","botonContenido" );
      ((Element)v.get(70)).setAttribute("tipo","html" );
      ((Element)v.get(70)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(70)).setAttribute("estado","false" );
      ((Element)v.get(70)).setAttribute("cod","1" );
      ((Element)v.get(70)).setAttribute("ontab","focaliza('frmFormulario.cbIdentificadorLote');" );
      ((Element)v.get(70)).setAttribute("onshtab","focaliza('frmFormulario.cbIdentificadorLote');" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:62   */

      /* Empieza nodo:73 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","756" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","1" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:80 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(80)).setAttribute("nombre","listado1" );
      ((Element)v.get(80)).setAttribute("ancho","507" );
      ((Element)v.get(80)).setAttribute("alto","291" );
      ((Element)v.get(80)).setAttribute("x","12" );
      ((Element)v.get(80)).setAttribute("y","122" );
      ((Element)v.get(80)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(80)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(81)).setAttribute("precarga","S" );
      ((Element)v.get(81)).setAttribute("conROver","S" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(82)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(82)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(82)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(82)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(83)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(83)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(83)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(83)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(84)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(84)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(86)).setAttribute("borde","1" );
      ((Element)v.get(86)).setAttribute("horizDatos","1" );
      ((Element)v.get(86)).setAttribute("horizCabecera","1" );
      ((Element)v.get(86)).setAttribute("vertical","1" );
      ((Element)v.get(86)).setAttribute("horizTitulo","1" );
      ((Element)v.get(86)).setAttribute("horizBase","1" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 85   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(87)).setAttribute("borde","#999999" );
      ((Element)v.get(87)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(87)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(87)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(87)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(87)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(87)).setAttribute("horizBase","#999999" );
      ((Element)v.get(85)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 80   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(88)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(88)).setAttribute("alto","22" );
      ((Element)v.get(88)).setAttribute("imgFondo","" );
      ((Element)v.get(88)).setAttribute("cod","00135" );
      ((Element)v.get(88)).setAttribute("ID","datosTitle" );
      ((Element)v.get(80)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(89)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(89)).setAttribute("alto","22" );
      ((Element)v.get(89)).setAttribute("imgFondo","" );
      ((Element)v.get(80)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 80   */
      v.add(doc.createElement("COLUMNAS"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(90)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(90)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(90)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(90)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(90)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(80)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","120" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","100" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","100" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","150" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","100" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:90   */

      /* Empieza nodo:96 / Elemento padre: 80   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(96)).setAttribute("alto","20" );
      ((Element)v.get(96)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(80)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("cod","818" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("colFondo","" );
      ((Element)v.get(98)).setAttribute("ID","EstCab" );
      ((Element)v.get(98)).setAttribute("cod","30" );
      ((Element)v.get(96)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("colFondo","" );
      ((Element)v.get(99)).setAttribute("ID","EstCab" );
      ((Element)v.get(99)).setAttribute("cod","263" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("colFondo","" );
      ((Element)v.get(100)).setAttribute("ID","EstCab" );
      ((Element)v.get(100)).setAttribute("cod","874" );
      ((Element)v.get(96)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","169" );
      ((Element)v.get(96)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:96   */

      /* Empieza nodo:102 / Elemento padre: 80   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(102)).setAttribute("alto","22" );
      ((Element)v.get(102)).setAttribute("accion","" );
      ((Element)v.get(102)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(102)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(102)).setAttribute("maxSel","-1" );
      ((Element)v.get(102)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(102)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(102)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(102)).setAttribute("onLoad","" );
      ((Element)v.get(102)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(80)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("tipo","texto" );
      ((Element)v.get(103)).setAttribute("ID","EstDat" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("tipo","texto" );
      ((Element)v.get(104)).setAttribute("ID","EstDat2" );
      ((Element)v.get(102)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("tipo","texto" );
      ((Element)v.get(105)).setAttribute("ID","EstDat" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(106)).setAttribute("nombre","Texto1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(106)).setAttribute("size","11" );
      ((Element)v.get(106)).setAttribute("max","10" );
      ((Element)v.get(106)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(106)).setAttribute("ID","EstDat2" );
      ((Element)v.get(106)).setAttribute("onchange","verificaFecha();" );
      ((Element)v.get(102)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("tipo","areatexto" );
      ((Element)v.get(107)).setAttribute("nombre","AreaTxt1" );
      ((Element)v.get(107)).setAttribute("IDOBJ","EstCajaDatForm2" );
      ((Element)v.get(107)).setAttribute("rows","2" );
      ((Element)v.get(107)).setAttribute("cols","50" );
      ((Element)v.get(107)).setAttribute("ID","EstDat" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:102   */

      /* Empieza nodo:108 / Elemento padre: 80   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(80)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(109)).setAttribute("ID","1" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(110)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(110)).setAttribute("TIPO","STRING" );
      ((Element)v.get(110)).setAttribute("VALOR","COD0" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 109   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(111)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(111)).setAttribute("TIPO","STRING" );
      ((Element)v.get(111)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(109)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(112)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(112)).setAttribute("TIPO","STRING" );
      ((Element)v.get(112)).setAttribute("VALOR","xxxxx1" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 109   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(113)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(113)).setAttribute("TIPO","STRING" );
      ((Element)v.get(113)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(109)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(114)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(114)).setAttribute("TIPO","STRING" );
      ((Element)v.get(114)).setAttribute("VALOR","" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 109   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(115)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(115)).setAttribute("TIPO","STRING" );
      ((Element)v.get(115)).setAttribute("VALOR","" );
      ((Element)v.get(109)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:109   */

      /* Empieza nodo:116 / Elemento padre: 108   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(116)).setAttribute("ID","2" );
      ((Element)v.get(108)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(117)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(117)).setAttribute("TIPO","STRING" );
      ((Element)v.get(117)).setAttribute("VALOR","COD1" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(118)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(118)).setAttribute("TIPO","STRING" );
      ((Element)v.get(118)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(119)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(119)).setAttribute("TIPO","STRING" );
      ((Element)v.get(119)).setAttribute("VALOR","xxxxx1" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(120)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(120)).setAttribute("TIPO","STRING" );
      ((Element)v.get(120)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(116)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(121)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(121)).setAttribute("TIPO","STRING" );
      ((Element)v.get(121)).setAttribute("VALOR","" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 116   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(122)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(122)).setAttribute("TIPO","STRING" );
      ((Element)v.get(122)).setAttribute("VALOR","" );
      ((Element)v.get(116)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:116   */

      /* Empieza nodo:123 / Elemento padre: 108   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(123)).setAttribute("ID","3" );
      ((Element)v.get(108)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(124)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(124)).setAttribute("TIPO","STRING" );
      ((Element)v.get(124)).setAttribute("VALOR","COD2" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 123   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(125)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(125)).setAttribute("TIPO","STRING" );
      ((Element)v.get(125)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(123)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(126)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(126)).setAttribute("TIPO","STRING" );
      ((Element)v.get(126)).setAttribute("VALOR","xxxxx1" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 123   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(127)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(127)).setAttribute("TIPO","STRING" );
      ((Element)v.get(127)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(123)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(128)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(128)).setAttribute("TIPO","STRING" );
      ((Element)v.get(128)).setAttribute("VALOR","" );
      ((Element)v.get(123)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 123   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(129)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(129)).setAttribute("TIPO","STRING" );
      ((Element)v.get(129)).setAttribute("VALOR","" );
      ((Element)v.get(123)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:123   */

      /* Empieza nodo:130 / Elemento padre: 108   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(130)).setAttribute("ID","1" );
      ((Element)v.get(108)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(131)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(131)).setAttribute("TIPO","STRING" );
      ((Element)v.get(131)).setAttribute("VALOR","COD3" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(132)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(132)).setAttribute("TIPO","STRING" );
      ((Element)v.get(132)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(130)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(133)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(133)).setAttribute("TIPO","STRING" );
      ((Element)v.get(133)).setAttribute("VALOR","xxxxx1" );
      ((Element)v.get(130)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(134)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(134)).setAttribute("TIPO","STRING" );
      ((Element)v.get(134)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(130)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(135)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(135)).setAttribute("TIPO","STRING" );
      ((Element)v.get(135)).setAttribute("VALOR","" );
      ((Element)v.get(130)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(136)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(136)).setAttribute("TIPO","STRING" );
      ((Element)v.get(136)).setAttribute("VALOR","" );
      ((Element)v.get(130)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:130   */

      /* Empieza nodo:137 / Elemento padre: 108   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(137)).setAttribute("ID","2" );
      ((Element)v.get(108)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(138)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(138)).setAttribute("TIPO","STRING" );
      ((Element)v.get(138)).setAttribute("VALOR","COD4" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 137   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(139)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(139)).setAttribute("TIPO","STRING" );
      ((Element)v.get(139)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(137)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(140)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(140)).setAttribute("TIPO","STRING" );
      ((Element)v.get(140)).setAttribute("VALOR","xxxxx1" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 137   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(141)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(141)).setAttribute("TIPO","STRING" );
      ((Element)v.get(141)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(137)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 137   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(142)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(142)).setAttribute("TIPO","STRING" );
      ((Element)v.get(142)).setAttribute("VALOR","" );
      ((Element)v.get(137)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 137   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(143)).setAttribute("TIPO","STRING" );
      ((Element)v.get(143)).setAttribute("VALOR","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(137)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:137   */
      /* Termina nodo:108   */

      /* Empieza nodo:144 / Elemento padre: 80   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(144)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(144)).setAttribute("ancho","507" );
      ((Element)v.get(144)).setAttribute("sep","$" );
      ((Element)v.get(144)).setAttribute("x","12" );
      ((Element)v.get(144)).setAttribute("class","botonera" );
      ((Element)v.get(144)).setAttribute("y","390" );
      ((Element)v.get(144)).setAttribute("control","|" );
      ((Element)v.get(144)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(144)).setAttribute("rowset","" );
      ((Element)v.get(144)).setAttribute("cargainicial","N" );
      ((Element)v.get(80)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","ret1" );
      ((Element)v.get(145)).setAttribute("x","37" );
      ((Element)v.get(145)).setAttribute("y","394" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("img","retroceder_on" );
      ((Element)v.get(145)).setAttribute("tipo","0" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("alt","" );
      ((Element)v.get(145)).setAttribute("codigo","" );
      ((Element)v.get(145)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","ava1" );
      ((Element)v.get(146)).setAttribute("x","52" );
      ((Element)v.get(146)).setAttribute("y","394" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("img","avanzar_on" );
      ((Element)v.get(146)).setAttribute("tipo","0" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("alt","" );
      ((Element)v.get(146)).setAttribute("codigo","" );
      ((Element)v.get(146)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(144)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:144   */
      /* Termina nodo:80   */

      /* Empieza nodo:147 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","primera1" );
      ((Element)v.get(147)).setAttribute("x","20" );
      ((Element)v.get(147)).setAttribute("y","394" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("img","primera_on" );
      ((Element)v.get(147)).setAttribute("tipo","-2" );
      ((Element)v.get(147)).setAttribute("estado","false" );
      ((Element)v.get(147)).setAttribute("alt","" );
      ((Element)v.get(147)).setAttribute("codigo","" );
      ((Element)v.get(147)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(148)).setAttribute("nombre","separa" );
      ((Element)v.get(148)).setAttribute("x","59" );
      ((Element)v.get(148)).setAttribute("y","390" );
      ((Element)v.get(148)).setAttribute("ID","botonContenido" );
      ((Element)v.get(148)).setAttribute("img","separa_base" );
      ((Element)v.get(148)).setAttribute("tipo","0" );
      ((Element)v.get(148)).setAttribute("estado","false" );
      ((Element)v.get(148)).setAttribute("alt","" );
      ((Element)v.get(148)).setAttribute("codigo","" );
      ((Element)v.get(148)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(149)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(149)).setAttribute("alto","12" );
      ((Element)v.get(149)).setAttribute("ancho","50" );
      ((Element)v.get(149)).setAttribute("colorf","" );
      ((Element)v.get(149)).setAttribute("borde","0" );
      ((Element)v.get(149)).setAttribute("imagenf","" );
      ((Element)v.get(149)).setAttribute("repeat","" );
      ((Element)v.get(149)).setAttribute("padding","" );
      ((Element)v.get(149)).setAttribute("visibilidad","visible" );
      ((Element)v.get(149)).setAttribute("contravsb","" );
      ((Element)v.get(149)).setAttribute("x","0" );
      ((Element)v.get(149)).setAttribute("y","418" );
      ((Element)v.get(149)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:6   */


   }

}
