
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_reclamos_consultar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_reclamos_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0217" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separaDiv {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_reclamos_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(8)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","idioma" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","pais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidReclamo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","524" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(22)).setAttribute("nombre","listado1" );
      ((Element)v.get(22)).setAttribute("ancho","500" );
      ((Element)v.get(22)).setAttribute("alto","317" );
      ((Element)v.get(22)).setAttribute("x","12" );
      ((Element)v.get(22)).setAttribute("y","12" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(22)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(23)).setAttribute("precarga","S" );
      ((Element)v.get(23)).setAttribute("conROver","S" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(24)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(24)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(24)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(24)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 23   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(25)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(25)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(25)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(25)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(26)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(26)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:23   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(28)).setAttribute("borde","1" );
      ((Element)v.get(28)).setAttribute("horizDatos","1" );
      ((Element)v.get(28)).setAttribute("horizCabecera","1" );
      ((Element)v.get(28)).setAttribute("vertical","1" );
      ((Element)v.get(28)).setAttribute("horizTitulo","1" );
      ((Element)v.get(28)).setAttribute("horizBase","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 27   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(29)).setAttribute("borde","#999999" );
      ((Element)v.get(29)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(29)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(29)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(29)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(29)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(29)).setAttribute("horizBase","#999999" );
      ((Element)v.get(27)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:27   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(30)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(30)).setAttribute("alto","22" );
      ((Element)v.get(30)).setAttribute("imgFondo","" );
      ((Element)v.get(30)).setAttribute("cod","00133" );
      ((Element)v.get(30)).setAttribute("ID","datosTitle" );
      ((Element)v.get(22)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 22   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(31)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(31)).setAttribute("alto","22" );
      ((Element)v.get(31)).setAttribute("imgFondo","" );
      ((Element)v.get(22)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 22   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(32)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(32)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(32)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(32)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(32)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(32)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(22)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","100" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(33)).setAttribute("oculta","S" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","100" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("ancho","100" );
      ((Element)v.get(36)).setAttribute("minimizable","S" );
      ((Element)v.get(36)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","100" );
      ((Element)v.get(37)).setAttribute("minimizable","S" );
      ((Element)v.get(37)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","100" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","120" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","100" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","100" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","100" );
      ((Element)v.get(43)).setAttribute("minimizable","S" );
      ((Element)v.get(43)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("ancho","120" );
      ((Element)v.get(44)).setAttribute("minimizable","S" );
      ((Element)v.get(44)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","130" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","100" );
      ((Element)v.get(46)).setAttribute("minimizable","S" );
      ((Element)v.get(46)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","100" );
      ((Element)v.get(47)).setAttribute("minimizable","S" );
      ((Element)v.get(47)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("ancho","100" );
      ((Element)v.get(48)).setAttribute("minimizable","S" );
      ((Element)v.get(48)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("ancho","150" );
      ((Element)v.get(49)).setAttribute("minimizable","S" );
      ((Element)v.get(49)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("ancho","150" );
      ((Element)v.get(50)).setAttribute("minimizable","S" );
      ((Element)v.get(50)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("ancho","150" );
      ((Element)v.get(51)).setAttribute("minimizable","S" );
      ((Element)v.get(51)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","100" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","130" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","150" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("ancho","100" );
      ((Element)v.get(55)).setAttribute("minimizable","S" );
      ((Element)v.get(55)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("ancho","150" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(56)).setAttribute("minimizable","S" );
      ((Element)v.get(56)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("ancho","150" );
      ((Element)v.get(57)).setAttribute("minimizable","S" );
      ((Element)v.get(57)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("ancho","150" );
      ((Element)v.get(58)).setAttribute("minimizable","S" );
      ((Element)v.get(58)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("ancho","150" );
      ((Element)v.get(59)).setAttribute("minimizable","S" );
      ((Element)v.get(59)).setAttribute("minimizada","N" );
      ((Element)v.get(32)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:32   */

      /* Empieza nodo:60 / Elemento padre: 22   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(60)).setAttribute("alto","20" );
      ((Element)v.get(60)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(60)).setAttribute("imgFondo","" );
      ((Element)v.get(60)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(22)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(61)).setAttribute("cod","299" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("cod","299" );
      ((Element)v.get(60)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("cod","406" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("cod","301" );
      ((Element)v.get(60)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("cod","375" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("cod","300" );
      ((Element)v.get(60)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("cod","302" );
      ((Element)v.get(60)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("colFondo","" );
      ((Element)v.get(68)).setAttribute("ID","EstCab" );
      ((Element)v.get(68)).setAttribute("cod","304" );
      ((Element)v.get(60)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("colFondo","" );
      ((Element)v.get(69)).setAttribute("ID","EstCab" );
      ((Element)v.get(69)).setAttribute("cod","305" );
      ((Element)v.get(60)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("colFondo","" );
      ((Element)v.get(70)).setAttribute("ID","EstCab" );
      ((Element)v.get(70)).setAttribute("cod","336" );
      ((Element)v.get(60)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("colFondo","" );
      ((Element)v.get(71)).setAttribute("ID","EstCab" );
      ((Element)v.get(71)).setAttribute("cod","337" );
      ((Element)v.get(60)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(72)).setAttribute("cod","338" );
      ((Element)v.get(60)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("colFondo","" );
      ((Element)v.get(73)).setAttribute("ID","EstCab" );
      ((Element)v.get(73)).setAttribute("cod","339" );
      ((Element)v.get(60)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(74)).setAttribute("cod","340" );
      ((Element)v.get(60)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("colFondo","" );
      ((Element)v.get(75)).setAttribute("ID","EstCab" );
      ((Element)v.get(75)).setAttribute("cod","341" );
      ((Element)v.get(60)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(76)).setAttribute("cod","307" );
      ((Element)v.get(60)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("colFondo","" );
      ((Element)v.get(77)).setAttribute("ID","EstCab" );
      ((Element)v.get(77)).setAttribute("cod","308" );
      ((Element)v.get(60)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("colFondo","" );
      ((Element)v.get(78)).setAttribute("ID","EstCab" );
      ((Element)v.get(78)).setAttribute("cod","309" );
      ((Element)v.get(60)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("colFondo","" );
      ((Element)v.get(79)).setAttribute("ID","EstCab" );
      ((Element)v.get(79)).setAttribute("cod","342" );
      ((Element)v.get(60)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("colFondo","" );
      ((Element)v.get(80)).setAttribute("ID","EstCab" );
      ((Element)v.get(80)).setAttribute("cod","343" );
      ((Element)v.get(60)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("colFondo","" );
      ((Element)v.get(81)).setAttribute("ID","EstCab" );
      ((Element)v.get(81)).setAttribute("cod","344" );
      ((Element)v.get(60)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("colFondo","" );
      ((Element)v.get(82)).setAttribute("ID","EstCab" );
      ((Element)v.get(82)).setAttribute("cod","345" );
      ((Element)v.get(60)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("colFondo","" );
      ((Element)v.get(83)).setAttribute("ID","EstCab" );
      ((Element)v.get(83)).setAttribute("cod","346" );
      ((Element)v.get(60)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("colFondo","" );
      ((Element)v.get(84)).setAttribute("ID","EstCab" );
      ((Element)v.get(84)).setAttribute("cod","347" );
      ((Element)v.get(60)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("colFondo","" );
      ((Element)v.get(85)).setAttribute("ID","EstCab" );
      ((Element)v.get(85)).setAttribute("cod","348" );
      ((Element)v.get(60)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("colFondo","" );
      ((Element)v.get(86)).setAttribute("ID","EstCab" );
      ((Element)v.get(86)).setAttribute("cod","349" );
      ((Element)v.get(60)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("colFondo","" );
      ((Element)v.get(87)).setAttribute("ID","EstCab" );
      ((Element)v.get(87)).setAttribute("cod","1616" );
      ((Element)v.get(60)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:60   */

      /* Empieza nodo:88 / Elemento padre: 22   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(88)).setAttribute("alto","22" );
      ((Element)v.get(88)).setAttribute("accion","" );
      ((Element)v.get(88)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(88)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(88)).setAttribute("maxSel","-1" );
      ((Element)v.get(88)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(88)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(88)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(88)).setAttribute("onLoad","" );
      ((Element)v.get(88)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(22)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("tipo","texto" );
      ((Element)v.get(89)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("tipo","texto" );
      ((Element)v.get(90)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(91)).setAttribute("tipo","texto" );
      ((Element)v.get(91)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("tipo","texto" );
      ((Element)v.get(92)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("tipo","texto" );
      ((Element)v.get(93)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("tipo","texto" );
      ((Element)v.get(94)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("tipo","texto" );
      ((Element)v.get(95)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("tipo","texto" );
      ((Element)v.get(96)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("tipo","texto" );
      ((Element)v.get(97)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("tipo","texto" );
      ((Element)v.get(98)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("tipo","texto" );
      ((Element)v.get(99)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("tipo","texto" );
      ((Element)v.get(100)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("tipo","texto" );
      ((Element)v.get(101)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("tipo","texto" );
      ((Element)v.get(102)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("tipo","texto" );
      ((Element)v.get(103)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("tipo","texto" );
      ((Element)v.get(104)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("tipo","texto" );
      ((Element)v.get(105)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("tipo","texto" );
      ((Element)v.get(106)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("tipo","texto" );
      ((Element)v.get(107)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("tipo","texto" );
      ((Element)v.get(108)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("tipo","texto" );
      ((Element)v.get(109)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("tipo","texto" );
      ((Element)v.get(110)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("tipo","texto" );
      ((Element)v.get(111)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("tipo","texto" );
      ((Element)v.get(112)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("tipo","texto" );
      ((Element)v.get(113)).setAttribute("ID","EstDat2" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(88)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("tipo","texto" );
      ((Element)v.get(114)).setAttribute("ID","EstDat" );
      ((Element)v.get(88)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat2" );
      ((Element)v.get(88)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:88   */

      /* Empieza nodo:116 / Elemento padre: 22   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(22)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 22   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(117)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(117)).setAttribute("ancho","631" );
      ((Element)v.get(117)).setAttribute("sep","$" );
      ((Element)v.get(117)).setAttribute("x","12" );
      ((Element)v.get(117)).setAttribute("class","botonera" );
      ((Element)v.get(117)).setAttribute("y","306" );
      ((Element)v.get(117)).setAttribute("control","|" );
      ((Element)v.get(117)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(117)).setAttribute("rowset","" );
      ((Element)v.get(117)).setAttribute("cargainicial","N" );
      ((Element)v.get(117)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(22)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(118)).setAttribute("nombre","ret1" );
      ((Element)v.get(118)).setAttribute("x","37" );
      ((Element)v.get(118)).setAttribute("y","310" );
      ((Element)v.get(118)).setAttribute("ID","botonContenido" );
      ((Element)v.get(118)).setAttribute("img","retroceder_on" );
      ((Element)v.get(118)).setAttribute("tipo","0" );
      ((Element)v.get(118)).setAttribute("estado","false" );
      ((Element)v.get(118)).setAttribute("alt","" );
      ((Element)v.get(118)).setAttribute("codigo","" );
      ((Element)v.get(118)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 117   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(119)).setAttribute("nombre","ava1" );
      ((Element)v.get(119)).setAttribute("x","52" );
      ((Element)v.get(119)).setAttribute("y","310" );
      ((Element)v.get(119)).setAttribute("ID","botonContenido" );
      ((Element)v.get(119)).setAttribute("img","avanzar_on" );
      ((Element)v.get(119)).setAttribute("tipo","0" );
      ((Element)v.get(119)).setAttribute("estado","false" );
      ((Element)v.get(119)).setAttribute("alt","" );
      ((Element)v.get(119)).setAttribute("codigo","" );
      ((Element)v.get(119)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(117)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:117   */
      /* Termina nodo:22   */

      /* Empieza nodo:120 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(120)).setAttribute("nombre","primera1" );
      ((Element)v.get(120)).setAttribute("x","20" );
      ((Element)v.get(120)).setAttribute("y","310" );
      ((Element)v.get(120)).setAttribute("ID","botonContenido" );
      ((Element)v.get(120)).setAttribute("img","primera_on" );
      ((Element)v.get(120)).setAttribute("tipo","-2" );
      ((Element)v.get(120)).setAttribute("estado","false" );
      ((Element)v.get(120)).setAttribute("alt","" );
      ((Element)v.get(120)).setAttribute("codigo","" );
      ((Element)v.get(120)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(121)).setAttribute("nombre","separa" );
      ((Element)v.get(121)).setAttribute("x","59" );
      ((Element)v.get(121)).setAttribute("y","306" );
      ((Element)v.get(121)).setAttribute("ID","botonContenido" );
      ((Element)v.get(121)).setAttribute("img","separa_base" );
      ((Element)v.get(121)).setAttribute("tipo","0" );
      ((Element)v.get(121)).setAttribute("estado","false" );
      ((Element)v.get(121)).setAttribute("alt","" );
      ((Element)v.get(121)).setAttribute("codigo","" );
      ((Element)v.get(121)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(122)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(122)).setAttribute("alto","12" );
      ((Element)v.get(122)).setAttribute("ancho","50" );
      ((Element)v.get(122)).setAttribute("colorf","" );
      ((Element)v.get(122)).setAttribute("borde","0" );
      ((Element)v.get(122)).setAttribute("imagenf","" );
      ((Element)v.get(122)).setAttribute("repeat","" );
      ((Element)v.get(122)).setAttribute("padding","" );
      ((Element)v.get(122)).setAttribute("visibilidad","visible" );
      ((Element)v.get(122)).setAttribute("contravsb","" );
      ((Element)v.get(122)).setAttribute("x","0" );
      ((Element)v.get(122)).setAttribute("y","329" );
      ((Element)v.get(122)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:8   */


   }

}
