
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeProduPageList  implements es.indra.druida.base.ObjetoXML {
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
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(0)).setAttribute("nombre","maeProduList" );
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

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(13)).setAttribute("ancho","100" );
      ((Element)v.get(13)).setAttribute("minimizable","S" );
      ((Element)v.get(13)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(14)).setAttribute("ancho","100" );
      ((Element)v.get(14)).setAttribute("minimizable","S" );
      ((Element)v.get(14)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(15)).setAttribute("ancho","100" );
      ((Element)v.get(15)).setAttribute("minimizable","S" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(16)).setAttribute("ancho","100" );
      ((Element)v.get(16)).setAttribute("minimizable","S" );
      ((Element)v.get(16)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(17)).setAttribute("ancho","100" );
      ((Element)v.get(17)).setAttribute("minimizable","S" );
      ((Element)v.get(17)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(18)).setAttribute("ancho","100" );
      ((Element)v.get(18)).setAttribute("minimizable","S" );
      ((Element)v.get(18)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(19)).setAttribute("ancho","100" );
      ((Element)v.get(19)).setAttribute("minimizable","S" );
      ((Element)v.get(19)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(20)).setAttribute("ancho","100" );
      ((Element)v.get(20)).setAttribute("minimizable","S" );
      ((Element)v.get(20)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(21)).setAttribute("ancho","100" );
      ((Element)v.get(21)).setAttribute("minimizable","S" );
      ((Element)v.get(21)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(22)).setAttribute("ancho","100" );
      ((Element)v.get(22)).setAttribute("minimizable","S" );
      ((Element)v.get(22)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(23)).setAttribute("ancho","100" );
      ((Element)v.get(23)).setAttribute("minimizable","S" );
      ((Element)v.get(23)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(24)).setAttribute("ancho","100" );
      ((Element)v.get(24)).setAttribute("minimizable","S" );
      ((Element)v.get(24)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(25)).setAttribute("ancho","100" );
      ((Element)v.get(25)).setAttribute("minimizable","S" );
      ((Element)v.get(25)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("ancho","100" );
      ((Element)v.get(26)).setAttribute("minimizable","S" );
      ((Element)v.get(26)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(27)).setAttribute("ancho","100" );
      ((Element)v.get(27)).setAttribute("minimizable","S" );
      ((Element)v.get(27)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("ancho","100" );
      ((Element)v.get(28)).setAttribute("minimizable","S" );
      ((Element)v.get(28)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(29)).setAttribute("ancho","100" );
      ((Element)v.get(29)).setAttribute("minimizable","S" );
      ((Element)v.get(29)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("ancho","100" );
      ((Element)v.get(30)).setAttribute("minimizable","S" );
      ((Element)v.get(30)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("ancho","100" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","100" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","100" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","100" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("ancho","100" );
      ((Element)v.get(36)).setAttribute("minimizable","S" );
      ((Element)v.get(36)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","100" );
      ((Element)v.get(37)).setAttribute("minimizable","S" );
      ((Element)v.get(37)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","100" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","100" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","100" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","100" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","100" );
      ((Element)v.get(43)).setAttribute("minimizable","S" );
      ((Element)v.get(43)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("ancho","100" );
      ((Element)v.get(44)).setAttribute("minimizable","S" );
      ((Element)v.get(44)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","100" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","100" );
      ((Element)v.get(46)).setAttribute("minimizable","S" );
      ((Element)v.get(46)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","100" );
      ((Element)v.get(47)).setAttribute("minimizable","S" );
      ((Element)v.get(47)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("ancho","100" );
      ((Element)v.get(48)).setAttribute("minimizable","S" );
      ((Element)v.get(48)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("ancho","100" );
      ((Element)v.get(49)).setAttribute("minimizable","S" );
      ((Element)v.get(49)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("ancho","100" );
      ((Element)v.get(50)).setAttribute("minimizable","S" );
      ((Element)v.get(50)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("ancho","100" );
      ((Element)v.get(51)).setAttribute("minimizable","S" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(51)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","100" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 9   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","100" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(9)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:9   */

      /* Empieza nodo:54 / Elemento padre: 0   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(54)).setAttribute("height","20" );
      ((Element)v.get(54)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(54)).setAttribute("imgFondo","" );
      ((Element)v.get(54)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(0)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("colFondo","" );
      ((Element)v.get(55)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).setAttribute("cod","MaeProdu.paisOidPais.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("colFondo","" );
      ((Element)v.get(56)).setAttribute("ID","EstCab" );
      ((Element)v.get(56)).setAttribute("cod","MaeProdu.codSap.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("colFondo","" );
      ((Element)v.get(57)).setAttribute("ID","EstCab" );
      ((Element)v.get(57)).setAttribute("cod","MaeProdu.codiAnti.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("colFondo","" );
      ((Element)v.get(58)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).setAttribute("cod","MaeProdu.desCort.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("colFondo","" );
      ((Element)v.get(59)).setAttribute("ID","EstCab" );
      ((Element)v.get(59)).setAttribute("cod","MaeProdu.valJera1.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("colFondo","" );
      ((Element)v.get(60)).setAttribute("ID","EstCab" );
      ((Element)v.get(60)).setAttribute("cod","MaeProdu.valJera2.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(61)).setAttribute("cod","MaeProdu.valJera3.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("cod","MaeProdu.valAtri1.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("cod","MaeProdu.valAtri2.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("cod","MaeProdu.valAtri3.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("cod","MaeProdu.valDimeAlto.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("cod","MaeProdu.valDimeLarg.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("cod","MaeProdu.valDimeAnch.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("colFondo","" );
      ((Element)v.get(68)).setAttribute("ID","EstCab" );
      ((Element)v.get(68)).setAttribute("cod","MaeProdu.valPeso.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("colFondo","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(69)).setAttribute("ID","EstCab" );
      ((Element)v.get(69)).setAttribute("cod","MaeProdu.valVolu.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("colFondo","" );
      ((Element)v.get(70)).setAttribute("ID","EstCab" );
      ((Element)v.get(70)).setAttribute("cod","MaeProdu.valCostEstd.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("colFondo","" );
      ((Element)v.get(71)).setAttribute("ID","EstCab" );
      ((Element)v.get(71)).setAttribute("cod","MaeProdu.valPrecPosi.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(72)).setAttribute("cod","MaeProdu.valPrecCata.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("colFondo","" );
      ((Element)v.get(73)).setAttribute("ID","EstCab" );
      ((Element)v.get(73)).setAttribute("cod","MaeProdu.valPrecCont.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(74)).setAttribute("cod","MaeProdu.numUnidDentPedi.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("colFondo","" );
      ((Element)v.get(75)).setAttribute("ID","EstCab" );
      ((Element)v.get(75)).setAttribute("cod","MaeProdu.numUnidCaja.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(76)).setAttribute("cod","MaeProdu.codImpu.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("colFondo","" );
      ((Element)v.get(77)).setAttribute("ID","EstCab" );
      ((Element)v.get(77)).setAttribute("cod","MaeProdu.pctUnid.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("colFondo","" );
      ((Element)v.get(78)).setAttribute("ID","EstCab" );
      ((Element)v.get(78)).setAttribute("cod","MaeProdu.geneOidGene.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("colFondo","" );
      ((Element)v.get(79)).setAttribute("ID","EstCab" );
      ((Element)v.get(79)).setAttribute("cod","MaeProdu.sgenOidSupeGene.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("colFondo","" );
      ((Element)v.get(80)).setAttribute("ID","EstCab" );
      ((Element)v.get(80)).setAttribute("cod","MaeProdu.unmdOidUnidMedi.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("colFondo","" );
      ((Element)v.get(81)).setAttribute("ID","EstCab" );
      ((Element)v.get(81)).setAttribute("cod","MaeProdu.unmdOidUnidMediPeso.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("colFondo","" );
      ((Element)v.get(82)).setAttribute("ID","EstCab" );
      ((Element)v.get(82)).setAttribute("cod","MaeProdu.unmdOidUnidMediDime.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("colFondo","" );
      ((Element)v.get(83)).setAttribute("ID","EstCab" );
      ((Element)v.get(83)).setAttribute("cod","MaeProdu.negoOidNego.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("colFondo","" );
      ((Element)v.get(84)).setAttribute("ID","EstCab" );
      ((Element)v.get(84)).setAttribute("cod","MaeProdu.meudOidEstaProd.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("colFondo","" );
      ((Element)v.get(85)).setAttribute("ID","EstCab" );
      ((Element)v.get(85)).setAttribute("cod","MaeProdu.liprOidLineProd.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("colFondo","" );
      ((Element)v.get(86)).setAttribute("ID","EstCab" );
      ((Element)v.get(86)).setAttribute("cod","MaeProdu.unegOidUnidNego.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("colFondo","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(87)).setAttribute("ID","EstCab" );
      ((Element)v.get(87)).setAttribute("cod","MaeProdu.perdOidPeriInic.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("colFondo","" );
      ((Element)v.get(88)).setAttribute("ID","EstCab" );
      ((Element)v.get(88)).setAttribute("cod","MaeProdu.perdOidPeriFin.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("colFondo","" );
      ((Element)v.get(89)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).setAttribute("cod","MaeProdu.indLote.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("colFondo","" );
      ((Element)v.get(90)).setAttribute("ID","EstCab" );
      ((Element)v.get(90)).setAttribute("cod","MaeProdu.indProdServ.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("colFondo","" );
      ((Element)v.get(91)).setAttribute("ID","EstCab" );
      ((Element)v.get(91)).setAttribute("cod","MaeProdu.codIndSitu.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("colFondo","" );
      ((Element)v.get(92)).setAttribute("ID","EstCab" );
      ((Element)v.get(92)).setAttribute("cod","MaeProdu.codIndDentCaja.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("colFondo","" );
      ((Element)v.get(93)).setAttribute("ID","EstCab" );
      ((Element)v.get(93)).setAttribute("cod","MaeProdu.indKit.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("colFondo","" );
      ((Element)v.get(94)).setAttribute("ID","EstCab" );
      ((Element)v.get(94)).setAttribute("cod","MaeProdu.fopaOidFormPago.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("colFondo","" );
      ((Element)v.get(95)).setAttribute("ID","EstCab" );
      ((Element)v.get(95)).setAttribute("cod","MaeProdu.maprOidMarcProd.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("colFondo","" );
      ((Element)v.get(96)).setAttribute("ID","EstCab" );
      ((Element)v.get(96)).setAttribute("cod","MaeProdu.valGrupArti.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("cod","MaeProdu.codUnicVent.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 54   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("colFondo","" );
      ((Element)v.get(98)).setAttribute("ID","EstCab" );
      ((Element)v.get(98)).setAttribute("cod","MaeProdu.prfiOidProgFide.label" );
      ((Element)v.get(54)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:54   */

      /* Empieza nodo:99 / Elemento padre: 0   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(99)).setAttribute("alto","22" );
      ((Element)v.get(99)).setAttribute("accion","" );
      ((Element)v.get(99)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(99)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(99)).setAttribute("maxSel","1" );
      ((Element)v.get(99)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(99)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(99)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(99)).setAttribute("onLoad","" );
      ((Element)v.get(99)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(0)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("tipo","texto" );
      ((Element)v.get(100)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("tipo","texto" );
      ((Element)v.get(101)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("tipo","texto" );
      ((Element)v.get(102)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("tipo","texto" );
      ((Element)v.get(103)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("tipo","texto" );
      ((Element)v.get(104)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 99   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("tipo","texto" );
      ((Element)v.get(105)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("tipo","texto" );
      ((Element)v.get(106)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("tipo","texto" );
      ((Element)v.get(107)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("tipo","texto" );
      ((Element)v.get(108)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("tipo","texto" );
      ((Element)v.get(109)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("tipo","texto" );
      ((Element)v.get(110)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("tipo","texto" );
      ((Element)v.get(111)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("tipo","texto" );
      ((Element)v.get(112)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("tipo","texto" );
      ((Element)v.get(113)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("tipo","texto" );
      ((Element)v.get(114)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("tipo","texto" );
      ((Element)v.get(119)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(127)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("tipo","texto" );
      ((Element)v.get(135)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("tipo","texto" );
      ((Element)v.get(139)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("tipo","texto" );
      ((Element)v.get(140)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("tipo","texto" );
      ((Element)v.get(141)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("tipo","texto" );
      ((Element)v.get(142)).setAttribute("ID","EstDat" );
      ((Element)v.get(99)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("tipo","texto" );
      ((Element)v.get(143)).setAttribute("ID","EstDat2" );
      ((Element)v.get(99)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:99   */

      /* Empieza nodo:144 / Elemento padre: 0   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(0)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */


   }

}
