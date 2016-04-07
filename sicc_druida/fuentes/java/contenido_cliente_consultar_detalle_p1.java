
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cliente_consultar_detalle_p1  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cliente_consultar_detalle" );
      ((Element)v.get(0)).setAttribute("cod","0410" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Clientes detalle" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar Clientes detalle" );
      ((Element)v.get(0)).setAttribute("onload","init()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","contenido_cliente_consultar_detalle_p1.js" );
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
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(8)).setAttribute("nombre","capaFormulario1" );
      ((Element)v.get(8)).setAttribute("x","0" );
      ((Element)v.get(8)).setAttribute("y","0" );
      ((Element)v.get(8)).setAttribute("ancho","100%" );
      ((Element)v.get(8)).setAttribute("alto","100" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(9)).setAttribute("width","100%" );
      ((Element)v.get(9)).setAttribute("border","0" );
      ((Element)v.get(9)).setAttribute("cellspacing","0" );
      ((Element)v.get(9)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("width","12" );
      ((Element)v.get(11)).setAttribute("align","center" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","b.gif" );
      ((Element)v.get(12)).setAttribute("width","12" );
      ((Element)v.get(12)).setAttribute("height","12" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("width","750" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","b.gif" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).setAttribute("width","12" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("height","1" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:10   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(22)).setAttribute("class","legend" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(23)).setAttribute("nombre","lbl1TitDatosComunes" );
      ((Element)v.get(23)).setAttribute("alto","13" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("filas","1" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(23)).setAttribute("cod","00159" );
      ((Element)v.get(23)).setAttribute("id","legend" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("table"));
      ((Element)v.get(27)).setAttribute("width","708" );
      ((Element)v.get(27)).setAttribute("border","0" );
      ((Element)v.get(27)).setAttribute("align","left" );
      ((Element)v.get(27)).setAttribute("cellspacing","0" );
      ((Element)v.get(27)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("colspan","4" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","8" );
      ((Element)v.get(30)).setAttribute("height","8" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:31 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","8" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lbl1CodCliente" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","datosTitle" );
      ((Element)v.get(35)).setAttribute("cod","263" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(31)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","8" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:31   */

      /* Empieza nodo:38 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(42)).setAttribute("nombre","lbl1CodClienteActual" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("id","datosCampos" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(38)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:38   */

      /* Empieza nodo:45 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("colspan","4" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:48 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:17   */

      /* Empieza nodo:50 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("height","24" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","750" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","12" );
      ((Element)v.get(50)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("height","24" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:50   */
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:57 / Elemento padre: 3   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(57)).setAttribute("nombre","listado1" );
      ((Element)v.get(57)).setAttribute("ancho","711" );
      ((Element)v.get(57)).setAttribute("alto","317" );
      ((Element)v.get(57)).setAttribute("x","12" );
      ((Element)v.get(57)).setAttribute("y","92" );
      ((Element)v.get(57)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(57)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(3)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(58)).setAttribute("precarga","S" );
      ((Element)v.get(58)).setAttribute("conROver","S" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(59)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(59)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(59)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(59)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 58   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(60)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(60)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(60)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(60)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(58)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(61)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(61)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:58   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(63)).setAttribute("borde","1" );
      ((Element)v.get(63)).setAttribute("horizDatos","1" );
      ((Element)v.get(63)).setAttribute("horizCabecera","1" );
      ((Element)v.get(63)).setAttribute("vertical","1" );
      ((Element)v.get(63)).setAttribute("horizTitulo","1" );
      ((Element)v.get(63)).setAttribute("horizBase","1" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 62   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(64)).setAttribute("borde","#999999" );
      ((Element)v.get(64)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(64)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(64)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(64)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(64)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(64)).setAttribute("horizBase","#999999" );
      ((Element)v.get(62)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 57   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(65)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(65)).setAttribute("alto","22" );
      ((Element)v.get(65)).setAttribute("imgFondo","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("cod","0053" );
      ((Element)v.get(65)).setAttribute("ID","datosTitle" );
      ((Element)v.get(57)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 57   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(66)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(66)).setAttribute("alto","22" );
      ((Element)v.get(66)).setAttribute("imgFondo","" );
      ((Element)v.get(57)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 57   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(67)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(67)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(67)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(67)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(67)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(57)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("ancho","190" );
      ((Element)v.get(68)).setAttribute("minimizable","S" );
      ((Element)v.get(68)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("ancho","100" );
      ((Element)v.get(69)).setAttribute("minimizable","S" );
      ((Element)v.get(69)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("ancho","80" );
      ((Element)v.get(70)).setAttribute("minimizable","S" );
      ((Element)v.get(70)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 67   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("ancho","100" );
      ((Element)v.get(71)).setAttribute("minimizable","S" );
      ((Element)v.get(71)).setAttribute("minimizada","N" );
      ((Element)v.get(67)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:67   */

      /* Empieza nodo:72 / Elemento padre: 57   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(72)).setAttribute("alto","20" );
      ((Element)v.get(72)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(72)).setAttribute("imgFondo","" );
      ((Element)v.get(72)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(57)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("colFondo","" );
      ((Element)v.get(73)).setAttribute("ID","EstCab" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cod","1126" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cod","1364" );
      ((Element)v.get(72)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("colFondo","" );
      ((Element)v.get(75)).setAttribute("ID","EstCab" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cod","1073" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(76)).setAttribute("cod","1113" );
      ((Element)v.get(72)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:72   */

      /* Empieza nodo:77 / Elemento padre: 57   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(77)).setAttribute("alto","22" );
      ((Element)v.get(77)).setAttribute("accion","" );
      ((Element)v.get(77)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(77)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(77)).setAttribute("maxSel","-1" );
      ((Element)v.get(77)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(77)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(77)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(77)).setAttribute("onLoad","" );
      ((Element)v.get(77)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(57)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("tipo","texto" );
      ((Element)v.get(78)).setAttribute("ID","EstDat" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 77   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","texto" );
      ((Element)v.get(79)).setAttribute("ID","EstDat2" );
      ((Element)v.get(77)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("tipo","texto" );
      ((Element)v.get(80)).setAttribute("ID","EstDat" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 77   */
      v.add(doc.createElement("COL"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("tipo","texto" );
      ((Element)v.get(81)).setAttribute("ID","EstDat2" );
      ((Element)v.get(77)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:77   */

      /* Empieza nodo:82 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:57   */

      /* Empieza nodo:83 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(83)).setAttribute("nombre","Siguiente1" );
      ((Element)v.get(83)).setAttribute("x","71" );
      ((Element)v.get(83)).setAttribute("y","387" );
      ((Element)v.get(83)).setAttribute("ID","botonContenido" );
      ((Element)v.get(83)).setAttribute("img","" );
      ((Element)v.get(83)).setAttribute("tipo","html" );
      ((Element)v.get(83)).setAttribute("estado","false" );
      ((Element)v.get(83)).setAttribute("alt","" );
      ((Element)v.get(83)).setAttribute("cod","446" );
      ((Element)v.get(83)).setAttribute("accion","siguientePestanya();" );
      ((Element)v.get(3)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 3   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(84)).setAttribute("nombre","Anterior1" );
      ((Element)v.get(84)).setAttribute("x","13" );
      ((Element)v.get(84)).setAttribute("y","387" );
      ((Element)v.get(84)).setAttribute("ID","botonContenido" );
      ((Element)v.get(84)).setAttribute("img","" );
      ((Element)v.get(84)).setAttribute("tipo","html" );
      ((Element)v.get(84)).setAttribute("estado","false" );
      ((Element)v.get(84)).setAttribute("alt","" );
      ((Element)v.get(84)).setAttribute("cod","1649" );
      ((Element)v.get(84)).setAttribute("accion","anteriorPestanya();" );
      ((Element)v.get(3)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:3   */


   }

}
