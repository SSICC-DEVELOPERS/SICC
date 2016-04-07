
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_desglose_numero_solicitud_consultar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML720(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_desglose_numero_solicitud_consultar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_desglose_numero_solicitud_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
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
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoDeUso" );
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
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","pais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","fechaInicio" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","fechaFin" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidTipoSolicitud" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","marca" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","canal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","zona" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","grupoProcesos" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","tipoCliente" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","subtipoCliente" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","tipoClasificacion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","clasificacion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","acceso" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","estadoSolicitud" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(27)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","100%" );
      ((Element)v.get(28)).setAttribute("border","0" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","524" );
      ((Element)v.get(31)).setAttribute("height","1" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(32)).setAttribute("nombre","listado1" );
      ((Element)v.get(32)).setAttribute("ancho","500" );
      ((Element)v.get(32)).setAttribute("alto","317" );
      ((Element)v.get(32)).setAttribute("x","12" );
      ((Element)v.get(32)).setAttribute("y","12" );
      ((Element)v.get(32)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(32)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(33)).setAttribute("precarga","S" );
      ((Element)v.get(33)).setAttribute("conROver","S" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(34)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(34)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(34)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(34)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 33   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(35)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(35)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(35)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(35)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(36)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(36)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:33   */

      /* Empieza nodo:37 / Elemento padre: 32   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(32)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(38)).setAttribute("borde","1" );
      ((Element)v.get(38)).setAttribute("horizDatos","1" );
      ((Element)v.get(38)).setAttribute("horizCabecera","1" );
      ((Element)v.get(38)).setAttribute("vertical","1" );
      ((Element)v.get(38)).setAttribute("horizTitulo","1" );
      ((Element)v.get(38)).setAttribute("horizBase","1" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 37   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(39)).setAttribute("borde","#999999" );
      ((Element)v.get(39)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(39)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(39)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(39)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(39)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(39)).setAttribute("horizBase","#999999" );
      ((Element)v.get(37)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 32   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(40)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(40)).setAttribute("alto","22" );
      ((Element)v.get(40)).setAttribute("imgFondo","" );
      ((Element)v.get(40)).setAttribute("cod","0027" );
      ((Element)v.get(40)).setAttribute("ID","datosTitle" );
      ((Element)v.get(32)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 32   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("BASE"));
      ((Element)v.get(41)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(41)).setAttribute("alto","22" );
      ((Element)v.get(41)).setAttribute("imgFondo","" );
      ((Element)v.get(32)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 32   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(42)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(42)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(42)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(42)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(42)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(42)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(32)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","100" );
      ((Element)v.get(43)).setAttribute("minimizable","S" );
      ((Element)v.get(43)).setAttribute("minimizada","N" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("ancho","100" );
      ((Element)v.get(44)).setAttribute("minimizable","S" );
      ((Element)v.get(44)).setAttribute("minimizada","N" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","100" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","100" );
      ((Element)v.get(46)).setAttribute("minimizable","S" );
      ((Element)v.get(46)).setAttribute("minimizada","N" );
      ((Element)v.get(42)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","100" );
      ((Element)v.get(47)).setAttribute("minimizable","S" );
      ((Element)v.get(47)).setAttribute("minimizada","N" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("ancho","150" );
      ((Element)v.get(48)).setAttribute("minimizable","S" );
      ((Element)v.get(48)).setAttribute("minimizada","N" );
      ((Element)v.get(42)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:42   */

      /* Empieza nodo:49 / Elemento padre: 32   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(49)).setAttribute("alto","20" );
      ((Element)v.get(49)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(49)).setAttribute("imgFondo","" );
      ((Element)v.get(49)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(32)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("cod","7" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("colFondo","" );
      ((Element)v.get(51)).setAttribute("ID","EstCab" );
      ((Element)v.get(51)).setAttribute("cod","10" );
      ((Element)v.get(49)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("colFondo","" );
      ((Element)v.get(52)).setAttribute("ID","EstCab" );
      ((Element)v.get(52)).setAttribute("cod","122" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("colFondo","" );
      ((Element)v.get(53)).setAttribute("ID","EstCab" );
      ((Element)v.get(53)).setAttribute("cod","424" );
      ((Element)v.get(49)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("colFondo","" );
      ((Element)v.get(54)).setAttribute("ID","EstCab" );
      ((Element)v.get(54)).setAttribute("cod","263" );
      ((Element)v.get(49)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("colFondo","" );
      ((Element)v.get(55)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).setAttribute("cod","943" );
      ((Element)v.get(49)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:49   */

      /* Empieza nodo:56 / Elemento padre: 32   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(56)).setAttribute("alto","22" );
      ((Element)v.get(56)).setAttribute("accion","" );
      ((Element)v.get(56)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(56)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(56)).setAttribute("maxSel","-1" );
      ((Element)v.get(56)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(56)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(56)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(56)).setAttribute("onLoad","" );
      ((Element)v.get(56)).setAttribute("colorSelecc","#D0D9E8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(32)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("tipo","texto" );
      ((Element)v.get(57)).setAttribute("ID","EstDat" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("tipo","texto" );
      ((Element)v.get(58)).setAttribute("ID","EstDat2" );
      ((Element)v.get(56)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("tipo","texto" );
      ((Element)v.get(59)).setAttribute("ID","EstDat" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("tipo","texto" );
      ((Element)v.get(60)).setAttribute("ID","EstDat2" );
      ((Element)v.get(56)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("tipo","texto" );
      ((Element)v.get(61)).setAttribute("ID","EstDat" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("tipo","texto" );
      ((Element)v.get(62)).setAttribute("ID","EstDat2" );
      ((Element)v.get(56)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:56   */

      /* Empieza nodo:63 / Elemento padre: 32   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(32)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(64)).setAttribute("ID","1" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(65)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(65)).setAttribute("TIPO","STRING" );
      ((Element)v.get(65)).setAttribute("VALOR","COD0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(66)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(66)).setAttribute("TIPO","STRING" );
      ((Element)v.get(66)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(67)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(67)).setAttribute("TIPO","STRING" );
      ((Element)v.get(67)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(68)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(68)).setAttribute("TIPO","STRING" );
      ((Element)v.get(68)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(69)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(69)).setAttribute("TIPO","STRING" );
      ((Element)v.get(69)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(70)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(70)).setAttribute("TIPO","STRING" );
      ((Element)v.get(70)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(71)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(71)).setAttribute("TIPO","STRING" );
      ((Element)v.get(71)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:64   */

      /* Empieza nodo:72 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(72)).setAttribute("ID","2" );
      ((Element)v.get(63)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(73)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(73)).setAttribute("TIPO","STRING" );
      ((Element)v.get(73)).setAttribute("VALOR","COD1" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(74)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(74)).setAttribute("TIPO","STRING" );
      ((Element)v.get(74)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(72)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(75)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(75)).setAttribute("TIPO","STRING" );
      ((Element)v.get(75)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(76)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(76)).setAttribute("TIPO","STRING" );
      ((Element)v.get(76)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(72)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(77)).setAttribute("NOMBRE","dato4" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(77)).setAttribute("TIPO","STRING" );
      ((Element)v.get(77)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(72)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(78)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(78)).setAttribute("TIPO","STRING" );
      ((Element)v.get(78)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(72)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(79)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(79)).setAttribute("TIPO","STRING" );
      ((Element)v.get(79)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(72)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:72   */

      /* Empieza nodo:80 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(80)).setAttribute("ID","3" );
      ((Element)v.get(63)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(81)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(81)).setAttribute("TIPO","STRING" );
      ((Element)v.get(81)).setAttribute("VALOR","COD2" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 80   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(82)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(82)).setAttribute("TIPO","STRING" );
      ((Element)v.get(82)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(80)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(83)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(83)).setAttribute("TIPO","STRING" );
      ((Element)v.get(83)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 80   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(84)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(84)).setAttribute("TIPO","STRING" );
      ((Element)v.get(84)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(80)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(85)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(85)).setAttribute("TIPO","STRING" );
      ((Element)v.get(85)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(80)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 80   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(86)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(86)).setAttribute("TIPO","STRING" );
      ((Element)v.get(86)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(80)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(87)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(87)).setAttribute("TIPO","STRING" );
      ((Element)v.get(87)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:80   */

      /* Empieza nodo:88 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(88)).setAttribute("ID","1" );
      ((Element)v.get(63)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(89)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(89)).setAttribute("TIPO","STRING" );
      ((Element)v.get(89)).setAttribute("VALOR","COD3" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(90)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(90)).setAttribute("TIPO","STRING" );
      ((Element)v.get(90)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(91)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(91)).setAttribute("TIPO","STRING" );
      ((Element)v.get(91)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(92)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(92)).setAttribute("TIPO","STRING" );
      ((Element)v.get(92)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(93)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(93)).setAttribute("TIPO","STRING" );
      ((Element)v.get(93)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(94)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(94)).setAttribute("TIPO","STRING" );
      ((Element)v.get(94)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(88)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(95)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(95)).setAttribute("TIPO","STRING" );
      ((Element)v.get(95)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(88)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:88   */

      /* Empieza nodo:96 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(96)).setAttribute("ID","2" );
      ((Element)v.get(63)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(97)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(97)).setAttribute("TIPO","STRING" );
      ((Element)v.get(97)).setAttribute("VALOR","COD4" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 96   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(98)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(98)).setAttribute("TIPO","STRING" );
      ((Element)v.get(98)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(96)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(99)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(99)).setAttribute("TIPO","STRING" );
      ((Element)v.get(99)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 96   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(100)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(100)).setAttribute("TIPO","STRING" );
      ((Element)v.get(100)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(96)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(101)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(101)).setAttribute("TIPO","STRING" );
      ((Element)v.get(101)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(96)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 96   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(102)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(102)).setAttribute("TIPO","STRING" );
      ((Element)v.get(102)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(96)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 96   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(103)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(103)).setAttribute("TIPO","STRING" );
      ((Element)v.get(103)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(96)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:96   */

      /* Empieza nodo:104 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(104)).setAttribute("ID","3" );
      ((Element)v.get(63)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(105)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(105)).setAttribute("TIPO","STRING" );
      ((Element)v.get(105)).setAttribute("VALOR","COD5" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 104   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(106)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(106)).setAttribute("TIPO","STRING" );
      ((Element)v.get(106)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(104)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(107)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(107)).setAttribute("TIPO","STRING" );
      ((Element)v.get(107)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 104   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(108)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(108)).setAttribute("TIPO","STRING" );
      ((Element)v.get(108)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(104)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(109)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(109)).setAttribute("TIPO","STRING" );
      ((Element)v.get(109)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 104   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(110)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(110)).setAttribute("TIPO","STRING" );
      ((Element)v.get(110)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(104)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(111)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(111)).setAttribute("TIPO","STRING" );
      ((Element)v.get(111)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:104   */

      /* Empieza nodo:112 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(112)).setAttribute("ID","3" );
      ((Element)v.get(63)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(113)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(113)).setAttribute("TIPO","STRING" );
      ((Element)v.get(113)).setAttribute("VALOR","COD6" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(114)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(114)).setAttribute("TIPO","STRING" );
      ((Element)v.get(114)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(112)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(115)).setAttribute("NOMBRE","dato4" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(115)).setAttribute("TIPO","STRING" );
      ((Element)v.get(115)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(116)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(116)).setAttribute("TIPO","STRING" );
      ((Element)v.get(116)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(112)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(117)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(117)).setAttribute("TIPO","STRING" );
      ((Element)v.get(117)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(112)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(118)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(118)).setAttribute("TIPO","STRING" );
      ((Element)v.get(118)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(112)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(119)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(119)).setAttribute("TIPO","STRING" );
      ((Element)v.get(119)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(112)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:112   */

      /* Empieza nodo:120 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(120)).setAttribute("ID","1" );
      ((Element)v.get(63)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(121)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(121)).setAttribute("TIPO","STRING" );
      ((Element)v.get(121)).setAttribute("VALOR","COD0" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(122)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(122)).setAttribute("TIPO","STRING" );
      ((Element)v.get(122)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(120)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(123)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(123)).setAttribute("TIPO","STRING" );
      ((Element)v.get(123)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(124)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(124)).setAttribute("TIPO","STRING" );
      ((Element)v.get(124)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(120)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(125)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(125)).setAttribute("TIPO","STRING" );
      ((Element)v.get(125)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(120)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(126)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(126)).setAttribute("TIPO","STRING" );
      ((Element)v.get(126)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(120)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(127)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(127)).setAttribute("TIPO","STRING" );
      ((Element)v.get(127)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(120)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:120   */

      /* Empieza nodo:128 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(128)).setAttribute("ID","2" );
      ((Element)v.get(63)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(129)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(129)).setAttribute("TIPO","STRING" );
      ((Element)v.get(129)).setAttribute("VALOR","COD1" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 128   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(130)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(130)).setAttribute("TIPO","STRING" );
      ((Element)v.get(130)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(128)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(131)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(131)).setAttribute("TIPO","STRING" );
      ((Element)v.get(131)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 128   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(132)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(132)).setAttribute("TIPO","STRING" );
      ((Element)v.get(132)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(128)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(133)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(133)).setAttribute("TIPO","STRING" );
      ((Element)v.get(133)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 128   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(134)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(134)).setAttribute("TIPO","STRING" );
      ((Element)v.get(134)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(128)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(135)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(135)).setAttribute("TIPO","STRING" );
      ((Element)v.get(135)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(128)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:128   */

      /* Empieza nodo:136 / Elemento padre: 63   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(136)).setAttribute("ID","3" );
      ((Element)v.get(63)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(137)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(137)).setAttribute("TIPO","STRING" );
      ((Element)v.get(137)).setAttribute("VALOR","COD2" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(138)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(138)).setAttribute("TIPO","STRING" );
      ((Element)v.get(138)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(139)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(139)).setAttribute("TIPO","STRING" );
      ((Element)v.get(139)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 136   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(140)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(140)).setAttribute("TIPO","STRING" );
      ((Element)v.get(140)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(136)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(141)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(141)).setAttribute("TIPO","STRING" );
      ((Element)v.get(141)).setAttribute("VALOR","xxxxxxx1" );
      ((Element)v.get(136)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 136   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(142)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(142)).setAttribute("TIPO","STRING" );
      ((Element)v.get(142)).setAttribute("VALOR","xxxxxxxxxxxxxx1" );
      ((Element)v.get(136)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 136   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(143)).setAttribute("TIPO","STRING" );
      ((Element)v.get(143)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(136)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:136   */
      /* Termina nodo:63   */

      /* Empieza nodo:144 / Elemento padre: 32   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(144)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(144)).setAttribute("ancho","500" );
      ((Element)v.get(144)).setAttribute("sep","$" );
      ((Element)v.get(144)).setAttribute("x","12" );
      ((Element)v.get(144)).setAttribute("class","botonera" );
      ((Element)v.get(144)).setAttribute("y","306" );
      ((Element)v.get(144)).setAttribute("control","|" );
      ((Element)v.get(144)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(144)).setAttribute("rowset","" );
      ((Element)v.get(144)).setAttribute("cargainicial","N" );
      ((Element)v.get(144)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'gestionarLista(ultima, rowset)')" );
      ((Element)v.get(32)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","ret1" );
      ((Element)v.get(145)).setAttribute("x","37" );
      ((Element)v.get(145)).setAttribute("y","310" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("img","retroceder_on" );
      ((Element)v.get(145)).setAttribute("tipo","0" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("alt","" );
      ((Element)v.get(145)).setAttribute("codigo","" );
      ((Element)v.get(145)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 144   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","ava1" );
      ((Element)v.get(146)).setAttribute("x","52" );
      ((Element)v.get(146)).setAttribute("y","310" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("img","avanzar_on" );
      ((Element)v.get(146)).setAttribute("tipo","0" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("alt","" );
      ((Element)v.get(146)).setAttribute("codigo","" );
      ((Element)v.get(146)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(144)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:144   */
      /* Termina nodo:32   */

      /* Empieza nodo:147 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","primera1" );
      ((Element)v.get(147)).setAttribute("x","20" );
      ((Element)v.get(147)).setAttribute("y","310" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("img","primera_on" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(147)).setAttribute("tipo","-2" );
      ((Element)v.get(147)).setAttribute("estado","false" );
      ((Element)v.get(147)).setAttribute("alt","" );
      ((Element)v.get(147)).setAttribute("codigo","" );
      ((Element)v.get(147)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(148)).setAttribute("nombre","separa" );
      ((Element)v.get(148)).setAttribute("x","59" );
      ((Element)v.get(148)).setAttribute("y","306" );
      ((Element)v.get(148)).setAttribute("ID","botonContenido" );
      ((Element)v.get(148)).setAttribute("img","separa_base" );
      ((Element)v.get(148)).setAttribute("tipo","0" );
      ((Element)v.get(148)).setAttribute("estado","false" );
      ((Element)v.get(148)).setAttribute("alt","" );
      ((Element)v.get(148)).setAttribute("codigo","" );
      ((Element)v.get(148)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(149)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(149)).setAttribute("alto","12" );
      ((Element)v.get(149)).setAttribute("ancho","50" );
      ((Element)v.get(149)).setAttribute("colorf","" );
      ((Element)v.get(149)).setAttribute("borde","0" );
      ((Element)v.get(149)).setAttribute("imagenf","" );
      ((Element)v.get(149)).setAttribute("repeat","" );
      ((Element)v.get(149)).setAttribute("padding","" );
      ((Element)v.get(149)).setAttribute("visibilidad","visible" );
      ((Element)v.get(149)).setAttribute("contravsb","" );
      ((Element)v.get(149)).setAttribute("x","0" );
      ((Element)v.get(149)).setAttribute("y","329" );
      ((Element)v.get(149)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:6   */


   }

}
