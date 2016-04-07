
import org.w3c.dom.*;
import java.util.ArrayList;

public class SegPaisPageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","SegPais.legend.label" );
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
      ((Element)v.get(29)).setAttribute("cod","SegPais.id.label" );
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
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',1, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 1, false)" );
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
      ((Element)v.get(54)).setAttribute("cod","SegPais.codPais.label" );
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
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',2, true)" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 2, false)" );
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
      ((Element)v.get(64)).setAttribute("cod","SegPais.moneOidMone.label" );
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
      ((Element)v.get(67)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',3, true);" );
      ((Element)v.get(67)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',3, false);" );
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
      ((Element)v.get(75)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
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
      ((Element)v.get(78)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',4, true);" );
      ((Element)v.get(78)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',4, false);" );
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
      ((Element)v.get(86)).setAttribute("cod","SegPais.Descripcion.label" );
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
      ((Element)v.get(90)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',5, true)" );
      ((Element)v.get(90)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 5, false)" );
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
      ((Element)v.get(94)).setAttribute("href","javascript:openLocalizationDialog('segPaisFrm', 'Descripcion', 1);" );
      ((Element)v.get(94)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"segPaisFrm\",5, true)', 'ejecutarAccionFoco(\"segPaisFrm\",5, false)')" );
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
      ((Element)v.get(117)).setAttribute("cod","SegPais.indInteGis.label" );
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
      ((Element)v.get(120)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',6, true)" );
      ((Element)v.get(120)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',6, false)" );
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
      ((Element)v.get(134)).setAttribute("cod","SegPais.valIden.label" );
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
      ((Element)v.get(137)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',7, true)" );
      ((Element)v.get(137)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',7, false)" );
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
      ((Element)v.get(151)).setAttribute("cod","SegPais.indSaldUnic.label" );
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
      ((Element)v.get(154)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',8, true)" );
      ((Element)v.get(154)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',8, false)" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(155)).setAttribute("valor","1" );
      ((Element)v.get(155)).setAttribute("cod","SegPais.indSaldUnic.1.label" );
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
      ((Element)v.get(157)).setAttribute("cod","SegPais.indSaldUnic.0.label" );
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
      ((Element)v.get(165)).setAttribute("cod","SegPais.valProgEjec.label" );
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
      ((Element)v.get(168)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',9, true)" );
      ((Element)v.get(168)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 9, false)" );
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
      ((Element)v.get(175)).setAttribute("cod","SegPais.valPorcAlar.label" );
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
      ((Element)v.get(178)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',10, true)" );
      ((Element)v.get(178)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 10, false)" );
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
      ((Element)v.get(200)).setAttribute("cod","SegPais.indCompAuto.label" );
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
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(203)).setAttribute("nombre","indCompAuto" );
      ((Element)v.get(203)).setAttribute("tipo","H" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("disabled","" );
      ((Element)v.get(203)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',11, true)" );
      ((Element)v.get(203)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',11, false)" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("valor","1" );
      ((Element)v.get(204)).setAttribute("cod","SegPais.indCompAuto.1.label" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("valor","0" );
      ((Element)v.get(206)).setAttribute("cod","SegPais.indCompAuto.0.label" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:208 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).setAttribute("nombre","indCompAutoGapTdId" );
      ((Element)v.get(208)).setAttribute("nowrap","true" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(208)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("nombre","numDiasMoraTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(211)).setAttribute("border","0" );
      ((Element)v.get(211)).setAttribute("cellspacing","0" );
      ((Element)v.get(211)).setAttribute("cellpadding","0" );
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("valign","top" );
      ((Element)v.get(213)).setAttribute("height","13" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblNumDiasMora" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","SegPais.numDiasMora.label" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(215)).setAttribute("nombre","numDiasMoraWidgetTrId" );
      ((Element)v.get(211)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(216)).setAttribute("nowrap","true" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(217)).setAttribute("nombre","numDiasMora" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).setAttribute("trim","S" );
      ((Element)v.get(217)).setAttribute("max","3" );
      ((Element)v.get(217)).setAttribute("onchange","" );
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("size","3" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("validacion","" );
      ((Element)v.get(217)).setAttribute("disabled","" );
      ((Element)v.get(217)).setAttribute("onblur","" );
      ((Element)v.get(217)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',12, true)" );
      ((Element)v.get(217)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 12, false)" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:218 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("nombre","numDiasMoraGapTdId" );
      ((Element)v.get(218)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("nombre","indTratAcumDescTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(221)).setAttribute("width","100%" );
      ((Element)v.get(221)).setAttribute("border","0" );
      ((Element)v.get(221)).setAttribute("cellspacing","0" );
      ((Element)v.get(221)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("valign","top" );
      ((Element)v.get(223)).setAttribute("height","13" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lblIndTratAcumDesc" );
      ((Element)v.get(224)).setAttribute("alto","13" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("id","datosTitle" );
      ((Element)v.get(224)).setAttribute("cod","SegPais.indTratAcumDesc.label" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(225)).setAttribute("nombre","indTratAcumDescWidgetTrId" );
      ((Element)v.get(221)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("align","left" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(226)).setAttribute("nowrap","true" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(227)).setAttribute("nombre","indTratAcumDesc" );
      ((Element)v.get(227)).setAttribute("tipo","H" );
      ((Element)v.get(227)).setAttribute("req","N" );
      ((Element)v.get(227)).setAttribute("id","datosCampos" );
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(227)).setAttribute("disabled","" );
      ((Element)v.get(227)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',13, true)" );
      ((Element)v.get(227)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',13, false)" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("valor","1" );
      ((Element)v.get(228)).setAttribute("cod","SegPais.indTratAcumDesc.1.label" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Elemento padre:228 / Elemento actual: 229   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(228)).appendChild((Text)v.get(229));

      /* Termina nodo Texto:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
      ((Element)v.get(230)).setAttribute("valor","0" );
      ((Element)v.get(230)).setAttribute("cod","SegPais.indTratAcumDesc.0.label" );
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Elemento padre:230 / Elemento actual: 231   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(230)).appendChild((Text)v.get(231));

      /* Termina nodo Texto:231   */
      /* Termina nodo:230   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:232 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("nombre","indTratAcumDescGapTdId" );
      ((Element)v.get(232)).setAttribute("nowrap","true" );
      ((Element)v.get(232)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","25" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("nombre","valTiemRezoTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).setAttribute("align","left" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).setAttribute("valign","top" );
      ((Element)v.get(237)).setAttribute("height","13" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblValTiemRezo" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","SegPais.valTiemRezo.label" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 235   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(239)).setAttribute("nombre","valTiemRezoWidgetTrId" );
      ((Element)v.get(235)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(240)).setAttribute("align","left" );
      ((Element)v.get(240)).setAttribute("nowrap","true" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(241)).setAttribute("nombre","valTiemRezo" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("trim","S" );
      ((Element)v.get(241)).setAttribute("max","2" );
      ((Element)v.get(241)).setAttribute("onchange","" );
      ((Element)v.get(241)).setAttribute("req","N" );
      ((Element)v.get(241)).setAttribute("size","2" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("validacion","" );
      ((Element)v.get(241)).setAttribute("disabled","" );
      ((Element)v.get(241)).setAttribute("onblur","" );
      ((Element)v.get(241)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',14, true)" );
      ((Element)v.get(241)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 14, false)" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:242 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(242)).setAttribute("nombre","valTiemRezoGapTdId" );
      ((Element)v.get(242)).setAttribute("nowrap","true" );
      ((Element)v.get(242)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("nombre","valConfSecuCccTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(245)).setAttribute("border","0" );
      ((Element)v.get(245)).setAttribute("cellspacing","0" );
      ((Element)v.get(245)).setAttribute("cellpadding","0" );
      ((Element)v.get(245)).setAttribute("align","left" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("valign","top" );
      ((Element)v.get(247)).setAttribute("height","13" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(248)).setAttribute("nombre","lblValConfSecuCcc" );
      ((Element)v.get(248)).setAttribute("ancho","150" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("id","datosTitle" );
      ((Element)v.get(248)).setAttribute("cod","SegPais.valConfSecuCcc.label" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:249 / Elemento padre: 245   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(249)).setAttribute("nombre","valConfSecuCccWidgetTrId" );
      ((Element)v.get(245)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("align","left" );
      ((Element)v.get(250)).setAttribute("nowrap","true" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(251)).setAttribute("nombre","valConfSecuCcc" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("multiple","N" );
      ((Element)v.get(251)).setAttribute("req","N" );
      ((Element)v.get(251)).setAttribute("size","1" );
      ((Element)v.get(251)).setAttribute("validacion","" );
      ((Element)v.get(251)).setAttribute("onchange","" );
      ((Element)v.get(251)).setAttribute("onfocus","" );
      ((Element)v.get(251)).setAttribute("valorinicial","" );
      ((Element)v.get(251)).setAttribute("textoinicial","" );
      ((Element)v.get(251)).setAttribute("disabled","" );
      ((Element)v.get(251)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',15, true)" );
      ((Element)v.get(251)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',15, false)" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(253)).setAttribute("ID","U" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(254)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(254)).setAttribute("TIPO","STRING" );
      ((Element)v.get(254)).setAttribute("VALOR","U" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 253   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(255)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(255)).setAttribute("TIPO","STRING" );
      ((Element)v.get(255)).setAttribute("VALOR","Único" );
      ((Element)v.get(253)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:253   */

      /* Empieza nodo:256 / Elemento padre: 252   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(256)).setAttribute("ID","A" );
      ((Element)v.get(252)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(257)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(257)).setAttribute("TIPO","STRING" );
      ((Element)v.get(257)).setAttribute("VALOR","A" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 256   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(258)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(258)).setAttribute("TIPO","STRING" );
      ((Element)v.get(258)).setAttribute("VALOR","Año" );
      ((Element)v.get(256)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:256   */

      /* Empieza nodo:259 / Elemento padre: 252   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(259)).setAttribute("ID","M" );
      ((Element)v.get(252)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(260)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(260)).setAttribute("TIPO","STRING" );
      ((Element)v.get(260)).setAttribute("VALOR","M" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(261)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(261)).setAttribute("TIPO","STRING" );
      ((Element)v.get(261)).setAttribute("VALOR","Mes y año" );
      ((Element)v.get(259)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:259   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:262 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("nombre","valConfSecuCccGapTdId" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(262)).setAttribute("nowrap","true" );
      ((Element)v.get(262)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","25" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:190   */

      /* Empieza nodo:266 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(266)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("align","center" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(271)).setAttribute("align","center" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:266   */

      /* Empieza nodo:273 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(273)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","12" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("width","100%" );
      ((Element)v.get(273)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(277)).setAttribute("width","100%" );
      ((Element)v.get(277)).setAttribute("border","0" );
      ((Element)v.get(277)).setAttribute("cellspacing","0" );
      ((Element)v.get(277)).setAttribute("cellpadding","0" );
      ((Element)v.get(277)).setAttribute("align","left" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(278)).setAttribute("align","left" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).setAttribute("nombre","numDiasFactTdId" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(280)).setAttribute("width","100%" );
      ((Element)v.get(280)).setAttribute("border","0" );
      ((Element)v.get(280)).setAttribute("cellspacing","0" );
      ((Element)v.get(280)).setAttribute("cellpadding","0" );
      ((Element)v.get(280)).setAttribute("align","left" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).setAttribute("valign","top" );
      ((Element)v.get(282)).setAttribute("height","13" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblNumDiasFact" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("id","datosTitle" );
      ((Element)v.get(283)).setAttribute("cod","SegPais.numDiasFact.label" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:284 / Elemento padre: 280   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(284)).setAttribute("nombre","numDiasFactWidgetTrId" );
      ((Element)v.get(280)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("align","left" );
      ((Element)v.get(285)).setAttribute("nowrap","true" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(286)).setAttribute("nombre","numDiasFact" );
      ((Element)v.get(286)).setAttribute("id","datosCampos" );
      ((Element)v.get(286)).setAttribute("trim","S" );
      ((Element)v.get(286)).setAttribute("max","2" );
      ((Element)v.get(286)).setAttribute("onchange","" );
      ((Element)v.get(286)).setAttribute("req","N" );
      ((Element)v.get(286)).setAttribute("size","2" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("validacion","" );
      ((Element)v.get(286)).setAttribute("disabled","" );
      ((Element)v.get(286)).setAttribute("onblur","" );
      ((Element)v.get(286)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',16, true)" );
      ((Element)v.get(286)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 16, false)" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:287 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("nombre","numDiasFactGapTdId" );
      ((Element)v.get(287)).setAttribute("nowrap","true" );
      ((Element)v.get(287)).setAttribute("class","datosCampos" );
      ((Element)v.get(278)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","25" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("nombre","numLimiDifePagoTdId" );
      ((Element)v.get(278)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(290)).setAttribute("border","0" );
      ((Element)v.get(290)).setAttribute("cellspacing","0" );
      ((Element)v.get(290)).setAttribute("cellpadding","0" );
      ((Element)v.get(290)).setAttribute("align","left" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("valign","top" );
      ((Element)v.get(292)).setAttribute("height","13" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(293)).setAttribute("nombre","lblNumLimiDifePago" );
      ((Element)v.get(293)).setAttribute("alto","13" );
      ((Element)v.get(293)).setAttribute("filas","1" );
      ((Element)v.get(293)).setAttribute("id","datosTitle" );
      ((Element)v.get(293)).setAttribute("cod","SegPais.numLimiDifePago.label" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:294 / Elemento padre: 290   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(294)).setAttribute("nombre","numLimiDifePagoWidgetTrId" );
      ((Element)v.get(290)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("align","left" );
      ((Element)v.get(295)).setAttribute("nowrap","true" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(296)).setAttribute("nombre","numLimiDifePago" );
      ((Element)v.get(296)).setAttribute("id","datosCampos" );
      ((Element)v.get(296)).setAttribute("trim","S" );
      ((Element)v.get(296)).setAttribute("max","12" );
      ((Element)v.get(296)).setAttribute("onchange","" );
      ((Element)v.get(296)).setAttribute("req","N" );
      ((Element)v.get(296)).setAttribute("size","12" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(296)).setAttribute("validacion","" );
      ((Element)v.get(296)).setAttribute("disabled","" );
      ((Element)v.get(296)).setAttribute("onblur","" );
      ((Element)v.get(296)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',17, true)" );
      ((Element)v.get(296)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 17, false)" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:297 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("nombre","numLimiDifePagoGapTdId" );
      ((Element)v.get(297)).setAttribute("nowrap","true" );
      ((Element)v.get(297)).setAttribute("class","datosCampos" );
      ((Element)v.get(278)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","25" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(299)).setAttribute("nombre","indEmisVencTdId" );
      ((Element)v.get(278)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(300)).setAttribute("width","100%" );
      ((Element)v.get(300)).setAttribute("border","0" );
      ((Element)v.get(300)).setAttribute("cellspacing","0" );
      ((Element)v.get(300)).setAttribute("cellpadding","0" );
      ((Element)v.get(300)).setAttribute("align","left" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(302)).setAttribute("valign","top" );
      ((Element)v.get(302)).setAttribute("height","13" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(303)).setAttribute("nombre","lblIndEmisVenc" );
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("id","datosTitle" );
      ((Element)v.get(303)).setAttribute("cod","SegPais.indEmisVenc.label" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 300   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(304)).setAttribute("nombre","indEmisVencWidgetTrId" );
      ((Element)v.get(300)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("align","left" );
      ((Element)v.get(305)).setAttribute("nowrap","true" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(306)).setAttribute("nombre","indEmisVenc" );
      ((Element)v.get(306)).setAttribute("tipo","H" );
      ((Element)v.get(306)).setAttribute("req","N" );
      ((Element)v.get(306)).setAttribute("id","datosCampos" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("disabled","" );
      ((Element)v.get(306)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',18, true)" );
      ((Element)v.get(306)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',18, false)" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(307)).setAttribute("id","datosCampos" );
      ((Element)v.get(307)).setAttribute("valor","1" );
      ((Element)v.get(307)).setAttribute("cod","SegPais.indEmisVenc.1.label" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Elemento padre:307 / Elemento actual: 308   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(307)).appendChild((Text)v.get(308));

      /* Termina nodo Texto:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(309)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).setAttribute("valor","0" );
      ((Element)v.get(309)).setAttribute("cod","SegPais.indEmisVenc.0.label" );
      ((Element)v.get(306)).appendChild((Element)v.get(309));

      /* Elemento padre:309 / Elemento actual: 310   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(309)).appendChild((Text)v.get(310));

      /* Termina nodo Texto:310   */
      /* Termina nodo:309   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:311 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(311)).setAttribute("nombre","indEmisVencGapTdId" );
      ((Element)v.get(311)).setAttribute("nowrap","true" );
      ((Element)v.get(311)).setAttribute("class","datosCampos" );
      ((Element)v.get(278)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","25" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("nombre","valMaxiDifeAnlsCombTdId" );
      ((Element)v.get(278)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(314)).setAttribute("border","0" );
      ((Element)v.get(314)).setAttribute("cellspacing","0" );
      ((Element)v.get(314)).setAttribute("cellpadding","0" );
      ((Element)v.get(314)).setAttribute("align","left" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).setAttribute("valign","top" );
      ((Element)v.get(316)).setAttribute("height","13" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(317)).setAttribute("nombre","lblValMaxiDifeAnlsComb" );
      ((Element)v.get(317)).setAttribute("alto","13" );
      ((Element)v.get(317)).setAttribute("filas","1" );
      ((Element)v.get(317)).setAttribute("id","datosTitle" );
      ((Element)v.get(317)).setAttribute("cod","SegPais.valMaxiDifeAnlsComb.label" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:318 / Elemento padre: 314   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(318)).setAttribute("nombre","valMaxiDifeAnlsCombWidgetTrId" );
      ((Element)v.get(314)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("align","left" );
      ((Element)v.get(319)).setAttribute("nowrap","true" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(320)).setAttribute("nombre","valMaxiDifeAnlsComb" );
      ((Element)v.get(320)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).setAttribute("trim","S" );
      ((Element)v.get(320)).setAttribute("max","12" );
      ((Element)v.get(320)).setAttribute("onchange","" );
      ((Element)v.get(320)).setAttribute("req","N" );
      ((Element)v.get(320)).setAttribute("size","12" );
      ((Element)v.get(320)).setAttribute("valor","" );
      ((Element)v.get(320)).setAttribute("validacion","" );
      ((Element)v.get(320)).setAttribute("disabled","" );
      ((Element)v.get(320)).setAttribute("onblur","" );
      ((Element)v.get(320)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',19, true)" );
      ((Element)v.get(320)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 19, false)" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:321 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(321)).setAttribute("nombre","valMaxiDifeAnlsCombGapTdId" );
      ((Element)v.get(321)).setAttribute("nowrap","true" );
      ((Element)v.get(321)).setAttribute("class","datosCampos" );
      ((Element)v.get(278)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("width","100%" );
      ((Element)v.get(278)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:273   */

      /* Empieza nodo:325 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(325)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).setAttribute("align","center" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:325   */

      /* Empieza nodo:332 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(332)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("align","center" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","12" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(336)).setAttribute("border","0" );
      ((Element)v.get(336)).setAttribute("cellspacing","0" );
      ((Element)v.get(336)).setAttribute("cellpadding","0" );
      ((Element)v.get(336)).setAttribute("align","left" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(337)).setAttribute("align","left" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("nombre","numPosiNumeClieTdId" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(339)).setAttribute("width","100%" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(339)).setAttribute("border","0" );
      ((Element)v.get(339)).setAttribute("cellspacing","0" );
      ((Element)v.get(339)).setAttribute("cellpadding","0" );
      ((Element)v.get(339)).setAttribute("align","left" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("valign","top" );
      ((Element)v.get(341)).setAttribute("height","13" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(342)).setAttribute("nombre","lblNumPosiNumeClie" );
      ((Element)v.get(342)).setAttribute("alto","13" );
      ((Element)v.get(342)).setAttribute("filas","1" );
      ((Element)v.get(342)).setAttribute("id","datosTitle" );
      ((Element)v.get(342)).setAttribute("cod","SegPais.numPosiNumeClie.label" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:343 / Elemento padre: 339   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(343)).setAttribute("nombre","numPosiNumeClieWidgetTrId" );
      ((Element)v.get(339)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(344)).setAttribute("align","left" );
      ((Element)v.get(344)).setAttribute("nowrap","true" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(345)).setAttribute("nombre","numPosiNumeClie" );
      ((Element)v.get(345)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).setAttribute("trim","S" );
      ((Element)v.get(345)).setAttribute("max","2" );
      ((Element)v.get(345)).setAttribute("onchange","" );
      ((Element)v.get(345)).setAttribute("req","N" );
      ((Element)v.get(345)).setAttribute("size","2" );
      ((Element)v.get(345)).setAttribute("valor","" );
      ((Element)v.get(345)).setAttribute("validacion","" );
      ((Element)v.get(345)).setAttribute("disabled","" );
      ((Element)v.get(345)).setAttribute("onblur","" );
      ((Element)v.get(345)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',20, true)" );
      ((Element)v.get(345)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 20, false)" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:346 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).setAttribute("nombre","numPosiNumeClieGapTdId" );
      ((Element)v.get(346)).setAttribute("nowrap","true" );
      ((Element)v.get(346)).setAttribute("class","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","25" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("nombre","valFormFechTdId" );
      ((Element)v.get(337)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(349)).setAttribute("width","100%" );
      ((Element)v.get(349)).setAttribute("border","0" );
      ((Element)v.get(349)).setAttribute("cellspacing","0" );
      ((Element)v.get(349)).setAttribute("cellpadding","0" );
      ((Element)v.get(349)).setAttribute("align","left" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("valign","top" );
      ((Element)v.get(351)).setAttribute("height","13" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(352)).setAttribute("nombre","lblValFormFech" );
      ((Element)v.get(352)).setAttribute("ancho","150" );
      ((Element)v.get(352)).setAttribute("alto","13" );
      ((Element)v.get(352)).setAttribute("filas","1" );
      ((Element)v.get(352)).setAttribute("id","datosTitle" );
      ((Element)v.get(352)).setAttribute("cod","SegPais.valFormFech.label" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:353 / Elemento padre: 349   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(353)).setAttribute("nombre","valFormFechWidgetTrId" );
      ((Element)v.get(349)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("align","left" );
      ((Element)v.get(354)).setAttribute("nowrap","true" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(355)).setAttribute("nombre","valFormFech" );
      ((Element)v.get(355)).setAttribute("id","datosCampos" );
      ((Element)v.get(355)).setAttribute("multiple","N" );
      ((Element)v.get(355)).setAttribute("req","N" );
      ((Element)v.get(355)).setAttribute("size","1" );
      ((Element)v.get(355)).setAttribute("validacion","" );
      ((Element)v.get(355)).setAttribute("onchange","" );
      ((Element)v.get(355)).setAttribute("onfocus","" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(355)).setAttribute("valorinicial","" );
      ((Element)v.get(355)).setAttribute("textoinicial","" );
      ((Element)v.get(355)).setAttribute("disabled","" );
      ((Element)v.get(355)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',21, true)" );
      ((Element)v.get(355)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',21, false)" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(357)).setAttribute("ID","dd/mm/yyyy" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(358)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(358)).setAttribute("TIPO","STRING" );
      ((Element)v.get(358)).setAttribute("VALOR","dd/mm/yyyy" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 357   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(359)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(359)).setAttribute("TIPO","STRING" );
      ((Element)v.get(359)).setAttribute("VALOR","dd/mm/aaaa" );
      ((Element)v.get(357)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:357   */

      /* Empieza nodo:360 / Elemento padre: 356   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(360)).setAttribute("ID","mm/dd/yyyy" );
      ((Element)v.get(356)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(361)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(361)).setAttribute("TIPO","STRING" );
      ((Element)v.get(361)).setAttribute("VALOR","mm/dd/yyyy" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 360   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(362)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(362)).setAttribute("TIPO","STRING" );
      ((Element)v.get(362)).setAttribute("VALOR","mm/dd/aaaa" );
      ((Element)v.get(360)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:360   */

      /* Empieza nodo:363 / Elemento padre: 356   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(363)).setAttribute("ID","dd-mm-yyyy" );
      ((Element)v.get(356)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(364)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(364)).setAttribute("TIPO","STRING" );
      ((Element)v.get(364)).setAttribute("VALOR","dd-mm-yyyy" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 363   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(365)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(365)).setAttribute("TIPO","STRING" );
      ((Element)v.get(365)).setAttribute("VALOR","dd-mm-aaaa" );
      ((Element)v.get(363)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:363   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:366 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).setAttribute("nombre","valFormFechGapTdId" );
      ((Element)v.get(366)).setAttribute("nowrap","true" );
      ((Element)v.get(366)).setAttribute("class","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","25" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("nombre","valSepaMileTdId" );
      ((Element)v.get(337)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(369)).setAttribute("width","100%" );
      ((Element)v.get(369)).setAttribute("border","0" );
      ((Element)v.get(369)).setAttribute("cellspacing","0" );
      ((Element)v.get(369)).setAttribute("cellpadding","0" );
      ((Element)v.get(369)).setAttribute("align","left" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("valign","top" );
      ((Element)v.get(371)).setAttribute("height","13" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(372)).setAttribute("nombre","lblValSepaMile" );
      ((Element)v.get(372)).setAttribute("ancho","150" );
      ((Element)v.get(372)).setAttribute("alto","13" );
      ((Element)v.get(372)).setAttribute("filas","1" );
      ((Element)v.get(372)).setAttribute("id","datosTitle" );
      ((Element)v.get(372)).setAttribute("cod","SegPais.valSepaMile.label" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:373 / Elemento padre: 369   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(373)).setAttribute("nombre","valSepaMileWidgetTrId" );
      ((Element)v.get(369)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("align","left" );
      ((Element)v.get(374)).setAttribute("nowrap","true" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(375)).setAttribute("nombre","valSepaMile" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(375)).setAttribute("id","datosCampos" );
      ((Element)v.get(375)).setAttribute("multiple","N" );
      ((Element)v.get(375)).setAttribute("req","N" );
      ((Element)v.get(375)).setAttribute("size","1" );
      ((Element)v.get(375)).setAttribute("validacion","" );
      ((Element)v.get(375)).setAttribute("onchange","" );
      ((Element)v.get(375)).setAttribute("onfocus","" );
      ((Element)v.get(375)).setAttribute("valorinicial","" );
      ((Element)v.get(375)).setAttribute("textoinicial","" );
      ((Element)v.get(375)).setAttribute("disabled","" );
      ((Element)v.get(375)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',22, true)" );
      ((Element)v.get(375)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',22, false)" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(377)).setAttribute("ID","," );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(378)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(378)).setAttribute("TIPO","STRING" );
      ((Element)v.get(378)).setAttribute("VALOR","," );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 377   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(379)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(379)).setAttribute("TIPO","STRING" );
      ((Element)v.get(379)).setAttribute("VALOR","," );
      ((Element)v.get(377)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:377   */

      /* Empieza nodo:380 / Elemento padre: 376   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(380)).setAttribute("ID","." );
      ((Element)v.get(376)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(381)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(381)).setAttribute("TIPO","STRING" );
      ((Element)v.get(381)).setAttribute("VALOR","." );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 380   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(382)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(382)).setAttribute("TIPO","STRING" );
      ((Element)v.get(382)).setAttribute("VALOR","." );
      ((Element)v.get(380)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:380   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:383 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(383)).setAttribute("nombre","valSepaMileGapTdId" );
      ((Element)v.get(383)).setAttribute("nowrap","true" );
      ((Element)v.get(383)).setAttribute("class","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","25" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("nombre","valSepaDeciTdId" );
      ((Element)v.get(337)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(386)).setAttribute("width","100%" );
      ((Element)v.get(386)).setAttribute("border","0" );
      ((Element)v.get(386)).setAttribute("cellspacing","0" );
      ((Element)v.get(386)).setAttribute("cellpadding","0" );
      ((Element)v.get(386)).setAttribute("align","left" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("valign","top" );
      ((Element)v.get(388)).setAttribute("height","13" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(389)).setAttribute("nombre","lblValSepaDeci" );
      ((Element)v.get(389)).setAttribute("ancho","150" );
      ((Element)v.get(389)).setAttribute("alto","13" );
      ((Element)v.get(389)).setAttribute("filas","1" );
      ((Element)v.get(389)).setAttribute("id","datosTitle" );
      ((Element)v.get(389)).setAttribute("cod","SegPais.valSepaDeci.label" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:390 / Elemento padre: 386   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(390)).setAttribute("nombre","valSepaDeciWidgetTrId" );
      ((Element)v.get(386)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("align","left" );
      ((Element)v.get(391)).setAttribute("nowrap","true" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(392)).setAttribute("nombre","valSepaDeci" );
      ((Element)v.get(392)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).setAttribute("multiple","N" );
      ((Element)v.get(392)).setAttribute("req","N" );
      ((Element)v.get(392)).setAttribute("size","1" );
      ((Element)v.get(392)).setAttribute("validacion","" );
      ((Element)v.get(392)).setAttribute("onchange","" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(392)).setAttribute("onfocus","" );
      ((Element)v.get(392)).setAttribute("valorinicial","" );
      ((Element)v.get(392)).setAttribute("textoinicial","" );
      ((Element)v.get(392)).setAttribute("disabled","" );
      ((Element)v.get(392)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',23, true)" );
      ((Element)v.get(392)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',23, false)" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(394)).setAttribute("ID","," );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(395)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(395)).setAttribute("TIPO","STRING" );
      ((Element)v.get(395)).setAttribute("VALOR","," );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 394   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(396)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(396)).setAttribute("TIPO","STRING" );
      ((Element)v.get(396)).setAttribute("VALOR","," );
      ((Element)v.get(394)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:394   */

      /* Empieza nodo:397 / Elemento padre: 393   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(397)).setAttribute("ID","." );
      ((Element)v.get(393)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(398)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(398)).setAttribute("TIPO","STRING" );
      ((Element)v.get(398)).setAttribute("VALOR","." );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 397   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(399)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(399)).setAttribute("TIPO","STRING" );
      ((Element)v.get(399)).setAttribute("VALOR","." );
      ((Element)v.get(397)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:397   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:400 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(400)).setAttribute("nombre","valSepaDeciGapTdId" );
      ((Element)v.get(400)).setAttribute("nowrap","true" );
      ((Element)v.get(400)).setAttribute("class","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("nombre","numPeriEgreTdId" );
      ((Element)v.get(337)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(403)).setAttribute("width","100%" );
      ((Element)v.get(403)).setAttribute("border","0" );
      ((Element)v.get(403)).setAttribute("cellspacing","0" );
      ((Element)v.get(403)).setAttribute("cellpadding","0" );
      ((Element)v.get(403)).setAttribute("align","left" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(405)).setAttribute("valign","top" );
      ((Element)v.get(405)).setAttribute("height","13" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(406)).setAttribute("nombre","lblNumPeriEgre" );
      ((Element)v.get(406)).setAttribute("alto","13" );
      ((Element)v.get(406)).setAttribute("filas","1" );
      ((Element)v.get(406)).setAttribute("id","datosTitle" );
      ((Element)v.get(406)).setAttribute("cod","SegPais.numPeriEgre.label" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:407 / Elemento padre: 403   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(407)).setAttribute("nombre","numPeriEgreWidgetTrId" );
      ((Element)v.get(403)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(408)).setAttribute("align","left" );
      ((Element)v.get(408)).setAttribute("nowrap","true" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(409)).setAttribute("nombre","numPeriEgre" );
      ((Element)v.get(409)).setAttribute("id","datosCampos" );
      ((Element)v.get(409)).setAttribute("trim","S" );
      ((Element)v.get(409)).setAttribute("max","2" );
      ((Element)v.get(409)).setAttribute("onchange","" );
      ((Element)v.get(409)).setAttribute("req","N" );
      ((Element)v.get(409)).setAttribute("size","2" );
      ((Element)v.get(409)).setAttribute("valor","" );
      ((Element)v.get(409)).setAttribute("validacion","" );
      ((Element)v.get(409)).setAttribute("disabled","" );
      ((Element)v.get(409)).setAttribute("onblur","" );
      ((Element)v.get(409)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',24, true)" );
      ((Element)v.get(409)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 24, false)" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:410 / Elemento padre: 337   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("nombre","numPeriEgreGapTdId" );
      ((Element)v.get(410)).setAttribute("nowrap","true" );
      ((Element)v.get(410)).setAttribute("class","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","25" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("width","100%" );
      ((Element)v.get(337)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:332   */

      /* Empieza nodo:414 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(414)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("align","center" );
      ((Element)v.get(415)).setAttribute("width","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","12" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(414)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","8" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).setAttribute("align","center" );
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","12" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:414   */

      /* Empieza nodo:421 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(421)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(422)).setAttribute("align","center" );
      ((Element)v.get(422)).setAttribute("width","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","12" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).setAttribute("width","100%" );
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(425)).setAttribute("border","0" );
      ((Element)v.get(425)).setAttribute("cellspacing","0" );
      ((Element)v.get(425)).setAttribute("cellpadding","0" );
      ((Element)v.get(425)).setAttribute("align","left" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(426)).setAttribute("align","left" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(427)).setAttribute("nombre","numPeriRetiTdId" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(428)).setAttribute("border","0" );
      ((Element)v.get(428)).setAttribute("cellspacing","0" );
      ((Element)v.get(428)).setAttribute("cellpadding","0" );
      ((Element)v.get(428)).setAttribute("align","left" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(430)).setAttribute("valign","top" );
      ((Element)v.get(430)).setAttribute("height","13" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(431)).setAttribute("nombre","lblNumPeriReti" );
      ((Element)v.get(431)).setAttribute("alto","13" );
      ((Element)v.get(431)).setAttribute("filas","1" );
      ((Element)v.get(431)).setAttribute("id","datosTitle" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(431)).setAttribute("cod","SegPais.numPeriReti.label" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:432 / Elemento padre: 428   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(432)).setAttribute("nombre","numPeriRetiWidgetTrId" );
      ((Element)v.get(428)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).setAttribute("align","left" );
      ((Element)v.get(433)).setAttribute("nowrap","true" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(434)).setAttribute("nombre","numPeriReti" );
      ((Element)v.get(434)).setAttribute("id","datosCampos" );
      ((Element)v.get(434)).setAttribute("trim","S" );
      ((Element)v.get(434)).setAttribute("max","2" );
      ((Element)v.get(434)).setAttribute("onchange","" );
      ((Element)v.get(434)).setAttribute("req","N" );
      ((Element)v.get(434)).setAttribute("size","2" );
      ((Element)v.get(434)).setAttribute("valor","" );
      ((Element)v.get(434)).setAttribute("validacion","" );
      ((Element)v.get(434)).setAttribute("disabled","" );
      ((Element)v.get(434)).setAttribute("onblur","" );
      ((Element)v.get(434)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',25, true)" );
      ((Element)v.get(434)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 25, false)" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:435 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(435)).setAttribute("nombre","numPeriRetiGapTdId" );
      ((Element)v.get(435)).setAttribute("nowrap","true" );
      ((Element)v.get(435)).setAttribute("class","datosCampos" );
      ((Element)v.get(426)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(436)).setAttribute("src","b.gif" );
      ((Element)v.get(436)).setAttribute("width","25" );
      ((Element)v.get(436)).setAttribute("height","8" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(437)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(426)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(438)).setAttribute("border","0" );
      ((Element)v.get(438)).setAttribute("cellspacing","0" );
      ((Element)v.get(438)).setAttribute("cellpadding","0" );
      ((Element)v.get(438)).setAttribute("align","left" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(440)).setAttribute("valign","top" );
      ((Element)v.get(440)).setAttribute("height","13" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(441)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(441)).setAttribute("id","datosTitle" );
      ((Element)v.get(441)).setAttribute("ancho","150" );
      ((Element)v.get(441)).setAttribute("alto","13" );
      ((Element)v.get(441)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:442 / Elemento padre: 438   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(442)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(438)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("align","left" );
      ((Element)v.get(443)).setAttribute("nowrap","true" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(444)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(444)).setAttribute("id","datosCampos" );
      ((Element)v.get(444)).setAttribute("multiple","N" );
      ((Element)v.get(444)).setAttribute("req","N" );
      ((Element)v.get(444)).setAttribute("size","1" );
      ((Element)v.get(444)).setAttribute("disabled","" );
      ((Element)v.get(444)).setAttribute("validacion","" );
      ((Element)v.get(444)).setAttribute("onchange","" );
      ((Element)v.get(444)).setAttribute("onfocus","" );
      ((Element)v.get(444)).setAttribute("valorinicial","" );
      ((Element)v.get(444)).setAttribute("textoinicial","" );
      ((Element)v.get(444)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',26, true);" );
      ((Element)v.get(444)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',26, false);" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:446 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(446)).setAttribute("nowrap","true" );
      ((Element)v.get(446)).setAttribute("class","datosCampos" );
      ((Element)v.get(426)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","25" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 426   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(448)).setAttribute("nombre","valCompTeleTdId" );
      ((Element)v.get(426)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(449)).setAttribute("width","100%" );
      ((Element)v.get(449)).setAttribute("border","0" );
      ((Element)v.get(449)).setAttribute("cellspacing","0" );
      ((Element)v.get(449)).setAttribute("cellpadding","0" );
      ((Element)v.get(449)).setAttribute("align","left" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(451)).setAttribute("valign","top" );
      ((Element)v.get(451)).setAttribute("height","13" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(452)).setAttribute("nombre","lblValCompTele" );
      ((Element)v.get(452)).setAttribute("alto","13" );
      ((Element)v.get(452)).setAttribute("filas","1" );
      ((Element)v.get(452)).setAttribute("id","datosTitle" );
      ((Element)v.get(452)).setAttribute("cod","SegPais.valCompTele.label" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 449   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(453)).setAttribute("nombre","valCompTeleWidgetTrId" );
      ((Element)v.get(449)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("align","left" );
      ((Element)v.get(454)).setAttribute("nowrap","true" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(455)).setAttribute("nombre","valCompTele" );
      ((Element)v.get(455)).setAttribute("id","datosCampos" );
      ((Element)v.get(455)).setAttribute("trim","S" );
      ((Element)v.get(455)).setAttribute("max","40" );
      ((Element)v.get(455)).setAttribute("onchange","" );
      ((Element)v.get(455)).setAttribute("req","N" );
      ((Element)v.get(455)).setAttribute("size","40" );
      ((Element)v.get(455)).setAttribute("valor","" );
      ((Element)v.get(455)).setAttribute("validacion","" );
      ((Element)v.get(455)).setAttribute("disabled","" );
      ((Element)v.get(455)).setAttribute("onblur","" );
      ((Element)v.get(455)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',27, true)" );
      ((Element)v.get(455)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm', 27, false)" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:456 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(456)).setAttribute("nombre","valCompTeleGapTdId" );
      ((Element)v.get(456)).setAttribute("nowrap","true" );
      ((Element)v.get(456)).setAttribute("class","datosCampos" );
      ((Element)v.get(426)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","25" );
      ((Element)v.get(457)).setAttribute("height","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(458)).setAttribute("width","100%" );
      ((Element)v.get(426)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:421   */

      /* Empieza nodo:460 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(460)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(461)).setAttribute("align","center" );
      ((Element)v.get(461)).setAttribute("width","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","12" );
      ((Element)v.get(462)).setAttribute("height","8" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 460   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).setAttribute("width","8" );
      ((Element)v.get(464)).setAttribute("height","8" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 460   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(465)).setAttribute("align","center" );
      ((Element)v.get(465)).setAttribute("width","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","12" );
      ((Element)v.get(466)).setAttribute("height","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:460   */

      /* Empieza nodo:467 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(467)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("align","center" );
      ((Element)v.get(468)).setAttribute("width","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","12" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(471)).setAttribute("width","100%" );
      ((Element)v.get(471)).setAttribute("border","0" );
      ((Element)v.get(471)).setAttribute("cellspacing","0" );
      ((Element)v.get(471)).setAttribute("cellpadding","0" );
      ((Element)v.get(471)).setAttribute("align","left" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(472)).setAttribute("align","left" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("nombre","indFletZonaUbigTdId" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(474)).setAttribute("width","100%" );
      ((Element)v.get(474)).setAttribute("border","0" );
      ((Element)v.get(474)).setAttribute("cellspacing","0" );
      ((Element)v.get(474)).setAttribute("cellpadding","0" );
      ((Element)v.get(474)).setAttribute("align","left" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(476)).setAttribute("valign","top" );
      ((Element)v.get(476)).setAttribute("height","13" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(477)).setAttribute("nombre","lblIndFletZonaUbig" );
      ((Element)v.get(477)).setAttribute("ancho","150" );
      ((Element)v.get(477)).setAttribute("alto","13" );
      ((Element)v.get(477)).setAttribute("filas","1" );
      ((Element)v.get(477)).setAttribute("id","datosTitle" );
      ((Element)v.get(477)).setAttribute("cod","SegPais.indFletZonaUbig.label" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:478 / Elemento padre: 474   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(478)).setAttribute("nombre","indFletZonaUbigWidgetTrId" );
      ((Element)v.get(474)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("align","left" );
      ((Element)v.get(479)).setAttribute("nowrap","true" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(480)).setAttribute("nombre","indFletZonaUbig" );
      ((Element)v.get(480)).setAttribute("id","datosCampos" );
      ((Element)v.get(480)).setAttribute("multiple","N" );
      ((Element)v.get(480)).setAttribute("req","N" );
      ((Element)v.get(480)).setAttribute("size","1" );
      ((Element)v.get(480)).setAttribute("validacion","" );
      ((Element)v.get(480)).setAttribute("onchange","" );
      ((Element)v.get(480)).setAttribute("onfocus","" );
      ((Element)v.get(480)).setAttribute("valorinicial","" );
      ((Element)v.get(480)).setAttribute("textoinicial","" );
      ((Element)v.get(480)).setAttribute("disabled","" );
      ((Element)v.get(480)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',28, true)" );
      ((Element)v.get(480)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',28, false)" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(482)).setAttribute("ID","U" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(483)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(483)).setAttribute("TIPO","STRING" );
      ((Element)v.get(483)).setAttribute("VALOR","U" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 482   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(484)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(484)).setAttribute("TIPO","STRING" );
      ((Element)v.get(484)).setAttribute("VALOR","Ubigeo" );
      ((Element)v.get(482)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:482   */

      /* Empieza nodo:485 / Elemento padre: 481   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(485)).setAttribute("ID","Z" );
      ((Element)v.get(481)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(486)).setAttribute("NOMBRE","CODIGO" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(486)).setAttribute("TIPO","STRING" );
      ((Element)v.get(486)).setAttribute("VALOR","Z" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 485   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(487)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(487)).setAttribute("TIPO","STRING" );
      ((Element)v.get(487)).setAttribute("VALOR","Zona" );
      ((Element)v.get(485)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:485   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:488 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(488)).setAttribute("nombre","indFletZonaUbigGapTdId" );
      ((Element)v.get(488)).setAttribute("nowrap","true" );
      ((Element)v.get(488)).setAttribute("class","datosCampos" );
      ((Element)v.get(472)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","25" );
      ((Element)v.get(489)).setAttribute("height","8" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(490)).setAttribute("nombre","valIndiSecuMoniTdId" );
      ((Element)v.get(472)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(491)).setAttribute("width","100%" );
      ((Element)v.get(491)).setAttribute("border","0" );
      ((Element)v.get(491)).setAttribute("cellspacing","0" );
      ((Element)v.get(491)).setAttribute("cellpadding","0" );
      ((Element)v.get(491)).setAttribute("align","left" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(493)).setAttribute("valign","top" );
      ((Element)v.get(493)).setAttribute("height","13" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(494)).setAttribute("nombre","lblValIndiSecuMoni" );
      ((Element)v.get(494)).setAttribute("alto","13" );
      ((Element)v.get(494)).setAttribute("filas","1" );
      ((Element)v.get(494)).setAttribute("id","datosTitle" );
      ((Element)v.get(494)).setAttribute("cod","SegPais.valIndiSecuMoni.label" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:495 / Elemento padre: 491   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(495)).setAttribute("nombre","valIndiSecuMoniWidgetTrId" );
      ((Element)v.get(491)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(496)).setAttribute("align","left" );
      ((Element)v.get(496)).setAttribute("nowrap","true" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(497)).setAttribute("nombre","valIndiSecuMoni" );
      ((Element)v.get(497)).setAttribute("tipo","H" );
      ((Element)v.get(497)).setAttribute("req","N" );
      ((Element)v.get(497)).setAttribute("id","datosCampos" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(497)).setAttribute("disabled","" );
      ((Element)v.get(497)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',29, true)" );
      ((Element)v.get(497)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',29, false)" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(498)).setAttribute("id","datosCampos" );
      ((Element)v.get(498)).setAttribute("valor","1" );
      ((Element)v.get(498)).setAttribute("cod","SegPais.valIndiSecuMoni.1.label" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Elemento padre:498 / Elemento actual: 499   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(498)).appendChild((Text)v.get(499));

      /* Termina nodo Texto:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 497   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(500)).setAttribute("id","datosCampos" );
      ((Element)v.get(500)).setAttribute("valor","0" );
      ((Element)v.get(500)).setAttribute("cod","SegPais.valIndiSecuMoni.0.label" );
      ((Element)v.get(497)).appendChild((Element)v.get(500));

      /* Elemento padre:500 / Elemento actual: 501   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(500)).appendChild((Text)v.get(501));

      /* Termina nodo Texto:501   */
      /* Termina nodo:500   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:502 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("nombre","valIndiSecuMoniGapTdId" );
      ((Element)v.get(502)).setAttribute("nowrap","true" );
      ((Element)v.get(502)).setAttribute("class","datosCampos" );
      ((Element)v.get(472)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","25" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).setAttribute("nombre","indSecuTdId" );
      ((Element)v.get(472)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(505)).setAttribute("width","100%" );
      ((Element)v.get(505)).setAttribute("border","0" );
      ((Element)v.get(505)).setAttribute("cellspacing","0" );
      ((Element)v.get(505)).setAttribute("cellpadding","0" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(505)).setAttribute("align","left" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(507)).setAttribute("valign","top" );
      ((Element)v.get(507)).setAttribute("height","13" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(508)).setAttribute("nombre","lblIndSecu" );
      ((Element)v.get(508)).setAttribute("ancho","150" );
      ((Element)v.get(508)).setAttribute("alto","13" );
      ((Element)v.get(508)).setAttribute("filas","1" );
      ((Element)v.get(508)).setAttribute("id","datosTitle" );
      ((Element)v.get(508)).setAttribute("cod","SegPais.indSecu.label" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:509 / Elemento padre: 505   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(509)).setAttribute("nombre","indSecuWidgetTrId" );
      ((Element)v.get(505)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(510)).setAttribute("align","left" );
      ((Element)v.get(510)).setAttribute("nowrap","true" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(511)).setAttribute("nombre","indSecu" );
      ((Element)v.get(511)).setAttribute("id","datosCampos" );
      ((Element)v.get(511)).setAttribute("multiple","N" );
      ((Element)v.get(511)).setAttribute("req","N" );
      ((Element)v.get(511)).setAttribute("size","1" );
      ((Element)v.get(511)).setAttribute("validacion","" );
      ((Element)v.get(511)).setAttribute("onchange","" );
      ((Element)v.get(511)).setAttribute("onfocus","" );
      ((Element)v.get(511)).setAttribute("valorinicial","" );
      ((Element)v.get(511)).setAttribute("textoinicial","" );
      ((Element)v.get(511)).setAttribute("disabled","" );
      ((Element)v.get(511)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',30, true)" );
      ((Element)v.get(511)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',30, false)" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(513)).setAttribute("ID","M" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(514)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(514)).setAttribute("TIPO","STRING" );
      ((Element)v.get(514)).setAttribute("VALOR","M" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 513   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(515)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(515)).setAttribute("TIPO","STRING" );
      ((Element)v.get(515)).setAttribute("VALOR","Monto" );
      ((Element)v.get(513)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:513   */

      /* Empieza nodo:516 / Elemento padre: 512   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(516)).setAttribute("ID","T" );
      ((Element)v.get(512)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(517)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(517)).setAttribute("TIPO","STRING" );
      ((Element)v.get(517)).setAttribute("VALOR","T" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 516   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(518)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(518)).setAttribute("TIPO","STRING" );
      ((Element)v.get(518)).setAttribute("VALOR","Transporte" );
      ((Element)v.get(516)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:516   */

      /* Empieza nodo:519 / Elemento padre: 512   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(519)).setAttribute("ID","I" );
      ((Element)v.get(512)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(520)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(520)).setAttribute("TIPO","STRING" );
      ((Element)v.get(520)).setAttribute("VALOR","I" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 519   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(521)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(521)).setAttribute("TIPO","STRING" );
      ((Element)v.get(521)).setAttribute("VALOR","Inicio" );
      ((Element)v.get(519)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:519   */

      /* Empieza nodo:522 / Elemento padre: 512   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(522)).setAttribute("ID","F" );
      ((Element)v.get(512)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(523)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(523)).setAttribute("TIPO","STRING" );
      ((Element)v.get(523)).setAttribute("VALOR","F" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 522   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(524)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(524)).setAttribute("TIPO","STRING" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(524)).setAttribute("VALOR","Final" );
      ((Element)v.get(522)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:522   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:525 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).setAttribute("nombre","indSecuGapTdId" );
      ((Element)v.get(525)).setAttribute("nowrap","true" );
      ((Element)v.get(525)).setAttribute("class","datosCampos" );
      ((Element)v.get(472)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).setAttribute("width","25" );
      ((Element)v.get(526)).setAttribute("height","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:527 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(527)).setAttribute("nombre","indBalaAreaCheqTdId" );
      ((Element)v.get(472)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(528)).setAttribute("border","0" );
      ((Element)v.get(528)).setAttribute("cellspacing","0" );
      ((Element)v.get(528)).setAttribute("cellpadding","0" );
      ((Element)v.get(528)).setAttribute("align","left" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(530)).setAttribute("valign","top" );
      ((Element)v.get(530)).setAttribute("height","13" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(531)).setAttribute("nombre","lblIndBalaAreaCheq" );
      ((Element)v.get(531)).setAttribute("ancho","150" );
      ((Element)v.get(531)).setAttribute("alto","13" );
      ((Element)v.get(531)).setAttribute("filas","1" );
      ((Element)v.get(531)).setAttribute("id","datosTitle" );
      ((Element)v.get(531)).setAttribute("cod","SegPais.indBalaAreaCheq.label" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:532 / Elemento padre: 528   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(532)).setAttribute("nombre","indBalaAreaCheqWidgetTrId" );
      ((Element)v.get(528)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(533)).setAttribute("align","left" );
      ((Element)v.get(533)).setAttribute("nowrap","true" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(534)).setAttribute("nombre","indBalaAreaCheq" );
      ((Element)v.get(534)).setAttribute("id","datosCampos" );
      ((Element)v.get(534)).setAttribute("multiple","N" );
      ((Element)v.get(534)).setAttribute("req","N" );
      ((Element)v.get(534)).setAttribute("size","1" );
      ((Element)v.get(534)).setAttribute("validacion","" );
      ((Element)v.get(534)).setAttribute("onchange","" );
      ((Element)v.get(534)).setAttribute("onfocus","" );
      ((Element)v.get(534)).setAttribute("valorinicial","" );
      ((Element)v.get(534)).setAttribute("textoinicial","" );
      ((Element)v.get(534)).setAttribute("disabled","" );
      ((Element)v.get(534)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',31, true)" );
      ((Element)v.get(534)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',31, false)" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(536)).setAttribute("ID","P" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(537)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(537)).setAttribute("TIPO","STRING" );
      ((Element)v.get(537)).setAttribute("VALOR","P" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 536   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(538)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(538)).setAttribute("TIPO","STRING" );
      ((Element)v.get(538)).setAttribute("VALOR","MODELO PERU" );
      ((Element)v.get(536)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:536   */

      /* Empieza nodo:539 / Elemento padre: 535   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(539)).setAttribute("ID","C" );
      ((Element)v.get(535)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(540)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(540)).setAttribute("TIPO","STRING" );
      ((Element)v.get(540)).setAttribute("VALOR","C" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 539   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(541)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(541)).setAttribute("TIPO","STRING" );
      ((Element)v.get(541)).setAttribute("VALOR","MODELO COLOMBIA" );
      ((Element)v.get(539)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:539   */
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:542 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(542)).setAttribute("nombre","indBalaAreaCheqGapTdId" );
      ((Element)v.get(542)).setAttribute("nowrap","true" );
      ((Element)v.get(542)).setAttribute("class","datosCampos" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(472)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","25" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("width","100%" );
      ((Element)v.get(472)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:467   */

      /* Empieza nodo:546 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(546)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(547)).setAttribute("align","center" );
      ((Element)v.get(547)).setAttribute("width","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","12" );
      ((Element)v.get(548)).setAttribute("height","8" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 546   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","8" );
      ((Element)v.get(550)).setAttribute("height","8" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 546   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("align","center" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","12" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:546   */

      /* Empieza nodo:553 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(553)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(554)).setAttribute("align","center" );
      ((Element)v.get(554)).setAttribute("width","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(555)).setAttribute("src","b.gif" );
      ((Element)v.get(555)).setAttribute("width","8" );
      ((Element)v.get(555)).setAttribute("height","12" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(556)).setAttribute("width","100%" );
      ((Element)v.get(553)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(557)).setAttribute("width","100%" );
      ((Element)v.get(557)).setAttribute("border","0" );
      ((Element)v.get(557)).setAttribute("cellspacing","0" );
      ((Element)v.get(557)).setAttribute("cellpadding","0" );
      ((Element)v.get(557)).setAttribute("align","left" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(558)).setAttribute("align","left" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(559)).setAttribute("nombre","valUrlTdId" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(560)).setAttribute("width","100%" );
      ((Element)v.get(560)).setAttribute("border","0" );
      ((Element)v.get(560)).setAttribute("cellspacing","0" );
      ((Element)v.get(560)).setAttribute("cellpadding","0" );
      ((Element)v.get(560)).setAttribute("align","left" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).setAttribute("valign","top" );
      ((Element)v.get(562)).setAttribute("height","13" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(563)).setAttribute("nombre","lblValUrl" );
      ((Element)v.get(563)).setAttribute("alto","13" );
      ((Element)v.get(563)).setAttribute("filas","1" );
      ((Element)v.get(563)).setAttribute("id","datosTitle" );
      ((Element)v.get(563)).setAttribute("cod","SegPais.valUrl.label" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:564 / Elemento padre: 560   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(564)).setAttribute("nombre","valUrlWidgetTrId" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(560)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(565)).setAttribute("align","left" );
      ((Element)v.get(565)).setAttribute("nowrap","true" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(566)).setAttribute("nombre","valUrl" );
      ((Element)v.get(566)).setAttribute("valor","" );
      ((Element)v.get(566)).setAttribute("rows","3" );
      ((Element)v.get(566)).setAttribute("cols","40" );
      ((Element)v.get(566)).setAttribute("validacion","" );
      ((Element)v.get(566)).setAttribute("disabled","" );
      ((Element)v.get(566)).setAttribute("req","N" );
      ((Element)v.get(566)).setAttribute("id","datosCampos" );
      ((Element)v.get(566)).setAttribute("onblur","" );
      ((Element)v.get(566)).setAttribute("onfocus","" );
      ((Element)v.get(566)).setAttribute("onchange","" );
      ((Element)v.get(566)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',32, true)" );
      ((Element)v.get(566)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',32, false)" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:564   */
      /* Termina nodo:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:567 / Elemento padre: 558   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(567)).setAttribute("nombre","valUrlGapTdId" );
      ((Element)v.get(567)).setAttribute("nowrap","true" );
      ((Element)v.get(567)).setAttribute("class","datosCampos" );
      ((Element)v.get(558)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).setAttribute("width","25" );
      ((Element)v.get(568)).setAttribute("height","8" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 558   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("nombre","indImpuInclTdId" );
      ((Element)v.get(558)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(570)).setAttribute("width","100%" );
      ((Element)v.get(570)).setAttribute("border","0" );
      ((Element)v.get(570)).setAttribute("cellspacing","0" );
      ((Element)v.get(570)).setAttribute("cellpadding","0" );
      ((Element)v.get(570)).setAttribute("align","left" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(572)).setAttribute("valign","top" );
      ((Element)v.get(572)).setAttribute("height","13" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(573)).setAttribute("nombre","lblIndImpuIncl" );
      ((Element)v.get(573)).setAttribute("alto","13" );
      ((Element)v.get(573)).setAttribute("filas","1" );
      ((Element)v.get(573)).setAttribute("id","datosTitle" );
      ((Element)v.get(573)).setAttribute("cod","SegPais.indImpuIncl.label" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:574 / Elemento padre: 570   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(574)).setAttribute("nombre","indImpuInclWidgetTrId" );
      ((Element)v.get(570)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(575)).setAttribute("align","left" );
      ((Element)v.get(575)).setAttribute("nowrap","true" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(576)).setAttribute("nombre","indImpuIncl" );
      ((Element)v.get(576)).setAttribute("tipo","H" );
      ((Element)v.get(576)).setAttribute("req","N" );
      ((Element)v.get(576)).setAttribute("id","datosCampos" );
      ((Element)v.get(576)).setAttribute("valor","" );
      ((Element)v.get(576)).setAttribute("disabled","" );
      ((Element)v.get(576)).setAttribute("ontab","ejecutarAccionFoco('segPaisFrm',33, true)" );
      ((Element)v.get(576)).setAttribute("onshtab","ejecutarAccionFoco('segPaisFrm',33, false)" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(577)).setAttribute("id","datosCampos" );
      ((Element)v.get(577)).setAttribute("valor","1" );
      ((Element)v.get(577)).setAttribute("cod","SegPais.indImpuIncl.1.label" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Elemento padre:577 / Elemento actual: 578   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(577)).appendChild((Text)v.get(578));

      /* Termina nodo Texto:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:579 / Elemento padre: 576   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(579)).setAttribute("id","datosCampos" );
      ((Element)v.get(579)).setAttribute("valor","0" );
      ((Element)v.get(579)).setAttribute("cod","SegPais.indImpuIncl.0.label" );
      ((Element)v.get(576)).appendChild((Element)v.get(579));

      /* Elemento padre:579 / Elemento actual: 580   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(579)).appendChild((Text)v.get(580));

      /* Termina nodo Texto:580   */
      /* Termina nodo:579   */
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:581 / Elemento padre: 558   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(581)).setAttribute("nombre","indImpuInclGapTdId" );
      ((Element)v.get(581)).setAttribute("nowrap","true" );
      ((Element)v.get(581)).setAttribute("class","datosCampos" );
      ((Element)v.get(558)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).setAttribute("width","25" );
      ((Element)v.get(582)).setAttribute("height","8" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:583 / Elemento padre: 558   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("width","100%" );
      ((Element)v.get(558)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:585 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(585)).setAttribute("width","100%" );
      ((Element)v.get(553)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:553   */

      /* Empieza nodo:586 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(586)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(587)).setAttribute("align","center" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","8" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 586   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(586)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(590)).setAttribute("width","8" );
      ((Element)v.get(590)).setAttribute("height","8" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 586   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("align","center" );
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","8" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:586   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:593 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(593)).setAttribute("align","center" );
      ((Element)v.get(593)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).setAttribute("width","12" );
      ((Element)v.get(594)).setAttribute("height","12" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:8   */

      /* Empieza nodo:595 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(595)).setAttribute("nombre","segPaisTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(596)).setAttribute("align","center" );
      ((Element)v.get(596)).setAttribute("width","12" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","12" );
      ((Element)v.get(597)).setAttribute("height","12" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(600)).setAttribute("width","100%" );
      ((Element)v.get(600)).setAttribute("border","0" );
      ((Element)v.get(600)).setAttribute("align","center" );
      ((Element)v.get(600)).setAttribute("cellspacing","0" );
      ((Element)v.get(600)).setAttribute("cellpadding","0" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(602)).setAttribute("class","tablaTitle" );
      ((Element)v.get(602)).setAttribute("nombre","segPaisTdQueryButton" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(603)).setAttribute("nombre","segPaisQueryButton" );
      ((Element)v.get(603)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(603)).setAttribute("estado","false" );
      ((Element)v.get(603)).setAttribute("accion","segPaisFirstPage();" );
      ((Element)v.get(603)).setAttribute("tipo","html" );
      ((Element)v.get(603)).setAttribute("ID","botonContenido" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(604)).setAttribute("class","tablaTitle" );
      ((Element)v.get(604)).setAttribute("nombre","segPaisTdLovNullSelectionButton" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(604)).setAttribute("align","left" );
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(601)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("height","8" );
      ((Element)v.get(605)).setAttribute("width","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */

      /* Empieza nodo:606 / Elemento padre: 604   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(606)).setAttribute("nombre","segPaisLovNullButton" );
      ((Element)v.get(606)).setAttribute("ID","botonContenido" );
      ((Element)v.get(606)).setAttribute("tipo","html" );
      ((Element)v.get(606)).setAttribute("accion","segPaisLovNullSelectionAction();" );
      ((Element)v.get(606)).setAttribute("estado","true" );
      ((Element)v.get(606)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(604)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:604   */
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:607 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(607)).setAttribute("align","center" );
      ((Element)v.get(607)).setAttribute("width","12" );
      ((Element)v.get(595)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","12" );
      ((Element)v.get(608)).setAttribute("height","12" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */
      /* Termina nodo:595   */


   }

}
