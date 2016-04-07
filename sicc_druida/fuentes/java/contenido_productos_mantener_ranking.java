
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_mantener_ranking  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_mantener_ranking" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","init();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_productos_mantener_ranking.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","pestanyas_concurso_ranking_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbProductos" );
      ((Element)v.get(5)).setAttribute("group","combo" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","515" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","yaEntroAModal" );
      ((Element)v.get(11)).setAttribute("valor","NO" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","valorMenu" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hIndEstadoParametrosGerentes" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hIndEstadoParametrosConsultoras" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hIndEstadoVariablesVenta" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","ocultarPestanyas" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(19)).setAttribute("width","100%" );
      ((Element)v.get(19)).setAttribute("height","100%" );
      ((Element)v.get(19)).setAttribute("border","0" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(19)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).setAttribute("cellspacing","0" );
      ((Element)v.get(19)).setAttribute("class","menu4" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(21)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","30" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(23)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));

      /* Elemento padre:23 / Elemento actual: 24   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(23)).appendChild((Text)v.get(24));

      /* Termina nodo Texto:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","10" );
      ((Element)v.get(25)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(25)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","10" );
      ((Element)v.get(26)).setAttribute("height","8" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","92" );
      ((Element)v.get(27)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(27)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","75" );
      ((Element)v.get(28)).setAttribute("border","1" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(28)).setAttribute("cellpadding","1" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(28)).setAttribute("onmouseover","activarPuntero('formulario', 1, 'lblDatosGenerales');" );
      ((Element)v.get(28)).setAttribute("onclick","onClickPestanyaHabilitadaSS(1, 'formulario', 'LPMantenerProductosRanking');" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(30)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(31)).setAttribute("cod","0011" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:32 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","10" );
      ((Element)v.get(32)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","10" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","20" );
      ((Element)v.get(34)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(34)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","75" );
      ((Element)v.get(35)).setAttribute("border","1" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellpadding","1" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(35)).setAttribute("onmouseover","activarPuntero('formulario', 2, 'lblAlcanceGeografico');" );
      ((Element)v.get(35)).setAttribute("onclick","onClickPestanyaHabilitadaSS(2, 'formulario', 'LPMantenerProductosRanking');" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(38)).setAttribute("alto","13" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(38)).setAttribute("cod","00368" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:39 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","10" );
      ((Element)v.get(39)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","10" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","20" );
      ((Element)v.get(41)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","75" );
      ((Element)v.get(42)).setAttribute("border","1" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cellpadding","1" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(42)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblParametrosGerentes');" );
      ((Element)v.get(42)).setAttribute("onclick","onClickPestanyaHabilitadaSS(3, 'formulario', 'LPMantenerProductosRanking');" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblParametrosGerentes" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(45)).setAttribute("cod","00594" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:46 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","10" );
      ((Element)v.get(46)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","10" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","20" );
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","75" );
      ((Element)v.get(49)).setAttribute("border","1" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellpadding","1" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(49)).setAttribute("onmouseover","activarPuntero('formulario', 4, 'lblParametrosConsultoras');" );
      ((Element)v.get(49)).setAttribute("onclick","onClickPestanyaHabilitadaSS(4, 'formulario', 'LPMantenerProductosRanking');" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblParametrosConsultoras" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(52)).setAttribute("cod","00595" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:53 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","16" );
      ((Element)v.get(53)).setAttribute("class","menu5texto" );
      ((Element)v.get(20)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","12" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:55 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("height","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("class","menu4" );
      ((Element)v.get(6)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(58)).setAttribute("height","30" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Elemento padre:59 / Elemento actual: 60   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(59)).appendChild((Text)v.get(60));

      /* Termina nodo Texto:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","20" );
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","75" );
      ((Element)v.get(64)).setAttribute("border","1" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellpadding","1" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(64)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(64)).setAttribute("onmouseover","activarPuntero('formulario', 5, 'lblProductos');" );
      ((Element)v.get(64)).setAttribute("onclick","onClickPestanyaHabilitadaSS(5,'formulario', 'LPMantenerProductosRanking');" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(67)).setAttribute("cod","0094" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:68 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","10" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","10" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","20" );
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","75" );
      ((Element)v.get(71)).setAttribute("border","1" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellpadding","1" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(71)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(71)).setAttribute("onmouseover","activarPuntero('formulario', 6, 'lblPremios');" );
      ((Element)v.get(71)).setAttribute("onclick","onClickPestanyaHabilitadaSS(6, 'formulario', 'LPMantenerProductosRanking');" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(74)).setAttribute("cod","00394" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:75 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","10" );
      ((Element)v.get(75)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","10" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","20" );
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","75" );
      ((Element)v.get(78)).setAttribute("border","1" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(78)).setAttribute("cellpadding","1" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(78)).setAttribute("onmouseover","activarPuntero('formulario', 7, 'lblVariablesVenta');" );
      ((Element)v.get(78)).setAttribute("onclick","onClickPestanyaHabilitadaSS(7, 'formulario', 'LPMantenerProductosRanking');" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblVariablesVenta" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(81)).setAttribute("cod","1951" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:82 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","16" );
      ((Element)v.get(82)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:84 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(84)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","12" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","12" );
      ((Element)v.get(88)).setAttribute("height","12" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","750" );
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(86)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","1" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:86   */

      /* Empieza nodo:93 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(98)).setAttribute("class","legend" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblMantenerProductos" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","legend" );
      ((Element)v.get(99)).setAttribute("cod","00333" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","500" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("colspan","4" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:107 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblProductos2" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("id","datosTitle" );
      ((Element)v.get(111)).setAttribute("cod","515" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:107   */

      /* Empieza nodo:114 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(118)).setAttribute("nombre","cbProductos" );
      ((Element)v.get(118)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAceptar');" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("size","1" );
      ((Element)v.get(118)).setAttribute("multiple","N" );
      ((Element)v.get(118)).setAttribute("req","S" );
      ((Element)v.get(118)).setAttribute("valorinicial","" );
      ((Element)v.get(118)).setAttribute("textoinicial","" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:120 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:114   */

      /* Empieza nodo:122 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("colspan","4" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:125 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:93   */

      /* Empieza nodo:127 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("class","botonera" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("tipo","html" );
      ((Element)v.get(135)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(135)).setAttribute("ontab","focaliza('formulario.cbProductos');" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("cod","12" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:127   */

      /* Empieza nodo:138 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("height","12" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","756" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","1" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:138   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:6   */


   }

}
