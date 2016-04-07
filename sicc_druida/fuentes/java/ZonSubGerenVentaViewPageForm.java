
import org.w3c.dom.*;
import java.util.ArrayList;

public class ZonSubGerenVentaViewPageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","ZonSubGerenVentaView.legend.label" );
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
      ((Element)v.get(29)).setAttribute("cod","ZonSubGerenVentaView.id.label" );
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
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
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
      ((Element)v.get(50)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(54)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("ancho","150" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("cod","ZonSubGerenVentaView.paisOidPais.label" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(55)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("nowrap","true" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(57)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("multiple","N" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("size","1" );
      ((Element)v.get(57)).setAttribute("disabled","" );
      ((Element)v.get(57)).setAttribute("validacion","" );
      ((Element)v.get(57)).setAttribute("onchange","" );
      ((Element)v.get(57)).setAttribute("onfocus","" );
      ((Element)v.get(57)).setAttribute("valorinicial","" );
      ((Element)v.get(57)).setAttribute("textoinicial","" );
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true);" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, false);" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:59 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(59)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(59)).setAttribute("nowrap","true" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(59)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */

      /* Empieza nodo:63 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(63)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","12" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:63   */

      /* Empieza nodo:70 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(70)).setAttribute("nombre","formTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).setAttribute("align","left" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(75)).setAttribute("align","left" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(76)).setAttribute("nombre","codSubgVentTdId" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(77)).setAttribute("border","0" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).setAttribute("align","left" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("valign","top" );
      ((Element)v.get(79)).setAttribute("height","13" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblCodSubgVent" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","ZonSubGerenVentaView.codSubgVent.label" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 77   */
      v.add(doc.createElement("TR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("nombre","codSubgVentWidgetTrId" );
      ((Element)v.get(77)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(82)).setAttribute("align","left" );
      ((Element)v.get(82)).setAttribute("nowrap","true" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(83)).setAttribute("nombre","codSubgVent" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("trim","S" );
      ((Element)v.get(83)).setAttribute("max","2" );
      ((Element)v.get(83)).setAttribute("onchange","" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("size","2" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("validacion","" );
      ((Element)v.get(83)).setAttribute("disabled","" );
      ((Element)v.get(83)).setAttribute("onblur","" );
      ((Element)v.get(83)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(83)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:84 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("nombre","codSubgVentGapTdId" );
      ((Element)v.get(84)).setAttribute("nowrap","true" );
      ((Element)v.get(84)).setAttribute("class","datosCampos" );
      ((Element)v.get(75)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(75)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:70   */

      /* Empieza nodo:88 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(88)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("height","8" );
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
      ((Element)v.get(93)).setAttribute("align","center" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:88   */

      /* Empieza nodo:95 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(95)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","12" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(99)).setAttribute("align","left" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).setAttribute("align","left" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).setAttribute("nombre","indBorrTdId" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(102)).setAttribute("border","0" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).setAttribute("align","left" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("valign","top" );
      ((Element)v.get(104)).setAttribute("height","13" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblIndBorr" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("id","datosTitle" );
      ((Element)v.get(105)).setAttribute("cod","ZonSubGerenVentaView.indBorr.label" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:106 / Elemento padre: 102   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(106)).setAttribute("nombre","indBorrWidgetTrId" );
      ((Element)v.get(102)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("align","left" );
      ((Element)v.get(107)).setAttribute("nowrap","true" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(108)).setAttribute("nombre","indBorr" );
      ((Element)v.get(108)).setAttribute("id","datosCampos" );
      ((Element)v.get(108)).setAttribute("trim","S" );
      ((Element)v.get(108)).setAttribute("max","1" );
      ((Element)v.get(108)).setAttribute("onchange","" );
      ((Element)v.get(108)).setAttribute("req","N" );
      ((Element)v.get(108)).setAttribute("size","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("validacion","" );
      ((Element)v.get(108)).setAttribute("disabled","" );
      ((Element)v.get(108)).setAttribute("onblur","" );
      ((Element)v.get(108)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(108)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("nombre","indBorrGapTdId" );
      ((Element)v.get(109)).setAttribute("nowrap","true" );
      ((Element)v.get(109)).setAttribute("class","datosCampos" );
      ((Element)v.get(100)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:95   */

      /* Empieza nodo:113 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(113)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:113   */

      /* Empieza nodo:120 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","12" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).setAttribute("align","left" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("nombre","indActiTdId" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(127)).setAttribute("align","left" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).setAttribute("valign","top" );
      ((Element)v.get(129)).setAttribute("height","13" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblIndActi" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","ZonSubGerenVentaView.indActi.label" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 127   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(131)).setAttribute("nombre","indActiWidgetTrId" );
      ((Element)v.get(127)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("align","left" );
      ((Element)v.get(132)).setAttribute("nowrap","true" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(133)).setAttribute("nombre","indActi" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("trim","S" );
      ((Element)v.get(133)).setAttribute("max","1" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("req","N" );
      ((Element)v.get(133)).setAttribute("size","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("validacion","" );
      ((Element)v.get(133)).setAttribute("disabled","" );
      ((Element)v.get(133)).setAttribute("onblur","" );
      ((Element)v.get(133)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(133)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:134 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("nombre","indActiGapTdId" );
      ((Element)v.get(134)).setAttribute("nowrap","true" );
      ((Element)v.get(134)).setAttribute("class","datosCampos" );
      ((Element)v.get(125)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(125)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:120   */

      /* Empieza nodo:138 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(138)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("align","center" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:138   */

      /* Empieza nodo:145 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(145)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","12" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).setAttribute("align","left" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(150)).setAttribute("align","left" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("nombre","codNse1TdId" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

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
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("valign","top" );
      ((Element)v.get(154)).setAttribute("height","13" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblCodNse1" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("id","datosTitle" );
      ((Element)v.get(155)).setAttribute("cod","ZonSubGerenVentaView.codNse1.label" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:156 / Elemento padre: 152   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(156)).setAttribute("nombre","codNse1WidgetTrId" );
      ((Element)v.get(152)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("align","left" );
      ((Element)v.get(157)).setAttribute("nowrap","true" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(158)).setAttribute("nombre","codNse1" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("trim","S" );
      ((Element)v.get(158)).setAttribute("max","2" );
      ((Element)v.get(158)).setAttribute("onchange","" );
      ((Element)v.get(158)).setAttribute("req","N" );
      ((Element)v.get(158)).setAttribute("size","2" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("validacion","" );
      ((Element)v.get(158)).setAttribute("disabled","" );
      ((Element)v.get(158)).setAttribute("onblur","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(158)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(158)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("nombre","codNse1GapTdId" );
      ((Element)v.get(159)).setAttribute("nowrap","true" );
      ((Element)v.get(159)).setAttribute("class","datosCampos" );
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:145   */

      /* Empieza nodo:163 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(163)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("align","center" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:163   */

      /* Empieza nodo:170 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(170)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("align","center" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","12" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(174)).setAttribute("align","left" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(175)).setAttribute("align","left" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("nombre","codNse2TdId" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(177)).setAttribute("border","0" );
      ((Element)v.get(177)).setAttribute("cellspacing","0" );
      ((Element)v.get(177)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).setAttribute("align","left" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("valign","top" );
      ((Element)v.get(179)).setAttribute("height","13" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblCodNse2" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","ZonSubGerenVentaView.codNse2.label" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(181)).setAttribute("nombre","codNse2WidgetTrId" );
      ((Element)v.get(177)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("align","left" );
      ((Element)v.get(182)).setAttribute("nowrap","true" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(183)).setAttribute("nombre","codNse2" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("trim","S" );
      ((Element)v.get(183)).setAttribute("max","2" );
      ((Element)v.get(183)).setAttribute("onchange","" );
      ((Element)v.get(183)).setAttribute("req","N" );
      ((Element)v.get(183)).setAttribute("size","2" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("validacion","" );
      ((Element)v.get(183)).setAttribute("disabled","" );
      ((Element)v.get(183)).setAttribute("onblur","" );
      ((Element)v.get(183)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(183)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:184 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("nombre","codNse2GapTdId" );
      ((Element)v.get(184)).setAttribute("nowrap","true" );
      ((Element)v.get(184)).setAttribute("class","datosCampos" );
      ((Element)v.get(175)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:170   */

      /* Empieza nodo:188 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(188)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("align","center" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","12" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("align","center" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","12" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:188   */

      /* Empieza nodo:195 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(195)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).setAttribute("align","center" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","12" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(199)).setAttribute("border","0" );
      ((Element)v.get(199)).setAttribute("cellspacing","0" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(199)).setAttribute("cellpadding","0" );
      ((Element)v.get(199)).setAttribute("align","left" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(200)).setAttribute("align","left" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("nombre","codNse3TdId" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(202)).setAttribute("border","0" );
      ((Element)v.get(202)).setAttribute("cellspacing","0" );
      ((Element)v.get(202)).setAttribute("cellpadding","0" );
      ((Element)v.get(202)).setAttribute("align","left" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("valign","top" );
      ((Element)v.get(204)).setAttribute("height","13" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(205)).setAttribute("nombre","lblCodNse3" );
      ((Element)v.get(205)).setAttribute("alto","13" );
      ((Element)v.get(205)).setAttribute("filas","1" );
      ((Element)v.get(205)).setAttribute("id","datosTitle" );
      ((Element)v.get(205)).setAttribute("cod","ZonSubGerenVentaView.codNse3.label" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:206 / Elemento padre: 202   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(206)).setAttribute("nombre","codNse3WidgetTrId" );
      ((Element)v.get(202)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("align","left" );
      ((Element)v.get(207)).setAttribute("nowrap","true" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(208)).setAttribute("nombre","codNse3" );
      ((Element)v.get(208)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).setAttribute("trim","S" );
      ((Element)v.get(208)).setAttribute("max","2" );
      ((Element)v.get(208)).setAttribute("onchange","" );
      ((Element)v.get(208)).setAttribute("req","N" );
      ((Element)v.get(208)).setAttribute("size","2" );
      ((Element)v.get(208)).setAttribute("valor","" );
      ((Element)v.get(208)).setAttribute("validacion","" );
      ((Element)v.get(208)).setAttribute("disabled","" );
      ((Element)v.get(208)).setAttribute("onblur","" );
      ((Element)v.get(208)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(208)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:209 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("nombre","codNse3GapTdId" );
      ((Element)v.get(209)).setAttribute("nowrap","true" );
      ((Element)v.get(209)).setAttribute("class","datosCampos" );
      ((Element)v.get(200)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","25" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(200)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:195   */

      /* Empieza nodo:213 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(213)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(214)).setAttribute("align","center" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","12" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 213   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("align","center" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","12" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:213   */

      /* Empieza nodo:220 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(220)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("align","center" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","12" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(224)).setAttribute("border","0" );
      ((Element)v.get(224)).setAttribute("cellspacing","0" );
      ((Element)v.get(224)).setAttribute("cellpadding","0" );
      ((Element)v.get(224)).setAttribute("align","left" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(225)).setAttribute("align","left" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("nombre","desSubgVentTdId" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(227)).setAttribute("width","100%" );
      ((Element)v.get(227)).setAttribute("border","0" );
      ((Element)v.get(227)).setAttribute("cellspacing","0" );
      ((Element)v.get(227)).setAttribute("cellpadding","0" );
      ((Element)v.get(227)).setAttribute("align","left" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("valign","top" );
      ((Element)v.get(229)).setAttribute("height","13" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(230)).setAttribute("nombre","lblDesSubgVent" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","ZonSubGerenVentaView.desSubgVent.label" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:231 / Elemento padre: 227   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(231)).setAttribute("nombre","desSubgVentWidgetTrId" );
      ((Element)v.get(227)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("align","left" );
      ((Element)v.get(232)).setAttribute("nowrap","true" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(233)).setAttribute("nombre","desSubgVent" );
      ((Element)v.get(233)).setAttribute("id","datosCampos" );
      ((Element)v.get(233)).setAttribute("trim","S" );
      ((Element)v.get(233)).setAttribute("max","40" );
      ((Element)v.get(233)).setAttribute("onchange","" );
      ((Element)v.get(233)).setAttribute("req","N" );
      ((Element)v.get(233)).setAttribute("size","40" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(233)).setAttribute("validacion","" );
      ((Element)v.get(233)).setAttribute("disabled","" );
      ((Element)v.get(233)).setAttribute("onblur","" );
      ((Element)v.get(233)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true)" );
      ((Element)v.get(233)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm', 0, false)" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:234 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("nombre","desSubgVentGapTdId" );
      ((Element)v.get(234)).setAttribute("nowrap","true" );
      ((Element)v.get(234)).setAttribute("class","datosCampos" );
      ((Element)v.get(225)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","25" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(225)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:220   */

      /* Empieza nodo:238 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(238)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("align","center" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","12" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("align","center" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","12" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:238   */

      /* Empieza nodo:245 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(245)).setAttribute("nombre","formTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("align","center" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","12" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(249)).setAttribute("border","0" );
      ((Element)v.get(249)).setAttribute("cellspacing","0" );
      ((Element)v.get(249)).setAttribute("cellpadding","0" );
      ((Element)v.get(249)).setAttribute("align","left" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(250)).setAttribute("align","left" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).setAttribute("nombre","marcOidMarcTdId" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(252)).setAttribute("border","0" );
      ((Element)v.get(252)).setAttribute("cellspacing","0" );
      ((Element)v.get(252)).setAttribute("cellpadding","0" );
      ((Element)v.get(252)).setAttribute("align","left" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("valign","top" );
      ((Element)v.get(254)).setAttribute("height","13" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(255)).setAttribute("nombre","lblmarcOidMarc" );
      ((Element)v.get(255)).setAttribute("id","datosTitle" );
      ((Element)v.get(255)).setAttribute("ancho","150" );
      ((Element)v.get(255)).setAttribute("alto","13" );
      ((Element)v.get(255)).setAttribute("cod","ZonSubGerenVentaView.marcOidMarc.label" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:256 / Elemento padre: 252   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(256)).setAttribute("nombre","marcOidMarcWidgetTrId" );
      ((Element)v.get(252)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("align","left" );
      ((Element)v.get(257)).setAttribute("nowrap","true" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(258)).setAttribute("nombre","marcOidMarc" );
      ((Element)v.get(258)).setAttribute("id","datosCampos" );
      ((Element)v.get(258)).setAttribute("multiple","N" );
      ((Element)v.get(258)).setAttribute("req","N" );
      ((Element)v.get(258)).setAttribute("size","1" );
      ((Element)v.get(258)).setAttribute("disabled","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(258)).setAttribute("validacion","" );
      ((Element)v.get(258)).setAttribute("onchange","" );
      ((Element)v.get(258)).setAttribute("onfocus","" );
      ((Element)v.get(258)).setAttribute("valorinicial","" );
      ((Element)v.get(258)).setAttribute("textoinicial","" );
      ((Element)v.get(258)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true);" );
      ((Element)v.get(258)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, false);" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:260 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("nombre","marcOidMarcGapTdId" );
      ((Element)v.get(260)).setAttribute("nowrap","true" );
      ((Element)v.get(260)).setAttribute("class","datosCampos" );
      ((Element)v.get(250)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(250)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:245   */

      /* Empieza nodo:264 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(264)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(265)).setAttribute("align","center" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","12" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 264   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("align","center" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","12" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:264   */

      /* Empieza nodo:271 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(271)).setAttribute("nombre","formTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("align","center" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","12" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).setAttribute("width","100%" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(275)).setAttribute("width","100%" );
      ((Element)v.get(275)).setAttribute("border","0" );
      ((Element)v.get(275)).setAttribute("cellspacing","0" );
      ((Element)v.get(275)).setAttribute("cellpadding","0" );
      ((Element)v.get(275)).setAttribute("align","left" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(276)).setAttribute("align","left" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(277)).setAttribute("nombre","canaOidCanaTdId" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(278)).setAttribute("border","0" );
      ((Element)v.get(278)).setAttribute("cellspacing","0" );
      ((Element)v.get(278)).setAttribute("cellpadding","0" );
      ((Element)v.get(278)).setAttribute("align","left" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("valign","top" );
      ((Element)v.get(280)).setAttribute("height","13" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(281)).setAttribute("nombre","lblcanaOidCana" );
      ((Element)v.get(281)).setAttribute("id","datosTitle" );
      ((Element)v.get(281)).setAttribute("ancho","150" );
      ((Element)v.get(281)).setAttribute("alto","13" );
      ((Element)v.get(281)).setAttribute("cod","ZonSubGerenVentaView.canaOidCana.label" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:282 / Elemento padre: 278   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(282)).setAttribute("nombre","canaOidCanaWidgetTrId" );
      ((Element)v.get(278)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","left" );
      ((Element)v.get(283)).setAttribute("nowrap","true" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(284)).setAttribute("nombre","canaOidCana" );
      ((Element)v.get(284)).setAttribute("id","datosCampos" );
      ((Element)v.get(284)).setAttribute("multiple","N" );
      ((Element)v.get(284)).setAttribute("req","N" );
      ((Element)v.get(284)).setAttribute("size","1" );
      ((Element)v.get(284)).setAttribute("disabled","" );
      ((Element)v.get(284)).setAttribute("validacion","" );
      ((Element)v.get(284)).setAttribute("onchange","" );
      ((Element)v.get(284)).setAttribute("onfocus","" );
      ((Element)v.get(284)).setAttribute("valorinicial","" );
      ((Element)v.get(284)).setAttribute("textoinicial","" );
      ((Element)v.get(284)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, true);" );
      ((Element)v.get(284)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaViewFrm',0, false);" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:286 / Elemento padre: 276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(286)).setAttribute("nombre","canaOidCanaGapTdId" );
      ((Element)v.get(286)).setAttribute("nowrap","true" );
      ((Element)v.get(286)).setAttribute("class","datosCampos" );
      ((Element)v.get(276)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","25" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(276)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:290 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(271)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:271   */

      /* Empieza nodo:291 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(291)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("align","center" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).setAttribute("align","center" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:291   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:298 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("align","center" );
      ((Element)v.get(298)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","12" );
      ((Element)v.get(299)).setAttribute("height","12" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:8   */

      /* Empieza nodo:300 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","zonSubGerenVentaViewTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","center" );
      ((Element)v.get(301)).setAttribute("width","12" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","12" );
      ((Element)v.get(302)).setAttribute("height","12" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(305)).setAttribute("border","0" );
      ((Element)v.get(305)).setAttribute("align","center" );
      ((Element)v.get(305)).setAttribute("cellspacing","0" );
      ((Element)v.get(305)).setAttribute("cellpadding","0" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("class","tablaTitle" );
      ((Element)v.get(307)).setAttribute("nombre","zonSubGerenVentaViewTdQueryButton" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(308)).setAttribute("nombre","zonSubGerenVentaViewQueryButton" );
      ((Element)v.get(308)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(308)).setAttribute("estado","false" );
      ((Element)v.get(308)).setAttribute("accion","zonSubGerenVentaViewFirstPage();" );
      ((Element)v.get(308)).setAttribute("tipo","html" );
      ((Element)v.get(308)).setAttribute("ID","botonContenido" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("class","tablaTitle" );
      ((Element)v.get(309)).setAttribute("nombre","zonSubGerenVentaViewTdLovNullSelectionButton" );
      ((Element)v.get(309)).setAttribute("align","left" );
      ((Element)v.get(309)).setAttribute("width","100%" );
      ((Element)v.get(306)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 309   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","zonSubGerenVentaViewLovNullButton" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("tipo","html" );
      ((Element)v.get(311)).setAttribute("accion","zonSubGerenVentaViewLovNullSelectionAction();" );
      ((Element)v.get(311)).setAttribute("estado","true" );
      ((Element)v.get(311)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(309)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:309   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:312 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("align","center" );
      ((Element)v.get(312)).setAttribute("width","12" );
      ((Element)v.get(300)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","12" );
      ((Element)v.get(313)).setAttribute("height","12" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:300   */


   }

}
