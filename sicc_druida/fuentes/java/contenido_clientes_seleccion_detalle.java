
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_seleccion_detalle  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_seleccion_detalle" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_clientes_seleccion_detalle.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","idioma" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","pais" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
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
      ((Element)v.get(14)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidTipoCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","codigoTipoCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(18)).setAttribute("nombre","listado1" );
      ((Element)v.get(18)).setAttribute("ancho","500" );
      ((Element)v.get(18)).setAttribute("alto","317" );
      ((Element)v.get(18)).setAttribute("x","12" );
      ((Element)v.get(18)).setAttribute("y","12" );
      ((Element)v.get(18)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(18)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(19)).setAttribute("precarga","S" );
      ((Element)v.get(19)).setAttribute("conROver","S" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(20)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(20)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(20)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(20)).setAttribute("desactivado","btnLista2D.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(21)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(21)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(21)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(21)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(22)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(22)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:19   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(24)).setAttribute("borde","1" );
      ((Element)v.get(24)).setAttribute("horizDatos","1" );
      ((Element)v.get(24)).setAttribute("horizCabecera","1" );
      ((Element)v.get(24)).setAttribute("vertical","0" );
      ((Element)v.get(24)).setAttribute("horizTitulo","1" );
      ((Element)v.get(24)).setAttribute("horizBase","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 23   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(25)).setAttribute("borde","#999999" );
      ((Element)v.get(25)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(25)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(25)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(25)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(25)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(25)).setAttribute("horizBase","#999999" );
      ((Element)v.get(23)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:23   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(26)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(26)).setAttribute("alto","22" );
      ((Element)v.get(26)).setAttribute("imgFondo","" );
      ((Element)v.get(26)).setAttribute("cod","0026" );
      ((Element)v.get(26)).setAttribute("ID","datosTitle" );
      ((Element)v.get(18)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 18   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(27)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(27)).setAttribute("alto","22" );
      ((Element)v.get(27)).setAttribute("imgFondo","" );
      ((Element)v.get(18)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 18   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(28)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(28)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(28)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(28)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(28)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(28)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(18)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(29)).setAttribute("ancho","100" );
      ((Element)v.get(29)).setAttribute("minimizable","S" );
      ((Element)v.get(29)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("ancho","100" );
      ((Element)v.get(30)).setAttribute("minimizable","S" );
      ((Element)v.get(30)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).setAttribute("oculta","S" );
      ((Element)v.get(28)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("ancho","100" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","100" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","100" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","100" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:28   */

      /* Empieza nodo:36 / Elemento padre: 18   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(36)).setAttribute("alto","20" );
      ((Element)v.get(36)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(36)).setAttribute("imgFondo","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(18)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("colFondo","" );
      ((Element)v.get(37)).setAttribute("ID","EstCab" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cod","263" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("colFondo","" );
      ((Element)v.get(38)).setAttribute("ID","EstCab" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cod","393" );
      ((Element)v.get(36)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("colFondo","" );
      ((Element)v.get(39)).setAttribute("ID","EstCab" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("cod","393" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("colFondo","" );
      ((Element)v.get(40)).setAttribute("ID","EstCab" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cod","93" );
      ((Element)v.get(36)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("colFondo","" );
      ((Element)v.get(41)).setAttribute("ID","EstCab" );
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("cod","94" );
      ((Element)v.get(36)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("colFondo","" );
      ((Element)v.get(42)).setAttribute("ID","EstCab" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cod","16" );
      ((Element)v.get(36)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("colFondo","" );
      ((Element)v.get(43)).setAttribute("ID","EstCab" );
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("cod","17" );
      ((Element)v.get(36)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:36   */

      /* Empieza nodo:44 / Elemento padre: 18   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(44)).setAttribute("alto","22" );
      ((Element)v.get(44)).setAttribute("accion","seleccionaFila(FILAEVENTO);" );
      ((Element)v.get(44)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(44)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(44)).setAttribute("maxSel","1" );
      ((Element)v.get(44)).setAttribute("deseleccionaSiMaxSel","S" );
      ((Element)v.get(44)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(44)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(44)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(44)).setAttribute("onLoad","" );
      ((Element)v.get(44)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(18)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("tipo","texto" );
      ((Element)v.get(45)).setAttribute("ID","EstDat" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("tipo","texto" );
      ((Element)v.get(46)).setAttribute("ID","EstDat" );
      ((Element)v.get(44)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("tipo","texto" );
      ((Element)v.get(47)).setAttribute("ID","EstDat2" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("tipo","texto" );
      ((Element)v.get(48)).setAttribute("ID","EstDat" );
      ((Element)v.get(44)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("tipo","texto" );
      ((Element)v.get(49)).setAttribute("ID","EstDat2" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("tipo","texto" );
      ((Element)v.get(50)).setAttribute("ID","EstDat" );
      ((Element)v.get(44)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("tipo","texto" );
      ((Element)v.get(51)).setAttribute("ID","EstDat2" );
      ((Element)v.get(44)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:44   */

      /* Empieza nodo:52 / Elemento padre: 18   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(18)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:18   */

      /* Empieza nodo:53 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(53)).setAttribute("nombre","btnVerFicha" );
      ((Element)v.get(53)).setAttribute("x","20" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(53)).setAttribute("y","307" );
      ((Element)v.get(53)).setAttribute("ID","botonContenido" );
      ((Element)v.get(53)).setAttribute("tipo","html" );
      ((Element)v.get(53)).setAttribute("accion","accionVerFicha();" );
      ((Element)v.get(53)).setAttribute("ontab","document.all['btnVerFicha'].focus();" );
      ((Element)v.get(53)).setAttribute("onshtab","document.all['btnVerFicha'].focus();" );
      ((Element)v.get(53)).setAttribute("estado","false" );
      ((Element)v.get(53)).setAttribute("cod","2074" );
      ((Element)v.get(6)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(54)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(54)).setAttribute("alto","12" );
      ((Element)v.get(54)).setAttribute("ancho","100%" );
      ((Element)v.get(54)).setAttribute("colorf","" );
      ((Element)v.get(54)).setAttribute("borde","0" );
      ((Element)v.get(54)).setAttribute("imagenf","" );
      ((Element)v.get(54)).setAttribute("repeat","" );
      ((Element)v.get(54)).setAttribute("padding","" );
      ((Element)v.get(54)).setAttribute("visibilidad","visible" );
      ((Element)v.get(54)).setAttribute("contravsb","" );
      ((Element)v.get(54)).setAttribute("x","0" );
      ((Element)v.get(54)).setAttribute("y","329" );
      ((Element)v.get(54)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:6   */


   }

}
