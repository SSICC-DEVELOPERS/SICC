
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cupones_reemplazo_imprimir  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cupones_reemplazo_imprimir" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_cupones_reemplazo_imprimir.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbMarca" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbCanal" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","7" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","276" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","textFechaFacturacionDesde" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","876" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:5   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(10)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","idioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","pais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casoUso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","marca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","canal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","longitudCodigoCliente" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("valor","11" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","codigos" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","750" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(36)).setAttribute("class","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","legend" );
      ((Element)v.get(37)).setAttribute("cod","0075" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","620" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","left" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("colspan","7" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("valign","bottom" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","6" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("valign","bottom" );
      ((Element)v.get(45)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","7" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblFechaFacturacion" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","876" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:45   */

      /* Empieza nodo:60 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(60));

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
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","S" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(64)).setAttribute("onchange","marcaOnChange();" );
      ((Element)v.get(64)).setAttribute("onshtab","onShTabCbMarca();" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","25" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(69)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("size","1" );
      ((Element)v.get(69)).setAttribute("multiple","N" );
      ((Element)v.get(69)).setAttribute("req","S" );
      ((Element)v.get(69)).setAttribute("valorinicial","" );
      ((Element)v.get(69)).setAttribute("textoinicial","" );
      ((Element)v.get(69)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:71 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(74)).setAttribute("nombre","textFechaFacturacionDesde" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("max","10" );
      ((Element)v.get(74)).setAttribute("tipo","" );
      ((Element)v.get(74)).setAttribute("onchange","" );
      ((Element)v.get(74)).setAttribute("req","S" );
      ((Element)v.get(74)).setAttribute("size","12" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("validacion","" );
      ((Element)v.get(74)).setAttribute("onblur","validaFecha('textFechaFacturacionDesde');" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:60   */

      /* Empieza nodo:77 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("colspan","7" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:80 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","620" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("align","left" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("colspan","3" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblCodigoCliente" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","263" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("colspan","2" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:83   */

      /* Empieza nodo:92 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(96)).setAttribute("nombre","textCodigoCliente" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("max","15" );
      ((Element)v.get(96)).setAttribute("tipo","" );
      ((Element)v.get(96)).setAttribute("onchange","" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","19" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(96)).setAttribute("onblur","codigoClienteOnBlur();" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("valign","bottom" );
      ((Element)v.get(92)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(100)).setAttribute("onclick","accionSeleccionarCliente();" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","16" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("tipo","html" );
      ((Element)v.get(104)).setAttribute("accion","anyadir();" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("cod","404" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(92)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:92   */

      /* Empieza nodo:107 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","3" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:110 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","597" );
      ((Element)v.get(112)).setAttribute("border","0" );
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(117)).setAttribute("nombre","cbCodCliente" );
      ((Element)v.get(117)).setAttribute("valorinicial","0" );
      ((Element)v.get(117)).setAttribute("req","N" );
      ((Element)v.get(117)).setAttribute("multiple","M" );
      ((Element)v.get(117)).setAttribute("size","5" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("textoinicial","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("valign","bottom" );
      ((Element)v.get(113)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(122)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(122)).setAttribute("ID","botonContenido" );
      ((Element)v.get(122)).setAttribute("tipo","html" );
      ((Element)v.get(122)).setAttribute("accion","eliminar();" );
      ((Element)v.get(122)).setAttribute("estado","false" );
      ((Element)v.get(122)).setAttribute("cod","1254" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:113   */

      /* Empieza nodo:125 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("colspan","3" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:128 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
      ((Element)v.get(130)).setAttribute("width","620" );
      ((Element)v.get(130)).setAttribute("border","0" );
      ((Element)v.get(130)).setAttribute("align","left" );
      ((Element)v.get(130)).setAttribute("cellspacing","0" );
      ((Element)v.get(130)).setAttribute("cellpadding","0" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("valign","bottom" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","276" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:131   */

      /* Empieza nodo:138 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(141)).setAttribute("valign","top" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(142)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("size","1" );
      ((Element)v.get(142)).setAttribute("multiple","N" );
      ((Element)v.get(142)).setAttribute("req","S" );
      ((Element)v.get(142)).setAttribute("valorinicial","" );
      ((Element)v.get(142)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:138   */

      /* Empieza nodo:146 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("colspan","3" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:149 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("table"));
      ((Element)v.get(151)).setAttribute("width","620" );
      ((Element)v.get(151)).setAttribute("border","0" );
      ((Element)v.get(151)).setAttribute("align","left" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("cellpadding","0" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblRegionDesde" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(156)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).setAttribute("cod","982" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","25" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblRegionHasta" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","983" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(152)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:152   */

      /* Empieza nodo:163 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(167)).setAttribute("nombre","textRegionDesde" );
      ((Element)v.get(167)).setAttribute("id","datosCampos" );
      ((Element)v.get(167)).setAttribute("max","40" );
      ((Element)v.get(167)).setAttribute("tipo","" );
      ((Element)v.get(167)).setAttribute("onchange","" );
      ((Element)v.get(167)).setAttribute("req","N" );
      ((Element)v.get(167)).setAttribute("size","40" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("validacion","" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(163)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(171)).setAttribute("nombre","textRegionHasta" );
      ((Element)v.get(171)).setAttribute("id","datosCampos" );
      ((Element)v.get(171)).setAttribute("max","40" );
      ((Element)v.get(171)).setAttribute("tipo","" );
      ((Element)v.get(171)).setAttribute("onchange","" );
      ((Element)v.get(171)).setAttribute("req","N" );
      ((Element)v.get(171)).setAttribute("size","40" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("validacion","" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(163)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:163   */

      /* Empieza nodo:174 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(151)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("colspan","5" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:177 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("table"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(179)).setAttribute("width","620" );
      ((Element)v.get(179)).setAttribute("border","0" );
      ((Element)v.get(179)).setAttribute("align","left" );
      ((Element)v.get(179)).setAttribute("cellspacing","0" );
      ((Element)v.get(179)).setAttribute("cellpadding","0" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblZonaDesde" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","1040" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblZonaHasta" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","1041" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:180   */

      /* Empieza nodo:191 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(191));

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
      ((Element)v.get(195)).setAttribute("nombre","textZonaDesde" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("max","40" );
      ((Element)v.get(195)).setAttribute("tipo","" );
      ((Element)v.get(195)).setAttribute("onchange","" );
      ((Element)v.get(195)).setAttribute("req","N" );
      ((Element)v.get(195)).setAttribute("size","40" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(199)).setAttribute("nombre","textZonaHasta" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("max","40" );
      ((Element)v.get(199)).setAttribute("tipo","" );
      ((Element)v.get(199)).setAttribute("onchange","" );
      ((Element)v.get(199)).setAttribute("req","N" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(199)).setAttribute("size","40" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("validacion","" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:191   */

      /* Empieza nodo:202 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("colspan","5" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:205 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("table"));
      ((Element)v.get(207)).setAttribute("width","620" );
      ((Element)v.get(207)).setAttribute("border","0" );
      ((Element)v.get(207)).setAttribute("align","left" );
      ((Element)v.get(207)).setAttribute("cellspacing","0" );
      ((Element)v.get(207)).setAttribute("cellpadding","0" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(212)).setAttribute("nombre","lblSeccionDesde" );
      ((Element)v.get(212)).setAttribute("alto","13" );
      ((Element)v.get(212)).setAttribute("filas","1" );
      ((Element)v.get(212)).setAttribute("valor","" );
      ((Element)v.get(212)).setAttribute("id","datosTitle" );
      ((Element)v.get(212)).setAttribute("cod","985" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(216)).setAttribute("nombre","lblSeccionHasta" );
      ((Element)v.get(216)).setAttribute("alto","13" );
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("id","datosTitle" );
      ((Element)v.get(216)).setAttribute("cod","986" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(208)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:208   */

      /* Empieza nodo:219 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(223)).setAttribute("nombre","textSeccionDesde" );
      ((Element)v.get(223)).setAttribute("id","datosCampos" );
      ((Element)v.get(223)).setAttribute("max","40" );
      ((Element)v.get(223)).setAttribute("tipo","" );
      ((Element)v.get(223)).setAttribute("onchange","" );
      ((Element)v.get(223)).setAttribute("req","N" );
      ((Element)v.get(223)).setAttribute("size","40" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("validacion","" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","25" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(219)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(227)).setAttribute("nombre","textSeccionHasta" );
      ((Element)v.get(227)).setAttribute("id","datosCampos" );
      ((Element)v.get(227)).setAttribute("max","40" );
      ((Element)v.get(227)).setAttribute("tipo","" );
      ((Element)v.get(227)).setAttribute("onchange","" );
      ((Element)v.get(227)).setAttribute("req","N" );
      ((Element)v.get(227)).setAttribute("size","40" );
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(227)).setAttribute("validacion","" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(219)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:219   */

      /* Empieza nodo:230 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("colspan","5" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:233 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("table"));
      ((Element)v.get(235)).setAttribute("width","620" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("align","left" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblTerritorioDesde" );
      ((Element)v.get(240)).setAttribute("alto","13" );
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("id","datosTitle" );
      ((Element)v.get(240)).setAttribute("cod","997" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(244)).setAttribute("nombre","lblTerritorioHasta" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(244)).setAttribute("alto","13" );
      ((Element)v.get(244)).setAttribute("filas","1" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(244)).setAttribute("id","datosTitle" );
      ((Element)v.get(244)).setAttribute("cod","998" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(236)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:236   */

      /* Empieza nodo:247 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(251)).setAttribute("nombre","textTerritorioDesde" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("max","40" );
      ((Element)v.get(251)).setAttribute("tipo","" );
      ((Element)v.get(251)).setAttribute("onchange","" );
      ((Element)v.get(251)).setAttribute("req","N" );
      ((Element)v.get(251)).setAttribute("size","40" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("validacion","" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","25" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(247)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(255)).setAttribute("nombre","textTerritorioHasta" );
      ((Element)v.get(255)).setAttribute("id","datosCampos" );
      ((Element)v.get(255)).setAttribute("max","40" );
      ((Element)v.get(255)).setAttribute("tipo","" );
      ((Element)v.get(255)).setAttribute("onchange","" );
      ((Element)v.get(255)).setAttribute("req","N" );
      ((Element)v.get(255)).setAttribute("size","40" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(255)).setAttribute("validacion","" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("width","100%" );
      ((Element)v.get(247)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:247   */

      /* Empieza nodo:258 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("colspan","5" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:261 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:31   */

      /* Empieza nodo:263 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("table"));
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(268)).setAttribute("border","0" );
      ((Element)v.get(268)).setAttribute("align","center" );
      ((Element)v.get(268)).setAttribute("cellspacing","0" );
      ((Element)v.get(268)).setAttribute("cellpadding","0" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("class","botonera" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(271)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(271)).setAttribute("ID","botonContenido" );
      ((Element)v.get(271)).setAttribute("tipo","html" );
      ((Element)v.get(271)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(271)).setAttribute("estado","false" );
      ((Element)v.get(271)).setAttribute("cod","1" );
      ((Element)v.get(271)).setAttribute("ontab","onTabBuscar();" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:272 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","12" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:263   */

      /* Empieza nodo:274 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("align","center" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","12" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","756" );
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","12" );
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(280)).setAttribute("height","1" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:274   */
      /* Termina nodo:23   */

      /* Empieza nodo:281 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(281)).setAttribute("nombre","capaLista" );
      ((Element)v.get(281)).setAttribute("alto","317" );
      ((Element)v.get(281)).setAttribute("ancho","100%" );
      ((Element)v.get(281)).setAttribute("colorf","" );
      ((Element)v.get(281)).setAttribute("borde","0" );
      ((Element)v.get(281)).setAttribute("imagenf","" );
      ((Element)v.get(281)).setAttribute("repeat","" );
      ((Element)v.get(281)).setAttribute("padding","" );
      ((Element)v.get(281)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(281)).setAttribute("contravsb","" );
      ((Element)v.get(281)).setAttribute("x","0" );
      ((Element)v.get(281)).setAttribute("y","444" );
      ((Element)v.get(281)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(282)).setAttribute("nombre","listado1" );
      ((Element)v.get(282)).setAttribute("ancho","624" );
      ((Element)v.get(282)).setAttribute("alto","317" );
      ((Element)v.get(282)).setAttribute("x","12" );
      ((Element)v.get(282)).setAttribute("y","0" );
      ((Element)v.get(282)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(282)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(283)).setAttribute("precarga","S" );
      ((Element)v.get(283)).setAttribute("conROver","S" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(284)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(284)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(284)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(284)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 283   */
      v.add(doc.createElement("BTNMINIMIZAR"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(285)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(285)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(285)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(285)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(283)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(286)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(286)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(283)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:283   */

      /* Empieza nodo:287 / Elemento padre: 282   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(282)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(288)).setAttribute("borde","1" );
      ((Element)v.get(288)).setAttribute("horizDatos","1" );
      ((Element)v.get(288)).setAttribute("horizCabecera","1" );
      ((Element)v.get(288)).setAttribute("vertical","1" );
      ((Element)v.get(288)).setAttribute("horizTitulo","1" );
      ((Element)v.get(288)).setAttribute("horizBase","1" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(289)).setAttribute("borde","#999999" );
      ((Element)v.get(289)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(289)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(289)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(289)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(289)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(289)).setAttribute("horizBase","#999999" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:287   */

      /* Empieza nodo:290 / Elemento padre: 282   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(290)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(290)).setAttribute("alto","22" );
      ((Element)v.get(290)).setAttribute("imgFondo","" );
      ((Element)v.get(290)).setAttribute("cod","00135" );
      ((Element)v.get(290)).setAttribute("ID","datosTitle" );
      ((Element)v.get(282)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 282   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(291)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(291)).setAttribute("alto","22" );
      ((Element)v.get(291)).setAttribute("imgFondo","" );
      ((Element)v.get(282)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 282   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(292)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(292)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(292)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(292)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(292)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(292)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(282)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("ancho","115" );
      ((Element)v.get(293)).setAttribute("minimizable","S" );
      ((Element)v.get(293)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).setAttribute("oculta","S" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("ancho","115" );
      ((Element)v.get(294)).setAttribute("minimizable","S" );
      ((Element)v.get(294)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("ancho","320" );
      ((Element)v.get(295)).setAttribute("minimizable","S" );
      ((Element)v.get(295)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("ancho","200" );
      ((Element)v.get(296)).setAttribute("minimizable","S" );
      ((Element)v.get(296)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("ancho","200" );
      ((Element)v.get(297)).setAttribute("minimizable","S" );
      ((Element)v.get(297)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("ancho","200" );
      ((Element)v.get(298)).setAttribute("minimizable","S" );
      ((Element)v.get(298)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("ancho","100" );
      ((Element)v.get(299)).setAttribute("minimizable","S" );
      ((Element)v.get(299)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("ancho","90" );
      ((Element)v.get(300)).setAttribute("minimizable","S" );
      ((Element)v.get(300)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(301)).setAttribute("ancho","120" );
      ((Element)v.get(301)).setAttribute("minimizable","S" );
      ((Element)v.get(301)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("ancho","120" );
      ((Element)v.get(302)).setAttribute("minimizable","S" );
      ((Element)v.get(302)).setAttribute("minimizada","N" );
      ((Element)v.get(292)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("ancho","115" );
      ((Element)v.get(303)).setAttribute("minimizable","S" );
      ((Element)v.get(303)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).setAttribute("oculta","S" );
      ((Element)v.get(292)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:292   */

      /* Empieza nodo:304 / Elemento padre: 282   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(304)).setAttribute("alto","20" );
      ((Element)v.get(304)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(304)).setAttribute("imgFondo","" );
      ((Element)v.get(304)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(282)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("colFondo","" );
      ((Element)v.get(305)).setAttribute("ID","EstCab" );
      ((Element)v.get(305)).setAttribute("cod","263" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("colFondo","" );
      ((Element)v.get(306)).setAttribute("ID","EstCab" );
      ((Element)v.get(306)).setAttribute("cod","263" );
      ((Element)v.get(304)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("colFondo","" );
      ((Element)v.get(307)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).setAttribute("cod","1655" );
      ((Element)v.get(304)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("colFondo","" );
      ((Element)v.get(308)).setAttribute("ID","EstCab" );
      ((Element)v.get(308)).setAttribute("cod","7" );
      ((Element)v.get(304)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("colFondo","" );
      ((Element)v.get(309)).setAttribute("ID","EstCab" );
      ((Element)v.get(309)).setAttribute("cod","10" );
      ((Element)v.get(304)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("colFondo","" );
      ((Element)v.get(310)).setAttribute("ID","EstCab" );
      ((Element)v.get(310)).setAttribute("cod","122" );
      ((Element)v.get(304)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("colFondo","" );
      ((Element)v.get(311)).setAttribute("ID","EstCab" );
      ((Element)v.get(311)).setAttribute("cod","1419" );
      ((Element)v.get(304)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("colFondo","" );
      ((Element)v.get(312)).setAttribute("ID","EstCab" );
      ((Element)v.get(312)).setAttribute("cod","276" );
      ((Element)v.get(304)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("colFondo","" );
      ((Element)v.get(313)).setAttribute("ID","EstCab" );
      ((Element)v.get(313)).setAttribute("cod","876" );
      ((Element)v.get(304)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("colFondo","" );
      ((Element)v.get(314)).setAttribute("ID","EstCab" );
      ((Element)v.get(314)).setAttribute("cod","2788" );
      ((Element)v.get(304)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 304   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
      ((Element)v.get(315)).setAttribute("cod","263" );
      ((Element)v.get(304)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:304   */

      /* Empieza nodo:316 / Elemento padre: 282   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(316)).setAttribute("alto","22" );
      ((Element)v.get(316)).setAttribute("accion","" );
      ((Element)v.get(316)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(316)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(316)).setAttribute("maxSel","-1" );
      ((Element)v.get(316)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(316)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(316)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(316)).setAttribute("onLoad","" );
      ((Element)v.get(316)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(316)).setAttribute("onAfterSetDatos","seleccionarFilas()" );
      ((Element)v.get(282)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(317)).setAttribute("tipo","texto" );
      ((Element)v.get(317)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","texto" );
      ((Element)v.get(318)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("tipo","texto" );
      ((Element)v.get(324)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("tipo","texto" );
      ((Element)v.get(325)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("tipo","texto" );
      ((Element)v.get(326)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("tipo","texto" );
      ((Element)v.get(327)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:316   */

      /* Empieza nodo:328 / Elemento padre: 282   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(328)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(328)).setAttribute("ancho","624" );
      ((Element)v.get(328)).setAttribute("sep","$" );
      ((Element)v.get(328)).setAttribute("x","12" );
      ((Element)v.get(328)).setAttribute("class","botonera" );
      ((Element)v.get(328)).setAttribute("y","294" );
      ((Element)v.get(328)).setAttribute("control","|" );
      ((Element)v.get(328)).setAttribute("conector","conector_fac" );
      ((Element)v.get(328)).setAttribute("rowset","" );
      ((Element)v.get(328)).setAttribute("cargainicial","N" );
      ((Element)v.get(328)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(282)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(329)).setAttribute("nombre","ret1" );
      ((Element)v.get(329)).setAttribute("x","37" );
      ((Element)v.get(329)).setAttribute("y","298" );
      ((Element)v.get(329)).setAttribute("ID","botonContenido" );
      ((Element)v.get(329)).setAttribute("img","retroceder_on" );
      ((Element)v.get(329)).setAttribute("tipo","0" );
      ((Element)v.get(329)).setAttribute("estado","false" );
      ((Element)v.get(329)).setAttribute("alt","" );
      ((Element)v.get(329)).setAttribute("codigo","" );
      ((Element)v.get(329)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 328   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(330)).setAttribute("nombre","ava1" );
      ((Element)v.get(330)).setAttribute("x","52" );
      ((Element)v.get(330)).setAttribute("y","298" );
      ((Element)v.get(330)).setAttribute("ID","botonContenido" );
      ((Element)v.get(330)).setAttribute("img","avanzar_on" );
      ((Element)v.get(330)).setAttribute("tipo","0" );
      ((Element)v.get(330)).setAttribute("estado","false" );
      ((Element)v.get(330)).setAttribute("alt","" );
      ((Element)v.get(330)).setAttribute("codigo","" );
      ((Element)v.get(330)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(328)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:328   */
      /* Termina nodo:282   */

      /* Empieza nodo:331 / Elemento padre: 281   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(331)).setAttribute("nombre","primera1" );
      ((Element)v.get(331)).setAttribute("x","20" );
      ((Element)v.get(331)).setAttribute("y","298" );
      ((Element)v.get(331)).setAttribute("ID","botonContenido" );
      ((Element)v.get(331)).setAttribute("img","primera_on" );
      ((Element)v.get(331)).setAttribute("tipo","-2" );
      ((Element)v.get(331)).setAttribute("estado","false" );
      ((Element)v.get(331)).setAttribute("alt","" );
      ((Element)v.get(331)).setAttribute("codigo","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(331)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(281)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 281   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(332)).setAttribute("nombre","separa" );
      ((Element)v.get(332)).setAttribute("x","59" );
      ((Element)v.get(332)).setAttribute("y","294" );
      ((Element)v.get(332)).setAttribute("ID","botonContenido" );
      ((Element)v.get(332)).setAttribute("img","separa_base" );
      ((Element)v.get(332)).setAttribute("tipo","0" );
      ((Element)v.get(332)).setAttribute("estado","false" );
      ((Element)v.get(332)).setAttribute("alt","" );
      ((Element)v.get(332)).setAttribute("codigo","" );
      ((Element)v.get(332)).setAttribute("accion","" );
      ((Element)v.get(281)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 281   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(333)).setAttribute("nombre","btnImprimir" );
      ((Element)v.get(333)).setAttribute("x","80" );
      ((Element)v.get(333)).setAttribute("y","295" );
      ((Element)v.get(333)).setAttribute("ID","botonContenido" );
      ((Element)v.get(333)).setAttribute("img","" );
      ((Element)v.get(333)).setAttribute("tipo","html" );
      ((Element)v.get(333)).setAttribute("estado","false" );
      ((Element)v.get(333)).setAttribute("cod","1157" );
      ((Element)v.get(333)).setAttribute("accion","onClickImprimir();" );
      ((Element)v.get(333)).setAttribute("onshtab","onShTabBtnImprimir();" );
      ((Element)v.get(333)).setAttribute("ontab","onTabBtnImprimir()" );
      ((Element)v.get(281)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:281   */

      /* Empieza nodo:334 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(334)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(334)).setAttribute("alto","12" );
      ((Element)v.get(334)).setAttribute("ancho","100" );
      ((Element)v.get(334)).setAttribute("colorf","" );
      ((Element)v.get(334)).setAttribute("borde","0" );
      ((Element)v.get(334)).setAttribute("imagenf","" );
      ((Element)v.get(334)).setAttribute("repeat","" );
      ((Element)v.get(334)).setAttribute("padding","" );
      ((Element)v.get(334)).setAttribute("visibilidad","visible" );
      ((Element)v.get(334)).setAttribute("contravsb","" );
      ((Element)v.get(334)).setAttribute("x","0" );
      ((Element)v.get(334)).setAttribute("y","761" );
      ((Element)v.get(334)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:10   */


   }

}
