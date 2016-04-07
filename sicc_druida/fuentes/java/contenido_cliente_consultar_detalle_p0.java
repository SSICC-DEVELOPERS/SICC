
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cliente_consultar_detalle_p0  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cliente_consultar_detalle_p0" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_cliente_consultar_detalle_p0.js" );
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
      ((Element)v.get(8)).setAttribute("nombre","listado0" );
      ((Element)v.get(8)).setAttribute("ancho","711" );
      ((Element)v.get(8)).setAttribute("alto","115" );
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

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(12)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(12)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:9   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(8)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(14)).setAttribute("borde","1" );
      ((Element)v.get(14)).setAttribute("horizDatos","1" );
      ((Element)v.get(14)).setAttribute("horizCabecera","1" );
      ((Element)v.get(14)).setAttribute("vertical","1" );
      ((Element)v.get(14)).setAttribute("horizTitulo","1" );
      ((Element)v.get(14)).setAttribute("horizBase","1" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(15)).setAttribute("borde","#999999" );
      ((Element)v.get(15)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(15)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(15)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(15)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(15)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(15)).setAttribute("horizBase","#999999" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:13   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(16)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(16)).setAttribute("alto","22" );
      ((Element)v.get(16)).setAttribute("imgFondo","" );
      ((Element)v.get(16)).setAttribute("cod","00135" );
      ((Element)v.get(16)).setAttribute("ID","datosTitle" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("BASE"));
      ((Element)v.get(17)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(17)).setAttribute("alto","22" );
      ((Element)v.get(17)).setAttribute("imgFondo","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(18)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(18)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(18)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(18)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(18)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(18)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(19)).setAttribute("ancho","30" );
      ((Element)v.get(19)).setAttribute("minimizable","S" );
      ((Element)v.get(19)).setAttribute("minimizada","N" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(20)).setAttribute("ancho","30" );
      ((Element)v.get(20)).setAttribute("minimizable","S" );
      ((Element)v.get(20)).setAttribute("minimizada","N" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:18   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(21)).setAttribute("alto","20" );
      ((Element)v.get(21)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(21)).setAttribute("imgFondo","" );
      ((Element)v.get(21)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(22)).setAttribute("colFondo","" );
      ((Element)v.get(22)).setAttribute("ID","EstCab" );
      ((Element)v.get(22)).setAttribute("cod","393" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(23)).setAttribute("colFondo","" );
      ((Element)v.get(23)).setAttribute("ID","EstCab" );
      ((Element)v.get(23)).setAttribute("cod","595" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:21   */

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
      /* Termina nodo:24   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:8   */

      /* Empieza nodo:28 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(28)).setAttribute("nombre","Siguiente0" );
      ((Element)v.get(28)).setAttribute("x","13" );
      ((Element)v.get(28)).setAttribute("y","105" );
      ((Element)v.get(28)).setAttribute("ID","botonContenido" );
      ((Element)v.get(28)).setAttribute("img","" );
      ((Element)v.get(28)).setAttribute("tipo","html" );
      ((Element)v.get(28)).setAttribute("estado","false" );
      ((Element)v.get(28)).setAttribute("alt","" );
      ((Element)v.get(28)).setAttribute("cod","446" );
      ((Element)v.get(28)).setAttribute("accion","siguientePestanya();" );
      ((Element)v.get(3)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:3   */


   }

}
