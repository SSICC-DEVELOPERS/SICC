
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cliente_consultar_detalle_p4  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cliente_consultar_detalle_p4" );
      ((Element)v.get(0)).setAttribute("cod","0410" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Clientes detalle" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar Clientes detalle" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_cliente_consultar_detalle_p4.js" );
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
      ((Element)v.get(8)).setAttribute("nombre","listado8" );
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
      ((Element)v.get(15)).setAttribute("cod","0058" );
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
      ((Element)v.get(17)).setAttribute("ancho","80" );
      ((Element)v.get(17)).setAttribute("minimizable","S" );
      ((Element)v.get(17)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(18)).setAttribute("ancho","95" );
      ((Element)v.get(18)).setAttribute("minimizable","S" );
      ((Element)v.get(18)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(19)).setAttribute("ancho","215" );
      ((Element)v.get(19)).setAttribute("minimizable","S" );
      ((Element)v.get(19)).setAttribute("minimizada","N" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:16   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(20)).setAttribute("alto","20" );
      ((Element)v.get(20)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(20)).setAttribute("imgFondo","" );
      ((Element)v.get(20)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(21)).setAttribute("colFondo","" );
      ((Element)v.get(21)).setAttribute("ID","EstCab" );
      ((Element)v.get(21)).setAttribute("align","center" );
      ((Element)v.get(21)).setAttribute("cod","1130" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 20   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(22)).setAttribute("colFondo","" );
      ((Element)v.get(22)).setAttribute("ID","EstCab" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(22)).setAttribute("cod","1057" );
      ((Element)v.get(20)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(23)).setAttribute("colFondo","" );
      ((Element)v.get(23)).setAttribute("ID","EstCab" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(23)).setAttribute("cod","1075" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:20   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(24)).setAttribute("alto","22" );
      ((Element)v.get(24)).setAttribute("accion","" );
      ((Element)v.get(24)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(24)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(24)).setAttribute("maxSel","-1" );
      ((Element)v.get(24)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(24)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(24)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(24)).setAttribute("onLoad","" );
      ((Element)v.get(24)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(25)).setAttribute("tipo","texto" );
      ((Element)v.get(25)).setAttribute("ID","EstDat" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("tipo","texto" );
      ((Element)v.get(26)).setAttribute("ID","EstDat2" );
      ((Element)v.get(24)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(27)).setAttribute("tipo","texto" );
      ((Element)v.get(27)).setAttribute("ID","EstDat" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:24   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:8   */

      /* Empieza nodo:29 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(29)).setAttribute("nombre","listado9" );
      ((Element)v.get(29)).setAttribute("ancho","711" );
      ((Element)v.get(29)).setAttribute("alto","293" );
      ((Element)v.get(29)).setAttribute("x","12" );
      ((Element)v.get(29)).setAttribute("y","330" );
      ((Element)v.get(29)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(29)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(30)).setAttribute("precarga","S" );
      ((Element)v.get(30)).setAttribute("conROver","S" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(31)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(31)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(31)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(31)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(32)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(32)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(32)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(32)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:30   */

      /* Empieza nodo:33 / Elemento padre: 29   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(29)).appendChild((Element)v.get(33));

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

      /* Empieza nodo:36 / Elemento padre: 29   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(36)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(36)).setAttribute("alto","22" );
      ((Element)v.get(36)).setAttribute("imgFondo","" );
      ((Element)v.get(36)).setAttribute("cod","0059" );
      ((Element)v.get(36)).setAttribute("ID","datosTitle" );
      ((Element)v.get(29)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 29   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(37)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(37)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(37)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(37)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(37)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(29)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","100" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","100" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","100" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","100" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","75" );
      ((Element)v.get(43)).setAttribute("minimizable","S" );
      ((Element)v.get(43)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 29   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(44)).setAttribute("alto","20" );
      ((Element)v.get(44)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(44)).setAttribute("imgFondo","" );
      ((Element)v.get(44)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(29)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("cod","6" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("colFondo","" );
      ((Element)v.get(46)).setAttribute("ID","EstCab" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("cod","7" );
      ((Element)v.get(44)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("colFondo","" );
      ((Element)v.get(47)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("cod","1869" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 44   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("colFondo","" );
      ((Element)v.get(48)).setAttribute("ID","EstCab" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("cod","595" );
      ((Element)v.get(44)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("colFondo","" );
      ((Element)v.get(49)).setAttribute("ID","EstCab" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cod","756" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cod","550" );
      ((Element)v.get(44)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:44   */

      /* Empieza nodo:51 / Elemento padre: 29   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(51)).setAttribute("alto","22" );
      ((Element)v.get(51)).setAttribute("accion","" );
      ((Element)v.get(51)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(51)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(51)).setAttribute("maxSel","-1" );
      ((Element)v.get(51)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(51)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(51)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(51)).setAttribute("onLoad","" );
      ((Element)v.get(51)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(29)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("tipo","texto" );
      ((Element)v.get(52)).setAttribute("ID","EstDat" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("tipo","texto" );
      ((Element)v.get(53)).setAttribute("ID","EstDat2" );
      ((Element)v.get(51)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("tipo","texto" );
      ((Element)v.get(54)).setAttribute("ID","EstDat" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("tipo","texto" );
      ((Element)v.get(55)).setAttribute("ID","EstDat2" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("tipo","texto" );
      ((Element)v.get(56)).setAttribute("ID","EstDat" );
      ((Element)v.get(51)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 51   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("tipo","texto" );
      ((Element)v.get(57)).setAttribute("ID","EstDat2" );
      ((Element)v.get(51)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:51   */

      /* Empieza nodo:58 / Elemento padre: 29   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(29)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:29   */

      /* Empieza nodo:59 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(59)).setAttribute("nombre","listado10" );
      ((Element)v.get(59)).setAttribute("ancho","711" );
      ((Element)v.get(59)).setAttribute("alto","294" );
      ((Element)v.get(59)).setAttribute("x","12" );
      ((Element)v.get(59)).setAttribute("y","647" );
      ((Element)v.get(59)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(59)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(60)).setAttribute("precarga","S" );
      ((Element)v.get(60)).setAttribute("conROver","S" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(61)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(61)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(61)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(61)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 60   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(62)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(62)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(62)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(62)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(60)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:60   */

      /* Empieza nodo:63 / Elemento padre: 59   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(59)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(64)).setAttribute("borde","1" );
      ((Element)v.get(64)).setAttribute("horizDatos","1" );
      ((Element)v.get(64)).setAttribute("horizCabecera","1" );
      ((Element)v.get(64)).setAttribute("vertical","1" );
      ((Element)v.get(64)).setAttribute("horizTitulo","1" );
      ((Element)v.get(64)).setAttribute("horizBase","1" );
   }

   private void getXML360(Document doc) {
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

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(66)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(66)).setAttribute("alto","22" );
      ((Element)v.get(66)).setAttribute("imgFondo","" );
      ((Element)v.get(66)).setAttribute("cod","0060" );
      ((Element)v.get(66)).setAttribute("ID","datosTitle" );
      ((Element)v.get(59)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 59   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(67)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(67)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(67)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(67)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(67)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(59)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("ancho","97" );
      ((Element)v.get(68)).setAttribute("minimizable","S" );
      ((Element)v.get(68)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("ancho","305" );
      ((Element)v.get(69)).setAttribute("minimizable","S" );
      ((Element)v.get(69)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("ancho","55" );
      ((Element)v.get(70)).setAttribute("minimizable","S" );
      ((Element)v.get(70)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("ancho","90" );
      ((Element)v.get(71)).setAttribute("minimizable","S" );
      ((Element)v.get(71)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("ancho","305" );
      ((Element)v.get(72)).setAttribute("minimizable","S" );
      ((Element)v.get(72)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("ancho","305" );
      ((Element)v.get(73)).setAttribute("minimizable","S" );
      ((Element)v.get(73)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:67   */

      /* Empieza nodo:74 / Elemento padre: 59   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(74)).setAttribute("alto","20" );
      ((Element)v.get(74)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(74)).setAttribute("imgFondo","" );
      ((Element)v.get(74)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(59)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("colFondo","" );
      ((Element)v.get(75)).setAttribute("ID","EstCab" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cod","1128" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 74   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(76)).setAttribute("cod","1067" );
      ((Element)v.get(74)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("colFondo","" );
      ((Element)v.get(77)).setAttribute("ID","EstCab" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(77)).setAttribute("cod","1123" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 74   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("colFondo","" );
      ((Element)v.get(78)).setAttribute("ID","EstCab" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(78)).setAttribute("cod","1129" );
      ((Element)v.get(74)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("colFondo","" );
      ((Element)v.get(79)).setAttribute("ID","EstCab" );
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(79)).setAttribute("cod","1069" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 74   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("colFondo","" );
      ((Element)v.get(80)).setAttribute("ID","EstCab" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cod","1096" );
      ((Element)v.get(74)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:74   */

      /* Empieza nodo:81 / Elemento padre: 59   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(81)).setAttribute("alto","22" );
      ((Element)v.get(81)).setAttribute("accion","" );
      ((Element)v.get(81)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(81)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(81)).setAttribute("maxSel","-1" );
      ((Element)v.get(81)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(81)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(81)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(81)).setAttribute("onLoad","" );
      ((Element)v.get(81)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(59)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("tipo","texto" );
      ((Element)v.get(82)).setAttribute("ID","EstDat" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("ID","EstDat2" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("tipo","texto" );
      ((Element)v.get(84)).setAttribute("ID","EstDat" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("tipo","texto" );
      ((Element)v.get(85)).setAttribute("ID","EstDat2" );
      ((Element)v.get(81)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("tipo","texto" );
      ((Element)v.get(86)).setAttribute("ID","EstDat" );
      ((Element)v.get(81)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("tipo","texto" );
      ((Element)v.get(87)).setAttribute("ID","EstDat2" );
      ((Element)v.get(81)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:81   */

      /* Empieza nodo:88 / Elemento padre: 59   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(59)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:59   */

      /* Empieza nodo:89 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(89)).setAttribute("nombre","listado11" );
      ((Element)v.get(89)).setAttribute("ancho","711" );
      ((Element)v.get(89)).setAttribute("alto","317" );
      ((Element)v.get(89)).setAttribute("x","12" );
      ((Element)v.get(89)).setAttribute("y","966" );
      ((Element)v.get(89)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(89)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(90)).setAttribute("precarga","S" );
      ((Element)v.get(90)).setAttribute("conROver","S" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(91)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(91)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(91)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(91)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 90   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(92)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(92)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(92)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(92)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(89)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(94)).setAttribute("borde","1" );
      ((Element)v.get(94)).setAttribute("horizDatos","1" );
      ((Element)v.get(94)).setAttribute("horizCabecera","1" );
      ((Element)v.get(94)).setAttribute("vertical","1" );
      ((Element)v.get(94)).setAttribute("horizTitulo","1" );
      ((Element)v.get(94)).setAttribute("horizBase","1" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(95)).setAttribute("borde","#999999" );
      ((Element)v.get(95)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(95)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(95)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(95)).setAttribute("horizBase","#999999" );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(96)).setAttribute("colFondo","#CECFCE" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(96)).setAttribute("alto","22" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("cod","00155" );
      ((Element)v.get(96)).setAttribute("ID","datosTitle" );
      ((Element)v.get(89)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 89   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(97)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(97)).setAttribute("alto","22" );
      ((Element)v.get(97)).setAttribute("imgFondo","" );
      ((Element)v.get(89)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(98)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(98)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(98)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(98)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(98)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","220" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","77" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","77" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("ancho","77" );
      ((Element)v.get(102)).setAttribute("minimizable","S" );
      ((Element)v.get(102)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:98   */

      /* Empieza nodo:103 / Elemento padre: 89   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(103)).setAttribute("alto","20" );
      ((Element)v.get(103)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(103)).setAttribute("imgFondo","" );
      ((Element)v.get(103)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(89)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("colFondo","" );
      ((Element)v.get(104)).setAttribute("ID","EstCab" );
      ((Element)v.get(104)).setAttribute("align","center" );
      ((Element)v.get(104)).setAttribute("cod","6" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cod","1365" );
      ((Element)v.get(103)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("colFondo","" );
      ((Element)v.get(106)).setAttribute("ID","EstCab" );
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(106)).setAttribute("cod","1366" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("cod","188" );
      ((Element)v.get(103)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:103   */

      /* Empieza nodo:108 / Elemento padre: 89   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(108)).setAttribute("alto","22" );
      ((Element)v.get(108)).setAttribute("accion","" );
      ((Element)v.get(108)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(108)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(108)).setAttribute("maxSel","-1" );
      ((Element)v.get(108)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(108)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(108)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(108)).setAttribute("onLoad","" );
      ((Element)v.get(108)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(89)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("tipo","texto" );
      ((Element)v.get(109)).setAttribute("ID","EstDat" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("tipo","texto" );
      ((Element)v.get(110)).setAttribute("ID","EstDat2" );
      ((Element)v.get(108)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("tipo","texto" );
      ((Element)v.get(111)).setAttribute("ID","EstDat" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(108)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("tipo","texto" );
      ((Element)v.get(112)).setAttribute("ID","EstDat2" );
      ((Element)v.get(108)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:108   */

      /* Empieza nodo:113 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:89   */

      /* Empieza nodo:114 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(114)).setAttribute("nombre","Anterior11" );
      ((Element)v.get(114)).setAttribute("x","13" );
      ((Element)v.get(114)).setAttribute("y","1261" );
      ((Element)v.get(114)).setAttribute("accion","anteriorPestanya();" );
      ((Element)v.get(114)).setAttribute("ID","botonContenido" );
      ((Element)v.get(114)).setAttribute("tipo","html" );
      ((Element)v.get(114)).setAttribute("estado","false" );
      ((Element)v.get(114)).setAttribute("cod","1649" );
      ((Element)v.get(3)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:3   */


   }

}
