
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0493" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Productos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    \r    DrdEnsanchaConMargenDcho('listado2',12);\r    document.all[\"Cplistado2\"].style.visibility='hidden';\r    document.all[\"CpLin1listado2\"].style.visibility='hidden';\r    document.all[\"CpLin2listado2\"].style.visibility='hidden';\r    document.all[\"CpLin3listado2\"].style.visibility='hidden';\r    document.all[\"CpLin4listado2\"].style.visibility='hidden';\r    document.all[\"primera2Div\"].style.visibility='hidden';\r    document.all[\"ret2Div\"].style.visibility='hidden';\r    document.all[\"ava2Div\"].style.visibility='hidden';\r    document.all[\"separa2Div\"].style.visibility='hidden';\r   \r    DrdEnsanchaConMargenDcho('listado3',12);\r    document.all[\"Cplistado3\"].style.visibility='hidden';\r    document.all[\"CpLin1listado3\"].style.visibility='hidden';\r    document.all[\"CpLin2listado3\"].style.visibility='hidden';\r    document.all[\"CpLin3listado3\"].style.visibility='hidden';\r    document.all[\"CpLin4listado3\"].style.visibility='hidden';\r    document.all[\"primera3Div\"].style.visibility='hidden';\r    document.all[\"ret3Div\"].style.visibility='hidden';\r    document.all[\"ava3Div\"].style.visibility='hidden';\r    document.all[\"separa3Div\"].style.visibility='hidden';\r    \r    DrdEnsanchaConMargenDcho('listado4',12);\r    document.all[\"Cplistado4\"].style.visibility='hidden';\r    document.all[\"CpLin1listado4\"].style.visibility='hidden';\r    document.all[\"CpLin2listado4\"].style.visibility='hidden';\r    document.all[\"CpLin3listado4\"].style.visibility='hidden';\r    document.all[\"CpLin4listado4\"].style.visibility='hidden';\r    document.all[\"primera4Div\"].style.visibility='hidden';\r    document.all[\"ret4Div\"].style.visibility='hidden';\r    document.all[\"ava4Div\"].style.visibility='hidden';\r    document.all[\"separa4Div\"].style.visibility='hidden';\r    \r    DrdEnsanchaConMargenDcho('listado5',12);\r    document.all[\"Cplistado5\"].style.visibility='hidden';\r    document.all[\"CpLin1listado5\"].style.visibility='hidden';\r    document.all[\"CpLin2listado5\"].style.visibility='hidden';\r    document.all[\"CpLin3listado5\"].style.visibility='hidden';\r    document.all[\"CpLin4listado5\"].style.visibility='hidden';\r    document.all[\"primera5Div\"].style.visibility='hidden';\r    document.all[\"ret5Div\"].style.visibility='hidden';\r    document.all[\"ava5Div\"].style.visibility='hidden';\r    document.all[\"separa5Div\"].style.visibility='hidden';\r    \r    DrdEnsanchaConMargenDcho('listado6',12);\r    document.all[\"Cplistado6\"].style.visibility='hidden';\r    document.all[\"CpLin1listado6\"].style.visibility='hidden';\r    document.all[\"CpLin2listado6\"].style.visibility='hidden';\r    document.all[\"CpLin3listado6\"].style.visibility='hidden';\r    document.all[\"CpLin4listado6\"].style.visibility='hidden';\r    document.all[\"primera6Div\"].style.visibility='hidden';\r    document.all[\"ret6Div\"].style.visibility='hidden';\r    document.all[\"ava6Div\"].style.visibility='hidden';\r    document.all[\"separa6Div\"].style.visibility='hidden';\r    eval (ON_RSZ);  \r\r   }\r   \r   \r"));
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
      ((Element)v.get(18)).setAttribute("nombre","lblDatos" );
      ((Element)v.get(18)).setAttribute("alto","13" );
      ((Element)v.get(18)).setAttribute("filas","1" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(18)).setAttribute("id","legend" );
      ((Element)v.get(18)).setAttribute("cod","00333" );
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
      ((Element)v.get(22)).setAttribute("width","400" );
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
      ((Element)v.get(30)).setAttribute("nombre","lblProductos1" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","datosTitle" );
      ((Element)v.get(30)).setAttribute("cod","515" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","100%" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","8" );
      ((Element)v.get(32)).setAttribute("height","8" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:26   */

      /* Empieza nodo:33 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","8" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(37)).setAttribute("nombre","cbProductos" );
      ((Element)v.get(37)).setAttribute("id","datosCampos" );
      ((Element)v.get(37)).setAttribute("size","1" );
      ((Element)v.get(37)).setAttribute("multiple","N" );
      ((Element)v.get(37)).setAttribute("req","S" );
      ((Element)v.get(37)).setAttribute("valorinicial","" );
      ((Element)v.get(37)).setAttribute("textoinicial","Productos válidos" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(39)).setAttribute("ID","1" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(40)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(40)).setAttribute("TIPO","STRING" );
      ((Element)v.get(40)).setAttribute("VALOR","00" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(41)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(41)).setAttribute("TIPO","STRING" );
      ((Element)v.get(41)).setAttribute("VALOR","Productos excluidos" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(42)).setAttribute("ID","2" );
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(43)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(43)).setAttribute("TIPO","STRING" );
      ((Element)v.get(43)).setAttribute("VALOR","01" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(44)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(44)).setAttribute("TIPO","STRING" );
      ((Element)v.get(44)).setAttribute("VALOR","Productos bonificados" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 38   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(45)).setAttribute("ID","3" );
      ((Element)v.get(38)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(46)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(46)).setAttribute("TIPO","STRING" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("VALOR","02" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 45   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(47)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(47)).setAttribute("TIPO","STRING" );
      ((Element)v.get(47)).setAttribute("VALOR","Productos exigidos" );
      ((Element)v.get(45)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:45   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:48 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(33)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:33   */

      /* Empieza nodo:50 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","4" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:53 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:12   */

      /* Empieza nodo:55 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(60)).setAttribute("border","0" );
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(60)).setAttribute("cellspacing","0" );
      ((Element)v.get(60)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("class","botonera" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(63)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(63)).setAttribute("ID","botonContenido" );
      ((Element)v.get(63)).setAttribute("tipo","html" );
      ((Element)v.get(63)).setAttribute("accion","" );
      ((Element)v.get(63)).setAttribute("estado","false" );
      ((Element)v.get(63)).setAttribute("cod","12" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","12" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:55   */

      /* Empieza nodo:66 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("height","12" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","756" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","12" );
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","1" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:66   */
      /* Termina nodo:4   */

      /* Empieza nodo:73 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(73)).setAttribute("nombre","listado1" );
      ((Element)v.get(73)).setAttribute("ancho","404" );
      ((Element)v.get(73)).setAttribute("alto","337" );
      ((Element)v.get(73)).setAttribute("x","12" );
      ((Element)v.get(73)).setAttribute("y","126" );
      ((Element)v.get(73)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(73)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(74)).setAttribute("precarga","S" );
      ((Element)v.get(74)).setAttribute("conROver","S" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(75)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(75)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(75)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(75)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 74   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(76)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(76)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(76)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(76)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(77)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(77)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:74   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(79)).setAttribute("borde","1" );
      ((Element)v.get(79)).setAttribute("horizDatos","1" );
      ((Element)v.get(79)).setAttribute("horizCabecera","1" );
      ((Element)v.get(79)).setAttribute("vertical","1" );
      ((Element)v.get(79)).setAttribute("horizTitulo","1" );
      ((Element)v.get(79)).setAttribute("horizBase","1" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(80)).setAttribute("borde","#999999" );
      ((Element)v.get(80)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(80)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(80)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(80)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(80)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(80)).setAttribute("horizBase","#999999" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 73   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(81)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(81)).setAttribute("alto","22" );
      ((Element)v.get(81)).setAttribute("imgFondo","" );
      ((Element)v.get(81)).setAttribute("cod","00338" );
      ((Element)v.get(81)).setAttribute("ID","datosTitle" );
      ((Element)v.get(73)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 73   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(82)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(82)).setAttribute("alto","22" );
      ((Element)v.get(82)).setAttribute("imgFondo","" );
      ((Element)v.get(73)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 73   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(83)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(83)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(83)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(83)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(83)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(83)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(73)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("ancho","150" );
      ((Element)v.get(84)).setAttribute("minimizable","S" );
      ((Element)v.get(84)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("ancho","150" );
      ((Element)v.get(85)).setAttribute("minimizable","S" );
      ((Element)v.get(85)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("ancho","150" );
      ((Element)v.get(86)).setAttribute("minimizable","S" );
      ((Element)v.get(86)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("ancho","150" );
      ((Element)v.get(87)).setAttribute("minimizable","S" );
      ((Element)v.get(87)).setAttribute("minimizada","N" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("ancho","150" );
      ((Element)v.get(88)).setAttribute("minimizable","S" );
      ((Element)v.get(88)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("ancho","150" );
      ((Element)v.get(89)).setAttribute("minimizable","S" );
      ((Element)v.get(89)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","150" );
      ((Element)v.get(90)).setAttribute("minimizable","S" );
      ((Element)v.get(90)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","150" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","150" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","150" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:83   */

      /* Empieza nodo:94 / Elemento padre: 73   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(94)).setAttribute("alto","40" );
      ((Element)v.get(94)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(94)).setAttribute("imgFondo","" );
      ((Element)v.get(94)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(94)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(73)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(95)).setAttribute("colFondo","" );
      ((Element)v.get(95)).setAttribute("ID","EstCab" );
      ((Element)v.get(95)).setAttribute("cod","00335" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("colFondo","" );
      ((Element)v.get(96)).setAttribute("ID","EstCab" );
      ((Element)v.get(96)).setAttribute("cod","6" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Elemento padre:96 / Elemento actual: 97   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(96)).appendChild((Text)v.get(97));

      /* Termina nodo Texto:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("colFondo","" );
      ((Element)v.get(98)).setAttribute("ID","EstCab" );
      ((Element)v.get(98)).setAttribute("cod","1338" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Elemento padre:98 / Elemento actual: 99   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(98)).appendChild((Text)v.get(99));

      /* Termina nodo Texto:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("colFondo","" );
      ((Element)v.get(100)).setAttribute("ID","EstCab" );
      ((Element)v.get(100)).setAttribute("cod","588" );
      ((Element)v.get(95)).appendChild((Element)v.get(100));

      /* Elemento padre:100 / Elemento actual: 101   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(100)).appendChild((Text)v.get(101));

      /* Termina nodo Texto:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("colFondo","" );
      ((Element)v.get(102)).setAttribute("ID","EstCab" );
      ((Element)v.get(102)).setAttribute("cod","590" );
      ((Element)v.get(95)).appendChild((Element)v.get(102));

      /* Elemento padre:102 / Elemento actual: 103   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(102)).appendChild((Text)v.get(103));

      /* Termina nodo Texto:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 95   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("colFondo","" );
      ((Element)v.get(104)).setAttribute("ID","EstCab" );
      ((Element)v.get(104)).setAttribute("cod","589" );
      ((Element)v.get(95)).appendChild((Element)v.get(104));

      /* Elemento padre:104 / Elemento actual: 105   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(104)).appendChild((Text)v.get(105));

      /* Termina nodo Texto:105   */
      /* Termina nodo:104   */
      /* Termina nodo:95   */

      /* Empieza nodo:106 / Elemento padre: 94   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(106)).setAttribute("colFondo","" );
      ((Element)v.get(106)).setAttribute("ID","EstCab" );
      ((Element)v.get(106)).setAttribute("cod","00336" );
      ((Element)v.get(94)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","608" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Elemento padre:107 / Elemento actual: 108   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(107)).appendChild((Text)v.get(108));

      /* Termina nodo Texto:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","581" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */
      /* Termina nodo:106   */

      /* Empieza nodo:111 / Elemento padre: 94   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","00337" );
      ((Element)v.get(94)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","337" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Elemento padre:112 / Elemento actual: 113   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(112)).appendChild((Text)v.get(113));

      /* Termina nodo Texto:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("cod","608" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Elemento padre:114 / Elemento actual: 115   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(114)).appendChild((Text)v.get(115));

      /* Termina nodo Texto:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("colFondo","" );
      ((Element)v.get(116)).setAttribute("ID","EstCab" );
      ((Element)v.get(116)).setAttribute("cod","581" );
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Elemento padre:116 / Elemento actual: 117   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(116)).appendChild((Text)v.get(117));

      /* Termina nodo Texto:117   */
      /* Termina nodo:116   */
      /* Termina nodo:111   */
      /* Termina nodo:94   */

      /* Empieza nodo:118 / Elemento padre: 73   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(118)).setAttribute("alto","22" );
      ((Element)v.get(118)).setAttribute("accion","" );
      ((Element)v.get(118)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(118)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(118)).setAttribute("maxSel","-1" );
      ((Element)v.get(118)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(118)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(118)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(118)).setAttribute("onLoad","" );
      ((Element)v.get(118)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(73)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("tipo","texto" );
      ((Element)v.get(119)).setAttribute("ID","EstDat" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat2" );
      ((Element)v.get(118)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat2" );
      ((Element)v.get(118)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat" );
      ((Element)v.get(118)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat2" );
      ((Element)v.get(118)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat" );
      ((Element)v.get(118)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat2" );
      ((Element)v.get(118)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat" );
      ((Element)v.get(118)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat2" );
      ((Element)v.get(118)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:118   */

      /* Empieza nodo:129 / Elemento padre: 73   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(73)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 73   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(130)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(130)).setAttribute("ancho","404" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("sep","$" );
      ((Element)v.get(130)).setAttribute("x","12" );
      ((Element)v.get(130)).setAttribute("class","botonera" );
      ((Element)v.get(130)).setAttribute("y","440" );
      ((Element)v.get(130)).setAttribute("control","|" );
      ((Element)v.get(130)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(130)).setAttribute("rowset","" );
      ((Element)v.get(130)).setAttribute("cargainicial","S" );
      ((Element)v.get(73)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(131)).setAttribute("nombre","ret1" );
      ((Element)v.get(131)).setAttribute("x","37" );
      ((Element)v.get(131)).setAttribute("y","444" );
      ((Element)v.get(131)).setAttribute("ID","botonContenido" );
      ((Element)v.get(131)).setAttribute("img","retroceder_on" );
      ((Element)v.get(131)).setAttribute("tipo","0" );
      ((Element)v.get(131)).setAttribute("estado","false" );
      ((Element)v.get(131)).setAttribute("alt","" );
      ((Element)v.get(131)).setAttribute("codigo","" );
      ((Element)v.get(131)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(132)).setAttribute("nombre","ava1" );
      ((Element)v.get(132)).setAttribute("x","52" );
      ((Element)v.get(132)).setAttribute("y","444" );
      ((Element)v.get(132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(132)).setAttribute("img","avanzar_on" );
      ((Element)v.get(132)).setAttribute("tipo","0" );
      ((Element)v.get(132)).setAttribute("estado","false" );
      ((Element)v.get(132)).setAttribute("alt","" );
      ((Element)v.get(132)).setAttribute("codigo","" );
      ((Element)v.get(132)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(130)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:130   */
      /* Termina nodo:73   */

      /* Empieza nodo:133 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(133)).setAttribute("nombre","primera1" );
      ((Element)v.get(133)).setAttribute("x","20" );
      ((Element)v.get(133)).setAttribute("y","444" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("img","primera_on" );
      ((Element)v.get(133)).setAttribute("tipo","-2" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("alt","" );
      ((Element)v.get(133)).setAttribute("codigo","" );
      ((Element)v.get(133)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","separa" );
      ((Element)v.get(134)).setAttribute("x","59" );
      ((Element)v.get(134)).setAttribute("y","440" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
      ((Element)v.get(134)).setAttribute("img","separa_base" );
      ((Element)v.get(134)).setAttribute("tipo","0" );
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("alt","" );
      ((Element)v.get(134)).setAttribute("codigo","" );
      ((Element)v.get(134)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(135)).setAttribute("nombre","listado2" );
      ((Element)v.get(135)).setAttribute("ancho","404" );
      ((Element)v.get(135)).setAttribute("alto","337" );
      ((Element)v.get(135)).setAttribute("x","12" );
      ((Element)v.get(135)).setAttribute("y","126" );
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
   }

   private void getXML630(Document doc) {
      ((Element)v.get(141)).setAttribute("horizDatos","1" );
      ((Element)v.get(141)).setAttribute("horizCabecera","1" );
      ((Element)v.get(141)).setAttribute("vertical","1" );
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
      ((Element)v.get(143)).setAttribute("cod","00339" );
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
      ((Element)v.get(146)).setAttribute("ancho","150" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","150" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","150" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","150" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","150" );
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
      ((Element)v.get(153)).setAttribute("ancho","150" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","150" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","150" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 145   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","150" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 145   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","150" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:145   */

      /* Empieza nodo:158 / Elemento padre: 135   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(158)).setAttribute("alto","40" );
      ((Element)v.get(158)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(158)).setAttribute("imgFondo","" );
      ((Element)v.get(158)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(158)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","00335" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","6" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Elemento padre:160 / Elemento actual: 161   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(160)).appendChild((Text)v.get(161));

      /* Termina nodo Texto:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("cod","1338" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Elemento padre:162 / Elemento actual: 163   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(162)).appendChild((Text)v.get(163));

      /* Termina nodo Texto:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","588" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Elemento padre:164 / Elemento actual: 165   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(164)).appendChild((Text)v.get(165));

      /* Termina nodo Texto:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("cod","590" );
      ((Element)v.get(159)).appendChild((Element)v.get(166));

      /* Elemento padre:166 / Elemento actual: 167   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(166)).appendChild((Text)v.get(167));

      /* Termina nodo Texto:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","589" );
      ((Element)v.get(159)).appendChild((Element)v.get(168));

      /* Elemento padre:168 / Elemento actual: 169   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(168)).appendChild((Text)v.get(169));

      /* Termina nodo Texto:169   */
      /* Termina nodo:168   */
      /* Termina nodo:159   */

      /* Empieza nodo:170 / Elemento padre: 158   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(170)).setAttribute("colFondo","" );
      ((Element)v.get(170)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).setAttribute("cod","00336" );
      ((Element)v.get(158)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","608" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Elemento padre:171 / Elemento actual: 172   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(171)).appendChild((Text)v.get(172));

      /* Termina nodo Texto:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","581" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Elemento padre:173 / Elemento actual: 174   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(173)).appendChild((Text)v.get(174));

      /* Termina nodo Texto:174   */
      /* Termina nodo:173   */
      /* Termina nodo:170   */

      /* Empieza nodo:175 / Elemento padre: 158   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","00337" );
      ((Element)v.get(158)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","337" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Elemento padre:176 / Elemento actual: 177   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(176)).appendChild((Text)v.get(177));

      /* Termina nodo Texto:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","608" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Elemento padre:178 / Elemento actual: 179   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(178)).appendChild((Text)v.get(179));

      /* Termina nodo Texto:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","581" );
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */
      /* Termina nodo:175   */

      /* Empieza nodo:182 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","1175" );
      ((Element)v.get(158)).appendChild((Element)v.get(182));

      /* Elemento padre:182 / Elemento actual: 183   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(182)).appendChild((Text)v.get(183));

      /* Termina nodo Texto:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 158   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","1176" );
      ((Element)v.get(158)).appendChild((Element)v.get(184));

      /* Elemento padre:184 / Elemento actual: 185   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(184)).appendChild((Text)v.get(185));

      /* Termina nodo Texto:185   */
      /* Termina nodo:184   */
      /* Termina nodo:158   */

      /* Empieza nodo:186 / Elemento padre: 135   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(186)).setAttribute("alto","22" );
      ((Element)v.get(186)).setAttribute("accion","" );
      ((Element)v.get(186)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(186)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(186)).setAttribute("maxSel","-1" );
      ((Element)v.get(186)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(186)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(186)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(186)).setAttribute("onLoad","" );
      ((Element)v.get(186)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(135)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat2" );
      ((Element)v.get(186)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat" );
      ((Element)v.get(186)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat2" );
      ((Element)v.get(186)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat" );
      ((Element)v.get(186)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat2" );
      ((Element)v.get(186)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat" );
      ((Element)v.get(186)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","texto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat2" );
      ((Element)v.get(186)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("tipo","texto" );
      ((Element)v.get(195)).setAttribute("ID","EstDat" );
      ((Element)v.get(186)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("tipo","texto" );
      ((Element)v.get(196)).setAttribute("ID","EstDat2" );
      ((Element)v.get(186)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","texto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat" );
      ((Element)v.get(186)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat2" );
      ((Element)v.get(186)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:186   */

      /* Empieza nodo:199 / Elemento padre: 135   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(135)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 135   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(200)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(200)).setAttribute("ancho","404" );
      ((Element)v.get(200)).setAttribute("sep","$" );
      ((Element)v.get(200)).setAttribute("x","12" );
      ((Element)v.get(200)).setAttribute("class","botonera" );
      ((Element)v.get(200)).setAttribute("y","440" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(200)).setAttribute("control","|" );
      ((Element)v.get(200)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(200)).setAttribute("rowset","" );
      ((Element)v.get(200)).setAttribute("cargainicial","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(201)).setAttribute("nombre","ret2" );
      ((Element)v.get(201)).setAttribute("x","37" );
      ((Element)v.get(201)).setAttribute("y","444" );
      ((Element)v.get(201)).setAttribute("ID","botonContenido" );
      ((Element)v.get(201)).setAttribute("img","retroceder_on" );
      ((Element)v.get(201)).setAttribute("tipo","0" );
      ((Element)v.get(201)).setAttribute("estado","false" );
      ((Element)v.get(201)).setAttribute("alt","" );
      ((Element)v.get(201)).setAttribute("codigo","" );
      ((Element)v.get(201)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 200   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(202)).setAttribute("nombre","ava2" );
      ((Element)v.get(202)).setAttribute("x","52" );
      ((Element)v.get(202)).setAttribute("y","444" );
      ((Element)v.get(202)).setAttribute("ID","botonContenido" );
      ((Element)v.get(202)).setAttribute("img","avanzar_on" );
      ((Element)v.get(202)).setAttribute("tipo","0" );
      ((Element)v.get(202)).setAttribute("estado","false" );
      ((Element)v.get(202)).setAttribute("alt","" );
      ((Element)v.get(202)).setAttribute("codigo","" );
      ((Element)v.get(202)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(200)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:200   */
      /* Termina nodo:135   */

      /* Empieza nodo:203 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(203)).setAttribute("nombre","primera2" );
      ((Element)v.get(203)).setAttribute("x","20" );
      ((Element)v.get(203)).setAttribute("y","444" );
      ((Element)v.get(203)).setAttribute("ID","botonContenido" );
      ((Element)v.get(203)).setAttribute("img","primera_on" );
      ((Element)v.get(203)).setAttribute("tipo","-2" );
      ((Element)v.get(203)).setAttribute("estado","false" );
      ((Element)v.get(203)).setAttribute("alt","" );
      ((Element)v.get(203)).setAttribute("codigo","" );
      ((Element)v.get(203)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(204)).setAttribute("nombre","separa2" );
      ((Element)v.get(204)).setAttribute("x","59" );
      ((Element)v.get(204)).setAttribute("y","440" );
      ((Element)v.get(204)).setAttribute("ID","botonContenido" );
      ((Element)v.get(204)).setAttribute("img","separa_base" );
      ((Element)v.get(204)).setAttribute("tipo","0" );
      ((Element)v.get(204)).setAttribute("estado","false" );
      ((Element)v.get(204)).setAttribute("alt","" );
      ((Element)v.get(204)).setAttribute("codigo","" );
      ((Element)v.get(204)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(205)).setAttribute("nombre","listado3" );
      ((Element)v.get(205)).setAttribute("ancho","404" );
      ((Element)v.get(205)).setAttribute("alto","337" );
      ((Element)v.get(205)).setAttribute("x","12" );
      ((Element)v.get(205)).setAttribute("y","126" );
      ((Element)v.get(205)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(205)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(206)).setAttribute("precarga","S" );
      ((Element)v.get(206)).setAttribute("conROver","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(207)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(207)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(207)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(207)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 206   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(208)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(208)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(208)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(208)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(209)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(209)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:206   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(211)).setAttribute("borde","1" );
      ((Element)v.get(211)).setAttribute("horizDatos","1" );
      ((Element)v.get(211)).setAttribute("horizCabecera","1" );
      ((Element)v.get(211)).setAttribute("vertical","1" );
      ((Element)v.get(211)).setAttribute("horizTitulo","1" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(211)).setAttribute("horizBase","1" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 210   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(212)).setAttribute("borde","#999999" );
      ((Element)v.get(212)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(212)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(212)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(212)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(212)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(212)).setAttribute("horizBase","#999999" );
      ((Element)v.get(210)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:210   */

      /* Empieza nodo:213 / Elemento padre: 205   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(213)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(213)).setAttribute("alto","22" );
      ((Element)v.get(213)).setAttribute("imgFondo","" );
      ((Element)v.get(213)).setAttribute("cod","00340" );
      ((Element)v.get(213)).setAttribute("ID","datosTitle" );
      ((Element)v.get(205)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(214)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(214)).setAttribute("alto","22" );
      ((Element)v.get(214)).setAttribute("imgFondo","" );
      ((Element)v.get(205)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 205   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(215)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(215)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(215)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(215)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(215)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(215)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","150" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","150" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("ancho","150" );
      ((Element)v.get(218)).setAttribute("minimizable","S" );
      ((Element)v.get(218)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("ancho","150" );
      ((Element)v.get(219)).setAttribute("minimizable","S" );
      ((Element)v.get(219)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("ancho","150" );
      ((Element)v.get(220)).setAttribute("minimizable","S" );
      ((Element)v.get(220)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("ancho","150" );
      ((Element)v.get(221)).setAttribute("minimizable","S" );
      ((Element)v.get(221)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","150" );
      ((Element)v.get(222)).setAttribute("minimizable","S" );
      ((Element)v.get(222)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","150" );
      ((Element)v.get(223)).setAttribute("minimizable","S" );
      ((Element)v.get(223)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","150" );
      ((Element)v.get(224)).setAttribute("minimizable","S" );
      ((Element)v.get(224)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","150" );
      ((Element)v.get(225)).setAttribute("minimizable","S" );
      ((Element)v.get(225)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","150" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","150" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(215)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","150" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 215   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","150" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:215   */

      /* Empieza nodo:230 / Elemento padre: 205   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(230)).setAttribute("alto","40" );
      ((Element)v.get(230)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(230)).setAttribute("imgFondo","" );
      ((Element)v.get(230)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(230)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(231)).setAttribute("colFondo","" );
      ((Element)v.get(231)).setAttribute("ID","EstCab" );
      ((Element)v.get(231)).setAttribute("cod","00335" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("colFondo","" );
      ((Element)v.get(232)).setAttribute("ID","EstCab" );
      ((Element)v.get(232)).setAttribute("cod","6" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Elemento padre:232 / Elemento actual: 233   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(232)).appendChild((Text)v.get(233));

      /* Termina nodo Texto:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("colFondo","" );
      ((Element)v.get(234)).setAttribute("ID","EstCab" );
      ((Element)v.get(234)).setAttribute("cod","1338" );
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Elemento padre:234 / Elemento actual: 235   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(234)).appendChild((Text)v.get(235));

      /* Termina nodo Texto:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 231   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("colFondo","" );
      ((Element)v.get(236)).setAttribute("ID","EstCab" );
      ((Element)v.get(236)).setAttribute("cod","588" );
      ((Element)v.get(231)).appendChild((Element)v.get(236));

      /* Elemento padre:236 / Elemento actual: 237   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(236)).appendChild((Text)v.get(237));

      /* Termina nodo Texto:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 231   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("colFondo","" );
      ((Element)v.get(238)).setAttribute("ID","EstCab" );
      ((Element)v.get(238)).setAttribute("cod","590" );
      ((Element)v.get(231)).appendChild((Element)v.get(238));

      /* Elemento padre:238 / Elemento actual: 239   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(238)).appendChild((Text)v.get(239));

      /* Termina nodo Texto:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 231   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("colFondo","" );
      ((Element)v.get(240)).setAttribute("ID","EstCab" );
      ((Element)v.get(240)).setAttribute("cod","589" );
      ((Element)v.get(231)).appendChild((Element)v.get(240));

      /* Elemento padre:240 / Elemento actual: 241   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(240)).appendChild((Text)v.get(241));

      /* Termina nodo Texto:241   */
      /* Termina nodo:240   */
      /* Termina nodo:231   */

      /* Empieza nodo:242 / Elemento padre: 230   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(242)).setAttribute("colFondo","" );
      ((Element)v.get(242)).setAttribute("ID","EstCab" );
      ((Element)v.get(242)).setAttribute("cod","00336" );
      ((Element)v.get(230)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("colFondo","" );
      ((Element)v.get(243)).setAttribute("ID","EstCab" );
      ((Element)v.get(243)).setAttribute("cod","608" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Elemento padre:243 / Elemento actual: 244   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(243)).appendChild((Text)v.get(244));

      /* Termina nodo Texto:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("colFondo","" );
      ((Element)v.get(245)).setAttribute("ID","EstCab" );
      ((Element)v.get(245)).setAttribute("cod","581" );
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Elemento padre:245 / Elemento actual: 246   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(245)).appendChild((Text)v.get(246));

      /* Termina nodo Texto:246   */
      /* Termina nodo:245   */
      /* Termina nodo:242   */

      /* Empieza nodo:247 / Elemento padre: 230   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(247)).setAttribute("colFondo","" );
      ((Element)v.get(247)).setAttribute("ID","EstCab" );
      ((Element)v.get(247)).setAttribute("cod","00337" );
      ((Element)v.get(230)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("colFondo","" );
      ((Element)v.get(248)).setAttribute("ID","EstCab" );
      ((Element)v.get(248)).setAttribute("cod","337" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Elemento padre:248 / Elemento actual: 249   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(248)).appendChild((Text)v.get(249));

      /* Termina nodo Texto:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(250)).setAttribute("colFondo","" );
      ((Element)v.get(250)).setAttribute("ID","EstCab" );
      ((Element)v.get(250)).setAttribute("cod","608" );
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Elemento padre:250 / Elemento actual: 251   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(250)).appendChild((Text)v.get(251));

      /* Termina nodo Texto:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("colFondo","" );
      ((Element)v.get(252)).setAttribute("ID","EstCab" );
      ((Element)v.get(252)).setAttribute("cod","581" );
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Elemento padre:252 / Elemento actual: 253   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(252)).appendChild((Text)v.get(253));

      /* Termina nodo Texto:253   */
      /* Termina nodo:252   */
      /* Termina nodo:247   */

      /* Empieza nodo:254 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("colFondo","" );
      ((Element)v.get(254)).setAttribute("ID","EstCab" );
      ((Element)v.get(254)).setAttribute("cod","1175" );
      ((Element)v.get(230)).appendChild((Element)v.get(254));

      /* Elemento padre:254 / Elemento actual: 255   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(254)).appendChild((Text)v.get(255));

      /* Termina nodo Texto:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("colFondo","" );
      ((Element)v.get(256)).setAttribute("ID","EstCab" );
      ((Element)v.get(256)).setAttribute("cod","1176" );
      ((Element)v.get(230)).appendChild((Element)v.get(256));

      /* Elemento padre:256 / Elemento actual: 257   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(256)).appendChild((Text)v.get(257));

      /* Termina nodo Texto:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("colFondo","" );
      ((Element)v.get(258)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).setAttribute("cod","1813" );
      ((Element)v.get(230)).appendChild((Element)v.get(258));

      /* Elemento padre:258 / Elemento actual: 259   */
      v.add(doc.createTextNode("Puntos unidad"));
      ((Element)v.get(258)).appendChild((Text)v.get(259));

      /* Termina nodo Texto:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 230   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("colFondo","" );
      ((Element)v.get(260)).setAttribute("ID","EstCab" );
      ((Element)v.get(260)).setAttribute("cod","1814" );
      ((Element)v.get(230)).appendChild((Element)v.get(260));

      /* Elemento padre:260 / Elemento actual: 261   */
      v.add(doc.createTextNode("Factor multiplicidad"));
      ((Element)v.get(260)).appendChild((Text)v.get(261));

      /* Termina nodo Texto:261   */
      /* Termina nodo:260   */
      /* Termina nodo:230   */

      /* Empieza nodo:262 / Elemento padre: 205   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(262)).setAttribute("alto","22" );
      ((Element)v.get(262)).setAttribute("accion","" );
      ((Element)v.get(262)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(262)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(262)).setAttribute("maxSel","-1" );
      ((Element)v.get(262)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(262)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(262)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(262)).setAttribute("onLoad","" );
      ((Element)v.get(262)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(205)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("tipo","texto" );
      ((Element)v.get(263)).setAttribute("ID","EstDat" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("tipo","texto" );
      ((Element)v.get(264)).setAttribute("ID","EstDat2" );
      ((Element)v.get(262)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("tipo","texto" );
      ((Element)v.get(265)).setAttribute("ID","EstDat" );
      ((Element)v.get(262)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("tipo","texto" );
      ((Element)v.get(266)).setAttribute("ID","EstDat2" );
      ((Element)v.get(262)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("tipo","texto" );
      ((Element)v.get(267)).setAttribute("ID","EstDat" );
      ((Element)v.get(262)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat2" );
      ((Element)v.get(262)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat" );
      ((Element)v.get(262)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat2" );
      ((Element)v.get(262)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat" );
      ((Element)v.get(262)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat2" );
      ((Element)v.get(262)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat" );
      ((Element)v.get(262)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat2" );
      ((Element)v.get(262)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat" );
      ((Element)v.get(262)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat2" );
      ((Element)v.get(262)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:262   */

      /* Empieza nodo:277 / Elemento padre: 205   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(205)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 205   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(278)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(278)).setAttribute("ancho","404" );
      ((Element)v.get(278)).setAttribute("sep","$" );
      ((Element)v.get(278)).setAttribute("x","12" );
      ((Element)v.get(278)).setAttribute("class","botonera" );
      ((Element)v.get(278)).setAttribute("y","440" );
      ((Element)v.get(278)).setAttribute("control","|" );
      ((Element)v.get(278)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(278)).setAttribute("rowset","" );
      ((Element)v.get(278)).setAttribute("cargainicial","S" );
      ((Element)v.get(205)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(279)).setAttribute("nombre","ret3" );
      ((Element)v.get(279)).setAttribute("x","37" );
      ((Element)v.get(279)).setAttribute("y","444" );
      ((Element)v.get(279)).setAttribute("ID","botonContenido" );
      ((Element)v.get(279)).setAttribute("img","retroceder_on" );
      ((Element)v.get(279)).setAttribute("tipo","0" );
      ((Element)v.get(279)).setAttribute("estado","false" );
      ((Element)v.get(279)).setAttribute("alt","" );
      ((Element)v.get(279)).setAttribute("codigo","" );
      ((Element)v.get(279)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 278   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(280)).setAttribute("nombre","ava3" );
      ((Element)v.get(280)).setAttribute("x","52" );
      ((Element)v.get(280)).setAttribute("y","444" );
      ((Element)v.get(280)).setAttribute("ID","botonContenido" );
      ((Element)v.get(280)).setAttribute("img","avanzar_on" );
      ((Element)v.get(280)).setAttribute("tipo","0" );
      ((Element)v.get(280)).setAttribute("estado","false" );
      ((Element)v.get(280)).setAttribute("alt","" );
      ((Element)v.get(280)).setAttribute("codigo","" );
      ((Element)v.get(280)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(278)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:278   */
      /* Termina nodo:205   */

      /* Empieza nodo:281 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(281)).setAttribute("nombre","primera3" );
      ((Element)v.get(281)).setAttribute("x","20" );
      ((Element)v.get(281)).setAttribute("y","444" );
      ((Element)v.get(281)).setAttribute("ID","botonContenido" );
      ((Element)v.get(281)).setAttribute("img","primera_on" );
      ((Element)v.get(281)).setAttribute("tipo","-2" );
      ((Element)v.get(281)).setAttribute("estado","false" );
      ((Element)v.get(281)).setAttribute("alt","" );
      ((Element)v.get(281)).setAttribute("codigo","" );
      ((Element)v.get(281)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(282)).setAttribute("nombre","separa3" );
      ((Element)v.get(282)).setAttribute("x","59" );
      ((Element)v.get(282)).setAttribute("y","440" );
      ((Element)v.get(282)).setAttribute("ID","botonContenido" );
      ((Element)v.get(282)).setAttribute("img","separa_base" );
      ((Element)v.get(282)).setAttribute("tipo","0" );
      ((Element)v.get(282)).setAttribute("estado","false" );
      ((Element)v.get(282)).setAttribute("alt","" );
      ((Element)v.get(282)).setAttribute("codigo","" );
      ((Element)v.get(282)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(283)).setAttribute("nombre","listado4" );
      ((Element)v.get(283)).setAttribute("ancho","404" );
      ((Element)v.get(283)).setAttribute("alto","337" );
      ((Element)v.get(283)).setAttribute("x","12" );
      ((Element)v.get(283)).setAttribute("y","126" );
      ((Element)v.get(283)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(283)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(284)).setAttribute("precarga","S" );
      ((Element)v.get(284)).setAttribute("conROver","S" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(285)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(285)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(285)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(285)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 284   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(286)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(286)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(286)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(286)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(284)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(287)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(287)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(284)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:284   */

      /* Empieza nodo:288 / Elemento padre: 283   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(283)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(289)).setAttribute("borde","1" );
      ((Element)v.get(289)).setAttribute("horizDatos","1" );
      ((Element)v.get(289)).setAttribute("horizCabecera","1" );
      ((Element)v.get(289)).setAttribute("vertical","1" );
      ((Element)v.get(289)).setAttribute("horizTitulo","1" );
      ((Element)v.get(289)).setAttribute("horizBase","1" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 288   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(290)).setAttribute("borde","#999999" );
      ((Element)v.get(290)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(290)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(290)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(290)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(290)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(290)).setAttribute("horizBase","#999999" );
      ((Element)v.get(288)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:288   */

      /* Empieza nodo:291 / Elemento padre: 283   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(291)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(291)).setAttribute("alto","22" );
      ((Element)v.get(291)).setAttribute("imgFondo","" );
      ((Element)v.get(291)).setAttribute("cod","00341" );
      ((Element)v.get(291)).setAttribute("ID","datosTitle" );
      ((Element)v.get(283)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 283   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(292)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(292)).setAttribute("alto","22" );
      ((Element)v.get(292)).setAttribute("imgFondo","" );
      ((Element)v.get(283)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 283   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(293)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(293)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(293)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(293)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(293)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(293)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(283)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("ancho","150" );
      ((Element)v.get(294)).setAttribute("minimizable","S" );
      ((Element)v.get(294)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("ancho","150" );
      ((Element)v.get(295)).setAttribute("minimizable","S" );
      ((Element)v.get(295)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("ancho","150" );
      ((Element)v.get(296)).setAttribute("minimizable","S" );
      ((Element)v.get(296)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("ancho","150" );
      ((Element)v.get(297)).setAttribute("minimizable","S" );
      ((Element)v.get(297)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("ancho","150" );
      ((Element)v.get(298)).setAttribute("minimizable","S" );
      ((Element)v.get(298)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("ancho","150" );
      ((Element)v.get(299)).setAttribute("minimizable","S" );
      ((Element)v.get(299)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(300)).setAttribute("ancho","150" );
      ((Element)v.get(300)).setAttribute("minimizable","S" );
      ((Element)v.get(300)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("ancho","150" );
      ((Element)v.get(301)).setAttribute("minimizable","S" );
      ((Element)v.get(301)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("ancho","150" );
      ((Element)v.get(302)).setAttribute("minimizable","S" );
      ((Element)v.get(302)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("ancho","150" );
      ((Element)v.get(303)).setAttribute("minimizable","S" );
      ((Element)v.get(303)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("ancho","150" );
      ((Element)v.get(304)).setAttribute("minimizable","S" );
      ((Element)v.get(304)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","150" );
      ((Element)v.get(305)).setAttribute("minimizable","S" );
      ((Element)v.get(305)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("ancho","150" );
      ((Element)v.get(306)).setAttribute("minimizable","S" );
      ((Element)v.get(306)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("ancho","150" );
      ((Element)v.get(307)).setAttribute("minimizable","S" );
      ((Element)v.get(307)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","150" );
      ((Element)v.get(308)).setAttribute("minimizable","S" );
      ((Element)v.get(308)).setAttribute("minimizada","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:293   */

      /* Empieza nodo:309 / Elemento padre: 283   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(309)).setAttribute("alto","40" );
      ((Element)v.get(309)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(309)).setAttribute("imgFondo","" );
      ((Element)v.get(309)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(309)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(283)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(310)).setAttribute("colFondo","" );
      ((Element)v.get(310)).setAttribute("ID","EstCab" );
      ((Element)v.get(310)).setAttribute("cod","00335" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("colFondo","" );
      ((Element)v.get(311)).setAttribute("ID","EstCab" );
      ((Element)v.get(311)).setAttribute("cod","6" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Elemento padre:311 / Elemento actual: 312   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(311)).appendChild((Text)v.get(312));

      /* Termina nodo Texto:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("colFondo","" );
      ((Element)v.get(313)).setAttribute("ID","EstCab" );
      ((Element)v.get(313)).setAttribute("cod","1338" );
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Elemento padre:313 / Elemento actual: 314   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(313)).appendChild((Text)v.get(314));

      /* Termina nodo Texto:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
      ((Element)v.get(315)).setAttribute("cod","588" );
      ((Element)v.get(310)).appendChild((Element)v.get(315));

      /* Elemento padre:315 / Elemento actual: 316   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(315)).appendChild((Text)v.get(316));

      /* Termina nodo Texto:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("colFondo","" );
      ((Element)v.get(317)).setAttribute("ID","EstCab" );
      ((Element)v.get(317)).setAttribute("cod","590" );
      ((Element)v.get(310)).appendChild((Element)v.get(317));

      /* Elemento padre:317 / Elemento actual: 318   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(317)).appendChild((Text)v.get(318));

      /* Termina nodo Texto:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("colFondo","" );
      ((Element)v.get(319)).setAttribute("ID","EstCab" );
      ((Element)v.get(319)).setAttribute("cod","589" );
      ((Element)v.get(310)).appendChild((Element)v.get(319));

      /* Elemento padre:319 / Elemento actual: 320   */
      v.add(doc.createTextNode("Genérico"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(319)).appendChild((Text)v.get(320));

      /* Termina nodo Texto:320   */
      /* Termina nodo:319   */
      /* Termina nodo:310   */

      /* Empieza nodo:321 / Elemento padre: 309   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(321)).setAttribute("colFondo","" );
      ((Element)v.get(321)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).setAttribute("cod","00336" );
      ((Element)v.get(309)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("colFondo","" );
      ((Element)v.get(322)).setAttribute("ID","EstCab" );
      ((Element)v.get(322)).setAttribute("cod","608" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Elemento padre:322 / Elemento actual: 323   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(322)).appendChild((Text)v.get(323));

      /* Termina nodo Texto:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("colFondo","" );
      ((Element)v.get(324)).setAttribute("ID","EstCab" );
      ((Element)v.get(324)).setAttribute("cod","581" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Elemento padre:324 / Elemento actual: 325   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(324)).appendChild((Text)v.get(325));

      /* Termina nodo Texto:325   */
      /* Termina nodo:324   */
      /* Termina nodo:321   */

      /* Empieza nodo:326 / Elemento padre: 309   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(326)).setAttribute("colFondo","" );
      ((Element)v.get(326)).setAttribute("ID","EstCab" );
      ((Element)v.get(326)).setAttribute("cod","00337" );
      ((Element)v.get(309)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("colFondo","" );
      ((Element)v.get(327)).setAttribute("ID","EstCab" );
      ((Element)v.get(327)).setAttribute("cod","337" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Elemento padre:327 / Elemento actual: 328   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(327)).appendChild((Text)v.get(328));

      /* Termina nodo Texto:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("colFondo","" );
      ((Element)v.get(329)).setAttribute("ID","EstCab" );
      ((Element)v.get(329)).setAttribute("cod","608" );
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Elemento padre:329 / Elemento actual: 330   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(329)).appendChild((Text)v.get(330));

      /* Termina nodo Texto:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("colFondo","" );
      ((Element)v.get(331)).setAttribute("ID","EstCab" );
      ((Element)v.get(331)).setAttribute("cod","581" );
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Elemento padre:331 / Elemento actual: 332   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(331)).appendChild((Text)v.get(332));

      /* Termina nodo Texto:332   */
      /* Termina nodo:331   */
      /* Termina nodo:326   */

      /* Empieza nodo:333 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("colFondo","" );
      ((Element)v.get(333)).setAttribute("ID","EstCab" );
      ((Element)v.get(333)).setAttribute("cod","1175" );
      ((Element)v.get(309)).appendChild((Element)v.get(333));

      /* Elemento padre:333 / Elemento actual: 334   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(333)).appendChild((Text)v.get(334));

      /* Termina nodo Texto:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("colFondo","" );
      ((Element)v.get(335)).setAttribute("ID","EstCab" );
      ((Element)v.get(335)).setAttribute("cod","1176" );
      ((Element)v.get(309)).appendChild((Element)v.get(335));

      /* Elemento padre:335 / Elemento actual: 336   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(335)).appendChild((Text)v.get(336));

      /* Termina nodo Texto:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("colFondo","" );
      ((Element)v.get(337)).setAttribute("ID","EstCab" );
      ((Element)v.get(337)).setAttribute("cod","1815" );
      ((Element)v.get(309)).appendChild((Element)v.get(337));

      /* Elemento padre:337 / Elemento actual: 338   */
      v.add(doc.createTextNode("Unidades exigidas"));
      ((Element)v.get(337)).appendChild((Text)v.get(338));

      /* Termina nodo Texto:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("colFondo","" );
      ((Element)v.get(339)).setAttribute("ID","EstCab" );
      ((Element)v.get(339)).setAttribute("cod","1816" );
      ((Element)v.get(309)).appendChild((Element)v.get(339));

      /* Elemento padre:339 / Elemento actual: 340   */
      v.add(doc.createTextNode("Monto exigido"));
      ((Element)v.get(339)).appendChild((Text)v.get(340));

      /* Termina nodo Texto:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("colFondo","" );
      ((Element)v.get(341)).setAttribute("ID","EstCab" );
      ((Element)v.get(341)).setAttribute("cod","1817" );
      ((Element)v.get(309)).appendChild((Element)v.get(341));

      /* Elemento padre:341 / Elemento actual: 342   */
      v.add(doc.createTextNode("Puntos exigidos"));
      ((Element)v.get(341)).appendChild((Text)v.get(342));

      /* Termina nodo Texto:342   */
      /* Termina nodo:341   */
      /* Termina nodo:309   */

      /* Empieza nodo:343 / Elemento padre: 283   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(343)).setAttribute("alto","22" );
      ((Element)v.get(343)).setAttribute("accion","" );
      ((Element)v.get(343)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(343)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(343)).setAttribute("maxSel","-1" );
      ((Element)v.get(343)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(343)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(343)).setAttribute("colorROver","#D0D9E8" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(343)).setAttribute("onLoad","" );
      ((Element)v.get(343)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(283)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("tipo","texto" );
      ((Element)v.get(344)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("tipo","texto" );
      ((Element)v.get(345)).setAttribute("ID","EstDat2" );
      ((Element)v.get(343)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("tipo","texto" );
      ((Element)v.get(346)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("tipo","texto" );
      ((Element)v.get(347)).setAttribute("ID","EstDat2" );
      ((Element)v.get(343)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("tipo","texto" );
      ((Element)v.get(348)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("tipo","texto" );
      ((Element)v.get(349)).setAttribute("ID","EstDat2" );
      ((Element)v.get(343)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("tipo","texto" );
      ((Element)v.get(350)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("tipo","texto" );
      ((Element)v.get(351)).setAttribute("ID","EstDat2" );
      ((Element)v.get(343)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("tipo","texto" );
      ((Element)v.get(352)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("tipo","texto" );
      ((Element)v.get(353)).setAttribute("ID","EstDat2" );
      ((Element)v.get(343)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("tipo","texto" );
      ((Element)v.get(354)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("tipo","texto" );
      ((Element)v.get(355)).setAttribute("ID","EstDat2" );
      ((Element)v.get(343)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("tipo","texto" );
      ((Element)v.get(356)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("tipo","texto" );
      ((Element)v.get(357)).setAttribute("ID","EstDat2" );
      ((Element)v.get(343)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","texto" );
      ((Element)v.get(358)).setAttribute("ID","EstDat" );
      ((Element)v.get(343)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:343   */

      /* Empieza nodo:359 / Elemento padre: 283   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(283)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 283   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(360)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(360)).setAttribute("ancho","404" );
      ((Element)v.get(360)).setAttribute("sep","$" );
      ((Element)v.get(360)).setAttribute("x","12" );
      ((Element)v.get(360)).setAttribute("class","botonera" );
      ((Element)v.get(360)).setAttribute("y","440" );
      ((Element)v.get(360)).setAttribute("control","|" );
      ((Element)v.get(360)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(360)).setAttribute("rowset","" );
      ((Element)v.get(360)).setAttribute("cargainicial","S" );
      ((Element)v.get(283)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(361)).setAttribute("nombre","ret4" );
      ((Element)v.get(361)).setAttribute("x","37" );
      ((Element)v.get(361)).setAttribute("y","444" );
      ((Element)v.get(361)).setAttribute("ID","botonContenido" );
      ((Element)v.get(361)).setAttribute("img","retroceder_on" );
      ((Element)v.get(361)).setAttribute("tipo","0" );
      ((Element)v.get(361)).setAttribute("estado","false" );
      ((Element)v.get(361)).setAttribute("alt","" );
      ((Element)v.get(361)).setAttribute("codigo","" );
      ((Element)v.get(361)).setAttribute("accion","mipgndo4.retroceder();" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(362)).setAttribute("nombre","ava4" );
      ((Element)v.get(362)).setAttribute("x","52" );
      ((Element)v.get(362)).setAttribute("y","444" );
      ((Element)v.get(362)).setAttribute("ID","botonContenido" );
      ((Element)v.get(362)).setAttribute("img","avanzar_on" );
      ((Element)v.get(362)).setAttribute("tipo","0" );
      ((Element)v.get(362)).setAttribute("estado","false" );
      ((Element)v.get(362)).setAttribute("alt","" );
      ((Element)v.get(362)).setAttribute("codigo","" );
      ((Element)v.get(362)).setAttribute("accion","mipgndo4.avanzar();" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:360   */
      /* Termina nodo:283   */

      /* Empieza nodo:363 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(363)).setAttribute("nombre","primera4" );
      ((Element)v.get(363)).setAttribute("x","20" );
      ((Element)v.get(363)).setAttribute("y","444" );
      ((Element)v.get(363)).setAttribute("ID","botonContenido" );
      ((Element)v.get(363)).setAttribute("img","primera_on" );
      ((Element)v.get(363)).setAttribute("tipo","-2" );
      ((Element)v.get(363)).setAttribute("estado","false" );
      ((Element)v.get(363)).setAttribute("alt","" );
      ((Element)v.get(363)).setAttribute("codigo","" );
      ((Element)v.get(363)).setAttribute("accion","mipgndo4.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(364)).setAttribute("nombre","separa4" );
      ((Element)v.get(364)).setAttribute("x","59" );
      ((Element)v.get(364)).setAttribute("y","440" );
      ((Element)v.get(364)).setAttribute("ID","botonContenido" );
      ((Element)v.get(364)).setAttribute("img","separa_base" );
      ((Element)v.get(364)).setAttribute("tipo","0" );
      ((Element)v.get(364)).setAttribute("estado","false" );
      ((Element)v.get(364)).setAttribute("alt","" );
      ((Element)v.get(364)).setAttribute("codigo","" );
      ((Element)v.get(364)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(365)).setAttribute("nombre","listado5" );
      ((Element)v.get(365)).setAttribute("ancho","404" );
      ((Element)v.get(365)).setAttribute("alto","337" );
      ((Element)v.get(365)).setAttribute("x","12" );
      ((Element)v.get(365)).setAttribute("y","126" );
      ((Element)v.get(365)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(365)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(366)).setAttribute("precarga","S" );
      ((Element)v.get(366)).setAttribute("conROver","S" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(367)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(367)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(367)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(367)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 366   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(368)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(368)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(368)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(368)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(366)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 366   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(369)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(369)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(366)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:366   */

      /* Empieza nodo:370 / Elemento padre: 365   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(365)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(371)).setAttribute("borde","1" );
      ((Element)v.get(371)).setAttribute("horizDatos","1" );
      ((Element)v.get(371)).setAttribute("horizCabecera","1" );
      ((Element)v.get(371)).setAttribute("vertical","1" );
      ((Element)v.get(371)).setAttribute("horizTitulo","1" );
      ((Element)v.get(371)).setAttribute("horizBase","1" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 370   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(372)).setAttribute("borde","#999999" );
      ((Element)v.get(372)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(372)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(372)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(372)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(372)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(372)).setAttribute("horizBase","#999999" );
      ((Element)v.get(370)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:370   */

      /* Empieza nodo:373 / Elemento padre: 365   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(373)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(373)).setAttribute("alto","22" );
      ((Element)v.get(373)).setAttribute("imgFondo","" );
      ((Element)v.get(373)).setAttribute("cod","00372" );
      ((Element)v.get(373)).setAttribute("ID","datosTitle" );
      ((Element)v.get(365)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 365   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("BASE"));
      ((Element)v.get(374)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(374)).setAttribute("alto","22" );
      ((Element)v.get(374)).setAttribute("imgFondo","" );
      ((Element)v.get(365)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 365   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(375)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(375)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(375)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(375)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(375)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(375)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(365)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("ancho","150" );
      ((Element)v.get(376)).setAttribute("minimizable","S" );
      ((Element)v.get(376)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("ancho","150" );
      ((Element)v.get(377)).setAttribute("minimizable","S" );
      ((Element)v.get(377)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("ancho","150" );
      ((Element)v.get(378)).setAttribute("minimizable","S" );
      ((Element)v.get(378)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("ancho","150" );
      ((Element)v.get(379)).setAttribute("minimizable","S" );
      ((Element)v.get(379)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("ancho","150" );
      ((Element)v.get(380)).setAttribute("minimizable","S" );
      ((Element)v.get(380)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("ancho","150" );
      ((Element)v.get(381)).setAttribute("minimizable","S" );
      ((Element)v.get(381)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","150" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("ancho","150" );
      ((Element)v.get(383)).setAttribute("minimizable","S" );
      ((Element)v.get(383)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("ancho","150" );
      ((Element)v.get(384)).setAttribute("minimizable","S" );
      ((Element)v.get(384)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 375   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("ancho","150" );
      ((Element)v.get(385)).setAttribute("minimizable","S" );
      ((Element)v.get(385)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:375   */

      /* Empieza nodo:386 / Elemento padre: 365   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(386)).setAttribute("alto","40" );
      ((Element)v.get(386)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(386)).setAttribute("imgFondo","" );
      ((Element)v.get(386)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(386)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(365)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(387)).setAttribute("colFondo","" );
      ((Element)v.get(387)).setAttribute("ID","EstCab" );
      ((Element)v.get(387)).setAttribute("cod","00335" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("colFondo","" );
      ((Element)v.get(388)).setAttribute("ID","EstCab" );
      ((Element)v.get(388)).setAttribute("cod","6" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Elemento padre:388 / Elemento actual: 389   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(388)).appendChild((Text)v.get(389));

      /* Termina nodo Texto:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("colFondo","" );
      ((Element)v.get(390)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).setAttribute("cod","1338" );
      ((Element)v.get(387)).appendChild((Element)v.get(390));

      /* Elemento padre:390 / Elemento actual: 391   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(390)).appendChild((Text)v.get(391));

      /* Termina nodo Texto:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(392)).setAttribute("colFondo","" );
      ((Element)v.get(392)).setAttribute("ID","EstCab" );
      ((Element)v.get(392)).setAttribute("cod","588" );
      ((Element)v.get(387)).appendChild((Element)v.get(392));

      /* Elemento padre:392 / Elemento actual: 393   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(392)).appendChild((Text)v.get(393));

      /* Termina nodo Texto:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("colFondo","" );
      ((Element)v.get(394)).setAttribute("ID","EstCab" );
      ((Element)v.get(394)).setAttribute("cod","590" );
      ((Element)v.get(387)).appendChild((Element)v.get(394));

      /* Elemento padre:394 / Elemento actual: 395   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(394)).appendChild((Text)v.get(395));

      /* Termina nodo Texto:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("colFondo","" );
      ((Element)v.get(396)).setAttribute("ID","EstCab" );
      ((Element)v.get(396)).setAttribute("cod","589" );
      ((Element)v.get(387)).appendChild((Element)v.get(396));

      /* Elemento padre:396 / Elemento actual: 397   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(396)).appendChild((Text)v.get(397));

      /* Termina nodo Texto:397   */
      /* Termina nodo:396   */
      /* Termina nodo:387   */

      /* Empieza nodo:398 / Elemento padre: 386   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(398)).setAttribute("colFondo","" );
      ((Element)v.get(398)).setAttribute("ID","EstCab" );
      ((Element)v.get(398)).setAttribute("cod","00336" );
      ((Element)v.get(386)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("colFondo","" );
      ((Element)v.get(399)).setAttribute("ID","EstCab" );
      ((Element)v.get(399)).setAttribute("cod","608" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Elemento padre:399 / Elemento actual: 400   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(399)).appendChild((Text)v.get(400));

      /* Termina nodo Texto:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 398   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("colFondo","" );
      ((Element)v.get(401)).setAttribute("ID","EstCab" );
      ((Element)v.get(401)).setAttribute("cod","581" );
      ((Element)v.get(398)).appendChild((Element)v.get(401));

      /* Elemento padre:401 / Elemento actual: 402   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(401)).appendChild((Text)v.get(402));

      /* Termina nodo Texto:402   */
      /* Termina nodo:401   */
      /* Termina nodo:398   */

      /* Empieza nodo:403 / Elemento padre: 386   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(403)).setAttribute("colFondo","" );
      ((Element)v.get(403)).setAttribute("ID","EstCab" );
      ((Element)v.get(403)).setAttribute("cod","00337" );
      ((Element)v.get(386)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("colFondo","" );
      ((Element)v.get(404)).setAttribute("ID","EstCab" );
      ((Element)v.get(404)).setAttribute("cod","337" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Elemento padre:404 / Elemento actual: 405   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(404)).appendChild((Text)v.get(405));

      /* Termina nodo Texto:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("colFondo","" );
      ((Element)v.get(406)).setAttribute("ID","EstCab" );
      ((Element)v.get(406)).setAttribute("cod","608" );
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Elemento padre:406 / Elemento actual: 407   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(406)).appendChild((Text)v.get(407));

      /* Termina nodo Texto:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 403   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(408)).setAttribute("colFondo","" );
      ((Element)v.get(408)).setAttribute("ID","EstCab" );
      ((Element)v.get(408)).setAttribute("cod","581" );
      ((Element)v.get(403)).appendChild((Element)v.get(408));

      /* Elemento padre:408 / Elemento actual: 409   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(408)).appendChild((Text)v.get(409));

      /* Termina nodo Texto:409   */
      /* Termina nodo:408   */
      /* Termina nodo:403   */
      /* Termina nodo:386   */

      /* Empieza nodo:410 / Elemento padre: 365   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(410)).setAttribute("alto","22" );
      ((Element)v.get(410)).setAttribute("accion","" );
      ((Element)v.get(410)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(410)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(410)).setAttribute("maxSel","-1" );
      ((Element)v.get(410)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(410)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(410)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(410)).setAttribute("onLoad","" );
      ((Element)v.get(410)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(365)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(411)).setAttribute("tipo","texto" );
      ((Element)v.get(411)).setAttribute("ID","EstDat" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("tipo","texto" );
      ((Element)v.get(412)).setAttribute("ID","EstDat2" );
      ((Element)v.get(410)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("tipo","texto" );
      ((Element)v.get(413)).setAttribute("ID","EstDat" );
      ((Element)v.get(410)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(414)).setAttribute("tipo","texto" );
      ((Element)v.get(414)).setAttribute("ID","EstDat2" );
      ((Element)v.get(410)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("tipo","texto" );
      ((Element)v.get(415)).setAttribute("ID","EstDat" );
      ((Element)v.get(410)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("tipo","texto" );
      ((Element)v.get(416)).setAttribute("ID","EstDat2" );
      ((Element)v.get(410)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("tipo","texto" );
      ((Element)v.get(417)).setAttribute("ID","EstDat" );
      ((Element)v.get(410)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */

      /* Empieza nodo:418 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(418)).setAttribute("tipo","texto" );
      ((Element)v.get(418)).setAttribute("ID","EstDat2" );
      ((Element)v.get(410)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("tipo","texto" );
      ((Element)v.get(419)).setAttribute("ID","EstDat" );
      ((Element)v.get(410)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 410   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("tipo","texto" );
      ((Element)v.get(420)).setAttribute("ID","EstDat2" );
      ((Element)v.get(410)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:410   */

      /* Empieza nodo:421 / Elemento padre: 365   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(365)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 365   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(422)).setAttribute("nombre","mipgndo5" );
      ((Element)v.get(422)).setAttribute("ancho","404" );
      ((Element)v.get(422)).setAttribute("sep","$" );
      ((Element)v.get(422)).setAttribute("x","12" );
      ((Element)v.get(422)).setAttribute("class","botonera" );
      ((Element)v.get(422)).setAttribute("y","440" );
      ((Element)v.get(422)).setAttribute("control","|" );
      ((Element)v.get(422)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(422)).setAttribute("rowset","" );
      ((Element)v.get(422)).setAttribute("cargainicial","S" );
      ((Element)v.get(365)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(423)).setAttribute("nombre","ret5" );
      ((Element)v.get(423)).setAttribute("x","37" );
      ((Element)v.get(423)).setAttribute("y","444" );
      ((Element)v.get(423)).setAttribute("ID","botonContenido" );
      ((Element)v.get(423)).setAttribute("img","retroceder_on" );
      ((Element)v.get(423)).setAttribute("tipo","0" );
      ((Element)v.get(423)).setAttribute("estado","false" );
      ((Element)v.get(423)).setAttribute("alt","" );
      ((Element)v.get(423)).setAttribute("codigo","" );
      ((Element)v.get(423)).setAttribute("accion","mipgndo5.retroceder();" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 422   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(424)).setAttribute("nombre","ava5" );
      ((Element)v.get(424)).setAttribute("x","52" );
      ((Element)v.get(424)).setAttribute("y","444" );
      ((Element)v.get(424)).setAttribute("ID","botonContenido" );
      ((Element)v.get(424)).setAttribute("img","avanzar_on" );
      ((Element)v.get(424)).setAttribute("tipo","0" );
      ((Element)v.get(424)).setAttribute("estado","false" );
      ((Element)v.get(424)).setAttribute("alt","" );
      ((Element)v.get(424)).setAttribute("codigo","" );
      ((Element)v.get(424)).setAttribute("accion","mipgndo5.avanzar();" );
      ((Element)v.get(422)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:422   */
      /* Termina nodo:365   */

      /* Empieza nodo:425 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(425)).setAttribute("nombre","primera5" );
      ((Element)v.get(425)).setAttribute("x","20" );
      ((Element)v.get(425)).setAttribute("y","444" );
      ((Element)v.get(425)).setAttribute("ID","botonContenido" );
      ((Element)v.get(425)).setAttribute("img","primera_on" );
      ((Element)v.get(425)).setAttribute("tipo","-2" );
      ((Element)v.get(425)).setAttribute("estado","false" );
      ((Element)v.get(425)).setAttribute("alt","" );
      ((Element)v.get(425)).setAttribute("codigo","" );
      ((Element)v.get(425)).setAttribute("accion","mipgndo5.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(426)).setAttribute("nombre","separa5" );
      ((Element)v.get(426)).setAttribute("x","59" );
      ((Element)v.get(426)).setAttribute("y","440" );
      ((Element)v.get(426)).setAttribute("ID","botonContenido" );
      ((Element)v.get(426)).setAttribute("img","separa_base" );
      ((Element)v.get(426)).setAttribute("tipo","0" );
      ((Element)v.get(426)).setAttribute("estado","false" );
      ((Element)v.get(426)).setAttribute("alt","" );
      ((Element)v.get(426)).setAttribute("codigo","" );
      ((Element)v.get(426)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(427)).setAttribute("nombre","listado6" );
      ((Element)v.get(427)).setAttribute("ancho","404" );
      ((Element)v.get(427)).setAttribute("alto","337" );
      ((Element)v.get(427)).setAttribute("x","12" );
      ((Element)v.get(427)).setAttribute("y","126" );
      ((Element)v.get(427)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(427)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(428)).setAttribute("precarga","S" );
      ((Element)v.get(428)).setAttribute("conROver","S" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(429)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(429)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(429)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(429)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 428   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(430)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(430)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(430)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(430)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(428)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 428   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(431)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(431)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(428)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:428   */

      /* Empieza nodo:432 / Elemento padre: 427   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(427)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(433)).setAttribute("borde","1" );
      ((Element)v.get(433)).setAttribute("horizDatos","1" );
      ((Element)v.get(433)).setAttribute("horizCabecera","1" );
      ((Element)v.get(433)).setAttribute("vertical","1" );
      ((Element)v.get(433)).setAttribute("horizTitulo","1" );
      ((Element)v.get(433)).setAttribute("horizBase","1" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 432   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(434)).setAttribute("borde","#999999" );
      ((Element)v.get(434)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(434)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(434)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(434)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(434)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(434)).setAttribute("horizBase","#999999" );
      ((Element)v.get(432)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:432   */

      /* Empieza nodo:435 / Elemento padre: 427   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(435)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(435)).setAttribute("alto","22" );
      ((Element)v.get(435)).setAttribute("imgFondo","" );
      ((Element)v.get(435)).setAttribute("cod","00373" );
      ((Element)v.get(435)).setAttribute("ID","datosTitle" );
      ((Element)v.get(427)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 427   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(436)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(436)).setAttribute("alto","22" );
      ((Element)v.get(436)).setAttribute("imgFondo","" );
      ((Element)v.get(427)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 427   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(437)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(437)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(437)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(437)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(437)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(437)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(427)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(438)).setAttribute("ancho","150" );
      ((Element)v.get(438)).setAttribute("minimizable","S" );
      ((Element)v.get(438)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(439)).setAttribute("ancho","150" );
      ((Element)v.get(439)).setAttribute("minimizable","S" );
      ((Element)v.get(439)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(440)).setAttribute("ancho","150" );
      ((Element)v.get(440)).setAttribute("minimizable","S" );
      ((Element)v.get(440)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */

      /* Empieza nodo:441 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(441)).setAttribute("ancho","150" );
      ((Element)v.get(441)).setAttribute("minimizable","S" );
      ((Element)v.get(441)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(442)).setAttribute("ancho","150" );
      ((Element)v.get(442)).setAttribute("minimizable","S" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(442)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(443)).setAttribute("ancho","150" );
      ((Element)v.get(443)).setAttribute("minimizable","S" );
      ((Element)v.get(443)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */

      /* Empieza nodo:444 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(444)).setAttribute("ancho","150" );
      ((Element)v.get(444)).setAttribute("minimizable","S" );
      ((Element)v.get(444)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */

      /* Empieza nodo:445 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(445)).setAttribute("ancho","150" );
      ((Element)v.get(445)).setAttribute("minimizable","S" );
      ((Element)v.get(445)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(446)).setAttribute("ancho","150" );
      ((Element)v.get(446)).setAttribute("minimizable","S" );
      ((Element)v.get(446)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */

      /* Empieza nodo:447 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(447)).setAttribute("ancho","150" );
      ((Element)v.get(447)).setAttribute("minimizable","S" );
      ((Element)v.get(447)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */

      /* Empieza nodo:448 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(448)).setAttribute("ancho","150" );
      ((Element)v.get(448)).setAttribute("minimizable","S" );
      ((Element)v.get(448)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 437   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(449)).setAttribute("ancho","150" );
      ((Element)v.get(449)).setAttribute("minimizable","S" );
      ((Element)v.get(449)).setAttribute("minimizada","N" );
      ((Element)v.get(437)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:437   */

      /* Empieza nodo:450 / Elemento padre: 427   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(450)).setAttribute("alto","40" );
      ((Element)v.get(450)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(450)).setAttribute("imgFondo","" );
      ((Element)v.get(450)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(450)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(427)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(451)).setAttribute("colFondo","" );
      ((Element)v.get(451)).setAttribute("ID","EstCab" );
      ((Element)v.get(451)).setAttribute("cod","00335" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(452)).setAttribute("colFondo","" );
      ((Element)v.get(452)).setAttribute("ID","EstCab" );
      ((Element)v.get(452)).setAttribute("cod","6" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Elemento padre:452 / Elemento actual: 453   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(452)).appendChild((Text)v.get(453));

      /* Termina nodo Texto:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(454)).setAttribute("colFondo","" );
      ((Element)v.get(454)).setAttribute("ID","EstCab" );
      ((Element)v.get(454)).setAttribute("cod","1338" );
      ((Element)v.get(451)).appendChild((Element)v.get(454));

      /* Elemento padre:454 / Elemento actual: 455   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(454)).appendChild((Text)v.get(455));

      /* Termina nodo Texto:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(456)).setAttribute("colFondo","" );
      ((Element)v.get(456)).setAttribute("ID","EstCab" );
      ((Element)v.get(456)).setAttribute("cod","588" );
      ((Element)v.get(451)).appendChild((Element)v.get(456));

      /* Elemento padre:456 / Elemento actual: 457   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(456)).appendChild((Text)v.get(457));

      /* Termina nodo Texto:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("colFondo","" );
      ((Element)v.get(458)).setAttribute("ID","EstCab" );
      ((Element)v.get(458)).setAttribute("cod","590" );
      ((Element)v.get(451)).appendChild((Element)v.get(458));

      /* Elemento padre:458 / Elemento actual: 459   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(458)).appendChild((Text)v.get(459));

      /* Termina nodo Texto:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(460)).setAttribute("colFondo","" );
      ((Element)v.get(460)).setAttribute("ID","EstCab" );
      ((Element)v.get(460)).setAttribute("cod","589" );
      ((Element)v.get(451)).appendChild((Element)v.get(460));

      /* Elemento padre:460 / Elemento actual: 461   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(460)).appendChild((Text)v.get(461));

      /* Termina nodo Texto:461   */
      /* Termina nodo:460   */
      /* Termina nodo:451   */

      /* Empieza nodo:462 / Elemento padre: 450   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(462)).setAttribute("colFondo","" );
      ((Element)v.get(462)).setAttribute("ID","EstCab" );
      ((Element)v.get(462)).setAttribute("cod","00336" );
      ((Element)v.get(450)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(463)).setAttribute("colFondo","" );
      ((Element)v.get(463)).setAttribute("ID","EstCab" );
      ((Element)v.get(463)).setAttribute("cod","608" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Elemento padre:463 / Elemento actual: 464   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(463)).appendChild((Text)v.get(464));

      /* Termina nodo Texto:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 462   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("colFondo","" );
      ((Element)v.get(465)).setAttribute("ID","EstCab" );
      ((Element)v.get(465)).setAttribute("cod","581" );
      ((Element)v.get(462)).appendChild((Element)v.get(465));

      /* Elemento padre:465 / Elemento actual: 466   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(465)).appendChild((Text)v.get(466));

      /* Termina nodo Texto:466   */
      /* Termina nodo:465   */
      /* Termina nodo:462   */

      /* Empieza nodo:467 / Elemento padre: 450   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(467)).setAttribute("colFondo","" );
      ((Element)v.get(467)).setAttribute("ID","EstCab" );
      ((Element)v.get(467)).setAttribute("cod","00337" );
      ((Element)v.get(450)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("colFondo","" );
      ((Element)v.get(468)).setAttribute("ID","EstCab" );
      ((Element)v.get(468)).setAttribute("cod","337" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Elemento padre:468 / Elemento actual: 469   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(468)).appendChild((Text)v.get(469));

      /* Termina nodo Texto:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("colFondo","" );
      ((Element)v.get(470)).setAttribute("ID","EstCab" );
      ((Element)v.get(470)).setAttribute("cod","608" );
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Elemento padre:470 / Elemento actual: 471   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(470)).appendChild((Text)v.get(471));

      /* Termina nodo Texto:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(472)).setAttribute("colFondo","" );
      ((Element)v.get(472)).setAttribute("ID","EstCab" );
      ((Element)v.get(472)).setAttribute("cod","581" );
      ((Element)v.get(467)).appendChild((Element)v.get(472));

      /* Elemento padre:472 / Elemento actual: 473   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(472)).appendChild((Text)v.get(473));

      /* Termina nodo Texto:473   */
      /* Termina nodo:472   */
      /* Termina nodo:467   */

      /* Empieza nodo:474 / Elemento padre: 450   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(474)).setAttribute("colFondo","" );
      ((Element)v.get(474)).setAttribute("ID","EstCab" );
      ((Element)v.get(474)).setAttribute("cod","1175" );
      ((Element)v.get(450)).appendChild((Element)v.get(474));

      /* Elemento padre:474 / Elemento actual: 475   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(474)).appendChild((Text)v.get(475));

      /* Termina nodo Texto:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 450   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(476)).setAttribute("colFondo","" );
      ((Element)v.get(476)).setAttribute("ID","EstCab" );
      ((Element)v.get(476)).setAttribute("cod","1176" );
      ((Element)v.get(450)).appendChild((Element)v.get(476));

      /* Elemento padre:476 / Elemento actual: 477   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(476)).appendChild((Text)v.get(477));

      /* Termina nodo Texto:477   */
      /* Termina nodo:476   */
      /* Termina nodo:450   */

      /* Empieza nodo:478 / Elemento padre: 427   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(478)).setAttribute("alto","22" );
      ((Element)v.get(478)).setAttribute("accion","" );
      ((Element)v.get(478)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(478)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(478)).setAttribute("maxSel","-1" );
      ((Element)v.get(478)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(478)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(478)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(478)).setAttribute("onLoad","" );
      ((Element)v.get(478)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(427)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(479)).setAttribute("tipo","texto" );
      ((Element)v.get(479)).setAttribute("ID","EstDat" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("tipo","texto" );
      ((Element)v.get(480)).setAttribute("ID","EstDat2" );
      ((Element)v.get(478)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(481)).setAttribute("tipo","texto" );
      ((Element)v.get(481)).setAttribute("ID","EstDat" );
      ((Element)v.get(478)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("tipo","texto" );
      ((Element)v.get(482)).setAttribute("ID","EstDat2" );
      ((Element)v.get(478)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(483)).setAttribute("tipo","texto" );
      ((Element)v.get(483)).setAttribute("ID","EstDat" );
      ((Element)v.get(478)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("tipo","texto" );
      ((Element)v.get(484)).setAttribute("ID","EstDat2" );
      ((Element)v.get(478)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(485)).setAttribute("tipo","texto" );
      ((Element)v.get(485)).setAttribute("ID","EstDat" );
      ((Element)v.get(478)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("tipo","texto" );
      ((Element)v.get(486)).setAttribute("ID","EstDat2" );
      ((Element)v.get(478)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("tipo","texto" );
      ((Element)v.get(487)).setAttribute("ID","EstDat" );
      ((Element)v.get(478)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("tipo","texto" );
      ((Element)v.get(488)).setAttribute("ID","EstDat2" );
      ((Element)v.get(478)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("tipo","texto" );
      ((Element)v.get(489)).setAttribute("ID","EstDat" );
      ((Element)v.get(478)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("tipo","texto" );
      ((Element)v.get(490)).setAttribute("ID","EstDat2" );
      ((Element)v.get(478)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:478   */

      /* Empieza nodo:491 / Elemento padre: 427   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(427)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 427   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(492)).setAttribute("nombre","mipgndo6" );
      ((Element)v.get(492)).setAttribute("ancho","404" );
      ((Element)v.get(492)).setAttribute("sep","$" );
      ((Element)v.get(492)).setAttribute("x","12" );
      ((Element)v.get(492)).setAttribute("class","botonera" );
      ((Element)v.get(492)).setAttribute("y","440" );
      ((Element)v.get(492)).setAttribute("control","|" );
      ((Element)v.get(492)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(492)).setAttribute("rowset","" );
      ((Element)v.get(492)).setAttribute("cargainicial","S" );
      ((Element)v.get(427)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(493)).setAttribute("nombre","ret6" );
      ((Element)v.get(493)).setAttribute("x","37" );
      ((Element)v.get(493)).setAttribute("y","444" );
      ((Element)v.get(493)).setAttribute("ID","botonContenido" );
      ((Element)v.get(493)).setAttribute("img","retroceder_on" );
      ((Element)v.get(493)).setAttribute("tipo","0" );
      ((Element)v.get(493)).setAttribute("estado","false" );
      ((Element)v.get(493)).setAttribute("alt","" );
      ((Element)v.get(493)).setAttribute("codigo","" );
      ((Element)v.get(493)).setAttribute("accion","mipgndo6.retroceder();" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 492   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(494)).setAttribute("nombre","ava6" );
      ((Element)v.get(494)).setAttribute("x","52" );
      ((Element)v.get(494)).setAttribute("y","444" );
      ((Element)v.get(494)).setAttribute("ID","botonContenido" );
      ((Element)v.get(494)).setAttribute("img","avanzar_on" );
      ((Element)v.get(494)).setAttribute("tipo","0" );
      ((Element)v.get(494)).setAttribute("estado","false" );
      ((Element)v.get(494)).setAttribute("alt","" );
      ((Element)v.get(494)).setAttribute("codigo","" );
      ((Element)v.get(494)).setAttribute("accion","mipgndo6.avanzar();" );
      ((Element)v.get(492)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:492   */
      /* Termina nodo:427   */

      /* Empieza nodo:495 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(495)).setAttribute("nombre","primera6" );
      ((Element)v.get(495)).setAttribute("x","20" );
      ((Element)v.get(495)).setAttribute("y","444" );
      ((Element)v.get(495)).setAttribute("ID","botonContenido" );
      ((Element)v.get(495)).setAttribute("img","primera_on" );
      ((Element)v.get(495)).setAttribute("tipo","-2" );
      ((Element)v.get(495)).setAttribute("estado","false" );
      ((Element)v.get(495)).setAttribute("alt","" );
      ((Element)v.get(495)).setAttribute("codigo","" );
      ((Element)v.get(495)).setAttribute("accion","mipgndo6.retrocederPrimeraPagina();" );
      ((Element)v.get(3)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(496)).setAttribute("nombre","separa6" );
      ((Element)v.get(496)).setAttribute("x","59" );
      ((Element)v.get(496)).setAttribute("y","440" );
      ((Element)v.get(496)).setAttribute("ID","botonContenido" );
      ((Element)v.get(496)).setAttribute("img","separa_base" );
      ((Element)v.get(496)).setAttribute("tipo","0" );
      ((Element)v.get(496)).setAttribute("estado","false" );
      ((Element)v.get(496)).setAttribute("alt","" );
      ((Element)v.get(496)).setAttribute("codigo","" );
      ((Element)v.get(496)).setAttribute("accion","" );
      ((Element)v.get(3)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(497)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(497)).setAttribute("alto","12" );
      ((Element)v.get(497)).setAttribute("ancho","100%" );
      ((Element)v.get(497)).setAttribute("colorf","" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(497)).setAttribute("borde","0" );
      ((Element)v.get(497)).setAttribute("imagenf","" );
      ((Element)v.get(497)).setAttribute("repeat","" );
      ((Element)v.get(497)).setAttribute("padding","" );
      ((Element)v.get(497)).setAttribute("visibilidad","visible" );
      ((Element)v.get(497)).setAttribute("contravsb","" );
      ((Element)v.get(497)).setAttribute("x","0" );
      ((Element)v.get(497)).setAttribute("y","463" );
      ((Element)v.get(497)).setAttribute("zindex","" );
      ((Element)v.get(3)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 3   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(498)).setAttribute("nombre","capa2" );
      ((Element)v.get(498)).setAttribute("alto","80" );
      ((Element)v.get(498)).setAttribute("ancho","100%" );
      ((Element)v.get(498)).setAttribute("colorf","" );
      ((Element)v.get(498)).setAttribute("borde","0" );
      ((Element)v.get(498)).setAttribute("imagenf","" );
      ((Element)v.get(498)).setAttribute("repeat","" );
      ((Element)v.get(498)).setAttribute("padding","" );
      ((Element)v.get(498)).setAttribute("visibilidad","" );
      ((Element)v.get(498)).setAttribute("contravsb","" );
      ((Element)v.get(498)).setAttribute("x","0" );
      ((Element)v.get(498)).setAttribute("y","475" );
      ((Element)v.get(498)).setAttribute("zindex","" );
      ((Element)v.get(3)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("table"));
      ((Element)v.get(499)).setAttribute("width","100%" );
      ((Element)v.get(499)).setAttribute("border","0" );
      ((Element)v.get(499)).setAttribute("cellspacing","0" );
      ((Element)v.get(499)).setAttribute("cellpadding","0" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(501)).setAttribute("width","12" );
      ((Element)v.get(501)).setAttribute("align","center" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","12" );
      ((Element)v.get(502)).setAttribute("height","12" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).setAttribute("width","750" );
      ((Element)v.get(500)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).setAttribute("width","12" );
      ((Element)v.get(500)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","12" );
      ((Element)v.get(506)).setAttribute("height","1" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:500   */

      /* Empieza nodo:507 / Elemento padre: 499   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(499)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(512)).setAttribute("class","legend" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(513)).setAttribute("nombre","lblOtrosDatos" );
      ((Element)v.get(513)).setAttribute("alto","13" );
      ((Element)v.get(513)).setAttribute("filas","1" );
      ((Element)v.get(513)).setAttribute("valor","" );
      ((Element)v.get(513)).setAttribute("id","legend" );
      ((Element)v.get(513)).setAttribute("cod","00167" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 511   */
      v.add(doc.createElement("table"));
      ((Element)v.get(514)).setAttribute("width","100%" );
      ((Element)v.get(514)).setAttribute("border","0" );
      ((Element)v.get(514)).setAttribute("align","center" );
      ((Element)v.get(514)).setAttribute("cellspacing","0" );
      ((Element)v.get(514)).setAttribute("cellpadding","0" );
      ((Element)v.get(511)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("table"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(517)).setAttribute("width","500" );
      ((Element)v.get(517)).setAttribute("border","0" );
      ((Element)v.get(517)).setAttribute("align","left" );
      ((Element)v.get(517)).setAttribute("cellspacing","0" );
      ((Element)v.get(517)).setAttribute("cellpadding","0" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).setAttribute("colspan","4" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","8" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:521 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","8" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(525)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(525)).setAttribute("alto","13" );
      ((Element)v.get(525)).setAttribute("filas","1" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(525)).setAttribute("id","datosTitle" );
      ((Element)v.get(525)).setAttribute("cod","1812" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","25" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(529)).setAttribute("nombre","lblMensaje" );
      ((Element)v.get(529)).setAttribute("alto","13" );
      ((Element)v.get(529)).setAttribute("filas","1" );
      ((Element)v.get(529)).setAttribute("valor","" );
      ((Element)v.get(529)).setAttribute("id","datosTitle" );
      ((Element)v.get(529)).setAttribute("cod","531" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).setAttribute("width","100%" );
      ((Element)v.get(521)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("width","8" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:521   */

      /* Empieza nodo:532 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(536)).setAttribute("nombre","lbldtComunicacion" );
      ((Element)v.get(536)).setAttribute("alto","13" );
      ((Element)v.get(536)).setAttribute("filas","1" );
      ((Element)v.get(536)).setAttribute("valor","x1" );
      ((Element)v.get(536)).setAttribute("id","datosCampos" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","25" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(540)).setAttribute("nombre","lbldtMensaje" );
      ((Element)v.get(540)).setAttribute("alto","13" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(540)).setAttribute("filas","1" );
      ((Element)v.get(540)).setAttribute("valor","xxxx1" );
      ((Element)v.get(540)).setAttribute("id","datosCampos" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(532)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("width","8" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:532   */

      /* Empieza nodo:543 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).setAttribute("colspan","4" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","8" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:546 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:507   */

      /* Empieza nodo:548 / Elemento padre: 499   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(499)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).setAttribute("width","12" );
      ((Element)v.get(549)).setAttribute("align","center" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","12" );
      ((Element)v.get(550)).setAttribute("height","12" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 548   */
      v.add(doc.createElement("td"));
      ((Element)v.get(551)).setAttribute("width","756" );
      ((Element)v.get(548)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 548   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).setAttribute("width","12" );
      ((Element)v.get(548)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("width","12" );
      ((Element)v.get(554)).setAttribute("height","1" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:548   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:3   */


   }

}
