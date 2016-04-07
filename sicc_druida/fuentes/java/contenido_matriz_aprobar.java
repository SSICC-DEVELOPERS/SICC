
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_aprobar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_aprobar" );
      ((Element)v.get(0)).setAttribute("cod","0220" );
      ((Element)v.get(0)).setAttribute("titulo","Aprobar Matriz" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()  {\r    configurarMenuSecundario(\"formulario\");\r    fMostrarMensajeError();\r    if ( get('formulario.hLbldtIndicadorActiva') == 'true' )  {\r      var si = GestionarMensaje(84);\r      txt_to('lbldtIndicadorActiva',si);\r    }\r    else {\r      var no = GestionarMensaje(86);\r      txt_to('lbldtIndicadorActiva',no);\r    }\r    focaliza('formulario.rbAprobar');\r    set('formulario.rbAprobar','N');\r\r    DrdEnsanchaConMargenDcho('listado1',12);\r     document.all[\"Cplistado1\"].style.visibility='visible';\r    document.all[\"CpLin1listado1\"].style.visibility='visible';\r    document.all[\"CpLin2listado1\"].style.visibility='visible';\r    document.all[\"CpLin3listado1\"].style.visibility='visible';\r    document.all[\"CpLin4listado1\"].style.visibility='visible';\r    document.all[\"primera1Div\"].style.visibility='visible';\r    document.all[\"ret1Div\"].style.visibility='visible';\r    document.all[\"ava1Div\"].style.visibility='visible';\r    document.all[\"separaDiv\"].style.visibility='visible';\r    eval (ON_RSZ);  \r\r   }\r\r\r  function fGuardar()  {\r    accionGuardar();\r  }\r\r  function accionGuardar()  {\r            set('formulario.accion','guardar');\r    enviaSICC('formulario');\r  }\r  function fPostGuardar()  {\r    btnProxy(1,'0');\r        GestionarMensaje('GEN-0206');\r		eval(\"formulario.oculto='N'\");\r    fSalir();\r\r\r  }\r\r\r  function fErrorAlGuardar()  {\r    document.all.tags(\"INPUT\")[\"rbAprobar\"][0].focus();\r  }\r  function focalizarOnShTabRBA()  {\r    document.all.tags(\"INPUT\")[\"rbAprobar\"][0].focus();\r  }\r\r  function focalizarOnTabRBA()  {\r      document.all.tags(\"INPUT\")[\"rbAprobar\"][1].focus();\r  }\r\r\r\r\r\r\r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","LPAprobarDescuento" );
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
      ((Element)v.get(9)).setAttribute("nombre","hOidDescuentoSel" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hLbldtIndicadorActiva" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(13)).setAttribute("width","100%" );
      ((Element)v.get(13)).setAttribute("border","0" );
      ((Element)v.get(13)).setAttribute("cellspacing","0" );
      ((Element)v.get(13)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).setAttribute("width","12" );
      ((Element)v.get(15)).setAttribute("align","center" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("height","12" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","750" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","1" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */
      /* Termina nodo:14   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(26)).setAttribute("class","legend" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(27)).setAttribute("nombre","lblDatosDescuento" );
      ((Element)v.get(27)).setAttribute("alto","13" );
      ((Element)v.get(27)).setAttribute("filas","1" );
      ((Element)v.get(27)).setAttribute("id","legend" );
      ((Element)v.get(27)).setAttribute("cod","0092" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","100%" );
      ((Element)v.get(28)).setAttribute("border","0" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("cellpadding","0" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","646" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("align","left" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("colspan","4" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","8" );
      ((Element)v.get(34)).setAttribute("height","8" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:35 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","8" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("id","datosTitle" );
      ((Element)v.get(39)).setAttribute("cod","9" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","25" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblPeridodesde" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","1175" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","25" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblPeridoHasta" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","1176" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblIndicadorActiva" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","904" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblAprobar" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","1169" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(35)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:35   */

      /* Empieza nodo:58 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(58));

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
      ((Element)v.get(62)).setAttribute("nombre","lbldtDescripcion" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("valor","" );
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
      ((Element)v.get(66)).setAttribute("nombre","lbldtPeriodoDesde" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("valor","" );
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
      ((Element)v.get(70)).setAttribute("nombre","lbldtPeriodoHasta" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lbldtIndicadorActiva" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("class","datosCampos" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(81)).setAttribute("nombre","rbAprobar" );
      ((Element)v.get(81)).setAttribute("tipo","H" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("onshtab","focalizarOnShTabRBA();" );
      ((Element)v.get(81)).setAttribute("ontab","focalizarOnTabRBA();" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(82)).setAttribute("valor","S" );
      ((Element)v.get(82)).setAttribute("check","N" );
      ((Element)v.get(82)).setAttribute("onfocus","" );
      ((Element)v.get(82)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).setAttribute("cod","117" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Elemento padre:82 / Elemento actual: 83   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(82)).appendChild((Text)v.get(83));

      /* Termina nodo Texto:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(84)).setAttribute("valor","N" );
      ((Element)v.get(84)).setAttribute("check","N" );
      ((Element)v.get(84)).setAttribute("onfocus","" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("cod","87" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Elemento padre:84 / Elemento actual: 85   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(84)).appendChild((Text)v.get(85));

      /* Termina nodo Texto:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:86 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(58)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:58   */

      /* Empieza nodo:88 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("colspan","4" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:91 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:21   */

      /* Empieza nodo:93 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(94)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","12" );
      ((Element)v.get(95)).setAttribute("height","12" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","756" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","12" );
      ((Element)v.get(93)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("height","1" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:93   */
      /* Termina nodo:13   */

      /* Empieza nodo:100 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(100)).setAttribute("nombre","listado1" );
      ((Element)v.get(100)).setAttribute("ancho","650" );
      ((Element)v.get(100)).setAttribute("alto","301" );
      ((Element)v.get(100)).setAttribute("x","12" );
      ((Element)v.get(100)).setAttribute("y","99" );
      ((Element)v.get(100)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(100)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(101)).setAttribute("precarga","S" );
      ((Element)v.get(101)).setAttribute("conROver","S" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(102)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(102)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(102)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(102)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 101   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(103)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(103)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(103)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(103)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(101)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(104)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(104)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:101   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(106)).setAttribute("borde","1" );
      ((Element)v.get(106)).setAttribute("horizDatos","1" );
      ((Element)v.get(106)).setAttribute("horizCabecera","1" );
      ((Element)v.get(106)).setAttribute("vertical","1" );
      ((Element)v.get(106)).setAttribute("horizTitulo","1" );
      ((Element)v.get(106)).setAttribute("horizBase","1" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 105   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(107)).setAttribute("borde","#999999" );
      ((Element)v.get(107)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(107)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(107)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(107)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(107)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(107)).setAttribute("horizBase","#999999" );
      ((Element)v.get(105)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:105   */

      /* Empieza nodo:108 / Elemento padre: 100   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(108)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(108)).setAttribute("alto","22" );
      ((Element)v.get(108)).setAttribute("imgFondo","" );
      ((Element)v.get(108)).setAttribute("cod","0093" );
      ((Element)v.get(108)).setAttribute("ID","datosTitle" );
      ((Element)v.get(100)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(109)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(109)).setAttribute("alto","22" );
      ((Element)v.get(109)).setAttribute("imgFondo","" );
      ((Element)v.get(100)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 100   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(110)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(110)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(110)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(110)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(110)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(110)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(100)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","500" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 100   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(112)).setAttribute("alto","20" );
      ((Element)v.get(112)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(112)).setAttribute("imgFondo","" );
      ((Element)v.get(112)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(100)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("cod","393" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Elemento padre:113 / Elemento actual: 114   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(113)).appendChild((Text)v.get(114));

      /* Termina nodo Texto:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 100   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(115)).setAttribute("alto","22" );
      ((Element)v.get(115)).setAttribute("accion","" );
      ((Element)v.get(115)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(115)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(115)).setAttribute("maxSel","-1" );
      ((Element)v.get(115)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(115)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(115)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(115)).setAttribute("onLoad","" );
      ((Element)v.get(115)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(100)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 100   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(100)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 100   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(118)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(118)).setAttribute("ancho","650" );
      ((Element)v.get(118)).setAttribute("sep","$" );
      ((Element)v.get(118)).setAttribute("x","12" );
      ((Element)v.get(118)).setAttribute("class","botonera" );
      ((Element)v.get(118)).setAttribute("y","377" );
      ((Element)v.get(118)).setAttribute("control","|" );
      ((Element)v.get(118)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(118)).setAttribute("rowset","" );
      ((Element)v.get(118)).setAttribute("cargainicial","N" );
      ((Element)v.get(100)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(119)).setAttribute("nombre","ret1" );
      ((Element)v.get(119)).setAttribute("x","37" );
      ((Element)v.get(119)).setAttribute("y","381" );
      ((Element)v.get(119)).setAttribute("ID","botonContenido" );
      ((Element)v.get(119)).setAttribute("img","retroceder_on" );
      ((Element)v.get(119)).setAttribute("tipo","0" );
      ((Element)v.get(119)).setAttribute("estado","false" );
      ((Element)v.get(119)).setAttribute("alt","" );
      ((Element)v.get(119)).setAttribute("codigo","" );
      ((Element)v.get(119)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 118   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(120)).setAttribute("nombre","ava1" );
      ((Element)v.get(120)).setAttribute("x","52" );
      ((Element)v.get(120)).setAttribute("y","381" );
      ((Element)v.get(120)).setAttribute("ID","botonContenido" );
      ((Element)v.get(120)).setAttribute("img","avanzar_on" );
      ((Element)v.get(120)).setAttribute("tipo","0" );
      ((Element)v.get(120)).setAttribute("estado","false" );
      ((Element)v.get(120)).setAttribute("alt","" );
      ((Element)v.get(120)).setAttribute("codigo","" );
      ((Element)v.get(120)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(118)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:118   */
      /* Termina nodo:100   */

      /* Empieza nodo:121 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(121)).setAttribute("nombre","primera1" );
      ((Element)v.get(121)).setAttribute("x","20" );
      ((Element)v.get(121)).setAttribute("y","381" );
      ((Element)v.get(121)).setAttribute("ID","botonContenido" );
      ((Element)v.get(121)).setAttribute("img","primera_on" );
      ((Element)v.get(121)).setAttribute("tipo","-2" );
      ((Element)v.get(121)).setAttribute("estado","false" );
      ((Element)v.get(121)).setAttribute("alt","" );
      ((Element)v.get(121)).setAttribute("codigo","" );
      ((Element)v.get(121)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(122)).setAttribute("nombre","separa" );
      ((Element)v.get(122)).setAttribute("x","59" );
      ((Element)v.get(122)).setAttribute("y","377" );
      ((Element)v.get(122)).setAttribute("ID","botonContenido" );
      ((Element)v.get(122)).setAttribute("img","separa_base" );
      ((Element)v.get(122)).setAttribute("tipo","0" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(122)).setAttribute("estado","false" );
      ((Element)v.get(122)).setAttribute("alt","" );
      ((Element)v.get(122)).setAttribute("codigo","" );
      ((Element)v.get(122)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(123)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(123)).setAttribute("alto","12" );
      ((Element)v.get(123)).setAttribute("ancho","100%" );
      ((Element)v.get(123)).setAttribute("colorf","" );
      ((Element)v.get(123)).setAttribute("borde","0" );
      ((Element)v.get(123)).setAttribute("imagenf","" );
      ((Element)v.get(123)).setAttribute("repeat","" );
      ((Element)v.get(123)).setAttribute("padding","" );
      ((Element)v.get(123)).setAttribute("visibilidad","visible" );
      ((Element)v.get(123)).setAttribute("contravsb","" );
      ((Element)v.get(123)).setAttribute("x","0" );
      ((Element)v.get(123)).setAttribute("y","400" );
      ((Element)v.get(123)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:6   */


   }

}
