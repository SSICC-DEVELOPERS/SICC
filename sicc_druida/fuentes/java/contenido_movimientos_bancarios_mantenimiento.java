
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_movimientos_bancarios_mantenimiento  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_movimientos_bancarios_mantenimiento" );
      ((Element)v.get(0)).setAttribute("cod","0171" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Confirmar Movimientos bancarios" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separa1Div {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_movimiento_bancario_mantenimiento.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","idioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","pais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","cu" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","numeroLote" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oid" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","fechaMovimiento" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","fechaValor" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","banco" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","cuentaCorriente" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","100%" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","424" );
      ((Element)v.get(28)).setAttribute("height","8" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(29)).setAttribute("nombre","listado1" );
      ((Element)v.get(29)).setAttribute("ancho","400" );
      ((Element)v.get(29)).setAttribute("alto","317" );
      ((Element)v.get(29)).setAttribute("x","12" );
      ((Element)v.get(29)).setAttribute("y","12" );
      ((Element)v.get(29)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(29)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));

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
      ((Element)v.get(32)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(32)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(33)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(33)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:30   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(35)).setAttribute("borde","1" );
      ((Element)v.get(35)).setAttribute("horizDatos","1" );
      ((Element)v.get(35)).setAttribute("horizCabecera","1" );
      ((Element)v.get(35)).setAttribute("vertical","1" );
      ((Element)v.get(35)).setAttribute("horizTitulo","1" );
      ((Element)v.get(35)).setAttribute("horizBase","1" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 34   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(36)).setAttribute("borde","#999999" );
      ((Element)v.get(36)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(36)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(36)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(36)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(36)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(36)).setAttribute("horizBase","#999999" );
      ((Element)v.get(34)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:34   */

      /* Empieza nodo:37 / Elemento padre: 29   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(37)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(37)).setAttribute("alto","22" );
      ((Element)v.get(37)).setAttribute("imgFondo","" );
      ((Element)v.get(37)).setAttribute("cod","00115" );
      ((Element)v.get(37)).setAttribute("ID","datosTitle" );
      ((Element)v.get(29)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 29   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(38)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(38)).setAttribute("alto","22" );
      ((Element)v.get(38)).setAttribute("imgFondo","" );
      ((Element)v.get(29)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 29   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(39)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(39)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(39)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(39)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(39)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(39)).setAttribute("botonOrdenar","S" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(29)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","150" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","150" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","150" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","150" );
      ((Element)v.get(43)).setAttribute("minimizable","S" );
      ((Element)v.get(43)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("ancho","150" );
      ((Element)v.get(44)).setAttribute("minimizable","S" );
      ((Element)v.get(44)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","150" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","150" );
      ((Element)v.get(46)).setAttribute("minimizable","S" );
      ((Element)v.get(46)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","150" );
      ((Element)v.get(47)).setAttribute("minimizable","S" );
      ((Element)v.get(47)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("ancho","150" );
      ((Element)v.get(48)).setAttribute("minimizable","S" );
      ((Element)v.get(48)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("ancho","150" );
      ((Element)v.get(49)).setAttribute("minimizable","S" );
      ((Element)v.get(49)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("ancho","150" );
      ((Element)v.get(50)).setAttribute("minimizable","S" );
      ((Element)v.get(50)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("ancho","150" );
      ((Element)v.get(51)).setAttribute("minimizable","S" );
      ((Element)v.get(51)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","200" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","150" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","150" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("ancho","150" );
      ((Element)v.get(55)).setAttribute("minimizable","S" );
      ((Element)v.get(55)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("ancho","150" );
      ((Element)v.get(56)).setAttribute("minimizable","S" );
      ((Element)v.get(56)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("ancho","100" );
      ((Element)v.get(57)).setAttribute("minimizable","S" );
      ((Element)v.get(57)).setAttribute("minimizada","N" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(39)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("ancho","150" );
      ((Element)v.get(58)).setAttribute("minimizable","S" );
      ((Element)v.get(58)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("ancho","250" );
      ((Element)v.get(59)).setAttribute("minimizable","S" );
      ((Element)v.get(59)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("ancho","150" );
      ((Element)v.get(60)).setAttribute("minimizable","S" );
      ((Element)v.get(60)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("ancho","150" );
      ((Element)v.get(61)).setAttribute("minimizable","S" );
      ((Element)v.get(61)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:39   */

      /* Empieza nodo:62 / Elemento padre: 29   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(62)).setAttribute("alto","20" );
      ((Element)v.get(62)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(62)).setAttribute("imgFondo","" );
      ((Element)v.get(62)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(62)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(29)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("cod","636" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Elemento padre:63 / Elemento actual: 64   */
      v.add(doc.createTextNode("Cuenta corriente"));
      ((Element)v.get(63)).appendChild((Text)v.get(64));

      /* Termina nodo Texto:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("cod","651" );
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Elemento padre:65 / Elemento actual: 66   */
      v.add(doc.createTextNode("Fecha movimiento"));
      ((Element)v.get(65)).appendChild((Text)v.get(66));

      /* Termina nodo Texto:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("cod","680" );
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Elemento padre:67 / Elemento actual: 68   */
      v.add(doc.createTextNode("Nº lote"));
      ((Element)v.get(67)).appendChild((Text)v.get(68));

      /* Termina nodo Texto:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("colFondo","" );
      ((Element)v.get(69)).setAttribute("ID","EstCab" );
      ((Element)v.get(69)).setAttribute("cod","634" );
      ((Element)v.get(62)).appendChild((Element)v.get(69));

      /* Elemento padre:69 / Elemento actual: 70   */
      v.add(doc.createTextNode("Consecutivo transacción"));
      ((Element)v.get(69)).appendChild((Text)v.get(70));

      /* Termina nodo Texto:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("colFondo","" );
      ((Element)v.get(71)).setAttribute("ID","EstCab" );
      ((Element)v.get(71)).setAttribute("cod","702" );
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Elemento padre:71 / Elemento actual: 72   */
      v.add(doc.createTextNode("Tipo transacción"));
      ((Element)v.get(71)).appendChild((Text)v.get(72));

      /* Termina nodo Texto:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("colFondo","" );
      ((Element)v.get(73)).setAttribute("ID","EstCab" );
      ((Element)v.get(73)).setAttribute("cod","670" );
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Elemento padre:73 / Elemento actual: 74   */
      v.add(doc.createTextNode("Importe pago"));
      ((Element)v.get(73)).appendChild((Text)v.get(74));

      /* Termina nodo Texto:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("colFondo","" );
      ((Element)v.get(75)).setAttribute("ID","EstCab" );
      ((Element)v.get(75)).setAttribute("cod","629" );
      ((Element)v.get(62)).appendChild((Element)v.get(75));

      /* Elemento padre:75 / Elemento actual: 76   */
      v.add(doc.createTextNode("Cód. consultora real"));
      ((Element)v.get(75)).appendChild((Text)v.get(76));

      /* Termina nodo Texto:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("colFondo","" );
      ((Element)v.get(77)).setAttribute("ID","EstCab" );
      ((Element)v.get(77)).setAttribute("cod","628" );
      ((Element)v.get(62)).appendChild((Element)v.get(77));

      /* Elemento padre:77 / Elemento actual: 78   */
      v.add(doc.createTextNode("Cód. consultora"));
      ((Element)v.get(77)).appendChild((Text)v.get(78));

      /* Termina nodo Texto:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("colFondo","" );
      ((Element)v.get(79)).setAttribute("ID","EstCab" );
      ((Element)v.get(79)).setAttribute("cod","678" );
      ((Element)v.get(62)).appendChild((Element)v.get(79));

      /* Elemento padre:79 / Elemento actual: 80   */
      v.add(doc.createTextNode("Nº factura"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(79)).appendChild((Text)v.get(80));

      /* Termina nodo Texto:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("colFondo","" );
      ((Element)v.get(81)).setAttribute("ID","EstCab" );
      ((Element)v.get(81)).setAttribute("cod","1193" );
      ((Element)v.get(62)).appendChild((Element)v.get(81));

      /* Elemento padre:81 / Elemento actual: 82   */
      v.add(doc.createTextNode("Dígito chequeo"));
      ((Element)v.get(81)).appendChild((Text)v.get(82));

      /* Termina nodo Texto:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("colFondo","" );
      ((Element)v.get(83)).setAttribute("ID","EstCab" );
      ((Element)v.get(83)).setAttribute("cod","675" );
      ((Element)v.get(62)).appendChild((Element)v.get(83));

      /* Elemento padre:83 / Elemento actual: 84   */
      v.add(doc.createTextNode("Nº cupón"));
      ((Element)v.get(83)).appendChild((Text)v.get(84));

      /* Termina nodo Texto:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("colFondo","" );
      ((Element)v.get(85)).setAttribute("ID","EstCab" );
      ((Element)v.get(85)).setAttribute("cod","677" );
      ((Element)v.get(62)).appendChild((Element)v.get(85));

      /* Elemento padre:85 / Elemento actual: 86   */
      v.add(doc.createTextNode("Nº doc pago"));
      ((Element)v.get(85)).appendChild((Text)v.get(86));

      /* Termina nodo Texto:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("colFondo","" );
      ((Element)v.get(87)).setAttribute("ID","EstCab" );
      ((Element)v.get(87)).setAttribute("cod","688" );
      ((Element)v.get(62)).appendChild((Element)v.get(87));

      /* Elemento padre:87 / Elemento actual: 88   */
      v.add(doc.createTextNode("Oficina recaudadora"));
      ((Element)v.get(87)).appendChild((Text)v.get(88));

      /* Termina nodo Texto:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("colFondo","" );
      ((Element)v.get(89)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).setAttribute("cod","687" );
      ((Element)v.get(62)).appendChild((Element)v.get(89));

      /* Elemento padre:89 / Elemento actual: 90   */
      v.add(doc.createTextNode("Nombre oficina"));
      ((Element)v.get(89)).appendChild((Text)v.get(90));

      /* Termina nodo Texto:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("colFondo","" );
      ((Element)v.get(91)).setAttribute("ID","EstCab" );
      ((Element)v.get(91)).setAttribute("cod","662" );
      ((Element)v.get(62)).appendChild((Element)v.get(91));

      /* Elemento padre:91 / Elemento actual: 92   */
      v.add(doc.createTextNode("Horario"));
      ((Element)v.get(91)).appendChild((Text)v.get(92));

      /* Termina nodo Texto:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("colFondo","" );
      ((Element)v.get(93)).setAttribute("ID","EstCab" );
      ((Element)v.get(93)).setAttribute("cod","704" );
      ((Element)v.get(62)).appendChild((Element)v.get(93));

      /* Elemento padre:93 / Elemento actual: 94   */
      v.add(doc.createTextNode("Usuario proceso"));
      ((Element)v.get(93)).appendChild((Text)v.get(94));

      /* Termina nodo Texto:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("colFondo","" );
      ((Element)v.get(95)).setAttribute("ID","EstCab" );
      ((Element)v.get(95)).setAttribute("cod","655" );
      ((Element)v.get(62)).appendChild((Element)v.get(95));

      /* Elemento padre:95 / Elemento actual: 96   */
      v.add(doc.createTextNode("Fecha proceso"));
      ((Element)v.get(95)).appendChild((Text)v.get(96));

      /* Termina nodo Texto:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("colFondo","" );
      ((Element)v.get(97)).setAttribute("ID","EstCab" );
      ((Element)v.get(97)).setAttribute("cod","661" );
      ((Element)v.get(62)).appendChild((Element)v.get(97));

      /* Elemento padre:97 / Elemento actual: 98   */
      v.add(doc.createTextNode("Hora proceso"));
      ((Element)v.get(97)).appendChild((Text)v.get(98));

      /* Termina nodo Texto:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("colFondo","" );
      ((Element)v.get(99)).setAttribute("ID","EstCab" );
      ((Element)v.get(99)).setAttribute("cod","630" );
      ((Element)v.get(62)).appendChild((Element)v.get(99));

      /* Elemento padre:99 / Elemento actual: 100   */
      v.add(doc.createTextNode("Cód. error"));
      ((Element)v.get(99)).appendChild((Text)v.get(100));

      /* Termina nodo Texto:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","644" );
      ((Element)v.get(62)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Estatus movimiento tesorería"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","663" );
      ((Element)v.get(62)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("Identificador proceso"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","169" );
      ((Element)v.get(62)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createTextNode("Observaciones"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */
      /* Termina nodo:62   */

      /* Empieza nodo:107 / Elemento padre: 29   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(107)).setAttribute("alto","22" );
      ((Element)v.get(107)).setAttribute("accion","" );
      ((Element)v.get(107)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(107)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(107)).setAttribute("maxSel","-1" );
      ((Element)v.get(107)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(107)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(107)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(107)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(29)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("tipo","texto" );
      ((Element)v.get(108)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("tipo","texto" );
      ((Element)v.get(109)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("tipo","texto" );
      ((Element)v.get(110)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("tipo","texto" );
      ((Element)v.get(111)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("tipo","texto" );
      ((Element)v.get(112)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("tipo","texto" );
      ((Element)v.get(113)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("tipo","texto" );
      ((Element)v.get(114)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("tipo","texto" );
      ((Element)v.get(118)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("tipo","texto" );
      ((Element)v.get(119)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("tipo","texto" );
      ((Element)v.get(120)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("tipo","texto" );
      ((Element)v.get(121)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:107   */

      /* Empieza nodo:130 / Elemento padre: 29   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(29)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 29   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(131)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(131)).setAttribute("ancho","400" );
      ((Element)v.get(131)).setAttribute("sep","$" );
      ((Element)v.get(131)).setAttribute("x","12" );
      ((Element)v.get(131)).setAttribute("class","botonera" );
      ((Element)v.get(131)).setAttribute("y","306" );
      ((Element)v.get(131)).setAttribute("control","|" );
      ((Element)v.get(131)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(131)).setAttribute("rowset","" );
      ((Element)v.get(131)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(131)).setAttribute("cargainicial","N" );
      ((Element)v.get(29)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(132)).setAttribute("nombre","ret1" );
      ((Element)v.get(132)).setAttribute("x","37" );
      ((Element)v.get(132)).setAttribute("y","310" );
      ((Element)v.get(132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(132)).setAttribute("img","retroceder_on" );
      ((Element)v.get(132)).setAttribute("tipo","0" );
      ((Element)v.get(132)).setAttribute("estado","false" );
      ((Element)v.get(132)).setAttribute("alt","" );
      ((Element)v.get(132)).setAttribute("codigo","" );
      ((Element)v.get(132)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 131   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(133)).setAttribute("nombre","ava1" );
      ((Element)v.get(133)).setAttribute("x","52" );
      ((Element)v.get(133)).setAttribute("y","310" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("img","avanzar_on" );
      ((Element)v.get(133)).setAttribute("tipo","0" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("alt","" );
      ((Element)v.get(133)).setAttribute("codigo","" );
      ((Element)v.get(133)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(131)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:131   */
      /* Termina nodo:29   */

      /* Empieza nodo:134 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","primera1" );
      ((Element)v.get(134)).setAttribute("x","20" );
      ((Element)v.get(134)).setAttribute("y","310" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
      ((Element)v.get(134)).setAttribute("img","primera_on" );
      ((Element)v.get(134)).setAttribute("tipo","-2" );
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("alt","" );
      ((Element)v.get(134)).setAttribute("codigo","" );
      ((Element)v.get(134)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","separa1" );
      ((Element)v.get(135)).setAttribute("x","59" );
      ((Element)v.get(135)).setAttribute("y","306" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("img","separa_base" );
      ((Element)v.get(135)).setAttribute("tipo","0" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("alt","" );
      ((Element)v.get(135)).setAttribute("codigo","" );
      ((Element)v.get(135)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(136)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(136)).setAttribute("alto","12" );
      ((Element)v.get(136)).setAttribute("ancho","100%" );
      ((Element)v.get(136)).setAttribute("colorf","" );
      ((Element)v.get(136)).setAttribute("borde","0" );
      ((Element)v.get(136)).setAttribute("imagenf","" );
      ((Element)v.get(136)).setAttribute("repeat","" );
      ((Element)v.get(136)).setAttribute("padding","" );
      ((Element)v.get(136)).setAttribute("visibilidad","visible" );
      ((Element)v.get(136)).setAttribute("contravsb","" );
      ((Element)v.get(136)).setAttribute("x","0" );
      ((Element)v.get(136)).setAttribute("y","329" );
      ((Element)v.get(136)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:8   */


   }

}
