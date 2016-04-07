
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_no_recojibles_gestionar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_no_recojibles_gestionar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","3261" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_productos_no_recojibles_gestionar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(7)).setAttribute("req","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(8)).setAttribute("req","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","276" );
      ((Element)v.get(9)).setAttribute("req","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:6   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(10)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","LPGestionarProductosNoRecogibles" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","buscar" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","dTOGestionProductosNoRecogibles" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","dTOProductoNoRecogibles" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidCanal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidPeriodo" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidMarca" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(23)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(23)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(23)).setAttribute("borde","0" );
      ((Element)v.get(23)).setAttribute("imagenf","" );
      ((Element)v.get(23)).setAttribute("repeat","" );
      ((Element)v.get(23)).setAttribute("padding","" );
      ((Element)v.get(23)).setAttribute("visibilidad","" );
      ((Element)v.get(23)).setAttribute("contravsb","" );
      ((Element)v.get(23)).setAttribute("x","0" );
      ((Element)v.get(23)).setAttribute("y","0" );
      ((Element)v.get(23)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","750" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","1" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:25   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(37)).setAttribute("class","legend" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(38)).setAttribute("id","legend" );
      ((Element)v.get(38)).setAttribute("cod","0075" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","4" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","6" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","7" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","276" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:43   */

      /* Empieza nodo:58 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(58));

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
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(62)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("size","1" );
      ((Element)v.get(62)).setAttribute("multiple","N" );
      ((Element)v.get(62)).setAttribute("req","S" );
      ((Element)v.get(62)).setAttribute("valorinicial","" );
      ((Element)v.get(62)).setAttribute("textoinicial","" );
      ((Element)v.get(62)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(62)).setAttribute("onshtab","tabGenerico('cbMarca','sh');" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:64 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(67)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("size","1" );
      ((Element)v.get(67)).setAttribute("multiple","N" );
      ((Element)v.get(67)).setAttribute("req","S" );
      ((Element)v.get(67)).setAttribute("valorinicial","" );
      ((Element)v.get(67)).setAttribute("textoinicial","" );
      ((Element)v.get(67)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(72)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("size","1" );
      ((Element)v.get(72)).setAttribute("multiple","N" );
      ((Element)v.get(72)).setAttribute("req","S" );
      ((Element)v.get(72)).setAttribute("valorinicial","" );
      ((Element)v.get(72)).setAttribute("textoinicial","" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:58   */

      /* Empieza nodo:74 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("colspan","4" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:39   */

      /* Empieza nodo:77 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(77)).setAttribute("border","0" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblCodVent" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","336" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblCodVentFict" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","1853" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblCodSAP" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","585" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","9" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:78   */

      /* Empieza nodo:97 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(101)).setAttribute("nombre","txtCodVent" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("max","30" );
      ((Element)v.get(101)).setAttribute("readonly","true" );
      ((Element)v.get(101)).setAttribute("tipo","" );
      ((Element)v.get(101)).setAttribute("onchange","deshab();" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("size","40" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("onshtab","tabGenerico('txtCodVent','sh');" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(105)).setAttribute("nombre","txtCodVentFict" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("max","30" );
      ((Element)v.get(105)).setAttribute("readonly","true" );
      ((Element)v.get(105)).setAttribute("tipo","" );
      ((Element)v.get(105)).setAttribute("onchange","deshab();" );
      ((Element)v.get(105)).setAttribute("req","N" );
      ((Element)v.get(105)).setAttribute("size","40" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(109)).setAttribute("nombre","txtCodSAP" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("max","30" );
      ((Element)v.get(109)).setAttribute("readonly","true" );
      ((Element)v.get(109)).setAttribute("tipo","" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("size","40" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(113)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("max","30" );
      ((Element)v.get(113)).setAttribute("readonly","true" );
      ((Element)v.get(113)).setAttribute("tipo","" );
      ((Element)v.get(113)).setAttribute("onchange","" );
      ((Element)v.get(113)).setAttribute("req","N" );
      ((Element)v.get(113)).setAttribute("size","40" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("ontab","tabGenerico('txtDescripcion');" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:97   */

      /* Empieza nodo:114 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(114));

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
      /* Termina nodo:77   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:117 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:32   */

      /* Empieza nodo:119 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("class","botonera" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(127)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(127)).setAttribute("ID","botonContenido" );
      ((Element)v.get(127)).setAttribute("tipo","html" );
      ((Element)v.get(127)).setAttribute("estado","false" );
      ((Element)v.get(127)).setAttribute("cod","1" );
      ((Element)v.get(127)).setAttribute("accion","botonBuscar();" );
      ((Element)v.get(127)).setAttribute("ontab","tabGenerico('btnBuscar');" );
      ((Element)v.get(127)).setAttribute("onshtab","tabGenerico('btnBuscar','sh');" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:128 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:119   */

      /* Empieza nodo:130 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(132)).setAttribute("height","12" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","750" );
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","12" );
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","12" );
      ((Element)v.get(136)).setAttribute("height","1" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:130   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:137 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(137)).setAttribute("nombre","listado1" );
      ((Element)v.get(137)).setAttribute("ancho","664" );
      ((Element)v.get(137)).setAttribute("alto","317" );
      ((Element)v.get(137)).setAttribute("x","12" );
      ((Element)v.get(137)).setAttribute("y","151" );
      ((Element)v.get(137)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(137)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(138)).setAttribute("precarga","S" );
      ((Element)v.get(138)).setAttribute("conROver","S" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(139)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(139)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(139)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(139)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 138   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(140)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(140)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(140)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(140)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(138)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(141)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(141)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:138   */

      /* Empieza nodo:142 / Elemento padre: 137   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(137)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(143)).setAttribute("borde","1" );
      ((Element)v.get(143)).setAttribute("horizDatos","1" );
      ((Element)v.get(143)).setAttribute("horizCabecera","1" );
      ((Element)v.get(143)).setAttribute("vertical","1" );
      ((Element)v.get(143)).setAttribute("horizTitulo","1" );
      ((Element)v.get(143)).setAttribute("horizBase","1" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 142   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(144)).setAttribute("borde","#999999" );
      ((Element)v.get(144)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(144)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(144)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(144)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(144)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(144)).setAttribute("horizBase","#999999" );
      ((Element)v.get(142)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 137   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(145)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(145)).setAttribute("alto","22" );
      ((Element)v.get(145)).setAttribute("imgFondo","" );
      ((Element)v.get(145)).setAttribute("cod","00135" );
      ((Element)v.get(145)).setAttribute("ID","datosTitle" );
      ((Element)v.get(137)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 137   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(146)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(146)).setAttribute("alto","22" );
      ((Element)v.get(146)).setAttribute("imgFondo","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(137)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 137   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(147)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(147)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(147)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(147)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(147)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(147)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(137)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","100" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","100" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","100" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","100" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","100" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","100" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","100" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","100" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:147   */

      /* Empieza nodo:156 / Elemento padre: 137   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(156)).setAttribute("alto","20" );
      ((Element)v.get(156)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(156)).setAttribute("imgFondo","" );
      ((Element)v.get(156)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(137)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("cod","336" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("Cod. Venta"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","1853" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("Cod. Venta Ficticio"));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("cod","585" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode("Cod. Producto"));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("colFondo","" );
      ((Element)v.get(163)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).setAttribute("cod","9" );
      ((Element)v.get(156)).appendChild((Element)v.get(163));

      /* Elemento padre:163 / Elemento actual: 164   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(163)).appendChild((Text)v.get(164));

      /* Termina nodo Texto:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","608" );
      ((Element)v.get(156)).appendChild((Element)v.get(165));

      /* Elemento padre:165 / Elemento actual: 166   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(165)).appendChild((Text)v.get(166));

      /* Termina nodo Texto:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 156   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","1604" );
      ((Element)v.get(156)).appendChild((Element)v.get(167));

      /* Elemento padre:167 / Elemento actual: 168   */
      v.add(doc.createTextNode("Numero Concurso"));
      ((Element)v.get(167)).appendChild((Text)v.get(168));

      /* Termina nodo Texto:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","1607" );
      ((Element)v.get(156)).appendChild((Element)v.get(169));

      /* Elemento padre:169 / Elemento actual: 170   */
      v.add(doc.createTextNode("Version"));
      ((Element)v.get(169)).appendChild((Text)v.get(170));

      /* Termina nodo Texto:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","1664" );
      ((Element)v.get(156)).appendChild((Element)v.get(171));

      /* Elemento padre:171 / Elemento actual: 172   */
      v.add(doc.createTextNode("Numero Nivel"));
      ((Element)v.get(171)).appendChild((Text)v.get(172));

      /* Termina nodo Texto:172   */
      /* Termina nodo:171   */
      /* Termina nodo:156   */

      /* Empieza nodo:173 / Elemento padre: 137   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(173)).setAttribute("alto","22" );
      ((Element)v.get(173)).setAttribute("accion","" );
      ((Element)v.get(173)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(173)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(173)).setAttribute("maxSel","-1" );
      ((Element)v.get(173)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(173)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(173)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(173)).setAttribute("onLoad","" );
      ((Element)v.get(173)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(137)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat2" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat" );
      ((Element)v.get(173)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","texto" );
      ((Element)v.get(177)).setAttribute("ID","EstDat2" );
      ((Element)v.get(173)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","texto" );
      ((Element)v.get(178)).setAttribute("ID","EstDat2" );
      ((Element)v.get(173)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat" );
      ((Element)v.get(173)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","texto" );
      ((Element)v.get(180)).setAttribute("ID","EstDat2" );
      ((Element)v.get(173)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("tipo","texto" );
      ((Element)v.get(181)).setAttribute("ID","EstDat" );
      ((Element)v.get(173)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:173   */

      /* Empieza nodo:182 / Elemento padre: 137   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(137)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 137   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(183)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(183)).setAttribute("ancho","664" );
      ((Element)v.get(183)).setAttribute("sep","$" );
      ((Element)v.get(183)).setAttribute("x","12" );
      ((Element)v.get(183)).setAttribute("class","botonera" );
      ((Element)v.get(183)).setAttribute("y","445" );
      ((Element)v.get(183)).setAttribute("control","|" );
      ((Element)v.get(183)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(183)).setAttribute("rowset","" );
      ((Element)v.get(183)).setAttribute("cargainicial","N" );
      ((Element)v.get(183)).setAttribute("onload","vacio(msgError, ultima, rowset);" );
      ((Element)v.get(137)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","ret1" );
      ((Element)v.get(184)).setAttribute("x","37" );
      ((Element)v.get(184)).setAttribute("y","449" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("img","retroceder_on" );
      ((Element)v.get(184)).setAttribute("tipo","0" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("alt","" );
      ((Element)v.get(184)).setAttribute("codigo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(184)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 183   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(185)).setAttribute("nombre","ava1" );
      ((Element)v.get(185)).setAttribute("x","52" );
      ((Element)v.get(185)).setAttribute("y","449" );
      ((Element)v.get(185)).setAttribute("ID","botonContenido" );
      ((Element)v.get(185)).setAttribute("img","avanzar_on" );
      ((Element)v.get(185)).setAttribute("tipo","0" );
      ((Element)v.get(185)).setAttribute("estado","false" );
      ((Element)v.get(185)).setAttribute("alt","" );
      ((Element)v.get(185)).setAttribute("codigo","" );
      ((Element)v.get(185)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(183)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:183   */
      /* Termina nodo:137   */

      /* Empieza nodo:186 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","primera1" );
      ((Element)v.get(186)).setAttribute("x","20" );
      ((Element)v.get(186)).setAttribute("y","449" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(186)).setAttribute("img","primera_on" );
      ((Element)v.get(186)).setAttribute("tipo","-2" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("alt","" );
      ((Element)v.get(186)).setAttribute("codigo","" );
      ((Element)v.get(186)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(187)).setAttribute("nombre","separa1" );
      ((Element)v.get(187)).setAttribute("x","59" );
      ((Element)v.get(187)).setAttribute("y","445" );
      ((Element)v.get(187)).setAttribute("ID","botonContenido" );
      ((Element)v.get(187)).setAttribute("img","separa_base" );
      ((Element)v.get(187)).setAttribute("tipo","0" );
      ((Element)v.get(187)).setAttribute("estado","false" );
      ((Element)v.get(187)).setAttribute("alt","" );
      ((Element)v.get(187)).setAttribute("codigo","" );
      ((Element)v.get(187)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(188)).setAttribute("nombre","Anadir" );
      ((Element)v.get(188)).setAttribute("x","80" );
      ((Element)v.get(188)).setAttribute("y","446" );
      ((Element)v.get(188)).setAttribute("ID","botonContenido" );
      ((Element)v.get(188)).setAttribute("tipo","html" );
      ((Element)v.get(188)).setAttribute("estado","false" );
      ((Element)v.get(188)).setAttribute("cod","404" );
      ((Element)v.get(188)).setAttribute("accion","botonAniadir();" );
      ((Element)v.get(188)).setAttribute("onshtab","tabGenerico('Anadir','sh');" );
      ((Element)v.get(188)).setAttribute("ontab","tabGenerico('Anadir');" );
      ((Element)v.get(10)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(189)).setAttribute("nombre","listado2" );
      ((Element)v.get(189)).setAttribute("ancho","664" );
      ((Element)v.get(189)).setAttribute("alto","317" );
      ((Element)v.get(189)).setAttribute("x","12" );
      ((Element)v.get(189)).setAttribute("y","492" );
      ((Element)v.get(189)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(189)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(190)).setAttribute("precarga","S" );
      ((Element)v.get(190)).setAttribute("conROver","S" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(191)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(191)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(191)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(191)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 190   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(192)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(192)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(192)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(192)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(190)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(193)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(193)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:190   */

      /* Empieza nodo:194 / Elemento padre: 189   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(189)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(195)).setAttribute("borde","1" );
      ((Element)v.get(195)).setAttribute("horizDatos","1" );
      ((Element)v.get(195)).setAttribute("horizCabecera","1" );
      ((Element)v.get(195)).setAttribute("vertical","1" );
      ((Element)v.get(195)).setAttribute("horizTitulo","1" );
      ((Element)v.get(195)).setAttribute("horizBase","1" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 194   */
      v.add(doc.createElement("COLOR"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(196)).setAttribute("borde","#999999" );
      ((Element)v.get(196)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(196)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(196)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(196)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(196)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(196)).setAttribute("horizBase","#999999" );
      ((Element)v.get(194)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 189   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(197)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(197)).setAttribute("alto","22" );
      ((Element)v.get(197)).setAttribute("imgFondo","" );
      ((Element)v.get(197)).setAttribute("cod","00499" );
      ((Element)v.get(197)).setAttribute("ID","datosTitle" );
      ((Element)v.get(189)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 189   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(198)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(198)).setAttribute("alto","22" );
      ((Element)v.get(198)).setAttribute("imgFondo","" );
      ((Element)v.get(189)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 189   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(199)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(199)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(199)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(199)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(199)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(199)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(189)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("ancho","100" );
      ((Element)v.get(200)).setAttribute("minimizable","S" );
      ((Element)v.get(200)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("ancho","100" );
      ((Element)v.get(201)).setAttribute("minimizable","S" );
      ((Element)v.get(201)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("ancho","100" );
      ((Element)v.get(202)).setAttribute("minimizable","S" );
      ((Element)v.get(202)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("ancho","100" );
      ((Element)v.get(203)).setAttribute("minimizable","S" );
      ((Element)v.get(203)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("ancho","100" );
      ((Element)v.get(204)).setAttribute("minimizable","S" );
      ((Element)v.get(204)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("ancho","100" );
      ((Element)v.get(205)).setAttribute("minimizable","S" );
      ((Element)v.get(205)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","100" );
      ((Element)v.get(206)).setAttribute("minimizable","S" );
      ((Element)v.get(206)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("ancho","100" );
      ((Element)v.get(207)).setAttribute("minimizable","S" );
      ((Element)v.get(207)).setAttribute("minimizada","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 199   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("ancho","0" );
      ((Element)v.get(208)).setAttribute("minimizable","S" );
      ((Element)v.get(208)).setAttribute("minimizada","S" );
      ((Element)v.get(199)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:199   */

      /* Empieza nodo:209 / Elemento padre: 189   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(209)).setAttribute("alto","20" );
      ((Element)v.get(209)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(209)).setAttribute("imgFondo","" );
      ((Element)v.get(209)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(189)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("colFondo","" );
      ((Element)v.get(210)).setAttribute("ID","EstCab" );
      ((Element)v.get(210)).setAttribute("cod","336" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Elemento padre:210 / Elemento actual: 211   */
      v.add(doc.createTextNode("Cod. Venta"));
      ((Element)v.get(210)).appendChild((Text)v.get(211));

      /* Termina nodo Texto:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("colFondo","" );
      ((Element)v.get(212)).setAttribute("ID","EstCab" );
      ((Element)v.get(212)).setAttribute("cod","1853" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Elemento padre:212 / Elemento actual: 213   */
      v.add(doc.createTextNode("Cod. Venta Ficticio"));
      ((Element)v.get(212)).appendChild((Text)v.get(213));

      /* Termina nodo Texto:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("colFondo","" );
      ((Element)v.get(214)).setAttribute("ID","EstCab" );
      ((Element)v.get(214)).setAttribute("cod","585" );
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Elemento padre:214 / Elemento actual: 215   */
      v.add(doc.createTextNode("Cod. Producto"));
      ((Element)v.get(214)).appendChild((Text)v.get(215));

      /* Termina nodo Texto:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("colFondo","" );
      ((Element)v.get(216)).setAttribute("ID","EstCab" );
      ((Element)v.get(216)).setAttribute("cod","9" );
      ((Element)v.get(209)).appendChild((Element)v.get(216));

      /* Elemento padre:216 / Elemento actual: 217   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(216)).appendChild((Text)v.get(217));

      /* Termina nodo Texto:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("colFondo","" );
      ((Element)v.get(218)).setAttribute("ID","EstCab" );
      ((Element)v.get(218)).setAttribute("cod","608" );
      ((Element)v.get(209)).appendChild((Element)v.get(218));

      /* Elemento padre:218 / Elemento actual: 219   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(218)).appendChild((Text)v.get(219));

      /* Termina nodo Texto:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("colFondo","" );
      ((Element)v.get(220)).setAttribute("ID","EstCab" );
      ((Element)v.get(220)).setAttribute("cod","1604" );
      ((Element)v.get(209)).appendChild((Element)v.get(220));

      /* Elemento padre:220 / Elemento actual: 221   */
      v.add(doc.createTextNode("Numero Concurso"));
      ((Element)v.get(220)).appendChild((Text)v.get(221));

      /* Termina nodo Texto:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("colFondo","" );
      ((Element)v.get(222)).setAttribute("ID","EstCab" );
      ((Element)v.get(222)).setAttribute("cod","1607" );
      ((Element)v.get(209)).appendChild((Element)v.get(222));

      /* Elemento padre:222 / Elemento actual: 223   */
      v.add(doc.createTextNode("Version"));
      ((Element)v.get(222)).appendChild((Text)v.get(223));

      /* Termina nodo Texto:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 209   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("cod","1664" );
      ((Element)v.get(209)).appendChild((Element)v.get(224));

      /* Elemento padre:224 / Elemento actual: 225   */
      v.add(doc.createTextNode("Numero Nivel"));
      ((Element)v.get(224)).appendChild((Text)v.get(225));

      /* Termina nodo Texto:225   */
      /* Termina nodo:224   */
      /* Termina nodo:209   */

      /* Empieza nodo:226 / Elemento padre: 189   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(226)).setAttribute("alto","22" );
      ((Element)v.get(226)).setAttribute("accion","" );
      ((Element)v.get(226)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(226)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(226)).setAttribute("maxSel","-1" );
      ((Element)v.get(226)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(226)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(226)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(226)).setAttribute("onLoad","" );
      ((Element)v.get(226)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(189)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("tipo","texto" );
      ((Element)v.get(227)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("tipo","texto" );
      ((Element)v.get(228)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("tipo","texto" );
      ((Element)v.get(229)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("tipo","texto" );
      ((Element)v.get(230)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","texto" );
      ((Element)v.get(231)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("tipo","texto" );
      ((Element)v.get(232)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("tipo","texto" );
      ((Element)v.get(233)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("tipo","texto" );
      ((Element)v.get(234)).setAttribute("ID","EstDat" );
      ((Element)v.get(226)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 226   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(235)).setAttribute("tipo","texto" );
      ((Element)v.get(235)).setAttribute("ID","EstDat2" );
      ((Element)v.get(226)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:226   */

      /* Empieza nodo:236 / Elemento padre: 189   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(189)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 189   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(237)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(237)).setAttribute("ancho","664" );
      ((Element)v.get(237)).setAttribute("sep","$" );
      ((Element)v.get(237)).setAttribute("x","12" );
      ((Element)v.get(237)).setAttribute("class","botonera" );
      ((Element)v.get(237)).setAttribute("y","786" );
      ((Element)v.get(237)).setAttribute("control","|" );
      ((Element)v.get(237)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(237)).setAttribute("rowset","" );
      ((Element)v.get(237)).setAttribute("cargainicial","N" );
      ((Element)v.get(189)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","ret2" );
      ((Element)v.get(238)).setAttribute("x","37" );
      ((Element)v.get(238)).setAttribute("y","790" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("img","retroceder_on" );
      ((Element)v.get(238)).setAttribute("tipo","0" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("alt","" );
      ((Element)v.get(238)).setAttribute("codigo","" );
      ((Element)v.get(238)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(239)).setAttribute("nombre","ava2" );
      ((Element)v.get(239)).setAttribute("x","52" );
      ((Element)v.get(239)).setAttribute("y","790" );
      ((Element)v.get(239)).setAttribute("ID","botonContenido" );
      ((Element)v.get(239)).setAttribute("img","avanzar_on" );
      ((Element)v.get(239)).setAttribute("tipo","0" );
      ((Element)v.get(239)).setAttribute("estado","false" );
      ((Element)v.get(239)).setAttribute("alt","" );
      ((Element)v.get(239)).setAttribute("codigo","" );
      ((Element)v.get(239)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */
      /* Termina nodo:189   */

      /* Empieza nodo:240 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(240)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(240)).setAttribute("x","20" );
      ((Element)v.get(240)).setAttribute("y","787" );
      ((Element)v.get(240)).setAttribute("ID","botonContenido" );
      ((Element)v.get(240)).setAttribute("tipo","html" );
      ((Element)v.get(240)).setAttribute("estado","false" );
      ((Element)v.get(240)).setAttribute("cod","1254" );
      ((Element)v.get(240)).setAttribute("accion","botonEliminar();" );
      ((Element)v.get(240)).setAttribute("onshtab","tabGenerico('Eliminar','sh');" );
      ((Element)v.get(240)).setAttribute("ontab","tabGenerico('Eliminar');" );
      ((Element)v.get(10)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(241)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(241)).setAttribute("alto","12" );
      ((Element)v.get(241)).setAttribute("ancho","50" );
      ((Element)v.get(241)).setAttribute("colorf","" );
      ((Element)v.get(241)).setAttribute("borde","0" );
      ((Element)v.get(241)).setAttribute("imagenf","" );
      ((Element)v.get(241)).setAttribute("repeat","" );
      ((Element)v.get(241)).setAttribute("padding","" );
      ((Element)v.get(241)).setAttribute("visibilidad","visible" );
      ((Element)v.get(241)).setAttribute("contravsb","" );
      ((Element)v.get(241)).setAttribute("x","0" );
      ((Element)v.get(241)).setAttribute("y","809" );
      ((Element)v.get(241)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:10   */


   }

}
