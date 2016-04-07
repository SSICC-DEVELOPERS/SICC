
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_despacho_premios_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_despacho_premios_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_despacho_premios_mantener.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hckComunicacionProcesoAutomatico" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hckComunicacionProcesoManual" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","htxtMensajesProcesoAutomatico" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","htxtMensajesProcesoManual" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidDespachoPremios" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("height","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("class","menu4" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(27)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","30" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(29)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Elemento padre:29 / Elemento actual: 30   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(29)).appendChild((Text)v.get(30));

      /* Termina nodo Texto:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","10" );
      ((Element)v.get(31)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(31)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","10" );
      ((Element)v.get(32)).setAttribute("height","8" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","92" );
      ((Element)v.get(33)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(33)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","75" );
      ((Element)v.get(34)).setAttribute("border","1" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(34)).setAttribute("cellpadding","1" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(34)).setAttribute("onmouseover","activarPuntero('formulario', '1', 'lblParametrosGenerales');" );
      ((Element)v.get(34)).setAttribute("onclick","onClickPestanyaPaginaDespacho(1, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(37)).setAttribute("cod","00393" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:38 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","10" );
      ((Element)v.get(38)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","10" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","20" );
      ((Element)v.get(40)).setAttribute("nowrap","nowrap" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","75" );
      ((Element)v.get(41)).setAttribute("border","1" );
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("cellpadding","1" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(41)).setAttribute("onmouseover","activarPuntero('formulario', 5, 'lblProductos');" );
      ((Element)v.get(41)).setAttribute("onclick","onClickPestanyaPaginaDespacho(5, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(44)).setAttribute("cod","0094" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:45 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","10" );
      ((Element)v.get(45)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","10" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","20" );
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","75" );
      ((Element)v.get(48)).setAttribute("border","1" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("cellpadding","1" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(48)).setAttribute("onmouseover","activarPuntero('formulario', 6, 'lblPremios');" );
      ((Element)v.get(48)).setAttribute("onclick","onClickPestanyaPaginaDespacho(6, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(51)).setAttribute("cod","00394" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:52 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","10" );
      ((Element)v.get(52)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","10" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","20" );
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","75" );
      ((Element)v.get(55)).setAttribute("border","1" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellpadding","1" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(55)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
      ((Element)v.get(55)).setAttribute("onclick","onClickPestanyaPaginaDespacho(7, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).setAttribute("align","center" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(58)).setAttribute("cod","00395" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:59 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","10" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","10" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","20" );
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","75" );
      ((Element)v.get(62)).setAttribute("border","1" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cellpadding","1" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(62)).setAttribute("onmouseover","activarPuntero('formulario', 4, 'lblObtencionPuntos');" );
      ((Element)v.get(62)).setAttribute("onclick","onClickPestanyaPaginaDespacho(4, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(65)).setAttribute("cod","00396" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:66 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","10" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","10" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","20" );
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(26)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","75" );
      ((Element)v.get(69)).setAttribute("border","1" );
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(69)).setAttribute("cellpadding","1" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(69)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(72)).setAttribute("cod","00397" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:73 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","16" );
      ((Element)v.get(73)).setAttribute("class","menu5texto" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(26)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:75 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(75)).setAttribute("height","100%" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("class","menu4" );
      ((Element)v.get(5)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("height","30" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Elemento padre:79 / Elemento actual: 80   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(79)).appendChild((Text)v.get(80));

      /* Termina nodo Texto:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","10" );
      ((Element)v.get(81)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","10" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","70" );
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","75" );
      ((Element)v.get(84)).setAttribute("border","1" );
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("cellpadding","1" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(84)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblAmbitoGeografico');" );
      ((Element)v.get(84)).setAttribute("onclick","onClickPestanyaPaginaDespacho(3, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(87)).setAttribute("cod","2801" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:88 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","10" );
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","10" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","70" );
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","75" );
      ((Element)v.get(91)).setAttribute("border","1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellpadding","1" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(91)).setAttribute("onmouseover","activarPuntero('formulario', 9, 'lblCalificacion');" );
      ((Element)v.get(91)).setAttribute("onclick","onClickPestanyaPaginaDespacho(9, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(94)).setAttribute("cod","00398" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:95 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","10" );
      ((Element)v.get(95)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","20" );
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","75" );
      ((Element)v.get(98)).setAttribute("border","1" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(98)).setAttribute("cellpadding","1" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(98)).setAttribute("onmouseover","activarPuntero('formulario', 10, 'lblGerentes');" );
      ((Element)v.get(98)).setAttribute("onclick","onClickPestanyaPaginaDespacho(10, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(101)).setAttribute("cod","00399" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:102 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","10" );
      ((Element)v.get(102)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","10" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","20" );
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("width","75" );
      ((Element)v.get(105)).setAttribute("border","1" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cellpadding","1" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(105)).setAttribute("onmouseover","activarPuntero('formulario', 11, 'lblConsultoras');" );
      ((Element)v.get(105)).setAttribute("onclick","onClickPestanyaPaginaDespacho(11, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(108)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(108)).setAttribute("cod","00401" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:109 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","10" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","10" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","20" );
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","75" );
      ((Element)v.get(112)).setAttribute("border","1" );
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(112)).setAttribute("cellpadding","1" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(112)).setAttribute("onmouseover","activarPuntero('formulario', 2, 'lblProgramaNuevas');" );
      ((Element)v.get(112)).setAttribute("onclick","onClickPestanyaPaginaDespacho(2, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(115)).setAttribute("cod","00590" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:116 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","10" );
      ((Element)v.get(116)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","10" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","20" );
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(119)).setAttribute("width","75" );
      ((Element)v.get(119)).setAttribute("border","1" );
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("cellpadding","1" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(119)).setAttribute("onmouseover","activarPuntero('formulario', '12', 'lblMultinivel');" );
      ((Element)v.get(119)).setAttribute("onclick","onClickPestanyaPaginaDespacho(12, 'formulario', 'LPMantenerDespachoPremios');" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(122)).setAttribute("cod","00400" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:123 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","16" );
      ((Element)v.get(123)).setAttribute("class","menu5texto" );
      ((Element)v.get(76)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","12" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:125 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(125)).setAttribute("nombre","capa1" );
      ((Element)v.get(125)).setAttribute("x","0" );
      ((Element)v.get(125)).setAttribute("y","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","750" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("height","1" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */

      /* Empieza nodo:134 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(139)).setAttribute("class","legend" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","legend" );
      ((Element)v.get(140)).setAttribute("cod","00282" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","507" );
      ((Element)v.get(144)).setAttribute("border","0" );
      ((Element)v.get(144)).setAttribute("align","left" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("colspan","3" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblComunicacionProcesoAutomatico" );
      ((Element)v.get(152)).setAttribute("alto","13" );
      ((Element)v.get(152)).setAttribute("filas","1" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(152)).setAttribute("id","datosTitle" );
      ((Element)v.get(152)).setAttribute("cod","1896" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblMensajesProcesoAutomatico" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(156)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).setAttribute("cod","531" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:148   */

      /* Empieza nodo:159 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("valing","bottom" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(163)).setAttribute("nombre","ckComunicacionProcesoAutomatico" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).setAttribute("onclick","onChangeComunicacionProcesoAutomatico();" );
      ((Element)v.get(163)).setAttribute("check","N" );
      ((Element)v.get(163)).setAttribute("onshtab","onShTabCkProcesoAutomatico();" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","25" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(166)).setAttribute("valing","bottom" );
      ((Element)v.get(159)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(167)).setAttribute("nombre","txtMensajesProcesoAutomatico" );
      ((Element)v.get(167)).setAttribute("id","datosCampos" );
      ((Element)v.get(167)).setAttribute("max","5" );
      ((Element)v.get(167)).setAttribute("tipo","" );
      ((Element)v.get(167)).setAttribute("onchange","" );
      ((Element)v.get(167)).setAttribute("req","N" );
      ((Element)v.get(167)).setAttribute("size","5" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("validacion","" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(159)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:159   */

      /* Empieza nodo:170 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("colspan","3" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:173 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("table"));
      ((Element)v.get(175)).setAttribute("width","507" );
      ((Element)v.get(175)).setAttribute("border","0" );
      ((Element)v.get(175)).setAttribute("align","left" );
      ((Element)v.get(175)).setAttribute("cellspacing","0" );
      ((Element)v.get(175)).setAttribute("cellpadding","0" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblComunicacionProcesoManual" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","1897" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblMensajesProcesoManual" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","531" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:176   */

      /* Empieza nodo:187 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("valing","bottom" );
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(191)).setAttribute("nombre","ckComunicacionProcesoManual" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("onclick","onChangeComunicacionProcesoManual();" );
      ((Element)v.get(191)).setAttribute("check","N" );
      ((Element)v.get(191)).setAttribute("ontab","onTabCkProcesoManual();" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).setAttribute("valing","bottom" );
      ((Element)v.get(187)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(195)).setAttribute("nombre","txtMensajesProcesoManual" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("max","5" );
      ((Element)v.get(195)).setAttribute("tipo","" );
      ((Element)v.get(195)).setAttribute("onchange","" );
      ((Element)v.get(195)).setAttribute("req","N" );
      ((Element)v.get(195)).setAttribute("size","5" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("validacion","" );
      ((Element)v.get(195)).setAttribute("ontab","focoCheckAutomatico();" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:187   */

      /* Empieza nodo:198 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("colspan","3" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:141   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:201 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:134   */

      /* Empieza nodo:203 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("width","12" );
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("height","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("width","756" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","12" );
      ((Element)v.get(203)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","12" );
      ((Element)v.get(209)).setAttribute("height","1" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:203   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:5   */


   }

}
