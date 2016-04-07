
import org.w3c.dom.*;
import java.util.ArrayList;

public class CarSoliEntrBloqPageForm  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML3330(doc);
         

      getXML3420(doc);
         

      getXML3510(doc);
         

      getXML3600(doc);
         

      getXML3690(doc);
         

      getXML3780(doc);
         
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
      ((Element)v.get(14)).setAttribute("cod","CarSoliEntrBloq.legend.label" );
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
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("width","12" );
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
      ((Element)v.get(29)).setAttribute("cod","CarSoliEntrBloq.id.label" );
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
      ((Element)v.get(32)).setAttribute("onblur","" );
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:33 / Elemento padre: 26   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(33)).setAttribute("nombre","idViewLabelTrId" );
      ((Element)v.get(26)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(34)).setAttribute("valign","top" );
      ((Element)v.get(34)).setAttribute("height","13" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblViewId" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("id","EstDat" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:36 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(36)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(36)).setAttribute("nowrap","true" );
      ((Element)v.get(36)).setAttribute("class","datosCampos" );
      ((Element)v.get(24)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","25" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(24)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:19   */

      /* Empieza nodo:40 / Elemento padre: 15   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(40)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(15)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:40   */

      /* Empieza nodo:47 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(47)).setAttribute("nombre","formTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

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
      ((Element)v.get(52)).setAttribute("align","left" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("nombre","paisOidPais_moneOidMoneAltTdId" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).setAttribute("align","left" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("valign","top" );
      ((Element)v.get(56)).setAttribute("height","13" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblpaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("ancho","100" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(58)).setAttribute("nombre","paisOidPais_moneOidMoneAltWidgetTrId" );
      ((Element)v.get(54)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(59)).setAttribute("align","left" );
      ((Element)v.get(59)).setAttribute("nowrap","true" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(60)).setAttribute("nombre","paisOidPais_moneOidMoneAlt" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("multiple","N" );
      ((Element)v.get(60)).setAttribute("req","N" );
      ((Element)v.get(60)).setAttribute("size","1" );
      ((Element)v.get(60)).setAttribute("validacion","" );
      ((Element)v.get(60)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'carSoliEntrBloq')" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(60)).setAttribute("onfocus","" );
      ((Element)v.get(60)).setAttribute("valorinicial","" );
      ((Element)v.get(60)).setAttribute("textoinicial","" );
      ((Element)v.get(60)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(60)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(62)).setAttribute("nombre","paisOidPais_moneOidMoneAltViewLabelTrId" );
      ((Element)v.get(54)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(63)).setAttribute("valign","top" );
      ((Element)v.get(63)).setAttribute("height","13" );
      ((Element)v.get(63)).setAttribute("width","30" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblViewPaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("id","EstDat" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:65 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(65)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(65)).setAttribute("nowrap","true" );
      ((Element)v.get(65)).setAttribute("class","datosCampos" );
      ((Element)v.get(52)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(67)).setAttribute("nombre","paisOidPais_moneOidMoneTdId" );
      ((Element)v.get(52)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("valign","top" );
      ((Element)v.get(70)).setAttribute("height","13" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblpaisOidPais_moneOidMone" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("ancho","100" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:72 / Elemento padre: 68   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(72)).setAttribute("nombre","paisOidPais_moneOidMoneWidgetTrId" );
      ((Element)v.get(68)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(73)).setAttribute("nowrap","true" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(74)).setAttribute("nombre","paisOidPais_moneOidMone" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("multiple","N" );
      ((Element)v.get(74)).setAttribute("req","N" );
      ((Element)v.get(74)).setAttribute("size","1" );
      ((Element)v.get(74)).setAttribute("validacion","" );
      ((Element)v.get(74)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'carSoliEntrBloq')" );
      ((Element)v.get(74)).setAttribute("onfocus","" );
      ((Element)v.get(74)).setAttribute("valorinicial","" );
      ((Element)v.get(74)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(74)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:76 / Elemento padre: 68   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(76)).setAttribute("nombre","paisOidPais_moneOidMoneViewLabelTrId" );
      ((Element)v.get(68)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(77)).setAttribute("valign","top" );
      ((Element)v.get(77)).setAttribute("height","13" );
      ((Element)v.get(77)).setAttribute("width","30" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblViewPaisOidPais_moneOidMone" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).setAttribute("id","EstDat" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:79 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(79)).setAttribute("nowrap","true" );
      ((Element)v.get(79)).setAttribute("class","datosCampos" );
      ((Element)v.get(52)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(81)).setAttribute("nombre","paisOidPais_fopaOidFormPagoTdId" );
      ((Element)v.get(52)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).setAttribute("align","left" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("valign","top" );
      ((Element)v.get(84)).setAttribute("height","13" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblpaisOidPais_fopaOidFormPago" );
      ((Element)v.get(85)).setAttribute("id","datosTitle" );
      ((Element)v.get(85)).setAttribute("ancho","100" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 82   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(86)).setAttribute("nombre","paisOidPais_fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(82)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("align","left" );
      ((Element)v.get(87)).setAttribute("nowrap","true" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","paisOidPais_fopaOidFormPago" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("req","N" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("validacion","" );
      ((Element)v.get(88)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'carSoliEntrBloq')" );
      ((Element)v.get(88)).setAttribute("onfocus","" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.paisOidPais');" );
      ((Element)v.get(88)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:90 / Elemento padre: 82   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(90)).setAttribute("nombre","paisOidPais_fopaOidFormPagoViewLabelTrId" );
      ((Element)v.get(82)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(91)).setAttribute("valign","top" );
      ((Element)v.get(91)).setAttribute("height","13" );
      ((Element)v.get(91)).setAttribute("width","30" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblViewPaisOidPais_fopaOidFormPago" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("id","EstDat" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:93 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(93)).setAttribute("class","datosCampos" );
      ((Element)v.get(52)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(52)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("cellpadding","0" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(96)).setAttribute("align","left" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("valign","top" );
      ((Element)v.get(98)).setAttribute("height","13" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("ancho","100" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("cod","CarSoliEntrBloq.paisOidPais.label" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:100 / Elemento padre: 96   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(96)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).setAttribute("align","left" );
      ((Element)v.get(101)).setAttribute("nowrap","true" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(102)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("multiple","N" );
      ((Element)v.get(102)).setAttribute("req","N" );
      ((Element)v.get(102)).setAttribute("size","1" );
      ((Element)v.get(102)).setAttribute("validacion","" );
      ((Element)v.get(102)).setAttribute("onchange","" );
      ((Element)v.get(102)).setAttribute("onfocus","" );
      ((Element)v.get(102)).setAttribute("valorinicial","" );
      ((Element)v.get(102)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(102)).setAttribute("onshtab","focaliza('carSoliEntrBloqFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:104 / Elemento padre: 96   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(104)).setAttribute("nombre","paisOidPaisViewLabelTrId" );
      ((Element)v.get(96)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("valign","top" );
      ((Element)v.get(105)).setAttribute("height","13" );
      ((Element)v.get(105)).setAttribute("width","30" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblViewPaisOidPais" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","EstDat" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:107 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(107)).setAttribute("nowrap","true" );
      ((Element)v.get(107)).setAttribute("class","datosCampos" );
      ((Element)v.get(52)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:47   */

      /* Empieza nodo:111 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(111)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("align","center" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:111   */

      /* Empieza nodo:118 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(118)).setAttribute("nombre","formTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(120)).setAttribute("height","12" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(122)).setAttribute("align","left" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(123)).setAttribute("align","left" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaTdId" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).setAttribute("valign","top" );
      ((Element)v.get(127)).setAttribute("height","13" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("ancho","100" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("cod","SegAcces.canaOidCana.label" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(129)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaWidgetTrId" );
      ((Element)v.get(125)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("align","left" );
      ((Element)v.get(130)).setAttribute("nowrap","true" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(131)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("multiple","N" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("size","1" );
      ((Element)v.get(131)).setAttribute("validacion","" );
      ((Element)v.get(131)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac' , 'carSoliEntrBloq')" );
      ((Element)v.get(131)).setAttribute("onfocus","" );
      ((Element)v.get(131)).setAttribute("valorinicial","" );
      ((Element)v.get(131)).setAttribute("textoinicial","" );
      ((Element)v.get(131)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(131)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:133 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(133)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaViewLabelTrId" );
      ((Element)v.get(125)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("valign","top" );
      ((Element)v.get(134)).setAttribute("height","13" );
      ((Element)v.get(134)).setAttribute("width","30" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblViewSbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("id","EstDat" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:136 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).setAttribute("nombre","sbacOidSbacGapTdId" );
      ((Element)v.get(136)).setAttribute("nowrap","true" );
      ((Element)v.get(136)).setAttribute("class","datosCampos" );
      ((Element)v.get(123)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(138)).setAttribute("nombre","sbacOidSbac_acceOidAcceTdId" );
      ((Element)v.get(123)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(139)).setAttribute("border","0" );
      ((Element)v.get(139)).setAttribute("cellspacing","0" );
      ((Element)v.get(139)).setAttribute("cellpadding","0" );
      ((Element)v.get(139)).setAttribute("align","left" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("valign","top" );
      ((Element)v.get(141)).setAttribute("height","13" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("ancho","100" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("cod","SegSubac.acceOidAcce.label" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 139   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(143)).setAttribute("nombre","sbacOidSbac_acceOidAcceWidgetTrId" );
      ((Element)v.get(139)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("align","left" );
      ((Element)v.get(144)).setAttribute("nowrap","true" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(145)).setAttribute("nombre","sbacOidSbac_acceOidAcce" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("multiple","N" );
      ((Element)v.get(145)).setAttribute("req","N" );
      ((Element)v.get(145)).setAttribute("size","1" );
      ((Element)v.get(145)).setAttribute("validacion","" );
      ((Element)v.get(145)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce', 'sbacOidSbac' , 'carSoliEntrBloq')" );
      ((Element)v.get(145)).setAttribute("onfocus","" );
      ((Element)v.get(145)).setAttribute("valorinicial","" );
      ((Element)v.get(145)).setAttribute("textoinicial","" );
      ((Element)v.get(145)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.sbacOidSbac');" );
      ((Element)v.get(145)).setAttribute("onshtab","focaliza('carSoliEntrBloqFrm.sbacOidSbac_acceOidAcce_canaOidCana');" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:147 / Elemento padre: 139   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(147)).setAttribute("nombre","sbacOidSbac_acceOidAcceViewLabelTrId" );
      ((Element)v.get(139)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("valign","top" );
      ((Element)v.get(148)).setAttribute("height","13" );
      ((Element)v.get(148)).setAttribute("width","30" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lblViewSbacOidSbac_acceOidAcce" );
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("id","EstDat" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:150 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("nombre","sbacOidSbacGapTdId" );
      ((Element)v.get(150)).setAttribute("nowrap","true" );
      ((Element)v.get(150)).setAttribute("class","datosCampos" );
      ((Element)v.get(123)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","25" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("nombre","sbacOidSbacTdId" );
      ((Element)v.get(123)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(153)).setAttribute("align","left" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("valign","top" );
      ((Element)v.get(155)).setAttribute("height","13" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblsbacOidSbac" );
      ((Element)v.get(156)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).setAttribute("ancho","100" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("cod","CarSoliEntrBloq.sbacOidSbac.label" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:157 / Elemento padre: 153   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(157)).setAttribute("nombre","sbacOidSbacWidgetTrId" );
      ((Element)v.get(153)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("align","left" );
      ((Element)v.get(158)).setAttribute("nowrap","true" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(159)).setAttribute("nombre","sbacOidSbac" );
      ((Element)v.get(159)).setAttribute("id","datosCampos" );
      ((Element)v.get(159)).setAttribute("multiple","N" );
      ((Element)v.get(159)).setAttribute("req","N" );
      ((Element)v.get(159)).setAttribute("size","1" );
      ((Element)v.get(159)).setAttribute("validacion","" );
      ((Element)v.get(159)).setAttribute("onchange","" );
      ((Element)v.get(159)).setAttribute("onfocus","" );
      ((Element)v.get(159)).setAttribute("valorinicial","" );
      ((Element)v.get(159)).setAttribute("textoinicial","" );
      ((Element)v.get(159)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(159)).setAttribute("onshtab","focaliza('carSoliEntrBloqFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:161 / Elemento padre: 153   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(161)).setAttribute("nombre","sbacOidSbacViewLabelTrId" );
      ((Element)v.get(153)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("valign","top" );
      ((Element)v.get(162)).setAttribute("height","13" );
      ((Element)v.get(162)).setAttribute("width","30" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lblViewSbacOidSbac" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("filas","1" );
      ((Element)v.get(163)).setAttribute("id","EstDat" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:164 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("nombre","sbacOidSbacGapTdId" );
      ((Element)v.get(164)).setAttribute("nowrap","true" );
      ((Element)v.get(164)).setAttribute("class","datosCampos" );
      ((Element)v.get(123)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","25" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(123)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:118   */

      /* Empieza nodo:168 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(168)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("align","center" );
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("width","12" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:168   */

      /* Empieza nodo:175 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(175)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("align","center" );
      ((Element)v.get(176)).setAttribute("width","12" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","12" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(179)).setAttribute("width","100%" );
      ((Element)v.get(179)).setAttribute("border","0" );
      ((Element)v.get(179)).setAttribute("cellspacing","0" );
      ((Element)v.get(179)).setAttribute("cellpadding","0" );
      ((Element)v.get(179)).setAttribute("align","left" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(180)).setAttribute("align","left" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("nombre","tsolOidTipoSoliTdId" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(182)).setAttribute("border","0" );
      ((Element)v.get(182)).setAttribute("cellspacing","0" );
      ((Element)v.get(182)).setAttribute("cellpadding","0" );
      ((Element)v.get(182)).setAttribute("align","left" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("valign","top" );
      ((Element)v.get(184)).setAttribute("height","13" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lbltsolOidTipoSoli" );
      ((Element)v.get(185)).setAttribute("id","datosTitle" );
      ((Element)v.get(185)).setAttribute("ancho","100" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("cod","CarSoliEntrBloq.tsolOidTipoSoli.label" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:186 / Elemento padre: 182   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(186)).setAttribute("nombre","tsolOidTipoSoliWidgetTrId" );
      ((Element)v.get(182)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(187)).setAttribute("nowrap","true" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(188)).setAttribute("nombre","tsolOidTipoSoli" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("multiple","N" );
      ((Element)v.get(188)).setAttribute("req","N" );
      ((Element)v.get(188)).setAttribute("size","1" );
      ((Element)v.get(188)).setAttribute("validacion","" );
      ((Element)v.get(188)).setAttribute("onchange","" );
      ((Element)v.get(188)).setAttribute("onfocus","" );
      ((Element)v.get(188)).setAttribute("valorinicial","" );
      ((Element)v.get(188)).setAttribute("textoinicial","" );
      ((Element)v.get(188)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(188)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:190 / Elemento padre: 182   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).setAttribute("nombre","tsolOidTipoSoliViewLabelTrId" );
      ((Element)v.get(182)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("valign","top" );
      ((Element)v.get(191)).setAttribute("height","13" );
      ((Element)v.get(191)).setAttribute("width","50" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblViewTsolOidTipoSoli" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("id","EstDat" );
      ((Element)v.get(192)).setAttribute("valor","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:193 / Elemento padre: 180   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("nombre","tsolOidTipoSoliGapTdId" );
      ((Element)v.get(193)).setAttribute("nowrap","true" );
      ((Element)v.get(193)).setAttribute("class","datosCampos" );
      ((Element)v.get(180)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 180   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:175   */

      /* Empieza nodo:197 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(197)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("align","center" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(197)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","12" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:197   */

      /* Empieza nodo:204 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(204)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(208)).setAttribute("border","0" );
      ((Element)v.get(208)).setAttribute("cellspacing","0" );
      ((Element)v.get(208)).setAttribute("cellpadding","0" );
      ((Element)v.get(208)).setAttribute("align","left" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(209)).setAttribute("align","left" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("nombre","socaOidSoliCabeTdId" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(214)).setAttribute("nombre","lblsocaOidSoliCabe" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("ancho","100" );
      ((Element)v.get(214)).setAttribute("alto","13" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(214)).setAttribute("cod","CarSoliEntrBloq.socaOidSoliCabe.label" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(215)).setAttribute("nombre","socaOidSoliCabeWidgetTrId" );
      ((Element)v.get(211)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(216)).setAttribute("nowrap","true" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(217)).setAttribute("nombre","socaOidSoliCabe" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).setAttribute("multiple","N" );
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("size","1" );
      ((Element)v.get(217)).setAttribute("validacion","" );
      ((Element)v.get(217)).setAttribute("onchange","" );
      ((Element)v.get(217)).setAttribute("onfocus","" );
      ((Element)v.get(217)).setAttribute("valorinicial","" );
      ((Element)v.get(217)).setAttribute("textoinicial","" );
      ((Element)v.get(217)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(217)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:219 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(219)).setAttribute("nombre","socaOidSoliCabeViewLabelTrId" );
      ((Element)v.get(211)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("valign","top" );
      ((Element)v.get(220)).setAttribute("height","13" );
      ((Element)v.get(220)).setAttribute("width","50" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblViewSocaOidSoliCabe" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("id","EstDat" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:222 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("nombre","socaOidSoliCabeGapTdId" );
      ((Element)v.get(222)).setAttribute("nowrap","true" );
      ((Element)v.get(222)).setAttribute("class","datosCampos" );
      ((Element)v.get(209)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:204   */

      /* Empieza nodo:226 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(226)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).setAttribute("align","center" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("align","center" );
      ((Element)v.get(231)).setAttribute("width","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","12" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:226   */

      /* Empieza nodo:233 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(233)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("align","center" );
      ((Element)v.get(234)).setAttribute("width","12" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","12" );
      ((Element)v.get(235)).setAttribute("height","12" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(237)).setAttribute("width","100%" );
      ((Element)v.get(237)).setAttribute("border","0" );
      ((Element)v.get(237)).setAttribute("cellspacing","0" );
      ((Element)v.get(237)).setAttribute("cellpadding","0" );
      ((Element)v.get(237)).setAttribute("align","left" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(238)).setAttribute("align","left" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("nombre","fecDocuTdId" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(240)).setAttribute("width","100%" );
      ((Element)v.get(240)).setAttribute("border","0" );
      ((Element)v.get(240)).setAttribute("cellspacing","0" );
      ((Element)v.get(240)).setAttribute("cellpadding","0" );
      ((Element)v.get(240)).setAttribute("align","left" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(242)).setAttribute("valign","top" );
      ((Element)v.get(242)).setAttribute("height","13" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblFecDocu" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("id","datosTitle" );
      ((Element)v.get(243)).setAttribute("cod","CarSoliEntrBloq.fecDocu.label" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:244 / Elemento padre: 240   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(244)).setAttribute("nombre","fecDocuWidgetTrId" );
      ((Element)v.get(240)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("align","left" );
      ((Element)v.get(245)).setAttribute("nowrap","true" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(246)).setAttribute("nombre","fecDocu" );
      ((Element)v.get(246)).setAttribute("id","datosCampos" );
      ((Element)v.get(246)).setAttribute("trim","S" );
      ((Element)v.get(246)).setAttribute("max","7" );
      ((Element)v.get(246)).setAttribute("onchange","" );
      ((Element)v.get(246)).setAttribute("req","N" );
      ((Element)v.get(246)).setAttribute("size","7" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(246)).setAttribute("validacion","" );
      ((Element)v.get(246)).setAttribute("onblur","" );
      ((Element)v.get(246)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(246)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:247 / Elemento padre: 240   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(247)).setAttribute("nombre","fecDocuViewLabelTrId" );
      ((Element)v.get(240)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("valign","top" );
      ((Element)v.get(248)).setAttribute("height","13" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(249)).setAttribute("nombre","lblViewFecDocu" );
      ((Element)v.get(249)).setAttribute("alto","13" );
      ((Element)v.get(249)).setAttribute("ancho","100" );
      ((Element)v.get(249)).setAttribute("id","EstDat" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:250 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("nombre","fecDocuGapTdId" );
      ((Element)v.get(250)).setAttribute("nowrap","true" );
      ((Element)v.get(250)).setAttribute("class","datosCampos" );
      ((Element)v.get(238)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","25" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("width","100%" );
      ((Element)v.get(238)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:233   */

      /* Empieza nodo:254 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(254)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","12" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:254   */

      /* Empieza nodo:261 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(261)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("align","center" );
      ((Element)v.get(262)).setAttribute("width","12" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","12" );
      ((Element)v.get(263)).setAttribute("height","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 261   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(261)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(265)).setAttribute("width","100%" );
      ((Element)v.get(265)).setAttribute("border","0" );
      ((Element)v.get(265)).setAttribute("cellspacing","0" );
      ((Element)v.get(265)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).setAttribute("align","left" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(266)).setAttribute("align","left" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("nombre","indNotiTdId" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(268)).setAttribute("border","0" );
      ((Element)v.get(268)).setAttribute("cellspacing","0" );
      ((Element)v.get(268)).setAttribute("cellpadding","0" );
      ((Element)v.get(268)).setAttribute("align","left" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("valign","top" );
      ((Element)v.get(270)).setAttribute("height","13" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(271)).setAttribute("nombre","lblIndNoti" );
      ((Element)v.get(271)).setAttribute("alto","13" );
      ((Element)v.get(271)).setAttribute("filas","1" );
      ((Element)v.get(271)).setAttribute("id","datosTitle" );
      ((Element)v.get(271)).setAttribute("cod","CarSoliEntrBloq.indNoti.label" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:272 / Elemento padre: 268   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(272)).setAttribute("nombre","indNotiWidgetTrId" );
      ((Element)v.get(268)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("align","left" );
      ((Element)v.get(273)).setAttribute("nowrap","true" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(274)).setAttribute("nombre","indNoti" );
      ((Element)v.get(274)).setAttribute("id","datosCampos" );
      ((Element)v.get(274)).setAttribute("trim","S" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(274)).setAttribute("max","1" );
      ((Element)v.get(274)).setAttribute("onchange","" );
      ((Element)v.get(274)).setAttribute("req","N" );
      ((Element)v.get(274)).setAttribute("size","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("validacion","" );
      ((Element)v.get(274)).setAttribute("onblur","" );
      ((Element)v.get(274)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(274)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 268   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(275)).setAttribute("nombre","indNotiViewLabelTrId" );
      ((Element)v.get(268)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("valign","top" );
      ((Element)v.get(276)).setAttribute("height","13" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(277)).setAttribute("nombre","lblViewIndNoti" );
      ((Element)v.get(277)).setAttribute("alto","13" );
      ((Element)v.get(277)).setAttribute("ancho","100" );
      ((Element)v.get(277)).setAttribute("id","EstDat" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:278 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("nombre","indNotiGapTdId" );
      ((Element)v.get(278)).setAttribute("nowrap","true" );
      ((Element)v.get(278)).setAttribute("class","datosCampos" );
      ((Element)v.get(266)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","25" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:261   */

      /* Empieza nodo:282 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(282)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("width","12" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","12" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("align","center" );
      ((Element)v.get(287)).setAttribute("width","12" );
      ((Element)v.get(282)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","12" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:282   */

      /* Empieza nodo:289 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(289)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("align","center" );
      ((Element)v.get(290)).setAttribute("width","12" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","12" );
      ((Element)v.get(291)).setAttribute("height","12" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(293)).setAttribute("width","100%" );
      ((Element)v.get(293)).setAttribute("border","0" );
      ((Element)v.get(293)).setAttribute("cellspacing","0" );
      ((Element)v.get(293)).setAttribute("cellpadding","0" );
      ((Element)v.get(293)).setAttribute("align","left" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(294)).setAttribute("align","left" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("nombre","valMontOrdeTdId" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

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
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("valign","top" );
      ((Element)v.get(298)).setAttribute("height","13" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lblValMontOrde" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","CarSoliEntrBloq.valMontOrde.label" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 296   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","valMontOrdeWidgetTrId" );
      ((Element)v.get(296)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","left" );
      ((Element)v.get(301)).setAttribute("nowrap","true" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(302)).setAttribute("nombre","valMontOrde" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("trim","S" );
      ((Element)v.get(302)).setAttribute("max","12" );
      ((Element)v.get(302)).setAttribute("onchange","" );
      ((Element)v.get(302)).setAttribute("req","N" );
      ((Element)v.get(302)).setAttribute("size","12" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(302)).setAttribute("validacion","" );
      ((Element)v.get(302)).setAttribute("onblur","" );
      ((Element)v.get(302)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(302)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:303 / Elemento padre: 296   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(303)).setAttribute("nombre","valMontOrdeViewLabelTrId" );
      ((Element)v.get(296)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).setAttribute("valign","top" );
      ((Element)v.get(304)).setAttribute("height","13" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(305)).setAttribute("nombre","lblViewValMontOrde" );
      ((Element)v.get(305)).setAttribute("alto","13" );
      ((Element)v.get(305)).setAttribute("ancho","100" );
      ((Element)v.get(305)).setAttribute("id","EstDat" );
      ((Element)v.get(305)).setAttribute("valor","" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:306 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).setAttribute("nombre","valMontOrdeGapTdId" );
      ((Element)v.get(306)).setAttribute("nowrap","true" );
      ((Element)v.get(306)).setAttribute("class","datosCampos" );
      ((Element)v.get(294)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(294)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:289   */

      /* Empieza nodo:310 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(310)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(311)).setAttribute("align","center" );
      ((Element)v.get(311)).setAttribute("width","12" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","12" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(315)).setAttribute("width","12" );
      ((Element)v.get(310)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","12" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:310   */

      /* Empieza nodo:317 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(317)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(318)).setAttribute("align","center" );
      ((Element)v.get(318)).setAttribute("width","12" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","12" );
      ((Element)v.get(319)).setAttribute("height","12" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(321)).setAttribute("width","100%" );
      ((Element)v.get(321)).setAttribute("border","0" );
      ((Element)v.get(321)).setAttribute("cellspacing","0" );
      ((Element)v.get(321)).setAttribute("cellpadding","0" );
      ((Element)v.get(321)).setAttribute("align","left" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(322)).setAttribute("align","left" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("nombre","valMontDeudVencTdId" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(324)).setAttribute("border","0" );
      ((Element)v.get(324)).setAttribute("cellspacing","0" );
      ((Element)v.get(324)).setAttribute("cellpadding","0" );
      ((Element)v.get(324)).setAttribute("align","left" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).setAttribute("valign","top" );
      ((Element)v.get(326)).setAttribute("height","13" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblValMontDeudVenc" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
      ((Element)v.get(327)).setAttribute("cod","CarSoliEntrBloq.valMontDeudVenc.label" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 324   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).setAttribute("nombre","valMontDeudVencWidgetTrId" );
      ((Element)v.get(324)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("align","left" );
      ((Element)v.get(329)).setAttribute("nowrap","true" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(330)).setAttribute("nombre","valMontDeudVenc" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(330)).setAttribute("trim","S" );
      ((Element)v.get(330)).setAttribute("max","12" );
      ((Element)v.get(330)).setAttribute("onchange","" );
      ((Element)v.get(330)).setAttribute("req","N" );
      ((Element)v.get(330)).setAttribute("size","12" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(330)).setAttribute("validacion","" );
      ((Element)v.get(330)).setAttribute("onblur","" );
      ((Element)v.get(330)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(330)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:331 / Elemento padre: 324   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(331)).setAttribute("nombre","valMontDeudVencViewLabelTrId" );
      ((Element)v.get(324)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(332)).setAttribute("valign","top" );
      ((Element)v.get(332)).setAttribute("height","13" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(333)).setAttribute("nombre","lblViewValMontDeudVenc" );
      ((Element)v.get(333)).setAttribute("alto","13" );
      ((Element)v.get(333)).setAttribute("ancho","100" );
      ((Element)v.get(333)).setAttribute("id","EstDat" );
      ((Element)v.get(333)).setAttribute("valor","" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:334 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).setAttribute("nombre","valMontDeudVencGapTdId" );
      ((Element)v.get(334)).setAttribute("nowrap","true" );
      ((Element)v.get(334)).setAttribute("class","datosCampos" );
      ((Element)v.get(322)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","25" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(322)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:317   */

      /* Empieza nodo:338 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(338)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(339)).setAttribute("align","center" );
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("align","center" );
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(338)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","12" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:338   */

      /* Empieza nodo:345 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(345)).setAttribute("nombre","formTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).setAttribute("align","center" );
      ((Element)v.get(346)).setAttribute("width","12" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","12" );
      ((Element)v.get(347)).setAttribute("height","12" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));

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
      ((Element)v.get(350)).setAttribute("align","left" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("nombre","indVali1TdId" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(352)).setAttribute("border","0" );
      ((Element)v.get(352)).setAttribute("cellspacing","0" );
      ((Element)v.get(352)).setAttribute("cellpadding","0" );
      ((Element)v.get(352)).setAttribute("align","left" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(354)).setAttribute("valign","top" );
      ((Element)v.get(354)).setAttribute("height","13" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(355)).setAttribute("nombre","lblIndVali1" );
      ((Element)v.get(355)).setAttribute("alto","13" );
      ((Element)v.get(355)).setAttribute("filas","1" );
      ((Element)v.get(355)).setAttribute("id","datosTitle" );
      ((Element)v.get(355)).setAttribute("cod","CarSoliEntrBloq.indVali1.label" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:356 / Elemento padre: 352   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(356)).setAttribute("nombre","indVali1WidgetTrId" );
      ((Element)v.get(352)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("align","left" );
      ((Element)v.get(357)).setAttribute("nowrap","true" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(358)).setAttribute("nombre","indVali1" );
      ((Element)v.get(358)).setAttribute("id","datosCampos" );
      ((Element)v.get(358)).setAttribute("trim","S" );
      ((Element)v.get(358)).setAttribute("max","1" );
      ((Element)v.get(358)).setAttribute("onchange","" );
      ((Element)v.get(358)).setAttribute("req","N" );
      ((Element)v.get(358)).setAttribute("size","1" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(358)).setAttribute("validacion","" );
      ((Element)v.get(358)).setAttribute("onblur","" );
      ((Element)v.get(358)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(358)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:359 / Elemento padre: 352   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(359)).setAttribute("nombre","indVali1ViewLabelTrId" );
      ((Element)v.get(352)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("valign","top" );
      ((Element)v.get(360)).setAttribute("height","13" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblViewIndVali1" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("ancho","100" );
      ((Element)v.get(361)).setAttribute("id","EstDat" );
      ((Element)v.get(361)).setAttribute("valor","" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:362 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(362)).setAttribute("nombre","indVali1GapTdId" );
      ((Element)v.get(362)).setAttribute("nowrap","true" );
      ((Element)v.get(362)).setAttribute("class","datosCampos" );
      ((Element)v.get(350)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","25" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(364)).setAttribute("width","100%" );
      ((Element)v.get(350)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:345   */

      /* Empieza nodo:366 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(366)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(367)).setAttribute("align","center" );
      ((Element)v.get(367)).setAttribute("width","12" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","12" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 366   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("width","8" );
      ((Element)v.get(370)).setAttribute("height","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 366   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("align","center" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(366)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","12" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:366   */

      /* Empieza nodo:373 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(373)).setAttribute("nombre","formTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("align","center" );
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","12" );
      ((Element)v.get(375)).setAttribute("height","12" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).setAttribute("width","100%" );
      ((Element)v.get(373)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(377)).setAttribute("width","100%" );
      ((Element)v.get(377)).setAttribute("border","0" );
      ((Element)v.get(377)).setAttribute("cellspacing","0" );
      ((Element)v.get(377)).setAttribute("cellpadding","0" );
      ((Element)v.get(377)).setAttribute("align","left" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(378)).setAttribute("align","left" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("nombre","indVali2TdId" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(380)).setAttribute("width","100%" );
      ((Element)v.get(380)).setAttribute("border","0" );
      ((Element)v.get(380)).setAttribute("cellspacing","0" );
      ((Element)v.get(380)).setAttribute("cellpadding","0" );
      ((Element)v.get(380)).setAttribute("align","left" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("valign","top" );
      ((Element)v.get(382)).setAttribute("height","13" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(383)).setAttribute("nombre","lblIndVali2" );
      ((Element)v.get(383)).setAttribute("alto","13" );
      ((Element)v.get(383)).setAttribute("filas","1" );
      ((Element)v.get(383)).setAttribute("id","datosTitle" );
      ((Element)v.get(383)).setAttribute("cod","CarSoliEntrBloq.indVali2.label" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 380   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(384)).setAttribute("nombre","indVali2WidgetTrId" );
      ((Element)v.get(380)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("align","left" );
      ((Element)v.get(385)).setAttribute("nowrap","true" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(386)).setAttribute("nombre","indVali2" );
      ((Element)v.get(386)).setAttribute("id","datosCampos" );
      ((Element)v.get(386)).setAttribute("trim","S" );
      ((Element)v.get(386)).setAttribute("max","1" );
      ((Element)v.get(386)).setAttribute("onchange","" );
      ((Element)v.get(386)).setAttribute("req","N" );
      ((Element)v.get(386)).setAttribute("size","1" );
      ((Element)v.get(386)).setAttribute("valor","" );
      ((Element)v.get(386)).setAttribute("validacion","" );
      ((Element)v.get(386)).setAttribute("onblur","" );
      ((Element)v.get(386)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(386)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:387 / Elemento padre: 380   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(387)).setAttribute("nombre","indVali2ViewLabelTrId" );
      ((Element)v.get(380)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("valign","top" );
      ((Element)v.get(388)).setAttribute("height","13" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(389)).setAttribute("nombre","lblViewIndVali2" );
      ((Element)v.get(389)).setAttribute("alto","13" );
      ((Element)v.get(389)).setAttribute("ancho","100" );
      ((Element)v.get(389)).setAttribute("id","EstDat" );
      ((Element)v.get(389)).setAttribute("valor","" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:390 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).setAttribute("nombre","indVali2GapTdId" );
      ((Element)v.get(390)).setAttribute("nowrap","true" );
      ((Element)v.get(390)).setAttribute("class","datosCampos" );
      ((Element)v.get(378)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","25" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("width","100%" );
      ((Element)v.get(378)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:373   */

      /* Empieza nodo:394 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(394)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(395)).setAttribute("align","center" );
      ((Element)v.get(395)).setAttribute("width","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","12" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(399)).setAttribute("align","center" );
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","12" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:394   */

      /* Empieza nodo:401 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(401)).setAttribute("nombre","formTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("align","center" );
      ((Element)v.get(402)).setAttribute("width","12" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","12" );
      ((Element)v.get(403)).setAttribute("height","12" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(401)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(405)).setAttribute("width","100%" );
      ((Element)v.get(405)).setAttribute("border","0" );
      ((Element)v.get(405)).setAttribute("cellspacing","0" );
      ((Element)v.get(405)).setAttribute("cellpadding","0" );
      ((Element)v.get(405)).setAttribute("align","left" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(406)).setAttribute("align","left" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(407)).setAttribute("nombre","indVali3TdId" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(408)).setAttribute("width","100%" );
      ((Element)v.get(408)).setAttribute("border","0" );
      ((Element)v.get(408)).setAttribute("cellspacing","0" );
      ((Element)v.get(408)).setAttribute("cellpadding","0" );
      ((Element)v.get(408)).setAttribute("align","left" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("valign","top" );
      ((Element)v.get(410)).setAttribute("height","13" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(411)).setAttribute("nombre","lblIndVali3" );
      ((Element)v.get(411)).setAttribute("alto","13" );
      ((Element)v.get(411)).setAttribute("filas","1" );
      ((Element)v.get(411)).setAttribute("id","datosTitle" );
      ((Element)v.get(411)).setAttribute("cod","CarSoliEntrBloq.indVali3.label" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 408   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(412)).setAttribute("nombre","indVali3WidgetTrId" );
      ((Element)v.get(408)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("align","left" );
      ((Element)v.get(413)).setAttribute("nowrap","true" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(414)).setAttribute("nombre","indVali3" );
      ((Element)v.get(414)).setAttribute("id","datosCampos" );
      ((Element)v.get(414)).setAttribute("trim","S" );
      ((Element)v.get(414)).setAttribute("max","1" );
      ((Element)v.get(414)).setAttribute("onchange","" );
      ((Element)v.get(414)).setAttribute("req","N" );
      ((Element)v.get(414)).setAttribute("size","1" );
      ((Element)v.get(414)).setAttribute("valor","" );
      ((Element)v.get(414)).setAttribute("validacion","" );
      ((Element)v.get(414)).setAttribute("onblur","" );
      ((Element)v.get(414)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(414)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 408   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(415)).setAttribute("nombre","indVali3ViewLabelTrId" );
      ((Element)v.get(408)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(416)).setAttribute("valign","top" );
      ((Element)v.get(416)).setAttribute("height","13" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(417)).setAttribute("nombre","lblViewIndVali3" );
      ((Element)v.get(417)).setAttribute("alto","13" );
      ((Element)v.get(417)).setAttribute("ancho","100" );
      ((Element)v.get(417)).setAttribute("id","EstDat" );
      ((Element)v.get(417)).setAttribute("valor","" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:418 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).setAttribute("nombre","indVali3GapTdId" );
      ((Element)v.get(418)).setAttribute("nowrap","true" );
      ((Element)v.get(418)).setAttribute("class","datosCampos" );
      ((Element)v.get(406)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","25" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("width","100%" );
      ((Element)v.get(406)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:401   */

      /* Empieza nodo:422 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(422)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("align","center" );
      ((Element)v.get(423)).setAttribute("width","12" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","12" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(422)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(427)).setAttribute("align","center" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(422)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","12" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:422   */

      /* Empieza nodo:429 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(429)).setAttribute("nombre","formTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(430)).setAttribute("align","center" );
      ((Element)v.get(430)).setAttribute("width","12" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","12" );
      ((Element)v.get(431)).setAttribute("height","12" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 429   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(432)).setAttribute("width","100%" );
      ((Element)v.get(429)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(433)).setAttribute("width","100%" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(433)).setAttribute("border","0" );
      ((Element)v.get(433)).setAttribute("cellspacing","0" );
      ((Element)v.get(433)).setAttribute("cellpadding","0" );
      ((Element)v.get(433)).setAttribute("align","left" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(434)).setAttribute("align","left" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(435)).setAttribute("nombre","indVali4TdId" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(436)).setAttribute("width","100%" );
      ((Element)v.get(436)).setAttribute("border","0" );
      ((Element)v.get(436)).setAttribute("cellspacing","0" );
      ((Element)v.get(436)).setAttribute("cellpadding","0" );
      ((Element)v.get(436)).setAttribute("align","left" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("valign","top" );
      ((Element)v.get(438)).setAttribute("height","13" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(439)).setAttribute("nombre","lblIndVali4" );
      ((Element)v.get(439)).setAttribute("alto","13" );
      ((Element)v.get(439)).setAttribute("filas","1" );
      ((Element)v.get(439)).setAttribute("id","datosTitle" );
      ((Element)v.get(439)).setAttribute("cod","CarSoliEntrBloq.indVali4.label" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:440 / Elemento padre: 436   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(440)).setAttribute("nombre","indVali4WidgetTrId" );
      ((Element)v.get(436)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("align","left" );
      ((Element)v.get(441)).setAttribute("nowrap","true" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(442)).setAttribute("nombre","indVali4" );
      ((Element)v.get(442)).setAttribute("id","datosCampos" );
      ((Element)v.get(442)).setAttribute("trim","S" );
      ((Element)v.get(442)).setAttribute("max","1" );
      ((Element)v.get(442)).setAttribute("onchange","" );
      ((Element)v.get(442)).setAttribute("req","N" );
      ((Element)v.get(442)).setAttribute("size","1" );
      ((Element)v.get(442)).setAttribute("valor","" );
      ((Element)v.get(442)).setAttribute("validacion","" );
      ((Element)v.get(442)).setAttribute("onblur","" );
      ((Element)v.get(442)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(442)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:443 / Elemento padre: 436   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(443)).setAttribute("nombre","indVali4ViewLabelTrId" );
      ((Element)v.get(436)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("valign","top" );
      ((Element)v.get(444)).setAttribute("height","13" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(445)).setAttribute("nombre","lblViewIndVali4" );
      ((Element)v.get(445)).setAttribute("alto","13" );
      ((Element)v.get(445)).setAttribute("ancho","100" );
      ((Element)v.get(445)).setAttribute("id","EstDat" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:446 / Elemento padre: 434   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("nombre","indVali4GapTdId" );
      ((Element)v.get(446)).setAttribute("nowrap","true" );
      ((Element)v.get(446)).setAttribute("class","datosCampos" );
      ((Element)v.get(434)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","25" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 434   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(448)).setAttribute("width","100%" );
      ((Element)v.get(434)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:429   */

      /* Empieza nodo:450 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(450)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(451)).setAttribute("align","center" );
      ((Element)v.get(451)).setAttribute("width","12" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","12" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(455)).setAttribute("align","center" );
      ((Element)v.get(455)).setAttribute("width","12" );
      ((Element)v.get(450)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","12" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:450   */

      /* Empieza nodo:457 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(457)).setAttribute("nombre","formTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(458)).setAttribute("align","center" );
      ((Element)v.get(458)).setAttribute("width","12" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","12" );
      ((Element)v.get(459)).setAttribute("height","12" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 457   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("width","100%" );
      ((Element)v.get(457)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(461)).setAttribute("width","100%" );
      ((Element)v.get(461)).setAttribute("border","0" );
      ((Element)v.get(461)).setAttribute("cellspacing","0" );
      ((Element)v.get(461)).setAttribute("cellpadding","0" );
      ((Element)v.get(461)).setAttribute("align","left" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(462)).setAttribute("align","left" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(463)).setAttribute("nombre","fecHoraLibeTdId" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(464)).setAttribute("width","100%" );
      ((Element)v.get(464)).setAttribute("border","0" );
      ((Element)v.get(464)).setAttribute("cellspacing","0" );
      ((Element)v.get(464)).setAttribute("cellpadding","0" );
      ((Element)v.get(464)).setAttribute("align","left" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(466)).setAttribute("valign","top" );
      ((Element)v.get(466)).setAttribute("height","13" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(467)).setAttribute("nombre","lblFecHoraLibe" );
      ((Element)v.get(467)).setAttribute("alto","13" );
      ((Element)v.get(467)).setAttribute("filas","1" );
      ((Element)v.get(467)).setAttribute("id","datosTitle" );
      ((Element)v.get(467)).setAttribute("cod","CarSoliEntrBloq.fecHoraLibe.label" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:468 / Elemento padre: 464   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(468)).setAttribute("nombre","fecHoraLibeWidgetTrId" );
      ((Element)v.get(464)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(469)).setAttribute("align","left" );
      ((Element)v.get(469)).setAttribute("nowrap","true" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(470)).setAttribute("nombre","fecHoraLibe" );
      ((Element)v.get(470)).setAttribute("id","datosCampos" );
      ((Element)v.get(470)).setAttribute("trim","S" );
      ((Element)v.get(470)).setAttribute("max","7" );
      ((Element)v.get(470)).setAttribute("onchange","" );
      ((Element)v.get(470)).setAttribute("req","N" );
      ((Element)v.get(470)).setAttribute("size","7" );
      ((Element)v.get(470)).setAttribute("valor","" );
      ((Element)v.get(470)).setAttribute("validacion","" );
      ((Element)v.get(470)).setAttribute("onblur","" );
      ((Element)v.get(470)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(470)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:471 / Elemento padre: 464   */
      v.add(doc.createElement("TR"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(471)).setAttribute("nombre","fecHoraLibeViewLabelTrId" );
      ((Element)v.get(464)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(472)).setAttribute("valign","top" );
      ((Element)v.get(472)).setAttribute("height","13" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(473)).setAttribute("nombre","lblViewFecHoraLibe" );
      ((Element)v.get(473)).setAttribute("alto","13" );
      ((Element)v.get(473)).setAttribute("ancho","100" );
      ((Element)v.get(473)).setAttribute("id","EstDat" );
      ((Element)v.get(473)).setAttribute("valor","" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:474 / Elemento padre: 462   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(474)).setAttribute("nombre","fecHoraLibeGapTdId" );
      ((Element)v.get(474)).setAttribute("nowrap","true" );
      ((Element)v.get(474)).setAttribute("class","datosCampos" );
      ((Element)v.get(462)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(475)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).setAttribute("width","25" );
      ((Element)v.get(475)).setAttribute("height","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 462   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(476)).setAttribute("width","100%" );
      ((Element)v.get(462)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:457   */

      /* Empieza nodo:478 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(478)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("align","center" );
      ((Element)v.get(479)).setAttribute("width","12" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","12" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(478)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(482)).setAttribute("height","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 478   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(483)).setAttribute("align","center" );
      ((Element)v.get(483)).setAttribute("width","12" );
      ((Element)v.get(478)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","12" );
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:478   */

      /* Empieza nodo:485 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(485)).setAttribute("nombre","formTr14" );
      ((Element)v.get(15)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(486)).setAttribute("align","center" );
      ((Element)v.get(486)).setAttribute("width","12" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(488)).setAttribute("width","100%" );
      ((Element)v.get(485)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(489)).setAttribute("width","100%" );
      ((Element)v.get(489)).setAttribute("border","0" );
      ((Element)v.get(489)).setAttribute("cellspacing","0" );
      ((Element)v.get(489)).setAttribute("cellpadding","0" );
      ((Element)v.get(489)).setAttribute("align","left" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(490)).setAttribute("align","left" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(491)).setAttribute("nombre","valObseTdId" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(492)).setAttribute("width","100%" );
      ((Element)v.get(492)).setAttribute("border","0" );
      ((Element)v.get(492)).setAttribute("cellspacing","0" );
      ((Element)v.get(492)).setAttribute("cellpadding","0" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(492)).setAttribute("align","left" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("valign","top" );
      ((Element)v.get(494)).setAttribute("height","13" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(495)).setAttribute("nombre","lblValObse" );
      ((Element)v.get(495)).setAttribute("alto","13" );
      ((Element)v.get(495)).setAttribute("filas","1" );
      ((Element)v.get(495)).setAttribute("id","datosTitle" );
      ((Element)v.get(495)).setAttribute("cod","CarSoliEntrBloq.valObse.label" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:496 / Elemento padre: 492   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(496)).setAttribute("nombre","valObseWidgetTrId" );
      ((Element)v.get(492)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("align","left" );
      ((Element)v.get(497)).setAttribute("nowrap","true" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(498)).setAttribute("nombre","valObse" );
      ((Element)v.get(498)).setAttribute("id","datosCampos" );
      ((Element)v.get(498)).setAttribute("trim","S" );
      ((Element)v.get(498)).setAttribute("max","100" );
      ((Element)v.get(498)).setAttribute("onchange","" );
      ((Element)v.get(498)).setAttribute("req","N" );
      ((Element)v.get(498)).setAttribute("size","100" );
      ((Element)v.get(498)).setAttribute("valor","" );
      ((Element)v.get(498)).setAttribute("validacion","" );
      ((Element)v.get(498)).setAttribute("onblur","" );
      ((Element)v.get(498)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(498)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:499 / Elemento padre: 492   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(499)).setAttribute("nombre","valObseViewLabelTrId" );
      ((Element)v.get(492)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(500)).setAttribute("valign","top" );
      ((Element)v.get(500)).setAttribute("height","13" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(501)).setAttribute("nombre","lblViewValObse" );
      ((Element)v.get(501)).setAttribute("alto","13" );
      ((Element)v.get(501)).setAttribute("ancho","100" );
      ((Element)v.get(501)).setAttribute("id","EstDat" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:502 / Elemento padre: 490   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("nombre","valObseGapTdId" );
      ((Element)v.get(502)).setAttribute("nowrap","true" );
      ((Element)v.get(502)).setAttribute("class","datosCampos" );
      ((Element)v.get(490)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","25" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 490   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(490)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:485   */

      /* Empieza nodo:506 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(506)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(15)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(507)).setAttribute("align","center" );
      ((Element)v.get(507)).setAttribute("width","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","12" );
      ((Element)v.get(508)).setAttribute("height","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 506   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 506   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("width","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","12" );
      ((Element)v.get(512)).setAttribute("height","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:506   */

      /* Empieza nodo:513 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(513)).setAttribute("nombre","formTr15" );
      ((Element)v.get(15)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("align","center" );
      ((Element)v.get(514)).setAttribute("width","12" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","12" );
      ((Element)v.get(515)).setAttribute("height","12" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 513   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(516)).setAttribute("width","100%" );
      ((Element)v.get(513)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(517)).setAttribute("width","100%" );
      ((Element)v.get(517)).setAttribute("border","0" );
      ((Element)v.get(517)).setAttribute("cellspacing","0" );
      ((Element)v.get(517)).setAttribute("cellpadding","0" );
      ((Element)v.get(517)).setAttribute("align","left" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(518)).setAttribute("align","left" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(519)).setAttribute("nombre","jeraOidJeraTdId" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(520)).setAttribute("border","0" );
      ((Element)v.get(520)).setAttribute("cellspacing","0" );
      ((Element)v.get(520)).setAttribute("cellpadding","0" );
      ((Element)v.get(520)).setAttribute("align","left" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(520)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(522)).setAttribute("valign","top" );
      ((Element)v.get(522)).setAttribute("height","13" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(523)).setAttribute("nombre","lbljeraOidJera" );
      ((Element)v.get(523)).setAttribute("id","datosTitle" );
      ((Element)v.get(523)).setAttribute("ancho","100" );
      ((Element)v.get(523)).setAttribute("alto","13" );
      ((Element)v.get(523)).setAttribute("cod","CarSoliEntrBloq.jeraOidJera.label" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:524 / Elemento padre: 520   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(524)).setAttribute("nombre","jeraOidJeraWidgetTrId" );
      ((Element)v.get(520)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).setAttribute("align","left" );
      ((Element)v.get(525)).setAttribute("nowrap","true" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(526)).setAttribute("nombre","jeraOidJera" );
      ((Element)v.get(526)).setAttribute("id","datosCampos" );
      ((Element)v.get(526)).setAttribute("multiple","N" );
      ((Element)v.get(526)).setAttribute("req","N" );
      ((Element)v.get(526)).setAttribute("size","1" );
      ((Element)v.get(526)).setAttribute("validacion","" );
      ((Element)v.get(526)).setAttribute("onchange","" );
      ((Element)v.get(526)).setAttribute("onfocus","" );
      ((Element)v.get(526)).setAttribute("valorinicial","" );
      ((Element)v.get(526)).setAttribute("textoinicial","" );
      ((Element)v.get(526)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(526)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:528 / Elemento padre: 520   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(528)).setAttribute("nombre","jeraOidJeraViewLabelTrId" );
      ((Element)v.get(520)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(529)).setAttribute("valign","top" );
      ((Element)v.get(529)).setAttribute("height","13" );
      ((Element)v.get(529)).setAttribute("width","50" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(530)).setAttribute("nombre","lblViewJeraOidJera" );
      ((Element)v.get(530)).setAttribute("alto","13" );
      ((Element)v.get(530)).setAttribute("filas","1" );
      ((Element)v.get(530)).setAttribute("id","EstDat" );
      ((Element)v.get(530)).setAttribute("valor","" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:531 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(531)).setAttribute("nombre","jeraOidJeraGapTdId" );
      ((Element)v.get(531)).setAttribute("nowrap","true" );
      ((Element)v.get(531)).setAttribute("class","datosCampos" );
      ((Element)v.get(518)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","25" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(533)).setAttribute("width","100%" );
      ((Element)v.get(518)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:513   */

      /* Empieza nodo:535 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(535)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(15)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(536)).setAttribute("align","center" );
      ((Element)v.get(536)).setAttribute("width","12" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","12" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 535   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(535)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","8" );
      ((Element)v.get(539)).setAttribute("height","8" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 535   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(540)).setAttribute("align","center" );
      ((Element)v.get(540)).setAttribute("width","12" );
      ((Element)v.get(535)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).setAttribute("width","12" );
      ((Element)v.get(541)).setAttribute("height","8" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */
      /* Termina nodo:535   */

      /* Empieza nodo:542 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(542)).setAttribute("nombre","formTr16" );
      ((Element)v.get(15)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(543)).setAttribute("align","center" );
      ((Element)v.get(543)).setAttribute("width","12" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(544)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).setAttribute("width","12" );
      ((Element)v.get(544)).setAttribute("height","12" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 542   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(545)).setAttribute("width","100%" );
      ((Element)v.get(542)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(546)).setAttribute("width","100%" );
      ((Element)v.get(546)).setAttribute("border","0" );
      ((Element)v.get(546)).setAttribute("cellspacing","0" );
      ((Element)v.get(546)).setAttribute("cellpadding","0" );
      ((Element)v.get(546)).setAttribute("align","left" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(547)).setAttribute("align","left" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(548)).setAttribute("nombre","espeOidEstaPediTdId" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(549)).setAttribute("border","0" );
      ((Element)v.get(549)).setAttribute("cellspacing","0" );
      ((Element)v.get(549)).setAttribute("cellpadding","0" );
      ((Element)v.get(549)).setAttribute("align","left" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("valign","top" );
      ((Element)v.get(551)).setAttribute("height","13" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(552)).setAttribute("nombre","lblespeOidEstaPedi" );
      ((Element)v.get(552)).setAttribute("id","datosTitle" );
      ((Element)v.get(552)).setAttribute("ancho","100" );
      ((Element)v.get(552)).setAttribute("alto","13" );
      ((Element)v.get(552)).setAttribute("cod","CarSoliEntrBloq.espeOidEstaPedi.label" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:553 / Elemento padre: 549   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(553)).setAttribute("nombre","espeOidEstaPediWidgetTrId" );
      ((Element)v.get(549)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(554)).setAttribute("align","left" );
      ((Element)v.get(554)).setAttribute("nowrap","true" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(555)).setAttribute("nombre","espeOidEstaPedi" );
      ((Element)v.get(555)).setAttribute("id","datosCampos" );
      ((Element)v.get(555)).setAttribute("multiple","N" );
      ((Element)v.get(555)).setAttribute("req","N" );
      ((Element)v.get(555)).setAttribute("size","1" );
      ((Element)v.get(555)).setAttribute("validacion","" );
      ((Element)v.get(555)).setAttribute("onchange","" );
      ((Element)v.get(555)).setAttribute("onfocus","" );
      ((Element)v.get(555)).setAttribute("valorinicial","" );
      ((Element)v.get(555)).setAttribute("textoinicial","" );
      ((Element)v.get(555)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(555)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:557 / Elemento padre: 549   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(557)).setAttribute("nombre","espeOidEstaPediViewLabelTrId" );
      ((Element)v.get(549)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(558)).setAttribute("valign","top" );
      ((Element)v.get(558)).setAttribute("height","13" );
      ((Element)v.get(558)).setAttribute("width","40" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(559)).setAttribute("nombre","lblViewEspeOidEstaPedi" );
      ((Element)v.get(559)).setAttribute("alto","13" );
      ((Element)v.get(559)).setAttribute("filas","1" );
      ((Element)v.get(559)).setAttribute("id","EstDat" );
      ((Element)v.get(559)).setAttribute("valor","" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:560 / Elemento padre: 547   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(560)).setAttribute("nombre","espeOidEstaPediGapTdId" );
      ((Element)v.get(560)).setAttribute("nowrap","true" );
      ((Element)v.get(560)).setAttribute("class","datosCampos" );
      ((Element)v.get(547)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","25" );
      ((Element)v.get(561)).setAttribute("height","8" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 547   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).setAttribute("width","100%" );
      ((Element)v.get(547)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(563)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:542   */

      /* Empieza nodo:564 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(564)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(15)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(565)).setAttribute("align","center" );
      ((Element)v.get(565)).setAttribute("width","12" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","12" );
      ((Element)v.get(566)).setAttribute("height","8" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 564   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(564)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).setAttribute("width","8" );
      ((Element)v.get(568)).setAttribute("height","8" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 564   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("align","center" );
      ((Element)v.get(569)).setAttribute("width","12" );
      ((Element)v.get(564)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","12" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:564   */

      /* Empieza nodo:571 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(571)).setAttribute("nombre","formTr17" );
      ((Element)v.get(15)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(572)).setAttribute("align","center" );
      ((Element)v.get(572)).setAttribute("width","12" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","12" );
      ((Element)v.get(573)).setAttribute("height","12" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(574)).setAttribute("width","100%" );
      ((Element)v.get(571)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(575)).setAttribute("width","100%" );
      ((Element)v.get(575)).setAttribute("border","0" );
      ((Element)v.get(575)).setAttribute("cellspacing","0" );
      ((Element)v.get(575)).setAttribute("cellpadding","0" );
      ((Element)v.get(575)).setAttribute("align","left" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(576)).setAttribute("align","left" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(577)).setAttribute("nombre","perdOidPeriTdId" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(578)).setAttribute("border","0" );
      ((Element)v.get(578)).setAttribute("cellspacing","0" );
      ((Element)v.get(578)).setAttribute("cellpadding","0" );
      ((Element)v.get(578)).setAttribute("align","left" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(580)).setAttribute("valign","top" );
      ((Element)v.get(580)).setAttribute("height","13" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(581)).setAttribute("nombre","lblperdOidPeri" );
      ((Element)v.get(581)).setAttribute("id","datosTitle" );
      ((Element)v.get(581)).setAttribute("ancho","100" );
      ((Element)v.get(581)).setAttribute("alto","13" );
      ((Element)v.get(581)).setAttribute("cod","CarSoliEntrBloq.perdOidPeri.label" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:582 / Elemento padre: 578   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(582)).setAttribute("nombre","perdOidPeriWidgetTrId" );
      ((Element)v.get(578)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("align","left" );
      ((Element)v.get(583)).setAttribute("nowrap","true" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(584)).setAttribute("nombre","perdOidPeri" );
      ((Element)v.get(584)).setAttribute("id","datosCampos" );
      ((Element)v.get(584)).setAttribute("multiple","N" );
      ((Element)v.get(584)).setAttribute("req","N" );
      ((Element)v.get(584)).setAttribute("size","1" );
      ((Element)v.get(584)).setAttribute("validacion","" );
      ((Element)v.get(584)).setAttribute("onchange","" );
      ((Element)v.get(584)).setAttribute("onfocus","" );
      ((Element)v.get(584)).setAttribute("valorinicial","" );
      ((Element)v.get(584)).setAttribute("textoinicial","" );
      ((Element)v.get(584)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(584)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:586 / Elemento padre: 578   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(586)).setAttribute("nombre","perdOidPeriViewLabelTrId" );
      ((Element)v.get(578)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(587)).setAttribute("valign","top" );
      ((Element)v.get(587)).setAttribute("height","13" );
      ((Element)v.get(587)).setAttribute("width","50" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(588)).setAttribute("nombre","lblViewPerdOidPeri" );
      ((Element)v.get(588)).setAttribute("alto","13" );
      ((Element)v.get(588)).setAttribute("filas","1" );
      ((Element)v.get(588)).setAttribute("id","EstDat" );
      ((Element)v.get(588)).setAttribute("valor","" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:589 / Elemento padre: 576   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(589)).setAttribute("nombre","perdOidPeriGapTdId" );
      ((Element)v.get(589)).setAttribute("nowrap","true" );
      ((Element)v.get(589)).setAttribute("class","datosCampos" );
      ((Element)v.get(576)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(590)).setAttribute("width","25" );
      ((Element)v.get(590)).setAttribute("height","8" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 576   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("width","100%" );
      ((Element)v.get(576)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:571   */

      /* Empieza nodo:593 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(593)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(15)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(594)).setAttribute("align","center" );
      ((Element)v.get(594)).setAttribute("width","12" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(595)).setAttribute("src","b.gif" );
      ((Element)v.get(595)).setAttribute("width","12" );
      ((Element)v.get(595)).setAttribute("height","8" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 593   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(593)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","8" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 593   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(598)).setAttribute("align","center" );
      ((Element)v.get(598)).setAttribute("width","12" );
      ((Element)v.get(593)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(599)).setAttribute("width","12" );
      ((Element)v.get(599)).setAttribute("height","8" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */
      /* Termina nodo:593   */

      /* Empieza nodo:600 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(600)).setAttribute("nombre","formTr18" );
      ((Element)v.get(15)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(601)).setAttribute("align","center" );
      ((Element)v.get(601)).setAttribute("width","12" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(602)).setAttribute("src","b.gif" );
      ((Element)v.get(602)).setAttribute("width","12" );
      ((Element)v.get(602)).setAttribute("height","12" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 600   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(603)).setAttribute("width","100%" );
      ((Element)v.get(600)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(604)).setAttribute("border","0" );
      ((Element)v.get(604)).setAttribute("cellspacing","0" );
      ((Element)v.get(604)).setAttribute("cellpadding","0" );
      ((Element)v.get(604)).setAttribute("align","left" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(605)).setAttribute("align","left" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(606)).setAttribute("nombre","clieOidClieTdId" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(607)).setAttribute("border","0" );
      ((Element)v.get(607)).setAttribute("cellspacing","0" );
      ((Element)v.get(607)).setAttribute("cellpadding","0" );
      ((Element)v.get(607)).setAttribute("align","left" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(609)).setAttribute("valign","top" );
      ((Element)v.get(609)).setAttribute("height","13" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(610)).setAttribute("nombre","lblclieOidClie" );
      ((Element)v.get(610)).setAttribute("id","datosTitle" );
      ((Element)v.get(610)).setAttribute("ancho","100" );
      ((Element)v.get(610)).setAttribute("alto","13" );
      ((Element)v.get(610)).setAttribute("cod","CarSoliEntrBloq.clieOidClie.label" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:611 / Elemento padre: 607   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(611)).setAttribute("nombre","clieOidClieWidgetTrId" );
      ((Element)v.get(607)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(612)).setAttribute("align","left" );
      ((Element)v.get(612)).setAttribute("nowrap","true" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(613)).setAttribute("nombre","clieOidClie" );
      ((Element)v.get(613)).setAttribute("id","datosCampos" );
      ((Element)v.get(613)).setAttribute("multiple","N" );
      ((Element)v.get(613)).setAttribute("req","N" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(613)).setAttribute("size","1" );
      ((Element)v.get(613)).setAttribute("validacion","" );
      ((Element)v.get(613)).setAttribute("onchange","" );
      ((Element)v.get(613)).setAttribute("onfocus","" );
      ((Element)v.get(613)).setAttribute("valorinicial","" );
      ((Element)v.get(613)).setAttribute("textoinicial","" );
      ((Element)v.get(613)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(613)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:615 / Elemento padre: 607   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(615)).setAttribute("nombre","clieOidClieViewLabelTrId" );
      ((Element)v.get(607)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("valign","top" );
      ((Element)v.get(616)).setAttribute("height","13" );
      ((Element)v.get(616)).setAttribute("width","15" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(617)).setAttribute("nombre","lblViewClieOidClie" );
      ((Element)v.get(617)).setAttribute("alto","13" );
      ((Element)v.get(617)).setAttribute("filas","1" );
      ((Element)v.get(617)).setAttribute("id","EstDat" );
      ((Element)v.get(617)).setAttribute("valor","" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:615   */
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:618 / Elemento padre: 605   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(618)).setAttribute("nombre","clieOidClieGapTdId" );
      ((Element)v.get(618)).setAttribute("nowrap","true" );
      ((Element)v.get(618)).setAttribute("class","datosCampos" );
      ((Element)v.get(605)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(619)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).setAttribute("width","25" );
      ((Element)v.get(619)).setAttribute("height","8" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 605   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(620)).setAttribute("width","100%" );
      ((Element)v.get(605)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:605   */
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:600   */

      /* Empieza nodo:622 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(622)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(15)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(623)).setAttribute("align","center" );
      ((Element)v.get(623)).setAttribute("width","12" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","12" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:625 / Elemento padre: 622   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(622)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","8" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 622   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(627)).setAttribute("align","center" );
      ((Element)v.get(627)).setAttribute("width","12" );
      ((Element)v.get(622)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(628)).setAttribute("src","b.gif" );
      ((Element)v.get(628)).setAttribute("width","12" );
      ((Element)v.get(628)).setAttribute("height","8" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:622   */

      /* Empieza nodo:629 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(629)).setAttribute("nombre","formTr19" );
      ((Element)v.get(15)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(630)).setAttribute("align","center" );
      ((Element)v.get(630)).setAttribute("width","12" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","12" );
      ((Element)v.get(631)).setAttribute("height","12" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 629   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(632)).setAttribute("width","100%" );
      ((Element)v.get(629)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(633)).setAttribute("width","100%" );
      ((Element)v.get(633)).setAttribute("border","0" );
      ((Element)v.get(633)).setAttribute("cellspacing","0" );
      ((Element)v.get(633)).setAttribute("cellpadding","0" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(633)).setAttribute("align","left" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(634)).setAttribute("align","left" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(635)).setAttribute("nombre","clieOidGereZonaTdId" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(636)).setAttribute("border","0" );
      ((Element)v.get(636)).setAttribute("cellspacing","0" );
      ((Element)v.get(636)).setAttribute("cellpadding","0" );
      ((Element)v.get(636)).setAttribute("align","left" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(638)).setAttribute("valign","top" );
      ((Element)v.get(638)).setAttribute("height","13" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(639)).setAttribute("nombre","lblclieOidGereZona" );
      ((Element)v.get(639)).setAttribute("id","datosTitle" );
      ((Element)v.get(639)).setAttribute("ancho","100" );
      ((Element)v.get(639)).setAttribute("alto","13" );
      ((Element)v.get(639)).setAttribute("cod","CarSoliEntrBloq.clieOidGereZona.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */
      /* Termina nodo:637   */

      /* Empieza nodo:640 / Elemento padre: 636   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(640)).setAttribute("nombre","clieOidGereZonaWidgetTrId" );
      ((Element)v.get(636)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(641)).setAttribute("align","left" );
      ((Element)v.get(641)).setAttribute("nowrap","true" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(642)).setAttribute("nombre","clieOidGereZona" );
      ((Element)v.get(642)).setAttribute("id","datosCampos" );
      ((Element)v.get(642)).setAttribute("multiple","N" );
      ((Element)v.get(642)).setAttribute("req","N" );
      ((Element)v.get(642)).setAttribute("size","1" );
      ((Element)v.get(642)).setAttribute("validacion","" );
      ((Element)v.get(642)).setAttribute("onchange","" );
      ((Element)v.get(642)).setAttribute("onfocus","" );
      ((Element)v.get(642)).setAttribute("valorinicial","" );
      ((Element)v.get(642)).setAttribute("textoinicial","" );
      ((Element)v.get(642)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(642)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */
      /* Termina nodo:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:644 / Elemento padre: 636   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(644)).setAttribute("nombre","clieOidGereZonaViewLabelTrId" );
      ((Element)v.get(636)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(645)).setAttribute("valign","top" );
      ((Element)v.get(645)).setAttribute("height","13" );
      ((Element)v.get(645)).setAttribute("width","15" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(646)).setAttribute("nombre","lblViewClieOidGereZona" );
      ((Element)v.get(646)).setAttribute("alto","13" );
      ((Element)v.get(646)).setAttribute("filas","1" );
      ((Element)v.get(646)).setAttribute("id","EstDat" );
      ((Element)v.get(646)).setAttribute("valor","" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */
      /* Termina nodo:636   */
      /* Termina nodo:635   */

      /* Empieza nodo:647 / Elemento padre: 634   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(647)).setAttribute("nombre","clieOidGereZonaGapTdId" );
      ((Element)v.get(647)).setAttribute("nowrap","true" );
      ((Element)v.get(647)).setAttribute("class","datosCampos" );
      ((Element)v.get(634)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(648)).setAttribute("src","b.gif" );
      ((Element)v.get(648)).setAttribute("width","25" );
      ((Element)v.get(648)).setAttribute("height","8" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */

      /* Empieza nodo:649 / Elemento padre: 634   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(649)).setAttribute("width","100%" );
      ((Element)v.get(634)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(650)).setAttribute("src","b.gif" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:634   */
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:629   */

      /* Empieza nodo:651 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(651)).setAttribute("nombre","formGapTr19" );
      ((Element)v.get(15)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(652)).setAttribute("align","center" );
      ((Element)v.get(652)).setAttribute("width","12" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(653)).setAttribute("src","b.gif" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(653)).setAttribute("width","12" );
      ((Element)v.get(653)).setAttribute("height","8" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:654 / Elemento padre: 651   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(651)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(655)).setAttribute("src","b.gif" );
      ((Element)v.get(655)).setAttribute("width","8" );
      ((Element)v.get(655)).setAttribute("height","8" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:654   */

      /* Empieza nodo:656 / Elemento padre: 651   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(656)).setAttribute("align","center" );
      ((Element)v.get(656)).setAttribute("width","12" );
      ((Element)v.get(651)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","12" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */
      /* Termina nodo:651   */

      /* Empieza nodo:658 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(658)).setAttribute("nombre","formTr20" );
      ((Element)v.get(15)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(659)).setAttribute("align","center" );
      ((Element)v.get(659)).setAttribute("width","12" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(660)).setAttribute("src","b.gif" );
      ((Element)v.get(660)).setAttribute("width","12" );
      ((Element)v.get(660)).setAttribute("height","12" );
      ((Element)v.get(659)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:659   */

      /* Empieza nodo:661 / Elemento padre: 658   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(661)).setAttribute("width","100%" );
      ((Element)v.get(658)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(662)).setAttribute("width","100%" );
      ((Element)v.get(662)).setAttribute("border","0" );
      ((Element)v.get(662)).setAttribute("cellspacing","0" );
      ((Element)v.get(662)).setAttribute("cellpadding","0" );
      ((Element)v.get(662)).setAttribute("align","left" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(663)).setAttribute("align","left" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(664)).setAttribute("nombre","cuadOidClieUnidAdmiTdId" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(665)).setAttribute("border","0" );
      ((Element)v.get(665)).setAttribute("cellspacing","0" );
      ((Element)v.get(665)).setAttribute("cellpadding","0" );
      ((Element)v.get(665)).setAttribute("align","left" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(665)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(667)).setAttribute("valign","top" );
      ((Element)v.get(667)).setAttribute("height","13" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(668)).setAttribute("nombre","lblcuadOidClieUnidAdmi" );
      ((Element)v.get(668)).setAttribute("id","datosTitle" );
      ((Element)v.get(668)).setAttribute("ancho","100" );
      ((Element)v.get(668)).setAttribute("alto","13" );
      ((Element)v.get(668)).setAttribute("cod","CarSoliEntrBloq.cuadOidClieUnidAdmi.label" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:669 / Elemento padre: 665   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(669)).setAttribute("nombre","cuadOidClieUnidAdmiWidgetTrId" );
      ((Element)v.get(665)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(670)).setAttribute("align","left" );
      ((Element)v.get(670)).setAttribute("nowrap","true" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(671)).setAttribute("nombre","cuadOidClieUnidAdmi" );
      ((Element)v.get(671)).setAttribute("id","datosCampos" );
      ((Element)v.get(671)).setAttribute("multiple","N" );
      ((Element)v.get(671)).setAttribute("req","N" );
      ((Element)v.get(671)).setAttribute("size","1" );
      ((Element)v.get(671)).setAttribute("validacion","" );
      ((Element)v.get(671)).setAttribute("onchange","" );
      ((Element)v.get(671)).setAttribute("onfocus","" );
      ((Element)v.get(671)).setAttribute("valorinicial","" );
      ((Element)v.get(671)).setAttribute("textoinicial","" );
      ((Element)v.get(671)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(671)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:671   */
      /* Termina nodo:670   */
      /* Termina nodo:669   */

      /* Empieza nodo:673 / Elemento padre: 665   */
      v.add(doc.createElement("TR"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(673)).setAttribute("nombre","cuadOidClieUnidAdmiViewLabelTrId" );
      ((Element)v.get(665)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(674)).setAttribute("valign","top" );
      ((Element)v.get(674)).setAttribute("height","13" );
      ((Element)v.get(674)).setAttribute("width","50" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(675)).setAttribute("nombre","lblViewCuadOidClieUnidAdmi" );
      ((Element)v.get(675)).setAttribute("alto","13" );
      ((Element)v.get(675)).setAttribute("filas","1" );
      ((Element)v.get(675)).setAttribute("id","EstDat" );
      ((Element)v.get(675)).setAttribute("valor","" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */
      /* Termina nodo:674   */
      /* Termina nodo:673   */
      /* Termina nodo:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:676 / Elemento padre: 663   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(676)).setAttribute("nombre","cuadOidClieUnidAdmiGapTdId" );
      ((Element)v.get(676)).setAttribute("nowrap","true" );
      ((Element)v.get(676)).setAttribute("class","datosCampos" );
      ((Element)v.get(663)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(677)).setAttribute("src","b.gif" );
      ((Element)v.get(677)).setAttribute("width","25" );
      ((Element)v.get(677)).setAttribute("height","8" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */
      /* Termina nodo:676   */

      /* Empieza nodo:678 / Elemento padre: 663   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(678)).setAttribute("width","100%" );
      ((Element)v.get(663)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(679)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:678   */
      /* Termina nodo:663   */
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:658   */

      /* Empieza nodo:680 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(680)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(15)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(681)).setAttribute("align","center" );
      ((Element)v.get(681)).setAttribute("width","12" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(682)).setAttribute("src","b.gif" );
      ((Element)v.get(682)).setAttribute("width","12" );
      ((Element)v.get(682)).setAttribute("height","8" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 680   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(680)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(684)).setAttribute("src","b.gif" );
      ((Element)v.get(684)).setAttribute("width","8" );
      ((Element)v.get(684)).setAttribute("height","8" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 680   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(685)).setAttribute("align","center" );
      ((Element)v.get(685)).setAttribute("width","12" );
      ((Element)v.get(680)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("width","12" );
      ((Element)v.get(686)).setAttribute("height","8" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:680   */

      /* Empieza nodo:687 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(687)).setAttribute("nombre","formTr21" );
      ((Element)v.get(15)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(688)).setAttribute("align","center" );
      ((Element)v.get(688)).setAttribute("width","12" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(689)).setAttribute("src","b.gif" );
      ((Element)v.get(689)).setAttribute("width","12" );
      ((Element)v.get(689)).setAttribute("height","12" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 687   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(690)).setAttribute("width","100%" );
      ((Element)v.get(687)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(691)).setAttribute("width","100%" );
      ((Element)v.get(691)).setAttribute("border","0" );
      ((Element)v.get(691)).setAttribute("cellspacing","0" );
      ((Element)v.get(691)).setAttribute("cellpadding","0" );
      ((Element)v.get(691)).setAttribute("align","left" );
      ((Element)v.get(690)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(692)).setAttribute("align","left" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(693)).setAttribute("nombre","coapOidCodiAproTdId" );
      ((Element)v.get(692)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(694)).setAttribute("border","0" );
      ((Element)v.get(694)).setAttribute("cellspacing","0" );
      ((Element)v.get(694)).setAttribute("cellpadding","0" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(694)).setAttribute("align","left" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(694)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(696)).setAttribute("valign","top" );
      ((Element)v.get(696)).setAttribute("height","13" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(697)).setAttribute("nombre","lblcoapOidCodiApro" );
      ((Element)v.get(697)).setAttribute("id","datosTitle" );
      ((Element)v.get(697)).setAttribute("ancho","100" );
      ((Element)v.get(697)).setAttribute("alto","13" );
      ((Element)v.get(697)).setAttribute("cod","CarSoliEntrBloq.coapOidCodiApro.label" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:698 / Elemento padre: 694   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(698)).setAttribute("nombre","coapOidCodiAproWidgetTrId" );
      ((Element)v.get(694)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(699)).setAttribute("align","left" );
      ((Element)v.get(699)).setAttribute("nowrap","true" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(700)).setAttribute("nombre","coapOidCodiApro" );
      ((Element)v.get(700)).setAttribute("id","datosCampos" );
      ((Element)v.get(700)).setAttribute("multiple","N" );
      ((Element)v.get(700)).setAttribute("req","N" );
      ((Element)v.get(700)).setAttribute("size","1" );
      ((Element)v.get(700)).setAttribute("validacion","" );
      ((Element)v.get(700)).setAttribute("onchange","" );
      ((Element)v.get(700)).setAttribute("onfocus","" );
      ((Element)v.get(700)).setAttribute("valorinicial","" );
      ((Element)v.get(700)).setAttribute("textoinicial","" );
      ((Element)v.get(700)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(700)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */
      /* Termina nodo:700   */
      /* Termina nodo:699   */
      /* Termina nodo:698   */

      /* Empieza nodo:702 / Elemento padre: 694   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(702)).setAttribute("nombre","coapOidCodiAproViewLabelTrId" );
      ((Element)v.get(694)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(703)).setAttribute("valign","top" );
      ((Element)v.get(703)).setAttribute("height","13" );
      ((Element)v.get(703)).setAttribute("width","30" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(704)).setAttribute("nombre","lblViewCoapOidCodiApro" );
      ((Element)v.get(704)).setAttribute("alto","13" );
      ((Element)v.get(704)).setAttribute("filas","1" );
      ((Element)v.get(704)).setAttribute("id","EstDat" );
      ((Element)v.get(704)).setAttribute("valor","" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */
      /* Termina nodo:702   */
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:705 / Elemento padre: 692   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(705)).setAttribute("nombre","coapOidCodiAproGapTdId" );
      ((Element)v.get(705)).setAttribute("nowrap","true" );
      ((Element)v.get(705)).setAttribute("class","datosCampos" );
      ((Element)v.get(692)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(706)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).setAttribute("width","25" );
      ((Element)v.get(706)).setAttribute("height","8" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */

      /* Empieza nodo:707 / Elemento padre: 692   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(707)).setAttribute("width","100%" );
      ((Element)v.get(692)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(708)).setAttribute("src","b.gif" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */
      /* Termina nodo:707   */
      /* Termina nodo:692   */
      /* Termina nodo:691   */
      /* Termina nodo:690   */
      /* Termina nodo:687   */

      /* Empieza nodo:709 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(709)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(15)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(710)).setAttribute("align","center" );
      ((Element)v.get(710)).setAttribute("width","12" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(711)).setAttribute("src","b.gif" );
      ((Element)v.get(711)).setAttribute("width","12" );
      ((Element)v.get(711)).setAttribute("height","8" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */

      /* Empieza nodo:712 / Elemento padre: 709   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(709)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(713)).setAttribute("src","b.gif" );
      ((Element)v.get(713)).setAttribute("width","8" );
      ((Element)v.get(713)).setAttribute("height","8" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */
      /* Termina nodo:712   */

      /* Empieza nodo:714 / Elemento padre: 709   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(714)).setAttribute("align","center" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(714)).setAttribute("width","12" );
      ((Element)v.get(709)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(715)).setAttribute("src","b.gif" );
      ((Element)v.get(715)).setAttribute("width","12" );
      ((Element)v.get(715)).setAttribute("height","8" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:714   */
      /* Termina nodo:709   */

      /* Empieza nodo:716 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(716)).setAttribute("nombre","formTr22" );
      ((Element)v.get(15)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(717)).setAttribute("align","center" );
      ((Element)v.get(717)).setAttribute("width","12" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(718)).setAttribute("src","b.gif" );
      ((Element)v.get(718)).setAttribute("width","12" );
      ((Element)v.get(718)).setAttribute("height","12" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:717   */

      /* Empieza nodo:719 / Elemento padre: 716   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(719)).setAttribute("width","100%" );
      ((Element)v.get(716)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(720)).setAttribute("width","100%" );
      ((Element)v.get(720)).setAttribute("border","0" );
      ((Element)v.get(720)).setAttribute("cellspacing","0" );
      ((Element)v.get(720)).setAttribute("cellpadding","0" );
      ((Element)v.get(720)).setAttribute("align","left" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(721)).setAttribute("align","left" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(722)).setAttribute("nombre","ejcuOidEjecCuenTdId" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(723)).setAttribute("border","0" );
      ((Element)v.get(723)).setAttribute("cellspacing","0" );
      ((Element)v.get(723)).setAttribute("cellpadding","0" );
      ((Element)v.get(723)).setAttribute("align","left" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(723)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(725)).setAttribute("valign","top" );
      ((Element)v.get(725)).setAttribute("height","13" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(726)).setAttribute("nombre","lblejcuOidEjecCuen" );
      ((Element)v.get(726)).setAttribute("id","datosTitle" );
      ((Element)v.get(726)).setAttribute("ancho","100" );
      ((Element)v.get(726)).setAttribute("alto","13" );
      ((Element)v.get(726)).setAttribute("cod","CarSoliEntrBloq.ejcuOidEjecCuen.label" );
      ((Element)v.get(725)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */
      /* Termina nodo:725   */
      /* Termina nodo:724   */

      /* Empieza nodo:727 / Elemento padre: 723   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(727)).setAttribute("nombre","ejcuOidEjecCuenWidgetTrId" );
      ((Element)v.get(723)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(728)).setAttribute("align","left" );
      ((Element)v.get(728)).setAttribute("nowrap","true" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(729)).setAttribute("nombre","ejcuOidEjecCuen" );
      ((Element)v.get(729)).setAttribute("id","datosCampos" );
      ((Element)v.get(729)).setAttribute("multiple","N" );
      ((Element)v.get(729)).setAttribute("req","N" );
      ((Element)v.get(729)).setAttribute("size","1" );
      ((Element)v.get(729)).setAttribute("validacion","" );
      ((Element)v.get(729)).setAttribute("onchange","" );
      ((Element)v.get(729)).setAttribute("onfocus","" );
      ((Element)v.get(729)).setAttribute("valorinicial","" );
      ((Element)v.get(729)).setAttribute("textoinicial","" );
      ((Element)v.get(729)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(729)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */
      /* Termina nodo:728   */
      /* Termina nodo:727   */

      /* Empieza nodo:731 / Elemento padre: 723   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(731)).setAttribute("nombre","ejcuOidEjecCuenViewLabelTrId" );
      ((Element)v.get(723)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(732)).setAttribute("valign","top" );
      ((Element)v.get(732)).setAttribute("height","13" );
      ((Element)v.get(732)).setAttribute("width","50" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(733)).setAttribute("nombre","lblViewEjcuOidEjecCuen" );
      ((Element)v.get(733)).setAttribute("alto","13" );
      ((Element)v.get(733)).setAttribute("filas","1" );
      ((Element)v.get(733)).setAttribute("id","EstDat" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(733)).setAttribute("valor","" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:723   */
      /* Termina nodo:722   */

      /* Empieza nodo:734 / Elemento padre: 721   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(734)).setAttribute("nombre","ejcuOidEjecCuenGapTdId" );
      ((Element)v.get(734)).setAttribute("nowrap","true" );
      ((Element)v.get(734)).setAttribute("class","datosCampos" );
      ((Element)v.get(721)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).setAttribute("width","25" );
      ((Element)v.get(735)).setAttribute("height","8" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 721   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(736)).setAttribute("width","100%" );
      ((Element)v.get(721)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(737)).setAttribute("src","b.gif" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */
      /* Termina nodo:736   */
      /* Termina nodo:721   */
      /* Termina nodo:720   */
      /* Termina nodo:719   */
      /* Termina nodo:716   */

      /* Empieza nodo:738 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(738)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(15)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(739)).setAttribute("align","center" );
      ((Element)v.get(739)).setAttribute("width","12" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(740)).setAttribute("src","b.gif" );
      ((Element)v.get(740)).setAttribute("width","12" );
      ((Element)v.get(740)).setAttribute("height","8" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */

      /* Empieza nodo:741 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(738)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(742)).setAttribute("src","b.gif" );
      ((Element)v.get(742)).setAttribute("width","8" );
      ((Element)v.get(742)).setAttribute("height","8" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:743 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(743)).setAttribute("align","center" );
      ((Element)v.get(743)).setAttribute("width","12" );
      ((Element)v.get(738)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(744)).setAttribute("src","b.gif" );
      ((Element)v.get(744)).setAttribute("width","12" );
      ((Element)v.get(744)).setAttribute("height","8" );
      ((Element)v.get(743)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */
      /* Termina nodo:743   */
      /* Termina nodo:738   */

      /* Empieza nodo:745 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(745)).setAttribute("nombre","formTr23" );
      ((Element)v.get(15)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(746)).setAttribute("align","center" );
      ((Element)v.get(746)).setAttribute("width","12" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(747)).setAttribute("src","b.gif" );
      ((Element)v.get(747)).setAttribute("width","12" );
      ((Element)v.get(747)).setAttribute("height","12" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */
      /* Termina nodo:746   */

      /* Empieza nodo:748 / Elemento padre: 745   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(748)).setAttribute("width","100%" );
      ((Element)v.get(745)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(749)).setAttribute("width","100%" );
      ((Element)v.get(749)).setAttribute("border","0" );
      ((Element)v.get(749)).setAttribute("cellspacing","0" );
      ((Element)v.get(749)).setAttribute("cellpadding","0" );
      ((Element)v.get(749)).setAttribute("align","left" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(750)).setAttribute("align","left" );
      ((Element)v.get(749)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(751)).setAttribute("nombre","ejcuOidUsuaLibeTdId" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(752)).setAttribute("border","0" );
      ((Element)v.get(752)).setAttribute("cellspacing","0" );
      ((Element)v.get(752)).setAttribute("cellpadding","0" );
      ((Element)v.get(752)).setAttribute("align","left" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(752)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(754)).setAttribute("valign","top" );
      ((Element)v.get(754)).setAttribute("height","13" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(755)).setAttribute("nombre","lblejcuOidUsuaLibe" );
      ((Element)v.get(755)).setAttribute("id","datosTitle" );
      ((Element)v.get(755)).setAttribute("ancho","100" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(755)).setAttribute("alto","13" );
      ((Element)v.get(755)).setAttribute("cod","CarSoliEntrBloq.ejcuOidUsuaLibe.label" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */
      /* Termina nodo:753   */

      /* Empieza nodo:756 / Elemento padre: 752   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(756)).setAttribute("nombre","ejcuOidUsuaLibeWidgetTrId" );
      ((Element)v.get(752)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(757)).setAttribute("align","left" );
      ((Element)v.get(757)).setAttribute("nowrap","true" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(758)).setAttribute("nombre","ejcuOidUsuaLibe" );
      ((Element)v.get(758)).setAttribute("id","datosCampos" );
      ((Element)v.get(758)).setAttribute("multiple","N" );
      ((Element)v.get(758)).setAttribute("req","N" );
      ((Element)v.get(758)).setAttribute("size","1" );
      ((Element)v.get(758)).setAttribute("validacion","" );
      ((Element)v.get(758)).setAttribute("onchange","" );
      ((Element)v.get(758)).setAttribute("onfocus","" );
      ((Element)v.get(758)).setAttribute("valorinicial","" );
      ((Element)v.get(758)).setAttribute("textoinicial","" );
      ((Element)v.get(758)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(758)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(758)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:757   */
      /* Termina nodo:756   */

      /* Empieza nodo:760 / Elemento padre: 752   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(760)).setAttribute("nombre","ejcuOidUsuaLibeViewLabelTrId" );
      ((Element)v.get(752)).appendChild((Element)v.get(760));

      /* Empieza nodo:761 / Elemento padre: 760   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(761)).setAttribute("valign","top" );
      ((Element)v.get(761)).setAttribute("height","13" );
      ((Element)v.get(761)).setAttribute("width","50" );
      ((Element)v.get(760)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(762)).setAttribute("nombre","lblViewEjcuOidUsuaLibe" );
      ((Element)v.get(762)).setAttribute("alto","13" );
      ((Element)v.get(762)).setAttribute("filas","1" );
      ((Element)v.get(762)).setAttribute("id","EstDat" );
      ((Element)v.get(762)).setAttribute("valor","" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */
      /* Termina nodo:760   */
      /* Termina nodo:752   */
      /* Termina nodo:751   */

      /* Empieza nodo:763 / Elemento padre: 750   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(763)).setAttribute("nombre","ejcuOidUsuaLibeGapTdId" );
      ((Element)v.get(763)).setAttribute("nowrap","true" );
      ((Element)v.get(763)).setAttribute("class","datosCampos" );
      ((Element)v.get(750)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(764)).setAttribute("src","b.gif" );
      ((Element)v.get(764)).setAttribute("width","25" );
      ((Element)v.get(764)).setAttribute("height","8" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */
      /* Termina nodo:763   */

      /* Empieza nodo:765 / Elemento padre: 750   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(765)).setAttribute("width","100%" );
      ((Element)v.get(750)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(766)).setAttribute("src","b.gif" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:765   */
      /* Termina nodo:750   */
      /* Termina nodo:749   */
      /* Termina nodo:748   */
      /* Termina nodo:745   */

      /* Empieza nodo:767 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(767)).setAttribute("nombre","formGapTr23" );
      ((Element)v.get(15)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(768)).setAttribute("align","center" );
      ((Element)v.get(768)).setAttribute("width","12" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(769)).setAttribute("src","b.gif" );
      ((Element)v.get(769)).setAttribute("width","12" );
      ((Element)v.get(769)).setAttribute("height","8" );
      ((Element)v.get(768)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */
      /* Termina nodo:768   */

      /* Empieza nodo:770 / Elemento padre: 767   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(767)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(771)).setAttribute("src","b.gif" );
      ((Element)v.get(771)).setAttribute("width","8" );
      ((Element)v.get(771)).setAttribute("height","8" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */

      /* Empieza nodo:772 / Elemento padre: 767   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(772)).setAttribute("align","center" );
      ((Element)v.get(772)).setAttribute("width","12" );
      ((Element)v.get(767)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(773)).setAttribute("src","b.gif" );
      ((Element)v.get(773)).setAttribute("width","12" );
      ((Element)v.get(773)).setAttribute("height","8" );
      ((Element)v.get(772)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:772   */
      /* Termina nodo:767   */

      /* Empieza nodo:774 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(774)).setAttribute("nombre","formTr24" );
      ((Element)v.get(15)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(775)).setAttribute("align","center" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(775)).setAttribute("width","12" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(776)).setAttribute("src","b.gif" );
      ((Element)v.get(776)).setAttribute("width","12" );
      ((Element)v.get(776)).setAttribute("height","12" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */
      /* Termina nodo:775   */

      /* Empieza nodo:777 / Elemento padre: 774   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(777)).setAttribute("width","100%" );
      ((Element)v.get(774)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(778)).setAttribute("width","100%" );
      ((Element)v.get(778)).setAttribute("border","0" );
      ((Element)v.get(778)).setAttribute("cellspacing","0" );
      ((Element)v.get(778)).setAttribute("cellpadding","0" );
      ((Element)v.get(778)).setAttribute("align","left" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(779)).setAttribute("align","left" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(780)).setAttribute("nombre","niriOidNiveRiesTdId" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(781)).setAttribute("border","0" );
      ((Element)v.get(781)).setAttribute("cellspacing","0" );
      ((Element)v.get(781)).setAttribute("cellpadding","0" );
      ((Element)v.get(781)).setAttribute("align","left" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(781)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(783)).setAttribute("valign","top" );
      ((Element)v.get(783)).setAttribute("height","13" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(784)).setAttribute("nombre","lblniriOidNiveRies" );
      ((Element)v.get(784)).setAttribute("id","datosTitle" );
      ((Element)v.get(784)).setAttribute("ancho","100" );
      ((Element)v.get(784)).setAttribute("alto","13" );
      ((Element)v.get(784)).setAttribute("cod","CarSoliEntrBloq.niriOidNiveRies.label" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */
      /* Termina nodo:783   */
      /* Termina nodo:782   */

      /* Empieza nodo:785 / Elemento padre: 781   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(785)).setAttribute("nombre","niriOidNiveRiesWidgetTrId" );
      ((Element)v.get(781)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(786)).setAttribute("align","left" );
      ((Element)v.get(786)).setAttribute("nowrap","true" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(787)).setAttribute("nombre","niriOidNiveRies" );
      ((Element)v.get(787)).setAttribute("id","datosCampos" );
      ((Element)v.get(787)).setAttribute("multiple","N" );
      ((Element)v.get(787)).setAttribute("req","N" );
      ((Element)v.get(787)).setAttribute("size","1" );
      ((Element)v.get(787)).setAttribute("validacion","" );
      ((Element)v.get(787)).setAttribute("onchange","" );
      ((Element)v.get(787)).setAttribute("onfocus","" );
      ((Element)v.get(787)).setAttribute("valorinicial","" );
      ((Element)v.get(787)).setAttribute("textoinicial","" );
      ((Element)v.get(787)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(787)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(787)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */
      /* Termina nodo:787   */
      /* Termina nodo:786   */
      /* Termina nodo:785   */

      /* Empieza nodo:789 / Elemento padre: 781   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(789)).setAttribute("nombre","niriOidNiveRiesViewLabelTrId" );
      ((Element)v.get(781)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(790)).setAttribute("valign","top" );
      ((Element)v.get(790)).setAttribute("height","13" );
      ((Element)v.get(790)).setAttribute("width","50" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(791)).setAttribute("nombre","lblViewNiriOidNiveRies" );
      ((Element)v.get(791)).setAttribute("alto","13" );
      ((Element)v.get(791)).setAttribute("filas","1" );
      ((Element)v.get(791)).setAttribute("id","EstDat" );
      ((Element)v.get(791)).setAttribute("valor","" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:790   */
      /* Termina nodo:789   */
      /* Termina nodo:781   */
      /* Termina nodo:780   */

      /* Empieza nodo:792 / Elemento padre: 779   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(792)).setAttribute("nombre","niriOidNiveRiesGapTdId" );
      ((Element)v.get(792)).setAttribute("nowrap","true" );
      ((Element)v.get(792)).setAttribute("class","datosCampos" );
      ((Element)v.get(779)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(793)).setAttribute("src","b.gif" );
      ((Element)v.get(793)).setAttribute("width","25" );
      ((Element)v.get(793)).setAttribute("height","8" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */
      /* Termina nodo:792   */

      /* Empieza nodo:794 / Elemento padre: 779   */
   }

   private void getXML3600(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(794)).setAttribute("width","100%" );
      ((Element)v.get(779)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(795)).setAttribute("src","b.gif" );
      ((Element)v.get(794)).appendChild((Element)v.get(795));
      /* Termina nodo:795   */
      /* Termina nodo:794   */
      /* Termina nodo:779   */
      /* Termina nodo:778   */
      /* Termina nodo:777   */
      /* Termina nodo:774   */

      /* Empieza nodo:796 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(796)).setAttribute("nombre","formGapTr24" );
      ((Element)v.get(15)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(797)).setAttribute("align","center" );
      ((Element)v.get(797)).setAttribute("width","12" );
      ((Element)v.get(796)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(798)).setAttribute("src","b.gif" );
      ((Element)v.get(798)).setAttribute("width","12" );
      ((Element)v.get(798)).setAttribute("height","8" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:799 / Elemento padre: 796   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(796)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(800)).setAttribute("src","b.gif" );
      ((Element)v.get(800)).setAttribute("width","8" );
      ((Element)v.get(800)).setAttribute("height","8" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */
      /* Termina nodo:799   */

      /* Empieza nodo:801 / Elemento padre: 796   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(801)).setAttribute("align","center" );
      ((Element)v.get(801)).setAttribute("width","12" );
      ((Element)v.get(796)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(802)).setAttribute("src","b.gif" );
      ((Element)v.get(802)).setAttribute("width","12" );
      ((Element)v.get(802)).setAttribute("height","8" );
      ((Element)v.get(801)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */
      /* Termina nodo:801   */
      /* Termina nodo:796   */

      /* Empieza nodo:803 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(803)).setAttribute("nombre","formTr25" );
      ((Element)v.get(15)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(804)).setAttribute("align","center" );
      ((Element)v.get(804)).setAttribute("width","12" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(805)).setAttribute("src","b.gif" );
      ((Element)v.get(805)).setAttribute("width","12" );
      ((Element)v.get(805)).setAttribute("height","12" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));
      /* Termina nodo:805   */
      /* Termina nodo:804   */

      /* Empieza nodo:806 / Elemento padre: 803   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(806)).setAttribute("width","100%" );
      ((Element)v.get(803)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(807)).setAttribute("width","100%" );
      ((Element)v.get(807)).setAttribute("border","0" );
      ((Element)v.get(807)).setAttribute("cellspacing","0" );
      ((Element)v.get(807)).setAttribute("cellpadding","0" );
      ((Element)v.get(807)).setAttribute("align","left" );
      ((Element)v.get(806)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(808)).setAttribute("align","left" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(809)).setAttribute("nombre","grsoOidGrupSoliTdId" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(810)).setAttribute("border","0" );
      ((Element)v.get(810)).setAttribute("cellspacing","0" );
      ((Element)v.get(810)).setAttribute("cellpadding","0" );
      ((Element)v.get(810)).setAttribute("align","left" );
      ((Element)v.get(809)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(810)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(812)).setAttribute("valign","top" );
      ((Element)v.get(812)).setAttribute("height","13" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(813)).setAttribute("nombre","lblgrsoOidGrupSoli" );
      ((Element)v.get(813)).setAttribute("id","datosTitle" );
      ((Element)v.get(813)).setAttribute("ancho","100" );
      ((Element)v.get(813)).setAttribute("alto","13" );
      ((Element)v.get(813)).setAttribute("cod","CarSoliEntrBloq.grsoOidGrupSoli.label" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:812   */
      /* Termina nodo:811   */

      /* Empieza nodo:814 / Elemento padre: 810   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(814)).setAttribute("nombre","grsoOidGrupSoliWidgetTrId" );
      ((Element)v.get(810)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(815)).setAttribute("align","left" );
      ((Element)v.get(815)).setAttribute("nowrap","true" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(816)).setAttribute("nombre","grsoOidGrupSoli" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(816)).setAttribute("id","datosCampos" );
      ((Element)v.get(816)).setAttribute("multiple","N" );
      ((Element)v.get(816)).setAttribute("req","N" );
      ((Element)v.get(816)).setAttribute("size","1" );
      ((Element)v.get(816)).setAttribute("validacion","" );
      ((Element)v.get(816)).setAttribute("onchange","" );
      ((Element)v.get(816)).setAttribute("onfocus","" );
      ((Element)v.get(816)).setAttribute("valorinicial","" );
      ((Element)v.get(816)).setAttribute("textoinicial","" );
      ((Element)v.get(816)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(816)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(816)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */
      /* Termina nodo:816   */
      /* Termina nodo:815   */
      /* Termina nodo:814   */

      /* Empieza nodo:818 / Elemento padre: 810   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(818)).setAttribute("nombre","grsoOidGrupSoliViewLabelTrId" );
      ((Element)v.get(810)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(819)).setAttribute("valign","top" );
      ((Element)v.get(819)).setAttribute("height","13" );
      ((Element)v.get(819)).setAttribute("width","50" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(820)).setAttribute("nombre","lblViewGrsoOidGrupSoli" );
      ((Element)v.get(820)).setAttribute("alto","13" );
      ((Element)v.get(820)).setAttribute("filas","1" );
      ((Element)v.get(820)).setAttribute("id","EstDat" );
      ((Element)v.get(820)).setAttribute("valor","" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */
      /* Termina nodo:818   */
      /* Termina nodo:810   */
      /* Termina nodo:809   */

      /* Empieza nodo:821 / Elemento padre: 808   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(821)).setAttribute("nombre","grsoOidGrupSoliGapTdId" );
      ((Element)v.get(821)).setAttribute("nowrap","true" );
      ((Element)v.get(821)).setAttribute("class","datosCampos" );
      ((Element)v.get(808)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(822)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).setAttribute("width","25" );
      ((Element)v.get(822)).setAttribute("height","8" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */

      /* Empieza nodo:823 / Elemento padre: 808   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(823)).setAttribute("width","100%" );
      ((Element)v.get(808)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(824)).setAttribute("src","b.gif" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */
      /* Termina nodo:823   */
      /* Termina nodo:808   */
      /* Termina nodo:807   */
      /* Termina nodo:806   */

      /* Empieza nodo:825 / Elemento padre: 803   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(825)).setAttribute("width","100%" );
      ((Element)v.get(803)).appendChild((Element)v.get(825));
      /* Termina nodo:825   */
      /* Termina nodo:803   */

      /* Empieza nodo:826 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(826)).setAttribute("nombre","formGapTr25" );
      ((Element)v.get(15)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(827)).setAttribute("align","center" );
      ((Element)v.get(827)).setAttribute("width","12" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(828)).setAttribute("src","b.gif" );
      ((Element)v.get(828)).setAttribute("width","12" );
      ((Element)v.get(828)).setAttribute("height","8" );
      ((Element)v.get(827)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */
      /* Termina nodo:827   */

      /* Empieza nodo:829 / Elemento padre: 826   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(826)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(830)).setAttribute("src","b.gif" );
      ((Element)v.get(830)).setAttribute("width","8" );
      ((Element)v.get(830)).setAttribute("height","8" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */

      /* Empieza nodo:831 / Elemento padre: 826   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(831)).setAttribute("align","center" );
      ((Element)v.get(831)).setAttribute("width","12" );
      ((Element)v.get(826)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(832)).setAttribute("src","b.gif" );
      ((Element)v.get(832)).setAttribute("width","12" );
      ((Element)v.get(832)).setAttribute("height","8" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));
      /* Termina nodo:832   */
      /* Termina nodo:831   */
      /* Termina nodo:826   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:833 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(833)).setAttribute("align","center" );
      ((Element)v.get(833)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(834)).setAttribute("src","b.gif" );
      ((Element)v.get(834)).setAttribute("width","12" );
      ((Element)v.get(834)).setAttribute("height","12" );
      ((Element)v.get(833)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */
      /* Termina nodo:833   */
      /* Termina nodo:8   */

      /* Empieza nodo:835 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(835)).setAttribute("nombre","carSoliEntrBloqTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(836)).setAttribute("align","center" );
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(836)).setAttribute("width","12" );
      ((Element)v.get(835)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(837)).setAttribute("src","b.gif" );
      ((Element)v.get(837)).setAttribute("width","12" );
      ((Element)v.get(837)).setAttribute("height","12" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */
      /* Termina nodo:836   */

      /* Empieza nodo:838 / Elemento padre: 835   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(835)).appendChild((Element)v.get(838));

      /* Empieza nodo:839 / Elemento padre: 838   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(838)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(840)).setAttribute("width","100%" );
      ((Element)v.get(840)).setAttribute("border","0" );
      ((Element)v.get(840)).setAttribute("align","center" );
      ((Element)v.get(840)).setAttribute("cellspacing","0" );
      ((Element)v.get(840)).setAttribute("cellpadding","0" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(840)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(842)).setAttribute("class","tablaTitle" );
      ((Element)v.get(842)).setAttribute("nombre","carSoliEntrBloqTdQueryButton" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(843)).setAttribute("nombre","carSoliEntrBloqQueryButton" );
      ((Element)v.get(843)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(843)).setAttribute("estado","false" );
      ((Element)v.get(843)).setAttribute("accion","carSoliEntrBloqFirstPage();" );
      ((Element)v.get(843)).setAttribute("tipo","html" );
      ((Element)v.get(843)).setAttribute("ID","botonContenido" );
      ((Element)v.get(842)).appendChild((Element)v.get(843));
      /* Termina nodo:843   */
      /* Termina nodo:842   */

      /* Empieza nodo:844 / Elemento padre: 841   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(844)).setAttribute("class","tablaTitle" );
      ((Element)v.get(844)).setAttribute("nombre","carSoliEntrBloqTdLovNullSelectionButton" );
      ((Element)v.get(844)).setAttribute("align","left" );
      ((Element)v.get(844)).setAttribute("width","100%" );
      ((Element)v.get(841)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(845)).setAttribute("src","b.gif" );
      ((Element)v.get(845)).setAttribute("height","8" );
      ((Element)v.get(845)).setAttribute("width","8" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */

      /* Empieza nodo:846 / Elemento padre: 844   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(846)).setAttribute("nombre","carSoliEntrBloqLovNullButton" );
      ((Element)v.get(846)).setAttribute("ID","botonContenido" );
      ((Element)v.get(846)).setAttribute("tipo","html" );
      ((Element)v.get(846)).setAttribute("accion","carSoliEntrBloqLovNullSelectionAction();" );
      ((Element)v.get(846)).setAttribute("estado","true" );
      ((Element)v.get(846)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(844)).appendChild((Element)v.get(846));
      /* Termina nodo:846   */
      /* Termina nodo:844   */
      /* Termina nodo:841   */
      /* Termina nodo:840   */
      /* Termina nodo:839   */
      /* Termina nodo:838   */

      /* Empieza nodo:847 / Elemento padre: 835   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(847)).setAttribute("align","center" );
      ((Element)v.get(847)).setAttribute("width","12" );
      ((Element)v.get(835)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(848)).setAttribute("src","b.gif" );
      ((Element)v.get(848)).setAttribute("width","12" );
      ((Element)v.get(848)).setAttribute("height","12" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));
      /* Termina nodo:848   */
      /* Termina nodo:847   */
      /* Termina nodo:835   */


   }

}
