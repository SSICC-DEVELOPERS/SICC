
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_responsables_unidades_asignar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_responsables_unidades_asignar" );
      ((Element)v.get(0)).setAttribute("cod","0944" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separaDiv {visibility:hidden;}\r#CplistaResultados{visibility:hidden;}\r#CpLin1listaResultados{visibility:hidden;}\r#CpLin2listaResultados{visibility:hidden;}\r#CpLin3listaResultados{visibility:hidden;}\r#CpLin4listaResultados{visibility:hidden;}\r\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_responsables_unidades_asignar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","6" );
      ((Element)v.get(8)).setAttribute("group","B" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","7" );
      ((Element)v.get(9)).setAttribute("group","B" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtCodClienteResponsable" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","412" );
      ((Element)v.get(10)).setAttribute("group","A" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:7   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","frm" );
      ((Element)v.get(11)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
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
      ((Element)v.get(19)).setAttribute("nombre","cteSubgerencia" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","cteRegion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","cteZona" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","cteSeccion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","indUA" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","longitudCodigoCliente" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidUA" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","subgRegZonSecc" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hcoddUA" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hMarca" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hCanal" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidOidClienteBusquedaRapida" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidCodClienteTemp" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(32)).setAttribute("nombre","capa" );
      ((Element)v.get(32)).setAttribute("x","0" );
      ((Element)v.get(32)).setAttribute("y","0" );
      ((Element)v.get(32)).setAttribute("ancho","100%" );
      ((Element)v.get(32)).setAttribute("alto","100%" );
      ((Element)v.get(11)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("height","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","750" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("height","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:34   */

      /* Empieza nodo:41 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("legend"));
      ((Element)v.get(46)).setAttribute("class","legend" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("cod","0075" );
      ((Element)v.get(47)).setAttribute("id","legend" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","600" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("align","left" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("colspan","4" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","6" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","7" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:55   */

      /* Empieza nodo:66 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(70)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("size","1" );
      ((Element)v.get(70)).setAttribute("multiple","N" );
      ((Element)v.get(70)).setAttribute("req","S" );
      ((Element)v.get(70)).setAttribute("valorinicial","" );
      ((Element)v.get(70)).setAttribute("onshtab","focalizarAnteriorMarca()" );
      ((Element)v.get(70)).setAttribute("textoinicial","" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:72 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(75)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("size","1" );
      ((Element)v.get(75)).setAttribute("multiple","N" );
      ((Element)v.get(75)).setAttribute("req","S" );
      ((Element)v.get(75)).setAttribute("valorinicial","" );
      ((Element)v.get(75)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:77 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(66)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:66   */

      /* Empieza nodo:79 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("colspan","4" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:82 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","600" );
      ((Element)v.get(84)).setAttribute("border","0" );
      ((Element)v.get(84)).setAttribute("align","left" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("cellpadding","0" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("class","datosCampos" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(89)).setAttribute("nombre","rbResponsable" );
      ((Element)v.get(89)).setAttribute("tipo","H" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(90)).setAttribute("valor","1" );
      ((Element)v.get(90)).setAttribute("check","S" );
      ((Element)v.get(90)).setAttribute("onfocus","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","992" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("onclick","codZonaOnOff()" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("class","datosCampos" );
      ((Element)v.get(85)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(94)).setAttribute("nombre","rbResponsable" );
      ((Element)v.get(94)).setAttribute("tipo","H" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(95)).setAttribute("valor","2" );
      ((Element)v.get(95)).setAttribute("check","N" );
      ((Element)v.get(95)).setAttribute("onfocus","" );
      ((Element)v.get(95)).setAttribute("id","datosTitle" );
      ((Element)v.get(95)).setAttribute("cod","109" );
      ((Element)v.get(95)).setAttribute("onclick","codZonaOnOff()" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("class","datosCampos" );
      ((Element)v.get(85)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(99)).setAttribute("nombre","rbResponsable" );
      ((Element)v.get(99)).setAttribute("tipo","H" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(100)).setAttribute("valor","3" );
      ((Element)v.get(100)).setAttribute("check","N" );
      ((Element)v.get(100)).setAttribute("onfocus","" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","143" );
      ((Element)v.get(100)).setAttribute("onclick","codZonaOnOff()" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("class","datosCampos" );
      ((Element)v.get(85)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(104)).setAttribute("nombre","rbResponsable" );
      ((Element)v.get(104)).setAttribute("tipo","H" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(105)).setAttribute("valor","4" );
      ((Element)v.get(105)).setAttribute("check","N" );
      ((Element)v.get(105)).setAttribute("onfocus","" );
      ((Element)v.get(105)).setAttribute("id","datosTitle" );
      ((Element)v.get(105)).setAttribute("cod","112" );
      ((Element)v.get(105)).setAttribute("onclick","codZonaOnOff()" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:106 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:85   */

      /* Empieza nodo:108 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("colspan","4" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:111 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(48)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","600" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("align","left" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("colspan","4" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblCodZona" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","datosTitle" );
      ((Element)v.get(121)).setAttribute("cod","1292" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(117)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:117   */

      /* Empieza nodo:124 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(128)).setAttribute("nombre","txtCodZona" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("max","4" );
      ((Element)v.get(128)).setAttribute("tipo","" );
      ((Element)v.get(128)).setAttribute("onchange","" );
      ((Element)v.get(128)).setAttribute("req","N" );
      ((Element)v.get(128)).setAttribute("size","4" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("validacion","" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:124   */

      /* Empieza nodo:131 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("colspan","4" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:48   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:134 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","12" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:41   */

      /* Empieza nodo:136 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("class","botonera" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","btnbuscar" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("tipo","html" );
      ((Element)v.get(144)).setAttribute("accion","accionBuscar()" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("ontab","focalizaSiguientebuscar()" );
      ((Element)v.get(144)).setAttribute("alt","" );
      ((Element)v.get(144)).setAttribute("cod","1" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:136   */

      /* Empieza nodo:147 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","750" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:147   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:154 / Elemento padre: 11   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(154)).setAttribute("nombre","listaResultados" );
      ((Element)v.get(154)).setAttribute("ancho","590" );
      ((Element)v.get(154)).setAttribute("alto","300" );
      ((Element)v.get(154)).setAttribute("x","12" );
      ((Element)v.get(154)).setAttribute("y","202" );
      ((Element)v.get(154)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(11)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(155)).setAttribute("precarga","S" );
      ((Element)v.get(155)).setAttribute("conROver","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(156)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(156)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(156)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(156)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(157)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(157)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(157)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(157)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(158)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(158)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:155   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(160)).setAttribute("borde","1" );
      ((Element)v.get(160)).setAttribute("horizDatos","1" );
      ((Element)v.get(160)).setAttribute("horizCabecera","1" );
      ((Element)v.get(160)).setAttribute("vertical","1" );
      ((Element)v.get(160)).setAttribute("horizTitulo","1" );
      ((Element)v.get(160)).setAttribute("horizBase","1" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 159   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(161)).setAttribute("borde","#999999" );
      ((Element)v.get(161)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(161)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(161)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(161)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(161)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(161)).setAttribute("horizBase","#999999" );
      ((Element)v.get(159)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:159   */

      /* Empieza nodo:162 / Elemento padre: 154   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(162)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(162)).setAttribute("alto","22" );
      ((Element)v.get(162)).setAttribute("imgFondo","" );
      ((Element)v.get(162)).setAttribute("cod","00135" );
      ((Element)v.get(162)).setAttribute("ID","datosTitle" );
      ((Element)v.get(154)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(163)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(163)).setAttribute("alto","22" );
      ((Element)v.get(163)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 154   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(164)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(164)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(164)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(164)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(164)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(164)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","80" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","50" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","80" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","80" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(168)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","50" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:164   */

      /* Empieza nodo:170 / Elemento padre: 154   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(170)).setAttribute("alto","20" );
      ((Element)v.get(170)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(170)).setAttribute("imgFondo","" );
      ((Element)v.get(170)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(170)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("align","center" );
      ((Element)v.get(171)).setAttribute("cod","1194" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("colFondo","" );
      ((Element)v.get(172)).setAttribute("ID","EstCab" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(172)).setAttribute("cod","412" );
      ((Element)v.get(170)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","943" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).appendChild((Element)v.get(174));

      /* Elemento padre:174 / Elemento actual: 175   */
      v.add(doc.createTextNode("IndicadorUnidadAdmin"));
      ((Element)v.get(174)).appendChild((Text)v.get(175));

      /* Termina nodo Texto:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).appendChild((Element)v.get(176));

      /* Elemento padre:176 / Elemento actual: 177   */
      v.add(doc.createTextNode("OID_CLIE"));
      ((Element)v.get(176)).appendChild((Text)v.get(177));

      /* Termina nodo Texto:177   */
      /* Termina nodo:176   */
      /* Termina nodo:170   */

      /* Empieza nodo:178 / Elemento padre: 154   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(178)).setAttribute("alto","22" );
      ((Element)v.get(178)).setAttribute("accion","onChangeLista(FILAEVENTO);" );
      ((Element)v.get(178)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(178)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(178)).setAttribute("maxSel","1" );
      ((Element)v.get(178)).setAttribute("deseleccionaSiMaxSel","S" );
      ((Element)v.get(178)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(178)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(178)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(178)).setAttribute("onLoad","" );
      ((Element)v.get(178)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(154)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","texto" );
      ((Element)v.get(180)).setAttribute("ID","EstDat2" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("tipo","texto" );
      ((Element)v.get(181)).setAttribute("ID","EstDat" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("tipo","texto" );
      ((Element)v.get(182)).setAttribute("ID","EstDat2" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("tipo","texto" );
      ((Element)v.get(183)).setAttribute("ID","EstDat" );
      ((Element)v.get(178)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:178   */

      /* Empieza nodo:184 / Elemento padre: 154   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(154)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 154   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(185)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(185)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(185)).setAttribute("ancho","519" );
      ((Element)v.get(185)).setAttribute("sep","$" );
      ((Element)v.get(185)).setAttribute("x","12" );
      ((Element)v.get(185)).setAttribute("class","botonera" );
      ((Element)v.get(185)).setAttribute("y","431" );
      ((Element)v.get(185)).setAttribute("control","" );
      ((Element)v.get(185)).setAttribute("conector","" );
      ((Element)v.get(185)).setAttribute("rowset","" );
      ((Element)v.get(185)).setAttribute("cargainicial","N" );
      ((Element)v.get(154)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","ret1" );
      ((Element)v.get(186)).setAttribute("x","37" );
      ((Element)v.get(186)).setAttribute("y","483" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(186)).setAttribute("img","retroceder_on" );
      ((Element)v.get(186)).setAttribute("tipo","0" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("alt","" );
      ((Element)v.get(186)).setAttribute("codigo","" );
      ((Element)v.get(186)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 185   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(187)).setAttribute("nombre","ava1" );
      ((Element)v.get(187)).setAttribute("x","52" );
      ((Element)v.get(187)).setAttribute("y","483" );
      ((Element)v.get(187)).setAttribute("ID","botonContenido" );
      ((Element)v.get(187)).setAttribute("img","avanzar_on" );
      ((Element)v.get(187)).setAttribute("tipo","0" );
      ((Element)v.get(187)).setAttribute("estado","false" );
      ((Element)v.get(187)).setAttribute("alt","" );
      ((Element)v.get(187)).setAttribute("codigo","" );
      ((Element)v.get(187)).setAttribute("accion","mipgndo.avanzar();" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(185)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:185   */
      /* Termina nodo:154   */

      /* Empieza nodo:188 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(188)).setAttribute("nombre","primera1" );
      ((Element)v.get(188)).setAttribute("x","20" );
      ((Element)v.get(188)).setAttribute("y","483" );
      ((Element)v.get(188)).setAttribute("ID","botonContenido" );
      ((Element)v.get(188)).setAttribute("img","primera_on" );
      ((Element)v.get(188)).setAttribute("tipo","-2" );
      ((Element)v.get(188)).setAttribute("estado","false" );
      ((Element)v.get(188)).setAttribute("alt","" );
      ((Element)v.get(188)).setAttribute("codigo","" );
      ((Element)v.get(188)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(11)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(189)).setAttribute("nombre","separa" );
      ((Element)v.get(189)).setAttribute("x","59" );
      ((Element)v.get(189)).setAttribute("y","479" );
      ((Element)v.get(189)).setAttribute("ID","botonContenido" );
      ((Element)v.get(189)).setAttribute("img","separa_base" );
      ((Element)v.get(189)).setAttribute("tipo","0" );
      ((Element)v.get(189)).setAttribute("estado","false" );
      ((Element)v.get(189)).setAttribute("alt","" );
      ((Element)v.get(189)).setAttribute("codigo","" );
      ((Element)v.get(189)).setAttribute("accion","" );
      ((Element)v.get(11)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(190)).setAttribute("nombre","Modificar" );
      ((Element)v.get(190)).setAttribute("x","75" );
      ((Element)v.get(190)).setAttribute("y","480" );
      ((Element)v.get(190)).setAttribute("ID","botonContenido" );
      ((Element)v.get(190)).setAttribute("tipo","html" );
      ((Element)v.get(190)).setAttribute("estado","false" );
      ((Element)v.get(190)).setAttribute("cod","2" );
      ((Element)v.get(190)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(190)).setAttribute("ontab","tabGenerico('Modificar');" );
      ((Element)v.get(190)).setAttribute("onshtab","tabGenerico('Modificar','sh');" );
      ((Element)v.get(11)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 11   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(191)).setAttribute("nombre","Detalle" );
      ((Element)v.get(191)).setAttribute("x","143" );
      ((Element)v.get(191)).setAttribute("y","480" );
      ((Element)v.get(191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(191)).setAttribute("tipo","html" );
      ((Element)v.get(191)).setAttribute("estado","false" );
      ((Element)v.get(191)).setAttribute("cod","3" );
      ((Element)v.get(191)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(191)).setAttribute("ontab","tabGenerico('Detalle');" );
      ((Element)v.get(191)).setAttribute("onshtab","tabGenerico('Detalle','sh');" );
      ((Element)v.get(11)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(192)).setAttribute("nombre","capa2" );
      ((Element)v.get(192)).setAttribute("alto","120" );
      ((Element)v.get(192)).setAttribute("ancho","100%" );
      ((Element)v.get(192)).setAttribute("colorf","" );
      ((Element)v.get(192)).setAttribute("borde","0" );
      ((Element)v.get(192)).setAttribute("imagenf","" );
      ((Element)v.get(192)).setAttribute("repeat","" );
      ((Element)v.get(192)).setAttribute("padding","" );
      ((Element)v.get(192)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(192)).setAttribute("contravsb","" );
      ((Element)v.get(192)).setAttribute("x","0" );
      ((Element)v.get(192)).setAttribute("y","514" );
      ((Element)v.get(192)).setAttribute("zindex","" );
      ((Element)v.get(11)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("table"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(193)).setAttribute("border","0" );
      ((Element)v.get(193)).setAttribute("cellspacing","0" );
      ((Element)v.get(193)).setAttribute("cellpadding","0" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("width","12" );
      ((Element)v.get(195)).setAttribute("align","center" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","12" );
      ((Element)v.get(196)).setAttribute("height","12" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","750" );
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","12" );
      ((Element)v.get(200)).setAttribute("height","1" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:194   */

      /* Empieza nodo:201 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(206)).setAttribute("class","legend" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(207)).setAttribute("nombre","lblAsignacionResponsable" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("id","legend" );
      ((Element)v.get(207)).setAttribute("cod","00660" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("table"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(208)).setAttribute("border","0" );
      ((Element)v.get(208)).setAttribute("align","center" );
      ((Element)v.get(208)).setAttribute("cellspacing","0" );
      ((Element)v.get(208)).setAttribute("cellpadding","0" );
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("table"));
      ((Element)v.get(211)).setAttribute("width","600" );
      ((Element)v.get(211)).setAttribute("border","0" );
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(211)).setAttribute("cellspacing","0" );
      ((Element)v.get(211)).setAttribute("cellpadding","0" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("colspan","4" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 211   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(211)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","3" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lblCodClienteResponsable" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("id","datosTitle" );
      ((Element)v.get(219)).setAttribute("cod","412" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(215)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:215   */

      /* Empieza nodo:222 / Elemento padre: 211   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(211)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(226)).setAttribute("nombre","txtCodClienteResponsable" );
      ((Element)v.get(226)).setAttribute("onshtab","document.all['btnbuscar'].focus()" );
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(226)).setAttribute("max","15" );
      ((Element)v.get(226)).setAttribute("tipo","" );
      ((Element)v.get(226)).setAttribute("onchange","" );
      ((Element)v.get(226)).setAttribute("req","N" );
      ((Element)v.get(226)).setAttribute("size","19" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("validacion","" );
      ((Element)v.get(226)).setAttribute("ontab","OnTabtxtCodClienteResponsable();" );
      ((Element)v.get(226)).setAttribute("onblur","OnBlurtxtCodClienteResponsable();" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(230)).setAttribute("onclick","accionSeleccionarCliente()" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:222   */

      /* Empieza nodo:233 / Elemento padre: 211   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(211)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("colspan","4" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:236 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:201   */

      /* Empieza nodo:238 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("table"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(243)).setAttribute("border","0" );
      ((Element)v.get(243)).setAttribute("align","center" );
      ((Element)v.get(243)).setAttribute("cellspacing","0" );
      ((Element)v.get(243)).setAttribute("cellpadding","0" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("class","botonera" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(246)).setAttribute("nombre","btnAsignar" );
      ((Element)v.get(246)).setAttribute("ID","botonContenido" );
      ((Element)v.get(246)).setAttribute("ontab","focaliza(FORMUL + '.cbMarca')" );
      ((Element)v.get(246)).setAttribute("tipo","html" );
      ((Element)v.get(246)).setAttribute("accion","accionAsignar()" );
      ((Element)v.get(246)).setAttribute("estado","false" );
      ((Element)v.get(246)).setAttribute("cod","231" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:247 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(248)).setAttribute("height","12" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:238   */

      /* Empieza nodo:249 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","12" );
      ((Element)v.get(250)).setAttribute("align","center" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","12" );
      ((Element)v.get(251)).setAttribute("height","12" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("width","756" );
      ((Element)v.get(249)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("width","12" );
      ((Element)v.get(249)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(255)).setAttribute("height","1" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:249   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:11   */


   }

}
