
import org.w3c.dom.*;
import java.util.ArrayList;

public class CccCuentContaPageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","CccCuentConta.legend.label" );
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
      ((Element)v.get(29)).setAttribute("cod","CccCuentConta.id.label" );
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
      ((Element)v.get(32)).setAttribute("ontab","ejecutarAccionFoco('cccCuentContaFrm',1, true)" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('cccCuentContaFrm', 1, false)" );
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
      ((Element)v.get(54)).setAttribute("cod","CccCuentConta.paisOidPais.label" );
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
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('cccCuentContaFrm',2, true);" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('cccCuentContaFrm',2, false);" );
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
      ((Element)v.get(76)).setAttribute("nombre","codCuenContTdId" );
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
      ((Element)v.get(80)).setAttribute("nombre","lblCodCuenCont" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","CccCuentConta.codCuenCont.label" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 77   */
      v.add(doc.createElement("TR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("nombre","codCuenContWidgetTrId" );
      ((Element)v.get(77)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(82)).setAttribute("align","left" );
      ((Element)v.get(82)).setAttribute("nowrap","true" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(83)).setAttribute("nombre","codCuenCont" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("trim","S" );
      ((Element)v.get(83)).setAttribute("max","4" );
      ((Element)v.get(83)).setAttribute("onchange","" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("size","4" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("validacion","" );
      ((Element)v.get(83)).setAttribute("disabled","" );
      ((Element)v.get(83)).setAttribute("onblur","" );
      ((Element)v.get(83)).setAttribute("ontab","ejecutarAccionFoco('cccCuentContaFrm',3, true)" );
      ((Element)v.get(83)).setAttribute("onshtab","ejecutarAccionFoco('cccCuentContaFrm', 3, false)" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:84 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("nombre","codCuenContGapTdId" );
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
      ((Element)v.get(86)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(75)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).setAttribute("align","left" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(89)).setAttribute("valign","top" );
      ((Element)v.get(89)).setAttribute("height","13" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","CccCuentConta.Descripcion.label" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(91)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(91)).setAttribute("colspan","2" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:88   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(87)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(94)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("trim","S" );
      ((Element)v.get(94)).setAttribute("max","30" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","30" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("disabled","" );
      ((Element)v.get(94)).setAttribute("onblur","" );
      ((Element)v.get(94)).setAttribute("ontab","ejecutarAccionFoco('cccCuentContaFrm',4, true)" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('cccCuentContaFrm', 4, false)" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(97)).setAttribute("align","left" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(97)).setAttribute("nowrap","true" );
      ((Element)v.get(97)).setAttribute("valign","bottom" );
      ((Element)v.get(92)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("A"));
      ((Element)v.get(98)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(98)).setAttribute("href","javascript:openLocalizationDialog('cccCuentContaFrm', 'Descripcion', 1);" );
      ((Element)v.get(98)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"cccCuentContaFrm\",4, true)', 'ejecutarAccionFoco(\"cccCuentContaFrm\",4, false)')" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(99)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("width","21" );
      ((Element)v.get(99)).setAttribute("height","15" );
      ((Element)v.get(99)).setAttribute("class","main" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:92   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:100 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(100)).setAttribute("nowrap","true" );
      ((Element)v.get(100)).setAttribute("class","datosCampos" );
      ((Element)v.get(75)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("nombre","codCuenSapTdId" );
      ((Element)v.get(75)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("valign","top" );
      ((Element)v.get(105)).setAttribute("height","13" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblCodCuenSap" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","CccCuentConta.codCuenSap.label" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:107 / Elemento padre: 103   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).setAttribute("nombre","codCuenSapWidgetTrId" );
      ((Element)v.get(103)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(108)).setAttribute("nowrap","true" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(109)).setAttribute("nombre","codCuenSap" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("trim","S" );
      ((Element)v.get(109)).setAttribute("max","10" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("size","10" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("validacion","" );
      ((Element)v.get(109)).setAttribute("disabled","" );
      ((Element)v.get(109)).setAttribute("onblur","" );
      ((Element)v.get(109)).setAttribute("ontab","ejecutarAccionFoco('cccCuentContaFrm',5, true)" );
      ((Element)v.get(109)).setAttribute("onshtab","ejecutarAccionFoco('cccCuentContaFrm', 5, false)" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:110 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("nombre","codCuenSapGapTdId" );
      ((Element)v.get(110)).setAttribute("nowrap","true" );
      ((Element)v.get(110)).setAttribute("class","datosCampos" );
      ((Element)v.get(75)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(75)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:70   */

      /* Empieza nodo:114 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(114)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:114   */

      /* Empieza nodo:121 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(121)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","12" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).setAttribute("nombre","valObseTdId" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(128)).setAttribute("width","100%" );
      ((Element)v.get(128)).setAttribute("border","0" );
      ((Element)v.get(128)).setAttribute("cellspacing","0" );
      ((Element)v.get(128)).setAttribute("cellpadding","0" );
      ((Element)v.get(128)).setAttribute("align","left" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("valign","top" );
      ((Element)v.get(130)).setAttribute("height","13" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblValObse" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","CccCuentConta.valObse.label" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:132 / Elemento padre: 128   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(132)).setAttribute("nombre","valObseWidgetTrId" );
      ((Element)v.get(128)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(133)).setAttribute("nowrap","true" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(134)).setAttribute("nombre","valObse" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("rows","3" );
      ((Element)v.get(134)).setAttribute("cols","40" );
      ((Element)v.get(134)).setAttribute("validacion","" );
      ((Element)v.get(134)).setAttribute("disabled","" );
      ((Element)v.get(134)).setAttribute("req","N" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(134)).setAttribute("onblur","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(134)).setAttribute("onfocus","" );
      ((Element)v.get(134)).setAttribute("onchange","" );
      ((Element)v.get(134)).setAttribute("ontab","ejecutarAccionFoco('cccCuentContaFrm',6, true)" );
      ((Element)v.get(134)).setAttribute("onshtab","ejecutarAccionFoco('cccCuentContaFrm',6, false)" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:135 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).setAttribute("nombre","valObseGapTdId" );
      ((Element)v.get(135)).setAttribute("nowrap","true" );
      ((Element)v.get(135)).setAttribute("class","datosCampos" );
      ((Element)v.get(126)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:139 / Elemento padre: 121   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(121)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:121   */

      /* Empieza nodo:140 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(140)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
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
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:140   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:147 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(147)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:8   */

      /* Empieza nodo:149 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(149)).setAttribute("nombre","cccCuentContaTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(151)).setAttribute("height","12" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(154)).setAttribute("border","0" );
      ((Element)v.get(154)).setAttribute("align","center" );
      ((Element)v.get(154)).setAttribute("cellspacing","0" );
      ((Element)v.get(154)).setAttribute("cellpadding","0" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(156)).setAttribute("class","tablaTitle" );
      ((Element)v.get(156)).setAttribute("nombre","cccCuentContaTdQueryButton" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(157)).setAttribute("nombre","cccCuentContaQueryButton" );
      ((Element)v.get(157)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(157)).setAttribute("estado","false" );
      ((Element)v.get(157)).setAttribute("accion","cccCuentContaFirstPage();" );
      ((Element)v.get(157)).setAttribute("tipo","html" );
      ((Element)v.get(157)).setAttribute("ID","botonContenido" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("class","tablaTitle" );
      ((Element)v.get(158)).setAttribute("nombre","cccCuentContaTdLovNullSelectionButton" );
      ((Element)v.get(158)).setAttribute("align","left" );
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 158   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(160)).setAttribute("nombre","cccCuentContaLovNullButton" );
      ((Element)v.get(160)).setAttribute("ID","botonContenido" );
      ((Element)v.get(160)).setAttribute("tipo","html" );
      ((Element)v.get(160)).setAttribute("accion","cccCuentContaLovNullSelectionAction();" );
      ((Element)v.get(160)).setAttribute("estado","true" );
      ((Element)v.get(160)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(158)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:158   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:161 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("align","center" );
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(149)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(162)).setAttribute("height","12" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:149   */


   }

}
