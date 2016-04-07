
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeProduViewPageList  implements es.indra.druida.base.ObjetoXML {
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
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(0)).setAttribute("nombre","maeProduViewList" );
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
      /* Termina nodo:9   */

      /* Empieza nodo:39 / Elemento padre: 0   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(39)).setAttribute("height","20" );
      ((Element)v.get(39)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(39)).setAttribute("imgFondo","" );
      ((Element)v.get(39)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(0)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("colFondo","" );
      ((Element)v.get(40)).setAttribute("ID","EstCab" );
      ((Element)v.get(40)).setAttribute("cod","MaeProduView.paisOidPais.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("colFondo","" );
      ((Element)v.get(41)).setAttribute("ID","EstCab" );
      ((Element)v.get(41)).setAttribute("cod","MaeProduView.codSap.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("colFondo","" );
      ((Element)v.get(42)).setAttribute("ID","EstCab" );
      ((Element)v.get(42)).setAttribute("cod","MaeProduView.codiAnti.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("colFondo","" );
      ((Element)v.get(43)).setAttribute("ID","EstCab" );
      ((Element)v.get(43)).setAttribute("cod","MaeProduView.desCort.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("colFondo","" );
      ((Element)v.get(44)).setAttribute("ID","EstCab" );
      ((Element)v.get(44)).setAttribute("cod","MaeProduView.valJera1.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("cod","MaeProduView.valJera2.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("colFondo","" );
      ((Element)v.get(46)).setAttribute("ID","EstCab" );
      ((Element)v.get(46)).setAttribute("cod","MaeProduView.valJera3.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("colFondo","" );
      ((Element)v.get(47)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).setAttribute("cod","MaeProduView.valAtri1.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("colFondo","" );
      ((Element)v.get(48)).setAttribute("ID","EstCab" );
      ((Element)v.get(48)).setAttribute("cod","MaeProduView.valAtri2.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("colFondo","" );
      ((Element)v.get(49)).setAttribute("ID","EstCab" );
      ((Element)v.get(49)).setAttribute("cod","MaeProduView.valAtri3.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("cod","MaeProduView.valDimeAlto.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("colFondo","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(51)).setAttribute("ID","EstCab" );
      ((Element)v.get(51)).setAttribute("cod","MaeProduView.valDimeLarg.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("colFondo","" );
      ((Element)v.get(52)).setAttribute("ID","EstCab" );
      ((Element)v.get(52)).setAttribute("cod","MaeProduView.valDimeAnch.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("colFondo","" );
      ((Element)v.get(53)).setAttribute("ID","EstCab" );
      ((Element)v.get(53)).setAttribute("cod","MaeProduView.valPeso.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("colFondo","" );
      ((Element)v.get(54)).setAttribute("ID","EstCab" );
      ((Element)v.get(54)).setAttribute("cod","MaeProduView.valVolu.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("colFondo","" );
      ((Element)v.get(55)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).setAttribute("cod","MaeProduView.valCostEstd.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("colFondo","" );
      ((Element)v.get(56)).setAttribute("ID","EstCab" );
      ((Element)v.get(56)).setAttribute("cod","MaeProduView.valPrecPosi.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("colFondo","" );
      ((Element)v.get(57)).setAttribute("ID","EstCab" );
      ((Element)v.get(57)).setAttribute("cod","MaeProduView.valPrecCata.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("colFondo","" );
      ((Element)v.get(58)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).setAttribute("cod","MaeProduView.valPrecCont.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("colFondo","" );
      ((Element)v.get(59)).setAttribute("ID","EstCab" );
      ((Element)v.get(59)).setAttribute("cod","MaeProduView.numUnidDentPedi.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("colFondo","" );
      ((Element)v.get(60)).setAttribute("ID","EstCab" );
      ((Element)v.get(60)).setAttribute("cod","MaeProduView.numUnidCaja.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(61)).setAttribute("cod","MaeProduView.codImpu.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("cod","MaeProduView.pctUnid.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("cod","MaeProduView.indLote.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("cod","MaeProduView.indProdServ.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("cod","MaeProduView.codIndSitu.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("cod","MaeProduView.codIndDentCaja.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("cod","MaeProduView.indKit.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("colFondo","" );
      ((Element)v.get(68)).setAttribute("ID","EstCab" );
      ((Element)v.get(68)).setAttribute("cod","MaeProduView.valGrupArti.label" );
      ((Element)v.get(39)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:39   */

      /* Empieza nodo:69 / Elemento padre: 0   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(69)).setAttribute("alto","22" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(69)).setAttribute("accion","" );
      ((Element)v.get(69)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(69)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(69)).setAttribute("maxSel","1" );
      ((Element)v.get(69)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(69)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(69)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(69)).setAttribute("onLoad","" );
      ((Element)v.get(69)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(0)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("tipo","texto" );
      ((Element)v.get(70)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("tipo","texto" );
      ((Element)v.get(71)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("tipo","texto" );
      ((Element)v.get(72)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("tipo","texto" );
      ((Element)v.get(73)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("tipo","texto" );
      ((Element)v.get(74)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("tipo","texto" );
      ((Element)v.get(75)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("tipo","texto" );
      ((Element)v.get(76)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("tipo","texto" );
      ((Element)v.get(77)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("tipo","texto" );
      ((Element)v.get(78)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","texto" );
      ((Element)v.get(79)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("tipo","texto" );
      ((Element)v.get(80)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("tipo","texto" );
      ((Element)v.get(81)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("tipo","texto" );
      ((Element)v.get(82)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("tipo","texto" );
      ((Element)v.get(84)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("tipo","texto" );
      ((Element)v.get(85)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("tipo","texto" );
      ((Element)v.get(86)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("tipo","texto" );
      ((Element)v.get(87)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("tipo","texto" );
      ((Element)v.get(88)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("tipo","texto" );
      ((Element)v.get(89)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 69   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("tipo","texto" );
      ((Element)v.get(90)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("tipo","texto" );
      ((Element)v.get(91)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("tipo","texto" );
      ((Element)v.get(92)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("tipo","texto" );
      ((Element)v.get(93)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("tipo","texto" );
      ((Element)v.get(94)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("tipo","texto" );
      ((Element)v.get(95)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("tipo","texto" );
      ((Element)v.get(96)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("tipo","texto" );
      ((Element)v.get(97)).setAttribute("ID","EstDat2" );
      ((Element)v.get(69)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 69   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("tipo","texto" );
      ((Element)v.get(98)).setAttribute("ID","EstDat" );
      ((Element)v.get(69)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:69   */

      /* Empieza nodo:99 / Elemento padre: 0   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(0)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */


   }

}
