
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_producto_buscar_ped  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_producto_buscar_ped" );
      ((Element)v.get(0)).setAttribute("cod","0150" );
      ((Element)v.get(0)).setAttribute("titulo","Buscar Producto" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Buscar Producto" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r     \r      \r	function onLoadPag()   \r	{\r	    DrdEnsanchaConMargenDcho('listado1',12);\r	    \r	    document.all[\"Cplistado1\"].style.visibility='';\r	    document.all[\"CpLin1listado1\"].style.visibility='';\r	    document.all[\"CpLin2listado1\"].style.visibility='';\r	    document.all[\"CpLin3listado1\"].style.visibility='';\r	    document.all[\"CpLin4listado1\"].style.visibility='';\r\r	    document.all[\"primera1Div\"].style.visibility='';\r	    document.all[\"ret1Div\"].style.visibility='';\r	    document.all[\"ava1Div\"].style.visibility='';\r	    document.all[\"separaDiv\"].style.visibility='';\r\r	    eval (ON_RSZ);  \r	}\r  \r  "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(4)).setAttribute("nombre","capaContenido" );
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
      ((Element)v.get(19)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(19)).setAttribute("alto","13" );
      ((Element)v.get(19)).setAttribute("filas","1" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(19)).setAttribute("id","legend" );
      ((Element)v.get(19)).setAttribute("cod","0075" );
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
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("width","664" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("align","left" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("colspan","4" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","8" );
      ((Element)v.get(26)).setAttribute("height","8" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:27 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","8" );
      ((Element)v.get(29)).setAttribute("height","8" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("id","datosTitle" );
      ((Element)v.get(31)).setAttribute("cod","516" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","25" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblPagina" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","datosTitle" );
      ((Element)v.get(35)).setAttribute("cod","592" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","25" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblLineaProducto" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("id","datosTitle" );
      ((Element)v.get(39)).setAttribute("cod","586" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("colspan","4" );
      ((Element)v.get(27)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:27   */

      /* Empieza nodo:42 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(42));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(46)).setAttribute("nombre","cbCatalogo" );
      ((Element)v.get(46)).setAttribute("id","datosCampos" );
      ((Element)v.get(46)).setAttribute("size","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("multiple","N" );
      ((Element)v.get(46)).setAttribute("req","N" );
      ((Element)v.get(46)).setAttribute("valorinicial","" );
      ((Element)v.get(46)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:48 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(51)).setAttribute("nombre","txtPagina" );
      ((Element)v.get(51)).setAttribute("id","datosCampos" );
      ((Element)v.get(51)).setAttribute("max","10" );
      ((Element)v.get(51)).setAttribute("tipo","" );
      ((Element)v.get(51)).setAttribute("onchange","" );
      ((Element)v.get(51)).setAttribute("req","N" );
      ((Element)v.get(51)).setAttribute("size","10" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("validacion","" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(55)).setAttribute("nombre","cbLineaProducto" );
      ((Element)v.get(55)).setAttribute("id","datosCampos" );
      ((Element)v.get(55)).setAttribute("size","1" );
      ((Element)v.get(55)).setAttribute("multiple","N" );
      ((Element)v.get(55)).setAttribute("req","N" );
      ((Element)v.get(55)).setAttribute("valorinicial","" );
      ((Element)v.get(55)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:57 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:42   */

      /* Empieza nodo:59 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("colspan","4" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:62 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","664" );
      ((Element)v.get(64)).setAttribute("border","0" );
      ((Element)v.get(64)).setAttribute("align","left" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("cellpadding","0" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("colspan","4" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblPrecioCatalogoDesde" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","Precio catálogo desde" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("codigo","" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblPrecioCatalogoDesde" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","Precio catálogo hasta" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("codigo","" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(77)).setAttribute("colspan","4" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:68   */

      /* Empieza nodo:79 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(83)).setAttribute("nombre","txtPrecioCatalogoDesde" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("max","13" );
      ((Element)v.get(83)).setAttribute("tipo","" );
      ((Element)v.get(83)).setAttribute("onchange","" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("size","15" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("validacion","" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(87)).setAttribute("nombre","txtPrecioCatalogoDesde" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("max","13" );
      ((Element)v.get(87)).setAttribute("tipo","" );
      ((Element)v.get(87)).setAttribute("onchange","" );
      ((Element)v.get(87)).setAttribute("req","N" );
      ((Element)v.get(87)).setAttribute("size","15" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("validacion","" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:79   */

      /* Empieza nodo:90 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("colspan","4" );
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
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:93 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","664" );
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
      ((Element)v.get(100)).setAttribute("nombre","lblDescripcionCorta" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","47" );
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
      ((Element)v.get(104)).setAttribute("nombre","lblDescripcionLarga" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","48" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(105)).setAttribute("colspan","4" );
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
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(111)).setAttribute("nombre","txtDescripcionCorta" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("max","40" );
      ((Element)v.get(111)).setAttribute("tipo","" );
      ((Element)v.get(111)).setAttribute("onchange","" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("size","40" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("validacion","" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(115)).setAttribute("nombre","txtDescripcionLarga" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("max","50" );
      ((Element)v.get(115)).setAttribute("tipo","" );
      ((Element)v.get(115)).setAttribute("onchange","" );
      ((Element)v.get(115)).setAttribute("req","N" );
      ((Element)v.get(115)).setAttribute("size","50" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("validacion","" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:107   */

      /* Empieza nodo:118 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("colspan","4" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:20   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:121 / Elemento padre: 13   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:13   */

      /* Empieza nodo:123 / Elemento padre: 5   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(5)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("table"));
      ((Element)v.get(128)).setAttribute("width","100%" );
      ((Element)v.get(128)).setAttribute("border","0" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("cellspacing","0" );
      ((Element)v.get(128)).setAttribute("cellpadding","0" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("class","botonera" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(131)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(131)).setAttribute("ID","botonContenido" );
      ((Element)v.get(131)).setAttribute("tipo","html" );
      ((Element)v.get(131)).setAttribute("accion","" );
      ((Element)v.get(131)).setAttribute("estado","false" );
      ((Element)v.get(131)).setAttribute("cod","1" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:132 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","12" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:123   */

      /* Empieza nodo:134 / Elemento padre: 5   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(5)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","12" );
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","12" );
      ((Element)v.get(136)).setAttribute("height","12" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","756" );
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(134)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("height","1" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:134   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:141 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(141)).setAttribute("nombre","listado1" );
      ((Element)v.get(141)).setAttribute("ancho","667" );
      ((Element)v.get(141)).setAttribute("alto","317" );
      ((Element)v.get(141)).setAttribute("x","12" );
      ((Element)v.get(141)).setAttribute("y","212" );
      ((Element)v.get(141)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(141)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(142)).setAttribute("precarga","S" );
      ((Element)v.get(142)).setAttribute("conROver","S" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(143)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(143)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(143)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(143)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 142   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(144)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(144)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(144)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(144)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(145)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(145)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:142   */

      /* Empieza nodo:146 / Elemento padre: 141   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(141)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(147)).setAttribute("borde","1" );
      ((Element)v.get(147)).setAttribute("horizDatos","1" );
      ((Element)v.get(147)).setAttribute("horizCabecera","1" );
      ((Element)v.get(147)).setAttribute("vertical","1" );
      ((Element)v.get(147)).setAttribute("horizTitulo","1" );
      ((Element)v.get(147)).setAttribute("horizBase","1" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(148)).setAttribute("borde","#999999" );
      ((Element)v.get(148)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(148)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(148)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(148)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(148)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(148)).setAttribute("horizBase","#999999" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:146   */

      /* Empieza nodo:149 / Elemento padre: 141   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(149)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(149)).setAttribute("alto","22" );
      ((Element)v.get(149)).setAttribute("imgFondo","" );
      ((Element)v.get(149)).setAttribute("cod","00135" );
      ((Element)v.get(149)).setAttribute("ID","datosTitle" );
      ((Element)v.get(141)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 141   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(150)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(150)).setAttribute("alto","22" );
      ((Element)v.get(150)).setAttribute("imgFondo","" );
      ((Element)v.get(141)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 141   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(151)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(151)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(151)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(151)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(151)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(151)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(141)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","20" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","20" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","20" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","20" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 151   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","20" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:151   */

      /* Empieza nodo:157 / Elemento padre: 141   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(157)).setAttribute("alto","20" );
      ((Element)v.get(157)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(157)).setAttribute("imgFondo","" );
      ((Element)v.get(157)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(141)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("cod","336" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","48" );
      ((Element)v.get(157)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","1172" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("cod","377" );
      ((Element)v.get(157)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("cod","47" );
      ((Element)v.get(157)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:157   */

      /* Empieza nodo:163 / Elemento padre: 141   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(163)).setAttribute("alto","22" );
      ((Element)v.get(163)).setAttribute("accion","" );
      ((Element)v.get(163)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(163)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(163)).setAttribute("maxSel","-1" );
      ((Element)v.get(163)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(163)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(163)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(163)).setAttribute("onLoad","" );
      ((Element)v.get(163)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(141)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
      ((Element)v.get(165)).setAttribute("ID","EstDat2" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("tipo","texto" );
      ((Element)v.get(166)).setAttribute("ID","EstDat" );
      ((Element)v.get(163)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat2" );
      ((Element)v.get(163)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat" );
      ((Element)v.get(163)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:163   */

      /* Empieza nodo:169 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(170)).setAttribute("ID","1" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(171)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(171)).setAttribute("TIPO","STRING" );
      ((Element)v.get(171)).setAttribute("VALOR","COD0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(172)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(172)).setAttribute("TIPO","STRING" );
      ((Element)v.get(172)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(170)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(173)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(173)).setAttribute("TIPO","STRING" );
      ((Element)v.get(173)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 170   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(174)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(174)).setAttribute("TIPO","STRING" );
      ((Element)v.get(174)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(170)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(175)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(175)).setAttribute("TIPO","STRING" );
      ((Element)v.get(175)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(170)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 170   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(176)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(176)).setAttribute("TIPO","STRING" );
      ((Element)v.get(176)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(170)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:170   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(177)).setAttribute("ID","2" );
      ((Element)v.get(169)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(178)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(178)).setAttribute("TIPO","STRING" );
      ((Element)v.get(178)).setAttribute("VALOR","COD1" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 177   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(179)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(179)).setAttribute("TIPO","STRING" );
      ((Element)v.get(179)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(177)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(180)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(180)).setAttribute("TIPO","STRING" );
      ((Element)v.get(180)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(181)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(181)).setAttribute("TIPO","STRING" );
      ((Element)v.get(181)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(177)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(182)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(182)).setAttribute("TIPO","STRING" );
      ((Element)v.get(182)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(177)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 177   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(183)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(183)).setAttribute("TIPO","STRING" );
      ((Element)v.get(183)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(177)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:177   */

      /* Empieza nodo:184 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(184)).setAttribute("ID","3" );
      ((Element)v.get(169)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(185)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(185)).setAttribute("TIPO","STRING" );
      ((Element)v.get(185)).setAttribute("VALOR","COD2" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(186)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(186)).setAttribute("TIPO","STRING" );
      ((Element)v.get(186)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(187)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(187)).setAttribute("TIPO","STRING" );
      ((Element)v.get(187)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(188)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(188)).setAttribute("TIPO","STRING" );
      ((Element)v.get(188)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(184)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(189)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(189)).setAttribute("TIPO","STRING" );
      ((Element)v.get(189)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(190)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(190)).setAttribute("TIPO","STRING" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(190)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(184)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:184   */

      /* Empieza nodo:191 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(191)).setAttribute("ID","1" );
      ((Element)v.get(169)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(192)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(192)).setAttribute("TIPO","STRING" );
      ((Element)v.get(192)).setAttribute("VALOR","COD3" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(193)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(193)).setAttribute("TIPO","STRING" );
      ((Element)v.get(193)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(194)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(194)).setAttribute("TIPO","STRING" );
      ((Element)v.get(194)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(195)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(195)).setAttribute("TIPO","STRING" );
      ((Element)v.get(195)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(191)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(196)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(196)).setAttribute("TIPO","STRING" );
      ((Element)v.get(196)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(191)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(197)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(197)).setAttribute("TIPO","STRING" );
      ((Element)v.get(197)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(191)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:191   */

      /* Empieza nodo:198 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(198)).setAttribute("ID","2" );
      ((Element)v.get(169)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(199)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(199)).setAttribute("TIPO","STRING" );
      ((Element)v.get(199)).setAttribute("VALOR","COD4" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(200)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(200)).setAttribute("TIPO","STRING" );
      ((Element)v.get(200)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(198)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(201)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(201)).setAttribute("TIPO","STRING" );
      ((Element)v.get(201)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(198)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(202)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(202)).setAttribute("TIPO","STRING" );
      ((Element)v.get(202)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(198)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(203)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(203)).setAttribute("TIPO","STRING" );
      ((Element)v.get(203)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(198)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(204)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(204)).setAttribute("TIPO","STRING" );
      ((Element)v.get(204)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(198)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:198   */

      /* Empieza nodo:205 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(205)).setAttribute("ID","3" );
      ((Element)v.get(169)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(206)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(206)).setAttribute("TIPO","STRING" );
      ((Element)v.get(206)).setAttribute("VALOR","COD5" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(207)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(207)).setAttribute("TIPO","STRING" );
      ((Element)v.get(207)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(205)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(208)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(208)).setAttribute("TIPO","STRING" );
      ((Element)v.get(208)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(205)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(209)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(209)).setAttribute("TIPO","STRING" );
      ((Element)v.get(209)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(205)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(210)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(210)).setAttribute("TIPO","STRING" );
      ((Element)v.get(210)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 205   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(211)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(211)).setAttribute("TIPO","STRING" );
      ((Element)v.get(211)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(205)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:205   */

      /* Empieza nodo:212 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(212)).setAttribute("ID","3" );
      ((Element)v.get(169)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(213)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(213)).setAttribute("TIPO","STRING" );
      ((Element)v.get(213)).setAttribute("VALOR","COD6" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(214)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(214)).setAttribute("TIPO","STRING" );
      ((Element)v.get(214)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(212)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(215)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(215)).setAttribute("TIPO","STRING" );
      ((Element)v.get(215)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(216)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(216)).setAttribute("TIPO","STRING" );
      ((Element)v.get(216)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(212)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(217)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(217)).setAttribute("TIPO","STRING" );
      ((Element)v.get(217)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(212)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(218)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(218)).setAttribute("TIPO","STRING" );
      ((Element)v.get(218)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(212)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:212   */

      /* Empieza nodo:219 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(219)).setAttribute("ID","1" );
      ((Element)v.get(169)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(220)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(220)).setAttribute("TIPO","STRING" );
      ((Element)v.get(220)).setAttribute("VALOR","COD0" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(221)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(221)).setAttribute("TIPO","STRING" );
      ((Element)v.get(221)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(219)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(222)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(222)).setAttribute("TIPO","STRING" );
      ((Element)v.get(222)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(223)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(223)).setAttribute("TIPO","STRING" );
      ((Element)v.get(223)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(219)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(224)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(224)).setAttribute("TIPO","STRING" );
      ((Element)v.get(224)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(219)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(225)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(225)).setAttribute("TIPO","STRING" );
      ((Element)v.get(225)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(219)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:219   */

      /* Empieza nodo:226 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(226)).setAttribute("ID","2" );
      ((Element)v.get(169)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(227)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(227)).setAttribute("TIPO","STRING" );
      ((Element)v.get(227)).setAttribute("VALOR","COD1" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(228)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(228)).setAttribute("TIPO","STRING" );
      ((Element)v.get(228)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(226)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 226   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(229)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(229)).setAttribute("TIPO","STRING" );
      ((Element)v.get(229)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(230)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(230)).setAttribute("TIPO","STRING" );
      ((Element)v.get(230)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(226)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(231)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(231)).setAttribute("TIPO","STRING" );
      ((Element)v.get(231)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 226   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(226)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:226   */

      /* Empieza nodo:233 / Elemento padre: 169   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(233)).setAttribute("ID","3" );
      ((Element)v.get(169)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(234)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(234)).setAttribute("TIPO","STRING" );
      ((Element)v.get(234)).setAttribute("VALOR","COD2" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(236)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(236)).setAttribute("TIPO","STRING" );
      ((Element)v.get(236)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(237)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(237)).setAttribute("TIPO","STRING" );
      ((Element)v.get(237)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(233)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(238)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(238)).setAttribute("TIPO","STRING" );
      ((Element)v.get(238)).setAttribute("VALOR","xxxxxxxxxx,xx" );
      ((Element)v.get(233)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(239)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(239)).setAttribute("TIPO","STRING" );
      ((Element)v.get(239)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(233)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:233   */
      /* Termina nodo:169   */

      /* Empieza nodo:240 / Elemento padre: 141   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(240)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(240)).setAttribute("ancho","667" );
      ((Element)v.get(240)).setAttribute("sep","$" );
      ((Element)v.get(240)).setAttribute("x","12" );
      ((Element)v.get(240)).setAttribute("class","botonera" );
      ((Element)v.get(240)).setAttribute("y","506" );
      ((Element)v.get(240)).setAttribute("control","|" );
      ((Element)v.get(240)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(240)).setAttribute("rowset","" );
      ((Element)v.get(240)).setAttribute("cargainicial","N" );
      ((Element)v.get(141)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(241)).setAttribute("nombre","ret1" );
      ((Element)v.get(241)).setAttribute("x","37" );
      ((Element)v.get(241)).setAttribute("y","510" );
      ((Element)v.get(241)).setAttribute("ID","botonContenido" );
      ((Element)v.get(241)).setAttribute("img","retroceder_on" );
      ((Element)v.get(241)).setAttribute("tipo","0" );
      ((Element)v.get(241)).setAttribute("estado","false" );
      ((Element)v.get(241)).setAttribute("alt","" );
      ((Element)v.get(241)).setAttribute("codigo","" );
      ((Element)v.get(241)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(242)).setAttribute("nombre","ava1" );
      ((Element)v.get(242)).setAttribute("x","52" );
      ((Element)v.get(242)).setAttribute("y","510" );
      ((Element)v.get(242)).setAttribute("ID","botonContenido" );
      ((Element)v.get(242)).setAttribute("img","avanzar_on" );
      ((Element)v.get(242)).setAttribute("tipo","0" );
      ((Element)v.get(242)).setAttribute("estado","false" );
      ((Element)v.get(242)).setAttribute("alt","" );
      ((Element)v.get(242)).setAttribute("codigo","" );
      ((Element)v.get(242)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */
      /* Termina nodo:141   */

      /* Empieza nodo:243 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(243)).setAttribute("nombre","primera1" );
      ((Element)v.get(243)).setAttribute("x","20" );
      ((Element)v.get(243)).setAttribute("y","510" );
      ((Element)v.get(243)).setAttribute("ID","botonContenido" );
      ((Element)v.get(243)).setAttribute("img","primera_on" );
      ((Element)v.get(243)).setAttribute("tipo","-2" );
      ((Element)v.get(243)).setAttribute("estado","false" );
      ((Element)v.get(243)).setAttribute("alt","" );
      ((Element)v.get(243)).setAttribute("codigo","" );
      ((Element)v.get(243)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(244)).setAttribute("nombre","separa" );
      ((Element)v.get(244)).setAttribute("x","59" );
      ((Element)v.get(244)).setAttribute("y","506" );
      ((Element)v.get(244)).setAttribute("ID","botonContenido" );
      ((Element)v.get(244)).setAttribute("img","separa_base" );
      ((Element)v.get(244)).setAttribute("tipo","0" );
      ((Element)v.get(244)).setAttribute("estado","false" );
      ((Element)v.get(244)).setAttribute("alt","" );
      ((Element)v.get(244)).setAttribute("codigo","" );
      ((Element)v.get(244)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(245)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(245)).setAttribute("alto","12" );
      ((Element)v.get(245)).setAttribute("ancho","50" );
      ((Element)v.get(245)).setAttribute("colorf","" );
      ((Element)v.get(245)).setAttribute("borde","0" );
      ((Element)v.get(245)).setAttribute("imagenf","" );
      ((Element)v.get(245)).setAttribute("repeat","" );
      ((Element)v.get(245)).setAttribute("padding","" );
      ((Element)v.get(245)).setAttribute("visibilidad","visible" );
      ((Element)v.get(245)).setAttribute("contravsb","" );
      ((Element)v.get(245)).setAttribute("x","0" );
      ((Element)v.get(245)).setAttribute("y","529" );
      ((Element)v.get(245)).setAttribute("zindex","" );
      ((Element)v.get(3)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:3   */


   }

}
