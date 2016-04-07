
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_estados_consolidados_buscar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_estados_consolidados_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0691" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_estados_consolidados_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(5)).setAttribute("nombre","ESTILO1" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r\r    .e1 { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8pt; font-weight: bold; color: #000000;\r    text-align: right; height: auto}\r\r    #e1F { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8pt; font-weight: bold; color: #000000;\r    text-align: right; height: auto}\r\r    #e1 { font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8pt; font-weight: bold; color: #000000;\r    text-align: right; height: auto}\r\r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtFechaInicio" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","274" );
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hUsaPlantillas" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hModificar" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hTipoSol" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hFechaIni" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hFechaFin" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hCbCodPlantilla" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hCodigoPlantilla" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hDescripcion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hTotalGP1" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hTotalGP2" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hTotalGP3" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hTotalGP4" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hTotalGP5" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hListaOidsCrear" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hGrupoReversion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hGPRever" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hMostrarLista" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hCodPantPlantilla" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hTreeGP1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hTreeGP2" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hTreeGP3" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hTreeGP4" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hTreeGP5" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hCrearGP1" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hCrearGP2" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hCrearGP3" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hCrearGP4" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hCrearGP5" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hIndTipif" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 10   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hFechaFact" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hPais" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hRegion" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hZona" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 10   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(52)).setAttribute("type","text/css" );
      ((Element)v.get(10)).appendChild((Element)v.get(52));

      /* Elemento padre:52 / Elemento actual: 53   */
      v.add(doc.createTextNode("\r.EstCab {\r            FONT-WEIGHT: bold; FONT-SIZE: 9px; VERTICAL-ALIGN: middle; COLOR: black; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; TEXT-ALIGN: center; TEXT-DECORATION: none; \r}\r \r.input { font-family: Verdana, Arial, Helvetica; color:black; font-size:10px; border: 1 solid #000000; font-weight:bold;  cursor: auto; background : white;} \r \r\rTR.AlSt {\r            HEIGHT: 22px\r}\r\rTD.BrdNoLeft {\r            BORDER-BOTTOM: #ffffff 1px solid; BORDER-LEFT-STYLE: none\r}\r\rTD.BrdWhite {\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid  \r}\r\rTD.BrdRWhite {\r            BORDER-RIGHT: #e0e0e0 1px solid; PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px\r}\r\rTD.BrdInf {\r            BORDER-BOTTOM: #999999 1px solid\r}\r\r.BrdNoLeft {\r            BORDER-BOTTOM: #ffffff 1px solid; BORDER-LEFT-STYLE: none PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #f0f0f0\r}\r\r.BrdEWhite {\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #f0f0f0\r}\r\r.BrdOWhite {\r\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #e0e0e0\r\r}\r\r.BrdPWhite {\r\r            BORDER-LEFT: #ffffff 1px solid; BORDER-BOTTOM: #ffffff 1px solid PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: blue\r\r}\r\r.BrdRWhite {\r\r            BORDER-RIGHT: #e0e0e0 1px solid; PADDING-RIGHT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px PADDING-LEFT: 5px; FONT-SIZE: 9px; COLOR: #000000; FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #cecfce\r\r}\r\r.BrdInf {\r\r            BORDER-BOTTOM: #999999 1px solid\r\r}\r\rTD.cabTit {\r\r            PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; WIDTH: 10px; PADDING-TOP: 0px\r\r}\r\rTABLE.cabTit {\r            WIDTH: 100%; BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-BOTTOM-STYLE: none\r}\r\r.EstDatOdd {\r	BACKGROUND-COLOR: #f0f0f0; PADDING-LEFT: 5px\r}\r.EstDatEven {\r	BACKGROUND-COLOR: #e0e0e0; PADDING-LEFT: 5px\r}\r"));
      ((Element)v.get(52)).appendChild((Text)v.get(53));

      /* Termina nodo Texto:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(54)).setAttribute("nombre","capa1" );
      ((Element)v.get(10)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(58)).setAttribute("height","12" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","750" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("height","1" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:56   */

      /* Empieza nodo:63 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(68)).setAttribute("class","legend" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","legend" );
      ((Element)v.get(69)).setAttribute("cod","0075" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(70)).setAttribute("border","0" );
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","679" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("colspan","4" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:77 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblFechaInicio" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","274" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblFechaFin" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("filas","1" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("id","datosTitle" );
      ((Element)v.get(85)).setAttribute("cod","251" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblCodigoPlantilla" );
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(89)).setAttribute("id","datosTitle" );
      ((Element)v.get(89)).setAttribute("cod","716" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","25" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","10" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(77)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:77   */

      /* Empieza nodo:96 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(100)).setAttribute("nombre","txtFechaInicio" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("max","10" );
      ((Element)v.get(100)).setAttribute("tipo","" );
      ((Element)v.get(100)).setAttribute("onchange","" );
      ((Element)v.get(100)).setAttribute("req","S" );
      ((Element)v.get(100)).setAttribute("size","12" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("validacion","" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","25" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(104)).setAttribute("nombre","txtFechaFin" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("max","10" );
      ((Element)v.get(104)).setAttribute("tipo","" );
      ((Element)v.get(104)).setAttribute("onchange","" );
      ((Element)v.get(104)).setAttribute("req","N" );
      ((Element)v.get(104)).setAttribute("size","12" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("validacion","" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","25" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(108)).setAttribute("nombre","cbCodigoPlantilla" );
      ((Element)v.get(108)).setAttribute("id","datosCampos" );
      ((Element)v.get(108)).setAttribute("size","1" );
      ((Element)v.get(108)).setAttribute("multiple","N" );
      ((Element)v.get(108)).setAttribute("req","N" );
      ((Element)v.get(108)).setAttribute("valorinicial","" );
      ((Element)v.get(108)).setAttribute("textoinicial","" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:110 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(113)).setAttribute("onchange","" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","N" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(96)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:96   */

      /* Empieza nodo:117 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("colspan","4" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:120 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(122)).setAttribute("width","679" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("align","left" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblTipoSolicitud" );
      ((Element)v.get(127)).setAttribute("alto","17" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("id","datosTitle" );
      ((Element)v.get(127)).setAttribute("cod","415" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","109" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblZona" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","143" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 123   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(123)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:123   */

      /* Empieza nodo:138 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(141)).setAttribute("valign","top" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(142)).setAttribute("nombre","cbTipoSolicitud" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("size","5" );
      ((Element)v.get(142)).setAttribute("multiple","S" );
      ((Element)v.get(142)).setAttribute("req","N" );
      ((Element)v.get(142)).setAttribute("valorinicial","" );
      ((Element)v.get(142)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","25" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).setAttribute("valign","top" );
      ((Element)v.get(138)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(147)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(147)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).setAttribute("size","5" );
      ((Element)v.get(147)).setAttribute("multiple","S" );
      ((Element)v.get(147)).setAttribute("req","N" );
      ((Element)v.get(147)).setAttribute("valorinicial","" );
      ((Element)v.get(147)).setAttribute("onchange","cambioRegion();" );
      ((Element)v.get(147)).setAttribute("textoinicial","" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:149 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","25" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).setAttribute("valign","top" );
      ((Element)v.get(138)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(152)).setAttribute("nombre","cbZona" );
      ((Element)v.get(152)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).setAttribute("size","5" );
      ((Element)v.get(152)).setAttribute("multiple","S" );
      ((Element)v.get(152)).setAttribute("req","N" );
      ((Element)v.get(152)).setAttribute("valorinicial","" );
      ((Element)v.get(152)).setAttribute("textoinicial","" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:138   */

      /* Empieza nodo:156 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("colspan","4" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:70   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:159 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:63   */

      /* Empieza nodo:161 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("table"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(166)).setAttribute("border","0" );
      ((Element)v.get(166)).setAttribute("align","center" );
      ((Element)v.get(166)).setAttribute("cellspacing","0" );
      ((Element)v.get(166)).setAttribute("cellpadding","0" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("class","botonera" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(169)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(169)).setAttribute("ID","botonContenido" );
      ((Element)v.get(169)).setAttribute("tipo","html" );
      ((Element)v.get(169)).setAttribute("accion","cargarLista();" );
      ((Element)v.get(169)).setAttribute("estado","false" );
      ((Element)v.get(169)).setAttribute("cod","1" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:170 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","12" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:161   */

      /* Empieza nodo:172 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(174)).setAttribute("height","12" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("width","750" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","12" );
      ((Element)v.get(178)).setAttribute("height","1" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:172   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:179 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(179)).setAttribute("nombre","capa2" );
      ((Element)v.get(179)).setAttribute("x","0" );
      ((Element)v.get(179)).setAttribute("y","534" );
      ((Element)v.get(179)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(10)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("table"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(180)).setAttribute("border","0" );
      ((Element)v.get(180)).setAttribute("cellspacing","0" );
      ((Element)v.get(180)).setAttribute("cellpadding","0" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","12" );
      ((Element)v.get(182)).setAttribute("align","center" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","12" );
      ((Element)v.get(183)).setAttribute("height","12" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","750" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","12" );
      ((Element)v.get(181)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","12" );
      ((Element)v.get(187)).setAttribute("height","1" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:181   */

      /* Empieza nodo:188 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(193)).setAttribute("class","legend" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(194)).setAttribute("nombre","lblGrupoProcesos" );
      ((Element)v.get(194)).setAttribute("alto","13" );
      ((Element)v.get(194)).setAttribute("filas","1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("id","legend" );
      ((Element)v.get(194)).setAttribute("cod","00610" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("table"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(195)).setAttribute("border","0" );
      ((Element)v.get(195)).setAttribute("align","center" );
      ((Element)v.get(195)).setAttribute("cellspacing","0" );
      ((Element)v.get(195)).setAttribute("cellpadding","0" );
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("table"));
      ((Element)v.get(198)).setAttribute("width","679" );
      ((Element)v.get(198)).setAttribute("border","0" );
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("cellspacing","0" );
      ((Element)v.get(198)).setAttribute("cellpadding","0" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("colspan","4" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("table"));
      ((Element)v.get(204)).setAttribute("width","60%" );
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("cellspacing","0" );
      ((Element)v.get(204)).setAttribute("cellpadding","0" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(209)).setAttribute("nombre","btnProcesoValidacion" );
      ((Element)v.get(209)).setAttribute("ID","botonContenido" );
      ((Element)v.get(209)).setAttribute("tipo","html" );
      ((Element)v.get(209)).setAttribute("accion","procesoValidacion();" );
      ((Element)v.get(209)).setAttribute("estado","false" );
      ((Element)v.get(209)).setAttribute("cod","1399" );
      ((Element)v.get(209)).setAttribute("onshtab","shtabProcesoValidacion();" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(211)).setAttribute("nombre","btnReporteFaltantes" );
      ((Element)v.get(211)).setAttribute("ID","botonContenido" );
      ((Element)v.get(211)).setAttribute("tipo","html" );
      ((Element)v.get(211)).setAttribute("accion","reporteFaltantes();" );
      ((Element)v.get(211)).setAttribute("estado","false" );
      ((Element)v.get(211)).setAttribute("cod","2484" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(213)).setAttribute("nombre","btnGenerarTipificacion" );
      ((Element)v.get(213)).setAttribute("ID","botonContenido" );
      ((Element)v.get(213)).setAttribute("tipo","html" );
      ((Element)v.get(213)).setAttribute("accion","generarSecTipificacion();" );
      ((Element)v.get(213)).setAttribute("estado","false" );
      ((Element)v.get(213)).setAttribute("cod","2712" );
      ((Element)v.get(213)).setAttribute("alt","Generar tipificación" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(215)).setAttribute("nombre","btnGestionStocks" );
      ((Element)v.get(215)).setAttribute("ID","botonContenido" );
      ((Element)v.get(215)).setAttribute("tipo","html" );
      ((Element)v.get(215)).setAttribute("accion","gestionStock();" );
      ((Element)v.get(215)).setAttribute("estado","false" );
      ((Element)v.get(215)).setAttribute("cod","2485" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(217)).setAttribute("nombre","btnFacturar" );
      ((Element)v.get(217)).setAttribute("ID","botonContenido" );
      ((Element)v.get(217)).setAttribute("tipo","html" );
      ((Element)v.get(217)).setAttribute("accion","facturar();" );
      ((Element)v.get(217)).setAttribute("estado","false" );
      ((Element)v.get(217)).setAttribute("cod","1501" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(205)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:220 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","80%" );
      ((Element)v.get(222)).setAttribute("align","center" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(227)).setAttribute("nombre","btnRevertirProcesos" );
      ((Element)v.get(227)).setAttribute("ID","botonContenido" );
      ((Element)v.get(227)).setAttribute("tipo","html" );
      ((Element)v.get(227)).setAttribute("accion","revertirSolicitudesServicio();" );
      ((Element)v.get(227)).setAttribute("estado","false" );
      ((Element)v.get(227)).setAttribute("cod","3166" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(229)).setAttribute("nombre","btnCrearGruposReversion" );
      ((Element)v.get(229)).setAttribute("ID","botonContenido" );
      ((Element)v.get(229)).setAttribute("tipo","html" );
      ((Element)v.get(229)).setAttribute("accion","crearGrupo();" );
      ((Element)v.get(229)).setAttribute("estado","false" );
      ((Element)v.get(229)).setAttribute("cod","2714" );
      ((Element)v.get(229)).setAttribute("alt","Crear grupos reversión" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("colspan","3" );
      ((Element)v.get(223)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(231)).setAttribute("nombre","btnAlarmaPedidosNoFacturados" );
      ((Element)v.get(231)).setAttribute("ID","botonContenido" );
      ((Element)v.get(231)).setAttribute("tipo","html" );
      ((Element)v.get(231)).setAttribute("accion","alarmaPedidos();" );
      ((Element)v.get(231)).setAttribute("estado","false" );
      ((Element)v.get(231)).setAttribute("cod","2486" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(223)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:234 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("colspan","4" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:237 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:188   */

      /* Empieza nodo:239 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("colspan","4" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","15" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(247)).setAttribute("class","legend" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(248)).setAttribute("nombre","lblTotalizacion1" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("id","legend" );
      ((Element)v.get(248)).setAttribute("cod","00209" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("table"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(249)).setAttribute("border","0" );
      ((Element)v.get(249)).setAttribute("align","center" );
      ((Element)v.get(249)).setAttribute("cellspacing","0" );
      ((Element)v.get(249)).setAttribute("cellpadding","0" );
      ((Element)v.get(246)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("table"));
      ((Element)v.get(252)).setAttribute("width","679" );
      ((Element)v.get(252)).setAttribute("border","0" );
      ((Element)v.get(252)).setAttribute("align","left" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(252)).setAttribute("cellspacing","0" );
      ((Element)v.get(252)).setAttribute("cellpadding","0" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("colspan","4" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:256 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(260)).setAttribute("nombre","lblTotalGP1" );
      ((Element)v.get(260)).setAttribute("alto","13" );
      ((Element)v.get(260)).setAttribute("filas","1" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(260)).setAttribute("id","datosTitle" );
      ((Element)v.get(260)).setAttribute("cod","1504" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","25" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblTotalGP2" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("valor","" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
      ((Element)v.get(264)).setAttribute("cod","1506" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","25" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(268)).setAttribute("nombre","lblTotalGP3" );
      ((Element)v.get(268)).setAttribute("alto","13" );
      ((Element)v.get(268)).setAttribute("filas","1" );
      ((Element)v.get(268)).setAttribute("valor","" );
      ((Element)v.get(268)).setAttribute("id","datosTitle" );
      ((Element)v.get(268)).setAttribute("cod","1507" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","25" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(272)).setAttribute("nombre","lblTotalGP4" );
      ((Element)v.get(272)).setAttribute("alto","13" );
      ((Element)v.get(272)).setAttribute("filas","1" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(272)).setAttribute("id","datosTitle" );
      ((Element)v.get(272)).setAttribute("cod","1508" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","25" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 256   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblTotalGP5" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","1509" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","100%" );
      ((Element)v.get(256)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","8" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:256   */

      /* Empieza nodo:279 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","8" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblTotalGP1XXX" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","xxxxxxx1" );
      ((Element)v.get(283)).setAttribute("id","datosCampos" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","25" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(287)).setAttribute("nombre","lblTotalGP2XXX" );
      ((Element)v.get(287)).setAttribute("alto","13" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("valor","xxxxxxx1" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(291)).setAttribute("nombre","lblTotalGP3XXX" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("valor","xxxxxxx1" );
      ((Element)v.get(291)).setAttribute("id","datosCampos" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lblTotalGP4XXX" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("valor","xxxxxxx1" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lblTotalGP5XXX" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("valor","xxxxxxx1" );
      ((Element)v.get(299)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("width","100%" );
      ((Element)v.get(279)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:279   */

      /* Empieza nodo:302 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("colspan","4" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:305 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:242   */

      /* Empieza nodo:307 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("colspan","4" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","15" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:310 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(315)).setAttribute("class","legend" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblDatosAnadir" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(316)).setAttribute("id","legend" );
      ((Element)v.get(316)).setAttribute("cod","00280" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("table"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("table"));
      ((Element)v.get(320)).setAttribute("width","679" );
      ((Element)v.get(320)).setAttribute("border","0" );
      ((Element)v.get(320)).setAttribute("align","left" );
      ((Element)v.get(320)).setAttribute("cellspacing","0" );
      ((Element)v.get(320)).setAttribute("cellpadding","0" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("colspan","4" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(328)).setAttribute("nombre","lblTipificacionCliente" );
      ((Element)v.get(328)).setAttribute("alto","13" );
      ((Element)v.get(328)).setAttribute("filas","1" );
      ((Element)v.get(328)).setAttribute("valor","" );
      ((Element)v.get(328)).setAttribute("id","datosTitle" );
      ((Element)v.get(328)).setAttribute("cod","2339" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","25" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(332)).setAttribute("nombre","lblFechaFacturacion" );
      ((Element)v.get(332)).setAttribute("alto","13" );
      ((Element)v.get(332)).setAttribute("filas","1" );
      ((Element)v.get(332)).setAttribute("valor","" );
      ((Element)v.get(332)).setAttribute("id","datosTitle" );
      ((Element)v.get(332)).setAttribute("cod","876" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(336)).setAttribute("nombre","lblGrupoReversion" );
      ((Element)v.get(336)).setAttribute("alto","13" );
      ((Element)v.get(336)).setAttribute("filas","1" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("id","datosTitle" );
      ((Element)v.get(336)).setAttribute("cod","1447" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(324)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:324   */

      /* Empieza nodo:339 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(343)).setAttribute("check","" );
      ((Element)v.get(343)).setAttribute("id","" );
      ((Element)v.get(343)).setAttribute("msjreq","" );
      ((Element)v.get(343)).setAttribute("nombre","chkTipificacionCliente" );
      ((Element)v.get(343)).setAttribute("onclick","" );
      ((Element)v.get(343)).setAttribute("readonly","" );
      ((Element)v.get(343)).setAttribute("req","" );
      ((Element)v.get(343)).setAttribute("tabindex","1" );
      ((Element)v.get(343)).setAttribute("texto","" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(343)).setAttribute("validacion","" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","25" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(339)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(347)).setAttribute("nombre","txtFechaFacturacion" );
      ((Element)v.get(347)).setAttribute("id","datosCampos" );
      ((Element)v.get(347)).setAttribute("max","10" );
      ((Element)v.get(347)).setAttribute("tipo","" );
      ((Element)v.get(347)).setAttribute("onchange","" );
      ((Element)v.get(347)).setAttribute("req","N" );
      ((Element)v.get(347)).setAttribute("size","12" );
      ((Element)v.get(347)).setAttribute("valor","" );
      ((Element)v.get(347)).setAttribute("validacion","" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","25" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(339)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(351)).setAttribute("nombre","txtGrupoReversion" );
      ((Element)v.get(351)).setAttribute("id","datosCampos" );
      ((Element)v.get(351)).setAttribute("max","4" );
      ((Element)v.get(351)).setAttribute("tipo","" );
      ((Element)v.get(351)).setAttribute("onchange","" );
      ((Element)v.get(351)).setAttribute("req","N" );
      ((Element)v.get(351)).setAttribute("size","4" );
      ((Element)v.get(351)).setAttribute("valor","" );
      ((Element)v.get(351)).setAttribute("validacion","" );
      ((Element)v.get(351)).setAttribute("ontab","tabGrupoReversion();" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(339)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:339   */

      /* Empieza nodo:354 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).setAttribute("colspan","4" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","8" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:357 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:310   */

      /* Empieza nodo:359 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).setAttribute("width","12" );
      ((Element)v.get(360)).setAttribute("align","center" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","12" );
      ((Element)v.get(361)).setAttribute("height","12" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).setAttribute("width","750" );
      ((Element)v.get(359)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("width","12" );
      ((Element)v.get(359)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(365)).setAttribute("width","12" );
      ((Element)v.get(365)).setAttribute("height","1" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:359   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:366 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(366)).setAttribute("nombre","capa3" );
      ((Element)v.get(366)).setAttribute("x","16" );
      ((Element)v.get(366)).setAttribute("y","213" );
      ((Element)v.get(366)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(10)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(367)).setAttribute("style","BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; WIDTH: 99%; BORDER-BOTTOM: #999999 1px solid" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(368)).setAttribute("id","tblPrincipal" );
      ((Element)v.get(368)).setAttribute("style","TABLE-LAYOUT: fixed" );
      ((Element)v.get(368)).setAttribute("cellSpacing","0" );
      ((Element)v.get(368)).setAttribute("cellPadding","0" );
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(368)).setAttribute("bgColor","#cecfce" );
      ((Element)v.get(368)).setAttribute("border","0" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(370)).setAttribute("class","AlSt" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("class","BrdInf EstCab" );
      ((Element)v.get(371)).setAttribute("style","PADDING-LEFT: 5px; TEXT-ALIGN: left" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Elemento padre:371 / Elemento actual: 372   */
      v.add(doc.createTextNode("Resultado de búsqueda"));
      ((Element)v.get(371)).appendChild((Text)v.get(372));

      /* Termina nodo Texto:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:373 / Elemento padre: 369   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(373)).setAttribute("class","AlSt" );
      ((Element)v.get(369)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("class","BrdInf" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(375)).setAttribute("id","tblHeader" );
      ((Element)v.get(375)).setAttribute("style","BORDER-COLLAPSE: collapse; HEIGHT: 100%" );
      ((Element)v.get(375)).setAttribute("cellSpacing","0" );
      ((Element)v.get(375)).setAttribute("cellPadding","0" );
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("TBODY"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(377)).setAttribute("class","EstCab" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(378)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(378)).setAttribute("width","250" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Elemento padre:378 / Elemento actual: 379   */
      v.add(doc.createTextNode("Tipo solicitud"));
      ((Element)v.get(378)).appendChild((Text)v.get(379));

      /* Termina nodo Texto:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(380)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(380)).setAttribute("width","75" );
      ((Element)v.get(377)).appendChild((Element)v.get(380));

      /* Elemento padre:380 / Elemento actual: 381   */
      v.add(doc.createTextNode("Región"));
      ((Element)v.get(380)).appendChild((Text)v.get(381));

      /* Termina nodo Texto:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(382)).setAttribute("width","75" );
      ((Element)v.get(377)).appendChild((Element)v.get(382));

      /* Elemento padre:382 / Elemento actual: 383   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(382)).appendChild((Text)v.get(383));

      /* Termina nodo Texto:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(384)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(384));

      /* Elemento padre:384 / Elemento actual: 385   */
      v.add(doc.createTextNode("GP1"));
      ((Element)v.get(384)).appendChild((Text)v.get(385));

      /* Termina nodo Texto:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(386)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(386));

      /* Elemento padre:386 / Elemento actual: 387   */
      v.add(doc.createTextNode("GP1"));
      ((Element)v.get(386)).appendChild((Text)v.get(387));

      /* Termina nodo Texto:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(388)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(388));

      /* Elemento padre:388 / Elemento actual: 389   */
      v.add(doc.createTextNode("GP2"));
      ((Element)v.get(388)).appendChild((Text)v.get(389));

      /* Termina nodo Texto:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(390)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(390));

      /* Elemento padre:390 / Elemento actual: 391   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createTextNode("GP2"));
      ((Element)v.get(390)).appendChild((Text)v.get(391));

      /* Termina nodo Texto:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(392)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(392));

      /* Elemento padre:392 / Elemento actual: 393   */
      v.add(doc.createTextNode("GP3"));
      ((Element)v.get(392)).appendChild((Text)v.get(393));

      /* Termina nodo Texto:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(394)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(394));

      /* Elemento padre:394 / Elemento actual: 395   */
      v.add(doc.createTextNode("GP3"));
      ((Element)v.get(394)).appendChild((Text)v.get(395));

      /* Termina nodo Texto:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(396)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(396));

      /* Elemento padre:396 / Elemento actual: 397   */
      v.add(doc.createTextNode("GP4"));
      ((Element)v.get(396)).appendChild((Text)v.get(397));

      /* Termina nodo Texto:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(398)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(398));

      /* Elemento padre:398 / Elemento actual: 399   */
      v.add(doc.createTextNode("GP4"));
      ((Element)v.get(398)).appendChild((Text)v.get(399));

      /* Termina nodo Texto:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(400)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(400)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(400));

      /* Elemento padre:400 / Elemento actual: 401   */
      v.add(doc.createTextNode("GP5"));
      ((Element)v.get(400)).appendChild((Text)v.get(401));

      /* Termina nodo Texto:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("class","BrdRWhite" );
      ((Element)v.get(402)).setAttribute("width","50" );
      ((Element)v.get(377)).appendChild((Element)v.get(402));

      /* Elemento padre:402 / Elemento actual: 403   */
      v.add(doc.createTextNode("GP5"));
      ((Element)v.get(402)).appendChild((Text)v.get(403));

      /* Termina nodo Texto:403   */
      /* Termina nodo:402   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:404 / Elemento padre: 369   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(369)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(405)).setAttribute("class","BrdInf" );
      ((Element)v.get(405)).setAttribute("style","HEIGHT: 252px" );
      ((Element)v.get(405)).setAttribute("vAlign","top" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("div"));
      ((Element)v.get(406)).setAttribute("id","oTableContainer" );
      ((Element)v.get(406)).setAttribute("style","WIDTH: 100%; POSITION: relative; HEIGHT: 100% " );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:407 / Elemento padre: 369   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(407)).setAttribute("class","AlSt" );
      ((Element)v.get(369)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(409)).setAttribute("nombre","refrescar" );
      ((Element)v.get(409)).setAttribute("ID","botonContenido" );
      ((Element)v.get(409)).setAttribute("tipo","html" );
      ((Element)v.get(409)).setAttribute("accion","cargarLista();" );
      ((Element)v.get(409)).setAttribute("estado","false" );
      ((Element)v.get(409)).setAttribute("cod","1500" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 408   */
      v.add(doc.createElement("select"));
      ((Element)v.get(410)).setAttribute("id","cmbDesglose" );
      ((Element)v.get(410)).setAttribute("size","1" );
      ((Element)v.get(410)).setAttribute("class","datosCampos" );
      ((Element)v.get(408)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("option"));
      ((Element)v.get(411)).setAttribute("value","" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 410   */
      v.add(doc.createElement("option"));
      ((Element)v.get(412)).setAttribute("value","2" );
      ((Element)v.get(410)).appendChild((Element)v.get(412));

      /* Elemento padre:412 / Elemento actual: 413   */
      v.add(doc.createTextNode("Desglose por acceso"));
      ((Element)v.get(412)).appendChild((Text)v.get(413));

      /* Termina nodo Texto:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 410   */
      v.add(doc.createElement("option"));
      ((Element)v.get(414)).setAttribute("value","3" );
      ((Element)v.get(410)).appendChild((Element)v.get(414));

      /* Elemento padre:414 / Elemento actual: 415   */
      v.add(doc.createTextNode("Desglose por contenido"));
      ((Element)v.get(414)).appendChild((Text)v.get(415));

      /* Termina nodo Texto:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 410   */
      v.add(doc.createElement("option"));
      ((Element)v.get(416)).setAttribute("value","4" );
      ((Element)v.get(410)).appendChild((Element)v.get(416));

      /* Elemento padre:416 / Elemento actual: 417   */
      v.add(doc.createTextNode("Desglose por estado"));
      ((Element)v.get(416)).appendChild((Text)v.get(417));

      /* Termina nodo Texto:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 410   */
      v.add(doc.createElement("option"));
      ((Element)v.get(418)).setAttribute("value","1" );
      ((Element)v.get(410)).appendChild((Element)v.get(418));

      /* Elemento padre:418 / Elemento actual: 419   */
      v.add(doc.createTextNode("Desglose por tipo, subtipo y clasificación cliente"));
      ((Element)v.get(418)).appendChild((Text)v.get(419));

      /* Termina nodo Texto:419   */
      /* Termina nodo:418   */
      /* Termina nodo:410   */

      /* Empieza nodo:420 / Elemento padre: 408   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("input"));
      ((Element)v.get(420)).setAttribute("id","Desglose" );
      ((Element)v.get(420)).setAttribute("type","button" );
      ((Element)v.get(420)).setAttribute("value","Desglose" );
      ((Element)v.get(420)).setAttribute("class","botonContenido" );
      ((Element)v.get(420)).setAttribute("onclick","desglose();" );
      ((Element)v.get(408)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:10   */


   }

}
