
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ofertas_consultar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         

      getXML2880(doc);
         

      getXML2970(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ofertas_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0182" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Ofertas" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar Ofertas" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    DrdEnsanchaConMargenDcho('listado2',12);\r    DrdEnsanchaConMargenDcho('listado3',36);\r    DrdEnsanchaConMargenDcho('listado4',36);\r    DrdEnsanchaConMargenDcho('listado5',22);\r    eval (ON_RSZ);  \r   }\r   \r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(4)).setAttribute("nombre","capaespacio" );
      ((Element)v.get(4)).setAttribute("x","0" );
      ((Element)v.get(4)).setAttribute("y","0" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(5)).setAttribute("width","100%" );
      ((Element)v.get(5)).setAttribute("border","0" );
      ((Element)v.get(5)).setAttribute("cellspacing","0" );
      ((Element)v.get(5)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("td"));
      ((Element)v.get(7)).setAttribute("width","12" );
      ((Element)v.get(7)).setAttribute("align","center" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(8)).setAttribute("src","b.gif" );
      ((Element)v.get(8)).setAttribute("width","12" );
      ((Element)v.get(8)).setAttribute("height","12" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).setAttribute("width","750" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","b.gif" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("width","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","b.gif" );
      ((Element)v.get(12)).setAttribute("width","12" );
      ((Element)v.get(12)).setAttribute("height","1" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */
      /* Termina nodo:6   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(5)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(15)).setAttribute("src","b.gif" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(18)).setAttribute("class","legend" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(19)).setAttribute("nombre","lblDatosOferta" );
      ((Element)v.get(19)).setAttribute("ancho","120" );
      ((Element)v.get(19)).setAttribute("alto","13" );
      ((Element)v.get(19)).setAttribute("filas","1" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(19)).setAttribute("id","legend" );
      ((Element)v.get(19)).setAttribute("cod","00113" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("colspan","4" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","8" );
      ((Element)v.get(23)).setAttribute("height","8" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:24 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","8" );
      ((Element)v.get(26)).setAttribute("height","8" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(28)).setAttribute("nombre","lblArgumentoVenta" );
      ((Element)v.get(28)).setAttribute("ancho","90" );
      ((Element)v.get(28)).setAttribute("alto","17" );
      ((Element)v.get(28)).setAttribute("filas","1" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(28)).setAttribute("id","datosTitle" );
      ((Element)v.get(28)).setAttribute("cod","528" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","100%" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","8" );
      ((Element)v.get(30)).setAttribute("height","8" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","8" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblArgumentoVentaXX" );
      ((Element)v.get(35)).setAttribute("ancho","90" );
      ((Element)v.get(35)).setAttribute("alto","17" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","xxxx" );
      ((Element)v.get(35)).setAttribute("id","datosCampos" );
      ((Element)v.get(35)).setAttribute("codigo","" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(31)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","576" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(31)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","1" );
      ((Element)v.get(39)).setAttribute("height","1" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:31   */

      /* Empieza nodo:40 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(40));

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
      /* Termina nodo:20   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:43 / Elemento padre: 13   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:13   */

      /* Empieza nodo:45 / Elemento padre: 5   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(5)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","756" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("height","1" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:45   */
      /* Termina nodo:5   */

      /* Empieza nodo:52 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(52)).setAttribute("nombre","capaProductoPrincipal" );
      ((Element)v.get(52)).setAttribute("alto","30" );
      ((Element)v.get(52)).setAttribute("ancho","100%" );
      ((Element)v.get(52)).setAttribute("colorf","" );
      ((Element)v.get(52)).setAttribute("borde","0" );
      ((Element)v.get(52)).setAttribute("imagenf","" );
      ((Element)v.get(52)).setAttribute("repeat","" );
      ((Element)v.get(52)).setAttribute("padding","" );
      ((Element)v.get(52)).setAttribute("visibilidad","visible" );
      ((Element)v.get(52)).setAttribute("contravsb","" );
      ((Element)v.get(52)).setAttribute("x","0" );
      ((Element)v.get(52)).setAttribute("y","95" );
      ((Element)v.get(52)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","12" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("height","1" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","750" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(60)).setAttribute("height","5" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:54   */

      /* Empieza nodo:61 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(66)).setAttribute("border","0" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(68)).setAttribute("valign","middle" );
      ((Element)v.get(68)).setAttribute("width","4" );
      ((Element)v.get(68)).setAttribute("height","4" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","5" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(70)).setAttribute("valign","middle" );
      ((Element)v.get(70)).setAttribute("height","20" );
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lbltitulo1" );
      ((Element)v.get(71)).setAttribute("ancho","666" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","579" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:72 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(61)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("height","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:61   */

      /* Empieza nodo:74 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","1" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","750" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","12" );
      ((Element)v.get(80)).setAttribute("height","5" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:74   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:81 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(81)).setAttribute("nombre","listado1" );
      ((Element)v.get(81)).setAttribute("ancho","677" );
      ((Element)v.get(81)).setAttribute("alto","290" );
      ((Element)v.get(81)).setAttribute("x","12" );
      ((Element)v.get(81)).setAttribute("y","124" );
      ((Element)v.get(81)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(81)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(82)).setAttribute("precarga","S" );
      ((Element)v.get(82)).setAttribute("conROver","S" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(83)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(83)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(83)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(83)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(84)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(84)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(84)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(84)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 81   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(81)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(86)).setAttribute("borde","1" );
      ((Element)v.get(86)).setAttribute("horizDatos","1" );
      ((Element)v.get(86)).setAttribute("horizCabecera","1" );
      ((Element)v.get(86)).setAttribute("vertical","0" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 85   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(87)).setAttribute("borde","#999999" );
      ((Element)v.get(87)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(87)).setAttribute("vertDatos","#999999" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(87)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(85)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 81   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(88)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(88)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(88)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(88)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(88)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(81)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("ancho","100" );
      ((Element)v.get(89)).setAttribute("minimizable","S" );
      ((Element)v.get(89)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","60" );
      ((Element)v.get(90)).setAttribute("minimizable","S" );
      ((Element)v.get(90)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","100" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","100" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","120" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","100" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","100" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:88   */

      /* Empieza nodo:96 / Elemento padre: 81   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(96)).setAttribute("alto","20" );
      ((Element)v.get(96)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(81)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("cod","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Elemento padre:97 / Elemento actual: 98   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(97)).appendChild((Text)v.get(98));

      /* Termina nodo Texto:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("colFondo","" );
      ((Element)v.get(99)).setAttribute("ID","EstCab" );
      ((Element)v.get(99)).setAttribute("cod","9" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Elemento padre:99 / Elemento actual: 100   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(99)).appendChild((Text)v.get(100));

      /* Termina nodo Texto:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","529" );
      ((Element)v.get(96)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","530" );
      ((Element)v.get(96)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","481" );
      ((Element)v.get(96)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","482" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(96)).appendChild((Element)v.get(107));

      /* Elemento padre:107 / Elemento actual: 108   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(107)).appendChild((Text)v.get(108));

      /* Termina nodo Texto:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","483" );
      ((Element)v.get(96)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */
      /* Termina nodo:96   */

      /* Empieza nodo:111 / Elemento padre: 81   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(111)).setAttribute("alto","22" );
      ((Element)v.get(111)).setAttribute("accion","" );
      ((Element)v.get(111)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(111)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(111)).setAttribute("maxSel","-1" );
      ((Element)v.get(111)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(111)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(111)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(111)).setAttribute("onLoad","" );
      ((Element)v.get(111)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(81)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("tipo","texto" );
      ((Element)v.get(112)).setAttribute("ID","EstDat" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("tipo","texto" );
      ((Element)v.get(113)).setAttribute("ID","EstDat2" );
      ((Element)v.get(111)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("tipo","texto" );
      ((Element)v.get(114)).setAttribute("ID","EstDat" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat2" );
      ((Element)v.get(111)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(111)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat2" );
      ((Element)v.get(111)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat" );
      ((Element)v.get(111)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:111   */

      /* Empieza nodo:119 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 81   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(120)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(120)).setAttribute("ancho","680" );
      ((Element)v.get(120)).setAttribute("sep","$" );
      ((Element)v.get(120)).setAttribute("x","12" );
      ((Element)v.get(120)).setAttribute("class","botonera" );
      ((Element)v.get(120)).setAttribute("y","375" );
      ((Element)v.get(120)).setAttribute("control","|" );
      ((Element)v.get(120)).setAttribute("conector","" );
      ((Element)v.get(120)).setAttribute("rowset","" );
      ((Element)v.get(120)).setAttribute("cargainicial","N" );
      ((Element)v.get(81)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(121)).setAttribute("nombre","primera1" );
      ((Element)v.get(121)).setAttribute("x","24" );
      ((Element)v.get(121)).setAttribute("y","379" );
      ((Element)v.get(121)).setAttribute("ID","botonContenido" );
      ((Element)v.get(121)).setAttribute("img","primera_on" );
      ((Element)v.get(121)).setAttribute("tipo","1" );
      ((Element)v.get(121)).setAttribute("estado","false" );
      ((Element)v.get(121)).setAttribute("alt","" );
      ((Element)v.get(121)).setAttribute("codigo","" );
      ((Element)v.get(121)).setAttribute("accion","" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 120   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(122)).setAttribute("nombre","ava1" );
      ((Element)v.get(122)).setAttribute("x","59" );
      ((Element)v.get(122)).setAttribute("y","379" );
      ((Element)v.get(122)).setAttribute("ID","botonContenido" );
      ((Element)v.get(122)).setAttribute("img","avanzar_on" );
      ((Element)v.get(122)).setAttribute("tipo","0" );
      ((Element)v.get(122)).setAttribute("estado","false" );
      ((Element)v.get(122)).setAttribute("alt","" );
      ((Element)v.get(122)).setAttribute("codigo","" );
      ((Element)v.get(122)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(120)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(123)).setAttribute("nombre","ret1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(123)).setAttribute("x","44" );
      ((Element)v.get(123)).setAttribute("y","379" );
      ((Element)v.get(123)).setAttribute("ID","botonContenido" );
      ((Element)v.get(123)).setAttribute("img","retroceder_on" );
      ((Element)v.get(123)).setAttribute("tipo","0" );
      ((Element)v.get(123)).setAttribute("estado","false" );
      ((Element)v.get(123)).setAttribute("alt","" );
      ((Element)v.get(123)).setAttribute("codigo","" );
      ((Element)v.get(123)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:120   */
      /* Termina nodo:81   */

      /* Empieza nodo:124 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(124)).setAttribute("nombre","capaProductoAsociado" );
      ((Element)v.get(124)).setAttribute("alto","30" );
      ((Element)v.get(124)).setAttribute("ancho","100%" );
      ((Element)v.get(124)).setAttribute("colorf","" );
      ((Element)v.get(124)).setAttribute("borde","0" );
      ((Element)v.get(124)).setAttribute("imagenf","" );
      ((Element)v.get(124)).setAttribute("repeat","" );
      ((Element)v.get(124)).setAttribute("padding","" );
      ((Element)v.get(124)).setAttribute("visibilidad","visible" );
      ((Element)v.get(124)).setAttribute("contravsb","" );
      ((Element)v.get(124)).setAttribute("x","0" );
      ((Element)v.get(124)).setAttribute("y","433" );
      ((Element)v.get(124)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("table"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("align","center" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("height","1" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","750" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(132)).setAttribute("height","5" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:126   */

      /* Empieza nodo:133 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("cellpadding","0" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(140)).setAttribute("valign","middle" );
      ((Element)v.get(140)).setAttribute("width","4" );
      ((Element)v.get(140)).setAttribute("height","4" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","5" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("bgcolor","#CCCCCC" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(142)).setAttribute("valign","middle" );
      ((Element)v.get(142)).setAttribute("height","20" );
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lbltitulo2" );
      ((Element)v.get(143)).setAttribute("ancho","666" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("valor","" );
      ((Element)v.get(143)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).setAttribute("cod","532" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:144 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(133)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("height","12" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:133   */

      /* Empieza nodo:146 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","12" );
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","1" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","750" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("height","5" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:146   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:153 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(153)).setAttribute("nombre","listado2" );
      ((Element)v.get(153)).setAttribute("ancho","677" );
      ((Element)v.get(153)).setAttribute("alto","290" );
      ((Element)v.get(153)).setAttribute("x","12" );
      ((Element)v.get(153)).setAttribute("y","462" );
      ((Element)v.get(153)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(153)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(154)).setAttribute("precarga","S" );
      ((Element)v.get(154)).setAttribute("conROver","S" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(155)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(155)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(155)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(155)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 154   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(156)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(156)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(156)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(156)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 153   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(153)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(158)).setAttribute("borde","1" );
      ((Element)v.get(158)).setAttribute("horizDatos","1" );
      ((Element)v.get(158)).setAttribute("horizCabecera","1" );
      ((Element)v.get(158)).setAttribute("vertical","0" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 157   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(159)).setAttribute("borde","#999999" );
      ((Element)v.get(159)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(159)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(159)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(159)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(157)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:157   */

      /* Empieza nodo:160 / Elemento padre: 153   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(160)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(160)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(160)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(160)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(160)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(153)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","60" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","60" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","100" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("ancho","100" );
      ((Element)v.get(164)).setAttribute("minimizable","S" );
      ((Element)v.get(164)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","100" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","60" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 160   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","60" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(160)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:160   */

      /* Empieza nodo:168 / Elemento padre: 153   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(168)).setAttribute("alto","20" );
      ((Element)v.get(168)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(168)).setAttribute("imgFondo","" );
      ((Element)v.get(168)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(153)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Elemento padre:169 / Elemento actual: 170   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(169)).appendChild((Text)v.get(170));

      /* Termina nodo Texto:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","9" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Elemento padre:171 / Elemento actual: 172   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(171)).appendChild((Text)v.get(172));

      /* Termina nodo Texto:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","529" );
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Elemento padre:173 / Elemento actual: 174   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(173)).appendChild((Text)v.get(174));

      /* Termina nodo Texto:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","530" );
      ((Element)v.get(168)).appendChild((Element)v.get(175));

      /* Elemento padre:175 / Elemento actual: 176   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(175)).appendChild((Text)v.get(176));

      /* Termina nodo Texto:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","481" );
      ((Element)v.get(168)).appendChild((Element)v.get(177));

      /* Elemento padre:177 / Elemento actual: 178   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(177)).appendChild((Text)v.get(178));

      /* Termina nodo Texto:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","482" );
      ((Element)v.get(168)).appendChild((Element)v.get(179));

      /* Elemento padre:179 / Elemento actual: 180   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(179)).appendChild((Text)v.get(180));

      /* Termina nodo Texto:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","483" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(168)).appendChild((Element)v.get(181));

      /* Elemento padre:181 / Elemento actual: 182   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(181)).appendChild((Text)v.get(182));

      /* Termina nodo Texto:182   */
      /* Termina nodo:181   */
      /* Termina nodo:168   */

      /* Empieza nodo:183 / Elemento padre: 153   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(183)).setAttribute("alto","22" );
      ((Element)v.get(183)).setAttribute("accion","" );
      ((Element)v.get(183)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(183)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(183)).setAttribute("maxSel","-1" );
      ((Element)v.get(183)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(183)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(183)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(183)).setAttribute("onLoad","" );
      ((Element)v.get(183)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(153)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("tipo","texto" );
      ((Element)v.get(184)).setAttribute("ID","EstDat" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("tipo","texto" );
      ((Element)v.get(185)).setAttribute("ID","EstDat2" );
      ((Element)v.get(183)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat" );
      ((Element)v.get(183)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat2" );
      ((Element)v.get(183)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat" );
      ((Element)v.get(183)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat2" );
      ((Element)v.get(183)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat" );
      ((Element)v.get(183)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:183   */

      /* Empieza nodo:191 / Elemento padre: 153   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(153)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 153   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(192)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(192)).setAttribute("ancho","680" );
      ((Element)v.get(192)).setAttribute("sep","$" );
      ((Element)v.get(192)).setAttribute("x","12" );
      ((Element)v.get(192)).setAttribute("class","botonera" );
      ((Element)v.get(192)).setAttribute("y","714" );
      ((Element)v.get(192)).setAttribute("control","|" );
      ((Element)v.get(192)).setAttribute("conector","" );
      ((Element)v.get(192)).setAttribute("rowset","" );
      ((Element)v.get(192)).setAttribute("cargainicial","N" );
      ((Element)v.get(153)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(193)).setAttribute("nombre","primera2" );
      ((Element)v.get(193)).setAttribute("x","24" );
      ((Element)v.get(193)).setAttribute("y","718" );
      ((Element)v.get(193)).setAttribute("ID","botonContenido" );
      ((Element)v.get(193)).setAttribute("img","primera_on" );
      ((Element)v.get(193)).setAttribute("tipo","1" );
      ((Element)v.get(193)).setAttribute("estado","false" );
      ((Element)v.get(193)).setAttribute("alt","" );
      ((Element)v.get(193)).setAttribute("codigo","" );
      ((Element)v.get(193)).setAttribute("accion","" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 192   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(194)).setAttribute("nombre","ava2" );
      ((Element)v.get(194)).setAttribute("x","59" );
      ((Element)v.get(194)).setAttribute("y","718" );
      ((Element)v.get(194)).setAttribute("ID","botonContenido" );
      ((Element)v.get(194)).setAttribute("img","avanzar_on" );
      ((Element)v.get(194)).setAttribute("tipo","0" );
      ((Element)v.get(194)).setAttribute("estado","false" );
      ((Element)v.get(194)).setAttribute("alt","" );
      ((Element)v.get(194)).setAttribute("codigo","" );
      ((Element)v.get(194)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(192)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(195)).setAttribute("nombre","ret2" );
      ((Element)v.get(195)).setAttribute("x","44" );
      ((Element)v.get(195)).setAttribute("y","718" );
      ((Element)v.get(195)).setAttribute("ID","botonContenido" );
      ((Element)v.get(195)).setAttribute("img","retroceder_on" );
      ((Element)v.get(195)).setAttribute("tipo","0" );
      ((Element)v.get(195)).setAttribute("estado","false" );
      ((Element)v.get(195)).setAttribute("alt","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(195)).setAttribute("codigo","" );
      ((Element)v.get(195)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(192)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:192   */
      /* Termina nodo:153   */

      /* Empieza nodo:196 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(196)).setAttribute("nombre","capaDatosGenerales" );
      ((Element)v.get(196)).setAttribute("alto","200" );
      ((Element)v.get(196)).setAttribute("ancho","100%" );
      ((Element)v.get(196)).setAttribute("colorf","" );
      ((Element)v.get(196)).setAttribute("borde","0" );
      ((Element)v.get(196)).setAttribute("imagenf","" );
      ((Element)v.get(196)).setAttribute("repeat","" );
      ((Element)v.get(196)).setAttribute("padding","" );
      ((Element)v.get(196)).setAttribute("visibilidad","visible" );
      ((Element)v.get(196)).setAttribute("contravsb","" );
      ((Element)v.get(196)).setAttribute("x","0" );
      ((Element)v.get(196)).setAttribute("y","759" );
      ((Element)v.get(196)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("table"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(197)).setAttribute("border","0" );
      ((Element)v.get(197)).setAttribute("cellspacing","0" );
      ((Element)v.get(197)).setAttribute("cellpadding","0" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(199)).setAttribute("align","center" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","12" );
      ((Element)v.get(200)).setAttribute("height","12" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","750" );
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("width","12" );
      ((Element)v.get(198)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","12" );
      ((Element)v.get(204)).setAttribute("height","1" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:198   */

      /* Empieza nodo:205 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(210)).setAttribute("class","legend" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(211)).setAttribute("ancho","120" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("id","legend" );
      ((Element)v.get(211)).setAttribute("cod","0011" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("table"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(212)).setAttribute("border","0" );
      ((Element)v.get(212)).setAttribute("align","center" );
      ((Element)v.get(212)).setAttribute("cellspacing","0" );
      ((Element)v.get(212)).setAttribute("cellpadding","0" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("colspan","4" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:216 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(212)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblNumeroGrupos" );
      ((Element)v.get(220)).setAttribute("ancho","50" );
      ((Element)v.get(220)).setAttribute("alto","17" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","533" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lblNumeroPaquetes" );
      ((Element)v.get(224)).setAttribute("ancho","65" );
      ((Element)v.get(224)).setAttribute("alto","17" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("id","datosTitle" );
      ((Element)v.get(224)).setAttribute("cod","534" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lblNumeroGruposCondicionantes" );
      ((Element)v.get(228)).setAttribute("ancho","130" );
      ((Element)v.get(228)).setAttribute("alto","17" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("id","datosTitle" );
      ((Element)v.get(228)).setAttribute("cod","535" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","25" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lblCondicionCondicionantes" );
      ((Element)v.get(232)).setAttribute("ancho","80" );
      ((Element)v.get(232)).setAttribute("alto","17" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(232)).setAttribute("id","datosTitle" );
      ((Element)v.get(232)).setAttribute("cod","536" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","25" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(236)).setAttribute("nombre","lblNumeroGruposCondicionados" );
      ((Element)v.get(236)).setAttribute("ancho","120" );
      ((Element)v.get(236)).setAttribute("alto","17" );
      ((Element)v.get(236)).setAttribute("filas","1" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("id","datosTitle" );
      ((Element)v.get(236)).setAttribute("cod","537" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","25" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblCondicionCondicionados" );
      ((Element)v.get(240)).setAttribute("ancho","80" );
      ((Element)v.get(240)).setAttribute("alto","17" );
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("id","datosTitle" );
      ((Element)v.get(240)).setAttribute("cod","538" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:216   */

      /* Empieza nodo:243 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(247)).setAttribute("nombre","txtNumeroGrupos" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("max","6" );
      ((Element)v.get(247)).setAttribute("tipo","" );
      ((Element)v.get(247)).setAttribute("onchange","" );
      ((Element)v.get(247)).setAttribute("req","N" );
      ((Element)v.get(247)).setAttribute("size","6" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("validacion","" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","25" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(251)).setAttribute("nombre","txtNumeroPaquetes" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("max","6" );
      ((Element)v.get(251)).setAttribute("tipo","" );
      ((Element)v.get(251)).setAttribute("onchange","" );
      ((Element)v.get(251)).setAttribute("req","N" );
      ((Element)v.get(251)).setAttribute("size","6" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("validacion","" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","25" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(255)).setAttribute("nombre","txtNumeroGruposCondicionantes" );
      ((Element)v.get(255)).setAttribute("id","datosCampos" );
      ((Element)v.get(255)).setAttribute("max","6" );
      ((Element)v.get(255)).setAttribute("tipo","" );
      ((Element)v.get(255)).setAttribute("onchange","" );
      ((Element)v.get(255)).setAttribute("req","N" );
      ((Element)v.get(255)).setAttribute("size","6" );
      ((Element)v.get(255)).setAttribute("valor","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(255)).setAttribute("validacion","" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("table"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("class","datosCampos" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(262)).setAttribute("nombre","rbCondicionCondicionantes" );
      ((Element)v.get(262)).setAttribute("tipo","H" );
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(263)).setAttribute("valor","S" );
      ((Element)v.get(263)).setAttribute("check","N" );
      ((Element)v.get(263)).setAttribute("onfocus","" );
      ((Element)v.get(263)).setAttribute("id","datosCampos" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Elemento padre:263 / Elemento actual: 264   */
      v.add(doc.createTextNode("Y  "));
      ((Element)v.get(263)).appendChild((Text)v.get(264));

      /* Termina nodo Texto:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(265)).setAttribute("valor","N" );
      ((Element)v.get(265)).setAttribute("onfocus","" );
      ((Element)v.get(265)).setAttribute("id","datosCampos" );
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Elemento padre:265 / Elemento actual: 266   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(265)).appendChild((Text)v.get(266));

      /* Termina nodo Texto:266   */
      /* Termina nodo:265   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:267 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","25" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(270)).setAttribute("nombre","txtNumeroGruposCondicionados" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("max","6" );
      ((Element)v.get(270)).setAttribute("tipo","" );
      ((Element)v.get(270)).setAttribute("onchange","" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("size","6" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("validacion","" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("table"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("class","datosCampos" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(277)).setAttribute("nombre","rbCondicionCondicionados" );
      ((Element)v.get(277)).setAttribute("tipo","H" );
      ((Element)v.get(277)).setAttribute("id","datosCampos" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(278)).setAttribute("valor","S" );
      ((Element)v.get(278)).setAttribute("check","N" );
      ((Element)v.get(278)).setAttribute("onfocus","" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Elemento padre:278 / Elemento actual: 279   */
      v.add(doc.createTextNode("Y  "));
      ((Element)v.get(278)).appendChild((Text)v.get(279));

      /* Termina nodo Texto:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(280)).setAttribute("valor","N" );
      ((Element)v.get(280)).setAttribute("onfocus","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(280)).setAttribute("id","datosCampos" );
      ((Element)v.get(277)).appendChild((Element)v.get(280));

      /* Elemento padre:280 / Elemento actual: 281   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(280)).appendChild((Text)v.get(281));

      /* Termina nodo Texto:281   */
      /* Termina nodo:280   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:282 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("width","19" );
      ((Element)v.get(243)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","19" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(243)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","1" );
      ((Element)v.get(285)).setAttribute("height","1" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:243   */
      /* Termina nodo:212   */

      /* Empieza nodo:286 / Elemento padre: 209   */
      v.add(doc.createElement("table"));
      ((Element)v.get(286)).setAttribute("width","100%" );
      ((Element)v.get(286)).setAttribute("border","0" );
      ((Element)v.get(286)).setAttribute("align","center" );
      ((Element)v.get(286)).setAttribute("cellspacing","0" );
      ((Element)v.get(286)).setAttribute("cellpadding","0" );
      ((Element)v.get(209)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("colspan","4" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:290 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(294)).setAttribute("nombre","lblDespachoCompleto" );
      ((Element)v.get(294)).setAttribute("ancho","100" );
      ((Element)v.get(294)).setAttribute("alto","17" );
      ((Element)v.get(294)).setAttribute("filas","1" );
      ((Element)v.get(294)).setAttribute("valor","" );
      ((Element)v.get(294)).setAttribute("id","datosTitle" );
      ((Element)v.get(294)).setAttribute("cod","539" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(298)).setAttribute("nombre","lblDespachoAutomatico" );
      ((Element)v.get(298)).setAttribute("ancho","110" );
      ((Element)v.get(298)).setAttribute("alto","17" );
      ((Element)v.get(298)).setAttribute("filas","1" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("id","datosTitle" );
      ((Element)v.get(298)).setAttribute("cod","540" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","25" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(302)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(302)).setAttribute("ancho","60" );
      ((Element)v.get(302)).setAttribute("alto","17" );
      ((Element)v.get(302)).setAttribute("filas","1" );
      ((Element)v.get(302)).setAttribute("valor","" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(302)).setAttribute("id","datosTitle" );
      ((Element)v.get(302)).setAttribute("cod","541" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","25" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(306)).setAttribute("nombre","lblRecuperacionObligatoriaSiPedido" );
      ((Element)v.get(306)).setAttribute("ancho","170" );
      ((Element)v.get(306)).setAttribute("alto","17" );
      ((Element)v.get(306)).setAttribute("filas","1" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("id","datosTitle" );
      ((Element)v.get(306)).setAttribute("cod","601" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(290)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:290   */

      /* Empieza nodo:309 / Elemento padre: 286   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(286)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(313)).setAttribute("nombre","ckDespachoCompleto" );
      ((Element)v.get(313)).setAttribute("texto","" );
      ((Element)v.get(313)).setAttribute("check","N" );
      ((Element)v.get(313)).setAttribute("validacion","" );
      ((Element)v.get(313)).setAttribute("req","N" );
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).setAttribute("ontab","" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","25" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(317)).setAttribute("nombre","ckDespachoAutomatico" );
      ((Element)v.get(317)).setAttribute("texto","" );
      ((Element)v.get(317)).setAttribute("check","N" );
      ((Element)v.get(317)).setAttribute("validacion","" );
      ((Element)v.get(317)).setAttribute("req","N" );
      ((Element)v.get(317)).setAttribute("id","datosCampos" );
      ((Element)v.get(317)).setAttribute("ontab","" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","25" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(321)).setAttribute("nombre","ckRecuperacionObligatoriaSiPedido" );
      ((Element)v.get(321)).setAttribute("texto","" );
      ((Element)v.get(321)).setAttribute("check","N" );
      ((Element)v.get(321)).setAttribute("validacion","" );
      ((Element)v.get(321)).setAttribute("req","N" );
      ((Element)v.get(321)).setAttribute("id","datosCampos" );
      ((Element)v.get(321)).setAttribute("ontab","" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(325)).setAttribute("nombre","txtFormaPago" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).setAttribute("max","2" );
      ((Element)v.get(325)).setAttribute("tipo","" );
      ((Element)v.get(325)).setAttribute("onchange","" );
      ((Element)v.get(325)).setAttribute("req","N" );
      ((Element)v.get(325)).setAttribute("size","2" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("validacion","" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","35" );
      ((Element)v.get(309)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","35" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","100%" );
      ((Element)v.get(309)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","1" );
      ((Element)v.get(329)).setAttribute("height","1" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:309   */
      /* Termina nodo:286   */

      /* Empieza nodo:330 / Elemento padre: 209   */
      v.add(doc.createElement("table"));
      ((Element)v.get(330)).setAttribute("width","100%" );
      ((Element)v.get(330)).setAttribute("border","0" );
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(330)).setAttribute("cellspacing","0" );
      ((Element)v.get(330)).setAttribute("cellpadding","0" );
      ((Element)v.get(209)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("colspan","4" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:334 / Elemento padre: 330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(330)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lblPrimerNumeroRanking" );
      ((Element)v.get(338)).setAttribute("ancho","90" );
      ((Element)v.get(338)).setAttribute("alto","17" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("id","datosTitle" );
      ((Element)v.get(338)).setAttribute("cod","484" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","25" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(342)).setAttribute("nombre","lblSegundoNumeroRanking" );
      ((Element)v.get(342)).setAttribute("ancho","90" );
      ((Element)v.get(342)).setAttribute("alto","17" );
      ((Element)v.get(342)).setAttribute("filas","1" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("id","datosTitle" );
      ((Element)v.get(342)).setAttribute("cod","485" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("width","100%" );
      ((Element)v.get(334)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:334   */

      /* Empieza nodo:345 / Elemento padre: 330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(330)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","8" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(349)).setAttribute("nombre","txtPrimerNumeroRanking" );
      ((Element)v.get(349)).setAttribute("id","datosCampos" );
      ((Element)v.get(349)).setAttribute("max","2" );
      ((Element)v.get(349)).setAttribute("tipo","" );
      ((Element)v.get(349)).setAttribute("onchange","" );
      ((Element)v.get(349)).setAttribute("req","N" );
      ((Element)v.get(349)).setAttribute("size","2" );
      ((Element)v.get(349)).setAttribute("valor","" );
      ((Element)v.get(349)).setAttribute("validacion","" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","25" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(353)).setAttribute("nombre","txtSegundoNumeroRanking" );
      ((Element)v.get(353)).setAttribute("id","datosCampos" );
      ((Element)v.get(353)).setAttribute("max","2" );
      ((Element)v.get(353)).setAttribute("tipo","" );
      ((Element)v.get(353)).setAttribute("onchange","" );
      ((Element)v.get(353)).setAttribute("req","N" );
      ((Element)v.get(353)).setAttribute("size","2" );
      ((Element)v.get(353)).setAttribute("valor","" );
      ((Element)v.get(353)).setAttribute("validacion","" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("width","35" );
      ((Element)v.get(345)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","35" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(345)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","1" );
      ((Element)v.get(357)).setAttribute("height","1" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:345   */

      /* Empieza nodo:358 / Elemento padre: 330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(330)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("colspan","4" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:330   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:361 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:205   */

      /* Empieza nodo:363 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("width","12" );
      ((Element)v.get(364)).setAttribute("align","center" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","12" );
      ((Element)v.get(365)).setAttribute("height","12" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","756" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","12" );
      ((Element)v.get(363)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","12" );
      ((Element)v.get(369)).setAttribute("height","1" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:363   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:370 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(370)).setAttribute("nombre","capaPromocion" );
      ((Element)v.get(370)).setAttribute("alto","750" );
      ((Element)v.get(370)).setAttribute("ancho","100%" );
      ((Element)v.get(370)).setAttribute("colorf","" );
      ((Element)v.get(370)).setAttribute("borde","0" );
      ((Element)v.get(370)).setAttribute("imagenf","" );
      ((Element)v.get(370)).setAttribute("repeat","" );
      ((Element)v.get(370)).setAttribute("padding","" );
      ((Element)v.get(370)).setAttribute("visibilidad","visible" );
      ((Element)v.get(370)).setAttribute("contravsb","" );
      ((Element)v.get(370)).setAttribute("x","0" );
      ((Element)v.get(370)).setAttribute("y","934" );
      ((Element)v.get(370)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("table"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(371)).setAttribute("border","0" );
      ((Element)v.get(371)).setAttribute("cellspacing","0" );
      ((Element)v.get(371)).setAttribute("cellpadding","0" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(374)).setAttribute("height","12" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("width","750" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","1" );
      ((Element)v.get(376)).setAttribute("height","1" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(378)).setAttribute("height","12" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:372   */

      /* Empieza nodo:379 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("width","12" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","12" );
      ((Element)v.get(381)).setAttribute("height","12" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(384)).setAttribute("class","legend" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(385)).setAttribute("nombre","lblPromociones" );
      ((Element)v.get(385)).setAttribute("ancho","105" );
      ((Element)v.get(385)).setAttribute("alto","13" );
      ((Element)v.get(385)).setAttribute("filas","1" );
      ((Element)v.get(385)).setAttribute("valor","" );
      ((Element)v.get(385)).setAttribute("id","legend" );
      ((Element)v.get(385)).setAttribute("cod","00117" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("table"));
      ((Element)v.get(386)).setAttribute("width","100%" );
      ((Element)v.get(386)).setAttribute("border","0" );
      ((Element)v.get(386)).setAttribute("align","center" );
      ((Element)v.get(386)).setAttribute("cellspacing","0" );
      ((Element)v.get(386)).setAttribute("cellpadding","0" );
      ((Element)v.get(383)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).setAttribute("colspan","4" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","12" );
      ((Element)v.get(389)).setAttribute("height","12" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:390 / Elemento padre: 386   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(386)).appendChild((Element)v.get(390));

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
      ((Element)v.get(393)).setAttribute("colspan","7" );
      ((Element)v.get(393)).setAttribute("width","100%" );
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("table"));
      ((Element)v.get(394)).setAttribute("width","100%" );
      ((Element)v.get(394)).setAttribute("border","0" );
      ((Element)v.get(394)).setAttribute("cellspacing","0" );
      ((Element)v.get(394)).setAttribute("cellpadding","0" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("table"));
      ((Element)v.get(398)).setAttribute("width","100%" );
      ((Element)v.get(398)).setAttribute("border","0" );
      ((Element)v.get(398)).setAttribute("align","center" );
      ((Element)v.get(398)).setAttribute("cellspacing","0" );
      ((Element)v.get(398)).setAttribute("cellpadding","0" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("colspan","4" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:402 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(406)).setAttribute("nombre","lblNumeroCondicion12" );
      ((Element)v.get(406)).setAttribute("ancho","110" );
      ((Element)v.get(406)).setAttribute("alto","17" );
      ((Element)v.get(406)).setAttribute("filas","1" );
      ((Element)v.get(406)).setAttribute("valor","" );
      ((Element)v.get(406)).setAttribute("id","datosTitle" );
      ((Element)v.get(406)).setAttribute("cod","004" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","25" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(410)).setAttribute("nombre","lblIndicadorCuadre12" );
      ((Element)v.get(410)).setAttribute("ancho","110" );
      ((Element)v.get(410)).setAttribute("alto","17" );
      ((Element)v.get(410)).setAttribute("filas","1" );
      ((Element)v.get(410)).setAttribute("valor","" );
      ((Element)v.get(410)).setAttribute("id","datosTitle" );
      ((Element)v.get(410)).setAttribute("cod","005" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 402   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","25" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lblFactorCuadre12" );
      ((Element)v.get(414)).setAttribute("ancho","130" );
      ((Element)v.get(414)).setAttribute("alto","17" );
      ((Element)v.get(414)).setAttribute("filas","1" );
      ((Element)v.get(414)).setAttribute("valor","" );
      ((Element)v.get(414)).setAttribute("id","datosTitle" );
      ((Element)v.get(414)).setAttribute("cod","006" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).setAttribute("width","88" );
      ((Element)v.get(402)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","236" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).setAttribute("width","100%" );
      ((Element)v.get(402)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","8" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:402   */

      /* Empieza nodo:419 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","8" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(423)).setAttribute("nombre","lblNumeroCondicionXX2" );
      ((Element)v.get(423)).setAttribute("ancho","60" );
      ((Element)v.get(423)).setAttribute("alto","17" );
      ((Element)v.get(423)).setAttribute("filas","1" );
      ((Element)v.get(423)).setAttribute("valor","xxx" );
      ((Element)v.get(423)).setAttribute("id","datosCampos" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","25" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(427)).setAttribute("nombre","lblIndicadorCuadreXX2" );
      ((Element)v.get(427)).setAttribute("ancho","90" );
      ((Element)v.get(427)).setAttribute("alto","17" );
      ((Element)v.get(427)).setAttribute("filas","1" );
      ((Element)v.get(427)).setAttribute("valor","x" );
      ((Element)v.get(427)).setAttribute("id","datosCampos" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","25" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(431)).setAttribute("nombre","lblFactorCuadreXX2" );
      ((Element)v.get(431)).setAttribute("ancho","130" );
      ((Element)v.get(431)).setAttribute("alto","17" );
      ((Element)v.get(431)).setAttribute("filas","1" );
      ((Element)v.get(431)).setAttribute("valor","xxxxxxxxxx" );
      ((Element)v.get(431)).setAttribute("id","datosCampos" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(432)).setAttribute("width","1" );
      ((Element)v.get(419)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","8" );
      ((Element)v.get(433)).setAttribute("height","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("width","100%" );
      ((Element)v.get(419)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:419   */

      /* Empieza nodo:436 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(437)).setAttribute("colspan","4" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(438)).setAttribute("height","310" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:439 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","12" );
      ((Element)v.get(440)).setAttribute("height","12" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:390   */

      /* Empieza nodo:441 / Elemento padre: 386   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(386)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).setAttribute("colspan","4" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","12" );
      ((Element)v.get(443)).setAttribute("height","12" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:386   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:444 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","12" );
      ((Element)v.get(445)).setAttribute("height","12" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:379   */

      /* Empieza nodo:446 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).setAttribute("width","12" );
      ((Element)v.get(447)).setAttribute("align","center" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","12" );
      ((Element)v.get(448)).setAttribute("height","12" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).setAttribute("width","750" );
      ((Element)v.get(446)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("width","12" );
      ((Element)v.get(446)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","12" );
      ((Element)v.get(452)).setAttribute("height","12" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:446   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:453 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(453)).setAttribute("nombre","listado3" );
      ((Element)v.get(453)).setAttribute("ancho","637" );
      ((Element)v.get(453)).setAttribute("alto","290" );
      ((Element)v.get(453)).setAttribute("x","32" );
      ((Element)v.get(453)).setAttribute("y","1027" );
      ((Element)v.get(453)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(453)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(454)).setAttribute("precarga","S" );
      ((Element)v.get(454)).setAttribute("conROver","S" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(455)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(455)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(455)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(455)).setAttribute("desactivado","btnLista2D.gif" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 454   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(456)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(456)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(456)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(456)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(454)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:454   */

      /* Empieza nodo:457 / Elemento padre: 453   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(453)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(458)).setAttribute("borde","1" );
      ((Element)v.get(458)).setAttribute("horizDatos","1" );
      ((Element)v.get(458)).setAttribute("horizCabecera","1" );
      ((Element)v.get(458)).setAttribute("vertical","0" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 457   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(459)).setAttribute("borde","#999999" );
      ((Element)v.get(459)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(459)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(459)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(459)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(457)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:457   */

      /* Empieza nodo:460 / Elemento padre: 453   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(460)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(460)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(460)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(460)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(460)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(453)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(461)).setAttribute("ancho","100" );
      ((Element)v.get(461)).setAttribute("minimizable","S" );
      ((Element)v.get(461)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("ancho","100" );
      ((Element)v.get(462)).setAttribute("minimizable","S" );
      ((Element)v.get(462)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(463)).setAttribute("ancho","100" );
      ((Element)v.get(463)).setAttribute("minimizable","S" );
      ((Element)v.get(463)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(464)).setAttribute("ancho","100" );
      ((Element)v.get(464)).setAttribute("minimizable","S" );
      ((Element)v.get(464)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("ancho","100" );
      ((Element)v.get(465)).setAttribute("minimizable","S" );
      ((Element)v.get(465)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:460   */

      /* Empieza nodo:466 / Elemento padre: 453   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(466)).setAttribute("alto","20" );
      ((Element)v.get(466)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(466)).setAttribute("imgFondo","" );
      ((Element)v.get(466)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(453)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(467)).setAttribute("colFondo","" );
      ((Element)v.get(467)).setAttribute("ID","EstCab" );
      ((Element)v.get(467)).setAttribute("cod","516" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("colFondo","" );
      ((Element)v.get(468)).setAttribute("ID","EstCab" );
      ((Element)v.get(468)).setAttribute("cod","593" );
      ((Element)v.get(466)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */

      /* Empieza nodo:469 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(469)).setAttribute("colFondo","" );
      ((Element)v.get(469)).setAttribute("ID","EstCab" );
      ((Element)v.get(469)).setAttribute("cod","555" );
      ((Element)v.get(466)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */

      /* Empieza nodo:470 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("colFondo","" );
      ((Element)v.get(470)).setAttribute("ID","EstCab" );
      ((Element)v.get(470)).setAttribute("cod","145" );
      ((Element)v.get(466)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 466   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(471)).setAttribute("colFondo","" );
      ((Element)v.get(471)).setAttribute("ID","EstCab" );
      ((Element)v.get(471)).setAttribute("cod","553" );
      ((Element)v.get(466)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:466   */

      /* Empieza nodo:472 / Elemento padre: 453   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(472)).setAttribute("alto","22" );
      ((Element)v.get(472)).setAttribute("accion","" );
      ((Element)v.get(472)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(472)).setAttribute("formaEnvio","xml" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(472)).setAttribute("maxSel","-1" );
      ((Element)v.get(472)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(472)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(472)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(472)).setAttribute("onLoad","" );
      ((Element)v.get(472)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(453)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(473)).setAttribute("tipo","texto" );
      ((Element)v.get(473)).setAttribute("ID","EstDat" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 472   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(474)).setAttribute("tipo","texto" );
      ((Element)v.get(474)).setAttribute("ID","EstDat2" );
      ((Element)v.get(472)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */

      /* Empieza nodo:475 / Elemento padre: 472   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(475)).setAttribute("tipo","texto" );
      ((Element)v.get(475)).setAttribute("ID","EstDat" );
      ((Element)v.get(472)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 472   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(476)).setAttribute("tipo","texto" );
      ((Element)v.get(476)).setAttribute("ID","EstDat2" );
      ((Element)v.get(472)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 472   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(477)).setAttribute("tipo","texto" );
      ((Element)v.get(477)).setAttribute("ID","EstDat" );
      ((Element)v.get(472)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:472   */

      /* Empieza nodo:478 / Elemento padre: 453   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(453)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 453   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(479)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(479)).setAttribute("ancho","680" );
      ((Element)v.get(479)).setAttribute("sep","$" );
      ((Element)v.get(479)).setAttribute("x","12" );
      ((Element)v.get(479)).setAttribute("class","botonera" );
      ((Element)v.get(479)).setAttribute("y","1279" );
      ((Element)v.get(479)).setAttribute("control","|" );
      ((Element)v.get(479)).setAttribute("conector","" );
      ((Element)v.get(479)).setAttribute("rowset","" );
      ((Element)v.get(479)).setAttribute("cargainicial","N" );
      ((Element)v.get(453)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(480)).setAttribute("nombre","primera3" );
      ((Element)v.get(480)).setAttribute("x","44" );
      ((Element)v.get(480)).setAttribute("y","1283" );
      ((Element)v.get(480)).setAttribute("ID","botonContenido" );
      ((Element)v.get(480)).setAttribute("img","primera_on" );
      ((Element)v.get(480)).setAttribute("tipo","1" );
      ((Element)v.get(480)).setAttribute("estado","false" );
      ((Element)v.get(480)).setAttribute("alt","" );
      ((Element)v.get(480)).setAttribute("codigo","" );
      ((Element)v.get(480)).setAttribute("accion","" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 479   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(481)).setAttribute("nombre","ava3" );
      ((Element)v.get(481)).setAttribute("x","79" );
      ((Element)v.get(481)).setAttribute("y","1283" );
      ((Element)v.get(481)).setAttribute("ID","botonContenido" );
      ((Element)v.get(481)).setAttribute("img","avanzar_on" );
      ((Element)v.get(481)).setAttribute("tipo","0" );
      ((Element)v.get(481)).setAttribute("estado","false" );
      ((Element)v.get(481)).setAttribute("alt","" );
      ((Element)v.get(481)).setAttribute("codigo","" );
      ((Element)v.get(481)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(479)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 479   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(482)).setAttribute("nombre","ret3" );
      ((Element)v.get(482)).setAttribute("x","64" );
      ((Element)v.get(482)).setAttribute("y","1283" );
      ((Element)v.get(482)).setAttribute("ID","botonContenido" );
      ((Element)v.get(482)).setAttribute("img","retroceder_on" );
      ((Element)v.get(482)).setAttribute("tipo","0" );
      ((Element)v.get(482)).setAttribute("estado","false" );
      ((Element)v.get(482)).setAttribute("alt","" );
      ((Element)v.get(482)).setAttribute("codigo","" );
      ((Element)v.get(482)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(479)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:479   */
      /* Termina nodo:453   */

      /* Empieza nodo:483 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(483)).setAttribute("nombre","capaGrupos" );
      ((Element)v.get(483)).setAttribute("alto","750" );
      ((Element)v.get(483)).setAttribute("ancho","100%" );
      ((Element)v.get(483)).setAttribute("colorf","" );
      ((Element)v.get(483)).setAttribute("borde","0" );
      ((Element)v.get(483)).setAttribute("imagenf","" );
      ((Element)v.get(483)).setAttribute("repeat","" );
      ((Element)v.get(483)).setAttribute("padding","" );
      ((Element)v.get(483)).setAttribute("visibilidad","visible" );
      ((Element)v.get(483)).setAttribute("contravsb","" );
      ((Element)v.get(483)).setAttribute("x","0" );
      ((Element)v.get(483)).setAttribute("y","1347" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(483)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("table"));
      ((Element)v.get(484)).setAttribute("width","100%" );
      ((Element)v.get(484)).setAttribute("border","0" );
      ((Element)v.get(484)).setAttribute("cellspacing","0" );
      ((Element)v.get(484)).setAttribute("cellpadding","0" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
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
      ((Element)v.get(488)).setAttribute("width","750" );
      ((Element)v.get(485)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","1" );
      ((Element)v.get(489)).setAttribute("height","1" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","12" );
      ((Element)v.get(491)).setAttribute("height","12" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:485   */

      /* Empieza nodo:492 / Elemento padre: 484   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(484)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).setAttribute("width","12" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","12" );
      ((Element)v.get(494)).setAttribute("height","12" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(497)).setAttribute("class","legend" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(498)).setAttribute("nombre","lblGrupos" );
      ((Element)v.get(498)).setAttribute("ancho","50" );
      ((Element)v.get(498)).setAttribute("alto","13" );
      ((Element)v.get(498)).setAttribute("filas","1" );
      ((Element)v.get(498)).setAttribute("valor","" );
      ((Element)v.get(498)).setAttribute("id","legend" );
      ((Element)v.get(498)).setAttribute("cod","545" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 496   */
      v.add(doc.createElement("table"));
      ((Element)v.get(499)).setAttribute("width","100%" );
      ((Element)v.get(499)).setAttribute("border","0" );
      ((Element)v.get(499)).setAttribute("align","center" );
      ((Element)v.get(499)).setAttribute("cellspacing","0" );
      ((Element)v.get(499)).setAttribute("cellpadding","0" );
      ((Element)v.get(496)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(501)).setAttribute("colspan","4" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","12" );
      ((Element)v.get(502)).setAttribute("height","12" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:503 / Elemento padre: 499   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(499)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).setAttribute("colspan","7" );
      ((Element)v.get(506)).setAttribute("width","100%" );
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("table"));
      ((Element)v.get(507)).setAttribute("width","100%" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(507)).setAttribute("border","0" );
      ((Element)v.get(507)).setAttribute("cellspacing","0" );
      ((Element)v.get(507)).setAttribute("cellpadding","0" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("td"));
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("table"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).setAttribute("colspan","4" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","8" );
      ((Element)v.get(514)).setAttribute("height","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:515 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","8" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lblNumeroCondicion123" );
      ((Element)v.get(519)).setAttribute("ancho","110" );
      ((Element)v.get(519)).setAttribute("alto","17" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("id","datosTitle" );
      ((Element)v.get(519)).setAttribute("cod","004" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(523)).setAttribute("nombre","lblIndicadorCuadre123" );
      ((Element)v.get(523)).setAttribute("ancho","110" );
      ((Element)v.get(523)).setAttribute("alto","17" );
      ((Element)v.get(523)).setAttribute("filas","1" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("id","datosTitle" );
      ((Element)v.get(523)).setAttribute("cod","005" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","25" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(527)).setAttribute("nombre","lblFactorCuadre123" );
      ((Element)v.get(527)).setAttribute("ancho","120" );
      ((Element)v.get(527)).setAttribute("alto","17" );
      ((Element)v.get(527)).setAttribute("filas","1" );
      ((Element)v.get(527)).setAttribute("valor","" );
      ((Element)v.get(527)).setAttribute("id","datosTitle" );
      ((Element)v.get(527)).setAttribute("cod","006" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","25" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 515   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(531)).setAttribute("nombre","lblTipoGrupo1" );
      ((Element)v.get(531)).setAttribute("ancho","130" );
      ((Element)v.get(531)).setAttribute("alto","17" );
      ((Element)v.get(531)).setAttribute("filas","1" );
      ((Element)v.get(531)).setAttribute("valor","" );
      ((Element)v.get(531)).setAttribute("id","datosTitle" );
      ((Element)v.get(531)).setAttribute("cod","479" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).setAttribute("width","88" );
      ((Element)v.get(515)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","81" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(515)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","8" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:515   */

      /* Empieza nodo:536 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","8" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(540)).setAttribute("nombre","lblNumeroCondicionXX23" );
      ((Element)v.get(540)).setAttribute("ancho","60" );
      ((Element)v.get(540)).setAttribute("alto","17" );
      ((Element)v.get(540)).setAttribute("filas","1" );
      ((Element)v.get(540)).setAttribute("valor","xxx" );
      ((Element)v.get(540)).setAttribute("id","datosCampos" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("width","25" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(544)).setAttribute("nombre","lblIndicadorCuadreXX23" );
      ((Element)v.get(544)).setAttribute("ancho","90" );
      ((Element)v.get(544)).setAttribute("alto","17" );
      ((Element)v.get(544)).setAttribute("filas","1" );
      ((Element)v.get(544)).setAttribute("valor","x" );
      ((Element)v.get(544)).setAttribute("id","datosCampos" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(546)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).setAttribute("width","25" );
      ((Element)v.get(546)).setAttribute("height","8" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:547 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(548)).setAttribute("nombre","lblFactorCuadreXX23" );
      ((Element)v.get(548)).setAttribute("ancho","130" );
      ((Element)v.get(548)).setAttribute("alto","17" );
      ((Element)v.get(548)).setAttribute("filas","1" );
      ((Element)v.get(548)).setAttribute("valor","xxxxxxxxxx" );
      ((Element)v.get(548)).setAttribute("id","datosCampos" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","25" );
      ((Element)v.get(550)).setAttribute("height","8" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(552)).setAttribute("nombre","lblTipoGrupoXX1" );
      ((Element)v.get(552)).setAttribute("ancho","130" );
      ((Element)v.get(552)).setAttribute("alto","17" );
      ((Element)v.get(552)).setAttribute("filas","1" );
      ((Element)v.get(552)).setAttribute("valor","xxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(552)).setAttribute("id","datosCampos" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).setAttribute("width","1" );
      ((Element)v.get(536)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("width","8" );
      ((Element)v.get(554)).setAttribute("height","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("width","100%" );
      ((Element)v.get(536)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","8" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:536   */

      /* Empieza nodo:557 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("colspan","4" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","310" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:560 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","12" );
      ((Element)v.get(561)).setAttribute("height","12" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:503   */

      /* Empieza nodo:562 / Elemento padre: 499   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(499)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).setAttribute("colspan","4" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","12" );
      ((Element)v.get(564)).setAttribute("height","12" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:499   */
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:565 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","12" );
      ((Element)v.get(566)).setAttribute("height","12" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:492   */

      /* Empieza nodo:567 / Elemento padre: 484   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(484)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).setAttribute("width","12" );
      ((Element)v.get(568)).setAttribute("align","center" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","12" );
      ((Element)v.get(569)).setAttribute("height","12" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 567   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).setAttribute("width","750" );
      ((Element)v.get(567)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 567   */
      v.add(doc.createElement("td"));
      ((Element)v.get(572)).setAttribute("width","12" );
      ((Element)v.get(567)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","12" );
      ((Element)v.get(573)).setAttribute("height","12" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:567   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:574 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(574)).setAttribute("nombre","listado4" );
      ((Element)v.get(574)).setAttribute("ancho","637" );
      ((Element)v.get(574)).setAttribute("alto","290" );
      ((Element)v.get(574)).setAttribute("x","32" );
      ((Element)v.get(574)).setAttribute("y","1440" );
      ((Element)v.get(574)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(574)).setAttribute("msgDebugJS","S" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(4)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(575)).setAttribute("precarga","S" );
      ((Element)v.get(575)).setAttribute("conROver","S" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(576)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(576)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(576)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(576)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */

      /* Empieza nodo:577 / Elemento padre: 575   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(577)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(577)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(577)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(577)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(575)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:575   */

      /* Empieza nodo:578 / Elemento padre: 574   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(574)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(579)).setAttribute("borde","1" );
      ((Element)v.get(579)).setAttribute("horizDatos","1" );
      ((Element)v.get(579)).setAttribute("horizCabecera","1" );
      ((Element)v.get(579)).setAttribute("vertical","0" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 578   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(580)).setAttribute("borde","#999999" );
      ((Element)v.get(580)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(580)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(580)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(580)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(578)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:578   */

      /* Empieza nodo:581 / Elemento padre: 574   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(581)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(581)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(581)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(581)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(581)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(574)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(582)).setAttribute("ancho","100" );
      ((Element)v.get(582)).setAttribute("minimizable","S" );
      ((Element)v.get(582)).setAttribute("minimizada","N" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */

      /* Empieza nodo:583 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(583)).setAttribute("ancho","100" );
      ((Element)v.get(583)).setAttribute("minimizable","S" );
      ((Element)v.get(583)).setAttribute("minimizada","N" );
      ((Element)v.get(581)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */

      /* Empieza nodo:584 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(584)).setAttribute("ancho","100" );
      ((Element)v.get(584)).setAttribute("minimizable","S" );
      ((Element)v.get(584)).setAttribute("minimizada","N" );
      ((Element)v.get(581)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */

      /* Empieza nodo:585 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(585)).setAttribute("ancho","100" );
      ((Element)v.get(585)).setAttribute("minimizable","S" );
      ((Element)v.get(585)).setAttribute("minimizada","N" );
      ((Element)v.get(581)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */

      /* Empieza nodo:586 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(586)).setAttribute("ancho","100" );
      ((Element)v.get(586)).setAttribute("minimizable","S" );
      ((Element)v.get(586)).setAttribute("minimizada","N" );
      ((Element)v.get(581)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */

      /* Empieza nodo:587 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(587)).setAttribute("ancho","100" );
      ((Element)v.get(587)).setAttribute("minimizable","S" );
      ((Element)v.get(587)).setAttribute("minimizada","N" );
      ((Element)v.get(581)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:581   */

      /* Empieza nodo:588 / Elemento padre: 574   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(588)).setAttribute("alto","20" );
      ((Element)v.get(588)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(588)).setAttribute("imgFondo","" );
      ((Element)v.get(588)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(574)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(589)).setAttribute("colFondo","" );
      ((Element)v.get(589)).setAttribute("ID","EstCab" );
      ((Element)v.get(589)).setAttribute("cod","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */

      /* Empieza nodo:590 / Elemento padre: 588   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(590)).setAttribute("colFondo","" );
      ((Element)v.get(590)).setAttribute("ID","EstCab" );
      ((Element)v.get(590)).setAttribute("cod","9" );
      ((Element)v.get(588)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */

      /* Empieza nodo:591 / Elemento padre: 588   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(591)).setAttribute("colFondo","" );
      ((Element)v.get(591)).setAttribute("ID","EstCab" );
      ((Element)v.get(591)).setAttribute("cod","529" );
      ((Element)v.get(588)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */

      /* Empieza nodo:592 / Elemento padre: 588   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(592)).setAttribute("colFondo","" );
      ((Element)v.get(592)).setAttribute("ID","EstCab" );
      ((Element)v.get(592)).setAttribute("cod","530" );
      ((Element)v.get(588)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */

      /* Empieza nodo:593 / Elemento padre: 588   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(593)).setAttribute("colFondo","" );
      ((Element)v.get(593)).setAttribute("ID","EstCab" );
      ((Element)v.get(593)).setAttribute("cod","481" );
      ((Element)v.get(588)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */

      /* Empieza nodo:594 / Elemento padre: 588   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(594)).setAttribute("colFondo","" );
      ((Element)v.get(594)).setAttribute("ID","EstCab" );
      ((Element)v.get(594)).setAttribute("cod","482" );
      ((Element)v.get(588)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */

      /* Empieza nodo:595 / Elemento padre: 588   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(595)).setAttribute("colFondo","" );
      ((Element)v.get(595)).setAttribute("ID","EstCab" );
      ((Element)v.get(595)).setAttribute("cod","483" );
      ((Element)v.get(588)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:588   */

      /* Empieza nodo:596 / Elemento padre: 574   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(596)).setAttribute("alto","22" );
      ((Element)v.get(596)).setAttribute("accion","" );
      ((Element)v.get(596)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(596)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(596)).setAttribute("maxSel","-1" );
      ((Element)v.get(596)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(596)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(596)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(596)).setAttribute("onLoad","" );
      ((Element)v.get(596)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(574)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(597)).setAttribute("tipo","texto" );
      ((Element)v.get(597)).setAttribute("ID","EstDat" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */

      /* Empieza nodo:598 / Elemento padre: 596   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(598)).setAttribute("tipo","texto" );
      ((Element)v.get(598)).setAttribute("ID","EstDat2" );
      ((Element)v.get(596)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */

      /* Empieza nodo:599 / Elemento padre: 596   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(599)).setAttribute("tipo","texto" );
      ((Element)v.get(599)).setAttribute("ID","EstDat" );
      ((Element)v.get(596)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */

      /* Empieza nodo:600 / Elemento padre: 596   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(600)).setAttribute("tipo","texto" );
      ((Element)v.get(600)).setAttribute("ID","EstDat2" );
      ((Element)v.get(596)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */

      /* Empieza nodo:601 / Elemento padre: 596   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(601)).setAttribute("tipo","texto" );
      ((Element)v.get(601)).setAttribute("ID","EstDat" );
      ((Element)v.get(596)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */

      /* Empieza nodo:602 / Elemento padre: 596   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(602)).setAttribute("tipo","texto" );
      ((Element)v.get(602)).setAttribute("ID","EstDat2" );
      ((Element)v.get(596)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:596   */

      /* Empieza nodo:603 / Elemento padre: 574   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(574)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */

      /* Empieza nodo:604 / Elemento padre: 574   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(604)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(604)).setAttribute("ancho","680" );
      ((Element)v.get(604)).setAttribute("sep","$" );
      ((Element)v.get(604)).setAttribute("x","12" );
      ((Element)v.get(604)).setAttribute("class","botonera" );
      ((Element)v.get(604)).setAttribute("y","1692" );
      ((Element)v.get(604)).setAttribute("control","|" );
      ((Element)v.get(604)).setAttribute("conector","" );
      ((Element)v.get(604)).setAttribute("rowset","" );
      ((Element)v.get(604)).setAttribute("cargainicial","N" );
      ((Element)v.get(574)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(605)).setAttribute("nombre","primera4" );
      ((Element)v.get(605)).setAttribute("x","44" );
      ((Element)v.get(605)).setAttribute("y","1697" );
      ((Element)v.get(605)).setAttribute("ID","botonContenido" );
      ((Element)v.get(605)).setAttribute("img","primera_on" );
      ((Element)v.get(605)).setAttribute("tipo","1" );
      ((Element)v.get(605)).setAttribute("estado","false" );
      ((Element)v.get(605)).setAttribute("alt","" );
      ((Element)v.get(605)).setAttribute("codigo","" );
      ((Element)v.get(605)).setAttribute("accion","" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */

      /* Empieza nodo:606 / Elemento padre: 604   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(606)).setAttribute("nombre","ava4" );
      ((Element)v.get(606)).setAttribute("x","79" );
      ((Element)v.get(606)).setAttribute("y","1697" );
      ((Element)v.get(606)).setAttribute("ID","botonContenido" );
      ((Element)v.get(606)).setAttribute("img","avanzar_on" );
      ((Element)v.get(606)).setAttribute("tipo","0" );
      ((Element)v.get(606)).setAttribute("estado","false" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(606)).setAttribute("alt","" );
      ((Element)v.get(606)).setAttribute("codigo","" );
      ((Element)v.get(606)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(604)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */

      /* Empieza nodo:607 / Elemento padre: 604   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(607)).setAttribute("nombre","ret4" );
      ((Element)v.get(607)).setAttribute("x","64" );
      ((Element)v.get(607)).setAttribute("y","1697" );
      ((Element)v.get(607)).setAttribute("ID","botonContenido" );
      ((Element)v.get(607)).setAttribute("img","retroceder_on" );
      ((Element)v.get(607)).setAttribute("tipo","0" );
      ((Element)v.get(607)).setAttribute("estado","false" );
      ((Element)v.get(607)).setAttribute("alt","" );
      ((Element)v.get(607)).setAttribute("codigo","" );
      ((Element)v.get(607)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(604)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:604   */
      /* Termina nodo:574   */

      /* Empieza nodo:608 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(608)).setAttribute("nombre","capaVentaExclusiva" );
      ((Element)v.get(608)).setAttribute("alto","346" );
      ((Element)v.get(608)).setAttribute("ancho","100%" );
      ((Element)v.get(608)).setAttribute("colorf","" );
      ((Element)v.get(608)).setAttribute("borde","0" );
      ((Element)v.get(608)).setAttribute("imagenf","" );
      ((Element)v.get(608)).setAttribute("repeat","" );
      ((Element)v.get(608)).setAttribute("padding","" );
      ((Element)v.get(608)).setAttribute("visibilidad","visible" );
      ((Element)v.get(608)).setAttribute("contravsb","" );
      ((Element)v.get(608)).setAttribute("x","0" );
      ((Element)v.get(608)).setAttribute("y","1760" );
      ((Element)v.get(608)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("table"));
      ((Element)v.get(609)).setAttribute("width","100%" );
      ((Element)v.get(609)).setAttribute("border","0" );
      ((Element)v.get(609)).setAttribute("cellspacing","0" );
      ((Element)v.get(609)).setAttribute("cellpadding","0" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("td"));
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","12" );
      ((Element)v.get(612)).setAttribute("height","12" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 610   */
      v.add(doc.createElement("td"));
      ((Element)v.get(613)).setAttribute("width","750" );
      ((Element)v.get(610)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).setAttribute("width","1" );
      ((Element)v.get(614)).setAttribute("height","1" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:615 / Elemento padre: 610   */
      v.add(doc.createElement("td"));
      ((Element)v.get(610)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(616)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).setAttribute("width","12" );
      ((Element)v.get(616)).setAttribute("height","12" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */
      /* Termina nodo:610   */

      /* Empieza nodo:617 / Elemento padre: 609   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(609)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(618)).setAttribute("width","12" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(619)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).setAttribute("width","12" );
      ((Element)v.get(619)).setAttribute("height","12" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(622)).setAttribute("class","legend" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(623)).setAttribute("nombre","lblVentaExclusiva" );
      ((Element)v.get(623)).setAttribute("ancho","115" );
      ((Element)v.get(623)).setAttribute("alto","13" );
      ((Element)v.get(623)).setAttribute("filas","1" );
      ((Element)v.get(623)).setAttribute("valor","" );
      ((Element)v.get(623)).setAttribute("id","legend" );
      ((Element)v.get(623)).setAttribute("cod","0010" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */

      /* Empieza nodo:624 / Elemento padre: 621   */
      v.add(doc.createElement("table"));
      ((Element)v.get(624)).setAttribute("width","100%" );
      ((Element)v.get(624)).setAttribute("border","0" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(624)).setAttribute("align","center" );
      ((Element)v.get(624)).setAttribute("cellspacing","0" );
      ((Element)v.get(624)).setAttribute("cellpadding","0" );
      ((Element)v.get(621)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(624)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).setAttribute("colspan","4" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).setAttribute("width","12" );
      ((Element)v.get(627)).setAttribute("height","12" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:628 / Elemento padre: 624   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(624)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("td"));
      ((Element)v.get(629)).setAttribute("width","323" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).setAttribute("width","678" );
      ((Element)v.get(630)).setAttribute("height","285" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:631 / Elemento padre: 624   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(624)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("td"));
      ((Element)v.get(632)).setAttribute("colspan","4" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(633)).setAttribute("width","12" );
      ((Element)v.get(633)).setAttribute("height","12" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:631   */
      /* Termina nodo:624   */
      /* Termina nodo:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:634 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","12" );
      ((Element)v.get(635)).setAttribute("height","12" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */
      /* Termina nodo:617   */

      /* Empieza nodo:636 / Elemento padre: 609   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(609)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(637)).setAttribute("width","12" );
      ((Element)v.get(637)).setAttribute("align","center" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","12" );
      ((Element)v.get(638)).setAttribute("height","18" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */

      /* Empieza nodo:639 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).setAttribute("width","750" );
      ((Element)v.get(636)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */

      /* Empieza nodo:641 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).setAttribute("width","12" );
      ((Element)v.get(636)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(642)).setAttribute("src","b.gif" );
      ((Element)v.get(642)).setAttribute("width","12" );
      ((Element)v.get(642)).setAttribute("height","18" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */
      /* Termina nodo:636   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:643 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(643)).setAttribute("nombre","listado5" );
      ((Element)v.get(643)).setAttribute("ancho","657" );
      ((Element)v.get(643)).setAttribute("alto","290" );
      ((Element)v.get(643)).setAttribute("x","22" );
      ((Element)v.get(643)).setAttribute("y","1792" );
      ((Element)v.get(643)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(643)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(644)).setAttribute("precarga","S" );
      ((Element)v.get(644)).setAttribute("conROver","S" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(645)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(645)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(645)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(645)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */

      /* Empieza nodo:646 / Elemento padre: 644   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(646)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(646)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(646)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(646)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(644)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:644   */

      /* Empieza nodo:647 / Elemento padre: 643   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(643)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(648)).setAttribute("borde","1" );
      ((Element)v.get(648)).setAttribute("horizDatos","1" );
      ((Element)v.get(648)).setAttribute("horizCabecera","1" );
      ((Element)v.get(648)).setAttribute("vertical","0" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */

      /* Empieza nodo:649 / Elemento padre: 647   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(649)).setAttribute("borde","#999999" );
      ((Element)v.get(649)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(649)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(649)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(649)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(647)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:647   */

      /* Empieza nodo:650 / Elemento padre: 643   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(650)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(650)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(650)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(650)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(650)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(643)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(651)).setAttribute("ancho","100" );
      ((Element)v.get(651)).setAttribute("minimizable","S" );
      ((Element)v.get(651)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("ancho","100" );
      ((Element)v.get(652)).setAttribute("minimizable","S" );
      ((Element)v.get(652)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("ancho","100" );
      ((Element)v.get(653)).setAttribute("minimizable","S" );
      ((Element)v.get(653)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("ancho","100" );
      ((Element)v.get(654)).setAttribute("minimizable","S" );
      ((Element)v.get(654)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(655)).setAttribute("ancho","100" );
      ((Element)v.get(655)).setAttribute("minimizable","S" );
      ((Element)v.get(655)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:650   */

      /* Empieza nodo:656 / Elemento padre: 643   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(656)).setAttribute("alto","20" );
      ((Element)v.get(656)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(656)).setAttribute("imgFondo","" );
      ((Element)v.get(656)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(643)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(657)).setAttribute("colFondo","" );
      ((Element)v.get(657)).setAttribute("ID","EstCab" );
      ((Element)v.get(657)).setAttribute("cod","393" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */

      /* Empieza nodo:658 / Elemento padre: 656   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(658)).setAttribute("colFondo","" );
      ((Element)v.get(658)).setAttribute("ID","EstCab" );
      ((Element)v.get(658)).setAttribute("cod","595" );
      ((Element)v.get(656)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */

      /* Empieza nodo:659 / Elemento padre: 656   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("colFondo","" );
      ((Element)v.get(659)).setAttribute("ID","EstCab" );
      ((Element)v.get(659)).setAttribute("cod","550" );
      ((Element)v.get(656)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 656   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("colFondo","" );
      ((Element)v.get(660)).setAttribute("ID","EstCab" );
      ((Element)v.get(660)).setAttribute("cod","551" );
      ((Element)v.get(656)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */

      /* Empieza nodo:661 / Elemento padre: 656   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(661)).setAttribute("colFondo","" );
      ((Element)v.get(661)).setAttribute("ID","EstCab" );
      ((Element)v.get(661)).setAttribute("cod","552" );
      ((Element)v.get(656)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */
      /* Termina nodo:656   */

      /* Empieza nodo:662 / Elemento padre: 643   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(662)).setAttribute("alto","22" );
      ((Element)v.get(662)).setAttribute("accion","" );
      ((Element)v.get(662)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(662)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(662)).setAttribute("maxSel","-1" );
      ((Element)v.get(662)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(662)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(662)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(662)).setAttribute("onLoad","" );
      ((Element)v.get(662)).setAttribute("colorSelecc","#D0D9E8" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(643)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(663)).setAttribute("tipo","texto" );
      ((Element)v.get(663)).setAttribute("ID","EstDat" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 662   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(664)).setAttribute("tipo","texto" );
      ((Element)v.get(664)).setAttribute("ID","EstDat2" );
      ((Element)v.get(662)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */

      /* Empieza nodo:665 / Elemento padre: 662   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(665)).setAttribute("tipo","texto" );
      ((Element)v.get(665)).setAttribute("ID","EstDat" );
      ((Element)v.get(662)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */

      /* Empieza nodo:666 / Elemento padre: 662   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(666)).setAttribute("tipo","texto" );
      ((Element)v.get(666)).setAttribute("ID","EstDat2" );
      ((Element)v.get(662)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */

      /* Empieza nodo:667 / Elemento padre: 662   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(667)).setAttribute("tipo","texto" );
      ((Element)v.get(667)).setAttribute("ID","EstDat" );
      ((Element)v.get(662)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:662   */

      /* Empieza nodo:668 / Elemento padre: 643   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(643)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */

      /* Empieza nodo:669 / Elemento padre: 643   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(669)).setAttribute("nombre","mipgndo5" );
      ((Element)v.get(669)).setAttribute("ancho","680" );
      ((Element)v.get(669)).setAttribute("sep","$" );
      ((Element)v.get(669)).setAttribute("x","12" );
      ((Element)v.get(669)).setAttribute("class","botonera" );
      ((Element)v.get(669)).setAttribute("y","2044" );
      ((Element)v.get(669)).setAttribute("control","|" );
      ((Element)v.get(669)).setAttribute("conector","" );
      ((Element)v.get(669)).setAttribute("rowset","" );
      ((Element)v.get(669)).setAttribute("cargainicial","N" );
      ((Element)v.get(643)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(670)).setAttribute("nombre","primera5" );
      ((Element)v.get(670)).setAttribute("x","44" );
      ((Element)v.get(670)).setAttribute("y","2048" );
      ((Element)v.get(670)).setAttribute("ID","botonContenido" );
      ((Element)v.get(670)).setAttribute("img","primera_on" );
      ((Element)v.get(670)).setAttribute("tipo","1" );
      ((Element)v.get(670)).setAttribute("estado","false" );
      ((Element)v.get(670)).setAttribute("alt","" );
      ((Element)v.get(670)).setAttribute("codigo","" );
      ((Element)v.get(670)).setAttribute("accion","" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */

      /* Empieza nodo:671 / Elemento padre: 669   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(671)).setAttribute("nombre","ava5" );
      ((Element)v.get(671)).setAttribute("x","79" );
      ((Element)v.get(671)).setAttribute("y","2048" );
      ((Element)v.get(671)).setAttribute("ID","botonContenido" );
      ((Element)v.get(671)).setAttribute("img","avanzar_on" );
      ((Element)v.get(671)).setAttribute("tipo","0" );
      ((Element)v.get(671)).setAttribute("estado","false" );
      ((Element)v.get(671)).setAttribute("alt","" );
      ((Element)v.get(671)).setAttribute("codigo","" );
      ((Element)v.get(671)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(669)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */

      /* Empieza nodo:672 / Elemento padre: 669   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(672)).setAttribute("nombre","ret5" );
      ((Element)v.get(672)).setAttribute("x","64" );
      ((Element)v.get(672)).setAttribute("y","2048" );
      ((Element)v.get(672)).setAttribute("ID","botonContenido" );
      ((Element)v.get(672)).setAttribute("img","retroceder_on" );
      ((Element)v.get(672)).setAttribute("tipo","0" );
      ((Element)v.get(672)).setAttribute("estado","false" );
      ((Element)v.get(672)).setAttribute("alt","" );
      ((Element)v.get(672)).setAttribute("codigo","" );
      ((Element)v.get(672)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(669)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:669   */
      /* Termina nodo:643   */
      /* Termina nodo:4   */
      /* Termina nodo:3   */


   }

}
