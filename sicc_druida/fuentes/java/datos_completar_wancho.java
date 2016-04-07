
import org.w3c.dom.*;
import java.util.ArrayList;

public class datos_completar_wancho  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_bp_completar" );
      ((Element)v.get(0)).setAttribute("cod","0225" );
      ((Element)v.get(0)).setAttribute("titulo","Completar datos BP" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Completar datos BP" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"detalleDiv\"].style.visibility='';\r    document.all[\"nuevaEntradaDiv\"].style.visibility='';\r    eval (ON_RSZ);\r   }\r   \r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("table"));
      ((Element)v.get(4)).setAttribute("width","100%" );
      ((Element)v.get(4)).setAttribute("border","0" );
      ((Element)v.get(4)).setAttribute("cellspacing","0" );
      ((Element)v.get(4)).setAttribute("cellpadding","0" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("td"));
      ((Element)v.get(6)).setAttribute("width","12" );
      ((Element)v.get(6)).setAttribute("align","center" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(7)).setAttribute("src","b.gif" );
      ((Element)v.get(7)).setAttribute("width","12" );
      ((Element)v.get(7)).setAttribute("height","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("td"));
      ((Element)v.get(8)).setAttribute("width","750" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(9)).setAttribute("src","b.gif" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("td"));
      ((Element)v.get(10)).setAttribute("width","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(11)).setAttribute("src","b.gif" );
      ((Element)v.get(11)).setAttribute("width","12" );
      ((Element)v.get(11)).setAttribute("height","1" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:10   */
      /* Termina nodo:5   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","b.gif" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(17)).setAttribute("class","legend" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(18)).setAttribute("nombre","lblTitDatosBP" );
      ((Element)v.get(18)).setAttribute("alto","13" );
      ((Element)v.get(18)).setAttribute("filas","1" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(18)).setAttribute("cod","00207" );
      ((Element)v.get(18)).setAttribute("id","legend" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(19)).setAttribute("width","100%" );
      ((Element)v.get(19)).setAttribute("border","0" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(19)).setAttribute("cellspacing","0" );
      ((Element)v.get(19)).setAttribute("cellpadding","0" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","683" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("align","left" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("colspan","4" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","8" );
      ((Element)v.get(25)).setAttribute("height","8" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:26 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","8" );
      ((Element)v.get(28)).setAttribute("height","8" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(30)).setAttribute("nombre","lblPais" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","datosTitle" );
      ((Element)v.get(30)).setAttribute("cod","5" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","25" );
      ((Element)v.get(32)).setAttribute("height","8" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","datosTitle" );
      ((Element)v.get(34)).setAttribute("cod","6" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","25" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("id","datosTitle" );
      ((Element)v.get(38)).setAttribute("cod","7" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(26)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:26   */

      /* Empieza nodo:41 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblPaisActual" );
      ((Element)v.get(45)).setAttribute("ancho","190" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(45)).setAttribute("id","datosCampos" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","25" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(49)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(49)).setAttribute("id","datosCampos" );
      ((Element)v.get(49)).setAttribute("size","1" );
      ((Element)v.get(49)).setAttribute("multiple","N" );
      ((Element)v.get(49)).setAttribute("req","N" );
      ((Element)v.get(49)).setAttribute("valorinicial","" );
      ((Element)v.get(49)).setAttribute("textoinicial","" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(52)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(52)).setAttribute("TIPO","STRING" );
      ((Element)v.get(52)).setAttribute("VALOR","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 51   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(53)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(53)).setAttribute("TIPO","STRING" );
      ((Element)v.get(53)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(51)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:54 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(57)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("size","1" );
      ((Element)v.get(57)).setAttribute("multiple","N" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("valorinicial","" );
      ((Element)v.get(57)).setAttribute("textoinicial","" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(60)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(60)).setAttribute("TIPO","STRING" );
      ((Element)v.get(60)).setAttribute("VALOR","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(61)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(61)).setAttribute("TIPO","STRING" );
      ((Element)v.get(61)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:62 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(41)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:41   */

      /* Empieza nodo:64 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("colspan","4" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:67 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","683" );
      ((Element)v.get(69)).setAttribute("border","0" );
      ((Element)v.get(69)).setAttribute("align","left" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","173" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","276" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","1301" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(70)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:70   */

      /* Empieza nodo:85 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(85));

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
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbActividad" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(92)).setAttribute("TIPO","STRING" );
      ((Element)v.get(92)).setAttribute("VALOR","0" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 91   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(93)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(93)).setAttribute("TIPO","STRING" );
      ((Element)v.get(93)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(91)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:94 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(97)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("size","1" );
      ((Element)v.get(97)).setAttribute("multiple","N" );
      ((Element)v.get(97)).setAttribute("req","N" );
      ((Element)v.get(97)).setAttribute("valorinicial","" );
      ((Element)v.get(97)).setAttribute("textoinicial","" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(100)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(100)).setAttribute("TIPO","STRING" );
      ((Element)v.get(100)).setAttribute("VALOR","0" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(101)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(101)).setAttribute("TIPO","STRING" );
      ((Element)v.get(101)).setAttribute("VALOR","xxxxxxxxxx" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:102 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(105)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("size","1" );
      ((Element)v.get(105)).setAttribute("multiple","N" );
      ((Element)v.get(105)).setAttribute("req","N" );
      ((Element)v.get(105)).setAttribute("valorinicial","" );
      ((Element)v.get(105)).setAttribute("textoinicial","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(108)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(108)).setAttribute("TIPO","STRING" );
      ((Element)v.get(108)).setAttribute("VALOR","0" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 107   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(109)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(109)).setAttribute("TIPO","STRING" );
      ((Element)v.get(109)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(107)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:110 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:85   */

      /* Empieza nodo:112 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("colspan","4" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:19   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:115 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:12   */

      /* Empieza nodo:117 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("class","botonera" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(125)).setAttribute("nombre","btnCompletar" );
      ((Element)v.get(125)).setAttribute("ID","botonContenido" );
      ((Element)v.get(125)).setAttribute("tipo","html" );
      ((Element)v.get(125)).setAttribute("accion","" );
      ((Element)v.get(125)).setAttribute("estado","false" );
      ((Element)v.get(125)).setAttribute("cod","1369" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:126 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","12" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:117   */

      /* Empieza nodo:128 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","24" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","750" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("height","24" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:128   */
      /* Termina nodo:4   */

      /* Empieza nodo:135 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(135)).setAttribute("nombre","listado1" );
      ((Element)v.get(135)).setAttribute("ancho","687" );
      ((Element)v.get(135)).setAttribute("alto","317" );
      ((Element)v.get(135)).setAttribute("x","12" );
      ((Element)v.get(135)).setAttribute("y","162" );
      ((Element)v.get(135)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(135)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(136)).setAttribute("precarga","S" );
      ((Element)v.get(136)).setAttribute("conROver","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(137)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(137)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(137)).setAttribute("seleccionado","btnLista2M.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(138)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(138)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(138)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(138)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(139)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(139)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:136   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(141)).setAttribute("borde","1" );
      ((Element)v.get(141)).setAttribute("horizDatos","1" );
      ((Element)v.get(141)).setAttribute("horizCabecera","1" );
      ((Element)v.get(141)).setAttribute("vertical","0" );
      ((Element)v.get(141)).setAttribute("horizTitulo","1" );
      ((Element)v.get(141)).setAttribute("horizBase","1" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(142)).setAttribute("borde","#999999" );
      ((Element)v.get(142)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(142)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(142)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(142)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(142)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(142)).setAttribute("horizBase","#999999" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 135   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(143)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(143)).setAttribute("alto","22" );
      ((Element)v.get(143)).setAttribute("imgFondo","" );
      ((Element)v.get(143)).setAttribute("cod","00142" );
      ((Element)v.get(143)).setAttribute("ID","datosTitle" );
      ((Element)v.get(135)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 135   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(144)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(144)).setAttribute("alto","22" );
      ((Element)v.get(144)).setAttribute("imgFondo","" );
      ((Element)v.get(135)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 135   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(145)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(145)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(145)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(145)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(145)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(145)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","80" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","80" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","90" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","255" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","205" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","150" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","150" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","255" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(145)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","255" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","255" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","50" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:145   */

      /* Empieza nodo:157 / Elemento padre: 135   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(157)).setAttribute("alto","20" );
      ((Element)v.get(157)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(157)).setAttribute("imgFondo","" );
      ((Element)v.get(157)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(135)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(158)).setAttribute("cod","10" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("align","center" );
      ((Element)v.get(159)).setAttribute("cod","122" );
      ((Element)v.get(157)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(160)).setAttribute("cod","967" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("align","center" );
      ((Element)v.get(161)).setAttribute("cod","581" );
      ((Element)v.get(157)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(162)).setAttribute("cod","608" );
      ((Element)v.get(157)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("colFondo","" );
      ((Element)v.get(163)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).setAttribute("align","center" );
      ((Element)v.get(163)).setAttribute("cod","337" );
      ((Element)v.get(157)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("align","center" );
      ((Element)v.get(164)).setAttribute("cod","838" );
      ((Element)v.get(157)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cod","595" );
      ((Element)v.get(157)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("align","center" );
      ((Element)v.get(166)).setAttribute("cod","610" );
      ((Element)v.get(157)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(167)).setAttribute("cod","611" );
      ((Element)v.get(157)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(168)).setAttribute("cod","400" );
      ((Element)v.get(157)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:157   */

      /* Empieza nodo:169 / Elemento padre: 135   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(169)).setAttribute("alto","22" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(169)).setAttribute("accion","" );
      ((Element)v.get(169)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(169)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(169)).setAttribute("maxSel","-1" );
      ((Element)v.get(169)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(169)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(169)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(169)).setAttribute("onLoad","" );
      ((Element)v.get(169)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(135)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","texto" );
      ((Element)v.get(177)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","texto" );
      ((Element)v.get(178)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","texto" );
      ((Element)v.get(180)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:169   */

      /* Empieza nodo:181 / Elemento padre: 135   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(135)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 135   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(182)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(182)).setAttribute("ancho","687" );
      ((Element)v.get(182)).setAttribute("sep","$" );
      ((Element)v.get(182)).setAttribute("x","12" );
      ((Element)v.get(182)).setAttribute("class","botonera" );
      ((Element)v.get(182)).setAttribute("y","456" );
      ((Element)v.get(182)).setAttribute("control","|" );
      ((Element)v.get(182)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(182)).setAttribute("rowset","" );
      ((Element)v.get(182)).setAttribute("cargainicial","N" );
      ((Element)v.get(135)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","ret1" );
      ((Element)v.get(183)).setAttribute("x","37" );
      ((Element)v.get(183)).setAttribute("y","460" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("img","retroceder_on" );
      ((Element)v.get(183)).setAttribute("tipo","0" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("alt","" );
      ((Element)v.get(183)).setAttribute("codigo","" );
      ((Element)v.get(183)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 182   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","ava1" );
      ((Element)v.get(184)).setAttribute("x","52" );
      ((Element)v.get(184)).setAttribute("y","460" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("img","avanzar_on" );
      ((Element)v.get(184)).setAttribute("tipo","0" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("alt","" );
      ((Element)v.get(184)).setAttribute("codigo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(184)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(182)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:182   */
      /* Termina nodo:135   */

      /* Empieza nodo:185 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(185)).setAttribute("nombre","primera1" );
      ((Element)v.get(185)).setAttribute("x","20" );
      ((Element)v.get(185)).setAttribute("y","460" );
      ((Element)v.get(185)).setAttribute("ID","botonContenido" );
      ((Element)v.get(185)).setAttribute("img","primera_on" );
      ((Element)v.get(185)).setAttribute("tipo","0" );
      ((Element)v.get(185)).setAttribute("estado","false" );
      ((Element)v.get(185)).setAttribute("alt","" );
      ((Element)v.get(185)).setAttribute("codigo","" );
      ((Element)v.get(185)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","separa" );
      ((Element)v.get(186)).setAttribute("x","59" );
      ((Element)v.get(186)).setAttribute("y","456" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(186)).setAttribute("img","separa_base" );
      ((Element)v.get(186)).setAttribute("tipo","0" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("alt","" );
      ((Element)v.get(186)).setAttribute("codigo","" );
      ((Element)v.get(186)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(187)).setAttribute("nombre","detalle" );
      ((Element)v.get(187)).setAttribute("x","80" );
      ((Element)v.get(187)).setAttribute("y","457" );
      ((Element)v.get(187)).setAttribute("ID","botonContenido" );
      ((Element)v.get(187)).setAttribute("tipo","html" );
      ((Element)v.get(187)).setAttribute("estado","false" );
      ((Element)v.get(187)).setAttribute("cod","3" );
      ((Element)v.get(3)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(188)).setAttribute("nombre","nuevaEntrada" );
      ((Element)v.get(188)).setAttribute("x","128" );
      ((Element)v.get(188)).setAttribute("y","457" );
      ((Element)v.get(188)).setAttribute("ID","botonContenido" );
      ((Element)v.get(188)).setAttribute("tipo","html" );
      ((Element)v.get(188)).setAttribute("estado","false" );
      ((Element)v.get(188)).setAttribute("cod","945" );
      ((Element)v.get(3)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(189)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(189)).setAttribute("alto","12" );
      ((Element)v.get(189)).setAttribute("ancho","100%" );
      ((Element)v.get(189)).setAttribute("colorf","" );
      ((Element)v.get(189)).setAttribute("borde","0" );
      ((Element)v.get(189)).setAttribute("imagenf","" );
      ((Element)v.get(189)).setAttribute("repeat","" );
      ((Element)v.get(189)).setAttribute("padding","" );
      ((Element)v.get(189)).setAttribute("visibilidad","visible" );
      ((Element)v.get(189)).setAttribute("contravsb","" );
      ((Element)v.get(189)).setAttribute("x","0" );
      ((Element)v.get(189)).setAttribute("y","479" );
      ((Element)v.get(189)).setAttribute("zindex","" );
      ((Element)v.get(3)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:3   */


   }

}
