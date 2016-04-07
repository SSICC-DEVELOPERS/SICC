
import org.w3c.dom.*;
import java.util.ArrayList;

public class MsgParamMensaPageList  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(0)).setAttribute("nombre","msgParamMensaList" );
      ((Element)v.get(0)).setAttribute("ancho","680" );
      ((Element)v.get(0)).setAttribute("alto","275" );
      ((Element)v.get(0)).setAttribute("x","12" );
      ((Element)v.get(0)).setAttribute("y","0" );
      ((Element)v.get(0)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(0)).setAttribute("msgDebugJS","S" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1)).setAttribute("precarga","S" );
      ((Element)v.get(1)).setAttribute("conROver","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(2)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(2)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(2)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(2)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(3)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(3)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(3)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(3)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */
      /* Termina nodo:1   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(5)).setAttribute("borde","1" );
      ((Element)v.get(5)).setAttribute("horizDatos","1" );
      ((Element)v.get(5)).setAttribute("horizCabecera","1" );
      ((Element)v.get(5)).setAttribute("vertical","1" );
      ((Element)v.get(5)).setAttribute("horizTitulo","1" );
      ((Element)v.get(5)).setAttribute("horizBase","1" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(6)).setAttribute("borde","#999999" );
      ((Element)v.get(6)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(6)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(6)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(6)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(6)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(6)).setAttribute("horizBase","#999999" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:4   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(7)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(7)).setAttribute("alto","22" );
      ((Element)v.get(7)).setAttribute("imgFondo","" );
      ((Element)v.get(7)).setAttribute("cod","00135" );
      ((Element)v.get(7)).setAttribute("ID","datosTitle" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(8)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(8)).setAttribute("alto","22" );
      ((Element)v.get(8)).setAttribute("imgFondo","" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(9)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(9)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(9)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(9)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(9)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(10)).setAttribute("ancho","100" );
      ((Element)v.get(10)).setAttribute("minimizable","S" );
      ((Element)v.get(10)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(11)).setAttribute("ancho","100" );
      ((Element)v.get(11)).setAttribute("minimizable","S" );
      ((Element)v.get(11)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(12)).setAttribute("ancho","100" );
      ((Element)v.get(12)).setAttribute("minimizable","S" );
      ((Element)v.get(12)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:9   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(13)).setAttribute("height","20" );
      ((Element)v.get(13)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(13)).setAttribute("imgFondo","" );
      ((Element)v.get(13)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(14)).setAttribute("colFondo","" );
      ((Element)v.get(14)).setAttribute("ID","EstCab" );
      ((Element)v.get(14)).setAttribute("cod","MsgParamMensa.codDatoVari.label" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(15)).setAttribute("colFondo","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).setAttribute("ID","EstCab" );
      ((Element)v.get(15)).setAttribute("cod","MsgParamMensa.desDatoVari.label" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(16)).setAttribute("colFondo","" );
      ((Element)v.get(16)).setAttribute("ID","EstCab" );
      ((Element)v.get(16)).setAttribute("cod","MsgParamMensa.fecSist.label" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:13   */

      /* Empieza nodo:17 / Elemento padre: 0   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(17)).setAttribute("alto","22" );
      ((Element)v.get(17)).setAttribute("accion","" );
      ((Element)v.get(17)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(17)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(17)).setAttribute("maxSel","1" );
      ((Element)v.get(17)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(17)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(17)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(17)).setAttribute("onLoad","" );
      ((Element)v.get(17)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(0)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(18)).setAttribute("tipo","texto" );
      ((Element)v.get(18)).setAttribute("ID","EstDat" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 17   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(19)).setAttribute("tipo","texto" );
      ((Element)v.get(19)).setAttribute("ID","EstDat2" );
      ((Element)v.get(17)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(20)).setAttribute("tipo","texto" );
      ((Element)v.get(20)).setAttribute("ID","EstDat" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:17   */

      /* Empieza nodo:21 / Elemento padre: 0   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(0)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */


   }

}
