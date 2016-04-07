
import org.w3c.dom.*;
import java.util.ArrayList;

public class CobAccioCobraPageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","CobAccioCobra.legend.label" );
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
      ((Element)v.get(29)).setAttribute("cod","CobAccioCobra.id.label" );
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
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',1, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 1, false)" );
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
      ((Element)v.get(50)).setAttribute("nombre","codAcciCobrTdId" );
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
      ((Element)v.get(54)).setAttribute("nombre","lblCodAcciCobr" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","CobAccioCobra.codAcciCobr.label" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(55)).setAttribute("nombre","codAcciCobrWidgetTrId" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("nowrap","true" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(57)).setAttribute("nombre","codAcciCobr" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("trim","S" );
      ((Element)v.get(57)).setAttribute("max","2" );
      ((Element)v.get(57)).setAttribute("onchange","" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("size","2" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("validacion","" );
      ((Element)v.get(57)).setAttribute("disabled","" );
      ((Element)v.get(57)).setAttribute("onblur","" );
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',2, true)" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 2, false)" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:58 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("nombre","codAcciCobrGapTdId" );
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
      ((Element)v.get(60)).setAttribute("nombre","valDescTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(61)).setAttribute("width","100%" );
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
      ((Element)v.get(64)).setAttribute("nombre","lblValDesc" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","CobAccioCobra.valDesc.label" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 61   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(65)).setAttribute("nombre","valDescWidgetTrId" );
      ((Element)v.get(61)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(66)).setAttribute("align","left" );
      ((Element)v.get(66)).setAttribute("nowrap","true" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(67)).setAttribute("nombre","valDesc" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("trim","S" );
      ((Element)v.get(67)).setAttribute("max","40" );
      ((Element)v.get(67)).setAttribute("onchange","" );
      ((Element)v.get(67)).setAttribute("req","N" );
      ((Element)v.get(67)).setAttribute("size","40" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("validacion","" );
      ((Element)v.get(67)).setAttribute("disabled","" );
      ((Element)v.get(67)).setAttribute("onblur","" );
      ((Element)v.get(67)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',3, true)" );
      ((Element)v.get(67)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 3, false)" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:68 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(68)).setAttribute("nombre","valDescGapTdId" );
      ((Element)v.get(68)).setAttribute("nowrap","true" );
      ((Element)v.get(68)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("nombre","saccOidSubtAcciTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).setAttribute("align","left" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("valign","top" );
      ((Element)v.get(73)).setAttribute("height","13" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblsaccOidSubtAcci" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("ancho","150" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("cod","CobAccioCobra.saccOidSubtAcci.label" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:75 / Elemento padre: 71   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(75)).setAttribute("nombre","saccOidSubtAcciWidgetTrId" );
      ((Element)v.get(71)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(76)).setAttribute("align","left" );
      ((Element)v.get(76)).setAttribute("nowrap","true" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(77)).setAttribute("nombre","saccOidSubtAcci" );
      ((Element)v.get(77)).setAttribute("id","datosCampos" );
      ((Element)v.get(77)).setAttribute("multiple","N" );
      ((Element)v.get(77)).setAttribute("req","N" );
      ((Element)v.get(77)).setAttribute("size","1" );
      ((Element)v.get(77)).setAttribute("disabled","" );
      ((Element)v.get(77)).setAttribute("validacion","" );
      ((Element)v.get(77)).setAttribute("onchange","" );
      ((Element)v.get(77)).setAttribute("onfocus","" );
      ((Element)v.get(77)).setAttribute("valorinicial","" );
      ((Element)v.get(77)).setAttribute("textoinicial","" );
      ((Element)v.get(77)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',4, true);" );
      ((Element)v.get(77)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',4, false);" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:79 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("nombre","saccOidSubtAcciGapTdId" );
      ((Element)v.get(79)).setAttribute("nowrap","true" );
      ((Element)v.get(79)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */

      /* Empieza nodo:83 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(83)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","12" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:83   */

      /* Empieza nodo:90 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(90)).setAttribute("nombre","formTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","12" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(96)).setAttribute("nombre","indFechHoraSeguTdId" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(97)).setAttribute("border","0" );
      ((Element)v.get(97)).setAttribute("cellspacing","0" );
      ((Element)v.get(97)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).setAttribute("align","left" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(99)).setAttribute("valign","top" );
      ((Element)v.get(99)).setAttribute("height","13" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(100)).setAttribute("nombre","lblIndFechHoraSegu" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","CobAccioCobra.indFechHoraSegu.label" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 97   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(101)).setAttribute("nombre","indFechHoraSeguWidgetTrId" );
      ((Element)v.get(97)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("align","left" );
      ((Element)v.get(102)).setAttribute("nowrap","true" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(103)).setAttribute("nombre","indFechHoraSegu" );
      ((Element)v.get(103)).setAttribute("tipo","H" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("disabled","" );
      ((Element)v.get(103)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',5, true)" );
      ((Element)v.get(103)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',5, false)" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("valor","1" );
      ((Element)v.get(104)).setAttribute("cod","CobAccioCobra.indFechHoraSegu.1.label" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Elemento padre:104 / Elemento actual: 105   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(104)).appendChild((Text)v.get(105));

      /* Termina nodo Texto:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("valor","0" );
      ((Element)v.get(106)).setAttribute("cod","CobAccioCobra.indFechHoraSegu.0.label" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Elemento padre:106 / Elemento actual: 107   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(106)).appendChild((Text)v.get(107));

      /* Termina nodo Texto:107   */
      /* Termina nodo:106   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:108 / Elemento padre: 95   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).setAttribute("nombre","indFechHoraSeguGapTdId" );
      ((Element)v.get(108)).setAttribute("nowrap","true" );
      ((Element)v.get(108)).setAttribute("class","datosCampos" );
      ((Element)v.get(95)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","25" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 95   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:90   */

      /* Empieza nodo:112 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(112)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","12" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:112   */

      /* Empieza nodo:119 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(119)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","12" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).setAttribute("align","left" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(124)).setAttribute("align","left" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("nombre","indFechImpoCompTdId" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("valign","top" );
      ((Element)v.get(128)).setAttribute("height","13" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblIndFechImpoComp" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("cod","CobAccioCobra.indFechImpoComp.label" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 126   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(130)).setAttribute("nombre","indFechImpoCompWidgetTrId" );
      ((Element)v.get(126)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).setAttribute("align","left" );
      ((Element)v.get(131)).setAttribute("nowrap","true" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(132)).setAttribute("nombre","indFechImpoComp" );
      ((Element)v.get(132)).setAttribute("tipo","H" );
      ((Element)v.get(132)).setAttribute("req","N" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("disabled","" );
      ((Element)v.get(132)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',6, true)" );
      ((Element)v.get(132)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',6, false)" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("valor","1" );
      ((Element)v.get(133)).setAttribute("cod","CobAccioCobra.indFechImpoComp.1.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Elemento padre:133 / Elemento actual: 134   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(133)).appendChild((Text)v.get(134));

      /* Termina nodo Texto:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(135)).setAttribute("id","datosCampos" );
      ((Element)v.get(135)).setAttribute("valor","0" );
      ((Element)v.get(135)).setAttribute("cod","CobAccioCobra.indFechImpoComp.0.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Elemento padre:135 / Elemento actual: 136   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(135)).appendChild((Text)v.get(136));

      /* Termina nodo Texto:136   */
      /* Termina nodo:135   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:137 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("nombre","indFechImpoCompGapTdId" );
      ((Element)v.get(137)).setAttribute("nowrap","true" );
      ((Element)v.get(137)).setAttribute("class","datosCampos" );
      ((Element)v.get(124)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("width","25" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(124)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:119   */

      /* Empieza nodo:141 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(141)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","12" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:141   */

      /* Empieza nodo:148 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(148)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","12" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(152)).setAttribute("border","0" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).setAttribute("align","left" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("nombre","indFechHoraNuevSeguTdId" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("valign","top" );
      ((Element)v.get(157)).setAttribute("height","13" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblIndFechHoraNuevSegu" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","CobAccioCobra.indFechHoraNuevSegu.label" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:159 / Elemento padre: 155   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(159)).setAttribute("nombre","indFechHoraNuevSeguWidgetTrId" );
      ((Element)v.get(155)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("align","left" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(160)).setAttribute("nowrap","true" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(161)).setAttribute("nombre","indFechHoraNuevSegu" );
      ((Element)v.get(161)).setAttribute("tipo","H" );
      ((Element)v.get(161)).setAttribute("req","N" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("disabled","" );
      ((Element)v.get(161)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',7, true)" );
      ((Element)v.get(161)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',7, false)" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(162)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).setAttribute("valor","1" );
      ((Element)v.get(162)).setAttribute("cod","CobAccioCobra.indFechHoraNuevSegu.1.label" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Elemento padre:162 / Elemento actual: 163   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(162)).appendChild((Text)v.get(163));

      /* Termina nodo Texto:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(164)).setAttribute("id","datosCampos" );
      ((Element)v.get(164)).setAttribute("valor","0" );
      ((Element)v.get(164)).setAttribute("cod","CobAccioCobra.indFechHoraNuevSegu.0.label" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Elemento padre:164 / Elemento actual: 165   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(164)).appendChild((Text)v.get(165));

      /* Termina nodo Texto:165   */
      /* Termina nodo:164   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:166 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("nombre","indFechHoraNuevSeguGapTdId" );
      ((Element)v.get(166)).setAttribute("nowrap","true" );
      ((Element)v.get(166)).setAttribute("class","datosCampos" );
      ((Element)v.get(153)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(153)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:148   */

      /* Empieza nodo:170 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(170)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("align","center" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("align","center" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","12" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:170   */

      /* Empieza nodo:177 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(177)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).setAttribute("align","center" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","12" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(181)).setAttribute("border","0" );
      ((Element)v.get(181)).setAttribute("cellspacing","0" );
      ((Element)v.get(181)).setAttribute("cellpadding","0" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(181)).setAttribute("align","left" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(182)).setAttribute("align","left" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("nombre","indAporPrueTdId" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(184)).setAttribute("border","0" );
      ((Element)v.get(184)).setAttribute("cellspacing","0" );
      ((Element)v.get(184)).setAttribute("cellpadding","0" );
      ((Element)v.get(184)).setAttribute("align","left" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(186)).setAttribute("valign","top" );
      ((Element)v.get(186)).setAttribute("height","13" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblIndAporPrue" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","CobAccioCobra.indAporPrue.label" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:188 / Elemento padre: 184   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(188)).setAttribute("nombre","indAporPrueWidgetTrId" );
      ((Element)v.get(184)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("align","left" );
      ((Element)v.get(189)).setAttribute("nowrap","true" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(190)).setAttribute("nombre","indAporPrue" );
      ((Element)v.get(190)).setAttribute("tipo","H" );
      ((Element)v.get(190)).setAttribute("req","N" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("disabled","" );
      ((Element)v.get(190)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',8, true)" );
      ((Element)v.get(190)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',8, false)" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("valor","1" );
      ((Element)v.get(191)).setAttribute("cod","CobAccioCobra.indAporPrue.1.label" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Elemento padre:191 / Elemento actual: 192   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(191)).appendChild((Text)v.get(192));

      /* Termina nodo Texto:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(193)).setAttribute("id","datosCampos" );
      ((Element)v.get(193)).setAttribute("valor","0" );
      ((Element)v.get(193)).setAttribute("cod","CobAccioCobra.indAporPrue.0.label" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));

      /* Elemento padre:193 / Elemento actual: 194   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(193)).appendChild((Text)v.get(194));

      /* Termina nodo Texto:194   */
      /* Termina nodo:193   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:195 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("nombre","indAporPrueGapTdId" );
      ((Element)v.get(195)).setAttribute("nowrap","true" );
      ((Element)v.get(195)).setAttribute("class","datosCampos" );
      ((Element)v.get(182)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:177   */

      /* Empieza nodo:199 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(199)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).setAttribute("align","center" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","12" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:199   */

      /* Empieza nodo:206 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(206)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("align","center" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","12" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(210)).setAttribute("border","0" );
      ((Element)v.get(210)).setAttribute("cellspacing","0" );
      ((Element)v.get(210)).setAttribute("cellpadding","0" );
      ((Element)v.get(210)).setAttribute("align","left" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("nombre","indDescPrueTdId" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(213)).setAttribute("width","100%" );
      ((Element)v.get(213)).setAttribute("border","0" );
      ((Element)v.get(213)).setAttribute("cellspacing","0" );
      ((Element)v.get(213)).setAttribute("cellpadding","0" );
      ((Element)v.get(213)).setAttribute("align","left" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("valign","top" );
      ((Element)v.get(215)).setAttribute("height","13" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(216)).setAttribute("nombre","lblIndDescPrue" );
      ((Element)v.get(216)).setAttribute("alto","13" );
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("id","datosTitle" );
      ((Element)v.get(216)).setAttribute("cod","CobAccioCobra.indDescPrue.label" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:217 / Elemento padre: 213   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(217)).setAttribute("nombre","indDescPrueWidgetTrId" );
      ((Element)v.get(213)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("align","left" );
      ((Element)v.get(218)).setAttribute("nowrap","true" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(219)).setAttribute("nombre","indDescPrue" );
      ((Element)v.get(219)).setAttribute("tipo","H" );
      ((Element)v.get(219)).setAttribute("req","N" );
      ((Element)v.get(219)).setAttribute("id","datosCampos" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("disabled","" );
      ((Element)v.get(219)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',9, true)" );
      ((Element)v.get(219)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',9, false)" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("valor","1" );
      ((Element)v.get(220)).setAttribute("cod","CobAccioCobra.indDescPrue.1.label" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Elemento padre:220 / Elemento actual: 221   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(220)).appendChild((Text)v.get(221));

      /* Termina nodo Texto:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("valor","0" );
      ((Element)v.get(222)).setAttribute("cod","CobAccioCobra.indDescPrue.0.label" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Elemento padre:222 / Elemento actual: 223   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createTextNode("x"));
      ((Element)v.get(222)).appendChild((Text)v.get(223));

      /* Termina nodo Texto:223   */
      /* Termina nodo:222   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:224 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(224)).setAttribute("nombre","indDescPrueGapTdId" );
      ((Element)v.get(224)).setAttribute("nowrap","true" );
      ((Element)v.get(224)).setAttribute("class","datosCampos" );
      ((Element)v.get(211)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","25" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("width","100%" );
      ((Element)v.get(211)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:206   */

      /* Empieza nodo:228 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(228)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","12" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:228   */

      /* Empieza nodo:235 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(235)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("align","center" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","12" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 235   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("width","100%" );
      ((Element)v.get(235)).appendChild((Element)v.get(238));

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
      ((Element)v.get(240)).setAttribute("align","left" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("nombre","indNumeDocuSopoTdId" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

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
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("valign","top" );
      ((Element)v.get(244)).setAttribute("height","13" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(245)).setAttribute("nombre","lblIndNumeDocuSopo" );
      ((Element)v.get(245)).setAttribute("alto","13" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(245)).setAttribute("filas","1" );
      ((Element)v.get(245)).setAttribute("id","datosTitle" );
      ((Element)v.get(245)).setAttribute("cod","CobAccioCobra.indNumeDocuSopo.label" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 242   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(246)).setAttribute("nombre","indNumeDocuSopoWidgetTrId" );
      ((Element)v.get(242)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("align","left" );
      ((Element)v.get(247)).setAttribute("nowrap","true" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(248)).setAttribute("nombre","indNumeDocuSopo" );
      ((Element)v.get(248)).setAttribute("tipo","H" );
      ((Element)v.get(248)).setAttribute("req","N" );
      ((Element)v.get(248)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("disabled","" );
      ((Element)v.get(248)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',10, true)" );
      ((Element)v.get(248)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',10, false)" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(249)).setAttribute("valor","1" );
      ((Element)v.get(249)).setAttribute("cod","CobAccioCobra.indNumeDocuSopo.1.label" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Elemento padre:249 / Elemento actual: 250   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(249)).appendChild((Text)v.get(250));

      /* Termina nodo Texto:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("valor","0" );
      ((Element)v.get(251)).setAttribute("cod","CobAccioCobra.indNumeDocuSopo.0.label" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Elemento padre:251 / Elemento actual: 252   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(251)).appendChild((Text)v.get(252));

      /* Termina nodo Texto:252   */
      /* Termina nodo:251   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:253 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(253)).setAttribute("nombre","indNumeDocuSopoGapTdId" );
      ((Element)v.get(253)).setAttribute("nowrap","true" );
      ((Element)v.get(253)).setAttribute("class","datosCampos" );
      ((Element)v.get(240)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","25" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("width","100%" );
      ((Element)v.get(240)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:235   */

      /* Empieza nodo:257 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(257)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("align","center" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","12" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:257   */

      /* Empieza nodo:264 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(264)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(265)).setAttribute("align","center" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","12" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("width","100%" );
      ((Element)v.get(264)).appendChild((Element)v.get(267));

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
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("nombre","indTipoDocuPagoTdId" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(271)).setAttribute("width","100%" );
      ((Element)v.get(271)).setAttribute("border","0" );
      ((Element)v.get(271)).setAttribute("cellspacing","0" );
      ((Element)v.get(271)).setAttribute("cellpadding","0" );
      ((Element)v.get(271)).setAttribute("align","left" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("valign","top" );
      ((Element)v.get(273)).setAttribute("height","13" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblIndTipoDocuPago" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("id","datosTitle" );
      ((Element)v.get(274)).setAttribute("cod","CobAccioCobra.indTipoDocuPago.label" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 271   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(275)).setAttribute("nombre","indTipoDocuPagoWidgetTrId" );
      ((Element)v.get(271)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("align","left" );
      ((Element)v.get(276)).setAttribute("nowrap","true" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(277)).setAttribute("nombre","indTipoDocuPago" );
      ((Element)v.get(277)).setAttribute("tipo","H" );
      ((Element)v.get(277)).setAttribute("req","N" );
      ((Element)v.get(277)).setAttribute("id","datosCampos" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(277)).setAttribute("disabled","" );
      ((Element)v.get(277)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',11, true)" );
      ((Element)v.get(277)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',11, false)" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(278)).setAttribute("valor","1" );
      ((Element)v.get(278)).setAttribute("cod","CobAccioCobra.indTipoDocuPago.1.label" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Elemento padre:278 / Elemento actual: 279   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(278)).appendChild((Text)v.get(279));

      /* Termina nodo Texto:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(280)).setAttribute("id","datosCampos" );
      ((Element)v.get(280)).setAttribute("valor","0" );
      ((Element)v.get(280)).setAttribute("cod","CobAccioCobra.indTipoDocuPago.0.label" );
      ((Element)v.get(277)).appendChild((Element)v.get(280));

      /* Elemento padre:280 / Elemento actual: 281   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(280)).appendChild((Text)v.get(281));

      /* Termina nodo Texto:281   */
      /* Termina nodo:280   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:282 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).setAttribute("nombre","indTipoDocuPagoGapTdId" );
      ((Element)v.get(282)).setAttribute("nowrap","true" );
      ((Element)v.get(282)).setAttribute("class","datosCampos" );
      ((Element)v.get(269)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","25" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(269)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:264   */

      /* Empieza nodo:286 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(286)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("align","center" );
      ((Element)v.get(287)).setAttribute("width","8" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","12" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("align","center" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","12" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:286   */

      /* Empieza nodo:293 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(293)).setAttribute("nombre","formTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("align","center" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","12" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).setAttribute("width","100%" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(297)).setAttribute("border","0" );
      ((Element)v.get(297)).setAttribute("cellspacing","0" );
      ((Element)v.get(297)).setAttribute("cellpadding","0" );
      ((Element)v.get(297)).setAttribute("align","left" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(298)).setAttribute("align","left" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(299)).setAttribute("nombre","indBancSucuTdId" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
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
      ((Element)v.get(303)).setAttribute("nombre","lblIndBancSucu" );
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("id","datosTitle" );
      ((Element)v.get(303)).setAttribute("cod","CobAccioCobra.indBancSucu.label" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 300   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(304)).setAttribute("nombre","indBancSucuWidgetTrId" );
      ((Element)v.get(300)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("align","left" );
      ((Element)v.get(305)).setAttribute("nowrap","true" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(306)).setAttribute("nombre","indBancSucu" );
      ((Element)v.get(306)).setAttribute("tipo","H" );
      ((Element)v.get(306)).setAttribute("req","N" );
      ((Element)v.get(306)).setAttribute("id","datosCampos" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("disabled","" );
      ((Element)v.get(306)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',12, true)" );
      ((Element)v.get(306)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',12, false)" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(307)).setAttribute("id","datosCampos" );
      ((Element)v.get(307)).setAttribute("valor","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(307)).setAttribute("cod","CobAccioCobra.indBancSucu.1.label" );
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
      ((Element)v.get(309)).setAttribute("cod","CobAccioCobra.indBancSucu.0.label" );
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

      /* Empieza nodo:311 / Elemento padre: 298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(311)).setAttribute("nombre","indBancSucuGapTdId" );
      ((Element)v.get(311)).setAttribute("nowrap","true" );
      ((Element)v.get(311)).setAttribute("class","datosCampos" );
      ((Element)v.get(298)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","25" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("width","100%" );
      ((Element)v.get(298)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:293   */

      /* Empieza nodo:315 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(315)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).setAttribute("align","center" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","12" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("align","center" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","12" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:315   */

      /* Empieza nodo:322 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(322)).setAttribute("nombre","formTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("align","center" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(324)).setAttribute("height","12" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("width","100%" );
      ((Element)v.get(322)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(326)).setAttribute("width","100%" );
      ((Element)v.get(326)).setAttribute("border","0" );
      ((Element)v.get(326)).setAttribute("cellspacing","0" );
      ((Element)v.get(326)).setAttribute("cellpadding","0" );
      ((Element)v.get(326)).setAttribute("align","left" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(327)).setAttribute("align","left" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(328)).setAttribute("nombre","indNuevDireTdId" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(329)).setAttribute("width","100%" );
      ((Element)v.get(329)).setAttribute("border","0" );
      ((Element)v.get(329)).setAttribute("cellspacing","0" );
      ((Element)v.get(329)).setAttribute("cellpadding","0" );
      ((Element)v.get(329)).setAttribute("align","left" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("valign","top" );
      ((Element)v.get(331)).setAttribute("height","13" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(332)).setAttribute("nombre","lblIndNuevDire" );
      ((Element)v.get(332)).setAttribute("alto","13" );
      ((Element)v.get(332)).setAttribute("filas","1" );
      ((Element)v.get(332)).setAttribute("id","datosTitle" );
      ((Element)v.get(332)).setAttribute("cod","CobAccioCobra.indNuevDire.label" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:333 / Elemento padre: 329   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(333)).setAttribute("nombre","indNuevDireWidgetTrId" );
      ((Element)v.get(329)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).setAttribute("align","left" );
      ((Element)v.get(334)).setAttribute("nowrap","true" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(335)).setAttribute("nombre","indNuevDire" );
      ((Element)v.get(335)).setAttribute("tipo","H" );
      ((Element)v.get(335)).setAttribute("req","N" );
      ((Element)v.get(335)).setAttribute("id","datosCampos" );
      ((Element)v.get(335)).setAttribute("valor","" );
      ((Element)v.get(335)).setAttribute("disabled","" );
      ((Element)v.get(335)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',13, true)" );
      ((Element)v.get(335)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',13, false)" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(336)).setAttribute("id","datosCampos" );
      ((Element)v.get(336)).setAttribute("valor","1" );
      ((Element)v.get(336)).setAttribute("cod","CobAccioCobra.indNuevDire.1.label" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Elemento padre:336 / Elemento actual: 337   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(336)).appendChild((Text)v.get(337));

      /* Termina nodo Texto:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 335   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(338)).setAttribute("valor","0" );
      ((Element)v.get(338)).setAttribute("cod","CobAccioCobra.indNuevDire.0.label" );
      ((Element)v.get(335)).appendChild((Element)v.get(338));

      /* Elemento padre:338 / Elemento actual: 339   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(338)).appendChild((Text)v.get(339));

      /* Termina nodo Texto:339   */
      /* Termina nodo:338   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:340 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).setAttribute("nombre","indNuevDireGapTdId" );
      ((Element)v.get(340)).setAttribute("nowrap","true" );
      ((Element)v.get(340)).setAttribute("class","datosCampos" );
      ((Element)v.get(327)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","25" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("width","100%" );
      ((Element)v.get(327)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:322   */

      /* Empieza nodo:344 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(344)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("align","center" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","12" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(344)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("align","center" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","12" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:344   */

      /* Empieza nodo:351 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(351)).setAttribute("nombre","formTr11" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","12" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("width","100%" );
      ((Element)v.get(351)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(355)).setAttribute("width","100%" );
      ((Element)v.get(355)).setAttribute("border","0" );
      ((Element)v.get(355)).setAttribute("cellspacing","0" );
      ((Element)v.get(355)).setAttribute("cellpadding","0" );
      ((Element)v.get(355)).setAttribute("align","left" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(356)).setAttribute("align","left" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("nombre","indNuevTelfTdId" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(358)).setAttribute("width","100%" );
      ((Element)v.get(358)).setAttribute("border","0" );
      ((Element)v.get(358)).setAttribute("cellspacing","0" );
      ((Element)v.get(358)).setAttribute("cellpadding","0" );
      ((Element)v.get(358)).setAttribute("align","left" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("valign","top" );
      ((Element)v.get(360)).setAttribute("height","13" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblIndNuevTelf" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("id","datosTitle" );
      ((Element)v.get(361)).setAttribute("cod","CobAccioCobra.indNuevTelf.label" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:362 / Elemento padre: 358   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(362)).setAttribute("nombre","indNuevTelfWidgetTrId" );
      ((Element)v.get(358)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("align","left" );
      ((Element)v.get(363)).setAttribute("nowrap","true" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(364)).setAttribute("nombre","indNuevTelf" );
      ((Element)v.get(364)).setAttribute("tipo","H" );
      ((Element)v.get(364)).setAttribute("req","N" );
      ((Element)v.get(364)).setAttribute("id","datosCampos" );
      ((Element)v.get(364)).setAttribute("valor","" );
      ((Element)v.get(364)).setAttribute("disabled","" );
      ((Element)v.get(364)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',14, true)" );
      ((Element)v.get(364)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',14, false)" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(365)).setAttribute("id","datosCampos" );
      ((Element)v.get(365)).setAttribute("valor","1" );
      ((Element)v.get(365)).setAttribute("cod","CobAccioCobra.indNuevTelf.1.label" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Elemento padre:365 / Elemento actual: 366   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(365)).appendChild((Text)v.get(366));

      /* Termina nodo Texto:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(367)).setAttribute("id","datosCampos" );
      ((Element)v.get(367)).setAttribute("valor","0" );
      ((Element)v.get(367)).setAttribute("cod","CobAccioCobra.indNuevTelf.0.label" );
      ((Element)v.get(364)).appendChild((Element)v.get(367));

      /* Elemento padre:367 / Elemento actual: 368   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(367)).appendChild((Text)v.get(368));

      /* Termina nodo Texto:368   */
      /* Termina nodo:367   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:369 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(369)).setAttribute("nombre","indNuevTelfGapTdId" );
      ((Element)v.get(369)).setAttribute("nowrap","true" );
      ((Element)v.get(369)).setAttribute("class","datosCampos" );
      ((Element)v.get(356)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("width","25" );
      ((Element)v.get(370)).setAttribute("height","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(356)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:351   */

      /* Empieza nodo:373 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(373)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("align","center" );
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","12" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(373)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","8" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(378)).setAttribute("align","center" );
      ((Element)v.get(378)).setAttribute("width","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","12" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:373   */

      /* Empieza nodo:380 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(380)).setAttribute("nombre","formTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(381)).setAttribute("align","center" );
      ((Element)v.get(381)).setAttribute("width","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).setAttribute("width","8" );
      ((Element)v.get(382)).setAttribute("height","12" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 380   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(380)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(384)).setAttribute("border","0" );
      ((Element)v.get(384)).setAttribute("cellspacing","0" );
      ((Element)v.get(384)).setAttribute("cellpadding","0" );
      ((Element)v.get(384)).setAttribute("align","left" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(385)).setAttribute("align","left" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).setAttribute("nombre","indPasaAdmiTdId" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(387)).setAttribute("width","100%" );
      ((Element)v.get(387)).setAttribute("border","0" );
      ((Element)v.get(387)).setAttribute("cellspacing","0" );
      ((Element)v.get(387)).setAttribute("cellpadding","0" );
      ((Element)v.get(387)).setAttribute("align","left" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(389)).setAttribute("valign","top" );
      ((Element)v.get(389)).setAttribute("height","13" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(390)).setAttribute("nombre","lblIndPasaAdmi" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("id","datosTitle" );
      ((Element)v.get(390)).setAttribute("cod","CobAccioCobra.indPasaAdmi.label" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:391 / Elemento padre: 387   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(391)).setAttribute("nombre","indPasaAdmiWidgetTrId" );
      ((Element)v.get(387)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("align","left" );
      ((Element)v.get(392)).setAttribute("nowrap","true" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(393)).setAttribute("nombre","indPasaAdmi" );
      ((Element)v.get(393)).setAttribute("tipo","H" );
      ((Element)v.get(393)).setAttribute("req","N" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(393)).setAttribute("id","datosCampos" );
      ((Element)v.get(393)).setAttribute("valor","" );
      ((Element)v.get(393)).setAttribute("disabled","" );
      ((Element)v.get(393)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',15, true)" );
      ((Element)v.get(393)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',15, false)" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(394)).setAttribute("id","datosCampos" );
      ((Element)v.get(394)).setAttribute("valor","1" );
      ((Element)v.get(394)).setAttribute("cod","CobAccioCobra.indPasaAdmi.1.label" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Elemento padre:394 / Elemento actual: 395   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(394)).appendChild((Text)v.get(395));

      /* Termina nodo Texto:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(396)).setAttribute("id","datosCampos" );
      ((Element)v.get(396)).setAttribute("valor","0" );
      ((Element)v.get(396)).setAttribute("cod","CobAccioCobra.indPasaAdmi.0.label" );
      ((Element)v.get(393)).appendChild((Element)v.get(396));

      /* Elemento padre:396 / Elemento actual: 397   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(396)).appendChild((Text)v.get(397));

      /* Termina nodo Texto:397   */
      /* Termina nodo:396   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:398 / Elemento padre: 385   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("nombre","indPasaAdmiGapTdId" );
      ((Element)v.get(398)).setAttribute("nowrap","true" );
      ((Element)v.get(398)).setAttribute("class","datosCampos" );
      ((Element)v.get(385)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","25" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 385   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(400)).setAttribute("width","100%" );
      ((Element)v.get(385)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:380   */

      /* Empieza nodo:402 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(402)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(403)).setAttribute("align","center" );
      ((Element)v.get(403)).setAttribute("width","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","12" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 402   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","8" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 402   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(407)).setAttribute("align","center" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","12" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:402   */

      /* Empieza nodo:409 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(409)).setAttribute("nombre","formTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("align","center" );
      ((Element)v.get(410)).setAttribute("width","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","8" );
      ((Element)v.get(411)).setAttribute("height","12" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("width","100%" );
      ((Element)v.get(409)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(413)).setAttribute("border","0" );
      ((Element)v.get(413)).setAttribute("cellspacing","0" );
      ((Element)v.get(413)).setAttribute("cellpadding","0" );
      ((Element)v.get(413)).setAttribute("align","left" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(414)).setAttribute("align","left" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(415)).setAttribute("nombre","indPetiBloqAdmiTdId" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(416)).setAttribute("width","100%" );
      ((Element)v.get(416)).setAttribute("border","0" );
      ((Element)v.get(416)).setAttribute("cellspacing","0" );
      ((Element)v.get(416)).setAttribute("cellpadding","0" );
      ((Element)v.get(416)).setAttribute("align","left" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).setAttribute("valign","top" );
      ((Element)v.get(418)).setAttribute("height","13" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(419)).setAttribute("nombre","lblIndPetiBloqAdmi" );
      ((Element)v.get(419)).setAttribute("alto","13" );
      ((Element)v.get(419)).setAttribute("filas","1" );
      ((Element)v.get(419)).setAttribute("id","datosTitle" );
      ((Element)v.get(419)).setAttribute("cod","CobAccioCobra.indPetiBloqAdmi.label" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:420 / Elemento padre: 416   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(420)).setAttribute("nombre","indPetiBloqAdmiWidgetTrId" );
      ((Element)v.get(416)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).setAttribute("align","left" );
      ((Element)v.get(421)).setAttribute("nowrap","true" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(422)).setAttribute("nombre","indPetiBloqAdmi" );
      ((Element)v.get(422)).setAttribute("tipo","H" );
      ((Element)v.get(422)).setAttribute("req","N" );
      ((Element)v.get(422)).setAttribute("id","datosCampos" );
      ((Element)v.get(422)).setAttribute("valor","" );
      ((Element)v.get(422)).setAttribute("disabled","" );
      ((Element)v.get(422)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',16, true)" );
      ((Element)v.get(422)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',16, false)" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(423)).setAttribute("id","datosCampos" );
      ((Element)v.get(423)).setAttribute("valor","1" );
      ((Element)v.get(423)).setAttribute("cod","CobAccioCobra.indPetiBloqAdmi.1.label" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Elemento padre:423 / Elemento actual: 424   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(423)).appendChild((Text)v.get(424));

      /* Termina nodo Texto:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 422   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(425)).setAttribute("id","datosCampos" );
      ((Element)v.get(425)).setAttribute("valor","0" );
      ((Element)v.get(425)).setAttribute("cod","CobAccioCobra.indPetiBloqAdmi.0.label" );
      ((Element)v.get(422)).appendChild((Element)v.get(425));

      /* Elemento padre:425 / Elemento actual: 426   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(425)).appendChild((Text)v.get(426));

      /* Termina nodo Texto:426   */
      /* Termina nodo:425   */
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:427 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(427)).setAttribute("nombre","indPetiBloqAdmiGapTdId" );
      ((Element)v.get(427)).setAttribute("nowrap","true" );
      ((Element)v.get(427)).setAttribute("class","datosCampos" );
      ((Element)v.get(414)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","25" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("width","100%" );
      ((Element)v.get(414)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:409   */

      /* Empieza nodo:431 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(431)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(432)).setAttribute("align","center" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","12" );
      ((Element)v.get(433)).setAttribute("height","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(436)).setAttribute("align","center" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(436)).setAttribute("width","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","12" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:431   */

      /* Empieza nodo:438 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(438)).setAttribute("nombre","formTr14" );
      ((Element)v.get(15)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(439)).setAttribute("align","center" );
      ((Element)v.get(439)).setAttribute("width","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","8" );
      ((Element)v.get(440)).setAttribute("height","12" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("width","100%" );
      ((Element)v.get(438)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(442)).setAttribute("width","100%" );
      ((Element)v.get(442)).setAttribute("border","0" );
      ((Element)v.get(442)).setAttribute("cellspacing","0" );
      ((Element)v.get(442)).setAttribute("cellpadding","0" );
      ((Element)v.get(442)).setAttribute("align","left" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(443)).setAttribute("align","left" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("nombre","indPetiDesbAdmiTdId" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(445)).setAttribute("width","100%" );
      ((Element)v.get(445)).setAttribute("border","0" );
      ((Element)v.get(445)).setAttribute("cellspacing","0" );
      ((Element)v.get(445)).setAttribute("cellpadding","0" );
      ((Element)v.get(445)).setAttribute("align","left" );
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
      ((Element)v.get(448)).setAttribute("nombre","lblIndPetiDesbAdmi" );
      ((Element)v.get(448)).setAttribute("alto","13" );
      ((Element)v.get(448)).setAttribute("filas","1" );
      ((Element)v.get(448)).setAttribute("id","datosTitle" );
      ((Element)v.get(448)).setAttribute("cod","CobAccioCobra.indPetiDesbAdmi.label" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:449 / Elemento padre: 445   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(449)).setAttribute("nombre","indPetiDesbAdmiWidgetTrId" );
      ((Element)v.get(445)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).setAttribute("align","left" );
      ((Element)v.get(450)).setAttribute("nowrap","true" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(451)).setAttribute("nombre","indPetiDesbAdmi" );
      ((Element)v.get(451)).setAttribute("tipo","H" );
      ((Element)v.get(451)).setAttribute("req","N" );
      ((Element)v.get(451)).setAttribute("id","datosCampos" );
      ((Element)v.get(451)).setAttribute("valor","" );
      ((Element)v.get(451)).setAttribute("disabled","" );
      ((Element)v.get(451)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',17, true)" );
      ((Element)v.get(451)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',17, false)" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(452)).setAttribute("id","datosCampos" );
      ((Element)v.get(452)).setAttribute("valor","1" );
      ((Element)v.get(452)).setAttribute("cod","CobAccioCobra.indPetiDesbAdmi.1.label" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Elemento padre:452 / Elemento actual: 453   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(452)).appendChild((Text)v.get(453));

      /* Termina nodo Texto:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 451   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(454)).setAttribute("id","datosCampos" );
      ((Element)v.get(454)).setAttribute("valor","0" );
      ((Element)v.get(454)).setAttribute("cod","CobAccioCobra.indPetiDesbAdmi.0.label" );
      ((Element)v.get(451)).appendChild((Element)v.get(454));

      /* Elemento padre:454 / Elemento actual: 455   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(454)).appendChild((Text)v.get(455));

      /* Termina nodo Texto:455   */
      /* Termina nodo:454   */
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:456 / Elemento padre: 443   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(456)).setAttribute("nombre","indPetiDesbAdmiGapTdId" );
      ((Element)v.get(456)).setAttribute("nowrap","true" );
      ((Element)v.get(456)).setAttribute("class","datosCampos" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(443)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","25" );
      ((Element)v.get(457)).setAttribute("height","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 443   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(458)).setAttribute("width","100%" );
      ((Element)v.get(443)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:438   */

      /* Empieza nodo:460 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(460)).setAttribute("nombre","formGapTr14" );
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
      ((Element)v.get(467)).setAttribute("nombre","formTr15" );
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
      ((Element)v.get(473)).setAttribute("nombre","indAcciMensRecoTdId" );
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
      ((Element)v.get(477)).setAttribute("nombre","lblIndAcciMensReco" );
      ((Element)v.get(477)).setAttribute("alto","13" );
      ((Element)v.get(477)).setAttribute("filas","1" );
      ((Element)v.get(477)).setAttribute("id","datosTitle" );
      ((Element)v.get(477)).setAttribute("cod","CobAccioCobra.indAcciMensReco.label" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:478 / Elemento padre: 474   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(478)).setAttribute("nombre","indAcciMensRecoWidgetTrId" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(474)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("align","left" );
      ((Element)v.get(479)).setAttribute("nowrap","true" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(480)).setAttribute("nombre","indAcciMensReco" );
      ((Element)v.get(480)).setAttribute("tipo","H" );
      ((Element)v.get(480)).setAttribute("req","N" );
      ((Element)v.get(480)).setAttribute("id","datosCampos" );
      ((Element)v.get(480)).setAttribute("valor","" );
      ((Element)v.get(480)).setAttribute("disabled","" );
      ((Element)v.get(480)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',18, true)" );
      ((Element)v.get(480)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',18, false)" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(481)).setAttribute("id","datosCampos" );
      ((Element)v.get(481)).setAttribute("valor","1" );
      ((Element)v.get(481)).setAttribute("cod","CobAccioCobra.indAcciMensReco.1.label" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Elemento padre:481 / Elemento actual: 482   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(481)).appendChild((Text)v.get(482));

      /* Termina nodo Texto:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 480   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(483)).setAttribute("id","datosCampos" );
      ((Element)v.get(483)).setAttribute("valor","0" );
      ((Element)v.get(483)).setAttribute("cod","CobAccioCobra.indAcciMensReco.0.label" );
      ((Element)v.get(480)).appendChild((Element)v.get(483));

      /* Elemento padre:483 / Elemento actual: 484   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(483)).appendChild((Text)v.get(484));

      /* Termina nodo Texto:484   */
      /* Termina nodo:483   */
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:485 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(485)).setAttribute("nombre","indAcciMensRecoGapTdId" );
      ((Element)v.get(485)).setAttribute("nowrap","true" );
      ((Element)v.get(485)).setAttribute("class","datosCampos" );
      ((Element)v.get(472)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(486)).setAttribute("src","b.gif" );
      ((Element)v.get(486)).setAttribute("width","25" );
      ((Element)v.get(486)).setAttribute("height","8" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:487 / Elemento padre: 472   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(487)).setAttribute("width","100%" );
      ((Element)v.get(472)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:467   */

      /* Empieza nodo:489 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(489)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(15)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(490)).setAttribute("align","center" );
      ((Element)v.get(490)).setAttribute("width","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","12" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 489   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(489)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(493)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).setAttribute("width","8" );
      ((Element)v.get(493)).setAttribute("height","8" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 489   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("align","center" );
      ((Element)v.get(494)).setAttribute("width","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","12" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:489   */

      /* Empieza nodo:496 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(496)).setAttribute("nombre","formTr16" );
      ((Element)v.get(15)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("align","center" );
      ((Element)v.get(497)).setAttribute("width","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","8" );
      ((Element)v.get(498)).setAttribute("height","12" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 496   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).setAttribute("width","100%" );
      ((Element)v.get(496)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(500)).setAttribute("width","100%" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(500)).setAttribute("border","0" );
      ((Element)v.get(500)).setAttribute("cellspacing","0" );
      ((Element)v.get(500)).setAttribute("cellpadding","0" );
      ((Element)v.get(500)).setAttribute("align","left" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(501)).setAttribute("align","left" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("nombre","indObseTdId" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(503)).setAttribute("width","100%" );
      ((Element)v.get(503)).setAttribute("border","0" );
      ((Element)v.get(503)).setAttribute("cellspacing","0" );
      ((Element)v.get(503)).setAttribute("cellpadding","0" );
      ((Element)v.get(503)).setAttribute("align","left" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(505)).setAttribute("valign","top" );
      ((Element)v.get(505)).setAttribute("height","13" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(506)).setAttribute("nombre","lblIndObse" );
      ((Element)v.get(506)).setAttribute("alto","13" );
      ((Element)v.get(506)).setAttribute("filas","1" );
      ((Element)v.get(506)).setAttribute("id","datosTitle" );
      ((Element)v.get(506)).setAttribute("cod","CobAccioCobra.indObse.label" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:507 / Elemento padre: 503   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(507)).setAttribute("nombre","indObseWidgetTrId" );
      ((Element)v.get(503)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(508)).setAttribute("align","left" );
      ((Element)v.get(508)).setAttribute("nowrap","true" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(509)).setAttribute("nombre","indObse" );
      ((Element)v.get(509)).setAttribute("tipo","H" );
      ((Element)v.get(509)).setAttribute("req","N" );
      ((Element)v.get(509)).setAttribute("id","datosCampos" );
      ((Element)v.get(509)).setAttribute("valor","" );
      ((Element)v.get(509)).setAttribute("disabled","" );
      ((Element)v.get(509)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',19, true)" );
      ((Element)v.get(509)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',19, false)" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(510)).setAttribute("id","datosCampos" );
      ((Element)v.get(510)).setAttribute("valor","1" );
      ((Element)v.get(510)).setAttribute("cod","CobAccioCobra.indObse.1.label" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Elemento padre:510 / Elemento actual: 511   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(510)).appendChild((Text)v.get(511));

      /* Termina nodo Texto:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 509   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(512)).setAttribute("id","datosCampos" );
      ((Element)v.get(512)).setAttribute("valor","0" );
      ((Element)v.get(512)).setAttribute("cod","CobAccioCobra.indObse.0.label" );
      ((Element)v.get(509)).appendChild((Element)v.get(512));

      /* Elemento padre:512 / Elemento actual: 513   */
      v.add(doc.createTextNode("x"));
      ((Element)v.get(512)).appendChild((Text)v.get(513));

      /* Termina nodo Texto:513   */
      /* Termina nodo:512   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:514 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("nombre","indObseGapTdId" );
      ((Element)v.get(514)).setAttribute("nowrap","true" );
      ((Element)v.get(514)).setAttribute("class","datosCampos" );
      ((Element)v.get(501)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","25" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(516)).setAttribute("width","100%" );
      ((Element)v.get(501)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:496   */

      /* Empieza nodo:518 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(518)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(15)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(519)).setAttribute("align","center" );
      ((Element)v.get(519)).setAttribute("width","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","12" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:521 / Elemento padre: 518   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(518)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(522)).setAttribute("src","b.gif" );
      ((Element)v.get(522)).setAttribute("width","8" );
      ((Element)v.get(522)).setAttribute("height","8" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:523 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(523)).setAttribute("align","center" );
      ((Element)v.get(523)).setAttribute("width","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).setAttribute("width","12" );
      ((Element)v.get(524)).setAttribute("height","8" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:518   */

      /* Empieza nodo:525 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(525)).setAttribute("nombre","formTr17" );
      ((Element)v.get(15)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(526)).setAttribute("align","center" );
      ((Element)v.get(526)).setAttribute("width","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","8" );
      ((Element)v.get(527)).setAttribute("height","12" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(525)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(529)).setAttribute("width","100%" );
      ((Element)v.get(529)).setAttribute("border","0" );
      ((Element)v.get(529)).setAttribute("cellspacing","0" );
      ((Element)v.get(529)).setAttribute("cellpadding","0" );
      ((Element)v.get(529)).setAttribute("align","left" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(530)).setAttribute("align","left" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(531)).setAttribute("nombre","valObseTdId" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(532)).setAttribute("width","100%" );
      ((Element)v.get(532)).setAttribute("border","0" );
      ((Element)v.get(532)).setAttribute("cellspacing","0" );
      ((Element)v.get(532)).setAttribute("cellpadding","0" );
      ((Element)v.get(532)).setAttribute("align","left" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(534)).setAttribute("valign","top" );
      ((Element)v.get(534)).setAttribute("height","13" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(535)).setAttribute("nombre","lblValObse" );
      ((Element)v.get(535)).setAttribute("alto","13" );
      ((Element)v.get(535)).setAttribute("filas","1" );
      ((Element)v.get(535)).setAttribute("id","datosTitle" );
      ((Element)v.get(535)).setAttribute("cod","CobAccioCobra.valObse.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:536 / Elemento padre: 532   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(536)).setAttribute("nombre","valObseWidgetTrId" );
      ((Element)v.get(532)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("align","left" );
      ((Element)v.get(537)).setAttribute("nowrap","true" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(538)).setAttribute("nombre","valObse" );
      ((Element)v.get(538)).setAttribute("id","datosCampos" );
      ((Element)v.get(538)).setAttribute("trim","S" );
      ((Element)v.get(538)).setAttribute("max","100" );
      ((Element)v.get(538)).setAttribute("onchange","" );
      ((Element)v.get(538)).setAttribute("req","N" );
      ((Element)v.get(538)).setAttribute("size","100" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(538)).setAttribute("validacion","" );
      ((Element)v.get(538)).setAttribute("disabled","" );
      ((Element)v.get(538)).setAttribute("onblur","" );
      ((Element)v.get(538)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',20, true)" );
      ((Element)v.get(538)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm', 20, false)" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:539 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(539)).setAttribute("nombre","valObseGapTdId" );
      ((Element)v.get(539)).setAttribute("nowrap","true" );
      ((Element)v.get(539)).setAttribute("class","datosCampos" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(530)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","25" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(530)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:525   */

      /* Empieza nodo:543 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(543)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(15)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("align","center" );
      ((Element)v.get(544)).setAttribute("width","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","12" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(543)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","8" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(548)).setAttribute("align","center" );
      ((Element)v.get(548)).setAttribute("width","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","12" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:543   */

      /* Empieza nodo:550 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(550)).setAttribute("nombre","formTr18" );
      ((Element)v.get(15)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("align","center" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","12" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(553)).setAttribute("width","100%" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(554)).setAttribute("width","100%" );
      ((Element)v.get(554)).setAttribute("border","0" );
      ((Element)v.get(554)).setAttribute("cellspacing","0" );
      ((Element)v.get(554)).setAttribute("cellpadding","0" );
      ((Element)v.get(554)).setAttribute("align","left" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(555)).setAttribute("align","left" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(556)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(557)).setAttribute("border","0" );
      ((Element)v.get(557)).setAttribute("cellspacing","0" );
      ((Element)v.get(557)).setAttribute("cellpadding","0" );
      ((Element)v.get(557)).setAttribute("align","left" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(559)).setAttribute("valign","top" );
      ((Element)v.get(559)).setAttribute("height","13" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(560)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(560)).setAttribute("id","datosTitle" );
      ((Element)v.get(560)).setAttribute("ancho","150" );
      ((Element)v.get(560)).setAttribute("alto","13" );
      ((Element)v.get(560)).setAttribute("cod","CobAccioCobra.paisOidPais.label" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:561 / Elemento padre: 557   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(561)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(557)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).setAttribute("align","left" );
      ((Element)v.get(562)).setAttribute("nowrap","true" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(563)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(563)).setAttribute("id","datosCampos" );
      ((Element)v.get(563)).setAttribute("multiple","N" );
      ((Element)v.get(563)).setAttribute("req","N" );
      ((Element)v.get(563)).setAttribute("size","1" );
      ((Element)v.get(563)).setAttribute("disabled","" );
      ((Element)v.get(563)).setAttribute("validacion","" );
      ((Element)v.get(563)).setAttribute("onchange","" );
      ((Element)v.get(563)).setAttribute("onfocus","" );
      ((Element)v.get(563)).setAttribute("valorinicial","" );
      ((Element)v.get(563)).setAttribute("textoinicial","" );
      ((Element)v.get(563)).setAttribute("ontab","ejecutarAccionFoco('cobAccioCobraFrm',21, true);" );
      ((Element)v.get(563)).setAttribute("onshtab","ejecutarAccionFoco('cobAccioCobraFrm',21, false);" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:565 / Elemento padre: 555   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(565)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(565)).setAttribute("nowrap","true" );
      ((Element)v.get(565)).setAttribute("class","datosCampos" );
      ((Element)v.get(555)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","25" );
      ((Element)v.get(566)).setAttribute("height","8" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 555   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(567)).setAttribute("width","100%" );
      ((Element)v.get(555)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:569 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("width","100%" );
      ((Element)v.get(550)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:550   */

      /* Empieza nodo:570 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(570)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(15)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(571)).setAttribute("align","center" );
      ((Element)v.get(571)).setAttribute("width","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","8" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 570   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(570)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(574)).setAttribute("width","8" );
      ((Element)v.get(574)).setAttribute("height","8" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:575 / Elemento padre: 570   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(575)).setAttribute("align","center" );
      ((Element)v.get(575)).setAttribute("width","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:570   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:577 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(577)).setAttribute("align","center" );
      ((Element)v.get(577)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(578)).setAttribute("src","b.gif" );
      ((Element)v.get(578)).setAttribute("width","12" );
      ((Element)v.get(578)).setAttribute("height","12" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:8   */

      /* Empieza nodo:579 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(579)).setAttribute("nombre","cobAccioCobraTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(580)).setAttribute("align","center" );
      ((Element)v.get(580)).setAttribute("width","12" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","12" );
      ((Element)v.get(581)).setAttribute("height","12" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */

      /* Empieza nodo:582 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(579)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(584)).setAttribute("width","100%" );
      ((Element)v.get(584)).setAttribute("border","0" );
      ((Element)v.get(584)).setAttribute("align","center" );
      ((Element)v.get(584)).setAttribute("cellspacing","0" );
      ((Element)v.get(584)).setAttribute("cellpadding","0" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(586)).setAttribute("class","tablaTitle" );
      ((Element)v.get(586)).setAttribute("nombre","cobAccioCobraTdQueryButton" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(587)).setAttribute("nombre","cobAccioCobraQueryButton" );
      ((Element)v.get(587)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(587)).setAttribute("estado","false" );
      ((Element)v.get(587)).setAttribute("accion","cobAccioCobraFirstPage();" );
      ((Element)v.get(587)).setAttribute("tipo","html" );
      ((Element)v.get(587)).setAttribute("ID","botonContenido" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 585   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(588)).setAttribute("class","tablaTitle" );
      ((Element)v.get(588)).setAttribute("nombre","cobAccioCobraTdLovNullSelectionButton" );
      ((Element)v.get(588)).setAttribute("align","left" );
      ((Element)v.get(588)).setAttribute("width","100%" );
      ((Element)v.get(585)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(589)).setAttribute("width","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */

      /* Empieza nodo:590 / Elemento padre: 588   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(590)).setAttribute("nombre","cobAccioCobraLovNullButton" );
      ((Element)v.get(590)).setAttribute("ID","botonContenido" );
      ((Element)v.get(590)).setAttribute("tipo","html" );
      ((Element)v.get(590)).setAttribute("accion","cobAccioCobraLovNullSelectionAction();" );
      ((Element)v.get(590)).setAttribute("estado","true" );
      ((Element)v.get(590)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(588)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:588   */
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:591 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("align","center" );
      ((Element)v.get(591)).setAttribute("width","12" );
      ((Element)v.get(579)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","12" );
      ((Element)v.get(592)).setAttribute("height","12" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:579   */


   }

}
