
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_facturacion_seleccionar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_facturacion_seleccionar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","0197" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_matriz_facturacion_seleccionar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","LPSeleccionarMF" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidOidCabeceraMF" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","hidOcultarNueva" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hidDesPaisSelec" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidDesMarcaSelec" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidDesCanalSelec" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidDesPeriSelec" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","nombreLogicaLP" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidError" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","flag_1" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","flag_2" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conexion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidParametro" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(23)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","724" );
      ((Element)v.get(27)).setAttribute("height","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(28)).setAttribute("nombre","listado1" );
      ((Element)v.get(28)).setAttribute("ancho","700" );
      ((Element)v.get(28)).setAttribute("alto","92" );
      ((Element)v.get(28)).setAttribute("x","12" );
      ((Element)v.get(28)).setAttribute("y","12" );
      ((Element)v.get(28)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(28)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(29)).setAttribute("precarga","S" );
      ((Element)v.get(29)).setAttribute("conROver","S" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(30)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(30)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(30)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(30)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 29   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(31)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(31)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(31)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(31)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(32)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(32)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:29   */

      /* Empieza nodo:33 / Elemento padre: 28   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(28)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(34)).setAttribute("borde","1" );
      ((Element)v.get(34)).setAttribute("horizDatos","1" );
      ((Element)v.get(34)).setAttribute("horizCabecera","1" );
      ((Element)v.get(34)).setAttribute("vertical","1" );
      ((Element)v.get(34)).setAttribute("horizTitulo","1" );
      ((Element)v.get(34)).setAttribute("horizBase","1" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 33   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(35)).setAttribute("borde","#999999" );
      ((Element)v.get(35)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(35)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(35)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(35)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(35)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(35)).setAttribute("horizBase","#999999" );
      ((Element)v.get(33)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:33   */

      /* Empieza nodo:36 / Elemento padre: 28   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(36)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(36)).setAttribute("alto","22" );
      ((Element)v.get(36)).setAttribute("imgFondo","" );
      ((Element)v.get(36)).setAttribute("cod","00111" );
      ((Element)v.get(36)).setAttribute("ID","datosTitle" );
      ((Element)v.get(28)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 28   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(37)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(37)).setAttribute("alto","22" );
      ((Element)v.get(37)).setAttribute("imgFondo","" );
      ((Element)v.get(28)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 28   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(38)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(38)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(38)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(38)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(38)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(38)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(28)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","100" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(38)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","100" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","80" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(38)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:38   */

      /* Empieza nodo:43 / Elemento padre: 28   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(43)).setAttribute("alto","20" );
      ((Element)v.get(43)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(43)).setAttribute("imgFondo","" );
      ((Element)v.get(43)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(28)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("colFondo","" );
      ((Element)v.get(44)).setAttribute("ID","EstCab" );
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("cod","5" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Elemento padre:44 / Elemento actual: 45   */
      v.add(doc.createTextNode("País"));
      ((Element)v.get(44)).appendChild((Text)v.get(45));

      /* Termina nodo Texto:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("colFondo","" );
      ((Element)v.get(46)).setAttribute("ID","EstCab" );
      ((Element)v.get(46)).setAttribute("cod","6" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Elemento padre:46 / Elemento actual: 47   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(46)).appendChild((Text)v.get(47));

      /* Termina nodo Texto:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("colFondo","" );
      ((Element)v.get(48)).setAttribute("ID","EstCab" );
      ((Element)v.get(48)).setAttribute("cod","7" );
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Elemento padre:48 / Elemento actual: 49   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(48)).appendChild((Text)v.get(49));

      /* Termina nodo Texto:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("cod","276" );
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Elemento padre:50 / Elemento actual: 51   */
      v.add(doc.createTextNode("Período"));
      ((Element)v.get(50)).appendChild((Text)v.get(51));

      /* Termina nodo Texto:51   */
      /* Termina nodo:50   */
      /* Termina nodo:43   */

      /* Empieza nodo:52 / Elemento padre: 28   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(52)).setAttribute("alto","22" );
      ((Element)v.get(52)).setAttribute("accion","" );
      ((Element)v.get(52)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(52)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(52)).setAttribute("maxSel","1" );
      ((Element)v.get(52)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(52)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(52)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(52)).setAttribute("onLoad","" );
      ((Element)v.get(52)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(28)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("tipo","texto" );
      ((Element)v.get(53)).setAttribute("ID","EstDat" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("tipo","texto" );
      ((Element)v.get(54)).setAttribute("ID","EstDat2" );
      ((Element)v.get(52)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("tipo","texto" );
      ((Element)v.get(55)).setAttribute("ID","EstDat" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("tipo","texto" );
      ((Element)v.get(56)).setAttribute("ID","EstDat2" );
      ((Element)v.get(52)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:52   */

      /* Empieza nodo:57 / Elemento padre: 28   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(28)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:28   */

      /* Empieza nodo:58 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(58)).setAttribute("nombre","listado2" );
      ((Element)v.get(58)).setAttribute("ancho","700" );
      ((Element)v.get(58)).setAttribute("alto","299" );
      ((Element)v.get(58)).setAttribute("x","12" );
      ((Element)v.get(58)).setAttribute("y","129" );
      ((Element)v.get(58)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(58)).setAttribute("msgDebugJS","S" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(59)).setAttribute("precarga","S" );
      ((Element)v.get(59)).setAttribute("conROver","S" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(60)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(60)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(60)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(60)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(61)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(61)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(61)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(61)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(62)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(62)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:59   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(64)).setAttribute("borde","1" );
      ((Element)v.get(64)).setAttribute("horizDatos","1" );
      ((Element)v.get(64)).setAttribute("horizCabecera","1" );
      ((Element)v.get(64)).setAttribute("vertical","1" );
      ((Element)v.get(64)).setAttribute("horizTitulo","1" );
      ((Element)v.get(64)).setAttribute("horizBase","1" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 63   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(65)).setAttribute("borde","#999999" );
      ((Element)v.get(65)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(65)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(65)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(65)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(65)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(65)).setAttribute("horizBase","#999999" );
      ((Element)v.get(63)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 58   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(66)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(66)).setAttribute("alto","22" );
      ((Element)v.get(66)).setAttribute("imgFondo","" );
      ((Element)v.get(66)).setAttribute("cod","00112" );
      ((Element)v.get(66)).setAttribute("ID","datosTitle" );
      ((Element)v.get(58)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 58   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(67)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(67)).setAttribute("alto","22" );
      ((Element)v.get(67)).setAttribute("imgFondo","" );
      ((Element)v.get(58)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 58   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(68)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(68)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(68)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(68)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(68)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(68)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(58)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("ancho","100" );
      ((Element)v.get(69)).setAttribute("minimizable","S" );
      ((Element)v.get(69)).setAttribute("minimizada","N" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("ancho","100" );
      ((Element)v.get(70)).setAttribute("minimizable","S" );
      ((Element)v.get(70)).setAttribute("minimizada","N" );
      ((Element)v.get(68)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("ancho","100" );
      ((Element)v.get(71)).setAttribute("minimizable","S" );
      ((Element)v.get(71)).setAttribute("minimizada","N" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("ancho","70" );
      ((Element)v.get(72)).setAttribute("minimizable","S" );
      ((Element)v.get(72)).setAttribute("minimizada","N" );
      ((Element)v.get(68)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:68   */

      /* Empieza nodo:73 / Elemento padre: 58   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(73)).setAttribute("alto","20" );
      ((Element)v.get(73)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(73)).setAttribute("imgFondo","" );
      ((Element)v.get(73)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(58)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(74)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(74)).setAttribute("cod","5" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Elemento padre:74 / Elemento actual: 75   */
      v.add(doc.createTextNode("País"));
      ((Element)v.get(74)).appendChild((Text)v.get(75));

      /* Termina nodo Texto:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(76)).setAttribute("cod","6" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Elemento padre:76 / Elemento actual: 77   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(76)).appendChild((Text)v.get(77));

      /* Termina nodo Texto:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("colFondo","" );
      ((Element)v.get(78)).setAttribute("ID","EstCab" );
      ((Element)v.get(78)).setAttribute("cod","7" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Elemento padre:78 / Elemento actual: 79   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(78)).appendChild((Text)v.get(79));

      /* Termina nodo Texto:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 73   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("colFondo","" );
      ((Element)v.get(80)).setAttribute("ID","EstCab" );
      ((Element)v.get(80)).setAttribute("cod","276" );
      ((Element)v.get(73)).appendChild((Element)v.get(80));

      /* Elemento padre:80 / Elemento actual: 81   */
      v.add(doc.createTextNode("Período"));
      ((Element)v.get(80)).appendChild((Text)v.get(81));

      /* Termina nodo Texto:81   */
      /* Termina nodo:80   */
      /* Termina nodo:73   */

      /* Empieza nodo:82 / Elemento padre: 58   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(82)).setAttribute("alto","22" );
      ((Element)v.get(82)).setAttribute("accion","" );
      ((Element)v.get(82)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(82)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(82)).setAttribute("maxSel","1" );
      ((Element)v.get(82)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(82)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(82)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(82)).setAttribute("onLoad","" );
      ((Element)v.get(82)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(58)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("ID","EstDat" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("tipo","texto" );
      ((Element)v.get(84)).setAttribute("ID","EstDat2" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("tipo","texto" );
      ((Element)v.get(85)).setAttribute("ID","EstDat" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 82   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("tipo","texto" );
      ((Element)v.get(86)).setAttribute("ID","EstDat2" );
      ((Element)v.get(82)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:82   */

      /* Empieza nodo:87 / Elemento padre: 58   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(58)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 58   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(88)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(88)).setAttribute("ancho","700" );
      ((Element)v.get(88)).setAttribute("sep","$" );
      ((Element)v.get(88)).setAttribute("x","12" );
      ((Element)v.get(88)).setAttribute("class","botonera" );
      ((Element)v.get(88)).setAttribute("y","405" );
      ((Element)v.get(88)).setAttribute("control","|" );
      ((Element)v.get(88)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(88)).setAttribute("rowset","" );
      ((Element)v.get(88)).setAttribute("cargainicial","N" );
      ((Element)v.get(88)).setAttribute("onload","procesarPaginado(mipgndo2,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(58)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(89)).setAttribute("nombre","ret2" );
      ((Element)v.get(89)).setAttribute("x","37" );
      ((Element)v.get(89)).setAttribute("y","409" );
      ((Element)v.get(89)).setAttribute("ID","botonContenido" );
      ((Element)v.get(89)).setAttribute("img","retroceder_on" );
      ((Element)v.get(89)).setAttribute("tipo","0" );
      ((Element)v.get(89)).setAttribute("estado","false" );
      ((Element)v.get(89)).setAttribute("alt","" );
      ((Element)v.get(89)).setAttribute("codigo","" );
      ((Element)v.get(89)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(90)).setAttribute("nombre","ava2" );
      ((Element)v.get(90)).setAttribute("x","52" );
      ((Element)v.get(90)).setAttribute("y","409" );
      ((Element)v.get(90)).setAttribute("ID","botonContenido" );
      ((Element)v.get(90)).setAttribute("img","avanzar_on" );
      ((Element)v.get(90)).setAttribute("tipo","0" );
      ((Element)v.get(90)).setAttribute("estado","false" );
      ((Element)v.get(90)).setAttribute("alt","" );
      ((Element)v.get(90)).setAttribute("codigo","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(90)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:88   */
      /* Termina nodo:58   */

      /* Empieza nodo:91 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(91)).setAttribute("nombre","primera2" );
      ((Element)v.get(91)).setAttribute("x","20" );
      ((Element)v.get(91)).setAttribute("y","409" );
      ((Element)v.get(91)).setAttribute("ID","botonContenido" );
      ((Element)v.get(91)).setAttribute("img","primera_on" );
      ((Element)v.get(91)).setAttribute("tipo","-2" );
      ((Element)v.get(91)).setAttribute("estado","false" );
      ((Element)v.get(91)).setAttribute("alt","" );
      ((Element)v.get(91)).setAttribute("codigo","" );
      ((Element)v.get(91)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(92)).setAttribute("nombre","separa2" );
      ((Element)v.get(92)).setAttribute("x","59" );
      ((Element)v.get(92)).setAttribute("y","405" );
      ((Element)v.get(92)).setAttribute("ID","botonContenido" );
      ((Element)v.get(92)).setAttribute("img","separa_base" );
      ((Element)v.get(92)).setAttribute("tipo","0" );
      ((Element)v.get(92)).setAttribute("estado","false" );
      ((Element)v.get(92)).setAttribute("alt","" );
      ((Element)v.get(92)).setAttribute("codigo","" );
      ((Element)v.get(92)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(93)).setAttribute("nombre","Nueva" );
      ((Element)v.get(93)).setAttribute("x","80" );
      ((Element)v.get(93)).setAttribute("y","406" );
      ((Element)v.get(93)).setAttribute("ID","botonContenido" );
      ((Element)v.get(93)).setAttribute("tipo","html" );
      ((Element)v.get(93)).setAttribute("estado","false" );
      ((Element)v.get(93)).setAttribute("cod","474" );
      ((Element)v.get(93)).setAttribute("accion","accionPulsaNueva();" );
      ((Element)v.get(93)).setAttribute("onshtab","onShTabBotonNueva();" );
      ((Element)v.get(6)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(94)).setAttribute("nombre","Anteriores" );
      ((Element)v.get(94)).setAttribute("x","126" );
      ((Element)v.get(94)).setAttribute("y","406" );
      ((Element)v.get(94)).setAttribute("ID","botonContenido" );
      ((Element)v.get(94)).setAttribute("tipo","html" );
      ((Element)v.get(94)).setAttribute("estado","false" );
      ((Element)v.get(94)).setAttribute("cod","475" );
      ((Element)v.get(94)).setAttribute("accion","accionPulsaAnterior();" );
      ((Element)v.get(94)).setAttribute("onshtab","onShTabBotonAterior()" );
      ((Element)v.get(6)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(95)).setAttribute("nombre","Seleccionar" );
      ((Element)v.get(95)).setAttribute("x","202" );
      ((Element)v.get(95)).setAttribute("y","406" );
      ((Element)v.get(95)).setAttribute("ID","botonContenido" );
      ((Element)v.get(95)).setAttribute("tipo","html" );
      ((Element)v.get(95)).setAttribute("estado","false" );
      ((Element)v.get(95)).setAttribute("cod","114" );
      ((Element)v.get(95)).setAttribute("accion","accionSeleccionaMatriz();" );
      ((Element)v.get(95)).setAttribute("ontab","onTabBotonSeleccionar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(96)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(96)).setAttribute("alto","12" );
      ((Element)v.get(96)).setAttribute("ancho","50" );
      ((Element)v.get(96)).setAttribute("colorf","" );
      ((Element)v.get(96)).setAttribute("borde","0" );
      ((Element)v.get(96)).setAttribute("imagenf","" );
      ((Element)v.get(96)).setAttribute("repeat","" );
      ((Element)v.get(96)).setAttribute("padding","" );
      ((Element)v.get(96)).setAttribute("visibilidad","visible" );
      ((Element)v.get(96)).setAttribute("contravsb","" );
      ((Element)v.get(96)).setAttribute("x","0" );
      ((Element)v.get(96)).setAttribute("y","428" );
      ((Element)v.get(96)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:6   */


   }

}
