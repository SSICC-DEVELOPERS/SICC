
import org.w3c.dom.*;
import java.util.ArrayList;

public class PedTipoSolicPaisPageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","PedTipoSolicPais.legend.label" );
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
      ((Element)v.get(29)).setAttribute("cod","PedTipoSolicPais.id.label" );
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
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',1, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 1, false)" );
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
      ((Element)v.get(54)).setAttribute("cod","PedTipoSolicPais.paisOidPais.label" );
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
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',2, true);" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',2, false);" );
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
      ((Element)v.get(61)).setAttribute("nombre","tsolOidTipoSoliTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(62)).setAttribute("border","0" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).setAttribute("align","left" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("valign","top" );
      ((Element)v.get(64)).setAttribute("height","13" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lbltsolOidTipoSoli" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("ancho","150" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("cod","PedTipoSolicPais.tsolOidTipoSoli.label" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 62   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(66)).setAttribute("nombre","tsolOidTipoSoliWidgetTrId" );
      ((Element)v.get(62)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(67)).setAttribute("align","left" );
      ((Element)v.get(67)).setAttribute("nowrap","true" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","tsolOidTipoSoli" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("req","N" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("disabled","" );
      ((Element)v.get(68)).setAttribute("validacion","" );
      ((Element)v.get(68)).setAttribute("onchange","" );
      ((Element)v.get(68)).setAttribute("onfocus","" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(68)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',3, true);" );
      ((Element)v.get(68)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',3, false);" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:70 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("nombre","tsolOidTipoSoliGapTdId" );
      ((Element)v.get(70)).setAttribute("nowrap","true" );
      ((Element)v.get(70)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */

      /* Empieza nodo:74 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(74)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","12" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:74   */

      /* Empieza nodo:81 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(81)).setAttribute("nombre","formTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","12" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(85)).setAttribute("align","left" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(86)).setAttribute("align","left" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("nombre","numSoliLoteTdId" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).setAttribute("align","left" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(90)).setAttribute("valign","top" );
      ((Element)v.get(90)).setAttribute("height","13" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblNumSoliLote" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","PedTipoSolicPais.numSoliLote.label" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","numSoliLoteWidgetTrId" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(94)).setAttribute("nombre","numSoliLote" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("trim","S" );
      ((Element)v.get(94)).setAttribute("max","3" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","3" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("disabled","" );
      ((Element)v.get(94)).setAttribute("onblur","" );
      ((Element)v.get(94)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',4, true)" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 4, false)" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:95 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("nombre","numSoliLoteGapTdId" );
      ((Element)v.get(95)).setAttribute("nowrap","true" );
      ((Element)v.get(95)).setAttribute("class","datosCampos" );
      ((Element)v.get(86)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:99 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(99)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("align","center" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:99   */

      /* Empieza nodo:106 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(106)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","12" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).setAttribute("align","left" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(111)).setAttribute("align","left" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("nombre","numUnidAlarTdId" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).setAttribute("align","left" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("valign","top" );
      ((Element)v.get(115)).setAttribute("height","13" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblNumUnidAlar" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","PedTipoSolicPais.numUnidAlar.label" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(117)).setAttribute("nombre","numUnidAlarWidgetTrId" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("nowrap","true" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(119)).setAttribute("nombre","numUnidAlar" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("trim","S" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("max","5" );
      ((Element)v.get(119)).setAttribute("onchange","" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("size","5" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("validacion","" );
      ((Element)v.get(119)).setAttribute("disabled","" );
      ((Element)v.get(119)).setAttribute("onblur","" );
      ((Element)v.get(119)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',5, true)" );
      ((Element)v.get(119)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 5, false)" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("nombre","numUnidAlarGapTdId" );
      ((Element)v.get(120)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).setAttribute("class","datosCampos" );
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:106   */

      /* Empieza nodo:124 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(124)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("align","center" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:124   */

      /* Empieza nodo:131 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(131)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","12" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(135)).setAttribute("border","0" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("cellpadding","0" );
      ((Element)v.get(135)).setAttribute("align","left" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(136)).setAttribute("align","left" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).setAttribute("align","left" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TR"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("valign","top" );
      ((Element)v.get(140)).setAttribute("height","13" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(141)).setAttribute("id","datosTitle" );
      ((Element)v.get(141)).setAttribute("ancho","150" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("cod","PedTipoSolicPais.fopaOidFormPago.label" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 138   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(142)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(138)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("align","left" );
      ((Element)v.get(143)).setAttribute("nowrap","true" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(144)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("multiple","N" );
      ((Element)v.get(144)).setAttribute("req","N" );
      ((Element)v.get(144)).setAttribute("size","1" );
      ((Element)v.get(144)).setAttribute("disabled","" );
      ((Element)v.get(144)).setAttribute("validacion","" );
      ((Element)v.get(144)).setAttribute("onchange","" );
      ((Element)v.get(144)).setAttribute("onfocus","" );
      ((Element)v.get(144)).setAttribute("valorinicial","" );
      ((Element)v.get(144)).setAttribute("textoinicial","" );
      ((Element)v.get(144)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',6, true);" );
      ((Element)v.get(144)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',6, false);" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:146 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(146)).setAttribute("nowrap","true" );
      ((Element)v.get(146)).setAttribute("class","datosCampos" );
      ((Element)v.get(136)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","25" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:131   */

      /* Empieza nodo:150 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(150)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:150   */

      /* Empieza nodo:157 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(157)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("height","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).setAttribute("align","left" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("nombre","indSujeFletTdId" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(164)).setAttribute("border","0" );
      ((Element)v.get(164)).setAttribute("cellspacing","0" );
      ((Element)v.get(164)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).setAttribute("align","left" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("valign","top" );
      ((Element)v.get(166)).setAttribute("height","13" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblIndSujeFlet" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","PedTipoSolicPais.indSujeFlet.label" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(168)).setAttribute("nombre","indSujeFletWidgetTrId" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("align","left" );
      ((Element)v.get(169)).setAttribute("nowrap","true" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(170)).setAttribute("nombre","indSujeFlet" );
      ((Element)v.get(170)).setAttribute("id","datosCampos" );
      ((Element)v.get(170)).setAttribute("trim","S" );
      ((Element)v.get(170)).setAttribute("max","1" );
      ((Element)v.get(170)).setAttribute("onchange","" );
      ((Element)v.get(170)).setAttribute("req","N" );
      ((Element)v.get(170)).setAttribute("size","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("validacion","" );
      ((Element)v.get(170)).setAttribute("disabled","" );
      ((Element)v.get(170)).setAttribute("onblur","" );
      ((Element)v.get(170)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',7, true)" );
      ((Element)v.get(170)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 7, false)" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("nombre","indSujeFletGapTdId" );
      ((Element)v.get(171)).setAttribute("nowrap","true" );
      ((Element)v.get(171)).setAttribute("class","datosCampos" );
      ((Element)v.get(162)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:157   */

      /* Empieza nodo:175 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(175)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("align","center" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","12" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:175   */

      /* Empieza nodo:182 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(182)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","12" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(186)).setAttribute("border","0" );
      ((Element)v.get(186)).setAttribute("cellspacing","0" );
      ((Element)v.get(186)).setAttribute("cellpadding","0" );
      ((Element)v.get(186)).setAttribute("align","left" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("nombre","indReseStocTdId" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(189)).setAttribute("border","0" );
      ((Element)v.get(189)).setAttribute("cellspacing","0" );
      ((Element)v.get(189)).setAttribute("cellpadding","0" );
      ((Element)v.get(189)).setAttribute("align","left" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("valign","top" );
      ((Element)v.get(191)).setAttribute("height","13" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblIndReseStoc" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","PedTipoSolicPais.indReseStoc.label" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:193 / Elemento padre: 189   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(193)).setAttribute("nombre","indReseStocWidgetTrId" );
      ((Element)v.get(189)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(194)).setAttribute("nowrap","true" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(195)).setAttribute("nombre","indReseStoc" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("trim","S" );
      ((Element)v.get(195)).setAttribute("max","1" );
      ((Element)v.get(195)).setAttribute("onchange","" );
      ((Element)v.get(195)).setAttribute("req","N" );
      ((Element)v.get(195)).setAttribute("size","1" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("validacion","" );
      ((Element)v.get(195)).setAttribute("disabled","" );
      ((Element)v.get(195)).setAttribute("onblur","" );
      ((Element)v.get(195)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',8, true)" );
      ((Element)v.get(195)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 8, false)" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:196 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).setAttribute("nombre","indReseStocGapTdId" );
      ((Element)v.get(196)).setAttribute("nowrap","true" );
      ((Element)v.get(196)).setAttribute("class","datosCampos" );
      ((Element)v.get(187)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:182   */

      /* Empieza nodo:200 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(200)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:200   */

      /* Empieza nodo:207 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(207)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).setAttribute("align","center" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","12" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(207)).appendChild((Element)v.get(210));

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
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("nombre","indPermReveTdId" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(214)).setAttribute("border","0" );
      ((Element)v.get(214)).setAttribute("cellspacing","0" );
      ((Element)v.get(214)).setAttribute("cellpadding","0" );
      ((Element)v.get(214)).setAttribute("align","left" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("valign","top" );
      ((Element)v.get(216)).setAttribute("height","13" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblIndPermReve" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","PedTipoSolicPais.indPermReve.label" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 214   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(218)).setAttribute("nombre","indPermReveWidgetTrId" );
      ((Element)v.get(214)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(219)).setAttribute("align","left" );
      ((Element)v.get(219)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(220)).setAttribute("nombre","indPermReve" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("trim","S" );
      ((Element)v.get(220)).setAttribute("max","1" );
      ((Element)v.get(220)).setAttribute("onchange","" );
      ((Element)v.get(220)).setAttribute("req","N" );
      ((Element)v.get(220)).setAttribute("size","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("validacion","" );
      ((Element)v.get(220)).setAttribute("disabled","" );
      ((Element)v.get(220)).setAttribute("onblur","" );
      ((Element)v.get(220)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',9, true)" );
      ((Element)v.get(220)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 9, false)" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("nombre","indPermReveGapTdId" );
      ((Element)v.get(221)).setAttribute("nowrap","true" );
      ((Element)v.get(221)).setAttribute("class","datosCampos" );
      ((Element)v.get(212)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(212)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:207   */

      /* Empieza nodo:225 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(225)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(226)).setAttribute("width","8" );
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
      ((Element)v.get(230)).setAttribute("width","8" );
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
      ((Element)v.get(232)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
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
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(237)).setAttribute("align","left" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("nombre","indPediPrueTdId" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
   }

   private void getXML1080(Document doc) {
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
      ((Element)v.get(242)).setAttribute("nombre","lblIndPediPrue" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","PedTipoSolicPais.indPediPrue.label" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 239   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(243)).setAttribute("nombre","indPediPrueWidgetTrId" );
      ((Element)v.get(239)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("align","left" );
      ((Element)v.get(244)).setAttribute("nowrap","true" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(245)).setAttribute("nombre","indPediPrue" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("trim","S" );
      ((Element)v.get(245)).setAttribute("max","1" );
      ((Element)v.get(245)).setAttribute("onchange","" );
      ((Element)v.get(245)).setAttribute("req","N" );
      ((Element)v.get(245)).setAttribute("size","1" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("validacion","" );
      ((Element)v.get(245)).setAttribute("disabled","" );
      ((Element)v.get(245)).setAttribute("onblur","" );
      ((Element)v.get(245)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',10, true)" );
      ((Element)v.get(245)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 10, false)" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:246 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("nombre","indPediPrueGapTdId" );
      ((Element)v.get(246)).setAttribute("nowrap","true" );
      ((Element)v.get(246)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:232   */

      /* Empieza nodo:250 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(250)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:250   */

      /* Empieza nodo:257 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(257)).setAttribute("nombre","formTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(261)).setAttribute("border","0" );
      ((Element)v.get(261)).setAttribute("cellspacing","0" );
      ((Element)v.get(261)).setAttribute("cellpadding","0" );
      ((Element)v.get(261)).setAttribute("align","left" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(262)).setAttribute("align","left" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("nombre","indComiTdId" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

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
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("valign","top" );
      ((Element)v.get(266)).setAttribute("height","13" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(267)).setAttribute("nombre","lblIndComi" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("id","datosTitle" );
      ((Element)v.get(267)).setAttribute("cod","PedTipoSolicPais.indComi.label" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:268 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(268)).setAttribute("nombre","indComiWidgetTrId" );
      ((Element)v.get(264)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(269)).setAttribute("nowrap","true" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(270)).setAttribute("nombre","indComi" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("trim","S" );
      ((Element)v.get(270)).setAttribute("max","1" );
      ((Element)v.get(270)).setAttribute("onchange","" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("size","1" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("validacion","" );
      ((Element)v.get(270)).setAttribute("disabled","" );
      ((Element)v.get(270)).setAttribute("onblur","" );
      ((Element)v.get(270)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',11, true)" );
      ((Element)v.get(270)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 11, false)" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:271 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(271)).setAttribute("nombre","indComiGapTdId" );
      ((Element)v.get(271)).setAttribute("nowrap","true" );
      ((Element)v.get(271)).setAttribute("class","datosCampos" );
      ((Element)v.get(262)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(262)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:257   */

      /* Empieza nodo:275 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(275)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(15)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("align","center" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","12" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("align","center" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","12" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:275   */

      /* Empieza nodo:282 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(282)).setAttribute("nombre","formTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","12" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(282)).appendChild((Element)v.get(285));

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
      ((Element)v.get(287)).setAttribute("align","left" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("nombre","indVentInteSab14TdId" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(289)).setAttribute("width","100%" );
      ((Element)v.get(289)).setAttribute("border","0" );
      ((Element)v.get(289)).setAttribute("cellspacing","0" );
      ((Element)v.get(289)).setAttribute("cellpadding","0" );
      ((Element)v.get(289)).setAttribute("align","left" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("valign","top" );
      ((Element)v.get(291)).setAttribute("height","13" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblIndVentInteSab14" );
      ((Element)v.get(292)).setAttribute("alto","13" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("id","datosTitle" );
      ((Element)v.get(292)).setAttribute("cod","PedTipoSolicPais.indVentInteSab14.label" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:293 / Elemento padre: 289   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(293)).setAttribute("nombre","indVentInteSab14WidgetTrId" );
      ((Element)v.get(289)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("align","left" );
      ((Element)v.get(294)).setAttribute("nowrap","true" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(295)).setAttribute("nombre","indVentInteSab14" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("trim","S" );
      ((Element)v.get(295)).setAttribute("max","1" );
      ((Element)v.get(295)).setAttribute("onchange","" );
      ((Element)v.get(295)).setAttribute("req","N" );
      ((Element)v.get(295)).setAttribute("size","1" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("validacion","" );
      ((Element)v.get(295)).setAttribute("disabled","" );
      ((Element)v.get(295)).setAttribute("onblur","" );
      ((Element)v.get(295)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',12, true)" );
      ((Element)v.get(295)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 12, false)" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:296 / Elemento padre: 287   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).setAttribute("nombre","indVentInteSab14GapTdId" );
      ((Element)v.get(296)).setAttribute("nowrap","true" );
      ((Element)v.get(296)).setAttribute("class","datosCampos" );
      ((Element)v.get(287)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(287)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:282   */

      /* Empieza nodo:300 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(15)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","center" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","12" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("align","center" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","12" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:300   */

      /* Empieza nodo:307 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(307)).setAttribute("nombre","formTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","12" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(311)).setAttribute("width","100%" );
      ((Element)v.get(311)).setAttribute("border","0" );
      ((Element)v.get(311)).setAttribute("cellspacing","0" );
      ((Element)v.get(311)).setAttribute("cellpadding","0" );
      ((Element)v.get(311)).setAttribute("align","left" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(312)).setAttribute("align","left" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("nombre","cactOidActiTdId" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(317)).setAttribute("nombre","lblcactOidActi" );
      ((Element)v.get(317)).setAttribute("id","datosTitle" );
      ((Element)v.get(317)).setAttribute("ancho","150" );
      ((Element)v.get(317)).setAttribute("alto","13" );
      ((Element)v.get(317)).setAttribute("cod","PedTipoSolicPais.cactOidActi.label" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:318 / Elemento padre: 314   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(318)).setAttribute("nombre","cactOidActiWidgetTrId" );
      ((Element)v.get(314)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("align","left" );
      ((Element)v.get(319)).setAttribute("nowrap","true" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(320)).setAttribute("nombre","cactOidActi" );
      ((Element)v.get(320)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).setAttribute("multiple","N" );
      ((Element)v.get(320)).setAttribute("req","N" );
      ((Element)v.get(320)).setAttribute("size","1" );
      ((Element)v.get(320)).setAttribute("disabled","" );
      ((Element)v.get(320)).setAttribute("validacion","" );
      ((Element)v.get(320)).setAttribute("onchange","" );
      ((Element)v.get(320)).setAttribute("onfocus","" );
      ((Element)v.get(320)).setAttribute("valorinicial","" );
      ((Element)v.get(320)).setAttribute("textoinicial","" );
      ((Element)v.get(320)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',13, true);" );
      ((Element)v.get(320)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',13, false);" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:322 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("nombre","cactOidActiGapTdId" );
      ((Element)v.get(322)).setAttribute("nowrap","true" );
      ((Element)v.get(322)).setAttribute("class","datosCampos" );
      ((Element)v.get(312)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(312)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:307   */

      /* Empieza nodo:326 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(326)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(15)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).setAttribute("align","center" );
      ((Element)v.get(327)).setAttribute("width","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","12" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("align","center" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","12" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:326   */

      /* Empieza nodo:333 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(333)).setAttribute("nombre","formTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).setAttribute("align","center" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","8" );
      ((Element)v.get(335)).setAttribute("height","12" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(333)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(337)).setAttribute("border","0" );
      ((Element)v.get(337)).setAttribute("cellspacing","0" );
      ((Element)v.get(337)).setAttribute("cellpadding","0" );
      ((Element)v.get(337)).setAttribute("align","left" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(338)).setAttribute("align","left" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(339)).setAttribute("nombre","moneOidMoneTdId" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(340)).setAttribute("border","0" );
      ((Element)v.get(340)).setAttribute("cellspacing","0" );
      ((Element)v.get(340)).setAttribute("cellpadding","0" );
      ((Element)v.get(340)).setAttribute("align","left" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("valign","top" );
      ((Element)v.get(342)).setAttribute("height","13" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(343)).setAttribute("nombre","lblmoneOidMone" );
      ((Element)v.get(343)).setAttribute("id","datosTitle" );
      ((Element)v.get(343)).setAttribute("ancho","150" );
      ((Element)v.get(343)).setAttribute("alto","13" );
      ((Element)v.get(343)).setAttribute("cod","PedTipoSolicPais.moneOidMone.label" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:344 / Elemento padre: 340   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(344)).setAttribute("nombre","moneOidMoneWidgetTrId" );
      ((Element)v.get(340)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("align","left" );
      ((Element)v.get(345)).setAttribute("nowrap","true" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(346)).setAttribute("nombre","moneOidMone" );
      ((Element)v.get(346)).setAttribute("id","datosCampos" );
      ((Element)v.get(346)).setAttribute("multiple","N" );
      ((Element)v.get(346)).setAttribute("req","N" );
      ((Element)v.get(346)).setAttribute("size","1" );
      ((Element)v.get(346)).setAttribute("disabled","" );
      ((Element)v.get(346)).setAttribute("validacion","" );
      ((Element)v.get(346)).setAttribute("onchange","" );
      ((Element)v.get(346)).setAttribute("onfocus","" );
      ((Element)v.get(346)).setAttribute("valorinicial","" );
      ((Element)v.get(346)).setAttribute("textoinicial","" );
      ((Element)v.get(346)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',14, true);" );
      ((Element)v.get(346)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',14, false);" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:348 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("nombre","moneOidMoneGapTdId" );
      ((Element)v.get(348)).setAttribute("nowrap","true" );
      ((Element)v.get(348)).setAttribute("class","datosCampos" );
      ((Element)v.get(338)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","25" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 338   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("width","100%" );
      ((Element)v.get(338)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:333   */

      /* Empieza nodo:352 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(352)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(15)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("align","center" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","12" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(352)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","8" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("align","center" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","12" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:352   */

      /* Empieza nodo:359 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(359)).setAttribute("nombre","formTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("align","center" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","8" );
      ((Element)v.get(361)).setAttribute("height","12" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(362)).setAttribute("width","100%" );
      ((Element)v.get(359)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(363)).setAttribute("border","0" );
      ((Element)v.get(363)).setAttribute("cellspacing","0" );
      ((Element)v.get(363)).setAttribute("cellpadding","0" );
      ((Element)v.get(363)).setAttribute("align","left" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(364)).setAttribute("align","left" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).setAttribute("nombre","tmalOidTipoMoviAsigTdId" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(366)).setAttribute("border","0" );
      ((Element)v.get(366)).setAttribute("cellspacing","0" );
      ((Element)v.get(366)).setAttribute("cellpadding","0" );
      ((Element)v.get(366)).setAttribute("align","left" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("valign","top" );
      ((Element)v.get(368)).setAttribute("height","13" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lbltmalOidTipoMoviAsig" );
      ((Element)v.get(369)).setAttribute("id","datosTitle" );
      ((Element)v.get(369)).setAttribute("ancho","150" );
      ((Element)v.get(369)).setAttribute("alto","13" );
      ((Element)v.get(369)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviAsig.label" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:370 / Elemento padre: 366   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(370)).setAttribute("nombre","tmalOidTipoMoviAsigWidgetTrId" );
      ((Element)v.get(366)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("align","left" );
      ((Element)v.get(371)).setAttribute("nowrap","true" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(372)).setAttribute("nombre","tmalOidTipoMoviAsig" );
      ((Element)v.get(372)).setAttribute("id","datosCampos" );
      ((Element)v.get(372)).setAttribute("multiple","N" );
      ((Element)v.get(372)).setAttribute("req","N" );
      ((Element)v.get(372)).setAttribute("size","1" );
      ((Element)v.get(372)).setAttribute("disabled","" );
      ((Element)v.get(372)).setAttribute("validacion","" );
      ((Element)v.get(372)).setAttribute("onchange","" );
      ((Element)v.get(372)).setAttribute("onfocus","" );
      ((Element)v.get(372)).setAttribute("valorinicial","" );
      ((Element)v.get(372)).setAttribute("textoinicial","" );
      ((Element)v.get(372)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',15, true);" );
      ((Element)v.get(372)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',15, false);" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:374 / Elemento padre: 364   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("nombre","tmalOidTipoMoviAsigGapTdId" );
      ((Element)v.get(374)).setAttribute("nowrap","true" );
      ((Element)v.get(374)).setAttribute("class","datosCampos" );
      ((Element)v.get(364)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","25" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 364   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).setAttribute("width","100%" );
      ((Element)v.get(364)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:359   */

      /* Empieza nodo:378 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(378)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(15)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("align","center" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","12" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(378)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).setAttribute("width","8" );
      ((Element)v.get(382)).setAttribute("height","8" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(383)).setAttribute("align","center" );
      ((Element)v.get(383)).setAttribute("width","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","12" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:378   */

      /* Empieza nodo:385 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(385)).setAttribute("nombre","formTr14" );
      ((Element)v.get(15)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).setAttribute("align","center" );
      ((Element)v.get(386)).setAttribute("width","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","12" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 385   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("width","100%" );
      ((Element)v.get(385)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(389)).setAttribute("width","100%" );
      ((Element)v.get(389)).setAttribute("border","0" );
      ((Element)v.get(389)).setAttribute("cellspacing","0" );
      ((Element)v.get(389)).setAttribute("cellpadding","0" );
      ((Element)v.get(389)).setAttribute("align","left" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(390)).setAttribute("align","left" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("nombre","tmalOidTipoMoviReseTdId" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(392)).setAttribute("border","0" );
      ((Element)v.get(392)).setAttribute("cellspacing","0" );
      ((Element)v.get(392)).setAttribute("cellpadding","0" );
      ((Element)v.get(392)).setAttribute("align","left" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("valign","top" );
      ((Element)v.get(394)).setAttribute("height","13" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(395)).setAttribute("nombre","lbltmalOidTipoMoviRese" );
      ((Element)v.get(395)).setAttribute("id","datosTitle" );
      ((Element)v.get(395)).setAttribute("ancho","150" );
      ((Element)v.get(395)).setAttribute("alto","13" );
      ((Element)v.get(395)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviRese.label" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:396 / Elemento padre: 392   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(396)).setAttribute("nombre","tmalOidTipoMoviReseWidgetTrId" );
      ((Element)v.get(392)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(397)).setAttribute("align","left" );
      ((Element)v.get(397)).setAttribute("nowrap","true" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(398)).setAttribute("nombre","tmalOidTipoMoviRese" );
      ((Element)v.get(398)).setAttribute("id","datosCampos" );
      ((Element)v.get(398)).setAttribute("multiple","N" );
      ((Element)v.get(398)).setAttribute("req","N" );
      ((Element)v.get(398)).setAttribute("size","1" );
      ((Element)v.get(398)).setAttribute("disabled","" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(398)).setAttribute("validacion","" );
      ((Element)v.get(398)).setAttribute("onchange","" );
      ((Element)v.get(398)).setAttribute("onfocus","" );
      ((Element)v.get(398)).setAttribute("valorinicial","" );
      ((Element)v.get(398)).setAttribute("textoinicial","" );
      ((Element)v.get(398)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',16, true);" );
      ((Element)v.get(398)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',16, false);" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:400 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(400)).setAttribute("nombre","tmalOidTipoMoviReseGapTdId" );
      ((Element)v.get(400)).setAttribute("nowrap","true" );
      ((Element)v.get(400)).setAttribute("class","datosCampos" );
      ((Element)v.get(390)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("width","100%" );
      ((Element)v.get(390)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:385   */

      /* Empieza nodo:404 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(404)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(15)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(405)).setAttribute("align","center" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","12" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(409)).setAttribute("align","center" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","12" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:404   */

      /* Empieza nodo:411 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(411)).setAttribute("nombre","formTr15" );
      ((Element)v.get(15)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("align","center" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","8" );
      ((Element)v.get(413)).setAttribute("height","12" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(414)).setAttribute("width","100%" );
      ((Element)v.get(411)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(415)).setAttribute("width","100%" );
      ((Element)v.get(415)).setAttribute("border","0" );
      ((Element)v.get(415)).setAttribute("cellspacing","0" );
      ((Element)v.get(415)).setAttribute("cellpadding","0" );
      ((Element)v.get(415)).setAttribute("align","left" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(416)).setAttribute("align","left" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(417)).setAttribute("nombre","tmalOidTipoMoviFactTdId" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(418)).setAttribute("border","0" );
      ((Element)v.get(418)).setAttribute("cellspacing","0" );
      ((Element)v.get(418)).setAttribute("cellpadding","0" );
      ((Element)v.get(418)).setAttribute("align","left" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("valign","top" );
      ((Element)v.get(420)).setAttribute("height","13" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(421)).setAttribute("nombre","lbltmalOidTipoMoviFact" );
      ((Element)v.get(421)).setAttribute("id","datosTitle" );
      ((Element)v.get(421)).setAttribute("ancho","150" );
      ((Element)v.get(421)).setAttribute("alto","13" );
      ((Element)v.get(421)).setAttribute("cod","PedTipoSolicPais.tmalOidTipoMoviFact.label" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:422 / Elemento padre: 418   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(422)).setAttribute("nombre","tmalOidTipoMoviFactWidgetTrId" );
      ((Element)v.get(418)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("align","left" );
      ((Element)v.get(423)).setAttribute("nowrap","true" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(424)).setAttribute("nombre","tmalOidTipoMoviFact" );
      ((Element)v.get(424)).setAttribute("id","datosCampos" );
      ((Element)v.get(424)).setAttribute("multiple","N" );
      ((Element)v.get(424)).setAttribute("req","N" );
      ((Element)v.get(424)).setAttribute("size","1" );
      ((Element)v.get(424)).setAttribute("disabled","" );
      ((Element)v.get(424)).setAttribute("validacion","" );
      ((Element)v.get(424)).setAttribute("onchange","" );
      ((Element)v.get(424)).setAttribute("onfocus","" );
      ((Element)v.get(424)).setAttribute("valorinicial","" );
      ((Element)v.get(424)).setAttribute("textoinicial","" );
      ((Element)v.get(424)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',17, true);" );
      ((Element)v.get(424)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',17, false);" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:426 / Elemento padre: 416   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(426)).setAttribute("nombre","tmalOidTipoMoviFactGapTdId" );
      ((Element)v.get(426)).setAttribute("nowrap","true" );
      ((Element)v.get(426)).setAttribute("class","datosCampos" );
      ((Element)v.get(416)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","25" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 416   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(416)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */
      /* Termina nodo:411   */

      /* Empieza nodo:430 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(430)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(15)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("align","center" );
      ((Element)v.get(431)).setAttribute("width","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","12" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(430)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(434)).setAttribute("height","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(435)).setAttribute("align","center" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(436)).setAttribute("src","b.gif" );
      ((Element)v.get(436)).setAttribute("width","12" );
      ((Element)v.get(436)).setAttribute("height","8" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:430   */

      /* Empieza nodo:437 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(437)).setAttribute("nombre","formTr16" );
      ((Element)v.get(15)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("align","center" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","8" );
      ((Element)v.get(439)).setAttribute("height","12" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(440)).setAttribute("width","100%" );
      ((Element)v.get(437)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(441)).setAttribute("width","100%" );
      ((Element)v.get(441)).setAttribute("border","0" );
      ((Element)v.get(441)).setAttribute("cellspacing","0" );
      ((Element)v.get(441)).setAttribute("cellpadding","0" );
      ((Element)v.get(441)).setAttribute("align","left" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(442)).setAttribute("align","left" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("nombre","tidoOidTipoDocuTdId" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(444)).setAttribute("border","0" );
      ((Element)v.get(444)).setAttribute("cellspacing","0" );
      ((Element)v.get(444)).setAttribute("cellpadding","0" );
      ((Element)v.get(444)).setAttribute("align","left" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("valign","top" );
      ((Element)v.get(446)).setAttribute("height","13" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(447)).setAttribute("nombre","lbltidoOidTipoDocu" );
      ((Element)v.get(447)).setAttribute("id","datosTitle" );
      ((Element)v.get(447)).setAttribute("ancho","150" );
      ((Element)v.get(447)).setAttribute("alto","13" );
      ((Element)v.get(447)).setAttribute("cod","PedTipoSolicPais.tidoOidTipoDocu.label" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:448 / Elemento padre: 444   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(448)).setAttribute("nombre","tidoOidTipoDocuWidgetTrId" );
      ((Element)v.get(444)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(449)).setAttribute("align","left" );
      ((Element)v.get(449)).setAttribute("nowrap","true" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(450)).setAttribute("nombre","tidoOidTipoDocu" );
      ((Element)v.get(450)).setAttribute("id","datosCampos" );
      ((Element)v.get(450)).setAttribute("multiple","N" );
      ((Element)v.get(450)).setAttribute("req","N" );
      ((Element)v.get(450)).setAttribute("size","1" );
      ((Element)v.get(450)).setAttribute("disabled","" );
      ((Element)v.get(450)).setAttribute("validacion","" );
      ((Element)v.get(450)).setAttribute("onchange","" );
      ((Element)v.get(450)).setAttribute("onfocus","" );
      ((Element)v.get(450)).setAttribute("valorinicial","" );
      ((Element)v.get(450)).setAttribute("textoinicial","" );
      ((Element)v.get(450)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',18, true);" );
      ((Element)v.get(450)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',18, false);" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:452 / Elemento padre: 442   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(452)).setAttribute("nombre","tidoOidTipoDocuGapTdId" );
      ((Element)v.get(452)).setAttribute("nowrap","true" );
      ((Element)v.get(452)).setAttribute("class","datosCampos" );
      ((Element)v.get(442)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","25" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 442   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("width","100%" );
      ((Element)v.get(442)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:437   */

      /* Empieza nodo:456 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(456)).setAttribute("nombre","formGapTr16" );
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
   }

   private void getXML2070(Document doc) {
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
      ((Element)v.get(463)).setAttribute("nombre","formTr17" );
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
      ((Element)v.get(469)).setAttribute("nombre","indPermUnioTdId" );
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
      ((Element)v.get(473)).setAttribute("nombre","lblIndPermUnio" );
      ((Element)v.get(473)).setAttribute("alto","13" );
      ((Element)v.get(473)).setAttribute("filas","1" );
      ((Element)v.get(473)).setAttribute("id","datosTitle" );
      ((Element)v.get(473)).setAttribute("cod","PedTipoSolicPais.indPermUnio.label" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:474 / Elemento padre: 470   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(474)).setAttribute("nombre","indPermUnioWidgetTrId" );
      ((Element)v.get(470)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("align","left" );
      ((Element)v.get(475)).setAttribute("nowrap","true" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(476)).setAttribute("nombre","indPermUnio" );
      ((Element)v.get(476)).setAttribute("id","datosCampos" );
      ((Element)v.get(476)).setAttribute("trim","S" );
      ((Element)v.get(476)).setAttribute("max","1" );
      ((Element)v.get(476)).setAttribute("onchange","" );
      ((Element)v.get(476)).setAttribute("req","N" );
      ((Element)v.get(476)).setAttribute("size","1" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(476)).setAttribute("validacion","" );
      ((Element)v.get(476)).setAttribute("disabled","" );
      ((Element)v.get(476)).setAttribute("onblur","" );
      ((Element)v.get(476)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',19, true)" );
      ((Element)v.get(476)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 19, false)" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:477 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(477)).setAttribute("nombre","indPermUnioGapTdId" );
      ((Element)v.get(477)).setAttribute("nowrap","true" );
      ((Element)v.get(477)).setAttribute("class","datosCampos" );
      ((Element)v.get(468)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).setAttribute("width","25" );
      ((Element)v.get(478)).setAttribute("height","8" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("width","100%" );
      ((Element)v.get(468)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:463   */

      /* Empieza nodo:481 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(481)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(15)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(482)).setAttribute("align","center" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).setAttribute("width","12" );
      ((Element)v.get(483)).setAttribute("height","8" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(481)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","8" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(486)).setAttribute("align","center" );
      ((Element)v.get(486)).setAttribute("width","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","12" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:481   */

      /* Empieza nodo:488 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(488)).setAttribute("nombre","formTr18" );
      ((Element)v.get(15)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(489)).setAttribute("align","center" );
      ((Element)v.get(489)).setAttribute("width","8" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","8" );
      ((Element)v.get(490)).setAttribute("height","12" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 488   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(491)).setAttribute("width","100%" );
      ((Element)v.get(488)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(492)).setAttribute("width","100%" );
      ((Element)v.get(492)).setAttribute("border","0" );
      ((Element)v.get(492)).setAttribute("cellspacing","0" );
      ((Element)v.get(492)).setAttribute("cellpadding","0" );
      ((Element)v.get(492)).setAttribute("align","left" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).setAttribute("align","left" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("nombre","indPediGtZonaTdId" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(495)).setAttribute("width","100%" );
      ((Element)v.get(495)).setAttribute("border","0" );
      ((Element)v.get(495)).setAttribute("cellspacing","0" );
      ((Element)v.get(495)).setAttribute("cellpadding","0" );
      ((Element)v.get(495)).setAttribute("align","left" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("valign","top" );
      ((Element)v.get(497)).setAttribute("height","13" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(498)).setAttribute("nombre","lblIndPediGtZona" );
      ((Element)v.get(498)).setAttribute("alto","13" );
      ((Element)v.get(498)).setAttribute("filas","1" );
      ((Element)v.get(498)).setAttribute("id","datosTitle" );
      ((Element)v.get(498)).setAttribute("cod","PedTipoSolicPais.indPediGtZona.label" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:499 / Elemento padre: 495   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(499)).setAttribute("nombre","indPediGtZonaWidgetTrId" );
      ((Element)v.get(495)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(500)).setAttribute("align","left" );
      ((Element)v.get(500)).setAttribute("nowrap","true" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(501)).setAttribute("nombre","indPediGtZona" );
      ((Element)v.get(501)).setAttribute("id","datosCampos" );
      ((Element)v.get(501)).setAttribute("trim","S" );
      ((Element)v.get(501)).setAttribute("max","1" );
      ((Element)v.get(501)).setAttribute("onchange","" );
      ((Element)v.get(501)).setAttribute("req","N" );
      ((Element)v.get(501)).setAttribute("size","1" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(501)).setAttribute("validacion","" );
      ((Element)v.get(501)).setAttribute("disabled","" );
      ((Element)v.get(501)).setAttribute("onblur","" );
      ((Element)v.get(501)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',20, true)" );
      ((Element)v.get(501)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 20, false)" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:502 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("nombre","indPediGtZonaGapTdId" );
      ((Element)v.get(502)).setAttribute("nowrap","true" );
      ((Element)v.get(502)).setAttribute("class","datosCampos" );
      ((Element)v.get(493)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","25" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(493)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:488   */

      /* Empieza nodo:506 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(506)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(15)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(507)).setAttribute("align","center" );
      ((Element)v.get(507)).setAttribute("width","8" );
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
      ((Element)v.get(511)).setAttribute("width","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","12" );
      ((Element)v.get(512)).setAttribute("height","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:506   */

      /* Empieza nodo:513 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(513)).setAttribute("nombre","formTr19" );
      ((Element)v.get(15)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("align","center" );
      ((Element)v.get(514)).setAttribute("width","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","8" );
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
      ((Element)v.get(519)).setAttribute("nombre","indCambVentBelTdId" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(520)).setAttribute("width","100%" );
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
      ((Element)v.get(523)).setAttribute("nombre","lblIndCambVentBel" );
      ((Element)v.get(523)).setAttribute("alto","13" );
      ((Element)v.get(523)).setAttribute("filas","1" );
      ((Element)v.get(523)).setAttribute("id","datosTitle" );
      ((Element)v.get(523)).setAttribute("cod","PedTipoSolicPais.indCambVentBel.label" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:524 / Elemento padre: 520   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(524)).setAttribute("nombre","indCambVentBelWidgetTrId" );
      ((Element)v.get(520)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).setAttribute("align","left" );
      ((Element)v.get(525)).setAttribute("nowrap","true" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(526)).setAttribute("nombre","indCambVentBel" );
      ((Element)v.get(526)).setAttribute("id","datosCampos" );
      ((Element)v.get(526)).setAttribute("trim","S" );
      ((Element)v.get(526)).setAttribute("max","1" );
      ((Element)v.get(526)).setAttribute("onchange","" );
      ((Element)v.get(526)).setAttribute("req","N" );
      ((Element)v.get(526)).setAttribute("size","1" );
      ((Element)v.get(526)).setAttribute("valor","" );
      ((Element)v.get(526)).setAttribute("validacion","" );
      ((Element)v.get(526)).setAttribute("disabled","" );
      ((Element)v.get(526)).setAttribute("onblur","" );
      ((Element)v.get(526)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',21, true)" );
      ((Element)v.get(526)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 21, false)" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:527 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(527)).setAttribute("nombre","indCambVentBelGapTdId" );
      ((Element)v.get(527)).setAttribute("nowrap","true" );
      ((Element)v.get(527)).setAttribute("class","datosCampos" );
      ((Element)v.get(518)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).setAttribute("width","25" );
      ((Element)v.get(528)).setAttribute("height","8" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(529)).setAttribute("width","100%" );
      ((Element)v.get(518)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:513   */

      /* Empieza nodo:531 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(531)).setAttribute("nombre","formGapTr19" );
      ((Element)v.get(15)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(532)).setAttribute("align","center" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","12" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(531)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","8" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(536)).setAttribute("align","center" );
      ((Element)v.get(536)).setAttribute("width","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","12" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:531   */

      /* Empieza nodo:538 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(538)).setAttribute("nombre","formTr20" );
      ((Element)v.get(15)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(539)).setAttribute("align","center" );
      ((Element)v.get(539)).setAttribute("width","8" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","8" );
      ((Element)v.get(540)).setAttribute("height","12" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 538   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(538)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(542)).setAttribute("width","100%" );
      ((Element)v.get(542)).setAttribute("border","0" );
      ((Element)v.get(542)).setAttribute("cellspacing","0" );
      ((Element)v.get(542)).setAttribute("cellpadding","0" );
      ((Element)v.get(542)).setAttribute("align","left" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(543)).setAttribute("align","left" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("nombre","almcOidAlmaTdId" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(545)).setAttribute("border","0" );
      ((Element)v.get(545)).setAttribute("cellspacing","0" );
      ((Element)v.get(545)).setAttribute("cellpadding","0" );
      ((Element)v.get(545)).setAttribute("align","left" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(547)).setAttribute("valign","top" );
      ((Element)v.get(547)).setAttribute("height","13" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(548)).setAttribute("nombre","lblalmcOidAlma" );
      ((Element)v.get(548)).setAttribute("id","datosTitle" );
      ((Element)v.get(548)).setAttribute("ancho","150" );
      ((Element)v.get(548)).setAttribute("alto","13" );
      ((Element)v.get(548)).setAttribute("cod","PedTipoSolicPais.almcOidAlma.label" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:549 / Elemento padre: 545   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(549)).setAttribute("nombre","almcOidAlmaWidgetTrId" );
      ((Element)v.get(545)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(550)).setAttribute("align","left" );
      ((Element)v.get(550)).setAttribute("nowrap","true" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(551)).setAttribute("nombre","almcOidAlma" );
      ((Element)v.get(551)).setAttribute("id","datosCampos" );
      ((Element)v.get(551)).setAttribute("multiple","N" );
      ((Element)v.get(551)).setAttribute("req","N" );
      ((Element)v.get(551)).setAttribute("size","1" );
      ((Element)v.get(551)).setAttribute("disabled","" );
      ((Element)v.get(551)).setAttribute("validacion","" );
      ((Element)v.get(551)).setAttribute("onchange","" );
      ((Element)v.get(551)).setAttribute("onfocus","" );
      ((Element)v.get(551)).setAttribute("valorinicial","" );
      ((Element)v.get(551)).setAttribute("textoinicial","" );
      ((Element)v.get(551)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',22, true);" );
      ((Element)v.get(551)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',22, false);" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:553 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(553)).setAttribute("nombre","almcOidAlmaGapTdId" );
      ((Element)v.get(553)).setAttribute("nowrap","true" );
      ((Element)v.get(553)).setAttribute("class","datosCampos" );
      ((Element)v.get(543)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("width","25" );
      ((Element)v.get(554)).setAttribute("height","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(555)).setAttribute("width","100%" );
      ((Element)v.get(543)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:538   */

      /* Empieza nodo:557 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(557)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(15)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(558)).setAttribute("align","center" );
      ((Element)v.get(558)).setAttribute("width","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","12" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 557   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(557)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","8" );
      ((Element)v.get(561)).setAttribute("height","8" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 557   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).setAttribute("align","center" );
      ((Element)v.get(562)).setAttribute("width","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(563)).setAttribute("src","b.gif" );
      ((Element)v.get(563)).setAttribute("width","12" );
      ((Element)v.get(563)).setAttribute("height","8" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:557   */

      /* Empieza nodo:564 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(564)).setAttribute("nombre","formTr21" );
      ((Element)v.get(15)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(565)).setAttribute("align","center" );
      ((Element)v.get(565)).setAttribute("width","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","8" );
      ((Element)v.get(566)).setAttribute("height","12" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 564   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(567)).setAttribute("width","100%" );
      ((Element)v.get(564)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(568)).setAttribute("width","100%" );
      ((Element)v.get(568)).setAttribute("border","0" );
      ((Element)v.get(568)).setAttribute("cellspacing","0" );
      ((Element)v.get(568)).setAttribute("cellpadding","0" );
      ((Element)v.get(568)).setAttribute("align","left" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(569)).setAttribute("align","left" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(570)).setAttribute("nombre","sociOidSociTdId" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(571)).setAttribute("border","0" );
      ((Element)v.get(571)).setAttribute("cellspacing","0" );
      ((Element)v.get(571)).setAttribute("cellpadding","0" );
      ((Element)v.get(571)).setAttribute("align","left" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(573)).setAttribute("valign","top" );
      ((Element)v.get(573)).setAttribute("height","13" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(574)).setAttribute("nombre","lblsociOidSoci" );
      ((Element)v.get(574)).setAttribute("id","datosTitle" );
      ((Element)v.get(574)).setAttribute("ancho","150" );
      ((Element)v.get(574)).setAttribute("alto","13" );
      ((Element)v.get(574)).setAttribute("cod","PedTipoSolicPais.sociOidSoci.label" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:575 / Elemento padre: 571   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(575)).setAttribute("nombre","sociOidSociWidgetTrId" );
      ((Element)v.get(571)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(576)).setAttribute("align","left" );
      ((Element)v.get(576)).setAttribute("nowrap","true" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(577)).setAttribute("nombre","sociOidSoci" );
      ((Element)v.get(577)).setAttribute("id","datosCampos" );
      ((Element)v.get(577)).setAttribute("multiple","N" );
      ((Element)v.get(577)).setAttribute("req","N" );
      ((Element)v.get(577)).setAttribute("size","1" );
      ((Element)v.get(577)).setAttribute("disabled","" );
      ((Element)v.get(577)).setAttribute("validacion","" );
      ((Element)v.get(577)).setAttribute("onchange","" );
      ((Element)v.get(577)).setAttribute("onfocus","" );
      ((Element)v.get(577)).setAttribute("valorinicial","" );
      ((Element)v.get(577)).setAttribute("textoinicial","" );
      ((Element)v.get(577)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',23, true);" );
      ((Element)v.get(577)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',23, false);" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:579 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(579)).setAttribute("nombre","sociOidSociGapTdId" );
      ((Element)v.get(579)).setAttribute("nowrap","true" );
      ((Element)v.get(579)).setAttribute("class","datosCampos" );
      ((Element)v.get(569)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","25" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(581)).setAttribute("width","100%" );
      ((Element)v.get(569)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:567   */
      /* Termina nodo:564   */

      /* Empieza nodo:583 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(583)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(15)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(584)).setAttribute("align","center" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(585)).setAttribute("src","b.gif" );
      ((Element)v.get(585)).setAttribute("width","12" );
      ((Element)v.get(585)).setAttribute("height","8" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */

      /* Empieza nodo:586 / Elemento padre: 583   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(587)).setAttribute("height","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 583   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(588)).setAttribute("align","center" );
      ((Element)v.get(588)).setAttribute("width","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("width","12" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:583   */

      /* Empieza nodo:590 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(590)).setAttribute("nombre","formTr22" );
      ((Element)v.get(15)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("align","center" );
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","8" );
      ((Element)v.get(592)).setAttribute("height","12" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(593)).setAttribute("width","100%" );
      ((Element)v.get(590)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(594)).setAttribute("width","100%" );
      ((Element)v.get(594)).setAttribute("border","0" );
      ((Element)v.get(594)).setAttribute("cellspacing","0" );
      ((Element)v.get(594)).setAttribute("cellpadding","0" );
      ((Element)v.get(594)).setAttribute("align","left" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(595)).setAttribute("align","left" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(596)).setAttribute("nombre","valGlosTdId" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(597)).setAttribute("width","100%" );
      ((Element)v.get(597)).setAttribute("border","0" );
      ((Element)v.get(597)).setAttribute("cellspacing","0" );
      ((Element)v.get(597)).setAttribute("cellpadding","0" );
      ((Element)v.get(597)).setAttribute("align","left" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(599)).setAttribute("valign","top" );
      ((Element)v.get(599)).setAttribute("height","13" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(600)).setAttribute("nombre","lblValGlos" );
      ((Element)v.get(600)).setAttribute("alto","13" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(600)).setAttribute("filas","1" );
      ((Element)v.get(600)).setAttribute("id","datosTitle" );
      ((Element)v.get(600)).setAttribute("cod","PedTipoSolicPais.valGlos.label" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:601 / Elemento padre: 597   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(601)).setAttribute("nombre","valGlosWidgetTrId" );
      ((Element)v.get(597)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(602)).setAttribute("align","left" );
      ((Element)v.get(602)).setAttribute("nowrap","true" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(603)).setAttribute("nombre","valGlos" );
      ((Element)v.get(603)).setAttribute("id","datosCampos" );
      ((Element)v.get(603)).setAttribute("trim","S" );
      ((Element)v.get(603)).setAttribute("max","255" );
      ((Element)v.get(603)).setAttribute("onchange","" );
      ((Element)v.get(603)).setAttribute("req","N" );
      ((Element)v.get(603)).setAttribute("size","255" );
      ((Element)v.get(603)).setAttribute("valor","" );
      ((Element)v.get(603)).setAttribute("validacion","" );
      ((Element)v.get(603)).setAttribute("disabled","" );
      ((Element)v.get(603)).setAttribute("onblur","" );
      ((Element)v.get(603)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',24, true)" );
      ((Element)v.get(603)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm', 24, false)" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:604 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(604)).setAttribute("nombre","valGlosGapTdId" );
      ((Element)v.get(604)).setAttribute("nowrap","true" );
      ((Element)v.get(604)).setAttribute("class","datosCampos" );
      ((Element)v.get(595)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","25" );
      ((Element)v.get(605)).setAttribute("height","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(606)).setAttribute("width","100%" );
      ((Element)v.get(595)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:590   */

      /* Empieza nodo:608 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(608)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(15)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(609)).setAttribute("align","center" );
      ((Element)v.get(609)).setAttribute("width","8" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).setAttribute("width","12" );
      ((Element)v.get(610)).setAttribute("height","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(608)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","8" );
      ((Element)v.get(612)).setAttribute("height","8" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(613)).setAttribute("align","center" );
      ((Element)v.get(613)).setAttribute("width","8" );
      ((Element)v.get(608)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).setAttribute("width","12" );
      ((Element)v.get(614)).setAttribute("height","8" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:608   */

      /* Empieza nodo:615 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(615)).setAttribute("nombre","formTr23" );
      ((Element)v.get(15)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("align","center" );
      ((Element)v.get(616)).setAttribute("width","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(617)).setAttribute("width","8" );
      ((Element)v.get(617)).setAttribute("height","12" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(618)).setAttribute("width","100%" );
      ((Element)v.get(615)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(619)).setAttribute("width","100%" );
      ((Element)v.get(619)).setAttribute("border","0" );
      ((Element)v.get(619)).setAttribute("cellspacing","0" );
      ((Element)v.get(619)).setAttribute("cellpadding","0" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(619)).setAttribute("align","left" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(620)).setAttribute("align","left" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(621)).setAttribute("nombre","tsolOidTipoConsTdId" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(622)).setAttribute("border","0" );
      ((Element)v.get(622)).setAttribute("cellspacing","0" );
      ((Element)v.get(622)).setAttribute("cellpadding","0" );
      ((Element)v.get(622)).setAttribute("align","left" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(624)).setAttribute("valign","top" );
      ((Element)v.get(624)).setAttribute("height","13" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(625)).setAttribute("nombre","lbltsolOidTipoCons" );
      ((Element)v.get(625)).setAttribute("id","datosTitle" );
      ((Element)v.get(625)).setAttribute("ancho","150" );
      ((Element)v.get(625)).setAttribute("alto","13" );
      ((Element)v.get(625)).setAttribute("cod","PedTipoSolicPais.tsolOidTipoCons.label" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:626 / Elemento padre: 622   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(626)).setAttribute("nombre","tsolOidTipoConsWidgetTrId" );
      ((Element)v.get(622)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(627)).setAttribute("align","left" );
      ((Element)v.get(627)).setAttribute("nowrap","true" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(628)).setAttribute("nombre","tsolOidTipoCons" );
      ((Element)v.get(628)).setAttribute("id","datosCampos" );
      ((Element)v.get(628)).setAttribute("multiple","N" );
      ((Element)v.get(628)).setAttribute("req","N" );
      ((Element)v.get(628)).setAttribute("size","1" );
      ((Element)v.get(628)).setAttribute("disabled","" );
      ((Element)v.get(628)).setAttribute("validacion","" );
      ((Element)v.get(628)).setAttribute("onchange","" );
      ((Element)v.get(628)).setAttribute("onfocus","" );
      ((Element)v.get(628)).setAttribute("valorinicial","" );
      ((Element)v.get(628)).setAttribute("textoinicial","" );
      ((Element)v.get(628)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicPaisFrm',25, true);" );
      ((Element)v.get(628)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicPaisFrm',25, false);" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:626   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:630 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(630)).setAttribute("nombre","tsolOidTipoConsGapTdId" );
      ((Element)v.get(630)).setAttribute("nowrap","true" );
      ((Element)v.get(630)).setAttribute("class","datosCampos" );
      ((Element)v.get(620)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","25" );
      ((Element)v.get(631)).setAttribute("height","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(632)).setAttribute("width","100%" );
      ((Element)v.get(620)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:634 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(634)).setAttribute("width","100%" );
      ((Element)v.get(615)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:615   */

      /* Empieza nodo:635 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(635)).setAttribute("nombre","formGapTr23" );
      ((Element)v.get(15)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(636)).setAttribute("align","center" );
      ((Element)v.get(636)).setAttribute("width","8" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(637)).setAttribute("src","b.gif" );
      ((Element)v.get(637)).setAttribute("width","8" );
      ((Element)v.get(637)).setAttribute("height","8" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 635   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(635)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(639)).setAttribute("src","b.gif" );
      ((Element)v.get(639)).setAttribute("width","8" );
      ((Element)v.get(639)).setAttribute("height","8" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:640 / Elemento padre: 635   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(640)).setAttribute("align","center" );
      ((Element)v.get(640)).setAttribute("width","8" );
      ((Element)v.get(635)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(641)).setAttribute("width","8" );
      ((Element)v.get(641)).setAttribute("height","8" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */
      /* Termina nodo:635   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:642 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(642)).setAttribute("align","center" );
      ((Element)v.get(642)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(643)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).setAttribute("width","12" );
      ((Element)v.get(643)).setAttribute("height","12" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */
      /* Termina nodo:8   */

      /* Empieza nodo:644 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(644)).setAttribute("nombre","pedTipoSolicPaisTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(645)).setAttribute("align","center" );
      ((Element)v.get(645)).setAttribute("width","12" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(646)).setAttribute("src","b.gif" );
      ((Element)v.get(646)).setAttribute("width","12" );
      ((Element)v.get(646)).setAttribute("height","12" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */

      /* Empieza nodo:647 / Elemento padre: 644   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(644)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(647)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(649)).setAttribute("width","100%" );
      ((Element)v.get(649)).setAttribute("border","0" );
      ((Element)v.get(649)).setAttribute("align","center" );
      ((Element)v.get(649)).setAttribute("cellspacing","0" );
      ((Element)v.get(649)).setAttribute("cellpadding","0" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(651)).setAttribute("class","tablaTitle" );
      ((Element)v.get(651)).setAttribute("nombre","pedTipoSolicPaisTdQueryButton" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(652)).setAttribute("nombre","pedTipoSolicPaisQueryButton" );
      ((Element)v.get(652)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(652)).setAttribute("estado","false" );
      ((Element)v.get(652)).setAttribute("accion","pedTipoSolicPaisFirstPage();" );
      ((Element)v.get(652)).setAttribute("tipo","html" );
      ((Element)v.get(652)).setAttribute("ID","botonContenido" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:651   */

      /* Empieza nodo:653 / Elemento padre: 650   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(653)).setAttribute("class","tablaTitle" );
      ((Element)v.get(653)).setAttribute("nombre","pedTipoSolicPaisTdLovNullSelectionButton" );
      ((Element)v.get(653)).setAttribute("align","left" );
      ((Element)v.get(653)).setAttribute("width","100%" );
      ((Element)v.get(650)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(654)).setAttribute("src","b.gif" );
      ((Element)v.get(654)).setAttribute("height","8" );
      ((Element)v.get(654)).setAttribute("width","8" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 653   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(655)).setAttribute("nombre","pedTipoSolicPaisLovNullButton" );
      ((Element)v.get(655)).setAttribute("ID","botonContenido" );
      ((Element)v.get(655)).setAttribute("tipo","html" );
      ((Element)v.get(655)).setAttribute("accion","pedTipoSolicPaisLovNullSelectionAction();" );
      ((Element)v.get(655)).setAttribute("estado","true" );
      ((Element)v.get(655)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(653)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:653   */
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:648   */
      /* Termina nodo:647   */

      /* Empieza nodo:656 / Elemento padre: 644   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(656)).setAttribute("align","center" );
      ((Element)v.get(656)).setAttribute("width","12" );
      ((Element)v.get(644)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","12" );
      ((Element)v.get(657)).setAttribute("height","12" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */
      /* Termina nodo:644   */


   }

}
