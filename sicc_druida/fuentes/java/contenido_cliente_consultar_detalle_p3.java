
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cliente_consultar_detalle_p3  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cliente_consultar_detalle_p3" );
      ((Element)v.get(0)).setAttribute("cod","0410" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Clientes detalle" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar Clientes detalle" );
      ((Element)v.get(0)).setAttribute("onload","init()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_cliente_consultar_detalle_p3.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(4)).setAttribute("nombre","accion" );
      ((Element)v.get(4)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(8)).setAttribute("nombre","listado5" );
      ((Element)v.get(8)).setAttribute("ancho","711" );
      ((Element)v.get(8)).setAttribute("alto","293" );
      ((Element)v.get(8)).setAttribute("x","12" );
      ((Element)v.get(8)).setAttribute("y","12" );
      ((Element)v.get(8)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(8)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(9)).setAttribute("precarga","S" );
      ((Element)v.get(9)).setAttribute("conROver","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(10)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(10)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(10)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(10)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(11)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(11)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(11)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(11)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:9   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(8)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(13)).setAttribute("borde","1" );
      ((Element)v.get(13)).setAttribute("horizDatos","1" );
      ((Element)v.get(13)).setAttribute("horizCabecera","1" );
      ((Element)v.get(13)).setAttribute("vertical","1" );
      ((Element)v.get(13)).setAttribute("horizTitulo","1" );
      ((Element)v.get(13)).setAttribute("horizBase","1" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(14)).setAttribute("borde","#999999" );
      ((Element)v.get(14)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(14)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(14)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(14)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(14)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(14)).setAttribute("horizBase","#999999" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:12   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(15)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(15)).setAttribute("alto","22" );
      ((Element)v.get(15)).setAttribute("imgFondo","" );
      ((Element)v.get(15)).setAttribute("cod","00143" );
      ((Element)v.get(15)).setAttribute("ID","datosTitle" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(16)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(16)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(16)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(16)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(16)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(17)).setAttribute("ancho","90" );
      ((Element)v.get(17)).setAttribute("minimizable","S" );
      ((Element)v.get(17)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(18)).setAttribute("ancho","90" );
      ((Element)v.get(18)).setAttribute("minimizable","S" );
      ((Element)v.get(18)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(19)).setAttribute("ancho","61" );
      ((Element)v.get(19)).setAttribute("minimizable","S" );
      ((Element)v.get(19)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(20)).setAttribute("ancho","215" );
      ((Element)v.get(20)).setAttribute("minimizable","S" );
      ((Element)v.get(20)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(21)).setAttribute("ancho","73" );
      ((Element)v.get(21)).setAttribute("minimizable","S" );
      ((Element)v.get(21)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(22)).setAttribute("ancho","72" );
      ((Element)v.get(22)).setAttribute("minimizable","S" );
      ((Element)v.get(22)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(23)).setAttribute("ancho","315" );
      ((Element)v.get(23)).setAttribute("minimizable","S" );
      ((Element)v.get(23)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(24)).setAttribute("ancho","115" );
      ((Element)v.get(24)).setAttribute("minimizable","S" );
      ((Element)v.get(24)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:16   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(25)).setAttribute("alto","20" );
      ((Element)v.get(25)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(25)).setAttribute("imgFondo","" );
      ((Element)v.get(25)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("colFondo","" );
      ((Element)v.get(26)).setAttribute("ID","EstCab" );
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(26)).setAttribute("cod","227" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(27)).setAttribute("colFondo","" );
      ((Element)v.get(27)).setAttribute("ID","EstCab" );
      ((Element)v.get(27)).setAttribute("align","center" );
      ((Element)v.get(27)).setAttribute("cod","159" );
      ((Element)v.get(25)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("colFondo","" );
      ((Element)v.get(28)).setAttribute("ID","EstCab" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(28)).setAttribute("cod","215" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(29)).setAttribute("colFondo","" );
      ((Element)v.get(29)).setAttribute("ID","EstCab" );
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(29)).setAttribute("cod","216" );
      ((Element)v.get(25)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("colFondo","" );
      ((Element)v.get(30)).setAttribute("ID","EstCab" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cod","939" );
      ((Element)v.get(25)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("colFondo","" );
      ((Element)v.get(31)).setAttribute("ID","EstCab" );
      ((Element)v.get(31)).setAttribute("align","center" );
      ((Element)v.get(31)).setAttribute("cod","1344" );
      ((Element)v.get(25)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("colFondo","" );
      ((Element)v.get(32)).setAttribute("ID","EstCab" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cod","169" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(25)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("colFondo","" );
      ((Element)v.get(33)).setAttribute("ID","EstCab" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cod","1349" );
      ((Element)v.get(25)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:25   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(34)).setAttribute("alto","22" );
      ((Element)v.get(34)).setAttribute("accion","" );
      ((Element)v.get(34)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(34)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(34)).setAttribute("maxSel","-1" );
      ((Element)v.get(34)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(34)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(34)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(34)).setAttribute("onLoad","" );
      ((Element)v.get(34)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("tipo","texto" );
      ((Element)v.get(35)).setAttribute("ID","EstDat2" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("tipo","texto" );
      ((Element)v.get(36)).setAttribute("ID","EstDat" );
      ((Element)v.get(34)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("tipo","texto" );
      ((Element)v.get(37)).setAttribute("ID","EstDat2" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("tipo","texto" );
      ((Element)v.get(38)).setAttribute("ID","EstDat" );
      ((Element)v.get(34)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("tipo","texto" );
      ((Element)v.get(39)).setAttribute("ID","EstDat2" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("tipo","texto" );
      ((Element)v.get(40)).setAttribute("ID","EstDat" );
      ((Element)v.get(34)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("tipo","texto" );
      ((Element)v.get(41)).setAttribute("ID","EstDat2" );
      ((Element)v.get(34)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("tipo","texto" );
      ((Element)v.get(42)).setAttribute("ID","EstDat" );
      ((Element)v.get(34)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:34   */

      /* Empieza nodo:43 / Elemento padre: 8   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(8)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:8   */

      /* Empieza nodo:44 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(44)).setAttribute("nombre","listado6" );
      ((Element)v.get(44)).setAttribute("ancho","711" );
      ((Element)v.get(44)).setAttribute("alto","293" );
      ((Element)v.get(44)).setAttribute("x","12" );
      ((Element)v.get(44)).setAttribute("y","330" );
      ((Element)v.get(44)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(44)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(45)).setAttribute("precarga","S" );
      ((Element)v.get(45)).setAttribute("conROver","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(46)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(46)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(46)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(46)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 45   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(47)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(47)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(47)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(47)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(45)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:45   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(44)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(49)).setAttribute("borde","1" );
      ((Element)v.get(49)).setAttribute("horizDatos","1" );
      ((Element)v.get(49)).setAttribute("horizCabecera","1" );
      ((Element)v.get(49)).setAttribute("vertical","1" );
      ((Element)v.get(49)).setAttribute("horizTitulo","1" );
      ((Element)v.get(49)).setAttribute("horizBase","1" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 48   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(50)).setAttribute("borde","#999999" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(50)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(50)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(50)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(50)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(50)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(50)).setAttribute("horizBase","#999999" );
      ((Element)v.get(48)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:48   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(51)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(51)).setAttribute("alto","22" );
      ((Element)v.get(51)).setAttribute("imgFondo","" );
      ((Element)v.get(51)).setAttribute("cod","00144" );
      ((Element)v.get(51)).setAttribute("ID","datosTitle" );
      ((Element)v.get(44)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 44   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(52)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(52)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(52)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(52)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(52)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(44)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","120" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","120" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("ancho","120" );
      ((Element)v.get(55)).setAttribute("minimizable","S" );
      ((Element)v.get(55)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("ancho","160" );
      ((Element)v.get(56)).setAttribute("minimizable","S" );
      ((Element)v.get(56)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("ancho","120" );
      ((Element)v.get(57)).setAttribute("minimizable","S" );
      ((Element)v.get(57)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("ancho","120" );
      ((Element)v.get(58)).setAttribute("minimizable","S" );
      ((Element)v.get(58)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("ancho","160" );
      ((Element)v.get(59)).setAttribute("minimizable","S" );
      ((Element)v.get(59)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:52   */

      /* Empieza nodo:60 / Elemento padre: 44   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(60)).setAttribute("alto","20" );
      ((Element)v.get(60)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(60)).setAttribute("imgFondo","" );
      ((Element)v.get(60)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(44)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cod","1350" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cod","1351" );
      ((Element)v.get(60)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cod","1352" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cod","1353" );
      ((Element)v.get(60)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(65)).setAttribute("cod","1354" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cod","1355" );
      ((Element)v.get(60)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 60   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cod","1356" );
      ((Element)v.get(60)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:60   */

      /* Empieza nodo:68 / Elemento padre: 44   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(68)).setAttribute("alto","22" );
      ((Element)v.get(68)).setAttribute("accion","" );
      ((Element)v.get(68)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(68)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(68)).setAttribute("maxSel","-1" );
      ((Element)v.get(68)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(68)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(68)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(68)).setAttribute("onLoad","" );
      ((Element)v.get(68)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(44)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("tipo","texto" );
      ((Element)v.get(69)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("tipo","texto" );
      ((Element)v.get(70)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("tipo","texto" );
      ((Element)v.get(71)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("tipo","texto" );
      ((Element)v.get(72)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("tipo","texto" );
      ((Element)v.get(73)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("tipo","texto" );
      ((Element)v.get(74)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("tipo","texto" );
      ((Element)v.get(75)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:68   */

      /* Empieza nodo:76 / Elemento padre: 44   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(44)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:44   */

      /* Empieza nodo:77 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(77)).setAttribute("nombre","listado7" );
      ((Element)v.get(77)).setAttribute("ancho","711" );
      ((Element)v.get(77)).setAttribute("alto","299" );
      ((Element)v.get(77)).setAttribute("x","12" );
      ((Element)v.get(77)).setAttribute("y","648" );
      ((Element)v.get(77)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(77)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(78)).setAttribute("precarga","S" );
      ((Element)v.get(78)).setAttribute("conROver","S" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(79)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(79)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(79)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(79)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(80)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(80)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(80)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(80)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 77   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(77)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(82)).setAttribute("borde","1" );
      ((Element)v.get(82)).setAttribute("horizDatos","1" );
      ((Element)v.get(82)).setAttribute("horizCabecera","1" );
      ((Element)v.get(82)).setAttribute("vertical","1" );
      ((Element)v.get(82)).setAttribute("horizTitulo","1" );
      ((Element)v.get(82)).setAttribute("horizBase","1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(83)).setAttribute("borde","#999999" );
      ((Element)v.get(83)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(83)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(83)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(83)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(83)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(83)).setAttribute("horizBase","#999999" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:81   */

      /* Empieza nodo:84 / Elemento padre: 77   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(84)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(84)).setAttribute("alto","22" );
      ((Element)v.get(84)).setAttribute("imgFondo","" );
      ((Element)v.get(84)).setAttribute("cod","00145" );
      ((Element)v.get(84)).setAttribute("ID","datosTitle" );
      ((Element)v.get(77)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(85)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(85)).setAttribute("alto","22" );
      ((Element)v.get(85)).setAttribute("imgFondo","" );
      ((Element)v.get(77)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 77   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(86)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(86)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(86)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(86)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(86)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(77)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("ancho","40" );
      ((Element)v.get(87)).setAttribute("minimizable","S" );
      ((Element)v.get(87)).setAttribute("minimizada","N" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 77   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(88)).setAttribute("alto","20" );
      ((Element)v.get(88)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(88)).setAttribute("imgFondo","" );
      ((Element)v.get(88)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(77)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("colFondo","" );
      ((Element)v.get(89)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(89)).setAttribute("cod","6" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 77   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(90)).setAttribute("alto","22" );
      ((Element)v.get(90)).setAttribute("accion","" );
      ((Element)v.get(90)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(90)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(90)).setAttribute("maxSel","-1" );
      ((Element)v.get(90)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(90)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(90)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(90)).setAttribute("onLoad","" );
      ((Element)v.get(90)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(77)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("tipo","texto" );
      ((Element)v.get(91)).setAttribute("ID","EstDat" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 77   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(77)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:77   */

      /* Empieza nodo:93 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(93)).setAttribute("nombre","Anterior7" );
      ((Element)v.get(93)).setAttribute("x","13" );
      ((Element)v.get(93)).setAttribute("y","925" );
      ((Element)v.get(93)).setAttribute("ID","botonContenido" );
      ((Element)v.get(93)).setAttribute("tipo","html" );
      ((Element)v.get(93)).setAttribute("estado","false" );
      ((Element)v.get(93)).setAttribute("cod","1649" );
      ((Element)v.get(93)).setAttribute("accion","anteriorPestanya();" );
      ((Element)v.get(3)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(94)).setAttribute("nombre","Siguiente7" );
      ((Element)v.get(94)).setAttribute("x","71" );
      ((Element)v.get(94)).setAttribute("y","925" );
      ((Element)v.get(94)).setAttribute("ID","botonContenido" );
      ((Element)v.get(94)).setAttribute("tipo","html" );
      ((Element)v.get(94)).setAttribute("estado","false" );
      ((Element)v.get(94)).setAttribute("cod","446" );
      ((Element)v.get(94)).setAttribute("accion","siguientePestanya();" );
      ((Element)v.get(3)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:3   */


   }

}
