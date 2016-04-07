
import org.w3c.dom.*;
import java.util.ArrayList;

public class PaginaPrueba  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML3060(doc);
         

      getXML3150(doc);
         

      getXML3240(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_bp_detalle" );
      ((Element)v.get(0)).setAttribute("cod","0225" );
      ((Element)v.get(0)).setAttribute("titulo","Completar datos BP" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","nueva entrada datos BP" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(1)).setAttribute("nombre","frmUnico" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(2)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(2)).setAttribute("valor","" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(3)).setAttribute("nombre","accion" );
      ((Element)v.get(3)).setAttribute("valor","" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 1   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(4)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(4)).setAttribute("valor","" );
      ((Element)v.get(1)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 1   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(1)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 1   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(6)).setAttribute("nombre","capaUnica" );
      ((Element)v.get(1)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(7)).setAttribute("width","100%" );
      ((Element)v.get(7)).setAttribute("border","0" );
      ((Element)v.get(7)).setAttribute("cellspacing","0" );
      ((Element)v.get(7)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).setAttribute("width","12" );
      ((Element)v.get(9)).setAttribute("align","center" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","b.gif" );
      ((Element)v.get(10)).setAttribute("width","12" );
      ((Element)v.get(10)).setAttribute("height","12" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("width","750" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","b.gif" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","b.gif" );
      ((Element)v.get(14)).setAttribute("width","12" );
      ((Element)v.get(14)).setAttribute("height","1" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */
      /* Termina nodo:8   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(20)).setAttribute("class","legend" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(21)).setAttribute("nombre","lblTitDatosCabecera" );
      ((Element)v.get(21)).setAttribute("alto","13" );
      ((Element)v.get(21)).setAttribute("filas","1" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(21)).setAttribute("cod","00156" );
      ((Element)v.get(21)).setAttribute("id","legend" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","714" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("align","left" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("colspan","4" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","8" );
      ((Element)v.get(28)).setAttribute("height","8" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:29 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","8" );
      ((Element)v.get(31)).setAttribute("height","8" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(33)).setAttribute("nombre","lblPais" );
      ((Element)v.get(33)).setAttribute("alto","13" );
      ((Element)v.get(33)).setAttribute("filas","1" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(33)).setAttribute("id","datosTitle" );
      ((Element)v.get(33)).setAttribute("cod","5" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","25" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","datosTitle" );
      ((Element)v.get(37)).setAttribute("cod","6" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","25" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","7" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(29)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:29   */

      /* Empieza nodo:44 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblPaisActual" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(48)).setAttribute("id","datosCampos" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblMarcaActual" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(52)).setAttribute("id","datosCampos" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","25" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lblCanalActual" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:44   */

      /* Empieza nodo:59 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(59));

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
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:62 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","714" );
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
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("cod","173" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","276" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","1301" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:65   */

      /* Empieza nodo:80 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblActividadActual" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblPeriodoActual" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","xxxxxxxxxx" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblTipoClienteActual" );
      ((Element)v.get(92)).setAttribute("alto","13" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:80   */

      /* Empieza nodo:95 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("colspan","4" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:22   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:98 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","12" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:15   */

      /* Empieza nodo:100 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","15" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","750" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","15" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */

      /* Empieza nodo:107 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(112)).setAttribute("class","legend" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblTitDatosIdentificacion" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("cod","00173" );
      ((Element)v.get(113)).setAttribute("id","legend" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("table"));
      ((Element)v.get(117)).setAttribute("width","714" );
      ((Element)v.get(117)).setAttribute("border","0" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("align","left" );
      ((Element)v.get(117)).setAttribute("cellspacing","0" );
      ((Element)v.get(117)).setAttribute("cellpadding","0" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

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

      /* Empieza nodo:121 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lblSubgerencia" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("filas","1" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(125)).setAttribute("id","datosTitle" );
      ((Element)v.get(125)).setAttribute("cod","992" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","25" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("cod","109" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","100%" );
      ((Element)v.get(121)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:121   */

      /* Empieza nodo:132 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(136)).setAttribute("nombre","cbSubgerencia" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("size","5" );
      ((Element)v.get(136)).setAttribute("multiple","S" );
      ((Element)v.get(136)).setAttribute("req","S" );
      ((Element)v.get(136)).setAttribute("valorinicial","" );
      ((Element)v.get(136)).setAttribute("textoinicial","" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:138 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("size","5" );
      ((Element)v.get(141)).setAttribute("multiple","S" );
      ((Element)v.get(141)).setAttribute("req","S" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(144)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(144)).setAttribute("TIPO","STRING" );
      ((Element)v.get(144)).setAttribute("VALOR","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 143   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(145)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(145)).setAttribute("TIPO","STRING" );
      ((Element)v.get(145)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(143)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:143   */

      /* Empieza nodo:146 / Elemento padre: 142   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(142)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(147)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(147)).setAttribute("TIPO","STRING" );
      ((Element)v.get(147)).setAttribute("VALOR","0" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(148)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(148)).setAttribute("TIPO","STRING" );
      ((Element)v.get(148)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:146   */

      /* Empieza nodo:149 / Elemento padre: 142   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(142)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(150)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(150)).setAttribute("TIPO","STRING" );
      ((Element)v.get(150)).setAttribute("VALOR","0" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 149   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(151)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(151)).setAttribute("TIPO","STRING" );
      ((Element)v.get(151)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(149)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:149   */

      /* Empieza nodo:152 / Elemento padre: 142   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(142)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(153)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(153)).setAttribute("TIPO","STRING" );
      ((Element)v.get(153)).setAttribute("VALOR","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(154)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(154)).setAttribute("TIPO","STRING" );
      ((Element)v.get(154)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 142   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(142)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(156)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(156)).setAttribute("TIPO","STRING" );
      ((Element)v.get(156)).setAttribute("VALOR","0" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(157)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(157)).setAttribute("TIPO","STRING" );
      ((Element)v.get(157)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:155   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:158 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(132)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:132   */

      /* Empieza nodo:160 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("colspan","4" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:163 / Elemento padre: 114   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","714" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","left" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblZona" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","143" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:166   */

      /* Empieza nodo:173 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(177)).setAttribute("nombre","cbZona" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("size","5" );
      ((Element)v.get(177)).setAttribute("multiple","S" );
      ((Element)v.get(177)).setAttribute("req","S" );
      ((Element)v.get(177)).setAttribute("valorinicial","" );
      ((Element)v.get(177)).setAttribute("textoinicial","" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(180)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(180)).setAttribute("TIPO","STRING" );
      ((Element)v.get(180)).setAttribute("VALOR","0" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 179   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(181)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(181)).setAttribute("TIPO","STRING" );
      ((Element)v.get(181)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(179)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(178)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(183)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(183)).setAttribute("TIPO","STRING" );
      ((Element)v.get(183)).setAttribute("VALOR","0" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 182   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(184)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(184)).setAttribute("TIPO","STRING" );
      ((Element)v.get(184)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(182)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(186)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(186)).setAttribute("TIPO","STRING" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(186)).setAttribute("VALOR","0" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 185   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(187)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(187)).setAttribute("TIPO","STRING" );
      ((Element)v.get(187)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(185)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:185   */

      /* Empieza nodo:188 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(178)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(189)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(189)).setAttribute("TIPO","STRING" );
      ((Element)v.get(189)).setAttribute("VALOR","0" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 188   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(190)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(190)).setAttribute("TIPO","STRING" );
      ((Element)v.get(190)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(188)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:188   */

      /* Empieza nodo:191 / Elemento padre: 178   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(178)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(192)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(192)).setAttribute("TIPO","STRING" );
      ((Element)v.get(192)).setAttribute("VALOR","0" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(193)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(193)).setAttribute("TIPO","STRING" );
      ((Element)v.get(193)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:191   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:194 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:173   */

      /* Empieza nodo:196 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("colspan","4" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:199 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("table"));
      ((Element)v.get(201)).setAttribute("width","714" );
      ((Element)v.get(201)).setAttribute("border","0" );
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(201)).setAttribute("cellspacing","0" );
      ((Element)v.get(201)).setAttribute("cellpadding","0" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","169" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(202)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:202   */

      /* Empieza nodo:209 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(213)).setAttribute("cols","50" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("nombre","textObservaciones" );
      ((Element)v.get(213)).setAttribute("readonly","N" );
      ((Element)v.get(213)).setAttribute("req","N" );
      ((Element)v.get(213)).setAttribute("rows","3" );
      ((Element)v.get(213)).setAttribute("tabindex","2" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:209   */

      /* Empieza nodo:216 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("colspan","4" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:219 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("table"));
      ((Element)v.get(221)).setAttribute("width","714" );
      ((Element)v.get(221)).setAttribute("border","0" );
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(221)).setAttribute("cellspacing","0" );
      ((Element)v.get(221)).setAttribute("cellpadding","0" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

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
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","595" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(230)).setAttribute("nombre","lblTipoClasificacionCliente" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","610" );
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
   }

   private void getXML900(Document doc) {
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:222   */

      /* Empieza nodo:233 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(237)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(237)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).setAttribute("size","5" );
      ((Element)v.get(237)).setAttribute("multiple","S" );
      ((Element)v.get(237)).setAttribute("req","S" );
      ((Element)v.get(237)).setAttribute("valorinicial","" );
      ((Element)v.get(237)).setAttribute("textoinicial","" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(240)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(240)).setAttribute("TIPO","STRING" );
      ((Element)v.get(240)).setAttribute("VALOR","0" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 239   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(241)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(241)).setAttribute("TIPO","STRING" );
      ((Element)v.get(241)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(239)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 238   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(238)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(243)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(243)).setAttribute("TIPO","STRING" );
      ((Element)v.get(243)).setAttribute("VALOR","0" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(244)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(244)).setAttribute("TIPO","STRING" );
      ((Element)v.get(244)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(242)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 238   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(238)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(246)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(246)).setAttribute("TIPO","STRING" );
      ((Element)v.get(246)).setAttribute("VALOR","0" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 245   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(247)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(247)).setAttribute("TIPO","STRING" );
      ((Element)v.get(247)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(245)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:245   */

      /* Empieza nodo:248 / Elemento padre: 238   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(238)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(249)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(249)).setAttribute("TIPO","STRING" );
      ((Element)v.get(249)).setAttribute("VALOR","0" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 248   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(250)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(250)).setAttribute("TIPO","STRING" );
      ((Element)v.get(250)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(248)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:248   */

      /* Empieza nodo:251 / Elemento padre: 238   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(238)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(252)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(252)).setAttribute("TIPO","STRING" );
      ((Element)v.get(252)).setAttribute("VALOR","0" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 251   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(253)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(253)).setAttribute("TIPO","STRING" );
      ((Element)v.get(253)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(251)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:251   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:254 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","25" );
      ((Element)v.get(255)).setAttribute("height","8" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(256)).setAttribute("valign","top" );
      ((Element)v.get(233)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(257)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(257)).setAttribute("id","datosCampos" );
      ((Element)v.get(257)).setAttribute("size","1" );
      ((Element)v.get(257)).setAttribute("multiple","N" );
      ((Element)v.get(257)).setAttribute("req","S" );
      ((Element)v.get(257)).setAttribute("valorinicial","" );
      ((Element)v.get(257)).setAttribute("textoinicial","" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(260)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(260)).setAttribute("TIPO","STRING" );
      ((Element)v.get(260)).setAttribute("VALOR","0" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(261)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(261)).setAttribute("TIPO","STRING" );
      ((Element)v.get(261)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(259)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:262 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:233   */

      /* Empieza nodo:264 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("colspan","4" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:267 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("table"));
      ((Element)v.get(269)).setAttribute("width","714" );
      ((Element)v.get(269)).setAttribute("border","0" );
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(269)).setAttribute("cellspacing","0" );
      ((Element)v.get(269)).setAttribute("cellpadding","0" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblClasificacionCliente" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("id","datosTitle" );
      ((Element)v.get(274)).setAttribute("cod","611" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(278)).setAttribute("nombre","lblEstado" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("valor","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(278)).setAttribute("id","datosTitle" );
      ((Element)v.get(278)).setAttribute("cod","400" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","100%" );
      ((Element)v.get(270)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:270   */

      /* Empieza nodo:281 / Elemento padre: 269   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(269)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(285)).setAttribute("nombre","cbClasificacionCliente" );
      ((Element)v.get(285)).setAttribute("id","datosCampos" );
      ((Element)v.get(285)).setAttribute("size","1" );
      ((Element)v.get(285)).setAttribute("multiple","N" );
      ((Element)v.get(285)).setAttribute("req","S" );
      ((Element)v.get(285)).setAttribute("valorinicial","" );
      ((Element)v.get(285)).setAttribute("textoinicial","" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(288)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(288)).setAttribute("TIPO","STRING" );
      ((Element)v.get(288)).setAttribute("VALOR","0" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(289)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(289)).setAttribute("TIPO","STRING" );
      ((Element)v.get(289)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:290 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","25" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(281)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(293)).setAttribute("nombre","cbEstado" );
      ((Element)v.get(293)).setAttribute("id","datosCampos" );
      ((Element)v.get(293)).setAttribute("size","1" );
      ((Element)v.get(293)).setAttribute("multiple","N" );
      ((Element)v.get(293)).setAttribute("req","S" );
      ((Element)v.get(293)).setAttribute("valorinicial","" );
      ((Element)v.get(293)).setAttribute("textoinicial","" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(296)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(296)).setAttribute("TIPO","STRING" );
      ((Element)v.get(296)).setAttribute("VALOR","0" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 295   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(297)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(297)).setAttribute("TIPO","STRING" );
      ((Element)v.get(297)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(295)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:298 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","8" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:281   */

      /* Empieza nodo:300 / Elemento padre: 269   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(269)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(301)).setAttribute("colspan","4" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:114   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:303 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","12" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:107   */

      /* Empieza nodo:305 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("table"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(310)).setAttribute("border","0" );
      ((Element)v.get(310)).setAttribute("align","center" );
      ((Element)v.get(310)).setAttribute("cellspacing","0" );
      ((Element)v.get(310)).setAttribute("cellpadding","0" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("class","botonera" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(313)).setAttribute("nombre","btnListaClientes" );
      ((Element)v.get(313)).setAttribute("ID","botonContenido" );
      ((Element)v.get(313)).setAttribute("tipo","html" );
      ((Element)v.get(313)).setAttribute("accion","" );
      ((Element)v.get(313)).setAttribute("estado","false" );
      ((Element)v.get(313)).setAttribute("cod","1375" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:314 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","12" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:305   */

      /* Empieza nodo:316 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("width","12" );
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","12" );
      ((Element)v.get(318)).setAttribute("height","15" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","750" );
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("width","12" );
      ((Element)v.get(316)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","12" );
      ((Element)v.get(322)).setAttribute("height","15" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:316   */

      /* Empieza nodo:323 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(328)).setAttribute("class","legend" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(329)).setAttribute("nombre","lblTitCriteriosAsignacion" );
      ((Element)v.get(329)).setAttribute("alto","13" );
      ((Element)v.get(329)).setAttribute("filas","1" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("cod","0033" );
      ((Element)v.get(329)).setAttribute("id","legend" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 327   */
      v.add(doc.createElement("table"));
      ((Element)v.get(330)).setAttribute("width","100%" );
      ((Element)v.get(330)).setAttribute("border","0" );
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(330)).setAttribute("cellspacing","0" );
      ((Element)v.get(330)).setAttribute("cellpadding","0" );
      ((Element)v.get(327)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("table"));
      ((Element)v.get(333)).setAttribute("width","714" );
      ((Element)v.get(333)).setAttribute("border","0" );
      ((Element)v.get(333)).setAttribute("align","left" );
      ((Element)v.get(333)).setAttribute("cellspacing","0" );
      ((Element)v.get(333)).setAttribute("cellpadding","0" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("colspan","4" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:337 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(341)).setAttribute("nombre","lblCriterioAsignacion" );
      ((Element)v.get(341)).setAttribute("alto","13" );
      ((Element)v.get(341)).setAttribute("filas","1" );
      ((Element)v.get(341)).setAttribute("valor","" );
      ((Element)v.get(341)).setAttribute("id","datosTitle" );
      ((Element)v.get(341)).setAttribute("cod","838" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("width","100%" );
      ((Element)v.get(337)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:337   */

      /* Empieza nodo:344 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(344)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(348)).setAttribute("nombre","cbCriterioAsignacion" );
      ((Element)v.get(348)).setAttribute("id","datosCampos" );
      ((Element)v.get(348)).setAttribute("size","1" );
      ((Element)v.get(348)).setAttribute("multiple","N" );
      ((Element)v.get(348)).setAttribute("req","S" );
      ((Element)v.get(348)).setAttribute("valorinicial","01" );
      ((Element)v.get(348)).setAttribute("textoinicial","Por atributos" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(351)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(351)).setAttribute("TIPO","STRING" );
      ((Element)v.get(351)).setAttribute("VALOR","02" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 350   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(352)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(352)).setAttribute("TIPO","STRING" );
      ((Element)v.get(352)).setAttribute("VALOR","Por variables de venta" );
      ((Element)v.get(350)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:350   */

      /* Empieza nodo:353 / Elemento padre: 349   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(349)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(354)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(354)).setAttribute("TIPO","STRING" );
      ((Element)v.get(354)).setAttribute("VALOR","03" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 353   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(355)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(355)).setAttribute("TIPO","STRING" );
      ((Element)v.get(355)).setAttribute("VALOR","Por fórmula" );
      ((Element)v.get(353)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:353   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:356 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(344)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:344   */

      /* Empieza nodo:358 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(358));

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
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:361 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","12" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:323   */

      /* Empieza nodo:363 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("table"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(368)).setAttribute("border","0" );
      ((Element)v.get(368)).setAttribute("align","center" );
      ((Element)v.get(368)).setAttribute("cellspacing","0" );
      ((Element)v.get(368)).setAttribute("cellpadding","0" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("class","botonera" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(371)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(371)).setAttribute("ID","botonContenido" );
      ((Element)v.get(371)).setAttribute("tipo","html" );
      ((Element)v.get(371)).setAttribute("accion","" );
      ((Element)v.get(371)).setAttribute("estado","false" );
      ((Element)v.get(371)).setAttribute("cod","12" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:372 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(373)).setAttribute("height","12" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:363   */

      /* Empieza nodo:374 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("width","12" );
      ((Element)v.get(375)).setAttribute("align","center" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","12" );
      ((Element)v.get(376)).setAttribute("height","15" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("width","750" );
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).setAttribute("width","12" );
      ((Element)v.get(374)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","12" );
      ((Element)v.get(380)).setAttribute("height","15" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:374   */

      /* Empieza nodo:381 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(386)).setAttribute("class","legend" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(387)).setAttribute("nombre","lblTitDatosDetalle" );
      ((Element)v.get(387)).setAttribute("alto","13" );
      ((Element)v.get(387)).setAttribute("filas","1" );
      ((Element)v.get(387)).setAttribute("valor","" );
      ((Element)v.get(387)).setAttribute("cod","00133" );
      ((Element)v.get(387)).setAttribute("id","legend" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 385   */
      v.add(doc.createElement("table"));
      ((Element)v.get(388)).setAttribute("width","100%" );
      ((Element)v.get(388)).setAttribute("border","0" );
      ((Element)v.get(388)).setAttribute("align","center" );
      ((Element)v.get(388)).setAttribute("cellspacing","0" );
      ((Element)v.get(388)).setAttribute("cellpadding","0" );
      ((Element)v.get(385)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).setAttribute("width","714" );
      ((Element)v.get(391)).setAttribute("border","0" );
      ((Element)v.get(391)).setAttribute("align","left" );
      ((Element)v.get(391)).setAttribute("cellspacing","0" );
      ((Element)v.get(391)).setAttribute("cellpadding","0" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).setAttribute("colspan","4" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:395 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(399)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(399)).setAttribute("alto","13" );
      ((Element)v.get(399)).setAttribute("filas","1" );
      ((Element)v.get(399)).setAttribute("valor","" );
      ((Element)v.get(399)).setAttribute("id","datosTitle" );
      ((Element)v.get(399)).setAttribute("cod","10" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(403)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(403)).setAttribute("alto","13" );
      ((Element)v.get(403)).setAttribute("filas","1" );
      ((Element)v.get(403)).setAttribute("valor","" );
      ((Element)v.get(403)).setAttribute("id","datosTitle" );
      ((Element)v.get(403)).setAttribute("cod","122" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(395)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:395   */

      /* Empieza nodo:406 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(410)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(410)).setAttribute("id","datosCampos" );
      ((Element)v.get(410)).setAttribute("size","5" );
      ((Element)v.get(410)).setAttribute("multiple","S" );
      ((Element)v.get(410)).setAttribute("req","S" );
      ((Element)v.get(410)).setAttribute("valorinicial","" );
      ((Element)v.get(410)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(413)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(413)).setAttribute("TIPO","STRING" );
      ((Element)v.get(413)).setAttribute("VALOR","0" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 412   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(414)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(414)).setAttribute("TIPO","STRING" );
      ((Element)v.get(414)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(412)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 411   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","0" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 415   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(417)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(417)).setAttribute("TIPO","STRING" );
      ((Element)v.get(417)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(415)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:415   */

      /* Empieza nodo:418 / Elemento padre: 411   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","0" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 418   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(420)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(420)).setAttribute("TIPO","STRING" );
      ((Element)v.get(420)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(418)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:418   */

      /* Empieza nodo:421 / Elemento padre: 411   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","0" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 421   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(423)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(423)).setAttribute("TIPO","STRING" );
      ((Element)v.get(423)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(421)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:421   */

      /* Empieza nodo:424 / Elemento padre: 411   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","0" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 424   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(426)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(426)).setAttribute("TIPO","STRING" );
      ((Element)v.get(426)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(424)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:424   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:427 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","25" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(430)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(430)).setAttribute("id","datosCampos" );
      ((Element)v.get(430)).setAttribute("size","5" );
      ((Element)v.get(430)).setAttribute("multiple","S" );
      ((Element)v.get(430)).setAttribute("req","S" );
      ((Element)v.get(430)).setAttribute("valorinicial","" );
      ((Element)v.get(430)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(433)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(433)).setAttribute("VALOR","0" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(434)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(434)).setAttribute("TIPO","STRING" );
      ((Element)v.get(434)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(432)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:432   */

      /* Empieza nodo:435 / Elemento padre: 431   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(431)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","0" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(437)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(437)).setAttribute("TIPO","STRING" );
      ((Element)v.get(437)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(435)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 431   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(431)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","0" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(440)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(440)).setAttribute("TIPO","STRING" );
      ((Element)v.get(440)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(438)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 431   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(431)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","0" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(443)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(443)).setAttribute("TIPO","STRING" );
      ((Element)v.get(443)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(441)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:441   */

      /* Empieza nodo:444 / Elemento padre: 431   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(431)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(445)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(445)).setAttribute("TIPO","STRING" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(445)).setAttribute("VALOR","0" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(446)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(446)).setAttribute("TIPO","STRING" );
      ((Element)v.get(446)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(444)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:444   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:447 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).setAttribute("width","100%" );
      ((Element)v.get(406)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","8" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:406   */

      /* Empieza nodo:449 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("colspan","4" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:452 / Elemento padre: 388   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(388)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("table"));
      ((Element)v.get(454)).setAttribute("width","714" );
      ((Element)v.get(454)).setAttribute("border","0" );
      ((Element)v.get(454)).setAttribute("align","left" );
      ((Element)v.get(454)).setAttribute("cellspacing","0" );
      ((Element)v.get(454)).setAttribute("cellpadding","0" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","8" );
      ((Element)v.get(457)).setAttribute("height","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(459)).setAttribute("nombre","lblPeriodoFin" );
      ((Element)v.get(459)).setAttribute("alto","13" );
      ((Element)v.get(459)).setAttribute("filas","1" );
      ((Element)v.get(459)).setAttribute("valor","" );
      ((Element)v.get(459)).setAttribute("id","datosTitle" );
      ((Element)v.get(459)).setAttribute("cod","967" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","25" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(463)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(463)).setAttribute("alto","13" );
      ((Element)v.get(463)).setAttribute("filas","1" );
      ((Element)v.get(463)).setAttribute("valor","" );
      ((Element)v.get(463)).setAttribute("id","datosTitle" );
      ((Element)v.get(463)).setAttribute("cod","608" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","25" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(467)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(467)).setAttribute("alto","13" );
      ((Element)v.get(467)).setAttribute("filas","1" );
      ((Element)v.get(467)).setAttribute("valor","" );
      ((Element)v.get(467)).setAttribute("id","datosTitle" );
      ((Element)v.get(467)).setAttribute("cod","581" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 455   */
      v.add(doc.createElement("td"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(468)).setAttribute("width","100%" );
      ((Element)v.get(455)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:455   */

      /* Empieza nodo:470 / Elemento padre: 454   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(454)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","8" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(470)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(474)).setAttribute("nombre","cbPeriodoFin" );
      ((Element)v.get(474)).setAttribute("id","datosCampos" );
      ((Element)v.get(474)).setAttribute("size","1" );
      ((Element)v.get(474)).setAttribute("multiple","N" );
      ((Element)v.get(474)).setAttribute("req","S" );
      ((Element)v.get(474)).setAttribute("valorinicial","" );
      ((Element)v.get(474)).setAttribute("textoinicial","" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(477)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(477)).setAttribute("TIPO","STRING" );
      ((Element)v.get(477)).setAttribute("VALOR","0" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 476   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(478)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(478)).setAttribute("TIPO","STRING" );
      ((Element)v.get(478)).setAttribute("VALOR","xxxxxxxxxx" );
      ((Element)v.get(476)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:479 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","25" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(470)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(482)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(482)).setAttribute("id","datosCampos" );
      ((Element)v.get(482)).setAttribute("size","1" );
      ((Element)v.get(482)).setAttribute("multiple","N" );
      ((Element)v.get(482)).setAttribute("req","S" );
      ((Element)v.get(482)).setAttribute("valorinicial","" );
      ((Element)v.get(482)).setAttribute("textoinicial","" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(485)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(485)).setAttribute("TIPO","STRING" );
      ((Element)v.get(485)).setAttribute("VALOR","0" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(486)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(486)).setAttribute("TIPO","STRING" );
      ((Element)v.get(486)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(484)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:487 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).setAttribute("width","25" );
      ((Element)v.get(488)).setAttribute("height","8" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:489 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(470)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(490)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(490)).setAttribute("id","datosCampos" );
      ((Element)v.get(490)).setAttribute("size","1" );
      ((Element)v.get(490)).setAttribute("multiple","N" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(490)).setAttribute("req","S" );
      ((Element)v.get(490)).setAttribute("valorinicial","" );
      ((Element)v.get(490)).setAttribute("textoinicial","" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(493)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(493)).setAttribute("TIPO","STRING" );
      ((Element)v.get(493)).setAttribute("VALOR","0" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 492   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(494)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(494)).setAttribute("TIPO","STRING" );
      ((Element)v.get(494)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(492)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:495 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("width","100%" );
      ((Element)v.get(470)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).setAttribute("width","8" );
      ((Element)v.get(496)).setAttribute("height","8" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:470   */

      /* Empieza nodo:497 / Elemento padre: 454   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(454)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(498)).setAttribute("colspan","4" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","8" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:500 / Elemento padre: 388   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(388)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("table"));
      ((Element)v.get(502)).setAttribute("width","714" );
      ((Element)v.get(502)).setAttribute("border","0" );
      ((Element)v.get(502)).setAttribute("align","left" );
      ((Element)v.get(502)).setAttribute("cellspacing","0" );
      ((Element)v.get(502)).setAttribute("cellpadding","0" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(502)).appendChild((Element)v.get(503));

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
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(507)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(507)).setAttribute("alto","13" );
      ((Element)v.get(507)).setAttribute("filas","1" );
      ((Element)v.get(507)).setAttribute("valor","" );
      ((Element)v.get(507)).setAttribute("id","datosTitle" );
      ((Element)v.get(507)).setAttribute("cod","337" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","25" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(511)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(511)).setAttribute("alto","13" );
      ((Element)v.get(511)).setAttribute("filas","1" );
      ((Element)v.get(511)).setAttribute("valor","" );
      ((Element)v.get(511)).setAttribute("id","datosTitle" );
      ((Element)v.get(511)).setAttribute("cod","336" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","25" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 503   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(515)).setAttribute("nombre","lblPrecioEstandar" );
      ((Element)v.get(515)).setAttribute("alto","13" );
      ((Element)v.get(515)).setAttribute("filas","1" );
      ((Element)v.get(515)).setAttribute("valor","" );
      ((Element)v.get(515)).setAttribute("id","datosTitle" );
      ((Element)v.get(515)).setAttribute("cod","1370" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","25" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lblPrecio" );
      ((Element)v.get(519)).setAttribute("alto","13" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("id","datosTitle" );
      ((Element)v.get(519)).setAttribute("cod","377" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(523)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(523)).setAttribute("alto","13" );
      ((Element)v.get(523)).setAttribute("filas","1" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("id","datosTitle" );
      ((Element)v.get(523)).setAttribute("cod","974" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(524)).setAttribute("width","100%" );
      ((Element)v.get(503)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:503   */

      /* Empieza nodo:526 / Elemento padre: 502   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(502)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).setAttribute("width","8" );
      ((Element)v.get(528)).setAttribute("height","8" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(529)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(526)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(530)).setAttribute("nombre","textCodProducto" );
      ((Element)v.get(530)).setAttribute("id","datosCampos" );
      ((Element)v.get(530)).setAttribute("max","" );
      ((Element)v.get(530)).setAttribute("tipo","" );
      ((Element)v.get(530)).setAttribute("onchange","20" );
      ((Element)v.get(530)).setAttribute("req","S" );
      ((Element)v.get(530)).setAttribute("valor","" );
      ((Element)v.get(530)).setAttribute("size","20" );
      ((Element)v.get(530)).setAttribute("validacion","" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","25" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(533)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(533)).setAttribute("valign","bottom" );
      ((Element)v.get(526)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(534)).setAttribute("nombre","textCodVenta" );
      ((Element)v.get(534)).setAttribute("id","datosCampos" );
      ((Element)v.get(534)).setAttribute("max","" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(534)).setAttribute("tipo","" );
      ((Element)v.get(534)).setAttribute("onchange","17" );
      ((Element)v.get(534)).setAttribute("req","N" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(534)).setAttribute("size","17" );
      ((Element)v.get(534)).setAttribute("validacion","" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","25" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(526)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(538)).setAttribute("nombre","textPrecioEstandar" );
      ((Element)v.get(538)).setAttribute("id","datosCampos" );
      ((Element)v.get(538)).setAttribute("max","" );
      ((Element)v.get(538)).setAttribute("tipo","" );
      ((Element)v.get(538)).setAttribute("onchange","17" );
      ((Element)v.get(538)).setAttribute("req","S" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(538)).setAttribute("size","17" );
      ((Element)v.get(538)).setAttribute("validacion","" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","25" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(526)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(542)).setAttribute("nombre","textPrecio" );
      ((Element)v.get(542)).setAttribute("id","datosCampos" );
      ((Element)v.get(542)).setAttribute("max","" );
      ((Element)v.get(542)).setAttribute("tipo","" );
      ((Element)v.get(542)).setAttribute("onchange","17" );
      ((Element)v.get(542)).setAttribute("req","S" );
      ((Element)v.get(542)).setAttribute("valor","" );
      ((Element)v.get(542)).setAttribute("size","17" );
      ((Element)v.get(542)).setAttribute("validacion","" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(544)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).setAttribute("width","25" );
      ((Element)v.get(544)).setAttribute("height","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(545)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(526)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(546)).setAttribute("nombre","textPrecioContable" );
      ((Element)v.get(546)).setAttribute("id","datosCampos" );
      ((Element)v.get(546)).setAttribute("max","" );
      ((Element)v.get(546)).setAttribute("tipo","" );
      ((Element)v.get(546)).setAttribute("onchange","17" );
      ((Element)v.get(546)).setAttribute("req","S" );
      ((Element)v.get(546)).setAttribute("valor","" );
      ((Element)v.get(546)).setAttribute("size","17" );
      ((Element)v.get(546)).setAttribute("validacion","" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:547 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(547)).setAttribute("width","100%" );
      ((Element)v.get(526)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","8" );
      ((Element)v.get(548)).setAttribute("height","8" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:526   */

      /* Empieza nodo:549 / Elemento padre: 502   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(502)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).setAttribute("colspan","4" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(551)).setAttribute("src","b.gif" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(551)).setAttribute("height","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:552 / Elemento padre: 388   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(388)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("table"));
      ((Element)v.get(554)).setAttribute("width","714" );
      ((Element)v.get(554)).setAttribute("border","0" );
      ((Element)v.get(554)).setAttribute("align","left" );
      ((Element)v.get(554)).setAttribute("cellspacing","0" );
      ((Element)v.get(554)).setAttribute("cellpadding","0" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).setAttribute("width","8" );
      ((Element)v.get(557)).setAttribute("height","8" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(559)).setAttribute("nombre","lblBaseDestinatarios" );
      ((Element)v.get(559)).setAttribute("alto","13" );
      ((Element)v.get(559)).setAttribute("filas","1" );
      ((Element)v.get(559)).setAttribute("valor","" );
      ((Element)v.get(559)).setAttribute("id","datosTitle" );
      ((Element)v.get(559)).setAttribute("cod","807" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","25" );
      ((Element)v.get(561)).setAttribute("height","8" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(563)).setAttribute("nombre","lblFactorCorreccion" );
      ((Element)v.get(563)).setAttribute("alto","13" );
      ((Element)v.get(563)).setAttribute("filas","1" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(563)).setAttribute("id","datosTitle" );
      ((Element)v.get(563)).setAttribute("cod","869" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","25" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(567)).setAttribute("nombre","lblPromedio" );
      ((Element)v.get(567)).setAttribute("alto","13" );
      ((Element)v.get(567)).setAttribute("filas","1" );
      ((Element)v.get(567)).setAttribute("valor","" );
      ((Element)v.get(567)).setAttribute("id","datosTitle" );
      ((Element)v.get(567)).setAttribute("cod","1371" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","25" );
      ((Element)v.get(569)).setAttribute("height","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(571)).setAttribute("nombre","lblUnidades" );
      ((Element)v.get(571)).setAttribute("alto","13" );
      ((Element)v.get(571)).setAttribute("filas","1" );
      ((Element)v.get(571)).setAttribute("valor","" );
      ((Element)v.get(571)).setAttribute("id","datosTitle" );
      ((Element)v.get(571)).setAttribute("cod","1179" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","25" );
      ((Element)v.get(573)).setAttribute("height","8" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(575)).setAttribute("nombre","lblCriterio" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(575)).setAttribute("alto","13" );
      ((Element)v.get(575)).setAttribute("filas","1" );
      ((Element)v.get(575)).setAttribute("valor","" );
      ((Element)v.get(575)).setAttribute("id","datosTitle" );
      ((Element)v.get(575)).setAttribute("cod","837" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).setAttribute("width","100%" );
      ((Element)v.get(555)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","8" );
      ((Element)v.get(577)).setAttribute("height","8" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:555   */

      /* Empieza nodo:578 / Elemento padre: 554   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(554)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(582)).setAttribute("nombre","textBaseDestinatarios" );
      ((Element)v.get(582)).setAttribute("id","datosCampos" );
      ((Element)v.get(582)).setAttribute("max","10" );
      ((Element)v.get(582)).setAttribute("tipo","" );
      ((Element)v.get(582)).setAttribute("onchange","20" );
      ((Element)v.get(582)).setAttribute("req","N" );
      ((Element)v.get(582)).setAttribute("valor","" );
      ((Element)v.get(582)).setAttribute("size","10" );
      ((Element)v.get(582)).setAttribute("validacion","" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:583 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","25" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(586)).setAttribute("nombre","textFactorCorreccion" );
      ((Element)v.get(586)).setAttribute("id","datosCampos" );
      ((Element)v.get(586)).setAttribute("max","18" );
      ((Element)v.get(586)).setAttribute("tipo","" );
      ((Element)v.get(586)).setAttribute("onchange","18" );
      ((Element)v.get(586)).setAttribute("req","N" );
      ((Element)v.get(586)).setAttribute("valor","" );
      ((Element)v.get(586)).setAttribute("size","18" );
      ((Element)v.get(586)).setAttribute("validacion","" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","25" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(590)).setAttribute("nombre","textPromedio" );
      ((Element)v.get(590)).setAttribute("id","datosCampos" );
      ((Element)v.get(590)).setAttribute("max","17" );
      ((Element)v.get(590)).setAttribute("tipo","" );
      ((Element)v.get(590)).setAttribute("onchange","17" );
      ((Element)v.get(590)).setAttribute("req","N" );
      ((Element)v.get(590)).setAttribute("valor","" );
      ((Element)v.get(590)).setAttribute("size","17" );
      ((Element)v.get(590)).setAttribute("validacion","" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","25" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(594)).setAttribute("nombre","textUnidades" );
      ((Element)v.get(594)).setAttribute("id","datosCampos" );
      ((Element)v.get(594)).setAttribute("max","20" );
      ((Element)v.get(594)).setAttribute("tipo","" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(594)).setAttribute("onchange","17" );
      ((Element)v.get(594)).setAttribute("req","N" );
      ((Element)v.get(594)).setAttribute("valor","" );
      ((Element)v.get(594)).setAttribute("size","20" );
      ((Element)v.get(594)).setAttribute("validacion","" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","25" );
      ((Element)v.get(596)).setAttribute("height","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(598)).setAttribute("nombre","textCriterio" );
      ((Element)v.get(598)).setAttribute("id","datosCampos" );
      ((Element)v.get(598)).setAttribute("max","20" );
      ((Element)v.get(598)).setAttribute("tipo","" );
      ((Element)v.get(598)).setAttribute("onchange","17" );
      ((Element)v.get(598)).setAttribute("req","N" );
      ((Element)v.get(598)).setAttribute("valor","" );
      ((Element)v.get(598)).setAttribute("size","20" );
      ((Element)v.get(598)).setAttribute("validacion","" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).setAttribute("width","100%" );
      ((Element)v.get(578)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","8" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:578   */

      /* Empieza nodo:601 / Elemento padre: 554   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(554)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).setAttribute("colspan","4" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","8" );
      ((Element)v.get(603)).setAttribute("height","8" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:604 / Elemento padre: 388   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(388)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("td"));
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("table"));
      ((Element)v.get(606)).setAttribute("width","714" );
      ((Element)v.get(606)).setAttribute("border","0" );
      ((Element)v.get(606)).setAttribute("align","left" );
      ((Element)v.get(606)).setAttribute("cellspacing","0" );
      ((Element)v.get(606)).setAttribute("cellpadding","0" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(609)).setAttribute("src","b.gif" );
      ((Element)v.get(609)).setAttribute("width","8" );
      ((Element)v.get(609)).setAttribute("height","8" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:610 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(611)).setAttribute("nombre","lblFormaCobro" );
      ((Element)v.get(611)).setAttribute("alto","13" );
      ((Element)v.get(611)).setAttribute("filas","1" );
      ((Element)v.get(611)).setAttribute("valor","" );
      ((Element)v.get(611)).setAttribute("id","datosTitle" );
      ((Element)v.get(611)).setAttribute("cod","884" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(613)).setAttribute("src","b.gif" );
      ((Element)v.get(613)).setAttribute("width","25" );
      ((Element)v.get(613)).setAttribute("height","8" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:614 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(615)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(615)).setAttribute("alto","13" );
      ((Element)v.get(615)).setAttribute("filas","1" );
      ((Element)v.get(615)).setAttribute("valor","" );
      ((Element)v.get(615)).setAttribute("id","datosTitle" );
      ((Element)v.get(615)).setAttribute("cod","541" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:616 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(617)).setAttribute("width","25" );
      ((Element)v.get(617)).setAttribute("height","8" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(619)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(619)).setAttribute("alto","13" );
      ((Element)v.get(619)).setAttribute("filas","1" );
      ((Element)v.get(619)).setAttribute("valor","" );
      ((Element)v.get(619)).setAttribute("id","datosTitle" );
      ((Element)v.get(619)).setAttribute("cod","1000" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).setAttribute("width","100%" );
      ((Element)v.get(607)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(621)).setAttribute("height","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:607   */

      /* Empieza nodo:622 / Elemento padre: 606   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(606)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:625 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(622)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(626)).setAttribute("nombre","cbFormaCobro" );
      ((Element)v.get(626)).setAttribute("id","datosCampos" );
      ((Element)v.get(626)).setAttribute("size","1" );
      ((Element)v.get(626)).setAttribute("multiple","N" );
      ((Element)v.get(626)).setAttribute("req","S" );
      ((Element)v.get(626)).setAttribute("valorinicial","00" );
      ((Element)v.get(626)).setAttribute("textoinicial","Gratis" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(626)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(629)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(629)).setAttribute("TIPO","STRING" );
      ((Element)v.get(629)).setAttribute("VALOR","01" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */

      /* Empieza nodo:630 / Elemento padre: 628   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(630)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(630)).setAttribute("TIPO","STRING" );
      ((Element)v.get(630)).setAttribute("VALOR","Facturado" );
      ((Element)v.get(628)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:631 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","25" );
      ((Element)v.get(632)).setAttribute("height","8" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(633)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(622)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(634)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(634)).setAttribute("id","datosCampos" );
      ((Element)v.get(634)).setAttribute("size","1" );
      ((Element)v.get(634)).setAttribute("multiple","N" );
      ((Element)v.get(634)).setAttribute("req","S" );
      ((Element)v.get(634)).setAttribute("valorinicial","00" );
      ((Element)v.get(634)).setAttribute("textoinicial","xxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(634)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(637)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(637)).setAttribute("TIPO","STRING" );
      ((Element)v.get(637)).setAttribute("VALOR","01" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */

      /* Empieza nodo:638 / Elemento padre: 636   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(638)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(638)).setAttribute("TIPO","STRING" );
      ((Element)v.get(638)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(636)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:636   */
      /* Termina nodo:635   */
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:639 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(640)).setAttribute("width","25" );
      ((Element)v.get(640)).setAttribute("height","8" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */

      /* Empieza nodo:641 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(622)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(642)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(642)).setAttribute("id","datosCampos" );
      ((Element)v.get(642)).setAttribute("size","1" );
      ((Element)v.get(642)).setAttribute("multiple","N" );
      ((Element)v.get(642)).setAttribute("req","S" );
      ((Element)v.get(642)).setAttribute("valorinicial","01" );
      ((Element)v.get(642)).setAttribute("textoinicial","Con pedido" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(642)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(643)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(645)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(645)).setAttribute("TIPO","STRING" );
      ((Element)v.get(645)).setAttribute("VALOR","03" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */

      /* Empieza nodo:646 / Elemento padre: 644   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(646)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(646)).setAttribute("TIPO","STRING" );
      ((Element)v.get(646)).setAttribute("VALOR","Con pedido de servicio" );
      ((Element)v.get(644)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:644   */

      /* Empieza nodo:647 / Elemento padre: 643   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(643)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(648)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(648)).setAttribute("TIPO","STRING" );
      ((Element)v.get(648)).setAttribute("VALOR","04" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */

      /* Empieza nodo:649 / Elemento padre: 647   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(649)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(649)).setAttribute("TIPO","STRING" );
      ((Element)v.get(649)).setAttribute("VALOR","Siempre inicio período" );
      ((Element)v.get(647)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:647   */

      /* Empieza nodo:650 / Elemento padre: 643   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(643)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(651)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(651)).setAttribute("TIPO","STRING" );
      ((Element)v.get(651)).setAttribute("VALOR","05" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 650   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(652)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(652)).setAttribute("TIPO","STRING" );
      ((Element)v.get(652)).setAttribute("VALOR","Siempre fin período" );
      ((Element)v.get(650)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:650   */
      /* Termina nodo:643   */
      /* Termina nodo:642   */
      /* Termina nodo:641   */

      /* Empieza nodo:653 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(653)).setAttribute("width","100%" );
      ((Element)v.get(622)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(654)).setAttribute("src","b.gif" );
      ((Element)v.get(654)).setAttribute("width","8" );
      ((Element)v.get(654)).setAttribute("height","8" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:653   */
      /* Termina nodo:622   */

      /* Empieza nodo:655 / Elemento padre: 606   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(606)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(656)).setAttribute("colspan","4" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","8" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */
      /* Termina nodo:655   */
      /* Termina nodo:606   */
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:658 / Elemento padre: 388   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(388)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("td"));
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("table"));
      ((Element)v.get(660)).setAttribute("width","714" );
      ((Element)v.get(660)).setAttribute("border","0" );
      ((Element)v.get(660)).setAttribute("align","left" );
      ((Element)v.get(660)).setAttribute("cellspacing","0" );
      ((Element)v.get(660)).setAttribute("cellpadding","0" );
      ((Element)v.get(659)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("td"));
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(663)).setAttribute("src","b.gif" );
      ((Element)v.get(663)).setAttribute("width","8" );
      ((Element)v.get(663)).setAttribute("height","8" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */
      /* Termina nodo:662   */

      /* Empieza nodo:664 / Elemento padre: 661   */
      v.add(doc.createElement("td"));
      ((Element)v.get(661)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(665)).setAttribute("nombre","lblEnvio" );
      ((Element)v.get(665)).setAttribute("alto","13" );
      ((Element)v.get(665)).setAttribute("filas","1" );
      ((Element)v.get(665)).setAttribute("valor","" );
      ((Element)v.get(665)).setAttribute("id","datosTitle" );
      ((Element)v.get(665)).setAttribute("cod","859" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 661   */
      v.add(doc.createElement("td"));
      ((Element)v.get(666)).setAttribute("width","100%" );
      ((Element)v.get(661)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(667)).setAttribute("src","b.gif" );
      ((Element)v.get(667)).setAttribute("width","8" );
      ((Element)v.get(667)).setAttribute("height","8" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */
      /* Termina nodo:661   */

      /* Empieza nodo:668 / Elemento padre: 660   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(660)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("td"));
      ((Element)v.get(668)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(670)).setAttribute("width","8" );
      ((Element)v.get(670)).setAttribute("height","8" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */

      /* Empieza nodo:671 / Elemento padre: 668   */
      v.add(doc.createElement("td"));
      ((Element)v.get(671)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(668)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(672)).setAttribute("nombre","cbTipoEnvio" );
      ((Element)v.get(672)).setAttribute("id","datosCampos" );
      ((Element)v.get(672)).setAttribute("size","1" );
      ((Element)v.get(672)).setAttribute("multiple","N" );
      ((Element)v.get(672)).setAttribute("req","N" );
      ((Element)v.get(672)).setAttribute("valorinicial","00" );
      ((Element)v.get(672)).setAttribute("textoinicial","Con primera solicitud que cumpla condición" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(673)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(675)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(675)).setAttribute("TIPO","STRING" );
      ((Element)v.get(675)).setAttribute("VALOR","01" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */

      /* Empieza nodo:676 / Elemento padre: 674   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(676)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(676)).setAttribute("TIPO","STRING" );
      ((Element)v.get(676)).setAttribute("VALOR","Con todas las que las cumplan" );
      ((Element)v.get(674)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:674   */
      /* Termina nodo:673   */
      /* Termina nodo:672   */
      /* Termina nodo:671   */

      /* Empieza nodo:677 / Elemento padre: 668   */
      v.add(doc.createElement("td"));
      ((Element)v.get(677)).setAttribute("width","100%" );
      ((Element)v.get(668)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("width","8" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */
      /* Termina nodo:668   */

      /* Empieza nodo:679 / Elemento padre: 660   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(660)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(680)).setAttribute("colspan","4" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(681)).setAttribute("src","b.gif" );
      ((Element)v.get(681)).setAttribute("width","8" );
      ((Element)v.get(681)).setAttribute("height","8" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:680   */
      /* Termina nodo:679   */
      /* Termina nodo:660   */
      /* Termina nodo:659   */
      /* Termina nodo:658   */
      /* Termina nodo:388   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:682 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(683)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).setAttribute("width","8" );
      ((Element)v.get(683)).setAttribute("height","12" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */
      /* Termina nodo:381   */

      /* Empieza nodo:684 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(685)).setAttribute("width","12" );
      ((Element)v.get(685)).setAttribute("align","center" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("width","12" );
      ((Element)v.get(686)).setAttribute("height","12" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */

      /* Empieza nodo:687 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(687)).setAttribute("width","750" );
      ((Element)v.get(684)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(688)).setAttribute("src","b.gif" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(689)).setAttribute("width","12" );
      ((Element)v.get(684)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(690)).setAttribute("src","b.gif" );
      ((Element)v.get(690)).setAttribute("width","12" );
      ((Element)v.get(690)).setAttribute("height","12" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */
      /* Termina nodo:684   */
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:691 / Elemento padre: 1   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(691)).setAttribute("nombre","capaBoton" );
      ((Element)v.get(691)).setAttribute("alto","120" );
      ((Element)v.get(691)).setAttribute("ancho","100%" );
      ((Element)v.get(691)).setAttribute("colorf","" );
      ((Element)v.get(691)).setAttribute("borde","0" );
      ((Element)v.get(691)).setAttribute("imagenf","" );
      ((Element)v.get(691)).setAttribute("repeat","" );
      ((Element)v.get(691)).setAttribute("padding","" );
      ((Element)v.get(691)).setAttribute("visibilidad","" );
      ((Element)v.get(691)).setAttribute("contravsb","" );
      ((Element)v.get(691)).setAttribute("x","0" );
      ((Element)v.get(691)).setAttribute("y","966" );
      ((Element)v.get(691)).setAttribute("zindex","" );
      ((Element)v.get(1)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("table"));
      ((Element)v.get(692)).setAttribute("width","100%" );
      ((Element)v.get(692)).setAttribute("border","0" );
      ((Element)v.get(692)).setAttribute("cellspacing","0" );
      ((Element)v.get(692)).setAttribute("cellpadding","0" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(692)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).setAttribute("width","12" );
      ((Element)v.get(694)).setAttribute("align","center" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(695)).setAttribute("src","b.gif" );
      ((Element)v.get(695)).setAttribute("width","12" );
      ((Element)v.get(695)).setAttribute("height","12" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:694   */

      /* Empieza nodo:696 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(696)).setAttribute("width","750" );
      ((Element)v.get(693)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(697)).setAttribute("src","b.gif" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:696   */

      /* Empieza nodo:698 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(698)).setAttribute("width","12" );
      ((Element)v.get(693)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(699)).setAttribute("src","b.gif" );
      ((Element)v.get(699)).setAttribute("width","12" );
      ((Element)v.get(699)).setAttribute("height","1" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:698   */
      /* Termina nodo:693   */

      /* Empieza nodo:700 / Elemento padre: 692   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(692)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("td"));
      ((Element)v.get(700)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(702)).setAttribute("src","b.gif" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 700   */
      v.add(doc.createElement("td"));
      ((Element)v.get(700)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(703)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(705)).setAttribute("class","legend" );
      ((Element)v.get(704)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(706)).setAttribute("nombre","lblTitCritOtrosDatos" );
      ((Element)v.get(706)).setAttribute("alto","13" );
      ((Element)v.get(706)).setAttribute("filas","1" );
      ((Element)v.get(706)).setAttribute("valor","" );
      ((Element)v.get(706)).setAttribute("cod","00284" );
      ((Element)v.get(706)).setAttribute("id","legend" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */

      /* Empieza nodo:707 / Elemento padre: 704   */
   }

   private void getXML2790(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(707)).setAttribute("width","100%" );
      ((Element)v.get(707)).setAttribute("border","0" );
      ((Element)v.get(707)).setAttribute("align","center" );
      ((Element)v.get(707)).setAttribute("cellspacing","0" );
      ((Element)v.get(707)).setAttribute("cellpadding","0" );
      ((Element)v.get(704)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(707)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("td"));
      ((Element)v.get(708)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("table"));
      ((Element)v.get(710)).setAttribute("width","714" );
      ((Element)v.get(710)).setAttribute("border","0" );
      ((Element)v.get(710)).setAttribute("align","left" );
      ((Element)v.get(710)).setAttribute("cellspacing","0" );
      ((Element)v.get(710)).setAttribute("cellpadding","0" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(710)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("td"));
      ((Element)v.get(712)).setAttribute("colspan","4" );
      ((Element)v.get(711)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(713)).setAttribute("src","b.gif" );
      ((Element)v.get(713)).setAttribute("width","8" );
      ((Element)v.get(713)).setAttribute("height","8" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */
      /* Termina nodo:712   */
      /* Termina nodo:711   */

      /* Empieza nodo:714 / Elemento padre: 710   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(710)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("td"));
      ((Element)v.get(714)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(716)).setAttribute("src","b.gif" );
      ((Element)v.get(716)).setAttribute("width","8" );
      ((Element)v.get(716)).setAttribute("height","8" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */
      /* Termina nodo:715   */

      /* Empieza nodo:717 / Elemento padre: 714   */
      v.add(doc.createElement("td"));
      ((Element)v.get(714)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(718)).setAttribute("nombre","lblEnviarMensaje" );
      ((Element)v.get(718)).setAttribute("alto","13" );
      ((Element)v.get(718)).setAttribute("filas","1" );
      ((Element)v.get(718)).setAttribute("valor","" );
      ((Element)v.get(718)).setAttribute("id","datosTitle" );
      ((Element)v.get(718)).setAttribute("cod","1221" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:717   */

      /* Empieza nodo:719 / Elemento padre: 714   */
      v.add(doc.createElement("td"));
      ((Element)v.get(714)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(720)).setAttribute("src","b.gif" );
      ((Element)v.get(720)).setAttribute("width","25" );
      ((Element)v.get(720)).setAttribute("height","8" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */
      /* Termina nodo:719   */

      /* Empieza nodo:721 / Elemento padre: 714   */
      v.add(doc.createElement("td"));
      ((Element)v.get(714)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(722)).setAttribute("nombre","lblCodMensaje" );
      ((Element)v.get(722)).setAttribute("alto","13" );
      ((Element)v.get(722)).setAttribute("filas","1" );
      ((Element)v.get(722)).setAttribute("valor","" );
      ((Element)v.get(722)).setAttribute("id","datosTitle" );
      ((Element)v.get(722)).setAttribute("cod","821" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */
      /* Termina nodo:721   */

      /* Empieza nodo:723 / Elemento padre: 714   */
      v.add(doc.createElement("td"));
      ((Element)v.get(723)).setAttribute("width","100%" );
      ((Element)v.get(714)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(724)).setAttribute("src","b.gif" );
      ((Element)v.get(724)).setAttribute("width","8" );
      ((Element)v.get(724)).setAttribute("height","8" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */
      /* Termina nodo:723   */
      /* Termina nodo:714   */

      /* Empieza nodo:725 / Elemento padre: 710   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(710)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(725)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(727)).setAttribute("src","b.gif" );
      ((Element)v.get(727)).setAttribute("width","8" );
      ((Element)v.get(727)).setAttribute("height","8" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */
      /* Termina nodo:726   */

      /* Empieza nodo:728 / Elemento padre: 725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(728)).setAttribute("class","datosCampos" );
      ((Element)v.get(728)).setAttribute("valign","bottom" );
      ((Element)v.get(725)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(729)).setAttribute("nombre","rbEnviarMensaje" );
      ((Element)v.get(729)).setAttribute("tipo","H" );
      ((Element)v.get(729)).setAttribute("id","datosCampos" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(730)).setAttribute("valor","S" );
      ((Element)v.get(730)).setAttribute("check","N" );
      ((Element)v.get(730)).setAttribute("onfocus","" );
      ((Element)v.get(730)).setAttribute("id","datosCampos" );
      ((Element)v.get(730)).setAttribute("cod","117" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));

      /* Elemento padre:730 / Elemento actual: 731   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(730)).appendChild((Text)v.get(731));

      /* Termina nodo Texto:731   */
      /* Termina nodo:730   */

      /* Empieza nodo:732 / Elemento padre: 729   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(732)).setAttribute("valor","N" );
      ((Element)v.get(732)).setAttribute("check","N" );
      ((Element)v.get(732)).setAttribute("onfocus","" );
      ((Element)v.get(732)).setAttribute("id","datosCampos" );
      ((Element)v.get(732)).setAttribute("cod","87" );
      ((Element)v.get(729)).appendChild((Element)v.get(732));

      /* Elemento padre:732 / Elemento actual: 733   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(732)).appendChild((Text)v.get(733));

      /* Termina nodo Texto:733   */
      /* Termina nodo:732   */
      /* Termina nodo:729   */
      /* Termina nodo:728   */

      /* Empieza nodo:734 / Elemento padre: 725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(725)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).setAttribute("width","25" );
      ((Element)v.get(735)).setAttribute("height","8" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(725)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(737)).setAttribute("nombre","cbCodMensaje" );
      ((Element)v.get(737)).setAttribute("id","datosCampos" );
      ((Element)v.get(737)).setAttribute("size","1" );
      ((Element)v.get(737)).setAttribute("multiple","N" );
      ((Element)v.get(737)).setAttribute("req","S" );
      ((Element)v.get(737)).setAttribute("valorinicial","" );
      ((Element)v.get(737)).setAttribute("textoinicial","" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(738)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(740)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(740)).setAttribute("TIPO","STRING" );
      ((Element)v.get(740)).setAttribute("VALOR","0" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */

      /* Empieza nodo:741 / Elemento padre: 739   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(741)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(741)).setAttribute("TIPO","STRING" );
      ((Element)v.get(741)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(739)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */
      /* Termina nodo:739   */
      /* Termina nodo:738   */
      /* Termina nodo:737   */
      /* Termina nodo:736   */

      /* Empieza nodo:742 / Elemento padre: 725   */
      v.add(doc.createElement("td"));
      ((Element)v.get(742)).setAttribute("width","100%" );
      ((Element)v.get(725)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(743)).setAttribute("src","b.gif" );
      ((Element)v.get(743)).setAttribute("width","8" );
      ((Element)v.get(743)).setAttribute("height","8" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */
      /* Termina nodo:742   */
      /* Termina nodo:725   */

      /* Empieza nodo:744 / Elemento padre: 710   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(710)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("td"));
      ((Element)v.get(745)).setAttribute("colspan","4" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(746)).setAttribute("src","b.gif" );
      ((Element)v.get(746)).setAttribute("width","8" );
      ((Element)v.get(746)).setAttribute("height","8" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:744   */
      /* Termina nodo:710   */
      /* Termina nodo:709   */
      /* Termina nodo:708   */
      /* Termina nodo:707   */
      /* Termina nodo:704   */
      /* Termina nodo:703   */

      /* Empieza nodo:747 / Elemento padre: 700   */
      v.add(doc.createElement("td"));
      ((Element)v.get(700)).appendChild((Element)v.get(747));

      /* Empieza nodo:748 / Elemento padre: 747   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(748)).setAttribute("src","b.gif" );
      ((Element)v.get(748)).setAttribute("width","8" );
      ((Element)v.get(748)).setAttribute("height","12" );
      ((Element)v.get(747)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */
      /* Termina nodo:747   */
      /* Termina nodo:700   */

      /* Empieza nodo:749 / Elemento padre: 692   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(692)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("td"));
      ((Element)v.get(749)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(751)).setAttribute("src","b.gif" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:750   */

      /* Empieza nodo:752 / Elemento padre: 749   */
      v.add(doc.createElement("td"));
      ((Element)v.get(749)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(752)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("table"));
      ((Element)v.get(754)).setAttribute("width","100%" );
      ((Element)v.get(754)).setAttribute("border","0" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(754)).setAttribute("align","center" );
      ((Element)v.get(754)).setAttribute("cellspacing","0" );
      ((Element)v.get(754)).setAttribute("cellpadding","0" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(754)).appendChild((Element)v.get(755));

      /* Empieza nodo:756 / Elemento padre: 755   */
      v.add(doc.createElement("td"));
      ((Element)v.get(756)).setAttribute("class","botonera" );
      ((Element)v.get(755)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(757)).setAttribute("nombre","btnNuevaEntrada" );
      ((Element)v.get(757)).setAttribute("ID","botonContenido" );
      ((Element)v.get(757)).setAttribute("tipo","html" );
      ((Element)v.get(757)).setAttribute("accion","" );
      ((Element)v.get(757)).setAttribute("estado","false" );
      ((Element)v.get(757)).setAttribute("cod","945" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */
      /* Termina nodo:756   */
      /* Termina nodo:755   */
      /* Termina nodo:754   */
      /* Termina nodo:753   */
      /* Termina nodo:752   */

      /* Empieza nodo:758 / Elemento padre: 749   */
      v.add(doc.createElement("td"));
      ((Element)v.get(749)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(759)).setAttribute("src","b.gif" );
      ((Element)v.get(759)).setAttribute("width","8" );
      ((Element)v.get(759)).setAttribute("height","12" );
      ((Element)v.get(758)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:749   */

      /* Empieza nodo:760 / Elemento padre: 692   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(692)).appendChild((Element)v.get(760));

      /* Empieza nodo:761 / Elemento padre: 760   */
      v.add(doc.createElement("td"));
      ((Element)v.get(761)).setAttribute("width","12" );
      ((Element)v.get(761)).setAttribute("align","center" );
      ((Element)v.get(760)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(762)).setAttribute("src","b.gif" );
      ((Element)v.get(762)).setAttribute("width","12" );
      ((Element)v.get(762)).setAttribute("height","12" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */

      /* Empieza nodo:763 / Elemento padre: 760   */
      v.add(doc.createElement("td"));
      ((Element)v.get(763)).setAttribute("width","750" );
      ((Element)v.get(760)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(764)).setAttribute("src","b.gif" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */
      /* Termina nodo:763   */

      /* Empieza nodo:765 / Elemento padre: 760   */
      v.add(doc.createElement("td"));
      ((Element)v.get(765)).setAttribute("width","12" );
      ((Element)v.get(760)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(766)).setAttribute("src","b.gif" );
      ((Element)v.get(766)).setAttribute("width","12" );
      ((Element)v.get(766)).setAttribute("height","12" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:765   */
      /* Termina nodo:760   */
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:767 / Elemento padre: 1   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(767)).setAttribute("nombre","capaSinBoton" );
      ((Element)v.get(767)).setAttribute("alto","120" );
      ((Element)v.get(767)).setAttribute("ancho","100%" );
      ((Element)v.get(767)).setAttribute("colorf","" );
      ((Element)v.get(767)).setAttribute("borde","0" );
      ((Element)v.get(767)).setAttribute("imagenf","" );
      ((Element)v.get(767)).setAttribute("repeat","" );
      ((Element)v.get(767)).setAttribute("padding","" );
      ((Element)v.get(767)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(767)).setAttribute("contravsb","" );
      ((Element)v.get(767)).setAttribute("x","0" );
      ((Element)v.get(767)).setAttribute("y","966" );
      ((Element)v.get(767)).setAttribute("zindex","" );
      ((Element)v.get(1)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("table"));
      ((Element)v.get(768)).setAttribute("width","100%" );
      ((Element)v.get(768)).setAttribute("border","0" );
      ((Element)v.get(768)).setAttribute("cellspacing","0" );
      ((Element)v.get(768)).setAttribute("cellpadding","0" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(768)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("td"));
      ((Element)v.get(770)).setAttribute("width","12" );
      ((Element)v.get(770)).setAttribute("align","center" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(771)).setAttribute("src","b.gif" );
      ((Element)v.get(771)).setAttribute("width","12" );
      ((Element)v.get(771)).setAttribute("height","12" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */

      /* Empieza nodo:772 / Elemento padre: 769   */
      v.add(doc.createElement("td"));
      ((Element)v.get(772)).setAttribute("width","750" );
      ((Element)v.get(769)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(773)).setAttribute("src","b.gif" );
      ((Element)v.get(772)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:772   */

      /* Empieza nodo:774 / Elemento padre: 769   */
      v.add(doc.createElement("td"));
      ((Element)v.get(774)).setAttribute("width","12" );
      ((Element)v.get(769)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
   }

   private void getXML3060(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(775)).setAttribute("src","b.gif" );
      ((Element)v.get(775)).setAttribute("width","12" );
      ((Element)v.get(775)).setAttribute("height","1" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */
      /* Termina nodo:774   */
      /* Termina nodo:769   */

      /* Empieza nodo:776 / Elemento padre: 768   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(768)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("td"));
      ((Element)v.get(776)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(778)).setAttribute("src","b.gif" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */
      /* Termina nodo:777   */

      /* Empieza nodo:779 / Elemento padre: 776   */
      v.add(doc.createElement("td"));
      ((Element)v.get(776)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(779)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(781)).setAttribute("class","legend" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(782)).setAttribute("nombre","lblTitCritOtrosDatos2" );
      ((Element)v.get(782)).setAttribute("alto","13" );
      ((Element)v.get(782)).setAttribute("filas","1" );
      ((Element)v.get(782)).setAttribute("valor","" );
      ((Element)v.get(782)).setAttribute("cod","00284" );
      ((Element)v.get(782)).setAttribute("id","legend" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */
      /* Termina nodo:781   */

      /* Empieza nodo:783 / Elemento padre: 780   */
      v.add(doc.createElement("table"));
      ((Element)v.get(783)).setAttribute("width","100%" );
      ((Element)v.get(783)).setAttribute("border","0" );
      ((Element)v.get(783)).setAttribute("align","center" );
      ((Element)v.get(783)).setAttribute("cellspacing","0" );
      ((Element)v.get(783)).setAttribute("cellpadding","0" );
      ((Element)v.get(780)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("td"));
      ((Element)v.get(784)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("table"));
      ((Element)v.get(786)).setAttribute("width","714" );
      ((Element)v.get(786)).setAttribute("border","0" );
      ((Element)v.get(786)).setAttribute("align","left" );
      ((Element)v.get(786)).setAttribute("cellspacing","0" );
      ((Element)v.get(786)).setAttribute("cellpadding","0" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(786)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("td"));
      ((Element)v.get(788)).setAttribute("colspan","4" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(789)).setAttribute("src","b.gif" );
      ((Element)v.get(789)).setAttribute("width","8" );
      ((Element)v.get(789)).setAttribute("height","8" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */
      /* Termina nodo:788   */
      /* Termina nodo:787   */

      /* Empieza nodo:790 / Elemento padre: 786   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(786)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(790)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(792)).setAttribute("src","b.gif" );
      ((Element)v.get(792)).setAttribute("width","8" );
      ((Element)v.get(792)).setAttribute("height","8" );
      ((Element)v.get(791)).appendChild((Element)v.get(792));
      /* Termina nodo:792   */
      /* Termina nodo:791   */

      /* Empieza nodo:793 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(790)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(794)).setAttribute("nombre","lblEnviarMensaje2" );
      ((Element)v.get(794)).setAttribute("alto","13" );
      ((Element)v.get(794)).setAttribute("filas","1" );
      ((Element)v.get(794)).setAttribute("valor","" );
      ((Element)v.get(794)).setAttribute("id","datosTitle" );
      ((Element)v.get(794)).setAttribute("cod","1221" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(790)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(796)).setAttribute("src","b.gif" );
      ((Element)v.get(796)).setAttribute("width","25" );
      ((Element)v.get(796)).setAttribute("height","8" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:797 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(790)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(798)).setAttribute("nombre","lblCodMensaje2" );
      ((Element)v.get(798)).setAttribute("alto","13" );
      ((Element)v.get(798)).setAttribute("filas","1" );
      ((Element)v.get(798)).setAttribute("valor","" );
      ((Element)v.get(798)).setAttribute("id","datosTitle" );
      ((Element)v.get(798)).setAttribute("cod","821" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(797)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:799 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).setAttribute("width","100%" );
      ((Element)v.get(790)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(800)).setAttribute("src","b.gif" );
      ((Element)v.get(800)).setAttribute("width","8" );
      ((Element)v.get(800)).setAttribute("height","8" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */
      /* Termina nodo:799   */
      /* Termina nodo:790   */

      /* Empieza nodo:801 / Elemento padre: 786   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(786)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(801)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(803)).setAttribute("src","b.gif" );
      ((Element)v.get(803)).setAttribute("width","8" );
      ((Element)v.get(803)).setAttribute("height","8" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));
      /* Termina nodo:803   */
      /* Termina nodo:802   */

      /* Empieza nodo:804 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(804)).setAttribute("class","datosCampos" );
      ((Element)v.get(804)).setAttribute("valign","bottom" );
      ((Element)v.get(801)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(805)).setAttribute("nombre","rbEnviarMensaje2" );
      ((Element)v.get(805)).setAttribute("tipo","H" );
      ((Element)v.get(805)).setAttribute("id","datosCampos" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(806)).setAttribute("valor","S" );
      ((Element)v.get(806)).setAttribute("check","N" );
      ((Element)v.get(806)).setAttribute("onfocus","" );
      ((Element)v.get(806)).setAttribute("id","datosCampos" );
      ((Element)v.get(806)).setAttribute("cod","117" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));

      /* Elemento padre:806 / Elemento actual: 807   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(806)).appendChild((Text)v.get(807));

      /* Termina nodo Texto:807   */
      /* Termina nodo:806   */

      /* Empieza nodo:808 / Elemento padre: 805   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(808)).setAttribute("valor","N" );
      ((Element)v.get(808)).setAttribute("check","N" );
      ((Element)v.get(808)).setAttribute("onfocus","" );
      ((Element)v.get(808)).setAttribute("id","datosCampos" );
      ((Element)v.get(808)).setAttribute("cod","87" );
      ((Element)v.get(805)).appendChild((Element)v.get(808));

      /* Elemento padre:808 / Elemento actual: 809   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(808)).appendChild((Text)v.get(809));

      /* Termina nodo Texto:809   */
      /* Termina nodo:808   */
      /* Termina nodo:805   */
      /* Termina nodo:804   */

      /* Empieza nodo:810 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(801)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(811)).setAttribute("src","b.gif" );
      ((Element)v.get(811)).setAttribute("width","25" );
      ((Element)v.get(811)).setAttribute("height","8" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */
      /* Termina nodo:810   */

      /* Empieza nodo:812 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(812)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(801)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(813)).setAttribute("nombre","cbCodMensaje2" );
      ((Element)v.get(813)).setAttribute("id","datosCampos" );
      ((Element)v.get(813)).setAttribute("size","1" );
      ((Element)v.get(813)).setAttribute("multiple","N" );
      ((Element)v.get(813)).setAttribute("req","S" );
      ((Element)v.get(813)).setAttribute("valorinicial","" );
      ((Element)v.get(813)).setAttribute("textoinicial","" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));

      /* Empieza nodo:814 / Elemento padre: 813   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(813)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(816)).setAttribute("NOMBRE","cabecera" );
      ((Element)v.get(816)).setAttribute("TIPO","STRING" );
      ((Element)v.get(816)).setAttribute("VALOR","0" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */

      /* Empieza nodo:817 / Elemento padre: 815   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(817)).setAttribute("NOMBRE","contenido" );
      ((Element)v.get(817)).setAttribute("TIPO","STRING" );
      ((Element)v.get(817)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxx" );
      ((Element)v.get(815)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */
      /* Termina nodo:815   */
      /* Termina nodo:814   */
      /* Termina nodo:813   */
      /* Termina nodo:812   */

      /* Empieza nodo:818 / Elemento padre: 801   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).setAttribute("width","100%" );
      ((Element)v.get(801)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(819)).setAttribute("src","b.gif" );
      ((Element)v.get(819)).setAttribute("width","8" );
      ((Element)v.get(819)).setAttribute("height","8" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */
      /* Termina nodo:818   */
      /* Termina nodo:801   */

      /* Empieza nodo:820 / Elemento padre: 786   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(786)).appendChild((Element)v.get(820));

      /* Empieza nodo:821 / Elemento padre: 820   */
      v.add(doc.createElement("td"));
      ((Element)v.get(821)).setAttribute("colspan","4" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(820)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(822)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).setAttribute("width","8" );
      ((Element)v.get(822)).setAttribute("height","8" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */
      /* Termina nodo:820   */
      /* Termina nodo:786   */
      /* Termina nodo:785   */
      /* Termina nodo:784   */
      /* Termina nodo:783   */
      /* Termina nodo:780   */
      /* Termina nodo:779   */

      /* Empieza nodo:823 / Elemento padre: 776   */
      v.add(doc.createElement("td"));
      ((Element)v.get(776)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(824)).setAttribute("src","b.gif" );
      ((Element)v.get(824)).setAttribute("width","8" );
      ((Element)v.get(824)).setAttribute("height","12" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */
      /* Termina nodo:823   */
      /* Termina nodo:776   */

      /* Empieza nodo:825 / Elemento padre: 768   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(768)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
      ((Element)v.get(826)).setAttribute("width","12" );
      ((Element)v.get(826)).setAttribute("align","center" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(827)).setAttribute("src","b.gif" );
      ((Element)v.get(827)).setAttribute("width","12" );
      ((Element)v.get(827)).setAttribute("height","12" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */
      /* Termina nodo:826   */

      /* Empieza nodo:828 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
      ((Element)v.get(828)).setAttribute("width","750" );
      ((Element)v.get(825)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(829)).setAttribute("src","b.gif" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));
      /* Termina nodo:829   */
      /* Termina nodo:828   */

      /* Empieza nodo:830 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
      ((Element)v.get(830)).setAttribute("width","12" );
      ((Element)v.get(825)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(831)).setAttribute("src","b.gif" );
      ((Element)v.get(831)).setAttribute("width","12" );
      ((Element)v.get(831)).setAttribute("height","12" );
      ((Element)v.get(830)).appendChild((Element)v.get(831));
      /* Termina nodo:831   */
      /* Termina nodo:830   */
      /* Termina nodo:825   */
      /* Termina nodo:768   */
      /* Termina nodo:767   */
      /* Termina nodo:1   */


   }

}
