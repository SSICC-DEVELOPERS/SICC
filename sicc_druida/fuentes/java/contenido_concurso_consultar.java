
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_concurso_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_concurso_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0493" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r  \r    DrdEnsanchaConMargenDcho('listado1',24);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separa1Div\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r\r    DrdEnsanchaConMargenDcho('listado2',12);\r    document.all[\"Cplistado2\"].style.visibility='';\r    document.all[\"CpLin1listado2\"].style.visibility='';\r    document.all[\"CpLin2listado2\"].style.visibility='';\r    document.all[\"CpLin3listado2\"].style.visibility='';\r    document.all[\"CpLin4listado2\"].style.visibility='';\r    document.all[\"separa2Div\"].style.visibility='';\r    document.all[\"primera2Div\"].style.visibility='';\r    document.all[\"ret2Div\"].style.visibility='';\r    document.all[\"ava2Div\"].style.visibility='';\r    document.all[\"btnDetalleDiv\"].style.visibility='';\r    eval (ON_RSZ);  \r\r	if (window.dialogArguments) {             btnProxy(2,1);              btnProxy(3,0);          }\r\r\r  }\r\r	function fVolver(){     \r					  window.close();\r	}\r\r\r   \r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","formulario" );
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
      ((Element)v.get(18)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(18)).setAttribute("alto","13" );
      ((Element)v.get(18)).setAttribute("filas","1" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(18)).setAttribute("cod","0075" );
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
      ((Element)v.get(22)).setAttribute("width","575" );
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
      ((Element)v.get(30)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","datosTitle" );
      ((Element)v.get(30)).setAttribute("cod","1604" );
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
      ((Element)v.get(34)).setAttribute("nombre","lblNombreConcurso" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","datosTitle" );
      ((Element)v.get(34)).setAttribute("cod","1605" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(26)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:26   */

      /* Empieza nodo:37 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(41)).setAttribute("nombre","cbNumConcurso" );
      ((Element)v.get(41)).setAttribute("id","datosCampos" );
      ((Element)v.get(41)).setAttribute("size","1" );
      ((Element)v.get(41)).setAttribute("multiple","N" );
      ((Element)v.get(41)).setAttribute("req","N" );
      ((Element)v.get(41)).setAttribute("valorinicial","" );
      ((Element)v.get(41)).setAttribute("textoinicial","xxxxx1" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","25" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(46)).setAttribute("nombre","txtNombreConcurso" );
      ((Element)v.get(46)).setAttribute("id","datosCampos" );
      ((Element)v.get(46)).setAttribute("max","75" );
      ((Element)v.get(46)).setAttribute("tipo","" );
      ((Element)v.get(46)).setAttribute("onchange","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("req","N" );
      ((Element)v.get(46)).setAttribute("size","75" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("validacion","" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:37   */

      /* Empieza nodo:49 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("colspan","4" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:52 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","575" );
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
      ((Element)v.get(59)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","1175" );
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
      ((Element)v.get(63)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","1176" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblDirigidoA" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","1626" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblPruebas" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","1631" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:55   */

      /* Empieza nodo:74 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("req","S" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","xx-xx-xxxx" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:81 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).setAttribute("valign","bottom" );
      ((Element)v.get(74)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","xx-xx-xxxx" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:87 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(89)).setAttribute("valign","bottom" );
      ((Element)v.get(74)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(90)).setAttribute("nombre","cbDirigidoA" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("size","1" );
      ((Element)v.get(90)).setAttribute("multiple","N" );
      ((Element)v.get(90)).setAttribute("req","N" );
      ((Element)v.get(90)).setAttribute("valorinicial","" );
      ((Element)v.get(90)).setAttribute("textoinicial","Gerentes" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(93)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(93)).setAttribute("TIPO","STRING" );
      ((Element)v.get(93)).setAttribute("VALOR","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 92   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(94)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(94)).setAttribute("TIPO","STRING" );
      ((Element)v.get(94)).setAttribute("VALOR","Consultoras" );
      ((Element)v.get(92)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:95 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("valign","bottom" );
      ((Element)v.get(74)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(98)).setAttribute("nombre","Pruebas" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("onclick","" );
      ((Element)v.get(98)).setAttribute("check","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:74   */

      /* Empieza nodo:101 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("colspan","4" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:104 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","575" );
      ((Element)v.get(106)).setAttribute("border","0" );
      ((Element)v.get(106)).setAttribute("align","left" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblSubgerencia" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("id","datosTitle" );
      ((Element)v.get(111)).setAttribute("cod","992" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblRegion" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","109" );
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

      /* Empieza nodo:118 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(122)).setAttribute("nombre","cbSubgerencia" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("size","5" );
      ((Element)v.get(122)).setAttribute("multiple","S" );
      ((Element)v.get(122)).setAttribute("req","N" );
      ((Element)v.get(122)).setAttribute("valorinicial","" );
      ((Element)v.get(122)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(125)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(125)).setAttribute("TIPO","STRING" );
      ((Element)v.get(125)).setAttribute("VALOR","0" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(126)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(126)).setAttribute("TIPO","STRING" );
      ((Element)v.get(126)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:124   */

      /* Empieza nodo:127 / Elemento padre: 123   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(123)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(128)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(128)).setAttribute("TIPO","STRING" );
      ((Element)v.get(128)).setAttribute("VALOR","0" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 127   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(129)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(129)).setAttribute("TIPO","STRING" );
      ((Element)v.get(129)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(127)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 123   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(123)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(131)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(131)).setAttribute("TIPO","STRING" );
      ((Element)v.get(131)).setAttribute("VALOR","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 130   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(132)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(132)).setAttribute("TIPO","STRING" );
      ((Element)v.get(132)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(130)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:130   */

      /* Empieza nodo:133 / Elemento padre: 123   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(123)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(134)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(134)).setAttribute("TIPO","STRING" );
      ((Element)v.get(134)).setAttribute("VALOR","0" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 133   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(135)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(135)).setAttribute("TIPO","STRING" );
      ((Element)v.get(135)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(133)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:133   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:136 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(139)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).setAttribute("size","5" );
      ((Element)v.get(139)).setAttribute("multiple","S" );
      ((Element)v.get(139)).setAttribute("req","N" );
      ((Element)v.get(139)).setAttribute("valorinicial","" );
      ((Element)v.get(139)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(142)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(142)).setAttribute("TIPO","STRING" );
      ((Element)v.get(142)).setAttribute("VALOR","0" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 141   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(143)).setAttribute("TIPO","STRING" );
      ((Element)v.get(143)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(141)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 140   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(140)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(145)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(145)).setAttribute("TIPO","STRING" );
      ((Element)v.get(145)).setAttribute("VALOR","0" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 144   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(146)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(146)).setAttribute("TIPO","STRING" );
      ((Element)v.get(146)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(144)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:144   */

      /* Empieza nodo:147 / Elemento padre: 140   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(140)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(148)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(148)).setAttribute("TIPO","STRING" );
      ((Element)v.get(148)).setAttribute("VALOR","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(149)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(149)).setAttribute("TIPO","STRING" );
      ((Element)v.get(149)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 140   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(140)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(151)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(151)).setAttribute("TIPO","STRING" );
      ((Element)v.get(151)).setAttribute("VALOR","0" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 150   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(152)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(152)).setAttribute("TIPO","STRING" );
      ((Element)v.get(152)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(150)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:150   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:153 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(118)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:118   */

      /* Empieza nodo:155 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("colspan","4" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:158 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("table"));
      ((Element)v.get(160)).setAttribute("width","575" );
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("align","left" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblZona" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","143" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("cod","112" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(161)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:161   */

      /* Empieza nodo:172 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cbZona" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("size","5" );
      ((Element)v.get(176)).setAttribute("multiple","S" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(179)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(179)).setAttribute("TIPO","STRING" );
      ((Element)v.get(179)).setAttribute("VALOR","0" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(180)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(180)).setAttribute("TIPO","STRING" );
      ((Element)v.get(180)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:178   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(177)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(182)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(182)).setAttribute("TIPO","STRING" );
      ((Element)v.get(182)).setAttribute("VALOR","0" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(183)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(183)).setAttribute("TIPO","STRING" );
      ((Element)v.get(183)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(177)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(185)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(185)).setAttribute("TIPO","STRING" );
      ((Element)v.get(185)).setAttribute("VALOR","0" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(186)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(186)).setAttribute("TIPO","STRING" );
      ((Element)v.get(186)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 177   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(177)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(188)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(188)).setAttribute("TIPO","STRING" );
      ((Element)v.get(188)).setAttribute("VALOR","0" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 187   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(189)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(189)).setAttribute("TIPO","STRING" );
      ((Element)v.get(189)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(187)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:187   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:190 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","25" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(193)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(193)).setAttribute("id","datosCampos" );
      ((Element)v.get(193)).setAttribute("size","5" );
      ((Element)v.get(193)).setAttribute("multiple","S" );
      ((Element)v.get(193)).setAttribute("req","N" );
      ((Element)v.get(193)).setAttribute("valorinicial","" );
      ((Element)v.get(193)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(196)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(196)).setAttribute("TIPO","STRING" );
      ((Element)v.get(196)).setAttribute("VALOR","0" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(197)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(197)).setAttribute("TIPO","STRING" );
      ((Element)v.get(197)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:195   */

      /* Empieza nodo:198 / Elemento padre: 194   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(194)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(199)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(199)).setAttribute("TIPO","STRING" );
      ((Element)v.get(199)).setAttribute("VALOR","0" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 198   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(200)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(200)).setAttribute("TIPO","STRING" );
      ((Element)v.get(200)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(198)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 194   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(194)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(202)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(202)).setAttribute("TIPO","STRING" );
      ((Element)v.get(202)).setAttribute("VALOR","0" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(203)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(203)).setAttribute("TIPO","STRING" );
      ((Element)v.get(203)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(201)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:201   */

      /* Empieza nodo:204 / Elemento padre: 194   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(194)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(205)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(205)).setAttribute("TIPO","STRING" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(205)).setAttribute("VALOR","0" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(206)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(206)).setAttribute("TIPO","STRING" );
      ((Element)v.get(206)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:204   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:207 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:172   */

      /* Empieza nodo:209 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("colspan","4" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:212 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("table"));
      ((Element)v.get(214)).setAttribute("width","575" );
      ((Element)v.get(214)).setAttribute("border","0" );
      ((Element)v.get(214)).setAttribute("align","left" );
      ((Element)v.get(214)).setAttribute("cellspacing","0" );
      ((Element)v.get(214)).setAttribute("cellpadding","0" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

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
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("id","datosTitle" );
      ((Element)v.get(219)).setAttribute("cod","126" );
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

      /* Empieza nodo:222 / Elemento padre: 214   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(214)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(226)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(226)).setAttribute("size","5" );
      ((Element)v.get(226)).setAttribute("multiple","S" );
      ((Element)v.get(226)).setAttribute("req","N" );
      ((Element)v.get(226)).setAttribute("valorinicial","" );
      ((Element)v.get(226)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(229)).setAttribute("NOMBRE","cabecera" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(229)).setAttribute("TIPO","STRING" );
      ((Element)v.get(229)).setAttribute("VALOR","0" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 228   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(230)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(230)).setAttribute("TIPO","STRING" );
      ((Element)v.get(230)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(228)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:228   */

      /* Empieza nodo:231 / Elemento padre: 227   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(227)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","0" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 231   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(233)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(233)).setAttribute("TIPO","STRING" );
      ((Element)v.get(233)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(231)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:231   */

      /* Empieza nodo:234 / Elemento padre: 227   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(227)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 234   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(236)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(236)).setAttribute("TIPO","STRING" );
      ((Element)v.get(236)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(234)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:234   */

      /* Empieza nodo:237 / Elemento padre: 227   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(227)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(238)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(238)).setAttribute("TIPO","STRING" );
      ((Element)v.get(238)).setAttribute("VALOR","0" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(239)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(239)).setAttribute("TIPO","STRING" );
      ((Element)v.get(239)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:240 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:222   */

      /* Empieza nodo:242 / Elemento padre: 214   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(214)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("colspan","4" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","336" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:19   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:245 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","12" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:12   */

      /* Empieza nodo:247 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("table"));
      ((Element)v.get(252)).setAttribute("width","100%" );
      ((Element)v.get(252)).setAttribute("border","0" );
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("cellspacing","0" );
      ((Element)v.get(252)).setAttribute("cellpadding","0" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(254)).setAttribute("class","botonera" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(255)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(255)).setAttribute("ID","botonContenido" );
      ((Element)v.get(255)).setAttribute("tipo","html" );
      ((Element)v.get(255)).setAttribute("accion","" );
      ((Element)v.get(255)).setAttribute("estado","false" );
      ((Element)v.get(255)).setAttribute("cod","1" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:256 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","12" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:247   */

      /* Empieza nodo:258 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","12" );
      ((Element)v.get(260)).setAttribute("height","12" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","750" );
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","12" );
      ((Element)v.get(264)).setAttribute("height","12" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:258   */
      /* Termina nodo:4   */

      /* Empieza nodo:265 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(265)).setAttribute("nombre","listado1" );
      ((Element)v.get(265)).setAttribute("ancho","557" );
      ((Element)v.get(265)).setAttribute("alto","301" );
      ((Element)v.get(265)).setAttribute("x","24" );
      ((Element)v.get(265)).setAttribute("y","385" );
      ((Element)v.get(265)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(265)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(266)).setAttribute("precarga","S" );
      ((Element)v.get(266)).setAttribute("conROver","S" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(267)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(267)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(267)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(267)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 266   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(268)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(268)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(268)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(268)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(266)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(269)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(269)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(266)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:266   */

      /* Empieza nodo:270 / Elemento padre: 265   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(265)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(271)).setAttribute("borde","1" );
      ((Element)v.get(271)).setAttribute("horizDatos","1" );
      ((Element)v.get(271)).setAttribute("horizCabecera","1" );
      ((Element)v.get(271)).setAttribute("vertical","0" );
      ((Element)v.get(271)).setAttribute("horizTitulo","1" );
      ((Element)v.get(271)).setAttribute("horizBase","1" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 270   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(272)).setAttribute("borde","#999999" );
      ((Element)v.get(272)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(272)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(272)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(272)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(272)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(272)).setAttribute("horizBase","#999999" );
      ((Element)v.get(270)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:270   */

      /* Empieza nodo:273 / Elemento padre: 265   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(273)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(273)).setAttribute("alto","22" );
      ((Element)v.get(273)).setAttribute("imgFondo","" );
      ((Element)v.get(273)).setAttribute("cod","00309" );
      ((Element)v.get(273)).setAttribute("ID","datosTitle" );
      ((Element)v.get(265)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 265   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(274)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(274)).setAttribute("alto","22" );
      ((Element)v.get(274)).setAttribute("imgFondo","" );
      ((Element)v.get(265)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 265   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(275)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(275)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(275)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(275)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(275)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(275)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(265)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("ancho","100" );
      ((Element)v.get(276)).setAttribute("minimizable","S" );
      ((Element)v.get(276)).setAttribute("minimizada","N" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 275   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("ancho","100" );
      ((Element)v.get(277)).setAttribute("minimizable","S" );
      ((Element)v.get(277)).setAttribute("minimizada","N" );
      ((Element)v.get(275)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:275   */

      /* Empieza nodo:278 / Elemento padre: 265   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(278)).setAttribute("alto","20" );
      ((Element)v.get(278)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(278)).setAttribute("imgFondo","" );
      ((Element)v.get(278)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(265)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("colFondo","" );
      ((Element)v.get(279)).setAttribute("ID","EstCab" );
      ((Element)v.get(279)).setAttribute("cod","1905" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 278   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("colFondo","" );
      ((Element)v.get(280)).setAttribute("ID","EstCab" );
      ((Element)v.get(280)).setAttribute("cod","9" );
      ((Element)v.get(278)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:278   */

      /* Empieza nodo:281 / Elemento padre: 265   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(281)).setAttribute("alto","22" );
      ((Element)v.get(281)).setAttribute("accion","" );
      ((Element)v.get(281)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(281)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(281)).setAttribute("maxSel","-1" );
      ((Element)v.get(281)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(281)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(281)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(281)).setAttribute("onLoad","" );
      ((Element)v.get(281)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(265)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("tipo","texto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","texto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat2" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:281   */

      /* Empieza nodo:284 / Elemento padre: 265   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(265)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 265   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(285)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(285)).setAttribute("ancho","557" );
      ((Element)v.get(285)).setAttribute("sep","$" );
      ((Element)v.get(285)).setAttribute("x","24" );
      ((Element)v.get(285)).setAttribute("class","botonera" );
      ((Element)v.get(285)).setAttribute("y","663" );
      ((Element)v.get(285)).setAttribute("control","|" );
      ((Element)v.get(285)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(285)).setAttribute("rowset","" );
      ((Element)v.get(285)).setAttribute("cargainicial","S" );
      ((Element)v.get(265)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(286)).setAttribute("nombre","ret1" );
      ((Element)v.get(286)).setAttribute("x","49" );
      ((Element)v.get(286)).setAttribute("y","667" );
      ((Element)v.get(286)).setAttribute("ID","botonContenido" );
      ((Element)v.get(286)).setAttribute("img","retroceder_on" );
      ((Element)v.get(286)).setAttribute("tipo","0" );
      ((Element)v.get(286)).setAttribute("estado","false" );
      ((Element)v.get(286)).setAttribute("alt","" );
      ((Element)v.get(286)).setAttribute("codigo","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(286)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 285   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(287)).setAttribute("nombre","ava1" );
      ((Element)v.get(287)).setAttribute("x","64" );
      ((Element)v.get(287)).setAttribute("y","667" );
      ((Element)v.get(287)).setAttribute("ID","botonContenido" );
      ((Element)v.get(287)).setAttribute("img","avanzar_on" );
      ((Element)v.get(287)).setAttribute("tipo","0" );
      ((Element)v.get(287)).setAttribute("estado","false" );
      ((Element)v.get(287)).setAttribute("alt","" );
      ((Element)v.get(287)).setAttribute("codigo","" );
      ((Element)v.get(287)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(285)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:285   */
      /* Termina nodo:265   */

      /* Empieza nodo:288 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(288)).setAttribute("nombre","primera1" );
      ((Element)v.get(288)).setAttribute("x","32" );
      ((Element)v.get(288)).setAttribute("y","667" );
      ((Element)v.get(288)).setAttribute("ID","botonContenido" );
      ((Element)v.get(288)).setAttribute("img","primera_on" );
      ((Element)v.get(288)).setAttribute("tipo","-2" );
      ((Element)v.get(288)).setAttribute("estado","false" );
      ((Element)v.get(288)).setAttribute("alt","" );
      ((Element)v.get(288)).setAttribute("codigo","" );
      ((Element)v.get(288)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(289)).setAttribute("nombre","separa1" );
      ((Element)v.get(289)).setAttribute("x","71" );
      ((Element)v.get(289)).setAttribute("y","663" );
      ((Element)v.get(289)).setAttribute("ID","botonContenido" );
      ((Element)v.get(289)).setAttribute("img","separa_base" );
      ((Element)v.get(289)).setAttribute("tipo","0" );
      ((Element)v.get(289)).setAttribute("estado","false" );
      ((Element)v.get(289)).setAttribute("alt","" );
      ((Element)v.get(289)).setAttribute("codigo","" );
      ((Element)v.get(289)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(290)).setAttribute("nombre","listado2" );
      ((Element)v.get(290)).setAttribute("ancho","579" );
      ((Element)v.get(290)).setAttribute("alto","317" );
      ((Element)v.get(290)).setAttribute("x","12" );
      ((Element)v.get(290)).setAttribute("y","752" );
      ((Element)v.get(290)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(290)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(291)).setAttribute("precarga","S" );
      ((Element)v.get(291)).setAttribute("conROver","S" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(292)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(292)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(292)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(292)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 291   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(293)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(293)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(293)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(293)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(291)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(294)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(294)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(291)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:291   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(290)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(296)).setAttribute("borde","1" );
      ((Element)v.get(296)).setAttribute("horizDatos","1" );
      ((Element)v.get(296)).setAttribute("horizCabecera","1" );
      ((Element)v.get(296)).setAttribute("vertical","0" );
      ((Element)v.get(296)).setAttribute("horizTitulo","1" );
      ((Element)v.get(296)).setAttribute("horizBase","1" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 295   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(297)).setAttribute("borde","#999999" );
      ((Element)v.get(297)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(297)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(297)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(297)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(297)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(297)).setAttribute("horizBase","#999999" );
      ((Element)v.get(295)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:295   */

      /* Empieza nodo:298 / Elemento padre: 290   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(298)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(298)).setAttribute("alto","22" );
      ((Element)v.get(298)).setAttribute("imgFondo","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(298)).setAttribute("cod","00135" );
      ((Element)v.get(298)).setAttribute("ID","datosTitle" );
      ((Element)v.get(290)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 290   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(299)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(299)).setAttribute("alto","22" );
      ((Element)v.get(299)).setAttribute("imgFondo","" );
      ((Element)v.get(290)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 290   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(300)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(300)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(300)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(300)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(300)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(300)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(290)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("ancho","100" );
      ((Element)v.get(301)).setAttribute("minimizable","S" );
      ((Element)v.get(301)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("ancho","100" );
      ((Element)v.get(302)).setAttribute("minimizable","S" );
      ((Element)v.get(302)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("ancho","100" );
      ((Element)v.get(303)).setAttribute("minimizable","S" );
      ((Element)v.get(303)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("ancho","100" );
      ((Element)v.get(304)).setAttribute("minimizable","S" );
      ((Element)v.get(304)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","100" );
      ((Element)v.get(305)).setAttribute("minimizable","S" );
      ((Element)v.get(305)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("ancho","100" );
      ((Element)v.get(306)).setAttribute("minimizable","S" );
      ((Element)v.get(306)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("ancho","100" );
      ((Element)v.get(307)).setAttribute("minimizable","S" );
      ((Element)v.get(307)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","100" );
      ((Element)v.get(308)).setAttribute("minimizable","S" );
      ((Element)v.get(308)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:300   */

      /* Empieza nodo:309 / Elemento padre: 290   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(309)).setAttribute("alto","20" );
      ((Element)v.get(309)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(309)).setAttribute("imgFondo","" );
      ((Element)v.get(309)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(290)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("colFondo","" );
      ((Element)v.get(310)).setAttribute("ID","EstCab" );
      ((Element)v.get(310)).setAttribute("cod","1604" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("colFondo","" );
      ((Element)v.get(311)).setAttribute("ID","EstCab" );
      ((Element)v.get(311)).setAttribute("cod","1607" );
      ((Element)v.get(309)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("colFondo","" );
      ((Element)v.get(312)).setAttribute("ID","EstCab" );
      ((Element)v.get(312)).setAttribute("cod","1605" );
      ((Element)v.get(309)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("colFondo","" );
      ((Element)v.get(313)).setAttribute("ID","EstCab" );
      ((Element)v.get(313)).setAttribute("cod","1175" );
      ((Element)v.get(309)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("colFondo","" );
      ((Element)v.get(314)).setAttribute("ID","EstCab" );
      ((Element)v.get(314)).setAttribute("cod","1176" );
      ((Element)v.get(309)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(315)).setAttribute("cod","1626" );
      ((Element)v.get(309)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("colFondo","" );
      ((Element)v.get(316)).setAttribute("ID","EstCab" );
      ((Element)v.get(316)).setAttribute("cod","1631" );
      ((Element)v.get(309)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("colFondo","" );
      ((Element)v.get(317)).setAttribute("ID","EstCab" );
      ((Element)v.get(317)).setAttribute("cod","795" );
      ((Element)v.get(309)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:309   */

      /* Empieza nodo:318 / Elemento padre: 290   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(318)).setAttribute("alto","22" );
      ((Element)v.get(318)).setAttribute("accion","" );
      ((Element)v.get(318)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(318)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(318)).setAttribute("maxSel","-1" );
      ((Element)v.get(318)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(318)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(318)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(318)).setAttribute("onLoad","" );
      ((Element)v.get(318)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(290)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat2" );
      ((Element)v.get(318)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat" );
      ((Element)v.get(318)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat2" );
      ((Element)v.get(318)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat" );
      ((Element)v.get(318)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("tipo","texto" );
      ((Element)v.get(324)).setAttribute("ID","EstDat2" );
      ((Element)v.get(318)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("tipo","texto" );
      ((Element)v.get(325)).setAttribute("ID","EstDat" );
      ((Element)v.get(318)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 318   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("tipo","texto" );
      ((Element)v.get(326)).setAttribute("ID","EstDat2" );
      ((Element)v.get(318)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:318   */

      /* Empieza nodo:327 / Elemento padre: 290   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(290)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 290   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(328)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(328)).setAttribute("ancho","579" );
      ((Element)v.get(328)).setAttribute("sep","$" );
      ((Element)v.get(328)).setAttribute("x","12" );
      ((Element)v.get(328)).setAttribute("class","botonera" );
      ((Element)v.get(328)).setAttribute("y","1046" );
      ((Element)v.get(328)).setAttribute("control","|" );
      ((Element)v.get(328)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(328)).setAttribute("rowset","" );
      ((Element)v.get(328)).setAttribute("cargainicial","S" );
      ((Element)v.get(290)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(329)).setAttribute("nombre","ret2" );
      ((Element)v.get(329)).setAttribute("x","37" );
      ((Element)v.get(329)).setAttribute("y","1050" );
      ((Element)v.get(329)).setAttribute("ID","botonContenido" );
      ((Element)v.get(329)).setAttribute("img","retroceder_on" );
      ((Element)v.get(329)).setAttribute("tipo","0" );
      ((Element)v.get(329)).setAttribute("estado","false" );
      ((Element)v.get(329)).setAttribute("alt","" );
      ((Element)v.get(329)).setAttribute("codigo","" );
      ((Element)v.get(329)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 328   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(330)).setAttribute("nombre","ava2" );
      ((Element)v.get(330)).setAttribute("x","52" );
      ((Element)v.get(330)).setAttribute("y","1050" );
      ((Element)v.get(330)).setAttribute("ID","botonContenido" );
      ((Element)v.get(330)).setAttribute("img","avanzar_on" );
      ((Element)v.get(330)).setAttribute("tipo","0" );
      ((Element)v.get(330)).setAttribute("estado","false" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(330)).setAttribute("alt","" );
      ((Element)v.get(330)).setAttribute("codigo","" );
      ((Element)v.get(330)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(328)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:328   */
      /* Termina nodo:290   */

      /* Empieza nodo:331 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(331)).setAttribute("nombre","primera2" );
      ((Element)v.get(331)).setAttribute("x","20" );
      ((Element)v.get(331)).setAttribute("y","1050" );
      ((Element)v.get(331)).setAttribute("ID","botonContenido" );
      ((Element)v.get(331)).setAttribute("img","primera_on" );
      ((Element)v.get(331)).setAttribute("tipo","-2" );
      ((Element)v.get(331)).setAttribute("estado","false" );
      ((Element)v.get(331)).setAttribute("alt","" );
      ((Element)v.get(331)).setAttribute("codigo","" );
      ((Element)v.get(331)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(332)).setAttribute("nombre","separa2" );
      ((Element)v.get(332)).setAttribute("x","59" );
      ((Element)v.get(332)).setAttribute("y","1046" );
      ((Element)v.get(332)).setAttribute("ID","botonContenido" );
      ((Element)v.get(332)).setAttribute("img","separa_base" );
      ((Element)v.get(332)).setAttribute("tipo","0" );
      ((Element)v.get(332)).setAttribute("estado","false" );
      ((Element)v.get(332)).setAttribute("alt","" );
      ((Element)v.get(332)).setAttribute("codigo","" );
      ((Element)v.get(332)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(333)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(333)).setAttribute("x","80" );
      ((Element)v.get(333)).setAttribute("y","1047" );
      ((Element)v.get(333)).setAttribute("ID","botonContenido" );
      ((Element)v.get(333)).setAttribute("tipo","html" );
      ((Element)v.get(333)).setAttribute("estado","false" );
      ((Element)v.get(333)).setAttribute("cod","3" );
      ((Element)v.get(3)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(334)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(334)).setAttribute("alto","12" );
      ((Element)v.get(334)).setAttribute("ancho","100%" );
      ((Element)v.get(334)).setAttribute("colorf","" );
      ((Element)v.get(334)).setAttribute("borde","0" );
      ((Element)v.get(334)).setAttribute("imagenf","" );
      ((Element)v.get(334)).setAttribute("repeat","" );
      ((Element)v.get(334)).setAttribute("padding","" );
      ((Element)v.get(334)).setAttribute("visibilidad","visible" );
      ((Element)v.get(334)).setAttribute("contravsb","" );
      ((Element)v.get(334)).setAttribute("x","0" );
      ((Element)v.get(334)).setAttribute("y","1069" );
      ((Element)v.get(334)).setAttribute("zindex","" );
      ((Element)v.get(3)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:3   */


   }

}
