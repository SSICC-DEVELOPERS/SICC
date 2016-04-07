
import org.w3c.dom.*;
import java.util.ArrayList;

public class pestanas_cliente_presentar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","pestana_concurso_crear" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#E5E5E5" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","pestanas_cliente_presentar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","idioma" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","pais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("var"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(14)).setAttribute("width","100%" );
      ((Element)v.get(14)).setAttribute("height","100%" );
      ((Element)v.get(14)).setAttribute("border","0" );
      ((Element)v.get(14)).setAttribute("align","center" );
      ((Element)v.get(14)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).setAttribute("cellspacing","0" );
      ((Element)v.get(14)).setAttribute("class","menu4" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(16)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("height","30" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(18)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(18)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Elemento padre:18 / Elemento actual: 19   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(18)).appendChild((Text)v.get(19));

      /* Termina nodo Texto:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","10" );
      ((Element)v.get(20)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(20)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("width","10" );
      ((Element)v.get(21)).setAttribute("height","8" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","20" );
      ((Element)v.get(22)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(22)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("nombre","tablelblFicha" );
      ((Element)v.get(23)).setAttribute("width","65" );
      ((Element)v.get(23)).setAttribute("border","1" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(23)).setAttribute("cellpadding","1" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(23)).setAttribute("bgcolor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(26)).setAttribute("nombre","lblFicha" );
      ((Element)v.get(26)).setAttribute("alto","13" );
      ((Element)v.get(26)).setAttribute("enlace","Javascript:onClickPestana('lblFicha');" );
      ((Element)v.get(26)).setAttribute("filas","1" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(26)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(26)).setAttribute("onclick","" );
      ((Element)v.get(26)).setAttribute("cod","00410" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","10" );
      ((Element)v.get(27)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","10" );
      ((Element)v.get(28)).setAttribute("height","8" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","20" );
      ((Element)v.get(29)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(29)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("nombre","tablelblContactos" );
      ((Element)v.get(30)).setAttribute("width","75" );
      ((Element)v.get(30)).setAttribute("border","1" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellpadding","1" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(30)).setAttribute("bgcolor","" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).setAttribute("align","center" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(33)).setAttribute("nombre","lblContactos" );
      ((Element)v.get(33)).setAttribute("alto","13" );
      ((Element)v.get(33)).setAttribute("filas","1" );
      ((Element)v.get(33)).setAttribute("enlace","Javascript:onClickPestana('lblContactos');" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(33)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(33)).setAttribute("onclick","" );
      ((Element)v.get(33)).setAttribute("cod","00411" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:34 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","10" );
      ((Element)v.get(34)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","10" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","20" );
      ((Element)v.get(36)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(36)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("nombre","tablelblCuentaCorriente" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("width","60" );
      ((Element)v.get(37)).setAttribute("border","1" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellpadding","1" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(37)).setAttribute("bgcolor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(40)).setAttribute("nombre","lblCuentaCorriente" );
      ((Element)v.get(40)).setAttribute("alto","13" );
      ((Element)v.get(40)).setAttribute("filas","1" );
      ((Element)v.get(40)).setAttribute("enlace","Javascript:onClickPestana('lblCuentaCorriente');" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(40)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(40)).setAttribute("onclick","" );
      ((Element)v.get(40)).setAttribute("cod","0025" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:41 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","10" );
      ((Element)v.get(41)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","10" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","20" );
      ((Element)v.get(43)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(43)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(44)).setAttribute("nombre","tablelblPedidos" );
      ((Element)v.get(44)).setAttribute("width","60" );
      ((Element)v.get(44)).setAttribute("border","1" );
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("cellpadding","1" );
      ((Element)v.get(44)).setAttribute("cellspacing","0" );
      ((Element)v.get(44)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(44)).setAttribute("bgcolor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblPedidos" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("enlace","Javascript:onClickPestana('lblPedidos');" );
      ((Element)v.get(47)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(47)).setAttribute("onclick","" );
      ((Element)v.get(47)).setAttribute("cod","00412" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:48 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","10" );
      ((Element)v.get(48)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","10" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","20" );
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(50)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("nombre","tablelblVinculos" );
      ((Element)v.get(51)).setAttribute("width","60" );
      ((Element)v.get(51)).setAttribute("border","1" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("cellpadding","1" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(51)).setAttribute("bgcolor","" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).setAttribute("align","center" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblVinculos" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("enlace","Javascript:onClickPestana('lblVinculos');" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(54)).setAttribute("onclick","" );
      ((Element)v.get(54)).setAttribute("cod","00415" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:55 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","10" );
      ((Element)v.get(55)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","10" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","20" );
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("nombre","tablelblDocumentos" );
      ((Element)v.get(58)).setAttribute("width","60" );
      ((Element)v.get(58)).setAttribute("border","1" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellpadding","1" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(58)).setAttribute("bgcolor","" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblDocumentos" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("enlace","Javascript:onClickPestana('lblDocumentos');" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(61)).setAttribute("onclick","" );
      ((Element)v.get(61)).setAttribute("cod","00416" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:62 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","10" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","20" );
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("nombre","tablelblDireccion" );
      ((Element)v.get(65)).setAttribute("width","75" );
      ((Element)v.get(65)).setAttribute("border","1" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("cellpadding","1" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(65)).setAttribute("bgcolor","" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblDireccion" );
      ((Element)v.get(68)).setAttribute("enlace","Javascript:onClickPestana('lblDireccion');" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(68)).setAttribute("RC","S" );
      ((Element)v.get(68)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(68)).setAttribute("onclick","" );
      ((Element)v.get(68)).setAttribute("cod","00417" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:69 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","16" );
      ((Element)v.get(69)).setAttribute("class","menu5texto" );
      ((Element)v.get(15)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","12" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */
      /* Termina nodo:6   */

      /* Empieza nodo:71 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(71)).setAttribute("nombre","frmContenidoEnvia" );
      ((Element)v.get(71)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 71   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(71)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 71   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(71)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:71   */


   }

}
