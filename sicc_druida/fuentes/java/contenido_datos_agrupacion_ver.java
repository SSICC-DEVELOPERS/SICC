
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_datos_agrupacion_ver  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_agrupacion_ver" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_datos_agrupacion_ver.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","N" );
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
      ((Element)v.get(9)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","varPais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hOidCentroDistribucion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hCodAgrupacion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","8" );
      ((Element)v.get(30)).setAttribute("height","12" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:25   */

      /* Empieza nodo:31 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("height","12" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","756" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(31)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","1" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:31   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:38 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","capaLista" );
      ((Element)v.get(38)).setAttribute("ancho","100%" );
      ((Element)v.get(38)).setAttribute("alto","330" );
      ((Element)v.get(38)).setAttribute("x","7" );
      ((Element)v.get(38)).setAttribute("y","42" );
      ((Element)v.get(38)).setAttribute("colorf","" );
      ((Element)v.get(38)).setAttribute("borde","0" );
      ((Element)v.get(38)).setAttribute("imagenf","" );
      ((Element)v.get(38)).setAttribute("repeat","" );
      ((Element)v.get(38)).setAttribute("padding","" );
      ((Element)v.get(38)).setAttribute("visibilidad","" );
      ((Element)v.get(38)).setAttribute("contravsb","" );
      ((Element)v.get(38)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(39)).setAttribute("nombre","listado1" );
      ((Element)v.get(39)).setAttribute("ancho","369" );
      ((Element)v.get(39)).setAttribute("alto","301" );
      ((Element)v.get(39)).setAttribute("x","12" );
      ((Element)v.get(39)).setAttribute("y","0" );
      ((Element)v.get(39)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(39)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(40)).setAttribute("precarga","S" );
      ((Element)v.get(40)).setAttribute("conROver","S" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(41)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(41)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(41)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(41)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 40   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(42)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(42)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(42)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(42)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("BTNORDENAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(43)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:40   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(45)).setAttribute("borde","1" );
      ((Element)v.get(45)).setAttribute("horizDatos","1" );
      ((Element)v.get(45)).setAttribute("horizCabecera","1" );
      ((Element)v.get(45)).setAttribute("vertical","1" );
      ((Element)v.get(45)).setAttribute("horizTitulo","1" );
      ((Element)v.get(45)).setAttribute("horizBase","1" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 44   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(46)).setAttribute("borde","#999999" );
      ((Element)v.get(46)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(46)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(46)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(46)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(46)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(46)).setAttribute("horizBase","#999999" );
      ((Element)v.get(44)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:44   */

      /* Empieza nodo:47 / Elemento padre: 39   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(47)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(47)).setAttribute("alto","22" );
      ((Element)v.get(47)).setAttribute("imgFondo","" );
      ((Element)v.get(47)).setAttribute("cod","ApeCubicArticFueraPed.agrup.label" );
      ((Element)v.get(47)).setAttribute("ID","datosTitle" );
      ((Element)v.get(39)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(48)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(48)).setAttribute("alto","22" );
      ((Element)v.get(48)).setAttribute("imgFondo","" );
      ((Element)v.get(39)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 39   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(49)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(49)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(49)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(49)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(49)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(49)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(39)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("ancho","100" );
      ((Element)v.get(50)).setAttribute("minimizable","S" );
      ((Element)v.get(50)).setAttribute("minimizada","N" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("ancho","100" );
      ((Element)v.get(51)).setAttribute("minimizable","S" );
      ((Element)v.get(51)).setAttribute("minimizada","N" );
      ((Element)v.get(49)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","100" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","100" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(49)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","100" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(49)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:49   */

      /* Empieza nodo:55 / Elemento padre: 39   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(55)).setAttribute("alto","25" );
      ((Element)v.get(55)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(55)).setAttribute("imgFondo","" );
      ((Element)v.get(55)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(39)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("colFondo","" );
      ((Element)v.get(56)).setAttribute("ID","EstCab" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cod","13" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Elemento padre:56 / Elemento actual: 57   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(56)).appendChild((Text)v.get(57));

      /* Termina nodo Texto:57   */
      /* Termina nodo:56   */

      /* Elemento padre:55 / Elemento actual: 58   */
      v.add(doc.createTextNode("		  .\r			"));
      ((Element)v.get(55)).appendChild((Text)v.get(58));

      /* Termina nodo Texto:58   */

      /* Empieza nodo:59 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("colFondo","" );
      ((Element)v.get(59)).setAttribute("ID","EstCab" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cod","7" );
      ((Element)v.get(55)).appendChild((Element)v.get(59));

      /* Elemento padre:59 / Elemento actual: 60   */
      v.add(doc.createTextNode("Canal"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(59)).appendChild((Text)v.get(60));

      /* Termina nodo Texto:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(61)).setAttribute("cod","00232" );
      ((Element)v.get(55)).appendChild((Element)v.get(61));

      /* Elemento padre:61 / Elemento actual: 62   */
      v.add(doc.createTextNode("Región"));
      ((Element)v.get(61)).appendChild((Text)v.get(62));

      /* Termina nodo Texto:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("cod","00233" );
      ((Element)v.get(55)).appendChild((Element)v.get(63));

      /* Elemento padre:63 / Elemento actual: 64   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(63)).appendChild((Text)v.get(64));

      /* Termina nodo Texto:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("cod","00234" );
      ((Element)v.get(55)).appendChild((Element)v.get(65));

      /* Elemento padre:65 / Elemento actual: 66   */
      v.add(doc.createTextNode("Sección"));
      ((Element)v.get(65)).appendChild((Text)v.get(66));

      /* Termina nodo Texto:66   */
      /* Termina nodo:65   */
      /* Termina nodo:55   */

      /* Empieza nodo:67 / Elemento padre: 39   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(67)).setAttribute("alto","22" );
      ((Element)v.get(67)).setAttribute("accion","" );
      ((Element)v.get(67)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(67)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(67)).setAttribute("maxSel","-1" );
      ((Element)v.get(67)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(67)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(67)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(67)).setAttribute("onLoad","" );
      ((Element)v.get(67)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(39)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("tipo","texto" );
      ((Element)v.get(68)).setAttribute("ID","EstDat" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("tipo","texto" );
      ((Element)v.get(69)).setAttribute("ID","EstDat2" );
      ((Element)v.get(67)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("tipo","texto" );
      ((Element)v.get(70)).setAttribute("ID","EstDat" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("tipo","texto" );
      ((Element)v.get(71)).setAttribute("ID","EstDat2" );
      ((Element)v.get(67)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("tipo","texto" );
      ((Element)v.get(72)).setAttribute("ID","EstDat2" );
      ((Element)v.get(67)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:67   */

      /* Empieza nodo:73 / Elemento padre: 39   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(39)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 39   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(74)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(74)).setAttribute("ancho","679" );
      ((Element)v.get(74)).setAttribute("sep","$" );
      ((Element)v.get(74)).setAttribute("x","12" );
      ((Element)v.get(74)).setAttribute("class","botonera" );
      ((Element)v.get(74)).setAttribute("y","294" );
      ((Element)v.get(74)).setAttribute("control","|" );
      ((Element)v.get(74)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(74)).setAttribute("rowset","" );
      ((Element)v.get(74)).setAttribute("cargainicial","N" );
      ((Element)v.get(74)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(39)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(75)).setAttribute("nombre","ret1" );
      ((Element)v.get(75)).setAttribute("x","37" );
      ((Element)v.get(75)).setAttribute("y","282" );
      ((Element)v.get(75)).setAttribute("ID","botonContenido" );
      ((Element)v.get(75)).setAttribute("img","retroceder_on" );
      ((Element)v.get(75)).setAttribute("tipo","0" );
      ((Element)v.get(75)).setAttribute("estado","false" );
      ((Element)v.get(75)).setAttribute("alt","" );
      ((Element)v.get(75)).setAttribute("codigo","" );
      ((Element)v.get(75)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 74   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(76)).setAttribute("nombre","ava1" );
      ((Element)v.get(76)).setAttribute("x","52" );
      ((Element)v.get(76)).setAttribute("y","282" );
      ((Element)v.get(76)).setAttribute("ID","botonContenido" );
      ((Element)v.get(76)).setAttribute("img","avanzar_on" );
      ((Element)v.get(76)).setAttribute("tipo","0" );
      ((Element)v.get(76)).setAttribute("estado","false" );
      ((Element)v.get(76)).setAttribute("alt","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(76)).setAttribute("codigo","" );
      ((Element)v.get(76)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(74)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:74   */
      /* Termina nodo:39   */

      /* Empieza nodo:77 / Elemento padre: 38   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(77)).setAttribute("nombre","primera1" );
      ((Element)v.get(77)).setAttribute("x","20" );
      ((Element)v.get(77)).setAttribute("y","282" );
      ((Element)v.get(77)).setAttribute("ID","botonContenido" );
      ((Element)v.get(77)).setAttribute("img","primera_on" );
      ((Element)v.get(77)).setAttribute("tipo","-2" );
      ((Element)v.get(77)).setAttribute("estado","false" );
      ((Element)v.get(77)).setAttribute("alt","" );
      ((Element)v.get(77)).setAttribute("codigo","" );
      ((Element)v.get(77)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(38)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 38   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(78)).setAttribute("nombre","separa" );
      ((Element)v.get(78)).setAttribute("x","59" );
      ((Element)v.get(78)).setAttribute("y","278" );
      ((Element)v.get(78)).setAttribute("ID","botonContenido" );
      ((Element)v.get(78)).setAttribute("img","separa_base" );
      ((Element)v.get(78)).setAttribute("tipo","0" );
      ((Element)v.get(78)).setAttribute("estado","false" );
      ((Element)v.get(78)).setAttribute("alt","" );
      ((Element)v.get(78)).setAttribute("codigo","" );
      ((Element)v.get(78)).setAttribute("accion","" );
      ((Element)v.get(38)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:38   */

      /* Empieza nodo:79 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(79)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(79)).setAttribute("alto","12" );
      ((Element)v.get(79)).setAttribute("ancho","100%" );
      ((Element)v.get(79)).setAttribute("colorf","" );
      ((Element)v.get(79)).setAttribute("borde","0" );
      ((Element)v.get(79)).setAttribute("imagenf","" );
      ((Element)v.get(79)).setAttribute("repeat","" );
      ((Element)v.get(79)).setAttribute("padding","" );
      ((Element)v.get(79)).setAttribute("visibilidad","visible" );
      ((Element)v.get(79)).setAttribute("contravsb","" );
      ((Element)v.get(79)).setAttribute("x","0" );
      ((Element)v.get(79)).setAttribute("y","428" );
      ((Element)v.get(79)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:6   */


   }

}
