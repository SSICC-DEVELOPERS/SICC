
import org.w3c.dom.*;
import java.util.ArrayList;

public class CarParamCartePageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","CarParamCarte.legend.label" );
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
      ((Element)v.get(29)).setAttribute("cod","CarParamCarte.id.label" );
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
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
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
      ((Element)v.get(60)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'carParamCarte')" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(60)).setAttribute("onfocus","" );
      ((Element)v.get(60)).setAttribute("valorinicial","" );
      ((Element)v.get(60)).setAttribute("textoinicial","" );
      ((Element)v.get(60)).setAttribute("ontab","focaliza('carParamCarteFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(60)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
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
      ((Element)v.get(74)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'carParamCarte')" );
      ((Element)v.get(74)).setAttribute("onfocus","" );
      ((Element)v.get(74)).setAttribute("valorinicial","" );
      ((Element)v.get(74)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).setAttribute("ontab","focaliza('carParamCarteFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(74)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
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
      ((Element)v.get(88)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'carParamCarte')" );
      ((Element)v.get(88)).setAttribute("onfocus","" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("ontab","focaliza('carParamCarteFrm.paisOidPais');" );
      ((Element)v.get(88)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
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
      ((Element)v.get(99)).setAttribute("cod","CarParamCarte.paisOidPais.label" );
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
      ((Element)v.get(102)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(102)).setAttribute("onshtab","focaliza('carParamCarteFrm.paisOidPais_fopaOidFormPago');" );
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
      ((Element)v.get(124)).setAttribute("nombre","grsoOidGrupSoliTdId" );
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
      ((Element)v.get(128)).setAttribute("nombre","lblgrsoOidGrupSoli" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("ancho","100" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("cod","CarParamCarte.grsoOidGrupSoli.label" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(129)).setAttribute("nombre","grsoOidGrupSoliWidgetTrId" );
      ((Element)v.get(125)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("align","left" );
      ((Element)v.get(130)).setAttribute("nowrap","true" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(131)).setAttribute("nombre","grsoOidGrupSoli" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("multiple","N" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("size","1" );
      ((Element)v.get(131)).setAttribute("validacion","" );
      ((Element)v.get(131)).setAttribute("onchange","" );
      ((Element)v.get(131)).setAttribute("onfocus","" );
      ((Element)v.get(131)).setAttribute("valorinicial","" );
      ((Element)v.get(131)).setAttribute("textoinicial","" );
      ((Element)v.get(131)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(131)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
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
      ((Element)v.get(133)).setAttribute("nombre","grsoOidGrupSoliViewLabelTrId" );
      ((Element)v.get(125)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("valign","top" );
      ((Element)v.get(134)).setAttribute("height","13" );
      ((Element)v.get(134)).setAttribute("width","50" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblViewGrsoOidGrupSoli" );
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
      ((Element)v.get(136)).setAttribute("nombre","grsoOidGrupSoliGapTdId" );
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
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(123)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:118   */

      /* Empieza nodo:140 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(140)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","12" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(140)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","12" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:140   */

      /* Empieza nodo:147 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(147)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(151)).setAttribute("border","0" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("cellpadding","0" );
      ((Element)v.get(151)).setAttribute("align","left" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(152)).setAttribute("align","left" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("nombre","niriOidNiveRiesTdId" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(154)).setAttribute("border","0" );
      ((Element)v.get(154)).setAttribute("cellspacing","0" );
      ((Element)v.get(154)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).setAttribute("align","left" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(156)).setAttribute("valign","top" );
      ((Element)v.get(156)).setAttribute("height","13" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblniriOidNiveRies" );
      ((Element)v.get(157)).setAttribute("id","datosTitle" );
      ((Element)v.get(157)).setAttribute("ancho","100" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("cod","CarParamCarte.niriOidNiveRies.label" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 154   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(158)).setAttribute("nombre","niriOidNiveRiesWidgetTrId" );
      ((Element)v.get(154)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("align","left" );
      ((Element)v.get(159)).setAttribute("nowrap","true" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(160)).setAttribute("nombre","niriOidNiveRies" );
      ((Element)v.get(160)).setAttribute("id","datosCampos" );
      ((Element)v.get(160)).setAttribute("multiple","N" );
      ((Element)v.get(160)).setAttribute("req","N" );
      ((Element)v.get(160)).setAttribute("size","1" );
      ((Element)v.get(160)).setAttribute("validacion","" );
      ((Element)v.get(160)).setAttribute("onchange","" );
      ((Element)v.get(160)).setAttribute("onfocus","" );
      ((Element)v.get(160)).setAttribute("valorinicial","" );
      ((Element)v.get(160)).setAttribute("textoinicial","" );
      ((Element)v.get(160)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(160)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:162 / Elemento padre: 154   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).setAttribute("nombre","niriOidNiveRiesViewLabelTrId" );
      ((Element)v.get(154)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("valign","top" );
      ((Element)v.get(163)).setAttribute("height","13" );
      ((Element)v.get(163)).setAttribute("width","50" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblViewNiriOidNiveRies" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("id","EstDat" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:165 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("nombre","niriOidNiveRiesGapTdId" );
      ((Element)v.get(165)).setAttribute("nowrap","true" );
      ((Element)v.get(165)).setAttribute("class","datosCampos" );
      ((Element)v.get(152)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(152)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:147   */

      /* Empieza nodo:169 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(169)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("align","center" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","12" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","12" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:169   */

      /* Empieza nodo:176 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(176)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("align","center" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","12" );
      ((Element)v.get(178)).setAttribute("height","12" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(180)).setAttribute("border","0" );
      ((Element)v.get(180)).setAttribute("cellspacing","0" );
      ((Element)v.get(180)).setAttribute("cellpadding","0" );
      ((Element)v.get(180)).setAttribute("align","left" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(181)).setAttribute("align","left" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("nombre","codConfTdId" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("valign","top" );
      ((Element)v.get(185)).setAttribute("height","13" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblCodConf" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","CarParamCarte.codConf.label" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 183   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(187)).setAttribute("nombre","codConfWidgetTrId" );
      ((Element)v.get(183)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("align","left" );
      ((Element)v.get(188)).setAttribute("nowrap","true" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(189)).setAttribute("nombre","codConf" );
      ((Element)v.get(189)).setAttribute("id","datosCampos" );
      ((Element)v.get(189)).setAttribute("trim","S" );
      ((Element)v.get(189)).setAttribute("max","3" );
      ((Element)v.get(189)).setAttribute("onchange","" );
      ((Element)v.get(189)).setAttribute("req","N" );
      ((Element)v.get(189)).setAttribute("size","3" );
      ((Element)v.get(189)).setAttribute("valor","" );
      ((Element)v.get(189)).setAttribute("validacion","" );
      ((Element)v.get(189)).setAttribute("onblur","" );
      ((Element)v.get(189)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(189)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 183   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).setAttribute("nombre","codConfViewLabelTrId" );
      ((Element)v.get(183)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("valign","top" );
      ((Element)v.get(191)).setAttribute("height","13" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblViewCodConf" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("ancho","100" );
      ((Element)v.get(192)).setAttribute("id","EstDat" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:193 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("nombre","codConfGapTdId" );
      ((Element)v.get(193)).setAttribute("nowrap","true" );
      ((Element)v.get(193)).setAttribute("class","datosCampos" );
      ((Element)v.get(181)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("width","100%" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(181)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:176   */

      /* Empieza nodo:197 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(197)).setAttribute("nombre","formGapTr4" );
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
      ((Element)v.get(204)).setAttribute("nombre","formTr5" );
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
      ((Element)v.get(210)).setAttribute("nombre","indDeudVencTdId" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

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
      ((Element)v.get(214)).setAttribute("nombre","lblIndDeudVenc" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","CarParamCarte.indDeudVenc.label" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(215)).setAttribute("nombre","indDeudVencWidgetTrId" );
      ((Element)v.get(211)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(216)).setAttribute("nowrap","true" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(217)).setAttribute("nombre","indDeudVenc" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(217)).setAttribute("trim","S" );
      ((Element)v.get(217)).setAttribute("max","1" );
      ((Element)v.get(217)).setAttribute("onchange","" );
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("size","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("validacion","" );
      ((Element)v.get(217)).setAttribute("onblur","" );
      ((Element)v.get(217)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(217)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(218)).setAttribute("nombre","indDeudVencViewLabelTrId" );
      ((Element)v.get(211)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("valign","top" );
      ((Element)v.get(219)).setAttribute("height","13" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblViewIndDeudVenc" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("ancho","100" );
      ((Element)v.get(220)).setAttribute("id","EstDat" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:221 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("nombre","indDeudVencGapTdId" );
      ((Element)v.get(221)).setAttribute("nowrap","true" );
      ((Element)v.get(221)).setAttribute("class","datosCampos" );
      ((Element)v.get(209)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:204   */

      /* Empieza nodo:225 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(225)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","12" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:225   */

      /* Empieza nodo:232 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(232)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","12" );
      ((Element)v.get(234)).setAttribute("height","12" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(236)).setAttribute("align","left" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(237)).setAttribute("align","left" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("nombre","numDiasDeudVencTdId" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(239)).setAttribute("border","0" );
      ((Element)v.get(239)).setAttribute("cellspacing","0" );
      ((Element)v.get(239)).setAttribute("cellpadding","0" );
      ((Element)v.get(239)).setAttribute("align","left" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("valign","top" );
      ((Element)v.get(241)).setAttribute("height","13" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lblNumDiasDeudVenc" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","CarParamCarte.numDiasDeudVenc.label" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 239   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(243)).setAttribute("nombre","numDiasDeudVencWidgetTrId" );
      ((Element)v.get(239)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("align","left" );
      ((Element)v.get(244)).setAttribute("nowrap","true" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(245)).setAttribute("nombre","numDiasDeudVenc" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("trim","S" );
      ((Element)v.get(245)).setAttribute("max","3" );
      ((Element)v.get(245)).setAttribute("onchange","" );
      ((Element)v.get(245)).setAttribute("req","N" );
      ((Element)v.get(245)).setAttribute("size","3" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("validacion","" );
      ((Element)v.get(245)).setAttribute("onblur","" );
      ((Element)v.get(245)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(245)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 239   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(246)).setAttribute("nombre","numDiasDeudVencViewLabelTrId" );
      ((Element)v.get(239)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("valign","top" );
      ((Element)v.get(247)).setAttribute("height","13" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(248)).setAttribute("nombre","lblViewNumDiasDeudVenc" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("ancho","100" );
      ((Element)v.get(248)).setAttribute("id","EstDat" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:249 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(249)).setAttribute("nombre","numDiasDeudVencGapTdId" );
      ((Element)v.get(249)).setAttribute("nowrap","true" );
      ((Element)v.get(249)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:232   */

      /* Empieza nodo:253 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(253)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("align","center" );
      ((Element)v.get(254)).setAttribute("width","12" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 253   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(253)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 253   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(258)).setAttribute("width","12" );
      ((Element)v.get(253)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:253   */

      /* Empieza nodo:260 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(260)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(261)).setAttribute("align","center" );
      ((Element)v.get(261)).setAttribute("width","12" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","12" );
      ((Element)v.get(262)).setAttribute("height","12" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 260   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(260)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(264)).setAttribute("border","0" );
      ((Element)v.get(264)).setAttribute("cellspacing","0" );
      ((Element)v.get(264)).setAttribute("cellpadding","0" );
      ((Element)v.get(264)).setAttribute("align","left" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(265)).setAttribute("align","left" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("nombre","indLineCredTdId" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(267)).setAttribute("width","100%" );
      ((Element)v.get(267)).setAttribute("border","0" );
      ((Element)v.get(267)).setAttribute("cellspacing","0" );
      ((Element)v.get(267)).setAttribute("cellpadding","0" );
      ((Element)v.get(267)).setAttribute("align","left" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("valign","top" );
      ((Element)v.get(269)).setAttribute("height","13" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(270)).setAttribute("nombre","lblIndLineCred" );
      ((Element)v.get(270)).setAttribute("alto","13" );
      ((Element)v.get(270)).setAttribute("filas","1" );
      ((Element)v.get(270)).setAttribute("id","datosTitle" );
      ((Element)v.get(270)).setAttribute("cod","CarParamCarte.indLineCred.label" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:271 / Elemento padre: 267   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(271)).setAttribute("nombre","indLineCredWidgetTrId" );
      ((Element)v.get(267)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("align","left" );
      ((Element)v.get(272)).setAttribute("nowrap","true" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(273)).setAttribute("nombre","indLineCred" );
      ((Element)v.get(273)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).setAttribute("trim","S" );
      ((Element)v.get(273)).setAttribute("max","1" );
      ((Element)v.get(273)).setAttribute("onchange","" );
      ((Element)v.get(273)).setAttribute("req","N" );
      ((Element)v.get(273)).setAttribute("size","1" );
      ((Element)v.get(273)).setAttribute("valor","" );
      ((Element)v.get(273)).setAttribute("validacion","" );
      ((Element)v.get(273)).setAttribute("onblur","" );
      ((Element)v.get(273)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(273)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:274 / Elemento padre: 267   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(274)).setAttribute("nombre","indLineCredViewLabelTrId" );
      ((Element)v.get(267)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("valign","top" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(275)).setAttribute("height","13" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblViewIndLineCred" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("ancho","100" );
      ((Element)v.get(276)).setAttribute("id","EstDat" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:277 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(277)).setAttribute("nombre","indLineCredGapTdId" );
      ((Element)v.get(277)).setAttribute("nowrap","true" );
      ((Element)v.get(277)).setAttribute("class","datosCampos" );
      ((Element)v.get(265)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).setAttribute("width","100%" );
      ((Element)v.get(265)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:260   */

      /* Empieza nodo:281 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(281)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).setAttribute("align","center" );
      ((Element)v.get(282)).setAttribute("width","12" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","12" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(286)).setAttribute("align","center" );
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(281)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","12" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:281   */

      /* Empieza nodo:288 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(288)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("align","center" );
      ((Element)v.get(289)).setAttribute("width","12" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","12" );
      ((Element)v.get(290)).setAttribute("height","12" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("width","100%" );
      ((Element)v.get(288)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(292)).setAttribute("border","0" );
      ((Element)v.get(292)).setAttribute("cellspacing","0" );
      ((Element)v.get(292)).setAttribute("cellpadding","0" );
      ((Element)v.get(292)).setAttribute("align","left" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(293)).setAttribute("align","left" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("nombre","fecVigeDesdTdId" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(295)).setAttribute("width","100%" );
      ((Element)v.get(295)).setAttribute("border","0" );
      ((Element)v.get(295)).setAttribute("cellspacing","0" );
      ((Element)v.get(295)).setAttribute("cellpadding","0" );
      ((Element)v.get(295)).setAttribute("align","left" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("valign","top" );
      ((Element)v.get(297)).setAttribute("height","13" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(298)).setAttribute("nombre","lblFecVigeDesd" );
      ((Element)v.get(298)).setAttribute("alto","13" );
      ((Element)v.get(298)).setAttribute("filas","1" );
      ((Element)v.get(298)).setAttribute("id","datosTitle" );
      ((Element)v.get(298)).setAttribute("cod","CarParamCarte.fecVigeDesd.label" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:299 / Elemento padre: 295   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(299)).setAttribute("nombre","fecVigeDesdWidgetTrId" );
      ((Element)v.get(295)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).setAttribute("align","left" );
      ((Element)v.get(300)).setAttribute("nowrap","true" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(301)).setAttribute("nombre","fecVigeDesd" );
      ((Element)v.get(301)).setAttribute("id","datosCampos" );
      ((Element)v.get(301)).setAttribute("trim","S" );
      ((Element)v.get(301)).setAttribute("max","7" );
      ((Element)v.get(301)).setAttribute("onchange","" );
      ((Element)v.get(301)).setAttribute("req","N" );
      ((Element)v.get(301)).setAttribute("size","7" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(301)).setAttribute("validacion","" );
      ((Element)v.get(301)).setAttribute("onblur","" );
      ((Element)v.get(301)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(301)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 295   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(302)).setAttribute("nombre","fecVigeDesdViewLabelTrId" );
      ((Element)v.get(295)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(303)).setAttribute("valign","top" );
      ((Element)v.get(303)).setAttribute("height","13" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblViewFecVigeDesd" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("ancho","100" );
      ((Element)v.get(304)).setAttribute("id","EstDat" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:305 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("nombre","fecVigeDesdGapTdId" );
      ((Element)v.get(305)).setAttribute("nowrap","true" );
      ((Element)v.get(305)).setAttribute("class","datosCampos" );
      ((Element)v.get(293)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(293)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:288   */

      /* Empieza nodo:309 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(309)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("align","center" );
      ((Element)v.get(310)).setAttribute("width","12" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","12" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(314)).setAttribute("align","center" );
      ((Element)v.get(314)).setAttribute("width","12" );
      ((Element)v.get(309)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","12" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:309   */

      /* Empieza nodo:316 / Elemento padre: 15   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(316)).setAttribute("nombre","formTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("width","12" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","12" );
      ((Element)v.get(318)).setAttribute("height","12" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(320)).setAttribute("border","0" );
      ((Element)v.get(320)).setAttribute("cellspacing","0" );
      ((Element)v.get(320)).setAttribute("cellpadding","0" );
      ((Element)v.get(320)).setAttribute("align","left" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(321)).setAttribute("align","left" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("nombre","fecVigeHastTdId" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(323)).setAttribute("width","100%" );
      ((Element)v.get(323)).setAttribute("border","0" );
      ((Element)v.get(323)).setAttribute("cellspacing","0" );
      ((Element)v.get(323)).setAttribute("cellpadding","0" );
      ((Element)v.get(323)).setAttribute("align","left" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("valign","top" );
      ((Element)v.get(325)).setAttribute("height","13" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(326)).setAttribute("nombre","lblFecVigeHast" );
      ((Element)v.get(326)).setAttribute("alto","13" );
      ((Element)v.get(326)).setAttribute("filas","1" );
      ((Element)v.get(326)).setAttribute("id","datosTitle" );
      ((Element)v.get(326)).setAttribute("cod","CarParamCarte.fecVigeHast.label" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 323   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(327)).setAttribute("nombre","fecVigeHastWidgetTrId" );
      ((Element)v.get(323)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(328)).setAttribute("align","left" );
      ((Element)v.get(328)).setAttribute("nowrap","true" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(329)).setAttribute("nombre","fecVigeHast" );
      ((Element)v.get(329)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).setAttribute("trim","S" );
      ((Element)v.get(329)).setAttribute("max","7" );
      ((Element)v.get(329)).setAttribute("onchange","" );
      ((Element)v.get(329)).setAttribute("req","N" );
      ((Element)v.get(329)).setAttribute("size","7" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("validacion","" );
      ((Element)v.get(329)).setAttribute("onblur","" );
      ((Element)v.get(329)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(329)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:330 / Elemento padre: 323   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(330)).setAttribute("nombre","fecVigeHastViewLabelTrId" );
      ((Element)v.get(323)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("valign","top" );
      ((Element)v.get(331)).setAttribute("height","13" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(332)).setAttribute("nombre","lblViewFecVigeHast" );
      ((Element)v.get(332)).setAttribute("alto","13" );
      ((Element)v.get(332)).setAttribute("ancho","100" );
      ((Element)v.get(332)).setAttribute("id","EstDat" );
      ((Element)v.get(332)).setAttribute("valor","" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:333 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("nombre","fecVigeHastGapTdId" );
      ((Element)v.get(333)).setAttribute("nowrap","true" );
      ((Element)v.get(333)).setAttribute("class","datosCampos" );
      ((Element)v.get(321)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(321)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:316   */

      /* Empieza nodo:337 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(337)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("align","center" );
      ((Element)v.get(338)).setAttribute("width","12" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("align","center" );
      ((Element)v.get(342)).setAttribute("width","12" );
      ((Element)v.get(337)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:337   */

      /* Empieza nodo:344 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(344)).setAttribute("nombre","formTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("align","center" );
      ((Element)v.get(345)).setAttribute("width","12" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","12" );
      ((Element)v.get(346)).setAttribute("height","12" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(344)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(348)).setAttribute("align","left" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(349)).setAttribute("align","left" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("nombre","valPorcValiTdId" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(351)).setAttribute("border","0" );
      ((Element)v.get(351)).setAttribute("cellspacing","0" );
      ((Element)v.get(351)).setAttribute("cellpadding","0" );
      ((Element)v.get(351)).setAttribute("align","left" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("valign","top" );
      ((Element)v.get(353)).setAttribute("height","13" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(354)).setAttribute("nombre","lblValPorcVali" );
      ((Element)v.get(354)).setAttribute("alto","13" );
      ((Element)v.get(354)).setAttribute("filas","1" );
      ((Element)v.get(354)).setAttribute("id","datosTitle" );
      ((Element)v.get(354)).setAttribute("cod","CarParamCarte.valPorcVali.label" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:355 / Elemento padre: 351   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(355)).setAttribute("nombre","valPorcValiWidgetTrId" );
      ((Element)v.get(351)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(356)).setAttribute("align","left" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(356)).setAttribute("nowrap","true" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(357)).setAttribute("nombre","valPorcVali" );
      ((Element)v.get(357)).setAttribute("id","datosCampos" );
      ((Element)v.get(357)).setAttribute("trim","S" );
      ((Element)v.get(357)).setAttribute("max","5" );
      ((Element)v.get(357)).setAttribute("onchange","" );
      ((Element)v.get(357)).setAttribute("req","N" );
      ((Element)v.get(357)).setAttribute("size","5" );
      ((Element)v.get(357)).setAttribute("valor","" );
      ((Element)v.get(357)).setAttribute("validacion","" );
      ((Element)v.get(357)).setAttribute("onblur","" );
      ((Element)v.get(357)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(357)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:358 / Elemento padre: 351   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(358)).setAttribute("nombre","valPorcValiViewLabelTrId" );
      ((Element)v.get(351)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("valign","top" );
      ((Element)v.get(359)).setAttribute("height","13" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(360)).setAttribute("nombre","lblViewValPorcVali" );
      ((Element)v.get(360)).setAttribute("alto","13" );
      ((Element)v.get(360)).setAttribute("ancho","100" );
      ((Element)v.get(360)).setAttribute("id","EstDat" );
      ((Element)v.get(360)).setAttribute("valor","" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:361 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(361)).setAttribute("nombre","valPorcValiGapTdId" );
      ((Element)v.get(361)).setAttribute("nowrap","true" );
      ((Element)v.get(361)).setAttribute("class","datosCampos" );
      ((Element)v.get(349)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","25" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(349)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:344   */

      /* Empieza nodo:365 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(365)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).setAttribute("align","center" );
      ((Element)v.get(366)).setAttribute("width","12" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","12" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("align","center" );
      ((Element)v.get(370)).setAttribute("width","12" );
      ((Element)v.get(365)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:365   */

      /* Empieza nodo:372 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(372)).setAttribute("nombre","formTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(373)).setAttribute("align","center" );
      ((Element)v.get(373)).setAttribute("width","12" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(376)).setAttribute("width","100%" );
      ((Element)v.get(376)).setAttribute("border","0" );
      ((Element)v.get(376)).setAttribute("cellspacing","0" );
      ((Element)v.get(376)).setAttribute("cellpadding","0" );
      ((Element)v.get(376)).setAttribute("align","left" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(377)).setAttribute("align","left" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(378)).setAttribute("nombre","indMontMaxiTdId" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(379)).setAttribute("width","100%" );
      ((Element)v.get(379)).setAttribute("border","0" );
      ((Element)v.get(379)).setAttribute("cellspacing","0" );
      ((Element)v.get(379)).setAttribute("cellpadding","0" );
      ((Element)v.get(379)).setAttribute("align","left" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(381)).setAttribute("valign","top" );
      ((Element)v.get(381)).setAttribute("height","13" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(382)).setAttribute("nombre","lblIndMontMaxi" );
      ((Element)v.get(382)).setAttribute("alto","13" );
      ((Element)v.get(382)).setAttribute("filas","1" );
      ((Element)v.get(382)).setAttribute("id","datosTitle" );
      ((Element)v.get(382)).setAttribute("cod","CarParamCarte.indMontMaxi.label" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:383 / Elemento padre: 379   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(383)).setAttribute("nombre","indMontMaxiWidgetTrId" );
      ((Element)v.get(379)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("align","left" );
      ((Element)v.get(384)).setAttribute("nowrap","true" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(385)).setAttribute("nombre","indMontMaxi" );
      ((Element)v.get(385)).setAttribute("id","datosCampos" );
      ((Element)v.get(385)).setAttribute("trim","S" );
      ((Element)v.get(385)).setAttribute("max","1" );
      ((Element)v.get(385)).setAttribute("onchange","" );
      ((Element)v.get(385)).setAttribute("req","N" );
      ((Element)v.get(385)).setAttribute("size","1" );
      ((Element)v.get(385)).setAttribute("valor","" );
      ((Element)v.get(385)).setAttribute("validacion","" );
      ((Element)v.get(385)).setAttribute("onblur","" );
      ((Element)v.get(385)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(385)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:386 / Elemento padre: 379   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(386)).setAttribute("nombre","indMontMaxiViewLabelTrId" );
      ((Element)v.get(379)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("valign","top" );
      ((Element)v.get(387)).setAttribute("height","13" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(388)).setAttribute("nombre","lblViewIndMontMaxi" );
      ((Element)v.get(388)).setAttribute("alto","13" );
      ((Element)v.get(388)).setAttribute("ancho","100" );
      ((Element)v.get(388)).setAttribute("id","EstDat" );
      ((Element)v.get(388)).setAttribute("valor","" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:389 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(389)).setAttribute("nombre","indMontMaxiGapTdId" );
      ((Element)v.get(389)).setAttribute("nowrap","true" );
      ((Element)v.get(389)).setAttribute("class","datosCampos" );
      ((Element)v.get(377)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","25" );
      ((Element)v.get(390)).setAttribute("height","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("width","100%" );
      ((Element)v.get(377)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:372   */

      /* Empieza nodo:393 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(393)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("align","center" );
      ((Element)v.get(394)).setAttribute("width","12" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","12" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(393)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 393   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("align","center" );
      ((Element)v.get(398)).setAttribute("width","12" );
      ((Element)v.get(393)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:393   */

      /* Empieza nodo:400 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(400)).setAttribute("nombre","formTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(401)).setAttribute("align","center" );
      ((Element)v.get(401)).setAttribute("width","12" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","12" );
      ((Element)v.get(402)).setAttribute("height","12" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(403)).setAttribute("width","100%" );
      ((Element)v.get(400)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(404)).setAttribute("border","0" );
      ((Element)v.get(404)).setAttribute("cellspacing","0" );
      ((Element)v.get(404)).setAttribute("cellpadding","0" );
      ((Element)v.get(404)).setAttribute("align","left" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(405)).setAttribute("align","left" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(406)).setAttribute("nombre","valMontMaxiPermTdId" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(407)).setAttribute("width","100%" );
      ((Element)v.get(407)).setAttribute("border","0" );
      ((Element)v.get(407)).setAttribute("cellspacing","0" );
      ((Element)v.get(407)).setAttribute("cellpadding","0" );
      ((Element)v.get(407)).setAttribute("align","left" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(409)).setAttribute("valign","top" );
      ((Element)v.get(409)).setAttribute("height","13" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(410)).setAttribute("nombre","lblValMontMaxiPerm" );
      ((Element)v.get(410)).setAttribute("alto","13" );
      ((Element)v.get(410)).setAttribute("filas","1" );
      ((Element)v.get(410)).setAttribute("id","datosTitle" );
      ((Element)v.get(410)).setAttribute("cod","CarParamCarte.valMontMaxiPerm.label" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:411 / Elemento padre: 407   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(411)).setAttribute("nombre","valMontMaxiPermWidgetTrId" );
      ((Element)v.get(407)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("align","left" );
      ((Element)v.get(412)).setAttribute("nowrap","true" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(413)).setAttribute("nombre","valMontMaxiPerm" );
      ((Element)v.get(413)).setAttribute("id","datosCampos" );
      ((Element)v.get(413)).setAttribute("trim","S" );
      ((Element)v.get(413)).setAttribute("max","12" );
      ((Element)v.get(413)).setAttribute("onchange","" );
      ((Element)v.get(413)).setAttribute("req","N" );
      ((Element)v.get(413)).setAttribute("size","12" );
      ((Element)v.get(413)).setAttribute("valor","" );
      ((Element)v.get(413)).setAttribute("validacion","" );
      ((Element)v.get(413)).setAttribute("onblur","" );
      ((Element)v.get(413)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(413)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:414 / Elemento padre: 407   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(414)).setAttribute("nombre","valMontMaxiPermViewLabelTrId" );
      ((Element)v.get(407)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("valign","top" );
      ((Element)v.get(415)).setAttribute("height","13" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(416)).setAttribute("nombre","lblViewValMontMaxiPerm" );
      ((Element)v.get(416)).setAttribute("alto","13" );
      ((Element)v.get(416)).setAttribute("ancho","100" );
      ((Element)v.get(416)).setAttribute("id","EstDat" );
      ((Element)v.get(416)).setAttribute("valor","" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:417 / Elemento padre: 405   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(417)).setAttribute("nombre","valMontMaxiPermGapTdId" );
      ((Element)v.get(417)).setAttribute("nowrap","true" );
      ((Element)v.get(417)).setAttribute("class","datosCampos" );
      ((Element)v.get(405)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","25" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 405   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).setAttribute("width","100%" );
      ((Element)v.get(405)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:400   */

      /* Empieza nodo:421 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(421)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(422)).setAttribute("align","center" );
      ((Element)v.get(422)).setAttribute("width","12" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","12" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","8" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(426)).setAttribute("align","center" );
      ((Element)v.get(426)).setAttribute("width","12" );
      ((Element)v.get(421)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:421   */

      /* Empieza nodo:428 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(428)).setAttribute("nombre","formTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("align","center" );
      ((Element)v.get(429)).setAttribute("width","12" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","12" );
      ((Element)v.get(430)).setAttribute("height","12" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 428   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("width","100%" );
      ((Element)v.get(428)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(432)).setAttribute("width","100%" );
      ((Element)v.get(432)).setAttribute("border","0" );
      ((Element)v.get(432)).setAttribute("cellspacing","0" );
      ((Element)v.get(432)).setAttribute("cellpadding","0" );
      ((Element)v.get(432)).setAttribute("align","left" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(433)).setAttribute("align","left" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(434)).setAttribute("nombre","indPorcMaxiTdId" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(435)).setAttribute("width","100%" );
      ((Element)v.get(435)).setAttribute("border","0" );
      ((Element)v.get(435)).setAttribute("cellspacing","0" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(435)).setAttribute("cellpadding","0" );
      ((Element)v.get(435)).setAttribute("align","left" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(437)).setAttribute("valign","top" );
      ((Element)v.get(437)).setAttribute("height","13" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(438)).setAttribute("nombre","lblIndPorcMaxi" );
      ((Element)v.get(438)).setAttribute("alto","13" );
      ((Element)v.get(438)).setAttribute("filas","1" );
      ((Element)v.get(438)).setAttribute("id","datosTitle" );
      ((Element)v.get(438)).setAttribute("cod","CarParamCarte.indPorcMaxi.label" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:439 / Elemento padre: 435   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(439)).setAttribute("nombre","indPorcMaxiWidgetTrId" );
      ((Element)v.get(435)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(440)).setAttribute("align","left" );
      ((Element)v.get(440)).setAttribute("nowrap","true" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(441)).setAttribute("nombre","indPorcMaxi" );
      ((Element)v.get(441)).setAttribute("id","datosCampos" );
      ((Element)v.get(441)).setAttribute("trim","S" );
      ((Element)v.get(441)).setAttribute("max","1" );
      ((Element)v.get(441)).setAttribute("onchange","" );
      ((Element)v.get(441)).setAttribute("req","N" );
      ((Element)v.get(441)).setAttribute("size","1" );
      ((Element)v.get(441)).setAttribute("valor","" );
      ((Element)v.get(441)).setAttribute("validacion","" );
      ((Element)v.get(441)).setAttribute("onblur","" );
      ((Element)v.get(441)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(441)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:442 / Elemento padre: 435   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(442)).setAttribute("nombre","indPorcMaxiViewLabelTrId" );
      ((Element)v.get(435)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("valign","top" );
      ((Element)v.get(443)).setAttribute("height","13" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(444)).setAttribute("nombre","lblViewIndPorcMaxi" );
      ((Element)v.get(444)).setAttribute("alto","13" );
      ((Element)v.get(444)).setAttribute("ancho","100" );
      ((Element)v.get(444)).setAttribute("id","EstDat" );
      ((Element)v.get(444)).setAttribute("valor","" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:445 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(445)).setAttribute("nombre","indPorcMaxiGapTdId" );
      ((Element)v.get(445)).setAttribute("nowrap","true" );
      ((Element)v.get(445)).setAttribute("class","datosCampos" );
      ((Element)v.get(433)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","25" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(447)).setAttribute("width","100%" );
      ((Element)v.get(433)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:428   */

      /* Empieza nodo:449 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(449)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).setAttribute("align","center" );
      ((Element)v.get(450)).setAttribute("width","12" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","12" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(449)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","8" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("align","center" );
      ((Element)v.get(454)).setAttribute("width","12" );
      ((Element)v.get(449)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","12" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:449   */

      /* Empieza nodo:456 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(456)).setAttribute("nombre","formTr14" );
      ((Element)v.get(15)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("align","center" );
      ((Element)v.get(457)).setAttribute("width","12" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","12" );
      ((Element)v.get(458)).setAttribute("height","12" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(459)).setAttribute("width","100%" );
      ((Element)v.get(456)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(460)).setAttribute("width","100%" );
      ((Element)v.get(460)).setAttribute("border","0" );
      ((Element)v.get(460)).setAttribute("cellspacing","0" );
      ((Element)v.get(460)).setAttribute("cellpadding","0" );
      ((Element)v.get(460)).setAttribute("align","left" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(461)).setAttribute("align","left" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(462)).setAttribute("nombre","valPorcTdId" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(463)).setAttribute("width","100%" );
      ((Element)v.get(463)).setAttribute("border","0" );
      ((Element)v.get(463)).setAttribute("cellspacing","0" );
      ((Element)v.get(463)).setAttribute("cellpadding","0" );
      ((Element)v.get(463)).setAttribute("align","left" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(465)).setAttribute("valign","top" );
      ((Element)v.get(465)).setAttribute("height","13" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(466)).setAttribute("nombre","lblValPorc" );
      ((Element)v.get(466)).setAttribute("alto","13" );
      ((Element)v.get(466)).setAttribute("filas","1" );
      ((Element)v.get(466)).setAttribute("id","datosTitle" );
      ((Element)v.get(466)).setAttribute("cod","CarParamCarte.valPorc.label" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:467 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(467)).setAttribute("nombre","valPorcWidgetTrId" );
      ((Element)v.get(463)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("align","left" );
      ((Element)v.get(468)).setAttribute("nowrap","true" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(469)).setAttribute("nombre","valPorc" );
      ((Element)v.get(469)).setAttribute("id","datosCampos" );
      ((Element)v.get(469)).setAttribute("trim","S" );
      ((Element)v.get(469)).setAttribute("max","5" );
      ((Element)v.get(469)).setAttribute("onchange","" );
      ((Element)v.get(469)).setAttribute("req","N" );
      ((Element)v.get(469)).setAttribute("size","5" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(469)).setAttribute("validacion","" );
      ((Element)v.get(469)).setAttribute("onblur","" );
      ((Element)v.get(469)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(469)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:470 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(470)).setAttribute("nombre","valPorcViewLabelTrId" );
      ((Element)v.get(463)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("valign","top" );
      ((Element)v.get(471)).setAttribute("height","13" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(472)).setAttribute("nombre","lblViewValPorc" );
      ((Element)v.get(472)).setAttribute("alto","13" );
      ((Element)v.get(472)).setAttribute("ancho","100" );
      ((Element)v.get(472)).setAttribute("id","EstDat" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:473 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("nombre","valPorcGapTdId" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(473)).setAttribute("nowrap","true" );
      ((Element)v.get(473)).setAttribute("class","datosCampos" );
      ((Element)v.get(461)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","25" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("width","100%" );
      ((Element)v.get(461)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:456   */

      /* Empieza nodo:477 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(477)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(15)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(478)).setAttribute("align","center" );
      ((Element)v.get(478)).setAttribute("width","12" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","12" );
      ((Element)v.get(479)).setAttribute("height","8" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 477   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(477)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","8" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 477   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(482)).setAttribute("align","center" );
      ((Element)v.get(482)).setAttribute("width","12" );
      ((Element)v.get(477)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).setAttribute("width","12" );
      ((Element)v.get(483)).setAttribute("height","8" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:477   */

      /* Empieza nodo:484 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(484)).setAttribute("nombre","formTr15" );
      ((Element)v.get(15)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(485)).setAttribute("align","center" );
      ((Element)v.get(485)).setAttribute("width","12" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(486)).setAttribute("src","b.gif" );
      ((Element)v.get(486)).setAttribute("width","12" );
      ((Element)v.get(486)).setAttribute("height","12" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:487 / Elemento padre: 484   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(487)).setAttribute("width","100%" );
      ((Element)v.get(484)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(488)).setAttribute("width","100%" );
      ((Element)v.get(488)).setAttribute("border","0" );
      ((Element)v.get(488)).setAttribute("cellspacing","0" );
      ((Element)v.get(488)).setAttribute("cellpadding","0" );
      ((Element)v.get(488)).setAttribute("align","left" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(489)).setAttribute("align","left" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(490)).setAttribute("nombre","numDiasAdicTdId" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

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
      ((Element)v.get(494)).setAttribute("nombre","lblNumDiasAdic" );
      ((Element)v.get(494)).setAttribute("alto","13" );
      ((Element)v.get(494)).setAttribute("filas","1" );
      ((Element)v.get(494)).setAttribute("id","datosTitle" );
      ((Element)v.get(494)).setAttribute("cod","CarParamCarte.numDiasAdic.label" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:495 / Elemento padre: 491   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(495)).setAttribute("nombre","numDiasAdicWidgetTrId" );
      ((Element)v.get(491)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(496)).setAttribute("align","left" );
      ((Element)v.get(496)).setAttribute("nowrap","true" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(497)).setAttribute("nombre","numDiasAdic" );
      ((Element)v.get(497)).setAttribute("id","datosCampos" );
      ((Element)v.get(497)).setAttribute("trim","S" );
      ((Element)v.get(497)).setAttribute("max","3" );
      ((Element)v.get(497)).setAttribute("onchange","" );
      ((Element)v.get(497)).setAttribute("req","N" );
      ((Element)v.get(497)).setAttribute("size","3" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(497)).setAttribute("validacion","" );
      ((Element)v.get(497)).setAttribute("onblur","" );
      ((Element)v.get(497)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(497)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:498 / Elemento padre: 491   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(498)).setAttribute("nombre","numDiasAdicViewLabelTrId" );
      ((Element)v.get(491)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).setAttribute("valign","top" );
      ((Element)v.get(499)).setAttribute("height","13" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(500)).setAttribute("nombre","lblViewNumDiasAdic" );
      ((Element)v.get(500)).setAttribute("alto","13" );
      ((Element)v.get(500)).setAttribute("ancho","100" );
      ((Element)v.get(500)).setAttribute("id","EstDat" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:501 / Elemento padre: 489   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(501)).setAttribute("nombre","numDiasAdicGapTdId" );
      ((Element)v.get(501)).setAttribute("nowrap","true" );
      ((Element)v.get(501)).setAttribute("class","datosCampos" );
      ((Element)v.get(489)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","25" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 489   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(503)).setAttribute("width","100%" );
      ((Element)v.get(489)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:484   */

      /* Empieza nodo:505 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(505)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(15)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).setAttribute("align","center" );
      ((Element)v.get(506)).setAttribute("width","12" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","12" );
      ((Element)v.get(507)).setAttribute("height","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(505)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","8" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 505   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(510)).setAttribute("align","center" );
      ((Element)v.get(510)).setAttribute("width","12" );
      ((Element)v.get(505)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(511)).setAttribute("width","12" );
      ((Element)v.get(511)).setAttribute("height","8" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:505   */

      /* Empieza nodo:512 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(512)).setAttribute("nombre","formTr16" );
      ((Element)v.get(15)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(513)).setAttribute("align","center" );
      ((Element)v.get(513)).setAttribute("width","12" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","12" );
      ((Element)v.get(514)).setAttribute("height","12" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(515)).setAttribute("width","100%" );
      ((Element)v.get(512)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(516)).setAttribute("width","100%" );
      ((Element)v.get(516)).setAttribute("border","0" );
      ((Element)v.get(516)).setAttribute("cellspacing","0" );
      ((Element)v.get(516)).setAttribute("cellpadding","0" );
      ((Element)v.get(516)).setAttribute("align","left" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(517)).setAttribute("align","left" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(518)).setAttribute("nombre","invaOidIndiValiTdId" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(519)).setAttribute("border","0" );
      ((Element)v.get(519)).setAttribute("cellspacing","0" );
      ((Element)v.get(519)).setAttribute("cellpadding","0" );
      ((Element)v.get(519)).setAttribute("align","left" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(521)).setAttribute("valign","top" );
      ((Element)v.get(521)).setAttribute("height","13" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(522)).setAttribute("nombre","lblinvaOidIndiVali" );
      ((Element)v.get(522)).setAttribute("id","datosTitle" );
      ((Element)v.get(522)).setAttribute("ancho","100" );
      ((Element)v.get(522)).setAttribute("alto","13" );
      ((Element)v.get(522)).setAttribute("cod","CarParamCarte.invaOidIndiVali.label" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:523 / Elemento padre: 519   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(523)).setAttribute("nombre","invaOidIndiValiWidgetTrId" );
      ((Element)v.get(519)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(524)).setAttribute("align","left" );
      ((Element)v.get(524)).setAttribute("nowrap","true" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(525)).setAttribute("nombre","invaOidIndiVali" );
      ((Element)v.get(525)).setAttribute("id","datosCampos" );
      ((Element)v.get(525)).setAttribute("multiple","N" );
      ((Element)v.get(525)).setAttribute("req","N" );
      ((Element)v.get(525)).setAttribute("size","1" );
      ((Element)v.get(525)).setAttribute("validacion","" );
      ((Element)v.get(525)).setAttribute("onchange","" );
      ((Element)v.get(525)).setAttribute("onfocus","" );
      ((Element)v.get(525)).setAttribute("valorinicial","" );
      ((Element)v.get(525)).setAttribute("textoinicial","" );
      ((Element)v.get(525)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(525)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:527 / Elemento padre: 519   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(527)).setAttribute("nombre","invaOidIndiValiViewLabelTrId" );
      ((Element)v.get(519)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).setAttribute("valign","top" );
      ((Element)v.get(528)).setAttribute("height","13" );
      ((Element)v.get(528)).setAttribute("width","50" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(529)).setAttribute("nombre","lblViewInvaOidIndiVali" );
      ((Element)v.get(529)).setAttribute("alto","13" );
      ((Element)v.get(529)).setAttribute("filas","1" );
      ((Element)v.get(529)).setAttribute("id","EstDat" );
      ((Element)v.get(529)).setAttribute("valor","" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:530 / Elemento padre: 517   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(530)).setAttribute("nombre","invaOidIndiValiGapTdId" );
      ((Element)v.get(530)).setAttribute("nowrap","true" );
      ((Element)v.get(530)).setAttribute("class","datosCampos" );
      ((Element)v.get(517)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("width","25" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 517   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(532)).setAttribute("width","100%" );
      ((Element)v.get(517)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:534 / Elemento padre: 512   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(512)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:512   */

      /* Empieza nodo:535 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(535)).setAttribute("nombre","formGapTr16" );
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
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:542 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(542)).setAttribute("align","center" );
      ((Element)v.get(542)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","12" );
      ((Element)v.get(543)).setAttribute("height","12" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:8   */

      /* Empieza nodo:544 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(544)).setAttribute("nombre","carParamCarteTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(545)).setAttribute("align","center" );
      ((Element)v.get(545)).setAttribute("width","12" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(546)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).setAttribute("width","12" );
      ((Element)v.get(546)).setAttribute("height","12" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:547 / Elemento padre: 544   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(549)).setAttribute("width","100%" );
      ((Element)v.get(549)).setAttribute("border","0" );
      ((Element)v.get(549)).setAttribute("align","center" );
      ((Element)v.get(549)).setAttribute("cellspacing","0" );
      ((Element)v.get(549)).setAttribute("cellpadding","0" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("class","tablaTitle" );
      ((Element)v.get(551)).setAttribute("nombre","carParamCarteTdQueryButton" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(552)).setAttribute("nombre","carParamCarteQueryButton" );
      ((Element)v.get(552)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(552)).setAttribute("estado","false" );
      ((Element)v.get(552)).setAttribute("accion","carParamCarteFirstPage();" );
      ((Element)v.get(552)).setAttribute("tipo","html" );
      ((Element)v.get(552)).setAttribute("ID","botonContenido" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(553)).setAttribute("class","tablaTitle" );
      ((Element)v.get(553)).setAttribute("nombre","carParamCarteTdLovNullSelectionButton" );
      ((Element)v.get(553)).setAttribute("align","left" );
      ((Element)v.get(553)).setAttribute("width","100%" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("height","8" );
      ((Element)v.get(554)).setAttribute("width","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 553   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(555)).setAttribute("nombre","carParamCarteLovNullButton" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(555)).setAttribute("ID","botonContenido" );
      ((Element)v.get(555)).setAttribute("tipo","html" );
      ((Element)v.get(555)).setAttribute("accion","carParamCarteLovNullSelectionAction();" );
      ((Element)v.get(555)).setAttribute("estado","true" );
      ((Element)v.get(555)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(553)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:553   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:556 / Elemento padre: 544   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(556)).setAttribute("align","center" );
      ((Element)v.get(556)).setAttribute("width","12" );
      ((Element)v.get(544)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).setAttribute("width","12" );
      ((Element)v.get(557)).setAttribute("height","12" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */
      /* Termina nodo:544   */


   }

}
