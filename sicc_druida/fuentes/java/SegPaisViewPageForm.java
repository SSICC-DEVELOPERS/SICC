
import org.w3c.dom.*;
import java.util.ArrayList;

public class SegPaisViewPageForm  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(0)).setAttribute("width","100%" );
      ((Element)v.get(0)).setAttribute("border","0" );
      ((Element)v.get(0)).setAttribute("cellspacing","0" );
      ((Element)v.get(0)).setAttribute("cellpadding","0" );
      ((Element)v.get(0)).setAttribute("align","left" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(2)).setAttribute("align","center" );
      ((Element)v.get(2)).setAttribute("width","12" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(3)).setAttribute("src","b.gif" );
      ((Element)v.get(3)).setAttribute("width","12" );
      ((Element)v.get(3)).setAttribute("height","12" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 1   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(4)).setAttribute("align","center" );
      ((Element)v.get(4)).setAttribute("width","750" );
      ((Element)v.get(1)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(5)).setAttribute("src","b.gif" );
      ((Element)v.get(5)).setAttribute("width","12" );
      ((Element)v.get(5)).setAttribute("height","12" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 1   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(6)).setAttribute("align","center" );
      ((Element)v.get(6)).setAttribute("width","12" );
      ((Element)v.get(1)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(7)).setAttribute("src","b.gif" );
      ((Element)v.get(7)).setAttribute("width","12" );
      ((Element)v.get(7)).setAttribute("height","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */
      /* Termina nodo:1   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(9)).setAttribute("align","center" );
      ((Element)v.get(9)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","b.gif" );
      ((Element)v.get(10)).setAttribute("width","12" );
      ((Element)v.get(10)).setAttribute("height","8" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(11)).setAttribute("width","100%" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(13)).setAttribute("class","legend" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(14)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(14)).setAttribute("alto","13" );
      ((Element)v.get(14)).setAttribute("filas","1" );
      ((Element)v.get(14)).setAttribute("id","legend" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(14)).setAttribute("cod","SegPaisView.legend.label" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("align","center" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("nowrap","true" );
      ((Element)v.get(17)).setAttribute("class","datosCampos" );
      ((Element)v.get(17)).setAttribute("colspan","3" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","8" );
      ((Element)v.get(18)).setAttribute("height","8" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(19)).setAttribute("nombre","formTr0" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(20)).setAttribute("width","8" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","8" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(23)).setAttribute("align","left" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(24)).setAttribute("align","left" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(25)).setAttribute("nombre","idTdId" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(26)).setAttribute("width","100%" );
      ((Element)v.get(26)).setAttribute("border","0" );
      ((Element)v.get(26)).setAttribute("cellspacing","0" );
      ((Element)v.get(26)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).setAttribute("align","left" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(28)).setAttribute("valign","top" );
      ((Element)v.get(28)).setAttribute("height","13" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblId" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("id","datosTitle" );
      ((Element)v.get(29)).setAttribute("cod","SegPaisView.id.label" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:30 / Elemento padre: 26   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(30)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(26)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(31)).setAttribute("align","left" );
      ((Element)v.get(31)).setAttribute("nowrap","true" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(32)).setAttribute("nombre","id" );
      ((Element)v.get(32)).setAttribute("id","datosCampos" );
      ((Element)v.get(32)).setAttribute("trim","S" );
      ((Element)v.get(32)).setAttribute("max","12" );
      ((Element)v.get(32)).setAttribute("onchange","" );
      ((Element)v.get(32)).setAttribute("req","N" );
      ((Element)v.get(32)).setAttribute("size","12" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(32)).setAttribute("validacion","" );
      ((Element)v.get(32)).setAttribute("disabled","" );
      ((Element)v.get(32)).setAttribute("onblur","" );
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',1, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 1, false)" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:33 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(33)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(33)).setAttribute("nowrap","true" );
      ((Element)v.get(33)).setAttribute("class","datosCampos" );
      ((Element)v.get(24)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","25" );
      ((Element)v.get(34)).setAttribute("height","8" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(24)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:19   */

      /* Empieza nodo:37 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(37)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(15)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(44)).setAttribute("nombre","formTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).setAttribute("align","left" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(49)).setAttribute("align","left" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("nombre","codPaisTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).setAttribute("align","left" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("valign","top" );
      ((Element)v.get(53)).setAttribute("height","13" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblCodPais" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","SegPaisView.codPais.label" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(55)).setAttribute("nombre","codPaisWidgetTrId" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("nowrap","true" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(57)).setAttribute("nombre","codPais" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("trim","S" );
      ((Element)v.get(57)).setAttribute("max","3" );
      ((Element)v.get(57)).setAttribute("onchange","" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("size","3" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("validacion","" );
      ((Element)v.get(57)).setAttribute("disabled","" );
      ((Element)v.get(57)).setAttribute("onblur","" );
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',2, true)" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 2, false)" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:58 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("nombre","codPaisGapTdId" );
      ((Element)v.get(58)).setAttribute("nowrap","true" );
      ((Element)v.get(58)).setAttribute("class","datosCampos" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(49)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).setAttribute("nombre","moneOidMoneTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("cellpadding","0" );
      ((Element)v.get(61)).setAttribute("align","left" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(63)).setAttribute("valign","top" );
      ((Element)v.get(63)).setAttribute("height","13" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblmoneOidMone" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("ancho","150" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("cod","SegPaisView.moneOidMone.label" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 61   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(65)).setAttribute("nombre","moneOidMoneWidgetTrId" );
      ((Element)v.get(61)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(66)).setAttribute("align","left" );
      ((Element)v.get(66)).setAttribute("nowrap","true" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(67)).setAttribute("nombre","moneOidMone" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("multiple","N" );
      ((Element)v.get(67)).setAttribute("req","N" );
      ((Element)v.get(67)).setAttribute("size","1" );
      ((Element)v.get(67)).setAttribute("disabled","" );
      ((Element)v.get(67)).setAttribute("validacion","" );
      ((Element)v.get(67)).setAttribute("onchange","" );
      ((Element)v.get(67)).setAttribute("onfocus","" );
      ((Element)v.get(67)).setAttribute("valorinicial","" );
      ((Element)v.get(67)).setAttribute("textoinicial","" );
      ((Element)v.get(67)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',3, true);" );
      ((Element)v.get(67)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',3, false);" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:69 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(69)).setAttribute("nombre","moneOidMoneGapTdId" );
      ((Element)v.get(69)).setAttribute("nowrap","true" );
      ((Element)v.get(69)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(71)).setAttribute("nombre","moneOidMoneAltTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).setAttribute("align","left" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(74)).setAttribute("valign","top" );
      ((Element)v.get(74)).setAttribute("height","13" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblmoneOidMoneAlt" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("ancho","150" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("cod","SegPaisView.moneOidMoneAlt.label" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 72   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(76)).setAttribute("nombre","moneOidMoneAltWidgetTrId" );
      ((Element)v.get(72)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(77)).setAttribute("align","left" );
      ((Element)v.get(77)).setAttribute("nowrap","true" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","moneOidMoneAlt" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("req","N" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("disabled","" );
      ((Element)v.get(78)).setAttribute("validacion","" );
      ((Element)v.get(78)).setAttribute("onchange","" );
      ((Element)v.get(78)).setAttribute("onfocus","" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',4, true);" );
      ((Element)v.get(78)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',4, false);" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:80 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(80)).setAttribute("nombre","moneOidMoneAltGapTdId" );
      ((Element)v.get(80)).setAttribute("nowrap","true" );
      ((Element)v.get(80)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(82)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(83)).setAttribute("border","0" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("cellpadding","0" );
      ((Element)v.get(83)).setAttribute("align","left" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(85)).setAttribute("valign","top" );
      ((Element)v.get(85)).setAttribute("height","13" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","SegPaisView.Descripcion.label" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(87)).setAttribute("colspan","2" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:84   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(88)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(89)).setAttribute("align","left" );
      ((Element)v.get(89)).setAttribute("nowrap","true" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(90)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("trim","S" );
      ((Element)v.get(90)).setAttribute("max","30" );
      ((Element)v.get(90)).setAttribute("onchange","" );
      ((Element)v.get(90)).setAttribute("req","N" );
      ((Element)v.get(90)).setAttribute("size","30" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("validacion","" );
      ((Element)v.get(90)).setAttribute("disabled","" );
      ((Element)v.get(90)).setAttribute("onblur","" );
      ((Element)v.get(90)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',5, true)" );
      ((Element)v.get(90)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 5, false)" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(93)).setAttribute("valign","bottom" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("A"));
      ((Element)v.get(94)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(94)).setAttribute("href","javascript:openLocalizationDialog('segPaisViewFrm', 'Descripcion', 1);" );
      ((Element)v.get(94)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"segPaisViewFrm\",5, true)', 'ejecutarAccionFoco(\"segPaisViewFrm\",5, false)')" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(95)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(95)).setAttribute("border","0" );
      ((Element)v.get(95)).setAttribute("width","21" );
      ((Element)v.get(95)).setAttribute("height","15" );
      ((Element)v.get(95)).setAttribute("class","main" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:88   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:96 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(96)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(96)).setAttribute("nowrap","true" );
      ((Element)v.get(96)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */

      /* Empieza nodo:100 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */

      /* Empieza nodo:107 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).setAttribute("nombre","formTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).setAttribute("align","left" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("nombre","indInteGisTdId" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(114)).setAttribute("align","left" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("valign","top" );
      ((Element)v.get(116)).setAttribute("height","13" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblIndInteGis" );
      ((Element)v.get(117)).setAttribute("ancho","150" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("cod","SegPaisView.indInteGis.label" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(118)).setAttribute("nombre","indInteGisWidgetTrId" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("nowrap","true" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(120)).setAttribute("nombre","indInteGis" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("multiple","N" );
      ((Element)v.get(120)).setAttribute("req","N" );
      ((Element)v.get(120)).setAttribute("size","1" );
      ((Element)v.get(120)).setAttribute("validacion","" );
      ((Element)v.get(120)).setAttribute("onchange","" );
      ((Element)v.get(120)).setAttribute("onfocus","" );
      ((Element)v.get(120)).setAttribute("valorinicial","" );
      ((Element)v.get(120)).setAttribute("textoinicial","" );
      ((Element)v.get(120)).setAttribute("disabled","" );
      ((Element)v.get(120)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',6, true)" );
      ((Element)v.get(120)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',6, false)" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(122)).setAttribute("ID","I" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(123)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(123)).setAttribute("TIPO","STRING" );
      ((Element)v.get(123)).setAttribute("VALOR","I" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 122   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(124)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(124)).setAttribute("TIPO","STRING" );
      ((Element)v.get(124)).setAttribute("VALOR","GIS" );
      ((Element)v.get(122)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:122   */

      /* Empieza nodo:125 / Elemento padre: 121   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(125)).setAttribute("ID","G" );
      ((Element)v.get(121)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(126)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(126)).setAttribute("TIPO","STRING" );
      ((Element)v.get(126)).setAttribute("VALOR","G" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 125   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(127)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(127)).setAttribute("TIPO","STRING" );
      ((Element)v.get(127)).setAttribute("VALOR","Georreferenciador" );
      ((Element)v.get(125)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:125   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:128 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("nombre","indInteGisGapTdId" );
      ((Element)v.get(128)).setAttribute("nowrap","true" );
      ((Element)v.get(128)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("nombre","valIdenTdId" );
      ((Element)v.get(112)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).setAttribute("align","left" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(133)).setAttribute("valign","top" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(133)).setAttribute("height","13" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblValIden" );
      ((Element)v.get(134)).setAttribute("ancho","150" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","SegPaisView.valIden.label" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:135 / Elemento padre: 131   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(135)).setAttribute("nombre","valIdenWidgetTrId" );
      ((Element)v.get(131)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).setAttribute("align","left" );
      ((Element)v.get(136)).setAttribute("nowrap","true" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(137)).setAttribute("nombre","valIden" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
      ((Element)v.get(137)).setAttribute("multiple","N" );
      ((Element)v.get(137)).setAttribute("req","N" );
      ((Element)v.get(137)).setAttribute("size","1" );
      ((Element)v.get(137)).setAttribute("validacion","" );
      ((Element)v.get(137)).setAttribute("onchange","" );
      ((Element)v.get(137)).setAttribute("onfocus","" );
      ((Element)v.get(137)).setAttribute("valorinicial","" );
      ((Element)v.get(137)).setAttribute("textoinicial","" );
      ((Element)v.get(137)).setAttribute("disabled","" );
      ((Element)v.get(137)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',7, true)" );
      ((Element)v.get(137)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',7, false)" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(139)).setAttribute("ID","B" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(140)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(140)).setAttribute("TIPO","STRING" );
      ((Element)v.get(140)).setAttribute("VALOR","B" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(141)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(141)).setAttribute("TIPO","STRING" );
      ((Element)v.get(141)).setAttribute("VALOR","Boleta" );
      ((Element)v.get(139)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 138   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(142)).setAttribute("ID","F" );
      ((Element)v.get(138)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(143)).setAttribute("TIPO","STRING" );
      ((Element)v.get(143)).setAttribute("VALOR","F" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 142   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(144)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(144)).setAttribute("TIPO","STRING" );
      ((Element)v.get(144)).setAttribute("VALOR","Factura" );
      ((Element)v.get(142)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:142   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:145 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("nombre","valIdenGapTdId" );
      ((Element)v.get(145)).setAttribute("nowrap","true" );
      ((Element)v.get(145)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("nombre","indSaldUnicTdId" );
      ((Element)v.get(112)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(148)).setAttribute("border","0" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("cellpadding","0" );
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("valign","top" );
      ((Element)v.get(150)).setAttribute("height","13" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(151)).setAttribute("nombre","lblIndSaldUnic" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("filas","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(151)).setAttribute("id","datosTitle" );
      ((Element)v.get(151)).setAttribute("cod","SegPaisView.indSaldUnic.label" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:152 / Elemento padre: 148   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(152)).setAttribute("nombre","indSaldUnicWidgetTrId" );
      ((Element)v.get(148)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(153)).setAttribute("nowrap","true" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(154)).setAttribute("nombre","indSaldUnic" );
      ((Element)v.get(154)).setAttribute("tipo","H" );
      ((Element)v.get(154)).setAttribute("req","N" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("disabled","" );
      ((Element)v.get(154)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',8, true)" );
      ((Element)v.get(154)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',8, false)" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(155)).setAttribute("valor","1" );
      ((Element)v.get(155)).setAttribute("cod","SegPaisView.indSaldUnic.1.label" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Elemento padre:155 / Elemento actual: 156   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(155)).appendChild((Text)v.get(156));

      /* Termina nodo Texto:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).setAttribute("valor","0" );
      ((Element)v.get(157)).setAttribute("cod","SegPaisView.indSaldUnic.0.label" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:159 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("nombre","indSaldUnicGapTdId" );
      ((Element)v.get(159)).setAttribute("nowrap","true" );
      ((Element)v.get(159)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("nombre","valProgEjecTdId" );
      ((Element)v.get(112)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(162)).setAttribute("border","0" );
      ((Element)v.get(162)).setAttribute("cellspacing","0" );
      ((Element)v.get(162)).setAttribute("cellpadding","0" );
      ((Element)v.get(162)).setAttribute("align","left" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("valign","top" );
      ((Element)v.get(164)).setAttribute("height","13" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblValProgEjec" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","SegPaisView.valProgEjec.label" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:166 / Elemento padre: 162   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(166)).setAttribute("nombre","valProgEjecWidgetTrId" );
      ((Element)v.get(162)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("align","left" );
      ((Element)v.get(167)).setAttribute("nowrap","true" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(168)).setAttribute("nombre","valProgEjec" );
      ((Element)v.get(168)).setAttribute("id","datosCampos" );
      ((Element)v.get(168)).setAttribute("trim","S" );
      ((Element)v.get(168)).setAttribute("max","10" );
      ((Element)v.get(168)).setAttribute("onchange","" );
      ((Element)v.get(168)).setAttribute("req","N" );
      ((Element)v.get(168)).setAttribute("size","10" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("validacion","" );
      ((Element)v.get(168)).setAttribute("disabled","" );
      ((Element)v.get(168)).setAttribute("onblur","" );
      ((Element)v.get(168)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',9, true)" );
      ((Element)v.get(168)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 9, false)" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:169 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(169)).setAttribute("nombre","valProgEjecGapTdId" );
      ((Element)v.get(169)).setAttribute("nowrap","true" );
      ((Element)v.get(169)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("nombre","valPorcAlarTdId" );
      ((Element)v.get(112)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(172)).setAttribute("align","left" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("valign","top" );
      ((Element)v.get(174)).setAttribute("height","13" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblValPorcAlar" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","SegPaisView.valPorcAlar.label" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 172   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(176)).setAttribute("nombre","valPorcAlarWidgetTrId" );
      ((Element)v.get(172)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("align","left" );
      ((Element)v.get(177)).setAttribute("nowrap","true" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(178)).setAttribute("nombre","valPorcAlar" );
      ((Element)v.get(178)).setAttribute("id","datosCampos" );
      ((Element)v.get(178)).setAttribute("trim","S" );
      ((Element)v.get(178)).setAttribute("max","5" );
      ((Element)v.get(178)).setAttribute("onchange","" );
      ((Element)v.get(178)).setAttribute("req","N" );
      ((Element)v.get(178)).setAttribute("size","5" );
      ((Element)v.get(178)).setAttribute("valor","" );
      ((Element)v.get(178)).setAttribute("validacion","" );
      ((Element)v.get(178)).setAttribute("disabled","" );
      ((Element)v.get(178)).setAttribute("onblur","" );
      ((Element)v.get(178)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',10, true)" );
      ((Element)v.get(178)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 10, false)" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:179 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("nombre","valPorcAlarGapTdId" );
      ((Element)v.get(179)).setAttribute("nowrap","true" );
      ((Element)v.get(179)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:107   */

      /* Empieza nodo:183 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("align","center" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","12" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","12" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:183   */

      /* Empieza nodo:190 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("align","center" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","12" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(194)).setAttribute("border","0" );
      ((Element)v.get(194)).setAttribute("cellspacing","0" );
      ((Element)v.get(194)).setAttribute("cellpadding","0" );
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(195)).setAttribute("align","left" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).setAttribute("nombre","indCompAutoTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(197)).setAttribute("border","0" );
      ((Element)v.get(197)).setAttribute("cellspacing","0" );
      ((Element)v.get(197)).setAttribute("cellpadding","0" );
      ((Element)v.get(197)).setAttribute("align","left" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).setAttribute("valign","top" );
      ((Element)v.get(199)).setAttribute("height","13" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblIndCompAuto" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("id","datosTitle" );
      ((Element)v.get(200)).setAttribute("cod","SegPaisView.indCompAuto.label" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 197   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(201)).setAttribute("nombre","indCompAutoWidgetTrId" );
      ((Element)v.get(197)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("align","left" );
      ((Element)v.get(202)).setAttribute("nowrap","true" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(203)).setAttribute("nombre","indCompAuto" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("trim","S" );
      ((Element)v.get(203)).setAttribute("max","1" );
      ((Element)v.get(203)).setAttribute("onchange","" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("size","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("validacion","" );
      ((Element)v.get(203)).setAttribute("disabled","" );
      ((Element)v.get(203)).setAttribute("onblur","" );
      ((Element)v.get(203)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',11, true)" );
      ((Element)v.get(203)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 11, false)" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("nombre","indCompAutoGapTdId" );
      ((Element)v.get(204)).setAttribute("nowrap","true" );
      ((Element)v.get(204)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","25" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("nombre","numDiasMoraTdId" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(195)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(207)).setAttribute("border","0" );
      ((Element)v.get(207)).setAttribute("cellspacing","0" );
      ((Element)v.get(207)).setAttribute("cellpadding","0" );
      ((Element)v.get(207)).setAttribute("align","left" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("valign","top" );
      ((Element)v.get(209)).setAttribute("height","13" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lblNumDiasMora" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","SegPaisView.numDiasMora.label" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).setAttribute("nombre","numDiasMoraWidgetTrId" );
      ((Element)v.get(207)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("nowrap","true" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(213)).setAttribute("nombre","numDiasMora" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("trim","S" );
      ((Element)v.get(213)).setAttribute("max","3" );
      ((Element)v.get(213)).setAttribute("onchange","" );
      ((Element)v.get(213)).setAttribute("req","N" );
      ((Element)v.get(213)).setAttribute("size","3" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("validacion","" );
      ((Element)v.get(213)).setAttribute("disabled","" );
      ((Element)v.get(213)).setAttribute("onblur","" );
      ((Element)v.get(213)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',12, true)" );
      ((Element)v.get(213)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 12, false)" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:214 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(214)).setAttribute("nombre","numDiasMoraGapTdId" );
      ((Element)v.get(214)).setAttribute("nowrap","true" );
      ((Element)v.get(214)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("nombre","indTratAcumDescTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).setAttribute("align","left" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("valign","top" );
      ((Element)v.get(219)).setAttribute("height","13" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblIndTratAcumDesc" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","SegPaisView.indTratAcumDesc.label" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:221 / Elemento padre: 217   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(221)).setAttribute("nombre","indTratAcumDescWidgetTrId" );
      ((Element)v.get(217)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("align","left" );
      ((Element)v.get(222)).setAttribute("nowrap","true" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(223)).setAttribute("nombre","indTratAcumDesc" );
      ((Element)v.get(223)).setAttribute("tipo","H" );
      ((Element)v.get(223)).setAttribute("req","N" );
      ((Element)v.get(223)).setAttribute("id","datosCampos" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("disabled","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(223)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',13, true)" );
      ((Element)v.get(223)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',13, false)" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(224)).setAttribute("id","datosCampos" );
      ((Element)v.get(224)).setAttribute("valor","1" );
      ((Element)v.get(224)).setAttribute("cod","SegPaisView.indTratAcumDesc.1.label" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Elemento padre:224 / Elemento actual: 225   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(224)).appendChild((Text)v.get(225));

      /* Termina nodo Texto:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(226)).setAttribute("id","datosCampos" );
      ((Element)v.get(226)).setAttribute("valor","0" );
      ((Element)v.get(226)).setAttribute("cod","SegPaisView.indTratAcumDesc.0.label" );
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Elemento padre:226 / Elemento actual: 227   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(226)).appendChild((Text)v.get(227));

      /* Termina nodo Texto:227   */
      /* Termina nodo:226   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:228 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("nombre","indTratAcumDescGapTdId" );
      ((Element)v.get(228)).setAttribute("nowrap","true" );
      ((Element)v.get(228)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","25" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("nombre","valTiemRezoTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(231)).setAttribute("border","0" );
      ((Element)v.get(231)).setAttribute("cellspacing","0" );
      ((Element)v.get(231)).setAttribute("cellpadding","0" );
      ((Element)v.get(231)).setAttribute("align","left" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("valign","top" );
      ((Element)v.get(233)).setAttribute("height","13" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(234)).setAttribute("nombre","lblValTiemRezo" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("id","datosTitle" );
      ((Element)v.get(234)).setAttribute("cod","SegPaisView.valTiemRezo.label" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:235 / Elemento padre: 231   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(235)).setAttribute("nombre","valTiemRezoWidgetTrId" );
      ((Element)v.get(231)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("align","left" );
      ((Element)v.get(236)).setAttribute("nowrap","true" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(237)).setAttribute("nombre","valTiemRezo" );
      ((Element)v.get(237)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).setAttribute("trim","S" );
      ((Element)v.get(237)).setAttribute("max","2" );
      ((Element)v.get(237)).setAttribute("onchange","" );
      ((Element)v.get(237)).setAttribute("req","N" );
      ((Element)v.get(237)).setAttribute("size","2" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(237)).setAttribute("validacion","" );
      ((Element)v.get(237)).setAttribute("disabled","" );
      ((Element)v.get(237)).setAttribute("onblur","" );
      ((Element)v.get(237)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',14, true)" );
      ((Element)v.get(237)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 14, false)" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:238 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("nombre","valTiemRezoGapTdId" );
      ((Element)v.get(238)).setAttribute("nowrap","true" );
      ((Element)v.get(238)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","25" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(240)).setAttribute("nombre","valConfSecuCccTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(241)).setAttribute("border","0" );
      ((Element)v.get(241)).setAttribute("cellspacing","0" );
      ((Element)v.get(241)).setAttribute("cellpadding","0" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("valign","top" );
      ((Element)v.get(243)).setAttribute("height","13" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(244)).setAttribute("nombre","lblValConfSecuCcc" );
      ((Element)v.get(244)).setAttribute("ancho","150" );
      ((Element)v.get(244)).setAttribute("alto","13" );
      ((Element)v.get(244)).setAttribute("filas","1" );
      ((Element)v.get(244)).setAttribute("id","datosTitle" );
      ((Element)v.get(244)).setAttribute("cod","SegPaisView.valConfSecuCcc.label" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 241   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(245)).setAttribute("nombre","valConfSecuCccWidgetTrId" );
      ((Element)v.get(241)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("align","left" );
      ((Element)v.get(246)).setAttribute("nowrap","true" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(247)).setAttribute("nombre","valConfSecuCcc" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("multiple","N" );
      ((Element)v.get(247)).setAttribute("req","N" );
      ((Element)v.get(247)).setAttribute("size","1" );
      ((Element)v.get(247)).setAttribute("validacion","" );
      ((Element)v.get(247)).setAttribute("onchange","" );
      ((Element)v.get(247)).setAttribute("onfocus","" );
      ((Element)v.get(247)).setAttribute("valorinicial","" );
      ((Element)v.get(247)).setAttribute("textoinicial","" );
      ((Element)v.get(247)).setAttribute("disabled","" );
      ((Element)v.get(247)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',15, true)" );
      ((Element)v.get(247)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',15, false)" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(249)).setAttribute("ID","U" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(250)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(250)).setAttribute("TIPO","STRING" );
      ((Element)v.get(250)).setAttribute("VALOR","U" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 249   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(251)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(251)).setAttribute("TIPO","STRING" );
      ((Element)v.get(251)).setAttribute("VALOR","�nico" );
      ((Element)v.get(249)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:249   */

      /* Empieza nodo:252 / Elemento padre: 248   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(252)).setAttribute("ID","A" );
      ((Element)v.get(248)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(253)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(253)).setAttribute("TIPO","STRING" );
      ((Element)v.get(253)).setAttribute("VALOR","A" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 252   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(254)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(254)).setAttribute("TIPO","STRING" );
      ((Element)v.get(254)).setAttribute("VALOR","A�o" );
      ((Element)v.get(252)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:252   */

      /* Empieza nodo:255 / Elemento padre: 248   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(255)).setAttribute("ID","M" );
      ((Element)v.get(248)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(256)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(256)).setAttribute("TIPO","STRING" );
      ((Element)v.get(256)).setAttribute("VALOR","M" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 255   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(257)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(257)).setAttribute("TIPO","STRING" );
      ((Element)v.get(257)).setAttribute("VALOR","Mes y a�o" );
      ((Element)v.get(255)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:255   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:258 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("nombre","valConfSecuCccGapTdId" );
      ((Element)v.get(258)).setAttribute("nowrap","true" );
      ((Element)v.get(258)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:190   */

      /* Empieza nodo:262 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(262)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("align","center" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","12" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("align","center" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:262   */

      /* Empieza nodo:269 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(269)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(269)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(273)).setAttribute("border","0" );
      ((Element)v.get(273)).setAttribute("cellspacing","0" );
      ((Element)v.get(273)).setAttribute("cellpadding","0" );
      ((Element)v.get(273)).setAttribute("align","left" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(274)).setAttribute("align","left" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("nombre","numDiasFactTdId" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(276)).setAttribute("width","100%" );
      ((Element)v.get(276)).setAttribute("border","0" );
      ((Element)v.get(276)).setAttribute("cellspacing","0" );
      ((Element)v.get(276)).setAttribute("cellpadding","0" );
      ((Element)v.get(276)).setAttribute("align","left" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("valign","top" );
      ((Element)v.get(278)).setAttribute("height","13" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lblNumDiasFact" );
      ((Element)v.get(279)).setAttribute("alto","13" );
      ((Element)v.get(279)).setAttribute("filas","1" );
      ((Element)v.get(279)).setAttribute("id","datosTitle" );
      ((Element)v.get(279)).setAttribute("cod","SegPaisView.numDiasFact.label" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:280 / Elemento padre: 276   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(280)).setAttribute("nombre","numDiasFactWidgetTrId" );
      ((Element)v.get(276)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).setAttribute("align","left" );
      ((Element)v.get(281)).setAttribute("nowrap","true" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(282)).setAttribute("nombre","numDiasFact" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(282)).setAttribute("id","datosCampos" );
      ((Element)v.get(282)).setAttribute("trim","S" );
      ((Element)v.get(282)).setAttribute("max","2" );
      ((Element)v.get(282)).setAttribute("onchange","" );
      ((Element)v.get(282)).setAttribute("req","N" );
      ((Element)v.get(282)).setAttribute("size","2" );
      ((Element)v.get(282)).setAttribute("valor","" );
      ((Element)v.get(282)).setAttribute("validacion","" );
      ((Element)v.get(282)).setAttribute("disabled","" );
      ((Element)v.get(282)).setAttribute("onblur","" );
      ((Element)v.get(282)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',16, true)" );
      ((Element)v.get(282)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 16, false)" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:283 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("nombre","numDiasFactGapTdId" );
      ((Element)v.get(283)).setAttribute("nowrap","true" );
      ((Element)v.get(283)).setAttribute("class","datosCampos" );
      ((Element)v.get(274)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("nombre","numLimiDifePagoTdId" );
      ((Element)v.get(274)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(286)).setAttribute("width","100%" );
      ((Element)v.get(286)).setAttribute("border","0" );
      ((Element)v.get(286)).setAttribute("cellspacing","0" );
      ((Element)v.get(286)).setAttribute("cellpadding","0" );
      ((Element)v.get(286)).setAttribute("align","left" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("valign","top" );
      ((Element)v.get(288)).setAttribute("height","13" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(289)).setAttribute("nombre","lblNumLimiDifePago" );
      ((Element)v.get(289)).setAttribute("alto","13" );
      ((Element)v.get(289)).setAttribute("filas","1" );
      ((Element)v.get(289)).setAttribute("id","datosTitle" );
      ((Element)v.get(289)).setAttribute("cod","SegPaisView.numLimiDifePago.label" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:290 / Elemento padre: 286   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(290)).setAttribute("nombre","numLimiDifePagoWidgetTrId" );
      ((Element)v.get(286)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(291)).setAttribute("nowrap","true" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(292)).setAttribute("nombre","numLimiDifePago" );
      ((Element)v.get(292)).setAttribute("id","datosCampos" );
      ((Element)v.get(292)).setAttribute("trim","S" );
      ((Element)v.get(292)).setAttribute("max","12" );
      ((Element)v.get(292)).setAttribute("onchange","" );
      ((Element)v.get(292)).setAttribute("req","N" );
      ((Element)v.get(292)).setAttribute("size","12" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("validacion","" );
      ((Element)v.get(292)).setAttribute("disabled","" );
      ((Element)v.get(292)).setAttribute("onblur","" );
      ((Element)v.get(292)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',17, true)" );
      ((Element)v.get(292)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 17, false)" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:293 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).setAttribute("nombre","numLimiDifePagoGapTdId" );
      ((Element)v.get(293)).setAttribute("nowrap","true" );
      ((Element)v.get(293)).setAttribute("class","datosCampos" );
      ((Element)v.get(274)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","25" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("nombre","indEmisVencTdId" );
      ((Element)v.get(274)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(296)).setAttribute("width","100%" );
      ((Element)v.get(296)).setAttribute("border","0" );
      ((Element)v.get(296)).setAttribute("cellspacing","0" );
      ((Element)v.get(296)).setAttribute("cellpadding","0" );
      ((Element)v.get(296)).setAttribute("align","left" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("valign","top" );
      ((Element)v.get(298)).setAttribute("height","13" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lblIndEmisVenc" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","SegPaisView.indEmisVenc.label" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 296   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","indEmisVencWidgetTrId" );
      ((Element)v.get(296)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","left" );
      ((Element)v.get(301)).setAttribute("nowrap","true" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(302)).setAttribute("nombre","indEmisVenc" );
      ((Element)v.get(302)).setAttribute("tipo","H" );
      ((Element)v.get(302)).setAttribute("req","N" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(302)).setAttribute("disabled","" );
      ((Element)v.get(302)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',18, true)" );
      ((Element)v.get(302)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',18, false)" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(303)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).setAttribute("valor","1" );
      ((Element)v.get(303)).setAttribute("cod","SegPaisView.indEmisVenc.1.label" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Elemento padre:303 / Elemento actual: 304   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(303)).appendChild((Text)v.get(304));

      /* Termina nodo Texto:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 302   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(305)).setAttribute("id","datosCampos" );
      ((Element)v.get(305)).setAttribute("valor","0" );
      ((Element)v.get(305)).setAttribute("cod","SegPaisView.indEmisVenc.0.label" );
      ((Element)v.get(302)).appendChild((Element)v.get(305));

      /* Elemento padre:305 / Elemento actual: 306   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(305)).appendChild((Text)v.get(306));

      /* Termina nodo Texto:306   */
      /* Termina nodo:305   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:307 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("nombre","indEmisVencGapTdId" );
      ((Element)v.get(307)).setAttribute("nowrap","true" );
      ((Element)v.get(307)).setAttribute("class","datosCampos" );
      ((Element)v.get(274)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","25" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("nombre","valMaxiDifeAnlsCombTdId" );
      ((Element)v.get(274)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(310)).setAttribute("border","0" );
      ((Element)v.get(310)).setAttribute("cellspacing","0" );
      ((Element)v.get(310)).setAttribute("cellpadding","0" );
      ((Element)v.get(310)).setAttribute("align","left" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("valign","top" );
      ((Element)v.get(312)).setAttribute("height","13" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lblValMaxiDifeAnlsComb" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("id","datosTitle" );
      ((Element)v.get(313)).setAttribute("cod","SegPaisView.valMaxiDifeAnlsComb.label" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:314 / Elemento padre: 310   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(314)).setAttribute("nombre","valMaxiDifeAnlsCombWidgetTrId" );
      ((Element)v.get(310)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("align","left" );
      ((Element)v.get(315)).setAttribute("nowrap","true" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(316)).setAttribute("nombre","valMaxiDifeAnlsComb" );
      ((Element)v.get(316)).setAttribute("id","datosCampos" );
      ((Element)v.get(316)).setAttribute("trim","S" );
      ((Element)v.get(316)).setAttribute("max","12" );
      ((Element)v.get(316)).setAttribute("onchange","" );
      ((Element)v.get(316)).setAttribute("req","N" );
      ((Element)v.get(316)).setAttribute("size","12" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(316)).setAttribute("validacion","" );
      ((Element)v.get(316)).setAttribute("disabled","" );
      ((Element)v.get(316)).setAttribute("onblur","" );
      ((Element)v.get(316)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',19, true)" );
      ((Element)v.get(316)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 19, false)" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:317 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("nombre","valMaxiDifeAnlsCombGapTdId" );
      ((Element)v.get(317)).setAttribute("nowrap","true" );
      ((Element)v.get(317)).setAttribute("class","datosCampos" );
      ((Element)v.get(274)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","25" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(274)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:269   */

      /* Empieza nodo:321 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(321)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("align","center" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","12" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).setAttribute("align","center" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:321   */

      /* Empieza nodo:328 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("align","center" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","12" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(332)).setAttribute("border","0" );
      ((Element)v.get(332)).setAttribute("cellspacing","0" );
      ((Element)v.get(332)).setAttribute("cellpadding","0" );
      ((Element)v.get(332)).setAttribute("align","left" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(333)).setAttribute("align","left" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).setAttribute("nombre","numPosiNumeClieTdId" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(335)).setAttribute("border","0" );
      ((Element)v.get(335)).setAttribute("cellspacing","0" );
      ((Element)v.get(335)).setAttribute("cellpadding","0" );
      ((Element)v.get(335)).setAttribute("align","left" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).setAttribute("valign","top" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(337)).setAttribute("height","13" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lblNumPosiNumeClie" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("id","datosTitle" );
      ((Element)v.get(338)).setAttribute("cod","SegPaisView.numPosiNumeClie.label" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:339 / Elemento padre: 335   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(339)).setAttribute("nombre","numPosiNumeClieWidgetTrId" );
      ((Element)v.get(335)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).setAttribute("align","left" );
      ((Element)v.get(340)).setAttribute("nowrap","true" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(341)).setAttribute("nombre","numPosiNumeClie" );
      ((Element)v.get(341)).setAttribute("id","datosCampos" );
      ((Element)v.get(341)).setAttribute("trim","S" );
      ((Element)v.get(341)).setAttribute("max","2" );
      ((Element)v.get(341)).setAttribute("onchange","" );
      ((Element)v.get(341)).setAttribute("req","N" );
      ((Element)v.get(341)).setAttribute("size","2" );
      ((Element)v.get(341)).setAttribute("valor","" );
      ((Element)v.get(341)).setAttribute("validacion","" );
      ((Element)v.get(341)).setAttribute("disabled","" );
      ((Element)v.get(341)).setAttribute("onblur","" );
      ((Element)v.get(341)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',20, true)" );
      ((Element)v.get(341)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 20, false)" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:342 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("nombre","numPosiNumeClieGapTdId" );
      ((Element)v.get(342)).setAttribute("nowrap","true" );
      ((Element)v.get(342)).setAttribute("class","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","25" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(344)).setAttribute("nombre","valFormFechTdId" );
      ((Element)v.get(333)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(345)).setAttribute("width","100%" );
      ((Element)v.get(345)).setAttribute("border","0" );
      ((Element)v.get(345)).setAttribute("cellspacing","0" );
      ((Element)v.get(345)).setAttribute("cellpadding","0" );
      ((Element)v.get(345)).setAttribute("align","left" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("valign","top" );
      ((Element)v.get(347)).setAttribute("height","13" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(348)).setAttribute("nombre","lblValFormFech" );
      ((Element)v.get(348)).setAttribute("ancho","150" );
      ((Element)v.get(348)).setAttribute("alto","13" );
      ((Element)v.get(348)).setAttribute("filas","1" );
      ((Element)v.get(348)).setAttribute("id","datosTitle" );
      ((Element)v.get(348)).setAttribute("cod","SegPaisView.valFormFech.label" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:349 / Elemento padre: 345   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(349)).setAttribute("nombre","valFormFechWidgetTrId" );
      ((Element)v.get(345)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("align","left" );
      ((Element)v.get(350)).setAttribute("nowrap","true" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(351)).setAttribute("nombre","valFormFech" );
      ((Element)v.get(351)).setAttribute("id","datosCampos" );
      ((Element)v.get(351)).setAttribute("multiple","N" );
      ((Element)v.get(351)).setAttribute("req","N" );
      ((Element)v.get(351)).setAttribute("size","1" );
      ((Element)v.get(351)).setAttribute("validacion","" );
      ((Element)v.get(351)).setAttribute("onchange","" );
      ((Element)v.get(351)).setAttribute("onfocus","" );
      ((Element)v.get(351)).setAttribute("valorinicial","" );
      ((Element)v.get(351)).setAttribute("textoinicial","" );
      ((Element)v.get(351)).setAttribute("disabled","" );
      ((Element)v.get(351)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',21, true)" );
      ((Element)v.get(351)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',21, false)" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(353)).setAttribute("ID","dd/mm/yyyy" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(354)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(354)).setAttribute("TIPO","STRING" );
      ((Element)v.get(354)).setAttribute("VALOR","dd/mm/yyyy" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 353   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(355)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(355)).setAttribute("TIPO","STRING" );
      ((Element)v.get(355)).setAttribute("VALOR","dd/mm/aaaa" );
      ((Element)v.get(353)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:353   */

      /* Empieza nodo:356 / Elemento padre: 352   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(356)).setAttribute("ID","mm/dd/yyyy" );
      ((Element)v.get(352)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(357)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(357)).setAttribute("TIPO","STRING" );
      ((Element)v.get(357)).setAttribute("VALOR","mm/dd/yyyy" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 356   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(358)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(358)).setAttribute("TIPO","STRING" );
      ((Element)v.get(358)).setAttribute("VALOR","mm/dd/aaaa" );
      ((Element)v.get(356)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:356   */

      /* Empieza nodo:359 / Elemento padre: 352   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(359)).setAttribute("ID","dd-mm-yyyy" );
      ((Element)v.get(352)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(360)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(360)).setAttribute("TIPO","STRING" );
      ((Element)v.get(360)).setAttribute("VALOR","dd-mm-yyyy" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 359   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(361)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(361)).setAttribute("TIPO","STRING" );
      ((Element)v.get(361)).setAttribute("VALOR","dd-mm-aaaa" );
      ((Element)v.get(359)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:359   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:362 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(362)).setAttribute("nombre","valFormFechGapTdId" );
      ((Element)v.get(362)).setAttribute("nowrap","true" );
      ((Element)v.get(362)).setAttribute("class","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","25" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(364)).setAttribute("nombre","valSepaMileTdId" );
      ((Element)v.get(333)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(365)).setAttribute("width","100%" );
      ((Element)v.get(365)).setAttribute("border","0" );
      ((Element)v.get(365)).setAttribute("cellspacing","0" );
      ((Element)v.get(365)).setAttribute("cellpadding","0" );
      ((Element)v.get(365)).setAttribute("align","left" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(367)).setAttribute("valign","top" );
      ((Element)v.get(367)).setAttribute("height","13" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(368)).setAttribute("nombre","lblValSepaMile" );
      ((Element)v.get(368)).setAttribute("ancho","150" );
      ((Element)v.get(368)).setAttribute("alto","13" );
      ((Element)v.get(368)).setAttribute("filas","1" );
      ((Element)v.get(368)).setAttribute("id","datosTitle" );
      ((Element)v.get(368)).setAttribute("cod","SegPaisView.valSepaMile.label" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:369 / Elemento padre: 365   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(369)).setAttribute("nombre","valSepaMileWidgetTrId" );
      ((Element)v.get(365)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("align","left" );
      ((Element)v.get(370)).setAttribute("nowrap","true" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(371)).setAttribute("nombre","valSepaMile" );
      ((Element)v.get(371)).setAttribute("id","datosCampos" );
      ((Element)v.get(371)).setAttribute("multiple","N" );
      ((Element)v.get(371)).setAttribute("req","N" );
      ((Element)v.get(371)).setAttribute("size","1" );
      ((Element)v.get(371)).setAttribute("validacion","" );
      ((Element)v.get(371)).setAttribute("onchange","" );
      ((Element)v.get(371)).setAttribute("onfocus","" );
      ((Element)v.get(371)).setAttribute("valorinicial","" );
      ((Element)v.get(371)).setAttribute("textoinicial","" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(371)).setAttribute("disabled","" );
      ((Element)v.get(371)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',22, true)" );
      ((Element)v.get(371)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',22, false)" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(373)).setAttribute("ID","," );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(374)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(374)).setAttribute("TIPO","STRING" );
      ((Element)v.get(374)).setAttribute("VALOR","," );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 373   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(375)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(375)).setAttribute("TIPO","STRING" );
      ((Element)v.get(375)).setAttribute("VALOR","," );
      ((Element)v.get(373)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:373   */

      /* Empieza nodo:376 / Elemento padre: 372   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(376)).setAttribute("ID","." );
      ((Element)v.get(372)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(377)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(377)).setAttribute("TIPO","STRING" );
      ((Element)v.get(377)).setAttribute("VALOR","." );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 376   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(378)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(378)).setAttribute("TIPO","STRING" );
      ((Element)v.get(378)).setAttribute("VALOR","." );
      ((Element)v.get(376)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:376   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:379 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("nombre","valSepaMileGapTdId" );
      ((Element)v.get(379)).setAttribute("nowrap","true" );
      ((Element)v.get(379)).setAttribute("class","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(381)).setAttribute("nombre","valSepaDeciTdId" );
      ((Element)v.get(333)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(382)).setAttribute("width","100%" );
      ((Element)v.get(382)).setAttribute("border","0" );
      ((Element)v.get(382)).setAttribute("cellspacing","0" );
      ((Element)v.get(382)).setAttribute("cellpadding","0" );
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("valign","top" );
      ((Element)v.get(384)).setAttribute("height","13" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(385)).setAttribute("nombre","lblValSepaDeci" );
      ((Element)v.get(385)).setAttribute("ancho","150" );
      ((Element)v.get(385)).setAttribute("alto","13" );
      ((Element)v.get(385)).setAttribute("filas","1" );
      ((Element)v.get(385)).setAttribute("id","datosTitle" );
      ((Element)v.get(385)).setAttribute("cod","SegPaisView.valSepaDeci.label" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:386 / Elemento padre: 382   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(386)).setAttribute("nombre","valSepaDeciWidgetTrId" );
      ((Element)v.get(382)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("align","left" );
      ((Element)v.get(387)).setAttribute("nowrap","true" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(388)).setAttribute("nombre","valSepaDeci" );
      ((Element)v.get(388)).setAttribute("id","datosCampos" );
      ((Element)v.get(388)).setAttribute("multiple","N" );
      ((Element)v.get(388)).setAttribute("req","N" );
      ((Element)v.get(388)).setAttribute("size","1" );
      ((Element)v.get(388)).setAttribute("validacion","" );
      ((Element)v.get(388)).setAttribute("onchange","" );
      ((Element)v.get(388)).setAttribute("onfocus","" );
      ((Element)v.get(388)).setAttribute("valorinicial","" );
      ((Element)v.get(388)).setAttribute("textoinicial","" );
      ((Element)v.get(388)).setAttribute("disabled","" );
      ((Element)v.get(388)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',23, true)" );
      ((Element)v.get(388)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',23, false)" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(390)).setAttribute("ID","," );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(391)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(391)).setAttribute("TIPO","STRING" );
      ((Element)v.get(391)).setAttribute("VALOR","," );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 390   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(392)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(392)).setAttribute("TIPO","STRING" );
      ((Element)v.get(392)).setAttribute("VALOR","," );
      ((Element)v.get(390)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:390   */

      /* Empieza nodo:393 / Elemento padre: 389   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(393)).setAttribute("ID","." );
      ((Element)v.get(389)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(394)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(394)).setAttribute("TIPO","STRING" );
      ((Element)v.get(394)).setAttribute("VALOR","." );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 393   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(395)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(395)).setAttribute("TIPO","STRING" );
      ((Element)v.get(395)).setAttribute("VALOR","." );
      ((Element)v.get(393)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:393   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:396 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).setAttribute("nombre","valSepaDeciGapTdId" );
      ((Element)v.get(396)).setAttribute("nowrap","true" );
      ((Element)v.get(396)).setAttribute("class","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","25" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("nombre","numPeriEgreTdId" );
      ((Element)v.get(333)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(399)).setAttribute("width","100%" );
      ((Element)v.get(399)).setAttribute("border","0" );
      ((Element)v.get(399)).setAttribute("cellspacing","0" );
      ((Element)v.get(399)).setAttribute("cellpadding","0" );
      ((Element)v.get(399)).setAttribute("align","left" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(401)).setAttribute("valign","top" );
      ((Element)v.get(401)).setAttribute("height","13" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(402)).setAttribute("nombre","lblNumPeriEgre" );
      ((Element)v.get(402)).setAttribute("alto","13" );
      ((Element)v.get(402)).setAttribute("filas","1" );
      ((Element)v.get(402)).setAttribute("id","datosTitle" );
      ((Element)v.get(402)).setAttribute("cod","SegPaisView.numPeriEgre.label" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:403 / Elemento padre: 399   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(403)).setAttribute("nombre","numPeriEgreWidgetTrId" );
      ((Element)v.get(399)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("align","left" );
      ((Element)v.get(404)).setAttribute("nowrap","true" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(405)).setAttribute("nombre","numPeriEgre" );
      ((Element)v.get(405)).setAttribute("id","datosCampos" );
      ((Element)v.get(405)).setAttribute("trim","S" );
      ((Element)v.get(405)).setAttribute("max","2" );
      ((Element)v.get(405)).setAttribute("onchange","" );
      ((Element)v.get(405)).setAttribute("req","N" );
      ((Element)v.get(405)).setAttribute("size","2" );
      ((Element)v.get(405)).setAttribute("valor","" );
      ((Element)v.get(405)).setAttribute("validacion","" );
      ((Element)v.get(405)).setAttribute("disabled","" );
      ((Element)v.get(405)).setAttribute("onblur","" );
      ((Element)v.get(405)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',24, true)" );
      ((Element)v.get(405)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 24, false)" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:406 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(406)).setAttribute("nombre","numPeriEgreGapTdId" );
      ((Element)v.get(406)).setAttribute("nowrap","true" );
      ((Element)v.get(406)).setAttribute("class","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","25" );
      ((Element)v.get(407)).setAttribute("height","8" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(408)).setAttribute("width","100%" );
      ((Element)v.get(333)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:328   */

      /* Empieza nodo:410 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(410)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(411)).setAttribute("align","center" );
      ((Element)v.get(411)).setAttribute("width","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","12" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 410   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","8" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 410   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("align","center" );
      ((Element)v.get(415)).setAttribute("width","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","12" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:410   */

      /* Empieza nodo:417 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(417)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).setAttribute("align","center" );
      ((Element)v.get(418)).setAttribute("width","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(419)).setAttribute("height","12" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 417   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("width","100%" );
      ((Element)v.get(417)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(421)).setAttribute("width","100%" );
      ((Element)v.get(421)).setAttribute("border","0" );
      ((Element)v.get(421)).setAttribute("cellspacing","0" );
      ((Element)v.get(421)).setAttribute("cellpadding","0" );
      ((Element)v.get(421)).setAttribute("align","left" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(422)).setAttribute("align","left" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("nombre","numPeriRetiTdId" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(424)).setAttribute("width","100%" );
      ((Element)v.get(424)).setAttribute("border","0" );
      ((Element)v.get(424)).setAttribute("cellspacing","0" );
      ((Element)v.get(424)).setAttribute("cellpadding","0" );
      ((Element)v.get(424)).setAttribute("align","left" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(426)).setAttribute("valign","top" );
      ((Element)v.get(426)).setAttribute("height","13" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(427)).setAttribute("nombre","lblNumPeriReti" );
      ((Element)v.get(427)).setAttribute("alto","13" );
      ((Element)v.get(427)).setAttribute("filas","1" );
      ((Element)v.get(427)).setAttribute("id","datosTitle" );
      ((Element)v.get(427)).setAttribute("cod","SegPaisView.numPeriReti.label" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:428 / Elemento padre: 424   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(428)).setAttribute("nombre","numPeriRetiWidgetTrId" );
      ((Element)v.get(424)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("align","left" );
      ((Element)v.get(429)).setAttribute("nowrap","true" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(430)).setAttribute("nombre","numPeriReti" );
      ((Element)v.get(430)).setAttribute("id","datosCampos" );
      ((Element)v.get(430)).setAttribute("trim","S" );
      ((Element)v.get(430)).setAttribute("max","2" );
      ((Element)v.get(430)).setAttribute("onchange","" );
      ((Element)v.get(430)).setAttribute("req","N" );
      ((Element)v.get(430)).setAttribute("size","2" );
      ((Element)v.get(430)).setAttribute("valor","" );
      ((Element)v.get(430)).setAttribute("validacion","" );
      ((Element)v.get(430)).setAttribute("disabled","" );
      ((Element)v.get(430)).setAttribute("onblur","" );
      ((Element)v.get(430)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',25, true)" );
      ((Element)v.get(430)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 25, false)" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:431 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("nombre","numPeriRetiGapTdId" );
      ((Element)v.get(431)).setAttribute("nowrap","true" );
      ((Element)v.get(431)).setAttribute("class","datosCampos" );
      ((Element)v.get(422)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","25" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(422)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(434)).setAttribute("border","0" );
      ((Element)v.get(434)).setAttribute("cellspacing","0" );
      ((Element)v.get(434)).setAttribute("cellpadding","0" );
      ((Element)v.get(434)).setAttribute("align","left" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(436)).setAttribute("valign","top" );
      ((Element)v.get(436)).setAttribute("height","13" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(437)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(437)).setAttribute("id","datosTitle" );
      ((Element)v.get(437)).setAttribute("ancho","150" );
      ((Element)v.get(437)).setAttribute("alto","13" );
      ((Element)v.get(437)).setAttribute("cod","SegPaisView.fopaOidFormPago.label" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 434   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(438)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(434)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(439)).setAttribute("align","left" );
      ((Element)v.get(439)).setAttribute("nowrap","true" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(440)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(440)).setAttribute("id","datosCampos" );
      ((Element)v.get(440)).setAttribute("multiple","N" );
      ((Element)v.get(440)).setAttribute("req","N" );
      ((Element)v.get(440)).setAttribute("size","1" );
      ((Element)v.get(440)).setAttribute("disabled","" );
      ((Element)v.get(440)).setAttribute("validacion","" );
      ((Element)v.get(440)).setAttribute("onchange","" );
      ((Element)v.get(440)).setAttribute("onfocus","" );
      ((Element)v.get(440)).setAttribute("valorinicial","" );
      ((Element)v.get(440)).setAttribute("textoinicial","" );
      ((Element)v.get(440)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',26, true);" );
      ((Element)v.get(440)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',26, false);" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:442 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(442)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(442)).setAttribute("nowrap","true" );
      ((Element)v.get(442)).setAttribute("class","datosCampos" );
      ((Element)v.get(422)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","25" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("nombre","valCompTeleTdId" );
      ((Element)v.get(422)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(445)).setAttribute("width","100%" );
      ((Element)v.get(445)).setAttribute("border","0" );
      ((Element)v.get(445)).setAttribute("cellspacing","0" );
      ((Element)v.get(445)).setAttribute("cellpadding","0" );
      ((Element)v.get(445)).setAttribute("align","left" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(447)).setAttribute("valign","top" );
      ((Element)v.get(447)).setAttribute("height","13" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(448)).setAttribute("nombre","lblValCompTele" );
      ((Element)v.get(448)).setAttribute("alto","13" );
      ((Element)v.get(448)).setAttribute("filas","1" );
      ((Element)v.get(448)).setAttribute("id","datosTitle" );
      ((Element)v.get(448)).setAttribute("cod","SegPaisView.valCompTele.label" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:449 / Elemento padre: 445   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(449)).setAttribute("nombre","valCompTeleWidgetTrId" );
      ((Element)v.get(445)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).setAttribute("align","left" );
      ((Element)v.get(450)).setAttribute("nowrap","true" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(451)).setAttribute("nombre","valCompTele" );
      ((Element)v.get(451)).setAttribute("id","datosCampos" );
      ((Element)v.get(451)).setAttribute("trim","S" );
      ((Element)v.get(451)).setAttribute("max","40" );
      ((Element)v.get(451)).setAttribute("onchange","" );
      ((Element)v.get(451)).setAttribute("req","N" );
      ((Element)v.get(451)).setAttribute("size","40" );
      ((Element)v.get(451)).setAttribute("valor","" );
      ((Element)v.get(451)).setAttribute("validacion","" );
      ((Element)v.get(451)).setAttribute("disabled","" );
      ((Element)v.get(451)).setAttribute("onblur","" );
      ((Element)v.get(451)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',27, true)" );
      ((Element)v.get(451)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm', 27, false)" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:452 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(452)).setAttribute("nombre","valCompTeleGapTdId" );
      ((Element)v.get(452)).setAttribute("nowrap","true" );
      ((Element)v.get(452)).setAttribute("class","datosCampos" );
      ((Element)v.get(422)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","25" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("width","100%" );
      ((Element)v.get(422)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:417   */

      /* Empieza nodo:456 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(456)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("align","center" );
      ((Element)v.get(457)).setAttribute("width","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","12" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(456)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","8" );
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(461)).setAttribute("align","center" );
      ((Element)v.get(461)).setAttribute("width","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","12" );
      ((Element)v.get(462)).setAttribute("height","8" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:456   */

      /* Empieza nodo:463 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(463)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(464)).setAttribute("align","center" );
      ((Element)v.get(464)).setAttribute("width","8" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","8" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(465)).setAttribute("height","12" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 463   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(466)).setAttribute("width","100%" );
      ((Element)v.get(463)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(467)).setAttribute("width","100%" );
      ((Element)v.get(467)).setAttribute("border","0" );
      ((Element)v.get(467)).setAttribute("cellspacing","0" );
      ((Element)v.get(467)).setAttribute("cellpadding","0" );
      ((Element)v.get(467)).setAttribute("align","left" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(468)).setAttribute("align","left" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(469)).setAttribute("nombre","indFletZonaUbigTdId" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(470)).setAttribute("border","0" );
      ((Element)v.get(470)).setAttribute("cellspacing","0" );
      ((Element)v.get(470)).setAttribute("cellpadding","0" );
      ((Element)v.get(470)).setAttribute("align","left" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(472)).setAttribute("valign","top" );
      ((Element)v.get(472)).setAttribute("height","13" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(473)).setAttribute("nombre","lblIndFletZonaUbig" );
      ((Element)v.get(473)).setAttribute("ancho","150" );
      ((Element)v.get(473)).setAttribute("alto","13" );
      ((Element)v.get(473)).setAttribute("filas","1" );
      ((Element)v.get(473)).setAttribute("id","datosTitle" );
      ((Element)v.get(473)).setAttribute("cod","SegPaisView.indFletZonaUbig.label" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:474 / Elemento padre: 470   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(474)).setAttribute("nombre","indFletZonaUbigWidgetTrId" );
      ((Element)v.get(470)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("align","left" );
      ((Element)v.get(475)).setAttribute("nowrap","true" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(476)).setAttribute("nombre","indFletZonaUbig" );
      ((Element)v.get(476)).setAttribute("id","datosCampos" );
      ((Element)v.get(476)).setAttribute("multiple","N" );
      ((Element)v.get(476)).setAttribute("req","N" );
      ((Element)v.get(476)).setAttribute("size","1" );
      ((Element)v.get(476)).setAttribute("validacion","" );
      ((Element)v.get(476)).setAttribute("onchange","" );
      ((Element)v.get(476)).setAttribute("onfocus","" );
      ((Element)v.get(476)).setAttribute("valorinicial","" );
      ((Element)v.get(476)).setAttribute("textoinicial","" );
      ((Element)v.get(476)).setAttribute("disabled","" );
      ((Element)v.get(476)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',28, true)" );
      ((Element)v.get(476)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',28, false)" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(476)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(478)).setAttribute("ID","U" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(479)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(479)).setAttribute("TIPO","STRING" );
      ((Element)v.get(479)).setAttribute("VALOR","U" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 478   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(480)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(480)).setAttribute("TIPO","STRING" );
      ((Element)v.get(480)).setAttribute("VALOR","Ubigeo" );
      ((Element)v.get(478)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:478   */

      /* Empieza nodo:481 / Elemento padre: 477   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(481)).setAttribute("ID","Z" );
      ((Element)v.get(477)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(482)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(482)).setAttribute("TIPO","STRING" );
      ((Element)v.get(482)).setAttribute("VALOR","Z" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 481   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(483)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(483)).setAttribute("TIPO","STRING" );
      ((Element)v.get(483)).setAttribute("VALOR","Zona" );
      ((Element)v.get(481)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:481   */
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:484 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(484)).setAttribute("nombre","indFletZonaUbigGapTdId" );
      ((Element)v.get(484)).setAttribute("nowrap","true" );
      ((Element)v.get(484)).setAttribute("class","datosCampos" );
      ((Element)v.get(468)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","25" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(486)).setAttribute("nombre","valIndiSecuMoniTdId" );
      ((Element)v.get(468)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(487)).setAttribute("width","100%" );
      ((Element)v.get(487)).setAttribute("border","0" );
      ((Element)v.get(487)).setAttribute("cellspacing","0" );
      ((Element)v.get(487)).setAttribute("cellpadding","0" );
      ((Element)v.get(487)).setAttribute("align","left" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(489)).setAttribute("valign","top" );
      ((Element)v.get(489)).setAttribute("height","13" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(490)).setAttribute("nombre","lblValIndiSecuMoni" );
      ((Element)v.get(490)).setAttribute("alto","13" );
      ((Element)v.get(490)).setAttribute("filas","1" );
      ((Element)v.get(490)).setAttribute("id","datosTitle" );
      ((Element)v.get(490)).setAttribute("cod","SegPaisView.valIndiSecuMoni.label" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:491 / Elemento padre: 487   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(491)).setAttribute("nombre","valIndiSecuMoniWidgetTrId" );
      ((Element)v.get(487)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(492)).setAttribute("align","left" );
      ((Element)v.get(492)).setAttribute("nowrap","true" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(493)).setAttribute("nombre","valIndiSecuMoni" );
      ((Element)v.get(493)).setAttribute("tipo","H" );
      ((Element)v.get(493)).setAttribute("req","N" );
      ((Element)v.get(493)).setAttribute("id","datosCampos" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(493)).setAttribute("disabled","" );
      ((Element)v.get(493)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',29, true)" );
      ((Element)v.get(493)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',29, false)" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(494)).setAttribute("id","datosCampos" );
      ((Element)v.get(494)).setAttribute("valor","1" );
      ((Element)v.get(494)).setAttribute("cod","SegPaisView.valIndiSecuMoni.1.label" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Elemento padre:494 / Elemento actual: 495   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(494)).appendChild((Text)v.get(495));

      /* Termina nodo Texto:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 493   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(496)).setAttribute("id","datosCampos" );
      ((Element)v.get(496)).setAttribute("valor","0" );
      ((Element)v.get(496)).setAttribute("cod","SegPaisView.valIndiSecuMoni.0.label" );
      ((Element)v.get(493)).appendChild((Element)v.get(496));

      /* Elemento padre:496 / Elemento actual: 497   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(496)).appendChild((Text)v.get(497));

      /* Termina nodo Texto:497   */
      /* Termina nodo:496   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:498 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).setAttribute("nombre","valIndiSecuMoniGapTdId" );
      ((Element)v.get(498)).setAttribute("nowrap","true" );
      ((Element)v.get(498)).setAttribute("class","datosCampos" );
      ((Element)v.get(468)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","25" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(500)).setAttribute("nombre","indSecuTdId" );
      ((Element)v.get(468)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(501)).setAttribute("width","100%" );
      ((Element)v.get(501)).setAttribute("border","0" );
      ((Element)v.get(501)).setAttribute("cellspacing","0" );
      ((Element)v.get(501)).setAttribute("cellpadding","0" );
      ((Element)v.get(501)).setAttribute("align","left" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(503)).setAttribute("valign","top" );
      ((Element)v.get(503)).setAttribute("height","13" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(504)).setAttribute("nombre","lblIndSecu" );
      ((Element)v.get(504)).setAttribute("ancho","150" );
      ((Element)v.get(504)).setAttribute("alto","13" );
      ((Element)v.get(504)).setAttribute("filas","1" );
      ((Element)v.get(504)).setAttribute("id","datosTitle" );
      ((Element)v.get(504)).setAttribute("cod","SegPaisView.indSecu.label" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:505 / Elemento padre: 501   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(505)).setAttribute("nombre","indSecuWidgetTrId" );
      ((Element)v.get(501)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).setAttribute("align","left" );
      ((Element)v.get(506)).setAttribute("nowrap","true" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(507)).setAttribute("nombre","indSecu" );
      ((Element)v.get(507)).setAttribute("id","datosCampos" );
      ((Element)v.get(507)).setAttribute("multiple","N" );
      ((Element)v.get(507)).setAttribute("req","N" );
      ((Element)v.get(507)).setAttribute("size","1" );
      ((Element)v.get(507)).setAttribute("validacion","" );
      ((Element)v.get(507)).setAttribute("onchange","" );
      ((Element)v.get(507)).setAttribute("onfocus","" );
      ((Element)v.get(507)).setAttribute("valorinicial","" );
      ((Element)v.get(507)).setAttribute("textoinicial","" );
      ((Element)v.get(507)).setAttribute("disabled","" );
      ((Element)v.get(507)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',30, true)" );
      ((Element)v.get(507)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',30, false)" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(509)).setAttribute("ID","M" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(510)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(510)).setAttribute("TIPO","STRING" );
      ((Element)v.get(510)).setAttribute("VALOR","M" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 509   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(511)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(511)).setAttribute("TIPO","STRING" );
      ((Element)v.get(511)).setAttribute("VALOR","Montoto" );
      ((Element)v.get(509)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:509   */

      /* Empieza nodo:512 / Elemento padre: 508   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(512)).setAttribute("ID","T" );
      ((Element)v.get(508)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(513)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(513)).setAttribute("TIPO","STRING" );
      ((Element)v.get(513)).setAttribute("VALOR","T" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 512   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(514)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(514)).setAttribute("TIPO","STRING" );
      ((Element)v.get(514)).setAttribute("VALOR","Transporte" );
      ((Element)v.get(512)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:512   */
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:515 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(515)).setAttribute("nombre","indSecuGapTdId" );
      ((Element)v.get(515)).setAttribute("nowrap","true" );
      ((Element)v.get(515)).setAttribute("class","datosCampos" );
      ((Element)v.get(468)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","25" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:517 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(517)).setAttribute("nombre","indBalaAreaCheqTdId" );
      ((Element)v.get(468)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(518)).setAttribute("width","100%" );
      ((Element)v.get(518)).setAttribute("border","0" );
      ((Element)v.get(518)).setAttribute("cellspacing","0" );
      ((Element)v.get(518)).setAttribute("cellpadding","0" );
      ((Element)v.get(518)).setAttribute("align","left" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(520)).setAttribute("valign","top" );
      ((Element)v.get(520)).setAttribute("height","13" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(521)).setAttribute("nombre","lblIndBalaAreaCheq" );
      ((Element)v.get(521)).setAttribute("ancho","150" );
      ((Element)v.get(521)).setAttribute("alto","13" );
      ((Element)v.get(521)).setAttribute("filas","1" );
      ((Element)v.get(521)).setAttribute("id","datosTitle" );
      ((Element)v.get(521)).setAttribute("cod","SegPaisView.indBalaAreaCheq.label" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:522 / Elemento padre: 518   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(522)).setAttribute("nombre","indBalaAreaCheqWidgetTrId" );
      ((Element)v.get(518)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(523)).setAttribute("align","left" );
      ((Element)v.get(523)).setAttribute("nowrap","true" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(524)).setAttribute("nombre","indBalaAreaCheq" );
      ((Element)v.get(524)).setAttribute("id","datosCampos" );
      ((Element)v.get(524)).setAttribute("multiple","N" );
      ((Element)v.get(524)).setAttribute("req","N" );
      ((Element)v.get(524)).setAttribute("size","1" );
      ((Element)v.get(524)).setAttribute("validacion","" );
      ((Element)v.get(524)).setAttribute("onchange","" );
      ((Element)v.get(524)).setAttribute("onfocus","" );
      ((Element)v.get(524)).setAttribute("valorinicial","" );
      ((Element)v.get(524)).setAttribute("textoinicial","" );
      ((Element)v.get(524)).setAttribute("disabled","" );
      ((Element)v.get(524)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',31, true)" );
      ((Element)v.get(524)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',31, false)" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(526)).setAttribute("ID","P" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(527)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(527)).setAttribute("TIPO","STRING" );
      ((Element)v.get(527)).setAttribute("VALOR","P" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 526   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(528)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(528)).setAttribute("TIPO","STRING" );
      ((Element)v.get(528)).setAttribute("VALOR","MODELO PERU" );
      ((Element)v.get(526)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:526   */

      /* Empieza nodo:529 / Elemento padre: 525   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(529)).setAttribute("ID","C" );
      ((Element)v.get(525)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(530)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(530)).setAttribute("TIPO","STRING" );
      ((Element)v.get(530)).setAttribute("VALOR","C" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */

      /* Empieza nodo:531 / Elemento padre: 529   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(531)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(531)).setAttribute("TIPO","STRING" );
      ((Element)v.get(531)).setAttribute("VALOR","MODELO COLOMBIA" );
      ((Element)v.get(529)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:529   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:532 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(532)).setAttribute("nombre","indBalaAreaCheqGapTdId" );
      ((Element)v.get(532)).setAttribute("nowrap","true" );
      ((Element)v.get(532)).setAttribute("class","datosCampos" );
      ((Element)v.get(468)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","25" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(468)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:463   */

      /* Empieza nodo:536 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(536)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("align","center" );
      ((Element)v.get(537)).setAttribute("width","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","12" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(536)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","8" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("align","center" );
      ((Element)v.get(541)).setAttribute("width","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("width","12" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:536   */

      /* Empieza nodo:543 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(543)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("align","center" );
      ((Element)v.get(544)).setAttribute("width","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","8" );
      ((Element)v.get(545)).setAttribute("height","12" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).setAttribute("width","100%" );
      ((Element)v.get(543)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(547)).setAttribute("width","100%" );
      ((Element)v.get(547)).setAttribute("border","0" );
      ((Element)v.get(547)).setAttribute("cellspacing","0" );
      ((Element)v.get(547)).setAttribute("cellpadding","0" );
      ((Element)v.get(547)).setAttribute("align","left" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(548)).setAttribute("align","left" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(549)).setAttribute("nombre","valUrlTdId" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(550)).setAttribute("width","100%" );
      ((Element)v.get(550)).setAttribute("border","0" );
      ((Element)v.get(550)).setAttribute("cellspacing","0" );
      ((Element)v.get(550)).setAttribute("cellpadding","0" );
      ((Element)v.get(550)).setAttribute("align","left" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(552)).setAttribute("valign","top" );
      ((Element)v.get(552)).setAttribute("height","13" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(553)).setAttribute("nombre","lblValUrl" );
      ((Element)v.get(553)).setAttribute("alto","13" );
      ((Element)v.get(553)).setAttribute("filas","1" );
      ((Element)v.get(553)).setAttribute("id","datosTitle" );
      ((Element)v.get(553)).setAttribute("cod","SegPaisView.valUrl.label" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:554 / Elemento padre: 550   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(554)).setAttribute("nombre","valUrlWidgetTrId" );
      ((Element)v.get(550)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(555)).setAttribute("align","left" );
      ((Element)v.get(555)).setAttribute("nowrap","true" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(556)).setAttribute("nombre","valUrl" );
      ((Element)v.get(556)).setAttribute("valor","" );
      ((Element)v.get(556)).setAttribute("rows","3" );
      ((Element)v.get(556)).setAttribute("cols","40" );
      ((Element)v.get(556)).setAttribute("validacion","" );
      ((Element)v.get(556)).setAttribute("disabled","" );
      ((Element)v.get(556)).setAttribute("req","N" );
      ((Element)v.get(556)).setAttribute("id","datosCampos" );
      ((Element)v.get(556)).setAttribute("onblur","" );
      ((Element)v.get(556)).setAttribute("onfocus","" );
      ((Element)v.get(556)).setAttribute("onchange","" );
      ((Element)v.get(556)).setAttribute("ontab","ejecutarAccionFoco('segPaisViewFrm',32, true)" );
      ((Element)v.get(556)).setAttribute("onshtab","ejecutarAccionFoco('segPaisViewFrm',32, false)" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:557 / Elemento padre: 548   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(557)).setAttribute("nombre","valUrlGapTdId" );
      ((Element)v.get(557)).setAttribute("nowrap","true" );
      ((Element)v.get(557)).setAttribute("class","datosCampos" );
      ((Element)v.get(548)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(558)).setAttribute("src","b.gif" );
      ((Element)v.get(558)).setAttribute("width","25" );
      ((Element)v.get(558)).setAttribute("height","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 548   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(559)).setAttribute("width","100%" );
      ((Element)v.get(548)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(560)).setAttribute("src","b.gif" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:561 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(561)).setAttribute("width","100%" );
      ((Element)v.get(543)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:543   */

      /* Empieza nodo:562 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(562)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(563)).setAttribute("align","center" );
      ((Element)v.get(563)).setAttribute("width","8" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","8" );
      ((Element)v.get(564)).setAttribute("height","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","8" );
      ((Element)v.get(566)).setAttribute("height","8" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(567)).setAttribute("align","center" );
      ((Element)v.get(567)).setAttribute("width","8" );
      ((Element)v.get(562)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).setAttribute("width","8" );
      ((Element)v.get(568)).setAttribute("height","8" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */
      /* Termina nodo:562   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:569 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("align","center" );
      ((Element)v.get(569)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","12" );
      ((Element)v.get(570)).setAttribute("height","12" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:8   */

      /* Empieza nodo:571 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(571)).setAttribute("nombre","segPaisViewTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(572)).setAttribute("align","center" );
      ((Element)v.get(572)).setAttribute("width","12" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","12" );
      ((Element)v.get(573)).setAttribute("height","12" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(571)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(576)).setAttribute("width","100%" );
      ((Element)v.get(576)).setAttribute("border","0" );
      ((Element)v.get(576)).setAttribute("align","center" );
      ((Element)v.get(576)).setAttribute("cellspacing","0" );
      ((Element)v.get(576)).setAttribute("cellpadding","0" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).setAttribute("class","tablaTitle" );
      ((Element)v.get(578)).setAttribute("nombre","segPaisViewTdQueryButton" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(579)).setAttribute("nombre","segPaisViewQueryButton" );
      ((Element)v.get(579)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(579)).setAttribute("estado","false" );
      ((Element)v.get(579)).setAttribute("accion","segPaisViewFirstPage();" );
      ((Element)v.get(579)).setAttribute("tipo","html" );
      ((Element)v.get(579)).setAttribute("ID","botonContenido" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 577   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(580)).setAttribute("class","tablaTitle" );
      ((Element)v.get(580)).setAttribute("nombre","segPaisViewTdLovNullSelectionButton" );
      ((Element)v.get(580)).setAttribute("align","left" );
      ((Element)v.get(580)).setAttribute("width","100%" );
      ((Element)v.get(577)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("height","8" );
      ((Element)v.get(581)).setAttribute("width","8" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */

      /* Empieza nodo:582 / Elemento padre: 580   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(582)).setAttribute("nombre","segPaisViewLovNullButton" );
      ((Element)v.get(582)).setAttribute("ID","botonContenido" );
      ((Element)v.get(582)).setAttribute("tipo","html" );
      ((Element)v.get(582)).setAttribute("accion","segPaisViewLovNullSelectionAction();" );
      ((Element)v.get(582)).setAttribute("estado","true" );
      ((Element)v.get(582)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(580)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:580   */
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:583 / Elemento padre: 571   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("align","center" );
      ((Element)v.get(583)).setAttribute("width","12" );
      ((Element)v.get(571)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","12" );
      ((Element)v.get(584)).setAttribute("height","12" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:571   */


   }

}
