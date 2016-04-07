
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cronograma_cobranza_periodo_generar_3  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cronograma_cobranza_periodo_generar_3" );
      ((Element)v.get(0)).setAttribute("cod","0264" );
      ((Element)v.get(0)).setAttribute("titulo","Generar cronograma de cobranza para período" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Generar cronograma de cobranza para período" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_cronograma_cobranza_periodo_generar_3.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hMensaje" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hFechaCierre" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hFechaEvaluacion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hFechaAuditoria" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(15)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("table"));
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(16)).setAttribute("border","0" );
      ((Element)v.get(16)).setAttribute("cellspacing","0" );
      ((Element)v.get(16)).setAttribute("cellpadding","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).setAttribute("width","578" );
      ((Element)v.get(19)).setAttribute("height","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(20)).setAttribute("nombre","listado1" );
      ((Element)v.get(20)).setAttribute("ancho","554" );
      ((Element)v.get(20)).setAttribute("alto","317" );
      ((Element)v.get(20)).setAttribute("x","12" );
      ((Element)v.get(20)).setAttribute("y","12" );
      ((Element)v.get(20)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(20)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(21)).setAttribute("precarga","S" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("conROver","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(22)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(22)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(22)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(22)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(23)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(23)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(23)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(23)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(24)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(24)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:21   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(26)).setAttribute("borde","1" );
      ((Element)v.get(26)).setAttribute("horizDatos","1" );
      ((Element)v.get(26)).setAttribute("horizCabecera","1" );
      ((Element)v.get(26)).setAttribute("vertical","1" );
      ((Element)v.get(26)).setAttribute("horizTitulo","1" );
      ((Element)v.get(26)).setAttribute("horizBase","1" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 25   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(27)).setAttribute("borde","#999999" );
      ((Element)v.get(27)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(27)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(27)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(27)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(27)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(27)).setAttribute("horizBase","#999999" );
      ((Element)v.get(25)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:25   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(28)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(28)).setAttribute("alto","22" );
      ((Element)v.get(28)).setAttribute("imgFondo","" );
      ((Element)v.get(28)).setAttribute("cod","00450" );
      ((Element)v.get(28)).setAttribute("ID","datosTitle" );
      ((Element)v.get(20)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 20   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(29)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(29)).setAttribute("alto","22" );
      ((Element)v.get(29)).setAttribute("imgFondo","" );
      ((Element)v.get(20)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 20   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(30)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(30)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(30)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(30)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(30)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(30)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("ancho","100" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","130" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","100" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","100" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("ancho","100" );
      ((Element)v.get(36)).setAttribute("minimizable","S" );
      ((Element)v.get(36)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","100" );
      ((Element)v.get(37)).setAttribute("minimizable","S" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","100" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","100" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","100" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","100" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","130" );
      ((Element)v.get(43)).setAttribute("minimizable","S" );
      ((Element)v.get(43)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("ancho","130" );
      ((Element)v.get(44)).setAttribute("minimizable","S" );
      ((Element)v.get(44)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","130" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","100" );
      ((Element)v.get(46)).setAttribute("oculta","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","100" );
      ((Element)v.get(47)).setAttribute("oculta","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:30   */

      /* Empieza nodo:48 / Elemento padre: 20   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(48)).setAttribute("alto","20" );
      ((Element)v.get(48)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(48)).setAttribute("imgFondo","" );
      ((Element)v.get(48)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(20)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("colFondo","" );
      ((Element)v.get(49)).setAttribute("ID","EstCab" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cod","2512" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cod","1219" );
      ((Element)v.get(48)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("colFondo","" );
      ((Element)v.get(51)).setAttribute("ID","EstCab" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("cod","865" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("colFondo","" );
      ((Element)v.get(52)).setAttribute("ID","EstCab" );
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(52)).setAttribute("cod","999" );
      ((Element)v.get(48)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("colFondo","" );
      ((Element)v.get(53)).setAttribute("ID","EstCab" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cod","6" );
      ((Element)v.get(48)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("colFondo","" );
      ((Element)v.get(54)).setAttribute("ID","EstCab" );
      ((Element)v.get(54)).setAttribute("align","center" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(54)).setAttribute("cod","7" );
      ((Element)v.get(48)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("colFondo","" );
      ((Element)v.get(55)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cod","276" );
      ((Element)v.get(48)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("colFondo","" );
      ((Element)v.get(56)).setAttribute("ID","EstCab" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cod","124" );
      ((Element)v.get(48)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("colFondo","" );
      ((Element)v.get(57)).setAttribute("ID","EstCab" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("cod","109" );
      ((Element)v.get(48)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("colFondo","" );
      ((Element)v.get(58)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cod","143" );
      ((Element)v.get(48)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("colFondo","" );
      ((Element)v.get(59)).setAttribute("ID","EstCab" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cod","112" );
      ((Element)v.get(48)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("colFondo","" );
      ((Element)v.get(60)).setAttribute("ID","EstCab" );
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(60)).setAttribute("cod","126" );
      ((Element)v.get(48)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cod","645" );
      ((Element)v.get(48)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cod","875" );
      ((Element)v.get(48)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cod","871" );
      ((Element)v.get(48)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("oculta","S" );
      ((Element)v.get(48)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 48   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("oculta","S" );
      ((Element)v.get(48)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:48   */

      /* Empieza nodo:66 / Elemento padre: 20   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(66)).setAttribute("alto","22" );
      ((Element)v.get(66)).setAttribute("accion","" );
      ((Element)v.get(66)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(66)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(66)).setAttribute("maxSel","-1" );
      ((Element)v.get(66)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(66)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(66)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(66)).setAttribute("onLoad","" );
      ((Element)v.get(66)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(20)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("tipo","texto" );
      ((Element)v.get(67)).setAttribute("ID","EstDat" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("tipo","texto" );
      ((Element)v.get(68)).setAttribute("ID","EstDat2" );
      ((Element)v.get(66)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("tipo","texto" );
      ((Element)v.get(69)).setAttribute("ID","EstDat" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 66   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("tipo","texto" );
      ((Element)v.get(70)).setAttribute("ID","EstDat2" );
      ((Element)v.get(66)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("tipo","texto" );
      ((Element)v.get(71)).setAttribute("ID","EstDat" );
      ((Element)v.get(66)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("tipo","texto" );
      ((Element)v.get(72)).setAttribute("ID","EstDat2" );
      ((Element)v.get(66)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("tipo","texto" );
      ((Element)v.get(73)).setAttribute("ID","EstDat" );
      ((Element)v.get(66)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("tipo","texto" );
      ((Element)v.get(74)).setAttribute("ID","EstDat2" );
      ((Element)v.get(66)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("tipo","texto" );
      ((Element)v.get(75)).setAttribute("ID","EstDat" );
      ((Element)v.get(66)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("tipo","texto" );
      ((Element)v.get(76)).setAttribute("ID","EstDat2" );
      ((Element)v.get(66)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("tipo","texto" );
      ((Element)v.get(77)).setAttribute("ID","EstDat" );
      ((Element)v.get(66)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("tipo","texto" );
      ((Element)v.get(78)).setAttribute("ID","EstDat2" );
      ((Element)v.get(66)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(79)).setAttribute("nombre","FechaCierre" );
      ((Element)v.get(79)).setAttribute("size","12" );
      ((Element)v.get(79)).setAttribute("max","10" );
      ((Element)v.get(79)).setAttribute("ID","EstDat" );
      ((Element)v.get(79)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(66)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(80)).setAttribute("nombre","FechaEvaluacion" );
      ((Element)v.get(80)).setAttribute("size","12" );
      ((Element)v.get(80)).setAttribute("max","10" );
      ((Element)v.get(80)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(66)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(81)).setAttribute("nombre","FechaAuditoria" );
      ((Element)v.get(81)).setAttribute("size","12" );
      ((Element)v.get(81)).setAttribute("max","10" );
      ((Element)v.get(81)).setAttribute("ID","EstDat" );
      ((Element)v.get(81)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(66)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("tipo","texto" );
      ((Element)v.get(82)).setAttribute("oculta","S" );
      ((Element)v.get(82)).setAttribute("nombre","FechaMin" );
      ((Element)v.get(66)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("oculta","S" );
      ((Element)v.get(83)).setAttribute("nombre","FechaMax" );
      ((Element)v.get(66)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:66   */

      /* Empieza nodo:84 / Elemento padre: 20   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(20)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 20   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(85)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(85)).setAttribute("ancho","554" );
      ((Element)v.get(85)).setAttribute("sep","$" );
      ((Element)v.get(85)).setAttribute("x","12" );
      ((Element)v.get(85)).setAttribute("class","botonera" );
      ((Element)v.get(85)).setAttribute("y","306" );
      ((Element)v.get(85)).setAttribute("control","|" );
      ((Element)v.get(85)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(85)).setAttribute("rowset","" );
      ((Element)v.get(85)).setAttribute("cargainicial","N" );
      ((Element)v.get(20)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(86)).setAttribute("nombre","ret1" );
      ((Element)v.get(86)).setAttribute("x","37" );
      ((Element)v.get(86)).setAttribute("y","310" );
      ((Element)v.get(86)).setAttribute("ID","botonContenido" );
      ((Element)v.get(86)).setAttribute("img","retroceder_on" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(86)).setAttribute("tipo","0" );
      ((Element)v.get(86)).setAttribute("estado","false" );
      ((Element)v.get(86)).setAttribute("alt","" );
      ((Element)v.get(86)).setAttribute("codigo","" );
      ((Element)v.get(86)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 85   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(87)).setAttribute("nombre","ava1" );
      ((Element)v.get(87)).setAttribute("x","52" );
      ((Element)v.get(87)).setAttribute("y","310" );
      ((Element)v.get(87)).setAttribute("ID","botonContenido" );
      ((Element)v.get(87)).setAttribute("img","avanzar_on" );
      ((Element)v.get(87)).setAttribute("tipo","0" );
      ((Element)v.get(87)).setAttribute("estado","false" );
      ((Element)v.get(87)).setAttribute("alt","" );
      ((Element)v.get(87)).setAttribute("codigo","" );
      ((Element)v.get(87)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(85)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:85   */
      /* Termina nodo:20   */

      /* Empieza nodo:88 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(88)).setAttribute("nombre","primera1" );
      ((Element)v.get(88)).setAttribute("x","20" );
      ((Element)v.get(88)).setAttribute("y","310" );
      ((Element)v.get(88)).setAttribute("ID","botonContenido" );
      ((Element)v.get(88)).setAttribute("img","primera_on" );
      ((Element)v.get(88)).setAttribute("tipo","-2" );
      ((Element)v.get(88)).setAttribute("estado","false" );
      ((Element)v.get(88)).setAttribute("alt","" );
      ((Element)v.get(88)).setAttribute("codigo","" );
      ((Element)v.get(88)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(89)).setAttribute("nombre","separa" );
      ((Element)v.get(89)).setAttribute("x","59" );
      ((Element)v.get(89)).setAttribute("y","306" );
      ((Element)v.get(89)).setAttribute("ID","botonContenido" );
      ((Element)v.get(89)).setAttribute("img","separa_base" );
      ((Element)v.get(89)).setAttribute("tipo","0" );
      ((Element)v.get(89)).setAttribute("estado","false" );
      ((Element)v.get(89)).setAttribute("alt","" );
      ((Element)v.get(89)).setAttribute("codigo","" );
      ((Element)v.get(89)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(90)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(90)).setAttribute("alto","12" );
      ((Element)v.get(90)).setAttribute("ancho","50" );
      ((Element)v.get(90)).setAttribute("colorf","" );
      ((Element)v.get(90)).setAttribute("borde","0" );
      ((Element)v.get(90)).setAttribute("imagenf","" );
      ((Element)v.get(90)).setAttribute("repeat","" );
      ((Element)v.get(90)).setAttribute("padding","" );
      ((Element)v.get(90)).setAttribute("visibilidad","visible" );
      ((Element)v.get(90)).setAttribute("contravsb","" );
      ((Element)v.get(90)).setAttribute("x","0" );
      ((Element)v.get(90)).setAttribute("y","329" );
      ((Element)v.get(90)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:5   */


   }

}
