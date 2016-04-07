
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_resultados_chequeos_introducir_2  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_resultados_chequeos_introducir_2" );
      ((Element)v.get(0)).setAttribute("cod","0145" );
      ((Element)v.get(0)).setAttribute("titulo","Introducir Resultados de Chequeos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Introducir Resultados de Chequeos" );
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
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_resultados_chequeos_introducir_2.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
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
      ((Element)v.get(14)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidSolicitud" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(16)).setAttribute("x","0" );
      ((Element)v.get(16)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","100%" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","569" );
      ((Element)v.get(20)).setAttribute("height","8" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(21)).setAttribute("nombre","listado1" );
      ((Element)v.get(21)).setAttribute("ancho","545" );
      ((Element)v.get(21)).setAttribute("alto","299" );
      ((Element)v.get(21)).setAttribute("x","12" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("y","12" );
      ((Element)v.get(21)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(21)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(22)).setAttribute("precarga","S" );
      ((Element)v.get(22)).setAttribute("conROver","S" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(23)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(23)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(23)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(23)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 22   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(24)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(24)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(24)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(24)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(25)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(25)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:22   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(27)).setAttribute("borde","1" );
      ((Element)v.get(27)).setAttribute("horizDatos","1" );
      ((Element)v.get(27)).setAttribute("horizCabecera","1" );
      ((Element)v.get(27)).setAttribute("vertical","1" );
      ((Element)v.get(27)).setAttribute("horizTitulo","1" );
      ((Element)v.get(27)).setAttribute("horizBase","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 26   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(28)).setAttribute("borde","#999999" );
      ((Element)v.get(28)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(28)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(28)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(28)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(28)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(28)).setAttribute("horizBase","#999999" );
      ((Element)v.get(26)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:26   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(29)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(29)).setAttribute("alto","22" );
      ((Element)v.get(29)).setAttribute("imgFondo","" );
      ((Element)v.get(29)).setAttribute("cod","00133" );
      ((Element)v.get(29)).setAttribute("ID","datosTitle" );
      ((Element)v.get(21)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 21   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(30)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(30)).setAttribute("alto","22" );
      ((Element)v.get(30)).setAttribute("imgFondo","" );
      ((Element)v.get(21)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 21   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(31)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(31)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(31)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(31)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(31)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(31)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(21)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","80" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 31   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","150" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(31)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","50" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:31   */

      /* Empieza nodo:35 / Elemento padre: 21   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(35)).setAttribute("alto","20" );
      ((Element)v.get(35)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(35)).setAttribute("imgFondo","" );
      ((Element)v.get(35)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(21)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("colFondo","" );
      ((Element)v.get(36)).setAttribute("ID","EstCab" );
      ((Element)v.get(36)).setAttribute("cod","336" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("colFondo","" );
      ((Element)v.get(37)).setAttribute("ID","EstCab" );
      ((Element)v.get(37)).setAttribute("cod","9" );
      ((Element)v.get(35)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("colFondo","" );
      ((Element)v.get(38)).setAttribute("ID","EstCab" );
      ((Element)v.get(38)).setAttribute("cod","495" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:35   */

      /* Empieza nodo:39 / Elemento padre: 21   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(39)).setAttribute("alto","22" );
      ((Element)v.get(39)).setAttribute("accion","" );
      ((Element)v.get(39)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(39)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(39)).setAttribute("maxSel","-1" );
      ((Element)v.get(39)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(39)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(39)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(39)).setAttribute("onLoad","" );
      ((Element)v.get(39)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(21)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("tipo","texto" );
      ((Element)v.get(40)).setAttribute("ID","EstDat" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("tipo","texto" );
      ((Element)v.get(41)).setAttribute("ID","EstDat2" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("tipo","texto" );
      ((Element)v.get(42)).setAttribute("ID","EstDat" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:39   */

      /* Empieza nodo:43 / Elemento padre: 21   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(21)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(44)).setAttribute("ID","1" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(45)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(45)).setAttribute("TIPO","STRING" );
      ((Element)v.get(45)).setAttribute("VALOR","COD0" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 44   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(46)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(46)).setAttribute("TIPO","STRING" );
      ((Element)v.get(46)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(44)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(47)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(47)).setAttribute("TIPO","STRING" );
      ((Element)v.get(47)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(48)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(48)).setAttribute("TIPO","STRING" );
      ((Element)v.get(48)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(44)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:44   */

      /* Empieza nodo:49 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(49)).setAttribute("ID","2" );
      ((Element)v.get(43)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(50)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(50)).setAttribute("TIPO","STRING" );
      ((Element)v.get(50)).setAttribute("VALOR","COD1" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(51)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(51)).setAttribute("TIPO","STRING" );
      ((Element)v.get(51)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(49)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(52)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(52)).setAttribute("TIPO","STRING" );
      ((Element)v.get(52)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(53)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(53)).setAttribute("TIPO","STRING" );
      ((Element)v.get(53)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(49)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:49   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(54)).setAttribute("ID","3" );
      ((Element)v.get(43)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(55)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(55)).setAttribute("TIPO","STRING" );
      ((Element)v.get(55)).setAttribute("VALOR","COD2" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 54   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(56)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(56)).setAttribute("TIPO","STRING" );
      ((Element)v.get(56)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(54)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(57)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(57)).setAttribute("TIPO","STRING" );
      ((Element)v.get(57)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 54   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(58)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(58)).setAttribute("TIPO","STRING" );
      ((Element)v.get(58)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(54)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:54   */

      /* Empieza nodo:59 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(59)).setAttribute("ID","1" );
      ((Element)v.get(43)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(60)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(60)).setAttribute("TIPO","STRING" );
      ((Element)v.get(60)).setAttribute("VALOR","COD3" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(61)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(61)).setAttribute("TIPO","STRING" );
      ((Element)v.get(61)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(62)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(62)).setAttribute("TIPO","STRING" );
      ((Element)v.get(62)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(63)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(63)).setAttribute("TIPO","STRING" );
      ((Element)v.get(63)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(59)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:59   */

      /* Empieza nodo:64 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(64)).setAttribute("ID","2" );
      ((Element)v.get(43)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(65)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(65)).setAttribute("TIPO","STRING" );
      ((Element)v.get(65)).setAttribute("VALOR","COD4" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(66)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(66)).setAttribute("TIPO","STRING" );
      ((Element)v.get(66)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(67)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(67)).setAttribute("TIPO","STRING" );
      ((Element)v.get(67)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(68)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(68)).setAttribute("TIPO","STRING" );
      ((Element)v.get(68)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(64)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:64   */

      /* Empieza nodo:69 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(69)).setAttribute("ID","3" );
      ((Element)v.get(43)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(70)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(70)).setAttribute("TIPO","STRING" );
      ((Element)v.get(70)).setAttribute("VALOR","COD5" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 69   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(71)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(71)).setAttribute("TIPO","STRING" );
      ((Element)v.get(71)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(69)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(72)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(72)).setAttribute("TIPO","STRING" );
      ((Element)v.get(72)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 69   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(73)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(73)).setAttribute("TIPO","STRING" );
      ((Element)v.get(73)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(69)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:69   */

      /* Empieza nodo:74 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(74)).setAttribute("ID","3" );
      ((Element)v.get(43)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(75)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(75)).setAttribute("TIPO","STRING" );
      ((Element)v.get(75)).setAttribute("VALOR","COD6" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 74   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(76)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(76)).setAttribute("TIPO","STRING" );
      ((Element)v.get(76)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(74)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(77)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(77)).setAttribute("TIPO","STRING" );
      ((Element)v.get(77)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 74   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(78)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(78)).setAttribute("TIPO","STRING" );
      ((Element)v.get(78)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(74)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:74   */

      /* Empieza nodo:79 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(79)).setAttribute("ID","1" );
      ((Element)v.get(43)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(80)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(80)).setAttribute("TIPO","STRING" );
      ((Element)v.get(80)).setAttribute("VALOR","COD0" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 79   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(81)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(81)).setAttribute("TIPO","STRING" );
      ((Element)v.get(81)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(79)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(82)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(82)).setAttribute("TIPO","STRING" );
      ((Element)v.get(82)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(79)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 79   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(83)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(83)).setAttribute("TIPO","STRING" );
      ((Element)v.get(83)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(79)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:79   */

      /* Empieza nodo:84 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(84)).setAttribute("ID","2" );
      ((Element)v.get(43)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(85)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(85)).setAttribute("TIPO","STRING" );
      ((Element)v.get(85)).setAttribute("VALOR","COD1" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 84   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(86)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(86)).setAttribute("TIPO","STRING" );
      ((Element)v.get(86)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(84)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(87)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(87)).setAttribute("TIPO","STRING" );
      ((Element)v.get(87)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 84   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(88)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(88)).setAttribute("TIPO","STRING" );
      ((Element)v.get(88)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(84)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:84   */

      /* Empieza nodo:89 / Elemento padre: 43   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(89)).setAttribute("ID","3" );
      ((Element)v.get(43)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(90)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(90)).setAttribute("TIPO","STRING" );
      ((Element)v.get(90)).setAttribute("VALOR","COD2" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(91)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(91)).setAttribute("TIPO","STRING" );
      ((Element)v.get(91)).setAttribute("VALOR","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(92)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(92)).setAttribute("TIPO","STRING" );
      ((Element)v.get(92)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(93)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(93)).setAttribute("TIPO","STRING" );
      ((Element)v.get(93)).setAttribute("VALOR","xxx1" );
      ((Element)v.get(89)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:89   */
      /* Termina nodo:43   */

      /* Empieza nodo:94 / Elemento padre: 21   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(94)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(94)).setAttribute("ancho","545" );
      ((Element)v.get(94)).setAttribute("sep","$" );
      ((Element)v.get(94)).setAttribute("x","12" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(94)).setAttribute("class","botonera" );
      ((Element)v.get(94)).setAttribute("y","288" );
      ((Element)v.get(94)).setAttribute("control","|" );
      ((Element)v.get(94)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(94)).setAttribute("rowset","" );
      ((Element)v.get(94)).setAttribute("cargainicial","N" );
      ((Element)v.get(94)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(21)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(95)).setAttribute("nombre","ret1" );
      ((Element)v.get(95)).setAttribute("x","37" );
      ((Element)v.get(95)).setAttribute("y","292" );
      ((Element)v.get(95)).setAttribute("ID","botonContenido" );
      ((Element)v.get(95)).setAttribute("img","retroceder_on" );
      ((Element)v.get(95)).setAttribute("tipo","0" );
      ((Element)v.get(95)).setAttribute("estado","false" );
      ((Element)v.get(95)).setAttribute("alt","" );
      ((Element)v.get(95)).setAttribute("codigo","" );
      ((Element)v.get(95)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 94   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(96)).setAttribute("nombre","ava1" );
      ((Element)v.get(96)).setAttribute("x","52" );
      ((Element)v.get(96)).setAttribute("y","292" );
      ((Element)v.get(96)).setAttribute("ID","botonContenido" );
      ((Element)v.get(96)).setAttribute("img","avanzar_on" );
      ((Element)v.get(96)).setAttribute("tipo","0" );
      ((Element)v.get(96)).setAttribute("estado","false" );
      ((Element)v.get(96)).setAttribute("alt","" );
      ((Element)v.get(96)).setAttribute("codigo","" );
      ((Element)v.get(96)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(94)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:94   */
      /* Termina nodo:21   */

      /* Empieza nodo:97 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(97)).setAttribute("nombre","primera1" );
      ((Element)v.get(97)).setAttribute("x","20" );
      ((Element)v.get(97)).setAttribute("y","292" );
      ((Element)v.get(97)).setAttribute("ID","botonContenido" );
      ((Element)v.get(97)).setAttribute("img","primera_on" );
      ((Element)v.get(97)).setAttribute("tipo","0" );
      ((Element)v.get(97)).setAttribute("estado","false" );
      ((Element)v.get(97)).setAttribute("alt","" );
      ((Element)v.get(97)).setAttribute("codigo","" );
      ((Element)v.get(97)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(98)).setAttribute("nombre","separa" );
      ((Element)v.get(98)).setAttribute("x","59" );
      ((Element)v.get(98)).setAttribute("y","288" );
      ((Element)v.get(98)).setAttribute("ID","botonContenido" );
      ((Element)v.get(98)).setAttribute("img","separa_base" );
      ((Element)v.get(98)).setAttribute("tipo","0" );
      ((Element)v.get(98)).setAttribute("estado","false" );
      ((Element)v.get(98)).setAttribute("alt","" );
      ((Element)v.get(98)).setAttribute("codigo","" );
      ((Element)v.get(98)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(99)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(99)).setAttribute("alto","12" );
      ((Element)v.get(99)).setAttribute("ancho","50" );
      ((Element)v.get(99)).setAttribute("colorf","" );
      ((Element)v.get(99)).setAttribute("borde","0" );
      ((Element)v.get(99)).setAttribute("imagenf","" );
      ((Element)v.get(99)).setAttribute("repeat","" );
      ((Element)v.get(99)).setAttribute("padding","" );
      ((Element)v.get(99)).setAttribute("visibilidad","visible" );
      ((Element)v.get(99)).setAttribute("contravsb","" );
      ((Element)v.get(99)).setAttribute("x","0" );
      ((Element)v.get(99)).setAttribute("y","311" );
      ((Element)v.get(99)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:6   */


   }

}
