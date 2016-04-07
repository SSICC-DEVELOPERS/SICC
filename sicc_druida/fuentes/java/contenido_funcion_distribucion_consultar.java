
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_funcion_distribucion_consultar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_funcion_distribucion_consultar" );
      ((Element)v.get(0)).setAttribute("cod","01066" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar funcion distribucion" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar funcion de distribucion" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_funcion_distribucion_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","validaciones_sicc.js" );
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
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","pais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","idioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(14)).setAttribute("nombre","listado1" );
      ((Element)v.get(14)).setAttribute("ancho","369" );
      ((Element)v.get(14)).setAttribute("alto","301" );
      ((Element)v.get(14)).setAttribute("x","12" );
      ((Element)v.get(14)).setAttribute("y","20" );
      ((Element)v.get(14)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(14)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(15)).setAttribute("precarga","S" );
      ((Element)v.get(15)).setAttribute("conROver","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(16)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(16)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(16)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(16)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(17)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(17)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(17)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(17)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(18)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(18)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:15   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(14)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(20)).setAttribute("borde","1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("horizDatos","1" );
      ((Element)v.get(20)).setAttribute("horizCabecera","1" );
      ((Element)v.get(20)).setAttribute("vertical","1" );
      ((Element)v.get(20)).setAttribute("horizTitulo","1" );
      ((Element)v.get(20)).setAttribute("horizBase","1" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(21)).setAttribute("borde","#999999" );
      ((Element)v.get(21)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(21)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(21)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(21)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(21)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(21)).setAttribute("horizBase","#999999" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:19   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(22)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(22)).setAttribute("alto","22" );
      ((Element)v.get(22)).setAttribute("imgFondo","" );
      ((Element)v.get(22)).setAttribute("cod","00135" );
      ((Element)v.get(22)).setAttribute("ID","datosTitle" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(23)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(23)).setAttribute("alto","22" );
      ((Element)v.get(23)).setAttribute("imgFondo","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(24)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(24)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(24)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(24)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(24)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(24)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(25)).setAttribute("ancho","100" );
      ((Element)v.get(25)).setAttribute("minimizable","S" );
      ((Element)v.get(25)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("ancho","100" );
      ((Element)v.get(26)).setAttribute("minimizable","S" );
      ((Element)v.get(26)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(27)).setAttribute("ancho","100" );
      ((Element)v.get(27)).setAttribute("minimizable","S" );
      ((Element)v.get(27)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:24   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(28)).setAttribute("alto","25" );
      ((Element)v.get(28)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(28)).setAttribute("imgFondo","" );
      ((Element)v.get(28)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(29)).setAttribute("colFondo","" );
      ((Element)v.get(29)).setAttribute("ID","EstCab" );
      ((Element)v.get(29)).setAttribute("cod","8" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Elemento padre:29 / Elemento actual: 30   */
      v.add(doc.createTextNode("Codigo"));
      ((Element)v.get(29)).appendChild((Text)v.get(30));

      /* Termina nodo Texto:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("colFondo","" );
      ((Element)v.get(31)).setAttribute("ID","EstCab" );
      ((Element)v.get(31)).setAttribute("cod","9" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Elemento padre:31 / Elemento actual: 32   */
      v.add(doc.createTextNode("Descipcion"));
      ((Element)v.get(31)).appendChild((Text)v.get(32));

      /* Termina nodo Texto:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 28   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("colFondo","" );
      ((Element)v.get(33)).setAttribute("ID","EstCab" );
      ((Element)v.get(33)).setAttribute("cod","2172" );
      ((Element)v.get(28)).appendChild((Element)v.get(33));

      /* Elemento padre:33 / Elemento actual: 34   */
      v.add(doc.createTextNode("Programa"));
      ((Element)v.get(33)).appendChild((Text)v.get(34));

      /* Termina nodo Texto:34   */
      /* Termina nodo:33   */
      /* Termina nodo:28   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(35)).setAttribute("alto","22" );
      ((Element)v.get(35)).setAttribute("accion","" );
      ((Element)v.get(35)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(35)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(35)).setAttribute("maxSel","0" );
      ((Element)v.get(35)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(35)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(35)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(35)).setAttribute("onLoad","" );
      ((Element)v.get(35)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).setAttribute("tipo","texto" );
      ((Element)v.get(36)).setAttribute("ID","EstDat" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("tipo","texto" );
      ((Element)v.get(37)).setAttribute("ID","EstDat2" );
      ((Element)v.get(35)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("tipo","texto" );
      ((Element)v.get(38)).setAttribute("ID","EstDat" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:35   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:14   */
      /* Termina nodo:6   */


   }

}
