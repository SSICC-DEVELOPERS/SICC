
import org.w3c.dom.*;
import java.util.ArrayList;

public class IntParamContaFactuPageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","IntParamContaFactu.legend.label" );
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
      ((Element)v.get(29)).setAttribute("cod","IntParamContaFactu.id.label" );
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
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',1, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm', 1, false)" );
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
      ((Element)v.get(50)).setAttribute("nombre","codApunTdId" );
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
      ((Element)v.get(54)).setAttribute("nombre","lblCodApun" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","IntParamContaFactu.codApun.label" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(55)).setAttribute("nombre","codApunWidgetTrId" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("nowrap","true" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(57)).setAttribute("nombre","codApun" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("trim","S" );
      ((Element)v.get(57)).setAttribute("max","4" );
      ((Element)v.get(57)).setAttribute("onchange","" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("size","4" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("validacion","" );
      ((Element)v.get(57)).setAttribute("disabled","" );
      ((Element)v.get(57)).setAttribute("onblur","" );
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',2, true)" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm', 2, false)" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:58 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("nombre","codApunGapTdId" );
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
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */

      /* Empieza nodo:62 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(62)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","12" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:62   */

      /* Empieza nodo:69 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(69)).setAttribute("nombre","formTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","12" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(74)).setAttribute("align","left" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).setAttribute("nombre","valTipoAsieTdId" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(76)).setAttribute("align","left" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(78)).setAttribute("valign","top" );
      ((Element)v.get(78)).setAttribute("height","13" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblValTipoAsie" );
      ((Element)v.get(79)).setAttribute("ancho","150" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","IntParamContaFactu.valTipoAsie.label" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 76   */
      v.add(doc.createElement("TR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(80)).setAttribute("nombre","valTipoAsieWidgetTrId" );
      ((Element)v.get(76)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(81)).setAttribute("align","left" );
      ((Element)v.get(81)).setAttribute("nowrap","true" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(82)).setAttribute("nombre","valTipoAsie" );
      ((Element)v.get(82)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).setAttribute("multiple","N" );
      ((Element)v.get(82)).setAttribute("req","N" );
      ((Element)v.get(82)).setAttribute("size","1" );
      ((Element)v.get(82)).setAttribute("validacion","" );
      ((Element)v.get(82)).setAttribute("onchange","" );
      ((Element)v.get(82)).setAttribute("onfocus","" );
      ((Element)v.get(82)).setAttribute("valorinicial","" );
      ((Element)v.get(82)).setAttribute("textoinicial","" );
      ((Element)v.get(82)).setAttribute("disabled","" );
      ((Element)v.get(82)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',3, true)" );
      ((Element)v.get(82)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',3, false)" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(84)).setAttribute("ID","VN" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(85)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(85)).setAttribute("TIPO","STRING" );
      ((Element)v.get(85)).setAttribute("VALOR","VN" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 84   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(86)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(86)).setAttribute("TIPO","STRING" );
      ((Element)v.get(86)).setAttribute("VALOR","VN" );
      ((Element)v.get(84)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 83   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(87)).setAttribute("ID","AB" );
      ((Element)v.get(83)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(88)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(88)).setAttribute("TIPO","STRING" );
      ((Element)v.get(88)).setAttribute("VALOR","AB" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 87   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(89)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(89)).setAttribute("TIPO","STRING" );
      ((Element)v.get(89)).setAttribute("VALOR","AB" );
      ((Element)v.get(87)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 83   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(90)).setAttribute("ID","TN" );
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(91)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(91)).setAttribute("TIPO","STRING" );
      ((Element)v.get(91)).setAttribute("VALOR","TN" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 90   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(92)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(92)).setAttribute("TIPO","STRING" );
      ((Element)v.get(92)).setAttribute("VALOR","TN" );
      ((Element)v.get(90)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:90   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:93 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("nombre","valTipoAsieGapTdId" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(93)).setAttribute("class","datosCampos" );
      ((Element)v.get(74)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:69   */

      /* Empieza nodo:97 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(97)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:97   */

      /* Empieza nodo:104 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(104)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","12" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(109)).setAttribute("align","left" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("nombre","valIdenCabeDetaTdId" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

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
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("valign","top" );
      ((Element)v.get(113)).setAttribute("height","13" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblValIdenCabeDeta" );
      ((Element)v.get(114)).setAttribute("ancho","150" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("id","datosTitle" );
      ((Element)v.get(114)).setAttribute("cod","IntParamContaFactu.valIdenCabeDeta.label" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 111   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(115)).setAttribute("nombre","valIdenCabeDetaWidgetTrId" );
      ((Element)v.get(111)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("align","left" );
      ((Element)v.get(116)).setAttribute("nowrap","true" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(117)).setAttribute("nombre","valIdenCabeDeta" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("multiple","N" );
      ((Element)v.get(117)).setAttribute("req","N" );
      ((Element)v.get(117)).setAttribute("size","1" );
      ((Element)v.get(117)).setAttribute("validacion","" );
      ((Element)v.get(117)).setAttribute("onchange","" );
      ((Element)v.get(117)).setAttribute("onfocus","" );
      ((Element)v.get(117)).setAttribute("valorinicial","" );
      ((Element)v.get(117)).setAttribute("textoinicial","" );
      ((Element)v.get(117)).setAttribute("disabled","" );
      ((Element)v.get(117)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',4, true)" );
      ((Element)v.get(117)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',4, false)" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("ID","C" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(120)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(120)).setAttribute("TIPO","STRING" );
      ((Element)v.get(120)).setAttribute("VALOR","C" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(121)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(121)).setAttribute("TIPO","STRING" );
      ((Element)v.get(121)).setAttribute("VALOR","C" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:119   */

      /* Empieza nodo:122 / Elemento padre: 118   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(122)).setAttribute("ID","D" );
      ((Element)v.get(118)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(123)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(123)).setAttribute("TIPO","STRING" );
      ((Element)v.get(123)).setAttribute("VALOR","D" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 122   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(124)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(124)).setAttribute("TIPO","STRING" );
      ((Element)v.get(124)).setAttribute("VALOR","D" );
      ((Element)v.get(122)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:122   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:125 / Elemento padre: 109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("nombre","valIdenCabeDetaGapTdId" );
      ((Element)v.get(125)).setAttribute("nowrap","true" );
      ((Element)v.get(125)).setAttribute("class","datosCampos" );
      ((Element)v.get(109)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:104   */

      /* Empieza nodo:129 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(129)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","12" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:129   */

      /* Empieza nodo:136 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(136)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","12" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(140)).setAttribute("border","0" );
      ((Element)v.get(140)).setAttribute("cellspacing","0" );
      ((Element)v.get(140)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).setAttribute("align","left" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(141)).setAttribute("align","left" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).setAttribute("nombre","valDescTdId" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(143)).setAttribute("border","0" );
      ((Element)v.get(143)).setAttribute("cellspacing","0" );
      ((Element)v.get(143)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).setAttribute("align","left" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("valign","top" );
      ((Element)v.get(145)).setAttribute("height","13" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblValDesc" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","IntParamContaFactu.valDesc.label" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:147 / Elemento padre: 143   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(147)).setAttribute("nombre","valDescWidgetTrId" );
      ((Element)v.get(143)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(148)).setAttribute("nowrap","true" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(149)).setAttribute("nombre","valDesc" );
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).setAttribute("trim","S" );
      ((Element)v.get(149)).setAttribute("max","40" );
      ((Element)v.get(149)).setAttribute("onchange","" );
      ((Element)v.get(149)).setAttribute("req","N" );
      ((Element)v.get(149)).setAttribute("size","40" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("validacion","" );
      ((Element)v.get(149)).setAttribute("disabled","" );
      ((Element)v.get(149)).setAttribute("onblur","" );
      ((Element)v.get(149)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',5, true)" );
      ((Element)v.get(149)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm', 5, false)" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:150 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("nombre","valDescGapTdId" );
      ((Element)v.get(150)).setAttribute("nowrap","true" );
      ((Element)v.get(150)).setAttribute("class","datosCampos" );
      ((Element)v.get(141)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","25" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(141)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:136   */

      /* Empieza nodo:154 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("align","center" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:154   */

      /* Empieza nodo:161 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(161)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","12" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(165)).setAttribute("align","left" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(166)).setAttribute("align","left" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("nombre","valGrupArtiTdId" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(168)).setAttribute("border","0" );
      ((Element)v.get(168)).setAttribute("cellspacing","0" );
      ((Element)v.get(168)).setAttribute("cellpadding","0" );
      ((Element)v.get(168)).setAttribute("align","left" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("valign","top" );
      ((Element)v.get(170)).setAttribute("height","13" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblValGrupArti" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","IntParamContaFactu.valGrupArti.label" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:172 / Elemento padre: 168   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).setAttribute("nombre","valGrupArtiWidgetTrId" );
      ((Element)v.get(168)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("align","left" );
      ((Element)v.get(173)).setAttribute("nowrap","true" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(174)).setAttribute("nombre","valGrupArti" );
      ((Element)v.get(174)).setAttribute("id","datosCampos" );
      ((Element)v.get(174)).setAttribute("trim","S" );
      ((Element)v.get(174)).setAttribute("max","9" );
      ((Element)v.get(174)).setAttribute("onchange","" );
      ((Element)v.get(174)).setAttribute("req","N" );
      ((Element)v.get(174)).setAttribute("size","9" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("validacion","" );
      ((Element)v.get(174)).setAttribute("disabled","" );
      ((Element)v.get(174)).setAttribute("onblur","" );
      ((Element)v.get(174)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',6, true)" );
      ((Element)v.get(174)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm', 6, false)" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("nombre","valGrupArtiGapTdId" );
      ((Element)v.get(175)).setAttribute("nowrap","true" );
      ((Element)v.get(175)).setAttribute("class","datosCampos" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 166   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(166)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:161   */

      /* Empieza nodo:179 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(179)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","12" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("align","center" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","12" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:179   */

      /* Empieza nodo:186 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(186)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("align","center" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","12" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(190)).setAttribute("border","0" );
      ((Element)v.get(190)).setAttribute("cellspacing","0" );
      ((Element)v.get(190)).setAttribute("cellpadding","0" );
      ((Element)v.get(190)).setAttribute("align","left" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(191)).setAttribute("align","left" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("nombre","maprOidMarcProdTdId" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(193)).setAttribute("border","0" );
      ((Element)v.get(193)).setAttribute("cellspacing","0" );
      ((Element)v.get(193)).setAttribute("cellpadding","0" );
      ((Element)v.get(193)).setAttribute("align","left" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("valign","top" );
      ((Element)v.get(195)).setAttribute("height","13" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblmaprOidMarcProd" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(196)).setAttribute("ancho","150" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("cod","IntParamContaFactu.maprOidMarcProd.label" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 193   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(197)).setAttribute("nombre","maprOidMarcProdWidgetTrId" );
      ((Element)v.get(193)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("align","left" );
      ((Element)v.get(198)).setAttribute("nowrap","true" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(199)).setAttribute("nombre","maprOidMarcProd" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("multiple","N" );
      ((Element)v.get(199)).setAttribute("req","N" );
      ((Element)v.get(199)).setAttribute("size","1" );
      ((Element)v.get(199)).setAttribute("disabled","" );
      ((Element)v.get(199)).setAttribute("validacion","" );
      ((Element)v.get(199)).setAttribute("onchange","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(199)).setAttribute("onfocus","" );
      ((Element)v.get(199)).setAttribute("valorinicial","" );
      ((Element)v.get(199)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',7, true);" );
      ((Element)v.get(199)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',7, false);" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:201 / Elemento padre: 191   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("nombre","maprOidMarcProdGapTdId" );
      ((Element)v.get(201)).setAttribute("nowrap","true" );
      ((Element)v.get(201)).setAttribute("class","datosCampos" );
      ((Element)v.get(191)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 191   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:186   */

      /* Empieza nodo:205 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(205)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("align","center" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","12" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:205   */

      /* Empieza nodo:212 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(212)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("align","center" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","12" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(216)).setAttribute("width","100%" );
      ((Element)v.get(216)).setAttribute("border","0" );
      ((Element)v.get(216)).setAttribute("cellspacing","0" );
      ((Element)v.get(216)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(217)).setAttribute("align","left" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("nombre","negoOidNegoTdId" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(219)).setAttribute("border","0" );
      ((Element)v.get(219)).setAttribute("cellspacing","0" );
      ((Element)v.get(219)).setAttribute("cellpadding","0" );
      ((Element)v.get(219)).setAttribute("align","left" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("valign","top" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(221)).setAttribute("height","13" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(222)).setAttribute("nombre","lblnegoOidNego" );
      ((Element)v.get(222)).setAttribute("id","datosTitle" );
      ((Element)v.get(222)).setAttribute("ancho","150" );
      ((Element)v.get(222)).setAttribute("alto","13" );
      ((Element)v.get(222)).setAttribute("cod","IntParamContaFactu.negoOidNego.label" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:223 / Elemento padre: 219   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(223)).setAttribute("nombre","negoOidNegoWidgetTrId" );
      ((Element)v.get(219)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(224)).setAttribute("align","left" );
      ((Element)v.get(224)).setAttribute("nowrap","true" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(225)).setAttribute("nombre","negoOidNego" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).setAttribute("multiple","N" );
      ((Element)v.get(225)).setAttribute("req","N" );
      ((Element)v.get(225)).setAttribute("size","1" );
      ((Element)v.get(225)).setAttribute("disabled","" );
      ((Element)v.get(225)).setAttribute("validacion","" );
      ((Element)v.get(225)).setAttribute("onchange","" );
      ((Element)v.get(225)).setAttribute("onfocus","" );
      ((Element)v.get(225)).setAttribute("valorinicial","" );
      ((Element)v.get(225)).setAttribute("textoinicial","" );
      ((Element)v.get(225)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',8, true);" );
      ((Element)v.get(225)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',8, false);" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:227 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).setAttribute("nombre","negoOidNegoGapTdId" );
      ((Element)v.get(227)).setAttribute("nowrap","true" );
      ((Element)v.get(227)).setAttribute("class","datosCampos" );
      ((Element)v.get(217)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(217)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:212   */

      /* Empieza nodo:231 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(231)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 231   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("align","center" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","12" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:231   */

      /* Empieza nodo:238 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(238)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("align","center" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","12" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(242)).setAttribute("width","100%" );
      ((Element)v.get(242)).setAttribute("border","0" );
      ((Element)v.get(242)).setAttribute("cellspacing","0" );
      ((Element)v.get(242)).setAttribute("cellpadding","0" );
      ((Element)v.get(242)).setAttribute("align","left" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(243)).setAttribute("align","left" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("nombre","prodOidProdTdId" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

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
      ((Element)v.get(248)).setAttribute("nombre","lblProdOidProd" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("id","datosTitle" );
      ((Element)v.get(248)).setAttribute("cod","IntParamContaFactu.prodOidProd.label" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:249 / Elemento padre: 245   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(249)).setAttribute("nombre","prodOidProdWidgetTrId" );
      ((Element)v.get(245)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("align","left" );
      ((Element)v.get(250)).setAttribute("nowrap","true" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(251)).setAttribute("nombre","prodOidProd" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("trim","S" );
      ((Element)v.get(251)).setAttribute("max","20" );
      ((Element)v.get(251)).setAttribute("onchange","" );
      ((Element)v.get(251)).setAttribute("req","N" );
      ((Element)v.get(251)).setAttribute("size","20" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("validacion","" );
      ((Element)v.get(251)).setAttribute("disabled","" );
      ((Element)v.get(251)).setAttribute("onblur","" );
      ((Element)v.get(251)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',9, true)" );
      ((Element)v.get(251)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm', 9, false)" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:252 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("nombre","prodOidProdGapTdId" );
      ((Element)v.get(252)).setAttribute("nowrap","true" );
      ((Element)v.get(252)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(243)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:238   */

      /* Empieza nodo:256 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(256)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("align","center" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","12" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 256   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(261)).setAttribute("align","center" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","12" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:256   */

      /* Empieza nodo:263 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(263)).setAttribute("nombre","formTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("align","center" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","12" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

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
      ((Element)v.get(268)).setAttribute("align","left" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("nombre","cucoOidCuenContTdId" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(270)).setAttribute("border","0" );
      ((Element)v.get(270)).setAttribute("cellspacing","0" );
      ((Element)v.get(270)).setAttribute("cellpadding","0" );
      ((Element)v.get(270)).setAttribute("align","left" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("valign","top" );
      ((Element)v.get(272)).setAttribute("height","13" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(273)).setAttribute("nombre","lblcucoOidCuenCont" );
      ((Element)v.get(273)).setAttribute("id","datosTitle" );
      ((Element)v.get(273)).setAttribute("ancho","150" );
      ((Element)v.get(273)).setAttribute("alto","13" );
      ((Element)v.get(273)).setAttribute("cod","IntParamContaFactu.cucoOidCuenCont.label" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:274 / Elemento padre: 270   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(274)).setAttribute("nombre","cucoOidCuenContWidgetTrId" );
      ((Element)v.get(270)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("align","left" );
      ((Element)v.get(275)).setAttribute("nowrap","true" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(276)).setAttribute("nombre","cucoOidCuenCont" );
      ((Element)v.get(276)).setAttribute("id","datosCampos" );
      ((Element)v.get(276)).setAttribute("multiple","N" );
      ((Element)v.get(276)).setAttribute("req","N" );
      ((Element)v.get(276)).setAttribute("size","1" );
      ((Element)v.get(276)).setAttribute("disabled","" );
      ((Element)v.get(276)).setAttribute("validacion","" );
      ((Element)v.get(276)).setAttribute("onchange","" );
      ((Element)v.get(276)).setAttribute("onfocus","" );
      ((Element)v.get(276)).setAttribute("valorinicial","" );
      ((Element)v.get(276)).setAttribute("textoinicial","" );
      ((Element)v.get(276)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',10, true);" );
      ((Element)v.get(276)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',10, false);" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:278 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("nombre","cucoOidCuenContGapTdId" );
      ((Element)v.get(278)).setAttribute("nowrap","true" );
      ((Element)v.get(278)).setAttribute("class","datosCampos" );
      ((Element)v.get(268)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","25" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("width","100%" );
      ((Element)v.get(268)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:263   */

      /* Empieza nodo:282 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(282)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("width","8" );
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
      ((Element)v.get(287)).setAttribute("width","8" );
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
      ((Element)v.get(289)).setAttribute("nombre","formTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("align","center" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
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
      v.add(doc.createElement("TR"));
      ((Element)v.get(294)).setAttribute("align","left" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("nombre","valIndiDebeHabeTdId" );
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
      ((Element)v.get(299)).setAttribute("nombre","lblValIndiDebeHabe" );
      ((Element)v.get(299)).setAttribute("ancho","150" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","IntParamContaFactu.valIndiDebeHabe.label" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 296   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","valIndiDebeHabeWidgetTrId" );
      ((Element)v.get(296)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","left" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(301)).setAttribute("nowrap","true" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(302)).setAttribute("nombre","valIndiDebeHabe" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("multiple","N" );
      ((Element)v.get(302)).setAttribute("req","N" );
      ((Element)v.get(302)).setAttribute("size","1" );
      ((Element)v.get(302)).setAttribute("validacion","" );
      ((Element)v.get(302)).setAttribute("onchange","" );
      ((Element)v.get(302)).setAttribute("onfocus","" );
      ((Element)v.get(302)).setAttribute("valorinicial","" );
      ((Element)v.get(302)).setAttribute("textoinicial","" );
      ((Element)v.get(302)).setAttribute("disabled","" );
      ((Element)v.get(302)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',11, true)" );
      ((Element)v.get(302)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',11, false)" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(304)).setAttribute("ID","D" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(305)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(305)).setAttribute("TIPO","STRING" );
      ((Element)v.get(305)).setAttribute("VALOR","D" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 304   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(306)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(306)).setAttribute("TIPO","STRING" );
      ((Element)v.get(306)).setAttribute("VALOR","D" );
      ((Element)v.get(304)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:304   */

      /* Empieza nodo:307 / Elemento padre: 303   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(307)).setAttribute("ID","H" );
      ((Element)v.get(303)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(308)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(308)).setAttribute("TIPO","STRING" );
      ((Element)v.get(308)).setAttribute("VALOR","H" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 307   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(309)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(309)).setAttribute("TIPO","STRING" );
      ((Element)v.get(309)).setAttribute("VALOR","H" );
      ((Element)v.get(307)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:307   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:310 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("nombre","valIndiDebeHabeGapTdId" );
      ((Element)v.get(310)).setAttribute("nowrap","true" );
      ((Element)v.get(310)).setAttribute("class","datosCampos" );
      ((Element)v.get(294)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("width","100%" );
      ((Element)v.get(294)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:289   */

      /* Empieza nodo:314 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(314)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","12" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("align","center" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","12" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:314   */

      /* Empieza nodo:321 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(321)).setAttribute("nombre","formTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("align","center" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","12" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(325)).setAttribute("width","100%" );
      ((Element)v.get(325)).setAttribute("border","0" );
      ((Element)v.get(325)).setAttribute("cellspacing","0" );
      ((Element)v.get(325)).setAttribute("cellpadding","0" );
      ((Element)v.get(325)).setAttribute("align","left" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(326)).setAttribute("align","left" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).setAttribute("nombre","imcfOidImpoContFactTdId" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(328)).setAttribute("border","0" );
      ((Element)v.get(328)).setAttribute("cellspacing","0" );
      ((Element)v.get(328)).setAttribute("cellpadding","0" );
      ((Element)v.get(328)).setAttribute("align","left" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("valign","top" );
      ((Element)v.get(330)).setAttribute("height","13" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblimcfOidImpoContFact" );
      ((Element)v.get(331)).setAttribute("id","datosTitle" );
      ((Element)v.get(331)).setAttribute("ancho","150" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("cod","IntParamContaFactu.imcfOidImpoContFact.label" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:332 / Elemento padre: 328   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(332)).setAttribute("nombre","imcfOidImpoContFactWidgetTrId" );
      ((Element)v.get(328)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("align","left" );
      ((Element)v.get(333)).setAttribute("nowrap","true" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(334)).setAttribute("nombre","imcfOidImpoContFact" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(334)).setAttribute("multiple","N" );
      ((Element)v.get(334)).setAttribute("req","N" );
      ((Element)v.get(334)).setAttribute("size","1" );
      ((Element)v.get(334)).setAttribute("disabled","" );
      ((Element)v.get(334)).setAttribute("validacion","" );
      ((Element)v.get(334)).setAttribute("onchange","" );
      ((Element)v.get(334)).setAttribute("onfocus","" );
      ((Element)v.get(334)).setAttribute("valorinicial","" );
      ((Element)v.get(334)).setAttribute("textoinicial","" );
      ((Element)v.get(334)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',12, true);" );
      ((Element)v.get(334)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',12, false);" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:336 / Elemento padre: 326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("nombre","imcfOidImpoContFactGapTdId" );
      ((Element)v.get(336)).setAttribute("nowrap","true" );
      ((Element)v.get(336)).setAttribute("class","datosCampos" );
      ((Element)v.get(326)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","25" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("width","100%" );
      ((Element)v.get(326)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:321   */

      /* Empieza nodo:340 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(340)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(341)).setAttribute("align","center" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","12" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("align","center" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","12" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:340   */

      /* Empieza nodo:347 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(347)).setAttribute("nombre","formTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("align","center" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","12" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("width","100%" );
      ((Element)v.get(347)).appendChild((Element)v.get(350));

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
      ((Element)v.get(352)).setAttribute("align","left" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(354)).setAttribute("border","0" );
      ((Element)v.get(354)).setAttribute("cellspacing","0" );
      ((Element)v.get(354)).setAttribute("cellpadding","0" );
      ((Element)v.get(354)).setAttribute("align","left" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(356)).setAttribute("valign","top" );
      ((Element)v.get(356)).setAttribute("height","13" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(357)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(357)).setAttribute("id","datosTitle" );
      ((Element)v.get(357)).setAttribute("ancho","150" );
      ((Element)v.get(357)).setAttribute("alto","13" );
      ((Element)v.get(357)).setAttribute("cod","IntParamContaFactu.paisOidPais.label" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:358 / Elemento padre: 354   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(358)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(354)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("align","left" );
      ((Element)v.get(359)).setAttribute("nowrap","true" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(360)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(360)).setAttribute("id","datosCampos" );
      ((Element)v.get(360)).setAttribute("multiple","N" );
      ((Element)v.get(360)).setAttribute("req","N" );
      ((Element)v.get(360)).setAttribute("size","1" );
      ((Element)v.get(360)).setAttribute("disabled","" );
      ((Element)v.get(360)).setAttribute("validacion","" );
      ((Element)v.get(360)).setAttribute("onchange","" );
      ((Element)v.get(360)).setAttribute("onfocus","" );
      ((Element)v.get(360)).setAttribute("valorinicial","" );
      ((Element)v.get(360)).setAttribute("textoinicial","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(360)).setAttribute("ontab","ejecutarAccionFoco('intParamContaFactuFrm',13, true);" );
      ((Element)v.get(360)).setAttribute("onshtab","ejecutarAccionFoco('intParamContaFactuFrm',13, false);" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:362 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(362)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(362)).setAttribute("nowrap","true" );
      ((Element)v.get(362)).setAttribute("class","datosCampos" );
      ((Element)v.get(352)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","25" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(364)).setAttribute("width","100%" );
      ((Element)v.get(352)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:366 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).setAttribute("width","100%" );
      ((Element)v.get(347)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:347   */

      /* Empieza nodo:367 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(367)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("align","center" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(372)).setAttribute("align","center" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:367   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:374 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("align","center" );
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","12" );
      ((Element)v.get(375)).setAttribute("height","12" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:8   */

      /* Empieza nodo:376 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(376)).setAttribute("nombre","intParamContaFactuTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(377)).setAttribute("align","center" );
      ((Element)v.get(377)).setAttribute("width","12" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(378)).setAttribute("height","12" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(381)).setAttribute("width","100%" );
      ((Element)v.get(381)).setAttribute("border","0" );
      ((Element)v.get(381)).setAttribute("align","center" );
      ((Element)v.get(381)).setAttribute("cellspacing","0" );
      ((Element)v.get(381)).setAttribute("cellpadding","0" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(383)).setAttribute("class","tablaTitle" );
      ((Element)v.get(383)).setAttribute("nombre","intParamContaFactuTdQueryButton" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(384)).setAttribute("nombre","intParamContaFactuQueryButton" );
      ((Element)v.get(384)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(384)).setAttribute("estado","false" );
      ((Element)v.get(384)).setAttribute("accion","intParamContaFactuFirstPage();" );
      ((Element)v.get(384)).setAttribute("tipo","html" );
      ((Element)v.get(384)).setAttribute("ID","botonContenido" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("class","tablaTitle" );
      ((Element)v.get(385)).setAttribute("nombre","intParamContaFactuTdLovNullSelectionButton" );
      ((Element)v.get(385)).setAttribute("align","left" );
      ((Element)v.get(385)).setAttribute("width","100%" );
      ((Element)v.get(382)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(386)).setAttribute("width","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 385   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(387)).setAttribute("nombre","intParamContaFactuLovNullButton" );
      ((Element)v.get(387)).setAttribute("ID","botonContenido" );
      ((Element)v.get(387)).setAttribute("tipo","html" );
      ((Element)v.get(387)).setAttribute("accion","intParamContaFactuLovNullSelectionAction();" );
      ((Element)v.get(387)).setAttribute("estado","true" );
      ((Element)v.get(387)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(385)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:385   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:388 / Elemento padre: 376   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("align","center" );
      ((Element)v.get(388)).setAttribute("width","12" );
      ((Element)v.get(376)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","12" );
      ((Element)v.get(389)).setAttribute("height","12" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:376   */


   }

}
