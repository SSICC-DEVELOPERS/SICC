
import org.w3c.dom.*;
import java.util.ArrayList;

public class ZonTerriPageForm  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(14)).setAttribute("cod","ZonTerri.legend.label" );
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
      ((Element)v.get(25)).setAttribute("nombre","paisOidPais_fopaOidFormPagoTdId" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(29)).setAttribute("nombre","lblpaisOidPais_fopaOidFormPago" );
      ((Element)v.get(29)).setAttribute("id","datosTitle" );
      ((Element)v.get(29)).setAttribute("ancho","100" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:30 / Elemento padre: 26   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(30)).setAttribute("nombre","paisOidPais_fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(26)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(31)).setAttribute("align","left" );
      ((Element)v.get(31)).setAttribute("nowrap","true" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(32)).setAttribute("nombre","paisOidPais_fopaOidFormPago" );
      ((Element)v.get(32)).setAttribute("id","datosCampos" );
      ((Element)v.get(32)).setAttribute("multiple","N" );
      ((Element)v.get(32)).setAttribute("req","N" );
      ((Element)v.get(32)).setAttribute("size","1" );
      ((Element)v.get(32)).setAttribute("disabled","" );
      ((Element)v.get(32)).setAttribute("validacion","" );
      ((Element)v.get(32)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'zonTerri')" );
      ((Element)v.get(32)).setAttribute("onfocus","" );
      ((Element)v.get(32)).setAttribute("valorinicial","" );
      ((Element)v.get(32)).setAttribute("textoinicial","" );
      ((Element)v.get(32)).setAttribute("ontab","focaliza('zonTerriFrm.paisOidPais_moneOidMoneAlt');" );
      ((Element)v.get(32)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm',0, false);" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:34 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(34)).setAttribute("nombre","paisOidPais_fopaOidFormPagoGapTdId" );
      ((Element)v.get(34)).setAttribute("nowrap","true" );
      ((Element)v.get(34)).setAttribute("class","datosCampos" );
      ((Element)v.get(24)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","25" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(36)).setAttribute("nombre","paisOidPais_moneOidMoneAltTdId" );
      ((Element)v.get(24)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).setAttribute("align","left" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(39)).setAttribute("valign","top" );
      ((Element)v.get(39)).setAttribute("height","13" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblpaisOidPais_moneOidMoneAlt" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("id","datosTitle" );
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(41)).setAttribute("nombre","paisOidPais_moneOidMoneAltWidgetTrId" );
      ((Element)v.get(37)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(42)).setAttribute("align","left" );
      ((Element)v.get(42)).setAttribute("nowrap","true" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(43)).setAttribute("nombre","paisOidPais_moneOidMoneAlt" );
      ((Element)v.get(43)).setAttribute("id","datosCampos" );
      ((Element)v.get(43)).setAttribute("multiple","N" );
      ((Element)v.get(43)).setAttribute("req","N" );
      ((Element)v.get(43)).setAttribute("size","1" );
      ((Element)v.get(43)).setAttribute("disabled","" );
      ((Element)v.get(43)).setAttribute("validacion","" );
      ((Element)v.get(43)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'zonTerri')" );
      ((Element)v.get(43)).setAttribute("onfocus","" );
      ((Element)v.get(43)).setAttribute("valorinicial","" );
      ((Element)v.get(43)).setAttribute("textoinicial","" );
      ((Element)v.get(43)).setAttribute("ontab","focaliza('zonTerriFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(43)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm',0, false);" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:45 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(45)).setAttribute("nombre","paisOidPais_moneOidMoneAltGapTdId" );
      ((Element)v.get(45)).setAttribute("nowrap","true" );
      ((Element)v.get(45)).setAttribute("class","datosCampos" );
      ((Element)v.get(24)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","25" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(47)).setAttribute("nombre","paisOidPais_moneOidMoneTdId" );
      ((Element)v.get(24)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).setAttribute("align","left" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("valign","top" );
      ((Element)v.get(50)).setAttribute("height","13" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblpaisOidPais_moneOidMone" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("ancho","100" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:52 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(52)).setAttribute("nombre","paisOidPais_moneOidMoneWidgetTrId" );
      ((Element)v.get(48)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("align","left" );
      ((Element)v.get(53)).setAttribute("nowrap","true" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(54)).setAttribute("nombre","paisOidPais_moneOidMone" );
      ((Element)v.get(54)).setAttribute("id","datosCampos" );
      ((Element)v.get(54)).setAttribute("multiple","N" );
      ((Element)v.get(54)).setAttribute("req","N" );
      ((Element)v.get(54)).setAttribute("size","1" );
      ((Element)v.get(54)).setAttribute("disabled","" );
      ((Element)v.get(54)).setAttribute("validacion","" );
      ((Element)v.get(54)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'zonTerri')" );
      ((Element)v.get(54)).setAttribute("onfocus","" );
      ((Element)v.get(54)).setAttribute("valorinicial","" );
      ((Element)v.get(54)).setAttribute("textoinicial","" );
      ((Element)v.get(54)).setAttribute("ontab","focaliza('zonTerriFrm.paisOidPais');" );
      ((Element)v.get(54)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm',0, false);" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:56 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("nombre","paisOidPais_moneOidMoneGapTdId" );
      ((Element)v.get(56)).setAttribute("nowrap","true" );
      ((Element)v.get(56)).setAttribute("class","datosCampos" );
      ((Element)v.get(24)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","25" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(24)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).setAttribute("align","left" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(61)).setAttribute("valign","top" );
      ((Element)v.get(61)).setAttribute("height","13" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("ancho","100" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("cod","ZonTerri.paisOidPais.label" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:63 / Elemento padre: 59   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(63)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(59)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(64)).setAttribute("align","left" );
      ((Element)v.get(64)).setAttribute("nowrap","true" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(65)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(65)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).setAttribute("multiple","N" );
      ((Element)v.get(65)).setAttribute("req","N" );
      ((Element)v.get(65)).setAttribute("size","1" );
      ((Element)v.get(65)).setAttribute("disabled","" );
      ((Element)v.get(65)).setAttribute("validacion","" );
      ((Element)v.get(65)).setAttribute("onchange","" );
      ((Element)v.get(65)).setAttribute("onfocus","" );
      ((Element)v.get(65)).setAttribute("valorinicial","" );
      ((Element)v.get(65)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true);" );
      ((Element)v.get(65)).setAttribute("onshtab","focaliza('zonTerriFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:67 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(67)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(67)).setAttribute("nowrap","true" );
      ((Element)v.get(67)).setAttribute("class","datosCampos" );
      ((Element)v.get(24)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(24)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:19   */

      /* Empieza nodo:71 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(71)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(15)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:71   */

      /* Empieza nodo:78 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(78)).setAttribute("nombre","formTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","12" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).setAttribute("align","left" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(83)).setAttribute("align","left" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("nombre","idTdId" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

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
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("valign","top" );
      ((Element)v.get(87)).setAttribute("height","13" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblId" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","ZonTerri.id.label" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 85   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(89)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(85)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(90)).setAttribute("align","left" );
      ((Element)v.get(90)).setAttribute("nowrap","true" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(91)).setAttribute("nombre","id" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("trim","S" );
      ((Element)v.get(91)).setAttribute("max","12" );
      ((Element)v.get(91)).setAttribute("onchange","" );
      ((Element)v.get(91)).setAttribute("req","N" );
      ((Element)v.get(91)).setAttribute("size","12" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("validacion","" );
      ((Element)v.get(91)).setAttribute("disabled","" );
      ((Element)v.get(91)).setAttribute("onblur","" );
      ((Element)v.get(91)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true)" );
      ((Element)v.get(91)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm', 0, false)" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:92 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(92)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(92)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).setAttribute("class","datosCampos" );
      ((Element)v.get(83)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:78   */

      /* Empieza nodo:96 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(96)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(15)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","12" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:96   */

      /* Empieza nodo:103 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(103)).setAttribute("nombre","formTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("align","center" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","12" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).setAttribute("align","left" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("nombre","codTerrTdId" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

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
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("valign","top" );
      ((Element)v.get(112)).setAttribute("height","13" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblCodTerr" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","ZonTerri.codTerr.label" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(114)).setAttribute("nombre","codTerrWidgetTrId" );
      ((Element)v.get(110)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("align","left" );
      ((Element)v.get(115)).setAttribute("nowrap","true" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(116)).setAttribute("nombre","codTerr" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).setAttribute("trim","S" );
      ((Element)v.get(116)).setAttribute("max","6" );
      ((Element)v.get(116)).setAttribute("onchange","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(116)).setAttribute("req","N" );
      ((Element)v.get(116)).setAttribute("size","6" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("validacion","" );
      ((Element)v.get(116)).setAttribute("disabled","" );
      ((Element)v.get(116)).setAttribute("onblur","" );
      ((Element)v.get(116)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true)" );
      ((Element)v.get(116)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm', 0, false)" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:117 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(117)).setAttribute("nombre","codTerrGapTdId" );
      ((Element)v.get(117)).setAttribute("nowrap","true" );
      ((Element)v.get(117)).setAttribute("class","datosCampos" );
      ((Element)v.get(108)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","25" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(108)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:103   */

      /* Empieza nodo:121 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(121)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(15)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","12" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("align","center" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:121   */

      /* Empieza nodo:128 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(128)).setAttribute("nombre","formTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","12" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(132)).setAttribute("align","left" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("nombre","codNse1TdId" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

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
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("valign","top" );
      ((Element)v.get(137)).setAttribute("height","13" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblCodNse1" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","ZonTerri.codNse1.label" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:139 / Elemento padre: 135   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(139)).setAttribute("nombre","codNse1WidgetTrId" );
      ((Element)v.get(135)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("align","left" );
      ((Element)v.get(140)).setAttribute("nowrap","true" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(141)).setAttribute("nombre","codNse1" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("trim","S" );
      ((Element)v.get(141)).setAttribute("max","2" );
      ((Element)v.get(141)).setAttribute("onchange","" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(141)).setAttribute("size","2" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(141)).setAttribute("validacion","" );
      ((Element)v.get(141)).setAttribute("disabled","" );
      ((Element)v.get(141)).setAttribute("onblur","" );
      ((Element)v.get(141)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true)" );
      ((Element)v.get(141)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm', 0, false)" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:142 / Elemento padre: 133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).setAttribute("nombre","codNse1GapTdId" );
      ((Element)v.get(142)).setAttribute("nowrap","true" );
      ((Element)v.get(142)).setAttribute("class","datosCampos" );
      ((Element)v.get(133)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","25" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(133)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:128   */

      /* Empieza nodo:146 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(146)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(15)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:146   */

      /* Empieza nodo:153 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(153)).setAttribute("nombre","formTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("align","center" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","12" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(157)).setAttribute("align","left" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(158)).setAttribute("align","left" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("nombre","codNse2TdId" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).setAttribute("align","left" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("valign","top" );
      ((Element)v.get(162)).setAttribute("height","13" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lblCodNse2" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("filas","1" );
      ((Element)v.get(163)).setAttribute("id","datosTitle" );
      ((Element)v.get(163)).setAttribute("cod","ZonTerri.codNse2.label" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(164)).setAttribute("nombre","codNse2WidgetTrId" );
      ((Element)v.get(160)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("align","left" );
      ((Element)v.get(165)).setAttribute("nowrap","true" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(166)).setAttribute("nombre","codNse2" );
      ((Element)v.get(166)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).setAttribute("trim","S" );
      ((Element)v.get(166)).setAttribute("max","2" );
      ((Element)v.get(166)).setAttribute("onchange","" );
      ((Element)v.get(166)).setAttribute("req","N" );
      ((Element)v.get(166)).setAttribute("size","2" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("validacion","" );
      ((Element)v.get(166)).setAttribute("disabled","" );
      ((Element)v.get(166)).setAttribute("onblur","" );
      ((Element)v.get(166)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true)" );
      ((Element)v.get(166)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm', 0, false)" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:167 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("nombre","codNse2GapTdId" );
      ((Element)v.get(167)).setAttribute("nowrap","true" );
      ((Element)v.get(167)).setAttribute("class","datosCampos" );
      ((Element)v.get(158)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(158)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:153   */

      /* Empieza nodo:171 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(171)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(15)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("align","center" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:171   */

      /* Empieza nodo:178 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(178)).setAttribute("nombre","formTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","12" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(182)).setAttribute("border","0" );
      ((Element)v.get(182)).setAttribute("cellspacing","0" );
      ((Element)v.get(182)).setAttribute("cellpadding","0" );
      ((Element)v.get(182)).setAttribute("align","left" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("nombre","codNse3TdId" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(185)).setAttribute("border","0" );
      ((Element)v.get(185)).setAttribute("cellspacing","0" );
      ((Element)v.get(185)).setAttribute("cellpadding","0" );
      ((Element)v.get(185)).setAttribute("align","left" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("valign","top" );
      ((Element)v.get(187)).setAttribute("height","13" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblCodNse3" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","ZonTerri.codNse3.label" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:189 / Elemento padre: 185   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(189)).setAttribute("nombre","codNse3WidgetTrId" );
      ((Element)v.get(185)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("align","left" );
      ((Element)v.get(190)).setAttribute("nowrap","true" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(191)).setAttribute("nombre","codNse3" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("trim","S" );
      ((Element)v.get(191)).setAttribute("max","2" );
      ((Element)v.get(191)).setAttribute("onchange","" );
      ((Element)v.get(191)).setAttribute("req","N" );
      ((Element)v.get(191)).setAttribute("size","2" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("validacion","" );
      ((Element)v.get(191)).setAttribute("disabled","" );
      ((Element)v.get(191)).setAttribute("onblur","" );
      ((Element)v.get(191)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true)" );
      ((Element)v.get(191)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm', 0, false)" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:192 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("nombre","codNse3GapTdId" );
      ((Element)v.get(192)).setAttribute("nowrap","true" );
      ((Element)v.get(192)).setAttribute("class","datosCampos" );
      ((Element)v.get(183)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:178   */

      /* Empieza nodo:196 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(196)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(15)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:196   */

      /* Empieza nodo:203 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(203)).setAttribute("nombre","formTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

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
      ((Element)v.get(208)).setAttribute("align","left" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("nombre","indBorrTdId" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

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
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("valign","top" );
      ((Element)v.get(212)).setAttribute("height","13" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblIndBorr" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","ZonTerri.indBorr.label" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:214 / Elemento padre: 210   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(214)).setAttribute("nombre","indBorrWidgetTrId" );
      ((Element)v.get(210)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("align","left" );
      ((Element)v.get(215)).setAttribute("nowrap","true" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(216)).setAttribute("nombre","indBorr" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("trim","S" );
      ((Element)v.get(216)).setAttribute("max","1" );
      ((Element)v.get(216)).setAttribute("onchange","" );
      ((Element)v.get(216)).setAttribute("req","N" );
      ((Element)v.get(216)).setAttribute("size","1" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("validacion","" );
      ((Element)v.get(216)).setAttribute("disabled","" );
      ((Element)v.get(216)).setAttribute("onblur","" );
      ((Element)v.get(216)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true)" );
      ((Element)v.get(216)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm', 0, false)" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).setAttribute("nombre","indBorrGapTdId" );
      ((Element)v.get(217)).setAttribute("nowrap","true" );
      ((Element)v.get(217)).setAttribute("class","datosCampos" );
      ((Element)v.get(208)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("width","100%" );
      ((Element)v.get(208)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:203   */

      /* Empieza nodo:221 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(221)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(15)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("align","center" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","12" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:221   */

      /* Empieza nodo:228 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(228)).setAttribute("nombre","formTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(232)).setAttribute("align","left" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(233)).setAttribute("align","left" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("nombre","vepoOidValoEstrGeopTdId" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
   }

   private void getXML1080(Document doc) {
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
      ((Element)v.get(238)).setAttribute("nombre","lblvepoOidValoEstrGeop" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("ancho","100" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("cod","ZonTerri.vepoOidValoEstrGeop.label" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 235   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(239)).setAttribute("nombre","vepoOidValoEstrGeopWidgetTrId" );
      ((Element)v.get(235)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(240)).setAttribute("align","left" );
      ((Element)v.get(240)).setAttribute("nowrap","true" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(241)).setAttribute("nombre","vepoOidValoEstrGeop" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("multiple","N" );
      ((Element)v.get(241)).setAttribute("req","N" );
      ((Element)v.get(241)).setAttribute("size","1" );
      ((Element)v.get(241)).setAttribute("disabled","" );
      ((Element)v.get(241)).setAttribute("validacion","" );
      ((Element)v.get(241)).setAttribute("onchange","" );
      ((Element)v.get(241)).setAttribute("onfocus","" );
      ((Element)v.get(241)).setAttribute("valorinicial","" );
      ((Element)v.get(241)).setAttribute("textoinicial","" );
      ((Element)v.get(241)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true);" );
      ((Element)v.get(241)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm',0, false);" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:243 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("nombre","vepoOidValoEstrGeopGapTdId" );
      ((Element)v.get(243)).setAttribute("nowrap","true" );
      ((Element)v.get(243)).setAttribute("class","datosCampos" );
      ((Element)v.get(233)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:228   */

      /* Empieza nodo:247 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(247)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(15)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("align","center" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","12" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:247   */

      /* Empieza nodo:254 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(254)).setAttribute("nombre","formTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(255)).setAttribute("width","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","12" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(258)).setAttribute("width","100%" );
      ((Element)v.get(258)).setAttribute("border","0" );
      ((Element)v.get(258)).setAttribute("cellspacing","0" );
      ((Element)v.get(258)).setAttribute("cellpadding","0" );
      ((Element)v.get(258)).setAttribute("align","left" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(259)).setAttribute("align","left" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("nombre","fecRtzTdId" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

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
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("valign","top" );
      ((Element)v.get(263)).setAttribute("height","13" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblFecRtz" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
      ((Element)v.get(264)).setAttribute("cod","ZonTerri.fecRtz.label" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:265 / Elemento padre: 261   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(265)).setAttribute("nombre","fecRtzWidgetTrId" );
      ((Element)v.get(261)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("align","left" );
      ((Element)v.get(266)).setAttribute("nowrap","true" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(267)).setAttribute("nombre","fecRtz" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
      ((Element)v.get(267)).setAttribute("trim","S" );
      ((Element)v.get(267)).setAttribute("max","7" );
      ((Element)v.get(267)).setAttribute("onchange","" );
      ((Element)v.get(267)).setAttribute("req","N" );
      ((Element)v.get(267)).setAttribute("size","7" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("validacion","" );
      ((Element)v.get(267)).setAttribute("disabled","" );
      ((Element)v.get(267)).setAttribute("onblur","" );
      ((Element)v.get(267)).setAttribute("ontab","ejecutarAccionFoco('zonTerriFrm',0, true)" );
      ((Element)v.get(267)).setAttribute("onshtab","ejecutarAccionFoco('zonTerriFrm', 0, false)" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:268 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(268)).setAttribute("nombre","fecRtzGapTdId" );
      ((Element)v.get(268)).setAttribute("nowrap","true" );
      ((Element)v.get(268)).setAttribute("class","datosCampos" );
      ((Element)v.get(259)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","25" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(259)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:272 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(254)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:254   */

      /* Empieza nodo:273 / Elemento padre: 15   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(273)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(15)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("align","center" );
      ((Element)v.get(278)).setAttribute("width","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:273   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:280 / Elemento padre: 8   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("align","center" );
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","12" );
      ((Element)v.get(281)).setAttribute("height","12" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:8   */

      /* Empieza nodo:282 / Elemento padre: 0   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(282)).setAttribute("nombre","zonTerriTrButtons" );
      ((Element)v.get(0)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("width","12" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","12" );
      ((Element)v.get(284)).setAttribute("height","12" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(287)).setAttribute("width","100%" );
      ((Element)v.get(287)).setAttribute("border","0" );
      ((Element)v.get(287)).setAttribute("align","center" );
      ((Element)v.get(287)).setAttribute("cellspacing","0" );
      ((Element)v.get(287)).setAttribute("cellpadding","0" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("class","tablaTitle" );
      ((Element)v.get(289)).setAttribute("nombre","zonTerriTdQueryButton" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(290)).setAttribute("nombre","zonTerriQueryButton" );
      ((Element)v.get(290)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(290)).setAttribute("estado","false" );
      ((Element)v.get(290)).setAttribute("accion","zonTerriFirstPage();" );
      ((Element)v.get(290)).setAttribute("tipo","html" );
      ((Element)v.get(290)).setAttribute("ID","botonContenido" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("class","tablaTitle" );
      ((Element)v.get(291)).setAttribute("nombre","zonTerriTdLovNullSelectionButton" );
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(291)).setAttribute("width","100%" );
      ((Element)v.get(288)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 291   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(293)).setAttribute("nombre","zonTerriLovNullButton" );
      ((Element)v.get(293)).setAttribute("ID","botonContenido" );
      ((Element)v.get(293)).setAttribute("tipo","html" );
      ((Element)v.get(293)).setAttribute("accion","zonTerriLovNullSelectionAction();" );
      ((Element)v.get(293)).setAttribute("estado","true" );
      ((Element)v.get(293)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(291)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:291   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:294 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("align","center" );
      ((Element)v.get(294)).setAttribute("width","12" );
      ((Element)v.get(282)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","12" );
      ((Element)v.get(295)).setAttribute("height","12" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:282   */


   }

}
